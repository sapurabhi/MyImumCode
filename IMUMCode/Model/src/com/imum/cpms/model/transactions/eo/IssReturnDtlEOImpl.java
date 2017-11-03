package com.imum.cpms.model.transactions.eo;

import java.math.BigDecimal;

import java.sql.CallableStatement;
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
// ---    Thu Jul 24 11:31:26 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class IssReturnDtlEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Issreturntrndetailseq {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getIssreturntrndetailseq();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setIssreturntrndetailseq((BigDecimal)value);
            }
        }
        ,
        Issreturntrnseq {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getIssreturntrnseq();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setIssreturntrnseq((BigDecimal)value);
            }
        }
        ,
        FromCardnum {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getFromCardnum();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setFromCardnum((String)value);
            }
        }
        ,
        Tocardnum {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getTocardnum();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setTocardnum((String)value);
            }
        }
        ,
        CardType {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getCardType();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setCardType((String)value);
            }
        }
        ,
        CardDenomAmt {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getCardDenomAmt();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setCardDenomAmt((BigDecimal)value);
            }
        }
        ,
        RetrunReasons {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getRetrunReasons();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setRetrunReasons((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        IssReturnHdrEO {
            public Object get(IssReturnDtlEOImpl obj) {
                return obj.getIssReturnHdrEO();
            }

            public void put(IssReturnDtlEOImpl obj, Object value) {
                obj.setIssReturnHdrEO((IssReturnHdrEOImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(IssReturnDtlEOImpl object);

        public abstract void put(IssReturnDtlEOImpl object, Object value);

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


    public static final int ISSRETURNTRNDETAILSEQ = AttributesEnum.Issreturntrndetailseq.index();
    public static final int ISSRETURNTRNSEQ = AttributesEnum.Issreturntrnseq.index();
    public static final int FROMCARDNUM = AttributesEnum.FromCardnum.index();
    public static final int TOCARDNUM = AttributesEnum.Tocardnum.index();
    public static final int CARDTYPE = AttributesEnum.CardType.index();
    public static final int CARDDENOMAMT = AttributesEnum.CardDenomAmt.index();
    public static final int RETRUNREASONS = AttributesEnum.RetrunReasons.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int ISSRETURNHDREO = AttributesEnum.IssReturnHdrEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public IssReturnDtlEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.transactions.eo.IssReturnDtlEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for Issreturntrndetailseq, using the alias name Issreturntrndetailseq.
     * @return the Issreturntrndetailseq
     */
    public BigDecimal getIssreturntrndetailseq() {
        return (BigDecimal)getAttributeInternal(ISSRETURNTRNDETAILSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Issreturntrndetailseq.
     * @param value value to set the Issreturntrndetailseq
     */
    public void setIssreturntrndetailseq(BigDecimal value) {
        setAttributeInternal(ISSRETURNTRNDETAILSEQ, value);
    }

    /**
     * Gets the attribute value for Issreturntrnseq, using the alias name Issreturntrnseq.
     * @return the Issreturntrnseq
     */
    public BigDecimal getIssreturntrnseq() {
        return (BigDecimal)getAttributeInternal(ISSRETURNTRNSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Issreturntrnseq.
     * @param value value to set the Issreturntrnseq
     */
    public void setIssreturntrnseq(BigDecimal value) {
        setAttributeInternal(ISSRETURNTRNSEQ, value);
    }

    /**
     * Gets the attribute value for FromCardnum, using the alias name FromCardnum.
     * @return the FromCardnum
     */
    public String getFromCardnum() {
        return (String)getAttributeInternal(FROMCARDNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for FromCardnum.
     * @param value value to set the FromCardnum
     */
    public void setFromCardnum(String value) {
        setAttributeInternal(FROMCARDNUM, value);
    }

    /**
     * Gets the attribute value for Tocardnum, using the alias name Tocardnum.
     * @return the Tocardnum
     */
    public String getTocardnum() {
        return (String)getAttributeInternal(TOCARDNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Tocardnum.
     * @param value value to set the Tocardnum
     */
    public void setTocardnum(String value) {
        setAttributeInternal(TOCARDNUM, value);
    }

    /**
     * Gets the attribute value for CardType, using the alias name CardType.
     * @return the CardType
     */
    public String getCardType() {
        return (String)getAttributeInternal(CARDTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardType.
     * @param value value to set the CardType
     */
    public void setCardType(String value) {
        setAttributeInternal(CARDTYPE, value);
    }

    /**
     * Gets the attribute value for CardDenomAmt, using the alias name CardDenomAmt.
     * @return the CardDenomAmt
     */
    public BigDecimal getCardDenomAmt() {
        return (BigDecimal)getAttributeInternal(CARDDENOMAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardDenomAmt.
     * @param value value to set the CardDenomAmt
     */
    public void setCardDenomAmt(BigDecimal value) {
        setAttributeInternal(CARDDENOMAMT, value);
    }

    /**
     * Gets the attribute value for RetrunReasons, using the alias name RetrunReasons.
     * @return the RetrunReasons
     */
    public String getRetrunReasons() {
        return (String)getAttributeInternal(RETRUNREASONS);
    }

    /**
     * Sets <code>value</code> as the attribute value for RetrunReasons.
     * @param value value to set the RetrunReasons
     */
    public void setRetrunReasons(String value) {
        setAttributeInternal(RETRUNREASONS, value);
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
     * @return the associated entity IssReturnHdrEOImpl.
     */
    public IssReturnHdrEOImpl getIssReturnHdrEO() {
        return (IssReturnHdrEOImpl)getAttributeInternal(ISSRETURNHDREO);
    }

    /**
     * Sets <code>value</code> as the associated entity IssReturnHdrEOImpl.
     */
    public void setIssReturnHdrEO(IssReturnHdrEOImpl value) {
        setAttributeInternal(ISSRETURNHDREO, value);
    }


    /**
     * @param issreturntrndetailseq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal issreturntrndetailseq) {
        return new Key(new Object[]{issreturntrndetailseq});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        CallableStatement stmt = null;
        try {
            stmt = getDBTransaction().createCallableStatement("{call  sequence_mst_trigger(?,?) }", 0);
            stmt.setString(1, "ISS_RETURN_TRN_DETAIL_SEQ");            
            stmt.registerOutParameter(2, Types.BIGINT);
            stmt.execute();           
            BigDecimal SeqNum = stmt.getBigDecimal(2);
           setIssreturntrndetailseq(SeqNum);
        }  catch (Exception e) {
                        e.printStackTrace();
               }
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
}
