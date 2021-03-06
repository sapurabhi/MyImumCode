package com.imum.cpms.model.login.client;

import com.imum.cpms.model.login.common.LoginAM;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 09 14:56:56 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LoginAMClient extends ApplicationModuleImpl implements LoginAM {
    /**
     * This is the default constructor (do not remove).
     */
    public LoginAMClient() {
    }


    public void commit() {
        Object _ret = this.riInvokeExportedMethod(this,"commit",null,null);
        return;
    }

    public String getLastLoginDate() {
        Object _ret =
            this.riInvokeExportedMethod(this,"getLastLoginDate",null,null);
        return (String)_ret;
    }

    public void convertPwd(String userId, String pwd) {
        Object _ret =
            this.riInvokeExportedMethod(this,"convertPwd",new String [] {"java.lang.String","java.lang.String"},new Object[] {userId, pwd});
        return;
    }

    public Boolean checkLoginCredentials(String enteredUserid,
                                         String enteredPassword) {
        Object _ret =
            this.riInvokeExportedMethod(this,"checkLoginCredentials",new String [] {"java.lang.String","java.lang.String"},new Object[] {enteredUserid, enteredPassword});
        return (Boolean)_ret;
    }

    public String getHashString(String str) {
        Object _ret =
            this.riInvokeExportedMethod(this,"getHashString",new String [] {"java.lang.String"},new Object[] {str});
        return (String)_ret;
    }

    public String encryptLdapData(String value) {
        Object _ret =
            this.riInvokeExportedMethod(this,"encryptLdapData",new String [] {"java.lang.String"},new Object[] {value});
        return (String)_ret;
    }
}
