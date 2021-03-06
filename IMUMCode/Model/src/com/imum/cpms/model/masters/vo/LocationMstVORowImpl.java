package com.imum.cpms.model.masters.vo;

import java.math.BigDecimal;

import java.sql.Time;
import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 10 16:29:36 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LocationMstVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ActiveFlag {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getActiveFlag();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setActiveFlag((String)value);
            }
        }
        ,
        AddlCharge {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getAddlCharge();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAddlCharge((BigDecimal)value);
            }
        }
        ,
        BayCount {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getBayCount();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setBayCount((Integer)value);
            }
        }
        ,
        COUNTRYCODE {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCOUNTRYCODE();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setCOUNTRYCODE((String)value);
            }
        }
        ,
        Clampingcharges {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getClampingcharges();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setClampingcharges((BigDecimal)value);
            }
        }
        ,
        CommunityCode {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCommunityCode();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setCommunityCode((String)value);
            }
        }
        ,
        ContactDetails {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getContactDetails();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setContactDetails((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Freedays {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getFreedays();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setFreedays((Integer)value);
            }
        }
        ,
        Geolatdeg {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getGeolatdeg();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setGeolatdeg((Float)value);
            }
        }
        ,
        Geolondeg {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getGeolondeg();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setGeolondeg((Float)value);
            }
        }
        ,
        GoLiveDt {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getGoLiveDt();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setGoLiveDt((Timestamp)value);
            }
        }
        ,
        LOCTYPE {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLOCTYPE();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLOCTYPE((String)value);
            }
        }
        ,
        LocAdd1 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLocAdd1();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLocAdd1((String)value);
            }
        }
        ,
        LocAdd2 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLocAdd2();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLocAdd2((String)value);
            }
        }
        ,
        LocDesc {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLocDesc();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLocDesc((String)value);
            }
        }
        ,
        LocationID {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLocationID();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLocationID((Integer)value);
            }
        }
        ,
        OpeningDt {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getOpeningDt();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setOpeningDt((Timestamp)value);
            }
        }
        ,
        OprHrFrom {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getOprHrFrom();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setOprHrFrom((Time)value);
            }
        }
        ,
        OprHrTo {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getOprHrTo();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setOprHrTo((Time)value);
            }
        }
        ,
        POBox {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getPOBox();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setPOBox((Integer)value);
            }
        }
        ,
        RemovalCharge {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getRemovalCharge();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setRemovalCharge((BigDecimal)value);
            }
        }
        ,
        UpdatedBy {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getUpdatedBy();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setUpdatedBy((String)value);
            }
        }
        ,
        UpdatedDate {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getUpdatedDate();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setUpdatedDate((Timestamp)value);
            }
        }
        ,
        issCommPrmitflag {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getissCommPrmitflag();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setissCommPrmitflag((String)value);
            }
        }
        ,
        issGovtPermitflag {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getissGovtPermitflag();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setissGovtPermitflag((String)value);
            }
        }
        ,
        Remarks {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getRemarks();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        AllowCommercialPermitsflag {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getAllowCommercialPermitsflag();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAllowCommercialPermitsflag((String)value);
            }
        }
        ,
        Storagecharge {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getStoragecharge();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setStoragecharge((BigDecimal)value);
            }
        }
        ,
        CountryName {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCountryName();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setCountryName((String)value);
            }
        }
        ,
        CommunityName {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCommunityName();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setCommunityName((String)value);
            }
        }
        ,
        LocationTypeName {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLocationTypeName();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLocationTypeName((String)value);
            }
        }
        ,
        Language {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLanguage();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLanguage((String)value);
            }
        }
        ,
        LocationNameLng {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLocationNameLng();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setLocationNameLng((String)value);
            }
        }
        ,
        YesNoLovVO1 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getYesNoLovVO1();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CommunityLovVO1 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCommunityLovVO1();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CountryLovVO1 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCountryLovVO1();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CityLovVO1 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCityLovVO1();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LocationTypeLVO1 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLocationTypeLVO1();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CityLovVO4 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getCityLovVO4();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LangMstLVO1 {
            public Object get(LocationMstVORowImpl obj) {
                return obj.getLangMstLVO1();
            }

            public void put(LocationMstVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(LocationMstVORowImpl object);

        public abstract void put(LocationMstVORowImpl object, Object value);

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
    public static final int ADDLCHARGE = AttributesEnum.AddlCharge.index();
    public static final int BAYCOUNT = AttributesEnum.BayCount.index();
    public static final int COUNTRYCODE = AttributesEnum.COUNTRYCODE.index();
    public static final int CLAMPINGCHARGES = AttributesEnum.Clampingcharges.index();
    public static final int COMMUNITYCODE = AttributesEnum.CommunityCode.index();
    public static final int CONTACTDETAILS = AttributesEnum.ContactDetails.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int FREEDAYS = AttributesEnum.Freedays.index();
    public static final int GEOLATDEG = AttributesEnum.Geolatdeg.index();
    public static final int GEOLONDEG = AttributesEnum.Geolondeg.index();
    public static final int GOLIVEDT = AttributesEnum.GoLiveDt.index();
    public static final int LOCTYPE = AttributesEnum.LOCTYPE.index();
    public static final int LOCADD1 = AttributesEnum.LocAdd1.index();
    public static final int LOCADD2 = AttributesEnum.LocAdd2.index();
    public static final int LOCDESC = AttributesEnum.LocDesc.index();
    public static final int LOCATIONID = AttributesEnum.LocationID.index();
    public static final int OPENINGDT = AttributesEnum.OpeningDt.index();
    public static final int OPRHRFROM = AttributesEnum.OprHrFrom.index();
    public static final int OPRHRTO = AttributesEnum.OprHrTo.index();
    public static final int POBOX = AttributesEnum.POBox.index();
    public static final int REMOVALCHARGE = AttributesEnum.RemovalCharge.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int ISSCOMMPRMITFLAG = AttributesEnum.issCommPrmitflag.index();
    public static final int ISSGOVTPERMITFLAG = AttributesEnum.issGovtPermitflag.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int ALLOWCOMMERCIALPERMITSFLAG = AttributesEnum.AllowCommercialPermitsflag.index();
    public static final int STORAGECHARGE = AttributesEnum.Storagecharge.index();
    public static final int COUNTRYNAME = AttributesEnum.CountryName.index();
    public static final int COMMUNITYNAME = AttributesEnum.CommunityName.index();
    public static final int LOCATIONTYPENAME = AttributesEnum.LocationTypeName.index();
    public static final int LANGUAGE = AttributesEnum.Language.index();
    public static final int LOCATIONNAMELNG = AttributesEnum.LocationNameLng.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();
    public static final int COMMUNITYLOVVO1 = AttributesEnum.CommunityLovVO1.index();
    public static final int COUNTRYLOVVO1 = AttributesEnum.CountryLovVO1.index();
    public static final int CITYLOVVO1 = AttributesEnum.CityLovVO1.index();
    public static final int LOCATIONTYPELVO1 = AttributesEnum.LocationTypeLVO1.index();
    public static final int CITYLOVVO4 = AttributesEnum.CityLovVO4.index();
    public static final int LANGMSTLVO1 = AttributesEnum.LangMstLVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LocationMstVORowImpl() {
    }

    /**
     * Gets LocationMstEO entity object.
     * @return the LocationMstEO
     */
    public EntityImpl getLocationMstEO() {
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
     * Gets the attribute value for Addl_Charge using the alias name AddlCharge.
     * @return the Addl_Charge
     */
    public BigDecimal getAddlCharge() {
        return (BigDecimal) getAttributeInternal(ADDLCHARGE);
    }

    /**
     * Sets <code>value</code> as attribute value for Addl_Charge using the alias name AddlCharge.
     * @param value value to set the Addl_Charge
     */
    public void setAddlCharge(BigDecimal value) {
        setAttributeInternal(ADDLCHARGE, value);
    }

    /**
     * Gets the attribute value for Bay_Count using the alias name BayCount.
     * @return the Bay_Count
     */
    public Integer getBayCount() {
        return (Integer) getAttributeInternal(BAYCOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for Bay_Count using the alias name BayCount.
     * @param value value to set the Bay_Count
     */
    public void setBayCount(Integer value) {
        setAttributeInternal(BAYCOUNT, value);
    }

    /**
     * Gets the attribute value for COUNTRY_CODE using the alias name COUNTRYCODE.
     * @return the COUNTRY_CODE
     */
    public String getCOUNTRYCODE() {
        return (String) getAttributeInternal(COUNTRYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for COUNTRY_CODE using the alias name COUNTRYCODE.
     * @param value value to set the COUNTRY_CODE
     */
    public void setCOUNTRYCODE(String value) {
        setAttributeInternal(COUNTRYCODE, value);
    }

    /**
     * Gets the attribute value for Clamping_charges using the alias name Clampingcharges.
     * @return the Clamping_charges
     */
    public BigDecimal getClampingcharges() {
        return (BigDecimal) getAttributeInternal(CLAMPINGCHARGES);
    }

    /**
     * Sets <code>value</code> as attribute value for Clamping_charges using the alias name Clampingcharges.
     * @param value value to set the Clamping_charges
     */
    public void setClampingcharges(BigDecimal value) {
        setAttributeInternal(CLAMPINGCHARGES, value);
    }

    /**
     * Gets the attribute value for Community_Code using the alias name CommunityCode.
     * @return the Community_Code
     */
    public String getCommunityCode() {
        return (String) getAttributeInternal(COMMUNITYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Community_Code using the alias name CommunityCode.
     * @param value value to set the Community_Code
     */
    public void setCommunityCode(String value) {
        setAttributeInternal(COMMUNITYCODE, value);
    }

    /**
     * Gets the attribute value for Contact_Details using the alias name ContactDetails.
     * @return the Contact_Details
     */
    public String getContactDetails() {
        return (String) getAttributeInternal(CONTACTDETAILS);
    }

    /**
     * Sets <code>value</code> as attribute value for Contact_Details using the alias name ContactDetails.
     * @param value value to set the Contact_Details
     */
    public void setContactDetails(String value) {
        setAttributeInternal(CONTACTDETAILS, value);
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
     * Gets the attribute value for Free_days using the alias name Freedays.
     * @return the Free_days
     */
    public Integer getFreedays() {
        return (Integer) getAttributeInternal(FREEDAYS);
    }

    /**
     * Sets <code>value</code> as attribute value for Free_days using the alias name Freedays.
     * @param value value to set the Free_days
     */
    public void setFreedays(Integer value) {
        setAttributeInternal(FREEDAYS, value);
    }

    /**
     * Gets the attribute value for Geo_lat_deg using the alias name Geolatdeg.
     * @return the Geo_lat_deg
     */
    public Float getGeolatdeg() {
        return (Float) getAttributeInternal(GEOLATDEG);
    }

    /**
     * Sets <code>value</code> as attribute value for Geo_lat_deg using the alias name Geolatdeg.
     * @param value value to set the Geo_lat_deg
     */
    public void setGeolatdeg(Float value) {
        setAttributeInternal(GEOLATDEG, value);
    }

    /**
     * Gets the attribute value for Geo_lon_deg using the alias name Geolondeg.
     * @return the Geo_lon_deg
     */
    public Float getGeolondeg() {
        return (Float) getAttributeInternal(GEOLONDEG);
    }

    /**
     * Sets <code>value</code> as attribute value for Geo_lon_deg using the alias name Geolondeg.
     * @param value value to set the Geo_lon_deg
     */
    public void setGeolondeg(Float value) {
        setAttributeInternal(GEOLONDEG, value);
    }

    /**
     * Gets the attribute value for GoLive_Dt using the alias name GoLiveDt.
     * @return the GoLive_Dt
     */
    public Timestamp getGoLiveDt() {
        return (Timestamp) getAttributeInternal(GOLIVEDT);
    }

    /**
     * Sets <code>value</code> as attribute value for GoLive_Dt using the alias name GoLiveDt.
     * @param value value to set the GoLive_Dt
     */
    public void setGoLiveDt(Timestamp value) {
        setAttributeInternal(GOLIVEDT, value);
    }

    /**
     * Gets the attribute value for LOC_TYPE using the alias name LOCTYPE.
     * @return the LOC_TYPE
     */
    public String getLOCTYPE() {
        return (String) getAttributeInternal(LOCTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for LOC_TYPE using the alias name LOCTYPE.
     * @param value value to set the LOC_TYPE
     */
    public void setLOCTYPE(String value) {
        setAttributeInternal(LOCTYPE, value);
    }

    /**
     * Gets the attribute value for Loc_Add1 using the alias name LocAdd1.
     * @return the Loc_Add1
     */
    public String getLocAdd1() {
        return (String) getAttributeInternal(LOCADD1);
    }

    /**
     * Sets <code>value</code> as attribute value for Loc_Add1 using the alias name LocAdd1.
     * @param value value to set the Loc_Add1
     */
    public void setLocAdd1(String value) {
        setAttributeInternal(LOCADD1, value);
    }

    /**
     * Gets the attribute value for Loc_Add2 using the alias name LocAdd2.
     * @return the Loc_Add2
     */
    public String getLocAdd2() {
        return (String) getAttributeInternal(LOCADD2);
    }

    /**
     * Sets <code>value</code> as attribute value for Loc_Add2 using the alias name LocAdd2.
     * @param value value to set the Loc_Add2
     */
    public void setLocAdd2(String value) {
        setAttributeInternal(LOCADD2, value);
    }

    /**
     * Gets the attribute value for Loc_Desc using the alias name LocDesc.
     * @return the Loc_Desc
     */
    public String getLocDesc() {
        return (String) getAttributeInternal(LOCDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for Loc_Desc using the alias name LocDesc.
     * @param value value to set the Loc_Desc
     */
    public void setLocDesc(String value) {
        setAttributeInternal(LOCDESC, value);
    }

    /**
     * Gets the attribute value for Location_ID using the alias name LocationID.
     * @return the Location_ID
     */
    public Integer getLocationID() {
        return (Integer) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for Location_ID using the alias name LocationID.
     * @param value value to set the Location_ID
     */
    public void setLocationID(Integer value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for Opening_Dt using the alias name OpeningDt.
     * @return the Opening_Dt
     */
    public Timestamp getOpeningDt() {
        return (Timestamp) getAttributeInternal(OPENINGDT);
    }

    /**
     * Sets <code>value</code> as attribute value for Opening_Dt using the alias name OpeningDt.
     * @param value value to set the Opening_Dt
     */
    public void setOpeningDt(Timestamp value) {
        setAttributeInternal(OPENINGDT, value);
    }

    /**
     * Gets the attribute value for Opr_Hr_From using the alias name OprHrFrom.
     * @return the Opr_Hr_From
     */
    public Time getOprHrFrom() {
        return (Time) getAttributeInternal(OPRHRFROM);
    }

    /**
     * Sets <code>value</code> as attribute value for Opr_Hr_From using the alias name OprHrFrom.
     * @param value value to set the Opr_Hr_From
     */
    public void setOprHrFrom(Time value) {
        setAttributeInternal(OPRHRFROM, value);
    }

    /**
     * Gets the attribute value for Opr_Hr_To using the alias name OprHrTo.
     * @return the Opr_Hr_To
     */
    public Time getOprHrTo() {
        return (Time) getAttributeInternal(OPRHRTO);
    }

    /**
     * Sets <code>value</code> as attribute value for Opr_Hr_To using the alias name OprHrTo.
     * @param value value to set the Opr_Hr_To
     */
    public void setOprHrTo(Time value) {
        setAttributeInternal(OPRHRTO, value);
    }

    /**
     * Gets the attribute value for PO_Box using the alias name POBox.
     * @return the PO_Box
     */
    public Integer getPOBox() {
        return (Integer) getAttributeInternal(POBOX);
    }

    /**
     * Sets <code>value</code> as attribute value for PO_Box using the alias name POBox.
     * @param value value to set the PO_Box
     */
    public void setPOBox(Integer value) {
        setAttributeInternal(POBOX, value);
    }

    /**
     * Gets the attribute value for Removal_Charge using the alias name RemovalCharge.
     * @return the Removal_Charge
     */
    public BigDecimal getRemovalCharge() {
        return (BigDecimal) getAttributeInternal(REMOVALCHARGE);
    }

    /**
     * Sets <code>value</code> as attribute value for Removal_Charge using the alias name RemovalCharge.
     * @param value value to set the Removal_Charge
     */
    public void setRemovalCharge(BigDecimal value) {
        setAttributeInternal(REMOVALCHARGE, value);
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
     * Gets the attribute value for iss_Comm_Prmit_flag using the alias name issCommPrmitflag.
     * @return the iss_Comm_Prmit_flag
     */
    public String getissCommPrmitflag() {
        return (String) getAttributeInternal(ISSCOMMPRMITFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for iss_Comm_Prmit_flag using the alias name issCommPrmitflag.
     * @param value value to set the iss_Comm_Prmit_flag
     */
    public void setissCommPrmitflag(String value) {
        setAttributeInternal(ISSCOMMPRMITFLAG, value);
    }

    /**
     * Gets the attribute value for iss_Govt_Permit_flag using the alias name issGovtPermitflag.
     * @return the iss_Govt_Permit_flag
     */
    public String getissGovtPermitflag() {
        return (String) getAttributeInternal(ISSGOVTPERMITFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for iss_Govt_Permit_flag using the alias name issGovtPermitflag.
     * @param value value to set the iss_Govt_Permit_flag
     */
    public void setissGovtPermitflag(String value) {
        setAttributeInternal(ISSGOVTPERMITFLAG, value);
    }

    /**
     * Gets the attribute value for Remarks using the alias name Remarks.
     * @return the Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as attribute value for Remarks using the alias name Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CountryName.
     * @return the CountryName
     */
    public String getCountryName() {
        return (String) getAttributeInternal(COUNTRYNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CountryName.
     * @param value value to set the  CountryName
     */
    public void setCountryName(String value) {
        setAttributeInternal(COUNTRYNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CommunityName.
     * @return the CommunityName
     */
    public String getCommunityName() {
        return (String) getAttributeInternal(COMMUNITYNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CommunityName.
     * @param value value to set the  CommunityName
     */
    public void setCommunityName(String value) {
        setAttributeInternal(COMMUNITYNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LocationTypeName.
     * @return the LocationTypeName
     */
    public String getLocationTypeName() {
        return (String) getAttributeInternal(LOCATIONTYPENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LocationTypeName.
     * @param value value to set the  LocationTypeName
     */
    public void setLocationTypeName(String value) {
        setAttributeInternal(LOCATIONTYPENAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Language.
     * @return the Language
     */
    public String getLanguage() {
        return (String) getAttributeInternal(LANGUAGE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Language.
     * @param value value to set the  Language
     */
    public void setLanguage(String value) {
        setAttributeInternal(LANGUAGE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LocationNameLng.
     * @return the LocationNameLng
     */
    public String getLocationNameLng() {
        return (String) getAttributeInternal(LOCATIONNAMELNG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LocationNameLng.
     * @param value value to set the  LocationNameLng
     */
    public void setLocationNameLng(String value) {
        setAttributeInternal(LOCATIONNAMELNG, value);
    }

    /**
     * Gets the attribute value for Allow_Commercial_Permits_flag using the alias name AllowCommercialPermitsflag.
     * @return the Allow_Commercial_Permits_flag
     */
    public String getAllowCommercialPermitsflag() {
        return (String) getAttributeInternal(ALLOWCOMMERCIALPERMITSFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Allow_Commercial_Permits_flag using the alias name AllowCommercialPermitsflag.
     * @param value value to set the Allow_Commercial_Permits_flag
     */
    public void setAllowCommercialPermitsflag(String value) {
        setAttributeInternal(ALLOWCOMMERCIALPERMITSFLAG, value);
    }

    /**
     * Gets the attribute value for Storage_charge using the alias name Storagecharge.
     * @return the Storage_charge
     */
    public BigDecimal getStoragecharge() {
        return (BigDecimal) getAttributeInternal(STORAGECHARGE);
    }

    /**
     * Sets <code>value</code> as attribute value for Storage_charge using the alias name Storagecharge.
     * @param value value to set the Storage_charge
     */
    public void setStoragecharge(BigDecimal value) {
        setAttributeInternal(STORAGECHARGE, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> YesNoLovVO1.
     */
    public RowSet getYesNoLovVO1() {
        return (RowSet)getAttributeInternal(YESNOLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CommunityLovVO1.
     */
    public RowSet getCommunityLovVO1() {
        return (RowSet)getAttributeInternal(COMMUNITYLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CountryLovVO1.
     */
    public RowSet getCountryLovVO1() {
        return (RowSet)getAttributeInternal(COUNTRYLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CityLovVO1.
     */
    public RowSet getCityLovVO1() {
        return (RowSet)getAttributeInternal(CITYLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LocationTypeLVO1.
     */
    public RowSet getLocationTypeLVO1() {
        return (RowSet)getAttributeInternal(LOCATIONTYPELVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CityLovVO4.
     */
    public RowSet getCityLovVO4() {
        return (RowSet)getAttributeInternal(CITYLOVVO4);
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
