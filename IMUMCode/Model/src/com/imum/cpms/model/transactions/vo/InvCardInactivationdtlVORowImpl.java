package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Mar 21 15:48:30 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InvCardInactivationdtlVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Inactivatedtlseq {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getInactivatedtlseq();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setInactivatedtlseq((BigDecimal)value);
            }
        }
        ,
        InactivateHdrseq {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getInactivateHdrseq();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setInactivateHdrseq((BigDecimal)value);
            }
        }
        ,
        Cardnum {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getCardnum();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setCardnum((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        InactivationReason {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getInactivationReason();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setInactivationReason((Integer)value);
            }
        }
        ,
        Approvedflag {
            public Object get(InvCardInactivationdtlVORowImpl obj) {
                return obj.getApprovedflag();
            }

            public void put(InvCardInactivationdtlVORowImpl obj,
                            Object value) {
                obj.setApprovedflag((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(InvCardInactivationdtlVORowImpl object);

        public abstract void put(InvCardInactivationdtlVORowImpl object,
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


    public static final int INACTIVATEDTLSEQ = AttributesEnum.Inactivatedtlseq.index();
    public static final int INACTIVATEHDRSEQ = AttributesEnum.InactivateHdrseq.index();
    public static final int CARDNUM = AttributesEnum.Cardnum.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int INACTIVATIONREASON = AttributesEnum.InactivationReason.index();
    public static final int APPROVEDFLAG = AttributesEnum.Approvedflag.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InvCardInactivationdtlVORowImpl() {
    }

    /**
     * Gets InvCardInactivationdtlEO entity object.
     * @return the InvCardInactivationdtlEO
     */
    public EntityImpl getInvCardInactivationdtlEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Inactivate_dtl_seq using the alias name Inactivatedtlseq.
     * @return the Inactivate_dtl_seq
     */
    public BigDecimal getInactivatedtlseq() {
        return (BigDecimal) getAttributeInternal(INACTIVATEDTLSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for Inactivate_dtl_seq using the alias name Inactivatedtlseq.
     * @param value value to set the Inactivate_dtl_seq
     */
    public void setInactivatedtlseq(BigDecimal value) {
        setAttributeInternal(INACTIVATEDTLSEQ, value);
    }

    /**
     * Gets the attribute value for Inactivate_Hdr_seq using the alias name InactivateHdrseq.
     * @return the Inactivate_Hdr_seq
     */
    public BigDecimal getInactivateHdrseq() {
        return (BigDecimal) getAttributeInternal(INACTIVATEHDRSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for Inactivate_Hdr_seq using the alias name InactivateHdrseq.
     * @param value value to set the Inactivate_Hdr_seq
     */
    public void setInactivateHdrseq(BigDecimal value) {
        setAttributeInternal(INACTIVATEHDRSEQ, value);
    }

    /**
     * Gets the attribute value for Card_num using the alias name Cardnum.
     * @return the Card_num
     */
    public String getCardnum() {
        return (String) getAttributeInternal(CARDNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for Card_num using the alias name Cardnum.
     * @param value value to set the Card_num
     */
    public void setCardnum(String value) {
        setAttributeInternal(CARDNUM, value);
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
     * Gets the attribute value for Inactivation_Reason_id using the alias name InactivationReason.
     * @return the Inactivation_Reason_id
     */
    public Integer getInactivationReason() {
        return (Integer) getAttributeInternal(INACTIVATIONREASON);
    }

    /**
     * Sets <code>value</code> as attribute value for Inactivation_Reason_id using the alias name InactivationReason.
     * @param value value to set the Inactivation_Reason_id
     */
    public void setInactivationReason(Integer value) {
        setAttributeInternal(INACTIVATIONREASON, value);
    }

    /**
     * Gets the attribute value for Approved_flag using the alias name Approvedflag.
     * @return the Approved_flag
     */
    public String getApprovedflag() {
        return (String) getAttributeInternal(APPROVEDFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Approved_flag using the alias name Approvedflag.
     * @param value value to set the Approved_flag
     */
    public void setApprovedflag(String value) {
        setAttributeInternal(APPROVEDFLAG, value);
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
