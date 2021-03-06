package com.imum.cpms.model.masters.vo;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 17 15:53:23 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RevenueTypeUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        RevTypeCode {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getRevTypeCode();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setRevTypeCode((String)value);
            }
        }
        ,
        RevGrpCode {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getRevGrpCode();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setRevGrpCode((String)value);
            }
        }
        ,
        RevTypeDesc {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getRevTypeDesc();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setRevTypeDesc((String)value);
            }
        }
        ,
        ActiveFlag {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getActiveFlag();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setActiveFlag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        UpdatedBy {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getUpdatedBy();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setUpdatedBy((String)value);
            }
        }
        ,
        UpdatedDate {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getUpdatedDate();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setUpdatedDate((Timestamp)value);
            }
        }
        ,
        clickedonedit {
            public Object get(RevenueTypeUVORowImpl obj) {
                return obj.getclickedonedit();
            }

            public void put(RevenueTypeUVORowImpl obj, Object value) {
                obj.setclickedonedit((Integer)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(RevenueTypeUVORowImpl object);

        public abstract void put(RevenueTypeUVORowImpl object, Object value);

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


    public static final int REVTYPECODE = AttributesEnum.RevTypeCode.index();
    public static final int REVGRPCODE = AttributesEnum.RevGrpCode.index();
    public static final int REVTYPEDESC = AttributesEnum.RevTypeDesc.index();
    public static final int ACTIVEFLAG = AttributesEnum.ActiveFlag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int CLICKEDONEDIT = AttributesEnum.clickedonedit.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RevenueTypeUVORowImpl() {
    }

    /**
     * Gets RevenueTypeEO entity object.
     * @return the RevenueTypeEO
     */
    public EntityImpl getRevenueTypeEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Rev_Type_Code using the alias name RevTypeCode.
     * @return the Rev_Type_Code
     */
    public String getRevTypeCode() {
        return (String) getAttributeInternal(REVTYPECODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Rev_Type_Code using the alias name RevTypeCode.
     * @param value value to set the Rev_Type_Code
     */
    public void setRevTypeCode(String value) {
        setAttributeInternal(REVTYPECODE, value);
    }

    /**
     * Gets the attribute value for Rev_Grp_Code using the alias name RevGrpCode.
     * @return the Rev_Grp_Code
     */
    public String getRevGrpCode() {
        return (String) getAttributeInternal(REVGRPCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Rev_Grp_Code using the alias name RevGrpCode.
     * @param value value to set the Rev_Grp_Code
     */
    public void setRevGrpCode(String value) {
        setAttributeInternal(REVGRPCODE, value);
    }

    /**
     * Gets the attribute value for Rev_Type_Desc using the alias name RevTypeDesc.
     * @return the Rev_Type_Desc
     */
    public String getRevTypeDesc() {
        return (String) getAttributeInternal(REVTYPEDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for Rev_Type_Desc using the alias name RevTypeDesc.
     * @param value value to set the Rev_Type_Desc
     */
    public void setRevTypeDesc(String value) {
        setAttributeInternal(REVTYPEDESC, value);
    }


    /**
     * Gets the attribute value for Active_Flag using the alias name ActiveFlag.
     * @return the Active_Flag
     */
    public String getActiveFlag() {
        return (String) getAttributeInternal(ACTIVEFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Active_Flag using the alias name ActiveFlag.
     * @param value value to set the Active_Flag
     */
    public void setActiveFlag(String value) {
        setAttributeInternal(ACTIVEFLAG, value);
    }

    /**
     * Gets the attribute value for Created_By using the alias name CreatedBy.
     * @return the Created_By
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for Created_By using the alias name CreatedBy.
     * @param value value to set the Created_By
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for Created_Date using the alias name CreatedDate.
     * @return the Created_Date
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Created_Date using the alias name CreatedDate.
     * @param value value to set the Created_Date
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for Updated_By using the alias name UpdatedBy.
     * @return the Updated_By
     */
    public String getUpdatedBy() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for Updated_By using the alias name UpdatedBy.
     * @param value value to set the Updated_By
     */
    public void setUpdatedBy(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for Updated_Date using the alias name UpdatedDate.
     * @return the Updated_Date
     */
    public Timestamp getUpdatedDate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Updated_Date using the alias name UpdatedDate.
     * @param value value to set the Updated_Date
     */
    public void setUpdatedDate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute clickedonedit.
     * @return the clickedonedit
     */
    public Integer getclickedonedit() {
        byte entityState = this.getEntity(0).getEntityState();
                return new Integer(entityState);
        //return (Integer) getAttributeInternal(CLICKEDONEDIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute clickedonedit.
     * @param value value to set the  clickedonedit
     */
    public void setclickedonedit(Integer value) {
        setAttributeInternal(CLICKEDONEDIT, value);
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
