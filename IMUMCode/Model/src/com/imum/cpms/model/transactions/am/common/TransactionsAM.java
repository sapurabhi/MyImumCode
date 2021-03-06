package com.imum.cpms.model.transactions.am.common;

import java.math.BigDecimal;

import java.sql.Date;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jul 09 13:04:50 IST 2014
// ---------------------------------------------------------------------
public interface TransactionsAM extends ApplicationModule {
    void searchCritRow();

    void commit();

    void callValProc();


    void updateSpoiledPVT(String userId,ArrayList pvts, String remarks);
    Boolean getPVTDetails(String PVTNum);
    void delRecieptDetail();


    String displayTransRefNum();

    void pushIssReturnHeader(Integer toLoc, Integer fromLoc, Date dispatchDate,
                             String createdBy, String tranType);

    void pushIssReturnDetail(String encoder, String reasons, String fromPage);

    void addNewCardTypeMst(String encoder);

    void fecthCardTypeMst(String encoder, String mode, String typeCode);


    String doCreatePayment(BigDecimal CustomerId, Number SaleReceiptNumber,
                           Date SaleDate, String location,
                           BigDecimal Totalamount, String encoder);

    void addPaymentRow(String encoder);


    void uploadPvtDocs(String encoder, ArrayList uploadFiles);

    void addPVTHeaderData(String userid);

    void plateCategoryTypeDependentLOV(int plateCategory);

    void vehicleMakeModelDependentLOV(int vehicleMake);


    Long getPVTCountForVehicle(String PVTNum);

    int getDiscountHeaderSeq();

    int getPlateCountryForPlateCategory(int PlateCategoryId);

    BigDecimal getContraAmtForContraCode(int ContraCode);

    String getSeqPVTPayMents(String pvtNo);

    String doCreatePVTPayment(BigDecimal CustomerId, BigDecimal paidAmt,
                              String encoder, BigDecimal outSatndingAmt,
                              ArrayList pvtNumList);

    void callRemovalChargesProc();

    void PVTPaymentCallRemovalCharges(BigDecimal pvtHdrSeq);

    String cardTypeLength(String cardType);
    void PVTupdatePaymentDetails(BigDecimal pvtHdrSeq, BigDecimal payableAmt);

    Boolean doRollback();

    Boolean doCommit();


    void createNewDepAckDtls(String encoder);


    void uploadPvtDocsPVTPayments(String encoder, ArrayList uploadFiles,
                                  BigDecimal pvtHdrseq);

    int checkPVTNumberExists(String pvtNumber);

    Map getPVTRemovalStatus(Map pvtMap);
    
    void createNewRowDocUpload(String encoder);

     void addUploadDoc(String encoder);

    void updateBayStatusByLocIdAndBayNo(String pvtNo, BigDecimal baySeq,
                                        String modifiedBy);

    void executeEmptyRowHeaderVO();

    void updateRollbackDiscountStatus(String userName,
                                      int rollbackDiscountSeq);

    String updatePvtStatusForReleaseOnHold(int pvtStatus, String loggerName,
                                           String notesEvent);

    void updatePVTEventAndAccountLog(BigDecimal pvtHeaderSeq,
                                     String loggerName, String remarks,
                                     BigDecimal knockAmt);


    String getPVTForAmtAdjustment(String PVTNum);

    Boolean CreateEvent(BigDecimal pvtHeaderSeq, String loggerName,
                        String remarks, String EventId);


    void createDocUploadPoundAlloc(String encoder);

    void pvtHeaderSiebleSynch(BigDecimal pvtHdrSeq);

    Boolean IntPVTAdjSP(BigDecimal pvtHDRSeq);
    void addPVTCancelHeaderData(String userid);
    String PVTupdateAdjustmentAmt(BigDecimal pvtHdrSeq,
                                  BigDecimal PVTAdjAmount, String loggerName,
                                  String Operator);


    void getPISupId();
    String ADPPrintDetails(String PVTHeaderId);

    void getPiPvts(String piid, String pidate);

    void getPisforShiftSector(String sup_id, String SName, int Shift,
                              String pidate);


    String submitCards(String username, String loc);

    int resultCards(String str, String end);

    String CallPaymentProcedure(String PVTNumber, String Amount, Date sqlDate,
                                String ReceiptNumber, String Transactionid,
                                String kiosklocation, String PaymentChannel,
                                String userName);


    Boolean fetchExpectedAmt(String tranDate, String locId,
                             Date transdateformat);

    String CreateGenEventDetails(BigDecimal depositAckSeqbigD,
                                 String NewDepSlip, String OldDepSlip,
                                 String encoder, Integer EventId);

    String SearchReceiptNumber(String receiptNumber);
    String pvtSearch(String sector, String zone, String pvtnum,
                     String contracode);

    void CARDentryEventDetails(String oldpayment, String newpayment,
                               String cardnumber, String loggedinuser);
    String pvtdiscountsearch(String sector, String zone, String pvtnum,
                             String contracode, int seq);

    void PRMentryEventDetails(String oldpayment, String newpayment,
                              String permitnumber, String loggedinuser);

    void PVTentryEventDetails(String oldpayment, String newpayment,
                              String PVTNumber, String loggedinuser);

    void CreateNewRemarks(String username, String remarks,
                          BigDecimal PvthdrSeqBD);

    void CreateNewPVTDocument(String username, String fullPath,
                              BigDecimal pvtHdrseq, String doctype,
                              String DOCDesc);

    Boolean PVTDocsSeibelSync();

    Boolean sendMail(BigDecimal pvtHdrSeq);

    Boolean pvteventsendDoTInstructions(BigDecimal pvtHeaderSeq,
                                        String loggerName, String remarks,
                                        String EventId);

    String PVTDoTInstructionsAmt(BigDecimal pvtHdrSeq, BigDecimal PVTAdjAmount,
                                 String loggerName, String Operator);

    Boolean clampingEvents(BigDecimal pvtHeaderSeq, String loggerName,
                           String remarks, String EventId);
    String saveAuctionInitiationDetails(Date auctionInitiationDate,
                                        Integer selectCount, String status,
                                        String createdBy);

    String getAuctionInitiationPvtDetails(BigDecimal auctionHeaderseq);

    void doSearchPvtPermit(String modetype, String hdrseq);

    void executeMyAssignments();
    String getAuctionEvidenceSearchPvtDetails(BigDecimal auctionHeaderseq);

    String getAuctionHouseEvaluationPvtDetails(BigDecimal auctionHeaderseq);
    int getissdetailSeq();

    void createNewRowDocUploadReleaseVehicle(String encoder);

    void callClampingChargesProc(BigDecimal pvthdrseq, Integer enfcVhclId);

    void createDocUploadAuctionEvidence(String encoder);

    void resetAuctionInitiation();

    void resetAuctionEvaluation();

    void createDocUploadAuctionEvaluation(String encoder);

    void resetAuctionClosing();

    String getAuctionClosingPvtDetails(BigDecimal auctionHeaderseq);

    void createDocUploadAuctionClosing(String encoder);


    String saveAuctionEvidenceDetails(BigDecimal auctionHeaderseq,
                                      Date updatedDate, String updatedby);


    String saveAuctionClosingDetails(BigDecimal auctionHeaderseq,
                                     Date updatedDate, String updatedby);

    

    String saveAuctionHouseEvaluationDetails(BigDecimal auctionHeaderseq,
                                             String auctionHouseRef,
                                             Date updatedDate,
                                             String updatedby);

    String saveAuctionHouseEvaluationPvtDetails(BigDecimal auctionHeaderseq,
                                                String auctionEvaluation,
                                                BigDecimal auctionEvaluationValue,
                                                Boolean auctionNOCReceived,
                                                String auctionVenue,
                                                Date updatedDate,
                                                String updatedBy,
                                                BigDecimal pvthdrseq);

    String saveAuctionClosingPvtDetails(BigDecimal auctionHeaderseq,
                                        BigDecimal finalBidAmount,
                                        String bidderName, String remarks,
                                        Date bidDate,
                                        Date auctionInitiationDate,
                                        String updatedBy,
                                        BigDecimal pvthdrseq);

    void createNewRowDocUploadFree(String encoder);


    Integer callGenPiGpsDataMapProc(Date date, Integer shift);

    void getallpicoordinates(Integer runseqno);

    void getallmapcoordinates(Timestamp startTime, Timestamp endTime,
                              String sectorCode);

    void getPiLocationCoordinates(String piid, String pidate);
}
