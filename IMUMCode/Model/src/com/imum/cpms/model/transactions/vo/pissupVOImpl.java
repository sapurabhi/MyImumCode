package com.imum.cpms.model.transactions.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Mar 10 12:22:41 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class pissupVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public pissupVOImpl() {
    }


    /**
     * Returns the bind variable value for supid.
     * @return bind variable value for supid
     */
    public String getsupid() {
        return (String)getNamedWhereClauseParam("supid");
    }

    /**
     * Sets <code>value</code> for variable supid.
     * @param value value to bind as supid
     */
    public void setsupid(String value) {
        ensureVariableManager().setVariableValue("supid", value);
    }
}