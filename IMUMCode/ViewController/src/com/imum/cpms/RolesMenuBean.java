package com.imum.cpms;

import com.imum.cpms.model.masters.vo.ContraventionMstUVORowImpl;
import com.imum.cpms.model.masters.vo.GenMsgMstVOImpl;
import com.imum.cpms.model.masters.vo.GenRoleUVORowImpl;
import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;

import com.imum.cpms.util.MessageUtil;
import com.imum.cpms.util.Shuttle;

import java.sql.Date;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

public class RolesMenuBean {
    private RichInputDate inactiveDate;
    private RichInputDate activeDate;

    public RolesMenuBean() {
        if(selectedLang==null || selectedLang.equals(""))
        {
            selectedLang = "EN";
        } 
    }
    private RichShowDetailHeader roleseMenuTable;
    private boolean hide = true;
    private boolean enabled = true;
    private RichCommandButton submitButton;
    private RichCommandButton cancelButton;
  

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    public static final ADFLogger logger = ADFLogger.createADFLogger(RolesMenuBean.class);
    MessageUtil mesageUtil = new MessageUtil();
    String selectedLang = httpSession.getAttribute("language").toString();
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    

    public String doViewRolesMenuMst() {
        
        logger.info("::::   doViewRolesMenuMst   :::::::");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditRolesMenuMst");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
        setEnabled(Boolean.FALSE);
        return null;
    }

    public String doEditRolesMenuMst() {
        
        logger.info(" ::::   doEditRolesMenuMst   ::::   ");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditRolesMenuMst");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();
        setEnabled(Boolean.TRUE);
        return null;
    }
    
    
    public String doNewRolesMenuMst() {
        logger.info("doNewRolesMenuMst");
        setHide(Boolean.FALSE);             
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNewRolesMenuMst");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        logger.info("success"); 
        if(!isEnabled())
            setEnabled(Boolean.TRUE);
        return null;
    }
    
    public String submitRolesMenuChanges(ActionEvent actionEvent) {
        String result = "pass";
//        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        DCIteratorBinding dcItteratorBinding =  bindingsAM.findIteratorBinding("GenRoleUVO2Iterator");
//        ViewObject genRoleVO = dcItteratorBinding.getViewObject();
//        GenRoleUVORowImpl genRoleRow = (GenRoleUVORowImpl)genRoleVO.getCurrentRow();
//        Date activeDate = genRoleRow.getActivatedate();
//        Date  inctiveDate = genRoleRow.getInactivedate();
//        java.sql.Date sysDate = new java.sql.Date(new java.util.Date().getTime());
//        java.sql.Date SysDate = java.sql.Date.valueOf(sysDate.toString());
        
//        if(activeDate.compareTo(SysDate) < 0) 
//        {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",mesageUtil.getMessage("274", selectedLang)));    
//            setHide(false);
//            ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
//            return "fail";
//        }
//        if(inctiveDate.compareTo(SysDate) < 0) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",mesageUtil.getMessage("275", selectedLang)));    
//            ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
//            setHide(false);
//            return "fail";
//        }
//        
    
        OperationBinding operationMenuRole = getBindings().getOperationBinding("MenuRoleCommit"); 
        operationMenuRole.execute();
        if(operationMenuRole.getErrors().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",mesageUtil.getMessage("132", selectedLang)));    
        }
        return result;
    }
    
    
    public void cancelRolesMenuChanges(ActionEvent actionEvent) {
       getBindings().getOperationBinding("MenuRoleRollback").execute();            
   }
    

    public List<SelectItem> getAllMenus() {
        return Shuttle.getAll("MenuMstRVO1Iterator", "MenuID",
                              "MenuDefinition");
    }

    public List getSelectedMenus() {
        return Shuttle.getSelected("GenMenuRoleUVO3Iterator",
                                   "MenuID");
    }

    public void setSelectedMenus(List selectedValues) {
        String clickedButtonVal =(String)ADFContext.getCurrent().getPageFlowScope().get("clickedButton");
        Shuttle.setSelected(selectedValues, "RoleID",
                            "GenMenuRoleUVO3Iterator", "RoleID",
                            "MenuID", "Delete", "CreateInsert",clickedButtonVal);
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

    public void setRoleseMenuTable(RichShowDetailHeader roleseMenuTable) {
        this.roleseMenuTable = roleseMenuTable;
    }

    public RichShowDetailHeader getRoleseMenuTable() {
        return roleseMenuTable;
    }

    public void setInactiveDate(RichInputDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public RichInputDate getInactiveDate() {
        return inactiveDate;
    }

    public void setActiveDate(RichInputDate activeDate) {
        this.activeDate = activeDate;
    }

    public RichInputDate getActiveDate() {
        return activeDate;
    }

    public void activeValueChangeListner(ValueChangeEvent valueChangeEvent) {
        System.out.println("Calling :::::         ");
        java.sql.Date sysDate = new java.sql.Date(new java.util.Date().getTime());
        Boolean checkValue =   (Boolean)valueChangeEvent.getNewValue();
        if(checkValue !=null && checkValue) {
             System.out.println("Calling :::::  TRUE       ");
             inactiveDate.setValue(null);
             activeDate.setValue(sysDate);
         }else {
            System.out.println("Calling :::::    FALSE     ");
            inactiveDate.setValue(sysDate);
            activeDate.setValue(null);
        }
      
    }
}
