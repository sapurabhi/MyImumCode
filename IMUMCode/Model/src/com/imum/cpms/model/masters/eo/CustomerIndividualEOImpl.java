package com.imum.cpms.model.masters.eo;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Timestamp;

import java.sql.Types;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 19 11:57:59 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CustomerIndividualEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CustID {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getCustID();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setCustID((BigDecimal)value);
            }
        }
        ,
        Salutation {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getSalutation();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setSalutation((String)value);
            }
        }
        ,
        LastName {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getLastName();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setLastName((String)value);
            }
        }
        ,
        FirstName {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getFirstName();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setFirstName((String)value);
            }
        }
        ,
        MiddleName {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getMiddleName();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setMiddleName((String)value);
            }
        }
        ,
        Gender {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getGender();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setGender((String)value);
            }
        }
        ,
        EmiratesID {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getEmiratesID();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setEmiratesID((String)value);
            }
        }
        ,
        Residenttype {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getResidenttype();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setResidenttype((String)value);
            }
        }
        ,
        Nationality {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getNationality();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setNationality((String)value);
            }
        }
        ,
        CityCode {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getCityCode();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setCityCode((String)value);
            }
        }
        ,
        Countrycode {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getCountrycode();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setCountrycode((String)value);
            }
        }
        ,
        Mobilenum {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getMobilenum();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setMobilenum((String)value);
            }
        }
        ,
        Landlinenum {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getLandlinenum();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setLandlinenum((String)value);
            }
        }
        ,
        ALTERNATEPHONENUM {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getALTERNATEPHONENUM();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setALTERNATEPHONENUM((String)value);
            }
        }
        ,
        EmailID {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getEmailID();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setEmailID((String)value);
            }
        }
        ,
        Activeflag {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getActiveflag();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setActiveflag((String)value);
            }
        }
        ,
        Comments {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getComments();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setComments((String)value);
            }
        }
        ,
        Legacyinfo {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getLegacyinfo();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setLegacyinfo((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updatedate {
            public Object get(CustomerIndividualEOImpl obj) {
                return obj.getUpdatedate();
            }

            public void put(CustomerIndividualEOImpl obj, Object value) {
                obj.setUpdatedate((Timestamp)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(CustomerIndividualEOImpl object);

        public abstract void put(CustomerIndividualEOImpl object,
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
    public static final int CUSTID = AttributesEnum.CustID.index();
    public static final int SALUTATION = AttributesEnum.Salutation.index();
    public static final int LASTNAME = AttributesEnum.LastName.index();
    public static final int FIRSTNAME = AttributesEnum.FirstName.index();
    public static final int MIDDLENAME = AttributesEnum.MiddleName.index();
    public static final int GENDER = AttributesEnum.Gender.index();
    public static final int EMIRATESID = AttributesEnum.EmiratesID.index();
    public static final int RESIDENTTYPE = AttributesEnum.Residenttype.index();
    public static final int NATIONALITY = AttributesEnum.Nationality.index();
    public static final int CITYCODE = AttributesEnum.CityCode.index();
    public static final int COUNTRYCODE = AttributesEnum.Countrycode.index();
    public static final int MOBILENUM = AttributesEnum.Mobilenum.index();
    public static final int LANDLINENUM = AttributesEnum.Landlinenum.index();
    public static final int ALTERNATEPHONENUM = AttributesEnum.ALTERNATEPHONENUM.index();
    public static final int EMAILID = AttributesEnum.EmailID.index();
    public static final int ACTIVEFLAG = AttributesEnum.Activeflag.index();
    public static final int COMMENTS = AttributesEnum.Comments.index();
    public static final int LEGACYINFO = AttributesEnum.Legacyinfo.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDATE = AttributesEnum.Updatedate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CustomerIndividualEOImpl() {
    }

    /**
     * Gets the attribute value for CustID, using the alias name CustID.
     * @return the CustID
     */
    public BigDecimal getCustID() {
        return (BigDecimal)getAttributeInternal(CUSTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustID.
     * @param value value to set the CustID
     */
    public void setCustID(BigDecimal value) {
        setAttributeInternal(CUSTID, value);
    }

    /**
     * Gets the attribute value for Salutation, using the alias name Salutation.
     * @return the Salutation
     */
    public String getSalutation() {
        return (String)getAttributeInternal(SALUTATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salutation.
     * @param value value to set the Salutation
     */
    public void setSalutation(String value) {
        setAttributeInternal(SALUTATION, value);
    }

    /**
     * Gets the attribute value for LastName, using the alias name LastName.
     * @return the LastName
     */
    public String getLastName() {
        return (String)getAttributeInternal(LASTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastName.
     * @param value value to set the LastName
     */
    public void setLastName(String value) {
        setAttributeInternal(LASTNAME, value);
    }

    /**
     * Gets the attribute value for FirstName, using the alias name FirstName.
     * @return the FirstName
     */
    public String getFirstName() {
        return (String)getAttributeInternal(FIRSTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for FirstName.
     * @param value value to set the FirstName
     */
    public void setFirstName(String value) {
        setAttributeInternal(FIRSTNAME, value);
    }

    /**
     * Gets the attribute value for MiddleName, using the alias name MiddleName.
     * @return the MiddleName
     */
    public String getMiddleName() {
        return (String)getAttributeInternal(MIDDLENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for MiddleName.
     * @param value value to set the MiddleName
     */
    public void setMiddleName(String value) {
        setAttributeInternal(MIDDLENAME, value);
    }

    /**
     * Gets the attribute value for Gender, using the alias name Gender.
     * @return the Gender
     */
    public String getGender() {
        return (String)getAttributeInternal(GENDER);
    }

    /**
     * Sets <code>value</code> as the attribute value for Gender.
     * @param value value to set the Gender
     */
    public void setGender(String value) {
        setAttributeInternal(GENDER, value);
    }

    /**
     * Gets the attribute value for EmiratesID, using the alias name EmiratesID.
     * @return the EmiratesID
     */
    public String getEmiratesID() {
        return (String)getAttributeInternal(EMIRATESID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmiratesID.
     * @param value value to set the EmiratesID
     */
    public void setEmiratesID(String value) {
        setAttributeInternal(EMIRATESID, value);
    }

    /**
     * Gets the attribute value for Residenttype, using the alias name Residenttype.
     * @return the Residenttype
     */
    public String getResidenttype() {
        return (String)getAttributeInternal(RESIDENTTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Residenttype.
     * @param value value to set the Residenttype
     */
    public void setResidenttype(String value) {
        setAttributeInternal(RESIDENTTYPE, value);
    }

    /**
     * Gets the attribute value for Nationality, using the alias name Nationality.
     * @return the Nationality
     */
    public String getNationality() {
        return (String)getAttributeInternal(NATIONALITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Nationality.
     * @param value value to set the Nationality
     */
    public void setNationality(String value) {
        setAttributeInternal(NATIONALITY, value);
    }

    /**
     * Gets the attribute value for CityCode, using the alias name CityCode.
     * @return the CityCode
     */
    public String getCityCode() {
        return (String)getAttributeInternal(CITYCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CityCode.
     * @param value value to set the CityCode
     */
    public void setCityCode(String value) {
        setAttributeInternal(CITYCODE, value);
    }

    /**
     * Gets the attribute value for Countrycode, using the alias name Countrycode.
     * @return the Countrycode
     */
    public String getCountrycode() {
        return (String)getAttributeInternal(COUNTRYCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Countrycode.
     * @param value value to set the Countrycode
     */
    public void setCountrycode(String value) {
        setAttributeInternal(COUNTRYCODE, value);
    }

    /**
     * Gets the attribute value for Mobilenum, using the alias name Mobilenum.
     * @return the Mobilenum
     */
    public String getMobilenum() {
        return (String)getAttributeInternal(MOBILENUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Mobilenum.
     * @param value value to set the Mobilenum
     */
    public void setMobilenum(String value) {
        setAttributeInternal(MOBILENUM, value);
    }

    /**
     * Gets the attribute value for Landlinenum, using the alias name Landlinenum.
     * @return the Landlinenum
     */
    public String getLandlinenum() {
        return (String)getAttributeInternal(LANDLINENUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Landlinenum.
     * @param value value to set the Landlinenum
     */
    public void setLandlinenum(String value) {
        setAttributeInternal(LANDLINENUM, value);
    }

    /**
     * Gets the attribute value for ALTERNATEPHONENUM, using the alias name ALTERNATEPHONENUM.
     * @return the ALTERNATEPHONENUM
     */
    public String getALTERNATEPHONENUM() {
        return (String)getAttributeInternal(ALTERNATEPHONENUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for ALTERNATEPHONENUM.
     * @param value value to set the ALTERNATEPHONENUM
     */
    public void setALTERNATEPHONENUM(String value) {
        setAttributeInternal(ALTERNATEPHONENUM, value);
    }

    /**
     * Gets the attribute value for EmailID, using the alias name EmailID.
     * @return the EmailID
     */
    public String getEmailID() {
        return (String)getAttributeInternal(EMAILID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmailID.
     * @param value value to set the EmailID
     */
    public void setEmailID(String value) {
        setAttributeInternal(EMAILID, value);
    }

    /**
     * Gets the attribute value for Activeflag, using the alias name Activeflag.
     * @return the Activeflag
     */
    public String getActiveflag() {
        return (String)getAttributeInternal(ACTIVEFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for Activeflag.
     * @param value value to set the Activeflag
     */
    public void setActiveflag(String value) {
        setAttributeInternal(ACTIVEFLAG, value);
    }

    /**
     * Gets the attribute value for Comments, using the alias name Comments.
     * @return the Comments
     */
    public String getComments() {
        return (String)getAttributeInternal(COMMENTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Comments.
     * @param value value to set the Comments
     */
    public void setComments(String value) {
        setAttributeInternal(COMMENTS, value);
    }

    /**
     * Gets the attribute value for Legacyinfo, using the alias name Legacyinfo.
     * @return the Legacyinfo
     */
    public String getLegacyinfo() {
        return (String)getAttributeInternal(LEGACYINFO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Legacyinfo.
     * @param value value to set the Legacyinfo
     */
    public void setLegacyinfo(String value) {
        setAttributeInternal(LEGACYINFO, value);
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
     * @param custID key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal custID) {
        return new Key(new Object[]{custID});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.masters.eo.CustomerIndividualEO");
        }
        return mDefinitionObject;
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
       
        CallableStatement stmt = null;
                try {
                    stmt = getDBTransaction().createCallableStatement("{call  sequence_mst_trigger(?,?) }", 0);
                    stmt.setString(1, "CUST_INST_ID");            
                    stmt.registerOutParameter(2, Types.BIGINT);
                    stmt.execute();           
                    BigDecimal SeqNum = stmt.getBigDecimal(2);
                    setCustID(SeqNum);
                }  catch (Exception e) {
                                e.printStackTrace();
                       }
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
