package com.imum.cpms.transactions.inventory;

import com.imum.cpms.model.masters.vo.DocMstDtlUVORowImpl;
import com.imum.cpms.model.masters.vo.DocMstHdrUVORowImpl;
import com.imum.cpms.model.transactions.vo.CardTypeMstUVORowImpl;
import com.imum.cpms.util.MessageUtil;
import com.imum.cpms.view.backing.DocMstBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;

public class CardTypeMstMBean {
    private RichPanelGroupLayout cardTypeMstForm;
    private RichCommandButton submitBtn;
    private RichCommandButton cancelBtn;
    private RichCommandButton submitBtnTop;
    private RichCommandButton cancelBtnTop;
    private RichCommandButton newBtn;
    private RichCommandButton editBtn;
    private RichCommandButton viewBtn;

    public CardTypeMstMBean() {
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        } 
    }
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private boolean isDisabled ;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger = ADFLogger.createADFLogger(CardTypeMstMBean.class);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public String New_action() {
        logger.info("Inside New_Action of CardTypeMstMBean");
        setIsDisabled(Boolean.FALSE);
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        OperationBinding operationBinding = bindings.getOperationBinding("addNewCardTypeMst");
        operationBinding.getParamsMap().put("encoder",userName);
        operationBinding.execute();
        getCardTypeMstForm().setVisible(true);
        getSubmitBtn().setRendered(true);
        getCancelBtn().setRendered(true);
        getSubmitBtnTop().setRendered(true);
        getCancelBtnTop().setRendered(true);
        getNewBtn().setRendered(false);
        getEditBtn().setRendered(false);
        getViewBtn().setRendered(false);
        return null;
    }
    
    public String Edit_action() {
        setIsDisabled(Boolean.FALSE);
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("CardTypeMstUVO2Iterator");
        ViewObject cardMstReadTbl = dcItteratorBindings.getViewObject();
        Row rowSelected = cardMstReadTbl.getCurrentRow();
        if(rowSelected != null)
        {
            String typeCode = (String)rowSelected.getAttribute("CardTypeCode");
            logger.info("Selected CardTypeCode in Edit_action is : "+typeCode);
            
            if(typeCode!=null && !"".equals(typeCode))
            {
                OperationBinding operationBinding = bindings.getOperationBinding("fecthCardTypeMst");
                operationBinding.getParamsMap().put("encoder",userName);
                operationBinding.getParamsMap().put("mode","edit");
                operationBinding.getParamsMap().put("typeCode",typeCode);
                operationBinding.execute(); 
                getCardTypeMstForm().setVisible(true);
                getSubmitBtn().setRendered(true);
                getCancelBtn().setRendered(true);
                getSubmitBtnTop().setRendered(true);
                getCancelBtnTop().setRendered(true);
                getNewBtn().setRendered(false);
                getEditBtn().setRendered(false);
                getViewBtn().setRendered(false);
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("55", lngCode)));       
        }
        return null;
    }
    
    public String View_action() {
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("CardTypeMstUVO2Iterator");
        ViewObject cardMstReadTbl = dcItteratorBindings.getViewObject();
        Row rowSelected = cardMstReadTbl.getCurrentRow();
        if(rowSelected != null)
        {
            String typeCode = (String)rowSelected.getAttribute("CardTypeCode");
            logger.info("Selected CardTypeCode in Edit_action is : "+typeCode);
            
            if(typeCode!=null && !"".equals(typeCode))
            {
                OperationBinding operationBinding = bindings.getOperationBinding("fecthCardTypeMst");
                operationBinding.getParamsMap().put("encoder",userName);
                operationBinding.getParamsMap().put("mode","view");
                operationBinding.getParamsMap().put("typeCode",typeCode);
                operationBinding.execute(); 
                getCardTypeMstForm().setVisible(true);
                getSubmitBtn().setRendered(false);
                getCancelBtn().setRendered(true);
                getSubmitBtnTop().setRendered(false);
                getCancelBtnTop().setRendered(true);
                getNewBtn().setRendered(false);
                getEditBtn().setRendered(false);
                getViewBtn().setRendered(false);
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));  
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("54", lngCode)));       
        }
        setIsDisabled(Boolean.TRUE);
        return null;
    }

    public String Submit_action() {
        String result = validateSubmit();
        if(result.equals("pass"))
        {
            OperationBinding operationBinding = bindings.getOperationBinding("commit");
            operationBinding.execute();
            if(operationBinding.getErrors().isEmpty())
            {
//                DCIteratorBinding dcItteratorHdr =
//                    bindingsAM.findIteratorBinding("CardTypeMstUVO1Iterator");   
//                ViewObject hdrVO = dcItteratorHdr.getViewObject();
//               CardTypeMstUVORowImpl hdrRow = (CardTypeMstUVORowImpl)hdrVO.first();
//               if(hdrRow != null)
//               {
//                   Object cardTypeCode = hdrRow.getCardTypeCode();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("178", lngCode)));     
                    getCardTypeMstForm().setVisible(false);
                getSubmitBtn().setRendered(false);
                getCancelBtn().setRendered(false);
                getSubmitBtnTop().setRendered(false);
                getCancelBtnTop().setRendered(false);
                getNewBtn().setRendered(true);
                getEditBtn().setRendered(true);
                getViewBtn().setRendered(true);
//                }
               
            }    
        }        
        return null;
    }
    public String validateSubmit()
        {
            String result = "pass";
            DCIteratorBinding dcItteratorBinding =
                bindingsAM.findIteratorBinding("CardTypeMstUVO1Iterator");
            ViewObject hdrVO = dcItteratorBinding.getViewObject();
                CardTypeMstUVORowImpl hdRow = (CardTypeMstUVORowImpl)hdrVO.getCurrentRow();
                String typeCode =  (String) hdRow.getAttribute("CardTypeCode");
                System.out.println("Card type Code in validate Submit is " + typeCode);
                if(hdRow != null)
                {
                    Object categ = hdRow.getCategory();
                    Object cardType = hdRow.getCardTypeName();
                    Object valdur = hdRow.getValDuration();
                    Object cost = hdRow.getCostAmt();
                    Object bulk = hdRow.getBulkSaleLimit();
                    Object timeLimit = hdRow.getamendTimeLimit();
                    Object carddenom = hdRow.getcardDenomamt();  
                    String fectDS = null;
                   
                    if(carddenom == null) {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("176", lngCode)));    
//                        result = "fail";
                        
                    }
                   else
                    {
                     fectDS = String.format("%f", carddenom);
                    }
                    System.out.println("fectDStr in valiateSybmit is : "+fectDS);
                    if(fectDS == null) {
                        
                    }
                  else
                    fectDS = fectDS.substring(0, fectDS.indexOf('.'));
                  
                    carddenom = fectDS;
                    Object typeCodeCurrent = hdRow.getCardTypeCode();
                    if(categ == null || categ.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("171", lngCode)));    
                        result = "fail";
                    }
                    if(cardType == null || cardType.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("135", lngCode)));    
                        result = "fail";
                    }
                    if(valdur == null || valdur.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("172", lngCode)));    
                        result = "fail";
                    }
                    if(cost == null || cost.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("173", lngCode)));    
                        result = "fail";
                    }
                    if(bulk == null || bulk.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("174", lngCode)));    
                        result = "fail";
                    }
                    if(timeLimit == null || timeLimit.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("175", lngCode)));    
                        result = "fail";
                    }
                    if(carddenom == null || carddenom.equals(""))
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("176", lngCode)));    
                        result = "fail";
                    }
                    
                    DCIteratorBinding dcItterator =
                        bindingsAM.findIteratorBinding("CardTypeMstUVO2Iterator");
                    ViewObjectImpl readOnlyVO = (ViewObjectImpl)dcItterator.getViewObject();
                    if(readOnlyVO != null)
                    {
                        double count = readOnlyVO.getEstimatedRowCount();
                        if(count>0)
                        {
                            for(int k=1; k<count; k++)
                                              {
                                                      CardTypeMstUVORowImpl readOnlyRow =
                                                          (CardTypeMstUVORowImpl)readOnlyVO.getRowAtRangeIndex(k);
                                                  if(readOnlyRow != null)
                                                  {
                                                         logger.info("headerRow row in validateSubmit is : "+k);
                                                         Object fetchSeq = readOnlyRow.getCardTypeCode();
                                                          Object fetchCateg = readOnlyRow.getCategory();
                                                          Object fetchDenom = readOnlyRow.getcardDenomamt();
                                                          String fectDStr = String.format("%f", fetchDenom);
                                                          System.out.println("fectDStr in valiateSybmit is : "+fectDStr);
                                                          fectDStr = fectDStr.substring(0, fectDStr.indexOf('.'));
                                                          fetchDenom = fectDStr;
                                                         if(typeCodeCurrent != null && fetchSeq.equals(typeCodeCurrent) && fetchCateg.equals(categ) && fetchDenom.equals(carddenom))
                                                         {
                                                             k = k+1;
                                                             readOnlyRow = (CardTypeMstUVORowImpl)readOnlyVO.getRowAtRangeIndex(k);
                                                             if(readOnlyRow != null)
                                                             {
                                                                 fetchCateg = readOnlyRow.getCategory();
                                                                 fetchDenom = readOnlyRow.getcardDenomamt(); 
                                                                 String fectDSt = String.format("%f", fetchDenom);
                                                                 System.out.println("fectDStr in valiateSybmit is : "+fectDSt);
                                                                 fectDSt = fectDSt.substring(0, fectDSt.indexOf('.'));
                                                                 fetchDenom = fectDSt;
                                                             }                                                             
                                                         }                                                         
                                                         System.out.println("Row Values during duplicate check is : "+fetchCateg+","+fetchDenom);
                                                          if(readOnlyRow != null)
                                                          {
                                                              if(fetchCateg != null && fetchDenom != null && fetchCateg.equals(categ) && fetchDenom.equals(carddenom)) {
                                                                  FacesContext.getCurrentInstance().addMessage(null,
                                                                                                               new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                                                                "Sample info message",
                                                                                                                                genMsg.getMessage("177", lngCode)));
                                                                  result = "fail";
                                                                  break;
                                                              }   
                                                          }                                                         
                                                      }        
                        }
                        }
                    }
                }
            return result;
        }
    
    public String Cancel_action() {
        getBindings().getOperationBinding("doRollback").execute();
        getCardTypeMstForm().setVisible(false);
        getSubmitBtn().setRendered(false);
        getCancelBtn().setRendered(false);
        getSubmitBtnTop().setRendered(false);
        getCancelBtnTop().setRendered(false);
        getNewBtn().setRendered(true);
        getEditBtn().setRendered(true);
        getViewBtn().setRendered(true);
        return null;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public boolean isIsDisabled() {
        return isDisabled;
    }

    public void setCardTypeMstForm(RichPanelGroupLayout cardTypeMstForm) {
        this.cardTypeMstForm = cardTypeMstForm;
    }

    public RichPanelGroupLayout getCardTypeMstForm() {
        return cardTypeMstForm;
    }

    public void setSubmitBtn(RichCommandButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public RichCommandButton getSubmitBtn() {
        return submitBtn;
    }

    public void setCancelBtn(RichCommandButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public RichCommandButton getCancelBtn() {
        return cancelBtn;
    }


    public void setSubmitBtnTop(RichCommandButton submitBtnTop) {
        this.submitBtnTop = submitBtnTop;
    }

    public RichCommandButton getSubmitBtnTop() {
        return submitBtnTop;
    }

    public void setCancelBtnTop(RichCommandButton cancelBtnTop) {
        this.cancelBtnTop = cancelBtnTop;
    }

    public RichCommandButton getCancelBtnTop() {
        return cancelBtnTop;
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
}
