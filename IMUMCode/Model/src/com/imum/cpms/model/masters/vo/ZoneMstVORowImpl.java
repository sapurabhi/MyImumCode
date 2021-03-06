package com.imum.cpms.model.masters.vo;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Sep 28 11:56:50 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ZoneMstVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ActiveFlag {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getActiveFlag();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setActiveFlag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        GeoLatDeg {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getGeoLatDeg();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setGeoLatDeg((Float)value);
            }
        }
        ,
        GeoLonDeg {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getGeoLonDeg();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setGeoLonDeg((Float)value);
            }
        }
        ,
        GoLiveDate {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getGoLiveDate();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setGoLiveDate((Date)value);
            }
        }
        ,
        RemoveVehicleflag {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getRemoveVehicleflag();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setRemoveVehicleflag((String)value);
            }
        }
        ,
        SectorCode {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getSectorCode();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setSectorCode((String)value);
            }
        }
        ,
        UpdatedBy {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getUpdatedBy();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setUpdatedBy((String)value);
            }
        }
        ,
        UpdatedDate {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getUpdatedDate();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setUpdatedDate((Timestamp)value);
            }
        }
        ,
        ZoneCode {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getZoneCode();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setZoneCode((String)value);
            }
        }
        ,
        ZoneName {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getZoneName();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setZoneName((String)value);
            }
        }
        ,
        LanguageZone {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getLanguageZone();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setLanguageZone((String)value);
            }
        }
        ,
        ZoneNameLng {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getZoneNameLng();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setZoneNameLng((String)value);
            }
        }
        ,
        YesNoLovVO1 {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getYesNoLovVO1();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LangMstLVO1 {
            public Object get(ZoneMstVORowImpl obj) {
                return obj.getLangMstLVO1();
            }

            public void put(ZoneMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(ZoneMstVORowImpl object);

        public abstract void put(ZoneMstVORowImpl object, Object value);

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


    public static final int ACTIVEFLAG = AttributesEnum.ActiveFlag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int GEOLATDEG = AttributesEnum.GeoLatDeg.index();
    public static final int GEOLONDEG = AttributesEnum.GeoLonDeg.index();
    public static final int GOLIVEDATE = AttributesEnum.GoLiveDate.index();
    public static final int REMOVEVEHICLEFLAG = AttributesEnum.RemoveVehicleflag.index();
    public static final int SECTORCODE = AttributesEnum.SectorCode.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int ZONECODE = AttributesEnum.ZoneCode.index();
    public static final int ZONENAME = AttributesEnum.ZoneName.index();
    public static final int LANGUAGEZONE = AttributesEnum.LanguageZone.index();
    public static final int ZONENAMELNG = AttributesEnum.ZoneNameLng.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();
    public static final int LANGMSTLVO1 = AttributesEnum.LangMstLVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ZoneMstVORowImpl() {
    }

    /**
     * Gets ZoneMstEO entity object.
     * @return the ZoneMstEO
     */
    public EntityImpl getZoneMstEO() {
        return (EntityImpl)getEntity(0);
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
     * Gets the attribute value for Geo_Lat_Deg using the alias name GeoLatDeg.
     * @return the Geo_Lat_Deg
     */
    public Float getGeoLatDeg() {
        return (Float) getAttributeInternal(GEOLATDEG);
    }

    /**
     * Sets <code>value</code> as attribute value for Geo_Lat_Deg using the alias name GeoLatDeg.
     * @param value value to set the Geo_Lat_Deg
     */
    public void setGeoLatDeg(Float value) {
        setAttributeInternal(GEOLATDEG, value);
    }

    /**
     * Gets the attribute value for Geo_Lon_Deg using the alias name GeoLonDeg.
     * @return the Geo_Lon_Deg
     */
    public Float getGeoLonDeg() {
        return (Float) getAttributeInternal(GEOLONDEG);
    }

    /**
     * Sets <code>value</code> as attribute value for Geo_Lon_Deg using the alias name GeoLonDeg.
     * @param value value to set the Geo_Lon_Deg
     */
    public void setGeoLonDeg(Float value) {
        setAttributeInternal(GEOLONDEG, value);
    }

    /**
     * Gets the attribute value for GoLive_Date using the alias name GoLiveDate.
     * @return the GoLive_Date
     */
    public Date getGoLiveDate() {
        return (Date) getAttributeInternal(GOLIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for GoLive_Date using the alias name GoLiveDate.
     * @param value value to set the GoLive_Date
     */
    public void setGoLiveDate(Date value) {
        setAttributeInternal(GOLIVEDATE, value);
    }

    /**
     * Gets the attribute value for Remove_Vehicle_flag using the alias name RemoveVehicleflag.
     * @return the Remove_Vehicle_flag
     */
    public String getRemoveVehicleflag() {
        return (String) getAttributeInternal(REMOVEVEHICLEFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Remove_Vehicle_flag using the alias name RemoveVehicleflag.
     * @param value value to set the Remove_Vehicle_flag
     */
    public void setRemoveVehicleflag(String value) {
        setAttributeInternal(REMOVEVEHICLEFLAG, value);
    }

    /**
     * Gets the attribute value for Sector_Code using the alias name SectorCode.
     * @return the Sector_Code
     */
    public String getSectorCode() {
        return (String) getAttributeInternal(SECTORCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Sector_Code using the alias name SectorCode.
     * @param value value to set the Sector_Code
     */
    public void setSectorCode(String value) {
        setAttributeInternal(SECTORCODE, value);
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
     * Gets the attribute value for Zone_Code using the alias name ZoneCode.
     * @return the Zone_Code
     */
    public String getZoneCode() {
        return (String) getAttributeInternal(ZONECODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Zone_Code using the alias name ZoneCode.
     * @param value value to set the Zone_Code
     */
    public void setZoneCode(String value) {
        setAttributeInternal(ZONECODE, value);
    }

    /**
     * Gets the attribute value for Zone_Name using the alias name ZoneName.
     * @return the Zone_Name
     */
    public String getZoneName() {
        return (String) getAttributeInternal(ZONENAME);
    }

    /**
     * Sets <code>value</code> as attribute value for Zone_Name using the alias name ZoneName.
     * @param value value to set the Zone_Name
     */
    public void setZoneName(String value) {
        setAttributeInternal(ZONENAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LanguageZone.
     * @return the LanguageZone
     */
    public String getLanguageZone() {
        return (String) getAttributeInternal(LANGUAGEZONE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LanguageZone.
     * @param value value to set the  LanguageZone
     */
    public void setLanguageZone(String value) {
        setAttributeInternal(LANGUAGEZONE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ZoneNameLng.
     * @return the ZoneNameLng
     */
    public String getZoneNameLng() {
        return (String) getAttributeInternal(ZONENAMELNG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ZoneNameLng.
     * @param value value to set the  ZoneNameLng
     */
    public void setZoneNameLng(String value) {
        setAttributeInternal(ZONENAMELNG, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> YesNoLovVO1.
     */
    public RowSet getYesNoLovVO1() {
        return (RowSet)getAttributeInternal(YESNOLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LangMstLVO1.
     */
    public RowSet getLangMstLVO1() {
        return (RowSet)getAttributeInternal(LANGMSTLVO1);
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
