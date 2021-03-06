package com.imum.cpms.model.masters.vo;

import com.imum.cpms.model.masters.eo.InstitutionEOImpl;

import java.math.BigDecimal;

import java.sql.Date;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed May 21 19:26:04 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InstitutionUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Activeflag {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getActiveflag();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setActiveflag((String)value);
            }
        }
        ,
        CUSTINSTADDRSEQ {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getCUSTINSTADDRSEQ();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setCUSTINSTADDRSEQ((BigDecimal)value);
            }
        }
        ,
        CityCode {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getCityCode();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setCityCode((String)value);
            }
        }
        ,
        CountryCode {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getCountryCode();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setCountryCode((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setCreatedDate((Date)value);
            }
        }
        ,
        EmailID {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getEmailID();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setEmailID((String)value);
            }
        }
        ,
        Faxnum {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getFaxnum();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setFaxnum((String)value);
            }
        }
        ,
        INSTID {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getINSTID();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setINSTID((BigDecimal)value);
            }
        }
        ,
        INSTNAME {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getINSTNAME();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setINSTNAME((String)value);
            }
        }
        ,
        INSTTYPE {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getINSTTYPE();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setINSTTYPE((String)value);
            }
        }
        ,
        Landlinenum {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getLandlinenum();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setLandlinenum((String)value);
            }
        }
        ,
        Primarycontact {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getPrimarycontact();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setPrimarycontact((String)value);
            }
        }
        ,
        Updatedate {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getUpdatedate();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setUpdatedate((Date)value);
            }
        }
        ,
        Updatedby {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        tradelicensenum {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.gettradelicensenum();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.settradelicensenum((String)value);
            }
        }
        ,
        ALTERNATEPHONENUM {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getALTERNATEPHONENUM();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setALTERNATEPHONENUM((String)value);
            }
        }
        ,
        InstitutionUVO1 {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getInstitutionUVO1();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CityLovVO1 {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getCityLovVO1();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CountryLovVO1 {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getCountryLovVO1();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        YesNoLovVO1 {
            public Object get(InstitutionUVORowImpl obj) {
                return obj.getYesNoLovVO1();
            }

            public void put(InstitutionUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(InstitutionUVORowImpl object);

        public abstract void put(InstitutionUVORowImpl object, Object value);

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
    public static final int CUSTINSTADDRSEQ = AttributesEnum.CUSTINSTADDRSEQ.index();
    public static final int CITYCODE = AttributesEnum.CityCode.index();
    public static final int COUNTRYCODE = AttributesEnum.CountryCode.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int EMAILID = AttributesEnum.EmailID.index();
    public static final int FAXNUM = AttributesEnum.Faxnum.index();
    public static final int INSTID = AttributesEnum.INSTID.index();
    public static final int INSTNAME = AttributesEnum.INSTNAME.index();
    public static final int INSTTYPE = AttributesEnum.INSTTYPE.index();
    public static final int LANDLINENUM = AttributesEnum.Landlinenum.index();
    public static final int PRIMARYCONTACT = AttributesEnum.Primarycontact.index();
    public static final int UPDATEDATE = AttributesEnum.Updatedate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int TRADELICENSENUM = AttributesEnum.tradelicensenum.index();
    public static final int ALTERNATEPHONENUM = AttributesEnum.ALTERNATEPHONENUM.index();
    public static final int INSTITUTIONUVO1 = AttributesEnum.InstitutionUVO1.index();
    public static final int CITYLOVVO1 = AttributesEnum.CityLovVO1.index();
    public static final int COUNTRYLOVVO1 = AttributesEnum.CountryLovVO1.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InstitutionUVORowImpl() {
    }

    /**
     * Gets InstitutionEO entity object.
     * @return the InstitutionEO
     */
    public InstitutionEOImpl getInstitutionEO() {
        return (InstitutionEOImpl)getEntity(0);
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
     * Gets the attribute value for CUST_INST_ADDR_SEQ using the alias name CUSTINSTADDRSEQ.
     * @return the CUST_INST_ADDR_SEQ
     */
    public BigDecimal getCUSTINSTADDRSEQ() {
        return (BigDecimal) getAttributeInternal(CUSTINSTADDRSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for CUST_INST_ADDR_SEQ using the alias name CUSTINSTADDRSEQ.
     * @param value value to set the CUST_INST_ADDR_SEQ
     */
    public void setCUSTINSTADDRSEQ(BigDecimal value) {
        setAttributeInternal(CUSTINSTADDRSEQ, value);
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
     * Gets the attribute value for Email_ID using the alias name EmailID.
     * @return the Email_ID
     */
    public String getEmailID() {
        return (String) getAttributeInternal(EMAILID);
    }

    /**
     * Sets <code>value</code> as attribute value for Email_ID using the alias name EmailID.
     * @param value value to set the Email_ID
     */
    public void setEmailID(String value) {
        setAttributeInternal(EMAILID, value);
    }

    /**
     * Gets the attribute value for Fax_num using the alias name Faxnum.
     * @return the Fax_num
     */
    public String getFaxnum() {
        return (String) getAttributeInternal(FAXNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for Fax_num using the alias name Faxnum.
     * @param value value to set the Fax_num
     */
    public void setFaxnum(String value) {
        setAttributeInternal(FAXNUM, value);
    }

    /**
     * Gets the attribute value for INST_ID using the alias name INSTID.
     * @return the INST_ID
     */
    public BigDecimal getINSTID() {
        return (BigDecimal) getAttributeInternal(INSTID);
    }

    /**
     * Sets <code>value</code> as attribute value for INST_ID using the alias name INSTID.
     * @param value value to set the INST_ID
     */
    public void setINSTID(BigDecimal value) {
        setAttributeInternal(INSTID, value);
    }

    /**
     * Gets the attribute value for INST_NAME using the alias name INSTNAME.
     * @return the INST_NAME
     */
    public String getINSTNAME() {
        return (String) getAttributeInternal(INSTNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for INST_NAME using the alias name INSTNAME.
     * @param value value to set the INST_NAME
     */
    public void setINSTNAME(String value) {
        setAttributeInternal(INSTNAME, value);
    }

    /**
     * Gets the attribute value for INST_TYPE using the alias name INSTTYPE.
     * @return the INST_TYPE
     */
    public String getINSTTYPE() {
        return (String) getAttributeInternal(INSTTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for INST_TYPE using the alias name INSTTYPE.
     * @param value value to set the INST_TYPE
     */
    public void setINSTTYPE(String value) {
        setAttributeInternal(INSTTYPE, value);
    }

    /**
     * Gets the attribute value for Landline_num using the alias name Landlinenum.
     * @return the Landline_num
     */
    public String getLandlinenum() {
        return (String) getAttributeInternal(LANDLINENUM);
    }

    /**
     * Sets <code>value</code> as attribute value for Landline_num using the alias name Landlinenum.
     * @param value value to set the Landline_num
     */
    public void setLandlinenum(String value) {
        setAttributeInternal(LANDLINENUM, value);
    }

    /**
     * Gets the attribute value for Primary_contact using the alias name Primarycontact.
     * @return the Primary_contact
     */
    public String getPrimarycontact() {
        return (String) getAttributeInternal(PRIMARYCONTACT);
    }

    /**
     * Sets <code>value</code> as attribute value for Primary_contact using the alias name Primarycontact.
     * @param value value to set the Primary_contact
     */
    public void setPrimarycontact(String value) {
        setAttributeInternal(PRIMARYCONTACT, value);
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
     * Gets the attribute value for trade_license_num using the alias name tradelicensenum.
     * @return the trade_license_num
     */
    public String gettradelicensenum() {
        return (String) getAttributeInternal(TRADELICENSENUM);
    }

    /**
     * Sets <code>value</code> as attribute value for trade_license_num using the alias name tradelicensenum.
     * @param value value to set the trade_license_num
     */
    public void settradelicensenum(String value) {
        setAttributeInternal(TRADELICENSENUM, value);
    }


    /**
     * Gets the attribute value for ALTERNATE_PHONE_NUM using the alias name ALTERNATEPHONENUM.
     * @return the ALTERNATE_PHONE_NUM
     */
    public String getALTERNATEPHONENUM() {
        return (String) getAttributeInternal(ALTERNATEPHONENUM);
    }

    /**
     * Sets <code>value</code> as attribute value for ALTERNATE_PHONE_NUM using the alias name ALTERNATEPHONENUM.
     * @param value value to set the ALTERNATE_PHONE_NUM
     */
    public void setALTERNATEPHONENUM(String value) {
        setAttributeInternal(ALTERNATEPHONENUM, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> InstitutionUVO1.
     */
    public RowSet getInstitutionUVO1() {
        return (RowSet)getAttributeInternal(INSTITUTIONUVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CityLovVO1.
     */
    public RowSet getCityLovVO1() {
        return (RowSet)getAttributeInternal(CITYLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CountryLovVO1.
     */
    public RowSet getCountryLovVO1() {
        return (RowSet)getAttributeInternal(COUNTRYLOVVO1);
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
