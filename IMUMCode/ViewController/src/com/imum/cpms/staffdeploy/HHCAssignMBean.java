package com.imum.cpms.staffdeploy;


import com.imum.cpms.model.masters.vo.HHDeviceMstUVORowImpl;
import com.imum.cpms.model.staffdeploy.vo.GenLocationLOVVORowImpl;
import com.imum.cpms.model.staffdeploy.vo.HHCAssignVORowImpl;
import com.imum.cpms.model.staffdeploy.vo.HHCNewReRowImpl;

import com.imum.cpms.model.staffdeploy.vo.PIUserMstUVORowImpl;

import com.imum.cpms.staffdeployment.PileavemangementMB;

import com.imum.cpms.util.ADFUtils;

import java.util.Date;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.BindingContainer;

import javax.faces.event.ValueChangeEvent;

//import oracle.adf.model.BindingContext;
//import oracle.adf.model.binding.DCBindingContainer;

//import oracle.adf.model.BindingContext;
//
//import oracle.binding.BindingContainer;
//import oracle.binding.OperationBinding;
//
//
//import oracle.adf.model.binding.DCBindingContainer;
//
//import oracle.adf.model.binding.DCIteratorBinding;


import oracle.adf.share.ADFContext;
import com.imum.cpms.util.MessageUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import javax.el.ELContext;
import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;

import javax.servlet.http.HttpSession;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;
 


import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.jbotester.load.SimpleDateFormatter;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import utils.system;

public class HHCAssignMBean {
  
    private RichCommandButton cb2;
    private RichCommandButton cb1;
    private RichPanelFormLayout pfl2;
    private RichSelectItem si5;
    private RichSelectItem si6;
    private RichSelectItem si4;
    private RichSelectOneChoice shift;
    private RichInputText contractorName;
    private RichInputText piId;
    private RichInputText hhcId;
    private RichInputDate date;
    private RichPanelFormLayout pfl1;
    private RichPanelBox pb1;
    private RichInputText replacementHHC;
    private RichInputText Commentsenterd;
    private RichInputText hhcAssignId;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    String  userName = httpSession.getAttribute("loggedinUserid").toString();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    DCBindingContainer bindingsAM =
        (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    public static final ADFLogger logger = ADFLogger.createADFLogger(HHCAssignMBean.class);
    private RichInputText it1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichSelectOneRadio issueselectedradio;
    private String rootPath = "//cpmsshare";

    
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flagIssueDate = false;
    boolean flagReceiveDate = false;
    boolean flagcancel = false;
    private RichSelectOneChoice location;
  // private RichInputDate curentDate;


    private RichInputText commentsnew;
    private RichSelectOneChoice selectlocation;
    private Date currentDate = new Date();
    private RichPanelGroupLayout gridPanel;
    MessageUtil genMsg = new MessageUtil();
    private RichSelectOneChoice shiftId;
    
    private String shiftVal="";
    private String locVal = "";
    private RichColumn receiveddate;
    private RichColumn reAssignAction;
    private java.util.Date curDate = new java.util.Date();
    private RichTable hhcTable;
    private boolean submitClickedFlag = false;
    private String oldShiftVal = "1";
    private RichSelectItem issueSelectOneChoice;
    private RichSelectItem receiveSelectOneChoice;
    private RichInputText printerId;
    private RichSelectOneRadio hhcReceiveConditionbind;
    private RichSelectItem hhcReceiveConditionBind;
    private RichPanelGroupLayout hhcReceivePgBind;
    private RichPanelGroupLayout printerReceivePgBind;
    private RichInputText printerReceiveConditionBind;
    private RichSelectOneRadio printerReceivedConditionBind;
    private RichSelectItem defaultSelectforHHCBind;
    private RichSelectItem defaultSelectPrinterBind;
    private RichInputFile hhcInputFileBind;
    private RichInputFile printerInputFileBind;
   

    public HHCAssignMBean() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
    }


    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setSi5(RichSelectItem si5) {
        this.si5 = si5;
    }

    public RichSelectItem getSi5() {
        return si5;
    }

    public void setSi6(RichSelectItem si6) {
        this.si6 = si6;
    }

    public RichSelectItem getSi6() {
        return si6;
    }

    public void setSi4(RichSelectItem si4) {
        this.si4 = si4;
    }

    public RichSelectItem getSi4() {
        return si4;
    }

    public void setShift(RichSelectOneChoice soc1) {
        this.shift = soc1;
    }

    public RichSelectOneChoice getShift() {
        return shift;
    }

    public void setContractorName(RichInputText it1) {
        this.contractorName = it1;
    }

    public RichInputText getContractorName() {
        return contractorName;
    }

    public void setPiId(RichInputText it2) {
        this.piId = it2;
    }

    public RichInputText getPiId() {
        return piId;
    }

    public void setHhcId(RichInputText it3) {
        this.hhcId = it3;
    }

    public RichInputText getHhcId() {
        return hhcId;
    }

    public void setDate(RichInputDate id1) {
        this.date = id1;
    }

    public RichInputDate getDate() {
        return date;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }


    public String IssueHHC() {
        setSubmitClickedFlag(false);
        BindingContainer bindings = getBindings();
        logger.info("Start IssueHHC Method of HHCAssignMBean ");
        try {
            getCurrentDt();
            pageflowScope.put("tableWidth", "I");
            DCBindingContainer bindingContainer1 =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            if(issueselectedradio.getValue()!=null){
                if(issueselectedradio.getValue().equals("I")){
                    
                }
            }
            /* JUCtrlListBinding juc1 = (JUCtrlListBinding) bindingContainer1.getControlBinding("Shift");
            String shiftID = juc1.getSelectedValue().toString(); */
            JUCtrlListBinding juc2 = (JUCtrlListBinding) bindingContainer1.getControlBinding("GenLocationLOVVO1");
            String location1 = juc2.getSelectedValue().toString();
            ViewObjectImpl assignVO = (ViewObjectImpl)bindingContainer1.findIteratorBinding("HHCAssignVO1Iterator").getViewObject();
//            assignVO.setApplyViewCriteriaName("HHCAssignVOCriteria");
//            assignVO.setNamedWhereClauseParam("shift", shiftID);
//            assignVO.setNamedWhereClauseParam("location", location1);
//            java.sql.Date sqlDate2 = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
//            assignVO.setNamedWhereClauseParam("currentDate", sqlDate2);
           // assignVO.executeQuery();
            
            String pi_id = null;
            String piid=null;
            String stDate = null;
            String shift = null;
            String HhcId = null;
            String HHc_id=null;
            String PrinterId=null;
            String Printer_id=null;
            String location = null;
            int LocationId = 0;
            String shift1=null;
            String assignedstatuss = "Issued";
            String Commentsentered = null;
            
            if (getPiId().getValue() != null) {
                piid = this.getPiId().getValue().toString();
                pi_id=piid.toUpperCase();
                System.out.println("PI Id is:::"+pi_id);
                if (getHhcId().getValue() != null && !getHhcId().getValue().equals("") ) {
                    HHc_id = getHhcId().getValue().toString();
                    HhcId=HHc_id.toUpperCase();
                if(getPrinterId().getValue() !=null && !getPrinterId().getValue().equals("")){
                    Printer_id=getPrinterId().getValue().toString();
                    PrinterId=Printer_id.toUpperCase();
                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
                gridPanel.setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                
             /* JUCtrlListBinding listBinding1 =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("shiftlistVO1");
            String shift1 = listBinding1.getSelectedValue().toString();  */
                    
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
                        shiftVal=Integer.toString(shtval);
                        shift1=shiftVal;
                    }
                    }
                    else{
                        shift1=shiftVal;
                    }
            DCIteratorBinding locIter =bindingsAM.findIteratorBinding("GenLocationLOVVO1Iterator");
            ViewObjectImpl locationLOVVO = (ViewObjectImpl)locIter.getViewObject();
            if (locationLOVVO != null) {
            GenLocationLOVVORowImpl locrow = (GenLocationLOVVORowImpl)locationLOVVO.getCurrentRow();
            String locationid = locrow.getAttribute("locationid").toString();
                LocationId = Integer.parseInt(locationid);
            }
            if (getDate().getValue() != null)
                stDate = this.getDate().getValue().toString();
        
           
            java.sql.Date sqlDate = new java.sql.Date(getCurrentDate().getTime());
         
                java.util.Date dt = (java.util.Date)sqlDate;
           
            if (getSelectlocation().getValue() != null) {
                location = getSelectlocation().getValue().toString();
              
             
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("473",lgCode)));
//                FacesContext.getCurrentInstance().addMessage(null,
//                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                                                              "Sample info message",
//                                                                              "Please select Location  "));
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                gridPanel.setVisible(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                
            }
            
            if (getIt1().getValue() != null) {
                Commentsentered = getIt1().getValue().toString();
            } 

           // System.out.println("HhcId" + HhcId);
            if (pi_id == null){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("474",lgCode)));
                //IssueRefreshGrid();
                return null;
            }

            if (shift1 == null){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("475",lgCode)));
                //IssueRefreshGrid();
                return null;
                }
            if (HhcId == null){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("476",lgCode)));
                IssueRefreshGrid();
            return null;
            }
            if(PrinterId == null){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              "Please enter Printer ID"));
                IssueRefreshGrid();
                return null;
            }
            
           

            DCBindingContainer bindingContainer =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                BindingContainer bin = getBindings();
//           

            DCIteratorBinding HHCIter =
                bindingsAM.findIteratorBinding("HHCAssignVO1Iterator");
            ViewObjectImpl HHCAssignVO =
                (ViewObjectImpl)HHCIter.getViewObject();
            
               /*  DBTransaction con =HHCAssignVO.getDBTransaction();
                PreparedStatement pstmt = con.createPreparedStatement("select * from hhc_assignment",0);
                ResultSet rs = pstmt.executeQuery();
                int i = 0;
                while(rs.next()){
                    i++;
                }
                  System.out.println("i value :"+i);  
                String oldVal = i+"";
                System.out.println(oldVal);
                HHCAssignVO.setWhereClause(null);
                HHCAssignVO.reset();
                HHCAssignVO.executeQuery();
                String newVal = HHCAssignVO.getRowCount()+"";
                System.out.println(newVal); */
                Row shiftRow = HHCAssignVO.last();
           /*      if(!oldVal.equals(newVal) && !isSubmitClickedFlag() && !oldShiftVal.equals(shiftVal) && !shiftVal.equals(shiftRow.getAttribute("Shift").toString())){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message","Please submit the HHC's issued for shift-"+shiftRow.getAttribute("Shift").toString()));
                    receiveSelectOneChoice.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(receiveSelectOneChoice);
                    IssueRefreshGrid();
                    return null;
                } */
            
//                HHCAssignVO.reset();
//                ViewCriteria vc = HHCAssignVO.getViewCriteria("HHCAssignVOCriteria");
//                HHCAssignVO.removeApplyViewCriteriaName("HHCAssignVOCriteria");
//                HHCAssignVO.executeQuery();
            System.out.println(HHCAssignVO.getEstimatedRowCount());
            if (HHCAssignVO != null) {
//                HHCAssignVORowImpl PICreateRow =
//                    (HHCAssignVORowImpl)HHCAssignVO.getCurrentRow();
               // if (PICreateRow != null) {
                   
                   
                    OperationBinding opCheckPIShift =
                        (OperationBinding)bindingContainer.getOperationBinding("CheckPIShift");
                    opCheckPIShift.getParamsMap().put("checkPIID", pi_id);
                    opCheckPIShift.getParamsMap().put("shiftentered",
                                                      shift1);
                    Date datesend = new Date();
                    Date currentDate = new Date(System.currentTimeMillis());
                    java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
               // System.out.println(dt);
                    opCheckPIShift.getParamsMap().put("stDate", sqlDate1);
//                    SimpleDateFormatter sdf = new SimpleDateFormatter("dd-MM-yyyy") ;
//                    Date todayformat = new Date(sdf.format(todaydate).toString());
                  //  System.out.println("shiftentered" + shift1);
                  
                    String PIShiftvalidate = (String)opCheckPIShift.execute();
                    
                    if(PIShiftvalidate == "failurePIID")
                    {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                           
                                                                                                   "Sample info message",
                                                                                                        "PI is not assigned to work for the current shift"));
                     setFlag1(true);
                     IssueRefreshGrid();
                        return null;
                    }   
                    if (PIShiftvalidate == "failure") {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                   "Sample info message",
                                                                                                        "PI is not assigned to work for the current shift"));
                       
                                                                                //      genMsg.getMessage("377",lgCode)));
//                        FacesContext.getCurrentInstance().addMessage(null,
//                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                                                                      "Sample info message",
//                                                                                      "PI is not valid for this shift for the current date"));
                        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                        gridPanel.setVisible(false);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                        IssueRefreshGrid();
                        return null;
                    }
                    else{
                    String status = "Y";
                    String masterHHId=null;
                    OperationBinding opExec =
                        (OperationBinding)bindingContainer.getOperationBinding("CheckUnique");
                        opExec.getParamsMap().put("PrinterId", PrinterId);
                    opExec.getParamsMap().put("checkPIID", pi_id);
                    opExec.getParamsMap().put("stDate", sqlDate);
                opExec.getParamsMap().put("assignedstatuss", assignedstatuss);
                 opExec.getParamsMap().put("status", status);
                     opExec.getParamsMap().put("HhcId", HhcId);
                opExec.getParamsMap().put("Shift", shift1);
                    String resultforDup = (String)opExec.execute();
                   // System.out.println("result :"+resultforDup);
                    if(resultforDup!=null){
                    if (resultforDup.equals("failurePIID")) {
//                        FacesContext.getCurrentInstance().addMessage(null,
//                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                                      "Sample info message",
//                                                                                      genMsg.getMessage("378",lgCode)));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                         "Sample info message","Before assigning the new device, Please receive the device already issued for PI - "+pi_id+" "));
                         AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                        gridPanel.setVisible(false);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                        IssueRefreshGrid();
                        return null;
                    }
                    if(resultforDup.equals("failureHHCID")) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                             "Sample info message",
                                                                                                          "HHC Device is already Assigned "));
                        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                        gridPanel.setVisible(false);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                        IssueRefreshGrid();
                        return null;
                    }
                    if(resultforDup.equals("failurePrinterId")){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                             "Sample info message",
                                                                                                          "Printer is already Assigned "));
                        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                        gridPanel.setVisible(false);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                        IssueRefreshGrid();
                        return null;  
                    }
                    Boolean flag=true;
                    if(HhcId !=null && PrinterId !=null ){
                       
                        ViewObjectImpl HHDeviceVO = (ViewObjectImpl)bindingContainer1.findIteratorBinding("HHDeviceMstUVO1Iterator").getViewObject();
                        HHDeviceVO.setWhereClause("HH_SNo = '"+HhcId+"' and asset_type_code = 'H' ");
                        System.out.println("for Serial_No query is:"+HHDeviceVO.getQuery());
                        HHDeviceVO.executeQuery();
                        System.out.println("row count is:::"+HHDeviceVO.getRowCount());
                        Row hRow=HHDeviceVO.first();
                        if(hRow!=null){
                            String statusCode=hRow.getAttribute("StatusCode").toString();
                            masterHHId=hRow.getAttribute("HHId").toString();
                            if(statusCode.equalsIgnoreCase("A")){
                              hRow.setAttribute("StatusCode", "I"); 
                              hRow.setAttribute("LastIssueddate", sqlDate);
                              hRow.setAttribute("Assingedto", pi_id);
                              flag=true;
                            }
                            else if(statusCode.equalsIgnoreCase("I")){
                                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                     "Sample info message",
                                                                                                                  "Device is already Issued... "));
                                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                                gridPanel.setVisible(false);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                                IssueRefreshGrid();
                                System.out.println("Device is Issued...");
                                flag=false;
                                HHDeviceVO.executeQuery();
                                OperationBinding dorollback = bin.getOperationBinding("callRollback"); 
                                dorollback.execute();
                                return null;
                            }
                            else{
                                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                     "Sample info message",
                                                                                                                  "HHC Device is Damaged... "));
                                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                                gridPanel.setVisible(false);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                                IssueRefreshGrid();
                                System.out.println("HHC Device is Damaged");
                                flag=false;
                                HHDeviceVO.executeQuery();
                                OperationBinding dorollback = bin.getOperationBinding("callRollback"); 
                                 dorollback.execute();
                                return null;
                            }
                            
                        }
                        else{
                            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                 "Sample info message",
                                                                                                              "No Device is found with HHC_SNO:"+HhcId+"  "));
                            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                            gridPanel.setVisible(false);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                            IssueRefreshGrid();
                          System.out.println("no record available with HHC_SNO:"+HhcId+" and asset_type'H' "); 
                            flag=false;
                            OperationBinding dorollback = bin.getOperationBinding("callRollback"); 
                             dorollback.execute();
                            return null;
                        }
                        
                        HHDeviceVO.setWhereClause("HH_SNo = '"+PrinterId+"' and asset_type_code = 'P' ");
                        System.out.println("for printerId query is:::"+HHDeviceVO.getQuery());
                        HHDeviceVO.executeQuery();
                        Row pRow=HHDeviceVO.first();
                        if(pRow!=null){
                            String statusCode=pRow.getAttribute("StatusCode").toString();
                            if(statusCode.equalsIgnoreCase("A")){
                              pRow.setAttribute("StatusCode", "I"); 
                              pRow.setAttribute("LastIssueddate", sqlDate);
                              pRow.setAttribute("Assingedto", pi_id);
                              flag=true;
                            }
                            else if(statusCode.equalsIgnoreCase("I")){
                                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                     "Sample info message",
                                                                                                                  "Printer is already Issued... "));
                                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                                gridPanel.setVisible(false);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                                IssueRefreshGrid();
                               System.out.println("Printer is Issued...");
                               flag=false;
                               HHDeviceVO.executeQuery();
                                OperationBinding dorollback = bin.getOperationBinding("callRollback"); 
                                dorollback.execute();
                               return null;
                            }
                            else{
                                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                     "Sample info message",
                                                                                                                  "Printer is Damaged... "));
                                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                                gridPanel.setVisible(false);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                                IssueRefreshGrid();
                                System.out.println("Printer is Damaged");
                                flag=false;
                                HHDeviceVO.executeQuery();
                                OperationBinding dorollback = bin.getOperationBinding("callRollback"); 
                                 dorollback.execute();
                                return null;
                            }
                            
                        }
                        else{
                            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                 "Sample info message",
                                                                                                              "No Printer is found with printerID: "+PrinterId+"  "));
                            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                            gridPanel.setVisible(false);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                            IssueRefreshGrid();
                          System.out.println("no record available with printerID: "+PrinterId+" and asset_type 'P' "); 
                            flag=false;
                           OperationBinding dorollback = bin.getOperationBinding("callRollback"); 
                            dorollback.execute();
                            return null;
                        }
                        
                    }
                    
//                        else
//                        {
                        if(flag){
                                pageflowScope.put("Button","Issue");
                                OperationBinding opExecIssue = bin.getOperationBinding("createHHCAssignRow");
                                
                                 opExecIssue.getParamsMap().put("checkPIID", pi_id);
                                // System.out.println("pi_id"+pi_id);
                                
                                //   System.out.println("date time in "+todaydate);
                                 opExecIssue.getParamsMap().put("stDate",sqlDate);
                                //   System.out.println("currentDate"+currentDate);
                                 opExecIssue.getParamsMap().put("HHCID", HhcId);
                                 opExecIssue.getParamsMap().put("masterHHId", masterHHId);
                                 opExecIssue.getParamsMap().put("PrinterId", PrinterId);
                                 opExecIssue.getParamsMap().put("PriterIssuedStatusCode", "I");
                                 opExecIssue.getParamsMap().put("shift",shift1);
                                 opExecIssue.getParamsMap().put("location", LocationId);
                                 opExecIssue.getParamsMap().put("comments",
                                                                Commentsentered);
                                opExecIssue.execute();
                               
                                
//                                DCBindingContainer bindingContainer_N =
//                                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//                                if(shiftVal.length()==0){
//                                    ViewObjectImpl shiftlistVO = (ViewObjectImpl)bindingContainer_N.findIteratorBinding("shiftlistVO1Iterator").getViewObject();
//                                    Row row = shiftlistVO.getRowAtRangeIndex(0);
//                                    shiftVal = row.getAttribute("shiftId").toString();
//                                }
//                                if(locVal.length()==0){
//                                    ViewObjectImpl genLocationLOVVO = (ViewObjectImpl)bindingContainer_N.findIteratorBinding("GenLocationLOVVO1Iterator").getViewObject();
//                                    Row row = genLocationLOVVO.getRowAtRangeIndex(0);
//                                    locVal = row.getAttribute("locationid").toString();
//                                }
//                                
//                                java.sql.Date sqlDt = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
//                                       OperationBinding op =
//                                    (OperationBinding)bindingContainer.getOperationBinding("displayHHCdtls"); 
//                                       op.getParamsMap().put("shift", shiftVal);
//                                op.getParamsMap().put("location", locVal);
//                                op.getParamsMap().put("currentDate", sqlDt);
//                                op.execute();


                                Boolean b = HHCAssignVO.getApplicationModule().getTransaction().isDirty();
                                FacesMessage msg=null;
                                Boolean ev = false;
                                if(b!=ev){
                              
                                //    pageflowScope.put("VOStatus","VODirty");
                                    piId.setValue(null);
                                    hhcId.setValue(null);
                                    printerId.setValue(null);
                                    it1.setValue(null);
                                    SubmitHHC();
                                                                
                                }
                                else {
                                   
                                }
                              
                        }   
                           // }
                                 }
                            
//                        gridPanel.setVisible(false);
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
//                        submitButton.setVisible(false);
//                         AdfFacesContext.getCurrentInstance().addPartialTarget(submitButton);
                    
                    
                    
                   
                   
                    //int count = HHCAssignVO1.getRowCount();
              
                DCIteratorBinding HHCIter2 =
                bindingsAM.findIteratorBinding("HHCNewRe1Iterator");
                ViewObjectImpl hhcre1 =
                (ViewObjectImpl)HHCIter2.getViewObject();
                
                hhcre1.setWhereClause(null);
                hhcre1.setWhereClauseParams(null);
                
                hhcre1.setWhereClause("Assigned_Status = '"+assignedstatuss+"'");
                int count2 = hhcre1.getRowCount();
                hhcre1.executeQuery();
             
              


                        //                    if (resultforDup.equals("commit")) {
//                        FacesContext.getCurrentInstance().addMessage(null,
//                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                                      "Sample info message",
//                                                                                      "Assignment done "));
//                        getHhcId().setValue(null);
//                        getPiId().setValue(null);
//
//
//                    }
            }
                     
                    }
                }
                else{
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "Please enter Printer Id"));
                    //                FacesContext.getCurrentInstance().addMessage(null,
                    //                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    //                                                                              "Sample info message",
                    //                                                                              "Please enter Printer Id  "));
                         AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                    //gridPanel.setVisible(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);   
                }
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("476",lgCode)));
//                FacesContext.getCurrentInstance().addMessage(null,
//                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                                                              "Sample info message",
//                                                                              "Please enter HHC Id  "));
                     AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                //gridPanel.setVisible(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
            }
                }else{
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("474",lgCode)));
//                    FacesContext.getCurrentInstance().addMessage(null,
//                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                                                                  "Sample info message",
//                                                                                  "Please enter PI Id  "));
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
                   // gridPanel.setVisible(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                }
        } catch (Exception e) {
            e.printStackTrace();

        }
       
        
        logger.info("End IssueHHC Method of HHCAssignMBean ");
        return null;
        
    }
    
    public String onSetFocus(ActionEvent event) {
        RichCommandButton rcb = (RichCommandButton)event.getSource();
        String focusOn = (String)rcb.getAttributes().get("focusField");

        FacesContext fctx = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = fctx.getViewRoot();
        
        //search can be improved to include naming containers
        RichInputText rit = (RichInputText)piId;

        if (rit != null) {
            String clientId = rit.getClientId(fctx);
            
            StringBuilder script = new StringBuilder();
            //use client id to ensure component is found if located in
            //naming container            
            script.append("var textInput = ");
            script.append("AdfPage.PAGE.findComponentByAbsoluteId");
            script.append ("('"+clientId+"');");

            script.append("if(textInput != null){");            
            script.append("textInput.focus();");
            script.append("}");
            writeJavaScriptToClient(script.toString());
        }
        return null;
    }

    private void writeJavaScriptToClient(String script) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks = null;
        erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
        erks.addScript(fctx, script);
    }

    
    
    public String SubmitHHC() {
       
        BindingContainer bin = getBindings();
        
            String issueradiovalue = null;
            if (getIssueselectedradio().getValue() != null) {
                issueradiovalue = getIssueselectedradio().getValue().toString();
            }
                if("R".equals(issueradiovalue)){
                DCIteratorBinding HHCIter =
                    bindingsAM.findIteratorBinding("HHCAssignVO1Iterator");
                ViewObjectImpl HHCAssignVO =
                    (ViewObjectImpl)HHCIter.getViewObject();
                System.out.println(HHCAssignVO.getRowCount());
                if(HHCAssignVO.getRowCount()==1){
                    Row row = HHCAssignVO.getCurrentRow();
//                    System.out.println(row.getAttribute("RecievedDate"));
//                    System.out.println(row.getAttribute("RecievedDate").toString().length());
//                    if(row.getAttribute("RecievedDate")!=null){
//                    if(row.getAttribute("RecievedDate").toString().length()>0){
                        row.setAttribute("Status","N");
                        row.setAttribute("AssignedStatus","Received");
                        Date currentDate = new Date(System.currentTimeMillis());
                        java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
                        row.setAttribute("RecievedDate",sqlDate1);
//                    }
//                    }
                }else if(HHCAssignVO.getRowCount()>1){
                    RowSetIterator rs = HHCAssignVO.createRowSetIterator(null);
                    rs.reset();
                while(rs.hasNext()){
                    Row row = rs.next();
//                    System.out.println(row.getAttribute("RecievedDate"));
//                    System.out.println(row.getAttribute("RecievedDate").toString().length());
//                    if(row.getAttribute("RecievedDate")!=null){
//                    if(row.getAttribute("RecievedDate").toString().length()>0){
                        Date currentDate = new Date(System.currentTimeMillis());
                        java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
                        row.setAttribute("RecievedDate",sqlDate1);
                        row.setAttribute("Status","N");
                        row.setAttribute("AssignedStatus","Received");
//                    }
//                    }
                }
                }
                }
                OperationBinding opCommit = bin.getOperationBinding("doCommit");
            opCommit.execute();
        if(opCommit.getErrors().isEmpty())
            
        {
                receiveSelectOneChoice.setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(receiveSelectOneChoice);
                setSubmitClickedFlag(true);
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                                              "Sample info message",
//                                                                                              "HHC Assignment done Successfully "));
                if("R".equals(issueradiovalue)){
                DCIteratorBinding HHCIter =
                    bindingsAM.findIteratorBinding("HHCAssignVO1Iterator");
                ViewObjectImpl HHCAssignVO =
                    (ViewObjectImpl)HHCIter.getViewObject();
              /*   if(HHCAssignVO.getRowCount()==1){
                    Row row = HHCAssignVO.getCurrentRow();
                    System.out.println(row.getAttribute("RecievedDate"));
                    System.out.println(row.getAttribute("RecievedDate").toString().length());
                    if(row.getAttribute("RecievedDate")!=null){
                    if(row.getAttribute("RecievedDate").toString().length()>0){
                        HHCAssignVO.setCurrentRow(row);
                        HHCAssignVO.removeCurrentRow();
                    }
                    }
                }else if(HHCAssignVO.getRowCount()>1){
                    RowSetIterator rs = HHCAssignVO.createRowSetIterator(null);
                    rs.reset();
                    while(rs.hasNext()){
                    Row row = rs.next();
                    System.out.println(row.getAttribute("RecievedDate"));
                    System.out.println(row.getAttribute("RecievedDate").toString().length());
                    if(row.getAttribute("RecievedDate")!=null){
                    if(row.getAttribute("RecievedDate").toString().length()>0){
                        HHCAssignVO.setCurrentRow(row);
                        HHCAssignVO.removeCurrentRow();
                    }
                    }
                }
                } */
                    this.hhcReceiveConditionbind.setValue("G");
                    this.printerReceivedConditionBind.setValue("G");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(printerReceivedConditionBind);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(hhcReceiveConditionbind);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                  "Sample info message",
                                                                                                                "HHC Receive done Successfully "));
                }
                if("I".equals(issueradiovalue)){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                                                  "Sample info message",
                                                                                                                "HHC Assignment done Successfully "));
                }
          
                AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
                AdfFacesContext.getCurrentInstance().addPartialTarget(hhcTable);
            }
     
            pageflowScope.put("VOStatus","notdirty");
          piId.setValue(null);
          hhcId.setValue(null);
          it1.setValue(null);
        printerId.setValue(null);
        
        return null;
    }

    public String ReceiveHHC() {
    
        logger.info("Start ReceiveHHC Method of HHCAssignMBean ");
        setSubmitClickedFlag(false);
        String shiftID=null;
        BindingContainer bindings = getBindings();
        getCurrentDt();
        ADFContext adfctx = ADFContext.getCurrent();
        String loginuser=adfctx.getSessionScope().get("loggedinUserid").toString();
        System.out.println("Logged in User is:"+loginuser);
        pageflowScope.put("tableWidth", "R");
        DCBindingContainer bindingContainer1 =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          /* JUCtrlListBinding juc1 = (JUCtrlListBinding) bindingContainer1.getControlBinding("shiftlistVO1");
        String shiftID = juc1.getSelectedValue().toString();  */
        
        JUCtrlListBinding juc2 = (JUCtrlListBinding) bindingContainer1.getControlBinding("GenLocationLOVVO1");
        String location1 = juc2.getSelectedValue().toString();
        ViewObjectImpl assignVO = (ViewObjectImpl)bindingContainer1.findIteratorBinding("HHCAssignVO1Iterator").getViewObject();
        assignVO.setApplyViewCriteriaName("HHCAssignVOCriteria");
        assignVO.setNamedWhereClauseParam("shift", shiftID);
        assignVO.setNamedWhereClauseParam("location", location1);
        java.sql.Date sqlDate1 = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
        assignVO.setNamedWhereClauseParam("currentDate", sqlDate1);
        //assignVO.executeQuery();
        try {
            String pi_id = null;
            String piid=null;
            String stDate = null;
            String shift = null;
            String printerReceiveCondition;
            String hhcReceivedCondition;
            String HhcId = null;
            String Hhc_id=null;
            String PrinterId=null;
            String printer_id=null;
            int LocationId = 0;
            String shift1=null;
            /* JUCtrlListBinding listBinding1 =
                (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("shiftlistVO1");
            String shift1 = listBinding1.getSelectedValue().toString(); */
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
                shiftVal=Integer.toString(shtval);
                shift1=shiftVal;
            }
            }
            else{
                shift1=shiftVal;  
            }
            
            
            DCIteratorBinding locIter =
            bindingsAM.findIteratorBinding("GenLocationLOVVO1Iterator");
            ViewObjectImpl locationLOVVO =
            (ViewObjectImpl)locIter.getViewObject();
            if (locationLOVVO != null) {
            GenLocationLOVVORowImpl locrow = (GenLocationLOVVORowImpl)locationLOVVO.getCurrentRow();
            String locationid = locrow.getAttribute("locationid").toString();
            LocationId = Integer.parseInt(locationid);
            }
            

            if (getPiId().getValue() != null) {
                piid = this.getPiId().getValue().toString();
                pi_id=piid.toUpperCase();
   //Adde Chandu             
                if (getHhcId().getValue() != null && !getHhcId().getValue().equals("")) {
                    Hhc_id = getHhcId().getValue().toString();
                    HhcId=Hhc_id.toUpperCase();
                    if(getPrinterId().getValue() !=null && !getPrinterId().getValue().equals("")){
                    printer_id=getPrinterId().getValue().toString();
                    PrinterId=printer_id.toUpperCase();
                    
                    // Start ***********
                    DCBindingContainer bindingContainer = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();


                    
                    java.sql.Date sqlDate = new java.sql.Date(getCurrentDate().getTime());
                    
                    //            if (HHCAssignVO != null) {
                    //
                    //                HHCAssignVORowImpl HHCAssignRow =
                    //                    (HHCAssignVORowImpl)HHCAssignVO.first();
                    //                if (HHCAssignRow != null) {
                    //                    String checkPIID = HHCAssignRow.getPIID();
                         
                            OperationBinding checkHHCValid =
                                (OperationBinding)bindingContainer.getOperationBinding("checkHHCValid");
                            checkHHCValid.getParamsMap().put("checkPIID", pi_id);
                            checkHHCValid.getParamsMap().put("stDate", sqlDate);
                               checkHHCValid.getParamsMap().put("HhcId", HhcId);
                               checkHHCValid.getParamsMap().put("PrinterId", PrinterId);
                            String HHCIdfromDB = (String)checkHHCValid.execute();
                            if (HHCIdfromDB.equals("HHCfailure")) {
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("479",lgCode)));
                    //                        FacesContext.getCurrentInstance().addMessage(null,
                    //                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    //                                                                                      "Sample info message",
                    //        ReceiveRefreshGrid();                                                               // "HHC Id does not match with the Assigned HHC ID"));
                                return null;
                            }
                    if (HHCIdfromDB.equals("Printerfailure")) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                     "Printer Id does not match with the Assigned PrinterId"));
                    //                        FacesContext.getCurrentInstance().addMessage(null,
                    //                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    //                                                                                      "Sample info message",
                    //        ReceiveRefreshGrid();                                                               // "HHC Id does not match with the Assigned HHC ID"));
                        return null;
                    }
                    
                    if (HHCIdfromDB.equals("failure")) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                     "The HHC:'"+HhcId+"' and Printer Id:'"+PrinterId+"'is not Issued..."));
                    //                        FacesContext.getCurrentInstance().addMessage(null,
                    //                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    //                                                                                      "Sample info message",
                    //        ReceiveRefreshGrid();                                                               // "HHC Id does not match with the Assigned HHC ID"));
                        return null;
                    }        
                    //
                    if(getPrinterReceivedConditionBind().getValue()!=null){
                    printerReceiveCondition=getPrinterReceivedConditionBind().getValue().toString();
                    }
                    else {
                        System.out.println("please check condition for printer");
                        return null;
                    }
                    if(getHhcReceiveConditionbind().getValue()!=null){
                     hhcReceivedCondition= hhcReceiveConditionbind.getValue().toString();
                    }
                    else{
                        System.out.println("please check condition  for HHC");
                        return null;  
                    }
                                DCIteratorBinding HHCIter =
                        bindingsAM.findIteratorBinding("HHCAssignVO1Iterator");
                    ViewObjectImpl HHCAssignVO =
                        (ViewObjectImpl)HHCIter.getViewObject();
                    HHCAssignVO.reset();
                    ViewCriteria vc = HHCAssignVO.getViewCriteria("HHCAssignVOCriteria");
                    HHCAssignVO.removeApplyViewCriteriaName("HHCAssignVOCriteria");
                    HHCAssignVO.executeQuery();
                    System.out.println(HHCAssignVO.getEstimatedRowCount());
                    DCIteratorBinding HHCMstIter =
                    bindingsAM.findIteratorBinding("HHDeviceMstUVO1Iterator");
                    ViewObjectImpl HHCMstVO =
                    (ViewObjectImpl)HHCMstIter.getViewObject();
                    HHCMstVO.reset();
                    String status = "Y";
                    String Assigned_status = "Issued";
                    String Assigned_status2 = "Received";
                    HHCAssignVO.setWhereClause("PI_ID = '"+pi_id+"' and HH_SNo = '"+HhcId+"' and Status = '"+status+"' and Assigned_Status = '"+Assigned_status+"' and Printer_SNo='"+PrinterId+"' ");
                    System.out.println("Check the HH_SNo and PI_ID and Printer_SNo available in HHC_Assgn Query is:"+HHCAssignVO.getQuery());
                    HHCAssignVO.executeQuery();
                    int count = HHCAssignVO.getRowCount();
                    if (HHCAssignVO != null) {
                    
                                    HHCAssignVORowImpl HHCAssignRow =
                                        (HHCAssignVORowImpl)HHCAssignVO.getCurrentRow();
                                    if (HHCAssignRow != null) {
                            HHCAssignRow.setStatus("N");
                            HHCAssignRow.setAssignedStatus("Received");
                            Timestamp timeDate = new java.sql.Timestamp(new java.util.Date().getTime());
                            HHCAssignRow.setRecievedDate(timeDate);
                            HHCAssignRow.setPrinterIssuedstatusCode("R");
                            if(printerReceiveCondition.equalsIgnoreCase("G")){
                            HHCAssignRow.setPrinterReturnCondition(1);
                            }
                            else{
                                HHCAssignRow.setPrinterReturnCondition(2);  
                            }
                            HHCAssignRow.setPrinterReceivedDate(timeDate);
                            HHCAssignRow.setupdatedby(loginuser);
                            HHCAssignRow.setUpdateddate(timeDate);
                            if(hhcReceivedCondition.equalsIgnoreCase("G")){
                            HHCAssignRow.setHHCReturnCondition(1);}
                            else{
                                HHCAssignRow.setHHCReturnCondition(2);   
                            }
                            if(HHCMstVO!=null){
                            HHCMstVO.setWhereClause("HH_SNo = '"+HhcId+"' and asset_type_code = 'H'");
                            System.out.println("updating statuscode for H in hhd_mst query:"+HHCMstVO.getQuery());
                            HHCMstVO.executeQuery();
                           Row hhcmstrow= HHCMstVO.first();
                           if(hhcmstrow!=null){
                               hhcmstrow.setAttribute("UpdatedDate", timeDate);
                               hhcmstrow.setAttribute("UpdatedBy", loginuser);
                               if(hhcReceivedCondition.equalsIgnoreCase("G")){
                               hhcmstrow.setAttribute("StatusCode","A" );}
                               else{
                                   hhcmstrow.setAttribute("StatusCode","D" ); 
                               }
                             }
                           HHCMstVO.setWhereClause(null);
                           HHCMstVO.executeQuery();
                           
                            HHCMstVO.setWhereClause("HH_SNo = '"+PrinterId+"' and asset_type_code = 'P'");
                            System.out.println("updating statuscode for P in hhd_mst query:"+HHCMstVO.getQuery());
                            HHCMstVO.executeQuery();
                            Row hhcmstrow1= HHCMstVO.first();
                            if(hhcmstrow1!=null){
                                hhcmstrow1.setAttribute("UpdatedDate", timeDate);
                                hhcmstrow1.setAttribute("UpdatedBy", loginuser);
                                if(printerReceiveCondition.equalsIgnoreCase("G")){
                                hhcmstrow1.setAttribute("StatusCode","A" );}
                                else{
                                    hhcmstrow1.setAttribute("StatusCode","D" ); 
                                }
                            }
                            
                                    }
                            piId.setValue(null);
                            hhcId.setValue(null);
                            it1.setValue(null);
                            printerId.setValue(null);
                            hhcInputFileBind.setVisible(false);
                           
                            printerInputFileBind.setVisible(false);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(printerInputFileBind);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(hhcInputFileBind);
                          
                            
                            

                    //                    DCBindingContainer bindingContainer_N =
                    //                        (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                    //                    if(shiftVal.length()==0){
                    //                        ViewObjectImpl shiftlistVO = (ViewObjectImpl)bindingContainer_N.findIteratorBinding("shiftlistVO1Iterator").getViewObject();
                    //                        Row row = shiftlistVO.getRowAtRangeIndex(0);
                    //                        shiftVal = row.getAttribute("shiftId").toString();
                    //                    }
                    //                    if(locVal.length()==0){
                    //                        ViewObjectImpl genLocationLOVVO = (ViewObjectImpl)bindingContainer_N.findIteratorBinding("GenLocationLOVVO1Iterator").getViewObject();
                    //                        Row row = genLocationLOVVO.getRowAtRangeIndex(0);
                    //                        locVal = row.getAttribute("locationid").toString();
                    //                    }
                    //
                    //                    java.sql.Date sqlDt = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
                    //                           OperationBinding op =
                    //                        (OperationBinding)bindingContainer.getOperationBinding("displayHHCdtls");
                    //                           op.getParamsMap().put("shift", shiftVal);
                    //                    op.getParamsMap().put("location", locVal);
                    //                    op.getParamsMap().put("currentDate", sqlDt);
                    //                    op.execute();
                            
                            Boolean b = HHCAssignVO.getApplicationModule().getTransaction().isDirty();
                            FacesMessage msg=null;
                            Boolean ev = false;
                            if(b!=ev){
                                SubmitHHC();
                                ReceiveRefreshGrid();
                                piId.setValue(null);
                                hhcId.setValue(null);
                                it1.setValue(null);
                                printerId.setValue(null);
                                hhcInputFileBind.setVisible(false);
                               
                                printerInputFileBind.setVisible(false);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(printerInputFileBind);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(hhcInputFileBind);
                               
                      //      pageflowScope.put("VOStatus","VODirty");
                            return null;
                            }
                            else {
                               
                            }
                    


                        } else {

                        }
                        logger.info("End ReceiveHHC Method of HHCAssignMBean ");
                    }
                    //End **************
                }
                    else{
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      "Sample info message",
                                                                                      "Please enter Printer Id"));
                        return null;
                    }
                }
                else{
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("476",lgCode)));
                  //  ReceiveRefreshGrid();
                    return null;
                }
                
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("474",lgCode)));
               // ReceiveRefreshGrid();
                return null;
            }
            //End Chandu
// 
//            if (HhcId == null){
//                FacesContext.getCurrentInstance().addMessage(null,
//                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                              "Sample info message",
//                                                                              genMsg.getMessage("476",lgCode)));
//                ReceiveRefreshGrid();
//            return null;
//            }
       
        
        

        } catch (Exception e) {
            e.printStackTrace();

        }
       
        return null;
       
    }


    public String cb1_action2() {
        logger.info("Start cb1_action2 Method of HHCAssignMBean ");
        String pi_id = this.getPiId().getValue().toString();
        String stDate = this.getDate().getValue().toString();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        //System.out.println(pi_id + "----------" + stDate);

        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding op =
            (OperationBinding)bindingContainer.getOperationBinding("validatePIID");
        op.getParamsMap().put("date", stDate);
        op.getParamsMap().put("PIID", pi_id);
        String result = (String)op.execute();
     //   FacesMessage fm = new FacesMessage("PI is Not Valid for This Shift");
        if (result == "Success") {
           // System.out.println("After Successfull ViewObject");
            // fm = new FacesMessage("PI is Assigned Success");
            BindingContainer bindingsxec = getBindings();
            DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("HHCNewRe1Iterator");
            ViewObjectImpl HHCVo = (ViewObjectImpl)dcItterator.getViewObject();

            HHCNewReRowImpl HHcRow = (HHCNewReRowImpl)HHCVo.getCurrentRow();
            String HHCId = (String)HHcRow.getAttribute("HHCID");
            //this.setHhcAssignId(  (RichInputText)HHcRow.getAttribute("HHCID"));
            this.getHhcAssignId().setValue(HHCId);


        }
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      "Sample info message",
                                                                      genMsg.getMessage("481",lgCode)));
//        fm.setSeverity(FacesMessage.SEVERITY_INFO);
//        FacesContext fctx = FacesContext.getCurrentInstance();
//        fctx.addMessage(null, fm);
         logger.info("End cb1_action2 Method of HHCAssignMBean ");
        return null;
    }

    public void setReplacementHHC(RichInputText replacementHHC) {
        this.replacementHHC = replacementHHC;
    }

    public RichInputText getReplacementHHC() {
        return replacementHHC;
    }

    public String cb2_action() {
        logger.info("Start cb2_action Method of HHCAssignMBean ");
        String pi_id = this.getPiId().getValue().toString();
        String stDate = this.getDate().getValue().toString();
        // Add event code here...
        logger.info("End cb2_action Method of HHCAssignMBean ");
        return null;
    }

    public String HHCAssignSave() {
        logger.info("Start HHCAssignSave Method of HHCAssignMBean ");
        String pi_id = this.getPiId().getValue().toString();
        String stDate = this.getDate().getValue().toString();


        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
//        System.out.println("replacementHHC.getValue()--" +
//                           replacementHHC.getValue());
        String ReplacementId = getReplacementHHC().getValue().toString();

        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding OPHHCReplace =
            (OperationBinding)bindingContainer.getOperationBinding("ReplacementHHC");
        OPHHCReplace.getParamsMap().put("PIID", pi_id);
        OPHHCReplace.getParamsMap().put("stDate", sqlDate);
        OPHHCReplace.getParamsMap().put("ReplacementId", ReplacementId);
        OPHHCReplace.getParamsMap().put("comments",
                                        getIt1().getValue().toString());
        OPHHCReplace.execute();


        BindingContainer bindingsxec = getBindings();

        OperationBinding OPHHC =
            (OperationBinding)bindingContainer.getOperationBinding("doCommit");

        OPHHC.execute();
        if (!OPHHC.getErrors().isEmpty()) {
            return null;
        }
        logger.info("End HHCAssignSave Method of HHCAssignMBean ");
        return null;
    }


    public void setHhcAssignId(RichInputText hhcAssignId) {
        this.hhcAssignId = hhcAssignId;
    }

    public RichInputText getHhcAssignId() {
        return hhcAssignId;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public String add() {
        // Add event code here...
        logger.info("Start add Method of HHCAssignMBean ");
        String pi_id = this.getPiId().getValue().toString();
        String HhcId = getHhcId().getValue().toString();
        Date d1 = (Date)getDate().getValue();
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding op =
            (OperationBinding)bindingContainer.getOperationBinding("insertToHHCGrid");
        //       System.out.println( + "test");
        //        System.out.println( + "test");
        op.getParamsMap().put("Pi_id", pi_id);
        op.getParamsMap().put("hhc_id", HhcId);
        op.getParamsMap().put("issueDate", d1);
        op.getParamsMap().put("Rece", "2014-10-05");

        op.execute();

        logger.info("End add Method of HHCAssignMBean ");
        return null;
    }


    public String IssueReceive(ValueChangeEvent valueChangeEvent) {
        logger.info("Start IssueReceive Method of HHCAssignMBean ");
        setSubmitClickedFlag(false);
         String issueradiovalue = null;
         int count = issueselectedradio.getChildCount();
        
         System.out.println("Radcou"+count);
        issueselectedradio.getChildCount();
       
        String AssignedStatus = null;
        String status = "Y";
      
        getCurrentDt();
        
      
     
        
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
       /*  if(shiftVal.length()==0){
            ViewObjectImpl shiftlistVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("shiftlistVO1Iterator").getViewObject();
            Row row = shiftlistVO.getRowAtRangeIndex(0);
            shiftVal = row.getAttribute("shiftId").toString();
        } */
/*        if(shiftVal.length()==0){
           ViewObjectImpl shiftvo = (ViewObjectImpl)bindingContainer.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
           Row row = shiftvo.getRowAtRangeIndex(0);
           shiftVal = row.getAttribute("pishiftid").toString();
       } */
       
        if(shiftVal.length()==0){
        String shift=(String)ADFUtils.evaluateEL("#{bindings.GenpiShiftMstVO1.attributeValue}");
        System.out.println("Shiftname is:::"+shift);
        if(shift!=null){
            DCBindingContainer bindingContainer1 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            ViewObject shiftVO = (ViewObject)bindingContainer1.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
            shiftVO.setWhereClause("pi_shift_desc='"+shift+"'");
            System.out.println("shift query is:::"+shiftVO.getQuery());
            shiftVO.executeQuery();
            Row row=shiftVO.first();
            Integer shtval=Integer.parseInt(row.getAttribute("pishiftid").toString());
            shiftVal=Integer.toString(shtval);
        }
        }
        
        if(locVal.length()==0){
            ViewObjectImpl genLocationLOVVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("GenLocationLOVVO1Iterator").getViewObject();
            Row row = genLocationLOVVO.getRowAtRangeIndex(0);
            locVal = row.getAttribute("locationid").toString();
        }
        
//        ViewObjectImpl assignVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("HHCAssignVO1Iterator").getViewObject();
//        assignVO.setApplyViewCriteriaName("HHCAssignVOCriteria");
//        assignVO.setNamedWhereClauseParam("shift", shiftVal);
//        assignVO.setNamedWhereClauseParam("location", locVal);
//        java.sql.Date sqlDate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
//        System.out.println(sqlDate);
//        assignVO.setNamedWhereClauseParam("currentDate", sqlDate);
//        assignVO.executeQuery();
                   java.sql.Date sqlDate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());  
                    OperationBinding op =
                 (OperationBinding)bindingContainer.getOperationBinding("displayHHCdtls"); 
                    op.getParamsMap().put("shift", shiftVal);
             op.getParamsMap().put("location", locVal);
             op.getParamsMap().put("currentDate", sqlDate);
             op.execute();
        
        if (getIssueselectedradio().getValue() != null) {
            issueradiovalue = getIssueselectedradio().getValue().toString();
        }

      //  System.out.println(issueradiovalue);
        if ("I".equals(issueradiovalue)) {
            
            pageflowScope.put("Status","Issue");
            pageflowScope.put("tableWidth", "I");
            receiveddate.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiveddate);
//            reAssignAction.setVisible(false);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(reAssignAction);
             AssignedStatus = "Received";
            setFlag1(true);
            setFlagIssueDate(true);
            setFlagcancel(true);
            setFlag2(false);
            setFlagReceiveDate(false);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
            gridPanel.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
            hhcReceiveConditionbind.setVisible(false);
            printerReceivedConditionBind.setVisible(false);
            hhcInputFileBind.setVisible(false);
          
            printerInputFileBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(printerInputFileBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(printerReceivedConditionBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(hhcReceiveConditionbind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(hhcInputFileBind);
          
        } 
        else if ("R".equals(issueradiovalue)) {
           
            pageflowScope.put("Status","Issue");
            pageflowScope.put("ReAssign","Issue");
            pageflowScope.put("tableWidth", "R");
            receiveddate.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiveddate);
//            reAssignAction.setVisible(true);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(reAssignAction);
            AssignedStatus = "Issued";
            setFlag2(true);
            setFlagReceiveDate(true);
            setFlag1(false);
            setFlagIssueDate(false);
            setFlagcancel(true);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
            gridPanel.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
            hhcReceiveConditionbind.setVisible(true);
            printerReceivedConditionBind.setVisible(true);
            this.hhcReceiveConditionbind.setValue("G");
            this.printerReceivedConditionBind.setValue("G");
           AdfFacesContext.getCurrentInstance().addPartialTarget(printerReceivedConditionBind);
           AdfFacesContext.getCurrentInstance().addPartialTarget(hhcReceiveConditionbind);
          
        }
        
        else {
          //  setFlag1(false);
            setFlagIssueDate(false);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
            gridPanel.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
         //   setFlag2(false);
            setFlagReceiveDate(false);
        }
        //   pageflowScope.put("Radio","Issue");
//        if ("R".equals(issueradiovalue)) {
//            pageflowScope.put("Status","Issue");
//         AssignedStatus = "Issued";
//            setFlag2(true);
//            setFlagReceiveDate(true);
//            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
//            gridPanel.setVisible(true);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
//          
//        }
//        //   pageflowScope.put("Radio","Receive");
//        else {
//            setFlag2(false);
//            setFlagReceiveDate(false);
//            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
//            gridPanel.setVisible(false);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
//        }

        logger.info("End IssueReceive Method of HHCAssignMBean ");
        return null;
    }
    public void ReceiveRefreshGrid(){
        setSubmitClickedFlag(false);
         String issueradiovalue = null;
         int count = issueselectedradio.getChildCount();
        
         System.out.println("Radcou"+count);
        issueselectedradio.getChildCount();
        
        String AssignedStatus = null;
        String status = "Y";
        
        getCurrentDt();
        
        
        
        
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        /*  if(shiftVal.length()==0){
            ViewObjectImpl shiftlistVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("shiftlistVO1Iterator").getViewObject();
            Row row = shiftlistVO.getRowAtRangeIndex(0);
            shiftVal = row.getAttribute("shiftId").toString();
        }  */
        if(shiftVal.length()==0){
        String shift=(String)ADFUtils.evaluateEL("#{bindings.GenpiShiftMstVO1.attributeValue}");
        System.out.println("Shiftname is:::"+shift);
        if(shift!=null){
            ViewObject shiftVO = (ViewObject)bindingContainer.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
            shiftVO.setWhereClause("pi_shift_desc='"+shift+"'");
            System.out.println("shift query is:::"+shiftVO.getQuery());
            shiftVO.executeQuery();
            Row row=shiftVO.first();
            Integer shtval=Integer.parseInt(row.getAttribute("pishiftid").toString());
            shiftVal=Integer.toString(shtval);
            
        }
        }
        if(locVal.length()==0){
            ViewObjectImpl genLocationLOVVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("GenLocationLOVVO1Iterator").getViewObject();
            Row row = genLocationLOVVO.getRowAtRangeIndex(0);
            locVal = row.getAttribute("locationid").toString();
        }
        
        //        ViewObjectImpl assignVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("HHCAssignVO1Iterator").getViewObject();
        //        assignVO.setApplyViewCriteriaName("HHCAssignVOCriteria");
        //        assignVO.setNamedWhereClauseParam("shift", shiftVal);
        //        assignVO.setNamedWhereClauseParam("location", locVal);
        //        java.sql.Date sqlDate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());
        //        System.out.println(sqlDate);
        //        assignVO.setNamedWhereClauseParam("currentDate", sqlDate);
        //        assignVO.executeQuery();
                   java.sql.Date sqlDate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());  
                    OperationBinding op =
                 (OperationBinding)bindingContainer.getOperationBinding("displayHHCdtls"); 
                    op.getParamsMap().put("shift", shiftVal);
             op.getParamsMap().put("location", locVal);
             op.getParamsMap().put("currentDate", sqlDate);
             op.execute();
        
       
            issueradiovalue = "R";
        

        //  System.out.println(issueradiovalue);
        if ("I".equals(issueradiovalue)) {
            
            pageflowScope.put("Status","Issue");
            pageflowScope.put("tableWidth", "I");
            receiveddate.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiveddate);
//            reAssignAction.setVisible(false);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(reAssignAction);
             AssignedStatus = "Received";
            setFlag1(true);
            setFlagIssueDate(true);
            setFlagcancel(true);
            setFlag2(false);
            setFlagReceiveDate(false);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
            gridPanel.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
         
        } 
        else if ("R".equals(issueradiovalue)) {
           
            pageflowScope.put("Status","Issue");
            pageflowScope.put("ReAssign","Issue");
            pageflowScope.put("tableWidth", "R");
            receiveddate.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiveddate);
//            reAssignAction.setVisible(true);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(reAssignAction);
         AssignedStatus = "Issued";
            setFlag2(true);
            setFlagReceiveDate(true);
            setFlag1(false);
            setFlagIssueDate(false);
            setFlagcancel(true);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
            gridPanel.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
          
        }
        
        else {
          //  setFlag1(false);
            setFlagIssueDate(false);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
            gridPanel.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
         //   setFlag2(false);
            setFlagReceiveDate(false);
        }
        

        logger.info("End IssueReceive Method of HHCAssignMBean ");
        
        
        
    }

    public void IssueRefreshGrid(){
        setSubmitClickedFlag(false);
         String issueradiovalue = null;
         int count = issueselectedradio.getChildCount();
        
         System.out.println("Radcou"+count);
        issueselectedradio.getChildCount();
        
        String AssignedStatus = null;
        String status = "Y";
        
        getCurrentDt();
        
        
        
        
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        /* if(shiftVal.length()==0){
            ViewObjectImpl shiftlistVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("shiftlistVO1Iterator").getViewObject();
            Row row = shiftlistVO.getRowAtRangeIndex(0);
            shiftVal = row.getAttribute("shiftId").toString();
        } */
        if(shiftVal.length()==0){
        String shift=(String)ADFUtils.evaluateEL("#{bindings.GenpiShiftMstVO1.attributeValue}");
        System.out.println("Shiftname is:::"+shift);
        if(shift!=null){
            ViewObject shiftVO = (ViewObject)bindingContainer.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
            shiftVO.setWhereClause("pi_shift_desc='"+shift+"'");
            System.out.println("shift query is:::"+shiftVO.getQuery());
            shiftVO.executeQuery();
            Row row=shiftVO.first();
            Integer shtval=Integer.parseInt(row.getAttribute("pishiftid").toString());
            shiftVal=Integer.toString(shtval);
           
        }
        }
   
        if(locVal.length()==0){
            ViewObjectImpl genLocationLOVVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("GenLocationLOVVO1Iterator").getViewObject();
            Row row = genLocationLOVVO.getRowAtRangeIndex(0);
            locVal = row.getAttribute("locationid").toString();
        }
        
        
                   java.sql.Date sqlDate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());  
                    OperationBinding op =
                 (OperationBinding)bindingContainer.getOperationBinding("displayHHCdtls"); 
                    op.getParamsMap().put("shift", shiftVal);
             op.getParamsMap().put("location", locVal);
             op.getParamsMap().put("currentDate", sqlDate);
             op.execute();
        
       
            issueradiovalue = "I";
        

        //  System.out.println(issueradiovalue);
        if ("I".equals(issueradiovalue)) {
            
            pageflowScope.put("Status","Issue");
            pageflowScope.put("tableWidth", "I");
            receiveddate.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiveddate);
//            reAssignAction.setVisible(false);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(reAssignAction);
             AssignedStatus = "Received";
            setFlag1(true);
            setFlagIssueDate(true);
            setFlagcancel(true);
            setFlag2(false);
            setFlagReceiveDate(false);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
            gridPanel.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
         
        } 
        else if ("R".equals(issueradiovalue)) {
           
            pageflowScope.put("Status","Issue");
            pageflowScope.put("ReAssign","Issue");
            pageflowScope.put("tableWidth", "R");
            receiveddate.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiveddate);
//            reAssignAction.setVisible(true);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(reAssignAction);
         AssignedStatus = "Issued";
            setFlag2(true);
            setFlagReceiveDate(true);
            setFlag1(false);
            setFlagIssueDate(false);
            setFlagcancel(true);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
            gridPanel.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
          
        }
        
        else {
          //  setFlag1(false);
            setFlagIssueDate(false);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
            gridPanel.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
         //   setFlag2(false);
            setFlagReceiveDate(false);
        }
        

        logger.info("End IssueReceive Method of HHCAssignMBean ");
        
        
        
    }


    public void setIssueselectedradio(RichSelectOneRadio issueselectedradio) {
        this.issueselectedradio = issueselectedradio;
    }

    public RichSelectOneRadio getIssueselectedradio() {
        return issueselectedradio;
    }


    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }

    public boolean isFlag1() {
        return flag1;
    }

    public void setFlag2(boolean flag2) {
        this.flag2 = flag2;
    }

    public boolean isFlag2() {
        return flag2;
    }

    public void setFlagIssueDate(boolean flagIssueDate) {
        this.flagIssueDate = flagIssueDate;
    }

    public boolean isFlagIssueDate() {
        return flagIssueDate;
    }

    public void setFlagReceiveDate(boolean flagReceiveDate) {
        this.flagReceiveDate = flagReceiveDate;
    }

    public boolean isFlagReceiveDate() {
        return flagReceiveDate;
    }

    public void setLocation(RichSelectOneChoice location) {
        this.location = location;
    }

    public RichSelectOneChoice getLocation() {
        return location;
    }


    public void setCommentsenterd(RichInputText Commentsenterd) {
        this.Commentsenterd = Commentsenterd;
    }

    public RichInputText getCommentsenterd() {
        return Commentsenterd;
    }

    public void setCommentsnew(RichInputText commentsnew) {
        this.commentsnew = commentsnew;
    }

    public RichInputText getCommentsnew() {
        return commentsnew;
    }

    public void setSelectlocation(RichSelectOneChoice selectlocation) {
        this.selectlocation = selectlocation;
    }

    public RichSelectOneChoice getSelectlocation() {
        return selectlocation;
    }


    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void ReAssignAction(ActionEvent actionEvent) { 
        // Add event code here...
     
        Row row = (Row)ADFUtil.evaluateEL("#{bindings.HHCAssignVO1Iterator.currentRow}"); 
       if( row.getAttribute("PIID") != null)
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("PIID",  row.getAttribute("PIID").toString());
        if( row.getAttribute("HHCID") != null)
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("HHCID",  row.getAttribute("HHCID").toString());
        if( row.getAttribute("Comments") != null)
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Comments",  row.getAttribute("Comments"));
        
        

       
    }

    public void setGridPanel(RichPanelGroupLayout gridPanel) {
        this.gridPanel = gridPanel;
    }

    public RichPanelGroupLayout getGridPanel() {
        return gridPanel;
    }

    public void showPanel(ActionEvent actionEvent) {
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        ViewObjectImpl assignVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("HHCAssignVO1Iterator").getViewObject();
//        assignVO.setApplyViewCriteriaName("HHCAssignVOCriteria");
//        assignVO.executeQuery();
               java.sql.Date sqlDate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime());  
               OperationBinding op =
            (OperationBinding)bindingContainer.getOperationBinding("displayHHCdtls"); 
               op.getParamsMap().put("shift", shiftVal);
        op.getParamsMap().put("location", locVal);
        op.getParamsMap().put("currentDate", sqlDate);
        op.execute();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", true);
        gridPanel.setVisible(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
        getCurrentDt();
        
    }

    public void setShiftId(RichSelectOneChoice shiftId) {
    }

    public RichSelectOneChoice getShiftId() {
        return shiftId;
    }

    public void shiftValueChange(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        oldShiftVal = shiftVal;
        System.out.println(valueChangeEvent.getNewValue());
        int val = 0;
        if(valueChangeEvent.getNewValue() != null){
        shiftVal =(valueChangeEvent.getNewValue().toString());
        }
        /* DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        ViewObjectImpl shiftlistVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("shiftlistVO1Iterator").getViewObject();
        Row row = shiftlistVO.getRowAtRangeIndex(val);
       shiftVal = row.getAttribute("shiftId").toString(); */
       /* issueselectedradio.resetValue();
       AdfFacesContext.getCurrentInstance().addPartialTarget(issueselectedradio); */ 
    }

    public void locationValueChange(ValueChangeEvent valueChangeEvent) {
        System.out.println(valueChangeEvent.getNewValue());
        int val = 0;
        if(valueChangeEvent.getNewValue() != null)
        {
         val = Integer.parseInt(valueChangeEvent.getNewValue().toString());
        }
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        ViewObjectImpl genLocationLOVVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("GenLocationLOVVO1Iterator").getViewObject();
        Row row = genLocationLOVVO.getRowAtRangeIndex(val);
        locVal = row.getAttribute("locationid").toString();
        /* issueselectedradio.resetValue();
        AdfFacesContext.getCurrentInstance().addPartialTarget(issueselectedradio); */
    }

    public void setShiftVal(String shiftVal) {
        this.shiftVal = shiftVal;
    }

    public String getShiftVal() {
        return shiftVal;
    }

    public void setLocVal(String locVal) {
        this.locVal = locVal;
    }

    public String getLocVal() {
        return locVal;
    }

    public void setReceiveddate(RichColumn receiveddate) {
        this.receiveddate = receiveddate;
    }

    public RichColumn getReceiveddate() {
        return receiveddate;
    }

    public void setReAssignAction(RichColumn reAssignAction) {
        this.reAssignAction = reAssignAction;
    }

    public RichColumn getReAssignAction() {
        return reAssignAction;
    }

    public String CancelTop() {
        // Add event code here...
        setSubmitClickedFlag(false);
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        /* ViewObjectImpl shiftlistVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("shiftlistVO1Iterator").getViewObject();
        Row row1 = shiftlistVO.getRowAtRangeIndex(0);
        shiftVal = row1.getAttribute("shiftId").toString(); */ 
        if(shiftVal.length()==0){
        String shift=(String)ADFUtils.evaluateEL("#{bindings.GenpiShiftMstVO1.attributeValue}");
        System.out.println("Shiftname is:::"+shift);
        if(shift!=null){
            ViewObject shiftVO = (ViewObject)bindingContainer.findIteratorBinding("GenpiShiftMstVO1Iterator").getViewObject();
            shiftVO.setWhereClause("pi_shift_desc='"+shift+"'");
            System.out.println("shift query is:::"+shiftVO.getQuery());
            shiftVO.executeQuery();
            Row row=shiftVO.first();
            Integer shtval=Integer.parseInt(row.getAttribute("pishiftid").toString());
            shiftVal=Integer.toString(shtval);
                  }
        }
        BindingContainer bindingContainer2 = getBindings();
        ViewObjectImpl genLocationLOVVO = (ViewObjectImpl)bindingContainer.findIteratorBinding("GenLocationLOVVO1Iterator").getViewObject();
        Row row2 = genLocationLOVVO.getRowAtRangeIndex(0);
        locVal = row2.getAttribute("locationid").toString();
        selectlocation.setValue(0);
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectlocation);
        pageflowScope.put("VOStatus","notdirty");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("panelVisible", false);
           gridPanel.setVisible(false);
           AdfFacesContext.getCurrentInstance().addPartialTarget(gridPanel);
        receiveSelectOneChoice.setDisabled(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(receiveSelectOneChoice);
        return null;
    }

    public void setFlagcancel(boolean flagcancel) {
        this.flagcancel = flagcancel;
    }

    public boolean isFlagcancel() {
        return flagcancel;
    }
    public void getCurrentDt(){
        logger.info("Start getCurrentDate Method of PISpvsrMapMBean ");
        SimpleDateFormat stf = new SimpleDateFormat("dd-MM-yyyy");
        curDate = new Date();
        try {
            curDate = stf.parse(stf.format(curDate).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public Date getCurDate() {
        return curDate;
    }

    public void setHhcTable(RichTable hhcTable) {
        this.hhcTable = hhcTable;
    }

    public RichTable getHhcTable() {
        return hhcTable;
    }

    public void setSubmitClickedFlag(boolean submitClickedFlag) {
        this.submitClickedFlag = submitClickedFlag;
    }

    public boolean isSubmitClickedFlag() {
        return submitClickedFlag;
    }

    public void setOldShiftVal(String oldShiftVal) {
        this.oldShiftVal = oldShiftVal;
    }

    public String getOldShiftVal() {
        return oldShiftVal;
    }

    public void setIssueSelectOneChoice(RichSelectItem issueSelectOneChoice) {
        this.issueSelectOneChoice = issueSelectOneChoice;
    }

    public RichSelectItem getIssueSelectOneChoice() {
        return issueSelectOneChoice;
    }

    public void setReceiveSelectOneChoice(RichSelectItem receiveSelectOneChoice) {
        this.receiveSelectOneChoice = receiveSelectOneChoice;
    }

    public RichSelectItem getReceiveSelectOneChoice() {
        return receiveSelectOneChoice;
    }

    public void setPrinterId(RichInputText printerId) {
        this.printerId = printerId;
    }

    public RichInputText getPrinterId() {
        return printerId;
    }

    public void setHhcReceiveConditionbind(RichSelectOneRadio hhcReceiveConditionbind) {
        this.hhcReceiveConditionbind = hhcReceiveConditionbind;
        if(this.hhcReceiveConditionbind.getValue()==null){
            this.hhcReceiveConditionbind.setValue("G");
        }
    }

    public RichSelectOneRadio getHhcReceiveConditionbind() {
        return hhcReceiveConditionbind;
    }

    public void setHhcReceiveConditionBind(RichSelectItem hhcReceiveConditionBind) {
        this.hhcReceiveConditionBind = hhcReceiveConditionBind;
    }

    public RichSelectItem getHhcReceiveConditionBind() {
        return hhcReceiveConditionBind;
    }

    public void setHhcReceivePgBind(RichPanelGroupLayout hhcReceivePgBind) {
        this.hhcReceivePgBind = hhcReceivePgBind;
    }

    public RichPanelGroupLayout getHhcReceivePgBind() {
        return hhcReceivePgBind;
    }

    public void setPrinterReceivePgBind(RichPanelGroupLayout printerReceivePgBind) {
        this.printerReceivePgBind = printerReceivePgBind;
    }

    public RichPanelGroupLayout getPrinterReceivePgBind() {
        return printerReceivePgBind;
    }

    public void setPrinterReceiveConditionBind(RichInputText printerReceiveConditionBind) {
        this.printerReceiveConditionBind = printerReceiveConditionBind;
    }

    public RichInputText getPrinterReceiveConditionBind() {
        return printerReceiveConditionBind;
    }

    public void setPrinterReceivedConditionBind(RichSelectOneRadio printerReceivedConditionBind) {
        this.printerReceivedConditionBind = printerReceivedConditionBind;
        if(this.printerReceivedConditionBind.getValue()==null){
            this.printerReceivedConditionBind.setValue("G"); 
        }
    }

    public RichSelectOneRadio getPrinterReceivedConditionBind() {
        return printerReceivedConditionBind;
    }


    public void fileuploadVC(ValueChangeEvent valueChangeEvent) {
         RichInputFile inputFileComponent = (RichInputFile)valueChangeEvent.getComponent();
        UploadedFile newFile = (UploadedFile)valueChangeEvent.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());
        String uploadPath = null;
        String fullPath = null;
        Row currentAttchmtRow;
        String HhcId=null;
            if (getHhcId().getValue() != null && !getHhcId().getValue().equals("") ) {
                HhcId = getHhcId().getValue().toString();
             DCIteratorBinding hhcAssigniter =bindingsAM.findIteratorBinding("HHCAssignVO2Iterator");
             ViewObject hhcAssignVO=hhcAssigniter.getViewObject();
             hhcAssignVO.setWhereClause("HH_SNo = '"+HhcId+"' and Status = 'Y' ");
             System.out.println("hhc Assign query in docUpload:"+hhcAssignVO.getQuery());
             hhcAssignVO.executeQuery();
             Row hhcAssignRow=hhcAssignVO.first();
             if(hhcAssignRow!=null){
             Integer id=Integer.parseInt(hhcAssignRow.getAttribute("ID").toString());
                    DCIteratorBinding dciterrefundattchmt1 =bindingsAM.findIteratorBinding("HHCAssignDocsVO1Iterator");
                    ViewObject hhcDocVO=dciterrefundattchmt1.getViewObject();
                    currentAttchmtRow= hhcDocVO.createRow();
                     if (null != valueChangeEvent.getNewValue()) {
                         UploadedFile uploadFile =(UploadedFile)valueChangeEvent.getNewValue();
                         if (uploadFile != null) {
                             uploadPath =uploadFilesToFolder("1", "HHD Data", HhcId, uploadFile);
                              if (uploadPath != null) {
                                 fullPath = uploadPath + "//" + uploadFile.getFilename();
                             }
                             String docFielName = uploadFile.getFilename();
                             java.sql.Date sqlDate =
                                 new java.sql.Date(new java.util.Date().getTime());
                             System.out.println("sqlDate is : " + sqlDate);
                           
                             /*start of code to get RelatedTo value */
                             /*end of code */
                             int docType = getFileExtension(docFielName);
                          
                             java.sql.Date sqlDate1 =
                                 new java.sql.Date(new java.util.Date().getTime());

                             currentAttchmtRow.setAttribute("HHCASSIGNID", id);
                             currentAttchmtRow.setAttribute("CreatedBy", userName);
                             currentAttchmtRow.setAttribute("filepath", fullPath);
                             currentAttchmtRow.setAttribute("deleteflag", "N");
                             currentAttchmtRow.setAttribute("doctype", docType);
                             currentAttchmtRow.setAttribute("Docstage", 1);
                             currentAttchmtRow.setAttribute("CreatedDate", sqlDate);
                             currentAttchmtRow.setAttribute("DOCDesc", docFielName);
                             hhcDocVO.insertRow(currentAttchmtRow);
                       
                         }
                     }
             }
                                 
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
              //rootPath = "D://FileStore";
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
                       if(documentCategory.equals("HHD Data"))
                       {                        
                         File docCat = null;
                         if (documentCategory.equals("HHD Data"))
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
                           if(documentCategory.equals("HHD Data"))
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

    public void hhcConditinVCL(ValueChangeEvent valueChangeEvent) {
       String assetype= valueChangeEvent.getNewValue().toString();
       if(assetype.equalsIgnoreCase("D")){
           hhcInputFileBind.setVisible(true);
           AdfFacesContext.getCurrentInstance().addPartialTarget(hhcInputFileBind);
         
       }  
       else{
           hhcInputFileBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(hhcInputFileBind);
       }
       }

    public void setHhcInputFileBind(RichInputFile hhcInputFileBind) {
        this.hhcInputFileBind = hhcInputFileBind;
    }

    public RichInputFile getHhcInputFileBind() {
        return hhcInputFileBind;
    }

    public void hhcIdVCL(ValueChangeEvent valueChangeEvent) {
        String hhcid=valueChangeEvent.getNewValue().toString();
        if(hhcid!=null){
            getHhcId().setValue(hhcid);
        }
    }


    public void fileuploadVC1(ValueChangeEvent valueChangeEvent) {
        RichInputFile inputFileComponent = (RichInputFile)valueChangeEvent.getComponent();
        UploadedFile newFile = (UploadedFile)valueChangeEvent.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());
        String uploadPath = null;
        String fullPath = null;
        Row currentAttchmtRow;
        String PrinterId=null;
        if(getPrinterId().getValue() !=null && !getPrinterId().getValue().equals("")){
            PrinterId=getPrinterId().getValue().toString();
            DCIteratorBinding hhcAssigniter =bindingsAM.findIteratorBinding("HHCAssignVO2Iterator");
            ViewObject hhcAssignVO=hhcAssigniter.getViewObject();
            hhcAssignVO.setWhereClause("Printer_SNo = '"+PrinterId+"' and Status = 'Y'  ");
            System.out.println("Printer Assign query in docUpload:"+hhcAssignVO.getQuery());
            hhcAssignVO.executeQuery();
            Row hhcAssignRow=hhcAssignVO.first();
            if(hhcAssignRow!=null){
            Integer id=Integer.parseInt(hhcAssignRow.getAttribute("ID").toString());
                   DCIteratorBinding dciterrefundattchmt1 =bindingsAM.findIteratorBinding("HHCAssignDocsVO1Iterator");
                   ViewObject hhcDocVO=dciterrefundattchmt1.getViewObject();
                   currentAttchmtRow= hhcDocVO.createRow();
                    if (null != valueChangeEvent.getNewValue()) {
                        UploadedFile uploadFile =(UploadedFile)valueChangeEvent.getNewValue();
                        if (uploadFile != null) {
                            uploadPath =uploadFilesToFolder1("1", "Printer Data", PrinterId, uploadFile);
                             if (uploadPath != null) {
                                fullPath = uploadPath + "//" + uploadFile.getFilename();
                            }
                            String docFielName = uploadFile.getFilename();
                            java.sql.Date sqlDate =
                                new java.sql.Date(new java.util.Date().getTime());
                            System.out.println("sqlDate is : " + sqlDate);
                          
                            /*start of code to get RelatedTo value */
                            /*end of code */
                            int docType = getFileExtension(docFielName);
                         
                            java.sql.Date sqlDate1 =
                                new java.sql.Date(new java.util.Date().getTime());

                            currentAttchmtRow.setAttribute("HHCASSIGNID", id);
                            currentAttchmtRow.setAttribute("CreatedBy", userName);
                            currentAttchmtRow.setAttribute("filepath", fullPath);
                            currentAttchmtRow.setAttribute("deleteflag", "N");
                            currentAttchmtRow.setAttribute("doctype", docType);
                            currentAttchmtRow.setAttribute("Docstage", 1);
                            currentAttchmtRow.setAttribute("CreatedDate", sqlDate);
                            currentAttchmtRow.setAttribute("DOCDesc", docFielName);
                            hhcDocVO.insertRow(currentAttchmtRow);
                      
                        }
                    }
            }
                                
        } 
    }
    public String uploadFilesToFolder1(String organizationId,
                                          String documentCategory, String code,
                                           UploadedFile uploadFiles) {

          String path = null;
          String uploadedPath = null;
          if (null != uploadFiles) {
           
              UploadedFile tempFile = uploadFiles;
              System.out.println("temp file" + tempFile.getFilename());
              //rootPath = "D://FileStore";
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
                    uploadedPath = findDirectoryAndUpload1(documentCategory,code,path,rootPath,organizationId,tempFile);     
                }else{
                     path = rootPath + "//" + organizationId;
                     uploadedPath = findDirectoryAndUpload1(documentCategory,code,path,rootPath,organizationId,tempFile);     
                    }
                      
                      System.out.println("Path in if part" + path);
                } 
                
            
            }
              return uploadedPath;
          }
    private String findDirectoryAndUpload1(String documentCategory, String code, String path, String rootPath, String orgId, UploadedFile tempFile) {
            String pvtTempPath = null;
            String tempPath = null;
            File pathFile = null;
            //Check if document category exist
                       if(documentCategory.equals("Printer Data"))
                       {                        
                         File docCat = null;
                         if (documentCategory.equals("Printer Data"))
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
                           if(documentCategory.equals("Printer Data"))
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
    public void setPrinterInputFileBind(RichInputFile printerInputFileBind) {
        this.printerInputFileBind = printerInputFileBind;
    }

    public RichInputFile getPrinterInputFileBind() {
        return printerInputFileBind;
    }

    public void priterConditionVCL(ValueChangeEvent valueChangeEvent) {
        String assetype=valueChangeEvent.getNewValue().toString();
        if(assetype.equalsIgnoreCase("D")){
            printerInputFileBind.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(printerInputFileBind);
        }
        else{
            printerInputFileBind.setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(printerInputFileBind);
        }
    }

    public void newshiftVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        oldShiftVal = shiftVal;
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
            /* issueselectedradio.resetValue();
            AdfFacesContext.getCurrentInstance().addPartialTarget(issueselectedradio); */
        }
    }
}
