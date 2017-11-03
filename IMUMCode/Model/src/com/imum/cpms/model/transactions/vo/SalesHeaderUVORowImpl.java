package com.imum.cpms.model.transactions.vo;

import com.imum.cpms.model.transactions.eo.SalesHeaderEOImpl;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Sep 25 19:25:20 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SalesHeaderUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreatedBy {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        CutomerID {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getCutomerID();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setCutomerID((BigDecimal)value);
            }
        }
        ,
        Instflag {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getInstflag();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setInstflag((String)value);
            }
        }
        ,
        LGCReceiptnumber {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getLGCReceiptnumber();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setLGCReceiptnumber((String)value);
            }
        }
        ,
        ReceiptNum {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getReceiptNum();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setReceiptNum((String)value);
            }
        }
        ,
        SaleAmt {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getSaleAmt();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setSaleAmt((BigDecimal)value);
            }
        }
        ,
        Saledate {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getSaledate();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setSaledate((Date)value);
            }
        }
        ,
        Salehdrseq {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getSalehdrseq();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setSalehdrseq((BigDecimal)value);
            }
        }
        ,
        USERID {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getUSERID();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setUSERID((String)value);
            }
        }
        ,
        Updatedby {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        locationid {
            public Object get(SalesHeaderUVORowImpl obj) {
                return obj.getlocationid();
            }

            public void put(SalesHeaderUVORowImpl obj, Object value) {
                obj.setlocationid((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SalesHeaderUVORowImpl object);

        public abstract void put(SalesHeaderUVORowImpl object, Object value);

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
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int CUTOMERID = AttributesEnum.CutomerID.index();
    public static final int INSTFLAG = AttributesEnum.Instflag.index();
    public static final int LGCRECEIPTNUMBER = AttributesEnum.LGCReceiptnumber.index();
    public static final int RECEIPTNUM = AttributesEnum.ReceiptNum.index();
    public static final int SALEAMT = AttributesEnum.SaleAmt.index();
    public static final int SALEDATE = AttributesEnum.Saledate.index();
    public static final int SALEHDRSEQ = AttributesEnum.Salehdrseq.index();
    public static final int USERID = AttributesEnum.USERID.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int LOCATIONID = AttributesEnum.locationid.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SalesHeaderUVORowImpl() {
    }

    /**
     * Gets SalesHeaderEO entity object.
     * @return the SalesHeaderEO
     */
    public SalesHeaderEOImpl getSalesHeaderEO() {
        return (SalesHeaderEOImpl)getEntity(0);
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
     * Gets the attribute value for Cutomer_ID using the alias name CutomerID.
     * @return the Cutomer_ID
     */
    public BigDecimal getCutomerID() {
        return (BigDecimal) getAttributeInternal(CUTOMERID);
    }

    /**
     * Sets <code>value</code> as attribute value for Cutomer_ID using the alias name CutomerID.
     * @param value value to set the Cutomer_ID
     */
    public void setCutomerID(BigDecimal value) {
        setAttributeInternal(CUTOMERID, value);
    }

    /**
     * Gets the attribute value for Inst_flag using the alias name Instflag.
     * @return the Inst_flag
     */
    public String getInstflag() {
        return (String) getAttributeInternal(INSTFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Inst_flag using the alias name Instflag.
     * @param value value to set the Inst_flag
     */
    public void setInstflag(String value) {
        setAttributeInternal(INSTFLAG, value);
    }

    /**
     * Gets the attribute value for LGC_Receipt_number using the alias name LGCReceiptnumber.
     * @return the LGC_Receipt_number
     */
    public String getLGCReceiptnumber() {
        return (String) getAttributeInternal(LGCRECEIPTNUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for LGC_Receipt_number using the alias name LGCReceiptnumber.
     * @param value value to set the LGC_Receipt_number
     */
    public void setLGCReceiptnumber(String value) {
        setAttributeInternal(LGCRECEIPTNUMBER, value);
    }

    /**
     * Gets the attribute value for Receipt_Num using the alias name ReceiptNum.
     * @return the Receipt_Num
     */
    public String getReceiptNum() {
        return (String) getAttributeInternal(RECEIPTNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for Receipt_Num using the alias name ReceiptNum.
     * @param value value to set the Receipt_Num
     */
    public void setReceiptNum(String value) {
        setAttributeInternal(RECEIPTNUM, value);
    }

    /**
     * Gets the attribute value for Sale_Amt using the alias name SaleAmt.
     * @return the Sale_Amt
     */
    public BigDecimal getSaleAmt() {
        return (BigDecimal) getAttributeInternal(SALEAMT);
    }

    /**
     * Sets <code>value</code> as attribute value for Sale_Amt using the alias name SaleAmt.
     * @param value value to set the Sale_Amt
     */
    public void setSaleAmt(BigDecimal value) {
        setAttributeInternal(SALEAMT, value);
    }

    /**
     * Gets the attribute value for Sale_date using the alias name Saledate.
     * @return the Sale_date
     */
    public Date getSaledate() {
        return (Date) getAttributeInternal(SALEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Sale_date using the alias name Saledate.
     * @param value value to set the Sale_date
     */
    public void setSaledate(Date value) {
        setAttributeInternal(SALEDATE, value);
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
     * Gets the attribute value for USER_ID using the alias name USERID.
     * @return the USER_ID
     */
    public String getUSERID() {
        return (String) getAttributeInternal(USERID);
    }

    /**
     * Sets <code>value</code> as attribute value for USER_ID using the alias name USERID.
     * @param value value to set the USER_ID
     */
    public void setUSERID(String value) {
        setAttributeInternal(USERID, value);
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
     * Gets the attribute value for location_id using the alias name locationid.
     * @return the location_id
     */
    public String getlocationid() {
        return (String) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for location_id using the alias name locationid.
     * @param value value to set the location_id
     */
    public void setlocationid(String value) {
        setAttributeInternal(LOCATIONID, value);
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
