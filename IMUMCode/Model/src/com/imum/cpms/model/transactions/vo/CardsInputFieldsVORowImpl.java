package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Date;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 10 17:14:53 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CardsInputFieldsVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CardIssuancenumber {
            public Object get(CardsInputFieldsVORowImpl obj) {
                return obj.getCardIssuancenumber();
            }

            public void put(CardsInputFieldsVORowImpl obj, Object value) {
                obj.setCardIssuancenumber((BigDecimal)value);
            }
        }
        ,
        SaleReceiptnumber {
            public Object get(CardsInputFieldsVORowImpl obj) {
                return obj.getSaleReceiptnumber();
            }

            public void put(CardsInputFieldsVORowImpl obj, Object value) {
                obj.setSaleReceiptnumber((String)value);
            }
        }
        ,
        dispatchDate {
            public Object get(CardsInputFieldsVORowImpl obj) {
                return obj.getdispatchDate();
            }

            public void put(CardsInputFieldsVORowImpl obj, Object value) {
                obj.setdispatchDate((Date)value);
            }
        }
        ,
        LocationId {
            public Object get(CardsInputFieldsVORowImpl obj) {
                return obj.getLocationId();
            }

            public void put(CardsInputFieldsVORowImpl obj, Object value) {
                obj.setLocationId((Integer)value);
            }
        }
        ,
        Saledate {
            public Object get(CardsInputFieldsVORowImpl obj) {
                return obj.getSaledate();
            }

            public void put(CardsInputFieldsVORowImpl obj, Object value) {
                obj.setSaledate((Date)value);
            }
        }
        ,
        CardLocationLOVVO1 {
            public Object get(CardsInputFieldsVORowImpl obj) {
                return obj.getCardLocationLOVVO1();
            }

            public void put(CardsInputFieldsVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(CardsInputFieldsVORowImpl object);

        public abstract void put(CardsInputFieldsVORowImpl object,
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
    public static final int CARDISSUANCENUMBER = AttributesEnum.CardIssuancenumber.index();
    public static final int SALERECEIPTNUMBER = AttributesEnum.SaleReceiptnumber.index();
    public static final int DISPATCHDATE = AttributesEnum.dispatchDate.index();
    public static final int LOCATIONID = AttributesEnum.LocationId.index();
    public static final int SALEDATE = AttributesEnum.Saledate.index();
    public static final int CARDLOCATIONLOVVO1 = AttributesEnum.CardLocationLOVVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CardsInputFieldsVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute CardIssuancenumber.
     * @return the CardIssuancenumber
     */
    public BigDecimal getCardIssuancenumber() {
        return (BigDecimal) getAttributeInternal(CARDISSUANCENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CardIssuancenumber.
     * @param value value to set the  CardIssuancenumber
     */
    public void setCardIssuancenumber(BigDecimal value) {
        setAttributeInternal(CARDISSUANCENUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SaleReceiptnumber.
     * @return the SaleReceiptnumber
     */
    public String getSaleReceiptnumber() {
        return (String) getAttributeInternal(SALERECEIPTNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SaleReceiptnumber.
     * @param value value to set the  SaleReceiptnumber
     */
    public void setSaleReceiptnumber(String value) {
        setAttributeInternal(SALERECEIPTNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute dispatchDate.
     * @return the dispatchDate
     */
    public Date getdispatchDate() {
        return (Date) getAttributeInternal(DISPATCHDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute dispatchDate.
     * @param value value to set the  dispatchDate
     */
    public void setdispatchDate(Date value) {
        setAttributeInternal(DISPATCHDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LocationId.
     * @return the LocationId
     */
    public Integer getLocationId() {
        return (Integer) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LocationId.
     * @param value value to set the  LocationId
     */
    public void setLocationId(Integer value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Saledate.
     * @return the Saledate
     */
    public Date getSaledate() {
        return (Date) getAttributeInternal(SALEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Saledate.
     * @param value value to set the  Saledate
     */
    public void setSaledate(Date value) {
        setAttributeInternal(SALEDATE, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CardLocationLOVVO1.
     */
    public RowSet getCardLocationLOVVO1() {
        return (RowSet)getAttributeInternal(CARDLOCATIONLOVVO1);
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
