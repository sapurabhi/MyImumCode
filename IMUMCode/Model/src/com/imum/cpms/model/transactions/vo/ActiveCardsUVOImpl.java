package com.imum.cpms.model.transactions.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 17 15:53:07 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ActiveCardsUVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public ActiveCardsUVOImpl() {
    }

    /**
     * Returns the variable value for StartNumber.
     * @return variable value for StartNumber
     */
    public String getStartNumber() {
        return (String)ensureVariableManager().getVariableValue("StartNumber");
    }

    /**
     * Sets <code>value</code> for variable StartNumber.
     * @param value value to bind as StartNumber
     */
    public void setStartNumber(String value) {
        ensureVariableManager().setVariableValue("StartNumber", value);
    }

    /**
     * Returns the variable value for EndNumber.
     * @return variable value for EndNumber
     */
    public String getEndNumber() {
        return (String)ensureVariableManager().getVariableValue("EndNumber");
    }

    /**
     * Sets <code>value</code> for variable EndNumber.
     * @param value value to bind as EndNumber
     */
    public void setEndNumber(String value) {
        ensureVariableManager().setVariableValue("EndNumber", value);
    }
}
