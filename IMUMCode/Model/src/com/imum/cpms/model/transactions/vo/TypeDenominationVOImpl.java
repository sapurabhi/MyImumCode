package com.imum.cpms.model.transactions.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Nov 03 16:43:14 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TypeDenominationVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public TypeDenominationVOImpl() {
    }

    /**
     * Returns the variable value for CardType.
     * @return variable value for CardType
     */
    public Integer getCardType() {
        return (Integer)ensureVariableManager().getVariableValue("CardType");
    }

    /**
     * Sets <code>value</code> for variable CardType.
     * @param value value to bind as CardType
     */
    public void setCardType(Integer value) {
        ensureVariableManager().setVariableValue("CardType", value);
    }
}