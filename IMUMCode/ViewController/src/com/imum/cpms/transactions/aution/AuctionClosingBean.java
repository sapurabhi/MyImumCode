package com.imum.cpms.transactions.aution;

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
import oracle.adf.view.rich.component.rich.input.RichInputDate;
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

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class AuctionClosingBean {
    
    private RichPanelGroupLayout pg11;
    private RichCommandButton submitBtnTop;
    private RichCommandButton cancelBtnTop;
    private RichInputText auctionBatchID;
    private RichInputText auctionInitiationDate;
    private String currentDate = getCurrentDateTime();
    private RichPanelGroupLayout autionClosingSearchForm;
    private RichPanelGroupLayout autionClosingSearchSelectForm;
    private RichTable auctionClosingSearchResultTable;
    private RichSelectBooleanCheckbox auctionClosingSearchSelectFlag;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger = ADFLogger.createADFLogger(AutionInitiationBean.class);
    MessageUtil genMsg = new MessageUtil();
    private RichCommandButton submitBtn;
    private RichCommandButton cancelBtn;
    private RichPanelGroupLayout auctionClosingTopToolbarForm;
    private RichPanelGroupLayout auctionClosingTopSearchForm;
    private RichCommandButton auctionIDSearch;
    private RichInputText pvtSearchSelectedValue;
    
    private HtmlInputHidden pvtNumberSelectedValue;
    private RichPanelGroupLayout autionClosingSearchTableForm;
    private RichShowDetailHeader pvtAuctionHeadertableForm;
    
    private RichCommandButton cancelSubmitBtnTop;
    private RichCommandButton cancelSubmitBtn;
    private BigDecimal pvtHdrSeqUpload;
    private RichTable docTable;
    private Row currentAttchmtRow = null;

    String lgCode = httpSession.getAttribute("language").toString();
    private RichCommandButton submitAuctionHouseActionBtn;
    private RichCommandButton submitAuctionHouseActionTopBtn;
    private RichInputText finalBidAmount;
    private RichInputText actualScrapAmount;
    private RichInputText bidderName;
    private RichInputText remarks;
    private RichInputDate bidDate;
    private RichInputDate scrapDate;

    public AuctionClosingBean() {
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

    public String submitAction() {
        // Add event code here...
        String result = validateDataOnSubmit(); 
            if(result.equals("fail")) {
            }
            else{ 
        String errorCheck="false";
        System.out.println("finalBidAmount ::"+finalBidAmount.getValue());
        System.out.println("actualScrapAmount in AED ::"+actualScrapAmount.getValue());
        System.out.println("bidderName ::"+bidderName.getValue());
        System.out.println("remarks ::"+remarks.getValue());
        System.out.println("bidDate ::"+bidDate.getValue());
        System.out.println("scrapDate ::"+scrapDate.getValue());
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PVTAUCTIONHeaderVO1Iterator");
         ViewObject genAuctionHeaderVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = genAuctionHeaderVO.getCurrentRow();
        BigDecimal finalAmount ;
        java.util.Date bidDt;
        if(rowSelected != null){
            BigDecimal auctionHeaderseq = (BigDecimal)rowSelected.getAttribute("AUCTIONHeaderseq");
            System.out.println("auctionHeaderseq ::"+auctionHeaderseq);
            DCIteratorBinding dcItterator =
                   bindingsAM.findIteratorBinding("AuctionEvidenceSearchVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
            Row row = invDetailVO.getCurrentRow();
            System.out.println("PVT Number ::"+row.getAttribute("PVTNum"));
            System.out.println("ValuationRecomdationID ::"+row.getAttribute("ValuationRecomdationID"));
            
            int ValuationRecomdationID = (Integer)row.getAttribute("ValuationRecomdationID");
            
             if(ValuationRecomdationID == 2){
                System.out.println("This is Scrap");
                finalAmount = (BigDecimal)actualScrapAmount.getValue();
                bidDt =(java.util.Date)scrapDate.getValue();
            }else{
                System.out.println("This is Auction");
                finalAmount = (BigDecimal)finalBidAmount.getValue();
                bidDt =(java.util.Date)bidDate.getValue();
            }
            
            OperationBinding operationBinding = bindings.getOperationBinding("saveAuctionClosingPvtDetails");
            operationBinding.getParamsMap().put("auctionHeaderseq", auctionHeaderseq);
            operationBinding.getParamsMap().put("finalBidAmount", finalAmount);
            operationBinding.getParamsMap().put("pvthdrseq",(BigDecimal)row.getAttribute("PVTHDRSEQ"));
            operationBinding.getParamsMap().put("bidderName", (String)bidderName.getValue());
            operationBinding.getParamsMap().put("remarks", (String)remarks.getValue());
            
            java.sql.Date bidDtsql = new java.sql.Date(bidDt.getTime());
            operationBinding.getParamsMap().put("bidDate", bidDtsql);
//            java.util.Date scrapDt =(java.util.Date)scrapDate.getValue();
//            java.sql.Date scrapDtsql = new java.sql.Date(scrapDt.getTime());
//            operationBinding.getParamsMap().put("scrapDate", scrapDtsql);
            operationBinding.getParamsMap().put("auctionInitiationDate", new java.sql.Date(new java.util.Date().getTime()));
            operationBinding.getParamsMap().put("updatedBy", httpSession.getAttribute("loggedinUserid").toString());
            errorCheck = (String)operationBinding.execute();
            if(errorCheck.equals("success")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Auction Closing Details and Files Upload Successfully"));
                finalBidAmount.setValue("");
                actualScrapAmount.setValue("");
                bidderName.setValue("");
                remarks.setValue("");
                bidDate.setValue("");
                scrapDate.setValue("");
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Auction Closing Details Failed to Save"));
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
        getAutionClosingSearchSelectForm().setVisible(false);
        getAuctionClosingSearchResultTable().setVisible(true);
        
        getCancelBtn().setVisible(true);
        getSubmitAuctionHouseActionBtn().setVisible(true);
        getSubmitAuctionHouseActionTopBtn().setVisible(true);
        getCancelBtnTop().setVisible(true);
        getCancelSubmitBtnTop().setVisible(false);
        getCancelSubmitBtn().setVisible(false);
        getSubmitBtn().setVisible(false);
        getSubmitBtnTop().setVisible(false);
        searchAuctionPvts();
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
        // Add event code here...
        getPvtAuctionHeadertableForm().setVisible(true);
        getAuctionClosingTopSearchForm().setVisible(true);
        getAutionClosingSearchSelectForm().setVisible(false);
        getAutionClosingSearchTableForm().setVisible(false);
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
                OperationBinding operationBinding = bindings.getOperationBinding("getAuctionClosingPvtDetails");
                operationBinding.getParamsMap().put("auctionHeaderseq", auctionHeaderseq);
                String selectedGroupNamePiid = (String)operationBinding.execute();
                getPvtAuctionHeadertableForm().setVisible(false);
                pvtSearchSelectedValue.setValue(auctionHeaderseq);
                getAuctionIDSearch().setVisible(false);
                getAutionClosingSearchTableForm().setVisible(true);
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

    public void setAutionClosingSearchForm(RichPanelGroupLayout autionClosingSearchForm) {
        this.autionClosingSearchForm = autionClosingSearchForm;
    }

    public RichPanelGroupLayout getAutionClosingSearchForm() {
        return autionClosingSearchForm;
    }

    public void auctionIDChange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        getAutionClosingSearchForm().setVisible(false);
    }

    public void setAuctionClosingSearchResultTable(RichTable auctionClosingSearchResultTable) {
        this.auctionClosingSearchResultTable = auctionClosingSearchResultTable;
    }

    public RichTable getAuctionClosingSearchResultTable() {
        return auctionClosingSearchResultTable;
    }

    public void setAuctionClosingSearchSelectFlag(RichSelectBooleanCheckbox auctionClosingSearchSelectFlag) {
        this.auctionClosingSearchSelectFlag = auctionClosingSearchSelectFlag;
    }

    public RichSelectBooleanCheckbox getAuctionClosingSearchSelectFlag() {
        return auctionClosingSearchSelectFlag;
    }

    public String validateDataOnSubmit() {
        DCIteratorBinding dcItterator =bindingsAM.findIteratorBinding("AuctionEvidenceSearchVO1Iterator");
        ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
        Row row = invDetailVO.getCurrentRow();
        System.out.println("PVT Number ::"+row.getAttribute("PVTNum"));
        System.out.println("ValuationRecomdationID ::"+row.getAttribute("ValuationRecomdationID"));
        int ValuationRecomdationID = row.getAttribute("ValuationRecomdationID")!=null?(Integer)row.getAttribute("ValuationRecomdationID"):0;
        String result="pass";
           
        if(remarks.getValue() == null || remarks.getValue().equals("")) {  
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Remarks.", null));    
             result = "fail";    
         }
        
        if(ValuationRecomdationID == 2){
        if(actualScrapAmount.getValue() == null || actualScrapAmount.getValue().equals("")) {  
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Actual Scrap Amount.", null));    
             result = "fail";    
         }
        if(scrapDate.getValue() == null || scrapDate.getValue().equals("")) {  
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Scrap Date.", null));    
             result = "fail";    
         }  }
        else {
            if(finalBidAmount.getValue() == null || finalBidAmount.getValue().equals("")) {  
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Final Bid Amount.", null));    
                 result = "fail";    
             }
            if(bidderName.getValue() == null || bidderName.getValue().equals("")) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Bidder Name.", null));    
              result = "fail";    
            }
            if(bidDate.getValue() == null || bidDate.getValue().equals("")) {  
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select Bid Date.", null));    
                 result = "fail";    
             }
        }
         
        return result;
    }



    public void auctionClosingSearchSelectFlagListener(ActionEvent actionEvent) {
        // Add event code here...
        DCIteratorBinding dcItterator =bindingsAM.findIteratorBinding("AuctionEvidenceSearchVO1Iterator");
        ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
        Row row = invDetailVO.getCurrentRow();
        System.out.println("PVT Number ::"+row.getAttribute("PVTNum"));
        System.out.println("ValuationRecomdationID ::"+row.getAttribute("ValuationRecomdationID"));
        int ValuationRecomdationID = row.getAttribute("ValuationRecomdationID")!=null?(Integer)row.getAttribute("ValuationRecomdationID"):0;
        
         if(ValuationRecomdationID == 2){
            System.out.println("This is Scrap");
            bidDate.setVisible(false);
            finalBidAmount.setVisible(false);
            scrapDate.setVisible(true);
            actualScrapAmount.setVisible(true);
        }else{
            System.out.println("This is Auction");
            scrapDate.setVisible(false);
            actualScrapAmount.setVisible(false);
            bidDate.setVisible(true);
            finalBidAmount.setVisible(true);
        }
        
        pvtNumberSelectedValue.setValue(row.getAttribute("PVTNum"));
        invDetailVO.clearCache();
        invDetailVO.executeEmptyRowSet();
        invDetailVO.insertRow(row);
        createNewRowDocUploadMethod();
        row.setAttribute("SelectFlag", true);
        getAuctionClosingSearchResultTable().setVisible(false);
        
        getAutionClosingSearchSelectForm().setVisible(true);
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
        OperationBinding operationBinding = bindingsxec.getOperationBinding("createDocUploadAuctionClosing"); 
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

    public void setAutionClosingSearchSelectForm(RichPanelGroupLayout autionClosingSearchSelectForm) {
        this.autionClosingSearchSelectForm = autionClosingSearchSelectForm;
    }

    public RichPanelGroupLayout getAutionClosingSearchSelectForm() {
        return autionClosingSearchSelectForm;
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

    public void setAuctionClosingTopToolbarForm(RichPanelGroupLayout auctionClosingTopToolbarForm) {
        this.auctionClosingTopToolbarForm = auctionClosingTopToolbarForm;
    }

    public RichPanelGroupLayout getAuctionClosingTopToolbarForm() {
        return auctionClosingTopToolbarForm;
    }

    public void setAuctionClosingTopSearchForm(RichPanelGroupLayout auctionClosingTopSearchForm) {
        this.auctionClosingTopSearchForm = auctionClosingTopSearchForm;
    }

    public RichPanelGroupLayout getAuctionClosingTopSearchForm() {
        return auctionClosingTopSearchForm;
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

   
    public void setPvtNumberSelectedValue(HtmlInputHidden pvtNumberSelectedValue) {
        this.pvtNumberSelectedValue = pvtNumberSelectedValue;
    }

    public HtmlInputHidden getPvtNumberSelectedValue() {
        return pvtNumberSelectedValue;
    }

    public void setAutionClosingSearchTableForm(RichPanelGroupLayout autionClosingSearchTableForm) {
        this.autionClosingSearchTableForm = autionClosingSearchTableForm;
    }

    public RichPanelGroupLayout getAutionClosingSearchTableForm() {
        return autionClosingSearchTableForm;
    }

    public void setPvtAuctionHeadertableForm(RichShowDetailHeader pvtAuctionHeadertableForm) {
        this.pvtAuctionHeadertableForm = pvtAuctionHeadertableForm;
    }

    public RichShowDetailHeader getPvtAuctionHeadertableForm() {
        return pvtAuctionHeadertableForm;
    }

   

    public String cancelSubmitAction() {
        // Add event code here...
        getAutionClosingSearchSelectForm().setVisible(false);
        getAuctionClosingSearchResultTable().setVisible(true);
        
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
            DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("AuctionEvidenceSearchVO1Iterator");
            ViewObject AuctionVO =dcIteratorBinding.getViewObject();
            System.out.println(AuctionVO.getEstimatedRowCount());
            RowSetIterator iterator = AuctionVO.createRowSetIterator(null);
            iterator.reset();
            while (iterator.hasNext()) {
            Row docRow = iterator.next();
                if(docRow!=null) {
               valmat   =docRow.getAttribute("FinalBidAmt");
                }
            
            if (valmat == null) {    
                Flage="N";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please Enter Auction Detiles "));       
            }     
            }         
            if(Flage.equals("Y")) {
            BigDecimal auctionHeaderseq =(BigDecimal)getPvtSearchSelectedValue().getValue();
            System.out.println(auctionHeaderseq);
            OperationBinding operationBinding =bindings.getOperationBinding("saveAuctionClosingDetails");
            operationBinding.getParamsMap().put("auctionHeaderseq",
                                                auctionHeaderseq);
            operationBinding.getParamsMap().put("updatedDate", new java.sql.Date(new java.util.Date().getTime()));
            operationBinding.getParamsMap().put("updatedby",httpSession.getAttribute("loggedinUserid").toString());
            String selectedResult = (String)operationBinding.execute();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Auction House Closing Successfully",null));
            System.out.println("Success Closed to Aution House");
            cancelAction();
            System.out.println("Success Closed to Aution House");
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

    public String submitAuctionHouseAction() {
        // Add event code here...
        System.out.println("after cancel");
        cancelAction();
        return null;
    }

    public void setFinalBidAmount(RichInputText finalBidAmount) {
        this.finalBidAmount = finalBidAmount;
    }

    public RichInputText getFinalBidAmount() {
        return finalBidAmount;
    }

    public void setActualScrapAmount(RichInputText actualScrapAmount) {
        this.actualScrapAmount = actualScrapAmount;
    }

    public RichInputText getActualScrapAmount() {
        return actualScrapAmount;
    }

    public void setBidderName(RichInputText bidderName) {
        this.bidderName = bidderName;
    }

    public RichInputText getBidderName() {
        return bidderName;
    }

    public void setRemarks(RichInputText remarks) {
        this.remarks = remarks;
    }

    public RichInputText getRemarks() {
        return remarks;
    }

    public void setBidDate(RichInputDate bidDate) {
        this.bidDate = bidDate;
    }

    public RichInputDate getBidDate() {
        return bidDate;
    }

    public void setScrapDate(RichInputDate scrapDate) {
        this.scrapDate = scrapDate;
    }

    public RichInputDate getScrapDate() {
        return scrapDate;
    }
}
