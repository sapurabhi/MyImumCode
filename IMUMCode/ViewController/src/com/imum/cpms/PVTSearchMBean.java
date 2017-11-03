package com.imum.cpms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.el.ELContext;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PVTSearchMBean {
    private RichTable pvTSearchResultTable;

    public PVTSearchMBean() {}
    
    public void updateSelectedPVTNum(ActionEvent actionEvent){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                       //get current date time with Date()
                       Date date = new Date();
                       System.out.println(dateFormat.format(date));
        DCIteratorBinding binding = getBindings().findIteratorBinding("PVTSearchRVO1Iterator1");
        
        ADFContext.getCurrent().getPageFlowScope().put("PVTNum",binding.getCurrentRow().getAttribute("PVTNum").toString());
        System.out.println("Selected Row PVT Number is : "+binding.getCurrentRow().getAttribute("PVTNum"));
        System.out.println("Exiting action listener "+dateFormat.format(date));
            
        }
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void ResetSearchPage(QueryOperationEvent queryOperationEvent) {
          invokeMethodExpression("#{bindings.PVTSearchRVOCriteriaQuery1.processQueryOperation}",
        Object.class,   
                                 new Class[]{ QueryOperationEvent.class},  
                                 new Object [] {queryOperationEvent});
          
          if(queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")){
              getBindings().findIteratorBinding("PVTSearchRVO1Iterator1").getViewObject().executeEmptyRowSet();
//              AdfFacesContext.getCurrentInstance().addPartialTarget((UIComponent)getPvTSearchResultTable);
//                  resId1
              }
        
        // Add event code here...
    }
    
    public Object invokeMethodExpression(String expr, Class returnType,  
                                           Class[] argTypes, Object[] args)  
      {  
        FacesContext fc = FacesContext.getCurrentInstance();  
        ELContext elctx = fc.getELContext();  
        ExpressionFactory elFactory =  
          fc.getApplication().getExpressionFactory();
//        ExpressionFactory expressionFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr =  
          elFactory.createMethodExpression(elctx, expr, returnType, argTypes);  
        return methodExpr.invoke(elctx, args);  
      }

    public void setPvTSearchResultTable(RichTable pvTSearchResultTable) {
        this.pvTSearchResultTable = pvTSearchResultTable;
    }

    public RichTable getPvTSearchResultTable() {
        return pvTSearchResultTable;
    }
}
