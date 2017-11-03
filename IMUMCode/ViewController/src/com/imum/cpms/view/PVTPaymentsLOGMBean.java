package com.imum.cpms.view;

import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTSearchRVOImpl;

import com.imum.cpms.model.transactions.vo.PaymentsTypesLOVVORowImpl;

import java.util.Date;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class PVTPaymentsLOGMBean {
    private RichInputText pvTPaidAmount;
    private RichInputText pvTpaidDate;
    private RichInputText receiptNumber;
    private RichInputText transactionID;
    private RichInputText kioskLocation;
    private RichInputText paymentChannel;
    private RichInputDate paymentDate;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
   
     String   PVTNumber = null;
    private RichSelectOneChoice paymentlov;
    private RichTable resultstable;


    public PVTPaymentsLOGMBean() {
    }

    public void setPvTPaidAmount(RichInputText pvTPaidAmount) {
        this.pvTPaidAmount = pvTPaidAmount;
    }

    public RichInputText getPvTPaidAmount() {
        return pvTPaidAmount;
    }

    public void setPvTpaidDate(RichInputText pvTpaidDate) {
        this.pvTpaidDate = pvTpaidDate;
    }

    public RichInputText getPvTpaidDate() {
        return pvTpaidDate;
    }

    public void setReceiptNumber(RichInputText receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public RichInputText getReceiptNumber() {
        return receiptNumber;
    }

    public void setTransactionID(RichInputText transactionID) {
        this.transactionID = transactionID;
    }

    public RichInputText getTransactionID() {
        return transactionID;
    }

    public void setKioskLocation(RichInputText kioskLocation) {
        this.kioskLocation = kioskLocation;
    }

    public RichInputText getKioskLocation() {
        return kioskLocation;
    }

    public void setPaymentChannel(RichInputText paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public RichInputText getPaymentChannel() {
        return paymentChannel;
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String SubmitPaymentslog() {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        // Add event code here...
       
        if(getPvTPaidAmount().getValue() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter PVT Paid Amount"));
            
            return null; 
        }
         String  PVTPaidAmount = getPvTPaidAmount().getValue().toString();
        if(getPaymentDate().getValue() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Payment Date"));
            
            return null; 
        }
        Date sqlDate =(Date)getPaymentDate().getValue();
       
        java.sql.Date sqlDate1= new java.sql.Date(sqlDate.getTime());
        java.sql.Date CurrentDate =
            new java.sql.Date(new java.util.Date().getTime());
        if(getPaymentDate().getValue() != null) {
            if(sqlDate1.after(CurrentDate)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "payment date cannot be greater than current date"));
                
                return null; 
            }
        }
        
        if( getReceiptNumber().getValue() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Receipt Number"));
            
            return null; 
        }
       
         String ReceiptNumber = getReceiptNumber().getValue().toString();
        if( getTransactionID().getValue() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Transaction ID"));
            
            return null; 
        }
         
         String Transactionid = getTransactionID().getValue().toString();
        if( getKioskLocation().getValue() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please enter Kiosk Loction"));
            
            return null; 
        }
        
         String kiosklocation = getKioskLocation().getValue().toString();
//        if( getPaymentChannel().getValue() == null) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select Payment Channel"));
//            
//            return null; 
//        }
          String PaymentChannellov = null;
        String valuecode = null;
        JUCtrlListBinding listBinding1 =
                       (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PaymentsTypesLOVVO1");
        if(listBinding1.getSelectedValue() != null)
        {
                    PaymentChannellov = listBinding1.getSelectedValue().toString();
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings2 =
            bindings3.findIteratorBinding("PaymentsTypesLOVVO1Iterator");
            ViewObject paymenttypelovvo = dcItteratorBindings2.getViewObject();
            
            ViewObjectImpl paymentlov = (ViewObjectImpl)paymenttypelovvo;
            
            if(paymentlov!=null) {
                paymentlov.setWhereClause(null);
                paymentlov.setWhereClauseParams(null);
                paymentlov.setWhereClause("value_desc ='"+PaymentChannellov+"'");
                paymentlov.executeQuery();
                PaymentsTypesLOVVORowImpl paymentsrow = (PaymentsTypesLOVVORowImpl)paymenttypelovvo.first(); 
                if(paymentsrow !=null)
                 valuecode= paymentsrow.getvaluecode().toString();
                if(valuecode.equals("WBP"))
                    valuecode = "WEB";
             
                    
            }
                    
                    
          
               
               
            
           
           
        }
        
       //  String PaymentChannel = getPaymentChannel().getValue().toString();
        
        
        BindingContainer bindings1 = getBindings();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding opBinding = bindings.getOperationBinding("CallPaymentProcedure");
        
        opBinding.getParamsMap().put("PVTNumber", PVTNumber);    
        opBinding.getParamsMap().put("Amount", PVTPaidAmount);
        opBinding.getParamsMap().put("sqlDate", sqlDate1);
        
        opBinding.getParamsMap().put("ReceiptNumber", ReceiptNumber);
        
        opBinding.getParamsMap().put("Transactionid", Transactionid);
        
        opBinding.getParamsMap().put("kiosklocation", kiosklocation);
        
        opBinding.getParamsMap().put("PaymentChannel", valuecode);
        opBinding.getParamsMap().put("userName", userName);
        
        
     
        
        opBinding.execute();
        if( opBinding.getResult()!= null)
        {
        String message = opBinding.getResult().toString();
        if(message != null)
        {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",message) );
        }
        }
        else
        {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Paymnet Information updated successfully") ); 
            pageflowScope.put("Entered","cancel"); 
            resultstable.getSelectedRowKeys().clear();
            
        }
        
      
       
        getPvTPaidAmount().setValue(null);
        getPaymentDate().setValue(null);
        getTransactionID().setValue(null);
        getReceiptNumber().setValue(null);
        getKioskLocation().setValue(null);
        
    
        DCBindingContainer bindings3 =
          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("PaymentsTypesLOVVO1Iterator");
        ViewObject paymenttypelovvo = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl paymentlov = (ViewObjectImpl)paymenttypelovvo;
        paymentlov.setWhereClause(null);
        paymentlov.setWhereClauseParams(null);
        paymentlov.executeQuery();
        
        
        return null;
    }

    public void setPaymentDate(RichInputDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public RichInputDate getPaymentDate() {
        return paymentDate;
    }

    public void SelectedPVT(SelectionEvent selectionEvent) {
//       
        ADFUtil.invokeEL("#{bindings.PVTSearchRVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
        // get the selected row , by this you can get any attribute of that row
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTSearchRVO1Iterator.currentRow}"); 
            getPvTPaidAmount().setValue(null);
            getPaymentDate().setValue(null);
            getTransactionID().setValue(null);
            getReceiptNumber().setValue(null);
            getKioskLocation().setValue(null);
         
            DCBindingContainer bindings3 =
              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings2 =
            bindings3.findIteratorBinding("PaymentsTypesLOVVO1Iterator");
            ViewObject paymenttypelovvo = dcItteratorBindings2.getViewObject();
            
            ViewObjectImpl paymentlov = (ViewObjectImpl)paymenttypelovvo;
            paymentlov.setWhereClause(null);
            paymentlov.setWhereClauseParams(null);
            paymentlov.executeQuery();
         
            
        if(selectedRow != null)
        {
            PVTNumber = selectedRow.getAttribute("PVTNum").toString();
            System.out.println("PVTNumber");
            pageflowScope.put("Entered","Update"); 
           
         
        }
        }


    public String Cancel() {
        // Add event code here...
        pageflowScope.put("Entered","cancel"); 
        resultstable.getSelectedRowKeys().clear();
        getPvTPaidAmount().setValue(null);
        getPaymentDate().setValue(null);
        getTransactionID().setValue(null);
        getReceiptNumber().setValue(null);
        getKioskLocation().setValue(null);
    
        DCBindingContainer bindings3 =
          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("PaymentsTypesLOVVO1Iterator");
        ViewObject paymenttypelovvo = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl paymentlov = (ViewObjectImpl)paymenttypelovvo;
        paymentlov.setWhereClause(null);
        paymentlov.setWhereClauseParams(null);
        paymentlov.executeQuery();
        
        return null;
    }

    public void setPaymentlov(RichSelectOneChoice paymentlov) {
        this.paymentlov = paymentlov;
    }

    public RichSelectOneChoice getPaymentlov() {
        return paymentlov;
    }

    public void setResultstable(RichTable resultstable) {
        this.resultstable = resultstable;
    }

    public RichTable getResultstable() {
        return resultstable;
    }
}
