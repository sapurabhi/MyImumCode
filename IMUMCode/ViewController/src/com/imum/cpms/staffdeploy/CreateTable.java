package com.imum.cpms.staffdeploy;

import com.imum.cpms.util.ADFUtils;
import com.imum.cpms.util.MessageUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import javax.servlet.http.HttpSession;


import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;



import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;
import oracle.jbo.uicli.binding.JUIteratorBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class CreateTable {
    private RichInputDate montyear;
    private String UserName="";
    private String userLastName="";
    private boolean disabled= false;
    private boolean disabledMonthly= false;
    private RichSelectOneChoice selectedpi;
    private String selected="";
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    String selectpi="";
    private java.util.Date curDate = new java.util.Date();
    private Date currentdate = new Date();
    private java.util.Date toDate1=new java.util.Date();
    private RichInputDate monthlyAssignDate;
    private RichTable dailyDeployTB;
    private RichPanelGroupLayout dailyDeployGridPanel;
    MessageUtil genMsg = new MessageUtil();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
 //   String lgCode = httpSession.getAttribute("language").toString();

  String lgCode="EN";
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichCommandButton submicb4;
    private RichCommandButton cancelcb5;
 //   private UISelectItem shift1ALL;
//    private UISelectItem shift1RESERVED;
//    private UISelectItem shift1OFF;
  //  private UISelectItem shift1Null;
    private UISelectItems shift1Vals;
    private RichSelectOneChoice shift1LOV;
    private RichInputText generateReport;
    private RichInputText reportshift;
    private RichInputDate reportdate;
    private RichSelectOneChoice shiftreport;
    private RichPanelFormLayout panelformlayout;
    private RichInputText userName1;
    private RichInputDate todate1;
    private RichCommandButton searchbtnbind;
    private RichCommandButton dailysubmitBind;
    private RichCommandButton dailyUnassgnBind;
    private RichTable tableBind;


    public CreateTable() {
    }
    private DCBindingContainer getBindings1() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
    }
    BindingContext bctx=BindingContext.getCurrent();
    public DCBindingContainer getBindings(){
        DCBindingContainer bc=(DCBindingContainer)bctx.getCurrentBindingsEntry();
      return bc;  
    }
    public Date getCurrentdate() {
        return currentdate;
    }
   
    public void setMontyear(RichInputDate montyear) {
        this.montyear = montyear;
    }

    public RichInputDate getMontyear() {
        return montyear;
    }

     public void setDisabled(){
        setDisabled(false);
        SimpleDateFormat stf = new SimpleDateFormat("dd-MM-yyyy");
        curDate = new Date();
        try {
            curDate = stf.parse(stf.format(curDate).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(curDate);
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }
    public void createTable(ActionEvent actionEvent) {
            java.util.Date fdate = (Date)this.getMontyear().getValue();
            if(this.getSelectedpi().getValue() == null ||  (fdate==null || fdate.getTime()<0)){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              " Please enter PI Number and Assigned Date."));
                return;
            }
             DCBindingContainer dcBindingContainer1 = this.getBindings1();
             oracle.binding.OperationBinding op2=dcBindingContainer1.getOperationBinding("callRollback");
             op2.execute();
             OperationBinding op1 = (OperationBinding)dcBindingContainer1.getOperationBinding("resetWorkAssignVO");
             op1.execute();
            Date dat = (Date)montyear.getValue();
            String sms=null;
            System.out.println(dat);
            if(fdate!=null){
            JUCtrlListBinding listBinding1 = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PIAssignListVO1");
            selectpi=listBinding1.getCurrentRow().getAttribute("PIid").toString();
            //setSelected(listBinding1.getCurrentRow().getAttribute("PIid").toString());
        
            Calendar cal = Calendar.getInstance();
            cal.setTime(dat);
            System.out.println(cal.getTime());
            System.out.println(cal.MONTH);
            int month = cal.get(Calendar.MONTH);
            month++;
            System.out.println(month);
            int days = cal.getActualMaximum(cal.DAY_OF_MONTH);
            System.out.println(days);
            OperationBinding op =
                (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("createTab1");
            //op.getParamsMap().put("days", days);
            if(this.getSelected()==null||"".equalsIgnoreCase(this.getSelected())){
            op.getParamsMap().put("piselected", selectpi);
            }
            else{
                op.getParamsMap().put("piselected", this.getSelected());     
            }
           //op.getParamsMap().put("piselected",this.getSelected());
            op.getParamsMap().put("currentdate",dat);
            sms=(String)op.execute();
            System.out.println("sms is :"+sms);
    //        }
            if(sms!=null)
            if(sms.equals("success")){
                cb1.setDisabled(false);
                
            }
                 this. getCb1().setDisabled(false);
                 AdfFacesContext.getCurrentInstance().addPartialTarget( getCb1());
             }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
        }

   public void setSelectedpi(RichSelectOneChoice selectedpi) {
        this.selectedpi = selectedpi;
    }

    public RichSelectOneChoice getSelectedpi() {
        return selectedpi;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getSelected() {
        return selected;
    }

    public void createtable_action(ActionEvent actionEvent) {
        MessageUtil mu;
        mu = new MessageUtil();
       
       
      
        ViewObject groupVO = getBindings1().findIteratorBinding("PImonthlyWorkAssignVO1Iterator").getViewObject();
        Row row = groupVO.getCurrentRow();
        if(montyear.getValue()!=null){
        Date dat = (Date)montyear.getValue();
       // Date tdt=(Date)todate1.getValue();
        System.out.println("from date:::"+dat);
       // System.out.println("to date:::"+tdt);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        System.out.println(cal.getTime());
        System.out.println(cal.MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        month++;
            
            //System.out.println(curmonth);
            java.sql.Date sqlstd = new java.sql.Date(dat.getTime());
            int totladays1 = cal.getActualMaximum(cal.DAY_OF_MONTH);
                //String sqlstd=year+"-"+month+"-"+1;
                String sqlend=year+"-"+month+"-"+totladays1;
                
          /*   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
             Date sqlstdate = format.parse(monthstrtdate);
            java.sql.Date sqlstd = new java.sql.Date(sqlstdate.getTime());
            Date sqlenddate = format.parse(monthenddate);
            java.sql.Date sqlend = new java.sql.Date(sqlenddate.getTime());  
         */
        
        
        try{
            ViewObject pileavevo = getBindings1().findIteratorBinding("PILeaveMangementVO2Iterator").getViewObject();
//               int totladays1 = cal.getActualMaximum(cal.DAY_OF_MONTH);
//                String monthstrtdate=year+"-"+month+"-"+1;
//                String monthenddate=year+"-"+month+"-"+totladays1;
//                Calendar cal1 = Calendar.getInstance();
//                cal1.setTime(currentdate);
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////            Date sqlstdate = format.parse(monthstrtdate);
////            java.sql.Date sqlstd = new java.sql.Date(sqlstdate.getTime());
//            
            /* java.sql.Date sqlstd = new java.sql.Date(dat.getTime());
            java.sql.Date sqlenddate= new java.sql.Date(tdt.getTime());
            
//            Date sqlenddate = format.parse(monthenddate);
            java.sql.Date sqlend = new java.sql.Date(sqlenddate.getTime());  */
            pileavevo.setWhereClause(null);
            pileavevo.setWhereClause("PI_id='"+selectpi+"'\n" + 
            "and  (Pi_id ='"+selectpi+"' and From_Date  between '"+sqlstd+"' and '"+sqlend+"') \n" + 
            "or (Pi_id ='"+selectpi+"' and To_Date between '"+sqlstd+"' and '"+sqlend+"') \n" + 
            "or (Pi_id ='"+selectpi+"' and '"+sqlstd+"' between From_Date and To_Date)\n" + 
            "or (Pi_id ='"+selectpi+"' and '"+sqlend+"' between From_Date and To_Date)");
            System.out.println("leave Query is::"+pileavevo.getQuery());
            pileavevo.executeQuery();
            int count=pileavevo.getRowCount();
            if(count>=1){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              " PI is on leave in the following date/dates.So he is not allowed to allocate to a sector."));
            }
            else{
                OperationBinding op =
                (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("insertMonthlyPIAllocation");
                System.out.println(selectpi);
                op.getParamsMap().put("piid", selectpi);
                op.getParamsMap().put("date", dat);
                op.getParamsMap().put("assignmonth", month);
                op.getParamsMap().put("assignyear", year);
                //        op.execute();
                String msg=op.execute().toString();
                System.out.println(msg);
                //        MessageUtil mu;
                //        mu = new MessageUtil();
                if(msg.equals("Success")){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Details Saved Successfully",
                                                                                  mu.getMessage("392",
                                                                                                    lgCode)));
                    cb1.setDisabled(true);
                  
                //            FacesMessage fm = new FacesMessage("Details saved successfully");
                //            FacesContext fctx = FacesContext.getCurrentInstance();
                //            fctx.addMessage(null, fm);
                    
                }else{
                //            FacesMessage fm = new FacesMessage("At least one Day need to be allocated to  save");
                //            FacesContext fctx = FacesContext.getCurrentInstance();
                //            fctx.addMessage(null, fm);
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "At least one Day need to be allocated to  save",
                                                                                  mu.getMessage("506",
                                                                                                    lgCode)));
                }
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
     
        }
        
        else{
//        FacesMessage fm = new FacesMessage("Please Select the AssignDate");
//        FacesContext fctx = FacesContext.getCurrentInstance();
//        fctx.addMessage(null, fm);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select the From Date",
                                                                          mu.getMessage("390",
                                                                                            lgCode)));
        }
        
    }
   

    public void shift1valuechanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject groupVO = getBindings1().findIteratorBinding("TempViewObj1Iterator").getViewObject();
        Row row = groupVO.getCurrentRow();
        
            //Row temprow=groupVO.next();
        String shift1 = valueChangeEvent.getNewValue().toString();
        if(shift1 != null)
            pageflowScope.put("shiftvalue","Selectedvalue");
         
    }
    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public Date getCurDate() {
        return curDate;
    }
    
    // PI MONTHLY DEPLOYMENT -SHINEY


    public void setMonthlyAssignDate(RichInputDate monthlyAssignDate) {
        this.monthlyAssignDate = monthlyAssignDate;
    }

    public RichInputDate getMonthlyAssignDate() {
        return monthlyAssignDate;
    }

    public void getPIDailyDeployementDtls(ActionEvent actionEvent) {
        MessageUtil mu;
        mu = new MessageUtil();
        
        if(monthlyAssignDate.getValue()!=null){
            Date assignDate = (Date)monthlyAssignDate.getValue();
            System.out.println("Assgned date:::"+assignDate);
            DCBindingContainer dcBindingContainer = this.getBindings1();
            OperationBinding op = (OperationBinding)dcBindingContainer.getOperationBinding("piDailyAssign");
            op.getParamsMap().put("dailyAssignDate", assignDate);
            op.execute();
            
            getDailyDeployTB().setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDailyDeployTB());
            dailysubmitBind.setVisible(true);
            dailyUnassgnBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dailysubmitBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dailyUnassgnBind);
            getMonthlyAssignDate().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getMonthlyAssignDate());
        }else{
            
            dailyDeployGridPanel.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dailyDeployGridPanel);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Enter Assignment Date",
                                                                          mu.getMessage("422",
                                                                                            lgCode)));
        }
        
    }
    public void commitMsg() {
        MessageUtil mu;
        mu = new MessageUtil();
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      "Sample info message",
                                                                      mu.getMessage("392",
                                                                                        lgCode)));
    }
    public void getDate(){
        setDisabledMonthly(false);
        SimpleDateFormat stf = new SimpleDateFormat("dd-MM-yyyy");
       curDate = new Date();
       try {
        
           curDate = stf.parse(stf.format(curDate).toString());
       } catch (ParseException e) {
           e.printStackTrace();
       }
       System.out.println(curDate);
    }
    public void setDailyDeployTB(RichTable dailyDeployTB) {
        this.dailyDeployTB = dailyDeployTB;
    }

    public RichTable getDailyDeployTB() {
        return dailyDeployTB;
    }

    public void setDailyDeployGridPanel(RichPanelGroupLayout dailyDeployGridPanel) {
        this.dailyDeployGridPanel = dailyDeployGridPanel;
    }

    public RichPanelGroupLayout getDailyDeployGridPanel() {
        return dailyDeployGridPanel;
    }

    public void setDisabledMonthly(boolean disabledMonthly) {
        this.disabledMonthly = disabledMonthly;
    }

    public boolean isDisabledMonthly() {
        return disabledMonthly;
    }

    public void piunassign(ActionEvent actionEvent) {
        // Add event code here...
        DCBindingContainer dcBindingContainer1 = this.getBindings1();
        OperationBinding op = (OperationBinding)dcBindingContainer1.getOperationBinding("piDailyUnassign");
     //   op.getParamsMap().put("dailyAssignDate", assignDate);
        if((op.execute())=="success"){
//            FacesMessage fm = new FacesMessage("PI unassigned successfully");
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
            MessageUtil mu;
            mu = new MessageUtil();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "PI unassigned successfully",
                                                                          mu.getMessage("507",
                                                                                            lgCode)));
            getDailyDeployTB().setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDailyDeployTB());
            dailysubmitBind.setVisible(false);
            dailyUnassgnBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dailysubmitBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dailyUnassgnBind);
        }
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setSubmicb4(RichCommandButton submicb4) {
        this.submicb4 = submicb4;
    }

    public RichCommandButton getSubmicb4() {
        return submicb4;
    }

    public void setCancelcb5(RichCommandButton cancelcb5) {
        this.cancelcb5 = cancelcb5;
    }

    public RichCommandButton getCancelcb5() {
        return cancelcb5;
    }

    public void testValuieChanged(ValueChangeEvent valueChangeEvent) {
//        System.out.println(shift1Vals.getValue());
//        List vals = (List)shift1Vals.getValue();
//        System.out.println(vals.size());
//        // Add event code here...
//        if(valueChangeEvent.getNewValue()!=null){
//            System.out.println(valueChangeEvent.getNewValue().toString());
//            if(valueChangeEvent.getNewValue().toString().length()==0){
//                shift1RESERVED.setItemValue(vals.size());
//                shift1OFF.setItemValue(vals.size()+1);
//                shift1LOV.setValue(new Integer(vals.size()));
//            }
//        }
    }

//    public void setShift1ALL(UISelectItem shift1ALL) {
//        this.shift1ALL = shift1ALL;
//    }
//
//    public UISelectItem getShift1ALL() {
//        return shift1ALL;
//    }

//    public void setShift1RESERVED(UISelectItem shift1RESERVED) {
//        this.shift1RESERVED = shift1RESERVED;
//    }
//
//    public UISelectItem getShift1RESERVED() {
//        return shift1RESERVED;
//    }
//
//    public void setShift1OFF(UISelectItem shift1OFF) {
//        this.shift1OFF = shift1OFF;
//    }
//
//    public UISelectItem getShift1OFF() {
//        return shift1OFF;
//    }

//    public void setShift1Null(UISelectItem shift1Null) {
//        this.shift1Null = shift1Null;
//    }
//
//    public UISelectItem getShift1Null() {
//        return shift1Null;
//    }

    public void setShift1Vals(UISelectItems shift1Vals) {
        this.shift1Vals = shift1Vals;
    }

    public UISelectItems getShift1Vals() {
        return shift1Vals;
    }

    public void setShift1LOV(RichSelectOneChoice shift1LOV) {
        this.shift1LOV = shift1LOV;
    }

    public RichSelectOneChoice getShift1LOV() {
        return shift1LOV;
    }

    public void doreset(ActionEvent actionEvent) {
        // Add event code here...
      

    }

    public void pWorkVORefresh(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue()!=null){
            DCBindingContainer dcBindingContainer1 = this.getBindings1();
            OperationBinding op = (OperationBinding)dcBindingContainer1.getOperationBinding("resetWorkAssignVO");
            op.execute();
             
            selectpi =valueChangeEvent.getNewValue().toString();
           if(!("".equalsIgnoreCase(selectpi)))
            setSelected(selectpi);
            System.out.println(selectpi);
            DCBindingContainer bindingContainer1 =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            ViewObjectImpl mastVO = (ViewObjectImpl)bindingContainer1.findIteratorBinding("PIUserMstUVO2Iterator1").getViewObject();
           mastVO.setWhereClause("User_Id='"+selectpi+"'");
            mastVO.executeQuery();
          Row rows=mastVO.next();
          
          if(rows.getAttribute("FirstName")!=null && rows.getAttribute("LastName")!=null){
              UserName=rows.getAttribute("FirstName").toString();
              userLastName=rows.getAttribute("LastName").toString();
              String fullname= UserName+ " " +userLastName;
              AdfFacesContext.getCurrentInstance().getPageFlowScope().put("firstNamepiMonthlyAssign", fullname);
              this.getUserName1().setValue(fullname);
          }
           
        }
        
        this. getCb1().setDisabled(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget( getCb1());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getUserName1());
    }

    public void piDailyDeploymentUpdate(ActionEvent actionEvent) {
        MessageUtil mu;
        mu = new MessageUtil();
        Date assignDate =null;
        
//        ViewObject dailyVO = getBindings1().findIteratorBinding("PImonthlyWorkAssignVO1Iterator").getViewObject();
//        RowSetIterator rsit= dailyVO.createRowSetIterator(null);
//        while(rsit.hasNext())
//        Row row = groupVO.getCurrentRow();
        
        
        
        
        
        if(monthlyAssignDate.getValue()!=null){
           assignDate = (Date)monthlyAssignDate.getValue();
           
        DCBindingContainer bc=(DCBindingContainer) getBindings();
        DCIteratorBinding dcItteratorBindings =
            bc.findIteratorBinding("PiDailyWorkAssignVO1Iterator");
        ViewObject pidailyVO = dcItteratorBindings.getViewObject();
        RowSetIterator iterator1 = pidailyVO.createRowSetIterator(null);
        iterator1.reset();
        Calendar c1 = Calendar.getInstance();
        java.sql.Timestamp currdate = new java.sql.Timestamp(c1.getTime().getTime());
        ADFContext adfctx = ADFContext.getCurrent();
        String userName=adfctx.getSessionScope().get("loggedinUserid").toString();
        ArrayList<String> al = new ArrayList<String>();
        Boolean flag=true;
         while (iterator1.hasNext()) {
        Row docRow1= iterator1.next();

        String dbval =(String)docRow1.getAttribute("dbval");
        Integer statusval=docRow1.getAttribute("PiAvailabitystatusID")!=null?(Integer)docRow1.getAttribute("PiAvailabitystatusID"):null;
        Integer dbpasi=docRow1.getAttribute("dbpasi")!=null?(Integer)docRow1.getAttribute("dbpasi"):null;
        Integer piattendance=docRow1.getAttribute("PIAttendancestatusid")!=null?(Integer)docRow1.getAttribute("PIAttendancestatusid"):null;     
        System.out.println("dbpasi val is:::"+dbpasi);
            if(dbval==null &&  statusval!=null){
                    if(statusval.equals(3)){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  "Sample Error message",
                                                                                  " Leave can't be proceed from here. please select other status.")); 
                    flag=false;
                    return;
                    }
                } 
         if (dbval==null) {
  /*       if (statusval == null|| statusval.equals(0)) {
                       pidailyVO.setCurrentRow(docRow1);
                       pidailyVO.removeCurrentRow();
                   } */
             if(statusval!=null){
                if(statusval.equals(1)){
             Integer shiftval=(Integer)docRow1.getAttribute("Shift");
             String sectorname=(String)docRow1.getAttribute("SectorName");
             String zonename=(String)docRow1.getAttribute("ZoneName");
             String sectorzone=sectorname+ "-" +zonename;
             if(sectorname!=null && zonename!=null){
             docRow1.setAttribute("SectorZone", sectorzone);
             }
             if(shiftval==null||sectorname==null||zonename==null)
             {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                               "Sample Error message",
                                                                               " Please Select shift,sector,and Zone Values."));  
                 flag=false;
             return;
             }
         }
             }
         }
         else if(dbval.equalsIgnoreCase("true")){
            if(statusval==null){
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                           "Sample Error message",
                                                                           "please select the Status. Status can't be blank for already deployed records"));  
                 flag=false;
             return;   
             }
             if(statusval!=null && piattendance!=null && dbpasi!=null){
             if(dbpasi.equals(2)&&piattendance.equals(3)&& statusval.equals(1)){
                 docRow1.setAttribute("PIAttendancestatusid", 1);   
             }
             else if(dbpasi.equals(4)&&piattendance.equals(3)&& statusval.equals(1)){
                 docRow1.setAttribute("PIAttendancestatusid", 1); 
             }
             }
              if(statusval!=null){
                 
             if(statusval.equals(1)){
                          Integer shiftval=(Integer)docRow1.getAttribute("Shift");
                          String sectorname=(String)docRow1.getAttribute("SectorName");
                          String zonename=(String)docRow1.getAttribute("ZoneName");
                          String sectorzone=sectorname+ "-" +zonename;
                          if(sectorname!=null && zonename!=null){
                          docRow1.setAttribute("SectorZone", sectorzone);
                          }
                          docRow1.setAttribute("UpdatedBy", userName);
                          docRow1.setAttribute("UpdatedDate", currdate);
                          if(shiftval==null||sectorname==null||zonename==null)
                          {
                              FacesContext.getCurrentInstance().addMessage(null,
                                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                            "Sample Error message",
                                                                                            " Please Select shift,sector,and Zone Values."));  
                              flag=false;
                          return;
                          }
                      }
             else if(statusval.equals(3)&&!(dbpasi.equals(3))){
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                               "Sample Error message",
                                                                               " Leave can't be proceed from here. please select other status.")); 
                 flag=false;
                 return;  
             }
         } 
         }
        } 
         
         if(flag){
             RowSetIterator iterator2 = pidailyVO.createRowSetIterator(null);
             iterator2.reset();
             while (iterator2.hasNext()) {
             Row docRow1= iterator2.next();
             Integer statusval=docRow1.getAttribute("PiAvailabitystatusID")!=null?(Integer)docRow1.getAttribute("PiAvailabitystatusID"):null;    
         if (statusval == null|| statusval.equals(0)) {
                       pidailyVO.setCurrentRow(docRow1);
                       pidailyVO.removeCurrentRow();
                   } 
         }
         }
        iterator1.closeRowSetIterator();
        DCBindingContainer bindingContainer1 =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
         oracle.binding.OperationBinding op=bindingContainer1.getOperationBinding("saveDB");
        String msg=(String) op.execute();
        if(msg.equalsIgnoreCase("success")){
         /*executing emptyrowset */
         oracle.binding.OperationBinding op1=bindingContainer1.getOperationBinding("resetdailyWorkAssignNewVO");
         op1.execute();
         FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      "Sample Info message",
                                                                      " Details Saved Successfully.")); 
             getDailyDeployTB().setVisible(false);
             AdfFacesContext.getCurrentInstance().addPartialTarget(getDailyDeployTB());
             dailysubmitBind.setVisible(false);
             dailyUnassgnBind.setVisible(false);
             AdfFacesContext.getCurrentInstance().addPartialTarget(dailysubmitBind);
             AdfFacesContext.getCurrentInstance().addPartialTarget(dailyUnassgnBind);
//         this.getSubmitBtnBind().setDisabled(true);
//         this.getSearchBtnBind().setDisabled(false);
//         AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchBtnBind());
//         AdfFacesContext.getCurrentInstance().addPartialTarget(getSubmitBtnBind());
         }
        if(msg.equalsIgnoreCase("fail")){
            oracle.binding.OperationBinding op2=bindingContainer1.getOperationBinding("callRollback");
            op2.execute(); 
            FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                         "Sample Info message",
                                                                         " Exception occurred during Save."));  
            getDailyDeployTB().setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDailyDeployTB());
            dailysubmitBind.setVisible(false);
            dailyUnassgnBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dailysubmitBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dailyUnassgnBind);
        }
        if(msg.equalsIgnoreCase("sqlfail")){
            oracle.binding.OperationBinding op2=bindingContainer1.getOperationBinding("callRollback");
            op2.execute(); 
            FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                         "Sample Info message",
                                                                         " Please Select other shifts.The current shift is already allocated."));   
        }
          
       
/* commented by karim 
 * DCBindingContainer dcBindingContainer = this.getBindings1();
            OperationBinding op = (OperationBinding)dcBindingContainer.getOperationBinding("piDailyDeploymentUpdate");
            op.getParamsMap().put("dailyAssignDate", assignDate);
            
            String msg=op.execute().toString();
            if(msg!=null){
             if(msg.equals("Success")){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Details Saved Successfully",
                                                                                  mu.getMessage("392",
                                                                                                  lgCode)));
                    
             }    else if(msg.equals("Failure")){
//                    FacesContext.getCurrentInstance().addMessage(null,
//                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                                  "Error occurred",
//                                                                                  "Error occurred"));
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "System Error occurred",
                                                                               mu.getMessage("508",
                                                                                               lgCode)));
             }
             
        }
             else{
//            FacesMessage fm = new FacesMessage("Please Select the AssignmentDate");
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
//            FacesContext.getCurrentInstance().addMessage(null,
//                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                          "Please Select the AssignmentDate",
//                                                                          "Please Select the AssignmentDate"));
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select the AssignmentDate",
                                                                          mu.getMessage("509",
                                                                                          lgCode)));
        }
        } */
    }
    }
    public void setGenerateReport(RichInputText generateReport) {
        this.generateReport = generateReport;
    }

    public RichInputText getGenerateReport() {
        return generateReport;
    }

    public void setReportshift(RichInputText reportshift) {
        this.reportshift = reportshift;
    }

    public RichInputText getReportshift() {
        return reportshift;
    }

    public void setReportdate(RichInputDate reportdate) {
        this.reportdate = reportdate;
    }

    public RichInputDate getReportdate() {
        return reportdate;
    }

    public void generateReport(ActionEvent actionEvent) {
        MessageUtil mu;
        mu = new MessageUtil();
        getPanelformlayout().setVisible(false);
        if((reportdate.getValue()==null) || (shiftreport.getValue().toString()==null)){
            if((reportdate.getValue()==null)){
            
//                FacesContext.getCurrentInstance().addMessage(null,
//                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                              "Please Select the MonthYear",
//                                                                              "Please Select the MonthYear"));
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Please Select the MonthYear",
                                                                              mu.getMessage("510",
                                                                                              lgCode)));
            }
            if((shiftreport.getValue().toString()==null)){
          
//                FacesContext.getCurrentInstance().addMessage(null,
//                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                              "Please Select the Shift",
//                                                                             "Please Select the Shift"));
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Please Select the Shift",
                                                                              mu.getMessage("511",
                                                                                              lgCode)));
            }
        }
        else{
        System.out.println(shiftreport.getValue().toString());
        System.out.println(reportdate.getValue().toString());
        String monthstrtdate="";
        String monthenddate="";
//        if(reportdate.getValue()!=null){
//        Date dat = (Date)reportdate.getValue();
//           Calendar cal1 = Calendar.getInstance();
//            cal1.setTime(dat);
//            int curyear=cal1.get(Calendar.YEAR);
//            int curmonth = cal1.get(Calendar.MONTH);
//            curmonth=curmonth+1;
//            String curmonth1="";
//            int totladays1 = cal1.getActualMaximum(cal1.DAY_OF_MONTH);
//            if(curmonth<=9){
//               curmonth1="0"+curmonth;
//                monthstrtdate=curyear+"-"+curmonth1+"-"+"01";
//                monthenddate=curyear+"-"+curmonth1+"-"+totladays1;
//            }else
//            {
//                monthstrtdate=curyear+"-"+curmonth+"-"+"01";
//               monthenddate=curyear+"-"+curmonth+"-"+totladays1;
//            }            
//           
////                monthstrtdate=curyear+"-"+curmonth1+"-"+"01";
////                monthenddate=curyear+"-"+curmonth1+"-"+totladays1;
//                int shift=Integer.parseInt(shiftreport.getValue().toString());
//            System.out.println(monthstrtdate);
//            System.out.println(monthenddate);
//            GenerateMonthlyReport gmr=new GenerateMonthlyReport();
//            gmr.callReport(monthstrtdate, monthenddate, shift);
//            
//        }
            DCBindingContainer dcBindingContainer1 = this.getBindings1();
            OperationBinding op = (OperationBinding)dcBindingContainer1.getOperationBinding("createDynamicVOReport");
        op.execute();
        getPanelformlayout().setVisible(true);    
        
        }
        
        
    }

    public void setShiftreport(RichSelectOneChoice shiftreport) {
        this.shiftreport = shiftreport;
    }

    public RichSelectOneChoice getShiftreport() {
        return shiftreport;
    }

    public void setPanelformlayout(RichPanelFormLayout panelformlayout) {
        this.panelformlayout = panelformlayout;
    }

    public RichPanelFormLayout getPanelformlayout() {
        return panelformlayout;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName1(RichInputText userName1) {
        this.userName1 = userName1;
    }

    public RichInputText getUserName1() {
        return userName1;
    }

    public String generateReport() {
        FacesContext fctx = FacesContext.getCurrentInstance();
               ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);      
               // Invoke a java script method name called showConfPopup()' with two parameters, You can pass any value 
               erks.addScript(fctx, "loadMap('"+"24.512689"+"','"+"54.37425"+ "')");  

        return null;
    }

 
   


    public void setToDate1(Date toDate1) {
        this.toDate1 = toDate1;
    }

    public Date getToDate1() {
        return toDate1;
    }

    public void setTodate1(RichInputDate todate1) {
        this.todate1 = todate1;
    }

    public RichInputDate getTodate1() {
        return todate1;
    }

    /* public void toDateValChange(ValueChangeEvent valueChangeEvent) {
        java.util.Date todate =(java.util.Date) valueChangeEvent.getNewValue();
        java.util.Date fromdate=(java.util.Date)this.getCurrentdate();
        java.sql.Date sqlstd = new java.sql.Date(fromdate.getTime());
        java.sql.Date sqlend = new java.sql.Date(todate.getTime());
        try{
                   SimpleDateFormat stf32 = new SimpleDateFormat("MM");
                   int month12 = Integer.parseInt(stf32.format(sqlstd));
                   int month22 = Integer.parseInt(stf32.format(sqlend));
            if(month12==month22){
                   searchbtnbind.setDisabled(false);
                   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                   String frmdate = sdf.format(fromdate);
                   String tdate = sdf.format(todate);
                   Date date1 = sdf.parse(frmdate);
                   Date date2 = sdf.parse(tdate);

                   System.out.println(sdf.format(date1));
                   System.out.println(sdf.format(date2));

                   if(date1.compareTo(date2)>0){
                       System.out.println("fromdate is after todate");
                       FacesContext.getCurrentInstance().addMessage(null,
                                                                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                     "Sample info message",
                                                                                     " To date should be after From Date ."));
                       searchbtnbind.setDisabled(true);
                   }else if(date1.compareTo(date2)<0){
                       System.out.println("fromdate is before todate");
                       searchbtnbind.setDisabled(false);
                   }else if(date1.compareTo(date2)==0){
                       System.out.println("fromdate is equal to todate");
                       searchbtnbind.setDisabled(false);
                   }
                   else{
                     System.out.println("");
                   }

               }
            else{
                System.out.println("From to dates should me in similar month.please selecte the dates again.");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              " From and To Dates should be in similar months.please select the dates in similar months."));
                searchbtnbind.setDisabled(true);
            }
        }
        
        catch(ParseException ex){
                   ex.printStackTrace();
               }
        
    } */

    public void setSearchbtnbind(RichCommandButton searchbtnbind) {
        this.searchbtnbind = searchbtnbind;
    }

    public RichCommandButton getSearchbtnbind() {
        return searchbtnbind;
    }

   /*  public void fromDateValChange(ValueChangeEvent valueChangeEvent) {
        java.util.Date fromdate =(java.util.Date) valueChangeEvent.getNewValue();
        java.util.Date todate=(java.util.Date)this.getToDate1();
        java.sql.Date sqlstd = new java.sql.Date(fromdate.getTime());
        java.sql.Date sqlend = new java.sql.Date(todate.getTime());
        try{
                   SimpleDateFormat stf32 = new SimpleDateFormat("MM");
                   int month12 = Integer.parseInt(stf32.format(sqlstd));
                   int month22 = Integer.parseInt(stf32.format(sqlend));
            if(month12==month22){
                   searchbtnbind.setDisabled(false);
                   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                   String frmdate = sdf.format(fromdate);
                   String tdate = sdf.format(todate);
                   Date date1 = sdf.parse(frmdate);
                   Date date2 = sdf.parse(tdate);

                   System.out.println(sdf.format(date1));
                   System.out.println(sdf.format(date2));

                   if(date1.compareTo(date2)>0){
                       System.out.println("fromdate is after todate");
                       FacesContext.getCurrentInstance().addMessage(null,
                                                                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                     "Sample info message",
                                                                                     "From Date should be before To date."));
                       searchbtnbind.setDisabled(true);
                   }else if(date1.compareTo(date2)<0){
                       System.out.println("fromdate is before todate");
                       searchbtnbind.setDisabled(false);
                   }else if(date1.compareTo(date2)==0){
                       System.out.println("fromdate is equal to todate");
                       searchbtnbind.setDisabled(false);
                   }
                   else{
                     System.out.println("");
                   }

               }
            else{
                System.out.println("From to dates should me in similar month.please selecte the dates again.");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              " From and To Dates should be in similar months.please select the dates in similar months.."));
                searchbtnbind.setDisabled(true);
            }
        }

        catch(ParseException ex){
                   ex.printStackTrace();
               }

    } */

    public void submitAction(ActionEvent actionEvent) {
        DCBindingContainer bc=(DCBindingContainer) getBindings();
        DCIteratorBinding dcItteratorBindings =
            bc.findIteratorBinding("PImonthlyWorkAssignVO1Iterator2");
        ViewObject pimonthlyVO = dcItteratorBindings.getViewObject();
        RowSetIterator iterator1 = pimonthlyVO.createRowSetIterator(null);
        iterator1.reset();
        ArrayList<Integer> al = new ArrayList<Integer>();
         while (iterator1.hasNext()) {
        Row docRow1= iterator1.next();
        String dbval =(String)docRow1.getAttribute("dbval");
        Integer statusval=docRow1.getAttribute("PiAvailabitystatusID")!=null?(Integer)docRow1.getAttribute("PiAvailabitystatusID"):null;
        Integer shtval=(Integer)docRow1.getAttribute("Shift"); 
             if(dbval!=null){
             if(dbval.equalsIgnoreCase("true"))
              al.add(shtval);
             }
         if (dbval==null && statusval!=null ) {
             if(statusval.equals(1)){
             Integer shiftval=(Integer)docRow1.getAttribute("Shift");
             String sectorname=(String)docRow1.getAttribute("SectorName");
             String zonename=(String)docRow1.getAttribute("ZoneName");
             String sectorzone=sectorname+ "-" +zonename;
             if(sectorname!=null && zonename!=null)
             docRow1.setAttribute("SectorZone", sectorzone);
            // al.add(shiftval);
             if(shiftval==null||sectorname==null||zonename==null)
             {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                               "Sample Error message",
                                                                               " Please Select shift,sector,and Zone Values."));  
             return;
             }
             if(al.size()>0 && al.contains(shiftval)){
                FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                               "Sample Error message",
                                                                               " Please Select other shifts.The current shift is already allocated."));  
                 return;     
             }
             
         }
         }
         if(statusval!=null){
         if(dbval==null && !(statusval.equals(1))){
             FacesContext.getCurrentInstance().addMessage(null,
                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                            "Sample Error message",
                                                                            " Please select status as WORKING."));  
              return;
         }
             }
            /*  if(dbval!=null && dbval.equalsIgnoreCase("true")){
                 Integer shiftval=(Integer)docRow1.getAttribute("Shift");
                 Boolean flag=al.contains(shiftval);
                 if(flag){
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                   "Sample Error message",
                                                                                   " Please Select other shifts."));  
                     return;     
                 }
             } */
 /*          if(dbval.equalsIgnoreCase("true")){
             if(statusval.equals(1)){
                          Integer shiftval=(Integer)docRow1.getAttribute("Shift");
                          String sectorname=(String)docRow1.getAttribute("SectorName");
                          String zonename=(String)docRow1.getAttribute("ZoneName");
                          if(shiftval==null||sectorname==null||zonename==null)
                          {
                              FacesContext.getCurrentInstance().addMessage(null,
                                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                            "Sample Error message",
                                                                                            " Please Select shift,sector,and Zone Values."));  
                          return;
                          }
                      }
             
         } */
        } 
         
        iterator1.closeRowSetIterator();
        DCBindingContainer bindingContainer1 =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();;
         oracle.binding.OperationBinding op=bindingContainer1.getOperationBinding("saveDB");
         op.execute();
         /*executing emptyrowset */
         oracle.binding.OperationBinding op1=bindingContainer1.getOperationBinding("resetWorkAssignVO");
         op1.execute();
         FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      "Sample Info message",
                                                                      " Details Saved Successfully.")); 
        this. getCb1().setDisabled(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget( getCb1());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
//         this.getSubmitBtnBind().setDisabled(true);
//         this.getSearchBtnBind().setDisabled(false);
//         AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchBtnBind());
//         AdfFacesContext.getCurrentInstance().addPartialTarget(getSubmitBtnBind());  
    }

    public void statusVCL(ValueChangeEvent valueChangeEvent) {
        DCBindingContainer bc=(DCBindingContainer) getBindings();
        DCIteratorBinding dcItteratorBindings =
            bc.findIteratorBinding("PImonthlyWorkAssignVO1Iterator2");
        ViewObject pimonthlyVO = dcItteratorBindings.getViewObject();
        Row row=pimonthlyVO.getCurrentRow();
        System.out.println(row.getAttribute("SectorName"));
        row.setAttribute("SectorName", null);
        row.setAttribute("Shift", null);
        row.setAttribute("ZoneName", null);
    }

    public void statusValueChange(ValueChangeEvent valueChangeEvent) {
        DCBindingContainer bc=(DCBindingContainer) getBindings();
        DCIteratorBinding dcItteratorBindings =
            bc.findIteratorBinding("PiDailyWorkAssignVO1Iterator");
        ViewObject pimonthlyVO = dcItteratorBindings.getViewObject();
        Row row=pimonthlyVO.getCurrentRow();
        System.out.println(row.getAttribute("SectorName"));
        row.setAttribute("SectorName", null);
        row.setAttribute("Shift", null);
        row.setAttribute("ZoneName", null);
    }

    public void setDailysubmitBind(RichCommandButton dailysubmitBind) {
        this.dailysubmitBind = dailysubmitBind;
    }

    public RichCommandButton getDailysubmitBind() {
        return dailysubmitBind;
    }

    public void setDailyUnassgnBind(RichCommandButton dailyUnassgnBind) {
        this.dailyUnassgnBind = dailyUnassgnBind;
    }

    public RichCommandButton getDailyUnassgnBind() {
        return dailyUnassgnBind;
    }

    public void sectorVCL(ValueChangeEvent valueChangeEvent) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
    }

    public void setTableBind(RichTable tableBind) {
        this.tableBind = tableBind;
    }

    public RichTable getTableBind() {
        return tableBind;
    }
}
