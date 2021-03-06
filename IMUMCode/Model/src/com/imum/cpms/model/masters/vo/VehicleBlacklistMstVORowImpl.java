package com.imum.cpms.model.masters.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Mar 21 13:34:44 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VehicleBlacklistMstVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Activeflag {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getActiveflag();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setActiveflag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        PLATECTGID {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getPLATECTGID();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setPLATECTGID((Integer)value);
            }
        }
        ,
        PLATENUMBER {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getPLATENUMBER();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setPLATENUMBER((String)value);
            }
        }
        ,
        PLATETYPEID {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getPLATETYPEID();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setPLATETYPEID((Integer)value);
            }
        }
        ,
        PlateCountryID {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getPlateCountryID();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setPlateCountryID((Integer)value);
            }
        }
        ,
        Plateid {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getPlateid();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setPlateid((BigDecimal)value);
            }
        }
        ,
        Updatedby {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        VEHCOLOURID {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVEHCOLOURID();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setVEHCOLOURID((Integer)value);
            }
        }
        ,
        VEHMAKEID {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVEHMAKEID();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setVEHMAKEID((Integer)value);
            }
        }
        ,
        VEHMODELID {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVEHMODELID();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setVEHMODELID((Integer)value);
            }
        }
        ,
        Blacklistseq {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getBlacklistseq();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setBlacklistseq((BigDecimal)value);
            }
        }
        ,
        updateddate {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getupdateddate();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setupdateddate((Timestamp)value);
            }
        }
        ,
        ActiveDateFrom {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getActiveDateFrom();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setActiveDateFrom((Timestamp)value);
            }
        }
        ,
        ActiveDateTo {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getActiveDateTo();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setActiveDateTo((Timestamp)value);
            }
        }
        ,
        VehiclePlateCountryLVO1 {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVehiclePlateCountryLVO1();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehiclePlateCategoryLVO1 {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVehiclePlateCategoryLVO1();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehiclePlateTypeLVO1 {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVehiclePlateTypeLVO1();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehicleMakeLOVVO1 {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVehicleMakeLOVVO1();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehicleModelLOVVO1 {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVehicleModelLOVVO1();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        VehicleColourLOVVO1 {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getVehicleColourLOVVO1();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        YesNoLovVO1 {
            public Object get(VehicleBlacklistMstVORowImpl obj) {
                return obj.getYesNoLovVO1();
            }

            public void put(VehicleBlacklistMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(VehicleBlacklistMstVORowImpl object);

        public abstract void put(VehicleBlacklistMstVORowImpl object,
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


    public static final int ACTIVEFLAG = AttributesEnum.Activeflag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int PLATECTGID = AttributesEnum.PLATECTGID.index();
    public static final int PLATENUMBER = AttributesEnum.PLATENUMBER.index();
    public static final int PLATETYPEID = AttributesEnum.PLATETYPEID.index();
    public static final int PLATECOUNTRYID = AttributesEnum.PlateCountryID.index();
    public static final int PLATEID = AttributesEnum.Plateid.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int VEHCOLOURID = AttributesEnum.VEHCOLOURID.index();
    public static final int VEHMAKEID = AttributesEnum.VEHMAKEID.index();
    public static final int VEHMODELID = AttributesEnum.VEHMODELID.index();
    public static final int BLACKLISTSEQ = AttributesEnum.Blacklistseq.index();
    public static final int UPDATEDDATE = AttributesEnum.updateddate.index();
    public static final int ACTIVEDATEFROM = AttributesEnum.ActiveDateFrom.index();
    public static final int ACTIVEDATETO = AttributesEnum.ActiveDateTo.index();
    public static final int VEHICLEPLATECOUNTRYLVO1 = AttributesEnum.VehiclePlateCountryLVO1.index();
    public static final int VEHICLEPLATECATEGORYLVO1 = AttributesEnum.VehiclePlateCategoryLVO1.index();
    public static final int VEHICLEPLATETYPELVO1 = AttributesEnum.VehiclePlateTypeLVO1.index();
    public static final int VEHICLEMAKELOVVO1 = AttributesEnum.VehicleMakeLOVVO1.index();
    public static final int VEHICLEMODELLOVVO1 = AttributesEnum.VehicleModelLOVVO1.index();
    public static final int VEHICLECOLOURLOVVO1 = AttributesEnum.VehicleColourLOVVO1.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VehicleBlacklistMstVORowImpl() {
    }

    /**
     * Gets VehicleBlacklistMstEO entity object.
     * @return the VehicleBlacklistMstEO
     */
    public EntityImpl getVehicleBlacklistMstEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Active_flag using the alias name Activeflag.
     * @return the Active_flag
     */
    public String getActiveflag() {
        return (String) getAttributeInternal(ACTIVEFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Active_flag using the alias name Activeflag.
     * @param value value to set the Active_flag
     */
    public void setActiveflag(String value) {
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
     * Gets the attribute value for PLATE_CTG_ID using the alias name PLATECTGID.
     * @return the PLATE_CTG_ID
     */
    public Integer getPLATECTGID() {
        return (Integer) getAttributeInternal(PLATECTGID);
    }

    /**
     * Sets <code>value</code> as attribute value for PLATE_CTG_ID using the alias name PLATECTGID.
     * @param value value to set the PLATE_CTG_ID
     */
    public void setPLATECTGID(Integer value) {
        setAttributeInternal(PLATECTGID, value);
    }

    /**
     * Gets the attribute value for PLATE_NUMBER using the alias name PLATENUMBER.
     * @return the PLATE_NUMBER
     */
    public String getPLATENUMBER() {
        return (String) getAttributeInternal(PLATENUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for PLATE_NUMBER using the alias name PLATENUMBER.
     * @param value value to set the PLATE_NUMBER
     */
    public void setPLATENUMBER(String value) {
        setAttributeInternal(PLATENUMBER, value);
    }

    /**
     * Gets the attribute value for PLATE_TYPE_ID using the alias name PLATETYPEID.
     * @return the PLATE_TYPE_ID
     */
    public Integer getPLATETYPEID() {
        return (Integer) getAttributeInternal(PLATETYPEID);
    }

    /**
     * Sets <code>value</code> as attribute value for PLATE_TYPE_ID using the alias name PLATETYPEID.
     * @param value value to set the PLATE_TYPE_ID
     */
    public void setPLATETYPEID(Integer value) {
        setAttributeInternal(PLATETYPEID, value);
    }

    /**
     * Gets the attribute value for Plate_Country_ID using the alias name PlateCountryID.
     * @return the Plate_Country_ID
     */
    public Integer getPlateCountryID() {
        return (Integer) getAttributeInternal(PLATECOUNTRYID);
    }

    /**
     * Sets <code>value</code> as attribute value for Plate_Country_ID using the alias name PlateCountryID.
     * @param value value to set the Plate_Country_ID
     */
    public void setPlateCountryID(Integer value) {
        setAttributeInternal(PLATECOUNTRYID, value);
    }

    /**
     * Gets the attribute value for Plate_id using the alias name Plateid.
     * @return the Plate_id
     */
    public BigDecimal getPlateid() {
        return (BigDecimal) getAttributeInternal(PLATEID);
    }

    /**
     * Sets <code>value</code> as attribute value for Plate_id using the alias name Plateid.
     * @param value value to set the Plate_id
     */
    public void setPlateid(BigDecimal value) {
        setAttributeInternal(PLATEID, value);
    }

    /**
     * Gets the attribute value for Updated_by using the alias name Updatedby.
     * @return the Updated_by
     */
    public String getUpdatedby() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for Updated_by using the alias name Updatedby.
     * @param value value to set the Updated_by
     */
    public void setUpdatedby(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for VEH_COLOUR_ID using the alias name VEHCOLOURID.
     * @return the VEH_COLOUR_ID
     */
    public Integer getVEHCOLOURID() {
        return (Integer) getAttributeInternal(VEHCOLOURID);
    }

    /**
     * Sets <code>value</code> as attribute value for VEH_COLOUR_ID using the alias name VEHCOLOURID.
     * @param value value to set the VEH_COLOUR_ID
     */
    public void setVEHCOLOURID(Integer value) {
        setAttributeInternal(VEHCOLOURID, value);
    }

    /**
     * Gets the attribute value for VEH_MAKE_ID using the alias name VEHMAKEID.
     * @return the VEH_MAKE_ID
     */
    public Integer getVEHMAKEID() {
        return (Integer) getAttributeInternal(VEHMAKEID);
    }

    /**
     * Sets <code>value</code> as attribute value for VEH_MAKE_ID using the alias name VEHMAKEID.
     * @param value value to set the VEH_MAKE_ID
     */
    public void setVEHMAKEID(Integer value) {
        setAttributeInternal(VEHMAKEID, value);
    }

    /**
     * Gets the attribute value for VEH_MODEL_ID using the alias name VEHMODELID.
     * @return the VEH_MODEL_ID
     */
    public Integer getVEHMODELID() {
        return (Integer) getAttributeInternal(VEHMODELID);
    }

    /**
     * Sets <code>value</code> as attribute value for VEH_MODEL_ID using the alias name VEHMODELID.
     * @param value value to set the VEH_MODEL_ID
     */
    public void setVEHMODELID(Integer value) {
        setAttributeInternal(VEHMODELID, value);
    }

    /**
     * Gets the attribute value for Blacklist_seq using the alias name Blacklistseq.
     * @return the Blacklist_seq
     */
    public BigDecimal getBlacklistseq() {
        return (BigDecimal) getAttributeInternal(BLACKLISTSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for Blacklist_seq using the alias name Blacklistseq.
     * @param value value to set the Blacklist_seq
     */
    public void setBlacklistseq(BigDecimal value) {
        setAttributeInternal(BLACKLISTSEQ, value);
    }

    /**
     * Gets the attribute value for updated_date using the alias name updateddate.
     * @return the updated_date
     */
    public Timestamp getupdateddate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for updated_date using the alias name updateddate.
     * @param value value to set the updated_date
     */
    public void setupdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for Active_Date_From using the alias name ActiveDateFrom.
     * @return the Active_Date_From
     */
    public Timestamp getActiveDateFrom() {
        return (Timestamp) getAttributeInternal(ACTIVEDATEFROM);
    }

    /**
     * Sets <code>value</code> as attribute value for Active_Date_From using the alias name ActiveDateFrom.
     * @param value value to set the Active_Date_From
     */
    public void setActiveDateFrom(Timestamp value) {
        setAttributeInternal(ACTIVEDATEFROM, value);
    }

    /**
     * Gets the attribute value for Active_Date_To using the alias name ActiveDateTo.
     * @return the Active_Date_To
     */
    public Timestamp getActiveDateTo() {
        return (Timestamp) getAttributeInternal(ACTIVEDATETO);
    }

    /**
     * Sets <code>value</code> as attribute value for Active_Date_To using the alias name ActiveDateTo.
     * @param value value to set the Active_Date_To
     */
    public void setActiveDateTo(Timestamp value) {
        setAttributeInternal(ACTIVEDATETO, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehiclePlateCountryLVO1.
     */
    public RowSet getVehiclePlateCountryLVO1() {
        return (RowSet)getAttributeInternal(VEHICLEPLATECOUNTRYLVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehiclePlateCategoryLVO1.
     */
    public RowSet getVehiclePlateCategoryLVO1() {
        return (RowSet)getAttributeInternal(VEHICLEPLATECATEGORYLVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehiclePlateTypeLVO1.
     */
    public RowSet getVehiclePlateTypeLVO1() {
        return (RowSet)getAttributeInternal(VEHICLEPLATETYPELVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehicleMakeLOVVO1.
     */
    public RowSet getVehicleMakeLOVVO1() {
        return (RowSet)getAttributeInternal(VEHICLEMAKELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehicleModelLOVVO1.
     */
    public RowSet getVehicleModelLOVVO1() {
        return (RowSet)getAttributeInternal(VEHICLEMODELLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VehicleColourLOVVO1.
     */
    public RowSet getVehicleColourLOVVO1() {
        return (RowSet)getAttributeInternal(VEHICLECOLOURLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> YesNoLovVO1.
     */
    public RowSet getYesNoLovVO1() {
        return (RowSet)getAttributeInternal(YESNOLOVVO1);
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
