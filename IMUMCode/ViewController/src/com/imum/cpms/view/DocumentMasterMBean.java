package com.imum.cpms.view;

import com.imum.cpms.model.masters.vo.DocMstDtlUVORowImpl;

import com.imum.cpms.model.masters.vo.DocMstHdrUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class DocumentMasterMBean {
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String selectedPermit,country,city,docCatg = null;
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();


    public DocumentMasterMBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    private void DisplayMessage(String str, String Code){
            FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"",genMsg.getMessage(str, lngCode)+Code) );            
        }

    /**Method called on click of New Button
     * @return
     */
    public String New_action() {         
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("addNewDocMaster");
            operationBinding.execute(); 
        return null;
    }
    /**
     * Method to set Selected Permit Type to new Row 
     */
    public void  pushSelectedPermit()
    {
//        DCBindingContainer binding =
//            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        DCIteratorBinding dcItteratorBindings2 =
//            binding.findIteratorBinding("DocMasterUVO2Iterator");   
//        ViewObject vo2 = dcItteratorBindings2.getViewObject();
//        if(vo2!=null)
//        {
//            Row row1 = vo2.getCurrentRow();
//            if(row1!=null && !"".equals(selectedPermit))
//            {
//                row1.setAttribute("DocSubCtg", selectedPermit);    
//                row1.setAttribute("CountryCode", country);   
//                row1.setAttribute("CityCode", city);   
//                row1.setAttribute("DocCtg", docCatg);   
//            }            
//        }    
    }
   


    public String Edit_action() {
        // Add event code here...
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("DocMstHdrUVO2Iterator");
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        Row rowSelected = voTableData.getCurrentRow();
        Object hdrId = rowSelected.getAttribute("PRMDocMstseq");
        System.out.println("Selected PRMDocMstseq is : "+hdrId);
        if(hdrId!=null && !"".equals(hdrId))
        {
             DCIteratorBinding dcItteratorHdr =
                 bindings.findIteratorBinding("DocMstHdrUVO1Iterator");   
             ViewObject hdrVO = dcItteratorHdr.getViewObject();
            DCIteratorBinding dcItteratorDtl =
                bindings.findIteratorBinding("DocMstDtlUVO1Iterator");   
            ViewObject dtlVO = dcItteratorDtl.getViewObject();
            
                                 if(hdrVO!=null)
                                 {
                                     hdrVO.setWhereClause(null);
                                     hdrVO.setWhereClause("PRM_Doc_Mst_seq = "+hdrId);
                                     hdrVO.executeQuery();
                                     System.out.println("Header Row Count : "+hdrVO.getRowCount());
                                     dtlVO.setWhereClause(null);
                                     dtlVO.setWhereClause("PRM_Doc_Mst_seq = "+hdrId);
                                     dtlVO.executeQuery();
                                     System.out.println("Detail Row Count : "+dtlVO.getRowCount());
                                 } 
        }
        return null;
    }

    public String View_action() {
        // Add event code here...      
            Edit_action();  
        return null;
    }
    public void addRowExecute()
    {
//        BindingContainer bindings =
//            BindingContext.getCurrent().getCurrentBindingsEntry();
//        OperationBinding operationBinding = bindings.getOperationBinding("addNewDocDtl");
//        operationBinding.execute();    
    }

    public String AddRow_action() {
        // Add event code here...
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("DocMstDtlUVO1Iterator");
        ViewObject docMstdtVO = dcItteratorBinding.getViewObject();
               DocMstDtlUVORowImpl dtlRow = (DocMstDtlUVORowImpl)docMstdtVO.createRow();
              docMstdtVO.insertRow(dtlRow);
        DCIteratorBinding dcItteratorBindings =
            bindingsAM.findIteratorBinding("DocMstHdrUVO2Iterator");
        ViewObject docMstHVO = dcItteratorBindings.getViewObject();
        DocMstHdrUVORowImpl hdRow = (DocMstHdrUVORowImpl)docMstHVO.last();
            Integer prmDocId = hdRow.getPRMDocMstseq() + 1;
        ViewObjectImpl docMstDtlVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
        DocMstDtlUVORowImpl dtRow = (DocMstDtlUVORowImpl)docMstDtlVO.getCurrentRow();
        if(dtlRow != null && prmDocId != null)
        {
            dtRow.setPRMDocMstseq(prmDocId);
             
            System.out.println("Foreign key on submit is : "+dtRow.getPRMDocMstseq());    
        }    
        else
        {
        System.out.println("Submit denied");    
        }
        return null;
    }

    public String AddRow_Edit_action() {
        // Add event code here...
//        addRowExecute();
//        DCBindingContainer bindingsAM =
//            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        DCIteratorBinding dcItteratorBindings1 =
//            bindingsAM.findIteratorBinding("DocMasterUVO1Iterator");
//        ViewObject voTableData = dcItteratorBindings1.getViewObject();
//        Row rowSelected = voTableData.getCurrentRow();
//        selectedPermit = (String)rowSelected.getAttribute("DocSubCtg");
//        country = (String)rowSelected.getAttribute("CountryCode");
//        city = (String)rowSelected.getAttribute("CityCode");
//        docCatg = (String)rowSelected.getAttribute("DocCtg");
//        DCIteratorBinding dcItteratorBindings2 =
//            bindingsAM.findIteratorBinding("DocMasterUVO2Iterator");   
//        ViewObject vo2 = dcItteratorBindings2.getViewObject();
//        Row currentRow = vo2.getCurrentRow();
//        System.out.println("Current Row primary key in Addrow Edit is : "+currentRow.getAttribute("PRMDocMstseq"));
//        if(currentRow != null)
//        {
//            currentRow.setAttribute("DocSubCtg", selectedPermit);    
//            currentRow.setAttribute("CountryCode", country);   
//            currentRow.setAttribute("CityCode", city);   
//            currentRow.setAttribute("DocCtg", docCatg);   
//        }
    return null;
    }

    public String Submit_action() {
        // Add event code here...
        String result = (String)validateSubmit();
        if(result.equalsIgnoreCase("pass"))
        {
            BindingContainer bindings = getBindings();
            OperationBinding opBinding =
                bindings.getOperationBinding("submitDocMaster");
            opBinding.execute();    
            DisplayMessage("228","");    
        }        
        return null;
    }
    public String validateSubmit()
    {
        String result = "pass";
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =
            bindingsAM.findIteratorBinding("DocMstHdrUVO1Iterator");
        ViewObject docMstHdVO = dcItteratorBinding.getViewObject();
            DocMstHdrUVORowImpl hdRow = (DocMstHdrUVORowImpl)docMstHdVO.getCurrentRow();
            if(hdRow != null)
            {
                Object categ = hdRow.getPrmCategCode();
                Object type = hdRow.getPrmTypeCode();
                Object res = hdRow.getLocalFlag();
                Object relF = hdRow.getRelativeflag();
                Object comF = hdRow.getCompAccomFlag();
                Object activeF = hdRow.getActiveflag();
                if(categ == null || categ.equals(""))
                {
                    DisplayMessage("33","");    
                    result = "fail";
                }
                if(type == null || type.equals(""))
                {
                    DisplayMessage("34","");    
                    result = "fail";
                }
                if(res == null || res.equals(""))
                {
                    DisplayMessage("35","");    
                    result = "fail";
                }
                if(relF == null || relF.equals(""))
                {
                    DisplayMessage("260","");    
                    result = "fail";
                }
                if(comF == null || comF.equals(""))
                {
                    DisplayMessage("261","");    
                    result = "fail";
                }
                if(activeF == null || activeF.equals(""))
                {
                    DisplayMessage("244","");    
                    result = "fail";
                }
                DCIteratorBinding dcItteratorDtl =
                    bindingsAM.findIteratorBinding("DocMstDtlUVO1Iterator");   
                ViewObject dtlVO = dcItteratorDtl.getViewObject();
                if(dtlVO != null)
                {
                    System.out.println("Detail Row Count : "+dtlVO.getFetchedRowCount()); 
                    for(int i = 0; i<dtlVO.getFetchedRowCount() ;i++)
                    {
                        DocMstDtlUVORowImpl dtRow = (DocMstDtlUVORowImpl)dtlVO.getRowAtRangeIndex(i) ;
                        if(dtRow != null)
                        {
                            Object dName = dtRow.getDocName();
                            Object dDesc = dtRow.getDocDesc();
                            Object manF = dtRow.getMandatoryflag();
                            Object actF = dtRow.getActiveflag();
                            if(dName == null || dName.equals(""))
                            {
                                DisplayMessage("38","");    
                                result = "fail";
                            }
                            if(dDesc == null || dDesc.equals(""))
                            {
                                DisplayMessage("39","");    
                                result = "fail";
                            }
                            if(manF == null || manF.equals(""))
                            {
                                DisplayMessage("262","");    
                                result = "fail";
                            }
                            if(actF == null || actF.equals(""))
                            {
                                DisplayMessage("244","");    
                                result = "fail";
                            }
                        }
                    }
                }

            }
            return result;
    }
}
