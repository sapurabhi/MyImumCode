package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 26 15:34:44 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InventorySaleDetailsVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        salehdrseq {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getsalehdrseq();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setsalehdrseq((BigDecimal)value);
            }
        }
        ,
        receiptnum {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getreceiptnum();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setreceiptnum((String)value);
            }
        }
        ,
        saledate {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getsaledate();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setsaledate((Timestamp)value);
            }
        }
        ,
        saleamt {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getsaleamt();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setsaleamt((BigDecimal)value);
            }
        }
        ,
        cardnumfrom {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getcardnumfrom();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setcardnumfrom((String)value);
            }
        }
        ,
        cardnumto {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getcardnumto();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setcardnumto((String)value);
            }
        }
        ,
        ParkingCardEXPDATE {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getParkingCardEXPDATE();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setParkingCardEXPDATE((Date)value);
            }
        }
        ,
        actioncode {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getactioncode();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setactioncode((Integer)value);
            }
        }
        ,
        ActionDesc {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getActionDesc();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setActionDesc((String)value);
            }
        }
        ,
        pymttype {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getpymttype();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setpymttype((String)value);
            }
        }
        ,
        PaymentDesc {
            public Object get(InventorySaleDetailsVORowImpl obj) {
                return obj.getPaymentDesc();
            }

            public void put(InventorySaleDetailsVORowImpl obj, Object value) {
                obj.setPaymentDesc((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(InventorySaleDetailsVORowImpl object);

        public abstract void put(InventorySaleDetailsVORowImpl object,
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
    public static final int SALEHDRSEQ = AttributesEnum.salehdrseq.index();
    public static final int RECEIPTNUM = AttributesEnum.receiptnum.index();
    public static final int SALEDATE = AttributesEnum.saledate.index();
    public static final int SALEAMT = AttributesEnum.saleamt.index();
    public static final int CARDNUMFROM = AttributesEnum.cardnumfrom.index();
    public static final int CARDNUMTO = AttributesEnum.cardnumto.index();
    public static final int PARKINGCARDEXPDATE = AttributesEnum.ParkingCardEXPDATE.index();
    public static final int ACTIONCODE = AttributesEnum.actioncode.index();
    public static final int ACTIONDESC = AttributesEnum.ActionDesc.index();
    public static final int PYMTTYPE = AttributesEnum.pymttype.index();
    public static final int PAYMENTDESC = AttributesEnum.PaymentDesc.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InventorySaleDetailsVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute salehdrseq.
     * @return the salehdrseq
     */
    public BigDecimal getsalehdrseq() {
        return (BigDecimal) getAttributeInternal(SALEHDRSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute salehdrseq.
     * @param value value to set the  salehdrseq
     */
    public void setsalehdrseq(BigDecimal value) {
        setAttributeInternal(SALEHDRSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute receiptnum.
     * @return the receiptnum
     */
    public String getreceiptnum() {
        return (String) getAttributeInternal(RECEIPTNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute receiptnum.
     * @param value value to set the  receiptnum
     */
    public void setreceiptnum(String value) {
        setAttributeInternal(RECEIPTNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute saledate.
     * @return the saledate
     */
    public Timestamp getsaledate() {
        return (Timestamp) getAttributeInternal(SALEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute saledate.
     * @param value value to set the  saledate
     */
    public void setsaledate(Timestamp value) {
        setAttributeInternal(SALEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute saleamt.
     * @return the saleamt
     */
    public BigDecimal getsaleamt() {
        return (BigDecimal) getAttributeInternal(SALEAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute saleamt.
     * @param value value to set the  saleamt
     */
    public void setsaleamt(BigDecimal value) {
        setAttributeInternal(SALEAMT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute cardnumfrom.
     * @return the cardnumfrom
     */
    public String getcardnumfrom() {
        return (String) getAttributeInternal(CARDNUMFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute cardnumfrom.
     * @param value value to set the  cardnumfrom
     */
    public void setcardnumfrom(String value) {
        setAttributeInternal(CARDNUMFROM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute cardnumto.
     * @return the cardnumto
     */
    public String getcardnumto() {
        return (String) getAttributeInternal(CARDNUMTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute cardnumto.
     * @param value value to set the  cardnumto
     */
    public void setcardnumto(String value) {
        setAttributeInternal(CARDNUMTO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ParkingCardEXPDATE.
     * @return the ParkingCardEXPDATE
     */
    public Date getParkingCardEXPDATE() {
        return (Date) getAttributeInternal(PARKINGCARDEXPDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ParkingCardEXPDATE.
     * @param value value to set the  ParkingCardEXPDATE
     */
    public void setParkingCardEXPDATE(Date value) {
        setAttributeInternal(PARKINGCARDEXPDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute actioncode.
     * @return the actioncode
     */
    public Integer getactioncode() {
        return (Integer) getAttributeInternal(ACTIONCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute actioncode.
     * @param value value to set the  actioncode
     */
    public void setactioncode(Integer value) {
        setAttributeInternal(ACTIONCODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ActionDesc.
     * @return the ActionDesc
     */
    public String getActionDesc() {
        return (String) getAttributeInternal(ACTIONDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ActionDesc.
     * @param value value to set the  ActionDesc
     */
    public void setActionDesc(String value) {
        setAttributeInternal(ACTIONDESC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute pymttype.
     * @return the pymttype
     */
    public String getpymttype() {
        return (String) getAttributeInternal(PYMTTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute pymttype.
     * @param value value to set the  pymttype
     */
    public void setpymttype(String value) {
        setAttributeInternal(PYMTTYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PaymentDesc.
     * @return the PaymentDesc
     */
    public String getPaymentDesc() {
        return (String) getAttributeInternal(PAYMENTDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PaymentDesc.
     * @param value value to set the  PaymentDesc
     */
    public void setPaymentDesc(String value) {
        setAttributeInternal(PAYMENTDESC, value);
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
