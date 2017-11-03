package com.imum.cpms;

import com.imum.cpms.model.masters.am.MastersAMImpl;
import com.imum.cpms.model.masters.vo.RemovalTruckMstVORowImpl;

import com.imum.cpms.model.masters.vo.VehicleBlacklistMstVORowImpl;

import com.imum.cpms.model.masters.vo.VehicleBlacklistMstVORowImpl;
import com.imum.cpms.util.ADFUtils;
import com.imum.cpms.util.MessageUtil;

import com.imum.cpms.util.PropertiesBeanUtils;

import java.math.BigDecimal;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import java.sql.Timestamp;

import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class VehicleBlacklistMstBean {
    private boolean hide = true;
    private boolean enabled = true;
    public static final ADFLogger logger = ADFLogger.createADFLogger(VehicleBlacklistMstBean.class);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private RichTable blacklistTable;
    String editMode=null;
    Map pageflowScope =ADFContext.getCurrent().getPageFlowScope();

    public VehicleBlacklistMstBean() {
    }
    
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public String submitBlacklist(ActionEvent actionEvent) {
        String result = validateDataOnSubmit();
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcItteratorBindings =bindings.findIteratorBinding("VehicleBlacklistMstVO1Iterator");
        ViewObject blacklistVO = dcItteratorBindings.getViewObject();
        if (result.equals("pass")) {    
        //For Varbinary PlateNumber Below Code Programmmatically Insert and Update
        Row currentRow = null;
        if(editMode!=null){                 
            if("new".equalsIgnoreCase(editMode)){
                currentRow = blacklistVO.first();
            }else if("edit".equalsIgnoreCase(editMode)){
                currentRow = blacklistVO.getCurrentRow();
            }
        }
               
        ViewObjectImpl vo= (ViewObjectImpl)blacklistVO;
        Integer vehColourId=(Integer)currentRow.getAttribute("VEHCOLOURID");
        Integer vehModelId=(Integer)currentRow.getAttribute("VEHMODELID");     
        Integer vehMakeId=(Integer)currentRow.getAttribute("VEHMAKEID");               
        Integer plateTypeId=(Integer)currentRow.getAttribute("PLATETYPEID");               
        Integer plateCtgId=(Integer)currentRow.getAttribute("PLATECTGID");              
        Integer plateCouId=(Integer)currentRow.getAttribute("PlateCountryID");             
        String plateNo=currentRow.getAttribute("PLATENUMBER").toString();
        Date activeDateFrom=(Date)currentRow.getAttribute("ActiveDateFrom");
        Date activeDateTo=(Date)currentRow.getAttribute("ActiveDateTo");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());   
        String activeFlag=currentRow.getAttribute("Activeflag").toString();
        Timestamp sqlDateActFrom = new java.sql.Timestamp(activeDateFrom.getTime());
        Timestamp sqlDateActTo = new java.sql.Timestamp(activeDateTo.getTime());
        BigDecimal blacklistSeq=null;
        
        if(editMode!=null){
            if("new".equalsIgnoreCase(editMode)){
                blacklistSeq=(BigDecimal)currentRow.getAttribute("Blacklistseq");
                System.out.println("blacklistSeq in doNewBlacklist is : "+blacklistSeq);
            }else if("edit".equalsIgnoreCase(editMode)){
                VehicleBlacklistMstVORowImpl blacklistRow = (VehicleBlacklistMstVORowImpl)vo.getCurrentRow();                   
                blacklistSeq=blacklistRow.getBlacklistseq();
            }
        }
        String sqlInsert=null;
        String sqlUpdate=null;
        if(editMode!=null){
            if("new".equalsIgnoreCase(editMode)){
               sqlInsert="INSERT INTO Veh_Blacklist_mst(PLATE_NUMBER,Plate_Country_ID,PLATE_CTG_ID,PLATE_TYPE_ID,VEH_MAKE_ID,VEH_MODEL_ID,VEH_COLOUR_ID,Created_By,Created_Date,Active_flag,Active_Date_From,Active_Date_To )" +
                     "VALUES (convert(varbinary(20),'"+plateNo+"'),"+plateCouId+","+plateCtgId+","+plateTypeId+","+vehMakeId+","+vehModelId+","+vehColourId+",'"+userName+"','"+sqlDate+"','"+activeFlag+"','"+sqlDateActFrom+"','"+sqlDateActTo+"')";
               System.out.println(sqlInsert);
            }else if("edit".equalsIgnoreCase(editMode)){
               sqlUpdate="Update Veh_Blacklist_mst set PLATE_NUMBER=convert(varbinary(20),'"+plateNo+"'),Plate_Country_ID="+plateCouId+",PLATE_CTG_ID="+plateCtgId+",PLATE_TYPE_ID="+plateTypeId+",VEH_MAKE_ID="+vehMakeId+",VEH_MODEL_ID="+vehModelId+",VEH_COLOUR_ID="+vehColourId+",Updated_by='"+userName+"',updated_date='"+sqlDate+"',Active_flag='"+activeFlag+"',Active_Date_From='"+sqlDateActFrom+"',Active_Date_To='"+sqlDateActTo+"' where Blacklist_seq = '"+blacklistSeq+"'";
            }     
        }
            Connection con = null;
        try{
             con = getConnection(); 
             Statement st1 = con.createStatement();
            if(editMode!=null){
                if("new".equalsIgnoreCase(editMode)){
                   Boolean a=st1.execute(sqlInsert);
                   System.out.println(a);
                    
                }else if("edit".equalsIgnoreCase(editMode)){
                    st1.executeUpdate(sqlUpdate);
                 
                 
             }                           
            }
             
        }catch(Exception e){
             System.out.println("SQL Exception Occured"+e.getMessage());
             logger.info("Exception" +e); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Insert/Update Statement Failed", e.getMessage()));   
            return "true";
        }finally{
            try{
                if(con!=null){
                    con.close();  
                 }
            }catch(Exception e){
                System.out.println(e);
            }
        }
  ViewObjectImpl userFormVO = (ViewObjectImpl)bindings.findIteratorBinding("VehicleBlacklistMstVO2Iterator").getViewObject();     
            userFormVO.clearCache();
            getBindings().getOperationBinding("doRollback").execute();
            //getBindings().getOperationBinding("commit").execute();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", genMsg.getMessage("514", lngCode)));    
//        }
        }else{
            //getBindings().getOperationBinding("doRollback").execute();
            if(editMode!=null && "new".equalsIgnoreCase(editMode)){ 
                blacklistVO.executeQuery();
            }
             
             setHide(false);
             ADFContext.getCurrent().getPageFlowScope().put("setvisible", "true");
             AdfFacesContext.getCurrentInstance().addPartialTarget(blacklistTable); 
            return "true";
        }
        return "false";
    }
    
    public Connection getConnection(){
           Connection con =null;
           try{
               Class.forName(PropertiesBeanUtils.getValue("DRIVER_CLASS"));
               con = DriverManager.getConnection(PropertiesBeanUtils.getValue("DATABASE_HOST"));
               }
           catch(Exception e){
               
           }
           return con;
       }
    
    public String validateDataOnSubmit() {
        String result = "pass";
        DCBindingContainer bindings =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings.findIteratorBinding("VehicleBlacklistMstVO2Iterator");
        ViewObject blacklistVO = dcIteratorBinding.getViewObject();
        VehicleBlacklistMstVORowImpl blacklistVORow = (VehicleBlacklistMstVORowImpl)blacklistVO.getCurrentRow();
        if (blacklistVORow != null) {    
            Object plateNumber = blacklistVORow.getPLATENUMBER();
            logger.info("Plate Number checking the value in Submit Action..." + plateNumber);
            if(plateNumber == null || plateNumber.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("205", lngCode)));    
                result = "fail";    
            }
            Object plateCountry = blacklistVORow.getPlateCountryID();
            logger.info("Plate Country checking the value in Submit Action..." + plateCountry);
            if(plateCountry == null || plateCountry.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("91", lngCode)));    
                result = "fail";    
            }
            Object plateCategory = blacklistVORow.getPLATECTGID();
            logger.info("Plate Category..." + plateCategory);
            if(plateCategory == null || plateCategory.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("92", lngCode)));   
                result = "fail";    
            }
            Object plateType = blacklistVORow.getPLATETYPEID();
            logger.info("Plate Type..." + plateType);
            if(plateType == null || plateType.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("93", lngCode)));   
                result = "fail";    
            } 
            Object vehMake = blacklistVORow.getVEHMAKEID();
            logger.info("Vehicle Make..." + vehMake);
            if(vehMake == null || vehMake.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("210", lngCode)));   
                result = "fail";    
            }  
            Object vehModel = blacklistVORow.getVEHMODELID();
            logger.info("Vehicle Model..." + vehModel);
            if(vehModel == null || vehModel.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("211", lngCode)));    
                result = "fail";    
            } 
            Object vehColour = blacklistVORow.getVEHCOLOURID();
            logger.info("Vehicle Colour..." + vehColour);
            if(vehColour == null || vehColour.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("212", lngCode)));    
                result = "fail";    
            }  
            Date actTo1 = (Date)blacklistVORow.getActiveDateTo();
            Date actFrom1 = (Date)blacklistVORow.getActiveDateFrom();
            java.sql.Date actFrom = new java.sql.Date(actFrom1.getTime());
            java.sql.Date sqldate = new java.sql.Date(new Date().getTime());      
            java.sql.Date actTo = new java.sql.Date(actTo1.getTime());
            System.out.println(actFrom);
            System.out.println(sqldate);
            System.out.println(actTo);
            String sfdate=actTo.toString().replaceAll("-","");
            String ssqldate=sqldate.toString().replaceAll("-","");
            String actfrom=actFrom.toString().replaceAll("-","");
            
            logger.info("Vehicle ActDateFrom..." + actFrom);
            if(actFrom == null || actFrom.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Valid From Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            }
            else if(editMode.equals("edit")){
                   
            }
            else if(actfrom.equals(ssqldate)){
                    
            } 
            else if(actFrom.compareTo(sqldate) < 0 ){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid From Date Cannot Be Less Than Current Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            }  
            
            logger.info("Vehicle ActDateTo..." + actTo);
            if(actTo == null || actTo.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Enter Valid To Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            } 
            else if(sfdate.equals(ssqldate)){
                 
            }
            if(editMode.equals("edit")) {
                
                if(actTo.compareTo(actFrom) < 0 && actFrom != null && !actFrom.equals("") && actTo != null && !actTo.equals("")){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid To Date Should Be After Valid From Date", genMsg.getMessage("212000", lngCode)));    
                    result = "fail";    
                }
                
            }
            
            else if(actTo.compareTo(sqldate ) < 0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid To Date Cannot Be Less Than Current Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            } 
            
            if(actTo.compareTo(actFrom) < 0 && actFrom != null && !actFrom.equals("") && actTo != null && !actTo.equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valid To Date Should Be After Valid From Date", genMsg.getMessage("212000", lngCode)));    
                result = "fail";    
            }
            }
        return result;
    }

    public void cancelBlacklist(ActionEvent actionEvent) {
        getBindings().getOperationBinding("doRollback").execute();
        FacesContext fctx = FacesContext.getCurrentInstance();
      
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        if(userSession.getAttribute("Fromdate")!=null)
        {
        userSession.removeAttribute("Fromdate");
        userSession.removeAttribute("todate");
        userSession.removeAttribute("plateno");
        userSession.removeAttribute("platccid");
        userSession.removeAttribute("plategid");
        userSession.removeAttribute("vehcol");
        userSession.removeAttribute("vehmake");
        userSession.removeAttribute("vehmodel");
        }
    }

    public String doNewBlacklist() {
        logger.info("doNewBlacklist");
        setHide(Boolean.FALSE);             
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        editMode="new";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doNewBlacklist");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.execute();
        logger.info("success"); 
        if(!isEnabled())
            setEnabled(Boolean.TRUE);    
       
        return null;
    }

    public String doEditBlacklist() {
        setHide(Boolean.FALSE);
        logger.info("doEditBlacklist");
        String userName = httpSession.getAttribute("loggedinUserid").toString();  
        editMode="edit";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditBlacklist");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","edit");
        opBinding.execute();
        setEnabled(Boolean.TRUE); 
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("VehicleBlacklistMstVO1Iterator").getEstimatedRowCount()>0)){
            pageflowScope.put("setvisible", false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        } 
          
        //truckIdButton.setRendered(Boolean.TRUE);
        return null;
    }

    public String doViewBlacklist() {
        logger.info("doViewBlacklist");
        String userName = httpSession.getAttribute("loggedinUserid").toString();
        editMode="view";
        BindingContainer bindings = getBindings();
        OperationBinding opBinding = bindings.getOperationBinding("doEditBlacklist");
        opBinding.getParamsMap().put("loggerName",userName);
        opBinding.getParamsMap().put("mode","view");
        opBinding.execute();  
        setHide(Boolean.FALSE);
        setEnabled(Boolean.FALSE);
        if(!(((DCBindingContainer)getBindings()).findIteratorBinding("VehicleBlacklistMstVO1Iterator").getEstimatedRowCount()>0)){
            pageflowScope.put("setvisible", false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No Data available to Edit/View Details", genMsg.getMessage("303", lngCode)));           
        }
           
        DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
        DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("VehicleBlacklistMstVO2Iterator");
        ViewObject blacklistVO = dcIteratorBinding.getViewObject();
        VehicleBlacklistMstVORowImpl blacklistVORow = (VehicleBlacklistMstVORowImpl)blacklistVO.getCurrentRow();
        DCIteratorBinding dc = bindings1.findIteratorBinding("printBlackVO1Iterator");
        ViewObject printvo = dc.getViewObject();
        printvo.setWhereClause(null);
        printvo.setWhereClause("Blacklist_seq=" + blacklistVORow.getBlacklistseq()
                               );
        printvo.executeQuery();
         
        // printVORowImpl whrow = (printVORowImpl)printvo.getCurrentRow();
         Row whrow= printvo.first();
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("Fromdate", whrow.getAttribute("ActiveDateFrom"));
        userSession.setAttribute("todate", whrow.getAttribute("ActiveDateTo")); 
        userSession.setAttribute("plateno", whrow.getAttribute("PLATENUMBER"));
        userSession.setAttribute("platccid", whrow.getAttribute("platecountryname")); 
        userSession.setAttribute("plategid", whrow.getAttribute("platetypedesc"));
        userSession.setAttribute("vehcol", whrow.getAttribute("ColourName"));
        userSession.setAttribute("vehmake",whrow.getAttribute("MakeName"));
        userSession.setAttribute("vehmodel",whrow.getAttribute("modelname")); 
        //truckIdButton.setRendered(Boolean.TRUE);
        return null;
    }

    public void setBlacklistTable(RichTable blacklistTable) {
        this.blacklistTable = blacklistTable;
    }

    public RichTable getBlacklistTable() {
        return blacklistTable;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isHide() {
        return hide;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }


    public void setEditMode(String editMode) {
        this.editMode = editMode;
    }

    public String getEditMode() {
        return editMode;
    }
}
