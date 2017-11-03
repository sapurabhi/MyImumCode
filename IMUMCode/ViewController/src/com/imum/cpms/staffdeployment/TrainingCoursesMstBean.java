package com.imum.cpms.staffdeployment;

import com.imum.cpms.model.staffdeploy.vo.GenTrainingCoursesMasterVOImpl;
import com.imum.cpms.model.staffdeploy.vo.GenTrainingCoursesMasterVORowImpl;
import com.imum.cpms.model.transactions.vo.CardTypeMstUVORowImpl;
import com.imum.cpms.util.MessageUtil;

import java.util.HashMap;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class TrainingCoursesMstBean {
    private RichCommandButton cancelBtn;
    private RichCommandButton cancelBtnTop;
    private RichSpacer s134;
    private RichCommandButton submitBtn;
    private RichCommandButton submitBtnTop;
    private RichToolbar t3;
    private RichSpacer s12344;
    private RichInputText it3;
    private RichInputText it4;
    private RichSelectBooleanCheckbox it5;
    private RichInputText it2;
    private RichInputText it1;
    private RichPanelFormLayout pfl1;
    private RichPanelGroupLayout trainingCoursesMstForm;
    private RichSpacer spacer3;
    private RichTable t2;
    private RichPanelGroupLayout pgl3;
    private RichShowDetailHeader sdh1;
    private RichSpacer s4;
    private RichCommandButton viewCourse;
    private RichSpacer s3;
    private RichCommandButton editCourse;
    private RichSpacer s2;
    private RichCommandButton newCourse;
    private RichSpacer s1;
    private RichToolbar t1;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl1;
    private HtmlInputHidden ih1;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    private boolean isDisabled ;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
   public static final ADFLogger logger = ADFLogger.createADFLogger(TrainingCoursesMstBean.class);
    MessageUtil genMsg = new MessageUtil();
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    
    String lgCode = httpSession.getAttribute("language").toString();



    public TrainingCoursesMstBean() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        } 
    }


    
    public void setCancelBtn(RichCommandButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public RichCommandButton getCancelBtn() {
        return cancelBtn;
    }

    public void setS134(RichSpacer s134) {
        this.s134 = s134;
    }

    public RichSpacer getS134() {
        return s134;
    }

    public void setSubmitBtn(RichCommandButton submitBtn) {
        this.submitBtn = submitBtn;
    }

    public RichCommandButton getSubmitBtn() {
        return submitBtn;
    }


    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setS12344(RichSpacer s12344) {
        this.s12344 = s12344;
    }

    public RichSpacer getS12344() {
        return s12344;
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

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setTrainingCoursesMstForm(RichPanelGroupLayout pgl4) {
        this.trainingCoursesMstForm = pgl4;
    }

    public RichPanelGroupLayout getTrainingCoursesMstForm() {
        return trainingCoursesMstForm;
    }

    public void setSpacer3(RichSpacer spacer3) {
        this.spacer3 = spacer3;
    }

    public RichSpacer getSpacer3() {
        return spacer3;
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

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setViewCourse(RichCommandButton viewCourse) {
        this.viewCourse = viewCourse;
    }

    public RichCommandButton getViewCourse() {
        return viewCourse;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setEditCourse(RichCommandButton editCourse) {
        this.editCourse = editCourse;
    }

    public RichCommandButton getEditCourse() {
        return editCourse;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setNewCourse(RichCommandButton newCourse) {
        this.newCourse = newCourse;
    }

    public RichCommandButton getNewCourse() {
        return newCourse;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
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
        
    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }
    
    public boolean isIsDisabled() {
        return isDisabled;
    }

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public String newAction() {
        logger.info("Start New_Action Method of TrainingCoursesMaster");
        setIsDisabled(Boolean.FALSE);
        
        getIt1().setValue(null);
        getIt2().setValue(null);
        getIt3().setValue(null);
        getIt5().setValue(false);
        // getSoc1().setValue("");
        getTrainingCoursesMstForm().setVisible(true);
        getIt2().setDisabled(false);
        getIt3().setDisabled(false);
        getIt5().setDisabled(false);
        getSoc1().setDisabled(false);
        getSubmitBtn().setVisible(true);
        getCancelBtn().setVisible(true);
        getSubmitBtnTop().setVisible(true);
        getCancelBtnTop().setVisible(true);
        
        getNewCourse().setVisible(false);
        getEditCourse().setVisible(false);
        getViewCourse().setVisible(false);
        logger.info("End New_Action Method of TrainingCoursesMaster");
        return null;
    }
    
    public String cancelAction(){
        logger.info("Start cancelAction Method of TrainingCoursesMaster");
        getIt2().setValue("");
        getIt3().setValue("");
        getIt5().setValue("");
        getTrainingCoursesMstForm().setVisible(false);
        getIt2().setDisabled(false);
        getIt3().setDisabled(false);
        getIt5().setDisabled(false);
        getSoc1().setDisabled(false);
       
        
        getNewCourse().setVisible(true);
        getEditCourse().setVisible(true);
        getViewCourse().setVisible(true);
        
        getSubmitBtn().setVisible(false);
        getCancelBtn().setVisible(false);
        
        getSubmitBtnTop().setVisible(false);
        getCancelBtnTop().setVisible(false);
        logger.info("End cancelAction Method of TrainingCoursesMaster");
        return null;
    }
    public String submitAction() {
        logger.info("Start submitAction Method of TrainingCoursesMaster");
        //String result = validateSubmit();
        JUCtrlListBinding listBinding = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenTrainingCoursesMasterPiTypeVO1");
        String groupName = (String)listBinding.getSelectedValue();
        if(groupName == null){
            groupName = (String)getIh1().getValue();
        }
        
       // System.out.println("groupName :::"+groupName);
        if(getIt2().getValue() == null && getIt3().getValue() == null && getIt5().getValue() == null && getSi1().getValue() == null){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("461",lgCode)));
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Enter All the Values", null));    
            return null;
        }else if(getIt2().getValue() == null){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("461",lgCode)));
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Enter Course Duration", null));    
            return null;     
        }else if(Integer.parseInt(getIt2().getValue().toString().equals("")?"0":getIt2().getValue().toString()) <= 0){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("462",lgCode)));
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Course Duration Should be Great Than 0", null));    
            return null;     
        }else if(getIt3().getValue() == null || getIt3().getValue().toString().equalsIgnoreCase("")){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("463",lgCode)));
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Enter Course Name", null));    
            return null;     
        }else if(groupName == null){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("464",lgCode)));
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select Group Name", null));    
            return null;     
        }else{
            //System.out.println("activeFlag ::"+getIt5().getValue());
                if(getIt5().getValue().equals(false)){
                        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Course Name is Empty", null));    
                        //return null;
                        getIt5().setValue("N");
                }else{
                    getIt5().setValue("Y");
                }
                Object courseCode = "";//getIt1().getValue().toString();
                Object coursesDuration = getIt2().getValue().toString();
                Object courseName = getIt3().getValue().toString();
                //Object groupId = getIt4().getValue().toString();
                //String groupId[] = groupName.split("-",0);
                //System.out.println("groupId :::"+groupName);
                Object activeFlag = getIt5().getValue().toString();
                    if(getIt1().getValue() == null){
                    //System.out.println(" New Training Course is Executing.. ");
                        OperationBinding operationBinding = bindings.getOperationBinding("saveTrainingCourseMaster");
                        operationBinding.getParamsMap().put("courseCode", courseCode);
                        operationBinding.getParamsMap().put("coursesDuration", coursesDuration);
                        operationBinding.getParamsMap().put("courseName", courseName);
                        operationBinding.getParamsMap().put("groupId", groupName);
                        //System.out.println("activeFlag :::"+activeFlag);
                        operationBinding.getParamsMap().put("activeFlag", activeFlag);
                        String result = (String)operationBinding.execute();
                            if(result.equals("success") )
                            {
                                 // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"New Training Course Saved Successfully", null));
                                 FacesContext.getCurrentInstance().addMessage(null,
                                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                               "Sample info message",
                                                                                               genMsg.getMessage("465",lgCode)));
                                  getTrainingCoursesMstForm().setVisible(false);
                                  getSubmitBtn().setVisible(false);
                                  getCancelBtn().setVisible(false);
                                  
                                getSubmitBtnTop().setVisible(false);
                                getCancelBtnTop().setVisible(false);
                                
                                getNewCourse().setVisible(true);
                                getEditCourse().setVisible(true);
                                getViewCourse().setVisible(true);
                            }else if(result.equals("exist")){
                                
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("466",lgCode)));
                                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"New Training CourseName Already Exist", null));     
                            }else{
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("467",lgCode)));
                                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"New Training CourseName Failure", null));     
                                
                            }
                    }else{
                       // System.out.println(" Edit Training Course is Executing.. ");
                        courseCode = getIt1().getValue().toString();
                        OperationBinding operationBinding = bindings.getOperationBinding("editTrainingCourseMaster");
                        operationBinding.getParamsMap().put("courseCode", courseCode);
                        operationBinding.getParamsMap().put("coursesDuration", coursesDuration);
                        operationBinding.getParamsMap().put("courseName", courseName);
                        operationBinding.getParamsMap().put("groupId", groupName);
                       // System.out.println("activeFlag :::"+activeFlag);
                        operationBinding.getParamsMap().put("activeFlag", activeFlag);
                        String result = (String)operationBinding.execute();
                            if(result.equals("success") )
                            {
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("468",lgCode)));
                                  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Edit Training Course Updated Successfully", null));     
                                  getIt1().setValue("");
                                  getIt2().setValue("");
                                  getIt3().setValue("");
                                  getIt5().setValue(false);
                                  getTrainingCoursesMstForm().setVisible(false);
                                  getSubmitBtn().setVisible(false);
                                  getCancelBtn().setVisible(false);
                                  
                                getSubmitBtnTop().setVisible(false);
                                getCancelBtnTop().setVisible(false);
                                  
                                getNewCourse().setVisible(true);
                                getEditCourse().setVisible(true);
                                getViewCourse().setVisible(true);
                                  
                            }else if(result.equals("exist")){
                                
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("469",lgCode)));
                               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Edit Training CourseName Already Exist", null));     
                                getIt5().setValue(activeFlag.equals('Y')?true : false);
                            }else if(result.equals("same")){
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("470",lgCode)));
                                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Entered Values are Already Exist", null));     
                                getIt5().setValue(activeFlag.equals('Y')?true : false);
                            }else{
                                FacesContext.getCurrentInstance().addMessage(null,
                                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                              "Sample info message",
                                                                                              genMsg.getMessage("471",lgCode)));
                                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Edit Training CourseName Failure", null));     
                                getIt5().setValue(activeFlag.equals('Y')?true : false);
                            }
                    }
                }
                logger.info("End submitAction Method of TrainingCoursesMaster");
                return null;
            }
    
    public String editAction() {
        logger.info("Start editAction Method of TrainingCoursesMaster");
        setIsDisabled(Boolean.FALSE);
        //String userName = httpSession.getAttribute("loggedinUserid").toString();
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("GenTrainingCoursesMasterVO1Iterator");
         ViewObject genTrainingMasterVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = genTrainingMasterVO.getCurrentRow();
        if(rowSelected != null){
            Object CourseCode = rowSelected.getAttribute("CourseCode");
            //logger.info("Selected TrainingCourseCode in Edit_action is : "+CourseCode);
            
            if(CourseCode!=null && !"".equals(CourseCode))
            {
                String selectedGroupPiid = rowSelected.getAttribute("GroupName").toString();
                getIh1().setValue(selectedGroupPiid);
                OperationBinding operationBinding = bindings.getOperationBinding("getPiTypeGroupName");
                operationBinding.getParamsMap().put("selectedGroupPiid", selectedGroupPiid);
                String selectedGroupNamePiid = (String)operationBinding.execute();
               // JUCtrlListBinding listBinding = (JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("GenTrainingCoursesMasterPiTypeVO1");
                //Object[] groupName = (Object[])listBinding.getAttributes();
               //for(int i=0;i<groupName.length;i++){
                 //   System.out.println("group value :::"+groupName[i]);
                //}
                
                
                getIt1().setValue(rowSelected.getAttribute("CourseCode"));
                Object courseCode = getIt1().getValue().toString();
                getIt2().setValue(rowSelected.getAttribute("CourseDuration"));
                getIt3().setValue(rowSelected.getAttribute("Coursename"));
                getIt5().setValue(rowSelected.getAttribute("ActiveFlag").equals("Y") ? true : false);
                //TODO getSoc1().setValue(selectedGroupNamePiid);
                //getSoc1().setValue(rowSelected.getAttribute("GroupName").toString());
                getSoc1().setSubmittedValue(selectedGroupNamePiid);
                getTrainingCoursesMstForm().setVisible(true);
                getIt2().setDisabled(false);
                getIt3().setDisabled(false);
                getIt5().setDisabled(false);
                getSoc1().setDisabled(true);
                getSubmitBtn().setVisible(true);
                getCancelBtn().setVisible(true);
                
                getSubmitBtnTop().setVisible(true);
                getCancelBtnTop().setVisible(true);
                
                getNewCourse().setVisible(false);
                getEditCourse().setVisible(false);
                getViewCourse().setVisible(false);
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("472",lgCode)));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select record in Table", null));       
            }
        }else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("472",lgCode)));
          //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select record in Table", null));       
        }
        logger.info("End editAction Method of TrainingCoursesMaster");
        return null;
    }
    
    public String viewAction() {
        logger.info("Start viewAction Method of TrainingCoursesMaster");
        setIsDisabled(Boolean.FALSE);
        //String userName = httpSession.getAttribute("loggedinUserid").toString();
        DCIteratorBinding dcItteratorBindings = bindingsAM.findIteratorBinding("GenTrainingCoursesMasterVO1Iterator");
         ViewObject genTrainingMasterVO = (ViewObject)dcItteratorBindings.getViewObject();
        Row rowSelected = genTrainingMasterVO.getCurrentRow();
        if(rowSelected != null){
            Object CourseCode = rowSelected.getAttribute("CourseCode");
            //logger.info("Selected TrainingCourseCode in Edit_action is : "+CourseCode);
            
            if(CourseCode!=null && !"".equals(CourseCode))
            {
                String selectedGroupPiid = rowSelected.getAttribute("GroupName").toString();
                OperationBinding operationBinding = bindings.getOperationBinding("getPiTypeGroupName");
                operationBinding.getParamsMap().put("selectedGroupPiid", selectedGroupPiid);
                String selectedGroupNamePiid = (String)operationBinding.execute();
                
                getIt1().setValue(rowSelected.getAttribute("CourseCode"));
                Object courseCode = getIt1().getValue().toString();
                getIt2().setValue(rowSelected.getAttribute("CourseDuration"));
                Object coursesDuration = getIt2().getValue().toString();
                getIt3().setValue(rowSelected.getAttribute("Coursename"));
                Object courseName = getIt3().getValue().toString();
                getIt5().setValue(rowSelected.getAttribute("ActiveFlag").equals("Y") ? true : false);
                Object activeFlag = getIt5().getValue().toString();
                
                // getSoc1().setValue(selectedGroupNamePiid);
                //getSi1().setseleValue(selectedGroupNamePiid);
                getSoc1().setSubmittedValue(selectedGroupNamePiid);
                getTrainingCoursesMstForm().setVisible(true);
                getIt2().setDisabled(true);
                getIt3().setDisabled(true);
                getIt5().setDisabled(true);
                getSoc1().setDisabled(true);
                getSubmitBtn().setVisible(false);
                getCancelBtn().setVisible(true);
                
                getSubmitBtnTop().setVisible(false);
                getCancelBtnTop().setVisible(true);
                
                getNewCourse().setVisible(false);
                getEditCourse().setVisible(false);
                getViewCourse().setVisible(false);
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("472",lgCode)));
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select record in Table", null));       
            }
        }else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("472",lgCode)));
          //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select record in Table", null));       
        }
        logger.info("End viewAction Method of TrainingCoursesMaster");
        return null;
    }
    
    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public void setCancelBtnTop(RichCommandButton cancelBtnTop) {
        this.cancelBtnTop = cancelBtnTop;
    }

    public RichCommandButton getCancelBtnTop() {
        return cancelBtnTop;
    }

    public void setSubmitBtnTop(RichCommandButton submitBtnTop) {
        this.submitBtnTop = submitBtnTop;
    }

    public RichCommandButton getSubmitBtnTop() {
        return submitBtnTop;
    }

    public void setIh1(HtmlInputHidden ih1) {
        this.ih1 = ih1;
    }

    public HtmlInputHidden getIh1() {
        return ih1;
    }
}
