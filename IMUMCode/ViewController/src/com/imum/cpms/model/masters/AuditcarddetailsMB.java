package com.imum.cpms.model.masters;


import com.imum.cpms.model.masters.vo.AuditCardsearchVORowImpl;

import com.imum.cpms.model.masters.vo.PVTCourtReportUVORowImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.output.RichMessage;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.event.SelectionEvent;

public class AuditcarddetailsMB {
    private boolean hide = true;
    private boolean visible = true;
    private boolean isDisabled =false;
    private RichSelectOneChoice loctionid;
    private RichColumn tablebind;
    private BigDecimal countseq;
    private String mode="new";
    DCBindingContainer bindings =(DCBindingContainer)getBindings();
    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    private int locid=0;
    private RichTable countbindtable;
    private RichInputText actualcount;
    private RichTable newcountbindtable;
    private RichCommandButton searchbind;
    private RichPopup popup;
    private RichTable detailbind;
    private RichTable auditcarddetails;
    private RichTable detailstablebind;
    private BigDecimal auditseq;
    private RichCommandButton freezebuttonbind;
    private RichPanelHeader panelDetails;
    private RichCommandButton addbuttonbind;
    private int cardlength=0;
    private RichMessage errormsg;

    public AuditcarddetailsMB() {
    }


    public String newAction() {
        setMode("new");
        loctionid.setReadOnly(false);
        searchbind.setDisabled(false);
        addbuttonbind.setDisabled(true);
        DCIteratorBinding AuditHeaderdc = bindings.findIteratorBinding("AuditHeaderVO2Iterator");
        ViewObject AuditHeaderVO = AuditHeaderdc.getViewObject();
        Row auditheaderrow=AuditHeaderVO.createRow();
        auditheaderrow.setAttribute("createddate", sqlDate);
        auditheaderrow.setAttribute("createdby", userName);
        auditheaderrow.setAttribute("AuditFreezeflag",'N');
        AuditHeaderVO.insertRow(auditheaderrow);
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("AuditCardcountdtlsVO2Iterator");
        ViewObject auditsearch = dcIteratorBinding.getViewObject();
        auditsearch.executeEmptyRowSet();
        countbindtable.setRendered(true);
        searchbind.setDisabled(false);
        errormsg.setMessage(null);
        errormsg.setVisible(false);
     //  AdfFacesContext.getCurrentInstance().addPartialTarget(newcountbindtable); 
        return null;
    }

    public String editAction() {
        setMode("edit");
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
       // BigDecimal auditseq;
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setreadonly","true");
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.AuditHeaderVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
           Object freez=selectedRow.getAttribute("AuditFreezeflag");
            if(freez!=null) {
                String f=freez.toString();
                if(f.equals("Y")) {
                    auditseq=new BigDecimal(selectedRow.getAttribute("AuditSeq").toString());
                    DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditCardcountdtlsVO2Iterator");
                    ViewObject appVO = dcItteratorBinding.getViewObject();
                    appVO.executeEmptyRowSet();
                    appVO.setWhereClause(null);
                    appVO.setWhereClauseParams(null);
                    appVO.setWhereClause("Audit_seq = '"+auditseq +"'");
                    appVO.executeQuery();                       
                     countbindtable.setRendered(true);
                     loctionid.setReadOnly(true);
                     searchbind.setDisabled(true);
                     addbuttonbind.setDisabled(true);
                     freezebuttonbind.setRendered(true);
                     freezebuttonbind.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("renderSubmitCancel","true");
                }  
                    else {
                    auditseq=new BigDecimal(selectedRow.getAttribute("AuditSeq").toString());
                    DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditCardcountdtlsVO2Iterator");
                    ViewObject appVO = dcItteratorBinding.getViewObject();
                    appVO.executeEmptyRowSet();
                    appVO.setWhereClause(null);
                    appVO.setWhereClauseParams(null);
                    appVO.setWhereClause("Audit_seq = '"+auditseq +"'");
                    appVO.executeQuery(); 
                    System.out.println(appVO.getEstimatedRowCount());
                    countbindtable.setRendered(true);
                    // newcountbindtable.setRendered(false);
                    loctionid.setReadOnly(true);
                    searchbind.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(searchbind); 
                    addbuttonbind.setDisabled(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(addbuttonbind); 
                    searchbind.setDisabled(true);
                    freezebuttonbind.setRendered(true);
                    errormsg.setMessage(null);
                    errormsg.setVisible(false);
                }
            }
            
        }
       
        return null;
    }

    public String viewAction() {
        setMode("view");
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        BigDecimal auditseq;
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setreadonly","true");
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.AuditHeaderVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
            auditseq=new BigDecimal(selectedRow.getAttribute("AuditSeq").toString());
            DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditCardcountdtlsVO2Iterator");
            ViewObject appVO = dcItteratorBinding.getViewObject();
            appVO.setWhereClause(null);
            appVO.setWhereClauseParams(null);
            appVO.setWhereClause("Audit_seq = '"+auditseq +"'");
            appVO.executeQuery(); 
//            DCIteratorBinding dcItteratorBinding2 =bindingsAM.findIteratorBinding("AuditcardDetailsVO1Iterator");
//            ViewObject countVO = dcItteratorBinding2.getViewObject();
//            countVO.executeQuery(); 
            DCBindingContainer bindingsA1 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBinding1 =bindingsA1.findIteratorBinding("auditcardDetailsRVO1Iterator");
            ViewObject auditdetailVO = dcItteratorBinding1.getViewObject();
            auditdetailVO.setWhereClause("audit_seq = '"+auditseq +"'");
            auditdetailVO.executeQuery();
            System.out.println(auditdetailVO.getEstimatedRowCount());
           // countbindtable.setRendered(false);
           detailstablebind.setRendered(true);
           // addbuttonbind.setDisabled(true);
            panelDetails.setRendered(true);
            countbindtable.setRendered(true);
            loctionid.setReadOnly(true);
            searchbind.setDisabled(true);
            addbuttonbind.setDisabled(true);
            freezebuttonbind.setRendered(true);
            freezebuttonbind.setDisabled(true);
            errormsg.setMessage(null);
            errormsg.setVisible(false);
            //detailbind.setRendered(true);
            
           
        }
        
        
        
        
        return null;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isHide() {
        return hide;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public boolean isIsDisabled() {
        return isDisabled;
    }

    public String submit() { 
        
       
//        if(mode.equals("new"))
//        {
//        BigDecimal  seq=null;
//        DCIteratorBinding AuditHeaderdc = bindings.findIteratorBinding("AuditHeaderVO2Iterator");
//        ViewObject AuditHeaderVO = AuditHeaderdc.getViewObject();
//        Row auditRow=AuditHeaderVO.getCurrentRow();
//        auditRow.setAttribute("AuditDate", sqlDate);
//        auditRow.setAttribute("AuditorID", "cpms");
//        OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
//        opBindingDoc.execute();
//        DCIteratorBinding AuditHeaderdc1 = bindings.findIteratorBinding("AuditHeaderVO1Iterator");
//        ViewObject AuditHeaderVO1 = AuditHeaderdc1.getViewObject();
//        Row r=AuditHeaderVO1.last();
//        Object ob=r.getAttribute("AuditSeq");
//        seq= (BigDecimal)ob;
//        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("AuditCardsearchVO1Iterator");
//        ViewObject auditsearchVO = dcIteratorBinding.getViewObject();
//        
//        Row selectionRowN[] = auditsearchVO.getAllRowsInRange();
//        Integer selectCountN = selectionRowN.length;
//       if(selectCountN>0) {
//           //for(int i = 0;i<selectCountN;i++) {
//                    
//               DCBindingContainer bindings1= (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//               DCIteratorBinding dcIteratorBind = bindings1.findIteratorBinding("AuditCardsearchVO1Iterator");
//               ViewObject auditcardcountdtlsVO =dcIteratorBind.getViewObject();
//               RowSetIterator iterator = auditcardcountdtlsVO.createRowSetIterator(null);    
//               iterator.reset();
//               while (iterator.hasNext()) {
//                Row docRow = iterator.next();
//
//                   System.out.println(docRow.getAttribute("countcards"));
//                   
//                   
//                   
//                   
////                   auditdetailrow.setAttribute("createddate", sqlDate);
////                   auditdetailrow.setAttribute("Createdby", "cpms");
////                   AuditcountdetailVO.insertRow(auditdetailrow);    
//               }
//           }
//          // actualcount.setReadOnly(true);
           OperationBinding op = getBindings().getOperationBinding("doCommit");                
           op.execute();
        detailstablebind.setRendered(false);
        if(op.getErrors().isEmpty()){  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Details saved Successfully",null)); 
        }
        panelDetails.setRendered(false);
        countbindtable.setRendered(false);
           AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setvisible","false");
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditHeaderVO1Iterator");
        ViewObject appVO = dcItteratorBinding.getViewObject();
        appVO.executeQuery();
        DCIteratorBinding count =bindingsAM.findIteratorBinding("AuditCardcountdtlsVO2Iterator");
        ViewObject countVO = count.getViewObject();
        countVO.executeQuery();
        DCIteratorBinding Detail =bindingsAM.findIteratorBinding("AuditcardDetailsVO1Iterator");
        ViewObject DetailVO = Detail.getViewObject();
        DetailVO.executeQuery();
           
           
     //  }     
   //   }
             
        return null;
    }

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public String Search() {
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(countbindtable); 
        DCIteratorBinding AuditHeaderdc = bindings.findIteratorBinding("AuditHeaderVO2Iterator");
        ViewObject AuditHeaderVO = AuditHeaderdc.getViewObject();
        Row auditRow=AuditHeaderVO.getCurrentRow();
        Object loc = auditRow.getAttribute("locationid");
        if(loc!=null) {
            locid=Integer.parseInt(loc.toString());
            auditRow.setAttribute("locationid", locid);
            auditRow.setAttribute("AuditorID", userName);
            auditRow.setAttribute("AuditDate", sqlDate);
            
            BindingContainer bindings = getBindings();
            OperationBinding op=bindings.getOperationBinding("loctionSearch");
            op.getParamsMap().put("locid",locid);
            op.getParamsMap().put("date","okokok");
         String res=op.execute().toString(); 
         if(res.equals("N")) {
             System.out.println("no recordes ");
         }
        }
        
        return null;
    }

    public void setLoctionid(RichSelectOneChoice loctionid) {
        this.loctionid = loctionid;
    }

    public RichSelectOneChoice getLoctionid() {
        return loctionid;
    }

    public void setTablebind(RichColumn tablebind) {
        this.tablebind = tablebind;
    }

    public RichColumn getTablebind() {
        return tablebind;
    }

    public void setLocid(int locid) {
        this.locid = locid;
    }

    public int getLocid() {
        return locid;
    }

    public void SelectedRow(SelectionEvent selectionEvent) {
        try
               {
                   if(mode.equals("edit"))
                   {
                   ADFUtil.invokeEL("#{bindings.AuditCardcountdtlsVO2.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
                   Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.AuditCardcountdtlsVO2.currentRow}"); // get the current selected row
                   AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Selected");
                   if(selectedRow != null)
                   {
                       Object seq = selectedRow.getAttribute("Auditcardcntseq");
                       if(seq != null) 
                       {
                            countseq = new BigDecimal(seq.toString());
                            DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditcardDetailsVO1Iterator");
                            ViewObjectImpl detailsVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
                            detailsVO.setApplyViewCriteriaName(null);
                            detailsVO.setApplyViewCriteriaName("AuditcardDetailsVOCriteria");
                            detailsVO.setNamedWhereClauseParam("cntSeq", countseq);
                            detailsVO.executeQuery();
                            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("countseq", countseq);
                            RichPopup.PopupHints ph = new RichPopup.PopupHints();
                            popup.show(ph);
                       }
                   }
                   }
               }
               catch (Exception e) {
                           System.out.println("Error occurred..." + e.toString());
                                                   }
    }

    public void setCountbindtable(RichTable countbindtable) {
        this.countbindtable = countbindtable;
    }

    public RichTable getCountbindtable() {
        return countbindtable;
    }

    public void setActualcount(RichInputText actualcount) {
        this.actualcount = actualcount;
    }

    public RichInputText getActualcount() {
        return actualcount;
    }

    public void setNewcountbindtable(RichTable newcountbindtable) {
        this.newcountbindtable = newcountbindtable;
    }

    public RichTable getNewcountbindtable() {
        return newcountbindtable;
    }

    public String cancelAction() {
        OperationBinding opBindingDoc = getBindings().getOperationBinding("doRollback");                
        opBindingDoc.execute();
        countbindtable.getSelectedRowKeys().clear();
       countbindtable.setRendered(false);
        detailstablebind.setRendered(false);
        searchbind.setDisabled(false);
        panelDetails.setRendered(false);
        countbindtable.setRendered(false);
        freezebuttonbind.setRendered(false);
        freezebuttonbind.setDisabled(false);
//        newcountbindtable.setRendered(false);
       // detailbind.setRendered(false);
        return null;
    }

    public void setSearchbind(RichCommandButton searchbind) {
        this.searchbind = searchbind;
    }

    public RichCommandButton getSearchbind() {
        return searchbind;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setPopup(RichPopup popup) {
        this.popup = popup;
    }

    public RichPopup getPopup() {
        return popup;
    }

    public void addRowToDetailTable(ActionEvent actionEvent) {
        // Add event code here...
               
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditcardDetailsVO1Iterator");
        ViewObjectImpl detailsVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
        Row newRow=detailsVO.createRow();
        newRow.setAttribute("createdby", userName);
        newRow.setAttribute("createddate", new java.sql.Date(new java.util.Date().getTime()));
        Object obj=AdfFacesContext.getCurrentInstance().getPageFlowScope().get("countseq");
        countseq = new BigDecimal(obj.toString());
        newRow.setAttribute("Auditcardcntseq", countseq);
        newRow.setAttribute("auditseq", auditseq);
        
        
//        newRow.setAttribute("", arg1);
//        newRow.setAttribute("", arg1);
        detailsVO.insertRow(newRow);
        
    }

    public void setDetailbind(RichTable detailbind) {
        this.detailbind = detailbind;
    }

    public RichTable getDetailbind() {
        return detailbind;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    DCIteratorBinding AuditHeaderdc = bindings.findIteratorBinding("AuditHeaderVO2Iterator");
//            ViewObject AuditHeaderVO = AuditHeaderdc.getViewObject();
//            Row auditRow=AuditHeaderVO.getCurrentRow();
//            auditRow.setAttribute("AuditDate", sqlDate);
//           
//            OperationBinding opBindingDoc = getBindings().getOperationBinding("doCommit");                
//            opBindingDoc.execute();
//            DCIteratorBinding AuditHeaderdc1 = bindings.findIteratorBinding("AuditHeaderVO1Iterator");
//            ViewObject AuditHeaderVO1 = AuditHeaderdc1.getViewObject();
//            Row r=AuditHeaderVO1.getCurrentRow();
//            Object ob=r.getAttribute("AuditSeq");
//            seq= (BigDecimal)ob;
//            DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("AuditCardsearchVO1Iterator");
//            ViewObject auditsearchVO = dcIteratorBinding.getViewObject();
//            Row selectionRowN[] = auditsearchVO.getAllRowsInRange();
//            Integer selectCountN = selectionRowN.length;
//           if(selectCountN>0) {
//               for(int i = 0;i<selectCountN;i++) {
//                   
//                   DCIteratorBinding auditcardcountdtls = bindings.findIteratorBinding("AuditCardsearchVO1Iterator");
//                   ViewObject auditcardcountdtlsVO = auditcardcountdtls.getViewObject(); 
//                   
//                   AuditCardsearchVORowImpl cardcountrow= (AuditCardsearchVORowImpl)auditcardcountdtlsVO.getRowSet().getRowAtRangeIndex(i);
//                   if(cardcountrow!=null) {
//                       DCIteratorBinding Auditcountdetail = bindings.findIteratorBinding("AuditCardcountdtlsVO1Iterator");
//                       ViewObject AuditcountdetailVO = Auditcountdetail.getViewObject();
//                       Row auditdetailrow=AuditcountdetailVO.createRow();
//                       auditdetailrow.setAttribute("Auditseq", seq.add(new BigDecimal(1)));
//                       auditdetailrow.setAttribute("CardTypeCode",selectionRowN[i].getAttribute("CardTypeCode"));
//                       auditdetailrow.setAttribute("Systemcount", selectionRowN[i].getAttribute("totalcards"));
//                       auditdetailrow.setAttribute("actualcount", selectionRowN[i].getAttribute("ActualStock"));
//                       auditdetailrow.setAttribute("createddate", sqlDate);
//                       auditdetailrow.setAttribute("Createdby", "cpms");
//                       AuditcountdetailVO.insertRow(auditdetailrow);    
//
    public String validateDataOnSubmit() {
        String result = "pass";
         DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("AuditcardDetailsVO1Iterator");
          ViewObject AuditcardDetailVO = dcIteratorBinding.getViewObject();
           Row selectionRowN[] = AuditcardDetailVO.getAllRowsInRange();
           Integer selectCountN = selectionRowN.length;
        if (selectCountN>0) {
            for (int i = 0; i < selectCountN; i++) {
                int presentlength =selectionRowN[i].getAttribute("cardnumber").toString().length();
              if(presentlength==cardlength) {
//                  errormsg.setMessage(null);
//                  errormsg.setVisible(false);
              }
                else
              {
                  
                  errormsg.setMessage("Please Enter Valid Card Number.");
                  errormsg.setVisible(true);
                  
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Valid Card Number.", null));    
                result = "fail";
                  
              }
          
            }
        }

      
        return result;
    }





    public void savecards(ActionEvent actionEvent) {
        String result = validateDataOnSubmit();
        if (result.equals("pass")) { 
        OperationBinding op = getBindings().getOperationBinding("doCommit");                
        op.execute();
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditcardDetailsVO1Iterator");
        ViewObjectImpl detailsVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
        detailsVO.executeQuery();
        RichPopup.PopupHints ph = new RichPopup.PopupHints();
        popup.hide();
        countbindtable.getSelectedRowKeys().clear();
        
            errormsg.setMessage(null);
            errormsg.setVisible(false);
        }
        
    }

    public void RollbackbuttonAction(ActionEvent actionEvent) {
        popup.hide();
        countbindtable.getSelectedRowKeys().clear();
    }

    public void setAuditcarddetails(RichTable auditcarddetails) {
        this.auditcarddetails = auditcarddetails;
    }

    public RichTable getAuditcarddetails() {
        return auditcarddetails;
    }

    public void setDetailstablebind(RichTable detailstablebind) {
        this.detailstablebind = detailstablebind;
    }

    public RichTable getDetailstablebind() {
        return detailstablebind;
    }

    public void freezeAction(ActionEvent actionEvent) {
        //dfgsd
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Once data is Freezed, It will not Editable",null)); 
       
        
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.AuditHeaderVO1Iterator.currentRow}"); 
        if(selectedRow != null)
        {
           
            selectedRow.setAttribute("AuditFreezeflag",'Y');
            selectedRow.setAttribute("updatedby", userName);
            selectedRow.setAttribute("updateddate",sqlDate);
        }
        
        OperationBinding op = getBindings().getOperationBinding("doCommit");                
        op.execute();
    
        detailstablebind.setRendered(false);
        panelDetails.setRendered(false);
        countbindtable.setRendered(false);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setvisible","false");
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditHeaderVO2Iterator");
        ViewObject appVO = dcItteratorBinding.getViewObject();
        appVO.executeQuery();
        
        
        // Add event code here...
    }

    public void setFreezebuttonbind(RichCommandButton freezebuttonbind) {
        this.freezebuttonbind = freezebuttonbind;
    }

    public RichCommandButton getFreezebuttonbind() {
        return freezebuttonbind;
    }

    public void setPanelDetails(RichPanelHeader panelDetails) {
        this.panelDetails = panelDetails;
    }

    public RichPanelHeader getPanelDetails() {
        return panelDetails;
    }

    public String AddCardes() {
        DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("setreadonly","true");
        Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.AuditCardcountdtlsVO2Iterator.currentRow}"); 
        try{
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Selected");
        if(selectedRow != null)
        {
            Object seq = selectedRow.getAttribute("Auditcardcntseq");
            Object cardnumber = selectedRow.getAttribute("Cardnumfrom");
            System.out.println(cardnumber.toString().length());
            cardlength=cardnumber.toString().length();
            if(seq != null) 
            {
                 countseq = new BigDecimal(seq.toString());
                 DCIteratorBinding dcItteratorBinding =bindingsAM.findIteratorBinding("AuditcardDetailsVO1Iterator");
                 ViewObjectImpl detailsVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
                 detailsVO.setApplyViewCriteriaName(null);
                 detailsVO.setApplyViewCriteriaName("AuditcardDetailsVOCriteria");
                 detailsVO.setNamedWhereClauseParam("cntSeq", countseq);
                 detailsVO.executeQuery();
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().put("countseq", countseq);
                 RichPopup.PopupHints ph = new RichPopup.PopupHints();
                 popup.show(ph);
                
            }
        }
        }
    
        catch (Exception e) {
                System.out.println("Error occurred..." + e.toString());
                                        }
        
        
        
        
        
        
        
        
        
        
        return null;
    }

    public void setAddbuttonbind(RichCommandButton addbuttonbind) {
        this.addbuttonbind = addbuttonbind;
    }

    public RichCommandButton getAddbuttonbind() {
        return addbuttonbind;
    }

    public void setErrormsg(RichMessage errormsg) {
        this.errormsg = errormsg;
    }

    public RichMessage getErrormsg() {
        return errormsg;
    }
}
