package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Sep 06 14:23:50 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AuctionEvidenceSearchVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PVTNum {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTNum();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTNum((String)value);
            }
        }
        ,
        PVTHDRSEQ {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTHDRSEQ();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTHDRSEQ((BigDecimal)value);
            }
        }
        ,
        PVTAMTREFUNDED {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTAMTREFUNDED();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTAMTREFUNDED((BigDecimal)value);
            }
        }
        ,
        PVTAMTPAYABLE {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTAMTPAYABLE();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTAMTPAYABLE((BigDecimal)value);
            }
        }
        ,
        PVTAMTPAID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTAMTPAID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTAMTPAID((BigDecimal)value);
            }
        }
        ,
        SectorCode {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getSectorCode();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setSectorCode((String)value);
            }
        }
        ,
        zonecode {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getzonecode();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setzonecode((String)value);
            }
        }
        ,
        PVTFromDate {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTFromDate();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTFromDate((Timestamp)value);
            }
        }
        ,
        PVTToDate {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTToDate();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTToDate((Timestamp)value);
            }
        }
        ,
        CreatedDate {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        PLATENUMBER {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPLATENUMBER();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPLATENUMBER((String)value);
            }
        }
        ,
        PVTSTAGEID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPVTSTAGEID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPVTSTAGEID((Integer)value);
            }
        }
        ,
        PLATECNTID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPLATECNTID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPLATECNTID((Integer)value);
            }
        }
        ,
        PLATECTGID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPLATECTGID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPLATECTGID((Integer)value);
            }
        }
        ,
        PLATETYPEID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getPLATETYPEID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setPLATETYPEID((Integer)value);
            }
        }
        ,
        VEHMAKEID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVEHMAKEID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setVEHMAKEID((Integer)value);
            }
        }
        ,
        VEHMODELID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVEHMODELID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setVEHMODELID((Integer)value);
            }
        }
        ,
        VEHCOLOURID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVEHCOLOURID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setVEHCOLOURID((Integer)value);
            }
        }
        ,
        ActiveFlag {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getActiveFlag();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setActiveFlag((String)value);
            }
        }
        ,
        DotApprvforAuctflag {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getDotApprvforAuctflag();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setDotApprvforAuctflag((String)value);
            }
        }
        ,
        Remarks {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getRemarks();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        AUCTIONHeaderseq {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getAUCTIONHeaderseq();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAUCTIONHeaderseq((BigDecimal)value);
            }
        }
        ,
        ValuationAmt {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getValuationAmt();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setValuationAmt((BigDecimal)value);
            }
        }
        ,
        ValuationRecomdationID {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getValuationRecomdationID();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setValuationRecomdationID((Integer)value);
            }
        }
        ,
        FinalBidAmt {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getFinalBidAmt();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setFinalBidAmt((BigDecimal)value);
            }
        }
        ,
        vehownershiptypeid {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getvehownershiptypeid();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setvehownershiptypeid((Integer)value);
            }
        }
        ,
        Balance {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getBalance();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setBalance((BigDecimal)value);
            }
        }
        ,
        SelectFlag {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getSelectFlag();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setSelectFlag((Boolean)value);
            }
        }
        ,
        VehColourmstVO1 {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVehColourmstVO1();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehicleCountrymstVO1 {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVehicleCountrymstVO1();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehiclePlateCategoryVO1 {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVehiclePlateCategoryVO1();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehiclePlateTypeVO1 {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVehiclePlateTypeVO1();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehMakeMstVO1 {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVehMakeMstVO1();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehModelMstVO1 {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getVehModelMstVO1();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        AuctionVehOwnshipTypeLOVVO1 {
            public Object get(AuctionEvidenceSearchVORowImpl obj) {
                return obj.getAuctionVehOwnshipTypeLOVVO1();
            }

            public void put(AuctionEvidenceSearchVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(AuctionEvidenceSearchVORowImpl object);

        public abstract void put(AuctionEvidenceSearchVORowImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int PVTNUM = AttributesEnum.PVTNum.index();
    public static final int PVTHDRSEQ = AttributesEnum.PVTHDRSEQ.index();
    public static final int PVTAMTREFUNDED = AttributesEnum.PVTAMTREFUNDED.index();
    public static final int PVTAMTPAYABLE = AttributesEnum.PVTAMTPAYABLE.index();
    public static final int PVTAMTPAID = AttributesEnum.PVTAMTPAID.index();
    public static final int SECTORCODE = AttributesEnum.SectorCode.index();
    public static final int ZONECODE = AttributesEnum.zonecode.index();
    public static final int PVTFROMDATE = AttributesEnum.PVTFromDate.index();
    public static final int PVTTODATE = AttributesEnum.PVTToDate.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int PLATENUMBER = AttributesEnum.PLATENUMBER.index();
    public static final int PVTSTAGEID = AttributesEnum.PVTSTAGEID.index();
    public static final int PLATECNTID = AttributesEnum.PLATECNTID.index();
    public static final int PLATECTGID = AttributesEnum.PLATECTGID.index();
    public static final int PLATETYPEID = AttributesEnum.PLATETYPEID.index();
    public static final int VEHMAKEID = AttributesEnum.VEHMAKEID.index();
    public static final int VEHMODELID = AttributesEnum.VEHMODELID.index();
    public static final int VEHCOLOURID = AttributesEnum.VEHCOLOURID.index();
    public static final int ACTIVEFLAG = AttributesEnum.ActiveFlag.index();
    public static final int DOTAPPRVFORAUCTFLAG = AttributesEnum.DotApprvforAuctflag.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int AUCTIONHEADERSEQ = AttributesEnum.AUCTIONHeaderseq.index();
    public static final int VALUATIONAMT = AttributesEnum.ValuationAmt.index();
    public static final int VALUATIONRECOMDATIONID = AttributesEnum.ValuationRecomdationID.index();
    public static final int FINALBIDAMT = AttributesEnum.FinalBidAmt.index();
    public static final int VEHOWNERSHIPTYPEID = AttributesEnum.vehownershiptypeid.index();
    public static final int BALANCE = AttributesEnum.Balance.index();
    public static final int SELECTFLAG = AttributesEnum.SelectFlag.index();
    public static final int VEHCOLOURMSTVO1 = AttributesEnum.VehColourmstVO1.index();
    public static final int VEHICLECOUNTRYMSTVO1 = AttributesEnum.VehicleCountrymstVO1.index();
    public static final int VEHICLEPLATECATEGORYVO1 = AttributesEnum.VehiclePlateCategoryVO1.index();
    public static final int VEHICLEPLATETYPEVO1 = AttributesEnum.VehiclePlateTypeVO1.index();
    public static final int VEHMAKEMSTVO1 = AttributesEnum.VehMakeMstVO1.index();
    public static final int VEHMODELMSTVO1 = AttributesEnum.VehModelMstVO1.index();
    public static final int AUCTIONVEHOWNSHIPTYPELOVVO1 = AttributesEnum.AuctionVehOwnshipTypeLOVVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public AuctionEvidenceSearchVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute PVTNum.
     * @return the PVTNum
     */
    public String getPVTNum() {
        return (String) getAttributeInternal(PVTNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTNum.
     * @param value value to set the  PVTNum
     */
    public void setPVTNum(String value) {
        setAttributeInternal(PVTNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTHDRSEQ.
     * @return the PVTHDRSEQ
     */
    public BigDecimal getPVTHDRSEQ() {
        return (BigDecimal) getAttributeInternal(PVTHDRSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTHDRSEQ.
     * @param value value to set the  PVTHDRSEQ
     */
    public void setPVTHDRSEQ(BigDecimal value) {
        setAttributeInternal(PVTHDRSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTAMTREFUNDED.
     * @return the PVTAMTREFUNDED
     */
    public BigDecimal getPVTAMTREFUNDED() {
        return (BigDecimal) getAttributeInternal(PVTAMTREFUNDED);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTAMTREFUNDED.
     * @param value value to set the  PVTAMTREFUNDED
     */
    public void setPVTAMTREFUNDED(BigDecimal value) {
        setAttributeInternal(PVTAMTREFUNDED, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTAMTPAYABLE.
     * @return the PVTAMTPAYABLE
     */
    public BigDecimal getPVTAMTPAYABLE() {
        return (BigDecimal) getAttributeInternal(PVTAMTPAYABLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTAMTPAYABLE.
     * @param value value to set the  PVTAMTPAYABLE
     */
    public void setPVTAMTPAYABLE(BigDecimal value) {
        setAttributeInternal(PVTAMTPAYABLE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTAMTPAID.
     * @return the PVTAMTPAID
     */
    public BigDecimal getPVTAMTPAID() {
        return (BigDecimal) getAttributeInternal(PVTAMTPAID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTAMTPAID.
     * @param value value to set the  PVTAMTPAID
     */
    public void setPVTAMTPAID(BigDecimal value) {
        setAttributeInternal(PVTAMTPAID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SectorCode.
     * @return the SectorCode
     */
    public String getSectorCode() {
        return (String) getAttributeInternal(SECTORCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SectorCode.
     * @param value value to set the  SectorCode
     */
    public void setSectorCode(String value) {
        setAttributeInternal(SECTORCODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute zonecode.
     * @return the zonecode
     */
    public String getzonecode() {
        return (String) getAttributeInternal(ZONECODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute zonecode.
     * @param value value to set the  zonecode
     */
    public void setzonecode(String value) {
        setAttributeInternal(ZONECODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTFromDate.
     * @return the PVTFromDate
     */
    public Timestamp getPVTFromDate() {
        return (Timestamp) getAttributeInternal(PVTFROMDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTFromDate.
     * @param value value to set the  PVTFromDate
     */
    public void setPVTFromDate(Timestamp value) {
        setAttributeInternal(PVTFROMDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTToDate.
     * @return the PVTToDate
     */
    public Timestamp getPVTToDate() {
        return (Timestamp) getAttributeInternal(PVTTODATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTToDate.
     * @param value value to set the  PVTToDate
     */
    public void setPVTToDate(Timestamp value) {
        setAttributeInternal(PVTTODATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreatedDate.
     * @return the CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreatedDate.
     * @param value value to set the  CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PLATENUMBER.
     * @return the PLATENUMBER
     */
    public String getPLATENUMBER() {
        return (String) getAttributeInternal(PLATENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PLATENUMBER.
     * @param value value to set the  PLATENUMBER
     */
    public void setPLATENUMBER(String value) {
        setAttributeInternal(PLATENUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTSTAGEID.
     * @return the PVTSTAGEID
     */
    public Integer getPVTSTAGEID() {
        return (Integer) getAttributeInternal(PVTSTAGEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTSTAGEID.
     * @param value value to set the  PVTSTAGEID
     */
    public void setPVTSTAGEID(Integer value) {
        setAttributeInternal(PVTSTAGEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PLATECNTID.
     * @return the PLATECNTID
     */
    public Integer getPLATECNTID() {
        return (Integer) getAttributeInternal(PLATECNTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PLATECNTID.
     * @param value value to set the  PLATECNTID
     */
    public void setPLATECNTID(Integer value) {
        setAttributeInternal(PLATECNTID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PLATECTGID.
     * @return the PLATECTGID
     */
    public Integer getPLATECTGID() {
        return (Integer) getAttributeInternal(PLATECTGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PLATECTGID.
     * @param value value to set the  PLATECTGID
     */
    public void setPLATECTGID(Integer value) {
        setAttributeInternal(PLATECTGID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PLATETYPEID.
     * @return the PLATETYPEID
     */
    public Integer getPLATETYPEID() {
        return (Integer) getAttributeInternal(PLATETYPEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PLATETYPEID.
     * @param value value to set the  PLATETYPEID
     */
    public void setPLATETYPEID(Integer value) {
        setAttributeInternal(PLATETYPEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute VEHMAKEID.
     * @return the VEHMAKEID
     */
    public Integer getVEHMAKEID() {
        return (Integer) getAttributeInternal(VEHMAKEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute VEHMAKEID.
     * @param value value to set the  VEHMAKEID
     */
    public void setVEHMAKEID(Integer value) {
        setAttributeInternal(VEHMAKEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute VEHMODELID.
     * @return the VEHMODELID
     */
    public Integer getVEHMODELID() {
        return (Integer) getAttributeInternal(VEHMODELID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute VEHMODELID.
     * @param value value to set the  VEHMODELID
     */
    public void setVEHMODELID(Integer value) {
        setAttributeInternal(VEHMODELID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute VEHCOLOURID.
     * @return the VEHCOLOURID
     */
    public Integer getVEHCOLOURID() {
        return (Integer) getAttributeInternal(VEHCOLOURID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute VEHCOLOURID.
     * @param value value to set the  VEHCOLOURID
     */
    public void setVEHCOLOURID(Integer value) {
        setAttributeInternal(VEHCOLOURID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ActiveFlag.
     * @return the ActiveFlag
     */
    public String getActiveFlag() {
        return (String) getAttributeInternal(ACTIVEFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ActiveFlag.
     * @param value value to set the  ActiveFlag
     */
    public void setActiveFlag(String value) {
        setAttributeInternal(ACTIVEFLAG, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DotApprvforAuctflag.
     * @return the DotApprvforAuctflag
     */
    public String getDotApprvforAuctflag() {
        return (String) getAttributeInternal(DOTAPPRVFORAUCTFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DotApprvforAuctflag.
     * @param value value to set the  DotApprvforAuctflag
     */
    public void setDotApprvforAuctflag(String value) {
        setAttributeInternal(DOTAPPRVFORAUCTFLAG, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Remarks.
     * @return the Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Remarks.
     * @param value value to set the  Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute AUCTIONHeaderseq.
     * @return the AUCTIONHeaderseq
     */
    public BigDecimal getAUCTIONHeaderseq() {
        return (BigDecimal) getAttributeInternal(AUCTIONHEADERSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AUCTIONHeaderseq.
     * @param value value to set the  AUCTIONHeaderseq
     */
    public void setAUCTIONHeaderseq(BigDecimal value) {
        setAttributeInternal(AUCTIONHEADERSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ValuationAmt.
     * @return the ValuationAmt
     */
    public BigDecimal getValuationAmt() {
        return (BigDecimal) getAttributeInternal(VALUATIONAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ValuationAmt.
     * @param value value to set the  ValuationAmt
     */
    public void setValuationAmt(BigDecimal value) {
        setAttributeInternal(VALUATIONAMT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ValuationRecomdationID.
     * @return the ValuationRecomdationID
     */
    public Integer getValuationRecomdationID() {
        return (Integer) getAttributeInternal(VALUATIONRECOMDATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ValuationRecomdationID.
     * @param value value to set the  ValuationRecomdationID
     */
    public void setValuationRecomdationID(Integer value) {
        setAttributeInternal(VALUATIONRECOMDATIONID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute FinalBidAmt.
     * @return the FinalBidAmt
     */
    public BigDecimal getFinalBidAmt() {
        return (BigDecimal) getAttributeInternal(FINALBIDAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute FinalBidAmt.
     * @param value value to set the  FinalBidAmt
     */
    public void setFinalBidAmt(BigDecimal value) {
        setAttributeInternal(FINALBIDAMT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute vehownershiptypeid.
     * @return the vehownershiptypeid
     */
    public Integer getvehownershiptypeid() {
        return (Integer) getAttributeInternal(VEHOWNERSHIPTYPEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute vehownershiptypeid.
     * @param value value to set the  vehownershiptypeid
     */
    public void setvehownershiptypeid(Integer value) {
        setAttributeInternal(VEHOWNERSHIPTYPEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Balance.
     * @return the Balance
     */
    public BigDecimal getBalance() {
        return (BigDecimal) getAttributeInternal(BALANCE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Balance.
     * @param value value to set the  Balance
     */
    public void setBalance(BigDecimal value) {
        setAttributeInternal(BALANCE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SelectFlag.
     * @return the SelectFlag
     */
    public Boolean getSelectFlag() {
        return (Boolean) getAttributeInternal(SELECTFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SelectFlag.
     * @param value value to set the  SelectFlag
     */
    public void setSelectFlag(Boolean value) {
        setAttributeInternal(SELECTFLAG, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehColourmstVO1.
     */
    public RowSet getVehColourmstVO1() {
        return (RowSet)getAttributeInternal(VEHCOLOURMSTVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehicleCountrymstVO1.
     */
    public RowSet getVehicleCountrymstVO1() {
        return (RowSet)getAttributeInternal(VEHICLECOUNTRYMSTVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehiclePlateCategoryVO1.
     */
    public RowSet getVehiclePlateCategoryVO1() {
        return (RowSet)getAttributeInternal(VEHICLEPLATECATEGORYVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehiclePlateTypeVO1.
     */
    public RowSet getVehiclePlateTypeVO1() {
        return (RowSet)getAttributeInternal(VEHICLEPLATETYPEVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehMakeMstVO1.
     */
    public RowSet getVehMakeMstVO1() {
        return (RowSet)getAttributeInternal(VEHMAKEMSTVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehModelMstVO1.
     */
    public RowSet getVehModelMstVO1() {
        return (RowSet)getAttributeInternal(VEHMODELMSTVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> AuctionVehOwnshipTypeLOVVO1.
     */
    public RowSet getAuctionVehOwnshipTypeLOVVO1() {
        return (RowSet)getAttributeInternal(AUCTIONVEHOWNSHIPTYPELOVVO1);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
