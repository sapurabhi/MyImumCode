package com.imum.cpms.transactions;

import com.imum.cpms.util.MessageUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

public class PVTOnHoldReleaseBean {
    public static final ADFLogger logger = ADFLogger.createADFLogger(PVTOnHoldReleaseBean.class);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private String deafultRadioValue ="4";
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private RichInputText eventNotes;

    public PVTOnHoldReleaseBean() {
        if(lngCode==null || lngCode.equals(""))
               {
                   lngCode = "EN";
               }
    }
    
    private int selectedRadioButtonValue =4;
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String updatePvtStatusSubmit(ActionEvent actionEvent) {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        String returValue = "false";
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =  bindingsAM.findIteratorBinding("PVTSearchRVO2Iterator");
        ViewObject spoiledPvtVO = dcItteratorBinding.getViewObject();
        String notes = (String)getEventNotes().getValue();
        int pvtSerachCount =  spoiledPvtVO.getRowCount();
        logger.info("pvtSerachCount::"+pvtSerachCount);
        if(pvtSerachCount ==0) {
            returValue = "true";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("94", lngCode))); 
            return returValue;
        }
        BindingContainer bindings = getBindings();
        OperationBinding opBinding =getBindings().getOperationBinding("updatePvtStatusForReleaseOnHold");
        opBinding.getParamsMap().put("pvtStatus",getSelectedRadioButtonValue());
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("notesEvent",notes);
        opBinding.execute();
        String validationFlag = (String)opBinding.getResult();
        int pvtStatusValue=getSelectedRadioButtonValue();
        
        if(validationFlag!=null && validationFlag.equals("true")){
            if(pvtStatusValue == 4){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("95", lngCode)));  
            }else if(pvtStatusValue == 1){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("287", lngCode))); 
            }
            
        }else{
           OperationBinding opBindingCommit =getBindings().getOperationBinding("commit");
            opBindingCommit.execute();
            if (opBindingCommit.getErrors().isEmpty()) { 
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("96", lngCode)));
                cancelAction();
                logger.info("success"); 
            }else{
                logger.info("Fail"); 
            }
            
        }
          return "";  
    }

    public void radioButtonsValue(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        logger.info("Radio Button New Value:"+valueChangeEvent.getNewValue());
        logger.info("Radio Button Old Value:"+valueChangeEvent.getOldValue());
        String pvtStatus = (String)valueChangeEvent.getNewValue();
        int radioButtonValue = Integer.parseInt(pvtStatus);
        setSelectedRadioButtonValue(radioButtonValue);
        logger.info("radioButton Value:"+radioButtonValue);
    }
    
    public String cancelAction() {
        logger.info("Inside Cancel Action");
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =  bindingsAM.findIteratorBinding("PVTSearchRVO2Iterator");
        ViewObject spoiledPvtVO = dcItteratorBinding.getViewObject();
        spoiledPvtVO.executeEmptyRowSet(); 
        getEventNotes().setValue("");
        return null;
    }


    public void setSelectedRadioButtonValue(int selectedRadioButtonValue) {
        this.selectedRadioButtonValue = selectedRadioButtonValue;
    }

    public int getSelectedRadioButtonValue() {
        return selectedRadioButtonValue;
    }


    public void setDeafultRadioValue(String deafultRadioValue) {
        this.deafultRadioValue = deafultRadioValue;
    }

    public String getDeafultRadioValue() {
        return deafultRadioValue;
    }

    public void setEventNotes(RichInputText eventNotes) {
        this.eventNotes = eventNotes;
    }

    public RichInputText getEventNotes() {
        return eventNotes;
    }
}
