package com.imum.cpms.view;

import com.imum.cpms.model.masters.vo.BeatMstUVORowImpl;

import com.imum.cpms.model.masters.vo.RevenueGroupUVORowImpl;

import com.imum.cpms.model.masters.vo.RevenueTypeUVORowImpl;

import java.sql.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;

public class RevenueGroupMBean {
    FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession httpSession = (HttpSession) externalContext.getSession(false);
   String userName = httpSession.getAttribute("loggedinUserid").toString();
   String GroupCode = null;
  
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    public RevenueGroupMBean() {
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public String NewRevenueGroup() {
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","notView");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("ROGrp","NotReadonly");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","New");
        OperationBinding op =
            getBindings().getOperationBinding("createRevenueGroupType");
        op.getParamsMap().put("username", userName);
        op.execute();
        DCIteratorBinding dcItteratorBindingType =
        bindingsAM.findIteratorBinding("RevenueTypeUVO1Iterator");
        
        ViewObject RevTypeVO = dcItteratorBindingType.getViewObject();
        RevTypeVO.executeEmptyRowSet();
       
        
        
        return null;
    }

    public String AddRevenueTypeRow() {
        
        
        String RevGroupcode = null;
        DCBindingContainer bindings4 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings3 =
        bindings4.findIteratorBinding("RevenueGroupUVO2Iterator");
        ViewObject RevenueGroupTabledata = dcItteratorBindings3.getViewObject();
        if(RevenueGroupTabledata != null) 
        {
            RevenueGroupUVORowImpl RevenueGrouprow = (RevenueGroupUVORowImpl)RevenueGroupTabledata.getCurrentRow();
            RevGroupcode = RevenueGrouprow.getRevGrpCode();
            String RevGroupDesc = RevenueGrouprow.getRevGrpDesc();
            String activeflag = RevenueGrouprow.getActiveFlag();
            if(RevGroupcode == null )
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Revenue Group Code."));    
                return null;
            }
        }
        
        OperationBinding op =
        getBindings().getOperationBinding("createRevenueTypeRow");
        op.getParamsMap().put("username", userName);
        op.getParamsMap().put("GroupCode", RevGroupcode);
      
        op.execute();
        
        return null;
       
    }

    public String Edit() {
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","notView");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("ROGrp","Readonly");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","New");
       
        
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.RevenueGroupUVO1Iterator.currentRow}");
        if(selectedRow != null) 
        {
             GroupCode= selectedRow.getAttribute("RevGrpCode").toString();
        }
     
        DCIteratorBinding dcItteratorBinding =
        bindingsAM.findIteratorBinding("RevenueGroupUVO2Iterator");
        
        ViewObject RevGroupVO = dcItteratorBinding.getViewObject();
        RevGroupVO.executeEmptyRowSet();
        RevGroupVO.setWhereClause(null);
        RevGroupVO.setWhereClauseParams(null);
        RevGroupVO.setWhereClause("Rev_Grp_Code = '"+GroupCode+"'");
        RevGroupVO.executeQuery();
        
     
        DCIteratorBinding dcItteratorBindingType =
        bindingsAM.findIteratorBinding("RevenueTypeUVO1Iterator");
        
        ViewObject RevTypeVO = dcItteratorBindingType.getViewObject();
        RevTypeVO.executeEmptyRowSet();
        RevTypeVO.setWhereClause(null);
        RevTypeVO.setWhereClauseParams(null);
        RevTypeVO.setWhereClause("Rev_Grp_Code = '"+GroupCode+"'");
        RevTypeVO.executeQuery();
        
       int count = RevTypeVO.getRowCount();
        return null;
    }

    public String Submit() {
        
        DCBindingContainer bindings4 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings3 =
        bindings4.findIteratorBinding("RevenueGroupUVO2Iterator");
        ViewObject RevenueGroupTabledata = dcItteratorBindings3.getViewObject();
        if(RevenueGroupTabledata != null) 
        {
            RevenueGroupUVORowImpl RevenueGrouprow = (RevenueGroupUVORowImpl)RevenueGroupTabledata.getCurrentRow();
            String RevGroupcode = RevenueGrouprow.getRevGrpCode();
            String RevGroupDesc = RevenueGrouprow.getRevGrpDesc();
            String activeflag = RevenueGrouprow.getActiveFlag();
            Integer rowstatus = (Integer)RevenueGrouprow.getclickedonedit();
            if(RevGroupcode == null )
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Revenue Group Code."));    
                return null;
            }
            if(RevGroupDesc == null)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Revenue Group Description."));    
                return null;
            }
            if(rowstatus == 2) 
            {
                Timestamp sqlDate =
                                   new java.sql.Timestamp(new java.util.Date().getTime());
                                RevenueGrouprow.setUpdatedBy(userName);
                                RevenueGrouprow.setUpdatedDate(sqlDate);
            }
           
        }
       
    
        DCIteratorBinding dcItteratorBindings4 =
        bindings4.findIteratorBinding("RevenueTypeUVO1Iterator");
        ViewObject RevTypeTabledata = dcItteratorBindings4.getViewObject();
        if(RevTypeTabledata!=null) 
        {
        long count =     RevTypeTabledata.getEstimatedRowCount();
        if(count == 0) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please add atleast one row for Revenue Type"));    
            return null;
        }
            
        for(int i = 0; i<RevTypeTabledata.getEstimatedRowCount() ;i++)
        {
        RevenueTypeUVORowImpl RevTyperow = (RevenueTypeUVORowImpl)RevTypeTabledata.getRowAtRangeIndex(i) ;
        String RevTypecode = RevTyperow.getRevTypeCode();
        String RevTypeDesc = RevTyperow.getRevTypeDesc();
        String Activeflag = RevTyperow.getActiveFlag();
            Integer rowstatus = (Integer)RevTyperow.getclickedonedit();
            
        if(RevTypecode == null) 
        { 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Revenue Type Code"));    
            return null;
        }
        if(RevTypeDesc == null)  
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Revenue Type Description"));    
            return null;
        }
            if(rowstatus == 2) 
            {
                Timestamp sqlDate =
                                   new java.sql.Timestamp(new java.util.Date().getTime());
                                RevTyperow.setUpdatedBy(userName);
                                RevTyperow.setUpdatedDate(sqlDate);
            }
            
        }
        
        
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doCommit");
        String result = opBinding.execute().toString();   
        if("true".equals(result)) {
            System.out.println(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Revenue Details saved successfully.")); 
            getBindings().getOperationBinding("doRollback").execute();
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","notNew");
         
            
        }
        
       
    }
        return null;
    }

    public void cancel(ActionEvent actionEvent) {
        // Add event code here...
        getBindings().getOperationBinding("doRollback").execute();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","notNew");
        
    }

    public String View() {
        // Add event code here...
       
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","New");
      
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","View");
        
        
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.RevenueGroupUVO1Iterator.currentRow}");
        if(selectedRow != null) 
        {
             GroupCode= selectedRow.getAttribute("RevGrpCode").toString();
        }
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
        bindingsAM.findIteratorBinding("RevenueGroupUVO2Iterator");
        
        ViewObject RevGroupVO = dcItteratorBinding.getViewObject();
        RevGroupVO.executeEmptyRowSet();
        RevGroupVO.setWhereClause(null);
        RevGroupVO.setWhereClauseParams(null);
        RevGroupVO.setWhereClause("Rev_Grp_Code = '"+GroupCode+"'");
        RevGroupVO.executeQuery();
        
        
        DCIteratorBinding dcItteratorBindingType =
        bindingsAM.findIteratorBinding("RevenueTypeUVO1Iterator");
        
        ViewObject RevTypeVO = dcItteratorBinding.getViewObject();
        RevTypeVO.executeEmptyRowSet();
        RevTypeVO.setWhereClause(null);
        RevTypeVO.setWhereClauseParams(null);
        RevTypeVO.setWhereClause("Rev_Grp_Code = '"+GroupCode+"'");
        RevTypeVO.executeQuery();
        
        
       
        return null;
    }
}
