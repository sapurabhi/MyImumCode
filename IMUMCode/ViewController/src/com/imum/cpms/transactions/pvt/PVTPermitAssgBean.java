package com.imum.cpms.transactions.pvt;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class PVTPermitAssgBean {
    private Boolean pvtRgn=false;
    private Boolean permitRgn=false;
    private String pvTPermitNo=null;
    private String permitNumber=null;
    private RichInputDate pvTAssgDate;
    private RichInputDate permitAssgDate;
    private RichSelectOneChoice permitGroup;
    private RichSelectOneChoice permitUser;
    private RichInputText permitRemarks;
    private RichSelectOneChoice pvTGroup;
    private RichSelectOneChoice pvTUser;
    private RichInputText pvTRemarks;
    private Boolean pvtDetails=false;
    private Boolean permitDetails=false;
    private Boolean submitAction=false;
    private Object PRMHDRSEQ =null;
    private Object PVTHDRSEQ =null;
    private  BigDecimal loghdrseq=null;
    FacesContext facesContext=FacesContext.getCurrentInstance();
    ExternalContext externalContext=facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    private  Integer permitUserIndex = null;
    private String selectedPos1 = null;
    private java.sql.Date sqlDate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());  
    private  Object PRMTNumber=null;
    private Object PVTNo=null;
    private RichTable pvttablebind;
    private RichColumn permittablebind;
    private RichTable permittablebindVar;


    public void pvtUserSelect(ValueChangeEvent valueChangeEvent) {
        permitUserIndex = (Integer)valueChangeEvent.getNewValue();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        JUCtrlListBinding list =
            (JUCtrlListBinding)bindings.get("PVTPermitUserVO1");
        Row row =
            list.getRowIterator().getRowAtRangeIndex(permitUserIndex);
        selectedPos1 = (String)row.getAttribute("userid");
        System.out.println(selectedPos1);
    }
   
    public void pvtUser1Select(ValueChangeEvent valueChangeEvent) {
        permitUserIndex = (Integer)valueChangeEvent.getNewValue();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        JUCtrlListBinding list =
            (JUCtrlListBinding)bindings.get("PVTPermitUserVO1");
        Row row =
            list.getRowIterator().getRowAtRangeIndex(permitUserIndex);
        selectedPos1 = (String)row.getAttribute("userid");
        System.out.println(selectedPos1);
    }
    
    
    public void pvtGroupSelect(ValueChangeEvent valueChangeEvent) {
        Integer selectedPosIndex = (Integer)valueChangeEvent.getNewValue(); 
        System.out.println(selectedPosIndex);
        
        if (selectedPosIndex != null) {
         DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                  JUCtrlListBinding list =(JUCtrlListBinding)bindings.get("PVTPermitGroupUserVO1");
                  //Passing the selected Value index and getting the Row object
                  Row row =list.getRowIterator().getRowAtRangeIndex(selectedPosIndex);
                  Integer  selectedPos = (Integer)row.getAttribute("groupid");
                 System.out.println(selectedPos);
                  DCBindingContainer AM =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                  DCIteratorBinding pvtpermit =
                      AM.findIteratorBinding("PVTPermitUserVO1Iterator");
                  ViewObject eventVO = pvtpermit.getViewObject();
                  eventVO.setWhereClause(null);
                  eventVO.setWhereClause("Group_id = " + selectedPos);                  
                  eventVO.executeQuery();

  
              }
       
    }

    public void pvtPermitSelect(ValueChangeEvent valueChangeEvent) {
        String pvtprmt = (String)valueChangeEvent.getNewValue();        
        if("PVT".equals(pvtprmt)){
            pvtRgn=true;
            permitRgn=false;
        }
        if("Permit".equals(pvtprmt)){
            permitRgn=true;
            pvtRgn=false;
        }
        submitAction=false; 
        pvTPermitNo=null;
        permitNumber=null;
    }
    
    public void selectPVTRow(SelectionEvent selectionEvent) {
        // Add event code here...
     
        try
        {
            ADFUtil.invokeEL("#{bindings.PVTSearchRVO11.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTSearchRVO1Iterator.currentRow}"); // get the current selected row           
           
            if(selectedRow != null)
            {
                PVTHDRSEQ = selectedRow.getAttribute("PVTHDRSEQ");       
                
                if(PVTHDRSEQ != null) 
                {
                    Object PVTNo = (String)selectedRow.getAttribute("PVTNum");
                    if(PVTNo!=null) {
                      pvTAssgDate.setValue(sqlDate);
                       pvTPermitNo =PVTNo.toString();
                       pvtDetails=true;
                       permitDetails=false;
                       submitAction=true;
                    }

                     
                }
            }
        }
        catch (Exception e) {
                    System.out.println("Error occurred..." + e.toString());
                                            }
    }
    
    
        
    
    public void selectPermitRow(SelectionEvent selectionEvent) {
        // Add event code here...
     
        try
        {
            ADFUtil.invokeEL("#{bindings.PermitSearchCriteriaVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PermitSearchCriteriaVO1Iterator.currentRow}"); // get the current selected row         
            if(selectedRow != null)
            {
                PRMHDRSEQ = selectedRow.getAttribute("PRMHeaderseq");
                if(PRMHDRSEQ != null) 
                {
                    Object PRMTNumber = selectedRow.getAttribute("PermitNumber");
                    if(PRMTNumber!=null)
                    {
                    permitNumber=PRMTNumber.toString();
                       permitAssgDate.setValue(sqlDate);
                        pvtDetails=false;
                        permitDetails=true;
                        submitAction=true;
                      
                    }
                     
                }
            }
        }
        catch (Exception e) {
                    System.out.println("Error occurred..." + e.toString());
                                            }
    }
    

    DCBindingContainer bindings1 = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    OperationBinding opBindingDoc1 = bindings1.getOperationBinding("doSearchPvtPermit");  
    OperationBinding opBindingDoc2 = bindings1.getOperationBinding("doSearchPermitpvt");
   
    
    
    public void selectPVTAssignRow(SelectionEvent selectionEvent) {
        // Add event code here...
     
        try
        {
            ADFUtil.invokeEL("#{bindings.PVTPermitAssignmentRVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTPermitAssignmentRVO1Iterator.currentRow}"); // get the current selected row          
            if(selectedRow != null)
            {
                 PVTNo = (String)selectedRow.getAttribute("PVTNum");
                 PRMTNumber=null;
                    loghdrseq = (BigDecimal)selectedRow.getAttribute("Assignlogseq");
                    System.out.println(loghdrseq);
                    if(PVTNo!=null) {
                     String pvTPermitNo1 =PVTNo.toString();        
                    opBindingDoc1.getParamsMap().put("modetype","PVT");
                    opBindingDoc1.getParamsMap().put("hdrseq",pvTPermitNo1);                    
                    opBindingDoc1.execute();
                   
                   
                     
                }
            }
        }
        catch (Exception e) {
        System.out.println("Error occurred..." + e.toString());
                  }     
    }
    
    
        
    
    public void selectPermitAssignRow(SelectionEvent selectionEvent) {
        // Add event code here...
     
        try
        {
            ADFUtil.invokeEL("#{bindings.PVTPermitAssignRVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTPermitAssignRVO1Iterator.currentRow}"); // get the current selected row         
            if(selectedRow != null)
            {
                     PRMTNumber = selectedRow.getAttribute("permitnumber");
                     PVTNo=null;
                     loghdrseq = (BigDecimal)selectedRow.getAttribute("Assignlogseq");
                    System.out.println(loghdrseq);
                    if(PRMTNumber!=null)
                    {
                    String permitNumber1=PRMTNumber.toString();
                       
                        opBindingDoc2.getParamsMap().put("modetype","PRM");
                        opBindingDoc2.getParamsMap().put("hdrseq",permitNumber1);                    
                        opBindingDoc2.execute();                
                      
                    }
                     
                }
            }
      
        catch (Exception e) {
            
        System.out.println("Error occurred..." + e.toString());
                                            }
     
    }
    

 
    public void setPvtRgn(Boolean pvtRgn) {
        this.pvtRgn = pvtRgn;
    }

    public Boolean getPvtRgn() {
        return pvtRgn;
    }

    public void setPermitRgn(Boolean permitRgn) {
        this.permitRgn = permitRgn;
    }

    public Boolean getPermitRgn() {
        return permitRgn;
    }


    public void setPvTPermitNo(String pvTPermitNo) {
        this.pvTPermitNo = pvTPermitNo;
    }

    public String getPvTPermitNo() {
        return pvTPermitNo;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

  
    public void setPvTAssgDate(RichInputDate pvTAssgDate) {
        this.pvTAssgDate = pvTAssgDate;
    }

    public RichInputDate getPvTAssgDate() {
        return pvTAssgDate;
    }

    public void setPermitAssgDate(RichInputDate permitAssgDate) {
        this.permitAssgDate = permitAssgDate;
    }

    public RichInputDate getPermitAssgDate() {
        return permitAssgDate;
    }

    public void setPermitGroup(RichSelectOneChoice permitGroup) {
        this.permitGroup = permitGroup;
    }

    public RichSelectOneChoice getPermitGroup() {
        return permitGroup;
    }

    public void setPermitUser(RichSelectOneChoice permitUser) {
        this.permitUser = permitUser;
    }

    public RichSelectOneChoice getPermitUser() {
        return permitUser;
    }

    public void setPermitRemarks(RichInputText permitRemarks) {
        this.permitRemarks = permitRemarks;
    }

    public RichInputText getPermitRemarks() {
        return permitRemarks;
    }

    public void setPvTGroup(RichSelectOneChoice pvTGroup) {
        this.pvTGroup = pvTGroup;
    }

    public RichSelectOneChoice getPvTGroup() {
        return pvTGroup;
    }

    public void setPvTUser(RichSelectOneChoice pvTUser) {
        this.pvTUser = pvTUser;
    }

    public RichSelectOneChoice getPvTUser() {
        return pvTUser;
    }

    public void setPvTRemarks(RichInputText pvTRemarks) {
        this.pvTRemarks = pvTRemarks;
    }

    public RichInputText getPvTRemarks() {
        return pvTRemarks;
    }
   

    public void setPvtDetails(Boolean pvtDetails) {
        this.pvtDetails = pvtDetails;
    }

    public Boolean getPvtDetails() {
        return pvtDetails;
    }

    public void setPermitDetails(Boolean permitDetails) {
        this.permitDetails = permitDetails;
    }

    public Boolean getPermitDetails() {
        return permitDetails;
    }

    public void setSubmitAction(Boolean submitAction) {
        this.submitAction = submitAction;
    }

    public Boolean getSubmitAction() {
        return submitAction;
    }

    public void savePVTPermit() {
        // Add event code here...
//        Timestamp sqlDate =
//            new java.sql.Timestamp(new java.util.Date().getTime());
        DCBindingContainer AM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding pvtpermit =
            AM.findIteratorBinding("PVTPermitAssignmentVO1Iterator");
        ViewObject eventVO = pvtpermit.getViewObject();
        eventVO.clearCache();
        eventVO.executeEmptyRowSet();
        if (eventVO != null) {
            Row eventRow = eventVO.createRow();  
//            Integer selectedPos = null;
           //A String selectedPos1 = null;
//            Integer permitGrpIndex = null;
          //A  Integer permitUserIndex = null;
            DCBindingContainer bindings =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            if (permitNumber != null) {
                //                      permitGrpIndex = (Integer)permitGroup.getValue();
             //   permitUserIndex = (Integer)permitUser.getValue();
                eventRow.setAttribute("Trnhdrseq", PRMHDRSEQ);
                eventRow.setAttribute("SOURCEMODULEID", "3");
                eventRow.setAttribute("AssignedDate", sqlDate);
                eventRow.setAttribute("AssignmentRemarks", permitRemarks.getValue());
                eventRow.setAttribute("AssignStatusID", "1");                
                permitDetails=false;
                submitAction=false;

            }
            if (pvTPermitNo != null) {
                //                         permitGrpIndex = (Integer)pvTGroup.getValue();
           //     permitUserIndex = (Integer)pvTUser.getValue();
                eventRow.setAttribute("Trnhdrseq", PVTHDRSEQ);
                eventRow.setAttribute("SOURCEMODULEID", "2");
                eventRow.setAttribute("AssignedDate",sqlDate);
                eventRow.setAttribute("AssignmentRemarks", pvTRemarks.getValue());
                eventRow.setAttribute("AssignStatusID", "1");
                pvtDetails=false;
                submitAction=false;
            }
            if (permitUserIndex != null) {
//                JUCtrlListBinding list =
//                    (JUCtrlListBinding)bindings.get("PVTPermitUserVO1");
//                Row row =
//                    list.getRowIterator().getRowAtRangeIndex(permitUserIndex);
//                selectedPos1 = (String)row.getAttribute("userid");
                eventRow.setAttribute("Assignedto", selectedPos1);
            }
            eventRow.setAttribute("CreatedBy", userName);
            eventRow.setAttribute("CreatedDate", sqlDate);
            eventVO.insertRow(eventRow);
            OperationBinding opBindingDoc =
                bindings.getOperationBinding("doCommit");
            opBindingDoc.execute();
            permitGroup.setValue(null);
            permitUser.setValue(null);
            pvTUser.setValue(null);
            pvTGroup.setValue(null);      
            pvTRemarks.setValue(null);
            permitRemarks.setValue(null);
            if (opBindingDoc.getErrors().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Your Assignment details saved Successfully",
                                                                              null));
                if (PVTHDRSEQ != null) {
                pvttablebind.getSelectedRowKeys().clear();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(pvttablebind); 
                }
                if (PRMHDRSEQ != null) {
                permittablebindVar.getSelectedRowKeys().clear();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(permittablebindVar);
                }
            }
 

        }
    }

    public void cancelAssg(){
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding opBindingDoc = bindings.getOperationBinding("doRollback");                
        opBindingDoc.execute(); 
        permitGroup.setValue(null);
        permitUser.setValue(null);
        pvTUser.setValue(null);
        pvTGroup.setValue(null);      
        pvTRemarks.setValue(null);
        permitRemarks.setValue(null);
        pvtDetails=false;
        permitDetails=false;
        submitAction=false;
        if (PVTHDRSEQ != null) {
        pvttablebind.getSelectedRowKeys().clear();
            AdfFacesContext.getCurrentInstance().addPartialTarget(pvttablebind);
        }
        if (PRMHDRSEQ != null) {
        permittablebindVar.getSelectedRowKeys().clear();
            AdfFacesContext.getCurrentInstance().addPartialTarget(permittablebindVar);
        }
       
        
    }


    public void commitPVTPermitAssign(ActionEvent actionEvent) {
        // Add event code here...
        
        DCBindingContainer AM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding opBindingDoc1 =
            AM.getOperationBinding("doCommit");      
        if(loghdrseq!=null){
        DCIteratorBinding pvtpermit =
            AM.findIteratorBinding("PVTPermitAssignmentVO1Iterator");
        ViewObject eventVO = pvtpermit.getViewObject();
        eventVO.setWhereClause(null);
        eventVO.setWhereClause("Assign_log_seq = " + loghdrseq);                  
        eventVO.executeQuery();        
        Row row=eventVO.first();
        if(row!=null){
            row.setAttribute("AssignStatusID", "2");
            row.setAttribute("Updatedby",userName);
            row.setAttribute("Updatedate",sqlDate);
            opBindingDoc1.execute();
           
        }
        
        
           
            DCIteratorBinding userEmail =
                AM.findIteratorBinding("PVTPermitUserVO1Iterator");
            ViewObject userEVO = userEmail.getViewObject();
            userEVO.setWhereClause(null);
            userEVO.setWhereClause("user_id = " + "'"+userName+"'");                  
            userEVO.executeQuery();
            Row row1=userEVO.first();
            String emailUser="";
            if(row1!=null){
                 emailUser = (String)row1.getAttribute("mailid");
            }
           DCIteratorBinding email =
                AM.findIteratorBinding("MyAssignmentEmailUVO1Iterator");
            ViewObject emailVO=email.getViewObject();                 
        
           String value="";
                String  value1 = (String)row.getAttribute("AssignmentRemarks");
            System.out.println(PRMTNumber +"  "+PVTNo);
            if(PRMTNumber!=null){
             value="Permit  " +PRMTNumber;
            }
            if(PVTNo!=null){
                value="PVT  " +PVTNo;              
            }
            if(emailUser!=null){
            if (emailVO != null) {
             Row emailRow = emailVO.createRow(); 
            emailRow.setAttribute("Srcmodule", "10");
            emailRow.setAttribute("Srceventid", "514");
            emailRow.setAttribute("EmailSubj", "Assigned Task Completed: "+value);
            emailRow.setAttribute("EmailText", "<p>Hi,<br>This is to inform that Assigned Task for "+ value +" has been Completed.<br> Assigned Task: "+value1+".<br><br>Thanks,<br>CPMS<br></p>");
            emailRow.setAttribute("ToEmailid", emailUser);
            emailRow.setAttribute("EmailLang", "EN");
            emailRow.setAttribute("BccEmailid", "NULL");
            emailRow.setAttribute("CcEmailid", "NULL");
            emailRow.setAttribute("SendStatus", 0);
            emailRow.setAttribute("Sentdate",sqlDate);
            emailRow.setAttribute("CreatedDate",sqlDate);
            emailRow.setAttribute("CreatedBy", userName);
            emailVO.insertRow(emailRow);  
                opBindingDoc1.execute();
            }
            }
        
            OperationBinding opBindingDoc =
                AM.getOperationBinding("executeMyAssignments");
            opBindingDoc.execute(); 
        }
        
    }

    public void setPvttablebind(RichTable pvttablebind) {
        this.pvttablebind = pvttablebind;
    }

    public RichTable getPvttablebind() {
        return pvttablebind;
    }

    public void setPermittablebind(RichColumn permittablebind) {
        this.permittablebind = permittablebind;
    }

    public RichColumn getPermittablebind() {
        return permittablebind;
    }

    public void setPermittablebindVar(RichTable permittablebindVar) {
        this.permittablebindVar = permittablebindVar;
    }

    public RichTable getPermittablebindVar() {
        return permittablebindVar;
    }
}
