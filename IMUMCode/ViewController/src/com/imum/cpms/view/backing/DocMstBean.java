package com.imum.cpms.view.backing;

import com.imum.cpms.model.masters.vo.DocMstDtlUVORowImpl;

import com.imum.cpms.model.masters.vo.DocMstHdrUVORowImpl;

import com.imum.cpms.util.MessageUtil;

import java.sql.Timestamp;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.event.RowDisclosureEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;

public class DocMstBean {
    
    private boolean hide = true;
    private boolean visible = true;
    RichTable t3 = new RichTable();
    private boolean isDisabled =false;
    private Integer a;
    private Integer newRuleId;
    MessageUtil genMsg = new MessageUtil();
    FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();
    String userName = httpSession.getAttribute("loggedinUserid").toString();
    Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
    
    public DocMstBean() {
            if(lngCode==null || lngCode.equals(""))
            {
                lngCode = "EN";
            }
        }    
    
    private void addPartialTarget() {
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT3());
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    public static final ADFLogger logger = ADFLogger.createADFLogger(DocMstBean.class);

    public String New_action() {
        // Add event code here...
        setHide(Boolean.FALSE);
        logger.info("Inside New_Action of DocMstBean");
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("addNewDocMaster");
        operationBinding.getParamsMap().put("encoder",userName);
        a = (Integer)operationBinding.execute();
        System.out.println("ruleid " + a);
        newRuleId = a;
        return null;
    }

    public void Edit_action() {
        // Add event code here...
        setHide(Boolean.FALSE);
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding("DocMstHdrUVO2Iterator");
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        if(voTableData != null)
        {
            Row rowSelected = voTableData.getCurrentRow();
            if(rowSelected != null)
            {
                Integer RuleId = (Integer)rowSelected.getAttribute("PRMDocMstseq");
                a=RuleId;
                System.out.println("Edit_action() RuleId"  + a);
                newRuleId = a;
//                if(rowSelected != null)
//                {
                    Object hdrId = rowSelected.getAttribute("PRMDocMstseq");
                    logger.info("Selected PRMDocMstseq in Edit_action is : "+hdrId);
                    
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
                                                 logger.info("Header Row COunt in Edit_action is : "+hdrVO.getRowCount());
                                                 dtlVO.setWhereClause(null);
                                                 dtlVO.setWhereClause("PRM_Doc_Mst_seq = "+hdrId);
                                                 dtlVO.executeQuery();
                                                 logger.info("Detail Row Count in Edit_action is : "+dtlVO.getRowCount());
                                             } 
                    }
//                }
//                else
//                {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Please select row to edit"));       
//                }       
            }
            else
            {
                pageflowScope.put("setvisible", false);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
                
            }
        }

        //return null;
    }

    public String View_action() {
        // Add event code here...
        setHide(Boolean.FALSE);
        Edit_action();
        return null;
    }

    public String Submit_action() {
        // Add event code here...
          String result = (String)validateSubmit();
        BindingContainer bindings = getBindings();
        DCBindingContainer bindingsAM =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                if(result.equalsIgnoreCase("pass"))
                {
                    Row currRowHdr = bindingsAM.findIteratorBinding("DocMstHdrUVO1Iterator").getViewObject().first();
                    if(currRowHdr==null)
                    {
                        currRowHdr = bindingsAM.findIteratorBinding("DocMstHdrUVO1Iterator").getViewObject().getCurrentRow();
                    }
                    if(currRowHdr != null)
                    {
                        Integer rowStatusHdr = (Integer)currRowHdr.getAttribute("rowStatus");
                        if (rowStatusHdr == 2) { 
                            currRowHdr.setAttribute("Updatedby",userName);
                            currRowHdr.setAttribute("Updateddate",sqlDate);
                        }    
                    }
                    OperationBinding opBinding = bindings.getOperationBinding("submitDocMaster");
                    opBinding.execute();    
            /*         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  "  Rule Id Is,'"+a+"'" )); */
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "Document Rule '"+newRuleId+"' saved Successfully"));   
                    setVisible(Boolean.FALSE);
                }else{
                    ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
                    
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
                    Integer ruleId =  (Integer) hdRow.getAttribute("PRMDocMstseq");
                    System.out.println("rule Id" + ruleId);
                    if(null!=ruleId) 
                      a = ruleId;
                    if(hdRow != null)
                    {
                        Object categ = hdRow.getPrmCategCode();
                        Object type = hdRow.getPrmTypeCode();
                        Object res = hdRow.getLocalFlag();
                        Object relF = hdRow.getRelativeflag();
                        Object comF = hdRow.getCompAccomFlag();
                        Object activeF = hdRow.getActiveflag();
                        Object docIdCurrent = hdRow.getPRMDocMstseq();
                        if(categ == null || categ.equals(""))
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("33", lngCode)));    
                            result = "fail";
                        }
                        if(type == null || type.equals(""))
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("34", lngCode)));    
                            result = "fail";
                        }
                        if(res == null || res.equals(""))
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("35", lngCode)));    
                            result = "fail";
                        }
                        if(relF == null || relF.equals(""))
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Relative Flag is Mandatory"));    
                            result = "fail";
                        }
                        if(comF == null || comF.equals(""))
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Company Accomodation Flag is Mandatory"));    
                            result = "fail";
                        }
                        if(activeF == null || activeF.equals(""))
                        {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Active Flag is Mandatory"));    
                            result = "fail";
                        }
                        DCIteratorBinding dcItterator =
                            bindingsAM.findIteratorBinding("DocMstHdrUVO2Iterator");
                        ViewObject headerVO = dcItterator.getViewObject();
                        if(headerVO != null)
                        {
                            Integer count = headerVO.getRowCount();
                            if(count>0)
                            {
                                for(int k=1; k<count; k++)
                                                  {
                                                          DocMstHdrUVORowImpl headerRow =
                                                              (DocMstHdrUVORowImpl)headerVO.getRowAtRangeIndex(k);
                                                      if(headerRow != null)
                                                      {
                                                             logger.info("headerRow row in validateSubmit is : "+k);
                                                             Object fetchSeq = headerRow.getPRMDocMstseq();
                                                              Object prm_ctg = headerRow.getPrmCategCode();
                                                              Object prm_type = headerRow.getPrmTypeCode();
                                                              Object prm_local_flag = headerRow.getLocalFlag();
                                                             if(docIdCurrent != null && fetchSeq.equals(docIdCurrent) && prm_ctg.equals(categ) && prm_type.equals(type) && prm_local_flag.equals(res))
                                                             {
                                                                 k = k+1;
                                                                 headerRow = (DocMstHdrUVORowImpl)headerVO.getRowAtRangeIndex(k);
                                                                 if(headerRow != null)
                                                                 {
                                                                     prm_ctg = headerRow.getPrmCategCode(); 
                                                                     prm_type = headerRow.getPrmTypeCode();
                                                                     prm_local_flag = headerRow.getLocalFlag();    
                                                                 }                                                             
                                                             }                                                         
                                                             logger.info("Row Values during duplicate check is : "+prm_ctg+","+prm_type+","+prm_local_flag);
                                                              if(headerRow != null)
                                                              {
                                                                  if(prm_ctg != null && prm_type != null && prm_local_flag != null && prm_ctg.equals(categ) && prm_type.equals(type) && prm_local_flag.equals(res)) {
                                                                      FacesContext.getCurrentInstance().addMessage(null,
                                                                                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                                                                    "Sample info message",
                                                                                                                                    genMsg.getMessage("36", lngCode)));
                                                                      result = "fail";
                                                                      break;
                                                                  }   
                                                              }                                                         
                                                          }        
                            }
                            }
                        }
                        DCIteratorBinding dcItteratorDtl =
                            bindingsAM.findIteratorBinding("DocMstDtlUVO1Iterator");   
                        ViewObject dtlVO = dcItteratorDtl.getViewObject();
                        if(dtlVO != null)
                        {
                            logger.info("Detail Row Count in ValidateSubmit : "+dtlVO.getFetchedRowCount()); 
                           
                            if(dtlVO.getFetchedRowCount()==0){
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("37", lngCode)));    
                                        result = "fail";
                                        return result;
                                        
                                        }
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
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("38", lngCode)));    
                                        result = "fail";
                                    }
                                    if(dDesc == null || dDesc.equals(""))
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("39", lngCode)));    
                                        result = "fail";
                                    }
                                   /*  if(manF == null || manF.equals(""))
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Mandatory Flag is required"));    
                                        result = "fail";
                                    }
                                    if(actF == null || actF.equals(""))
                                    {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", "Active Flag is Mandatory"));    
                                        result = "fail";
                                    } */
                                }
                            }
                            if(activeF != null & activeF.equals("N"))
                            {
                                for(int p = 0; p<dtlVO.getFetchedRowCount() ;p++)
                                {  
                                    DocMstDtlUVORowImpl dtRow = (DocMstDtlUVORowImpl)dtlVO.getRowAtRangeIndex(p) ;
                                    if(dtRow != null)
                                    {
                                        Object checkActiveFlagDTL = dtRow.getActiveflag();   
                                        if(checkActiveFlagDTL != null && checkActiveFlagDTL.equals("Y"))
                                        {
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("40", lngCode)));    
                                            result = "fail";  
                                            break;
                                        }
                                    }
                                } 
                            }
                            if(result.equalsIgnoreCase("pass"))
                            {
                                for(int i = 0; i<dtlVO.getFetchedRowCount() ;i++)
                                {
                                    DocMstDtlUVORowImpl dtRow = (DocMstDtlUVORowImpl)dtlVO.getRowAtRangeIndex(i) ;
                                    if(dtRow != null)
                                    {
                                        Integer rowStatusHdr = (Integer)dtRow.getAttribute("rowStatus");
                                        if (rowStatusHdr == 2) { 
                                            dtRow.setAttribute("Updatedby",userName);
                                            dtRow.setAttribute("Updateddate",sqlDate);
                                        }         
                                    }
                                }
                            }
                        }
                        if(result.equalsIgnoreCase("pass"))
                        {
                            dtlVO.clearCache();
                             headerVO.clearCache();    
                        }                   
                    }
                    if(result.equalsIgnoreCase("pass"))
                    {
                    
                    docMstHdVO.clearCache();
                    }    
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("303", lngCode)));  
                    result = "fail";  
                }
                return result;
        }

    public String AddRow_action() {
        // Add event code here...
        Integer prmDocId = null;
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding = bindingsAM.findIteratorBinding("DocMstDtlUVO1Iterator");
        ViewObjectImpl docMstDtlVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
        ViewObject docMstdtVO = dcItteratorBinding.getViewObject();                              
        DocMstDtlUVORowImpl dtlRow = (DocMstDtlUVORowImpl)docMstdtVO.createRow();
        dtlRow.setAttribute("CreatedBy", userName);
        dtlRow.setAttribute("CreatedDate", sqlDate);
        docMstdtVO.insertRow(dtlRow);
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("DocMstHdrUVO2Iterator");
        ViewObject docMstHVO = dcItteratorBindings.getViewObject();                
//                DocMstHdrUVORowImpl hdRow = (DocMstHdrUVORowImpl)docMstHVO.first();
        prmDocId = newRuleId;
//                if(hdRow != null)
//                {
//                        prmDocId = hdRow.getPRMDocMstseq(); 
                
                       /* if(prmDocId == null)
                        {
                                prmDocId = 1;
                            }
                        else
                        {
                                prmDocId = prmDocId+1;
                            }*/
//                    }                  
        DocMstDtlUVORowImpl dtRow = (DocMstDtlUVORowImpl)docMstDtlVO.getCurrentRow();
        if(dtlRow != null && prmDocId != null)
        {
            dtRow.setPRMDocMstseq(prmDocId);                 
             newRuleId = prmDocId;
            logger.info("DocID on AddRow_action : "+dtRow.getPRMDocMstseq());    
        }    
        else
        {
        logger.info("Submit denied in AddRow_Action");    
        }
        return null;
    }

    public String AddRow_Edit_action() {
        // Add event code here...
        DCBindingContainer bindingsAM =
                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBinding =
                    bindingsAM.findIteratorBinding("DocMstDtlUVO1Iterator");
        ViewObjectImpl docMstDtlVO = (ViewObjectImpl)dcItteratorBinding.getViewObject();
                ViewObject docMstdtVO = dcItteratorBinding.getViewObject();
                       DocMstDtlUVORowImpl dtlRow = (DocMstDtlUVORowImpl)docMstdtVO.createRow();
        dtlRow.setAttribute("CreatedBy", userName);
        dtlRow.setAttribute("CreatedDate", sqlDate);
                      docMstdtVO.insertRow(dtlRow);
                DCIteratorBinding dcItteratorBindings =
                    bindingsAM.findIteratorBinding("DocMstHdrUVO2Iterator");
                ViewObject docMstHVO = dcItteratorBindings.getViewObject();
                DocMstHdrUVORowImpl hdRow = (DocMstHdrUVORowImpl)docMstHVO.getCurrentRow();
                Integer prmDocId = hdRow.getPRMDocMstseq();                 
                DocMstDtlUVORowImpl dtRow = (DocMstDtlUVORowImpl)docMstDtlVO.getCurrentRow();
                if(dtlRow != null && prmDocId != null)
                {
                    dtRow.setPRMDocMstseq(prmDocId);                                      
                    logger.info("DocID on AddRow_Edit_action : "+dtRow.getPRMDocMstseq());    
                    newRuleId=prmDocId;
                }    
                else
                {
                logger.info("Submit denied in AddRow_Edit_action");    
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

    public boolean isVisible() {
        return visible;
    }

  
    public void handleRowDisclosure(RowDisclosureEvent rowDisclosureEvent)
      throws Exception {
        Object rowKey = null;
        Object rowData = null;
        RichTable rtable = (RichTable) rowDisclosureEvent.getSource();
        RowKeySet rks = rowDisclosureEvent.getAddedSet();
     
        if (rks != null) {
            int setSize = rks.size();
            if (setSize > 1) {
                throw new Exception("Unexpected multiple row disclosure added row sets found.");
            }
            
            if (setSize == 0) {
               // nothing in getAddedSet indicates this is a node
               // contraction, not expansion. If interested only in handling
               // node expansion at this point, return.
               return;
            }
     
            rowKey = rks.iterator().next();
            rtable.setRowKey(rowKey);
            rowData = rtable.getRowData();
     
            // Do whatever is necessary for accessing tree node from
            // rowData, by casting it to an appropriate data structure
            // for example, a Java map or Java bean, and so forth.
       }
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public boolean isIsDisabled() {
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =  bindingsAM.findIteratorBinding("DocMstHdrUVO2Iterator");
        ViewObject vo = dcItteratorBindings.getViewObject();
        if(vo!=null) return vo.getEstimatedRowCount()>0 ? Boolean.FALSE : Boolean.TRUE; 
        else return  Boolean.FALSE;
        
      
    }
}
