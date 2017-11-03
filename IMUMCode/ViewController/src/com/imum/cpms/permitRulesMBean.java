package com.imum.cpms;


import com.imum.cpms.model.masters.am.MastersAMImpl;
import com.imum.cpms.model.masters.vo.PermitChargesVORowImpl;
import com.imum.cpms.model.masters.vo.PermitRuleUVORowImpl;

import com.imum.cpms.model.masters.vo.RuleMaxQuotaVORowImpl;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpServletRequest;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.model.binding.DCUtil;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.server.ViewObjectImpl;
    import com.imum.cpms.util.MessageUtil;

import java.sql.Timestamp;

import javax.faces.context.ExternalContext;

import javax.servlet.http.HttpSession;

public class permitRulesMBean {
    private boolean viewBtnEnabled = true;
    private boolean submitBtnEnabled = true;
    private RichTable sectorTable;
    private RichTable sectorTable1;
    private RichSelectOneChoice renewal;
    private RichSelectOneChoice permitCateGory;
    private RichInputText maxQuota;
    private RichInputText freePermits;
    private RichSelectOneChoice permitType;
    private RichInputText shortCode;
    private RichInputDate startDate;
    private RichInputDate fromDate;
    private RichSelectOneChoice flag;
    private RichInputText renewalGrace;
    private RichInputText pvTGrace;
    private RichSelectBooleanCheckbox active;
    private RichSelectOneChoice choice;
    private boolean hide = true;
    private boolean addRowNew = true;
    private boolean addRowEdit = true;
    private Integer a;
    private RichTable ruleTable;
    private Integer NewRuleId;
    private boolean isDisabled = false ;

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    java.sql.Date sqlDateTime = new java.sql.Date(new java.util.Date().getTime());
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        MessageUtil genMsg = new MessageUtil();
        String lngCode = httpSession.getAttribute("language").toString();



    public permitRulesMBean() {}

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    private void DisplayMessage(String str, String Code){
            FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"",genMsg.getMessage(str, lngCode)+Code) );            
        }

    //Code for Submit starts here//

    public String SubmitRule() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =  bindings.findIteratorBinding("PermitRuleUVO1Iterator");
        ViewObject PermitRuleVO = dcItteratorBindings.getViewObject();
        String result = (String)validatePermitMaster();
        AdfFacesContext adfctx = null;
                                adfctx = AdfFacesContext.getCurrentInstance();

         if (result.equalsIgnoreCase("pass")) {
//            BindingContainer bindings = getBindings();
            OperationBinding opBinding =
                bindings.getOperationBinding("submitPermitRule");
            opBinding.execute();
            PermitRuleVO.executeQuery();
            adfctx.addPartialTarget(getRuleTable()); 
//            DisplayMessage("  Rule Id Is,'"+a+"'" );
            DisplayMessage("236","'"+a+"'" );
            
            
            setHide(Boolean.TRUE);
            setAddRowEdit(Boolean.TRUE);
            setAddRowNew(Boolean.TRUE);
            
        }else
         {
             ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");    
         }
        return null;

    }
    //Code for Submit End here//


    
    //Code for Validation Method Starts here//
    public String validatePermitMaster() {
        String result = "pass";
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("PermitRuleUVO2Iterator");
        ViewObject docMstHdVO = dcItteratorBinding.getViewObject();
        PermitRuleUVORowImpl hdRow =
            (PermitRuleUVORowImpl)docMstHdVO.getCurrentRow();
        if (hdRow != null) {
            Object catg = hdRow.getCategCode();
            Object maxQuota = hdRow.getMaxQuota();
            Object localFlag = hdRow.getLocalFlag();
            Object PVT = hdRow.getPVTgracePeriod();
            Object ShortCode = hdRow.getShortCode();
            Object permitType = hdRow.getTypeCode();
            Object fromDate = hdRow.getEffectivedateFrom();
            Object rulIdCurrent = hdRow.getRuleId();
            
          
            
           
            if (catg == null || catg.equals("")) {
                DisplayMessage("33","");
                result = "fail";
            }
            if (permitType == null || permitType.equals("")) {
                DisplayMessage("34","");
                result = "fail";
            }
            if (localFlag == null || localFlag.equals(""))

            {
                DisplayMessage("35","");
                result = "fail";
            }
            if (maxQuota == null || maxQuota.equals(""))

            {
                DisplayMessage("237","");
                result = "fail";
            }
            if (ShortCode == null || ShortCode.equals(""))

            {
                DisplayMessage("238","");
                result = "fail";
            }
            if (fromDate == null || fromDate.equals(""))

            {
                DisplayMessage("239","");
                result = "fail";
            }
            if (PVT == null || PVT.equals(""))

            {
                DisplayMessage("240","");
                result = "fail";
            }
            
            

            DCIteratorBinding dcItteratorDtl =
                bindingsAM.findIteratorBinding("RuleMaxQuotaVO1Iterator");
            ViewObject dtlVO = dcItteratorDtl.getViewObject();
            if(dtlVO.getRowCount()==0) {
                DisplayMessage("241","");
                result = "fail";
            }
            if (dtlVO != null) {
                System.out.println("Detail Row Count : " +
                                   dtlVO.getFetchedRowCount());
                for (int i = 0; i < dtlVO.getFetchedRowCount(); i++) {
                    RuleMaxQuotaVORowImpl dtRow =
                        (RuleMaxQuotaVORowImpl)dtlVO.getRowAtRangeIndex(i);
                    
                    if (dtRow != null) {
                        Object sector = dtRow.getSectorCode();
                        Object maxPermits = dtRow.getquotanum();
                        Object activeFlag = dtRow.getActiveflag();
                        Integer rowStatusMaxQuota = dtRow.getrowStatus();
                        if (sector == null || sector.equals("")) {
                            DisplayMessage("242","");
                            result = "fail";
                        }
                        if (maxPermits == null || maxPermits.equals("")) {
                            DisplayMessage("243","");
                            result = "fail";
                        }
                        if (activeFlag == null || activeFlag.equals("")) {
                            DisplayMessage("244","");
                            result = "fail";
                        }
                        if(result.equals("pass") && rowStatusMaxQuota == 2)
                        {
                            dtRow.setUpdatedby(userName);
                            dtRow.setUpdateddate(sqlDate);        
                        }
                    }
                }
            }
            Integer rowStatusRule = hdRow.getrowStatus();
            if(result.equals("pass") && rowStatusRule == 2)
            {
                hdRow.setUpdatedBy(userName);        
                hdRow.setUpdatedDate(sqlDateTime);        
            }
        }
        DCIteratorBinding dcItteratorDtl =
            bindingsAM.findIteratorBinding("PermitChargesVO1Iterator");
        ViewObject chargesVO = dcItteratorDtl.getViewObject();
        if(chargesVO.getRowCount()==0) {
            DisplayMessage("245","");
            result = "fail";
        }
        if (chargesVO != null) {
            System.out.println("Detail Row Count : " +
                               chargesVO.getFetchedRowCount());
            for (int i = 0; i < chargesVO.getFetchedRowCount(); i++) {
                PermitChargesVORowImpl chargesRow =
                    (PermitChargesVORowImpl)chargesVO.getRowAtRangeIndex(i);
                if (chargesRow != null) {
                    Object validity = chargesRow.getVadityPeriod();
                    Object vehicles = chargesRow.getNumofVeh();
                    Object adminCharges = chargesRow.getAdminChrg();
                    Object processing = chargesRow.getProcesschrg();
                    Object PermitChar = chargesRow.getPermitchrg();
                    Object ActiveFlag = chargesRow.getActiveflag();
                    if (validity == null || validity.equals("")) {
                        DisplayMessage("246","");
                        result = "fail";
                    }
                    if (vehicles == null || vehicles.equals("")) {
                        DisplayMessage("247","");
                        result = "fail";
                    }
                    if (adminCharges == null || adminCharges.equals("")) {
                        DisplayMessage("248","");
                        result = "fail";
                    }
                    if (processing == null || processing.equals("")) {
                        DisplayMessage("249","");
                        result = "fail";
                    }
                    if (PermitChar == null || PermitChar.equals("")) {
                        DisplayMessage("250","");
                        result = "fail";
                    }
                    if (ActiveFlag == null || ActiveFlag.equals("")) {
                        DisplayMessage("244","");
                        result = "fail";
                    }
                    Integer rowStatusCharges = chargesRow.getrowStatus();
                    if(result.equals("pass") && rowStatusCharges == 2)
                    {
                        chargesRow.setUpdatedby(userName);        
                        chargesRow.setUpdateddate(sqlDate);        
                    }
                }

            }

        }

        return result;
    }
    //Code for Validation Method Ends here//
    
    
    
    //Code For Edit Start Here//
    public void Edit_PermitRule() {
        setHide(Boolean.FALSE);
        setAddRowEdit(Boolean.FALSE);
        setAddRowNew(Boolean.TRUE);
        if(!isSubmitBtnEnabled())
          setSubmitBtnEnabled(Boolean.TRUE);
        
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        
        DCIteratorBinding dcItteratorBindings1 =
            bindings.findIteratorBinding("PermitRuleUVO1Iterator");
        ViewObject CusvoTableData = dcItteratorBindings1.getViewObject();
        if(CusvoTableData != null)
        {
            Row CustomerrowSelected = dcItteratorBindings1.getCurrentRow();
            if(CustomerrowSelected != null)
            {
                Integer RuleId = (Integer)CustomerrowSelected.getAttribute("RuleId");
                    a=RuleId;
                System.out.println("ruleid " + a);
                NewRuleId=a;
                DCIteratorBinding dcItteratorBindings2 =
                    bindings.findIteratorBinding("PermitRuleUVO2Iterator");
                ViewObject PermitRuleData = dcItteratorBindings2.getViewObject();

                DCIteratorBinding dcItteratorBindings3 =
                    bindings.findIteratorBinding("RuleMaxQuotaVO1Iterator");
                ViewObject PermitSectorData = dcItteratorBindings3.getViewObject();


                DCIteratorBinding dcItteratorBindings4 =
                    bindings.findIteratorBinding("PermitChargesVO1Iterator");
                ViewObject PermitChargesData = dcItteratorBindings4.getViewObject();


                if (RuleId != null) {
                    PermitRuleData.clearCache();
                    PermitRuleData.setWhereClause(null);
                    PermitRuleData.setWhereClause("Rule_Id = " + RuleId);
                    PermitRuleData.executeQuery();
                    System.out.println("" + PermitRuleData.getRowCount());
                    System.out.println("ruleid" + RuleId);

                    PermitSectorData.clearCache();
                    PermitSectorData.setWhereClause(null);
                    PermitSectorData.setWhereClause("Rule_Id = " + RuleId);
                    PermitSectorData.executeQuery();

                    System.out.println("Query" + PermitSectorData.getQuery());

                    System.out.println("" + PermitSectorData.getRowCount());
                    System.out.println("ruleid" + RuleId);


                    PermitChargesData.clearCache();
                    PermitChargesData.setWhereClause(null);
                    PermitChargesData.setWhereClause("Rule_Id = " + RuleId);
                    PermitChargesData.executeQuery();
                    System.out.println("Query" + PermitChargesData.getQuery());
                    System.out.println("" + PermitChargesData.getRowCount());
                    System.out.println("ruleid" + RuleId);
                }
                setViewBtnEnabled(Boolean.TRUE);   
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
            }
        }       
    }
    //Code For Edit End Here//

    public void setViewBtnEnabled(boolean enabled) {
        this.viewBtnEnabled = enabled;
    }

    public boolean isViewBtnEnabled() {
        return viewBtnEnabled;
    }

    //Code For View starts Here//
    public void View_permitRule() {
        setHide(Boolean.FALSE);
        setAddRowNew(Boolean.TRUE);
        setAddRowEdit(Boolean.TRUE);
        Edit_PermitRule();
        submitBtnEnabled=false;
        viewBtnEnabled=true;
//        setEnabled(Boolean.FALSE);
       


    }
    //Code For View Edit Here//

    /**
     * @return
     */
    
    //Code For New Starts here//
    public String NewPermit() {
        
        setHide(Boolean.FALSE);
        setAddRowEdit(Boolean.TRUE);
        setAddRowNew(Boolean.FALSE);
      if(!isSubmitBtnEnabled())
        setSubmitBtnEnabled(Boolean.TRUE);
      
        BindingContainer bindings = getBindings();
        OperationBinding opBinding =
            bindings.getOperationBinding("NewRule");
        opBinding.getParamsMap().put("encoder",userName);
        a=(Integer)opBinding.execute();
        System.out.println("ruleid " + a);
        NewRuleId = a;
        setViewBtnEnabled(Boolean.TRUE);
        return null;
    }
    
    //Code for New Edns Here//
    

    public void setSectorTable1(RichTable sectorTable1) {
        this.sectorTable1 = sectorTable1;
    }

    public RichTable getSectorTable1() {
        return sectorTable1;
    }

    public void setRenewal(RichSelectOneChoice renewal) {
        this.renewal = renewal;
    }

    public RichSelectOneChoice getRenewal() {
        return renewal;
    }


    public void setPermitCateGory(RichSelectOneChoice permitCateGory) {
        this.permitCateGory = permitCateGory;
    }

    public RichSelectOneChoice getPermitCateGory() {
        return permitCateGory;
    }

    public void setMaxQuota(RichInputText maxQuota) {
        this.maxQuota = maxQuota;
    }

    public RichInputText getMaxQuota() {
        return maxQuota;
    }

    public void setFreePermits(RichInputText freePermits) {
        this.freePermits = freePermits;
    }

    public RichInputText getFreePermits() {
        return freePermits;
    }

    public void setPermitType(RichSelectOneChoice permitType) {
        this.permitType = permitType;
    }

    public RichSelectOneChoice getPermitType() {
        return permitType;
    }

    public void setShortCode(RichInputText shortCode) {
        this.shortCode = shortCode;
    }

    public RichInputText getShortCode() {
        return shortCode;
    }

    public void setStartDate(RichInputDate startDate) {
        this.startDate = startDate;
    }

    public RichInputDate getStartDate() {
        return startDate;
    }

    public void setFromDate(RichInputDate fromDate) {
        this.fromDate = fromDate;
    }

    public RichInputDate getFromDate() {
        return fromDate;
    }

    public void setFlag(RichSelectOneChoice flag) {
        this.flag = flag;
    }

    public RichSelectOneChoice getFlag() {
        return flag;
    }

    public void setRenewalGrace(RichInputText renewalGrace) {
        this.renewalGrace = renewalGrace;
    }

    public RichInputText getRenewalGrace() {
        return renewalGrace;
    }

    public void setPvTGrace(RichInputText pvTGrace) {
        this.pvTGrace = pvTGrace;
    }

    public RichInputText getPvTGrace() {
        return pvTGrace;
    }

    public void setActive(RichSelectBooleanCheckbox active) {
        this.active = active;
    }

    public RichSelectBooleanCheckbox getActive() {
        return active;
    }

    public void setChoice(RichSelectOneChoice choice) {
        this.choice = choice;


        this.choice.setValue(1);
    }

    public RichSelectOneChoice getChoice() {
        return choice;
    }

    

    //Code for Add new row For Permit Sector Quota starts here//
    public String AddRow_Quota() {
        Integer ruleId = null;
        DCBindingContainer bindingsAM =
                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBinding =
                    bindingsAM.findIteratorBinding("RuleMaxQuotaVO1Iterator");
        ViewObjectImpl maxQuotaVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
                ViewObject quotaVO = dcItteratorBinding.getViewObject();

//                System.out.println("Current Row's Rule Id value is : "+quotaVO.getCurrentRow().getAttribute("RuleId").toString());
//                Integer RuleId=(Integer) quotaVO.getCurrentRow().getAttribute("RuleId");
                
                RuleMaxQuotaVORowImpl quotaRow = (RuleMaxQuotaVORowImpl)quotaVO.createRow();
        quotaRow.setCreatedBy(userName);
        quotaRow.setCreatedDate(sqlDate);
                quotaVO.insertRow(quotaRow);
        ruleId=NewRuleId;
        System.out.println("Rule Id from class variable NewRuleId :  "+ruleId);
                         
                RuleMaxQuotaVORowImpl maxQuotaRow = (RuleMaxQuotaVORowImpl)maxQuotaVO.getCurrentRow();
                if(maxQuotaRow != null && ruleId != null)
                {
                    maxQuotaRow.setRuleId(ruleId);                 
                     
                    System.out.println("Rule id in AddRow_Quota is : "+maxQuotaRow.getRuleId());    
                }   
        return null;
    }
    //Code for Add new row For Permit Sector Quota Ends here//
    
    
 //Code for Add new row For Permit Charges starts here//
    public String AddRow_Charges() {
        Integer ruleId = null;
        DCBindingContainer bindingsAM =
                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBinding =
                    bindingsAM.findIteratorBinding("PermitChargesVO1Iterator");
        ViewObjectImpl maxQuotaVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
                ViewObject quotaVO = dcItteratorBinding.getViewObject();
                
                       PermitChargesVORowImpl quotaRow = (PermitChargesVORowImpl)quotaVO.createRow();
        quotaRow.setCreatedBy(userName);
        quotaRow.setCreatedDate(sqlDate);
                      quotaVO.insertRow(quotaRow);


        ruleId=NewRuleId;

                        System.out.println("Rule Id from class variable NewRuleId :  "+ruleId);

                
                         
                PermitChargesVORowImpl maxQuotaRow = (PermitChargesVORowImpl)maxQuotaVO.getCurrentRow();
                if(maxQuotaRow != null && ruleId != null)
                {
//                    BigDecimal ruleIdBigDec = new BigDecimal(ruleId);
                    maxQuotaRow.setRuleId(ruleId);                 
                     
                    System.out.println("Rule id in AddRow_Charges is : "+maxQuotaRow.getRuleId());    
                }   
        return null;
    }
    //Code for Add new row For Permit Charges Ends here//
    
    
    
    //Code for Editing   Permit Charges starts here//
    public String AddRowEdit_Charges() {
        // Add event code here...
        DCBindingContainer bindingsAM =
                            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcItteratorBinding =
                            bindingsAM.findIteratorBinding("PermitChargesVO1Iterator");
                ViewObjectImpl chargesVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
                        ViewObject prmChargesVO = dcItteratorBinding.getViewObject();
                               PermitChargesVORowImpl chargesRow = (PermitChargesVORowImpl)prmChargesVO.createRow();
        chargesRow.setCreatedBy(userName);
        chargesRow.setCreatedDate(sqlDate);
                              prmChargesVO.insertRow(chargesRow);
                        DCIteratorBinding dcItteratorBindings =
                            bindingsAM.findIteratorBinding("PermitRuleUVO1Iterator");
                        ViewObject prmRuleVO = dcItteratorBindings.getViewObject();
                        PermitRuleUVORowImpl prmRuleRow = (PermitRuleUVORowImpl)prmRuleVO.getCurrentRow();
                        Integer ruleId = prmRuleRow.getRuleId();
                        PermitChargesVORowImpl chargeRow = (PermitChargesVORowImpl)chargesVO.getCurrentRow();
                        if(chargesRow != null && ruleId != null)
                        {
//                            BigDecimal ruleIdBigDec = new BigDecimal(ruleId);
                            chargeRow.setRuleId(ruleId);

                            System.out.println("Rule Id on AddRowEdit_Charges : "+chargeRow.getRuleId());
                        }
                        else
                        {
                        System.out.println("Submit denied");
                        }
        return null;
    }
    
    //Code for Add  For Editing Permit Charges Ends here//



    //Code for Editing Record of   Permit Sector Quota Starts here//
    public String AddRowEdit_Quota() {
        // Add event code here...
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("RuleMaxQuotaVO1Iterator");
        ViewObjectImpl quotaVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
        ViewObject prmQuotaVO = dcItteratorBinding.getViewObject();
               RuleMaxQuotaVORowImpl prmQuotaRow = (RuleMaxQuotaVORowImpl)prmQuotaVO.createRow();
        prmQuotaRow.setCreatedBy(userName);
        prmQuotaRow.setCreatedDate(sqlDate);
              prmQuotaVO.insertRow(prmQuotaRow);
        DCIteratorBinding dcItteratorBindings =
            bindingsAM.findIteratorBinding("PermitRuleUVO1Iterator");
        ViewObject prmRuleVO = dcItteratorBindings.getViewObject();
        PermitRuleUVORowImpl prmRuleRow = (PermitRuleUVORowImpl)prmRuleVO.getCurrentRow();
        Integer ruleId = prmRuleRow.getRuleId();
        RuleMaxQuotaVORowImpl quotaRow = (RuleMaxQuotaVORowImpl)quotaVO.getCurrentRow();
        if(quotaRow != null && ruleId != null)
        {
            quotaRow.setRuleId(ruleId);

            System.out.println("Rule id in AddRowEdit_Quota is : "+quotaRow.getRuleId());
        }
        else
        {
        System.out.println("Submit denied");
        }
        return null;
    }
    
    //Code for Editing Record of   Permit Sector Quota End here//

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isHide() {
        return hide;
    }

    public void setAddRowNew(boolean addRowNew) {
        this.addRowNew = addRowNew;
    }

    public boolean isAddRowNew() {
        return addRowNew;
    }

    public void setAddRowEdit(boolean addRowEdit) {
        this.addRowEdit = addRowEdit;
    }

    public boolean isAddRowEdit() {
        return addRowEdit;
    }

    public void setRuleTable(RichTable ruleTable) {
        this.ruleTable = ruleTable;
    }

    public RichTable getRuleTable() {
        return ruleTable;
    }

    public void setSubmitBtnEnabled(boolean submitBtnEnabled) {
        this.submitBtnEnabled = submitBtnEnabled;
    }

    public boolean isSubmitBtnEnabled() {
        return submitBtnEnabled;
    }
    
    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public boolean isIsDisabled() {
       String rolename= ADFContext.getCurrent().getSessionScope().get("rolename").toString();
        if(rolename.equalsIgnoreCase("MDReadOnly")){
            return true;
        }
        DCBindingContainer bindingsAM =
                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindingsAM.findIteratorBinding("PermitRuleUVO2Iterator");
        ViewObject vo = dcItteratorBindings.getViewObject();
        
        return vo.getRowCount()>0 ? Boolean.FALSE : Boolean.TRUE;
    //        return isDisabled;
    }

    public void AllSectorCodeCheck(ValueChangeEvent vce) {
        String Code = vce.getNewValue().toString();
        
        
    }
}
