package com.imum.cpms.model.transactions.vo.common;

import java.math.BigDecimal;

import oracle.jbo.Row;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 28 17:41:36 IST 2014
// ---------------------------------------------------------------------
public interface CardIssueSrchCriVORow extends Row {
    String getCardType();

    void setCardType(String value);

    Integer getDenomination();

    void setDenomination(Integer value);

    Integer getNoOfCards();

    void setNoOfCards(Integer value);


    Boolean getRemoveFlag();

    void setRemoveFlag(Boolean value);


}
