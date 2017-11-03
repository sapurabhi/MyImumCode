package com.imum.cpms.view;

import com.imum.cpms.model.masters.vo.BeatMstUVORowImpl;


import com.imum.cpms.model.masters.vo.DocMstDtlUVORowImpl;
import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;

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

import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;

public class BeatMstBean {
    FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession httpSession = (HttpSession) externalContext.getSession(false);
   String userName = httpSession.getAttribute("loggedinUserid").toString();
    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
    String zonecode = null;
    
    
    public BeatMstBean() {
    }

    public String EditBeatMst() {
        // Add event code here...
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","false");
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.ZoneMstVO1Iterator.currentRow}");
        if(selectedRow != null) 
        {
             zonecode= selectedRow.getAttribute("ZoneCode").toString();
        }
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
        bindingsAM.findIteratorBinding("BeatMstUVO1Iterator");
        ViewObjectImpl BeatMstdtlVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
        ViewObject BeatMstVO = dcItteratorBinding.getViewObject();
        BeatMstVO.executeEmptyRowSet();
        BeatMstVO.setWhereClause(null);
        BeatMstVO.setWhereClauseParams(null);
        BeatMstVO.setWhereClause("Zone_Code = '"+zonecode+"'");
        BeatMstVO.executeQuery();
       
        System.out.println(BeatMstVO.getQuery());
        
        int count = BeatMstVO.getRowCount();
        return null;
    }

    public String AddRow() {
       
        OperationBinding op =
            getBindings().getOperationBinding("createnewBeat");
        op.getParamsMap().put("username",
                              userName);
        op.getParamsMap().put("zonecode",
                              zonecode);
        
        op.execute();
        
        
        return null;
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String Submit() {
        // Add event code here...
        DCBindingContainer bindings4 =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings3 =
        bindings4.findIteratorBinding("BeatMstUVO1Iterator");
        ViewObject BeatMstTabledata = dcItteratorBindings3.getViewObject();
        if(BeatMstTabledata!=null) 
        {
        for(int i = 0; i<BeatMstTabledata.getFetchedRowCount() ;i++)
        {
        BeatMstUVORowImpl beatrow = (BeatMstUVORowImpl)BeatMstTabledata.getRowAtRangeIndex(i) ;
        String beatcode = beatrow.getBeatCode();
            String beatname = beatrow.getBeatName();
            Object golivedate = beatrow.getGoLiveDate();
            Integer rowStatus = (Integer)beatrow.getAttribute("clickonedit");
        if(beatcode == null) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Beat Code"));    
            return null;
        }
            else if(rowStatus == 0)
            
        {
                    Row[] filteredRows = BeatMstTabledata.getFilteredRows("BeatCode", beatcode);
            if(filteredRows.length>1)
            {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Beat code already exists.Please enter different Beat Code."));   
             return null;
            }
         }
            
        if(beatname== null) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Beat Name"));   
            return null;
        }
        if(golivedate == null)   
        {
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter Go Live Date"));   
                return null;
            
        }
            java.sql.Date golivedateF = new java.sql.Date(beatrow.getGoLiveDate().getTime());
          
             java.sql.Date sqlDate =
                new java.sql.Date(new java.util.Date().getTime());
           
      
            String golivedateStr = golivedateF.toString();
            String sqlDatefromstr = sqlDate.toString();
         
             if(golivedateStr.compareToIgnoreCase(sqlDatefromstr) == 0) {
                 System.out.println(sqlDate);
             }
            else if(golivedateF.before(sqlDate) && rowStatus == 0 ) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Go Live Date should not be before current date",null));    
                return null;
                
            }
        
            
      
           
        }
        }
        
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doCommit");
        String result = opBinding.execute().toString();   
        if("true".equals(result)) {
            System.out.println(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Beat Details saved successfully.")); 
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","disable");
            
        }
        return null;
    }

    public String View() {
        // Add event code here...
        
        
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("RenderedMode","View");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit");
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.ZoneMstVO1Iterator.currentRow}");
        if(selectedRow != null) 
        {
             zonecode= selectedRow.getAttribute("ZoneCode").toString();
        }
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
        bindingsAM.findIteratorBinding("BeatMstUVO1Iterator");
        ViewObjectImpl BeatMstdtlVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
        ViewObject BeatMstVO = dcItteratorBinding.getViewObject();
        BeatMstVO.executeEmptyRowSet();
        BeatMstVO.setWhereClause(null);
        BeatMstVO.setWhereClauseParams(null);
        BeatMstVO.setWhereClause("Zone_Code = '"+zonecode+"'");
        BeatMstVO.executeQuery();
        
        System.out.println(BeatMstVO.getQuery());
        
        return null;
    }

    public void Cancel(ActionEvent actionEvent) {
        // Add event code here...
        getBindings().getOperationBinding("doRollback").execute();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","disable");
    }
}
