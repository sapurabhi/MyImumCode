package com.imum.cpms.staffdeployment;

import com.imum.cpms.util.MessageUtil;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;


import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class TrainingCoursesMasterBean {
    private RichTable t2;
    private RichPanelGroupLayout pgl3;
    private RichShowDetailHeader sdh1;
    private RichCommandButton viewCourse;
    private RichCommandButton editCourse;
    private RichCommandButton newCourse;
    private RichToolbar t1;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout trainingCoursesMasterForm;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichSelectBooleanCheckbox it5;
    private RichToolbar t3;
    private RichCommandButton cancelBtn;
    private RichCommandButton submitBtn;

    public TrainingCoursesMasterBean() {
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        } 
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setSdh1(RichShowDetailHeader sdh1) {
        this.sdh1 = sdh1;
    }

    public RichShowDetailHeader getSdh1() {
        return sdh1;
    }

    public void setViewCourse(RichCommandButton cb1) {
        this.viewCourse = cb1;
    }

    public RichCommandButton getViewCourse() {
        return viewCourse;
    }

    public void setEditCourse(RichCommandButton edit) {
        this.editCourse = edit;
    }

    public RichCommandButton getEditCourse() {
        return editCourse;
    }

    public void setNewCourse(RichCommandButton cb2) {
        this.newCourse = cb2;
    }

    public RichCommandButton getNewCourse() {
        return newCourse;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setTrainingCoursesMasterForm(RichPanelGroupLayout pgl4) {
        this.trainingCoursesMasterForm = pgl4;
    }

    public RichPanelGroupLayout getTrainingCoursesMasterForm() {
        return trainingCoursesMasterForm;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }


    public void setIt5(RichSelectBooleanCheckbox it5) {
        this.it5 = it5;
    }

    public RichSelectBooleanCheckbox getIt5() {
        return it5;
    }

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setCancelBtn(RichCommandButton cb3) {
        this.cancelBtn = cb3;
    }

    public RichCommandButton getCancelBtn() {
        return cancelBtn;
    }
    
    public void setSubmitBtn(RichCommandButton cb3) {
        this.submitBtn = cb3;
    }

    public RichCommandButton getSubmitBtn() {
        return submitBtn;
    }
    
    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }
    
    public boolean isIsDisabled() {
        return isDisabled;
    }

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private boolean isDisabled ;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    public static final ADFLogger logger = ADFLogger.createADFLogger(TrainingCoursesMasterBean.class);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public String newAction() {
        logger.info("Inside New_Action of TrainingCoursesMaster");
        setIsDisabled(Boolean.FALSE);
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        //OperationBinding operationBinding = bindings.getOperationBinding("addNewTrainingCourseMst");
        //operationBinding.getParamsMap().put("encoder",userName);
        //operationBinding.execute();
        getTrainingCoursesMasterForm().setVisible(true);
        getSubmitBtn().setVisible(true);
        getCancelBtn().setVisible(true);
        
        return null;
    }
    
    public String cancelAction(){
        getTrainingCoursesMasterForm().setVisible(false);
        getSubmitBtn().setVisible(false);
        getCancelBtn().setVisible(false);
        return null;
    }
    public String submitAction() {
        
        return null;
    }

    
}
