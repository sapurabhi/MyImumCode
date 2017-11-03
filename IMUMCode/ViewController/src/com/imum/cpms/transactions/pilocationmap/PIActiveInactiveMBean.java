package com.imum.cpms.transactions.pilocationmap;

import com.imum.cpms.util.ADFUtils;

import com.imum.cpms.util.MessageUtil;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class PIActiveInactiveMBean {
    private RichInputDate assigndateBind;
    private String shiftVal="";
    private RichSelectBooleanCheckbox selectAllShiftsBind;
    private RichSelectOneChoice shiftsBind;
    private Boolean allShiftsCheckBox=false;
    MessageUtil genMsg = new MessageUtil();

    public PIActiveInactiveMBean() {
    }
    BindingContainer bindings = getBindings();
    DCBindingContainer bindingContainer1 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public void setAssigndateBind(RichInputDate assigndateBind) {
        this.assigndateBind = assigndateBind;
    }

    public RichInputDate getAssigndateBind() {
        return assigndateBind;
    }

     public void allShiftsVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance()); 
        Boolean flag=(Boolean)valueChangeEvent.getNewValue();
        //Boolean allShiftsVal = (Boolean)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("allShiftsCheckedUnchecked");
        //if(Boolean.TRUE.equals(allShiftsVal)){
            if(flag){
            shiftsBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(shiftsBind);
            }
            else {
                shiftsBind.setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(shiftsBind);   
            }
        //}
    } 

    public void shiftVCL(ValueChangeEvent valueChangeEvent) {
       // valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        System.out.println(valueChangeEvent.getNewValue());
        int val = 0;
        if(valueChangeEvent.getNewValue() != null){
        shiftVal =(valueChangeEvent.getNewValue().toString());
            DCBindingContainer bindingContainer1 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            ViewObject shiftVO = (ViewObject)bindingContainer1.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
            shiftVO.setWhereClause("pi_shift_desc='"+shiftVal+"'");
            System.out.println("shift query is:::"+shiftVO.getQuery());
            shiftVO.executeQuery();
            Row row=shiftVO.first();
            Integer shtval=Integer.parseInt(row.getAttribute("pishiftid").toString());
            shiftVal=Integer.toString(shtval);
            if(shiftVal!=null){
            selectAllShiftsBind.resetValue();
            selectAllShiftsBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllShiftsBind);
            }
        }
        }

    public void setSelectAllShiftsBind(RichSelectBooleanCheckbox selectAllShiftsBind) {
        this.selectAllShiftsBind = selectAllShiftsBind;
    }

    public RichSelectBooleanCheckbox getSelectAllShiftsBind() {
        return selectAllShiftsBind;
    }

    public void setShiftsBind(RichSelectOneChoice shiftsBind) {
        this.shiftsBind = shiftsBind;
    }

    public RichSelectOneChoice getShiftsBind() {
        return shiftsBind;
    }

    public String generateReport() {
        Date piDate=null;
        String shift=null;
        Integer shift1=null;
        Boolean allshifts=(Boolean)selectAllShiftsBind.getValue();
        if(!allshifts){
        if(shiftVal.length()==0){
         shift=(String)ADFUtils.evaluateEL("#{bindings.GenpiShiftMstVO1.attributeValue}");
         System.out.println("Shiftname is:::"+shift);
        if(shift!=null){
           
            ViewObject shiftVO = (ViewObject)bindingContainer1.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
            shiftVO.setWhereClause("pi_shift_desc='"+shift+"'");
            System.out.println("shift query is:::"+shiftVO.getQuery());
            shiftVO.executeQuery();
            Row row=shiftVO.first();
            Integer shtval=Integer.parseInt(row.getAttribute("pishiftid").toString());
            //shiftVal=Integer.toString(shtval);
            shift1=shtval;
        }
        }
        else{
           shift1=Integer.parseInt(shiftVal);
        }
       }
       else{
           shift1=0;
       }
      
       
        if(shift1==null ){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please Select Shift")); 
            return null;   
        }
        if(assigndateBind.getValue()!=null){
        piDate=(Date)assigndateBind.getValue();
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please Select Date")); 
            return null;
        }
        java.sql.Date sqldate= new java.sql.Date( piDate.getTime());
       System.out.println("selected date is:::"+sqldate);
          OperationBinding operationBindings =bindings.getOperationBinding("callGenPiGpsDataMapProc");
        operationBindings.getParamsMap().put("date", sqldate);
        operationBindings.getParamsMap().put("shift", shift1);
        Integer runseqno=(Integer)operationBindings.execute();  
       //Integer runseqno=1;
        if(runseqno!=null){
        OperationBinding operationBindings1 = bindings.getOperationBinding("getallpicoordinates");
        operationBindings1.getParamsMap().put("runseqno", runseqno);
        operationBindings1.execute();
        }
        
        ViewObject shiftVO1 = (ViewObject)bindingContainer1.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
        shiftVO1.setWhereClause(null);
        shiftVO1.executeQuery();
        return null;
    }

    public void setAllShiftsCheckBox(Boolean allShiftsCheckBox) {
        this.allShiftsCheckBox = allShiftsCheckBox;
    }

    public Boolean getAllShiftsCheckBox() {
        return allShiftsCheckBox;
    }
}
