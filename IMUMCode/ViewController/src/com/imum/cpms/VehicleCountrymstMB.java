package com.imum.cpms;

import com.imum.cpms.model.masters.vo.InvStockReorderLevelDetailsVORowImpl;
import com.imum.cpms.model.masters.vo.VehicleCountrymstVORowImpl;
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

public class VehicleCountrymstMB {
    private boolean hide = true;
    private boolean enabled = true;
    private String editMode=null;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    private RichInputText inactivateseq;
    MessageUtil genMsg = new MessageUtil();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    private RichTable tablebind;
    public VehicleCountrymstMB() {
        if(lngCode==null || lngCode.equals(""))
         {
          lngCode = "EN";
         }
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public void actionNew(ActionEvent actionEvent) {
        setHide(Boolean.FALSE);  
        editMode="new";
        String userName = httpSession.getAttribute("loggedinUserid").toString();
      
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNewVehicleCountry");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        //inactivateseq.setRendered(Boolean.FALSE);
        if(!isEnabled())
            setEnabled(Boolean.TRUE);
    }

    public void actionEdit(ActionEvent actionEvent) {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        editMode="edit";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditVehicleCountry");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();     
        setEnabled(Boolean.TRUE);        
       
    }

    public String actionView() {
        editMode="view";
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditVehicleCountry");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
        setEnabled(Boolean.FALSE);
        return null;
    }
    public ViewObject getVehicleCountrymasterVO() {
        DCBindingContainer bindings=(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding bindingAccnt =bindings.findIteratorBinding("VehicleCountrymstVO2Iterator");
        ViewObject invstock = bindingAccnt.getViewObject();
        return invstock;
    }
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("VehicleCountrymstVO2Iterator");
        ViewObject vehileVO = dcIteratorBinding.getViewObject();
        VehicleCountrymstVORowImpl Row = (VehicleCountrymstVORowImpl)vehileVO.getCurrentRow();
        if (Row != null) {            
                    Object name = Row.getPlateCountryName();
                 if(name == null || name.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Plate Country Name ", null));    
                result = "fail";    
            }
            Object mpark = Row.getmParkPlateCountry();
           
            if(mpark == null || mpark.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select mPark Plate Country ", null));    
                result = "fail";    
            }
                    
           
        }
        return result;
    }
    public void actionSubmit(ActionEvent actionEvent) {
        String result = validateDataOnSubmit();
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        
        ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
        if("pass".equals(result))
        {    
        int seq=0;
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcItteratorBindings =bindings.findIteratorBinding("VehicleCountrymstVO1Iterator");
        ViewObject vehcountryVO = dcItteratorBindings.getViewObject();
        DCIteratorBinding dcItteratorBindings2=bindings.findIteratorBinding("VehicleCountrymstVO2Iterator");
        ViewObject countrymst =getVehicleCountrymasterVO();
        Object ob=dcItteratorBindings.getViewObject().last().getAttribute("PlateCountryID");
           
          
        
        if(ob!=null) {
             seq= Integer.parseInt(ob.toString());
        }
        
        
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        if(editMode!=null && (editMode.equalsIgnoreCase("new"))){
            DCIteratorBinding dcItterator =bindings.findIteratorBinding("VehicleCountrymstVO2Iterator");
            ViewObject vehcountryV1O = dcItterator.getViewObject();
                Row countryRow = vehcountryV1O.getCurrentRow();
            DCIteratorBinding dcItterator1 =bindings.findIteratorBinding("VehicleCountrymstlngVO1Iterator");
            ViewObject vehcountrylngVO = dcItterator1.getViewObject();
                Row countrylngRow = vehcountrylngVO.getCurrentRow();
                countrylngRow.setAttribute("LNGCODE", "EN");
                countrylngRow.setAttribute("PlateCountryName",countryRow.getAttribute("PlateCountryName"));
                countrylngRow.setAttribute("PlateCountryID",seq+1);
                countryRow.setAttribute("CountryOrder", seq+1);
                
            }
        else if(editMode!=null && (editMode.equalsIgnoreCase("edit"))){
            
            int Code=seq;
            VehicleCountrymstVORowImpl Row = (VehicleCountrymstVORowImpl)countrymst.getCurrentRow();
                if(Row!=null){
                    Row.setUpdatedBy(userName);
                    Row.setUpdatedDate(sqlDate);    
                }          
            }                
        
        if (result.equals("pass")) {               
        OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
        opBindingDoc.execute();                
        if(opBindingDoc.getErrors().isEmpty()){
            vehcountryVO.executeQuery();
            ADFContext.getCurrent().getPageFlowScope().put("setvisible", "false");
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Details Saved Successfully",null));    
        }
        }else{
             getBindings().getOperationBinding("doRollback").execute();
             vehcountryVO.executeQuery();
             setHide(false);                 
             ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
             AdfFacesContext.getCurrentInstance().addPartialTarget(tablebind); 
        
        }
        }
    }

    public void actionCancel(ActionEvent actionEvent) {
        getBindings().getOperationBinding("doRollback").execute();
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

    public void setTablebind(RichTable tablebind) {
        this.tablebind = tablebind;
    }

    public RichTable getTablebind() {
        return tablebind;
    }
}
