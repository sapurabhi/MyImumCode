package com.imum.cpms;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.context.ExternalContext;
import org.apache.commons.lang.ArrayUtils;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import com.imum.cpms.util.MessageUtil;

import oracle.jbo.server.ViewObjectImpl;

public class vehicleMakeModelMBean {
    private Boolean SubmitCancelBtnLayout = false;
    private Boolean VehDetailsLayout = false;
    private Boolean ViewModeEnabled = false;
    private RichShowDetailHeader vehicleDetailsSDH;
    private String currentMakeId = "";
    private Boolean newMakeModeEnabled = false;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession)externalContext.getSession(false);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();


    public vehicleMakeModelMBean() {
    }

    public void addNewVehModelRecord(ActionEvent actionEvent) {
        String Iterator =
            newMakeModeEnabled == true ? "VehModelMstVO2Iterator" :
            "VehModelMstVO1Iterator";
        ViewObject modelvo =
            getBindings().findIteratorBinding(Iterator).getViewObject();
        Row newModelRow = modelvo.createRow();
        newModelRow.setAttribute("MakeID", currentMakeId);
        newModelRow.setAttribute("CreatedBy",
                                 httpSession.getAttribute("loggedinUserid").toString());
        newModelRow.setAttribute("UpdatedBy",
                                 httpSession.getAttribute("loggedinUserid").toString());

        modelvo.insertRow(newModelRow);
    }

    public void createNewVehMasDetails(ActionEvent actionEvent) {
        //bindings.CreateInsert.execute

        OperationBinding binding =
            getBindings().getOperationBinding("createNewVehMstDetails");
        binding.getParamsMap().put("username",
                                   httpSession.getAttribute("loggedinUserid").toString());
        binding.execute();
        Integer MakeId = (Integer)binding.getResult();
        currentMakeId = MakeId.toString();


        //        getBindings().getOperationBinding("CreateInsert1").execute();
        setSubmitCancelBtnLayout(Boolean.TRUE);
        if (ViewModeEnabled)
            setViewModeEnabled(Boolean.FALSE);
        if (!newMakeModeEnabled)
            setNewMakeModeEnabled(Boolean.TRUE);

    }


    public void viewVehicleMakeDetails(ActionEvent actionEvent) {
        if(getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getEstimatedRowCount()>0){
        setSubmitCancelBtnLayout(Boolean.TRUE);
        /* Disable Edit functionality */
        if (!ViewModeEnabled)
            setViewModeEnabled(Boolean.TRUE);
        if (newMakeModeEnabled)
            setNewMakeModeEnabled(Boolean.FALSE);

        getLangDetailForSelectedMake();
        }else{DisplayMessage("303", " No records to Edit or View");}//303
    }

    public void getLangDetailForSelectedMake() {
        String selectedLang =
            FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
        String OtherLang = "";
        if (selectedLang.equalsIgnoreCase("EN")) {
            OtherLang = "AR";
        } else {
            OtherLang = "EN";
        }

        OperationBinding binding =
            getBindings().getOperationBinding("getLangRecForMake");
        binding.getParamsMap().put("Lang", OtherLang);
        binding.getParamsMap().put("currentMakeId", currentMakeId);
        binding.execute();
        /* if(getBindings().findIteratorBinding("VehMakeMstLngVO2Iterator").getViewObject().getEstimatedRowCount()>0){
//            getBindings().findIteratorBinding("VehMakeMstLngVO2Iterator").refresh(DCIteratorBinding.RANGESIZE_DO_NOT_OVERRIDE);
            String makeNameLng = getBindings().findIteratorBinding("VehMakeMstLngVO2Iterator").getViewObject().first().getAttribute("MakeName")==null ? "" : getBindings().findIteratorBinding("VehMakeMstLngVO2Iterator").getViewObject().first().getAttribute("MakeName").toString();
            getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getCurrentRow().setAttribute("MakeName",makeNameLng);
            }*/
    }

    public void editVehicleMakeDetails(ActionEvent actionEvent) {
        //System.out.println("Entered method - editVehicleMakeDetails");
        if(getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getEstimatedRowCount()>0){
        setSubmitCancelBtnLayout(Boolean.TRUE);
        if (ViewModeEnabled)
            setViewModeEnabled(Boolean.FALSE);
        if (newMakeModeEnabled)
            setNewMakeModeEnabled(Boolean.FALSE);
        currentMakeId =
                getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getCurrentRow().getAttribute("MakeID").toString();

        getLangDetailForSelectedMake();}else{DisplayMessage("303", " No records to Edit or View");}//303
    }


    public Boolean createNewMakeLangRec(String Lang, String MakeName) {
        //            createNewMakeLangRec(String Lang, String MakeName, String currentMakeId,String username)
        OperationBinding binding =
            getBindings().getOperationBinding("createNewMakeLangRec");
        binding.getParamsMap().put("Lang", Lang);
        binding.getParamsMap().put("MakeName", MakeName);
        binding.getParamsMap().put("currentMakeId", currentMakeId);
        binding.getParamsMap().put("username",
                                   httpSession.getAttribute("loggedinUserid").toString());
        binding.execute();

        //        return Boolean.parseBoolean(binding.getResult().toString());
        return true;
    }

    public Boolean createNewModelLangRec(String Lang, String ModelName,
                                         Integer ModelId) {
        //            createNewMakeLangRec(String Lang, String MakeName, String currentMakeId,String username)
        OperationBinding binding =
            getBindings().getOperationBinding("createNewModelLangRec");
        binding.getParamsMap().put("Lang", Lang);
        binding.getParamsMap().put("ModelName", ModelName);
        binding.getParamsMap().put("currentModelId", ModelId);
        binding.getParamsMap().put("username",
                                   httpSession.getAttribute("loggedinUserid").toString());
        binding.execute();

        //        return Boolean.parseBoolean(binding.getResult().toString());
        return true;
    }


    public void submitChangesToDB(ActionEvent actionEvent) {

        Boolean isError = false;
        //        getBindings().findIteratorBinding("VehMakeMstVO1Iterator");
        Boolean notNullMakeName =
            getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getCurrentRow().getAttribute("MakeName") !=
            null ? true : false;
        String MakeCountryCode =
            getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getCurrentRow().getAttribute("Countrycode").toString();
        System.out.println("Country Code for Vehicle Make is : " +
                           MakeCountryCode);


        if (notNullMakeName) {
            /* Make arabic lang changes - start*/
            Boolean notNullMakeNameInOtherLang =
                getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getCurrentRow().getAttribute("VehMakeNameLng") !=
                null ? true : false;

            if (notNullMakeNameInOtherLang) {
                /*insert records into lng*/
                String selectedLang =
                    FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
                String OtherLang = "";
                if (selectedLang.equalsIgnoreCase("EN")) {
                    OtherLang = "AR";
                } else {
                    OtherLang = "EN";
                }

                createNewMakeLangRec(selectedLang,
                                     getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getCurrentRow().getAttribute("MakeName").toString());
                createNewMakeLangRec(OtherLang,
                                     getBindings().findIteratorBinding("VehMakeMstVO1Iterator").getCurrentRow().getAttribute("VehMakeNameLng").toString());

                /* Making Model is optional
                 * Integer curMaxModelId = 0;
                getBindings().findIteratorBinding("VehModelMstModelIdRVO1Iterator").getViewObject().executeQuery();
                if (getBindings().findIteratorBinding("VehModelMstModelIdRVO1Iterator").getEstimatedRowCount() >
                    0) {
                    curMaxModelId =
                            Integer.parseInt(getBindings().findIteratorBinding("VehModelMstModelIdRVO1Iterator").getViewObject().first().getAttribute("ModelId").toString());

                } */


                /* Make arabic lang changes - ends*/
                /* String Iterator =
                    newMakeModeEnabled == true ? "VehModelMstVO2Iterator" :
                    "VehModelMstVO1Iterator";

                DCIteratorBinding binding =
                    getBindings().findIteratorBinding(Iterator);
                long count = binding.getEstimatedRowCount(); */


               // if (count > 0) {

                    /* Row[] allRowsInRange = binding.getAllRowsInRange();
                    Row[] revRowsInRange;
                    ArrayUtils.reverse(allRowsInRange);
                    Row[] VTRowsToCmp = allRowsInRange;
                    //                Boolean isError = false;
//                    int modelRecCount = 0;
                    int newModelId = curMaxModelId; */
                    /* for (Row curModelRow : allRowsInRange) {
//                        modelRecCount++;
                        
                        if (curModelRow.getAttribute("ModelName") == null) {
                            DisplayMessage("263", "");
                            isError = true;
                            break;
                        } */
                        /* start */
                        /* int dupCount = 0;
                        String ModelName =
                            curModelRow.getAttribute("ModelName").toString();
                        for (Row cmpRow : VTRowsToCmp) {
                            if (ModelName.equalsIgnoreCase(cmpRow.getAttribute("ModelName").toString()))
                                dupCount++;
                        }
                        if (dupCount > 1) {
                            DisplayMessage("280", ModelName);
                            isError = true;
                            break;
                        } */

                        // insert lang record for model - selected language
                        /* if (curModelRow.getAttribute("ModelId")==null) {
                            createNewModelLangRec(selectedLang, ModelName,
                                                  ++newModelId);
                        } else {
                            createNewModelLangRec(selectedLang, ModelName,
                                                  Integer.parseInt(curModelRow.getAttribute("ModelId").toString()));
                        } */
                        /* end */
                        // for Lang - VehModelNameLng

                        /* if (curModelRow.getAttribute("VehModelNameLng") ==
                            null) {
                            DisplayMessage("295",
                                           "");
                            isError = true;
                            break;
                        } */
                        /* start */
                        /* dupCount = 0;
                        String ModelNameLng =
                            curModelRow.getAttribute("VehModelNameLng").toString();
                        for (Row cmpRow : VTRowsToCmp) {
                            if (ModelNameLng.equalsIgnoreCase(cmpRow.getAttribute("VehModelNameLng").toString()))
                                dupCount++;
                        }
                        if (dupCount > 1) {
                            DisplayMessage("280", ModelNameLng);
                            isError = true;
                            break;
                        } */

                        // insert lang record for model - Other language
                       /*  if (curModelRow.getAttribute("ModelId")==null) {
                            createNewModelLangRec(OtherLang, ModelNameLng,
                                                  newModelId);
                        } else {
                            createNewModelLangRec(OtherLang, ModelNameLng,
                                                  Integer.parseInt(curModelRow.getAttribute("ModelId").toString()));
                        } */
                        /* end */


                        /* if (curModelRow.getAttribute("CountryCode") == null) {
                            curModelRow.setAttribute("CountryCode",
                                                     MakeCountryCode);
                        }
                    } */

                   // if (!isError) {
                        getBindings().getOperationBinding("doCommit").execute();
                        Boolean status =
                            Boolean.parseBoolean(getBindings().getOperationBinding("doCommit").getResult().toString());
                        if (status) {
                            setSubmitCancelBtnLayout(Boolean.FALSE);
                            getBindings().findIteratorBinding("VehMakeMstVO1Iterator").executeQuery();
                            //System.out.println("Make Iterator executed successfully.");


                            //System.out.println("current Make Id is : " +
                            //                                           currentMakeId);

                            //                        DisplayMessage("Make Id is : '" + currentMakeId + "'");
                            DisplayMessage("259", "'" + currentMakeId + "'");
                        } else {
                            DisplayMessage("234", "");
                        }
                   // }
               /*  } else {
                    DisplayMessage("264", "");
                } */ //count else
            } else {
                DisplayMessage("296", " ");
            }
        } else {
            DisplayMessage("265", "");
        }

    }

    public void cancelChangesToDB(ActionEvent actionEvent) {
        if(ViewModeEnabled){setSubmitCancelBtnLayout(Boolean.FALSE);}
        else{
        OperationBinding binding =
            getBindings().getOperationBinding("doRollback");
        binding.execute();

        Boolean status = (Boolean)binding.getResult();
        if (status) {
            setSubmitCancelBtnLayout(Boolean.FALSE);
        } else {
            DisplayMessage("235", "");
        }}
    }

    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    private void DisplayMessage(String str, String Code) {
        FacesContext.getCurrentInstance().addMessage("",
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      "",
                                                                      genMsg.getMessage(str,
                                                                                        lngCode) +
                                                                      Code));
    }

    public void setSubmitCancelBtnLayout(Boolean SubmitCancelBtnLayout) {
        this.SubmitCancelBtnLayout = SubmitCancelBtnLayout;
    }

    public Boolean getSubmitCancelBtnLayout() {
        if (SubmitCancelBtnLayout == null) {
            System.out.println("Null found for SubmitCancelBtnLayout ");
            // defaulting  value

            return false;
        }
        //        System.out.println("Value of SubmitCancelBtnLayout : " +
        //                           SubmitCancelBtnLayout);

        return SubmitCancelBtnLayout;
    }

    public void setVehDetailsLayout(Boolean VehDetailsLayout) {
        this.VehDetailsLayout = VehDetailsLayout;
    }

    public Boolean getVehDetailsLayout() {
        return VehDetailsLayout;
    }

    public void setVehicleDetailsSDH(RichShowDetailHeader vehicleDetailsSDH) {
        this.vehicleDetailsSDH = vehicleDetailsSDH;
    }

    public RichShowDetailHeader getVehicleDetailsSDH() {
        return vehicleDetailsSDH;
    }

    public void setViewModeEnabled(Boolean ViewEnabled) {
        this.ViewModeEnabled = ViewEnabled;
    }

    public Boolean getViewModeEnabled() {
        return ViewModeEnabled;
    }

    public String submitAction() {


        return null;
    }

    public void setNewMakeModeEnabled(Boolean newMakeModeEnabled) {
        this.newMakeModeEnabled = newMakeModeEnabled;
    }

    public Boolean getNewMakeModeEnabled() {
        return newMakeModeEnabled;
    }
}
