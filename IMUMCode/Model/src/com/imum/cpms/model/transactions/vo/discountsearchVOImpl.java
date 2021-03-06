package com.imum.cpms.model.transactions.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jun 13 11:45:58 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class discountsearchVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public discountsearchVOImpl() {
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
     * Returns the variable value for seq.
     * @return variable value for seq
     */
    public Integer getseq() {
        return (Integer)ensureVariableManager().getVariableValue("seq");
    }

    /**
     * Sets <code>value</code> for variable seq.
     * @param value value to bind as seq
     */
    public void setseq(Integer value) {
        ensureVariableManager().setVariableValue("seq", value);
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
}
