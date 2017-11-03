package com.imum.cpms.model;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class AuctionOwnershipmBean {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
              HttpSession httpSession = (HttpSession)externalContext.getSession(false);
            String userName = httpSession.getAttribute("loggedinUserid").toString();
          // String userName="imum";
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    private RichTable auctionPVTTableBind;

    public AuctionOwnershipmBean() {
    }

    public void SelectedBean(SelectionEvent selectionEvent) {
        try {
                ADFUtil.invokeEL("#{bindings.AuctionSearchRVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
               AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit");
             
                Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.AuctionSearchRVO1Iterator.currentRow}"); // get the current selected row
              
            if(selectedRow != null)
              {
                  Object PVTHdrSeq= selectedRow.getAttribute("PVTHDRSEQ");
                  if(PVTHdrSeq != null) 
                  {
                     String PVTHeader = PVTHdrSeq.toString();
                      DCBindingContainer bindings =
                                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                      DCIteratorBinding dcItteratorBindings =
                      bindings.findIteratorBinding("AuctionOwnershipDetailsVO1Iterator");
                      ViewObject PVTTableData = dcItteratorBindings.getViewObject();
                      PVTTableData.clearCache();
                      PVTTableData.setWhereClause(null);
                      PVTTableData.setWhereClause("PVT_HDR_SEQ = '"+PVTHdrSeq+"'");
                      PVTTableData.executeQuery();
                     
                     // auctionForm.setRendered(true);
                      //AdfFacesContext.getCurrentInstance().addPartialTarget(auctionForm); 
                  }
              }
           }
        catch (Exception e) 
        {
                   System.out.println("Error occurred..." + e.toString());
        }
    }

   

        public String Submit() {
            BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
            DCBindingContainer bindings1 =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings =bindings1.findIteratorBinding("AuctionOwnershipDetailsVO1Iterator");
            ViewObject vo = dcItteratorBindings.getViewObject();
            Row r= vo.getCurrentRow();
            r.setAttribute("Updatedby", userName);
            r.setAttribute("Updateddate", sqlDate);
            OperationBinding opBinding;
            opBinding = bindings.getOperationBinding("doCommit");
            String result = opBinding.execute().toString(); 
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit1");
            auctionPVTTableBind.getSelectedRowKeys().clear();
            AdfFacesContext.getCurrentInstance().addPartialTarget(auctionPVTTableBind); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PVT details saved Successfully.",null));    
            return null;
        }
        
        public void  Cancel(ActionEvent actionEvent){
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit1");
            BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("doRollback").execute();
            auctionPVTTableBind.getSelectedRowKeys().clear();
            AdfFacesContext.getCurrentInstance().addPartialTarget(auctionPVTTableBind); 
            
        }

    public void setAuctionPVTTableBind(RichTable auctionPVTTableBind) {
        this.auctionPVTTableBind = auctionPVTTableBind;
    }

    public RichTable getAuctionPVTTableBind() {
        return auctionPVTTableBind;
    }
}


