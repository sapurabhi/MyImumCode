package com.imum.cpms.model.masters.vo;

import java.math.BigDecimal;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 30 20:06:10 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTWRITEOFFDETAILSVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PVTWRITEOFFDETAILSVOImpl() {
    }

    /**
     * Returns the variable value for bindPvtheaderseq.
     * @return variable value for bindPvtheaderseq
     */
    public BigDecimal getbindPvtheaderseq() {
        return (BigDecimal)ensureVariableManager().getVariableValue("bindPvtheaderseq");
    }

    /**
     * Sets <code>value</code> for variable bindPvtheaderseq.
     * @param value value to bind as bindPvtheaderseq
     */
    public void setbindPvtheaderseq(BigDecimal value) {
        ensureVariableManager().setVariableValue("bindPvtheaderseq", value);
    }
}
