package com.imum.cpms.model.staffdeploy.vo;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Oct 27 16:54:32 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SupervisorSectorVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Allocid {
            public Object get(SupervisorSectorVORowImpl obj) {
                return obj.getAllocid();
            }

            public void put(SupervisorSectorVORowImpl obj, Object value) {
                obj.setAllocid((Integer)value);
            }
        }
        ,
        Sector {
            public Object get(SupervisorSectorVORowImpl obj) {
                return obj.getSector();
            }

            public void put(SupervisorSectorVORowImpl obj, Object value) {
                obj.setSector((String)value);
            }
        }
        ,
        Shift {
            public Object get(SupervisorSectorVORowImpl obj) {
                return obj.getShift();
            }

            public void put(SupervisorSectorVORowImpl obj, Object value) {
                obj.setShift((String)value);
            }
        }
        ,
        Sno {
            public Object get(SupervisorSectorVORowImpl obj) {
                return obj.getSno();
            }

            public void put(SupervisorSectorVORowImpl obj, Object value) {
                obj.setSno((Integer)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SupervisorSectorVORowImpl object);

        public abstract void put(SupervisorSectorVORowImpl object,
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
    public static final int ALLOCID = AttributesEnum.Allocid.index();
    public static final int SECTOR = AttributesEnum.Sector.index();
    public static final int SHIFT = AttributesEnum.Shift.index();
    public static final int SNO = AttributesEnum.Sno.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SupervisorSectorVORowImpl() {
    }

    /**
     * Gets SupervisorSectorEO entity object.
     * @return the SupervisorSectorEO
     */
    public EntityImpl getSupervisorSectorEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Alloc_id using the alias name Allocid.
     * @return the Alloc_id
     */
    public Integer getAllocid() {
        return (Integer) getAttributeInternal(ALLOCID);
    }

    /**
     * Sets <code>value</code> as attribute value for Alloc_id using the alias name Allocid.
     * @param value value to set the Alloc_id
     */
    public void setAllocid(Integer value) {
        setAttributeInternal(ALLOCID, value);
    }

    /**
     * Gets the attribute value for Sector using the alias name Sector.
     * @return the Sector
     */
    public String getSector() {
        return (String) getAttributeInternal(SECTOR);
    }

    /**
     * Sets <code>value</code> as attribute value for Sector using the alias name Sector.
     * @param value value to set the Sector
     */
    public void setSector(String value) {
        setAttributeInternal(SECTOR, value);
    }

    /**
     * Gets the attribute value for Shift using the alias name Shift.
     * @return the Shift
     */
    public String getShift() {
        return (String) getAttributeInternal(SHIFT);
    }

    /**
     * Sets <code>value</code> as attribute value for Shift using the alias name Shift.
     * @param value value to set the Shift
     */
    public void setShift(String value) {
        setAttributeInternal(SHIFT, value);
    }

    /**
     * Gets the attribute value for Sno using the alias name Sno.
     * @return the Sno
     */
    public Integer getSno() {
        return (Integer) getAttributeInternal(SNO);
    }

    /**
     * Sets <code>value</code> as attribute value for Sno using the alias name Sno.
     * @param value value to set the Sno
     */
    public void setSno(Integer value) {
        setAttributeInternal(SNO, value);
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