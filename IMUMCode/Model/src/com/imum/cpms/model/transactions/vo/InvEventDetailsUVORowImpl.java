package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 11 13:21:16 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InvEventDetailsUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        INVEVENTseq {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getINVEVENTseq();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setINVEVENTseq((BigDecimal)value);
            }
        }
        ,
        InvDetailSeq {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getInvDetailSeq();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setInvDetailSeq((BigDecimal)value);
            }
        }
        ,
        EVENTID {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getEVENTID();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setEVENTID((BigDecimal)value);
            }
        }
        ,
        EVENTDATE {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getEVENTDATE();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setEVENTDATE((Timestamp)value);
            }
        }
        ,
        Remarks {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getRemarks();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        EventAmt {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getEventAmt();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setEventAmt((BigDecimal)value);
            }
        }
        ,
        BalanceAmt {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getBalanceAmt();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setBalanceAmt((BigDecimal)value);
            }
        }
        ,
        BPELRefID {
            public Object get(InvEventDetailsUVORowImpl obj) {
                return obj.getBPELRefID();
            }

            public void put(InvEventDetailsUVORowImpl obj, Object value) {
                obj.setBPELRefID((BigDecimal)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(InvEventDetailsUVORowImpl object);

        public abstract void put(InvEventDetailsUVORowImpl object,
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
    public static final int INVEVENTSEQ = AttributesEnum.INVEVENTseq.index();
    public static final int INVDETAILSEQ = AttributesEnum.InvDetailSeq.index();
    public static final int EVENTID = AttributesEnum.EVENTID.index();
    public static final int EVENTDATE = AttributesEnum.EVENTDATE.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int EVENTAMT = AttributesEnum.EventAmt.index();
    public static final int BALANCEAMT = AttributesEnum.BalanceAmt.index();
    public static final int BPELREFID = AttributesEnum.BPELRefID.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InvEventDetailsUVORowImpl() {
    }

    /**
     * Gets InvEventDetailsEO entity object.
     * @return the InvEventDetailsEO
     */
    public EntityImpl getInvEventDetailsEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for INV_EVENT_seq using the alias name INVEVENTseq.
     * @return the INV_EVENT_seq
     */
    public BigDecimal getINVEVENTseq() {
        return (BigDecimal) getAttributeInternal(INVEVENTSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for INV_EVENT_seq using the alias name INVEVENTseq.
     * @param value value to set the INV_EVENT_seq
     */
    public void setINVEVENTseq(BigDecimal value) {
        setAttributeInternal(INVEVENTSEQ, value);
    }

    /**
     * Gets the attribute value for Inv_Detail_Seq using the alias name InvDetailSeq.
     * @return the Inv_Detail_Seq
     */
    public BigDecimal getInvDetailSeq() {
        return (BigDecimal) getAttributeInternal(INVDETAILSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for Inv_Detail_Seq using the alias name InvDetailSeq.
     * @param value value to set the Inv_Detail_Seq
     */
    public void setInvDetailSeq(BigDecimal value) {
        setAttributeInternal(INVDETAILSEQ, value);
    }

    /**
     * Gets the attribute value for EVENT_ID using the alias name EVENTID.
     * @return the EVENT_ID
     */
    public BigDecimal getEVENTID() {
        return (BigDecimal) getAttributeInternal(EVENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_ID using the alias name EVENTID.
     * @param value value to set the EVENT_ID
     */
    public void setEVENTID(BigDecimal value) {
        setAttributeInternal(EVENTID, value);
    }

    /**
     * Gets the attribute value for EVENT_DATE using the alias name EVENTDATE.
     * @return the EVENT_DATE
     */
    public Timestamp getEVENTDATE() {
        return (Timestamp) getAttributeInternal(EVENTDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_DATE using the alias name EVENTDATE.
     * @param value value to set the EVENT_DATE
     */
    public void setEVENTDATE(Timestamp value) {
        setAttributeInternal(EVENTDATE, value);
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
     * Gets the attribute value for Event_Amt using the alias name EventAmt.
     * @return the Event_Amt
     */
    public BigDecimal getEventAmt() {
        return (BigDecimal) getAttributeInternal(EVENTAMT);
    }

    /**
     * Sets <code>value</code> as attribute value for Event_Amt using the alias name EventAmt.
     * @param value value to set the Event_Amt
     */
    public void setEventAmt(BigDecimal value) {
        setAttributeInternal(EVENTAMT, value);
    }

    /**
     * Gets the attribute value for Balance_Amt using the alias name BalanceAmt.
     * @return the Balance_Amt
     */
    public BigDecimal getBalanceAmt() {
        return (BigDecimal) getAttributeInternal(BALANCEAMT);
    }

    /**
     * Sets <code>value</code> as attribute value for Balance_Amt using the alias name BalanceAmt.
     * @param value value to set the Balance_Amt
     */
    public void setBalanceAmt(BigDecimal value) {
        setAttributeInternal(BALANCEAMT, value);
    }

    /**
     * Gets the attribute value for BPEL_Ref_ID using the alias name BPELRefID.
     * @return the BPEL_Ref_ID
     */
    public BigDecimal getBPELRefID() {
        return (BigDecimal) getAttributeInternal(BPELREFID);
    }

    /**
     * Sets <code>value</code> as attribute value for BPEL_Ref_ID using the alias name BPELRefID.
     * @param value value to set the BPEL_Ref_ID
     */
    public void setBPELRefID(BigDecimal value) {
        setAttributeInternal(BPELREFID, value);
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
