package com.imum.cpms.model.masters.vo;

import com.imum.cpms.model.masters.eo.RuleMaxQuotaEOImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 23 12:16:35 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RuleMaxQuotaVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PRMQuotaseq {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getPRMQuotaseq();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setPRMQuotaseq((BigDecimal)value);
            }
        }
        ,
        RuleId {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getRuleId();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setRuleId((Integer)value);
            }
        }
        ,
        SectorCode {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getSectorCode();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setSectorCode((String)value);
            }
        }
        ,
        Activeflag {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getActiveflag();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setActiveflag((String)value);
            }
        }
        ,
        NumPermitsissued {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getNumPermitsissued();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setNumPermitsissued((BigDecimal)value);
            }
        }
        ,
        Renewalallowedflag {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getRenewalallowedflag();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setRenewalallowedflag((String)value);
            }
        }
        ,
        Changedflag {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getChangedflag();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setChangedflag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        ActiveFlagBoolean {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getActiveFlagBoolean();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setActiveFlagBoolean((Boolean)value);
            }
        }
        ,
        RenewalFlagBoolean {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getRenewalFlagBoolean();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setRenewalFlagBoolean((Boolean)value);
            }
        }
        ,
        quotanum {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getquotanum();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setquotanum((BigDecimal)value);
            }
        }
        ,
        rowStatus {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getrowStatus();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setrowStatus((Integer)value);
            }
        }
        ,
        SectorLovVO1 {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getSectorLovVO1();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        YesNoLovVO1 {
            public Object get(RuleMaxQuotaVORowImpl obj) {
                return obj.getYesNoLovVO1();
            }

            public void put(RuleMaxQuotaVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(RuleMaxQuotaVORowImpl object);

        public abstract void put(RuleMaxQuotaVORowImpl object, Object value);

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


    public static final int PRMQUOTASEQ = AttributesEnum.PRMQuotaseq.index();
    public static final int RULEID = AttributesEnum.RuleId.index();
    public static final int SECTORCODE = AttributesEnum.SectorCode.index();
    public static final int ACTIVEFLAG = AttributesEnum.Activeflag.index();
    public static final int NUMPERMITSISSUED = AttributesEnum.NumPermitsissued.index();
    public static final int RENEWALALLOWEDFLAG = AttributesEnum.Renewalallowedflag.index();
    public static final int CHANGEDFLAG = AttributesEnum.Changedflag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int ACTIVEFLAGBOOLEAN = AttributesEnum.ActiveFlagBoolean.index();
    public static final int RENEWALFLAGBOOLEAN = AttributesEnum.RenewalFlagBoolean.index();
    public static final int QUOTANUM = AttributesEnum.quotanum.index();
    public static final int ROWSTATUS = AttributesEnum.rowStatus.index();
    public static final int SECTORLOVVO1 = AttributesEnum.SectorLovVO1.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RuleMaxQuotaVORowImpl() {
    }

    /**
     * Gets RuleMaxQuotaEO entity object.
     * @return the RuleMaxQuotaEO
     */
    public RuleMaxQuotaEOImpl getRuleMaxQuotaEO() {
        return (RuleMaxQuotaEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for PRM_Quota_seq using the alias name PRMQuotaseq.
     * @return the PRM_Quota_seq
     */
    public BigDecimal getPRMQuotaseq() {
        return (BigDecimal) getAttributeInternal(PRMQUOTASEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for PRM_Quota_seq using the alias name PRMQuotaseq.
     * @param value value to set the PRM_Quota_seq
     */
    public void setPRMQuotaseq(BigDecimal value) {
        setAttributeInternal(PRMQUOTASEQ, value);
    }

    /**
     * Gets the attribute value for Rule_Id using the alias name RuleId.
     * @return the Rule_Id
     */
    public Integer getRuleId() {
        return (Integer) getAttributeInternal(RULEID);
    }

    /**
     * Sets <code>value</code> as attribute value for Rule_Id using the alias name RuleId.
     * @param value value to set the Rule_Id
     */
    public void setRuleId(Integer value) {
        setAttributeInternal(RULEID, value);
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
     * Gets the attribute value for quota_num using the alias name quotanum.
     * @return the quota_num
     */
    public BigDecimal getquotanum() {
        return (BigDecimal) getAttributeInternal(QUOTANUM);
    }

    /**
     * Sets <code>value</code> as attribute value for quota_num using the alias name quotanum.
     * @param value value to set the quota_num
     */
    public void setquotanum(BigDecimal value) {
        setAttributeInternal(QUOTANUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute rowStatus.
     * @return the rowStatus
     */
    public Integer getrowStatus() {
        byte entityState = this.getEntity(0).getEntityState();
                return new Integer(entityState);
        //return (Integer) getAttributeInternal(ROWSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute rowStatus.
     * @param value value to set the  rowStatus
     */
    public void setrowStatus(Integer value) {
        setAttributeInternal(ROWSTATUS, value);
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
     * Gets the attribute value for Num_Permits_issued using the alias name NumPermitsissued.
     * @return the Num_Permits_issued
     */
    public BigDecimal getNumPermitsissued() {
        return (BigDecimal) getAttributeInternal(NUMPERMITSISSUED);
    }

    /**
     * Sets <code>value</code> as attribute value for Num_Permits_issued using the alias name NumPermitsissued.
     * @param value value to set the Num_Permits_issued
     */
    public void setNumPermitsissued(BigDecimal value) {
        setAttributeInternal(NUMPERMITSISSUED, value);
    }

    /**
     * Gets the attribute value for Renewal_allowed_flag using the alias name Renewalallowedflag.
     * @return the Renewal_allowed_flag
     */
    public String getRenewalallowedflag() {
        return (String) getAttributeInternal(RENEWALALLOWEDFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Renewal_allowed_flag using the alias name Renewalallowedflag.
     * @param value value to set the Renewal_allowed_flag
     */
    public void setRenewalallowedflag(String value) {
        setAttributeInternal(RENEWALALLOWEDFLAG, value);
    }

    /**
     * Gets the attribute value for Changed_flag using the alias name Changedflag.
     * @return the Changed_flag
     */
    public String getChangedflag() {
        return (String) getAttributeInternal(CHANGEDFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Changed_flag using the alias name Changedflag.
     * @param value value to set the Changed_flag
     */
    public void setChangedflag(String value) {
        setAttributeInternal(CHANGEDFLAG, value);
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
     * Gets the attribute value for the calculated attribute ActiveFlagBoolean.
     * @return the ActiveFlagBoolean
     */
    public Boolean getActiveFlagBoolean() {
//        return (Boolean) getAttributeInternal(ACTIVEFLAGBOOLEAN);
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
     * Sets <code>value</code> as the attribute value for the calculated attribute ActiveFlagBoolean.
     * @param value value to set the  ActiveFlagBoolean
     */
    public void setActiveFlagBoolean(Boolean value) {
//        setAttributeInternal(ACTIVEFLAGBOOLEAN, value);
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
     * Gets the attribute value for the calculated attribute RenewalFlagBoolean.
     * @return the RenewalFlagBoolean
     */
    public Boolean getRenewalFlagBoolean() {
//        return (Boolean) getAttributeInternal(RENEWALFLAGBOOLEAN);
        if(getRenewalallowedflag() != null && getRenewalallowedflag().equalsIgnoreCase("Y"))
        {
            return true;
            }
        else
        {
            return false;
            }
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RenewalFlagBoolean.
     * @param value value to set the  RenewalFlagBoolean
     */
    public void setRenewalFlagBoolean(Boolean value) {
//        setAttributeInternal(RENEWALFLAGBOOLEAN, value);
                        if(value)
        {
            setRenewalallowedflag("Y");
            }
        else
        {
            setRenewalallowedflag("N");
            }
    }

    /**
     * Gets the view accessor <code>RowSet</code> SectorLovVO1.
     */
    public RowSet getSectorLovVO1() {
        return (RowSet)getAttributeInternal(SECTORLOVVO1);
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
