package com.imum.cpms;

import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVOImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVORowImpl;


import com.imum.cpms.util.MessageUtil;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import com.sun.rowset.internal.Row;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

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

import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class LocationMstBean {
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
    String lngCode = httpSession.getAttribute("language").toString();

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    private DCBindingContainer getDCBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public LocationMstBean() {
        if(lngCode==null || lngCode.equals(""))
               {
                   lngCode = "EN";
               }

    }

    public String doNewLocMst() {
        logger.info("Inside New_Action of LocationMstBean");
        setHide(Boolean.FALSE);
        editMode="new";
        System.out.println("doNewLocMst");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNewLoc");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        System.out.println("success"); 
        locationIdButton.setRendered(Boolean.FALSE);
        if(!isEnabled())
          setEnabled(Boolean.TRUE);
        return null;
    }
    
    public String doEditLocMst() {
        
        
        System.out.println("doEditLocMst");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditLoc");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();
       
            
        editMode="edit";
     
       
        
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        
        if(!(bindings3.findIteratorBinding("LocationMstVO1Iterator").getEstimatedRowCount()>0)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data to available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("LocationMstVO2Iterator");
        ViewObject locvo2TableData = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl mstVO = (ViewObjectImpl)locvo2TableData;
        
        if(locvo2TableData!=null) {
            LocationMstVORowImpl locMstRow = (LocationMstVORowImpl)locvo2TableData.first(); 
            setLocationMstLngData(locMstRow.getLocationID(),mstVO);
            logger.info("locMstRow.getBayCount() Value after Editing::  "+locMstRow.getBayCount());
            System.out.println("locMstRow.getBayCount() Value after ::::::::::::::;  "+locMstRow.getBayCount());
            bayCount.setValue(locMstRow.getBayCount());
            setEditLocType(locMstRow.getLOCTYPE());
            if(locMstRow.getBayCount()!=null){
               
             setBayCountValue(locMstRow.getBayCount());  
            }
     }
        setEnabled(Boolean.TRUE);
        locationIdButton.setRendered(Boolean.TRUE);
        return null;
    }

    public String doViewLocMst() {
        logger.info("Inside View_Action of LocationMstBean");
        System.out.println("doViewLocMst");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        setHide(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditLoc");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        if(!(bindings3.findIteratorBinding("LocationMstVO1Iterator").getEstimatedRowCount()>0)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("LocationMstVO2Iterator");
        ViewObject locvo2TableData = dcItteratorBindings2.getViewObject();
        ViewObjectImpl mstVO = (ViewObjectImpl)locvo2TableData;
        if(locvo2TableData!=null) {
            LocationMstVORowImpl locMstRow = (LocationMstVORowImpl)locvo2TableData.getCurrentRow();
            setLocationMstLngData(locMstRow.getLocationID(),mstVO);
            bayCount.setValue(locMstRow.getBayCount());
        }
        setEnabled(Boolean.FALSE);
        locationIdButton.setRendered(Boolean.TRUE);
        return null;
    }
    
    public void setLocationMstLngData(Integer locCode,ViewObjectImpl mstVO){
        //Getting Data from Sector Master Language Table
         String lang = httpSession.getAttribute("language").toString();       
         getLocationMstLngVO().setWhereClause("Location_ID="+locCode);
         getLocationMstLngVO().executeQuery();
         RowSetIterator locIterator =getLocationMstLngVO().createRowSetIterator(null);
         while (locIterator.hasNext()) {
         oracle.jbo.Row locRow = locIterator.next();
            if(locRow!=null){
                String selectLang=(String)locRow.getAttribute("LNGCODE");
                if(("EN".equalsIgnoreCase(lang) && "AR".equalsIgnoreCase(selectLang))||("AR".equalsIgnoreCase(lang) && "EN".equalsIgnoreCase(selectLang))){
                     System.out.println("Location Code ::::::::::    "+mstVO.getCurrentRow().getAttribute("LocationID"));
                     mstVO.getCurrentRow().setAttribute("Language", selectLang);
                     mstVO.getCurrentRow().setAttribute("LocationNameLng", locRow.getAttribute("LocDesc")); 
                  } 
                    System.out.println("Loc Desc :::::::::::::::  "+locRow.getAttribute("LocDesc"));
               }
           }
    }
    
    public String submitLocationChanges(ActionEvent actionEvent) { 
                Integer currentBayNum = 0;
                String locationType=null;
                Integer currLoc_id = 0;
              
                int poundcharges=0 ; 
                DCBindingContainer bindings4 =
                              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindings3 =
                bindings4.findIteratorBinding("LocationMstVO2Iterator");
                ViewObject afterLocvo2TableData = dcItteratorBindings3.getViewObject();
                if(afterLocvo2TableData!=null) {
                    LocationMstVORowImpl locMstRow = (LocationMstVORowImpl)afterLocvo2TableData.getCurrentRow();
                    logger.info("Selected BayNum  Value in Submit Action ::"+locMstRow.getBayCount());
                    logger.info("Selected LocationType  Value in Submit Action :: "+locMstRow.getLOCTYPE());
                    currentBayNum= locMstRow.getBayCount();                    
                    locationType = locMstRow.getLOCTYPE();
                    currLoc_id = locMstRow.getLocationID();
                    if(locMstRow.getStoragecharge() != null)
                    poundcharges =locMstRow.getStoragecharge().intValue();
                    
                    
                    //Current Date validation for GoLiveDate
                    Timestamp activeDate = locMstRow.getGoLiveDt();
                    java.sql.Date sysDate = new java.sql.Date(new java.util.Date().getTime());
                    java.sql.Date SysDate = java.sql.Date.valueOf(sysDate.toString());
                    if(editMode!=null && editMode.equalsIgnoreCase("edit") && activeDate!=null) {
                        java.sql.Timestamp GoliveDate = (java.sql.Timestamp)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("GOLiveDate");
                        if(GoliveDate != null)
                        {
                        if(!activeDate.equals(GoliveDate )) {
                            if(activeDate.compareTo(SysDate) < 0) 
                            {
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("292", lngCode)));    
                                setHide(false);
                                ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
                                return "true";  
                            }
                        }
                    }
                        else if(activeDate!=null && activeDate.compareTo(SysDate) < 0) 
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("292", lngCode)));    
                            setHide(false);
                            ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
                            return "true";
                        }
                        
                        
                    }
                    
                    else if(activeDate!=null && activeDate.compareTo(SysDate) < 0) 
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("292", lngCode)));    
                        setHide(false);
                        ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
                        return "true";
                    }
//                    if( !"".equals(poundcharges) && poundcharges <0)
//                    { 
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter positive value for pound charges"));
//                        setHide(false);
//                        ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
//                        return "true";
//                    }
                    
                    if(editMode!=null && editMode.equalsIgnoreCase("edit")&& locationType!=null && ("PND".equals(getEditLocType())) && !("PND".equalsIgnoreCase(locationType))){                    
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("31", lngCode)));
                       setHide(false);
                       ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
                       return "true";
                   }
                }
                DCBindingContainer bindingsDC =(DCBindingContainer)getBindings();
                DCIteratorBinding dcItteratorBindings =bindingsDC.findIteratorBinding("PoundBayDetailVO1Iterator");
                ViewObject poundBayData = dcItteratorBindings.getViewObject();
                String userName = httpSession.getAttribute("loggedinUserid").toString();
                BindingContainer bindings = getBindings();
                Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
                
                if(editMode!=null && editMode.equalsIgnoreCase("edit") && bayCountValue!=0 && (currentBayNum!=null &&  currentBayNum < bayCountValue) && locationType!=null && locationType.equalsIgnoreCase("PND")){
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("32", lngCode)));
                 setHide(false);
                ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true"); 
                 return "true";
                   
                }  
      
                getBindings().getOperationBinding("doCommit").execute(); 
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("88", lngCode)));
                
                //Location Master Language Code Start
                
                DCIteratorBinding binding =
                    getDCBindings().findIteratorBinding("LocationMstVO2Iterator"); 
                String language = (String)binding.getViewObject().getCurrentRow().getAttribute("Language");
                String selectedLanguage = httpSession.getAttribute("language").toString();
                String locNameLng = (String)binding.getViewObject().getCurrentRow().getAttribute("LocationNameLng");
                String locationName = (String)binding.getViewObject().getCurrentRow().getAttribute("LocDesc");
                
                if(language!=null && language.equalsIgnoreCase(selectedLanguage)){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("288", lngCode)));
                    return "true";
                }
                
                //Getting Newly inserted values
                DCIteratorBinding dcItteratorBindings3Loc =
                bindings4.findIteratorBinding("LocationMstVO1Iterator");              
                ViewObject locVO = dcItteratorBindings3Loc.getViewObject();
                locVO.executeQuery();
                LocationMstVORowImpl locMstRow = (LocationMstVORowImpl)locVO.first();                   
                Integer loc_id = locMstRow.getLocationID();
                
                ViewObject locMstLngVo = getLocationMstLngVO();
                if(editMode!=null && editMode.equalsIgnoreCase("edit") ){                    
                    RowSetIterator locIterator =getLocationMstLngVO().createRowSetIterator(null);
                    while (locIterator.hasNext()) {
                    oracle.jbo.Row locRow = locIterator.next();
                       if(locRow!=null){
                                   String selectLang=locRow.getAttribute("LNGCODE").toString();
                                    if(selectLang!=null && selectLang.equalsIgnoreCase("EN")){
                                        locRow.setAttribute("LocDesc",locationName);
                                    }else{
                                        locRow.setAttribute("LocDesc",locNameLng);
                                    }                                                 
                                    locRow.setAttribute("Updatedby",httpSession.getAttribute("loggedinUserid").toString());
                                    locRow.setAttribute("Updatedate",sqlDate);                                   
                                }
                    }              
                }else if(editMode!=null && (editMode.equalsIgnoreCase("new") )){
                    for(int i=0;i<2;i++){
                        oracle.jbo.Row newRow = locMstLngVo.createRow();
                        newRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
                        newRow.setAttribute("CreatedDate",sqlDate);
                        newRow.setAttribute("LocationID",loc_id);
                        if(i==0){
                            newRow.setAttribute("LNGCODE",httpSession.getAttribute("language").toString());
                            newRow.setAttribute("LocDesc",locationName);
                        }else{
                            newRow.setAttribute("LNGCODE",language);
                            newRow.setAttribute("LocDesc",locNameLng);
                        }                  
                        locMstLngVo.insertRow(newRow); 
                    }   
                }                                  
                locMstLngVo.executeQuery(); 
                getBindings().getOperationBinding("doCommit").execute();
                //Location Master Language Code End
                
                if(editMode!=null && (editMode.equalsIgnoreCase("new") && locationType!=null && locationType.equalsIgnoreCase("PND"))){
                  
                    OperationBinding opBinding = bindings.getOperationBinding("doAddBayDetail");
                    opBinding.getParamsMap().put("loggerName",userName);
                    opBinding.execute(); 
                    
                    int bayCountPound = poundBayData.getRowCount();
                    System.out.println("bayCountPound"+bayCountPound);
                    int count = 1;
                    if(bayCountPound>0){
//                        RowSetIterator bayIterator =poundBayData.createRowSetIterator(null);                
//                        while (bayIterator.hasNext()) {
//                            oracle.jbo.Row bayRow = bayIterator.next();
//                            if (bayRow != null) {                    
//                              System.out.println("Baynum  :::::::::::::::::::::::" + bayRow.getAttribute("Baynum"));                         
//                             if(bayRow.getAttribute("Baynum") == null){
//                                  bayRow.setAttribute("Baynum",count);//Setting BayNum Value once again here
//                              }                     
//                          }
//                            count++;
//                        }
                        bayNumberSetting(poundBayData);
                    } 
                }
                else if(editMode!=null && (editMode.equalsIgnoreCase("edit") && currentBayNum!=null && currentBayNum > bayCountValue && locationType!=null && locationType.equalsIgnoreCase("PND"))){
                    
                    PoundBayDetailVOImpl poundImpl = (PoundBayDetailVOImpl)poundBayData;
                    poundImpl.clearCache();
                    poundImpl.executeEmptyRowSet();
                    //Inserting Pound Location type records based on Bay count
                    
                    int loopValue=bayCountValue+1;
               
                        for(int j=loopValue;j<=currentBayNum;j++){
                                PoundBayDetailVORowImpl rowBayImpl = (PoundBayDetailVORowImpl)poundImpl.createRow();
                                rowBayImpl.setCreatedBy(userName);
                                rowBayImpl.setCreatedDate(sqlDate);
                                rowBayImpl.setBaynum(j);
                                System.out.println("bayNum:::"+rowBayImpl.getBaynum());
                                rowBayImpl.setPOUNDLocationID(currLoc_id);
                                rowBayImpl.setBaystatus("A");//Assigning Available status
                                poundImpl.insertRow(rowBayImpl);                                                                 
                        } 
                        
                        if(bayCountValue == 0 && currentBayNum > 0){
                            bayNumberSetting(poundBayData);
                        }
                  
                }
                OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");
                opBindingDoc.execute();
                if(!opBindingDoc.getErrors().isEmpty()){
                   System.out.println("DB Errors::"+opBindingDoc.getErrors());
                }else{
                    
                    logger.info("Successfully Created "+currentBayNum+"bays in Pound Bay in Submit Action");
                } 
                
                DCIteratorBinding dcItteratorBindingsLoc =
                     bindings4.findIteratorBinding("LocationMstVO1Iterator");
                ViewObject locvoTableData = dcItteratorBindingsLoc.getViewObject();
                locvoTableData.executeQuery();
                return "false";
            }
    
    public ViewObject getLocationMstLngVO() {
        DCIteratorBinding bindingLink =getDCBindings().findIteratorBinding("LocationMstLngVO1Iterator");
        ViewObject voLink = bindingLink.getViewObject();
        return voLink;
    }

    public void bayNumberSetting(ViewObject poundBayData){
        int baySetCount = 1;
        RowSetIterator bayIterator =poundBayData.createRowSetIterator(null);                
        while (bayIterator.hasNext()) {
            oracle.jbo.Row bayRow = bayIterator.next();
            if (bayRow != null) {                    
              System.out.println("Baynum  :::::::::::::::::::::::" + bayRow.getAttribute("Baynum"));                         
             if(bayRow.getAttribute("Baynum") == null){
                  bayRow.setAttribute("Baynum",baySetCount);//Setting BayNum Value once again here
              }                     
          }
            baySetCount++;
        }
    }
    public void cancelLocationChanges(ActionEvent actionEvent) {
                getBindings().getOperationBinding("doRollback").execute();
            }

    public void setLocationTable(RichShowDetailHeader locationTable) {
        this.locationTable = locationTable;
    }

    public RichShowDetailHeader getLocationTable() {
        return locationTable;
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

    public void setLocationIdButton(RichInputText locationIdButton) {
        this.locationIdButton = locationIdButton;
    }

    public RichInputText getLocationIdButton() {
        return locationIdButton;
    }
    
    public void activeFlagBoolean(ValueChangeEvent valueChangeEvent) {
           // Add event code here...
           Boolean newValue = (Boolean)valueChangeEvent.getNewValue();
           System.out.println("newValue"+newValue);
           if(!newValue){
           BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
           OperationBinding opBinding = bindings.getOperationBinding("bayStatusForLocation");
           opBinding.execute(); 
           int bayCount = (Integer)opBinding.getResult();
           System.out.println("bayCount-activeFlagBoolean"+bayCount);
           logger.info("bayCount-activeFlagBoolean for Selection of active flag"+bayCount);
           if(bayCount == 0){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("89", lngCode)));           
           }
         }
       }

    public void setBayCount(RichInputText bayCount) {
        bayCount.setValue(new Integer(0));
        this.bayCount = bayCount;
    }

    public RichInputText getBayCount() { 
        return bayCount;
    }

    public void setBayCountValue(Integer bayCountValue) {
        this.bayCountValue = bayCountValue;
    }

    public Integer getBayCountValue() {
        return bayCountValue;
    }


    public void setEditLocType(String editLocType) {
        this.editLocType = editLocType;
    }

    public String getEditLocType() {
        return editLocType;
    }
}
