package com.imum.cpms.model.transactions.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 12 15:32:11 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PILocationVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PILocationVOImpl() {
    }

    /**
     * Returns the variable value for pilocpid.
     * @return variable value for pilocpid
     */
    public String getpilocpid() {
        return (String)ensureVariableManager().getVariableValue("pilocpid");
    }

    /**
     * Sets <code>value</code> for variable pilocpid.
     * @param value value to bind as pilocpid
     */
    public void setpilocpid(String value) {
        ensureVariableManager().setVariableValue("pilocpid", value);
    }


    /**
     * Returns the variable value for curdatetime.
     * @return variable value for curdatetime
     */
    public String getcurdatetime() {
        return (String)ensureVariableManager().getVariableValue("curdatetime");
    }

    /**
     * Sets <code>value</code> for variable curdatetime.
     * @param value value to bind as curdatetime
     */
    public void setcurdatetime(String value) {
        ensureVariableManager().setVariableValue("curdatetime", value);
    }
}
