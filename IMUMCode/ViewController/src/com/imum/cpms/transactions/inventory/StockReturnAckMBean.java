package com.imum.cpms.transactions.inventory;

import com.imum.cpms.model.transactions.vo.InvDetailUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class StockReturnAckMBean {
    private RichSelectOneChoice card_type;
    private String hide;
    DCBindingContainer bindingsAM =
        (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichCommandButton resetBtn;
    private RichCommandButton submitBtn;
    private RichCommandButton removeUnselected;
    private RichCommandButton selectDeselect;
    private  Integer  LocationID = null;
    private RichTable resultsTbl;
    private Integer selPos;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private RichSelectOneChoice location_Id;


    public StockReturnAckMBean() {
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        }
    }

    public void setCard_type(RichSelectOneChoice card_type) {
        this.card_type = card_type;
    }

    public RichSelectOneChoice getCard_type() {
        return card_type;
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String selectDeselect_All() {
        int count = resultsTbl.getRowCount();
        if(count>0)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();    
            if(invDetailVO != null)
            {
                Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
                Integer selectCount = selectionRow.length;
                for(int i = 0;i<count;i++)
                {
                    InvDetailUVORowImpl invDetailRow = (InvDetailUVORowImpl)invDetailVO.getRowAtRangeIndex(i);    
                    if(invDetailRow != null)
                    {
                        if(selectCount==count)
                        {
                            invDetailRow.setSelectFlag(false);            
                        }
                        else
                        {
                            invDetailRow.setSelectFlag(true);            
                        }                        
                    }
                }
                
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("154", lngCode)));                 
        }
        return null;
    }

    public String removeUnselectedRows() {
        int count = resultsTbl.getRowCount();
        System.out.println("count in removeUnselectedRow : "+count);
        if(count>0)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();    
            if(invDetailVO != null)
            {
//                Row selectionRowN[] = invDetailVO.getFilteredRows("SelectFlag",null);
//                Integer selectCountN = selectionRowN.length;
//                if(selectCountN > 0)removeResult(selectionRowN,selectCountN);
//                Row selectionRowF[] = invDetailVO.getFilteredRows("SelectFlag",false);
//                Integer selectCountF = selectionRowF.length; 
//                if(selectCountF > 0)removeResult(selectionRowF,selectCountF);
                
                Row selectionRowN[] = invDetailVO.getFilteredRows("SelectFlag",null);
                Integer selectCountN = selectionRowN.length;
                Row selectionRowF[] = invDetailVO.getFilteredRows("SelectFlag",false);
                Integer selectCountF = selectionRowF.length; 
                
                if (selectCountN != 0 || selectCountF != 0) {
                    if(selectCountN > 0){
                        removeResult(selectionRowN,selectCountN);
                    }                                      
                    if(selectCountF > 0){
                        removeResult(selectionRowF,selectCountF); 
                    }
                        
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("164", lngCode))); 
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("161", lngCode)));                    
        }
        return null;
    }
    public void removeResult(Row selectionRow[], Integer selectCount)
    {
           
                System.out.println("selectCount in removeUnselectedRow : "+selectCount);
                 for(int i = 0;i<selectCount;i++)
                 {
                     Row invDetailRow = selectionRow[i];
                     if(invDetailRow != null)
                     {
                        invDetailRow.removeFromCollection(); 
                     }
                 }   
        }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }

    public String fetchCards_Action() {
        Integer cardStatus = fetchCardStatus();
         LocationID=fetchLocationID();
        if(cardStatus != null && LocationID != null)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();  
            
            
            if(invDetailVO != null && cardStatus != null && LocationID != null)
            {
                invDetailVO.setWhereClause(null);
                String query = invDetailVO.getQuery();
                invDetailVO.setWhereClause("Card_Status_ID = "+cardStatus+" and Location_ID ='"+LocationID+"'");

                                                                                             
                invDetailVO.executeQuery();
                invDetailVO.setQuery(query);
                if(invDetailVO.getRowCount()>0)
                {
                    getResultsTbl().setRendered(true);
                    getSelectDeselect().setRendered(true);
                    getRemoveUnselected().setRendered(true);
                    getSubmitBtn().setRendered(true);
                    getResetBtn().setRendered(true);
                }
                else
                {
                    if(cardStatus==8)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("193", lngCode)));    
                    }
                    else if(cardStatus==10)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("194", lngCode)));    
                    }
                                     
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("135", lngCode)));         
        }
        return null;
    }

    public String Submit_Action() {
        String result = (String)validateCardAck();
               if(result != null && result.equalsIgnoreCase("pass"))
               {
                  BindingContainer bindings = getBindings();
                    OperationBinding opBinding =
                     bindings.getOperationBinding("commit");
                    opBinding.execute();   
                    DCBindingContainer bindings2 =(DCBindingContainer)getBindings();
                    DCIteratorBinding dcItteratorBindings1 =bindings2.findIteratorBinding("IssReturnHdrUVO1Iterator");
                    ViewObject HdrVO =dcItteratorBindings1.getViewObject();
                    HdrVO.executeQuery();
                    //OperationBinding op = bindings.getOperationBinding("getissdetailSeq");
                    //op.execute();
                    getResultsTbl().setRendered(false);
                    getSelectDeselect().setRendered(false);
                    getRemoveUnselected().setRendered(false);
                    getSubmitBtn().setRendered(false);
                    getResetBtn().setRendered(false);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("195", lngCode)));       
                }
        return null;
    }
    private String validateCardAck() {
        String result = "pass";
        String reasons=" ";
        String fromloc=null;
         int count = resultsTbl.getRowCount();
         if(count>0)
         
         {
         BigDecimal seq=null;
             DCIteratorBinding dcItterator =
                              bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
                          ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject(); 
          
             DCBindingContainer bindings2 =(DCBindingContainer)getBindings();
             DCIteratorBinding dcItteratorBindings1 =bindings2.findIteratorBinding("IssReturnHdrUVO1Iterator");
             ViewObject HdrVO =dcItteratorBindings1.getViewObject();
             Row r=HdrVO.last();
             if (r!=null)
             {
             Object ob =r.getAttribute("Issreturntrnseq");
            seq = (BigDecimal)ob;
             } 
             else 
                 seq=new BigDecimal(1);
                     
             
             
                          if(invDetailVO != null)
                          {
                              Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true); 
                      
                              if(selectionRow.length>0)
                              {
                                  
                                  BindingContainer bindings = getBindings();
                                  OperationBinding opBinding = bindings.getOperationBinding("pushIssReturnHeader");
                                  opBinding.getParamsMap().put("toLoc",1001);
                                  opBinding.getParamsMap().put("fromLoc",LocationID);
                                  opBinding.getParamsMap().put("tranType","R");
                                   opBinding.getParamsMap().put("dispatchDate",null);
                                   opBinding.getParamsMap().put("createdBy",httpSession.getAttribute("loggedinUserid").toString());
                                  opBinding.execute();
                                 
                                  for(int i = 0;i<selectionRow.length;i++)
                                  {
                                     
                                      Row invDetailRow = selectionRow[i];
                                      
                        if(invDetailRow != null)
                                      {
                                          Integer statusId = fetchCardStatus();
                                         if(statusId!=null &&statusId == 10)
                                         {
                                             invDetailRow.setAttribute("CardStatusID",11); 
                                             reasons="Damage";
                                         }
                                         else if(statusId!=null && statusId == 8)
                                         {
                                             invDetailRow.setAttribute("CardStatusID",3); 
                                             reasons="Excess";
                                         }
                                         invDetailRow.setAttribute("LOcationid", 1001);
                                         invDetailRow.setAttribute("Updatedby", httpSession.getAttribute("loggedinUserid").toString());
                                          java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime()); 
                                          invDetailRow.setAttribute("Updateddate", sqlDate);
                                          
                                          //detail
                                          DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
                                          DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("IssReturnDtlUVO1Iterator");
                                          ViewObject invslVO =dcItteratorBindings.getViewObject();
                                          
                                              Row dtlRow = invslVO.createRow();                                              
                                              dtlRow.setAttribute("Issreturntrnseq",seq.add(new BigDecimal(1)));
                                              dtlRow.setAttribute("CardType",invDetailRow.getAttribute("CardctgCode"));
                                      //String cardDenom =invDetailRow.getAttribute("CardDenomAmt").toString();
                                      
//                                          Integer cardDenom =(Integer)invDetailRow.getAttribute("CardDenomAmt");
//                                          BigDecimal cardDenomBD = new BigDecimal(cardDenom.toString()+".0000"); 
                                          BigDecimal denomAmt = (BigDecimal)invDetailRow.getAttribute("CardDenomAmt");
                                      
                                    //   BigDecimal denomAmt = new BigDecimal(cardDenom+".00");
                                           // BigDecimal denomAmt = (BigDecimal)invDetailRow.getAttribute("CardDenomAmt");
                                              dtlRow.setAttribute("CardDenomAmt",denomAmt); 
                                              dtlRow.setAttribute("FromCardnum",invDetailRow.getAttribute("Cardnum"));
                                              dtlRow.setAttribute("Tocardnum",invDetailRow.getAttribute("Cardnum"));
                                              dtlRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString()); 
                                              dtlRow.setAttribute("CreatedDate",sqlDate);                                            
                                              dtlRow.setAttribute("RetrunReasons","R");                                                                                     
                                              invslVO.insertRow(dtlRow); 
                                          
                                      }
                                      
                                  } 
                                 
                                  
                              }
                 
                              else
                              {
                                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("166", lngCode)));         
                                   result = "fail"; 
                              }
                         
            }
                          
                  
         }
         else
         {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("167", lngCode)));         
             result = "fail";
         } 
         return result;
    }
    public String Reset_Action() {
        getResultsTbl().setRendered(false);
        getSelectDeselect().setRendered(false);
        getRemoveUnselected().setRendered(false);
        getSubmitBtn().setRendered(false);
        getResetBtn().setRendered(false);
        return null;
    }

    public void setResetBtn(RichCommandButton resetBtn) {
        this.resetBtn = resetBtn;
    }

    public RichCommandButton getResetBtn() {
        return resetBtn;
    }

    public void setSubmitBtn(RichCommandButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public RichCommandButton getSubmitBtn() {
        return submitBtn;
    }

    public void setRemoveUnselected(RichCommandButton removeUnselected) {
        this.removeUnselected = removeUnselected;
    }

    public RichCommandButton getRemoveUnselected() {
        return removeUnselected;
    }

    public void setSelectDeselect(RichCommandButton selectDeselect) {
        this.selectDeselect = selectDeselect;
    }

    public RichCommandButton getSelectDeselect() {
        return selectDeselect;
    }

    private Integer fetchCardStatus() {
        DCIteratorBinding dcItterator =
            bindingsAM.findIteratorBinding("StckRetAckVO1Iterator");
        Row row = dcItterator.getCurrentRow();
        Integer statusId = null;
        if(row != null)
        {
            statusId = (Integer)row.getAttribute("CardStatus");
        }
        return statusId;
    }
    
   private Integer fetchLocationID() {
        DCIteratorBinding dcItterator =bindingsAM.findIteratorBinding("LocationIDRVO1Iterator");
        Row row = dcItterator.getCurrentRow();
        
        if(row != null)
        {
            LocationID = (Integer)row.getAttribute("LocationID");
        }
        return LocationID;
    }
    
    

    public void setResultsTbl(RichTable resultsTbl) {
        this.resultsTbl = resultsTbl;
    }

    public RichTable getResultsTbl() {
        return resultsTbl;
    }

    public void setLocation_Id(RichSelectOneChoice location_Id) {
        this.location_Id = location_Id;
    }

    public RichSelectOneChoice getLocation_Id() {
        return location_Id;
    }
       /*  public void setSelPos(Integer selPos) {
            this.selPos = selPos;
        }

        public Integer getSelPos() {
            return selPos;
        } */

   /*  public void LocationId(ValueChangeEvent valueChangeEvent) {

            DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

                Integer selectedPosIndex;
                selectedPosIndex = (Integer)valueChangeEvent.getNewValue();
                Integer selectedPos = null;
                if (selectedPosIndex != null)
                {
                    //Passing the LOV Iterator object and getting the list
                    JUCtrlListBinding list =(JUCtrlListBinding)bindings.get("LocationLVO1");
                    //Passing the selected Value index and getting the Row object
                    Row row =list.getRowIterator().getRowAtRangeIndex(selectedPosIndex);
                    selectedPos = (Integer)row.getAttribute("LocationID");
                    selPos = selectedPosIndex;
        }
        }*/

    public void setLocationID(Integer LocationID) {
        this.LocationID = LocationID;
    }

    public Integer getLocationID() {
        return LocationID;
    }
}

