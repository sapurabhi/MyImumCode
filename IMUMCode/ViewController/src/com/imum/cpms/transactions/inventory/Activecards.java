package com.imum.cpms.transactions.inventory;

import com.imum.cpms.util.MessageUtil;


import com.imum.ws.CardInactive.CardInactivepprovalBPMProcessPortType;
import com.imum.ws.CardInactive.CardInactivepprovalBPMProcessService;

import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessService;

import java.math.BigDecimal;

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
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class Activecards {
    private Boolean display=false;
    private RichInputText fromcardno;
    private RichInputText toCardno;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    private RichTable resultsTbl;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    String lngcode = httpSession.getAttribute("language").toString();
    MessageUtil msgUtil = new MessageUtil();
    private RichInputText remarks;

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public Activecards() {
        if(lngcode==null || lngcode.equals(""))
        {
            lngcode = "EN";
        }
    }
    @WebServiceRef
    private static CardInactivepprovalBPMProcessService cardInactivepprovalBPMProcessService;
    
    public void setFromcardno(RichInputText fromcardno) {
        this.fromcardno = fromcardno;
    }

    public RichInputText getFromcardno() {
        return fromcardno;
    }

    public void setToCardno(RichInputText toCardno) {
        this.toCardno = toCardno;
    }

    public RichInputText getToCardno() {
        return toCardno;
    }

    public String search() {
        int count=0;
    if(fromcardno.getValue()!=null && toCardno.getValue()!=null &&fromcardno.getValue()!=""&&toCardno.getValue()!="" ) {
        String strcard =fromcardno.getValue().toString();
        String endcard = toCardno.getValue().toString();
        if(endcard.length()>=strcard.length())
        {
        if(strcard.length()<7 && endcard.length()<7) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ples enter valid card number", msgUtil.getMessage("270000",lngcode))); 
           
        }
        else {
            if(strcard!=endcard) {
            OperationBinding opBinding = bindings.getOperationBinding("resultCards");
            opBinding.getParamsMap().put("str",strcard);
            opBinding.getParamsMap().put("end",endcard);
            count=Integer.parseInt(opBinding.execute().toString());
            if(count>0)
                display=true;
            } if(count <=0){
                display=false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No Data Found Please Redefine Your Search Crieteria", msgUtil.getMessage("000",lngcode))); 
                return null;
            }
        }  
    }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Valid from is not less then valid to", msgUtil.getMessage("2700",lngcode))); 
            return null;
           // System.out.println("Valid from is not less then valid to");
        }
    }
    else {
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter From Card Number and To Card Number", msgUtil.getMessage("2700",lngcode))); 
        //System.out.println("pls enter From Card Number and To card Number");
        return null;
    }
    return null;   
    }

    public void checkVC(ValueChangeEvent valueChangeEvent) {
        ViewObjectImpl vo = (ViewObjectImpl)bindingsAM.findIteratorBinding("ActiveCardsUVO1Iterator").getViewObject();
        RowSetIterator rs1 = vo.createRowSetIterator(null);
        rs1.reset();
        if(valueChangeEvent.getNewValue()!=null){
        Boolean flag = (Boolean)valueChangeEvent.getNewValue();
                if(flag!=null)
        {
           Row r=vo.getCurrentRow();
           
        System.out.println(r.getAttribute("inActive"));
        r.setAttribute("inActive",flag);
         
        }
        else  {
    
        }
        }
         }

    public String submitAction() {
        int count = resultsTbl.getRowCount();
        Boolean result;
        String loc="";
        String cardnum="";
        String userName="";
        Long seq=0L;
        ADFContext adfctx = ADFContext.getCurrent();
        if(adfctx.getSessionScope().get("loggedinUserid")!=null){
         userName = adfctx.getSessionScope().get("loggedinUserid").toString(); 
        } 
                if(count>0)
              {
                  DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                  DCIteratorBinding dcItterator =bindingsAM.findIteratorBinding("ActiveCardsUVO1Iterator");
                  ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();         
                  DCIteratorBinding dcItterator2 =bindingsAM.findIteratorBinding("InvCardInactivationHdrVO1Iterator");  
                  ViewObject Activecard =dcItterator2.getViewObject();    
                  DCIteratorBinding dcItterator1 =bindingsAM.findIteratorBinding("InvCardInactivationdtlVO1Iterator");
                   ViewObject Activecarddet =dcItterator1.getViewObject();
                  java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
                  RowSetIterator rsi=invDetailVO.createRowSetIterator(null);
                 
                  if(invDetailVO != null)
                  {
                      Row selectionRow[] = rsi.getFilteredRows("inActive",true);
                      Integer selectCount = selectionRow.length;
                      if(selectCount > 0)
                      {
                      // hrd call
                      
                          BindingContainer bin1 = getBindings();
                          OperationBinding opBinding = bin1.getOperationBinding("submitCards");
                          opBinding.getParamsMap().put("username",userName);
                         
                          opBinding.getParamsMap().put("loc","");
                          String resseq= opBinding.execute().toString();
                         System.out.println(resseq);
                         if(resseq!=null) {
                             seq = Long.valueOf(resseq);
                         }
                      
                if(resseq!=null) {
                   
                }
                          for(int i = 0;i<selectCount;i++)
                          {
                              Row invDetailRow = selectionRow[i];
                             
                              if(invDetailRow != null)
                              {
                                  String active = invDetailRow.getAttribute("inActive").toString();
                                  
                                  if(active=="true") {
                                      // invDetailRow.setAttribute("CardStatusID", 2);
                                      System.out.println(invDetailRow.getAttribute("Remarks"));
                                      if(invDetailRow.getAttribute("Remarks")!=null) {
                                      // set sates and remarks 
                                      
                                      invDetailRow.setAttribute("CardStatusID", 12);
                                       invDetailRow.setAttribute("Updateddate", sqlTime);
                                          if(invDetailRow.getAttribute("Locationid")!=null) {
                                              loc=invDetailRow.getAttribute("Locationid").toString();
                                          }
                                          if(invDetailRow.getAttribute("Cardnum")!=null) {
                                           cardnum = invDetailRow.getAttribute("Cardnum").toString();
                                          }
                                          String Remarksnew = null;
                                          if(invDetailRow.getAttribute("Remarksnew") != null)
                                           Remarksnew = invDetailRow.getAttribute("Remarksnew").toString();
                                        
                                          Row NewRowactived = Activecarddet.createRow();
                                          NewRowactived.setNewRowState(Row.STATUS_INITIALIZED);
                                          NewRowactived.setAttribute("InactivateHdrseq",resseq);
                                          NewRowactived.setAttribute("Cardnum",cardnum);
                                          NewRowactived.setAttribute("InactivationReason",invDetailRow.getAttribute("Remarks").toString());
                                          NewRowactived.setAttribute("CreatedBy",userName);
                                          NewRowactived.setAttribute("CreatedDate",sqlTime);
                                          NewRowactived.setAttribute("Approvedflag",'N');
                                          Activecarddet.insertRow(NewRowactived);                             
                                      System.out.println(sqlTime);
                                       System.out.println(invDetailRow.getAttribute("Remarks"));
                                          System.out.println(invDetailRow.getAttribute("Remarks"));
                                        
//                                          if(Remarksnew != null) 
//                                          {
//                                              
//                                              OperationBinding op2 = getBindings().getOperationBinding("CreateGenEventDetails");
//                                              op2.getParamsMap().put("depositAckSeqbigD",resseq);
//                                              op2.getParamsMap().put("NewDepSlip",Remarksnew );
//                                               op2.getParamsMap().put("OldDepSlip",null);
//                                              op2.getParamsMap().put("encoder",userName);
//                                              op2.getParamsMap().put("EventId",633);
//                                              op2.execute();
//                                          }
                                         
                                         
                                                           
                                      }
                                      else {
                                          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter remarkes", msgUtil.getMessage("2007",lngcode)));      
                                          
                                          result=false;
                                          break;
                                      }
                                  }
                                  
                                  System.out.println(invDetailRow.getAttribute("Cardnum"));
                                 String remarks = invDetailRow.getAttribute("Remarks").toString();
                                System.out.println(invDetailRow.getAttribute("Remarks"));
                                 
                              }
                          }
                          OperationBinding op1 = getBindings().getOperationBinding("doCommit");
                             op1.execute();
                             
                             
                          cardInactivepprovalBPMProcessService=new CardInactivepprovalBPMProcessService();
                          CardInactivepprovalBPMProcessPortType cardInactivepprovalBPMProcessPortType=cardInactivepprovalBPMProcessService.getCardInactivepprovalBPMProcessPort();
                          cardInactivepprovalBPMProcessPortType.start(seq);
                          if(op1.getErrors().isEmpty()){ 
                              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"\n" + "Selected Cards are Successfully sent approval for Inactivation with Sequence"+seq,null));
                              display=false;
                              AdfFacesContext.getCurrentInstance().addPartialTarget(resultsTbl);
                          }
                             

                       invDetailVO.executeQuery();
                          
                          display=false;
                      }
                      else
                      {
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select Atleast One", msgUtil.getMessage("327",lngcode))); 
                         
                          
                        
                      }                
                  }
              } 
        else
        {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select Atlest One", msgUtil.getMessage("327",lngcode))); 
           
            
          
        }  
        return null;
    }

    public void setResultsTbl(RichTable resultsTbl) {
        this.resultsTbl = resultsTbl;
    }

    public RichTable getResultsTbl() {
        return resultsTbl;
    }


  
    
    public String cancelAction() {
        ViewObjectImpl vo = (ViewObjectImpl)bindingsAM.findIteratorBinding("ActiveCardsUVO1Iterator").getViewObject();
        if(vo != null)
        {
            ViewCriteria vc = vo.getViewCriteria();
            vo.executeEmptyRowSet();
            if(vc != null)
            {
                vo.applyViewCriteria(vc);        
            }
        } 
        display=false;
        return null;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Boolean getDisplay() {
        return display;
    }

    public String displayTable() {
       
        display=false;
        return null;
    }

    public void setRemarks(RichInputText remarks) {
        this.remarks = remarks;
    }

    public RichInputText getRemarks() {
        return remarks;
    }
}
