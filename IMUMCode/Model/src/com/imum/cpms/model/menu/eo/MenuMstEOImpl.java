package com.imum.cpms.model.menu.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 04 17:07:49 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MenuMstEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        MenuID {
            public Object get(MenuMstEOImpl obj) {
                return obj.getMenuID();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setMenuID((BigDecimal)value);
            }
        }
        ,
        ParentMenuID {
            public Object get(MenuMstEOImpl obj) {
                return obj.getParentMenuID();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setParentMenuID((BigDecimal)value);
            }
        }
        ,
        MenuDefinition {
            public Object get(MenuMstEOImpl obj) {
                return obj.getMenuDefinition();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setMenuDefinition((String)value);
            }
        }
        ,
        Displayseq {
            public Object get(MenuMstEOImpl obj) {
                return obj.getDisplayseq();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setDisplayseq((Integer)value);
            }
        }
        ,
        MenuURL {
            public Object get(MenuMstEOImpl obj) {
                return obj.getMenuURL();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setMenuURL((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(MenuMstEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(MenuMstEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(MenuMstEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updatedate {
            public Object get(MenuMstEOImpl obj) {
                return obj.getUpdatedate();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setUpdatedate((Timestamp)value);
            }
        }
        ,
        MenuMstEO {
            public Object get(MenuMstEOImpl obj) {
                return obj.getMenuMstEO();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ParentMenuIDMenuMstEO {
            public Object get(MenuMstEOImpl obj) {
                return obj.getParentMenuIDMenuMstEO();
            }

            public void put(MenuMstEOImpl obj, Object value) {
                obj.setParentMenuIDMenuMstEO((MenuMstEOImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(MenuMstEOImpl object);

        public abstract void put(MenuMstEOImpl object, Object value);

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


    public static final int MENUID = AttributesEnum.MenuID.index();
    public static final int PARENTMENUID = AttributesEnum.ParentMenuID.index();
    public static final int MENUDEFINITION = AttributesEnum.MenuDefinition.index();
    public static final int DISPLAYSEQ = AttributesEnum.Displayseq.index();
    public static final int MENUURL = AttributesEnum.MenuURL.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDATE = AttributesEnum.Updatedate.index();
    public static final int MENUMSTEO = AttributesEnum.MenuMstEO.index();
    public static final int PARENTMENUIDMENUMSTEO = AttributesEnum.ParentMenuIDMenuMstEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MenuMstEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.menu.eo.MenuMstEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for MenuID, using the alias name MenuID.
     * @return the MenuID
     */
    public BigDecimal getMenuID() {
        return (BigDecimal)getAttributeInternal(MENUID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MenuID.
     * @param value value to set the MenuID
     */
    public void setMenuID(BigDecimal value) {
        setAttributeInternal(MENUID, value);
    }

    /**
     * Gets the attribute value for ParentMenuID, using the alias name ParentMenuID.
     * @return the ParentMenuID
     */
    public BigDecimal getParentMenuID() {
        return (BigDecimal)getAttributeInternal(PARENTMENUID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ParentMenuID.
     * @param value value to set the ParentMenuID
     */
    public void setParentMenuID(BigDecimal value) {
        setAttributeInternal(PARENTMENUID, value);
    }

    /**
     * Gets the attribute value for MenuDefinition, using the alias name MenuDefinition.
     * @return the MenuDefinition
     */
    public String getMenuDefinition() {
        return (String)getAttributeInternal(MENUDEFINITION);
    }

    /**
     * Sets <code>value</code> as the attribute value for MenuDefinition.
     * @param value value to set the MenuDefinition
     */
    public void setMenuDefinition(String value) {
        setAttributeInternal(MENUDEFINITION, value);
    }

    /**
     * Gets the attribute value for Displayseq, using the alias name Displayseq.
     * @return the Displayseq
     */
    public Integer getDisplayseq() {
        return (Integer)getAttributeInternal(DISPLAYSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Displayseq.
     * @param value value to set the Displayseq
     */
    public void setDisplayseq(Integer value) {
        setAttributeInternal(DISPLAYSEQ, value);
    }

    /**
     * Gets the attribute value for MenuURL, using the alias name MenuURL.
     * @return the MenuURL
     */
    public String getMenuURL() {
        return (String)getAttributeInternal(MENUURL);
    }

    /**
     * Sets <code>value</code> as the attribute value for MenuURL.
     * @param value value to set the MenuURL
     */
    public void setMenuURL(String value) {
        setAttributeInternal(MENUURL, value);
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
    public RowIterator getMenuMstEO() {
        return (RowIterator)getAttributeInternal(MENUMSTEO);
    }

    /**
     * @return the associated entity MenuMstEOImpl.
     */
    public MenuMstEOImpl getParentMenuIDMenuMstEO() {
        return (MenuMstEOImpl)getAttributeInternal(PARENTMENUIDMENUMSTEO);
    }

    /**
     * Sets <code>value</code> as the associated entity MenuMstEOImpl.
     */
    public void setParentMenuIDMenuMstEO(MenuMstEOImpl value) {
        setAttributeInternal(PARENTMENUIDMENUMSTEO, value);
    }


    /**
     * @param menuID key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal menuID) {
        return new Key(new Object[]{menuID});
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
