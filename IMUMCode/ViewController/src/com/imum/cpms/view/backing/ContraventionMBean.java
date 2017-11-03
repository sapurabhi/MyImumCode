package com.imum.cpms.view.backing;

import com.imum.cpms.model.masters.vo.ContraventionMstUVORowImpl;
import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;
import com.imum.cpms.model.transactions.vo.CardTypeMstUVORowImpl;
import com.imum.cpms.transactions.inventory.CardTypeMstMBean;

import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import java.sql.Date;

import java.sql.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;


import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class ContraventionMBean {
    
    
    private RichCommandButton submitBottom;
    private RichCommandButton cancelBottom;
    private Boolean isDisabled;
    private RichCommandButton submitTop;
    private RichCommandButton cancelTop;
    private RichShowDetailHeader cntrCodeForm;
    private RichCommandButton newBtn;
    private RichCommandButton editBtn;
    private RichCommandButton viewBtn;
    private RichInputText obsTime;
    private Integer contracode;
    private RichShowDetailHeader exceptionzone;
    private RichSelectOneChoice zonecode;
    private RichCommandImageLink addrowbind;
    private RichSelectBooleanCheckbox actflag;


    public ContraventionMBean() {
        if(lngCode==null || lngCode.equals(""))
            {
             lngCode = "EN";
            }
    }

  MessageUtil genMsg = new MessageUtil();
  FacesContext facesContext = FacesContext.getCurrentInstance();
  ExternalContext externalContext = facesContext.getExternalContext();
  HttpSession httpSession = (HttpSession)externalContext.getSession(false);
  String lngCode = httpSession.getAttribute("language").toString();
    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());


  DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger = ADFLogger.createADFLogger(ContraventionMBean.class);
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String New_action() {
        logger.info("Inside New_Action of ContraventionMBean");
        setIsDisabled(Boolean.FALSE);
      String userName = httpSession.getAttribute("loggedinUserid").toString();
         //  String userName = "cpms";
           
        OperationBinding operationBinding = bindings.getOperationBinding("addNewContrMst");
        operationBinding.getParamsMap().put("encoder",userName);
        operationBinding.execute();
        getCntrCodeForm().setVisible(true);
        getSubmitBottom().setVisible(true);
        getCancelBottom().setVisible(true);
        getSubmitTop().setVisible(true);
        getCancelTop().setVisible(true);
        getNewBtn().setVisible(false);
        getEditBtn().setVisible(false);
        getViewBtn().setVisible(false);
        
        ADFContext.getCurrent().getPageFlowScope().put("actionMode", "New");
        return null;
    }

    public String Submit_action() {
        String result = validateContrMst();
        if(result.equals("pass"))
        {
            OperationBinding operationBinding = bindings.getOperationBinding("doCommit");
            operationBinding.execute();
            
            String actionMode=(String)ADFContext.getCurrent().getPageFlowScope().get("actionMode");
            
            //Contravention Master Language Code Start
            
            DCIteratorBinding binding =bindingsAM.findIteratorBinding("ContraventionMstUVO1Iterator");                              
            String language = (String)binding.getViewObject().getCurrentRow().getAttribute("Language");
            String selectedLanguage = httpSession.getAttribute("language").toString();
            String locNameLng = (String)binding.getViewObject().getCurrentRow().getAttribute("ContraCodeLng");
            String locationName = (String)binding.getViewObject().getCurrentRow().getAttribute("CodeNameEn");
            
            if(language!=null && language.equalsIgnoreCase(selectedLanguage)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("288", lngCode)));
                return "true";
            }
            
            //Getting Newly inserted values
            DCIteratorBinding dcItteratorCon =bindingsAM.findIteratorBinding("ContraventionMstUVO1Iterator");   
            ViewObject conVO = dcItteratorCon.getViewObject();
           // conVO.executeQuery();
            ContraventionMstUVORowImpl conMstRow = (ContraventionMstUVORowImpl)conVO.getCurrentRow();              
            Integer con_code = conMstRow.getContraCode();
            
            ViewObject locMstLngVo = getContraventionMstLngVO();
            if(actionMode!=null && actionMode.equalsIgnoreCase("edit") ){                    
                RowSetIterator locIterator =getContraventionMstLngVO().createRowSetIterator(null);
                while (locIterator.hasNext()) {
                oracle.jbo.Row locRow = locIterator.next();
                   if(locRow!=null){
                               String selectLang=locRow.getAttribute("LNGCODE").toString();
                                if("EN".equalsIgnoreCase(selectLang)){
                                    locRow.setAttribute("CodeName",locationName);
                                }else{
                                    locRow.setAttribute("CodeName",locNameLng);
                                }                                                 
                                locRow.setAttribute("Updatedby",httpSession.getAttribute("loggedinUserid").toString());
                                locRow.setAttribute("Updatedate",sqlDate);                                   
                            }
                }              
            }else if(actionMode!=null && (actionMode.equalsIgnoreCase("new") )){
                for(int i=0;i<2;i++){
                    oracle.jbo.Row newRow = locMstLngVo.createRow();
                    newRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
                    newRow.setAttribute("CreatedDate",sqlDate);
                    newRow.setAttribute("ContraCode",con_code);
                    if(i==0){
                        newRow.setAttribute("LNGCODE",httpSession.getAttribute("language").toString());
                        newRow.setAttribute("CodeName",locationName);
                    }else{
                        newRow.setAttribute("LNGCODE",language);
                        newRow.setAttribute("CodeName",locNameLng);
                    }                  
                    locMstLngVo.insertRow(newRow); 
                }   
            }                                  
            locMstLngVo.executeQuery(); 
            getBindings().getOperationBinding("doCommit").execute();
            //Contravention Master Language Code End
            DCBindingContainer bindings =(DCBindingContainer)getBindings();
            DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("PVTExceptionzoneVO1Iterator");
            ViewObject exceptVO = dcIteratorBinding.getViewObject();
            exceptVO.executeEmptyRowSet();
            
            
            if(operationBinding.getErrors().isEmpty())
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("24",lngCode)));         
                DCIteratorBinding dcItteratorBinding =
                    bindingsAM.findIteratorBinding("ContraventionMstUVO2Iterator");
                dcItteratorBinding.getViewObject().executeQuery();
                getCntrCodeForm().setVisible(false);
                getSubmitBottom().setVisible(false);
                getCancelBottom().setVisible(false);
                getSubmitTop().setVisible(false);
                getCancelTop().setVisible(false);
                getNewBtn().setVisible(true);
                getEditBtn().setVisible(true);
                getViewBtn().setVisible(true);
                getObsTime().setDisabled(true);
                getAddrowbind().setDisabled(true);
                
                //exceptionzone.setVisible(false);
            }
        }
        
        return null;
    }

    public String validateContrMst()
    {
      String result = "pass";
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("ContraventionMstUVO1Iterator");
        ViewObject cntrCodeVO = dcItteratorBinding.getViewObject();
            ContraventionMstUVORowImpl cntrCodeRow = (ContraventionMstUVORowImpl)cntrCodeVO.getCurrentRow();
            if(cntrCodeRow != null)
            {
                Object code = cntrCodeRow.getContraCode();
                Object name = cntrCodeRow.getCodeNameEn();
                Object country = cntrCodeRow.getCountryCode();
                Date fromDate = cntrCodeRow.getValidFrom();
                System.out.println("From Date in validate Contravention code method is : "+fromDate);
                Date toDate = cntrCodeRow.getValidTo();
                System.out.println("To Date in validate Contravention code method is : "+toDate);
                Date lawDate = cntrCodeRow.getLawVerDt();
                Object baseCost = cntrCodeRow.getBaseCostAmt();
                Object remReqFlag = cntrCodeRow.getRemovalReqflag();
                Object obsReqFlag = cntrCodeRow.getObservreqflag();
                if(code == null || code.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("41",lngCode)));    
                    result = "fail";    
                }
                if(name == null || name.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("42",lngCode)));    
                    result = "fail";    
                }
                if(result.equalsIgnoreCase("pass")&& country == null || country.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("215",lngCode)));    
                    result = "fail";    
                }
                if(result.equalsIgnoreCase("pass")&& baseCost == null || baseCost.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("43",lngCode)));    
                    result = "fail";     
                }
                if(result.equalsIgnoreCase("pass")&& fromDate == null || fromDate.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("44",lngCode)));    
                    result = "fail";    
                }
                if(result.equalsIgnoreCase("pass")&& toDate == null || toDate.equals(""))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("45",lngCode)));    
                    result = "fail";    
                }
                if(obsReqFlag != null && obsReqFlag.equals("Y"))
                {
                    Object obsTime = cntrCodeRow.getObservTime();
                    if(obsTime==null)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("46",lngCode)));    
                        result = "fail";        
                    }
                }
                if(remReqFlag != null && remReqFlag.equals("N"))
                {
                    Object noOfPVT = cntrCodeRow.getEnfreqPVTcnt();
                    Object noOfDays = cntrCodeRow.getEnfreqdays();
                    if( noOfPVT==null || noOfPVT.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("47",lngCode)));    
                        result = "fail";        
                    }
                    if(noOfDays==null || noOfDays.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("48",lngCode)));    
                        result = "fail";        
                    }
                }
                java.sql.Date sysDate = new java.sql.Date(new java.util.Date().getTime());
                java.sql.Date SysDate = java.sql.Date.valueOf(sysDate.toString());
                System.out.println("SysDate in validate Contravention code method is : "+sysDate);
                if(result.equalsIgnoreCase("pass")&& fromDate != null && toDate != null)
                {
                    java.sql.Date FromDate = java.sql.Date.valueOf(fromDate.toString());
                    java.sql.Date ToDate = java.sql.Date.valueOf(toDate.toString());
                   
                    if(result.equalsIgnoreCase("pass") && ADFContext.getCurrent().getPageFlowScope().get("actionMode").equals("New") && FromDate.compareTo(SysDate)<0)                    
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("49",lngCode)));    
                        result = "fail";       
                    }
                    if(result.equalsIgnoreCase("pass")&& ToDate.compareTo(SysDate)<0)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("50",lngCode)));    
                        result = "fail";       
                    }
                    if(result.equalsIgnoreCase("pass")&& ToDate.compareTo(FromDate)<0)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("51",lngCode)));    
                        result = "fail";       
                    }
                }
                if(result.equalsIgnoreCase("pass") && lawDate != null)
                {
                    java.sql.Date LawDate = java.sql.Date.valueOf(lawDate.toString());
                    if(LawDate.compareTo(SysDate)>0)
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("52",lngCode)));    
                        result = "fail";      
                    }
                }
            }
            
      return result;
    }
    public String View_action() {
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("ContraventionMstUVO2Iterator");
        ViewObject contrCodeReadOnlyVO = dcItteratorBindings.getViewObject();
       
        Row rowSelected = contrCodeReadOnlyVO.getCurrentRow();
        if(rowSelected != null)
        {
           Integer contraCode = (Integer)rowSelected.getAttribute("ContraCode");
            logger.info("Selected ContraventionCode  in View_action is : "+contraCode);
            if(contraCode != null)
            {
                DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("ContraventionMstUVO1Iterator");
                ViewObject contrCodeFormVO = dcItteratorBinding.getViewObject();
                contrCodeFormVO.setWhereClause(null);
                contrCodeFormVO.setWhereClause("Contra_Code = "+contraCode);
                contrCodeFormVO.executeQuery();
                DCIteratorBinding dcItteratorBinding1 = bindingsAM.findIteratorBinding("PVTExceptionzoneVO1Iterator");
                ViewObject ExceptionzoneVO = dcItteratorBinding1.getViewObject();                   
                ExceptionzoneVO.setWhereClause(null);
                ExceptionzoneVO.setWhereClause("CONTRA_CODE = "+contraCode);
                ExceptionzoneVO.executeQuery();
                ViewObjectImpl mstVO = (ViewObjectImpl)contrCodeFormVO;
                setContraventionMstLngData(contraCode,mstVO);
                getCntrCodeForm().setVisible(true);
                getCancelBottom().setVisible(true);
                getCancelTop().setVisible(true);
                setIsDisabled(Boolean.TRUE);
                getNewBtn().setVisible(false);
                getEditBtn().setVisible(false);
                getViewBtn().setVisible(false);
                getZonecode().setDisabled(true);
                getActflag().setDisabled(true);
                getAddrowbind().setDisabled(true);
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("53",lngCode)));            
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));  
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("54",lngCode)));        
        }
        ADFContext.getCurrent().getPageFlowScope().put("actionMode", "View");
        return null;
    }
       public String Edit_action() {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
       //    String userName = "vara";
      // exceptionzone.setVisible(true);
           java.sql.Timestamp sqlTime = new java.sql.Timestamp(new java.util.Date().getTime());
           DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("ContraventionMstUVO2Iterator");
           ViewObject contrCodeReadOnlyVO = dcItteratorBindings.getViewObject();
           Row rowSelected = contrCodeReadOnlyVO.getCurrentRow();
           
           if(rowSelected != null)
           {
              Integer contraCode = (Integer)rowSelected.getAttribute("ContraCode");  
               AdfFacesContext.getCurrentInstance().getPageFlowScope().put("concode",contraCode); 
               contracode=contraCode;
               logger.info("Selected ContraventionCode  in Edit_action is : "+contraCode);
               if(contraCode != null)
               {
                   DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("ContraventionMstUVO1Iterator");
                   ViewObject contrCodeFormVO = dcItteratorBinding.getViewObject();                   
                   contrCodeFormVO.setWhereClause(null);
                   contrCodeFormVO.setWhereClause("Contra_Code = "+contraCode);
                   contrCodeFormVO.executeQuery();
                   DCIteratorBinding dcItteratorBinding1 = bindingsAM.findIteratorBinding("PVTExceptionzoneVO1Iterator");
                   ViewObject ExceptionzoneVO = dcItteratorBinding1.getViewObject();                   
                   ExceptionzoneVO.setWhereClause(null);
                   ExceptionzoneVO.setWhereClause("CONTRA_CODE = "+contraCode);
                   ExceptionzoneVO.executeQuery();
                   ViewObjectImpl mstVO = (ViewObjectImpl)contrCodeFormVO;
                   setContraventionMstLngData(contraCode,mstVO);
                   ContraventionMstUVORowImpl contrRow = (ContraventionMstUVORowImpl)contrCodeFormVO.getCurrentRow();
                   if(contrRow != null )
                   {
                       Object obsFlag = contrRow.getObservreqflag();
                       if(obsFlag != null && obsFlag.equals("Y"))
                       {
                            getObsTime().setDisabled(false);
                        }
                       contrRow.setUpdatedBy(userName);         
                       contrRow.setUpdatedDate(sqlTime);
                       getCntrCodeForm().setVisible(true);
                       getSubmitBottom().setVisible(true);
                       getCancelBottom().setVisible(true);
                       getSubmitTop().setVisible(true);
                       getCancelTop().setVisible(true);
                       setIsDisabled(Boolean.FALSE);
                       getNewBtn().setVisible(false);
                       getEditBtn().setVisible(false);
                       getViewBtn().setVisible(false);
                       getZonecode().setDisabled(false);
                       getAddrowbind().setDisabled(false);
                       getActflag().setDisabled(false);
                       AdfFacesContext.getCurrentInstance().addPartialTarget(getZonecode());
                       AdfFacesContext.getCurrentInstance().addPartialTarget(getActflag());
                   }
               }
               else
               {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message",genMsg.getMessage("53",lngCode) ));            
               }
           }
           else
           {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode))); 
               //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("55",lngCode)));        
           }
           ADFContext.getCurrent().getPageFlowScope().put("actionMode", "Edit");
           
           return null;
       }

    public void setContraventionMstLngData(Integer conCode,ViewObjectImpl mstVO){
        //Getting Data from Sector Master Language Table
         String lang = httpSession.getAttribute("language").toString();       
         getContraventionMstLngVO().setWhereClause("Contra_Code="+conCode);
         getContraventionMstLngVO().executeQuery();
         RowSetIterator conIterator =getContraventionMstLngVO().createRowSetIterator(null);
         while (conIterator.hasNext()) {
         oracle.jbo.Row conRow = conIterator.next();
            if(conRow!=null){
                String selectLang=(String)conRow.getAttribute("LNGCODE");
                    if(("EN".equalsIgnoreCase(lang) && "AR".equalsIgnoreCase(selectLang))||("AR".equalsIgnoreCase(lang) && "EN".equalsIgnoreCase(selectLang))){
                     System.out.println("Contravention Code ::::::::::    "+mstVO.getCurrentRow().getAttribute("ContraCode"));
                     mstVO.getCurrentRow().setAttribute("Language", selectLang);
                     mstVO.getCurrentRow().setAttribute("ContraCodeLng", conRow.getAttribute("CodeName")); 
                  } 
                    System.out.println("Loc Desc :::::::::::::::  "+conRow.getAttribute("CodeName"));
               }
           }
    }
   

    public void setSubmitBottom(RichCommandButton submitBottom) {
        this.submitBottom = submitBottom;
    }

    public RichCommandButton getSubmitBottom() {
        return submitBottom;
    }

    public void setCancelBottom(RichCommandButton cancelBottom) {
        this.cancelBottom = cancelBottom;
    }

    public RichCommandButton getCancelBottom() {
        return cancelBottom;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public String Cancel_action() {
        getCntrCodeForm().setVisible(false);
        getSubmitBottom().setVisible(false);
        getCancelBottom().setVisible(false);
        getSubmitTop().setVisible(false);
        getCancelTop().setVisible(false);
        getNewBtn().setVisible(true);
        getEditBtn().setVisible(true);
        getViewBtn().setVisible(true);
        getObsTime().setDisabled(true);
        getAddrowbind().setDisabled(true);
        //exceptionzone.setVisible(false);
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("PVTExceptionzoneVO1Iterator");
        ViewObject exceptVO = dcIteratorBinding.getViewObject();
        exceptVO.executeEmptyRowSet();
        getBindings().getOperationBinding("doRollback").execute();
        bindingsAM.findIteratorBinding("ContraventionMstUVO2Iterator").getViewObject().executeQuery();
        return null;
    }

    public void setSubmitTop(RichCommandButton submitTop) {
        this.submitTop = submitTop;
    }

    public RichCommandButton getSubmitTop() {
        return submitTop;
    }

    public void setCancelTop(RichCommandButton cancelTop) {
        this.cancelTop = cancelTop;
    }

    public RichCommandButton getCancelTop() {
        return cancelTop;
    }

    public void setCntrCodeForm(RichShowDetailHeader cntrCodeForm) {
        this.cntrCodeForm = cntrCodeForm;
    }

    public RichShowDetailHeader getCntrCodeForm() {
        return cntrCodeForm;
    }

    public void setNewBtn(RichCommandButton newBtn) {
        this.newBtn = newBtn;
    }

    public RichCommandButton getNewBtn() {
        return newBtn;
    }

    public void setEditBtn(RichCommandButton editBtn) {
        this.editBtn = editBtn;
    }

    public RichCommandButton getEditBtn() {
        return editBtn;
    }

    public void setViewBtn(RichCommandButton viewBtn) {
        this.viewBtn = viewBtn;
    }

    public RichCommandButton getViewBtn() {
        return viewBtn;
    }

    public void obsrFlagCheck(ValueChangeEvent valueChangeEvent) {
        Boolean flag = (Boolean)valueChangeEvent.getNewValue();
        if(!flag)
        {
                DCIteratorBinding dcItteratorBinding =
                    bindingsAM.findIteratorBinding("ContraventionMstUVO1Iterator");
                ViewObject cntrCodeVO = dcItteratorBinding.getViewObject();
                    ContraventionMstUVORowImpl cntrCodeRow = (ContraventionMstUVORowImpl)cntrCodeVO.getCurrentRow();
                    if(cntrCodeRow != null)
                    {
                        cntrCodeRow.setObservTime(null);
                        getObsTime().setSubmittedValue(null);  
                        AdfFacesContext.getCurrentInstance().addPartialTarget(obsTime);
                        getObsTime().setDisabled(true);
                    }
                
            }
        else if(flag)
        {
                getObsTime().setDisabled(false);
            }
    }

    public void setObsTime(RichInputText obsTime) {
        this.obsTime = obsTime;
    }

    public RichInputText getObsTime() {
        return obsTime;
    }
    
    public ViewObject getContraventionMstLngVO() {
        DCIteratorBinding bindingLink =bindingsAM.findIteratorBinding("ContraMstLngVO1Iterator");
        ViewObject voLink = bindingLink.getViewObject();
        return voLink;
    }
   

    public void addRow(ActionEvent actionEvent) {
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("PVTExceptionzoneVO1Iterator");
        ViewObject exceptionzone = dcIteratorBinding.getViewObject();
        Row newRow = exceptionzone.createRow();
        newRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
        newRow.setAttribute("CreatedDate", sqlDate);
        newRow.setAttribute("CONTRACODE", AdfFacesContext.getCurrentInstance().getPageFlowScope().get("concode"));
        
        exceptionzone.insertRow(newRow);
    }

    public void setContracode(Integer contracode) {
        this.contracode = contracode;
    }

    public Integer getContracode() {
        return contracode;
    }

    public void setExceptionzone(RichShowDetailHeader exceptionzone) {
        this.exceptionzone = exceptionzone;
    }

    public RichShowDetailHeader getExceptionzone() {
        return exceptionzone;
    }

    public void setZonecode(RichSelectOneChoice zonecode) {
        this.zonecode = zonecode;
    }

    public RichSelectOneChoice getZonecode() {
        return zonecode;
    }

    public void setAddrowbind(RichCommandImageLink addrowbind) {
        this.addrowbind = addrowbind;
    }

    public RichCommandImageLink getAddrowbind() {
        return addrowbind;
    }

    public void setActflag(RichSelectBooleanCheckbox actflag) {
        this.actflag = actflag;
    }

    public RichSelectBooleanCheckbox getActflag() {
        return actflag;
    }
}
