package com.imum.cpms.view;

import com.imum.cpms.model.staffdeploy.vo.PITrainingActivityUVORowImpl;
import com.imum.cpms.model.staffdeploy.vo.PIUserMstUVORowImpl;

import com.imum.cpms.staffdeployment.supervisorSectorAssignmentMB;
import com.imum.cpms.util.MessageUtil;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.Map;

import javax.faces.application.FacesMessage;

import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


import javax.servlet.http.HttpSession;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.output.RichOutputText;


import oracle.adfinternal.view.faces.model.binding.FacesCtrlListBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class PITrainingActivityMBean {
    private RichSelectOneChoice piType;
    private RichSelectOneChoice piNumber;
    private RichSelectOneChoice courseName;
    private RichInputText courseDescription;
    MessageUtil genMsg = new MessageUtil();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private RichInputDate startDate;
    private RichInputDate endDate;
    private RichInputText result;
    private String coursenameevent;
    DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichSelectOneChoice courseNameUpdate;
    private RichInputText courseDescriptionUpdate;
    private RichInputText courseNameUpdateText;
    private RichInputDate startDateUpdate;
    private RichInputDate endDateUpdate;
    private RichInputText resultUpdate;
    private RichPanelGroupLayout trainingCourseAllocationForm;
    private RichPanelGroupLayout trainingCourseUpdationForm;
    private RichCommandButton submitAllocation;
    private RichCommandButton cancelAllocation;
    private RichCommandButton submitUpdation;
    private RichCommandButton cancelUpdation;
   
    private HtmlInputHidden snoHidden;
    private HtmlInputHidden piNumberHidden;
    private HtmlInputHidden piTypeHidden;
    private RichPanelHeader piTrainingCourseTableForm;
    private RichCommandButton newTraining;
    private RichCommandButton editTraining;
    private RichOutputText outPutText;
    String lgCode = httpSession.getAttribute("language").toString();
    public static final ADFLogger logger = ADFLogger.createADFLogger(PITrainingActivityMBean.class);
    String  userName = httpSession.getAttribute("loggedinUserid").toString();
    private String rootPath = "//cpmsshare";
   

    public PITrainingActivityMBean() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
    }
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
        private DCBindingContainer getDCBindings() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public void PITypeValueentered(ValueChangeEvent valueChangeEvent) {
            getPiNumberHidden().setValue(null);
            getPiTypeHidden().setValue(null);
            getTrainingCourseAllocationForm().setVisible(false);
            getSubmitAllocation().setVisible(false);
            getCancelAllocation().setVisible(false);
            //getSubmitAllocationTop().setVisible(false);
            //getCancelAllocationTop().setVisible(false);
            getTrainingCourseUpdationForm().setVisible(false);
            getSubmitUpdation().setVisible(false);
            getCancelUpdation().setVisible(false);
            //getSubmitUpdationTop().setVisible(false);
            //getCancelUpdationTop().setVisible(false);
            getPiTrainingCourseTableForm().setVisible(false);
            getNewTraining().setVisible(false);
            getEditTraining().setVisible(false);
            getOutPutText().setVisible(true);
            String PITypevalue = getPiType().getValue().toString();
            int PITypeint = Integer.parseInt(PITypevalue);
            DCBindingContainer bindings3 =
                          (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings2 =
            bindings3.findIteratorBinding("genPITypeLOVVO1Iterator");
            ViewObject TrainingData = dcItteratorBindings2.getViewObject();
            
            ViewObjectImpl trainingvo = (ViewObjectImpl)TrainingData;
            Row selectedrow = trainingvo.getRowAtRangeIndex(PITypeint);
            String PIType = selectedrow.getAttribute("groupid").toString();
//            JUCtrlListBinding listBinding1 =
//                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("genPITypeLOVVO1");
//            String PINO = listBinding1.getSelectedValue().toString();
            System.out.println("PIType"+PIType);
            //BindingContainer bindings = getBindings();
            OperationBinding operationBindingcreate = bindings.getOperationBinding("GetPINumberLOV");
             operationBindingcreate.getParamsMap().put("PIType",PIType);
             Object resultcreate = operationBindingcreate.execute();
             getPiNumber().setDisabled(false);
            DCIteratorBinding TrainingDC = bindings.findIteratorBinding("PITrainingActivityUVO1Iterator");
            ViewObjectImpl TrainingVO =(ViewObjectImpl) TrainingDC.getViewObject();
             TrainingVO.setWhereClause(null);
            TrainingVO.executeQuery();
            
           
        }
    public String SearchPI() {
        try{
        
       
           JUCtrlListBinding listBinding1 =
               (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenPINumberLOVVO1");
           String PINO = listBinding1.getSelectedValue().toString();
            JUCtrlListBinding listBindingPi =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("genPITypeLOVVO1");
            String piType = (String)listBindingPi.getSelectedValue();
            if(piType != null){   
            getPiTypeHidden().setValue(piType);
            }
           DCIteratorBinding TrainingDC =
           bindings.findIteratorBinding("PITrainingActivityUVO1Iterator");
           ViewObjectImpl TrainingVO =(ViewObjectImpl) TrainingDC.getViewObject();
           
            pageflowScope.put("Button","Search");
            pageflowScope.put("PINO", PINO);
            
            getPiTrainingCourseTableForm().setVisible(true);
            getNewTraining().setVisible(true);
            getEditTraining().setVisible(true);
            getNewTraining().setVisible(true);
            getEditTraining().setVisible(true);
            getOutPutText().setVisible(false);
      
               TrainingVO.setWhereClause(null);
               if(PINO != null)
               {
                 getPiNumberHidden().setValue(PINO);
              TrainingVO.setWhereClause( "PI_Number = '"+PINO+"'"); 
                       TrainingVO.executeQuery();
               int count = TrainingVO.getRowCount();
               if(count == 0)
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No course with the PI Exists", genMsg.getMessage("487",lgCode)));
                   
           }
        }catch(Exception e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select Pi Type", genMsg.getMessage("488",lgCode)));
        }
               return null;
    }

    public String Submit() {
        // Add event code here...
        JUCtrlListBinding listBinding1 =
            (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenPINumberLOVVO1");
        String PINO = null;
        if(listBinding1.getSelectedValue() != null)
        PINO = listBinding1.getSelectedValue().toString();
        String coursename = null;
        String coursedesc = null;
        Date startdate = null;
        Date enddate = null;
        String result = null;
        JUCtrlListBinding listBinding1course =
            (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenCoursesLOVVO1");
        if(listBinding1course.getSelectedValue()!= null)
            coursename= listBinding1course.getSelectedValue().toString();
//        if(getCourseName().getValue() != null)
//        coursename = getCourseName().getValue().toString();
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please select Course Name", genMsg.getMessage("489",lgCode)));  
            return null;
        }
        if(getCourseDescription().getValue() != null && !getCourseDescription().getValue().toString().equals(""))
         coursedesc = getCourseDescription().getValue().toString();
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter Course Description", genMsg.getMessage("490",lgCode)));  
            return null;
        }
        if(getStartDate().getValue() != null && !getStartDate().getValue().toString().equals(""))
            startdate = (Date)getStartDate().getValue();
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter Start Date", genMsg.getMessage("491",lgCode)));  
            return null;
        }
        if(getEndDate().getValue() != null && !getEndDate().getValue().toString().equals(""))
        enddate = (Date)getEndDate().getValue();
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter End Date", genMsg.getMessage("492",lgCode)));  
            return null;
        }
        if(getResult().getValue() != null && !getResult().getValue().toString().equals(""))
        result = getResult().getValue().toString();
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter Result", genMsg.getMessage("493",lgCode)));  
            return null;
        }
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding operationBindingcreate = bindings.getOperationBinding("CreateTrainingRow");
         operationBindingcreate.getParamsMap().put("PINO",PINO);
        operationBindingcreate.getParamsMap().put("coursename",coursename);
        operationBindingcreate.getParamsMap().put("coursedesc",coursedesc);
        operationBindingcreate.getParamsMap().put("startdate",startdate);
        operationBindingcreate.getParamsMap().put("enddate",enddate);
        operationBindingcreate.getParamsMap().put("result",result);
        operationBindingcreate.getParamsMap().put("userName",userName);
       
        
         String resultcreate = (String)operationBindingcreate.execute();
//        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
//        Object executeresult = operationBinding.execute();
        if (resultcreate.equalsIgnoreCase("success") ){
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Allocation done  successfully", genMsg.getMessage("494",lgCode))); 
            getTrainingCourseAllocationForm().setVisible(false);
            getSubmitAllocation().setVisible(false);
            getCancelAllocation().setVisible(false);
            SearchPI();
            //getSubmitAllocationTop().setVisible(false);
            //getCancelAllocationTop().setVisible(false);
            return null;
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Course Name Already Exist", genMsg.getMessage("495",lgCode))); 
            getCourseDescription().setValue(null);
            getStartDate().setValue(null);
            getEndDate().setValue(null);
            getResult().setValue(null);
        }
        
        return null;
    }

    public void setPiType(RichSelectOneChoice piType) {
        this.piType = piType;
    }

    public RichSelectOneChoice getPiType() {
        return piType;
    }

    public void setPiNumber(RichSelectOneChoice piNumber) {
        this.piNumber = piNumber;
    }

    public RichSelectOneChoice getPiNumber() {
        return piNumber;
    }

    public void setCourseName(RichSelectOneChoice courseName) {
        this.courseName = courseName;
    }

    public RichSelectOneChoice getCourseName() {
        return courseName;
    }

    public void setCourseDescription(RichInputText courseDescription) {
        this.courseDescription = courseDescription;
    }

    public RichInputText getCourseDescription() {
        return courseDescription;
    }

    public void setStartDate(RichInputDate startDate) {
        this.startDate = startDate;
    }

    public RichInputDate getStartDate() {
        return startDate;
    }

    public void setEndDate(RichInputDate endDate) {
        this.endDate = endDate;
    }

    public RichInputDate getEndDate() {
        return endDate;
    }

    public void setResult(RichInputText result) {
        this.result = result;
    }

    public RichInputText getResult() {
        return result;
    }

    public String EditTraining() {
        // Add event code here...
       
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PITrainingActivityUVO1.currentRow}");
        if(selectedRow == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please select a row to Edit", genMsg.getMessage("496",lgCode)));  
            return null;
        }
        pageflowScope.put("Button","Edit");   
        //System.out.println(selectedRow.getAttribute("Sno").toString());
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("PITrainingActivityUVO1Iterator");
        ViewObject TrainingData = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl trainingvo = (ViewObjectImpl)TrainingData;
        PITrainingActivityUVORowImpl row = (PITrainingActivityUVORowImpl)trainingvo.getCurrentRow();
        
//        if(selectedRow != null)
//        String coursename = selectedRow.getAttribute("Coursename").toString();
//        String courseDesc= row.getAttribute("CourseDesc").toString();
//        Date startDate = (Date)row.getAttribute("StartDate");
//        Date enddate = (Date)row.getAttribute("EndDate");
//        String Result = (String)row.getAttribute("Result");
//        if(coursename != null)
//            getCourseName().setValue(coursename);
//            getCourseDescription().setValue(courseDesc);
//      getStartDate().setValue(startDate);
//      getEndDate().setValue(enddate);
//      getResult().setValue(Result);


//        int SnoInt = Integer.parseInt(sno);
//        trainingvo.setWhereClause("Sno = "+SnoInt);
       // trainingvo.executeQuery();
        
       DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PITrainingActivityUVO1Iterator");
        ViewObject genTrainingCourseVO = (ViewObject)dcItteratorBindings.getViewObject();
       Row rowSelected = genTrainingCourseVO.getCurrentRow();
       if(rowSelected != null){
           Object CourseCode = rowSelected.getAttribute("Coursename");
           Object Sno = rowSelected.getAttribute("Sno");
           if(Sno != null){
               getSnoHidden().setValue(Sno.toString());
           }
           Object piNumber = rowSelected.getAttribute("PINumber");
           getCourseNameUpdateText().setValue(rowSelected.getAttribute("Coursename"));
           getCourseDescriptionUpdate().setValue(rowSelected.getAttribute("CourseDesc"));
           getResultUpdate().setValue(rowSelected.getAttribute("Result"));
           getStartDateUpdate().setValue(rowSelected.getAttribute("StartDate"));
           getEndDateUpdate().setValue(rowSelected.getAttribute("EndDate"));
       }
       getTrainingCourseUpdationForm().setVisible(true);
       getSubmitUpdation().setVisible(true);
       getCancelUpdation().setVisible(true);
        //getSubmitUpdationTop().setVisible(true);
        //getCancelUpdationTop().setVisible(true);
        return null;
    }

    public String updatetraining() {
        Object coursename = null;
        Object coursedesc = null;
        Object startdate = null;
        Object enddate = null;
        Object result1 = null;
        DCIteratorBinding holdVOIter =
            bindingsAM.findIteratorBinding("PITrainingActivityUVO1Iterator");
        ViewObjectImpl trainingvo = (ViewObjectImpl)holdVOIter.getViewObject();
        if(trainingvo != null)
        {
            PITrainingActivityUVORowImpl trainingrow = (PITrainingActivityUVORowImpl)trainingvo.getCurrentRow();
             coursename = trainingrow.getAttribute("Coursename");
        //          coursedesc= trainingrow.getAttribute("CourseDesc");
        //         startdate = trainingrow.getAttribute("StartDate");
//            enddate = trainingrow.getAttribute("EndDate");
//          result1 = trainingrow.getAttribute("Result");
          if(getCourseNameUpdateText().getValue() != null && !getCourseNameUpdateText().getValue().toString().equals("")){
              coursename = getCourseNameUpdateText().getValue();
          }
          if(getCourseDescriptionUpdate().getValue() != null && !getCourseDescriptionUpdate().getValue().toString().equals("")){
              coursedesc = getCourseDescriptionUpdate().getValue();
          }
          if(getResultUpdate().getValue() != null && !getResultUpdate().getValue().toString().equals("")){
              result1 = getResultUpdate().getValue();
          }
          if(getStartDateUpdate().getValue() != null && !getStartDateUpdate().getValue().toString().equals("")){
              startdate = getStartDateUpdate().getValue();
          }
          if(getEndDateUpdate().getValue() != null && !getEndDateUpdate().getValue().toString().equals("")){
              enddate = getEndDateUpdate().getValue();
          }
             if(coursename == null)
                 {
                             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please select Course Name", genMsg.getMessage("489",lgCode)));  
                             return null;
                        
                  }
             else if(coursedesc == null) {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter Course Description", genMsg.getMessage("490",lgCode)));  
                 return null;
             }
             else if(startdate == null) {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter Start Date", genMsg.getMessage("491",lgCode)));  
                 return null;
             }
             else if(enddate == null) {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter End Date", genMsg.getMessage("492",lgCode)));  
                 return null;
             }
             else if(result1 == null)
                 {
                                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please enter Result", genMsg.getMessage("493",lgCode)));  
                                 return null;
                             }
                 

        
        JUCtrlListBinding listBinding1 =
            (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenPINumberLOVVO1");
        String PINO = null;
        if(listBinding1.getSelectedValue() != null)
        PINO = listBinding1.getSelectedValue().toString();
        System.out.println("SnoHidden ::"+getSnoHidden().getValue());
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        BindingContainer bindings = getBindings();
        OperationBinding operationBindingcreate = bindings.getOperationBinding("UpdateTrainingRow");
        operationBindingcreate.getParamsMap().put("PINO",PINO);
        operationBindingcreate.getParamsMap().put("SNOHidden",getSnoHidden().getValue().toString());
        operationBindingcreate.getParamsMap().put("coursename",coursename);
        operationBindingcreate.getParamsMap().put("coursedesc",coursedesc);
        operationBindingcreate.getParamsMap().put("startdate",startdate);
        operationBindingcreate.getParamsMap().put("enddate",enddate);
        operationBindingcreate.getParamsMap().put("result",result1);
        operationBindingcreate.getParamsMap().put("userName",userName);
        
        
         String resultcreate = (String)operationBindingcreate.execute();
        //        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
        //        Object executeresult = operationBinding.execute();
        if (resultcreate.equalsIgnoreCase("success") ){
//        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
//        Object result = operationBinding.execute();
//        if (operationBinding.getErrors().isEmpty()) {
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Allocation updated successfully", genMsg.getMessage("497",lgCode))); 
            getTrainingCourseUpdationForm().setVisible(false);
            getSubmitUpdation().setVisible(false);
            getCancelUpdation().setVisible(false);
            //getSubmitUpdationTop().setVisible(false);
            //getCancelUpdationTop().setVisible(false);
            return null;
        }
        }
        return null;
    }

    public String NewTraining() {
        String PITypevalue = getPiType().getValue().toString();
        if(PITypevalue == null)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please select PI Type", genMsg.getMessage("488",lgCode)));  
                return null;
                   
             }
            
            getCourseDescriptionUpdate().setValue(null);
            getResultUpdate().setValue(null);
            getStartDateUpdate().setValue(null);
            getEndDateUpdate().setValue(null);
        getCourseDescription().setValue(null);
        getResult().setValue(null);
        getStartDate().setValue(null);
        getEndDate().setValue(null);
        pageflowScope.put("Button","New");
        getTrainingCourseAllocationForm().setVisible(true);
        getSubmitAllocation().setVisible(true);
        getCancelAllocation().setVisible(true);
        //getSubmitAllocationTop().setVisible(true);
        //getCancelAllocationTop().setVisible(true);
        
        return null;
    }

    public void StartDateValuechanged(ValueChangeEvent valueChangeEvent) {
        Date startdate = null;
        String coursename = null;
        if(getStartDate().getValue() != null)
            startdate = (Date)getStartDate().getValue();
        else{
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Start Date should not be Empty", genMsg.getMessage("498",lgCode)));
                    getStartDateUpdate().setValue(valueChangeEvent.getOldValue());
                    
                }
        if(getCourseName().getValue() != null)
            coursename = getCourseName().getValue().toString();
       //  int coursenameint = Integer.parseInt(coursename);
        String piNumber = null;
        if(getPiNumberHidden().getValue() != null){
        piNumber = (String)getPiNumberHidden().getValue();
        }
        String piType = null;
        if(getPiTypeHidden().getValue() != null){
            piType = (String)getPiTypeHidden().getValue();
        }
        
            FacesCtrlListBinding listBinding2 =(FacesCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenPINumberLOVVO1");
            Row row = (Row)listBinding2.getCurrentRow();
            if(row.getAttribute("userid") != null){
                piNumber = row.getAttribute("userid").toString();
            }
            
        FacesCtrlListBinding listBindingpi =(FacesCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("genPITypeLOVVO1");
        Row rowpi = (Row)listBindingpi.getCurrentRow();
        if(rowpi.getAttribute("groupname") != null){
            piType = rowpi.getAttribute("groupname").toString();
        }
        
        System.out.println("piNumber :::"+piNumber);
        System.out.println("piType ::::"+piType);
        
       OperationBinding operationBindingvalidateStartDate = bindings.getOperationBinding("validateStartDateTrainingActivate");
       operationBindingvalidateStartDate.getParamsMap().put("startdate",startdate);
        operationBindingvalidateStartDate.getParamsMap().put("piNumber",piNumber);
        String result = (String)operationBindingvalidateStartDate.execute();
            if(result.equalsIgnoreCase("success")){
           
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("GenCoursesLOVVO1Iterator");
        ViewObject TrainingData = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl trainingvo = (ViewObjectImpl)TrainingData;
       // Row selectedrow = trainingvo.getRowAtRangeIndex(coursenameint);
       //  coursename = selectedrow.getAttribute("coursename").toString();
        JUCtrlListBinding listBinding1course =
            (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenCoursesLOVVO1");
        if(listBinding1course.getSelectedValue()!= null)
            coursename= listBinding1course.getSelectedValue().toString();
        if(coursename != null ){
        OperationBinding operationBindingcreate = bindings.getOperationBinding("SetEndDateValue");
        operationBindingcreate.getParamsMap().put("startdate",startdate);
        operationBindingcreate.getParamsMap().put("coursename",coursename);
        operationBindingcreate.getParamsMap().put("piType",piType);
        java.sql.Date enddate = (java.sql.Date)operationBindingcreate.execute();
         //Date enddate = new jave.sql.Date(resultcreate.getTime());
         if(enddate != null){
        getEndDate().setValue(enddate);
         }else{
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                           "CourseNames are Not Available",genMsg.getMessage("499",lgCode)));
             getEndDate().setValue(null);
             getStartDate().setValue(null);
         }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "CourseNames are Not Available",genMsg.getMessage("499",lgCode)));
        }
                
               
            }else if(result.equalsIgnoreCase("noHireDate")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Hire Date Not Available",genMsg.getMessage("500",lgCode)));
                //getEndDate().setValue(null);
                getStartDate().setValue(valueChangeEvent.getOldValue());
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Start Date should be Greater Than Hire Date",genMsg.getMessage("501",lgCode)));
                //getEndDate().setValue(null);
                getStartDate().setValue(valueChangeEvent.getOldValue());
            }
        getPiNumberHidden().setValue(piNumber);
        getPiTypeHidden().setValue(piType);
    }

    public void coursenamechanged(ValueChangeEvent valueChangeEvent) {
        getCourseDescription().setValue(null);
        getStartDate().setValue(null);
        getEndDate().setValue(null);
        getResult().setValue(null);
        // Add event code here...
        String PITypevalue = null;
        if(getCourseName().getValue() != null){
        PITypevalue = getCourseName().getValue().toString();
        
        int PITypeint = Integer.parseInt(PITypevalue);
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("GenCoursesLOVVO1Iterator");
        ViewObject TrainingData = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl trainingvo = (ViewObjectImpl)TrainingData;
        Row selectedrow = trainingvo.getRowAtRangeIndex(PITypeint);
        
       coursenameevent = selectedrow.getAttribute("coursename").toString();
       
//        JUCtrlListBinding listBinding1course =
//           (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenCoursesLOVVO1");
//        if(listBinding1course.getSelectedValue()!= null)
//           coursenameevent= listBinding1course.getSelectedValue().toString();
        }
    }

    public String CourseNameUpdateValueChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PITrainingActivityUVO1.currentRow}");
        if(selectedRow == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please select a row to Edit", genMsg.getMessage("496",lgCode)));  
            return null;
        }
          String coursename = null;  
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("PITrainingActivityUVO1Iterator");
        ViewObject TrainingData = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl trainingvo = (ViewObjectImpl)TrainingData;
     
        if(selectedRow.getAttribute("Coursename") != null)
         coursenameevent = selectedRow.getAttribute("Coursename").toString();
        return null;
    }

    public String StartDateUpdateValueChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PITrainingActivityUVO1.currentRow}");
        if(selectedRow == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please select a row to Edit", genMsg.getMessage("496",lgCode)));  
            return null;
        }
        if(coursenameevent == null){
            coursenameevent = selectedRow.getAttribute("Coursename").toString();
        }
        if(getCourseNameUpdateText().getValue() != null){
            coursenameevent = getCourseNameUpdateText().getValue().toString();
        }
          Date StartDate = null;
        
        DCBindingContainer bindings3 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings2 =
        bindings3.findIteratorBinding("PITrainingActivityUVO1Iterator");
        ViewObject TrainingData = dcItteratorBindings2.getViewObject();
        
        ViewObjectImpl trainingvo = (ViewObjectImpl)TrainingData;
        if(selectedRow.getAttribute("StartDate") != null)
         StartDate = (Date)selectedRow.getAttribute("StartDate");
        System.out.println(getStartDateUpdate().getValue());
        System.out.println(valueChangeEvent.getNewValue());
        try {
        if(getStartDateUpdate().getValue() != null)
               StartDate = (Date)valueChangeEvent.getNewValue();//new SimpleDateFormat("dd-MM-yyyy").parse(getStartDateUpdate().getValue().toString());
        else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Start Date should not be Empty", genMsg.getMessage("498",lgCode)));
            getStartDateUpdate().setValue(valueChangeEvent.getOldValue());
            return null;
        }
            } catch (Exception e) {
            } //(Date)valueChangeEvent.getNewValue();
        System.out.println("start Dtate ::"+StartDate);
         String piNumber = null;//(String)getPiNumberHidden().getValue();
        if(getPiNumberHidden().getValue() != null){
        piNumber = (String)getPiNumberHidden().getValue();
        }
        String piType = null;
        if(getPiTypeHidden().getValue() != null){
            piType = (String)getPiTypeHidden().getValue();
        }
            FacesCtrlListBinding listBinding2 =(FacesCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenPINumberLOVVO1");
            Row row = (Row)listBinding2.getCurrentRow();
            if(row.getAttribute("userid") != null){
                piNumber = row.getAttribute("userid").toString();
            }
            
        FacesCtrlListBinding listBindingpi =(FacesCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("genPITypeLOVVO1");
        Row rowpi = (Row)listBindingpi.getCurrentRow();
        if(rowpi.getAttribute("groupname") != null){
            piType = rowpi.getAttribute("groupname").toString();
        }
        
         System.out.println("piNumber :::"+piNumber);
         System.out.println("piType ::"+piType);
         OperationBinding operationBindingvalidateStartDate = bindings.getOperationBinding("validateStartDateTrainingActivate");
         operationBindingvalidateStartDate.getParamsMap().put("startdate",StartDate);
          operationBindingvalidateStartDate.getParamsMap().put("piNumber",piNumber);
         String result = (String)operationBindingvalidateStartDate.execute();
              if(result.equalsIgnoreCase("success")){
        BindingContainer bindings = getBindings();
        OperationBinding operationBindingcreate = bindings.getOperationBinding("SetEndDateValue");
         operationBindingcreate.getParamsMap().put("startdate",StartDate);
        operationBindingcreate.getParamsMap().put("coursename",coursenameevent);
        operationBindingcreate.getParamsMap().put("piType",piType);
         java.sql.Date enddate = (java.sql.Date)operationBindingcreate.execute();
         //System.out.println(enddate.toString());
         //Date enddate = new jave.sql.Date(resultcreate.getTime());
        //getEndDate().setValue(enddate);
         if(enddate !=  null){
        getEndDateUpdate().setValue(enddate);
         }
              }else if(result.equalsIgnoreCase("noHireDate")){
                  FacesContext.getCurrentInstance().addMessage(null,
                                                               new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                "Hire Date Not Available",genMsg.getMessage("500",lgCode)));
                  //getEndDateUpdate().setValue(null);
                  getStartDateUpdate().setValue(valueChangeEvent.getOldValue());
              }else{
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Start Date should be Greater Than Hire Date",genMsg.getMessage("501",lgCode)));
                 //getEndDateUpdate().setValue(null);
                 getStartDateUpdate().setValue(valueChangeEvent.getOldValue());
             }
        getPiNumberHidden().setValue(piNumber);
        getPiTypeHidden().setValue(piType);
        return null;
    }

    public String Cancel() {
        JUCtrlListBinding listBinding1course =
            (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenCoursesLOVVO1");
        if(getPiNumberHidden().getValue() != null){   
        getPiNumberHidden().setValue(getPiNumberHidden().getValue());
        }
        getCourseDescription().setValue(null);
        getCourseName().setValue(null);
        getStartDate().setValue(null);
        getEndDate().setValue(null);
        getResult().setValue(null);
        getTrainingCourseAllocationForm().setVisible(false);
        getSubmitAllocation().setVisible(false);
        getCancelAllocation().setVisible(false);
        //getSubmitAllocationTop().setVisible(false);
        //getCancelAllocationTop().setVisible(false);
        return null;
    }

    public String CancelUpdate() {
        // Add event code here...
        if(getPiNumberHidden().getValue() != null){   
        getPiNumberHidden().setValue(getPiNumberHidden().getValue());
        }
        getCourseDescriptionUpdate().setValue(null);
         getCourseName().setValue(0);
         getStartDateUpdate().setValue(null);
         getEndDateUpdate().setValue(null);
         getResultUpdate().setValue(null);
 
        getTrainingCourseUpdationForm().setVisible(false);
        getSubmitUpdation().setVisible(false);
        getCancelUpdation().setVisible(false);
        //getSubmitUpdationTop().setVisible(false);
        //getCancelUpdationTop().setVisible(false);
        return null;
    }

    public void setCourseNameUpdate(RichSelectOneChoice courseNameUpdate) {
        this.courseNameUpdate = courseNameUpdate;
    }

    public RichSelectOneChoice getCourseNameUpdate() {
        return courseNameUpdate;
    }

    public void setCourseDescriptionUpdate(RichInputText courseDescriptionUpdate) {
        this.courseDescriptionUpdate = courseDescriptionUpdate;
    }

    public RichInputText getCourseDescriptionUpdate() {
        return courseDescriptionUpdate;
    }

    public void setStartDateUpdate(RichInputDate startDateUpdate) {
        this.startDateUpdate = startDateUpdate;
    }

    public RichInputDate getStartDateUpdate() {
        return startDateUpdate;
    }

    public void setEndDateUpdate(RichInputDate endDateUpdate) {
        this.endDateUpdate = endDateUpdate;
    }

    public RichInputDate getEndDateUpdate() {
        return endDateUpdate;
    }

    public void setResultUpdate(RichInputText resultUpdate) {
        this.resultUpdate = resultUpdate;
    }

    public RichInputText getResultUpdate() {
        return resultUpdate;
    }

    public void setTrainingCourseAllocationForm(RichPanelGroupLayout trainingCourseAllocationForm) {
        this.trainingCourseAllocationForm = trainingCourseAllocationForm;
    }

    public RichPanelGroupLayout getTrainingCourseAllocationForm() {
        return trainingCourseAllocationForm;
    }

    public void setTrainingCourseUpdationForm(RichPanelGroupLayout trainingCourseUpdationForm) {
        this.trainingCourseUpdationForm = trainingCourseUpdationForm;
    }

    public RichPanelGroupLayout getTrainingCourseUpdationForm() {
        return trainingCourseUpdationForm;
    }

    public void setSubmitAllocation(RichCommandButton submitAlloction) {
        this.submitAllocation = submitAlloction;
    }

    public RichCommandButton getSubmitAllocation() {
        return submitAllocation;
    }

    public void setCancelAllocation(RichCommandButton cancelAlloction) {
        this.cancelAllocation = cancelAlloction;
    }

    public RichCommandButton getCancelAllocation() {
        return cancelAllocation;
    }

    public void setSubmitUpdation(RichCommandButton submitUpdation) {
        this.submitUpdation = submitUpdation;
    }

    public RichCommandButton getSubmitUpdation() {
        return submitUpdation;
    }

    public void setCancelUpdation(RichCommandButton cancelUpdation) {
        this.cancelUpdation = cancelUpdation;
    }

    public RichCommandButton getCancelUpdation() {
        return cancelUpdation;
    }

    public void setSnoHidden(HtmlInputHidden snoHidden) {
        this.snoHidden = snoHidden;
    }

    public HtmlInputHidden getSnoHidden() {
        return snoHidden;
    }

    public void setPiTrainingCourseTableForm(RichPanelHeader piTrainingCourseTableForm) {
        this.piTrainingCourseTableForm = piTrainingCourseTableForm;
    }

    public RichPanelHeader getPiTrainingCourseTableForm() {
        return piTrainingCourseTableForm;
    }

    public void setNewTraining(RichCommandButton newTraining) {
        this.newTraining = newTraining;
    }

    public RichCommandButton getNewTraining() {
        return newTraining;
    }

    public void setEditTraining(RichCommandButton editTraining) {
        this.editTraining = editTraining;
    }

    public RichCommandButton getEditTraining() {
        return editTraining;
    }

    public void setOutPutText(RichOutputText outPutText) {
        this.outPutText = outPutText;
    }

    public RichOutputText getOutPutText() {
        return outPutText;
    }

    public void PINumberValueChangeLisner(ValueChangeEvent valueChangeEvent) {
         getPiNumberHidden().setValue(null);
        getTrainingCourseAllocationForm().setVisible(false);
        getSubmitAllocation().setVisible(false);
        getCancelAllocation().setVisible(false);
        //getSubmitAllocationTop().setVisible(false);
        //getCancelAllocationTop().setVisible(false);
        getTrainingCourseUpdationForm().setVisible(false);
        getSubmitUpdation().setVisible(false);
        getCancelUpdation().setVisible(false);
        //getSubmitUpdationTop().setVisible(false);
        //getCancelUpdationTop().setVisible(false);
        getPiTrainingCourseTableForm().setVisible(false);
        getNewTraining().setVisible(false);
        getEditTraining().setVisible(false);
        getOutPutText().setVisible(true);
    }

    public void setPiNumberHidden(HtmlInputHidden piNumberHidden) {
        this.piNumberHidden = piNumberHidden;
    }

    public HtmlInputHidden getPiNumberHidden() {
        return piNumberHidden;
    }
    
    public String EditTrainingActivity() {
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PITrainingActivityUVO1Iterator");
         ViewObject genTrainingMasterVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = genTrainingMasterVO.getCurrentRow();
        if(rowSelected != null){
            Object CourseName = rowSelected.getAttribute("Coursename");
            //logger.info("Selected TrainingCourseCode in Edit_action is : "+CourseCode);
            
            if(CourseName!=null && !"".equals(CourseName))
            {
            }
        }
        return null;
    }

    public void setCourseNameUpdateText(RichInputText courseNameUpdateText) {
        this.courseNameUpdateText = courseNameUpdateText;
    }

    public RichInputText getCourseNameUpdateText() {
        return courseNameUpdateText;
    }


    public void setPiTypeHidden(HtmlInputHidden piTypeHidden) {
        this.piTypeHidden = piTypeHidden;
    }

    public HtmlInputHidden getPiTypeHidden() {
        return piTypeHidden;
    }

    public void fileuploadVC(ValueChangeEvent vce) {
        String uploadPath = null;
        String fullPath = null;
        BigDecimal seq = new BigDecimal(0);
        RichInputFile inputFileComponent = (RichInputFile)vce.getComponent();
        UploadedFile newFile = (UploadedFile)vce.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());
        String Pinum=pageflowScope.get("PINO").toString();
        
        DCIteratorBinding usermstiter =
            bindingsAM.findIteratorBinding("PINumFromUserMstVO1Iterator");
        ViewObject usrmstVO=usermstiter.getViewObject();
        usrmstVO.applyViewCriteria(null);
        usrmstVO.setWhereClause(null);
        String qry="PIUserMstEO.User_Id='"+Pinum+ "' ";
      
       usrmstVO.setWhereClause(qry);
       System.out.println("Query is:::"+usrmstVO.getQuery());
       usrmstVO.executeQuery();
       Row usrmstrow= usrmstVO.first();
       //Row usrmstrow=usrmstVO.getCurrentRow();
       String usernum=usrmstrow.getAttribute("USERNUM").toString();
       int usrno=Integer.parseInt(usernum);
       

        DCIteratorBinding dciterrefundattchmt =
            bindingsAM.findIteratorBinding("GenUserDocsVO1Iterator");

        ViewObject genuserdocsvo = dciterrefundattchmt.getViewObject();


        try {
            Row docsrow = genuserdocsvo.createRow();

            if (null != vce.getNewValue()) {
                UploadedFile uploadFile = (UploadedFile)vce.getNewValue();
                if (uploadFile != null) {
                    uploadPath =
                            uploadFilesToFolder("1", "TrainigDocs", usernum,
                                                uploadFile);
                    if (uploadPath != null) {
                        fullPath =
                                uploadPath + "//" + uploadFile.getFilename();
                    }
                    String docFielName = uploadFile.getFilename();
                    java.sql.Date sqlDate =
                        new java.sql.Date(new java.util.Date().getTime());
                    System.out.println("sqlDate is : " + sqlDate);

                    int docType = getFileExtension(docFielName);

                    docsrow.setAttribute("USERNUM", usrno);
                    docsrow.setAttribute("CreatedBy", userName);
                    docsrow.setAttribute("filepath", fullPath);
                    docsrow.setAttribute("Docstage", 1);
                    docsrow.setAttribute("deleteflag", "N");
                    docsrow.setAttribute("CreatedDate", sqlDate);
                    docsrow.setAttribute("DOCDesc", docFielName);
                    docsrow.setAttribute("doctype", docType);
                    genuserdocsvo.insertRow(docsrow);
                  
                    }
                }
            }
                catch(Exception e){
                    e.printStackTrace();
                }
                   
    }
    public String uploadFilesToFolder(String organizationId,
                                          String documentCategory, String code,
                                           UploadedFile uploadFiles) {

          String path = null;
          String uploadedPath = null;
          if (null != uploadFiles) {
           
              UploadedFile tempFile = uploadFiles;
              System.out.println("temp file" + tempFile.getFilename());
             // rootPath = "D://FileStore";
              File rootP = new File(rootPath);
              rootP.setWritable(Boolean.TRUE);
              if (tempFile != null) {
                System.out.println(tempFile.getFilename());
                File orgId = new File(rootPath + "//"+ organizationId);
                // check if orgId folder exist
                if (!orgId.isDirectory()) {
                  System.out.println("before creating directory orgId");            
                  orgId.mkdir();
                  orgId.setWritable(Boolean.TRUE);
                  System.out.println("after creating directory orgId");
                    path = rootPath + "//"+  organizationId;
                    uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
                }else{
                     path = rootPath + "//" + organizationId;
                     uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
                    }
                      
                      System.out.println("Path in if part" + path);
                } 
                
            
            }
              return uploadedPath;
          }
        private String findDirectoryAndUpload(String documentCategory, String code, String path, String rootPath, String orgId, UploadedFile tempFile) {
            String pvtTempPath = null;
            String tempPath = null;
            File pathFile = null;
            //Check if document category exist
                       if(documentCategory.equals("TrainigDocs"))
                       {                        
                         File docCat = null;
                         if (documentCategory.equals("TrainigDocs"))
                         {
                           path=  getFolderPath(orgId, documentCategory, code);
                           pvtTempPath = path;
                           docCat = new File(pvtTempPath);
                         }else{                       
                           System.out.println("before creating directory documentCategory");  
                           tempPath = rootPath + "//" + orgId  +"//" + documentCategory;
                           docCat = new File(tempPath);                       
                        
                           if(!docCat.isDirectory()){
                                   docCat.mkdir();
                                   docCat.setWritable(Boolean.TRUE);
                                   //path = rootPath + "//" + orgId + "//"+ documentCategory;
                               }
                           else{
                                //path = rootPath + "//" + orgId + "//"+ documentCategory;                            
                            }
                           path = tempPath;
                         }
                           System.out.println("after creating directory documentCategory");  
                           if(documentCategory.equals("TrainigDocs"))
                           {
                              pathFile = new File (pvtTempPath + "//" + code);
                              path = pvtTempPath + "//" + code;
                           }
                           else
                           {
                              pathFile = new File (tempPath + "//" + code);
                              path = tempPath + "//" + code;
                            }
                           
                           if(!pathFile.isDirectory())
                           {
                                pathFile.mkdir();
                                pathFile.setWritable(Boolean.TRUE);
                                //path = rootPath + "//" + orgId + "//"+ documentCategory + "//" + code;
                                callUploadFiles(tempFile, path);    
                                
                           }else{
                                 //path = rootPath + "//" + orgId + "//"+ documentCategory + "//" + code;
                                 callUploadFiles(tempFile, path);                                   
                               }                       
                       }                   
                         
          
                       return path;
        }
        public String getFolderPath(String orgId, String documentCategory, String code){
            
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                String monthS = "0";
                String path = null;
                if(month < 10) {
                     monthS = "0"+month;
                    }else {
                     monthS = String.valueOf(month);
                }

                File currentYearMonth = new File(rootPath + "//" + orgId + "//"+ documentCategory +"//"+ year+monthS);
                
                if(!currentYearMonth.isDirectory())
                {
                  currentYearMonth.mkdirs();
                  currentYearMonth.setWritable(Boolean.TRUE);
                  path = rootPath + "//" + orgId + "//"+ documentCategory +"//"+year+monthS;             
                  
                }else{
                 path = rootPath + "//" + orgId + "//"+ documentCategory +"//"+year+monthS;            
                  
                }
                return path;
            }
        
        
        
        public void callUploadFiles(UploadedFile tempFile, String path){
            
                InputStream inputStream = null;
                try {
                  FileOutputStream out = new FileOutputStream(path +"//"+ tempFile.getFilename());
                  inputStream = tempFile.getInputStream();
                  byte[] buffer = new byte[8192];
                  int bytesRead = 0;
                  while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, bytesRead);
                  }
                  out.flush();
                  out.close();
                } catch (Exception ex) {
                  // handle exception
                  ex.printStackTrace();
                } finally {
                  try {
                      if(inputStream!=null){
                          inputStream.close(); 
                      }
                    
                  } catch (IOException e) {
                  }
                }
            }
                    
     private static int getFileExtension(String file) {
        String fileName = file;
        String extType = null;
        int docType = 0;
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            extType = fileName.substring(fileName.lastIndexOf(".")+1);
            //.gif.bmp.dib.jpg.jpe.jfif.tiff.tif
            if(extType != null && extType.equalsIgnoreCase("jpeg")|| extType.equalsIgnoreCase("png") ||
            extType.equalsIgnoreCase("gif")|| extType.equalsIgnoreCase("bmp")||extType.equalsIgnoreCase("dib")|| extType.equalsIgnoreCase("jpg")||
            extType.equalsIgnoreCase("jfif")|| extType.equalsIgnoreCase("tiff")||extType.equalsIgnoreCase("tif")){
                extType = "IMAGE";
                docType = 2;
            }else if(extType != null && extType.equalsIgnoreCase("xml")){
                extType = "XML";
                docType=3;
            }else if(extType != null && extType.equalsIgnoreCase("pdf")|| extType.equalsIgnoreCase("docx") || extType.equalsIgnoreCase("doc") ||extType.equalsIgnoreCase("xlsx")
                   || extType.equalsIgnoreCase("xls") || extType.equalsIgnoreCase("txt")){
                extType = "PDF";
                docType=3;
            }else if(extType != null && ( extType.equalsIgnoreCase("MPG")|| extType.equalsIgnoreCase("MPEG"))){
                extType = "Video";
                docType=4;
            }
            return docType;
        }
        
        else return docType;
        }
            
}
