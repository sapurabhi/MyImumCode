package com.imum.cpms.view.backing;

import com.imum.cpms.util.MessageUtil;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;

public class GroupMgmtMBean {
    public GroupMgmtMBean() {
        if(lngCode==null || lngCode.equals(""))
            {
             lngCode = "EN";
            }
    }

    FacesContext facesContext = FacesContext.getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String userName = httpSession.getAttribute("loggedinUserid").toString();
//      String userName = "VARA"    ;
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    
    private DCBindingContainer getBindings() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public void newUserAction(ActionEvent actionEvent) {
        pageflowScope.put("mode","NEW");
        pageflowScope.put("display","TCL");        
        ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject();
        Row userRow = userFormVO.createRow();
        userRow.setAttribute("CreatedBy",userName);
        userRow.setAttribute("CreatedDate",sqlDate);
        userFormVO.insertRow(userRow);
        userFormVO.setCurrentRow(userRow);
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
        if(getBindings().findIteratorBinding("GroupMstUVO2Iterator").getViewObject().getCurrentRow() != null)
        {
            Object groupId  = getBindings().findIteratorBinding("GroupMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("GroupId");
            if(groupId != null)
            {
                ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject();      
                userFormVO.setWhereClause(null);
                userFormVO.setWhereClause("Group_Id = '"+groupId+"'");
                userFormVO.executeQuery();
                pageflowScope.put("display","TCL");
            }   
        }          
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));                     
        }
    }
    
    public void submitAction(ActionEvent actionEvent) {
        Boolean result = validateGroup();
        if(result)
        {
            Row currRow = getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject().getCurrentRow();
            Integer rowStatus = (Integer)currRow.getAttribute("rowStatus");
            if (rowStatus == 2) { 
                currRow.setAttribute("UpdatedBy",userName);
                currRow.setAttribute("UpdatedDate",sqlDate);
            }                                
            OperationBinding op = getBindings().getOperationBinding("doCommit");
            op.execute();  
            if(op.getErrors().isEmpty())
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("270",lngCode))); 
                getBindings().findIteratorBinding("GroupMstUVO2Iterator").getViewObject().executeQuery();
            }
            pageflowScope.put("display","DML");   
            pageflowScope.put("mode","VIEW");
        }
    }
    
    public Boolean validateGroup()
    {
       Boolean result = true;
        Row row = getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject().getCurrentRow();         
        if(row != null)
        {
            Object grpName = row.getAttribute("GroupName");
            Object country = row.getAttribute("CountryCode");
            if(grpName==null || grpName.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("269",lngCode))); 
                result = false;
            }   
            if(country==null || country.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("215",lngCode))); 
                result = false;
            }
            if(grpName != null || country != null)
            {
                ViewObjectImpl vo = (ViewObjectImpl)getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject();
                RowQualifier qual = new RowQualifier("GroupName = '"+grpName+"'"); 
                Row filRows[] = vo.getFilteredRows(qual);
                if(filRows.length>1)
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("62",lngCode)));     
                    result = false;
                }
            }
        }
        return result;
    }
    public void cancelAction(ActionEvent actionEvent) {
        OperationBinding op = getBindings().getOperationBinding("doRollback");
        op.execute();  
        pageflowScope.put("display","DML");
        pageflowScope.put("mode","VIEW");
    }

    public void displayDML() {
        pageflowScope.put("display","DML"); 
        pageflowScope.put("mode","VIEW");
    }
}
