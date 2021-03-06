package com.imum.cpms.model.staffdeploy.vo;

import com.imum.cpms.model.staffdeploy.eo.HHCAssignEOImpl;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Mar 15 17:45:27 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HHCAssignVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        AssignedStatus {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getAssignedStatus();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setAssignedStatus((String)value);
            }
        }
        ,
        CoOrdinator {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getCoOrdinator();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setCoOrdinator((String)value);
            }
        }
        ,
        Comments {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getComments();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setComments((String)value);
            }
        }
        ,
        HHCID {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getHHCID();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setHHCID((String)value);
            }
        }
        ,
        ID {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getID();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setID((Integer)value);
            }
        }
        ,
        IssuedDate1 {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getIssuedDate1();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setIssuedDate1((Timestamp)value);
            }
        }
        ,
        Locationid {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getLocationid();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setLocationid((Integer)value);
            }
        }
        ,
        PIID {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getPIID();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setPIID((String)value);
            }
        }
        ,
        Reassignedby {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getReassignedby();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setReassignedby((String)value);
            }
        }
        ,
        RecievedDate {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getRecievedDate();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setRecievedDate((Timestamp)value);
            }
        }
        ,
        Status {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getStatus();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setStatus((String)value);
            }
        }
        ,
        Shift {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getShift();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setShift((Integer)value);
            }
        }
        ,
        IssuedDate2 {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getIssuedDate2();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setIssuedDate2((Timestamp)value);
            }
        }
        ,
        PrinterIssuedDate {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getPrinterIssuedDate();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setPrinterIssuedDate((Timestamp)value);
            }
        }
        ,
        PrinterIssuedstatusCode {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getPrinterIssuedstatusCode();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setPrinterIssuedstatusCode((String)value);
            }
        }
        ,
        PrinterReceivedDate {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getPrinterReceivedDate();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setPrinterReceivedDate((Timestamp)value);
            }
        }
        ,
        PrinterReturnCondition {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getPrinterReturnCondition();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setPrinterReturnCondition((Integer)value);
            }
        }
        ,
        PrinterSNo {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getPrinterSNo();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setPrinterSNo((String)value);
            }
        }
        ,
        HHSNo {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getHHSNo();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setHHSNo((String)value);
            }
        }
        ,
        HHCReturnCondition {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getHHCReturnCondition();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setHHCReturnCondition((Integer)value);
            }
        }
        ,
        CreatedBy {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        Createddate {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getCreateddate();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setCreateddate((Timestamp)value);
            }
        }
        ,
        Updateddate {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        updatedby {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getupdatedby();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setupdatedby((String)value);
            }
        }
        ,
        pilistVO1 {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getpilistVO1();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        shiftlistVO1 {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getshiftlistVO1();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        GenLocationLOVVO1 {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getGenLocationLOVVO1();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        GenpiShiftMstVO1 {
            public Object get(HHCAssignVORowImpl obj) {
                return obj.getGenpiShiftMstVO1();
            }

            public void put(HHCAssignVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(HHCAssignVORowImpl object);

        public abstract void put(HHCAssignVORowImpl object, Object value);

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


    public static final int ASSIGNEDSTATUS = AttributesEnum.AssignedStatus.index();
    public static final int COORDINATOR = AttributesEnum.CoOrdinator.index();
    public static final int COMMENTS = AttributesEnum.Comments.index();
    public static final int HHCID = AttributesEnum.HHCID.index();
    public static final int ID = AttributesEnum.ID.index();
    public static final int ISSUEDDATE1 = AttributesEnum.IssuedDate1.index();
    public static final int LOCATIONID = AttributesEnum.Locationid.index();
    public static final int PIID = AttributesEnum.PIID.index();
    public static final int REASSIGNEDBY = AttributesEnum.Reassignedby.index();
    public static final int RECIEVEDDATE = AttributesEnum.RecievedDate.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int SHIFT = AttributesEnum.Shift.index();
    public static final int ISSUEDDATE2 = AttributesEnum.IssuedDate2.index();
    public static final int PRINTERISSUEDDATE = AttributesEnum.PrinterIssuedDate.index();
    public static final int PRINTERISSUEDSTATUSCODE = AttributesEnum.PrinterIssuedstatusCode.index();
    public static final int PRINTERRECEIVEDDATE = AttributesEnum.PrinterReceivedDate.index();
    public static final int PRINTERRETURNCONDITION = AttributesEnum.PrinterReturnCondition.index();
    public static final int PRINTERSNO = AttributesEnum.PrinterSNo.index();
    public static final int HHSNO = AttributesEnum.HHSNo.index();
    public static final int HHCRETURNCONDITION = AttributesEnum.HHCReturnCondition.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.Createddate.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int UPDATEDBY = AttributesEnum.updatedby.index();
    public static final int PILISTVO1 = AttributesEnum.pilistVO1.index();
    public static final int SHIFTLISTVO1 = AttributesEnum.shiftlistVO1.index();
    public static final int GENLOCATIONLOVVO1 = AttributesEnum.GenLocationLOVVO1.index();
    public static final int GENPISHIFTMSTVO1 = AttributesEnum.GenpiShiftMstVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public HHCAssignVORowImpl() {
    }

    /**
     * Gets HHCAssignEO entity object.
     * @return the HHCAssignEO
     */
    public HHCAssignEOImpl getHHCAssignEO() {
        return (HHCAssignEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Assigned_Status using the alias name AssignedStatus.
     * @return the Assigned_Status
     */
    public String getAssignedStatus() {
        return (String) getAttributeInternal(ASSIGNEDSTATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for Assigned_Status using the alias name AssignedStatus.
     * @param value value to set the Assigned_Status
     */
    public void setAssignedStatus(String value) {
        setAttributeInternal(ASSIGNEDSTATUS, value);
    }

    /**
     * Gets the attribute value for CoOrdinator using the alias name CoOrdinator.
     * @return the CoOrdinator
     */
    public String getCoOrdinator() {
        return (String) getAttributeInternal(COORDINATOR);
    }

    /**
     * Sets <code>value</code> as attribute value for CoOrdinator using the alias name CoOrdinator.
     * @param value value to set the CoOrdinator
     */
    public void setCoOrdinator(String value) {
        setAttributeInternal(COORDINATOR, value);
    }

    /**
     * Gets the attribute value for Comments using the alias name Comments.
     * @return the Comments
     */
    public String getComments() {
        return (String) getAttributeInternal(COMMENTS);
    }

    /**
     * Sets <code>value</code> as attribute value for Comments using the alias name Comments.
     * @param value value to set the Comments
     */
    public void setComments(String value) {
        setAttributeInternal(COMMENTS, value);
    }

    /**
     * Gets the attribute value for HHC_ID using the alias name HHCID.
     * @return the HHC_ID
     */
    public String getHHCID() {
        return (String) getAttributeInternal(HHCID);
    }

    /**
     * Sets <code>value</code> as attribute value for HHC_ID using the alias name HHCID.
     * @param value value to set the HHC_ID
     */
    public void setHHCID(String value) {
        setAttributeInternal(HHCID, value);
    }

    /**
     * Gets the attribute value for ID using the alias name ID.
     * @return the ID
     */
    public Integer getID() {
        return (Integer) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name ID.
     * @param value value to set the ID
     */
    public void setID(Integer value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for Issued_Date using the alias name IssuedDate1.
     * @return the Issued_Date
     */
    public Timestamp getIssuedDate1() {
        return (Timestamp) getAttributeInternal(ISSUEDDATE1);
    }

    /**
     * Sets <code>value</code> as attribute value for Issued_Date using the alias name IssuedDate1.
     * @param value value to set the Issued_Date
     */
    public void setIssuedDate1(Timestamp value) {
        setAttributeInternal(ISSUEDDATE1, value);
    }

    /**
     * Gets the attribute value for Locationid using the alias name Locationid.
     * @return the Locationid
     */
    public Integer getLocationid() {
        return (Integer) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for Locationid using the alias name Locationid.
     * @param value value to set the Locationid
     */
    public void setLocationid(Integer value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for PI_ID using the alias name PIID.
     * @return the PI_ID
     */
    public String getPIID() {
        return (String) getAttributeInternal(PIID);
    }

    /**
     * Sets <code>value</code> as attribute value for PI_ID using the alias name PIID.
     * @param value value to set the PI_ID
     */
    public void setPIID(String value) {
        setAttributeInternal(PIID, value);
    }

    /**
     * Gets the attribute value for Reassignedby using the alias name Reassignedby.
     * @return the Reassignedby
     */
    public String getReassignedby() {
        return (String) getAttributeInternal(REASSIGNEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for Reassignedby using the alias name Reassignedby.
     * @param value value to set the Reassignedby
     */
    public void setReassignedby(String value) {
        setAttributeInternal(REASSIGNEDBY, value);
    }

    /**
     * Gets the attribute value for Recieved_Date using the alias name RecievedDate.
     * @return the Recieved_Date
     */
    public Timestamp getRecievedDate() {
        return (Timestamp) getAttributeInternal(RECIEVEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Recieved_Date using the alias name RecievedDate.
     * @param value value to set the Recieved_Date
     */
    public void setRecievedDate(Timestamp value) {
        setAttributeInternal(RECIEVEDDATE, value);
    }

    /**
     * Gets the attribute value for Status using the alias name Status.
     * @return the Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for Status using the alias name Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for Shift using the alias name Shift.
     * @return the Shift
     */
    public Integer getShift() {
        return (Integer) getAttributeInternal(SHIFT);
    }

    /**
     * Sets <code>value</code> as attribute value for Shift using the alias name Shift.
     * @param value value to set the Shift
     */
    public void setShift(Integer value) {
        setAttributeInternal(SHIFT, value);
    }

    /**
     * Gets the attribute value for IssuedDate using the alias name IssuedDate2.
     * @return the IssuedDate
     */
    public Timestamp getIssuedDate2() {
        return (Timestamp) getAttributeInternal(ISSUEDDATE2);
    }

    /**
     * Sets <code>value</code> as attribute value for IssuedDate using the alias name IssuedDate2.
     * @param value value to set the IssuedDate
     */
    public void setIssuedDate2(Timestamp value) {
        setAttributeInternal(ISSUEDDATE2, value);
    }

    /**
     * Gets the attribute value for Printer_Issued_Date using the alias name PrinterIssuedDate.
     * @return the Printer_Issued_Date
     */
    public Timestamp getPrinterIssuedDate() {
        return (Timestamp) getAttributeInternal(PRINTERISSUEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Printer_Issued_Date using the alias name PrinterIssuedDate.
     * @param value value to set the Printer_Issued_Date
     */
    public void setPrinterIssuedDate(Timestamp value) {
        setAttributeInternal(PRINTERISSUEDDATE, value);
    }

    /**
     * Gets the attribute value for Printer_Issued_status_Code using the alias name PrinterIssuedstatusCode.
     * @return the Printer_Issued_status_Code
     */
    public String getPrinterIssuedstatusCode() {
        return (String) getAttributeInternal(PRINTERISSUEDSTATUSCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for Printer_Issued_status_Code using the alias name PrinterIssuedstatusCode.
     * @param value value to set the Printer_Issued_status_Code
     */
    public void setPrinterIssuedstatusCode(String value) {
        setAttributeInternal(PRINTERISSUEDSTATUSCODE, value);
    }

    /**
     * Gets the attribute value for Printer_Received_Date using the alias name PrinterReceivedDate.
     * @return the Printer_Received_Date
     */
    public Timestamp getPrinterReceivedDate() {
        return (Timestamp) getAttributeInternal(PRINTERRECEIVEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Printer_Received_Date using the alias name PrinterReceivedDate.
     * @param value value to set the Printer_Received_Date
     */
    public void setPrinterReceivedDate(Timestamp value) {
        setAttributeInternal(PRINTERRECEIVEDDATE, value);
    }

    /**
     * Gets the attribute value for Printer_Return_Condition using the alias name PrinterReturnCondition.
     * @return the Printer_Return_Condition
     */
    public Integer getPrinterReturnCondition() {
        return (Integer) getAttributeInternal(PRINTERRETURNCONDITION);
    }

    /**
     * Sets <code>value</code> as attribute value for Printer_Return_Condition using the alias name PrinterReturnCondition.
     * @param value value to set the Printer_Return_Condition
     */
    public void setPrinterReturnCondition(Integer value) {
        setAttributeInternal(PRINTERRETURNCONDITION, value);
    }

    /**
     * Gets the attribute value for Printer_SNo using the alias name PrinterSNo.
     * @return the Printer_SNo
     */
    public String getPrinterSNo() {
        return (String) getAttributeInternal(PRINTERSNO);
    }

    /**
     * Sets <code>value</code> as attribute value for Printer_SNo using the alias name PrinterSNo.
     * @param value value to set the Printer_SNo
     */
    public void setPrinterSNo(String value) {
        setAttributeInternal(PRINTERSNO, value);
    }

    /**
     * Gets the attribute value for HH_SNo using the alias name HHSNo.
     * @return the HH_SNo
     */
    public String getHHSNo() {
        return (String) getAttributeInternal(HHSNO);
    }

    /**
     * Sets <code>value</code> as attribute value for HH_SNo using the alias name HHSNo.
     * @param value value to set the HH_SNo
     */
    public void setHHSNo(String value) {
        setAttributeInternal(HHSNO, value);
    }

    /**
     * Gets the attribute value for HHC_Return_Condition using the alias name HHCReturnCondition.
     * @return the HHC_Return_Condition
     */
    public Integer getHHCReturnCondition() {
        return (Integer) getAttributeInternal(HHCRETURNCONDITION);
    }

    /**
     * Sets <code>value</code> as attribute value for HHC_Return_Condition using the alias name HHCReturnCondition.
     * @param value value to set the HHC_Return_Condition
     */
    public void setHHCReturnCondition(Integer value) {
        setAttributeInternal(HHCRETURNCONDITION, value);
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
     * Gets the attribute value for Created_date using the alias name Createddate.
     * @return the Created_date
     */
    public Timestamp getCreateddate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Created_date using the alias name Createddate.
     * @param value value to set the Created_date
     */
    public void setCreateddate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
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
     * Gets the attribute value for updated_by using the alias name updatedby.
     * @return the updated_by
     */
    public String getupdatedby() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for updated_by using the alias name updatedby.
     * @param value value to set the updated_by
     */
    public void setupdatedby(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> pilistVO1.
     */
    public RowSet getpilistVO1() {
        return (RowSet)getAttributeInternal(PILISTVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> shiftlistVO1.
     */
    public RowSet getshiftlistVO1() {
        return (RowSet)getAttributeInternal(SHIFTLISTVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> GenLocationLOVVO1.
     */
    public RowSet getGenLocationLOVVO1() {
        return (RowSet)getAttributeInternal(GENLOCATIONLOVVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> GenpiShiftMstVO1.
     */
    public RowSet getGenpiShiftMstVO1() {
        return (RowSet)getAttributeInternal(GENPISHIFTMSTVO1);
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
