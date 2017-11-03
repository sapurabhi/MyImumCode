package com.imum.cpms.transactions.pilocationmap;

import com.imum.cpms.util.ADFUtils;
import com.imum.cpms.util.MessageUtil;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

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

public class PVTMapMBean {
    
    private RichInputDate assigndateBind;
    private Boolean allShiftsCheckBox=false;
    private RichSelectBooleanCheckbox selectAllShiftsBind;
    MessageUtil genMsg = new MessageUtil();
    private RichSelectOneChoice shiftsBind;
    private String shiftVal;
    private String sectorVal;
    private List<SelectItem> shiftLOV;
    private List<SelectItem> sectorLOV;
    public PVTMapMBean() {
    }
    private DCBindingContainer getBindings1() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    BindingContainer bindings = getBindings();
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public void allShiftsVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance()); 
        Boolean flag=(Boolean)valueChangeEvent.getNewValue();
         if(flag){
            shiftsBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(shiftsBind);
            }
            else {
                shiftsBind.setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(shiftsBind);   
            }
    }

   

    public void setAssigndateBind(RichInputDate assigndateBind) {
        this.assigndateBind = assigndateBind;
    }

    public RichInputDate getAssigndateBind() {
        return assigndateBind;
    }

    public void setSelectAllShiftsBind(RichSelectBooleanCheckbox selectAllShiftsBind) {
        this.selectAllShiftsBind = selectAllShiftsBind;
    }

    public RichSelectBooleanCheckbox getSelectAllShiftsBind() {
        return selectAllShiftsBind;
    }

    public void setAllShiftsCheckBox(Boolean allShiftsCheckBox) {
        this.allShiftsCheckBox = allShiftsCheckBox;
    }

    public Boolean getAllShiftsCheckBox() {
        return allShiftsCheckBox;
    }

   
    public void setGenMsg(MessageUtil genMsg) {
        this.genMsg = genMsg;
    }

    public MessageUtil getGenMsg() {
        return genMsg;
    }

    public String generateReport() {
        Date selectedDate=null;
        Integer hour;
        java.sql.Timestamp startTime=null;
        java.sql.Timestamp endTime=null;
        if(assigndateBind.getValue()!=null){
        selectedDate=(Date)assigndateBind.getValue();
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Please Select Date")); 
            return null;
        }
        /* if(sectorVal.length()==0){
         sectorVal=(String)ADFUtils.evaluateEL("#{bindings.SectorCode.attributeValue}");
        } */
        
        Boolean allshifts=(Boolean)selectAllShiftsBind.getValue();
        if(!allshifts){
        /* if(shiftVal.length()==0){
        Integer shtval=Integer.parseInt(ADFUtils.evaluateEL("#{bindings.pishiftid.attributeValue}").toString());
        shiftVal=Integer.toString(shtval);
        } */
       }
        else{
        shiftVal="0";
         Calendar c = Calendar.getInstance();
            c.setTime(selectedDate); 
            c.add(Calendar.DATE,0);
            c.set(Calendar.HOUR, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            startTime = new java.sql.Timestamp(c.getTime().getTime());
            System.out.println("in all shifts startTime:::"+startTime);
            
         Calendar c1 = Calendar.getInstance();
            c1.setTime(selectedDate); 
            c1.add(Calendar.DATE,0);
            c1.set(Calendar.HOUR,23);
            c1.set(Calendar.MINUTE,59);
            c1.set(Calendar.SECOND, 59);
            endTime = new java.sql.Timestamp(c1.getTime().getTime());
            System.out.println("in all shifts endTime is:::"+endTime);
            
        }
        if(selectedDate!=null &&shiftVal==null ){
                shiftVal="0";
                Calendar c = Calendar.getInstance();
                c.setTime(selectedDate); 
                c.add(Calendar.DATE,0);
                c.set(Calendar.HOUR, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                startTime = new java.sql.Timestamp(c.getTime().getTime());
                System.out.println("in all shifts startTime:::"+startTime);
                
             Calendar c1 = Calendar.getInstance();
                c1.setTime(selectedDate); 
                c1.add(Calendar.DATE,0);
                c1.set(Calendar.HOUR,23);
                c1.set(Calendar.MINUTE,59);
                c1.set(Calendar.SECOND, 59);
                endTime = new java.sql.Timestamp(c1.getTime().getTime());
                System.out.println("in all shifts endTime is:::"+endTime);  
        }
        java.sql.Date startDate= new java.sql.Date( selectedDate.getTime());
        System.out.println("StartDate is:::"+startDate);
        if(shiftVal!=null){
        if(shiftVal!="0"){
        ViewObject shiftVO = getBindings1().findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
        shiftVO.setWhereClause("pi_shift_id='"+shiftVal+"'");
        System.out.println("shift query to get hours is::"+shiftVO.getQuery());
        shiftVO.executeQuery();
        Row row=shiftVO.first();
        hour=Integer.parseInt(row.getAttribute("durationhr").toString());
        java.sql.Time time=(java.sql.Time)row.getAttribute("ShiftFrom");
        int hours=time.getHours();
        int minutes=time.getMinutes();
        Calendar c = Calendar.getInstance();
            c.setTime(selectedDate); 
            c.add(Calendar.DATE,0);
            c.set(Calendar.HOUR, hours);
            c.set(Calendar.MINUTE, minutes);
            c.set(Calendar.SECOND, 0);
            startTime = new java.sql.Timestamp(c.getTime().getTime());
            System.out.println("startTime is:::"+startTime);
            
            int totalHours = time.getHours() + hour;
            int remainingHours = totalHours-24;
            int totalMinutes = time.getMinutes();    
        Calendar c1 = Calendar.getInstance();
                c1.setTime(selectedDate);
             if(totalHours>24){
                c1.add(Calendar.DATE,1);
                c1.set(Calendar.HOUR, remainingHours);
                c1.set(Calendar.MINUTE,totalMinutes);
                c1.set(Calendar.SECOND, 0);
             }
             else{
                c1.add(Calendar.DATE,0);
                c1.set(Calendar.HOUR, totalHours);
                c1.set(Calendar.MINUTE, totalMinutes);
                c1.set(Calendar.SECOND, 0);
             }
            endTime = new java.sql.Timestamp(c1.getTime().getTime());
            System.out.println("endTime is:::"+endTime);
      }
        }
        OperationBinding operationBindings = bindings.getOperationBinding("getallmapcoordinates");
        operationBindings.getParamsMap().put("startTime", startTime);
        operationBindings.getParamsMap().put("endTime", endTime);
        operationBindings.getParamsMap().put("sectorCode", sectorVal);
        operationBindings.execute();
        return null;
    }

    public void shiftVCL(ValueChangeEvent valueChangeEvent) {
        if(valueChangeEvent.getNewValue() != null){
        shiftVal =(valueChangeEvent.getNewValue().toString());
         if(shiftVal!=null){
             System.out.println("shiftval is:::"+shiftVal);
            selectAllShiftsBind.resetValue();
            selectAllShiftsBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllShiftsBind);
            }
        }
    }

    public void setShiftsBind(RichSelectOneChoice shiftsBind) {
        this.shiftsBind = shiftsBind;
    }

    public RichSelectOneChoice getShiftsBind() {
        return shiftsBind;
    }

    public void sectorVCL(ValueChangeEvent valueChangeEvent) {
        if(valueChangeEvent.getNewValue() != null){
        shiftVal =(valueChangeEvent.getNewValue().toString());
        System.out.println("shiftval is:::"+shiftVal);
        }
    }

    public void setShiftLOV(List<SelectItem> shiftLOV) {
        this.shiftLOV = shiftLOV;
    }

    public List<SelectItem> getShiftLOV() {
        if (shiftLOV == null) {
                    shiftLOV =
                            ADFUtils.selectItemsForIterator("GenpiShiftMstVO1Iterator", "pishiftid",
                                                            "pishiftdesc");
                }

        return shiftLOV;
    }

    public void setSectorLOV(List<SelectItem> sectorLOV) {
        this.sectorLOV = sectorLOV;
    }

    public List<SelectItem> getSectorLOV() {
        if (sectorLOV == null) {
                    sectorLOV =
                            ADFUtils.selectItemsForIterator("GenSectorMstMapRVO1Iterator", "SectorCode",
                                                            "SectorName");
                } 
        return sectorLOV;
    }

    public void setShiftVal(String shiftVal) {
        this.shiftVal = shiftVal;
    }

    public String getShiftVal() {
        return shiftVal;
    }

    public void setSectorVal(String sectorVal) {
        this.sectorVal = sectorVal;
    }

    public String getSectorVal() {
        return sectorVal;
    }
}
