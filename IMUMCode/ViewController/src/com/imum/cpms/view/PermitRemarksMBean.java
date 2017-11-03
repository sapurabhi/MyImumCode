package com.imum.cpms.view;

import com.imum.cpms.util.FileUpload;

import java.math.BigDecimal;

import java.sql.Timestamp;

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

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class PermitRemarksMBean {
    private RichInputText remarksBind;
    
    BigDecimal PRMHeaderseqBD = null; 
    FacesContext facesContext = FacesContext.getCurrentInstance();

    ExternalContext externalContext = facesContext.getExternalContext();
    
    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    private RichInputFile uploadDoc;
    private RichTable selectedtable;


    public PermitRemarksMBean() {
    }
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void selectedPermit(SelectionEvent selectionEvent) 
    {
        // Add event code here...
        try
        {
            ADFUtil.invokeEL("#{bindings.PermitSearchCriteriaVO1.collectionModel.makeCurrent}", new Class[] {SelectionEvent.class},new Object[] { selectionEvent });
           
            Row selectedRow = (Row)ADFUtil.evaluateEL("#{bindings.PermitSearchCriteriaVO1Iterator.currentRow}"); 
           
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Selected");
            if(selectedRow != null)
            {
                Object PRMHeaderseq = selectedRow.getAttribute("PRMHeaderseq");
                if(PRMHeaderseq != null) 
                {
                     PRMHeaderseqBD = new BigDecimal(PRMHeaderseq.toString());
                }
            }
                
        }
        catch (Exception e) {
                    System.out.println("Error occurred..." + e.toString());
                                            }
    }
    
    public String Submit() {
        // Add event code here...
        if(getRemarksBind().getValue() == null &&  getUploadDoc().getValue() == null) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please  enetr Remarks or Upload Documents."));
            return null;
        }
//         if(getUploadDoc().getValue() == null)
//        {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message","Please upload document."));
//            return null;  
//        } 
        
        if(getRemarksBind().getValue() != null)
        {
            String remarks = getRemarksBind().getValue().toString();
//            OperationBinding op =
//                getBindings().getOperationBinding("CreateNewRemarks");
//            op.getParamsMap().put("username",
//                                 userName);
//            op.getParamsMap().put("remarks",
//                                  remarks);
//            op.getParamsMap().put("PRMHeaderseqBD",
//                                  PRMHeaderseqBD);
            
            
            
           // op.execute();
           Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
           DCBindingContainer AM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
           DCIteratorBinding dccourt =AM.findIteratorBinding("PermitRemarksEntityDetailsVO1Iterator");
                    ViewObjectImpl permiteventvo =(ViewObjectImpl)dccourt.getViewObject();
                       if (permiteventvo != null) {
                        Row permitrow = permiteventvo.createRow();
                        permitrow.setAttribute("CreatedBy",userName);
                        permitrow.setAttribute("CreatedDate",sqlDate);
                        permitrow.setAttribute("EVENTDATE",sqlDate);
                        permitrow.setAttribute("EVENTID","134");
                        permitrow.setAttribute("PRMHeaderseq",PRMHeaderseqBD);
                        permitrow.setAttribute("Remarks",remarks);
                        permiteventvo.insertRow(permitrow);
                    }
            
           
            OperationBinding opcommit = getBindings().getOperationBinding("doCommit");
                opcommit.execute();
            permiteventvo.executeQuery();
                if(opcommit.getErrors().isEmpty())
                {
                    OperationBinding opproc =getBindings().getOperationBinding("PermitDocsSeibelSync");
                    
                    opproc.execute();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message","Permit Details saved successfully."));
                    getRemarksBind().setValue(null);
                    getUploadDoc().setValue(null);

                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","NoSelected");
                    selectedtable.getSelectedRowKeys().clear();
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

    public void uploadFile(ValueChangeEvent vce) {
        String uploadPath = null;
        String fullPath = null;
        FileUpload fl = new FileUpload();
        
        DCIteratorBinding bind =
            getBindings().findIteratorBinding("PermitSearchCriteriaVO1Iterator");
        String PermitNumber =
            bind.getViewObject().getCurrentRow().getAttribute("PRMHeaderseq") ==
            null ? "" :
            bind.getViewObject().getCurrentRow().getAttribute("PRMHeaderseq").toString();
        
        String PermitNumberN =
            bind.getViewObject().getCurrentRow().getAttribute("PermitNumber") ==
            null ? "" :
            bind.getViewObject().getCurrentRow().getAttribute("PermitNumber").toString();
        
        RichInputFile inputFileComponent = (RichInputFile)vce.getComponent();
        UploadedFile newFile = (UploadedFile)vce.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());

        
        
        
         if (null != vce.getNewValue()) {
            UploadedFile uploadFile =
                (UploadedFile)vce.getNewValue();

            if (uploadFile != null) {
                uploadPath =
                        fl.uploadFilesToFolder("1", "PERMIT", PermitNumberN, uploadFile);
                if (uploadPath != null) {
                    fullPath = uploadPath + "//" + uploadFile.getFilename();
                }
                String docFielName = uploadFile.getFilename();
                java.sql.Date sqlDate =
                    new java.sql.Date(new java.util.Date().getTime());
                System.out.println("sqlDate is : " + sqlDate);
                 int docType = getFileExtension(docFielName);
                 
                OperationBinding op =
                    getBindings().getOperationBinding("CreateNewPermitDocument");
                op.getParamsMap().put("username",
                                     userName);
                op.getParamsMap().put("fullPath",
                                      fullPath);
                op.getParamsMap().put("Prmseq",
                                      PermitNumber);
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

    public void setUploadDoc(RichInputFile uploadDoc) {
        this.uploadDoc = uploadDoc;
    }

    public RichInputFile getUploadDoc() {
        return uploadDoc;
    }

    public String cancel() {
        // Add event code here...
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","NoSelected");
        getRemarksBind().setValue(null);
        getUploadDoc().setValue(null);
        selectedtable.getSelectedRowKeys().clear();
        getBindings().getOperationBinding("doRollback").execute();
        return null;
    }

    public void setSelectedtable(RichTable selectedtable) {
        this.selectedtable = selectedtable;
    }

    public RichTable getSelectedtable() {
        return selectedtable;
    }
}
