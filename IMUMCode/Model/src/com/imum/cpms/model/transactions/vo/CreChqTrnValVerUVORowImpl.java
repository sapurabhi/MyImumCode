package com.imum.cpms.model.transactions.vo;

import com.imum.cpms.model.transactions.eo.SalesSettlementEOImpl;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Sep 18 19:08:38 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CreChqTrnValVerUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Ackstatusid {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getAckstatusid();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAckstatusid((Integer)value);
            }
        }
        ,
        SaleStlseq {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getSaleStlseq();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setSaleStlseq((BigDecimal)value);
            }
        }
        ,
        AltChqnum {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getAltChqnum();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAltChqnum((String)value);
            }
        }
        ,
        AuthCode {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getAuthCode();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAuthCode((String)value);
            }
        }
        ,
        CCDSlipAckDate {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getCCDSlipAckDate();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setCCDSlipAckDate((Timestamp)value);
            }
        }
        ,
        CCDSlipAckUserID {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getCCDSlipAckUserID();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setCCDSlipAckUserID((String)value);
            }
        }
        ,
        CCDType {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getCCDType();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setCCDType((String)value);
            }
        }
        ,
        CCDnum {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getCCDnum();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setCCDnum((String)value);
            }
        }
        ,
        ChqAckDate {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getChqAckDate();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setChqAckDate((Timestamp)value);
            }
        }
        ,
        ChqAckUserID {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getChqAckUserID();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setChqAckUserID((String)value);
            }
        }
        ,
        ChqBankname {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getChqBankname();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setChqBankname((String)value);
            }
        }
        ,
        ChqDate {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getChqDate();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setChqDate((Date)value);
            }
        }
        ,
        Chqnum {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getChqnum();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setChqnum((String)value);
            }
        }
        ,
        PYMTAMT {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getPYMTAMT();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setPYMTAMT((BigDecimal)value);
            }
        }
        ,
        PYMTType {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getPYMTType();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setPYMTType((String)value);
            }
        }
        ,
        Salehdrseq {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getSalehdrseq();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setSalehdrseq((BigDecimal)value);
            }
        }
        ,
        ReceiptNum {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getReceiptNum();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setReceiptNum((String)value);
            }
        }
        ,
        SaleDate {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getSaleDate();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setSaleDate((Timestamp)value);
            }
        }
        ,
        LocationId {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getLocationId();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setLocationId((String)value);
            }
        }
        ,
        Esysreceiptnum {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getEsysreceiptnum();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setEsysreceiptnum((String)value);
            }
        }
        ,
        SaleDateFrom {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getSaleDateFrom();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setSaleDateFrom((Timestamp)value);
            }
        }
        ,
        SaleDateTo {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getSaleDateTo();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setSaleDateTo((Timestamp)value);
            }
        }
        ,
        SelectFlag {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getSelectFlag();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setSelectFlag((Boolean)value);
            }
        }
        ,
        statusLOVswitcher {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getstatusLOVswitcher();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setstatusLOVswitcher((String)value);
            }
        }
        ,
        CreChqStaticLOVVO1 {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getCreChqStaticLOVVO1();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        SLTAckStatusLOVVO1 {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getSLTAckStatusLOVVO1();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CCDStatusStaticLOVVO1 {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getCCDStatusStaticLOVVO1();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CHQStatusStaticLOVVO1 {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getCHQStatusStaticLOVVO1();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LocationLVO1 {
            public Object get(CreChqTrnValVerUVORowImpl obj) {
                return obj.getLocationLVO1();
            }

            public void put(CreChqTrnValVerUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(CreChqTrnValVerUVORowImpl object);

        public abstract void put(CreChqTrnValVerUVORowImpl object,
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


    public static final int ACKSTATUSID = AttributesEnum.Ackstatusid.index();
    public static final int SALESTLSEQ = AttributesEnum.SaleStlseq.index();
    public static final int ALTCHQNUM = AttributesEnum.AltChqnum.index();
    public static final int AUTHCODE = AttributesEnum.AuthCode.index();
    public static final int CCDSLIPACKDATE = AttributesEnum.CCDSlipAckDate.index();
    public static final int CCDSLIPACKUSERID = AttributesEnum.CCDSlipAckUserID.index();
    public static final int CCDTYPE = AttributesEnum.CCDType.index();
    public static final int CCDNUM = AttributesEnum.CCDnum.index();
    public static final int CHQACKDATE = AttributesEnum.ChqAckDate.index();
    public static final int CHQACKUSERID = AttributesEnum.ChqAckUserID.index();
    public static final int CHQBANKNAME = AttributesEnum.ChqBankname.index();
    public static final int CHQDATE = AttributesEnum.ChqDate.index();
    public static final int CHQNUM = AttributesEnum.Chqnum.index();
    public static final int PYMTAMT = AttributesEnum.PYMTAMT.index();
    public static final int PYMTTYPE = AttributesEnum.PYMTType.index();
    public static final int SALEHDRSEQ = AttributesEnum.Salehdrseq.index();
    public static final int RECEIPTNUM = AttributesEnum.ReceiptNum.index();
    public static final int SALEDATE = AttributesEnum.SaleDate.index();
    public static final int LOCATIONID = AttributesEnum.LocationId.index();
    public static final int ESYSRECEIPTNUM = AttributesEnum.Esysreceiptnum.index();
    public static final int SALEDATEFROM = AttributesEnum.SaleDateFrom.index();
    public static final int SALEDATETO = AttributesEnum.SaleDateTo.index();
    public static final int SELECTFLAG = AttributesEnum.SelectFlag.index();
    public static final int STATUSLOVSWITCHER = AttributesEnum.statusLOVswitcher.index();
    public static final int CRECHQSTATICLOVVO1 = AttributesEnum.CreChqStaticLOVVO1.index();
    public static final int SLTACKSTATUSLOVVO1 = AttributesEnum.SLTAckStatusLOVVO1.index();
    public static final int CCDSTATUSSTATICLOVVO1 = AttributesEnum.CCDStatusStaticLOVVO1.index();
    public static final int CHQSTATUSSTATICLOVVO1 = AttributesEnum.CHQStatusStaticLOVVO1.index();
    public static final int LOCATIONLVO1 = AttributesEnum.LocationLVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CreChqTrnValVerUVORowImpl() {
    }

    /**
     * Gets SalesSettlementEO entity object.
     * @return the SalesSettlementEO
     */
    public SalesSettlementEOImpl getSalesSettlementEO() {
        return (SalesSettlementEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Ack_status_id using the alias name Ackstatusid.
     * @return the Ack_status_id
     */
    public Integer getAckstatusid() {
        return (Integer) getAttributeInternal(ACKSTATUSID);
    }

    /**
     * Sets <code>value</code> as attribute value for Ack_status_id using the alias name Ackstatusid.
     * @param value value to set the Ack_status_id
     */
    public void setAckstatusid(Integer value) {
        setAttributeInternal(ACKSTATUSID, value);
    }

    /**
     * Gets the attribute value for Sale_Stl_seq using the alias name SaleStlseq.
     * @return the Sale_Stl_seq
     */
    public BigDecimal getSaleStlseq() {
        return (BigDecimal) getAttributeInternal(SALESTLSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for Sale_Stl_seq using the alias name SaleStlseq.
     * @param value value to set the Sale_Stl_seq
     */
    public void setSaleStlseq(BigDecimal value) {
        setAttributeInternal(SALESTLSEQ, value);
    }

    /**
     * Gets the attribute value for Alt_Chq_num using the alias name AltChqnum.
     * @return the Alt_Chq_num
     */
    public String getAltChqnum() {
        return (String) getAttributeInternal(ALTCHQNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for Alt_Chq_num using the alias name AltChqnum.
     * @param value value to set the Alt_Chq_num
     */
    public void setAltChqnum(String value) {
        setAttributeInternal(ALTCHQNUM, value);
    }

    /**
     * Gets the attribute value for Auth_Code using the alias name AuthCode.
     * @return the Auth_Code
     */
    public String getAuthCode() {
        return (String) getAttributeInternal(AUTHCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Auth_Code using the alias name AuthCode.
     * @param value value to set the Auth_Code
     */
    public void setAuthCode(String value) {
        setAttributeInternal(AUTHCODE, value);
    }

    /**
     * Gets the attribute value for CCD_Slip_Ack_Date using the alias name CCDSlipAckDate.
     * @return the CCD_Slip_Ack_Date
     */
    public Timestamp getCCDSlipAckDate() {
        return (Timestamp) getAttributeInternal(CCDSLIPACKDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CCD_Slip_Ack_Date using the alias name CCDSlipAckDate.
     * @param value value to set the CCD_Slip_Ack_Date
     */
    public void setCCDSlipAckDate(Timestamp value) {
        setAttributeInternal(CCDSLIPACKDATE, value);
    }

    /**
     * Gets the attribute value for CCD_Slip_Ack_User_ID using the alias name CCDSlipAckUserID.
     * @return the CCD_Slip_Ack_User_ID
     */
    public String getCCDSlipAckUserID() {
        return (String) getAttributeInternal(CCDSLIPACKUSERID);
    }

    /**
     * Sets <code>value</code> as attribute value for CCD_Slip_Ack_User_ID using the alias name CCDSlipAckUserID.
     * @param value value to set the CCD_Slip_Ack_User_ID
     */
    public void setCCDSlipAckUserID(String value) {
        setAttributeInternal(CCDSLIPACKUSERID, value);
    }

    /**
     * Gets the attribute value for CCD_Type using the alias name CCDType.
     * @return the CCD_Type
     */
    public String getCCDType() {
        return (String) getAttributeInternal(CCDTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for CCD_Type using the alias name CCDType.
     * @param value value to set the CCD_Type
     */
    public void setCCDType(String value) {
        setAttributeInternal(CCDTYPE, value);
    }

    /**
     * Gets the attribute value for CCD_num using the alias name CCDnum.
     * @return the CCD_num
     */
    public String getCCDnum() {
        return (String) getAttributeInternal(CCDNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for CCD_num using the alias name CCDnum.
     * @param value value to set the CCD_num
     */
    public void setCCDnum(String value) {
        setAttributeInternal(CCDNUM, value);
    }

    /**
     * Gets the attribute value for Chq_Ack_Date using the alias name ChqAckDate.
     * @return the Chq_Ack_Date
     */
    public Timestamp getChqAckDate() {
        return (Timestamp) getAttributeInternal(CHQACKDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Chq_Ack_Date using the alias name ChqAckDate.
     * @param value value to set the Chq_Ack_Date
     */
    public void setChqAckDate(Timestamp value) {
        setAttributeInternal(CHQACKDATE, value);
    }

    /**
     * Gets the attribute value for Chq_Ack_User_ID using the alias name ChqAckUserID.
     * @return the Chq_Ack_User_ID
     */
    public String getChqAckUserID() {
        return (String) getAttributeInternal(CHQACKUSERID);
    }

    /**
     * Sets <code>value</code> as attribute value for Chq_Ack_User_ID using the alias name ChqAckUserID.
     * @param value value to set the Chq_Ack_User_ID
     */
    public void setChqAckUserID(String value) {
        setAttributeInternal(CHQACKUSERID, value);
    }

    /**
     * Gets the attribute value for Chq_Bank_name using the alias name ChqBankname.
     * @return the Chq_Bank_name
     */
    public String getChqBankname() {
        return (String) getAttributeInternal(CHQBANKNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for Chq_Bank_name using the alias name ChqBankname.
     * @param value value to set the Chq_Bank_name
     */
    public void setChqBankname(String value) {
        setAttributeInternal(CHQBANKNAME, value);
    }

    /**
     * Gets the attribute value for Chq_Date using the alias name ChqDate.
     * @return the Chq_Date
     */
    public Date getChqDate() {
        return (Date) getAttributeInternal(CHQDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Chq_Date using the alias name ChqDate.
     * @param value value to set the Chq_Date
     */
    public void setChqDate(Date value) {
        setAttributeInternal(CHQDATE, value);
    }

    /**
     * Gets the attribute value for Chq_num using the alias name Chqnum.
     * @return the Chq_num
     */
    public String getChqnum() {
        return (String) getAttributeInternal(CHQNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for Chq_num using the alias name Chqnum.
     * @param value value to set the Chq_num
     */
    public void setChqnum(String value) {
        setAttributeInternal(CHQNUM, value);
    }

    /**
     * Gets the attribute value for PYMT_AMT using the alias name PYMTAMT.
     * @return the PYMT_AMT
     */
    public BigDecimal getPYMTAMT() {
        return (BigDecimal) getAttributeInternal(PYMTAMT);
    }

    /**
     * Sets <code>value</code> as attribute value for PYMT_AMT using the alias name PYMTAMT.
     * @param value value to set the PYMT_AMT
     */
    public void setPYMTAMT(BigDecimal value) {
        setAttributeInternal(PYMTAMT, value);
    }

    /**
     * Gets the attribute value for PYMT_Type using the alias name PYMTType.
     * @return the PYMT_Type
     */
    public String getPYMTType() {
        return (String) getAttributeInternal(PYMTTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for PYMT_Type using the alias name PYMTType.
     * @param value value to set the PYMT_Type
     */
    public void setPYMTType(String value) {
        setAttributeInternal(PYMTTYPE, value);
    }

    /**
     * Gets the attribute value for Sale_hdr_seq using the alias name Salehdrseq.
     * @return the Sale_hdr_seq
     */
    public BigDecimal getSalehdrseq() {
        return (BigDecimal) getAttributeInternal(SALEHDRSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for Sale_hdr_seq using the alias name Salehdrseq.
     * @param value value to set the Sale_hdr_seq
     */
    public void setSalehdrseq(BigDecimal value) {
        setAttributeInternal(SALEHDRSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ReceiptNum.
     * @return the ReceiptNum
     */
    public String getReceiptNum() {
        return (String) getAttributeInternal(RECEIPTNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ReceiptNum.
     * @param value value to set the  ReceiptNum
     */
    public void setReceiptNum(String value) {
        setAttributeInternal(RECEIPTNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SaleDate.
     * @return the SaleDate
     */
    public Timestamp getSaleDate() {
        return (Timestamp) getAttributeInternal(SALEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SaleDate.
     * @param value value to set the  SaleDate
     */
    public void setSaleDate(Timestamp value) {
        setAttributeInternal(SALEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LocationId.
     * @return the LocationId
     */
    public String getLocationId() {
        return (String) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LocationId.
     * @param value value to set the  LocationId
     */
    public void setLocationId(String value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Esysreceiptnum.
     * @return the Esysreceiptnum
     */
    public String getEsysreceiptnum() {
        return (String) getAttributeInternal(ESYSRECEIPTNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Esysreceiptnum.
     * @param value value to set the  Esysreceiptnum
     */
    public void setEsysreceiptnum(String value) {
        setAttributeInternal(ESYSRECEIPTNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SaleDateFrom.
     * @return the SaleDateFrom
     */
    public Timestamp getSaleDateFrom() {
        return (Timestamp) getAttributeInternal(SALEDATEFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SaleDateFrom.
     * @param value value to set the  SaleDateFrom
     */
    public void setSaleDateFrom(Timestamp value) {
        setAttributeInternal(SALEDATEFROM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SaleDateTo.
     * @return the SaleDateTo
     */
    public Timestamp getSaleDateTo() {
        return (Timestamp) getAttributeInternal(SALEDATETO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SaleDateTo.
     * @param value value to set the  SaleDateTo
     */
    public void setSaleDateTo(Timestamp value) {
        setAttributeInternal(SALEDATETO, value);
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
     * Gets the attribute value for the calculated attribute statusLOVswitcher.
     * @return the statusLOVswitcher
     */
    public String getstatusLOVswitcher() {
        return (String) getAttributeInternal(STATUSLOVSWITCHER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute statusLOVswitcher.
     * @param value value to set the  statusLOVswitcher
     */
    public void setstatusLOVswitcher(String value) {
        setAttributeInternal(STATUSLOVSWITCHER, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CreChqStaticLOVVO1.
     */
    public RowSet getCreChqStaticLOVVO1() {
        return (RowSet)getAttributeInternal(CRECHQSTATICLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> SLTAckStatusLOVVO1.
     */
    public RowSet getSLTAckStatusLOVVO1() {
        return (RowSet)getAttributeInternal(SLTACKSTATUSLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CCDStatusStaticLOVVO1.
     */
    public RowSet getCCDStatusStaticLOVVO1() {
        return (RowSet)getAttributeInternal(CCDSTATUSSTATICLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CHQStatusStaticLOVVO1.
     */
    public RowSet getCHQStatusStaticLOVVO1() {
        return (RowSet)getAttributeInternal(CHQSTATUSSTATICLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LocationLVO1.
     */
    public RowSet getLocationLVO1() {
        return (RowSet)getAttributeInternal(LOCATIONLVO1);
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
