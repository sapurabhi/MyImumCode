package com.imum.cpms.model.transactions.vo;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Apr 03 20:13:11 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PaymentsTypesLOVVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        valuecode {
            public Object get(PaymentsTypesLOVVORowImpl obj) {
                return obj.getvaluecode();
            }

            public void put(PaymentsTypesLOVVORowImpl obj, Object value) {
                obj.setvaluecode((String)value);
            }
        }
        ,
        valuedesc {
            public Object get(PaymentsTypesLOVVORowImpl obj) {
                return obj.getvaluedesc();
            }

            public void put(PaymentsTypesLOVVORowImpl obj, Object value) {
                obj.setvaluedesc((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PaymentsTypesLOVVORowImpl object);

        public abstract void put(PaymentsTypesLOVVORowImpl object,
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
    public static final int VALUECODE = AttributesEnum.valuecode.index();
    public static final int VALUEDESC = AttributesEnum.valuedesc.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PaymentsTypesLOVVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute valuecode.
     * @return the valuecode
     */
    public String getvaluecode() {
        return (String) getAttributeInternal(VALUECODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute valuecode.
     * @param value value to set the  valuecode
     */
    public void setvaluecode(String value) {
        setAttributeInternal(VALUECODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute valuedesc.
     * @return the valuedesc
     */
    public String getvaluedesc() {
        return (String) getAttributeInternal(VALUEDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute valuedesc.
     * @param value value to set the  valuedesc
     */
    public void setvaluedesc(String value) {
        setAttributeInternal(VALUEDESC, value);
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
