package com.imum.cpms.view;

import com.imum.cpms.model.masters.eo.CourtpvtHeaderVORowImpl;
import com.imum.cpms.model.masters.vo.InvStockReorderLevelDetailsVORowImpl;
import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;

import com.imum.cpms.model.masters.vo.PVTCourtReportUVORowImpl;
import com.imum.cpms.model.transactions.vo.InvEventDetailsUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTEventDetailsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVORowImpl;
import com.imum.cpms.transactions.PoundBayAllocationBean;
import com.imum.cpms.util.FileUpload;

import com.imum.cpms.util.MessageUtil;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Map;

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
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.model.UploadedFile;


public class PVTCourtReportingMbean {
    private RichInputText pvtNumber;
    String pvtNumberValue=null;
    private String Mode=null;
    private RichTable docTable;
    private boolean hide = false;
    private boolean enabled = true;
    private boolean look=false;
    private boolean editMode=false;
    public BigDecimal hdrseq=null;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    private RichInputText inactivateseq;
    MessageUtil genMsg = new MessageUtil();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
   //String lngCode ="EN";
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    private Row currentAttchmtRow=null;
    private RichTable coderdoc;
    private RichTable courttablebind;
    private RichCommandLink filePropertyCommandLink;
    private boolean dcodesc=false;
    private boolean upload=false;
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    private RichCommandButton sbutton;
    private RichCommandImageLink deletebind;
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    private String remarks=null;
    private RichTable remarkestablebind;
    private boolean remarkstable=false;
    private RichInputDate caseclosedDate;
    private RichSelectOneRadio judgement;


    public PVTCourtReportingMbean() {
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    private String rootPath = "//cpmsshare";
    public static final ADFLogger logger = ADFLogger.createADFLogger(PoundBayAllocationBean.class);
    private BigDecimal s;
    private DCBindingContainer getBindings1() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public void pvtSearch(ActionEvent actionEvent) {
        System.out.println(this.getPvtNumber());
        if(pvtNumber.getValue()!=null&&!"".equals(pvtNumber.getValue())){
        pvtNumberValue=pvtNumber.getValue().toString();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("executePVTSearchVO");
        opBinding.getParamsMap().put("pvtNumber",pvtNumberValue);        
        Object ob = opBinding.execute(); 
        if(ob!=null && !ob.equals("")) {
            hdrseq=new BigDecimal(ob.toString());
        }
      //  System.out.println(pvtNumberValue+" "+hdrseq); 
        if(hdrseq==null||"".equals(hdrseq)){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter a valid PVT No.",null));  
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setvisiblePvt",false); 
        }
        
    }
        else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter PVT No.",null));  
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setvisiblePvt",false); 
           
        }
    }
    
    public void visibleInitiate(ActionEvent actionEvent){
        
        
        setLook(Boolean.TRUE); 
        setEditMode(Boolean.FALSE);
        pvtNumber.setDisabled(true);
        sbutton.setDisabled(true);
       
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("executeCreateCourtReport");
        opBinding.execute();
        
        BindingContext bindingctx = BindingContext.getCurrent();
        BindingContainer binding = bindingctx.getCurrentBindingsEntry();
        DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
        
        //Code for testing
        DCIteratorBinding dciterrefundattchmt =
            bindingsImpl.findIteratorBinding("PVTDocsVO1Iterator");
        ViewObject pvtdocVO = dciterrefundattchmt.getViewObject();
        pvtdocVO.executeEmptyRowSet();
        
    }
    
    

    public void setPvtNumber(RichInputText pvtNumber) {
        this.pvtNumber = pvtNumber;
    }

    public RichInputText getPvtNumber() {
        return pvtNumber;
    }
//    public BigDecimal getPVTHDRSeqNumber() {
//       DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
//       DCIteratorBinding headerPvt =
//           bindingsAM.findIteratorBinding("PVTHeaderVO1Iterator");
//       ViewObjectImpl headerPvtVO = (ViewObjectImpl)headerPvt.getViewObject();              
//       if(headerPvtVO!=null &&  getPvtNumber()!=null)
//       {
//           headerPvtVO.setWhereClause(null);
//           headerPvtVO.setWhereClause("PVT_Num = '"+ getPvtNumber()+"'");
//           headerPvtVO.executeQuery();
//           logger.info("get query in Submit Bay Changes Action" + headerPvtVO.getQuery());
//           PVTHeaderVORowImpl pvtHdrRow = (PVTHeaderVORowImpl)headerPvtVO.first();
//           if(pvtHdrRow!=null){
//               pvtHdrSeqUpload = pvtHdrRow.getPVTHDRSEQ();
//           }
//       }
//       return pvtHdrSeqUpload;
//    }
    public void setDocTable(RichTable docTable) {
        this.docTable = docTable;
    }

    public RichTable getDocTable() {
        return docTable;
    }

    public void attachValueChangeListner1(ValueChangeEvent valueChangeEvent) {
        DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
        DCIteratorBinding pvtDocs =
            bindingsAM.findIteratorBinding("PVTDocsVO1Iterator");
        
        currentAttchmtRow = pvtDocs.getRowAtRangeIndex(getDocTable().getRowIndex());
    }

    public void courtFileUpload(ValueChangeEvent valueChangeEvent) {
    UploadedFile uploadFile =  (UploadedFile)valueChangeEvent.getNewValue();
    BindingContainer bindings = getBindings();
    OperationBinding opBinding = bindings.getOperationBinding("courtFileUploadMethod");
    opBinding.getParamsMap().put("pvtNumber",pvtNumberValue); 
    opBinding.getParamsMap().put("hdrSeq",hdrseq);
    opBinding.getParamsMap().put("uploadFile", uploadFile);
    opBinding.execute();
    

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

    public String uploadDoc() {
        

        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("ModeA","visibleInitiate"); 
        BindingContext bindingctx = BindingContext.getCurrent();
        BindingContainer binding = bindingctx.getCurrentBindingsEntry();
        DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
        
        //Code for testing
        DCIteratorBinding dciterrefundattchmt = bindingsImpl.findIteratorBinding("PVTDocsVO1Iterator");
        ViewObject pvtdocVO = dciterrefundattchmt.getViewObject();
        pvtdocVO.executeEmptyRowSet();
        Row NewRow=pvtdocVO.createRow();
        pvtdocVO.insertRow(NewRow);
       
       
        return null;
    }

    public String Cancel() {
        getBindings().getOperationBinding("doRollback").execute();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setvisiblePvt",false); 
        setHide(Boolean.FALSE); 
        setLook(Boolean.FALSE);
        pvtNumber.setDisabled(false);
        sbutton.setDisabled(false);
        setRemarkstable(Boolean.FALSE);
        AdfFacesContext.getCurrentInstance().addPartialTarget(remarkestablebind); 
        return null;
    }

    public String submit() {
        String result = validateDataOnSubmit();
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("CourtpvtHeaderVO1Iterator");
        ViewObject PVTHeaderVO = dcItteratorBinding.getViewObject();
        if(result.equals("pass")){
                BindingContext bindingctx = BindingContext.getCurrent();
                BindingContainer binding = bindingctx.getCurrentBindingsEntry();
                DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
                DCIteratorBinding dciterrefundattchmt = bindingsImpl.findIteratorBinding("PVTCourtReportUVO2Iterator");
                ViewObject  pvtcourtrepVO= dciterrefundattchmt.getViewObject();
                PVTCourtReportUVORowImpl row=(PVTCourtReportUVORowImpl)pvtcourtrepVO.getCurrentRow();
                
                if(hdrseq!=null) {
                    
                    PVTHeaderVO.executeEmptyRowSet();
                    PVTHeaderVO.setWhereClause(null);
                    PVTHeaderVO.setWhereClauseParams(null);
                    PVTHeaderVO.setWhereClause("PVT_HDR_SEQ = '"+hdrseq+"'");
                    PVTHeaderVO.executeQuery();
                }
                
                CourtpvtHeaderVORowImpl row1=(CourtpvtHeaderVORowImpl)PVTHeaderVO.first();  
            if(Mode.equals("new")) {
                setHide(Boolean.FALSE); 
                setLook(Boolean.FALSE);
                if(null != hdrseq)
                {
                    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
                    row.setPVTHDRSEQ(hdrseq);
                    if(row.getCasestatusID()==null) {
                        row.setCasestatusID(1);
                    }   
                    row.setCreatedBy(userName);
                    row.setCreatedDate(sqlDate);
                    if(row.getJudgementStatusID()==null) {
                        row.setJudgementStatusID(1);
                    }
                    System.out.println(row.getProgressremarks());
                    remarks=row.getProgressremarks();
                   
                Timestamp sqlDate1 = new java.sql.Timestamp(new java.util.Date().getTime());
                if(row1!=null) {
                    System.out.println(row1.getPVTSTAGEID()); 
                    System.out.println(row1.getPVTNum()); 
                    row1.setPVTSTAGEID(13);
                    row1.setUpdatedby(userName);
                    row1.setUpdateddate(sqlDate1);
                }
               
           //Inserting Notes in PVT Event Details table
           DCBindingContainer AM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
           DCIteratorBinding dccourt =AM.findIteratorBinding("PVTEventDetailsVO1Iterator");
                    ViewObject eventVO = dccourt.getViewObject();
                       if (eventVO != null) {
                        Row eventRow = eventVO.createRow();
                        eventRow.setAttribute("PVTHDRSEQ", hdrseq);
                        eventRow.setAttribute("Remarks",remarks);
                        eventRow.setAttribute("EVENTID", "588");
                        eventRow.setAttribute("EVENTDATE", sqlDate);
                        eventRow.setAttribute("CreatedBy", userName);
                        eventRow.setAttribute("CreatedDate", sqlDate);
                        eventVO.insertRow(eventRow);

                    }


                }
         
   
            }
            if(Mode.equals("edit")) {
                String eventremarks=null;
                Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
                Object closecourt=row.getCasestatusID();
               Object status=row.getJudgementStatusID();
               if(status.equals(2)) {
                   eventremarks="favour of DoT";
                   row1.setPVTSTAGEID(20);
                   row1.setUpdatedby(userName);
                   row1.setUpdateddate(sqlDate);
                   
               }
               if(status.equals(3))
               {
                   eventremarks="Against DoT";
                   row1.setPVTSTAGEID(21);
                   row1.setUpdatedby(userName);
                   row1.setUpdateddate(sqlDate);
                   row1.setPVTStatusID(3);
               }
                if(closecourt!=null) {
                    int s=Integer.parseInt(closecourt.toString());
                    if(s==2) {
                        DCBindingContainer AM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dccourt =AM.findIteratorBinding("PVTEventDetailsVO1Iterator");
                                 ViewObject eventVO = dccourt.getViewObject();
                                 
                                 eventVO.clearCache();
                                 eventVO.executeEmptyRowSet();
                                 if (eventVO != null) {
                                     Row eventRow = eventVO.createRow();
                                     eventRow.setAttribute("PVTHDRSEQ", hdrseq);
                                     eventRow.setAttribute("Remarks",eventremarks);
                                     eventRow.setAttribute("EVENTID", "589");
                                     eventRow.setAttribute("EVENTDATE", sqlDate);
                                     eventRow.setAttribute("CreatedBy", userName);
                                     eventRow.setAttribute("CreatedDate", sqlDate);
                                     eventVO.insertRow(eventRow);
                                 }
                    }
                }
                row.setUpdatedate(sqlDate);
                row.setUpdatedby(userName);
                System.out.println(row.getProgressremarks());
                remarks=row.getProgressremarks();
              
                   
                
            }
            }
            
            
     if (result.equals("pass")) { 
             BigDecimal  seq=null;
             Timestamp sql= new java.sql.Timestamp(new java.util.Date().getTime());
        OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
        opBindingDoc.execute();       
        if(opBindingDoc.getErrors().isEmpty()){  
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Details saved Successfully",null));    
            setHide(Boolean.FALSE); 
            setLook(Boolean.FALSE);
            setRemarkstable(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setvisiblePvt",false); 
          AdfFacesContext.getCurrentInstance().addPartialTarget(courttablebind); 
            BindingContext bindingctx = BindingContext.getCurrent();
            BindingContainer binding = bindingctx.getCurrentBindingsEntry();
            DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
            DCIteratorBinding dciterrefundattchmt =bindingsImpl.findIteratorBinding("PVTCourtReportUVO1Iterator");
            ViewObject courtvo = dciterrefundattchmt.getViewObject();
            Row r=courtvo.getCurrentRow();
            if(remarks!=null)
            {
            if(r!=null) {
             Object ob=r.getAttribute("CourtReportingseq");
                seq=(BigDecimal)ob;
                Timestamp sqlDate1 = new java.sql.Timestamp(new java.util.Date().getTime());
                System.out.println(r.getAttribute("CourtReportingseq"));
                DCIteratorBinding dc =bindingsImpl.findIteratorBinding("PVTCourtcaseremarksVO1Iterator");
                ViewObject remarkesVO = dc.getViewObject();
                Row remarkesRow=remarkesVO.createRow();
                if(Mode.equals("new")) {
                    remarkesRow.setAttribute("CourtReportingseq",seq.add(new BigDecimal(1)));
                }
                else  
                remarkesRow.setAttribute("CourtReportingseq",seq);
                remarkesRow.setAttribute("Remarksdate",sqlDate1); 
                remarkesRow.setAttribute("Remarks",remarks);
                remarkesRow.setAttribute("CreatedBy",userName);
                remarkesRow.setAttribute("CreatedDate",sqlDate1);
                remarkesVO.insertRow(remarkesRow);
                OperationBinding op = getBindings().getOperationBinding("doCommit");                
                op.execute();
                remarkesVO.executeQuery();
            }
            }  
            DCIteratorBinding bind =bindingsImpl.findIteratorBinding("PVTCourtReportUVO1Iterator");
            ViewObject tablevo = bind.getViewObject();
            tablevo.executeQuery();
            
            AdfFacesContext.getCurrentInstance().addPartialTarget(remarkestablebind); 
        }

         }
  
        return null; 
        
    }
    
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("PVTCourtReportUVO2Iterator");
        ViewObject courtVO = dcIteratorBinding.getViewObject();
        PVTCourtReportUVORowImpl Row = (PVTCourtReportUVORowImpl)courtVO.getCurrentRow();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        java.sql.Date courtcaseindate=null;
        java.sql.Date courtcasecldate=null;
        if (Row != null) {            
            
            Object LawyerEmailID = Row.getLawyerEmailID();
           
            if(LawyerEmailID == null || LawyerEmailID.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Lawyer Email ID.", null));    
                result = "fail";    
            }
            Object LawyerMobNum = Row.getLawyerMobNum();
           
            if(LawyerMobNum == null || LawyerMobNum.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Lawyer Mobile Number. ", null));    
                result = "fail";    
            }
            Object LawyerName = Row.getLawyerName();
            
            if(LawyerName == null || LawyerName.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Lawyer Name.", null));    
                result = "fail";    
            }
            Object id=Row.getCasestatusID();
            if(id!=null)
            {
                String st=id.toString();
                int i=Integer.parseInt(st);
                if(i==2)
                {
           // Court case date          
            Object  closeddate = Row.getcaseclosuredate();
            if( closeddate == null ||  closeddate.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select Court Case Closed Date.", null));    
                result = "fail";    
            }
            else {
                Object  CreatedDate = Row.getcaseinitiationdate();
                if(CreatedDate!=null)
                {
                    courtcaseindate = new java.sql.Date(Row.getcaseinitiationdate().getTime());
                    courtcasecldate = new java.sql.Date(Row.getcaseclosuredate().getTime());
                    String actfromdate = courtcaseindate.toString();
                    String sqlDatefromstr = sqlDate.toString();
                    String acttidate=courtcasecldate.toString();
                    
                    if(courtcasecldate.before(sqlDate) ) {
                        if(acttidate.compareToIgnoreCase(sqlDatefromstr) == 0) {
                                         System.out.println(sqlDate);
                        }                       
                        
                    }
                    else
                    {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Court case close date should be befor The current Date",null));
                        result = "fail";   
                    }
                    if(courtcaseindate.after(courtcasecldate) ) 
                    {
                            if(actfromdate.compareToIgnoreCase(acttidate) == 0) 
                                             System.out.println(sqlDate);
                        else {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Court case close date should be after court case initiated date",null));    
                             result = "fail"; 
                        }
                    }   
                 
                }
            }
            //Judgement 
                    Object  judgement = Row.getJudgementStatusID();
                    if(judgement!=null) {
                   int j=Integer.parseInt(judgement.toString());
                    
                    if( j == 1 ||  judgement.equals("")) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select Judgement.", null));    
                        result = "fail";    
                    }
                    }
                    
                //   Court case date valid 
                    
                    
                 
                    
                }
            }
            Object  DoTRoleType = Row.getDoTRoleType();
            
            if( DoTRoleType == null ||  DoTRoleType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select Plaintiff/Defendant.", null));    
                result = "fail";    
            }
            Object caseinition = Row.getcaseinitiationdate();
            
            if(caseinition == null || caseinition.equals("")) {
               
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Case Initiated Date ", null));    
                result = "fail";    
            }
            else {
                if(Mode.equals("new")) {
               java.sql.Date  courtiniti = new java.sql.Date(Row.getcaseinitiationdate().getTime());
                    String sqlDatefromstr = sqlDate.toString();
                    String actfromdate = courtiniti.toString();
                    if(courtiniti.before(sqlDate) ) {
                        if(actfromdate.compareToIgnoreCase(sqlDatefromstr) == 0) {
                                         System.out.println(sqlDate);
                        }                       
                        
                    }
                    else
                    {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Court case Case Initiated Date should be befor The current Date",null));
                        result = "fail";   
                    }
                }
            }
            
        }
        return result;
    }

    public String editAction() {
        BigDecimal seq=null;
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        setEnabled(Boolean.TRUE);
        setHide(Boolean.FALSE);  
        setLook(Boolean.TRUE);
        setRemarkstable(Boolean.TRUE);
        setEditMode(Boolean.TRUE);
       setDcodesc(Boolean.TRUE);
        setUpload(Boolean.FALSE);
        Mode="edit";
        caseclosedDate.setDisabled(Boolean.TRUE);
            judgement.setDisabled(Boolean.TRUE);
        BigDecimal courtseq;
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTCourtReportUVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
            seq=new BigDecimal(selectedRow.getAttribute("CourtReportingseq").toString());
        }
        
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("PVTCourtReportUVO2Iterator");
        ViewObject appVO = dcItteratorBinding.getViewObject();
        appVO.executeEmptyRowSet();
        appVO.setWhereClause(null);
        appVO.setWhereClauseParams(null);
        appVO.setWhereClause("Court_Reporting_seq = '"+seq +"'");
        appVO.executeQuery();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("ModeA","visibleInitiate");
       Object ob=selectedRow.getAttribute("PVTHDRSEQ");
        Object closecourt=selectedRow.getAttribute("CasestatusID");
        if(closecourt!=null) {
            int s=Integer.parseInt(closecourt.toString());
            if(s==2) {
                setHide(Boolean.FALSE);  
                setLook(Boolean.TRUE);
                setEnabled(Boolean.FALSE);
                setEditMode(Boolean.TRUE);
                setDcodesc(Boolean.TRUE); 
             
            }
        }
       if(ob!=null)
       {
        BigDecimal pvthdr=new BigDecimal(ob.toString());
        DCIteratorBinding dcI =bindingsAM.findIteratorBinding("PVTCourtReportDocsUVO1Iterator");
        ViewObject docvo = dcI.getViewObject();
        docvo.setWhereClause("PVT_HDR_SEQ = '"+pvthdr +"' and Doc_stage=6" );
        docvo.executeQuery();
           hdrseq=pvthdr;
        
       }
        DCIteratorBinding dc =bindingsAM.findIteratorBinding("PVTCourtcaseremarksVO1Iterator");
        ViewObject remarkesVO = dc.getViewObject(); 
        
        if(remarkesVO!=null){
            
            remarkesVO.setWhereClause("Court_Reporting_seq ='"+seq +"'" );
            remarkesVO.executeQuery();
        }
       
       
       
       
       
        return null;
    }

    public String viewAction() {
        BigDecimal seq=null;
        setHide(Boolean.FALSE);  
        setLook(Boolean.TRUE);
        setEnabled(Boolean.FALSE);
        setEditMode(Boolean.TRUE);
        setDcodesc(Boolean.FALSE);
        setUpload(Boolean.TRUE);
        
        
        
        setRemarkstable(Boolean.TRUE);
        caseclosedDate.setDisabled(Boolean.TRUE);
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTCourtReportUVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
            seq=new BigDecimal(selectedRow.getAttribute("CourtReportingseq").toString());
        }
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("PVTCourtReportUVO2Iterator");
        ViewObject appVO = dcItteratorBinding.getViewObject();
        appVO.executeEmptyRowSet();
        appVO.setWhereClause(null);
        appVO.setWhereClauseParams(null);
        appVO.setWhereClause("Court_Reporting_seq = '"+ seq+"'");
        appVO.executeQuery();
        Object ob=selectedRow.getAttribute("PVTHDRSEQ");
        if(ob!=null)
        {
         BigDecimal pvthdr=new BigDecimal(ob.toString());
         DCIteratorBinding dcI =bindingsAM.findIteratorBinding("PVTCourtReportDocsUVO1Iterator");
         ViewObject docvo = dcI.getViewObject();
         docvo.setWhereClause("PVT_HDR_SEQ = '"+pvthdr +"' and Doc_stage=6" );
         docvo.executeQuery();         
        }
        
        DCIteratorBinding dc =bindingsAM.findIteratorBinding("PVTCourtcaseremarksVO1Iterator");
        ViewObject remarkesVO = dc.getViewObject(); 
        
        if(remarkesVO!=null){
            
            remarkesVO.setWhereClause("Court_Reporting_seq = '"+seq +"'" );
            remarkesVO.executeQuery();
        }
        
        
        
        return null;
    }

    public String newAction() {
        setHide(Boolean.TRUE); 
        setLook(Boolean.FALSE);
        Mode="new";
        setDcodesc(Boolean.TRUE);
        setUpload(Boolean.FALSE);
        
        
        
        setRemarkstable(Boolean.FALSE);
        if(!isEnabled())
            setEnabled(Boolean.TRUE);
        return null;
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

  

    public void setLook(boolean look) {
        this.look = look;
    }

    public boolean isLook() {
        return look;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setMode(String Mode) {
        this.Mode = Mode;
    }

    public String getMode() {
        return Mode;
    }
    
    public void addUploadDoc(ActionEvent actionEvent) {
        
        ViewObject docVo = getBindings1().findIteratorBinding("PVTCourtReportDocsUVO1Iterator").getViewObject();
        Row newRow = docVo.createRow();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        //        newRow.setAttribute("", );
        newRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
            newRow.setAttribute("CreatedDate", sqlDate);
        docVo.insertRow(newRow);
        
    }

    public void fileuploadVC(ValueChangeEvent vce) {
        String uploadPath = null;
        String fullPath = null;
        String pvtno=pvtNumberValue;
        DCIteratorBinding bind =getBindings1().findIteratorBinding("PVTCourtReportUVO2Iterator");     
        RichInputFile inputFileComponent = (RichInputFile)vce.getComponent();
        UploadedFile newFile = (UploadedFile)vce.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());
        DCIteratorBinding dciterrefundattchmt = getBindings1().findIteratorBinding("PVTCourtReportDocsUVO1Iterator");
        currentAttchmtRow = dciterrefundattchmt.getRowAtRangeIndex(getCoderdoc().getRowIndex());
        System.out.println(currentAttchmtRow.getAttribute("CreatedDate"));
        if (null != vce.getNewValue()) {
            UploadedFile uploadFile =(UploadedFile)vce.getNewValue();
            if (uploadFile != null) {
                uploadPath =uploadFilesToFolder("1", "PVT", pvtno, uploadFile);
                if (uploadPath != null) {
                    fullPath = uploadPath + "//" + uploadFile.getFilename();
                }
                String docFielName = uploadFile.getFilename();
                java.sql.Date sqlDate =
                    new java.sql.Date(new java.util.Date().getTime());
                System.out.println("sqlDate is : " + sqlDate);
                
                /*start of code to get RelatedTo value */
                /*end of code */
                int docType = getFileExtension(docFielName);
                //String userName = userName;
       
                currentAttchmtRow.setAttribute("CreatedBy", userName);
                currentAttchmtRow.setAttribute("filepath", fullPath);
                currentAttchmtRow.setAttribute("deleteflag", "N");
                currentAttchmtRow.setAttribute("doctype", docType);
                currentAttchmtRow.setAttribute("Docstage", 6);
                currentAttchmtRow.setAttribute("PVTHDRSEQ", hdrseq);
          
            }
        }
       
       
       
       
    }
    
    public String uploadFilesToFolder(String organizationId,
                                      String documentCategory, String code,
                                       UploadedFile uploadFiles) {

      String path = null;
      String uploadedPath = null;
      if (null != uploadFiles) {
       
          UploadedFile tempFile = uploadFiles;
          System.out.println("temp file" + tempFile.getFilename());
        //  rootPath = "D://FileStore";
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
                   if(documentCategory.equals("PVT"))
                   {                        
                     File docCat = null;
                     if (documentCategory.equals("PVT"))
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
                       if(documentCategory.equals("PVT"))
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

    public void setCoderdoc(RichTable coderdoc) {
        this.coderdoc = coderdoc;
    }

    public RichTable getCoderdoc() {
        return coderdoc;
    }

    public void setCourttablebind(RichTable courttablebind) {
        this.courttablebind = courttablebind;
    }

    public RichTable getCourttablebind() {
        return courttablebind;
    }

    public void downloadFileListener(FacesContext facesContext,
                                     java.io.OutputStream outputStream) {
      
        String filePath =(String)getFilePropertyCommandLink().getAttributes().get("filePath");
        System.out.println("filePath  :::::::::::::::::             "+filePath);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            outputStream.flush();
        } catch (IOException e) {
        }
    }

    public void setFilePropertyCommandLink(RichCommandLink filePropertyCommandLink) {
        this.filePropertyCommandLink = filePropertyCommandLink;
    }

    public RichCommandLink getFilePropertyCommandLink() {
        return filePropertyCommandLink;
    }

    public void setDcodesc(boolean dcodesc) {
        this.dcodesc = dcodesc;
    }

    public boolean isDcodesc() {
        return dcodesc;
    }

    public void setSbutton(RichCommandButton sbutton) {
        this.sbutton = sbutton;
    }

    public RichCommandButton getSbutton() {
        return sbutton;
    }


    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setRemarkestablebind(RichTable remarkestablebind) {
        this.remarkestablebind = remarkestablebind;
    }

    public RichTable getRemarkestablebind() {
        return remarkestablebind;
    }

    public void setRemarkstable(boolean remarkstable) {
        this.remarkstable = remarkstable;
    }

    public boolean isRemarkstable() {
        return remarkstable;
    }

    public void closedDate(ValueChangeEvent valueChangeEvent) {
        Object ob=valueChangeEvent.getNewValue();
        if(ob!=null)
        {
        if(ob.equals(true)){
        caseclosedDate.setDisabled(Boolean.FALSE);
            judgement.setDisabled(Boolean.FALSE);
        caseclosedDate.setShowRequired(true);
            judgement.setShowRequired(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(judgement); 
        AdfFacesContext.getCurrentInstance().addPartialTarget(caseclosedDate); 
        }
        }
    }

    public void setCaseclosedDate(RichInputDate caseclosedDate) {
        this.caseclosedDate = caseclosedDate;
    }

    public RichInputDate getCaseclosedDate() {
        return caseclosedDate;
    }

    public void setJudgement(RichSelectOneRadio judgement) {
        this.judgement = judgement;
    }

    public RichSelectOneRadio getJudgement() {
        return judgement;
    }
}

