package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Aug 18 13:52:57 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MyAssignmentsEmailVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        BccEmailid {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getBccEmailid();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setBccEmailid((String)value);
            }
        }
        ,
        CcEmailid {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getCcEmailid();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setCcEmailid((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        EmailLang {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getEmailLang();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setEmailLang((String)value);
            }
        }
        ,
        EmailRelayseq {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getEmailRelayseq();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setEmailRelayseq((BigDecimal)value);
            }
        }
        ,
        EmailSubj {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getEmailSubj();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setEmailSubj((String)value);
            }
        }
        ,
        EmailText {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getEmailText();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setEmailText((String)value);
            }
        }
        ,
        Retrycount {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getRetrycount();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setRetrycount((Integer)value);
            }
        }
        ,
        Retryerror {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getRetryerror();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setRetryerror((String)value);
            }
        }
        ,
        SendStatus {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getSendStatus();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setSendStatus((Integer)value);
            }
        }
        ,
        Sentdate {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getSentdate();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setSentdate((Timestamp)value);
            }
        }
        ,
        Srceventid {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getSrceventid();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setSrceventid((BigDecimal)value);
            }
        }
        ,
        Srcmodule {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getSrcmodule();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setSrcmodule((Integer)value);
            }
        }
        ,
        Srctxnref {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getSrctxnref();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setSrctxnref((BigDecimal)value);
            }
        }
        ,
        ToEmailid {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getToEmailid();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setToEmailid((String)value);
            }
        }
        ,
        Updatedby {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getUpdatedby();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setUpdatedby((String)value);
            }
        }
        ,
        Updateddate {
            public Object get(MyAssignmentsEmailVORowImpl obj) {
                return obj.getUpdateddate();
            }

            public void put(MyAssignmentsEmailVORowImpl obj, Object value) {
                obj.setUpdateddate((Timestamp)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(MyAssignmentsEmailVORowImpl object);

        public abstract void put(MyAssignmentsEmailVORowImpl object,
                                 Object value);

        public int index() {
            return MyAssignmentsEmailVORowImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return MyAssignmentsEmailVORowImpl.AttributesEnum.firstIndex() + MyAssignmentsEmailVORowImpl.AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = MyAssignmentsEmailVORowImpl.AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int BCCEMAILID = MyAssignmentsEmailVORowImpl.AttributesEnum.BccEmailid.index();
    public static final int CCEMAILID = MyAssignmentsEmailVORowImpl.AttributesEnum.CcEmailid.index();
    public static final int CREATEDBY = MyAssignmentsEmailVORowImpl.AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = MyAssignmentsEmailVORowImpl.AttributesEnum.CreatedDate.index();
    public static final int EMAILLANG = MyAssignmentsEmailVORowImpl.AttributesEnum.EmailLang.index();
    public static final int EMAILRELAYSEQ = MyAssignmentsEmailVORowImpl.AttributesEnum.EmailRelayseq.index();
    public static final int EMAILSUBJ = MyAssignmentsEmailVORowImpl.AttributesEnum.EmailSubj.index();
    public static final int EMAILTEXT = MyAssignmentsEmailVORowImpl.AttributesEnum.EmailText.index();
    public static final int RETRYCOUNT = MyAssignmentsEmailVORowImpl.AttributesEnum.Retrycount.index();
    public static final int RETRYERROR = MyAssignmentsEmailVORowImpl.AttributesEnum.Retryerror.index();
    public static final int SENDSTATUS = MyAssignmentsEmailVORowImpl.AttributesEnum.SendStatus.index();
    public static final int SENTDATE = MyAssignmentsEmailVORowImpl.AttributesEnum.Sentdate.index();
    public static final int SRCEVENTID = MyAssignmentsEmailVORowImpl.AttributesEnum.Srceventid.index();
    public static final int SRCMODULE = MyAssignmentsEmailVORowImpl.AttributesEnum.Srcmodule.index();
    public static final int SRCTXNREF = MyAssignmentsEmailVORowImpl.AttributesEnum.Srctxnref.index();
    public static final int TOEMAILID = MyAssignmentsEmailVORowImpl.AttributesEnum.ToEmailid.index();
    public static final int UPDATEDBY = MyAssignmentsEmailVORowImpl.AttributesEnum.Updatedby.index();
    public static final int UPDATEDDATE = MyAssignmentsEmailVORowImpl.AttributesEnum.Updateddate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MyAssignmentsEmailVORowImpl() {
    }

    /**
     * Gets MyAssignmentsEmailEO entity object.
     * @return the MyAssignmentsEmailEO
     */
    public EntityImpl getMyAssignmentsEmailEO() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for Bcc_Email_id using the alias name BccEmailid.
     * @return the Bcc_Email_id
     */
    public String getBccEmailid() {
        return (String) getAttributeInternal(BCCEMAILID);
    }

    /**
     * Sets <code>value</code> as attribute value for Bcc_Email_id using the alias name BccEmailid.
     * @param value value to set the Bcc_Email_id
     */
    public void setBccEmailid(String value) {
        setAttributeInternal(BCCEMAILID, value);
    }

    /**
     * Gets the attribute value for Cc_Email_id using the alias name CcEmailid.
     * @return the Cc_Email_id
     */
    public String getCcEmailid() {
        return (String) getAttributeInternal(CCEMAILID);
    }

    /**
     * Sets <code>value</code> as attribute value for Cc_Email_id using the alias name CcEmailid.
     * @param value value to set the Cc_Email_id
     */
    public void setCcEmailid(String value) {
        setAttributeInternal(CCEMAILID, value);
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
     * Gets the attribute value for Email_Lang using the alias name EmailLang.
     * @return the Email_Lang
     */
    public String getEmailLang() {
        return (String) getAttributeInternal(EMAILLANG);
    }

    /**
     * Sets <code>value</code> as attribute value for Email_Lang using the alias name EmailLang.
     * @param value value to set the Email_Lang
     */
    public void setEmailLang(String value) {
        setAttributeInternal(EMAILLANG, value);
    }

    /**
     * Gets the attribute value for Email_Relay_seq using the alias name EmailRelayseq.
     * @return the Email_Relay_seq
     */
    public BigDecimal getEmailRelayseq() {
        return (BigDecimal) getAttributeInternal(EMAILRELAYSEQ);
    }

    /**
     * Sets <code>value</code> as attribute value for Email_Relay_seq using the alias name EmailRelayseq.
     * @param value value to set the Email_Relay_seq
     */
    public void setEmailRelayseq(BigDecimal value) {
        setAttributeInternal(EMAILRELAYSEQ, value);
    }

    /**
     * Gets the attribute value for Email_Subj using the alias name EmailSubj.
     * @return the Email_Subj
     */
    public String getEmailSubj() {
        return (String) getAttributeInternal(EMAILSUBJ);
    }

    /**
     * Sets <code>value</code> as attribute value for Email_Subj using the alias name EmailSubj.
     * @param value value to set the Email_Subj
     */
    public void setEmailSubj(String value) {
        setAttributeInternal(EMAILSUBJ, value);
    }

    /**
     * Gets the attribute value for Email_Text using the alias name EmailText.
     * @return the Email_Text
     */
    public String getEmailText() {
        return (String) getAttributeInternal(EMAILTEXT);
    }

    /**
     * Sets <code>value</code> as attribute value for Email_Text using the alias name EmailText.
     * @param value value to set the Email_Text
     */
    public void setEmailText(String value) {
        setAttributeInternal(EMAILTEXT, value);
    }

    /**
     * Gets the attribute value for Retry_count using the alias name Retrycount.
     * @return the Retry_count
     */
    public Integer getRetrycount() {
        return (Integer) getAttributeInternal(RETRYCOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for Retry_count using the alias name Retrycount.
     * @param value value to set the Retry_count
     */
    public void setRetrycount(Integer value) {
        setAttributeInternal(RETRYCOUNT, value);
    }

    /**
     * Gets the attribute value for Retry_error using the alias name Retryerror.
     * @return the Retry_error
     */
    public String getRetryerror() {
        return (String) getAttributeInternal(RETRYERROR);
    }

    /**
     * Sets <code>value</code> as attribute value for Retry_error using the alias name Retryerror.
     * @param value value to set the Retry_error
     */
    public void setRetryerror(String value) {
        setAttributeInternal(RETRYERROR, value);
    }

    /**
     * Gets the attribute value for Send_Status using the alias name SendStatus.
     * @return the Send_Status
     */
    public Integer getSendStatus() {
        return (Integer) getAttributeInternal(SENDSTATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for Send_Status using the alias name SendStatus.
     * @param value value to set the Send_Status
     */
    public void setSendStatus(Integer value) {
        setAttributeInternal(SENDSTATUS, value);
    }

    /**
     * Gets the attribute value for Sent_date using the alias name Sentdate.
     * @return the Sent_date
     */
    public Timestamp getSentdate() {
        return (Timestamp) getAttributeInternal(SENTDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for Sent_date using the alias name Sentdate.
     * @param value value to set the Sent_date
     */
    public void setSentdate(Timestamp value) {
        setAttributeInternal(SENTDATE, value);
    }

    /**
     * Gets the attribute value for Src_eventid using the alias name Srceventid.
     * @return the Src_eventid
     */
    public BigDecimal getSrceventid() {
        return (BigDecimal) getAttributeInternal(SRCEVENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for Src_eventid using the alias name Srceventid.
     * @param value value to set the Src_eventid
     */
    public void setSrceventid(BigDecimal value) {
        setAttributeInternal(SRCEVENTID, value);
    }

    /**
     * Gets the attribute value for Src_module using the alias name Srcmodule.
     * @return the Src_module
     */
    public Integer getSrcmodule() {
        return (Integer) getAttributeInternal(SRCMODULE);
    }

    /**
     * Sets <code>value</code> as attribute value for Src_module using the alias name Srcmodule.
     * @param value value to set the Src_module
     */
    public void setSrcmodule(Integer value) {
        setAttributeInternal(SRCMODULE, value);
    }

    /**
     * Gets the attribute value for Src_txnref using the alias name Srctxnref.
     * @return the Src_txnref
     */
    public BigDecimal getSrctxnref() {
        return (BigDecimal) getAttributeInternal(SRCTXNREF);
    }

    /**
     * Sets <code>value</code> as attribute value for Src_txnref using the alias name Srctxnref.
     * @param value value to set the Src_txnref
     */
    public void setSrctxnref(BigDecimal value) {
        setAttributeInternal(SRCTXNREF, value);
    }

    /**
     * Gets the attribute value for To_Email_id using the alias name ToEmailid.
     * @return the To_Email_id
     */
    public String getToEmailid() {
        return (String) getAttributeInternal(TOEMAILID);
    }

    /**
     * Sets <code>value</code> as attribute value for To_Email_id using the alias name ToEmailid.
     * @param value value to set the To_Email_id
     */
    public void setToEmailid(String value) {
        setAttributeInternal(TOEMAILID, value);
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
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= MyAssignmentsEmailVORowImpl.AttributesEnum.firstIndex()) && (index < MyAssignmentsEmailVORowImpl.AttributesEnum.count())) {
            return MyAssignmentsEmailVORowImpl.AttributesEnum.staticValues()[index - MyAssignmentsEmailVORowImpl.AttributesEnum.firstIndex()].get(this);
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
        if ((index >= MyAssignmentsEmailVORowImpl.AttributesEnum.firstIndex()) && (index < MyAssignmentsEmailVORowImpl.AttributesEnum.count())) {
            MyAssignmentsEmailVORowImpl.AttributesEnum.staticValues()[index - MyAssignmentsEmailVORowImpl.AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}