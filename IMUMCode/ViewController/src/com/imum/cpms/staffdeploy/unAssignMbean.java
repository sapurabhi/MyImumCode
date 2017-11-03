package com.imum.cpms.staffdeploy;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.context.AdfFacesContext;

public class unAssignMbean {
    public String time =null;
    public unAssignMbean() {
    }

    public void getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        String timeStamp = dateFormat.format(cal.getTime());
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.getPageFlowScope().put("timeStamp", timeStamp);
        time = timeStamp;
    }
    public void saveDtls(){
        BindingContext lBindingContext = BindingContext.getCurrent();
        DCBindingContainer lBindingContainer =(DCBindingContainer) lBindingContext.getCurrentBindingsEntry();
        DCBindingContainer bindingsIte = (DCBindingContainer) lBindingContainer ;
        OperationBinding op = (OperationBinding)bindingsIte.getOperationBinding("saveUnassignDtls");
        op.getParamsMap().put("time", time);
        System.out.println("Result :"+op.execute());
        if(op!=null){
            String result =(String)op.execute();
            if(result=="success"){
                FacesMessage fm = new FacesMessage("Details saved successfully");
                FacesContext fctx = FacesContext.getCurrentInstance();
                fctx.addMessage(null, fm);
            }
        }
    }


    public void setTime(String time) {
        this.time = time;
    }

    public String getTime1() {
        return time;
    }
}
