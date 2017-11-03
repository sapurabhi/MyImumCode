package com.imum.cpms.view.backing;

import com.imum.cpms.model.transactions.vo.CashRemarksVOImpl;
import com.imum.cpms.model.transactions.vo.CashRemarksVORowImpl;
import com.imum.cpms.model.transactions.vo.DepositAckDetailsUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;

import oracle.binding.OperationBinding;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import java.sql.Timestamp;

import java.util.Date;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class DepAckDetailMBean {
    
    private Boolean isDisabled;
    private Boolean displayHari = false;
        private Boolean operationsPanel = true;
        private Boolean submissionPanel = false;
        private Boolean cancelPanel = false;
        public static final ADFLogger logger = ADFLogger.createADFLogger(DepAckDetailMBean.class);
    private RichShowDetailHeader depAckDtlsForm;
    private RichInputText depositSlipNum;
    private String depositslipbeforedit;
    private RichTable renderRemarksTable1;
    private RichTable renderRemarksTable2;
    private RichPanelGroupLayout panelAck1;
    private RichPanelGroupLayout panelAck2;
    private RichShowDetailHeader showAck1;

    public DepAckDetailMBean() {
        if(lngcode==null || lngcode.equals(""))
        {
            lngcode = "EN";
        }
    }

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    String lngcode = httpSession.getAttribute("language").toString();
    MessageUtil msgUtil = new MessageUtil();
    
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public String NewAction() {
       
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        //String userName = "anonymous"    ;
        OperationBinding op = getBindings().getOperationBinding("createNewDepAckDtls");
        op.getParamsMap().put("encoder",userName);
        op.execute();
        setOperationsPanel(Boolean.FALSE);
        setSubmissionPanel(Boolean.TRUE);
        setCancelPanel(Boolean.TRUE);
        getDepAckDtlsForm().setVisible(true);
        setIsDisabled(Boolean.FALSE);
        ADFContext.getCurrent().getPageFlowScope().put("actionMode","New");
        setDisplayHari(Boolean.FALSE);
        return null;
    }


    public String EditAction() {
        Date transdateformat=null;
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        //                   String userName = "anonymous"    ;
        ADFContext.getCurrent().getPageFlowScope().put("actionMode","Edit");
                java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
                Row rowSelected = bindingsAM.findIteratorBinding("DepositAckDetailsUVO2Iterator").getViewObject().getCurrentRow();
                if( rowSelected.getAttribute("Depositslipnum") != null)
                depositslipbeforedit = rowSelected.getAttribute("Depositslipnum").toString();
        ADFContext.getCurrent().getPageFlowScope().put("depositslipbeforedit",depositslipbeforedit);
                if(rowSelected != null)
                {
                   Object dptId = rowSelected.getAttribute("DepositAckSeq");
                    logger.info("Selected HolidayId  in Edit_action is : "+dptId);
                    if(dptId != null)
                    {
                        DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator");
                        ViewObject dptAckFormVO = dcItteratorBinding.getViewObject(); 
                        dptAckFormVO.setWhereClause(null);
                        dptAckFormVO.setWhereClause("Deposit_Ack_Seq = "+dptId);
                        dptAckFormVO.executeQuery();
                        DepositAckDetailsUVORowImpl dptAckRow = (DepositAckDetailsUVORowImpl)dptAckFormVO.getCurrentRow();
                        if(dptAckRow != null )
                        {
                            dptAckRow.setUpdatedby(userName);         
                            dptAckRow.setupdateddate(sqlTime);
                            setOperationsPanel(Boolean.FALSE);
                            setSubmissionPanel(Boolean.TRUE);
                            setCancelPanel(Boolean.TRUE);
                            getDepAckDtlsForm().setVisible(true);
                            setIsDisabled(Boolean.FALSE);
                            transdateformat=dptAckRow.getSaleTrnDate();
                        }
                        
                      //vamsi
                      DCIteratorBinding dcItteratorBinding1 = bindingsAM.findIteratorBinding("CashRemarksVO1Iterator");
                      ViewObject remarksvo = dcItteratorBinding1.getViewObject(); 
                    //  CashRemarksVOImpl remarksvo = this.getCashRemarksVO1();
                      if(remarksvo!=null) {
                      remarksvo.setWhereClause(null);
                      remarksvo.setWhereClauseParams(null);
                      //  remarksvo.setWhereClause("Trans_Date ='"+transdateformat+"'");
                     
                      if(transdateformat!=null)
                      {
                      remarksvo.setWhereClause("Trans_Date ='"+transdateformat+"'");
                     
                      remarksvo.executeQuery();
                      int count = remarksvo.getRowCount();
                          setDisplayHari(Boolean.TRUE);
                      CashRemarksVORowImpl rowremarks= (CashRemarksVORowImpl)remarksvo.first();
                      if(rowremarks != null)
                      {
                      String remarks = rowremarks.getDepositSlip();
                      ADFContext.getCurrent().getPageFlowScope().put("Remarks",remarks);
                      }
                      }
                      }
                        
                      
                        //

            }
                    else
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("69",lngcode)));            
                    }
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", msgUtil.getMessage("303", lngcode))); 
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("55",lngcode)));        
                }
        return null;
    }

    public String ViewAction() {
        Date transdateformat=null;
        ADFContext.getCurrent().getPageFlowScope().put("actionMode","View");
        Row rowSelected = bindingsAM.findIteratorBinding("DepositAckDetailsUVO2Iterator").getViewObject().getCurrentRow();
                if(rowSelected != null)
                {
                   Object dptId = rowSelected.getAttribute("DepositAckSeq");
                    logger.info("Selected HolidayId  in View_action is : "+dptId);
                    if(dptId != null)
                    {
                        DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator");
                        ViewObject dptAckFormVO = dcItteratorBinding.getViewObject(); 
                        dptAckFormVO.setWhereClause(null);
                        dptAckFormVO.setWhereClause("Deposit_Ack_Seq = "+dptId);
                        dptAckFormVO.executeQuery();
                        setOperationsPanel(Boolean.FALSE);
                        setSubmissionPanel(Boolean.FALSE);
                        setCancelPanel(Boolean.TRUE);
                        getDepAckDtlsForm().setVisible(true);
                        setIsDisabled(Boolean.TRUE);
                        DepositAckDetailsUVORowImpl dptAckRow = (DepositAckDetailsUVORowImpl)dptAckFormVO.getCurrentRow();
                        if(dptAckRow!=null) {
                            transdateformat=dptAckRow.getSaleTrnDate();
                        }
                        DCIteratorBinding dcItteratorBinding1 = bindingsAM.findIteratorBinding("CashRemarksVO1Iterator");
                        ViewObject remarksvo = dcItteratorBinding1.getViewObject(); 
                        //  CashRemarksVOImpl remarksvo = this.getCashRemarksVO1();
                        if(remarksvo!=null) {
                        remarksvo.setWhereClause(null);
                        remarksvo.setWhereClauseParams(null);
                        //  remarksvo.setWhereClause("Trans_Date ='"+transdateformat+"'");
                        
                        if(transdateformat!=null)
                        {
                        remarksvo.setWhereClause("Trans_Date ='"+transdateformat+"'");
                        
                        remarksvo.executeQuery();
                        int count = remarksvo.getRowCount();
                            setDisplayHari(Boolean.TRUE);
                        CashRemarksVORowImpl rowremarks= (CashRemarksVORowImpl)remarksvo.first();
                        if(rowremarks != null)
                        {
                        String remarks = rowremarks.getDepositSlip();
                        ADFContext.getCurrent().getPageFlowScope().put("Remarks",remarks);
                        }
                        }
                        }      
                    }
                    
                    
                    
                    else
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("69",lngcode)));            
                    }
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", msgUtil.getMessage("303", lngcode)));  
                   // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("54",lngcode)));        
                }
        return null;
    }

    public String SubmitAction() {
            
        Boolean result = validateDepAckDtls();
                if(result)
                {
                    
                    OperationBinding op = getBindings().getOperationBinding("doCommit");
                    op.execute();  
                    if(op.getErrors().isEmpty())
                    {
                    
                        DCIteratorBinding dcItteratorDtl = bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator");
                        bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator").executeQuery();
                        bindingsAM.findIteratorBinding("DepositAckDetailsUVO2Iterator").executeQuery();
                        ViewObject dptAckVO = dcItteratorDtl.getViewObject();
                        DepositAckDetailsUVORowImpl dptAckRow = (DepositAckDetailsUVORowImpl)dptAckVO.getCurrentRow();  
        //                if (ADFContext.getCurrent().getPageFlowScope().get("actionMode") != null && ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New")) {
        //                    OperationBinding opBindingSequence = bindingsAM.getOperationBinding("updateHolidaySequence");
        //                    opBindingSequence.getParamsMap().put("holidaySequence", holidayRow.getHolidayId());
        //                    opBindingSequence.execute();
        //                    System.out.println("Holiday sequence updated to ..." + holidayRow.getHolidayId());    
        //                    ADFContext.getCurrent().getPageFlowScope().put("actionMode", null);
        //                }
                        
        
            String depslipNum = dptAckRow.getDepositslipnum();
            
            BigDecimal depositAckSeqbigD = dptAckRow.getDepositAckSeq();
            if(depslipNum != null)
            {
            String depositslipnum = null;
            if(ADFContext.getCurrent().getPageFlowScope().get("Remarks")!= null)
             depositslipnum =   ADFContext.getCurrent().getPageFlowScope().get("Remarks").toString();
             if( ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New")) 
             {
              if(depositslipnum != null)
              {
                if(!depositslipnum.equals(depslipNum))
                {
                String userName = httpSession.getAttribute("loggedinUserid").toString();
                OperationBinding op1 = getBindings().getOperationBinding("CreateGenEventDetails");
                op1.getParamsMap().put("depositAckSeqbigD",depositAckSeqbigD);
                op1.getParamsMap().put("NewDepSlip",depslipNum);
                 op1.getParamsMap().put("OldDepSlip",depositslipnum);
                op1.getParamsMap().put("encoder",userName);
                op1.getParamsMap().put("EventId",701);
                
                op1.execute();
            }
             }
             }
            else if( ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("Edit")) 
             {
                
                 if(ADFContext.getCurrent().getPageFlowScope().get("depositslipbeforedit") != null)
                 {
                 if(ADFContext.getCurrent().getPageFlowScope().get("depositslipbeforedit")!=depslipNum)
                 {
                     
                 String userName = httpSession.getAttribute("loggedinUserid").toString();
                 OperationBinding op2 = getBindings().getOperationBinding("CreateGenEventDetails");
                 op2.getParamsMap().put("depositAckSeqbigD",depositAckSeqbigD);
                 op2.getParamsMap().put("NewDepSlip",depslipNum);
                  op2.getParamsMap().put("OldDepSlip",ADFContext.getCurrent().getPageFlowScope().get("depositslipbeforedit"));
                 op2.getParamsMap().put("encoder",userName);
                 op2.getParamsMap().put("EventId",701);
                 op2.execute();
             }
             } 
             }
            }
                        OperationBinding op5 = getBindings().getOperationBinding("doCommit");
                        op5.execute();  
        
                        setOperationsPanel(Boolean.TRUE);
                        setSubmissionPanel(Boolean.FALSE);
                        setCancelPanel(Boolean.FALSE);
                       getDepAckDtlsForm().setVisible(false);
                       /* Refresh the table with latest result */
                        bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator").executeQuery();
                        bindingsAM.findIteratorBinding("DepositAckDetailsUVO2Iterator").executeQuery();
                        /* end */
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", msgUtil.getMessage("70",lngcode)));       
                         // bindingsAM.findIteratorBinding("DepositAckDetailsUVO2Iterator").getViewObject().executeQuery();
                    }
                    else
                    {
                        setOperationsPanel(Boolean.FALSE);
                        setSubmissionPanel(Boolean.TRUE);
                        setCancelPanel(Boolean.TRUE);
                        getDepAckDtlsForm().setVisible(true);
                        setIsDisabled(Boolean.FALSE);        
                    }
                } 
                else
                {
                    setOperationsPanel(Boolean.FALSE);
                    setSubmissionPanel(Boolean.TRUE);
                    setCancelPanel(Boolean.TRUE);
                    getDepAckDtlsForm().setVisible(true);
                    setIsDisabled(Boolean.FALSE);    
                }
                return null;
            }

    public String CancelAction() {
        setOperationsPanel(Boolean.TRUE);
        setSubmissionPanel(Boolean.FALSE);
        setCancelPanel(Boolean.FALSE);
 
        getDepAckDtlsForm().setVisible(false);
        getBindings().getOperationBinding("doRollback").execute();
       // bindingsAM.findIteratorBinding("DepositAckDetailsUVO2Iterator").getViewObject().executeQuery();
        return null;
    }

    public Boolean validateDepAckDtls()
       {
       Boolean result = true;
           DCIteratorBinding depAckVOIter =
               bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator");
           ViewObjectImpl depAckVO = (ViewObjectImpl)depAckVOIter.getViewObject();
           if(depAckVO != null)
           {
               DepositAckDetailsUVORowImpl depAckRow = (DepositAckDetailsUVORowImpl)depAckVO.getCurrentRow();   
               if(depAckRow != null)
               {
                   System.out.println("DepAck Id in validateDepAckDtls is : "+depAckRow.getDepositAckSeq());
                  
                   BigDecimal depositAckSeqbigD = depAckRow.getDepositAckSeq();
                   Object bankInfo = depAckRow.getBankAccinfoSeq();
                   Timestamp depDate = depAckRow.getDepositeDate();
                   Object slipAmt = depAckRow.getDepositeSlipAmt();
                   Timestamp slipAckDate = depAckRow.getDepositeSlipAckDate();
                   Object depslipNum = depAckRow.getDepositslipnum();
                   Object loc = depAckRow.getCashSource();
                   Timestamp saleTrnDate = depAckRow.getSaleTrnDate();
                   Object ackSlipNum = depAckRow.getAckslipnum();
                   Object expAmt = depAckRow.getExpectedAmt();
                   Object locId = depAckRow.getLOCATIONID();
                   if(bankInfo == null || bankInfo.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("71",lngcode)));            
                        result = false;  
                    }
                   if(depDate == null || depDate.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("72",lngcode)));            
                        result = false;  
                    }
                   if(slipAmt == null || slipAmt.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("73",lngcode)));            
                        result = false;  
                    }
                   if(slipAckDate == null || slipAckDate.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("74",lngcode)));            
                        result = false;  
                    }
                   if(depslipNum == null || depslipNum.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("75",lngcode)));            
                        result = false;  
                    }
                 
                   if(loc == null || loc.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("76",lngcode)));            
                        result = false;  
                    }
                   if(saleTrnDate == null || saleTrnDate.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("77",lngcode)));            
                        result = false;  
                    }
                   if(ackSlipNum == null || ackSlipNum.equals(""))
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("78",lngcode)));            
                        result = false;  
                    }
                   java.sql.Date sysDate = new java.sql.Date(new java.util.Date().getTime());
                   if(result && ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New") && depDate.after(sysDate))
                   {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("79",lngcode)));            
                       result = false;      
                   }
                   if(result && ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New") && slipAckDate.after(sysDate))
                   {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("80",lngcode)));            
                       result = false;      
                   }
                   if(result && ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New") && saleTrnDate.after(sysDate))
                   {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("81",lngcode)));            
                       result = false;      
                   }
//                   if(expAmt==null)//Call for the 1st click of submit on New
//                   {
//                         getBindings().getOperationBinding("fetchExpectedAmt").execute(); 
//                        result =(Boolean)getBindings().getOperationBinding("fetchExpectedAmt").getResult();
//                        if(!result)
//                        {
//                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Day End settlement details do not exist for Sale Transaction Date and Location combination"));                
//                            result = false;
//                        }
//                        else
//                        {
//                        expAmt = depAckRow.getExpectedAmt();
//                        }
//                    }
                   if(locId!=null && saleTrnDate!=null)
                   {
                        OperationBinding op = getBindings().getOperationBinding("fetchExpectedAmt");
                        op.getParamsMap().put("tranDate",saleTrnDate.toString());
                        op.getParamsMap().put("locId",locId.toString());
                      
                        op.execute(); 
                        Boolean expAmtResult =(Boolean)op.getResult();
                        if(!expAmtResult)
                        {
                           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("82",lngcode)));                
                           result = false;
                        }
                    }
                    if(result && expAmt != null)
                    {
                        result = validateDispFlag();           
                    }                           
               }
           }
       return result;    
       }
    public Boolean validateDispFlag()
    {
        Boolean result = true;
        DCIteratorBinding depAckVOIter =
            bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator");
        ViewObjectImpl depAckVO = (ViewObjectImpl)depAckVOIter.getViewObject();
        if(depAckVO != null)
        {
            DepositAckDetailsUVORowImpl depAckRow = (DepositAckDetailsUVORowImpl)depAckVO.getCurrentRow();   
            if(depAckRow != null)
            {
                Object slipAmt = depAckRow.getDepositeSlipAmt();
                Object expAmt = depAckRow.getExpectedAmt();
                Object dispFlag = depAckRow.getDiscrepancyflag();
                System.out.println("Slip Amt is : "+slipAmt+" Exp Amt : "+expAmt+" Disp Flag is : "+dispFlag); 
                String slipAmtStr = null;
                String expAmtStr  = null;
                if(slipAmt != null  && slipAmt.toString().contains("."))
                {
                     slipAmtStr = slipAmt.toString().substring(0,slipAmt.toString().indexOf("."));                        
                 }
                else
                {
                    if(slipAmt!=null)
                    {
                        slipAmtStr = slipAmt.toString();    
                    }
                    else
                    {
                        result = false;     
                    }
                }
                if(expAmt != null  && expAmt.toString().contains("."))
                {
                     expAmtStr = expAmt.toString().substring(0,expAmt.toString().indexOf("."));
                 }
                else
                {
                    if(expAmt!=null)
                    {
                        expAmtStr = expAmt.toString();   
                    }
                    else
                    {
                        result = false;     
                    }
                }
                System.out.println("Slip Amt Str is : "+slipAmtStr+" Exp Amt str : "+expAmtStr); 
                if(result && expAmtStr!=null && slipAmtStr!=null &&  !expAmtStr.equals(slipAmtStr) && dispFlag.equals("N"))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("83",lngcode)));            
                    result = false;     
                }
                if(result && expAmtStr!=null && slipAmtStr!=null &&  expAmtStr.equals(slipAmtStr) && dispFlag.equals("Y"))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("84",lngcode)));            
                    result = false;     
                }
            }
        }
        return result;
    }
    public void fetchExpAmt(ValueChangeEvent valueChangeEvent) {
        if(valueChangeEvent.getNewValue() != null)
        {
            Boolean goAhead = checkLocTransDate("trnDate");
            Object tranDate = valueChangeEvent.getNewValue();  
            Date  tranDateformat = (Date) valueChangeEvent.getNewValue();
            System.out.println("tranDate in valuChangeEvent is : "+tranDate);
            DepositAckDetailsUVORowImpl depAckRow = (DepositAckDetailsUVORowImpl)
                bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator").getViewObject().getCurrentRow(); 
            CashRemarksVORowImpl remarksrow = (CashRemarksVORowImpl)
                bindingsAM.findIteratorBinding("CashRemarksVO1Iterator").getViewObject().first();
            setDisplayHari(Boolean.TRUE);
                if(depAckRow != null)
                {
                    Object locID = depAckRow.getLOCATIONID();
                    if(goAhead && tranDate != null && locID!=null)
                    {
                        OperationBinding op = getBindings().getOperationBinding("fetchExpectedAmt");
                        op.getParamsMap().put("tranDate",tranDate.toString());
                        op.getParamsMap().put("locId",locID.toString());
                        op.getParamsMap().put("transdateformat",tranDateformat);
                        
                        op.execute();
                        Boolean result =(Boolean)op.getResult();
                      
                        if(!result)
                        {
                           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("82",lngcode)));                
                           result = false;
                        }
                    }
                }  
                if(remarksrow != null) 
                {
                    String depositslipnum  = null;
                    if(ADFContext.getCurrent().getPageFlowScope().get("Remarks") != null)
                     depositslipnum =   ADFContext.getCurrent().getPageFlowScope().get("Remarks").toString();
                    depositSlipNum.setValue(depositslipnum);
                   
        
                    //ADFContext.getCurrent().getPageFlowScope().put("DisplayHari","true"); 
//                    AdfFacesContext.getCurrentInstance().addPartialTarget(panelAck1);
                  AdfFacesContext.getCurrentInstance().addPartialTarget(renderRemarksTable2);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(panelAck1);
                }
        }       

    }
    public Boolean checkLocTransDate(String fromField)
    {
        Boolean result = true;
        DCIteratorBinding depAckVOIter =
            bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator");
        ViewObjectImpl depAckVO = (ViewObjectImpl)depAckVOIter.getViewObject();
        if(depAckVO != null)
        {
            DepositAckDetailsUVORowImpl depAckRow = (DepositAckDetailsUVORowImpl)depAckVO.getCurrentRow();   
            if(depAckRow != null)
            {
                Object locID = depAckRow.getLOCATIONID();
                Object saleTrnDate = depAckRow.getSaleTrnDate();
                if(fromField.equals("trnDate"))
                {
                    if(locID==null)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("85",lngcode)));                
                        result = false;   
                    }                   
                }  
               else if(fromField.equals("location"))
                {
                    if(saleTrnDate==null)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("86",lngcode)));                
                        result = false;   
                    }                   
                }
            }
        }
        
        return result;
    }
    public void calExpAmount(ValueChangeEvent valueChangeEvent) {
        if(valueChangeEvent.getNewValue() != null)
        {
            Boolean goAhead = checkLocTransDate("location");
            JUCtrlListBinding listBinding =(JUCtrlListBinding)getBindings().get("LOCATIONID");
            listBinding.setSelectedIndex(Integer.parseInt(valueChangeEvent.getNewValue().toString()));
            Row selectedValue = (Row) listBinding.getSelectedValue();
            Integer locId = (Integer)selectedValue.getAttribute("LocationId");
            System.out.println("locId in valuChangeEvent is : "+locId);        
            DepositAckDetailsUVORowImpl depAckRow = (DepositAckDetailsUVORowImpl)
                bindingsAM.findIteratorBinding("DepositAckDetailsUVO1Iterator").getViewObject().getCurrentRow(); 
                if(depAckRow != null)
                {
                    Object saleTrnDate = depAckRow.getSaleTrnDate();
                    if(goAhead && locId != null && saleTrnDate!=null)
                    {
                        OperationBinding op = getBindings().getOperationBinding("fetchExpectedAmt");
                        op.getParamsMap().put("tranDate",saleTrnDate.toString());
                        op.getParamsMap().put("locId",locId.toString());
                        op.getParamsMap().put("transdateformat","");
                        op.execute();
                        Boolean result =(Boolean)op.getResult();
                        if(!result)
                        {
                           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", msgUtil.getMessage("82",lngcode)));                
                           result = false;
                        }
                    }
                }    
        }              
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

    public void setDepAckDtlsForm(RichShowDetailHeader depAckDtlsForm) {
        this.depAckDtlsForm = depAckDtlsForm;
    }

    public RichShowDetailHeader getDepAckDtlsForm() {
        return depAckDtlsForm;
    }

    public void setDepositSlipNum(RichInputText depositSlipNum) {
        this.depositSlipNum = depositSlipNum;
    }

    public RichInputText getDepositSlipNum() {
        return depositSlipNum;
    }

    public void setRenderRemarksTable1(RichTable renderRemarksTable1) {
        this.renderRemarksTable1 = renderRemarksTable1;
    }

    public RichTable getRenderRemarksTable1() {
        return renderRemarksTable1;
    }

    public void setRenderRemarksTable2(RichTable renderRemarksTable2) {
        this.renderRemarksTable2 = renderRemarksTable2;
    }

    public RichTable getRenderRemarksTable2() {
        return renderRemarksTable2;
    }

    public void setPanelAck1(RichPanelGroupLayout panelAck1) {
        this.panelAck1 = panelAck1;
    }

    public RichPanelGroupLayout getPanelAck1() {
        return panelAck1;
    }

    public void setPanelAck2(RichPanelGroupLayout panelAck2) {
        this.panelAck2 = panelAck2;
    }

    public RichPanelGroupLayout getPanelAck2() {
        return panelAck2;
    }

    public void setShowAck1(RichShowDetailHeader showAck1) {
        this.showAck1 = showAck1;
    }

    public RichShowDetailHeader getShowAck1() {
        return showAck1;
    }

    public void setDisplayHari(Boolean displayHari) {
        this.displayHari = displayHari;
    }

    public Boolean getDisplayHari() {
        return displayHari;
    }
}
