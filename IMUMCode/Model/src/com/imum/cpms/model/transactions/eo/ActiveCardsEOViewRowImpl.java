package com.imum.cpms.model.transactions.eo;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Apr 10 18:46:02 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ActiveCardsEOViewRowImpl extends ViewRowImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public ActiveCardsEOViewRowImpl() {
    }

    /**
     * Gets ActiveCardsEO entity object.
     * @return the ActiveCardsEO
     */
    public EntityImpl getActiveCardsEO() {
        return (EntityImpl)getEntity(0);
    }
}
