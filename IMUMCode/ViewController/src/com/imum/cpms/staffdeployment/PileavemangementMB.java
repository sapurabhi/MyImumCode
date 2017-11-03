package com.imum.cpms.staffdeployment;

import com.imum.cpms.util.MessageUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.context.FacesContextFactory;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.context.AdfFacesContext;



import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;

import org.apache.commons.io.IOUtils;

public class PileavemangementMB {
    private RichSelectBooleanCheckbox halfday;
    private RichInputDate fromDate;
    private RichInputDate toDate;
    private RichInputText leavereason;
    private RichSelectOneChoice soc1;
    private RichInputText piName;
    private RichInputDate id1;
    private RichInputDate id2;
    private RichInputFile attachment;
    private RichInputFile uploadedFile;
    private UploadedFile myfile;
    private RichInputText leaveDays;
    MessageUtil genMsg = new MessageUtil();
    String oldValue = "";
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    public static final ADFLogger logger = ADFLogger.createADFLogger(PileavemangementMB.class);
   
   //ArrayList dates = new ArrayList();

//    String amDef = "com.imum.cpms.model.staffdeploy";
//    String config = "StaffDeployLocal";


    public PileavemangementMB() {
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

//    public static Date convertToUtilDate(String sdate) throws ParseException {
//            java.util.Date date=null;
//            DateFormat formatter = new SimpleDateFormat("yyyy mm DD");
//            System.out.println(formatter.getDateInstance());
//            date = formatter.parse(sdate);
         
//        return date;        
//        }

    public String createDir(String chaildDir, String rootPath ){
        logger.info("Start createDir Method of PileavemangementMB ");
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
           //  System.out.println("Root Path"+rootPath);
            }
            else{
                rootPath = rootPath+"//"+createD;
                f.mkdir();
                 if(nextDir.charAt(0) == '/'){
               nextDir  = chaildDir.substring(chaildDir.indexOf("/")+2,chaildDir.length());
               createDir(nextDir,rootPath);
             }
             else{
                 createD = nextDir.substring(0,nextDir.indexOf("/"));
                  f.mkdir();
                  rootPath = rootPath+"//"+createD;

             }
            }
        }
        }
        else{
        }
        }
        catch(Exception e){
         //   logger.ERROR("createDir Method of PileavemangementMB ");
            e.printStackTrace();
        }
        logger.info("End createDir Method of PileavemangementMB ");
                return rootPath;
    }
//    public void test(){
//        File f = new File(rootPath); 
//        if(f.isDirectory()){
//            System.out.println("Yes Done");
//        }
//    }
    public void callUploadFiles(UploadedFile tempFile, String path){
            logger.info("Start callUploadFiles Method of PileavemangementMB ");
            InputStream inputStream = null;
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ectx = context.getExternalContext();
                Map sessionMap = ectx.getSessionMap();
                //sessionMap.put("InputStream",inputstream);
                InputStream inputstream =(InputStream)sessionMap.get("InputStream");
              FileOutputStream out = new FileOutputStream(path +"//"+ tempFile.getFilename());
                IOUtils.copy(inputstream, out);
                //System.out.println("Data ------------------------"+inputstream);
             // inputStream = tempFile.getInputStream();
              byte[] buffer = new byte[1024];
              int bytesRead;
               // len = inputstream.read(buf)) > 0
                while ((bytesRead = inputstream.read(buffer)) > 0){
              //while ((bytesRead = inputstream.read(buffer)) > 0) {
                out.write( bytesRead);
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
            logger.info("End callUploadFiles Method of PileavemangementMB ");
        }

    
    public String doSave() {
        logger.info("Start doSave Method of PileavemangementMB ");
          try
        {
         
          String rootPath = "//cpmsshare";
          //String rootPath="D://cpmsshare";
          String subFolderPath = "PILeaveProfile//PILeave";
           Boolean b1 = new Boolean(true);
         String s="";
          ADFContext adfctx = ADFContext.getCurrent();
          if(adfctx.getSessionScope().get("loggedinUserid")!=null){
          s = adfctx.getSessionScope().get("loggedinUserid").toString(); 
          }  
        Object checkFromDate = fromDate.getValue();
        Object checkToDate=toDate.getValue();
        Object checkres=leavereason.getValue();
        JUCtrlListBinding listBinding =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforsupervisorVO1");
        String pi = (String)listBinding.getSelectedValue();
              if(pi==null) {
                    
                  FacesContext.getCurrentInstance().addMessage(null,
                                                               new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                "Sample info message",
                                                                                genMsg.getMessage("428",lgCode)));
                  
                    
//                     
//                  FacesMessage fm = new FacesMessage("select PI is should be  mandatory ");
//                  fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                  FacesContext fctx = FacesContext.getCurrentInstance();
//                  fctx.addMessage(null, fm); 
                  return null;
                  
              }
              
    
             if(checkFromDate == null)
              {
                      FacesContext.getCurrentInstance().addMessage(null,
                                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                    "Sample info message",
                                                                                    genMsg.getMessage("424",lgCode)));
//                      FacesMessage fm = new FacesMessage("From Date should be  mandatory ");
//                      fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                      FacesContext fctx = FacesContext.getCurrentInstance();
//                      fctx.addMessage(null, fm); 
                      return null;
                  }
              
        
             else if(checkToDate == null)
             {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("425",lgCode)));
                     return null;
//                     FacesMessage fm = new FacesMessage("To Date should be  mandatory ");
//                     fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                     FacesContext fctx = FacesContext.getCurrentInstance();
//                     fctx.addMessage(null, fm); 
                 }
       
             else if(checkres == null)
             {
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("426",lgCode)));
                     return null;
//                     FacesMessage fm = new FacesMessage("Leave Reason should be  mandatory ");
//                     fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                     FacesContext fctx = FacesContext.getCurrentInstance();
//                     fctx.addMessage(null, fm); 
                 }
              else{
                 int count = 0;
                  OperationBinding op3=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getFridaysOnly");
                   op3.getParamsMap().put("stDate",fromDate.getValue().toString());
                   op3.getParamsMap().put("endDate",toDate.getValue().toString());
                  Object fridayCount =  op3.execute();
                   count = Integer.parseInt(fridayCount.toString());
                 if(count==1){
                     if(fromDate.getValue().toString().equals(toDate.getValue().toString())){
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                       "Sample info message",
                                                                                       genMsg.getMessage("453",lgCode))); 
//                         FacesMessage fm = new FacesMessage("Today is Friday ");
//                                               fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                                               FacesContext fctx = FacesContext.getCurrentInstance();
//                                               fctx.addMessage(null, fm);
                                                                                                 
//                     FacesContext.getCurrentInstance().addMessage(null,
//                                                                  new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                                                                   "Sample info message",
//                                                                                   genMsg.getMessage("427","To day is Friday"))); 
                     return null; 
                     }
                 }
                  Date fDate=(Date)fromDate.getValue();
                  Date tDate=(Date)toDate.getValue();  
                  RichSelectBooleanCheckbox booleanCheckbox = this.getHalfday();
                  Date currentDate = new Date(System.currentTimeMillis());
                  java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
                  java.sql.Date fD1 = new java.sql.Date(fDate.getTime());
                  java.sql.Date tD1 = new java.sql.Date(tDate.getTime());
                  long diff = tD1.getTime()-fD1.getTime();
                   long diffHours = diff / (60 * 60 * 1000);
                   long dayes= diffHours/24;
                  float d = 0;
                 if(leaveDays.getValue() !=null){
                     if(!leaveDays.getValue().toString().equals("")){
                        d=Float.parseFloat(leaveDays.getValue().toString());
                     }
                     else{
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                       "Sample info message",
                                                                                       genMsg.getMessage("427",lgCode))); 
                         return null;
                     }
                 }
                 else{
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("427",lgCode))); 
                     return null;
                 }
                  if( d == 0) {
                              FacesContext.getCurrentInstance().addMessage(null,
                                                                           new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                            "Sample info message",
                                                                                            genMsg.getMessage("427",lgCode)));
//                      FacesMessage fm = new FacesMessage("To Date should not be less than From Date ");
//                      fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                      FacesContext fctx = FacesContext.getCurrentInstance();
//                      fctx.addMessage(null, fm); 
                            return null; 
                          }
                 
                  String sfdate=fD1.toString().replaceAll("-","");
                  String stdate=tD1.toString().replaceAll("-","");
                   //System.out.println("from date"+scudate); 
                  //System.out.println("to date"+sfdate);
                  int ifdate=Integer.parseInt(sfdate);
                  int itdate=Integer.parseInt(stdate);
                  JUCtrlListBinding listBinding1 =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforsupervisorVO1");
                  String str = (String)listBinding1.getSelectedValue();
                  JUCtrlListBinding listBinding2 =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leavetypeLOV1");
                  String leavetype = (String)listBinding2.getSelectedValue();
                  if(str.equals(null))
                  {
                      
//                      FacesMessage fm = new FacesMessage("select PI is should be  mandatory ");
//                      fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                      FacesContext fctx = FacesContext.getCurrentInstance();
//                      fctx.addMessage(null, fm); 
                      return null;
                  }
                   
                  if(booleanCheckbox.getValue().equals(b1))
                     {
                    if(ifdate!=itdate) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      genMsg.getMessage("429",lgCode)));
//                        FacesMessage fm = new FacesMessage("FromDate and Todate should be same ");
//                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                        FacesContext fctx = FacesContext.getCurrentInstance();
//                        fctx.addMessage(null, fm);
                        return null;
                    }
                    
                    
                      ViewObject piworkvo =
                        getBindings1().findIteratorBinding("PImonthlyWorkAssignVO2Iterator").getViewObject();
                    java.sql.Date fmd = new java.sql.Date(fDate.getTime());
                    java.sql.Date tod = new java.sql.Date(tDate.getTime());
                     piworkvo.setWhereClause("Pi_id ='"+pi+"' and Assgn_Date  between '"+fmd+"' and '"+tod+"' and Pi_Availabity_status_ID=1 ");
                     System.out.println("my query is:::"+piworkvo.getQuery());
                     piworkvo.executeQuery();
                     int rowcnt=piworkvo.getRowCount();
                     if(rowcnt>=1){
                         FacesMessage fm = new FacesMessage("PI is already deployed on the following date/dates.");
                         fm.setSeverity(FacesMessage.SEVERITY_INFO);
                         FacesContext fctx = FacesContext.getCurrentInstance();
                         fctx.addMessage(null, fm);
                         return null; 
                     }
                    
                    String Status = "Pending";
                    String leaveres1=leavereason.getValue().toString();
                    OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getCheckLeave");
                     op1.getParamsMap().put("pi",str );
                     op1.getParamsMap().put("fd",fDate);
                     op1.getParamsMap().put("td",tDate);
                     String s2=(String)op1.execute();
                     if(s2.equals("Failure")) {
                         FacesMessage fm = new FacesMessage("Already Leave applied in these days ");
                         fm.setSeverity(FacesMessage.SEVERITY_INFO);
                         FacesContext fctx = FacesContext.getCurrentInstance();
                         fctx.addMessage(null, fm);
                         return null;
                         
                     }
                    if(rowcnt==0){
                        piworkvo.setWhereClause("Pi_id ='"+pi+"' and Assgn_Date  between '"+fmd+"' and '"+tod+"' and Pi_Availabity_status_ID!=1"); 
                        System.out.println("Delete query is:::"+piworkvo.getQuery());
                        piworkvo.executeQuery();
                        RowSetIterator rs=piworkvo.createRowSetIterator(null); 
                        rs.reset();
                        while(rs.hasNext()){
                            Row current=rs.next();
                            rs.setCurrentRow(current);
                             current.remove();
                        }
                        rs.closeRowSetIterator();
                        }
                   
                  
                    
                    
//                    JUCtrlListBinding listBinding1 =
//                        (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leavetypeLOV1");
//                    String leavetype = (String)listBinding1.getSelectedValue();
                    ViewObject groupVO =
                        getBindings1().findIteratorBinding("PILeaveMangementVO1Iterator").getViewObject();
                    Row row = groupVO.getCurrentRow();
                    row.setAttribute("PIid", str);
                    row.setAttribute("FromDate", fD1);
                    row.setAttribute("ToDate", tD1);
                    row.setAttribute("LeavesApplied", 0.5);
                    row.setAttribute("LeaveReason",leaveres1);
                    row.setAttribute("Status", Status);
                    row.setAttribute("LeaveType", leavetype);
                    row.setAttribute("AppliedDate", sqlDate1);
                    //row.setAttribute("Attachment", "No Attachement");  
                    row.setAttribute("SupId", s);
                    groupVO.setCurrentRow(row);
                    BindingContainer bindings = getBindings();
                    OperationBinding operationBinding =
                    bindings.getOperationBinding("Commit");
                    Object result = operationBinding.execute();
                    if (!operationBinding.getErrors().isEmpty()) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      genMsg.getMessage("432",lgCode)));
//                        FacesMessage fm =
//                            new FacesMessage("PI Leave is Not applyed Successfully");
//                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//                        FacesContext fctx = FacesContext.getCurrentInstance();
//                        fctx.addMessage(null, fm);
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      genMsg.getMessage("431",lgCode)));
//                        FacesMessage fm =
//                            new FacesMessage("PI Leave applyed Successfully");
//                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                        FacesContext fctx = FacesContext.getCurrentInstance();
//                        fctx.addMessage(null, fm);
                        ViewObject groupVO1 =
                        getBindings1().findIteratorBinding("PILeaveMangementVO1Iterator").getViewObject();
                        Row row1 = groupVO1.last();
                        Integer sno=(Integer)row1.getAttribute("Sno");
                        String piid=(String)row1.getAttribute("PIid");
                        String supid=(String)row1.getAttribute("SupId");
                        Date fd=(Date)row1.getAttribute("FromDate");
                        Date td=(Date)row1.getAttribute("ToDate");
                        java.sql.Date fromdate= new java.sql.Date(fd.getTime());
                        java.sql.Date todate= new java.sql.Date(td.getTime());
                        System.out.println("from date is:::"+fromdate);
                        System.out.println("todate is :::"+todate);
                        
                        OperationBinding operationBinding1 =bindings.getOperationBinding("callPopulatePILeaveProc");
                        operationBinding1.getParamsMap().put("sno",sno );
                        operationBinding1.getParamsMap().put("piid", piid);
                        operationBinding1.getParamsMap().put("fromdate", fromdate);
                        operationBinding1.getParamsMap().put("todate", todate);
                        operationBinding1.getParamsMap().put("flag","Y");
                        operationBinding1.getParamsMap().put("supid", supid);
                        operationBinding1.execute();
                    }
                    fromDate.setValue(null);
                    toDate.setValue(null);
                    leavereason.setValue(null);
                    leaveDays.setValue(null);
                    halfday.setValue(false);
                    uploadedFile.setDisabled(false);
                    uploadedFile.setValue(null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
                    JUCtrlListBinding listBindingResetlov =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforsupervisorVO1");
                    listBindingResetlov.setSelectedIndex(0);
                    JUCtrlListBinding listBindingleavetype =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leavetypeLOV1");
                    listBindingleavetype.setSelectedIndex(0);
                    
                }

                else {
                   

                    String chaildDir= "PILeaveProfile//PILeave";
                    String Status = "Pending";
                    String leave=leavereason.getValue().toString();
                    OperationBinding fromdatevalidate = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("validateFromDate");
                    fromdatevalidate.getParamsMap().put("startdate",fDate);
                     fromdatevalidate.getParamsMap().put("piNumber",str);
                     String result1 = (String)fromdatevalidate.execute();
                         if(result1.equalsIgnoreCase("noHireDate"))
                         {
                                 FacesMessage fm = new FacesMessage("From Date should not be less than HireDate ");
                                 fm.setSeverity(FacesMessage.SEVERITY_INFO);
                                 FacesContext fctx = FacesContext.getCurrentInstance();
                                 fctx.addMessage(null, fm);
                                 return null;
                             
                             
                             }
                  
                    
                    ViewObject piworkvo =
                        getBindings1().findIteratorBinding("PImonthlyWorkAssignVO2Iterator").getViewObject();
                    java.sql.Date fmd = new java.sql.Date(fDate.getTime());
                    java.sql.Date tod = new java.sql.Date(tDate.getTime());
                     piworkvo.setWhereClause("Pi_id ='"+pi+"' and Assgn_Date  between '"+fmd+"' and '"+tod+"' and Pi_Availabity_status_ID=1");
                     System.out.println("my query is:::"+piworkvo.getQuery());
                     piworkvo.executeQuery();
                     int rowcnt=piworkvo.getRowCount();
                     if(rowcnt>=1){
                         FacesMessage fm = new FacesMessage("PI is already deployed on the following date/dates.");
                         fm.setSeverity(FacesMessage.SEVERITY_INFO);
                         FacesContext fctx = FacesContext.getCurrentInstance();
                         fctx.addMessage(null, fm);
                         return null; 
                     } 
                  
                  
                  
                   OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getCheckLeave");
                    op1.getParamsMap().put("pi",str );
                    op1.getParamsMap().put("fd",fDate);
                    op1.getParamsMap().put("td",tDate);
                    String s2=(String)op1.execute();
                    if(s2.equals("Failure")) {
                        FacesMessage fm = new FacesMessage("Already Leave applied in these days ");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext fctx = FacesContext.getCurrentInstance();
                        fctx.addMessage(null, fm);
                        return null;
                    }
                      
                    else{
                        if(rowcnt==0){
                            piworkvo.setWhereClause("Pi_id ='"+pi+"' and Assgn_Date  between '"+fmd+"' and '"+tod+"' and Pi_Availabity_status_ID!=1"); 
                            System.out.println("Delete query is:::"+piworkvo.getQuery());
                            piworkvo.executeQuery();
                            RowSetIterator rs=piworkvo.createRowSetIterator(null); 
                            rs.reset();
                            while(rs.hasNext()){
                                Row current=rs.next();
                                rs.setCurrentRow(current);
                                 current.remove();
                            }
                            rs.closeRowSetIterator();
                            }
                        RowSetIterator[] al=piworkvo.getRowSetIterators();
                    
                    UploadedFile myfile = (UploadedFile)this.getMyfile();
                    
                    //System.out.println("Myfile ---"+myfile);
                   /*  if(!leavetype.equalsIgnoreCase("Consolation leave")&&!leavetype.equalsIgnoreCase("Sick leave")&&!leavetype.equalsIgnoreCase("Marriage leave")) {
                        
                        if(myfile==null)
                        
                        {
                            
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                          "Sample info message",
                                                                                          genMsg.getMessage("433",lgCode)));
//                            FacesMessage fm = new FacesMessage("File should be  mandatory ");
//                            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                            FacesContext fctx = FacesContext.getCurrentInstance();
//                            fctx.addMessage(null, fm);
                            return null;
                            
                        }
                    } */
                     if(myfile!=null) 
                     {
              
                         logger.info("Inside the if Condition Line 507 doSave Method of PileavemangementMB ");
                    //            java.sql.Date fD = new java.sql.Date(fDate.getTime());
                    //            java.sql.Date tD = new java.sql.Date(tDate.getTime());
                     

                  
                    // System.out.println(myfile);
                    //   InputStream inputstream =  createMyStream(myfile);//myfile.getInputStream();
                    FacesContext context = FacesContext.getCurrentInstance();
                    ExternalContext ectx = context.getExternalContext();
                    Map sessionMap = ectx.getSessionMap();
                    
                    File f1 = new File(rootPath+"//"+subFolderPath); 
                         logger.info("Line 520 doSave Method of PileavemangementMB "+f1.getName());
                      if(!f1.isDirectory()){
                          createDir(subFolderPath+"//"+str+"//",rootPath);
                          logger.info("Line 522 doSave Method of PileavemangementMB ");
                          rootPath = rootPath+"//"+subFolderPath+"//"+str;
                                                }
                      else{
                          File f3 = new File(rootPath+"//"+subFolderPath+"//"+str); 
                          if(!f3.isDirectory()){
                              f3.mkdir();
                              rootPath = rootPath+"//"+subFolderPath+"//"+str;
                          }
                          else {
                              rootPath = rootPath+"//"+subFolderPath+"//"+str; 
                          }
                          
                      }
                      
                         logger.info("Line 538 doSave Method of PileavemangementMB "+rootPath);
                      
                    InputStream inputstream =(InputStream)sessionMap.get("InputStream");
                        // sessionMap.remove(inputstream);
                   //type
                    //check IputStream ??,Consolation ,leave Sick leave ,Marriage leave
                     // 
                   // InputStream inputstream =(InputStream)sessionMap.get("InputStream");
                   logger.info("Line 546 doSave Method of PileavemangementMB "+rootPath);
                         logger.info("Line 547 stream doSave Method of PileavemangementMB "+inputstream);
                    File f = new File(rootPath+"//"+myfile.getFilename());
                         logger.info("Line 549 path doSave Method of PileavemangementMB "+f.getAbsolutePath());
                    //Added kk
                   OutputStream out = new FileOutputStream(f);
                    byte buf[] = new byte[1024];
                    int len;
                    while ((len = inputstream.read(buf)) > 0)
                        out.write(buf, 0, len);
                    out.close();
                    
                         logger.info("Line 557 path doSave Method of PileavemangementMB ");
//                    FileInputStream fis = new FileInputStream(f);
//                      
// 

// String filetype = myfile.getContentType();
                    //cpmsshare//PIProfile//Leave//123/123.doc"
                 //Ended kk
                    //  System.out.println(inputstream);
                    String filetype = myfile.getContentType();
                    //System.out.println(filetype);
                    String fileExt =filetype.substring(filetype.lastIndexOf("/") + 1);
                   // System.out.println(fileExt);
                    byte b[]  = IOUtils.toByteArray(inputstream);
                         
              
                     }
                      
                    ViewObject groupVO =getBindings1().findIteratorBinding("PILeaveMangementVO1Iterator").getViewObject();
                    Row row = groupVO.getCurrentRow();
                    row.setAttribute("PIid", str);
                    row.setAttribute("FromDate", fD1);
                    row.setAttribute("ToDate", tD1);
                    row.setAttribute("LeavesApplied", leaveDays.getValue());
                    row.setAttribute("LeaveReason", leave);
                    row.setAttribute("Status", Status);
                    row.setAttribute("LeaveType", leavetype);
                    row.setAttribute("AppliedDate", sqlDate1);
                   // logger.info("Line 586 path doSave Method of PileavemangementMB "+rootPath+"//"+myfile.getFilename());
                  if (myfile!=null)
                  {
                    row.setAttribute("Attachment", rootPath+"//"+myfile.getFilename()); 
                     
                  }
                  else{
                      //row.setAttribute("Attachment", "No Attachement");  
                  }
                   
                    row.setAttribute("SupId", s);
                    groupVO.setCurrentRow(row);
                    BindingContainer bindings = getBindings();
                    OperationBinding operationBinding =
                        bindings.getOperationBinding("Commit");
                    Object result = operationBinding.execute();
                    if (!operationBinding.getErrors().isEmpty()) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      genMsg.getMessage("432",lgCode)));
//                        FacesMessage fm =
//                            new FacesMessage("PI Leave is Not applyed Successfully");
//                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                        FacesContext fctx = FacesContext.getCurrentInstance();
//                        fctx.addMessage(null, fm);
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      genMsg.getMessage("431",lgCode)));
//                        FacesMessage fm =
//                            new FacesMessage("PI Leave applyed Successfully");
//                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                        FacesContext fctx = FacesContext.getCurrentInstance();
//                        fctx.addMessage(null, fm);
                        
                        ViewObject groupVO1 =getBindings1().findIteratorBinding("PILeaveMangementVO1Iterator").getViewObject();
                        groupVO1.executeQuery();
                        Row row1 = groupVO1.last();
                        Integer sno=(Integer)row1.getAttribute("Sno");
                        String piid=(String)row1.getAttribute("PIid");
                        String supid=(String)row1.getAttribute("SupId");
                        Date fd=(Date)row1.getAttribute("FromDate");
                        Date td=(Date)row1.getAttribute("ToDate");
                        java.sql.Date fromdate= new java.sql.Date(fd.getTime());
                        java.sql.Date todate= new java.sql.Date(td.getTime());
                        System.out.println("from date is:::"+fromdate);
                        System.out.println("todate is :::"+todate);
                        OperationBinding operationBinding1 =bindings.getOperationBinding("callPopulatePILeaveProc");
                        operationBinding1.getParamsMap().put("sno",sno );
                        operationBinding1.getParamsMap().put("piid", piid);
                        operationBinding1.getParamsMap().put("fromdate", fromdate);
                        operationBinding1.getParamsMap().put("todate", todate);
                        operationBinding1.getParamsMap().put("flag","N");
                        operationBinding1.getParamsMap().put("supid", supid);
                        operationBinding1.execute(); 
                    }

                    fromDate.setValue(null);
                    toDate.setValue(null);
                    leavereason.setValue(null);
                    leaveDays.setValue(null);
                    halfday.setValue(false);
                    uploadedFile.setValue(null);
                    uploadedFile.setDisabled(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
                    JUCtrlListBinding listBindingResetlov =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforsupervisorVO1");
                    listBindingResetlov.setSelectedIndex(0);
                    JUCtrlListBinding listBindingleavetype =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leavetypeLOV1");
                    listBindingleavetype.setSelectedIndex(0);
                    setMyfile(null);
                    FacesContext context = FacesContext.getCurrentInstance();
                    ExternalContext ectx = context.getExternalContext();
                    Map sessionMap = ectx.getSessionMap();
                    sessionMap.remove("myfile");
                    sessionMap.remove("InputStream");   
                        
                    
                  
                     // attachment.resetValue();  
                    // rootPath = "D://cpmsshare";
               //    getPiLeaveDocs(out);

                   //  }
                  
                }
                 
                }
              }
         
      }
        
        catch(Exception e)
             {
                    e.printStackTrace();
                 // rootPath = "D://cpmsshare";
              }
            
        logger.info("End doSave Method of PileavemangementMB ");
             return null;
    }


    public void setHalfday(RichSelectBooleanCheckbox halfday) {
        this.halfday = halfday;
    }

    public RichSelectBooleanCheckbox getHalfday() {
        return halfday;
    }

    public void setFromDate(RichInputDate fromDate) {
        this.fromDate = fromDate;
    }

    public RichInputDate getFromDate() {
        return fromDate;
    }

    public void setToDate(RichInputDate toDate) {
        this.toDate = toDate;
    }

    public RichInputDate getToDate() {
        return toDate;
    }

    public void setLeavereason(RichInputText leavereason) {
        this.leavereason = leavereason;
    }

    public RichInputText getLeavereason() {
        return leavereason;
    }

    public String pileaveSerach() {
        logger.info("Start pileaveSerach Method of PileavemangementMB ");
        // Add event code here...
        ADFContext adfctx = ADFContext.getCurrent();
       String sup = adfctx.getSessionScope().get("loggedinUserid").toString(); 
       Date d1=(Date)id2.getValue();
       Date d2=(Date)id1.getValue();        
        if(d1== null || d2== null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("434",lgCode)));
//            FacesMessage fm = new FacesMessage("From Date,To Date should be  mandatory ");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm); 
            return null;
           
        }
        else{
            if(d1!= null || d2!= null) {
                
                java.sql.Date fD1 = new java.sql.Date(d1.getTime());
                java.sql.Date tD1 = new java.sql.Date(d2.getTime());
                long diff = tD1.getTime()-fD1.getTime();
                 long diffHours = diff / (60 * 60 * 1000);
                 long dayes= diffHours/24;

                if( dayes > 0) {
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                          "Sample info message",
                                                                                          genMsg.getMessage("427",lgCode)));
//                    FacesMessage fm = new FacesMessage("To Date should not be less than From Date ");
//                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                    FacesContext fctx = FacesContext.getCurrentInstance();
//                    fctx.addMessage(null, fm); 
                          return null; 
                        }
            }
        }
        
        
       String pi=piName.getValue().toString();
       Date tdate=(Date)id2.getValue();
       Date fdate=(Date)id1.getValue();
//        java.sql.Date fD1 = new java.sql.Date(tdate.getTime());
//        java.sql.Date tD1 = new java.sql.Date(fdate.getTime());
        OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getleaveserch");
        op1.getParamsMap().put("pi",pi );
        op1.getParamsMap().put("fd",fdate);
        op1.getParamsMap().put("td",tdate);
        op1.getParamsMap().put("sup_id",sup);
        op1.execute();
        id2.setValue(null);
        id1.setValue(null);
        logger.info("End pileaveSerach Method of PileavemangementMB ");
        return null;
    }

    public void searchLeavePage(ActionEvent actionEvent) {
        logger.info("Start searchLeavePage Method of PileavemangementMB ");
        JUCtrlListBinding listBinding = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforsupervisorVO1");
        String str1 = (String)listBinding.getSelectedValue();
        if(str1==null) {
        //                FacesMessage fm = new FacesMessage("select PI is should be  mandatory ");
        //                fm.setSeverity(FacesMessage.SEVERITY_INFO);
        //                FacesContext fctx = FacesContext.getCurrentInstance();
        //                fctx.addMessage(null, fm);
                                 FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                   "Sample info message",
                                                                                   genMsg.getMessage("428",lgCode)));
             
        }
        else
            
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("piName", str1);
        ADFContext adfctx = ADFContext.getCurrent();
        String sup = adfctx.getSessionScope().get("loggedinUserid").toString();
        OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getSupervisorUnderpis");
        op1.getParamsMap().put("sup_id",sup);
        op1.getParamsMap().put("pinumber",str1);
        op1.execute();
       // System.out.println(str1);
       
        logger.info("End searchLeavePage Method of PileavemangementMB");
    }


    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setPiName(RichInputText piName) {
        this.piName = piName;
    }

    public RichInputText getPiName() {
        return piName;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setAttachment(RichInputFile attachment) {
        this.attachment = attachment;
    }

    public RichInputFile getAttachment() {
        return attachment;
    }

    public void onFileUpload(ValueChangeEvent valueChangeEvent) {
        logger.info("Start onFileUpload Method of PileavemangementMB ");
        try {
       myfile = (UploadedFile)valueChangeEvent.getNewValue();
            InputStream inputstream = myfile.getInputStream();
            //System.out.println(myfile);
            String filetype = myfile.getContentType();
           // System.out.println(filetype);
            String fileExt = filetype.substring(filetype.lastIndexOf("/") + 1);
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext ectx = context.getExternalContext();
            Map sessionMap = ectx.getSessionMap();
            sessionMap.put("InputStream",inputstream);
            sessionMap.put("myfile",myfile);
            
           // System.out.println(fileExt);
            //add code 
            
//            myfile = (UploadedFile)valueChangeEvent.getNewValue();
//                 InputStream inputstream = myfile.getInputStream();
//                 //System.out.println(myfile);
//                 String filetype = myfile.getContentType();
//                 //System.out.println(filetype);
//                 String fileExt = filetype.substring(filetype.lastIndexOf("/") + 1);
//                 FacesContext context = FacesContext.getCurrentInstance();
//                 ExternalContext ectx = context.getExternalContext();
//                 Map sessionMap = ectx.getSessionMap();
//                 sessionMap.put("InputStream",inputstream);
//                 sessionMap.put("myfile",myfile);
//                 //System.out.println(fileExt);
            
            // add code
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("End onFileUpload Method of PileavemangementMB ");
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

    

    public void setLeaveDays(RichInputText leaveDays) {
        this.leaveDays = leaveDays;
    }

    public RichInputText getLeaveDays() {
        return leaveDays;
    }

    public void fromDatevcl(ValueChangeEvent valueChangeEven) {
        logger.info("Start fromDatevcl Method of PileavemangementMB ");
        // Add event code here...
        int count = 0;
        Object check1= valueChangeEven.getNewValue();
        Object check2= toDate.getValue();
        if(check1 != null && check2!=null){
        Date tdate=(Date)toDate.getValue();
         Date fd=(Date)fromDate.getValue();
        java.sql.Date fd1 = new java.sql.Date(fd.getTime());
        java.sql.Date tD1 = new java.sql.Date(tdate.getTime());
        long diff2 = tD1.getTime()-fd1.getTime();
        long diffHours2 = diff2/ (60 * 60 * 1000);
        long dayes2= diffHours2/24;
            OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getFridaysOnly");
             op1.getParamsMap().put("stDate",fromDate.getValue().toString());
             op1.getParamsMap().put("endDate",toDate.getValue().toString());
            Object fridayCount =  op1.execute();
             count = Integer.parseInt(fridayCount.toString());
        if(dayes2 < 0) {
                    Object object = halfday.getValue();
                    if(object!=null) {
                    if(object.equals(true))
                    {
                    halfday.setValue(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(halfday);
                        uploadedFile.setDisabled(false);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
                    }
                    }
        
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("427",lgCode)));
                    leaveDays.setValue("");
//            FacesMessage fm = new FacesMessage("To Date should not be less than From Date ");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm); 
                   
                }
            else{
                Object object = halfday.getValue();
                if(object!=null) {
                if(object.equals(true))
                {
                halfday.setValue(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(halfday);
                    uploadedFile.setDisabled(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
                }
                }
        
            dayes2 = dayes2+1-count;
             leaveDays.setValue(dayes2);
            
            }
        }
        
//         if(check1 == null)
//          {
//                  FacesMessage fm = new FacesMessage("From Date should be  mandatory ");
//                  fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                  FacesContext fctx = FacesContext.getCurrentInstance();
//                  fctx.addMessage(null, fm); 
//                               }
//        Date newValue =(Date)valueChangeEven.getNewValue();
        fromDate.setValue(check1);
        logger.info("End fromDatevcl Method of PileavemangementMB ");
    }

    public void Todatevcl(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        logger.info("Start Todatevcl Method of PileavemangementMB ");
        Object check= valueChangeEvent.getNewValue();
        Object checkVal = fromDate.getValue();
        int count =0;
        
        if(check != null){
                if(checkVal == null)
                 {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("424",lgCode)));
//                         FacesMessage fm = new FacesMessage("From Date should be  mandatory ");
//                         fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                         FacesContext fctx = FacesContext.getCurrentInstance();
//                         fctx.addMessage(null, fm); 
                        
                }
                else{
                    if(check != null && checkVal!=null){
                    Date tdate=(Date)toDate.getValue();
                     Date fd=(Date)fromDate.getValue();
                    java.sql.Date fd1 = new java.sql.Date(fd.getTime());
                    java.sql.Date tD1 = new java.sql.Date(tdate.getTime());
                    long diff2 = tD1.getTime()-fd1.getTime();
                    long diffHours2 = diff2/ (60 * 60 * 1000);
                    long dayes2= diffHours2/24;
                        OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getFridaysOnly");
                         op1.getParamsMap().put("stDate",fromDate.getValue().toString());
                         op1.getParamsMap().put("endDate",toDate.getValue().toString());
                      Object fridayCount =  op1.execute();
                       count = Integer.parseInt(fridayCount.toString());
                         //System.out.println(op1.execute());
                    if(dayes2 < 0) {
                                Object object = halfday.getValue();
                                if(object!=null) {
                               if(object.equals(true))
                               {
                                halfday.setValue(false);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(halfday);
                                    uploadedFile.setDisabled(false);
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
                                }
                                }
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("427",lgCode)));
                                leaveDays.setValue("");
                                
//                        FacesMessage fm = new FacesMessage("To Date should not be less than From Date ");
//                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                        FacesContext fctx = FacesContext.getCurrentInstance();
//                        fctx.addMessage(null, fm); 
                               
                            }
                        else{
                        Object object = halfday.getValue();
                        if(object!=null) {
                        object.equals(true);
                        halfday.setValue(false);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(halfday);
                    }
                        dayes2 = dayes2+1-count;
                         leaveDays.setValue(dayes2);
                        }
                    }
                    
                }
        }
        else{
        //System.out.println(valueChangeEvent.getNewValue());
   
//        if(check == null)
//         {
//                 FacesMessage fm = new FacesMessage(" To Date should be  mandatory ");
//                 fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                 FacesContext fctx = FacesContext.getCurrentInstance();
//                 fctx.addMessage(null, fm); 
//         
// }
        if(check != null){
        Date tdate=(Date)valueChangeEvent.getNewValue();
         Date fd=(Date)fromDate.getValue();
        java.sql.Date fd1 = new java.sql.Date(fd.getTime());
        java.sql.Date tD1 = new java.sql.Date(tdate.getTime());
        long diff2 = tD1.getTime()-fd1.getTime();
        long diffHours2 = diff2/ (60 * 60 * 1000);
        long dayes2= diffHours2/24;
        if(dayes2 < 0) {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("427",lgCode)));
//            FacesMessage fm = new FacesMessage("To Date should not be less than From Date ");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm); 
                   
                }
      
            else{
            
            dayes2 = dayes2+1-count;
             leaveDays.setValue(dayes2);
            }
        }
        }
        logger.info("End Todatevcl Method of PileavemangementMB ");
    }
  
    public void halfday(ValueChangeEvent valueChangeEvent) {
        logger.info("Start halfday Method of PileavemangementMB ");
        // Add event code here...
       // Object h=valueChangeEvent.getOldValue();
       Object object = halfday.getValue();
        Object day=leaveDays.getValue();
        try{
        if(day==null) {
         System.out.println("dj");   
        }
        else
        {
       // oldValue=leaveDays.getValue().toString();
        }
    Boolean b1=(Boolean)valueChangeEvent.getNewValue();
        Object check1=fromDate.getValue();//.toString();//.replaceAll("-","");
        Object check2=toDate.getValue();//.toString();//.replaceAll("-","");
    //Added kk
        if(b1){
    if(check1 == null)
     {
          halfday.setValue(false);
          AdfFacesContext.getCurrentInstance().addPartialTarget(halfday);
          uploadedFile.setDisabled(false);
          AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
          FacesContext.getCurrentInstance().addMessage(null,
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                        "Sample info message",
                                                                        genMsg.getMessage("424",lgCode)));
          
//             FacesMessage fm = new FacesMessage("From Date should be  mandatory ");
//             fm.setSeverity(FacesMessage.SEVERITY_INFO);
//             FacesContext fctx = FacesContext.getCurrentInstance();
//             fctx.addMessage(null, fm); 
           
      }
       else  if(check2 == null)
         {
              halfday.setValue(false);
              AdfFacesContext.getCurrentInstance().addPartialTarget(halfday);
              uploadedFile.setDisabled(false);
              AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
              FacesContext.getCurrentInstance().addMessage(null,
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                            "Sample info message",
                                                                            genMsg.getMessage("425",lgCode)));
//                 FacesMessage fm = new FacesMessage(" To Date should be  mandatory ");
//                 fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                 FacesContext fctx = FacesContext.getCurrentInstance();
//                 fctx.addMessage(null, fm); 
          }
       else if(check1 != null && check2 != null){
            String sdt= fromDate.getValue().toString().replaceAll("-","");
            String edt= toDate.getValue().toString().replaceAll("-","");
            
         if(fromDate.getValue().toString().equals(toDate.getValue().toString()) && b1){
             leaveDays.setValue(0.5);
             if(object!=null) {
             if(object.equals(true))
             {
              uploadedFile.setDisabled(true);
             AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
             if(uploadedFile.getValue()!=null) {
                 uploadedFile.setValue(null);  
                 setMyfile(null);
             }
             }
             else {
                 uploadedFile.setDisabled(false);
                 AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
             }
             
             
             }
             
         }
         
         else if(!sdt.equals(edt)){
              halfday.setValue(false);
              AdfFacesContext.getCurrentInstance().addPartialTarget(halfday);
              uploadedFile.setDisabled(false);
              AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
              FacesContext.getCurrentInstance().addMessage(null,
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                            "Sample info message",
                                                                            genMsg.getMessage("429",lgCode)));
              
//              FacesMessage fm = new FacesMessage(" From date and To date should be the same Date ");
//              fm.setSeverity(FacesMessage.SEVERITY_INFO);
//              FacesContext fctx = FacesContext.getCurrentInstance();
//              fctx.addMessage(null, fm); 
            //  oldValue =  leaveDays.getValue().toString(); 
             // leaveDays.setValue(oldValue); 
          }
            else {
          //  oldValue =  leaveDays.getValue().toString();
             
            leaveDays.setValue(0.5);
            }
        }

    
    }
        else{
            if(check1 != null && check2 != null){
          //if(!oldValue.equals("")){
                if(fromDate.getValue().toString().equals(toDate.getValue().toString()) && !b1){
                    uploadedFile.setDisabled(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
                  leaveDays.setValue(1);
                }
                else{
                    
                   // leaveDays.setValue(oldValue);
                }
                
               
                //oldValue=leaveDays.getValue().toString();
      //   }
           
            }
//            else {
//                FacesMessage fm = new FacesMessage(" From date and To date should be mandatory ");
//             fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                 FacesContext fctx = FacesContext.getCurrentInstance();
//                       fctx.addMessage(null, fm);
//            }
                
            
        }
    }
        catch(Exception e) {
         e.printStackTrace();   
            
        }
        
    //End
    logger.info("End halfday Method of PileavemangementMB ");
  
       
        
    }

    public String doCancel() {
        // Add event code here...
        logger.info("Start doCancel Method of PileavemangementMB ");
        fromDate.setValue(null);
        toDate.setValue(null);
        leavereason.setValue(null);
        leaveDays.setValue(null);
        uploadedFile.setValue(null);
        halfday.setValue(false);
        uploadedFile.setDisabled(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(uploadedFile);
        JUCtrlListBinding listBindingResetlov =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("pisforsupervisorVO1");
        listBindingResetlov.setSelectedIndex(0);
        JUCtrlListBinding listBindingleavetype =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leavetypeLOV1");
        listBindingleavetype.setSelectedIndex(0);
        setMyfile(null);
        logger.info("End doCancel Method of PileavemangementMB ");
         return null;
    }

    public String doBack() {
        // Add event code here...
        
       
        
        return null;
    }

    public void chengeM(ValueChangeEvent valueChangeEvent) {
        logger.info("Start chengeM Method of PileavemangementMB ");
//        JUCtrlListBinding listBinding2 =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leavetypeLOV1");
//        String leavetype1 = (String)listBinding2.getSelectedValue();
        
        //System.out.println(valueChangeEvent.getNewValue().toString());
        int indiex=Integer.parseInt(valueChangeEvent.getNewValue().toString());
        OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getMandatoryType");
        op1.getParamsMap().put("indexCount",indiex );
        String typename =(String)op1.execute();
        if(!typename.equalsIgnoreCase("Consolation leave")&&!typename.equalsIgnoreCase("Sick leave")&&!typename.equalsIgnoreCase("Marriage leave"))
        {
      getUploadedFile().setShowRequired(true);
            }
        else{
            getUploadedFile().setShowRequired(false);
        }
        logger.info("End chengeM Method of PileavemangementMB ");
    }

    public void doBack(ActionEvent actionEvent) {
        // Add event code here...
        logger.info("Start doBack Method of PileavemangementMB ");
        id2.setValue(null);
        id1.setValue(null);
        logger.info("End doBack Method of PileavemangementMB ");
        
        
    }
}
