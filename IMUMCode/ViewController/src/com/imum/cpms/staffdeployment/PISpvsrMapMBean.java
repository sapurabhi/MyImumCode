package com.imum.cpms.staffdeployment;

import com.imum.cpms.util.ADFUtils;
import com.imum.cpms.util.MessageUtil;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectManyShuttle;
import oracle.adf.view.rich.component.rich.input.RichSelectOneListbox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlListBinding;
import com.imum.cpms.util.MessageUtil;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;

public class PISpvsrMapMBean {
        private RichInputDate startDate; //Commented  Kiran
        private RichSelectManyShuttle shuttleValues;
        private RichPopup popup;
    private RichSelectOneListbox supervisors;
    public String selectedSpvsr ="";
    private RichTable tempTable;
    MessageUtil genMsg = new MessageUtil();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    private RichPanelGroupLayout tempTablePanel;
    private boolean renderTableFlag = false;
    private String currentDate ="";
    private java.util.Date curDate = new java.util.Date();
    private java.util.Date newDate = new java.util.Date();
    private String newDateDtr="";
    public static final ADFLogger logger = ADFLogger.createADFLogger(PISpvsrMapMBean.class);

    public PISpvsrMapMBean() {
            if(lgCode==null || lgCode.equals(""))
            {
                lgCode = "EN";
            }
        }

        public void saveDetails(ActionEvent actionEvent) {
            logger.info("Start saveDetails Method of PISpvsrMapMBean ");
            try{
              //  RichInputDate startDate;//Added Kiran
            MessageUtil mu;
            mu = new MessageUtil();
                //Kiran
           // System.out.println("startDate.getValue()"+startDate.getValue());//Added Kiran
                
            if(startDate.getValue()==null){
                if(startDate.getValue().toString().trim().length()==0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", mu.getMessage("390", lgCode)));            
                }
            } 
                
            Date strtDate = new Date();
            if(startDate.getValue()!=null){
            strtDate  = (java.util.Date)startDate.getValue();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(strtDate);
            cal.add(Calendar.MONTH, 1);
            Date endDate = (Date)cal.getTime();
             OperationBinding op = (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("SavePIDtls");
             op.getParamsMap().put("PId", null);
            op.getParamsMap().put("selectedPIds", null);
            op.getParamsMap().put("startDate", strtDate);
            op.getParamsMap().put("endDate", endDate);
               // System.out.println("startDate" + strtDate);
                //System.out.println("endDate"+ endDate);
            String result = (String)op.execute();
               
                OperationBinding opComm = (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("doCommit");
               Boolean resultBool = (Boolean)opComm.execute();
                //System.out.println(resultBool);
                startDate.setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(startDate);
                if(resultBool){
                    
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                popup.show(hints);
   
            }else{
                //System.out.println("Error");
            }
            }catch(Exception e){
                e.printStackTrace();
            }
            logger.info("End saveDetails Method of PISpvsrMapMBean ");
           
        }
                public BindingContainer getBindings() {
                        return BindingContext.getCurrent().getCurrentBindingsEntry();
                    }
        public void resetDetails(ActionEvent actionEvent) {
            logger.info("Start resetDetails Method of PISpvsrMapMBean ");
          //  RichInputDate startDate;//Added Kiran
//            BindingContainer bc = this.getBindings();
//           //new
//            JUCtrlListBinding listBindings = (JUCtrlListBinding)bc.get("PIsForGenPoolVO1");
//            //listBindings.clearSelectedIndices();
            startDate.setValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(startDate);
            logger.info("End resetDetails Method of PISpvsrMapMBean ");
            
        }
        

        public void setStartDate(RichInputDate startDate) {
            this.startDate = startDate;
        }

        public RichInputDate getStartDate() {
            return startDate;
        }

        public void setShuttleValues(RichSelectManyShuttle shuttleValues) {
            this.shuttleValues = shuttleValues;
        }

        public RichSelectManyShuttle getShuttleValues() {
            return shuttleValues;
        }

        public void successMsg(DialogEvent dialogEvent) {
            logger.info("Start successMsg Method of PISpvsrMapMBean ");
            BindingContainer bc = this.getBindings ();
            JUCtrlListBinding listBindings = (JUCtrlListBinding)bc.get("PIsForGenPoolVO1");
            int[] lt = listBindings.getSelectedIndices();
           //new
            OperationBinding op = (OperationBinding)bc.getOperationBinding("clearList");
            op.getParamsMap().put("indices", lt);
            op.execute();
            listBindings.clearSelectedIndices();
            AdfFacesContext.getCurrentInstance().addPartialTarget(shuttleValues);
            logger.info("End successMsg Method of PISpvsrMapMBean ");
        }

    public void addDetails(ActionEvent actionEvent) {
        logger.info("Start addDetails Method of PISpvsrMapMBean ");
        //date validation :
        MessageUtil mu;
        mu = new MessageUtil();

        //System.out.println("Date in addDetails ---------"+startDate.getValue());
        if (startDate.getValue() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          mu.getMessage("390",
                                                                                            lgCode)));
        } else if (startDate.getValue() != null) {
            if (startDate.getValue().toString().trim().length() == 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                            mu.getMessage("390",
                                                                                                lgCode)));
            } else {

                JUCtrlListBinding listBinding =
                    (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PIsForGenPoolVO1");
                Object[] str = (Object[])listBinding.getSelectedValues();
                if (str != null && str.length > 0) {
                    ArrayList ArrList = new ArrayList();
                    for (Object s : str) {
                        ArrList.add(s);
                    }
                    JUCtrlListBinding listBinding1 =
                        (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("SpvsrDtlsVO1");
                    String strVal = (String)listBinding1.getSelectedValue();
                    //System.out.println("Supervisior ------------"+strVal);
                    if (strVal == null || strVal == "") {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      mu.getMessage("390",
                                                                                                        lgCode)));
                    } else {
                        //render table :
                        setRenderTableFlag(true);
                        tempTablePanel.setVisible(true);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(tempTablePanel);
                        
                        OperationBinding op =
                            (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("addDetails");
                   // System.out.println(""+strVal);
                      //  System.out.println(""+ArrList);
                        op.getParamsMap().put("PId", strVal);
                        op.getParamsMap().put("selectedPIds", ArrList);
                        String result = (String)op.execute();
                        OperationBinding opComm =
                            (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("doCommit");
                        Boolean resultBool = (Boolean)opComm.execute();
                      //  System.out.println(resultBool);
                        if (resultBool) {
                            clearPIPool();
                           // clearSpvsrDtls();
                            AdfFacesContext.getCurrentInstance().addPartialTarget(tempTable);
                            
                        }
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  mu.getMessage("391",
                                                                                                    lgCode)));
                    
                   // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("32", lngCode)));
                }
            }
        }
        logger.info("End addDetails Method of PISpvsrMapMBean ");
    }
        public void clearPIPool(){
            logger.info("Start clearPIPool Method of PISpvsrMapMBean ");
            BindingContainer bc1 = this.getBindings ();
            JUCtrlListBinding listBindings = (JUCtrlListBinding)bc1.get("PIsForGenPoolVO1");
           int[] lt1 = listBindings.getSelectedIndices();
                OperationBinding op2 = (OperationBinding)bc1.getOperationBinding("clearList");
                op2.getParamsMap().put("indices", lt1);
                op2.execute();
                listBindings.clearSelectedIndices();
                AdfFacesContext.getCurrentInstance().addPartialTarget(shuttleValues);
            logger.info("End clearPIPool Method of PISpvsrMapMBean ");
            //new


        }
        public void clearSpvsrDtls(){
            logger.info("Start clearSpvsrDtls Method of PISpvsrMapMBean ");
            BindingContainer bc = this.getBindings();
            JUCtrlListBinding listBindings1 = (JUCtrlListBinding)bc.get("SpvsrDtlsVO1");
          int[] lt = listBindings1.getSelectedIndices();
              //System.out.println(lt);
                OperationBinding op1 = (OperationBinding)bc.getOperationBinding("clearListSpvsr");
                op1.getParamsMap().put("indices", lt);
                op1.execute();
                listBindings1.clearSelectedIndices();
                AdfFacesContext.getCurrentInstance().addPartialTarget(supervisors);
            logger.info("End clearSpvsrDtls Method of PISpvsrMapMBean ");
            //new
        }

        public void setPopup(RichPopup popup) {
            this.popup = popup;
        }

        public RichPopup getPopup() {
            return popup;
        }

    public void setSupervisors(RichSelectOneListbox supervisors) {
        this.supervisors = supervisors;
    }

    public RichSelectOneListbox getSupervisors() {
        return supervisors;
    }

    public void setSelectedSpvsr(String selectedSpvsr) {
        this.selectedSpvsr = selectedSpvsr;
    }

    public String getSelectedSpvsr() {
        return selectedSpvsr;
    }

    public void removeRow(ActionEvent actionEvent) {
        logger.info("Start removeRow Method of PISpvsrMapMBean ");
        OperationBinding op = (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("removeDetails");
        HashMap Val = (HashMap)op.execute();
        Set s = Val.keySet();
        ArrayList keys = new ArrayList();
        ArrayList values = new ArrayList();
        for(Object o :s.toArray()){
            keys.add(o.toString());
            values.add(Val.get(o.toString()));
        }
       // System.out.println(keys);
        //System.out.println(values);
        
        clearPIPool();
        clearSpvsrDtls();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(tempTable);
        logger.info("End removeRow Method of PISpvsrMapMBean ");
    }

    public void setTempTable(RichTable tempTable) {
        this.tempTable = tempTable;
    }

    public RichTable getTempTable() {
        return tempTable;
    }

    public void removePiRow(ActionEvent actionEvent) {
        logger.info("Start removePiRow Method of PISpvsrMapMBean ");
        OperationBinding op = (OperationBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("removeDetails");
        HashMap Val = (HashMap)op.execute();
        Set s = Val.keySet();
        ArrayList keys = new ArrayList();
        ArrayList values = new ArrayList();
        for(Object o :s.toArray()){
            keys.add(o.toString());
            values.add(Val.get(o.toString()));
        }
       // System.out.println(keys);
        //System.out.println(values);
        BindingContainer bc = this.getBindings();
        
        
      //  AdfFacesContext.getCurrentInstance().addPartialTarget(supervisors);
        AdfFacesContext.getCurrentInstance().addPartialTarget(shuttleValues);
        AdfFacesContext.getCurrentInstance().addPartialTarget(tempTable);
        logger.info("End removePiRow Method of PISpvsrMapMBean ");
    }
    public void getCurrentDate(){
        logger.info("Start getCurrentDate Method of PISpvsrMapMBean ");
        SimpleDateFormat stf = new SimpleDateFormat("dd-MM-yyyy");
        curDate = new Date();
        try {
            curDate = stf.parse(stf.format(curDate).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
       // System.out.println(curDate);
        
//        System.out.println(curDate);
//        java.sql.Date sqlDate = new java.sql.Date(curDate.getTime());
//        System.out.println(sqlDate);
//        newDate = (Date)sqlDate;
//        System.out.println("newDate :"+newDate);
//        
//        
//        newDateDtr = newDate.toString();
//
//
//        try {
//            newDate = stf.parse(newDateDtr);
//        } catch (ParseException e) {
//        }
//        System.out.println(newDate);
         DCIteratorBinding dciteralloc = ADFUtils.findIterator("PiTempRVO1Iterator");
        dciteralloc.getViewObject().executeQuery();
        DCIteratorBinding dciter = ADFUtils.findIterator("PIsForGenPoolVO1Iterator");
        dciter.getViewObject().executeQuery();
        DCIteratorBinding dcitersup = ADFUtils.findIterator("SpvsrDtlsVO1Iterator");
        dcitersup.getViewObject().executeQuery();
        logger.info("End getCurrentDate Method of PISpvsrMapMBean ");
    }
    public void setTempTablePanel(RichPanelGroupLayout tempTablePanel) {
        this.tempTablePanel = tempTablePanel;
    }

    public RichPanelGroupLayout getTempTablePanel() {
        return tempTablePanel;
    }

    public void setRenderTableFlag(boolean renderTableFlag) {
        this.renderTableFlag = renderTableFlag;
    }

    public boolean isRenderTableFlag() {
        return renderTableFlag;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentDate1() {
        return currentDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public Date getCurDate() {
        return curDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDateDtr(String newDateDtr) {
        this.newDateDtr = newDateDtr;
    }

    public String getNewDateDtr() {
        return newDateDtr;
    }
    
 
    
}

//For Session retrieval 
//FacesContext facesContext = FacesContext.getCurrentInstance();
//     ExternalContext externalContext = facesContext.getExternalContext();


//     HttpSession httpSession = (HttpSession) externalContext.getSession(false);

//     String userName = httpSession.getAttribute("loggedinUserid").toString();

