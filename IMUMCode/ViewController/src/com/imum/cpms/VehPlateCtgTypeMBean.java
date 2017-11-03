package com.imum.cpms;

import com.imum.cpms.util.MessageUtil;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;

//import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

//import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewObject;
import oracle.jbo.server.RowImpl;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.commons.lang.ArrayUtils;

public class VehPlateCtgTypeMBean {
    private Boolean SubmitCancelBtnLayout = false;
    private Boolean VehDetailsLayout = false;
    private Boolean ViewModeEnabled = false;
    private RichShowDetailHeader vehicleDetailsSDH;
    private String currentPlateCtgId="";
    private Boolean newPlateCtgModeEnabled = false;
    private Integer TypeOrder ;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
        
        ExternalContext externalContext = facesContext.getExternalContext();
        
            HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private RichSelectOneChoice countryid;


    public VehPlateCtgTypeMBean() {}

    public void addNewVehPlateTypeRecord(ActionEvent actionEvent) {
        String Iterator = newPlateCtgModeEnabled==true ? "VehiclePlateTypeVO2Iterator" : "VehiclePlateTypeVO1Iterator";
        ViewObject modelvo = getBindings().findIteratorBinding(Iterator).getViewObject();
        Row newModelRow = modelvo.createRow();
        newModelRow.setAttribute("PlateCategoryID", currentPlateCtgId);
        newModelRow.setAttribute("CreatedBy", httpSession.getAttribute("loggedinUserid").toString());
               newModelRow.setAttribute("UpdatedBy", httpSession.getAttribute("loggedinUserid").toString());

        TypeOrder++;
        newModelRow.setAttribute("TypeOrder", TypeOrder);
                modelvo.insertRow(newModelRow);
    }
    
    public void createNewVehMasDetails(ActionEvent actionEvent) {
        //bindings.CreateInsert.execute
        
        OperationBinding binding = getBindings().getOperationBinding("createNewVehCategoryMstDetails");
        binding.getParamsMap().put("username", httpSession.getAttribute("loggedinUserid").toString());
//        String countryid = getCountryid().getValue().toString();
//        binding.getParamsMap().put("countryid", countryid);
        binding.execute();
        
        
        
  Integer CtgId = (Integer)binding.getResult();
  if(CtgId != null)
     currentPlateCtgId = CtgId.toString();
        

        //        getBindings().getOperationBinding("CreateInsert1").execute();
        setSubmitCancelBtnLayout(Boolean.TRUE); 
        if(ViewModeEnabled) setViewModeEnabled(Boolean.FALSE);
        if(!newPlateCtgModeEnabled) setNewPlateCtgModeEnabled(Boolean.TRUE);
        TypeOrder=1;
        
    }
        

    public void getLangDetailForSelectedCtg() {
        String selectedLang =
            FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
        String OtherLang = "";
        if (selectedLang.equalsIgnoreCase("EN")) {
            OtherLang = "AR";
        } else {
            OtherLang = "EN";
        }

        OperationBinding binding =
            getBindings().getOperationBinding("getLangRecForCtg");
        binding.getParamsMap().put("Lang", OtherLang);
        binding.getParamsMap().put("currentCtgId", currentPlateCtgId);
        binding.execute();
        
    }
    
    public void viewVehicleMakeDetails(ActionEvent actionEvent) {
        if(getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getEstimatedRowCount()>0){
        setSubmitCancelBtnLayout(Boolean.TRUE); 
        /* Disable Edit functionality */
        if(!ViewModeEnabled) setViewModeEnabled(Boolean.TRUE);
        if(newPlateCtgModeEnabled) setNewPlateCtgModeEnabled(Boolean.FALSE);
        
        getLangDetailForSelectedCtg();
        }else{DisplayMessage("303", " No records to Edit or View");}//303
    }
    
    public void editVehicleMakeDetails(ActionEvent actionEvent) {
            if(getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getEstimatedRowCount()>0){
        setSubmitCancelBtnLayout(Boolean.TRUE);
        
        if(ViewModeEnabled) setViewModeEnabled(Boolean.FALSE);
        if(newPlateCtgModeEnabled) setNewPlateCtgModeEnabled(Boolean.FALSE);
        currentPlateCtgId = getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getCurrentRow().getAttribute("PlateCtgID").toString();
            String username=httpSession.getAttribute("loggedinUserid").toString();
            getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getCurrentRow().setAttribute("UpdatedBy",username);
        TypeOrder  = Integer.parseInt(((Long) getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getEstimatedRowCount()).toString());
        
        getLangDetailForSelectedCtg();
        }else{DisplayMessage("303", " No records to Edit or View");}//303
    }
    
    public void deleteVehModelRecord(){
            String binding = newPlateCtgModeEnabled==true ? "Delete1" : "Delete";
            getBindings().getOperationBinding(binding).execute();
            TypeOrder--;
            
        }
    
    public Boolean createNewCtgLangRec(String Lang, String CtgName) {
        //            createNewMakeLangRec(String Lang, String MakeName, String currentMakeId,String username)
        OperationBinding binding =
            getBindings().getOperationBinding("createNewCtgLangRec");
        binding.getParamsMap().put("Lang", Lang);
        binding.getParamsMap().put("CtgName", CtgName);
        binding.getParamsMap().put("currentPlateCtgId", currentPlateCtgId);
        binding.getParamsMap().put("username",
                                   httpSession.getAttribute("loggedinUserid").toString());
        binding.execute();
        

        //        return Boolean.parseBoolean(binding.getResult().toString());
        return true;
    }
    
    public Boolean createNewTypeLangRec(String Lang, String TypeName,
                                         Integer TypeId) {
        //            createNewMakeLangRec(String Lang, String MakeName, String currentMakeId,String username)
        OperationBinding binding =
            getBindings().getOperationBinding("createNewTypeLangRec");
        binding.getParamsMap().put("Lang", Lang);
        binding.getParamsMap().put("TypeName", TypeName);
        binding.getParamsMap().put("currentTypeId", TypeId);
        binding.getParamsMap().put("username",
                                   httpSession.getAttribute("loggedinUserid").toString());
        binding.execute();

        //        return Boolean.parseBoolean(binding.getResult().toString());
        return true;
    }

    
    public void submitChangesToDB(ActionEvent actionEvent) {
        Boolean isError = false;
         
        String selectedLang =
            FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
        String OtherLang = "";
        if (selectedLang.equalsIgnoreCase("EN")) {
            OtherLang = "AR";
        } else {
            OtherLang = "EN";
        }
        
        Row newRow = getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getViewObject().getCurrentRow();
        
        String username=httpSession.getAttribute("loggedinUserid").toString();
        System.out.println(username);
        
        //newRow.setAttribute("CreatedBy", username);
        
        
       
        
        System.out.println( newRow.getAttribute("Countrycode"));
        System.out.println( newRow.getAttribute("CreatedBy"));
       
 
        if(newRow.getAttribute("PlateCtgDesc")==null){
            DisplayMessage("229","");
                isError= true;
            }if(newRow.getAttribute("PlateCountryID")==null){
        DisplayMessage("230","");
            isError= true;
        } if(newRow.getAttribute("VehCtgNameLng")==null){
        DisplayMessage("297","");
            isError= true;
         }if(newRow.getAttribute("PlateCtgDesc")!=null  && newRow.getAttribute("PlateCountryID")!=null && newRow.getAttribute("VehCtgNameLng")!=null){
         

        createNewCtgLangRec(selectedLang,
                             getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getCurrentRow().getAttribute("PlateCtgDesc").toString());
        createNewCtgLangRec(OtherLang,
                             getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getCurrentRow().getAttribute("VehCtgNameLng").toString());

         }
         

        Integer curMaxTypeId = 0;
        getBindings().findIteratorBinding("VehPlateTypeTypeIdRVO1Iterator").getViewObject().executeQuery();
        if (getBindings().findIteratorBinding("VehPlateTypeTypeIdRVO1Iterator").getEstimatedRowCount() >
            0) {
            if(getBindings().findIteratorBinding("VehPlateTypeTypeIdRVO1Iterator").getViewObject().first().getAttribute("PlateTypeID") != null)
            curMaxTypeId =
                    Integer.parseInt(getBindings().findIteratorBinding("VehPlateTypeTypeIdRVO1Iterator").getViewObject().first().getAttribute("PlateTypeID").toString());

        }
         
         
        String Iterator = newPlateCtgModeEnabled==true ? "VehiclePlateTypeVO2Iterator" : "VehiclePlateTypeVO1Iterator";
        long count = getBindings().findIteratorBinding(Iterator).getEstimatedRowCount();
        
        if(count >0){
//            getBindings().findIteratorBinding(Iterator).executeQuery();
                Calendar c1 = Calendar.getInstance();
               java.sql.Timestamp currdate = new java.sql.Timestamp(c1.getTime().getTime());
               //System.out.println("current date is:::"+currdate);
            Row[] allVehTypeRows = getBindings().findIteratorBinding(Iterator).getAllRowsInRange();
            Row[] VTRowsToCmp = allVehTypeRows; 
            ArrayUtils.reverse(allVehTypeRows);
//            int TypeRecCount = 0;
            int newTypeId = curMaxTypeId;
//            Row[] VTRowsToCmp = getBindings().findIteratorBinding("VehiclePlateTypeVO2Iterator1").getAllRowsInRange();
            for(Row curRow : allVehTypeRows){
//                    TypeRecCount++;
                    
                    
                if(curRow.getAttribute("PlateTypedesc")==null){
                    DisplayMessage("231","");
                    isError=true;
                    break;
                    
                    }
                /* start */
                int dupCount =0;
                String TypeName = null;
                if(curRow.getAttribute("PlateTypedesc") != null)
                 TypeName = curRow.getAttribute("PlateTypedesc").toString();
                for(Row cmpRow : VTRowsToCmp){
                    if(cmpRow.getAttribute("PlateTypedesc")==null) {
                        
                    }
                    
                    else
                    {
                    
                    if(TypeName.equalsIgnoreCase(cmpRow.getAttribute("PlateTypedesc").toString())) dupCount++;
                    }
                }
                if(dupCount>1){
                        DisplayMessage("279",TypeName);
                        isError=true;
                        break;
                    }
                
                    // insert lang record for model - selected language
                    if (curRow.getAttribute("PlateTypeID")== null) {
                        createNewTypeLangRec(selectedLang, TypeName,
                                              ++newTypeId);
                    } else {
                        curRow.setAttribute("UpdatedDate", currdate);
                        curRow.setAttribute("UpdatedBy", username);
                        createNewTypeLangRec(selectedLang, TypeName,
                                              Integer.parseInt(curRow.getAttribute("PlateTypeID").toString()));
                    }

                    if (curRow.getAttribute("VehTypeNameLng") == null) {
                        DisplayMessage("298","");
                        isError = true;
                        break;
                    }
                
                    /* start */
                    dupCount = 0;
                String TypeNameLng = null;
                if(curRow.getAttribute("VehTypeNameLng") != null)
                     TypeNameLng =
                        curRow.getAttribute("VehTypeNameLng").toString();
                    for (Row cmpRow : VTRowsToCmp) {
                        if(cmpRow.getAttribute("VehTypeNameLng")==null) {
                            
                        }
                        else {
                            if (TypeNameLng.equalsIgnoreCase(cmpRow.getAttribute("VehTypeNameLng").toString()))
                                dupCount++;
                        }
                        
                    }
                    if (dupCount > 1) {
                        DisplayMessage("279", TypeNameLng);
                        isError = true;
                        break;
                    }

                    // insert lang record for model - Other language
                    if (curRow.getAttribute("PlateTypeID")== null) {
                        createNewTypeLangRec(OtherLang, TypeNameLng,
                                              newTypeId);
                    } else {
                        curRow.setAttribute("UpdatedDate", currdate);
                        curRow.setAttribute("UpdatedBy", username);
                        createNewTypeLangRec(OtherLang, TypeNameLng,
                                              Integer.parseInt(curRow.getAttribute("PlateTypeID").toString()));
                    }
                    /* end */

                    
                /* end */
                }
        }else{
                DisplayMessage("232","");   
                isError= true;
            }
        
             
        
       
        
             
             
        
        if(!isError){

        ViewObjectImpl VehPlatCatLVO = (ViewObjectImpl)getBindings().findIteratorBinding("VehiclePlateCategoryLVO1Iterator").getViewObject();
        int platecountryid= 0;
        if(newRow.getAttribute("PlateCountryID") != null)
         platecountryid = Integer.parseInt(newRow.getAttribute("PlateCountryID").toString());
        Row vehplaterow = VehPlatCatLVO.getCurrentRow();
       ViewObjectImpl platecountrycodevo = (ViewObjectImpl)getBindings().findIteratorBinding("VehiclePlateCountryLVO2Iterator").getViewObject();
       platecountrycodevo.setWhereClause(null);
       platecountrycodevo.setWhereClause("Plate_Country_ID=" +
                                               platecountryid);
       platecountrycodevo.executeQuery();
       Row countrycoderow = platecountrycodevo.first();
       if(countrycoderow != null)
       {
       if(countrycoderow.getAttribute("CountryCode") != null && !"".equals(countrycoderow.getAttribute("CountryCode")))
       {
       String countrycode = countrycoderow.getAttribute("CountryCode").toString();
       newRow.setAttribute("Countrycode", countrycode);
       }
       }
       

        VehPlatCatLVO.applyViewCriteria(VehPlatCatLVO.getViewCriteria("getByPlateCountryId"));
        VariableValueManager evm = VehPlatCatLVO.ensureVariableManager();
        if(newRow.getAttribute("PlateCountryID") != null)
        evm.setVariableValue("BindPlateCountryId", Integer.parseInt(newRow.getAttribute("PlateCountryID").toString()));
        VehPlatCatLVO.executeQuery();
        Long ctgOrder = VehPlatCatLVO.getEstimatedRowCount();
        Integer nextCtgOrder = 1;
        if(ctgOrder != null)
        {
        if(ctgOrder>0)nextCtgOrder = Integer.parseInt(ctgOrder.toString())+1;
        newRow.setAttribute("CtgOrder",nextCtgOrder );
        }
        
      

        
        getBindings().getOperationBinding("doCommit").execute();
        Boolean status = Boolean.parseBoolean(getBindings().getOperationBinding("doCommit").getResult().toString());
        if(status){
        
        setSubmitCancelBtnLayout(Boolean.FALSE);
        getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").executeQuery();
            
         
        System.out.println("current Vehicle Plate Category Id is : "+currentPlateCtgId);
        
//        DisplayMessage(" Plate Category Id is : '"+currentPlateCtgId+"'");
        DisplayMessage("233","'"+currentPlateCtgId+"'");
            }else{
                    DisplayMessage("234","");
                }
//            

   }
        
    }

    public void cancelChangesToDB(ActionEvent actionEvent) {
        if(ViewModeEnabled){setSubmitCancelBtnLayout(Boolean.FALSE);}
        else{
        getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getViewObject().clearCache();
        getBindings().findIteratorBinding("VehiclePlateCategoryVO1Iterator").getViewObject().executeQuery();
        getBindings().findIteratorBinding("VehiclePlateTypeVO1Iterator").getViewObject().clearCache();
        getBindings().findIteratorBinding("VehiclePlateTypeVO1Iterator").getViewObject().executeQuery();
        getBindings().findIteratorBinding("VehiclePlateTypeVO2Iterator").getViewObject().clearCache();
        getBindings().findIteratorBinding("VehiclePlateTypeVO2Iterator").getViewObject().executeQuery();
        
        
        
        OperationBinding binding = getBindings().getOperationBinding("doRollback");
        binding.execute();
        
        Boolean status = (Boolean) binding.getResult();
        if(status){
        setSubmitCancelBtnLayout(Boolean.FALSE);
        }else{
                DisplayMessage("235","");
            }}
    }
    
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    private void DisplayMessage(String str, String Code){
            FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"",genMsg.getMessage(str, lngCode)+Code) );
            
            
        }


    public void setSubmitCancelBtnLayout(Boolean SubmitCancelBtnLayout) {
        this.SubmitCancelBtnLayout = SubmitCancelBtnLayout;
    }

    public Boolean getSubmitCancelBtnLayout() {
        return SubmitCancelBtnLayout;
    }

    public void setVehDetailsLayout(Boolean VehDetailsLayout) {
        this.VehDetailsLayout = VehDetailsLayout;
    }

    public Boolean getVehDetailsLayout() {
        return VehDetailsLayout;
    }

    public void setViewModeEnabled(Boolean ViewModeEnabled) {
        this.ViewModeEnabled = ViewModeEnabled;
    }

    public Boolean getViewModeEnabled() {
        return ViewModeEnabled;
    }

    public void setVehicleDetailsSDH(RichShowDetailHeader vehicleDetailsSDH) {
        this.vehicleDetailsSDH = vehicleDetailsSDH;
    }

    public RichShowDetailHeader getVehicleDetailsSDH() {
        return vehicleDetailsSDH;
    }

    public void setCurrentPlateCtgId(String currentPlateCtgId) {
        this.currentPlateCtgId = currentPlateCtgId;
    }

    public String getCurrentPlateCtgId() {
        return currentPlateCtgId;
    }

    public void setNewPlateCtgModeEnabled(Boolean newMakeModeEnabled) {
        this.newPlateCtgModeEnabled = newMakeModeEnabled;
    }

    public Boolean getNewPlateCtgModeEnabled() {
        return newPlateCtgModeEnabled;
    }

    public void setTypeOrder(Integer TypeOrder) {
        this.TypeOrder = TypeOrder;
    }

    public Integer getTypeOrder() {
        return TypeOrder;
    }


    public void setCountryid(RichSelectOneChoice countryid) {
        this.countryid = countryid;
    }

    public RichSelectOneChoice getCountryid() {
        return countryid;
    }
}
