package com.imum.cpms.view.backing;




import com.imum.cpms.model.transactions.vo.CreChqTrnValVerUVORowImpl;

import com.imum.cpms.model.transactions.vo.PVTDiscountHeaderSearchVORowImpl;
import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.adf.view.rich.model.AttributeCriterion;
import oracle.adf.view.rich.model.AttributeDescriptor;
import oracle.adf.view.rich.model.ConjunctionCriterion;
import oracle.adf.view.rich.model.Criterion;
import oracle.adf.view.rich.model.QueryDescriptor;

import oracle.adf.view.rich.model.QueryModel;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;
import oracle.jbo.uicli.binding.JUSearchBindingCustomizer;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;


public class CreChqTrnValVerMBean {
    private RichTable resultsTbl;
    private RichQuery richQuery;
    private RichInputText totalAmount;
    private RichSelectOneRadio ackStatus;
    //private Boolean selectedFlag = Boolean.FALSE;
    private RichSelectBooleanCheckbox check;
    private RichInputText countRows;

    public CreChqTrnValVerMBean() {
        if(lngcode==null || lngcode.equals(""))
        {
            lngcode = "EN";
        }
    }
    
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession httpSession = (HttpSession) externalContext.getSession(false);
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    String lngcode = httpSession.getAttribute("language").toString();
    MessageUtil msgUtil = new MessageUtil();
        
        private DCBindingContainer getBindings() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }


    public String SubmitAction() {
        Boolean result = validateCreChqValVer();
                if(result)
                {
                    OperationBinding op = getBindings().getOperationBinding("doCommit");
                    op.execute();  
                    
                    if(op.getErrors().isEmpty())
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", msgUtil.getMessage("27",lngcode)));       
                        //bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator").getViewObject().executeQuery();
                    }
                }
        return null;
    }
    public Boolean validateCreChqValVer()
        {
            Boolean result = true;
            ViewObjectImpl vo = (ViewObjectImpl)bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator").getViewObject();
            java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
          //  String userName = httpSession.getAttribute("loggedinUserid").toString();
            String userName = "anonymous"    ;
            int count = vo.getRowCount();
            if(count <= 0)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",  msgUtil.getMessage("28",lngcode))); 
                result = false;
            }
            else if(count > 0)
            {
                RowQualifier qualf = new RowQualifier("SelectFlag = "+true); 
                Row[] rows = vo.getFilteredRows(qualf);
                System.out.println("Row Count after filter is : "+vo.getRowCount());
                if(rows.length > 0)
                {
                    for(int i=0;i<rows.length;i++)
                    {
                        Row invDtlURow = rows[i];        
                        if(invDtlURow != null)
                        {
                            Object pymtType = invDtlURow.getAttribute("PYMTType");
                            if(pymtType == null)
                            {
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",msgUtil.getMessage("29",lngcode))); 
                                result = false;
                            }
                            else if(pymtType.equals("CCD") || pymtType.equals("KSK") || pymtType.equals("WBP"))
                            {
                                invDtlURow.setAttribute("CCDSlipAckUserID",userName);
                                invDtlURow.setAttribute("CCDSlipAckDate",sqlTime);   
                            }
                            else if(pymtType.equals("CHQ"))
                            {
                                invDtlURow.setAttribute("ChqAckUserID",userName);
                                invDtlURow.setAttribute("ChqAckDate",sqlTime);     
                            }                          
                        }
                    }
                }
                else if(rows.length <= 0)
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", msgUtil.getMessage("30",lngcode)));  
                    result = false;
                }                
            }
            return result;
        }

    public void selectFlagValChangeLstnr(ValueChangeEvent valueChangeEvent) {
       // int index = resultsTbl.getcRowIndex();
        ViewObjectImpl vo = (ViewObjectImpl)bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator").getViewObject();
       // CreChqTrnValVerUVORowImpl rowImpl = (CreChqTrnValVerUVORowImpl)vo.getRowAtRangeIndex(index);
       RowSetIterator rs1 = vo.createRowSetIterator(null);
       rs1.reset();  
      //ViewObjectImpl vo = (ViewObjectImpl)bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator").getViewObject();
             //  CreChqTrnValVerUVORowImpl row = (CreChqTrnValVerUVORowImpl)vo.getCurrentRow();
        if(valueChangeEvent.getNewValue()!=null){
        Boolean flag = (Boolean)valueChangeEvent.getNewValue();
                if(flag!=null)
      {
           Row r=vo.getCurrentRow();
           
       
       r.setAttribute("SelectFlag",flag);
            
            
            
       }
       else  {
          
           
       }
        }
    }

    public String CancelAction() {
        //getBindings().getOperationBinding("doRollback").execute();   
//        RichQuery queryComp = getRichQuery();    
//        QueryModel queryModel = queryComp.getModel();  
//        QueryDescriptor queryDescriptor = queryComp.getValue();  
//        queryModel.reset(queryDescriptor);  
//        queryComp.refresh(FacesContext.getCurrentInstance());  
          ViewObjectImpl vo = (ViewObjectImpl)bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator").getViewObject();
          if(vo != null)
          {
              ViewCriteria vc = vo.getViewCriteria();
              vo.executeEmptyRowSet();
              if(vc != null)
              {
                  vo.applyViewCriteria(vc);        
              }
          }
        
        return null;
    }

    public void processCustomListener(QueryEvent queryEvent) {
        QueryDescriptor qd = queryEvent.getDescriptor();   
        AttributeCriterion cri = qd.getCurrentCriterion();
//        String attrLabel = cri.getAttribute().getName();
        ConjunctionCriterion conCrit = qd.getConjunctionCriterion();
        List<Criterion> criterionList = conCrit.getCriterionList();

                for (Criterion criterion : criterionList) {
                    AttributeDescriptor attrDescriptor =  ((AttributeCriterion)criterion).getAttribute();

                    if (attrDescriptor.getName().equalsIgnoreCase("PYMTType")) { // EmployeeId is one of the query items in the search pane
                     Integer pymtType  =  (Integer)((AttributeCriterion)criterion).getValues().get(0);
                     //New Requirement in Prod-New column (Receipt Number) for Kiosk,Webpay
                     if(pymtType==0 || pymtType==1){
                         pageflowScope.put("pymtTypeRec","REC");
                     }else if(pymtType==2 || pymtType==3){
                         pageflowScope.put("pymtTypeRec","ESYS");
                     }
                     //End
                     if(pymtType==0)
                     {
                            pageflowScope.put("pymtTypeCrit","CHQ");
                }
                     else if(pymtType==1 || pymtType==2 || pymtType==3)
                     {
                            pageflowScope.put("pymtTypeCrit","CCD");
//                            70
                        }
                    }
                }               
        /** Gets the currently keyed in search criteria for quickQuery,
         *  You can do manipulate the values here :)
         */
//        String attrLabel = criterion.getAttribute().getLabel();   
//        Object attrValue = criterion.getValues().get(1); 
        DCBindingContainer bc =   
        (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();             
        /** The below call get ViewCriteria from the Search binding */  
        ViewCriteria vc = getViewCriteria(bc, qd);            
        /** Manipulate ViewCriteria, if you want and 
         *  then invoke query,optionally          */   
        invokeQueryEventMethodExpression("#{bindings.CreChqTrnValVerUVOCriteriaQuery2.processQuery}",   
               queryEvent);  
    }
    
    /**
       * Gets ViewCriteria used by the QueryModel
       */     
      private ViewCriteria getViewCriteria(DCBindingContainer bc,   
                QueryDescriptor qd) {   
                  
       Object execBinding =   
         bc.findExecutableBinding("CreChqTrnValVerUVOCriteriaQuery2");   
      ViewCriteria vc =   
       JUSearchBindingCustomizer.getViewCriteria((DCBindingContainer)execBinding, qd.getName());   
      return vc;   
        
      }  

    public String CheckAmount() {
        // Add event code here...
         int count = resultsTbl.getRowCount();
         BigDecimal totalAmt = null;
                 if(count>0)
               {
                   DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                   DCIteratorBinding dcItterator =bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator");
                   ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
                   if(invDetailVO != null)
                   {
                       Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
                       Integer selectCount = selectionRow.length;
                       if(selectCount > 0)
                       {
                           for(int i = 0;i<selectCount;i++)
                           {
                               Row invDetailRow = selectionRow[i];
                               if(invDetailRow != null)
                               {
                                   BigDecimal rowAmt = (BigDecimal)invDetailRow.getAttribute("PYMTAMT");
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

                           totalAmount.setValue(totalAmt);
                           countRows.setValue(selectCount);
                           
                       }
                       else
                       {
                           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select Atlest One", msgUtil.getMessage("327",lngcode))); 
                          
                           
                           totalAmount.setValue("");
                           countRows.setValue("");
                       }                
                   }
               }
               else
               {
                   
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter Atleast One Search Field Value", msgUtil.getMessage("326",lngcode))); 
                  // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please Enter Atleast One Search Field Value"));
                  // genMsg.getMessage("162", lngCode));      
               }
               
          
       
        return null;
    }
    private void invokeQueryEventMethodExpression(String expression,   
                   QueryEvent queryEvent) {   
                     
      FacesContext fctx = FacesContext.getCurrentInstance();   
      ELContext elctx = fctx.getELContext();   
      ExpressionFactory efactory = fctx.getApplication().getExpressionFactory();   
      MethodExpression me = efactory.createMethodExpression(elctx, expression, Object.class,   
                 new Class[] { QueryEvent.class });   
      me.invoke(elctx, new Object[] { queryEvent }); 
                   }
    public String selectAllAck() {
            // Add event code here...
            int count = resultsTbl.getRowCount();
        if(count>0)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
            String voName = (String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("voName");
                   String iteratorName = voName + "Iterator";
            Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
        Integer selectCountN = selectionRow.length;
            if(selectCountN != 0)
        for(int i = 0;i<selectCountN;i++) {
     selectionRow[i].setAttribute("Ackstatusid",1);
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select Atlest One", msgUtil.getMessage("327",lngcode))); 
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Please Select Atlest One"));  
        }
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter Atleast One Search Field Value", msgUtil.getMessage("326",lngcode))); 
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please Enter Atleast One Search Field Value"));
        }
         
            
      return null;
        
    }

   
    
    public void setResultsTbl(RichTable resultsTbl) {
        this.resultsTbl = resultsTbl;
    }

    public RichTable getResultsTbl() {
        return resultsTbl;
    }

    public void setRichQuery(RichQuery richQuery) {
        this.richQuery = richQuery;
    }

    public RichQuery getRichQuery() {
        return richQuery;
    }

    public void setTotalAmount(RichInputText totalAmount) {
        this.totalAmount = totalAmount;
    }

    public RichInputText getTotalAmount() {
        return totalAmount;
    }

    public void setAckStatus(RichSelectOneRadio ackStatus) {
        this.ackStatus = ackStatus;
    }

    public RichSelectOneRadio getAckStatus() {
        return ackStatus;
    }

    public void selectDeselect(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        String s="";
        DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator");
                ViewObjectImpl invDetailVO =(ViewObjectImpl)dcItterator.getViewObject();
                //int count = resultsTbl.getRowCount();
              if(valueChangeEvent.getNewValue()!=null) {
               //s=valueChangeEvent.getNewValue().toString();       
               if (invDetailVO != null) {
                   for (int i =0 ; i <invDetailVO.getEstimatedRowCount(); i++) {
                       CreChqTrnValVerUVORowImpl invDetailRow =
                           (CreChqTrnValVerUVORowImpl)invDetailVO.getRowAtRangeIndex(i);
                      
                       if (invDetailRow != null) {
                           //invDetailRow.setSelectFlag(false);
                           invDetailRow.setSelectFlag((Boolean)valueChangeEvent.getNewValue());
                           
                          
                       }

                   }
            }
              }
               
                /* if(s.equals("true")&& count!=0) {
                    if (count > 0) {
                        if (invDetailVO != null) {
                            for (int i =0 ; i <invDetailVO.getEstimatedRowCount(); i++) {
                                CreChqTrnValVerUVORowImpl invDetailRow =
                                    (CreChqTrnValVerUVORowImpl)invDetailVO.getRowAtRangeIndex(i);
                               
                                if (invDetailRow != null) {
                                    //invDetailRow.setSelectFlag(false);
                                    invDetailRow.setSelectFlag(true);
                                    
                                   System.out.println(invDetailRow.getReceiptNum());
                                }

                            }


                        }
                        
                    }
                    
        else {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please enter atleast one search field Value")); 
             
           }
        
        
        
    }
                    
                    if(s.equals("false")&& count!=0) {
                        if (count > 0) {
                            if (invDetailVO != null) {
                                for (int i =0 ; i <invDetailVO.getEstimatedRowCount(); i++) {
                                    CreChqTrnValVerUVORowImpl invDetailRow =
                                        (CreChqTrnValVerUVORowImpl)invDetailVO.getRowAtRangeIndex(i);
                                    if (invDetailRow != null) {
                                        invDetailRow.setSelectFlag(false);
                                        invDetailRow.setAckstatusid(0);
                                        System.out.println(invDetailRow.getReceiptNum());
                                    }

                                }


                            }
                            
                        }
                        else {
                               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please enter atleast one search field Value")); 
                             
                           }
                        
                    
                    
                    }
                        
                    
                    */
                AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTbl());
                    }


    public void setCheck(RichSelectBooleanCheckbox check) {
        this.check = check;
    }

    public RichSelectBooleanCheckbox getCheck() {
        return check;
    }



    public void buttonselect() {
        DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator");
        ViewObjectImpl invDetailVO =(ViewObjectImpl)dcItterator.getViewObject();
        
    //        for (Row row = invDetailVO.first();row != null;row = invDetailVO.next()){
    //
    //            row.setAttribute("SelectFlag", true);
    //           // row.setAttribute("Ackstatusid",0);
    //        }
           
        int count = resultsTbl.getRowCount();
        if(count>0)
        {
                   System.out.println(resultsTbl.getRowCount());
            RowSetIterator rs1 = invDetailVO.createRowSetIterator(null);
            rs1.reset();

            System.out.println(invDetailVO.getEstimatedRowCount());
         int c=0;
            while (rs1.hasNext()) {
                Row r = rs1.next();
                r.setAttribute("SelectFlag", true);
                
                System.out.println("r - " + r);
                
                c++;
            }
            System.out.println(c);
            System.out.println(resultsTbl.getRowCount());
        }   
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter Atleast One Search Field Value", msgUtil.getMessage("326",lngcode))); 
          //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please Enter Atleast One Search Field Value")); 
        }
        
    }
    
    
  








    public void setCountRows(RichInputText countRows) {
        this.countRows = countRows;
    }

    public RichInputText getCountRows() {
        return countRows;
    }

    public String deSelect() {
        DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator");
        DCIteratorBinding dcItterator1 = bindingsAM.findIteratorBinding("CreChqTrnValVerUVO1Iterator1");
        
        ViewObjectImpl invDetailVO =(ViewObjectImpl)dcItterator.getViewObject();
        ViewObjectImpl invDetailVO1 =(ViewObjectImpl)dcItterator1.getViewObject();
        int count = resultsTbl.getRowCount();
        
        if(count>0)
        {
     
            RowSetIterator rs1 = invDetailVO.createRowSetIterator(null);
            rs1.reset();  
            RowSetIterator rs2 = invDetailVO1.createRowSetIterator(null);
          //  rs1.reset(); 
            while (rs1.hasNext() && rs2.hasNext()) {
                Row r1=rs2.next();
                Row r = rs1.next();
                //Row r1=rs2.next();
                r.setAttribute("SelectFlag", false);
           r.refresh(r.REFRESH_WITH_DB_FORGET_CHANGES);
              
            }
            
           
            invDetailVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTbl());
         
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter Atleast One Search Field Value", msgUtil.getMessage("326",lngcode))); 
          
        }
       
        totalAmount.resetValue();
        countRows.resetValue();
       
        return null;
    }


   
}
