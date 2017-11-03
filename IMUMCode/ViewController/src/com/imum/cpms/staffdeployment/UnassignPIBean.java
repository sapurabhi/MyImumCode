package com.imum.cpms.staffdeployment;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.binding.OperationBinding;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewObject;

public class UnassignPIBean {
    private RichTable piSupAllocTableBind;
    String supId="";
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);

    public UnassignPIBean() {
    }
    private DCBindingContainer getBindings1() {
                return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            }
    public String unAssignAction() {
        String userName = "";
        String ssup=(String)httpSession.getAttribute("seniourSup");
        if(ssup!=null){
        if(ssup.equalsIgnoreCase("SeniourSupervisor")){
        userName=supId;
        } 
        }
        else{
        ADFContext adfctx = ADFContext.getCurrent();
        if(adfctx.getSessionScope().get("loggedinUserid")!=null){
            userName = adfctx.getSessionScope().get("loggedinUserid").toString(); 
        }
        }
        String result=null;
        ViewObject piSupAllocVO = getBindings1().findIteratorBinding("PIAllocToSpvsrGrpUVO2Iterator").getViewObject();
        DCBindingContainer dcBindingContainer1 = this.getBindings1();
                OperationBinding op = (OperationBinding)dcBindingContainer1.getOperationBinding("piUnassign");
                result=(String)op.execute();
                if(result!=null){
                if(result.equalsIgnoreCase("success")){
                    piSupAllocVO.setWhereClause("AssignedTo='"+userName+"' and status='Assigned'");
                    piSupAllocVO.executeQuery();
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "The selected PI/PI's are Unassigned Successfully."));
                AdfFacesContext.getCurrentInstance().addPartialTarget(getPiSupAllocTableBind());    
                }
                else if(result.equalsIgnoreCase("fail")){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  "Sample info message",
                                                                                  "Exception occurred during Un-Assign."));  
                }
                }
        return null;
    }

    public void setPiSupAllocTableBind(RichTable piSupAllocTableBind) {
        this.piSupAllocTableBind = piSupAllocTableBind;
    }

    public RichTable getPiSupAllocTableBind() {
        return piSupAllocTableBind;
    }

    public void supLovVCL(ValueChangeEvent valueChangeEvent) {
        supId=(String)valueChangeEvent.getNewValue();
        ViewObject piSupAllocVO = getBindings1().findIteratorBinding("PIAllocToSpvsrGrpUVO2Iterator").getViewObject();
        piSupAllocVO.setWhereClause("AssignedTo='"+supId+"' and status='Assigned'");
        System.out.println("supLocVCL qry is:::"+piSupAllocVO.getQuery());
        piSupAllocVO.executeQuery();
        int count=piSupAllocVO.getRowCount();
        if(count==0){
            FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      "No PI's exist under the Supervisor:"+supId));
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getPiSupAllocTableBind()); 
    }
}
