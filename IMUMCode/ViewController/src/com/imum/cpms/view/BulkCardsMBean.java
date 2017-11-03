package com.imum.cpms.view;

import com.imum.cpms.model.transactions.vo.BulkCardsInstVORowImpl;
import com.imum.cpms.model.transactions.vo.CardIssueSrchCriVORowImpl;


import com.imum.cpms.model.transactions.vo.CardsInputFieldsVORowImpl;
import com.imum.cpms.model.transactions.vo.InvDetailUVORowImpl;

import com.imum.cpms.model.transactions.vo.ParkingCardTypesUVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesHeaderUVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesSettlementUVORowImpl;

import com.imum.cpms.util.MessageUtil;
import com.imum.ws.BulkSale.RCSaleWS;
import com.imum.ws.BulkSale.RCSaleWS_Service;

import com.imum.ws.BulkSale.RechargeCardObj;
import com.imum.ws.BulkSale.SoldRechargeCard;

import com.imum.ws.BulkSale.SoldRechargeCardResponse;

import java.math.BigDecimal;

import java.sql.Date;

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
import oracle.adf.view.rich.component.rich.data.RichColumn;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BulkCardsMBean {
   
    DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    private RichCommandButton instPopupTable;
    private RichInputText institutionId;
    private RichInputText institutionName;
    private RichInputText primaryContact;
    private RichInputText customerType;
    private RichInputText customerId;
    private String CustRender;
    private String InstRender ;
    private RichSelectOneRadio customerTypeRadio;
    private RichInputDate saleDate;
    private RichSelectOneChoice locationId;
    private RichInputText location;
    private RichTable invDtlResult;
    private RichInputText totalCards;
    private RichInputText totalAmount;
    private RichInputText institutionIdentifier;
    private RichInputText institutionnameIdentifier;
    private RichInputText primarycontactidentifier;
    DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichColumn selectDeselect;
    private RichPanelFormLayout totalForm;
    private RichCommandButton submitBtn;
    private RichCommandButton removeUnselected;
    private RichCommandButton resetBtn;
    private RichTable invSearchTbl;
    private RichCommandButton removeCards;
    private String hide;
    private boolean disableCHQ = true;
    private boolean disableCCD = true;
    private RichSpacer makepaymentrender;
    private RichPanelGroupLayout paymentboxrender;
    private RichCommandButton paymentbtnpanel;
    private RichCommandButton selectdeselctnew;
    private RichPanelGroupLayout submitpanel;

    private boolean visible = true;

    private RichColumn chequeNumCol;
    private RichColumn chequeBnkCol;
    private RichColumn chequeDateCol;
    private RichColumn creditCardTypeCol;
    private RichColumn creditCardNumCol;
    private RichColumn authCodeCol;
    private RichPanelGroupLayout renderSrchTbl;
    private RichCommandButton checkAvlBTN;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private RichInputText saleRcptNum;
    private RichSelectBooleanCheckbox populateCheckAmount;
    private RichCommandButton addCardsButton;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private RichInputText chequenumber;
    private RichInputText chequebankname;
    private RichInputDate chequedate;
    private RichSelectOneChoice creditcardtype;
    private RichInputText creditcardnumber;
    private RichInputText creditcardauthcode;
    private RichCommandImageLink addPymtDetailsIcon;


    public BulkCardsMBean() {
      
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        }   
    }
   /* public void CustomerTypeChange(ValueChangeEvent valueChangeEvent) {
        String customerType = valueChangeEvent.getNewValue().toString();
        System.out.println("customer type"+customerType);
        if(customerType != null) 
        {
            if("INDI".equals(customerType)) 
            {
                getIndiPG().setRendered(true);
                getInstPG().setRendered(false);
//            setCustRender(Boolean.TRUE);
//               setInstRender(Boolean.FALSE);
              
            }
             else
            {
                getInstPG().setRendered(true);
                getIndiPG().setRendered(false);
//             setCustRender(Boolean.FALSE);
//                   setInstRender(Boolean.TRUE);
            }
        }
    }*/
   
    public void CustomerIdEntered(ValueChangeEvent valueChangeEvent) {
       // String customerType = valueChangeEvent.getNewValue().toString();
        BigDecimal CustomerId = (BigDecimal)getCustomerId().getValue();
        DCIteratorBinding BulkCardsCustVO =
        bindings.findIteratorBinding("BulkCardsCustomerVO1Iterator1");
        ViewObject CustomerVO = BulkCardsCustVO.getViewObject(); 
     
    
       /* if(customerType == null)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample Error message", " Please select Customer Type"));
        else 
        {*/
            if(CustomerId != null) 
            {
              
               
                ViewObject BulkCradsCustomerVO = BulkCardsCustVO.getViewObject(); 
              
                    BulkCradsCustomerVO.setWhereClause(null);
                BulkCradsCustomerVO.setWhereClause("Cust_ID = '"+CustomerId+"'");
                BulkCradsCustomerVO.executeQuery();
                    
            } 
        
    }
    
    public void InstitutionIdEntered(ValueChangeEvent valueChangeEvent) {
      //  String customerType = getCustomerTypeRadio().toString();
      DCIteratorBinding BulkCardsCustVO = bindings.findIteratorBinding("BulkCardsInstVO1Iterator");
      ViewObject BulkCardsInstitutionVO = BulkCardsCustVO.getViewObject(); 
//        BulkCardsInstVORowImpl cardsrow = (BulkCardsInstVORowImpl)BulkCardsInstitutionVO.getCurrentRow();
//     BigDecimal InstitutionId = (BigDecimal)cardsrow.getinstid();
       /*tring InstitutionIdstring = getInstitutionId().toString();
        Integer InstitutionId = null;
        if(InstitutionIdstring != null)
     InstitutionId = Integer.parseInt(InstitutionIdstring);
        System.out.println("InstitutionId"+InstitutionId);*/
       /* if(customerType == null)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample Error message", " Please select Customer Type"));
        else 
        {*/
      Object InstitutionId = getInstitutionId().getValue();
            if(InstitutionId != null) 
            {
                BulkCardsInstitutionVO.setWhereClause(null);
                BulkCardsInstitutionVO.setWhereClause("inst_id = '"+InstitutionId+"'");
                BulkCardsInstitutionVO.executeQuery();
                getInstitutionId().setValue(InstitutionId);
            } 
    }
    public String Checkavailability() {
        
        totalCards.setValue(null);
        totalAmount.setValue(null); 
        
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
                String queryBase = invDetailVO.getQuery();
                String queryUpdate = null;
                
                for(int i=0;i<count;i++)
                {
                    String queryTop = null;
                    CardIssueSrchCriVORowImpl cardIssRow   = (CardIssueSrchCriVORowImpl)cardIssVO.getRowAtRangeIndex(i);
                    if(cardIssRow != null)
                    {
                        String cardType = cardIssRow.getBulkSaleCardType();
                        if(cardType != null)
                        {
                             //cardCrit = " WHERE Card_Status_ID = 3 and Card_Type_code = '"+cardType+"'";
                             
//                            if (cardType.equals("2"))//recharge cards check for expiry date greater than currentdate 
//                            { 
//                                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime()); 
//                                cardCrit = " WHERE Card_Status_ID = 3 and Card_Type_code = '"+cardType+"' and Expiry_Date >= '"+sqlDate+"'";
//                                cardCriteriaNoWhere = " Card_Status_ID = 3 and Card_Type_code = '"+cardType+"' and Expiry_Date >= '"+sqlDate+"'";
//                            } else {
                                cardCrit = " WHERE Card_Status_ID = 3 and Card_ctg_Code = '"+cardType+"'";
                                cardCriteriaNoWhere = " Card_Status_ID = 3 and Card_ctg_Code = '"+cardType+"'";
//                            }
                            
                            Object denom = cardIssRow.getDenomination();
                            if(denom != null)
                            {
                               cardCrit= cardCrit+ " and Card_Denom_Amt = "+denom;
                                cardCriteriaNoWhere = cardCriteriaNoWhere + " and Card_Denom_Amt = "+denom;
                                Integer numOfCards = cardIssRow.getNoOfCards();
                                NoWhereNumberOfCards = cardIssRow.getNoOfCards();
                                
                               Object Startnum = cardIssRow.getStartNum();

                                   if(Startnum != null)
                                   {
//                                         cardCrit= cardCrit+ " and Card_num LIKE '"+Startnum+"%'"; 
//                                         cardCriteriaNoWhere= cardCriteriaNoWhere+ " and Card_num LIKE '"+Startnum+"%'";
                                       
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
                                       DCIteratorBinding dcItteratorChk = bindingsAM.findIteratorBinding("ParkingCardTypesUVO1Iterator");
                                       ViewObjectImpl invDetailVOChk = (ViewObjectImpl)dcItteratorChk.getViewObject();   
                                       invDetailVOChk.setWhereClause("Category = '"+cardType+"' and Card_Denom_Amt = "+denom);
                                       invDetailVOChk.executeQuery();
                                       System.out.println("Query of Bulk is : "+invDetailVOChk.getQuery());
                                       System.out.println("Row count of Bulk is : "+invDetailVOChk.getRowCount());
                                       ParkingCardTypesUVORowImpl row = (ParkingCardTypesUVORowImpl)invDetailVOChk.getRowAtRangeIndex(0);
                                       if(row != null)
                                       {
                                            int limitBulk = row.getBulkSaleLimit();
                                            if(numOfCards <= limitBulk)
                                            {
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
                                                "FROM  INV_INVENTORY_DETAIL InvDetailEO "; */
                                            }else{
                                                Integer a = i+1;
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("133", lngCode)));            
                                                result = "fail";
                                                break;    
                                            }  
                                        }                                      
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

                if (result.equalsIgnoreCase("pass"))
                {
                    if (queryUpdate != null) {
                        invDetailVO.setQuery(queryUpdate + " ORDER BY CARD_NUM");
                    } else {
                        invDetailVO.setQuery(queryUpdate);
                        invDetailVO.clearCache();
                        invDetailVO.cancelQuery();
                    }
            //        invDetailVO.setOrderByClause("card_num");

                    if (invDetailVO.getWhereClause() == null) {
                        if (cardCriteriaNoWhere != null) {
                            if (NoWhereNumberOfCards != null) {
                            String NoWhereQueryTop = "SELECT TOP "+NoWhereNumberOfCards+" InvDetailEO.Inv_Detail_Seq,\n" + 
                            "	InvDetailEO.Card_num,\n" + 
                            "	InvDetailEO.LOcation_id, \n" + 
                            "	InvDetailEO.Despatch_date_CCO, \n" + 
                            "	InvDetailEO.Received_Date_CSC, \n" + 
                            "	InvDetailEO.Card_Denom_Amt, \n" + 
                            "	InvDetailEO.Sale_Date,\n" + 
                            "	InvDetailEO.Customer_ID,\n" + 
                            "	 InvDetailEO.Org_Card_num, \n" + 
                            "	InvDetailEO.RC_Card_active_date,\n" + 
                            "	InvDetailEO.Expiry_Date,\n" + 
                            "	InvDetailEO.upload_count,\n" + 
                            "       InvDetailEO.Created_By, \n" + 
                            "       InvDetailEO.Created_Date, 	\n" + 
                            "	InvDetailEO.Updated_by,\n" + 
                            "	InvDetailEO.Card_Status_ID,\n" + 
                            "	InvDetailEO.Updated_date, \n" + 
                            "	InvDetailEO.CSA_Assigned_Date, \n" + 
                            "	InvDetailEO.CSA_Assigned_To,\n" + 
                            "	InvDetailEO.Sale_hdr_seq,\n" + 
                       //     "       InvDetailEO.CVV_CODE,\n" + 
                            "       InvDetailEO.Card_ctg_Code,\n" + 
                            "	InvDetailEO.Sale_Shift_ID,      \n" + 
                            "	InvDetailEO.Bulk_Sale_Flag,     \n" + 
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
                                "FROM  INV_INVENTORY_DETAIL InvDetailEO WHERE " + cardCriteriaNoWhere + " order by card_num";*/
                                invDetailVO.cancelQuery();
                                invDetailVO.setQuery(NoWhereQueryTop);
                                System.out.println("before setting where clause query..." + invDetailVO.getQuery());
                            } else {
                                System.out.println("before setting into query when WHERE clause is null...." + cardCriteriaNoWhere);                        
                                invDetailVO.setWhereClause(cardCriteriaNoWhere);    
                                invDetailVO.setOrderByClause("card_num");
                            }
                        }
                    }
                    
//                    if (invDetailVO.getOrderByClause() == null) {
//                        System.out.println("before setting into query when ORDER clause is null....");                        
//                        invDetailVO.setOrderByClause("card_num");
//                    }
                    
                    System.out.println("@@@@@@@@ Final Query : " + invDetailVO.getQuery());
                    invDetailVO.executeQuery(); 
                    System.out.println("Query results count...." + invDetailVO.getRowCount());
                    invDetailVO.setQuery(queryBase);                
                }
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("136", lngCode)));  
                result = "fail";
            }
        }
        if(result.equalsIgnoreCase("pass"))
        {
            paymentbtnpanel.setRendered(true);    
        }        
        displayResult(result);
        return null;
    }
    public void displayResult(String result)
    {       
        if(result.equalsIgnoreCase("pass"))
        {
            getInvDtlResult().setRendered(true);
            getSelectdeselctnew().setRendered(true);
            getTotalForm().setRendered(true);
            getSubmitBtn().setRendered(true);
            getRemoveUnselected().setRendered(true);  
            getResetBtn().setRendered(true);
            
        }
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
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("160", lngCode)));      
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("161", lngCode)));                    
        }
        
        return null;
    }

   
    public String addSearch_action() {
        saleRcptNum.setValue(null);
        
        DCIteratorBinding dcItterator =
            bindingsAM.findIteratorBinding("CardsInputFieldsVO1Iterator");
        Row row = dcItterator.getCurrentRow();
        Object saleDate = row.getAttribute("Saledate");
        Integer locId = 1001;
            
            //locDispatch();
//        BigDecimal InstitutionId = (BigDecimal)cardsrow.getinstid();
        
        Object InstitutionId = getInstitutionId().getValue();   
        if(locId != null && InstitutionId!= null && saleDate != null)
        {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("searchCritRow");
            operationBinding.execute();
       // getRenderSrchTbl().setRendered(true);
        getInvSearchTbl().setRendered(true);
            getCheckAvlBTN().setRendered(true);  
            getRemoveCards().setRendered(true);
        }
        if(saleDate == null)
        {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("137", lngCode)));   
        }
        if(locId == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("138", lngCode)));           
        }
        if(InstitutionId == null) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("139", lngCode)));   
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

    public BigDecimal CheckAmount() {
       
        int count = invDtlResult.getRowCount();
        BigDecimal totalAmt = null;
        if(count>0)
        {
           
            DCBindingContainer bindingsAM =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
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
                    totalCards.setValue(selectCount);
                    totalAmount.setValue(totalAmt);   
                    paymentbtnpanel.setRendered(true);
                }
                else
                {
                   // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Please select cards to view summary")); 
                    totalCards.setValue("");
                    totalAmount.setValue("");   
                }                
            }
        }
        else
        {
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("162", lngCode)));      
        }
        
        return totalAmt;
    }
 public String cb1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context,null,"success");
        return null;
    }
    public String createnewInstitution() {
        // Add event code here...
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context,null,"Institution");
        return null;
    }
    


    public String DeleteCurrentRow() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.CardIssueSrchCriVO1Iterator.currentRow}");

        if(selectedRow!=null)
        {
        selectedRow.remove();
        }
        return null;
    }
    
    @WebServiceRef
    private static RCSaleWS_Service rCSaleWS_Service;
    
    public String SubmitCards() {
           java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           String result = "pass";
           DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
           DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
           ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
           Row[] filteredRows = invDetailVO.getFilteredRows("SelectFlag",true);
           
           String userName = "anonymous";
           if (httpSession.getAttribute("loggedinUserid") != null) {
               userName = httpSession.getAttribute("loggedinUserid").toString();
           }
           
           if(filteredRows.length > 0) {
               DCIteratorBinding dcItteratorSale = bindingsAM.findIteratorBinding("SalesHeaderUVO1Iterator");
               ViewObjectImpl saleHdrVO = (ViewObjectImpl)dcItteratorSale.getViewObject(); 
               SalesHeaderUVORowImpl saleHdrRow = (SalesHeaderUVORowImpl)saleHdrVO.getCurrentRow();
               Object saleReceiptNum = saleHdrRow.getReceiptNum();
               Object saleHdrSeq = saleHdrRow.getSalehdrseq();
               System.out.println("Sale Hdr Seq in BulkCardMBean is : "+saleHdrSeq);
               DCIteratorBinding dcItteratorcards = bindingsAM.findIteratorBinding("CardsInputFieldsVO1Iterator");
               ViewObjectImpl cardfieldsvo = (ViewObjectImpl)dcItteratorcards.getViewObject(); 
               CardsInputFieldsVORowImpl cardfieldsrow = (CardsInputFieldsVORowImpl)cardfieldsvo.getCurrentRow();
               Date SaleDate = cardfieldsrow.getSaledate();
               String cardTypeDisp = null;
               System.out.println("Filtered Rows for inserting into ADF..." + filteredRows.length);
               for(int i = 0;i<filteredRows.length;i++)
               {
                   Row invDetailRow  = filteredRows[i];
                   Integer cardTypeInt = (Integer)invDetailRow.getAttribute("CardctgCode");
                   String cardTypeVal = cardTypeInt.toString();
                   if(cardTypeVal.equalsIgnoreCase("1"))
                   {
                       if(cardTypeDisp==null)
                       {
                           cardTypeDisp = "Prepaid";
                       }
                       else if(cardTypeDisp != null && cardTypeDisp.contains("Recharge"))
                       {
                           cardTypeDisp = cardTypeDisp + ", Prepaid";
                       }
                   }else if(cardTypeVal.equalsIgnoreCase("2"))
                   {
                       if(cardTypeDisp==null)
                       {
                           cardTypeDisp = "Recharge";
                       }
                       else if(cardTypeDisp != null && cardTypeDisp.contains("Prepaid"))
                       {
                           cardTypeDisp = cardTypeDisp + ", Recharge";
                       }
                   }
                   System.out.println("Filtered row card number in ADF..." + invDetailRow.getAttribute("Cardnum").toString());
                   invDetailRow.setAttribute("CardStatusID", 7);
                   invDetailRow.setAttribute("SaleDate", sqlDate);
                   invDetailRow.setAttribute("LOcationid", 1001);      
                   invDetailRow.setAttribute("Updatedby", userName);
                   invDetailRow.setAttribute("Updateddate", sqlDate);
                   invDetailRow.setAttribute("Salehdrseq", saleHdrSeq);
                   invDetailRow.setAttribute("BulkSaleFlag","Y");
                   if (pageflowScope.get("custId") != null) {
                       invDetailRow.setAttribute("CustomerID", pageflowScope.get("custId"));    
                   }
               }
               System.out.println("CardType Display value is : "+cardTypeDisp);
               pageflowScope.put("cardTypeDisplay",cardTypeDisp);
                pageflowScope.put("numOfCards",filteredRows.length);
               DCIteratorBinding Payment = bindingsAM.findIteratorBinding("SalesSettlementUVO1Iterator");
               ViewObjectImpl PaymentVO = (ViewObjectImpl)Payment.getViewObject();
               int paymentcount = PaymentVO.getRowCount();
               if(paymentcount > 0)
               {
                    for(int i = 0;i<paymentcount;i++)
                    {
                        SalesSettlementUVORowImpl paymentrow = (SalesSettlementUVORowImpl)PaymentVO.getRowAtRangeIndex(i);
                        if(paymentrow != null)
                        {
                            String PaymentType = paymentrow.getPYMTType();
                            BigDecimal paymentAmount = paymentrow.getPYMTAMT();
                            String chqBankName = paymentrow.getChqBankname();
                            Date chqDate = paymentrow.getChqDate();
                            String chqNum = paymentrow.getChqnum(); 
                            String ccdType = paymentrow.getCCDType();
                            String CreditCardNum = paymentrow.getCCDnum();
                            String AuthorizationCode = paymentrow.getAuthCode();
                            if(PaymentType != null)
                            {
                                if(paymentAmount != null)
                                {  
                                    if("CCD".equals(PaymentType) ) 
                                    {

                                        if(paymentAmount.equals(new BigDecimal(0)))
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Payment Details with Amount Zero not allowed","Payment Details with Amount Zero not allowed")); 
                                            result = "fail";
                                            break;     
                                        }
                                        if(chqBankName!=null || chqDate!=null || chqNum!=null)
                                        {
                                             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("140", lngCode))); 
                                             result = "fail";
                                             break;   
                                         }
                                        if(CreditCardNum == null || "".equals(CreditCardNum)) 
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("141", lngCode))); 
                                            result = "fail";
                                            break;
                                        }
                                        else if(AuthorizationCode == null || "".equals(AuthorizationCode)) 
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("142", lngCode))); 
                                            result = "fail";
                                            break; 
                                        } 
                                        else if(ccdType == null || "".equals(ccdType)) 
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("143", lngCode))); 
                                            result = "fail";
                                            break; 
                                        } 
                                    }
                                    if("CHQ".equals(PaymentType))
                                    {
                    
                                        if(paymentAmount.equals(new BigDecimal(0)))
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Payment Details with Amount Zero not allowed","Payment Details with Amount Zero not allowed")); 
                                            result = "fail";
                                            break;     
                                        }
                                         if(CreditCardNum!=null || AuthorizationCode!=null || ccdType!=null)
                                        {
                                             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("144", lngCode))); 
                                             result = "fail";
                                             break;   
                                         }
                                        if( chqBankName== null || "".equals(chqBankName))
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("145", lngCode))); 
                                            result = "fail";
                                            break;  
                                        }
                                        else if( chqDate == null || "".equals(chqDate))
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("146", lngCode))); 
                                            result = "fail";
                                            break;  
                                        }
                                        else if(chqNum == null || "".equals(chqNum))
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("147", lngCode))); 
                                            result = "fail";
                                            break;     
                                        }
                                    } 
                                    if("CSH".equals(PaymentType))
                                    {
                                        if(paymentAmount.equals(new BigDecimal(0)))
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Payment Details with Amount Zero not allowed","Payment Details with Amount Zero not allowed")); 
                                            result = "fail";
                                            break;     
                                        }
                                        if(CreditCardNum!=null || AuthorizationCode!=null || ccdType!=null)
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("148", lngCode))); 
                                            result = "fail";
                                            break;   
                                        }
                                        if(chqBankName!=null || chqDate!=null || chqNum!=null)
                                        {
                                             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("149", lngCode))); 
                                             result = "fail";
                                             break;   
                                         }
                                    }
                                    BigDecimal totalamountbig = (BigDecimal)CheckAmount();
                                    Integer totamount = Integer.valueOf(totalamountbig.intValue());
                                    System.out.println("totalamount"+totamount);
                                    BigDecimal totalAmountPaying = totalPaymentamountAction();
                                    Integer totamountpaying = Integer.valueOf(totalAmountPaying.intValue());
                                    System.out.println("totamountpaying..." + totamountpaying);
                                    if(!totamount.equals(totamountpaying))
                                    {
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("150", lngCode)));
                                    result = "fail";
                                        break;  
                                    }
                                }
                                else
                                {
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("151", lngCode)));
                                    result = "fail"; 
                                    break;  
                                }                     
                            }
                            else
                            {
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("152", lngCode))); 
                                result = "fail";    
                                break;  
                            }
                             
                        }
                        else
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Payment Details required. Click Add Payment Details to Enter Payement Details", "Payment Details required. Click Add Payment Details to Enter Payement Details")); 
                            result = "fail";   
                            addPymtDetailsIcon.setRendered(true);
                        }
                    }  
                }
               else
               {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Payment Details required. Click Add Payment Details to Enter Payement Details", "Payment Details required. Click Add Payment Details to Enter Payement Details")); 
                    result = "fail";   
                   addPymtDetailsIcon.setRendered(true);
                }
               if(result.equalsIgnoreCase("pass"))
               {
                   BindingContainer bindingsxec = getBindings(); 
                   OperationBinding operationBinding = bindingsxec.getOperationBinding("commit");
                   operationBinding.execute();
                   if (operationBinding.getErrors().isEmpty()) {            
                       saleRcptNum.setValue(saleReceiptNum);
                      // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Payment done successfully with Sale Reciept Number : "+saleReceiptNum));
                       addCardsButton.setDisabled(false);
                       removeCards.setDisabled(false);
                       checkAvlBTN.setDisabled(false);
                       selectdeselctnew.setDisabled(false);
                       removeUnselected.setDisabled(false); 
                       paymentbtnpanel.setDisabled(false);
                       refreshPage();
                       PrintReceipt(saleHdrSeq); 
                       FacesContext context = FacesContext.getCurrentInstance(); 
                       context.getApplication().getNavigationHandler().handleNavigation(context,null,"Success");
                       
                       // Calling Webservice to update SOLD status in Infocomm
                       
                       try {
                          SoldRechargeCard soldRechargeCard = new SoldRechargeCard();                        
                          SoldRechargeCardResponse soldRechargeCardResponse = new SoldRechargeCardResponse();
                          RechargeCardObj rechargeCardObj = new RechargeCardObj();
                               
                          rCSaleWS_Service = new RCSaleWS_Service();
                          RCSaleWS rCSaleWS = rCSaleWS_Service.getRCSaleWSPort();
                          System.out.println("Filtered Rows for inserting to call service..." + filteredRows.length);
                          for (int i = 0; i<filteredRows.length; i++) {
                              Row invDetailRow = filteredRows[i];
                              System.out.println("Calling webservice to update infocomm..." + i); 
                              Integer cardTypeInt = (Integer)invDetailRow.getAttribute("CardctgCode");
                              String cardType = cardTypeInt.toString();
                             // String cardType = (String)invDetailRow.getAttribute("CardctgCode");
                              if (cardType.equalsIgnoreCase("2")) {
                                  System.out.println("Before calling WS...");
                                  String CardNumber = null;
                                  if (invDetailRow.getAttribute("Cardnum") != null) {
                                      CardNumber = invDetailRow.getAttribute("Cardnum").toString();
                                  }
                                  System.out.println("Card Number to service..." + CardNumber);
                                  String ExpiryDate = null;
                                  String serviceExpiryDate = null;
                                  if (invDetailRow.getAttribute("ExpiryDate") != null) {
                                      ExpiryDate = invDetailRow.getAttribute("ExpiryDate").toString();
                                      Date monthDate = convertStringToDate(ExpiryDate);
                                      Calendar calendar = Calendar.getInstance();
                                      calendar.setTime(monthDate);
                                      System.out.println("Returned after conversion of date..." + monthDate);
                                      int serviceMonth = calendar.get(Calendar.MONTH) + 1;
                                      System.out.println("Month from date returned..." + serviceMonth);
                                      int serviceYear = calendar.get(Calendar.YEAR);
                                      System.out.println("Year from date returned..." + serviceYear);
                                      serviceExpiryDate = String.valueOf(serviceMonth) + "/" + String.valueOf(serviceYear).substring(2);                                      
                                  }
                                  System.out.println("Expiry date to service..." + serviceExpiryDate);
                                  String CVV = "000";
//                                  if (invDetailRow.getAttribute("CVVCODE") != null) {
//                                      CVV = invDetailRow.getAttribute("CVVCODE").toString();
//                                  }
//                                  System.out.println("CVC Number to service..." + CVV);
                                  
                          //        RechargeCardObj rechargeCardObject = rCSaleWS.soldRechargeCard(CardNumber, "ADF", "ADF", CVV, ExpiryDate);
                                  
                                    rCSaleWS.soldRechargeCard(CardNumber, "ADF", "ADF", CVV, null);

                           //       System.out.println("After calling WS Status Code..." + rechargeCardObject.getOperationStatusCode());
                          //        System.out.println("After calling WS Status Desc..." + rechargeCardObject.getOperationStatusDesc());
                          //        System.out.println("After calling WS Recharge card status..." + rechargeCardObject.getRechargeCardStatus() + "...for recharge card number..." + rechargeCardObject.getRechargeCardNo());

                                  System.out.println("End of calling WS...");
                              }
                          }
                       } catch (Exception wse) {
                          System.out.println("WS....Exception while calling webservice for updating status as sold in Infocomm..." + wse);
                       }
                       pageflowScope.put("custId", null);  
                   }    
               }
           }
           else
           {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("153", lngCode)));     
           }
       return null;
       }
    
       public Date convertStringToDate(String ExpiryDate) {
            try {
                System.out.println("String parsing to convert..." + ExpiryDate);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date utildate = dateFormat.parse(ExpiryDate);
                java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
                System.out.println("Returning sqldate after conversion..." + sqldate);
                return sqldate;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    
      public String PrintReceipt(Object saleHdrSeq) { 
            FacesContext context = FacesContext.getCurrentInstance(); 
            context.getApplication().getNavigationHandler().handleNavigation(context,null,"Success"); 
            setVisible(Boolean.FALSE); 
            DCBindingContainer bindings = 
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry(); 
            DCIteratorBinding dcItteratorBindings1 = 
                bindings.findIteratorBinding("PaymetReceiptVO1Iterator"); 
            ViewObjectImpl receptVO = (ViewObjectImpl)dcItteratorBindings1.getViewObject(); 
            String queryBase = receptVO.getQuery(); 
            String queryEx = queryBase+" where  SLT_Sales_Settlement.Sale_hdr_seq = "+saleHdrSeq; 
            receptVO.setQuery(queryEx); 
            receptVO.executeQuery(); 
            System.out.println("Receipt Query is : "+receptVO.getQuery()); 
            receptVO.setQuery(queryBase); 
            return "Success"; 
        }

    public BigDecimal totalPaymentamountAction() {
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding Payment =
            bindingsAM.findIteratorBinding("SalesSettlementUVO1Iterator");
        ViewObjectImpl PaymentVO = (ViewObjectImpl)Payment.getViewObject();
        int count = PaymentVO.getRowCount();
        BigDecimal totalAmt = null;
        if(count>0)
        {
                for(int i = 0;i<count;i++)
                {
                    Row PaymentRow  = PaymentVO.getRowAtRangeIndex(i);
                    if(PaymentRow != null)
                    {
                        BigDecimal rowAmt = (BigDecimal)PaymentRow.getAttribute("PYMTAMT");
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
        }
        System.out.println("totalAmt"+totalAmt);
    
      
        return totalAmt;
    }



    public void setInstitutionId(RichInputText institutionId) {
        this.institutionId = institutionId;
    }

    public RichInputText getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionName(RichInputText institutionName) {
        this.institutionName = institutionName;
    }

    public RichInputText getInstitutionName() {
        return institutionName;
    }

    public void setPrimaryContact(RichInputText primaryContact) {
        this.primaryContact = primaryContact;
    }

    public RichInputText getPrimaryContact() {
        return primaryContact;
    }

//    public String SearchInstitution() {
//        // Add event code here...
//        String instidrich = getInstitutionIdentifier().toString();
//        String InstId = null;
//        String Institutionname = null;
//        String primarycontact  = null;
//        Integer InstitutionId = null;
//        if(instidrich!= null)
//        {
//         InstId = getInstitutionIdentifier().getValue().toString();
//         System.out.println("InstId"+InstId);
//         if(InstId != null && !"".equals(InstId))
//            InstitutionId = Integer.parseInt(InstId);
//        }
//     
//       
//        System.out.println("InstitutionId"+InstitutionId);
//        String InstitutionnameRich = getInstitutionnameIdentifier().toString();
//        if( getInstitutionnameIdentifier().getValue() != null && !"".equals(getInstitutionnameIdentifier().getValue()))
//        Institutionname = getInstitutionnameIdentifier().getValue().toString();
//        String primarycontactRich = getPrimarycontactidentifier().toString();
//        if(getPrimarycontactidentifier().getValue() != null && !"".equals(getPrimarycontactidentifier().getValue()))
//         primarycontact = getPrimarycontactidentifier().getValue().toString();
//        
//        DCIteratorBinding BulkCardsCustVO =
//        bindings.findIteratorBinding("BulkCardsInstVO1Iterator");
//        ViewObjectImpl BulkCardsInstitutionVO =(ViewObjectImpl) BulkCardsCustVO.getViewObject();
//        
//        String queryBase = BulkCardsInstitutionVO.getQuery();
//        String query = null;
//            BulkCardsInstitutionVO.setWhereClause(null);
//            if(InstitutionId != null)
//            {
//              
//             query =   " WHERE inst_id LIKE '"+InstitutionId+"%'"; 
//            
//             if(Institutionname != null) {
//              
//                query =  query +" AND inst_name LIKE '"+Institutionname+"%' "; 
//            }
//             if(primarycontact != null) {
//              
//                query = query +" AND primary_contact LIKE '"+primarycontact+"%' ";
//            }
//            }
//             else if(Institutionname != null  ) 
//             {
//              
//                query =  " WHERE inst_name LIKE '"+Institutionname+"%' "; 
//                if(primarycontact != null) {
//                 
//                   query = query +" AND primary_contact LIKE '"+primarycontact+"%' ";
//                }
//                
//            }
//            else if(primarycontact != null) {
//                query =   " WHERE primary_contact LIKE '"+primarycontact+"%'"; 
//            }
//           String queryupdate =  queryBase+query;
//         BulkCardsInstitutionVO.setQuery(queryupdate);
//        System.out.println(query);
//        BulkCardsInstitutionVO.executeQuery();
//        Row currentRow = BulkCardsInstitutionVO.getCurrentRow();
//        if(currentRow != null)
//        {
//            Object instDsp = currentRow.getAttribute("instid");
//            getInstitutionId().setValue(instDsp);    
//        }
//        BulkCardsInstitutionVO.setQuery(queryBase);         
//      
//        
//        return null;
//    }
    
    public void SelectInstitution() {
        // Add event code here...
        BigDecimal a;
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        
        DCIteratorBinding dcItteratorBindings1 =
            bindings.findIteratorBinding("BulkCardsInstVO1Iterator");
        ViewObject bulkCardsvoTableData = dcItteratorBindings1.getViewObject();
        Row instrowSelected = dcItteratorBindings1.getCurrentRow();
        System.out.println("instid-SelectInstitution" +(BigDecimal) instrowSelected.getAttribute("instid"));
        System.out.println("instname-SelectInstitution" +(String) instrowSelected.getAttribute("instname"));
        System.out.println("primarycontact-SelectInstitution" +(String) instrowSelected.getAttribute("primarycontact"));
        System.out.println("landlinenum-SelectInstitution" +(String) instrowSelected.getAttribute("landlinenum"));
        getInstitutionIdentifier().setValue((BigDecimal) instrowSelected.getAttribute("instid"));
        Object instDsp = (BigDecimal) instrowSelected.getAttribute("instid");
        getInstitutionId().setValue(instDsp);     
    }
    
    public String SearchInstitution() {
        // Add event code here...
        String instidrich = getInstitutionIdentifier().toString();
        String InstId = null;
        String Institutionname = null;
        String primarycontact  = null;
        Integer InstitutionId = null;
        boolean searchFieldFlag = false;
        System.out.println("instidrich Value:"+instidrich);
        System.out.println("InstitutionIdentifier Value:"+getInstitutionIdentifier().getValue());
        if(instidrich!= null && getInstitutionIdentifier().getValue()!=null)
        {
         InstId = getInstitutionIdentifier().getValue().toString();
         System.out.println("InstId"+InstId);
         if(InstId != null && !"".equals(InstId)){
            InstitutionId = Integer.parseInt(InstId);
            searchFieldFlag = true;
         }
        }
     
       
        System.out.println("InstitutionId"+InstitutionId);
        String InstitutionnameRich = getInstitutionnameIdentifier().toString();
        if( getInstitutionnameIdentifier().getValue() != null && !"".equals(getInstitutionnameIdentifier().getValue())){
            searchFieldFlag = true;
            Institutionname = getInstitutionnameIdentifier().getValue().toString();
        }
        
        String primarycontactRich = getPrimarycontactidentifier().toString();
        if(getPrimarycontactidentifier().getValue() != null && !"".equals(getPrimarycontactidentifier().getValue())){
            searchFieldFlag = true;
            primarycontact = getPrimarycontactidentifier().getValue().toString();
        }
        
        
        if (!searchFieldFlag) {    
        System.out.println("searchFieldFlag in If"+searchFieldFlag);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("163", lngCode)));
        }else{
            System.out.println("Execute Query"+searchFieldFlag);
        DCIteratorBinding BulkCardsCustVO =
        bindings.findIteratorBinding("BulkCardsInstVO1Iterator");
        ViewObjectImpl BulkCardsInstitutionVO =(ViewObjectImpl) BulkCardsCustVO.getViewObject();
        
        String queryBase = BulkCardsInstitutionVO.getQuery();
        String query = null;
            BulkCardsInstitutionVO.setWhereClause(null);
            if(InstitutionId != null)
            {
              
             query =   " WHERE inst_id LIKE '"+InstitutionId+"%'"; 
            
             if(Institutionname != null) {
              
                query =  query +" AND inst_name LIKE '"+Institutionname+"%' "; 
            }
             if(primarycontact != null) {
              
                query = query +" AND primary_contact LIKE '"+primarycontact+"%' ";
            }
            }
             else if(Institutionname != null  ) 
             {
              
                query =  " WHERE inst_name LIKE '"+Institutionname+"%' "; 
                if(primarycontact != null) {
                 
                   query = query +" AND primary_contact LIKE '"+primarycontact+"%' ";
                }
                
            }
            else if(primarycontact != null) {
                query =   " WHERE primary_contact LIKE '"+primarycontact+"%'"; 
            }
           String queryupdate =  queryBase+query;
         BulkCardsInstitutionVO.setQuery(queryupdate);
        System.out.println(query);
        BulkCardsInstitutionVO.executeQuery();
        Row currentRow = BulkCardsInstitutionVO.getCurrentRow();
        if(currentRow != null)
        {
            Object instDsp = currentRow.getAttribute("instid");
            getInstitutionId().setValue(instDsp);    
        }
        BulkCardsInstitutionVO.setQuery(queryBase);         
      
        } 
        return null;
    }

    public void setCustomerType(RichInputText customerType) {
        this.customerType = customerType;
    }

    public RichInputText getCustomerType() {
        return customerType;
    }


    public void setCustomerId(RichInputText customerId) {
        this.customerId = customerId;
    }

    public RichInputText getCustomerId() {
        return customerId;
    }


  

    public void setCustomerTypeRadio(RichSelectOneRadio customerTypeRadio) {
        this.customerTypeRadio = customerTypeRadio;
    }

    public RichSelectOneRadio getCustomerTypeRadio() {
        return customerTypeRadio;
    }

  //  public void setIndiPG(RichPanelGroupLayout indiPG) {
//        this.indiPG = indiPG;
//    }
//
//    public RichPanelGroupLayout getIndiPG() {
//        return indiPG;
//    }
//
//    public void setInstPG(RichPanelGroupLayout instPG) {
//        this.instPG = instPG;
//    }
//
//    public RichPanelGroupLayout getInstPG() {
//        return instPG;
//    }


    public void setCustRender(String CustRender) {
        this.CustRender = CustRender;
    }

    public String getCustRender() {
        return CustRender = "false";
    }

    public void setInstRender(String InstRender) {
        this.InstRender = InstRender;
    }

    public String getInstRender() {
        return InstRender = "false";
    }

    public void setSaleDate(RichInputDate saleDate) {
        this.saleDate = saleDate;
    }

    public RichInputDate getSaleDate() {
        return saleDate;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
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
                
//                Integer orgCount = count - selectCount;
//                if(count!=orgCount)
//                {
//                    for(int j = 0;j<selectCount;j++)
//                    {
//                        InvDetailUVORowImpl invDetailRow = (InvDetailUVORowImpl)invDetailVO.getRowAtRangeIndex(j);    
//                        if(invDetailRow != null)
//                        {
//                            invDetailRow.setSelectFlag(true);   
//                        }
//                    }   
//                }                
                
            }        
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("154", lngCode)));                 
        }
        BigDecimal bD = CheckAmount();
        return bD;
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("165", lngCode)));                    
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
    public void refreshPage()
    {
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("CardIssueSrchCriVO1Iterator");
        ViewObject cardIssVO = dcItteratorBinding.getViewObject();   
        cardIssVO.clearCache();
        getInvDtlResult().setRendered(false);
        getSelectdeselctnew().setRendered(false);
        getTotalForm().setRendered(false);
        // getSubmitBtn().setRendered(false);
        getRemoveUnselected().setRendered(false);
        getResetBtn().setRendered(false);
        getCheckAvlBTN().setRendered(false);
        getInvSearchTbl().setRendered(false);
        getPaymentboxrender().setRendered(false);
        //        getPaymentbtnpanel().setRendered(false);
        getSubmitpanel().setRendered(false);
        totalCards.setValue(null);
        totalAmount.setValue(null);  
        paymentbtnpanel.setRendered(false);
        
        addCardsButton.setDisabled(false);
        removeCards.setDisabled(false);
        checkAvlBTN.setDisabled(false);
        selectdeselctnew.setDisabled(false);
        removeUnselected.setDisabled(false);
        paymentbtnpanel.setDisabled(false);    
    }
    public String Reset_Action() {
        refreshPage();
        getBindings().getOperationBinding("doRollback").execute();              
        getBindings().getOperationBinding("CreateInsert").execute();     
        getBindings().getOperationBinding("clearCacheAllRows").execute(); 
        institutionIdentifier.setValue(null);
        institutionnameIdentifier.setValue(null);
        return null;
    }

    public String Make_Payment() {

//        DCIteratorBinding paymentDB = bindingsAM.findIteratorBinding("SalesSettlementUVO1Iterator");
//        ViewObject paymentVO = paymentDB.getViewObject();   
//        paymentVO.clearCache();
        
        addCardsButton.setDisabled(true);
        removeCards.setDisabled(true);
        checkAvlBTN.setDisabled(true);
        
        
        
        DCIteratorBinding dcItterat = bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
        ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterat.getViewObject();
        Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
        Integer selectCount = selectionRow.length;
        if(selectCount > 0)
        {
            selectdeselctnew.setDisabled(true);
            removeUnselected.setDisabled(true);      
            paymentbtnpanel.setDisabled(true);
            DCIteratorBinding BulkCardsCustVO =
            bindings.findIteratorBinding("BulkCardsInstVO1Iterator");
            ViewObject BulkCardsInstitutionVO = BulkCardsCustVO.getViewObject(); 
              BulkCardsInstVORowImpl cardsrow = (BulkCardsInstVORowImpl)BulkCardsInstitutionVO.getCurrentRow();
            // BigDecimal CustomerId = (BigDecimal)getInstitutionId().getValue();
            BigDecimal CustomerId = (BigDecimal)cardsrow.getinstid();
            pageflowScope.put("custId",CustomerId);
            // BigDecimal CustomerId = (BigDecimal)getInstitutionId().getValue();
            DCBindingContainer bindingsAM =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("CardsInputFieldsVO1Iterator");
            ViewObjectImpl cardfieldsvo = (ViewObjectImpl)dcItterator.getViewObject(); 
            CardsInputFieldsVORowImpl cardfieldsrow = (CardsInputFieldsVORowImpl)cardfieldsvo.getCurrentRow();
            Date SaleDate = cardfieldsrow.getSaledate();
            Integer location =  1001;
                //(Integer)cardfieldsrow.getLocationId();
            String SaleReceiptNumber = cardfieldsrow.getSaleReceiptnumber();
            System.out.println("Testing sale receipt number...." + SaleReceiptNumber);
            BigDecimal Totalamount = (BigDecimal)CheckAmount();
            if(Totalamount == null)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("155", lngCode)));             
            }
            /* Date SaleDate = (Date)getSaleDate().getValue();
            String location = getLocationId().getValue().toString();
            String SaleReceiptNumber = getSaleReceiptnumber().getValue().toString();
            Integer saleNum = Integer.parseInt(SaleReceiptNumber);*/
            
            
            if(CustomerId == null || "".equals(CustomerId))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("156", lngCode))); 
            }
            else if(SaleDate == null || "".equals(SaleDate)) 
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("157", lngCode)));  
            }
            else if(location == null || "".equals(location)) 
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("158", lngCode)));  
            }      
            BindingContainer bindingsxec = getBindings();
            OperationBinding operationBinding = bindingsxec.getOperationBinding("doCreatePayment");
            operationBinding.getParamsMap().put("CustomerId", CustomerId); 
            operationBinding.getParamsMap().put("SaleDate", SaleDate); 
            operationBinding.getParamsMap().put("location", location); 
            operationBinding.getParamsMap().put("SaleReceiptNumber", SaleReceiptNumber); 
            operationBinding.getParamsMap().put("Totalamount", Totalamount); 
            operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
            Object result = operationBinding.execute();
            
            if (operationBinding.getErrors().isEmpty()) {
                paymentboxrender.setRendered(true);
                submitpanel.setRendered(true);          
            }
        }
        else
        {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("165", lngCode)));  
            }
       
       
        
        return null;
        
    }

    public void setLocationId(RichSelectOneChoice locationId) {
        this.locationId = locationId;
    }

    public RichSelectOneChoice getLocationId() {
        return locationId;
    }

//    public void setSaleReceiptNumber(RichInputText saleReceiptNumber) {
//        this.saleReceiptNumber = saleReceiptNumber;
//    }
//
//    public RichInputText getSaleReceiptNumber() {
//        return saleReceiptNumber;
//    }

    public void setLocation(RichInputText location) {
        this.location = location;
    }

    public RichInputText getLocation() {
        return location;
    }

//    public void setSaleReceiptnumber(RichInputText saleReceiptnumber) {
//        this.saleReceiptnumber = saleReceiptnumber;
//    }
//
//    public RichInputText getSaleReceiptnumber() {
//        return saleReceiptnumber;
//    }


    public void setInvDtlResult(RichTable invDtlResult) {
        this.invDtlResult = invDtlResult;
    }

    public RichTable getInvDtlResult() {
        return invDtlResult;
    }

    public void setTotalCards(RichInputText totalCards) {
        this.totalCards = totalCards;
    }

    public RichInputText getTotalCards() {
        return totalCards;
    }

    public void setTotalAmount(RichInputText totalAmount) {
        this.totalAmount = totalAmount;
    }

    public RichInputText getTotalAmount() {
        return totalAmount;
    }


    public void setInstitutionIdentifier(RichInputText institutionIdentifier) {
        this.institutionIdentifier = institutionIdentifier;
    }

    public RichInputText getInstitutionIdentifier() {
        return institutionIdentifier;
    }

    public void setInstitutionnameIdentifier(RichInputText institutionnameIdentifier) {
        this.institutionnameIdentifier = institutionnameIdentifier;
    }

    public RichInputText getInstitutionnameIdentifier() {
        return institutionnameIdentifier;
    }

    public void setPrimarycontactidentifier(RichInputText primarycontactidentifier) {
        this.primarycontactidentifier = primarycontactidentifier;
    }

    public RichInputText getPrimarycontactidentifier() {
        return primarycontactidentifier;
    }

    public void setSelectDeselect(RichColumn selectDeselect) {
        this.selectDeselect = selectDeselect;
    }

    public RichColumn getSelectDeselect() {
        return selectDeselect;
    }

//    public void setTotalForm(RichPanelGroupLayout totalForm) {
//        this.totalForm = totalForm;
//    }
//
//    public RichPanelGroupLayout getTotalForm() {
//        return totalForm;
//    }

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

    public void setResetBtn(RichCommandButton resetBtn) {
        this.resetBtn = resetBtn;
    }

    public RichCommandButton getResetBtn() {
        return resetBtn;
    }

    public void setInvSearchTbl(RichTable invSearchTbl) {
        this.invSearchTbl = invSearchTbl;
    }

    public RichTable getInvSearchTbl() {
        return invSearchTbl;
    }

    public void setRemoveCards(RichCommandButton removeCards) {
        this.removeCards = removeCards;
    }

    public RichCommandButton getRemoveCards() {
        return removeCards;
    }


    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }

    public void setMakepaymentrender(RichSpacer makepaymentrender) {
        this.makepaymentrender = makepaymentrender;
    }

    public RichSpacer getMakepaymentrender() {
        return makepaymentrender;
    }

    public void setPaymentboxrender(RichPanelGroupLayout paymentboxrender) {
        this.paymentboxrender = paymentboxrender;
    }

    public RichPanelGroupLayout getPaymentboxrender() {
        return paymentboxrender;
    }

    public void setPaymentbtnpanel(RichCommandButton paymentbtnpanel) {
        this.paymentbtnpanel = paymentbtnpanel;
    }

    public RichCommandButton getPaymentbtnpanel() {
        return paymentbtnpanel;
    }

//    public void setPaymenttable(RichTable paymenttable) {
//        this.paymenttable = paymenttable;
//    }
//
//    public RichTable getPaymenttable() {
//        return paymenttable;
//    }

    public void setSelectdeselctnew(RichCommandButton selectdeselctnew) {
        this.selectdeselctnew = selectdeselctnew;
    }

    public RichCommandButton getSelectdeselctnew() {
        return selectdeselctnew;
    }

    public void setSubmitpanel(RichPanelGroupLayout submitpanel) {
        this.submitpanel = submitpanel;
    }

    public RichPanelGroupLayout getSubmitpanel() {
        return submitpanel;
    }


    public String getHide1() {
        return hide;
    }


    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setChequeNumCol(RichColumn chequeNumCol) {
        this.chequeNumCol = chequeNumCol;
    }

    public RichColumn getChequeNumCol() {
        return chequeNumCol;
    }

    public void setChequeBnkCol(RichColumn chequeBnkCol) {
        this.chequeBnkCol = chequeBnkCol;
    }

    public RichColumn getChequeBnkCol() {
        return chequeBnkCol;
    }

    public void setChequeDateCol(RichColumn chequeDateCol) {
        this.chequeDateCol = chequeDateCol;
    }

    public RichColumn getChequeDateCol() {
        return chequeDateCol;
    }

    public void setCreditCardTypeCol(RichColumn creditCardTypeCol) {
        this.creditCardTypeCol = creditCardTypeCol;
    }

    public RichColumn getCreditCardTypeCol() {
        return creditCardTypeCol;
    }

    public void setCreditCardNumCol(RichColumn creditCardNumCol) {
        this.creditCardNumCol = creditCardNumCol;
    }

    public RichColumn getCreditCardNumCol() {
        return creditCardNumCol;
    }

    public void setAuthCodeCol(RichColumn authCodeCol) {
        this.authCodeCol = authCodeCol;
    }

    public RichColumn getAuthCodeCol() {
        return authCodeCol;
    }
    public void pymtType(ValueChangeEvent valueChangeEvent) {
        Object pymType = valueChangeEvent.getNewValue();
        System.out.println("Payment type selected..." + pymType);
        if(pymType != null)
        {
            if(pymType.equals(0))//CreditCard
            {
                System.out.println("Cash selected +++++++");
                chequenumber.setValue(null);
                chequebankname.setValue(null);
                chequedate.setValue(null);
                creditcardnumber.setValue(null);
                creditcardtype.setValue(null);
                creditcardauthcode.setValue(null);
            }
            else if(pymType.equals(1))//CreditCard
            {
                System.out.println("Credit Card selected +++++++");
                chequenumber.setValue(null);
                chequebankname.setValue(null);
                chequedate.setValue(null);
            }
            else if(pymType.equals(2))//Cheque
            {
                System.out.println("Cheque selected +++++++");
                creditcardnumber.setValue(null);
                creditcardtype.setValue(null);
                creditcardauthcode.setValue(null);
            }    
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("159", lngCode)));             
        }
        
    }

    public void setDisableCHQ(boolean disableCHQ) {
        this.disableCHQ = disableCHQ;
    }

    public boolean isDisableCHQ() {
        return disableCHQ;
    }

    public void setDisableCCD(boolean disableCCD) {
        this.disableCCD = disableCCD;
    }

    public boolean isDisableCCD() {
        return disableCCD;
    }

    public void instSearch_selectListener(SelectionEvent selectionEvent) {
        System.out.println(selectionEvent.toString());
        
    }

    public void setTotalForm(RichPanelFormLayout totalForm) {
        this.totalForm = totalForm;
    }

    public RichPanelFormLayout getTotalForm() {
        return totalForm;
    }

    public void setRenderSrchTbl(RichPanelGroupLayout renderSrchTbl) {
        this.renderSrchTbl = renderSrchTbl;
    }

    public RichPanelGroupLayout getRenderSrchTbl() {
        return renderSrchTbl;
    }

    public void setCheckAvlBTN(RichCommandButton checkAvlBTN) {
        this.checkAvlBTN = checkAvlBTN;
    }

    public RichCommandButton getCheckAvlBTN() {
        return checkAvlBTN;
    }
    public String addPayment() {
        addPymtDetailsIcon.setRendered(false);
        BindingContainer bindingsxec = getBindings();
        OperationBinding operationBinding = bindingsxec.getOperationBinding("addPaymentRow"); 
        operationBinding.getParamsMap().put("encoder",httpSession.getAttribute("loggedinUserid").toString());
        operationBinding.execute();
        return null;
    }

    public void setSaleRcptNum(RichInputText saleRcptNum) {
        this.saleRcptNum = saleRcptNum;
    }

    public RichInputText getSaleRcptNum() {
        return saleRcptNum;
    }
    
    public void setInstPopupTable(RichCommandButton instPopupTable) {
        this.instPopupTable = instPopupTable;
    }

    public RichCommandButton getInstPopupTable() {
        return instPopupTable;
    }

    public BigDecimal populateAmountRows(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //Getting CurrentChecbox value
        boolean selectedValue = (Boolean)valueChangeEvent.getNewValue(); 
        System.out.println("populateAmountRows bfr CheckAmount --value-selectedValue:"+selectedValue);
       //Getting Checked Row
        int index = invDtlResult.getRowIndex();
        System.out.println("populateAmountRows bfr CheckAmount --value-index:"+index);
        
        BigDecimal totalAmt = null;
                 
            DCBindingContainer bindingsAM =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
            
            //Setting Current Checkbox value to current row
            InvDetailUVORowImpl rowImpl = (InvDetailUVORowImpl)invDetailVO.getRowAtRangeIndex(index);
            rowImpl.setSelectFlag(selectedValue);
            
            if(invDetailVO != null)
            {
                paymentbtnpanel.setRendered(true);
                Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
                Integer selectCount = selectionRow.length;
                if(selectCount > 0)
                {
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
                    totalCards.setValue(selectCount);
                    totalAmount.setValue(totalAmt);   
                   
                }
                else
                {
                    totalCards.setValue(null);
                    totalAmount.setValue(null);  
                }                
            }

        return totalAmt;
    }


//    public void clearCacheInst() {
//        // Add event code here...
//        institutionId.setValue(null);
//    }

    public void setAddCardsButton(RichCommandButton addCardsButton) {
        this.addCardsButton = addCardsButton;
    }

    public RichCommandButton getAddCardsButton() {
        return addCardsButton;
    }

    public String clearCacheSearchInstitution() {
        // Add event code here...
        DCIteratorBinding BulkCardsCustVO =
        bindings.findIteratorBinding("BulkCardsInstVO1Iterator");
        ViewObject BulkCardsInstitutionVO = BulkCardsCustVO.getViewObject();
        BulkCardsInstitutionVO.executeQuery();
        return null;
    }

    public String backBtnRcpt_action() {
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.getApplication().getNavigationHandler().handleNavigation(context,null,"backNav"); 
        return null;
    }

    public void setChequenumber(RichInputText chequenumber) {
        this.chequenumber = chequenumber;
    }

    public RichInputText getChequenumber() {
        return chequenumber;
    }

    public void setChequebankname(RichInputText chequebankname) {
        this.chequebankname = chequebankname;
    }

    public RichInputText getChequebankname() {
        return chequebankname;
    }

    public void setChequedate(RichInputDate chequedate) {
        this.chequedate = chequedate;
    }

    public RichInputDate getChequedate() {
        return chequedate;
    }

    public void setCreditcardtype(RichSelectOneChoice creditcardtype) {
        this.creditcardtype = creditcardtype;
    }

    public RichSelectOneChoice getCreditcardtype() {
        return creditcardtype;
    }

    public void setCreditcardnumber(RichInputText creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public RichInputText getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardauthcode(RichInputText creditcardauthcode) {
        this.creditcardauthcode = creditcardauthcode;
    }

    public RichInputText getCreditcardauthcode() {
        return creditcardauthcode;
    }

    public void setAddPymtDetailsIcon(RichCommandImageLink addPymtDetailsIcon) {
        this.addPymtDetailsIcon = addPymtDetailsIcon;
    }

    public RichCommandImageLink getAddPymtDetailsIcon() {
        return addPymtDetailsIcon;
    }
}
