package com.imum.cpms.model.transactions.vo;

import java.sql.Date;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 16 17:18:45 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SectorforSupVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        AllocId {
            public Object get(SectorforSupVORowImpl obj) {
                return obj.getAllocId();
            }

            public void put(SectorforSupVORowImpl obj, Object value) {
                obj.setAllocId((Integer)value);
            }
        }
        ,
        supid {
            public Object get(SectorforSupVORowImpl obj) {
                return obj.getsupid();
            }

            public void put(SectorforSupVORowImpl obj, Object value) {
                obj.setsupid((String)value);
            }
        }
        ,
        AssgnStartDate {
            public Object get(SectorforSupVORowImpl obj) {
                return obj.getAssgnStartDate();
            }

            public void put(SectorforSupVORowImpl obj, Object value) {
                obj.setAssgnStartDate((Date)value);
            }
        }
        ,
        AssgnEndDate {
            public Object get(SectorforSupVORowImpl obj) {
                return obj.getAssgnEndDate();
            }

            public void put(SectorforSupVORowImpl obj, Object value) {
                obj.setAssgnEndDate((Date)value);
            }
        }
        ,
        sector {
            public Object get(SectorforSupVORowImpl obj) {
                return obj.getsector();
            }

            public void put(SectorforSupVORowImpl obj, Object value) {
                obj.setsector((String)value);
            }
        }
        ,
        SectorLovVO1 {
            public Object get(SectorforSupVORowImpl obj) {
                return obj.getSectorLovVO1();
            }

            public void put(SectorforSupVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SectorforSupVORowImpl object);

        public abstract void put(SectorforSupVORowImpl object, Object value);

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
    public static final int ALLOCID = AttributesEnum.AllocId.index();
    public static final int SUPID = AttributesEnum.supid.index();
    public static final int ASSGNSTARTDATE = AttributesEnum.AssgnStartDate.index();
    public static final int ASSGNENDDATE = AttributesEnum.AssgnEndDate.index();
    public static final int SECTOR = AttributesEnum.sector.index();
    public static final int SECTORLOVVO1 = AttributesEnum.SectorLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SectorforSupVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute AllocId.
     * @return the AllocId
     */
    public Integer getAllocId() {
        return (Integer) getAttributeInternal(ALLOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AllocId.
     * @param value value to set the  AllocId
     */
    public void setAllocId(Integer value) {
        setAttributeInternal(ALLOCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute supid.
     * @return the supid
     */
    public String getsupid() {
        return (String) getAttributeInternal(SUPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute supid.
     * @param value value to set the  supid
     */
    public void setsupid(String value) {
        setAttributeInternal(SUPID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute AssgnStartDate.
     * @return the AssgnStartDate
     */
    public Date getAssgnStartDate() {
        return (Date) getAttributeInternal(ASSGNSTARTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AssgnStartDate.
     * @param value value to set the  AssgnStartDate
     */
    public void setAssgnStartDate(Date value) {
        setAttributeInternal(ASSGNSTARTDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute AssgnEndDate.
     * @return the AssgnEndDate
     */
    public Date getAssgnEndDate() {
        return (Date) getAttributeInternal(ASSGNENDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AssgnEndDate.
     * @param value value to set the  AssgnEndDate
     */
    public void setAssgnEndDate(Date value) {
        setAttributeInternal(ASSGNENDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute sector.
     * @return the sector
     */
    public String getsector() {
        return (String) getAttributeInternal(SECTOR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute sector.
     * @param value value to set the  sector
     */
    public void setsector(String value) {
        setAttributeInternal(SECTOR, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> SectorLovVO1.
     */
    public RowSet getSectorLovVO1() {
        return (RowSet)getAttributeInternal(SECTORLOVVO1);
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