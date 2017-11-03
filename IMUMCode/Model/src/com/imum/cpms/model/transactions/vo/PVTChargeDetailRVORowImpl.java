package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Sep 01 18:55:45 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTChargeDetailRVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PVTCHRGseq {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getPVTCHRGseq();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setPVTCHRGseq((BigDecimal)value);
            }
        }
        ,
        PVTHDRSEQ {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getPVTHDRSEQ();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setPVTHDRSEQ((BigDecimal)value);
            }
        }
        ,
        ChargeType {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getChargeType();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setChargeType((Integer)value);
            }
        }
        ,
        ChargeAmount {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getChargeAmount();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setChargeAmount((BigDecimal)value);
            }
        }
        ,
        ChargeDate {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getChargeDate();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setChargeDate((Timestamp)value);
            }
        }
        ,
        CreatedBy {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        GenRefDataDetailLovVO1 {
            public Object get(PVTChargeDetailRVORowImpl obj) {
                return obj.getGenRefDataDetailLovVO1();
            }

            public void put(PVTChargeDetailRVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PVTChargeDetailRVORowImpl object);

        public abstract void put(PVTChargeDetailRVORowImpl object,
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
    public static final int PVTCHRGSEQ = AttributesEnum.PVTCHRGseq.index();
    public static final int PVTHDRSEQ = AttributesEnum.PVTHDRSEQ.index();
    public static final int CHARGETYPE = AttributesEnum.ChargeType.index();
    public static final int CHARGEAMOUNT = AttributesEnum.ChargeAmount.index();
    public static final int CHARGEDATE = AttributesEnum.ChargeDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int GENREFDATADETAILLOVVO1 = AttributesEnum.GenRefDataDetailLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PVTChargeDetailRVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute PVTCHRGseq.
     * @return the PVTCHRGseq
     */
    public BigDecimal getPVTCHRGseq() {
        return (BigDecimal) getAttributeInternal(PVTCHRGSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTCHRGseq.
     * @param value value to set the  PVTCHRGseq
     */
    public void setPVTCHRGseq(BigDecimal value) {
        setAttributeInternal(PVTCHRGSEQ, value);
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
     * Gets the attribute value for the calculated attribute ChargeType.
     * @return the ChargeType
     */
    public Integer getChargeType() {
        return (Integer) getAttributeInternal(CHARGETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ChargeType.
     * @param value value to set the  ChargeType
     */
    public void setChargeType(Integer value) {
        setAttributeInternal(CHARGETYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ChargeAmount.
     * @return the ChargeAmount
     */
    public BigDecimal getChargeAmount() {
        return (BigDecimal) getAttributeInternal(CHARGEAMOUNT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ChargeAmount.
     * @param value value to set the  ChargeAmount
     */
    public void setChargeAmount(BigDecimal value) {
        setAttributeInternal(CHARGEAMOUNT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ChargeDate.
     * @return the ChargeDate
     */
    public Timestamp getChargeDate() {
        return (Timestamp) getAttributeInternal(CHARGEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ChargeDate.
     * @param value value to set the  ChargeDate
     */
    public void setChargeDate(Timestamp value) {
        setAttributeInternal(CHARGEDATE, value);
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
     * Gets the view accessor <code>RowSet</code> GenRefDataDetailLovVO1.
     */
    public RowSet getGenRefDataDetailLovVO1() {
        return (RowSet)getAttributeInternal(GENREFDATADETAILLOVVO1);
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
