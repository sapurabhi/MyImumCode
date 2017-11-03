package com.imum.cpms.model.masters.vo;

import java.math.BigDecimal;

import java.sql.Date;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jun 19 11:25:19 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PvtAppealdocMstVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        APPEALDOCMSTSEQ {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getAPPEALDOCMSTSEQ();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setAPPEALDOCMSTSEQ((BigDecimal)value);
            }
        }
        ,
        PVTAPPEALREASONID {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getPVTAPPEALREASONID();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setPVTAPPEALREASONID((Integer)value);
            }
        }
        ,
        DocName {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getDocName();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setDocName((String)value);
            }
        }
        ,
        DocDesc {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getDocDesc();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setDocDesc((String)value);
            }
        }
        ,
        Mandatoryflag {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getMandatoryflag();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setMandatoryflag((String)value);
            }
        }
        ,
        Activeflag {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getActiveflag();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setActiveflag((String)value);
            }
        }
        ,
        ActivefromDate {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getActivefromDate();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setActivefromDate((Date)value);
            }
        }
        ,
        ActivetoDate {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getActivetoDate();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setActivetoDate((Date)value);
            }
        }
        ,
        DEFCityCode {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getDEFCityCode();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setDEFCityCode((String)value);
            }
        }
        ,
        DEFCountryMst {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getDEFCountryMst();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setDEFCountryMst((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setCreatedDate((Date)value);
            }
        }
        ,
        Updatedby {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updatedate {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getUpdatedate();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setUpdatedate((Date)value);
            }
        }
        ,
        clickonedit {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getclickonedit();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setclickonedit((Integer)value);
            }
        }
        ,
        ActiveFlagBoolean {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getActiveFlagBoolean();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setActiveFlagBoolean((Boolean)value);
            }
        }
        ,
        MFlagBoolean {
            public Object get(PvtAppealdocMstVORowImpl obj) {
                return obj.getMFlagBoolean();
            }

            public void put(PvtAppealdocMstVORowImpl obj, Object value) {
                obj.setMFlagBoolean((Boolean)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PvtAppealdocMstVORowImpl object);

        public abstract void put(PvtAppealdocMstVORowImpl object,
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


    public static final int APPEALDOCMSTSEQ = AttributesEnum.APPEALDOCMSTSEQ.index();
    public static final int PVTAPPEALREASONID = AttributesEnum.PVTAPPEALREASONID.index();
    public static final int DOCNAME = AttributesEnum.DocName.index();
    public static final int DOCDESC = AttributesEnum.DocDesc.index();
    public static final int MANDATORYFLAG = AttributesEnum.Mandatoryflag.index();
    public static final int ACTIVEFLAG = AttributesEnum.Activeflag.index();
    public static final int ACTIVEFROMDATE = AttributesEnum.ActivefromDate.index();
    public static final int ACTIVETODATE = AttributesEnum.ActivetoDate.index();
    public static final int DEFCITYCODE = AttributesEnum.DEFCityCode.index();
    public static final int DEFCOUNTRYMST = AttributesEnum.DEFCountryMst.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDATE = AttributesEnum.Updatedate.index();
    public static final int CLICKONEDIT = AttributesEnum.clickonedit.index();
    public static final int ACTIVEFLAGBOOLEAN = AttributesEnum.ActiveFlagBoolean.index();
    public static final int MFLAGBOOLEAN = AttributesEnum.MFlagBoolean.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PvtAppealdocMstVORowImpl() {
    }

    /**
     * Gets PvtAppealdocMstEO entity object.
     * @return the PvtAppealdocMstEO
     */
    public EntityImpl getPvtAppealdocMstEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for APPEAL_DOC_MST_SEQ using the alias name APPEALDOCMSTSEQ.
     * @return the APPEAL_DOC_MST_SEQ
     */
    public BigDecimal getAPPEALDOCMSTSEQ() {
        return (BigDecimal) getAttributeInternal(APPEALDOCMSTSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for APPEAL_DOC_MST_SEQ using the alias name APPEALDOCMSTSEQ.
     * @param value value to set the APPEAL_DOC_MST_SEQ
     */
    public void setAPPEALDOCMSTSEQ(BigDecimal value) {
        setAttributeInternal(APPEALDOCMSTSEQ, value);
    }

    /**
     * Gets the attribute value for PVT_APPEAL_REASON_ID using the alias name PVTAPPEALREASONID.
     * @return the PVT_APPEAL_REASON_ID
     */
    public Integer getPVTAPPEALREASONID() {
        return (Integer) getAttributeInternal(PVTAPPEALREASONID);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_APPEAL_REASON_ID using the alias name PVTAPPEALREASONID.
     * @param value value to set the PVT_APPEAL_REASON_ID
     */
    public void setPVTAPPEALREASONID(Integer value) {
        setAttributeInternal(PVTAPPEALREASONID, value);
    }

    /**
     * Gets the attribute value for Doc_Name using the alias name DocName.
     * @return the Doc_Name
     */
    public String getDocName() {
        return (String) getAttributeInternal(DOCNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for Doc_Name using the alias name DocName.
     * @param value value to set the Doc_Name
     */
    public void setDocName(String value) {
        setAttributeInternal(DOCNAME, value);
    }

    /**
     * Gets the attribute value for Doc_Desc using the alias name DocDesc.
     * @return the Doc_Desc
     */
    public String getDocDesc() {
        return (String) getAttributeInternal(DOCDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for Doc_Desc using the alias name DocDesc.
     * @param value value to set the Doc_Desc
     */
    public void setDocDesc(String value) {
        setAttributeInternal(DOCDESC, value);
    }

    /**
     * Gets the attribute value for Mandatory_flag using the alias name Mandatoryflag.
     * @return the Mandatory_flag
     */
    public String getMandatoryflag() {
        return (String) getAttributeInternal(MANDATORYFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Mandatory_flag using the alias name Mandatoryflag.
     * @param value value to set the Mandatory_flag
     */
    public void setMandatoryflag(String value) {
        setAttributeInternal(MANDATORYFLAG, value);
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
     * Gets the attribute value for Active_from_Date using the alias name ActivefromDate.
     * @return the Active_from_Date
     */
    public Date getActivefromDate() {
        return (Date) getAttributeInternal(ACTIVEFROMDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Active_from_Date using the alias name ActivefromDate.
     * @param value value to set the Active_from_Date
     */
    public void setActivefromDate(Date value) {
        setAttributeInternal(ACTIVEFROMDATE, value);
    }

    /**
     * Gets the attribute value for Active_to_Date using the alias name ActivetoDate.
     * @return the Active_to_Date
     */
    public Date getActivetoDate() {
        return (Date) getAttributeInternal(ACTIVETODATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Active_to_Date using the alias name ActivetoDate.
     * @param value value to set the Active_to_Date
     */
    public void setActivetoDate(Date value) {
        setAttributeInternal(ACTIVETODATE, value);
    }

    /**
     * Gets the attribute value for DEF_City_Code using the alias name DEFCityCode.
     * @return the DEF_City_Code
     */
    public String getDEFCityCode() {
        return (String) getAttributeInternal(DEFCITYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for DEF_City_Code using the alias name DEFCityCode.
     * @param value value to set the DEF_City_Code
     */
    public void setDEFCityCode(String value) {
        setAttributeInternal(DEFCITYCODE, value);
    }

    /**
     * Gets the attribute value for DEF_Country_Mst using the alias name DEFCountryMst.
     * @return the DEF_Country_Mst
     */
    public String getDEFCountryMst() {
        return (String) getAttributeInternal(DEFCOUNTRYMST);
    }

    /**
     * Sets <code>value</code> as attribute value for DEF_Country_Mst using the alias name DEFCountryMst.
     * @param value value to set the DEF_Country_Mst
     */
    public void setDEFCountryMst(String value) {
        setAttributeInternal(DEFCOUNTRYMST, value);
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
    public Date getCreatedDate() {
        return (Date) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Created_Date using the alias name CreatedDate.
     * @param value value to set the Created_Date
     */
    public void setCreatedDate(Date value) {
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
     * Gets the attribute value for Update_date using the alias name Updatedate.
     * @return the Update_date
     */
    public Date getUpdatedate() {
        return (Date) getAttributeInternal(UPDATEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Update_date using the alias name Updatedate.
     * @param value value to set the Update_date
     */
    public void setUpdatedate(Date value) {
        setAttributeInternal(UPDATEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute clickonedit.
     * @return the clickonedit
     */
    public Integer getclickonedit() {
        byte entityState = this.getEntity(0).getEntityState();
                      return new Integer(entityState);

        
       // return (String) getAttributeInternal(CLICKONEDIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute clickonedit.
     * @param value value to set the  clickonedit
     */
    public void setclickonedit(Integer value) {
        setAttributeInternal(CLICKONEDIT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ActiveFlagBoolean.
     * @return the ActiveFlagBoolean
     */
    public Boolean getActiveFlagBoolean() {
        
        if(getActiveflag() != null && getActiveflag().equalsIgnoreCase("Y"))
        {
        return true;
        }
        else
        {
        return false;
        }
        
        //return (Boolean) getAttributeInternal(ACTIVEFLAGBOOLEAN);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ActiveFlagBoolean.
     * @param value value to set the  ActiveFlagBoolean
     */
    public void setActiveFlagBoolean(Boolean value) {
        
        if(value)
        {
        setActiveflag("Y");
        }
        else
        {
            setActiveflag("N");
        }
        
        
       // setAttributeInternal(ACTIVEFLAGBOOLEAN, value);
    }

    /**
     * Gets the attribute value for the calculated attribute MFlagBoolean.
     * @return the MFlagBoolean
     */
    public Boolean getMFlagBoolean() {
        
        if(getMandatoryflag() != null && getMandatoryflag().equalsIgnoreCase("Y"))
        {
        return true;
        }
        else
        {
        return false;
        }
        
       // return (Boolean) getAttributeInternal(MFLAGBOOLEAN);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute MFlagBoolean.
     * @param value value to set the  MFlagBoolean
     */
    public void setMFlagBoolean(Boolean value) {
        
        
        if(value)
        {
        setMandatoryflag("Y");
        }
        else
        {
        setMandatoryflag("N");
        } 
        //setAttributeInternal(MFLAGBOOLEAN, value);
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