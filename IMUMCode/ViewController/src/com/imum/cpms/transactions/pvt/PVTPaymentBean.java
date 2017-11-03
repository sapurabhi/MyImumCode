package com.imum.cpms.transactions.pvt;


import com.imum.cpms.model.transactions.am.TransactionsAMImpl;
import com.imum.cpms.model.transactions.vo.BulkCardsInstVORowImpl;
import com.imum.cpms.model.transactions.vo.CardIssueSrchCriVORowImpl;


import com.imum.cpms.model.transactions.vo.CardsInputFieldsVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTChargeDetailRVOImpl;
import com.imum.cpms.model.transactions.vo.PVTDocsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVOImpl;

import com.imum.cpms.model.transactions.vo.PVTHeaderVORowImpl;

import com.imum.cpms.model.transactions.vo.PVTSearchRVOImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVOImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesDetailUVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesHeaderUVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesSettlementUVORowImpl;

import com.imum.cpms.util.FileUpload;

import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import java.sql.Array;
import java.sql.Date;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCDataControl;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichColumn;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.RowSetIterator;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class PVTPaymentBean {


    private RichInputText closeRemarks;
    private RichCommandButton submitButton;
    private RichCommandButton cancelButton;
   // private RichInputFile uploadButton;
    private RichCommandButton releaseVehicleBT;
    private RichPanelFormLayout panelFormUpload;
    private RichPanelGroupLayout knockOffCB;
    private RichPanelGroupLayout makePymntBn;
    private RichPanelGroupLayout remarksText;
    private RichPanelGroupLayout releaseCB;
    private RichSelectOneChoice ccdType;
    private RichTable selectedtable;


    public PVTPaymentBean() {
        if(lngCode==null || lngCode.equals(""))
               {
                   lngCode = "EN";
               }
    }
    private BigDecimal conventionFee;  
    private BigDecimal discountOmConv;
    private BigDecimal PayableAmt;
    private BigDecimal paid;
    private BigDecimal removalCharge = null;
    private BigDecimal clampingCharge = null;
    private BigDecimal poundCharge = null;
    private BigDecimal outStandingAmt = null;
    private BigDecimal adjustmentAmt=null;
    List<UploadedFile> uploadedFiles;
    private RichColumn chequeNumCol;
    private RichColumn chequeBnkCol;
    private RichColumn chequeDateCol;
    private RichColumn creditCardTypeCol;
    private RichColumn creditCardNumCol;
    private RichColumn authCodeCol;
    private RichPanelGroupLayout paymentboxrender;
    private Boolean hide;
    private ArrayList pvtNumList;
    private BigDecimal pvtCustomerId = new BigDecimal(0);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    private RichCommandButton sendApprovalBT;
    private RichCommandButton makePaymentBT;
    private RichInputText knockAMT;
    private Boolean knockOffCheck;
    private Boolean vehicleCheck=false;
    private Boolean paidFully=false;
    private Boolean releaseCheckBox=false;
    private Boolean hidePVTDetails;
    private BigDecimal enterKnockOff;
    private String enterRemarks;
    private String paidFullVrelease=null;
    private boolean knockCheckValue = false;
    
    private ArrayList pvtcheckBackSelection=null;
    private String pvtNumforUpload=null;
    private Boolean backButtonSelect=false;
    private ArrayList listReleaseCheck=null;
    private int enforceReleaseCheck=0;
    public static final ADFLogger logger = ADFLogger.createADFLogger(PVTPaymentBean.class);
    private Boolean paymentDocsuploadForm=false;
    private boolean releaseCheckBoxValue=false;
    private boolean enableBackReleaseCB=false;
    private Row currentAttchmtRow=null;
    private RichTable docTable;
    private BigDecimal pvtHdrSeqUpload;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    

    public String getPVTDetails(SelectionEvent selectionEvent) {
              
            setHidePVTDetails(true);
            releaseVehicleBT.setVisible(false);
            knockOffCB.setVisible(Boolean.FALSE);
            makePymntBn.setVisible(Boolean.FALSE);
            remarksText.setVisible(Boolean.FALSE);
            releaseCB.setVisible(Boolean.FALSE);
            ADFUtil.invokeEL("#{bindings.PVTSearchRVO2.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
            // get the selected row , by this you can get any attribute of that row
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTSearchRVO2Iterator.currentRow}"); //
                   DCBindingContainer bindings =
                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                       DCIteratorBinding dcItteratorBindingsHeader1 = bindings.findIteratorBinding("PVTSearchRVO2Iterator");
                       ViewObject serach2VO = dcItteratorBindingsHeader1.getViewObject();
                       PVTSearchRVOImpl pvtSearchVo = (PVTSearchRVOImpl)serach2VO;
                       VariableValueManager variableValueManger = pvtSearchVo.ensureVariableManager();
                       String pvtNumber = (String)variableValueManger.getVariableValue("bindPVTNumber");
                       String plateNumber = (String)variableValueManger.getVariableValue("bindPlateNumber");
                       logger.info("Bind Value pvtNumber======================="+pvtNumber);
                       logger.info("Bind Value plateNumber======================="+plateNumber);
                       logger.info("Seletec plateId Number   ::::::   " +selectedRow.getAttribute("PlateId"));
                        Integer plateId = (Integer)selectedRow.getAttribute("PlateId"); 
          
                    DCIteratorBinding dcItteratorBindingsHeader = bindings.findIteratorBinding("PVTHeaderVO1Iterator");
                   ViewObject hedaerVo = dcItteratorBindingsHeader.getViewObject();
                   PVTHeaderVOImpl pvtHeaderVo = (PVTHeaderVOImpl)hedaerVo;
                   pvtHeaderVo.clearCache();
                  String paymentSearchWhereClause="";
                  
              if ( pvtHeaderVo!= null) {
                   paymentSearchWhereClause = paymentSearchWhereClause + " PVT_Status_ID = '"+1+"'";
                
                if(pvtNumber !=null) {
                   paymentSearchWhereClause = paymentSearchWhereClause +" AND PVT_Num = '"+pvtNumber+"'";
                }
                if(plateNumber !=null) {
                   paymentSearchWhereClause = paymentSearchWhereClause +" AND Plate_Id = '"+plateId+"'";
                }
                logger.info("paymentSearchWhereClause Query :::::::::::::::::     "+paymentSearchWhereClause);
                System.out.println("Headrs Row Selection Query  :::::::::::::::    "+paymentSearchWhereClause);
                pvtHeaderVo.setWhereClause(null);
                pvtHeaderVo.setWhereClause(paymentSearchWhereClause);
                System.out.println("Total Query :::::::::::::::  "+pvtHeaderVo.getQuery());
                pvtHeaderVo.executeQuery();
            }
                  
           return null;
        }

    public String getPVTAmountDetails(ActionEvent actionEvent) {
                enforceReleaseCheck=0;
                String validation ="pass";
                knockOffCB.setVisible(Boolean.TRUE);
                makePymntBn.setVisible(Boolean.TRUE);
                remarksText.setVisible(Boolean.TRUE);
                clampingCharge = new BigDecimal(0);
                adjustmentAmt = new BigDecimal(0);
                poundCharge = new BigDecimal(0);
                removalCharge = new BigDecimal(0);
                conventionFee  = new BigDecimal(0);
                discountOmConv  = new BigDecimal(0);
                PayableAmt  = new BigDecimal(0);
                paid  = new BigDecimal(0);
                //setReleaseCheckBox(false);
                releaseCB.setVisible(Boolean.FALSE);
                setKnockCheckValue(false);
                setBackButtonSelect(Boolean.FALSE);
                setEnableBackReleaseCB(Boolean.FALSE);
                knockAMT.setVisible(false);
                makePaymentBT.setVisible(true);
                makePaymentBT.setDisabled(false);
                panelFormUpload.setVisible(Boolean.FALSE);
                makePaymentBT.setRendered(Boolean.TRUE);
                listReleaseCheck = new ArrayList();
                PVTDocsVOImpl pvtDocImpl = (PVTDocsVOImpl)this.getTRansactionModule().getPVTDocsVO1();
                   if(pvtDocImpl!=null) {
                       pvtDocImpl.clearCache();
                       pvtDocImpl.executeEmptyRowSet();
                     }    
                          
                DCBindingContainer bindings =
                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindings =
                    bindings.findIteratorBinding("PVTHeaderVO1Iterator");
           
           
           PVTDocsVOImpl pvtDocsImpl = (PVTDocsVOImpl)getTRansactionModule().getPVTDocsVO1();
           if(pvtDocsImpl!=null) {
             int docsCount =  pvtDocsImpl.getRowCount();
             System.out.println("docsCount::"+docsCount);
             if(docsCount!=0){
                 OperationBinding operationBinding = bindings.getOperationBinding("uploadDelete"); 
                 operationBinding.execute();       
             }
           }
                
               
                ViewObject voTableData = dcItteratorBindings.getViewObject();
                Row rowSelected = voTableData.getCurrentRow();    
                if(rowSelected==null) {
                    validation="fail";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample ino message", genMsg.getMessage("103", lngCode)));
                    return validation;
                }
                
                setPvtCustomerId((BigDecimal)rowSelected.getAttribute("CustID"));
                
                Row[] rows = voTableData.getAllRowsInRange();
                int pvtSelectCount =0;
                
                
             for(int i =0;i<rows.length ; i++ ){
                Boolean checkValue =  (Boolean)rows[i].getAttribute("CheckFlagBox");
                Integer stageId=(Integer)rows[i].getAttribute("PVTSTAGEID");
                Integer enforceStageId=(Integer)rows[i].getAttribute("ENFORCESTAGEID");
                if(checkValue!=null && checkValue) {
                    if(enforceStageId != null && enforceStageId==12) {
                        setPvtNumforUpload((String)rows[i].getAttribute("PVTNum"));
                        enforceReleaseCheck++;
                    }
                    if((stageId!=null && enforceStageId!=null)&& ((stageId == 10 && enforceStageId == 12 ) ||(stageId == 8 && enforceStageId == 12))){
                        //setReleaseCheckBox(true);
                        releaseCB.setVisible(Boolean.TRUE);
                        setPvtNumforUpload((String)rows[i].getAttribute("PVTNum"));
                        setPaidFully(true);
                    }  
                    pvtSelectCount++;
                }
            }
             if(pvtSelectCount==0) {
                 validation="fail";
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("103", lngCode)));   
                 return validation;
             }
             
        //calling Stroed Procedure inside the function
        this.callProcedureUpdatatingtheCharges();
                
             ArrayList pvtNumListForSaleDetail = new ArrayList();
           for(int i =0;i<rows.length ; i++ ){
            
            Boolean checkValue =  (Boolean)rows[i].getAttribute("CheckFlagBox");
            String pvtNum =  (String)rows[i].getAttribute("PVTNum");
           if(checkValue!=null && checkValue) {
               logger.info("After checkValue ===============            "+checkValue);
                BindingContainer bindings1 = getBindings();
                OperationBinding opBinding = bindings.getOperationBinding("getSeqPVTPayMents");
                opBinding.getParamsMap().put("pvtNo", pvtNum);
                opBinding.execute();
                String pvtHdrSeq = (String)opBinding.getResult();
                pvtNumListForSaleDetail.add(pvtHdrSeq);  
                 BigDecimal  PVTHDRSEQ =  (BigDecimal)rows[i].getAttribute("PVTHDRSEQ");
                listReleaseCheck.add(PVTHDRSEQ);
                logger.info("Seq Value====================" + pvtHdrSeq);
             if (pvtHdrSeq != null) {
                DCIteratorBinding dcItteratorBindingsCharge =
                bindings.findIteratorBinding("PVTChargeDetailRVO1Iterator");
                ViewObject chargeVo = dcItteratorBindingsCharge.getViewObject();
                PVTChargeDetailRVOImpl pvtChargeVo = (PVTChargeDetailRVOImpl)chargeVo;
            if (pvtChargeVo != null) {
                pvtChargeVo.setWhereClause(null);
                pvtChargeVo.setWhereClause("PVT_HDR_SEQ = '" + pvtHdrSeq + "'");
                pvtChargeVo.executeQuery();
                logger.info("getCount..." + pvtChargeVo.getRowCount());
                int rowCount = pvtChargeVo.getRowCount();
                RowSetIterator paymentIterator =pvtChargeVo.createRowSetIterator(null);
            while (paymentIterator.hasNext()) {
                Row paymentRow = paymentIterator.next();
                logger.info("Filterd Emploee ID  :::::::::::::::::::::::" + paymentRow.getAttribute("ChargeType"));

          if (paymentRow != null) {
             int chargeType =  (Integer)paymentRow.getAttribute("ChargeType");
          if (chargeType == 1) {
                 removalCharge =  removalCharge.add((BigDecimal)paymentRow.getAttribute("ChargeAmount"));
            } else if (chargeType == 2) {
              clampingCharge = clampingCharge.add((BigDecimal)paymentRow.getAttribute("ChargeAmount"));
            } else if (chargeType == 3) {
                 poundCharge =  poundCharge.add((BigDecimal)paymentRow.getAttribute("ChargeAmount"));
            }
            else if (chargeType == 5) {
                     adjustmentAmt =  adjustmentAmt.add((BigDecimal)paymentRow.getAttribute("ChargeAmount"));
                }
               }
            }
          }
            logger.info("removalCharge ======  " + removalCharge);
            logger.info("clampingCharge ====" + clampingCharge);
            logger.info("poundCharge  ====  " + poundCharge);
             logger.info("adjustmentAmt  ====  " + adjustmentAmt);
             if(rows[i].getAttribute("CONTRAAMT")!=null) {             
                conventionFee =  conventionFee.add((BigDecimal)rows[i].getAttribute("CONTRAAMT"));
                }
              if(rows[i].getAttribute("Discountamt")!=null){
                 discountOmConv =  discountOmConv.add((BigDecimal)rows[i].getAttribute("Discountamt"));
                }
              if(rows[i].getAttribute("PVTAMTPAYABLE")!=null){
                 PayableAmt =  PayableAmt.add((BigDecimal)rows[i].getAttribute("PVTAMTPAYABLE"));
                }
              if(rows[i].getAttribute("PVTAMTPAID")!=null)
                {
                 paid =  paid.add((BigDecimal)rows[i].getAttribute("PVTAMTPAID"));
                }
            logger.info("CON AMT ======  " + conventionFee);
            logger.info("Doscoumnt ====" + discountOmConv);
            logger.info("Pay  ====  " + PayableAmt);
            logger.info("Paid ===  " + paid);
            setConventionFee(conventionFee);
            setDiscountOmConv(discountOmConv);
            setPayableAmt(PayableAmt);
            setPaid(paid);
//        if(paid==null) {
//             setOutStandingAmt(PayableAmt.subtract(new BigDecimal(0)));
//           }else {
//          setOutStandingAmt(PayableAmt.subtract(paid)); 
//          }
           setOutStandingAmt(PayableAmt);
         }           
               
               if(PayableAmt!=null && ! PayableAmt.equals(new BigDecimal(0))){
                   makePymntBn.setVisible(Boolean.TRUE);        
               }             
        Integer pvtStageId =  (Integer)rows[i].getAttribute("PVTSTAGEID");
        Integer pvtEnforceId =  (Integer)rows[i].getAttribute("ENFORCESTAGEID");
         //pvtStageId=8;
         // pvtEnforceId=11;
         logger.info("pvtStageId Value ======================="+pvtStageId);
         logger.info("pvtEnforceId Value ======================="+pvtEnforceId);
          if(pvtStageId!=null && pvtEnforceId!=null )
        {
            Integer  outStandingAmtValue =Integer.valueOf(outStandingAmt.intValue());
             // outStandingAmtValue =0;
           if(pvtStageId==8 && pvtEnforceId==11 && outStandingAmtValue==0 )
          {
             logger.info("Inside If       =====================================");
             // setReleaseCheckBox(true);
              setPaidFully(true);
           }
             else{
                // setReleaseCheckBox(false);
             }
            }
           }
         }
        setPvtNumList(pvtNumListForSaleDetail);
        submitButton.setVisible(true);
        cancelButton.setVisible(true);
        return null;   
       }

/**
 * this method is used for uploading the doc for Write and Relese
 * coommon Fuction both functionlaties
*/
    public String  uploadDocsWriteAndRelease(BigDecimal pvtHdrSeq) {
      String validaion = "success";
      PVTDocsVOImpl pvtDocsImpl = (PVTDocsVOImpl)getTRansactionModule().getPVTDocsVO1();
        FileUpload fl = new FileUpload();
        if(pvtDocsImpl!=null) {
          int docsCount =  pvtDocsImpl.getRowCount();
          
          for(int i=0;i<docsCount; i++) {
               // String uploadPath =  "D://Files//PVT//Chrysanthemum.jpg";
               String uploadPath=null;
                Row docRow = pvtDocsImpl.getRowAtRangeIndex(i);
                 org.apache.myfaces.trinidad.model.UploadedFile uploadFile = (org.apache.myfaces.trinidad.model.UploadedFile)docRow.getAttribute("FileUpload");
                  if(uploadFile!=null)
                  {
                 uploadPath = fl.uploadFilesToFolder("1", "PVT", getPvtNumforUpload(), uploadFile);
                  if(uploadPath==null) {
                      uploadPath=uploadFile.getFilename();
                  }
                  String docFielName = uploadFile.getFilename();
                  java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                  System.out.println("sqlDate in uploadPvtDocs is : "+sqlDate);
                  int documentStage=7;
                  int docType = getFileExtension(docFielName);
                  String userName = httpSession.getAttribute("loggedinUserid").toString();
                  docRow.setAttribute("CreatedBy",userName);
                  docRow.setAttribute("CreatedDate",sqlDate);
                  docRow.setAttribute("filepath",uploadPath);
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
    
        public void uploadPaymentDocsChanges(BigDecimal pvtHdrSeq) {
                                     
                    ArrayList uploadFiles =  uploadPaymentDocs();               
                    String userName = httpSession.getAttribute("loggedinUserid").toString();
                    OperationBinding opBindingDoc = getBindings().getOperationBinding("uploadPvtDocsPVTPayments");
                    opBindingDoc.getParamsMap().put("encoder",userName);
                    opBindingDoc.getParamsMap().put("uploadFiles",uploadFiles); 
                    opBindingDoc.getParamsMap().put("pvtHdrseq",pvtHdrSeq);
                    logger.info("uploadFiles size== "+uploadFiles.size());
                    opBindingDoc.execute();
                    logger.info("Successfully pvt Docs method called");
                    getBindings().getOperationBinding("commit").execute();                                 
                }
        
        public  ArrayList uploadPaymentDocs() {
            
            FileUpload fl = new FileUpload();
            String uploadPath = null;
                List<UploadedFile> uploadDocs = this.getUploadedFiles();     
            uploadPath = fl.uploadFilesToFolder("1", "PVT", getPvtNumforUpload(), uploadDocs);
              ArrayList  fileUploadList =  new ArrayList();        
            if (null != uploadDocs) {         
              for (int j = 0; j < uploadDocs.size(); j++) {
                  logger.info("Docs File Name  ::::     " + uploadDocs.get(j).getFilename());
                if(uploadPath!=null){
                  String fullPath = uploadPath+"//"+uploadDocs.get(j).getFilename();
                  logger.info("fullPath  ::::     " + fullPath);
                  fileUploadList.add(fullPath);
                  }else{
                      fileUploadList.add(uploadDocs.get(j).getFilename());
                  }
                  
              }
               
            }  
            return fileUploadList;
        }        


    public TransactionsAMImpl getTRansactionModule() {
            FacesContext context = FacesContext.getCurrentInstance();
            BindingContext bindingContext = BindingContext.getCurrent();
            DCDataControl dc =
                bindingContext.findDataControl("TransactionsAMDataControl");
            TransactionsAMImpl appM = (TransactionsAMImpl)dc.getDataProvider();
            return appM;
        }
    
    public void pymtType(ValueChangeEvent valueChangeEvent) {
        Object pymType = valueChangeEvent.getNewValue();
        if(pymType == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("104", lngCode)));
        }
        else{
            ccdType.setValue(null);
            
        }
    }
    
    public String addPVTPayment() {
        BindingContainer bindingsxec = getBindings();
        OperationBinding operationBinding = bindingsxec.getOperationBinding("addPaymentRow"); 
        //operationBinding.getParamsMap().put("encoder","vara");
        operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
        operationBinding.execute();
        return null;
    }
    
    public String makePVTPayment() {
        String validation = "success";
        knockOffCB.setVisible(Boolean.FALSE);
        makePaymentBT.setDisabled(true);
        if(getOutStandingAmt()==null) {
            validation = "fail";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("105", lngCode)));  
            return validation;
        }
        
        if(getOutStandingAmt()!=null && Integer.valueOf(getOutStandingAmt().intValue())==0) {
            validation = "fail";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("106", lngCode)));
            return validation;
        }
        
            BindingContainer bindingsxec = getBindings();
            OperationBinding operationBinding = bindingsxec.getOperationBinding("doCreatePVTPayment");
            operationBinding.getParamsMap().put("CustomerId", getPvtCustomerId()); 
            operationBinding.getParamsMap().put("paidAmt", getPaid());
            operationBinding.getParamsMap().put("outSatndingAmt", getOutStandingAmt());
            operationBinding.getParamsMap().put("pvtNumList", getPvtNumList());
            //operationBinding.getParamsMap().put("encoder","vara");
            operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
            Object result = operationBinding.execute();            
            if (operationBinding.getErrors().isEmpty()) {
                paymentboxrender.setRendered(true);
                paymentboxrender.setVisible(true);
                //submitpanel.setRendered(true);          
            }            
        return null;
        
    }
    
    public String  submitPVTpymntCharges(ActionEvent actionEvent) {
       String validation = "pass";
        if(getOutStandingAmt()==null || (!makePaymentBT.isDisabled())) {
            validation = "fail";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("107", lngCode)));
            return validation;
         }
        
//          if(getKnockOffCheck())  {
//                 uploadPaymentDocsChanges();
//          } else{
   
           java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           String result = "pass";          
               DCBindingContainer bindings = (DCBindingContainer)getBindings();
               DCIteratorBinding Payment = bindings.findIteratorBinding("SalesSettlementUVO1Iterator");
               ViewObjectImpl PaymentVO = (ViewObjectImpl)Payment.getViewObject();
               long paymentcount = PaymentVO.getEstimatedRowCount();
              
              if(paymentcount==0) {
                  validation = "fail";
                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("107", lngCode)));  
                  return validation;
              }
               if(paymentcount > 0)
                for(int i = 0;i<paymentcount;i++)
                {
                    SalesSettlementUVORowImpl paymentrow = (SalesSettlementUVORowImpl)PaymentVO.getRowAtRangeIndex(i);
                    if(paymentrow != null)
                    {
                        String PaymentType = paymentrow.getPYMTType();
                        BigDecimal paymentAmount = paymentrow.getPYMTAMT();
                        String chqBankName = paymentrow.getChqBankname();
                        Date chqDate = paymentrow.getChqDate();
                        String chqNum = paymentrow.getChqnum(); 
                        String ccdType = paymentrow.getCCDType();
                        String CreditCardNum = paymentrow.getCCDnum();
                        String AuthorizationCode = paymentrow.getAuthCode();
                        if(PaymentType != null)
                        {
                            if(paymentAmount != null)
                            {  
                                if("CCD".equals(PaymentType) ) 
                                {

                                    if(chqBankName!=null || chqDate!=null || chqNum!=null)
                                    {
                                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("108", lngCode))); 
                                         result = "fail";
                                         break;   
                                     }
                                    if(CreditCardNum == null || "".equals(CreditCardNum)) 
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("109", lngCode))); 
                                        result = "fail";
                                        break;
                                    }
                                    else if(AuthorizationCode == null || "".equals(AuthorizationCode)) 
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("110", lngCode)));  
                                        result = "fail";
                                        break; 
                                    } 
                                    else if(ccdType == null || "".equals(ccdType)) 
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("111", lngCode))); 
                                        result = "fail";
                                        break; 
                                    } 
                                }
                                if("CHQ".equals(PaymentType))
                                {
       
                                     if(CreditCardNum!=null || AuthorizationCode!=null || ccdType!=null)
                                    {
                                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("112", lngCode)));
                                         result = "fail";
                                         break;   
                                     }
                                    if( chqBankName== null || "".equals(chqBankName))
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("113", lngCode))); 
                                        result = "fail";
                                        break;  
                                    }
                                    else if( chqDate == null || "".equals(chqDate))
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("114", lngCode)));
                                        result = "fail";
                                        break;  
                                    }
                                    else if(chqNum == null || "".equals(chqNum))
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("115", lngCode)));
                                        result = "fail";
                                        break;     
                                    }
                                } 
                                if("CSH".equals(PaymentType))
                                {
                                    if(CreditCardNum!=null || AuthorizationCode!=null || ccdType!=null)
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("116", lngCode))); 
                                        result = "fail";
                                        break;   
                                    }
                                    if(chqBankName!=null || chqDate!=null || chqNum!=null)
                                    {
                                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("117", lngCode))); 
                                         result = "fail";
                                         break;   
                                     }
                                }
                            }
                            else
                            {
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("118", lngCode)));
                                result = "fail"; 
                                break;  
                            }                     
                        }
                        else
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("119", lngCode))); 
                            result = "fail";    
                            break;  
                        }
                         
                    }   
               }
            
               if(result == "fail"){
                   validation = "fail";
                  return validation; 
               }
               

           BigDecimal totalamountbig = getOutStandingAmt();
           Integer totamount = Integer.valueOf(totalamountbig.intValue());
           logger.info("totalOutstandingAmount"+totamount);
           BigDecimal totalAmountPaying = totalPaymentamountAction();
           Integer totamountpaying = Integer.valueOf(totalAmountPaying.intValue());
           logger.info("totamountPVTpaying..." + totamountpaying);
           String paid = null;
           if(totamount.equals(totamountpaying))
           {
              paid = "true";
              result=updatePVTStageAndAmount(totalamountbig,totalAmountPaying,paid); 
              setPaidFully(true);
              
           }else if(totamountpaying<totamount){
               paid = "false";
              result=updatePVTStageAndAmount(totalamountbig,totalAmountPaying,paid);
               setPaidFully(false);
           }else{
               setPaidFully(false);
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("120", lngCode)));
               result = "fail";                  
           }
              
               if("pass".equalsIgnoreCase(result))
               {
                   //Setting Sale Amount(i.e.,  Total Paying Amount value) inn Sales Header
                   DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
                   DCIteratorBinding saleHeaderPvt =
                       bindingsAM.findIteratorBinding("SalesHeaderUVO1Iterator");
                   ViewObjectImpl saleHeaderPvtVO = (ViewObjectImpl)saleHeaderPvt.getViewObject();
                   
                   SalesHeaderUVORowImpl rowImpl = (SalesHeaderUVORowImpl)saleHeaderPvtVO.getCurrentRow();
                   if(rowImpl!=null){
                       rowImpl.setSaleAmt(totalAmountPaying);
                   }
                   
                   BindingContainer bindingsxec = getBindings(); 
                   OperationBinding operationBinding = bindingsxec.getOperationBinding("commit");
                   operationBinding.execute();
                   if (operationBinding.getErrors().isEmpty()) {            
                    
                       BigDecimal saleHdrSeq = getSaleHdrSequence();
                       logger.info("saleHdrSeq from SaleHdr::"+saleHdrSeq);
                       PrintReceipt(saleHdrSeq); 
                       //Reset_Action();
                      // cancelAction();
                      // rollback();
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("121", lngCode)));
                       FacesContext context = FacesContext.getCurrentInstance(); 
                       context.getApplication().getNavigationHandler().handleNavigation(context,null,"Success");
                   }    else {
                           rollback();
                     }
               }
      // }
             return null;
    }
    public String updatePVTStageAndAmount(BigDecimal totalamountbig,BigDecimal totalAmountPaying,String paid) {
        
        pvtcheckBackSelection = new ArrayList();
        DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
        DCIteratorBinding headerPvt =
            bindingsAM.findIteratorBinding("PVTHeaderVO1Iterator");
        ViewObjectImpl headerPvtVO = (ViewObjectImpl)headerPvt.getViewObject();
        long countheaderPvt = headerPvtVO.getEstimatedRowCount();
        logger.info("countheaderPvt Value ============="+countheaderPvt);
        Integer totamount = Integer.valueOf(totalAmountPaying.intValue());
        Row[] rowsPVT = headerPvtVO.getAllRowsInRange();
        BindingContainer bindings1 = getBindings();
        Integer pymntAmntVar = totamount;
        for(int i =0;i<rowsPVT.length ; i++ ){         
         Boolean checkValue =  (Boolean)rowsPVT[i].getAttribute("CheckFlagBox");
        
            if(checkValue!=null && checkValue){
                Integer enforceStage = (Integer) rowsPVT[i].getAttribute("ENFORCESTAGEID");   
                BigDecimal headerPVTAmt = (BigDecimal)rowsPVT[i].getAttribute("PVTAMTPAYABLE");
                Integer headerPVTAmtInt = Integer.valueOf(headerPVTAmt.intValue());
                PVTHeaderVORowImpl rowImpl = (PVTHeaderVORowImpl) rowsPVT[i];
                BigDecimal pvtHeaderSeq = rowImpl.getPVTHDRSEQ();
                logger.info("pvtHeaderSeq Value in pvtHeader for loop============="+pvtHeaderSeq);
                updateSalesDetailWithPaidAmnt(pvtHeaderSeq,headerPVTAmtInt,totamount,paid);

                //If FullPaid                
                if(paid!=null && "true".equalsIgnoreCase(paid)){
               //   rowImpl.setPVTAMTPAYABLE(new BigDecimal(0));
               //calling Procedure for updating the payable amount
               logger.info("Paid Successfull    ===============   "+pvtHeaderSeq);
               pvtcheckBackSelection.add(pvtHeaderSeq);
               OperationBinding opBinding = bindings1.getOperationBinding("PVTupdatePaymentDetails");
               opBinding.getParamsMap().put("pvtHdrSeq", pvtHeaderSeq);
               opBinding.getParamsMap().put("payableAmt",headerPVTAmt);
               opBinding.execute();
                    rowImpl.setPVTSTAGEID(8);
                   if(enforceStage ==null || enforceStage != 12) 
                   {
                       rowImpl.setPVTStatusID(2);
                   }
                }
                //If it is partially paid
                if(paid!=null && "false".equalsIgnoreCase(paid) && pymntAmntVar!=0){
                    if(headerPVTAmtInt < pymntAmntVar){                    
                    // rowImpl.setPVTAMTPAYABLE(new BigDecimal(0));
                    //calling Procedure for updating the payable amount
                    OperationBinding opBinding = bindings1.getOperationBinding("PVTupdatePaymentDetails");
                    opBinding.getParamsMap().put("pvtHdrSeq", pvtHeaderSeq);
                    opBinding.getParamsMap().put("payableAmt", headerPVTAmt);
                    opBinding.execute();
                        if(enforceStage ==null || enforceStage != 12) 
                        {
                           rowImpl.setPVTStatusID(2);
                        }
                        rowImpl.setPVTSTAGEID(8);
                        pymntAmntVar = pymntAmntVar-headerPVTAmtInt;
                    }else if(headerPVTAmtInt > pymntAmntVar){                   
                       // rowImpl.setPVTAMTPAYABLE(new BigDecimal(headerPVTAmtInt-pymntAmntVar));
                       OperationBinding opBinding = bindings1.getOperationBinding("PVTupdatePaymentDetails");
                       opBinding.getParamsMap().put("pvtHdrSeq", pvtHeaderSeq);
                       opBinding.getParamsMap().put("payableAmt",new BigDecimal(pymntAmntVar));
                       opBinding.execute();
                        rowImpl.setPVTSTAGEID(7);
                        pymntAmntVar = pymntAmntVar-headerPVTAmtInt;
                        break;
                    }else{
                       // rowImpl.setPVTAMTPAYABLE(new BigDecimal(0));
                       OperationBinding opBinding = bindings1.getOperationBinding("PVTupdatePaymentDetails");
                       opBinding.getParamsMap().put("pvtHdrSeq", pvtHeaderSeq);
                       opBinding.getParamsMap().put("payableAmt",headerPVTAmt);
                        opBinding.execute();
                        if(enforceStage ==null || enforceStage != 12) 
                        {
                            rowImpl.setPVTStatusID(2);
                        }
                        rowImpl.setPVTSTAGEID(8);
                        pymntAmntVar = 0;
                    } 
                }
               
            }
        }
        return "pass";
    }
    
    
 /**
     *updating sales Details
     * @param pvtHeaderSeq
     * @param headerPVTAmtInt
     * @param totamount
     * @param paid
     */

    public void updateSalesDetailWithPaidAmnt(BigDecimal pvtHeaderSeq,Integer headerPVTAmtInt,Integer totamount,String paid){
        DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
        DCIteratorBinding salesDetail =
            bindingsAM.findIteratorBinding("SalesDetailUVO1Iterator");
        ViewObjectImpl salesDetailVO = (ViewObjectImpl)salesDetail.getViewObject();
        int countSalesDetail = salesDetailVO.getRowCount();
        Row[] rowsSale = salesDetailVO.getAllRowsInRange();
        Integer pymntAmntSale = totamount;
        logger.info("countSalesDetail Count ============="+countSalesDetail);
        logger.info("headerPVTAmtInt Value ============="+headerPVTAmtInt);
        
        RowSetIterator salesDetailVOIterator =salesDetailVO.createRowSetIterator(null);
        while (salesDetailVOIterator.hasNext()) {
            Row salesPaymentRow = salesDetailVOIterator.next();
            SalesDetailUVORowImpl rowImplSale = (SalesDetailUVORowImpl)salesPaymentRow;
                BigDecimal salePVTAmt = (BigDecimal)rowImplSale.getSaleAmt();
                BigDecimal salePVTHdrSeq = (BigDecimal)rowImplSale.getPVTHDRSEQ();
                Integer salePVTHdrSeqInt = Integer.valueOf(salePVTHdrSeq.intValue());
                Integer pvtHeaderSeqInt = Integer.valueOf(pvtHeaderSeq.intValue());
            if(salePVTAmt==null){
                salePVTAmt = new BigDecimal(0);
            }
            if(salePVTAmt==null){
                salePVTAmt = new BigDecimal(0);
            }
            if(salePVTHdrSeqInt.equals(pvtHeaderSeqInt)){
                Integer salePVTAmtInt = Integer.valueOf(salePVTAmt.intValue());
            
                //If FullPaid                
                if(paid!=null && "true".equalsIgnoreCase(paid)){
                    if(salePVTAmtInt !=0){
                        headerPVTAmtInt = headerPVTAmtInt+salePVTAmtInt;                        
                    }
                    rowImplSale.setSaleAmt(new BigDecimal(headerPVTAmtInt)); 
                }
                
                //If it is partially paid
                if(paid!=null && "false".equalsIgnoreCase(paid) &&  pymntAmntSale!=0){
                    if(headerPVTAmtInt < pymntAmntSale){
                        if(salePVTAmtInt !=0){
                            headerPVTAmtInt = headerPVTAmtInt+salePVTAmtInt;                        
                        }
                        rowImplSale.setSaleAmt(new BigDecimal(headerPVTAmtInt));
                        pymntAmntSale = pymntAmntSale-salePVTAmtInt;
                    }else if(headerPVTAmtInt > pymntAmntSale){ 
                        rowImplSale.setSaleAmt(new BigDecimal(pymntAmntSale));                   
                        pymntAmntSale = pymntAmntSale-salePVTAmtInt;
                        break;
                    }else{
                        if(salePVTAmtInt !=0){
                            headerPVTAmtInt = headerPVTAmtInt+salePVTAmtInt;                        
                        }
                        rowImplSale.setSaleAmt(new BigDecimal(headerPVTAmtInt));                   
                        pymntAmntSale = 0;
                    } 
                }
        }
        }
    }
    
    public BigDecimal totalPaymentamountAction() {
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding Payment =
            bindingsAM.findIteratorBinding("SalesSettlementUVO1Iterator");
        ViewObjectImpl PaymentVO = (ViewObjectImpl)Payment.getViewObject();
        long count = PaymentVO.getEstimatedRowCount();
        BigDecimal totalAmt = null;
        if(count>0)
        {
                for(int i = 0;i<count;i++)
                {
                    Row PaymentRow  = PaymentVO.getRowAtRangeIndex(i);
                    if(PaymentRow != null)
                    {
                        BigDecimal rowAmt = (BigDecimal)PaymentRow.getAttribute("PYMTAMT");
                       if(totalAmt == null)
                       {
                               totalAmt = rowAmt;
                       }
                       else
                       {
                            totalAmt = totalAmt.add(rowAmt);    
                        }
                        
                    }
                }
        }
        logger.info("totalAmt"+totalAmt);
    
      
        return totalAmt;
    }
    
    
    //Getting Autogenerated SalesHeader Sequence from Sales HJeader table
    public BigDecimal getSaleHdrSequence(){
       
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorSale = bindingsAM.findIteratorBinding("SalesHeaderUVO1Iterator");
        ViewObjectImpl saleHdrVO = (ViewObjectImpl)dcItteratorSale.getViewObject(); 
        SalesHeaderUVORowImpl saleHdrRow = (SalesHeaderUVORowImpl)saleHdrVO.getCurrentRow();
        Object saleReceiptNum = saleHdrRow.getReceiptNum();
        Object saleHdrSeq = saleHdrRow.getSalehdrseq();
        BigDecimal saleHdrSeqBig = (BigDecimal)saleHdrSeq;
        logger.info("Sale Hdr Seq in BulkCardMBean is : "+saleHdrSeq);
        return saleHdrSeqBig;
    }

    //For Payment Receipt Generation
    public String PrintReceipt(Object saleHdrSeq) { 
          FacesContext context = FacesContext.getCurrentInstance(); 
          context.getApplication().getNavigationHandler().handleNavigation(context,null,"Success"); 
          //setVisible(Boolean.FALSE); 
          DCBindingContainer bindings = 
              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry(); 
          DCIteratorBinding dcItteratorBindings1 = 
              bindings.findIteratorBinding("PaymetReceiptVO1Iterator"); 
          ViewObjectImpl receptVO = (ViewObjectImpl)dcItteratorBindings1.getViewObject(); 
          receptVO.setWhereClause(null);
          receptVO.setWhereClause("Sale_hdr_seq = '"+saleHdrSeq+"'");
          receptVO.executeQuery();
         
//          String queryBase = receptVO.getQuery(); 
//          String queryEx = queryBase+" where  SLT_Sales_Settlement.Sale_hdr_seq = '"+saleHdrSeq+"'"; 
//          receptVO.setQuery(queryEx); 
//          receptVO.executeQuery(); 
          logger.info("Receipt Query is : "+receptVO.getQuery()); 
         // receptVO.setQuery(queryBase); 
        // logger.info("3333:::::::::::::::     "+receptVO.getQuery());
          return "Success"; 
      }
    
    
    //For Back Button
    public String backBtnRcpt_action() {
        cancelAction();
        if(paidFully && enforceReleaseCheck!=0)  {
            AdfFacesContext.getCurrentInstance().addPartialTarget(releaseCB);
            releaseCB.setVisible(Boolean.TRUE);
            //setReleaseCheckBox(true);
            setEnableBackReleaseCB(Boolean.TRUE);
            cancelButton.setVisible(Boolean.TRUE);
        }
        setBackButtonSelect(Boolean.TRUE);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.getApplication().getNavigationHandler().handleNavigation(context,null,"backNav"); 
        executePaymentReciptQuery();
        return null;
    }
    
    // knock off checkBox 
    public void getKnockOffValue(ValueChangeEvent valueChangeEvent) {
     Boolean checkValue =   (Boolean)valueChangeEvent.getNewValue();
     setKnockOffCheck(checkValue);
     logger.info("checkValue =======================    "+checkValue);
     if(checkValue !=null && checkValue) {
         logger.info("ifloop =======================    "+checkValue);
         knockAMT.setValue(getOutStandingAmt());
         sendApprovalBT.setVisible(true);
         knockAMT.setVisible(true);
         makePaymentBT.setVisible(false);
         submitButton.setVisible(false);
         releaseCB.setVisible(Boolean.FALSE);
        // setReleaseCheckBoxValue(false);
         //cancelButton.setVisible(false);
         setPaymentDocsuploadForm(true);
         panelFormUpload.setVisible(Boolean.TRUE);
        // uploadButton.setVisible(true);
         BindingContainer bindingsxec = getBindings();
         OperationBinding operationBinding = bindingsxec.getOperationBinding("createNewRowDocUploadFree"); 
          operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
         operationBinding.execute();  
        
       }
         else{
             knockAMT.setValue(null);
             makePaymentBT.setVisible(true);
             sendApprovalBT.setVisible(false);
             knockAMT.setVisible(false);
             submitButton.setVisible(true);
             cancelButton.setVisible(true);
           //  releaseCB.setVisible(Boolean.TRUE);
            // uploadButton.setVisible(false);
          //if unselect the Knock removeing created rows
             PVTDocsVOImpl pvtDocImpl = (PVTDocsVOImpl)this.getTRansactionModule().getPVTDocsVO1();
                 if(pvtDocImpl!=null) {
                    pvtDocImpl.getDBTransaction().rollback();
                 }
             setPaymentDocsuploadForm(false);
             panelFormUpload.setVisible(Boolean.FALSE);
         }
    }
   
    public String sendForApproval() {
        String userName = httpSession.getAttribute("loggedinUserid").toString();       
        String validationCheck = "fasle";
        DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
        DCIteratorBinding headerPvt =
            bindingsAM.findIteratorBinding("PVTHeaderVO1Iterator");
        ViewObjectImpl headerPvtVO = (ViewObjectImpl)headerPvt.getViewObject();
        long countheaderPvt = headerPvtVO.getEstimatedRowCount();
        logger.info("countheaderPvt Value ============="+countheaderPvt);
         Row[] rowsPVT = headerPvtVO.getAllRowsInRange();
         int pvtselectedCount =0;
         int pvtAcceptedAtPound =0;
         BigDecimal pvtHdrSeq =null;
         int sendApprovalCount=0;
         
            for(int i =0;i<rowsPVT.length ; i++ ){   
                // Write-Off PVT amount as per DoT Instructions
                Boolean checkValue =  (Boolean)rowsPVT[i].getAttribute("CheckFlagBox");
                   if(checkValue!=null && checkValue){
                Integer enforceStageId=(Integer)rowsPVT[i].getAttribute("ENFORCESTAGEID");
                Integer pvtStageID =(Integer)rowsPVT[i].getAttribute("PVTSTAGEID");         
                if(enforceStageId!=null && enforceStageId==12){
                    pvtHdrSeq=(BigDecimal)rowsPVT[i].getAttribute("PVTHDRSEQ");
                    pvtAcceptedAtPound++;
                } 
                if((pvtStageID !=null && pvtStageID==9) || (pvtStageID !=null && pvtStageID==10))
                    sendApprovalCount++;   
                }
            }
            
            if(sendApprovalCount!=0) {
                validationCheck = "true";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("122", lngCode)));
                return validationCheck;  
            }
         
         if(pvtAcceptedAtPound == 0) {
             validationCheck = "true";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("123", lngCode)));
            // uploadButton.setVisible(true);
             return validationCheck;
         }
         
        for(int i =0;i<rowsPVT.length ; i++ ){         
         Boolean checkValue =  (Boolean)rowsPVT[i].getAttribute("CheckFlagBox");
            if(checkValue!=null && checkValue){
                pvtselectedCount++;
            }
                        
            }if(pvtselectedCount==0 || getOutStandingAmt()==null){
            validationCheck = "true";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("124", lngCode)));
           // uploadButton.setVisible(true);
            return validationCheck;
            }
        
        if(closeRemarks.getValue()== null){
            validationCheck = "true";
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("125", lngCode)));
            //uploadButton.setVisible(true);
            return validationCheck;
         }
        
        
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
        
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please upload mandatary Documents "));       
        //                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
        //                                    "Sample info message",
        //                                    genMsg.getMessage("100", lngCode)));
            return "true";
        }
        
        }
        if (docsDesc == null) {
           
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                 "Sample info message",
                 genMsg.getMessage("101", lngCode)));
            return "true";
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
        

//        PVTDocsVOImpl pvtDocsImpl = (PVTDocsVOImpl)getTRansactionModule().getPVTDocsVO1();
//        if(pvtDocsImpl!=null) {
//          int docsCount =  pvtDocsImpl.getRowCount();
//          for(int i=0;i<docsCount; i++) {
//             Row docRow = pvtDocsImpl.getRowAtRangeIndex(i);
//             org.apache.myfaces.trinidad.model.UploadedFile uploadFile = (org.apache.myfaces.trinidad.model.UploadedFile)docRow.getAttribute("FileUpload");
//              String docsDesc = (String)docRow.getAttribute("DOCDesc");
//              if(uploadFile==null)
//              {
//                validationCheck = "true";
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("126", lngCode)));
//                return validationCheck;
//              }
//              if(docsDesc==null)
//              {
//                validationCheck = "true";
//                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("127", lngCode)));
//                return validationCheck;
//              }
//          }
//        }
//        if(uploadedFiles==null){
//            validationCheck = "true";
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please upload documents")); 
//           // uploadButton.setVisible(true);
//            return validationCheck;
//        }
           
            for(int i =0;i<rowsPVT.length ; i++ ){         
             Boolean checkValue =  (Boolean)rowsPVT[i].getAttribute("CheckFlagBox");
                if(checkValue!=null && checkValue){
                    PVTHeaderVORowImpl pymntImpl = (PVTHeaderVORowImpl)rowsPVT[i];
                    //setting the status for 
                     Integer enforceStage = (Integer) rowsPVT[i].getAttribute("ENFORCESTAGEID");
                      if(enforceStage != null && enforceStage == 12 ){
                       rowsPVT[i].setAttribute("PVTSTAGEID",new BigDecimal(9));
                       rowsPVT[i].setAttribute("KnockoffAmt",(BigDecimal)knockAMT.getValue());
                       rowsPVT[i].setAttribute("CLOSUREREMARKS",(String)closeRemarks.getValue());
                       setPvtNumforUpload((String)rowsPVT[i].getAttribute("PVTNum"));
                     
                     //event for sending DOT 
                         OperationBinding operation1 = getBindings().getOperationBinding("pvteventsendDoTInstructions");
                         operation1.getParamsMap().put("pvtHeaderSeq", pvtHdrSeq);
                         operation1.getParamsMap().put("loggerName", userName);
                         operation1.getParamsMap().put("remarks", "DoT Spl instructions received");
                         operation1.getParamsMap().put("EventId", "584");
                         operation1.execute();
                   }
                }
            }  

//             if(pvtHdrSeq !=null){
//                String validationUpload =  uploadDocsWriteAndRelease(pvtHdrSeq);
//             } 
        
        BindingContainer bindingsxec = getBindings(); 
//        OperationBinding opBinding = bindingsxec.getOperationBinding("PVTupdatePaymentDetails");
//        opBinding.getParamsMap().put("pvtHdrSeq", pvtHdrSeq);
//        opBinding.getParamsMap().put("payableAmt", getOutStandingAmt());
//        opBinding.execute();
        OperationBinding op = bindingsxec.getOperationBinding("sendMail");
        op.getParamsMap().put("pvtHdrSeq", pvtHdrSeq);
        op.execute();
        OperationBinding operationBinding = bindingsxec.getOperationBinding("commit");
        operationBinding.execute();
        
        if (operationBinding.getErrors().isEmpty()) { 
            makePaymentBT.setVisible(true);
            sendApprovalBT.setVisible(false);
            knockAMT.setVisible(false);
            submitButton.setVisible(true);
            cancelButton.setVisible(true);
            panelFormUpload.setVisible(Boolean.FALSE);
            //uploadButton.setVisible(false);
            cancelAction();
            rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("128", lngCode))); 
        }
      return null;
    }
    

    public void releaseVehicleCheck(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Boolean vehCheck =   (Boolean)valueChangeEvent.getNewValue();
       setVehicleCheck(vehCheck);
       if(vehCheck!=null && vehCheck){
           releaseVehicleBT.setVisible(Boolean.TRUE);
           knockOffCB.setVisible(Boolean.FALSE);
           makePymntBn.setVisible(Boolean.FALSE);
           remarksText.setVisible(Boolean.TRUE);
           submitButton.setVisible(Boolean.FALSE);
           panelFormUpload.setVisible(Boolean.TRUE);
           //setKnockCheckValue(Boolean.FALSE);
           knockOffCB.setVisible(Boolean.FALSE);
           setPaymentDocsuploadForm(true);
           BindingContainer bindingsxec = getBindings();
           OperationBinding operationBinding = bindingsxec.getOperationBinding("createNewRowDocUploadReleaseVehicle"); 
           operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
           operationBinding.execute();  
          // uploadButton.setVisible(true);
           
       }else{
           
           if(!(isEnableBackReleaseCB())){
               knockOffCB.setVisible(Boolean.TRUE);
               makePymntBn.setVisible(Boolean.TRUE);
               submitButton.setVisible(Boolean.TRUE); 
               knockOffCB.setVisible(Boolean.TRUE);
           }
             releaseVehicleBT.setVisible(false);
             
             PVTDocsVOImpl pvtDocImpl = (PVTDocsVOImpl)this.getTRansactionModule().getPVTDocsVO1();
                 if(pvtDocImpl!=null) {
                    pvtDocImpl.getDBTransaction().rollback();
            }
         panelFormUpload.setVisible(Boolean.FALSE);
        
       //  uploadButton.setVisible(false);
         }
       
    }
    
    public void changeBayStatusToAvailable(BigDecimal pvtHdrSeq){
        DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
        DCIteratorBinding poundBayPvt = bindingsAM.findIteratorBinding("PoundBayDetailVO1Iterator");
        PoundBayDetailVOImpl poundBayVO = (PoundBayDetailVOImpl)poundBayPvt.getViewObject();
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        poundBayVO.applyViewCriteria(null);
        poundBayVO.applyViewCriteria(poundBayVO.getViewCriteria("GetByPvtHeaderSeq"));
        VariableValueManager bay= poundBayVO.ensureVariableManager();
        bay.setVariableValue("BindPvtHdrSeq", pvtHdrSeq);
        poundBayVO.executeQuery();
        if(poundBayVO!=null) {
             PoundBayDetailVORowImpl row  =  (PoundBayDetailVORowImpl)poundBayVO.first();
             if(row!=null)
            {
             String bayStatus = (String) row.getBaystatus();
              if(bayStatus.equalsIgnoreCase("O")){
                row.setBaystatus("A");
                row.setPVTHDRSEQ(null);
                row.setUpdateddate(sqlDate);
                row.setUpdatedby(userName);
                
                /* adding vehicle release event */
                OperationBinding operation1 = getBindings().getOperationBinding("CreateEvent");
                    operation1.getParamsMap().put("pvtHeaderSeq", pvtHdrSeq);
                    operation1.getParamsMap().put("loggerName", userName);
                    operation1.getParamsMap().put("remarks", "Vehicle Released from Pound");
                    operation1.getParamsMap().put("EventId", "578");
                //                operation1.getParamsMap().put("Amt", BigDecimal.valueOf(((long)PVTAdjAmount*100, 2) );
                operation1.execute();
              }
            }
        }
    }
    
   /*
    * Vehicle release
    */
    public String releaseVehicle(ActionEvent actionEvent) {
        BigDecimal pvtHdrSeqRelease=null;
        BigDecimal KnockoffAmt =null;
        if(!getBackButtonSelect() ){
           pvtcheckBackSelection= listReleaseCheck;
        }

         if(getVehicleCheck()!=null && getVehicleCheck() && getPaidFully()){
             if(closeRemarks.getValue()== null ){
                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("125", lngCode)));
                // uploadButton.setVisible(true);
                 return "true";
                  
              }
             
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
             
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please upload mandatary Documents "));       
             //                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
             //                                    "Sample info message",
             //                                    genMsg.getMessage("100", lngCode)));
                 return "true";
             }
             
             }
             if (docsDesc == null) {
                
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                      "Sample info message",
                      genMsg.getMessage("101", lngCode)));
                 return "true";
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
             
             
             
             
             
             
             
             
             
             
             
             
//             
//             PVTDocsVOImpl pvtDocsImpl = (PVTDocsVOImpl)getTRansactionModule().getPVTDocsVO1();
//             if(pvtDocsImpl!=null) {
//               int docsCount =  pvtDocsImpl.getRowCount();
//               for(int i=0;i<docsCount; i++) {
//                  Row docRow = pvtDocsImpl.getRowAtRangeIndex(i);
//                  org.apache.myfaces.trinidad.model.UploadedFile uploadFile = (org.apache.myfaces.trinidad.model.UploadedFile)docRow.getAttribute("FileUpload");
//                   String docsDesc = (String)docRow.getAttribute("DOCDesc");
//                   if(uploadFile==null)
//                   {
//                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("126", lngCode)));
//                      return "true";
//                  }
//                   if(docsDesc==null)
//                   {
//                     
//                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("127", lngCode)));
//                       return "true";
//                   }
//               }
//             }
             
//             if(uploadedFiles==null){
//                 
//                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please upload documents")); 
//                // uploadButton.setVisible(true);
//                 return "true";
//             }
             

         if(pvtcheckBackSelection !=null) {
             
             for(int i=0;i<pvtcheckBackSelection.size(); i++){
             BigDecimal pvtHDRSeq = (BigDecimal)pvtcheckBackSelection.get(i);
             DCBindingContainer bindingsAM =(DCBindingContainer)getBindings();
             DCIteratorBinding headerPvt = bindingsAM.findIteratorBinding("PVTHeaderVO1Iterator");
             ViewObjectImpl headerPvtVO = (ViewObjectImpl)headerPvt.getViewObject();
             headerPvtVO.setWhereClause(null);
             headerPvtVO.setWhereClause("PVT_HDR_SEQ = '"+pvtHDRSeq+"'"); 
             headerPvtVO.executeQuery();
            logger.info("Query :::::::::::::::             "+ headerPvtVO.getQuery());
                 
                 if(headerPvtVO!=null) {
                      Row row  =  headerPvtVO.first();
                      Integer enforceStage = (Integer) row.getAttribute("ENFORCESTAGEID");
                     Integer pvtStage = (Integer) row.getAttribute("PVTSTAGEID");
                     if(pvtStage!=null && pvtStage == 8 || pvtStage == 10){
                        pvtHdrSeqRelease = (BigDecimal) row.getAttribute("PVTHDRSEQ");
                        row.setAttribute("PVTStatusID",2);
                         BindingContainer pvtSynchSieble = getBindings();
                         OperationBinding operationBinding = pvtSynchSieble.getOperationBinding("pvtHeaderSiebleSynch"); 
                         operationBinding.getParamsMap().put("pvtHdrSeq",pvtHdrSeqRelease);
                         operationBinding.execute();
                     }
                    if(row!=null && enforceStage != null && enforceStage == 12){
                     KnockoffAmt = (BigDecimal) row.getAttribute("KnockoffAmt");
                     pvtHdrSeqRelease = (BigDecimal) row.getAttribute("PVTHDRSEQ");
                     row.setAttribute("ENFORCESTAGEID",14);
                     setPvtNumforUpload((String)row.getAttribute("PVTNum"));
                     row.setAttribute("CLOSUREREMARKS",(String)closeRemarks.getValue());
                        BigDecimal deimalBig = new BigDecimal("0.00");
                     if(KnockoffAmt != null && KnockoffAmt.compareTo(BigDecimal.ZERO) > 0){
                         BindingContainer bindingsxec = getBindings(); 
                         OperationBinding pvtEventAccLog = bindingsxec.getOperationBinding("updatePVTEventAndAccountLog");
                         pvtEventAccLog.getParamsMap().put("pvtHeaderSeq",pvtHdrSeqRelease);
                         pvtEventAccLog.getParamsMap().put("loggerName",httpSession.getAttribute("loggedinUserid").toString());
                         pvtEventAccLog.getParamsMap().put("remarks",(String)closeRemarks.getValue());
                         pvtEventAccLog.getParamsMap().put("knockAmt",KnockoffAmt);
                         pvtEventAccLog.execute();
                     }
                    }
                 }
             /* pound Release*/
               changeBayStatusToAvailable(pvtHdrSeqRelease);
             
             }
             
//               if(pvtHdrSeqRelease !=null ) {
//                   uploadDocsWriteAndRelease(pvtHdrSeqRelease);
//               }
             
               BindingContainer bindingsxecCommit = getBindings(); 
               OperationBinding operationBinding = bindingsxecCommit.getOperationBinding("commit");
               operationBinding.execute();
               
               if (operationBinding.getErrors().isEmpty()) { 
                   makePaymentBT.setVisible(true);
                   sendApprovalBT.setVisible(false);
                   knockAMT.setVisible(false);
                  // setReleaseCheckBox(false);
                   releaseCB.setVisible(Boolean.FALSE);
                   submitButton.setVisible(true);
                   cancelButton.setVisible(true);
                   panelFormUpload.setVisible(Boolean.FALSE);
                   
                  // uploadButton.setVisible(false);
                   cancelAction();
                  // rollback();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("129", lngCode)));
               }

           }
         }
        
       return null;
     }
    
    
    
    public String  addUploadDoc() {
            
            BindingContainer bindingsxec = getBindings();
            OperationBinding operationBinding = bindingsxec.getOperationBinding("addUploadDoc"); 
            //operationBinding.getParamsMap().put("encoder","vara");
            operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
            operationBinding.execute();  
            
            return null;
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
        }else if(extType != null && extType.equalsIgnoreCase("pdf") || extType.equalsIgnoreCase("docx") || extType.equalsIgnoreCase("doc") ||extType.equalsIgnoreCase("xlsx")
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
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public void setRemovalCharge(BigDecimal removalCharge) {
        this.removalCharge = removalCharge;
    }

    public BigDecimal getRemovalCharge() {
        return removalCharge;
    }

    public void setClampingCharge(BigDecimal clampingCharge) {
        this.clampingCharge = clampingCharge;
    }

    public BigDecimal getClampingCharge() {
        return clampingCharge;
    }

    public void setPoundCharge(BigDecimal poundCharge) {
        this.poundCharge = poundCharge;
    }

    public BigDecimal getPoundCharge() {
        return poundCharge;
    }

    public void setOutStandingAmt(BigDecimal outStandingAmt) {
        this.outStandingAmt = outStandingAmt;
    }

    public BigDecimal getOutStandingAmt() {
        return outStandingAmt;
    }

    public void setConventionFee(BigDecimal conventionFee) {
        this.conventionFee = conventionFee;
    }

    public BigDecimal getConventionFee() {
        return conventionFee;
    }

    public void setDiscountOmConv(BigDecimal discountOmConv) {
        this.discountOmConv = discountOmConv;
    }

    public BigDecimal getDiscountOmConv() {
        return discountOmConv;
    }

    public void setPayableAmt(BigDecimal PayableAmt) {
        this.PayableAmt = PayableAmt;
    }

    public BigDecimal getPayableAmt() {
        return PayableAmt;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public List<UploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setChequeNumCol(RichColumn chequeNumCol) {
        this.chequeNumCol = chequeNumCol;
    }

    public RichColumn getChequeNumCol() {
        return chequeNumCol;
    }

    public void setChequeBnkCol(RichColumn chequeBnkCol) {
        this.chequeBnkCol = chequeBnkCol;
    }

    public RichColumn getChequeBnkCol() {
        return chequeBnkCol;
    }

    public void setChequeDateCol(RichColumn chequeDateCol) {
        this.chequeDateCol = chequeDateCol;
    }

    public RichColumn getChequeDateCol() {
        return chequeDateCol;
    }

    public void setCreditCardTypeCol(RichColumn creditCardTypeCol) {
        this.creditCardTypeCol = creditCardTypeCol;
    }

    public RichColumn getCreditCardTypeCol() {
        return creditCardTypeCol;
    }

    public void setCreditCardNumCol(RichColumn creditCardNumCol) {
        this.creditCardNumCol = creditCardNumCol;
    }

    public RichColumn getCreditCardNumCol() {
        return creditCardNumCol;
    }

    public void setAuthCodeCol(RichColumn authCodeCol) {
        this.authCodeCol = authCodeCol;
    }

    public RichColumn getAuthCodeCol() {
        return authCodeCol;
    }


    public void setPvtCustomerId(BigDecimal pvtCustomerId) {
        this.pvtCustomerId = pvtCustomerId;
    }

    public BigDecimal getPvtCustomerId() {
        return pvtCustomerId;
    }

    public void setPaymentboxrender(RichPanelGroupLayout paymentboxrender) {
        this.paymentboxrender = paymentboxrender;
    }

    public RichPanelGroupLayout getPaymentboxrender() {
        return paymentboxrender;
    }

   

    public void setPvtNumList(ArrayList pvtNumList) {
        this.pvtNumList = pvtNumList;
    }

    public ArrayList getPvtNumList() {
        return pvtNumList;
    }


    public void setSendApprovalBT(RichCommandButton sendApprovalBT) {
        this.sendApprovalBT = sendApprovalBT;
    }

    public RichCommandButton getSendApprovalBT() {
        return sendApprovalBT;
    }

    public void setMakePaymentBT(RichCommandButton makePaymentBT) {
        this.makePaymentBT = makePaymentBT;
    }

    public RichCommandButton getMakePaymentBT() {
        return makePaymentBT;
    }

    public void setKnockAMT(RichInputText knockAMT) {
        this.knockAMT = knockAMT;
    }

    public RichInputText getKnockAMT() {
        return knockAMT;
    }

    public void setKnockOffCheck(Boolean knockOffCheck) {
        this.knockOffCheck = knockOffCheck;
    }

    public Boolean getKnockOffCheck() {
        return knockOffCheck;
    }


    public void setCloseRemarks(RichInputText closeRemarks) {
        this.closeRemarks = closeRemarks;
    }

    public RichInputText getCloseRemarks() {
        return closeRemarks;
    }


    public void setVehicleCheck(Boolean vehicleCheck) {
        this.vehicleCheck = vehicleCheck;
    }

    public Boolean getVehicleCheck() {
        return vehicleCheck;
    }

    public void setPaidFully(Boolean paidFully) {
        this.paidFully = paidFully;
    }

    public Boolean getPaidFully() {
        return paidFully;
    }

//    public void setReleaseCheckBox(Boolean releaseCheckBox) {
//        this.releaseCheckBox = releaseCheckBox;
//    }
//
//    public Boolean getReleaseCheckBox() {
//        return releaseCheckBox;
//    }

    public void setHidePVTDetails(Boolean hidePVTDetails) {
        this.hidePVTDetails = hidePVTDetails;
    }

    public Boolean getHidePVTDetails() {
        return hidePVTDetails;
    }

    private void callProcedureUpdatatingtheCharges() {
        BindingContainer bindings1 = getBindings();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("PVTHeaderVO1Iterator");
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        Row rowSelected = voTableData.getCurrentRow();    
         Row[] rows1 = voTableData.getAllRowsInRange();
        ArrayList pvtHeaderseqList = new ArrayList();
        for(int i =0;i<rows1.length ; i++ ){
        Boolean checkValueP =  (Boolean)rows1[i].getAttribute("CheckFlagBox");
        String pvtNum1P =  (String)rows1[i].getAttribute("PVTNum");
        BigDecimal pvtHdrSequence =  (BigDecimal)rows1[i].getAttribute("PVTHDRSEQ");
        logger.info("Before If pvtNum  callProcedureUpdatatintheCharges ================           "+pvtNum1P);
        logger.info(" Before If callProcedureUpdatatintheCharges ===============            "+checkValueP);
        
        if(checkValueP!=null && checkValueP) {
            OperationBinding opBinding1 = bindings.getOperationBinding("getSeqPVTPayMents");
            opBinding1.getParamsMap().put("pvtNo", pvtNum1P);
            opBinding1.execute();
            String pvtHdrSeq = (String)opBinding1.getResult();
            //calling procedure
            BigDecimal pvtSeq = new BigDecimal(pvtHdrSeq);
            OperationBinding opBinding = bindings1.getOperationBinding("PVTPaymentCallRemovalCharges");
            opBinding.getParamsMap().put("pvtHdrSeq", pvtHdrSequence);
            opBinding.execute();
        
        }
    }
            OperationBinding operationBinding = bindings1.getOperationBinding("commit");
            operationBinding.execute();
           
       
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
                     uploadPath = fl.uploadFilesToFolder("1", "PVT", getPvtNumforUpload(), uploadFile);
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
       if(headerPvtVO!=null &&  getPvtNumforUpload()!=null)
       {
           headerPvtVO.setWhereClause(null);
           headerPvtVO.setWhereClause("PVT_Num = '"+ getPvtNumforUpload() +"'");
           headerPvtVO.executeQuery();
           logger.info("get query in Submit Bay Changes Action" + headerPvtVO.getQuery());
           PVTHeaderVORowImpl pvtHdrRow = (PVTHeaderVORowImpl)headerPvtVO.first();
           if(pvtHdrRow!=null){
               pvtHdrSeqUpload = pvtHdrRow.getPVTHDRSEQ();
           }
       }
       return pvtHdrSeqUpload;
    }


    public String cancelAction() {
        // Add event code here...      
         setHide(Boolean.FALSE);
         setReleaseCheckBoxValue(false);
         paymentboxrender.setRendered(Boolean.FALSE);
         paymentboxrender.setVisible(Boolean.FALSE);
            setHidePVTDetails(Boolean.FALSE);
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding("PVTSearchRVO2Iterator");
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        voTableData.clearCache();
        voTableData.executeEmptyRowSet();
        removalCharge = null;
        clampingCharge = null;
        adjustmentAmt=null;
        poundCharge = null;
        outStandingAmt = null;
        conventionFee=null;  
        discountOmConv=null;
        PayableAmt=null;
        sendApprovalBT.setVisible(false);
        paid=null;
        closeRemarks.setValue(null);
        knockAMT.setValue(null);
        enterRemarks=null;
        knockAMT.setVisible(Boolean.FALSE);
        knockAMT=null;
        releaseCB.setVisible(Boolean.FALSE);
        setKnockCheckValue(false);
        releaseVehicleBT.setVisible(false);
        knockOffCB.setVisible(Boolean.FALSE);
        makePaymentBT.setRendered(Boolean.FALSE);
        remarksText.setVisible(Boolean.FALSE);
         panelFormUpload.setVisible(Boolean.FALSE);
        selectedtable.getSelectedRowKeys().clear();
        return null;
    }
    
    
    public void executePaymentReciptQuery() {
        DCBindingContainer bindings = 
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry(); 
        DCIteratorBinding dcItteratorBindings1 = 
            bindings.findIteratorBinding("PaymetReceiptVO1Iterator"); 
        ViewObjectImpl receptVO = (ViewObjectImpl)dcItteratorBindings1.getViewObject();
        receptVO.setWhereClause(null);
        System.out.println("  Back Button Query  ::::::::::  "+receptVO.getQuery());
        receptVO.executeQuery(); 
        logger.info("executePaymentReciptQuery :::::::::::::::::::::"+receptVO.getQuery());

    }
    
    public void rollback() {
        getBindings().getOperationBinding("Rollback").execute();
    }
    
       

    public void setEnterKnockOff(BigDecimal enterKnockOff) {
        this.enterKnockOff = enterKnockOff;
    }

    public BigDecimal getEnterKnockOff() {
        return enterKnockOff;
    }

    public void setEnterRemarks(String enterRemarks) {
        this.enterRemarks = enterRemarks;
    }

    public String getEnterRemarks() {
        return enterRemarks;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public Boolean getHide() {
        return hide;
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

//    public void setUploadButton(RichInputFile uploadButton) {
//        uploadButton.setVisible(false);
//        this.uploadButton = uploadButton;
//    }
//
//    public RichInputFile getUploadButton() {
//        return uploadButton;
//    }

    public void setKnockCheckValue(boolean knockCheckValue) {
        this.knockCheckValue = knockCheckValue;
    }

    public boolean isKnockCheckValue() {
        return knockCheckValue;
    }

    public void setReleaseCheckBoxValue(boolean releaseCheckBoxValue) {
        this.releaseCheckBoxValue = releaseCheckBoxValue;
    }

    public boolean isReleaseCheckBoxValue() {
        return releaseCheckBoxValue;
    }

    public void setReleaseVehicleBT(RichCommandButton releaseVehicleBT) {
        this.releaseVehicleBT = releaseVehicleBT;
    }

    public RichCommandButton getReleaseVehicleBT() {
        return releaseVehicleBT;
    }

    public void setPvtNumforUpload(String pvtNumforUpload) {
        this.pvtNumforUpload = pvtNumforUpload;
    }

    public String getPvtNumforUpload() {
        return pvtNumforUpload;
    }


    public void setBackButtonSelect(Boolean backButtonSelect) {
        this.backButtonSelect = backButtonSelect;
    }

    public Boolean getBackButtonSelect() {
        return backButtonSelect;
    }

    public void setPaymentDocsuploadForm(Boolean paymentDocsuploadForm) {
        this.paymentDocsuploadForm = paymentDocsuploadForm;
    }

    public Boolean getPaymentDocsuploadForm() {
        return paymentDocsuploadForm;
    }

    public void setPanelFormUpload(RichPanelFormLayout panelFormUpload) {
        this.panelFormUpload = panelFormUpload;
    }

    public RichPanelFormLayout getPanelFormUpload() {
        return panelFormUpload;
    }

    public void setKnockOffCB(RichPanelGroupLayout knockOffCB) {
        this.knockOffCB = knockOffCB;
    }

    public RichPanelGroupLayout getKnockOffCB() {
        return knockOffCB;
    }

    public void setMakePymntBn(RichPanelGroupLayout makePymntBn) {
        this.makePymntBn = makePymntBn;
    }

    public RichPanelGroupLayout getMakePymntBn() {
        return makePymntBn;
    }

    public void setRemarksText(RichPanelGroupLayout remarksText) {
        this.remarksText = remarksText;
    }

    public RichPanelGroupLayout getRemarksText() {
        return remarksText;
    }

    public void setReleaseCB(RichPanelGroupLayout releaseCB) {
        this.releaseCB = releaseCB;
    }

    public RichPanelGroupLayout getReleaseCB() {
        return releaseCB;
    }

    public void setEnableBackReleaseCB(boolean enableBackReleaseCB) {
        this.enableBackReleaseCB = enableBackReleaseCB;
    }

    public boolean isEnableBackReleaseCB() {
        return enableBackReleaseCB;
    }
    
    public void setDocTable(RichTable docTable) {
        this.docTable = docTable;
    }

    public RichTable getDocTable() {
        return docTable;
    }

    public void setCcdType(RichSelectOneChoice ccdType) {
        this.ccdType = ccdType;
    }

    public RichSelectOneChoice getCcdType() {
        return ccdType;
    }

    public void setAdjustmentAmt(BigDecimal adjustmentAmt) {
        this.adjustmentAmt = adjustmentAmt;
    }

    public BigDecimal getAdjustmentAmt() {
        return adjustmentAmt;
    }
    public void setSelectedtable(RichTable selectedtable) {
        this.selectedtable = selectedtable;
    }

    public RichTable getSelectedtable() {
        return selectedtable;
    }
    
}
