package com.imum.cpms.model.masters.vo;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 19 16:41:24 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PoundLocationLVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        LocationID {
            public Object get(PoundLocationLVORowImpl obj) {
                return obj.getLocationID();
            }

            public void put(PoundLocationLVORowImpl obj, Object value) {
                obj.setLocationID((Integer)value);
            }
        }
        ,
        LocDesc {
            public Object get(PoundLocationLVORowImpl obj) {
                return obj.getLocDesc();
            }

            public void put(PoundLocationLVORowImpl obj, Object value) {
                obj.setLocDesc((String)value);
            }
        }
        ,
        LngCode {
            public Object get(PoundLocationLVORowImpl obj) {
                return obj.getLngCode();
            }

            public void put(PoundLocationLVORowImpl obj, Object value) {
                obj.setLngCode((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PoundLocationLVORowImpl object);

        public abstract void put(PoundLocationLVORowImpl object, Object value);

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


    public static final int LOCATIONID = AttributesEnum.LocationID.index();
    public static final int LOCDESC = AttributesEnum.LocDesc.index();
    public static final int LNGCODE = AttributesEnum.LngCode.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PoundLocationLVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute LocationID.
     * @return the LocationID
     */
    public Integer getLocationID() {
        return (Integer) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LocationID.
     * @param value value to set the  LocationID
     */
    public void setLocationID(Integer value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LocDesc.
     * @return the LocDesc
     */
    public String getLocDesc() {
        return (String) getAttributeInternal(LOCDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LocDesc.
     * @param value value to set the  LocDesc
     */
    public void setLocDesc(String value) {
        setAttributeInternal(LOCDESC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LngCode.
     * @return the LngCode
     */
    public String getLngCode() {
        return (String) getAttributeInternal(LNGCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LngCode.
     * @param value value to set the  LngCode
     */
    public void setLngCode(String value) {
        setAttributeInternal(LNGCODE, value);
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