package com.imum.cpms.model.transactions.vo;

import com.imum.cpms.model.transactions.eo.PVTDiscCnclHeaderEOImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 27 16:40:26 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTDiscCnclHeaderVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        DISCCNCLhdrSeq {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDISCCNCLhdrSeq();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDISCCNCLhdrSeq((BigDecimal)value);
            }
        }
        ,
        DISCCNCLTYPE {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDISCCNCLTYPE();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDISCCNCLTYPE((String)value);
            }
        }
        ,
        DISCPROMOCODE {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDISCPROMOCODE();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDISCPROMOCODE((String)value);
            }
        }
        ,
        DISCPROMONAME {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDISCPROMONAME();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDISCPROMONAME((String)value);
            }
        }
        ,
        Contracode {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getContracode();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setContracode((Integer)value);
            }
        }
        ,
        PVTdatefrom {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTdatefrom();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPVTdatefrom((Timestamp)value);
            }
        }
        ,
        PVTdateto {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTdateto();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPVTdateto((Timestamp)value);
            }
        }
        ,
        PVTSOURCE {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTSOURCE();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPVTSOURCE((String)value);
            }
        }
        ,
        PVTStatusID {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTStatusID();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPVTStatusID((Integer)value);
            }
        }
        ,
        PVTSTAGEID {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTSTAGEID();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPVTSTAGEID((Integer)value);
            }
        }
        ,
        DISCPCT {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDISCPCT();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDISCPCT((BigDecimal)value);
            }
        }
        ,
        DISCFLATAMT {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDISCFLATAMT();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDISCFLATAMT((BigDecimal)value);
            }
        }
        ,
        PVTAmtRangefrom {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTAmtRangefrom();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPVTAmtRangefrom((BigDecimal)value);
            }
        }
        ,
        PVTAmtRangeTo {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTAmtRangeTo();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPVTAmtRangeTo((BigDecimal)value);
            }
        }
        ,
        Promoeffectivedatefrom {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPromoeffectivedatefrom();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPromoeffectivedatefrom((Timestamp)value);
            }
        }
        ,
        PromoeffectivedateTo {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPromoeffectivedateTo();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPromoeffectivedateTo((Timestamp)value);
            }
        }
        ,
        PlateCountryID {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateCountryID();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPlateCountryID((Integer)value);
            }
        }
        ,
        SectorCode {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getSectorCode();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setSectorCode((String)value);
            }
        }
        ,
        zonecode {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getzonecode();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setzonecode((String)value);
            }
        }
        ,
        DISCCNCLSTATUS {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDISCCNCLSTATUS();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDISCCNCLSTATUS((Integer)value);
            }
        }
        ,
        Remarks {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getRemarks();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        ApprovedBy {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getApprovedBy();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setApprovedBy((String)value);
            }
        }
        ,
        ApprovedDate {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getApprovedDate();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setApprovedDate((Timestamp)value);
            }
        }
        ,
        ApproverRemarks {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getApproverRemarks();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setApproverRemarks((String)value);
            }
        }
        ,
        DEFCityCode {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDEFCityCode();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDEFCityCode((String)value);
            }
        }
        ,
        DEFCountryCode {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getDEFCountryCode();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setDEFCountryCode((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        updateddate {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getupdateddate();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setupdateddate((Timestamp)value);
            }
        }
        ,
        PlateType {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateType();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPlateType((Integer)value);
            }
        }
        ,
        PlateCategory {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateCategory();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPlateCategory((Integer)value);
            }
        }
        ,
        PlateNumber {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateNumber();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPlateNumber((String)value);
            }
        }
        ,
        PlateCountry {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateCountry();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setPlateCountry((Integer)value);
            }
        }
        ,
        ZoneLOVVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getZoneLOVVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PVTStatusLOVVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTStatusLOVVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PVTStageLOVVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPVTStageLOVVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PlateCategoryLOVVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateCategoryLOVVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PlateTypeLOVVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateTypeLOVVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ContraCodeLOVVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getContraCodeLOVVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        SectorLovVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getSectorLovVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehiclePlateCountryLVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getVehiclePlateCountryLVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PlateCountryLOVVO1 {
            public Object get(PVTDiscCnclHeaderVORowImpl obj) {
                return obj.getPlateCountryLOVVO1();
            }

            public void put(PVTDiscCnclHeaderVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PVTDiscCnclHeaderVORowImpl object);

        public abstract void put(PVTDiscCnclHeaderVORowImpl object,
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


    public static final int DISCCNCLHDRSEQ = AttributesEnum.DISCCNCLhdrSeq.index();
    public static final int DISCCNCLTYPE = AttributesEnum.DISCCNCLTYPE.index();
    public static final int DISCPROMOCODE = AttributesEnum.DISCPROMOCODE.index();
    public static final int DISCPROMONAME = AttributesEnum.DISCPROMONAME.index();
    public static final int CONTRACODE = AttributesEnum.Contracode.index();
    public static final int PVTDATEFROM = AttributesEnum.PVTdatefrom.index();
    public static final int PVTDATETO = AttributesEnum.PVTdateto.index();
    public static final int PVTSOURCE = AttributesEnum.PVTSOURCE.index();
    public static final int PVTSTATUSID = AttributesEnum.PVTStatusID.index();
    public static final int PVTSTAGEID = AttributesEnum.PVTSTAGEID.index();
    public static final int DISCPCT = AttributesEnum.DISCPCT.index();
    public static final int DISCFLATAMT = AttributesEnum.DISCFLATAMT.index();
    public static final int PVTAMTRANGEFROM = AttributesEnum.PVTAmtRangefrom.index();
    public static final int PVTAMTRANGETO = AttributesEnum.PVTAmtRangeTo.index();
    public static final int PROMOEFFECTIVEDATEFROM = AttributesEnum.Promoeffectivedatefrom.index();
    public static final int PROMOEFFECTIVEDATETO = AttributesEnum.PromoeffectivedateTo.index();
    public static final int PLATECOUNTRYID = AttributesEnum.PlateCountryID.index();
    public static final int SECTORCODE = AttributesEnum.SectorCode.index();
    public static final int ZONECODE = AttributesEnum.zonecode.index();
    public static final int DISCCNCLSTATUS = AttributesEnum.DISCCNCLSTATUS.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int APPROVEDBY = AttributesEnum.ApprovedBy.index();
    public static final int APPROVEDDATE = AttributesEnum.ApprovedDate.index();
    public static final int APPROVERREMARKS = AttributesEnum.ApproverRemarks.index();
    public static final int DEFCITYCODE = AttributesEnum.DEFCityCode.index();
    public static final int DEFCOUNTRYCODE = AttributesEnum.DEFCountryCode.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.updateddate.index();
    public static final int PLATETYPE = AttributesEnum.PlateType.index();
    public static final int PLATECATEGORY = AttributesEnum.PlateCategory.index();
    public static final int PLATENUMBER = AttributesEnum.PlateNumber.index();
    public static final int PLATECOUNTRY = AttributesEnum.PlateCountry.index();
    public static final int ZONELOVVO1 = AttributesEnum.ZoneLOVVO1.index();
    public static final int PVTSTATUSLOVVO1 = AttributesEnum.PVTStatusLOVVO1.index();
    public static final int PVTSTAGELOVVO1 = AttributesEnum.PVTStageLOVVO1.index();
    public static final int PLATECATEGORYLOVVO1 = AttributesEnum.PlateCategoryLOVVO1.index();
    public static final int PLATETYPELOVVO1 = AttributesEnum.PlateTypeLOVVO1.index();
    public static final int CONTRACODELOVVO1 = AttributesEnum.ContraCodeLOVVO1.index();
    public static final int SECTORLOVVO1 = AttributesEnum.SectorLovVO1.index();
    public static final int VEHICLEPLATECOUNTRYLVO1 = AttributesEnum.VehiclePlateCountryLVO1.index();
    public static final int PLATECOUNTRYLOVVO1 = AttributesEnum.PlateCountryLOVVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PVTDiscCnclHeaderVORowImpl() {
    }

    /**
     * Gets PVTDiscCnclHeaderEO entity object.
     * @return the PVTDiscCnclHeaderEO
     */
    public PVTDiscCnclHeaderEOImpl getPVTDiscCnclHeaderEO() {
        return (PVTDiscCnclHeaderEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for DISC_CNCL_hdr_Seq using the alias name DISCCNCLhdrSeq.
     * @return the DISC_CNCL_hdr_Seq
     */
    public BigDecimal getDISCCNCLhdrSeq() {
        return (BigDecimal) getAttributeInternal(DISCCNCLHDRSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for DISC_CNCL_hdr_Seq using the alias name DISCCNCLhdrSeq.
     * @param value value to set the DISC_CNCL_hdr_Seq
     */
    public void setDISCCNCLhdrSeq(BigDecimal value) {
        setAttributeInternal(DISCCNCLHDRSEQ, value);
    }

    /**
     * Gets the attribute value for DISC_CNCL_TYPE using the alias name DISCCNCLTYPE.
     * @return the DISC_CNCL_TYPE
     */
    public String getDISCCNCLTYPE() {
        return (String) getAttributeInternal(DISCCNCLTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for DISC_CNCL_TYPE using the alias name DISCCNCLTYPE.
     * @param value value to set the DISC_CNCL_TYPE
     */
    public void setDISCCNCLTYPE(String value) {
        setAttributeInternal(DISCCNCLTYPE, value);
    }

    /**
     * Gets the attribute value for DISC_PROMO_CODE using the alias name DISCPROMOCODE.
     * @return the DISC_PROMO_CODE
     */
    public String getDISCPROMOCODE() {
        return (String) getAttributeInternal(DISCPROMOCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for DISC_PROMO_CODE using the alias name DISCPROMOCODE.
     * @param value value to set the DISC_PROMO_CODE
     */
    public void setDISCPROMOCODE(String value) {
        setAttributeInternal(DISCPROMOCODE, value);
    }

    /**
     * Gets the attribute value for DISC_PROMO_NAME using the alias name DISCPROMONAME.
     * @return the DISC_PROMO_NAME
     */
    public String getDISCPROMONAME() {
        return (String) getAttributeInternal(DISCPROMONAME);
    }

    /**
     * Sets <code>value</code> as attribute value for DISC_PROMO_NAME using the alias name DISCPROMONAME.
     * @param value value to set the DISC_PROMO_NAME
     */
    public void setDISCPROMONAME(String value) {
        setAttributeInternal(DISCPROMONAME, value);
    }

    /**
     * Gets the attribute value for Contra_code using the alias name Contracode.
     * @return the Contra_code
     */
    public Integer getContracode() {
        return (Integer) getAttributeInternal(CONTRACODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Contra_code using the alias name Contracode.
     * @param value value to set the Contra_code
     */
    public void setContracode(Integer value) {
        setAttributeInternal(CONTRACODE, value);
    }

    /**
     * Gets the attribute value for PVT_date_from using the alias name PVTdatefrom.
     * @return the PVT_date_from
     */
    public Timestamp getPVTdatefrom() {
        return (Timestamp) getAttributeInternal(PVTDATEFROM);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_date_from using the alias name PVTdatefrom.
     * @param value value to set the PVT_date_from
     */
    public void setPVTdatefrom(Timestamp value) {
        setAttributeInternal(PVTDATEFROM, value);
    }

    /**
     * Gets the attribute value for PVT_date_to using the alias name PVTdateto.
     * @return the PVT_date_to
     */
    public Timestamp getPVTdateto() {
        return (Timestamp) getAttributeInternal(PVTDATETO);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_date_to using the alias name PVTdateto.
     * @param value value to set the PVT_date_to
     */
    public void setPVTdateto(Timestamp value) {
        setAttributeInternal(PVTDATETO, value);
    }

    /**
     * Gets the attribute value for PVT_SOURCE using the alias name PVTSOURCE.
     * @return the PVT_SOURCE
     */
    public String getPVTSOURCE() {
        return (String) getAttributeInternal(PVTSOURCE);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_SOURCE using the alias name PVTSOURCE.
     * @param value value to set the PVT_SOURCE
     */
    public void setPVTSOURCE(String value) {
        setAttributeInternal(PVTSOURCE, value);
    }

    /**
     * Gets the attribute value for PVT_Status_ID using the alias name PVTStatusID.
     * @return the PVT_Status_ID
     */
    public Integer getPVTStatusID() {
        return (Integer) getAttributeInternal(PVTSTATUSID);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_Status_ID using the alias name PVTStatusID.
     * @param value value to set the PVT_Status_ID
     */
    public void setPVTStatusID(Integer value) {
        setAttributeInternal(PVTSTATUSID, value);
    }

    /**
     * Gets the attribute value for PVT_STAGE_ID using the alias name PVTSTAGEID.
     * @return the PVT_STAGE_ID
     */
    public Integer getPVTSTAGEID() {
        return (Integer) getAttributeInternal(PVTSTAGEID);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_STAGE_ID using the alias name PVTSTAGEID.
     * @param value value to set the PVT_STAGE_ID
     */
    public void setPVTSTAGEID(Integer value) {
        setAttributeInternal(PVTSTAGEID, value);
    }

    /**
     * Gets the attribute value for DISC_PCT using the alias name DISCPCT.
     * @return the DISC_PCT
     */
    public BigDecimal getDISCPCT() {
        return (BigDecimal) getAttributeInternal(DISCPCT);
    }

    /**
     * Sets <code>value</code> as attribute value for DISC_PCT using the alias name DISCPCT.
     * @param value value to set the DISC_PCT
     */
    public void setDISCPCT(BigDecimal value) {
        setAttributeInternal(DISCPCT, value);
    }

    /**
     * Gets the attribute value for DISC_FLAT_AMT using the alias name DISCFLATAMT.
     * @return the DISC_FLAT_AMT
     */
    public BigDecimal getDISCFLATAMT() {
        return (BigDecimal) getAttributeInternal(DISCFLATAMT);
    }

    /**
     * Sets <code>value</code> as attribute value for DISC_FLAT_AMT using the alias name DISCFLATAMT.
     * @param value value to set the DISC_FLAT_AMT
     */
    public void setDISCFLATAMT(BigDecimal value) {
        setAttributeInternal(DISCFLATAMT, value);
    }

    /**
     * Gets the attribute value for PVT_Amt_Range_from using the alias name PVTAmtRangefrom.
     * @return the PVT_Amt_Range_from
     */
    public BigDecimal getPVTAmtRangefrom() {
        return (BigDecimal) getAttributeInternal(PVTAMTRANGEFROM);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_Amt_Range_from using the alias name PVTAmtRangefrom.
     * @param value value to set the PVT_Amt_Range_from
     */
    public void setPVTAmtRangefrom(BigDecimal value) {
        setAttributeInternal(PVTAMTRANGEFROM, value);
    }

    /**
     * Gets the attribute value for PVT_Amt_Range_To using the alias name PVTAmtRangeTo.
     * @return the PVT_Amt_Range_To
     */
    public BigDecimal getPVTAmtRangeTo() {
        return (BigDecimal) getAttributeInternal(PVTAMTRANGETO);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_Amt_Range_To using the alias name PVTAmtRangeTo.
     * @param value value to set the PVT_Amt_Range_To
     */
    public void setPVTAmtRangeTo(BigDecimal value) {
        setAttributeInternal(PVTAMTRANGETO, value);
    }

    /**
     * Gets the attribute value for Promo_effective_date_from using the alias name Promoeffectivedatefrom.
     * @return the Promo_effective_date_from
     */
    public Timestamp getPromoeffectivedatefrom() {
        return (Timestamp) getAttributeInternal(PROMOEFFECTIVEDATEFROM);
    }

    /**
     * Sets <code>value</code> as attribute value for Promo_effective_date_from using the alias name Promoeffectivedatefrom.
     * @param value value to set the Promo_effective_date_from
     */
    public void setPromoeffectivedatefrom(Timestamp value) {
        setAttributeInternal(PROMOEFFECTIVEDATEFROM, value);
    }

    /**
     * Gets the attribute value for Promo_effective_date_To using the alias name PromoeffectivedateTo.
     * @return the Promo_effective_date_To
     */
    public Timestamp getPromoeffectivedateTo() {
        return (Timestamp) getAttributeInternal(PROMOEFFECTIVEDATETO);
    }

    /**
     * Sets <code>value</code> as attribute value for Promo_effective_date_To using the alias name PromoeffectivedateTo.
     * @param value value to set the Promo_effective_date_To
     */
    public void setPromoeffectivedateTo(Timestamp value) {
        setAttributeInternal(PROMOEFFECTIVEDATETO, value);
    }

    /**
     * Gets the attribute value for Plate_Country_ID using the alias name PlateCountryID.
     * @return the Plate_Country_ID
     */
    public Integer getPlateCountryID() {
        return (Integer) getAttributeInternal(PLATECOUNTRYID);
    }

    /**
     * Sets <code>value</code> as attribute value for Plate_Country_ID using the alias name PlateCountryID.
     * @param value value to set the Plate_Country_ID
     */
    public void setPlateCountryID(Integer value) {
        setAttributeInternal(PLATECOUNTRYID, value);
    }

    /**
     * Gets the attribute value for Sector_Code using the alias name SectorCode.
     * @return the Sector_Code
     */
    public String getSectorCode() {
        return (String) getAttributeInternal(SECTORCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Sector_Code using the alias name SectorCode.
     * @param value value to set the Sector_Code
     */
    public void setSectorCode(String value) {
        setAttributeInternal(SECTORCODE, value);
    }

    /**
     * Gets the attribute value for zone_code using the alias name zonecode.
     * @return the zone_code
     */
    public String getzonecode() {
        return (String) getAttributeInternal(ZONECODE);
    }

    /**
     * Sets <code>value</code> as attribute value for zone_code using the alias name zonecode.
     * @param value value to set the zone_code
     */
    public void setzonecode(String value) {
        setAttributeInternal(ZONECODE, value);
    }

    /**
     * Gets the attribute value for DISC_CNCL_STATUS using the alias name DISCCNCLSTATUS.
     * @return the DISC_CNCL_STATUS
     */
    public Integer getDISCCNCLSTATUS() {
        return (Integer) getAttributeInternal(DISCCNCLSTATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for DISC_CNCL_STATUS using the alias name DISCCNCLSTATUS.
     * @param value value to set the DISC_CNCL_STATUS
     */
    public void setDISCCNCLSTATUS(Integer value) {
        setAttributeInternal(DISCCNCLSTATUS, value);
    }

    /**
     * Gets the attribute value for Remarks using the alias name Remarks.
     * @return the Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as attribute value for Remarks using the alias name Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for Approved_By using the alias name ApprovedBy.
     * @return the Approved_By
     */
    public String getApprovedBy() {
        return (String) getAttributeInternal(APPROVEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for Approved_By using the alias name ApprovedBy.
     * @param value value to set the Approved_By
     */
    public void setApprovedBy(String value) {
        setAttributeInternal(APPROVEDBY, value);
    }

    /**
     * Gets the attribute value for Approved_Date using the alias name ApprovedDate.
     * @return the Approved_Date
     */
    public Timestamp getApprovedDate() {
        return (Timestamp) getAttributeInternal(APPROVEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Approved_Date using the alias name ApprovedDate.
     * @param value value to set the Approved_Date
     */
    public void setApprovedDate(Timestamp value) {
        setAttributeInternal(APPROVEDDATE, value);
    }

    /**
     * Gets the attribute value for Approver_Remarks using the alias name ApproverRemarks.
     * @return the Approver_Remarks
     */
    public String getApproverRemarks() {
        return (String) getAttributeInternal(APPROVERREMARKS);
    }

    /**
     * Sets <code>value</code> as attribute value for Approver_Remarks using the alias name ApproverRemarks.
     * @param value value to set the Approver_Remarks
     */
    public void setApproverRemarks(String value) {
        setAttributeInternal(APPROVERREMARKS, value);
    }

    /**
     * Gets the attribute value for DEF_City_Code using the alias name DEFCityCode.
     * @return the DEF_City_Code
     */
    public String getDEFCityCode() {
        return (String) getAttributeInternal(DEFCITYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for DEF_City_Code using the alias name DEFCityCode.
     * @param value value to set the DEF_City_Code
     */
    public void setDEFCityCode(String value) {
        setAttributeInternal(DEFCITYCODE, value);
    }

    /**
     * Gets the attribute value for DEF_Country_Code using the alias name DEFCountryCode.
     * @return the DEF_Country_Code
     */
    public String getDEFCountryCode() {
        return (String) getAttributeInternal(DEFCOUNTRYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for DEF_Country_Code using the alias name DEFCountryCode.
     * @param value value to set the DEF_Country_Code
     */
    public void setDEFCountryCode(String value) {
        setAttributeInternal(DEFCOUNTRYCODE, value);
    }

    /**
     * Gets the attribute value for Created_By using the alias name CreatedBy.
     * @return the Created_By
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for Created_By using the alias name CreatedBy.
     * @param value value to set the Created_By
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for Created_Date using the alias name CreatedDate.
     * @return the Created_Date
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Created_Date using the alias name CreatedDate.
     * @param value value to set the Created_Date
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for Updated_by using the alias name Updatedby.
     * @return the Updated_by
     */
    public String getUpdatedby() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for Updated_by using the alias name Updatedby.
     * @param value value to set the Updated_by
     */
    public void setUpdatedby(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for updated_date using the alias name updateddate.
     * @return the updated_date
     */
    public Timestamp getupdateddate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for updated_date using the alias name updateddate.
     * @param value value to set the updated_date
     */
    public void setupdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PlateType.
     * @return the PlateType
     */
    public Integer getPlateType() {
        return (Integer) getAttributeInternal(PLATETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PlateType.
     * @param value value to set the  PlateType
     */
    public void setPlateType(Integer value) {
        setAttributeInternal(PLATETYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PlateCategory.
     * @return the PlateCategory
     */
    public Integer getPlateCategory() {
        return (Integer) getAttributeInternal(PLATECATEGORY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PlateCategory.
     * @param value value to set the  PlateCategory
     */
    public void setPlateCategory(Integer value) {
        setAttributeInternal(PLATECATEGORY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PlateNumber.
     * @return the PlateNumber
     */
    public String getPlateNumber() {
        return (String) getAttributeInternal(PLATENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PlateNumber.
     * @param value value to set the  PlateNumber
     */
    public void setPlateNumber(String value) {
        setAttributeInternal(PLATENUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PlateCountry.
     * @return the PlateCountry
     */
    public Integer getPlateCountry() {
        return (Integer) getAttributeInternal(PLATECOUNTRY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PlateCountry.
     * @param value value to set the  PlateCountry
     */
    public void setPlateCountry(Integer value) {
        setAttributeInternal(PLATECOUNTRY, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ZoneLOVVO1.
     */
    public RowSet getZoneLOVVO1() {
        return (RowSet)getAttributeInternal(ZONELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PVTStatusLOVVO1.
     */
    public RowSet getPVTStatusLOVVO1() {
        return (RowSet)getAttributeInternal(PVTSTATUSLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PVTStageLOVVO1.
     */
    public RowSet getPVTStageLOVVO1() {
        return (RowSet)getAttributeInternal(PVTSTAGELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PlateCategoryLOVVO1.
     */
    public RowSet getPlateCategoryLOVVO1() {
        return (RowSet)getAttributeInternal(PLATECATEGORYLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PlateTypeLOVVO1.
     */
    public RowSet getPlateTypeLOVVO1() {
        return (RowSet)getAttributeInternal(PLATETYPELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ContraCodeLOVVO1.
     */
    public RowSet getContraCodeLOVVO1() {
        return (RowSet)getAttributeInternal(CONTRACODELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> SectorLovVO1.
     */
    public RowSet getSectorLovVO1() {
        return (RowSet)getAttributeInternal(SECTORLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehiclePlateCountryLVO1.
     */
    public RowSet getVehiclePlateCountryLVO1() {
        return (RowSet)getAttributeInternal(VEHICLEPLATECOUNTRYLVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PlateCountryLOVVO1.
     */
    public RowSet getPlateCountryLOVVO1() {
        return (RowSet)getAttributeInternal(PLATECOUNTRYLOVVO1);
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
