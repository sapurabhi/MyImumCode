package com.imum.cpms.staffdeployment;

import com.imum.cpms.util.ADFUtils;

import com.imum.cpms.util.MessageUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.component.UISelectItems;

import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectManyListbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichResetButton;

import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.binding.BindingContainer;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

public class SupervisorAmendment {

    private RichCommandButton cb1;
    private RichPanelFormLayout pfl2;
    private RichInputText it2;
    private RichInputText it1;
    private RichPanelHeader pb1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichSelectManyListbox sml1;
    private UISelectItems si2;
    private RichCommandButton cb2;
    private RichPanelFormLayout pfl3;
    private RichInputDate id1;
    private RichInputDate id2;
    private HtmlInputHidden ih1;
    private RichSelectOneChoice soc2;
    private UISelectItems si3;
    private Date currentSDate = new Date();
    private Date currentEDate = getAssignEndDateDefault();
    private RichPanelGroupLayout pgl1;
    private RichCommandButton cb3;
    private RichInputDate id3;
    private RichInputDate id4;
    MessageUtil genMsg = new MessageUtil();
    String oldValue = "";
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lgCode = httpSession.getAttribute("language").toString();
    public static final ADFLogger logger = ADFLogger.createADFLogger(SupervisorAmendment.class);
    private Date getAssignEndDateDefault(){
        Date strtDate = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(strtDate);
        cal.add(Calendar.YEAR, 10);
        return (Date)cal.getTime();
    }
    public SupervisorAmendment() {
        if(lgCode==null || lgCode.equals(""))
        {
            lgCode = "EN";
        }
        
    }
    

        public void setCurrentSDate(Date currentDate) {
            this.currentSDate = currentDate;
        }

        public Date getCurrentSDate() {
            return currentSDate;
        }
    private DCBindingContainer getBindings1() {
            return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        }
    
    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
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


    public void setPb1(RichPanelHeader pb1) {
        this.pb1 = pb1;
    }

    public RichPanelHeader getPb1() {
        return pb1;
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

    public void setSml1(RichSelectManyListbox sml1) {
        this.sml1 = sml1;
    }

    public RichSelectManyListbox getSml1() {
        return sml1;
    }

    public void setSi2(UISelectItems si2) {
        this.si2 = si2;
    }

    public UISelectItems getSi2() {
        return si2;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setIh1(HtmlInputHidden ih1) {
        this.ih1 = ih1;
    }

    public HtmlInputHidden getIh1() {
        return ih1;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }


    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setCurrentEDate(Date currentEDate) {
        this.currentEDate = currentEDate;
    }

    public Date getCurrentEDate() {
        return currentEDate;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public String cb1_action() {
        //FacesMessage fm = new FacesMessage("");
        logger.info("Start cb1_action Method of SupervisorAmendment ");
        try{
        String oldAllocid = this.getIh1().getValue().toString();
        if(!oldAllocid.equals("")){        
        //String mang="Manager";
        String sessionManager = httpSession.getAttribute("loggedinUserid").toString();
        String status="Assigned";
        JUCtrlListBinding listBinding2 =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
         Object[] str = (Object[])listBinding2.getSelectedValues();
        ArrayList ArrList = new ArrayList();
        boolean selectionSectors = false;
        String multipleSector = "";
        int countMultipleSector = 0;
        for (Object s : str) {
            ArrList.add(s);
            selectionSectors = true;
            if(countMultipleSector == 0){
                multipleSector = " "+s.toString();
            }else{
                multipleSector = multipleSector +", "+ s.toString();
            }
            //System.out.println(s);
            ++countMultipleSector;
            }
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
            if(id2.getValue() == null && selectionSectors == false){
//                FacesContext.getCurrentInstance().addMessage(null,
//                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                              "Sample info message",
//                                                                              genMsg.getMessage("",lgCode)));
                FacesMessage fm = new FacesMessage("Assign End Date and Sector should not be Empty");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext fctx = FacesContext.getCurrentInstance();
                fctx.addMessage(null, fm);
                return null;
            }else if(id2.getValue() == null){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("402",lgCode)));
//                fm = new FacesMessage("End Date should not be Empty");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm);
                return null;
            }else if(id2.getValue() == null ){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("402",lgCode)));
//            fm = new FacesMessage("Assign End Date should not be Empty");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
            return null;
        }
            if(id1.getValue() == null){
                getId1().setValue(new Date());
            }
        Date sdate=(Date)id1.getValue();
        Date endDate =(Date)id2.getValue();
        
        //System.out.println("-------------------------------------------------dosave -------------------------------------------");
        //--
        Date currentDate = new Date();
       // System.out.println("utils date currentDate ::"+currentDate);
        java.sql.Date sqlDate1 = new java.sql.Date(currentDate.getTime());
            //System.out.println("sql date sqlDate1 ::"+sqlDate1);
        java.sql.Date fD1 = new java.sql.Date(sdate.getTime());
       // System.out.println("START FROM DATE ::"+fD1);
        java.sql.Date tD1 = new java.sql.Date(endDate.getTime());
          //  System.out.println("END TO DATE ::"+tD1);
        long diff = fD1.getTime()-sqlDate1.getTime();
        long diffHours = diff / (60 * 60 * 1000);
        long dayes= diffHours/24;
       // System.out.println(dayes);
        
        long diff2 = tD1.getTime()-fD1.getTime();
        
        long diffHours2 = diff2/ (60 * 60 * 1000);
        long dayes2= diffHours2/24;
            // System.out.println(dayes);
            //System.out.println("condition"+sqlDate1.equals(fD1));
             //if(diff <= 0){
             if(!sqlDate1.toString().equals(fD1.toString()) && diff < 0){
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("394",lgCode)));
//                 fm = new FacesMessage("Assign Start Date should not be less than Current Date ");
//                 fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                 FacesContext fctx = FacesContext.getCurrentInstance();
//                 fctx.addMessage(null, fm);
                 return null;  
             }else if(diff2 < 0) {
                 FacesContext.getCurrentInstance().addMessage(null,
                                                              new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                               "Sample info message",
                                                                               genMsg.getMessage("403",lgCode)));
//                 fm = new FacesMessage("Assign END Date should not be less than Assign Start Date ");
//                 fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                 FacesContext fctx = FacesContext.getCurrentInstance();
//                 fctx.addMessage(null, fm);
                 return null;  
             }else{
        
        String supname = it1.getValue().toString();
        //System.out.println(supname);
        
       // System.out.println(sdate);
       // System.out.println(endDate);
         if(selectionSectors){
          //  System.out.println("current Start Date ::"+id3.getValue().toString());
          //  System.out.println("current End Date ::"+id4.getValue().toString());
            java.sql.Date sqlStartDate = new java.sql.Date(sdate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
            java.sql.Date sqlCurStartDate = new java.sql.Date(((Date)id3.getValue()).getTime());
           // System.out.println("sqlCurStartDate ::"+sqlCurStartDate);
            java.sql.Date sqlCurEndDate = new java.sql.Date(((Date)id4.getValue()).getTime());
           // System.out.println("sqlCurEndDate ::"+sqlCurEndDate);
            //System.out.println("sdate ::"+sqlStartDate);
          //  System.out.println("endDate ::"+sqlEndDate);
          //  System.out.println("Start Dtae ::"+sqlCurStartDate.equals(sqlStartDate));
          //  System.out.println("End Dtae ::"+sqlCurEndDate.equals(sqlEndDate));
            String sqlStartDateReplace = sqlCurStartDate.toString().replaceAll("-", "");
            String sqlEndDateReplace = sqlCurEndDate.toString().replaceAll("-", "");
            String currentStartDateReplace = sqlStartDate.toString().replaceAll("-", "");
            String currentEndDateReplace = sqlEndDate.toString().replaceAll("-", "");
           //  System.out.println("sqlStartDateReplace ::"+sqlStartDateReplace);
           //  System.out.println("sqlEndDateReplace ::"+sqlEndDateReplace);
          //   System.out.println("currentStartDateReplace ::"+currentStartDateReplace);
          //   System.out.println("currentEndDateReplace ::"+currentEndDateReplace);
           // if(sqlStartDateReplace.equals(currentStartDateReplace) && sqlEndDateReplace.equals(currentEndDateReplace)){
                
            //    System.out.println("sector Selected ::"+multipleSector);
            //     System.out.println("sector Already ::"+it2.getValue().toString());
                if(multipleSector.equals(it2.getValue().toString())){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("404",lgCode)));
//                    fm = new FacesMessage("Assign Start Date, End Date and Also Sector are Aready Available");
//                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                    FacesContext fctx = FacesContext.getCurrentInstance();
//                    fctx.addMessage(null, fm);
                    return null;
                }
            // }
            
        oracle.binding.OperationBinding op1=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("SaveSup");
        op1.getParamsMap().put("supname", supname);
        op1.getParamsMap().put("mang", sessionManager);
      //  System.out.println("Sadtae---"+sdate);
        op1.getParamsMap().put("sdate", sdate);
        op1.getParamsMap().put("endDate", endDate);
        op1.execute();

        oracle.binding.OperationBinding op2=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("SaveAllocDtls");
        op2.getParamsMap().put("selectedsector", ArrList);
        //op2.getParamsMap().put("shift",shift1);            
        String newAllocid = (String)op2.execute();

        oracle.binding.OperationBinding op3=BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("saveUnAssignPreValues");
        op3.getParamsMap().put("newAllocid", newAllocid);
        op3.getParamsMap().put("oldAllocid", oldAllocid);
        op3.getParamsMap().put("mang", sessionManager);
        op3.getParamsMap().put("supname", supname);
        op3.getParamsMap().put("sdate", sdate);
        op3.getParamsMap().put("endDate", endDate);

        String result = op3.execute().toString();
        if (!result.equals("success"))
           {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              "Sample info message",
                                                                              genMsg.getMessage("397",lgCode)));
//            fm = new FacesMessage("supervisor sector Amendment is not Successfull");
//                fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                FacesContext fctx = FacesContext.getCurrentInstance();
//                fctx.addMessage(null, fm);
                return null;           
            }
        else
            {
                 
             //fm = new FacesMessage("supervisor sector Amendment done Successfully");
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                           "Sample info message",
                                                                           genMsg.getMessage("398",lgCode)));
            // System.out.println("allocid ::"+getIh1().getValue());    
             getIh1().setValue(newAllocid);
             getIt2().setValue(multipleSector);
             getId3().setValue(id1.getValue());
             getId4().setValue(id2.getValue());
           // System.out.println("allocid ::"+getIh1().getValue());    
             }
                 }else{
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  "Sample info message",
                                                                                  genMsg.getMessage("396",lgCode)));
//                     fm = new FacesMessage("Atleast one Sector should be Selected");
//                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
//                    FacesContext fctx = FacesContext.getCurrentInstance();
//                    fctx.addMessage(null, fm);
                    return null;
                }
          }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          "Sample info message",
                                                                          genMsg.getMessage("454",lgCode)));
//            fm = new FacesMessage("Please Click on View Sector to view Current Sector");
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
            return null;
        }

            
        }catch(Exception e){
            e.printStackTrace();
//            FacesContext.getCurrentInstance().addMessage(null,
//                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                                                          "Sample info message",
//                                                                          genMsg.getMessage("",lgCode)));
//            fm.setSeverity(FacesMessage.SEVERITY_INFO);
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            fctx.addMessage(null, fm);
        }
        JUCtrlListBinding listBindingReset =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
        listBindingReset.clearSelectedIndices();
        getId1().setValue(new Date());
        getId2().setValue(getAssignEndDateDefault());
        logger.info("End cb1_action Method of SupervisorAmendment ");
        return null;
    }
    
    public void amendBack(ActionEvent actionEvent) {
        logger.info("Start amendBack Method of SupervisorAmendment ");
       // System.out.println("Amend Back Button is Executed");
        JUCtrlListBinding listBindingReset =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
        listBindingReset.clearSelectedIndices();
        getId1().setValue(new Date());
        getId2().setValue(getAssignEndDateDefault());
        logger.info("End amendBack Method of SupervisorAmendment ");
 
    }

    public String amendCancel() {
        logger.info("Start amendCancel Method of SupervisorAmendment ");
        JUCtrlListBinding listBindingReset =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("sectorlistVo1");
        listBindingReset.clearSelectedIndices();
        getId1().setValue(new Date());
        getId2().setValue(getAssignEndDateDefault());
        logger.info("End amendCancel Method of SupervisorAmendment ");
        return null;
    }
}
