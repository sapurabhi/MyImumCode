package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 19 14:32:14 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PvtEnforceVehicleAssignRVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        EVASSIGNSEQ {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getEVASSIGNSEQ();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setEVASSIGNSEQ((BigDecimal)value);
            }
        }
        ,
        PVTHDRSEQ {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getPVTHDRSEQ();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setPVTHDRSEQ((BigDecimal)value);
            }
        }
        ,
        ENFORCEVHCLID {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getENFORCEVHCLID();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setENFORCEVHCLID((BigDecimal)value);
            }
        }
        ,
        PRIORITY {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getPRIORITY();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setPRIORITY((String)value);
            }
        }
        ,
        REQUESTSENTAT {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getREQUESTSENTAT();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setREQUESTSENTAT((Timestamp)value);
            }
        }
        ,
        ACCEPTREJAT {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getACCEPTREJAT();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setACCEPTREJAT((Timestamp)value);
            }
        }
        ,
        REQUESTSTATUS {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getREQUESTSTATUS();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setREQUESTSTATUS((Integer)value);
            }
        }
        ,
        EVgeolat {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getEVgeolat();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setEVgeolat((Float)value);
            }
        }
        ,
        EVgeolon {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getEVgeolon();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setEVgeolon((Float)value);
            }
        }
        ,
        CreatedBy {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        Evcomments {
            public Object get(PvtEnforceVehicleAssignRVORowImpl obj) {
                return obj.getEvcomments();
            }

            public void put(PvtEnforceVehicleAssignRVORowImpl obj,
                            Object value) {
                obj.setEvcomments((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PvtEnforceVehicleAssignRVORowImpl object);

        public abstract void put(PvtEnforceVehicleAssignRVORowImpl object,
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
    public static final int EVASSIGNSEQ = AttributesEnum.EVASSIGNSEQ.index();
    public static final int PVTHDRSEQ = AttributesEnum.PVTHDRSEQ.index();
    public static final int ENFORCEVHCLID = AttributesEnum.ENFORCEVHCLID.index();
    public static final int PRIORITY = AttributesEnum.PRIORITY.index();
    public static final int REQUESTSENTAT = AttributesEnum.REQUESTSENTAT.index();
    public static final int ACCEPTREJAT = AttributesEnum.ACCEPTREJAT.index();
    public static final int REQUESTSTATUS = AttributesEnum.REQUESTSTATUS.index();
    public static final int EVGEOLAT = AttributesEnum.EVgeolat.index();
    public static final int EVGEOLON = AttributesEnum.EVgeolon.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int EVCOMMENTS = AttributesEnum.Evcomments.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PvtEnforceVehicleAssignRVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute EVASSIGNSEQ.
     * @return the EVASSIGNSEQ
     */
    public BigDecimal getEVASSIGNSEQ() {
        return (BigDecimal) getAttributeInternal(EVASSIGNSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EVASSIGNSEQ.
     * @param value value to set the  EVASSIGNSEQ
     */
    public void setEVASSIGNSEQ(BigDecimal value) {
        setAttributeInternal(EVASSIGNSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PVTHDRSEQ.
     * @return the PVTHDRSEQ
     */
    public BigDecimal getPVTHDRSEQ() {
        return (BigDecimal) getAttributeInternal(PVTHDRSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PVTHDRSEQ.
     * @param value value to set the  PVTHDRSEQ
     */
    public void setPVTHDRSEQ(BigDecimal value) {
        setAttributeInternal(PVTHDRSEQ, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ENFORCEVHCLID.
     * @return the ENFORCEVHCLID
     */
    public BigDecimal getENFORCEVHCLID() {
        return (BigDecimal) getAttributeInternal(ENFORCEVHCLID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ENFORCEVHCLID.
     * @param value value to set the  ENFORCEVHCLID
     */
    public void setENFORCEVHCLID(BigDecimal value) {
        setAttributeInternal(ENFORCEVHCLID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PRIORITY.
     * @return the PRIORITY
     */
    public String getPRIORITY() {
        return (String) getAttributeInternal(PRIORITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PRIORITY.
     * @param value value to set the  PRIORITY
     */
    public void setPRIORITY(String value) {
        setAttributeInternal(PRIORITY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute REQUESTSENTAT.
     * @return the REQUESTSENTAT
     */
    public Timestamp getREQUESTSENTAT() {
        return (Timestamp) getAttributeInternal(REQUESTSENTAT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute REQUESTSENTAT.
     * @param value value to set the  REQUESTSENTAT
     */
    public void setREQUESTSENTAT(Timestamp value) {
        setAttributeInternal(REQUESTSENTAT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ACCEPTREJAT.
     * @return the ACCEPTREJAT
     */
    public Timestamp getACCEPTREJAT() {
        return (Timestamp) getAttributeInternal(ACCEPTREJAT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ACCEPTREJAT.
     * @param value value to set the  ACCEPTREJAT
     */
    public void setACCEPTREJAT(Timestamp value) {
        setAttributeInternal(ACCEPTREJAT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute REQUESTSTATUS.
     * @return the REQUESTSTATUS
     */
    public Integer getREQUESTSTATUS() {
        return (Integer) getAttributeInternal(REQUESTSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute REQUESTSTATUS.
     * @param value value to set the  REQUESTSTATUS
     */
    public void setREQUESTSTATUS(Integer value) {
        setAttributeInternal(REQUESTSTATUS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EVgeolat.
     * @return the EVgeolat
     */
    public Float getEVgeolat() {
        return (Float) getAttributeInternal(EVGEOLAT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EVgeolat.
     * @param value value to set the  EVgeolat
     */
    public void setEVgeolat(Float value) {
        setAttributeInternal(EVGEOLAT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EVgeolon.
     * @return the EVgeolon
     */
    public Float getEVgeolon() {
        return (Float) getAttributeInternal(EVGEOLON);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EVgeolon.
     * @param value value to set the  EVgeolon
     */
    public void setEVgeolon(Float value) {
        setAttributeInternal(EVGEOLON, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreatedBy.
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreatedBy.
     * @param value value to set the  CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreatedDate.
     * @return the CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreatedDate.
     * @param value value to set the  CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Updatedby.
     * @return the Updatedby
     */
    public String getUpdatedby() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Updatedby.
     * @param value value to set the  Updatedby
     */
    public void setUpdatedby(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Updateddate.
     * @return the Updateddate
     */
    public Timestamp getUpdateddate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Updateddate.
     * @param value value to set the  Updateddate
     */
    public void setUpdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Evcomments.
     * @return the Evcomments
     */
    public String getEvcomments() {
        return (String) getAttributeInternal(EVCOMMENTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Evcomments.
     * @param value value to set the  Evcomments
     */
    public void setEvcomments(String value) {
        setAttributeInternal(EVCOMMENTS, value);
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