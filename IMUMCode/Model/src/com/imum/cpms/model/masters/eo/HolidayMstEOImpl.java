package com.imum.cpms.model.masters.eo;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.Time;
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
// ---    Thu Sep 04 19:55:41 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HolidayMstEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        HolidayId {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getHolidayId();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setHolidayId((Integer)value);
            }
        }
        ,
        GroupId {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getGroupId();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setGroupId((Integer)value);
            }
        }
        ,
        HolidayYear {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getHolidayYear();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setHolidayYear((String)value);
            }
        }
        ,
        HolidayDate {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getHolidayDate();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setHolidayDate((Date)value);
            }
        }
        ,
        HolidayDesc {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getHolidayDesc();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setHolidayDesc((String)value);
            }
        }
        ,
        HolidayType {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getHolidayType();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setHolidayType((String)value);
            }
        }
        ,
        RequestedBy {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getRequestedBy();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setRequestedBy((String)value);
            }
        }
        ,
        RequestedDt {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getRequestedDt();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setRequestedDt((Timestamp)value);
            }
        }
        ,
        DeclaredBy {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getDeclaredBy();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setDeclaredBy((String)value);
            }
        }
        ,
        DeclaredDt {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getDeclaredDt();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setDeclaredDt((Timestamp)value);
            }
        }
        ,
        Remarks {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getRemarks();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        ActiveFlag {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getActiveFlag();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setActiveFlag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updatedate {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getUpdatedate();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setUpdatedate((Timestamp)value);
            }
        }
        ,
        OperationHrstart {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getOperationHrstart();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setOperationHrstart((Time)value);
            }
        }
        ,
        OperationHrEnd {
            public Object get(HolidayMstEOImpl obj) {
                return obj.getOperationHrEnd();
            }

            public void put(HolidayMstEOImpl obj, Object value) {
                obj.setOperationHrEnd((Time)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(HolidayMstEOImpl object);

        public abstract void put(HolidayMstEOImpl object, Object value);

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


    public static final int HOLIDAYID = AttributesEnum.HolidayId.index();
    public static final int GROUPID = AttributesEnum.GroupId.index();
    public static final int HOLIDAYYEAR = AttributesEnum.HolidayYear.index();
    public static final int HOLIDAYDATE = AttributesEnum.HolidayDate.index();
    public static final int HOLIDAYDESC = AttributesEnum.HolidayDesc.index();
    public static final int HOLIDAYTYPE = AttributesEnum.HolidayType.index();
    public static final int REQUESTEDBY = AttributesEnum.RequestedBy.index();
    public static final int REQUESTEDDT = AttributesEnum.RequestedDt.index();
    public static final int DECLAREDBY = AttributesEnum.DeclaredBy.index();
    public static final int DECLAREDDT = AttributesEnum.DeclaredDt.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int ACTIVEFLAG = AttributesEnum.ActiveFlag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDATE = AttributesEnum.Updatedate.index();
    public static final int OPERATIONHRSTART = AttributesEnum.OperationHrstart.index();
    public static final int OPERATIONHREND = AttributesEnum.OperationHrEnd.index();

    /**
     * This is the default constructor (do not remove).
     */
    public HolidayMstEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.masters.eo.HolidayMstEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for HolidayId, using the alias name HolidayId.
     * @return the HolidayId
     */
    public Integer getHolidayId() {
        return (Integer)getAttributeInternal(HOLIDAYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for HolidayId.
     * @param value value to set the HolidayId
     */
    public void setHolidayId(Integer value) {
        setAttributeInternal(HOLIDAYID, value);
    }

    /**
     * Gets the attribute value for GroupId, using the alias name GroupId.
     * @return the GroupId
     */
    public Integer getGroupId() {
        return (Integer)getAttributeInternal(GROUPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for GroupId.
     * @param value value to set the GroupId
     */
    public void setGroupId(Integer value) {
        setAttributeInternal(GROUPID, value);
    }

    /**
     * Gets the attribute value for HolidayYear, using the alias name HolidayYear.
     * @return the HolidayYear
     */
    public String getHolidayYear() {
        return (String)getAttributeInternal(HOLIDAYYEAR);
    }

    /**
     * Sets <code>value</code> as the attribute value for HolidayYear.
     * @param value value to set the HolidayYear
     */
    public void setHolidayYear(String value) {
        setAttributeInternal(HOLIDAYYEAR, value);
    }

    /**
     * Gets the attribute value for HolidayDate, using the alias name HolidayDate.
     * @return the HolidayDate
     */
    public Date getHolidayDate() {
        return (Date)getAttributeInternal(HOLIDAYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for HolidayDate.
     * @param value value to set the HolidayDate
     */
    public void setHolidayDate(Date value) {
        setAttributeInternal(HOLIDAYDATE, value);
    }

    /**
     * Gets the attribute value for HolidayDesc, using the alias name HolidayDesc.
     * @return the HolidayDesc
     */
    public String getHolidayDesc() {
        return (String)getAttributeInternal(HOLIDAYDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for HolidayDesc.
     * @param value value to set the HolidayDesc
     */
    public void setHolidayDesc(String value) {
        setAttributeInternal(HOLIDAYDESC, value);
    }

    /**
     * Gets the attribute value for HolidayType, using the alias name HolidayType.
     * @return the HolidayType
     */
    public String getHolidayType() {
        return (String)getAttributeInternal(HOLIDAYTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for HolidayType.
     * @param value value to set the HolidayType
     */
    public void setHolidayType(String value) {
        setAttributeInternal(HOLIDAYTYPE, value);
    }

    /**
     * Gets the attribute value for RequestedBy, using the alias name RequestedBy.
     * @return the RequestedBy
     */
    public String getRequestedBy() {
        return (String)getAttributeInternal(REQUESTEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for RequestedBy.
     * @param value value to set the RequestedBy
     */
    public void setRequestedBy(String value) {
        setAttributeInternal(REQUESTEDBY, value);
    }

    /**
     * Gets the attribute value for RequestedDt, using the alias name RequestedDt.
     * @return the RequestedDt
     */
    public Timestamp getRequestedDt() {
        return (Timestamp)getAttributeInternal(REQUESTEDDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for RequestedDt.
     * @param value value to set the RequestedDt
     */
    public void setRequestedDt(Timestamp value) {
        setAttributeInternal(REQUESTEDDT, value);
    }

    /**
     * Gets the attribute value for DeclaredBy, using the alias name DeclaredBy.
     * @return the DeclaredBy
     */
    public String getDeclaredBy() {
        return (String)getAttributeInternal(DECLAREDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for DeclaredBy.
     * @param value value to set the DeclaredBy
     */
    public void setDeclaredBy(String value) {
        setAttributeInternal(DECLAREDBY, value);
    }

    /**
     * Gets the attribute value for DeclaredDt, using the alias name DeclaredDt.
     * @return the DeclaredDt
     */
    public Timestamp getDeclaredDt() {
        return (Timestamp)getAttributeInternal(DECLAREDDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for DeclaredDt.
     * @param value value to set the DeclaredDt
     */
    public void setDeclaredDt(Timestamp value) {
        setAttributeInternal(DECLAREDDT, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the Remarks
     */
    public String getRemarks() {
        return (String)getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for ActiveFlag, using the alias name ActiveFlag.
     * @return the ActiveFlag
     */
    public String getActiveFlag() {
        return (String)getAttributeInternal(ACTIVEFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for ActiveFlag.
     * @param value value to set the ActiveFlag
     */
    public void setActiveFlag(String value) {
        setAttributeInternal(ACTIVEFLAG, value);
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
     * Gets the attribute value for Updatedate, using the alias name Updatedate.
     * @return the Updatedate
     */
    public Timestamp getUpdatedate() {
        return (Timestamp)getAttributeInternal(UPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Updatedate.
     * @param value value to set the Updatedate
     */
    public void setUpdatedate(Timestamp value) {
        setAttributeInternal(UPDATEDATE, value);
    }

    /**
     * Gets the attribute value for OperationHrstart, using the alias name OperationHrstart.
     * @return the OperationHrstart
     */
    public Time getOperationHrstart() {
        return (Time)getAttributeInternal(OPERATIONHRSTART);
    }

    /**
     * Sets <code>value</code> as the attribute value for OperationHrstart.
     * @param value value to set the OperationHrstart
     */
    public void setOperationHrstart(Time value) {
        setAttributeInternal(OPERATIONHRSTART, value);
    }

    /**
     * Gets the attribute value for OperationHrEnd, using the alias name OperationHrEnd.
     * @return the OperationHrEnd
     */
    public Time getOperationHrEnd() {
        return (Time)getAttributeInternal(OPERATIONHREND);
    }

    /**
     * Sets <code>value</code> as the attribute value for OperationHrEnd.
     * @param value value to set the OperationHrEnd
     */
    public void setOperationHrEnd(Time value) {
        setAttributeInternal(OPERATIONHREND, value);
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
     * @param holidayId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer holidayId) {
        return new Key(new Object[]{holidayId});
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
                stmt.setString(1, "GEN_Holiday_Id_SEQ");            
                stmt.registerOutParameter(2, Types.INTEGER);
                stmt.execute();           
                Integer SeqNum = stmt.getInt(2);  
                System.out.println("Holiday Id in EO is : "+SeqNum);
                setHolidayId(SeqNum);
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
