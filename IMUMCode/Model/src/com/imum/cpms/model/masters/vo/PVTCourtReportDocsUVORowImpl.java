package com.imum.cpms.model.masters.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jun 19 18:11:54 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTCourtReportDocsUVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreatedBy {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        DOCSEQ {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getDOCSEQ();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setDOCSEQ((BigDecimal)value);
            }
        }
        ,
        CreatedDate {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        DOCDesc {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getDOCDesc();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setDOCDesc((String)value);
            }
        }
        ,
        Docstage {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getDocstage();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setDocstage((Integer)value);
            }
        }
        ,
        PVTHDRSEQ {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getPVTHDRSEQ();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setPVTHDRSEQ((BigDecimal)value);
            }
        }
        ,
        Updatedby {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        deleteflag {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getdeleteflag();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setdeleteflag((String)value);
            }
        }
        ,
        doctype {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getdoctype();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setdoctype((Integer)value);
            }
        }
        ,
        filepath {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getfilepath();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setfilepath((String)value);
            }
        }
        ,
        remarks {
            public Object get(PVTCourtReportDocsUVORowImpl obj) {
                return obj.getremarks();
            }

            public void put(PVTCourtReportDocsUVORowImpl obj, Object value) {
                obj.setremarks((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PVTCourtReportDocsUVORowImpl object);

        public abstract void put(PVTCourtReportDocsUVORowImpl object,
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


    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int DOCSEQ = AttributesEnum.DOCSEQ.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int DOCDESC = AttributesEnum.DOCDesc.index();
    public static final int DOCSTAGE = AttributesEnum.Docstage.index();
    public static final int PVTHDRSEQ = AttributesEnum.PVTHDRSEQ.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int DELETEFLAG = AttributesEnum.deleteflag.index();
    public static final int DOCTYPE = AttributesEnum.doctype.index();
    public static final int FILEPATH = AttributesEnum.filepath.index();
    public static final int REMARKS = AttributesEnum.remarks.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PVTCourtReportDocsUVORowImpl() {
    }

    /**
     * Gets PVTDocsEO entity object.
     * @return the PVTDocsEO
     */
    public EntityImpl getPVTDocsEO() {
        return (EntityImpl)getEntity(0);
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
     * Gets the attribute value for DOC_SEQ using the alias name DOCSEQ.
     * @return the DOC_SEQ
     */
    public BigDecimal getDOCSEQ() {
        return (BigDecimal) getAttributeInternal(DOCSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for DOC_SEQ using the alias name DOCSEQ.
     * @param value value to set the DOC_SEQ
     */
    public void setDOCSEQ(BigDecimal value) {
        setAttributeInternal(DOCSEQ, value);
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
     * Gets the attribute value for DOC_Desc using the alias name DOCDesc.
     * @return the DOC_Desc
     */
    public String getDOCDesc() {
        return (String) getAttributeInternal(DOCDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for DOC_Desc using the alias name DOCDesc.
     * @param value value to set the DOC_Desc
     */
    public void setDOCDesc(String value) {
        setAttributeInternal(DOCDESC, value);
    }

    /**
     * Gets the attribute value for Doc_stage using the alias name Docstage.
     * @return the Doc_stage
     */
    public Integer getDocstage() {
        return (Integer) getAttributeInternal(DOCSTAGE);
    }

    /**
     * Sets <code>value</code> as attribute value for Doc_stage using the alias name Docstage.
     * @param value value to set the Doc_stage
     */
    public void setDocstage(Integer value) {
        setAttributeInternal(DOCSTAGE, value);
    }

    /**
     * Gets the attribute value for PVT_HDR_SEQ using the alias name PVTHDRSEQ.
     * @return the PVT_HDR_SEQ
     */
    public BigDecimal getPVTHDRSEQ() {
        return (BigDecimal) getAttributeInternal(PVTHDRSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for PVT_HDR_SEQ using the alias name PVTHDRSEQ.
     * @param value value to set the PVT_HDR_SEQ
     */
    public void setPVTHDRSEQ(BigDecimal value) {
        setAttributeInternal(PVTHDRSEQ, value);
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
     * Gets the attribute value for delete_flag using the alias name deleteflag.
     * @return the delete_flag
     */
    public String getdeleteflag() {
        return (String) getAttributeInternal(DELETEFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for delete_flag using the alias name deleteflag.
     * @param value value to set the delete_flag
     */
    public void setdeleteflag(String value) {
        setAttributeInternal(DELETEFLAG, value);
    }

    /**
     * Gets the attribute value for doc_type using the alias name doctype.
     * @return the doc_type
     */
    public Integer getdoctype() {
        return (Integer) getAttributeInternal(DOCTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for doc_type using the alias name doctype.
     * @param value value to set the doc_type
     */
    public void setdoctype(Integer value) {
        setAttributeInternal(DOCTYPE, value);
    }

    /**
     * Gets the attribute value for file_path using the alias name filepath.
     * @return the file_path
     */
    public String getfilepath() {
        return (String) getAttributeInternal(FILEPATH);
    }

    /**
     * Sets <code>value</code> as attribute value for file_path using the alias name filepath.
     * @param value value to set the file_path
     */
    public void setfilepath(String value) {
        setAttributeInternal(FILEPATH, value);
    }

    /**
     * Gets the attribute value for remarks using the alias name remarks.
     * @return the remarks
     */
    public String getremarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as attribute value for remarks using the alias name remarks.
     * @param value value to set the remarks
     */
    public void setremarks(String value) {
        setAttributeInternal(REMARKS, value);
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
