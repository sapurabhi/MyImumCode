package com.imum.cpms.view;



import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;



public class CreateCustomer {
    private Boolean enabled = false;
    private RichCommandButton utilityBillNumber;
    private RichCommandButton resetUtilityBillNumber;
    private RichInputText searchUtilityBillNumber;

    public CreateCustomer() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String doNew() {
        setEnabled(Boolean.FALSE);
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("doCustomerNew");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
    
    public String doEdit() {
        setEnabled(Boolean.FALSE);

           
            BindingContainer bindingsxec = getBindings();
            OperationBinding operationBinding = bindingsxec.getOperationBinding("doCustomerEdit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
            
         
        
        return null;
    }

    /**
     * @return
     */
    public String doCustomerSubmit() {
      
          
            BindingContainer bindingsxec = getBindings();
            OperationBinding operationBinding = bindingsxec.getOperationBinding("doCustomerSubmit");
            Object result = operationBinding.execute();
            if (!operationBinding.getErrors().isEmpty()) {
            return null;
            }
            
       BindingContext bctx = BindingContext.getCurrent(); 
        BindingContainer bc = bctx.getCurrentBindingsEntry();
        DCBindingContainer bindingsImpl = (DCBindingContainer)bc;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", " Customer data saved successfully!"));

       

            
            return null;
    }
   public String doCusAddressSearch() {
       System.out.println("utill number "+ this.getSearchUtilityBillNumber().getValue().toString());
       if (this.getSearchUtilityBillNumber().getValue().toString() != null)
       {
           DCBindingContainer bindings =
                         (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
           DCIteratorBinding dcItteratorBindings =
           bindings.findIteratorBinding("AddressDetailsUVO1Iterator");
           ViewObject AddrDetailsTableData = dcItteratorBindings.getViewObject();
     System.out.println("testing11111");
           AddrDetailsTableData.clearCache();
           AddrDetailsTableData.setWhereClause(null);
           System.out.println("testing222222");
           AddrDetailsTableData.setWhereClause("UTIL_BILL_NUM = '"+this.getSearchUtilityBillNumber().getValue().toString()+ "'");
           System.out.println("Query....." + AddrDetailsTableData.getQuery());
           AddrDetailsTableData.executeQuery();
       } 
      
       return null;
   }
   
    public String resetCusAddressSearch() {
        if (this.getSearchUtilityBillNumber().toString() != null)
        {
            setSearchUtilityBillNumber(null);
            
            DCBindingContainer bindings =
                          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("AddressDetailsUVO1Iterator");
            ViewObject AddrDetailsTableData = dcItteratorBindings.getViewObject();
      
            AddrDetailsTableData.clearCache();
            AddrDetailsTableData.cancelQuery();
            AddrDetailsTableData.executeEmptyRowSet();
        } 
       
        return null;
    }

    public void t1_selectionListener(SelectionEvent selectionEvent) {
        // Add event code here...
       /* ADFUtil.invokeEL("#{bindings.CustomerIndividualUVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},
                         new Object[] { selectionEvent });
        
        Row selectedRow =
            (Row)ADFUtil.evaluateEL("#{bindings.CustomerIndividualUVO1Iterator1.currentRow}"); */
        
       
    }

    public String doView() {
        setEnabled(Boolean.TRUE);
        BindingContainer bindingsxec = getBindings();
        OperationBinding operationBinding = bindingsxec.getOperationBinding("doCusIndView");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
        return null;
        }
       
        return null;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }


    public void setUtilityBillNumber(RichCommandButton utilityBillNumber) {
        this.utilityBillNumber = utilityBillNumber;
    }

    public RichCommandButton getUtilityBillNumber() {
        return utilityBillNumber;
    }

    public void setResetUtilityBillNumber(RichCommandButton resetUtilityBillNumber) {
        this.resetUtilityBillNumber = resetUtilityBillNumber;
    }

    public RichCommandButton getResetUtilityBillNumber() {
        return resetUtilityBillNumber;
    }

    public void setSearchUtilityBillNumber(RichInputText searchUtilityBillNumber) {
        this.searchUtilityBillNumber = searchUtilityBillNumber;
    }

    public RichInputText getSearchUtilityBillNumber() {
        return searchUtilityBillNumber;
    }
}
