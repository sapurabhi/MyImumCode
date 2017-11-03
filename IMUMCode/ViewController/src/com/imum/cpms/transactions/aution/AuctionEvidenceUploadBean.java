package com.imum.cpms.transactions.aution;

import com.imum.cpms.model.transactions.vo.PVTHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVORowImpl;
import com.imum.cpms.util.FileUpload;
import com.imum.cpms.util.MessageUtil;

import com.imum.ws.Auction.AuctionApprovalBPMProcessPortType;
import com.imum.ws.Auction.AuctionApprovalBPMProcessService;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class AuctionEvidenceUploadBean {
    private RichPanelGroupLayout pg11;
    private RichCommandButton submitBtnTop;
    private RichCommandButton cancelBtnTop;
    private RichInputText auctionBatchID;
    private java.util.Date currentDate = getCurrentDate();
    private RichPanelGroupLayout autionEvidenceSearchForm;
    private RichPanelGroupLayout autionEvidenceSearchSelectForm;
    private RichTable auctionEvidenceSearchResultTable;
    private RichSelectBooleanCheckbox auctionEvidenceSearchSelectFlag;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    DCBindingContainer bindingsAM =
        (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger =
        ADFLogger.createADFLogger(AutionInitiationBean.class);
    MessageUtil genMsg = new MessageUtil();
    private RichCommandButton submitBtn;
    private RichCommandButton cancelBtn;
    private RichPanelGroupLayout auctionEvidenceTopToolbarForm;
    private RichPanelGroupLayout auctionEvidenceTopSearchForm;
    private RichCommandButton auctionIDSearch;
    private HtmlInputHidden pvtSearchSelectedValue;
    private BigDecimal pvtHdrSeqUpload;
    private RichTable docTable;
    private Row currentAttchmtRow = null;
    public static DateFormat OUT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    String lgCode = httpSession.getAttribute("language").toString();
    private HtmlInputHidden searchClickedCheck;
    private int pvthdr;
    

    public AuctionEvidenceUploadBean() {
        if (lgCode == null || lgCode.equals("")) {
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
        
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        // Add event code here...
        String errorCheck="false";
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                 "Auction Initiation Documents Upload Successfully",null));
        pvtSearchSelectedValue.setValue("");
        cancelAction();
        return null;
    }
    
    public void createNewRowDocUploadMethod() {               
        BindingContainer bindingsxec = getBindings();
        OperationBinding operationBinding = bindingsxec.getOperationBinding("createDocUploadAuctionEvidence"); 
        operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
        operationBinding.execute();
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
        getAuctionEvidenceTopSearchForm().setVisible(true);
        getAutionEvidenceSearchSelectForm().setVisible(false);
        getAutionEvidenceSearchForm().setVisible(true);
        getAuctionIDSearch().setVisible(true);
        getSubmitBtn().setVisible(false);
        getCancelBtn().setVisible(false);
        getSubmitBtnTop().setVisible(false);
        getCancelBtnTop().setVisible(false);
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

    public void setAuctionBatchID(RichInputText auctionBatchID) {
        this.auctionBatchID = auctionBatchID;
    }

    public RichInputText getAuctionBatchID() {
        return auctionBatchID;
    }


    /**
     * Get Current Date
     * @return
     */
     public java.util.Date getCurrentDate(){
         logger.info("Start getCurrentDate Method of PISpvsrMapMBean ");
         SimpleDateFormat stf = new SimpleDateFormat("dd-MM-yyyy");
         java.util.Date curDate = new java.util.Date();
         try {
             curDate = stf.parse(stf.format(curDate).toString());
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return curDate;
     }

    public String searchAuctionPvts() {
        try {
            // Add event code here...
            BigDecimal auctionHeaderseq =
                (BigDecimal)getAuctionBatchID().getValue();
            if (auctionHeaderseq != null) {
                OperationBinding operationBinding =
                    bindings.getOperationBinding("getAuctionEvidenceSearchPvtDetails");
                operationBinding.getParamsMap().put("auctionHeaderseq",
                                                    auctionHeaderseq);
                String selectedResult = (String)operationBinding.execute();
                if (selectedResult.equals("success")) {
                    searchClickedCheck.setValue(true);
                    getAutionEvidenceSearchForm().setVisible(true);
                    getAutionEvidenceSearchSelectForm().setVisible(false);
                    getAuctionEvidenceTopSearchForm().setVisible(true);
                    getAuctionIDSearch().setVisible(true);
                    getSubmitBtn().setVisible(false);
                    getSubmitBtnTop().setVisible(false);
                    getCancelBtn().setVisible(false);
                    getCancelBtnTop().setVisible(false);
                
                }else if(selectedResult.equals("other")){
                
                    searchClickedCheck.setValue(false);
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  "Auction Batch ID Status is Not Valid",
                                                                                  null));
                    getAutionEvidenceSearchForm().setVisible(false);
                    getAuctionEvidenceTopSearchForm().setVisible(true);
                    getAutionEvidenceSearchSelectForm().setVisible(false);
                    getAuctionIDSearch().setVisible(true);
                    getSubmitBtn().setVisible(false);
                    getSubmitBtnTop().setVisible(false);
                    getCancelBtn().setVisible(false);
                    getCancelBtnTop().setVisible(false);
                    
                }else {
                    searchClickedCheck.setValue(false);
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  "Please Enter Valid Auction Batch ID",
                                                                                  null));
                    getAutionEvidenceSearchForm().setVisible(false);
                    getAuctionEvidenceTopSearchForm().setVisible(true);
                    getAutionEvidenceSearchSelectForm().setVisible(false);
                    getAuctionIDSearch().setVisible(true);
                    getSubmitBtn().setVisible(false);
                    getSubmitBtnTop().setVisible(false);
                    getCancelBtn().setVisible(false);
                    getCancelBtnTop().setVisible(false);
                }
            } else {
                searchClickedCheck.setValue(false);
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Please Enter Auction Batch ID",
                                                                              null));
                getAutionEvidenceSearchForm().setVisible(false);
                getAuctionEvidenceTopSearchForm().setVisible(true);
                getAutionEvidenceSearchSelectForm().setVisible(false);
                getAuctionIDSearch().setVisible(true);
                getSubmitBtn().setVisible(false);
                getSubmitBtnTop().setVisible(false);
                getCancelBtn().setVisible(false);
                getCancelBtnTop().setVisible(false);
            }
        } catch (Exception e) {
            searchClickedCheck.setValue(false);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          "Please Enter Valid Auction Batch ID",
                                                                          null));

        }
        return null;
    }

    

    public void setAutionEvidenceSearchForm(RichPanelGroupLayout autionEvidenceSearchForm) {
        this.autionEvidenceSearchForm = autionEvidenceSearchForm;
    }

    public RichPanelGroupLayout getAutionEvidenceSearchForm() {
        return autionEvidenceSearchForm;
    }

    public void auctionIDChange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        getAutionEvidenceSearchForm().setVisible(false);
        searchClickedCheck.setValue("false");
        
    }

    public void setAuctionEvidenceSearchResultTable(RichTable auctionEvidenceSearchResultTable) {
        this.auctionEvidenceSearchResultTable =
                auctionEvidenceSearchResultTable;
    }

    public RichTable getAuctionEvidenceSearchResultTable() {
        return auctionEvidenceSearchResultTable;
    }

    public void setAuctionEvidenceSearchSelectFlag(RichSelectBooleanCheckbox auctionEvidenceSearchSelectFlag) {
        this.auctionEvidenceSearchSelectFlag = auctionEvidenceSearchSelectFlag;
    }

    public RichSelectBooleanCheckbox getAuctionEvidenceSearchSelectFlag() {
        return auctionEvidenceSearchSelectFlag;
    }

    public void auctionEvidenceSearchSelectFlagListener(ActionEvent valueChangeEvent) {
        // Add event code here...dfgsdf
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        DCIteratorBinding dcItterator =
            bindingsAM.findIteratorBinding("AuctionEvidenceSearchVO1Iterator");
        ViewObjectImpl invDetailVO =
            (ViewObjectImpl)dcItterator.getViewObject();
        Row row = invDetailVO.getCurrentRow();
        System.out.println("PVT Number ::" + row.getAttribute("PVTNum"));
        invDetailVO.clearCache();
        invDetailVO.executeEmptyRowSet();
        invDetailVO.insertRow(row);
        pvtSearchSelectedValue.setValue(row.getAttribute("PVTNum"));
        if(row.getAttribute("PVTHDRSEQ")!=null) {
            pvthdr=Integer.parseInt(row.getAttribute("PVTHDRSEQ").toString());
            DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding pvtheader = bindings1.findIteratorBinding("PVTHeaderVO1Iterator");
            PVTHeaderVOImpl pvtHeaderVO =(PVTHeaderVOImpl)pvtheader.getViewObject();
            //   PVTHeaderVOImpl pvtHeaderVO = (PVTHeaderVOImpl)getPVTHeaderVO1();df
                        pvtHeaderVO.setWhereClause(null);
                        pvtHeaderVO.setWhereClause("PVT_HDR_SEQ = " + pvthdr);
                        pvtHeaderVO.executeQuery();
                        Row pvtHeaderVORow = pvtHeaderVO.first(); 
                        pvtHeaderVORow.setAttribute("PVTSTAGEID",24);
                        pvtHeaderVORow.setAttribute("Updatedby",httpSession.getAttribute("loggedinUserid").toString());
                        pvtHeaderVORow.setAttribute("Updateddate",sqlDate);
        }
        
        row.setAttribute("SelectFlag", true);
        createNewRowDocUploadMethod();
        getAuctionEvidenceTopSearchForm().setVisible(false);
        getAutionEvidenceSearchSelectForm().setVisible(true);
        getAutionEvidenceSearchForm().setVisible(false);
        getSubmitBtn().setVisible(true);
        getCancelBtn().setVisible(true);
        getAuctionIDSearch().setVisible(false);
        getSubmitBtnTop().setVisible(true);
        getCancelBtnTop().setVisible(true);
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
                        fl.uploadFilesToFolder("1", "PVT", getPvtSearchSelectedValue().getValue().toString(),
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
        if (headerPvtVO != null && getPvtSearchSelectedValue() != null) {
            headerPvtVO.setWhereClause(null);
            headerPvtVO.setWhereClause("PVT_Num = '" +
                                       getPvtSearchSelectedValue().getValue() + "'");
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

    public void setAutionEvidenceSearchSelectForm(RichPanelGroupLayout autionEvidenceSearchSelectForm) {
        this.autionEvidenceSearchSelectForm = autionEvidenceSearchSelectForm;
    }

    public RichPanelGroupLayout getAutionEvidenceSearchSelectForm() {
        return autionEvidenceSearchSelectForm;
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

    public void setAuctionEvidenceTopToolbarForm(RichPanelGroupLayout auctionEvidenceTopToolbarForm) {
        this.auctionEvidenceTopToolbarForm = auctionEvidenceTopToolbarForm;
    }

    public RichPanelGroupLayout getAuctionEvidenceTopToolbarForm() {
        return auctionEvidenceTopToolbarForm;
    }

    public void setAuctionEvidenceTopSearchForm(RichPanelGroupLayout auctionEvidenceTopSearchForm) {
        this.auctionEvidenceTopSearchForm = auctionEvidenceTopSearchForm;
    }

    public RichPanelGroupLayout getAuctionEvidenceTopSearchForm() {
        return auctionEvidenceTopSearchForm;
    }

    public void setAuctionIDSearch(RichCommandButton auctionIDSearch) {
        this.auctionIDSearch = auctionIDSearch;
    }

    public RichCommandButton getAuctionIDSearch() {
        return auctionIDSearch;
    }

    public void setPvtSearchSelectedValue(HtmlInputHidden pvtSearchSelectedValue) {
        this.pvtSearchSelectedValue = pvtSearchSelectedValue;
    }

    public HtmlInputHidden getPvtSearchSelectedValue() {
        return pvtSearchSelectedValue;
    }

    public String AssignAuctionHouse() {
        // Add event code here...
        return null;
    }

    public void dialogListener(DialogEvent dialogEvent) {
        long l1;
        if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.yes)) {
            System.out.println("Please confirm to Processed");
            String searchClickedCheckValue = searchClickedCheck.getValue().toString();
            System.out.println("searchClickedCheck ::"+searchClickedCheckValue);
            if(searchClickedCheckValue.equalsIgnoreCase("false")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              "Enter and Click on search with Valid Auction Batch ID",
                                                                              null));
                
            }else{
                BigDecimal auctionHeaderseq =(BigDecimal)getAuctionBatchID().getValue();
                System.out.println(auctionHeaderseq);
                OperationBinding operationBinding =bindings.getOperationBinding("saveAuctionEvidenceDetails");
                operationBinding.getParamsMap().put("auctionHeaderseq",auctionHeaderseq);
                operationBinding.getParamsMap().put("updatedDate", new java.sql.Date(new java.util.Date().getTime()));
                operationBinding.getParamsMap().put("updatedby",httpSession.getAttribute("loggedinUserid").toString());
                String selectedResult = (String)operationBinding.execute();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Assigned to Auction House Successfully",null));
                System.out.println("Success Assigned to Aution House");
                searchClickedCheck.setValue(false);
                getAutionEvidenceSearchForm().setVisible(false);
                getAuctionEvidenceTopSearchForm().setVisible(true);
                getAutionEvidenceSearchSelectForm().setVisible(false);
                getAuctionIDSearch().setVisible(true);
                getSubmitBtn().setVisible(false);
                getSubmitBtnTop().setVisible(false);
                getCancelBtn().setVisible(false);
                getCancelBtnTop().setVisible(false);
               


                
                
                
                
                
                
            }
        }
    }

    public void setDocTable(RichTable docTable) {
        this.docTable = docTable;
    }

    public RichTable getDocTable() {
        return docTable;
    }

    public void setSearchClickedCheck(HtmlInputHidden searchClickedCheck) {
        this.searchClickedCheck = searchClickedCheck;
    }

    public HtmlInputHidden getSearchClickedCheck() {
        return searchClickedCheck;
    }

    public void setPvthdr(int pvthdr) {
        this.pvthdr = pvthdr;
    }

    public int getPvthdr() {
        return pvthdr;
    }
}
