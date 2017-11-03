package com.imum.cpms.transactions.aution;

import com.imum.cpms.model.transactions.vo.CardTypeMstUVORowImpl;
import com.imum.cpms.model.transactions.vo.InvDetailUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTAuctionSearchVORowImpl;
import com.imum.cpms.util.MessageUtil;

import com.imum.ws.Auction.AuctionApprovalBPMProcessPortType;
import com.imum.ws.Auction.AuctionApprovalBPMProcessService;

import java.math.BigDecimal;

import java.util.HashMap;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.FacesMessage;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import javax.xml.ws.WebServiceRef;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class AutionInitiationBean {
    private RichSpacer s134;
    private RichToolbar t3;
    private RichSpacer s12344;
    private RichInputText it3;
    private RichInputText it4;
    private RichSpacer s1;
    private RichToolbar t1;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl1;
    private RichCommandButton cancelBtn;
    private RichCommandButton cancelBtnTop;
    private RichCommandButton submitBtn;
    private RichCommandButton submitBtnTop;
    private RichSelectBooleanCheckbox it5;
    private RichInputText it2;
    private RichInputText it1;
    private RichPanelFormLayout pfl1;
    private RichPanelGroupLayout autionInitiationForm;
    private RichPanelGroupLayout autionInitiationViewForm;
    private RichSpacer spacer3;
    private RichTable t2;
    private RichPanelGroupLayout pgl3;
    private RichShowDetailHeader sdh1;
    private RichSpacer s4;
    private RichCommandButton viewAuction;
    private RichSpacer s3;
    private RichSpacer s2;
    private RichCommandButton newAuction;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private boolean isDisabled ;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger = ADFLogger.createADFLogger(AutionInitiationBean.class);
    MessageUtil genMsg = new MessageUtil();
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichTable pvTSearchResultTable;
    private RichTable auctionInitiationSearchResultTable;
    private RichPanelFormLayout pfl3;
    private RichToolbar t4;
    private RichInputText total_num_pvts;
    private RichInputText selectedAuctionBatchID;
    
    
    String lgCode = httpSession.getAttribute("language").toString();
    
    public AutionInitiationBean() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        } 
    }
    @WebServiceRef
    private static AuctionApprovalBPMProcessService auctionApprovalBPMProcessService;
    
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setS134(RichSpacer s134) {
        this.s134 = s134;
    }

    public RichSpacer getS134() {
        return s134;
    }

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setS12344(RichSpacer s12344) {
        this.s12344 = s12344;
    }

    public RichSpacer getS12344() {
        return s12344;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
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

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setCancelBtn(RichCommandButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public RichCommandButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtnTop(RichCommandButton cancelBtnTop) {
        this.cancelBtnTop = cancelBtnTop;
    }

    public RichCommandButton getCancelBtnTop() {
        return cancelBtnTop;
    }

    public void setSubmitBtn(RichCommandButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public RichCommandButton getSubmitBtn() {
        return submitBtn;
    }

    public void setSubmitBtnTop(RichCommandButton submitBtnTop) {
        this.submitBtnTop = submitBtnTop;
    }

    public RichCommandButton getSubmitBtnTop() {
        return submitBtnTop;
    }

    public void setIt5(RichSelectBooleanCheckbox it5) {
        this.it5 = it5;
    }

    public RichSelectBooleanCheckbox getIt5() {
        return it5;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setSpacer3(RichSpacer spacer3) {
        this.spacer3 = spacer3;
    }

    public RichSpacer getSpacer3() {
        return spacer3;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setSdh1(RichShowDetailHeader sdh1) {
        this.sdh1 = sdh1;
    }

    public RichShowDetailHeader getSdh1() {
        return sdh1;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setViewAuction(RichCommandButton viewAuction) {
        this.viewAuction = viewAuction;
    }

    public RichCommandButton getViewAuction() {
        return viewAuction;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    
    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setNewAuction(RichCommandButton newAuction) {
        this.newAuction = newAuction;
    }

    public RichCommandButton getNewAuction() {
        return newAuction;
    }

    public void setAutionInitiationForm(RichPanelGroupLayout autionInitiationForm) {
        this.autionInitiationForm = autionInitiationForm;
    }

    public RichPanelGroupLayout getAutionInitiationForm() {
        return autionInitiationForm;
    }
    public void setAutionInitiationViewForm(RichPanelGroupLayout autionInitiationViewForm) {
        this.autionInitiationViewForm = autionInitiationViewForm;
    }

    public RichPanelGroupLayout getAutionInitiationViewForm() {
        return autionInitiationViewForm;
    }
    
    public String newAction() {
        logger.info("Start New_Action Method of AutionInitiationBean");
        System.out.println("New Action tiggered");
        getBindings().findIteratorBinding("PVTAuctionSearchVO1Iterator").getViewObject().executeEmptyRowSet();
        getAutionInitiationForm().setVisible(true);
        getAutionInitiationViewForm().setVisible(false);
        getSubmitBtn().setVisible(true);
        getCancelBtn().setVisible(true);
        getViewAuction().setVisible(false);
        getNewAuction().setVisible(false);
        getSubmitBtnTop().setVisible(true);
        getCancelBtnTop().setVisible(true);
        logger.info("End New_Action Method of AutionInitiationBean");
        return null;
    }
    
    public String cancelAction(){
        logger.info("Start cancelAction Method of AutionInitiationBean");
        System.out.println("Cancel Action tiggered");
        getBindings().findIteratorBinding("PVTAuctionSearchVO1Iterator").getViewObject().executeEmptyRowSet();
        getAutionInitiationForm().setVisible(false);
        getAutionInitiationViewForm().setVisible(false);
        getSubmitBtn().setVisible(false);
        getCancelBtn().setVisible(false);
        getViewAuction().setVisible(true);
        getNewAuction().setVisible(true);
        getSubmitBtnTop().setVisible(false);
        getCancelBtnTop().setVisible(false);
        logger.info("End cancelAction Method of AutionInitiationBean");
        return null;
    }
    public String submitAction() {
        long l1;
        logger.info("Start submitAction Method of AutionInitiationBean");
        System.out.println("Submit Action tiggered");
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        String result = "pass";
        DCIteratorBinding dcItterator =  bindingsAM.findIteratorBinding("PVTAuctionSearchVO1Iterator1");
           ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();  
        
           if(invDetailVO != null)
           {
               Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
               Integer selectCount = selectionRow.length;
               if (selectCount > 0) {
                   BindingContainer bindings = getBindings();
                   OperationBinding opBinding = bindings.getOperationBinding("saveAuctionInitiationDetails");
                   opBinding.getParamsMap().put("auctionInitiationDate", sqlDate);
                   opBinding.getParamsMap().put("totalNosPVTs",selectCount);
                   opBinding.getParamsMap().put("status","Auction Initiated");
                   //opBinding.getParamsMap().put("createdBy","Ayyappa");
                   opBinding.getParamsMap().put("createdBy",httpSession.getAttribute("loggedinUserid").toString());
                   String saveHeaderResult = (String)opBinding.execute();
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Auction Initiation Successfully", null));         
                    result = "success"; 
                   getAutionInitiationForm().setVisible(false);
                   getAutionInitiationViewForm().setVisible(false);
                   getSubmitBtn().setVisible(false);
                   getCancelBtn().setVisible(false);
                   getViewAuction().setVisible(true);
                   getNewAuction().setVisible(true);
                   getSubmitBtnTop().setVisible(false);
                   getCancelBtnTop().setVisible(false);
                   DCIteratorBinding dcItterator1=bindingsAM.findIteratorBinding("PVTAUCTIONHeaderVO1Iterator");
                      ViewObjectImpl pvtauctionVO = (ViewObjectImpl)dcItterator1.getViewObject();
                   pvtauctionVO.executeQuery();  
                   Row r=pvtauctionVO.first();
                   if(r!=null) {
                       BigDecimal auctionHeaderseq =(BigDecimal)r.getAttribute("AUCTIONHeaderseq");
                 
                       l1=auctionHeaderseq.longValue();
                       auctionApprovalBPMProcessService = new AuctionApprovalBPMProcessService();
                       AuctionApprovalBPMProcessPortType auctionApprovalBPMProcessPortType =auctionApprovalBPMProcessService.getAuctionApprovalBPMProcessPort();
                       auctionApprovalBPMProcessPortType.start(l1);
                   }
                   
                   
               } else {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Select atleast one PVT to Processed", null));         
                    result = "fail"; 
                    
               }
               total_num_pvts.setValue(0);
           }
        
        logger.info("End submitAction Method of AutionInitiationBean");
        return result;
    }
    public String viewAction() {
        logger.info("Start viewAction Method of AutionInitiationBean");
        System.out.println("View Action tiggered");
        
        
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("PVTAUCTIONHeaderVO1Iterator");
         ViewObject genAuctionHeaderVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = genAuctionHeaderVO.getCurrentRow();
        if(rowSelected != null){
            BigDecimal auctionHeaderseq = (BigDecimal)rowSelected.getAttribute("AUCTIONHeaderseq");
            
            
            if(auctionHeaderseq!=null && !"".equals(auctionHeaderseq))
            {
                OperationBinding operationBinding = bindings.getOperationBinding("getAuctionInitiationPvtDetails");
                operationBinding.getParamsMap().put("auctionHeaderseq", auctionHeaderseq);
                String selectedGroupNamePiid = (String)operationBinding.execute();
                selectedAuctionBatchID.setValue(auctionHeaderseq);
                getAutionInitiationForm().setVisible(false);
                getAutionInitiationViewForm().setVisible(true);
                getSubmitBtn().setVisible(false);
                getCancelBtn().setVisible(true);
                getViewAuction().setVisible(false);
                getNewAuction().setVisible(false);
                getSubmitBtnTop().setVisible(false);
                getCancelBtnTop().setVisible(true);
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Please Select Auction to Show Details",null));
                   
            }
        }else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Please Select Auction to Show Details",null));
         
        }
        logger.info("End viewAction Method of AutionInitiationBean");
        return null;
    }
    
    public void ResetSearchPage(QueryOperationEvent queryOperationEvent) {
          invokeMethodExpression("#{bindings.PVTAuctionSearchVO1Query.processQueryOperation}",
        Object.class,   
                                 new Class[]{ QueryOperationEvent.class},  
                                 new Object [] {queryOperationEvent});
          
          if(queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")){
              getBindings().findIteratorBinding("PVTAuctionSearchVO1Iterator").getViewObject().executeEmptyRowSet();
   
            }
        
        // Add event code here...
    }
    
    public Object invokeMethodExpression(String expr, Class returnType,  
                                           Class[] argTypes, Object[] args)  
      {  
        FacesContext fc = FacesContext.getCurrentInstance();  
        ELContext elctx = fc.getELContext();  
        ExpressionFactory elFactory =  
          fc.getApplication().getExpressionFactory();
    //        ExpressionFactory expressionFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr =  
          elFactory.createMethodExpression(elctx, expr, returnType, argTypes);  
        return methodExpr.invoke(elctx, args);  
      }
    
    public String searchAction() {
        logger.info("Start searchAction Method of AutionInitiationBean");
        System.out.println("Search Action tiggered");
        logger.info("End searchAction Method of AutionInitiationBean");
        return null;
    }
    
    public String resetAction() {
        logger.info("Start resetAction Method of AutionInitiationBean");
        System.out.println("Reset Action tiggered");
        logger.info("End resetAction Method of AutionInitiationBean");
        return null;
    }
    
    public BigDecimal populateTotalPvts(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        boolean selectedValue = (Boolean)valueChangeEvent.getNewValue(); 
        //Getting Checked Row
        int index = pvTSearchResultTable.getRowIndex();
        BigDecimal totalAmt = null;
         DCIteratorBinding dcItterator =
                bindingsAM.findIteratorBinding("PVTAuctionSearchVO1Iterator1");
            ViewObjectImpl invDetailVO = (ViewObjectImpl)dcItterator.getViewObject();  
        //Setting Current Checkbox value to current row
        PVTAuctionSearchVORowImpl rowImpl = (PVTAuctionSearchVORowImpl)invDetailVO.getRowAtRangeIndex(index);
        if(rowImpl != null){
        rowImpl.setSelectFlag(selectedValue);
            if(invDetailVO != null)
            {
                Row selectionRow[] = invDetailVO.getFilteredRows("SelectFlag",true);
                Integer selectCount = selectionRow.length;
                if (selectCount > 0) {
                    total_num_pvts.setValue(selectCount);
                    
                } else {
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Please select any cards to view summary"));      
                    total_num_pvts.setValue("");
                    
                }
            }
        }
        return totalAmt;
    }
    

    public void setPvTSearchResultTable(RichTable pvTSearchResultTable) {
        this.pvTSearchResultTable = pvTSearchResultTable;
    }

    public RichTable getPvTSearchResultTable() {
        return pvTSearchResultTable;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setT4(RichToolbar t4) {
        this.t4 = t4;
    }

    public RichToolbar getT4() {
        return t4;
    }


    public void setTotal_num_pvts(RichInputText total_num_pvts) {
        this.total_num_pvts = total_num_pvts;
    }

    public RichInputText getTotal_num_pvts() {
        return total_num_pvts;
    }

    public void setAuctionInitiationSearchResultTable(RichTable auctionInitiationSearchResultTable) {
        this.auctionInitiationSearchResultTable = auctionInitiationSearchResultTable;
    }

    public RichTable getAuctionInitiationSearchResultTable() {
        return auctionInitiationSearchResultTable;
    }

    public void setSelectedAuctionBatchID(RichInputText selectedAuctionBatchID) {
        this.selectedAuctionBatchID = selectedAuctionBatchID;
    }

    public RichInputText getSelectedAuctionBatchID() {
        return selectedAuctionBatchID;
    }
}
