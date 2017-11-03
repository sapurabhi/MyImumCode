package com.imum.cpms.transactions.pvt;

import com.imum.cpms.model.transactions.vo.CreChqTrnValVerUVORowImpl;
import com.imum.cpms.model.transactions.vo.InvDetailUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscCnclDetailVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscCnclHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscCnclHeaderVORowImpl;

import com.imum.cpms.model.transactions.vo.PVTDiscountHeaderSearchVORowImpl;
import com.imum.cpms.util.MessageUtil;

import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessPortType;
import com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessService;

import java.math.BigDecimal;

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
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class BulkPVtcancellationMB {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    String lngCode = "";
    private String hide;
    MessageUtil genMsg = new MessageUtil();
    private RichTable searchResultsTbl;
    private RichPanelGroupLayout pvTDiscountSearchResultsPanel;
    private RichSelectOneChoice foreignVehFlag;
    private RichInputText pvtnum;

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public BulkPVtcancellationMB() {
        if(lngCode==null || lngCode.equals(""))
            {
             lngCode = "EN";
            }
    }
    @WebServiceRef
    private static BulkDiscountApprovalBPMProcessService bulkDiscountApprovalBPMProcessService;


    public String pvtsearch_action() {
        // Add event code here...
        String foreignVehFlag1="";
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
                    if(pvtDiscountHeaderRow.getPlateCountry() != null)
                        PlateCountry = Integer.parseInt(pvtDiscountHeaderRow.getPlateCountry().toString());
                    System.out.println("Plate Type..." + pvtDiscountHeaderRow.getPlateType());
                    if (pvtDiscountHeaderRow.getPlateType() != null) {
                        plateType = Integer.parseInt(pvtDiscountHeaderRow.getPlateType().toString());
                        discountSearchWhereClause = discountSearchWhereClause + " AND Plate_Id IN (select plate_id from veh_plate_mst where PLATE_CTG_ID="+plateCategory+" and plate_type_id="+plateType+" and plate_cnt_id="+PlateCountry+" and Country_Code='ARE')";
                    }
                } else {
                    if (pvtDiscountHeaderRow.getPlateType() != null) {
                        pvtDiscountHeaderRow.setPlateType(null);
                    }
                }
                
                System.out.println("Plate Number..." + pvtDiscountHeaderRow.getPlateNumber());
                if (pvtDiscountHeaderRow.getPlateNumber() != null) {
                    plateNumber = pvtDiscountHeaderRow.getPlateNumber().toString();
                   
                    System.out.println(foreignVehFlag1);
                        
                    discountSearchWhereClause = discountSearchWhereClause + " AND Request_log_seq IN (select request_log_seq from pvt_hhc_request_log where plate_number like '%"+plateNumber+"%')";
                }
                
                
               // BigDecimal ContraFeeEntered = new BigDecimal(getContraFeeEntered().getValue().toString());
              //  System.out.println("Contra fee entered for discount..." + ContraFeeEntered);
                
                DCIteratorBinding discountSearchItterator = bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator");
                ViewObjectImpl discountSearchVO = (ViewObjectImpl)discountSearchItterator.getViewObject(); 
                if(foreignVehFlag.getValue()!=null)
                {
                    
                     foreignVehFlag1 =foreignVehFlag.getValue().toString();
                     if(foreignVehFlag1.equals("0"))
                         foreignVehFlag1 = "Y";
                     else if(foreignVehFlag1.equals("1"))
                        foreignVehFlag1 = "N";
                     
                         
                    
                discountSearchVO.refreshWhereClauseParams();
                discountSearchVO.setWhereClause(discountSearchWhereClause + " and pvt_status_id=1 and foreign_veh_flag ='"+foreignVehFlag1+"'");
                }
                
             
               
                
                else {
                    discountSearchVO.refreshWhereClauseParams();
                    discountSearchVO.setWhereClause(discountSearchWhereClause + " and pvt_status_id=1");
                }
                
                
                //pvt number serach
                if(pvtnum.getValue()!=null)
                {
                discountSearchVO.refreshWhereClauseParams();
                discountSearchVO.setWhereClause(discountSearchWhereClause + "and PVT_Num ='"+pvtnum.getValue()+"'");
                }
                
                System.out.println("Search query..." + discountSearchVO.getQuery());
                
                
                
                
                discountSearchVO.executeQuery();
                //System.out.println("Count of search results rows..." + discountSearchVO.getRowCount());
                
//                ADFContext.getCurrent().getPageFlowScope().put("TotalPVTs", discountSearchVO.getRowCount());
//                
//                // Calculating discount based on criteria
//                
//                BigDecimal PVTAmountAfterDiscount = null;
//                BigDecimal DiscountedContraFee = null;
//                BigDecimal ContraFeeAfterDiscount = null;
//                
//                //String contraOptionSelected = getContraFeeOption().getValue().toString();
//                //System.out.println("Contra Option Selected..." + contraOptionSelected);
//                
//                
//                BigDecimal TotalPVTAmountPayable = new BigDecimal("0.00");
//                BigDecimal TotalPVTAmountAfterDiscount = new BigDecimal("0.00");
//                BigDecimal TotalContraAmt = new BigDecimal("0.00");
//                BigDecimal TotalDiscountedContraFee = new BigDecimal("0.00");
//                BigDecimal TotalContraFeeAfterDiscount = new BigDecimal("0.00");
//                
//                if (discountSearchVO != null) {
//                    RowSetIterator searchResultsIterator = discountSearchVO.createRowSetIterator(null);
//                    while (searchResultsIterator.hasNext()) { 
//                        Row discountSearchRow = searchResultsIterator.next();
//                        BigDecimal PVTAMTPAYABLE = (BigDecimal)discountSearchRow.getAttribute("PVTAMTPAYABLE");
//                        
//                        TotalPVTAmountPayable = TotalPVTAmountPayable.add(PVTAMTPAYABLE);
//        //                        System.out.println("PVTAMTPAYABLE..." + PVTAMTPAYABLE);
//        //                        System.out.println("TotalPVTAmountPayable..." + TotalPVTAmountPayable);
//                            
//                        BigDecimal CONTRAAMT = (BigDecimal)discountSearchRow.getAttribute("CONTRAAMT");
//                        
//                        TotalContraAmt = TotalContraAmt.add(CONTRAAMT);
//        //                        System.out.println("CONTRAAMT..." + CONTRAAMT);
//        //                        System.out.println("TotalContraAmt..." + TotalContraAmt);
//                        
//                        BigDecimal zeroCompare = new BigDecimal("0.0000");
//                        
//                        if (!PVTAMTPAYABLE.stripTrailingZeros().equals(zeroCompare.stripTrailingZeros())) {
//                                
//                            
//                            if (DiscountedContraFee.toString().contains("-")) {
//                                DiscountedContraFee = zeroCompare;
//                            }
//                            if (ContraFeeAfterDiscount.toString().contains("-")) {
//                                ContraFeeAfterDiscount = zeroCompare;
//                            }
//                            if (PVTAmountAfterDiscount.toString().contains("-")) {
//                                PVTAmountAfterDiscount = zeroCompare;
//                            }
//                            
//                            discountSearchRow.setAttribute("PVTAmountAfterDiscount", PVTAmountAfterDiscount);
//                            TotalPVTAmountAfterDiscount = TotalPVTAmountAfterDiscount.add(PVTAmountAfterDiscount);
//                            discountSearchRow.setAttribute("DiscountedContraFee", DiscountedContraFee);
//                            TotalDiscountedContraFee = TotalDiscountedContraFee.add(DiscountedContraFee);
//                            discountSearchRow.setAttribute("ContraFeeAfterDiscount", ContraFeeAfterDiscount);
//                            TotalContraFeeAfterDiscount = TotalContraFeeAfterDiscount.add(ContraFeeAfterDiscount);
//                        } else {
//                            discountSearchRow.setAttribute("PVTAmountAfterDiscount", new BigDecimal("0.00"));
//                            discountSearchRow.setAttribute("DiscountedContraFee", new BigDecimal("0.00"));
//                            discountSearchRow.setAttribute("ContraFeeAfterDiscount", new BigDecimal("0.00"));
//                        }
//                    }
//                    
//                    ADFContext.getCurrent().getPageFlowScope().put("TotalPVTAmountPayable", TotalPVTAmountPayable);
//                    ADFContext.getCurrent().getPageFlowScope().put("TotalPVTAmountAfterDiscount", TotalPVTAmountAfterDiscount);
//                    ADFContext.getCurrent().getPageFlowScope().put("TotalContraAmt", TotalContraAmt);
//                    ADFContext.getCurrent().getPageFlowScope().put("TotalDiscountedContraFee", TotalDiscountedContraFee);
//                    ADFContext.getCurrent().getPageFlowScope().put("TotalContraFeeAfterDiscount", TotalContraFeeAfterDiscount);
//                    
//                }
//                
       
                               
                if (discountSearchVO.getRowCount() != 0) {
                System.out.println("-------");
                    getPvTDiscountSearchResultsPanel().setRendered(true);
                    getSearchResultsTbl().setRendered(true);
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("28",lngCode)));    
                    getPvTDiscountSearchResultsPanel().setRendered(false);
                    System.out.println("------");
                }
                    
            }
        }
        System.out.println(result);
        
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchResultsTbl);
        return null;
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
        
       getPvTDiscountSearchResultsPanel().setRendered(false);
        
        return null;
    }

  
    public String validateSubmitData() {
        String result = "Pass";
//        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclHeaderVO1Iterator");
//        ViewObject pvtDiscountHeaderVO = dcIteratorBinding.getViewObject();
//        PVTDiscCnclHeaderVORowImpl pvtDiscountHeaderRow = (PVTDiscCnclHeaderVORowImpl)pvtDiscountHeaderVO.getCurrentRow();
//        if (pvtDiscountHeaderRow != null) {
//            Object promoEffectiveDateFrom = pvtDiscountHeaderRow.getPromoeffectivedatefrom();
//            System.out.println("Effective Date From..." + promoEffectiveDateFrom);
//            if(promoEffectiveDateFrom == null || promoEffectiveDateFrom.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("44",lngCode)));    
//                result = "fail";    
//            }
//            Object promoEffectiveDateTo = pvtDiscountHeaderRow.getPromoeffectivedateTo();
//            System.out.println("Effective Date To..." + promoEffectiveDateTo);
//            if(promoEffectiveDateTo == null || promoEffectiveDateTo.equals("")) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("45",lngCode)));    
//                result = "fail";    
//            }
//            
//            if (promoEffectiveDateFrom != null && promoEffectiveDateTo != null) {
//                java.sql.Date Promoeffectivedatefrom = new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedatefrom().getTime());
//                java.sql.Date PromoeffectivedateTo = new java.sql.Date(pvtDiscountHeaderRow.getPromoeffectivedateTo().getTime());
//                if (Promoeffectivedatefrom.after(PromoeffectivedateTo)) {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("222",lngCode)));    
//                    result = "fail";    
//                }  
//            }
//        }
        return result;
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
            
            
      
        }
        return result;   
    }


    public String SubmitAction() {
        // Add event code here...
        String result = validateSubmitData();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        
        if (result.equalsIgnoreCase("Pass"))
        {
            String userName =null;
            if (httpSession.getAttribute("loggedinUserid") == null || httpSession.getAttribute("loggedinUserid").equals("")) {                
                userName = "anonymous";
            } else {
                userName = httpSession.getAttribute("loggedinUserid").toString();
            }
            OperationBinding operationBindings = bindings.getOperationBinding("addPVTCancelHeaderData");
            operationBindings.getParamsMap().put("userid", userName);
            operationBindings.execute();
      
      
      
      
        int count = searchResultsTbl.getRowCount();
        System.out.println("count in removeUnselectedRow : "+count);
        if(count>0)
        {
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();    
            if(invDetailVO != null)
            {
                Row selectionRowN[] = invDetailVO.getFilteredRows("SelectFlag",true);
                if(selectionRowN.length==0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("324", lngCode)));  
                }
                else {
                    
                    Integer selectCountN = selectionRowN.length;
                    for(int i = 0;i<selectCountN;i++) {
//                        Object attribute = selectionRowN[i].getAttribute("PVTNum");
//                        System.out.println("attribute"+attribute);
            DCIteratorBinding discountSearchItterator = bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator1");
            ViewObjectImpl discountSearchVO = (ViewObjectImpl)discountSearchItterator.getViewObject(); 
            
            DCIteratorBinding discountDetailBinding = bindingsAM.findIteratorBinding("PVTDiscCnclDetailVO1Iterator");
            ViewObject pvtDiscountDetailVO = discountDetailBinding.getViewObject();
          //  System.out.println("Discount search results row count..." + discountSearchVO.getRowCount());
               // PVTDiscountHeaderSearchVORowImpl pvtDiscountHeaderSearchVORow = (PVTDiscountHeaderSearchVORowImpl)discountSearchVO.getRowSet().getRowAtRangeIndex(i);
                        
               RowSetIterator rs1 = discountSearchVO.createRowSetIterator(null);
               rs1.reset();

               System.out.println(invDetailVO.getEstimatedRowCount());
                  
                       
                        
//        PVTDiscountHeaderSearchVORowImpl pvtDiscountHeaderSearchVORow =(PVTDiscountHeaderSearchVORowImpl)discountSearchVO.getRowAtRangeIndex(i);
//               if (pvtDiscountHeaderSearchVORow != null) {
                    Row discountDetailRow = pvtDiscountDetailVO.createRow();
              //      discountDetailRow.setAttribute("DISCCNCLhdrSeq", Integer.parseInt(pvtLastDiscountHeaderRow.getDISCCNCLhdrSeq().toString())+1);
                    discountDetailRow.setAttribute("DISCCNCLhdrSeq", 0);
                    System.out.println( selectionRowN[i].getAttribute("PVTHDRSEQ"));
                    discountDetailRow.setAttribute("PVTHDRSEQ",selectionRowN[i].getAttribute("PVTHDRSEQ"));
                    System.out.println(selectionRowN[i].getAttribute("CONTRAAMT"));
                  discountDetailRow.setAttribute("ORGCONTRAAMT", selectionRowN[i].getAttribute("CONTRAAMT"));
//                    discountDetailRow.setAttribute("COMPDISCONCONTRAAMT", pvtDiscountHeaderSearchVORow.getDiscountedContraFee());
//                    discountDetailRow.setAttribute("PVTAMTPAYABLE", pvtDiscountHeaderSearchVORow.getPVTAmountAfterDiscount());
                    discountDetailRow.setAttribute("Approvedflag", "N");
                    discountDetailRow.setAttribute("CreatedBy", userName);
                    discountDetailRow.setAttribute("CreatedDate", sqlDate);                
              //      System.out.println("Inserting into discount detail row..." + searchRow);
                    pvtDiscountDetailVO.insertRow(discountDetailRow);
                    
                    DCBindingContainer AM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dccourt =AM.findIteratorBinding("PVTEventDetailsVO1Iterator");
                             ViewObject eventVO = dccourt.getViewObject();
                                if (eventVO != null) {
                                 Row eventRow = eventVO.createRow();
                                 eventRow.setAttribute("PVTHDRSEQ", selectionRowN[i].getAttribute("PVTHDRSEQ"));
                                // eventRow.setAttribute("Remarks",remarks);
                                 eventRow.setAttribute("EVENTID", "591");
                                 eventRow.setAttribute("EVENTDATE", sqlDate);
                                 eventRow.setAttribute("CreatedBy", userName);
                                 eventRow.setAttribute("CreatedDate", sqlDate);
                                 eventVO.insertRow(eventRow);

                             }
                    
                    
                    
                    
            //    }
           
                }
                    if (operationBindings.getErrors().isEmpty()) {
                        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
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
                           
                            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("323",lngCode) + PvtHeaderSeq));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("323",lngCode) + PvtHeaderSeq));

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
                            getPvTDiscountSearchResultsPanel().setRendered(false);
                         
                        } 
                    }
                    
               
                }
               
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("324", lngCode)));                    
        }
       
       
    }
        return null;
    }

    public void setSearchResultsTbl(RichTable searchResultsTbl) {
        this.searchResultsTbl = searchResultsTbl;
    }

    public RichTable getSearchResultsTbl() {
        return searchResultsTbl;
    }

    public void checkVc(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Boolean selectedValue =(Boolean)valueChangeEvent.getNewValue(); 
        if(selectedValue != null)
        {
        System.out.println(selectedValue);
        int index = searchResultsTbl.getRowIndex();
        FacesCtrlHierBinding listBinding2 =(FacesCtrlHierBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PVTDiscountHeaderSearchVO1");
        ViewObject vo = listBinding2.getViewObject();
//        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        DCIteratorBinding dcItterator =bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1");
//        ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();
//        
        //Setting Current Checkbox value to current row
     
      PVTDiscountHeaderSearchVORowImpl rowImpl = (PVTDiscountHeaderSearchVORowImpl)vo.getRowAtRangeIndex(index);
      if(rowImpl != null)
     rowImpl.setSelectFlag(selectedValue);
        
        }  
        
    }

    public String PVTResultsCancelAction() {
        // Add event code here...
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTDiscCnclDetailVO1Iterator");
        ViewObject pvtDiscountDetailsVO = dcIteratorBinding.getViewObject();
        pvtDiscountDetailsVO.clearCache();
        PVTDiscCnclDetailVORowImpl pvtDiscountDetailRow = (PVTDiscCnclDetailVORowImpl)pvtDiscountDetailsVO.getCurrentRow();
        if (pvtDiscountDetailRow != null) {
            System.out.println("Row exists in pvt detail VO, removing...");
            pvtDiscountDetailRow.remove();
        }
        getPvTDiscountSearchResultsPanel().setRendered(false);
     searchResultsTbl.getSelectedRowKeys().clear();
      
        return null;
    }

    public String generateReport() {
        FacesContext fctx = FacesContext.getCurrentInstance();
               ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);      
               // Invoke a java script method name called showConfPopup()' with two parameters, You can pass any value 
               erks.addScript(fctx, "loadMap('"+"54.37425"+"','"+"24.512689"+ "')");  
               

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

    public void setForeignVehFlag(RichSelectOneChoice foreignVehFlag) {
        this.foreignVehFlag = foreignVehFlag;
    }

    public RichSelectOneChoice getForeignVehFlag() {
        return foreignVehFlag;
    }

    public void setPvtnum(RichInputText pvtnum) {
        this.pvtnum = pvtnum;
    }

    public RichInputText getPvtnum() {
        return pvtnum;
    }
    
    
    public void buttonselect() {
        DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator1");
        ViewObjectImpl invDetailVO =(ViewObjectImpl)dcItterator.getViewObject();
        
    //        for (Row row = invDetailVO.first();row != null;row = invDetailVO.next()){
    //
    //            row.setAttribute("SelectFlag", true);
    //           // row.setAttribute("Ackstatusid",0);
    //        }
           
        int count = getSearchResultsTbl().getRowCount();
        if(count>0)
        {
                   System.out.println(getSearchResultsTbl().getRowCount());
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
            System.out.println(getSearchResultsTbl().getRowCount());
        }   
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter Atleast One Search Field Value", genMsg.getMessage("326",lngCode))); 
          //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please Enter Atleast One Search Field Value")); 
        }
        
    }
    
    
    
    public String deSelect() {
        DCIteratorBinding dcItterator = bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator");
        DCIteratorBinding dcItterator1 = bindingsAM.findIteratorBinding("PVTDiscountHeaderSearchVO1Iterator1");
        
        ViewObjectImpl invDetailVO =(ViewObjectImpl)dcItterator.getViewObject();
        ViewObjectImpl invDetailVO1 =(ViewObjectImpl)dcItterator1.getViewObject();
        int count = getSearchResultsTbl().getRowCount();
        
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
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchResultsTbl());
         
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter Atleast One Search Field Value", genMsg.getMessage("326",lngCode))); 
          
        }
       
        
       
        return null;
    }


    
   
}
