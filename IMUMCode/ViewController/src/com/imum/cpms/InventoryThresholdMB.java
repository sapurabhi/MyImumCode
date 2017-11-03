package com.imum.cpms;

import com.imum.cpms.model.masters.vo.AccountMapMstVORowImpl;

import com.imum.cpms.model.masters.vo.AccountMstVORowImpl;

import com.imum.cpms.model.masters.vo.InvStockReorderLevelDetailsVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;


public class InventoryThresholdMB {
    
    private boolean hide = true;
    private boolean enabled = true;
    private String editMode=null;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    private RichInputText inactivateseq;
    MessageUtil genMsg = new MessageUtil();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
   // String lngCode = httpSession.getAttribute("language").toString();
   String lngCode ="EN";
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    private RichTable tablebind;

    public InventoryThresholdMB() {
        if(lngCode==null || lngCode.equals(""))
         {
          lngCode = "EN";
         }
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public void newInventoryThreshold(ActionEvent actionEvent) {
        
        setHide(Boolean.FALSE);  
        editMode="new";
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("donewInventoryThreshold");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        inactivateseq.setRendered(Boolean.FALSE);
        if(!isEnabled())
            setEnabled(Boolean.TRUE);
       
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isHide() {
        return hide;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEditMode(String editMode) {
        this.editMode = editMode;
    }

    public String getEditMode() {
        return editMode;
    }

    public String doEditInventoryThreshold() {
       
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        editMode="edit";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditINVStockReorderLevelDetails");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();     
        setEnabled(Boolean.TRUE);
        inactivateseq.setRendered(Boolean.TRUE);
        //If no data exists in Table
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("InvStockReorderLevelDetailsVO1Iterator").getEstimatedRowCount()>0)){
           pageflowScope.put("setvisible", false);
            System.out.println("No Data available to Edit/View Details");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }            
        return null;
    }
    
    public String doViewInventoryThreshold() {
        
       // String userName = httpSession.getAttribute("loggedinUserid").toString();
        editMode="view";
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditINVStockReorderLevelDetails");
        opBinding.getParamsMap().put("loggerName","imum");
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
        setEnabled(Boolean.FALSE);
            if(!(((DCBindingContainer)getBindings()).findIteratorBinding("InvStockReorderLevelDetailsVO1Iterator").getEstimatedRowCount()>0)){
            pageflowScope.put("setvisible", false);
                System.out.println("No Data available to Edit/View Details");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }   
        return null;
    }
    
    public ViewObject getInvStockReorderLevelDetailsVO() {
        DCBindingContainer bindings=(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding bindingAccnt =bindings.findIteratorBinding("InvStockReorderLevelDetailsVO2Iterator");
        ViewObject invstock = bindingAccnt.getViewObject();
        return invstock;
    }
    
//    public String submitChanges(ActionEvent actionEvent) {
//                //String result="pass";
////                String result = validateDataOnSubmit();
//                DCBindingContainer bindings =(DCBindingContainer)getBindings();
//                DCIteratorBinding dcItteratorBindings =bindings.findIteratorBinding("InvStockReorderLevelDetailsVO1Iterator");
//                ViewObject invstockvo1 = dcItteratorBindings.getViewObject();
//                DCIteratorBinding dcItteratorBindings2=bindings.findIteratorBinding("InvStockReorderLevelDetailsVO2Iterator");
//                ViewObject invstock = getInvStockReorderLevelDetailsVO();
//                String seq = (String)dcItteratorBindings2.getViewObject().getCurrentRow().getAttribute("stockReorderSeq");
//                Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
//                //Creating New row in Account Map -Setting remarks and Account code values 
//                if(editMode!=null && (editMode.equalsIgnoreCase("new"))){
//                    Row accntMapNewRow = invstock.createRow();
//                    //accntMapNewRow.setAttribute("CreatedBy",httpSession.getAttribute("loggedinUserid").toString());
//                    accntMapNewRow.setAttribute("CreatedBy","imum");
//                    accntMapNewRow.setAttribute("CreatedDate",sqlDate);
//                    accntMapNewRow.setAttribute("stockReorderSeq",seq);
//                    invstock.insertRow(accntMapNewRow);
//                }else if(editMode!=null && (editMode.equalsIgnoreCase("edit"))){
//                    String Code=seq;
//                    if(Code!=null){                    
//                        invstock.clearCache();
//                        invstock.setWhereClause(null);
//                        invstock.setWhereClause("stockReorderSeq = '"+Code+"'");
//                        invstock.executeQuery(); 
//                       InvStockReorderLevelDetailsVORowImpl Row = (InvStockReorderLevelDetailsVORowImpl)invstock.first();
//                        if(Row!=null){
//                            
//                            //Row.setstockReorderSeq(9);
//                           // Row.setUpdatedby(httpSession.getAttribute("loggedinUserid").toString());
//                            Row.setUpdatedby("imum");
//                            Row.setUpdateddate(sqlDate);    
//                        }          
//                    }                }
//                
//                if (true) {               
//                OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
//                opBindingDoc.execute();                
//                if(opBindingDoc.getErrors().isEmpty()){
//                    invstockvo1.executeQuery();
//                   // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Account Master details saved Successfully",genMsg.getMessage("311",lngCode)));    
//                }
//               }else{
//                     //getBindings().getOperationBinding("doRollback").execute();
//                     invstockvo1.executeQuery();
//                     setHide(false);                 
//                     ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
//                    // AdfFacesContext.getCurrentInstance().addPartialTarget(accntIdTable); 
//                    return "true";
//              }
//               return "false";
//            }
//    
    
    
    
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("InvStockReorderLevelDetailsVO2Iterator");
        ViewObject accntVO = dcIteratorBinding.getViewObject();
        InvStockReorderLevelDetailsVORowImpl Row = (InvStockReorderLevelDetailsVORowImpl)accntVO.getCurrentRow();
        if (Row != null) {            
            
            Object LocationID = Row.getLocationID();
           
            if(LocationID == null || LocationID.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select Location", null));    
                result = "fail";    
            }
            Object cardtype = Row.getCardTypeCode();
           
            if(cardtype == null || cardtype.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select Card Type ", null));    
                result = "fail";    
            }
            Object rleave = Row.getReorderLevel();
            
            if(rleave == null || rleave.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Reorder Level", null));    
                result = "fail";    
            }
            if(rleave!=null) {
                int leave=Integer.parseInt(rleave.toString());
                if(leave<0)
                {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter valied Reorder Level", null));    
                result = "fail";    
                }
            }
            
            if(cardtype!=null && LocationID!=null) {
                  DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
                  DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("InvStockReorderLevelDetailsVO2Iterator");
                  ViewObjectImpl invslVO =(ViewObjectImpl)dcItteratorBindings.getViewObject();
                 //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
                   RowQualifier rowQualifier = new RowQualifier(invslVO);
                   rowQualifier.setWhereClause("LocationID="+LocationID+" AND CardTypeCode="+cardtype);
                   Row[] filteredRows = invslVO.getFilteredRows(rowQualifier); 
                   
                   if(filteredRows.length>1){
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Record with the given Location and Card type already exists.", null));    
                       result = "fail";     
                   }

              }
            if(cardtype!=null && LocationID!=null) {
                  DCBindingContainer bindings3 =(DCBindingContainer)getBindings();
                  DCIteratorBinding dcItteratorBindings1 =bindings3.findIteratorBinding("InvStockReorderLevelDetailsVO3Iterator");
                  ViewObjectImpl invslVO =(ViewObjectImpl)dcItteratorBindings1.getViewObject();
                 //  ViewObjectImpl invslVO =(ViewObjectImpl)getInvStockReorderLevelDetailsVO();
                   RowQualifier rowQualifier = new RowQualifier(invslVO);
                   rowQualifier.setWhereClause("LocationID="+LocationID+" AND CardTypeCode="+cardtype);
                   Row[] filteredRows = invslVO.getFilteredRows(rowQualifier); 
                   
                   if(filteredRows.length>1){
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Record with the given Location and Card type already exists.", null));    
                       result = "fail";     
                   }

              }
            
            
                   
           
        }
        return result;
    }

    public void submitTheChanges(ActionEvent actionEvent) {
        String result = validateDataOnSubmit();
        ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
        
        if("pass".equals(result))
        {    
        BigDecimal  seq=null;
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcItteratorBindings =bindings.findIteratorBinding("InvStockReorderLevelDetailsVO1Iterator");
        ViewObject invstockvo1 = dcItteratorBindings.getViewObject();
        DCIteratorBinding dcItteratorBindings2=bindings.findIteratorBinding("InvStockReorderLevelDetailsVO2Iterator");
        ViewObject invstock =getInvStockReorderLevelDetailsVO();
        Object ob=dcItteratorBindings.getViewObject().getCurrentRow().getAttribute("stockReorderSeq");
          
        
        if(ob!=null) {
             seq= (BigDecimal)ob;
        }
        
       
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        //Creating New row in Account Map -Setting remarks and Account code values 
        if(editMode!=null && (editMode.equalsIgnoreCase("new"))){
//           // Row accntMapNewRow = invstock.getCurrentRow();
//           Row NewRow = invstock.getCurrentRow();
//           System.out.println(NewRow.getAttribute("CreatedBy"));
//           System.out.println(NewRow.getAttribute("CreatedDate"));
//            System.out.println(NewRow.getAttribute("LocationID"));   
//            System.out.println(NewRow.getAttribute("CardTypeCode"));
//            System.out.println(NewRow.getAttribute("ReorderLevel"));
//            System.out.println(NewRow.getAttribute("TriggerEmailflag"));
//            //accntMapNewRow.setAttribute("CreatedBy",httpSession.getAttribute("loggedinUserid").toString());
//            
//            //accntMapNewRow.setAttribute("stockReorderSeq",dcItteratorBindings2.getViewObject().getCurrentRow().getAttribute("stockReorderSeq"));
//            System.out.println(invstock.getQuery());
//            //invstock.insertRow(NewRow);
        }
        else if(editMode!=null && (editMode.equalsIgnoreCase("edit"))){
            
            BigDecimal Code=seq;
//            if(Code!=null){ 
//                invstock.clearCache();
//                invstock.setWhereClause(null);
//                invstock.setWhereClause("stock_Reorder_Seq = '"+Code+"'");
//                invstock.executeQuery(); 
//               InvStockReorderLevelDetailsVORowImpl Row = (InvStockReorderLevelDetailsVORowImpl)invstock.first();
               InvStockReorderLevelDetailsVORowImpl Row = (InvStockReorderLevelDetailsVORowImpl)invstock.getCurrentRow();
                if(Row!=null){
                    
                    //Row.setstockReorderSeq(9);
                   // Row.setUpdatedby(httpSession.getAttribute("loggedinUserid").toString());
                    Row.setUpdatedby("imum");
                    Row.setUpdateddate(sqlDate);    
                }          
            }                
        
        if (result.equals("pass")) {               
        OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
        opBindingDoc.execute();                
        if(opBindingDoc.getErrors().isEmpty()){
            invstockvo1.executeQuery();
            ADFContext.getCurrent().getPageFlowScope().put("setvisible", "false");
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Threshold Stock  details saved Successfully",null));    
        }
        }else{
             getBindings().getOperationBinding("doRollback").execute();
             invstockvo1.executeQuery();
             setHide(false);                 
             ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
             AdfFacesContext.getCurrentInstance().addPartialTarget(tablebind); 
     
    }
        }
    }

    public void setInactivateseq(RichInputText inactivateseq) {
        this.inactivateseq = inactivateseq;
    }

    public RichInputText getInactivateseq() {
        return inactivateseq;
    }

    public void cancel(ActionEvent actionEvent) {
        getBindings().getOperationBinding("doRollback").execute();
    }

    public void setTablebind(RichTable tablebind) {
        this.tablebind = tablebind;
    }

    public RichTable getTablebind() {
        return tablebind;
    }
}
