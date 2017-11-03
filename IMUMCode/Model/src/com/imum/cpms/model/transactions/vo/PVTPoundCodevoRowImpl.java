package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 19 11:51:40 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTPoundCodevoRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        locationid {
            public Object get(PVTPoundCodevoRowImpl obj) {
                return obj.getlocationid();
            }

            public void put(PVTPoundCodevoRowImpl obj, Object value) {
                obj.setlocationid((Integer)value);
            }
        }
        ,
        locationdesc {
            public Object get(PVTPoundCodevoRowImpl obj) {
                return obj.getlocationdesc();
            }

            public void put(PVTPoundCodevoRowImpl obj, Object value) {
                obj.setlocationdesc((String)value);
            }
        }
        ,
        enforcevhclid {
            public Object get(PVTPoundCodevoRowImpl obj) {
                return obj.getenforcevhclid();
            }

            public void put(PVTPoundCodevoRowImpl obj, Object value) {
                obj.setenforcevhclid((BigDecimal)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PVTPoundCodevoRowImpl object);

        public abstract void put(PVTPoundCodevoRowImpl object, Object value);

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


    public static final int LOCATIONID = AttributesEnum.locationid.index();
    public static final int LOCATIONDESC = AttributesEnum.locationdesc.index();
    public static final int ENFORCEVHCLID = AttributesEnum.enforcevhclid.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PVTPoundCodevoRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute locationid.
     * @return the locationid
     */
    public Integer getlocationid() {
        return (Integer) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute locationid.
     * @param value value to set the  locationid
     */
    public void setlocationid(Integer value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute locationdesc.
     * @return the locationdesc
     */
    public String getlocationdesc() {
        return (String) getAttributeInternal(LOCATIONDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute locationdesc.
     * @param value value to set the  locationdesc
     */
    public void setlocationdesc(String value) {
        setAttributeInternal(LOCATIONDESC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute enforcevhclid.
     * @return the enforcevhclid
     */
    public BigDecimal getenforcevhclid() {
        return (BigDecimal) getAttributeInternal(ENFORCEVHCLID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute enforcevhclid.
     * @param value value to set the  enforcevhclid
     */
    public void setenforcevhclid(BigDecimal value) {
        setAttributeInternal(ENFORCEVHCLID, value);
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
