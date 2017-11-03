package com.imum.cpms.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.HashMap;

import java.util.Map;

import oracle.adf.view.rich.event.QueryOperationEvent;



import javax.faces.context.FacesContext;



import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import java.util.HashMap;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.RichQuery;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.model.QueryDescriptor;
import oracle.adf.view.rich.model.QueryModel;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;


public class PermitSearchResMBean {
    public PermitSearchResMBean() {
    }
    private Map<String, Object> parameterMap = new HashMap<String, Object>();
    private RichCommandLink filePropertyCommandLink;
//    public BindingContainer getBindings() {
//        return BindingContext.getCurrent().getCurrentBindingsEntry();
//    }
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String PermitSearchselectionlistener(SelectionEvent selectionEvent) {
        try {
                ADFUtil.invokeEL("#{bindings.PermitSearchCriteriaVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });

                // get the selected row , by this you can get any attribute of that row
                Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PermitSearchCriteriaVO1Iterator.currentRow}"); // get the current selected row
               // Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PermitSearchCriteriaVO1.collectionModel.selectedRow}");
            
            
            
        
              if(selectedRow != null) {
                  FacesContext context = FacesContext.getCurrentInstance();
                  context.getApplication().getNavigationHandler().handleNavigation(context,null,"success");
                Object PermitNumber= selectedRow.getAttribute("PermitNumber");
                System.out.println("PermitNumber"+PermitNumber);
                Object PermitSequence = selectedRow.getAttribute("PRMHeaderseq");
                System.out.println("prm seq"+PermitSequence);
                Object CustomerId = selectedRow.getAttribute("CustID");
                System.out.println(""+CustomerId);
                Number plateId = (Number)selectedRow.getAttribute("vhlplateid");
                System.out.println("plateId"+plateId);
                String CategCode = selectedRow.getAttribute("Categcode").toString();
                System.out.println("CategCode : "+CategCode);
                
                DCBindingContainer bindings =
                              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindings =
                bindings.findIteratorBinding("PermitSearchCriteriaVO1Iterator");
                DCIteratorBinding dcItteratorBindingsCust =
                bindings.findIteratorBinding("PermitSearchCriteriaVO1Iterator");
                ViewObject PermitTableData = dcItteratorBindings.getViewObject();
                System.out.println("Query is : "+PermitTableData.getQuery());
                
//                    PermitTableData.clearCache();
//                                        PermitTableData.setWhereClause(null);
//                                        PermitTableData.setWhereClause("PRM_Header_seq = '"+PermitSequence+"'");
//                                        PermitTableData.executeQuery();
                System.out.println(PermitTableData.getRowCount());
                

                BindingContainer bindingsCust = getBindings(); 
               
                OperationBinding Customer = bindings.getOperationBinding("PermitDetails");
                 Customer.getParamsMap().put("CustomerId", CustomerId); 
                Customer.getParamsMap().put("PermitSequence", PermitSequence); 
                Customer.getParamsMap().put("PlateId", plateId); 
                Customer.getParamsMap().put("CategCode", CategCode); 
                System.out.println("plateid"+plateId);
                Object result = Customer.execute();
            }
        } catch (Exception e) {
            System.out.println("Error occurred..." + e.toString());
        }
             return "success";
              
            }

    public String cb1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context,null,"Back");
        DCBindingContainer bindings =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
        bindings.findIteratorBinding("PermitSearchCriteriaVO1Iterator");
       ViewObject PermitTableData = dcItteratorBindings.getViewObject();
         System.out.println("Query is : "+PermitTableData.getQuery());
        Number permitNumber =0;
//            PermitTableData.clearCache();
//        PermitTableData.setWhereClause(null);    
//        PermitTableData.setWhereClauseParams(null);
//       PermitTableData.executeQuery();
        
        /*RichQuery queryComp = getRichQuery();  
             QueryModel queryModel = queryComp.getModel();  
             QueryDescriptor queryDescriptor = queryComp.getValue();  
             queryModel.reset(queryDescriptor);  
             queryComp.refresh(FacesContext.getCurrentInstance()); */ 
             
//        PermitTableData.executeEmptyRowSet();
        System.out.println(PermitTableData.getRowCount());
        
        
        return null;
    }


    public String PermitSearchselectionlistener() {
      
        try {
                //ADFUtil.invokeEL("#{bindings.PermitSearchCriteriaVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });

                // get the selected row , by this you can get any attribute of that row
                Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PermitSearchCriteriaVO1Iterator.currentRow}"); // get the current selected row
               // Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PermitSearchCriteriaVO1.collectionModel.selectedRow}");
             

               
            
        
              if(selectedRow != null) {
                DCBindingContainer bindings =
                              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindingsCust =
                bindings.findIteratorBinding("PermitSearchCriteriaVO1Iterator");
                System.out.println("Current Query is : "+dcItteratorBindingsCust.getViewObject().getQuery());
                
                  FacesContext context = FacesContext.getCurrentInstance();
                  context.getApplication().getNavigationHandler().handleNavigation(context,null,"success");
                Object PermitNumber= selectedRow.getAttribute("PermitNumber");
                System.out.println("PermitNumber"+PermitNumber);
                Object PermitSequence = selectedRow.getAttribute("PRMHeaderseq");
                System.out.println("prm seq"+PermitSequence);
                Object CustomerId = selectedRow.getAttribute("CustID");
                System.out.println(""+CustomerId);
                Object plateId = selectedRow.getAttribute("vhlplateid");
                System.out.println("plateId"+plateId);
                
                String CategCode = selectedRow.getAttribute("Categcode").toString();
                System.out.println("CategCode : "+CategCode);
                
             
                

                DCIteratorBinding dcItteratorBindings =
                bindings.findIteratorBinding("PermitSearchCriteriaVO1Iterator");
               ViewObject PermitTableData = dcItteratorBindings.getViewObject();
                 

//                    PermitTableData.clearCache();
//                                        PermitTableData.setWhereClause(null);
//                                        PermitTableData.setWhereClause("PRM_Header_seq = '"+PermitSequence+"'");
//                                        PermitTableData.executeQuery();
                System.out.println(PermitTableData.getRowCount());
                

                BindingContainer bindingsCust = getBindings(); 
               
                OperationBinding Customer = bindings.getOperationBinding("PermitDetails");
                 Customer.getParamsMap().put("CustomerId", CustomerId); 
                Customer.getParamsMap().put("PermitSequence", PermitSequence); 
                Customer.getParamsMap().put("PlateId", plateId); 
                Customer.getParamsMap().put("CategCode", CategCode); 
                System.out.println("plateid"+plateId);
                Object result = Customer.execute();
            }
        } catch (Exception e) {
            System.out.println("Error occurred..." + e.toString());
        }
             return "success";
    }

    public void ResetSearchPage(QueryOperationEvent queryOperationEvent) {
          invokeMethodExpression("#{bindings.PermitSearchCritVOCriteriaQuery.processQueryOperation}",
        Object.class,   
                                 new Class[]{ QueryOperationEvent.class},  
                                 new Object [] {queryOperationEvent});
          
          if(queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")){
              
              getBindings().findIteratorBinding("PermitSearchCriteriaVO1Iterator").getViewObject().executeEmptyRowSet();
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
    
    public void setFilePropertyCommandLink(RichCommandLink filePropertyCommandLink) {
        this.filePropertyCommandLink = filePropertyCommandLink;
    }

    public RichCommandLink getFilePropertyCommandLink() {
        return filePropertyCommandLink;
    }


    
    
}
