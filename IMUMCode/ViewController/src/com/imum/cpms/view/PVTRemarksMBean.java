package com.imum.cpms.view;

import com.imum.cpms.util.FileUpload;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.VariableValueManager;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class PVTRemarksMBean {
    private Row currentAttchmtRow=null;
    BigDecimal PvthdrSeqBD = null; 
    FacesContext facesContext = FacesContext.getCurrentInstance();

    ExternalContext externalContext = facesContext.getExternalContext();
    
    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    private RichInputText remarksBind;
    private RichInputFile uploadDoc;
    private RichTable selectedtable;

    public PVTRemarksMBean() {
    }
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void SelectPVTRow(SelectionEvent selectionEvent) {
        // Add event code here...
     
        try
        {
            ADFUtil.invokeEL("#{bindings.PVTSearchRVO11.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PVTSearchRVO1Iterator.currentRow}"); // get the current selected row
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Selected");
            if(selectedRow != null)
            {
                Object PVTHDRSEQ = selectedRow.getAttribute("PVTHDRSEQ");
                if(PVTHDRSEQ != null) 
                {
                     PvthdrSeqBD = new BigDecimal(PVTHDRSEQ.toString());
                     
                }
            }
        }
        catch (Exception e) {
                    System.out.println("Error occurred..." + e.toString());
                                            }
    }

    public void uploadFile(ValueChangeEvent vce) {
         
        String uploadPath = null;
        String fullPath = null;
        FileUpload fl = new FileUpload();
        
        DCIteratorBinding bind =
            getBindings().findIteratorBinding("PVTSearchRVO1Iterator");
        String PVTNumber =
            bind.getViewObject().getCurrentRow().getAttribute("PVTHDRSEQ") ==
            null ? "" :
            bind.getViewObject().getCurrentRow().getAttribute("PVTHDRSEQ").toString();
        
        String PVTNumberN =
            bind.getViewObject().getCurrentRow().getAttribute("PVTNum") ==
            null ? "" :
            bind.getViewObject().getCurrentRow().getAttribute("PVTNum").toString();
        
        RichInputFile inputFileComponent = (RichInputFile)vce.getComponent();
        UploadedFile newFile = (UploadedFile)vce.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());

      
     
      
         if (null != vce.getNewValue()) {
            UploadedFile uploadFile =
                (UploadedFile)vce.getNewValue();

            if (uploadFile != null) {
                uploadPath =
                        fl.uploadFilesToFolder("1", "PVT", PVTNumberN, uploadFile);
                if (uploadPath != null) {
                    fullPath = uploadPath + "//" + uploadFile.getFilename();
                }
                String docFielName = uploadFile.getFilename();
                java.sql.Date sqlDate =
                    new java.sql.Date(new java.util.Date().getTime());
                System.out.println("sqlDate is : " + sqlDate);
                 int docType = getFileExtension(docFielName);
                 
                OperationBinding op =
                    getBindings().getOperationBinding("CreateNewPVTDocument");
                op.getParamsMap().put("username",
                                     userName);
                op.getParamsMap().put("fullPath",
                                      fullPath);
                op.getParamsMap().put("pvtHdrseq",
                                      PVTNumber);
                op.getParamsMap().put("doctype",
                                      docType);
                op.getParamsMap().put("DOCDesc",
                                      docFielName);
                
                
                op.execute();
                
                
                
                
     }

        }

      

    }
    private static int getFileExtension(String file) {
    String fileName = file;
    String extType = null;
    int docType = 0;
    if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
        extType = fileName.substring(fileName.lastIndexOf(".")+1);
        //.gif.bmp.dib.jpg.jpe.jfif.tiff.tif
        if(extType != null && extType.equalsIgnoreCase("jpeg")|| extType.equalsIgnoreCase("png") ||
        extType.equalsIgnoreCase("gif")|| extType.equalsIgnoreCase("bmp")||extType.equalsIgnoreCase("dib")|| extType.equalsIgnoreCase("jpg")||
        extType.equalsIgnoreCase("jfif")|| extType.equalsIgnoreCase("tiff")||extType.equalsIgnoreCase("tif")){
            extType = "IMAGE";
            docType = 2;
        }else if(extType != null && extType.equalsIgnoreCase("xml")){
            extType = "XML";
            docType=3;
        }else if(extType != null && extType.equalsIgnoreCase("pdf") || extType.equalsIgnoreCase("docx") || extType.equalsIgnoreCase("doc") ||extType.equalsIgnoreCase("xlsx")
               || extType.equalsIgnoreCase("xls") || extType.equalsIgnoreCase("txt")){
            extType = "PDF";
            docType=3;
        }else if(extType != null && ( extType.equalsIgnoreCase("MPG")|| extType.equalsIgnoreCase("MPEG"))){
            extType = "Video";
            docType=4;
        }
        return docType;
    }
    
    else return docType;
    }

    public void setCurrentAttchmtRow(Row currentAttchmtRow) {
        this.currentAttchmtRow = currentAttchmtRow;
    }

    public Row getCurrentAttchmtRow() {
        return currentAttchmtRow;
    }

    public String Submit() {
        // Add event code here...
        if(getRemarksBind().getValue() == null && getUploadDoc().getValue() == null) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please enter either Remarks or Upload Document."));
            return null;
        }
//        if(getUploadDoc().getValue() == null)
//        {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please upload document."));
//            return null;  
//        }
        
        if(getRemarksBind().getValue() != null)
        {
            String remarks = getRemarksBind().getValue().toString();
            OperationBinding op =
                getBindings().getOperationBinding("CreateNewRemarks");
            op.getParamsMap().put("username",
                                userName);
            op.getParamsMap().put("remarks",
                                  remarks);
            op.getParamsMap().put("PvthdrSeqBD",
                                  PvthdrSeqBD);
            
            
            
            op.execute();
         
          
            
            if(op.getErrors().isEmpty())
            {
            OperationBinding opcommit =
                getBindings().getOperationBinding("doCommit");
                opcommit.execute();
                if(opcommit.getErrors().isEmpty())
                {
                    OperationBinding opproc =
                        getBindings().getOperationBinding("PVTDocsSeibelSync");
                    
                    opproc.execute();
                    
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","PVT Details saved successfully."));
                    selectedtable.getSelectedRowKeys().clear();
                    getRemarksBind().setValue(null);
                    getUploadDoc().setValue(null);
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","NoSelected");
                    
                }
            }
            
            
        }
        return null;
    }

    public void setRemarksBind(RichInputText remarksBind) {
        this.remarksBind = remarksBind;
    }

    public RichInputText getRemarksBind() {
        return remarksBind;
    }

    public String cancel() {
        // Add event code here...
        getBindings().getOperationBinding("doRollback").execute();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","NoSelected");
        getRemarksBind().setValue(null);
        getUploadDoc().setValue(null);
        return null;
    }

    public void setUploadDoc(RichInputFile uploadDoc) {
        this.uploadDoc = uploadDoc;
    }

    public RichInputFile getUploadDoc() {
        return uploadDoc;
    }

    public void setSelectedtable(RichTable selectedtable) {
        this.selectedtable = selectedtable;
    }

    public RichTable getSelectedtable() {
        return selectedtable;
    }
}
