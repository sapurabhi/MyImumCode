package com.imum.cpms.model.transactions.vo;

import java.sql.Date;

import java.sql.Timestamp;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Aug 07 14:17:48 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTAuctionSearchVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PVTAuctionSearchVOImpl() {
    }

    /**
     * Returns the variable value for bindPVTIssueFromDate.
     * @return variable value for bindPVTIssueFromDate
     */
    public Timestamp getbindPVTIssueFromDate() {
        return (Timestamp)ensureVariableManager().getVariableValue("bindPVTIssueFromDate");
    }

    /**
     * Sets <code>value</code> for variable bindPVTIssueFromDate.
     * @param value value to bind as bindPVTIssueFromDate
     */
    public void setbindPVTIssueFromDate(Timestamp value) {
        ensureVariableManager().setVariableValue("bindPVTIssueFromDate", value);
    }

    /**
     * Returns the variable value for bindPVTIssueToDate.
     * @return variable value for bindPVTIssueToDate
     */
    public Timestamp getbindPVTIssueToDate() {
        return (Timestamp)ensureVariableManager().getVariableValue("bindPVTIssueToDate");
    }

    /**
     * Sets <code>value</code> for variable bindPVTIssueToDate.
     * @param value value to bind as bindPVTIssueToDate
     */
    public void setbindPVTIssueToDate(Timestamp value) {
        ensureVariableManager().setVariableValue("bindPVTIssueToDate", value);
    }

    /**
     * Returns the variable value for bindSectorCode.
     * @return variable value for bindSectorCode
     */
    public String getbindSectorCode() {
        return (String)ensureVariableManager().getVariableValue("bindSectorCode");
    }

    /**
     * Sets <code>value</code> for variable bindSectorCode.
     * @param value value to bind as bindSectorCode
     */
    public void setbindSectorCode(String value) {
        ensureVariableManager().setVariableValue("bindSectorCode", value);
    }

    /**
     * Returns the variable value for bindZone_code.
     * @return variable value for bindZone_code
     */
    public String getbindZone_code() {
        return (String)ensureVariableManager().getVariableValue("bindZone_code");
    }

    /**
     * Sets <code>value</code> for variable bindZone_code.
     * @param value value to bind as bindZone_code
     */
    public void setbindZone_code(String value) {
        ensureVariableManager().setVariableValue("bindZone_code", value);
    }

    /**
     * Returns the variable value for bindPlateNumber.
     * @return variable value for bindPlateNumber
     */
    public String getbindPlateNumber() {
        return (String)ensureVariableManager().getVariableValue("bindPlateNumber");
    }

    /**
     * Sets <code>value</code> for variable bindPlateNumber.
     * @param value value to bind as bindPlateNumber
     */
    public void setbindPlateNumber(String value) {
        ensureVariableManager().setVariableValue("bindPlateNumber", value);
    }

    /**
     * Returns the variable value for bindCountry.
     * @return variable value for bindCountry
     */
    public String getbindCountry() {
        return (String)ensureVariableManager().getVariableValue("bindCountry");
    }

    /**
     * Sets <code>value</code> for variable bindCountry.
     * @param value value to bind as bindCountry
     */
    public void setbindCountry(String value) {
        ensureVariableManager().setVariableValue("bindCountry", value);
    }

    /**
     * Returns the variable value for bindPlateCtgId.
     * @return variable value for bindPlateCtgId
     */
    public String getbindPlateCtgId() {
        return (String)ensureVariableManager().getVariableValue("bindPlateCtgId");
    }

    /**
     * Sets <code>value</code> for variable bindPlateCtgId.
     * @param value value to bind as bindPlateCtgId
     */
    public void setbindPlateCtgId(String value) {
        ensureVariableManager().setVariableValue("bindPlateCtgId", value);
    }

    /**
     * Returns the variable value for bindPlateTypeId.
     * @return variable value for bindPlateTypeId
     */
    public String getbindPlateTypeId() {
        return (String)ensureVariableManager().getVariableValue("bindPlateTypeId");
    }

    /**
     * Sets <code>value</code> for variable bindPlateTypeId.
     * @param value value to bind as bindPlateTypeId
     */
    public void setbindPlateTypeId(String value) {
        ensureVariableManager().setVariableValue("bindPlateTypeId", value);
    }


}
