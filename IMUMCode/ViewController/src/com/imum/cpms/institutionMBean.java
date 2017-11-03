package com.imum.cpms;


import com.imum.cpms.model.masters.am.MastersAMImpl;
import com.imum.cpms.model.masters.vo.AddressDetailsUVORowImpl;
import com.imum.cpms.model.masters.vo.CustomerInstitutionVORowImpl;
import com.imum.cpms.model.masters.vo.PermitRuleUVORowImpl;
import com.imum.cpms.model.masters.vo.RuleMaxQuotaVORowImpl;

import com.imum.cpms.util.MessageUtil;
import com.imum.ws.CustomerInstitution.GenAddressDetails;
import com.imum.ws.CustomerInstitution.GenInstitutionMst;
import com.imum.ws.CustomerInstitution.GenericCustomerOrInstitutionCreationInSIBLResponse;
import com.imum.ws.CustomerInstitution.Generic_CustomerOrInstitutionCreationInSIBL;
import com.imum.ws.CustomerInstitution.Generic_customerorinstitutioncreationinsibl_client_ep;

import com.imum.ws.CustomerInstitution.ObjectFactory;

import java.math.BigDecimal;


import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.el.ValueBinding;

import javax.servlet.http.HttpSession;

import javax.xml.bind.JAXBElement;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;


import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;


public class institutionMBean {
    private RichInputText institutionID;
    private RichInputText institutionName;
    private RichInputText tradeLicenseNumber;
    private RichInputText towTeeqNumber;
    private RichInputText institutionType;
    private RichInputText addressLine1;
    private RichInputText addressLine2;
    private RichInputText addressLine3;
    private RichInputText postBoxNumber;
    private RichSelectOneChoice sector;
    private RichSelectOneChoice zone;
    private RichSelectOneChoice city;
    private RichSelectOneChoice country;
    private RichInputText faxNumber;
    private RichInputText primaryContactNumber;
    private RichInputText emailId;
    private RichSelectOneChoice activeFlag;    
    private boolean enabled = true;
    private RichTable instTable;
    private boolean hide = true;
    private RichCommandButton utilityBillNumber;
    private RichShowDetailHeader institutionTable;
    private RichInputText searchUtilityBillNumber;
    private RichCommandButton resetUtilityBillNumber;
    private RichCommandButton submitButton;
    private RichCommandButton resetButton;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
    MessageUtil genMsg = new MessageUtil();
    private RichCommandButton newBtn;
    private RichCommandButton editBtn;
    private RichCommandButton viewBtn;


    public institutionMBean() {
        super();
        if(lngCode==null || lngCode.equals(""))
            {
             lngCode = "EN";
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

    /**
     * @return
     */
    
    public String resetButton_Clicked() {
        setHide(Boolean.TRUE);
        getNewBtn().setVisible(true);
        getEditBtn().setVisible(true);
        getViewBtn().setVisible(true);
        getResetButton().setRendered(false);
        getSubmitButton().setRendered(false);
      return null;
    }
    
    
    //New Functionality Code Starts Here Institution//
    public String doNew() {
        setHide(Boolean.FALSE);
        getNewBtn().setVisible(false);
        getEditBtn().setVisible(false);
        getViewBtn().setVisible(false);
        getResetButton().setRendered(true);
        getSubmitButton().setRendered(true);
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNew");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        setEnabled(Boolean.TRUE);
        ADFContext.getCurrent().getPageFlowScope().put("actionMode", "New");
        return null;
    }
    //New Functionality Code Ends Here Institution//
    
    
    //View Functionality Starts Here Institution//
      public void doView() {
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
             bindingsAM.findIteratorBinding("CustomerInstitutionVO1Iterator");
        ViewObject CusvoTableData = dcItteratorBindings.getViewObject();
        if(CusvoTableData != null)
        {  
            long count =CusvoTableData.getEstimatedRowCount();
            Row CustomerrowSelected = CusvoTableData.getCurrentRow();
            if(CustomerrowSelected != null)
            {
                setHide(Boolean.FALSE);
                getNewBtn().setVisible(false);
                getEditBtn().setVisible(false);
                getViewBtn().setVisible(false);
                String userName = httpSession.getAttribute("loggedinUserid").toString();
                BindingContainer bindings = getBindings();
                OperationBinding opBinding = bindings.getOperationBinding("doEditInstitution");
                opBinding.getParamsMap().put("loggerName",userName);
                opBinding.getParamsMap().put("mode","view");
                opBinding.execute();
                setEnabled(Boolean.FALSE);       
            }else if(count>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select the record to Edit/View", genMsg.getMessage("324", lngCode)));               
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
            }
        }
        
        
    }
    //View Functionality Starts Here Institution//
      
      
  //Edit Functionality Starts Here Institution//
    public void doEditInstitution() {
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
             bindingsAM.findIteratorBinding("CustomerInstitutionVO1Iterator");
        ViewObject CusvoTableData = dcItteratorBindings.getViewObject();
        if(CusvoTableData != null)
        {   
            long count =CusvoTableData.getEstimatedRowCount();
            Row CustomerrowSelected = CusvoTableData.getCurrentRow();
            if(CustomerrowSelected != null)
            {
               setHide(Boolean.FALSE);
               getResetButton().setRendered(true);
               getNewBtn().setVisible(false);
               getEditBtn().setVisible(false);
               getViewBtn().setVisible(false);
               String userName = httpSession.getAttribute("loggedinUserid").toString();
               getSubmitButton().setRendered(true);
               BindingContainer bindings = getBindings();
               OperationBinding opBinding = bindings.getOperationBinding("doEditInstitution");
               opBinding.getParamsMap().put("loggerName",userName);
               opBinding.getParamsMap().put("mode","edit");
               opBinding.execute();
               setEnabled(Boolean.TRUE);
            }else if(count>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select the record to Edit/View", genMsg.getMessage("324", lngCode)));               
            }
            else
            {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));               
            }
        }
        
    }
    //Edit Functionality Starts Here for Institution//

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @return
     */
    
     @WebServiceRef
     private static Generic_customerorinstitutioncreationinsibl_client_ep generic_customerorinstitutioncreationinsibl_client_ep;
    
     //Submit Functionality Starts Here Institution//
    public String doSubmitInstitution() {
        DCBindingContainer bindings =
                              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindings =
                    bindings.findIteratorBinding("CustomerInstitutionVO1Iterator");
                ViewObject PermitRuleVO = dcItteratorBindings.getViewObject();
        String result = (String)validatePermitMaster();
        AdfFacesContext adfctx = null;
                                adfctx = AdfFacesContext.getCurrentInstance();

         if (result.equalsIgnoreCase("pass")) {
       
            OperationBinding opBinding =
                bindings.getOperationBinding("doSubmitInstitution");
            opBinding.execute();
            PermitRuleVO.executeQuery();
            adfctx.addPartialTarget(getInstitutionTable()); 
         
            if (opBinding.getErrors().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                            genMsg.getMessage("223",lngCode) ));    
                setHide(Boolean.TRUE);
                getResetButton().setRendered(false);
                getSubmitButton().setRendered(false);
                getNewBtn().setVisible(true);
                getEditBtn().setVisible(true);
                getViewBtn().setVisible(true);
                DCIteratorBinding dcItteratorDtl = bindings.findIteratorBinding("AddressDetailsUVO1Iterator");
                ViewObject AddressVO = dcItteratorDtl.getViewObject();
                AddressDetailsUVORowImpl AddressRow = (AddressDetailsUVORowImpl)AddressVO.getCurrentRow();
                
                if (ADFContext.getCurrent().getPageFlowScope().get("actionMode") != null && ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New")) {
                    OperationBinding opBindingSequence = bindings.getOperationBinding("updateAddressSequence");
                    opBindingSequence.getParamsMap().put("addressSequence", AddressRow.getADDRESSDTLSEQ());
                    opBindingSequence.execute();
                    System.out.println("Address sequence updated to ..." + AddressRow.getADDRESSDTLSEQ());    
                    ADFContext.getCurrent().getPageFlowScope().put("actionMode", null);
                }
                
                // Calling Webservice to update Siebel database
                
                try {
                                    
                    DCIteratorBinding dcItteratorBinding = bindings.findIteratorBinding("CustomerInstitutionVO2Iterator");
                    ViewObject institutionVO = dcItteratorBinding.getViewObject();
                    CustomerInstitutionVORowImpl institutionRow = (CustomerInstitutionVORowImpl)institutionVO.getCurrentRow();
                
                    System.out.println("WS....START of calling WebService to update Siebel database...");
                    
                    generic_customerorinstitutioncreationinsibl_client_ep = new Generic_customerorinstitutioncreationinsibl_client_ep();
                    Generic_CustomerOrInstitutionCreationInSIBL generic_CustomerOrInstitutionCreationInSIBL = generic_customerorinstitutioncreationinsibl_client_ep.getGeneric_CustomerOrInstitutionCreationInSIBL_pt();
                    
                    GenericCustomerOrInstitutionCreationInSIBLResponse response = new GenericCustomerOrInstitutionCreationInSIBLResponse();
                    
                    GenInstitutionMst genInsitutionMst = new GenInstitutionMst();
                    GenAddressDetails genAddressDetails = new GenAddressDetails();
                    GenInstitutionMst.GenAddressDetailsCollection genAddressDetailsCollection = new GenInstitutionMst.GenAddressDetailsCollection();
                    ObjectFactory objectFactory = new ObjectFactory();
                    
                    genInsitutionMst.setInstId(institutionRow.getINSTID().longValue());
                    
                    JAXBElement<String> institutionName = objectFactory.createGenInstitutionMstInstName(institutionRow.getINSTNAME());
                    genInsitutionMst.setInstName(institutionName);
                    
                    JAXBElement<String> officeNumber = objectFactory.createGenInstitutionMstLandlineNum(institutionRow.getLandlinenum());
                    genInsitutionMst.setLandlineNum(officeNumber);
                    
                    JAXBElement<String> faxNumber = objectFactory.createGenInstitutionMstFaxNum(institutionRow.getFaxnum());
                    genInsitutionMst.setFaxNum(faxNumber);
                    
                    JAXBElement<String> url = objectFactory.createGenInstitutionMstInstUrl(institutionRow.getINSTURL());
                    genInsitutionMst.setInstUrl(url);
                    
                    JAXBElement<String> emailId = objectFactory.createGenInstitutionMstEmailID(institutionRow.getEmailID());
                    genInsitutionMst.setEmailID(emailId);
                    
                    JAXBElement<String> contactName = objectFactory.createGenInstitutionMstPrimaryContact(institutionRow.getPrimarycontact());
                    genInsitutionMst.setPrimaryContact(contactName);
                    
                    JAXBElement<String> activeFlag = objectFactory.createGenCustomerMstActiveFlag(institutionRow.getActiveflag());                                
                    genInsitutionMst.setActiveFlag(activeFlag);
                    
                    JAXBElement<String> createdBy = objectFactory.createGenCustomerMstCreatedBy(institutionRow.getCreatedBy());                                
                    genInsitutionMst.setCreatedBy(createdBy);
                    
                    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(sqlDate);
                    XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
                    genInsitutionMst.setCreatedDate(xmlGregorianCalendar);
                                        
                    genAddressDetails.setAddressDtlSeq(AddressRow.getADDRESSDTLSEQ().longValue());
                    
                    JAXBElement<String> utilityBill = objectFactory.createGenAddressDetailsUtilBillNum(AddressRow.getUTILBILLNUM());                                
                    genAddressDetails.setUtilBillNum(utilityBill);
                    
                    JAXBElement<String> address1 = objectFactory.createGenAddressDetailsAddrLine1(AddressRow.getADDRLINE1());                                
                    genAddressDetails.setAddrLine1(address1);
                    
                    JAXBElement<String> address2 = objectFactory.createGenAddressDetailsAddrLine2(AddressRow.getADDRLINE2());                                
                    genAddressDetails.setAddrLine2(address2);
                    
                    JAXBElement<String> address3 = objectFactory.createGenAddressDetailsAddrLine3(AddressRow.getADDRLINE3());                                
                    genAddressDetails.setAddrLine3(address3);
                    
                    JAXBElement<String> city = objectFactory.createGenAddressDetailsCityCode(AddressRow.getCityCode());                                
                    genAddressDetails.setCityCode(city);
                    
                    JAXBElement<String> country = objectFactory.createGenAddressDetailsCountryCode(AddressRow.getCountrycode());                                
                    genAddressDetails.setCountryCode(country);
                    
                    JAXBElement<String> addressCreatedBy = objectFactory.createGenAddressDetailsCreatedBy(AddressRow.getCreatedBy());                                
                    genAddressDetails.setCreatedBy(addressCreatedBy);
                    
                    genAddressDetails.setCreatedDate(xmlGregorianCalendar);
                    
                    genAddressDetailsCollection.getGenAddressDetails().add(genAddressDetails);
                    
                    genInsitutionMst.setGenAddressDetailsCollection(genAddressDetailsCollection);
                  //  System.out.println("WS....Retrieving address details added...getAddressDtlSeq..." + genInsitutionMst.getGenAddressDetailsCollection().getGenAddressDetails().get(0).getAddressDtlSeq());
                  //  System.out.println("WS....Retrieving address details added...getUtilBillNum..." + genInsitutionMst.getGenAddressDetailsCollection().getGenAddressDetails().get(0).getUtilBillNum().getValue());

                    response = generic_CustomerOrInstitutionCreationInSIBL.genericInstitutionCreationInSIBL(genInsitutionMst); 
                    
                    System.out.println("WS....response.getStatus()...." + response.getStatus());
                    System.out.println("WS....response.getResponseCode()...." + (String)response.getResponseCode().getValue());
                    System.out.println("WS....response.getResponseDesc()...." + (String)response.getResponseDesc().getValue());
                    
                } catch (Exception wse) {
                    System.out.println("WS....Exception occurred while invoking BPEL service to update Siebel DB..." + wse);
                }
                
                System.out.println("WS....END of calling Web Service to update Siebel database...");
                
            }else{
                System.out.println("Error message in DB");
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                            opBinding.getErrors().toString()));    
                               //CustomerInstitution VO Rollback
                                DCIteratorBinding dcItteratorBinding =
                                    bindings.findIteratorBinding("CustomerInstitutionVO1Iterator");                                
                                ViewObject instVO = dcItteratorBinding.getViewObject();                               
                                MastersAMImpl am= (MastersAMImpl)instVO.getApplicationModule();
                                DBTransaction bTransaction = am.getDBTransaction();
                                bTransaction.rollback(); 
                                //Address VO Rollback
                                DCIteratorBinding dcItteratorBindingAddr =
                                    bindings.findIteratorBinding("AddressDetailsUVO1Iterator");
                                ViewObject instVOAddr = dcItteratorBindingAddr.getViewObject();
                                MastersAMImpl amAddr= (MastersAMImpl)instVOAddr.getApplicationModule();
                                DBTransaction bTransactionAddr = amAddr.getDBTransaction();
                                bTransactionAddr.rollback(); 
                               
            }
            
            
             getResetButton().setRendered(false);
             getSubmitButton().setRendered(false);
            setHide(Boolean.TRUE);

         }else{
             System.out.println("validatePermitMaster-Fail");
         }
        
        return null;
    }
    //Submit Functionality Ends Here Institution//
    
    
    
    
    //Code For Validations Starts here//
    public String validatePermitMaster() {
        String result = "pass";
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("CustomerInstitutionVO2Iterator");
        ViewObject docMstHdVO = dcItteratorBinding.getViewObject();
        CustomerInstitutionVORowImpl InstRow =
            (CustomerInstitutionVORowImpl)docMstHdVO.getCurrentRow();
        if (InstRow != null) {
            Object inst_Name = InstRow.getINSTNAME();
            Object Active_Flag = InstRow.getActiveflag();
            
            
          
            
           
            if (inst_Name == null || inst_Name.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("224",lngCode)));
                result = "fail";
            }
            if (Active_Flag == null || Active_Flag.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              "Sample info message",
                                                                              "Active Flag is Mandatory"));
                result = "fail";
            }
            
            
            
  
            DCIteratorBinding dcItteratorDtl =
                bindingsAM.findIteratorBinding("AddressDetailsUVO1Iterator");
            ViewObject AddressVO = dcItteratorDtl.getViewObject();
            if(AddressVO.getRowCount()==0) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("225",lngCode)));
                result = "fail";
            }
            if (AddressVO != null) {
                System.out.println("Detail Row Count : " +
                                   AddressVO.getFetchedRowCount());
                for (int i = 0; i < AddressVO.getFetchedRowCount(); i++) {
                    AddressDetailsUVORowImpl AddressRow =
                        (AddressDetailsUVORowImpl)AddressVO.getRowAtRangeIndex(i);
                    
                    if (AddressRow != null) {
                        Object utility = AddressRow.getUTILBILLNUM();
                        Object Address_Line1 = AddressRow.getADDRLINE1();
                        Object city =AddressRow.getCityCode();
                        Object Country =AddressRow.getCountrycode();
                        
                        
                        if (Address_Line1 == null || Address_Line1.equals("")) {
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "Sample info message",
                                                                                          genMsg.getMessage("226",lngCode)));
                            result = "fail";
                        }
                        if (city == null || city.equals("")) {
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "Sample info message",
                                                                                          genMsg.getMessage("227",lngCode)));
                            result = "fail";
                        }
                        if (Country == null || Country.equals("")) {
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "Sample info message",
                                                                                         genMsg.getMessage("215",lngCode)));
                            result = "fail";
                        }
                        
                    }
                }
            }
           
     
     }
        getResetButton().setRendered(true);
        getSubmitButton().setRendered(true);
        return result;
    }
    //Code For Validations End here//



    public void setInstTable(RichTable instTable) {
        this.instTable = instTable;
    }

    public RichTable getInstTable() {
        return instTable;
    }
     
   


    
    
    
    public void setUtilityBillNumber(RichCommandButton utilityBillNumber) {
        this.utilityBillNumber = utilityBillNumber;
    }

    public RichCommandButton getUtilityBillNumber() {
        return utilityBillNumber;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isHide() {
        return hide;
    }

    public void setInstitutionTable(RichShowDetailHeader institutionTable) {
        this.institutionTable = institutionTable;
    }

    public RichShowDetailHeader getInstitutionTable() {
        return institutionTable;
    }

    public void setSearchUtilityBillNumber(RichInputText searchUtilityBillNumber) {
        this.searchUtilityBillNumber = searchUtilityBillNumber;
    }

    public RichInputText getSearchUtilityBillNumber() {
        return searchUtilityBillNumber;
    }

    public void setResetUtilityBillNumber(RichCommandButton resetUtilityBillNumber) {
        this.resetUtilityBillNumber = resetUtilityBillNumber;
    }

    public RichCommandButton getResetUtilityBillNumber() {
        return resetUtilityBillNumber;
    }

    public String cancelButton_Action() {
        // Add event code here...
        setHide(Boolean.TRUE);
        return null;
    }

    public void setSubmitButton(RichCommandButton submitButton) {
        this.submitButton = submitButton;
    }

    public RichCommandButton getSubmitButton() {
        return submitButton;
    }

    public void setResetButton(RichCommandButton resetButton) {
        this.resetButton = resetButton;
    }

    public RichCommandButton getResetButton() {
        return resetButton;
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
}
