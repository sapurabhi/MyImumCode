package com.imum.cpms.transactions.pvt;

import com.imum.cpms.model.transactions.vo.PVTIssuanceVORowImpl;

import com.imum.cpms.util.MessageUtil;
import com.imum.ws.PVTIssuance.ObjectFactory;
import com.imum.ws.PVTIssuance.PVTHHCRequestLog;
import com.imum.ws.PVTIssuance.PVTObservationOrIssuanceResponse;
import com.imum.ws.PVTIssuance.PVT_ObservationOrIssuance;
import com.imum.ws.PVTIssuance.Pvt_observationorissuance_client_ep;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class PVTIssuanceMBean {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    
    private RichInputText pvtnumber;
    private RichInputText vehgeolongitude;
    private RichInputText vehgeolatitude;
    private RichInputText platenumber;
    private RichSelectOneChoice platecategory;
    private RichSelectOneChoice platetype;
    private RichSelectOneChoice contraventioncode;
    private RichSelectOneChoice sector;
    private RichSelectOneChoice vehiclemake;
    private RichSelectOneChoice vehiclemodel;
    private RichSelectOneChoice vehiclecolor;
    DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichSelectOneChoice tarifftype;
    private RichSelectOneChoice platecountry;
    private RichSelectOneChoice zone;
    private RichInputDate pvtissuancedate;
    private RichSelectOneChoice contraventiondesc;
    private RichInputDate test;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    //BindingContainer bindings = getBindings();
    
    public PVTIssuanceMBean() {
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        }
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    @WebServiceRef
    private static Pvt_observationorissuance_client_ep pvt_observationorissuance_client_ep;
    
    public String callWebServiceOnSubmitAction() {
        String result = validateDataOnSubmit();
        if (result.equals("pass")) {
            
            // Calling Webservice for PVT Issuance
            
            try {
                                
                DCIteratorBinding dcItteratorBinding = bindings.findIteratorBinding("PVTIssuanceVO1Iterator");
                ViewObject pvtIssuanceVO = dcItteratorBinding.getViewObject();
                PVTIssuanceVORowImpl pvtIssuanceVORowImpl = (PVTIssuanceVORowImpl)pvtIssuanceVO.getCurrentRow();
            
                System.out.println("WS....START of calling WebService for PVT issuance...");
            
                pvt_observationorissuance_client_ep = new Pvt_observationorissuance_client_ep();
                PVT_ObservationOrIssuance pVT_ObservationOrIssuance = pvt_observationorissuance_client_ep.getPVT_ObservationOrIssuance_pt();
                
                PVTObservationOrIssuanceResponse pvtObservationOrIssuanceResponse = new PVTObservationOrIssuanceResponse();
                
                PVTHHCRequestLog pvtHHCRequestLog = new PVTHHCRequestLog();
                
                ObjectFactory objectFactory = new ObjectFactory();
                
                JAXBElement<String> pvtNumber = objectFactory.createPVTHHCRequestLogPVTNum(pvtIssuanceVORowImpl.getPVTNumber().toString());
                pvtHHCRequestLog.setPVTNum(pvtNumber);
                
                pvtHHCRequestLog.setPlateNumber(pvtIssuanceVORowImpl.getPlateNumber());
                
                pvtHHCRequestLog.setPlateTypeId(Integer.parseInt(pvtIssuanceVORowImpl.getPlateType()));
                
                pvtHHCRequestLog.setPlateCtgId(pvtIssuanceVORowImpl.getPlateCategory());
                
                pvtHHCRequestLog.setContraCode(pvtIssuanceVORowImpl.getContraventionCode());
                
                pvtHHCRequestLog.setSectorCode(pvtIssuanceVORowImpl.getSector());
                
                if (pvtIssuanceVORowImpl.getVehicleGeoLatitude() != null) {
                    pvtHHCRequestLog.setVEHGeoLat(Double.parseDouble(pvtIssuanceVORowImpl.getVehicleGeoLatitude().toString()));
                } else {
                    pvtHHCRequestLog.setVEHGeoLat(Double.parseDouble("54.5849"));
                }                
                //  System.out.println("getVEHGeoLat..." + pvtHHCRequestLog.getVEHGeoLat());
                
                if (pvtIssuanceVORowImpl.getVehicleGeoLongitude() != null) {
                    pvtHHCRequestLog.setVEHGeoLon(Double.parseDouble(pvtIssuanceVORowImpl.getVehicleGeoLongitude().toString()));
                } else {
                    pvtHHCRequestLog.setVEHGeoLon(Double.parseDouble("24.3291"));
                }
                //  System.out.println("getVEHGeoLon..." + pvtHHCRequestLog.getVEHGeoLon());
                
                pvtHHCRequestLog.setVehMakeId(pvtIssuanceVORowImpl.getVehicleMake());
                
                //pvtHHCRequestLog.setVehModelId(Integer.parseInt(pvtIssuanceVORowImpl.getVehicleModel()));
                
                pvtHHCRequestLog.setVehColourId(Integer.parseInt(pvtIssuanceVORowImpl.getVehicleColor()));
                
                pvtHHCRequestLog.setHHCSerialNum("0");
                
                pvtHHCRequestLog.setTariffID(pvtIssuanceVORowImpl.getTariffType());
                System.out.println("Tariff Type..." + pvtIssuanceVORowImpl.getTariffType());
                
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(sqlDate);
                XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
                pvtHHCRequestLog.setCreatedDate(xmlGregorianCalendar);
                
                pvtHHCRequestLog.setRequestType("P");
                pvtHHCRequestLog.setObsrvFrom(xmlGregorianCalendar);
                pvtHHCRequestLog.setPiId("0");
                                
                java.sql.Date sqlDateIssue = new java.sql.Date(pvtIssuanceVORowImpl.getPVTIssuanceDate().getTime());
                GregorianCalendar gregorianCalendarIssue = new GregorianCalendar();
                gregorianCalendarIssue.setTime(sqlDateIssue);
                XMLGregorianCalendar xmlGregorianCalendarIssue = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendarIssue);
                JAXBElement<XMLGregorianCalendar> pvtIssDatetime = objectFactory.createPVTHHCRequestLogPvtIssDatetime(xmlGregorianCalendarIssue);
                pvtHHCRequestLog.setPvtIssDatetime(pvtIssDatetime);
                
                JAXBElement<Integer> localAuthId = objectFactory.createPVTHHCRequestLogLocalAuthId(1);
                pvtHHCRequestLog.setLocalAuthId(localAuthId);
                pvtHHCRequestLog.setRequestDateTime(xmlGregorianCalendar);
                
                String userName = httpSession.getAttribute("loggedinUserid").toString();
                if (userName == null || userName.equals("")) {
                    userName = "anonymous";
                }
                pvtHHCRequestLog.setCreatedBy(userName);
                
                OperationBinding contraAmountOB = bindings.getOperationBinding("getContraAmtForContraCode");
                contraAmountOB.getParamsMap().put("ContraCode", pvtIssuanceVORowImpl.getContraventionCode());
                BigDecimal ContraAmount = (BigDecimal)contraAmountOB.execute();
                System.out.println("Contra Amount passing to service..." + ContraAmount);
                pvtHHCRequestLog.setContraAmt(ContraAmount);
                
//                OperationBinding plateCategoryOB = bindings.getOperationBinding("getPlateCountryForPlateCategory");
//                plateCategoryOB.getParamsMap().put("PlateCategoryId", pvtIssuanceVORowImpl.getPlateCategory());
//                int PlateCountryId = Integer.parseInt(plateCategoryOB.execute().toString());
//                System.out.println("Plate Country Id passing to service..." + PlateCountryId);
//                pvtHHCRequestLog.setPlateCountryID(PlateCountryId);
                
                pvtHHCRequestLog.setPlateCountryID(pvtIssuanceVORowImpl.getPlateCountry());
                System.out.println("Plate Country Id passing to service..." + pvtIssuanceVORowImpl.getPlateCountry());
                
                pvtHHCRequestLog.setZoneCode(pvtIssuanceVORowImpl.getZone());
                
                pvtObservationOrIssuanceResponse = pVT_ObservationOrIssuance.pvtObservationOrIssuance(pvtHHCRequestLog);
                
                System.out.println("WS..PVT Issuance..response.getStatus()...." + pvtObservationOrIssuanceResponse.getStatus().getValue());
                System.out.println("WS..PVT Issuance..response.getResponseCode()...." + (String)pvtObservationOrIssuanceResponse.getResponseCode().getValue());
                System.out.println("WS..PVT Issuance..response.getResponseDesc()...." + (String)pvtObservationOrIssuanceResponse.getResponseDesc().getValue());
                
                if (pvtObservationOrIssuanceResponse.getStatus().getValue().equalsIgnoreCase("Success")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("214", lngCode) + pvtIssuanceVORowImpl.getPVTNumber().toString()));
                    pvtIssuanceVO.clearCache();
                    PVTIssuanceVORowImpl pvtIssuanceRow = (PVTIssuanceVORowImpl)pvtIssuanceVO.getCurrentRow();
                    if (pvtIssuanceRow != null) {
                        System.out.println("Row exists in VO, removing...");
                        pvtIssuanceRow.remove();
                    }
                    Row createRow = pvtIssuanceVO.createRow();
                    pvtIssuanceVO.insertRow(createRow);
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("199", lngCode))); 
                }
                
            } catch (Exception wse) {
                System.out.println("WS....Exception occurred while invoking BPEL service for PVT Issuance..." + wse);
            }
            
            System.out.println("WS....END of calling Web Service for PVT issuance...");
        }
        return null; 
    }
    
    public String validateDataOnSubmit() {
        String result = "pass";
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTIssuanceVO1Iterator");
        ViewObject pvtIssuanceVO = dcIteratorBinding.getViewObject();
        System.out.println("PVTISSUANCEVO ROWS="+pvtIssuanceVO.getRowCount());
        PVTIssuanceVORowImpl pvtIssuanceRow = (PVTIssuanceVORowImpl)pvtIssuanceVO.getCurrentRow();
        if (pvtIssuanceRow != null) {
            Object pvtNumber = pvtIssuanceRow.getPVTNumber();
         
            System.out.println("PVT Number..." + pvtNumber);
            if(pvtNumber == null || pvtNumber.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("99", lngCode)));    
                result = "fail";    
            }
            if(pvtNumber != null) {
                if (!pvtNumber.toString().startsWith("15") && !pvtNumber.toString().startsWith("AD") ) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("200", lngCode)));
                    result = "fail"; 
                }
               else if (pvtNumber.toString().length() >20) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("201", lngCode)));
                    result = "fail"; 
                }
                BindingContainer bindings = getBindings();
                OperationBinding operationBinding = bindings.getOperationBinding("checkPVTNumberExists");
                operationBinding.getParamsMap().put("pvtNumber", pvtNumber);
                int pvtNumberExistsCount = Integer.parseInt(operationBinding.execute().toString());
                System.out.println("Status after checking exists..." + pvtNumberExistsCount);
                if (pvtNumberExistsCount != 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("202", lngCode)));
                    result = "fail"; 
                }
            }
            Object pvtIssuanceDate = pvtIssuanceRow.getPVTIssuanceDate();
            System.out.println("PVT Issuance Date..." + pvtIssuanceDate);
            if(pvtIssuanceDate == null || pvtIssuanceDate.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("203", lngCode)));    
                result = "fail";    
            }
            if (pvtIssuanceDate != null) {
                Timestamp currentDate = new java.sql.Timestamp(new java.util.Date().getTime());
                Timestamp pvtIssuanceDateConvert = (java.sql.Timestamp)pvtIssuanceDate;
                if (pvtIssuanceDateConvert.after(currentDate)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("204", lngCode)));    
                    result = "fail";    
                } 
            }
            
            Object plateCountry = pvtIssuanceRow.getPlateCountry();
            System.out.println("Plate Country..." + plateCountry);
            if(plateCountry == null || plateCountry.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("91", lngCode)));    
                result = "fail";    
            }
            Object plateCategory = pvtIssuanceRow.getPlateCategory();
            System.out.println("Plate Category..." + plateCategory);
            if(plateCategory == null || plateCategory.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("92", lngCode)));    
                result = "fail";    
            }
            Object plateType = pvtIssuanceRow.getPlateType();
            System.out.println("Plate Type..." + plateType);
            if(plateType == null || plateType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("93", lngCode)));    
                result = "fail";    
            }
            Object plateNumber = pvtIssuanceRow.getPlateNumber();
            System.out.println("Plate Number..." + plateNumber);
            if(plateNumber == null || plateNumber.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("205", lngCode)));    
                result = "fail";    
            }
            Object contraventionCode = pvtIssuanceRow.getContraventionCode();
            System.out.println("Contravention Code..." + contraventionCode);
            if(contraventionCode == null || contraventionCode.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("41", lngCode)));    
                result = "fail";    
            }
            Object sector = pvtIssuanceRow.getSector();
            System.out.println("Sector..." + sector);
            if(sector == null || sector.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("206", lngCode)));    
                result = "fail";    
            }
            Object zone = pvtIssuanceRow.getZone();
            System.out.println("zone..." + zone);
            if(zone == null || zone.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("207", lngCode)));    
                result = "fail";    
            }
            Object vehicleGeoLatitude = pvtIssuanceRow.getVehicleGeoLatitude();
            System.out.println("Vehicle Geo Latitude..." + vehicleGeoLatitude);
//            if(vehicleGeoLatitude == null || vehicleGeoLatitude.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("208", lngCode)));    
//                result = "fail";    
//            }
            Object vehicleGeoLongitude = pvtIssuanceRow.getVehicleGeoLongitude();
            System.out.println("Vehicle Geo Longitude..." + vehicleGeoLongitude);
//            if(vehicleGeoLongitude == null || vehicleGeoLongitude.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("209", lngCode)));    
//                result = "fail";    
//            }
            Object vehicleMake = pvtIssuanceRow.getVehicleMake();
            System.out.println("Vehicle Make..." + vehicleMake);
            if(vehicleMake == null || vehicleMake.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("210", lngCode)));    
                result = "fail";    
            }
            /* Object vehicleModel = pvtIssuanceRow.getVehicleModel();
            System.out.println("Vehicle Model..." + vehicleModel);
            if(vehicleModel == null || vehicleModel.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("211", lngCode)));    
                result = "fail";    
            } */
            Object vehicleColor = pvtIssuanceRow.getVehicleColor();
            System.out.println("Vehicle Color..." + vehicleColor);
            if(vehicleColor == null || vehicleColor.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("212", lngCode)));    
                result = "fail";    
            }
            Object trariffType = pvtIssuanceRow.getTariffType();
            System.out.println("Tariff Type..." + trariffType);
            if(trariffType == null || trariffType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("213", lngCode)));    
                result = "fail";    
            }
        }
        return result;
    }
    
    public String clearDataOnResetAction() {
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTIssuanceVO1Iterator");
        ViewObject pvtIssuanceVO = dcIteratorBinding.getViewObject();
        pvtIssuanceVO.clearCache();
        PVTIssuanceVORowImpl pvtIssuanceRow = (PVTIssuanceVORowImpl)pvtIssuanceVO.getCurrentRow();
        if (pvtIssuanceRow != null) {
            System.out.println("Row exists in VO, removing...");
            pvtIssuanceRow.remove();
        }
        Row createRow = pvtIssuanceVO.createRow();
        pvtIssuanceVO.insertRow(createRow);
        
        return null;
    }


    public void setPvtnumber(RichInputText pvtnumber) {
        this.pvtnumber = pvtnumber;
    }

    public RichInputText getPvtnumber() {
        return pvtnumber;
    }

    public void setVehgeolongitude(RichInputText vehgeolongitude) {
        this.vehgeolongitude = vehgeolongitude;
    }

    public RichInputText getVehgeolongitude() {
        return vehgeolongitude;
    }

    public void setVehgeolatitude(RichInputText vehgeolatitude) {
        this.vehgeolatitude = vehgeolatitude;
    }

    public RichInputText getVehgeolatitude() {
        return vehgeolatitude;
    }

    public void setPlatenumber(RichInputText platenumber) {
        this.platenumber = platenumber;
    }

    public RichInputText getPlatenumber() {
        return platenumber;
    }


    public void setPlatecategory(RichSelectOneChoice platecategory) {
        this.platecategory = platecategory;
    }

    public RichSelectOneChoice getPlatecategory() {
        return platecategory;
    }

    public void setPlatetype(RichSelectOneChoice platetype) {
        this.platetype = platetype;
    }

    public RichSelectOneChoice getPlatetype() {
        return platetype;
    }

    public void setContraventioncode(RichSelectOneChoice contraventioncode) {
        this.contraventioncode = contraventioncode;
    }

    public RichSelectOneChoice getContraventioncode() {
        return contraventioncode;
    }

    public void setSector(RichSelectOneChoice sector) {
        this.sector = sector;
    }

    public RichSelectOneChoice getSector() {
        return sector;
    }

    public void setVehiclemake(RichSelectOneChoice vehiclemake) {
        this.vehiclemake = vehiclemake;
    }

    public RichSelectOneChoice getVehiclemake() {
        return vehiclemake;
    }

    public void setVehiclemodel(RichSelectOneChoice vehiclemodel) {
        this.vehiclemodel = vehiclemodel;
    }

    public RichSelectOneChoice getVehiclemodel() {
        return vehiclemodel;
    }

    public void setVehiclecolor(RichSelectOneChoice vehiclecolor) {
        this.vehiclecolor = vehiclecolor;
    }

    public RichSelectOneChoice getVehiclecolor() {
        return vehiclecolor;
    }

    public void plateCategoryVC(ValueChangeEvent valueChangeEvent) {
//        int plateCategory = Integer.parseInt(valueChangeEvent.getNewValue().toString());
        System.out.println("Selected plate category...valueChangeEvent..." + valueChangeEvent.getNewValue().toString());
        int plateCategory = Integer.parseInt(getPlatecategory().getValue().toString());
        System.out.println("Selected plate category..." + plateCategory);
//        if (plateCategory != 0) {
//            OperationBinding operationBinding = bindings.getOperationBinding("plateCategoryTypeDependentLOV");
//            operationBinding.getParamsMap().put("plateCategory", plateCategory);
//            operationBinding.execute();    
//        }
    }

    public void vehicleMakeVC(ValueChangeEvent valueChangeEvent) {
     //   int vehicleMake = Integer.parseInt(valueChangeEvent.getNewValue().toString());
        System.out.println("Selected vehicle make...valueChangeEvent..." + valueChangeEvent.getNewValue().toString());
        int vehicleMake = Integer.parseInt(getVehiclemake().getValue().toString());
        System.out.println("Selected vehicle make..." + vehicleMake);
//        if (vehicleMake != 0) {
//            OperationBinding operationBinding = bindings.getOperationBinding("vehicleMakeModelDependentLOV");
//            operationBinding.getParamsMap().put("vehicleMake", vehicleMake);
//            operationBinding.execute();
//        }
    }

    public void setTarifftype(RichSelectOneChoice tarifftype) {
        this.tarifftype = tarifftype;
    }

    public RichSelectOneChoice getTarifftype() {
        return tarifftype;
    }

    public void setPlatecountry(RichSelectOneChoice platecountry) {
        this.platecountry = platecountry;
    }

    public RichSelectOneChoice getPlatecountry() {
        return platecountry;
    }

    public void setZone(RichSelectOneChoice zone) {
        this.zone = zone;
    }

    public RichSelectOneChoice getZone() {
        return zone;
    }

    public void setPvtissuancedate(RichInputDate pvtissuancedate) {
        this.pvtissuancedate = pvtissuancedate;
    }

    public RichInputDate getPvtissuancedate() {
        return pvtissuancedate;
    }

    public void setContraventiondesc(RichSelectOneChoice contraventiondesc) {
        contraventiondesc.setValue(new Integer(0));
        this.contraventiondesc = contraventiondesc;
    }

    public RichSelectOneChoice getContraventiondesc() {
        return contraventiondesc;
    }

}
