package com.imum.cpms.view.backing;

import com.imum.cpms.model.masters.vo.ContraventionMstUVORowImpl;

import com.imum.cpms.model.masters.vo.HolidayMstUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.sql.Date;

import java.sql.Time;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class HolidayMstMBean {
    private RichCommandButton submitCancel;
    
    private RichShowDetailHeader holidayDetailsForm;
    private Boolean isDisabled;
    private Boolean operationsPanel = true;
    private Boolean submissionPanel = false;
    private Boolean cancelPanel = false;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    public static final ADFLogger logger = ADFLogger.createADFLogger(HolidayMstMBean.class);
    MessageUtil genMsg = new MessageUtil();
    String lgCode = httpSession.getAttribute("language").toString();


    public HolidayMstMBean() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
    }
    
   
    
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String NewHoliday() {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
//           String userName = "anonymous"    ;
        OperationBinding op =
            getBindings().getOperationBinding("createNewHoliday");
        op.getParamsMap().put("encoder",userName);
        op.execute();
        setOperationsPanel(Boolean.FALSE);
        setSubmissionPanel(Boolean.TRUE);
        setCancelPanel(Boolean.TRUE);
        getHolidayDetailsForm().setVisible(true);
        setIsDisabled(Boolean.FALSE);
        ADFContext.getCurrent().getPageFlowScope().put("actionMode","New");
        return null;
    }

    public String EditHoliday() {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
//           String userName = "anonymous"    ;
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("HolidayMstUVO2Iterator");
        ViewObject holidayReadOnlyVO = dcItteratorBindings.getViewObject();
        Row rowSelected = holidayReadOnlyVO.getCurrentRow();
        if(rowSelected != null)
        {
           Integer holidayId = (Integer)rowSelected.getAttribute("HolidayId");
            logger.info("Selected HolidayId  in Edit_action is : "+holidayId);
            if(holidayId != null)
            {
                DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("HolidayMstUVO1Iterator");
                ViewObject holidayFormVO = dcItteratorBinding.getViewObject(); 
                holidayFormVO.setWhereClause(null);
                holidayFormVO.setWhereClause("Holiday_Id = "+holidayId);
                holidayFormVO.executeQuery();
                HolidayMstUVORowImpl holiRow = (HolidayMstUVORowImpl)holidayFormVO.getCurrentRow();
                if(holiRow != null )
                {
                    holiRow.setUpdatedby(userName);         
                    holiRow.setUpdatedate(sqlTime);
                    setOperationsPanel(Boolean.FALSE);
                    setSubmissionPanel(Boolean.TRUE);
                    setCancelPanel(Boolean.TRUE);
                    getHolidayDetailsForm().setVisible(true);
                    setIsDisabled(Boolean.FALSE);
                }
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("61", lgCode)));            
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lgCode))); 
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",  genMsg.getMessage("55", lgCode)));        
        }
        
        return null;
    }

    public String ViewHoliday() {
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("HolidayMstUVO2Iterator");
        ViewObject holidayReadOnlyVO = dcItteratorBindings.getViewObject();
        Row rowSelected = holidayReadOnlyVO.getCurrentRow();
        if(rowSelected != null)
        {
           Integer holidayId = (Integer)rowSelected.getAttribute("HolidayId");
            logger.info("Selected HolidayId  in View_action is : "+holidayId);
            if(holidayId != null)
            {
                DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("HolidayMstUVO1Iterator");
                ViewObject holidayFormVO = dcItteratorBinding.getViewObject(); 
                holidayFormVO.setWhereClause(null);
                holidayFormVO.setWhereClause("Holiday_Id = "+holidayId);
                holidayFormVO.executeQuery();
                setOperationsPanel(Boolean.FALSE);
                setSubmissionPanel(Boolean.FALSE);
                setCancelPanel(Boolean.TRUE);
                getHolidayDetailsForm().setVisible(true);
                setIsDisabled(Boolean.TRUE);
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("61", lgCode)));            
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lgCode))); 
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("54", lgCode)));        
        }
        return null;
    }

    public String SubmitHoliday() {
        Boolean result = validateHolidayData();
        if(result)
        {
            OperationBinding op = getBindings().getOperationBinding("doCommit");
            op.execute();  
            if(op.getErrors().isEmpty())
            {
                DCIteratorBinding dcItteratorDtl = bindingsAM.findIteratorBinding("HolidayMstUVO1Iterator");
                ViewObject holidayVO = dcItteratorDtl.getViewObject();
                HolidayMstUVORowImpl holidayRow = (HolidayMstUVORowImpl)holidayVO.getCurrentRow();
                if (ADFContext.getCurrent().getPageFlowScope().get("actionMode") != null && ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New")) {
                    OperationBinding opBindingSequence = bindingsAM.getOperationBinding("updateHolidaySequence");
                    opBindingSequence.getParamsMap().put("holidaySequence", holidayRow.getHolidayId());
                    opBindingSequence.execute();
                    System.out.println("Holiday sequence updated to ..." + holidayRow.getHolidayId());    
                    ADFContext.getCurrent().getPageFlowScope().put("actionMode", null);
                }
                
                setOperationsPanel(Boolean.TRUE);
                setSubmissionPanel(Boolean.FALSE);
                setCancelPanel(Boolean.FALSE);
                getHolidayDetailsForm().setVisible(false);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("26", lgCode)));         
                  bindingsAM.findIteratorBinding("HolidayMstUVO2Iterator").getViewObject().executeQuery();
            }   
        } 
        else
        {
            setOperationsPanel(Boolean.FALSE);
            setSubmissionPanel(Boolean.TRUE);
            setCancelPanel(Boolean.TRUE);
            getHolidayDetailsForm().setVisible(true);
            setIsDisabled(Boolean.FALSE);    
        }
        return null;
    }

    public String CancelHoliday() {
        setOperationsPanel(Boolean.TRUE);
        setSubmissionPanel(Boolean.FALSE);
        setCancelPanel(Boolean.FALSE);
        getHolidayDetailsForm().setVisible(false);
        getBindings().getOperationBinding("doRollback").execute();
        bindingsAM.findIteratorBinding("HolidayMstUVO2Iterator").getViewObject().executeQuery();
        return null;
    }
   
   public Boolean validateHolidayData()
   {
   Boolean result = true;
       DCIteratorBinding holdVOIter =
           bindingsAM.findIteratorBinding("HolidayMstUVO1Iterator");
       ViewObjectImpl holVO = (ViewObjectImpl)holdVOIter.getViewObject();
       if(holVO != null)
       {
           HolidayMstUVORowImpl holRow = (HolidayMstUVORowImpl)holVO.getCurrentRow();   
           if(holRow != null)
           {
               System.out.println("Holiday Id in validateHolidayData is : "+holRow.getHolidayId());
               Object groupId = holRow.getGroupId();
               Object type = holRow.getHolidayType();
               Object desc = holRow.getHolidayDesc();
               String holYear = holRow.getHolidayYear();
               Object holDate = holRow.getHolidayDate();
               Time startHrs = holRow.getOperationHrstart();
               Time endHrs = holRow.getOperationHrEnd();
               if(groupId == null || groupId.equals(""))
               {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("18",lgCode)));            
                    result = false;  
                }               
               if(holYear == null || holYear.equals(""))
               {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("63", lgCode)));            
                    result = false;   
                }
               if(holDate == null || holDate.equals(""))
               {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("64", lgCode)));            
                    result = false;   
                }
               if(desc == null || desc.equals(""))
               {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("65", lgCode)));            
                    result = false;   
               }
               if(type == null || type.equals(""))
               {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("66", lgCode)));            
                    result = false;   
                }               
               if(holDate != null && result)
               {
                    String holDateStr = holDate.toString();  
                    if(!holDateStr.contains(holYear))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("67", lgCode)));            
                        result = false;
                    }   
                }
               String decBy = holRow.getDeclaredBy();
               String reqBy = holRow.getRequestedBy();
               if(decBy != null && reqBy != null)
               {
                    if(decBy.equalsIgnoreCase(reqBy))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("68", lgCode)));            
                        result = false;   
                    }
               }
               if(startHrs != null && endHrs != null)
               {
                   if(endHrs.before(startHrs))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("293", lgCode)));            
                        result = false;      
                    }
                }
           }           
       }
   return result;    
   }

    public void setHolidayDetailsForm(RichShowDetailHeader holidayDetailsForm) {
        this.holidayDetailsForm = holidayDetailsForm;
    }

    public RichShowDetailHeader getHolidayDetailsForm() {
        return holidayDetailsForm;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setOperationsPanel(Boolean operationsPanel) {
        this.operationsPanel = operationsPanel;
    }

    public Boolean getOperationsPanel() {
        return operationsPanel;
    }

    public void setSubmissionPanel(Boolean submissionPanel) {
        this.submissionPanel = submissionPanel;
    }

    public Boolean getSubmissionPanel() {
        return submissionPanel;
    }

    public void setCancelPanel(Boolean cancelPanel) {
        this.cancelPanel = cancelPanel;
    }

    public Boolean getCancelPanel() {
        return cancelPanel;
    }
}
