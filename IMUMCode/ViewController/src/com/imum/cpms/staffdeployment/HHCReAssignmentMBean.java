package com.imum.cpms.staffdeployment;

import com.imum.cpms.model.staffdeploy.vo.HHCNewReRowImpl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

import oracle.jbo.server.ViewObjectImpl;
import com.imum.cpms.model.staffdeploy.vo.HHCNewReRowImpl;

import com.imum.cpms.model.staffdeploy.vo.PIUserMstUVORowImpl;
import com.imum.cpms.util.MessageUtil;

import java.util.Date;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.OperationBinding;
import oracle.binding.BindingContainer;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;


import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;


import oracle.jbo.server.ViewObjectImpl;

public class HHCReAssignmentMBean {


    private RichInputDate date;
    private RichInputText hhcassignId;
    private RichInputText replacementHHCID;
    DCBindingContainer bindingsAM =
        (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichInputText comments;
    private RichInputDate hhCDate;
    private RichInputText piIDNew;
    private Date currentDate = new Date();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    MessageUtil genMsg = new MessageUtil();
    public static final ADFLogger logger = ADFLogger.createADFLogger(HHCReAssignmentMBean.class);
    private RichInputText printerId;

    public HHCReAssignmentMBean() {
    }
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String cb1_action2() {
        logger.info("Start cb1_action2 Method of HHCReAssignmentMBean ");
        String pi_id = null;
        if(getPiIDNew().getValue() != null)
        {
         pi_id = this.getPiIDNew().getValue().toString();
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("474",lgCode)));
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI ID "));
        }
        
        String stDate = null;
        if(getHhCDate().getValue() != null)
         stDate = this.getHhCDate().getValue().toString();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
       // System.out.println(pi_id+"----------"+stDate);
        
        DCBindingContainer bindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding op = (OperationBinding) bindingContainer.getOperationBinding("validatePIID");
        op.getParamsMap().put("date", stDate);
        op.getParamsMap().put("PIID", pi_id);
        String result = (String)op.execute();
        if(result == "Failure")
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("482",lgCode)));
          //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "HHC ID is not allocated to this PI "));
       
        if(result == "Success"){
         //   System.out.println("After Successfull ViewObject");
            // fm = new FacesMessage("PI is Assigned Success");
            BindingContainer bindingsxec = getBindings();
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("HHCNewRe1Iterator");
            ViewObjectImpl HHCVo = (ViewObjectImpl)dcItterator.getViewObject();
            HHCVo.setWhereClause("PI_ID = '"+pi_id+"'");
            HHCVo.executeQuery();
            int rowcount = HHCVo.getRowCount();
           // System.out.println("rowcount"+rowcount);
            HHCNewReRowImpl HHcRow = (HHCNewReRowImpl)HHCVo.last();
            if(HHcRow != null)
            {
            String HHCId = (String)HHcRow.getAttribute("HHCID");
           // System.out.println("HHCId"+HHCId);
          //this.setHhcAssignId(  (RichInputText)HHcRow.getAttribute("HHCID"));
            this.getHhcassignId().setValue(HHCId);
            }
          
            
            
           
         
    //            if (!operationBinding.getErrors().isEmpty()) {
    //            return null;
    //            }
               
               
        }
//        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//        FacesContext fctx = FacesContext.getCurrentInstance();
//        fctx.addMessage(null, fm);
        logger.info("End cb1_action2 Method of HHCReAssignmentMBean ");
        return null;
    }

    public void setReplacementHHC(RichInputText replacementHHC) {
        this.replacementHHCID = replacementHHC;
    }
    public void Back(ActionEvent actionEvent) {
        // Add event code here...
        pageflowScope.put("Button","Issue");
        DCBindingContainer bindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding op = (OperationBinding) bindingContainer.getOperationBinding("displayHHCdtls");
        Object execute = op.execute();


    }

    public String HHCAssignSave() {
        logger.info("Start HHCAssignSave Method of HHCReAssignmentMBean ");
        String pi_id = null;
        String stDate = this.getHhCDate().getValue().toString();
        String old_hhcID = "";
        if(hhcassignId.getValue()!=null){
         old_hhcID = hhcassignId.getValue().toString();
        }
       if (getPiIDNew().getValue() == null) {
           FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                         "Sample info message",
                                                                         genMsg.getMessage("474",lgCode)));
          return null;
       }
       else{
           pi_id = this.getPiIDNew().getValue().toString();
       }
        if(getHhCDate().getValue() == null)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("483",lgCode)));
            return null;
        }
        if(getReplacementHHCID().getValue()== null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("484",lgCode)));
            return null;
        }
        if(getComments().getValue() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("485",lgCode)));
            return null;
        }
        String assignedstatuss = "Issued";
        String status = "Y";
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            BindingContainer bin = getBindings();
        oracle.binding.OperationBinding opExec =
            (oracle.binding.OperationBinding)bindingContainer.getOperationBinding("CheckUniqueForReassign");
        opExec.getParamsMap().put("checkPIID", pi_id);
        opExec.getParamsMap().put("stDate", sqlDate);
        opExec.getParamsMap().put("assignedstatuss", assignedstatuss);
        opExec.getParamsMap().put("status", status);
        String newHHC = "";
        if(getReplacementHHCID().getValue()!=null){
            newHHC = getReplacementHHCID().getValue().toString();
        }
         opExec.getParamsMap().put("HhcId", newHHC);
        
        String resultforDup = (String)opExec.execute();
        // System.out.println("result :"+resultforDup);
        if(resultforDup!=null){
       
        if(resultforDup.equals("failureHHCID")) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                 "Sample info message",
                                                                                              "HHC Device is already Assigned "));
            return null;
        }
        
        }
        
        OperationBinding OPHHCReplace = (OperationBinding)bindingContainer.getOperationBinding("ReplacementHHC");
        if(getPiIDNew().getValue() != null && getHhCDate().getValue() != null && getReplacementHHCID().getValue() != null && getComments().getValue() != null )
        {
        OPHHCReplace.getParamsMap().put("PIID", pi_id);
         OPHHCReplace.getParamsMap().put("stDate", sqlDate);
        OPHHCReplace.getParamsMap().put("ReplacementId", getReplacementHHCID().getValue().toString());
        
        OPHHCReplace.getParamsMap().put("comments", getComments().getValue().toString());
            OPHHCReplace.getParamsMap().put("oldHHCID", old_hhcID);
        OPHHCReplace.execute();
//            OperationBinding OPHHCCheck = (OperationBinding)bindingContainer.getOperationBinding("checkReAssign"); 
//            OPHHCReplace.getParamsMap().put("PIID", pi_id);
//             OPHHCReplace.getParamsMap().put("stDate", sqlDate);
//          
//            
//            OPHHCReplace.getParamsMap().put("comments", getComments().getValue().toString());
//                OPHHCReplace.getParamsMap().put("oldHHCID", old_hhcID);
//            OPHHCReplace.execute();
            
        
      
        
        BindingContainer bindingsxec = getBindings(); 
      
        OperationBinding OPHHC = (OperationBinding) bindingContainer.getOperationBinding("doCommit");
       
        OPHHC.execute();
        if (OPHHC.getErrors().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("486",lgCode)));
            return null;
        }
        }
        logger.info("End HHCAssignSave Method of HHCReAssignmentMBean ");
        return null;
    }

   

    public void setDate(RichInputDate date) {
        this.date = date;
    }

    public RichInputDate getDate() {
        return date;
    }

    public void setHhcassignId(RichInputText hhcassignId) {
        this.hhcassignId = hhcassignId;
    }

    public RichInputText getHhcassignId() {
        return hhcassignId;
    }

    public void setReplacementHHCID(RichInputText replacementHHCID) {
        this.replacementHHCID = replacementHHCID;
    }

    public RichInputText getReplacementHHCID() {
        return replacementHHCID;
    }

    public void setComments(RichInputText comments) {
        this.comments = comments;
    }

    public RichInputText getComments() {
        return comments;
    }

    public void setHhCDate(RichInputDate hhCDate) {
        this.hhCDate = hhCDate;
    }

    public RichInputDate getHhCDate() {
        return hhCDate;
    }

    public void setPiIDNew(RichInputText piIDNew) {
        this.piIDNew = piIDNew;
    }

    public RichInputText getPiIDNew() {
        return piIDNew;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }


    public String Cancel() {
        // Add event code here...
        setReplacementHHCID(null);
        setComments(null);
        return null;
    }

    public void setPrinterId(RichInputText printerId) {
        this.printerId = printerId;
    }

    public RichInputText getPrinterId() {
        return printerId;
    }
}
