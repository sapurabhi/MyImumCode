package com.imum.cpms.model.transactions.vo;

import java.math.BigDecimal;

import oracle.jbo.server.ViewObjectImpl;
import org.apache.myfaces.trinidad.model.UploadedFile;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Sep 12 12:22:05 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PVTDocsVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PVTDocsVOImpl() {
    }

    /**
     * Returns the variable value for BindPvtHdrSeq.
     * @return variable value for BindPvtHdrSeq
     */
    public BigDecimal getBindPvtHdrSeq() {
        return (BigDecimal)ensureVariableManager().getVariableValue("BindPvtHdrSeq");
    }

    /**
     * Sets <code>value</code> for variable BindPvtHdrSeq.
     * @param value value to bind as BindPvtHdrSeq
     */
    public void setBindPvtHdrSeq(BigDecimal value) {
        ensureVariableManager().setVariableValue("BindPvtHdrSeq", value);
    }
}
