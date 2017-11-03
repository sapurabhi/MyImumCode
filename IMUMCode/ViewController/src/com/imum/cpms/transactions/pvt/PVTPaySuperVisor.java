package com.imum.cpms.transactions.pvt;

import com.imum.cpms.model.transactions.vo.PVTChargeDetailRVOImpl;

import com.imum.cpms.model.transactions.vo.PVTDocsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PvtHeaderPaySuperVisorRVOImpl;
import com.imum.cpms.model.transactions.vo.PvtHeaderPaySuperVisorRVORowImpl;
import com.imum.cpms.model.transactions.vo.PvtHeaderPaySuperVisorUVOImpl;
import com.imum.cpms.model.transactions.vo.PvtHeaderPaySuperVisorUVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesDetailUVOImpl;

import com.imum.cpms.model.transactions.vo.SalesDetailUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class PVTPaySuperVisor {
    private RichInputText closeRemarks;
    private Boolean approveCheck=false;
    ArrayList<DocsBean> doclist = null;
    private Boolean remarksVisible =false;
    private RichCommandLink filePropertyCommandLink;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    public static final ADFLogger logger = ADFLogger.createADFLogger(PVTPaySuperVisor.class);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    public PVTPaySuperVisor() {
        if(lngCode==null || lngCode.equals(""))
               {
                   lngCode = "EN";
               }
    }

   private String remarks;


    public void approved(ValueChangeEvent valueChangeEvent) {
       Boolean approved = (Boolean)valueChangeEvent.getNewValue();
      
    }

    public String getUploadedDocs() {
        BigDecimal pvtheaderSeq =null;
        setRemarksVisible(true);
        doclist = new ArrayList<DocsBean>();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding("PvtHeaderPaySuperVisorUVO1Iterator");
        PvtHeaderPaySuperVisorUVOImpl pvtHeaderPaySuperVisorUVOImpl = (PvtHeaderPaySuperVisorUVOImpl)dcItteratorBindings.getViewObject();
        PvtHeaderPaySuperVisorUVORowImpl pvtPaySuperVisorROWImpl = (PvtHeaderPaySuperVisorUVORowImpl)pvtHeaderPaySuperVisorUVOImpl.getCurrentRow();
        if(pvtPaySuperVisorROWImpl!=null)
        {
         pvtheaderSeq = pvtPaySuperVisorROWImpl.getPVTHDRSEQ();
        }
        
        if(pvtheaderSeq!=null) {
            DCIteratorBinding dcItteratorBindingsHeader = bindings.findIteratorBinding("PVTDocsVO1Iterator");
            ViewObject pvtDocVo = dcItteratorBindingsHeader.getViewObject();
            PVTDocsVOImpl pvtDocVoimpl = (PVTDocsVOImpl)pvtDocVo;
            if (pvtDocVo != null) {
                 pvtDocVoimpl.setWhereClause(null);
                 pvtDocVoimpl.setWhereClause("PVT_HDR_SEQ = '" + pvtheaderSeq + "'");
                 pvtDocVoimpl.executeQuery();
             }
            
           logger.info("pvtDocVoimpl Size =============="+pvtDocVoimpl.getRowCount());
            RowSetIterator paymentSuperVisorIterator = pvtDocVoimpl.createRowSetIterator(null);
            DocsBean docsBean = new DocsBean();
            while (paymentSuperVisorIterator.hasNext()) {
               docsBean = new DocsBean();
                Row paymentRow = paymentSuperVisorIterator.next();
                if(paymentRow!=null) {
                   String filepath = (String) paymentRow.getAttribute("filepath");
                   String docName = (String)paymentRow.getAttribute("DOCDesc");
                    docsBean.setDocPath(filepath);
                    docsBean.setDocName(docName);
                    
                      }
                       doclist.add(docsBean);
                   } 

                }
                return null;
    }

    public String getApproved() {
        BigDecimal PVTAdjAmount;
        BigDecimal KnockoffAmt =null;
        if(closeRemarks.getValue()== null|| closeRemarks.getValue().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("125", lngCode)));  
            return "Fail";
         }
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding("PvtHeaderPaySuperVisorUVO1Iterator");
        PvtHeaderPaySuperVisorUVOImpl pvtHeaderPaySuperVisorUVOImpl = (PvtHeaderPaySuperVisorUVOImpl)dcItteratorBindings.getViewObject();
        PvtHeaderPaySuperVisorUVORowImpl pvtPaySuperVisorROWImpl = (PvtHeaderPaySuperVisorUVORowImpl)pvtHeaderPaySuperVisorUVOImpl.getCurrentRow();
        
        if(pvtPaySuperVisorROWImpl !=null)
        {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        pvtPaySuperVisorROWImpl.setPVTSTAGEID(new Integer(10));
        pvtPaySuperVisorROWImpl.setKnockoffApprovedDate(sqlDate);
        pvtPaySuperVisorROWImpl.setKnockoffApprovedby(userName);
        PVTAdjAmount=pvtPaySuperVisorROWImpl.getPVTAMTPAYABLE();
        KnockoffAmt =pvtPaySuperVisorROWImpl.getKnockoffAmt();
        BigDecimal pvtHdrSeq=pvtPaySuperVisorROWImpl.getPVTHDRSEQ();
        OperationBinding operation1 = getBindings().getOperationBinding("pvteventsendDoTInstructions");
        operation1.getParamsMap().put("pvtHeaderSeq", pvtHdrSeq);
        operation1.getParamsMap().put("loggerName", userName);
        operation1.getParamsMap().put("remarks", "Knocked off amount : AED "+KnockoffAmt);
        operation1.getParamsMap().put("EventId", "585");
        operation1.execute();
        
            OperationBinding operation = getBindings().getOperationBinding("PVTDoTInstructionsAmt");
            operation.getParamsMap().put("pvtHdrSeq",pvtHdrSeq );
            operation.getParamsMap().put("PVTAdjAmount", PVTAdjAmount);
            operation.getParamsMap().put("loggerName", httpSession.getAttribute("loggedinUserid").toString());
            operation.getParamsMap().put("Operator", "-");
            operation.execute();


       
        
        if(closeRemarks.getValue() != null){
        pvtPaySuperVisorROWImpl.setCLOSUREREMARKS(closeRemarks.getValue().toString());
        }
        BindingContainer bindingsxec = getBindings(); 
        OperationBinding operationBinding = bindingsxec.getOperationBinding("commit");
        operationBinding.execute();
        if(operationBinding.getErrors().size()>0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("130", lngCode))); 
        }else {
               pvtHeaderPaySuperVisorUVOImpl.executeQuery();
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("131", lngCode))); 
           }
        }
        return null;
    }
    
    
    public void downloadFileListener(FacesContext facesContext, OutputStream outputStream) throws IOException {
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
           outputStream.flush();
       }

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setCloseRemarks(RichInputText closeRemarks) {
        this.closeRemarks = closeRemarks;
    }

    public RichInputText getCloseRemarks() {
        return closeRemarks;
    }


    public void setApproveCheck(Boolean approveCheck) {
        this.approveCheck = approveCheck;
    }

    public Boolean getApproveCheck() {
        return approveCheck;
    }

    public void setDoclist(ArrayList<DocsBean> doclist) {
        this.doclist = doclist;
    }

    public ArrayList<DocsBean> getDoclist() {
        return doclist;
    }

    public void setRemarksVisible(Boolean remarksVisible) {
        this.remarksVisible = remarksVisible;
    }

    public Boolean getRemarksVisible() {
        return remarksVisible;
    }
    
    public void setFilePropertyCommandLink(RichCommandLink filePropertyCommandLink) {
        this.filePropertyCommandLink = filePropertyCommandLink;
    }

    public RichCommandLink getFilePropertyCommandLink() {
        return filePropertyCommandLink;
    }
}
