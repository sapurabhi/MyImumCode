package com.imum.cpms.staffdeployment;

import com.imum.cpms.util.JSFUtils;

import com.imum.cpms.util.MessageUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class PiapprovelMB {
    private RichCommandLink linkDoc;
    private RichInputText statuscom;
    private RichSelectOneChoice setSelect;
    MessageUtil genMsg = new MessageUtil();
    ArrayList lisSlected = new ArrayList();
    String filePath;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    public static final ADFLogger logger = ADFLogger.createADFLogger(PiapprovelMB.class);
    public PiapprovelMB() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
        
        
        
    }
    private DCBindingContainer getBindings() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    private DCBindingContainer getBindings1() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    
    
    public void getPiLeaveDocs(FacesContext facesContext, OutputStream outputStream) {
       // String filePath = "D:\\cpmsshare\\PIProfile\\Leave\\AD044\\insert.txt";//(String
       logger.info("Start getPiLeaveDocs Method of PiapprovelMB ");
        filePath =(String)linkDoc.getAttributes().get("Attachment");
      //  System.out.println(filePath);
        
        //end 
    //Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.leaveApproveVO1.currentRow}");
        
 // FacesCtrlHierBinding listBinding2 =(FacesCtrlHierBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leaveApproveVO1"); 
   
     //selectedRow.getCurrentRow();
     // String filePath =(String)listBinding2.getAttribute("Attachment");
   //String filePath="";
 //String  filePath=AdfFacesContext.getCurrentInstance().getPageFlowScope().get("Attachment").toString();
//    String filePath=(String)selectedRow.getAttribute("Attachment");
//       System.out.println(filePath);
      
          
//        //Row r=groupVO.getCurrentRow();
//        //r.getAttribute("Attachment");
//       String s=selectedRow.getAttribute("PIid").toString();
//       System.out.println(s);
//        String filePath =(String)selectedRow.getAttribute("Attachment");
            
//        System.out.println(selectedRow.getAttribute("PIid"));        
//        System.out.println(selectedRow.getAttribute("Attachment"));
        // get the current selected row
//         
//       //String filePath =(String)selectedRow.getAttribute("Attachment");
//        String pi=(String)selectedRow.getAttribute("PIid");
//        System.out.println(pi);
     
       filePath=(String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("Attachment");
            //  System.out.println("filePath  :::::::::::::::::             "+filePath);
        File filed = new File(filePath);
        FileInputStream fis;
        byte[] b;
        try {
            fis = new FileInputStream(filed);

            int n;
            while ((n = fis.available()) > 0) {
                b = new byte[n];
                int result = fis.read(b);
                outputStream.write(b, 0, b.length);
                if (result == -1)
                    break;
            }
            outputStream.flush();
            ViewObject groupVO=getBindings1().findIteratorBinding("leaveApproveVO1Iterator").getViewObject();
            groupVO.executeQuery();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("End getPiLeaveDocs Method of PiapprovelMB ");  
    }

    public void setLinkDoc(RichCommandLink linkDoc) {
        this.linkDoc = linkDoc;
    }

    public RichCommandLink getLinkDoc() {
        return linkDoc;
    }


    public String saveRows() {
        // Add event code here...
        logger.info("Start saveRows Method of PiapprovelMB ");
        FacesCtrlHierBinding listBinding2 =(FacesCtrlHierBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leaveApproveVO1");
        ViewObject vo = listBinding2.getViewObject();
        RowSetIterator rowsi = vo.createRowSetIterator(null);
       // System.out.println(rowsi.getRowCount());
        boolean result = true;
        while(rowsi.hasNext()){
            Row row = rowsi.next();
            //System.out.println(row.getAttribute("StatusComments"));
          //System.out.println(row.getAttribute("Status"));
            //----------- chandu added code
    
            //---------------------------
            if(row.getAttribute("Status")!=null){
//            if(row.getAttribute("Status").toString().equalsIgnoreCase("Approved") || row.getAttribute("Status").toString().equalsIgnoreCase("Denied")){
//                result = true;
//            }
            if(row.getAttribute("Status").toString().equalsIgnoreCase("Denied")){
                if(row.getAttribute("StatusComments")==null||row.getAttribute("StatusComments").toString().trim().length()==0){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "Leave Rejection comments are Mandatory.")); 
                    
                    result=false;
                  return null;
                }  
                else{
                    result=true;
                }
            }
            if(row.getAttribute("Status").toString().equalsIgnoreCase("Approved")){
                ViewObjectImpl pimonthvo =(ViewObjectImpl)getBindings1().findIteratorBinding("PImonthlyWorkAssignVO2Iterator").getViewObject();
                pimonthvo.setApplyViewCriteriaName("PIAftermonthlyLeaveApplyWorkAssignVOCriteria1");
                pimonthvo.setNamedWhereClauseParam("piid", row.getAttribute("PIid"));
                pimonthvo.setNamedWhereClauseParam("leavestartdate", row.getAttribute("FromDate"));
                pimonthvo.setNamedWhereClauseParam("leaveenddate", row.getAttribute("ToDate"));
                System.out.println("pimonthvo query in pi leave screen is:::"+pimonthvo.getQuery());
                pimonthvo.executeQuery();
                java.util.Date currentDate = new java.util.Date(System.currentTimeMillis());
                java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
                java.sql.Date fD1 = new java.sql.Date(sqlDate1.getTime());
                System.out.println(pimonthvo.getRowCount());
                RowSetIterator rowsi1 = pimonthvo.createRowSetIterator(null);
                while(rowsi1.hasNext()){
                    Row row1=rowsi1.next();
                    row1.setAttribute("Shift1Flag", "N");
                    row1.setAttribute("Shift2Flag", "N");
                    row1.setAttribute("Shift3Flag", "N");
                    //row1.setAttribute("Shift", 0);
                    //row1.setAttribute("SectorName", "OnLeave");
                   // row1.setAttribute("ZoneName", "OnLeave");
                   // row1.setAttribute("SectorZone", "OnLeave");
                    row1.setAttribute("Shift1", "OnLeave");
                    row1.setAttribute("Shift2", "OnLeave");
                    row1.setAttribute("Shift3", "OnLeave");
                    row1.setAttribute("UpdatedBy","PI_ADMIN" );
                    row1.setAttribute("UpdatedDate", fD1);
                    logger.info("pi Shift flags changed to OnLeave");
                }
            }
        }
        } 
        if(0 < rowsi.getRowCount()){
       // System.out.println(setSelect.getValue());
   if(lisSlected.size()>0)
   {
        
        if(result){
        oracle.binding.BindingContainer bindings = getBindings();
        OperationBinding op =bindings.getOperationBinding("doCommit");
        op.execute();
       ViewObject voUpdate= (ViewObject)listBinding2.getViewObject();
       voUpdate.executeQuery();
        lisSlected.clear();
        System.out.println("Number of elements in the list:::"+lisSlected.size());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("448",lgCode)));
//       FacesMessage fm = new FacesMessage("selected Leaves are approved/Denied");
//       fm.setSeverity(FacesMessage.SEVERITY_INFO);
//       FacesContext fctx = FacesContext.getCurrentInstance();
//       fctx.addMessage(null, fm);
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          "Please select at least on Leave to approve/Denied"));
//            FacesMessage fm = new FacesMessage("Please select at least on Leave to approve/Denied");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
        }
   }   
   else {
       FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                     "Sample info message",
                                                                     genMsg.getMessage("449",lgCode)));
//       FacesMessage fm = new FacesMessage("Please select at least one Leave to approve/Denied");
//       fm.setSeverity(FacesMessage.SEVERITY_INFO);
//       FacesContext fctx = FacesContext.getCurrentInstance();
//       fctx.addMessage(null, fm);
   }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("450",lgCode)));
//            FacesMessage fm = new FacesMessage("No Records Available To Submit");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
        }
  // System.out.println(" --------------------");
        logger.info("End saveRows Method of PiapprovelMB ");
        return null;
    }

    public void setStatuscom(RichInputText statuscom) {
        this.statuscom = statuscom;
    }

    public RichInputText getStatuscom() {
        return statuscom;
    }


    public String doCancel() {
        statuscom.setValue(null);
      //  JUCtrlListBinding listBinding1 =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leaveApproveVO1");
       FacesCtrlHierBinding listBinding2 =(FacesCtrlHierBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("leaveApproveVO1"); 
       ViewObject selected=listBinding2.getViewObject();
       RowSetIterator rowsi = selected.createRowSetIterator(null);
       // System.out.println(rowsi.getRowCount());
        if(0 >= rowsi.getRowCount()){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("451",lgCode)));
//            FacesMessage fm = new FacesMessage("No Records Available To Cancel");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
            return null;
        }
        
        while(rowsi.hasNext()){
            Row row = rowsi.next();
           // System.out.println(row.getAttribute("StatusComments"));
            //System.out.println(row.getAttribute("Status"));
            row.setAttribute("StatusComments", null);
            row.setAttribute("Status", "Pending");
            //getSetSelect().setSubmittedValue(0);
            //getSetSelect().resetValue();
        }
        logger.info("End saveRows Method of PiapprovelMB ");
        return null;
    }

    public void setSetSelect(RichSelectOneChoice setSelect) {
        this.setSelect = setSelect;
    }

    public RichSelectOneChoice getSetSelect() {
        return setSelect;
        
    }

    public void getValue(ValueChangeEvent valueChangeEvent) {
        logger.info("Start getValue Method of PiapprovelMB ");
      // System.out.println(valueChangeEvent.getNewValue());
      
       if(valueChangeEvent.getNewValue()!=null){
           //setSelect.setValue(valueChangeEvent.getNewValue());
           lisSlected.add(valueChangeEvent.getNewValue());
       }
       else{
           if(lisSlected.size()>0){
             lisSlected.remove(0);
           }
       }
        logger.info("End getValue Method of PiapprovelMB ");
    }

    public void getPath(ActionEvent actionEvent) {
        logger.info("Start getPath Method of PiapprovelMB ");
    filePath=(String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("Attachment");
   // System.out.println(filePath);
        logger.info("End getPath Method of PiapprovelMB ");
        
        
        
        
    }
}
