package com.imum.cpms.transactions.inventory;


import com.imum.cpms.util.MessageUtil;

import com.imum.ws.CardInactive.CardInactivepprovalBPMProcessPortType;
import com.imum.ws.CardInactive.CardInactivepprovalBPMProcessService;

import java.io.FileNotFoundException;
import java.io.IOException;




import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import javax.xml.ws.WebServiceRef;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.UploadedFile;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class inventoryUploadMBean {
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    private RichInputFile inventoryUpload;
    UploadedFile selectedFile = null;
    String selectedFileName = null;
    int TotalCardsCount = 0;
    int PrepaidCardsCount = 0;
    int RechargeCardsCount = 0;
    int VVIPCardsCount = 0;
    String hide;
    private RichPanelGroupLayout sheetReview;
    Object uploadSeq;
    Number vendor = null;
    String orderReference = null;
    String cartonNumber = null;
    Number cardType = null;
    String cardNumber = null;
    String CVVCode = null;
    Number denomination = null;
    Date dispatchedDate = null;
    Date expiryDate = null;
    String validationCheck = "Success";
    DecimalFormat decimalFormat = new DecimalFormat("#");
    String disableButton;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private RichTable errorTbl;
    private RichCommandButton reviewInventory;
    private RichCommandButton submitInventory;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();

    public inventoryUploadMBean() {
        super();
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        }
    }
    @WebServiceRef
    private static CardInactivepprovalBPMProcessService cardInactivepprovalBPMProcessService;
    
    public String onClickSubmit_Action() {
//        System.out.println("***********TotalCardsCount....." + pageflowScope.get("TotalCardsCount"));
//        if (pageflowScope.get("TotalCardsCount") != null) {
//            TotalCardsCount = Integer.parseInt(pageflowScope.get("TotalCardsCount").toString());
//        }
//        if (TotalCardsCount == 0) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "No Cards to upload, please select a valid file"));  
//        } else {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("commit");
            operationBinding.execute();
           
            OperationBinding operationBindProc = bindings.getOperationBinding("callValProc");
            operationBindProc.execute();
            DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            
            DCIteratorBinding invStkUploadBinding = bindingsAM.findIteratorBinding("InventoryStockUploadUVO1Iterator");
            ViewObjectImpl uploadHVO = (ViewObjectImpl)invStkUploadBinding.getViewObject();                     
            if(uploadHVO != null)
            {   Long reuploadlog=0L;
                Object reupload=null;
                Row currRow = uploadHVO.getCurrentRow();
                uploadSeq = currRow.getAttribute("UploadSeq"); 
                System.out.println("Upload seq after proc in submit is : "+uploadSeq);
                
                DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("InventoryStockUploadUVO2Iterator");
                ViewObjectImpl appVO = (ViewObjectImpl)dcItteratorBinding.getViewObject(); 
                appVO.setWhereClauseParams(null);
                appVO.setWhereClause("Upload_Seq = '"+uploadSeq+"'");
                appVO.executeQuery();
                System.out.println(appVO.getEstimatedRowCount());
               
                
                Row CRow = appVO.first();
                reupload=CRow.getAttribute("reuploadaprvseq");
                if(reupload!=null) {
                    
                    reuploadlog = Long.valueOf(reupload.toString());
                    System.out.println("calllllllllllllll");
                    cardInactivepprovalBPMProcessService=new CardInactivepprovalBPMProcessService();
                    CardInactivepprovalBPMProcessPortType cardInactivepprovalBPMProcessPortType=cardInactivepprovalBPMProcessService.getCardInactivepprovalBPMProcessPort();
                    cardInactivepprovalBPMProcessPortType.start(reuploadlog);
                    
                    
                    
                }
                
                
            }    
            DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("StockUploadErrorVO1Iterator");
            ViewObjectImpl uploadErr = (ViewObjectImpl)dcItteratorBinding.getViewObject();     
            if(uploadErr != null)
            {
                uploadErr.setWhereClause(null);
                uploadErr.setWhereClause("error_msg not like 'No Error' and upload_seq = "+uploadSeq);
                uploadErr.executeQuery(); 
                System.out.println("Query ErrorVO :"+uploadErr.getQuery());
                System.out.println("Error Row count is : "+uploadErr.getRowCount());
                if(uploadErr.getRowCount() > 0)
                {
                    getErrorTbl().setRendered(true);
                  //  getSheetReview().setRendered(false);
                }
                if (operationBindProc.getErrors().isEmpty() && operationBinding.getErrors().isEmpty() && uploadErr.getRowCount() == 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",  genMsg.getMessage("192", lngCode)));
                  //  getSheetReview().setRendered(false);
            }
            }
//        }
       
        getSubmitInventory().setDisabled(true);
        return null;
    }

    public String onClickReview_Action() {
            DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            try {
                if (validationCheck.equalsIgnoreCase("Success")) {
                    HSSFWorkbook workbook = new HSSFWorkbook(selectedFile.getInputStream());
                    HSSFSheet worksheet = workbook.getSheetAt(0);
                    Iterator workSheetIterator = worksheet.rowIterator();
                    while (workSheetIterator.hasNext()) {
                        HSSFRow cellRow = (HSSFRow) workSheetIterator.next();
                        Iterator cellsIterator = cellRow.cellIterator();
                        if (cellRow.getRowNum() != 0) {
                            TotalCardsCount = TotalCardsCount + 1;
                        }
                        while (cellsIterator.hasNext()) {
                            HSSFCell cell = (HSSFCell) cellsIterator.next();
                            short celNum = cell.getCellNum();
                            
                            if (validationCheck.equalsIgnoreCase("Success")) {
                                if (cellRow.getRowNum() > 0)
                                {
                                        if(celNum == 2)
                                        {
                                            try{
                                                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                                                    orderReference = cell.getStringCellValue();
                                                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                                                    orderReference = String.format("%f", cell.getNumericCellValue());
                                                    System.out.println("orderReference..." + orderReference);
                                                    orderReference = orderReference.substring(0, orderReference.indexOf('.'));
                                                    System.out.println("after substring orderReference..." + orderReference);
                                                }
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("180", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            }
                                            System.out.println("Order Reference for Row "+cellRow.getRowNum()+" is : "+orderReference);
                                        }
                                        if(celNum == 0)
                                        {      
                                            try{
                                                vendor = cell.getNumericCellValue();  
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("181", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            }                                            
                                            System.out.println("vendor for Row "+cellRow.getRowNum()+" is : "+vendor);
                                        }
                                         if(celNum == 3)
                                        {       
                                            try{
                                                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                                                    cartonNumber = cell.getStringCellValue();
                                                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                                                    cartonNumber = String.format("%f", cell.getNumericCellValue());
                                                    System.out.println("cartonNumber..." + cartonNumber);
                                                    cartonNumber = cartonNumber.substring(0, cartonNumber.indexOf('.'));
                                                    System.out.println("after substring cartonNumber..." + cartonNumber);
                                                }
                                               // cartonNumber = cell.getNumericCellValue();   
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("182", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            }   
                                            System.out.println("cartonNumber for Row "+cellRow.getRowNum()+" is : "+cartonNumber);
                                        }
                                         if(celNum == 4)
                                        {
                                            try{
                                                cardType = cell.getNumericCellValue();
                                                cardType = Integer.valueOf(decimalFormat.format(cardType));
                                                if (cardType == (Number)1) {
                                                    PrepaidCardsCount = PrepaidCardsCount + 1;
                                                } else if (cardType == (Number)2) {
                                                    RechargeCardsCount = RechargeCardsCount + 1;
                                                } else if (cardType == (Number)3) {
                                                    VVIPCardsCount = VVIPCardsCount + 1;
                                                } 
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("183", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            }   
                                            System.out.println("cardType for Row "+cellRow.getRowNum()+" is : "+cardType);
                                        } 
                                         if(celNum == 5)
                                        {     
                                            try{
                                                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                                                    cardNumber = cell.getStringCellValue();
                                                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                                                    cardNumber = String.format("%f", cell.getNumericCellValue());
                                                    System.out.println("cardNumber..." + cardNumber);
                                                    cardNumber = cardNumber.substring(0, cardNumber.indexOf('.'));
                                                    System.out.println("after substring cardNumber..." + cardNumber);
                                                }
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("184", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            } 
                                            System.out.println("cardNumber for Row "+cellRow.getRowNum()+" is : "+cardNumber);
                                        }
                                         if(celNum == 6)
                                        {     
                                            try{
                                                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {                                                    
                                                    CVVCode = cell.getStringCellValue();
                                                    int CVVCodeLength = CVVCode.length();
                                                    if (CVVCodeLength != 3) {
                                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"CVV Code should contain 3 digits, invalid CVV Code", genMsg.getMessage("299", lngCode) +cellRow.getRowNum()));
                                                        validationCheck = "fail";
                                                        break; 
                                                    }
                                                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                                                    CVVCode = String.format("%f", cell.getNumericCellValue());
                                                    System.out.println("CVVCode..." + CVVCode);
                                                    CVVCode = CVVCode.substring(0, CVVCode.indexOf('.'));
                                                    System.out.println("after substring CVVCode..." + CVVCode);
                                                    int CVVCodeLength = CVVCode.length();
                                                    if (CVVCodeLength != 3) {
                                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"CVV Code should contain 3 digits, invalid CVV Code", genMsg.getMessage("299", lngCode) +cellRow.getRowNum()));
                                                        validationCheck = "fail";
                                                        break; 
                                                    }
                                                } else {
                                                    CVVCode = null;
                                                }
//                                                if(CVVCode.equals(0.0))
//                                                {
//                                                    CVVCode = null;
//                                                }
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("185", lngCode) +cellRow.getRowNum()));
                                                validationCheck = "fail";
                                                break;
                                            } 
                                            System.out.println("CVVCode for Row "+cellRow.getRowNum()+" is : "+CVVCode);
                                        }
                                         if(celNum == 7)
                                        {   
                                            try{
                                                denomination = cell.getNumericCellValue();
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("186", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            } 
                                            System.out.println("denomination for Row "+cellRow.getRowNum()+" is : "+denomination);
                                        }
                                         if(celNum == 1)
                                        {
                                            try{
                                                dispatchedDate = cell.getDateCellValue();
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("187", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            } System.out.println("dispatchedDate for Row "+cellRow.getRowNum()+" is : "+dispatchedDate);
                                        }
                                         if(celNum == 8)
                                        {
                                           
                                            try{
                                                expiryDate = cell.getDateCellValue();
                                            }catch(Exception e)
                                            {
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("188", lngCode) +cellRow.getRowNum()));        
                                                validationCheck = "fail";
                                                break;
                                            } 
                                            System.out.println("expiryDate for Row "+cellRow.getRowNum()+" is : "+expiryDate);
                                        }         
                              }   
                            }
                    }
                    if (cellRow.getRowNum() > 0 && validationCheck.equalsIgnoreCase("Success"))
                    {
                        if(cellRow.getRowNum()==1)
                        {
                            OperationBinding delRcptDtl = bindingsAM.getOperationBinding("delRecieptDetail");
                            delRcptDtl.execute();
                            OperationBinding operationBinding = bindingsAM.getOperationBinding("commit");
                            operationBinding.execute();
                            DCIteratorBinding invStkUploadBinding = bindingsAM.findIteratorBinding("InventoryStockUploadUVO1Iterator");
                            ViewObjectImpl uploadHVO = (ViewObjectImpl)invStkUploadBinding.getViewObject();                     
                            if(uploadHVO != null)
                            {
                                Row currRow = uploadHVO.createRow();  
                                System.out.println("******************************selectedFileName on review is : "+selectedFileName);
                                currRow.setAttribute("filename",selectedFileName);
                                uploadHVO.insertRow(currRow);    
                                uploadHVO.setCurrentRow(currRow);
                                uploadSeq = currRow.getAttribute("UploadSeq"); 
                                System.out.println("Upload seq on review is :"+uploadSeq);
                            }
                        }
                        DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("InventoryStockUploadDetailsVO1Iterator");
                        ViewObject invUpload = dcItteratorBinding.getViewObject(); 
                        if (dispatchedDate != null) {
                            Row invRow = invUpload.createRow();
                            invUpload.insertRow(invRow); 
                            if(invRow != null)
                            {
                                System.out.println("*****Attributes for row "+cellRow.getRowNum());
                                invRow.setAttribute("UploadSeq", uploadSeq);
                                invRow.setAttribute("VendorID",vendor);
                                invRow.setAttribute("OrderRefnum",orderReference);
                                invRow.setAttribute("Cartonnum",cartonNumber);
                                invRow.setAttribute("CardType",cardType);
                                invRow.setAttribute("CardNumber",cardNumber);
                                invRow.setAttribute("CVVCode",CVVCode);
                                invRow.setAttribute("DenomAmt",denomination);
                                
                                if (dispatchedDate != null) {
                                    java.sql.Date sqldispatchdate = new java.sql.Date(dispatchedDate.getTime());
                                    invRow.setAttribute("DispatchedDate",sqldispatchdate);  
                                } else {
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("189", lngCode)));
                                    break;
                                }
                                    
                                if (expiryDate != null) {                    
                                    java.sql.Date sqlexpiryDate = new java.sql.Date(expiryDate.getTime());
                                    invRow.setAttribute("ExpiryDate", sqlexpiryDate);
                                } else {
                                    invRow.setAttribute("ExpiryDate", null);
                                    
                                }
                                
                                if (httpSession.getAttribute("loggedinUserid") != null)
                                {
                                    invRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
                                    invRow.setAttribute("Updatedby", httpSession.getAttribute("loggedinUserid").toString());    
                                } else {
                                    invRow.setAttribute("CreatedBy", "anonymous");
                                    invRow.setAttribute("Updatedby", "anonymous");
                                }
                            } 
                        } else {
                            TotalCardsCount = TotalCardsCount - 1;
                            break;
                        }
                    }
                }
                DCIteratorBinding dcItteratorB = bindingsAM.findIteratorBinding("InventoryStockUploadUVO1Iterator");
                ViewObjectImpl uploadHdrVO = (ViewObjectImpl)dcItteratorB.getViewObject();                     
                if(uploadHdrVO != null)
                {
                   Row currRow = uploadHdrVO.getCurrentRow();
                    if(currRow != null )
                    {
                        System.out.println("Vendor id in Submit is : "+vendor);
                        currRow.setAttribute("VendorID",vendor);    
                        currRow.setAttribute("Totalcardsreceived",TotalCardsCount);   
                        if (httpSession.getAttribute("loggedinUserid") != null)
                        {
                            currRow.setAttribute("CreatedBy",httpSession.getAttribute("loggedinUserid").toString());  
                            currRow.setAttribute("Updatedby",httpSession.getAttribute("loggedinUserid").toString());  
                        } else {
                            currRow.setAttribute("CreatedBy","anonymous");  
                            currRow.setAttribute("Updatedby","anonymous");
                        }
                    }
                }
              } 
            }catch (FileNotFoundException fileNotFoundException) {
                    System.out.println("fileNotFoundException..." + fileNotFoundException);
            } catch (IOException ioException) {
                    System.out.println("ioException..." + ioException);
            } catch (Exception exception) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("190", lngCode)));
                    System.out.println("exception..." + exception);  
            } finally {
            }
            if (validationCheck.equalsIgnoreCase("Success")) {
                if(TotalCardsCount!=0)
                {
                    pageflowScope.put("TotalStockUploaded", TotalCardsCount);
                    pageflowScope.put("PrepaidCardsStock", PrepaidCardsCount);
                    pageflowScope.put("RechargeCardsStock", RechargeCardsCount);
                    pageflowScope.put("VVIPCardsStock", VVIPCardsCount);
                    getSheetReview().setRendered(true);
                    getSubmitInventory().setDisabled(false);   
                }
                
            }
            return null;
        }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public String commitOperationAM() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("commit");
        operationBinding.execute();
        return null;
    }

    public void setInventoryUpload(RichInputFile inventoryUpload) {
        this.inventoryUpload = inventoryUpload;
    }

    public RichInputFile getInventoryUpload() {
        return inventoryUpload;
    }

    public void selectedFile(ValueChangeEvent valueChangeEvent) {
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        selectedFile = (UploadedFile) valueChangeEvent.getNewValue();
        if (selectedFile != null && selectedFile.getLength() > 0) {
            selectedFileName = selectedFile.getFilename().toString();            
             if(selectedFileName.contains(".")){
             int i = selectedFileName.lastIndexOf('.');
            String fileType = selectedFileName.substring(i+1);
             System.out.println("Selected File Name..." + selectedFileName);
                 if(fileType.equalsIgnoreCase("xls"))
                 {
                     validationCheck = "Success";
                     DCIteratorBinding dcItteratorB = bindingsAM.findIteratorBinding("InventoryStockUploadUVO1Iterator");
                     ViewObjectImpl uploadHdrVO = (ViewObjectImpl)dcItteratorB.getViewObject();   
               //      uploadHdrVO.setWhereClause("ISNULL(total_cards_received, 0) != ISNULL(total_error_cards, 0)");
                     System.out.println("Query for header table filter..." + uploadHdrVO.getQuery());
                     Row fileNameVal[] = uploadHdrVO.getFilteredRows("filename", selectedFileName);
                     System.out.println("Rows in DB with File Name exists count : "+fileNameVal.length);
                     if(fileNameVal.length>0)
                     {
                         uploadHdrVO.setWhereClause("ISNULL(total_cards_received, 0) != ISNULL(total_error_cards, 0)");
                         uploadHdrVO.executeQuery();
                         System.out.println("Query@@@@@@@@@@@..." + uploadHdrVO.getQuery());
                         int rowCount = uploadHdrVO.getRowCount();
                         if (rowCount > 0) {
                             validationCheck = "fail";
                             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("179", lngCode)));         
                         }
                     }
                 }
                 else
                 {
                     validationCheck = "fail";
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("191", lngCode)));     
                 }
             }
        }
        getSheetReview().setRendered(false);
        getErrorTbl().setRendered(false);
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }

    public void setSheetReview(RichPanelGroupLayout sheetReview) {
        this.sheetReview = sheetReview;
    }

    public RichPanelGroupLayout getSheetReview() {
        return sheetReview;
    }

    public void setErrorTbl(RichTable errorTbl) {
        this.errorTbl = errorTbl;
    }

    public RichTable getErrorTbl() {
        return errorTbl;
    }

    public void setDisableButton(String disableButton) {
        this.disableButton = disableButton;
    }

    public String getDisableButton() {
        return disableButton = "false";
    }

    public void setReviewInventory(RichCommandButton reviewInventory) {
        this.reviewInventory = reviewInventory;
    }

    public RichCommandButton getReviewInventory() {
        return reviewInventory;
    }

    public void setSubmitInventory(RichCommandButton submitInventory) {
        this.submitInventory = submitInventory;
    }

    public RichCommandButton getSubmitInventory() {
        return submitInventory;
    }
}
