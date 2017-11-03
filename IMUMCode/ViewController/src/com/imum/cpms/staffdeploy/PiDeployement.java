package com.imum.cpms.staffdeploy;


import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import javax.swing.JList;

import oracle.adf.model.BindingContext;
import oracle.adf.model.ControlBinding;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;

public class PiDeployement {
    private RichInputText piid;
    private RichSelectOneChoice sector;
    private RichSelectOneChoice zone;
    private RichSelectOneChoice beat;

    public PiDeployement() {
    }
    public DCBindingContainer getBindings(){
        DCBindingContainer bindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        return bindingContainer;
    }
    public String editsavecb1_action() {
        //get values :
        String pidVal = null;
        String secVal = null;
        String zoneVal = null;
        String beatVal = null;
        
        DCBindingContainer bindingContainer = this.getBindings();
        if(getPiid().getValue()!=null){
          pidVal = getPiid().getValue().toString();
        }
        JUCtrlListBinding JList1 = (JUCtrlListBinding)bindingContainer.getControlBinding("Zone");
        Row row1 = JList1.getCurrentRow();
        if(row1.getAttribute("Zone")!=null){
            zoneVal = row1.getAttribute("Zone").toString();
        }
        JUCtrlListBinding JList2 = (JUCtrlListBinding)bindingContainer.getControlBinding("Sector");
        Row row2 = JList2.getCurrentRow();
        if(row2.getAttribute("Sector")!=null){
            secVal = row2.getAttribute("Sector").toString();
        }
        JUCtrlListBinding JList3 = (JUCtrlListBinding)bindingContainer.getControlBinding("Beat");
        Row row3 = JList3.getCurrentRow();
        if(row3.getAttribute("Beat")!=null){
            beatVal = row3.getAttribute("Beat").toString();
        }
        
//        if(getSector().getValue()!=null){
//            secVal = getSector().getValue().toString();  
//            OperationBinding op = (OperationBinding)bindingsIte.getOperationBinding("getLovVal");
//            op.getParamsMap().put("Val", secVal);
//            op.getParamsMap().put("flag", "sector");
//            if(op!=null){
//                secVal = op.execute().toString();
//            }
//            else{
//                System.out.println("Failure");
//            }
//        }
//        if(getZone().getValue()!=null){
//            zoneVal = getZone().getValue().toString();  
//            System.out.println(zoneVal);
//            OperationBinding op = (OperationBinding)bindingsIte.getOperationBinding("getLovVal");
//            op.getParamsMap().put("Val", zoneVal);
//            op.getParamsMap().put("flag", "zone");
//            if(op!=null){
//                zoneVal = op.execute().toString();
//            }
//            else{
//                System.out.println("Failure");
//            }
//            
//        }
//        if(getBeat().getValue()!=null){
//            beatVal = getBeat().getValue().toString();  
//            OperationBinding op = (OperationBinding)bindingsIte.getOperationBinding("getLovVal");
//            op.getParamsMap().put("Val", beatVal);
//            op.getParamsMap().put("flag", "beat");
//            if(op!=null){
//                beatVal = op.execute().toString();
//            }
//            else{
//                System.out.println("Failure");
//            }
//        }
       
        OperationBinding op = (OperationBinding)bindingContainer.getOperationBinding("editSaveDtls");
        op.getParamsMap().put("pidVal", pidVal);
        op.getParamsMap().put("secVal", secVal);
        op.getParamsMap().put("zoneVal", zoneVal);
        op.getParamsMap().put("beatVal", beatVal);
        if(op!=null){
            String result =(String)op.execute();
            if(result=="success"){
                FacesMessage fm = new FacesMessage("Details saved successfully");
                FacesContext fctx = FacesContext.getCurrentInstance();
                fctx.addMessage(null, fm);
            }
        }
        
          
       

        return null;
    }

    public void setPiid(RichInputText piid) {
        this.piid = piid;
    }

    public RichInputText getPiid() {
        return piid;
    }

    public void setSector(RichSelectOneChoice sector) {
        this.sector = sector;
    }

    public RichSelectOneChoice getSector() {
        return sector;
    }

    public void setZone(RichSelectOneChoice zone) {
        this.zone = zone;
    }

    public RichSelectOneChoice getZone() {
        return zone;
    }

    public void setBeat(RichSelectOneChoice beat) {
        this.beat = beat;
    }

    public RichSelectOneChoice getBeat() {
        return beat;
    }
}
