package com.imum.cpms.model.transactions.eo;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Date;
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
// ---    Fri Sep 05 18:29:12 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SalesDetailEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        SaleDtlseq {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getSaleDtlseq();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setSaleDtlseq((BigDecimal)value);
            }
        }
        ,
        Salehdrseq {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getSalehdrseq();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setSalehdrseq((BigDecimal)value);
            }
        }
        ,
        Prodcode {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getProdcode();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setProdcode((BigDecimal)value);
            }
        }
        ,
        Cardnumfrom {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getCardnumfrom();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setCardnumfrom((String)value);
            }
        }
        ,
        Cardnumto {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getCardnumto();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setCardnumto((String)value);
            }
        }
        ,
        ParkingCardEXPDATE {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getParkingCardEXPDATE();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setParkingCardEXPDATE((Date)value);
            }
        }
        ,
        OrgCardnum {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getOrgCardnum();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setOrgCardnum((BigDecimal)value);
            }
        }
        ,
        PromoDiscCode {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getPromoDiscCode();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setPromoDiscCode((String)value);
            }
        }
        ,
        ReplacementReason {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getReplacementReason();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setReplacementReason((String)value);
            }
        }
        ,
        PRMHeaderseq {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getPRMHeaderseq();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setPRMHeaderseq((BigDecimal)value);
            }
        }
        ,
        SaleAmt {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getSaleAmt();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setSaleAmt((BigDecimal)value);
            }
        }
        ,
        DiscAmt {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getDiscAmt();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setDiscAmt((BigDecimal)value);
            }
        }
        ,
        CreatedBy {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        Updatedby {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updatedate {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getUpdatedate();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setUpdatedate((Timestamp)value);
            }
        }
        ,
        Updateddate {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ,
        ActionCode {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getActionCode();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setActionCode((Integer)value);
            }
        }
        ,
        InstQuotaseq {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getInstQuotaseq();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setInstQuotaseq((BigDecimal)value);
            }
        }
        ,
        RCMobileNum {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getRCMobileNum();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setRCMobileNum((String)value);
            }
        }
        ,
        LineComments {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getLineComments();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setLineComments((String)value);
            }
        }
        ,
        PVTHDRSEQ {
            public Object get(SalesDetailEOImpl obj) {
                return obj.getPVTHDRSEQ();
            }

            public void put(SalesDetailEOImpl obj, Object value) {
                obj.setPVTHDRSEQ((BigDecimal)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SalesDetailEOImpl object);

        public abstract void put(SalesDetailEOImpl object, Object value);

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


    public static final int SALEDTLSEQ = AttributesEnum.SaleDtlseq.index();
    public static final int SALEHDRSEQ = AttributesEnum.Salehdrseq.index();
    public static final int PRODCODE = AttributesEnum.Prodcode.index();
    public static final int CARDNUMFROM = AttributesEnum.Cardnumfrom.index();
    public static final int CARDNUMTO = AttributesEnum.Cardnumto.index();
    public static final int PARKINGCARDEXPDATE = AttributesEnum.ParkingCardEXPDATE.index();
    public static final int ORGCARDNUM = AttributesEnum.OrgCardnum.index();
    public static final int PROMODISCCODE = AttributesEnum.PromoDiscCode.index();
    public static final int REPLACEMENTREASON = AttributesEnum.ReplacementReason.index();
    public static final int PRMHEADERSEQ = AttributesEnum.PRMHeaderseq.index();
    public static final int SALEAMT = AttributesEnum.SaleAmt.index();
    public static final int DISCAMT = AttributesEnum.DiscAmt.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.Updatedby.index();
    public static final int UPDATEDATE = AttributesEnum.Updatedate.index();
    public static final int UPDATEDDATE = AttributesEnum.Updateddate.index();
    public static final int ACTIONCODE = AttributesEnum.ActionCode.index();
    public static final int INSTQUOTASEQ = AttributesEnum.InstQuotaseq.index();
    public static final int RCMOBILENUM = AttributesEnum.RCMobileNum.index();
    public static final int LINECOMMENTS = AttributesEnum.LineComments.index();
    public static final int PVTHDRSEQ = AttributesEnum.PVTHDRSEQ.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SalesDetailEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("com.imum.cpms.model.transactions.eo.SalesDetailEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for SaleDtlseq, using the alias name SaleDtlseq.
     * @return the SaleDtlseq
     */
    public BigDecimal getSaleDtlseq() {
        return (BigDecimal)getAttributeInternal(SALEDTLSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for SaleDtlseq.
     * @param value value to set the SaleDtlseq
     */
    public void setSaleDtlseq(BigDecimal value) {
        setAttributeInternal(SALEDTLSEQ, value);
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
     * Gets the attribute value for Prodcode, using the alias name Prodcode.
     * @return the Prodcode
     */
    public BigDecimal getProdcode() {
        return (BigDecimal)getAttributeInternal(PRODCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Prodcode.
     * @param value value to set the Prodcode
     */
    public void setProdcode(BigDecimal value) {
        setAttributeInternal(PRODCODE, value);
    }

    /**
     * Gets the attribute value for Cardnumfrom, using the alias name Cardnumfrom.
     * @return the Cardnumfrom
     */
    public String getCardnumfrom() {
        return (String)getAttributeInternal(CARDNUMFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Cardnumfrom.
     * @param value value to set the Cardnumfrom
     */
    public void setCardnumfrom(String value) {
        setAttributeInternal(CARDNUMFROM, value);
    }

    /**
     * Gets the attribute value for Cardnumto, using the alias name Cardnumto.
     * @return the Cardnumto
     */
    public String getCardnumto() {
        return (String)getAttributeInternal(CARDNUMTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Cardnumto.
     * @param value value to set the Cardnumto
     */
    public void setCardnumto(String value) {
        setAttributeInternal(CARDNUMTO, value);
    }

    /**
     * Gets the attribute value for ParkingCardEXPDATE, using the alias name ParkingCardEXPDATE.
     * @return the ParkingCardEXPDATE
     */
    public Date getParkingCardEXPDATE() {
        return (Date)getAttributeInternal(PARKINGCARDEXPDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ParkingCardEXPDATE.
     * @param value value to set the ParkingCardEXPDATE
     */
    public void setParkingCardEXPDATE(Date value) {
        setAttributeInternal(PARKINGCARDEXPDATE, value);
    }

    /**
     * Gets the attribute value for OrgCardnum, using the alias name OrgCardnum.
     * @return the OrgCardnum
     */
    public BigDecimal getOrgCardnum() {
        return (BigDecimal)getAttributeInternal(ORGCARDNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrgCardnum.
     * @param value value to set the OrgCardnum
     */
    public void setOrgCardnum(BigDecimal value) {
        setAttributeInternal(ORGCARDNUM, value);
    }

    /**
     * Gets the attribute value for PromoDiscCode, using the alias name PromoDiscCode.
     * @return the PromoDiscCode
     */
    public String getPromoDiscCode() {
        return (String)getAttributeInternal(PROMODISCCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PromoDiscCode.
     * @param value value to set the PromoDiscCode
     */
    public void setPromoDiscCode(String value) {
        setAttributeInternal(PROMODISCCODE, value);
    }

    /**
     * Gets the attribute value for ReplacementReason, using the alias name ReplacementReason.
     * @return the ReplacementReason
     */
    public String getReplacementReason() {
        return (String)getAttributeInternal(REPLACEMENTREASON);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReplacementReason.
     * @param value value to set the ReplacementReason
     */
    public void setReplacementReason(String value) {
        setAttributeInternal(REPLACEMENTREASON, value);
    }

    /**
     * Gets the attribute value for PRMHeaderseq, using the alias name PRMHeaderseq.
     * @return the PRMHeaderseq
     */
    public BigDecimal getPRMHeaderseq() {
        return (BigDecimal)getAttributeInternal(PRMHEADERSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for PRMHeaderseq.
     * @param value value to set the PRMHeaderseq
     */
    public void setPRMHeaderseq(BigDecimal value) {
        setAttributeInternal(PRMHEADERSEQ, value);
    }


    /**
     * Gets the attribute value for SaleAmt, using the alias name SaleAmt.
     * @return the SaleAmt
     */
    public BigDecimal getSaleAmt() {
        return (BigDecimal)getAttributeInternal(SALEAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for SaleAmt.
     * @param value value to set the SaleAmt
     */
    public void setSaleAmt(BigDecimal value) {
        setAttributeInternal(SALEAMT, value);
    }

    /**
     * Gets the attribute value for DiscAmt, using the alias name DiscAmt.
     * @return the DiscAmt
     */
    public BigDecimal getDiscAmt() {
        return (BigDecimal)getAttributeInternal(DISCAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for DiscAmt.
     * @param value value to set the DiscAmt
     */
    public void setDiscAmt(BigDecimal value) {
        setAttributeInternal(DISCAMT, value);
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
     * Gets the attribute value for ActionCode, using the alias name ActionCode.
     * @return the ActionCode
     */
    public Integer getActionCode() {
        return (Integer)getAttributeInternal(ACTIONCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ActionCode.
     * @param value value to set the ActionCode
     */
    public void setActionCode(Integer value) {
        setAttributeInternal(ACTIONCODE, value);
    }

    /**
     * Gets the attribute value for InstQuotaseq, using the alias name InstQuotaseq.
     * @return the InstQuotaseq
     */
    public BigDecimal getInstQuotaseq() {
        return (BigDecimal)getAttributeInternal(INSTQUOTASEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for InstQuotaseq.
     * @param value value to set the InstQuotaseq
     */
    public void setInstQuotaseq(BigDecimal value) {
        setAttributeInternal(INSTQUOTASEQ, value);
    }

    /**
     * Gets the attribute value for RCMobileNum, using the alias name RCMobileNum.
     * @return the RCMobileNum
     */
    public String getRCMobileNum() {
        return (String)getAttributeInternal(RCMOBILENUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for RCMobileNum.
     * @param value value to set the RCMobileNum
     */
    public void setRCMobileNum(String value) {
        setAttributeInternal(RCMOBILENUM, value);
    }

    /**
     * Gets the attribute value for LineComments, using the alias name LineComments.
     * @return the LineComments
     */
    public String getLineComments() {
        return (String)getAttributeInternal(LINECOMMENTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for LineComments.
     * @param value value to set the LineComments
     */
    public void setLineComments(String value) {
        setAttributeInternal(LINECOMMENTS, value);
    }

    /**
     * Gets the attribute value for PVTHDRSEQ, using the alias name PVTHDRSEQ.
     * @return the PVTHDRSEQ
     */
    public BigDecimal getPVTHDRSEQ() {
        return (BigDecimal)getAttributeInternal(PVTHDRSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for PVTHDRSEQ.
     * @param value value to set the PVTHDRSEQ
     */
    public void setPVTHDRSEQ(BigDecimal value) {
        setAttributeInternal(PVTHDRSEQ, value);
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
     * @param saleDtlseq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal saleDtlseq) {
        return new Key(new Object[]{saleDtlseq});
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
            stmt.setString(1, "SALE_DTL_SEQ");            
            stmt.registerOutParameter(2, Types.BIGINT);
            stmt.execute();           
            BigDecimal SeqNum = stmt.getBigDecimal(2);
            setSaleDtlseq(SeqNum);
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
