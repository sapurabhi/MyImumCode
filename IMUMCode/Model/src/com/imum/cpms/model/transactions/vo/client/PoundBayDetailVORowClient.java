package com.imum.cpms.model.transactions.vo.client;

import com.imum.cpms.model.transactions.vo.common.PoundBayDetailVORow;

import oracle.jbo.client.remote.RowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Sep 05 22:05:21 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PoundBayDetailVORowClient extends RowImpl implements PoundBayDetailVORow {
    /**
     * This is the default constructor (do not remove).
     */
    public PoundBayDetailVORowClient() {
    }

    public void refreshPoundBayAllocLovs() {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"refreshPoundBayAllocLovs",null,null);
        return;
    }
}