package com.imum.cpms.view.backing;

import com.imum.cpms.ldap.WeblogicUserMgmt;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class ChangePasswordBean {
    private RichInputText currPwd;
    private RichInputText newPwd;
    private RichInputText confirmPwd;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
    String userId = httpSession.getAttribute("loggedinUserid").toString();
    BindingContainer bindings = getBindings();
    
    public static final ADFLogger logger = ADFLogger.createADFLogger(ContraventionMBean.class);
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public ChangePasswordBean() { }

    public void setCurrPwd(RichInputText currPwd) {
        this.currPwd = currPwd;
    }

    public RichInputText getCurrPwd() {
        return currPwd;
    }

    public void setNewPwd(RichInputText newPwd) {
        this.newPwd = newPwd;
    }

    public RichInputText getNewPwd() {
        return newPwd;
    }

    public void setConfirmPwd(RichInputText confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public RichInputText getConfirmPwd() {
        return confirmPwd;
    }

    public String submitAction() {
            Boolean result = true;
            String currentPassword = null;
            String newPassword = null;
            String confirmNewPassword = null;
            DCBindingContainer bindingsImpls = (DCBindingContainer)bindings; 
            DCIteratorBinding dcIterators = bindingsImpls.findIteratorBinding("UserVO1Iterator"); 
            ViewObject validatePasswordVO = dcIterators.getViewObject();
            validatePasswordVO.setWhereClause("user_id= '" + userId + "'");
            validatePasswordVO.executeQuery();
//            Row row = validatePasswordVO.next(); 
//            String password = (String)row.getAttribute("pwd");
            if(currPwd.getValue()==null || currPwd.getValue().equals("")){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Current Password"));
                result = false;
            }else{
                OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
                oprHashPass.getParamsMap().put("str",currPwd.getValue().toString());
                oprHashPass.execute();
                 currentPassword = oprHashPass.getResult().toString();
                 

            }
            if(newPwd.getValue()==null || newPwd.getValue().equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter New Password")); 
                result = false;
            }else{
                OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
                oprHashPass.getParamsMap().put("str",newPwd.getValue().toString());
                oprHashPass.execute();
                 newPassword = oprHashPass.getResult().toString();
                
            }
            if(confirmPwd.getValue()==null || confirmPwd.getValue().equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Confirm New Password")); 
                result = false;
            }else{
                OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
                oprHashPass.getParamsMap().put("str",confirmPwd.getValue().toString());
                oprHashPass.execute();
                 confirmNewPassword = oprHashPass.getResult().toString();
                
            }
            
             String LogIncurrentPassword = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("password");
        OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
        oprHashPass.getParamsMap().put("str",LogIncurrentPassword);
        oprHashPass.execute();
         LogIncurrentPassword = oprHashPass.getResult().toString();
         
             System.out.println("LogIncurrentPassword ::::::::::::::::::::   "+LogIncurrentPassword);
            if(LogIncurrentPassword != null && currentPassword != null && !(LogIncurrentPassword.equals(currentPassword))){
                currPwd.setSubmittedValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(currPwd);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Entered Current Password is wrong"));
                result = false;
            }
            if( !(newPassword.equals(confirmNewPassword))){
                newPwd.setSubmittedValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
                confirmPwd.setSubmittedValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","New Password and Confirm Password do not match")); 
                result = false;
            }
        if( (newPassword.equals(currentPassword))){
            currPwd.setSubmittedValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(currPwd);
            newPwd.setSubmittedValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
            confirmPwd.setSubmittedValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","New Password cannot be same as Current Password")); 
            result = false;
        }
       if(result)
       {
               updateResetPassword();
//               OperationBinding operationBinding = bindings.getOperationBinding("convertPwd");
//                   operationBinding.getParamsMap().put("userId",userId);
//               operationBinding.getParamsMap().put("pwd",newPassword);
//               operationBinding.execute();
//               if(operationBinding.getErrors().isEmpty())
//               {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Password Updated Successfully "));                
//                }
           }        
        return null;
    }
    public String updateResetPassword() 
    {
        String Password1 = null;
        String Password2 = null;
        String Password3 = null;
        String Password4 = null;
        String lastPassword = null;
        String passwordMatched = "No";
        if ((newPwd.getValue() != null) && (!newPwd.getValue().equals(""))) 
        {
            OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
            oprHashPass.getParamsMap().put("str", newPwd.getValue().toString());
            oprHashPass.execute();
            String enteredPassword = oprHashPass.getResult().toString();
             
            
            BindingContainer bindings = this.getBindings();
            DCBindingContainer bindingsImpls = (DCBindingContainer)bindings; 
            DCIteratorBinding dcIterators = bindingsImpls.findIteratorBinding("UserVO1Iterator"); 
            ViewObject validatePasswordVO = dcIterators.getViewObject();
            int userExistss = validatePasswordVO.getEstimatedRangePageCount();
            if (userExistss != 0) 
            {
                Row row = validatePasswordVO.getCurrentRow()!=null ? validatePasswordVO.getCurrentRow() : validatePasswordVO.first();
                if (row != null)
                {
                    if (row.getAttribute("pwd") != null && !row.getAttribute("pwd").equals("")) 
                    {
                        lastPassword = row.getAttribute("pwd").toString();
                        if (lastPassword.equals(enteredPassword)) 
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Password match with previous 5 passwords, Please enter again"));
                            passwordMatched = "Yes";
                            newPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
                            confirmPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
                        }
                    }
                    if (row.getAttribute("pwd1") != null && !row.getAttribute("pwd1").equals("") &&  passwordMatched.equals("No")) 
                    {
                        Password1 = row.getAttribute("pwd1").toString();
                        if (Password1.equals(enteredPassword)) 
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Password match with previous 5 passwords, Please enter again"));
                            passwordMatched = "Yes";
                            newPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
                            confirmPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
                        }
                    }
                    if (row.getAttribute("pwd2") != null && !row.getAttribute("pwd2").equals("") &&  passwordMatched.equals("No")) 
                    {
                        Password2 = row.getAttribute("pwd2").toString();
                        if (Password2.equals(enteredPassword))
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Password match with previous 5 passwords, Please enter again"));
                            passwordMatched = "Yes";
                            newPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
                            confirmPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
                        }
                    }
                    if (row.getAttribute("pwd3") != null && !row.getAttribute("pwd3").equals("") &&  passwordMatched.equals("No")) {
                        Password3 = row.getAttribute("pwd3").toString();
                        if (Password3.equals(enteredPassword)) 
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Password match with previous 5 passwords, Please enter again"));
                            passwordMatched = "Yes";
                            newPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
                            confirmPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
                        }
                    }
                    if (row.getAttribute("pwd4") != null && !row.getAttribute("pwd4").equals("") &&  passwordMatched.equals("No")) 
                    {
                        Password4 = row.getAttribute("pwd4").toString();
                        if (Password4.equals(enteredPassword)) 
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Password match with previous 5 passwords, Please enter again"));
                            passwordMatched = "Yes";
                            newPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
                            confirmPwd.setSubmittedValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
                        }
                    }
                    if (passwordMatched.equalsIgnoreCase("No")) 
                    {
                        DCBindingContainer bindingsImpl = (DCBindingContainer)bindings; 
                        DCIteratorBinding dcIterator = bindingsImpl.findIteratorBinding("ResetPasswordVO1Iterator"); 
                        ViewObject resetPasswordVO = dcIterator.getViewObject();
                        resetPasswordVO.setWhereClause("user_id= '" +userId + "'");
                        resetPasswordVO.executeQuery();
                        int userExists = resetPasswordVO.getEstimatedRangePageCount();
                        if (userExists != 0) 
                        {
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
                                
                                  logger.info("ChnagesPassword page  Group Name ::::::::::::::::::::::::::::::::::::::"+groupName);
                                
                                 OperationBinding oprHashPass1 = getBindings().getOperationBinding("getHashString");
                                 oprHashPass1.getParamsMap().put("str",newPwd.getValue().toString());
                                 oprHashPass1.execute();
                                 String resetHashPassword = oprHashPass1.getResult().toString();
                                 System.out.println("Chnage Password hashPassword :::::::::::::::::::::      "+resetHashPassword);
                                  logger.info("Chnages Password encyptPassword  ::::::::::::  "+resetHashPassword);
                                
                                
//                                OperationBinding oprEncryptPass = getBindings().getOperationBinding("encryptLdapData");
//                                oprEncryptPass.getParamsMap().put("value",resetHashPassword);
//                                oprEncryptPass.execute();
                                String resetEncyptPassword =resetHashPassword;// oprEncryptPass.getResult().toString();
                                System.out.println(" Chnages Password page encyptPassword ::::::::::::::::::::::::::      "+resetEncyptPassword);
                                 logger.info(" Chnages Password page encyptPassword  ::::::::::::  "+resetEncyptPassword);
                                WeblogicUserMgmt wls = new WeblogicUserMgmt();
                                String ServerName = "";
                                ServerName = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
                                 
                                

                                  if(groupName!=null && bpmGroups.contains(groupName))
                                  {
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

                                   OperationBinding operationBindings = bindings.getOperationBinding("convertPwd");
                                   operationBindings.getParamsMap().put("userId",userId.toString());
                                   operationBindings.getParamsMap().put("pwd",newPwd.getValue().toString());
                                   operationBindings.execute();

                                    if(operationBindings.getErrors().isEmpty())
                                    {
                                        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//                                        HttpServletResponse httpResponse = (HttpServletResponse)externalContext.getResponse();
                                        HttpSession httpSession = (HttpSession)externalContext.getSession(true);
                                                
                                        httpSession.setAttribute("encyptPassword", resetEncyptPassword);
                                        
                                        currPwd.resetValue();
                                        newPwd.resetValue();
                                        confirmPwd.resetValue();
                                        
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Password Updated Successfully "));                
                                           
                                    }
                                    else
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Invalid password, Please enter again"));   
                                    }   
                            } 
                             else
                             {
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Invalid password, Please enter again"));   
                             }
                        }
                     }
                  }
              }
        } 
        else 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Invalid password, Please enter again"));
        }
        return "true";
    }
    public String resetAction() {
        currPwd.setSubmittedValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(currPwd);
        newPwd.setSubmittedValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(newPwd);
        confirmPwd.setSubmittedValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPwd);
        return null;
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
