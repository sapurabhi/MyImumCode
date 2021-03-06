package com.imum.cpms.model.transactions.eo;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Timestamp;

import java.sql.Types;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 25 19:36:40 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class IssReturnHdrEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Issreturntrnseq {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getIssreturntrnseq();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setIssreturntrnseq((BigDecimal)value);
            }
        }
        ,
        FromLocation {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getFromLocation();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setFromLocation((Integer)value);
            }
        }
        ,
        ToLocation {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getToLocation();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setToLocation((Integer)value);
            }
        }
        ,
        TrnType {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getTrnType();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setTrnType((String)value);
            }
        }
        ,
        DispatchDate {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getDispatchDate();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setDispatchDate((Timestamp)value);
            }
        }
        ,
        CreatedBy {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        IssReturnDtlEO {
            public Object get(IssReturnHdrEOImpl obj) {
                return obj.getIssReturnDtlEO();
            }

            public void put(IssReturnHdrEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(IssReturnHdrEOImpl object);

        public abstract void put(IssReturnHdrEOImpl object, Object value);

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
    public static final int ISSRETURNTRNSEQ = AttributesEnum.Issreturntrnseq.index();
    public static final int FROMLOCATION = AttributesEnum.FromLocation.index();
    public static final int TOLOCATION = AttributesEnum.ToLocation.index();
    public static final int TRNTYPE = AttributesEnum.TrnType.index();
    public static final int DISPATCHDATE = AttributesEnum.DispatchDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int ISSRETURNDTLEO = AttributesEnum.IssReturnDtlEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public IssReturnHdrEOImpl() {
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
     * Gets the attribute value for FromLocation, using the alias name FromLocation.
     * @return the FromLocation
     */
    public Integer getFromLocation() {
        return (Integer)getAttributeInternal(FROMLOCATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for FromLocation.
     * @param value value to set the FromLocation
     */
    public void setFromLocation(Integer value) {
        setAttributeInternal(FROMLOCATION, value);
    }

    /**
     * Gets the attribute value for ToLocation, using the alias name ToLocation.
     * @return the ToLocation
     */
    public Integer getToLocation() {
        return (Integer)getAttributeInternal(TOLOCATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for ToLocation.
     * @param value value to set the ToLocation
     */
    public void setToLocation(Integer value) {
        setAttributeInternal(TOLOCATION, value);
    }

    /**
     * Gets the attribute value for TrnType, using the alias name TrnType.
     * @return the TrnType
     */
    public String getTrnType() {
        return (String)getAttributeInternal(TRNTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for TrnType.
     * @param value value to set the TrnType
     */
    public void setTrnType(String value) {
        setAttributeInternal(TRNTYPE, value);
    }

    /**
     * Gets the attribute value for DispatchDate, using the alias name DispatchDate.
     * @return the DispatchDate
     */
    public Timestamp getDispatchDate() {
        return (Timestamp)getAttributeInternal(DISPATCHDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DispatchDate.
     * @param value value to set the DispatchDate
     */
    public void setDispatchDate(Timestamp value) {
        setAttributeInternal(DISPATCHDATE, value);
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
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getIssReturnDtlEO() {
        return (RowIterator)getAttributeInternal(ISSRETURNDTLEO);
    }

    /**
     * @param issreturntrnseq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal issreturntrnseq) {
        return new Key(new Object[]{issreturntrnseq});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.transactions.eo.IssReturnHdrEO");
        }
        return mDefinitionObject;
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
                   stmt.setString(1, "ISS_RETURN_TRN_SEQ");            
                   stmt.registerOutParameter(2, Types.BIGINT);
                   stmt.execute();           
                   BigDecimal SeqNum = stmt.getBigDecimal(2);
                  setIssreturntrnseq(SeqNum);
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
