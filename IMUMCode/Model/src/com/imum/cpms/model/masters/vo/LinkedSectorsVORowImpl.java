package com.imum.cpms.model.masters.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Sep 28 12:21:31 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LinkedSectorsVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ActiveFlag,
        CreatedBy,
        CreatedDate,
        LINKEDSectorCode,
        LINKEDsectorSeq,
        SectorCode,
        Updatedby,
        Updateddate,
        SectorLovVO1,
        YesNoLovVO1;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

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


    public static final int ACTIVEFLAG = AttributesEnum.ActiveFlag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LINKEDSECTORCODE = AttributesEnum.LINKEDSectorCode.index();
    public static final int LINKEDSECTORSEQ = AttributesEnum.LINKEDsectorSeq.index();
    public static final int SECTORCODE = AttributesEnum.SectorCode.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int SECTORLOVVO1 = AttributesEnum.SectorLovVO1.index();
    public static final int YESNOLOVVO1 = AttributesEnum.YesNoLovVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LinkedSectorsVORowImpl() {
    }

    /**
     * Gets LinkedSectorsEO entity object.
     * @return the LinkedSectorsEO
     */
    public EntityImpl getLinkedSectorsEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Active_Flag using the alias name ActiveFlag.
     * @return the Active_Flag
     */
    public String getActiveFlag() {
        return (String) getAttributeInternal(ACTIVEFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for Active_Flag using the alias name ActiveFlag.
     * @param value value to set the Active_Flag
     */
    public void setActiveFlag(String value) {
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
     * Gets the attribute value for LINKED_Sector_Code using the alias name LINKEDSectorCode.
     * @return the LINKED_Sector_Code
     */
    public String getLINKEDSectorCode() {
        return (String) getAttributeInternal(LINKEDSECTORCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for LINKED_Sector_Code using the alias name LINKEDSectorCode.
     * @param value value to set the LINKED_Sector_Code
     */
    public void setLINKEDSectorCode(String value) {
        setAttributeInternal(LINKEDSECTORCODE, value);
    }

    /**
     * Gets the attribute value for LINKED_sector_Seq using the alias name LINKEDsectorSeq.
     * @return the LINKED_sector_Seq
     */
    public BigDecimal getLINKEDsectorSeq() {
        return (BigDecimal) getAttributeInternal(LINKEDSECTORSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for LINKED_sector_Seq using the alias name LINKEDsectorSeq.
     * @param value value to set the LINKED_sector_Seq
     */
    public void setLINKEDsectorSeq(BigDecimal value) {
        setAttributeInternal(LINKEDSECTORSEQ, value);
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
}
