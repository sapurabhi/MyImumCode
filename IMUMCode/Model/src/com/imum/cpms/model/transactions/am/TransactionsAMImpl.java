package com.imum.cpms.model.transactions.am;


import com.imum.cpms.model.masters.vo.CardCtgMstRVOImpl;
import com.imum.cpms.model.masters.vo.ContraventionMstUVOImpl;
import com.imum.cpms.model.masters.vo.CustomerIndividualUVOImpl;
import com.imum.cpms.model.masters.vo.CustomerInstitutionVOImpl;
import com.imum.cpms.model.transactions.am.common.TransactionsAM;


import com.imum.cpms.model.transactions.vo.ActiveCardsUVOImpl;
import com.imum.cpms.model.transactions.vo.AuctionClosingVOImpl;
import com.imum.cpms.model.transactions.vo.AuctionEvaluationVOImpl;
import com.imum.cpms.model.transactions.vo.AuctionEvidenceDocVOImpl;
import com.imum.cpms.model.transactions.vo.BayNumberLVOImpl;
import com.imum.cpms.model.transactions.vo.BulkCardsInstVOImpl;

import com.imum.cpms.model.transactions.vo.CardIssueSrchCriVOImpl;

import com.imum.cpms.model.transactions.vo.CardIssueSrchCriVORowImpl;
import com.imum.cpms.model.transactions.vo.CardTypeMstUVOImpl;
import com.imum.cpms.model.transactions.vo.CardsInputFieldsVOImpl;

import com.imum.cpms.model.transactions.vo.CardsInputFieldsVORowImpl;
import com.imum.cpms.model.transactions.vo.CashRemarksVOImpl;
import com.imum.cpms.model.transactions.vo.ClampingUVOImpl;
import com.imum.cpms.model.transactions.vo.CreChqTrnValVerUVOImpl;
import com.imum.cpms.model.transactions.vo.DepositAckDetailsUVOImpl;
import com.imum.cpms.model.transactions.vo.DepositAckDetailsUVORowImpl;
import com.imum.cpms.model.transactions.vo.GenAccLogUVOImpl;
import com.imum.cpms.model.transactions.vo.InvCardInactivationdtlVOImpl;
import com.imum.cpms.model.transactions.vo.InventorySaleDetailsVOImpl;
import com.imum.cpms.model.transactions.vo.PILocationVOImpl;
import com.imum.cpms.model.transactions.vo.PIMonthlyDeploymentVOImpl;
import com.imum.cpms.model.transactions.vo.PVTAuctionSearchVOImpl;
import com.imum.cpms.model.transactions.vo.PVTBulkCancellationImpl;
import com.imum.cpms.model.transactions.vo.PVTCategorizedChargesRVOImpl;
import com.imum.cpms.model.transactions.vo.PVTDocsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTEnforceidVOImpl;
import com.imum.cpms.model.transactions.vo.PVTEventDetailsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTPoundCodevoImpl;
import com.imum.cpms.model.transactions.vo.PVTRollbackDiscountSearchVOImpl;
import com.imum.cpms.model.transactions.vo.PVTdissmsVOImpl;
import com.imum.cpms.model.transactions.vo.PaymentsINVOImpl;
import com.imum.cpms.model.transactions.vo.PaymentsTypesLOVVOImpl;
import com.imum.cpms.model.transactions.vo.PvtHeaderPaySuperVisorUVOImpl;
import com.imum.cpms.model.transactions.vo.InvDetailUVOImpl;
import com.imum.cpms.model.transactions.vo.InventoryStockUploadUVOImpl;
import com.imum.cpms.model.transactions.vo.IssReturnDtlUVOImpl;
import com.imum.cpms.model.transactions.vo.IssReturnHdrUVOImpl;
import com.imum.cpms.model.transactions.vo.IssReturnHdrUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscCnclDetailVOImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscCnclHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscountHeaderSearchVOImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscountHeaderSeqVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTIssuanceVOImpl;
import com.imum.cpms.model.transactions.vo.PVTSearchRVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTSearchRVOImpl;
import com.imum.cpms.model.transactions.vo.PVTTariffTypesLOVVOImpl;
import com.imum.cpms.model.transactions.vo.ParkingCardTypesUVOImpl;
import com.imum.cpms.model.transactions.vo.PVTChargeDetailRVOImpl;
import com.imum.cpms.model.transactions.vo.PVTDiscCnclHeaderVORowImpl;
import com.imum.cpms.model.transactions.vo.PlateTypeLOVVOImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVOImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVORowImpl;
import com.imum.cpms.model.transactions.vo.SaleReceiptDetailVOImpl;
import com.imum.cpms.model.transactions.vo.SalesDetailUVOImpl;

import com.imum.cpms.model.transactions.vo.SalesDetailUVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesHeaderUVOImpl;

import com.imum.cpms.model.transactions.vo.SalesHeaderUVORowImpl;
import com.imum.cpms.model.transactions.vo.SalesSettlementUVOImpl;

import com.imum.cpms.model.transactions.vo.SalesSettlementUVORowImpl;
import com.imum.cpms.model.transactions.vo.SectorforSupVOImpl;
import com.imum.cpms.model.transactions.vo.StckRetAckVOImpl;

import com.imum.cpms.model.transactions.vo.StockUploadErrorVOImpl;

import com.imum.cpms.model.transactions.vo.VehicleModelLOVVOImpl;

import com.imum.cpms.model.masters.vo.RemovalTruckMstVOImpl;
import com.imum.cpms.model.transactions.eo.ActiveCardsEOViewImpl;
import com.imum.cpms.model.transactions.vo.ActiveCardsUVORowImpl;
import com.imum.cpms.model.transactions.vo.AuctionEvidenceSearchVOImpl;
import com.imum.cpms.model.transactions.vo.AuctionInitiationViewVOImpl;
import com.imum.cpms.model.transactions.vo.CashRemarksVORowImpl;
import com.imum.cpms.model.transactions.vo.GenEventDetailsUVOImpl;
import com.imum.cpms.model.transactions.vo.PvtEnforceVehicleAssignRVOImpl;

import com.imum.cpms.model.transactions.vo.InvCardStatusLOVVOImpl;
import com.imum.cpms.model.transactions.vo.InvEventDetailsUVOImpl;
import com.imum.cpms.model.transactions.vo.InvEventDetailsUVORowImpl;
import com.imum.cpms.model.transactions.vo.InventoryEventDetailsVOImpl;
import com.imum.cpms.model.transactions.vo.InventorySaleAccDetailsVOImpl;
import com.imum.cpms.model.transactions.vo.InventorySearchCriteriaVOImpl;
import com.imum.cpms.model.transactions.vo.PVTAUCTIONHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTAUCTIONHeaderVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTAUCTIONPVTDETAILSVOImpl;
import com.imum.cpms.model.transactions.vo.PVTEnforceidVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTEventDetailsVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTHeadersmsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTPaymentLogUVOImpl;
import com.imum.cpms.model.transactions.vo.PVTPaymentLogUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTVehPoungLogUVOImpl;
import com.imum.cpms.model.transactions.vo.PVTVehPoungLogUVORowImpl;
import com.imum.cpms.model.transactions.vo.PermitEventUVOImpl;
import com.imum.cpms.model.transactions.vo.PermitEventUVORowImpl;
import com.imum.cpms.model.transactions.vo.TypeDenominationVOImpl;

import com.imum.cpms.model.transactions.vo.discountsearchVOImpl;
import com.imum.cpms.model.transactions.vo.pissupVOImpl;

import com.imum.cpms.model.transactions.vo.pisvoImpl;


import com.imum.cpms.model.transactions.vo.saleReceiptSettlVOImpl;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;


import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Timestamp;

import java.sql.Types;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.RowSetIterator;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.RowImpl;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 07 12:03:01 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TransactionsAMImpl extends ApplicationModuleImpl implements TransactionsAM {
    /**
     * This is the default constructor (do not remove).
     */
    public TransactionsAMImpl() {
    }
    private BigDecimal pvtHdrSeq;
    private String encoderforevent = null;
    


    /**
     * Rohini's code for PVT Amount Adjustable
     *
     * */
    
    public String PVTupdateAdjustmentAmt(BigDecimal pvtHdrSeq, BigDecimal PVTAdjAmount,String loggerName,String Operator){
    // insert record into charges table with -ve amount
    encoderforevent = loggerName;
    Timestamp sqlDate =
        new java.sql.Timestamp(new java.util.Date().getTime());
                       System.out.println("negative of adjustment amount : "+BigDecimal.ZERO.subtract(PVTAdjAmount));
        Row newRow = getPVTChargeDetailsVO1().createRow();
        newRow.setAttribute("PVTHDRSEQ", pvtHdrSeq);
        newRow.setAttribute("ChargeType", "5");
        
        if(Operator.equalsIgnoreCase("-"))
            newRow.setAttribute("ChargeAmount", BigDecimal.ZERO.subtract(PVTAdjAmount));
        else 
            newRow.setAttribute("ChargeAmount", PVTAdjAmount);
        
        newRow.setAttribute("ChargeDate", sqlDate);
        newRow.setAttribute("CreatedBy", loggerName);
        newRow.setAttribute("Updatedby", loggerName);
        getPVTChargeDetailsVO1().insertRow(newRow);
        

        // Update Payable Amount with the Charge.
    ViewObjectImpl PVTHeaderVO = getPVTHeaderVO1();
    PVTHeaderVO.applyViewCriteria(null);
    PVTHeaderVO.applyViewCriteria(PVTHeaderVO.getViewCriteria("GetByPvtHeaderSeq"));
    VariableValueManager evm = PVTHeaderVO.ensureVariableManager();
    evm.setVariableValue("BindPvtHdrSeq", pvtHdrSeq);
    PVTHeaderVO.executeQuery();
    BigDecimal PVTAMTPAYABLE = (BigDecimal)PVTHeaderVO.first().getAttribute("PVTAMTPAYABLE");
    System.out.println("Initial PVTAMTPAYABLE :"+PVTAMTPAYABLE);
    if(Operator.equalsIgnoreCase("-"))
        PVTAMTPAYABLE = PVTAMTPAYABLE.subtract(PVTAdjAmount);
    else 
        PVTAMTPAYABLE = PVTAMTPAYABLE.add(PVTAdjAmount);
    
        System.out.println("Final PVTAMTPAYABLE :"+PVTAMTPAYABLE);
        PVTHeaderVO.first().setAttribute("PVTAMTPAYABLE",PVTAMTPAYABLE);
        
        if(PVTAMTPAYABLE.compareTo(BigDecimal.ZERO)==0){
                Boolean PoundPayFlag = PVTHeaderVO.first().getAttribute("POUNDPAYFLAG") == null ?  false :(PVTHeaderVO.first().getAttribute("POUNDPAYFLAG").toString().equalsIgnoreCase("Y") ? true: false);
                Integer ENFORCESTAGEID = (Integer) PVTHeaderVO.first().getAttribute("ENFORCESTAGEID");
                    
                PVTHeaderVO.first().setAttribute("PVTSTAGEID",8);//fully paid
                if(!PoundPayFlag){
                    PVTHeaderVO.first().setAttribute("PVTStatusID",2);//closed
                    }
                else {
                    if( ENFORCESTAGEID==14 ){
                
                        PVTHeaderVO.first().setAttribute("PVTStatusID",2);//closed
                    }
                    }
                
            }
        
    
    return "";
    }
    
    public String getPVTForAmtAdjustment(String PVTNum) {

        ViewObjectImpl PVTSearchRVO = getPVTSearchRVO1();
        PVTSearchRVO.applyViewCriteria(null);
        PVTSearchRVO.applyViewCriteria(PVTSearchRVO.getViewCriteria("getByPVTNum"));
        VariableValueManager evm = PVTSearchRVO.ensureVariableManager();
        evm.setVariableValue("bindPVTNumber", PVTNum);
        PVTSearchRVO.executeQuery();
        if (PVTSearchRVO.getEstimatedRowCount() > 0) {
            Row curRow = PVTSearchRVO.first();
            Integer Status =
                Integer.parseInt(curRow.getAttribute("PVTStatusID").toString());
//            if (Status == 1 || Status == 4) return "SUCCESS";
            if (Status == 1 ) return "SUCCESS";
            else if (Status == 2) return "CLOSED";
            else if (Status == 4) return "ONHOLD";
            else return "CANCELLED";

        } else return "EMPTY";
    }
    
    public Boolean CreateEvent(BigDecimal pvtHeaderSeq,
                                            String loggerName, String remarks,String EventId
                                            ){
        try{
            PVTEventDetailsVOImpl pvtEventVO = getPVTEventDetailsVO1();
            Timestamp sqlDate =
                new java.sql.Timestamp(new java.util.Date().getTime());
            Row pvtEventRow = pvtEventVO.createRow();
            pvtEventRow.setAttribute("PVTHDRSEQ", pvtHeaderSeq);
            pvtEventRow.setAttribute("Remarks",remarks);
            pvtEventRow.setAttribute("EVENTID", EventId);
            pvtEventRow.setAttribute("EVENTDATE", sqlDate);
            pvtEventRow.setAttribute("CreatedBy", loggerName);
            pvtEventRow.setAttribute("CreatedDate", sqlDate);
            pvtEventVO.insertRow(pvtEventRow);
            PVTVehPoungLogUVOImpl pvtvehlogVO = (PVTVehPoungLogUVOImpl) this.getPVTVehPoungLogUVO1(); 
            if(pvtvehlogVO != null)
            {
                pvtvehlogVO.setWhereClause(null);
                pvtvehlogVO.setWhereClause("PVT_HDR_SEQ = " + pvtHeaderSeq);
                pvtvehlogVO.executeQuery();
                PVTVehPoungLogUVORowImpl poundcodevoRow = (PVTVehPoungLogUVORowImpl)pvtvehlogVO.first(); 
                poundcodevoRow.setRELEASEDATE(sqlDate);
                poundcodevoRow.setUpdatedby(loggerName);
                poundcodevoRow.setupdateddate(sqlDate);
                
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
            }
        return true;
            
        }


/** Rohini's Code for PVT Details Row*/
public Long getPVTCountForVehicle(String PVTNum){
    
        ViewObjectImpl PVTSearchRVO = getPVTSearchRVO2();
        PVTSearchRVO.applyViewCriteria(null);
        PVTSearchRVO.applyViewCriteria(PVTSearchRVO.getViewCriteria("getByPVTNum"));
        VariableValueManager evm= PVTSearchRVO.ensureVariableManager();
        evm.setVariableValue("bindPVTNumber", PVTNum);
        PVTSearchRVO.executeQuery();
        
        Row currentPVTRow = PVTSearchRVO.first();
        String PlateId = currentPVTRow.getAttribute("PlateId").toString();
        
        
        getPVTHeaderVO1().setWhereClause("PVTHeaderEO.Plate_Id = '"+PlateId+"'");
        getPVTHeaderVO1().executeQuery();
        
        
        
    
    System.out.println("count of PVTs associated :"+getPVTHeaderVO1().getEstimatedRowCount());
        return getPVTHeaderVO1().getEstimatedRowCount();
        
    }
public Boolean getPVTDetails(String PVTNum){

        /* For PVT Search VO */
        ViewObjectImpl PVTSearchRVO = getPVTSearchRVO2();
        PVTSearchRVO.applyViewCriteria(null);
        PVTSearchRVO.applyViewCriteria(PVTSearchRVO.getViewCriteria("getByPVTNum"));
        VariableValueManager evm= PVTSearchRVO.ensureVariableManager();
        evm.setVariableValue("bindPVTNumber", PVTNum);
        PVTSearchRVO.executeQuery();
        PVTSearchRVO.applyViewCriteria(null);
        
        Row currentPVTRow = PVTSearchRVO.first();
        BigDecimal PvtHeaderSeq = (BigDecimal) currentPVTRow.getAttribute("PVTHDRSEQ");
        BigDecimal ObsrvSeq = (BigDecimal) currentPVTRow.getAttribute("Obsrvseq");//Obsrvseq //Obsrv_seq
       // BigDecimal CustomerId = (BigDecimal) currentPVTRow.getAttribute("CustID");
        BigDecimal VehCustomerId = (BigDecimal) currentPVTRow.getAttribute("VehCustId");
        
        
        
        /*  VOs to set
         * PVTEventVO - Waiting for DB Changes from PVT_Num to PVTHdrSeq
         * ChargesVO
         * VehicleDetailsVO
         * PI Name VO - PIUserLovVO
         * PVTObservationVO - PVT_Observation
         * SLT_Sale_Detail VO - receipt - Waiting for DB Changes from PVT_Num to PVTHdrSeq
         * PhotoVO(DocumentVO with fileType as Photoes) - Done
         * DocumentVO - Done
         * CustomerVO, 
         * InstitutionVO,
         * ChargesVO
         * */
        
        /* For Documents VO  */
        getPVTDocsVO1().applyViewCriteria(null);
        getPVTDocsVO1().applyViewCriteria(getPVTDocsVO1().getViewCriteria("GetByPvtHdrSeqDocsOnly")); /* GetByPvtHdrSeq */
        VariableValueManager evm1= getPVTDocsVO1().ensureVariableManager();
        evm1.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPVTDocsVO1().executeQuery();
        
        /* For Photo VO  */
        getPVTPhotoRVO1().applyViewCriteria(null);
        getPVTPhotoRVO1().applyViewCriteria(getPVTPhotoRVO1().getViewCriteria("GetByPvtHeaderSeq"));
        VariableValueManager evm2= getPVTPhotoRVO1().ensureVariableManager();
        evm2.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPVTPhotoRVO1().executeQuery();
        
        /* For Observation VO */
        getPVTObservationRVO1().applyViewCriteria(null);
        getPVTObservationRVO1().applyViewCriteria(getPVTObservationRVO1().getViewCriteria("GetByObservationSeq"));
        VariableValueManager evm3= getPVTObservationRVO1().ensureVariableManager();
        evm3.setVariableValue("BindObsrvSeq", ObsrvSeq);
        getPVTObservationRVO1().executeQuery();
        
        /* For Customer  */
        System.out.println("Cust Id  is"+VehCustomerId);
        ViewObjectImpl CustIndiDetailsVO =getCustomerIndividualUVO1();
        CustIndiDetailsVO.setWhereClause(null);
        CustIndiDetailsVO.setWhereClause("Cust_ID = "+VehCustomerId);
        CustIndiDetailsVO.executeQuery();
        
        System.out.println("Cus Id from Bean"+VehCustomerId);
        ViewObjectImpl CustInstDetailsVO =getCustomerInstitutionVO1();
        CustInstDetailsVO.setWhereClause(null);
        CustInstDetailsVO.setWhereClause("INST_ID = "+VehCustomerId);
        CustInstDetailsVO.executeQuery();
                
        /* For Charges VO */
//        getPVTCategorizedChargesRVO1()
        getPVTCategorizedChargesRVO1().applyViewCriteria(null);
        getPVTCategorizedChargesRVO1().applyViewCriteria(getPVTCategorizedChargesRVO1().getViewCriteria("GetByPvtHeaderSeq"));
        VariableValueManager evm4= getPVTCategorizedChargesRVO1().ensureVariableManager();
        evm4.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPVTCategorizedChargesRVO1().executeQuery();
                
        /* For Photo VO  */
//        getPVTReceiptRVO1()
        getPVTReceiptRVO1().applyViewCriteria(null);
        getPVTReceiptRVO1().applyViewCriteria(getPVTReceiptRVO1().getViewCriteria("GetByPvtHeaderSeq"));
        VariableValueManager evm5= getPVTReceiptRVO1().ensureVariableManager();
        evm5.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPVTReceiptRVO1().executeQuery();
        
        /* For Appeals Info*/
        getPVTAppealDetailsRVO1().applyViewCriteria(null);
        
        getPVTAppealDetailsRVO1().applyViewCriteria(getPVTAppealDetailsRVO1().getViewCriteria("GetByPvtHeaderSeq"));
        VariableValueManager evm6= getPVTAppealDetailsRVO1().ensureVariableManager();
        evm6.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPVTAppealDetailsRVO1().executeQuery();
        
        /* For Pound Bay Details */
//        getPoundBayDetailVO1()
        getPoundBayDetailVO1().applyViewCriteria(null);
        getPoundBayDetailVO1().applyViewCriteria(getPoundBayDetailVO1().getViewCriteria("GetByPvtHeaderSeq"));
        VariableValueManager evm7= getPoundBayDetailVO1().ensureVariableManager();
        evm7.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPoundBayDetailVO1().executeQuery();

        /* For Event History VO  */
//        getPVTEventHistoryRVO1()
        getPVTEventHistoryRVO1().applyViewCriteria(null);
        getPVTEventHistoryRVO1().applyViewCriteria(getPVTEventHistoryRVO1().getViewCriteria("GetByPvtHdrSeq"));
        VariableValueManager evm8= getPVTEventHistoryRVO1().ensureVariableManager();
        evm8.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPVTEventHistoryRVO1().executeQuery();
        
        //PVT Account Entries
        getPVTAccEntriesRVO1().applyViewCriteria(null);
        getPVTAccEntriesRVO1().applyViewCriteria(getPVTAccEntriesRVO1().getViewCriteria("GetByPvtHeaderSeq"));
        VariableValueManager evm9= getPVTAccEntriesRVO1().ensureVariableManager();
        evm9.setVariableValue("BindPvtHdrSeq", PvtHeaderSeq);
        getPVTAccEntriesRVO1().executeQuery();
        System.out.println(getPVTAccEntriesRVO1().getQuery());

//        getPVTAccountEntries(PvtHeaderSeq);
        
            //PVT Hyper link Entries
           
           
            String PlateId = currentPVTRow.getAttribute("PlateId").toString();
            getPVTHyperLinkVO1().applyViewCriteria(null);
            getPVTHyperLinkVO1().applyViewCriteria(getPVTHyperLinkVO1().getViewCriteria("PVTHyperLinkVOCriteria"));
            VariableValueManager evm10= getPVTHyperLinkVO1().ensureVariableManager();
            evm10.setVariableValue("BindPvtHdrSeq", PlateId);
            getPVTHyperLinkVO1().executeQuery();
            System.out.println(getPVTHyperLinkVO1().getQuery());
            
            /**/
        

        return Boolean.TRUE;
    }


    public void searchCritRow()
    {
        CardIssueSrchCriVOImpl vo = this.getCardIssueSrchCriVO1();
        if(vo != null)
        {
            Row row = vo.createRow(); 
            vo.insertRow(row);
        }
    }
    
    public void commit() {
        getDBTransaction().commit();
    }
    
        public Boolean doCommit(){
            try{
            getDBTransaction().commit();
                return true;
            }catch(Exception e){
                e.printStackTrace();
                return false;
                }
            }
        
        
        public Boolean doRollback(){
            try{
            getDBTransaction().rollback();
            }catch(Exception e){
                System.out.println("Rollback failed");
                e.printStackTrace();
                return false;
                }
            return true;
            }

        /**
         *Subiksha - Deposit Ack Details
         * @param encoder
         */
        public void createNewDepAckDtls(String encoder)
        {
           DepositAckDetailsUVOImpl vo = (DepositAckDetailsUVOImpl)this.getDepositAckDetailsUVO1();
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());    
            if(vo != null)
            {
                Row depAckRow = vo.createRow();   
                depAckRow.setAttribute("CreatedBy",encoder);
                depAckRow.setAttribute("CreatedDate",sqlDate);
                vo.insertRow(depAckRow);    
            }    
        }

        public String CreateGenEventDetails(BigDecimal depositAckSeqbigD,String NewDepSlip,String OldDepSlip,String encoder,Integer EventId) 
        {
            BigDecimal depAckSlip = null;
            GenEventDetailsUVOImpl vo = (GenEventDetailsUVOImpl)this.getGenEventDetailsUVO1();
            DepositAckDetailsUVOImpl Depvo = (DepositAckDetailsUVOImpl)this.getDepositAckDetailsUVO1();
            DepositAckDetailsUVORowImpl DepRow = (DepositAckDetailsUVORowImpl)Depvo.first();
            if(DepRow != null) {
                depAckSlip = DepRow.getDepositAckSeq();
            }
             java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());    
             if(vo != null)
             {
                 Row EventRow = vo.createRow();   
                 EventRow.setAttribute("CreatedBy",encoder);
                 EventRow.setAttribute("CreatedDate",sqlDate);
                 EventRow.setAttribute("GENHeaderseq",depositAckSeqbigD);
                 EventRow.setAttribute("EVENTID",EventId );
                 EventRow.setAttribute("EVENTDATE",sqlDate);
                 if(EventId == 701)
                 EventRow.setAttribute("Remarks"," old Deposit Number is: '"+OldDepSlip+"' New Depost Number is:" +NewDepSlip);
                 if(EventId == 633)
                     EventRow.setAttribute("Remarks"," Remarks for inactivating card: '"+NewDepSlip+"' ");
                 EventRow.setAttribute("EventAmt",0);
                 EventRow.setAttribute("BalanceAmt",0);
                 
                 vo.insertRow(EventRow);    
             }    
         return null;   
        }
     

        public Boolean fetchExpectedAmt(String tranDate, String locId,Date transdateformat )
        {
            Boolean result = true;
         
            DepositAckDetailsUVOImpl vo = (DepositAckDetailsUVOImpl)this.getDepositAckDetailsUVO1();
            DepositAckDetailsUVORowImpl row = (DepositAckDetailsUVORowImpl)vo.first();
           //getCurrentRow();
    
    
        if(row != null)
            {
            String depositslipnum = null;
             //   Object locId = row.getLOCATIONID();
//                Object tranDates = row.getSaleTrnDate();
                System.out.println("Loc Id in fectExpectedAmt AM is : "+locId+" and Sale Tran Date is : "+tranDate);
                if(locId != null && tranDate != null)
                {
                    PreparedStatement preparedStatement = null;
                    try {
                        String sql = "select sum(pymt_amt)expected_amt from gen_day_end_settl_details where pymt_type in ('CSH','CHQ') and trn_date = '"+tranDate+"' and csc_loc_id = "+locId;
                        preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);                   
                        ResultSet rs =  preparedStatement.executeQuery();//preparedStatement.getResultSet();
                                       CashRemarksVOImpl remarksvo = this.getCashRemarksVO1();
                        if(remarksvo!=null) {
                            remarksvo.setWhereClause(null);
                            remarksvo.setWhereClauseParams(null);
                          //  remarksvo.setWhereClause("Trans_Date ='"+transdateformat+"'");
                            if(transdateformat!=null)
                            {
                          remarksvo.setWhereClause("Trans_Date ='"+transdateformat+"'");
                            System.out.println(transdateformat);
                            remarksvo.executeQuery();
                            int count = remarksvo.getRowCount();
                            CashRemarksVORowImpl rowremarks= (CashRemarksVORowImpl)remarksvo.first(); 
                            if(rowremarks != null)
                            {
                            String remarks = rowremarks.getDepositSlip();
                            ADFContext.getCurrent().getPageFlowScope().put("Remarks",remarks);
                            }
                            }
                        }
                       
                        
                       
                        
                        if(rs != null )
                        {
                            while(rs.next())
                            {
                                BigDecimal expAmt = rs.getBigDecimal("expected_amt");
                                if(expAmt != null)
                                {
                                    row.setExpectedAmt(expAmt);   
                                    
                                }
                                else
                                {
                                    row.setExpectedAmt(null);
                                    result = false;    
                                }
                            }                                                
                        }
                        else
                        {
                            row.setExpectedAmt(null);
                            result = false;         
                        }                        
                    }  catch (Exception e) {
                        System.out.println("fetchExpectedAmt exception : "+e.getMessage());
                    }
                }
            }
           return result;
            
        }
    public void getPiLocationCoordinates(String piid, String pidate) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks =
            Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
        //erks.addScript(fctx, "alert('" + piid + "');");
       // erks.addScript(fctx, "alert('" + pidate + "');");
      
       
        ViewObjectImpl loc1=(ViewObjectImpl)getPVTHeaderVO1();
//        loc1.setApplyViewCriteriaName("PVTHeaderVOCriteria");
//        loc1.setNamedWhereClauseParam("pilocpid",piid);
//        loc1.setNamedWhereClauseParam("issuedate",pidate);
        
        loc1.setWhereClause("PI_ID='"+piid+"'  AND convert(date, PVT_date_time)='"+pidate+"'");
        System.out.println("PVT Map Query is:::"+loc1.getQuery());
        loc1.executeQuery();
        
        //and issued_date='"+sqldate+"'
        RowSetIterator rsi1=loc1.createRowSetIterator(null);
              
        erks.addScript(fctx,"var long1 = [];");
        erks.addScript(fctx,"var lat1 = [];");
        erks.addScript(fctx,"var long = [];");
        erks.addScript(fctx,"var lat = [];");
        erks.addScript(fctx,"var timestamp = [];"); 
        erks.addScript(fctx,"var active = [];");
        
               while(rsi1.hasNext()) {
                  Row r=rsi1.next();
                // System.out.println(r.getAttribute("geolon"));
                //  System.out.println(r.getAttribute("geolat"));
                   System.out.println(r.getAttribute("PVTNum"));
                   System.out.println(r.getAttribute("PVTVHCLgeolon"));
                   System.out.println(r.getAttribute("PVTVHCLgeolat"));
                   
                 if(r.getAttribute("PVTVHCLgeolon")!=null) {
                        erks.addScript(fctx,"long1.push("+r.getAttribute("PVTVHCLgeolon").toString()+")");
                 }
                   if(r.getAttribute("PVTVHCLgeolat")!=null) {
                      erks.addScript(fctx,"lat1.push("+r.getAttribute("PVTVHCLgeolat").toString()+")");     
                   }
                      
        //                     erks.addScript(fctx1,"long1.push("+r.getAttribute("PVTVHCLgeolon").toString()+")");
        //                     erks.addScript(fctx1,"lat1.push("+r.getAttribute("PVTVHCLgeolat").toString()+")");
                                       
               //   erks.addScript(fctx,"long.push("+r.getAttribute("geolon").toString()+")");
               //   erks.addScript(fctx,"lat.push("+r.getAttribute("geolat").toString()+")");
              }

       
      //  erks.addScript(fctx,"loadMap(long1,lat1)");
        // erks.addScript(fctx1,"loadMap1()");
               if(piid!=null&&pidate!=null){
                   ViewObjectImpl loc=(ViewObjectImpl)getPVTHHCGPSTrackerVO1();
                   loc.setWhereClause("PI_ID='"+piid+"'  AND convert(date, curr_date_time)='"+pidate+"'");
                   /* loc.setApplyViewCriteriaName("PILocationVOCriteria");
                   loc.setNamedWhereClauseParam("pilocpid",piid);
                   loc.setNamedWhereClauseParam("issuedate",pidate); */
                   System.out.println("locaton query is:"+loc.getQuery());
                   loc.executeQuery(); 
                   int rcnt=loc.getRowCount();
                   int mycnt=0;
                   RowSetIterator rsi=loc.createRowSetIterator(null);
                    
                   //        erks.addScript(fctx,"long.push(54.397360)");
                   //       erks.addScript(fctx,"lat.push(24.442093)");
                          /*  while(rsi.hasNext()) {
                              Row r=rsi.next();
                             System.out.println(r.getAttribute("geolon"));
                              System.out.println(r.getAttribute("geolat"));
                              erks.addScript(fctx,"long.push("+r.getAttribute("geolon").toString()+")");
                              erks.addScript(fctx,"lat.push("+r.getAttribute("geolat").toString()+")");
                          } */
                       while(rsi.hasNext()) { 
                           mycnt++;
                          Row r=rsi.next();
                          System.out.println(r.getAttribute("geolon"));
                          System.out.println(r.getAttribute("geolat")); 
                                        if(r.getAttribute("geolon")!=null && r.getAttribute("geolat")!=null) {
                                                   erks.addScript(fctx,"long.push('"+r.getAttribute("geolon").toString()+"')");
                                                   erks.addScript(fctx,"lat.push('"+r.getAttribute("geolat").toString()+"')"); 
                                                    if(r.getAttribute("currdatetime")!=null) {
                                                       erks.addScript(fctx,"timestamp.push('"+r.getAttribute("currdatetime").toString()+"')");
                                                    }  
                                                   else {
                                                     erks.addScript(fctx,"timestamp.push('')");
                                                     }
                                                    if(mycnt==1){
                                                        erks.addScript(fctx,"active.push('2')");   
                                                    }
                                                   else if(mycnt==rcnt){
                                                        erks.addScript(fctx,"active.push('1')");   
                                                    }
                                                    else{
                                                        erks.addScript(fctx,"active.push('0')");    
                                                    }
                                                    
                                        }
                             }
                        
               }
               
        else if(pidate!=null&&piid==null){
        ViewObjectImpl loc=(ViewObjectImpl)getPVTHHCGPSTrackerVO1();
        loc.setWhereClause("convert(date, curr_date_time)='"+pidate+"' ");
        /* loc.setApplyViewCriteriaName("PILocationVOCriteria");
        loc.setNamedWhereClauseParam("pilocpid",piid);
        loc.setNamedWhereClauseParam("issuedate",pidate); */
        System.out.println("locaton query is:"+loc.getQuery());
        loc.executeQuery();
            RowSetIterator rsi=loc.createRowSetIterator(null);
             
            //        erks.addScript(fctx,"long.push(54.397360)");
            //       erks.addScript(fctx,"lat.push(24.442093)");
                    /* while(rsi.hasNext()) {
                       Row r=rsi.next();
                      System.out.println(r.getAttribute("geolon"));
                       System.out.println(r.getAttribute("geolat"));
                       erks.addScript(fctx,"long.push("+r.getAttribute("geolon").toString()+")");
                       erks.addScript(fctx,"lat.push("+r.getAttribute("geolat").toString()+")");
                   } */
            while(rsi.hasNext()) { 
               Row r=rsi.next();
               System.out.println(r.getAttribute("geolon"));
               System.out.println(r.getAttribute("geolat")); 
                             if(r.getAttribute("geolon")!=null && r.getAttribute("geolat")!=null) {
                                        erks.addScript(fctx,"long.push('"+r.getAttribute("geolon").toString()+"')");
                                        erks.addScript(fctx,"lat.push('"+r.getAttribute("geolat").toString()+"')"); 
                                         if(r.getAttribute("currdatetime")!=null) {
                                            erks.addScript(fctx,"timestamp.push('"+r.getAttribute("currdatetime").toString()+"')");
                                         }  
                                        else {
                                          erks.addScript(fctx,"timestamp.push('')");
                                          } 
                             }
                  }
        }        
       //and issued_date='"+sqldate+"'
      
            
      erks.addScript(fctx,"loadMap(long,lat,long1,lat1,timestamp,active)");
    
    }
    public String doCreatePayment(BigDecimal CustomerId,Number SaleReceiptNumber,Date SaleDate,String location,BigDecimal Totalamount,String encoder )
   {
       java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
       java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
       ViewObjectImpl SalesHeaderVO =this.getSalesHeaderUVO1();               
       ViewObjectImpl SalesSettlementVO = this.getSalesSettlementUVO1();   
       SalesHeaderVO.clearCache();              
       SalesSettlementVO.clearCache();
       SalesHeaderVO.executeEmptyRowSet();               
       SalesSettlementVO.executeEmptyRowSet();
       try
       {
           SalesHeaderUVORowImpl SalesHeaderRow = (SalesHeaderUVORowImpl)SalesHeaderVO.createRow();
           SalesSettlementUVORowImpl salesSettlementRow = (SalesSettlementUVORowImpl)SalesSettlementVO.createRow();
           SalesHeaderVO.insertRow(SalesHeaderRow);
           BigDecimal SaleHdrSeq = SalesHeaderRow.getSalehdrseq();
           SalesHeaderRow.setAttribute("Instflag",'Y');                
           SalesHeaderRow.setAttribute("SaleAmt", Totalamount);
           SalesHeaderRow.setSaledate(sqlDate);
           SalesHeaderRow.setCutomerID(CustomerId);
           SalesHeaderRow.setUSERID("1");
           SalesHeaderRow.setlocationid(location);  
           SalesHeaderRow.setCreatedBy(encoder);
           SalesHeaderRow.setCreatedDate(sqlTime);
           CardIssueSrchCriVOImpl cardSrchVO = this.getCardIssueSrchCriVO1();
           String storeFirstCardNum = null;
           int insertStartNum = 0;
           BigDecimal cardAmt = new BigDecimal(0);
           for(int i = 0;i<cardSrchVO.getRowCount();i++)
           {
               CardIssueSrchCriVORowImpl cardSrchRow = (CardIssueSrchCriVORowImpl)cardSrchVO.getRowAtRangeIndex(i);
               if(cardSrchRow != null) 
               {
                       InvDetailUVOImpl invDetailVO = this.getInvDetailUVO1();  
                       String cardType = cardSrchRow.getBulkSaleCardType();
                       Integer cardDenom = cardSrchRow.getDenomination();
                       BigDecimal cardDenomBD = new BigDecimal(cardDenom.toString()+".0000"); 
                       RowQualifier qualf = new RowQualifier("CardStatusID = "+3+" AND CardDenomAmt = "+cardDenomBD+" AND CardctgCode ='"+cardType+"' AND SelectFlag = "+true);  
                       Row[] rows = invDetailVO.getFilteredRows(qualf);
                       int selectedCount = rows.length;
                       if(selectedCount > 0) 
                       {
                           int flag = 1;
                           for(int j=0; j<selectedCount; j++) 
                           {
                               Row firstRow = rows[j];
                               if(firstRow != null) 
                               {
                                   BigDecimal firstCardNum = new BigDecimal(firstRow.getAttribute("Cardnum").toString()); 
                             
                                   String cardNum = firstRow.getAttribute("Cardnum").toString().substring(0,firstRow.getAttribute("Cardnum").toString().length()-firstCardNum.toString().length());
                                  
                                   if (rows.length == 1) 
                                   {
                                       cardAmt = new BigDecimal(firstRow.getAttribute("CardDenomAmt").toString());
                                        insertSaleDetail(SaleHdrSeq,cardAmt, firstRow.getAttribute("Cardnum").toString(), firstRow.getAttribute("Cardnum").toString(), encoder,cardType);    
                                        insertStartNum = 0;
                                        cardAmt = new BigDecimal(0);
                                   }
                                   else
                                   {
                                       BigDecimal tmp = firstCardNum.add(new BigDecimal(1));
                                     
                                  
                                      
                                      
                                      
                                       int k = j+1; 
                                       cardAmt = cardAmt.add(new BigDecimal(firstRow.getAttribute("CardDenomAmt").toString()));
                                       if (insertStartNum == 0) 
                                       {
                                           storeFirstCardNum = firstRow.getAttribute("Cardnum").toString();
                                           insertStartNum = 1;
                                       }
                                       if(k==rows.length) 
                                       {
                                            insertSaleDetail(SaleHdrSeq,cardAmt, storeFirstCardNum, cardNum+firstCardNum.toString(), encoder,cardType);
                                           insertStartNum = 0;
                                           cardAmt = new BigDecimal(0);
                                       }
                                       else 
                                       {
                                           insertStartNum = 1; 
                                           Row nextRow = rows[k];
                                           if(nextRow != null) 
                                           {
                                               
                                               BigDecimal nextCardNum = new BigDecimal(nextRow.getAttribute("Cardnum").toString());
                                               if(!tmp.equals(nextCardNum)) 
                                               {
                                                   int startRowPosition = k - flag;
                                                   Row startRow = rows[startRowPosition];
                                                   if(startRowPosition!=0) 
                                                   {
                                                       startRow = rows[startRowPosition-1];    
                                                   }
                                                   if(startRow != null) 
                                                   {
                                                       insertSaleDetail(SaleHdrSeq, cardAmt, storeFirstCardNum, cardNum+firstCardNum.toString(), encoder,cardType);
                                                       insertStartNum = 0;
                                                       cardAmt = new BigDecimal(0);
                                                       flag = 1;   
                                                   }
                                               }
                                               else
                                               {
                                                 insertStartNum = 1;
                                                 flag = flag +1;
                                               }
                                           }   
                                       }
                                   }
                               }
                           }
                       }
                   }
             
              /**
               CardIssueSrchCriVORowImpl cardSrchRow = (CardIssueSrchCriVORowImpl)cardSrchVO.getRowAtRangeIndex(i);
               if(cardSrchRow != null)
               {
                   InvDetailUVOImpl invDetailVO = this.getInvDetailUVO1();  
                 String cardType = cardSrchRow.getBulkSaleCardType();
                 Integer cardDenom = cardSrchRow.getDenomination();
                   BigDecimal cardDenomBD = new BigDecimal(cardDenom.toString()+".0000"); 
                   RowQualifier qualf = new RowQualifier("CardStatusID = "+3+" AND CardDenomAmt = "+cardDenomBD+" AND CardctgCode ="+cardType);  
                   Row[] rows = invDetailVO.getFilteredRows(qualf);
                   if(rows.length > 0)
                   {   
                       int x = 0;
                       BigDecimal cardAmtTotLine = new BigDecimal(0);
                       for(int j=0;j<rows.length;j++)
                       {
                           Row invDtlURow = rows[j]; 
                           Object selectFlagVal = invDtlURow.getAttribute("SelectFlag");
                           BigDecimal cardAmtLine = (BigDecimal)invDtlURow.getAttribute("CardDenomAmt");
                           if(selectFlagVal!=null && selectFlagVal.equals(true)){
                           cardAmtTotLine = cardAmtTotLine.add(cardAmtLine);
                           }
                           if(selectFlagVal==null || selectFlagVal.equals(false))
                           {
                               if(j != 0)
                               {
                                   x= x+1; 
                                   System.out.println("Value of X : "+x);
                               }                                                      
                               Row invDtlURowFirst = rows[x];
                               Object cardNumStart = invDtlURowFirst.getAttribute("Cardnum");
                               Object selectF1 = invDtlURowFirst.getAttribute("SelectFlag");
                               if(selectF1 != null && selectF1.equals(true))
                               {
                                   Row invDtlURowLast = rows[j-1];
                                   Object cardNumEnd = invDtlURowLast.getAttribute("Cardnum");
                                   Object selectF2 = invDtlURowLast.getAttribute("SelectFlag");
                                   if(selectF2 != null && selectF2.equals(true))
                                   {
                                       System.out.println("Sale Amount in doCreatePayment is : "+cardAmtTotLine);
                                       SalesDetailUVORowImpl salesDetailRow = (SalesDetailUVORowImpl)SalesDetailVO.createRow();
                                       salesDetailRow.setSalehdrseq(SaleHdrSeq);
                                       salesDetailRow.setAttribute("Prodcode",1);
                                       salesDetailRow.setSaleAmt(cardAmtTotLine);
                                       salesDetailRow.setAttribute("DiscAmt",0);
                                       salesDetailRow.setActionCode(1); 
                                       salesDetailRow.setAttribute("Cardnumfrom", cardNumStart);
                                       salesDetailRow.setAttribute("Cardnumto", cardNumEnd);
                                       salesDetailRow.setCreatedBy(encoder);
                                       salesDetailRow.setCreatedDate(sqlTime);               
                                       SalesDetailVO.insertRow(salesDetailRow); 
                                       x = j;
                                       cardAmtTotLine = new BigDecimal(0);
                                   }    
                               }
                                                                                       
                           }
                       }
                       
                   }
               }*/
           }
            SalesSettlementVO.insertRow(salesSettlementRow);
            salesSettlementRow.setSalehdrseq(SaleHdrSeq);
            salesSettlementRow.setPYMTAMT(Totalamount);
            salesSettlementRow.setPYMTType("CSH");
            salesSettlementRow.setCreatedBy(encoder);
            salesSettlementRow.setCreatedDate(sqlTime);
     
       }
       catch (Exception e) {
       e.printStackTrace();
           } 
          return null;
   }
    public void insertSaleDetail(BigDecimal hdrSeq,  BigDecimal cardAmt, String cardNumFrom, String cardNumTo, String encoder,String cardType) {
        Timestamp sqlDate = new Timestamp(new java.util.Date().getTime());
        ViewObjectImpl SalesDetailVO = this.getSalesDetailUVO1();
        SalesDetailUVORowImpl salesDetailRow = (SalesDetailUVORowImpl)SalesDetailVO.createRow();
        salesDetailRow.setSalehdrseq(hdrSeq);
        if(cardType!=null){
            int cardNo=Integer.parseInt(cardType);
            if(cardNo==2){
                salesDetailRow.setAttribute("Prodcode",2);//Recharge Card
            }else if(cardNo==1){
                salesDetailRow.setAttribute("Prodcode",4);//Prepaid Card
            }
             
        }
        salesDetailRow.setSaleAmt(cardAmt);
        salesDetailRow.setAttribute("DiscAmt",0);
        salesDetailRow.setActionCode(1); 
        salesDetailRow.setAttribute("Cardnumfrom", cardNumFrom);
        salesDetailRow.setAttribute("Cardnumto", cardNumTo);
        salesDetailRow.setCreatedBy(encoder);
        salesDetailRow.setCreatedDate(sqlDate);               
        SalesDetailVO.insertRow(salesDetailRow); 
    }
    public void callValProc()
    {
        CallableStatement stmt = null;
        try {
            System.out.println("before Procedure Execution");
           stmt = getDBTransaction().createCallableStatement("{call  Inv_receipt_validation_proc}", 0);
            
           stmt.execute();
           commit();
            System.out.println("Procedure Executed");
            
        }  catch (Exception e) {
                 e.printStackTrace();
                 }         
        finally {
            try {
                     stmt.close();
            } catch(Exception e) {
                System.out.println("Closing the statement error..." + e);
            }
        }
    }
    public void delRecieptDetail()
    {
        PreparedStatement pst = null;
        try  
        {   
        pst = getDBTransaction().createPreparedStatement("delete from  inv_reciept_detail", 0);
        pst.execute();
        }   
        catch(Exception exception)   
        {    
        System.out.println(exception);   
        }   finally {
                try {
                   
                    if (pst != null) {
                        pst.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
        }
    }
    
    public void addPaymentRow(String encoder)
   {
       java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
       try{
            ViewObjectImpl SalesHeaderVO =this.getSalesHeaderUVO1();
            SalesHeaderUVORowImpl SalesHeaderRow = (SalesHeaderUVORowImpl)SalesHeaderVO.getCurrentRow();
            BigDecimal SaleHdrSeq = SalesHeaderRow.getSalehdrseq();
           System.out.println("saleHdrSeq in addPaymentRow is : "+SaleHdrSeq);
            ViewObjectImpl SalesSettlementVO = this.getSalesSettlementUVO1();   
            SalesSettlementUVORowImpl salesSettlementRow = (SalesSettlementUVORowImpl)SalesSettlementVO.createRow();
            SalesSettlementVO.insertRow(salesSettlementRow);
             if(SaleHdrSeq != null)
             {
                 salesSettlementRow.setPYMTAMT(new BigDecimal(0));  
                 salesSettlementRow.setSalehdrseq(SaleHdrSeq);    
                 salesSettlementRow.setCreatedBy(encoder);    
                 salesSettlementRow.setCreatedDate(sqlDate);    
             }             
        }catch(Exception e)
       {
           System.out.println("Exception in addPaymentRow is "+e.getMessage());   
       }
       
   }
    
    public void pushIssReturnHeader(Integer toLoc,Integer fromLoc,Date dispatchDate,String createdBy,String tranType)
    {
        try
        {
            IssReturnHdrUVOImpl vo = this.getIssReturnHdrUVO1();
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            if(vo != null)
            {
                IssReturnHdrUVORowImpl row = (IssReturnHdrUVORowImpl)vo.createRow();
                row.setToLocation(toLoc);
                row.setFromLocation(fromLoc);
                row.setTrnType(tranType);
                row.setDispatchDate(getCurrentTimeStamp());
                row.setCreatedBy(createdBy);
                vo.insertRow(row);
            }    
        }catch(Exception e)
        {
            System.out.println("Exception in AM method pushIssReturnHeader is :"+e.getMessage());    
        }  
        
        
    }
    private static java.sql.Timestamp getCurrentTimeStamp() {
     
            java.util.Date today = new java.util.Date();
            return new java.sql.Timestamp(today.getTime());
     
    }
    
    public String displayTransRefNum()
    {
        Object transRef = null;
        IssReturnHdrUVOImpl vo = this.getIssReturnHdrUVO1();
        if(vo != null)
        {
            IssReturnHdrUVORowImpl row = (IssReturnHdrUVORowImpl)vo.getCurrentRow();
            if(row != null)
            {
                transRef = row.getIssreturntrnseq();
            }   
        }
        return transRef.toString();
    }
    
    public void pushIssReturnDetail(String encoder, String reasons, String fromPage)
    {
        try
        {
            InvDetailUVOImpl invDetailVO = this.getInvDetailUVO1();
            IssReturnHdrUVOImpl vo = this.getIssReturnHdrUVO1();
            IssReturnHdrUVORowImpl hdrRow = (IssReturnHdrUVORowImpl)vo.getCurrentRow();
            Object hdrSeq = hdrRow.getIssreturntrnseq();
            CardIssueSrchCriVOImpl cardSrchVO = this.getCardIssueSrchCriVO1();
            
//            if(fromPage.equalsIgnoreCase("trns"))
//            {
//                for(int i = 0;i<cardSrchVO.getRowCount();i++)
//                {
//                    CardIssueSrchCriVORowImpl cardSrchRow = (CardIssueSrchCriVORowImpl)cardSrchVO.getRowAtRangeIndex(i);
//                    if(cardSrchRow != null)
//                    {
//                        
//                      String cardType = cardSrchRow.getCardType();
//                      Integer cardDenom = cardSrchRow.getDenomination();
//                        BigDecimal cardDenomBD = new BigDecimal(cardDenom.toString()+".0000"); 
//                        RowQualifier qualf = new RowQualifier("CardStatusID = "+3+" AND CardDenomAmt = '"+cardDenomBD+"' AND CardctgCode ="+cardType);  
//                        Row[] rows = invDetailVO.getFilteredRows(qualf);
//                        if(rows.length > 0)
//                        {
//                            int x = 0;
//                            for(int j=0;j<rows.length;j++)
//                            {
//                                Row invDtlURow = rows[j];    
//                                Object selectFlagVal = invDtlURow.getAttribute("SelectFlag");
//                                if(selectFlagVal==null || selectFlagVal.equals(false))
//                                {
//                                    if(j != 0)
//                                    {
//                                        x= x+1; 
//                                        System.out.println("Value of X : "+x);
//                                    }                                                      
//                                    Row invDtlURowFirst = rows[x];
//                                    Object cardNumStart = invDtlURowFirst.getAttribute("Cardnum");
//                                    Object selectF1 = invDtlURowFirst.getAttribute("SelectFlag");
//                                    if(selectF1 != null && selectF1.equals(true))
//                                    {
//                                        Row invDtlURowLast = rows[j-1];
//                                        Object cardNumEnd = invDtlURowLast.getAttribute("Cardnum");
//                                        Object selectF2 = invDtlURowLast.getAttribute("SelectFlag");
//                                        if(selectF2 != null && selectF2.equals(true))
//                                        {
//                                            IssReturnDtlUVOImpl issRetDtlVO = this.getIssReturnDtlUVO1();
//                                             Row dtlRow = issRetDtlVO.createRow();                                              
//                                            dtlRow.setAttribute("Issreturntrnseq",hdrSeq);
//                                             dtlRow.setAttribute("CardType",cardType);
//                                            dtlRow.setAttribute("CardDenomAmt",cardDenom);
//                                            dtlRow.setAttribute("FromCardnum",cardNumStart);
//                                            dtlRow.setAttribute("Tocardnum",cardNumEnd);
//                                            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//                                                dtlRow.setAttribute("CreatedBy", encoder); 
//                                                dtlRow.setAttribute("CreatedDate",sqlDate);
//                                            dtlRow.setAttribute("RetrunReasons",reasons);
//                                            issRetDtlVO.insertRow(dtlRow); 
//                                            x = j;
//                                        }    
//                                    }
//                                                                                            
//                                }
//                            }
//                            
//                        }
//                    }
//                }    
//            }
            
            if(fromPage.equalsIgnoreCase("trns")) {
                String storeFirstCardNum = null;
                int insertStartNum = 0;
                for(int i = 0;i<cardSrchVO.getRowCount();i++) {
                    CardIssueSrchCriVORowImpl cardSrchRow = (CardIssueSrchCriVORowImpl)cardSrchVO.getRowAtRangeIndex(i);
                    if(cardSrchRow != null) {
                        String cardType = cardSrchRow.getCardType();
                        Integer cardDenom = cardSrchRow.getDenomination();
                        BigDecimal cardDenomBD = new BigDecimal(cardDenom.toString()+".0000"); 
                        RowQualifier qualf = new RowQualifier("CardStatusID = "+3+" AND CardDenomAmt = '"+cardDenomBD+"' AND CardctgCode = '"+cardType+"' AND SelectFlag = "+true);  
                        Row[] rows = invDetailVO.getFilteredRows(qualf);
                        int selectedCount = rows.length;
                        
                        if(selectedCount > 0) {
                            int flag = 1;
                            for(int j=0; j<selectedCount; j++) {
                                Row firstRow = rows[j];
                                if(firstRow != null) {
                                    System.out.println("%%%%% Card number display...." + firstRow.getAttribute("Cardnum").toString());
                                    
                                    BigDecimal firstCardNum = new BigDecimal(firstRow.getAttribute("Cardnum").toString());                                  
                                    if (rows.length == 1) {
                                        System.out.println("%%%%% Rows length is 1 inserting now into detail..." + firstCardNum.toString() + "..." + firstCardNum.toString());
                                        insertIssRetDetail(hdrSeq.toString(),cardType, cardDenom, firstCardNum.toString(), firstCardNum.toString(), encoder,reasons);    
                                        System.out.println("1....insertStartNum = 0");
                                        insertStartNum = 0;
                                    }
                                    else {
                                        System.out.println("%%%%% Rows length is NOT equal to 1...");
                                        BigDecimal tmp = firstCardNum.add(new BigDecimal(1));
                                        int k = j+1;
                                        System.out.println("%%%%% j="+j+"...k="+k);
                                        
                                        if (insertStartNum == 0) {
                                            storeFirstCardNum = firstRow.getAttribute("Cardnum").toString();
                                            System.out.println("11....insertStartNum = 1");
                                            insertStartNum = 1;
                                        }
                                        if(k==rows.length) {
                                            System.out.println("%%%%% k equal to rows length inserting now into detail..." + storeFirstCardNum + "..." + firstCardNum.toString());
                                            insertIssRetDetail(hdrSeq.toString(),cardType, cardDenom, storeFirstCardNum, firstCardNum.toString(), encoder,reasons);
                                            System.out.println("2....insertStartNum = 0");
                                            insertStartNum = 0;
                                        }
                                        else {
                                            insertStartNum = 1;
                                            System.out.println("12....insertStartNum = 1");
                                            System.out.println("%%%%% k NOT equal to rows length...");
                                            Row nextRow = rows[k];
                                            if(nextRow != null) {
                                                BigDecimal nextCardNum = new BigDecimal(nextRow.getAttribute("Cardnum").toString());
                                                if(!tmp.equals(nextCardNum)) {
                                                    int startRowPosition = k - flag;
                                                    Row startRow = rows[startRowPosition];
                                                    if(startRowPosition!=0) {
                                                        startRow = rows[startRowPosition-1];    
                                                }
                                                if(startRow != null) {
                                                    System.out.println("%%%%% startrow not equal to null inserting into detail..." + storeFirstCardNum + "..." + firstCardNum.toString());
                                                    insertIssRetDetail(hdrSeq.toString(),cardType, cardDenom, storeFirstCardNum, firstCardNum.toString(), encoder,reasons);
                                                    System.out.println("3....insertStartNum = 0");
                                                    insertStartNum = 0;
                                                    flag = 1;   
                                                }
                                             }
                                             else {
                                                  System.out.println("13....insertStartNum = 1");
                                                  insertStartNum = 1;
                                                  flag = flag +1;
                                             }
                                           }   
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(fromPage.equalsIgnoreCase("ack"))
            {
//                int cardStatus = 0;
//                if(reasons.equals("Excess"))
//                {
//                    cardStatus =8;
//                }
//                else if(reasons.equals("Damage"))
//                {
//                    cardStatus =10 ;
//                }                
//                RowQualifier qualf = new RowQualifier("CardStatusID = "+cardStatus);
//                Row[] rows = invDetailVO.getFilteredRows(qualf);   
//                if(rows.length > 0)
//                {
//                    int x = 0;
//                    for(int i=x;i<rows.length;i++)
//                    {
//                        Row invRow = rows[x];
//                        String cardType = (String)invRow.getAttribute("CardTypecode");
//                        BigDecimal denomAmt = (BigDecimal)invRow.getAttribute("CardDenomAmt");
//                        if(x != i)
//                        {
//                            Row invRowJ = rows[i];
//                            String cardTypeJ = (String)invRowJ.getAttribute("CardTypecode");
//                            BigDecimal denomAmtJ = (BigDecimal)invRowJ.getAttribute("CardDenomAmt"); 
//                            if(!cardType.equalsIgnoreCase(cardTypeJ) || denomAmt!=denomAmtJ)
//                            {
//                                IssReturnDtlUVOImpl issRetDtlVO = this.getIssReturnDtlUVO1();
//                                int first = x;
//                                int last = i-1;
//                                if(first==last)//indicates only one row is present with Qual from invRow
//                                {
//                                    Row invSingle = rows[x]   ;
//                                    Object selectFlagSingle = invSingle.getAttribute("SelectFlag");
//                                    Object cardNumSingle = invSingle.getAttribute("Cardnum");
//                                    if(selectFlagSingle!=null && selectFlagSingle.equals(true))
//                                    {
//                                        
//                                        Row dtlRow = issRetDtlVO.createRow();                                              
//                                        dtlRow.setAttribute("Issreturntrnseq",hdrSeq);
//                                        dtlRow.setAttribute("CardType",cardType);
//                                        dtlRow.setAttribute("CardDenomAmt",denomAmt);
//                                        dtlRow.setAttribute("FromCardnum",cardNumSingle);
//                                        dtlRow.setAttribute("Tocardnum",cardNumSingle);
//                                        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//                                        dtlRow.setAttribute("CreatedBy", encoder); 
//                                        dtlRow.setAttribute("CreatedDate",sqlDate);
//                                        dtlRow.setAttribute("RetrunReasons",reasons);
//                                        issRetDtlVO.insertRow(dtlRow); 
//                                    }
//                                }
//                                else if(first!=last)
//                                {
//                                    int y = 0;
//                                    for(int j=0;j<last;j++ )//indicates more than one row is present with Qual from invRow
//                                    {
//                                        Row invDtlURow = rows[j];    
//                                        Object selectFlagVal = invDtlURow.getAttribute("SelectFlag");
//                                        if(selectFlagVal==null || selectFlagVal.equals(false))
//                                        {
//                                            if(j != 0)
//                                            {
//                                                y=y+1; 
//                                                System.out.println("Value of Y : "+y);
//                                            }                                                      
//                                            Row invDtlURowFirst = rows[y];
//                                            Object cardNumStart = invDtlURowFirst.getAttribute("Cardnum");
//                                            Object selectF1 = invDtlURowFirst.getAttribute("SelectFlag");
//                                            if(selectF1 != null && selectF1.equals(true))
//                                            {
//                                                Row invDtlURowLast = rows[j-1];
//                                                Object cardNumEnd = invDtlURowLast.getAttribute("Cardnum");
//                                                Object selectF2 = invDtlURowLast.getAttribute("SelectFlag");
//                                                if(selectF2 != null && selectF2.equals(true))
//                                                {
//                                                    
//                                                    Row dtlRow = issRetDtlVO.createRow();                                              
//                                                    dtlRow.setAttribute("Issreturntrnseq",hdrSeq);
//                                                    dtlRow.setAttribute("CardType",cardType);
//                                                    dtlRow.setAttribute("CardDenomAmt",denomAmt);
//                                                    dtlRow.setAttribute("FromCardnum",cardNumStart);
//                                                    dtlRow.setAttribute("Tocardnum",cardNumEnd);
//                                                    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//                                                    dtlRow.setAttribute("CreatedBy", encoder); 
//                                                    dtlRow.setAttribute("CreatedDate",sqlDate);
//                                                    dtlRow.setAttribute("RetrunReasons",reasons);
//                                                    issRetDtlVO.insertRow(dtlRow); 
//                                                    y = j;
//                                                }    
//                                            }                                                           
//                                        }                                         
//                                    }    
//                                }    
//                                x=i;
//                                break;
//                            }
//                        }
//                    }    
//                }
            }
        }catch(Exception e)
        {
            System.out.println("Exception in AM method pushIssReturnDetail is :"+e.getMessage());       
        }
    }
    
    public void insertIssRetDetail(String hdrSeq, String cardType, Integer cardDenom, String cardNumFrom, String cardNumTo, String encoder, String reasons) {
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        IssReturnDtlUVOImpl issRetDtlVO = this.getIssReturnDtlUVO1();
        Row dtlRow = issRetDtlVO.createRow();
        dtlRow.setAttribute("Issreturntrnseq",hdrSeq);
        dtlRow.setAttribute("CardType",cardType);
        dtlRow.setAttribute("CardDenomAmt",cardDenom);
        dtlRow.setAttribute("FromCardnum",cardNumFrom);
        dtlRow.setAttribute("Tocardnum",cardNumTo);
        dtlRow.setAttribute("CreatedBy", encoder);
        dtlRow.setAttribute("CreatedDate",sqlDate);
        dtlRow.setAttribute("RetrunReasons",reasons);
        issRetDtlVO.insertRow(dtlRow);       
    }
    
    public void addNewCardTypeMst(String encoder)
    {
        CardTypeMstUVOImpl vo = (CardTypeMstUVOImpl)this.getCardTypeMstUVO1();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        if(vo != null)
        {
            Row cardTypeMstRow = vo.createRow();   
            cardTypeMstRow.setAttribute("Createdby",encoder);
            cardTypeMstRow.setAttribute("CreatedDate",sqlDate);
            cardTypeMstRow.setAttribute("Countrycode","ARE");
            vo.insertRow(cardTypeMstRow);
        }
    }
    
    public void fecthCardTypeMst(String encoder, String mode, String typeCode)
    {
        CardTypeMstUVOImpl hdrVO = (CardTypeMstUVOImpl)this.getCardTypeMstUVO1();        
        if(hdrVO!=null)
        {
            hdrVO.setWhereClause(null);
            hdrVO.setWhereClause("Card_Type_Code = "+typeCode);
            hdrVO.executeQuery();
            System.out.println("Card Type Count in Edit_action is : "+hdrVO.getRowCount());
            Row currentRow = hdrVO.getCurrentRow();
            if(currentRow != null && mode.equals("edit"))
            {
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                currentRow.setAttribute("Updatedby",encoder);        
                currentRow.setAttribute("Updateddate",sqlDate);   
            }
        }    
    }
    
    public String cardTypeLength(String cardType)
    {
        Object length = null ;
        CardCtgMstRVOImpl cardctgRVO = (CardCtgMstRVOImpl)this.getCardCtgMstRVO1();        
        if(cardctgRVO!=null)
        {
            cardctgRVO.setWhereClause(null);
            cardctgRVO.setWhereClause("Card_Ctg_Code = "+cardType);
            cardctgRVO.executeQuery();    
            System.out.println("get query..." + cardctgRVO.getQuery());
            System.out.println("Row count in cardTypeLength is : "+cardctgRVO.getRowCount());
            Row cardTypeCurrentRow = cardctgRVO.first();
            if(cardTypeCurrentRow != null)
            {
                String numFormat = (String)cardTypeCurrentRow.getAttribute("NumberFormat");
                length = numFormat.length();
            }
        }
        System.out.println("length in cardTypeLength is : "+length);
        return length.toString();
    }
    
    public void plateCategoryTypeDependentLOV(int plateCategory)
    {
        PlateTypeLOVVOImpl plateTypeVOImpl = (PlateTypeLOVVOImpl)this.getPlateTypeLOVVO1();        
        if(plateTypeVOImpl != null)
        {
            plateTypeVOImpl.setWhereClause(null);
            plateTypeVOImpl.setWhereClause("plate_category_id = "+plateCategory);
            plateTypeVOImpl.executeQuery();    
            System.out.println("plateTypeVO query..." + plateTypeVOImpl.getQuery());
            System.out.println("Row count in plateTypeVOImpl is : "+plateTypeVOImpl.getRowCount());
        }
    }
    
    public void vehicleMakeModelDependentLOV(int vehicleMake)
    {
        VehicleModelLOVVOImpl vehicleModelVOImpl = (VehicleModelLOVVOImpl)this.getVehicleMakeLOVVO1();        
        if(vehicleModelVOImpl != null)
        {
            vehicleModelVOImpl.setWhereClause(null);
            vehicleModelVOImpl.setWhereClause("make_id = "+vehicleMake);
            vehicleModelVOImpl.executeQuery();    
            System.out.println("vehicleModelVOImpl query..." + vehicleModelVOImpl.getQuery());
            System.out.println("Row count in vehicleModelVOImpl is : "+vehicleModelVOImpl.getRowCount());
        }
    }
    
    public void addPVTHeaderData(String userid)
    {
        PVTDiscCnclHeaderVOImpl pvtDiscCnclHeaderVOImpl = (PVTDiscCnclHeaderVOImpl)this.getPVTDiscCnclHeaderVO1();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        if (pvtDiscCnclHeaderVOImpl != null)
        {
            Row pvtDiscCnclHeaderVOImplRow = pvtDiscCnclHeaderVOImpl.getCurrentRow();
            pvtDiscCnclHeaderVOImplRow.setAttribute("CreatedBy", userid);
            pvtDiscCnclHeaderVOImplRow.setAttribute("CreatedDate", sqlDate);
            pvtDiscCnclHeaderVOImplRow.setAttribute("DISCCNCLTYPE", "D");
            pvtDiscCnclHeaderVOImplRow.setAttribute("DISCCNCLSTATUS", 2);
        }
    }
    public void addPVTCancelHeaderData(String userid)
    {
        PVTDiscCnclHeaderVOImpl pvtDiscCnclHeaderVOImpl = (PVTDiscCnclHeaderVOImpl)this.getPVTDiscCnclHeaderVO1();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        if (pvtDiscCnclHeaderVOImpl != null)
        {
            Row pvtDiscCnclHeaderVOImplRow = pvtDiscCnclHeaderVOImpl.getCurrentRow();
            pvtDiscCnclHeaderVOImplRow.setAttribute("CreatedBy", userid);
            pvtDiscCnclHeaderVOImplRow.setAttribute("CreatedDate", sqlDate);
            pvtDiscCnclHeaderVOImplRow.setAttribute("DISCCNCLTYPE", "C");
            pvtDiscCnclHeaderVOImplRow.setAttribute("DISCCNCLSTATUS", 2);
            pvtDiscCnclHeaderVOImplRow.setAttribute("Promoeffectivedatefrom", sqlDate);
            pvtDiscCnclHeaderVOImplRow.setAttribute("PromoeffectivedateTo", sqlDate);
        }
       
    }
    
    public int getDiscountHeaderSeq() {
        ViewObjectImpl pvtHeaderSeqVO = getPVTDiscountHeaderSeqVO1();
        pvtHeaderSeqVO.executeQuery();
        
        Row lastSeqHeaderRow = pvtHeaderSeqVO.last();
        int PvtHeaderSeq = Integer.parseInt(lastSeqHeaderRow.getAttribute("disccnclhdrseq").toString());
        
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update pvt_disc_cncl_dtl set disc_cncl_hdr_seq="+ PvtHeaderSeq +" where disc_cncl_hdr_seq=0";
            preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
            preparedStatement.executeUpdate();
            System.out.println("Sequence updated in detail table...");
        }  catch (Exception e) {
            e.printStackTrace();
        }
        getDBTransaction().commit();
        
        return PvtHeaderSeq;
    }
    
    
    
    public int getissdetailSeq() {
        ViewObjectImpl HeaderSeqVO = getIssReturnHdrUVO1();
        HeaderSeqVO.executeQuery();
        
        Row lastSeqHeaderRow = HeaderSeqVO.last();
        int cardHeaderSeq = Integer.parseInt(lastSeqHeaderRow.getAttribute("Issreturntrnseq").toString());
        
        PreparedStatement preparedStatement = null;
        try {
            //update Inv_Iss_Return_Detail set Iss_return_trn_seq=170 where Iss_return_trn_seq=0
            String sql = "update Inv_Iss_Return_Detail set Iss_return_trn_seq="+ cardHeaderSeq +" where Iss_return_trn_seq=0";
            preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
            preparedStatement.executeUpdate();
            System.out.println("Sequence updated in detail table...");
        }  catch (Exception e) {
            e.printStackTrace();
        }
        getDBTransaction().commit();
        
        return cardHeaderSeq;
    }
    
    
    public BigDecimal getContraAmtForContraCode(int ContraCode) {
        ViewObjectImpl contraCodeVO = getContraventionMstUVO1();
        contraCodeVO.setWhereClause("Contra_Code="+ContraCode);
        contraCodeVO.executeQuery();
        BigDecimal ContraAmount = new BigDecimal("0.00");
        Row contraCodeRow = contraCodeVO.first();
        if (contraCodeRow != null) {
            ContraAmount = (BigDecimal)contraCodeRow.getAttribute("BaseCostAmt");
        }
        return ContraAmount;
    }
    
    public int getPlateCountryForPlateCategory(int PlateCategoryId) {
        ViewObjectImpl plateCategoryIdVO = getVehiclePlateCategoryVO1();
        plateCategoryIdVO.setWhereClause("Plate_Ctg_ID="+PlateCategoryId);
        plateCategoryIdVO.executeQuery();
        int PlateCountryID = 0;
        Row plateCategoryIdRow = plateCategoryIdVO.first();
        if (plateCategoryIdRow != null) {
            PlateCountryID = Integer.parseInt(plateCategoryIdRow.getAttribute("PlateCountryID").toString());
        }
        return PlateCountryID;
    }
    
    //PoundBayAllocation Screen Methods  
        public void updateBayStatusByLocIdAndBayNo(String pvtNo,BigDecimal baySeq,String modifiedBy)
                {
                    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
                    System.out.println("sqlDate in updateBayStatusByLocIdAndBayNo is : "+sqlDate);
                    System.out.println("baySeq in updateBayStatusByLocIdAndBayNo is : "+baySeq);
                    System.out.println("pvtNo in updateBayStatusByLocIdAndBayNo is : "+pvtNo);
                    BigDecimal pvtHdrSeq =  new BigDecimal(0);
          
                  //Getting Pvtheader sequence from Pvt Header table
                    PVTHeaderVOImpl pvtVo= (PVTHeaderVOImpl)this.getPVTHeaderVO1(); 
                    if(pvtVo!=null)
                    {
                        pvtVo.setWhereClause(null);
                        pvtVo.setWhereClause("PVT_Num = '"+pvtNo+"'");
                        pvtVo.executeQuery();
                        System.out.println("get query..." + pvtVo.getQuery());
                        PVTHeaderVORowImpl pvtHdrRow = (PVTHeaderVORowImpl)pvtVo.first();
                        if(pvtHdrRow!=null)
                        {
                          pvtHdrSeq =  pvtHdrRow.getPVTHDRSEQ();   
                          setPvtHdrSeq(pvtHdrSeq);
                          pvtHdrRow.setVehPoundDate(sqlDate);
                          pvtHdrRow.setPOUNDPAYFLAG("Y");
                          pvtHdrRow.setUpdatedby(modifiedBy);
                        }                   
                    }
                               
                    //Updating pound bay detail table (Bay status ,pvtheader seq)
                   PoundBayDetailVOImpl bayDetailvoTableData = (PoundBayDetailVOImpl) this.getPoundBayDetailVO1();             
                    if(baySeq != null) 
                    {
                        bayDetailvoTableData.clearCache();
                        bayDetailvoTableData.setWhereClause(null);
                        bayDetailvoTableData.setWhereClause("Pound_bay_detail_Seq = "+baySeq);
                        bayDetailvoTableData.executeQuery(); 
                        PoundBayDetailVORowImpl bayDetailRow = (PoundBayDetailVORowImpl)bayDetailvoTableData.first();
                        if(bayDetailRow!=null)
                        {
                           bayDetailRow.setBaystatus("O");
                            if(pvtNo!=null){
                            bayDetailRow.setPVTHDRSEQ(pvtHdrSeq);
                            }
                            bayDetailRow.setUpdateddate(sqlDate);
                            bayDetailRow.setUpdatedby(modifiedBy);
                            Integer locationid = bayDetailRow.getPOUNDLocationID();
                            /* added for inserting during vehicle release */
                            PVTVehPoungLogUVOImpl pvtvehlogVO = (PVTVehPoungLogUVOImpl) this.getPVTVehPoungLogUVO1(); 
                            if(pvtvehlogVO != null)
                            {
                            Row vehlorow = pvtvehlogVO.createRow();
                            if(vehlorow != null)
                            {
                            
                            vehlorow.setAttribute("PVTHDRSEQ", pvtHdrSeq);
                            vehlorow.setAttribute("POUNDDATE", sqlDate);
                            vehlorow.setAttribute("POUNDLOCATIONID", locationid);   
                            vehlorow.setAttribute("CreatedBy", modifiedBy);
                            vehlorow.setAttribute("CreatedDate", sqlDate);  
                            pvtvehlogVO.insertRow(vehlorow);
                                
                            }
                            }
                            
                            
                            
                            
                          
                        }                   
                    }         
                }

            public void uploadPvtDocs(String encoder, ArrayList uploadFiles)
            {
                ViewObjectImpl vo = getPVTDocsVO1();
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                System.out.println("sqlDate in uploadPvtDocs is : "+sqlDate);
                int documentStage=7; //Bay Number
                if(vo != null && null != uploadFiles)
                {
                    for(int i=0;i<uploadFiles.size(); i++)
                    {
                    Row pvtDocsRow = vo.createRow();
                    int extType1;
                    extType1 = getFileExtension((String)uploadFiles.get(i));
                    pvtDocsRow.setAttribute("CreatedBy",encoder);
                    pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                    pvtDocsRow.setAttribute("filepath",uploadFiles.get(i));
                    pvtDocsRow.setAttribute("Docstage",documentStage);
                    pvtDocsRow.setAttribute("PVTHDRSEQ",getPvtHdrSeq());
                    pvtDocsRow.setAttribute("deleteflag","N");
                    pvtDocsRow.setAttribute("doctype",extType1);
                    vo.insertRow(pvtDocsRow);
                    }
                }
            }
            
    public Boolean IntSpoiledPVTAtoSiebel(BigDecimal pvtHDRSeq){
        
            CallableStatement stmt = null;
                try {
                    stmt = getDBTransaction().createCallableStatement("{call  INT_PVT_DATA_CHANGE_LOG_proc('PVT_Header', ?, 'N', 'N', 'N') }", 0);
                    stmt.setBigDecimal(1,pvtHDRSeq);            
                    stmt.execute();           
                   
                    
                }  catch (Exception e) {
                    System.out.println("INT_PVT_DATA_CHANGE_LOG_proc procedure exception : "+e.getMessage());
                    return false;
                } 
                return true;
        }
    
    public Boolean PVTDocsSeibelSync()
    {
        CallableStatement stmt = null;
            try {
                BigDecimal docseq = null;
                ViewObjectImpl pvtdocsvo = this.getPVTDocsVO1();
                Row row = pvtdocsvo.first();
                if(row.getAttribute("DOCSEQ") != null)
                 docseq = new BigDecimal(row.getAttribute("DOCSEQ").toString());
                System.out.println(docseq);
                stmt = getDBTransaction().createCallableStatement("{call  INT_PVT_DATA_CHANGE_LOG_proc('PVT_DOCS', ?, 'N', 'N', 'X') }", 0);
                stmt.setBigDecimal(1,docseq);            
                stmt.execute(); 
                getDBTransaction().commit();
               
                
            }  catch (Exception e) {
                System.out.println("INT_PVT_DATA_CHANGE_LOG_proc procedure exception : "+e.getMessage());
                return false;
            } 
            return true;
    }
            
            public Boolean IntPVTAdjSP(BigDecimal pvtHDRSeq){
                
                    CallableStatement stmt = null;
                        try {
                            stmt = getDBTransaction().createCallableStatement("{call  INT_PVT_DATA_CHANGE_LOG_proc('PVT_Header', ?, 'N', 'N', 'N') }", 0);
                            stmt.setBigDecimal(1,pvtHDRSeq);            
                            stmt.execute();           
                           
                            
                        }  catch (Exception e) {
                            System.out.println("INT_PVT_DATA_CHANGE_LOG_proc procedure exception : "+e.getMessage());
                            return false;
                        } 
                        return true;
                }
            
            
        public void callRemovalChargesProc()
        {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "select Enforce_Vhcl_Id from PVT_enforce_vhcl_assign where pvt_hdr_seq = "+getPvtHdrSeq();
                preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
               
                ResultSet rs =  preparedStatement.executeQuery();//preparedStatement.getResultSet();
                if(rs != null )
                {
                    while(rs.next())
                    {
                        Integer enfcVhclId = rs.getInt("Enforce_Vhcl_Id");
                        if(enfcVhclId != null)
                        {
                            CallableStatement stmt = null;
                                try {
                                    stmt = getDBTransaction().createCallableStatement("{call  PVT_Populate_removal_charges(?,?,?) }", 0);
                                    stmt.setBigDecimal(1,getPvtHdrSeq());            
                                    stmt.setInt(2,enfcVhclId);
                                    stmt.setString(3,"R");
                                    // Charge_type
                                    stmt.execute();           
                                   
                                    
                                }  catch (Exception e) {
                                    System.out.println("callRemovalCharges procedure exception : "+e.getMessage());
                                }      
                        }       
                    }
                                        
                }
                
            }  catch (Exception e) {
                System.out.println("callRemovalCharges exception : "+e.getMessage());
            }
         System.out.println("Success");    
        }
        
    public void callClampingChargesProc(BigDecimal pvthdrseq,Integer enfcVhclId)
    {
       
        try {
                             if(enfcVhclId != null)
                    {
                        CallableStatement stmt = null;
                            try {
                                stmt = getDBTransaction().createCallableStatement("{call  PVT_Populate_removal_charges(?,?,?) }", 0);
                                stmt.setBigDecimal(1,pvthdrseq);            
                                stmt.setInt(2,enfcVhclId);
                                stmt.setString(3,"C");
                                // Charge_type
                                stmt.execute();           
                               
                                
                            }  catch (Exception e) {
                                System.out.println("callRemovalCharges procedure exception : "+e.getMessage());
                            }      
                    }       
                }
                                    
            
            
         catch (Exception e) {
            System.out.println("callRemovalCharges exception : "+e.getMessage());
        }
     System.out.println("Success");    
    }    
        
     
        
    public void updateSpoiledPVT(String userId,ArrayList pvts, String remarks)
        {
//            PVTHeaderVOImpl pvtHeaderVO = (PVTHeaderVOImpl)this.getPVTHeaderVO1();
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            if(null != pvts)
            {
//                pvtHeaderVO.executeQuery();
                for(int i=0;i<pvts.size(); i++)
                {            
                    getPVTHeaderVO1().applyViewCriteria(null);
                    getPVTHeaderVO1().applyViewCriteria(getPVTHeaderVO1().getViewCriteria("GetByPvtHeaderSeq"));
                    VariableValueManager evm2= getPVTHeaderVO1().ensureVariableManager();
                    evm2.setVariableValue("BindPvtHdrSeq", pvts.get(i));
                    getPVTHeaderVO1().executeQuery();
                    
                    Row headerRows = getPVTHeaderVO1().first();
                    
                    if(null!=headerRows)
                    {
//                        System.out.println("headerRows.length" + headerRows.length);
                        headerRows.setAttribute("PVTStatusID", 3);
                        headerRows.setAttribute("CLOSUREREMARKS", remarks);
                        headerRows.setAttribute("Updatedby",userId);
                        headerRows.setAttribute("Updateddate",sqlDate); 
                        BigDecimal hdrSeq=(BigDecimal)headerRows.getAttribute("PVTHDRSEQ");
                        System.out.println("hdrSeq in Spoiled PVT:"+hdrSeq);
                        //Inserting Notes in PVT Event Details table  
                              
                        PVTEventDetailsVOImpl eventVO = getPVTEventDetailsVO1();    
                          eventVO.clearCache();
                          eventVO.executeEmptyRowSet();
                          System.out.println("RowCount::::IMpl::::"+eventVO.getRowCount());
                        if(eventVO != null)
                        {
                            Row eventRow = eventVO.createRow();
                            eventRow.setAttribute("PVTHDRSEQ",hdrSeq);
                            eventRow.setAttribute("Remarks",remarks);                       
                            eventRow.setAttribute("EVENTID","560");  //SpoiledPVT Code
                            eventRow.setAttribute("EVENTDATE",sqlDate);
                            eventRow.setAttribute("CreatedBy",userId);
                            eventRow.setAttribute("CreatedDate",sqlDate);
                            eventVO.insertRow(eventRow);  
                            IntSpoiledPVTAtoSiebel(hdrSeq);
                        }
                    }                
                    
                }
//              pvtHeaderVO.getDBTransaction().commit();
//              this.getPVTEventDetailsVO1().getDBTransaction().commit();
              getDBTransaction().commit();            
            }
        }

    
     public Map getPVTRemovalStatus(Map pvtMap){
        
            ContraventionMstUVOImpl contraVO = (ContraventionMstUVOImpl)this.getContraventionMstUVO1();
            String pvtSeq,contraCode,removalFlag = null;
            Iterator<Map.Entry<String,String>> it1 = pvtMap.entrySet().iterator();
            while(it1.hasNext()){
            System.out.println("Map Size" + pvtMap.size() );
            Map.Entry entry = it1.next();
            pvtSeq = entry.getKey().toString();
            contraCode = entry.getValue().toString();                          
            contraVO.setWhereClause("Contra_Code="+contraCode);
            contraVO.executeQuery();
                
            Row contraCodeRow = contraVO.first();
            if (contraCodeRow != null) {
                removalFlag = contraCodeRow.getAttribute("RemovalReqflag").toString();
                if(!removalFlag.equals("Y")){
                    pvtMap.remove(pvtSeq);                    
                    }
            }
                
        }
        
        return pvtMap;
        } 
  
        private static int getFileExtension(String file) {
        String fileName = file;
        String extType = null;
        int docType = 0;
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            extType = fileName.substring(fileName.lastIndexOf(".")+1);
            //.gif.bmp.dib.jpg.jpe.jfif.tiff.tif
            if(extType != null && extType.equalsIgnoreCase("jpeg")|| extType.equalsIgnoreCase("png") ||
            extType.equalsIgnoreCase("gif")|| extType.equalsIgnoreCase("bmp")||extType.equalsIgnoreCase("dib")|| extType.equalsIgnoreCase("jpg")||
            extType.equalsIgnoreCase("jfif")|| extType.equalsIgnoreCase("tiff")||extType.equalsIgnoreCase("tif")){
                extType = "IMAGE";
                docType = 2;
            }else if(extType != null && extType.equalsIgnoreCase("xml")){
                extType = "XML";
                docType=3;
            }else if(extType != null && extType.equalsIgnoreCase("pdf")){
                extType = "PDF";
                docType=3;
            }else if(extType != null && ( extType.equalsIgnoreCase("MPG")|| extType.equalsIgnoreCase("MPEG"))){
                extType = "Video";
                docType=4;
            }
            return docType;
        }
        
        else return docType;
        }

//PVTOnHoldRelease Screen Methods  
       public String updatePvtStatusForReleaseOnHold(int pvtStatus,String loggerName,String notesEvent)
                {
                    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
                    System.out.println("sqlDate in updatePvtStatusForReleaseOnHold is : "+sqlDate);
                    System.out.println("pvtStatus in updatePvtStatusForReleaseOnHold is : "+pvtStatus);                 
                    int statusId = 0;
                    String flag=null;
                  //Updating PvtStatus in PvtHeader table
                    
                    PVTSearchRVOImpl pvtSearchVo= (PVTSearchRVOImpl)this.getPVTSearchRVO2(); 
                    int count = pvtSearchVo.getRowCount();
                    if(pvtSearchVo!=null)
                    {
                        //Getting Pvtheader sequence from Pvt Header table
                        
                          PVTHeaderVOImpl pvtVo= (PVTHeaderVOImpl)this.getPVTHeaderVO1(); 
                        for(int i=0; i<count;i++){
                            PVTSearchRVORowImpl pvtSearchVoRow= (PVTSearchRVORowImpl)pvtSearchVo.getRowSet().getRowAtRangeIndex(i);
                            if(pvtSearchVoRow!=null){
                                BigDecimal pvtHeaderSeq= pvtSearchVoRow.getPVTHDRSEQ();
                                statusId = pvtSearchVoRow.getPVTStatusID();
                                  if(pvtVo!=null)
                                  {
                                      pvtVo.setWhereClause(null);
                                      pvtVo.setWhereClause("PVT_HDR_SEQ = '"+pvtHeaderSeq+"'");
                                      pvtVo.executeQuery();                               
                                      PVTHeaderVORowImpl pvtHdrRow = (PVTHeaderVORowImpl)pvtVo.first();
                                      System.out.println("pvtHeaderSeq ---------------------"+pvtHeaderSeq);                                      
                                      if(pvtHdrRow!=null)
                                      {
                                          pvtHdrRow.setPVTStatusID(pvtStatus);
                                          pvtHdrRow.setUpdatedby(loggerName);
                                          pvtHdrRow.setUpdateddate(sqlDate);
                                      } 
                                //Inserting Notes in PVT Event Details table  
                                      
                                PVTEventDetailsVOImpl eventVO = (PVTEventDetailsVOImpl)this.getPVTEventDetailsVO1();    
                                  eventVO.clearCache();
                                  eventVO.executeEmptyRowSet();
                                  System.out.println("RowCount::::IMpl::::"+eventVO.getRowCount());
                                if(eventVO != null)
                                {
                                    Row eventRow = eventVO.createRow();
                                    eventRow.setAttribute("PVTHDRSEQ",pvtHeaderSeq);
                                    eventRow.setAttribute("Remarks",notesEvent);
                                    if(pvtStatus==4){
                                        eventRow.setAttribute("EVENTID","570"); 
                                    }else{
                                        eventRow.setAttribute("EVENTID","571"); 
                                    }
                                    eventRow.setAttribute("EVENTDATE",sqlDate);
                                    eventRow.setAttribute("CreatedBy",loggerName);
                                    eventRow.setAttribute("CreatedDate",sqlDate);
                                    eventVO.insertRow(eventRow);  
                                }
                              }
                            }                     
                       }                                                
                }
                    if(statusId == pvtStatus){
                        flag = "true";
                        this.getPVTEventDetailsVO1().getDBTransaction().rollback();
                   }else{
                        flag = "false";
                    }
                    
                return flag;
            }


  /**
     *PVT Payments
     * @param pvtNo
     * @return
     */
    public String   getSeqPVTPayMents(String pvtNo) {
          String   pvtHdrSeq= null;
          PVTHeaderVOImpl pvtVo= (PVTHeaderVOImpl)this.getPVTHeaderVO2(); 
          if(pvtVo!=null)
          {
              pvtVo.setWhereClause(null);
              pvtVo.setWhereClause("PVT_Num = '"+pvtNo+"'");
              pvtVo.executeQuery();
              System.out.println("get query..." + pvtVo.getQuery());
              PVTHeaderVORowImpl pvtHdrRow = (PVTHeaderVORowImpl)pvtVo.first();
              setPvtHdrSeq(pvtHdrRow.getPVTHDRSEQ());
               pvtHdrSeq =  pvtHdrRow.getPVTHDRSEQ().toString(); 
          }
         
          return pvtHdrSeq;
      }

      public String doCreatePVTPayment(BigDecimal CustomerId,BigDecimal paidAmt,String encoder, BigDecimal outSatndingAmt,ArrayList pvtNumList)
    {
       java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
       java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
       ViewObjectImpl SalesHeaderVO =this.getSalesHeaderUVO1();               
       ViewObjectImpl SalesSettlementVO = this.getSalesSettlementUVO1();               
       ViewObjectImpl SalesDetailVO = this.getSalesDetailUVO1();

       SalesHeaderVO.clearCache();              
       SalesSettlementVO.clearCache();
       SalesHeaderVO.executeEmptyRowSet();               
       SalesSettlementVO.executeEmptyRowSet();
       SalesDetailVO.clearCache();
       SalesDetailVO.executeEmptyRowSet();
       if(CustomerId == null){
           CustomerId = new BigDecimal(0);
       }
       try
       {
           SalesHeaderUVORowImpl SalesHeaderRow = (SalesHeaderUVORowImpl)SalesHeaderVO.createRow();
           SalesSettlementUVORowImpl salesSettlementRow = (SalesSettlementUVORowImpl)SalesSettlementVO.createRow();
           SalesHeaderVO.insertRow(SalesHeaderRow);
         
           BigDecimal SaleHdrSeq = SalesHeaderRow.getSalehdrseq();
           System.out.println("SaleHdrSeq ---doCreatePVTPayment"+SaleHdrSeq);
           SalesHeaderRow.setAttribute("Instflag",'N');                
           SalesHeaderRow.setAttribute("SaleAmt", paidAmt);
           SalesHeaderRow.setSaledate(sqlDate);
           SalesHeaderRow.setCutomerID(CustomerId);
           SalesHeaderRow.setUSERID("1");
           SalesHeaderRow.setCreatedBy(encoder);
           SalesHeaderRow.setCreatedDate(sqlTime);
           if(pvtNumList!=null){
               for(int i=0;i<pvtNumList.size();i++){
                   SalesDetailUVORowImpl salesDetailRow = (SalesDetailUVORowImpl)SalesDetailVO.createRow();
                   salesDetailRow.setSalehdrseq(SaleHdrSeq);
                   salesDetailRow.setAttribute("Prodcode",5);
                   salesDetailRow.setSaleAmt(new BigDecimal(0));
                   salesDetailRow.setAttribute("DiscAmt",0);
                   salesDetailRow.setActionCode(1); 
                   salesDetailRow.setPVTHDRSEQ(new BigDecimal(pvtNumList.get(i).toString()));//Need to change Type in DB from BigDecimal to String
                   salesDetailRow.setCreatedBy(encoder);
                   salesDetailRow.setCreatedDate(sqlTime);               
                   SalesDetailVO.insertRow(salesDetailRow);
               } 
           }
          
            SalesSettlementVO.insertRow(salesSettlementRow);
            salesSettlementRow.setSalehdrseq(SaleHdrSeq);
            salesSettlementRow.setPYMTAMT(outSatndingAmt);
            salesSettlementRow.setPYMTType("CSH");
            salesSettlementRow.setCreatedBy(encoder);
            salesSettlementRow.setCreatedDate(sqlTime);
     
       }
       catch (Exception e) {
       e.printStackTrace();
           } 
          return null;
    }
//    public void callPoundResidualChargesProc()
//    {
//        CallableStatement stmt = null;
//        PVTHeaderVOImpl vo = (PVTHeaderVOImpl)this.getPVTHeaderVO1();
//        for(int i =0;i<vo.getRowCount() ; i++ ){
//            PVTHeaderVORowImpl rows = (PVTHeaderVORowImpl)vo.getRowAtRangeIndex(i);
//            Boolean checkValue =  rows.getCheckFlagBox();
//                //(Boolean)rows[i].getAttribute("CheckFlagBox");
//            if(checkValue!=null && checkValue) {
//                String pvtNum = rows.getPVTNum();
//                String pvtHdrSeq = (String)getSeqPVTPayMents(pvtNum);
//                Integer pvtHdrSeqInt = Integer.parseInt(pvtHdrSeq);
//                if(pvtHdrSeq != null)
//                {
//                    try {
//                        stmt = getDBTransaction().createCallableStatement("{call  PVT_Populate_Pound_residual_Charges(?) }", 0);
//                        stmt.setInt(1,pvtHdrSeqInt);            
//                        stmt.execute();                                  
//                        
//                    }  catch (Exception e) {
//                        System.out.println("callPoundResidualChargesProc procedure exception : "+e.getMessage());
//                    }  
//                }
//            }
//        }           
//    }
      
      /**
     *PVT PaymentDetails
     * @param pvtHdrSeq
     */
    public void PVTPaymentCallRemovalCharges(BigDecimal pvtHdrSeq)
        {
               CallableStatement stmt = null;
                   try {
                       stmt = getDBTransaction().createCallableStatement("{call  PVT_Populate_Pound_residual_Charges (?) }", 0);
                       stmt.setBigDecimal(1,pvtHdrSeq);           
                      
                       boolean returnValue = stmt.execute(); 
                       System.out.println("returnValue  :::::::::::::           "+returnValue);
               
                   }  catch (Exception e) {
                       System.out.println("callRemovalCharges procedure exception : "+e.getMessage());
                   }   
            System.out.println("Success");    
     }
      


    
    public String CallPaymentProcedure(String PVTNumber,String Amount, java.sql.Date sqlDate, String ReceiptNumber,String Transactionid,String kiosklocation ,String PaymentChannel,String userName)
    {
           CallableStatement stmt = null;
           String statmsg = null;
               try {
                   System.out.println("PVTupdatePaymentDetails  ::::::::: pvtHdrSeq   :::::::::"+pvtHdrSeq);
                   System.out.println(Amount);
                  Float PVTPaidAmountFloat = Float.parseFloat(Amount);
                    BigDecimal   PVTPaidAmountBig = new BigDecimal(Amount);
                   java.sql.Timestamp timestampdate = new java.sql.Timestamp(sqlDate.getTime());
                   java.sql.Timestamp sqlcurrentdate = new java.sql.Timestamp(new java.util.Date().getTime());
                   
                   stmt = getDBTransaction().createCallableStatement("{call  Esys_Pvt_Pymt_Ins(?,?,?,?,?,?,?,?,?) }", 0);
                   stmt.setString(1,PVTNumber);
                   stmt.setFloat(2, PVTPaidAmountFloat);  
                   stmt.setDate(3,sqlDate); 
                    stmt.setString(4,ReceiptNumber); 
                       stmt.setString(5,Transactionid); 
                       stmt.setString(6,kiosklocation); 
                       stmt.setString(7,PaymentChannel); 
                   stmt.registerOutParameter(8, Types.VARCHAR);
                   stmt.registerOutParameter(9, Types.VARCHAR);
             stmt.execute(); 
                   String statcode = stmt.getString(8);
                    statmsg = stmt.getString(9);
                   PVTPaymentLogUVOImpl PVTPaymentvo = (PVTPaymentLogUVOImpl)this.getPVTPaymentLogUVO1();
                   PVTPaymentLogUVORowImpl pvtPaymentrow =(PVTPaymentLogUVORowImpl) PVTPaymentvo.createRow();
                   
                   pvtPaymentrow.setTrnnumber(PVTNumber);
                   pvtPaymentrow.setPaidAmt(PVTPaidAmountBig);
                   pvtPaymentrow.setpaymentDate(timestampdate);
                   pvtPaymentrow.setreceiptNum(ReceiptNumber);
                   pvtPaymentrow.setpymtreference(kiosklocation);
                   pvtPaymentrow.setEsyspymtdate(sqlcurrentdate);
                   pvtPaymentrow.setpymtChannel(PaymentChannel);
                   pvtPaymentrow.setresponsecode(statcode);
                   pvtPaymentrow.setresponsemessage(statmsg);
                   pvtPaymentrow.setCreatedDate(sqlcurrentdate);
                   pvtPaymentrow.setBpelProcessId(Transactionid);
                     pvtPaymentrow.setCreatedBy(userName);
                   if(statcode == null ||(statcode.equals(180 )))
                   pvtPaymentrow.setresponsemessage("Success");
                
                   else
                       pvtPaymentrow.setresponsemessage("Fatal");  
                   
                   PVTPaymentvo.insertRow(pvtPaymentrow);
                   
                   getDBTransaction().commit();
                   
                   //return statmsg;
                   
                   //System.out.println("PVTupdatePaymentDetails  :::::::::::::           "+returnValue);
           
               }  catch (Exception e) {
                   //System.out.println("PVTupdatePaymentDetails procedure exception : "+e.getMessage());
               }   
        return statmsg;
    }
    
    public void PRMentryEventDetails(String oldpayment,String newpayment,String permitnumber,String loggedinuser)
    {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        ViewObjectImpl permiteventvo = this.getPermitEventUVO1(); 
        
        PermitEventUVORowImpl permitrow = (PermitEventUVORowImpl)permiteventvo.createRow();
        permitrow.setNewRowState(Row.STATUS_INITIALIZED);
        permitrow.setCreatedBy(loggedinuser);
        permitrow.setCreatedDate(sqlDate);
        permitrow.setEVENTDATE(sqlDate);
        permitrow.setEVENTID(new BigDecimal(516));
        permitrow.setBalanceAmt(new BigDecimal(0));
        permitrow.setEventAmt(new BigDecimal(0));
        permitrow.setPRMHeaderseq(new BigDecimal(permitnumber));
        permitrow.setRemarks("old payment details:"+oldpayment+"new payment details"+newpayment);
        permiteventvo.insertRow(permitrow);
        
        
        
        
    }
    public void CreateNewRemarks(String username,String remarks,BigDecimal PvthdrSeqBD)
    {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        ViewObjectImpl pvteventvo = this.getPVTEventDetailsVO1();
        Row pvtrow = pvteventvo.createRow();
        pvtrow.setNewRowState(Row.STATUS_INITIALIZED);
        pvtrow.setAttribute("CreatedBy",username);
        pvtrow.setAttribute("CreatedDate",sqlDate);
        pvtrow.setAttribute("EVENTDATE",sqlDate);
        pvtrow.setAttribute("EVENTID","99");
        pvtrow.setAttribute("PVTHDRSEQ",PvthdrSeqBD);
        pvtrow.setAttribute("Remarks",remarks);
        pvteventvo.insertRow(pvtrow);
    }
    
    public void CreateNewPVTDocument(String username,String fullPath,BigDecimal  pvtHdrseq,String doctype,String DOCDesc)
    {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        ViewObjectImpl pvtdocsvo = this.getPVTDocsVO1();
        Row pvtDocsRow = pvtdocsvo.createRow();
        pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
        pvtDocsRow.setAttribute("CreatedBy",username);
        pvtDocsRow.setAttribute("CreatedDate",sqlDate);
        pvtDocsRow.setAttribute("filepath",fullPath);
        pvtDocsRow.setAttribute("Docstage",3);
        pvtDocsRow.setAttribute("PVTHDRSEQ",pvtHdrseq);
        pvtDocsRow.setAttribute("deleteflag","N");
        pvtDocsRow.setAttribute("doctype",doctype);
        pvtDocsRow.setAttribute("DOCDesc",DOCDesc);
        pvtdocsvo.insertRow(pvtDocsRow);
        
       
    }
    
    public void PVTentryEventDetails(String oldpayment,String newpayment,String PVTNumber,String loggedinuser)
    {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
       ViewObjectImpl pvteventvo = this.getPVTEventDetailsVO1();
        Row pvtrow = pvteventvo.createRow();
        pvtrow.setNewRowState(Row.STATUS_INITIALIZED);
        pvtrow.setAttribute("CreatedBy",loggedinuser);
        pvtrow.setAttribute("CreatedDate",sqlDate);
        pvtrow.setAttribute("EVENTDATE",sqlDate);
        pvtrow.setAttribute("EVENTID","587");
       
        pvtrow.setAttribute("PVTHDRSEQ",new BigDecimal(PVTNumber));
        pvtrow.setAttribute("Remarks","old payment details:"+oldpayment+"new payment details"+newpayment);
        pvteventvo.insertRow(pvtrow);
        
        
        
        
    }
    
    public void CARDentryEventDetails(String oldpayment,String newpayment,String cardnumber,String loggedinuser)
    {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        ViewObjectImpl inveventvo =this.getInvEventDetailsUVO1();
          InvEventDetailsUVORowImpl invrow = (  InvEventDetailsUVORowImpl)inveventvo.createRow();
        invrow.setNewRowState(Row.STATUS_INITIALIZED);
        invrow.setCreatedBy(loggedinuser);
        invrow.setCreatedDate(sqlDate);
        invrow.setEVENTDATE(sqlDate);
        invrow.setEVENTID(new BigDecimal(634));
        invrow.setBalanceAmt(new BigDecimal(0));
        BigDecimal invdetailseq  = null;
        InvDetailUVOImpl detailUVO1 = (InvDetailUVOImpl)this.getInvDetailUVO1();
        ViewObjectImpl invpayVO = this.getPaymentsINVO1();
        invpayVO.setWhereClause(null);
        invpayVO.setWhereClause(null);
        invpayVO.setWhereClause(" Card_num = '"+cardnumber+"'");
        
        invpayVO.executeQuery();
        Row payinvrow = invpayVO.first();
        if(payinvrow != null) {
            try{
                invdetailseq = (BigDecimal)payinvrow.getAttribute("InvDetailSeq");
                invrow.setInvDetailSeq(invdetailseq);
                
            }
            catch (Exception e) {
                                   System.out.println("error in converting: "+e.getMessage());
                               }
            
          
        }
        
//        if(detailUVO1 != null)
//        {
//        Row[] filteredrows= detailUVO1.getFilteredRows("Cardnum",cardnumber);
//      
//        if(filteredrows.length>0) 
//        {
//            Row firstRow = filteredrows[0];
//            invdetailseq = (BigDecimal)firstRow.getAttribute("InvDetailSeq");
//        }
//        }
        invrow.setEventAmt(new BigDecimal(0));
       
        
        invrow.setRemarks("old payment details:"+oldpayment+"new payment details"+newpayment);
        inveventvo.insertRow(invrow);
        
        
        
        
    }
    
    
    public String SearchReceiptNumber(String receiptNumber) 
    {
        SalesHeaderUVOImpl salehdrvo = (SalesHeaderUVOImpl)this.getSalesHeaderUVO1();
     //   int countf= salehdrvo.getRowCount();
        BigDecimal saleseq = null;
       // Row[] filteredRows = salehdrvo.getFilteredRows("ReceiptNum",receiptNumber);
        
//        if(filteredRows.length > 0) 
//        {
//            Row firstRow = filteredRows[0];
//            if(firstRow != null) {
//                try 
//                {
//                    saleseq = new BigDecimal(firstRow.getAttribute("Salehdrseq").toString());
//                }
//                catch (Exception e) {
//                                       System.out.println("error in converting: "+e.getMessage());
//                                   }
       
                salehdrvo.setWhereClause(null);
                salehdrvo.setWhereClauseParams(null);
                salehdrvo.setWhereClause(" Receipt_Num = '"+receiptNumber+"'");
                
                salehdrvo.executeQuery();
                
                if(salehdrvo != null) 
                {
                   SalesHeaderUVORowImpl salesrow =(SalesHeaderUVORowImpl) salehdrvo.first();
                  if(salesrow != null)
                  {
//                    try 
//                                    {
//                                        saleseq = new BigDecimal(salesrow.getAttribute("Salehdrseq").toString());
//                                    }
//                                    catch (Exception e) {
//                                                           System.out.println("error in converting: "+e.getMessage());
//                                                       }
//                    System.out.println(saleseq);
                   
                
                SaleReceiptDetailVOImpl saledtlvo = (SaleReceiptDetailVOImpl)this.getSaleReceiptDetailVO1();
//                saledtlvo.setWhereClause(null);
//                saledtlvo.setWhereClauseParams(null);
//                saledtlvo.setWhereClause("Sale_hdr_seq = '"+saleseq+"'");
//                saledtlvo.executeQuery();
                
                                      saledtlvo.setWhereClause(null);
                                      saledtlvo.setWhereClauseParams(null);
                                      saledtlvo.setWhereClause("Sale_hdr_seq in (select Sale_hdr_seq from SLT_Sales_header where Receipt_Num='"+receiptNumber+"')");
                                      System.out.println(saledtlvo.getQuery());
                       saledtlvo.executeQuery();
               // int count = saledtlvo.getRowCount();
               
                saleReceiptSettlVOImpl salestlvo = (saleReceiptSettlVOImpl)this.getsaleReceiptSettlVO1();
                salestlvo.setWhereClause(null);
                salestlvo.setWhereClauseParams(null);
                salestlvo.setWhereClause("Sale_hdr_seq in (select Sale_hdr_seq from SLT_Sales_header where Receipt_Num='"+receiptNumber+"')");
                salestlvo.executeQuery();
                   }
                 
                    else 
                    {
                        return "norows";
                    }
                }
        
           // }
               
        
       
        
       return "rows";
        
    }
   
      
        public void PVTupdatePaymentDetails(BigDecimal pvtHdrSeq,BigDecimal payableAmt)
        {
               CallableStatement stmt = null;
                   try {
                       System.out.println("PVTupdatePaymentDetails  ::::::::: pvtHdrSeq   :::::::::"+pvtHdrSeq);
                       System.out.println("PVTupdatePaymentDetails  ::::::::: payableAmt   :::::::::"+payableAmt);
                       
                       stmt = getDBTransaction().createCallableStatement("{call  PVT_UPDATE_PAYMENT_DTL(?,?) }", 0);
                       stmt.setBigDecimal(1,pvtHdrSeq);    
                       stmt.setBigDecimal(2,payableAmt); 
                      
                       boolean returnValue = stmt.execute(); 
                       System.out.println("PVTupdatePaymentDetails  :::::::::::::           "+returnValue);
               
                   }  catch (Exception e) {
                       System.out.println("PVTupdatePaymentDetails procedure exception : "+e.getMessage());
                   }   
            System.out.println("Success");    
        }

        public void uploadPvtDocsPVTPayments(String encoder, ArrayList uploadFiles,BigDecimal pvtHdrseq)
        {
            ViewObjectImpl vo = getPVTDocsVO1();
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            System.out.println("sqlDate in uploadPvtDocs is : "+sqlDate);
            int documentStage=7; //Bay Number
            if(vo != null && null != uploadFiles)
            {
                for(int i=0;i<uploadFiles.size(); i++)
                {
                Row pvtDocsRow = vo.createRow();
                int extType1;
                extType1 = getFileExtension((String)uploadFiles.get(i));
                pvtDocsRow.setAttribute("CreatedBy",encoder);
                pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                pvtDocsRow.setAttribute("filepath",uploadFiles.get(i));
                pvtDocsRow.setAttribute("Docstage",documentStage);
                pvtDocsRow.setAttribute("PVTHDRSEQ",pvtHdrseq);
                pvtDocsRow.setAttribute("deleteflag","N");
                pvtDocsRow.setAttribute("doctype",extType1);
                vo.insertRow(pvtDocsRow);
                }
            }
        }
        
      

   //for PVT Paymets        
     public void createNewRowDocUploadReleaseVehicle(String encoder){
                ViewObjectImpl pvtDocs = getPVTDocsVO1();
                pvtDocs.clearCache();
                pvtDocs.executeEmptyRowSet();
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                ViewObjectImpl pounddocVO = getpoundReleasVO1();
                RowSetIterator rsi=pounddocVO.createRowSetIterator(null);

                while(rsi.hasNext()) {
                    Row docrow=rsi.next();
                    Row pvtDocsRow = pvtDocs.createRow(); 
                    pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
                    pvtDocsRow.setAttribute("CreatedBy",encoder);
                    pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                    pvtDocsRow.setAttribute("DOCDesc",docrow.getAttribute("DocDesc"));
                    pvtDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
                    pvtDocs.insertRow(pvtDocsRow); 
                }
         
         
//                    int documentStage=7;
//                    if(pvtDocs!=null) {
//                            Row pvtDocsRow = pvtDocs.createRow(); 
//                            pvtDocsRow.setAttribute("CreatedBy",encoder);
//                            pvtDocs.insertRow(pvtDocsRow);   
//                    }
               // Clearing Previously queried records(PVTSearch)
//                this.getPoundBayDetailVO1().clearCache();
//                this.getPoundBayDetailVO1().setWhereClause(null);
//                this.getPoundBayDetailVO1().applyViewCriteria(null);
//                this.getPoundBayDetailVO1().executeQuery();

            }
    public void createNewRowDocUpload(String encoder){
               ViewObjectImpl pvtDocs = getPVTDocsVO1();
               pvtDocs.clearCache();
               pvtDocs.executeEmptyRowSet();
               java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
               ViewObjectImpl pounddocVO = getPoundDocVO1();
               RowSetIterator rsi=pounddocVO.createRowSetIterator(null);

               while(rsi.hasNext()) {
                   Row docrow=rsi.next();
                   Row pvtDocsRow = pvtDocs.createRow(); 
                   //pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
                   pvtDocsRow.setAttribute("CreatedBy",encoder);
                   pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                   pvtDocsRow.setAttribute("DOCDesc",docrow.getAttribute("DocDesc"));
                   pvtDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
                   pvtDocs.insertRow(pvtDocsRow); 
               }
        
        
    //                    int documentStage=7;
    //                    if(pvtDocs!=null) {
    //                            Row pvtDocsRow = pvtDocs.createRow();
    //                            pvtDocsRow.setAttribute("CreatedBy",encoder);
    //                            pvtDocs.insertRow(pvtDocsRow);
    //                    }
              // Clearing Previously queried records(PVTSearch)
    //                this.getPoundBayDetailVO1().clearCache();
    //                this.getPoundBayDetailVO1().setWhereClause(null);
    //                this.getPoundBayDetailVO1().applyViewCriteria(null);
    //                this.getPoundBayDetailVO1().executeQuery();

           }
    
    
    
    public void createNewRowDocUploadFree(String encoder){
        ViewObjectImpl pvtDocs = getPVTDocsVO1();
        pvtDocs.clearCache();
        pvtDocs.executeEmptyRowSet();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        ViewObjectImpl pounddocVO = getPoundFreeDocVO1();
        RowSetIterator rsi=pounddocVO.createRowSetIterator(null);

        while(rsi.hasNext()) {
            Row docrow=rsi.next();
            Row pvtDocsRow = pvtDocs.createRow(); 
            //pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
            pvtDocsRow.setAttribute("CreatedBy",encoder);
            pvtDocsRow.setAttribute("CreatedDate",sqlDate);
            pvtDocsRow.setAttribute("DOCDesc",docrow.getAttribute("DocDesc"));
            pvtDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
            pvtDocs.insertRow(pvtDocsRow); 
        }
    }
    public void createDocUploadPoundAlloc(String encoder){
               ViewObjectImpl pvtDocs = getPVTDocsVO1();
               java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
               int flag = 0;
               for(Row row : pvtDocs.getAllRowsInRange())
               {
                    ViewRowImpl rowEn = (ViewRowImpl)row;       
                    byte entityState = rowEn.getEntity(0).getEntityState();
                    if(entityState==rowEn.STATUS_INITIALIZED || entityState==0)
                    {
                        flag = flag+1;    
                    }
                }
               if(flag==0)
               {
                    pvtDocs.clearCache();    
                    pvtDocs.executeEmptyRowSet();
                    
                    int documentStage=7;
                    
                    if(pvtDocs!=null) {
                        //doc master PoundDocVO
                        
                        ViewObjectImpl pounddocVO = getPoundDocVO1();
                        RowSetIterator rsi=pounddocVO.createRowSetIterator(null);

                        while(rsi.hasNext()) {
                            Row docrow=rsi.next();
                            
                            Row pvtDocsRow = pvtDocs.createRow(); 
                            pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
                            pvtDocsRow.setAttribute("CreatedBy",encoder);
                            pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                            pvtDocsRow.setAttribute("DOCDesc",docrow.getAttribute("DocDesc"));
                            pvtDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
                            pvtDocs.insertRow(pvtDocsRow); 
                        }
                        
                           
                            
                    }           
                }
               //Clearing Previously queried records(PVTSearch)
               this.getPoundBayDetailVO1().clearCache();
               this.getPoundBayDetailVO1().setWhereClause(null);
               this.getPoundBayDetailVO1().applyViewCriteria(null);
               this.getPoundBayDetailVO1().executeQuery();
               ViewObjectImpl PVTSearchRVO = getPVTSearchRVO2();
               PVTSearchRVO.applyViewCriteria(null);
               
               VariableValueManager evm= PVTSearchRVO.ensureVariableManager();
               evm.clearValue("bindPVTNumber"); 
               if(evm.getVariableValue("bindPVTNumber")==null ) System.out.println("null value found for bindPVTNumber");
               else System.out.println("bindPVTNumber : "+evm.getVariableValue("bindPVTNumber").toString());
//               PVTSearchRVO.executeQuery();
               
               
               
               

           }
            
        public void addUploadDoc(String encoder){
                   
                   ViewObjectImpl pvtDocs = getPVTDocsVO1();
                   java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                   int documentStage=7;
                   if(pvtDocs!=null) {
                       Row pvtDocsRow = pvtDocs.createRow(); 
                       pvtDocsRow.setAttribute("CreatedBy",encoder);
                       pvtDocs.insertRow(pvtDocsRow);
                   }
               }    
          
        
      
      public void executeEmptyRowHeaderVO() {
          ViewObject headerVO = this.getPVTDiscCnclHeaderVO1();
          headerVO.clearCache();
          
          Row createRow = headerVO.createRow();
          headerVO.insertRow(createRow);
      }
      
        public void updateRollbackDiscountStatus(String userName, int rollbackDiscountSeq){
            PreparedStatement preparedStatement = null;
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            try {
                String sql = "UPDATE pvt_disc_cncl_header SET disc_cncl_status = 6, updated_by='"+userName+"', updated_date='"+sqlDate+"' WHERE disc_cncl_hdr_seq = "+rollbackDiscountSeq;
                preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
                preparedStatement.executeUpdate();           
            }  catch (Exception e) {
                e.printStackTrace();
            }
            getDBTransaction().commit();
        }
      
      
    /**
     * Container's getter for BulkCardsCustomerTypeVO1.
     * @return BulkCardsCustomerTypeVO1
     */
    public ViewObjectImpl getBulkCardsCustomerTypeVO1() {
        return (ViewObjectImpl)findViewObject("BulkCardsCustomerTypeVO1");
    }

    /**
     * Container's getter for BulkCardsCustomerVO1.
     * @return BulkCardsCustomerVO1
     */
    public ViewObjectImpl getBulkCardsCustomerVO1() {
        return (ViewObjectImpl)findViewObject("BulkCardsCustomerVO1");
    }

    /**
     * Container's getter for BulkcardsCustTypeLOVVO1.
     * @return BulkcardsCustTypeLOVVO1
     */
    public ViewObjectImpl getBulkcardsCustTypeLOVVO1() {
        return (ViewObjectImpl)findViewObject("BulkcardsCustTypeLOVVO1");
    }

    /**
     * Container's getter for BulkCardsInstVO1.
     * @return BulkCardsInstVO1
     */
    public BulkCardsInstVOImpl getBulkCardsInstVO1() {
        return (BulkCardsInstVOImpl)findViewObject("BulkCardsInstVO1");
    }

    /**
     * Container's getter for BulkcardsTypeLOVVO1.
     * @return BulkcardsTypeLOVVO1
     */
    public ViewObjectImpl getBulkcardsTypeLOVVO1() {
        return (ViewObjectImpl)findViewObject("BulkcardsTypeLOVVO1");
    }

    /**
     * Container's getter for BulkCreditTypeLOVVO1.
     * @return BulkCreditTypeLOVVO1
     */
    public ViewObjectImpl getBulkCreditTypeLOVVO1() {
        return (ViewObjectImpl)findViewObject("BulkCreditTypeLOVVO1");
    }

    /**
     * Container's getter for CardIssueSrchCriVO1.
     * @return CardIssueSrchCriVO1
     */
    public CardIssueSrchCriVOImpl getCardIssueSrchCriVO1() {
        return (CardIssueSrchCriVOImpl)findViewObject("CardIssueSrchCriVO1");
    }

    /**
     * Container's getter for CardLocationLOVVO1.
     * @return CardLocationLOVVO1
     */
    public ViewObjectImpl getCardLocationLOVVO1() {
        return (ViewObjectImpl)findViewObject("CardLocationLOVVO1");
    }

    /**
     * Container's getter for CardsInputFieldsVO1.
     * @return CardsInputFieldsVO1
     */
    public CardsInputFieldsVOImpl getCardsInputFieldsVO1() {
        return (CardsInputFieldsVOImpl)findViewObject("CardsInputFieldsVO1");
    }

    /**
     * Container's getter for CardTypeLOVVO1.
     * @return CardTypeLOVVO1
     */
    public ViewObjectImpl getCardTypeLOVVO1() {
        return (ViewObjectImpl)findViewObject("CardTypeLOVVO1");
    }

    /**
     * Container's getter for DenominationLOVVO1.
     * @return DenominationLOVVO1
     */
    public ViewObjectImpl getDenominationLOVVO1() {
        return (ViewObjectImpl)findViewObject("DenominationLOVVO1");
    }

    /**
     * Container's getter for ExcessDamageLOVVO1.
     * @return ExcessDamageLOVVO1
     */
    public ViewObjectImpl getExcessDamageLOVVO1() {
        return (ViewObjectImpl)findViewObject("ExcessDamageLOVVO1");
    }


    /**
     * Container's getter for InventoryStockUploadDetailsVO1.
     * @return InventoryStockUploadDetailsVO1
     */
    public ViewObjectImpl getInventoryStockUploadDetailsVO1() {
        return (ViewObjectImpl)findViewObject("InventoryStockUploadDetailsVO1");
    }

    /**
     * Container's getter for InventoryStockUploadUVO1.
     * @return InventoryStockUploadUVO1
     */
    public ViewObjectImpl getInventoryStockUploadUVO1() {
        return (ViewObjectImpl)findViewObject("InventoryStockUploadUVO1");
    }

    /**
     * Container's getter for ParkingCardTypesUVO1.
     * @return ParkingCardTypesUVO1
     */
    public ParkingCardTypesUVOImpl getParkingCardTypesUVO1() {
        return (ParkingCardTypesUVOImpl)findViewObject("ParkingCardTypesUVO1");
    }

    /**
     * Container's getter for PaymentTypeLOVVO1.
     * @return PaymentTypeLOVVO1
     */
    public ViewObjectImpl getPaymentTypeLOVVO1() {
        return (ViewObjectImpl)findViewObject("PaymentTypeLOVVO1");
    }

    /**
     * Container's getter for SalesDetailUVO1.
     * @return SalesDetailUVO1
     */
    public SalesDetailUVOImpl getSalesDetailUVO1() {
        return (SalesDetailUVOImpl)findViewObject("SalesDetailUVO1");
    }

    /**
     * Container's getter for SalesHeaderUVO1.
     * @return SalesHeaderUVO1
     */
    public SalesHeaderUVOImpl getSalesHeaderUVO1() {
        return (SalesHeaderUVOImpl)findViewObject("SalesHeaderUVO1");
    }

    /**
     * Container's getter for SalesSettlementUVO1.
     * @return SalesSettlementUVO1
     */
    public SalesSettlementUVOImpl getSalesSettlementUVO1() {
        return (SalesSettlementUVOImpl)findViewObject("SalesSettlementUVO1");
    }

    /**
     * Container's getter for StckRetAckVO1.
     * @return StckRetAckVO1
     */
    public StckRetAckVOImpl getStckRetAckVO1() {
        return (StckRetAckVOImpl)findViewObject("StckRetAckVO1");
    }

    /**
     * Container's getter for PaymetReceiptVO1.
     * @return PaymetReceiptVO1
     */
    public ViewObjectImpl getPaymetReceiptVO1() {
        return (ViewObjectImpl)findViewObject("PaymetReceiptVO1");
    }

    /**
     * Container's getter for BulkCardtypeStaticLOVVO1.
     * @return BulkCardtypeStaticLOVVO1
     */
    public ViewObjectImpl getBulkCardtypeStaticLOVVO1() {
        return (ViewObjectImpl)findViewObject("BulkCardtypeStaticLOVVO1");
    }

    /**
     * Container's getter for StockUploadErrorVO1.
     * @return StockUploadErrorVO1
     */
    public ViewObjectImpl getStockUploadErrorVO1() {
        return (ViewObjectImpl)findViewObject("StockUploadErrorVO1");
    }

    /**
     * Container's getter for IssReturnHdrUVO1.
     * @return IssReturnHdrUVO1
     */
    public IssReturnHdrUVOImpl getIssReturnHdrUVO1() {
        return (IssReturnHdrUVOImpl)findViewObject("IssReturnHdrUVO1");
    }

    /**
     * Container's getter for IssReturnDtlUVO1.
     * @return IssReturnDtlUVO1
     */
    public IssReturnDtlUVOImpl getIssReturnDtlUVO1() {
        return (IssReturnDtlUVOImpl)findViewObject("IssReturnDtlUVO1");
    }

    /**
     * Container's getter for InvDetailUVO1.
     * @return InvDetailUVO1
     */
    public InvDetailUVOImpl getInvDetailUVO1() {
        return (InvDetailUVOImpl)findViewObject("InvDetailUVO1");
    }

    /**
     * Container's getter for CardTypeMstUVO1.
     * @return CardTypeMstUVO1
     */
    public ViewObjectImpl getCardTypeMstUVO1() {
        return (ViewObjectImpl)findViewObject("CardTypeMstUVO1");
    }

    /**
     * Container's getter for CardTypeMstUVO2.
     * @return CardTypeMstUVO2
     */
    public ViewObjectImpl getCardTypeMstUVO2() {
        return (ViewObjectImpl)findViewObject("CardTypeMstUVO2");
    }

    /**
     * Container's getter for PVTIssuanceVO1.
     * @return PVTIssuanceVO1
     */
    public PVTIssuanceVOImpl getPVTIssuanceVO1() {
        return (PVTIssuanceVOImpl)findViewObject("PVTIssuanceVO1");
    }
    
    public int checkPVTNumberExists(String pvtNumber)
    {
        int pvtCount = 0;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "select count(pvt_num) as count from PVT_header where pvt_num = '"+pvtNumber+"'";
            preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
            ResultSet resultSet =  preparedStatement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    pvtCount = resultSet.getInt(1);
                    System.out.println("Count of existing pvts..." + pvtCount);
                } 
            }
        }  catch (Exception e) {
            System.out.println("Exception while fetching exists PVT number : " + e.getMessage());
        }
        return pvtCount;
    }

    /**
     * Container's getter for VehicleColourLOVVO1.
     * @return VehicleColourLOVVO1
     */
    public ViewObjectImpl getVehicleColourLOVVO1() {
        return (ViewObjectImpl)findViewObject("VehicleColourLOVVO1");
    }

    /**
     * Container's getter for VehicleMakeLOVVO1.
     * @return VehicleMakeLOVVO1
     */
    public ViewObjectImpl getVehicleMakeLOVVO1() {
        return (ViewObjectImpl)findViewObject("VehicleMakeLOVVO1");
    }

    /**
     * Container's getter for VehicleModelLOVVO1.
     * @return VehicleModelLOVVO1
     */
    public ViewObjectImpl getVehicleModelLOVVO1() {
        return (ViewObjectImpl)findViewObject("VehicleModelLOVVO1");
    }

    /**
     * Container's getter for PlateCategoryLOVVO1.
     * @return PlateCategoryLOVVO1
     */
    public ViewObjectImpl getPlateCategoryLOVVO1() {
        return (ViewObjectImpl)findViewObject("PlateCategoryLOVVO1");
    }

    /**
     * Container's getter for PlateTypeLOVVO1.
     * @return PlateTypeLOVVO1
     */
    public ViewObjectImpl getPlateTypeLOVVO1() {
        return (ViewObjectImpl)findViewObject("PlateTypeLOVVO1");
    }

    /**
     * Container's getter for PVTDiscCnclHeaderVO1.
     * @return PVTDiscCnclHeaderVO1
     */
    public ViewObjectImpl getPVTDiscCnclHeaderVO1() {
        return (ViewObjectImpl)findViewObject("PVTDiscCnclHeaderVO1");
    }

    /**
     * Container's getter for PVTDiscCnclDetailVO1.
     * @return PVTDiscCnclDetailVO1
     */
    public ViewObjectImpl getPVTDiscCnclDetailVO1() {
        return (ViewObjectImpl)findViewObject("PVTDiscCnclDetailVO1");
    }

    /**
     * Container's getter for PVTStageLOVVO1.
     * @return PVTStageLOVVO1
     */
    public ViewObjectImpl getPVTStageLOVVO1() {
        return (ViewObjectImpl)findViewObject("PVTStageLOVVO1");
    }

    /**
     * Container's getter for PVTStatusLOVVO1.
     * @return PVTStatusLOVVO1
     */
    public ViewObjectImpl getPVTStatusLOVVO1() {
        return (ViewObjectImpl)findViewObject("PVTStatusLOVVO1");
    }

    /**
     * Container's getter for ZoneLOVVO1.
     * @return ZoneLOVVO1
     */
    public ViewObjectImpl getZoneLOVVO1() {
        return (ViewObjectImpl)findViewObject("ZoneLOVVO1");
    }

    /**
         * Container's getter for PVTDocsVO1.
         * @return PVTDocsVO1
         */
        public ViewObjectImpl getPVTDocsVO1() {
            return (ViewObjectImpl)findViewObject("PVTDocsVO1");
        }

        /**
         * Container's getter for PoundBayDetailVO1.
         * @return PoundBayDetailVO1
         */
        public ViewObjectImpl getPoundBayDetailVO1() {
            return (ViewObjectImpl)findViewObject("PoundBayDetailVO1");
        }


        /**
         * Container's getter for PVTHeaderVO1.
         * @return PVTHeaderVO1
         */
        public ViewObjectImpl getPVTHeaderVO1() {
            return (ViewObjectImpl)findViewObject("PVTHeaderVO1");
        }

        /**
         * Container's getter for BayNumberLVO1.
         * @return BayNumberLVO1
         */
        public BayNumberLVOImpl getBayNumberLVO1() {
            return (BayNumberLVOImpl)findViewObject("BayNumberLVO1");
        }



    public void setPvtHdrSeq(BigDecimal pvtHdrSeq) {
        this.pvtHdrSeq = pvtHdrSeq;
    }

    public BigDecimal getPvtHdrSeq() {
        System.out.println("pvtHdrSeq in PoundBayAlloc is : "+pvtHdrSeq);
        return pvtHdrSeq;
    }


    /**
     * Container's getter for PVTPhotoRVO1.
     * @return PVTPhotoRVO1
     */
    public ViewObjectImpl getPVTPhotoRVO1() {
        return (ViewObjectImpl)findViewObject("PVTPhotoRVO1");
    }

    /**
     * Container's getter for PVTObservationRVO1.
     * @return PVTObservationRVO1
     */
    public ViewObjectImpl getPVTObservationRVO1() {
        return (ViewObjectImpl)findViewObject("PVTObservationRVO1");
    }

    /**
     * Container's getter for CustomerIndividualUVO1.
     * @return CustomerIndividualUVO1
     */
    public CustomerIndividualUVOImpl getCustomerIndividualUVO1() {
        return (CustomerIndividualUVOImpl)findViewObject("CustomerIndividualUVO1");
    }

    /**
     * Container's getter for CustomerInstitutionVO1.
     * @return CustomerInstitutionVO1
     */
    public CustomerInstitutionVOImpl getCustomerInstitutionVO1() {
        return (CustomerInstitutionVOImpl)findViewObject("CustomerInstitutionVO1");
    }

    /**
     * Container's getter for PVTStatusHoldRelLVO1.
     * @return PVTStatusHoldRelLVO1
     */
    public ViewObjectImpl getPVTStatusHoldRelLVO1() {
        return (ViewObjectImpl)findViewObject("PVTStatusHoldRelLVO1");
    }


    /**
     * Container's getter for PVTDiscountHeaderSearchVO1.
     * @return PVTDiscountHeaderSearchVO1
     */
    public PVTDiscountHeaderSearchVOImpl getPVTDiscountHeaderSearchVO1() {
        return (PVTDiscountHeaderSearchVOImpl)findViewObject("PVTDiscountHeaderSearchVO1");
    }


    /**
     * Container's getter for PVTChargeDetailRVO1.
     * @return PVTChargeDetailRVO1
     */
    public ViewObjectImpl getPVTChargeDetailRVO1() {
        return (ViewObjectImpl)findViewObject("PVTChargeDetailRVO1");
    }


    /**
     * Container's getter for PVTDiscountHeaderSeqVO1.
     * @return PVTDiscountHeaderSeqVO1
     */
    public PVTDiscountHeaderSeqVOImpl getPVTDiscountHeaderSeqVO1() {
        return (PVTDiscountHeaderSeqVOImpl)findViewObject("PVTDiscountHeaderSeqVO1");
    }

    /**
     * Container's getter for PVTSearchRVO1.
     * @return PVTSearchRVO1
     */
    public PVTSearchRVOImpl getPVTSearchRVO1() {
        return (PVTSearchRVOImpl)findViewObject("PVTSearchRVO1");
    }

    /**
     * Container's getter for PVTSearchRVO2.
     * @return PVTSearchRVO2
     */
    public PVTSearchRVOImpl getPVTSearchRVO2() {
        return (PVTSearchRVOImpl)findViewObject("PVTSearchRVO2");
    }

    /**
     * Container's getter for ContraventionMstUVO1.
     * @return ContraventionMstUVO1
     */
    public ContraventionMstUVOImpl getContraventionMstUVO1() {
        return (ContraventionMstUVOImpl)findViewObject("ContraventionMstUVO1");
    }

    /**
     * Container's getter for VehiclePlateCategoryVO1.
     * @return VehiclePlateCategoryVO1
     */
    public ViewObjectImpl getVehiclePlateCategoryVO1() {
        return (ViewObjectImpl)findViewObject("VehiclePlateCategoryVO1");
    }
/**
     * Container's getter for PVTHeaderVO2.
     * @return PVTHeaderVO2
     */
    public PVTHeaderVOImpl getPVTHeaderVO2() {
        return (PVTHeaderVOImpl)findViewObject("PVTHeaderVO2");
    }

    /**
     * Container's getter for PVTTariffTypesLOVVO1.
     * @return PVTTariffTypesLOVVO1
     */
    public PVTTariffTypesLOVVOImpl getPVTTariffTypesLOVVO1() {
        return (PVTTariffTypesLOVVOImpl)findViewObject("PVTTariffTypesLOVVO1");
    }

  /**
     * Container's getter for PvtHeaderPaySuperVisorUVO1.
     * @return PvtHeaderPaySuperVisorUVO1
     */
    public PvtHeaderPaySuperVisorUVOImpl getPvtHeaderPaySuperVisorUVO1() {
        return (PvtHeaderPaySuperVisorUVOImpl)findViewObject("PvtHeaderPaySuperVisorUVO1");
    }


    /**
     * Container's getter for PVTCategorizedChargesRVO1.
     * @return PVTCategorizedChargesRVO1
     */
    public ViewObjectImpl getPVTCategorizedChargesRVO1() {
        return (ViewObjectImpl)findViewObject("PVTCategorizedChargesRVO1");
    }

    /**
     * Container's getter for CardCtgMstRVO1.
     * @return CardCtgMstRVO1
     */
    public CardCtgMstRVOImpl getCardCtgMstRVO1() {
        return (CardCtgMstRVOImpl)findViewObject("CardCtgMstRVO1");
    }
    /**
     * Container's getter for PVTReceiptRVO1.
     * @return PVTReceiptRVO1
     */
    public ViewObjectImpl getPVTReceiptRVO1() {
        return (ViewObjectImpl)findViewObject("PVTReceiptRVO1");
    }

    /**
     * Container's getter for DepositAckDetailsUVO1.
     * @return DepositAckDetailsUVO1
     */
    public DepositAckDetailsUVOImpl getDepositAckDetailsUVO1() {
        return (DepositAckDetailsUVOImpl)findViewObject("DepositAckDetailsUVO1");
    }

    /**
     * Container's getter for DepositAckDetailsUVO2.
     * @return DepositAckDetailsUVO2
     */
    public DepositAckDetailsUVOImpl getDepositAckDetailsUVO2() {
        return (DepositAckDetailsUVOImpl)findViewObject("DepositAckDetailsUVO2");
    }



    /**
     * Container's getter for CreChqTrnValVerUVO1.
     * @return CreChqTrnValVerUVO1
     */
    public CreChqTrnValVerUVOImpl getCreChqTrnValVerUVO1() {
        return (CreChqTrnValVerUVOImpl)findViewObject("CreChqTrnValVerUVO1");
    }

    /**
     * Container's getter for PVTAppealDetailsRVO1.
     * @return PVTAppealDetailsRVO1
     */
    public ViewObjectImpl getPVTAppealDetailsRVO1() {
        return (ViewObjectImpl)findViewObject("PVTAppealDetailsRVO1");
    }

    /**
     * Container's getter for ContraDescLOVVO1.
     * @return ContraDescLOVVO1
     */
    public ViewObjectImpl getContraDescLOVVO1() {
        return (ViewObjectImpl)findViewObject("ContraDescLOVVO1");
    }

    /**
     * Container's getter for PVTRollbackDiscountSearchVO1.
     * @return PVTRollbackDiscountSearchVO1
     */
    public PVTRollbackDiscountSearchVOImpl getPVTRollbackDiscountSearchVO1() {
        return (PVTRollbackDiscountSearchVOImpl)findViewObject("PVTRollbackDiscountSearchVO1");
    }

    /**
     * Container's getter for PVTEventHistoryRVO1.
     * @return PVTEventHistoryRVO1
     */
    public ViewObjectImpl getPVTEventHistoryRVO1() {
        return (ViewObjectImpl)findViewObject("PVTEventHistoryRVO1");
    }

    /**
     * Container's getter for PVTEventDetailsVO1.
     * @return PVTEventDetailsVO1
     */
    public PVTEventDetailsVOImpl getPVTEventDetailsVO1() {
        return (PVTEventDetailsVOImpl)findViewObject("PVTEventDetailsVO1");
    }


   
    public void updatePVTEventAndAccountLog(BigDecimal pvtHeaderSeq, String loggerName,String remarks,BigDecimal knockAmt) {
        
        System.out.println("pvtHeaderSeq ::::::::::::::::::     "+pvtHeaderSeq);
        System.out.println("loggerName ::::::::::::::::::       "+loggerName);
        System.out.println("remarks ::::::::::::::::::          "+remarks);
        System.out.println("knockAmt ::::::::::::::::::         "+knockAmt);
        
        
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        PVTEventDetailsVOImpl pvtEventVO = this.getPVTEventDetailsVO1();    
        pvtEventVO.clearCache();
        pvtEventVO.executeEmptyRowSet();
        System.out.println("RowCount::::IMpl::::"+pvtEventVO.getRowCount());
      
        
        
        if(pvtEventVO != null)
        {
            Row pvtEventRow = pvtEventVO.createRow();
            pvtEventRow.setAttribute("PVTHDRSEQ",pvtHeaderSeq);
           // Vehicle released free after DOT approval
            //pvtEventRow.setAttribute("Remarks","Knocked off amount : AED "+ knockAmt);
            pvtEventRow.setAttribute("Remarks","Vehicle released free after DOT approval");
            pvtEventRow.setAttribute("EVENTID","572"); 
            pvtEventRow.setAttribute("EVENTDATE",sqlDate);
            pvtEventRow.setAttribute("CreatedBy",loggerName);
            pvtEventRow.setAttribute("CreatedDate",sqlDate);
            pvtEventVO.insertRow(pvtEventRow);  
            
        }
        
        GenAccLogUVOImpl pvtAccLogVO = this.getGenAccLogUVO1();    
        pvtAccLogVO.clearCache();
        pvtAccLogVO.executeEmptyRowSet();
        if(pvtAccLogVO!=null) {
            Row pvtEventRow = pvtAccLogVO.createRow(); 
            pvtEventRow.setAttribute("accdate",sqlDate);
            pvtEventRow.setAttribute("PVTHDRSEQ",pvtHeaderSeq);
            pvtEventRow.setAttribute("accamount",knockAmt);
            pvtEventRow.setAttribute("accsource","8");
            pvtEventRow.setAttribute("CreatedBy",loggerName);
            pvtEventRow.setAttribute("CreatedDate",sqlDate);
  
       }
        
        
    }
    public String ADPPrintDetails(String PVTHeaderId) {
        if (!PVTHeaderId.equals("") && PVTHeaderId != null) {
            System.out.println(" PVTHeaderId from Bean" + PVTHeaderId);
            ViewObjectImpl poundcodevo = this.getPVTEnforceidVO1();
            if(poundcodevo != null)
            {
            poundcodevo.setWhereClause(null);
            poundcodevo.setWhereClause("pvt_hdr_seq = " + PVTHeaderId);
            poundcodevo.executeQuery();
            PVTEnforceidVORowImpl poundcodevoRow = (PVTEnforceidVORowImpl)poundcodevo.first();
            if(poundcodevoRow != null)
            {
            Object enforcevhclid = poundcodevoRow.getenforcevhclid();
            ViewObjectImpl poundcodeidvo  = this.getPVTPoundCodevo1();
            if(poundcodeidvo!=null) {
                poundcodeidvo.setWhereClause(null);
                poundcodeidvo.setWhereClause("enforce_vhcl_id = " + enforcevhclid);
                poundcodeidvo.executeQuery();
                
            
                
                
                
                
            }
                ViewObjectImpl pvtreleasevo = this.getPVTReleaseVO1();
                if(pvtreleasevo != null) {
                    pvtreleasevo.setWhereClause(null);
                    pvtreleasevo.setWhereClause("PVT_HDR_SEQ = " + PVTHeaderId);
                    pvtreleasevo.executeQuery();
                    
                }
                ViewObjectImpl pvtarrivevo = this.getPVTArrivalVO1();
                if(pvtarrivevo != null)
                {
                pvtarrivevo.setWhereClause(null);
                pvtarrivevo.setWhereClause("PVT_HDR_SEQ = " + PVTHeaderId);
                pvtarrivevo.executeQuery();
                }
                ViewObjectImpl pvtliftedVO = this.getPVTVehicleLiftedVO1();
                if(pvtliftedVO != null) {
                    pvtliftedVO.setWhereClause(null);
                    pvtliftedVO.setWhereClause("PVT_HDR_SEQ = " + PVTHeaderId);
                    pvtliftedVO.executeQuery();  
                }
            
            
            }
            
            
            }
            
        } 
        return null;
    }

    /**
     * Container's getter for GenAccLogUVO1.
     * @return GenAccLogUVO1
     */
    public GenAccLogUVOImpl getGenAccLogUVO1() {
        return (GenAccLogUVOImpl)findViewObject("GenAccLogUVO1");
    }

  /**
   * Container's getter for PIUserLovVO1.
   * @return PIUserLovVO1
   */
  public ViewObjectImpl getPIUserLovVO1() {
    return (ViewObjectImpl)findViewObject("PIUserLovVO1");
  }

  /**
     * Container's getter for PvtEnforceVehicleAssignRVO1.
     * @return PvtEnforceVehicleAssignRVO1
     */
    public PvtEnforceVehicleAssignRVOImpl getPvtEnforceVehicleAssignRVO1() {
        return (PvtEnforceVehicleAssignRVOImpl)findViewObject("PvtEnforceVehicleAssignRVO1");
    }

    /**
     * Container's getter for RemovalTruckMstVO1.
     * @return RemovalTruckMstVO1
     */
    public RemovalTruckMstVOImpl getRemovalTruckMstVO1() {
        return (RemovalTruckMstVOImpl)findViewObject("RemovalTruckMstVO1");
    }

    /**
     * Container's getter for PoundLocationLVO1.
     * @return PoundLocationLVO1
     */
    public ViewObjectImpl getPoundLocationLVO1() {
        return (ViewObjectImpl)findViewObject("PoundLocationLVO1");
    }
    
    /**
     * Container's getter for CardsSearchCriteriaVO1.
     * @return CardsSearchCriteriaVO1
     */
    public InventorySearchCriteriaVOImpl getCardsSearchCriteriaVO1() {
        return (InventorySearchCriteriaVOImpl)findViewObject("CardsSearchCriteriaVO1");
    }

    /**
     * Container's getter for InventorySearchCriteriaVO1.
     * @return InventorySearchCriteriaVO1
     */
    public InventorySearchCriteriaVOImpl getInventorySearchCriteriaVO1() {
        return (InventorySearchCriteriaVOImpl)findViewObject("InventorySearchCriteriaVO1");
    }

    /**
     * Container's getter for TypeDenominationVO1.
     * @return TypeDenominationVO1
     */
    public TypeDenominationVOImpl getTypeDenominationVO1() {
        return (TypeDenominationVOImpl)findViewObject("TypeDenominationVO1");
    }

    /**
     * Container's getter for InvCardStatusLOVVO1.
     * @return InvCardStatusLOVVO1
     */
    public InvCardStatusLOVVOImpl getInvCardStatusLOVVO1() {
        return (InvCardStatusLOVVOImpl)findViewObject("InvCardStatusLOVVO1");
    }

    /**
     * Container's getter for InventoryEventDetailsVO1.
     * @return InventoryEventDetailsVO1
     */
    public InventoryEventDetailsVOImpl getInventoryEventDetailsVO1() {
        return (InventoryEventDetailsVOImpl)findViewObject("InventoryEventDetailsVO1");
    }

    /**
     * Container's getter for InventorySaleAccDetailsVO1.
     * @return InventorySaleAccDetailsVO1
     */
    public InventorySaleAccDetailsVOImpl getInventorySaleAccDetailsVO1() {
        return (InventorySaleAccDetailsVOImpl)findViewObject("InventorySaleAccDetailsVO1");
    }

    /**
     * Container's getter for InventorySaleDetailsVO1.
     * @return InventorySaleDetailsVO1
     */
    public InventorySaleDetailsVOImpl getInventorySaleDetailsVO1() {
        return (InventorySaleDetailsVOImpl)findViewObject("InventorySaleDetailsVO1");
    }

    /**
     * Container's getter for PVTChargeDetailsVO1.
     * @return PVTChargeDetailsVO1
     */
    public ViewObjectImpl getPVTChargeDetailsVO1() {
        return (ViewObjectImpl)findViewObject("PVTChargeDetailsVO1");
    }

    /**
     * Container's getter for LocationLVO1.
     * @return LocationLVO1
     */
    public ViewObjectImpl getLocationLVO1() {
        return (ViewObjectImpl)findViewObject("LocationLVO1");
    }
    
    public void pvtHeaderSiebleSynch(BigDecimal pvtHdrSeq) {
            CallableStatement stmt = null;
            try {
                System.out.println("Siebel sych PVT HEADER SEQ    :::     "+pvtHdrSeq);
                stmt =getDBTransaction().createCallableStatement("{call INT_PVT_DATA_CHANGE_LOG_proc(?,?,?,?,?) }",0);
                stmt.setString(1, "PVT_HEADER");
                stmt.setBigDecimal(2, pvtHdrSeq);
                stmt.setString(3, "N");
                stmt.setString(4, "N");
                stmt.setString(5, "N");
                stmt.execute();
            } catch (Exception e) {
                    System.out.println("pvtHeaderSiebleSynch Exception Occured"+e.getMessage());
                
            }
        }
    public void getPISupId()
       {
            String userName = "";
            ADFContext adfctx = ADFContext.getCurrent();
            if(adfctx.getSessionScope().get("loggedinUserid")!=null){
                userName = adfctx.getSessionScope().get("loggedinUserid").toString(); 
            }   
      
       ViewObjectImpl vo= (ViewObjectImpl)getpissupVO1();
       vo.setApplyViewCriteriaName("pissupVOCriteria");
       vo.setNamedWhereClauseParam("supid",userName);
       vo.executeQuery();
       
            ViewObjectImpl vo1= (ViewObjectImpl)getSectorforSupVO1();
            vo1.setApplyViewCriteriaName("SectorforSupVOCriteria");
            vo1.setNamedWhereClauseParam("sup",userName);
            vo1.executeQuery();
//            Row row=vo1.first(); 
//            System.out.println(row.getAttribute("sector"));
           // ADFContext.getCurrent().getPageFlowScope().put("Ssector", row.getAttribute("sector"));
            
           
            
            
            
//            ViewObjectImpl vo2= (ViewObjectImpl)getPIMonthlyDeploymentVO1();
//            vo2.setApplyViewCriteriaName("PIMonthlyDeploymentVOCriteria");
//            vo2.setNamedWhereClauseParam("supid","Supervisor");
//            vo2.setNamedWhereClauseParam("sector","A7,A8");
//            vo2.executeQuery();
//            Row r=vo2.first();
//           
//            while(vo2.hasNext()) {
//          
//                System.out.println(r.getAttribute("PIid"));
//                System.out.println(r.getAttribute("Shift"));
//                r.getAttribute("PIid");
//                r.getAttribute("Shift");
//                r=vo2.next();
//         
//            }
            
           

        //            RowSetIterator rs = (RowSetIterator)vo.createRowSetIterator(null);
//            rs.reset();
           // System.out.println(rs.getRowCount());
        }
    public void getPiPvts(String piid, String pidate) {
        FacesContext fctx1 = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks =
            Service.getRenderKitService(fctx1, ExtendedRenderKitService.class);
        //erks.addScript(fctx1, "alert('" + piid + "');");
        // erks.addScript(fctx1, "alert('" + pidate + "');");
        ViewObjectImpl loc=(ViewObjectImpl)getPVTHeaderVO1();
        loc.setApplyViewCriteriaName("PVTHeaderVOCriteria");
        loc.setNamedWhereClauseParam("pilocpid",piid);
        loc.setNamedWhereClauseParam("issuedate",pidate);
        loc.executeQuery();
        
        //and issued_date='"+sqldate+"'
        RowSetIterator rsi=loc.createRowSetIterator(null);
        
        
        erks.addScript(fctx1,"var long1 = [];");
         erks.addScript(fctx1,"var lat1 = [];");
       
               while(rsi.hasNext()) {
                  Row r=rsi.next();
                // System.out.println(r.getAttribute("geolon"));
                //  System.out.println(r.getAttribute("geolat"));
                   System.out.println(r.getAttribute("PVTNum"));
                   System.out.println(r.getAttribute("PVTVHCLgeolon"));
                   System.out.println(r.getAttribute("PVTVHCLgeolat"));
                   
                 if(r.getAttribute("PVTVHCLgeolon")!=null) {
                        erks.addScript(fctx1,"long.push("+r.getAttribute("PVTVHCLgeolon").toString()+")");
                 }
                   if(r.getAttribute("PVTVHCLgeolon")!=null) {
                      erks.addScript(fctx1,"lat.push("+r.getAttribute("PVTVHCLgeolat").toString()+")");     
                   }
                      
//                     erks.addScript(fctx1,"long1.push("+r.getAttribute("PVTVHCLgeolon").toString()+")");
//                     erks.addScript(fctx1,"lat1.push("+r.getAttribute("PVTVHCLgeolat").toString()+")");                      
                                       
               //   erks.addScript(fctx,"long.push("+r.getAttribute("geolon").toString()+")");
               //   erks.addScript(fctx,"lat.push("+r.getAttribute("geolat").toString()+")");
              }
            
       erks.addScript(fctx1,"loadMap(long1,lat1)");
      // erks.addScript(fctx1,"loadMap1()");
    }
    public void getPisforShiftSector(String sup_id,String SName,int Shift,String pidate) {
        ViewObjectImpl vo2=(ViewObjectImpl)getPIMonthlyDeploymentVO1();
        vo2.setApplyViewCriteriaName("PIMonthlyDeploymentVOCriteria");
        vo2.setNamedWhereClauseParam("supid",sup_id);
        vo2.setNamedWhereClauseParam("sector",SName);
        vo2.setNamedWhereClauseParam("shift",Shift);
         vo2.setNamedWhereClauseParam("date",pidate);
         System.out.println("pis for the shift"+vo2.getQuery());
        vo2.executeQuery();
     }
    public int resultCards(String str, String end) {
        ViewObjectImpl vo2 = (ViewObjectImpl)getActiveCardsUVO1();
        vo2.setApplyViewCriteriaName("ActiveCardsUVOCriteria");
        vo2.setNamedWhereClauseParam("StartNumber", str);
        vo2.setNamedWhereClauseParam("EndNumber", end);
        vo2.executeQuery();
        int count = vo2.getRowCount();
        return count;
    }

    public String submitCards(String username, String loc) {

        // get max valu form seq
        //        ViewObjectImpl seq = (ViewObjectImpl)getInvCardInactivationHdrVO1();
        //        RowSetIterator rs = seq.createRowSetIterator(null);
        //        rs.reset();
        //        String hdrseq = null;
        //        while (rs.hasNext()) {
        //        Row row1 = rs.next();
        //
        //        if (row1.getAttribute("InactivateHdrseq") != null) {
        //        hdrseq = row1.getAttribute("InactivateHdrseq").toString();
        //        }
        //        System.out.println("InactivateHdrseq ::" + hdrseq);
        //        }
        ////        ViewObjectImpl acthdr = getInvCardInactivationHdrVO1();
        ////        ActiveCardsUVORowImpl acthrow = (ActiveCardsUVORowImpl)acthdr.createRow();
        ////        acthdr.insertRow(acthrow);
        ////         if(SaleHdrSeq != null)
        ////         {
        ////             acthrow.setPYMTAMT(new BigDecimal(0));
        ////             acthrow.setSalehdrseq(SaleHdrSeq);
        ////             acthrow.setCreatedBy(encoder);
        ////             acthrow.setCreatedDate(sqlDate);
        ////         }
        //


        java.sql.Timestamp sqlTime =
            new java.sql.Timestamp(new java.util.Date().getTime());
        ViewObjectImpl acthdr = (ViewObjectImpl)getInvCardInactivationHdrVO1(); 
        Row NewRow = acthdr.createRow();
        NewRow.setAttribute("locationid", loc);
        NewRow.setAttribute("InactivateDate", sqlTime);
        NewRow.setAttribute("InactivateDate", sqlTime);
        NewRow.setAttribute("CreatedBy", username);
        NewRow.setAttribute("CreatedDate", sqlTime);
        acthdr.insertRow(NewRow);
        doCommit();
        
        RowSetIterator itr = acthdr.createRowSetIterator(null);

        Row seqrowlast = itr.last();
 
  return seqrowlast.getAttribute("InactivateHdrseq").toString();

    }
    
    
    
    public String pvtSearch(String sector,String zone,String pvtnum,String contracode) {
      
        PVTHeadersmsVOImpl PVTSearchsmsVO = (PVTHeadersmsVOImpl)this.getPVTHeadersmsVO1();
        ViewCriteriaManager vcm =PVTSearchsmsVO.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("PVTHeadersmsVOCriteria");
        PVTSearchsmsVO.setsector(sector);
        PVTSearchsmsVO.setpvtno(pvtnum);
        PVTSearchsmsVO.setcontracode(contracode);
        PVTSearchsmsVO.setzone(zone);
        PVTSearchsmsVO.applyViewCriteria(vc);
        PVTSearchsmsVO.executeQuery();
        System.out.println(PVTSearchsmsVO.getQuery());
        long count = PVTSearchsmsVO.getEstimatedRowCount();
        if(count!=0) {
            return "Y";
        }
        else
            return "N";
       
         
        
    }
    
    
    public String pvtdiscountsearch(String sector,String zone,String pvtnum,String contracode,int seq) {
      
        discountsearchVOImpl discountsearch = (discountsearchVOImpl)this.getdiscountsearchVO1();
        ViewCriteriaManager vcm =discountsearch.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("discountsearchVOCriteria");
        discountsearch.setsector(sector);
        discountsearch.setseq(seq);
        discountsearch.setpvtno(pvtnum);
        discountsearch.setcontracode(contracode);
        discountsearch.setzone(zone);
        discountsearch.applyViewCriteria(vc);
        discountsearch.executeQuery();
        System.out.println(discountsearch.getQuery());
        long count = discountsearch.getEstimatedRowCount();
            if(count!=0) {
                return "Y";
            }
            else
                return "N";
       
        
    }
    
    
    
    public Boolean sendMail(BigDecimal pvtHdrSeq)
    {
        CallableStatement stmt = null;
            try {
                stmt = getDBTransaction().createCallableStatement("{call  PVT_Notifications_DoT_Instructions(?)}", 0);
                stmt.setBigDecimal(1,pvtHdrSeq);            
                stmt.execute();        
                
            }  catch (Exception e) {
                System.out.println("PVT_Notifications_DoT_Instructions procedure exception : "+e.getMessage());
                return false;
            } 
            return true;
    }    
    //write-Off PVT amount as per DoTInstructions send
    public Boolean pvteventsendDoTInstructions(BigDecimal pvtHeaderSeq,String loggerName, String remarks,String EventId){
        try{
            PVTEventDetailsVOImpl pvtEventVO = getPVTEventDetailsVO1();
            Timestamp sqlDate =new java.sql.Timestamp(new java.util.Date().getTime());
            Row pvtEventRow = pvtEventVO.createRow();
            pvtEventRow.setAttribute("PVTHDRSEQ", pvtHeaderSeq);
            pvtEventRow.setAttribute("Remarks",remarks);
            pvtEventRow.setAttribute("EVENTID", EventId);
            pvtEventRow.setAttribute("EVENTDATE", sqlDate);
            pvtEventRow.setAttribute("CreatedBy", loggerName);
            pvtEventRow.setAttribute("CreatedDate", sqlDate);
            if(EventId.equals("585"))
            {
            pvtEventRow.setAttribute("BalanceAmt", 0.00);
            }
            pvtEventVO.insertRow(pvtEventRow);
                    }catch(Exception e){
            e.printStackTrace();
            return false;
            }
        return true;
            
        }
    //write-Off PVT amount as per DoTInstructions pvt amount to 0
    public String PVTDoTInstructionsAmt(BigDecimal pvtHdrSeq, BigDecimal PVTAdjAmount,String loggerName,String Operator){
    // insert record into charges table with -ve amount
    encoderforevent = loggerName;
    Timestamp sqlDate =new java.sql.Timestamp(new java.util.Date().getTime());
     System.out.println("negative of adjustment amount : "+BigDecimal.ZERO.subtract(PVTAdjAmount));
        Row newRow = getPVTChargeDetailsVO1().createRow();
        newRow.setAttribute("PVTHDRSEQ", pvtHdrSeq);
        newRow.setAttribute("ChargeType", "5");
        if(Operator.equalsIgnoreCase("-"))
        newRow.setAttribute("ChargeAmount", BigDecimal.ZERO.subtract(PVTAdjAmount));      
        newRow.setAttribute("ChargeDate", sqlDate);
        newRow.setAttribute("CreatedBy", loggerName);
        newRow.setAttribute("Updatedby", loggerName);
        getPVTChargeDetailsVO1().insertRow(newRow);
        // Update Payable Amount with the Charge.
    ViewObjectImpl PVTHeaderVO = getPVTHeaderVO1();
    PVTHeaderVO.applyViewCriteria(null);
    PVTHeaderVO.applyViewCriteria(PVTHeaderVO.getViewCriteria("GetByPvtHeaderSeq"));
    VariableValueManager evm = PVTHeaderVO.ensureVariableManager();
    evm.setVariableValue("BindPvtHdrSeq", pvtHdrSeq);
    PVTHeaderVO.executeQuery();
    BigDecimal PVTAMTPAYABLE = (BigDecimal)PVTHeaderVO.first().getAttribute("PVTAMTPAYABLE");
    PVTHeaderVO.first().setAttribute("PVTAMTPAYABLE",0.00);
   
    return null;
    }
  
  
  //clamping events 
    public Boolean clampingEvents(BigDecimal pvtHeaderSeq,String loggerName, String remarks,String EventId){
        try{
            PVTEventDetailsVOImpl pvtEventVO = getPVTEventDetailsVO1();
            Timestamp sqlDate =new java.sql.Timestamp(new java.util.Date().getTime());
            Row pvtEventRow = pvtEventVO.createRow();
            pvtEventRow.setAttribute("PVTHDRSEQ", pvtHeaderSeq);
            pvtEventRow.setAttribute("Remarks",remarks);
            pvtEventRow.setAttribute("EVENTID", EventId);
            pvtEventRow.setAttribute("EVENTDATE", sqlDate);
            pvtEventRow.setAttribute("CreatedBy", loggerName);
            pvtEventRow.setAttribute("CreatedDate", sqlDate);
            pvtEventVO.insertRow(pvtEventRow);
                    }catch(Exception e){
            e.printStackTrace();
            return false;
            }
        return true;
            
        }
    
    
    public void doSearchPvtPermit(String modetype,String hdrseq){
        
        if(modetype!=null){
        if(modetype.equals("PVT")){
            
            ViewObjectImpl pvtSearch = getPVTSearchRVO1();
            pvtSearch.applyViewCriteria(null);
            pvtSearch.applyViewCriteria(pvtSearch.getViewCriteria("PVTSearchRVOCriteria"));
            VariableValueManager evm = pvtSearch.ensureVariableManager();
            evm.setVariableValue("bindPVTNumber", hdrseq);           
            pvtSearch.executeQuery();          
        }
        
        if(modetype.equals("PRM")){
          ViewObjectImpl prmSearch = getPermitSearchCriteriaVO1();
            prmSearch.applyViewCriteria(null);
            prmSearch.applyViewCriteria(prmSearch.getViewCriteria("PermitSearchCritVOCriteria"));
            VariableValueManager evm = prmSearch.ensureVariableManager();
            evm.setVariableValue("permi_number", hdrseq);           
            prmSearch.executeQuery();
            long a = prmSearch.getEstimatedRowCount();
            System.out.println(a);
            
        }
        }
        
    }
    
    
    public void executeMyAssignments(){
       
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedinUserid");
        ViewObjectImpl eventVO1 = getPVTPermitAssignRVO1();
        ViewObjectImpl eventVO2 = getPVTPermitAssignmentRVO1();
        eventVO1.applyViewCriteria(null);
        eventVO1.applyViewCriteria(eventVO1.getViewCriteria("PVTPermitAssignRVOCriteria"));
        VariableValueManager evm = eventVO1.ensureVariableManager();
        evm.setVariableValue("userId",FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedinUserid"));           
        eventVO1.executeQuery();
        
        eventVO2.applyViewCriteria(null);
        eventVO2.applyViewCriteria(eventVO2.getViewCriteria("PVTPermitAssignmentRVOCriteria"));
        VariableValueManager evm1 = eventVO2.ensureVariableManager();
        evm1.setVariableValue("userId",FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedinUserid"));              
        eventVO2.executeQuery(); 
        
    }
  
 
      
    
    /**
     * Container's getter for PVTHyperLinkVO1.
     * @return PVTHyperLinkVO1
     */
    public ViewObjectImpl getPVTHyperLinkVO1() {
        return (ViewObjectImpl)findViewObject("PVTHyperLinkVO1");
    }


    /**
     * Container's getter for PVTAccEntriesRVO1.
     * @return PVTAccEntriesRVO1
     */
    public ViewObjectImpl getPVTAccEntriesRVO1() {
        return (ViewObjectImpl)findViewObject("PVTAccEntriesRVO1");
    }
    /**
     * Container's getter for PVTBulkCancellation1.
     * @return PVTBulkCancellation1
     */
    public PVTBulkCancellationImpl getPVTBulkCancellation1() {
        return (PVTBulkCancellationImpl)findViewObject("PVTBulkCancellation1");
    }

    /**
     * Container's getter for pissupVO1.
     * @return pissupVO1
     */
    public ViewObjectImpl getpissupVO1() {
        return (ViewObjectImpl)findViewObject("pissupVO1");
    }

    /**
     * Container's getter for SectorforSupVO1.
     * @return SectorforSupVO1
     */
    public ViewObjectImpl getSectorforSupVO1() {
        return (ViewObjectImpl)findViewObject("SectorforSupVO1");
    }

    /**
     * Container's getter for PIMonthlyDeploymentVO1.
     * @return PIMonthlyDeploymentVO1
     */
    public ViewObjectImpl getPIMonthlyDeploymentVO1() {
        return (ViewObjectImpl)findViewObject("PIMonthlyDeploymentVO1");
    }

    /**
     * Container's getter for pisvo1.
     * @return pisvo1
     */
    public pisvoImpl getpisvo1() {
        return (pisvoImpl)findViewObject("pisvo1");
    }

    /**
     * Container's getter for PVTEnforceidVO1.
     * @return PVTEnforceidVO1
     */
    public ViewObjectImpl getPVTEnforceidVO1() {
        return (ViewObjectImpl)findViewObject("PVTEnforceidVO1");
    }

    /**
     * Container's getter for PVTPoundCodevo1.
     * @return PVTPoundCodevo1
     */
    public ViewObjectImpl getPVTPoundCodevo1() {
        return (ViewObjectImpl)findViewObject("PVTPoundCodevo1");
    }

    /**
     * Container's getter for PVTReleaseVO1.
     * @return PVTReleaseVO1
     */
    public ViewObjectImpl getPVTReleaseVO1() {
        return (ViewObjectImpl)findViewObject("PVTReleaseVO1");
    }

    /**
     * Container's getter for PVTArrivalVO1.
     * @return PVTArrivalVO1
     */
    public ViewObjectImpl getPVTArrivalVO1() {
        return (ViewObjectImpl)findViewObject("PVTArrivalVO1");
    }

    /**
     * Container's getter for PVTVehicleLiftedVO1.
     * @return PVTVehicleLiftedVO1
     */
    public ViewObjectImpl getPVTVehicleLiftedVO1() {
        return (ViewObjectImpl)findViewObject("PVTVehicleLiftedVO1");
    }
    /**
     * Container's getter for ActiveCardsEOView1.
     * @return ActiveCardsEOView1
     */
    public ViewObjectImpl getActiveCardsEOView1() {
        return (ViewObjectImpl)findViewObject("ActiveCardsEOView1");
    }

    /**
     * Container's getter for InvCardInactivationHdrVO1.
     * @return InvCardInactivationHdrVO1
     */
    public ViewObjectImpl getInvCardInactivationHdrVO1() {
        return (ViewObjectImpl)findViewObject("InvCardInactivationHdrVO1");
    }

    /**
     * Container's getter for InvCardInactivationdtlVO1.
     * @return InvCardInactivationdtlVO1
     */
    public ViewObjectImpl getInvCardInactivationdtlVO1() {
        return (ViewObjectImpl)findViewObject("InvCardInactivationdtlVO1");
    }

    /**
     * Container's getter for ViewObj1.
     * @return ViewObj1
     */
    public ViewObjectImpl getViewObj1() {
        return (ViewObjectImpl)findViewObject("ViewObj1");
    }

    /**
     * Container's getter for RemarksLoVVO1.
     * @return RemarksLoVVO1
     */
    public ViewObjectImpl getRemarksLoVVO1() {
        return (ViewObjectImpl)findViewObject("RemarksLoVVO1");
    }

    /**
     * Container's getter for PVTVehPoungLogUVO1.
     * @return PVTVehPoungLogUVO1
     */
    public ViewObjectImpl getPVTVehPoungLogUVO1() {
        return (ViewObjectImpl)findViewObject("PVTVehPoungLogUVO1");
    }

    /**
     * Container's getter for PVTPaymentLogUVO1.
     * @return PVTPaymentLogUVO1
     */
    public ViewObjectImpl getPVTPaymentLogUVO1() {
        return (ViewObjectImpl)findViewObject("PVTPaymentLogUVO1");
    }

    /**
     * Container's getter for PaymentsTypesLOVVO1.
     * @return PaymentsTypesLOVVO1
     */
    public ViewObjectImpl getPaymentsTypesLOVVO1() {
        return (ViewObjectImpl)findViewObject("PaymentsTypesLOVVO1");
    }

    
   

    /**
     * Container's getter for CashRemarksVO1.
     * @return CashRemarksVO1
     */
    public CashRemarksVOImpl getCashRemarksVO1() {
        return (CashRemarksVOImpl)findViewObject("CashRemarksVO1");
    }

    /**
     * Container's getter for GenEventDetailsUVO1.
     * @return GenEventDetailsUVO1
     */
    public ViewObjectImpl getGenEventDetailsUVO1() {
        return (ViewObjectImpl)findViewObject("GenEventDetailsUVO1");
    }

    /**
     * Container's getter for PlateCountryLOVVO1.
     * @return PlateCountryLOVVO1
     */
    public ViewObjectImpl getPlateCountryLOVVO1() {
        return (ViewObjectImpl)findViewObject("PlateCountryLOVVO1");
    }

    /**
     * Container's getter for SaleReceiptDetailVO1.
     * @return SaleReceiptDetailVO1
     */
    public SaleReceiptDetailVOImpl getSaleReceiptDetailVO1() {
        return (SaleReceiptDetailVOImpl)findViewObject("SaleReceiptDetailVO1");
    }


    /**
     * Container's getter for saleReceiptSettlVO1.
     * @return saleReceiptSettlVO1
     */
    public saleReceiptSettlVOImpl getsaleReceiptSettlVO1() {
        return (saleReceiptSettlVOImpl)findViewObject("saleReceiptSettlVO1");
    }

    /**
     * Container's getter for saleReceiptSettlVO2.
     * @return saleReceiptSettlVO2
     */
    public saleReceiptSettlVOImpl getsaleReceiptSettlVO2() {
        return (saleReceiptSettlVOImpl)findViewObject("saleReceiptSettlVO2");
    }
    /**
     * Container's getter for PVTHeadersmsVO1.
     * @return PVTHeadersmsVO1
     */
    public ViewObjectImpl getPVTHeadersmsVO1() {
        return (ViewObjectImpl)findViewObject("PVTHeadersmsVO1");
    }

    /**
     * Container's getter for discountsearchVO1.
     * @return discountsearchVO1
     */
    public ViewObjectImpl getdiscountsearchVO1() {
        return (ViewObjectImpl)findViewObject("discountsearchVO1");
    }

    /**
     * Container's getter for PVTHeadersmsVO2.
     * @return PVTHeadersmsVO2
     */
    public PVTHeadersmsVOImpl getPVTHeadersmsVO2() {
        return (PVTHeadersmsVOImpl)findViewObject("PVTHeadersmsVO2");
    }
    /** Container's getter for PermitEventUVO1.
     * @return PermitEventUVO1
     */
    public ViewObjectImpl getPermitEventUVO1() {
        return (ViewObjectImpl)findViewObject("PermitEventUVO1");
    }

    /**
     * Container's getter for InvEventDetailsUVO1.
     * @return InvEventDetailsUVO1
     */
    public ViewObjectImpl getInvEventDetailsUVO1() {
        return (ViewObjectImpl)findViewObject("InvEventDetailsUVO1");
    }

    /**
     * Container's getter for PaymentsINVO1.
     * @return PaymentsINVO1
     */
    public ViewObjectImpl getPaymentsINVO1() {
        return (ViewObjectImpl)findViewObject("PaymentsINVO1");
    }
   

    /**
     * Container's getter for PVTRemarksRVO1.
     * @return PVTRemarksRVO1
     */
    public ViewObjectImpl getPVTRemarksRVO1() {
        return (ViewObjectImpl)findViewObject("PVTRemarksRVO1");
    }

    /**
     * Container's getter for ActiveCardsUVO1.
     * @return ActiveCardsUVO1
     */
    public ActiveCardsUVOImpl getActiveCardsUVO1() {
        return (ActiveCardsUVOImpl)findViewObject("ActiveCardsUVO1");
    }

    /**
     * Container's getter for PVTdissmsVO1.
     * @return PVTdissmsVO1
     */
    public PVTdissmsVOImpl getPVTdissmsVO1() {
        return (PVTdissmsVOImpl)findViewObject("PVTdissmsVO1");
    }

    /**
     * Container's getter for InventoryStockUploadUVO2.
     * @return InventoryStockUploadUVO2
     */
    public InventoryStockUploadUVOImpl getInventoryStockUploadUVO2() {
        return (InventoryStockUploadUVOImpl)findViewObject("InventoryStockUploadUVO2");
    }

    /**
     * Container's getter for pvtpaymentVO1.
     * @return pvtpaymentVO1
     */
    public ViewObjectImpl getpvtpaymentVO1() {
        return (ViewObjectImpl)findViewObject("pvtpaymentVO1");
    }
    /**
     * Container's getter for ClampingUVO1.
     * @return ClampingUVO1
     */
    public ViewObjectImpl getClampingUVO1() {
        return (ViewObjectImpl)findViewObject("ClampingUVO1");
    }

    /**
     * Container's getter for ClampenforcementRVO1.
     * @return ClampenforcementRVO1
     */
    public ViewObjectImpl getClampenforcementRVO1() {
        return (ViewObjectImpl)findViewObject("ClampenforcementRVO1");
    }
    /**
     * Container's getter for PVTAUCTIONHeaderVO1.
     * @return PVTAUCTIONHeaderVO1
     */
    public ViewObjectImpl getPVTAUCTIONHeaderVO1() {
        return (ViewObjectImpl)findViewObject("PVTAUCTIONHeaderVO1");
    }

    /**
     * Container's getter for PVTAUCTIONPVTDETAILSVO1.
     * @return PVTAUCTIONPVTDETAILSVO1
     */
    public ViewObjectImpl getPVTAUCTIONPVTDETAILSVO1() {
        return (ViewObjectImpl)findViewObject("PVTAUCTIONPVTDETAILSVO1");
    }
    /**
     * Container's getter for AuctionSearchRVO1.
     * @return AuctionSearchRVO1
     */
    public ViewObjectImpl getAuctionSearchRVO1() {
        return (ViewObjectImpl)findViewObject("AuctionSearchRVO1");
    }

    /**
     * Container's getter for AuctionOwnershipDetailsVO1.
     * @return AuctionOwnershipDetailsVO1
     */
    public ViewObjectImpl getAuctionOwnershipDetailsVO1() {
        return (ViewObjectImpl)findViewObject("AuctionOwnershipDetailsVO1");
    }

    /**
     * Container's getter for AuctionVehOwnshipTypeLOVVO1.
     * @return AuctionVehOwnshipTypeLOVVO1
     */
    public ViewObjectImpl getAuctionVehOwnshipTypeLOVVO1() {
        return (ViewObjectImpl)findViewObject("AuctionVehOwnshipTypeLOVVO1");
    }

    /**
     * Container's getter for PVTAuctionSearchVO1.
     * @return PVTAuctionSearchVO1
     */
    public ViewObjectImpl getPVTAuctionSearchVO1() {
        return (ViewObjectImpl)findViewObject("PVTAuctionSearchVO1");
    }
    
    public String saveAuctionInitiationDetails(Date auctionInitiationDate,Integer totalNosPVTs,String status,String createdBy)
    {
        ViewObjectImpl pvtAuctionHeaderVO = (ViewObjectImpl)getPVTAUCTIONHeaderVO1();
        Row rowHeader = pvtAuctionHeaderVO.createRow();
        rowHeader.setAttribute("AUCTInitiationDate",auctionInitiationDate);
        rowHeader.setAttribute("TotalPVTCount",totalNosPVTs);
        rowHeader.setAttribute("BatchStatusID",1);
        rowHeader.setAttribute("CreatedBy", createdBy);
        rowHeader.setAttribute("CreatedDate", auctionInitiationDate);
        //rowHeader.setAttribute("PLATECNTID",PLATECNTID);
        //rowHeader.setAttribute("PLATECTGID",PLATECTGID);
        //rowHeader.setAttribute("PLATENUMBER",PLATENUMBER);
        //rowHeader.setAttribute("PLATETYPEID",PLATETYPEID);
        //rowHeader.setAttribute("PVTdatefrom",PVTdatefrom);
        //rowHeader.setAttribute("PVTdateto",PVTdateto);
        //rowHeader.setAttribute("SectorCode",SectorCode);
        //rowHeader.setAttribute("zonecode",zonecode);
        pvtAuctionHeaderVO.insertRow(rowHeader);
        System.out.println("Auction Hearder Count ::"+pvtAuctionHeaderVO.getRowCount());
        long count = pvtAuctionHeaderVO.getEstimatedRowCount();
            System.out.println("Auction Hearder TotalPVTCount ::"+pvtAuctionHeaderVO.getCurrentRow().getAttribute("TotalPVTCount"));                                                                                    
        this.getDBTransaction().commit();
        pvtAuctionHeaderVO.executeQuery();
        //pvtAuctionHeaderVO.setCurrentRow(row);
        //pvtAuctionHeaderVO.setOrderByClause("ASC");
       // System.out.println("pvtAuctionHeaderVO row Count ::"+pvtAuctionHeaderVO.getRowCount());
       // System.out.println("Auction Hearder Seq ::"+pvtAuctionHeaderVO.getRowAtRangeIndex(pvtAuctionHeaderVO.getRowCount()-1).getAttribute("AUCTIONHeaderseq"));
        BigDecimal newAuctionHeaderSeq = (BigDecimal)pvtAuctionHeaderVO.first().getAttribute("AUCTIONHeaderseq");
        System.out.println("Auction Hearder newAuctionHeaderSeq ::"+newAuctionHeaderSeq);
        ViewObjectImpl pvtAuctionPvtDetailsVO = (ViewObjectImpl)getPVTAUCTIONPVTDETAILSVO1();
        
        ViewObjectImpl pvtAuctionPvtSearch = (ViewObjectImpl)getPVTAuctionSearchVO1();  
        
         Row selectionRow[] = pvtAuctionPvtSearch.getFilteredRows("SelectFlag",true);
         Integer selectCount = selectionRow.length;
         for(int i=0;selectCount > i;i++){
            Row rowDetails = pvtAuctionPvtDetailsVO.createRow();
            rowDetails.setAttribute("AUCTIONHeaderseq",newAuctionHeaderSeq);
            //rowDetails.setAttribute("AuctionVenue",AuctionVenue);
            //rowDetails.setAttribute("Biddate",Biddate);
            //rowDetails.setAttribute("BidderName", BidderName);
            rowDetails.setAttribute("CreatedBy", createdBy);
            rowDetails.setAttribute("CreatedDate", auctionInitiationDate);
            rowDetails.setAttribute("DoTApprvforAuctflag","N");
            //rowDetails.setAttribute("FinalBidAmt",FinalBidAmt);
            //rowDetails.setAttribute("NOCReceivedFlag",NOCReceivedFlag);
            System.out.println("Plate Contry ID ::"+selectionRow[i].getAttribute("PLATECNTID"));
            rowDetails.setAttribute("PLATECNTID",selectionRow[i].getAttribute("PLATECNTID"));
            rowDetails.setAttribute("PLATECTGID",selectionRow[i].getAttribute("PLATECTGID"));
            rowDetails.setAttribute("PLATENUMBER",selectionRow[i].getAttribute("PLATENUMBER"));
            rowDetails.setAttribute("PLATETYPEID",selectionRow[i].getAttribute("PLATETYPEID"));
            rowDetails.setAttribute("PVTAMTPAYABLE",selectionRow[i].getAttribute("PVTAMTPAYABLE"));
             BigDecimal pvtHdrSeq = (BigDecimal)selectionRow[i].getAttribute("PVTHDRSEQ");
            rowDetails.setAttribute("PVTHDRSEQ",pvtHdrSeq);
            //rowDetails.setAttribute("Remarks",selectionRow[i].getAttribute("Remarks"));
            //rowDetails.setAttribute("Updatedate",Updatedate);
            //rowDetails.setAttribute("Updatedby",Updatedby);
            rowDetails.setAttribute("VEHCOLOURID",selectionRow[i].getAttribute("VEHCOLOURID"));
            rowDetails.setAttribute("VEHMAKEID",selectionRow[i].getAttribute("VEHMAKEID"));
            rowDetails.setAttribute("VEHMODELID",selectionRow[i].getAttribute("VEHMODELID"));
            //rowDetails.setAttribute("ValuationAmt",ValuationAmt);
            //rowDetails.setAttribute("ValuationRecomdationID",ValuationRecomdationID);
            //rowDetails.setAttribute("VehReleasedflag",VehReleasedflag);
            pvtAuctionPvtDetailsVO.insertRow(rowDetails);
            clampingEvents(pvtHdrSeq,createdBy, "Auction Initiated to DOT Approval/Reject","751");
            stageIDUpdate(pvtHdrSeq,auctionInitiationDate,createdBy);
            
             
        }
        callProcedureToGenMail(newAuctionHeaderSeq, "770", createdBy);
        this.getDBTransaction().commit();
        return String.valueOf( pvtAuctionHeaderVO.getEstimatedRowCount());
    }
    private Boolean stageIDUpdate(BigDecimal pvtHeaderSeq,Date auctionInitiationDate,String createdBy){
        try{
            PVTHeaderVOImpl pvtHeaderVO = (PVTHeaderVOImpl)getPVTHeaderVO1();
            pvtHeaderVO.setWhereClause(null);
            pvtHeaderVO.setWhereClause("PVT_HDR_SEQ = " + pvtHeaderSeq);
            pvtHeaderVO.executeQuery();
            Row pvtHeaderVORow = pvtHeaderVO.first(); 
            pvtHeaderVORow.setAttribute("PVTSTAGEID",22);
            pvtHeaderVORow.setAttribute("Updatedby",createdBy);
            pvtHeaderVORow.setAttribute("Updateddate",auctionInitiationDate);
             
            }catch(Exception e){
            e.printStackTrace();
            return false;
            }
        return true;
            
        }
    
    public String getAuctionInitiationPvtDetails(BigDecimal auctionHeaderseq){
        
        AuctionInitiationViewVOImpl auctionInitiationSeacrchVO = (AuctionInitiationViewVOImpl)this.getAuctionInitiationViewVO1();
        ViewCriteriaManager vcm =auctionInitiationSeacrchVO.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("AuctionInitiationViewVOCriteria");
        auctionInitiationSeacrchVO.setbindAuctionHeaderSeq(auctionHeaderseq);
        auctionInitiationSeacrchVO.applyViewCriteria(vc);
        auctionInitiationSeacrchVO.executeQuery();
        System.out.println(auctionInitiationSeacrchVO.getQuery());
        long count = auctionInitiationSeacrchVO.getEstimatedRowCount();
        if(count!=0) {
            return "Y";
        }
        else
            return "N";
        
    }

    /**
     * Container's getter for AuctionInitiationViewVO1.
     * @return AuctionInitiationViewVO1
     */
    public ViewObjectImpl getAuctionInitiationViewVO1() {
        return (ViewObjectImpl)findViewObject("AuctionInitiationViewVO1");
    }

    /**
     * Container's getter for PvtEnforceVhclMstVO1.
     * @return PvtEnforceVhclMstVO1
     */
    public ViewObjectImpl getPvtEnforceVhclMstVO1() {
        return (ViewObjectImpl)findViewObject("PvtEnforceVhclMstVO1");
    }

    /**
     * Container's getter for PvtEnforceVhclAssignVO1.
     * @return PvtEnforceVhclAssignVO1
     */
    public ViewObjectImpl getPvtEnforceVhclAssignVO1() {
        return (ViewObjectImpl)findViewObject("PvtEnforceVhclAssignVO1");
    }
    /**
     * Container's getter for AuctionEvidenceSearchVO1.
     * @return AuctionEvidenceSearchVO1
     */
    public ViewObjectImpl getAuctionEvidenceSearchVO1() {
        return (ViewObjectImpl)findViewObject("AuctionEvidenceSearchVO1");
    }
    
    
    public String getAuctionEvidenceSearchPvtDetails(BigDecimal auctionHeaderseq){
        String result = "failure";
        PVTAUCTIONHeaderVOImpl pvtAUCTIONHeaderVO = (PVTAUCTIONHeaderVOImpl)getPVTAUCTIONHeaderVO1();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.setWhereClause("AUCTION_Header_seq = " + auctionHeaderseq);
        pvtAUCTIONHeaderVO.executeQuery();
        int pvtAUCTIONHeaderVORowCount = pvtAUCTIONHeaderVO.getRowCount();
        if(pvtAUCTIONHeaderVORowCount > 0){
        PVTAUCTIONHeaderVORowImpl pvtAuctionHeaderRowImpl = (PVTAUCTIONHeaderVORowImpl)pvtAUCTIONHeaderVO.first();
        Integer batchStatsuID = pvtAuctionHeaderRowImpl.getBatchStatusID();
        if(batchStatsuID == 2){
        AuctionEvidenceSearchVOImpl auctionEvidenceSearchVO = (AuctionEvidenceSearchVOImpl)getAuctionEvidenceSearchVO1();
        auctionEvidenceSearchVO.setWhereClause(null);
        auctionEvidenceSearchVO.setWhereClause("AUCTION_Header_seq = " + auctionHeaderseq);
        System.out.println(auctionEvidenceSearchVO.getQuery());
        auctionEvidenceSearchVO.executeQuery();
        System.out.println(auctionEvidenceSearchVO.getQuery());
        int auctionEvidenceSearchRowCount = auctionEvidenceSearchVO.getRowCount();
        if(auctionEvidenceSearchRowCount > 0){
            result = "success";
        }
        }else{
            result = "other";
        }
        }
        return result;
    }

    /**
     * Container's getter for PoundDocVO1.
     * @return PoundDocVO1
     */
    public ViewObjectImpl getPoundDocVO1() {
        return (ViewObjectImpl)findViewObject("PoundDocVO1");
    }
    public String getAuctionHouseEvaluationPvtDetails(BigDecimal auctionHeaderseq){
        
        AuctionEvidenceSearchVOImpl auctionEvidenceSeacrchVO = (AuctionEvidenceSearchVOImpl)this.getAuctionEvidenceSearchVO1();
        ViewCriteriaManager vcm =auctionEvidenceSeacrchVO.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("AuctionEvidenceSearchVOCriteria");
       auctionEvidenceSeacrchVO.setbindPVTHDRSeq(auctionHeaderseq);
        auctionEvidenceSeacrchVO.applyViewCriteria(vc);
        auctionEvidenceSeacrchVO.executeQuery();
        System.out.println(auctionEvidenceSeacrchVO.getQuery());
        long count = auctionEvidenceSeacrchVO.getEstimatedRowCount();
        if(count!=0) {
            return "Y";
        }
        else
            return "N";
        
    }

    /**
     * Container's getter for poundReleasVO1.
     * @return poundReleasVO1
     */
    public ViewObjectImpl getpoundReleasVO1() {
        return (ViewObjectImpl)findViewObject("poundReleasVO1");
    }
    /**
     * Container's getter for PVTPermitUserVO1.
     * @return PVTPermitUserVO1
     */
    public ViewObjectImpl getPVTPermitUserVO1() {
        return (ViewObjectImpl)findViewObject("PVTPermitUserVO1");
    }

    /**
     * Container's getter for PVTPermitGroupUserVO1.
     * @return PVTPermitGroupUserVO1
     */
    public ViewObjectImpl getPVTPermitGroupUserVO1() {
        return (ViewObjectImpl)findViewObject("PVTPermitGroupUserVO1");
    }


    /**
     * Container's getter for PVTPermitAssignmentVO1.
     * @return PVTPermitAssignmentVO1
     */
    public ViewObjectImpl getPVTPermitAssignmentVO1() {
        return (ViewObjectImpl)findViewObject("PVTPermitAssignmentVO1");
    }

    /**
     * Container's getter for PVTPermitAssignmentRVO1.
     * @return PVTPermitAssignmentRVO1
     */
    public ViewObjectImpl getPVTPermitAssignmentRVO1() {
        return (ViewObjectImpl)findViewObject("PVTPermitAssignmentRVO1");
    }

    /**
     * Container's getter for PVTPermitAssignRVO1.
     * @return PVTPermitAssignRVO1
     */
    public ViewObjectImpl getPVTPermitAssignRVO1() {
        return (ViewObjectImpl)findViewObject("PVTPermitAssignRVO1");
    }


    /**
     * Container's getter for PermitSearchCriteriaVO1.
     * @return PermitSearchCriteriaVO1
     */
    public ViewObjectImpl getPermitSearchCriteriaVO1() {
        return (ViewObjectImpl)findViewObject("PermitSearchCriteriaVO1");
    }

    /**
     * Container's getter for LocationIDRVO1.
     * @return LocationIDRVO1
     */
    public ViewObjectImpl getLocationIDRVO1() {
        return (ViewObjectImpl)findViewObject("LocationIDRVO1");
    }
    /**
     * Container's getter for MyAssignmentEmailUVO1.
     * @return MyAssignmentEmailUVO1
     */
    public ViewObjectImpl getMyAssignmentEmailUVO1() {
        return (ViewObjectImpl)findViewObject("MyAssignmentEmailUVO1");
    }

    public void createDocUploadAuctionEvidence(String encoder){
               ViewObjectImpl pvtDocs = getPVTDocsVO1();
               java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
               int flag = 0;
                    pvtDocs.clearCache();    
                    pvtDocs.executeEmptyRowSet();
                    
                    if(pvtDocs!=null) {
                        //doc master PoundDocVO
                        
                        ViewObjectImpl auctionEvidenceVO = getAuctionEvidenceDocVO1();
                        RowSetIterator rsi=auctionEvidenceVO.createRowSetIterator(null);

                        while(rsi.hasNext()) {
                            Row docrow=rsi.next();
                            
                            Row pvtDocsRow = pvtDocs.createRow(); 
                            pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
                            pvtDocsRow.setAttribute("CreatedBy",encoder);
                            pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                            pvtDocsRow.setAttribute("DOCDesc",docrow.getAttribute("DocDesc"));
                            pvtDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
                            pvtDocs.insertRow(pvtDocsRow); 
                        }
                  
                    }
           }

    /**
     * Container's getter for AuctionEvidenceDocVO1.
     * @return AuctionEvidenceDocVO1
     */
    public ViewObjectImpl getAuctionEvidenceDocVO1() {
        return (ViewObjectImpl)findViewObject("AuctionEvidenceDocVO1");
    }
    
    public void resetAuctionInitiation(){
        PVTAUCTIONHeaderVOImpl pvtAUCTIONHeaderVO = (PVTAUCTIONHeaderVOImpl)getPVTAUCTIONHeaderVO1();
        pvtAUCTIONHeaderVO.clearCache();
//        pvtAUCTIONHeaderVO.executeEmptyRowSet();
         pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.executeQuery();
    }
    
    public void resetAuctionEvaluation(){
        PVTAUCTIONHeaderVOImpl pvtAUCTIONHeaderVO = (PVTAUCTIONHeaderVOImpl)getPVTAUCTIONHeaderVO1();
        pvtAUCTIONHeaderVO.clearCache();
        //pvtAUCTIONHeaderVO.executeEmptyRowSet();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.executeQuery();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.setWhereClause("Batch_Status_ID = 3");
        pvtAUCTIONHeaderVO.executeQuery();
    }

    /**
     * Container's getter for AuctionEvaluationVO1.
     * @return AuctionEvaluationVO1
     */
    public AuctionEvaluationVOImpl getAuctionEvaluationVO1() {
        return (AuctionEvaluationVOImpl)findViewObject("AuctionEvaluationVO1");
    }
    public void createDocUploadAuctionEvaluation(String encoder){
           ViewObjectImpl pvtDocs = getPVTDocsVO1();
           java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           int flag = 0;
                pvtDocs.clearCache();    
                pvtDocs.executeEmptyRowSet();
                
                if(pvtDocs!=null) {
                    //doc master PoundDocVO
                    
                    ViewObjectImpl auctionEvaluationVO = getAuctionEvaluationVO1();
                    RowSetIterator rsi=auctionEvaluationVO.createRowSetIterator(null);

                    while(rsi.hasNext()) {
                        Row docrow=rsi.next();
                        
                        Row pvtDocsRow = pvtDocs.createRow(); 
                        pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
                        pvtDocsRow.setAttribute("CreatedBy",encoder);
                        pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                        pvtDocsRow.setAttribute("DOCDesc",docrow.getAttribute("DocDesc"));
                        pvtDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
                        pvtDocs.insertRow(pvtDocsRow); 
                    }
              
                }
        }
    public void resetAuctionClosing(){
        PVTAUCTIONHeaderVOImpl pvtAUCTIONHeaderVO = (PVTAUCTIONHeaderVOImpl)getPVTAUCTIONHeaderVO1();
        pvtAUCTIONHeaderVO.clearCache();
        //pvtAUCTIONHeaderVO.executeEmptyRowSet();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.executeQuery();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.setWhereClause("Batch_Status_ID = 4");
        pvtAUCTIONHeaderVO.executeQuery();
    }
    
    public String getAuctionClosingPvtDetails(BigDecimal auctionHeaderseq){
        
        AuctionEvidenceSearchVOImpl auctionEvidenceSeacrchVO = (AuctionEvidenceSearchVOImpl)this.getAuctionEvidenceSearchVO1();
        ViewCriteriaManager vcm =auctionEvidenceSeacrchVO.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("AuctionEvidenceSearchVOCriteria");
       auctionEvidenceSeacrchVO.setbindPVTHDRSeq(auctionHeaderseq);
        auctionEvidenceSeacrchVO.applyViewCriteria(vc);
        auctionEvidenceSeacrchVO.executeQuery();
        System.out.println(auctionEvidenceSeacrchVO.getQuery());
        long count = auctionEvidenceSeacrchVO.getEstimatedRowCount();
        if(count!=0) {
            return "Y";
        }
        else
            return "N";
        
    }
    public void createDocUploadAuctionClosing(String encoder){
           ViewObjectImpl pvtDocs = getPVTDocsVO1();
           java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           int flag = 0;
                pvtDocs.clearCache();    
                pvtDocs.executeEmptyRowSet();
                
                if(pvtDocs!=null) {
                    //doc master PoundDocVO
                    
                    ViewObjectImpl auctionEvaluationVO = getAuctionClosingVO1();
                    RowSetIterator rsi=auctionEvaluationVO.createRowSetIterator(null);

                    while(rsi.hasNext()) {
                        Row docrow=rsi.next();
                        
                        Row pvtDocsRow = pvtDocs.createRow(); 
                        pvtDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
                        pvtDocsRow.setAttribute("CreatedBy",encoder);
                        pvtDocsRow.setAttribute("CreatedDate",sqlDate);
                        pvtDocsRow.setAttribute("DOCDesc",docrow.getAttribute("DocDesc"));
                        pvtDocsRow.setAttribute("FlageM",docrow.getAttribute("Mandatoryflag"));
                        pvtDocs.insertRow(pvtDocsRow); 
                    }
              
                }
        }

    /**
     * Container's getter for AuctionClosingVO1.
     * @return AuctionClosingVO1
     */
    public AuctionClosingVOImpl getAuctionClosingVO1() {
        return (AuctionClosingVOImpl)findViewObject("AuctionClosingVO1");
    }
    
    public String saveAuctionClosingPvtDetails(BigDecimal auctionHeaderseq,BigDecimal finalBidAmount,String bidderName,String remarks,Date bidDate,Date auctionInitiationDate,String updatedBy,BigDecimal pvthdrseq){
           
        System.out.println("finalBidAmount ::"+finalBidAmount);
        //System.out.println("actualScrapAmount in AED ::"+actualScrapAmount);
        System.out.println("bidderName ::"+bidderName);
        System.out.println("remarks ::"+remarks);
        System.out.println("bidDate ::"+bidDate);
        //System.out.println("scrapDate ::"+scrapDate);
        try{
            PVTAUCTIONPVTDETAILSVOImpl pvtAuctionPvtDetailsVO = (PVTAUCTIONPVTDETAILSVOImpl)getPVTAUCTIONPVTDETAILSVO1();
            pvtAuctionPvtDetailsVO.setWhereClause(null);
            pvtAuctionPvtDetailsVO.setWhereClause("AUCTION_Header_seq = "+auctionHeaderseq+" and PVT_HDR_SEQ="+ pvthdrseq+"");
            pvtAuctionPvtDetailsVO.executeQuery();
            Row pvtAuctionPvtDetailsVORow = pvtAuctionPvtDetailsVO.first(); 
            pvtAuctionPvtDetailsVORow.setAttribute("FinalBidAmt",finalBidAmount);
            pvtAuctionPvtDetailsVORow.setAttribute("Biddate",bidDate);
            pvtAuctionPvtDetailsVORow.setAttribute("BidderName",bidderName);
            pvtAuctionPvtDetailsVORow.setAttribute("Remarks",remarks);
            pvtAuctionPvtDetailsVORow.setAttribute("Updatedby",updatedBy);
            pvtAuctionPvtDetailsVORow.setAttribute("Updatedate",auctionInitiationDate);
             
                PVTHeaderVOImpl pvtHeaderVO = (PVTHeaderVOImpl)getPVTHeaderVO1();
                pvtHeaderVO.setWhereClause(null);
                pvtHeaderVO.setWhereClause("PVT_HDR_SEQ = " + pvthdrseq);
                pvtHeaderVO.executeQuery();
                Row pvtHeaderVORow = pvtHeaderVO.first(); 
                pvtHeaderVORow.setAttribute("PVTSTAGEID",27);
                pvtHeaderVORow.setAttribute("Updatedby",updatedBy);
                pvtHeaderVORow.setAttribute("Updateddate",auctionInitiationDate);     
            }catch(Exception e){
            e.printStackTrace();
            return "failure";
            }
        return "success";
    }
    
    
    public String saveAuctionHouseEvaluationPvtDetails(BigDecimal auctionHeaderseq,String auctionEvaluation,BigDecimal auctionEvaluationValue,Boolean auctionNOCReceived,String auctionVenue,Date updatedDate,String updatedBy,BigDecimal pvthdrseq){
        //auctionHeaderseq i am changeing this value to PVT_HDR_SEQ
        System.out.println("auctionEvaluation ::"+auctionEvaluation);
        System.out.println("auctionNOCReceived ::"+auctionNOCReceived);
        System.out.println("auctionEvaluationValue ::"+auctionEvaluationValue);
        System.out.println("auctionVenue ::"+auctionVenue);
        
        //System.out.println("scrapDate ::"+scrapDate);
        try{
            PVTAUCTIONPVTDETAILSVOImpl pvtAuctionPvtDetailsVO = (PVTAUCTIONPVTDETAILSVOImpl)getPVTAUCTIONPVTDETAILSVO1();
            pvtAuctionPvtDetailsVO.setWhereClause(null);
            pvtAuctionPvtDetailsVO.setWhereClause("AUCTION_Header_seq = "+auctionHeaderseq+" and PVT_HDR_SEQ="+ pvthdrseq+"");
            pvtAuctionPvtDetailsVO.executeQuery();
            Row pvtAuctionPvtDetailsVORow = pvtAuctionPvtDetailsVO.first(); 
            System.out.println(auctionEvaluation.equals("Auction")?3:(auctionEvaluation.equals("Scrap")?2:1));
            pvtAuctionPvtDetailsVORow.setAttribute("ValuationRecomdationID",auctionEvaluation.equals("Auction")?3:(auctionEvaluation.equals("Scrap")?2:1));
            pvtAuctionPvtDetailsVORow.setAttribute("ValuationAmt",auctionEvaluationValue);
            pvtAuctionPvtDetailsVORow.setAttribute("AuctionVenue",auctionVenue);
            pvtAuctionPvtDetailsVORow.setAttribute("NOCReceivedFlag",auctionNOCReceived==true?'Y':'N');
            pvtAuctionPvtDetailsVORow.setAttribute("Updatedby",updatedBy);
            pvtAuctionPvtDetailsVORow.setAttribute("Updatedate",updatedDate);
            //this.getDBTransaction().commit();
            PVTHeaderVOImpl pvtHeaderVO = (PVTHeaderVOImpl)getPVTHeaderVO1();
            pvtHeaderVO.setWhereClause(null);
            pvtHeaderVO.setWhereClause("PVT_HDR_SEQ = " + pvthdrseq);
            pvtHeaderVO.executeQuery();
            Row pvtHeaderVORow = pvtHeaderVO.first(); 
            if(auctionEvaluation.equals("Auction")) {
                pvtHeaderVORow.setAttribute("PVTSTAGEID",26); 
            }
            else {
                pvtHeaderVORow.setAttribute("PVTSTAGEID",25);
            }
           pvtHeaderVORow.setAttribute("Updatedby",updatedBy);
            pvtHeaderVORow.setAttribute("Updateddate",updatedDate);
           // clampingEvents((BigDecimal)pvtAuctionPvtDetailsVORow.getAttribute("PVTHDRSEQ"), updatedBy, "Assigned to Auction House for Evaluation", "753");
           clampingEvents(pvthdrseq, updatedBy, "Assigned to Auction House for Evaluation", "753");
            }catch(Exception e){
            e.printStackTrace();
            return "failure";
            }
        return "success";
    }
    
    public String saveAuctionEvidenceDetails(BigDecimal auctionHeaderseq,Date updatedDate,String updatedby){
        String result = "failure";
        PVTAUCTIONHeaderVOImpl pvtAUCTIONHeaderVO = (PVTAUCTIONHeaderVOImpl)getPVTAUCTIONHeaderVO1();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.setWhereClause("AUCTION_Header_seq = " + auctionHeaderseq);
        pvtAUCTIONHeaderVO.executeQuery();
        Row pvtAuctionHeaderRow = pvtAUCTIONHeaderVO.first();
        pvtAuctionHeaderRow.setAttribute("BatchStatusID",3);
        pvtAuctionHeaderRow.setAttribute("Updatedby",updatedby);
        pvtAuctionHeaderRow.setAttribute("Updatedate",updatedDate);
        this.getDBTransaction().commit();
        pvtAUCTIONHeaderVO.executeQuery();
        callProcedureToGenMail(auctionHeaderseq,"772",updatedby);
        return result;
    }
    
    private void callProcedureToGenMail(BigDecimal auctionHeaderseq,String eventID,String userID)
    {
        CallableStatement stmt = null;
        try {
            System.out.println("before PVT_AUCTION_Events_and_Notifications Procedure Execution");
           stmt = getDBTransaction().createCallableStatement("{call  PVT_AUCTION_Events_and_Notifications(?, ?, ?) }", 0);
           stmt.setBigDecimal(1,auctionHeaderseq);            
           stmt.setString(2,eventID);
           stmt.setString(3,userID);
           stmt.execute();
           commit();
            System.out.println("Procedure Executed");
            
        }  catch (Exception e) {
                 e.printStackTrace();
                 }         
        finally {
            try {
                     stmt.close();
            } catch(Exception e) {
                System.out.println("Closing the statement error..." + e);
            }
        }
    }
    
    
    public String saveAuctionHouseEvaluationDetails(BigDecimal auctionHeaderseq,String auctionHouseRef,Date updatedDate,String updatedby){
        String result = "failure";
        PVTAUCTIONHeaderVOImpl pvtAUCTIONHeaderVO = (PVTAUCTIONHeaderVOImpl)getPVTAUCTIONHeaderVO1();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.setWhereClause("AUCTION_Header_seq = " + auctionHeaderseq);
        pvtAUCTIONHeaderVO.executeQuery();
        Row pvtAuctionHeaderRow = pvtAUCTIONHeaderVO.first();
        pvtAuctionHeaderRow.setAttribute("BatchStatusID",4);
        pvtAuctionHeaderRow.setAttribute("AuctHouseRefnum",auctionHouseRef);
        pvtAuctionHeaderRow.setAttribute("Updatedby",updatedby);
        pvtAuctionHeaderRow.setAttribute("Updatedate",updatedDate);
        this.getDBTransaction().commit();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.executeQuery();
        pvtAUCTIONHeaderVO.setWhereClause("Batch_Status_ID = 3");
        pvtAUCTIONHeaderVO.executeQuery();
        callProcedureToGenMail(auctionHeaderseq,"775",updatedby);
        return result;
    }
    
    public String saveAuctionClosingDetails(BigDecimal auctionHeaderseq,Date updatedDate,String updatedby){
        String result = "failure";
        PVTAUCTIONHeaderVOImpl pvtAUCTIONHeaderVO = (PVTAUCTIONHeaderVOImpl)getPVTAUCTIONHeaderVO1();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.setWhereClause("AUCTION_Header_seq = " + auctionHeaderseq);
        pvtAUCTIONHeaderVO.executeQuery();
        Row pvtAuctionHeaderRow = pvtAUCTIONHeaderVO.first();
        pvtAuctionHeaderRow.setAttribute("BatchStatusID",5);
        pvtAuctionHeaderRow.setAttribute("Updatedby",updatedby);
        pvtAuctionHeaderRow.setAttribute("Updatedate",updatedDate);
        this.getDBTransaction().commit();
        pvtAUCTIONHeaderVO.setWhereClause(null);
        pvtAUCTIONHeaderVO.executeQuery();
        pvtAUCTIONHeaderVO.setWhereClause("Batch_Status_ID = 4");
        pvtAUCTIONHeaderVO.executeQuery();
        callProcedureToGenMail(auctionHeaderseq,"773",updatedby);
        return result;
    }

    /**
     * Container's getter for PoundFreeDocVO1.
     * @return PoundFreeDocVO1
     */
    public ViewObjectImpl getPoundFreeDocVO1() {
        return (ViewObjectImpl)findViewObject("PoundFreeDocVO1");
    }

    /**
     * Container's getter for PiidMonthlyDeployment1.
     * @return PiidMonthlyDeployment1
     */
    public ViewObjectImpl getPiidMonthlyDeployment1() {
        return (ViewObjectImpl)findViewObject("PiidMonthlyDeployment1");
    }

    /**
     * Container's getter for PILocationVO1.
     * @return PILocationVO1
     */
    public PILocationVOImpl getPILocationVO1() {
        return (PILocationVOImpl)findViewObject("PILocationVO1");
    }

    /**
     * Container's getter for PVTHHCGPSTrackerVO1.
     * @return PVTHHCGPSTrackerVO1
     */
    public ViewObjectImpl getPVTHHCGPSTrackerVO1() {
        return (ViewObjectImpl)findViewObject("PVTHHCGPSTrackerVO1");
    }

    /**
     * Container's getter for HHCInactiveFlagVO1.
     * @return HHCInactiveFlagVO1
     */
    public ViewObjectImpl getHHCInactiveFlagVO1() {
        return (ViewObjectImpl)findViewObject("HHCInactiveFlagVO1");
    }

    /**
     * Container's getter for GENPIGPSDATAMAPActiveRVO1.
     * @return GENPIGPSDATAMAPActiveRVO1
     */
    public ViewObjectImpl getGENPIGPSDATAMAPActiveRVO1() {
        return (ViewObjectImpl)findViewObject("GENPIGPSDATAMAPActiveRVO1");
    }

    /**
     * Container's getter for GENPIGPSDATAMAPInactiveRVO1.
     * @return GENPIGPSDATAMAPInactiveRVO1
     */
    public ViewObjectImpl getGENPIGPSDATAMAPInactiveRVO1() {
        return (ViewObjectImpl)findViewObject("GENPIGPSDATAMAPInactiveRVO1");
    }
    public DBTransaction getDBConnection1(){
        DBTransaction  con= this.getDBTransaction();
        return  con;
    }
    /* GEN_PI_GPS_DATA_MAP_PROC calling */
    public Integer callGenPiGpsDataMapProc (java.sql.Date date,Integer shift)
            { 
                     Integer runseqno=null;
               
                try {
                                CallableStatement stmt = null;
                                    try {
                                        stmt = getDBTransaction().createCallableStatement("{call  GEN_PI_GPS_DATA_MAP_PROC (?,?,?) }", 0);
                                        stmt.setDate(1,date); 
                                        stmt.setInt(2,shift);
                                        stmt.registerOutParameter(3, Types.INTEGER);
                                        
                                        System.out.println("params on GEN_PI_GPS_DATA_MAP_PROC is :date "+date+" and shift is : "+shift);
                                        
                                        stmt.execute(); 
                                        runseqno = (Integer)stmt.getInt(3); 
                                        System.out.println("genereated run_seq on GEN_PI_GPS_DATA_MAP_PROC is:::"+runseqno);
                                        getDBConnection1().commit();
                                                                            
                                        
                                    }  catch (Exception e) {
                                        System.out.println("callGenPiGpsDataMapProc procedure exception : "+e.getMessage());
                                    }
                                finally {
                                    try {
                                        if(stmt!=null)
                                           stmt.close();
                                    } catch(Exception e) {
                                        System.out.println("Closing the statement error..." + e);
                                    }
                                }
                                
                        }
                                            
                    
                    
                 catch (Exception e) {
                    System.out.println("callGenPiGpsDataMapProc exception : "+e.getMessage());
                }
             System.out.println("Success"); 
            return runseqno;                 
            }
    
    
    /* PI Active Inactive Map Business Logic goes here */
    public void getallpicoordinates(Integer runseqno){      
                    
            FacesContext fctx = FacesContext.getCurrentInstance();
            ExtendedRenderKitService erks =Service.getRenderKitService(fctx, ExtendedRenderKitService.class);

            ViewObjectImpl activeloc=(ViewObjectImpl)getGENPIGPSDATAMAPActiveRVO1();
            activeloc.setWhereClause("run_seq='"+runseqno+"'");
            System.out.println("Active query is:::"+activeloc.getQuery());
            activeloc.executeQuery();
     
            RowSetIterator rsi1=activeloc.createRowSetIterator(null);
            erks.addScript(fctx, "var long1 = [];");
            erks.addScript(fctx, "var lat1 = [];");
            erks.addScript(fctx, "var long = [];");
            erks.addScript(fctx, "var lat = [];");
            erks.addScript(fctx, "var piid = [];");
            erks.addScript(fctx, "var piname = [];");
            erks.addScript(fctx, "var cnumber = [];");
            erks.addScript(fctx, "var sector = [];");
            erks.addScript(fctx, "var activesince = [];");
            erks.addScript(fctx, "var active = [];");
            erks.addScript(fctx, "var supervisorid = [];");
            erks.addScript(fctx, "var supervisorname = [];");
            erks.addScript(fctx, "var supervisorcontactnum = [];");
                       
                  while(rsi1.hasNext()) {
                                        Row r=rsi1.next();
                                        /*  System.out.println("Active Values are:::");
                                         System.out.println("lon val is:::"+r.getAttribute("geolon"));
                                         System.out.println("lat val is:::"+r.getAttribute("geolat"));
                                         System.out.println("PI ID   is:::"+r.getAttribute("PIID"));
                                         System.out.println("PIName  is:::"+r.getAttribute("PIName"));
                                         System.out.println("MobNo   is:::"+r.getAttribute("PIMobileNo"));
                                         System.out.println("Sector  is:::"+r.getAttribute("sectorcode"));
                                         System.out.println("Active  is:::"+r.getAttribute("Mingpsdatetime")); */
                                         
                                         
                                       if(r.getAttribute("geolon")!=null && r.getAttribute("geolat")!=null) {
                                                  erks.addScript(fctx,"long.push('"+r.getAttribute("geolon").toString()+"')");
                                                  erks.addScript(fctx,"lat.push('"+r.getAttribute("geolat").toString()+"')"); 
                                                   if(r.getAttribute("PIID")!=null) {
                                                      erks.addScript(fctx,"piid.push('"+r.getAttribute("PIID").toString()+"')");
                                                   }  
                                                  else {
                                                    erks.addScript(fctx,"piid.push('')");
                                                    } 
                                                if(r.getAttribute("PIName")!=null) {
                                                 erks.addScript(fctx," piname.push('"+r.getAttribute("PIName").toString()+"')");
                                                   }  
                                                else {
                                                 erks.addScript(fctx," piname.push('')");
                                                     } 
                                               if(r.getAttribute("PIMobileNo")!=null) {
                                                 erks.addScript(fctx," cnumber.push('"+r.getAttribute("PIMobileNo").toString()+"')");
                                                     }  
                                               else {
                                                erks.addScript(fctx," cnumber.push('')");
                                               } 
                                               if(r.getAttribute("sectorcode")!=null) {
                                                 erks.addScript(fctx," sector.push('"+r.getAttribute("sectorcode").toString()+"')");
                                                }  
                                                else {
                                                erks.addScript(fctx," sector.push('')");
                                               } 
                                                if(r.getAttribute("Mingpsdatetime")!=null) {
                                                erks.addScript(fctx," activesince.push('"+r.getAttribute("Mingpsdatetime").toString()+"')");
                                                }  
                                                 else {
                                                erks.addScript(fctx," activesince.push('')");
                                                } 
                                         
                                          if(r.getAttribute("Supervisorid")!=null) {
                                            erks.addScript(fctx," supervisorid.push('"+r.getAttribute("Supervisorid").toString()+"')");
                                           }  
                                           else {
                                           erks.addScript(fctx," supervisorid.push('')");
                                          } 
                                           if(r.getAttribute("Supervisorname")!=null) {
                                           erks.addScript(fctx," supervisorname.push('"+r.getAttribute("Supervisorname").toString()+"')");
                                           }  
                                            else {
                                           erks.addScript(fctx," supervisorname.push('')");
                                           } 
                                          if(r.getAttribute("Supervisorcontactnum")!=null) {
                                          erks.addScript(fctx," supervisorcontactnum.push('"+r.getAttribute("Supervisorcontactnum").toString()+"')");
                                          }  
                                           else {
                                          erks.addScript(fctx," supervisorcontactnum.push('')");
                                          } 
                                          erks.addScript(fctx,"active.push('1')");
                                          
                                      }
                  }
            
                        ViewObjectImpl inactiveloc=(ViewObjectImpl)getGENPIGPSDATAMAPInactiveRVO1();
                        inactiveloc.setWhereClause("run_seq='"+runseqno+"'");
                        System.out.println("Inactive query is:::"+inactiveloc.getQuery());
                        inactiveloc.executeQuery();
                        
                        RowSetIterator rsi11=inactiveloc.createRowSetIterator(null);      
                         while(rsi11.hasNext()) {
                                              Row r=rsi11.next();
                                               /* System.out.println("Inactive Values are:::");
                                               System.out.println(r.getAttribute("geolon"));
                                               System.out.println(r.getAttribute("geolat"));
                                               System.out.println("PI ID   is:::"+r.getAttribute("PIID"));
                                               System.out.println("PIName  is:::"+r.getAttribute("PIName"));
                                               System.out.println("MobNo   is:::"+r.getAttribute("PIMobileNo"));
                                               System.out.println("Sector  is:::"+r.getAttribute("sectorcode"));
                                               System.out.println("Active  is:::"+r.getAttribute("Mingpsdatetime")); */
                                             if(r.getAttribute("geolon")!=null && r.getAttribute("geolat")!=null) {
                                                        erks.addScript(fctx,"long.push('"+r.getAttribute("geolon").toString()+"')");
                                                        erks.addScript(fctx,"lat.push('"+r.getAttribute("geolat").toString()+"')"); 
                                                if(r.getAttribute("PIID")!=null) {
                                                       erks.addScript(fctx,"piid.push('"+r.getAttribute("PIID").toString()+"')");
                                                         }  
                                                else {
                                                       erks.addScript(fctx,"piid.push('')");
                                                          }
                                                if(r.getAttribute("PIName")!=null) {
                                                 erks.addScript(fctx," piname.push('"+r.getAttribute("PIName").toString()+"')");
                                                   }  
                                                else {
                                                 erks.addScript(fctx," piname.push('')");
                                                     } 
                                                if(r.getAttribute("PIMobileNo")!=null) {
                                                 erks.addScript(fctx," cnumber.push('"+r.getAttribute("PIMobileNo").toString()+"')");
                                                     }  
                                                else {
                                                erks.addScript(fctx," cnumber.push('')");
                                                }
                                                if(r.getAttribute("sectorcode")!=null) {
                                                 erks.addScript(fctx," sector.push('"+r.getAttribute("sectorcode").toString()+"')");
                                                }  
                                                else {
                                                erks.addScript(fctx," sector.push('')");
                                                }
                                                if(r.getAttribute("Mingpsdatetime")!=null) {
                                                erks.addScript(fctx," activesince.push('"+r.getAttribute("Mingpsdatetime").toString()+"')");
                                                }  
                                                 else {
                                                erks.addScript(fctx," activesince.push('')");
                                                }
                                               
                                                if(r.getAttribute("Supervisorid")!=null) {
                                                  erks.addScript(fctx," supervisorid.push('"+r.getAttribute("Supervisorid").toString()+"')");
                                                 }  
                                                 else {
                                                 erks.addScript(fctx," supervisorid.push('')");
                                                } 
                                                 if(r.getAttribute("Supervisorname")!=null) {
                                                 erks.addScript(fctx," supervisorname.push('"+r.getAttribute("Supervisorname").toString()+"')");
                                                 }  
                                                  else {
                                                 erks.addScript(fctx," supervisorname.push('')");
                                                 } 
                                                if(r.getAttribute("Supervisorcontactnum")!=null) {
                                                erks.addScript(fctx," supervisorcontactnum.push('"+r.getAttribute("Supervisorcontactnum").toString()+"')");
                                                }  
                                                 else {
                                                erks.addScript(fctx," supervisorcontactnum.push('')");
                                                } 
                                                erks.addScript(fctx,"active.push('0')");
                                                
                                            }
                        }
                        ViewObjectImpl idleloc=(ViewObjectImpl)getGENPIGPSDATAMAPIdleRVO1();
                        idleloc.setWhereClause("run_seq='"+runseqno+"'");
                        System.out.println("Inactive query is:::"+idleloc.getQuery());
                        idleloc.executeQuery();
                        
                        RowSetIterator rsi12=idleloc.createRowSetIterator(null);      
                         while(rsi12.hasNext()) {
                                              Row r=rsi12.next();
                                               /* System.out.println("Inactive Values are:::");
                                               System.out.println(r.getAttribute("geolon"));
                                               System.out.println(r.getAttribute("geolat"));
                                               System.out.println("PI ID   is:::"+r.getAttribute("PIID"));
                                               System.out.println("PIName  is:::"+r.getAttribute("PIName"));
                                               System.out.println("MobNo   is:::"+r.getAttribute("PIMobileNo"));
                                               System.out.println("Sector  is:::"+r.getAttribute("sectorcode"));
                                               System.out.println("Active  is:::"+r.getAttribute("Mingpsdatetime")); */
                                             if(r.getAttribute("geolon")!=null && r.getAttribute("geolat")!=null) {
                                                        erks.addScript(fctx,"long.push('"+r.getAttribute("geolon").toString()+"')");
                                                        erks.addScript(fctx,"lat.push('"+r.getAttribute("geolat").toString()+"')"); 
                                                if(r.getAttribute("PIID")!=null) {
                                                       erks.addScript(fctx,"piid.push('"+r.getAttribute("PIID").toString()+"')");
                                                         }  
                                                else {
                                                       erks.addScript(fctx,"piid.push('')");
                                                          }
                                                if(r.getAttribute("PIName")!=null) {
                                                 erks.addScript(fctx," piname.push('"+r.getAttribute("PIName").toString()+"')");
                                                   }  
                                                else {
                                                 erks.addScript(fctx," piname.push('')");
                                                     } 
                                                if(r.getAttribute("PIMobileNo")!=null) {
                                                 erks.addScript(fctx," cnumber.push('"+r.getAttribute("PIMobileNo").toString()+"')");
                                                     }  
                                                else {
                                                erks.addScript(fctx," cnumber.push('')");
                                                }
                                                if(r.getAttribute("sectorcode")!=null) {
                                                 erks.addScript(fctx," sector.push('"+r.getAttribute("sectorcode").toString()+"')");
                                                }  
                                                else {
                                                erks.addScript(fctx," sector.push('')");
                                                }
                                                if(r.getAttribute("Mingpsdatetime")!=null) {
                                                erks.addScript(fctx," activesince.push('"+r.getAttribute("Mingpsdatetime").toString()+"')");
                                                }  
                                                 else {
                                                erks.addScript(fctx," activesince.push('')");
                                                }
                                                
                                                if(r.getAttribute("Supervisorid")!=null) {
                                                  erks.addScript(fctx," supervisorid.push('"+r.getAttribute("Supervisorid").toString()+"')");
                                                 }  
                                                 else {
                                                 erks.addScript(fctx," supervisorid.push('')");
                                                } 
                                                 if(r.getAttribute("Supervisorname")!=null) {
                                                 erks.addScript(fctx," supervisorname.push('"+r.getAttribute("Supervisorname").toString()+"')");
                                                 }  
                                                  else {
                                                 erks.addScript(fctx," supervisorname.push('')");
                                                 } 
                                                if(r.getAttribute("Supervisorcontactnum")!=null) {
                                                erks.addScript(fctx," supervisorcontactnum.push('"+r.getAttribute("Supervisorcontactnum").toString()+"')");
                                                }  
                                                 else {
                                                erks.addScript(fctx," supervisorcontactnum.push('')");
                                                } 
                                                erks.addScript(fctx,"active.push('2')");
                                                
                                            }
                        }
                        
                    erks.addScript(fctx,"loadMap(long, lat, piid, piname, cnumber, sector, activesince,supervisorid,supervisorname,supervisorcontactnum, active)");    
                    }
  /* PVT Map */ 
    public void getallmapcoordinates(java.sql.Timestamp startTime ,java.sql.Timestamp endTime ,String sectorCode ){
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks =Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
        ViewObject loc1=(ViewObject)getPVTHeaderMapRVO1();
        if(sectorCode!=null){
        loc1.setWhereClause("PVT_date_time between '"+startTime+"' and '"+endTime+"'" + 
        "     and Sector_Code =  isnull('"+sectorCode+"',Sector_Code)" + 
        "     and ISNULL(PVT_VHCL_geo_lat,0) != 0 and isnull(PVT_VHCL_geo_lon,0) != 0");
        }
        else{
            loc1.setWhereClause("PVT_date_time between '"+startTime+"' and '"+endTime+"'" + 
            "     and Sector_Code =  isnull("+sectorCode+",Sector_Code)" + 
            "     and ISNULL(PVT_VHCL_geo_lat,0) != 0 and isnull(PVT_VHCL_geo_lon,0) != 0");   
        }
        System.out.println("PVT Map Query is:::"+loc1.getQuery());
        loc1.executeQuery();
        
        RowSetIterator rsi1=loc1.createRowSetIterator(null);
              
        erks.addScript(fctx,"var long1 = [];");
        erks.addScript(fctx,"var lat1 = [];");
        erks.addScript(fctx,"var long = [];");
        erks.addScript(fctx,"var lat = [];");
        erks.addScript(fctx,"var pvtnum = [];");
        erks.addScript(fctx,"var plateid = [];");
        erks.addScript(fctx,"var piid = [];");
        erks.addScript(fctx,"var sector = [];");
        erks.addScript(fctx,"var zone = [];");
        erks.addScript(fctx,"var pvtdatetime = [];");
        erks.addScript(fctx,"var contracode = [];");
    
               while(rsi1.hasNext()) {
                                     Row r=rsi1.next();
                                     /*  System.out.println("Active Values are:::");
                                     System.out.println("geoLon is:::"+r.getAttribute("PVTVHCLgeolon"));
                                     System.out.println("geoLat is:::"+r.getAttribute("PVTVHCLgeolat"));
                                      System.out.println("PVTNum   is:::"+r.getAttribute("PVTNum"));
                                      System.out.println("Plateid  is:::"+r.getAttribute("Plateid"));
                                      System.out.println("piid   is:::"+r.getAttribute("piid"));
                                      System.out.println("SectorCode  is:::"+r.getAttribute("SectorCode"));
                                      System.out.println("zonecode  is:::"+r.getAttribute("zonecode")); 
                                      System.out.println("PVTdatetime  is:::"+r.getAttribute("PVTdatetime"));
                                      System.out.println("contracode  is:::"+r.getAttribute("contracode"));*/
                                      
                                      
                                    if(r.getAttribute("PVTVHCLgeolon")!=null && r.getAttribute("PVTVHCLgeolat")!=null) {
                                               erks.addScript(fctx,"long.push('"+r.getAttribute("PVTVHCLgeolon").toString()+"')");
                                               erks.addScript(fctx,"lat.push('"+r.getAttribute("PVTVHCLgeolat").toString()+"')"); 
                                                if(r.getAttribute("PVTNum")!=null) {
                                                   erks.addScript(fctx,"pvtnum.push('"+r.getAttribute("PVTNum").toString()+"')");
                                                }  
                                               else {
                                                 erks.addScript(fctx,"pvtnum.push('')");
                                                 } 
                                             if(r.getAttribute("platenum")!=null) {
                                              erks.addScript(fctx," plateid.push('"+r.getAttribute("platenum").toString()+"')");
                                                }  
                                             else {
                                              erks.addScript(fctx," plateid.push('')");
                                                  } 
                                            if(r.getAttribute("piid")!=null) {
                                              erks.addScript(fctx," piid.push('"+r.getAttribute("piid").toString()+"')");
                                                  }  
                                            else {
                                             erks.addScript(fctx," piid.push('')");
                                            } 
                                            if(r.getAttribute("SectorCode")!=null) {
                                              erks.addScript(fctx," sector.push('"+r.getAttribute("SectorCode").toString()+"')");
                                             }  
                                             else {
                                             erks.addScript(fctx," sector.push('')");
                                            } 
                                             if(r.getAttribute("zonecode")!=null) {
                                             erks.addScript(fctx," zone.push('"+r.getAttribute("zonecode").toString()+"')");
                                             }  
                                              else {
                                             erks.addScript(fctx," zone.push('')");
                                             } 
                                       if(r.getAttribute("PVTdatetime")!=null) {
                                       erks.addScript(fctx," pvtdatetime.push('"+r.getAttribute("PVTdatetime").toString()+"')");
                                       }  
                                        else {
                                       erks.addScript(fctx," pvtdatetime.push('')");
                                       } 
                                       if(r.getAttribute("contracode")!=null) {
                                       erks.addScript(fctx," contracode.push('"+r.getAttribute("contracode").toString()+"')");
                                       }  
                                        else {
                                       erks.addScript(fctx," contracode.push('')");
                                       } 
                                      
                                       
                                   }
               }
                
    erks.addScript(fctx,"loadMap(long,lat,long1,lat1,pvtnum,plateid,piid,sector,zone,pvtdatetime,contracode)"); 
    }

    /**
     * Container's getter for PVTHeaderMapRVO1.
     * @return PVTHeaderMapRVO1
     */
    public ViewObjectImpl getPVTHeaderMapRVO1() {
        return (ViewObjectImpl)findViewObject("PVTHeaderMapRVO1");
    }

    /**
     * Container's getter for GENPIGPSDATAMAPIdleRVO1.
     * @return GENPIGPSDATAMAPIdleRVO1
     */
    public ViewObjectImpl getGENPIGPSDATAMAPIdleRVO1() {
        return (ViewObjectImpl)findViewObject("GENPIGPSDATAMAPIdleRVO1");
    }
}
