package com.imum.cpms.view;


import com.imum.cpms.model.masters.vo.PvtAppealdocMstVORowImpl;

import java.sql.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;

public class ApplealDocumentsMB {
        FacesContext facesContext = FacesContext.getCurrentInstance();
         ExternalContext externalContext = facesContext.getExternalContext();
         HttpSession httpSession = (HttpSession) externalContext.getSession(false);
         String userName = httpSession.getAttribute("loggedinUserid").toString();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        String reasonid = null;
    public ApplealDocumentsMB() {
    }

    public String editApplealDocuments() {
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","false");
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.appealResVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
           
            reasonid= selectedRow.getAttribute("ReasonID").toString();
        
        }
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("PvtAppealdocMstVO1Iterator");
        ViewObject appVO = dcItteratorBinding.getViewObject();
        appVO.executeEmptyRowSet();
        appVO.setWhereClause(null);
        appVO.setWhereClauseParams(null);
        appVO.setWhereClause("pvt_appeal_reason_id = '"+reasonid+"'");
        appVO.executeQuery();
    return null;
    }
        
      

    public String viewApplealDocuments() {
       
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","View");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit"); 
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.appealResVO1Iterator.currentRow}"); 
            String rid=null;
        if(selectedRow != null)
        {
           
        rid=selectedRow.getAttribute("ReasonID").toString();
        
        }
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("PvtAppealdocMstVO1Iterator");
        ViewObject appVO = dcItteratorBinding.getViewObject();
        appVO.executeEmptyRowSet();
        appVO.setWhereClause(null);
        appVO.setWhereClauseParams(null);
        appVO.setWhereClause("pvt_appeal_reason_id = '"+rid+"'");
        appVO.executeQuery();
        return null;
        }
       
           
   

    public String Submit() {
        String er=null;
        DCBindingContainer bindings4 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings3 =bindings4.findIteratorBinding("PvtAppealdocMstVO1Iterator");
        ViewObject ApplealTabledata = dcItteratorBindings3.getViewObject();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        java.sql.Date activeFromDate=null;
        java.sql.Date activeTODate=null;
        if(ApplealTabledata!=null) 
        {
        for(int i = 0; i<ApplealTabledata.getFetchedRowCount() ;i++)
        {
        PvtAppealdocMstVORowImpl row = (PvtAppealdocMstVORowImpl)ApplealTabledata.getRowAtRangeIndex(i) ;
           
            Object docname = row.getDocName();
            Object docdesc = row.getDocDesc();
            Object actf=row.getActivefromDate();
            Object acttodate=row.getActivetoDate();
            Object mflag=row.getActiveflag();
            Object aflag=row.getMandatoryflag();
            Integer rowStatus = (Integer)row.getclickonedit();
            if(!(docname!=null)) {  
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Document Name ",null));
                er="error";
            }
                  if(!(docdesc!=null)) {  
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Document Descripton",null));    
                er="error";
            }
            if(!(actf!=null)) {  
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Active From Date  ",null));
            er="error";
            }
            if(!(acttodate!=null)) {  
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter Active To Date  ",null));
            er="error";
            }
            if(er!=null) {
                return null;
            }
            if(mflag==null && rowStatus == 0) {  
                row.setMandatoryflag("N");
            }
            if(aflag==null & rowStatus == 0) {  
            row.setActiveflag("N");
            }
          
            
            int seq=0;
            if(reasonid!=null)
            {
            seq=Integer.parseInt(reasonid);
            }
            
            row.setPVTAPPEALREASONID(seq);
            // new date 
            System.out.println(rowStatus);
            if(row.getActivefromDate()!=null && row.getActivetoDate()!=null && rowStatus == 0) {
                activeFromDate = new java.sql.Date(row.getActivefromDate().getTime());
                activeTODate = new java.sql.Date(row.getActivetoDate().getTime());
            String actfromdate = activeFromDate.toString();
            String sqlDatefromstr = sqlDate.toString();
            String acttidate=activeTODate.toString();
            
                if(activeFromDate.before(sqlDate) ) {
                    if(actfromdate.compareToIgnoreCase(sqlDatefromstr) == 0) {
                                     System.out.println(sqlDate);
                    }
                    else
                    {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Active From Date should not be before Current Date",null)); 
                   return null;
                    }
                }
               
                if(activeFromDate.after(activeTODate) ) {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Active To Date should be After The From Date",null));    
                   return null;
                }
            
            
            
            
            
            
            
                
//             else if(actfromdate.compareToIgnoreCase(sqlDatefromstr) == 0) {
//                 System.out.println(sqlDate);
//                 if(activeFromDate.before(sqlDate) ) {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Active From Date should not be before Current Date",null)); 
//                    return null;
//                   
//                    
//                 }
//             }
             
             
            }
            
            //edit date 
            if(row.getActivefromDate()!=null && row.getActivetoDate()!=null && rowStatus == 2) {
                activeFromDate = new java.sql.Date(row.getActivefromDate().getTime());
                activeTODate = new java.sql.Date(row.getActivetoDate().getTime());
                String actfromdate = activeFromDate.toString();
                String sqlDatefromstr = sqlDate.toString();
                row.setUpdatedby(userName);
                row.setUpdatedate(sqlDate);
                System.out.println(activeFromDate);
                System.out.println(activeTODate);
                if(actfromdate.compareToIgnoreCase(sqlDatefromstr) == 0) {
                    System.out.println(sqlDate);
                }
                
                 if(activeFromDate.before(sqlDate) ) {   
                }
              if(activeFromDate.after(activeTODate) ) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," Active To Date should be After The From Date",null));    
                return null;
            }
            }
            
            
            
            
            
        }
        }
        
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doCommit");
        String result = opBinding.execute().toString();   
        if("true".equals(result)) {
            System.out.println(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Appleal Details saved successfully.")); 
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","disable");
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","false");
            
        }
      
      
      
        return null;
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public String cancel() {
        getBindings().getOperationBinding("doRollback").execute();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","disable");
        return null;
    }

  

    public String getNewRow() {
        OperationBinding op =getBindings().getOperationBinding("createnewRow");
        op.getParamsMap().put("username",userName);
        op.getParamsMap().put("reasonid",reasonid);
        op.execute();
        return null;
    }
}
