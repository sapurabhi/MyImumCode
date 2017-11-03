package com.imum.cpms.model.transactions.vo;

import com.imum.cpms.model.transactions.vo.common.CardIssueSrchCriVORow;

import java.math.BigDecimal;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 28 16:16:15 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CardIssueSrchCriVORowImpl extends ViewRowImpl implements CardIssueSrchCriVORow {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CardType {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getCardType();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setCardType((String)value);
            }
        }
        ,
        Denomination {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getDenomination();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setDenomination((Integer)value);
            }
        }
        ,
        NoOfCards {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getNoOfCards();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setNoOfCards((Integer)value);
            }
        }
        ,
        StartNum {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getStartNum();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setStartNum((String)value);
            }
        }
        ,
        EndNum {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getEndNum();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setEndNum((String)value);
            }
        }
        ,
        RemoveFlag {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getRemoveFlag();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setRemoveFlag((Boolean)value);
            }
        }
        ,
        BulkSaleCardType {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getBulkSaleCardType();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setBulkSaleCardType((String)value);
            }
        }
        ,
        CardTypeLOVVO1 {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getCardTypeLOVVO1();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        DenominationLOVVO1 {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getDenominationLOVVO1();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        BulkCardtypeStaticLOVVO1 {
            public Object get(CardIssueSrchCriVORowImpl obj) {
                return obj.getBulkCardtypeStaticLOVVO1();
            }

            public void put(CardIssueSrchCriVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(CardIssueSrchCriVORowImpl object);

        public abstract void put(CardIssueSrchCriVORowImpl object,
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


    public static final int CARDTYPE = AttributesEnum.CardType.index();
    public static final int DENOMINATION = AttributesEnum.Denomination.index();
    public static final int NOOFCARDS = AttributesEnum.NoOfCards.index();
    public static final int STARTNUM = AttributesEnum.StartNum.index();
    public static final int ENDNUM = AttributesEnum.EndNum.index();
    public static final int REMOVEFLAG = AttributesEnum.RemoveFlag.index();
    public static final int BULKSALECARDTYPE = AttributesEnum.BulkSaleCardType.index();
    public static final int CARDTYPELOVVO1 = AttributesEnum.CardTypeLOVVO1.index();
    public static final int DENOMINATIONLOVVO1 = AttributesEnum.DenominationLOVVO1.index();
    public static final int BULKCARDTYPESTATICLOVVO1 = AttributesEnum.BulkCardtypeStaticLOVVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CardIssueSrchCriVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute CardType.
     * @return the CardType
     */
    public String getCardType() {
        return (String) getAttributeInternal(CARDTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CardType.
     * @param value value to set the  CardType
     */
    public void setCardType(String value) {
        setAttributeInternal(CARDTYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Denomination.
     * @return the Denomination
     */
    public Integer getDenomination() {
        return (Integer) getAttributeInternal(DENOMINATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Denomination.
     * @param value value to set the  Denomination
     */
    public void setDenomination(Integer value) {
        setAttributeInternal(DENOMINATION, value);
    }

    /**
     * Gets the attribute value for the calculated attribute NoOfCards.
     * @return the NoOfCards
     */
    public Integer getNoOfCards() {
        return (Integer) getAttributeInternal(NOOFCARDS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute NoOfCards.
     * @param value value to set the  NoOfCards
     */
    public void setNoOfCards(Integer value) {
        setAttributeInternal(NOOFCARDS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StartNum.
     * @return the StartNum
     */
    public String getStartNum() {
        return (String) getAttributeInternal(STARTNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StartNum.
     * @param value value to set the  StartNum
     */
    public void setStartNum(String value) {
        setAttributeInternal(STARTNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EndNum.
     * @return the EndNum
     */
    public String getEndNum() {
        return (String) getAttributeInternal(ENDNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EndNum.
     * @param value value to set the  EndNum
     */
    public void setEndNum(String value) {
        setAttributeInternal(ENDNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RemoveFlag.
     * @return the RemoveFlag
     */
    public Boolean getRemoveFlag() {
        return (Boolean) getAttributeInternal(REMOVEFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RemoveFlag.
     * @param value value to set the  RemoveFlag
     */
    public void setRemoveFlag(Boolean value) {
        setAttributeInternal(REMOVEFLAG, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BulkSaleCardType.
     * @return the BulkSaleCardType
     */
    public String getBulkSaleCardType() {
        return (String) getAttributeInternal(BULKSALECARDTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BulkSaleCardType.
     * @param value value to set the  BulkSaleCardType
     */
    public void setBulkSaleCardType(String value) {
        setAttributeInternal(BULKSALECARDTYPE, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CardTypeLOVVO1.
     */
    public RowSet getCardTypeLOVVO1() {
        return (RowSet)getAttributeInternal(CARDTYPELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> DenominationLOVVO1.
     */
    public RowSet getDenominationLOVVO1() {
        return (RowSet)getAttributeInternal(DENOMINATIONLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> BulkCardtypeStaticLOVVO1.
     */
    public RowSet getBulkCardtypeStaticLOVVO1() {
        return (RowSet)getAttributeInternal(BULKCARDTYPESTATICLOVVO1);
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