package com.imum.cpms.login;

import com.imum.cpms.ldap.WeblogicUserMgmt;
import com.imum.cpms.util.MessageUtil;
import com.imum.cpms.view.TemplateBean;

import com.imum.cpms.view.backing.ChangePasswordBean;

import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;


import java.text.SimpleDateFormat;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlSelectOneListbox;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.adf.view.rich.component.rich.nav.RichCommandNavigationItem;
import oracle.adf.view.rich.component.rich.output.RichMessages;

import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.sqlj.runtime.Oracle;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

import org.joda.time.format.DateTimeFormatter;
import oracle.jbo.Session;
import oracle.jbo.common.DefLocaleContext;
import oracle.jbo.server.SessionImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class backing_LoginPage {
    public static final ADFLogger logger = ADFLogger.createADFLogger(backing_LoginPage.class);
    private HtmlSelectOneListbox language;
    private RichCommandLink resetPassword;

    String selectedLang = "English";
    private RichInputText enteredUserid;
    private RichInputText enteredPassword;
    String loggedinUserid;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    // setting to true - this will create session if doesn't exist
    HttpSession httpSession = (HttpSession) externalContext.getSession(true);
    AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
    
    private RichMessages loginMessages;
    private RichInputText resetUserID;
    private RichInputText resetSecretQuestion;
    private RichInputText resetSecretAnswer;
    private RichInputText resetResetPassword;
    
    String visibleSecretQuestion;
    String visibleSecretAnswer;
    String visibleResetPassword;
    String Last_login_datetime = null;
    String lastLoginDate = null;
    String lastLoginTime = null;
    
    private RichCommandButton resetCheckSecretAnswerButton;
    private RichCommandButton resetUpdatePasswordButton;
    private RichCommandNavigationItem loggedinUsername;
    private RichCommandNavigationItem logout;
    private RichMessages loginMessagess;
    private RichCommandLink resetLogin;
    private RichPopup popupCancel;
    private RichOutputText popupOutputText;
    private RichOutputLabel outputInfo;
    private RichPopup popUp;
    private RichInputText currentPwd;
    private RichInputText newPwd;
    private RichInputText confirmNewPwd;
    private RichCommandLink resetFirstPwd;
    private RichOutputText passwordNote;
    

    public backing_LoginPage() {}

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String onClickLogin_action() {               
        String returnString = "error";
        BindingContainer bindings = getBindings();
        String username=(String)enteredUserid.getValue();
        String password=(String)enteredPassword.getValue();
        if(username==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter UserName", "Please enter User Name"));    
        }
        if(password==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Password", "Please enter Password"));    
        }
        if(username!=null && password!=null){
        OperationBinding operationBinding = bindings.getOperationBinding("checkLoginCredentials");
        operationBinding.getParamsMap().put("enteredUserid",  username);
        operationBinding.getParamsMap().put("enteredPassword",  password);
        operationBinding.execute();
        Boolean result = (Boolean)operationBinding.getResult();
        if(result)
        {
            BindingContainer binding = this.getBindings();
            DCBindingContainer bindingsImp = (DCBindingContainer)binding; 
            DCIteratorBinding dcIterato = bindingsImp.findIteratorBinding("LoginVO1Iterator"); 
            ViewObject loginVO = dcIterato.getViewObject();
            String flag = loginVO.first().getAttribute("activeflag") ==null ? "" : loginVO.first().getAttribute("activeflag").toString();
            if(flag!= null && flag.equals("Y"))
            {
                System.out.println("Locale in Backing Bean" +
                                   FacesContext.getCurrentInstance().getViewRoot().getLocale());
                selectedLang = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
                if (operationBinding.getErrors().isEmpty()) {
                    System.out.println("Language..." + selectedLang);
                    if (selectedLang.equalsIgnoreCase("EN") || selectedLang.equals("English")) {
                        returnString = "success.EN";
                    } else if (selectedLang.equalsIgnoreCase("AR") || selectedLang.equals("Arabic")) {
                        returnString = "success.AR";
                    }
                    BindingContext.getCurrent().setLocaleContext(new DefLocaleContext(new Locale(selectedLang)));
                    ADFContext.getCurrent().setLocale(new Locale(selectedLang));
                    OperationBinding operationBindingReset = bindings.getOperationBinding("getLastLoginDate");
                    operationBindingReset.execute();
                    String resetResult = (String)operationBindingReset.getResult();
                    System.out.println("First Time login check:"+resetResult);
                    
                    //Programatically invoking Popup for Reset Password (First user)
                    if(resetResult != null && resetResult.equals("true")){
                        ShowPopup();
                        returnString="true";                
                    }else{
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("password", password);
                        
                        HidePopup();           
                    }
                    
                    
                    OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
                    oprHashPass.getParamsMap().put("str",password);
                    oprHashPass.execute();
                    String hashPassword = oprHashPass.getResult().toString();
                    System.out.println("Login hashPassword :::::::::::::::::::::      "+hashPassword);
                    
                    OperationBinding oprEncryptPass = getBindings().getOperationBinding("encryptLdapData");
                    oprEncryptPass.getParamsMap().put("value",hashPassword);
                    oprEncryptPass.execute();
                    String encyptPassword = hashPassword; //oprEncryptPass.getResult().toString();
                    System.out.println(" Login  encyptPassword ::::::::::::::::::::::::::      "+encyptPassword);
                    
                    httpSession.setAttribute("encyptPassword", encyptPassword);
                    
                    System.out.println("Before updating into database login date..." + httpSession.getAttribute("encyptPassword").toString());
                    
                    
                    
                    DCBindingContainer bindingsImpl = (DCBindingContainer)binding; 
                    DCIteratorBinding dcIterator = bindingsImpl.findIteratorBinding("UserVO1Iterator"); 
                    ViewObject userDetailsVO = dcIterator.getViewObject();
                    httpSession.setAttribute("loggedinUserid", enteredUserid.getValue().toString());
                    System.out.println("Before updating into database login date..." + httpSession.getAttribute("loggedinUserid").toString());
                    userDetailsVO.setWhereClause("user_id= '" + httpSession.getAttribute("loggedinUserid").toString() + "'");
                    userDetailsVO.executeQuery();
                    
                    DCIteratorBinding iter= bindingsImpl.findIteratorBinding("UserRoleMapUVO2Iterator");
                    ViewObject rolemapvo=iter.getViewObject();
                    rolemapvo.setWhereClause("user_id= '" + httpSession.getAttribute("loggedinUserid").toString() + "'");
                    System.out.println(rolemapvo.getQuery());
                    rolemapvo.executeQuery();
                    Row rolemaprow=rolemapvo.first();
                    if(rolemaprow!=null){
                        String rolename=rolemaprow.getAttribute("RoleName").toString(); 
                        System.out.println("Role Name is:::"+rolename);
                        httpSession.setAttribute("rolename", rolename);
                                       }
                   
                    int userExists = userDetailsVO.getEstimatedRangePageCount();
                    
                    if (userExists != 0) {
                        Row row = userDetailsVO.next();
                        if (row != null)
                        {
                            if (row.getAttribute("Lastlogindatetime") != null) {
                                Last_login_datetime = row.getAttribute("Lastlogindatetime").toString();
                                int lastLoginDateIndex = Last_login_datetime.indexOf(" ");
                                lastLoginDate = Last_login_datetime.substring(0, lastLoginDateIndex);
                                lastLoginTime = Last_login_datetime.substring(lastLoginDateIndex+1);
                            }
                            if(row.getAttribute("Username") != null)
                            {
                                httpSession.setAttribute("loggedinUserName", row.getAttribute("Username").toString());    
                            }else
                            {
                                httpSession.setAttribute("loggedinUserName", enteredUserid.getValue().toString());    
                            } 
                            System.out.println("Last_login_datetime...." + Last_login_datetime);
                                try {
                                    String ds1 = lastLoginDate;
                                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                                    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
                                    if(ds1!=null){
                                        lastLoginDate = sdf2.format(sdf1.parse(ds1));
                                    }
                                    
                                }catch (ParseException e) {
                                    e.printStackTrace();
                                } 
                                
                            
                            
                            httpSession.setAttribute("lastLoginDate", lastLoginDate);
                            httpSession.setAttribute("lastLoginTime", lastLoginTime);
                            /**** testing ****/
                            if(row.getAttribute("Lastlogindatetime")!=null){
                            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                          
                                row.setAttribute("Lastlogindatetime", sqlDate);
                                 
                            System.out.println("inserted sqlDate...." + sqlDate.toString());
                            }
                            OperationBinding operationBindings = binding.getOperationBinding("commit");
                            operationBindings.execute();
                            TemplateBean tb = new TemplateBean();
                            String userName = httpSession.getAttribute("loggedinUserid").toString();
                            if(selectedLang.equalsIgnoreCase("EN") || selectedLang.equals("English")){                            
                                tb.executeUserRoleMenuQuery("MenuMstUVO1Iterator", "1", userName);
                            }else{
                                tb.executeUserRoleMenuQuery("MenuLngDetailVO1Iterator", "1", userName);
                            }
                        } else {
                            System.out.println("User doesnt exist in database");
                        }
                    }
                    
                } else {
                    System.out.println("operationBinding.getErrors()..." + operationBinding.getErrors().toString());
                    enteredPassword.setImmediate(true);
                    enteredPassword.setValue("");
                    adfFacesContext.addPartialTarget(enteredPassword);
                    httpSession.setAttribute("loggedinUserid", null);
                    httpSession.setAttribute("language", null);
                }

                System.out.println("On validation of credentials returning to page.... " + returnString);
                
                if (httpSession.getAttribute("loggedinUserid") != null) {
                    System.out.println("$$$$$$ userid from session..." + httpSession.getAttribute("loggedinUserid").toString());
                }
                
                if (httpSession.getAttribute("language") != null) {
                    System.out.println("$$$$$$ language from session..." + httpSession.getAttribute("language").toString());
                } 
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "User inactive. Please contact Admin"));          
            }
        }  
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Invalid Userid / Password, Please enter again"));      
        }
        }
        return returnString;
        
    }
    
    public String onClickReset_action() {
        enteredUserid.setImmediate(true);
        enteredUserid.setValue("");
        adfFacesContext.addPartialTarget(enteredUserid);
        enteredPassword.setImmediate(true);
        enteredPassword.setValue("");
        adfFacesContext.addPartialTarget(enteredPassword);
        return null;
    }
    
    public String infoMessage(String displayMessage) {
        FacesMessage facesMessage = new FacesMessage(displayMessage);
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);   
        outputInfo.setRendered(true);
        outputInfo.setValue("Information");
        return null;
    }
    
    public String errorMessage(String displayMessage) {
        FacesMessage facesMessage = new FacesMessage(displayMessage);
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesContext.addMessage(null, facesMessage);
        outputInfo.setRendered(true);
        outputInfo.setValue("Information");
        return null;
    }
    
    public String onClickResetPassword_action() {
        //return "Resetpassword";
        return null;
    }

    public void setLanguage(HtmlSelectOneListbox language) {
        this.language = language;
    }

    public HtmlSelectOneListbox getLanguage() {
        return language;
    }

    public void languageSelection(ValueChangeEvent valueChangeEvent) {
        selectedLang = valueChangeEvent.getNewValue().toString();
        httpSession.setAttribute("language", selectedLang);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(selectedLang)); 
        FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale(selectedLang));
        System.out.println("Locale in Bean"+FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
    }

    public void setResetPassword(RichCommandLink resetPassword) {
        this.resetPassword = resetPassword;
    }

    public RichCommandLink getResetPassword() {
        return resetPassword;
    }

    public void setEnteredUserid(RichInputText enteredUserid) {
        this.enteredUserid = enteredUserid;
    }

    public RichInputText getEnteredUserid() {         
        return enteredUserid;
    }

    public void setEnteredPassword(RichInputText enteredPassword) {
        this.enteredPassword = enteredPassword;
    }

    public RichInputText getEnteredPassword() {
        return enteredPassword;
    }

    public void loggedinUserid(ValueChangeEvent valueChangeEvent) {
        loggedinUserid = valueChangeEvent.getNewValue().toString();
        httpSession.setAttribute("loggedinUserid", loggedinUserid);
    }

    public void setLoginMessages(RichMessages loginMessages) {
        this.loginMessages = loginMessages;
    }

    public RichMessages getLoginMessages() {
        return loginMessages;
    }

    public void setResetUserID(RichInputText resetUserID) {
        this.resetUserID = resetUserID;
    }

    public RichInputText getResetUserID() {
        return resetUserID;
    }

    public void setResetSecretQuestion(RichInputText resetSecretQuestion) {
        this.resetSecretQuestion = resetSecretQuestion;
    }

    public RichInputText getResetSecretQuestion() {
        return resetSecretQuestion;
    }

    public void setResetSecretAnswer(RichInputText resetSecretAnswer) {
        this.resetSecretAnswer = resetSecretAnswer;
    }

    public RichInputText getResetSecretAnswer() {
        return resetSecretAnswer;
    }

    public void setResetResetPassword(RichInputText resetResetPassword) {
        this.resetResetPassword = resetResetPassword;
    }

    public RichInputText getResetResetPassword() {
        return resetResetPassword;
    }
    
    public String checkResetUserID() {
        
        if ((resetUserID.getValue() != null) && (!resetUserID.getValue().equals(""))) {
            System.out.println("entered resetUserID..." + resetUserID.getValue());
            
            BindingContainer binding = this.getBindings(); 
            DCBindingContainer bindingsImpl = (DCBindingContainer)binding; 
            DCIteratorBinding dcIterator = bindingsImpl.findIteratorBinding("ResetPasswordVO1Iterator"); 
            ViewObject resetPasswordVO = dcIterator.getViewObject();
            resetPasswordVO.setWhereClause("user_id= '" + resetUserID.getValue().toString() + "'");
            resetPasswordVO.executeQuery();
            
            int userExists = resetPasswordVO.getEstimatedRangePageCount();
            String SecretQuestion = "";
            
            if (userExists == 0) {
                System.out.println("Requested user doesnot exist in database");
                infoMessage("Requested user id does not exist");
                popupOutputText.setValue("Requested user id does not exist");
            } else {
                System.out.println("Requested user exists in database");
                resetSecretQuestion.setRendered(true);
                resetSecretAnswer.setRendered(true);
                resetCheckSecretAnswerButton.setRendered(true);
                Row row = resetPasswordVO.next();
                if (row != null)
                {
                    SecretQuestion = row.getAttribute("Secretqust").toString();
                }
                resetSecretQuestion.setValue(SecretQuestion);
            }
        } else {
            errorMessage("Please enter valid user id");
            popupOutputText.setValue("Please enter valid user id");
        }
        popupCancel.setAutoCancel("disabled");
        return null;   
    }
    
    public String checkResetSecretAnswer() {
        popupOutputText.setValue("");
        outputInfo.setValue("");
        if ((resetUserID.getValue() != null) && (!resetUserID.getValue().equals("")) && (resetSecretAnswer.getValue() != null) && (!resetSecretAnswer.getValue().equals(""))) {
        
            OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
            oprHashPass.getParamsMap().put("str",resetSecretAnswer.getValue().toString());
            oprHashPass.execute();
            String secretAns = oprHashPass.getResult().toString();
            System.out.println("checkResetSecretAnswer  secretAns :::::::::::::::::::::      "+secretAns);
             logger.info("checkResetSecretAnswer  secretAns ::::::::::::  "+secretAns);
        
            BindingContainer binding = this.getBindings();
            DCBindingContainer bindingsImpl = (DCBindingContainer)binding; 
            DCIteratorBinding dcIterator = bindingsImpl.findIteratorBinding("ResetPasswordVO1Iterator"); 
            ViewObject resetPasswordVO = dcIterator.getViewObject();
            resetPasswordVO.setWhereClause("user_id= '" + resetUserID.getValue().toString() + "' and secret_ans= convert(varbinary(80),'"+ secretAns +"') ");
            resetPasswordVO.executeQuery();
            
            int secretAnswerExists = resetPasswordVO.getEstimatedRangePageCount();
            
            if (secretAnswerExists == 0) {
                infoMessage("Invalid answer");
                popupOutputText.setValue("Invalid answer");
            } else {
                resetResetPassword.setRendered(true);
                resetUpdatePasswordButton.setRendered(true);   
                passwordNote.setRendered(true);
            }
        } else {
            infoMessage("Invalid answer");
            popupOutputText.setValue("Invalid answer");
        }
       
        popupCancel.setAutoCancel("disabled");
        return null;
    }
    
    public String updateResetPassword() {
        String Password1 = null;
        String Password2 = null;
        String Password3 = null;
        String Password4 = null;
        String lastPassword = null;
        String passwordMatched = "No";
        
        popupOutputText.setValue("");
        outputInfo.setValue("");
        
        if ((resetResetPassword.getValue() != null) && (!resetResetPassword.getValue().equals(""))) {
            System.out.println("entered password is :" + resetResetPassword.getValue().toString());
            OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
            oprHashPass.getParamsMap().put("str",resetResetPassword.getValue().toString());
            oprHashPass.execute();
            String enteredPassword = oprHashPass.getResult().toString();
            
           
            System.out.println("Hashed entered password..." + enteredPassword);
            BindingContainer bindings = this.getBindings();
            DCBindingContainer bindingsImpls = (DCBindingContainer)bindings; 
            DCIteratorBinding dcIterators = bindingsImpls.findIteratorBinding("UserVO1Iterator"); 
            ViewObject validatePasswordVO = dcIterators.getViewObject();
            validatePasswordVO.setWhereClause("user_id= '" + resetUserID.getValue().toString() + "'");
            validatePasswordVO.executeQuery();
            int userExistss = validatePasswordVO.getEstimatedRangePageCount();
            
            if (userExistss != 0) {
                System.out.println("Validating entered password with existing passwords");
                Row row = validatePasswordVO.next();
                if (row != null)
                {
                    if (row.getAttribute("pwd") != null && !row.getAttribute("pwd").equals("")) {
                        lastPassword = row.getAttribute("pwd").toString();
                        System.out.println("lastPassword..." + lastPassword);
                        if (lastPassword.equals(enteredPassword)) {
                            errorMessage("Password match with previous 5 passwords, Please enter again");
                            popupOutputText.setValue("Password match with previous 5 passwords, Please enter again");
                            passwordMatched = "Yes";
                            resetResetPassword.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(resetResetPassword);
                        }
                    }
                    if (row.getAttribute("pwd1") != null && !row.getAttribute("pwd1").equals("") && passwordMatched.equalsIgnoreCase("No")) {
                        Password1 = row.getAttribute("pwd1").toString();
                        System.out.println("Password1..." + Password1);
                        if (Password1.equals(enteredPassword)) {
                            errorMessage("Password match with previous 5 passwords, Please enter again");
                            popupOutputText.setValue("Password match with previous 5 passwords, Please enter again");
                            passwordMatched = "Yes";
                            resetResetPassword.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(resetResetPassword);
                        }
                    }
                    if (row.getAttribute("pwd2") != null && !row.getAttribute("pwd2").equals("") && passwordMatched.equalsIgnoreCase("No")) {
                        Password2 = row.getAttribute("pwd2").toString();
                        System.out.println("Password2..." + Password2);
                        if (Password2.equals(enteredPassword)) {
                            errorMessage("Password match with previous 5 passwords, Please enter again");
                            popupOutputText.setValue("Password match with previous 5 passwords, Please enter again");
                            passwordMatched = "Yes";
                            resetResetPassword.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(resetResetPassword);
                        }
                    }
                    if (row.getAttribute("pwd3") != null && !row.getAttribute("pwd3").equals("") && passwordMatched.equalsIgnoreCase("No")) {
                        Password3 = row.getAttribute("pwd3").toString();
                        System.out.println("Password3..." + Password3);
                        if (Password3.equals(enteredPassword)) {
                            errorMessage("Password match with previous 5 passwords, Please enter again");
                            popupOutputText.setValue("Password match with previous 5 passwords, Please enter again");
                            passwordMatched = "Yes";
                            resetResetPassword.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(resetResetPassword);
                        }
                    }
                    if (row.getAttribute("pwd4") != null && !row.getAttribute("pwd4").equals("") && passwordMatched.equalsIgnoreCase("No")) {
                        Password4 = row.getAttribute("pwd4").toString();
                        System.out.println("pwd4..." + Password4);
                        if (Password4.equals(enteredPassword)) {
                            errorMessage("Password match with previous 5 passwords, Please enter again");
                            popupOutputText.setValue("Password match with previous 5 passwords, Please enter again");
                            passwordMatched = "Yes";
                            resetResetPassword.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(resetResetPassword);
                        }
                    }
                    
                    if (passwordMatched.equalsIgnoreCase("No")) {
                        
                        
                 
                        BindingContainer binding = this.getBindings();
                        DCBindingContainer bindingsImpl = (DCBindingContainer)binding; 
                        DCIteratorBinding dcIterator = bindingsImpl.findIteratorBinding("ResetPasswordVO1Iterator"); 
                        ViewObject resetPasswordVO = dcIterator.getViewObject();
                        resetPasswordVO.setWhereClause("user_id= '" + resetUserID.getValue().toString() + "'");
                        resetPasswordVO.executeQuery();
                        int userExists = resetPasswordVO.getEstimatedRangePageCount();
                        
                        if (userExists != 0) {
                            Row rows = resetPasswordVO.next();
                            if (rows != null)
                            {
                            
                                Integer groupId  =  (Integer)row.getAttribute("GroupId");
                                DCBindingContainer dcbindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding iterator = dcbindings.findIteratorBinding("GroupMstUVO1Iterator");
                                Key key = new Key(new Object[] { groupId });
                                RowSetIterator rsi = iterator.getRowSetIterator();
                                Row groupRow = rsi.findByKey(key, 1)[0];
                                String groupName = (String)groupRow.getAttribute("GroupName");
                                          
                                logger.info("Rest page  Group Name ::::::::::::::::::::::::::::::::::::::"+groupName);
                                                      
                                OperationBinding oprHashPassReset = getBindings().getOperationBinding("getHashString");
                                oprHashPassReset.getParamsMap().put("str",resetResetPassword.getValue().toString());
                                oprHashPassReset.execute();
                                String resetHashPassword = oprHashPassReset.getResult().toString();
                                System.out.println("hashPassword :::::::::::::::::::::      "+resetHashPassword);
                                logger.info("Rest page encyptPassword  ::::::::::::  "+resetHashPassword);
                                                      
//                                OperationBinding oprEncryptPass = getBindings().getOperationBinding("encryptLdapData");
//                                oprEncryptPass.getParamsMap().put("value",resetHashPassword);
//                                oprEncryptPass.execute();
                                String resetEncyptPassword = resetHashPassword;
                                System.out.println(" Rest page encyptPassword ::::::::::::::::::::::::::      "+resetEncyptPassword);
                                logger.info(" Rest page encyptPassword  ::::::::::::  "+resetEncyptPassword);
                                  
                                if(groupName!=null && bpmGroups.contains(groupName))
                                   {
                                    String userId = resetUserID.getValue().toString();
                                              WeblogicUserMgmt wls = new WeblogicUserMgmt();
                                              String ServerName = "";
                                              ServerName = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
                                               
                                              

                                                    try{
                                                        wls.connect(ServerName);
                                                        if(wls.IsUserExists(userId)){
                                                            wls.changeUserPassword(userId, lastPassword, resetEncyptPassword);
                                                        }else{
                                                                wls.createUser(userId, resetEncyptPassword, "BPM User");
                                                                wls.addMemberToGroup(groupName, userId);
                                                                    
                                                            }
                                                       
                                                       
                                                        
                                                    }catch(Exception e) {
                                                        System.out.println("Edit Error ::::::::::::  "+e);
                                                        logger.info("Edit Error ::::::::::::  "+e);
                                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Error in connecting to server for User Management."));
                                                        return "true";
                                                      
                                                        }finally{
                                                            wls.close();
                                                        }
                                                
                                          }

                            
                               OperationBinding operationBindings = binding.getOperationBinding("convertPwd");
                                    operationBindings.getParamsMap().put("userId",resetUserID.getValue().toString());
                                operationBindings.getParamsMap().put("pwd",resetResetPassword.getValue().toString());
                                operationBindings.execute();
                            if(operationBindings.getErrors().isEmpty())
                            {
                                infoMessage("Password has been reset");
                                popupOutputText.setValue("Password has been reset");
                                passwordNote.setVisible(false);
                                }
                            else
                            {
                                infoMessage("Invalid password, Please enter again");
                                popupOutputText.setValue("Invalid password, Please enter again");    
                            }
//                                rows.setAttribute("Password", resetResetPassword.getValue().toString());
//                                OperationBinding operationBindings = binding.getOperationBinding("commit");
//                                operationBindings.execute();
                                
                               
                            } else {
                                infoMessage("Invalid password, Please enter again");
                                popupOutputText.setValue("Invalid password, Please enter again");
                            }
                        }
                    }
                }
            }
        } else {
            infoMessage("Invalid password");
            popupOutputText.setValue("Invalid password");
        }
        popupCancel.setAutoCancel("disabled");
        return null;
    }

    public void setVisibleSecretQuestion(String visibleSecretQuestion) {
        this.visibleSecretQuestion = visibleSecretQuestion;
    }

    public String getVisibleSecretQuestion() {
        return visibleSecretQuestion = "false";
    }

    public void setVisibleSecretAnswer(String visibleSecretAnswer) {
        this.visibleSecretAnswer = visibleSecretAnswer;
    }

    public String getVisibleSecretAnswer() {
        return visibleSecretAnswer = "false";
    }

    public void setVisibleResetPassword(String visibleResetPassword) {
        this.visibleResetPassword = visibleResetPassword;
    }

    public String getVisibleResetPassword() {
        return visibleResetPassword = "false";
    }

    public void setResetCheckSecretAnswerButton(RichCommandButton resetCheckSecretAnswerButton) {
        this.resetCheckSecretAnswerButton = resetCheckSecretAnswerButton;
    }

    public RichCommandButton getResetCheckSecretAnswerButton() {
        return resetCheckSecretAnswerButton;
    }

    public void setResetUpdatePasswordButton(RichCommandButton resetUpdatePasswordButton) {
        this.resetUpdatePasswordButton = resetUpdatePasswordButton;
    }

    public RichCommandButton getResetUpdatePasswordButton() {
        return resetUpdatePasswordButton;
    }

    public void setLoggedinUsername(RichCommandNavigationItem loggedinUsername) {
        this.loggedinUsername = loggedinUsername;
    }

    public RichCommandNavigationItem getLoggedinUsername() {
        return loggedinUsername;
    }

    public void setLogout(RichCommandNavigationItem logout) {
        this.logout = logout;
    }

    public RichCommandNavigationItem getLogout() {
        return logout;
    }

    public String logoutButton_action() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse httpResponse = (HttpServletResponse)externalContext.getResponse();
        HttpSession httpSession = (HttpSession)externalContext.getSession(false);
        try {
            if (httpSession != null) {
                httpSession.invalidate();
            }
            httpResponse.sendRedirect("Login.jspx");
        } catch (Exception e) {
            System.out.println("HTTP Session is null");
        }
        
        return null;
    }
    
    public String resetLogin_Link() {
        resetPrevValues();
        popupCancel.setAutoCancel("enabled");
        
        return "resetLogin";
    }

    public void onClickMessageOK(AttributeChangeEvent attributeChangeEvent) {        
        System.out.println("Message Clicked ok..." + attributeChangeEvent.getNewValue());
    }

    public void setLoginMessagess(RichMessages loginMessagess) {
        this.loginMessagess = loginMessagess;
    }

    public RichMessages getLoginMessagess() {
        return loginMessagess;
    }

    public void setResetLogin(RichCommandLink resetLogin) {
        this.resetLogin = resetLogin;
    }

    public RichCommandLink getResetLogin() {
        return resetLogin;
    }

    public String onClickResetCredentials_action() {
        // Add event code here...
        return null;
    }

    public void setPopupCancel(RichPopup popupCancel) {
        this.popupCancel = popupCancel;
    }

    public RichPopup getPopupCancel() {
        return popupCancel;
    }

    public void setPopupOutputText(RichOutputText popupOutputText) {
        this.popupOutputText = popupOutputText;
    }

    public RichOutputText getPopupOutputText() {
        return popupOutputText;
    }

    public void setOutputInfo(RichOutputLabel outputInfo) {
        this.outputInfo = outputInfo;
    }

    public RichOutputLabel getOutputInfo() {
        return outputInfo;
    }

    public void resetPrevValuesCancel(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        System.out.println("resetPrevValuesCancel");
        resetPrevValues();     
    }
    
    public void resetPrevValues(){
        onClickReset_action();
                resetUserID.setValue("");
                resetSecretQuestion.setValue("");
                resetSecretAnswer.setValue("");
                resetSecretQuestion.setRendered(false);
                resetSecretAnswer.setRendered(false);
                resetCheckSecretAnswerButton.setRendered(false);
                resetResetPassword.setValue("");
                resetResetPassword.setRendered(false);
                resetUpdatePasswordButton.setRendered(false); 
                outputInfo.setRendered(false);
                popupOutputText.setValue("");
                currentPwd.setValue("");
                newPwd.setValue("");
                confirmNewPwd.setValue("");
    }

    public String onClickResetPwd_action() {
        // Add event code here...
        popupOutputText.setValue("");
        outputInfo.setValue("");
        resetUserID.setImmediate(true);
        resetUserID.setValue("");
        adfFacesContext.addPartialTarget(resetUserID);
        popupCancel.setAutoCancel("disabled");
        return null;
    }
    
    public void ShowPopup() {
              RichPopup.PopupHints hints = new RichPopup.PopupHints();
              this.getPopUp().show(hints);
     
     }
    
    public void HidePopup() {
               RichPopup.PopupHints hints = new RichPopup.PopupHints();
               this.getPopUp().hide();
     
      }
    
    public String resetFirstPassword() {
        String currentPassword,newPassword,confirmNewPassword;
        String userId = (String)httpSession.getAttribute("loggedinUserid");
        BindingContainer bindings = getBindings();
        DCBindingContainer bindingsImpls = (DCBindingContainer)bindings; 
        DCIteratorBinding dcIterators = bindingsImpls.findIteratorBinding("UserVO1Iterator"); 
        ViewObject validatePasswordVO = dcIterators.getViewObject();
        validatePasswordVO.setWhereClause("user_id= '" + userId + "'");
        validatePasswordVO.executeQuery();
        Row row = validatePasswordVO.next(); 
        String password = (String)row.getAttribute("pwd");
        if(currentPwd.getValue()==null){
            errorMessage("Please enter Current Password");
            return "fail";
        }else{
            
            OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
            oprHashPass.getParamsMap().put("str",currentPwd.getValue().toString());
            oprHashPass.execute();
             currentPassword = oprHashPass.getResult().toString();
            
        }
        if(newPwd.getValue()==null){
            errorMessage("Please enter New Password"); 
            return "fail";
        }else{
            
            if(newPwd.getValue().toString().equals(currentPwd.getValue().toString())){
                errorMessage("New Password cannot be same as Current Password"); 
                return "fail";
            }else{
                
            newPassword = newPwd.getValue().toString();}
        }
        if(confirmNewPwd.getValue()==null){
            errorMessage("Please enter Confirm New Password"); 
            return "fail";
        }else{
            confirmNewPassword = confirmNewPwd.getValue().toString();
        }

        if(password != null && currentPassword != null && !(password.equals(currentPassword))){
            errorMessage("Entered Current Password is wrong");
            return "fail";
        }
        if( !(newPassword.equals(confirmNewPassword))){
            errorMessage("confirm New Password is not matched to New Password"); 
            return "fail";
        }else{
//            row.setAttribute("Password", newPassword);
            
          //START LDAP user modify
         // Integer groupId  = (Integer)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject().getCurrentRow().getAttribute("GroupId");
            
          Integer groupId  =  (Integer)row.getAttribute("GroupId");
          DCBindingContainer dcbindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding iterator = dcbindings.findIteratorBinding("GroupMstUVO1Iterator");
          Key key = new Key(new Object[] { groupId });
          RowSetIterator rsi = iterator.getRowSetIterator();
          Row groupRow = rsi.findByKey(key, 1)[0];
          String groupName = (String)groupRow.getAttribute("GroupName");
          
            logger.info("Rest page  Group Name ::::::::::::::::::::::::::::::::::::::"+groupName);
          
           OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
           oprHashPass.getParamsMap().put("str",newPassword);
           oprHashPass.execute();
           String resetHashPassword = oprHashPass.getResult().toString();
           System.out.println("hashPassword :::::::::::::::::::::      "+resetHashPassword);
            logger.info("Rest page encyptPassword  ::::::::::::  "+resetHashPassword);
          
          
//          OperationBinding oprEncryptPass = getBindings().getOperationBinding("encryptLdapData");
//          oprEncryptPass.getParamsMap().put("value",resetHashPassword);
//          oprEncryptPass.execute();
          String resetEncyptPassword = resetHashPassword;
          System.out.println(" Rest page encyptPassword ::::::::::::::::::::::::::      "+resetEncyptPassword);
           logger.info(" Rest page encyptPassword  ::::::::::::  "+resetEncyptPassword);
        
            if(groupName!=null && bpmGroups.contains(groupName))
            {
            WeblogicUserMgmt wls = new WeblogicUserMgmt();
                String ServerName = "";
                ServerName = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
                 
                
                    try{
                        wls.connect(ServerName);
                        if(wls.IsUserExists(userId)){
                            wls.changeUserPassword(userId, currentPassword, resetEncyptPassword);
                        }else{
                                wls.createUser(userId, resetEncyptPassword, "BPM User");
                                wls.addMemberToGroup(groupName, userId);
                                    
                            }
                       
                       
                        
                    }catch(Exception e) {
                        System.out.println("Edit Error ::::::::::::  "+e);
                        logger.info("Edit Error ::::::::::::  "+e);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Error in connecting to server for User Management."));
                        return "true";
                      
                        }finally{
                            wls.close();
                        }
            }
        //END LDAP CODE
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());    
            row.setAttribute("Lastlogindatetime", sqlDate);  
            OperationBinding operationBindings = bindings.getOperationBinding("commit");
            operationBindings.execute();
            OperationBinding operationBinding = bindings.getOperationBinding("convertPwd");
                operationBinding.getParamsMap().put("userId",userId);
            operationBinding.getParamsMap().put("pwd",newPassword);
            operationBinding.execute();
            
            
            
            if (operationBinding.getErrors().isEmpty()) {
               onClickReset_action();
               
               HidePopup();
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Password Updated Successfully "));             
           }
        }       
        return null;
    }

    public void setPopUp(RichPopup popUp) {
        this.popUp = popUp;
    }

    public RichPopup getPopUp() {
        return popUp;
    }

    public void setCurrentPwd(RichInputText currentPwd) {
        this.currentPwd = currentPwd;
    }

    public RichInputText getCurrentPwd() {
        return currentPwd;
    }

    public void setNewPwd(RichInputText newPwd) {
        this.newPwd = newPwd;
    }

    public RichInputText getNewPwd() {
        return newPwd;
    }

    public void setConfirmNewPwd(RichInputText confirmNewPwd) {
        this.confirmNewPwd = confirmNewPwd;
    }

    public RichInputText getConfirmNewPwd() {
        return confirmNewPwd;
    }

    public void setResetFirstPwd(RichCommandLink resetFirstPwd) {
        this.resetFirstPwd = resetFirstPwd;
    }

    public RichCommandLink getResetFirstPwd() {
        return resetFirstPwd;
    }

    public void setPasswordNote(RichOutputText passwordNote) {
        this.passwordNote = passwordNote;
    }

    public RichOutputText getPasswordNote() {
        return passwordNote;
    }
    
    public  enum bpmGroups {
        appealmanager,
        appealcommitte,
        appealchairman, 
        appealfeedback,
        appealcondept,
        pvtdispatcher,
        permitapprover,
        pvtblkapprover,
        cardapprovergroup,
        bulksecondapprovergroup,
        pvtremovalvhcl;
         private static final long serialVersionUID = 0L;

         public static boolean contains(String s)
       {
           for(bpmGroups group:values())
                if (group.name().equals(s) ) 
                   return true;
           return false;
       } 

     };
}
