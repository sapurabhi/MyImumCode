package com.imum.cpms.model.transactions.vo;

import java.sql.ResultSet;

import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jun 12 19:49:15 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTHeadersmsVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PVTHeadersmsVOImpl() {
    }

    /**
     * Returns the variable value for bindZoneCode.
     * @return variable value for bindZoneCode
     */
    public String getbindZoneCode() {
        return (String)ensureVariableManager().getVariableValue("bindZoneCode");
    }

    /**
     * Sets <code>value</code> for variable bindZoneCode.
     * @param value value to bind as bindZoneCode
     */
    public void setbindZoneCode(String value) {
        ensureVariableManager().setVariableValue("bindZoneCode", value);
    }

    /**
     * Returns the variable value for zone.
     * @return variable value for zone
     */
    public String getzone() {
        return (String)ensureVariableManager().getVariableValue("zone");
    }

    /**
     * Sets <code>value</code> for variable zone.
     * @param value value to bind as zone
     */
    public void setzone(String value) {
        ensureVariableManager().setVariableValue("zone", value);
    }

    /**
     * Returns the variable value for sector.
     * @return variable value for sector
     */
    public String getsector() {
        return (String)ensureVariableManager().getVariableValue("sector");
    }

    /**
     * Sets <code>value</code> for variable sector.
     * @param value value to bind as sector
     */
    public void setsector(String value) {
        ensureVariableManager().setVariableValue("sector", value);
    }

    /**
     * Returns the variable value for pvtno.
     * @return variable value for pvtno
     */
    public String getpvtno() {
        return (String)ensureVariableManager().getVariableValue("pvtno");
    }

    /**
     * Sets <code>value</code> for variable pvtno.
     * @param value value to bind as pvtno
     */
    public void setpvtno(String value) {
        ensureVariableManager().setVariableValue("pvtno", value);
    }

    /**
     * Returns the variable value for contracode.
     * @return variable value for contracode
     */
    public String getcontracode() {
        return (String)ensureVariableManager().getVariableValue("contracode");
    }

    /**
     * Sets <code>value</code> for variable contracode.
     * @param value value to bind as contracode
     */
    public void setcontracode(String value) {
        ensureVariableManager().setVariableValue("contracode", value);
    }

    /**
     * executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object[] params,
                                             int noUserParams) {
        super.executeQueryForCollection(qc, params, noUserParams);
    }

    /**
     * hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        boolean bRet = super.hasNextForCollection(qc);
        return bRet;
    }

    /**
     * createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc,
                                                 ResultSet resultSet) {
        ViewRowImpl value = super.createRowFromResultSet(qc, resultSet);
        return value;
    }

    /**
     * getQueryHitCount - overridden for custom java data source support.
     */
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        long value = super.getQueryHitCount(viewRowSet);
        return value;
    }
}
