package com.imum.cpms.model.transactions.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 25 19:21:32 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InvDetailEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        InvDetailSeq {
            public Object get(InvDetailEOImpl obj) {
                return obj.getInvDetailSeq();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setInvDetailSeq((BigDecimal)value);
            }
        }
        ,
        Cardnum {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCardnum();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCardnum((String)value);
            }
        }
        ,
        LOcationid {
            public Object get(InvDetailEOImpl obj) {
                return obj.getLOcationid();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setLOcationid((String)value);
            }
        }
        ,
        DespatchdateCCO {
            public Object get(InvDetailEOImpl obj) {
                return obj.getDespatchdateCCO();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setDespatchdateCCO((Timestamp)value);
            }
        }
        ,
        ReceivedDateCSC {
            public Object get(InvDetailEOImpl obj) {
                return obj.getReceivedDateCSC();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setReceivedDateCSC((Timestamp)value);
            }
        }
        ,
        CardDenomAmt {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCardDenomAmt();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCardDenomAmt((BigDecimal)value);
            }
        }
        ,
        SaleDate {
            public Object get(InvDetailEOImpl obj) {
                return obj.getSaleDate();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setSaleDate((Timestamp)value);
            }
        }
        ,
        CustomerID {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCustomerID();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCustomerID((BigDecimal)value);
            }
        }
        ,
        OrgCardnum {
            public Object get(InvDetailEOImpl obj) {
                return obj.getOrgCardnum();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setOrgCardnum((String)value);
            }
        }
        ,
        RCCardactivedate {
            public Object get(InvDetailEOImpl obj) {
                return obj.getRCCardactivedate();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setRCCardactivedate((Timestamp)value);
            }
        }
        ,
        ExpiryDate {
            public Object get(InvDetailEOImpl obj) {
                return obj.getExpiryDate();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setExpiryDate((Timestamp)value);
            }
        }
        ,
        uploadcount {
            public Object get(InvDetailEOImpl obj) {
                return obj.getuploadcount();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setuploadcount((Integer)value);
            }
        }
        ,
        CreatedBy {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(InvDetailEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        CardStatusID {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCardStatusID();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCardStatusID((Integer)value);
            }
        }
        ,
        Updateddate {
            public Object get(InvDetailEOImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        CSAAssignedTo {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCSAAssignedTo();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCSAAssignedTo((String)value);
            }
        }
        ,
        CSAAssignedDate {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCSAAssignedDate();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCSAAssignedDate((Timestamp)value);
            }
        }
        ,
        Salehdrseq {
            public Object get(InvDetailEOImpl obj) {
                return obj.getSalehdrseq();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setSalehdrseq((BigDecimal)value);
            }
        }
        ,
        CardctgCode {
            public Object get(InvDetailEOImpl obj) {
                return obj.getCardctgCode();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setCardctgCode((Integer)value);
            }
        }
        ,
        SaleShiftID {
            public Object get(InvDetailEOImpl obj) {
                return obj.getSaleShiftID();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setSaleShiftID((Integer)value);
            }
        }
        ,
        BulkSaleFlag {
            public Object get(InvDetailEOImpl obj) {
                return obj.getBulkSaleFlag();
            }

            public void put(InvDetailEOImpl obj, Object value) {
                obj.setBulkSaleFlag((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(InvDetailEOImpl object);

        public abstract void put(InvDetailEOImpl object, Object value);

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


    public static final int INVDETAILSEQ = AttributesEnum.InvDetailSeq.index();
    public static final int CARDNUM = AttributesEnum.Cardnum.index();
    public static final int LOCATIONID = AttributesEnum.LOcationid.index();
    public static final int DESPATCHDATECCO = AttributesEnum.DespatchdateCCO.index();
    public static final int RECEIVEDDATECSC = AttributesEnum.ReceivedDateCSC.index();
    public static final int CARDDENOMAMT = AttributesEnum.CardDenomAmt.index();
    public static final int SALEDATE = AttributesEnum.SaleDate.index();
    public static final int CUSTOMERID = AttributesEnum.CustomerID.index();
    public static final int ORGCARDNUM = AttributesEnum.OrgCardnum.index();
    public static final int RCCARDACTIVEDATE = AttributesEnum.RCCardactivedate.index();
    public static final int EXPIRYDATE = AttributesEnum.ExpiryDate.index();
    public static final int UPLOADCOUNT = AttributesEnum.uploadcount.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int CARDSTATUSID = AttributesEnum.CardStatusID.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int CSAASSIGNEDTO = AttributesEnum.CSAAssignedTo.index();
    public static final int CSAASSIGNEDDATE = AttributesEnum.CSAAssignedDate.index();
    public static final int SALEHDRSEQ = AttributesEnum.Salehdrseq.index();
    public static final int CARDCTGCODE = AttributesEnum.CardctgCode.index();
    public static final int SALESHIFTID = AttributesEnum.SaleShiftID.index();
    public static final int BULKSALEFLAG = AttributesEnum.BulkSaleFlag.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InvDetailEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.transactions.eo.InvDetailEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for InvDetailSeq, using the alias name InvDetailSeq.
     * @return the InvDetailSeq
     */
    public BigDecimal getInvDetailSeq() {
        return (BigDecimal)getAttributeInternal(INVDETAILSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for InvDetailSeq.
     * @param value value to set the InvDetailSeq
     */
    public void setInvDetailSeq(BigDecimal value) {
        setAttributeInternal(INVDETAILSEQ, value);
    }

    /**
     * Gets the attribute value for Cardnum, using the alias name Cardnum.
     * @return the Cardnum
     */
    public String getCardnum() {
        return (String)getAttributeInternal(CARDNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Cardnum.
     * @param value value to set the Cardnum
     */
    public void setCardnum(String value) {
        setAttributeInternal(CARDNUM, value);
    }


    /**
     * Gets the attribute value for LOcationid, using the alias name LOcationid.
     * @return the LOcationid
     */
    public String getLOcationid() {
        return (String)getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LOcationid.
     * @param value value to set the LOcationid
     */
    public void setLOcationid(String value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for DespatchdateCCO, using the alias name DespatchdateCCO.
     * @return the DespatchdateCCO
     */
    public Timestamp getDespatchdateCCO() {
        return (Timestamp)getAttributeInternal(DESPATCHDATECCO);
    }

    /**
     * Sets <code>value</code> as the attribute value for DespatchdateCCO.
     * @param value value to set the DespatchdateCCO
     */
    public void setDespatchdateCCO(Timestamp value) {
        setAttributeInternal(DESPATCHDATECCO, value);
    }

    /**
     * Gets the attribute value for ReceivedDateCSC, using the alias name ReceivedDateCSC.
     * @return the ReceivedDateCSC
     */
    public Timestamp getReceivedDateCSC() {
        return (Timestamp)getAttributeInternal(RECEIVEDDATECSC);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReceivedDateCSC.
     * @param value value to set the ReceivedDateCSC
     */
    public void setReceivedDateCSC(Timestamp value) {
        setAttributeInternal(RECEIVEDDATECSC, value);
    }

    /**
     * Gets the attribute value for CardDenomAmt, using the alias name CardDenomAmt.
     * @return the CardDenomAmt
     */
    public BigDecimal getCardDenomAmt() {
        return (BigDecimal)getAttributeInternal(CARDDENOMAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardDenomAmt.
     * @param value value to set the CardDenomAmt
     */
    public void setCardDenomAmt(BigDecimal value) {
        setAttributeInternal(CARDDENOMAMT, value);
    }

    /**
     * Gets the attribute value for SaleDate, using the alias name SaleDate.
     * @return the SaleDate
     */
    public Timestamp getSaleDate() {
        return (Timestamp)getAttributeInternal(SALEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SaleDate.
     * @param value value to set the SaleDate
     */
    public void setSaleDate(Timestamp value) {
        setAttributeInternal(SALEDATE, value);
    }


    /**
     * Gets the attribute value for CustomerID, using the alias name CustomerID.
     * @return the CustomerID
     */
    public BigDecimal getCustomerID() {
        return (BigDecimal)getAttributeInternal(CUSTOMERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustomerID.
     * @param value value to set the CustomerID
     */
    public void setCustomerID(BigDecimal value) {
        setAttributeInternal(CUSTOMERID, value);
    }

    /**
     * Gets the attribute value for OrgCardnum, using the alias name OrgCardnum.
     * @return the OrgCardnum
     */
    public String getOrgCardnum() {
        return (String)getAttributeInternal(ORGCARDNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrgCardnum.
     * @param value value to set the OrgCardnum
     */
    public void setOrgCardnum(String value) {
        setAttributeInternal(ORGCARDNUM, value);
    }

    /**
     * Gets the attribute value for RCCardactivedate, using the alias name RCCardactivedate.
     * @return the RCCardactivedate
     */
    public Timestamp getRCCardactivedate() {
        return (Timestamp)getAttributeInternal(RCCARDACTIVEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for RCCardactivedate.
     * @param value value to set the RCCardactivedate
     */
    public void setRCCardactivedate(Timestamp value) {
        setAttributeInternal(RCCARDACTIVEDATE, value);
    }

    /**
     * Gets the attribute value for ExpiryDate, using the alias name ExpiryDate.
     * @return the ExpiryDate
     */
    public Timestamp getExpiryDate() {
        return (Timestamp)getAttributeInternal(EXPIRYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpiryDate.
     * @param value value to set the ExpiryDate
     */
    public void setExpiryDate(Timestamp value) {
        setAttributeInternal(EXPIRYDATE, value);
    }

    /**
     * Gets the attribute value for uploadcount, using the alias name uploadcount.
     * @return the uploadcount
     */
    public Integer getuploadcount() {
        return (Integer)getAttributeInternal(UPLOADCOUNT);
    }

    /**
     * Sets <code>value</code> as the attribute value for uploadcount.
     * @param value value to set the uploadcount
     */
    public void setuploadcount(Integer value) {
        setAttributeInternal(UPLOADCOUNT, value);
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
     * Gets the attribute value for CardStatusID, using the alias name CardStatusID.
     * @return the CardStatusID
     */
    public Integer getCardStatusID() {
        return (Integer)getAttributeInternal(CARDSTATUSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardStatusID.
     * @param value value to set the CardStatusID
     */
    public void setCardStatusID(Integer value) {
        setAttributeInternal(CARDSTATUSID, value);
    }

    /**
     * Gets the attribute value for Updateddate, using the alias name Updateddate.
     * @return the Updateddate
     */
    public Timestamp getUpdateddate() {
        return (Timestamp)getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Updateddate.
     * @param value value to set the Updateddate
     */
    public void setUpdateddate(Timestamp value) {
        setAttributeInternal(UPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for CSAAssignedTo, using the alias name CSAAssignedTo.
     * @return the CSAAssignedTo
     */
    public String getCSAAssignedTo() {
        return (String)getAttributeInternal(CSAASSIGNEDTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for CSAAssignedTo.
     * @param value value to set the CSAAssignedTo
     */
    public void setCSAAssignedTo(String value) {
        setAttributeInternal(CSAASSIGNEDTO, value);
    }

    /**
     * Gets the attribute value for CSAAssignedDate, using the alias name CSAAssignedDate.
     * @return the CSAAssignedDate
     */
    public Timestamp getCSAAssignedDate() {
        return (Timestamp)getAttributeInternal(CSAASSIGNEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CSAAssignedDate.
     * @param value value to set the CSAAssignedDate
     */
    public void setCSAAssignedDate(Timestamp value) {
        setAttributeInternal(CSAASSIGNEDDATE, value);
    }


    /**
     * Gets the attribute value for Salehdrseq, using the alias name Salehdrseq.
     * @return the Salehdrseq
     */
    public BigDecimal getSalehdrseq() {
        return (BigDecimal)getAttributeInternal(SALEHDRSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salehdrseq.
     * @param value value to set the Salehdrseq
     */
    public void setSalehdrseq(BigDecimal value) {
        setAttributeInternal(SALEHDRSEQ, value);
    }


    /**
     * Gets the attribute value for CardctgCode, using the alias name CardctgCode.
     * @return the CardctgCode
     */
    public Integer getCardctgCode() {
        return (Integer)getAttributeInternal(CARDCTGCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CardctgCode.
     * @param value value to set the CardctgCode
     */
    public void setCardctgCode(Integer value) {
        setAttributeInternal(CARDCTGCODE, value);
    }

    /**
     * Gets the attribute value for SaleShiftID, using the alias name SaleShiftID.
     * @return the SaleShiftID
     */
    public Integer getSaleShiftID() {
        return (Integer)getAttributeInternal(SALESHIFTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SaleShiftID.
     * @param value value to set the SaleShiftID
     */
    public void setSaleShiftID(Integer value) {
        setAttributeInternal(SALESHIFTID, value);
    }

    /**
     * Gets the attribute value for BulkSaleFlag, using the alias name BulkSaleFlag.
     * @return the BulkSaleFlag
     */
    public String getBulkSaleFlag() {
        return (String)getAttributeInternal(BULKSALEFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for BulkSaleFlag.
     * @param value value to set the BulkSaleFlag
     */
    public void setBulkSaleFlag(String value) {
        setAttributeInternal(BULKSALEFLAG, value);
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
     * @param invDetailSeq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal invDetailSeq) {
        return new Key(new Object[]{invDetailSeq});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
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