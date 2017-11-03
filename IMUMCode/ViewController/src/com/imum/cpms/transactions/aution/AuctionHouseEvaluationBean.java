package com.imum.cpms.transactions.aution;

import com.imum.cpms.model.masters.vo.PVTCourtReportUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVORowImpl;
import com.imum.cpms.util.FileUpload;
import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class AuctionHouseEvaluationBean {
    
    private RichPanelGroupLayout pg11;
    private RichCommandButton submitBtnTop;
    private RichCommandButton cancelBtnTop;
    private RichInputText auctionBatchID;
    private RichInputText auctionInitiationDate;
    private String currentDate = getCurrentDateTime();
    private RichPanelGroupLayout autionHouseEvaluationSearchForm;
    private RichPanelGroupLayout autionHouseEvaluationSearchSelectForm;
    private RichTable auctionHouseEvaluationSearchResultTable;
    private RichSelectBooleanCheckbox auctionHouseEvaluationSearchSelectFlag;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger = ADFLogger.createADFLogger(AutionInitiationBean.class);
    MessageUtil genMsg = new MessageUtil();
    private RichCommandButton submitBtn;
    private RichCommandButton cancelBtn;
    private RichPanelGroupLayout auctionHouseEvaluationTopToolbarForm;
    private RichPanelGroupLayout auctionHouseEvaluationTopSearchForm;
    private RichCommandButton auctionIDSearch;
    private RichInputText pvtSearchSelectedValue;
    private RichInputText auctionHouseRefValue;
    private HtmlInputHidden pvtNumberSelectedValue;
    private RichPanelGroupLayout autionHouseEvaluationSearchTableForm;
    private RichShowDetailHeader pvtAuctionHeadertableForm;
    private Boolean auctionHouseRefVisible = false;
    private RichCommandButton cancelSubmitBtnTop;
    private RichCommandButton cancelSubmitBtn;
    private BigDecimal pvtHdrSeqUpload;
    private RichTable docTable;
    private Row currentAttchmtRow = null;

    String lgCode = httpSession.getAttribute("language").toString();
    private RichCommandButton submitAuctionHouseActionBtn;
    private RichCommandButton submitAuctionHouseActionTopBtn;
    private RichSelectOneChoice auctionEvaluation;
    private RichInputText auctionVenue;
    private RichSelectBooleanCheckbox auctionNOCReceived;
    private RichInputText auctionEvaluationValue;

    public AuctionHouseEvaluationBean() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        } 
    }
    
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setPg11(RichPanelGroupLayout pg11) {
        this.pg11 = pg11;
    }

    public RichPanelGroupLayout getPg11() {
        return pg11;
    }



    public String validateDataOnSubmit() {
        String result="pass";
           if(auctionEvaluation.getValue() == null || auctionEvaluation.getValue().equals("")) {  
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Select Evaluation.", null));    
                result = "fail";    
            }
           else {
               if(auctionEvaluation.getValue().equals("Auction"))
               {
               if(auctionEvaluationValue.getValue() == null || auctionEvaluationValue.getValue().equals("")) {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Evaluation Value in AED. ", null));    
                   result = "fail";    
               }
                   if(auctionVenue.getValue() == null || auctionVenue.getValue().equals("")) {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Auction Venue. ", null));    
                       result = "fail";    
                   }  
               }
               if(auctionEvaluation.getValue().equals("Scrap"))
               {
                   if(auctionEvaluationValue.getValue() == null || auctionEvaluationValue.getValue().equals("")) {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Evaluation Value in AED. ", null));    
                       result = "fail";    
                   }
                       if(auctionVenue.getValue() == null || auctionVenue.getValue().equals("")) {
                           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Auction Venue. ", null));    
                           result = "fail";    
                       }  
                   
               }
               
               
           }          
        System.out.println(auctionEvaluation.getValue());       
         
        return result;
    }
    public String submitAction() {
        // Add event code here...
        BigDecimal pvthdr=new BigDecimal(0);
        String s="N";
        java.sql.Date sqlDate =new java.sql.Date(new java.util.Date().getTime());
        String result = validateDataOnSubmit();
        if(result.equals("fail")) {
        }
        else{  
        String errorCheck="false";
        System.out.println("auctionEvaluation ::"+auctionEvaluation.getValue());
        System.out.println("auctionEvaluationValue in AED ::"+auctionEvaluationValue.getValue());
        System.out.println("auctionVenue ::"+auctionVenue.getValue());
        System.out.println("auctionNOCReceived ::"+auctionNOCReceived.getValue());
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.AuctionEvidenceSearchVO1Iterator.currentRow}");
         if(selectedRow!=null) {
            pvthdr=(BigDecimal)selectedRow.getAttribute("PVTHDRSEQ");
            System.out.println(pvthdr);
                        

        }
            
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PVTAUCTIONHeaderVO1Iterator");
         ViewObject genAuctionHeaderVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = genAuctionHeaderVO.getCurrentRow();
        if(rowSelected != null){
        BigDecimal auctionHeaderseq = (BigDecimal)rowSelected.getAttribute("AUCTIONHeaderseq");
        System.out.println("auctionHeaderseq ::"+auctionHeaderseq);
        OperationBinding operationBinding = bindings.getOperationBinding("saveAuctionHouseEvaluationPvtDetails");
        operationBinding.getParamsMap().put("auctionHeaderseq", auctionHeaderseq);
        operationBinding.getParamsMap().put("pvthdrseq", pvthdr);
        operationBinding.getParamsMap().put("auctionEvaluation", auctionEvaluation.getValue().toString());
        operationBinding.getParamsMap().put("auctionEvaluationValue", (BigDecimal)auctionEvaluationValue.getValue());
        operationBinding.getParamsMap().put("auctionNOCReceived", auctionNOCReceived.getValue());
        operationBinding.getParamsMap().put("auctionVenue", auctionVenue.getValue());
        operationBinding.getParamsMap().put("updatedDate", new java.sql.Date(new java.util.Date().getTime()));
        operationBinding.getParamsMap().put("updatedBy", httpSession.getAttribute("loggedinUserid").toString());
        errorCheck = (String)operationBinding.execute();
        if(errorCheck.equals("success")){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Auction House Evaluation Details and Files Upload Successfully"));
            auctionEvaluation.setValue("");
            auctionEvaluationValue.setValue("");
            auctionVenue.setValue("");
            auctionNOCReceived.setValue(false);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Auction House Evaluation Details Failed to Save"));
            return errorCheck;
        }
        }
        //sqatrt 
        DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("PVTDocsVO1Iterator");
        ViewObject pvtDocsImpl =dcIteratorBinding.getViewObject();
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
                 "Please upload mandatary PVT Documents ",null));
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
        
        OperationBinding commit = getBindings().getOperationBinding("commit"); 
        commit.execute();
        getAutionHouseEvaluationSearchSelectForm().setVisible(false);
        getAuctionHouseEvaluationSearchResultTable().setVisible(true);
        getAuctionHouseRefValue().setVisible(true);
        getCancelBtn().setVisible(true);
        getSubmitAuctionHouseActionBtn().setVisible(true);
        getSubmitAuctionHouseActionTopBtn().setVisible(true);
        getCancelBtnTop().setVisible(true);
        getCancelSubmitBtnTop().setVisible(false);
        getCancelSubmitBtn().setVisible(false);
        getSubmitBtn().setVisible(false);
        getSubmitBtnTop().setVisible(false);
        searchAuctionPvts();
        return null;
    }
        return null;
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

    public String cancelAction() {
        getAuctionHouseRefValue().setValue(null);
        getPvtAuctionHeadertableForm().setVisible(true);
        getAuctionHouseEvaluationTopSearchForm().setVisible(true);
        getAutionHouseEvaluationSearchSelectForm().setVisible(false);
        getAutionHouseEvaluationSearchTableForm().setVisible(false);
        getAuctionIDSearch().setVisible(true);
        getSubmitBtn().setVisible(false);
        getCancelBtn().setVisible(false);
        getSubmitAuctionHouseActionBtn().setVisible(false);
        getSubmitAuctionHouseActionTopBtn().setVisible(false);
        getCancelSubmitBtn().setVisible(false);
        getSubmitBtnTop().setVisible(false);
        getCancelBtnTop().setVisible(false);
        getCancelSubmitBtnTop().setVisible(false);
        return null;
    }

    public void setAuctionBatchID(RichInputText auctionBatchID) {
        this.auctionBatchID = auctionBatchID;
    }

    public RichInputText getAuctionBatchID() {
        return auctionBatchID;
    }

    public void setAuctionInitiationDate(RichInputText auctionInitiationDate) {
        this.auctionInitiationDate = auctionInitiationDate;
    }

    public RichInputText getAuctionInitiationDate() {
        return auctionInitiationDate;
    }
    /**
        * Get Current Date
        * @return
        */
        public String getCurrentDateTime()
      {
      return new Date(new java.sql.Timestamp(System.currentTimeMillis())).toString();
      }

    public String searchAuctionPvts() {
        try{
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PVTAUCTIONHeaderVO1Iterator");
         ViewObject genAuctionHeaderVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = genAuctionHeaderVO.getCurrentRow();
        if(rowSelected != null){
            BigDecimal auctionHeaderseq = (BigDecimal)rowSelected.getAttribute("AUCTIONHeaderseq");
            
            
            if(auctionHeaderseq!=null && !"".equals(auctionHeaderseq))
            {
                OperationBinding operationBinding = bindings.getOperationBinding("getAuctionHouseEvaluationPvtDetails");
                operationBinding.getParamsMap().put("auctionHeaderseq", auctionHeaderseq);
                String selectedGroupNamePiid = (String)operationBinding.execute();
                getPvtAuctionHeadertableForm().setVisible(false);
                pvtSearchSelectedValue.setValue(auctionHeaderseq);
                
                getAuctionIDSearch().setVisible(false);
                getAutionHouseEvaluationSearchTableForm().setVisible(true);
                getSubmitBtn().setVisible(false);
                getCancelBtn().setVisible(true);
                getSubmitAuctionHouseActionBtn().setVisible(true);
                getSubmitAuctionHouseActionTopBtn().setVisible(true);
                getSubmitBtnTop().setVisible(false);
                getCancelBtnTop().setVisible(true);
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Please Select Auction to Show Details",null));
                   
            }
        }else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select Auction to Show Details",null));
         
        }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          "Please Enter Valid Auction Batch ID",null));
            
        }
        getSubmitBtnTop().setVisible(false);
        return null;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setAutionHouseEvaluationSearchForm(RichPanelGroupLayout autionHouseEvaluationSearchForm) {
        this.autionHouseEvaluationSearchForm = autionHouseEvaluationSearchForm;
    }

    public RichPanelGroupLayout getAutionHouseEvaluationSearchForm() {
        return autionHouseEvaluationSearchForm;
    }

    public void auctionIDChange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        getAutionHouseEvaluationSearchForm().setVisible(false);
    }

    public void setAuctionHouseEvaluationSearchResultTable(RichTable auctionHouseEvaluationSearchResultTable) {
        this.auctionHouseEvaluationSearchResultTable = auctionHouseEvaluationSearchResultTable;
    }

    public RichTable getAuctionHouseEvaluationSearchResultTable() {
        return auctionHouseEvaluationSearchResultTable;
    }

    public void setAuctionHouseEvaluationSearchSelectFlag(RichSelectBooleanCheckbox auctionHouseEvaluationSearchSelectFlag) {
        this.auctionHouseEvaluationSearchSelectFlag = auctionHouseEvaluationSearchSelectFlag;
    }

    public RichSelectBooleanCheckbox getAuctionHouseEvaluationSearchSelectFlag() {
        return auctionHouseEvaluationSearchSelectFlag;
    }

    public void auctionHouseEvaluationSearchSelectFlagListener(ActionEvent actionEvent) {
        // Add event code here...
        DCIteratorBinding dcItterator =
               bindingsAM.findIteratorBinding("AuctionEvidenceSearchVO1Iterator");
        ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
        Row row = invDetailVO.getCurrentRow();
        System.out.println("PVT Number ::"+row.getAttribute("PVTNum"));
        
        pvtNumberSelectedValue.setValue(row.getAttribute("PVTNum"));
       
        invDetailVO.clearCache();
        invDetailVO.executeEmptyRowSet();
        invDetailVO.insertRow(row);
        createNewRowDocUploadMethod();
        
        
        
        row.setAttribute("SelectFlag", true);
        getAuctionHouseEvaluationSearchResultTable().setVisible(false);
        getAuctionHouseRefValue().setVisible(false);
        getAutionHouseEvaluationSearchSelectForm().setVisible(true);
        getSubmitBtn().setVisible(true);
        getCancelSubmitBtn().setVisible(true);
        getCancelBtn().setVisible(false);
        getSubmitAuctionHouseActionBtn().setVisible(false);
        getSubmitAuctionHouseActionTopBtn().setVisible(false);
        getAuctionIDSearch().setVisible(false);
        getSubmitBtnTop().setVisible(true);
        getCancelSubmitBtnTop().setVisible(true);
        getCancelBtnTop().setVisible(false);
    }
    
    public void createNewRowDocUploadMethod() {               
        BindingContainer bindingsxec = getBindings();
        OperationBinding operationBinding = bindingsxec.getOperationBinding("createDocUploadAuctionEvaluation"); 
        operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
        operationBinding.execute();
    }
    
    public String attachValueChangeListner(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String validaion = "success";
        String uploadPath = null;
        String fullPath = null;
        FileUpload fl = new FileUpload();
        BigDecimal pvtHDRSeq = getPVTHDRSeqNumber();
        RichInputFile inputFileComponent =
            (RichInputFile)valueChangeEvent.getComponent();
        UploadedFile newFile = (UploadedFile)valueChangeEvent.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());

        BindingContext bindingctx = BindingContext.getCurrent();
        BindingContainer binding = bindingctx.getCurrentBindingsEntry();
        DCBindingContainer bindingsImpl = (DCBindingContainer)binding;

        //Code for testing
        DCIteratorBinding dciterrefundattchmt =
            bindingsImpl.findIteratorBinding("PVTDocsVO1Iterator");
        ViewObject voattchmttrans = dciterrefundattchmt.getViewObject();

        currentAttchmtRow =
                dciterrefundattchmt.getRowAtRangeIndex(getDocTable().getRowIndex());

        if (null != valueChangeEvent.getNewValue()) {
            UploadedFile uploadFile =
                (UploadedFile)valueChangeEvent.getNewValue();

            if (uploadFile != null) {
                uploadPath =
                        fl.uploadFilesToFolder("1", "PVT", getPvtNumberSelectedValue().getValue().toString(),
                                               uploadFile);
                if (uploadPath != null) {
                    fullPath = uploadPath + "//" + uploadFile.getFilename();
                }
                String docFielName = uploadFile.getFilename();
                java.sql.Date sqlDate =
                    new java.sql.Date(new java.util.Date().getTime());
                System.out.println("sqlDate in uploadPvtDocs is : " + sqlDate);
                int documentStage = 7;
                int docType = getFileExtension(docFielName);
                String userName =
                    httpSession.getAttribute("loggedinUserid").toString();
                currentAttchmtRow.setAttribute("CreatedBy", userName);
                currentAttchmtRow.setAttribute("CreatedDate", sqlDate);
                currentAttchmtRow.setAttribute("filepath", fullPath);
                currentAttchmtRow.setAttribute("Docstage", documentStage);
                currentAttchmtRow.setAttribute("PVTHDRSEQ", pvtHDRSeq);
                currentAttchmtRow.setAttribute("deleteflag", "N");
                currentAttchmtRow.setAttribute("doctype", docType);

                System.out.println("CreatedBy ::::::::::::::" +
                                   currentAttchmtRow.getAttribute("CreatedBy"));
                System.out.println("CreatedDate ::::::::::::::" +
                                   currentAttchmtRow.getAttribute("CreatedDate"));
                System.out.println("filepath ::::::::::::::" +
                                   currentAttchmtRow.getAttribute("filepath"));
                System.out.println("filepath ::::::::::::::" +
                                   currentAttchmtRow.getAttribute("CreatedBy"));
                System.out.println("Docstage ::::::::::::::" +
                                   currentAttchmtRow.getAttribute("Docstage"));
                System.out.println("PVTHDRSEQ ::::::::::::::" +
                                   currentAttchmtRow.getAttribute("PVTHDRSEQ"));
                System.out.println("doctype ::::::::::::::" +
                                   currentAttchmtRow.getAttribute("doctype"));

            } else {
                return "fail";
            }

        }

        return validaion;
    }

    public BigDecimal getPVTHDRSeqNumber() {
        DCBindingContainer bindingsAM = (DCBindingContainer)getBindings();
        DCIteratorBinding headerPvt =
            bindingsAM.findIteratorBinding("PVTHeaderVO1Iterator");
        ViewObjectImpl headerPvtVO = (ViewObjectImpl)headerPvt.getViewObject();
        if (headerPvtVO != null && getPvtNumberSelectedValue() != null) {
            headerPvtVO.setWhereClause(null);
            headerPvtVO.setWhereClause("PVT_Num = '" +
                                       getPvtNumberSelectedValue().getValue() + "'");
            headerPvtVO.executeQuery();
            //logger.info("get query in Submit Bay Changes Action" + headerPvtVO.getQuery());
            PVTHeaderVORowImpl pvtHdrRow =
                (PVTHeaderVORowImpl)headerPvtVO.first();
            if (pvtHdrRow != null) {
                pvtHdrSeqUpload = pvtHdrRow.getPVTHDRSEQ();
            }
        }
        return pvtHdrSeqUpload;
    }
    
    private static int getFileExtension(String file) {
        String fileName = file;
        String extType = null;
        int docType = 0;
        if (fileName.lastIndexOf(".") != -1 &&
            fileName.lastIndexOf(".") != 0) {
            extType = fileName.substring(fileName.lastIndexOf(".") + 1);
            //.gif.bmp.dib.jpg.jpe.jfif.tiff.tif
            if (extType != null && extType.equalsIgnoreCase("jpeg") ||
                extType.equalsIgnoreCase("png") ||
                extType.equalsIgnoreCase("gif") ||
                extType.equalsIgnoreCase("bmp") ||
                extType.equalsIgnoreCase("dib") ||
                extType.equalsIgnoreCase("jpg") ||
                extType.equalsIgnoreCase("jfif") ||
                extType.equalsIgnoreCase("tiff") ||
                extType.equalsIgnoreCase("tif")) {
                extType = "IMAGE";
                docType = 2;
            } else if (extType != null && extType.equalsIgnoreCase("xml")) {
                extType = "XML";
                docType = 3;
            } else if (extType != null && extType.equalsIgnoreCase("pdf") ||
                       extType.equalsIgnoreCase("docx") ||
                       extType.equalsIgnoreCase("doc") ||
                       extType.equalsIgnoreCase("xlsx") ||
                       extType.equalsIgnoreCase("xls") ||
                       extType.equalsIgnoreCase("txt")) {
                extType = "PDF";
                docType = 3;
            } else if (extType != null &&
                       (extType.equalsIgnoreCase("MPG") || extType.equalsIgnoreCase("MPEG"))) {
                extType = "Video";
                docType = 4;
            }
            return docType;
        }

        else
            return docType;
    }

    public void setAutionHouseEvaluationSearchSelectForm(RichPanelGroupLayout autionHouseEvaluationSearchSelectForm) {
        this.autionHouseEvaluationSearchSelectForm = autionHouseEvaluationSearchSelectForm;
    }

    public RichPanelGroupLayout getAutionHouseEvaluationSearchSelectForm() {
        return autionHouseEvaluationSearchSelectForm;
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

    public void setAuctionHouseEvaluationTopToolbarForm(RichPanelGroupLayout auctionHouseEvaluationTopToolbarForm) {
        this.auctionHouseEvaluationTopToolbarForm = auctionHouseEvaluationTopToolbarForm;
    }

    public RichPanelGroupLayout getAuctionHouseEvaluationTopToolbarForm() {
        return auctionHouseEvaluationTopToolbarForm;
    }

    public void setAuctionHouseEvaluationTopSearchForm(RichPanelGroupLayout auctionHouseEvaluationTopSearchForm) {
        this.auctionHouseEvaluationTopSearchForm = auctionHouseEvaluationTopSearchForm;
    }

    public RichPanelGroupLayout getAuctionHouseEvaluationTopSearchForm() {
        return auctionHouseEvaluationTopSearchForm;
    }

    public void setAuctionIDSearch(RichCommandButton auctionIDSearch) {
        this.auctionIDSearch = auctionIDSearch;
    }

    public RichCommandButton getAuctionIDSearch() {
        return auctionIDSearch;
    }

    public void setPvtSearchSelectedValue(RichInputText pvtSearchSelectedValue) {
        this.pvtSearchSelectedValue = pvtSearchSelectedValue;
    }

    public RichInputText getPvtSearchSelectedValue() {
        return pvtSearchSelectedValue;
    }

   
    public void setAuctionHouseRefValue(RichInputText auctionHouseRefValue) {
        this.auctionHouseRefValue = auctionHouseRefValue;
    }

    public RichInputText getAuctionHouseRefValue() {
        return auctionHouseRefValue;
    }

    public void setPvtNumberSelectedValue(HtmlInputHidden pvtNumberSelectedValue) {
        this.pvtNumberSelectedValue = pvtNumberSelectedValue;
    }

    public HtmlInputHidden getPvtNumberSelectedValue() {
        return pvtNumberSelectedValue;
    }

    public void setAutionHouseEvaluationSearchTableForm(RichPanelGroupLayout autionHouseEvaluationSearchTableForm) {
        this.autionHouseEvaluationSearchTableForm = autionHouseEvaluationSearchTableForm;
    }

    public RichPanelGroupLayout getAutionHouseEvaluationSearchTableForm() {
        return autionHouseEvaluationSearchTableForm;
    }

    public void setPvtAuctionHeadertableForm(RichShowDetailHeader pvtAuctionHeadertableForm) {
        this.pvtAuctionHeadertableForm = pvtAuctionHeadertableForm;
    }

    public RichShowDetailHeader getPvtAuctionHeadertableForm() {
        return pvtAuctionHeadertableForm;
    }

    public void setAuctionHouseRefVisible(Boolean auctionHouseRefVisible) {
        this.auctionHouseRefVisible = auctionHouseRefVisible;
    }

    public Boolean getAuctionHouseRefVisible() {
        return auctionHouseRefVisible;
    }

    public String cancelSubmitAction() {
        // Add event code here...
        getAutionHouseEvaluationSearchSelectForm().setVisible(false);
        getAuctionHouseEvaluationSearchResultTable().setVisible(true);
        getAuctionHouseRefValue().setVisible(true);
        getCancelBtn().setVisible(true);
        getSubmitAuctionHouseActionBtn().setVisible(true);
        getSubmitAuctionHouseActionTopBtn().setVisible(true);
        getCancelBtnTop().setVisible(true);
        getCancelSubmitBtnTop().setVisible(false);
        getCancelSubmitBtn().setVisible(false);
        getSubmitBtn().setVisible(false);
        getSubmitBtnTop().setVisible(false);
        searchAuctionPvts();
        //remove rows
        DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("PVTDocsVO1Iterator");
        
        
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
        
        pvtDocsImpl1.setCurrentRow(docRow1);
        pvtDocsImpl1.removeCurrentRow();
        }
        return null;
    }

    public void setCancelSubmitBtnTop(RichCommandButton cancelSubmitBtnTop) {
        this.cancelSubmitBtnTop = cancelSubmitBtnTop;
    }

    public RichCommandButton getCancelSubmitBtnTop() {
        return cancelSubmitBtnTop;
    }

    public void setCancelSubmitBtn(RichCommandButton cancelSubmitBtn) {
        this.cancelSubmitBtn = cancelSubmitBtn;
    }

    public RichCommandButton getCancelSubmitBtn() {
        return cancelSubmitBtn;
    }

    public void setDocTable(RichTable docTable) {
        this.docTable = docTable;
    }

    public RichTable getDocTable() {
        return docTable;
    }

    public void submitAuctionHouseAction(DialogEvent dialogEvent) {
        String Flage="Y";
        Object valmat=null;
        if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.yes)) {
            // check the values 
            DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("AuctionEvidenceSearchVO1Iterator");
            ViewObject AuctionVO =dcIteratorBinding.getViewObject();
           System.out.println(AuctionVO.getEstimatedRowCount());
            RowSetIterator iterator = AuctionVO.createRowSetIterator(null);
            iterator.reset();
            while (iterator.hasNext()) {
            Row docRow = iterator.next();
                if(docRow!=null) {
               valmat   =docRow.getAttribute("ValuationRecomdationID");
                }
            
            if (valmat ==null) {    
                Flage="N";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please Enter Auction Detiles "));       
            }     
           }
            
           if(Flage.equals("Y")) {
                   BigDecimal auctionHeaderseq =(BigDecimal)getPvtSearchSelectedValue().getValue();
                   System.out.println(auctionHeaderseq);
                  OperationBinding operationBinding =bindings.getOperationBinding("saveAuctionHouseEvaluationDetails");
                           operationBinding.getParamsMap().put("auctionHeaderseq",auctionHeaderseq);
                           System.out.println(auctionHouseRefValue.getValue());
                           operationBinding.getParamsMap().put("auctionHouseRef",auctionHouseRefValue.getValue());
                           operationBinding.getParamsMap().put("updatedDate", new java.sql.Date(new java.util.Date().getTime()));
                           operationBinding.getParamsMap().put("updatedby",httpSession.getAttribute("loggedinUserid").toString());
                           String selectedResult = (String)operationBinding.execute();
                           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Auction House Evaluation Successfully",null));
                           System.out.println("Success Assigned to Aution House");
                           cancelAction();
                System.out.println("Success Assigned to Aution House");
            }
               
   }
    }

    public void setSubmitAuctionHouseActionBtn(RichCommandButton submitAuctionHouseActionBtn) {
        this.submitAuctionHouseActionBtn = submitAuctionHouseActionBtn;
    }

    public RichCommandButton getSubmitAuctionHouseActionBtn() {
        return submitAuctionHouseActionBtn;
    }

    public void setSubmitAuctionHouseActionTopBtn(RichCommandButton submitAuctionHouseActionTopBtn) {
        this.submitAuctionHouseActionTopBtn = submitAuctionHouseActionTopBtn;
    }

    public RichCommandButton getSubmitAuctionHouseActionTopBtn() {
        return submitAuctionHouseActionTopBtn;
    }

    public void setAuctionEvaluation(RichSelectOneChoice auctionEvaluation) {
        this.auctionEvaluation = auctionEvaluation;
    }

    public RichSelectOneChoice getAuctionEvaluation() {
        return auctionEvaluation;
    }

    public void setAuctionVenue(RichInputText auctionVenue) {
        this.auctionVenue = auctionVenue;
    }

    public RichInputText getAuctionVenue() {
        return auctionVenue;
    }

    public void setAuctionNOCReceived(RichSelectBooleanCheckbox auctionNOCReceived) {
        this.auctionNOCReceived = auctionNOCReceived;
    }

    public RichSelectBooleanCheckbox getAuctionNOCReceived() {
        return auctionNOCReceived;
    }

    public void setAuctionEvaluationValue(RichInputText auctionEvaluationValue) {
        this.auctionEvaluationValue = auctionEvaluationValue;
    }

    public RichInputText getAuctionEvaluationValue() {
        return auctionEvaluationValue;
    }

    public String submitAuctionHouseAction() {
        // Add event code here...
        System.out.println("after cancel");
        cancelAction();
        return null;
    }
}
