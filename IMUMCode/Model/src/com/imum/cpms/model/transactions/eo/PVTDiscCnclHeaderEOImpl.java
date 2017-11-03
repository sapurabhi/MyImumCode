package com.imum.cpms.model.transactions.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Aug 23 16:27:10 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTDiscCnclHeaderEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        DISCCNCLhdrSeq {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDISCCNCLhdrSeq();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDISCCNCLhdrSeq((BigDecimal)value);
            }
        }
        ,
        DISCCNCLTYPE {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDISCCNCLTYPE();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDISCCNCLTYPE((String)value);
            }
        }
        ,
        DISCPROMOCODE {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDISCPROMOCODE();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDISCPROMOCODE((String)value);
            }
        }
        ,
        DISCPROMONAME {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDISCPROMONAME();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDISCPROMONAME((String)value);
            }
        }
        ,
        Contracode {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getContracode();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setContracode((Integer)value);
            }
        }
        ,
        PVTdatefrom {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPVTdatefrom();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPVTdatefrom((Timestamp)value);
            }
        }
        ,
        PVTdateto {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPVTdateto();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPVTdateto((Timestamp)value);
            }
        }
        ,
        PVTSOURCE {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPVTSOURCE();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPVTSOURCE((String)value);
            }
        }
        ,
        PVTStatusID {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPVTStatusID();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPVTStatusID((Integer)value);
            }
        }
        ,
        PVTSTAGEID {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPVTSTAGEID();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPVTSTAGEID((Integer)value);
            }
        }
        ,
        DISCPCT {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDISCPCT();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDISCPCT((BigDecimal)value);
            }
        }
        ,
        DISCFLATAMT {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDISCFLATAMT();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDISCFLATAMT((BigDecimal)value);
            }
        }
        ,
        PVTAmtRangefrom {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPVTAmtRangefrom();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPVTAmtRangefrom((BigDecimal)value);
            }
        }
        ,
        PVTAmtRangeTo {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPVTAmtRangeTo();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPVTAmtRangeTo((BigDecimal)value);
            }
        }
        ,
        Promoeffectivedatefrom {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPromoeffectivedatefrom();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPromoeffectivedatefrom((Timestamp)value);
            }
        }
        ,
        PromoeffectivedateTo {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPromoeffectivedateTo();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPromoeffectivedateTo((Timestamp)value);
            }
        }
        ,
        PlateCountryID {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getPlateCountryID();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setPlateCountryID((Integer)value);
            }
        }
        ,
        SectorCode {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getSectorCode();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setSectorCode((String)value);
            }
        }
        ,
        zonecode {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getzonecode();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setzonecode((String)value);
            }
        }
        ,
        DISCCNCLSTATUS {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDISCCNCLSTATUS();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDISCCNCLSTATUS((Integer)value);
            }
        }
        ,
        Remarks {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getRemarks();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        ApprovedBy {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getApprovedBy();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setApprovedBy((String)value);
            }
        }
        ,
        ApprovedDate {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getApprovedDate();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setApprovedDate((Timestamp)value);
            }
        }
        ,
        ApproverRemarks {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getApproverRemarks();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setApproverRemarks((String)value);
            }
        }
        ,
        DEFCityCode {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDEFCityCode();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDEFCityCode((String)value);
            }
        }
        ,
        DEFCountryCode {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getDEFCountryCode();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setDEFCountryCode((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        updateddate {
            public Object get(PVTDiscCnclHeaderEOImpl obj) {
                return obj.getupdateddate();
            }

            public void put(PVTDiscCnclHeaderEOImpl obj, Object value) {
                obj.setupdateddate((Timestamp)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PVTDiscCnclHeaderEOImpl object);

        public abstract void put(PVTDiscCnclHeaderEOImpl object, Object value);

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

    /**
     * This is the default constructor (do not remove).
     */
    public PVTDiscCnclHeaderEOImpl() {
    }

    /**
     * Gets the attribute value for DISCCNCLhdrSeq, using the alias name DISCCNCLhdrSeq.
     * @return the DISCCNCLhdrSeq
     */
    public BigDecimal getDISCCNCLhdrSeq() {
        return (BigDecimal)getAttributeInternal(DISCCNCLHDRSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for DISCCNCLhdrSeq.
     * @param value value to set the DISCCNCLhdrSeq
     */
    public void setDISCCNCLhdrSeq(BigDecimal value) {
        setAttributeInternal(DISCCNCLHDRSEQ, value);
    }

    /**
     * Gets the attribute value for DISCCNCLTYPE, using the alias name DISCCNCLTYPE.
     * @return the DISCCNCLTYPE
     */
    public String getDISCCNCLTYPE() {
        return (String)getAttributeInternal(DISCCNCLTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DISCCNCLTYPE.
     * @param value value to set the DISCCNCLTYPE
     */
    public void setDISCCNCLTYPE(String value) {
        setAttributeInternal(DISCCNCLTYPE, value);
    }

    /**
     * Gets the attribute value for DISCPROMOCODE, using the alias name DISCPROMOCODE.
     * @return the DISCPROMOCODE
     */
    public String getDISCPROMOCODE() {
        return (String)getAttributeInternal(DISCPROMOCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DISCPROMOCODE.
     * @param value value to set the DISCPROMOCODE
     */
    public void setDISCPROMOCODE(String value) {
        setAttributeInternal(DISCPROMOCODE, value);
    }

    /**
     * Gets the attribute value for DISCPROMONAME, using the alias name DISCPROMONAME.
     * @return the DISCPROMONAME
     */
    public String getDISCPROMONAME() {
        return (String)getAttributeInternal(DISCPROMONAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for DISCPROMONAME.
     * @param value value to set the DISCPROMONAME
     */
    public void setDISCPROMONAME(String value) {
        setAttributeInternal(DISCPROMONAME, value);
    }

    /**
     * Gets the attribute value for Contracode, using the alias name Contracode.
     * @return the Contracode
     */
    public Integer getContracode() {
        return (Integer)getAttributeInternal(CONTRACODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Contracode.
     * @param value value to set the Contracode
     */
    public void setContracode(Integer value) {
        setAttributeInternal(CONTRACODE, value);
    }

    /**
     * Gets the attribute value for PVTdatefrom, using the alias name PVTdatefrom.
     * @return the PVTdatefrom
     */
    public Timestamp getPVTdatefrom() {
        return (Timestamp)getAttributeInternal(PVTDATEFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTdatefrom.
     * @param value value to set the PVTdatefrom
     */
    public void setPVTdatefrom(Timestamp value) {
        setAttributeInternal(PVTDATEFROM, value);
    }

    /**
     * Gets the attribute value for PVTdateto, using the alias name PVTdateto.
     * @return the PVTdateto
     */
    public Timestamp getPVTdateto() {
        return (Timestamp)getAttributeInternal(PVTDATETO);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTdateto.
     * @param value value to set the PVTdateto
     */
    public void setPVTdateto(Timestamp value) {
        setAttributeInternal(PVTDATETO, value);
    }

    /**
     * Gets the attribute value for PVTSOURCE, using the alias name PVTSOURCE.
     * @return the PVTSOURCE
     */
    public String getPVTSOURCE() {
        return (String)getAttributeInternal(PVTSOURCE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTSOURCE.
     * @param value value to set the PVTSOURCE
     */
    public void setPVTSOURCE(String value) {
        setAttributeInternal(PVTSOURCE, value);
    }

    /**
     * Gets the attribute value for PVTStatusID, using the alias name PVTStatusID.
     * @return the PVTStatusID
     */
    public Integer getPVTStatusID() {
        return (Integer)getAttributeInternal(PVTSTATUSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTStatusID.
     * @param value value to set the PVTStatusID
     */
    public void setPVTStatusID(Integer value) {
        setAttributeInternal(PVTSTATUSID, value);
    }

    /**
     * Gets the attribute value for PVTSTAGEID, using the alias name PVTSTAGEID.
     * @return the PVTSTAGEID
     */
    public Integer getPVTSTAGEID() {
        return (Integer)getAttributeInternal(PVTSTAGEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTSTAGEID.
     * @param value value to set the PVTSTAGEID
     */
    public void setPVTSTAGEID(Integer value) {
        setAttributeInternal(PVTSTAGEID, value);
    }

    /**
     * Gets the attribute value for DISCPCT, using the alias name DISCPCT.
     * @return the DISCPCT
     */
    public BigDecimal getDISCPCT() {
        return (BigDecimal)getAttributeInternal(DISCPCT);
    }

    /**
     * Sets <code>value</code> as the attribute value for DISCPCT.
     * @param value value to set the DISCPCT
     */
    public void setDISCPCT(BigDecimal value) {
        setAttributeInternal(DISCPCT, value);
    }

    /**
     * Gets the attribute value for DISCFLATAMT, using the alias name DISCFLATAMT.
     * @return the DISCFLATAMT
     */
    public BigDecimal getDISCFLATAMT() {
        return (BigDecimal)getAttributeInternal(DISCFLATAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for DISCFLATAMT.
     * @param value value to set the DISCFLATAMT
     */
    public void setDISCFLATAMT(BigDecimal value) {
        setAttributeInternal(DISCFLATAMT, value);
    }

    /**
     * Gets the attribute value for PVTAmtRangefrom, using the alias name PVTAmtRangefrom.
     * @return the PVTAmtRangefrom
     */
    public BigDecimal getPVTAmtRangefrom() {
        return (BigDecimal)getAttributeInternal(PVTAMTRANGEFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTAmtRangefrom.
     * @param value value to set the PVTAmtRangefrom
     */
    public void setPVTAmtRangefrom(BigDecimal value) {
        setAttributeInternal(PVTAMTRANGEFROM, value);
    }

    /**
     * Gets the attribute value for PVTAmtRangeTo, using the alias name PVTAmtRangeTo.
     * @return the PVTAmtRangeTo
     */
    public BigDecimal getPVTAmtRangeTo() {
        return (BigDecimal)getAttributeInternal(PVTAMTRANGETO);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTAmtRangeTo.
     * @param value value to set the PVTAmtRangeTo
     */
    public void setPVTAmtRangeTo(BigDecimal value) {
        setAttributeInternal(PVTAMTRANGETO, value);
    }

    /**
     * Gets the attribute value for Promoeffectivedatefrom, using the alias name Promoeffectivedatefrom.
     * @return the Promoeffectivedatefrom
     */
    public Timestamp getPromoeffectivedatefrom() {
        return (Timestamp)getAttributeInternal(PROMOEFFECTIVEDATEFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Promoeffectivedatefrom.
     * @param value value to set the Promoeffectivedatefrom
     */
    public void setPromoeffectivedatefrom(Timestamp value) {
        setAttributeInternal(PROMOEFFECTIVEDATEFROM, value);
    }

    /**
     * Gets the attribute value for PromoeffectivedateTo, using the alias name PromoeffectivedateTo.
     * @return the PromoeffectivedateTo
     */
    public Timestamp getPromoeffectivedateTo() {
        return (Timestamp)getAttributeInternal(PROMOEFFECTIVEDATETO);
    }

    /**
     * Sets <code>value</code> as the attribute value for PromoeffectivedateTo.
     * @param value value to set the PromoeffectivedateTo
     */
    public void setPromoeffectivedateTo(Timestamp value) {
        setAttributeInternal(PROMOEFFECTIVEDATETO, value);
    }

    /**
     * Gets the attribute value for PlateCountryID, using the alias name PlateCountryID.
     * @return the PlateCountryID
     */
    public Integer getPlateCountryID() {
        return (Integer)getAttributeInternal(PLATECOUNTRYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for PlateCountryID.
     * @param value value to set the PlateCountryID
     */
    public void setPlateCountryID(Integer value) {
        setAttributeInternal(PLATECOUNTRYID, value);
    }

    /**
     * Gets the attribute value for SectorCode, using the alias name SectorCode.
     * @return the SectorCode
     */
    public String getSectorCode() {
        return (String)getAttributeInternal(SECTORCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SectorCode.
     * @param value value to set the SectorCode
     */
    public void setSectorCode(String value) {
        setAttributeInternal(SECTORCODE, value);
    }

    /**
     * Gets the attribute value for zonecode, using the alias name zonecode.
     * @return the zonecode
     */
    public String getzonecode() {
        return (String)getAttributeInternal(ZONECODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for zonecode.
     * @param value value to set the zonecode
     */
    public void setzonecode(String value) {
        setAttributeInternal(ZONECODE, value);
    }

    /**
     * Gets the attribute value for DISCCNCLSTATUS, using the alias name DISCCNCLSTATUS.
     * @return the DISCCNCLSTATUS
     */
    public Integer getDISCCNCLSTATUS() {
        return (Integer)getAttributeInternal(DISCCNCLSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for DISCCNCLSTATUS.
     * @param value value to set the DISCCNCLSTATUS
     */
    public void setDISCCNCLSTATUS(Integer value) {
        setAttributeInternal(DISCCNCLSTATUS, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the Remarks
     */
    public String getRemarks() {
        return (String)getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for ApprovedBy, using the alias name ApprovedBy.
     * @return the ApprovedBy
     */
    public String getApprovedBy() {
        return (String)getAttributeInternal(APPROVEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for ApprovedBy.
     * @param value value to set the ApprovedBy
     */
    public void setApprovedBy(String value) {
        setAttributeInternal(APPROVEDBY, value);
    }

    /**
     * Gets the attribute value for ApprovedDate, using the alias name ApprovedDate.
     * @return the ApprovedDate
     */
    public Timestamp getApprovedDate() {
        return (Timestamp)getAttributeInternal(APPROVEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ApprovedDate.
     * @param value value to set the ApprovedDate
     */
    public void setApprovedDate(Timestamp value) {
        setAttributeInternal(APPROVEDDATE, value);
    }

    /**
     * Gets the attribute value for ApproverRemarks, using the alias name ApproverRemarks.
     * @return the ApproverRemarks
     */
    public String getApproverRemarks() {
        return (String)getAttributeInternal(APPROVERREMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for ApproverRemarks.
     * @param value value to set the ApproverRemarks
     */
    public void setApproverRemarks(String value) {
        setAttributeInternal(APPROVERREMARKS, value);
    }

    /**
     * Gets the attribute value for DEFCityCode, using the alias name DEFCityCode.
     * @return the DEFCityCode
     */
    public String getDEFCityCode() {
        return (String)getAttributeInternal(DEFCITYCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DEFCityCode.
     * @param value value to set the DEFCityCode
     */
    public void setDEFCityCode(String value) {
        setAttributeInternal(DEFCITYCODE, value);
    }

    /**
     * Gets the attribute value for DEFCountryCode, using the alias name DEFCountryCode.
     * @return the DEFCountryCode
     */
    public String getDEFCountryCode() {
        return (String)getAttributeInternal(DEFCOUNTRYCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DEFCountryCode.
     * @param value value to set the DEFCountryCode
     */
    public void setDEFCountryCode(String value) {
        setAttributeInternal(DEFCOUNTRYCODE, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return (String)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp)getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for Updatedby, using the alias name Updatedby.
     * @return the Updatedby
     */
    public String getUpdatedby() {
        return (String)getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Updatedby.
     * @param value value to set the Updatedby
     */
    public void setUpdatedby(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for updateddate, using the alias name updateddate.
     * @return the updateddate
     */
    public Timestamp getupdateddate() {
        return (Timestamp)getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for updateddate.
     * @param value value to set the updateddate
     */
    public void setupdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
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

    /**
     * @param dISCCNCLhdrSeq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal dISCCNCLhdrSeq) {
        return new Key(new Object[]{dISCCNCLhdrSeq});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.transactions.eo.PVTDiscCnclHeaderEO");
        }
        return mDefinitionObject;
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}