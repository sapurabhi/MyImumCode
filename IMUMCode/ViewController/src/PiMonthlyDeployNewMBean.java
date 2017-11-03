import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class PiMonthlyDeployNewMBean {
    private RichInputDate fromDateBind;
    //private Date fromdate;
    //private Date todate;
    private java.util.Date curDate = new java.util.Date();
    private boolean disabledMonthly= false;
    private boolean disabled= false;
    private RichInputDate toDateBind;
    private RichCommandButton searchBtnBind;
    private RichSelectOneChoice selectedpi;
    String selectpi="";
    private String UserName="";
    private String userLastName="";
    private RichSelectOneChoice shiftBind;
    private RichTable tableBind;
    private RichCommandButton submitBtnBind;
    private String selected="";
    private RichInputText fullName;
    private RichSelectOneChoice shitBind;
    private RichSelectOneChoice sectorBind;
    private RichSelectOneChoice zoneBind;

    public PiMonthlyDeployNewMBean() {
    }
   BindingContext bctx=BindingContext.getCurrent();
   public DCBindingContainer getBindings(){
       DCBindingContainer bc=(DCBindingContainer)bctx.getCurrentBindingsEntry();
     return bc;  
   }
    public void setFromDateBind(RichInputDate fromDateBind) {
        this.fromDateBind = fromDateBind;
    }

    public RichInputDate getFromDateBind() {
        return fromDateBind;
    }

//    public void setFromdate(Date fromdate) {
//        this.fromdate = fromdate;
//    }
//
//    public Date getFromdate() {
//        return fromdate;
//    }
//
//    public void setTodate(Date todate) {
//        this.todate = todate;
//    }
//
//    public Date getTodate() {
//        return todate;
//    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public Date getCurDate() {
        try {
        Calendar now = Calendar.getInstance();
        java.util.Date date = now.getTime();
        now.add(Calendar.DAY_OF_MONTH, -60);
        Date today60 = now.getTime();
        System.out.println("Date="+now.getTime());
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(today60);
        return formatter.parse(currentDate);
        } catch (Exception e) {
        return null;
        }
        //return curDate;
    }

    public void setDisabledMonthly(boolean disabledMonthly) {
        this.disabledMonthly = disabledMonthly;
    }

    public boolean isDisabledMonthly() {
        return disabledMonthly;
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

    public void setToDateBind(RichInputDate toDateBind) {
        this.toDateBind = toDateBind;
    }

    public RichInputDate getToDateBind() {
        return toDateBind;
    }

    public void setSearchBtnBind(RichCommandButton searchBtnBind) {
        this.searchBtnBind = searchBtnBind;
    }

    public RichCommandButton getSearchBtnBind() {
        return searchBtnBind;
    }

    public void SearchAction(ActionEvent actionEvent) {
        System.out.println(this.getSelectedpi());
        java.util.Date fdate = (Date)this.getFromDateBind().getValue();
       java.util.Date tdate = (Date)this.getToDateBind().getValue();
        if(this.getSelectedpi().getValue() == null ||  (fdate==null || fdate.getTime()<0)|| (tdate ==null || tdate.getTime() <0)){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          " Please enter PI Number,FromDate and ToDate."));
            return;
        }
        DCBindingContainer bindingContainer1 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding op2=bindingContainer1.getOperationBinding("callRollback");
        op2.execute();
        /*executing emptyrowset */
         OperationBinding op1=bindingContainer1.getOperationBinding("resetWorkAssignNewVO");
         op1.execute();
        java.util.Date fromDate = (Date)this.getFromDateBind().getValue();
        java.util.Date toDate = (Date)this.getToDateBind().getValue();
        if(fromDate.compareTo(toDate)>0){
            System.out.println("fromdate is after todate");
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          " To date should be after From Date ."));
            this.getSubmitBtnBind().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSubmitBtnBind());
        }
        else{
        DCBindingContainer bc=(DCBindingContainer) getBindings();
        DCIteratorBinding dcItteratorBindings =
            bc.findIteratorBinding("PIMonthlyAssignNewVO1Iterator");
        ViewObject pimonthlyVO = dcItteratorBindings.getViewObject();
     JUCtrlListBinding listBinding1 = (JUCtrlListBinding)bc.get("PIAssignListVO1");
     selectpi=listBinding1.getCurrentRow().getAttribute("PIid").toString();
//       setSelected(listBinding1.getCurrentRow().getAttribute("PIid").toString());
        
        OperationBinding op=bc.getOperationBinding("getMonthlDates");
            if(this.getSelected()==null||"".equalsIgnoreCase(this.getSelected())){
        op.getParamsMap().put("piid", selectpi);
            }
            else{
                op.getParamsMap().put("piid", this.getSelected());     
            }
        op.getParamsMap().put("fromdate", fromDate);
        op.getParamsMap().put("todate", toDate);
        op.execute();
       
        this.getSubmitBtnBind().setDisabled(false);
        //this.getSearchBtnBind().setDisabled(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSubmitBtnBind());
       // AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchBtnBind());
            
        }
       AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
    }

    public void setSelectedpi(RichSelectOneChoice selectedpi) {
        this.selectedpi = selectedpi;
    }

    public RichSelectOneChoice getSelectedpi() {
        return selectedpi;
    }

    public void pWorkVORefresh(ValueChangeEvent valueChangeEvent) {
       // valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if(valueChangeEvent.getNewValue()!=null){
            DCBindingContainer bindingContainer1 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();;
             OperationBinding op=bindingContainer1.getOperationBinding("resetWorkAssignNewVO");
             op.execute();
            
            selectpi = valueChangeEvent.getNewValue().toString();//valueChangeEvent.getNewValue().toString();
            if(!("".equalsIgnoreCase(selectpi)))
            setSelected(selectpi);
            System.out.println(selectpi);
            ViewObjectImpl mastVO = (ViewObjectImpl)bindingContainer1.findIteratorBinding("PIUserMstUVO2Iterator").getViewObject();
           mastVO.setWhereClause("User_Id='"+selectpi+"'");
            mastVO.executeQuery();
          Row rows=mastVO.next();
          
          if(rows.getAttribute("FirstName")!=null && rows.getAttribute("LastName")!=null){
              UserName=rows.getAttribute("FirstName").toString();
              userLastName=rows.getAttribute("LastName").toString();
              String fullname= UserName+ " " +userLastName;
              AdfFacesContext.getCurrentInstance().getPageFlowScope().put("firstNamepiMonthlyAssign", fullname);
              //this.setUserName(UserName);
              this.getFullName().setValue(fullname);
              
              
          }
           
        }
       
        this.getSubmitBtnBind().setDisabled(true);
//        this.getSearchBtnBind().setDisabled(false);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchBtnBind());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSubmitBtnBind());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getFullName());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void createtableAction(ActionEvent actionEvent) {
           
            DCBindingContainer bc=(DCBindingContainer) getBindings();
            DCIteratorBinding dcItteratorBindings =bc.findIteratorBinding("PIMonthlyAssignNewVO1Iterator");
            ViewObject pimonthlyVO = dcItteratorBindings.getViewObject();
            RowSetIterator iterator1 = pimonthlyVO.createRowSetIterator(null);
            Calendar c1 = Calendar.getInstance();
            java.sql.Timestamp currdate = new java.sql.Timestamp(c1.getTime().getTime());
            ADFContext adfctx = ADFContext.getCurrent();
            String userName=adfctx.getSessionScope().get("loggedinUserid").toString();
            
             while (iterator1.hasNext()) {
            Row docRow1= iterator1.next();

             String dbval =(String)docRow1.getAttribute("dbval");
            Integer statusval=docRow1.getAttribute("PiAvailabitystatusID")!=null?(Integer)docRow1.getAttribute("PiAvailabitystatusID"):null;
            Integer dbpasi=docRow1.getAttribute("dbpasi")!=null?(Integer)docRow1.getAttribute("dbpasi"):null;
                 System.out.println("dbpasi val is:::"+dbpasi);
             if(dbval==null &&  statusval!=null){
                     if(statusval.equals(3)){
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                   "Sample Error message",
                                                                                   " Leave can't be proceed from here. please select other status.")); 
                     return;
                     }
                 } 
             if (dbval==null) {
            if (statusval == null|| statusval.equals(0)) {
                           pimonthlyVO.setCurrentRow(docRow1);
                           pimonthlyVO.removeCurrentRow();
                       }
                    else if(statusval.equals(1)){
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
                 return;
                 }
             }
             }
             else if(dbval.equalsIgnoreCase("true")){
                 if(statusval==null){
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                   "Sample Error message",
                                                                                   "please select the Status. Status can't be blank for already deployed records."));  
                     return;   
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
                              return;
                              }
                          }
                 else if(statusval.equals(3)&&!(dbpasi.equals(3))){
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                   "Sample Error message",
                                                                                   " Leave can't be proceed from here. please select other status.")); 
                     return;  
                 }
             }   
             }
            } 
            iterator1.closeRowSetIterator();
            DCBindingContainer bindingContainer1 =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();;
             OperationBinding op=bindingContainer1.getOperationBinding("saveDB");
            String msg=(String) op.execute();
            if(msg.equalsIgnoreCase("success")){
             /*executing emptyrowset */
             OperationBinding op1=bindingContainer1.getOperationBinding("resetWorkAssignNewVO");
             op1.execute();
             FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample Info message",
                                                                          " Details Saved Successfully.")); 
             this.getSubmitBtnBind().setDisabled(true);
             AdfFacesContext.getCurrentInstance().addPartialTarget(getSubmitBtnBind());
             AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
             }
            if(msg.equalsIgnoreCase("fail")){
                OperationBinding op2=bindingContainer1.getOperationBinding("callRollback");
                op2.execute(); 
                FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                             "Sample Info message",
                                                                             " Exception occurred during Save."));  
            }
            if(msg.equalsIgnoreCase("sqlfail")){
                OperationBinding op2=bindingContainer1.getOperationBinding("callRollback");
                op2.execute(); 
                FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                             "Sample Info message",
                                                                             " Please Select other shifts.The current shift is already allocated."));   
            }
            
        }

    public void statusVCL(ValueChangeEvent valueChangeEvent) {
        DCBindingContainer bc=(DCBindingContainer) getBindings();
        DCIteratorBinding dcItteratorBindings =
            bc.findIteratorBinding("PIMonthlyAssignNewVO1Iterator");
        ViewObject pimonthlyVO = dcItteratorBindings.getViewObject();
        Row row=pimonthlyVO.getCurrentRow();
        System.out.println(row.getAttribute("SectorName"));
        row.setAttribute("SectorName", null);
        row.setAttribute("Shift", null);
        row.setAttribute("ZoneName", null);
        row.setAttribute("SectorZone", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getShitBind());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSectorBind());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getZoneBind());
        //AdfFacesContext.getCurrentInstance().addPartialTarget(getTableBind());
        }

   

    public void setTableBind(RichTable tableBind) {
        this.tableBind = tableBind;
    }

    public RichTable getTableBind() {
        return tableBind;
    }

     public void setSubmitBtnBind(RichCommandButton submitBtnBind) {
        this.submitBtnBind = submitBtnBind;
    }

    public RichCommandButton getSubmitBtnBind() {
        return submitBtnBind;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getSelected() {
       return selected;
    }

    public void setFullName(RichInputText fullName) {
        this.fullName = fullName;
    }

    public RichInputText getFullName() {
        return fullName;
    }

    public void sectorVCL(ValueChangeEvent valueChangeEvent) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(getZoneBind());
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTableBind());
    }

    public void setShitBind(RichSelectOneChoice shitBind) {
        this.shitBind = shitBind;
    }

    public RichSelectOneChoice getShitBind() {
        return shitBind;
    }

    public void setSectorBind(RichSelectOneChoice sectorBind) {
        this.sectorBind = sectorBind;
    }

    public RichSelectOneChoice getSectorBind() {
        return sectorBind;
    }

    public void setZoneBind(RichSelectOneChoice zoneBind) {
        this.zoneBind = zoneBind;
    }

    public RichSelectOneChoice getZoneBind() {
        return zoneBind;
    }
}
