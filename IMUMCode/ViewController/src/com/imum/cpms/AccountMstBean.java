package com.imum.cpms;

import com.imum.cpms.model.masters.vo.AccountMapMstVORowImpl;
import com.imum.cpms.model.masters.vo.AccountMstVORowImpl;
import com.imum.cpms.model.masters.vo.RemovalTruckMstVORowImpl;
import com.imum.cpms.util.MessageUtil;

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
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class AccountMstBean {
    

    public AccountMstBean() {
        if(lngCode==null || lngCode.equals(""))
         {
          lngCode = "EN";
         }
    }
    
    private boolean hide = true;
    private boolean enabled = true;
    private String editMode=null;
    private RichCommandButton submitButton;
    private RichCommandButton cancelButton;
    private RichInputText accntIdButton;
    private RichTable accntIdTable;
    public static final ADFLogger logger = ADFLogger.createADFLogger(AccountMstBean.class);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
  
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    String accountCode=null;

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public String doNewAccntMst() {
        // Add event code here...
        logger.info("doNewAccntMst");
        setHide(Boolean.FALSE);  
        editMode="new";
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNewAccnt");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        logger.info("success"); 
        accntIdButton.setRendered(Boolean.FALSE);
        if(!isEnabled())
            setEnabled(Boolean.TRUE);
        return null;
    }
    
    public ViewObject getAccountVO() {
        DCBindingContainer bindings=(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding bindingAccnt =bindings.findIteratorBinding("AccountMapMstVO1Iterator");
        ViewObject voAccnt = bindingAccnt.getViewObject();
        return voAccnt;
    }
    
    public String submitAccntChanges(ActionEvent actionEvent) {
                //String result="pass";
                String result = validateDataOnSubmit();
                DCBindingContainer bindings =(DCBindingContainer)getBindings();
                DCIteratorBinding dcItteratorBindings =bindings.findIteratorBinding("AccountMstVO1Iterator");
                ViewObject accntVO1 = dcItteratorBindings.getViewObject();
                DCIteratorBinding dcItteratorBindings2 =bindings.findIteratorBinding("AccountMstVO2Iterator");
                ViewObject accntVOMap = getAccountVO();
                String accountCode = (String)dcItteratorBindings2.getViewObject().getCurrentRow().getAttribute("acccode");
                Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
                //Creating New row in Account Map -Setting remarks and Account code values 
                if(editMode!=null && (editMode.equalsIgnoreCase("new"))){
                    Row accntMapNewRow = accntVOMap.createRow();
                    accntMapNewRow.setAttribute("CreatedBy",httpSession.getAttribute("loggedinUserid").toString());
                    accntMapNewRow.setAttribute("CreatedDate",sqlDate);
                    accntMapNewRow.setAttribute("acccode",accountCode);
                    accntVOMap.insertRow(accntMapNewRow);
                }else if(editMode!=null && (editMode.equalsIgnoreCase("edit"))){
                    String accCode=getAccountCode();
                    if(accCode!=null){                    
                        accntVOMap.clearCache();
                        accntVOMap.setWhereClause(null);
                        accntVOMap.setWhereClause("acc_code = '"+accCode+"'");
                        accntVOMap.executeQuery(); 
                        AccountMapMstVORowImpl accntMapMstRow = (AccountMapMstVORowImpl)accntVOMap.first();
                        if(accntMapMstRow!=null){
                            accntMapMstRow.setacccode(accountCode);
                            accntMapMstRow.setUpdatedby(httpSession.getAttribute("loggedinUserid").toString());
                            accntMapMstRow.setUpdateddate(sqlDate);    
                        }          
                    }
                }
                
                if (result.equals("pass")) {               
                OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
                opBindingDoc.execute();                
                if(opBindingDoc.getErrors().isEmpty()){
                    accntVO1.executeQuery();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Account Master details saved Successfully",genMsg.getMessage("311",lngCode)));    
                }
               }else{
                     //getBindings().getOperationBinding("doRollback").execute();
                     accntVO1.executeQuery();
                     setHide(false);                 
                     ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
                     AdfFacesContext.getCurrentInstance().addPartialTarget(accntIdTable); 
                    return "true";
              }
                return "false";
            }
    

    public void cancelAccntChanges(ActionEvent actionEvent) {
                // Add event code here...
                getBindings().getOperationBinding("doRollback").execute();
            }

    public String doEditAccntMst() {
        logger.info("doEditAccntMst");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        editMode="edit";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditAccnt");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();
        String acccode = (String)opBinding.getResult();
        setAccountCode(acccode);
        setEnabled(Boolean.TRUE);
        accntIdButton.setRendered(Boolean.TRUE);
        //If no data exists in Table
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("AccountMstVO1Iterator").getEstimatedRowCount()>0)){
            pageflowScope.put("setvisible", false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }            
        return null;
    }

    public String doViewAccntMst() {
        logger.info("doViewAccntMst");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        editMode="view";
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditAccnt");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
        setEnabled(Boolean.FALSE);
        accntIdButton.setRendered(Boolean.TRUE);
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("AccountMstVO1Iterator").getEstimatedRowCount()>0)){
            pageflowScope.put("setvisible", false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }   
        return null;
    }
    
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("AccountMstVO2Iterator");
        ViewObject accntVO = dcIteratorBinding.getViewObject();
        AccountMstVORowImpl accntRow = (AccountMstVORowImpl)accntVO.getCurrentRow();
        if (accntRow != null) {            
            Object accountCode = accntRow.getacccode();
            logger.info("Account Code checking the value in Submit Action..." + accountCode);
            if(accountCode == null || accountCode.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Account Code", genMsg.getMessage("312",lngCode)));    
                result = "fail";    
            }
            Object accountType = accntRow.getacctype();
            logger.info("Account Type..." + accountType);
            if(accountType == null || accountType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select Account Type", genMsg.getMessage("313",lngCode)));    
                result = "fail";    
            }
            Object accountDesc = accntRow.getaccdesc();
            logger.info("Account Description..." + accountDesc);
            if(accountDesc == null || accountDesc.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Account Description", genMsg.getMessage("314",lngCode)));    
                result = "fail";    
            }    
            Object RevGroup = accntRow.getRevGrpCode();
                if(RevGroup == null || RevGroup.equals("")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Revenue Group ", "Please enter Revenue Group "));    
                    result = "fail";    
                }   
            Object RevType = accntRow.getRevTypeCode();
            if(RevType == null || RevType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Revenue Type ", "Please enter Revenue Type. "));    
                result = "fail";    
            }  
        }
        return result;
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

    public void setSubmitButton(RichCommandButton submitButton) {
        this.submitButton = submitButton;
    }

    public RichCommandButton getSubmitButton() {
        return submitButton;
    }

    public void setCancelButton(RichCommandButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public RichCommandButton getCancelButton() {
        return cancelButton;
    }

    public void setAccntIdButton(RichInputText accntIdButton) {
        this.accntIdButton = accntIdButton;
    }

    public RichInputText getAccntIdButton() {
        return accntIdButton;
    }

    public void setAccntIdTable(RichTable accntIdTable) {
        this.accntIdTable = accntIdTable;
    }

    public RichTable getAccntIdTable() {
        return accntIdTable;
    }
    
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountCode() {
        return accountCode;
    }
}
