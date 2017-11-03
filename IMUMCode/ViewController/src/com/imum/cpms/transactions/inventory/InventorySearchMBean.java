package com.imum.cpms.transactions.inventory;

import com.imum.cpms.model.transactions.vo.InventorySearchCriteriaVORowImpl;

import com.imum.cpms.transactions.pvt.PVTDiscountMBean;
import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class InventorySearchMBean {
    private RichPanelGroupLayout inventoryEventDetailsPanel;
    private RichPanelGroupLayout inventorySaleDetailsPanel;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
    MessageUtil genMsg = new MessageUtil();
    
    private RichPanelTabbed inventoryDetails;
    private RichPanelGroupLayout inventoryAccountDetailsPanel;

    public InventorySearchMBean() {
        if (lngCode == null || lngCode.equals("")) {
            lngCode = "EN";
        }
    }
    
    private String hide;
    private RichPanelGroupLayout inventorySearchResultsPanel;
    DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    
    public String validateDataOnSearchAction() {
        String result = "pass";
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("InventorySearchCriteriaVO1Iterator");
        ViewObject inventorySearchVO = dcIteratorBinding.getViewObject();
        InventorySearchCriteriaVORowImpl inventorySearchCriteriaRow = (InventorySearchCriteriaVORowImpl)inventorySearchVO.getCurrentRow();
        if (inventorySearchCriteriaRow != null) {
            Object CardType = inventorySearchCriteriaRow.getCardType();
            Object Denomination = inventorySearchCriteriaRow.getDenomination();
            Object CardStatus = inventorySearchCriteriaRow.getCardStatus();
            Object FromCard = inventorySearchCriteriaRow.getFromCard();
            Object ToCard = inventorySearchCriteriaRow.getToCard();
            
            if (CardType==null && Denomination==null && CardStatus==null && FromCard==null && ToCard==null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select any one criteria to search inventory", genMsg.getMessage("300",lngCode)));
                result = "fail"; 
            }
        }
        return result;
    }
    
    public String InventorySearch() {
        String result = validateDataOnSearchAction();
        
        if (result.equals("pass")) {
            DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("InventorySearchCriteriaVO1Iterator");
            ViewObject inventorySearchVO = dcItteratorBinding.getViewObject();     
            if (inventorySearchVO != null) {
                InventorySearchCriteriaVORowImpl inventorySearchCriteriaRow = (InventorySearchCriteriaVORowImpl)inventorySearchVO.getCurrentRow();
                
                String cardType = null;
                int denomination = 0;
                int CardStatus = 0;
                String FromCard = null;
                String ToCard = null;
                String inventorySearchWhereClause = null;
                
                if (inventorySearchCriteriaRow != null) {
                    if (inventorySearchCriteriaRow.getCardType() != null) {
                        cardType = inventorySearchCriteriaRow.getCardType().toString();
                       // System.out.println("Card Type selected..." + cardType);
                        if (inventorySearchWhereClause != null) {
                            inventorySearchWhereClause = inventorySearchWhereClause + " AND Card_ctg_Code = " + cardType;
                        } else {
                            inventorySearchWhereClause = "Card_ctg_Code = " + cardType;
                        }
                    }
                    if (inventorySearchCriteriaRow.getDenomination() != null) {
                        denomination = inventorySearchCriteriaRow.getDenomination();
                    //    System.out.println("Denomination selected..." + denomination);
                        if (inventorySearchWhereClause != null) {
                            inventorySearchWhereClause = inventorySearchWhereClause + " AND Card_Denom_Amt = " + denomination;
                        } else {
                            inventorySearchWhereClause = "Card_Denom_Amt = " + denomination;
                        }
                    }
                    if (inventorySearchCriteriaRow.getCardStatus() != null) {
                        CardStatus = inventorySearchCriteriaRow.getCardStatus();
                     //   System.out.println("Card Status selected..." + CardStatus);
                         if (inventorySearchWhereClause != null) {
                             inventorySearchWhereClause = inventorySearchWhereClause + " AND Card_Status_ID = " + CardStatus;
                         } else {
                             inventorySearchWhereClause = "Card_Status_ID = " + CardStatus;
                         }                    
                    }
                    if (inventorySearchCriteriaRow.getFromCard() != null && inventorySearchCriteriaRow.getToCard() == null) {
                        FromCard = inventorySearchCriteriaRow.getFromCard().toString();
                     //   System.out.println("From Card entered..." + FromCard);
                         if (inventorySearchWhereClause != null) {
                             inventorySearchWhereClause = inventorySearchWhereClause + " AND card_num like '" + FromCard + "'";
                         } else {
                             inventorySearchWhereClause = "card_num = '" + FromCard + "'";
                         }
                    }
                    if (inventorySearchCriteriaRow.getFromCard() != null && inventorySearchCriteriaRow.getToCard() != null) {
                        FromCard = inventorySearchCriteriaRow.getFromCard().toString();
                        ToCard = inventorySearchCriteriaRow.getToCard().toString();
                    //    System.out.println("From Card entered..." + FromCard + "...and To Card entered..." + ToCard);
                        if (inventorySearchWhereClause != null) {
                            inventorySearchWhereClause = inventorySearchWhereClause + " AND card_num between '" + FromCard + "' and '" + ToCard + "'";
                        } else {
                            inventorySearchWhereClause = "card_num between '" + FromCard + "' and '" + ToCard + "'";
                        }
                    }
                    if (inventorySearchCriteriaRow.getFromCard() == null && inventorySearchCriteriaRow.getToCard() != null) {
                        ToCard = inventorySearchCriteriaRow.getToCard().toString();
                     //   System.out.println("To Card entered..." + ToCard);
                         if (inventorySearchWhereClause != null) {
                             inventorySearchWhereClause = inventorySearchWhereClause + " AND card_num like '" + ToCard + "'";
                         } else {
                             inventorySearchWhereClause = "card_num = '" + ToCard + "'";
                         }
                    }
                    
                    DCIteratorBinding invSearchResultsIterator = bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
                    ViewObjectImpl inventorySearchResultsVO = (ViewObjectImpl)invSearchResultsIterator.getViewObject();  
                    inventorySearchResultsVO.refreshWhereClauseParams();
                    inventorySearchResultsVO.setWhereClause(inventorySearchWhereClause);
                    System.out.println("Search query in inventory..." + inventorySearchResultsVO.getQuery());
                    inventorySearchResultsVO.executeQuery();
                    System.out.println("Count of inventory search results..." + inventorySearchResultsVO.getRowCount());
                    inventorySearchResultsVO.setWhereClause(null);
                    
                    ADFContext.getCurrent().getPageFlowScope().put("TotalCardsInInventory", inventorySearchResultsVO.getRowCount());
                                   
                    if (inventorySearchResultsVO.getRowCount() != 0) {
                        getInventorySearchResultsPanel().setRendered(true);                        
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No cards available in inventory for the search criteria", genMsg.getMessage("301",lngCode)));
                        getInventorySearchResultsPanel().setRendered(false);
                    }
                    getInventoryDetails().setRendered(false);
                    //getInventoryEventDetailsPanel().setRendered(false);
                   // getInventorySaleDetailsPanel().setRendered(false);
                }
            }
        }
        return null;
    }
    
    public String InventorySearchReset() {
        DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("InventorySearchCriteriaVO1Iterator");
        ViewObject inventorySearchVO = dcItteratorBinding.getViewObject();     
        inventorySearchVO.clearCache();
        InventorySearchCriteriaVORowImpl inventorySearchVORow = (InventorySearchCriteriaVORowImpl)inventorySearchVO.getCurrentRow();
        if (inventorySearchVORow != null) {
            inventorySearchVO.remove();
        }
        Row createRow = inventorySearchVO.createRow();
        inventorySearchVO.insertRow(createRow);
        getInventorySearchResultsPanel().setRendered(false);
        getInventoryDetails().setRendered(false);
//        getInventoryEventDetailsPanel().setRendered(false);
//        getInventorySaleDetailsPanel().setRendered(false);
        return null;
    }
    
    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }


    public void setInventorySearchResultsPanel(RichPanelGroupLayout inventorySearchResultsPanel) {
        this.inventorySearchResultsPanel = inventorySearchResultsPanel;
    }

    public RichPanelGroupLayout getInventorySearchResultsPanel() {
        return inventorySearchResultsPanel;
    }

    public String SelectedInventoryDetails() {
        String SelectedCardNumber = null;
        String SelectedCardStatus = null;
        String SelectedSaleHrdSeq = null;
        System.out.println("Page flow scope selected card number..." + ADFContext.getCurrent().getPageFlowScope().get("SelectedCardNumber"));
        if (ADFContext.getCurrent().getPageFlowScope().get("SelectedCardNumber") != null) {
            SelectedCardNumber = ADFContext.getCurrent().getPageFlowScope().get("SelectedCardNumber").toString();
        }
        System.out.println("Page flow scope selected card status..." + ADFContext.getCurrent().getPageFlowScope().get("SelectedCardStatus"));
        if (ADFContext.getCurrent().getPageFlowScope().get("SelectedCardStatus") != null) {
            SelectedCardStatus = ADFContext.getCurrent().getPageFlowScope().get("SelectedCardStatus").toString();
        }
        System.out.println("Page flow scope selected sale header sequence..." + ADFContext.getCurrent().getPageFlowScope().get("SelectedSaleHrdSeq"));
        if (ADFContext.getCurrent().getPageFlowScope().get("SelectedSaleHrdSeq") != null) {
            SelectedSaleHrdSeq = ADFContext.getCurrent().getPageFlowScope().get("SelectedSaleHrdSeq").toString();
        }
        
        /*start of getting inv_detail_seq*/
        DCIteratorBinding InvDetailUVOIterator = bindingsAM.findIteratorBinding("InvDetailUVO1Iterator");
        ViewObjectImpl InvDetailUVO = (ViewObjectImpl)InvDetailUVOIterator.getViewObject();
        BigDecimal InvDetailSeq =  new BigDecimal(InvDetailUVO.first().getAttribute("InvDetailSeq").toString());


        /*end of getting inv_detail_seq*/
        
        String inventoryEDWhereClause = "inv_detail_seq = '"+InvDetailSeq+"'";
        DCIteratorBinding inventoryEDIterator = bindingsAM.findIteratorBinding("InventoryEventDetailsVO1Iterator");
        ViewObjectImpl inventoryEDVO = (ViewObjectImpl)inventoryEDIterator.getViewObject();  
        inventoryEDVO.refreshWhereClauseParams();
        inventoryEDVO.setWhereClause(inventoryEDWhereClause);
        System.out.println("Search query in inventory for event details..." + inventoryEDVO.getQuery());
        inventoryEDVO.executeQuery();
        System.out.println("Event details count..." + inventoryEDVO.getRowCount());
        inventoryEDVO.setWhereClause(null);
        
        if (inventoryEDVO.getRowCount() != 0) {
            getInventoryDetails().setRendered(true);
            
            if (SelectedCardStatus.equalsIgnoreCase("sold")) {
                
                String inventorySDWhereClause = "sale_hdr_seq = "+SelectedSaleHrdSeq;
                DCIteratorBinding inventorySDIterator = bindingsAM.findIteratorBinding("InventorySaleDetailsVO1Iterator");
                ViewObjectImpl inventorySDVO = (ViewObjectImpl)inventorySDIterator.getViewObject();  
                inventorySDVO.refreshWhereClauseParams();
                inventorySDVO.setWhereClause(inventorySDWhereClause);
                System.out.println("Search query in inventory for sale details..." + inventorySDVO.getQuery());
                inventorySDVO.executeQuery();
                System.out.println("Sale details count..." + inventorySDVO.getRowCount());
                inventorySDVO.setWhereClause(null);
                
                String inventorySADWhereClause = "card_num like '"+SelectedCardNumber+"'";
                DCIteratorBinding inventorySADIterator = bindingsAM.findIteratorBinding("InventorySaleAccDetailsVO1Iterator");
                ViewObjectImpl inventorySADVO = (ViewObjectImpl)inventorySADIterator.getViewObject();  
                inventorySADVO.refreshWhereClauseParams();
                inventorySADVO.setWhereClause(inventorySADWhereClause);
                System.out.println("Search query in inventory for sale account entry details..." + inventorySADVO.getQuery());
                inventorySADVO.executeQuery();
                System.out.println("Sale account details count..." + inventorySADVO.getRowCount());
                inventorySADVO.setWhereClause(null);
                if (inventorySADVO.getRowCount() != 0) {
                    getInventorySaleDetailsPanel().setRendered(true);    
                }
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No events occurred for the selected card number", genMsg.getMessage("302",lngCode)));
            getInventoryDetails().setRendered(false);
//            getInventoryEventDetailsPanel().setRendered(false);
//            getInventorySaleDetailsPanel().setRendered(false);
        }
        
        return null;
    }

    public void setInventoryEventDetailsPanel(RichPanelGroupLayout inventoryEventDetailsPanel) {
        this.inventoryEventDetailsPanel = inventoryEventDetailsPanel;
    }

    public RichPanelGroupLayout getInventoryEventDetailsPanel() {
        return inventoryEventDetailsPanel;
    }

    public void setInventorySaleDetailsPanel(RichPanelGroupLayout inventorySaleDetailsPanel) {
        this.inventorySaleDetailsPanel = inventorySaleDetailsPanel;
    }

    public RichPanelGroupLayout getInventorySaleDetailsPanel() {
        return inventorySaleDetailsPanel;
    }

    public void setInventoryDetails(RichPanelTabbed inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

    public RichPanelTabbed getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryAccountDetailsPanel(RichPanelGroupLayout inventoryAccountDetailsPanel) {
        this.inventoryAccountDetailsPanel = inventoryAccountDetailsPanel;
    }

    public RichPanelGroupLayout getInventoryAccountDetailsPanel() {
        return inventoryAccountDetailsPanel;
    }
}
