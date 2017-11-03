package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 24 21:25:08 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SaleReceiptDetailVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ActionCode {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getActionCode();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setActionCode((Integer)value);
            }
        }
        ,
        Cardnumfrom {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getCardnumfrom();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setCardnumfrom((String)value);
            }
        }
        ,
        card {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getcard();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setcard((String)value);
            }
        }
        ,
        Cardnumto {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getCardnumto();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setCardnumto((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        DiscAmt {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getDiscAmt();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setDiscAmt((BigDecimal)value);
            }
        }
        ,
        InstQuotaseq {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getInstQuotaseq();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setInstQuotaseq((BigDecimal)value);
            }
        }
        ,
        LineComments {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getLineComments();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setLineComments((String)value);
            }
        }
        ,
        OrgCardnum {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getOrgCardnum();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setOrgCardnum((String)value);
            }
        }
        ,
        PRMHeaderseq {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getPRMHeaderseq();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setPRMHeaderseq((BigDecimal)value);
            }
        }
        ,
        ParkingCardEXPDATE {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getParkingCardEXPDATE();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setParkingCardEXPDATE((Date)value);
            }
        }
        ,
        Prodcode {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getProdcode();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setProdcode((Integer)value);
            }
        }
        ,
        PromoDiscCode {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getPromoDiscCode();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setPromoDiscCode((String)value);
            }
        }
        ,
        RCMobileNum {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getRCMobileNum();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setRCMobileNum((String)value);
            }
        }
        ,
        SaleAmt {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getSaleAmt();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setSaleAmt((BigDecimal)value);
            }
        }
        ,
        SaleDtlseq {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getSaleDtlseq();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setSaleDtlseq((BigDecimal)value);
            }
        }
        ,
        Salehdrseq {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getSalehdrseq();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setSalehdrseq((BigDecimal)value);
            }
        }
        ,
        Updatedby {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        PVTHDRSEQ {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getPVTHDRSEQ();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setPVTHDRSEQ((BigDecimal)value);
            }
        }
        ,
        pvtnumber {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getpvtnumber();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setpvtnumber((String)value);
            }
        }
        ,
        permitnumber {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getpermitnumber();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setpermitnumber((String)value);
            }
        }
        ,
        prodname {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getprodname();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setprodname((String)value);
            }
        }
        ,
        TransactionRefNo {
            public Object get(SaleReceiptDetailVORowImpl obj) {
                return obj.getTransactionRefNo();
            }

            public void put(SaleReceiptDetailVORowImpl obj, Object value) {
                obj.setTransactionRefNo((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SaleReceiptDetailVORowImpl object);

        public abstract void put(SaleReceiptDetailVORowImpl object,
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
    public static final int ACTIONCODE = AttributesEnum.ActionCode.index();
    public static final int CARDNUMFROM = AttributesEnum.Cardnumfrom.index();
    public static final int CARD = AttributesEnum.card.index();
    public static final int CARDNUMTO = AttributesEnum.Cardnumto.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int DISCAMT = AttributesEnum.DiscAmt.index();
    public static final int INSTQUOTASEQ = AttributesEnum.InstQuotaseq.index();
    public static final int LINECOMMENTS = AttributesEnum.LineComments.index();
    public static final int ORGCARDNUM = AttributesEnum.OrgCardnum.index();
    public static final int PRMHEADERSEQ = AttributesEnum.PRMHeaderseq.index();
    public static final int PARKINGCARDEXPDATE = AttributesEnum.ParkingCardEXPDATE.index();
    public static final int PRODCODE = AttributesEnum.Prodcode.index();
    public static final int PROMODISCCODE = AttributesEnum.PromoDiscCode.index();
    public static final int RCMOBILENUM = AttributesEnum.RCMobileNum.index();
    public static final int SALEAMT = AttributesEnum.SaleAmt.index();
    public static final int SALEDTLSEQ = AttributesEnum.SaleDtlseq.index();
    public static final int SALEHDRSEQ = AttributesEnum.Salehdrseq.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int PVTHDRSEQ = AttributesEnum.PVTHDRSEQ.index();
    public static final int PVTNUMBER = AttributesEnum.pvtnumber.index();
    public static final int PERMITNUMBER = AttributesEnum.permitnumber.index();
    public static final int PRODNAME = AttributesEnum.prodname.index();
    public static final int TRANSACTIONREFNO = AttributesEnum.TransactionRefNo.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SaleReceiptDetailVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute ActionCode.
     * @return the ActionCode
     */
    public Integer getActionCode() {
        return (Integer) getAttributeInternal(ACTIONCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ActionCode.
     * @param value value to set the  ActionCode
     */
    public void setActionCode(Integer value) {
        setAttributeInternal(ACTIONCODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Cardnumfrom.
     * @return the Cardnumfrom
     */
    public String getCardnumfrom() {
        return (String) getAttributeInternal(CARDNUMFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Cardnumfrom.
     * @param value value to set the  Cardnumfrom
     */
    public void setCardnumfrom(String value) {
        setAttributeInternal(CARDNUMFROM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute card.
     * @return the card
     */
    public String getcard() {
        return (String) getAttributeInternal(CARD);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute card.
     * @param value value to set the  card
     */
    public void setcard(String value) {
        setAttributeInternal(CARD, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Cardnumto.
     * @return the Cardnumto
     */
    public String getCardnumto() {
        return (String) getAttributeInternal(CARDNUMTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Cardnumto.
     * @param value value to set the  Cardnumto
     */
    public void setCardnumto(String value) {
        setAttributeInternal(CARDNUMTO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreatedBy.
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreatedBy.
     * @param value value to set the  CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
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
     * Gets the attribute value for the calculated attribute DiscAmt.
     * @return the DiscAmt
     */
    public BigDecimal getDiscAmt() {
        return (BigDecimal) getAttributeInternal(DISCAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DiscAmt.
     * @param value value to set the  DiscAmt
     */
    public void setDiscAmt(BigDecimal value) {
        setAttributeInternal(DISCAMT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute InstQuotaseq.
     * @return the InstQuotaseq
     */
    public BigDecimal getInstQuotaseq() {
        return (BigDecimal) getAttributeInternal(INSTQUOTASEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute InstQuotaseq.
     * @param value value to set the  InstQuotaseq
     */
    public void setInstQuotaseq(BigDecimal value) {
        setAttributeInternal(INSTQUOTASEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LineComments.
     * @return the LineComments
     */
    public String getLineComments() {
        return (String) getAttributeInternal(LINECOMMENTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LineComments.
     * @param value value to set the  LineComments
     */
    public void setLineComments(String value) {
        setAttributeInternal(LINECOMMENTS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute OrgCardnum.
     * @return the OrgCardnum
     */
    public String getOrgCardnum() {
        return (String) getAttributeInternal(ORGCARDNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute OrgCardnum.
     * @param value value to set the  OrgCardnum
     */
    public void setOrgCardnum(String value) {
        setAttributeInternal(ORGCARDNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PRMHeaderseq.
     * @return the PRMHeaderseq
     */
    public BigDecimal getPRMHeaderseq() {
        return (BigDecimal) getAttributeInternal(PRMHEADERSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PRMHeaderseq.
     * @param value value to set the  PRMHeaderseq
     */
    public void setPRMHeaderseq(BigDecimal value) {
        setAttributeInternal(PRMHEADERSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ParkingCardEXPDATE.
     * @return the ParkingCardEXPDATE
     */
    public Date getParkingCardEXPDATE() {
        return (Date) getAttributeInternal(PARKINGCARDEXPDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ParkingCardEXPDATE.
     * @param value value to set the  ParkingCardEXPDATE
     */
    public void setParkingCardEXPDATE(Date value) {
        setAttributeInternal(PARKINGCARDEXPDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Prodcode.
     * @return the Prodcode
     */
    public Integer getProdcode() {
        return (Integer) getAttributeInternal(PRODCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Prodcode.
     * @param value value to set the  Prodcode
     */
    public void setProdcode(Integer value) {
        setAttributeInternal(PRODCODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PromoDiscCode.
     * @return the PromoDiscCode
     */
    public String getPromoDiscCode() {
        return (String) getAttributeInternal(PROMODISCCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PromoDiscCode.
     * @param value value to set the  PromoDiscCode
     */
    public void setPromoDiscCode(String value) {
        setAttributeInternal(PROMODISCCODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RCMobileNum.
     * @return the RCMobileNum
     */
    public String getRCMobileNum() {
        return (String) getAttributeInternal(RCMOBILENUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RCMobileNum.
     * @param value value to set the  RCMobileNum
     */
    public void setRCMobileNum(String value) {
        setAttributeInternal(RCMOBILENUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SaleAmt.
     * @return the SaleAmt
     */
    public BigDecimal getSaleAmt() {
        return (BigDecimal) getAttributeInternal(SALEAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SaleAmt.
     * @param value value to set the  SaleAmt
     */
    public void setSaleAmt(BigDecimal value) {
        setAttributeInternal(SALEAMT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SaleDtlseq.
     * @return the SaleDtlseq
     */
    public BigDecimal getSaleDtlseq() {
        return (BigDecimal) getAttributeInternal(SALEDTLSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SaleDtlseq.
     * @param value value to set the  SaleDtlseq
     */
    public void setSaleDtlseq(BigDecimal value) {
        setAttributeInternal(SALEDTLSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Salehdrseq.
     * @return the Salehdrseq
     */
    public BigDecimal getSalehdrseq() {
        return (BigDecimal) getAttributeInternal(SALEHDRSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Salehdrseq.
     * @param value value to set the  Salehdrseq
     */
    public void setSalehdrseq(BigDecimal value) {
        setAttributeInternal(SALEHDRSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Updatedby.
     * @return the Updatedby
     */
    public String getUpdatedby() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Updatedby.
     * @param value value to set the  Updatedby
     */
    public void setUpdatedby(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Updateddate.
     * @return the Updateddate
     */
    public Timestamp getUpdateddate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Updateddate.
     * @param value value to set the  Updateddate
     */
    public void setUpdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
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
     * Gets the attribute value for the calculated attribute pvtnumber.
     * @return the pvtnumber
     */
    public String getpvtnumber() {
        return (String) getAttributeInternal(PVTNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute pvtnumber.
     * @param value value to set the  pvtnumber
     */
    public void setpvtnumber(String value) {
        setAttributeInternal(PVTNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute permitnumber.
     * @return the permitnumber
     */
    public String getpermitnumber() {
        return (String) getAttributeInternal(PERMITNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute permitnumber.
     * @param value value to set the  permitnumber
     */
    public void setpermitnumber(String value) {
        setAttributeInternal(PERMITNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute prodname.
     * @return the prodname
     */
    public String getprodname() {
        return (String) getAttributeInternal(PRODNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute prodname.
     * @param value value to set the  prodname
     */
    public void setprodname(String value) {
        setAttributeInternal(PRODNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransactionRefNo.
     * @return the TransactionRefNo
     */
    public String getTransactionRefNo() {
        return (String) getAttributeInternal(TRANSACTIONREFNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransactionRefNo.
     * @param value value to set the  TransactionRefNo
     */
    public void setTransactionRefNo(String value) {
        setAttributeInternal(TRANSACTIONREFNO, value);
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
