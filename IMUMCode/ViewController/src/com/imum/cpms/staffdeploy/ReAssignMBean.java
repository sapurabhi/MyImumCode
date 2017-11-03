package com.imum.cpms.staffdeploy;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

public class ReAssignMBean {
    private RichOutputText pidVal;
    private RichOutputFormatted beatVal;
    private RichOutputFormatted secVal;
    private RichOutputFormatted zoneVal;

    public ReAssignMBean() {
    }

    public String reassign_action() {
        // Add event code here...
        System.out.println("HI ");
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =(DCBindingContainer) lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer) lBindingContainer ;
        OperationBinding op = (OperationBinding)bindingsIte.getOperationBinding("saveReassignDtls");
        op.getParamsMap().put("pidVal", this.getPidVal().getValue().toString());
        op.getParamsMap().put("secVal", this.getSecVal().getValue().toString());
        op.getParamsMap().put("zoneVal", this.getZoneVal().getValue().toString());
        op.getParamsMap().put("beatVal", this.getBeatVal().getValue().toString());
        System.out.println(this.getPidVal().getValue().toString());
        System.out.println("Result :"+op.execute());
        return null;
    }

    public void setPidVal(RichOutputText pidVal) {
        this.pidVal = pidVal;
    }

    public RichOutputText getPidVal() {
        return pidVal;
    }

    public void setBeatVal(RichOutputFormatted beatVal) {
        this.beatVal = beatVal;
    }

    public RichOutputFormatted getBeatVal() {
        return beatVal;
    }

    public void setSecVal(RichOutputFormatted secVal) {
        this.secVal = secVal;
    }

    public RichOutputFormatted getSecVal() {
        return secVal;
    }

    public void setZoneVal(RichOutputFormatted zoneVal) {
        this.zoneVal = zoneVal;
    }

    public RichOutputFormatted getZoneVal() {
        return zoneVal;
    }

    public String cb1_action() {
        // Add event code here...
        System.out.println(
            "ADF");
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =(DCBindingContainer) lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer) lBindingContainer ;
        OperationBinding op = (OperationBinding)bindingsIte.getOperationBinding("saveReassignDtls");
        op.getParamsMap().put("pidVal", this.getPidVal().getValue().toString());
        op.getParamsMap().put("secVal", this.getSecVal().getValue().toString());
        op.getParamsMap().put("zoneVal", this.getZoneVal().getValue().toString());
        op.getParamsMap().put("beatVal", this.getBeatVal().getValue().toString());
        System.out.println(this.getPidVal().getValue().toString());
        System.out.println("Result :"+op.execute());
        return null;
        
    }

    public void reassign(ActionEvent actionEvent) {
        System.out.println("HI ");
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =(DCBindingContainer) lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer) lBindingContainer ;
        OperationBinding op = (OperationBinding)bindingsIte.getOperationBinding("saveReassignDtls");
        System.out.println(this.getPidVal().getValue().toString());
        
        op.getParamsMap().put("pidVal", this.getPidVal().getValue().toString());
        op.getParamsMap().put("secVal", this.getSecVal().getValue().toString());
        op.getParamsMap().put("zoneVal", this.getZoneVal().getValue().toString());
        op.getParamsMap().put("beatVal", this.getBeatVal().getValue().toString());
        System.out.println(this.getPidVal().getValue().toString());
        System.out.println("Result :"+op.execute());
    }
}
