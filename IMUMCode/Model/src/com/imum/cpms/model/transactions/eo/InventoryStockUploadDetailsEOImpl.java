package com.imum.cpms.model.transactions.eo;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.Timestamp;

import java.sql.Types;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jul 10 16:58:31 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InventoryStockUploadDetailsEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        
//        CallableStatement stmt = null;
//        try {
//            stmt = getDBTransaction().createCallableStatement("{call  sequence_mst_trigger(?,?) }", 0);
//            stmt.setString(1, "INV_UPLOAD_DTL_SEQ");            
//            stmt.registerOutParameter(2, Types.BIGINT);
//            stmt.execute();           
//            BigDecimal SeqNum = stmt.getBigDecimal(2);
//            setUploadDetailSeq(SeqNum);
//        }  catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        UploadDetailSeq {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getUploadDetailSeq();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setUploadDetailSeq((BigDecimal)value);
            }
        }
        ,
        UploadSeq {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getUploadSeq();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setUploadSeq((BigDecimal)value);
            }
        }
        ,
        VendorID {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getVendorID();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setVendorID((Integer)value);
            }
        }
        ,
        DispatchedDate {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getDispatchedDate();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setDispatchedDate((Date)value);
            }
        }
        ,
        OrderRefnum {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getOrderRefnum();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setOrderRefnum((String)value);
            }
        }
        ,
        Cartonnum {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getCartonnum();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setCartonnum((String)value);
            }
        }
        ,
        CardType {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getCardType();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setCardType((Integer)value);
            }
        }
        ,
        CardNumber {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getCardNumber();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setCardNumber((String)value);
            }
        }
        ,
        CVVCode {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getCVVCode();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setCVVCode((String)value);
            }
        }
        ,
        DenomAmt {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getDenomAmt();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setDenomAmt((BigDecimal)value);
            }
        }
        ,
        ExpiryDate {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getExpiryDate();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setExpiryDate((Date)value);
            }
        }
        ,
        ValidationFlag {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getValidationFlag();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setValidationFlag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(InventoryStockUploadDetailsEOImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(InventoryStockUploadDetailsEOImpl obj,
                            Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(InventoryStockUploadDetailsEOImpl object);

        public abstract void put(InventoryStockUploadDetailsEOImpl object,
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


    public static final int UPLOADDETAILSEQ = AttributesEnum.UploadDetailSeq.index();
    public static final int UPLOADSEQ = AttributesEnum.UploadSeq.index();
    public static final int VENDORID = AttributesEnum.VendorID.index();
    public static final int DISPATCHEDDATE = AttributesEnum.DispatchedDate.index();
    public static final int ORDERREFNUM = AttributesEnum.OrderRefnum.index();
    public static final int CARTONNUM = AttributesEnum.Cartonnum.index();
    public static final int CARDTYPE = AttributesEnum.CardType.index();
    public static final int CARDNUMBER = AttributesEnum.CardNumber.index();
    public static final int CVVCODE = AttributesEnum.CVVCode.index();
    public static final int DENOMAMT = AttributesEnum.DenomAmt.index();
    public static final int EXPIRYDATE = AttributesEnum.ExpiryDate.index();
    public static final int VALIDATIONFLAG = AttributesEnum.ValidationFlag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InventoryStockUploadDetailsEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.transactions.eo.InventoryStockUploadDetailsEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for UploadDetailSeq, using the alias name UploadDetailSeq.
     * @return the UploadDetailSeq
     */
    public BigDecimal getUploadDetailSeq() {
        return (BigDecimal)getAttributeInternal(UPLOADDETAILSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for UploadDetailSeq.
     * @param value value to set the UploadDetailSeq
     */
    public void setUploadDetailSeq(BigDecimal value) {
        setAttributeInternal(UPLOADDETAILSEQ, value);
    }

    /**
     * Gets the attribute value for UploadSeq, using the alias name UploadSeq.
     * @return the UploadSeq
     */
    public BigDecimal getUploadSeq() {
        return (BigDecimal)getAttributeInternal(UPLOADSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for UploadSeq.
     * @param value value to set the UploadSeq
     */
    public void setUploadSeq(BigDecimal value) {
        setAttributeInternal(UPLOADSEQ, value);
    }

    /**
     * Gets the attribute value for VendorID, using the alias name VendorID.
     * @return the VendorID
     */
    public Integer getVendorID() {
        return (Integer)getAttributeInternal(VENDORID);
    }

    /**
     * Sets <code>value</code> as the attribute value for VendorID.
     * @param value value to set the VendorID
     */
    public void setVendorID(Integer value) {
        setAttributeInternal(VENDORID, value);
    }

    /**
     * Gets the attribute value for DispatchedDate, using the alias name DispatchedDate.
     * @return the DispatchedDate
     */
    public Date getDispatchedDate() {
        return (Date)getAttributeInternal(DISPATCHEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DispatchedDate.
     * @param value value to set the DispatchedDate
     */
    public void setDispatchedDate(Date value) {
        setAttributeInternal(DISPATCHEDDATE, value);
    }

    /**
     * Gets the attribute value for OrderRefnum, using the alias name OrderRefnum.
     * @return the OrderRefnum
     */
    public String getOrderRefnum() {
        return (String)getAttributeInternal(ORDERREFNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrderRefnum.
     * @param value value to set the OrderRefnum
     */
    public void setOrderRefnum(String value) {
        setAttributeInternal(ORDERREFNUM, value);
    }

    /**
     * Gets the attribute value for Cartonnum, using the alias name Cartonnum.
     * @return the Cartonnum
     */
    public String getCartonnum() {
        return (String)getAttributeInternal(CARTONNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Cartonnum.
     * @param value value to set the Cartonnum
     */
    public void setCartonnum(String value) {
        setAttributeInternal(CARTONNUM, value);
    }

    /**
     * Gets the attribute value for CardType, using the alias name CardType.
     * @return the CardType
     */
    public Integer getCardType() {
        return (Integer)getAttributeInternal(CARDTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardType.
     * @param value value to set the CardType
     */
    public void setCardType(Integer value) {
        setAttributeInternal(CARDTYPE, value);
    }

    /**
     * Gets the attribute value for CardNumber, using the alias name CardNumber.
     * @return the CardNumber
     */
    public String getCardNumber() {
        return (String)getAttributeInternal(CARDNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardNumber.
     * @param value value to set the CardNumber
     */
    public void setCardNumber(String value) {
        setAttributeInternal(CARDNUMBER, value);
    }

    /**
     * Gets the attribute value for CVVCode, using the alias name CVVCode.
     * @return the CVVCode
     */
    public String getCVVCode() {
        return (String)getAttributeInternal(CVVCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CVVCode.
     * @param value value to set the CVVCode
     */
    public void setCVVCode(String value) {
        setAttributeInternal(CVVCODE, value);
    }

    /**
     * Gets the attribute value for DenomAmt, using the alias name DenomAmt.
     * @return the DenomAmt
     */
    public BigDecimal getDenomAmt() {
        return (BigDecimal)getAttributeInternal(DENOMAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for DenomAmt.
     * @param value value to set the DenomAmt
     */
    public void setDenomAmt(BigDecimal value) {
        setAttributeInternal(DENOMAMT, value);
    }

    /**
     * Gets the attribute value for ExpiryDate, using the alias name ExpiryDate.
     * @return the ExpiryDate
     */
    public Date getExpiryDate() {
        return (Date)getAttributeInternal(EXPIRYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpiryDate.
     * @param value value to set the ExpiryDate
     */
    public void setExpiryDate(Date value) {
        setAttributeInternal(EXPIRYDATE, value);
    }

    /**
     * Gets the attribute value for ValidationFlag, using the alias name ValidationFlag.
     * @return the ValidationFlag
     */
    public String getValidationFlag() {
        return (String)getAttributeInternal(VALIDATIONFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for ValidationFlag.
     * @param value value to set the ValidationFlag
     */
    public void setValidationFlag(String value) {
        setAttributeInternal(VALIDATIONFLAG, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return (String)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp)getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for Updatedby, using the alias name Updatedby.
     * @return the Updatedby
     */
    public String getUpdatedby() {
        return (String)getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Updatedby.
     * @param value value to set the Updatedby
     */
    public void setUpdatedby(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for Updateddate, using the alias name Updateddate.
     * @return the Updateddate
     */
    public Timestamp getUpdateddate() {
        return (Timestamp)getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Updateddate.
     * @param value value to set the Updateddate
     */
    public void setUpdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
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

    /**
     * @param uploadDetailSeq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal uploadDetailSeq) {
        return new Key(new Object[]{uploadDetailSeq});
    }


}