package com.imum.cpms;

import com.imum.cpms.model.masters.vo.SectorMstLngVOImpl;
import com.imum.cpms.model.masters.vo.SectorMstLngVORowImpl;
import com.imum.cpms.model.masters.vo.SectorMstVORowImpl;
import com.imum.cpms.util.ADFUtils;
import com.imum.cpms.util.FileUpload;

import java.util.ArrayList;
import java.util.List;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.jbo.ViewObject;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import java.sql.Date;

import javax.faces.context.ExternalContext;

import javax.servlet.http.HttpSession;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.binding.BindingContainer;

import oracle.jbo.VariableValueManager;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.server.ViewRowImpl;

import org.apache.myfaces.trinidad.ADFUtil;
import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;
import com.imum.cpms.util.MessageUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.jbo.ApplicationModule;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;

public class sectorMBean {
    private Boolean DisableViewEditBtn;
    private Boolean viewBtnClicked = true;
    private Boolean showSubmitCancelBtn = false;
    private RichShowDetailHeader secDetailsLayout;
    private RichPanelGroupLayout newEditViewBtnLayout;
    private Integer hSpace = 425;
    private List<UploadedFile> uploadedFiles;
    private Boolean editClicked = Boolean.FALSE;
    private Boolean clickedNewButton = Boolean.TRUE;
    FacesContext facesContext = FacesContext.getCurrentInstance();

    ExternalContext externalContext = facesContext.getExternalContext();

    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
        MessageUtil genMsg = new MessageUtil();
        String lngCode = httpSession.getAttribute("language").toString();

    private RichTable docTable;
    private Row currentAttchmtRow=null;
    public static final ADFLogger logger = ADFLogger.createADFLogger(LocationMstBean.class);
    String actionMode=null;
    private RichCommandLink filePropertyCommandLink;
    private  Date GoLiveDtforcheck ;

    public sectorMBean() {
    }
    
    public void  addUploadDoc(ActionEvent actionEvent) {
        ViewObject docVo = getBindings().findIteratorBinding("GenRefDataDocVO1Iterator").getViewObject();
        Row newRow = docVo.createRow();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
//        newRow.setAttribute("", );
        newRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
//        newRow.setAttribute("CreatedDate", sqlDate);
        
       
        docVo.insertRow(newRow);
        
    }
    
    public void fileUploadVCE(ValueChangeEvent vce) {
        String uploadPath = null;
        String fullPath = null;
        FileUpload fl = new FileUpload();
        
        DCIteratorBinding bind =
            getBindings().findIteratorBinding("SectorMstVO1Iterator");
        String SectorCode =
            bind.getViewObject().getCurrentRow().getAttribute("SectorCode") ==
            null ? "" :
            bind.getViewObject().getCurrentRow().getAttribute("SectorCode").toString();
        
        RichInputFile inputFileComponent = (RichInputFile)vce.getComponent();
        UploadedFile newFile = (UploadedFile)vce.getNewValue();
        inputFileComponent.getClientId(FacesContext.getCurrentInstance());

//        BindingContext bindingctx = BindingContext.getCurrent();
//        BindingContainer binding = bindingctx.getCurrentBindingsEntry();
//        DCBindingContainer bindingsImpl = (DCBindingContainer)binding;

        //Code for testing
        DCIteratorBinding dciterrefundattchmt = getBindings().findIteratorBinding("GenRefDataDocVO1Iterator");
        currentAttchmtRow =
                dciterrefundattchmt.getRowAtRangeIndex(getDocTable().getRowIndex());

        if (null != vce.getNewValue()) {
            UploadedFile uploadFile =
                (UploadedFile)vce.getNewValue();

            if (uploadFile != null) {
                uploadPath =
                        fl.uploadFilesToFolder("1", "SECTOR", SectorCode, uploadFile);
                if (uploadPath != null) {
                    fullPath = uploadPath + "//" + uploadFile.getFilename();
                }
                String docFielName = uploadFile.getFilename();
                java.sql.Date sqlDate =
                    new java.sql.Date(new java.util.Date().getTime());
                System.out.println("sqlDate is : " + sqlDate);
                
                /*start of code to get RelatedTo value */
                ViewObjectImpl headerVo = (ViewObjectImpl) getBindings().findIteratorBinding("GenRefDataHeaderMstRVO1Iterator").getViewObject();
                
                headerVo.applyViewCriteria(null);
                headerVo.applyViewCriteria(headerVo.getViewCriteria("GetByRefGroupCode"));
                VariableValueManager evm = headerVo.ensureVariableManager();
                evm.setVariableValue("BindRefGroupCode", "GEN_DOC_RELATED_TO");
                headerVo.executeQuery();
                
                ViewObjectImpl detailVo =(ViewObjectImpl) getBindings().findIteratorBinding("GenRefDataDetailMstRVO1Iterator").getViewObject();
                
                detailVo.applyViewCriteria(null);
                detailVo.applyViewCriteria(detailVo.getViewCriteria("GetByRefHeaderSeqAndValueDesc"));
                VariableValueManager evm1 = detailVo.ensureVariableManager();
                evm1.setVariableValue("BindRefDataHeaderSeq", Integer.parseInt(headerVo.first().getAttribute("RefdataHeaderseq").toString()));
                evm1.setVariableValue("BindValueDesc", "SECTOR");
                detailVo.executeQuery();
                /*end of code */
                int docType = getFileExtension(docFielName);
                String userName = httpSession.getAttribute("loggedinUserid").toString();
//                String userName = "vara";
                currentAttchmtRow.setAttribute("CreatedBy", userName);
//                currentAttchmtRow.setAttribute("CreatedDate", sqlDate);
                currentAttchmtRow.setAttribute("Updatedby", userName);
//                currentAttchmtRow.setAttribute("UpdatedDate", sqlDate);
                currentAttchmtRow.setAttribute("filepath", fullPath);
                currentAttchmtRow.setAttribute("referenceid",SectorCode);
//                currentAttchmtRow.setAttribute("Docstage", documentStage);
                currentAttchmtRow.setAttribute("RELATEDTO", Integer.parseInt(detailVo.first().getAttribute("ValueCode").toString()));
                currentAttchmtRow.setAttribute("deleteflag", "N");
                currentAttchmtRow.setAttribute("doctype", docType);
                
//                SecDocRow.setAttribute("RELATEDTO",Integer.parseInt(getGenRefDataDetailMstRVO1().first().getAttribute("ValueCode").toString()));//Value of Value_Code in "Gen_Ref_Data_Detail_Mst" whose Ref_Data_Header_Seq is 13 & value_description is "Sector".
//                SecDocRow.setAttribute("referenceid",Sectorcode);
//                SecDocRow.setAttribute("filepath",uploadFiles.get(i));
//                SecDocRow.setAttribute("doctype",doctype);
//                SecDocRow.setAttribute("deleteflag","N");

            } else {
                DisplayMessage("251","");
//                return "fail";
            }

        }

//        return validaion;


    }

    public void viewCurrentSector(ActionEvent actionEvent) {
        if(getBindings().findIteratorBinding("SectorMstVO1Iterator").getEstimatedRowCount()>0){
        actionMode="view";

        ViewObjectImpl mstVO = (ViewObjectImpl)getSectorMstVO();
        if (mstVO.getCurrentRow() == null) {
            mstVO.setCurrentRow(mstVO.first());
        }


        OperationBinding binding =
            getBindings().getOperationBinding("getZonesOfSector");
        String sectorCode =  mstVO.getCurrentRow().getAttribute("SectorCode").toString();
        binding.getParamsMap().put("Sector",sectorCode);
        binding.execute();
        
        
        setSectorMstLngData(sectorCode,mstVO);

        /* Show Sector Details Layout*/
        secDetailsLayout.setVisible(true);

        /* show Sector Details in Read-Only Mode */
        setViewBtnClicked(Boolean.TRUE);

        /* Show buttons Submit, Cancel*/
        setShowSubmitCancelBtn(Boolean.TRUE);

        /* In "New Sector Creation" Scenario, Hide New, Edit & View Buttons*/
        newEditViewBtnLayout.setVisible(Boolean.FALSE);
        //setting FALSE for when the use select the VIEW button
        setEditClicked(Boolean.FALSE);
        }else{DisplayMessage("303", " No records to Edit or View");}//303
    }

    public void editCurrentSector(ActionEvent actionEvent) {
            if(getBindings().findIteratorBinding("SectorMstVO1Iterator").getEstimatedRowCount()>0){
        /*Hide New, Edit & View Buttons*/
        //        newEditViewBtnLayout.setVisible(Boolean.FALSE);
        actionMode="edit";
        ViewObjectImpl mstVO = (ViewObjectImpl)getSectorMstVO();
        if (mstVO.getCurrentRow() == null) {
            mstVO.setCurrentRow(mstVO.first());
        }
        if(mstVO.getCurrentRow() != null)
        {
            GoLiveDtforcheck =  (Date) mstVO.getCurrentRow().getAttribute("GoLiveDate");
           
        }

        OperationBinding binding =
            getBindings().getOperationBinding("getZonesOfSector");
        String sectorCode=mstVO.getCurrentRow().getAttribute("SectorCode").toString();
        binding.getParamsMap().put("Sector",sectorCode);
        binding.execute();
        
        setSectorMstLngData(sectorCode,mstVO);
      

        /* Show Sector Details Layout*/
        secDetailsLayout.setVisible(true);

        /* show Sector Details in Edit Mode */
        setViewBtnClicked(Boolean.FALSE);

        /* Show buttons Submit, Cancel*/
        setShowSubmitCancelBtn(Boolean.TRUE);

        /* In "New Sector Creation" Scenario, Hide New, Edit & View Buttons*/
        newEditViewBtnLayout.setVisible(Boolean.FALSE);
        setEditClicked(Boolean.TRUE);
        clickedNewButton = Boolean.TRUE;

        }else{DisplayMessage("303", " No records to Edit or View");}//303
    }

    public void createNewSector(ActionEvent actionEvent) {

        /* Create & New sector record */
        actionMode="new";
        OperationBinding op =
            getBindings().getOperationBinding("createNewSector");
        op.getParamsMap().put("username",
                              httpSession.getAttribute("loggedinUserid").toString());
        op.execute();

        OperationBinding binding =
            getBindings().getOperationBinding("getZonesOfSector");
        binding.getParamsMap().put("Sector", "");
        binding.execute();

        /* Show Sector Details Layout*/
        secDetailsLayout.setVisible(true);

        /* show Sector Details in Edit Mode */
        setViewBtnClicked(Boolean.FALSE);

        /* Show buttons Submit, Cancel*/
        setShowSubmitCancelBtn(Boolean.TRUE);


        /* In "New Sector Creation" Scenario, Hide New, Edit & View Buttons*/
        newEditViewBtnLayout.setVisible(Boolean.FALSE);
        //setting FALSE for when the use select the NEW button
        setEditClicked(Boolean.FALSE);
        clickedNewButton = Boolean.FALSE;


    }
    
    
    public void setSectorMstLngData(String sectorCode,ViewObjectImpl mstVO){
        //Getting Data from Sector Master Language Table
         String lang = httpSession.getAttribute("language").toString();       
         getSectorMstLngVO().setWhereClause("Sector_Code='"+sectorCode+"'");
         getSectorMstLngVO().executeQuery();
         RowSetIterator sectorIterator =getSectorMstLngVO().createRowSetIterator(null);
         while (sectorIterator.hasNext()) {
         Row sectorRow = sectorIterator.next();
            if(sectorRow!=null){
                String selectLang=(String)sectorRow.getAttribute("LNGCODE");
                    if(("EN".equalsIgnoreCase(lang) && "AR".equalsIgnoreCase(selectLang))||("AR".equalsIgnoreCase(lang) && "EN".equalsIgnoreCase(selectLang))){
                     System.out.println("Sector Code ::::::::::    "+mstVO.getCurrentRow().getAttribute("SectorCode"));
                     mstVO.getCurrentRow().setAttribute("Language", selectLang);
                             mstVO.getCurrentRow().setAttribute("SectorNameLng", sectorRow.getAttribute("SectorName")); 
                         } 
                         System.out.println("SectorName :::::::::::::::  "+sectorRow.getAttribute("SectorName"));
                     }
           }
        ViewObjectImpl zoneVO = (ViewObjectImpl)getZoneVO();
        ViewObjectImpl zoneLngVO = (ViewObjectImpl)getZoneLngVO();
        getZoneVO().setWhereClause("Sector_Code='"+sectorCode+"'");
                getZoneVO().executeQuery();
                RowSetIterator zoneIterator =getZoneVO().createRowSetIterator(null);
               
                while (zoneIterator.hasNext()) {
                Row zoneRow = zoneIterator.next();                   
                   if(zoneRow!=null){
                       /*Start*/
                       String zoneCode=(String)zoneRow.getAttribute("ZoneCode");
                       getZoneMstLngVO().setWhereClause(null);
                       getZoneMstLngVO().setWhereClause("Zone_Code='"+zoneCode+"'");
                       getZoneMstLngVO().executeQuery();
                       RowSetIterator zoneMstIterator =getZoneMstLngVO().createRowSetIterator(null);
                       
                       while (zoneMstIterator.hasNext()) {
                       Row zoneMstRow = zoneMstIterator.next();
                          if(zoneMstRow!=null){
                              String selectLang=(String)zoneMstRow.getAttribute("LNGCODE");
                                  if(("EN".equalsIgnoreCase(lang) && "AR".equalsIgnoreCase(selectLang))||("AR".equalsIgnoreCase(lang) && "EN".equalsIgnoreCase(selectLang))){
                                   //System.out.println("Zone Code ::::::::::    "+zoneVO.getCurrentRow().getAttribute("ZoneCode"));
                                
                                   zoneLngVO.first().setAttribute("LanguageZone", selectLang);
                                    zoneRow.setAttribute("ZoneNameLng", zoneMstRow.getAttribute("ZoneName")); 
                                 } 
                                System.out.println("ZoneName :::::::::::::::  "+zoneMstRow.getAttribute("ZoneName"));
                          }   
                     }
                         
                       //End
                   }
                   
                }
                
        getZoneMstLngVO().clearCache();
        getZoneMstLngVO().setWhereClause(null);
        getZoneMstLngVO().executeQuery();
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


    public void submitSectorChanges(ActionEvent actionEvent) {

        // Commit changes to DB
        DCIteratorBinding binding =
            getBindings().findIteratorBinding("SectorMstVO1Iterator");
        String SectorCode =
            binding.getViewObject().getCurrentRow().getAttribute("SectorCode") ==
            null ? "" :
            binding.getViewObject().getCurrentRow().getAttribute("SectorCode").toString();
        String SectorName =
            binding.getViewObject().getCurrentRow().getAttribute("SectorName") ==
            null ? "" :
            binding.getViewObject().getCurrentRow().getAttribute("SectorName").toString();
        String CommunityCode =
            binding.getViewObject().getCurrentRow().getAttribute("CommunityCode") ==
            null ? "" :
            binding.getViewObject().getCurrentRow().getAttribute("CommunityCode").toString();
        String BayCount =
            binding.getViewObject().getCurrentRow().getAttribute("BayCount") ==
            null ? "" :
            binding.getViewObject().getCurrentRow().getAttribute("BayCount").toString();
        String sectorlngname =
            binding.getViewObject().getCurrentRow().getAttribute("SectorNameLng") ==
            null ? "" :
            binding.getViewObject().getCurrentRow().getAttribute("SectorNameLng").toString();
        
        
        String language =(String)binding.getViewObject().getCurrentRow().getAttribute("Language");
        String zoneLanguage =(String)getZoneLngVO().getCurrentRow().getAttribute("LanguageZone");
        String selectedLanguage = httpSession.getAttribute("language").toString();
        String sectorNameLng = (String)binding.getViewObject().getCurrentRow().getAttribute("SectorNameLng");
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                
        java.sql.Date sysDate = new java.sql.Date(new java.util.Date().getTime());
        java.sql.Date SysDate = java.sql.Date.valueOf(sysDate.toString());
      

        Boolean isError = false;
        
        if(language.equalsIgnoreCase(selectedLanguage)){
            isError = true;
            DisplayMessage("288","");
        }
        if(sectorlngname.equalsIgnoreCase("")) {
            isError = true;
            DisplayMessage("253","");
        }

        /* null sector code check */

        if (SectorCode.equalsIgnoreCase("")) {
            isError = true;
            DisplayMessage("252","");
        }

        if (SectorName.equalsIgnoreCase("")) {
            isError = true;
            DisplayMessage("253","");
        }

        if (CommunityCode.equalsIgnoreCase("")) {
            isError = true;
            DisplayMessage("254","");
        }

        if (BayCount.equalsIgnoreCase("")) {
            isError = true;
            DisplayMessage("255","");
        }
        
            if (binding.getViewObject().getCurrentRow().getAttribute("GoLiveDate")==null) {
                isError = true;
                DisplayMessage("284","");
            }
            
            Date SectorGoLiveDate = (Date)binding.getViewObject().getCurrentRow().getAttribute("GoLiveDate");

            if(!isError){
        //Zone Details --Setting Sector Code
//        getBindings().findIteratorBinding("ZoneMstVO1Iterator").executeQuery();
        ViewObject zoneVO = getZoneVO();
        Row[] allZoneRows = zoneVO.getAllRowsInRange();
        Row[] ZRowsToCmp = allZoneRows; 

        for (Row curRow : allZoneRows) {

        /* commented for testing                  
            EntityImpl entity = ((ViewRowImpl)curRow).getEntity(0);
            if(EntityImpl.STATUS_MODIFIED == entity.getEntityState() || EntityImpl.STATUS_NEW == entity.getEntityState())
            { */

            if (curRow.getAttribute("ZoneCode") == null) {
                DisplayMessage("256","");
                isError = true;
                break;
            }
            if (curRow.getAttribute("ZoneName") == null) {
                DisplayMessage("257","");
                isError = true;
                break;
            }
            
            if (curRow.getAttribute("GoLiveDate") == null) {
                DisplayMessage("283","");
                isError = true;
                break;
            }
            
            if (curRow.getAttribute("ZoneNameLng") == null) {
                DisplayMessage("294","");
                isError = true;
                break;
            }
            
            /* unique zonecode check start */
            int dupCount =0;
            String ZoneCode = curRow.getAttribute("ZoneCode").toString();
            for(Row cmpRow : ZRowsToCmp){
                    if(ZoneCode.equalsIgnoreCase(cmpRow.getAttribute("ZoneCode").toString())) dupCount++;
            }
         
            if(dupCount>1){
                    DisplayMessage("281",ZoneCode);
                    isError=true;
                    break;
                }
        
            
            /* end */
            
            /* unique ZoneName check start */
            dupCount =0;
            String ZoneName = curRow.getAttribute("ZoneName").toString();
            for(Row cmpRow : ZRowsToCmp){
                    if(ZoneName.equalsIgnoreCase(cmpRow.getAttribute("ZoneName").toString())) dupCount++;
            }        
            
            if(dupCount>1){
                    DisplayMessage("282",ZoneName);
                    isError=true;
                    break;
                }
            
            
            /* end */
      /* Zone's GoLive Date should be greater than or equal to Sector's GoLiveDate*/      
      Date ZoneGoLiveDate = (Date) curRow.getAttribute("GoLiveDate");
            if(SectorGoLiveDate.after(ZoneGoLiveDate) ){
                    DisplayMessage("285","");
                    isError=true;
                    break;
                }
            
            /* end */
            String ZoneNameLng = (String)curRow.getAttribute("ZoneNameLng"); 
            if (curRow.getAttribute("SectorCode") == null)
                curRow.setAttribute("SectorCode", SectorCode);
            /* Inserting & Updating Records in Zone Master Language table*/
                ViewObject zoneMstLngVo = getZoneMstLngVO();
                System.out.println("zoneMstLngVo Size:"+zoneMstLngVo.getRangeSize());
                RowSetIterator zoneMstIterator =getZoneMstLngVO().createRowSetIterator(null);
           
            boolean breakFlag=false;
            int i=0;
                while (zoneMstIterator.hasNext()) {
                        
                     Row zoneMstRow = zoneMstIterator.next();
                        if(zoneMstRow!=null){ 
                            String zoneCodeMst = (String)zoneMstRow.getAttribute("ZoneCode");
                            System.out.println("zoneCodeMst"+zoneCodeMst);
                            if(zoneCodeMst == null || zoneCodeMst ==""){
                                zoneMstRow.setAttribute("ZoneCode",ZoneCode);
                                zoneCodeMst=(String)zoneMstRow.getAttribute("ZoneCode");
                                i++;
                                breakFlag=true;
                                
                            }  else {
                               if(ZoneCode.equalsIgnoreCase(zoneCodeMst)){
                                zoneMstRow.setAttribute("Updatedby",httpSession.getAttribute("loggedinUserid").toString());
                                zoneMstRow.setAttribute("Updatedate",SysDate);        
                               }
                            }  
                            String selectMstLang=(String)zoneMstRow.getAttribute("LNGCODE");
                            System.out.println("selectLang"+selectMstLang);
                            if(ZoneCode.equalsIgnoreCase(zoneCodeMst)){
                                if(selectMstLang.equalsIgnoreCase(selectedLanguage)){
                                    zoneMstRow.setAttribute("ZoneName",ZoneName);
                                }else{
                                    zoneMstRow.setAttribute("ZoneName",ZoneNameLng);
                                }    
                            }                                                                                                                                                               
                         }
                        if(breakFlag && i==2 ){
                           break; 
                        }                   
                    }                                                                                         
        }
    

        //Linked Sectors Details --Setting Sector Code
        ViewObject linkedVo = getLinkedSectorsVO();
        Row[] allLinkRows = linkedVo.getAllRowsInRange();
        for (Row curRow : allLinkRows) {
            if (curRow.getAttribute("SectorCode") == null)
                curRow.setAttribute("SectorCode", SectorCode);
        }
    }
        if (!isError) {

        /*    //upload files
            if (getUploadedFiles() != null) {
                ArrayList filePathList = uploadSectorDocs(SectorCode);
                //        uploadSectorDocs
                OperationBinding operationBinding =
                    getBindings().getOperationBinding("uploadSectorDocs");
                operationBinding.getParamsMap().put("Sectorcode", SectorCode);
                operationBinding.getParamsMap().put("uploadFiles",
                                                    filePathList);
                operationBinding.execute();
            }*/

            // caling procedure if Date is modified at Edit
            System.out.println(SectorGoLiveDate);
            System.out.println(GoLiveDtforcheck);
            if (editClicked && clickedNewButton) {
                if(SectorGoLiveDate != null && GoLiveDtforcheck != null)
                {
                if(!(SectorGoLiveDate.compareTo(GoLiveDtforcheck)==0))
                {    
                OperationBinding operationBinding =
                    getBindings().getOperationBinding("goLiveDateProcdure");
                operationBinding.getParamsMap().put("sectorCode", SectorCode);
                operationBinding.execute();
                }
                }
            }

            getBindings().getOperationBinding("doCommit").execute();
           
            Boolean status =
                Boolean.parseBoolean(getBindings().getOperationBinding("doCommit").getResult().toString());
            if (status) {
            
                ViewObject sectorMstLngVo = getSectorMstLngVO();
                
                if(actionMode!=null && actionMode.equalsIgnoreCase("edit")){                    
                    RowSetIterator sectorIterator =getSectorMstLngVO().createRowSetIterator(null);
                    while (sectorIterator.hasNext()) {
                    Row sectorRow = sectorIterator.next();
                       if(sectorRow!=null){
                                   String selectLang=sectorRow.getAttribute("LNGCODE").toString(); 
                                    if("EN".equalsIgnoreCase(selectLang)){
                                        sectorRow.setAttribute("SectorName",SectorName);
                                    }else{
                                        sectorRow.setAttribute("SectorName",sectorNameLng);
                                    }                                                 
                                    sectorRow.setAttribute("Updatedby",httpSession.getAttribute("loggedinUserid").toString());
                                    sectorRow.setAttribute("Updatedate",SysDate);
                                   
                                }
                       
                    }  
//                    ViewObject sectorMstVo = getSectorMstVO();
//                    SectorMstVORowImpl currrow = (SectorMstVORowImpl)sectorMstVo.getCurrentRow();
//                    int rowstatus = currrow.getRowChanged();
//                    sectorMstVo.is
//                    System.out.println(rowstatus);
//                 System.out.println(binding.getViewObject().getCurrentRow().getAttribute("RowChanged"));    
//                if( Integer.parseInt(binding.getViewObject().getCurrentRow().getAttribute("RowChanged").toString()) == 2)
//                    {
                    binding.getViewObject().getCurrentRow().setAttribute("UpdatedBy",httpSession.getAttribute("loggedinUserid").toString());
                    binding.getViewObject().getCurrentRow().setAttribute("UpdatedDate",sqlDate);
                   // }
                }else if(actionMode!=null && actionMode.equalsIgnoreCase("new")){
                    for(int i=0;i<2;i++){
                        Row newRow = sectorMstLngVo.createRow();
                        newRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
                        newRow.setAttribute("CreatedDate",sqlDate);
                        newRow.setAttribute("SectorCode",SectorCode);
                        if(i==0){
                            newRow.setAttribute("LNGCODE",httpSession.getAttribute("language").toString());
                            newRow.setAttribute("SectorName",SectorName);
                        }else{
                            newRow.setAttribute("LNGCODE",language);
                            newRow.setAttribute("SectorName",sectorNameLng);
                        }                  
                        sectorMstLngVo.insertRow(newRow); 
                    }   
                }                                  
                sectorMstLngVo.executeQuery(); 
                getBindings().getOperationBinding("doCommit").execute();

//                DisplayMessage("SectorCode is : '" + SectorCode + "'");
                DisplayMessage("258","'" + SectorCode + "'");

                /*Hide Sector Details Layout, Submit & Cancel Buttons*/
                secDetailsLayout.setVisible(Boolean.FALSE);


                /* Hide buttons Submit, Cancel*/
                setShowSubmitCancelBtn(Boolean.FALSE);

                /*Show  New, Edit & View Buttons*/
                newEditViewBtnLayout.setVisible(Boolean.TRUE);
                setEditClicked(Boolean.FALSE);

            } else {
                DisplayMessage("234","");
            }
        }
    }

    public ArrayList uploadSectorDocs(String sectorCode) {
        FileUpload fl = new FileUpload();
        String uploadPath = "";
        List<UploadedFile> uploadDocs = getUploadedFiles();
        uploadPath =
                fl.uploadFilesToFolder("1", "SECTOR", sectorCode, uploadDocs);
        //List<UploadedFile> uploadDocs = this.getUploadedDocs();
        ArrayList filePathList = new ArrayList();

        for (int i = 0; i < uploadDocs.size(); i++) {
            System.out.println("Document Name  ::::     " +
                               uploadDocs.get(i).getFilename());
            if (uploadPath != null) {
                //String concat = uploadPath.concat(uploadDocs.get(i).getFilename());
                String fullPath =
                    uploadPath + "//" + uploadDocs.get(i).getFilename();
                filePathList.add(fullPath);
            } else {
                filePathList.add(uploadDocs.get(i).getFilename());
            }

        }

        return filePathList;
    }

    public void cancelSectorChanges(ActionEvent actionEvent) {
        // Rollback changes to DB
        OperationBinding binding =
            getBindings().getOperationBinding("doRollback");
        binding.execute();

        getSectorMstVO().clearCache();
        getSectorMstVO().executeQuery();

        Boolean status = (Boolean)binding.getResult();
        if (status) {

            /*Hide Sector Details Layout, Submit & Cancel Buttons*/
            secDetailsLayout.setVisible(Boolean.FALSE);

            /* Hide buttons Submit, Cancel*/
            setShowSubmitCancelBtn(Boolean.FALSE);

            /* Show New, Edit & View Buttons*/
            newEditViewBtnLayout.setVisible(Boolean.TRUE);
            setEditClicked(Boolean.FALSE);
        } else {
            DisplayMessage("235","");
        }
    }

    private void DisplayMessage(String str, String Code){
            FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"",genMsg.getMessage(str, lngCode)+Code) );            
        }

    public Boolean getDisableViewEditBtn() {
        DCBindingContainer bc = getBindings(); //
        OperationBinding binding = bc.getOperationBinding("getSectorRowCount");

        binding.execute();
        return Boolean.parseBoolean(binding.getResult().toString());
    }

    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setSecDetailsLayout(RichShowDetailHeader secDetailsLayout) {
        this.secDetailsLayout = secDetailsLayout;
    }

    public RichShowDetailHeader getSecDetailsLayout() {
        return secDetailsLayout;
    }


    public void setShowSubmitCancelBtn(Boolean HideSubmitCancelBtn) {
        if (HideSubmitCancelBtn)
            hSpace = 275;
        else
            hSpace = 425;
        this.showSubmitCancelBtn = HideSubmitCancelBtn;
    }

    public Boolean getShowSubmitCancelBtn() {
        return showSubmitCancelBtn;
    }

    public void setNewEditViewBtnLayout(RichPanelGroupLayout newEditViewBtnLayout) {
        this.newEditViewBtnLayout = newEditViewBtnLayout;
    }

    public RichPanelGroupLayout getNewEditViewBtnLayout() {
        return newEditViewBtnLayout;
    }


    public void setViewBtnClicked(Boolean viewBtnClicked) {
        this.viewBtnClicked = viewBtnClicked;
    }

    public Boolean getViewBtnClicked() {
        return viewBtnClicked;
    }

    public void setHSpace(Integer hSpace) {
        this.hSpace = hSpace;
    }

    public Integer getHSpace() {
        return hSpace;
    }

    public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public List<UploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }

    /**
     *called when you change the Date
     * @param attributeChangeEvent
     */
    public void goLiveDateAction(ValueChangeEvent valueChangeEvent) {
        Date oldDate = (Date)valueChangeEvent.getOldValue();
        Date newDate = (Date)valueChangeEvent.getNewValue();
        if (oldDate != null && !oldDate.equals(newDate)) {
            editClicked = Boolean.TRUE;
        }

    }

    public ViewObject getZoneVO() {
        DCIteratorBinding bindingZone =
            getBindings().findIteratorBinding("ZoneMstVO1Iterator");
        ViewObject voZone = bindingZone.getViewObject();
        return voZone;
    }
    
    public ViewObject getZoneLngVO() {
        DCIteratorBinding bindingZone =
            getBindings().findIteratorBinding("ZoneMstVO2Iterator");
        ViewObject voZone = bindingZone.getViewObject();
        return voZone;
    }

    public ViewObject getLinkedSectorsVO() {
        DCIteratorBinding bindingLink =
            getBindings().findIteratorBinding("LinkedSectorsVO1Iterator");
        ViewObject voLink = bindingLink.getViewObject();
        return voLink;
    }

    public ViewObject getSectorMstVO() {
        DCIteratorBinding bindingLink =
            getBindings().findIteratorBinding("SectorMstVO1Iterator");
        ViewObject voLink = bindingLink.getViewObject();
        return voLink;
    }
    
    public ViewObject getSectorMstLngVO() {
        DCIteratorBinding bindingLink =
            getBindings().findIteratorBinding("SectorMstLngVO1Iterator");
        ViewObject voLink = bindingLink.getViewObject();
        return voLink;
    }
    
    public ViewObject getZoneMstLngVO() {
            DCIteratorBinding bindingLink =
                getBindings().findIteratorBinding("ZoneMstLngVO1Iterator");
            ViewObject voLink = bindingLink.getViewObject();
            return voLink;
        }

    public void addNewZoneRecord(ActionEvent actionEvent) {
        ViewObject zoneVO = getZoneVO();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        Row zoneNewRow = zoneVO.createRow();
        zoneNewRow.setAttribute("CreatedBy",
                                httpSession.getAttribute("loggedinUserid").toString());
        zoneNewRow.setAttribute("UpdatedBy",
                                httpSession.getAttribute("loggedinUserid").toString());

        zoneVO.insertRowAtRangeIndex(0,zoneNewRow);
//        getBindings().findIteratorBinding("ZoneMstVO1Iterator").executeQuery();
        
        //Creating 2 records in Zone Master Lang Table
        ViewObject zoneLngVO = getZoneMstLngVO();
        String zoneLanguage =(String)getZoneLngVO().getCurrentRow().getAttribute("LanguageZone");
        for(int i=0;i<2;i++){
         Row zoneNewMStRow = zoneLngVO.createRow();
         zoneNewMStRow.setAttribute("CreatedBy",
                                httpSession.getAttribute("loggedinUserid").toString());
         zoneNewMStRow.setAttribute("CreatedDate",sqlDate); 
         if(i==0){
                zoneNewMStRow.setAttribute("LNGCODE",
                                       httpSession.getAttribute("language").toString()); 
            }else{
                zoneNewMStRow.setAttribute("LNGCODE",zoneLanguage);  
         }
         zoneLngVO.insertRow(zoneNewMStRow);
        }
   
    }

    public void getFilterZoneLinkBySector() {
        DCIteratorBinding binding =
            getBindings().findIteratorBinding("SectorMstVO1Iterator");
        String SectorCode =
            binding.getViewObject().getCurrentRow().getAttribute("SectorCode").toString();
        System.out.println("SectorCode - editCurrentSector:'" + SectorCode +
                           "'");

        ViewObject voZone = getZoneVO();
        voZone.clearCache();
        voZone.setWhereClause(null);
        voZone.setWhereClause("Sector_Code = '" + SectorCode + "'");
        voZone.executeQuery();
        Row[] zoneRows = voZone.getFilteredRows("SectorCode", SectorCode);
        System.out.println("zoneRows count:" + zoneRows.length);

        ViewObject voLink = getLinkedSectorsVO();
        voLink.clearCache();
        voLink.setWhereClause(null);
        voLink.setWhereClause("Sector_Code = '" + SectorCode + "'");
        voLink.executeQuery();
    }


    public void addNewLinkSectorRecord(ActionEvent actionEvent) {
        ViewObject linkVO = getLinkedSectorsVO();
        Row linkNewRow = linkVO.createRow();
        linkNewRow.setAttribute("CreatedBy",
                                httpSession.getAttribute("loggedinUserid").toString());
        linkNewRow.setAttribute("Updatedby",
                                httpSession.getAttribute("loggedinUserid").toString());
        linkVO.insertRow(linkNewRow);
    }


    public void setDocTable(RichTable docTable) {
        this.docTable = docTable;
    }

    public RichTable getDocTable() {
        return docTable;
    }

    public void setCurrentAttchmtRow(Row currentAttchmtRow) {
        this.currentAttchmtRow = currentAttchmtRow;
    }

    public Row getCurrentAttchmtRow() {
        return currentAttchmtRow;
    }
    public void downloadFileListener(FacesContext facesContext, OutputStream outputStream) throws IOException {
               String filePath =(String)getFilePropertyCommandLink().getAttributes().get("filePath");
               System.out.println("filePath  :::::::::::::::::             "+filePath);
               File filed = new File(filePath);
               FileInputStream fis;
               byte[] b;
               try {
                   fis = new FileInputStream(filed);

                   int n;
                   while ((n = fis.available()) > 0) {
                       b = new byte[n];
                       int result = fis.read(b);
                       outputStream.write(b, 0, b.length);
                       if (result == -1)
                           break;
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
               outputStream.flush();
           }
    
    
    public String deleteZoneLang() {
        Row selectedRow =(Row)ADFUtil.evaluateEL("#{bindings.ZoneMstVO1Iterator.currentRow}");
        String zoneCode =(String)selectedRow.getAttribute("ZoneCode");
        System.out.println("zoneCode:"+zoneCode);
        selectedRow.remove();
        if(actionMode!=null && actionMode.equalsIgnoreCase("new")){
            int i=0;
            RowSetIterator zoneLngIterator =getZoneMstLngVO().createRowSetIterator(null);
            while (zoneLngIterator.hasNext()) {
            Row zoneRow = zoneLngIterator.next();
              if(zoneRow!=null){
                      String zoneCodeMst = (String)zoneRow.getAttribute("ZoneCode");
                      System.out.println("zoneCodeMst:"+zoneCodeMst);
                      if(i==2){
                        break;  
                      }
                      if(zoneCodeMst==null){
                          zoneRow.remove(); 
                          i++;
                      }
                  }
            }
        }else if(actionMode!=null && actionMode.equalsIgnoreCase("edit")){
            boolean zoneAvailFlag=false;
            RowSetIterator zoneLngIterator =getZoneMstLngVO().createRowSetIterator(null);
            while (zoneLngIterator.hasNext()) {
            Row zoneRow = zoneLngIterator.next();
              if(zoneRow!=null){
                      String zoneCodeMst = (String)zoneRow.getAttribute("ZoneCode");
                      System.out.println("zoneCodeMst:"+zoneCodeMst);
                     
                      if(zoneCodeMst == null || zoneCodeMst.equals(zoneCode)){
                          zoneRow.remove();    
                          zoneAvailFlag=true;
                      }
                  }
            }
            if(!zoneAvailFlag){
                
                int i=0;
                RowSetIterator zoneEditLngIterator =getZoneMstLngVO().createRowSetIterator(null);
                while (zoneEditLngIterator.hasNext()) {
                Row zoneRow = zoneEditLngIterator.next();
                  if(zoneRow!=null){
                          String zoneCodeMst = (String)zoneRow.getAttribute("ZoneCode");
                          System.out.println("zoneCodeMst:"+zoneCodeMst);
                          if(i==2){
                            break;  
                          }
                          if(zoneCodeMst==null){
                              zoneRow.remove(); 
                              i++;
                          }
                      }
                }
            }
        }
        

        return null;
    }

        
        public void setFilePropertyCommandLink(RichCommandLink filePropertyCommandLink) {
            this.filePropertyCommandLink = filePropertyCommandLink;
        }

        public RichCommandLink getFilePropertyCommandLink() {
            return filePropertyCommandLink;
        }

    public void setEditClicked(Boolean editClicked) {
        this.editClicked = editClicked;
    }

    public Boolean getEditClicked() {
        return editClicked;
    }
}
