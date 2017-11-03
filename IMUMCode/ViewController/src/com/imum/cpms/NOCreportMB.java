package com.imum.cpms;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.ADFUtil;

public class NOCreportMB {
    public NOCreportMB() {
    }
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public void actionPrint(ActionEvent actionEvent) {
        try{
            BindingContainer bindingsCust = getBindings(); 
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTSearchRVO1Iterator.currentRow}"); 
            if(selectedRow != null)
            {
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("date",sqlDate);
                Object PVTHeaderID = selectedRow.getAttribute("PVTHDRSEQ");
                if(PVTHeaderID != null)
                {
                String PVTHeaderIDpvt = selectedRow.getAttribute("PVTHDRSEQ").toString();
             
                }
                DCIteratorBinding dcItteratorBinding =getBindings().findIteratorBinding("pvtpaymentVO1Iterator");
                ViewObject appVO = dcItteratorBinding.getViewObject();
                appVO.setWhereClause("PVT_HDR_SEQ = '"+PVTHeaderID+"'");
                appVO.executeQuery();

                Row row = appVO.first();
                if(row!=null) {
                    Object attribute = row.getAttribute("Saledate");
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("paydate",sqlDate);
                    System.out.println(attribute);
                }
                
            }
            
                
                
        }
        catch (Exception e) {
                   System.out.println("Error occurred..." + e.toString());
               }
      
      
      
      
      
    }
}
