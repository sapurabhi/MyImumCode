package com.imum.cpms.model.masters.vo;

import com.imum.cpms.model.masters.eo.DocMstHdrEOImpl;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Aug 18 14:21:16 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DocMstHdrUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PRMDocMstseq {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getPRMDocMstseq();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setPRMDocMstseq((Integer)value);
            }
        }
        ,
        CityCode {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getCityCode();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setCityCode((String)value);
            }
        }
        ,
        CountryCode {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getCountryCode();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setCountryCode((String)value);
            }
        }
        ,
        PrmCategCode {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getPrmCategCode();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setPrmCategCode((String)value);
            }
        }
        ,
        PrmTypeCode {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getPrmTypeCode();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setPrmTypeCode((String)value);
            }
        }
        ,
        LocalFlag {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getLocalFlag();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setLocalFlag((String)value);
            }
        }
        ,
        Relativeflag {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getRelativeflag();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setRelativeflag((String)value);
            }
        }
        ,
        CompAccomFlag {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getCompAccomFlag();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setCompAccomFlag((String)value);
            }
        }
        ,
        Activeflag {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getActiveflag();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setActiveflag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        catgdesc {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getcatgdesc();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setcatgdesc((String)value);
            }
        }
        ,
        permittype {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getpermittype();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setpermittype((String)value);
            }
        }
        ,
        restype {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getrestype();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setrestype((String)value);
            }
        }
        ,
        BooleanRelative {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getBooleanRelative();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setBooleanRelative((Boolean)value);
            }
        }
        ,
        BooleanComp {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getBooleanComp();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setBooleanComp((Boolean)value);
            }
        }
        ,
        BooleanActive {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getBooleanActive();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setBooleanActive((Boolean)value);
            }
        }
        ,
        rowStatus {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getrowStatus();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setrowStatus((Integer)value);
            }
        }
        ,
        PermitDocCategoryLOVVO1 {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getPermitDocCategoryLOVVO1();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PermitTypeLovVO1 {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getPermitTypeLovVO1();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ResidenceTypeVO1 {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getResidenceTypeVO1();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        YesNoLovVO1 {
            public Object get(DocMstHdrUVORowImpl obj) {
                return obj.getYesNoLovVO1();
            }

            public void put(DocMstHdrUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(DocMstHdrUVORowImpl object);

        public abstract void put(DocMstHdrUVORowImpl object, Object value);

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


    public static final int PRMDOCMSTSEQ = AttributesEnum.PRMDocMstseq.index();
    public static final int CITYCODE = AttributesEnum.CityCode.index();
    public static final int COUNTRYCODE = AttributesEnum.CountryCode.index();
    public static final int PRMCATEGCODE = AttributesEnum.PrmCategCode.index();
    public static final int PRMTYPECODE = AttributesEnum.PrmTypeCode.index();
    public static final int LOCALFLAG = AttributesEnum.LocalFlag.index();
    public static final int RELATIVEFLAG = AttributesEnum.Relativeflag.index();
    public static final int COMPACCOMFLAG = AttributesEnum.CompAccomFlag.index();
    public static final int ACTIVEFLAG = AttributesEnum.Activeflag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int CATGDESC = AttributesEnum.catgdesc.index();
    public static final int PERMITTYPE = AttributesEnum.permittype.index();
    public static final int RESTYPE = AttributesEnum.restype.index();
    public static final int BOOLEANRELATIVE = AttributesEnum.BooleanRelative.index();
    public static final int BOOLEANCOMP = AttributesEnum.BooleanComp.index();
    public static final int BOOLEANACTIVE = AttributesEnum.BooleanActive.index();
    public static final int ROWSTATUS = AttributesEnum.rowStatus.index();
    public static final int PERMITDOCCATEGORYLOVVO1 = AttributesEnum.PermitDocCategoryLOVVO1.index();
    public static final int PERMITTYPELOVVO1 = AttributesEnum.PermitTypeLovVO1.index();
    public static final int RESIDENCETYPEVO1 = AttributesEnum.ResidenceTypeVO1.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DocMstHdrUVORowImpl() {
    }

    /**
     * Gets DocMstHdrEO entity object.
     * @return the DocMstHdrEO
     */
    public DocMstHdrEOImpl getDocMstHdrEO() {
        return (DocMstHdrEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for PRM_Doc_Mst_seq using the alias name PRMDocMstseq.
     * @return the PRM_Doc_Mst_seq
     */
    public Integer getPRMDocMstseq() {
        return (Integer) getAttributeInternal(PRMDOCMSTSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for PRM_Doc_Mst_seq using the alias name PRMDocMstseq.
     * @param value value to set the PRM_Doc_Mst_seq
     */
    public void setPRMDocMstseq(Integer value) {
        setAttributeInternal(PRMDOCMSTSEQ, value);
    }

    /**
     * Gets the attribute value for City_Code using the alias name CityCode.
     * @return the City_Code
     */
    public String getCityCode() {
        return (String) getAttributeInternal(CITYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for City_Code using the alias name CityCode.
     * @param value value to set the City_Code
     */
    public void setCityCode(String value) {
        setAttributeInternal(CITYCODE, value);
    }

    /**
     * Gets the attribute value for Country_Code using the alias name CountryCode.
     * @return the Country_Code
     */
    public String getCountryCode() {
        return (String) getAttributeInternal(COUNTRYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Country_Code using the alias name CountryCode.
     * @param value value to set the Country_Code
     */
    public void setCountryCode(String value) {
        setAttributeInternal(COUNTRYCODE, value);
    }

    /**
     * Gets the attribute value for Prm_Categ_Code using the alias name PrmCategCode.
     * @return the Prm_Categ_Code
     */
    public String getPrmCategCode() {
        return (String) getAttributeInternal(PRMCATEGCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Prm_Categ_Code using the alias name PrmCategCode.
     * @param value value to set the Prm_Categ_Code
     */
    public void setPrmCategCode(String value) {
        setAttributeInternal(PRMCATEGCODE, value);
    }

    /**
     * Gets the attribute value for Prm_Type_Code using the alias name PrmTypeCode.
     * @return the Prm_Type_Code
     */
    public String getPrmTypeCode() {
        return (String) getAttributeInternal(PRMTYPECODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Prm_Type_Code using the alias name PrmTypeCode.
     * @param value value to set the Prm_Type_Code
     */
    public void setPrmTypeCode(String value) {
        setAttributeInternal(PRMTYPECODE, value);
    }

    /**
     * Gets the attribute value for Local_Flag using the alias name LocalFlag.
     * @return the Local_Flag
     */
    public String getLocalFlag() {
        return (String) getAttributeInternal(LOCALFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Local_Flag using the alias name LocalFlag.
     * @param value value to set the Local_Flag
     */
    public void setLocalFlag(String value) {
        setAttributeInternal(LOCALFLAG, value);
    }

    /**
     * Gets the attribute value for Relative_flag using the alias name Relativeflag.
     * @return the Relative_flag
     */
    public String getRelativeflag() {
        return (String) getAttributeInternal(RELATIVEFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Relative_flag using the alias name Relativeflag.
     * @param value value to set the Relative_flag
     */
    public void setRelativeflag(String value) {
        setAttributeInternal(RELATIVEFLAG, value);
    }

    /**
     * Gets the attribute value for Comp_Accom_Flag using the alias name CompAccomFlag.
     * @return the Comp_Accom_Flag
     */
    public String getCompAccomFlag() {
        return (String) getAttributeInternal(COMPACCOMFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Comp_Accom_Flag using the alias name CompAccomFlag.
     * @param value value to set the Comp_Accom_Flag
     */
    public void setCompAccomFlag(String value) {
        setAttributeInternal(COMPACCOMFLAG, value);
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
     * Gets the attribute value for Updated_date using the alias name Updateddate.
     * @return the Updated_date
     */
    public Timestamp getUpdateddate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Updated_date using the alias name Updateddate.
     * @param value value to set the Updated_date
     */
    public void setUpdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute catgdesc.
     * @return the catgdesc
     */
    public String getcatgdesc() {
        return (String) getAttributeInternal(CATGDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute catgdesc.
     * @param value value to set the  catgdesc
     */
    public void setcatgdesc(String value) {
        setAttributeInternal(CATGDESC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute permittype.
     * @return the permittype
     */
    public String getpermittype() {
        return (String) getAttributeInternal(PERMITTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute permittype.
     * @param value value to set the  permittype
     */
    public void setpermittype(String value) {
        setAttributeInternal(PERMITTYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute restype.
     * @return the restype
     */
    public String getrestype() {
        return (String) getAttributeInternal(RESTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute restype.
     * @param value value to set the  restype
     */
    public void setrestype(String value) {
        setAttributeInternal(RESTYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BooleanRelative.
     * @return the BooleanRelative
     */
    public Boolean getBooleanRelative() {
        if(getRelativeflag() != null && getRelativeflag().equalsIgnoreCase("Y"))
        {
            return true;
            }
        else
        {
            return false;
            }
       // return (Boolean) getAttributeInternal(BOOLEANRELATIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BooleanRelative.
     * @param value value to set the  BooleanRelative
     */
    public void setBooleanRelative(Boolean value) {
        if(value)
        {
            setRelativeflag("Y");
            }
        else
        {
            setRelativeflag("N");
            }
//        setAttributeInternal(BOOLEANRELATIVE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BooleanComp.
     * @return the BooleanComp
     */
    public Boolean getBooleanComp() {
        if(getCompAccomFlag() != null && getCompAccomFlag().equalsIgnoreCase("Y"))
        {
            return true;
            }
        else
        {
            return false;
            }
      //  return (Boolean) getAttributeInternal(BOOLEANCOMP);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BooleanComp.
     * @param value value to set the  BooleanComp
     */
    public void setBooleanComp(Boolean value) {
        if(value)
        {
            setCompAccomFlag("Y");
            }
        else
        {
            setCompAccomFlag("N");
            }
//        setAttributeInternal(BOOLEANCOMP, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BooleanActive.
     * @return the BooleanActive
     */
    public Boolean getBooleanActive() {
        if(getActiveflag() != null && getActiveflag().equalsIgnoreCase("Y"))
        {
            return true;
            }
        else
        {
            return false;
            }
      //  return (Boolean) getAttributeInternal(BOOLEANACTIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BooleanActive.
     * @param value value to set the  BooleanActive
     */
    public void setBooleanActive(Boolean value) {
        if(value)
        {
            setActiveflag("Y");
            }
        else
        {
            setActiveflag("N");
            }
       // setAttributeInternal(BOOLEANACTIVE, value);
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
     * Gets the view accessor <code>RowSet</code> PermitDocCategoryLOVVO1.
     */
    public RowSet getPermitDocCategoryLOVVO1() {
        return (RowSet)getAttributeInternal(PERMITDOCCATEGORYLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PermitTypeLovVO1.
     */
    public RowSet getPermitTypeLovVO1() {
        return (RowSet)getAttributeInternal(PERMITTYPELOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ResidenceTypeVO1.
     */
    public RowSet getResidenceTypeVO1() {
        return (RowSet)getAttributeInternal(RESIDENCETYPEVO1);
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