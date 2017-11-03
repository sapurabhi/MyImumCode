package com.imum.cpms.staffdeployment;

import com.imum.cpms.model.staffdeploy.vo.HHCNewReRowImpl;

import com.imum.cpms.util.MessageUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.jbo.Row;


import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class supervisorSectorAssignmentMB {
    
    private RichCommandButton b1;
    private RichCommandButton b2;
    private RichCommandButton b3;
    private RichInputDate startDate;
    private RichInputDate endDate;
    MessageUtil genMsg = new MessageUtil();
    String oldValue = "";
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    public static final ADFLogger logger = ADFLogger.createADFLogger(supervisorSectorAssignmentMB.class);

    public supervisorSectorAssignmentMB() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
    }
    private DCBindingContainer getBindings1() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public String doSave() {
        logger.info("Start DoSave Method of supervisorSectorAssignmentMB ");
        try{
            
        //String mang="Manager";
        String sessionManager = httpSession.getAttribute("loggedinUserid").toString();
        String states="Assigned";
       Date currentDate = new Date(System.currentTimeMillis());
       java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
        if(startDate.getValue() == null ){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("401",lgCode)));
//            FacesMessage fm = new FacesMessage("Assign Start Date should not be Empty");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
            return null;
        }else if(endDate.getValue() == null){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("402",lgCode)));
            //            FacesMessage fm = new FacesMessage("Assign End Date should not be Empty");
            //            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            //            FacesContext fctx = FacesContext.getCurrentInstance();
            //            fctx.addMessage(null, fm);
        }
           
        Date sdate=(Date)startDate.getValue();
        Date edate=(Date)endDate.getValue();
        java.sql.Date fD1 = new java.sql.Date(sdate.getTime());
        java.sql.Date endD1 = new java.sql.Date(edate.getTime());
        int assignStartDt = Integer.parseInt(fD1.toString().replaceAll("-", ""));
        int assignEndDt = Integer.parseInt(endD1.toString().replaceAll("-", ""));
       // System.out.println("from date ---"+fD1);
        //System.out.println("System Date"+sqlDate1);
        String curDate = sqlDate1.toString();
        String fromDate = fD1.toString();
          //  long diff = sqlDate1.getTime()-fD1.getTime();
            long diff = fD1.getTime()-sqlDate1.getTime();
            long diffHours = diff / (60 * 60 * 1000);
            long dayes= diffHours/24;
            //System.out.println(dayes);
            if(dayes < 0){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("394",lgCode)));
//                FacesMessage fm = new FacesMessage("Assignment Date should not be less than Current Date ");
//                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                 fctx.addMessage(null, fm);   
                return null;
            }else if(assignStartDt > assignEndDt){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("403",lgCode)));
                //                FacesMessage fm = new FacesMessage("Assign END Date should not be less than Assign Start Date");
                //                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                //                FacesContext fctx = FacesContext.getCurrentInstance();
                //                 fctx.addMessage(null, fm);
                
            }else{
       // System.out.println("-------------------------------------------------dosave -------------------------------------------");
        // Add event code here...
         
        JUCtrlListBinding listBinding = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("supervisorlistVO1");
        String supname = (String)listBinding.getSelectedValue();
       // System.out.println(supname);
            if(supname == null){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("395",lgCode)));
//                FacesMessage fm = new FacesMessage("Supervisor should be selected");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm);  
                return null;
            }
        
        JUCtrlListBinding listBinding2 =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
        Object[] str = (Object[])listBinding2.getSelectedValues();
        ArrayList ArrList = new ArrayList();
        boolean countSector = false;
        for (Object s : str) {
            ArrList.add(s);
            //System.out.println(s);
                  countSector = true;
            
              }
        if(!countSector){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("396",lgCode)));
//            FacesMessage fm = new FacesMessage("Atleast one Sector should be Selected");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
            return null;
        }
        //System.out.println(sdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdate);
        cal.add(Calendar.MONTH, 1);
        Date endDate = edate;//cal.getTime();
        //System.out.println(sdate);
        //System.out.println(endDate);
        OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("SaveSup");
        op1.getParamsMap().put("supname", supname);
        op1.getParamsMap().put("mang", sessionManager);
        //System.out.println("Sadtae---"+sdate);
        op1.getParamsMap().put("sdate", sdate);
        op1.getParamsMap().put("endDate", endDate);
        op1.execute();
        BindingContainer bin = getBindings();
        OperationBinding ob = bin.getOperationBinding("doCommit");
        Object re = ob.execute();
        OperationBinding op2 = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("SaveAllocDtls");
        op2.getParamsMap().put("selectedsector", ArrList);
        //op2.getParamsMap().put("shift",shift1);            
        op2.execute();
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
        Object result = operationBinding.execute();
//        OperationBinding op = (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("sector");
//        op.getParamsMap().put("shift",shift1);
//        op.getParamsMap().put("selectedsector",ArrList );
//        op.execute();
                     
            getEndDate().setValue(getAssignEndDateDefault());
        if (!operationBinding.getErrors().isEmpty())
           {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("397",lgCode)));
                
//            FacesMessage fm = new FacesMessage("supervisor sector Assignment is not Successfull");
//            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);      
                return null;
            }
        else
            {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("398",lgCode)));
//             FacesMessage fm = new FacesMessage("supervisor sector Assignment done Successfully");
//             fm.setSeverity(FacesMessage.SEVERITY_INFO);
//             FacesContext fctx = FacesContext.getCurrentInstance();
//             fctx.addMessage(null, fm);
            JUCtrlListBinding listBindingReset =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
            listBindingReset.clearSelectedIndices();
            getStartDate().setValue(new Date());
            getEndDate().setValue(getAssignEndDateDefault());
            return null;
             }
            
        }
            
        }catch(Exception NullPointerException)
        {              
            }
        JUCtrlListBinding listBindingReset =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
        listBindingReset.clearSelectedIndices();
        getStartDate().setValue(new Date());
        getEndDate().setValue(getAssignEndDateDefault());
        logger.info("End DoSave Method of supervisorSectorAssignmentMB ");
        return null;
        
    }

   

    public void setB1(RichCommandButton b1) {
        this.b1 = b1;
    }

    public RichCommandButton getB1() {
        return b1;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setStartDate(RichInputDate startDate) {
        this.startDate = startDate;
    }

    public RichInputDate getStartDate() {
        return startDate;
    }
    private Date currentDate = new Date();
   
            
    private Date currentEDate = getAssignEndDateDefault();

    private Date getAssignEndDateDefault(){
        Date strtDate = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(strtDate);
        cal.add(Calendar.YEAR, 10);
        return (Date)cal.getTime();
    }
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setB2(RichCommandButton b2) {
        this.b2 = b2;
    }

    public RichCommandButton getB2() {
        return b2;
    }

    public void amendScreen(ActionEvent actionEvent) {
        logger.info("Start AmendScreen Method of supervisorSectorAssignmentMB ");
        //System.out.println("in Action Listener");
        FacesCtrlHierBinding listBinding2 =(FacesCtrlHierBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("SupervisorSectorAssignmentVO1");
        Row row = (Row)listBinding2.getCurrentRow();
           
        //System.out.println("AllocID ::"+row.getAttribute("allocid").toString());
      //  System.out.println("Sector ::"+row.getAttribute("Sector").toString());
      //  System.out.println("SupID ::"+row.getAttribute("supid").toString());
       // System.out.println("AssgnStartDate ::"+(Date)row.getAttribute("AssgnStartDate"));
        //System.out.println("AssgnEndDate ::"+(Date)row.getAttribute("AssgnEndDate"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Allocid",  row.getAttribute("allocid").toString());
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("currentSector",  row.getAttribute("Sector").toString());
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("supId",  row.getAttribute("supid").toString());
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("AssgnStartDate",  (Date)row.getAttribute("AssgnStartDate"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("AssgnEndDate",  (Date)row.getAttribute("AssgnEndDate"));
        JUCtrlListBinding listBindingReset =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
        listBindingReset.clearSelectedIndices();
        getStartDate().setValue(new Date());
        getEndDate().setValue(getAssignEndDateDefault());
        logger.info("End AmendScreen Method of supervisorSectorAssignmentMB ");
    }

    public void setB3(RichCommandButton b3) {
        this.b3 = b3;
    }

    public RichCommandButton getB3() {
        return b3;
    }

    public String cb3_action() {
        logger.info("Start cb3_action Method of supervisorSectorAssignmentMB ");
        //System.out.println("To Reset All Selected Values");
        JUCtrlListBinding listBindingSectorReset =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
        listBindingSectorReset.clearSelectedIndices();
        JUCtrlListBinding listBindingSupervisorReset = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("supervisorlistVO1");
        listBindingSupervisorReset.setSelectedIndex(0);
        getStartDate().setValue(new Date());
        getEndDate().setValue(getAssignEndDateDefault());
        logger.info("End cb3_action Method of supervisorSectorAssignmentMB ");
        // Add event code here...
        return null;
    }

    public void setEndDate(RichInputDate endDate) {
        this.endDate = endDate;
    }

    public RichInputDate getEndDate() {
        return endDate;
    }

    public void setCurrentEDate(Date currentEDate) {
        this.currentEDate = currentEDate;
    }

    public Date getCurrentEDate() {
        return currentEDate;
    }
}
