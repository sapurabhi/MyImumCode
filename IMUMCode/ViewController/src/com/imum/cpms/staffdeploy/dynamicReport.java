package com.imum.cpms.staffdeploy;

import com.imum.cpms.util.MessageUtil;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichActiveOutputText;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

public class dynamicReport {
    private RichCommandButton cb1;
    private RichSpacer s1;
    private RichPanelGroupLayout pgl1;
    private RichSelectItem si2;
    private RichSelectItem si1;
    private RichSelectItem si3;
    private RichSelectOneChoice shift;
    private RichInputDate monthYear;
    private RichPanelFormLayout pfl2;
    private RichMessages m1;
    private RichSpacer s2;
    private RichActiveOutputText aot1;
    private RichPanelHeader ph1;

    public dynamicReport() {
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setSi2(RichSelectItem si2) {
        this.si2 = si2;
    }

    public RichSelectItem getSi2() {
        return si2;
    }

    public void setSi1(RichSelectItem si1) {
        this.si1 = si1;
    }

    public RichSelectItem getSi1() {
        return si1;
    }

    public void setSi3(RichSelectItem si3) {
        this.si3 = si3;
    }

    public RichSelectItem getSi3() {
        return si3;
    }

    public void setShift(RichSelectOneChoice soc1) {
        this.shift = soc1;
    }

    public RichSelectOneChoice getShift() {
        return shift;
    }

    public void setMonthYear(RichInputDate id1) {
        this.monthYear = id1;
    }

    public RichInputDate getMonthYear() {
        return monthYear;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setAot1(RichActiveOutputText aot1) {
        this.aot1 = aot1;
    }

    public RichActiveOutputText getAot1() {
        return aot1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public String genarateReportActionLiserer() {
        MessageUtil mu;
        mu = new MessageUtil();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession httpSession = (HttpSession) externalContext.getSession(false);
        String lgCode = httpSession.getAttribute("language").toString();
        if(monthYear.getValue() == null){
//            FacesContext.getCurrentInstance().addMessage(null,
//                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                          "Please Select Month Year",
//                                                                          " Please Select Month Year"));
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select Month Year",
                                                                          mu.getMessage("000",
                                                                                          lgCode)));
            return null;
        }else if(shift.getValue() == null ){
//            FacesContext.getCurrentInstance().addMessage(null,
//                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                          "Please Select Shift",
//                                                                          "Please Select Shift"));
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select Shift",
                                                                          mu.getMessage("000",
                                                                                          lgCode)));
            return null;
        }
        // Add event code here...
        OperationBinding op2 = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("createDynamicVOReport");
        op2.getParamsMap().put("dynamicReportMonthYear", (Date)monthYear.getValue());
        op2.getParamsMap().put("dynamicReportShift", shift.getValue().toString());
        op2.execute();
        
        return "dynamicVO";
    }

    
}
