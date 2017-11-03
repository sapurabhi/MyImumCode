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
// ---    Wed Jun 10 13:20:05 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class saleReceiptSettlVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Ackstatusid {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getAckstatusid();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setAckstatusid((Integer)value);
            }
        }
        ,
        AltChqnum {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getAltChqnum();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setAltChqnum((String)value);
            }
        }
        ,
        AuthCode {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getAuthCode();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setAuthCode((String)value);
            }
        }
        ,
        CCDSlipAckDate {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getCCDSlipAckDate();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setCCDSlipAckDate((Timestamp)value);
            }
        }
        ,
        CCDSlipAckUserID {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getCCDSlipAckUserID();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setCCDSlipAckUserID((String)value);
            }
        }
        ,
        CCDType {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getCCDType();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setCCDType((String)value);
            }
        }
        ,
        CCDnum {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getCCDnum();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setCCDnum((String)value);
            }
        }
        ,
        ChqAckDate {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getChqAckDate();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setChqAckDate((Timestamp)value);
            }
        }
        ,
        ChqAckUserID {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getChqAckUserID();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setChqAckUserID((String)value);
            }
        }
        ,
        ChqBankname {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getChqBankname();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setChqBankname((String)value);
            }
        }
        ,
        ChqDate {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getChqDate();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setChqDate((Date)value);
            }
        }
        ,
        Chqnum {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getChqnum();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setChqnum((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        ForeigncurrAmt {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getForeigncurrAmt();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setForeigncurrAmt((BigDecimal)value);
            }
        }
        ,
        Foreigncurrcode {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getForeigncurrcode();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setForeigncurrcode((String)value);
            }
        }
        ,
        LGCAuthcode {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getLGCAuthcode();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setLGCAuthcode((String)value);
            }
        }
        ,
        LGCCCDNum {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getLGCCCDNum();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setLGCCCDNum((String)value);
            }
        }
        ,
        LGCChqNum {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getLGCChqNum();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setLGCChqNum((String)value);
            }
        }
        ,
        OrgCardnum {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getOrgCardnum();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setOrgCardnum((String)value);
            }
        }
        ,
        PYMTAMT {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getPYMTAMT();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setPYMTAMT((BigDecimal)value);
            }
        }
        ,
        PYMTType {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getPYMTType();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setPYMTType((String)value);
            }
        }
        ,
        PromoDscCode {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getPromoDscCode();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setPromoDscCode((String)value);
            }
        }
        ,
        SaleStlseq {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getSaleStlseq();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setSaleStlseq((BigDecimal)value);
            }
        }
        ,
        Salehdrseq {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getSalehdrseq();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setSalehdrseq((BigDecimal)value);
            }
        }
        ,
        Updatedby {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        stlcomments {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getstlcomments();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setstlcomments((String)value);
            }
        }
        ,
        Paymentdesc {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getPaymentdesc();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setPaymentdesc((String)value);
            }
        }
        ,
        Updatedate {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getUpdatedate();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setUpdatedate((Timestamp)value);
            }
        }
        ,
        BulkCreditTypeLOVVO1 {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getBulkCreditTypeLOVVO1();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PaymentTypeLOVVO1 {
            public Object get(saleReceiptSettlVORowImpl obj) {
                return obj.getPaymentTypeLOVVO1();
            }

            public void put(saleReceiptSettlVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(saleReceiptSettlVORowImpl object);

        public abstract void put(saleReceiptSettlVORowImpl object,
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
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int FOREIGNCURRAMT = AttributesEnum.ForeigncurrAmt.index();
    public static final int FOREIGNCURRCODE = AttributesEnum.Foreigncurrcode.index();
    public static final int LGCAUTHCODE = AttributesEnum.LGCAuthcode.index();
    public static final int LGCCCDNUM = AttributesEnum.LGCCCDNum.index();
    public static final int LGCCHQNUM = AttributesEnum.LGCChqNum.index();
    public static final int ORGCARDNUM = AttributesEnum.OrgCardnum.index();
    public static final int PYMTAMT = AttributesEnum.PYMTAMT.index();
    public static final int PYMTTYPE = AttributesEnum.PYMTType.index();
    public static final int PROMODSCCODE = AttributesEnum.PromoDscCode.index();
    public static final int SALESTLSEQ = AttributesEnum.SaleStlseq.index();
    public static final int SALEHDRSEQ = AttributesEnum.Salehdrseq.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int STLCOMMENTS = AttributesEnum.stlcomments.index();
    public static final int PAYMENTDESC = AttributesEnum.Paymentdesc.index();
    public static final int UPDATEDATE = AttributesEnum.Updatedate.index();
    public static final int BULKCREDITTYPELOVVO1 = AttributesEnum.BulkCreditTypeLOVVO1.index();
    public static final int PAYMENTTYPELOVVO1 = AttributesEnum.PaymentTypeLOVVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public saleReceiptSettlVORowImpl() {
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
     * Gets the attribute value for Foreign_curr_Amt using the alias name ForeigncurrAmt.
     * @return the Foreign_curr_Amt
     */
    public BigDecimal getForeigncurrAmt() {
        return (BigDecimal) getAttributeInternal(FOREIGNCURRAMT);
    }

    /**
     * Sets <code>value</code> as attribute value for Foreign_curr_Amt using the alias name ForeigncurrAmt.
     * @param value value to set the Foreign_curr_Amt
     */
    public void setForeigncurrAmt(BigDecimal value) {
        setAttributeInternal(FOREIGNCURRAMT, value);
    }

    /**
     * Gets the attribute value for Foreign_curr_code using the alias name Foreigncurrcode.
     * @return the Foreign_curr_code
     */
    public String getForeigncurrcode() {
        return (String) getAttributeInternal(FOREIGNCURRCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Foreign_curr_code using the alias name Foreigncurrcode.
     * @param value value to set the Foreign_curr_code
     */
    public void setForeigncurrcode(String value) {
        setAttributeInternal(FOREIGNCURRCODE, value);
    }

    /**
     * Gets the attribute value for LGC_Auth_code using the alias name LGCAuthcode.
     * @return the LGC_Auth_code
     */
    public String getLGCAuthcode() {
        return (String) getAttributeInternal(LGCAUTHCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for LGC_Auth_code using the alias name LGCAuthcode.
     * @param value value to set the LGC_Auth_code
     */
    public void setLGCAuthcode(String value) {
        setAttributeInternal(LGCAUTHCODE, value);
    }

    /**
     * Gets the attribute value for LGC_CCD_Num using the alias name LGCCCDNum.
     * @return the LGC_CCD_Num
     */
    public String getLGCCCDNum() {
        return (String) getAttributeInternal(LGCCCDNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for LGC_CCD_Num using the alias name LGCCCDNum.
     * @param value value to set the LGC_CCD_Num
     */
    public void setLGCCCDNum(String value) {
        setAttributeInternal(LGCCCDNUM, value);
    }

    /**
     * Gets the attribute value for LGC_Chq_Num using the alias name LGCChqNum.
     * @return the LGC_Chq_Num
     */
    public String getLGCChqNum() {
        return (String) getAttributeInternal(LGCCHQNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for LGC_Chq_Num using the alias name LGCChqNum.
     * @param value value to set the LGC_Chq_Num
     */
    public void setLGCChqNum(String value) {
        setAttributeInternal(LGCCHQNUM, value);
    }

    /**
     * Gets the attribute value for Org_Card_num using the alias name OrgCardnum.
     * @return the Org_Card_num
     */
    public String getOrgCardnum() {
        return (String) getAttributeInternal(ORGCARDNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for Org_Card_num using the alias name OrgCardnum.
     * @param value value to set the Org_Card_num
     */
    public void setOrgCardnum(String value) {
        setAttributeInternal(ORGCARDNUM, value);
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
     * Gets the attribute value for Promo_Dsc_Code using the alias name PromoDscCode.
     * @return the Promo_Dsc_Code
     */
    public String getPromoDscCode() {
        return (String) getAttributeInternal(PROMODSCCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Promo_Dsc_Code using the alias name PromoDscCode.
     * @param value value to set the Promo_Dsc_Code
     */
    public void setPromoDscCode(String value) {
        setAttributeInternal(PROMODSCCODE, value);
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
     * Gets the attribute value for "Synchronize:Fix_SQL" using the alias name Updatedate.
     * @return the "Synchronize:Fix_SQL"
     */
    public Timestamp getUpdatedate() {
        return (Timestamp) getAttributeInternal(UPDATEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for "Synchronize:Fix_SQL" using the alias name Updatedate.
     * @param value value to set the "Synchronize:Fix_SQL"
     */
    public void setUpdatedate(Timestamp value) {
        setAttributeInternal(UPDATEDATE, value);
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
     * Gets the attribute value for Updated_date using the alias name Updateddate.
     * @return the Updated_date
     */
    public Timestamp getUpdateddate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Updated_date using the alias name Updateddate.
     * @param value value to set the Updated_date
     */
    public void setUpdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for stl_comments using the alias name stlcomments.
     * @return the stl_comments
     */
    public String getstlcomments() {
        return (String) getAttributeInternal(STLCOMMENTS);
    }

    /**
     * Sets <code>value</code> as attribute value for stl_comments using the alias name stlcomments.
     * @param value value to set the stl_comments
     */
    public void setstlcomments(String value) {
        setAttributeInternal(STLCOMMENTS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Paymentdesc.
     * @return the Paymentdesc
     */
    public String getPaymentdesc() {
        return (String) getAttributeInternal(PAYMENTDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Paymentdesc.
     * @param value value to set the  Paymentdesc
     */
    public void setPaymentdesc(String value) {
        setAttributeInternal(PAYMENTDESC, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> BulkCreditTypeLOVVO1.
     */
    public RowSet getBulkCreditTypeLOVVO1() {
        return (RowSet)getAttributeInternal(BULKCREDITTYPELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PaymentTypeLOVVO1.
     */
    public RowSet getPaymentTypeLOVVO1() {
        return (RowSet)getAttributeInternal(PAYMENTTYPELOVVO1);
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
