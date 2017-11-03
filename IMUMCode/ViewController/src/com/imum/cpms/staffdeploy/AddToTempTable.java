package com.imum.cpms.staffdeploy;


import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.swing.JList;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;


public class AddToTempTable {
    private RichTable selectedrow;
    private RichInputDate endDate;
    private RichInputDate startDate;
    
    private Date currentdate = new Date();

    public void setSelectedrow(RichTable selectedrow) {
        this.selectedrow = selectedrow;
    }

    public RichTable getSelectedrow() {
        return selectedrow;
    }

    public AddToTempTable() {
    }


    public String insertToTable() {

        //execute the view criteria
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =
            (DCBindingContainer)lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer)lBindingContainer;
        OperationBinding op2 =
            (OperationBinding)bindingsIte.getOperationBinding("getSectorDetails");
        op2.execute();


        // Add event code here...
        java.util.Date endtDate = null;
        java.util.Date strtDate = null;
        if (startDate.getValue() != null) {
            strtDate = (java.util.Date)startDate.getValue();
        }
        if (startDate.getValue() != null) {
            endtDate = (java.util.Date)startDate.getValue();
        }

        OperationBinding op1 =
            (OperationBinding)bindingsIte.getOperationBinding("getPiWorkStatus");
        
        OperationBinding opat =
            (OperationBinding)bindingsIte.getOperationBinding("getPiAttendanceStatus");
        String status;
        String attstatus;
        attstatus=opat.execute().toString();
        status = op1.execute().toString();
        System.out.println(status);
        if (status.equals("Assigned")|| attstatus.equals("NotPresent") || attstatus.equals("OnLeave")) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PI Status is already Allocated to Sector,Zone,Beat.You can only Amend."));
            if(status.equals("Assigned")){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          "PI Status is already Allocated to Sector,Zone,Beat.You can only Amend."));
            }
            if(attstatus.equals("NotPresent")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              "PI Attendance Status is NotPresent, You cannot Assign or Amend."));
            }
            if(attstatus.equals("OnLeave")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              "PI Attendance Status is OnLeave, You cannot Assign or Amend."));
            }
        } else {

            OperationBinding op =
                (OperationBinding)bindingsIte.getOperationBinding("insertToTable");


            System.out.println(strtDate + "test");
            System.out.println(endtDate + "test");
            op.getParamsMap().put("startDate", strtDate);
            op.getParamsMap().put("endDate", endtDate);

            if (op.execute() != null) {
                System.out.println("Success");
                //            DCBindingContainer dcBindingContainer = getBindings();
                //            OperationBinding op1 = (OperationBinding)dcBindingContainer.getOperationBinding("doCommit");
                //            Boolean result = (Boolean)op1.execute();
                //            System.out.println("Commit :"+result);
            } else {
                System.out.println("Failure");
            }
        }

        return null;

    }

    public void deleteFromTable() {
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =
            (DCBindingContainer)lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer)lBindingContainer;
        OperationBinding op =
            (OperationBinding)bindingsIte.getOperationBinding("deleteFrmTable");
        op.execute();
    }

    public String assign_action() {
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =
            (DCBindingContainer)lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer)lBindingContainer;
        OperationBinding op =
            (OperationBinding)bindingsIte.getOperationBinding("filterSearchResults");
        op.execute();


        // Add event code here...
        return null;
    }

    public void assignValuesToWorkVO(ActionEvent actionEvent) {
       
        DCBindingContainer dcBindingContainer = getBindings();
        OperationBinding op1 =
              (OperationBinding)dcBindingContainer.getOperationBinding("validatePiWorkAssign");
       String stat= op1.execute().toString();
            if(stat.equals("Failure")) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                                          new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                           "Sample info message",
                                                                                           "Please Select Atleast one Sector Zone Beat to assign PI"));
            }
            else{
      OperationBinding op =
            (OperationBinding)dcBindingContainer.getOperationBinding("doCommit");
        Boolean result = (Boolean)op.execute();
        System.out.println("Commit :" + result);
        if(result.equals(true)) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage("Sample info message",
                                                                          "PI's Have been allocated succesfully"));
        }
            }
    }

    public DCBindingContainer getBindings() {
        BindingContext bindingContext = BindingContext.getCurrent();
        DCBindingContainer dcBindingContainer =
            (DCBindingContainer)bindingContext.getCurrent().getCurrentBindingsEntry();
        return dcBindingContainer;
    }


    public void setEndDate(RichInputDate endDate) {
        this.endDate = endDate;
    }

    public RichInputDate getEndDate() {
        return endDate;
    }

    public void setStartDate(RichInputDate startDate) {
        this.startDate = startDate;
    }

    public RichInputDate getStartDate() {
        return startDate;
    }

    public void sectorVal(ValueChangeEvent valueChangeEvent) {
        DCBindingContainer dcBindingContainer = getBindings();
        JUCtrlListBinding JList =
            (JUCtrlListBinding)dcBindingContainer.getControlBinding("SectorVO1");
        Row row = JList.getCurrentRow();
        String sector = (String)row.getAttribute("Sector");
        String rowIDStr = (String)row.getAttribute("ID");
        int rowID = Integer.parseInt(rowIDStr);
        OperationBinding op =
            (OperationBinding)dcBindingContainer.getOperationBinding("sectorSave");
        op.getParamsMap().put("status", sector);
        op.getParamsMap().put("rowID", rowID);
        Boolean result = (Boolean)op.execute();
    }

    public String Ammend_action() {
        String alocstatus = "amend";
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =
            (DCBindingContainer)lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer)lBindingContainer;
        OperationBinding op1 =
            (OperationBinding)bindingsIte.getOperationBinding("getPiWorkStatus");
        String status;
        status = op1.execute().toString();
        System.out.println(status);
        OperationBinding opat =
            (OperationBinding)bindingsIte.getOperationBinding("getPiAttendanceStatus");
        String attstatus=opat.execute().toString();
        if (status.equals("Unassigned")|| attstatus.equals("NotPresent")|| attstatus.equals("OnLeave")) {
            if(status.equals("Unassigned")){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          "PI Status is Un-Assigned-You can not Amend him before Assigning."));
            }
            if(attstatus.equals("NotPresent"))
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PI Status is Un-Assigned-You can not Amend him before Assigning."));
            {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      "PI Attendance Status is NotPresent, You cannot Assign or Amend."));
                        }
            if(attstatus.equals("OnLeave"))
           
            {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      "PI Attendance Status is OnLeave, You cannot Assign or Amend."));
                        }
            alocstatus = "";
        }

        return alocstatus;
    }

    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
    }

    public Date getCurrentdate() {
        return currentdate;
    }

    public void column1_attributeChangeListener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
        System.out.println("Chandu");
    }
}
