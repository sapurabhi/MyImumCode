package com.imum.cpms.transactions.inventory;

import com.imum.cpms.model.transactions.vo.CardIssueSrchCriVOImpl;

import com.imum.cpms.model.transactions.vo.CardIssueSrchCriVORowImpl;

import com.imum.cpms.model.transactions.vo.InvDetailUVORowImpl;

import com.imum.cpms.model.transactions.vo.IssReturnHdrUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;

public class CardIssuanceMBean {
    private RichInputText total_num_cards;
    private RichTable invDtlResult;
    private String hide;
    private RichTable invSearchTbl;
    private RichToolbar checkAvlBTN;
    private RichCommandButton selectDeselect;
    private RichPanelFormLayout totalForm;
    private RichCommandButton submitBtn;
    private RichSelectOneChoice locationId;
    Object cscLoc = null;
    private RichCommandButton removeUnselected;
    private RichInputText total_amount;
    private RichInputDate dispatchDate;
    private RichInputText endNumDisplay;
    DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichCommandButton resetBtn;
    private RichCommandButton removeCards;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private RichInputText transRefNumber;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    
    BindingContainer bindings = getBindings();

    public CardIssuanceMBean() {
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        } 
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public String checkAvailability_Action() {
        getTransRefNumber().setValue(null);
        DCIteratorBinding checkAvailDB = bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
        ViewObject checkAvailVO = checkAvailDB.getViewObject();   
        checkAvailVO.clearCache();
        checkAvailVO.executeEmptyRowSet();
        checkAvailVO.reset();
        checkAvailVO.cancelQuery();        
        
        
        total_num_cards.setValue(null);
        total_amount.setValue(null);
        
        
        String cardCrit = null;
        String cardCriteriaNoWhere = null;
        Integer NoWhereNumberOfCards = null;
        
        String result = "pass";
        DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("CardIssueSrchCriVO1Iterator");
        ViewObject cardIssVO = dcItteratorBinding.getViewObject();     
        if(cardIssVO != null)
        {
            Long count = cardIssVO.getEstimatedRowCount();
            if(count>0)
            {       
                DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
                ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject(); 
                invDetailVO.refreshWhereClauseParams();
                String queryBase = invDetailVO.getQuery();
                String queryUpdate = null;
                
                for(int i=0;i<count;i++)
                {
                    String queryTop = null;
                    CardIssueSrchCriVORowImpl cardIssRow   = (CardIssueSrchCriVORowImpl)cardIssVO.getRowAtRangeIndex(i);
                    if(cardIssRow != null)
                    {
                        Object cardType = cardIssRow.getCardType();
                        if(cardType != null)
                        {
//                            if(cardType.equals("2"))//recharge cards check for expiry date greater than currentdate
//                            {
//                                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//                                cardCrit = " WHERE Card_Status_ID = 3 and location_id=1001 and Card_Type_code = '"+cardType+"' and Expiry_Date >= '"+sqlDate+"'"; //expiry_date > '2014-07-28'     
//                                cardCriteriaNoWhere = " Card_Status_ID = 3 and location_id=1001 and Card_Type_code = '"+cardType+"' and Expiry_Date >= '"+sqlDate+"'";
//                            } else {
                                cardCrit = " WHERE Card_Status_ID = 3 and location_id=1001 and Card_ctg_Code = '"+cardType+"'";
                                cardCriteriaNoWhere = " Card_Status_ID = 3 and location_id=1001 and Card_ctg_Code = '"+cardType+"'";
//                            }
                                                 
                            Object denom = cardIssRow.getDenomination();
                            if(denom != null)
                            {
                               cardCrit= cardCrit+ "and Card_Denom_Amt = "+denom;
                               cardCriteriaNoWhere= cardCriteriaNoWhere + " and Card_Denom_Amt = "+denom;
                                
                               Integer numOfCards = cardIssRow.getNoOfCards();
                                NoWhereNumberOfCards = cardIssRow.getNoOfCards();
                               Object Startnum = cardIssRow.getStartNum();

                                   if(Startnum != null)
                                   {
//                                       cardCrit= cardCrit+ " and Card_num LIKE '"+Startnum+"%'"; 
//                                       cardCriteriaNoWhere= cardCriteriaNoWhere + " and Card_num LIKE '"+Startnum+"%'"; 
                                       
                                       String lengthOfCardNum = "0";
                                       String nineLengthOfCardNum = "9";
                                       
                                       OperationBinding operationBinding = bindings.getOperationBinding("cardTypeLength");
                                       operationBinding.getParamsMap().put("cardType", cardType.toString());
//                                       operationBinding.getParamsMap().put("denom", denom.toString());
                                       lengthOfCardNum = (String)operationBinding.execute();
                                       System.out.println("lengthOfCardNum....." + lengthOfCardNum);
                                       int intLengthOfCardNum = Integer.parseInt(lengthOfCardNum);
                                       for (int l=1; l<=intLengthOfCardNum-1; l++) {
                                           nineLengthOfCardNum = nineLengthOfCardNum + "9";                                            
                                       }
                                       
                                       System.out.println("Generated 9ssss...." + nineLengthOfCardNum);
                                       
                                       if (Startnum.toString().length() != intLengthOfCardNum) {
                                           cardCrit= cardCrit+ " and Card_num between '"+Startnum+"%' and '"+nineLengthOfCardNum+"'";
                                           cardCriteriaNoWhere= cardCriteriaNoWhere + " and Card_num between '"+Startnum+"%' and '"+nineLengthOfCardNum+"'";
                                       } else {
                                           cardCrit= cardCrit+ " and Card_num between '"+Startnum+"' and '"+nineLengthOfCardNum+"'";
                                           cardCriteriaNoWhere= cardCriteriaNoWhere + " and Card_num between '"+Startnum+"' and '"+nineLengthOfCardNum+"'";    
                                       }
                                   }
                                  if(numOfCards!=null)
                                   {
                                       System.out.println("@@@@@@@Number of cards != null");
                                       
                                       queryTop = "SELECT TOP "+numOfCards+" InvDetailEO.Inv_Detail_Seq,\n" + 
                                       "     InvDetailEO.Card_num,\n" + 
                                       "     InvDetailEO.LOcation_id, \n" + 
                                       "     InvDetailEO.Despatch_date_CCO, \n" + 
                                       "     InvDetailEO.Received_Date_CSC, \n" + 
                                       "     InvDetailEO.Card_Denom_Amt, \n" + 
                                       "     InvDetailEO.Sale_Date,\n" + 
                                       "     InvDetailEO.Customer_ID,\n" + 
                                       "      InvDetailEO.Org_Card_num, \n" + 
                                       "     InvDetailEO.RC_Card_active_date,\n" + 
                                       "     InvDetailEO.Expiry_Date,\n" + 
                                       "     InvDetailEO.upload_count,\n" + 
                                       "       InvDetailEO.Created_By, \n" + 
                                       "       InvDetailEO.Created_Date,     \n" + 
                                       "     InvDetailEO.Updated_by,\n" + 
                                       "     InvDetailEO.Card_Status_ID,\n" + 
                                       "     InvDetailEO.Updated_date, \n" + 
                                       "     InvDetailEO.CSA_Assigned_Date, \n" + 
                                       "     InvDetailEO.CSA_Assigned_To,\n" + 
                                       "     InvDetailEO.Sale_hdr_seq,\n" + 
                                       //  "       InvDetailEO.CVV_CODE,\n" +
                                       "       InvDetailEO.Card_ctg_Code,\n" + 
                                       "     InvDetailEO.Sale_Shift_ID,      \n" + 
                                       "     InvDetailEO.Bulk_Sale_Flag,     \n" + 
                                       "(select distinct card_type_name from  inv_card_type_mst where category = InvDetailEO.Card_ctg_Code)cardTypeDesc,\n" + 
                                       "(select card_status_desc from  INV_Card_status_mst where card_status_id = InvDetailEO.Card_Status_ID)cardStatusDesc,\n" + 
                                       "(select loc_desc from gen_location_mst where location_id = InvDetailEO.location_id)LocationDesc\n" +
                                       "FROM  INV_INVENTORY_DETAIL InvDetailEO";
                                       
                                      /* queryTop = "SELECT TOP "+numOfCards+" InvDetailEO.CSA_Assigned_Date, \n" + 
                                       "       InvDetailEO.CSA_Assigned_To, \n" + 
                                       "       InvDetailEO.Card_Denom_Amt, \n" + 
                                       "       InvDetailEO.Card_Status_ID, \n" + 
                                       "       InvDetailEO.Card_Type_code, \n" + 
                                       "       InvDetailEO.Card_num, \n" + 
                                       "       InvDetailEO.Created_By, \n" + 
                                       "       InvDetailEO.Created_Date, \n" + 
                                       "       InvDetailEO.Customer_ID, \n" + 
                                       "       InvDetailEO.Despatch_date_CCO, \n" + 
                                       "       InvDetailEO.Expiry_Date, \n" + 
                                       "       InvDetailEO.Inv_Detail_Seq, \n" + 
                                       "       InvDetailEO.LOcation_id, \n" + 
                                       "       InvDetailEO.Org_Card_num, \n" + 
                                       "       InvDetailEO.RC_Card_active_date, \n" + 
                                       "       InvDetailEO.Received_Date_CSC, \n" + 
                                       "       InvDetailEO.Sale_Date, \n" + 
                                       "       InvDetailEO.Sale_hdr_seq, \n" + 
                                       "       InvDetailEO.Shift_ID, \n" + 
                                       "       InvDetailEO.Updated_by, \n" + 
                                       "       InvDetailEO.Updated_date, \n" + 
                                       "       InvDetailEO.upload_count,\n" + 
                                       "(select distinct card_type_name from  inv_card_type_mst where category = InvDetailEO.Card_Type_code)cardTypeDesc,\n" + 
                                       "(select card_status_desc from  INV_Card_status_mst where card_status_id = InvDetailEO.Card_Status_ID)cardStatusDesc,\n" + 
                                       "(select loc_desc from gen_location_mst where location_id = InvDetailEO.location_id)LocationDesc\n" +
                                       "FROM  INV_INVENTORY_DETAIL InvDetailEO ";*/
                                   }
                            }
                            else
                            {
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("134", lngCode)));            
                                result = "fail";
                                break;    
                            }
                        }
                        else
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("135", lngCode)));            
                            result = "fail";
                            break;
                        }
                    }
                    if(i!=count-1)
                    {
                        if(queryTop==null)
                        {
                                queryUpdate = queryBase+cardCrit+" UNION ";   
                        }
                        else
                        {
                            queryUpdate = queryTop+cardCrit+" UNION ";       
                        }
                        
                    }
                    else
                    {
                        if(queryUpdate != null)
                        {
                            if(queryTop!=null){
                               queryUpdate = queryUpdate+queryTop+cardCrit;
                           }else{
                               queryUpdate = queryUpdate+queryBase+cardCrit;
                           }
                        }
                        else
                        {
                            if(queryTop==null)
                            {
                                queryUpdate = queryBase+cardCrit;
                            }
                            else
                            {
                                queryUpdate = queryTop+cardCrit;    
                            }
                           
                        }
                    }
              queryTop = null;
                }
                
                if (queryUpdate != null) {
                    invDetailVO.setQuery(queryUpdate + " ORDER BY CARD_NUM");
                } else {
                    invDetailVO.setQuery(queryUpdate);
                    invDetailVO.clearCache();
                    invDetailVO.cancelQuery();
                }
             //   invDetailVO.setOrderByClause("card_num");     
                
                if (invDetailVO.getWhereClause() == null) {
                    if (cardCriteriaNoWhere != null) {
                        if (NoWhereNumberOfCards != null) {
                            String NoWhereQueryTop = "SELECT TOP "+NoWhereNumberOfCards+" InvDetailEO.Inv_Detail_Seq,\n" + 
                            "   InvDetailEO.Card_num,\n" + 
                            "   InvDetailEO.LOcation_id, \n" + 
                            "   InvDetailEO.Despatch_date_CCO, \n" + 
                            "   InvDetailEO.Received_Date_CSC, \n" + 
                            "   InvDetailEO.Card_Denom_Amt, \n" + 
                            "   InvDetailEO.Sale_Date,\n" + 
                            "   InvDetailEO.Customer_ID,\n" + 
                            "    InvDetailEO.Org_Card_num, \n" + 
                            "   InvDetailEO.RC_Card_active_date,\n" + 
                            "   InvDetailEO.Expiry_Date,\n" + 
                            "   InvDetailEO.upload_count,\n" + 
                            "       InvDetailEO.Created_By, \n" + 
                            "       InvDetailEO.Created_Date,   \n" + 
                            "   InvDetailEO.Updated_by,\n" + 
                            "   InvDetailEO.Card_Status_ID,\n" + 
                            "   InvDetailEO.Updated_date, \n" + 
                            "   InvDetailEO.CSA_Assigned_Date, \n" + 
                            "   InvDetailEO.CSA_Assigned_To,\n" + 
                            "   InvDetailEO.Sale_hdr_seq,\n" + 
                            //     "       InvDetailEO.CVV_CODE,\n" +
                            "       InvDetailEO.Card_ctg_Code,\n" + 
                            "   InvDetailEO.Sale_Shift_ID,      \n" + 
                            "   InvDetailEO.Bulk_Sale_Flag,     \n" + 
                            "(select distinct card_type_name from  inv_card_type_mst where category = InvDetailEO.Card_ctg_Code)cardTypeDesc,\n" + 
                            "(select card_status_desc from  INV_Card_status_mst where card_status_id = InvDetailEO.Card_Status_ID)cardStatusDesc,\n" + 
                            "(select loc_desc from gen_location_mst where location_id = InvDetailEO.location_id)LocationDesc\n" +
                            "FROM  INV_INVENTORY_DETAIL InvDetailEO WHERE " + cardCriteriaNoWhere + " order by card_num"; 
                            
                            
                           /* String NoWhereQueryTop = "SELECT TOP "+NoWhereNumberOfCards+" InvDetailEO.CSA_Assigned_Date, \n" + 
                                           "       InvDetailEO.CSA_Assigned_To, \n" + 
                                           "       InvDetailEO.Card_Denom_Amt, \n" + 
                                           "       InvDetailEO.Card_Status_ID, \n" + 
                                           "       InvDetailEO.Card_Type_code, \n" + 
                                           "       InvDetailEO.Card_num, \n" + 
                                           "       InvDetailEO.Created_By, \n" + 
                                           "       InvDetailEO.Created_Date, \n" + 
                                           "       InvDetailEO.Customer_ID, \n" + 
                                           "       InvDetailEO.Despatch_date_CCO, \n" + 
                                           "       InvDetailEO.Expiry_Date, \n" + 
                                           "       InvDetailEO.Inv_Detail_Seq, \n" + 
                                           "       InvDetailEO.LOcation_id, \n" + 
                                           "       InvDetailEO.Org_Card_num, \n" + 
                                           "       InvDetailEO.RC_Card_active_date, \n" + 
                                           "       InvDetailEO.Received_Date_CSC, \n" + 
                                           "       InvDetailEO.Sale_Date, \n" + 
                                           "       InvDetailEO.Sale_hdr_seq, \n" + 
                                           "       InvDetailEO.Shift_ID, \n" + 
                                           "       InvDetailEO.Updated_by, \n" + 
                                           "       InvDetailEO.Updated_date, \n" + 
                                           "       InvDetailEO.upload_count,\n" + 
                                           "(select distinct card_type_name from  inv_card_type_mst where category = InvDetailEO.Card_Type_code)cardTypeDesc,\n" + 
                                           "(select card_status_desc from  INV_Card_status_mst where card_status_id = InvDetailEO.Card_Status_ID)cardStatusDesc,\n" + 
                                           "(select loc_desc from gen_location_mst where location_id = InvDetailEO.location_id)LocationDesc\n" +
                                           "FROM  INV_INVENTORY_DETAIL InvDetailEO WHERE " + cardCriteriaNoWhere + " order by card_num";  */  
                            invDetailVO.cancelQuery();
                            invDetailVO.setQuery(NoWhereQueryTop);
                            System.out.println("@@@@@@@@ before setting where clause query..." + invDetailVO.getQuery());
                        } else {
                            System.out.println("@@@@@@@@ before setting into query when WHERE and ORDER BY is null...." + cardCriteriaNoWhere);       
                            invDetailVO.setWhereClause(cardCriteriaNoWhere);
                            invDetailVO.setOrderByClause("card_num");
                        }
                    }
                }
                
//                if (invDetailVO.getQuery() != null) {
//                    int storeIndex = invDetailVO.getQuery().indexOf("order");
//                    System.out.println("@@@@@ index of order in final query..." + storeIndex);
//                    if (storeIndex == -1) {
//                        System.out.println("@@@@@@@@@@@ ORDER is not available in set query...concatinating the query for order by");
//                        invDetailVO.getQuery().concat(" order by card_num");
//                    }
//                }
                
//                if (invDetailVO.getOrderByClause() == null) {
//                    System.out.println("@@@@@@@@ before setting into query when ORDER clause is null....");                        
//                    invDetailVO.addOrderByClause("card_num");
//                }
                
                System.out.println("@@@@@@@@ Final Query : " + invDetailVO.getQuery());
                invDetailVO.executeQuery(); 
                System.out.println("Query results count...." + invDetailVO.getRowCount());
                invDetailVO.setQuery(queryBase);                
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("136", lngCode)));  
                result = "fail";
            }
        }
        displayResult(result);
        return null;
    }
    public void displayResult(String result)
    {       
        if(result.equalsIgnoreCase("pass"))
        {
            getInvDtlResult().setRendered(true);
            getSelectDeselect().setRendered(true);
            getTotalForm().setRendered(true);
            getSubmitBtn().setRendered(true);
            getRemoveUnselected().setRendered(true);  
            getResetBtn().setRendered(true);
        }
    }
    public String addSearch_action() {
        Integer locId = locDispatch();
        String dispatchDate = dispatchDate();
        getTransRefNumber().setValue(null);
        if(locId != null && dispatchDate != null)
        {            
            OperationBinding operationBinding = bindings.getOperationBinding("searchCritRow");
            operationBinding.execute();
            getInvSearchTbl().setRendered(true);
            getCheckAvlBTN().setRendered(true);  
            getRemoveCards().setRendered(true);
        }
        if (locId == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("138", lngCode)));           
        }
        if (dispatchDate == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("170", lngCode)));           
        }
        
        return null;
    }
    public Integer locDispatch()
    {
        DCIteratorBinding dcItterator =
            bindingsAM.findIteratorBinding("CardsInputFieldsVO1Iterator");
        Row row = dcItterator.getCurrentRow();
        Integer locId = null;
        if(row != null)
        {
            locId = (Integer)row.getAttribute("LocationId");
        }
        return locId;
    }
    
    public String dispatchDate()
    {
        DCIteratorBinding dcItterator =
            bindingsAM.findIteratorBinding("CardsInputFieldsVO1Iterator");
        Row row = dcItterator.getCurrentRow();
        String dispatchdate = null; 
        if(row != null)
        {
            if (row.getAttribute("dispatchDate") != null) {
                dispatchdate = row.getAttribute("dispatchDate").toString();
            }
        }
        return dispatchdate;
    }

    public void setTotal_num_cards(RichInputText total_num_cards) {
        this.total_num_cards = total_num_cards;
    }

    public RichInputText getTotal_num_cards() {
        return total_num_cards;
    }

    public void setInvDtlResult(RichTable invDtlResult) {
        this.invDtlResult = invDtlResult;
    }

    public RichTable getInvDtlResult() {
        return invDtlResult;
    }

    public String Submit_Action() {
       String result = (String)validateCardIssuance();
       if(result != null && result.equalsIgnoreCase("pass"))
       {
            BindingContainer bindings = getBindings();
            OperationBinding opBinding = bindings.getOperationBinding("commit");
            opBinding.execute();    
            OperationBinding setTransRef = bindings.getOperationBinding("displayTransRefNum");
           Object transRef = setTransRef.execute();
           if(transRef != null)
           {
                getTransRefNumber().setValue(transRef);
           }
            if (opBinding.getErrors().isEmpty() && setTransRef.getErrors().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("168", lngCode)));       
                getInvDtlResult().setRendered(false);
                getTotalForm().setRendered(false);
                getSelectDeselect().setRendered(false);
                getRemoveUnselected().setRendered(false);
                getSubmitBtn().setRendered(false);
                getResetBtn().setRendered(false);
                total_num_cards.setValue(0);
                total_amount.setValue(0);
            }
        }
        return null;
    }

    private String validateCardIssuance() {
        String result = "pass";
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
         int count = invDtlResult.getRowCount();
         if(count>0)
         {
             DCIteratorBinding dcItterator =
                              bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
                          ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();  
//                              if(result.equalsIgnoreCase("pass") )//&& selectionRow.length>0)
//                              {
                                  BindingContainer bindings = getBindings();
                                  OperationBinding opBinding = bindings.getOperationBinding("pushIssReturnHeader");
                                  opBinding.getParamsMap().put("toLoc",locDispatch());
                                  opBinding.getParamsMap().put("fromLoc",1001);
                                  opBinding.getParamsMap().put("tranType","I");
                                  opBinding.getParamsMap().put("dispatchDate", sqlDate);
                                 opBinding.getParamsMap().put("createdBy",httpSession.getAttribute("loggedinUserid").toString());
                                  opBinding.execute();
                                  OperationBinding opBind = bindings.getOperationBinding("pushIssReturnDetail");
                                 opBind.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
                                 opBind.getParamsMap().put("reasons",null);
                                 opBind.getParamsMap().put("fromPage","trns");
                                 opBind.execute();
                                   if(invDetailVO != null)
                                   {
                                       Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);  
                                       if(selectionRow.length>0)
                                       {
                                           for(int i = 0;i<selectionRow.length;i++)
                                           {
                                               Row invDetailRow = selectionRow[i];
                                               if(invDetailRow != null)
                                               {
                                                  invDetailRow.setAttribute("CardStatusID",4);
                                                  invDetailRow.setAttribute("LOcationid",locDispatch());    
                                                  invDetailRow.setAttribute("DespatchdateCCO", sqlDate);
                                                 invDetailRow.setAttribute("Updatedby",httpSession.getAttribute("loggedinUserid").toString());
                                                  invDetailRow.setAttribute("Updateddate", sqlDate);
                                               }
                                           }        
                                       }
                                       else
                                       {
                                           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("166", lngCode)));         
                                            result = "fail"; 
                                       }
                                   }
//                              } 
                         
                          
         }
         else
         {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("167", lngCode)));         
             result = "fail";
         } 
         return result;
    }

//    public BigDecimal selectDeselect_All() {
//        int count = invDtlResult.getRowCount();
//        if(count>0)
//        {
//            DCIteratorBinding dcItterator =
//                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
//            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();    
//            if(invDetailVO != null)
//            {
//                Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
//                Integer selectCount = selectionRow.length;
//                for(int i = 0;i<count;i++)
//                {
//                    InvDetailUVORowImpl invDetailRow = (InvDetailUVORowImpl)invDetailVO.getRowAtRangeIndex(i);    
//                    if(invDetailRow != null)
//                    {
//                        if(selectCount==count)
//                        {
//                            invDetailRow.setSelectFlag(false);            
//                        }
//                        else
//                        {
//                            invDetailRow.setSelectFlag(true);            
//                        }                        
//                    }
//                }
//                
//            }
//        }
//        else
//        {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "There are no cards to Select/Deselect"));                 
//        }
//        BigDecimal bD = totalCardsAmount_Action();
//        return bD;
//    }

    public BigDecimal selectDeselect_All() {
        int count = invDtlResult.getRowCount();
        if(count>0)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();    
            if(invDetailVO != null)
            {
                for(int i = 0;i<count;i++)
                {
                    InvDetailUVORowImpl invDetailRow = (InvDetailUVORowImpl)invDetailVO.getRowAtRangeIndex(i);    
                    if(invDetailRow != null)
                    {
                        if(invDetailRow.getSelectFlag()==null || !invDetailRow.getSelectFlag())
                        {
                            invDetailRow.setSelectFlag(true);               
                        }
                        else 
                        {
                            invDetailRow.setSelectFlag(false);   
                        }                        
                    }
                }
                Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",false);
                Integer selectCount = selectionRow.length;
                
                if (count!=selectCount) {
                    for(int j = 0;j<count;j++)
                    {
                        InvDetailUVORowImpl invDetailRow = (InvDetailUVORowImpl)invDetailVO.getRowAtRangeIndex(j);    
                        if(invDetailRow != null)
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
        BigDecimal bD = totalCardsAmount_Action();
        return bD;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }

    public void setInvSearchTbl(RichTable invSearchTbl) {
        this.invSearchTbl = invSearchTbl;
    }

    public RichTable getInvSearchTbl() {
        return invSearchTbl;
    }

    public void setCheckAvlBTN(RichToolbar checkAvlBTN) {
        this.checkAvlBTN = checkAvlBTN;
    }

    public RichToolbar getCheckAvlBTN() {
        return checkAvlBTN;
    }

    public void setSelectDeselect(RichCommandButton selectDeselect) {
        this.selectDeselect = selectDeselect;
    }

    public RichCommandButton getSelectDeselect() {
        return selectDeselect;
    }

    public void setTotalForm(RichPanelFormLayout totalForm) {
        this.totalForm = totalForm;
    }

    public RichPanelFormLayout getTotalForm() {
        return totalForm;
    }

    public void setSubmitBtn(RichCommandButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public RichCommandButton getSubmitBtn() {
        return submitBtn;
    }

    public String Reset_Action() {
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("CardIssueSrchCriVO1Iterator");
        ViewObject cardIssVO = dcItteratorBinding.getViewObject();   
        cardIssVO.clearCache();
        getInvDtlResult().setRendered(false);
        getSelectDeselect().setRendered(false);
        getTotalForm().setRendered(false);
        getSubmitBtn().setRendered(false);
        getRemoveUnselected().setRendered(false);
        getResetBtn().setRendered(false);
        return null;
    }

    public void setLocationId(RichSelectOneChoice locationId) {
        this.locationId = locationId;
    }

    public RichSelectOneChoice getLocationId() {
        return locationId;
    }

    public void setRemoveUnselected(RichCommandButton removeUnselected) {
        this.removeUnselected = removeUnselected;
    }

    public RichCommandButton getRemoveUnselected() {
        return removeUnselected;
    }

    public String removeUnselectedRows() {
            // Add event code here...
            int count = invDtlResult.getRowCount();
            System.out.println("count in removeUnselectedRow : "+count);
            if(count>0)
            {
                DCIteratorBinding dcItterator =
                    bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
                ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();    
                if(invDetailVO != null)
                {
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("164", lngCode)));                    
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
    public BigDecimal totalCardsAmount_Action() {
        // Add event code here...
        int count = invDtlResult.getRowCount();
        BigDecimal totalAmt = null;
        if(count>0)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();    
            if(invDetailVO != null)
            {
                Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
                Integer selectCount = selectionRow.length;
                if (selectCount > 0) {
                    for(int i = 0;i<selectCount;i++)
                    {
                        Row invDetailRow = selectionRow[i];
                        if(invDetailRow != null)
                        {
                            BigDecimal rowAmt = (BigDecimal)invDetailRow.getAttribute("CardDenomAmt");
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
                } else {
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Please select any cards to view summary"));      
                    total_num_cards.setValue("");
                    total_amount.setValue("");
                }
                
                total_num_cards.setValue(selectCount);
                total_amount.setValue(totalAmt);
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("169", lngCode)));      
        }
        return totalAmt;
    }

    public void setTotal_amount(RichInputText total_amount) {
        this.total_amount = total_amount;
    }

    public RichInputText getTotal_amount() {
        return total_amount;
    }

    public void setDispatchDate(RichInputDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public RichInputDate getDispatchDate() {
        return dispatchDate;
    }

    public void setEndNumDisplay(RichInputText endNumDisplay) {
        this.endNumDisplay = endNumDisplay;
    }

    public RichInputText getEndNumDisplay() {
        return endNumDisplay;
    }

    public String delSearch_action() {
        int count = invSearchTbl.getRowCount();
        System.out.println("count in delSearch_action : "+count);
        if(count>0)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("CardIssueSrchCriVO1Iterator");
            ViewObjectImpl VO = (ViewObjectImpl)dcItterator.getViewObject();    
            if(VO != null)
            {
                Row selectionRow[] = VO.getFilteredRows("RemoveFlag",true);
                Integer selectCount = selectionRow.length;
                if(selectCount > 0)
                {
                        removeResult(selectionRow,selectCount);
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("160", lngCode) ));      
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("161", lngCode)));                    
        }
        
        return null;
    }

    public void setResetBtn(RichCommandButton resetBtn) {
        this.resetBtn = resetBtn;
    }

    public RichCommandButton getResetBtn() {
        return resetBtn;
    }

    public void setRemoveCards(RichCommandButton removeCards) {
        this.removeCards = removeCards;
    }

    public RichCommandButton getRemoveCards() {
        return removeCards;
    }

    public void setTransRefNumber(RichInputText transRefNumber) {
        this.transRefNumber = transRefNumber;
    }

    public RichInputText getTransRefNumber() {
        return transRefNumber;
    }

    public BigDecimal populateAmoundCards(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //Getting CurrentChecbox value
        boolean selectedValue = (Boolean)valueChangeEvent.getNewValue(); 
        System.out.println("populateAmountRows bfr CheckAmount --value-selectedValue:"+selectedValue);
        //Getting Checked Row
        int index = invDtlResult.getRowIndex();
        System.out.println("populateAmountRows bfr CheckAmount --value-index:"+index);
        BigDecimal totalAmt = null;
        
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();  
        //Setting Current Checkbox value to current row
        InvDetailUVORowImpl rowImpl = (InvDetailUVORowImpl)invDetailVO.getRowAtRangeIndex(index);
        rowImpl.setSelectFlag(selectedValue);
            if(invDetailVO != null)
            {
                Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
                Integer selectCount = selectionRow.length;
                if (selectCount > 0) {
                    for(int i = 0;i<selectCount;i++)
                    {
                        Row invDetailRow = selectionRow[i];
                        if(invDetailRow != null)
                        {
                            BigDecimal rowAmt = (BigDecimal)invDetailRow.getAttribute("CardDenomAmt");
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
                    total_num_cards.setValue(selectCount);
                    total_amount.setValue(totalAmt);
                } else {
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Please select any cards to view summary"));      
                    total_num_cards.setValue("");
                    total_amount.setValue("");
                }
                
                
            }
       
        return totalAmt;
    }
}
