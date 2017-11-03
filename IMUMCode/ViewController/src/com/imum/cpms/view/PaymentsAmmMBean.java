package com.imum.cpms.view;

import com.imum.cpms.model.transactions.vo.PVTDiscountHeaderSearchVORowImpl;
import com.imum.cpms.model.transactions.vo.SaleReceiptDetailVORowImpl;
import com.imum.cpms.model.transactions.vo.saleReceiptSettlVORowImpl;

import java.math.BigDecimal;

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
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.ADFUtil;


public class PaymentsAmmMBean {
    private RichInputText receiptNumber;
 
    private RichInputText transactionNumber;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    private RichTable tablebin;

    public PaymentsAmmMBean() {
    }

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String SearchAction() {
      
        // Add event code here...
        BindingContainer bindings = getBindings();
        Object receiptnum = getReceiptNumber().getValue();
        String receiptNumber = null;
        String permitnumber = null;
        String cardnumber = null;
        String cardnumberfrom = null;
        String PVTNumberN = null;
        String PermitNumberN = null;
        if(receiptnum!=null  )
        {
         receiptNumber = getReceiptNumber().getValue().toString();
        
        }
        
        if(receiptnum==null || "".equals(receiptnum))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Receipt Number"));
            ADFContext.getCurrent().getPageFlowScope().put("Search","NoEntered");
            ADFContext.getCurrent().getPageFlowScope().put("Edit","NoEntered");
            return null; 
        }
        OperationBinding opBinding = bindings.getOperationBinding("SearchReceiptNumber");
        opBinding.getParamsMap().put("receiptNumber",receiptNumber);
        String result = opBinding.execute().toString();
        if("norows".equals(result))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter valid Receipt Number"));
            ADFContext.getCurrent().getPageFlowScope().put("Search","NoEntered");
            ADFContext.getCurrent().getPageFlowScope().put("Edit","NoEntered");
            return null; 
        }
        DCBindingContainer bindings4 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings3 =
        bindings4.findIteratorBinding("SaleReceiptDetailVO1Iterator");
        ViewObject detailvo = dcItteratorBindings3.getViewObject();
        
        long count = detailvo.getEstimatedRowCount();
        String prodcode = null;
        
        
//        for(SaleReceiptDetailVORowImpl detailrow = (SaleReceiptDetailVORowImpl)detailvo.first();detailvo.hasNext();detailrow = (SaleReceiptDetailVORowImpl)detailvo.next())
//        {
        // SaleReceiptDetailVORowImpl detailrow = (SaleReceiptDetailVORowImpl)detailvo.getRowAtRangeIndex(i);
        RowSetIterator SaleRecIter = detailvo.createRowSetIterator(null);
        String s="N";
            while (SaleRecIter.hasNext()) {
                s="Y";
            Row detailrow = SaleRecIter.next();
            if(detailrow != null)
            {
            if(detailrow.getAttribute("Prodcode") !=null)
            prodcode=  detailrow.getAttribute("Prodcode").toString();
           int prodcodeint = Integer.parseInt(prodcode);
            ADFContext.getCurrent().getPageFlowScope().put("prodcodeint",prodcodeint);
           if(prodcodeint == 1)
           {
               if(detailrow.getAttribute("permitnumber")!=null)
                PermitNumberN = detailrow.getAttribute("permitnumber").toString();
           if(detailrow.getAttribute("permitnumber") != null)
          
           permitnumber = detailrow.getAttribute("PRMHeaderseq").toString();
           ADFContext.getCurrent().getPageFlowScope().put("permitnumber",permitnumber);
               
          // getTransactionNumber().setValue(PermitNumberN);
               detailrow.setAttribute("TransactionRefNo", PermitNumberN);
                   
              
              // AdfFacesContext.getCurrentInstance().addPartialTarget( transactionNumber);
           }
            else if(prodcodeint == 2 || prodcodeint == 3 || prodcodeint == 4  )
           {
             if(detailrow.getAttribute("card") != null) 
            cardnumber = detailrow.getAttribute("card").toString();
             if(detailrow.getAttribute("Cardnumfrom") != null)
            cardnumberfrom = detailrow.getAttribute("Cardnumfrom").toString();
           // getTransactionNumber().setValue(cardnumber);
           detailrow.setAttribute("TransactionRefNo", cardnumber);
         
            
               ADFContext.getCurrent().getPageFlowScope().put("cardnumber",cardnumber);
               ADFContext.getCurrent().getPageFlowScope().put("cardnumberfrom",cardnumberfrom);
              // AdfFacesContext.getCurrentInstance().addPartialTarget( transactionNumber); 
           }
            else if(prodcodeint ==  5)
           {
               if(detailrow.getAttribute("pvtnumber") != null)
               PVTNumberN = detailrow.getAttribute("pvtnumber").toString();  
               String PVTNumber = null;
                if(detailrow.getAttribute("PVTHDRSEQ") != null)
                PVTNumber = detailrow.getAttribute("PVTHDRSEQ").toString();
            //   getTransactionNumber().setValue(PVTNumberN);
            detailrow.setAttribute("TransactionRefNo", PVTNumberN);
       
               ADFContext.getCurrent().getPageFlowScope().put("PVTNumber",PVTNumber);
               AdfFacesContext.getCurrentInstance().addPartialTarget(tablebin);
           }
               
           
            }
            
        }
            if(s.equals("Y")) {
                ADFContext.getCurrent().getPageFlowScope().put("Search","Entered");
            }


        return null;
    }

    public void setReceiptNumber(RichInputText receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public RichInputText getReceiptNumber() {
        return receiptNumber;
    }

   

    public void setTransactionNumber(RichInputText transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public RichInputText getTransactionNumber() {
        return transactionNumber;
    }

    public String edit() {
        // Add event code here...
        ADFContext.getCurrent().getPageFlowScope().put("Edit","Entered");
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.saleReceiptSettlVO1Iterator.currentRow}"); // get the current selected row
        if(selectedRow != null) {
         BigDecimal salestlseq= new BigDecimal(selectedRow.getAttribute("SaleStlseq").toString());
            DCBindingContainer bindings4 =
                          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings3 =
            bindings4.findIteratorBinding("saleReceiptSettlVO2Iterator");
            ViewObject settlvo = dcItteratorBindings3.getViewObject();
            settlvo.setWhereClause(null);
            settlvo.setWhereClauseParams(null);
            settlvo.setWhereClause("Sale_Stl_seq = '"+salestlseq+"'");
            settlvo.executeQuery();
            if(settlvo != null) 
            {
                saleReceiptSettlVORowImpl settlrow = (saleReceiptSettlVORowImpl)settlvo.first();
                String paymenttype = settlrow.getPYMTType();
                ADFContext.getCurrent().getPageFlowScope().put("oldPaymentMode",paymenttype);
                if("CSH".equals(paymenttype)) 
                {
                    String cashPay = paymenttype;
                    ADFContext.getCurrent().getPageFlowScope().put("oldpayment",cashPay);
                    ADFContext.getCurrent().getPageFlowScope().put("Payment","cash");
                }
                else if("CCD".equals(paymenttype)) 
                {
                  String creditpay =   paymenttype + "||" + settlrow.getCCDnum()+"||" +settlrow.getCCDType()+ "||" +settlrow.getAuthCode();
                    ADFContext.getCurrent().getPageFlowScope().put("oldpayment",creditpay);
                    ADFContext.getCurrent().getPageFlowScope().put("Payment","creditcard");
                }
                else if("CHQ".equals(paymenttype)) 
                {
                  String chequepay =    paymenttype + "||" + settlrow.getChqnum()+"||" +settlrow.getChqDate()+"||" +settlrow.getChqBankname();
                    ADFContext.getCurrent().getPageFlowScope().put("oldpayment",chequepay);
                    ADFContext.getCurrent().getPageFlowScope().put("Payment","cheque");
                }
               
                                   
                
            }
            
         
       
        }
        return null;
    }

    public String Submit() {
        // Add event code here...
        DCBindingContainer bindings4 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings3 =
        bindings4.findIteratorBinding("saleReceiptSettlVO2Iterator");
        ViewObject settlvo = dcItteratorBindings3.getViewObject();
        saleReceiptSettlVORowImpl settlrow = (saleReceiptSettlVORowImpl)settlvo.getCurrentRow();
        //String loggedinuser = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        if(settlrow != null) 
        {
            String paymenttype = null;
            if(settlrow.getPYMTType() != null)
             paymenttype = settlrow.getPYMTType().toString();
            if(paymenttype == null || "".equals(paymenttype)) 
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Payment Type"));
                return null;
            }
            if( ADFContext.getCurrent().getPageFlowScope().get("oldPaymentMode").equals(paymenttype)) 
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "There is no change in the payment mode."));
                return null;
            }
         
            if("CSH".equals(paymenttype) ) 
            {
                String cashPay = paymenttype;
                ADFContext.getCurrent().getPageFlowScope().put("newpayment",paymenttype);
               
            }
            else if("CCD".equals(paymenttype)) 
            {
                if(settlrow.getCCDnum() == null) 
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter credit card number"));
                    return null;
                }
                else if(settlrow.getCCDType() == null ||  "".equals(settlrow.getCCDType())) 
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter credit card Type"));
                    return null;  
                }
                if(settlrow.getCCDnum().toString().length() <4 ) 
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter valid 4 digit credit card Number"));
                    return null;  
                    
                }
                
                System.out.println(settlrow.getAuthCode());
          if(settlrow.getAuthCode() == null || "".equals(settlrow.getAuthCode())) {
                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter authorization Code."));
                         return null;  
                     }
              String creditpay =   settlrow.getCCDnum()+"||" +settlrow.getCCDType()+ "||" +settlrow.getAuthCode();
                ADFContext.getCurrent().getPageFlowScope().put("newpayment",creditpay);
                
           
            }
            else if("CHQ".equals(paymenttype)) 
            {
                if( settlrow.getChqnum() == null || "".equals(settlrow.getChqnum())) 
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Cheque number"));
                    return null;
                }
                else if(settlrow.getChqDate() == null || "".equals(settlrow.getChqDate())) 
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Cheque Date"));
                    return null;  
                }
                else if(settlrow.getChqBankname()== null || "".equals(settlrow.getChqBankname())) {
                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Bank Name."));
                         return null;  
                     }
              String chequepay =   settlrow.getChqnum()+"||" +settlrow.getChqDate()+"||" +settlrow.getChqBankname();
                ADFContext.getCurrent().getPageFlowScope().put("newpayment",chequepay);
              
            }
            String prodcode = null;
            String PermitNumberN= null;
            String permitnumber = null;
          String cardnumber= null;
          String cardnumberfrom= null;
          String PVTNumberN= null;
            DCIteratorBinding dcItteratorBindings5 =
            bindings4.findIteratorBinding("SaleReceiptDetailVO1Iterator");
            ViewObject detailvo = dcItteratorBindings5.getViewObject();
            RowSetIterator SaleRecIter = detailvo.createRowSetIterator(null);
            while (SaleRecIter.hasNext()) {
            Row detailrow = SaleRecIter.next();
            if(detailrow != null)
            {
            if(detailrow.getAttribute("Prodcode") !=null)
            prodcode=  detailrow.getAttribute("Prodcode").toString();
            int prodcodeint = Integer.parseInt(prodcode);
            ADFContext.getCurrent().getPageFlowScope().put("prodcodeint",prodcodeint);
            if(prodcodeint == 1)
            {
               if(detailrow.getAttribute("permitnumber")!=null)
                PermitNumberN = detailrow.getAttribute("permitnumber").toString();
            if(detailrow.getAttribute("permitnumber") != null)
            {
            
            permitnumber = detailrow.getAttribute("PRMHeaderseq").toString();
                OperationBinding opBinding = bindings.getOperationBinding("PRMentryEventDetails");
                opBinding.getParamsMap().put("oldpayment",ADFContext.getCurrent().getPageFlowScope().get("oldpayment"));
                opBinding.getParamsMap().put("newpayment",ADFContext.getCurrent().getPageFlowScope().get("newpayment"));
                 opBinding.getParamsMap().put("permitnumber",permitnumber);
                  
                    opBinding.getParamsMap().put("loggedinuser",userName);
                    
                opBinding.execute();
            
            }
          
                   
              
              // AdfFacesContext.getCurrentInstance().addPartialTarget( transactionNumber);
            }
            else if(prodcodeint == 2 || prodcodeint == 3 || prodcodeint == 4  )
            {
             if(detailrow.getAttribute("card") != null) 
            cardnumber = detailrow.getAttribute("card").toString();
             if(detailrow.getAttribute("Cardnumfrom") != null)
             {
            cardnumberfrom = detailrow.getAttribute("Cardnumfrom").toString();
                 OperationBinding opBinding = bindings.getOperationBinding("CARDentryEventDetails");
                 opBinding.getParamsMap().put("oldpayment",ADFContext.getCurrent().getPageFlowScope().get("oldpayment"));
                 opBinding.getParamsMap().put("newpayment",ADFContext.getCurrent().getPageFlowScope().get("newpayment"));
                 opBinding.getParamsMap().put("cardnumber",cardnumberfrom);
                 opBinding.getParamsMap().put("loggedinuser",userName);
                 
                 opBinding.execute();
             }
             
           
            }
            else if(prodcodeint ==  5)
            {
               if(detailrow.getAttribute("pvtnumber") != null)
               PVTNumberN = detailrow.getAttribute("pvtnumber").toString();  
               String PVTNumber = null;
                if(detailrow.getAttribute("PVTHDRSEQ") != null)
                {
                PVTNumber = detailrow.getAttribute("PVTHDRSEQ").toString();
                    OperationBinding opBinding = bindings.getOperationBinding("PVTentryEventDetails");
                    opBinding.getParamsMap().put("oldpayment",ADFContext.getCurrent().getPageFlowScope().get("oldpayment"));
                    opBinding.getParamsMap().put("newpayment",ADFContext.getCurrent().getPageFlowScope().get("newpayment"));
                    opBinding.getParamsMap().put("PVTNumber",  PVTNumber);
                    opBinding.getParamsMap().put("loggedinuser",userName);
                    
                    opBinding.execute();
                }
          
            }
               
            
            }
            
            }
           
//            if(  Integer.parseInt(ADFContext.getCurrent().getPageFlowScope().get("prodcodeint").toString()) == 1)
//            {
//                if(ADFContext.getCurrent().getPageFlowScope().get("permitnumber") != null)
//                {
//            OperationBinding opBinding = bindings.getOperationBinding("PRMentryEventDetails");
//            opBinding.getParamsMap().put("oldpayment",ADFContext.getCurrent().getPageFlowScope().get("oldpayment"));
//            opBinding.getParamsMap().put("newpayment",ADFContext.getCurrent().getPageFlowScope().get("newpayment"));
//             opBinding.getParamsMap().put("permitnumber",ADFContext.getCurrent().getPageFlowScope().get("permitnumber"));
//              
//                opBinding.getParamsMap().put("loggedinuser",userName);
//                
//            opBinding.execute();
//                }
//            }
//            else if(Integer.parseInt(ADFContext.getCurrent().getPageFlowScope().get("prodcodeint").toString()) == 2 || Integer.parseInt(ADFContext.getCurrent().getPageFlowScope().get("prodcodeint").toString()) == 3 || Integer.parseInt(ADFContext.getCurrent().getPageFlowScope().get("prodcodeint").toString()) == 4) 
//            {
//                if(ADFContext.getCurrent().getPageFlowScope().get("cardnumberfrom") != null)
//                {
//                OperationBinding opBinding = bindings.getOperationBinding("CARDentryEventDetails");
//                opBinding.getParamsMap().put("oldpayment",ADFContext.getCurrent().getPageFlowScope().get("oldpayment"));
//                opBinding.getParamsMap().put("newpayment",ADFContext.getCurrent().getPageFlowScope().get("newpayment"));
//                opBinding.getParamsMap().put("cardnumber", ADFContext.getCurrent().getPageFlowScope().get("cardnumberfrom"));
//                opBinding.getParamsMap().put("loggedinuser",userName);
//               
//                opBinding.execute();
//                }
//            }
//            else if(Integer.parseInt(ADFContext.getCurrent().getPageFlowScope().get("prodcodeint").toString()) == 5)
//            {
//               if(ADFContext.getCurrent().getPageFlowScope().get("PVTNumber") != null)
//               {
//                OperationBinding opBinding = bindings.getOperationBinding("PVTentryEventDetails");
//                opBinding.getParamsMap().put("oldpayment",ADFContext.getCurrent().getPageFlowScope().get("oldpayment"));
//                opBinding.getParamsMap().put("newpayment",ADFContext.getCurrent().getPageFlowScope().get("newpayment"));
//                opBinding.getParamsMap().put("PVTNumber",   ADFContext.getCurrent().getPageFlowScope().get("PVTNumber"));
//                opBinding.getParamsMap().put("loggedinuser",userName);
//              
//                opBinding.execute();
//               }
//            }
            OperationBinding opBinding = bindings.getOperationBinding("commit");
            opBinding.execute();
            if(opBinding.getErrors().isEmpty())
            {
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Payment Details submitted successfully."));
                ADFContext.getCurrent().getPageFlowScope().put("Search","NoEntered");
                ADFContext.getCurrent().getPageFlowScope().put("Edit","NoEntered");
                
                return null;  
            }
        }
        
        
        return null;
    }

    public void PaymentTypeValueChange(ValueChangeEvent valueChangeEvent) {
        String paymenttype = valueChangeEvent.getNewValue().toString();
            if("0".equals(paymenttype)) 
            {
               
               
                ADFContext.getCurrent().getPageFlowScope().put("Payment","cash");
            }
            else if("1".equals(paymenttype)) 
            {
              
               
                ADFContext.getCurrent().getPageFlowScope().put("Payment","creditcard");
            }
            else if("2".equals(paymenttype)) 
            {
             
                ADFContext.getCurrent().getPageFlowScope().put("Payment","cheque");
            }
        
    }

    public void Cancel(ActionEvent actionEvent) {
        // Add event code here...
        getBindings().getOperationBinding("doRollback").execute();
        ADFContext.getCurrent().getPageFlowScope().put("Search","NoEntered");
        ADFContext.getCurrent().getPageFlowScope().put("Edit","NoEntered");
    }

    public void setTablebin(RichTable tablebin) {
        this.tablebin = tablebin;
    }

    public RichTable getTablebin() {
        return tablebin;
    }
}
