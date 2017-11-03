package com.imum.cpms.view;

import com.imum.cpms.LocationMstBean;
import com.imum.cpms.model.masters.vo.VehicleBlaclListMstUVORowImpl;
import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

import java.util.Date;

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
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class VehicleBlackListMBean {
    private RichShowDetailHeader locationTable;
    private boolean hide = true;
    private boolean enabled = true;
    private RichCommandButton submitButton;
    private RichCommandButton cancelButton;

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private RichInputText locationIdButton;
    private RichInputText bayCount;
    private Integer bayCountValue=0;
    private Integer previousBayCount;
    private String editMode=null;
    private String editLocType=null;
    public static final ADFLogger logger = ADFLogger.createADFLogger(LocationMstBean.class);
    MessageUtil genMsg = new MessageUtil();
    //String lngCode = httpSession.getAttribute("language").toString();
    String lngCode = "EN";

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    private DCBindingContainer getDCBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public VehicleBlackListMBean() {
    }

    public String doNew() {
        // Add event code here...
       // String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNewVehicleBlack");
        opBinding.getParamsMap().put("loggerName","cpms");
        opBinding.execute();
        System.out.println("success"); 
        return null;
    }

    public String doEdit() {
        // Add event code here...
       // setHide(Boolean.FALSE);
        logger.info("doEditWhitelist");
        String userName = httpSession.getAttribute("loggedinUserid").toString();  
        editMode="edit";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditWhitelist");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();
        //setEnabled(Boolean.TRUE); 
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("VehicleBlaclListMstUVO1Iterator").getEstimatedRowCount()>0)){
           // pageflowScope.put("setvisible", false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        } 
          
        //truckIdButton.setRendered(Boolean.TRUE);
     
        return null;
    }

    public String doView() {
        // Add event code here...
        logger.info("doViewWhitelist");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        editMode="view";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditWhitelist");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
//        setHide(Boolean.FALSE);
//        setEnabled(Boolean.FALSE);
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("VehicleBlaclListMstUVO1Iterator").getEstimatedRowCount()>0)){
//            pageflowScope.put("setvisible", false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }
        return null;
    }

    public void SubmitBlackList(ActionEvent actionEvent) {
        // Add event code here...
        String result = validateDataOnSubmit();
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcItteratorBindings =bindings.findIteratorBinding("VehicleBlaclListMstUVO1Iterator");
        ViewObject blacklistvo = dcItteratorBindings.getViewObject();
        if (result.equals("pass")) {    
        //For Varbinary PlateNumber Below Code Programmmatically Insert and Update
      
//        if(editMode!=null){                 
//            if("new".equalsIgnoreCase(editMode)){
//                currentRow = blacklistvo.first();
//            }else if("edit".equalsIgnoreCase(editMode)){
//                currentRow = blacklistvo.getCurrentRow();
//            }
//        }
          VehicleBlaclListMstUVORowImpl   currentRow = (VehicleBlaclListMstUVORowImpl)blacklistvo.getCurrentRow();
          
              
       
        Integer vehColourId=(Integer)currentRow.getVEHCOLOURID();
        Integer vehModelId=(Integer)currentRow.getAttribute("VEHMODELID");     
        Integer vehMakeId=(Integer)currentRow.getAttribute("VEHMAKEID");               
        Integer plateTypeId=(Integer)currentRow.getAttribute("PLATETYPEID");               
        Integer plateCtgId=(Integer)currentRow.getAttribute("PLATECTGID");              
        Integer plateCouId=(Integer)currentRow.getAttribute("PlateCountryID");             
        String plateNo=currentRow.getAttribute("PLATENUMBER").toString();
        Date activeDateFrom=(Date)currentRow.getAttribute("ActiveDateFrom");
        Date activeDateTo=(Date)currentRow.getAttribute("ActiveDateTo");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());   
        String activeFlag=currentRow.getAttribute("Activeflag").toString();
        Timestamp sqlDateActFrom = new java.sql.Timestamp(activeDateFrom.getTime());
        Timestamp sqlDateActTo = new java.sql.Timestamp(activeDateTo.getTime());
        BigDecimal whitelistSeq=null;
        
//        if(editMode!=null){
//            if("new".equalsIgnoreCase(editMode)){
//                whitelistSeq=(BigDecimal)currentRow.getAttribute("Whitelistseq");
//                System.out.println("whitelistSeq in doNewWhitelist is : "+whitelistSeq);
//            }else if("edit".equalsIgnoreCase(editMode)){
//                VehicleBlaclListMstUVORowImpl whitelistRow = (VehicleBlaclListMstUVORowImpl)vo.getCurrentRow();                   
//                whitelistSeq=whitelistRow.getWhitelistseq();
//            }
//        }
        
      
       
      
            // setHide(false);
             ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
             //AdfFacesContext.getCurrentInstance().addPartialTarget(whitelistTable); 
           
        }
       
    }
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("VehicleBlaclListMstUVO2Iterator");
        ViewObject blacklistvo = dcIteratorBinding.getViewObject();
        VehicleBlaclListMstUVORowImpl blacklistvoRow = (VehicleBlaclListMstUVORowImpl)blacklistvo.getCurrentRow();
        if (blacklistvoRow != null) {    
            Object plateNumber = blacklistvoRow.getPLATENUMBER();
            logger.info("Plate Number checking the value in Submit Action..." + plateNumber);
            if(plateNumber == null || plateNumber.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("205", lngCode)));    
                result = "fail";    
            }
            Object plateCountry = blacklistvoRow.getPlateCountryID();
            logger.info("Plate Country checking the value in Submit Action..." + plateCountry);
            if(plateCountry == null || plateCountry.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("91", lngCode)));    
                result = "fail";    
            }
            Object plateCategory = blacklistvoRow.getPLATECTGID();
            logger.info("Plate Category..." + plateCategory);
            if(plateCategory == null || plateCategory.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("92", lngCode)));   
                result = "fail";    
            }
            Object plateType = blacklistvoRow.getPLATETYPEID();
            logger.info("Plate Type..." + plateType);
            if(plateType == null || plateType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("93", lngCode)));   
                result = "fail";    
            } 
            Object vehMake = blacklistvoRow.getVEHMAKEID();
            logger.info("Vehicle Make..." + vehMake);
            if(vehMake == null || vehMake.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("210", lngCode)));   
                result = "fail";    
            }  
            Object vehModel = blacklistvoRow.getVEHMODELID();
            logger.info("Vehicle Model..." + vehModel);
            if(vehModel == null || vehModel.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("211", lngCode)));    
                result = "fail";    
            } 
            Object vehColour = blacklistvoRow.getVEHCOLOURID();
            logger.info("Vehicle Colour..." + vehColour);
            if(vehColour == null || vehColour.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("212", lngCode)));    
                result = "fail";    
            }  
            Date actTo1 = (Date)blacklistvoRow.getActiveDateTo();
            Date actFrom1 = (Date)blacklistvoRow.getActiveDateFrom();
            java.sql.Date actFrom = new java.sql.Date(actFrom1.getTime());
            java.sql.Date sqldate = new java.sql.Date(new Date().getTime());      
            java.sql.Date actTo = new java.sql.Date(actTo1.getTime());
            System.out.println(actFrom);
            System.out.println(sqldate);
            System.out.println(actTo);
            String sfdate=actTo.toString().replaceAll("-","");
            String ssqldate=sqldate.toString().replaceAll("-","");
            String actfrom=actFrom.toString().replaceAll("-","");
            
            logger.info("Vehicle ActDateFrom..." + actFrom);
            if(actFrom == null || actFrom.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Valid From Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            }
            else if(editMode.equals("edit")){
                   
            }
            else if(actfrom.equals(ssqldate)){
                    
            } 
            else if(actFrom.compareTo(sqldate) < 0 ){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid From Date Cannot Be Less Than Current Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            }  
            
            logger.info("Vehicle ActDateTo..." + actTo);
            if(actTo == null || actTo.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Valid To Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            } 
            else if(sfdate.equals(ssqldate)){
                 
            }
            if(editMode.equals("edit")) {
                
                if(actTo.compareTo(actFrom) < 0 && actFrom != null && !actFrom.equals("") && actTo != null && !actTo.equals("")){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid To Date Should Be After Valid From Date", genMsg.getMessage("212000", lngCode)));    
                    result = "fail";    
                }
                
            }
            
            else if(actTo.compareTo(sqldate ) < 0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid To Date Cannot Be Less Than Current Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            } 
            
            if(actTo.compareTo(actFrom) < 0 && actFrom != null && !actFrom.equals("") && actTo != null && !actTo.equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid To Date Should Be After Valid From Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            }
            }
        return result;
    }
    public void cancelWhitelist(ActionEvent actionEvent) {
        getBindings().getOperationBinding("doRollback").execute();
        FacesContext fctx = FacesContext.getCurrentInstance();
      
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        if(userSession.getAttribute("Fromdate")!=null)
        {
        userSession.removeAttribute("Fromdate");
        userSession.removeAttribute("todate");
        userSession.removeAttribute("plateno");
        userSession.removeAttribute("platccid");
        userSession.removeAttribute("plategid");
        userSession.removeAttribute("vehcol");
        userSession.removeAttribute("vehmake");
        userSession.removeAttribute("vehmodel");
        }
    }
}
