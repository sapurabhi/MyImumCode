package com.imum.cpms.transactions.pvt;

import com.imum.cpms.model.transactions.vo.PVTDiscCnclHeaderVORowImpl;

import com.imum.cpms.util.MessageUtil;
import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessPortType;
import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessService;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import javax.xml.ws.WebServiceRef;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class PVTRollbackDiscountMBean {

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    
    private RichPanelGroupLayout discountedPVTsSearchResultsPanel;
    
    private String hide;
    private RichInputText discountseq;
    private RichInputDate pvtissueddatefrom;
    private RichInputDate pvtissueddateto;
    private RichInputText discountpercentage;
    private RichInputText discountflat;
    private RichInputText amtrangefrom;
    private RichInputText amtrangeto;
    private RichSelectOneChoice contracode;
    private RichInputDate promoeffectivedatefrom;
    private RichInputDate promoeffectivedateto;
    private RichSelectOneChoice sector;
    private RichSelectOneChoice zone;
    private RichSelectOneChoice pvtstage;
    private RichSelectOneChoice pvtstatus;
    private RichInputText remarks;
    private RichPanelFormLayout headersearchform;
    
    String lngCode = httpSession.getAttribute("language").toString();
    MessageUtil genMsg = new MessageUtil();

    public PVTRollbackDiscountMBean() {
        if (lngCode==null || lngCode.equals("")) {
             lngCode = "EN";
        }
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public String DiscountedPVTsSearch() {
        String result = validateDataOnSearchAction();
        if (result.equals("pass")) {
            System.out.println("Retrieving discounted pvts on search condition...");
            
            DCIteratorBinding headerIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
            ViewObject pvtDiscountHeaderVO = headerIteratorBinding.getViewObject();
            PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
            
            String discountSearchWhereClause = "approved_by IS NULL AND approved_date IS NULL AND disc_cncl_status=2";
            
            if (pvtDiscountHeaderRow != null) {
                
                if (pvtDiscountHeaderRow.getDISCCNCLhdrSeq() != null) {
                   discountSearchWhereClause = discountSearchWhereClause + " AND DISC_CNCL_hdr_Seq = "+Integer.parseInt(pvtDiscountHeaderRow.getDISCCNCLhdrSeq().toString());
                }
                if (pvtDiscountHeaderRow.getPVTdatefrom() != null) {
                   java.sql.Date pvtIssuedDateFrom = new java.sql.Date(pvtDiscountHeaderRow.getPVTdatefrom().getTime());
                   discountSearchWhereClause = discountSearchWhereClause + " AND PVT_date_from = '"+pvtIssuedDateFrom+"'";
                }
                if (pvtDiscountHeaderRow.getPVTdateto() != null) {
                    java.sql.Date pvtIssuedDateTo = new java.sql.Date(pvtDiscountHeaderRow.getPVTdateto().getTime());
                    discountSearchWhereClause = discountSearchWhereClause + " AND PVT_date_to = '"+pvtIssuedDateTo+"'";
                }
                if (pvtDiscountHeaderRow.getDISCPCT() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND DISC_PCT >= "+Float.parseFloat(pvtDiscountHeaderRow.getDISCPCT().toString());
                }
                if (pvtDiscountHeaderRow.getDISCFLATAMT() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND PVT_AMT_PAYABLE <= "+pvtDiscountHeaderRow.getDISCFLATAMT();
                }               
                if (pvtDiscountHeaderRow.getPVTAmtRangefrom() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND Contra_code = "+pvtDiscountHeaderRow.getPVTAmtRangefrom();
                }
                if (pvtDiscountHeaderRow.getPVTAmtRangeTo() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND Sector_Code = "+pvtDiscountHeaderRow.getPVTAmtRangeTo();
                }
                if (pvtDiscountHeaderRow.getContracode() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND Contra_code = "+Integer.parseInt(pvtDiscountHeaderRow.getContracode().toString());
                }
                if (pvtDiscountHeaderRow.getPromoeffectivedatefrom() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND Promo_effective_date_from = '"+new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedatefrom().getTime())+"'";
                }
                if (pvtDiscountHeaderRow.getPromoeffectivedateTo() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND Promo_effective_date_To = '"+new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedateTo().getTime())+"'";
                }
                if (pvtDiscountHeaderRow.getSectorCode() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND Sector_Code = '"+pvtDiscountHeaderRow.getSectorCode().toString()+"'";
                }
                if (pvtDiscountHeaderRow.getzonecode() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND zone_code = '"+pvtDiscountHeaderRow.getzonecode().toString()+"'";
                }
                if (pvtDiscountHeaderRow.getPVTSTAGEID() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND PVT_STAGE_ID = "+Integer.parseInt(pvtDiscountHeaderRow.getPVTSTAGEID().toString());
                }
                if (pvtDiscountHeaderRow.getPVTStatusID() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND PVT_Status_ID = "+Integer.parseInt(pvtDiscountHeaderRow.getPVTStatusID().toString());
                }
                if (pvtDiscountHeaderRow.getRemarks() != null) {
                    discountSearchWhereClause = discountSearchWhereClause + " AND Remarks = '"+pvtDiscountHeaderRow.getRemarks().toString()+"'";
                }
               
                DCIteratorBinding discountSearchItterator = bindingsAM.findIteratorBinding("PVTRollbackDiscountSearchVO1Iterator");
                ViewObjectImpl discountSearchVO = (ViewObjectImpl)discountSearchItterator.getViewObject();  
                discountSearchVO.refreshWhereClauseParams();
                discountSearchVO.setWhereClause(discountSearchWhereClause);
                System.out.println("Search query to rollback discount..." + discountSearchVO.getQuery());
                discountSearchVO.executeQuery();
                System.out.println("Count of discounted pvts to rollback..." + discountSearchVO.getRowCount());
                
                ADFContext.getCurrent().getPageFlowScope().put("TotalPVTs", discountSearchVO.getRowCount());
                               
                if (discountSearchVO.getRowCount() != 0) {
                    getDiscountedPVTsSearchResultsPanel().setRendered(true);
                    
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("276",lngCode)));    
                    getDiscountedPVTsSearchResultsPanel().setRendered(false);
                }
            }
        }
        return null;
    }
    
    public String validateDataOnSearchAction() {
        String result = "pass";
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
        ViewObject pvtDiscountHeaderVO = dcIteratorBinding.getViewObject();
        PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
        if (pvtDiscountHeaderRow != null) {
            Object DISCCNCLhdrSeq = pvtDiscountHeaderRow.getDISCCNCLhdrSeq();
            Object PVTdatefrom = pvtDiscountHeaderRow.getPVTdatefrom();
            Object PVTdateto = pvtDiscountHeaderRow.getPVTdateto();
            Object DISCPCT = pvtDiscountHeaderRow.getDISCPCT();
            Object DISCFLATAMT = pvtDiscountHeaderRow.getDISCFLATAMT();
            Object PVTAmtRangefrom = pvtDiscountHeaderRow.getPVTAmtRangefrom();
            Object PVTAmtRangeTo = pvtDiscountHeaderRow.getPVTAmtRangeTo();
            Object Contracode = pvtDiscountHeaderRow.getContracode();
            Object Promoeffectivedatefrom = pvtDiscountHeaderRow.getPromoeffectivedatefrom();
            Object PromoeffectivedateTo = pvtDiscountHeaderRow.getPromoeffectivedateTo();
            Object SectorCode = pvtDiscountHeaderRow.getSectorCode();
            Object zonecode = pvtDiscountHeaderRow.getzonecode();
            Object PVTSTAGEID = pvtDiscountHeaderRow.getPVTSTAGEID();
            Object PVTStatusID = pvtDiscountHeaderRow.getPVTStatusID();
            Object Remarks = pvtDiscountHeaderRow.getRemarks();
            
            if (DISCCNCLhdrSeq==null && PVTdatefrom==null && PVTdateto==null && DISCPCT==null && DISCFLATAMT==null && PVTAmtRangefrom==null && PVTAmtRangeTo==null && Contracode==null && 
                               Promoeffectivedatefrom==null && PromoeffectivedateTo==null && SectorCode==null && zonecode==null && PVTSTAGEID==null && PVTStatusID==null && Remarks==null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("277",lngCode)));    
                result = "fail"; 
            }
        }
        return result;
    }

    public String ResetDiscountedPVTsSearch() {
        
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
        ViewObject pvtDiscountHeaderVO = dcIteratorBinding.getViewObject();
        PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
        if (pvtDiscountHeaderRow != null) {
            System.out.println("Row exists in pvt header VO for discount rollback, removing the current row !!");
            pvtDiscountHeaderRow.remove();
        }
        Row createRow = pvtDiscountHeaderVO.createRow();
        pvtDiscountHeaderVO.insertRow(createRow);
        
        getDiscountedPVTsSearchResultsPanel().setRendered(false);
        
        return null;
    }

    public void setDiscountedPVTsSearchResultsPanel(RichPanelGroupLayout discountedPVTsSearchResultsPanel) {
        this.discountedPVTsSearchResultsPanel = discountedPVTsSearchResultsPanel;
    }

    public RichPanelGroupLayout getDiscountedPVTsSearchResultsPanel() {
        return discountedPVTsSearchResultsPanel;
    }
    
    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }

    @WebServiceRef
    private static BulkDiscountApprovalBPMProcessService bulkDiscountApprovalBPMProcessService;
    
    public String RollbackDiscountOnSubmit() {
        
        String userName = null;
        if (httpSession.getAttribute("loggedinUserid") == null || httpSession.getAttribute("loggedinUserid").equals("")) {                
            userName = "anonymous";
        } else {
            userName = httpSession.getAttribute("loggedinUserid").toString();
        }
        
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
        ViewObject pvtDiscountHeaderVO = dcIteratorBinding.getViewObject();
        PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
        if (pvtDiscountHeaderRow != null) {
            System.out.println("Row exists in pvt header VO for discount rollback, removing the current row !!");
            pvtDiscountHeaderRow.remove();
        }
        
        DCIteratorBinding rollbackIteratorBinding = bindingsAM.findIteratorBinding("PVTRollbackDiscountSearchVO1Iterator");
        ViewObjectImpl rollbackDiscountVO = (ViewObjectImpl)rollbackIteratorBinding.getViewObject();
        
        if (rollbackDiscountVO != null) {
               Row uniqueDiscountRow[] = rollbackDiscountVO.getFilteredRows("uniqueDiscountSeq", new BigDecimal(1));  
               System.out.println("Filtered unique discount to rollback sequences..." + uniqueDiscountRow.length);
               if (uniqueDiscountRow.length > 0) {
                   for (int i = 0;i<uniqueDiscountRow.length;i++) {
                       Row rollbackDiscountVORow = uniqueDiscountRow[i];
                       if (rollbackDiscountVORow != null) {
                           System.out.println("Discount sequences sending to service..." + rollbackDiscountVORow.getAttribute("disccnclhdrseq"));
                           OperationBinding opBindingRollbackSeq = bindingsAM.getOperationBinding("updateRollbackDiscountStatus");
                           opBindingRollbackSeq.getParamsMap().put("userName", userName);
                           opBindingRollbackSeq.getParamsMap().put("rollbackDiscountSeq", rollbackDiscountVORow.getAttribute("disccnclhdrseq"));
                           opBindingRollbackSeq.execute();
                           
                           // Calling BPM webservice and passing discount header sequence to rollback
                           
                           System.out.println("##### Start of calling BPM Service to Rollback Discount #####");
                           System.out.println("Passing discount header seq to service...." + rollbackDiscountVORow.getAttribute("disccnclhdrseq"));
                           
                           bulkDiscountApprovalBPMProcessService = new BulkDiscountApprovalBPMProcessService();
                           BulkDiscountApprovalBPMProcessPortType bulkDiscountApprovalBPMProcessPortType = bulkDiscountApprovalBPMProcessService.getBulkDiscountApprovalBPMProcessPort();
                           bulkDiscountApprovalBPMProcessPortType.start(Integer.parseInt(rollbackDiscountVORow.getAttribute("disccnclhdrseq").toString()));
                           
                           System.out.println("##### End of calling BPM Service #####");
                       }
                   }        
               }
          }
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("278",lngCode)));
        
        getDiscountedPVTsSearchResultsPanel().setRendered(false);
        Row createRow = pvtDiscountHeaderVO.createRow();
        pvtDiscountHeaderVO.insertRow(createRow);
        
        return null;
    }

    public String DiscountRollbackCancelledAction(ActionEvent actionEvent) {
        getAmtrangeto().setValue(null);
        amtrangeto.resetValue();
        getDiscountseq().setValue(null);
        discountseq.resetValue();
        getPvtissueddatefrom().setValue(null);
        pvtissueddatefrom.resetValue();
        getPvtissueddateto().setValue(null);
        pvtissueddateto.resetValue();
        getDiscountpercentage().setValue(null);
        discountpercentage.resetValue();
        getDiscountflat().setValue(null);
        discountflat.resetValue();
        getAmtrangefrom().setValue(null);
        amtrangefrom.resetValue();
        getContracode().setValue(null);
        contracode.resetValue();
        getPromoeffectivedatefrom().setValue(null);
        promoeffectivedatefrom.resetValue();
        getPromoeffectivedateto().setValue(null);
        promoeffectivedatefrom.resetValue();
        getSector().setValue(null);
        sector.resetValue();
        getZone().setValue(null);
        zone.resetValue();
        getPvtstage().setValue(null);
        pvtstage.resetValue();
        getPvtstatus().setValue(null);
        pvtstatus.resetValue();
        getRemarks().setValue(null);
        remarks.resetValue();
        
        UIComponent comp = actionEvent.getComponent();
        oracle.adf.view.rich.util.ResetUtils.reset(comp);
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.headersearchform);
        
        getDiscountedPVTsSearchResultsPanel().setRendered(false);
        return null;
    }

    public void setDiscountseq(RichInputText discountseq) {
        this.discountseq = discountseq;
    }

    public RichInputText getDiscountseq() {
        return discountseq;
    }

    public void setPvtissueddatefrom(RichInputDate pvtissueddatefrom) {
        this.pvtissueddatefrom = pvtissueddatefrom;
    }

    public RichInputDate getPvtissueddatefrom() {
        return pvtissueddatefrom;
    }

    public void setPvtissueddateto(RichInputDate pvtissueddateto) {
        this.pvtissueddateto = pvtissueddateto;
    }

    public RichInputDate getPvtissueddateto() {
        return pvtissueddateto;
    }

    public void setDiscountpercentage(RichInputText discountpercentage) {
        this.discountpercentage = discountpercentage;
    }

    public RichInputText getDiscountpercentage() {
        return discountpercentage;
    }

    public void setDiscountflat(RichInputText discountflat) {
        this.discountflat = discountflat;
    }

    public RichInputText getDiscountflat() {
        return discountflat;
    }

    public void setAmtrangefrom(RichInputText amtrangefrom) {
        this.amtrangefrom = amtrangefrom;
    }

    public RichInputText getAmtrangefrom() {
        return amtrangefrom;
    }

    public void setAmtrangeto(RichInputText amtrangeto) {
        this.amtrangeto = amtrangeto;
    }

    public RichInputText getAmtrangeto() {
        return amtrangeto;
    }

    public void setContracode(RichSelectOneChoice contracode) {
        this.contracode = contracode;
    }

    public RichSelectOneChoice getContracode() {
        return contracode;
    }

    public void setPromoeffectivedatefrom(RichInputDate promoeffectivedatefrom) {
        this.promoeffectivedatefrom = promoeffectivedatefrom;
    }

    public RichInputDate getPromoeffectivedatefrom() {
        return promoeffectivedatefrom;
    }

    public void setPromoeffectivedateto(RichInputDate promoeffectivedateto) {
        this.promoeffectivedateto = promoeffectivedateto;
    }

    public RichInputDate getPromoeffectivedateto() {
        return promoeffectivedateto;
    }

    public void setSector(RichSelectOneChoice sector) {
        this.sector = sector;
    }

    public RichSelectOneChoice getSector() {
        return sector;
    }

    public void setZone(RichSelectOneChoice zone) {
        this.zone = zone;
    }

    public RichSelectOneChoice getZone() {
        return zone;
    }

    public void setPvtstage(RichSelectOneChoice pvtstage) {
        this.pvtstage = pvtstage;
    }

    public RichSelectOneChoice getPvtstage() {
        return pvtstage;
    }

    public void setPvtstatus(RichSelectOneChoice pvtstatus) {
        this.pvtstatus = pvtstatus;
    }

    public RichSelectOneChoice getPvtstatus() {
        return pvtstatus;
    }

    public void setRemarks(RichInputText remarks) {
        this.remarks = remarks;
    }

    public RichInputText getRemarks() {
        return remarks;
    }

    public void setHeadersearchform(RichPanelFormLayout headersearchform) {
        this.headersearchform = headersearchform;
    }

    public RichPanelFormLayout getHeadersearchform() {
        return headersearchform;
    }
}
