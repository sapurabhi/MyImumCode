package com.imum.cpms;

import com.imum.cpms.model.masters.vo.RemovalTruckMstVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTIssuanceVORowImpl;

import com.imum.cpms.util.MessageUtil;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import com.sun.rowset.internal.Row;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

public class RemovalTruckMstBean {
    
    private boolean hide = true;
    private boolean enabled = true;
    private RichCommandButton submitButton;
    private RichCommandButton cancelButton;
    public static final ADFLogger logger = ADFLogger.createADFLogger(RemovalTruckMstBean.class);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private RichInputText truckIdButton;
    private RichTable truckTable;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private RichInputText moblienumber;

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public RemovalTruckMstBean() {
        if(lngCode==null || lngCode.equals(""))
         {
          lngCode = "EN";
         }
    }

    public String doNewTruckMst() {
        // Add event code here...
        logger.info("doNewTruckMst");
        setHide(Boolean.FALSE);             
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNewTruck");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        logger.info("success"); 
        truckIdButton.setRendered(Boolean.FALSE);
        if(!isEnabled())
            setEnabled(Boolean.TRUE);
        return null;
    }
    
    public String submitTruckChanges(ActionEvent actionEvent) {
                String result = validateDataOnSubmit();
                DCBindingContainer bindings =(DCBindingContainer)getBindings();
                DCIteratorBinding dcItteratorBindings =bindings.findIteratorBinding("RemovalTruckMstVO1Iterator");
                ViewObject removalTruckVO = dcItteratorBindings.getViewObject();
                if (result.equals("pass")) {               
                OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
                opBindingDoc.execute();                
                if(opBindingDoc.getErrors().isEmpty()){
                    removalTruckVO.executeQuery();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("90",lngCode)));    
                }
               }else{
                     getBindings().getOperationBinding("doRollback").execute();
                     removalTruckVO.executeQuery();
                     setHide(false);                 
                     ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
                     AdfFacesContext.getCurrentInstance().addPartialTarget(truckTable); 
                    return "true";
              }
                return "false";
            }
    
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("RemovalTruckMstVO2Iterator");
        ViewObject removalTruckVO = dcIteratorBinding.getViewObject();
        RemovalTruckMstVORowImpl removalTruckRow = (RemovalTruckMstVORowImpl)removalTruckVO.getCurrentRow();
        if (removalTruckRow != null) {            
            Object plateCountry = removalTruckRow.getPlateCountryID();
            logger.info("Plate Country checking the value in Submit Action..." + plateCountry);
            if(plateCountry == null || plateCountry.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("91",lngCode)));    
                result = "fail";    
            }
            Object plateCategory = removalTruckRow.getPLATECTGID();
            logger.info("Plate Category..." + plateCategory);
            if(plateCategory == null || plateCategory.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("92",lngCode)));    
                result = "fail";    
            }
            Object plateType = removalTruckRow.getPLATETYPEID();
            logger.info("Plate Type..." + plateType);
            if(plateType == null || plateType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("93",lngCode)));    
                result = "fail";    
            }   
            Object type = removalTruckRow.getVHCLTYPE();
            Object mobli = removalTruckRow.getmobilenum();
            System.out.println(type);
            if(type!=null) {
                if(type.equals("C"))
                {
                if(mobli == null || mobli.equals("")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Mobile Number.", null));     
                    result = "fail";    
                   
                }
                }
            }
            
            
            
        }
        return result;
    }

    public void cancelTruckChanges(ActionEvent actionEvent) {
                // Add event code here...
                getBindings().getOperationBinding("doRollback").execute();
            }

    public String doEditTruckMst() {
        logger.info("doEditTruckMst");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        moblienumber.setVisible(true);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditTruck");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();
        //If no data exists in Table
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("RemovalTruckMstVO1Iterator").getEstimatedRowCount()>0)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }       
        setEnabled(Boolean.TRUE);
        truckIdButton.setRendered(Boolean.TRUE);
      
        return null;
    }

    public String doViewTruckMst() {
        logger.info("doViewTruckMst");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditTruck");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("RemovalTruckMstVO1Iterator").getEstimatedRowCount()>0)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }   
        setEnabled(Boolean.FALSE);
        truckIdButton.setRendered(Boolean.TRUE);
        return null;
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

    public void setTruckIdButton(RichInputText truckIdButton) {
        this.truckIdButton = truckIdButton;
    }

    public RichInputText getTruckIdButton() {
        return truckIdButton;
    }

    public void setTruckTable(RichTable truckTable) {
        this.truckTable = truckTable;
    }

    public RichTable getTruckTable() {
        return truckTable;
    }

    public void vhecltypeVC(ValueChangeEvent valueChangeEvent) {
        int i;
        Object newValue = valueChangeEvent.getNewValue();
        System.out.println(newValue);
        if(newValue!=null)
        {
        i=Integer.parseInt(newValue.toString()); 
        if(i==0)
        {
        moblienumber.setVisible(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(moblienumber); 
        }
        }
    }

    public void setMoblienumber(RichInputText moblienumber) {
        this.moblienumber = moblienumber;
    }

    public RichInputText getMoblienumber() {
        return moblienumber;
    }
}
