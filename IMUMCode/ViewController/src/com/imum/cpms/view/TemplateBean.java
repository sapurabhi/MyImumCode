package com.imum.cpms.view;

import com.imum.cpms.transactions.pvt.PVTPaymentBean;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.share.logging.ADFLogger;

import oracle.binding.BindingContainer;

import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewObject;
import oracle.jbo.common.types.ViewCriteria;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class TemplateBean {

    private String taskFlowId = "/WEB-INF/AboutIMUMTF.xml#AboutIMUMTF";
    private static String HTTP="http";
    public static final ADFLogger logger = ADFLogger.createADFLogger(TemplateBean.class);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String userName = httpSession.getAttribute("loggedinUserid").toString();

    public TemplateBean() {
        super();
    }
    
    public String passMenuId() {
        
        Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
        String bind_menuid = (String)pageflowScope.get("BindMenuID");
        System.out.println("##### Passing bind variable value... " + bind_menuid);
        executeUserRoleMenuQuery("MenuMstUVO1Iterator",bind_menuid,userName);       
        return null;
    }
    
    public String passMenuIdLng() {
            Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
            String bind_menuid = (String)pageflowScope.get("BindMenuID");
            System.out.println("##### Passing bind variable value...Lng " + bind_menuid);
            executeUserRoleMenuQuery("MenuLngDetailVO1Iterator",bind_menuid,userName);
            return null;
        }
    
/**
 * public String setCurrentMenuTaskFlowURL(ActionEvent actionEvent){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse httpResponse = (HttpServletResponse)externalContext.getResponse();
        HttpSession httpSession = (HttpSession)externalContext.getSession(true);
        System.out.println("HTTP SESSION ::::::::::::::::::    "+httpSession.getAttribute("loggedinUserid").toString());
        logger.info("HTTP SESSION TEMPLATE BEAN :::::::::::::::::::::   "+httpSession.getAttribute("loggedinUserid").toString());
        String menuURLToExecute = actionEvent.getComponent().getAttributes().get("requestedMenuURL").toString();
          System.out.println(" Requested menu url...." + menuURLToExecute);
          //open in new window for External application
            if(menuURLToExecute !=null && menuURLToExecute.contains(HTTP)) {
                   String username = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username").toString();
                   String password = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("password").toString();
//                   http://192.168.200.112:8001/bpm/workspace/faces/j_security_check?j_username=aplcommittee&j_password=aplcommittee%401
            String BPMURL = "";
            BPMURL = menuURLToExecute.substring(0, menuURLToExecute.indexOf("?"))+"?j_username="+username+"&j_password="+password;//+"%401";
//                BPMURL = "http://cpmsfmwappdc.cpms.local:8001/bpm/workspace/faces/j_security_check"+"?j_username="+"halo"+"&j_password="+"Halo@123";//+"%401";
               System.out.println(" if Requested menu url...." + BPMURL);
               FacesContext facesContext = FacesContext.getCurrentInstance();
               ExtendedRenderKitService erkService =  Service.getService(facesContext.getRenderKit(), ExtendedRenderKitService.class);
            // String url = "window.open('"+ menuURLToExecute +"','_self');";
               String url = "window.open('"+ BPMURL +"','_blank');";
               erkService.addScript(facesContext.getCurrentInstance(), url);              
               } else {
               System.out.println(" else Requested menu url...." + menuURLToExecute);
               taskFlowId = menuURLToExecute;
               }
           return null; 
    }*/
    
    
    public String setCurrentMenuTaskFlowURL(ActionEvent actionEvent){
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse httpResponse = (HttpServletResponse)externalContext.getResponse();
        HttpSession httpSession = (HttpSession)externalContext.getSession(true);
        System.out.println("HTTP SESSION ::::::::::::::::::    "+httpSession.getAttribute("loggedinUserid").toString());
        logger.info("HTTP SESSION TEMPLATE BEAN :::::::::::::::::::::   "+httpSession.getAttribute("loggedinUserid").toString());
        String menuURLToExecute = actionEvent.getComponent().getAttributes().get("requestedMenuURL").toString();
          System.out.println(" Requested menu url...." + menuURLToExecute);
          //open in new window for External application
            if(menuURLToExecute !=null && menuURLToExecute.contains(HTTP)) {
               
               String j_UserId = httpSession.getAttribute("loggedinUserid").toString();
               String j_Password = httpSession.getAttribute("encyptPassword").toString();
              String user_pass = "filler=141ca450-e37e-4527-b712-481b813581c0141ca450-e37e-4527-b712-481b813581c0141ca450-e37e-4527-b712-481b813581c0141ca450-e37e-4527-b712-481b813581c0141ca450-e37e-4527-b712-481b813581c0141ca450-e37e-4527-b712-481b813581c0"+"&j_username="+ j_UserId +"&j_password="+j_Password;
            //http://192.168.200.113:8001/bpm/workspace/faces/j_security_check?j_username=aplmanager&j_password=aplmanager%401
              // String bpm_url =  PropertiesBeanUtils.getValue("HTTP_DEV_BPM_URL");
               System.out.println("bpm_url  :::::::::::::   "+menuURLToExecute);
                String final_bpm_url =  menuURLToExecute.concat(user_pass);
                System.out.println("        final_bpm_url            "+final_bpm_url);
               
               System.out.println(" if Requested menu url...." + menuURLToExecute);
               FacesContext facesContext = FacesContext.getCurrentInstance();
               ExtendedRenderKitService erkService =  Service.getService(facesContext.getRenderKit(), ExtendedRenderKitService.class);
            // String url = "window.open('"+ menuURLToExecute +"','_self');";
               String url = "window.open('"+ final_bpm_url +"','_blank');";
               erkService.addScript(facesContext.getCurrentInstance(), url);              
               } else {
               System.out.println(" else Requested menu url...." + menuURLToExecute);
               taskFlowId = menuURLToExecute;
               }
           return null; 
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }
    
    public String logoutButton_action() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      
        HttpServletResponse httpResponse = (HttpServletResponse)externalContext.getResponse();
        HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    
        System.out.println("getDynamicTaskFlowId.........!!!!!!!! " + this.getDynamicTaskFlowId());
        if (this.getDynamicTaskFlowId() != null) {
            taskFlowId = "/WEB-INF/AboutIMUMTF.xml#AboutIMUMTF";  
        }
    
        try {
            if (httpSession != null) {
                httpSession.invalidate();
                FacesContext.getCurrentInstance().responseComplete();
            }

            httpResponse.sendRedirect("Login.jspx");
        } catch (Exception exception) {
            System.out.println("HTTP Session is null" + exception);
        }
        
        return null;
    }
    
    public void executeUserRoleMenuQuery(String menuIterator,String bind_menuid,String username){
        BindingContext bindingctx = BindingContext.getCurrent(); 
        BindingContainer binding = bindingctx.getCurrentBindingsEntry(); 
        DCBindingContainer bindingsImpl = (DCBindingContainer)binding; 
        DCIteratorBinding dcIterator = bindingsImpl.findIteratorBinding(menuIterator); 
        ViewObjectImpl menuIdVO = (ViewObjectImpl)dcIterator.getViewObject();  
        menuIdVO.setNamedWhereClauseParam("bind_menuid", bind_menuid);
        menuIdVO.setNamedWhereClauseParam("user_roleid", userName);
        menuIdVO.executeQuery();
        System.out.println("Query:::::"+menuIdVO.getQuery());
        System.out.println("Row Count:::Lng:"+menuIdVO.getRowCount());
    }

}
