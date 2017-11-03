package com.imum.cpms.staffdeploy;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.jbo.uicli.binding.*;

import org.apache.myfaces.trinidad.*;

import java.util.Iterator;
import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import org.apache.myfaces.trinidad.model.RowKeySet;


import org.apache.myfaces.trinidad.model.RowKeySet;

public class PIAssignmentDynamicRegion {
    private String taskFlowId =
        "/WEB-INF/staffdeploy/PIAssingnmentEdit-flow-definition.xml#PIAssingnmentEdit-flow-definition";
    private RichTable searchResults;
    public String PId="";

    public PIAssignmentDynamicRegion() {
    }

    public TaskFlowId getDynamicTaskFlowId() {

        return TaskFlowId.parse(taskFlowId);
    }

    public String editPITaskFlow() {
        // Add event code here...
        //  taskFlowId = "/WEB-INF/onstreet/PIAssingnmentEdit-flow-definition.xml#PIAssingnmentEdit-flow-definition";
//        RowKeySet selectedEmps = getSearchResults().getSelectedRowKeys();
//        Iterator selectedEmpIter = selectedEmps.iterator();
//        DCBindingContainer bindings =
//            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        DCIteratorBinding empIter =
//            bindings.findIteratorBinding("PIAssignSearch1Iterator");
//        RowSetIterator empRSIter = empIter.getRowSetIterator();
//        while (selectedEmpIter.hasNext()) {
//            Key key = (Key)((List)selectedEmpIter.next()).get(0);
//            Row currentRow = empRSIter.getRow(key);
//            System.out.println(currentRow.getAttribute("PIid"));
//            AdfFacesContext adctx = AdfFacesContext.getCurrentInstance();
//            if(currentRow.getAttribute("PIid")!=null){
//            adctx.getPageFlowScope().put("PIid",
//                                         currentRow.getAttribute("PIid").toString());
//                PId = currentRow.getAttribute("PIid").toString();
//            }
            taskFlowId =
                    "/WEB-INF/staffdeploy/PIAssingnmentEdit-flow-definition.xml#PIAssingnmentEdit-flow-definition";
//        }
        return null;
    }

    public String getReassignTaskFlow() {
        // Add event code here...
        taskFlowId =
                "/WEB-INF/staffdeploy/reassign-flow-definition.xml#reassign-flow-definition";
        return null;
    }

    public String getUnassignTaskFlow() {
        // Add event code here...
        taskFlowId =
                "/WEB-INF/staffdeploy/PIUnassing-task-flow-definition.xml#PIUnassing-task-flow-definition";
        return null;
    }

    public String getOvertimeTaskFlow() {
        // Add event code here...
        taskFlowId =
                "/WEB-INF/staffdeploy/overtime-flow-definition.xml#overtime-flow-definition";
        return null;
    }

    public void setSearchResults(RichTable searchResults) {
        this.searchResults = searchResults;
    }

    public RichTable getSearchResults() {
        return searchResults;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getPId() {
        return PId;
    }
}

