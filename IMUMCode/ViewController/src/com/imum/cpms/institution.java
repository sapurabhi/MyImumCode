package com.imum.cpms;

import com.imum.cpms.model.constants.cpmsConstants;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.javatools.resourcebundle.BundleFactory;

public class institution {
    private RichInputText institutionID;
    private RichInputText institutionName;
    private RichInputText tradeLicenseNumber;
    private RichInputText towTeeqNumber;
    private RichInputText utilityBillNumber;
    private RichInputText institutionType;
    private RichInputText addressLine1;
    private RichInputText addressLine2;
    private RichInputText addressLine3;
    private RichInputText postBoxNumber;
    private RichSelectOneChoice sector;
    private RichSelectOneChoice zone;
    private RichSelectOneChoice city;
    private RichSelectOneChoice country;
    private RichInputText landLineNumber;
    private RichInputText faxNumber;
    private RichInputText primaryContactNumber;
    private RichInputText emailId;
    private RichSelectOneChoice activeFlag;
    static ResourceBundle resourceBundle=null;
    public static final String RESOURCE_BUNDLE_NAME = cpmsConstants.Cpms_Properties_File_Name;
    private boolean visible=true;


    public institution() {
        super();
    }
    static{
        try{
            resourceBundle = BundleFactory.getBundle(RESOURCE_BUNDLE_NAME);
            if(null == resourceBundle) 
                System.out.println("this is ty block");
            }catch(Exception e) {
                System.out.println("this is catch block");
            }
        }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    /**
     * @param institutionID
     */
    public void setInstitutionID(RichInputText institutionID) {
        this.institutionID = institutionID;
    }

    public RichInputText getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionName(RichInputText institutionName) {
        this.institutionName = institutionName;
    }

    public RichInputText getInstitutionName() {
        return institutionName;
    }

    public void setTradeLicenseNumber(RichInputText tradeLicenseNumber) {
        this.tradeLicenseNumber = tradeLicenseNumber;
    }

    public RichInputText getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }

    public void setTowTeeqNumber(RichInputText towTeeqNumber) {
        this.towTeeqNumber = towTeeqNumber;
    }

    public RichInputText getTowTeeqNumber() {
        return towTeeqNumber;
    }

    public void setUtilityBillNumber(RichInputText utilityBillNumber) {
        this.utilityBillNumber = utilityBillNumber;
    }

    public RichInputText getUtilityBillNumber() {
        return utilityBillNumber;
    }

    public void setInstitutionType(RichInputText institutionType) {
        this.institutionType = institutionType;
    }

    public RichInputText getInstitutionType() {
        return institutionType;
    }

    public void setAddressLine1(RichInputText addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public RichInputText getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine2(RichInputText addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public RichInputText getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine3(RichInputText addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public RichInputText getAddressLine3() {
        return addressLine3;
    }

    public void setPostBoxNumber(RichInputText postBoxNumber) {
        this.postBoxNumber = postBoxNumber;
    }

    public RichInputText getPostBoxNumber() {
        return postBoxNumber;
    }

    public void setSector(RichSelectOneChoice sector) {
        this.sector = sector;
    }

    public RichSelectOneChoice getSector() {
        return sector;
    }

    public void setZone(RichSelectOneChoice zone) {
        this.zone = zone;
    }

    public RichSelectOneChoice getZone() {
        return zone;
    }

    public void setCity(RichSelectOneChoice city) {
        this.city = city;
    }

    public RichSelectOneChoice getCity() {
        return city;
    }

    public void setCountry(RichSelectOneChoice country) {
        this.country = country;
    }

    public RichSelectOneChoice getCountry() {
        return country;
    }

    public void setFaxNumber(RichInputText faxNumber) {
        this.faxNumber = faxNumber;
    }

    public RichInputText getFaxNumber() {
        return faxNumber;
    }

    public void setPrimaryContactNumber(RichInputText primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
    }

    public RichInputText getPrimaryContactNumber() {
        return primaryContactNumber;
    }

    public void setEmailId(RichInputText emailId) {
        this.emailId = emailId;
    }

    public RichInputText getEmailId() {
        return emailId;
    }

    public void setActiveFlag(RichSelectOneChoice activeFlag) {
        this.activeFlag = activeFlag;
    }

    public RichSelectOneChoice getActiveFlag() {
        return activeFlag;
    }

    public String doNew() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("CreateInsert1");
        Object result = operationBinding.execute();
        setVisible(Boolean.TRUE);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    /**
     * @return
     */
    public String doSubmit() {
        if(null== this.getInstitutionName()) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            String msg = resourceBundle.getString(cpmsConstants.Inst_Name);
            fctx.addMessage(null,new FacesMessage(msg));

        }else{
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        
        }
        return null;
    }


    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return
     */
    public boolean isVisible() {
        return visible;
    }
}
