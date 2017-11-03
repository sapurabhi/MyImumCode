package com.imum.cpms.view;


import com.imum.cpms.model.masters.vo.HolidayMstUVORowImpl;
import com.imum.cpms.model.staffdeploy.vo.GenLocationLOVVORowImpl;
import com.imum.cpms.model.staffdeploy.vo.PIUserMstUVORowImpl;

import com.imum.cpms.util.MessageUtil;
import com.rsa.certj.cert.attributes.Gender;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.Blob;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectManyCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;

import org.apache.commons.io.IOUtils;



import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.adf.view.rich.model.QueryModel;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.javatools.status.Issue;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;
import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;
import com.imum.cpms.util.JSFUtils;
public class PINewProfileMBean {
    private Boolean FormVisible = false;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    private RichInputText reasonsDeactivate;
    private RichPanelGroupLayout editPanel;
    private String hide;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichInputText piId;
    private RichSelectOneRadio intExtStatus;
    private RichInputFile uploadedFile;
    private UploadedFile myfile;
    private RichInputText piIdNew;
    private RichInputText firstnameNew;
    private RichInputText lastNameNew;
    private RichSelectOneRadio gendernew;
    private RichInputDate doBNew;
    private RichInputText addr1New;
    private RichInputText addr2New;
    private RichSelectOneChoice cityNew;
    private RichSelectOneChoice countryNew;
    private RichInputText emiratesIdNew;
    private RichSelectOneChoice piStatusNew;
    private RichInputText passportNumberNew;
    private RichInputDate dateofIssueNew;
    private RichInputDate dateofExpiryNew;
    private RichSelectOneChoice nationalityNew;
    private RichSelectOneChoice educationalNew;
    private RichInputDate hireDate;
    private RichInputText medicalNew;
    private RichSelectOneChoice healthNew;
    private RichInputText commentsNew;
    private RichSelectOneRadio trainingstatus;
    MessageUtil genMsg = new MessageUtil();
    private RichInputDate hiredateNew;
    private RichSelectOneRadio trainingstatusNew;
    public static final ADFLogger logger = ADFLogger.createADFLogger(PINewProfileMBean.class);
    private RichInputFile uploadedUpdateFile;
    private RichSelectOneRadio trainingupdate;
    private RichSelectOneChoice piStatusUpdate;
    private RichTable searchTable;
    private RichSelectManyCheckbox trainingCheckbox;
   
    private RichSelectItem internalTrainingNew;
    private RichSelectItem externalTrainingNew;
    private RichSelectItem internaltrainingUpdate;
    private RichSelectItem externalTrainingUpdate;
    private RichSelectBooleanCheckbox internalCheck;
    private RichPanelFormLayout externalCheck;
    private RichSelectBooleanCheckbox externalchecked;
    private RichSelectBooleanCheckbox internalTraining;
    private RichSelectBooleanCheckbox externalTraining;
    private String groupid;
    private RichSelectBooleanCheckbox medicalexamcheck;
    private RichSelectBooleanCheckbox updateMedExamCheck;

    public BindingContainer getBindings1() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    private DCBindingContainer getDCBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public PINewProfileMBean() {
                if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
    }

    public String cb1_action() {
        // Add event code here...
        return null;
    }
    public String createDir(String chaildDir, String rootPath ){
            logger.info("Start createDir Method of PINewProfileMBean ");
            try{
           String createD = "";
            String nextDir="";
            if(chaildDir != null && !chaildDir.equals("")){
                if(chaildDir.charAt(0) == '/'){
                  chaildDir  = chaildDir.substring(chaildDir.indexOf("/")+2,chaildDir.length());
                    createD = chaildDir.substring(0,chaildDir.indexOf("/"));
                    // f.mkdir();
                     rootPath = rootPath+"//"+createD;
                }
                else{
                 createD = chaildDir.substring(0,chaildDir.indexOf("/"));
                nextDir = chaildDir.substring(chaildDir.indexOf("/"),chaildDir.length());
                File f = new File(rootPath+"//"+createD); 
                if(f.isDirectory()){
                // f.mkdir();
                  // rootPath = rootPath+"//"+createD;
                // System.out.println("Root Path"+rootPath);
                }
                else{
                    rootPath = rootPath+"//"+createD;
                    f.mkdirs();
                     if(nextDir.charAt(0) == '/'){
                   nextDir  = chaildDir.substring(chaildDir.indexOf("/")+2,chaildDir.length());
                   createDir(nextDir,rootPath);
                 }
                 else{
                     createD = nextDir.substring(0,nextDir.indexOf("/"));
                      f.mkdirs();
                      rootPath = rootPath+"//"+createD;

                 }
                }
            }
            }
            else{
            }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            logger.info("End createDir Method of PINewProfileMBean ");
            return rootPath;
        }
    
    public String Submit() {
        logger.info("Start Submit Method of PINewProfileMBean ");
        try{
            String userName = httpSession.getAttribute("loggedinUserid").toString();
            String PIID = null;
            String Firstname = null;
            String Lastname = null;
            String Gender = null;
            Date DOB ;
            String Address1 = null;
            String address2 = null;
            String City = null;
            String country = null;
            String emiratesId = null;
            String PIStatus = null;
             String passportnumber = null;
            Date dateofIssue = null;
           Date dateofExpiry = null;;
            String Nationality = null;
            String EducationalQualification = null;
            Date hiredate ;
            String medicalDetails = null;
            String healthinsurance = null;
            String comments = null;
            String trainingstatus = null;
            String Internaltraining = null;
            String ExternalTraining = null;
            String Groupname=null;
            Boolean medicalcheck=false;
            Boolean inttraincheck=false;
            Boolean extraincheck=false;
            HashMap map = new HashMap();
            int citycode = 0;
            DCBindingContainer bindings =
                          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("PIUserMstUVO1Iterator");
            DCIteratorBinding dcItteratorBindingsvo2 =
            bindings.findIteratorBinding("PIUserMstUVO2Iterator");
            
            
            ViewObject PITableData = dcItteratorBindings.getViewObject();
            ViewObject PITableData2 = dcItteratorBindingsvo2.getViewObject();
            
            if(getPiIdNew().getValue() != null)
            {
             PIID = getPiIdNew().getValue().toString();
            
            }
            else {
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI Id"));  
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                             "Sample info message",
                                                                             genMsg.getMessage("406",lgCode)));
                return null;
            }
            if(PIID != null) {
               if(PITableData != null)
               {
                   int rowcount = PITableData2.getRowCount();   
                Row[] filteredRows = PITableData2.getFilteredRows("UserId", PIID);
                if(filteredRows.length>0)
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "PI already exists"));
                    return null;
                }
               }
            }
            if(getFirstnameNew().getValue() != null)
             Firstname =getFirstnameNew().getValue().toString();
            else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter First Name"));  
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("407",lgCode)));
                return null;
            }
            if(getLastNameNew().getValue() != null)
             Lastname = getLastNameNew().getValue().toString();
            else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("408",lgCode)));
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Last Name"));  
            }
            if(getGendernew().getValue() != null)
             Gender = getGendernew().getValue().toString();
            else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("410",lgCode)));
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select Gender"));  
                return null;
            }
            if(getDoBNew().getValue()!= null){
               Date dob=(Date)getDoBNew().getValue();
             if(dob.before(new Date())){
                 DOB = (Date)getDoBNew().getValue();
             }
             else{
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("455",lgCode)));
                 //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", " Date of Birth should be Before Current Date"));  
                 return null;
             }
             
            }
            else {
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Date of Birth"));
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                             "Sample info message",
                                                                             genMsg.getMessage("409",lgCode)));
                return null;
            }
            if(getAddr1New().getValue() != null)
             Address1 =getAddr1New().getValue().toString();
            else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("411",lgCode)));
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Address1"));  
                return null;
            }
            if(getAddr2New().getValue() != null)
             address2 = getAddr2New().getValue().toString();
            if(getCityNew().getValue() != null)
             City = getCityNew().getValue().toString();
            else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("413",lgCode)));
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select City"));  
                return null;
            }
            
            JUCtrlListBinding listBinding1 =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenCityLOVVO1");
            if(listBinding1.getSelectedValue() != null)
            {
            City = listBinding1.getSelectedValue().toString();
        
            }
           
           
            if(getCountryNew().getValue() != null)
             country = getCountryNew().getValue().toString();
            else {
               //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select Country"));
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                             "Sample info message",
                                                                             genMsg.getMessage("414",lgCode)));
                return null;
            }
            
            JUCtrlListBinding listBindingcountry =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenCountryLOVVO1");
            if(listBindingcountry.getSelectedValue() != null)
            {
            country = listBindingcountry.getSelectedValue().toString();
            
            }
            if(getEmiratesIdNew().getValue() != null)
             emiratesId = this.getEmiratesIdNew().getValue().toString();
            else {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Emirates Id"));
                 
                    return null;
                }  
            
            if(getPiStatusNew().getValue() != null)
             PIStatus = getPiStatusNew().getValue().toString();
            else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("416",lgCode)));
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI Status"));  
                return null;
            }
            String medcheck=getMedicalexamcheck().getValue().toString();
            if(medcheck=="true"){
                medicalcheck=true;
                //setMedicalexamcheck(null);
                System.out.println("checked");
            }
            else
                medicalcheck=false;
                System.out.println("unchecked");
            if(getPiStatusNew().getValue().equals(2)){
                if(medicalcheck==false){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "Medical examination is mandatory before PI Deployment"));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI Status"));  
                    return null; 
                }
            }
            
            String inttrain=getInternalTraining().getValue().toString(); 
            if(inttrain=="true"){
                inttraincheck=true;
                //setMedicalexamcheck(null);
                System.out.println("checked");
            }
            else
                inttraincheck=false;
                System.out.println("unchecked");
            if(getPiStatusNew().getValue().equals(2)){
                if(inttraincheck==false){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "Internal Training  is mandatory before PI Deployment"));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI Status"));  
                    return null; 
                }
            }
            String exttrain=getExternalTraining().getValue().toString(); 
            if(exttrain=="true"){
                extraincheck=true;
                //setMedicalexamcheck(null);
                System.out.println("checked");
            }
            else
                extraincheck=false;
                System.out.println("unchecked");
            if(getPiStatusNew().getValue().equals(2)){
                if(extraincheck==false){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "External Training is mandatory before PI Deployment"));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI Status"));  
                    return null; 
                }
            }
            JUCtrlListBinding listBindingstatus =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PITrainingStatusLOVVO1");
            if(listBindingstatus.getSelectedValue() != null)
            {
            PIStatus = listBindingstatus.getSelectedValue().toString();
            
            }
            JUCtrlListBinding listBindingstatus1 =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PIGroupLOVVO1");
            if(listBindingstatus1.getSelectedValue() != null)
            {
            Groupname = listBindingstatus1.getSelectedValue().toString();
            
            }
            if(getPassportNumberNew().getValue()!= null){
               passportnumber = getPassportNumberNew().getValue().toString();
               
            }
            if(passportnumber != null) {
              
            Row[] filteredRows = PITableData.getFilteredRows("PassportNumber", passportnumber);
                if(filteredRows.length>0)
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Passport Number is already registered for another user"));
                    return null;
                }

            }
          
             if( getDateofIssueNew().getValue() != null && getDateofExpiryNew().getValue() != null ){
                 Date Issue = (Date)getDateofIssueNew().getValue();
                 Date Expiry = (Date)getDateofExpiryNew().getValue();
                
                     if(passportnumber==null){
                 if((Issue !=null && Expiry !=null)){
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                       "Sample info message",
                                                                                       genMsg.getMessage("456",lgCode)));
                      // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "You Cannot Enter Issue Date and ExpiryDate without Passport number"));
                       return null;
                     }}
                   
                     if((Issue !=null && Expiry !=null)){    
                 if(Issue.after(Expiry)){
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("457",lgCode)));
                    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Issue Date Should be Less than Expiry Date"));
                     return null;
                 }
                 if(Issue.after(DOB) && Expiry.after(DOB)){
                     dateofIssue=  (Date)getDateofIssueNew().getValue();
                     dateofExpiry = (Date)getDateofExpiryNew().getValue();
                 }
                 else{
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                       "Sample info message",
                                                                                       genMsg.getMessage("458",lgCode)));
                         //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Passport Issue Date and Expiry Should be greater than Date of Birth"));
                         return null;
                     }
                 }
//                 else{
//                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Passport Issue Date and Expiry Should be greater than Date of Birth")); 
//                     return null;
//                 }
             }    
//             if(getDateofExpiryNew().getValue() != null){
//             dateofExpiry = (Date)getDateofExpiryNew().getValue();
//             }
             
           
            if(getNationalityNew().getValue() != null)
             Nationality = getNationalityNew().getValue().toString();
            else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("415",lgCode)));
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select Nationality"));  
                return null;
            }
            JUCtrlListBinding listBindingnation =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GennationalityLOVVO1");
            if(listBindingnation.getSelectedValue() != null)
            {
            Nationality = listBindingnation.getSelectedValue().toString();
            
            }
            if(getEducationalNew().getValue() != null)
             EducationalQualification = getEducationalNew().getValue().toString();
            JUCtrlListBinding listBindingeduc =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PIQualificationLOVVO1");
            if(listBindingeduc.getSelectedValue() != null)
            {
            EducationalQualification = listBindingeduc.getSelectedValue().toString();
            
            }
            
            if(getHiredateNew().getValue() != null){
            Date hired=(Date)getHiredateNew().getValue();
                if(DOB.before(hired)){
                    hiredate = (Date)getHiredateNew().getValue();
                }
                else{
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("459",lgCode)));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", " Hired Date  should be Greater than Date of Birth "));  
                    return null;
                }
                if(hired.after(new Date())){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", " Hire Date  should not be Greater than Current Date "));  
                return null;  
                }
            }
            else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("417",lgCode)));
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Hire Date"));  
                return null;
            }
            if(getMedicalNew().getValue() != null)
             medicalDetails = getMedicalNew().getValue().toString();
            if(getHealthNew().getValue() != null)
             healthinsurance = getHealthNew().getValue().toString();
            JUCtrlListBinding listBindingyesno =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("YesNoLOVVO1");
            if(listBindingyesno.getSelectedValue() != null)
            {
            healthinsurance = listBindingyesno.getSelectedValue().toString();
            
            }
//            String grpid=(String)pageflowScope.get("groupid");
//            //int gpid=Integer.parseInt(grpid);
            if(getCommentsNew().getValue() != null)
             comments = getCommentsNew().getValue().toString();
          
            if(getInternalTraining().getValue() != null){
             Internaltraining= getInternalTraining().getValue().toString();
            }
            if(getExternalTraining().getValue() != null){
             ExternalTraining = getExternalTraining().getValue().toString();
            }
            if(getMedicalexamcheck().getValue() != null)
             trainingstatus =getMedicalexamcheck().getValue().toString();
            map.put("PIID",PIID);
            map.put("Firstname",Firstname);
            map.put("Lastname",Lastname);
            map.put("Gender",Gender);
            map.put("DOB",DOB);
             map.put("Address1",Address1);
            map.put("address2",address2);
            map.put("City",City);
            map.put("country",country);
            map.put("emiratesId",emiratesId);
            map.put("PIStatus",PIStatus);
            map.put("passportnumber",passportnumber);
            map.put("dateofIssue",dateofIssue);
            map.put("dateofExpiry",dateofExpiry);
            map.put("Nationality",Nationality);
            map.put("EducationalQualification",EducationalQualification);
            map.put("hiredate",hiredate);
            map.put("medicalDetails",medicalDetails);
            map.put("healthinsurance",healthinsurance);
            map.put("comments",comments);
            map.put("trainingstatus",trainingstatus);
            map.put("Internaltraining",Internaltraining);           
            map.put("ExternalTraining",ExternalTraining);
            map.put("Groupname", Groupname);
            
            
            map.put("encoder",userName);
            OperationBinding operationBindingcreate = bindings.getOperationBinding("createPIProfile");
             operationBindingcreate.getParamsMap().put("map",map);
             Object resultcreate = operationBindingcreate.execute();
              DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                          DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PIUserMstUVO1Iterator");
                          ViewObjectImpl PIProfileVO = (ViewObjectImpl)dcItterator.getViewObject(); 
            
            
            
            
        Boolean result = validatePIData();
            String str = null;
        String UserId = null;
            DCIteratorBinding holdVOIter2 =
                bindingsAM.findIteratorBinding("PIUserMstUVO1Iterator");
            ViewObjectImpl PICreateVO2 = (ViewObjectImpl)holdVOIter2.getViewObject();
            if(PICreateVO2 != null)
            {
                PIUserMstUVORowImpl PICreateRow2 = (PIUserMstUVORowImpl)PICreateVO2.getCurrentRow();   
                if(PICreateRow2 != null)
                {
                     str = PICreateRow2.getUserId().toString();
                }
    
        if(result)
        {
            String rootPath = "//cpmsshare";
                 String subFolderPath = "PIProfile//PIPhoto";  
            String chaildDir= "PIProfile//PIPhoto";
            //UploadedFile myfile = (UploadedFile)this.getMyfile();
            File f1 = new File(rootPath+"//"+subFolderPath); 
                                 if(!f1.isDirectory()){
                                     createDir(subFolderPath+"//"+str+"//",rootPath);
                                     rootPath = rootPath+"//"+subFolderPath+"//"+str;
                                 }
                                 else{
                                     File f3 = new File(rootPath+"//"+subFolderPath+"//"+str); 
                                     if(!f3.isDirectory()){
                                         f3.mkdirs();
                                         rootPath = rootPath+"//"+subFolderPath+"//"+str;
                                     }
                                     else {
                                         rootPath = rootPath+"//"+subFolderPath+"//"+str; 
                                     }
                                     
                                 }
            FacesContext context = FacesContext.getCurrentInstance();
                               ExternalContext ectx = context.getExternalContext();
                               Map sessionMap = ectx.getSessionMap();
            InputStream inputstream =(InputStream)sessionMap.get("InputStream");
            Map sessionMap1 = ectx.getSessionMap();
            if(sessionMap1.get("myfile") != null)
            {
            myfile =(UploadedFile) sessionMap1.get("myfile");
            Map sessionMap3 = ectx.getSessionMap();
            String rootpathsession =
                        (String)sessionMap3.put("rootpath",rootPath);
                
                              File f = new File(rootPath+"//"+myfile.getFilename());
            OutputStream out = new FileOutputStream(f);
                              byte buf[] = new byte[1024];
                              int len;
                              while ((len = inputstream.read(buf)) > 0)
                                  out.write(buf, 0, len);
                              out.close();
            String filetype = myfile.getContentType();
                              //System.out.println(filetype);
                              String fileExt =filetype.substring(filetype.lastIndexOf("/") + 1); 
                              //System.out.println(fileExt);
            byte b[]  = IOUtils.toByteArray(inputstream);
            PICreateRow2.setAttribute("Attachment", rootPath+"//"+myfile.getFilename()); 
            }
        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
        Object executeresult = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
          
            DCIteratorBinding holdVOIter =
                bindingsAM.findIteratorBinding("PIUserMstUVO1Iterator");
            ViewObjectImpl PICreateVO = (ViewObjectImpl)holdVOIter.getViewObject();
            if(PICreateVO != null)
            {
                PIUserMstUVORowImpl PICreateRow = (PIUserMstUVORowImpl)PICreateVO.getCurrentRow();   
                if(PICreateRow != null) {
                    
                    UserId =  PICreateRow.getUserId();
                   
                }
            }
//            OperationBinding operationBindingcreate = bindings.getOperationBinding("createPIProfile");
//            operationBinding.getParamsMap().put("encoder",userName);
//            Object resultcreate = operationBindingcreate.execute();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "PI Created successfully with UserId " +" " +UserId));
           // FacesContext.getCurrentInstance().addMessage(null,
                                                       //  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                             //             "Sample info message",
                                                            //              genMsg.getMessage("418",lgCode)+UserId));
       
            pageflowScope.put("Button","disable");
            pageflowScope.put("Entered","disable");
            sessionMap.remove("InputStream");
            sessionMap.remove("myfile");
            return null;
        }

         
        getPiId().setValue(null);
//            DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//            DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PIUserMstUVO2Iterator");
//            ViewObjectImpl PIProfileVO = (ViewObjectImpl)dcItterator.getViewObject();
//            PIProfileVO.setWhereClause(null);
//            PIProfileVO.setWhereClauseParams(null);
//            PIProfileVO.executeQuery();
        
            
        }}}
        catch(Exception e)
                    {
                           e.printStackTrace();
                        // rootPath = "D://cpmsshare";
                     }
        logger.info("End createDir Method of PINewProfileMBean ");
        return null;
    }
    public String CreatePIProfile() {
        // Add event code here...
        logger.info("Start CreatePIProfile Method of PINewProfileMBean ");
        searchTable.getSelectedRowKeys().clear();
        pageflowScope.put("Button","New");
        pageflowScope.put("Entered","New");
      getPiIdNew().setValue(null);
       getFirstnameNew().setValue(null);
       getLastNameNew().setValue(null);
       getDoBNew().setValue(null);
      getAddr1New().setValue(null); 
    getAddr2New().setValue(null);
    // getCityNew().setValue("DFA");
    cityNew.setValue(1);
     nationalityNew.setValue(52);
    //  getCountryNew().setValue("ARE");
  countryNew.setValue(0);
         getEmiratesIdNew().setValue(null);
       getPiStatusNew().setValue(null);
      getPassportNumberNew().setValue(null);
        getDateofIssueNew().setValue(null);
        getDateofExpiryNew().setValue(null);
   
       getEducationalNew().setValue(null);
    getHiredateNew().setValue(null);
       getMedicalNew().setValue(null);
       getHealthNew().setValue(null);
getCommentsNew().setValue(null);
 
        getGendernew().setSubmittedValue(0);
      getUploadedFile().setValue(null);
      getInternalTraining().setValue(false);
      getExternalTraining().setValue(false);

        String userName = httpSession.getAttribute("loggedinUserid").toString();
      BindingContainer bindings = getBindings();
      /* commented for ncheck cancel* start*/
//      OperationBinding operationBinding = bindings.getOperationBinding("createPIProfile");
//       operationBinding.getParamsMap().put("encoder",userName);
//       Object result = operationBinding.execute();
//        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//                    DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PIUserMstUVO1Iterator");
//                    ViewObjectImpl PIProfileVO = (ViewObjectImpl)dcItterator.getViewObject();
      /* commented for ncheck cancel end */
                
  //           PIProfileVO.setNamedWhereClauseParam("First_Name", null);
//               PIProfileVO.setNamedWhereClauseParam("FirstNmBind", null);
//               PIProfileVO.setNamedWhereClauseParam("EmailBind", null);
//               PIProfileVO.setNamedWhereClauseParam("SalaryBind", null);
   //           PIProfileVO.executeQuery();
     //  PIProfileVO.executeEmptyRowSet();

       
       
        
       
     //   ADFContext.getCurrent().getPageFlowScope().put("actionMode","New");
     logger.info("End CreatePIProfile Method of PINewProfileMBean ");
        return null;
    }


    public void PISelectionListener(SelectionEvent selectionEvent) {
    
        // Add event code here...
        logger.info("Start PISelectionListener Method of PINewProfileMBean ");
        try {
                ADFUtil.invokeEL("#{bindings.PIUserMstUVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });

                // get the selected row , by this you can get any attribute of that row
                Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PIUserMstUVO1Iterator.currentRow}"); // get the current selected row
               // Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PermitSearchCriteriaVO1.collectionModel.selectedRow}");
               String UserId =(String) selectedRow.getAttribute("UserId");
                //System.out.println("userid"+UserId);
               
        
              if(selectedRow != null) {
                  FacesContext context = FacesContext.getCurrentInstance();
                pageflowScope.put("Entered","Update");
                pageflowScope.put("Button","Update");
                pageflowScope.put("PIID","disable");
               

                getEditPanel().setRendered(true);
                DCBindingContainer bindings =
                              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindings =
                bindings.findIteratorBinding("PIUserMstUVO2Iterator");
                
                
                ViewObject PITableData = dcItteratorBindings.getViewObject();
               
                
                //System.out.println("Query is : "+PITableData.getQuery());
     
    //                PITableData.clearCache();
    //                PITableData.executeEmptyRowSet();
                PITableData.setWhereClause(null);
                PITableData.setWhereClauseParams(null);
                PITableData.setWhereClause("User_Id = '"+UserId+"'");
                PITableData.executeQuery();
                //Row row = PITableData.getCurrentRow();
               // String selected = (String)row.getAttribute("IntExtTrainingStatus");
                String attachment = (String) selectedRow.getAttribute("Attachment");
                if(selectedRow.getAttribute("IntExtTrainingStatus") != null)
                {
                String intstatus = (String)selectedRow.getAttribute("IntExtTrainingStatus");
                if(intstatus != null)
                {
                    if(intstatus.equals("I  "))
                        internalCheck.setSelected(true);
                    else
                    internalCheck.setSelected(false);
                  
                }
                
                        
                        
                }
                if(selectedRow.getAttribute("ExtTrainingStatus") != null)
                {
                String extsattus = (String)selectedRow.getAttribute("ExtTrainingStatus");
                if(extsattus != null)
                {
                    if(extsattus.equals("E  "))
                     externalchecked.setSelected(true);
                    else
                    externalchecked.setSelected(false);  
                  
                }
                        
                }
                if(selectedRow.getAttribute("medicaltestcompletedflag") != null)
                {
                String medsattus = (String)selectedRow.getAttribute("medicaltestcompletedflag");
                if(medsattus != null)
                {
                    if(medsattus.equals("Y")){
                     updateMedExamCheck.setSelected(true);
                    medicalexamcheck.setSelected(true);
                    }
                    else{
                    updateMedExamCheck.setSelected(false);  
                    medicalexamcheck.setSelected(false);
                    }
                  
                }
                        
                }
                
              
                
                
                
                if(selectedRow.getAttribute("Trainingstatus") != null) {
                    String Trainingstatus = selectedRow.getAttribute("Trainingstatus").toString();
                    String intstatus = (String)selectedRow.getAttribute("IntExtTrainingStatus");
                    String extsattus = (String)selectedRow.getAttribute("ExtTrainingStatus");
                    String medsattus = (String)selectedRow.getAttribute("medicaltestcompletedflag");
                    System.out.println(Trainingstatus);
                    if(Trainingstatus.equals("3")&&intstatus.equals("I  ")&&extsattus.equals("E  ")&&medsattus.equals("Y")){
                        piStatusUpdate.setDisabled(true);  
                    }
                    else{
                        piStatusUpdate.setDisabled(false); 
                       
                    }
                
                }
                ExternalContext ectx = context.getExternalContext();
                Map sessionMap = ectx.getSessionMap();
                Map sessionMap1 = ectx.getSessionMap();
                DCBindingContainer bindingslink =
                              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindingslink =
                bindings.findIteratorBinding("PITrainingLinkVO1Iterator");
                
                
                ViewObject PITableDatlinka = dcItteratorBindingslink.getViewObject();
                
                PITableDatlinka.setWhereClause(null);
                PITableDatlinka.setWhereClauseParams(null);
                PITableDatlinka.setWhereClause("PI_Number = '"+UserId+"'");
                PITableDatlinka.executeQuery();
                
                
                //System.out.println("Query is : "+PITableData.getQuery());
                
                
                myfile =(UploadedFile) sessionMap1.get("myfile");
                String   path = (String)sessionMap1.get("rootpath")  ;
                Map sessionMap4 = ectx.getSessionMap();
                sessionMap4.put("Attachment",attachment);
              
               // getPiPhoto(facesContext,out) ;
                getUploadedFile().setValue("attachment");              
                //System.out.println("Query is : "+PITableData.getQuery());
                                          
               // System.out.println(PITableData.getRowCount());
                AdfFacesContext.getCurrentInstance().addPartialTarget(editPanel);
                //FileOutputStream out = new FileOutputStream(attachment);

             
            }
        } catch (Exception e) {
            //System.out.println("Error occurred..." + e.toString());
        }
           //  return "success";
           logger.info("End PISelectionListener Method of PINewProfileMBean "); 
    }

    public String Update() {
        logger.info("Start Update Method of PINewProfileMBean ");
        try
        {
            Boolean resultvalid = validateUpdatePIData();
            if(resultvalid)
            {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PIUserMstUVO2Iterator");
        ViewObjectImpl PIProfileVO = (ViewObjectImpl)dcItterator.getViewObject();
        PIUserMstUVORowImpl selectedrow = (PIUserMstUVORowImpl)PIProfileVO.getCurrentRow();
        //selectedrow.setAttribute("ActiveFlag", 'N');
        selectedrow.setUpdatedBy(userName);
        selectedrow.setUpdatedDate(sqlDate);
        BindingContainer bindings = getBindings();
        String userId = selectedrow.getUserId();
            String rootPath = "//cpmsshare";
                 String subFolderPath = "PIProfile//PIPhoto";  
            String chaildDir= "PIProfile//PIPhoto";
            //UploadedFile myfile = (UploadedFile)this.getMyfile();
            File f1 = new File(rootPath+"//"+subFolderPath); 
                                 if(!f1.isDirectory()){
                                     createDir(subFolderPath+"//"+userId+"//",rootPath);
                                     rootPath = rootPath+"//"+subFolderPath+"//"+userId;
                                 }
                                 else{
                                     File f3 = new File(rootPath+"//"+subFolderPath+"//"+userId); 
                                     if(!f3.isDirectory()){
                                         f3.mkdirs();
                                         rootPath = rootPath+"//"+subFolderPath+"//"+userId;
                                     }
                                     else {
                                         rootPath = rootPath+"//"+subFolderPath+"//"+userId; 
                                     }
                                     
                                 }
            FacesContext context = FacesContext.getCurrentInstance();
                               ExternalContext ectx = context.getExternalContext();
                               Map sessionMap = ectx.getSessionMap();
            InputStream inputstream =(InputStream)sessionMap.get("InputStream");
            Map sessionMap1 = ectx.getSessionMap();
            if(sessionMap1.get("myfile") != null)
            {
            myfile =(UploadedFile) sessionMap1.get("myfile");
            Map sessionMap3 = ectx.getSessionMap();
            String rootpathsession =
                        (String)sessionMap3.put("rootpath",rootPath);
                
                              File f = new File(rootPath+"//"+myfile.getFilename());
            OutputStream out = new FileOutputStream(f);
                              byte buf[] = new byte[1024];
                              int len;
                              while ((len = inputstream.read(buf)) > 0)
                                  out.write(buf, 0, len);
                              out.close();
            String filetype = myfile.getContentType();
                              //System.out.println(filetype);
                              String fileExt =filetype.substring(filetype.lastIndexOf("/") + 1); 
                             // System.out.println(fileExt);
            byte b[]  = IOUtils.toByteArray(inputstream);
            selectedrow.setAttribute("Attachment", rootPath+"//"+myfile.getFilename()); 
            }
        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "PI Profile of UserId " + " " +userId + " Updated successfully "));
            pageflowScope.put("Button","disable");
            pageflowScope.put("Entered","disable");
            sessionMap1.remove("myfile");
            sessionMap.remove("InputStream");
            searchTable.getSelectedRowKeys().clear();
            
            return null;
        }
        }
            
        }
        
        catch (Exception e) {
                           e.printStackTrace();
                       }
        logger.info("End Update Method of PINewProfileMBean ");
        return null;
       
    }
    public void getPiPhoto(FacesContext facesContext, OutputStream outputStream) throws IOException {
           logger.info("Start getPiPhoto Method of PINewProfileMBean ");
          // String filePath = "D:\\cpmsshare\\PIProfile\\PIPhoto\\AD044\\insert.txt";//(String)getFilePropertyCommandLink().getAttributes().get("filePath");
          FacesContext context = FacesContext.getCurrentInstance();
                             ExternalContext ectx = context.getExternalContext();
          Map sessionMap4 = ectx.getSessionMap();
           String   filePath = (String)sessionMap4.get("Attachment")  ;
           File filed = new File(filePath);
           FileInputStream fis;
           byte[] b;
           try {
               fis = new FileInputStream(filed);

               int n;
               while ((n = fis.available()) > 0) {
                   b = new byte[n];
                   int result = fis.read(b);
                   outputStream.write(b, 0, b.length);
                   if (result == -1)
                       break;
               }
               outputStream.flush();
           } catch (IOException e) {
               e.printStackTrace();
           }
           logger.info("End getPiPhoto Method of PINewProfileMBean ");
       }
    
    public Boolean validatePIData()
    {
        logger.info("Start validatePIData Method of PINewProfileMBean ");
    Boolean result = true;
        DCIteratorBinding holdVOIter =
            bindingsAM.findIteratorBinding("PIUserMstUVO1Iterator");
        ViewObjectImpl PICreateVO = (ViewObjectImpl)holdVOIter.getViewObject();
        if(PICreateVO != null)
        {
            PIUserMstUVORowImpl PICreateRow = (PIUserMstUVORowImpl)PICreateVO.getCurrentRow();   
            if(PICreateRow != null)
            {
                Object PIId = PICreateRow.getUserId();
                Object FirstName = PICreateRow.getFirstName();
                Object LastName = PICreateRow.getLastName();
                Object Address1 = PICreateRow.getLocalAdd1();
                Object City = PICreateRow.getLocalCity();
                Object Country = PICreateRow.getLocalCountry();
                Object Nationality = PICreateRow.getNationality();
                Object Hiredate = PICreateRow.getHireDate();
                Object TrainingStatus = PICreateRow.getTrainingstatus();
                Object dob = PICreateRow.getBirthDate();
                
               if(PIId == null || PIId.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("406",lgCode)));
                         //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI Id"));            
                         result = false;  
                }  
                if(FirstName == null || FirstName.equals(""))
                {
                    
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("407",lgCode)));
                    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter First Name"));            
                     result = false;  
                 } 
                if(LastName == null || LastName.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("408",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Last Name"));            
                     result = false;  
                 }
                if(dob == null || dob.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("409",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Date of Birth"));            
                     result = false;  
                 } 
                if(Address1 == null || Address1.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("411",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Address1"));            
                     result = false;   
                 }
                if(City == null || City.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("413",lgCode)));
                    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter City"));            
                     result = false;   
                 }
                if(Country == null || Country.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("414",lgCode)));
                    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Country"));            
                     result = false;   
                }
                if(Nationality == null || Nationality.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("415",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Nationality"));            
                     result = false;   
                 }  
                if(Hiredate == null || Hiredate.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("417",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter HireDate"));            
                     result = false;   
                 }               
                if(TrainingStatus == null || TrainingStatus.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("460",lgCode)));
                    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select Training Status"));            
                     result = false;   
                 } 
               
         
            }           
        }
        logger.info("End validatePIData Method of PINewProfileMBean ");
    return result;    
    }
    public Boolean validateUpdatePIData()
    {
   logger.info("Start validateUpdatePIData Method of PINewProfileMBean ");
    Boolean result = true;
        DCIteratorBinding holdVOIter =
            bindingsAM.findIteratorBinding("PIUserMstUVO2Iterator");
        ViewObjectImpl PICreateVO = (ViewObjectImpl)holdVOIter.getViewObject();
        if(PICreateVO != null)
        {
            PIUserMstUVORowImpl PICreateRow = (PIUserMstUVORowImpl)PICreateVO.getCurrentRow();   
            if(PICreateRow != null)
            {
                Object PIId = PICreateRow.getUserId();
                Object FirstName = PICreateRow.getFirstName();
                Object LastName = PICreateRow.getLastName();
                Object Address1 = PICreateRow.getLocalAdd1();
                Object City = PICreateRow.getLocalCity();
                Object Country = PICreateRow.getLocalCountry();
                Object Nationality = PICreateRow.getNationality();
                Date Hiredate = (Date)PICreateRow.getHireDate();
                Object TrainingStatus = PICreateRow.getTrainingstatus();
                Date dob =(Date) PICreateRow.getBirthDate();
                Object passportnumber = PICreateRow.getPassportNumber();
                Date dateofissue = (Date)PICreateRow.getpssptDateofIssue();
                Date dateofexpiry = (Date)PICreateRow.getPSSPTDateofExpiry();
                Object emiratesId = PICreateRow.getEmiratesId();
                String medflag=PICreateRow.getmedicaltestcompletedflag().toString();
                String intTraining=PICreateRow.getIntExtTrainingStatus().toString();
                String extTraining= PICreateRow.getExtTrainingStatus().toString();
                
                if(PIId == null || PIId.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("406",lgCode)));
                    
                        // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PI Id"));            
                         result = false;  
                }  
                if(FirstName == null || FirstName.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("407",lgCode)));
                    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter First Name"));            
                     result = false;  
                 } 
                if(LastName == null || LastName.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("408",lgCode)));
                   //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Last Name"));            
                     result = false;  
                 }
                if(dob == null || dob.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("409",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Date of Birth"));            
                     result = false;  
                 } 
                else if((dob).after(new Date())){
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("455",lgCode)));
                 //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", " Date of Birth should be Before Current Date"));  
                 result = false;
             }
             
                    
                           if(passportnumber == null ){
                     if((dateofissue !=null && dateofexpiry !=null)){
                             FacesContext.getCurrentInstance().addMessage(null,
                                                                          new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                           "Sample info message",
                                                                                           genMsg.getMessage("456",lgCode)));
                           //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "You Cannot Enter Issue Date and ExpiryDate without Passport number"));
                           result = false;
                         }}
                if(passportnumber != null) {
                  
                Row[] filteredRows = PICreateVO.getFilteredRows("PassportNumber", passportnumber);
                    if(filteredRows.length>1)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Passport Number is already registered for another user"));
                        result = false;
                    }

                }
                         if(dateofissue != null && dateofexpiry != null )
                         {
                          if(dateofissue.after(dateofexpiry)){
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                       "Sample info message",
                                                                                       genMsg.getMessage("457",lgCode)));
                        // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Issue Date Should be Less than Expiry Date"));
                        result = false;
                     }
                          if(dob!= null)
                          {
                     if(dateofissue.before(dob) && dateofexpiry.before(dob)){
                         
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                       "Sample info message",
                                                                                       genMsg.getMessage("458",lgCode)));
                         //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Passport Issue Date and Expiry Should be greater than Date of Birth"));
                         result = false;
                        
                     }
                     }}
                         if(dob != null && Hiredate != null)
                         {
                if(dob.after(Hiredate)){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("459",lgCode)));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Hire Date cannot be greater than  date of birth"));
                    result = false;
                }
                    if(Hiredate.after(new Date())){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", " Hire Date  should not be Greater than Current Date "));  
                    return null;  
                    }
                }
                if(Address1 == null || Address1.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("411",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Address1"));            
                     result = false;   
                 }
                if(City == null || City.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("413",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter City"));            
                     result = false;   
                 }
                if(Country == null || Country.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("414",lgCode)));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Country"));            
                     result = false;   
                }
                if(Nationality == null || Nationality.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("415",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Nationality"));            
                     result = false;   
                 }  
                if(Hiredate == null || Hiredate.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("417",lgCode)));
                     //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter HireDate"));            
                     result = false;   
                 }  
                if(emiratesId == null || emiratesId.equals("emiratesId")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Emirates Id")); 
                    result = false;  
                }
                if(TrainingStatus == null || TrainingStatus.equals(""))
                {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("460",lgCode)));
                    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select Training Status"));            
                     result = false;   
                 }    
                int tstaus=Integer.parseInt(TrainingStatus.toString());
                if(tstaus==3 && medflag.equals("N")){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "Medical examination is mandatory before PI Deployment")); 
                    //piStatusUpdate.setDisabled(false); 
                    result=false;
                }
                else{
                    //piStatusUpdate.setDisabled(true);   
                }
                
                if(tstaus==3 && intTraining.equals("E")){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "Internal Training is mandatory before PI Deployment")); 
                    //piStatusUpdate.setDisabled(false); 
                    result=false;
                }
                else{
                    //piStatusUpdate.setDisabled(true);   
                }
                if(tstaus==3 && extTraining.equals("N")){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "External Training is mandatory before PI Deployment")); 
                    //piStatusUpdate.setDisabled(false); 
                    result=false;
                }
                else{
                    //piStatusUpdate.setDisabled(true);   
                }
                if(tstaus==3 && medflag.equals("Y") && intTraining.equals("I") && extTraining.equals("E") )
                    piStatusUpdate.setDisabled(true);
                else
                piStatusUpdate.setDisabled(false);
                
               
            }           
        }
        logger.info("Start validateUpdatePIData Method of PINewProfileMBean ");
    return result;    
    }

    public String Confirm() {
        logger.info("Start Confirm Method of PINewProfileMBean ");
        String Reasons = null;
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        if( getReasonsDeactivate().getValue()!=null) 
        {
            Reasons = getReasonsDeactivate().getValue().toString();
        }
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PIUserMstUVO2Iterator");
        ViewObjectImpl PIProfileVO = (ViewObjectImpl)dcItterator.getViewObject();
        PIUserMstUVORowImpl selectedrow = (PIUserMstUVORowImpl)PIProfileVO.getCurrentRow();
        selectedrow.setAttribute("ActiveFlag", 'N');
        selectedrow.setUpdatedBy(userName);
        selectedrow.setUpdatedDate(sqlDate);
        selectedrow.setDeactivationReason(Reasons);
        String userId = selectedrow.getUserId();
        BindingContainer bindings = getBindings();
        OperationBinding operationBindingcreate =getBindings1().getOperationBinding("deactivatworkpi");
        operationBindingcreate.getParamsMap().put("userId",userId);
        operationBindingcreate.execute();
        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
        Object result = operationBinding.execute();
            if (operationBinding.getErrors().isEmpty()) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "PI of UserId " +" "+userId +  " deactivated successfully "));
            return null;
        }
        logger.info("End Confirm Method of PINewProfileMBean ");
        return null;
        
    }
    public void ResetSearchPage(QueryOperationEvent queryOperationEvent) {
        logger.info("Start ResetSearchPage Method of PINewProfileMBean ");
          invokeMethodExpression("#{bindings.PIUserMstUVOCriteriaQuery.processQueryOperation}",
        Object.class,   
                                 new Class[]{ QueryOperationEvent.class},  
                                 new Object [] {queryOperationEvent});
          
          if(queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")){
              
           
                  DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                  DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PIUserMstUVO1Iterator");
                  ViewObjectImpl PIProfileVO = (ViewObjectImpl)dcItterator.getViewObject();
                  PIProfileVO.clearCache();
                          PIProfileVO.setWhereClause(null);
                          PIProfileVO.setWhereClauseParams(null);
                        PIProfileVO.executeQuery();
    
              }
        logger.info("End ResetSearchPage Method of PINewProfileMBean ");
        // Add event code here...
    }
    public Object invokeMethodExpression(String expr, Class returnType,  
                                           Class[] argTypes, Object[] args)  
      {  
          logger.info("Start invokeMethodExpression Method of PINewProfileMBean ");
        FacesContext fc = FacesContext.getCurrentInstance();  
        ELContext elctx = fc.getELContext();  
        ExpressionFactory elFactory =  
          fc.getApplication().getExpressionFactory();
    //        ExpressionFactory expressionFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr =  
          elFactory.createMethodExpression(elctx, expr, returnType, argTypes);  
          logger.info("End invokeMethodExpression Method of PINewProfileMBean ");
        return methodExpr.invoke(elctx, args);  
      }

    public void setReasonsDeactivate(RichInputText reasonsDeactivate) {
        this.reasonsDeactivate = reasonsDeactivate;
    }

    public RichInputText getReasonsDeactivate() {
        return reasonsDeactivate;
    }

    public void setEditPanel(RichPanelGroupLayout editPanel) {
        this.editPanel = editPanel;
    }

    public RichPanelGroupLayout getEditPanel() {
        return editPanel;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }

    public void setPiId(RichInputText piId) {
        this.piId = piId;
    }

    public RichInputText getPiId() {
        return piId;
    }

    public String Cancel() {
        logger.info("Start Cancel Method of PINewProfileMBean ");
        pageflowScope.put("Button","disable");
        pageflowScope.put("Entered","disable");
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        logger.info("End Cancel Method of PINewProfileMBean ");
        return null;
    }

    public void setIntExtStatus(RichSelectOneRadio intExtStatus) {
        this.intExtStatus = intExtStatus;
    }

    public RichSelectOneRadio getIntExtStatus() {
        return intExtStatus;
    }

    public void onFileUpload(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        logger.info("Start onFileUpload Method of PINewProfileMBean ");
        try {
                  
              myfile = (UploadedFile)valueChangeEvent.getNewValue();
                   InputStream inputstream = myfile.getInputStream();
                   //System.out.println(myfile);
                   String filetype = myfile.getContentType();
                   //System.out.println(filetype);
                   String fileExt = filetype.substring(filetype.lastIndexOf("/") + 1);
                   FacesContext context = FacesContext.getCurrentInstance();
                   ExternalContext ectx = context.getExternalContext();
                   Map sessionMap = ectx.getSessionMap();
                   sessionMap.put("InputStream",inputstream);
            sessionMap.put("myfile",myfile);
                   //System.out.println(fileExt);
               } catch (IOException e) {
                   e.printStackTrace();
               }
        logger.info("End onFileUpload Method of PINewProfileMBean ");
    }

    public void setUploadedFile(RichInputFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public RichInputFile getUploadedFile() {
        return uploadedFile;
    }

    public void setMyfile(UploadedFile myfile) {
        this.myfile = myfile;
    }

    public UploadedFile getMyfile() {
        return myfile;
    }

    public void setPiIdNew(RichInputText piIdNew) {
        this.piIdNew = piIdNew;
    }

    public RichInputText getPiIdNew() {
        return piIdNew;
    }

    public void setFirstnameNew(RichInputText firstnameNew) {
        this.firstnameNew = firstnameNew;
    }

    public RichInputText getFirstnameNew() {
        return firstnameNew;
    }

    public void setLastNameNew(RichInputText lastNameNew) {
        this.lastNameNew = lastNameNew;
    }

    public RichInputText getLastNameNew() {
        return lastNameNew;
    }

    public void setGendernew(RichSelectOneRadio gendernew) {
        this.gendernew = gendernew;
    }

    public RichSelectOneRadio getGendernew() {
        return gendernew;
    }

    public void setDoBNew(RichInputDate doBNew) {
        this.doBNew = doBNew;
    }

    public RichInputDate getDoBNew() {
        return doBNew;
    }

    public void setAddr1New(RichInputText addr1New) {
        this.addr1New = addr1New;
    }

    public RichInputText getAddr1New() {
        return addr1New;
    }

    public void setAddr2New(RichInputText addr2New) {
        this.addr2New = addr2New;
    }

    public RichInputText getAddr2New() {
        return addr2New;
    }

    public void setCityNew(RichSelectOneChoice cityNew) {
        this.cityNew = cityNew;
    }

    public RichSelectOneChoice getCityNew() {
        return cityNew;
    }

    public void setCountryNew(RichSelectOneChoice countryNew) {
        this.countryNew = countryNew;
    }

    public RichSelectOneChoice getCountryNew() {
        return countryNew;
    }

    public void setEmiratesIdNew(RichInputText emiratesIdNew) {
        this.emiratesIdNew = emiratesIdNew;
    }

    public RichInputText getEmiratesIdNew() {
        return emiratesIdNew;
    }

    public void setPiStatusNew(RichSelectOneChoice piStatusNew) {
        this.piStatusNew = piStatusNew;
    }

    public RichSelectOneChoice getPiStatusNew() {
        return piStatusNew;
    }

    public void setPassportNumberNew(RichInputText passportNumberNew) {
        this.passportNumberNew = passportNumberNew;
    }

    public RichInputText getPassportNumberNew() {
        return passportNumberNew;
    }

    public void setDateofIssueNew(RichInputDate dateofIssueNew) {
        this.dateofIssueNew = dateofIssueNew;
    }

    public RichInputDate getDateofIssueNew() {
        return dateofIssueNew;
    }

    public void setDateofExpiryNew(RichInputDate dateofExpiryNew) {
        this.dateofExpiryNew = dateofExpiryNew;
    }

    public RichInputDate getDateofExpiryNew() {
        return dateofExpiryNew;
    }

    public void setNationalityNew(RichSelectOneChoice nationalityNew) {
        this.nationalityNew = nationalityNew;
    }

    public RichSelectOneChoice getNationalityNew() {
        return nationalityNew;
    }

    public void setEducationalNew(RichSelectOneChoice educationalNew) {
        this.educationalNew = educationalNew;
    }

    public RichSelectOneChoice getEducationalNew() {
        return educationalNew;
    }

    public void setHireDate(RichInputDate hireDate) {
        this.hireDate = hireDate;
    }

    public RichInputDate getHireDate() {
        return hireDate;
    }

    public void setMedicalNew(RichInputText medicalNew) {
        this.medicalNew = medicalNew;
    }

    public RichInputText getMedicalNew() {
        return medicalNew;
    }

    public void setHealthNew(RichSelectOneChoice healthNew) {
        this.healthNew = healthNew;
    }

    public RichSelectOneChoice getHealthNew() {
        return healthNew;
    }

    public void setCommentsNew(RichInputText commentsNew) {
        this.commentsNew = commentsNew;
    }

    public RichInputText getCommentsNew() {
        return commentsNew;
    }

    public void setTrainingstatus(RichSelectOneRadio trainingstatus) {
        this.trainingstatus = trainingstatus;
    }

    public RichSelectOneRadio getTrainingstatus() {
        return trainingstatus;
    }

  

    public void setHiredateNew(RichInputDate hiredateNew) {
        this.hiredateNew = hiredateNew;
    }

    public RichInputDate getHiredateNew() {
        return hiredateNew;
    }

    public void setTrainingstatusNew(RichSelectOneRadio trainingstatusNew) {
        this.trainingstatusNew = trainingstatusNew;
    }

    public RichSelectOneRadio getTrainingstatusNew() {
        return trainingstatusNew;
    }

   

    public void onFileUploadUpdate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        try {
                  
              myfile = (UploadedFile)valueChangeEvent.getNewValue();
                   InputStream inputstream = myfile.getInputStream();
                   //System.out.println(myfile);
                   String filetype = myfile.getContentType();
                   //System.out.println(filetype);
                   String fileExt = filetype.substring(filetype.lastIndexOf("/") + 1);
                   FacesContext context = FacesContext.getCurrentInstance();
                   ExternalContext ectx = context.getExternalContext();
                   Map sessionMap = ectx.getSessionMap();
                   sessionMap.put("InputStream",inputstream);
                   sessionMap.put("myfile",myfile);
                   //System.out.println(fileExt);
                  
               } catch (IOException e) {
                   e.printStackTrace();
               }
    }

    public void setUploadedUpdateFile(RichInputFile uploadedUpdateFile) {
        this.uploadedUpdateFile = uploadedUpdateFile;
    }

    public RichInputFile getUploadedUpdateFile() {
        return uploadedUpdateFile;
    }
    public void setTrainingupdate(RichSelectOneRadio trainingupdate) {
        this.trainingupdate = trainingupdate;
    }

    public RichSelectOneRadio getTrainingupdate() {
        return trainingupdate;
    }

    public void setPiStatusUpdate(RichSelectOneChoice piStatusUpdate) {
        this.piStatusUpdate = piStatusUpdate;
    }

    public RichSelectOneChoice getPiStatusUpdate() {
        return piStatusUpdate;
    }

    public void setSearchTable(RichTable searchTable) {
        this.searchTable = searchTable;
    }

    public RichTable getSearchTable() {
        return searchTable;
    }

    public void setTrainingCheckbox(RichSelectManyCheckbox trainingCheckbox) {
        this.trainingCheckbox = trainingCheckbox;
    }

    public RichSelectManyCheckbox getTrainingCheckbox() {
        return trainingCheckbox;
    }

   

    public void setInternalTrainingNew(RichSelectItem internalTrainingNew) {
        this.internalTrainingNew = internalTrainingNew;
    }

    public RichSelectItem getInternalTrainingNew() {
        return internalTrainingNew;
    }

    public void setExternalTrainingNew(RichSelectItem externalTrainingNew) {
        this.externalTrainingNew = externalTrainingNew;
    }

    public RichSelectItem getExternalTrainingNew() {
        return externalTrainingNew;
    }

    public void setInternaltrainingUpdate(RichSelectItem internaltrainingUpdate) {
        this.internaltrainingUpdate = internaltrainingUpdate;
    }

    public RichSelectItem getInternaltrainingUpdate() {
        return internaltrainingUpdate;
    }

    public void setExternalTrainingUpdate(RichSelectItem externalTrainingUpdate) {
        this.externalTrainingUpdate = externalTrainingUpdate;
    }

    public RichSelectItem getExternalTrainingUpdate() {
        return externalTrainingUpdate;
    }

    public void setInternalCheck(RichSelectBooleanCheckbox internalCheck) {
        this.internalCheck = internalCheck;
    }

    public RichSelectBooleanCheckbox getInternalCheck() {
        return internalCheck;
    }

    public void setExternalCheck(RichPanelFormLayout externalCheck) {
        this.externalCheck = externalCheck;
    }

    public RichPanelFormLayout getExternalCheck() {
        return externalCheck;
    }

    public void setExternalchecked(RichSelectBooleanCheckbox externalchecked) {
        this.externalchecked = externalchecked;
    }

    public RichSelectBooleanCheckbox getExternalchecked() {
        return externalchecked;
    }

    public void setInternalTraining(RichSelectBooleanCheckbox internalTraining) {
        this.internalTraining = internalTraining;
    }

    public RichSelectBooleanCheckbox getInternalTraining() {
        return internalTraining;
    }

    public void setExternalTraining(RichSelectBooleanCheckbox externalTraining) {
        this.externalTraining = externalTraining;
    }

    public RichSelectBooleanCheckbox getExternalTraining() {
        return externalTraining;
    }

    public void selectedgroup(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
         groupid  = JSFUtils.resolveExpression("#{bindings.SelectGroup.attributeValue}").toString();
        pageflowScope.put("groupid",groupid);
    }

    public void setMedicalexamcheck(RichSelectBooleanCheckbox medicalexamcheck) {
        this.medicalexamcheck = medicalexamcheck;
    }

    public RichSelectBooleanCheckbox getMedicalexamcheck() {
        return medicalexamcheck;
    }

    public void setUpdateMedExamCheck(RichSelectBooleanCheckbox updateMedExamCheck) {
        this.updateMedExamCheck = updateMedExamCheck;
    }

    public RichSelectBooleanCheckbox getUpdateMedExamCheck() {
        return updateMedExamCheck;
    }
}
