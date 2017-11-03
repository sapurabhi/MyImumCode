package com.imum.cpms.transactions.pvt;

import com.imum.cpms.model.masters.vo.PVTWRITEOFFDETAILSVORowImpl;
import com.imum.cpms.model.masters.vo.PvtSearchWriteOffRVORowImpl;

import com.imum.cpms.model.transactions.vo.PVTDiscountHeaderSearchVORowImpl;

import com.imum.cpms.model.transactions.vo.PVTDocsVORowImpl;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.application.FacesMessage;

import com.imum.cpms.util.ADFUtils;

//import com.imum.cpms.util.CustomUploadedFile;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;

import oracle.adf.model.binding.DCBindingContainer;
//import oracle.adf.model.binding.DCIteratorBinding;
import com.imum.cpms.util.MessageUtil;

//import com.imum.ws.Auction.AuctionApprovalBPMProcessPortType;
//import com.imum.ws.Auction.AuctionApprovalBPMProcessService;
import com.imum.ws.pvtwriteoff.PVTWriteoffApprovalBPMPortType;
import com.imum.ws.pvtwriteoff.PVTWriteoffApprovalBPMService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Calendar;


import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.UploadedFile;
import java.util.*;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.model.QueryModel;
import oracle.adf.view.rich.model.QueryDescriptor;

import org.apache.myfaces.trinidad.ADFUtil;


public class PvtWriteOffBean {
    private Row currentAttchmtRow=null;
    private Row currentAttchmtRow1=null;
    private RichTable pvtSearchTableBind;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    DCBindingContainer bindingsAM =
        (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    MessageUtil genMsg = new MessageUtil();
    String lngCode = "";
    private String rootPath = "//cpmsshare";
    private RichTable coderdoc;
    private RichPanelGroupLayout querypanelTableBind;
    private RichPanelGroupLayout pgl2;
    private RichToolbar t1;
    private RichCommandButton submitBtnTop;
    private RichCommandButton cancelBtnTop;
    private RichSpacer s1;
    private RichCommandButton newPvtWriteOff;
    private RichSpacer s2;
    private RichCommandButton viewPvtWriteOff;
    private RichSpacer s4;
    private RichShowDetailHeader sdh1;
    private RichPanelGroupLayout pgl3;
    private RichSpacer spacer3;
    private RichPanelFormLayout pfl1;
    private RichToolbar t4;
    private RichCommandButton submitBtn;
    private RichCommandButton cancelBtn;
    private RichPanelGroupLayout pvtWriteOffDetailsView;
    private RichInputText detailPvtNoBind;
    private RichColumn detailPvtAmtBind;
    private RichColumn detailPvtDocBind;
    private RichColumn detailPvtRemarksBind;
    private RichColumn detailPvtActionBind;
    private RichColumn detailPvtRemoveBind;
    private RichInputText detailReqRemarksBind;
    private RichTable pvtWriteOffDetailsReadonlyBind;
    private RichCommandButton editPvtWriteOffBind;
    private RichCommandButton addSeletedBtn1;
    private RichCommandButton addSeletedBtn2;
    private RichQuery richQuery;
    private UploadedFile myfile;
    private RichInputFile pvtfile;
    private RichCommandLink filePropertyCommandLink;
    private RichCommandButton sendtoDotBind;
    private RichPopup myPopUpBind;
    private RichCommandButton newSubmitAction;
    private RichCommandButton newSubmitBind;
    private RichCommandButton newsubmitbtntop;
    String  userName = httpSession.getAttribute("loggedinUserid").toString();
    private boolean docdownload=true;
    private RichTable onViewActionBind;
    private boolean deleteshow=true;

    public PvtWriteOffBean() {
    }

    public BindingContainer getBindings() {
           return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public void setPvtSearchTableBind(RichTable pvtSearchTableBind) {
        this.pvtSearchTableBind = pvtSearchTableBind;
    }

    public RichTable getPvtSearchTableBind() {
        return pvtSearchTableBind;
    }

    public void selectedRows(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Boolean selectedValue = (Boolean)valueChangeEvent.getNewValue();
        if (selectedValue != null) {
            System.out.println(selectedValue);
            int index = pvtSearchTableBind.getRowIndex();
            FacesCtrlHierBinding listBinding2 =
                (FacesCtrlHierBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PvtSearchWriteOffRVO11");
            ViewObject vo = listBinding2.getViewObject();

            //Setting Current Checkbox value to current row

            PvtSearchWriteOffRVORowImpl rowImpl =
                (PvtSearchWriteOffRVORowImpl)vo.getRowAtRangeIndex(index);
            if (rowImpl != null)
                rowImpl.setSelectFlag(selectedValue);

        }  
}

    public String addSelectedRecordsToTempTable() {
        // Add event code here...
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                String userName =null;
                if (httpSession.getAttribute("loggedinUserid") == null || httpSession.getAttribute("loggedinUserid").equals("")) {                
                    userName = "anonymous";
                } else {
                    userName = httpSession.getAttribute("loggedinUserid").toString();
                }
                
                int count = pvtSearchTableBind.getRowCount();
                System.out.println("count in removeUnselectedRow : "+count);

                if (count > 0) {
                    DCIteratorBinding dcItterator =
                        bindingsAM.findIteratorBinding("PvtSearchWriteOffRVO1Iterator");
                    ViewObjectImpl invDetailVO =
                        (ViewObjectImpl)dcItterator.getViewObject();
                    if (invDetailVO != null) {
                        Row selectionRowN[] =
                            invDetailVO.getFilteredRows("SelectFlag", true);
                        if (selectionRowN.length == 0) {
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                          "Sample info message",
                                                                                          genMsg.getMessage("324",
                                                                                                            lngCode)));
                        } else {

                            Integer selectCountN = selectionRowN.length;
                            //vamsi start
//                           //Creating HeaderRow 
//                    Timestamp sqlDate1 = new java.sql.Timestamp(new java.util.Date().getTime());
                    DCIteratorBinding pvtheader = bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
                    ViewObjectImpl pvtheadervo =(ViewObjectImpl)pvtheader.getViewObject();
//                    Row headerrow = pvtheadervo.createRow();
//                    headerrow.setAttribute("CreatedDate", sqlDate1);
//                    headerrow.setAttribute("CreatedBy", userName);
//                    headerrow.setAttribute("ACTIONEDDate", sqlDate1);
//                    headerrow.setAttribute("ACTIONEDBy", userName);
//                    headerrow.setAttribute("WRITEOFFREQSTATUS", 1);
//                      headerrow.setAttribute("WRITEOFFREQDATE", sqlDate1);
//                    headerrow.setAttribute("PVTCOUNT", selectCountN);
//
//                    pvtheadervo.insertRow(headerrow);
//                    pvtheadervo.setCurrentRow(headerrow);
                           
//                            BindingContainer bindings =getBindings();
//                            OperationBinding opBinding = bindings.getOperationBinding("Commit");
//                            opBinding.execute();
                        
                    for (int i = 0; i < selectCountN; i++) {

                                DCIteratorBinding progIter = bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator");
                                ViewObjectImpl progVO = (ViewObjectImpl)progIter.getViewObject();
                               // checking if pvtnumber is already exist in the progVO or not, if not createRow
//                                String pvtnumber= (String)selectionRowN[i].getAttribute("PVTNum");
//                                System.out.println((String)selectionRowN[i].getAttribute("PVTNum"));
//                                progVO.setWhereClause("pvt_number="+"'"+pvtnumber+"'");
//                                System.out.println(progVO.getQuery());
//                                progVO.executeQuery();
//                                int rowcount=progVO.getRowCount();
//                                if(rowcount==0){
                                            
                                RowSetIterator rs1 = progVO.createRowSetIterator(null);
                                rs1.reset();
                                System.out.println(invDetailVO.getEstimatedRowCount());


                                PVTWRITEOFFDETAILSVORowImpl progVORow = (PVTWRITEOFFDETAILSVORowImpl)progVO.createRow();
                                progVO.insertRow(progVORow);
                                //pvtheadervo.executeQuery();
                                //Row headerRow=pvtheadervo.last();                                
                             //Row headerRow=pvtheadervo.getCurrentRow();
                               // BigDecimal pvtWriteOffHeaderseq = (BigDecimal)rowSelected.getAttribute("WRITEOFFHDRSeq");
                               // BigDecimal newWriteOffHeaderSeq = (BigDecimal) headerRow.getAttribute("WRITEOFFHDRSeq");
                               // BigDecimal newWriteOffHeaderSeq = (BigDecimal)pvtheadervo.first().getAttribute("WRITEOFFHDRSeq");
                                //System.out.println("PvtWriteOff Hearder newWriteOffHeaderSeq ::"+newWriteOffHeaderSeq);
                                Row headerRow=pvtheadervo.last();
                                Integer pvtWriteOffHeaderseq = Integer.parseInt(headerRow.getAttribute("WRITEOFFHDRSeq").toString());
                                Integer newint=pvtWriteOffHeaderseq+1;
                                //BigDecimal newPvtWriteOffHeaderseq=(BigDecimal)(pvtWriteOffHeaderseq+1);
                                progVORow.setAttribute("WRITEOFFHDRSeq",newint);
                                
                                progVORow.setAttribute("CreatedBy", userName);
                                progVORow.setAttribute("CreatedDate", sqlDate);
                                progVORow.setAttribute("Approvedflag","N");
                               
                                BigDecimal pvtHdrSeq = (BigDecimal)selectionRowN[i].getAttribute("PVTHDRSEQ");
                                progVORow.setAttribute("PVTHDRSEQ",pvtHdrSeq);
                        
                                BigDecimal PVTAMTPAYABLE = (BigDecimal)selectionRowN[i].getAttribute("PVTAMTPAYABLE");
                                progVORow.setAttribute("PVTAMTPAYABLE",PVTAMTPAYABLE);   
                                System.out.println((BigDecimal)selectionRowN[i].getAttribute("PVTAMTPAYABLE"));
                               
                                progVORow.setAttribute("ReasonID",1);
                        
                                progVORow.setAttribute("PvtNo",selectionRowN[i].getAttribute("PVTNum").toString());
                                System.out.println(selectionRowN[i].getAttribute("PVTNum"));
                        
                               // progVORow.setpvtnumber(selectionRowN[i].getAttribute("PVTNum").toString());
                                progVORow.getAttribute("pvtnumber");
                               // java.sql.Timestamp d=(java.sql.Timestamp) selectionRowN[i].getAttribute("PVTdatetime");
//                                progVORow.setAttribute("PVTDate",d);
                                System.out.println((java.sql.Timestamp) selectionRowN[i].getAttribute("PVTdatetime"));
                                
                               

                                
                              // }

                            }
                        }
                    }
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("324", lngCode)));                    
                }
                return null; 
                
            }//addSelectedRecordsToTempTable

    public String newAction(Integer noOfPvts) {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        DCIteratorBinding pvtheader = bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
        ViewObjectImpl pvtheadervo =  (ViewObjectImpl)pvtheader.getViewObject();
               Row headerrow=pvtheadervo.createRow();
               headerrow.setAttribute("CreatedDate", sqlDate);
               headerrow.setAttribute("CreatedBy", userName);
             headerrow.setAttribute("ACTIONEDDate", sqlDate);
        headerrow.setAttribute("ACTIONEDBy", userName);
        headerrow.setAttribute("WRITEOFFREQSTATUS", 1);
        headerrow.setAttribute("PVTCOUNT", 0);
        pvtheadervo.insertRow(headerrow); 
        
        
        
        return null;
    }
    
    public void fileuploadVC(ValueChangeEvent vce) {
         String uploadPath = null;
        String fullPath = null;
        String pvtno=null;
        BigDecimal seq=new BigDecimal(0);
       // DCIteratorBinding bind =getBindings().findIteratorBinding("PVTCourtReportUVO2Iterator");     
        RichInputFile inputFileComponent = (RichInputFile)vce.getComponent();
        UploadedFile newFile = (UploadedFile)vce.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());
        
      
        DCIteratorBinding dciterrefundattchmt =bindingsAM.findIteratorBinding("PVTCourtReportDocsUVO1Iterator");
       // currentAttchmtRow = dciterrefundattchmt.getRowAtRangeIndex(getCoderdoc().getRowIndex());
        ViewObject pvtdocsvo=dciterrefundattchmt.getViewObject();
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTWRITEOFFDETAILSVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
           seq =new BigDecimal(selectedRow.getAttribute("PVTHDRSEQ").toString());
            if(selectedRow.getAttribute("PvtNo")!=null)
            pvtno=selectedRow.getAttribute("PvtNo").toString();
        }
        try{
       currentAttchmtRow =pvtdocsvo.createRow();
      //  System.out.println(currentAttchmtRow.getAttribute("CreatedDate"));
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
                //BigDecimal seq=new BigDecimal(0);
                /*start of code to get RelatedTo value */
                /*end of code */
                int docType = getFileExtension(docFielName);
                //String userName = userName;
                
//                DCIteratorBinding pvtdetailrow = bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator");
//                ViewObjectImpl pvtdetailsvo =(ViewObjectImpl)pvtdetailrow.getViewObject();
//               // Row headerRow = pvtheadervo.last();
//                 Row detailrow=pvtdetailsvo.getCurrentRow();
//                Integer pvtWriteOffHeaderseq =Integer.parseInt(detailrow.getAttribute("WRITEOFFHDRSeq").toString());
//                Integer newint = pvtWriteOffHeaderseq + 1;
                
                
                java.sql.Date sqlDate1 =
                    new java.sql.Date(new java.util.Date().getTime());

                currentAttchmtRow.setAttribute("PVTHDRSEQ", seq);
                currentAttchmtRow.setAttribute("CreatedBy", userName);
                currentAttchmtRow.setAttribute("filepath", fullPath);
                currentAttchmtRow.setAttribute("deleteflag", "N");
                currentAttchmtRow.setAttribute("doctype", docType);
                currentAttchmtRow.setAttribute("Docstage", 11);
                currentAttchmtRow.setAttribute("CreatedDate", sqlDate1);
                
                currentAttchmtRow.setAttribute("DOCDesc", docFielName);
                pvtdocsvo.insertRow(currentAttchmtRow);
          
            }
        }
    }
        catch(Exception e){
            DCIteratorBinding dciterrefundattchmt1 =bindingsAM.findIteratorBinding("PVTDocsVO1Iterator");
            ViewObject pvtdocsvo1=dciterrefundattchmt1.getViewObject();
            currentAttchmtRow= pvtdocsvo1.createRow();
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
                     
             //                DCIteratorBinding pvtdetailrow = bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator");
             //                ViewObjectImpl pvtdetailsvo =(ViewObjectImpl)pvtdetailrow.getViewObject();
             //               // Row headerRow = pvtheadervo.last();
             //                 Row detailrow=pvtdetailsvo.getCurrentRow();
             //                Integer pvtWriteOffHeaderseq =Integer.parseInt(detailrow.getAttribute("WRITEOFFHDRSeq").toString());
             //                Integer newint = pvtWriteOffHeaderseq + 1;
                  
                     java.sql.Date sqlDate1 =
                         new java.sql.Date(new java.util.Date().getTime());

                     currentAttchmtRow.setAttribute("PVTHDRSEQ", seq);
                     currentAttchmtRow.setAttribute("CreatedBy", userName);
                     currentAttchmtRow.setAttribute("filepath", fullPath);
                     currentAttchmtRow.setAttribute("deleteflag", "N");
                     currentAttchmtRow.setAttribute("doctype", docType);
                     currentAttchmtRow.setAttribute("Docstage", 11);
                     currentAttchmtRow.setAttribute("CreatedDate", sqlDate1);
                     currentAttchmtRow.setAttribute("DOCDesc", docFielName);
                     pvtdocsvo.insertRow(currentAttchmtRow);
               
                 }
             }
            
        }
       
       
       
       
    }
    public void fileuploadVC1(ValueChangeEvent vce) {
         String uploadPath = null;
        String fullPath = null;
        String pvtno=null;
        BigDecimal seq=new BigDecimal(0);
       // DCIteratorBinding bind =getBindings().findIteratorBinding("PVTCourtReportUVO2Iterator");     
        RichInputFile inputFileComponent = (RichInputFile)vce.getComponent();
        UploadedFile newFile = (UploadedFile)vce.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());
        
      
        DCIteratorBinding dciterrefundattchmt =bindingsAM.findIteratorBinding("PVTCourtReportDocsUVO1Iterator");
       // currentAttchmtRow = dciterrefundattchmt.getRowAtRangeIndex(getPvtWriteOffDetailsReadonlyBind().getRowIndex());
        ViewObject pvtdocsvo=dciterrefundattchmt.getViewObject();
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTWRITEOFFDETAILSVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
           seq =new BigDecimal(selectedRow.getAttribute("PVTHDRSEQ").toString());
            if(selectedRow.getAttribute("PvtNo")!=null)
            pvtno=selectedRow.getAttribute("PvtNo").toString();
        }
        try{
        currentAttchmtRow1 =pvtdocsvo.createRow();
        
      //  System.out.println(currentAttchmtRow.getAttribute("CreatedDate"));
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
                
    //                DCIteratorBinding pvtdetailrow = bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator");
    //                ViewObjectImpl pvtdetailsvo =(ViewObjectImpl)pvtdetailrow.getViewObject();
    //               // Row headerRow = pvtheadervo.last();
    //                 Row detailrow=pvtdetailsvo.getCurrentRow();
    //                Integer pvtWriteOffHeaderseq =Integer.parseInt(detailrow.getAttribute("WRITEOFFHDRSeq").toString());
    //                Integer newint = pvtWriteOffHeaderseq + 1;
                
               
                java.sql.Date sqlDate1 =
                    new java.sql.Date(new java.util.Date().getTime());

                currentAttchmtRow1.setAttribute("PVTHDRSEQ", seq);
                currentAttchmtRow1.setAttribute("CreatedBy", userName);
                currentAttchmtRow1.setAttribute("filepath", fullPath);
                currentAttchmtRow1.setAttribute("deleteflag", "N");
                currentAttchmtRow1.setAttribute("doctype", docType);
                currentAttchmtRow1.setAttribute("Docstage", 11);
                currentAttchmtRow1.setAttribute("CreatedDate", sqlDate1);
                currentAttchmtRow1.setAttribute("DOCDesc", docFielName);
                pvtdocsvo.insertRow(currentAttchmtRow1);
          
            }
        }
        }
        catch(Exception e){
            DCIteratorBinding dciterrefundattchmt1 =bindingsAM.findIteratorBinding("PVTDocsVO1Iterator");
            ViewObject pvtdocsvo1=dciterrefundattchmt1.getViewObject();
           currentAttchmtRow1= pvtdocsvo1.createRow();
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
                    
            //                DCIteratorBinding pvtdetailrow = bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator");
            //                ViewObjectImpl pvtdetailsvo =(ViewObjectImpl)pvtdetailrow.getViewObject();
            //               // Row headerRow = pvtheadervo.last();
            //                 Row detailrow=pvtdetailsvo.getCurrentRow();
            //                Integer pvtWriteOffHeaderseq =Integer.parseInt(detailrow.getAttribute("WRITEOFFHDRSeq").toString());
            //                Integer newint = pvtWriteOffHeaderseq + 1;
                   
                    java.sql.Date sqlDate1 =
                        new java.sql.Date(new java.util.Date().getTime());

                    currentAttchmtRow1.setAttribute("PVTHDRSEQ", seq);
                    currentAttchmtRow1.setAttribute("CreatedBy", userName);
                    currentAttchmtRow1.setAttribute("filepath", fullPath);
                    currentAttchmtRow1.setAttribute("deleteflag", "N");
                    currentAttchmtRow1.setAttribute("doctype", docType);
                    currentAttchmtRow1.setAttribute("Docstage", 11);
                    currentAttchmtRow1.setAttribute("CreatedDate", sqlDate1);
                    currentAttchmtRow1.setAttribute("DOCDesc", docFielName);
                    pvtdocsvo.insertRow(currentAttchmtRow1);
              
                }
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
         // rootPath = "D://FileStore";
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

    public void setCoderdoc(RichTable coderdoc) {
        this.coderdoc = coderdoc;
    }

    public RichTable getCoderdoc() {
        return coderdoc;
    }

    public void setQuerypanelTableBind(RichPanelGroupLayout querypanelTableBind) {
        this.querypanelTableBind = querypanelTableBind;
    }

    public RichPanelGroupLayout getQuerypanelTableBind() {
        return querypanelTableBind;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setSubmitBtnTop(RichCommandButton submitBtnTop) {
        this.submitBtnTop = submitBtnTop;
    }

    public RichCommandButton getSubmitBtnTop() {
        return submitBtnTop;
    }

    public void setCancelBtnTop(RichCommandButton cancelBtnTop) {
        this.cancelBtnTop = cancelBtnTop;
    }

    public RichCommandButton getCancelBtnTop() {
        return cancelBtnTop;
    }

    public String submitAction() {
//        DCIteratorBinding pvtdtl = bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator");
//                            ViewObjectImpl pvtdetailvo =(ViewObjectImpl)pvtdtl.getViewObject();
//                            long count = pvtdetailvo.getEstimatedRowCount();
//        BigDecimal d = BigDecimal.valueOf(count);
//        DCIteratorBinding pvtheader = bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
//                            ViewObject pvtheadervo =pvtheader.getViewObject();
//                            Row headerrow = pvtheadervo.getCurrentRow();
//        headerrow.setAttribute("PVTCOUNT", d);
        System.out.println("Submit Action tiggered");
        long l1;
        String result = "pass";
        BigDecimal pvtWriteOffHeaderseq = (BigDecimal) ADFUtils.getBoundAttributeValue("WRITEOFFHDRSeq");
        Integer pvthdrseq=Integer.parseInt(pvtWriteOffHeaderseq.toString());
        Integer newpvthdrseq=pvthdrseq+1;
        BigDecimal finalpvthdrseq = new BigDecimal(newpvthdrseq.toString());
        System.out.println("on click new button submit:::-->"+finalpvthdrseq);
        BindingContainer bindings =getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doCommit");
        opBinding.execute();
        /*executing WriteOff Details to get no.of records for a particular WriteOffHeaderSeq*/
        DCIteratorBinding progIter = bindingsAM.findIteratorBinding("PvtWiriteOffCount1Iterator");
        ViewObjectImpl progVO = (ViewObjectImpl)progIter.getViewObject();
        progVO.setWhereClause("PVTWRITEOFFDETAILSEO.WRITEOFF_HDR_Seq="+finalpvthdrseq);
        System.out.println(progVO.getQuery());
        progVO.executeQuery();
        Long count=progVO.getEstimatedRowCount();
        BigDecimal d = new BigDecimal(count);
        System.out.println(d);
        /*Updating Count in Header Table*/
        OperationBinding opBinding1 = bindings.getOperationBinding("getPvtCount");
        opBinding1.getParamsMap().put("pvtcount", d);
        opBinding1.getParamsMap().put("hdrseq", finalpvthdrseq);
        opBinding1.execute();  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PvtWriteOff Initiation Successfully", null));         
        result = "success"; 
        
        
        
      
       // logger.info("Start submitAction Method of AutionInitiationBean");
        
       
//        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
       
//        DCIteratorBinding dcItterator =  bindingsAM.findIteratorBinding("PvtSearchWriteOffRVO1Iterator");
//           ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();  
//        
//           if(invDetailVO != null)
//           {
//               Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
//               Integer selectCount = selectionRow.length;
//               if (selectCount > 0) {
//                   BindingContainer bindings = getBindings();
//                   OperationBinding opBinding = bindings.getOperationBinding("savePvtWriteOffDetails");
//                   opBinding.getParamsMap().put("pvtWriteOffInitiationDate", sqlDate);
//                   opBinding.getParamsMap().put("totalNosPVTs",selectCount);
//                   opBinding.getParamsMap().put("status",1);
//                   opBinding.getParamsMap().put("createdBy","Ayyappa");
//                  // opBinding.getParamsMap().put("createdBy",httpSession.getAttribute("loggedinUserid").toString());
//                   String saveHeaderResult = (String)opBinding.execute();
//                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PvtWriteOff Initiation Successfully", null));         
//                    result = "success"; 
                   
                   getSubmitBtn().setVisible(false);
                   getCancelBtn().setVisible(false);
                   
                   getNewPvtWriteOff().setVisible(true);
                   getViewPvtWriteOff().setVisible(true);
                   getEditPvtWriteOffBind().setVisible(true);
                   getPgl3().setVisible(true);
                   getQuerypanelTableBind().setVisible(false);
                   getPvtWriteOffDetailsView().setVisible(false);
                   
                   getSubmitBtnTop().setVisible(false);
                   getCancelBtnTop().setVisible(false);
                   //code to send the Header seq to BPM service
//                   DCIteratorBinding dcItterator1=bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
//                   ViewObjectImpl pvtWriteOffHeaderVO = (ViewObjectImpl)dcItterator1.getViewObject();
//                   pvtWriteOffHeaderVO.executeQuery();  
//                   Row r=pvtWriteOffHeaderVO.first();
//                   if(r!=null) {
//                       BigDecimal pvtWriteOffHeaderseq =(BigDecimal)r.getAttribute("WRITEOFFHDRSeq");
//                 
//                     //  l1=pvtWriteOffHeaderseq.longValue();
//                       //passing pvtWriteOff Header Sequence to BPM Service
////                       auctionApprovalBPMProcessService = new AuctionApprovalBPMProcessService();
////                       AuctionApprovalBPMProcessPortType auctionApprovalBPMProcessPortType =auctionApprovalBPMProcessService.getAuctionApprovalBPMProcessPort();
////                       auctionApprovalBPMProcessPortType.start(l1);
//                   }
                   
//                   
//               } else {
//                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Select atleast one PVT to Processed", null));         
//                    result = "fail"; 
//                    
//               }
//              
//           }
        
      
        return result;
    }

    public String cancelAction() {
        
        System.out.println("Cancel Pvt WriteOff");
        bindingsAM.findIteratorBinding("PvtSearchWriteOffRVO1Iterator").getViewObject().executeEmptyRowSet();
        DCIteratorBinding dcItterator1=bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
         ViewObjectImpl pvtWriteOffHeaderVO = (ViewObjectImpl)dcItterator1.getViewObject();
          pvtWriteOffHeaderVO.executeQuery();
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doRollback");
        opBinding.execute();
        
        getSubmitBtn().setVisible(false);
        getCancelBtn().setVisible(false);
        
        getNewPvtWriteOff().setVisible(true);
        getViewPvtWriteOff().setVisible(true);
        getEditPvtWriteOffBind().setVisible(true);
        getSubmitBtnTop().setVisible(false);
        getCancelBtnTop().setVisible(false);
        
        getPgl3().setVisible(true);
        getQuerypanelTableBind().setVisible(false);
        getPvtWriteOffDetailsView().setVisible(false);
        getNewSubmitBind().setVisible(false);
        getNewsubmitbtntop().setVisible(false);
        getSendtoDotBind().setVisible(false);
        
        return null;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setNewPvtWriteOff(RichCommandButton newPvtWriteOff) {
        this.newPvtWriteOff = newPvtWriteOff;
    }

    public RichCommandButton getNewPvtWriteOff() {
        return newPvtWriteOff;
    }

    public String newPvtWriteOff() {
        
        System.out.println("New Pvt WriteOff");
        bindingsAM.findIteratorBinding("PvtSearchWriteOffRVO1Iterator").getViewObject().executeEmptyRowSet();
        bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator").getViewObject().executeEmptyRowSet();
       
        //Creating Header Row
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        DCIteratorBinding pvtheader =
            bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
        ViewObjectImpl pvtheadervo = (ViewObjectImpl)pvtheader.getViewObject();
        Row headerrow = pvtheadervo.createRow();
        headerrow.setAttribute("CreatedDate", sqlDate);
        headerrow.setAttribute("CreatedBy", "cpms");
        headerrow.setAttribute("ACTIONEDDate", sqlDate);
        headerrow.setAttribute("ACTIONEDBy", "cpms");
        headerrow.setAttribute("WRITEOFFREQSTATUS", 1);
        headerrow.setAttribute("WRITEOFFREQDATE",sqlDate);
        headerrow.setAttribute("PVTCOUNT", 0);
        pvtheadervo.insertRow(headerrow);


        getSubmitBtn().setVisible(true);
        getCancelBtn().setVisible(true);
        
        getNewPvtWriteOff().setVisible(false);
        getViewPvtWriteOff().setVisible(false);
        getEditPvtWriteOffBind().setVisible(false);
        getSubmitBtnTop().setVisible(true);
        getCancelBtnTop().setVisible(true);
        
        getPgl3().setVisible(true);
        getQuerypanelTableBind().setVisible(true);
        getPvtWriteOffDetailsView().setVisible(true);
      
        
        getCoderdoc().setVisible(true);
        getPvtWriteOffDetailsReadonlyBind().setVisible(false);
        getAddSeletedBtn1().setVisible(true); 
        getAddSeletedBtn2().setVisible(false);
        getSendtoDotBind().setVisible(false);
        getNewSubmitBind().setVisible(false);
        
        return null;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setViewPvtWriteOff(RichCommandButton viewPvtWriteOff) {
        this.viewPvtWriteOff = viewPvtWriteOff;
    }

    public RichCommandButton getViewPvtWriteOff() {
        return viewPvtWriteOff;
    }

    public String viewPvtWriteOff() {
        
        
        System.out.println("View PvtWriteOff triggered");
        
        
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
         ViewObject pvtWriteOffHeaderVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = pvtWriteOffHeaderVO.getCurrentRow();
        
        if(rowSelected != null){
            BigDecimal pvtWriteOffHeaderseq = (BigDecimal)rowSelected.getAttribute("WRITEOFFHDRSeq");
          Integer reqstatus= (Integer)rowSelected.getAttribute("WRITEOFFREQSTATUS");
          
            
            if(pvtWriteOffHeaderseq!=null && !"".equals(pvtWriteOffHeaderseq))
            {
                OperationBinding operationBinding = bindings.getOperationBinding("getPvtWriteOffDetails");
                operationBinding.getParamsMap().put("pvtWriteOffHeaderseq", pvtWriteOffHeaderseq);
                String selectedGroupNamePiid = (String)operationBinding.execute();
                //selectedAuctionBatchID.setValue(auctionHeaderseq);

                getPgl3().setVisible(false);
                getQuerypanelTableBind().setVisible(false);
                getPvtWriteOffDetailsView().setVisible(true);
        
               // getDetailPvtNoBind().setReadOnly(true);
               
               
                getSubmitBtn().setVisible(false);
                getCancelBtn().setVisible(true);
                getNewPvtWriteOff().setVisible(false);
                getViewPvtWriteOff().setVisible(false);
                getEditPvtWriteOffBind().setVisible(false);
                getSubmitBtnTop().setVisible(false);
                getCancelBtnTop().setVisible(true);
               
                getCoderdoc().setVisible(false);
                getPvtWriteOffDetailsReadonlyBind().setVisible(true);
                getAddSeletedBtn2().setVisible(false);
                getAddSeletedBtn1().setVisible(false);
                this.docdownload=false;
                this.deleteshow=false;
             
                
            }
            
            else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Please Select PvtWriteOff to Show Details",null));
                   
            }
            if(reqstatus==1){
                getSendtoDotBind().setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSendtoDotBind());
                  }
            else{
                
                RichPopup.PopupHints ph=new RichPopup.PopupHints();
                  this.getMyPopUpBind().show(ph);
                  
                  getSubmitBtn().setVisible(false);
                  getCancelBtn().setVisible(false);
                  getSubmitBtnTop().setVisible(false);
                  getCancelBtnTop().setVisible(false);
                  
                  getNewPvtWriteOff().setVisible(true);
                  getViewPvtWriteOff().setVisible(true);
                  getEditPvtWriteOffBind().setVisible(true);
                  getPgl3().setVisible(true);
                  getQuerypanelTableBind().setVisible(false);
                  getPvtWriteOffDetailsView().setVisible(false);
                  getSendtoDotBind().setVisible(false);
                getNewSubmitBind().setVisible(false);
                getNewsubmitbtntop().setVisible(false);
                
            }
            
            
             
            
            
        }else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select PvtWriteOff to Show Details",null));
         
        }
       
        
        
        return null;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setSdh1(RichShowDetailHeader sdh1) {
        this.sdh1 = sdh1;
    }

    public RichShowDetailHeader getSdh1() {
        return sdh1;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setSpacer3(RichSpacer spacer3) {
        this.spacer3 = spacer3;
    }

    public RichSpacer getSpacer3() {
        return spacer3;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setT4(RichToolbar t4) {
        this.t4 = t4;
    }

    public RichToolbar getT4() {
        return t4;
    }

    public void setSubmitBtn(RichCommandButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public RichCommandButton getSubmitBtn() {
        return submitBtn;
    }

    public void setCancelBtn(RichCommandButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public RichCommandButton getCancelBtn() {
        return cancelBtn;
    }

    public void setPvtWriteOffDetailsView(RichPanelGroupLayout pvtWriteOffDetailsView) {
        this.pvtWriteOffDetailsView = pvtWriteOffDetailsView;
    }

    public RichPanelGroupLayout getPvtWriteOffDetailsView() {
        return pvtWriteOffDetailsView;
    }

    public void setDetailPvtNoBind(RichInputText detailPvtNoBind) {
        this.detailPvtNoBind = detailPvtNoBind;
    }
    
    public RichInputText getDetailPvtNoBind() {
        return detailPvtNoBind;
    }


    public void setDetailReqRemarksBind(RichInputText detailReqRemarksBind) {
        this.detailReqRemarksBind = detailReqRemarksBind;
    }

    public RichInputText getDetailReqRemarksBind() {
        return detailReqRemarksBind;
    }


    public void setPvtWriteOffDetailsReadonlyBind(RichTable pvtWriteOffDetailsReadonlyBind) {
        this.pvtWriteOffDetailsReadonlyBind = pvtWriteOffDetailsReadonlyBind;
    }

    public RichTable getPvtWriteOffDetailsReadonlyBind() {
        return pvtWriteOffDetailsReadonlyBind;
    }

    public String onEditAction() {
     
        System.out.println("Edit PvtWriteOff triggered");
        /* to clear search results*/
        RichQuery queryComp = getRichQuery();  
             QueryModel queryModel = queryComp.getModel();  
             QueryDescriptor queryDescriptor = queryComp.getValue();  
             queryModel.reset(queryDescriptor);  
             queryComp.refresh(FacesContext.getCurrentInstance()); 
      /* to clear query result*/
      bindingsAM.findIteratorBinding("PvtSearchWriteOffRVO1Iterator").getViewObject().executeEmptyRowSet();
             
        BigDecimal seq=new BigDecimal(0);
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTWRITEOFFDETAILSVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
           seq =new BigDecimal(selectedRow.getAttribute("PVTHDRSEQ").toString());
        }
//        doctab vo
//            while loop details table
//        DCIteratorBinding dcItteratorBindings1 = bindingsAM.findIteratorBinding("PVTDocsVO1Iterator");
//         ViewObject pvtdocVO = (ViewObject)dcItteratorBindings1.getViewObject();  
//         
//         while(detailvo.hasNext()) {
//             
//         }
//         pvtdocVO.setWhereClause("PVTHDRSEQ="+pvtWriteOffHeaderseq);
//        //PVTDocsVORowImpl row=(PVTDocsVORowImpl) pvtdocVO.getCurrentRow();
//        while(pvtdocVO.hasNext()){
//          PVTDocsVORowImpl row=(PVTDocsVORowImpl)pvtdocVO.next();
//        CustomUploadedFile cf1 = new CustomUploadedFile();
//        cf1.setFilename(row.getfilepath());
//        setMyfile(cf1);
//        }
             
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PVTWRITEOFFHEADERVO1Iterator");
         ViewObject pvtWriteOffHeaderVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = pvtWriteOffHeaderVO.getCurrentRow();
        pvtWriteOffHeaderVO.setCurrentRow(rowSelected);
        if(rowSelected != null){
            BigDecimal pvtWriteOffHeaderseq = (BigDecimal)rowSelected.getAttribute("WRITEOFFHDRSeq");
            Integer reqstatus= (Integer)rowSelected.getAttribute("WRITEOFFREQSTATUS");
//            DCIteratorBinding dcItteratorBindings1 = bindingsAM.findIteratorBinding("PVTDocsVO1Iterator");
//             ViewObject pvtdocVO = (ViewObject)dcItteratorBindings1.getViewObject();  
//             pvtdocVO.setWhereClause("PVTDocsEO.PVT_HDR_SEQ="+pvtWriteOffHeaderseq);
//             pvtdocVO.executeQuery();
//             int doccount=pvtdocVO.getRowCount();
//             System.out.println(doccount);
//             System.out.println(pvtdocVO.getQuery());
//            //PVTDocsVORowImpl row=(PVTDocsVORowImpl) pvtdocVO.getCurrentRow();
//            while(pvtdocVO.hasNext()){
//              PVTDocsVORowImpl row=(PVTDocsVORowImpl)pvtdocVO.next();
//            CustomUploadedFile cf1 = new CustomUploadedFile();
//            cf1.setFilename(row.getfilepath());
//            setMyfile(cf1);
            //}




/*  */
//            ADFContext adfCtx = ADFContext.getCurrent();
//            Map pageFlowScope = adfCtx.getPageFlowScope();
//            pageFlowScope.put("pvtheaderseq", pvtWriteOffHeaderseq);
            
            if(pvtWriteOffHeaderseq!=null && !"".equals(pvtWriteOffHeaderseq))
            {
                OperationBinding operationBinding = bindings.getOperationBinding("getPvtWriteOffDetails");
                operationBinding.getParamsMap().put("pvtWriteOffHeaderseq", pvtWriteOffHeaderseq);
                String selectedGroupNamePiid = (String)operationBinding.execute();
                //selectedAuctionBatchID.setValue(auctionHeaderseq);

                getPgl3().setVisible(false);
                getQuerypanelTableBind().setVisible(true);
                getPvtWriteOffDetailsView().setVisible(true);
        
               
               
               
                getSubmitBtn().setVisible(false);
                getCancelBtn().setVisible(true);
                getNewPvtWriteOff().setVisible(false);
                getViewPvtWriteOff().setVisible(false);
                getEditPvtWriteOffBind().setVisible(false);
                getSubmitBtnTop().setVisible(false);
                getCancelBtnTop().setVisible(true);
                getNewsubmitbtntop().setVisible(true);
                this.docdownload=true;
                this.deleteshow=true;
              
                
               
                getCoderdoc().setVisible(false);
                getPvtWriteOffDetailsReadonlyBind().setVisible(true);
                getAddSeletedBtn2().setVisible(true);
                getAddSeletedBtn1().setVisible(false);
                getSendtoDotBind().setVisible(false);
                getNewSubmitBind().setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getNewSubmitBind());
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Please Select PvtWriteOff to Show Details",null));
                   
            }
            if(reqstatus==2 ||reqstatus==3){
                                  RichPopup.PopupHints ph=new RichPopup.PopupHints();
                                    this.getMyPopUpBind().show(ph);
                                    
                                    getSubmitBtn().setVisible(false);
                                    getCancelBtn().setVisible(false);
                                    getSubmitBtnTop().setVisible(false);
                                    getCancelBtnTop().setVisible(false);
                                    
                                    getNewPvtWriteOff().setVisible(true);
                                    getViewPvtWriteOff().setVisible(true);
                                    getEditPvtWriteOffBind().setVisible(true);
                                    getPgl3().setVisible(true);
                                    getQuerypanelTableBind().setVisible(false);
                                    getPvtWriteOffDetailsView().setVisible(false);
                                    getSendtoDotBind().setVisible(false);
                                  getNewSubmitBind().setVisible(false);
                                  getNewsubmitbtntop().setVisible(false);
                                 
                              }
                        
        }else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select PvtWriteOff to Show Details",null));
         
        }
     
        return null;
    }
    
    public String addSelectedRecordsToTempTableNew() {
        System.out.println("new addSeleted trigerred");
        System.out.println("selected HdrSeq from header table is:"+ADFUtils.getBoundAttributeValue("WRITEOFFHDRSeq")); 
        BigDecimal pvtWriteOffHeaderseq = (BigDecimal) ADFUtils.getBoundAttributeValue("WRITEOFFHDRSeq");//attribute binding done in pageDef
        BigDecimal pvtCount = (BigDecimal)  ADFUtils.getBoundAttributeValue("PVTCOUNT");
        
        System.out.println("pvt count in the header table is:"+ADFUtils.getBoundAttributeValue("PVTCOUNT"));
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        int count = pvtSearchTableBind.getRowCount();
        System.out.println("count in removeUnselectedRow : "+count);

        if (count > 0) {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("PvtSearchWriteOffRVO1Iterator");
            ViewObjectImpl invDetailVO =
                (ViewObjectImpl)dcItterator.getViewObject();
            if (invDetailVO != null) {
                Row selectionRowN[] =
                    invDetailVO.getFilteredRows("SelectFlag", true);
                if (selectionRowN.length == 0) {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("324",
                                                                                                    lngCode)));
                } else {

                    int selectCountN = selectionRowN.length;
                    java.math.BigDecimal newpvtcount = new java.math.BigDecimal(String.valueOf(selectCountN));
                    //BigDecimal newpvtcount = new BigDecimal(selectCountN.toString());
//                    BigDecimal totalpvtcount=newpvtcount.add(pvtCount);
//                    ADFContext adfCtx = ADFContext.getCurrent();
//                    Map pageFlowScope = adfCtx.getPageFlowScope();
//                    pageFlowScope.put("pvtcount", totalpvtcount);
//                    System.out.println(pageFlowScope.get("pvtcount"));
//                    
//                    
//                    System.out.println("total pvts count is:"+ totalpvtcount);
//                    BindingContainer bindings =getBindings();
//                    OperationBinding opBinding = bindings.getOperationBinding("getPvtCount");
//                    opBinding.getParamsMap().put("pvtcount", totalpvtcount);
//                    opBinding.getParamsMap().put("hdrseq", pvtWriteOffHeaderseq);
//                    opBinding.execute();       
        
            for (int i = 0; i < selectCountN; i++) {

                        DCIteratorBinding progIter = bindingsAM.findIteratorBinding("PVTWRITEOFFDETAILSVO1Iterator");
                        ViewObjectImpl progVO = (ViewObjectImpl)progIter.getViewObject();
                       // checking if pvtnumber is already exist in the progVO or not, if not createRow
//                        String pvtnumber= (String)selectionRowN[i].getAttribute("PVTNum");
//                        System.out.println((String)selectionRowN[i].getAttribute("PVTNum"));
//                        progVO.setWhereClause("pvt_number="+"'"+pvtnumber+"'");
//                        System.out.println(progVO.getQuery());
//                        progVO.executeQuery();
//                        int rowcount=progVO.getRowCount();
//                        if(rowcount==0){
                                    
                        RowSetIterator rs1 = progVO.createRowSetIterator(null);
                        rs1.reset();
                        System.out.println(invDetailVO.getEstimatedRowCount());


                        Row progVORow = progVO.createRow();
                       
                       
                        progVORow.setAttribute("WRITEOFFHDRSeq",pvtWriteOffHeaderseq);
                        
                        progVORow.setAttribute("CreatedBy", userName);
                        progVORow.setAttribute("CreatedDate", sqlDate);
                        progVORow.setAttribute("Approvedflag","N");
                       
                        BigDecimal pvtHdrSeq = (BigDecimal)selectionRowN[i].getAttribute("PVTHDRSEQ");
                        progVORow.setAttribute("PVTHDRSEQ",pvtHdrSeq);
                
                        BigDecimal PVTAMTPAYABLE = (BigDecimal)selectionRowN[i].getAttribute("PVTAMTPAYABLE");
                        progVORow.setAttribute("PVTAMTPAYABLE",PVTAMTPAYABLE);   
                        System.out.println((BigDecimal)selectionRowN[i].getAttribute("PVTAMTPAYABLE"));
                       
                        progVORow.setAttribute("ReasonID",1);
                
                        progVORow.setAttribute("PvtNo",selectionRowN[i].getAttribute("PVTNum").toString());
                        System.out.println(selectionRowN[i].getAttribute("PVTNum"));
                
                        progVORow.setAttribute("pvtnumber",selectionRowN[i].getAttribute("PVTNum").toString());
                        progVORow.getAttribute("pvtnumber");
                        
                       // java.sql.Timestamp d=(java.sql.Timestamp) selectionRowN[i].getAttribute("PVTdatetime");
        //                                progVORow.setAttribute("PVTDate",d);
                        System.out.println((java.sql.Timestamp) selectionRowN[i].getAttribute("PVTdatetime"));
                        
                       

                        progVO.insertRow(progVORow);
                      // }
//                        else{
//                            System.out.println("The Pvt Number is already selected for WriteOff. Please choose different one's");
//                        }

                    }
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("324", lngCode)));                    
        }      
        
        return null;
    }    
    
    public String onSendtoDotAction() {
        BigDecimal seq=new BigDecimal(0);
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTWRITEOFFHEADERVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
           seq =new BigDecimal(selectedRow.getAttribute("WRITEOFFHDRSeq").toString());
          Integer reqstatus=(Integer) selectedRow.getAttribute("WRITEOFFREQSTATUS");
        }
        
        
        
        
        BigDecimal pvtWriteOffHeaderseq = (BigDecimal) ADFUtils.getBoundAttributeValue("WRITEOFFHDRSeq");
       int pvtwriteoffhdseq= pvtWriteOffHeaderseq.intValue();
        Integer reqstatus=(Integer)ADFUtils.getBoundAttributeValue("WRITEOFFREQSTATUS"); 
        if(reqstatus==1){
            long l1;
            BindingContainer bindings =getBindings();
            OperationBinding opBinding = bindings.getOperationBinding("updatePvtWriteOff");
            opBinding.getParamsMap().put("reqstatus", reqstatus);
            opBinding.getParamsMap().put("pvtWriteOffHeaderseq", pvtwriteoffhdseq);
            opBinding.getParamsMap().put("username",userName);
            opBinding.execute();
            
            //passing pvtWriteOff Header Sequence to BPM Service
              l1=pvtWriteOffHeaderseq.longValue();
              PVTWriteoffApprovalBPMService  pvtWriteOffApprovalBPMProcessService = new PVTWriteoffApprovalBPMService();
              PVTWriteoffApprovalBPMPortType pvtWriteOffApprovalBPMProcessPortType =pvtWriteOffApprovalBPMProcessService.getPVTWriteoffApprovalBPMPort();
              pvtWriteOffApprovalBPMProcessPortType.start(l1);
            
            selectedRow.setAttribute("WRITEOFFREQSTATUS", 2);  
            OperationBinding opBinding1 = bindings.getOperationBinding("Commit");
            opBinding1.execute();
            
            getSubmitBtn().setVisible(false);
            getCancelBtn().setVisible(false);
            getSubmitBtnTop().setVisible(false);
            getCancelBtnTop().setVisible(false);
            
            
            getNewPvtWriteOff().setVisible(true);
            getViewPvtWriteOff().setVisible(true);
            getEditPvtWriteOffBind().setVisible(true);
            getPgl3().setVisible(true);
            getQuerypanelTableBind().setVisible(false);
            getPvtWriteOffDetailsView().setVisible(false);
            getSendtoDotBind().setVisible(false);
            getNewsubmitbtntop().setVisible(false);
            getNewSubmitBind().setVisible(false);
        }
        else{
//          RichPopup.PopupHints ph=new RichPopup.PopupHints();
//            this.getMyPopUpBind().show(ph);
//            
//            getSubmitBtn().setVisible(false);
//            getCancelBtn().setVisible(false);
//            
//            getNewPvtWriteOff().setVisible(true);
//            getViewPvtWriteOff().setVisible(true);
//            getEditPvtWriteOffBind().setVisible(true);
//            getPgl3().setVisible(true);
//            getQuerypanelTableBind().setVisible(false);
//            getPvtWriteOffDetailsView().setVisible(false);
//            getSendtoDotBind().setVisible(false);
           
        }
        return null;
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


    public void setEditPvtWriteOffBind(RichCommandButton editPvtWriteOffBind) {
        this.editPvtWriteOffBind = editPvtWriteOffBind;
    }

    public RichCommandButton getEditPvtWriteOffBind() {
        return editPvtWriteOffBind;
    }

    public void setAddSeletedBtn1(RichCommandButton addSeletedBtn1) {
        this.addSeletedBtn1 = addSeletedBtn1;
    }

    public RichCommandButton getAddSeletedBtn1() {
        return addSeletedBtn1;
    }

    public void setAddSeletedBtn2(RichCommandButton addSeletedBtn2) {
        this.addSeletedBtn2 = addSeletedBtn2;
    }

    public RichCommandButton getAddSeletedBtn2() {
        return addSeletedBtn2;
    }


    public void setRichQuery(RichQuery richQuery) {
        this.richQuery = richQuery;
    }

    public RichQuery getRichQuery() {
        return richQuery;
    }

    public void setMyfile(UploadedFile myfile) {
        this.myfile = myfile;
    }

    public UploadedFile getMyfile() {
        return myfile;
    }

    public void setPvtfile(RichInputFile pvtfile) {
        this.pvtfile = pvtfile;
    }

    public RichInputFile getPvtfile() {
        return pvtfile;
    }

    public void setFilePropertyCommandLink(RichCommandLink filePropertyCommandLink) {
        this.filePropertyCommandLink = filePropertyCommandLink;
    }

    public RichCommandLink getFilePropertyCommandLink() {
        return filePropertyCommandLink;
    }

    public void setSendtoDotBind(RichCommandButton sendtoDotBind) {
        this.sendtoDotBind = sendtoDotBind;
    }

    public RichCommandButton getSendtoDotBind() {
        return sendtoDotBind;
    }

   

    public void setMyPopUpBind(RichPopup myPopUpBind) {
        this.myPopUpBind = myPopUpBind;
    }

    public RichPopup getMyPopUpBind() {
        return myPopUpBind;
    }

    public void setNewSubmitAction(RichCommandButton newSubmitAction) {
        this.newSubmitAction = newSubmitAction;
    }

    public RichCommandButton getNewSubmitAction() {
        return newSubmitAction;
    }

    public void setNewSubmitBind(RichCommandButton newSubmitBind) {
        this.newSubmitBind = newSubmitBind;
    }

    public RichCommandButton getNewSubmitBind() {
        return newSubmitBind;
    }

    public String newSubmitAction() {
        System.out.println("new Submit triggered");
        BigDecimal pvtWriteOffHeaderseq = (BigDecimal) ADFUtils.getBoundAttributeValue("WRITEOFFHDRSeq");//attribute binding done in pageDef
//        ADFContext adfCtx = ADFContext.getCurrent();
//        Map pageFlowScope = adfCtx.getPageFlowScope();
//        BigDecimal pvtcount=(BigDecimal)pageFlowScope.get("pvtcount");
//        System.out.println(pageFlowScope.get("pvtcount"));
        
        /*Commiting the added records from Pvt_header to WriteOffDetails with WriteOffHeaderSeq*/
        BindingContainer bindings =getBindings();
        OperationBinding opBinding1 = bindings.getOperationBinding("Commit");
        opBinding1.execute();
        /*executing WriteOff Details to get no.of records for a particular WriteOffHeaderSeq*/
        DCIteratorBinding progIter = bindingsAM.findIteratorBinding("PvtWiriteOffCount1Iterator");
        ViewObjectImpl progVO = (ViewObjectImpl)progIter.getViewObject();
        progVO.setWhereClause("PVTWRITEOFFDETAILSEO.WRITEOFF_HDR_Seq="+pvtWriteOffHeaderseq);
        System.out.println(progVO.getQuery());
        progVO.executeQuery();
        Long count=progVO.getEstimatedRowCount();
        BigDecimal d = new BigDecimal(count);
        System.out.println(d);
        /*Updating Count in Header Table*/
        OperationBinding opBinding = bindings.getOperationBinding("getPvtCount");
        opBinding.getParamsMap().put("pvtcount", d);
        opBinding.getParamsMap().put("hdrseq", pvtWriteOffHeaderseq);
        opBinding.execute();    
        
        getSubmitBtn().setVisible(false);
        getCancelBtn().setVisible(false);
        
        getNewPvtWriteOff().setVisible(true);
        getViewPvtWriteOff().setVisible(true);
        getEditPvtWriteOffBind().setVisible(true);
        getPgl3().setVisible(true);
        getQuerypanelTableBind().setVisible(false);
        getPvtWriteOffDetailsView().setVisible(false);
        
        getSubmitBtnTop().setVisible(false);
        getCancelBtnTop().setVisible(false);
        getNewsubmitbtntop().setVisible(false);
        getNewSubmitBind().setVisible(false);
        return null;
    }

    public void setNewsubmitbtntop(RichCommandButton newsubmitbtntop) {
        this.newsubmitbtntop = newsubmitbtntop;
    }

    public RichCommandButton getNewsubmitbtntop() {
        return newsubmitbtntop;
    }

    public void setDocdownload(boolean docdownload) {
        this.docdownload = docdownload;
    }

    public boolean isDocdownload() {
        return docdownload;
    }

    public void setDeleteshow(boolean deleteshow) {
        this.deleteshow = deleteshow;
    }

    public boolean isDeleteshow() {
        return deleteshow;
    }
}
