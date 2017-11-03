package com.imum.cpms.view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.ADFUtil;

public class ADPSearchReportMBean {
    public ADPSearchReportMBean() {
    }
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String print() {
        // Add event code here...
        try{
            BindingContainer bindingsCust = getBindings(); 
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTSearchRVO1Iterator.currentRow}"); 
            if(selectedRow != null)
            {
                Object PVTHeaderIDpvt = selectedRow.getAttribute("PVT_HDR_SEQ");
            DCBindingContainer bindings =
                          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding Customer = bindings.getOperationBinding("ADPPrintDetails");
             Customer.getParamsMap().put("PVTHeaderId", PVTHeaderIDpvt); 
          
            Object result = Customer.execute();
            }
        }
        catch (Exception e) {
                   System.out.println("Error occurred..." + e.toString());
               }
      
        return null;
    }

    public void Printable(ActionEvent actionEvent) {
        // Add event code here...
        try{
            BindingContainer bindingsCust = getBindings(); 
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTSearchRVO1Iterator.currentRow}"); 
            if(selectedRow != null)
            {
                Object PVTHeaderID = selectedRow.getAttribute("PVTHDRSEQ");
                if(PVTHeaderID != null)
                {
                String PVTHeaderIDpvt = selectedRow.getAttribute("PVTHDRSEQ").toString();
                
            DCBindingContainer bindings =
                          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding Customer = bindings.getOperationBinding("ADPPrintDetails");
             Customer.getParamsMap().put("PVTHeaderId", PVTHeaderIDpvt); 
          
            Object result = Customer.execute();
                }
            }
        }
        catch (Exception e) {
                   System.out.println("Error occurred..." + e.toString());
               }
        
    }
}
