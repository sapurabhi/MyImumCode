package com.imum.cpms.transactions.pvt;

import com.imum.cpms.model.transactions.vo.PVTDiscCnclDetailVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscCnclHeaderVORowImpl;

import com.imum.cpms.model.transactions.vo.PVTDiscountHeaderSearchVORowImpl;

import com.imum.cpms.util.MessageUtil;
import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessPortType;
import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessService;

import java.math.BigDecimal;

import java.sql.Timestamp;

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
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class PVTDiscountMBean {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    private RichSelectOneRadio contraFeeOption;
    private RichInputText contraFeeEntered;
    private RichPanelGroupLayout pvTDiscountSearchResultsPanel;
    private String hide;
    String lngCode = httpSession.getAttribute("language").toString();
    MessageUtil genMsg = new MessageUtil();
    
    public PVTDiscountMBean() {
        if(lngCode==null || lngCode.equals(""))
            {
             lngCode = "EN";
            }
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setContraFeeOption(RichSelectOneRadio contraFeeOption) {
        this.contraFeeOption = contraFeeOption;
    }

    public RichSelectOneRadio getContraFeeOption() {
        return contraFeeOption;
    }

    public void setContraFeeEntered(RichInputText contraFeeEntered) {
        this.contraFeeEntered = contraFeeEntered;
    }

    public RichInputText getContraFeeEntered() {
        return contraFeeEntered;
    }

    public String PVTSearchAction() {
        String result = validateDataOnSearchAction();
        if (result.equals("pass")) {
            System.out.println("Retrieving data on search condition...");
            
            DCIteratorBinding headerIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
            ViewObject pvtDiscountHeaderVO = headerIteratorBinding.getViewObject();
            PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
            
            String discountSearchWhereClause = null;
            int pvtStage = 0;
            int pvtStatus = 0;
            int contraventionCode = 0;
            String sector = null;
            String zone = null;
            int plateType = 0;
            int plateCategory = 0;
            String plateNumber = null;
            int PlateCountry = 0;
            
            if (pvtDiscountHeaderRow != null) {
                java.sql.Date pvtIssuedDateFrom = new java.sql.Date(pvtDiscountHeaderRow.getPVTdatefrom().getTime());
                System.out.println("Issued Date From..." + pvtIssuedDateFrom);
                java.sql.Date pvtIssuedDateTo = new java.sql.Date(pvtDiscountHeaderRow.getPVTdateto().getTime());
                System.out.println("Issued Date To..." + pvtIssuedDateTo);
                discountSearchWhereClause = "PVT_date_time >= '"+pvtIssuedDateFrom+"' AND PVT_date_time <= '"+pvtIssuedDateTo+" 23:59:59'";
                System.out.println("Stage..." + pvtDiscountHeaderRow.getPVTSTAGEID());
                if (pvtDiscountHeaderRow.getPVTSTAGEID() != null) {
                   pvtStage  = Integer.parseInt(pvtDiscountHeaderRow.getPVTSTAGEID().toString());
                   discountSearchWhereClause = discountSearchWhereClause + " AND PVT_Stage_ID = "+pvtStage;
                }
                System.out.println("Status..." + pvtDiscountHeaderRow.getPVTStatusID());
                if (pvtDiscountHeaderRow.getPVTStatusID() != null) {
                    pvtStatus = Integer.parseInt(pvtDiscountHeaderRow.getPVTStatusID().toString());
                    discountSearchWhereClause = discountSearchWhereClause + " AND PVT_Status_ID = "+pvtStatus;
                }
                System.out.println("Outstanding Greater..." + pvtDiscountHeaderRow.getPVTAmtRangefrom());
                if (pvtDiscountHeaderRow.getPVTAmtRangefrom() != null) {
                    BigDecimal outstandingGreater = pvtDiscountHeaderRow.getPVTAmtRangefrom();
                    discountSearchWhereClause = discountSearchWhereClause + " AND PVT_AMT_PAYABLE >= "+outstandingGreater;
                }
                System.out.println("Outstanding Lesser..." + pvtDiscountHeaderRow.getPVTAmtRangeTo());
                if (pvtDiscountHeaderRow.getPVTAmtRangeTo() != null) {
                    BigDecimal outstandingLesser = pvtDiscountHeaderRow.getPVTAmtRangeTo();
                    discountSearchWhereClause = discountSearchWhereClause + " AND PVT_AMT_PAYABLE <= "+outstandingLesser;
                }               
                System.out.println("Contravention Code..." + pvtDiscountHeaderRow.getContracode());
                if (pvtDiscountHeaderRow.getContracode() != null) {
                    contraventionCode = Integer.parseInt(pvtDiscountHeaderRow.getContracode().toString());
                    discountSearchWhereClause = discountSearchWhereClause + " AND Contra_code = "+contraventionCode;
                }
                System.out.println("Sector..." + pvtDiscountHeaderRow.getSectorCode());
                if (pvtDiscountHeaderRow.getSectorCode() != null) {
                    sector = pvtDiscountHeaderRow.getSectorCode().toString();
                    discountSearchWhereClause = discountSearchWhereClause + " AND Sector_Code = '"+sector+"'";
                }
                System.out.println("Zone..." + pvtDiscountHeaderRow.getzonecode());
                if (pvtDiscountHeaderRow.getzonecode() != null) {
                    zone = pvtDiscountHeaderRow.getzonecode().toString();
                    discountSearchWhereClause = discountSearchWhereClause + " AND zone_code = '"+zone+"'";
                }
                
                System.out.println("Plate Category..." + pvtDiscountHeaderRow.getPlateCategory());
                if (pvtDiscountHeaderRow.getPlateCategory() != null) {
                    plateCategory = Integer.parseInt(pvtDiscountHeaderRow.getPlateCategory().toString());
                    System.out.println("Plate Type..." + pvtDiscountHeaderRow.getPlateType());
                    if(pvtDiscountHeaderRow.getPlateCountry() != null)
                        PlateCountry = Integer.parseInt(pvtDiscountHeaderRow.getPlateCountry().toString());
                    if (pvtDiscountHeaderRow.getPlateType() != null) {
                        plateType = Integer.parseInt(pvtDiscountHeaderRow.getPlateType().toString());
                        discountSearchWhereClause = discountSearchWhereClause + " AND Plate_Id IN (select plate_id from veh_plate_mst where PLATE_CTG_ID="+plateCategory+" and plate_cnt_id="+PlateCountry+" and plate_type_id="+plateType+" and Country_Code='ARE')";
                    }
                } else {
                    if (pvtDiscountHeaderRow.getPlateType() != null) {
                        pvtDiscountHeaderRow.setPlateType(null);
                    }
                }
                
                System.out.println("Plate Number..." + pvtDiscountHeaderRow.getPlateNumber());
                if (pvtDiscountHeaderRow.getPlateNumber() != null) {
                    plateNumber = pvtDiscountHeaderRow.getPlateNumber().toString();
                    discountSearchWhereClause = discountSearchWhereClause + " AND Request_log_seq IN (select request_log_seq from pvt_hhc_request_log where plate_number like '%"+plateNumber+"%')";
                }
                
                BigDecimal ContraFeeEntered = new BigDecimal(getContraFeeEntered().getValue().toString());
                System.out.println("Contra fee entered for discount..." + ContraFeeEntered);
                
                DCIteratorBinding discountSearchItterator = bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator");
                ViewObjectImpl discountSearchVO = (ViewObjectImpl)discountSearchItterator.getViewObject(); 
                discountSearchVO.refreshWhereClauseParams();
                discountSearchVO.setWhereClause(discountSearchWhereClause + " and pvt_status_id=1");
                System.out.println("Search query..." + discountSearchVO.getQuery());
                discountSearchVO.executeQuery();
                System.out.println("Count of search results rows..." + discountSearchVO.getRowCount());
                
                ADFContext.getCurrent().getPageFlowScope().put("TotalPVTs", discountSearchVO.getRowCount());
                
                // Calculating discount based on criteria
                
                BigDecimal PVTAmountAfterDiscount = null;
                BigDecimal DiscountedContraFee = null;
                BigDecimal ContraFeeAfterDiscount = null;
                
                String contraOptionSelected = getContraFeeOption().getValue().toString();
                System.out.println("Contra Option Selected..." + contraOptionSelected);
                
                
                BigDecimal TotalPVTAmountPayable = new BigDecimal("0.00");
                BigDecimal TotalPVTAmountAfterDiscount = new BigDecimal("0.00");
                BigDecimal TotalContraAmt = new BigDecimal("0.00");
                BigDecimal TotalDiscountedContraFee = new BigDecimal("0.00");
                BigDecimal TotalContraFeeAfterDiscount = new BigDecimal("0.00");
                
                if (discountSearchVO != null) {
                    RowSetIterator searchResultsIterator = discountSearchVO.createRowSetIterator(null);
                    while (searchResultsIterator.hasNext()) { 
                        Row discountSearchRow = searchResultsIterator.next();
                        BigDecimal PVTAMTPAYABLE = (BigDecimal)discountSearchRow.getAttribute("PVTAMTPAYABLE");
                        
                        TotalPVTAmountPayable = TotalPVTAmountPayable.add(PVTAMTPAYABLE);
//                        System.out.println("PVTAMTPAYABLE..." + PVTAMTPAYABLE);
//                        System.out.println("TotalPVTAmountPayable..." + TotalPVTAmountPayable);
                            
                        BigDecimal CONTRAAMT = (BigDecimal)discountSearchRow.getAttribute("CONTRAAMT");
                        
                        TotalContraAmt = TotalContraAmt.add(CONTRAAMT);
//                        System.out.println("CONTRAAMT..." + CONTRAAMT);
//                        System.out.println("TotalContraAmt..." + TotalContraAmt);
                        
                        BigDecimal zeroCompare = new BigDecimal("0.0000");
                        
                        if (!PVTAMTPAYABLE.stripTrailingZeros().equals(zeroCompare.stripTrailingZeros())) {
                                
                            if (contraOptionSelected.equalsIgnoreCase("PercentageDiscount")) {
                                pvtDiscountHeaderRow.setDISCPCT(ContraFeeEntered);
                                BigDecimal ONEHUNDERT = new BigDecimal(100);
                                DiscountedContraFee = CONTRAAMT.multiply(ContraFeeEntered).divide(ONEHUNDERT);
                            //    System.out.println("DiscountedContraFee contains negative..." + DiscountedContraFee.toString().contains("-"));
                                ContraFeeAfterDiscount = CONTRAAMT.subtract(DiscountedContraFee);
                            //    System.out.println("ContraFeeAfterDiscount contains negative..." + ContraFeeAfterDiscount.toString().contains("-"));
                                PVTAmountAfterDiscount = PVTAMTPAYABLE.subtract(DiscountedContraFee);
                              //  System.out.println("PVTAmountAfterDiscount contains negative..." + PVTAmountAfterDiscount.toString().contains("-"));
                            } else {
                                pvtDiscountHeaderRow.setDISCFLATAMT(ContraFeeEntered);
                                DiscountedContraFee = ContraFeeEntered;
                           //     System.out.println("DiscountedContraFee contains negative..." + DiscountedContraFee.toString().contains("-"));
                                ContraFeeAfterDiscount = CONTRAAMT.subtract(DiscountedContraFee);
                          //      System.out.println("ContraFeeAfterDiscount contains negative..." + ContraFeeAfterDiscount.toString().contains("-"));
                                PVTAmountAfterDiscount = PVTAMTPAYABLE.subtract(DiscountedContraFee);
                          //      System.out.println("PVTAmountAfterDiscount contains negative..." + PVTAmountAfterDiscount.toString().contains("-"));
                            }
                            if (DiscountedContraFee.toString().contains("-")) {
                                DiscountedContraFee = zeroCompare;
                            }
                            if (ContraFeeAfterDiscount.toString().contains("-")) {
                                ContraFeeAfterDiscount = zeroCompare;
                            }
                            if (PVTAmountAfterDiscount.toString().contains("-")) {
                                PVTAmountAfterDiscount = zeroCompare;
                            }
                            
                            discountSearchRow.setAttribute("PVTAmountAfterDiscount", PVTAmountAfterDiscount);
                            TotalPVTAmountAfterDiscount = TotalPVTAmountAfterDiscount.add(PVTAmountAfterDiscount);
                            discountSearchRow.setAttribute("DiscountedContraFee", DiscountedContraFee);
                            TotalDiscountedContraFee = TotalDiscountedContraFee.add(DiscountedContraFee);
                            discountSearchRow.setAttribute("ContraFeeAfterDiscount", ContraFeeAfterDiscount);
                            TotalContraFeeAfterDiscount = TotalContraFeeAfterDiscount.add(ContraFeeAfterDiscount);
                        } else {
                            discountSearchRow.setAttribute("PVTAmountAfterDiscount", new BigDecimal("0.00"));
                            discountSearchRow.setAttribute("DiscountedContraFee", new BigDecimal("0.00"));
                            discountSearchRow.setAttribute("ContraFeeAfterDiscount", new BigDecimal("0.00"));
                        }
                    }
                    
                    ADFContext.getCurrent().getPageFlowScope().put("TotalPVTAmountPayable", TotalPVTAmountPayable);
                    ADFContext.getCurrent().getPageFlowScope().put("TotalPVTAmountAfterDiscount", TotalPVTAmountAfterDiscount);
                    ADFContext.getCurrent().getPageFlowScope().put("TotalContraAmt", TotalContraAmt);
                    ADFContext.getCurrent().getPageFlowScope().put("TotalDiscountedContraFee", TotalDiscountedContraFee);
                    ADFContext.getCurrent().getPageFlowScope().put("TotalContraFeeAfterDiscount", TotalContraFeeAfterDiscount);
                    
                }
                
//                for (int searchRow=0; searchRow<discountSearchVO.getRowCount(); searchRow++) { 
//                    PVTDiscountHeaderSearchVORowImpl pvtDiscountHeaderSearchVORow = (PVTDiscountHeaderSearchVORowImpl)discountSearchVO.getRowAtRangeIndex(searchRow);
//            //        System.out.println("Calculating discount for row..." + searchRow);
//                    
//                    if (pvtDiscountHeaderSearchVORow != null) {
//                        BigDecimal PVTAMTPAYABLE = pvtDiscountHeaderSearchVORow.getPVTAMTPAYABLE();
//                        BigDecimal CONTRAAMT = pvtDiscountHeaderSearchVORow.getCONTRAAMT();
//                        BigDecimal zeroCompare = new BigDecimal("0.0000");
//                        
//                  //      System.out.println("PVTAMTPAYABLE value to calculate dicount...." + PVTAMTPAYABLE.stripTrailingZeros());
//                        if (!PVTAMTPAYABLE.stripTrailingZeros().equals(zeroCompare.stripTrailingZeros())) {
//                           // System.out.println("Calculating discount with contra fee for PVTAMTPAYABLE");
//                                
//                            if (contraOptionSelected.equalsIgnoreCase("PercentageDiscount")) {
//                                BigDecimal ONEHUNDERT = new BigDecimal(100);
//                                DiscountedContraFee = CONTRAAMT.multiply(ContraFeeEntered).divide(ONEHUNDERT);
//                                ContraFeeAfterDiscount = CONTRAAMT.subtract(DiscountedContraFee);
//                                PVTAmountAfterDiscount = PVTAMTPAYABLE.subtract(DiscountedContraFee);
//                            } else {
//                                DiscountedContraFee = ContraFeeEntered;
//                                ContraFeeAfterDiscount = CONTRAAMT.subtract(DiscountedContraFee);
//                                PVTAmountAfterDiscount = PVTAMTPAYABLE.subtract(DiscountedContraFee);
//                            }
//                            pvtDiscountHeaderSearchVORow.setPVTAmountAfterDiscount(PVTAmountAfterDiscount);
//                            pvtDiscountHeaderSearchVORow.setDiscountedContraFee(DiscountedContraFee);
//                            pvtDiscountHeaderSearchVORow.setContraFeeAfterDiscount(ContraFeeAfterDiscount);
//                        } else {
//                            pvtDiscountHeaderSearchVORow.setPVTAmountAfterDiscount(new BigDecimal("0.00"));
//                            pvtDiscountHeaderSearchVORow.setDiscountedContraFee(new BigDecimal("0.00"));
//                            pvtDiscountHeaderSearchVORow.setContraFeeAfterDiscount(new BigDecimal("0.00"));
//                        }
//                    }
//                }
                               
                if (discountSearchVO.getRowCount() != 0) {
                    getPvTDiscountSearchResultsPanel().setRendered(true);
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("28",lngCode)));    
                    getPvTDiscountSearchResultsPanel().setRendered(false);
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
            Object pvtIssuedDateFrom = pvtDiscountHeaderRow.getPVTdatefrom();
           // System.out.println("PVT Issued Date From..." + pvtIssuedDateFrom);
            if (pvtIssuedDateFrom == null || pvtIssuedDateFrom.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("217",lngCode)));    
                result = "fail";    
            }
            Object pvtIssuedDateTo = pvtDiscountHeaderRow.getPVTdateto();
          //  System.out.println("PVT Issued Date To..." + pvtIssuedDateTo);
            if (pvtIssuedDateTo == null || pvtIssuedDateTo.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("218",lngCode)));    
                result = "fail";    
            }
            
            if (pvtIssuedDateFrom != null && pvtIssuedDateTo != null) {
                java.sql.Date pvtIssuedFromDate = new java.sql.Date(pvtDiscountHeaderRow.getPVTdatefrom().getTime());
                java.sql.Date pvtIssuedToDate = new java.sql.Date(pvtDiscountHeaderRow.getPVTdateto().getTime());
                if (pvtIssuedFromDate.after(pvtIssuedToDate)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("219",lngCode)));    
                    result = "fail";    
                }  
            }
            
            Object plateCategory = pvtDiscountHeaderRow.getPlateCategory();
        //    System.out.println(plateCategory);
            Object plateType = pvtDiscountHeaderRow.getPlateType();
         //   System.out.println(plateType);
            if (plateCategory != null && !plateCategory.equals("")) {
                if (plateType == null || plateType.equals("")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("93",lngCode)));    
                    result = "fail";
                }
            } else if (plateType != null) {
                   plateType = null;
            }
            
            
          //  System.out.println("Contravention fee entered..." + getContraFeeEntered().getValue());
            if (getContraFeeEntered().getValue() == null || getContraFeeEntered().getValue().equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("220",lngCode)));    
                result = "fail";  
            }
            
            if (getContraFeeOption().getValue() != null || !getContraFeeOption().getValue().equals("")) {
                String contraOptionSelected = getContraFeeOption().getValue().toString();            
                if (contraOptionSelected.equalsIgnoreCase("PercentageDiscount")) {   
                    if (getContraFeeEntered().getValue() != null && !getContraFeeEntered().getValue().equals("")) {
                        int ContraFeeEntered = Integer.parseInt(getContraFeeEntered().getValue().toString());
                        if (ContraFeeEntered > 100) {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("221",lngCode)));    
                            result = "fail";
                        }
                    }
                }
            }
            

        }
        return result;   
    }

    public String PVTSearchResetAction() {
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
        ViewObject pvtDiscountHeaderVO = dcIteratorBinding.getViewObject();
        pvtDiscountHeaderVO.clearCache();
        PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
        if (pvtDiscountHeaderRow != null) {
            System.out.println("Row exists in pvt header VO, removing...");
            pvtDiscountHeaderRow.remove();
        }
        Row createRow = pvtDiscountHeaderVO.createRow();
        pvtDiscountHeaderVO.insertRow(createRow);
        
        getContraFeeOption().setId("PercentageDiscount");
        getContraFeeEntered().setValue(null);
        getPvTDiscountSearchResultsPanel().setRendered(false);
        
        return null;
    }

    public void contraFeeOptionVC(ValueChangeEvent valueChangeEvent) {
        System.out.println("Select contra fee option..." + valueChangeEvent.getNewValue());
        getContraFeeOption().setValue(valueChangeEvent.getNewValue());
    }
    
    @WebServiceRef
    private static BulkDiscountApprovalBPMProcessService bulkDiscountApprovalBPMProcessService;

    public String PVTSubmitAction() {
        String result = validateSubmitData();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        
        if (result.equalsIgnoreCase("Pass"))
        {
            String userName = null;
            if (httpSession.getAttribute("loggedinUserid") == null || httpSession.getAttribute("loggedinUserid").equals("")) {                
                userName = "anonymous";
            } else {
                userName = httpSession.getAttribute("loggedinUserid").toString();
            }
            OperationBinding operationBindings = bindings.getOperationBinding("addPVTHeaderData");
            operationBindings.getParamsMap().put("userid", userName);
            operationBindings.execute();
            
            // start of inserting into discount details table
            
            DCIteratorBinding discountSearchItterator = bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator");
            ViewObjectImpl discountSearchVO = (ViewObjectImpl)discountSearchItterator.getViewObject(); 
            
            DCIteratorBinding discountDetailBinding = bindingsAM.findIteratorBinding("PVTDiscCnclDetailVO1Iterator");
            ViewObject pvtDiscountDetailVO = discountDetailBinding.getViewObject();
            long count = discountSearchVO.getEstimatedRowCount();
            RowSetIterator itr = discountSearchVO.createRowSetIterator(null);
           long localcount = 0;
          //  System.out.println("Discount search results row count..." + discountSearchVO.getRowCount());
            for(PVTDiscountHeaderSearchVORowImpl row = (PVTDiscountHeaderSearchVORowImpl)discountSearchVO.first();discountSearchVO.hasNext();row = (PVTDiscountHeaderSearchVORowImpl)discountSearchVO.next())
            {
                if(row !=null)
                {
                    localcount++;
                    Row discountDetailRow = pvtDiscountDetailVO.createRow();
              //      discountDetailRow.setAttribute("DISCCNCLhdrSeq", Integer.parseInt(pvtLastDiscountHeaderRow.getDISCCNCLhdrSeq().toString())+1);
                    discountDetailRow.setAttribute("DISCCNCLhdrSeq", 0);
                    discountDetailRow.setAttribute("PVTHDRSEQ", row.getPVTHDRSEQ());
                    discountDetailRow.setAttribute("ORGCONTRAAMT", row.getCONTRAAMT());
                    discountDetailRow.setAttribute("COMPDISCONCONTRAAMT", row.getDiscountedContraFee());
                    discountDetailRow.setAttribute("PVTAMTPAYABLE", row.getPVTAmountAfterDiscount());
                    discountDetailRow.setAttribute("Approvedflag", "N");
                    discountDetailRow.setAttribute("CreatedBy", userName);
                    discountDetailRow.setAttribute("CreatedDate", sqlDate);                
              //      System.out.println("Inserting into discount detail row..." + searchRow);
                    pvtDiscountDetailVO.insertRow(discountDetailRow);
                    System.out.println(localcount);
                }
                }
            
    
            // end of inserting into discount details table
            
            if (operationBindings.getErrors().isEmpty()) {
                OperationBinding operationBinding = bindings.getOperationBinding("commit");
                operationBinding.execute();  
                if (operationBinding.getErrors().isEmpty())
                {
                    // calling method for getting header sequence
                    OperationBinding operationBindingSeq = bindings.getOperationBinding("getDiscountHeaderSeq");
                    Object PvtHeaderSeqObject = operationBindingSeq.execute();  
                    int  PvtHeaderSeq = Integer.parseInt(PvtHeaderSeqObject.toString());                    
                    
                    // Calling BPM webservice and passing discount header sequence generated
                    
                    System.out.println("##### Start of calling BPM Service #####");
                    System.out.println("Passing discount header seq to service...." + PvtHeaderSeq);
                    
                    bulkDiscountApprovalBPMProcessService = new BulkDiscountApprovalBPMProcessService();
                    BulkDiscountApprovalBPMProcessPortType bulkDiscountApprovalBPMProcessPortType = bulkDiscountApprovalBPMProcessService.getBulkDiscountApprovalBPMProcessPort();
                    bulkDiscountApprovalBPMProcessPortType.start(PvtHeaderSeq);
                    
                    System.out.println("##### End of calling BPM Service #####");
                    
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("216",lngCode) + PvtHeaderSeq));

                    DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
                    ViewObject pvtDiscountHeaderVO = dcIteratorBinding.getViewObject();
                    pvtDiscountHeaderVO.clearCache();
                    PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
                    if (pvtDiscountHeaderRow != null) {
                        System.out.println("Row exists in pvt discount header VO, removing...");
                        pvtDiscountHeaderRow.remove();
                    }
                    Row discountHeaderRow = pvtDiscountHeaderVO.createRow();
                    pvtDiscountHeaderVO.insertRow(discountHeaderRow);
                    
                    getContraFeeOption().setId("PercentageDiscount");
                    getContraFeeEntered().setValue(null);
                    getPvTDiscountSearchResultsPanel().setRendered(false);
                } 
            }
            
        }
        return null;
    }
    
    public String validateSubmitData() {
        String result = "Pass";
    
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
        ViewObject pvtDiscountHeaderVO = dcIteratorBinding.getViewObject();
        PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
        if (pvtDiscountHeaderRow != null) {
            Object promoEffectiveDateFrom = pvtDiscountHeaderRow.getPromoeffectivedatefrom();
            System.out.println("Effective Date From..." + promoEffectiveDateFrom);
            if(promoEffectiveDateFrom == null || promoEffectiveDateFrom.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("44",lngCode)));    
                result = "fail";    
            }
            
            Object promoEffectiveDateTo = pvtDiscountHeaderRow.getPromoeffectivedateTo();
            System.out.println("Effective Date To..." + promoEffectiveDateTo);
            if(promoEffectiveDateTo == null || promoEffectiveDateTo.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("45",lngCode)));    
                result = "fail";    
            }
            
            if (promoEffectiveDateFrom != null && promoEffectiveDateTo != null) {
                java.sql.Date Promoeffectivedatefrom = new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedatefrom().getTime());
                java.sql.Date PromoeffectivedateTo = new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedateTo().getTime());
                if (Promoeffectivedatefrom.after(PromoeffectivedateTo)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("222",lngCode)));    
                    result = "fail";    
                }  
            }
            if(promoEffectiveDateFrom != null) 
            {
                java.sql.Date Promoeffectivedatefrom = new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedatefrom().getTime());
                java.sql.Date PromoeffectivedateTo = new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedateTo().getTime());
                 java.sql.Date sqlDate =
                    new java.sql.Date(new java.util.Date().getTime());
                 System.out.println(Promoeffectivedatefrom);
                System.out.println(sqlDate);
                String PromoeffectivedatefromStr = Promoeffectivedatefrom.toString();
                String sqlDatefromstr = sqlDate.toString();
                String PromoeffectivedateTostr = PromoeffectivedateTo.toString();
                 if(PromoeffectivedatefromStr.compareToIgnoreCase(sqlDatefromstr) == 0) {
                     System.out.println(sqlDate);
                 }
                 else if(Promoeffectivedatefrom.before(sqlDate)) {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Promo Effective Start Date should not be before current date",null));    
                     result = "fail";   
                     
                 }
                if(PromoeffectivedateTostr.compareToIgnoreCase(sqlDatefromstr) == 0) {
                    
                }
                else if(PromoeffectivedateTo.before(sqlDate)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Promo Effective End Date should not be before current date",null));    
                    result = "fail";   
                    
                }
                
            }
        }
        return result;
    }

    public String PVTResultsCancelAction() {
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclDetailVO1Iterator");
        ViewObject pvtDiscountDetailsVO = dcIteratorBinding.getViewObject();
        pvtDiscountDetailsVO.clearCache();
        PVTDiscCnclDetailVORowImpl pvtDiscountDetailRow = (PVTDiscCnclDetailVORowImpl)pvtDiscountDetailsVO.getCurrentRow();
        if (pvtDiscountDetailRow != null) {
            System.out.println("Row exists in pvt detail VO, removing...");
            pvtDiscountDetailRow.remove();
        }
        getPvTDiscountSearchResultsPanel().setRendered(false);
        return null;
    }

    public String PVTResultsRecalculateAction() {
        return null;
    }

    public void setPvTDiscountSearchResultsPanel(RichPanelGroupLayout pvTDiscountSearchResultsPanel) {
        this.pvTDiscountSearchResultsPanel = pvTDiscountSearchResultsPanel;
    }

    public RichPanelGroupLayout getPvTDiscountSearchResultsPanel() {
        return pvTDiscountSearchResultsPanel;
    }
    
    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHide() {
        return hide = "false";
    }
}
