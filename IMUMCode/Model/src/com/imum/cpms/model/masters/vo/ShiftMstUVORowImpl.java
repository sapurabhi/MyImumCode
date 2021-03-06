package com.imum.cpms.model.masters.vo;

import com.imum.cpms.model.masters.eo.ShiftMstEOImpl;

import java.math.BigDecimal;

import java.sql.Time;
import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Nov 24 16:24:29 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ShiftMstUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ShiftId {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getShiftId();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setShiftId((Integer)value);
            }
        }
        ,
        ShiftDesc {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getShiftDesc();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setShiftDesc((String)value);
            }
        }
        ,
        ShiftFr {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getShiftFr();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setShiftFr((BigDecimal)value);
            }
        }
        ,
        ShiftTo {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getShiftTo();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setShiftTo((BigDecimal)value);
            }
        }
        ,
        ActiveFlag {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getActiveFlag();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setActiveFlag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        UpdatedBy {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getUpdatedBy();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setUpdatedBy((String)value);
            }
        }
        ,
        UpdatedDate {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getUpdatedDate();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setUpdatedDate((Timestamp)value);
            }
        }
        ,
        rowStatus {
            public Object get(ShiftMstUVORowImpl obj) {
                return obj.getrowStatus();
            }

            public void put(ShiftMstUVORowImpl obj, Object value) {
                obj.setrowStatus((Integer)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(ShiftMstUVORowImpl object);

        public abstract void put(ShiftMstUVORowImpl object, Object value);

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


    public static final int SHIFTID = AttributesEnum.ShiftId.index();
    public static final int SHIFTDESC = AttributesEnum.ShiftDesc.index();
    public static final int SHIFTFR = AttributesEnum.ShiftFr.index();
    public static final int SHIFTTO = AttributesEnum.ShiftTo.index();
    public static final int ACTIVEFLAG = AttributesEnum.ActiveFlag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int ROWSTATUS = AttributesEnum.rowStatus.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ShiftMstUVORowImpl() {
    }

    /**
     * Gets ShiftMstEO entity object.
     * @return the ShiftMstEO
     */
    public ShiftMstEOImpl getShiftMstEO() {
        return (ShiftMstEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Shift_Id using the alias name ShiftId.
     * @return the Shift_Id
     */
    public Integer getShiftId() {
        return (Integer) getAttributeInternal(SHIFTID);
    }

    /**
     * Sets <code>value</code> as attribute value for Shift_Id using the alias name ShiftId.
     * @param value value to set the Shift_Id
     */
    public void setShiftId(Integer value) {
        setAttributeInternal(SHIFTID, value);
    }

    /**
     * Gets the attribute value for Shift_Desc using the alias name ShiftDesc.
     * @return the Shift_Desc
     */
    public String getShiftDesc() {
        return (String) getAttributeInternal(SHIFTDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for Shift_Desc using the alias name ShiftDesc.
     * @param value value to set the Shift_Desc
     */
    public void setShiftDesc(String value) {
        setAttributeInternal(SHIFTDESC, value);
    }

    /**
     * Gets the attribute value for Shift_Fr using the alias name ShiftFr.
     * @return the Shift_Fr
     */
    public BigDecimal getShiftFr() {
        return (BigDecimal) getAttributeInternal(SHIFTFR);
    }

    /**
     * Sets <code>value</code> as attribute value for Shift_Fr using the alias name ShiftFr.
     * @param value value to set the Shift_Fr
     */
    public void setShiftFr(BigDecimal value) {
        setAttributeInternal(SHIFTFR, value);
    }

    /**
     * Gets the attribute value for Shift_To using the alias name ShiftTo.
     * @return the Shift_To
     */
    public BigDecimal getShiftTo() {
        return (BigDecimal) getAttributeInternal(SHIFTTO);
    }

    /**
     * Sets <code>value</code> as attribute value for Shift_To using the alias name ShiftTo.
     * @param value value to set the Shift_To
     */
    public void setShiftTo(BigDecimal value) {
        setAttributeInternal(SHIFTTO, value);
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
     * Gets the attribute value for the calculated attribute rowStatus.
     * @return the rowStatus
     */
    public Integer getrowStatus() {
        byte entityState = this.getEntity(0).getEntityState();
                return new Integer(entityState);
//        return (Integer) getAttributeInternal(ROWSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute rowStatus.
     * @param value value to set the  rowStatus
     */
    public void setrowStatus(Integer value) {
        setAttributeInternal(ROWSTATUS, value);
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
