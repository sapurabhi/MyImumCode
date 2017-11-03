package com.imum.cpms.staffdeployment;

import com.imum.cpms.util.ADFUtils;

import com.imum.cpms.util.FileUpload;
import com.imum.cpms.util.MessageUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;

import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;
import javax.faces.event.ActionEvent;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adfinternal.view.faces.taglib.listener.ResetActionListener;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class piobservationsMB {
//    FacesContext facesContext = FacesContext.getCurrentInstance();
//    ExternalContext externalContext = facesContext.getExternalContext();
//    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
//    private RichInputDate date;
//    private RichInputText observation;

    
    private RichSelectOneChoice CIDC;
    private RichInputText ciDcom;
    private RichSelectOneChoice leavePayRecevied;
    private RichInputText leavePayReceivedCom;
    private RichSelectOneChoice trainingNeeds;
    private RichInputText trainingneedsCom;
    private RichSelectOneChoice employmentCon;
    private RichInputText employmentContcom;
    private RichSelectOneChoice housingallowance;
    private RichSelectOneChoice occupationalInsurance;
    private RichSelectOneChoice embezzrement;
    private RichSelectOneChoice empletter;
    private RichSelectOneChoice piBeh;
    private RichInputText piBhacom;
    private RichSelectOneChoice piEx;
    private RichInputDate uidate;
    private RichSelectOneChoice piidselect;
    private RichPanelFormLayout pf11;
    MessageUtil genMsg = new MessageUtil();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    public static final ADFLogger logger = ADFLogger.createADFLogger(piobservationsMB.class);
    private RichPanelGroupLayout newviewbtnsbind;
    private RichShowDetailHeader sdhBind;
    private RichShowDetailHeader sdhtablebind;
    private RichShowDetailHeader sdhviewbind;
    private Row currentAttchmtRow=null;
    private RichTable docTable;
    private String rootPath = "//cpmsshare";
   // private String rootPath = "D://cpmsshare";
    private RichSelectOneChoice piIdBind;
    private RichSelectOneChoice supLovBind;
    private RichShowDetailHeader editSdhBind;
    private RichInputText editPiIdBind;
    private RichInputDate uidate1;
    private RichSelectOneChoice ciDC1;
    private RichSelectOneChoice employmentCon1;
    private RichSelectOneChoice leavePayRecevied1;
    private RichSelectOneChoice embezzrement1;
    private RichSelectOneChoice empletter1;
    private RichSelectOneChoice housingallowance1;
    private RichSelectOneChoice occupationalInsurance1;
    private RichSelectOneChoice piEx1;
    private RichSelectOneChoice trainingNeeds1;


    public piobservationsMB() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    private DCBindingContainer getBindings1() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }

   

    public void piObservationsSave(ActionEvent actionEvent) {
        logger.info("Start piObservationsSave Method of piobservationsMB ");
        ADFContext adfctx = ADFContext.getCurrent();
       adfctx.getSessionScope().get("loggedinUserid");
         String userName =(String)adfctx.getSessionScope().get("loggedinUserid").toString(); 
         //System.out.println("--------------Save----------");
        String pibcom ="";
        String cidcom1="";
        String leavepaycom="";
        String trainingcom="";
        String employcom="";
        Object checkd=uidate.getValue();
        Object cid=CIDC.getValue();
        Object tn=trainingNeeds.getValue();
        Object  lpr=leavePayRecevied.getValue();
        Object echeck=employmentCon.getValue();
        Object hcheck=housingallowance.getValue();
        Object eplatter=empletter.getValue();
        Object emz=embezzrement.getValue();
        Object  occheck=occupationalInsurance.getValue();
        Object checkpiEx=piEx.getValue();
        
        
    
        //        employmentCon.getValue();
        //        employmentContcom.getValue();
        //        housingallowance.getValue();
        //        occupationalInsurance.getValue();
        //        embezzrement.getValue();
        //        empletter.getValue();
        
        
        
        try{
      
       
       if(checkd==null)
        {
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                       "Sample info message",
                                                                                       genMsg.getMessage("435",lgCode)));
//       FacesMessage fm = new FacesMessage("Date should be  mandatory  ");
//       fm.setSeverity(FacesMessage.SEVERITY_INFO);
//       FacesContext fctx = FacesContext.getCurrentInstance();
//       fctx.addMessage(null, fm);
       return;
                     }
      Date currentDate = new Date(System.currentTimeMillis());
      java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
      String scudate=sqlDate1.toString().replaceAll("-","");
      Date from=(Date)uidate.getValue();
      java.sql.Date  fdate= new java.sql.Date(from.getTime());
      String sfdate=fdate.toString().replaceAll("-","");
       //System.out.println("from date"+scudate); 
      //System.out.println("to date"+sfdate);
        int ifdate=Integer.parseInt(sfdate);
      int icudate=Integer.parseInt(scudate);

            
            
                       
            if(ifdate > icudate)   {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("436",lgCode)));
//                FacesMessage fm = new FacesMessage("Date should Not be Greter Than currnet Date   ");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm); 
                return;
            }
            
            
        if(cid==null)
        {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("437",lgCode)));
//        FacesMessage fm = new FacesMessage("CIDClearance should be mandatory  ");
//        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//        FacesContext fctx = FacesContext.getCurrentInstance();
//        fctx.addMessage(null, fm); 
        return;
                 }
            if(echeck==null) {
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "Sample info message",
                                                                                          genMsg.getMessage("447",lgCode)));
//                FacesMessage fm = new FacesMessage("employment contract should be mandatory  ");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm); 
                return;
                        }
         if(lpr==null)   {
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                           "Sample info message",
                                                                           genMsg.getMessage("438",lgCode)));
//             FacesMessage fm = new FacesMessage("leavePayRecevied should be mandatory  ");
//             fm.setSeverity(FacesMessage.SEVERITY_INFO);
//             FacesContext fctx = FacesContext.getCurrentInstance();
//             fctx.addMessage(null, fm); 
             return;
         }
            if(tn==null)
            {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("439",lgCode)));
//                    FacesMessage fm = new FacesMessage("trainingNeeds should be mandatory  ");
//                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                    FacesContext fctx = FacesContext.getCurrentInstance();
//                    fctx.addMessage(null, fm); 
                    return;
                
                }
            if(emz==null) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("440",lgCode)));
//                FacesMessage fm = new FacesMessage("Embezzlement should be mandatory  ");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm); 
                return;
                
            }
            if(eplatter==null)   
            {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("441",lgCode)));
//                    FacesMessage fm = new FacesMessage("employement letter from compay be mandatory  ");
//                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                    FacesContext fctx = FacesContext.getCurrentInstance();
//                    fctx.addMessage(null, fm); 
                    return;
                
                }
           
            
            if(hcheck==null)   
            {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("442",lgCode)));
//                    FacesMessage fm = new FacesMessage("Housing allowance should be mandatory  ");
//                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                    FacesContext fctx = FacesContext.getCurrentInstance();
//                    fctx.addMessage(null, fm); 
                    return;
                
                }
            
           
            if(occheck==null)   {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("443",lgCode)));
//                FacesMessage fm = new FacesMessage("Occupational Insurance should be mandatory ");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm); 
                return;
            }
            if(checkpiEx==null)   {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("444",lgCode)));
//                FacesMessage fm = new FacesMessage("Excuses Made By PI  should be mandatory ");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm); 
                return;
            }
            
            
            if(employmentContcom.getValue()== null)   {
                employmentContcom.setValue(null);
            }
            else {
                employcom=employmentContcom.getValue().toString();
            }
            if(trainingneedsCom.getValue()== null)   {
                trainingneedsCom.setValue(null);
            }
            else {
                trainingcom=trainingneedsCom.getValue().toString(); 
            }
            if(leavePayReceivedCom.getValue()== null)   {
                leavePayReceivedCom.setValue(null);
            }
            else {
               leavepaycom=leavePayReceivedCom.getValue().toString();  
            }
            
            if(ciDcom.getValue()== null)   {
                ciDcom.setValue(null);
            }
            else {
                cidcom1=ciDcom.getValue().toString(); 
            }
            
            if(piBhacom.getValue()== null)   {
                piBhacom.setValue(null);
            }else{
               pibcom=piBhacom.getValue().toString();
            }
            DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                                  DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("PIObservationDocsVO1Iterator");
                                  ViewObject pvtDocsImpl =dcIteratorBinding.getViewObject();
                                                   
                                 RowSetIterator iterator = pvtDocsImpl.createRowSetIterator(null);    
                                 iterator.reset();
                       while (iterator.hasNext()) {
                           Row docRow = iterator.next();

                           UploadedFile uploadFile =
                               (UploadedFile)docRow.getAttribute("FileUpload");
                           String docsDesc = (String)docRow.getAttribute("DOCName");
                           String docMflag = (String)docRow.getAttribute("FlageM");
                           if (uploadFile == null) {
                               if (docMflag.equals("Y")) {
                                  
                                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please upload mandatory PVT Documents "));       
            //                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
            //                                    "Sample info message",
            //                                    genMsg.getMessage("100", lngCode)));
                                   return ;
                               }
                              
                           }
                           if (docsDesc == null) {
                                                              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           "Sample info message",
                                           "Please enter the Document Name"));
                               return ;
                           }
                       } 
            
            //remove rows 
            DCIteratorBinding dcIteratorBinding1= bindings1.findIteratorBinding("PIObservationDocsVO1Iterator");
            ViewObject pvtDocsImpl1 =dcIteratorBinding1.getViewObject();
            RowSetIterator iterator1 = pvtDocsImpl1.createRowSetIterator(null);
            iterator1.reset();
            while (iterator1.hasNext()) {
            Row docRow1= iterator1.next();

            UploadedFile uploadFile =
            (UploadedFile)docRow1.getAttribute("FileUpload");
            String docsDesc = (String)docRow1.getAttribute("DOCName");
            String docMflag = (String)docRow1.getAttribute("FlageM");
            if (uploadFile == null) {
            if (docMflag.equals("Y")) {
                       }
            else {
             pvtDocsImpl.setCurrentRow(docRow1);
             pvtDocsImpl.removeCurrentRow();
            }
            }
            if (docsDesc == null) {
            
            }
            }
                
         
//        Date date1=(Date)date.getValue();         
//        String cid=CIDC.getValue().toString();
//        String leavepay=leavePayRecevied.getValue().toString();
//        String training= trainingNeeds.getValue().toString();
//        String employ=employmentCon.getValue().toString();
//        String hous= housingallowance.getValue().toString();
//        String occ=occupationalInsurance.getValue().toString(); 
//        String emb=embezzrement.getValue().toString();
//        String emplett=empletter.getValue().toString();
            
            
      // String pib=piBeh.getValue().toString();
      String leavepay=leavePayRecevied.getValue().toString();
      //System.out.println(leavepay);
      String training= trainingNeeds.getValue().toString();
      String employ=employmentCon.getValue().toString();
      String hous= housingallowance.getValue().toString();
      String occ=occupationalInsurance.getValue().toString(); 
      String emb=embezzrement.getValue().toString();
      String emplett=empletter.getValue().toString();
       String expix=piEx.getValue().toString();
        
//        leavePayRecevied.getValue();
//        leavePayReceivedCom.getValue();
//        trainingNeeds.getValue();
//        trainingneedsCom.getValue();
//        employmentCon.getValue();
//        employmentContcom.getValue();
//        housingallowance.getValue();
//        occupationalInsurance.getValue();
//        embezzrement.getValue();
//        empletter.getValue();
    JUCtrlListBinding listBinding =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforobservationsLOV1");
    String pi1 = (String)listBinding.getSelectedValue();
            if(pi1.equals(null)) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("428",lgCode)));
//                FacesMessage fm = new FacesMessage("Pi Id Should be  mandatory   ");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm);
                return;
                
            }
            OperationBinding fromdatevalidate = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("validateFromDate");
            fromdatevalidate.getParamsMap().put("startdate",fdate);
             fromdatevalidate.getParamsMap().put("piNumber",pi1);
             String result1 = (String)fromdatevalidate.execute();
                 if(result1.equalsIgnoreCase("noHireDate"))
                 {
                         FacesMessage fm = new FacesMessage("Date should not be less than HireDate ");
                         fm.setSeverity(FacesMessage.SEVERITY_INFO);
                         FacesContext fctx = FacesContext.getCurrentInstance();
                         fctx.addMessage(null, fm);
                         return ;
                     
                     
                     }
            
    JUCtrlListBinding listBinding2 = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("ObservationstypesVO1");
    String obtype = (String)listBinding2.getSelectedValue();
            OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("SavePiobservation");
            op1.getParamsMap().put("pi",pi1 );
            op1.getParamsMap().put("cdate",fdate);
            op1.getParamsMap().put("obtype",obtype);
            op1.getParamsMap().put("pibcom",pibcom);
            op1.getParamsMap().put("employ",employ);
            op1.getParamsMap().put("employcom",employcom );
            op1.getParamsMap().put("cid",cid );
            op1.getParamsMap().put("cidcom1",cidcom1 );
            op1.getParamsMap().put("s", userName );
            op1.getParamsMap().put("training",training);
            op1.getParamsMap().put("trainingcom",trainingcom );
            op1.getParamsMap().put("leavepay",leavepay );
            op1.getParamsMap().put("leavepaycom",leavepaycom );
            op1.getParamsMap().put("emplett",emplett );
            op1.getParamsMap().put("occ",occ );
            op1.getParamsMap().put("hous",hous );
            op1.getParamsMap().put("emb",emb );
            op1.getParamsMap().put("expix",expix );
            op1.execute();
//            DCIteratorBinding dciter = ADFUtils.findIterator("PiobservationsVO1Iterator");
//            dciter.getViewObject().executeQuery();
            
            AdfFacesContext.getCurrentInstance().addPartialTarget(pf11);
            
   // JUCtrlListBinding listBinding = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PiobservationsVO1");
//    ViewObject groupVO = getBindings1().findIteratorBinding("PiobservationsVO1Iterator").getViewObject();
//    Row row = groupVO.getCurrentRow();
//            //System.out.println((Integer.parseInt(employ) == 0)? 'Y':'N');
//        row.setAttribute("PIID",pi); 
//        row.setAttribute("Date",cdate);
//        row.setAttribute("ObservationType",obtype);
//        row.setAttribute("ObservationNotes",pibcom);
//        row.setAttribute("empcontract",employ);
//        row.setAttribute("empcontractcomm",employcom);  
//        row.setAttribute("CIDClearance", cid);
//        row.setAttribute("CIDClearancecomm",cidcom1);
//        row.setAttribute("Supid",s );    
//        row.setAttribute("TrainingNeeds",training);  
//        row.setAttribute("TrainingNeedscomm",trainingcom);  
//        row.setAttribute("LeavePayreceived",leavepay);
//        row.setAttribute("LeavePayreceivedcomm", leavepaycom);  
//        row.setAttribute("empletter",emplett); 
//        row.setAttribute("Occupationalinsurance",occ);
//        row.setAttribute("Housingallowance",hous);  
//        row.setAttribute("Embezzlement",emb);  
//        row.setAttribute("ExcusesPI",expix);    
//        groupVO.setCurrentRow(row);
            
        BindingContainer bindings = getBindings();
           OperationBinding operationBinding = bindings.getOperationBinding("Commit1");
          Object result = operationBinding.execute();
            System.out.println("operation binding info"+operationBinding.getOperationInfo());
         
         if (!operationBinding.getErrors().isEmpty()) {
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                           "Sample info message",
                                                                          "Observations not Successfully" ));
//             FacesMessage fm = new FacesMessage(pi1+"Observations not Successfully");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO); genMsg.getMessage("445",lgCode)
//           FacesContext fctx = FacesContext.getCurrentInstance();
//             fctx.addMessage(null, fm);
          BindingContainer bindings12 = getBindings();
          OperationBinding operationBinding12 = bindings12.getOperationBinding("Rollback");
          Object result12 = operationBinding12.execute();  
         }
            else
         {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("446",lgCode)));
             newviewbtnsbind.setVisible(true);
             sdhtablebind.setVisible(true);
             sdhBind.setVisible(false);
             sdhviewbind.setVisible(false);
                 DCBindingContainer bcbind=(DCBindingContainer) getBindings1();
                 DCIteratorBinding piiter=bcbind.findIteratorBinding("PiobservationsVO2Iterator");
                 ViewObject piobsrvvo=piiter.getViewObject();
                 piobsrvvo.executeQuery();
//                 FacesMessage fm = new FacesMessage(pi1+" Observations done Successfully");
//                 fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                 FacesContext fctx = FacesContext.getCurrentInstance();
//                 fctx.addMessage(null, fm);
             
              DCBindingContainer bindings2= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
              DCIteratorBinding dcIteratorBinding2 = bindings2.findIteratorBinding("PiobservationsVO2Iterator");
              ViewObject piobservo =dcIteratorBinding2.getViewObject();
              piobservo.executeQuery();
              Row row=piobservo.first();
              String id=row.getAttribute("ID").toString();
              BigDecimal newid=new BigDecimal(id);
              System.out.println("New generate Id is:::"+id);
          
                 DCIteratorBinding dciterrefundattchmt =bindings2.findIteratorBinding("PIObservationDocsVO1Iterator");
                 ViewObject pidocsvo = dciterrefundattchmt.getViewObject();
                 pidocsvo.setWhereClause("PI_Observation_ID=123");
                 System.out.println("pidocs updating query is:"+pidocsvo.getQuery());
                 pidocsvo.executeQuery();
                 RowSetIterator rsi=pidocsvo.createRowSetIterator(null);

                 while(rsi.hasNext()) {
                     Row docrow=rsi.next();
                     if(docrow!=null){
                         docrow.setAttribute("PIOBSERVATIONID", newid);
                     }
                    
                    
                 }
                 BindingContainer bindings12 = getBindings();
                    OperationBinding operationBinding12 = bindings12.getOperationBinding("Commit");
                   Object result12 = operationBinding12.execute();
                  
                  if (!operationBinding.getErrors().isEmpty()) {
                      FacesContext.getCurrentInstance().addMessage(null,
                                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                    "Sample info message",
                                                                                    "Updating piObservationID in piobservatindocs failed"));
                 //             FacesMessage fm = new FacesMessage(pi1+"Observations not Successfully");
                 //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                 //           FacesContext fctx = FacesContext.getCurrentInstance();
                 //             fctx.addMessage(null, fm);
                  }
              
                 
             }
           
//        uidate.setValue(" ");
//        this.employmentContcom.setValue("");
//        this.getEmploymentContcom().setValue("");
//        this.getCiDcom().setValue("");
//        this.getLeavePayReceivedCom().setValue("");
//        this.employmentCon.setSubmittedValue("");
//        this.trainingneedsCom.setValue("");
//       this.CIDC.setSubmittedValue("");     
//       this.embezzrement.setSubmittedValue("");
//      this.leavePayRecevied.setSubmittedValue("");
//      this.trainingNeeds.setSubmittedValue("");
//      this.empletter.setSubmittedValue("");
//      this.occupationalInsurance.setSubmittedValue("");
//      this.housingallowance.setSubmittedValue("");
//      this.piEx.setSubmittedValue("");
//      this.piBhacom.setValue("");
//      employmentContcom.setVisible(false);
//      trainingneedsCom.setVisible(false);
//      leavePayReceivedCom.setVisible(false);
//      ciDcom.setVisible(false);
//      this.doReset();
//     JUCtrlListBinding listBindingResetlov =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforobservationsLOV1");
//     listBindingResetlov.setSelectedIndex(0);
//     JUCtrlListBinding listBindingResettype =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("ObservationstypesVO1");
//     listBindingResettype.clearSelectedIndices();
            ResetActionListener ral = new ResetActionListener();
            ral.processAction(actionEvent);
          doReset();
            return;
                
        }
catch(Exception e)    {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("452",lgCode)));
//            FacesMessage fm = new FacesMessage(" Mandatory Filed Should Be Enter   " );
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);     
            
        }

 
    
      
        
        
//        BindingContainer bindings = getBindings();
//        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
//        Object result = operationBinding.execute();
//        if (!operationBinding.getErrors().isEmpty()) {
//            return null;
//        }
     logger.info("End piObservationsSave Method of PileavemangementMB ");
    }

    public void setCIDC(RichSelectOneChoice CIDC) {
        this.CIDC = CIDC;
    }

    public RichSelectOneChoice getCIDC() {
        return CIDC;
    }

    public void setCiDcom(RichInputText ciDcom) {
        this.ciDcom = ciDcom;
    }

    public RichInputText getCiDcom() {
        return ciDcom;
    }

    public void setLeavePayRecevied(RichSelectOneChoice leavePayRecevied) {
        this.leavePayRecevied = leavePayRecevied;
    }

    public RichSelectOneChoice getLeavePayRecevied() {
        return leavePayRecevied;
    }

    public void setLeavePayReceivedCom(RichInputText leavePayReceivedCom) {
        this.leavePayReceivedCom = leavePayReceivedCom;
    }

    public RichInputText getLeavePayReceivedCom() {
        return leavePayReceivedCom;
    }

    public void setTrainingNeeds(RichSelectOneChoice trainingNeeds) {
        this.trainingNeeds = trainingNeeds;
    }

    public RichSelectOneChoice getTrainingNeeds() {
        return trainingNeeds;
    }

    public void setTrainingneedsCom(RichInputText trainingneedsCom) {
        this.trainingneedsCom = trainingneedsCom;
    }

    public RichInputText getTrainingneedsCom() {
        return trainingneedsCom;
    }

    public void setEmploymentCon(RichSelectOneChoice employmentCon) {
        this.employmentCon = employmentCon;
    }

    public RichSelectOneChoice getEmploymentCon() {
        return employmentCon;
    }

    public void setEmploymentContcom(RichInputText employmentContcom) {
        this.employmentContcom = employmentContcom;
    }

    public RichInputText getEmploymentContcom() {
        return employmentContcom;
    }

    public void setHousingallowance(RichSelectOneChoice housingallowance) {
        this.housingallowance = housingallowance;
    }

    public RichSelectOneChoice getHousingallowance() {
        return housingallowance;
    }

    public void setOccupationalInsurance(RichSelectOneChoice occupationalInsurance) {
        this.occupationalInsurance = occupationalInsurance;
    }

    public RichSelectOneChoice getOccupationalInsurance() {
        return occupationalInsurance;
    }

    public void setEmbezzrement(RichSelectOneChoice embezzrement) {
        this.embezzrement = embezzrement;
    }

    public RichSelectOneChoice getEmbezzrement() {
        return embezzrement;
    }

    public void setEmpletter(RichSelectOneChoice empletter) {
        this.empletter = empletter;
    }

    public RichSelectOneChoice getEmpletter() {
        return empletter;
    }

    public void setPiBeh(RichSelectOneChoice piBeh) {
        this.piBeh = piBeh;
    }

    public RichSelectOneChoice getPiBeh() {
        return piBeh;
    }

    public void setPiBhacom(RichInputText piBhacom) {
        this.piBhacom = piBhacom;
    }

    public RichInputText getPiBhacom() {
        return piBhacom;
    }

    public void getVal(ValueChangeEvent valueChangeEvent) {
//System.out.println(valueChangeEvent.getNewValue());
        logger.info("Start getVal Method of piobservationsMB ");
                //System.out.println(valueChangeEvent.getNewValue());
                if(valueChangeEvent.getNewValue()!=null){
        
                ciDcom.setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ciDcom);
            }else{
                ciDcom.setVisible(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ciDcom);
            }
        logger.info("End getVal Method of piobservationsMB ");
   
    }

    public void setPiEx(RichSelectOneChoice piEx) {
        this.piEx = piEx;
    }

    public RichSelectOneChoice getPiEx() {
        return piEx;
    }

    public void getEc(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        logger.info("Start getEc Method of piobservationsMB ");
        if(valueChangeEvent.getNewValue()!=null){
     //   if(valueChangeEvent.getNewValue().toString().equals("0")){
                employmentContcom.setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(employmentContcom);
            
        }else{
            employmentContcom.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(employmentContcom);
        }
        logger.info("End getEc Method of piobservationsMB ");
    }

    public void getLpr(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        logger.info("Start getLpr Method of piobservationsMB ");
        if(valueChangeEvent.getNewValue()!=null){
                leavePayReceivedCom.setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(leavePayReceivedCom);
            }else{
                leavePayReceivedCom.setVisible(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(leavePayReceivedCom);
            }
        logger.info("End getLpr Method of piobservationsMB ");
    }

    public void getTN(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        logger.info("Start getTN Method of piobservationsMB ");
        if(valueChangeEvent.getNewValue()!=null){
                trainingneedsCom.setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(trainingneedsCom);
            }else{
                trainingneedsCom.setVisible(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(trainingneedsCom);
            }
        logger.info("End getLpr Method of piobservationsMB ");
    }

    public void doReset() {
        logger.info("Start doReset Method of piobservationsMB ");
//        System.out.println(" --"+ciDcom.getValue());
        ciDcom.setVisible(false);
        employmentContcom.setVisible(false);
        employmentContcom.setVisible(false);
        leavePayReceivedCom.setVisible(false);
        trainingneedsCom.setVisible(false); 
        newviewbtnsbind.setVisible(true);
        sdhtablebind.setVisible(true);
        sdhBind.setVisible(false);
        sdhviewbind.setVisible(false);
        String ssup=(String)httpSession.getAttribute("seniourSup");
        if(ssup!=null){
        if(ssup.equalsIgnoreCase("SeniourSupervisor")){
        supLovBind.setVisible(true);
        }
        }
        
//        uidate.setValue("");
//        empletter.setSubmittedValue("");
//        occupationalInsurance.setSubmittedValue("");
//        housingallowance.setSubmittedValue("");
//        piEx.setSubmittedValue("");
//        piBhacom.setValue("");
//        embezzrement.setSubmittedValue("");
//        CIDC.setSubmittedValue("");
//                this.embezzrement.setSubmittedValue("");
//                this.leavePayRecevied.setSubmittedValue("");
//                this.trainingNeeds.setSubmittedValue("");
//                this.empletter.setSubmittedValue("");
//                this.occupationalInsurance.setSubmittedValue("");
//                this.housingallowance.setSubmittedValue("");
//                this.piEx.setSubmittedValue("");
//                this.piBhacom.setValue("");
//        
 
        JUCtrlListBinding listBindingResettype =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("ObservationstypesVO1");
        listBindingResettype.setSelectedIndex(0);
        JUCtrlListBinding listBindingResetlov =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforobservationsLOV1");
        listBindingResetlov.setSelectedIndex(0);
        
        
        logger.info("End getLpr Method of piobservationsMB ");   
        
    }

    public void setUidate(RichInputDate uidate) {
        this.uidate = uidate;
    }

    public RichInputDate getUidate() {
        return uidate;
    }


    public void setPiidselect(RichSelectOneChoice piidselect) {
        this.piidselect = piidselect;
    }

    public RichSelectOneChoice getPiidselect() {
        return piidselect;
    }

    public void setPf11(RichPanelFormLayout pf11) {
        this.pf11 = pf11;
    }

    public RichPanelFormLayout getPf11() {
        return pf11;
    }

    public void setNewviewbtnsbind(RichPanelGroupLayout newviewbtnsbind) {
        this.newviewbtnsbind = newviewbtnsbind;
    }

    public RichPanelGroupLayout getNewviewbtnsbind() {
        return newviewbtnsbind;
    }

    public String newBtnAction() {
        newviewbtnsbind.setVisible(false);
        sdhBind.setVisible(true);
        sdhtablebind.setVisible(false);
        sdhviewbind.setVisible(false);
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        DCBindingContainer bindings2= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding2 = bindings2.findIteratorBinding("PIObservationDocsVO1Iterator");
       // ViewObject piobservo =dcIteratorBinding2.getViewObject();
        try{
            ViewObjectImpl piDocs =(ViewObjectImpl)dcIteratorBinding2.getViewObject();
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            int flag = 0;
            for(Row row : piDocs.getAllRowsInRange())
            {
                 ViewRowImpl rowEn = (ViewRowImpl)row;       
                 byte entityState = rowEn.getEntity(0).getEntityState();
                 if(entityState==rowEn.STATUS_INITIALIZED || entityState==0)
                 {
                     flag = flag+1;    
                 }
             }
            if(flag==0)
            {
                 piDocs.clearCache();    
                 piDocs.executeEmptyRowSet();
                 
                 //int documentStage=7;
                 
                 if(piDocs!=null) {
                     //doc master PoundDocVO
                     DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                     DCIteratorBinding dcIteratorBinding1 = bindings1.findIteratorBinding("PIObservationDocMstVO1Iterator"); 
                     ViewObjectImpl piMstVO =(ViewObjectImpl) dcIteratorBinding1.getViewObject();
                     RowSetIterator rsi=piMstVO.createRowSetIterator(null);

                     while(rsi.hasNext()) {
                         Row docrow=rsi.next();
                         
                         Row piDocsRow = piDocs.createRow(); 
                         piDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
                         piDocsRow.setAttribute("CreatedBy",userName);
                         piDocsRow.setAttribute("CreatedDate",sqlDate);
                         piDocsRow.setAttribute("DOCName",docrow.getAttribute("DocDesc"));
                         piDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
                         piDocs.insertRow(piDocsRow); 
                        
                     }
                     
                        
                         
                 }           
             }

        }           
        catch(Exception e){
            e.printStackTrace();
          }
        return null;
    }

   
    public void setSdhBind(RichShowDetailHeader sdhBind) {
        this.sdhBind = sdhBind;
    }

    public RichShowDetailHeader getSdhBind() {
        return sdhBind;
    }

    public String viewBtnAction() {
        String piid = (String) ADFUtils.getBoundAttributeValue("PIID1");
        BigDecimal id = (BigDecimal) ADFUtils.getBoundAttributeValue("ID1");
        
        if(piid!=null){
        DCBindingContainer bcbind=(DCBindingContainer) getBindings1();
        DCIteratorBinding piiter=bcbind.findIteratorBinding("PiobservationsVO1Iterator");
        ViewObject piobsrvvo=piiter.getViewObject();
        piobsrvvo.setWhereClause("PI_ID='"+piid+"' and ID='"+id+"' ");
        System.out.println("piobserv on view query:::"+piobsrvvo.getQuery());
        piobsrvvo.executeQuery();
        newviewbtnsbind.setVisible(false);
        sdhtablebind.setVisible(false);
        sdhBind.setVisible(false);
        sdhviewbind.setVisible(true);
            String ssup=(String)httpSession.getAttribute("seniourSup");
            if(ssup!=null){
            if(ssup.equalsIgnoreCase("SeniourSupervisor")){
            supLovBind.setVisible(false);
            }  
            }
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          "Please select the PI"));   
        }
        return null;
    }

    public void setSdhtablebind(RichShowDetailHeader sdhtablebind) {
        this.sdhtablebind = sdhtablebind;
    }

    public RichShowDetailHeader getSdhtablebind() {
        return sdhtablebind;
    }

    public void setSdhviewbind(RichShowDetailHeader sdhviewbind) {
        this.sdhviewbind = sdhviewbind;
    }

    public RichShowDetailHeader getSdhviewbind() {
        return sdhviewbind;
    }


    public void attachValueChangeListner(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        String validaion = "success";
        String uploadPath =  null;
        String fullPath=null;
        FileUpload fl = new FileUpload();
        //String piId=this.getPiIdBind().getValue().toString();
        String piId= resolveExpression("#{bindings.pisforobservationsLOV1.attributeValue}").toString();
        RichInputFile inputFileComponent = (RichInputFile)valueChangeEvent.getComponent();
                   UploadedFile newFile = (UploadedFile)valueChangeEvent.getNewValue();
                   inputFileComponent.getClientId(FacesContext.getCurrentInstance());
        
        BindingContext bindingctx = BindingContext.getCurrent();
        BindingContainer binding = bindingctx.getCurrentBindingsEntry();
        DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
        /* JUCtrlListBinding juc1 = (JUCtrlListBinding) binding.get("pisforobservationsLOV1");
        String selectedPI = juc1.getSelectedValue().toString(); */
        //Code for testing
        DCIteratorBinding dciterrefundattchmt =
            bindingsImpl.findIteratorBinding("PIObservationDocsVO1Iterator");
        ViewObject voattchmttrans = dciterrefundattchmt.getViewObject();
        
        currentAttchmtRow =dciterrefundattchmt.getRowAtRangeIndex(getDocTable().getRowIndex());
        
         if(null != valueChangeEvent.getNewValue()){
            UploadedFile uploadFile =  (UploadedFile)valueChangeEvent.getNewValue();
            
             if(uploadFile!=null)
             {
             uploadPath =uploadFilesToFolder1("PI Data", "Observations", piId, uploadFile);
             if(uploadPath!=null) {
                 fullPath = uploadPath+"//"+ uploadFile.getFilename();
             }
             String docFielName = uploadFile.getFilename();
             java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
             System.out.println("sqlDate in uploadPvtDocs is : "+sqlDate);
             int documentStage=1;
             int docType = getFileExtension(docFielName);
             BigDecimal num=new BigDecimal("123"); 
             String userName = httpSession.getAttribute("loggedinUserid").toString();
             currentAttchmtRow.setAttribute("CreatedBy",userName);
             currentAttchmtRow.setAttribute("CreatedDate",sqlDate);
             currentAttchmtRow.setAttribute("filepath",fullPath);
             //currentAttchmtRow.setAttribute("Docstage",documentStage);
             currentAttchmtRow.setAttribute("PIOBSERVATIONID", num);
            // System.out.println("piobserId is::"+currentAttchmtRow.getAttribute("PIOBSERVATIONID"));
             currentAttchmtRow.setAttribute("deleteflag","N");
             currentAttchmtRow.setAttribute("doctype",docType);
            
         
         }  
         }

                 
    }
    public String uploadFilesToFolder1(String organizationId,
                                      String documentCategory, String code,
                                       UploadedFile uploadFiles) {

      String path = null;
      String uploadedPath = null;
      if (null != uploadFiles) {
       
          UploadedFile tempFile = uploadFiles;
          System.out.println("temp file" + tempFile.getFilename());
          //rootPath = "D://FileStore";
          File rootP = new File(rootPath);
          rootP.setWritable(Boolean.TRUE);
          if (tempFile != null) {
            System.out.println(tempFile.getFilename());
            File orgId = new File(rootPath + "//"+ organizationId);
            // check if orgId folder exist
            if (!orgId.isDirectory()) {
              System.out.println("before creating directory orgId");            
              orgId.mkdir();
              orgId.setWritable(Boolean.TRUE);
              System.out.println("after creating directory orgId");
                path = rootPath + "//"+  organizationId;
                uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
            }else{
                 path = rootPath + "//" + organizationId;
                 uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
                }
                  
                  System.out.println("Path in if part" + path);
            } 
            
        
        }
          return uploadedPath;
      }
    private String findDirectoryAndUpload(String documentCategory, String code, String path, String rootPath, String orgId, UploadedFile tempFile) {
        String pvtTempPath = null;
        String tempPath = null;
        File pathFile = null;
        //Check if document category exist
                   if(documentCategory.equals("Observations"))
                   {                        
                     File docCat = null;
                     if (documentCategory.equals("Observations"))
                     {
                       path=  getFolderPath(orgId, documentCategory, code);
                       pvtTempPath = path;
                       docCat = new File(pvtTempPath);
                     }else{                       
                       System.out.println("before creating directory documentCategory");  
                       tempPath = rootPath + "//" + orgId  +"//" + documentCategory;
                       docCat = new File(tempPath);                       
                    
                       if(!docCat.isDirectory()){
                               docCat.mkdir();
                               docCat.setWritable(Boolean.TRUE);
                               //path = rootPath + "//" + orgId + "//"+ documentCategory;
                           }
                       else{
                            //path = rootPath + "//" + orgId + "//"+ documentCategory;                            
                        }
                       path = tempPath;
                     }
                       System.out.println("after creating directory documentCategory");  
                       if(documentCategory.equals("Observations"))
                       {
                          pathFile = new File (pvtTempPath + "//" + code);
                          path = pvtTempPath + "//" + code;
                       }
                       else
                       {
                          pathFile = new File (tempPath + "//" + code);
                          path = tempPath + "//" + code;
                        }
                       
                       if(!pathFile.isDirectory())
                       {
                            pathFile.mkdir();
                            pathFile.setWritable(Boolean.TRUE);
                            //path = rootPath + "//" + orgId + "//"+ documentCategory + "//" + code;
                            callUploadFiles(tempFile, path);    
                            
                       }else{
                             //path = rootPath + "//" + orgId + "//"+ documentCategory + "//" + code;
                             callUploadFiles(tempFile, path);                                   
                           }                       
                   }                   
                     
      
                   return path;
    }
    public String getFolderPath(String orgId, String documentCategory, String code){
        
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            String monthS = "0";
            String path = null;
            if(month < 10) {
                 monthS = "0"+month;
                }else {
                 monthS = String.valueOf(month);
            }

            File currentYearMonth = new File(rootPath + "//" + orgId + "//"+ documentCategory +"//"+ year+monthS);
            
            if(!currentYearMonth.isDirectory())
            {
              currentYearMonth.mkdirs();
              currentYearMonth.setWritable(Boolean.TRUE);
              path = rootPath + "//" + orgId + "//"+ documentCategory +"//"+year+monthS;             
              
            }else{
             path = rootPath + "//" + orgId + "//"+ documentCategory +"//"+year+monthS;            
              
            }
            return path;
        }
    
    
    
    public void callUploadFiles(UploadedFile tempFile, String path){
        
            InputStream inputStream = null;
            try {
              FileOutputStream out = new FileOutputStream(path +"//"+ tempFile.getFilename());
              inputStream = tempFile.getInputStream();
              byte[] buffer = new byte[8192];
              int bytesRead = 0;
              while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                out.write(buffer, 0, bytesRead);
              }
              out.flush();
              out.close();
            } catch (Exception ex) {
              // handle exception
              ex.printStackTrace();
            } finally {
              try {
                  if(inputStream!=null){
                      inputStream.close(); 
                  }
                
              } catch (IOException e) {
              }
            }
        }
    private static int getFileExtension(String file) {
    String fileName = file;
    String extType = null;
    int docType = 0;
    if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
        extType = fileName.substring(fileName.lastIndexOf(".")+1);
        //.gif.bmp.dib.jpg.jpe.jfif.tiff.tif
        if(extType != null && extType.equalsIgnoreCase("jpeg")|| extType.equalsIgnoreCase("png") ||
        extType.equalsIgnoreCase("gif")|| extType.equalsIgnoreCase("bmp")||extType.equalsIgnoreCase("dib")|| extType.equalsIgnoreCase("jpg")||
        extType.equalsIgnoreCase("jfif")|| extType.equalsIgnoreCase("tiff")||extType.equalsIgnoreCase("tif")){
            extType = "IMAGE";
            docType = 2;
        }else if(extType != null && extType.equalsIgnoreCase("xml")){
            extType = "XML";
            docType=3;
        }else if(extType != null && extType.equalsIgnoreCase("pdf")|| extType.equalsIgnoreCase("docx") || extType.equalsIgnoreCase("doc") ||extType.equalsIgnoreCase("xlsx")
               || extType.equalsIgnoreCase("xls") || extType.equalsIgnoreCase("txt")){
            extType = "PDF";
            docType=3;
        }else if(extType != null && ( extType.equalsIgnoreCase("MPG")|| extType.equalsIgnoreCase("MPEG"))){
            extType = "Video";
            docType=4;
        }
        return docType;
    }
    
    else return docType;
    }

    public void setDocTable(RichTable docTable) {
        this.docTable = docTable;
    }

    public RichTable getDocTable() {
        return docTable;
    }

    public void setPiIdBind(RichSelectOneChoice piIdBind) {
        this.piIdBind = piIdBind;
    }

    public RichSelectOneChoice getPiIdBind() {
        return piIdBind;
    }

    public void piIdVCE(ValueChangeEvent valueChangeEvent) {
        this.setValueToEL("#{bindings.pisforobservationsLOV1.inputValue}", valueChangeEvent.getNewValue()); //Updates the model
            System.out.println("\n******** Selected Value: "+resolveExpression("#{bindings.pisforobservationsLOV1.attributeValue}"));
            System.out.println("\n******** Display Value: "+resolveExpression("#{bindings.pisforobservationsLOV1.selectedValue ne ' ' ? bindings.Deptno.selectedValue.attributeValues[1] : ''}"));
      /*  String piId= resolveExpression("#{bindings.pisforobservationsLOV1.attributeValue}").toString();
       this.getPiIdBind().setValue(piId); */
    }
    public Object resolveExpression(String el) {      
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory =  facesContext.getApplication().getExpressionFactory();        
        ValueExpression valueExp = expressionFactory.createValueExpression(elContext,el,Object.class);
        return valueExp.getValue(elContext);
    }

    public void setValueToEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory =   facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);
        exp.setValue(elContext, val);
    }

    public String editBtnAction() {
        String piid = (String) ADFUtils.getBoundAttributeValue("PIID1");
        BigDecimal id = (BigDecimal) ADFUtils.getBoundAttributeValue("ID1");
        
        if(piid!=null){
        DCBindingContainer bcbind=(DCBindingContainer) getBindings1();
        DCIteratorBinding piiter=bcbind.findIteratorBinding("PiobservationsVO1Iterator");
        ViewObject piobsrvvo=piiter.getViewObject();
        piobsrvvo.setWhereClause("PI_ID='"+piid+"' and ID='"+id+"' ");
        System.out.println("piobserv on edit query:::"+piobsrvvo.getQuery());
        piobsrvvo.executeQuery();
        sdhtablebind.setVisible(false);
        sdhBind.setVisible(false);
        sdhviewbind.setVisible(false);
        editSdhBind.setVisible(true);
        newviewbtnsbind.setVisible(false);
            String ssup=(String)httpSession.getAttribute("seniourSup");
            if(ssup!=null){
            if(ssup.equalsIgnoreCase("SeniourSupervisor")){
            supLovBind.setVisible(false);
            
            }  
            }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSdhBind());
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          "Please select the PI"));   
        }
        return null;
    }

    public void supLovVCL(ValueChangeEvent valueChangeEvent) {
        String supId=(String)valueChangeEvent.getNewValue();
        DCBindingContainer bindings2= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding2 = bindings2.findIteratorBinding("PiobservationsVO2Iterator");
        ViewObject piobservo =dcIteratorBinding2.getViewObject();
        piobservo.setWhereClause("Sup_id='"+supId+"'");
        System.out.println("supLov qry is:::"+piobservo.getQuery());
        piobservo.executeQuery();
        long count=piobservo.getEstimatedRowCount();
        DCIteratorBinding dcIteratorBinding3 = bindings2.findIteratorBinding("pisforobservationsLOV1Iterator");
        ViewObject piforsupLovVO =dcIteratorBinding3.getViewObject();
        piforsupLovVO.setWhereClause("Sup_id='"+supId+"'");
        System.out.println("piforSup qry is:::"+piforsupLovVO.getQuery());
        piforsupLovVO.executeQuery();
        
        if(count==0){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          "No PI's exist under the Supervisor:"+supId));    
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSdhtablebind());
        
    }


    public void setSupLovBind(RichSelectOneChoice supLovBind) {
        this.supLovBind = supLovBind;
    }

    public RichSelectOneChoice getSupLovBind() {
        return supLovBind;
    }

    public void setEditSdhBind(RichShowDetailHeader editSdhBind) {
        this.editSdhBind = editSdhBind;
    }

    public RichShowDetailHeader getEditSdhBind() {
        return editSdhBind;
    }


    public String editBtnSubmitAction() {
        logger.info("Start piObservationsSave Method of piobservationsMB ");
         ADFContext adfctx = ADFContext.getCurrent();
        adfctx.getSessionScope().get("loggedinUserid");
          String userName =(String)adfctx.getSessionScope().get("loggedinUserid").toString(); 
          //System.out.println("--------------Save----------");
         String pibcom ="";
         String cidcom1="";
         String leavepaycom="";
         String trainingcom="";
         String employcom="";
         Object checkd=uidate1.getValue();
         Object cid=ciDC1.getValue();
         Object tn=trainingNeeds1.getValue();
         Object  lpr=leavePayRecevied1.getValue();
         Object echeck=employmentCon1.getValue();
         Object hcheck=housingallowance1.getValue();
         Object eplatter=empletter1.getValue();
         Object emz=embezzrement1.getValue();
         Object  occheck=occupationalInsurance1.getValue();
         Object checkpiEx=piEx1.getValue();
         
         
        
         //        employmentCon.getValue();
         //        employmentContcom.getValue();
         //        housingallowance.getValue();
         //        occupationalInsurance.getValue();
         //        embezzrement.getValue();
         //        empletter.getValue();
         
         
         
         try{
        
        
        if(checkd==null)
         {
                          FacesContext.getCurrentInstance().addMessage(null,
                                                                       new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                        "Sample info message",
                                                                                        genMsg.getMessage("435",lgCode)));
        //       FacesMessage fm = new FacesMessage("Date should be  mandatory  ");
        //       fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //       FacesContext fctx = FacesContext.getCurrentInstance();
        //       fctx.addMessage(null, fm);
        return null;
                      }
        Date currentDate = new Date(System.currentTimeMillis());
        java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
        String scudate=sqlDate1.toString().replaceAll("-","");
        Date from=(Date)uidate1.getValue();
        java.sql.Date  fdate= new java.sql.Date(from.getTime());
        String sfdate=fdate.toString().replaceAll("-","");
        //System.out.println("from date"+scudate); 
        //System.out.println("to date"+sfdate);
         int ifdate=Integer.parseInt(sfdate);
        int icudate=Integer.parseInt(scudate);

             
             
                        
             if(ifdate > icudate)   {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("436",lgCode)));
        //                FacesMessage fm = new FacesMessage("Date should Not be Greter Than currnet Date   ");
        //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                FacesContext fctx = FacesContext.getCurrentInstance();
        //                fctx.addMessage(null, fm);
        return null;
             }
             
             
         if(cid==null)
         {
                      FacesContext.getCurrentInstance().addMessage(null,
                                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                    "Sample info message",
                                                                                    genMsg.getMessage("437",lgCode)));
        //        FacesMessage fm = new FacesMessage("CIDClearance should be mandatory  ");
        //        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //        FacesContext fctx = FacesContext.getCurrentInstance();
        //        fctx.addMessage(null, fm);
        return null;
                  }
             if(echeck==null) {
                             FacesContext.getCurrentInstance().addMessage(null,
                                                                          new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                           "Sample info message",
                                                                                           genMsg.getMessage("447",lgCode)));
        //                FacesMessage fm = new FacesMessage("employment contract should be mandatory  ");
        //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                FacesContext fctx = FacesContext.getCurrentInstance();
        //                fctx.addMessage(null, fm);
        return null;
                         }
          if(lpr==null)   {
              FacesContext.getCurrentInstance().addMessage(null,
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                            "Sample info message",
                                                                            genMsg.getMessage("438",lgCode)));
        //             FacesMessage fm = new FacesMessage("leavePayRecevied should be mandatory  ");
        //             fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //             FacesContext fctx = FacesContext.getCurrentInstance();
        //             fctx.addMessage(null, fm);
        return null;
          }
             if(tn==null)
             {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("439",lgCode)));
        //                    FacesMessage fm = new FacesMessage("trainingNeeds should be mandatory  ");
        //                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                    FacesContext fctx = FacesContext.getCurrentInstance();
        //                    fctx.addMessage(null, fm);
        return null;
                 
                 }
             if(emz==null) {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("440",lgCode)));
        //                FacesMessage fm = new FacesMessage("Embezzlement should be mandatory  ");
        //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                FacesContext fctx = FacesContext.getCurrentInstance();
        //                fctx.addMessage(null, fm);
        return null;
                 
             }
             if(eplatter==null)   
             {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("441",lgCode)));
        //                    FacesMessage fm = new FacesMessage("employement letter from compay be mandatory  ");
        //                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                    FacesContext fctx = FacesContext.getCurrentInstance();
        //                    fctx.addMessage(null, fm);
        return null;
                 
                 }
            
             
             if(hcheck==null)   
             {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("442",lgCode)));
        //                    FacesMessage fm = new FacesMessage("Housing allowance should be mandatory  ");
        //                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                    FacesContext fctx = FacesContext.getCurrentInstance();
        //                    fctx.addMessage(null, fm);
        return null;
                 
                 }
             
            
             if(occheck==null)   {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("443",lgCode)));
        //                FacesMessage fm = new FacesMessage("Occupational Insurance should be mandatory ");
        //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                FacesContext fctx = FacesContext.getCurrentInstance();
        //                fctx.addMessage(null, fm);
        return null;
             }
             if(checkpiEx==null)   {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("444",lgCode)));
        //                FacesMessage fm = new FacesMessage("Excuses Made By PI  should be mandatory ");
        //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                FacesContext fctx = FacesContext.getCurrentInstance();
        //                fctx.addMessage(null, fm);
        return null;
             }
             
             
             
             
            
        /*  String leavepay=leavePayRecevied.getValue().toString();
        //System.out.println(leavepay);
        String training= trainingNeeds.getValue().toString();
        String employ=employmentCon.getValue().toString();
        String hous= housingallowance.getValue().toString();
        String occ=occupationalInsurance.getValue().toString();
        String emb=embezzrement.getValue().toString();
        String emplett=empletter.getValue().toString();
        String expix=piEx.getValue().toString(); */
        String pi1=editPiIdBind.getValue().toString(); 
            OperationBinding fromdatevalidate = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("validateFromDate");
             fromdatevalidate.getParamsMap().put("startdate",fdate);
              fromdatevalidate.getParamsMap().put("piNumber",pi1);
              String result1 = (String)fromdatevalidate.execute();
                  if(result1.equalsIgnoreCase("noHireDate"))
                  {
                          FacesMessage fm = new FacesMessage("Date should not be less than HireDate ");
                          fm.setSeverity(FacesMessage.SEVERITY_INFO);
                          FacesContext fctx = FacesContext.getCurrentInstance();
                          fctx.addMessage(null, fm);
                          return null ;
                      
                      
                      }
        
                         }
         catch(Exception e){
             e.printStackTrace();
         }
        BindingContainer bindings = getBindings();
           OperationBinding operationBinding = bindings.getOperationBinding("Commit");
          Object result = operationBinding.execute();
         
         if (operationBinding.getErrors().isEmpty()) {
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                           "Sample info message",
                                                                           "Observations successfully edited"));
        //             FacesMessage fm = new FacesMessage(pi1+"Observations not Successfully");
        //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //           FacesContext fctx = FacesContext.getCurrentInstance();
        //             fctx.addMessage(null, fm);
             editSdhBind.setVisible(false);
             sdhtablebind.setVisible(true);
             supLovBind.setVisible(true);
             newviewbtnsbind.setVisible(true);
             AdfFacesContext.getCurrentInstance().addPartialTarget(getEditSdhBind()); 
             AdfFacesContext.getCurrentInstance().addPartialTarget(getSdhtablebind());
             AdfFacesContext.getCurrentInstance().addPartialTarget(getSupLovBind());
             AdfFacesContext.getCurrentInstance().addPartialTarget(getNewviewbtnsbind());
         } 
         
        return null;
    }

    public void setEditPiIdBind(RichInputText editPiIdBind) {
        this.editPiIdBind = editPiIdBind;
    }

    public RichInputText getEditPiIdBind() {
        return editPiIdBind;
    }

    public String editCancelAction() {
        supLovBind.setVisible(true);
        editSdhBind.setVisible(false);
        sdhtablebind.setVisible(true);
        newviewbtnsbind.setVisible(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getEditSdhBind());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSdhtablebind());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getNewviewbtnsbind());
        return null;
    }

    public void setUidate1(RichInputDate uidate1) {
        this.uidate1 = uidate1;
    }

    public RichInputDate getUidate1() {
        return uidate1;
    }

    public void setCiDC1(RichSelectOneChoice ciDC1) {
        this.ciDC1 = ciDC1;
    }

    public RichSelectOneChoice getCiDC1() {
        return ciDC1;
    }

    public void setEmploymentCon1(RichSelectOneChoice employmentCon1) {
        this.employmentCon1 = employmentCon1;
    }

    public RichSelectOneChoice getEmploymentCon1() {
        return employmentCon1;
    }

    public void setLeavePayRecevied1(RichSelectOneChoice leavePayRecevied1) {
        this.leavePayRecevied1 = leavePayRecevied1;
    }

    public RichSelectOneChoice getLeavePayRecevied1() {
        return leavePayRecevied1;
    }

    public void setEmbezzrement1(RichSelectOneChoice embezzrement1) {
        this.embezzrement1 = embezzrement1;
    }

    public RichSelectOneChoice getEmbezzrement1() {
        return embezzrement1;
    }

    public void setEmpletter1(RichSelectOneChoice empletter1) {
        this.empletter1 = empletter1;
    }

    public RichSelectOneChoice getEmpletter1() {
        return empletter1;
    }

    public void setHousingallowance1(RichSelectOneChoice housingallowance1) {
        this.housingallowance1 = housingallowance1;
    }

    public RichSelectOneChoice getHousingallowance1() {
        return housingallowance1;
    }

    public void setOccupationalInsurance1(RichSelectOneChoice occupationalInsurance1) {
        this.occupationalInsurance1 = occupationalInsurance1;
    }

    public RichSelectOneChoice getOccupationalInsurance1() {
        return occupationalInsurance1;
    }

    public void setPiEx1(RichSelectOneChoice piEx1) {
        this.piEx1 = piEx1;
    }

    public RichSelectOneChoice getPiEx1() {
        return piEx1;
    }

    public void setTrainingNeeds1(RichSelectOneChoice trainingNeeds1) {
        this.trainingNeeds1 = trainingNeeds1;
    }

    public RichSelectOneChoice getTrainingNeeds1() {
        return trainingNeeds1;
    }
}
