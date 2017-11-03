package com.imum.cpms.view.backing;

import com.imum.cpms.model.masters.vo.ContraventionMstUVORowImpl;

import com.imum.cpms.model.masters.vo.HHDeviceMstUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.ADFUtil;

public class HHDeviceMstBean {
    private RichCommandButton submitBottom;
    private RichCommandButton cancelBottom;
    private RichCommandButton submitTop;
    private RichCommandButton cancelTop;
    private RichCommandButton newBtn;
    private RichCommandButton editBtn;
    private RichCommandButton viewBtn;
    private Boolean isDisabled;
    private RichShowDetailHeader assetForm;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger = ADFLogger.createADFLogger(HHDeviceMstBean.class);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private RichSelectOneRadio assetypeBind;
    private RichSelectOneRadio deviceStatusBind;


    public HHDeviceMstBean() {
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        }
    }
    
   
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String New_action() {
        logger.info("Inside New_Action of HHDeviceMstBean");       
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        //"cpms";
       
       
        OperationBinding operationBinding = bindings.getOperationBinding("addNewAssetMst");
        operationBinding.getParamsMap().put("encoder",userName);
        operationBinding.execute();
       
        setIsDisabled(Boolean.FALSE);
        getAssetForm().setVisible(true);
        getSubmitBottom().setVisible(true);
        getCancelBottom().setVisible(true);
        getSubmitTop().setVisible(true);
        getCancelTop().setVisible(true);
        getNewBtn().setVisible(false);
        getEditBtn().setVisible(false);
        getViewBtn().setVisible(false);
        getDeviceStatusBind().setVisible(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getDeviceStatusBind());
        return null;
    }

    public String Edit_action() {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
            //"vara";
            
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("HHDeviceMstUVO2Iterator");
        ViewObject assetReadOnlyVO = dcItteratorBindings.getViewObject();
        Row rowSelected = (Row)ADFUtil.evaluateEL("#{bindings.HHDeviceMstUVO2Iterator.currentRow}"); 
        //Row rowSelected = assetReadOnlyVO.getCurrentRow();
        if(rowSelected != null)
        {
           Integer deviceId = (Integer)rowSelected.getAttribute("HHId");
            logger.info("Selected DeviceId  in Edit_action is : "+deviceId);
            if(deviceId != null)
            {
                DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("HHDeviceMstUVO1Iterator");
                ViewObject assetFormVO = dcItteratorBinding.getViewObject(); 
                assetFormVO.setWhereClause(null);
                assetFormVO.setWhereClause("HH_Id = "+deviceId);
                assetFormVO.executeQuery();
                HHDeviceMstUVORowImpl contrRow = (HHDeviceMstUVORowImpl)assetFormVO.getCurrentRow();
                if(contrRow != null )
                {
                    contrRow.setUpdatedBy(userName);         
                    contrRow.setUpdatedDate(sqlTime);
                    String assetype=contrRow.getAttribute("assettypecode").toString();
                    String status=contrRow.getAttribute("StatusCode").toString();
                    if(assetype.equalsIgnoreCase("H")){
                        this.assetypeBind.setValue("H");
                    }
                    else{
                        this.assetypeBind.setValue("P");
                    }
                    if(status.equalsIgnoreCase("D")){
                        getDeviceStatusBind().setVisible(true);
                        deviceStatusBind.setValue("D");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(getDeviceStatusBind());
                    }
                    else{
                        getDeviceStatusBind().setVisible(false);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(getDeviceStatusBind());
                    }
                    getAssetForm().setVisible(true);
                    getSubmitBottom().setVisible(true);
                    getCancelBottom().setVisible(true);
                    getSubmitTop().setVisible(true);
                    getCancelTop().setVisible(true);
                    setIsDisabled(Boolean.FALSE);
                    getNewBtn().setVisible(false);
                    getEditBtn().setVisible(false);
                    getViewBtn().setVisible(false);
                }
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("57", lngCode)));            
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode))); 
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("55", lngCode)));        
        }
        return null;
    }

    public String View_action() {
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("HHDeviceMstUVO2Iterator");
        ViewObject assetReadOnlyVO = dcItteratorBindings.getViewObject();
        Row rowSelected = (Row)ADFUtil.evaluateEL("#{bindings.HHDeviceMstUVO2Iterator.currentRow}"); 
        //Row rowSelected = assetReadOnlyVO.getCurrentRow();
        if(rowSelected != null)
        {
            Integer deviceId = (Integer)rowSelected.getAttribute("HHId");
             logger.info("Selected DeviceId  in Edit_action is : "+deviceId);
             if(deviceId != null)
             {
                 DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("HHDeviceMstUVO1Iterator");
                 ViewObject assetFormVO = dcItteratorBinding.getViewObject(); 
                 assetFormVO.setWhereClause(null);
                 assetFormVO.setWhereClause("HH_Id = "+deviceId);
                 assetFormVO.executeQuery();
                 Row asserrow =assetFormVO.getCurrentRow();
                 if(asserrow!=null){
                String assetype=asserrow.getAttribute("assettypecode").toString();
                String status=asserrow.getAttribute("StatusCode").toString();
                if(assetype.equalsIgnoreCase("H")){
                    this.assetypeBind.setValue("H");
                }
                else{
                    this.assetypeBind.setValue("P");
                }
                     if(status.equalsIgnoreCase("D")){
                         getDeviceStatusBind().setVisible(true);
                         deviceStatusBind.setValue("D");
                         AdfFacesContext.getCurrentInstance().addPartialTarget(getDeviceStatusBind());
                     }
                     else if(status.equalsIgnoreCase("A")){
                         getDeviceStatusBind().setVisible(true);
                         deviceStatusBind.setValue("A");
                         AdfFacesContext.getCurrentInstance().addPartialTarget(getDeviceStatusBind());
                     }
                     else{
                         getDeviceStatusBind().setVisible(false);
                         AdfFacesContext.getCurrentInstance().addPartialTarget(getDeviceStatusBind());
                     }
                 }
                getAssetForm().setVisible(true);
                getCancelBottom().setVisible(true);
                getCancelTop().setVisible(true);
                setIsDisabled(Boolean.TRUE);
                getNewBtn().setVisible(false);
                getEditBtn().setVisible(false);
                getViewBtn().setVisible(false);
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("57", lngCode)));            
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode))); 
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("54", lngCode)));        
        }        
        return null;
    }

    public String Submit_action() { 
        String result = validateAssetMst();
        if(result.equals("pass"))
        {
            OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
            operationBinding.execute();  
            if(operationBinding.getErrors().isEmpty())
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("25", lngCode)));         
                DCIteratorBinding dcItteratorBinding =
                    bindingsAM.findIteratorBinding("HHDeviceMstUVO2Iterator");
                dcItteratorBinding.getViewObject().executeQuery();
                getAssetForm().setVisible(false);
                getSubmitBottom().setVisible(false);
                getCancelBottom().setVisible(false);
                getSubmitTop().setVisible(false);
                getCancelTop().setVisible(false);
                getNewBtn().setVisible(true);
                getEditBtn().setVisible(true);
                getViewBtn().setVisible(true);
            }
        }
        return null;
    }

    public String Cancel_action() {
        getAssetForm().setVisible(false);
        getSubmitBottom().setVisible(false);
        getCancelBottom().setVisible(false);
        getSubmitTop().setVisible(false);
        getCancelTop().setVisible(false);
        getNewBtn().setVisible(true);
        getEditBtn().setVisible(true);
        getViewBtn().setVisible(true);
        getBindings().getOperationBinding("doRollback").execute();
        bindingsAM.findIteratorBinding("HHDeviceMstUVO2Iterator").getViewObject().executeQuery();
        return null;
    }
    public String validateAssetMst()
    {
        String result = "pass";
          DCIteratorBinding dcItteratorBinding =
              bindingsAM.findIteratorBinding("HHDeviceMstUVO1Iterator");
          ViewObject assetVO = dcItteratorBinding.getViewObject();
              HHDeviceMstUVORowImpl assetRow = (HHDeviceMstUVORowImpl)assetVO.getCurrentRow();
              if(assetRow != null)
              {
//                  Object code = assetRow.getHHId();
                 Object name = assetRow.getHHModel();
                 Object serialNum = assetRow.getHHSNo();
                 assetRow.setStatusCode("A");
                 String assettype=assetypeBind.getValue().toString();
                 String status=(String)deviceStatusBind.getValue();
                  if(assettype == null )
                  {
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Asset Type is Mandatory"));    
                      result = "fail";    
                  }
                 if(assettype.equalsIgnoreCase("H")){
                     assetRow.setAttribute("assettypecode", "H");
                 }
                 else{
                     assetRow.setAttribute("assettypecode", "P");
                 }
                  /* if(status == null )
                  {
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Device Status is Mandatory"));    
                      result = "fail";    
                  } */
                 if(status!=null){
                  if(status.equalsIgnoreCase("D")){
                     assetRow.setAttribute("StatusCode", "D");
                  }
                  else{
                     assetRow.setAttribute("StatusCode", "A");
                  }
                 }
//                  if(code == null || code.equals(""))
//                  {
//                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Device Id is Mandatory"));    
//                      result = "fail";    
//                  }
                  if(name == null || name.equals(""))
                  {
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("58", lngCode)));    
                      result = "fail";    
                  }
                  if(result.equalsIgnoreCase("pass")&& serialNum == null || serialNum.equals(""))
                  {
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("59", lngCode)));    
                      result = "fail";    
                  }
                  
              }
              return result;
    }

    public void setSubmitBottom(RichCommandButton submitBottom) {
        this.submitBottom = submitBottom;
    }

    public RichCommandButton getSubmitBottom() {
        return submitBottom;
    }

    public void setCancelBottom(RichCommandButton cancelBottom) {
        this.cancelBottom = cancelBottom;
    }

    public RichCommandButton getCancelBottom() {
        return cancelBottom;
    }

    public void setSubmitTop(RichCommandButton submitTop) {
        this.submitTop = submitTop;
    }

    public RichCommandButton getSubmitTop() {
        return submitTop;
    }

    public void setCancelTop(RichCommandButton cancelTop) {
        this.cancelTop = cancelTop;
    }

    public RichCommandButton getCancelTop() {
        return cancelTop;
    }

    public void setNewBtn(RichCommandButton newBtn) {
        this.newBtn = newBtn;
    }

    public RichCommandButton getNewBtn() {
        return newBtn;
    }

    public void setEditBtn(RichCommandButton editBtn) {
        this.editBtn = editBtn;
    }

    public RichCommandButton getEditBtn() {
        return editBtn;
    }

    public void setViewBtn(RichCommandButton viewBtn) {
        this.viewBtn = viewBtn;
    }

    public RichCommandButton getViewBtn() {
        return viewBtn;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setAssetForm(RichShowDetailHeader assetForm) {
        this.assetForm = assetForm;
    }

    public RichShowDetailHeader getAssetForm() {
        return assetForm;
    }

    public void setAssetypeBind(RichSelectOneRadio assetypeBind) {
        this.assetypeBind = assetypeBind;
       
    }

    public RichSelectOneRadio getAssetypeBind() {
        return assetypeBind;
    }


    public void setDeviceStatusBind(RichSelectOneRadio deviceStatusBind) {
        this.deviceStatusBind = deviceStatusBind;
    }

    public RichSelectOneRadio getDeviceStatusBind() {
        return deviceStatusBind;
    }
}
