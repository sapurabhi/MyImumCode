package com.imum.cpms.transactions;


import com.imum.cpms.model.masters.vo.PVTCourtReportUVORowImpl;
import com.imum.cpms.model.transactions.vo.ClampingUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import com.imum.ws.Clamping.ClampingApprovalBPMProcessPortType;
import com.imum.ws.Clamping.ClampingApprovalBPMProcessService;

import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessService;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import javax.xml.ws.WebServiceRef;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class ClampingMbean {
    BigDecimal PvthdrSeqBD = null;
    private String pvtnumber;
    private String currentstatus;
    private int en; 
    private String Remarksforclamping;
    private Integer selPos;
    private RichSelectOneChoice newstatus;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    MessageUtil genMsg = new MessageUtil();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
    private RichInputText remarks;
   String userName = httpSession.getAttribute("loggedinUserid").toString();
    //String userName="imum";
    private RichTable selectedtable;
    private RichPopup pvtamtpayablepopup;


    public ClampingMbean() {
    }
    @WebServiceRef
    private static ClampingApprovalBPMProcessService clampingApprovalBPMProcessService;
    public void SelectedRow(SelectionEvent selectionEvent) {
        // Add event code here...
        try
        {
            ADFUtil.invokeEL("#{bindings.ClampingUVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.ClampingUVO1Iterator.currentRow}"); // get the current selected row
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Selected");
                if(selectedRow != null)
                {
                    Object PVTHDRSEQ = selectedRow.getAttribute("PVTHDRSEQ");
                    Object pvtNumber = selectedRow.getAttribute("PVTNum");
                    Object currentStatus = selectedRow.getAttribute("PVTStatusID");
                    Object enfors = selectedRow.getAttribute("ENFORCESTAGEID");
                   
                    if(PVTHDRSEQ != null) 
                    {
                         PvthdrSeqBD = new BigDecimal(PVTHDRSEQ.toString());
                         pvtnumber=pvtNumber.toString();
                         currentstatus=currentStatus.toString();
                         en=Integer.parseInt(enfors.toString());
                        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("ClampenforcementRVO1Iterator");
                        ViewObject appVO = dcItteratorBinding.getViewObject(); 
                        if(en==26)
                        appVO.setWhereClause("ENFORCE_STAGE_ID in (18,27)");
                      if(en==18)
                      appVO.setWhereClause("ENFORCE_STAGE_ID in (29,30,31)");
                      if(en==33)
                      appVO.setWhereClause("ENFORCE_STAGE_ID in (34,35)");
                      if(en==34)
                      appVO.setWhereClause("ENFORCE_STAGE_ID in (37)");
                      if(en==30)
                      appVO.setWhereClause("ENFORCE_STAGE_ID in (32)");
                      if(en==37)
                      {
                      appVO.setWhereClause("ENFORCE_STAGE_ID in (37)");
                      }
                     appVO.executeQuery();
                  }
                }
                }
        catch (Exception e) {
                    System.out.println("Error occurred..." + e.toString());
                                            }
        }

    public String Submit() {
        int vehno=0;
        String result = validateDataOnSubmit();
        if(result.equals("pass")){
        
            Timestamp sqlDate =new java.sql.Timestamp(new java.util.Date().getTime());
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        Integer selectedPosIndex=0;
//                Integer i;
//                if(newstatus.getValue()!=null) {
//                    selectedPosIndex = Integer.parseInt(newstatus.getValue().toString());
//                }
//                  String selectedPos = null;
//                if (selectedPosIndex != null )
//                {
//                    //Passing the LOV Iterator object and getting the list
//                    JUCtrlListBinding list =(JUCtrlListBinding)bindings.get("ClampenforcementRVO1");
//                    //Passing the selected Value index and getting the Row object
//                    Row row =list.getRowIterator().getRowAtRangeIndex(selectedPosIndex);
//                    selectedPos = row.getAttribute("ENFORCESTAGEID").toString();
//                     selPos =Integer.parseInt(selectedPos.toString());
//                    }
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("ClampingUVO1Iterator");
        ViewObjectImpl VO =(ViewObjectImpl)dcIteratorBinding.getViewObject();
        ClampingUVORowImpl Row = (ClampingUVORowImpl)VO.getCurrentRow();
        if(Row!=null){
        Row.setENFORCESTAGEID(selPos);
        Row.setUpdatedby(userName);
        Row.setUpdateddate(sqlDate);
        if(selPos == 32) {
                    BigDecimal val=new BigDecimal(0);
                     val=Row.getPVTAMTPAYABLE();
                     int i = val.intValue();
                     System.out.println("Payable amount is::::"+i);
                     if(i!=0){
               Row.setENFORCESTAGEID(30);
               OperationBinding opcommit1 = getBindings().getOperationBinding("doCommit");
               opcommit1.execute();
               RichPopup.PopupHints ph=new RichPopup.PopupHints();
               this.getPvtamtpayablepopup().show(ph);
               return null;
                     }
        }

        
        
      OperationBinding operation1 =getBindings().getOperationBinding("clampingEvents");
            operation1.getParamsMap().put("pvtHeaderSeq", PvthdrSeqBD);
            operation1.getParamsMap().put("loggerName", userName);
            operation1.getParamsMap().put("remarks", Remarksforclamping);
            if (selPos == 26)
                operation1.getParamsMap().put("EventId", "756");
            if (selPos == 18)
                operation1.getParamsMap().put("EventId", "757");
            if (selPos == 27)
                operation1.getParamsMap().put("EventId", "758");
            if (selPos == 28)
                operation1.getParamsMap().put("EventId", "759");
            if (selPos == 29)
                operation1.getParamsMap().put("EventId", "760");
            if (selPos == 30)
                operation1.getParamsMap().put("EventId", "761");
            if (selPos == 31)
                operation1.getParamsMap().put("EventId", "762");
            if (selPos == 32)
            operation1.getParamsMap().put("EventId", "763");
            if (selPos == 33)
                operation1.getParamsMap().put("EventId", "763");
            if (selPos == 34)
                operation1.getParamsMap().put("EventId", "764");
            if (selPos == 35)
                operation1.getParamsMap().put("EventId", "765");
            if (selPos == 36)
                operation1.getParamsMap().put("EventId", "766");
            if (selPos == 37)
                operation1.getParamsMap().put("EventId", "767");
                operation1.execute();
            
        if(selPos == 18) {
            DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
            DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("PvtEnforceVhclAssignVO1Iterator");
            ViewObjectImpl assignVO =(ViewObjectImpl)dcItteratorBindings.getViewObject();
            //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
            assignVO.setWhereClauseParams(null);
            assignVO.setWhereClause("REQUEST_STATUS=6 and PVT_HDR_SEQ='"+PvthdrSeqBD+"'");
            assignVO.executeQuery();
            Row assrow = assignVO.first();
            if(assrow!=null) {
                assrow.setAttribute("REQUESTSTATUS",7);
            }
            
//             RowQualifier rowQualifier = new RowQualifier(assignVO);
//             rowQualifier.setWhereClause("PVTHDRSEQ="+PvthdrSeqBD+" AND REQUESTSTATUS=6");
//           Row filteredRows = assignVO.first();
//             if(filteredRows!=null) {
//                System.out.println(filteredRows.getAttribute("ENFORCEVHCLID"));
//                 vehno=Integer.parseInt(filteredRows.getAttribute("ENFORCEVHCLID").toString());
//             }
//            if(vehno!=0)
//            {
//            DCIteratorBinding dcItteratorBinding =bindings1.findIteratorBinding("PvtEnforceVhclMstVO1Iterator");
//            ViewObject enforcmstVO = dcItteratorBinding.getViewObject();
//            enforcmstVO.setWhereClause(null);
//            enforcmstVO.setWhereClauseParams(null);
//              //  VHCL_TYPE= 'C' and
//            enforcmstVO.setWhereClause("VHCL_ASSIGN_STATUS=1 and ENFORCE_VHCL_ID='"+vehno+"'");
//            enforcmstVO.executeQuery();
//            
//            Row selectedRow=enforcmstVO.first();
//            if(selectedRow!=null)
//            selectedRow.setAttribute("VHCLASSIGNSTATUS",2);
            //Object ob=selectedRow.getAttribute("ENFORCEVHCLID");
            //Object closecourt=selectedRow.getAttribute("CasestatusID");
         //   }
        }
        if(selPos == 27) {
            DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
            DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("PvtEnforceVhclAssignVO1Iterator");
            ViewObjectImpl assignVO =(ViewObjectImpl)dcItteratorBindings.getViewObject();
            //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
            assignVO.setWhereClauseParams(null);
            assignVO.setWhereClause("REQUEST_STATUS=6 and PVT_HDR_SEQ='"+PvthdrSeqBD+"'");
            assignVO.executeQuery();
            Row assrow = assignVO.first();
            if(assrow!=null) {
                assrow.setAttribute("REQUESTSTATUS",8);
            }
            
            //             RowQualifier rowQualifier = new RowQualifier(assignVO);
            //             rowQualifier.setWhereClause("PVTHDRSEQ="+PvthdrSeqBD+" AND REQUESTSTATUS=6");
            Row filteredRows = assignVO.first();
             if(filteredRows!=null) {
                System.out.println(filteredRows.getAttribute("ENFORCEVHCLID"));
                 vehno=Integer.parseInt(filteredRows.getAttribute("ENFORCEVHCLID").toString());
             }
            if(vehno!=0)
            {
            DCIteratorBinding dcItteratorBinding =bindings1.findIteratorBinding("PvtEnforceVhclMstVO1Iterator");
            ViewObject enforcmstVO = dcItteratorBinding.getViewObject();
            enforcmstVO.setWhereClause(null);
            enforcmstVO.setWhereClauseParams(null);
              //  VHCL_TYPE= 'C' and VHCL_ASSIGN_STATUS=2 and
            enforcmstVO.setWhereClause("ENFORCE_VHCL_ID='"+vehno+"'");
            enforcmstVO.executeQuery();
            
            Row selectedRow=enforcmstVO.first();
            if(selectedRow!=null)
            selectedRow.setAttribute("VHCLASSIGNSTATUS",1);
            //Object ob=selectedRow.getAttribute("ENFORCEVHCLID");
            //Object closecourt=selectedRow.getAttribute("CasestatusID");
            }
            
        }
        if(selPos == 34) {
            DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
            DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("PvtEnforceVhclAssignVO1Iterator");
            ViewObjectImpl assignVO =(ViewObjectImpl)dcItteratorBindings.getViewObject();
            //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
            assignVO.setWhereClauseParams(null);
            assignVO.setWhereClause("REQUEST_STATUS=9 and PVT_HDR_SEQ='"+PvthdrSeqBD+"'");
            assignVO.executeQuery();
            Row assrow = assignVO.first();
            if(assrow!=null) {
                assrow.setAttribute("REQUESTSTATUS",10);
            }
            
            //             RowQualifier rowQualifier = new RowQualifier(assignVO);
            //             rowQualifier.setWhereClause("PVTHDRSEQ="+PvthdrSeqBD+" AND REQUESTSTATUS=6");
//            Row filteredRows = assignVO.first();
//             if(filteredRows!=null) {
//                System.out.println(filteredRows.getAttribute("ENFORCEVHCLID"));
//                 vehno=Integer.parseInt(filteredRows.getAttribute("ENFORCEVHCLID").toString());
//             }
//            if(vehno!=0)
//            {
//            DCIteratorBinding dcItteratorBinding =bindings1.findIteratorBinding("PvtEnforceVhclMstVO1Iterator");
//            ViewObject enforcmstVO = dcItteratorBinding.getViewObject();
//            enforcmstVO.setWhereClause(null);
//            enforcmstVO.setWhereClauseParams(null);
//              //  VHCL_TYPE= 'C' and
//            enforcmstVO.setWhereClause("VHCL_ASSIGN_STATUS=1 and ENFORCE_VHCL_ID='"+vehno+"'");
//            enforcmstVO.executeQuery();
//            
//            Row selectedRow=enforcmstVO.first();
//            if(selectedRow!=null)
//            selectedRow.setAttribute("VHCLASSIGNSTATUS",2);
            //Object ob=selectedRow.getAttribute("ENFORCEVHCLID");
            //Object closecourt=selectedRow.getAttribute("CasestatusID");
         //   }
            
        }
        if(selPos == 35) {
            DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
            DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("PvtEnforceVhclAssignVO1Iterator");
            ViewObjectImpl assignVO =(ViewObjectImpl)dcItteratorBindings.getViewObject();
            //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
            assignVO.setWhereClauseParams(null);
            assignVO.setWhereClause("REQUEST_STATUS=9 and PVT_HDR_SEQ='"+PvthdrSeqBD+"'");
            assignVO.executeQuery();
            Row assrow = assignVO.first();
            if(assrow!=null) {
                assrow.setAttribute("REQUESTSTATUS",11);
            }
            
            //             RowQualifier rowQualifier = new RowQualifier(assignVO);
            //             rowQualifier.setWhereClause("PVTHDRSEQ="+PvthdrSeqBD+" AND REQUESTSTATUS=6");
            Row filteredRows = assignVO.first();
             if(filteredRows!=null) {
                System.out.println(filteredRows.getAttribute("ENFORCEVHCLID"));
                 vehno=Integer.parseInt(filteredRows.getAttribute("ENFORCEVHCLID").toString());
             }
            if(vehno!=0)
            {
            DCIteratorBinding dcItteratorBinding =bindings1.findIteratorBinding("PvtEnforceVhclMstVO1Iterator");
            ViewObject enforcmstVO = dcItteratorBinding.getViewObject();
            enforcmstVO.setWhereClause(null);
            enforcmstVO.setWhereClauseParams(null);
              //  VHCL_TYPE= 'C' and
            enforcmstVO.setWhereClause("ENFORCE_VHCL_ID='"+vehno+"'");
            enforcmstVO.executeQuery();
            
            Row selectedRow=enforcmstVO.first();
            if(selectedRow!=null)
            selectedRow.setAttribute("VHCLASSIGNSTATUS",1);
            //Object ob=selectedRow.getAttribute("ENFORCEVHCLID");
            //Object closecourt=selectedRow.getAttribute("CasestatusID");
            }
        }
        if(selPos == 30 || selPos==29 || selPos==31) {
            DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
            DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("PvtEnforceVhclAssignVO1Iterator");
            ViewObjectImpl assignVO =(ViewObjectImpl)dcItteratorBindings.getViewObject();
            //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
            assignVO.setWhereClauseParams(null);
            assignVO.setWhereClause("REQUEST_STATUS=7 and PVT_HDR_SEQ='"+PvthdrSeqBD+"'");
            assignVO.executeQuery();
            
            //             RowQualifier rowQualifier = new RowQualifier(assignVO);
            //             rowQualifier.setWhereClause("PVTHDRSEQ="+PvthdrSeqBD+" AND REQUESTSTATUS=6");
            Row filteredRows = assignVO.first();
             if(filteredRows!=null) {
                System.out.println(filteredRows.getAttribute("ENFORCEVHCLID"));
                 vehno=Integer.parseInt(filteredRows.getAttribute("ENFORCEVHCLID").toString());
             }
            if(vehno!=0)
            {
            DCIteratorBinding dcItteratorBinding =bindings1.findIteratorBinding("PvtEnforceVhclMstVO1Iterator");
            ViewObject enforcmstVO = dcItteratorBinding.getViewObject();
            enforcmstVO.setWhereClause(null);
            enforcmstVO.setWhereClauseParams(null);
             //  VHCL_TYPE= 'C' and
            enforcmstVO.setWhereClause("ENFORCE_VHCL_ID='"+vehno+"'");
            enforcmstVO.executeQuery();
            Row selectedRow=enforcmstVO.first();
            if(selectedRow!=null)
            selectedRow.setAttribute("VHCLASSIGNSTATUS",1);
            //Object ob=selectedRow.getAttribute("ENFORCEVHCLID");
            //Object closecourt=selectedRow.getAttribute("CasestatusID");
            }
            if(selPos == 30)
            {
            OperationBinding operationBinding = getBindings().getOperationBinding("callClampingChargesProc"); 
            operationBinding.getParamsMap().put("pvthdrseq",PvthdrSeqBD);
            operationBinding.getParamsMap().put("enfcVhclId",30);
            operationBinding.execute();
            }
            
            
        }
        if(selPos == 37) {
            DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
            DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("PvtEnforceVhclAssignVO1Iterator");
            ViewObjectImpl assignVO =(ViewObjectImpl)dcItteratorBindings.getViewObject();
            //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
            assignVO.setWhereClauseParams(null);
            assignVO.setWhereClause("REQUEST_STATUS=10 and PVT_HDR_SEQ='"+PvthdrSeqBD+"'");
            assignVO.executeQuery();
            
            //             RowQualifier rowQualifier = new RowQualifier(assignVO);
            //             rowQualifier.setWhereClause("PVTHDRSEQ="+PvthdrSeqBD+" AND REQUESTSTATUS=6");
            Row filteredRows = assignVO.first();
             if(filteredRows!=null) {
                System.out.println(filteredRows.getAttribute("ENFORCEVHCLID"));
                 vehno=Integer.parseInt(filteredRows.getAttribute("ENFORCEVHCLID").toString());
             }
            if(vehno!=0)
            {
            DCIteratorBinding dcItteratorBinding =bindings1.findIteratorBinding("PvtEnforceVhclMstVO1Iterator");
            ViewObject enforcmstVO = dcItteratorBinding.getViewObject();
            enforcmstVO.setWhereClause(null);
            enforcmstVO.setWhereClauseParams(null);
              //  VHCL_TYPE= 'C' and
            enforcmstVO.setWhereClause("ENFORCE_VHCL_ID='"+vehno+"'");
            enforcmstVO.executeQuery();
            
            Row selectedRow=enforcmstVO.first();
            if(selectedRow!=null)
            selectedRow.setAttribute("VHCLASSIGNSTATUS",1);
            //Object ob=selectedRow.getAttribute("ENFORCEVHCLID");
            //Object closecourt=selectedRow.getAttribute("CasestatusID");
            }
            
        }
        
             
        OperationBinding opcommit = getBindings().getOperationBinding("doCommit");
        opcommit.execute();
                
        if(selPos == 32) {
            clampingApprovalBPMProcessService = new ClampingApprovalBPMProcessService();
            ClampingApprovalBPMProcessPortType clampingApprovalBPMProcessPortType = clampingApprovalBPMProcessService.getClampingApprovalBPMProcessPort();
            clampingApprovalBPMProcessPortType.start(PvthdrSeqBD.longValue(),2);
            System.out.println("WSDL with 2");
        } 
        if (selPos == 35) {
            clampingApprovalBPMProcessService = new ClampingApprovalBPMProcessService();
            ClampingApprovalBPMProcessPortType clampingApprovalBPMProcessPortType = clampingApprovalBPMProcessService.getClampingApprovalBPMProcessPort();
            clampingApprovalBPMProcessPortType.start(PvthdrSeqBD.longValue(),2);          
            System.out.println("WSDL with 2");
        }
        if (selPos == 27) {
            clampingApprovalBPMProcessService = new ClampingApprovalBPMProcessService();
            ClampingApprovalBPMProcessPortType clampingApprovalBPMProcessPortType = clampingApprovalBPMProcessService.getClampingApprovalBPMProcessPort();
            clampingApprovalBPMProcessPortType.start(PvthdrSeqBD.longValue(),1); 
            System.out.println("WSDL with 1");
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Details saved Successfully",null));   
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","NoSelected");
        DCIteratorBinding dcIteratorBinding1 = bindings.findIteratorBinding("ClampingUVO1Iterator");
        ViewObjectImpl VO1 =(ViewObjectImpl)dcIteratorBinding1.getViewObject();
        VO1.executeQuery();
        selectedtable.getSelectedRowKeys().clear();
        Remarksforclamping=null;
        
    }
        }
        else {
            return null;  
        }
       
        return null;
    }
    
    
    
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings1 =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        Integer selectedPosIndex = 0;
        Integer i;
        if (newstatus.getValue() != null) {
            selectedPosIndex =
                    Integer.parseInt(newstatus.getValue().toString());
        }
        String selectedPos = null;
        if (selectedPosIndex != null) {
            //Passing the LOV Iterator object and getting the list
            JUCtrlListBinding list =
                (JUCtrlListBinding)bindings1.get("ClampenforcementRVO1");
            //Passing the selected Value index and getting the Row object
            Row row =
                list.getRowIterator().getRowAtRangeIndex(selectedPosIndex);
            selectedPos = row.getAttribute("ENFORCESTAGEID").toString();
            selPos = Integer.parseInt(selectedPos.toString());
        }
            if(getRemarksforclamping()!=null) {
                               
            }
            else {
                if(selPos==27)
                {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Remarks.", null));
                result = "fail";    
                }
                
                if(selPos==35)
                {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Remarks.", null));
                result = "fail";    
                } 
            }
        if(selPos==30)
        {
            if(currentstatus.equals("2"))
            {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"PVT Already closed.", null));
        result = "fail";    
        }
        }
        
        if(selPos==31)
        {
            if(currentstatus.equals("2"))
            {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"PVT Already closed.", null));
        result = "fail";    
        } 
        }
              
        
        return result;
    }
    
 
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String Cancel() {
        // Add event code here...
        getBindings().getOperationBinding("doRollback").execute();
        setRemarks(null);
        selectedtable.getSelectedRowKeys().clear();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","NoSelected");
        return null;
    }

    public void setPvtnumber(String pvtnumber) {
        this.pvtnumber = pvtnumber;
    }

    public String getPvtnumber() {
        return pvtnumber;
    }

    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }

    public String getCurrentstatus() {
        return currentstatus;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getEn() {
        return en;
    }

//    public void newStatusVC(ValueChangeEvent valueChangeEvent) {
//        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        Integer selectedPosIndex;
//        Integer i;
//        selectedPosIndex = (Integer)valueChangeEvent.getNewValue();
//        String selectedPos = null;
//        if (selectedPosIndex != null) 
//        {
//            //Passing the LOV Iterator object and getting the list
//            JUCtrlListBinding list =(JUCtrlListBinding)bindings.get("ClampenforcementRVO1");
//            //Passing the selected Value index and getting the Row object
//            Row row =list.getRowIterator().getRowAtRangeIndex(selectedPosIndex);
//            selectedPos = (String)row.getAttribute("ENFORCESTAGEID");
//             selPos =Integer.parseInt(selectedPos.toString());
//            }
// 
//    }


    public void setSelPos(Integer selPos) {
        this.selPos = selPos;
    }

    public Integer getSelPos() {
        return selPos;
    }

    public void setNewstatus(RichSelectOneChoice newstatus) {
        this.newstatus = newstatus;
    }

    public RichSelectOneChoice getNewstatus() {
        return newstatus;
    }

    public void setRemarks(RichInputText remarks) {
        this.remarks = remarks;
    }

    public RichInputText getRemarks() {
        return remarks;
    }

    public void setSelectedtable(RichTable selectedtable) {
        this.selectedtable = selectedtable;
    }

    public RichTable getSelectedtable() {
        return selectedtable;
    }

    public void setRemarksforclamping(String Remarksforclamping) {
        this.Remarksforclamping = Remarksforclamping;
    }

    public String getRemarksforclamping() {
        return Remarksforclamping;
    }

    public void setPvtamtpayablepopup(RichPopup pvtamtpayablepopup) {
        this.pvtamtpayablepopup = pvtamtpayablepopup;
    }

    public RichPopup getPvtamtpayablepopup() {
        return pvtamtpayablepopup;
    }
}
