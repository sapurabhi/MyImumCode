package com.imum.cpms.view.backing;

import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;

import oracle.binding.OperationBinding;

import oracle.jbo.NavigatableRowIterator;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;

public class GroupUserMgmtMBean {
    private RichTable groupTable;
    private RichShowDetailHeader userPanel;

    public GroupUserMgmtMBean() {
    }
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    //  String userName = httpSession.getAttribute("loggedinUserid").toString();
      String userName = "VARA"    ;
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();

    
    private DCBindingContainer getBindings() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public void newGroupAction(ActionEvent actionEvent) {
       
          CollectionModel tableModel = (CollectionModel)getGroupTable().getValue();
          JUCtrlHierBinding adfModel = (JUCtrlHierBinding)tableModel.getWrappedData();
          DCIteratorBinding dciter = adfModel.getDCIteratorBinding();
          NavigatableRowIterator nav=dciter.getNavigatableRowIterator();
          Row newRow = nav.createRow();
          newRow.setAttribute("CreatedBy",userName);
          newRow.setAttribute("CreatedDate",sqlDate);
          newRow.setNewRowState(Row.STATUS_INITIALIZED);
          nav.insertRowAtRangeIndex(0, newRow);        
          dciter.setCurrentRowWithKey(newRow.getKey().toStringFormat(true));        
          getGroupTable().setActiveRowKey(newRow.getKey());
    
}

    public void setGroupTable(RichTable groupTable) {
        this.groupTable = groupTable;
    }

    public RichTable getGroupTable() {
        return groupTable;
    }

    public void groupSubmitAction(ActionEvent actionEvent) {
        ViewObject groupVO = getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject();
                RowSetIterator deptIter = groupVO.createRowSetIterator(null);
                while (deptIter.hasNext()) {
                    Row nextRow = deptIter.next();
                    if (nextRow.getAttribute("rowStatus") != null) {
                        Integer rowStatus = (Integer)nextRow.getAttribute("rowStatus");
                        if (rowStatus == 2) {
                            nextRow.setAttribute("UpdatedBy",userName);
                            nextRow.setAttribute("UpdatedDate",sqlDate);
                        }
                    }
                }
        OperationBinding op = getBindings().getOperationBinding("doCommit");
        op.execute();  
        if(op.getErrors().isEmpty())
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Group data saved successfully")); 
            getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject().executeQuery();
        }
    }

    public void populateUsers(ActionEvent actionEvent) {
        Object groupId = getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject().getCurrentRow().getAttribute("GroupId");
        if(groupId != null)
        {
            getUserPanel().setRendered(true);  
            getUserPanel().setText("Users for Group : "+getBindings().findIteratorBinding("GroupMstUVO1Iterator").getViewObject().getCurrentRow().getAttribute("GroupName"));
            ViewObjectImpl userReadOnlyVO = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject();
            if(userReadOnlyVO != null)
            {
                userReadOnlyVO.setWhereClause(null);        
                userReadOnlyVO.setWhereClause("Group_Id = "+groupId);
                userReadOnlyVO.executeQuery();
            }
        }
        else if(groupId == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Users unavailable for unsaved groups"));         
        }
    }

    public void setUserPanel(RichShowDetailHeader userPanel) {
        this.userPanel = userPanel;
    }

    public RichShowDetailHeader getUserPanel() {
        return userPanel;
    }

    public void newUserAction(ActionEvent actionEvent) {
        pageflowScope.put("mode","NEW");
        ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject();
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
        Object userId  = getBindings().findIteratorBinding("UserMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("UserId");
        if(userId != null)
        {
            ViewObjectImpl userFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("UserMstUVO1Iterator").getViewObject();      
            userFormVO.setWhereClause(null);
            userFormVO.setWhereClause("User_Id = '"+userId+"'");
            userFormVO.executeQuery();
        }
          
    }
}
