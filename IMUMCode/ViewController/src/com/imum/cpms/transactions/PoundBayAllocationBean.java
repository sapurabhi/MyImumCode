package com.imum.cpms.transactions;

import com.imum.cpms.model.masters.vo.PoundLocationLVORowImpl;
import com.imum.cpms.model.masters.vo.RemovalTruckMstVORowImpl;
import com.imum.cpms.model.transactions.am.TransactionsAMImpl;
import com.imum.cpms.model.transactions.vo.ClampingUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTDocsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVORowImpl;

import com.imum.cpms.model.transactions.vo.PvtEnforceVehicleAssignRVOImpl;

import com.imum.cpms.model.transactions.vo.PvtEnforceVehicleAssignRVORowImpl;

import java.io.File;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;

import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;


import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import javax.servlet.http.HttpSession;

import oracle.adf.model.AttributeBinding;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

import com.imum.cpms.util.FileUpload;

import com.imum.cpms.util.MessageUtil;

import javax.faces.application.FacesMessage;


import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class PoundBayAllocationBean {
    private RichInputFile attachPhoto;
    private RichInputFile attachDoc;
    private String pvtNumber;
    private BigDecimal bayDetailSeq;
    private String fileName;
    private int extensionType;
    public static final ADFLogger logger = ADFLogger.createADFLogger(PoundBayAllocationBean.class);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    List<UploadedFile> uploadedFiles;
    private RichSelectOneChoice poundLocSelect;
    private RichInputText pvTNumber;
    private Boolean required = true;
    private RichSelectOneChoice bayLocSelect;
    private RichTable docTable;
    private Row currentAttchmtRow=null;
    private BigDecimal pvtHdrSeqUpload;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private BigDecimal pvtHdrSeqPound;
    private BigDecimal vehicleId;
    private Integer poundId;
    private String poundLocDesc;
 
  

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public PoundBayAllocationBean() {
        if(lngCode==null || lngCode.equals(""))
               {
                   lngCode = "EN";
               }
    }

    public void setAttachPhoto(RichInputFile attachPhoto) {
        this.attachPhoto = attachPhoto;
    }

    public RichInputFile getAttachPhoto() {
        return attachPhoto;
    }

    public void setAttachDoc(RichInputFile attachDoc) {
        this.attachDoc = attachDoc;
    }

    public RichInputFile getAttachDoc() {
        return attachDoc;
    }

//    public  ArrayList uploadBayAllocPhotosDocs() {
//        FileUpload fl = new FileUpload();
//        String uploadPath = null;
//       List<UploadedFile> uploadPhotos = this.getUploadedFiles();
//        uploadPath = fl.uploadFilesToFolder("1", "PVT", getPvtNumber(), uploadPhotos);
//          ArrayList  fileUploadList =  new ArrayList();
//        
//          if (null != uploadPhotos) {         
//            for (int i = 0; i < uploadPhotos.size(); i++) {
//                logger.info("Photo FileName  ::     " + uploadPhotos.get(i).getFilename());
//                if(uploadPath!=null){
//                    //String concat = uploadPath.concat(uploadPhotos.get(i).getFilename());
//                    String fullPath = uploadPath+"//"+uploadPhotos.get(i).getFilename();
//                    logger.info("fullPath  ::    " + fullPath);
//                    fileUploadList.add(fullPath);
//                }else{
//                    fileUploadList.add(uploadPhotos.get(i).getFilename()); 
//                }
//                
//            }
//        }
//        return fileUploadList;      
//    }
    
    public String submitBayChanges(ActionEvent actionEvent) {
                String errorCheck="false";
                BigDecimal pvtHdrSeq=null;            
                String pvtNo=getPvtNumber();
                DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
                DCIteratorBinding binding = bindingsAM.findIteratorBinding("PoundBayDetailVO1Iterator");
                Row row = binding.getViewObject().getCurrentRow();
                if(row != null)
                {
                    Integer locID = (Integer)row.getAttribute("PoundBayLocation");
                    
                     if(locID == null){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("97", lngCode)));
                        errorCheck = "true";
                        return errorCheck;
                     }else{
                         if(getPoundId()!=null && !locID.equals(getPoundId())){
                             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("304", lngCode)+"'"+getPoundLocDesc()+"'"));
                             errorCheck = "true";
                             return errorCheck;
                         }
                     }
                    
                    
                        if(getBayDetailSeq()==null){
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("98", lngCode))); 
                            errorCheck = "true";
                            return errorCheck;
                        }
                        if(pvtNo==null){
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("99", lngCode))); 
                            errorCheck = "true";
                            return errorCheck;
                        }
                        
                       //sqatrt 
                       DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                       DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("PVTDocsVO1Iterator");
                       ViewObject pvtDocsImpl =dcIteratorBinding.getViewObject();
                      // ClampingUVORowImpl pvtDocsImpl = (ClampingUVORowImpl)VO.getCurrentRow();                        
                      RowSetIterator iterator = pvtDocsImpl.createRowSetIterator(null);    
                      iterator.reset();
            while (iterator.hasNext()) {
                Row docRow = iterator.next();

                UploadedFile uploadFile =
                    (UploadedFile)docRow.getAttribute("FileUpload");
                String docsDesc = (String)docRow.getAttribute("DOCDesc");
                String docMflag = (String)docRow.getAttribute("FlageM");
                if (uploadFile == null) {
                    if (docMflag.equals("Y")) {
                        errorCheck = "true";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please upload mandatary PVT Documents "));       
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                    "Sample info message",
//                                    genMsg.getMessage("100", lngCode)));
                        return errorCheck;
                    }
                   
                }
                if (docsDesc == null) {
                    errorCheck = "true";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Sample info message",
                                genMsg.getMessage("101", lngCode)));
                    return errorCheck;
                }
            }
            
          //remove rows 
          DCIteratorBinding dcIteratorBinding1= bindings1.findIteratorBinding("PVTDocsVO1Iterator");
          ViewObject pvtDocsImpl1 =dcIteratorBinding1.getViewObject();
          RowSetIterator iterator1 = pvtDocsImpl1.createRowSetIterator(null);
          iterator1.reset();
          while (iterator1.hasNext()) {
          Row docRow1= iterator1.next();

          UploadedFile uploadFile =
          (UploadedFile)docRow1.getAttribute("FileUpload");
          String docsDesc = (String)docRow1.getAttribute("DOCDesc");
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
            
            
           
            //    PVTDocsVOImpl pvtDocsImpl = (PVTDocsVOImpl)getTRansactionModule().getPVTDocsVO1();
//                      if(pvtDocsImpl!=null) {
//                        int docsCount =  pvtDocsImpl.getRowCount();
//                        for(int i=0;i<docsCount; i++) {
//                            
//                           Row docRow = pvtDocsImpl.getRowAtRangeIndex(i);
//                            org.apache.myfaces.trinidad.model.UploadedFile uploadFile = (org.apache.myfaces.trinidad.model.UploadedFile)docRow.getAttribute("FileUpload");
//                              String docsDesc = (String)docRow.getAttribute("DOCDesc");
//                              String docMflag = (String)docRow.getAttribute("FlageM");
//                             if(uploadFile==null)
//                              {
//                                 if(docMflag.equals("Y"))
//                                 {
//                                errorCheck = "true";
//                                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("100", lngCode)));
//                                return errorCheck;
//                                 }
//                                      }
//                              if(docsDesc==null)
//                               {
//                                 errorCheck = "true";
//                                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("101", lngCode)));
//                                 return errorCheck;
//                               }
//                          }
//                      }
                    
                    //Assigning Enforce Stage ID as Vehicle Accepted at Pound to particular PVT number 
                    
                    DCIteratorBinding headerPvt =
                        bindingsAM.findIteratorBinding("PVTHeaderVO1Iterator");
                    ViewObjectImpl headerPvtVO = (ViewObjectImpl)headerPvt.getViewObject();              
                    if(headerPvtVO!=null)
                    {
                        headerPvtVO.setWhereClause(null);
                        headerPvtVO.setWhereClause("PVT_Num = '"+pvtNo+"'");
                        headerPvtVO.executeQuery();
                        logger.info("get query in Submit Bay Changes Action" + headerPvtVO.getQuery());
                        PVTHeaderVORowImpl pvtHdrRow = (PVTHeaderVORowImpl)headerPvtVO.first();
                        if(pvtHdrRow!=null){
                            pvtHdrSeq=pvtHdrRow.getPVTHDRSEQ();
                            pvtHdrRow.setENFORCESTAGEID(12); 
                        }
                        
                    }
                    String userName = httpSession.getAttribute("loggedinUserid").toString();
                    logger.info("pvtNo== "+pvtNo);
                    BindingContainer bindings = getBindings();
                    OperationBinding opBinding = bindings.getOperationBinding("updateBayStatusByLocIdAndBayNo");
                    opBinding.getParamsMap().put("pvtNo",getPvtNumber());
                    opBinding.getParamsMap().put("baySeq",getBayDetailSeq());
                    opBinding.getParamsMap().put("modifiedBy",userName);
                    opBinding.execute();
                    
                    //Inserting Docs and photos to Pvt Doc Table
                    // calling upload docs method
                    //   uploadBayDocs(pvtHdrSeq);  
                       logger.info("Successfully pvt Docs uploaded");
                        OperationBinding commit = getBindings().getOperationBinding("commit"); 
                        commit.execute();
                        if(commit.getErrors().isEmpty())
                        {
                            OperationBinding op = getBindings().getOperationBinding("callRemovalChargesProc");
                            op.execute();
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("102", lngCode)));
                            setPvtNumber("");
                            resetBayChanges(actionEvent);  
                            errorCheck="true";
//                            OperationBinding operationBinding = getBindings().getOperationBinding("createNewRowDocUpload"); 
//                            operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
//                            operationBinding.execute();
//                            AdfFacesContext.getCurrentInstance().addPartialTarget(docTable);
                            
                        }     
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please create a Pound Location to proceed with Pound Vehicle - Bay Allocation"));       
                }                   
                return errorCheck; 
            }
    public void resetBayChanges(ActionEvent actionEvent) {               
                
                getBindings().getOperationBinding("Rollback").execute(); 
                logger.info("Refreshing Pound Location LOV");
                setRequired(false);
                setPvtNumber("");
                DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
                DCIteratorBinding bindingBay = bindingsAM.findIteratorBinding("PoundBayDetailVO1Iterator");
                Row rowBay = bindingBay.getViewObject().first();
                if(rowBay != null)
                {
                    BindingContainer bc = this.getBindings();
                    JUCtrlListBinding listBindings = (JUCtrlListBinding)bc.get("PoundBayLocation");
                    listBindings.clearSelectedIndices();
                    JUCtrlListBinding listBindingBay =(JUCtrlListBinding)getBindings().get("PoundBayNumber");
                    listBindingBay.clearSelectedIndices();
                    getBindings().getOperationBinding("refreshPoundBayAllocLovs").execute();   
                    AdfFacesContext.getCurrentInstance().addPartialTarget(poundLocSelect);     //PoundLocation LOV not refresher after clicking on Reset button   
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bayLocSelect);
                    BindingContainer bindingsxec = getBindings();
                    OperationBinding operationBinding = bindingsxec.getOperationBinding("createNewRowDocUpload"); 
                    //operationBinding.getParamsMap().put("encoder","vara");
                    operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
                    operationBinding.execute();
                    
                } 
                //Refreshing LocationID LVO and BayNumber LVO
               
                
            }
    
    public void changeBayNumOnLocId(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        JUCtrlListBinding listBinding =(JUCtrlListBinding)getBindings().get("PoundBayLocation");
        listBinding.setSelectedIndex(Integer.parseInt(valueChangeEvent.getNewValue().toString()));
        Row selectedValue = (Row) listBinding.getSelectedValue();
        Integer locId = (Integer)selectedValue.getAttribute("LocationID");
        logger.info("Slected LocationID:: "+selectedValue.getAttribute("LocationID"));
        logger.info("Slected LocationName:: "+selectedValue.getAttribute("LocDesc"));         
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("getBayStatusNosAvailable");
        opBinding.getParamsMap().put("locId",locId);
        opBinding.execute();       
   }
    
    public void getBayNumOnSelect(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        JUCtrlListBinding listBinding =(JUCtrlListBinding)getBindings().get("PoundBayNumber");
        listBinding.setSelectedIndex(Integer.parseInt(valueChangeEvent.getNewValue().toString()));
        Row selectedValue = (Row) listBinding.getSelectedValue();
        if(selectedValue!=null){
            Integer bayNo = (Integer)selectedValue.getAttribute("Baynum");
            logger.info("Selected bayNo:: "+bayNo);
            BigDecimal baySeq = (BigDecimal)selectedValue.getAttribute("PoundbaydetailSeq");
            setBayDetailSeq(baySeq);
            logger.info("Selected baySeq:: "+baySeq);
        }       
    }
    
  
    /**
     * this method is used for uploading the doc for Write and Relese
     * coommon Fuction both functionlaties
    */
        public String  uploadBayDocs(BigDecimal pvtHdrSeq) {
          String validaion = "success";
          PVTDocsVOImpl pvtDocsImpl = (PVTDocsVOImpl)getTRansactionModule().getPVTDocsVO1();
            FileUpload fl = new FileUpload();

            if(pvtDocsImpl!=null) {
              int docsCount =  pvtDocsImpl.getRowCount();
              
              for(int i=0;i<docsCount; i++) {
                    String uploadPath =  null;
                    String fullPath = null;
                    Row docRow = pvtDocsImpl.getRowAtRangeIndex(i);
                     org.apache.myfaces.trinidad.model.UploadedFile uploadFile = (org.apache.myfaces.trinidad.model.UploadedFile)docRow.getAttribute("FileUpload");
                      if(uploadFile!=null)
                      {
                     uploadPath = fl.uploadFilesToFolder("1", "PVT", getPvtNumber(),uploadFile);
                      if(uploadPath!=null) {
                          fullPath = uploadPath+"//"+ uploadFile.getFilename();
                      }
                      String docFielName = uploadFile.getFilename();
                      java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                      System.out.println("sqlDate in uploadPvtDocs is : "+sqlDate);
                      int documentStage=7;
                      int docType = getFileExtension(docFielName);
                      String userName = httpSession.getAttribute("loggedinUserid").toString();
                      docRow.setAttribute("CreatedBy",userName);
                      docRow.setAttribute("CreatedDate",sqlDate);
                      docRow.setAttribute("filepath",fullPath);
                      docRow.setAttribute("Docstage",documentStage);
                      docRow.setAttribute("PVTHDRSEQ",pvtHdrSeq);
                      docRow.setAttribute("deleteflag","N");
                      docRow.setAttribute("doctype",docType);
                  }else {
                      return "fail";
                     }
                    }
                  }
                return validaion;
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
      
      
    public TransactionsAMImpl getTRansactionModule() {
            FacesContext context = FacesContext.getCurrentInstance();
            BindingContext bindingContext = BindingContext.getCurrent();
            DCDataControl dc =
                bindingContext.findDataControl("TransactionsAMDataControl");
            TransactionsAMImpl appM = (TransactionsAMImpl)dc.getDataProvider();
            return appM;
        }  
    
    public String  addUploadDoc() {           
            BindingContainer bindingsxec = getBindings();
            OperationBinding operationBinding = bindingsxec.getOperationBinding("addUploadDoc"); 
            //operationBinding.getParamsMap().put("encoder","vara");
            operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
            operationBinding.execute();  
            return null;
    }
    
  
    public void setPvtNumber(String pvtNumber) {
        this.pvtNumber = pvtNumber;
    }

    public String getPvtNumber() {
        return pvtNumber;
    }

    public void setBayDetailSeq(BigDecimal bayDetailSeq) {
        this.bayDetailSeq = bayDetailSeq;
    }

    public BigDecimal getBayDetailSeq() {
        return bayDetailSeq;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setExtensionType(int extensionType) {
        this.extensionType = extensionType;
    }

    public int getExtensionType() {
        return extensionType;
    }

    public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public List<UploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }



    public void setPoundLocSelect(RichSelectOneChoice poundLocSelect) {
        this.poundLocSelect = poundLocSelect;
    }

    public RichSelectOneChoice getPoundLocSelect() {
        return poundLocSelect;
    }

    public void setPvTNumber(RichInputText pvTNumber) {
        this.pvTNumber = pvTNumber;
    }

    public RichInputText getPvTNumber() {
        return pvTNumber;
    }

    public String selectPVTValue() {
      
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        
        DCIteratorBinding dcItteratorBindings1 =
            bindings.findIteratorBinding("PVTSearchRVO2Iterator");
        ViewObject pvtNumberVoImpl = dcItteratorBindings1.getViewObject();
        Row instrowSelected = dcItteratorBindings1.getCurrentRow();
        if(instrowSelected!=null){
            logger.info("PVTNum ================" +(String) instrowSelected.getAttribute("PVTNum"));
            
            // getPvTNumber().setValue((BigDecimal) instrowSelected.getAttribute("instid"));
            Object pvtNum = (String) instrowSelected.getAttribute("PVTNum");
            getPvTNumber().setValue(pvtNum); 
            setPvtNumber(pvtNum.toString());
            System.out.println("GetPVyNum ::::::::::::::::::::  "+getPvTNumber());
            
            //For Selecting Exact Pound
            BigDecimal pvtHdrSeqLoc = (BigDecimal) instrowSelected.getAttribute("PVTHDRSEQ");
            pvtHdrSeqPound=pvtHdrSeqLoc;
            System.out.println("pvtHdrSeqLoc ::::::::::::::::::::  "+pvtHdrSeqPound);
            //Getting VehicleId and LocationID for Particular PVT Number
            if(pvtHdrSeqPound!=null){
                Integer poundLocId=getLocIdVehicleID();
                setPoundId(poundLocId);
            }
            
        }       
        return null;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setBayLocSelect(RichSelectOneChoice bayLocSelect) {
        this.bayLocSelect = bayLocSelect;
    }

    public RichSelectOneChoice getBayLocSelect() {
        return bayLocSelect;
    }

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


    public String attachValueChangeListner(ValueChangeEvent valueChangeEvent) {
                // Add event code here...
                String validaion = "success";
                String uploadPath =  null;
                String fullPath=null;
                FileUpload fl = new FileUpload();
                BigDecimal  pvtHDRSeq = getPVTHDRSeqNumber();
                RichInputFile inputFileComponent = (RichInputFile)valueChangeEvent.getComponent();
                           UploadedFile newFile = (UploadedFile)valueChangeEvent.getNewValue();
                           inputFileComponent.getClientId(FacesContext.getCurrentInstance());
                
                BindingContext bindingctx = BindingContext.getCurrent();
                BindingContainer binding = bindingctx.getCurrentBindingsEntry();
                DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
                
                //Code for testing
                DCIteratorBinding dciterrefundattchmt =
                    bindingsImpl.findIteratorBinding("PVTDocsVO1Iterator");
                ViewObject voattchmttrans = dciterrefundattchmt.getViewObject();
                
                currentAttchmtRow =dciterrefundattchmt.getRowAtRangeIndex(getDocTable().getRowIndex());
          
                 if(null != valueChangeEvent.getNewValue()){
                    UploadedFile uploadFile =  (UploadedFile)valueChangeEvent.getNewValue();
                    
                     if(uploadFile!=null)
                     {
                     uploadPath = fl.uploadFilesToFolder("1", "PVT", getPvtNumber(), uploadFile);
                     if(uploadPath!=null) {
                         fullPath = uploadPath+"//"+ uploadFile.getFilename();
                     }
                     String docFielName = uploadFile.getFilename();
                     java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                     System.out.println("sqlDate in uploadPvtDocs is : "+sqlDate);
                     int documentStage=7;
                     int docType = getFileExtension(docFielName);
                     String userName = httpSession.getAttribute("loggedinUserid").toString();
                     currentAttchmtRow.setAttribute("CreatedBy",userName);
                     currentAttchmtRow.setAttribute("CreatedDate",sqlDate);
                     currentAttchmtRow.setAttribute("filepath",fullPath);
                     currentAttchmtRow.setAttribute("Docstage",documentStage);
                     currentAttchmtRow.setAttribute("PVTHDRSEQ", pvtHDRSeq);
                     currentAttchmtRow.setAttribute("deleteflag","N");
                     currentAttchmtRow.setAttribute("doctype",docType);
                     
                    System.out.println("CreatedBy ::::::::::::::"+currentAttchmtRow.getAttribute("CreatedBy"));
                    System.out.println("CreatedDate ::::::::::::::"+currentAttchmtRow.getAttribute("CreatedDate"));
                    System.out.println("filepath ::::::::::::::"+currentAttchmtRow.getAttribute("filepath"));
                    System.out.println("filepath ::::::::::::::"+currentAttchmtRow.getAttribute("CreatedBy"));
                    System.out.println("Docstage ::::::::::::::"+currentAttchmtRow.getAttribute("Docstage"));
                    System.out.println("PVTHDRSEQ ::::::::::::::"+currentAttchmtRow.getAttribute("PVTHDRSEQ"));  
                    System.out.println("doctype ::::::::::::::"+currentAttchmtRow.getAttribute("doctype")); 

                     }else {
                     return "fail";
                     }
  
                 }     

        return validaion;
    }

     public BigDecimal getPVTHDRSeqNumber() {
        DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
        DCIteratorBinding headerPvt =
            bindingsAM.findIteratorBinding("PVTHeaderVO1Iterator");
        ViewObjectImpl headerPvtVO = (ViewObjectImpl)headerPvt.getViewObject();              
        if(headerPvtVO!=null &&  getPvtNumber()!=null)
        {
            headerPvtVO.setWhereClause(null);
            headerPvtVO.setWhereClause("PVT_Num = '"+ getPvtNumber()+"'");
            headerPvtVO.executeQuery();
            logger.info("get query in Submit Bay Changes Action" + headerPvtVO.getQuery());
            PVTHeaderVORowImpl pvtHdrRow = (PVTHeaderVORowImpl)headerPvtVO.first();
            if(pvtHdrRow!=null){
                pvtHdrSeqUpload = pvtHdrRow.getPVTHDRSEQ();
            }
        }
        return pvtHdrSeqUpload;
    }
//     public Boolean checkDataBayLoc()
//     {
//        Boolean result = true;
//         DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
//         DCIteratorBinding poundLoc =
//             bindingsAM.findIteratorBinding("PoundLocationLVO1Iterator");
//         ViewObjectImpl poundLocLVO = (ViewObjectImpl)poundLoc.getViewObject();       
//                 if(poundLocLVO != null)
//                 {
//                     poundLocLVO.executeQuery();
//                     if(poundLocLVO.getRowCount()<=0)
//                     {
//                         result = false;
//                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please create a Pound Location to proceed with Pound-Bay Allocation"));    
//                     }
//                     else
//                     {
//                         DCIteratorBinding bayNum =
//                             bindingsAM.findIteratorBinding("BayNumberLVO1Iterator");
//                         ViewObjectImpl bayNumLVO = (ViewObjectImpl)bayNum.getViewObject();    
//                         if(bayNumLVO != null)
//                         {
//                             bayNumLVO.executeQuery();
//                             if(bayNumLVO.getRowCount()<=0)
//                             {
//                                 result = false;
//                                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please create Bay for Pound Location to proceed with Pound-Bay Allocation"));    
//                             }
//                         }
//                     }
//                 }
//        return result;
//     }
     
     
    public Integer getLocIdVehicleID() {
        Integer poundLocId=null;
        DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
        DCIteratorBinding headerVhcl =
            bindingsAM.findIteratorBinding("PvtEnforceVehicleAssignRVO1Iterator");
        ViewObjectImpl headerVhclVO = (ViewObjectImpl)headerVhcl.getViewObject();              
        if(headerVhclVO!=null &&  pvtHdrSeqPound!=null)
        {
            headerVhclVO.setWhereClause(null);
            headerVhclVO.setWhereClause("PVT_HDR_SEQ = '"+ pvtHdrSeqPound+"'");
            headerVhclVO.executeQuery();
            logger.info("get query in getLocIdVehicleID Action" + headerVhclVO.getQuery());
            PvtEnforceVehicleAssignRVORowImpl vhclRow = (PvtEnforceVehicleAssignRVORowImpl)headerVhclVO.first();
            if(vhclRow!=null){
                vehicleId = vhclRow.getENFORCEVHCLID();
            }
        }
        DCIteratorBinding removalTruck =
            bindingsAM.findIteratorBinding("RemovalTruckMstVO1Iterator");
        ViewObjectImpl removalTruckVO = (ViewObjectImpl)removalTruck.getViewObject();              
        if(removalTruckVO!=null &&  vehicleId!=null)
        {
            removalTruckVO.setWhereClause(null);
            removalTruckVO.setWhereClause("ENFORCE_VHCL_ID = '"+ vehicleId+"'");
            removalTruckVO.executeQuery();
            logger.info("get query in getLocIdVehicleID :Getting Pound Id" + removalTruckVO.getQuery());
            RemovalTruckMstVORowImpl removalTruckRow = (RemovalTruckMstVORowImpl)removalTruckVO.first();
           
            if(removalTruckRow!=null){
                poundLocId = removalTruckRow.getLocationID();
            }
        }
        
        DCIteratorBinding locDesc =
            bindingsAM.findIteratorBinding("PoundLocationLVO1Iterator");
        ViewObjectImpl locDescVO = (ViewObjectImpl)locDesc.getViewObject();              
        if(locDescVO!=null &&  poundLocId!=null)
        {
            //locDescVO.setWhereClause(null);
            locDescVO.setWhereClause("Location_ID = '"+ poundLocId+"'");
            locDescVO.executeQuery();
            logger.info("get query in getLocIdVehicleID :Getting Location Desc" + locDescVO.getQuery());
            PoundLocationLVORowImpl locDescRow = (PoundLocationLVORowImpl)locDescVO.first();
           
            if(locDescRow!=null){
                String poundLocDesc = (String)locDescRow.getLocDesc();
                setPoundLocDesc(poundLocDesc);
                System.out.println("GetPoundLocDesc ::::::::::::::::::::  "+getPoundLocDesc());
                
            }
        }
        
        return poundLocId;
    }

    public void setPoundId(Integer poundId) {
        this.poundId = poundId;
    }

    public Integer getPoundId() {
        return poundId;
    }

    public void setPoundLocDesc(String poundLocDesc) {
        this.poundLocDesc = poundLocDesc;
    }

    public String getPoundLocDesc() {
        return poundLocDesc;
    }
}
