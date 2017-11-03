package com.imum.cpms.view.backing;

import com.imum.cpms.ldap.WeblogicUserMgmt;
import com.imum.cpms.util.MessageUtil;

import com.imum.cpms.util.Shuttle;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;


import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectManyShuttle;


import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;


public class UserMgmtMBean {

    public static final ADFLogger logger = ADFLogger.createADFLogger(UserMgmtMBean.class);
    private RichSelectManyShuttle roleUserShuttle;
    private RichInputText userIdBinding;
    private String OldPassword = "";
    private String OldSecAns = "";

    public UserMgmtMBean() {
        if(lngCode==null || lngCode.equals(""))
            {
             lngCode = "EN";
            }
    }
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       HttpSession httpSession = (HttpSession) externalContext.getSession(false);
       String lngCode = httpSession.getAttribute("language").toString();
//              String lngCode = "EN";
      String userName = httpSession.getAttribute("loggedinUserid").toString();
//    String userName = "VARA"    ;
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    MessageUtil genMsg = new MessageUtil();
    
    private DCBindingContainer getBindings() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public void newUserAction(ActionEvent actionEvent) {
        pageflowScope.put("mode","NEW");
        pageflowScope.put("display","TCL");        
        ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject();
        userFormVO.clearCache();
        userFormVO.executeEmptyRowSet();
        Row userRow = userFormVO.createRow();
        userRow.setAttribute("Createdby",userName);
        userRow.setAttribute("Createddate",sqlDate);
        userFormVO.insertRow(userRow);
        userFormVO.setCurrentRow(userRow);
        List returnList = (List)getSelectedRoles();
    }

    public void editUserAction(ActionEvent actionEvent) {
        displayUserInForm();
        pageflowScope.put("mode","EDIT");
    }

    public void viewUserAction(ActionEvent actionEvent) {
        displayUserInForm();
        pageflowScope.put("mode","VIEW");       
    }
    
    public void displayUserInForm()
    {
        if(getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().getCurrentRow() != null)
        {
            Object userId  = getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("UserId");
              String ActiveFlag  = getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("ActiveFlag").toString();
            String UserIdScope = null;
            String oldgroupid = null;
              if(userId !=null)
              {
                  pageflowScope.put("usernameuserid",userId);
               UserIdScope = getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("Usernum").toString();
              }
              if(getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("GroupId") !=null)
               oldgroupid = getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("GroupId").toString();
              pageflowScope.put("ActiveFlag",ActiveFlag);
              pageflowScope.put("UserIdScope",UserIdScope);
            pageflowScope.put("oldgroupid",oldgroupid);
            
            if(userId != null)
            {
                pageflowScope.put("userId",userId);
                ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject();     
                userFormVO.clearCache();
                userFormVO.setWhereClause(null);
                userFormVO.setWhereClause("User_Id = '"+userId+"'");
                userFormVO.executeQuery();
                OldPassword = userFormVO.first().getAttribute("Password")==null ?"" : userFormVO.getCurrentRow().getAttribute("Password").toString();
                OldSecAns = userFormVO.first().getAttribute("Secretans") == null ? "" : userFormVO.getCurrentRow().getAttribute("Secretans").toString();
                    
                    pageflowScope.put("OldPassword", OldPassword);
                    pageflowScope.put("OldSecAns", OldSecAns);
                pageflowScope.put("display","TCL");
                //List returnList = (List)getSelectedRoles();
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));                  
        }
          
    }
    public String submitAction(ActionEvent actionEvent) {
            Boolean userResult = validateUserData();
            String clickedButtonVal =(String)ADFContext.getCurrent().getPageFlowScope().get("clickedButton");
            if(userResult)
            {
                String roleid=null;
                DCBindingContainer dcbindings1 = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding iterator1 = dcbindings1.findIteratorBinding("GenRoleUVO2Iterator");
                ViewObject genrolevo=iterator1.getViewObject();
                genrolevo.setWhereClause("GenRoleEO.role_Name='MDReadOnly'");
                System.out.println("Query is:::"+genrolevo.getQuery());
                genrolevo.executeQuery();
                Row row=genrolevo.first();
                roleid=row.getAttribute("RoleID").toString();
                BigDecimal newroleid=new BigDecimal(roleid);
               
                ArrayList<String> list =
                 (ArrayList<String>)Shuttle.getSelected("UserRoleMapUVO3Iterator",
                                        "RoleID");  
                System.out.println("selected role are"+list);
                if(list.size()>1 && list.contains(newroleid)){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Master Data Read Only role cannot be assigned along with any other role."));    
                 
                }
                else{
               
                Boolean userRoleMapResult = (Boolean)pageflowScope.get("mapResult");
                if(userRoleMapResult==null)
                {
                    userRoleMapResult = true;    
                }
                
               if(userRoleMapResult)
               {
                   String Activeflag  = null;
                   String ActiveFlagold  = null;
                   String UserIdScope = null;
                   String newgroupid = null;
                   Row currRow = getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject().getCurrentRow();
                           Integer rowStatus = (Integer)currRow.getAttribute("rowStatus");
                           if(currRow.getAttribute("ActiveFlag") != null)
                   Activeflag =currRow.getAttribute("ActiveFlag").toString();
                   if(currRow.getAttribute("GroupId") != null)
                   newgroupid = currRow.getAttribute("GroupId").toString();
                   
                           if (rowStatus == 2) { 
                               currRow.setAttribute("UpdatedBy",userName);
                               currRow.setAttribute("UpdatedDate",sqlDate);
                           }
                           if(currRow.getAttribute("ActiveFlag") != null && clickedButtonVal !=null && clickedButtonVal.equalsIgnoreCase("NEW"))
                           {
                          
                            if(Activeflag != null && Activeflag.equals("Y") ) 
                            {
                                currRow.setAttribute("lastactivateddate",sqlDate);
                                
                            }
                               else if(Activeflag != null && Activeflag.equals("N") )
                               {
                                   currRow.setAttribute("lastDeactivateddate",sqlDate);  
                               }
                                
                           }
                 
                           if(pageflowScope.get("ActiveFlag") != null)
                            ActiveFlagold = pageflowScope.get("ActiveFlag").toString();
                           if( pageflowScope.get("UserIdScope") != null)
                            UserIdScope = pageflowScope.get("UserIdScope").toString();
                   if(clickedButtonVal !=null && clickedButtonVal.equalsIgnoreCase("EDIT")) 
                   {
                       if(Activeflag != null && ActiveFlagold != null)
                       {
                           System.out.println(Activeflag);
                           System.out.println( );
                           
                           
                       if((ActiveFlagold.equalsIgnoreCase("Y")&&Activeflag.equalsIgnoreCase("N"))||(ActiveFlagold.equalsIgnoreCase("N")&&Activeflag.equalsIgnoreCase("Y")))
                    {
                           if(Activeflag != null && Activeflag.equals("Y") ) 
                           {
                               currRow.setAttribute("lastactivateddate",sqlDate);
                               String userName = httpSession.getAttribute("loggedinUserid").toString();
                               OperationBinding op2 = getBindings().getOperationBinding("CreateGenEventDetails");
                               op2.getParamsMap().put("depositAckSeqbigD",UserIdScope);
                               op2.getParamsMap().put("NewDepSlip",null);
                                op2.getParamsMap().put("OldDepSlip",null);
                               op2.getParamsMap().put("encoder",userName);
                               op2.getParamsMap().put("EventId",704);
                               
                               op2.execute();
                               
                           }
                              else if(Activeflag != null && Activeflag.equals("N") )
                              {
                                  currRow.setAttribute("lastDeactivateddate",sqlDate);  
                                  String userName = httpSession.getAttribute("loggedinUserid").toString();
                                  OperationBinding op2 = getBindings().getOperationBinding("CreateGenEventDetails");
                                  op2.getParamsMap().put("depositAckSeqbigD",UserIdScope);
                                  op2.getParamsMap().put("NewDepSlip",null);
                                   op2.getParamsMap().put("OldDepSlip",null);
                                  op2.getParamsMap().put("encoder",userName);
                                  op2.getParamsMap().put("EventId",705);
                                  
                                  op2.execute();
                              }
                      
                           
                       }
                       }
                   }
                       

                   
                       OldPassword = pageflowScope.get("OldPassword")==null ? "" : pageflowScope.get("OldPassword").toString();
                       OldSecAns=pageflowScope.get("OldSecAns") == null ? "" : pageflowScope.get("OldSecAns").toString();
                       String isPwdMod = OldPassword.equals(pageflowScope.get("pwd").toString()) ? "N" : "Y";
                       String isSaMod = OldSecAns.equals(pageflowScope.get("secans").toString())? "N" : "Y";
                       String isGroupchanged  = null;
                       if(clickedButtonVal !=null && clickedButtonVal.equalsIgnoreCase("EDIT")) {
                       if(pageflowScope.get("oldgroupid") != null)
                        isGroupchanged = newgroupid.equals(pageflowScope.get("oldgroupid").toString()) ? "N" : "Y";
                       if(isPwdMod.equals("Y"))
                       {
                           String userName = httpSession.getAttribute("loggedinUserid").toString();
                           OperationBinding op2 = getBindings().getOperationBinding("CreateGenEventDetails");
                           op2.getParamsMap().put("depositAckSeqbigD",UserIdScope);
                           op2.getParamsMap().put("NewDepSlip",pageflowScope.get("pwd") == null ? "" : pageflowScope.get("pwd").toString() );
                            op2.getParamsMap().put("OldDepSlip",OldPassword);
                           op2.getParamsMap().put("encoder",userName);
                           op2.getParamsMap().put("EventId",707);
                           
                           op2.execute();
                           
                       }
                       if(isGroupchanged !=null){
                       if(isGroupchanged.equals("Y")) 
                       {
                           String userName = httpSession.getAttribute("loggedinUserid").toString();
                           OperationBinding op2 = getBindings().getOperationBinding("CreateGenEventDetails");
                           op2.getParamsMap().put("depositAckSeqbigD",UserIdScope);
                           op2.getParamsMap().put("NewDepSlip",newgroupid);
                            op2.getParamsMap().put("OldDepSlip",pageflowScope.get("oldgroupid") == null ? "" : pageflowScope.get("oldgroupid").toString());
                           op2.getParamsMap().put("encoder",userName);
                           op2.getParamsMap().put("EventId",708);
                           
                           op2.execute();
                       }

                       }                       
                       }
                       
                       //ldap related code
                       
                       Integer groupId  = (Integer)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject().getCurrentRow().getAttribute("GroupId");
                       DCBindingContainer dcbindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                       DCIteratorBinding iterator = dcbindings.findIteratorBinding("GroupMstUVO1Iterator");
                       Key key = new Key(new Object[] { groupId });
                       RowSetIterator rsi = iterator.getRowSetIterator();
                       Row groupRow = rsi.findByKey(key, 1)[0];
                       String groupName = (String)groupRow.getAttribute("GroupName");
                       
                       logger.info("Edit Group Name ::::::::::::::::::::::::::::::::::::::"+groupName);
                   String hashPassword ="";
                       if(pageflowScope.get("OldPassword")!=null && pageflowScope.get("OldPassword").toString().equals(pageflowScope.get("pwd").toString())){
                           hashPassword =pageflowScope.get("pwd").toString();
                       }else{
                               OperationBinding oprHashPass = getBindings().getOperationBinding("getHashString");
                               oprHashPass.getParamsMap().put("str",pageflowScope.get("pwd").toString());
                               oprHashPass.execute();
                               hashPassword = oprHashPass.getResult().toString();
                               
                           }
                        System.out.println("hashPassword :::::::::::::::::::::      "+hashPassword);
                         logger.info("encyptPassword  ::::::::::::  "+hashPassword);
                       
                       
                      /* OperationBinding oprEncryptPass = getBindings().getOperationBinding("encryptLdapData");
                       oprEncryptPass.getParamsMap().put("value",hashPassword);
                       oprEncryptPass.execute();
                       String encyptPassword = oprEncryptPass.getResult().toString(); */
                   String encyptPassword = hashPassword;
                       System.out.println("encyptPassword ::::::::::::::::::::::::::      "+encyptPassword);
                       logger.info("encyptPassword  ::::::::::::  "+encyptPassword);
                       
                   WeblogicUserMgmt wls = new WeblogicUserMgmt();
                   String userId = pageflowScope.get("userId").toString();
                   String ServerName = "";
                   ServerName = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
                    
                      
                       if(clickedButtonVal !=null && clickedButtonVal.equalsIgnoreCase("NEW"))
                       {     
                           if(groupName!= null && bpmGroups.contains(groupName))
                           {
                           try{
                            
                               wls.connect(ServerName);
                               wls.createUser(userId, encyptPassword, "BPM User");
                               wls.addMemberToGroup(groupName, userId);
                               
                               // cust.addToGroup(u.getDnFull(), "Administrators");
                        } catch(Exception e) {
                                  System.out.println("create Error ::::::::::::  "+e);
                                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Error in connecting to server for User Management."));    
                                  return "true";
                              }finally{
                                   wls.close();
                               }
                           }
                       }else if(clickedButtonVal !=null && clickedButtonVal.equalsIgnoreCase("EDIT")) {
                           
                           if(groupName!=null && bpmGroups.contains(groupName))
                           {
                           try{
                               wls.connect(ServerName);
                               if(wls.IsUserExists(userId)){
                                   wls.changeUserPassword(userId, OldPassword, encyptPassword);
                               }else{
                                       wls.createUser(userId, encyptPassword, "BPM User");
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
                         }

                   
                   // END LDAP CODE
                   if(currRow != null)
                   {
                       currRow.setAttribute("Password",null); 
                       currRow.setAttribute("Secretans",null);   
                   }
                       
                       OperationBinding opr = getBindings().getOperationBinding("convertPwdSecAns");
                       opr.getParamsMap().put("userId",pageflowScope.get("userId").toString());
                       opr.getParamsMap().put("pwd",pageflowScope.get("pwd").toString());
                       opr.getParamsMap().put("secans",pageflowScope.get("secans").toString());
                   opr.getParamsMap().put("mode",pageflowScope.get("mode").toString());
                   
                   opr.getParamsMap().put("isPwdMod",isPwdMod);
                   opr.getParamsMap().put("isSaMod",isSaMod);
                       opr.execute();  
                       if(opr.getErrors().isEmpty())
                       {
                           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message",genMsg.getMessage("1", lngCode))); 
                           getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().executeQuery();
                           ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject();     
                           userFormVO.clearCache();
                           DCIteratorBinding iter = getBindings().findIteratorBinding("UserRoleMapUVO3Iterator");
                           iter.getViewObject().clearCache();
                       }
//                   }
                   pageflowScope.put("display","DML");  
                   pageflowScope.put("mode","VIEW");
               } 
            }
            }
            return "true";
        }

    public void cancelAction(ActionEvent actionEvent) {
        OperationBinding op = getBindings().getOperationBinding("doRollback");
        op.execute();  
        pageflowScope.put("display","DML");
        pageflowScope.put("mode","VIEW");
        ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject();     
        userFormVO.clearCache();
        DCIteratorBinding iter = getBindings().findIteratorBinding("UserRoleMapUVO3Iterator");
        iter.getViewObject().clearCache();
    }

    public void displayDML() {
        pageflowScope.put("display","DML"); 
        pageflowScope.put("mode","VIEW");
    }

    
    public Boolean validateUserData()
    {
        Boolean result = true;
        Row row  = getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject().getCurrentRow(); 
        if(row != null)
        {
            Object userID = row.getAttribute("UserId");
            Object firstName = row.getAttribute("FirstName");
            Object lastName = row.getAttribute("LastName");
            Object gender = row.getAttribute("Gender");
//            Object dob = row.getAttribute("BirthDate");
            Object prefComm = row.getAttribute("PrefComm");
            Object secQues = row.getAttribute("Secretqust");
            Object secAns = row.getAttribute("Secretans");
            Object password = row.getAttribute("Password");
            Object lCountry = row.getAttribute("LocalCountry");
            Object lCity = row.getAttribute("LocalCity");
//            Object lAddr = row.getAttribute("LocalAdd1");
//            Object pCountry = row.getAttribute("PermCountry");
//            Object pCity = row.getAttribute("PermCity");
//            Object pAddr = row.getAttribute("PermAdd1");
            Object group = row.getAttribute("GroupId");
            Object mgr = row.getAttribute("ManagerId");
            Object printId = row.getAttribute("LoginPrintID");
            if(userID==null || userID.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("3",lngCode))); 
                result = false;
            }
            if(firstName==null || firstName.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("4",lngCode)));
                result = false;
            }
            if(lastName==null || lastName.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("5",lngCode)));
                result = false;
            }
            if(gender==null || gender.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("6",lngCode)));
                result = false;
            }
//            if(dob==null || dob.equals(""))
//            {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("7",lngCode)));
//                result = false;
//            }
            if(prefComm==null || prefComm.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("8",lngCode)));
                result = false;
            }
            if(secQues==null || secQues.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("9",lngCode)));
                result = false;
            }
            if(secAns==null || secAns.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("10",lngCode)));
                result = false;
            }
            if(password==null || password.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("11",lngCode)));
                result = false;
            }
            if(lCountry==null || lCountry.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("12",lngCode)));
                result = false;
            }
            if(lCity==null || lCity.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("13",lngCode)));
                result = false;
            }
//            if(lAddr==null || lAddr.equals(""))
//            {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("14",lngCode)));
//                result = false;
//            }
//            if(pCountry==null || pCountry.equals(""))
//            {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("15",lngCode)));
//                result = false;
//            }
//            if(pCity==null || pCity.equals(""))
//            {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("16",lngCode)));
//                result = false;
//            }
//            if(pAddr==null || pAddr.equals(""))
//            {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("17",lngCode)));
//                result = false;
//            }
            if(group==null || group.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("18",lngCode)));
                result = false;
            }
           /*  if(mgr==null || mgr.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("19",lngCode)));
                result = false;
            } */
            if(printId==null || printId.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("21",lngCode)));
                result = false;
            }
            if(result)
            {
                ViewObjectImpl vo = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject();
                RowQualifier qual = new RowQualifier("UserId = '"+userID+"'"); 
                Row filRows[] = vo.getFilteredRows(qual);
                if(filRows.length>1)
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("20",lngCode)));     
                    result = false;
                }
//                if(pageflowScope.get("mode").equals("NEW"))
//                {
//                    java.sql.Date sysDate = new java.sql.Date(new java.util.Date().getTime());
//                    java.sql.Date SysDate = java.sql.Date.valueOf(sysDate.toString());
//                    java.sql.Date dateOfBirth = java.sql.Date.valueOf(dob.toString());
//                    if(dateOfBirth.compareTo(SysDate)>0)
//                    {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("271",lngCode)));    
//                        result = false; 
//                    }
//                }                
                if(result)
                {
                    pageflowScope.put("pwd", password.toString());   
                    pageflowScope.put("secans", secAns.toString());     
                }        
            }
        }
        return result;
        
    }    
//    public Boolean validateUserRoleMap(ArrayList checkListNew)
//    {
//       Boolean result = true;
////        ArrayList checkListNew = new ArrayList();
//       ArrayList checkListOld = new ArrayList();
//        Object userId = pageflowScope.get("userId");
//        if(userId == null)
//        {
//            userId = getUserIdBinding().getValue();
//            if(pageflowScope.get("mode").equals("NEW"))
//            {
//                pageflowScope.put("userId",userId);   
//            }
//        }
////        JUCtrlListBinding listBindings = (JUCtrlListBinding)getBindings().get("RoleLOVVO1");
////        Object[] selectedVals = listBindings.getSelectedValues();
////        for(int i = 0; i<selectedVals.length; i++)
////        {
////            checkListNew.add(selectedVals[i])  ; 
////        }
//        checkListOld = (ArrayList)pageflowScope.get("list");
//        DCIteratorBinding iter = getBindings().findIteratorBinding("UserRoleMapUVO3Iterator");
//        ViewObjectImpl userRoleMapvo = (ViewObjectImpl)iter.getViewObject();
//        if(checkListNew == null || checkListNew.size() <= 0)
//        {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("2",lngCode) ));    
//            result = false;
//        }
//        else
//        {
//            
//            if(checkListOld!=null && checkListOld.size()>0 && checkListNew!=null && checkListNew.size()>0)
//            {
//                for(int j = 0; j<checkListNew.size();j++)
//                {
//                    Object newVal = checkListNew.get(j);
//                    for(int k=0; k<checkListOld.size(); k++)
//                    {
//                        Object oldVal = checkListOld.get(k);
//                        if(newVal.toString().equals(oldVal.toString()))
//                        {
//                            checkListOld.remove(k);
//                            checkListNew.remove(j);  
//                        }                        
//                    }
//                }
//            }
//            if(checkListOld!=null && checkListOld.size()>0)
//            {
//                for (int i =0; i<checkListOld.size(); i++) {
//                    Object role = checkListOld.get(i);
//                    RowQualifier qualf = new RowQualifier("userid = '"+userId+"' AND RoleID = "+role+" AND activeflag = 'Y' "); 
//                    System.out.println("Qualifier Old : "+qualf.getWhereClause());
//                    Row oldRow[] = userRoleMapvo.getFilteredRows(qualf) ;
//                    if(oldRow.length >0)
//                    {
//                        for(Row curOldRow : oldRow)
//                        {
//                            curOldRow.setAttribute("activeflag",'N');
//                            curOldRow.setAttribute("Updatedby",userName);
//                            curOldRow.setAttribute("Updateddate",sqlDate);
//                        }
//                    }
//                }
//            }
//            if(checkListNew!=null && checkListNew.size()>0)
//            {
//                for (int i =0; i<checkListNew.size(); i++) {
//                    Object role = checkListNew.get(i);
//                    RowQualifier qualf = new RowQualifier("userid = '"+userId+"' AND RoleID = "+role+" AND activeflag = 'N' ");
//                    System.out.println("Qualifier New : "+qualf.getWhereClause());
//                    Row newRow[] = userRoleMapvo.getFilteredRows(qualf) ;
//                    if(newRow.length >0)
//                    {
//                        for(Row curNewRow : newRow)
//                        {
//                            curNewRow.setAttribute("activeflag",'Y');
//                            curNewRow.setAttribute("Updatedby",userName);
//                            curNewRow.setAttribute("Updateddate",sqlDate);
//                        }
//                    }
//                    else
//                    {
//                        Row freshRow = userRoleMapvo.createRow();
//                        freshRow.setAttribute("RoleID", role);
//                        freshRow.setAttribute("userid", userId);
//                        freshRow.setAttribute("activeflag", 'Y');
//                        freshRow.setAttribute("CreatedBy",userName);
//                        freshRow.setAttribute("CreatedDate",sqlDate);
//                        userRoleMapvo.insertRow(freshRow);
//                    }
//                }    
//            }   
//        }
//        return result;
//    }
    public Boolean validateUserRoleMap(ArrayList checkListNew)
    {
       Boolean result = true;
//        ArrayList checkListNew = new ArrayList();
       ArrayList checkListOld = new ArrayList();       
       Object userId = null;
       
       if(pageflowScope.get("mode").equals("NEW"))
        {
            userId = getUserIdBinding().getValue();
            pageflowScope.put("userId",userId);   
        }else{
            userId = pageflowScope.get("userId");
        }
       
//        JUCtrlListBinding listBindings = (JUCtrlListBinding)getBindings().get("RoleLOVVO1");
//        Object[] selectedVals = listBindings.getSelectedValues();
//        for(int i = 0; i<selectedVals.length; i++)
//        {
//            checkListNew.add(selectedVals[i])  ; 
//        }
        checkListOld = (ArrayList)pageflowScope.get("list");
        DCIteratorBinding iter = getBindings().findIteratorBinding("UserRoleMapUVO3Iterator");
        ViewObjectImpl userRoleMapvo = (ViewObjectImpl)iter.getViewObject();
        if(checkListNew == null || checkListNew.size() <= 0)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("2",lngCode) ));    
            result = false;
        }
        else
        {
            
//            if(checkListOld!=null && checkListOld.size()>0 && checkListNew!=null && checkListNew.size()>0)
//            {
//                int newSize = checkListNew.size();
//                int oldSize = checkListOld.size();
//                for(int j = 0; j<newSize;j++)
//                {
//                    Object newVal = checkListNew.get(j);
//                    for(int k=0; k<oldSize; k++)
//                    {
//                        Object oldVal = checkListOld.get(k);
//                        if(newVal.toString().equals(oldVal.toString()))
//                        {
//                            checkListOld.remove(k);
//                            checkListNew.remove(j); 
//                            newSize = checkListNew.size();
//                            oldSize = checkListOld.size();
//                        }                        
//                    }
//                }
//            }
            if(checkListOld!=null && checkListOld.size()>0)
            {
                System.out.println("checkListOld : "+checkListOld.size());
                for (int i =0; i<checkListOld.size(); i++) {
                    Object role = checkListOld.get(i);
                    RowQualifier qualf = new RowQualifier("userid = '"+userId+"' AND RoleID = "+role+" AND activeflag = 'Y' "); 
                    System.out.println("Qualifier Old : "+qualf.getWhereClause());
                    Row oldRow[] = userRoleMapvo.getFilteredRows(qualf) ;
                    if(oldRow.length >0)
                    {
                        for(Row curOldRow : oldRow)
                        {
                            curOldRow.remove();
//                            curOldRow.setAttribute("activeflag",'N');
//                            curOldRow.setAttribute("Updatedby",userName);
//                            curOldRow.setAttribute("Updateddate",sqlDate);
                        }
                    }
                }
            }
            if(checkListNew!=null && checkListNew.size()>0)
            {
                System.out.println("checkListNew : "+checkListNew.size());
               for (int i =0; i<checkListNew.size(); i++) {
                    Object role = checkListNew.get(i);
//                    RowQualifier qualf = new RowQualifier("userid = '"+userId+"' AND RoleID = "+role+" AND activeflag = 'N' ");
//                    System.out.println("Qualifier New : "+qualf.getWhereClause());
//                    Row newRow[] = userRoleMapvo.getFilteredRows(qualf) ;
//                    if(newRow.length >0)
//                    {
//                        for(Row curNewRow : newRow)
//                        {
//                            curNewRow.setAttribute("activeflag",'Y');
//                            curNewRow.setAttribute("Updatedby",userName);
//                            curNewRow.setAttribute("Updateddate",sqlDate);
//                        }
//                    }
//                    else
//                    {
                        Row freshRow = userRoleMapvo.createRow();
                        freshRow.setAttribute("RoleID", role);
                        freshRow.setAttribute("userid", userId);
                        freshRow.setAttribute("activeflag", 'Y');
                        freshRow.setAttribute("CreatedBy",userName);
                        freshRow.setAttribute("CreatedDate",sqlDate);
                        userRoleMapvo.insertRow(freshRow);
//                    }
                }    
            }   
        }
        return result;
    }
    public List<SelectItem> getAllRoles() {
        return Shuttle.getAll("RoleLOVVO1Iterator", "roleid",
                              "roledesc");
    }
    public List getSelectedRoles() {
        List list = new ArrayList();
        list = Shuttle.getSelected("UserRoleMapUVO3Iterator",
                                   "RoleID");
        pageflowScope.put("list", list);
        return list;
    }

    public void setSelectedRoles(List selectedValues) {
        System.out.println(selectedValues);
        Boolean result = validateUserRoleMap((ArrayList)selectedValues);
        pageflowScope.put("mapResult",result);
//        String clickedButtonVal =(String)ADFContext.getCurrent().getPageFlowScope().get("clickedButton");
//        Shuttle.setSelected(selectedValues, "RoleID",
//                            "UserRoleMapUVO3Iterator", "RoleID",
//                            "RoleID", "Delete", "CreateInsert",clickedButtonVal);
    }
    public void setRoleUserShuttle(RichSelectManyShuttle roleUserShuttle) {
        this.roleUserShuttle = roleUserShuttle;
    }

    public RichSelectManyShuttle getRoleUserShuttle() {
        return roleUserShuttle;
    }

    public void setUserIdBinding(RichInputText userIdBinding) {
        this.userIdBinding = userIdBinding;
    }

    public RichInputText getUserIdBinding() {
        return userIdBinding;
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
        clampapproverGroup,
        institutequotagroup,
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
