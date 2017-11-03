package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 04 12:38:59 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InventoryEventDetailsVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        LoginprintID {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.getLoginprintID();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.setLoginprintID((String)value);
            }
        }
        ,
        eventid {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.geteventid();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.seteventid((BigDecimal)value);
            }
        }
        ,
        eventdate {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.geteventdate();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.seteventdate((Timestamp)value);
            }
        }
        ,
        eventdesc {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.geteventdesc();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.seteventdesc((String)value);
            }
        }
        ,
        remarks {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.getremarks();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.setremarks((String)value);
            }
        }
        ,
        eventamt {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.geteventamt();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.seteventamt((BigDecimal)value);
            }
        }
        ,
        balanceamt {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.getbalanceamt();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.setbalanceamt((BigDecimal)value);
            }
        }
        ,
        invdetailseq {
            public Object get(InventoryEventDetailsVORowImpl obj) {
                return obj.getinvdetailseq();
            }

            public void put(InventoryEventDetailsVORowImpl obj, Object value) {
                obj.setinvdetailseq((BigDecimal)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(InventoryEventDetailsVORowImpl object);

        public abstract void put(InventoryEventDetailsVORowImpl object,
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


    public static final int LOGINPRINTID = AttributesEnum.LoginprintID.index();
    public static final int EVENTID = AttributesEnum.eventid.index();
    public static final int EVENTDATE = AttributesEnum.eventdate.index();
    public static final int EVENTDESC = AttributesEnum.eventdesc.index();
    public static final int REMARKS = AttributesEnum.remarks.index();
    public static final int EVENTAMT = AttributesEnum.eventamt.index();
    public static final int BALANCEAMT = AttributesEnum.balanceamt.index();
    public static final int INVDETAILSEQ = AttributesEnum.invdetailseq.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InventoryEventDetailsVORowImpl() {
    }


    /**
     * Gets the attribute value for the calculated attribute LoginprintID.
     * @return the LoginprintID
     */
    public String getLoginprintID() {
        return (String) getAttributeInternal(LOGINPRINTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LoginprintID.
     * @param value value to set the  LoginprintID
     */
    public void setLoginprintID(String value) {
        setAttributeInternal(LOGINPRINTID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute eventid.
     * @return the eventid
     */
    public BigDecimal geteventid() {
        return (BigDecimal) getAttributeInternal(EVENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute eventid.
     * @param value value to set the  eventid
     */
    public void seteventid(BigDecimal value) {
        setAttributeInternal(EVENTID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute eventdate.
     * @return the eventdate
     */
    public Timestamp geteventdate() {
        return (Timestamp) getAttributeInternal(EVENTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute eventdate.
     * @param value value to set the  eventdate
     */
    public void seteventdate(Timestamp value) {
        setAttributeInternal(EVENTDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute eventdesc.
     * @return the eventdesc
     */
    public String geteventdesc() {
        return (String) getAttributeInternal(EVENTDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute eventdesc.
     * @param value value to set the  eventdesc
     */
    public void seteventdesc(String value) {
        setAttributeInternal(EVENTDESC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute remarks.
     * @return the remarks
     */
    public String getremarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute remarks.
     * @param value value to set the  remarks
     */
    public void setremarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute eventamt.
     * @return the eventamt
     */
    public BigDecimal geteventamt() {
        return (BigDecimal) getAttributeInternal(EVENTAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute eventamt.
     * @param value value to set the  eventamt
     */
    public void seteventamt(BigDecimal value) {
        setAttributeInternal(EVENTAMT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute balanceamt.
     * @return the balanceamt
     */
    public BigDecimal getbalanceamt() {
        return (BigDecimal) getAttributeInternal(BALANCEAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute balanceamt.
     * @param value value to set the  balanceamt
     */
    public void setbalanceamt(BigDecimal value) {
        setAttributeInternal(BALANCEAMT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute invdetailseq.
     * @return the invdetailseq
     */
    public BigDecimal getinvdetailseq() {
        return (BigDecimal) getAttributeInternal(INVDETAILSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute invdetailseq.
     * @param value value to set the  invdetailseq
     */
    public void setinvdetailseq(BigDecimal value) {
        setAttributeInternal(INVDETAILSEQ, value);
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