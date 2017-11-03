package com.imum.cpms.view.backing;

import com.imum.cpms.model.masters.vo.ShiftMstUVORowImpl;
import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import java.sql.Time;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

public class ShiftMstMBean {
    private RichShowDetailHeader shiftDetailsForm;

    public ShiftMstMBean() {
        if(lngCode==null || lngCode.equals(""))
            {
             lngCode = "EN";
            }
    }
    FacesContext facesContext = FacesContext.getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       HttpSession httpSession = (HttpSession) externalContext.getSession(false);
       String lngCode = httpSession.getAttribute("language").toString();
//                  String lngCode = "EN";
      String userName = httpSession.getAttribute("loggedinUserid").toString();
//        String userName = "VARA"    ;
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    MessageUtil genMsg = new MessageUtil();
    private Boolean operationsPanel = true;
    private Boolean submissionPanel = false;
    private Boolean cancelPanel = false;
    
    private DCBindingContainer getBindings() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public void submitAction(ActionEvent actionEvent) {
        Boolean shiftResult = validateShiftData();
        if(shiftResult)
        {
           OperationBinding op = getBindings().getOperationBinding("doCommit");
           op.execute();  
           if(op.getErrors().isEmpty())
           {   
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Shift Data saved successfully", "Shift Data saved successfully"));                      
                setOperationsPanel(Boolean.TRUE);
                setSubmissionPanel(Boolean.FALSE);
                setCancelPanel(Boolean.FALSE);
                getShiftDetailsForm().setRendered(false);
                ViewObjectImpl shiftFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("ShiftMstUVO2Iterator").getViewObject();
                shiftFormVO.executeQuery();
            }
           else
           {
               setOperationsPanel(Boolean.FALSE);
               setSubmissionPanel(Boolean.TRUE);
               setCancelPanel(Boolean.TRUE);        
           }
        }
        else
        {
            setOperationsPanel(Boolean.FALSE);
            setSubmissionPanel(Boolean.TRUE);
            setCancelPanel(Boolean.TRUE);    
        }
    }    
    public void cancelAction(ActionEvent actionEvent) {
        OperationBinding op = getBindings().getOperationBinding("doRollback");
        op.execute();  
        ViewObjectImpl shiftFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("ShiftMstUVO2Iterator").getViewObject();
        shiftFormVO.executeQuery();
        setOperationsPanel(Boolean.TRUE);
        setSubmissionPanel(Boolean.FALSE);
        setCancelPanel(Boolean.FALSE);
        getShiftDetailsForm().setRendered(false);
    }

    public void newAction(ActionEvent actionEvent) {
        pageflowScope.put("mode","NEW");
        pageflowScope.put("display","TCL");        
        ViewObjectImpl shiftFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("ShiftMstUVO1Iterator").getViewObject();
        shiftFormVO.clearCache();
        shiftFormVO.executeEmptyRowSet();
        Row shiftRow = shiftFormVO.createRow();
        shiftRow.setAttribute("CreatedBy",userName);
        shiftRow.setAttribute("CreatedDate",sqlDate);
        shiftFormVO.insertRow(shiftRow);
        shiftFormVO.setCurrentRow(shiftRow);
        setOperationsPanel(Boolean.FALSE);
        setSubmissionPanel(Boolean.TRUE);
        setCancelPanel(Boolean.TRUE);
        getShiftDetailsForm().setRendered(true);
    }

    public void editAction(ActionEvent actionEvent) {
        displayShiftInForm();
        setSubmissionPanel(Boolean.TRUE);
        setCancelPanel(Boolean.TRUE);
        pageflowScope.put("mode","EDIT");
    }

    public void viewAction(ActionEvent actionEvent) {
        displayShiftInForm();
        setSubmissionPanel(Boolean.FALSE);
        setCancelPanel(Boolean.TRUE);
        pageflowScope.put("mode","VIEW");     
    }
    public void displayShiftInForm()
    {
        if(getBindings().findIteratorBinding("ShiftMstUVO2Iterator").getViewObject().getCurrentRow() != null)
        {
            Object shiftId  = getBindings().findIteratorBinding("ShiftMstUVO2Iterator").getViewObject().getCurrentRow().getAttribute("ShiftId");
            if(shiftId != null)
            {
                ViewObjectImpl shiftFormVO = (ViewObjectImpl)getBindings().findIteratorBinding("ShiftMstUVO1Iterator").getViewObject();     
                shiftFormVO.clearCache();
                shiftFormVO.setWhereClause(null);
                shiftFormVO.setWhereClause("Shift_Id = '"+shiftId+"'");
                shiftFormVO.executeQuery();
                setOperationsPanel(Boolean.FALSE);
                getShiftDetailsForm().setRendered(true);
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));                  
        }
          
    }

    private Boolean validateShiftData() {
        Boolean result = true;
        Integer rowStatus = 0;
       ShiftMstUVORowImpl currRow = (ShiftMstUVORowImpl) getBindings().findIteratorBinding("ShiftMstUVO1Iterator").getViewObject().getCurrentRow();
        if(currRow != null)
        {
            BigDecimal shiftFrom = currRow.getShiftFr();          
            BigDecimal shiftTo = currRow.getShiftTo();
            String shiftDesc = currRow.getShiftDesc();
            if(shiftDesc == null || shiftDesc.equals(""))
            {
                result = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Description is Mandatory", "Description is Mandatory"));                         
            }
            if(shiftFrom == null || shiftFrom.equals(""))
            {
                result = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Shift From is Mandatory", "Shift From is Mandatory"));                         
            }
            if(shiftTo == null || shiftTo.equals(""))
            {
                result = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Shift To is Mandatory", "Shift To is Mandatory"));      
            }
            if( result && shiftFrom.compareTo(shiftTo)>=0)
            {
               result = false;
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Shift From cannot be after Shift To", "Shift From cannot be after Shift To"));                      
            }
            rowStatus = (Integer)currRow.getrowStatus();
            if(result && rowStatus==2)
            {
                    currRow.setAttribute("UpdatedBy",userName);
                    currRow.setAttribute("UpdatedDate",sqlDate);
            }
        }
        else
        {
            result = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));                      
        }
        return result;
    }
    public void setOperationsPanel(Boolean operationsPanel) {
        this.operationsPanel = operationsPanel;
    }

    public Boolean getOperationsPanel() {
        return operationsPanel;
    }

    public void setSubmissionPanel(Boolean submissionPanel) {
        this.submissionPanel = submissionPanel;
    }

    public Boolean getSubmissionPanel() {
        return submissionPanel;
    }

    public void setCancelPanel(Boolean cancelPanel) {
        this.cancelPanel = cancelPanel;
    }

    public Boolean getCancelPanel() {
        return cancelPanel;
    }

    public void setShiftDetailsForm(RichShowDetailHeader shiftDetailsForm) {
        this.shiftDetailsForm = shiftDetailsForm;
    }

    public RichShowDetailHeader getShiftDetailsForm() {
        return shiftDetailsForm;
    }
}
