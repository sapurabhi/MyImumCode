package com.imum.cpms.model.masters.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 08 19:14:25 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UserRoleMapEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        UserRoleMapID {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getUserRoleMapID();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        userid {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getuserid();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setuserid((String)value);
            }
        }
        ,
        RoleID {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getRoleID();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setRoleID((BigDecimal)value);
            }
        }
        ,
        activeflag {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getactiveflag();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setactiveflag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(UserRoleMapEOImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(UserRoleMapEOImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(UserRoleMapEOImpl object);

        public abstract void put(UserRoleMapEOImpl object, Object value);

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


    public static final int USERROLEMAPID = AttributesEnum.UserRoleMapID.index();
    public static final int USERID = AttributesEnum.userid.index();
    public static final int ROLEID = AttributesEnum.RoleID.index();
    public static final int ACTIVEFLAG = AttributesEnum.activeflag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public UserRoleMapEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.masters.eo.UserRoleMapEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for UserRoleMapID, using the alias name UserRoleMapID.
     * @return the UserRoleMapID
     */
    public BigDecimal getUserRoleMapID() {
        return (BigDecimal)getAttributeInternal(USERROLEMAPID);
    }

    /**
     * Gets the attribute value for userid, using the alias name userid.
     * @return the userid
     */
    public String getuserid() {
        return (String)getAttributeInternal(USERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for userid.
     * @param value value to set the userid
     */
    public void setuserid(String value) {
        setAttributeInternal(USERID, value);
    }

    /**
     * Gets the attribute value for RoleID, using the alias name RoleID.
     * @return the RoleID
     */
    public BigDecimal getRoleID() {
        return (BigDecimal)getAttributeInternal(ROLEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RoleID.
     * @param value value to set the RoleID
     */
    public void setRoleID(BigDecimal value) {
        setAttributeInternal(ROLEID, value);
    }

    /**
     * Gets the attribute value for activeflag, using the alias name activeflag.
     * @return the activeflag
     */
    public String getactiveflag() {
        return (String)getAttributeInternal(ACTIVEFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for activeflag.
     * @param value value to set the activeflag
     */
    public void setactiveflag(String value) {
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
     * @param userRoleMapID key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal userRoleMapID) {
        return new Key(new Object[]{userRoleMapID});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
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
