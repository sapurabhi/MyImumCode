package com.imum.cpms.transactions;

import com.imum.cpms.util.MessageUtil;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

public class PVTAmtAdjMBean {
    private Boolean showDetailsLayout= false ;
    private Float PVTAdjAmount= new Float(0);
    private Float NewPVTPayableAmt= new Float(0);
    private String PVTNo;
    private Boolean DisableSubmit = true;
    FacesContext facesContext = FacesContext.getCurrentInstance();

    ExternalContext externalContext = facesContext.getExternalContext();

    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
        MessageUtil genMsg = new MessageUtil();
        String lngCode = httpSession.getAttribute("language").toString();
    private RichSelectOneRadio adjAmtAction;
    private RichInputText remarks_ITB;
    private RichOutputText initialPVTPayableAmt;
    


    public void SearchPVT(ActionEvent actionEvent) {
         String pvtno=getPVTNo();  
         if(pvtno!=null){
        OperationBinding operation = getBindings().getOperationBinding("getPVTForAmtAdjustment");
        operation.getParamsMap().put("PVTNum",pvtno );
        operation.execute();
        
        String result = operation.getResult().toString();
        /* for Empty PVT*/
        if(result.equalsIgnoreCase("SUCCESS")) {
            setShowDetailsLayout(true);
            /* initialize new pvt payable amount */
               if(adjAmtAction.getLocalValue()!=null && adjAmtAction.getLocalValue().toString().equalsIgnoreCase("-"))
               NewPVTPayableAmt = Float.parseFloat(getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first().getAttribute("PVTAMTPAYABLE").toString()) - PVTAdjAmount;
               else 
                   NewPVTPayableAmt = Float.parseFloat(getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first().getAttribute("PVTAMTPAYABLE").toString()) + PVTAdjAmount;
               System.out.println("NewPVTPayableAmt is : "+NewPVTPayableAmt);
            }
        /* for Closed PVT status*/
        else if(result.equalsIgnoreCase("CLOSED")) DisplayMessage("315", "");//Cannot proceed to Adjustment as PVT is already CLOSED.
        /* for CANCELLED PVT status*/
        else if(result.equalsIgnoreCase("CANCELLED")) DisplayMessage("316", "");//Cannot proceed to Adjustment as PVT is in CANCELLED status.
            /* for ON HOLD PVT status */
        else if(result.equalsIgnoreCase("ONHOLD")) DisplayMessage("322", "");//Cannot proceed to Adjustment as PVT is in ON HOLD status.
        /* for EMPTY PVT status*/
        else DisplayMessage("317", "");//PVT not Found.
         } else{
             DisplayMessage("325", "Please Enter PVT Number.");
         }
    }

    public String CancelAmountAdjustment(){
            PVTNo="";
//            PVTAdjAmount= null;
            PVTAdjAmount = Float.parseFloat("0.00");
            NewPVTPayableAmt = Float.parseFloat("0.00");
            adjAmtAction.setValue("-");
            DisableSubmit = true;
            remarks_ITB.setValue("");
            setShowDetailsLayout(false);
        return null;
        }



    private Boolean ValidateAdjAmount(){
            Row curRow = getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first();
            Float PVTAMTPAYABLE =  Float.parseFloat(curRow.getAttribute("PVTAMTPAYABLE").toString());
            BigDecimal PVTHdrSeq = (BigDecimal) curRow.getAttribute("PVTHDRSEQ");
                
            if(PVTAdjAmount==null){
                DisplayMessage("321","");//Please enter Adjustment Amount.
                return false;
            }else if(PVTAMTPAYABLE<PVTAdjAmount && adjAmtAction.getValue().toString().equalsIgnoreCase("-") ){
                /* Display error as Adjustable Amount is cannot be greator Than Payable Amount*/
                DisplayMessage("319","");//Adjustment Amount Cannot be Greator than PVTPayableAmount.    
                return false;
                
            }else if(PVTAdjAmount<0){
            DisplayMessage("320","");//Adjustment Amount Cannot be negative value.
            return false;
            }
        return true;
        }

    public String DisplayPVTPayableAmt() {

    if(ValidateAdjAmount()){
        if(adjAmtAction.getValue().toString().equalsIgnoreCase("-"))
            NewPVTPayableAmt = Float.parseFloat(getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first().getAttribute("PVTAMTPAYABLE").toString()) - PVTAdjAmount;
        else{
            NewPVTPayableAmt = Float.parseFloat(getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first().getAttribute("PVTAMTPAYABLE").toString()) + PVTAdjAmount;
        }
        DisableSubmit = false;
    }else{
        
        }
        return null;
    }
    
    public String submitAdjAmount() {
        Row curRow = getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first();
//        Float PVTAMTPAYABLE =  Float.parseFloat(curRow.getAttribute("PVTAMTPAYABLE").toString());
        BigDecimal PVTHdrSeq = (BigDecimal) curRow.getAttribute("PVTHDRSEQ");
        if(ValidateAdjAmount()){
            /*call SP to insert Adjustable amount */
            OperationBinding operation = getBindings().getOperationBinding("PVTupdateAdjustmentAmt");
            operation.getParamsMap().put("pvtHdrSeq",PVTHdrSeq );
            operation.getParamsMap().put("PVTAdjAmount", PVTAdjAmount);
            operation.getParamsMap().put("loggerName", httpSession.getAttribute("loggedinUserid").toString());
            operation.getParamsMap().put("Operator", adjAmtAction.getValue().toString());
            operation.execute();
            if(operation.getErrors().isEmpty()){
            /*call SP to enter EVENT into history table*/
            OperationBinding operation1 = getBindings().getOperationBinding("CreateEvent");
                operation1.getParamsMap().put("pvtHeaderSeq", PVTHdrSeq);
                operation1.getParamsMap().put("loggerName", httpSession.getAttribute("loggedinUserid").toString());
                operation1.getParamsMap().put("remarks", "Adjustable amount : AED " + PVTAdjAmount+". "+remarks_ITB.getLocalValue());
                operation1.getParamsMap().put("EventId", "577");
//                operation1.getParamsMap().put("Amt", BigDecimal.valueOf(((long)PVTAdjAmount*100, 2) );
            operation1.execute();
            
                OperationBinding operation2 = getBindings().getOperationBinding("IntPVTAdjSP");
                operation2.getParamsMap().put("pvtHDRSeq", PVTHdrSeq);
                operation2.execute();
            
                
            
            /* committ changes */
            OperationBinding operation3 = getBindings().getOperationBinding("doCommit");
            operation3.execute();
            if(!operation3.getErrors().isEmpty()){
                DisplayMessage("234","");//Failed to Save updates. Please check the Log.
            } else{
            /* Display Success Message to user*/
            DisplayMessage("318", PVTNo);
            /* Hide Details region & clear PVTNum field.*/
            PVTNo="";
                PVTAdjAmount= null;
            setShowDetailsLayout(false);
            }
            }else{
                DisplayMessage("234","");//Failed to Save updates. Please check the Log.
                 }
            }


        return null;
    }

    private void DisplayMessage(String str, String Code){
            FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,str,genMsg.getMessage(str, lngCode)+Code) );            
        }

    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void setShowDetailsLayout(Boolean showDetailsLayout) {
        this.showDetailsLayout = showDetailsLayout;
    }

    public Boolean getShowDetailsLayout() {
        return showDetailsLayout;
    }

    public void setPVTAdjAmount(Float PVTAdjAmount) {
        this.PVTAdjAmount = PVTAdjAmount;
    }

    public Float getPVTAdjAmount() {
        return PVTAdjAmount;
    }


    public void setPVTNo(String PVTNum) {
        this.PVTNo = PVTNum;
    }

    public String getPVTNo() {
        return PVTNo;
    }

    public void calAmountPayable(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(adjAmtAction.getValue().toString().equalsIgnoreCase("-"))
            NewPVTPayableAmt = Float.parseFloat(getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first().getAttribute("PVTAMTPAYABLE").toString()) - PVTAdjAmount;
        else{
            NewPVTPayableAmt = Float.parseFloat(getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().first().getAttribute("PVTAMTPAYABLE").toString()) + PVTAdjAmount;
        }
        DisableSubmit= true;
        
    }

    public void setAdjAmtAction(RichSelectOneRadio adjAmtAction) {
        this.adjAmtAction = adjAmtAction;
    }

    public RichSelectOneRadio getAdjAmtAction() {
        return adjAmtAction;
    }



    public void setRemarks_ITB(RichInputText remarks_ITB) {
        this.remarks_ITB = remarks_ITB;
    }

    public RichInputText getRemarks_ITB() {
        return remarks_ITB;
    }

    public void setInitialPVTPayableAmt(RichOutputText initialPVTPayableAmt) {
        this.initialPVTPayableAmt = initialPVTPayableAmt;
    }

    public RichOutputText getInitialPVTPayableAmt() {
        return initialPVTPayableAmt;
    }

    public void setNewPVTPayableAmt(Float NewPVTPayableAmt) {
        this.NewPVTPayableAmt = NewPVTPayableAmt;
    }

    public Float getNewPVTPayableAmt() {
        return NewPVTPayableAmt;
    }

    public void setDisableSubmit(Boolean DisableSubmit) {
        this.DisableSubmit = DisableSubmit;
    }

    public Boolean getDisableSubmit() {
        return DisableSubmit;
    }
}
