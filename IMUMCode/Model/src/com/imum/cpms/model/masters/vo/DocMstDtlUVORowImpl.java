package com.imum.cpms.model.masters.vo;

import com.imum.cpms.model.masters.eo.DocMstDtlEOImpl;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jun 20 11:15:01 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DocMstDtlUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PRMDocMstDtlseq {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getPRMDocMstDtlseq();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setPRMDocMstDtlseq((Integer)value);
            }
        }
        ,
        PRMDocMstseq {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getPRMDocMstseq();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setPRMDocMstseq((Integer)value);
            }
        }
        ,
        DocName {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getDocName();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setDocName((String)value);
            }
        }
        ,
        DocDesc {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getDocDesc();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setDocDesc((String)value);
            }
        }
        ,
        Mandatoryflag {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getMandatoryflag();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setMandatoryflag((String)value);
            }
        }
        ,
        Activeflag {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getActiveflag();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setActiveflag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        ActiveBoolean {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getActiveBoolean();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setActiveBoolean((Boolean)value);
            }
        }
        ,
        MandatoryBoolean {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getMandatoryBoolean();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setMandatoryBoolean((Boolean)value);
            }
        }
        ,
        ActivefromDate {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getActivefromDate();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setActivefromDate((Date)value);
            }
        }
        ,
        ActivetoDate {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getActivetoDate();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setActivetoDate((Date)value);
            }
        }
        ,
        rowStatus {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getrowStatus();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setrowStatus((Integer)value);
            }
        }
        ,
        YesNoLovVO1 {
            public Object get(DocMstDtlUVORowImpl obj) {
                return obj.getYesNoLovVO1();
            }

            public void put(DocMstDtlUVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(DocMstDtlUVORowImpl object);

        public abstract void put(DocMstDtlUVORowImpl object, Object value);

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


    public static final int PRMDOCMSTDTLSEQ = AttributesEnum.PRMDocMstDtlseq.index();
    public static final int PRMDOCMSTSEQ = AttributesEnum.PRMDocMstseq.index();
    public static final int DOCNAME = AttributesEnum.DocName.index();
    public static final int DOCDESC = AttributesEnum.DocDesc.index();
    public static final int MANDATORYFLAG = AttributesEnum.Mandatoryflag.index();
    public static final int ACTIVEFLAG = AttributesEnum.Activeflag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int ACTIVEBOOLEAN = AttributesEnum.ActiveBoolean.index();
    public static final int MANDATORYBOOLEAN = AttributesEnum.MandatoryBoolean.index();
    public static final int ACTIVEFROMDATE = AttributesEnum.ActivefromDate.index();
    public static final int ACTIVETODATE = AttributesEnum.ActivetoDate.index();
    public static final int ROWSTATUS = AttributesEnum.rowStatus.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DocMstDtlUVORowImpl() {
    }

    /**
     * Gets DocMstDtlEO entity object.
     * @return the DocMstDtlEO
     */
    public DocMstDtlEOImpl getDocMstDtlEO() {
        return (DocMstDtlEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for PRM_Doc_Mst_Dtl_seq using the alias name PRMDocMstDtlseq.
     * @return the PRM_Doc_Mst_Dtl_seq
     */
    public Integer getPRMDocMstDtlseq() {
        return (Integer) getAttributeInternal(PRMDOCMSTDTLSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for PRM_Doc_Mst_Dtl_seq using the alias name PRMDocMstDtlseq.
     * @param value value to set the PRM_Doc_Mst_Dtl_seq
     */
    public void setPRMDocMstDtlseq(Integer value) {
        setAttributeInternal(PRMDOCMSTDTLSEQ, value);
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
     * Gets the attribute value for the calculated attribute ActiveBoolean.
     * @return the ActiveBoolean
     */
    public Boolean getActiveBoolean() {
//        return (Boolean) getAttributeInternal(ACTIVEBOOLEAN);
        if(getActiveflag() != null && getActiveflag().equalsIgnoreCase("Y"))
        {
            return true;
            }
        else
        {
            return false;
            }
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ActiveBoolean.
     * @param value value to set the  ActiveBoolean
     */
    public void setActiveBoolean(Boolean value) {
//        setAttributeInternal(ACTIVEBOOLEAN, value);
        if(value)
        {
            setActiveflag("Y");
            }
        else
        {
            setActiveflag("N");
            }
    }

    /**
     * Gets the attribute value for the calculated attribute MandatoryBoolean.
     * @return the MandatoryBoolean
     */
    public Boolean getMandatoryBoolean() {
//        return (Boolean) getAttributeInternal(MANDATORYBOOLEAN);
        if(getMandatoryflag() != null && getMandatoryflag().equalsIgnoreCase("Y"))
        {
            return true;
            }
        else
        {
            return false;
            }
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute MandatoryBoolean.
     * @param value value to set the  MandatoryBoolean
     */
    public void setMandatoryBoolean(Boolean value) {
//        setAttributeInternal(MANDATORYBOOLEAN, value);
        if(value)
        {
            setMandatoryflag("Y");
            }
        else
        {
            setMandatoryflag("N");
            }
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
     * Gets the attribute value for the calculated attribute rowStatus.
     * @return the rowStatus
     */
    public Integer getrowStatus() {
        byte entityState = this.getEntity(0).getEntityState();
                return new Integer(entityState);
       // return (Integer) getAttributeInternal(ROWSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute rowStatus.
     * @param value value to set the  rowStatus
     */
    public void setrowStatus(Integer value) {
        setAttributeInternal(ROWSTATUS, value);
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
