package com.imum.cpms.model.transactions.vo;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Aug 26 17:06:11 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PlateTypeLOVVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        platetypeid {
            public Object get(PlateTypeLOVVORowImpl obj) {
                return obj.getplatetypeid();
            }

            public void put(PlateTypeLOVVORowImpl obj, Object value) {
                obj.setplatetypeid((Integer)value);
            }
        }
        ,
        platecategoryid {
            public Object get(PlateTypeLOVVORowImpl obj) {
                return obj.getplatecategoryid();
            }

            public void put(PlateTypeLOVVORowImpl obj, Object value) {
                obj.setplatecategoryid((Integer)value);
            }
        }
        ,
        platetypedesc {
            public Object get(PlateTypeLOVVORowImpl obj) {
                return obj.getplatetypedesc();
            }

            public void put(PlateTypeLOVVORowImpl obj, Object value) {
                obj.setplatetypedesc((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PlateTypeLOVVORowImpl object);

        public abstract void put(PlateTypeLOVVORowImpl object, Object value);

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
    public static final int PLATETYPEID = AttributesEnum.platetypeid.index();
    public static final int PLATECATEGORYID = AttributesEnum.platecategoryid.index();
    public static final int PLATETYPEDESC = AttributesEnum.platetypedesc.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PlateTypeLOVVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute platetypeid.
     * @return the platetypeid
     */
    public Integer getplatetypeid() {
        return (Integer) getAttributeInternal(PLATETYPEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute platetypeid.
     * @param value value to set the  platetypeid
     */
    public void setplatetypeid(Integer value) {
        setAttributeInternal(PLATETYPEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute platecategoryid.
     * @return the platecategoryid
     */
    public Integer getplatecategoryid() {
        return (Integer) getAttributeInternal(PLATECATEGORYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute platecategoryid.
     * @param value value to set the  platecategoryid
     */
    public void setplatecategoryid(Integer value) {
        setAttributeInternal(PLATECATEGORYID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute platetypedesc.
     * @return the platetypedesc
     */
    public String getplatetypedesc() {
        return (String) getAttributeInternal(PLATETYPEDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute platetypedesc.
     * @param value value to set the  platetypedesc
     */
    public void setplatetypedesc(String value) {
        setAttributeInternal(PLATETYPEDESC, value);
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
