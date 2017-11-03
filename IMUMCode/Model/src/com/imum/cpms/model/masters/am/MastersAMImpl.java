package com.imum.cpms.model.masters.am;


import com.imum.cpms.model.masters.am.common.MastersAM;
import com.imum.cpms.model.masters.eo.CourtpvtHeaderVOImpl;
import com.imum.cpms.model.masters.vo.AccountMapMstVOImpl;
import com.imum.cpms.model.masters.vo.AccountMstVOImpl;
import com.imum.cpms.model.masters.vo.AuditCardsearchVOImpl;
import com.imum.cpms.model.masters.vo.BeatMstUVOImpl;
import com.imum.cpms.model.masters.vo.GenMsgMstLngVOImpl;
import com.imum.cpms.model.login.LoginVOImpl;
import com.imum.cpms.model.masters.eo.ContraventionMstEOImpl;
import com.imum.cpms.model.masters.vo.AccountMstVORowImpl;
import com.imum.cpms.model.masters.vo.AddressDetailsUVOImpl;
import com.imum.cpms.model.masters.vo.AddressDetailsUVORowImpl;


import com.imum.cpms.model.masters.vo.AddressDetailsUVORowImpl;
import com.imum.cpms.model.masters.vo.ContraventionMstUVOImpl;
import com.imum.cpms.model.masters.vo.CustInstAddressVOImpl;
import com.imum.cpms.model.masters.vo.CustInstAddressVORowImpl;
import com.imum.cpms.model.masters.vo.CustomerIndividualUVOImpl;
import com.imum.cpms.model.masters.vo.CustomerInstitutionVOImpl;
import com.imum.cpms.model.masters.vo.DocMasterUVOImpl;
import com.imum.cpms.model.masters.vo.DocMstDtlUVOImpl;
import com.imum.cpms.model.masters.vo.DocMstHdrUVOImpl;
import com.imum.cpms.model.masters.vo.GenMsgMstLngVOImpl;
import com.imum.cpms.model.masters.vo.GenMsgMstVOImpl;
import com.imum.cpms.model.masters.vo.GenRoleUVOImpl;
import com.imum.cpms.model.masters.vo.GroupMstUVOImpl;
import com.imum.cpms.model.masters.vo.InstitutionUVOImpl;
import com.imum.cpms.model.masters.vo.InstitutionUVORowImpl;
import com.imum.cpms.model.masters.vo.CustInstAddressVORowImpl;
import com.imum.cpms.model.masters.vo.CustomerIndividualUVORowImpl;


import com.imum.cpms.model.masters.vo.CustomerInstitutionVORowImpl;
import com.imum.cpms.model.masters.vo.DocMstDtlUVORowImpl;
import com.imum.cpms.model.masters.vo.DocMstHdrUVORowImpl;
import com.imum.cpms.model.masters.vo.GenEventLogDetailsUVOImpl;
import com.imum.cpms.model.masters.vo.GenEventLogDetailsUVORowImpl;
import com.imum.cpms.model.masters.vo.GenRoleUVORowImpl;
import com.imum.cpms.model.masters.vo.HHDeviceMstUVOImpl;
import com.imum.cpms.model.masters.vo.HolidayMstUVOImpl;
import com.imum.cpms.model.masters.vo.InvStockReorderLevelDetailsVOImpl;
import com.imum.cpms.model.masters.vo.InvStockReorderLevelDetailsVORowImpl;
import com.imum.cpms.model.masters.vo.LinkedSectorsVOImpl;
import com.imum.cpms.model.masters.vo.LocationMstVOImpl;
import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;
import com.imum.cpms.model.masters.vo.MessageVOImpl;
import com.imum.cpms.model.masters.vo.MessageVORowImpl;

import com.imum.cpms.model.masters.vo.PRMDocUVOImpl;
import com.imum.cpms.model.masters.vo.PVTCourtReportDocsUVOImpl;
import com.imum.cpms.model.masters.vo.PVTCourtReportUVOImpl;
import com.imum.cpms.model.masters.vo.PVTCourtReportingRVOImpl;
import com.imum.cpms.model.masters.vo.PVTCourtcaseremarksVOImpl;
import com.imum.cpms.model.masters.vo.PVTSearchRVORowImpl;
import com.imum.cpms.model.masters.vo.PVTWRITEOFFDETAILSVOImpl;
import com.imum.cpms.model.masters.vo.PVTWRITEOFFHEADERVOImpl;
import com.imum.cpms.model.masters.vo.PVTcourtsearchVOImpl;
import com.imum.cpms.model.masters.vo.PVTcourtsearchVORowImpl;
import com.imum.cpms.model.masters.vo.PermitAccountEntriesRVOImpl;
import com.imum.cpms.model.masters.vo.PermitChargesVOImpl;
import com.imum.cpms.model.masters.vo.PermitChargesVORowImpl;
import com.imum.cpms.model.masters.vo.PermitPaidDetailsImpl;
import com.imum.cpms.model.masters.vo.PermitQuotaVOImpl;
import com.imum.cpms.model.masters.vo.PermitQuotaVORowImpl;
import com.imum.cpms.model.masters.vo.PermitRuleUVOImpl;
import com.imum.cpms.model.masters.vo.PermitRuleUVORowImpl;

import com.imum.cpms.model.masters.vo.PermitSectorQuotaUVODefImpl;
import com.imum.cpms.model.masters.vo.PermitSectorQuotaUVOImpl;
import com.imum.cpms.model.masters.vo.PermitSectorQuotaUVORowImpl;

import com.imum.cpms.model.masters.vo.PvtAppealdocMstVOImpl;
import com.imum.cpms.model.masters.vo.PvtSearchWriteOffRVOImpl;
import com.imum.cpms.model.masters.vo.PvtWriteOffProgVOImpl;
import com.imum.cpms.model.masters.vo.RemovalTruckMstVOImpl;
import com.imum.cpms.model.masters.vo.RemovalTruckMstVORowImpl;
import com.imum.cpms.model.masters.vo.RevenueGroupUVOImpl;
import com.imum.cpms.model.masters.vo.RevenueTypeUVOImpl;
import com.imum.cpms.model.masters.vo.RuleMaxQuotaVOImpl;
import com.imum.cpms.model.masters.vo.RuleMaxQuotaVORowImpl;

import com.imum.cpms.model.masters.vo.SectorMstLngVOImpl;
import com.imum.cpms.model.masters.vo.SectorMstVOImpl;
import com.imum.cpms.model.masters.vo.ShiftMstUVOImpl;
import com.imum.cpms.model.masters.vo.UserMstUVOImpl;
import com.imum.cpms.model.masters.vo.VehicleBlacklistMstVOImpl;
import com.imum.cpms.model.masters.vo.VehicleBlacklistMstVORowImpl;
import com.imum.cpms.model.masters.vo.VehicleBlaclListMstUVOImpl;
import com.imum.cpms.model.masters.vo.VehicleBlaclListMstUVORowImpl;
import com.imum.cpms.model.masters.vo.VehicleCountrymstVOImpl;
import com.imum.cpms.model.masters.vo.VehicleCountrymstlngVOImpl;
import com.imum.cpms.model.masters.vo.VehicleWhitelistMstVOImpl;
import com.imum.cpms.model.masters.vo.VehicleWhitelistMstVORowImpl;
import com.imum.cpms.model.masters.vo.VehicleBlacklistMstVORowImpl;
import com.imum.cpms.model.masters.vo.VehicleCountrymstVORowImpl;
import com.imum.cpms.model.masters.vo.VehicleCountrymstlngVORowImpl;
import com.imum.cpms.model.masters.vo.ZoneMstVOImpl;
import com.imum.cpms.model.masters.vo.appealResVOImpl;
import com.imum.cpms.model.masters.vo.printBlackVOImpl;
import com.imum.cpms.model.masters.vo.printVOImpl;
import com.imum.cpms.model.transactions.vo.BayNumberLVOImpl;
import com.imum.cpms.model.transactions.vo.CardTypeMstUVOImpl;

import com.imum.cpms.model.transactions.vo.PVTDocsVOImpl;
import com.imum.cpms.model.transactions.vo.PVTEventDetailsVOImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVOImpl;
import com.imum.cpms.model.masters.vo.ZoneMstLngVOImpl;

import com.imum.cpms.model.masters.vo.appealResVORowImpl;

import java.math.BigDecimal;

import oracle.adf.model.BindingContext;

import java.math.BigDecimal;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Timestamp;
import java.sql.Types;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewLinkImpl;

import com.imum.cpms.model.transactions.am.TransactionsAMImpl;
import com.imum.cpms.model.transactions.vo.AuctionInitiationViewVOImpl;
import com.imum.cpms.model.transactions.vo.DepositAckDetailsUVOImpl;
import com.imum.cpms.model.transactions.vo.DepositAckDetailsUVORowImpl;
import com.imum.cpms.model.transactions.vo.GenEventDetailsUVOImpl;
import com.imum.cpms.model.transactions.vo.GenEventDetailsUVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTSearchRVOImpl;
import com.imum.cpms.model.transactions.vo.PoundBayDetailVORowImpl;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.RowSetIterator;
import oracle.jbo.VariableValueManager;

import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.UploadedFile;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 22 12:05:28 IST 2014
// ---    Wed May 21 19:25:48 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MastersAMImpl extends ApplicationModuleImpl implements MastersAM {

    /**
     * This is the default constructor (do not remove).
     */
    public MastersAMImpl() {
    }

    /* Rohini's Code - get current Category Name from Lang*/

    public void getLangRecForCtg(String Lang, String currentCtgId) {
        if (currentCtgId == null || currentCtgId.equalsIgnoreCase("")) {
            currentCtgId =
                    getVehiclePlateCategoryVO1().getCurrentRow() == null ?
                    getVehiclePlateCategoryVO1().first().getAttribute("PlateCtgID").toString() :
                    getVehiclePlateCategoryVO1().getCurrentRow().getAttribute("PlateCtgID").toString();
        }
        ViewObjectImpl vehPlateCtgMstLngVO2 = getVehPlateCtgMstLngVO2();
        vehPlateCtgMstLngVO2.applyViewCriteria(null);
        vehPlateCtgMstLngVO2.applyViewCriteria(vehPlateCtgMstLngVO2.getViewCriteria("GetByCtgIDLang"));
        VariableValueManager evm =
            vehPlateCtgMstLngVO2.ensureVariableManager();
        evm.setVariableValue("BindCtgID", currentCtgId);
        evm.setVariableValue("BindLang", Lang);
        vehPlateCtgMstLngVO2.executeQuery();
        if (vehPlateCtgMstLngVO2.getEstimatedRowCount() > 0) {
            getVehiclePlateCategoryVO1().getCurrentRow().setAttribute("VehCtgNameLng",
                                                                      vehPlateCtgMstLngVO2.first().getAttribute("PlateCtgDesc"));
        }
        /* Fetching Type lang records*/

        if (getVehiclePlateTypeVO1().getEstimatedRowCount() > 0) {

            getVehiclePlateTypeVO1().executeQuery();
            Row[] allRowsInRange =
                getVehiclePlateTypeVO1().getAllRowsInRange();
            ViewObjectImpl vehPlateTypeMstLngVO2 = getVehPlateTypeMstLngVO2();

            for (Row curRow : allRowsInRange) {
                if (curRow != null) {


                    System.out.println("current Type Id is :  " +
                                       curRow.getAttribute("PlateTypeID"));
                    vehPlateTypeMstLngVO2.applyViewCriteria(null);
                    vehPlateTypeMstLngVO2.applyViewCriteria(vehPlateTypeMstLngVO2.getViewCriteria("GetByTypeIDLang"));
                    VariableValueManager evm2 =
                        vehPlateTypeMstLngVO2.ensureVariableManager();
                    evm2.setVariableValue("BindTypeID",
                                          Integer.parseInt(curRow.getAttribute("PlateTypeID").toString()));
                    evm2.setVariableValue("BindLang", Lang);
                    vehPlateTypeMstLngVO2.executeQuery();

                    if (vehPlateTypeMstLngVO2.getEstimatedRowCount() > 0) {
                        System.out.println("Type Name from Lang :  " +
                                           vehPlateTypeMstLngVO2.first().getAttribute("PlateTypedesc").toString());
                        curRow.setAttribute("VehTypeNameLng",
                                            vehPlateTypeMstLngVO2.first().getAttribute("PlateTypedesc").toString());
                        System.out.println(" Type Lang name from Master" +
                                           curRow.getAttribute("PlateTypedesc"));
                    }

                } else {
                }
            }
        }

    }

    public String executePVTSearchVO(String pvtNumber){
        String hdrseq="";
  
        ViewObjectImpl loc1=(ViewObjectImpl)getPVTcourtsearchVO1();
        loc1.setApplyViewCriteriaName("PVTcourtsearchVOCriteria");
        loc1.setNamedWhereClauseParam("pvtBindVar",pvtNumber);
        loc1.executeQuery();
        int cnt = (int)loc1.getEstimatedRowCount();    
         if(cnt>0){
            PVTcourtsearchVORowImpl row=(PVTcourtsearchVORowImpl) loc1.first();
            if(row!=null){            
        Object hdrs=row.getPVTHDRSEQ();
                hdrseq=hdrs.toString();
            }           
            
        }
        ViewObjectImpl doc1=(ViewObjectImpl)getPVTCourtReportDocsUVO1();
        doc1.executeEmptyRowSet();
         ViewObjectImpl doc2=(ViewObjectImpl)getPVTDocsVO1();
         doc2.executeEmptyRowSet();
        int count = (int)loc1.getEstimatedRowCount();
        System.out.println(count);
        if(count>0){
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode","Edit"); 
        }
       return hdrseq; 
        
    }
    
    public void executeCreateCourtReport(){
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        getPVTCourtReportUVO2().executeEmptyRowSet();
        ViewObject codeReportVO = getPVTCourtReportUVO2();
        Row NewRow = codeReportVO.createRow();
        
        NewRow.setAttribute("CreatedDate",sqlDate);
        codeReportVO.insertRow(NewRow);
    }
    
    
    /* Rohini's code - to create new Category Lang record*/
    public void CreateNewRemarks(String username,String remarks,BigDecimal PRMHeaderseqBD)
    {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        ViewObjectImpl permiteventvo = this.getPermitRemarksEntityDetailsVO1();
        Row permitrow = permiteventvo.createRow();
        permitrow.setNewRowState(Row.STATUS_INITIALIZED);
        permitrow.setAttribute("CreatedBy",username);
        permitrow.setAttribute("CreatedDate",sqlDate);
        permitrow.setAttribute("EVENTDATE",sqlDate);
        permitrow.setAttribute("EVENTID","134");
        permitrow.setAttribute("PRMHeaderseq",PRMHeaderseqBD);
        permitrow.setAttribute("Remarks",remarks);
        permiteventvo.insertRow(permitrow);
        
    }
    
    public void CreateNewPermitDocument(String username,String fullPath,BigDecimal  Prmseq,String doctype,String DOCDesc) 
    {
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        BigDecimal SeqNum=new BigDecimal(0); 
        
        CallableStatement stmt = null;
                try {
                    stmt = getDBTransaction().createCallableStatement("{call  sequence_mst_trigger(?,?) }", 0);
                    stmt.setString(1, "PRM_DOC_SEQ");            
                    stmt.registerOutParameter(2, Types.BIGINT);
                    stmt.execute();      
                    SeqNum = stmt.getBigDecimal(2);
                          getDBTransaction().commit();
                      }  catch (Exception e) {
                                e.printStackTrace();
                       }
        
        
        ViewObjectImpl permitdocsvo = this.getPermitDocumentUVO1();
        Row permitDocsRow = permitdocsvo.createRow();
        permitDocsRow.setNewRowState(Row.STATUS_INITIALIZED);
        permitDocsRow.setAttribute("DOCSEQ",SeqNum);
        permitDocsRow.setAttribute("CreatedBy",username);
        permitDocsRow.setAttribute("CreatedDate",sqlDate);
        permitDocsRow.setAttribute("filepath",fullPath);
        permitDocsRow.setAttribute("PRMHeaderseq",Prmseq);
        permitDocsRow.setAttribute("deleteflag","N");
        permitDocsRow.setAttribute("doctype",doctype);
        permitDocsRow.setAttribute("DOCDesc",DOCDesc);
        
        
        permitdocsvo.insertRow(permitDocsRow);
       
    }
    public Boolean PermitDocsSeibelSync()
    {
        CallableStatement stmt1 = null;
            try {
                BigDecimal docseq = null;
                ViewObjectImpl permitdocsvo = this.getPermitDocumentUVO1();
                Row row = permitdocsvo.first();
                if(row.getAttribute("DOCSEQ") != null)
                 docseq = new BigDecimal(row.getAttribute("DOCSEQ").toString());
                System.out.println(docseq);
                //stmt1 = getDBTransaction().createCallableStatement("{call  INT_PVT_DATA_CHANGE_LOG_proc('PRM_DOCS', ?, 'N', 'N', 'X') }", 0);
                stmt1 = getDBTransaction().createCallableStatement("{call  INT_PVT_DATA_CHANGE_LOG_proc('PRM_DOCS', ?, 'N', 'N', 'X') }", 0);
                stmt1.setBigDecimal(1,docseq);            
                stmt1.execute(); 
                getDBTransaction().commit();
               
                
            }  catch (Exception e) {
                System.out.println("INT_PVT_DATA_CHANGE_LOG_proc procedure exception : "+e.getMessage());
                return false;
            } 
            return true;
    }

    public Boolean createNewCtgLangRec(String Lang, String CtgName,
                                           String currentPlateCtgId,
                                           String username) {

            ViewObjectImpl vehPlateCtgMstLngVO2 =(ViewObjectImpl) getVehPlateCtgMstLngVO2();
            vehPlateCtgMstLngVO2.applyViewCriteria(null);
            vehPlateCtgMstLngVO2.applyViewCriteria(vehPlateCtgMstLngVO2.getViewCriteria("GetByCtgIDLang"));
            VariableValueManager evm =
                vehPlateCtgMstLngVO2.ensureVariableManager();
            evm.setVariableValue("BindCtgID", currentPlateCtgId);
            evm.setVariableValue("BindLang", Lang);
            vehPlateCtgMstLngVO2.executeQuery();


            if (vehPlateCtgMstLngVO2.getEstimatedRowCount() > 0) {
                Row curRow = vehPlateCtgMstLngVO2.first();
                String curRowCtgName =
                    curRow.getAttribute("PlateCtgDesc") == null ? "" :
                    curRow.getAttribute("PlateCtgDesc").toString();
                if (!curRowCtgName.equalsIgnoreCase(CtgName)) {
                    curRow.setAttribute("PlateCtgDesc", CtgName);
                    curRow.setAttribute("Updatedby", username);
                }


            } else {
                ViewObject vehPlateCtgMstLngVO1 = getVehPlateCtgMstLngVO1();
               
                    try{
                Row NewRow = vehPlateCtgMstLngVO1.createRow();
                NewRow.setAttribute("PlateCtgID", currentPlateCtgId);
                NewRow.setAttribute("LNGCODE", Lang);
                NewRow.setAttribute("PlateCtgDesc", CtgName);
                NewRow.setAttribute("CreatedBy", username);
                NewRow.setAttribute("Updatedby", username);
                vehPlateCtgMstLngVO1.insertRow(NewRow);
                    }
                    catch(Exception e){
                        ViewObject vehPlateCtgMstLngV2 = getVehPlateCtgMstLngVO2();
                        Row NewRow = vehPlateCtgMstLngV2.createRow();
                        NewRow.setAttribute("PlateCtgID", currentPlateCtgId);
                        NewRow.setAttribute("LNGCODE", Lang);
                        NewRow.setAttribute("PlateCtgDesc", CtgName);
                        NewRow.setAttribute("CreatedBy", username);
                        NewRow.setAttribute("Updatedby", username);
                        vehPlateCtgMstLngV2.insertRow(NewRow);   
                    }

            }
            //            getDBTransaction().commit();
            return true;
        }

     /* Rohini's code - to create new Plate Type Lang record*/

    public Boolean createNewTypeLangRec(String Lang, String TypeName,
                                            String currentTypeId,
                                            String username) {

            ViewObjectImpl vehPlateTypeMstLngVO2 = getVehPlateTypeMstLngVO2();
            vehPlateTypeMstLngVO2.applyViewCriteria(null);
            vehPlateTypeMstLngVO2.applyViewCriteria(vehPlateTypeMstLngVO2.getViewCriteria("GetByTypeIDLang"));
            VariableValueManager evm =
                vehPlateTypeMstLngVO2.ensureVariableManager();
            evm.setVariableValue("BindTypeID", currentTypeId);
            evm.setVariableValue("BindLang", Lang);
            vehPlateTypeMstLngVO2.executeQuery();


            if (vehPlateTypeMstLngVO2.getEstimatedRowCount() > 0) {
                Row curRow = vehPlateTypeMstLngVO2.first();
                String curRowTypeName =
                    curRow.getAttribute("PlateTypedesc") == null ? "" :
                    curRow.getAttribute("PlateTypedesc").toString();
                if (!curRowTypeName.equalsIgnoreCase(TypeName)) {
                    curRow.setAttribute("PlateTypedesc", TypeName);
                    curRow.setAttribute("Updatedby", username);
                }


            } else {
                ViewObject vehPlateTypeMstLngVO1 = getVehPlateTypeMstLngVO1();
                try{
                Row NewRow = vehPlateTypeMstLngVO1.createRow();
                NewRow.setAttribute("PlateTypeID", currentTypeId);
                NewRow.setAttribute("LNGCODE", Lang);
                NewRow.setAttribute("PlateTypedesc", TypeName);
                NewRow.setAttribute("CreatedBy", username);
                NewRow.setAttribute("Updatedby", username);
                vehPlateTypeMstLngVO1.insertRow(NewRow);
                }
                catch(Exception e){
                ViewObject   vehPlateTypeMstLngVO3= getVehPlateTypeMstLngVO2();
                    Row NewRow = vehPlateTypeMstLngVO3.createRow();
                    NewRow.setAttribute("PlateTypeID", currentTypeId);
                    NewRow.setAttribute("LNGCODE", Lang);
                    NewRow.setAttribute("PlateTypedesc", TypeName);
                    NewRow.setAttribute("CreatedBy", username);
                    NewRow.setAttribute("Updatedby", username);
                    vehPlateTypeMstLngVO3.insertRow(NewRow);
                }

            }

            return true;
        }



    /* Rohini's Code - get current Make Name from Lang*/

    public void getLangRecForMake(String Lang, String currentMakeId) {
        if (currentMakeId == null || currentMakeId.equalsIgnoreCase("")) {
            currentMakeId =
                    getVehMakeMstVO1().getCurrentRow() == null ? getVehMakeMstVO1().first().getAttribute("MakeID").toString() :
                    getVehMakeMstVO1().getCurrentRow().getAttribute("MakeID").toString();
        }
        ViewObjectImpl vehMakeMstLngVO2 = getVehMakeMstLngVO2();
        vehMakeMstLngVO2.applyViewCriteria(null);
        vehMakeMstLngVO2.applyViewCriteria(vehMakeMstLngVO2.getViewCriteria("GetByMakeIDLang"));
        VariableValueManager evm = vehMakeMstLngVO2.ensureVariableManager();
        evm.setVariableValue("BindMakeID", currentMakeId);
        evm.setVariableValue("BindLang", Lang);
        vehMakeMstLngVO2.executeQuery();
        if (vehMakeMstLngVO2.getEstimatedRowCount() > 0) {
            getVehMakeMstVO1().getCurrentRow().setAttribute("VehMakeNameLng",
                                                            vehMakeMstLngVO2.first().getAttribute("MakeName"));
        }
        /* Fetching model lang records*/
        System.out.println("model row count :" +
                           getVehModelMstVO1().getEstimatedRowCount());
        if (getVehModelMstVO1().getEstimatedRowCount() > 0) {
            getVehModelMstVO1().setRangeSize(-1);
            getVehModelMstVO1().executeQuery();
            System.out.println("model row count :" +
                               getVehModelMstVO1().getEstimatedRowCount());
            Row[] allRowsInRange = getVehModelMstVO1().getAllRowsInRange();
            System.out.println("allRowsInRange for model" +
                               allRowsInRange.length);
            ViewObjectImpl vehModelMstLngVO2 = getVehModelMstLngVO2();

            for (Row curRow : allRowsInRange) {
                if (curRow != null) {


                    System.out.println("current Model Id is :  " +
                                       curRow.getAttribute("ModelId"));
                    vehModelMstLngVO2.applyViewCriteria(null);
                    vehModelMstLngVO2.applyViewCriteria(vehModelMstLngVO2.getViewCriteria("GetByModelIDLang"));
                    VariableValueManager evm2 =
                        vehModelMstLngVO2.ensureVariableManager();
                    evm2.setVariableValue("BindModelID",
                                          Integer.parseInt(curRow.getAttribute("ModelId").toString()));
                    evm2.setVariableValue("BindLang", Lang);
                    vehModelMstLngVO2.executeQuery();

                    if (vehModelMstLngVO2.getEstimatedRowCount() > 0) {
                        System.out.println("model Name from Lang :  " +
                                           vehModelMstLngVO2.first().getAttribute("ModelName").toString());
                        curRow.setAttribute("VehModelNameLng",
                                            vehModelMstLngVO2.first().getAttribute("ModelName").toString());
                        System.out.println(" model Lang name from Master" +
                                           curRow.getAttribute("VehModelNameLng"));
                    }

                } else {
                    System.out.println("no lang records found ");

                }
            }
        }
        getVehModelMstVO1().setRangeSize(1);

    }

    /* Rohini's code - to create new Make Lang record*/

    public Boolean createNewMakeLangRec(String Lang, String MakeName,
                                        String currentMakeId,
                                        String username) {

        ViewObjectImpl vehMakeMstLngVO2 = getVehMakeMstLngVO2();
        vehMakeMstLngVO2.applyViewCriteria(null);
        vehMakeMstLngVO2.applyViewCriteria(vehMakeMstLngVO2.getViewCriteria("GetByMakeIDLang"));
        VariableValueManager evm = vehMakeMstLngVO2.ensureVariableManager();
        evm.setVariableValue("BindMakeID", currentMakeId);
        evm.setVariableValue("BindLang", Lang);
        vehMakeMstLngVO2.executeQuery();


        if (vehMakeMstLngVO2.getEstimatedRowCount() > 0) {
            Row curRow = vehMakeMstLngVO2.first();
            String curRowMakeName =
                curRow.getAttribute("MakeName") == null ? "" :
                curRow.getAttribute("MakeName").toString();
            if (!curRowMakeName.equalsIgnoreCase(MakeName)) {
                curRow.setAttribute("MakeName", MakeName);
                curRow.setAttribute("Updatedby", username);
            }


        } else {
            ViewObject vehMakeLngVO1 = getVehMakeMstLngVO1();
            Row NewRow = vehMakeLngVO1.createRow();
            NewRow.setAttribute("MakeID", currentMakeId);
            NewRow.setAttribute("LNGCODE", Lang);
            NewRow.setAttribute("MakeName", MakeName);
            NewRow.setAttribute("CreatedBy", username);
            NewRow.setAttribute("Updatedby", username);
            vehMakeLngVO1.insertRow(NewRow);

        }
        //            getDBTransaction().commit();
        return true;
    }

    /* Rohini's code - to create new ModelLang record*/

    public Boolean createNewModelLangRec(String Lang, String ModelName,
                                         String currentModelId,
                                         String username) {

        ViewObjectImpl getVehModelMstLngVO2 = getVehModelMstLngVO2();
        getVehModelMstLngVO2.applyViewCriteria(null);
        getVehModelMstLngVO2.applyViewCriteria(getVehModelMstLngVO2.getViewCriteria("GetByModelIDLang"));
        VariableValueManager evm =
            getVehModelMstLngVO2.ensureVariableManager();
        evm.setVariableValue("BindModelID", currentModelId);
        evm.setVariableValue("BindLang", Lang);
        getVehModelMstLngVO2.executeQuery();


        if (getVehModelMstLngVO2.getEstimatedRowCount() > 0) {
            Row curRow = getVehModelMstLngVO2.first();
            String curRowMakeName =
                curRow.getAttribute("ModelName") == null ? "" :
                curRow.getAttribute("ModelName").toString();
            if (!curRowMakeName.equalsIgnoreCase(ModelName)) {
                curRow.setAttribute("ModelName", ModelName);
                curRow.setAttribute("Updatedby", username);
            }


        } else {
            ViewObject vehModelLngVO1 = getVehModelMstLngVO1();
            Row NewRow = vehModelLngVO1.createRow();
            NewRow.setAttribute("ModelId", currentModelId);
            NewRow.setAttribute("LNGCODE", Lang);
            NewRow.setAttribute("ModelName", ModelName);
            NewRow.setAttribute("CreatedBy", username);
            NewRow.setAttribute("Updatedby", username);
            vehModelLngVO1.insertRow(NewRow);

        }

        return true;
    }


    /** rohini's Vehicle Plate Category & Type Code
     *
     * */
    public Integer createNewVehCategoryMstDetails(String username) {
        /* logic to get the latest Category ID */
        getVehiclePlateCategoryVO2().executeQuery();
        long count = getVehiclePlateCategoryVO2().getEstimatedRowCount();
        Integer nextPlateCtgId = 1;
        if (count > 0) {
            nextPlateCtgId =
                    (Integer)getVehiclePlateCategoryVO2().first().getAttribute("PlateCtgID");
            nextPlateCtgId++;
        }
        Row makeRow = getVehiclePlateCategoryVO1().createRow();
        //        VehiclePlateCategoryVOImpl vo  =(VehiclePlateCategoryVOImpl)this.getVehiclePlateCategoryVO1();
        //        VehiclePlateCategoryVORowImpl makeRow = (VehiclePlateCategoryVORowImpl)vo.createRow();
        if (makeRow != null) {
            //            makeRow.setAttribute("CreatedBy",username);
            //            makeRow.setAttribute("UpdatedBy",username);
            makeRow.setAttribute("CreatedBy", username);
          
           // makeRow.setAttribute("Plate_Country_ID", Integer.parseInt(countryid));
            getVehiclePlateCategoryVO1().insertRow(makeRow);
         
                

        }

        //       getVehiclePlateCategoryVO1().insertRow(getVehiclePlateCategoryVO1().createRow());

        System.out.println("Next Plate Category Id is : " + nextPlateCtgId);
        Row newModelRow = getVehiclePlateTypeVO2().createRow();
        newModelRow.setAttribute("PlateCategoryID", nextPlateCtgId);
        newModelRow.setAttribute("TypeOrder", Integer.parseInt("1"));
        newModelRow.setAttribute("CreatedBy", username);
        makeRow.setAttribute("CreatedBy", username);
        getVehiclePlateTypeVO2().setWhereClause(null);
        getVehiclePlateTypeVO2().setWhereClause("VehiclePlateTypeEO.Plate_Category_ID=" +
                                                nextPlateCtgId);
        getVehiclePlateTypeVO2().executeQuery();
        getVehiclePlateTypeVO2().insertRow(newModelRow);
        //        getVehiclePlateTypeVO2().getQuery();

        return nextPlateCtgId;


    }


    /** rohini's Vehicle Make & Model Master Code
     *
     * */


    public void getZonesOfSector(String Sector) {
        //         String sector ="";
        //        if(getSectorMstVO1().getCurrentRow() == null){
        //        getSectorMstVO1().setCurrentRow(getSectorMstVO1().first());
        //            }
        //        sector = getSectorMstVO1().getCurrentRow().getAttribute("SectorCode").toString();
        System.out.println("Current Sector Code is : " + Sector);
        getSectorDocs(Sector);

        getZoneMstVO1().applyViewCriteria(getZoneMstVO1().getViewCriteria("GetBySectorCode"));
        VariableValueManager evm = getZoneMstVO1().ensureVariableManager();
        evm.setVariableValue("BindSectorCode", Sector);
        getZoneMstVO1().executeQuery();

        getLinkedSectorsVO1().applyViewCriteria(getLinkedSectorsVO1().getViewCriteria("GetBySectorCode"));
        VariableValueManager evm2 =
            getLinkedSectorsVO1().ensureVariableManager();
        evm2.setVariableValue("BindSectorCode", Sector);
        getLinkedSectorsVO1().executeQuery();

        //         getLinkedSectorsVO1()

    }

    public Integer createNewVehMstDetails(String username) {
        /* logic to get the latest Make ID */
        getVehMakeMstVO2().executeQuery();
        long count = getVehMakeMstVO2().getEstimatedRowCount();
        Integer nextMakeId = 1;
        if (count > 0) {
            nextMakeId =
                    (Integer)getVehMakeMstVO2().first().getAttribute("MakeID");
            nextMakeId++;
        }
        Row makeRow = getVehMakeMstVO1().createRow();
        makeRow.setAttribute("CreatedBy", username);
        makeRow.setAttribute("UpdatedBy", username);
        getVehMakeMstVO1().insertRow(makeRow);

        System.out.println("Next Make Id is : " + nextMakeId);
        /* Keeping Model is Optional
         * Row newModelRow = getVehModelMstVO2().createRow();
        newModelRow.setAttribute("MakeID", nextMakeId);
        newModelRow.setAttribute("CreatedBy", username);
        newModelRow.setAttribute("UpdatedBy", username);
        getVehModelMstVO2().setWhereClause(null);
        getVehModelMstVO2().setWhereClause("VehModelMstEO.Make_ID=" +
                                           nextMakeId);
        getVehModelMstVO2().executeQuery();
        getVehModelMstVO2().insertRow(newModelRow); */
        //        getVehModelMstVO2().getQuery();

        return nextMakeId;


    }

    /**
     * Rohini's Sector Master related Code
     * */

    public Integer createNewSector(String username) {
        /*Get Max Sector Id from DB */
        //        getSectorMstVO1().executeQuery();
        //        Row first = getSectorMstVO1().first();
        //            Integer SectorID=1;
        //        if(first!=null) SectorID= Integer.parseInt(first.getAttribute("SectorID").toString())+1;

        Row newRow = getSectorMstVO1().createRow();
        newRow.setAttribute("CreatedBy", username);
        newRow.setAttribute("UpdatedBy", username);
        //        newRow.setAttribute("SectorID", SectorID);
        //        System.out.println("New Sector Row's Sector Id is : "+newRow.getAttribute("SectorID").toString());
        getSectorMstVO1().insertRow(newRow);

        /* filter docs based on sector code*/
        getSectorDocs("");

        return null;
    }

    /* Code to filter sector docs based on sector code*/

    public void getSectorDocs(String Sector) {
        //        getGenRefDataDocVO1()
        getGenRefDataDocVO1().applyViewCriteria(null);
        getGenRefDataDocVO1().applyViewCriteria(getGenRefDataDocVO1().getViewCriteria("GetByReferenceId"));
        VariableValueManager evm =
            getGenRefDataDocVO1().ensureVariableManager();
        evm.setVariableValue("BindRefId", Sector);
        getGenRefDataDocVO1().executeQuery();

    }

    public void uploadSectorDocs(String Sectorcode, ArrayList uploadFiles) {
        ViewObjectImpl dataDocVO1 = getGenRefDataDocVO1();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());

        //        int documentStage=7; // Check with Venu;
        if (dataDocVO1 != null && null != uploadFiles) {
            for (int i = 0; i < uploadFiles.size(); i++) {
                Row SecDocRow = dataDocVO1.createRow();
                int doctype;
                doctype = getFileExtension((String)uploadFiles.get(i));

                /*start of code to get RelatedTo value */
                getGenRefDataHeaderMstRVO1().applyViewCriteria(getGenRefDataHeaderMstRVO1().getViewCriteria("GetByRefGroupCode"));
                VariableValueManager evm =
                    getGenRefDataHeaderMstRVO1().ensureVariableManager();
                evm.setVariableValue("BindRefGroupCode", "GEN_DOC_RELATED_TO");
                getGenRefDataHeaderMstRVO1().executeQuery();


                getGenRefDataDetailMstRVO1().applyViewCriteria(getGenRefDataDetailMstRVO1().getViewCriteria("GetByRefHeaderSeqAndValueDesc"));
                VariableValueManager evm1 =
                    getGenRefDataDetailMstRVO1().ensureVariableManager();
                evm1.setVariableValue("BindRefDataHeaderSeq",
                                      Integer.parseInt(getGenRefDataHeaderMstRVO1().first().getAttribute("RefdataHeaderseq").toString()));
                evm1.setVariableValue("BindValueDesc", "SECTOR");
                getGenRefDataDetailMstRVO1().executeQuery();
                /*end of code */
                System.out.println("file path is : " + uploadFiles.get(i));
                SecDocRow.setAttribute("RELATEDTO",
                                       Integer.parseInt(getGenRefDataDetailMstRVO1().first().getAttribute("ValueCode").toString())); //Value of Value_Code in "Gen_Ref_Data_Detail_Mst" whose Ref_Data_Header_Seq is 13 & value_description is "Sector".
                SecDocRow.setAttribute("referenceid", Sectorcode);
                SecDocRow.setAttribute("filepath", uploadFiles.get(i));
                SecDocRow.setAttribute("doctype", doctype);
                SecDocRow.setAttribute("deleteflag", "N");
                dataDocVO1.insertRow(SecDocRow);
            }
        }
    }

    private int getFileExtension(String file) {
        String fileName = file;
        String extType = null;
        int docType = 0;
        if (fileName.lastIndexOf(".") != -1 &&
            fileName.lastIndexOf(".") != 0) {
            extType = fileName.substring(fileName.lastIndexOf(".") + 1);
            //.gif.bmp.dib.jpg.jpe.jfif.tiff.tif
            if (extType != null && extType.equalsIgnoreCase("jpeg") ||
                extType.equalsIgnoreCase("png") ||
                extType.equalsIgnoreCase("gif") ||
                extType.equalsIgnoreCase("bmp") ||
                extType.equalsIgnoreCase("dib") ||
                extType.equalsIgnoreCase("jpg") ||
                extType.equalsIgnoreCase("jfif") ||
                extType.equalsIgnoreCase("tiff") ||
                extType.equalsIgnoreCase("tif")) {
                extType = "IMAGE";
                docType = 2;
            } else if (extType != null && extType.equalsIgnoreCase("xml")) {
                extType = "XML";
                docType = 3;
            } else if (extType != null && extType.equalsIgnoreCase("pdf")) {
                extType = "PDF";
                docType = 3;
            } else if (extType != null &&
                       (extType.equalsIgnoreCase("MPG") || extType.equalsIgnoreCase("MPEG"))) {
                extType = "Video";
                docType = 4;
            }
            return docType;
        }

        else
            return docType;
    }

    public Boolean getSectorRowCount() {
        getSectorMstVO1().executeQuery();
        System.out.println("RowCount is " +
                           getSectorMstVO1().getEstimatedRowCount());
        return getSectorMstVO1().getEstimatedRowCount() > 0 ? Boolean.TRUE :
               Boolean.FALSE;

    }

    public Boolean doCommit() {
        try {
            getDBTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public Boolean doRollback() {
        try {
            getDBTransaction().rollback();
        } catch (Exception e) {
            System.out.println("Rollback failed");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //    /**
    //     * Subiksha - User Management - 13-10-2014
    //     */
    //        public void convertPwdSecAns(String userId, String pwd, String secans)
    //        {
    //        getDBTransaction().commit();
    //        PreparedStatement preparedStatement = null;
    //            try {
    //                String sql = "update gen_user_mst set password = convert(varbinary,'"+pwd+"') , secret_ans = convert(varbinary,'"+secans+"') where user_id = '"+userId+"'";
    //                preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
    //                preparedStatement.executeUpdate();
    //                getDBTransaction().commit();
    //            }  catch (Exception e) {
    //                e.printStackTrace();
    //            }
    //        }
    //

    /**
     * Subiksha - User Management - 13-10-2014
     */
    public void convertPwdSecAns(String userId, String pwd, String secans,
                                 String isPwdMod, String isSaMod,
                                 String mode) {

        //            String OldPwd = getUserMstUVO2().getCurrentRow().getAttribute("Password")!=null ? getUserMstUVO1().getCurrentRow().getAttribute("Password").toString(): "";
        //            String OldSecAns = getUserMstUVO2().getCurrentRow().getAttribute("Secretans")!=null ? getUserMstUVO1().getCurrentRow().getAttribute("Secretans").toString(): "";

        //        String HashOldPwd
        String HashPwd = "";
        String HashSecAns = "";
        if (isPwdMod.equalsIgnoreCase("Y")) {
            HashPwd = getHashString(pwd);
            System.out.println("Hashed New Password is : " + HashPwd);
        } else{
            HashPwd = pwd;
            }
        if (isSaMod.equalsIgnoreCase("Y")) {
            HashSecAns = getHashString(secans);
            System.out.println("Hashed New SecAns is : " + HashSecAns);
        } else{
            HashSecAns = secans;
        }


        if (!(HashPwd.equalsIgnoreCase("error") ||
              HashSecAns.equalsIgnoreCase("error"))) {

//            if (mode.equalsIgnoreCase("new")) {
                getDBTransaction().commit();
//            }
            PreparedStatement preparedStatement = null;
            try {
                String sql =
                    "update gen_user_mst set password = convert(varbinary(80),'" +
                    HashPwd + "') , secret_ans = convert(varbinary(255),'" +
                    HashSecAns + "') where user_id = '" + userId + "'";
                preparedStatement =
                        getDBTransaction().createPreparedStatement(sql, 0);
                preparedStatement.executeUpdate();
                getDBTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Changes are not committed since HashString output is error for pwd or secAns. ");
        }

    }

    public String encryptData(String value) {
        
//        if(true)return value;
        
        String result = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql =
                "select convert(varbinary,'" + value + "') as resultVal;";
            preparedStatement =
                    getDBTransaction().createPreparedStatement(sql, 0);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnType(1));
            if (rs != null) {
                while (rs.next()) {
                    Object esult = rs.getObject("resultVal");
                    result = esult.toString();
                    System.out.println(result);
                    Row row = this.getUserMstUVO1().getCurrentRow();
                    row.setAttribute("Password", esult);
                }
            }
        } catch (Exception e) {
            System.out.println("encryptData exception : " + e.getMessage());
        }
        return result;
    }

    /**
     * Subiksha Holiday Master Code - 05-09-2014
     */
    public void createNewHoliday(String encoder) {
        HolidayMstUVOImpl vo = (HolidayMstUVOImpl)this.getHolidayMstUVO1();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        if (vo != null) {
            Row contrMstRow = vo.createRow();
            contrMstRow.setAttribute("CreatedBy", encoder);
            contrMstRow.setAttribute("CreatedDate", sqlDate);
            vo.insertRow(contrMstRow);
        }
    }
    public void createnewBeat(String username,String zonecode)
    {
        
        BeatMstUVOImpl vo = (BeatMstUVOImpl)this.getBeatMstUVO1();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        if (vo != null) {
            Row Beatrow = vo.createRow();
            Beatrow.setNewRowState(Row.STATUS_INITIALIZED);
          
            Beatrow.setAttribute("CreatedBy", username);
            Beatrow.setAttribute("CreatedDate", sqlDate);
            Beatrow.setAttribute("ZoneCode", zonecode);
            Beatrow.setAttribute("GeoLatDeg", null);
            //Beatrow.setAttribute("clickonedit", "Y");
            vo.insertRow(Beatrow);
          
        }
      
    }
    
    
    
    
    public void createnewRow(String username,String reasonid)
    {
        
        ViewObject vo =getPvtAppealdocMstVO1();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        if (vo != null) {
            Row newrow = vo.createRow();
            newrow.setNewRowState(Row.STATUS_INITIALIZED);
            newrow.setAttribute("CreatedBy", username);
            newrow.setAttribute("CreatedDate", sqlDate);
            newrow.setAttribute("DEFCityCode", "DFA");
            newrow.setAttribute("DEFCountryMst","ARE");
            vo.insertRow(newrow);
          
        }
      
    }
    public void createRevenueGroupType(String username) 
    {
        RevenueGroupUVOImpl groupvo = (RevenueGroupUVOImpl)this.getRevenueGroupUVO2();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        if (groupvo != null) {
            Row grouprow = groupvo.createRow();
            grouprow.setNewRowState(Row.STATUS_INITIALIZED);
            grouprow.setAttribute("CountryCode", "ARE");
            grouprow.setAttribute("CreatedBy", username);
            grouprow.setAttribute("CreatedDate", sqlDate);
            groupvo.insertRow(grouprow);
          
        }
    }
    public void createRevenueTypeRow(String username,String GroupCode) 
    {
        ViewObjectImpl Typevo = this.getRevenueTypeUVO1();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        if (Typevo != null) {
            Row Typerow = Typevo.createRow();
            Typerow.setNewRowState(Row.STATUS_INITIALIZED);
          
            Typerow.setAttribute("CreatedBy", username);
            Typerow.setAttribute("CreatedDate",sqlDate);
            Typerow.setAttribute("RevGrpCode",GroupCode);
            Typevo.insertRow(Typerow);
          
        }
    }


    public void updateHolidaySequence(BigDecimal holidaySequence) {
        PreparedStatement preparedStatement = null;
        try {
            String sql =
                "update  sequence_mst set last_used_num=" + holidaySequence +
                " where seq_name='GEN_Holiday_Id_SEQ'";
            preparedStatement =
                    getDBTransaction().createPreparedStatement(sql, 0);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDBTransaction().commit();
    }

    /**
     * Subiksha's Asset Master Code
     */
    public void addNewAssetMst(String encoder) {
        HHDeviceMstUVOImpl vo = (HHDeviceMstUVOImpl)this.getHHDeviceMstUVO1();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        if (vo != null) {
            Row contrMstRow = vo.createRow();
            contrMstRow.setAttribute("CreatedBy", encoder);
            contrMstRow.setAttribute("CreatedDate", sqlDate);
             vo.insertRow(contrMstRow);
        }
    }
    


    public String getHashString(String str) {
//        if(true)return str;
        String HashStr = "";
        CallableStatement stmt = null;
        try {

            stmt =
getDBTransaction().createCallableStatement("{call  gen_hashstring(?,?) }", 0);
            stmt.setString(1, str);
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            HashStr = stmt.getString(2);

            System.out.println("output is " + HashStr);
            return HashStr;

        } catch (SQLException sqlerr) {
            sqlerr.printStackTrace(); //throw new JboException(closeerr);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException closeerr) {
                closeerr.printStackTrace(); //throw new JboException(closeerr);
            }
            if (HashStr.equalsIgnoreCase(""))
                return "error";
            else
                return HashStr;
        }

    }
    public String getGroupName(String grpid){
        String grpname=null;
        try{
        ViewObjectImpl uservo=(ViewObjectImpl)this.getUserMstUVO2();
        int groupid = Integer.parseInt(grpid);
        uservo.setWhereClause("Group_Id="+groupid);
        System.out.println("grpid qry::"+uservo.getQuery());
        uservo.executeQuery();
        Row row=uservo.first();
        grpname= row.getAttribute("GroupName").toString();
                
        }
        catch(Exception e){
            ViewObjectImpl uservo=(ViewObjectImpl)this.getUserMstUVO1();
            int groupid = Integer.parseInt(grpid);
            uservo.setWhereClause("Group_Id="+groupid);
            System.out.println("grpid qry::"+uservo.getQuery());
            uservo.executeQuery();
            Row row=uservo.first();
            if(row!=null){
            grpname= row.getAttribute("GroupName").toString();
            }          
        }
     return grpname;   
    }
    
    public String CreateGenEventDetails(String depositAckSeqbigD,String NewDepSlip,String OldDepSlip,String encoder,Integer EventId) 
    {
        BigDecimal depAckSlip = null;
         ViewObjectImpl vo = (ViewObjectImpl)this.getGenEventLogDetailsUVO1();
        
        RowSetIterator rsi=vo.createRowSetIterator(null);
        //Row EventRow=null;
         
              if(rsi.hasNext())
              {
//              EventRow=rsi.createRow();
//              EventRow.setNewRowState(Row.STATUS_INITIALIZED);
          }
              
         java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());    
         if(vo != null)
         {
             Integer depositAckSeqInt = Integer.parseInt(depositAckSeqbigD);
            
             GenEventLogDetailsUVORowImpl EventRow = (GenEventLogDetailsUVORowImpl)vo.createRow(); 
           
             EventRow.setAttribute("CreatedBy",encoder);
             EventRow.setAttribute("CreatedDate",sqlDate);
             EventRow.setAttribute("GENHeaderseq",depositAckSeqInt);
             EventRow.setAttribute("EVENTID",EventId );
             EventRow.setAttribute("EVENTDATE",sqlDate);
             if(EventId == 701)
             EventRow.setAttribute("Remarks"," old Deposit Number is: '"+OldDepSlip+"' New Depost Number is:" +NewDepSlip);
            
             if(EventId == 707){
                 String oldDepSlipHash=getHashString(OldDepSlip);
                 String newDepSlipHash=getHashString(NewDepSlip);
             EventRow.setAttribute("Remarks"," old Password is: '"+oldDepSlipHash+"' New Password is:" +newDepSlipHash);
             }
             if(EventId == 704)
                 EventRow.setAttribute("Remarks","Active flag is checked. for  user '["+ADFContext.getCurrent().getPageFlowScope().get("usernameuserid") +"]' ");
             if(EventId == 705)
                 EventRow.setAttribute("Remarks","Active flag is unchecked  for user '["+ADFContext.getCurrent().getPageFlowScope().get("usernameuserid") +"]'");
             if(EventId == 708){
                 String oldgrpname=getGroupName(OldDepSlip);
                 String newgrpname=getGroupName(NewDepSlip);
             EventRow.setAttribute("Remarks"," old Group  is: '"+oldgrpname+"' New Group is: '"+newgrpname+"' for user '["+ADFContext.getCurrent().getPageFlowScope().get("usernameuserid")+"]'");
             }
             EventRow.setAttribute("EventAmt",0);
             EventRow.setAttribute("BalanceAmt",0);
             
             vo.insertRow(EventRow);    
         }    
     return null;   
    }

    public String encryptLdapData(String value) {
                if(true)return value;
        String encryPtPass = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql =
                "select convert(varbinary(80),'" + value + "') as resultVal;";
            preparedStatement =
                    getDBTransaction().createPreparedStatement(sql, 0);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnType(1));
            if (rs != null) {
                while (rs.next()) {
                    encryPtPass = rs.getString("resultVal");
                }
            }
        } catch (Exception e) {
            System.out.println("encryptData exception : " + e.getMessage());
        }
        return encryPtPass;
    }

    /**
     * Subiksha's Contravention Code
     */
    public void addNewContrMst(String encoder) {
        ContraventionMstUVOImpl vo =
            (ContraventionMstUVOImpl)this.getContraventionMstUVO1();
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        if (vo != null) {
            Row contrMstRow = vo.createRow();
            contrMstRow.setAttribute("CreatedBy", encoder);
            contrMstRow.setAttribute("CreatedDate", sqlDate);
            contrMstRow.setAttribute("CountryCode", "ARE");
            vo.insertRow(contrMstRow);
        }
    }

    /**
     * Subiksha Code - Doc Master
     */
    public int addNewDocMaster(String encoder) {

        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        Integer prmDocId = null;
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("DocMstHdrUVO2Iterator");
        ViewObject docMstHVO = dcItteratorBindings.getViewObject();
        System.out.println("docMstHVO.getRowCount()" +
                           docMstHVO.getRowCount());
        DocMstHdrUVORowImpl hdRow = (DocMstHdrUVORowImpl)docMstHVO.first();
        //            if(docMstHVO.getRowCount() > 0)
        //            {
        //                 hdRow = (DocMstHdrUVORowImpl)docMstHVO.getRowAtRangeIndex(0);
        //             //
        //            }
        if (hdRow != null) {
            prmDocId = hdRow.getPRMDocMstseq() + 1;
        } else if (hdRow == null) {
            prmDocId = 1;
        }


        ViewObject docMstHdVO = this.getDocMstDtlUVO1();
        Row hdrRow = docMstHdVO.createRow();
        ViewObject docMstdtVO = this.getDocMstHdrUVO1();
        Row dtlRow = docMstdtVO.createRow();

        if (docMstHdVO != null && docMstdtVO != null) {
            docMstHdVO.setWhereClause(null);
            docMstHdVO.setWhereClause("PRM_Doc_Mst_seq = " + prmDocId);
            docMstHdVO.executeQuery();
            hdrRow.setAttribute("CreatedBy", encoder);
            hdrRow.setAttribute("CreatedDate", sqlDate);
            docMstHdVO.insertRow(hdrRow);
            System.out.println("addNewDocMaster header row count is : " +
                               docMstHdVO.getRowCount());
            docMstdtVO.setWhereClause(null);
            docMstdtVO.setWhereClause("PRM_Doc_Mst_seq = " + prmDocId);
            docMstdtVO.executeQuery();
            dtlRow.setAttribute("CreatedBy", encoder);
            dtlRow.setAttribute("CreatedDate", sqlDate);
            docMstdtVO.insertRow(dtlRow);
            System.out.println("addNewDocMaster details row count is : " +
                               docMstdtVO.getRowCount());
        }

        ViewObjectImpl docMstDtlVO = getDocMstDtlUVO1();
        DocMstDtlUVORowImpl dtRow =
            (DocMstDtlUVORowImpl)docMstDtlVO.getCurrentRow();
        if (dtlRow != null && prmDocId != null) {
            dtRow.setPRMDocMstseq(prmDocId);

            System.out.println("Foreign key on submit is : " +
                               dtRow.getPRMDocMstseq());
        } else {
            System.out.println("Submit denied");
        }

        return prmDocId;


    }

    public void submitDocMaster() {

        getDBTransaction().commit();
    }

    public void submitPermitRule() {

        getDBTransaction().commit();

    }

    /**
     * Hari Code - Custoemer Individual
     * */
    public String doCustomerNew() {
        ViewObjectImpl addVO = this.getAddressDetailsUVO1();
        ViewObjectImpl CusVo = this.getCustomerIndividualUVO2();

        CustomerIndividualUVORowImpl row2 =
            (CustomerIndividualUVORowImpl)CusVo.createRow();
        addVO.clearCache();
        addVO.executeQuery();

        AddressDetailsUVORowImpl row1 =
            (AddressDetailsUVORowImpl)addVO.createRow();
        addVO.insertRow(row1);
        //           String cityCode = row1.getCityCode();
        //           String countrycode = row1.getCountrycode();
        CusVo.insertRow(row2);
        BigDecimal CustomerId = row2.getCustID();
        BigDecimal aDDRESSDTLSEQ = row1.getADDRESSDTLSEQ();
        //          DBTransaction bTransaction = this.getDBTransaction();
        ViewObjectImpl CusAddrVO = this.getCustInstAddressVO1();
        CustInstAddressVORowImpl row3 =
            (CustInstAddressVORowImpl)CusAddrVO.createRow();
        row3.setInstCustID(CustomerId);
        row3.setADDRESSDTLSEQ(aDDRESSDTLSEQ);
        CusAddrVO.insertRow(row3);

        return null;
    }

    public String doCusAddressSearch() {
        ViewObjectImpl addVO = this.getAddressDetailsUVO1();
        AddressDetailsUVORowImpl row =
            (AddressDetailsUVORowImpl)addVO.getCurrentRow();
        String bILLNUM = row.getUTILBILLNUM();
        if (bILLNUM != null) {
            addVO.clearCache();
            addVO.setWhereClause(null);
            addVO.setWhereClause("UTIL_BILL_NUM = ' " + bILLNUM + "'");
            addVO.executeQuery();
        }
        return null;
    }

    public String doCustomerSubmit() {
        ViewObjectImpl addVO = this.getAddressDetailsUVO1();
        ViewObjectImpl CusVo = this.getCustomerIndividualUVO2();
        CustomerIndividualUVORowImpl row2 =
            (CustomerIndividualUVORowImpl)CusVo.getCurrentRow();
        AddressDetailsUVORowImpl row1 =
            (AddressDetailsUVORowImpl)addVO.getCurrentRow();
        if (row1 != null) {
            String cityCode = row1.getCityCode();
            String countrycode = row1.getCountrycode();
            if (cityCode != null)
                row2.setCityCode(cityCode);
            if (countrycode != null)
                row2.setCountrycode(countrycode);
        }
        getDBTransaction().commit();
        return null;

    }


    public String doCusIndView() {
        doCustomerEdit();

        return null;

    }

    public String doCustomerEdit() {

        ViewObjectImpl CusAddrVO = this.getCustInstAddressVO1();

        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("CustomerIndividualUVO1Iterator");
        ViewObject CusvoTableData = dcItteratorBindings.getViewObject();
        Row CustomerrowSelected = CusvoTableData.getCurrentRow();
        BigDecimal CustomerId =
            (BigDecimal)CustomerrowSelected.getAttribute("CustID");
        BigDecimal CustAddrSeq = null;
        BigDecimal AddrDetailseq = null;
        //      BigDecimal   CustAddrDetailSeq = null;

        DCIteratorBinding dcItteratorBindings2 =
            bindings.findIteratorBinding("CustomerIndividualUVO2Iterator");
        ViewObject Cusvo2TableData = dcItteratorBindings2.getViewObject();
        if (CustomerId != null) {
            Cusvo2TableData.clearCache();
            Cusvo2TableData.setWhereClause(null);
            Cusvo2TableData.setWhereClause("Cust_ID = " + CustomerId);
            Cusvo2TableData.executeQuery();

            System.out.println("" + CustomerId);
            System.out.println("" + CustAddrSeq);

            CusAddrVO.setWhereClause(null);
            CusAddrVO.setWhereClause("Inst_Cust_ID = " + CustomerId);
            CusAddrVO.executeQuery();
            System.out.println("CusAddrVO rows are : " +
                               CusAddrVO.getRowCount());
            Row CustomerAddrrowSelected = CusAddrVO.first();

            if (CustomerAddrrowSelected != null)
                AddrDetailseq =
                        (BigDecimal)CustomerAddrrowSelected.getAttribute("ADDRESSDTLSEQ");
            System.out.println("" + AddrDetailseq);

            DCIteratorBinding dcItteratorBindings4 =
                bindings.findIteratorBinding("AddressDetailsUVO1Iterator");
            ViewObject AddrDetailsTableData =
                dcItteratorBindings4.getViewObject();
            if (AddrDetailseq != null) {
                AddrDetailsTableData.clearCache();
                AddrDetailsTableData.setWhereClause(null);
                AddrDetailsTableData.setWhereClause("ADDRESS_DTL_SEQ = " +
                                                    AddrDetailseq);
                AddrDetailsTableData.executeQuery();


            }


        }


        return null;
    }


    public String display_Meaasge(Number msg_id) {


        ViewObjectImpl displayMessageVO = this.getMessageVO1();
        displayMessageVO.setWhereClause(null);
        displayMessageVO.setWhereClause("msg_code = " + msg_id);
        displayMessageVO.executeQuery();

        System.out.println(" display message: " +
                           displayMessageVO.getRowCount());
        System.out.println(" msg_id: " + displayMessageVO.getRowCount());
        MessageVORowImpl messageRow =
            (MessageVORowImpl)displayMessageVO.first();

        String msg = messageRow.getmsgdesc();


        return msg;

    }

    /**
     * shamshad Code - Customer Institution
     */
    //Customer Institution For New Functionality Code Starts Here.
    //It adds a new row in Customer Institution Table//

    public void doNew(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        //   System.out.println("sqlDate in doNew of Institution is : "+sqlDate);
        ViewObjectImpl addVO = this.getAddressDetailsUVO1();
        ViewObjectImpl InstVo = this.getCustomerInstitutionVO2();
        CustomerInstitutionVORowImpl row2 =
            (CustomerInstitutionVORowImpl)InstVo.createRow();
        row2.setCreatedBy(loggerName);
        row2.setCreatedDate(sqlDate);
        row2.setCityCode("DFA");
        row2.setCountryCode("ARE");

        addVO.clearCache();
        addVO.executeEmptyRowSet();

        AddressDetailsUVORowImpl row1 =
            (AddressDetailsUVORowImpl)addVO.createRow();

        if (row1 != null) {
            addVO.insertRow(row1);
            row1.setCityCode("DFA");
            row1.setCountrycode("ARE");
            row1.setCreatedBy(loggerName);
            row1.setCreatedDate(sqlDate);
        }

        InstVo.insertRow(row2);
        BigDecimal InstitutionId = row2.getINSTID();
        System.out.println("Customer institution sequence generated..." +
                           InstitutionId);
        BigDecimal aDDRESSDTLSEQ = row1.getADDRESSDTLSEQ();
        System.out.println("Address sequence generated...." + aDDRESSDTLSEQ);
        if (aDDRESSDTLSEQ != null) {
            String utiBilNum = "I" + aDDRESSDTLSEQ.toString();
            row1.setUTILBILLNUM(utiBilNum);
        }

        //           DBTransaction bTransaction = this.getDBTransaction();
        ViewObjectImpl CusAddrVO = this.getCustInstAddressVO1();
        CustInstAddressVORowImpl row3 =
            (CustInstAddressVORowImpl)CusAddrVO.createRow();
        row3.setInstCustID(InstitutionId);
        row3.setADDRESSDTLSEQ(aDDRESSDTLSEQ);
        row3.setCreatedBy(loggerName);
        row3.setCreatedDate(sqlDate);
        CusAddrVO.insertRow(row3);
        BigDecimal CustAddrSeq = row3.getCUSTINSTADDRSEQ();
        System.out.println("Mapping Cust Address Sequence generated..." +
                           CustAddrSeq);
        row2.setCUSTINSTADDRSEQ(CustAddrSeq);
    }

    //Customer Institution For New Functionality Code Ends Here//


    //Code For Edit  Functionality Starts  Here//
    // Here User can Edit the Customer Row Based On INstitution ID//

    public void doEditInstitution(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditInstitution is : " + sqlDate);
        ViewObjectImpl CusAddrVO = this.getCustInstAddressVO1();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("CustomerInstitutionVO1Iterator");
        ViewObject CusvoTableData = dcItteratorBindings.getViewObject();
        Row CustomerrowSelected = CusvoTableData.getCurrentRow();
        BigDecimal InstitutionId = null;
        if (CustomerrowSelected != null) {
            InstitutionId =
                    (BigDecimal)CustomerrowSelected.getAttribute("INSTID");
            BigDecimal CustAddrSeq = null;
            BigDecimal AddrDetailseq = null;
            DCIteratorBinding dcItteratorBindings2 =
                bindings.findIteratorBinding("CustomerInstitutionVO2Iterator");
            ViewObject Cusvo2TableData = dcItteratorBindings2.getViewObject();
            if (InstitutionId != null) {
                Cusvo2TableData.clearCache();
                Cusvo2TableData.setWhereClause(null);
                Cusvo2TableData.setWhereClause("INST_ID = " + InstitutionId);
                Cusvo2TableData.executeQuery();
                CustomerInstitutionVORowImpl custInstRow =
                    (CustomerInstitutionVORowImpl)Cusvo2TableData.first();
                if (mode.equals("edit") && custInstRow != null) {
                    custInstRow.setUpdatedby(loggerName);
                    custInstRow.setUpdatedate(sqlDate);
                }
                CustAddrSeq =
                        (BigDecimal)CustomerrowSelected.getAttribute("CUSTINSTADDRSEQ");
                System.out.println("Instituion Id in doEditInstitution is : " +
                                   InstitutionId);
                System.out.println("CustAddrSeq in doEditInstitution is : " +
                                   CustAddrSeq);
                CusAddrVO.setWhereClause(null);
                CusAddrVO.setWhereClause("CUST_INST_ADDR_SEQ = " +
                                         CustAddrSeq);
                CusAddrVO.executeQuery();
                System.out.println("CusAddrVO rows are : " +
                                   CusAddrVO.getRowCount());
                Row CustomerAddrrowSelected = CusAddrVO.first();
                if (CustomerAddrrowSelected != null)
                    AddrDetailseq =
                            (BigDecimal)CustomerAddrrowSelected.getAttribute("ADDRESSDTLSEQ");
                System.out.println("" + AddrDetailseq);

                DCIteratorBinding dcItteratorBindings4 =
                    bindings.findIteratorBinding("AddressDetailsUVO1Iterator");
                ViewObject AddrDetailsTableData =
                    dcItteratorBindings4.getViewObject();
                if (AddrDetailseq != null) {
                    AddrDetailsTableData.clearCache();
                    AddrDetailsTableData.setWhereClause(null);
                    AddrDetailsTableData.setWhereClause("ADDRESS_DTL_SEQ = " +
                                                        AddrDetailseq);
                    AddrDetailsTableData.executeQuery();
                    AddressDetailsUVORowImpl addrRow =
                        (AddressDetailsUVORowImpl)AddrDetailsTableData.first();
                    if (addrRow != null && mode.equals("edit")) {
                        addrRow.setUpdatedate(sqlDate);
                        addrRow.setUpdatedby(loggerName);
                    }
                } else {
                    AddrDetailsTableData.clearCache();
                    AddrDetailsTableData.executeEmptyRowSet();
                }
            }
        }
    }
    //Code For Edit  Functionality Ends   here//


    //Code For Submiting Institution Details starts here//
    //Here Commiting The data in Institution Table ,Address Table//

    public void doSubmitInstitution() {
        //               ViewObjectImpl addVO =this.getAddressDetailsUVO1();
        //                      ViewObjectImpl CusVo =this.getCustomerInstitutionVO2();
        //                      CustomerInstitutionVORowImpl row2 = (CustomerInstitutionVORowImpl)CusVo.getCurrentRow();
        //                       AddressDetailsUVORowImpl row1 = (AddressDetailsUVORowImpl)addVO.getCurrentRow();
        //                      String cityCode = row1.getCityCode();
        //                      String countrycode = row1.getCountrycode();
        //                      if(cityCode!=null)
        //                      {
        //                       row2.setCityCode(cityCode);
        //                      }
        //               if(countrycode!=null)
        //               {
        //                      row2.setCountryCode(countrycode);
        //               }
        getDBTransaction().commit();

    }

    //Code For Submiting Institution Details ends here//

    public void updateAddressSequence(BigDecimal addressSequence) {

        PreparedStatement preparedStatement = null;
        try {
            String sql =
                "update  sequence_mst set last_used_num=" + addressSequence +
                " where seq_name='ADDRESS_DTL_SEQ'";
            preparedStatement =
                    getDBTransaction().createPreparedStatement(sql, 0);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ViewObjectImpl CusAddrVO = this.getCustInstAddressVO1();
        CustInstAddressVORowImpl custInstMappingRow =
            (CustInstAddressVORowImpl)CusAddrVO.getCurrentRow();

        PreparedStatement preparedStatementMapping = null;
        try {
            String sqlMapping =
                "update  sequence_mst set last_used_num=" + custInstMappingRow.getCUSTINSTADDRSEQ() +
                " where seq_name='CUST_INST_ADDR_SEQ'";
            preparedStatementMapping =
                    getDBTransaction().createPreparedStatement(sqlMapping, 0);
            preparedStatementMapping.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        getDBTransaction().commit();
    }

    /*Permit Search*/

    public void PermitDetails(String CustomerId, String PermitSequence,
                              Number PlateId, String CategCode) {
        System.out.println("vehicle id" + PlateId);

        if (CategCode.equalsIgnoreCase("INDI")) {
            System.out.println("Cus Id from Bean" + CustomerId);
            ViewObjectImpl CustDetailsVO = this.getCustomerIndividualUVO1();
            CustDetailsVO.setWhereClause(null);
            CustDetailsVO.setWhereClause("Cust_ID = " + CustomerId);
            CustDetailsVO.executeQuery();
        } else {
            System.out.println("Cus Id from Bean" + CustomerId);
            ViewObjectImpl CustDetailsVO = getCustomerInstitutionVO1();
            CustDetailsVO.setWhereClause(null);
            CustDetailsVO.setWhereClause("INST_ID = " + CustomerId);
            CustDetailsVO.executeQuery();

        }
        ViewObjectImpl PermitDocumentsVO = this.getPRMDocUVO1();
        PermitDocumentsVO.setWhereClause(null);
        PermitDocumentsVO.setWhereClause("prm_header_seq = " + PermitSequence);
        PermitDocumentsVO.executeQuery();


        getPermitEventsVO1().applyViewCriteria(null);
        getPermitEventsVO1().applyViewCriteria(getPermitEventsVO1().getViewCriteria("PermitEventsVOCriteria"));
        VariableValueManager prmEvent =
            getPermitEventsVO1().ensureVariableManager();
        prmEvent.setVariableValue("BindPrmHdrSeq", PermitSequence);
        getPermitEventsVO1().executeQuery();

        getPermitPaidDetails1().applyViewCriteria(null);
        getPermitPaidDetails1().applyViewCriteria(getPermitPaidDetails1().getViewCriteria("PermitPaidDetailsCriteria"));
        VariableValueManager prmPaiddetail =
            getPermitPaidDetails1().ensureVariableManager();
        prmPaiddetail.setVariableValue("BindPrmHdrSeq", PermitSequence);
        System.out.println("PErmit  Query ::::::::::::::::::    " +
                           getPermitPaidDetails1().getQuery());
        getPermitPaidDetails1().executeQuery();

        ViewObjectImpl PermitDetailsVO = this.getPermitVehicleDetailsVO1();
        PermitDetailsVO.setWhereClause(null);
        PermitDetailsVO.setWhereClause("plate_id = " + PlateId);
        PermitDetailsVO.executeQuery();

        //        ViewObjectImpl accountEntriesRVO1 = getPermitAccountEntriesRVO1();
        getPermitAccountEntriesRVO1().applyViewCriteria(null);
        getPermitAccountEntriesRVO1().applyViewCriteria(getPermitAccountEntriesRVO1().getViewCriteria("GetByPrmHeaderSeq"));
        VariableValueManager evm9 =
            getPermitAccountEntriesRVO1().ensureVariableManager();
        evm9.setVariableValue("BindPrmHdrSeq", PermitSequence);
        getPermitAccountEntriesRVO1().executeQuery();
        System.out.println(getPermitAccountEntriesRVO1().getQuery());

        //              getPermitAccountEntries(PermitSequence);


    }


    public String loctionSearch(int locid,String date) {
               BigDecimal  seq=new BigDecimal(0);
               Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
               String s="N";
               ViewObjectImpl vo2 = (ViewObjectImpl)getAuditCardsearchVO1();
               vo2.setApplyViewCriteriaName("AuditCardsearchVOCriteria");
               vo2.setNamedWhereClauseParam("loctionid", locid);
               vo2.executeQuery();
               int count = vo2.getRowCount();
        if (count>0) {
           
            s = "Y";
            getAuditCardcountdtlsVO2().clearCache();
            getAuditCardcountdtlsVO2().executeEmptyRowSet();
            Row selectionRowN[] = vo2.getAllRowsInRange();
            Integer selectCountN = selectionRowN.length;
            Row r = getAuditHeaderVO1().getCurrentRow();
            Object ob = r.getAttribute("AuditSeq");
            if(ob!=null)
            {
            seq = (BigDecimal)ob;
            }
            RowSetIterator iterator = vo2.createRowSetIterator(null);
            iterator.reset();
            while (iterator.hasNext()) {
                Row docRow = iterator.next();
                Row auditdetailrow = getAuditCardcountdtlsVO2().createRow();
                auditdetailrow.setAttribute("Auditseq",
                                            seq.add(new BigDecimal(1)));
//                  auditdetailrow.setAttribute("Auditseq",
//                                            10);
                auditdetailrow.setAttribute("CardTypeCode",
                                            docRow.getAttribute("CardTypeCode"));
                auditdetailrow.setAttribute("Systemcount",
                                            docRow.getAttribute("totalcards"));
                auditdetailrow.setAttribute("Cardnumfrom",
                                            docRow.getAttribute("cardfrom"));
                auditdetailrow.setAttribute("CardnumTo",
                                            docRow.getAttribute("cardto"));
                auditdetailrow.setAttribute("Createdby",
                                            "cpms");
                auditdetailrow.setAttribute("createddate",sqlDate);
                
              
                
                getAuditCardcountdtlsVO2().insertRow(auditdetailrow);
                
            }

        }
        return s;
           }
    /**
     * Container's getter for AddressDetailsUVO1.
     * @return AddressDetailsUVO1
     */
    public AddressDetailsUVOImpl getAddressDetailsUVO1() {
        return (AddressDetailsUVOImpl)findViewObject("AddressDetailsUVO1");
    }

    /**
     * Container's getter for CustInstAddressVO1.
     * @return CustInstAddressVO1
     */
    public CustInstAddressVOImpl getCustInstAddressVO1() {
        return (CustInstAddressVOImpl)findViewObject("CustInstAddressVO1");
    }


    /**
     * Container's getter for DocMasterUVO1.
     * @return DocMasterUVO1
     */
    public DocMasterUVOImpl getDocMasterUVO1() {
        return (DocMasterUVOImpl)findViewObject("DocMasterUVO1");
    }


    /**
     * Container's getter for InstitutionUVO1.
     * @return InstitutionUVO1
     */
    public InstitutionUVOImpl getInstitutionUVO1() {
        return (InstitutionUVOImpl)findViewObject("InstitutionUVO1");
    }

    /**
     * Container's getter for InstitutionUVO2.
     * @return InstitutionUVO2
     */
    public InstitutionUVOImpl getInstitutionUVO2() {
        return (InstitutionUVOImpl)findViewObject("InstitutionUVO2");
    }

    /**
     * Container's getter for MessageVO1.
     * @return MessageVO1
     */
    public ViewObjectImpl getMessageVO1() {
        return (ViewObjectImpl)findViewObject("MessageVO1");
    }


    /**
     * Container's getter for PermitSectorQuotaUVO1.
     * @return PermitSectorQuotaUVO1
     */
    public ViewObjectImpl getPermitSectorQuotaUVO1() {
        return (ViewObjectImpl)findViewObject("PermitSectorQuotaUVO1");
    }


    /**
     * Container's getter for PermitCategoryVO1.
     * @return PermitCategoryVO1
     */
    public ViewObjectImpl getPermitCategoryVO1() {
        return (ViewObjectImpl)findViewObject("PermitCategoryVO1");
    }

    /**
     * Container's getter for PermitTypeVO1.
     * @return PermitTypeVO1
     */


    public void cb1_action_new_permitRules() {


    }

    public void cb4_action_submit_PermitRules() {

        getDBTransaction().commit();


    }

    // New Permit rule starts here//

    public int NewRule(String encoder) {
        Integer ruleId = null;
        java.sql.Date sqlDate =
            new java.sql.Date(new java.util.Date().getTime());
        Timestamp sqlDateTime =
            new java.sql.Timestamp(new java.util.Date().getTime());
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("PermitRuleUVO1Iterator");
        ViewObject prmRuleMstVO = dcItteratorBindings.getViewObject();
        //        PermitRuleUVORowImpl prmRuleMstRow = (PermitRuleUVORowImpl)prmRuleMstVO.last();
        /*Logic is to find out max Rule Id - As query is sorted by Rule_Id in desc. Pick the first row & increment rule_id*/
        PermitRuleUVORowImpl prmRuleMstRow =
            (PermitRuleUVORowImpl)prmRuleMstVO.first();

        if (prmRuleMstRow != null) {
            ruleId = prmRuleMstRow.getRuleId() + 1;
        } else if (prmRuleMstRow == null) {
            ruleId = 1;
        }
        System.out.println("************* New ruleId value is :" + ruleId);
        ViewObjectImpl permitRulesVO = this.getPermitRuleUVO2();

        //        row1.setRuleId(ruleId);

        if (permitRulesVO != null) {
            PermitRuleUVORowImpl row1 =
                (PermitRuleUVORowImpl)permitRulesVO.createRow();
            permitRulesVO.clearCache();
            permitRulesVO.executeQuery();
            row1.setCreatedBy(encoder);
            row1.setCreatedDate(sqlDate);
            permitRulesVO.insertRow(row1);
        }

        ViewObjectImpl PermitSectorVO = this.getRuleMaxQuotaVO1();
        RuleMaxQuotaVORowImpl row2 =
            (RuleMaxQuotaVORowImpl)PermitSectorVO.createRow();
        PermitSectorVO.executeEmptyRowSet();
        row2.setCreatedBy(encoder);
        row2.setCreatedDate(sqlDateTime);
        PermitSectorVO.insertRow(row2);

        ViewObjectImpl permitChargesVO = this.getPermitChargesVO1();
        PermitChargesVORowImpl row3 =
            (PermitChargesVORowImpl)permitChargesVO.createRow();
        permitChargesVO.executeEmptyRowSet();
        row3.setCreatedBy(encoder);
        row3.setCreatedDate(sqlDateTime);
        permitChargesVO.insertRow(row3);

        ViewObjectImpl prmQuotaVO = getRuleMaxQuotaVO1();
        RuleMaxQuotaVORowImpl prmQuotaRow =
            (RuleMaxQuotaVORowImpl)prmQuotaVO.getCurrentRow();
        ViewObjectImpl prmChargesVO = getPermitChargesVO1();
        PermitChargesVORowImpl prmChargesVORow =
            (PermitChargesVORowImpl)prmChargesVO.getCurrentRow();
        if (prmQuotaRow != null && ruleId != null) {
            prmQuotaRow.setRuleId(ruleId);

            System.out.println("Rule id in Rule quota on NEW is : " +
                               prmQuotaRow.getRuleId());
        }
        if (prmChargesVORow != null && ruleId != null) {
            prmChargesVORow.setRuleId(ruleId);

            System.out.println("Rule id in Rule charges on NEW is : " +
                               prmChargesVORow.getRuleId());
        }
        return ruleId;
    }

    // New Permit rule Ends here//

    public void doNewLoc(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNew of Location is : " + sqlDate);
        ViewObjectImpl locVo = this.getLocationMstVO2();
        LocationMstVORowImpl rowLoc1 = (LocationMstVORowImpl)locVo.createRow();
        rowLoc1.setCreatedBy(loggerName);
        rowLoc1.setCreatedDate(sqlDate);
        locVo.insertRow(rowLoc1);
    }

    public void doNewVehicleBlack(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNew of Location is : " + sqlDate);
        ViewObjectImpl blackvo = this.getVehicleBlaclListMstUVO2();
        VehicleBlaclListMstUVORowImpl Blackrow = (VehicleBlaclListMstUVORowImpl)blackvo.createRow();
        Blackrow.setCreatedBy(loggerName);
        Blackrow.setCreatedDate(sqlDate);
        blackvo.insertRow(Blackrow);
    }
    public void doEditVehicleBlack(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditLoc is : " + sqlDate);

        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("VehicleBlaclListMstUVO1Iterator");
        ViewObject BlackListvo = dcItteratorBindings.getViewObject();
        Row BlackrowSelected = BlackListvo.getCurrentRow();
            BigDecimal blacklistId = null;
            if (BlackrowSelected != null) {
                blacklistId =
                        (BigDecimal)BlackrowSelected.getAttribute("Blacklistseq");
                System.out.println("whitelistId in doEditWhitelist is : " +
                                   blacklistId);
            }

            ViewObjectImpl BlacklistMstVO2 = this.getVehicleBlaclListMstUVO2();
           
            if (blacklistId != null) {
                BlacklistMstVO2.clearCache();
                BlacklistMstVO2.setWhereClause(null);
                BlacklistMstVO2.setWhereClause("Blacklist_seq = " + blacklistId);
                BlacklistMstVO2.executeQuery();
                VehicleBlaclListMstUVORowImpl blacklistMstRow =
                    (VehicleBlaclListMstUVORowImpl)BlacklistMstVO2.first();
                if (mode.equals("edit") && blacklistMstRow != null) {
                    blacklistMstRow.setUpdatedby(loggerName);
                    blacklistMstRow.setupdateddate(sqlDate);
                }

            }
        }

    public void doSearchPermitpvt(String modetype,String hdrseq){
        
        if(modetype!=null){
               
        if(modetype.equals("PRM")){
          ViewObjectImpl prmSearch = getPermitSearchCriteriaVO1();
    //          prmSearch.setWhereClauseParams(null);
    //            prmSearch.setWhereClause("Permit_Number = '"+hdrseq+"'");
            prmSearch.applyViewCriteria(null);
            prmSearch.applyViewCriteria(prmSearch.getViewCriteria("PermitSearchCritVOCriteria"));
            VariableValueManager evm = prmSearch.ensureVariableManager();
            evm.setVariableValue("permi_number", hdrseq);           
            prmSearch.executeQuery();
            long a = prmSearch.getEstimatedRowCount();
            System.out.println(a);
            
        }
        }
        
    }










       
    
    

    public void doEditLoc(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditLoc is : " + sqlDate);

        //                ViewObjectImpl locMstVO =this.getLocationMstVO1();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("LocationMstVO1Iterator");
        ViewObject locvoTableData = dcItteratorBindings.getViewObject();
        Row locrowSelected = locvoTableData.getCurrentRow();
        Integer locationId = null;
       java.sql.Timestamp golivedate = null;
        if (locrowSelected != null) {
            locationId = (Integer)locrowSelected.getAttribute("LocationID");
            golivedate = (java.sql.Timestamp)locrowSelected.getAttribute("GoLiveDt");
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("GOLiveDate",golivedate);
            System.out.println("locationId in doEditLoc is : " + locationId);
        }

        DCIteratorBinding dcItteratorBindings2 =
            bindings.findIteratorBinding("LocationMstVO2Iterator");
        ViewObject locvo2TableData = dcItteratorBindings2.getViewObject();
        if (locationId != null) {
            locvo2TableData.clearCache();
            locvo2TableData.setWhereClause(null);
            locvo2TableData.setWhereClause("Location_ID = " + locationId);
            locvo2TableData.executeQuery();
            LocationMstVORowImpl locMstRow =
                (LocationMstVORowImpl)locvo2TableData.first();
            if (mode.equals("edit") && locMstRow != null) {
                System.out.println("locMstRow" + locMstRow.getLocDesc());
                locMstRow.setUpdatedBy(loggerName);
                locMstRow.setUpdatedDate(sqlDate);
            }

        }
    }


    //Inserting records in Gen_pound_bay_detail based on Location Type and based on number(GEN_LOCATION_MST)

    public void doAddBayDetail(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditLoc is : " + sqlDate);
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("LocationMstVO1Iterator");
        ViewObject locvoTableData = dcItteratorBindings.getViewObject();
        locvoTableData.executeQuery();

        //Getting Newly inserted values
        LocationMstVORowImpl locMstRow =
            (LocationMstVORowImpl)locvoTableData.first();
        Integer loc_id = locMstRow.getLocationID();
        System.out.println("loc_id:" + loc_id);
        Integer bayCount = locMstRow.getBayCount();
        String locationType = locMstRow.getLOCTYPE();
        //                    BigDecimal pvtHdrSeq ;

        //Getting PoundBayDetailVO1 object from Transaction DataControl


        PoundBayDetailVOImpl poundImpl =
            (PoundBayDetailVOImpl)this.getPoundBayDetailVO1();
        poundImpl.clearCache();
        poundImpl.executeEmptyRowSet();
        //Inserting Pound Location type records based on Bay count

        if (locationType != null && locationType.equals("PND") &&
            bayCount > 0) {
            for (int i = 1; i <= bayCount; i++) {
                PoundBayDetailVORowImpl rowBayImpl =
                    (PoundBayDetailVORowImpl)poundImpl.createRow();
                rowBayImpl.setCreatedBy(loggerName);
                rowBayImpl.setCreatedDate(sqlDate);
                rowBayImpl.setBaynum(i);
                System.out.println("bayNum:::" + rowBayImpl.getBaynum());
                rowBayImpl.setPOUNDLocationID(loc_id);
                rowBayImpl.setBaystatus("A"); //Assigning Available status
                //rowBay1.setPVTHDRSEQ(new BigDecimal(100));//Need to remove this line after changing this value nullable No to Yes
                poundImpl.insertRow(rowBayImpl);
            }
        }
    }

    public int bayStatusForLocation() {
        int count = -1;
        LocationMstVOImpl locRow = getLocationMstVO2();
        LocationMstVORowImpl locIdRow = (LocationMstVORowImpl)locRow.first();
        Integer locId = locIdRow.getLocationID();
        System.out.println("locId" + locId);
        String locType = locIdRow.getLOCTYPE();
        System.out.println("locType" + locType);
        //Getting Available Status bay count from BayNumberLVO
        if ("PND".equals(locType) && locId != null) {
            BayNumberLVOImpl bayLvo = getBayNumberLVO1();
            ViewCriteria vc = bayLvo.getViewCriteria("BayNumberLVOCriteria");
            vc.resetCriteria();
            bayLvo.setpoundId(locId);
            bayLvo.applyViewCriteria(vc);
            bayLvo.executeQuery();
            count = bayLvo.getRowCount();
            System.out.println("count- bayStatusForLocation:" + count);
        }
        return count;
    }

    //Removal Truck Masters New ,Edit and View functionalities

    public void doNewTruck(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNew of Truck is : " + sqlDate);
        ViewObjectImpl truckVo = this.getRemovalTruckMstVO2();
        RemovalTruckMstVORowImpl rowTruck1 =
            (RemovalTruckMstVORowImpl)truckVo.createRow();
        rowTruck1.setDEFCountrycode("ARE");
        rowTruck1.setVHCLASSIGNSTATUS(1);
        rowTruck1.setCreatedBy(loggerName);
        rowTruck1.setCreatedDate(sqlDate);
        truckVo.insertRow(rowTruck1);
    }

    public void doEditTruck(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditTruck is : " + sqlDate);

        //                    ViewObjectImpl truckMstVO =this.getRemovalTruckMstVO1();
        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("RemovalTruckMstVO1Iterator");
        ViewObject truckvoTableData = dcItteratorBindings.getViewObject();
        Row truckRowSelected = truckvoTableData.getCurrentRow();
        BigDecimal truckId = null;
        if (truckRowSelected != null) {
            truckId =
                    (BigDecimal)truckRowSelected.getAttribute("ENFORCEVHCLID");
            System.out.println("truckId in doEditTruck is : " + truckId);
        }

        DCIteratorBinding dcItteratorBindings2 =
            bindings.findIteratorBinding("RemovalTruckMstVO2Iterator");
        ViewObject truckvo2TableData = dcItteratorBindings2.getViewObject();
        if (truckId != null) {
            truckvo2TableData.clearCache();
            truckvo2TableData.setWhereClause(null);
            truckvo2TableData.setWhereClause("ENFORCE_VHCL_ID = " + truckId);
            truckvo2TableData.executeQuery();
            RemovalTruckMstVORowImpl truckMstRow =
                (RemovalTruckMstVORowImpl)truckvo2TableData.first();
            if (mode.equals("edit") && truckMstRow != null) {
                truckMstRow.setUpdatedby(loggerName);
                truckMstRow.setUpdateddate(sqlDate);
            }

        }
    }

    //Vehicle Whitelist Masters New ,Edit and View functionalities

    public void doNewWhitelist(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNewWhitelist is : " + sqlDate);
        ViewObjectImpl whitelistVo = this.getVehicleWhitelistMstVO2();
        VehicleWhitelistMstVORowImpl whitelistRow =
            (VehicleWhitelistMstVORowImpl)whitelistVo.createRow();
        whitelistRow.setPlateid(new BigDecimal(1));
        whitelistRow.setCreatedBy(loggerName);
        whitelistRow.setCreatedDate(sqlDate);
        whitelistVo.insertRow(whitelistRow);
    }
    public void doNewBlacklist(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNewBlacklist is : " + sqlDate);
        ViewObjectImpl blacklistVo = this.getVehicleBlacklistMstVO2();
        VehicleBlacklistMstVORowImpl blacklistRow =
            (VehicleBlacklistMstVORowImpl)blacklistVo.createRow();
        blacklistRow.setPlateid(new BigDecimal(1));
        blacklistRow.setCreatedBy(loggerName);
        blacklistRow.setCreatedDate(sqlDate);
        blacklistVo.insertRow(blacklistRow);
    }

    public void doEditBlacklist(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditBlacklist is : " + sqlDate);

        ViewObjectImpl blacklistMstVO = this.getVehicleBlacklistMstVO1();
        //                    DCBindingContainer bindings =
        //                                  (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //                    DCIteratorBinding dcItteratorBindings =
        //                         bindings.findIteratorBinding("VehicleWhitelistMstVO1Iterator");
        //                    ViewObject truckvoTableData = dcItteratorBindings.getViewObject();
        Row blacklistRowSelected = blacklistMstVO.getCurrentRow();
        BigDecimal blacklistId = null;
        if (blacklistRowSelected != null) {
            blacklistId =
                    (BigDecimal)blacklistRowSelected.getAttribute("Blacklistseq");
            System.out.println("blacklistId in doEditBlacklist is : " +
                               blacklistId);
        }

        ViewObjectImpl blacklistMstVO2 = this.getVehicleBlacklistMstVO2();
        //ViewObject truckvo2TableData = dcItteratorBindings2.getViewObject();
        if (blacklistId != null) {
            blacklistMstVO2.clearCache();
            blacklistMstVO2.setWhereClause(null);
            blacklistMstVO2.setWhereClause("Blacklist_seq = " + blacklistId);
            blacklistMstVO2.executeQuery();
            VehicleBlacklistMstVORowImpl blacklistMstRow =
                (VehicleBlacklistMstVORowImpl)blacklistMstVO2.first();
            if (mode.equals("edit") && blacklistMstRow != null) {
                blacklistMstRow.setUpdatedby(loggerName);
                blacklistMstRow.setupdateddate(sqlDate);
            }

        }
    }
    public void doEditWhitelist(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditWhitelist is : " + sqlDate);

        ViewObjectImpl whitelistMstVO = this.getVehicleWhitelistMstVO1();
        //                    DCBindingContainer bindings =
        //                                  (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //                    DCIteratorBinding dcItteratorBindings =
        //                         bindings.findIteratorBinding("VehicleWhitelistMstVO1Iterator");
        //                    ViewObject truckvoTableData = dcItteratorBindings.getViewObject();
        Row whitelistRowSelected = whitelistMstVO.getCurrentRow();
        BigDecimal whitelistId = null;
        if (whitelistRowSelected != null) {
            whitelistId =
                    (BigDecimal)whitelistRowSelected.getAttribute("Whitelistseq");
            System.out.println("whitelistId in doEditWhitelist is : " +
                               whitelistId);
        }

        ViewObjectImpl whitelistMstVO2 = this.getVehicleWhitelistMstVO2();
        //ViewObject truckvo2TableData = dcItteratorBindings2.getViewObject();
        if (whitelistId != null) {
            whitelistMstVO2.clearCache();
            whitelistMstVO2.setWhereClause(null);
            whitelistMstVO2.setWhereClause("Whitelist_seq = " + whitelistId);
            whitelistMstVO2.executeQuery();
            VehicleWhitelistMstVORowImpl whitelistMstRow =
                (VehicleWhitelistMstVORowImpl)whitelistMstVO2.first();
            if (mode.equals("edit") && whitelistMstRow != null) {
                whitelistMstRow.setUpdatedby(loggerName);
                whitelistMstRow.setupdateddate(sqlDate);
            }

        }
    }

    //Account Masters New ,Edit and View functionalities

    public void doNewAccnt(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNew of Account is : " + sqlDate);
        ViewObjectImpl accntVo = this.getAccountMstVO2();
        AccountMstVORowImpl rowAccnt1 =
            (AccountMstVORowImpl)accntVo.createRow();
        rowAccnt1.setCreatedBy(loggerName);
        rowAccnt1.setCreatedDate(sqlDate);
        accntVo.insertRow(rowAccnt1);
    }
    
    
    public void donewInventoryThreshold(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNew of Account is : " + sqlDate);
        ViewObjectImpl stockVO = this.getInvStockReorderLevelDetailsVO2(); 
        InvStockReorderLevelDetailsVORowImpl InvStockReorderLevelDetailsRow =(InvStockReorderLevelDetailsVORowImpl)stockVO.createRow();
        InvStockReorderLevelDetailsRow.setCreatedBy(loggerName);
        InvStockReorderLevelDetailsRow.setCreatedDate(sqlDate);
        stockVO.insertRow(InvStockReorderLevelDetailsRow);
       
    }
    
    
    public String doEditAccnt(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditAccnt is : " + sqlDate);
        String accountCode = null;
        ViewObjectImpl truckMstVO = this.getAccountMstVO1();
        //                    DCBindingContainer bindings =
        //                                  (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //                    DCIteratorBinding dcItteratorBindings =
        //                         bindings.findIteratorBinding("RemovalTruckMstVO1Iterator");
        ViewObject accntvoTableData = (ViewObject)truckMstVO;
        //ViewObject truckvoTableData = dcItteratorBindings.getViewObject();
        Row truckRowSelected = accntvoTableData.getCurrentRow();
        BigDecimal accntSeqId = null;
        if (truckRowSelected != null) {
            accntSeqId =
                    (BigDecimal)truckRowSelected.getAttribute("accmstseq");
            System.out.println("accntSeqId in doEditAccnt is : " + accntSeqId);
        }

        //                    DCIteratorBinding dcItteratorBindings2 =
        //                    bindings.findIteratorBinding("RemovalTruckMstVO2Iterator");
        //                    ViewObject truckvo2TableData = dcItteratorBindings2.getViewObject();
        ViewObjectImpl truckMstVO2 = this.getAccountMstVO2();
        ViewObject accntvo2TableData = (ViewObject)truckMstVO2;
        if (accntSeqId != null) {
            accntvo2TableData.clearCache();
            accntvo2TableData.setWhereClause(null);
            accntvo2TableData.setWhereClause("acc_mst_seq = " + accntSeqId);
            accntvo2TableData.executeQuery();
            AccountMstVORowImpl accntMstRow =
                (AccountMstVORowImpl)accntvo2TableData.first();
            accountCode = (String)accntMstRow.getAttribute("acccode");
            if (mode.equals("edit") && accntMstRow != null) {
                accntMstRow.setUpdatedby(loggerName);
                accntMstRow.setUpdateddate(sqlDate);
            }

        }
        return accountCode;
    }


    public void goLiveDateProcdure(String sectorCode) {
        {
            CallableStatement stmt = null;
            try {
                System.out.println("goLiveDateProcdure  ::::::::: sectorCode   :::::::::" +
                                   sectorCode);
                stmt =
getDBTransaction().createCallableStatement("{call  PRM_GoLive_Date_Update (?) }",
                                           0);
                stmt.setString(1, sectorCode);
                boolean returnValue = stmt.execute();
                System.out.println("PRM_GoLive_Date_Update  :::::::::::::           " +
                                   returnValue);

            } catch (Exception e) {
                System.out.println("PRM_GoLive_Date_Update procedure exception : " +
                                   e.getMessage());
            }


        }
    }
    
    public String doEditINVStockReorderLevelDetails(String loggerName, String mode) {
        Timestamp sqlDate =new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditAccnt is : " + sqlDate);
        String accountCode = null;
        ViewObjectImpl InventoryThresholdVO = this.getInvStockReorderLevelDetailsVO1();
        ViewObject InventoryThresholdtabledate = (ViewObject)InventoryThresholdVO;
        Row SelectedRow = InventoryThresholdtabledate.getCurrentRow();
        BigDecimal SeqId = null;
        if (SelectedRow != null) {
            SeqId =
                    (BigDecimal)SelectedRow.getAttribute("stockReorderSeq");
            System.out.println("accntSeqId in doEditAccnt is : " + SeqId);
        }

        //                    DCIteratorBinding dcItteratorBindings2 =
        //                    bindings.findIteratorBinding("RemovalTruckMstVO2Iterator");
        //                    ViewObject truckvo2TableData = dcItteratorBindings2.getViewObject();
        ViewObjectImpl InventoryThresholdVO2 = this.getInvStockReorderLevelDetailsVO2();
        ViewObject InventoryThresholdtabledate2 = (ViewObject)InventoryThresholdVO2;
        if (SeqId != null) {
            InventoryThresholdtabledate2.clearCache();
            InventoryThresholdtabledate2.setWhereClause(null);
            InventoryThresholdtabledate2.setWhereClause("stock_Reorder_Seq = " + SeqId);
            InventoryThresholdtabledate2.executeQuery();
            InvStockReorderLevelDetailsVORowImpl MstRow =
                (InvStockReorderLevelDetailsVORowImpl)InventoryThresholdtabledate2.first();
           
            if (mode.equals("edit") && MstRow != null) {
                MstRow.setUpdatedby(loggerName);
                MstRow.setUpdateddate(sqlDate);
            }

        }
        return "";
    }

    
    
    
    
    


    public void doNewRolesMenuMst(String loggerName) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("doViewRolesMenuMst : " + sqlDate);
        ViewObjectImpl genRole = this.getGenRoleUVO2();
        genRole.clearCache();
        GenRoleUVORowImpl genRoleRowImpl =
            (GenRoleUVORowImpl)genRole.createRow();
        genRoleRowImpl.setCreatedBy(loggerName);
        genRoleRowImpl.setCreatedDate(sqlDate);
        genRole.insertRow(genRoleRowImpl);
    }


    public void doEditRolesMenuMst(String loggerName, String mode) {
        Timestamp sqlDate =
            new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditRolesMenuMst is : " + sqlDate);

        DCBindingContainer bindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
            bindings.findIteratorBinding("GenRoleUVO1Iterator");
        ViewObject genRoleVO = dcItteratorBindings.getViewObject();
        Row seletedGenRoleRow = genRoleVO.getCurrentRow();
        BigDecimal roleId = null;
        if (seletedGenRoleRow != null) {
            roleId = (BigDecimal)seletedGenRoleRow.getAttribute("RoleID");
            System.out.println("Role ID in doEditRolesMenuMst is : " + roleId);
        }

        DCIteratorBinding dcItteratorBindings2 =
            bindings.findIteratorBinding("GenRoleUVO2Iterator");
        ViewObject genRolesFormData = dcItteratorBindings2.getViewObject();
        if (roleId != null) {
            genRolesFormData.clearCache();
            genRolesFormData.setWhereClause(null);
            genRolesFormData.setWhereClause("ROLE_ID = " + roleId);
            genRolesFormData.executeQuery();
            GenRoleUVORowImpl genRoleRow =
                (GenRoleUVORowImpl)genRolesFormData.first();
            if (mode.equals("edit") && genRoleRow != null) {
                genRoleRow.setUpdatedby(loggerName);
                genRoleRow.setUpdatedate(sqlDate);
            }
        }
    }


    private void getPermitAccountEntries(String prmHDRSeq) {

        String finalQuery = null;
        PermitAccountEntriesRVOImpl permitAccountVO =
            this.getPermitAccountEntriesRVO1();
        String queryBase = permitAccountVO.getQuery();
        System.out.println("queryBase      " + queryBase);
        String whereQuery =
            " where a.Sale_hdr_seq = c.Sale_hdr_seq  and c.prm_header_seq = " +
            prmHDRSeq + " and b.acc_code = a.acc_code Order by a.acc_seq ";
        finalQuery = queryBase + whereQuery;
        System.out.println("finalQuery      :::::::::                  " +
                           finalQuery);
        permitAccountVO.setQuery(finalQuery);
        permitAccountVO.executeQuery();
        permitAccountVO.setQuery(queryBase);
        System.out.println("after Reset     :::::::::                  " +
                           permitAccountVO.getQuery());

    }
    
    public String courtFileUploadMethod(UploadedFile uploadFile,String pvtNumber,String hdrseq) {
//        // Add event code here...
        String validation = "success";
//        String uploadPath =  null;
//        String fullPath=null;
//        FileUpload fl = new FileUpload();
//      //  BigDecimal  pvtHDRSeq = getPVTHDRSeqNumber();
////        RichInputFile inputFileComponent = (RichInputFile)valueChangeEvent.getComponent();
////                  // UploadedFile newFile = (UploadedFile)valueChangeEvent.getNewValue();
////                   inputFileComponent.getClientId(FacesContext.getCurrentInstance());
//        
//        BindingContext bindingctx = BindingContext.getCurrent();
//        BindingContainer binding = bindingctx.getCurrentBindingsEntry();
//        DCBindingContainer bindingsImpl = (DCBindingContainer)binding;
//        
//        //Code for testing
//        DCIteratorBinding dciterrefundattchmt =
//            bindingsImpl.findIteratorBinding("PVTDocsVO1Iterator");
//        ViewObject voattchmttrans = dciterrefundattchmt.getViewObject();
//        voattchmttrans.executeEmptyRowSet();
//      //  currentAttchmtRow =dciterrefundattchmt.getRowAtRangeIndex(getDocTable().getRowIndex());
//    ViewObject pvtDocs = getPVTDocsVO1();
//    Row currentAttchmtRow = pvtDocs.createRow();
//   //      if(null != valueChangeEvent.getNewValue()){
////            UploadedFile uploadFile =  (UploadedFile)valueChangeEvent.getNewValue();
//            String pvtNumb = pvtNumber;
//             if(uploadFile!=null)
//             {
//             uploadPath = fl.uploadFilesToFolder("1", "PVT", pvtNumb, uploadFile);
//             if(uploadPath!=null) {
//                 fullPath = uploadPath+"//"+ uploadFile.getFilename();
//             }
//             String docFielName = uploadFile.getFilename();
//             java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//             System.out.println("sqlDate in uploadPvtDocs is : "+sqlDate);
//             int documentStage=7;
//             int docType = getFileExtension(docFielName);
//             //String userName = httpSession.getAttribute("loggedinUserid").toString();
//             String userName="Sathya";
//             currentAttchmtRow.setAttribute("CreatedBy",userName);
//             currentAttchmtRow.setAttribute("CreatedDate",sqlDate);
//             currentAttchmtRow.setAttribute("filepath",fullPath);
//             currentAttchmtRow.setAttribute("Docstage",documentStage);
//             currentAttchmtRow.setAttribute("PVTHDRSEQ", hdrseq);
//             currentAttchmtRow.setAttribute("deleteflag","N");
//             currentAttchmtRow.setAttribute("doctype",docType);
//             
//            System.out.println("CreatedBy ::::::::::::::"+currentAttchmtRow.getAttribute("CreatedBy"));
//            System.out.println("CreatedDate ::::::::::::::"+currentAttchmtRow.getAttribute("CreatedDate"));
//            System.out.println("filepath ::::::::::::::"+currentAttchmtRow.getAttribute("filepath"));
//            System.out.println("filepath ::::::::::::::"+currentAttchmtRow.getAttribute("CreatedBy"));
//            System.out.println("Docstage ::::::::::::::"+currentAttchmtRow.getAttribute("Docstage"));
//            System.out.println("PVTHDRSEQ ::::::::::::::"+currentAttchmtRow.getAttribute("PVTHDRSEQ"));  
//            System.out.println("doctype ::::::::::::::"+currentAttchmtRow.getAttribute("doctype")); 
//
//             }else {
//             return "fail";
//             }
        
     //    }     

        return validation;
    }
    
    
    public void emptyRowSet() {
        ViewObjectImpl except=(ViewObjectImpl)getPVTExceptionzoneVO1();
        except.executeEmptyRowSet(); 
        //AdfFacesContext.getCurrentInstance().getPageFlowScope().put("Mode",true);
        
    }
    
    public void doNewVehicleCountry(String loggerName) {
        Timestamp sqlDate =new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doNew of Account is : " + sqlDate);
        ViewObjectImpl countryVO = this.getVehicleCountrymstVO2();
        VehicleCountrymstVORowImpl VehicleCountryRow=(VehicleCountrymstVORowImpl)countryVO.createRow();
        VehicleCountryRow.setCreatedBy(loggerName);
        VehicleCountryRow.setCreatedDate(sqlDate);
        VehicleCountryRow.setCountrycode("ARE");
        countryVO.insertRow(VehicleCountryRow);
        ViewObjectImpl countryVO1 = this.getVehicleCountrymstVO1();
        VehicleCountrymstVORowImpl VehicleCountryRow1=(VehicleCountrymstVORowImpl)countryVO1.first();
        Object ob=VehicleCountryRow1.getPlateCountryID();
        if(ob!=null)
        {
         int id=Integer.parseInt(ob.toString());  
        ViewObjectImpl countrylngVO = this.getVehicleCountrymstlngVO1();
        VehicleCountrymstlngVORowImpl VehicleCountrylngRow=(VehicleCountrymstlngVORowImpl)countrylngVO.createRow();
        VehicleCountrylngRow.setCreatedBy(loggerName);
        VehicleCountrylngRow.setCreatedDate(sqlDate);
        countrylngVO.insertRow(VehicleCountrylngRow);
        }
    }
    
    public String doEditVehicleCountry(String loggerName, String mode) {
        Timestamp sqlDate =new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("sqlDate in doEditAccnt is : " + sqlDate);
        String accountCode = null;
        ViewObjectImpl countryVO = this.getVehicleCountrymstVO1();
        ViewObject countryVO1 = (ViewObject)countryVO;
        Row SelectedRow = countryVO1.getCurrentRow();
        int SeqId =1;
        if (SelectedRow != null) {
            SeqId =Integer.parseInt(SelectedRow.getAttribute("PlateCountryID").toString());
            System.out.println("accntSeqId in doEditAccnt is : " + SeqId);
        }
        ViewObjectImpl countryVO2 = this.getVehicleCountrymstVO2();
        ViewObject countryVO12 = (ViewObject)countryVO2;
        if (SeqId != 0) {
            countryVO12.clearCache();
            countryVO12.setWhereClause(null);
            countryVO12.setWhereClause("Plate_Country_ID=" + SeqId);
            countryVO12.executeQuery();
            VehicleCountrymstVORowImpl MstRow =(VehicleCountrymstVORowImpl)countryVO12.first();
           
            if (mode.equals("edit") && MstRow != null) {
                MstRow.setUpdatedBy(loggerName);
                MstRow.setUpdatedDate(sqlDate);
            }

        }
        return "";
    }
    
    public void resetPvtWriteOff(){
      PVTWRITEOFFHEADERVOImpl pvtWriteOffHeaderVO=(PVTWRITEOFFHEADERVOImpl)getPVTWRITEOFFHEADERVO1();
      pvtWriteOffHeaderVO.clearCache();
      pvtWriteOffHeaderVO.setWhereClause(null);
      pvtWriteOffHeaderVO.executeQuery();
      
    }
    
    public String getPvtWriteOffDetails(BigDecimal pvtWriteOffHeaderseq){
        
      PVTWRITEOFFDETAILSVOImpl pvtWriteOffDetailsVO=(PVTWRITEOFFDETAILSVOImpl) this.getPVTWRITEOFFDETAILSVO1();
         ViewCriteriaManager vcm=pvtWriteOffDetailsVO.getViewCriteriaManager();
         ViewCriteria vc =vcm.getViewCriteria("PVTWRITEOFFDETAILSVOCriteria");
         pvtWriteOffDetailsVO.setbindPvtheaderseq(pvtWriteOffHeaderseq);
         pvtWriteOffDetailsVO.appendViewCriteria(vc);
         pvtWriteOffDetailsVO.executeQuery();
         System.out.println(pvtWriteOffDetailsVO.getQuery());
         long count=pvtWriteOffDetailsVO.getEstimatedRowCount();
         System.out.println("row count is::::"+count);
         if(count!=0){
             return "Y";
         }
         else
             return "N";
     
    }
    
    /* on submit action*/
    public BigDecimal getPvtWriteOffHeaderSeq() {
       // ViewObjectImpl pvtHeaderSeqVO = getPVTDiscountHeaderSeqVO1();
       ViewObjectImpl pvtWriteOffHeaderVO = (ViewObjectImpl) getPVTWRITEOFFHEADERVO1();
        pvtWriteOffHeaderVO.executeQuery();
        
        Row lastSeqHeaderRow = pvtWriteOffHeaderVO.last();
        BigDecimal PvtHeaderSeq =(BigDecimal)lastSeqHeaderRow.getAttribute("WRITEOFFHDRSeq");
        
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update PVT_WRITEOFF_PVT_DETAILS set WRITEOFF_HDR_Seq="+ PvtHeaderSeq +" where WRITEOFF_HDR_Seq=1";
            preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
            preparedStatement.executeUpdate();
            System.out.println("Sequence updated in detail table...");
        }  catch (Exception e) {
            e.printStackTrace();
        }
        getDBTransaction().commit();
        
        return PvtHeaderSeq;
    }
    
    public BigDecimal getPvtCount(BigDecimal pvtcount,BigDecimal hdrseq)  {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update PVT_WRITEOFF_HEADER set PVT_COUNT="+ pvtcount +" where WRITEOFF_HDR_Seq="+hdrseq;
            preparedStatement = getDBTransaction().createPreparedStatement(sql, 0);
            preparedStatement.executeUpdate();
            System.out.println("Pvt Count is updated in Header table...");
        }  catch (Exception e) {
            e.printStackTrace();
        }
       this.getDBTransaction().commit();

        return null;
    }
    
    
    public void updatePvtWriteOff(int reqstatus,int pvtWriteOffHeaderseq,String username) 
    {
   
    
    CallableStatement stmt = null;
            try {
                stmt = getDBTransaction().createCallableStatement("{call PVT_WriteOff_update(?,?,?)}", 0);
                stmt.setInt(1, reqstatus); 
                stmt.setInt(2, pvtWriteOffHeaderseq);
                stmt.setString(3, username);
                stmt.execute();      
                 getDBTransaction().commit();
                  }  catch (Exception e) {
                            e.printStackTrace();
                   }
    }
    
    
    
    
    
    
/*     public String savePvtWriteOffDetails(Date pvtWriteOffInitiationDate,Integer totalNosPVTs,String status,String createdBy)
    {
        this.getDBTransaction().commit();
        ViewObjectImpl pvtWriteOffHeaderVO = (ViewObjectImpl) getPVTWRITEOFFHEADERVO1();
       // ViewObjectImpl pvtAuctionHeaderVO = (ViewObjectImpl)getPVTAUCTIONHeaderVO1();
       // Row rowHeader = pvtWriteOffHeaderVO.getCurrentRow();
//        rowHeader.setAttribute("WRITEOFFREQDATE",pvtWriteOffInitiationDate);
//        rowHeader.setAttribute("PVTCOUNT",totalNosPVTs);
//        rowHeader.setAttribute("WRITEOFFREQSTATUS",status);
//        rowHeader.setAttribute("CreatedBy", createdBy);
//        rowHeader.setAttribute("CreatedDate", pvtWriteOffInitiationDate);
        //rowHeader.setAttribute("PLATECNTID",PLATECNTID);
        //rowHeader.setAttribute("PLATECTGID",PLATECTGID);
        //rowHeader.setAttribute("PLATENUMBER",PLATENUMBER);
        //rowHeader.setAttribute("PLATETYPEID",PLATETYPEID);
        //rowHeader.setAttribute("PVTdatefrom",PVTdatefrom);
        //rowHeader.setAttribute("PVTdateto",PVTdateto);
        //rowHeader.setAttribute("SectorCode",SectorCode);
        //rowHeader.setAttribute("zonecode",zonecode);
       // pvtWriteOffHeaderVO.insertRow(rowHeader);
        System.out.println("WriteOff Hearder Count ::"+pvtWriteOffHeaderVO.getRowCount());
        long count = pvtWriteOffHeaderVO.getEstimatedRowCount();
            System.out.println("WriteOff Hearder TotalPVTCount ::"+pvtWriteOffHeaderVO.getCurrentRow().getAttribute("PVTCOUNT"));                                                                                    
       // this.getDBTransaction().commit();
        pvtWriteOffHeaderVO.executeQuery();
        //pvtAuctionHeaderVO.setCurrentRow(row);
        //pvtAuctionHeaderVO.setOrderByClause("ASC");
       // System.out.println("pvtAuctionHeaderVO row Count ::"+pvtAuctionHeaderVO.getRowCount());
       // System.out.println("Auction Hearder Seq ::"+pvtAuctionHeaderVO.getRowAtRangeIndex(pvtAuctionHeaderVO.getRowCount()-1).getAttribute("AUCTIONHeaderseq"));
        BigDecimal newWriteOffHeaderSeq = (BigDecimal)pvtWriteOffHeaderVO.first().getAttribute("WRITEOFFHDRSeq");
        System.out.println("Auction Hearder newAuctionHeaderSeq ::"+newWriteOffHeaderSeq);
         ViewObjectImpl pvtWriteOffDetailsVO = (ViewObjectImpl)getPVTWRITEOFFDETAILSVO1();
         
        //ViewObjectImpl pvtAuctionPvtDetailsVO = (ViewObjectImpl)getPVTAUCTIONPVTDETAILSVO1();
       ViewObjectImpl pvtWriteOffSearchVO = (ViewObjectImpl) getPvtSearchWriteOffRVO1();
       
        //ViewObjectImpl pvtAuctionPvtSearch = (ViewObjectImpl)getPVTAuctionSearchVO1();  
        
//         Row selectionRow[] = pvtWriteOffSearchVO.getFilteredRows("SelectFlag",true);
//         Integer selectCount = selectionRow.length;
//         for(int i=0;selectCount > i;i++){
//            Row rowDetails = pvtWriteOffDetailsVO.createRow();
//            rowDetails.setAttribute("WRITEOFFHDRSeq",newWriteOffHeaderSeq);
             
            //rowDetails.setAttribute("AuctionVenue",AuctionVenue);
            //rowDetails.setAttribute("Biddate",Biddate);
            //rowDetails.setAttribute("BidderName", BidderName);
//             
//            rowDetails.setAttribute("CreatedBy", createdBy);
//            rowDetails.setAttribute("CreatedDate", pvtWriteOffInitiationDate);
//           rowDetails.setAttribute("Approvedflag","N");
             
            //rowDetails.setAttribute("FinalBidAmt",FinalBidAmt);
            //rowDetails.setAttribute("NOCReceivedFlag",NOCReceivedFlag);
//            System.out.println("Plate Contry ID ::"+selectionRow[i].getAttribute("PLATECNTID"));
//            rowDetails.setAttribute("PLATECNTID",selectionRow[i].getAttribute("PLATECNTID"));
//            rowDetails.setAttribute("PLATECTGID",selectionRow[i].getAttribute("PLATECTGID"));
//            rowDetails.setAttribute("PLATENUMBER",selectionRow[i].getAttribute("PLATENUMBER"));
//            rowDetails.setAttribute("PLATETYPEID",selectionRow[i].getAttribute("PLATETYPEID"));
             
//            rowDetails.setAttribute("PVTAMTPAYABLE",selectionRow[i].getAttribute("PVTAMTPAYABLE"));
//             BigDecimal pvtHdrSeq = (BigDecimal)selectionRow[i].getAttribute("PVTHDRSEQ");
//            rowDetails.setAttribute("PVTHDRSEQ",pvtHdrSeq);
//            rowDetails.setAttribute("ReasonID",12345);
             
//            //rowDetails.setAttribute("Updatedate",Updatedate);
//            //rowDetails.setAttribute("Updatedby",Updatedby);
//            rowDetails.setAttribute("VEHCOLOURID",selectionRow[i].getAttribute("VEHCOLOURID"));
//            rowDetails.setAttribute("VEHMAKEID",selectionRow[i].getAttribute("VEHMAKEID"));
//            rowDetails.setAttribute("VEHMODELID",selectionRow[i].getAttribute("VEHMODELID"));
//            //rowDetails.setAttribute("ValuationAmt",ValuationAmt);
//            //rowDetails.setAttribute("ValuationRecomdationID",ValuationRecomdationID);
//            //rowDetails.setAttribute("VehReleasedflag",VehReleasedflag);
          //  pvtWriteOffDetailsVO.insertRow(rowDetails);
             
//            clampingEvents(pvtHdrSeq,createdBy, "Auction Initiated to DOT Approval/Reject","751");
//            stageIDUpdate(pvtHdrSeq,auctionInitiationDate,createdBy);
            
             
       // }
      //  callProcedureToGenMail(newAuctionHeaderSeq, "770", createdBy);
       // this.getDBTransaction().commit();
        return String.valueOf( pvtWriteOffHeaderVO.getEstimatedRowCount());
    }
     */
    
    

    public ViewObjectImpl getPermitEventsVO1() {
        return (ViewObjectImpl)findViewObject("PermitEventsVO1");
    }


    public PermitSectorQuotaUVOImpl getPermitSectorQuotaUVO2() {
        return (PermitSectorQuotaUVOImpl)findViewObject("PermitSectorQuotaUVO2");
    }

    public LoginVOImpl getLoginVO1() {
        return (LoginVOImpl)findViewObject("LoginVO1");
    }


    /**
     * Container's getter for ResidenceTypeVO1.
     * @return ResidenceTypeVO1
     */
    public ViewObjectImpl getResidenceTypeVO1() {
        return (ViewObjectImpl)findViewObject("ResidenceTypeVO1");
    }

    /**
     * Container's getter for PermitDocumentsVO1.
     * @return PermitDocumentsVO1
     */
    public ViewObjectImpl getPermitDocumentsVO1() {
        return (ViewObjectImpl)findViewObject("PermitDocumentsVO1");
    }

    /**
     * Container's getter for PermitSearchVO1.
     * @return PermitSearchVO1
     */
    public ViewObjectImpl getPermitSearchVO1() {
        return (ViewObjectImpl)findViewObject("PermitSearchVO1");
    }


    /**
     * Container's getter for PermitCategLovVO1.
     * @return PermitCategLovVO1
     */
    public ViewObjectImpl getPermitCategLovVO1() {
        return (ViewObjectImpl)findViewObject("PermitCategLovVO1");
    }

    /**
     * Container's getter for PermitTypeVO1.
     * @return PermitTypeVO1
     */
    public ViewObjectImpl getPermitTypeVO1() {
        return (ViewObjectImpl)findViewObject("PermitTypeVO1");
    }


    /**
     * Container's getter for SectorVO2.
     * @return SectorVO2
     */
    public ViewObjectImpl getSectorVO2() {
        return (ViewObjectImpl)findViewObject("SectorVO2");
    }

    /**
     * Container's getter for SectorLovVO1.
     * @return SectorLovVO1
     */
    public ViewObjectImpl getSectorLovVO1() {
        return (ViewObjectImpl)findViewObject("SectorLovVO1");
    }


    /**
     * Container's getter for DocMasterUVO2.
     * @return DocMasterUVO2
     */
    public DocMasterUVOImpl getDocMasterUVO2() {
        return (DocMasterUVOImpl)findViewObject("DocMasterUVO2");
    }


    /**
     * Container's getter for PermitSearchCatgLOVVO1.
     * @return PermitSearchCatgLOVVO1
     */
    public ViewObjectImpl getPermitSearchCatgLOVVO1() {
        return (ViewObjectImpl)findViewObject("PermitSearchCatgLOVVO1");
    }


    /**
     * Container's getter for ViewObj1.
     * @return ViewObj1
     */
    //    public ViewObjImpl getViewObj1() {
    //        return (ViewObjImpl)findViewObject("ViewObj1");
    //    }


    /**
     * Container's getter for CustomerIndividualUVO1.
     * @return CustomerIndividualUVO1
     */
    public ViewObjectImpl getCustomerIndividualUVO1() {
        return (ViewObjectImpl)findViewObject("CustomerIndividualUVO1");
    }

    /**
     * Container's getter for CustomerIndividualUVO2.
     * @return CustomerIndividualUVO2
     */
    public ViewObjectImpl getCustomerIndividualUVO2() {
        return (ViewObjectImpl)findViewObject("CustomerIndividualUVO2");
    }

    /**
     * Container's getter for PermitVehicleDetailsVO1.
     * @return PermitVehicleDetailsVO1
     */
    public ViewObjectImpl getPermitVehicleDetailsVO1() {
        return (ViewObjectImpl)findViewObject("PermitVehicleDetailsVO1");
    }


    /**
     * Container's getter for PermitQuotaVO1.
     * @return PermitQuotaVO1
     */
    public PermitQuotaVOImpl getPermitQuotaVO1() {
        return (PermitQuotaVOImpl)findViewObject("PermitQuotaVO1");
    }


    /**
     * Container's getter for DocMstDtlUVO1.
     * @return DocMstDtlUVO1
     */
    public DocMstDtlUVOImpl getDocMstDtlUVO1() {
        return (DocMstDtlUVOImpl)findViewObject("DocMstDtlUVO1");
    }

    /**
     * Container's getter for PermitQuotaVO2.
     * @return PermitQuotaVO2
     */
    public PermitQuotaVOImpl getPermitQuotaVO2() {
        return (PermitQuotaVOImpl)findViewObject("PermitQuotaVO2");
    }


    /**
     * Container's getter for PermitChargesVO1.
     * @return PermitChargesVO1
     */
    public PermitChargesVOImpl getPermitChargesVO1() {
        return (PermitChargesVOImpl)findViewObject("PermitChargesVO1");
    }

    /**
     * Container's getter for PermitChargesVO2.
     * @return PermitChargesVO2
     */
    public PermitChargesVOImpl getPermitChargesVO2() {
        return (PermitChargesVOImpl)findViewObject("PermitChargesVO2");
    }

    /**
     * Container's getter for DocMstHdrUVO1.
     * @return DocMstHdrUVO1
     */
    public DocMstHdrUVOImpl getDocMstHdrUVO1() {
        return (DocMstHdrUVOImpl)findViewObject("DocMstHdrUVO1");
    }

    /**
     * Container's getter for DocMstHdrUVO2.
     * @return DocMstHdrUVO2
     */
    public DocMstHdrUVOImpl getDocMstHdrUVO2() {
        return (DocMstHdrUVOImpl)findViewObject("DocMstHdrUVO2");
    }


    /**
     * Container's getter for CustomerInstitutionVO1.
     * @return CustomerInstitutionVO1
     */
    public CustomerInstitutionVOImpl getCustomerInstitutionVO1() {
        return (CustomerInstitutionVOImpl)findViewObject("CustomerInstitutionVO1");
    }

    /**
     * Container's getter for CustomerInstitutionVO2.
     * @return CustomerInstitutionVO2
     */
    public CustomerInstitutionVOImpl getCustomerInstitutionVO2() {
        return (CustomerInstitutionVOImpl)findViewObject("CustomerInstitutionVO2");
    }


    /**
     * Container's getter for PermitRuleUVO1.
     * @return PermitRuleUVO1
     */
    public PermitRuleUVOImpl getPermitRuleUVO1() {
        return (PermitRuleUVOImpl)findViewObject("PermitRuleUVO1");
    }

    /**
     * Container's getter for PermitRuleUVO2.
     * @return PermitRuleUVO2
     */
    public PermitRuleUVOImpl getPermitRuleUVO2() {
        return (PermitRuleUVOImpl)findViewObject("PermitRuleUVO2");
    }


    /**
     * Container's getter for MenuMstUVO1.
     * @return MenuMstUVO1
     */
    public ViewObjectImpl getMenuMstUVO1() {
        return (ViewObjectImpl)findViewObject("MenuMstUVO1");
    }

    /**
     * Container's getter for SectorMstVO1.
     * @return SectorMstVO1
     */
    public ViewObjectImpl getSectorMstVO1() {
        return (ViewObjectImpl)findViewObject("SectorMstVO1");
    }

    /**
     * Container's getter for VehMakeMstVO1.
     * @return VehMakeMstVO1
     */
    public ViewObjectImpl getVehMakeMstVO1() {
        return (ViewObjectImpl)findViewObject("VehMakeMstVO1");
    }

    /**
     * Container's getter for VehModelMstVO1.
     * @return VehModelMstVO1
     */
    public ViewObjectImpl getVehModelMstVO1() {
        return (ViewObjectImpl)findViewObject("VehModelMstVO1");
    }

    /**
     * Container's getter for VehMakeToVehModelVL1.
     * @return VehMakeToVehModelVL1
     */
    public ViewLinkImpl getVehMakeToVehModelVL1() {
        return (ViewLinkImpl)findViewLink("VehMakeToVehModelVL1");
    }

    /**
     * Container's getter for VehModelMstVO2.
     * @return VehModelMstVO2
     */
    public ViewObjectImpl getVehModelMstVO2() {
        return (ViewObjectImpl)findViewObject("VehModelMstVO2");
    }

    /**
     * Container's getter for PermitSearchCriteriaVO1.
     * @return PermitSearchCriteriaVO1
     */
    public ViewObjectImpl getPermitSearchCriteriaVO1() {
        return (ViewObjectImpl)findViewObject("PermitSearchCriteriaVO1");
    }

    /**
     * Container's getter for ContraventionMstUVO1.
     * @return ContraventionMstUVO1
     */
    public ViewObjectImpl getContraventionMstUVO1() {
        return (ViewObjectImpl)findViewObject("ContraventionMstUVO1");
    }

    /**
     * Container's getter for ContraventionMstUVO2.
     * @return ContraventionMstUVO2
     */
    public ViewObjectImpl getContraventionMstUVO2() {
        return (ViewObjectImpl)findViewObject("ContraventionMstUVO2");
    }

    /**
     * Container's getter for VehMakeMstVO2.
     * @return VehMakeMstVO2
     */
    public ViewObjectImpl getVehMakeMstVO2() {
        return (ViewObjectImpl)findViewObject("VehMakeMstVO2");
    }

    /**
     * Container's getter for LocationMstVO1.
     * @return LocationMstVO1
     */
    public LocationMstVOImpl getLocationMstVO1() {
        return (LocationMstVOImpl)findViewObject("LocationMstVO1");
    }

    /**
     * Container's getter for LocationMstVO2.
     * @return LocationMstVO2
     */
    public LocationMstVOImpl getLocationMstVO2() {
        return (LocationMstVOImpl)findViewObject("LocationMstVO2");
    }

    /**
     * Container's getter for HHDeviceMstUVO1.
     * @return HHDeviceMstUVO1
     */
    public ViewObjectImpl getHHDeviceMstUVO1() {
        return (ViewObjectImpl)findViewObject("HHDeviceMstUVO1");
    }

    /**
     * Container's getter for HHDeviceMstUVO2.
     * @return HHDeviceMstUVO2
     */
    public ViewObjectImpl getHHDeviceMstUVO2() {
        return (ViewObjectImpl)findViewObject("HHDeviceMstUVO2");
    }


    /**
     * Container's getter for RemovalTruckMstVO1.
     * @return RemovalTruckMstVO1
     */
    public RemovalTruckMstVOImpl getRemovalTruckMstVO1() {
        return (RemovalTruckMstVOImpl)findViewObject("RemovalTruckMstVO1");
    }

    /**
     * Container's getter for RemovalTruckMstVO2.
     * @return RemovalTruckMstVO2
     */
    public RemovalTruckMstVOImpl getRemovalTruckMstVO2() {
        return (RemovalTruckMstVOImpl)findViewObject("RemovalTruckMstVO2");
    }


    /**
     * Container's getter for VehiclePlateCategoryVO2.
     * @return VehiclePlateCategoryVO2
     */
    public ViewObjectImpl getVehiclePlateCategoryVO2() {
        return (ViewObjectImpl)findViewObject("VehiclePlateCategoryVO2");
    }

    /**
     * Container's getter for VehiclePlateTypeVO2.
     * @return VehiclePlateTypeVO2
     */
    public ViewObjectImpl getVehiclePlateTypeVO2() {
        return (ViewObjectImpl)findViewObject("VehiclePlateTypeVO2");
    }


    /**
     * Container's getter for VehiclePlateCategoryVO1.
     * @return VehiclePlateCategoryVO1
     */
    public ViewObjectImpl getVehiclePlateCategoryVO1() {
        return (ViewObjectImpl)findViewObject("VehiclePlateCategoryVO1");
    }

    /**
     * Container's getter for VehiclePlateTypeVO1.
     * @return VehiclePlateTypeVO1
     */
    public ViewObjectImpl getVehiclePlateTypeVO1() {
        return (ViewObjectImpl)findViewObject("VehiclePlateTypeVO1");
    }

    /**
     * Container's getter for VehPlateCtgToTypeVL1.
     * @return VehPlateCtgToTypeVL1
     */
    public ViewLinkImpl getVehPlateCtgToTypeVL1() {
        return (ViewLinkImpl)findViewLink("VehPlateCtgToTypeVL1");
    }


    /**
     * Container's getter for BayNumberLVO1.
     * @return BayNumberLVO1
     */
    public BayNumberLVOImpl getBayNumberLVO1() {
        return (BayNumberLVOImpl)findViewObject("BayNumberLVO1");
    }

    /**
     * Container's getter for PVTStageOnHoldRelLVO1.
     * @return PVTStageOnHoldRelLVO1
     */
    public ViewObjectImpl getPVTStageOnHoldRelLVO1() {
        return (ViewObjectImpl)findViewObject("PVTStageOnHoldRelLVO1");
    }

    /**
     * Container's getter for GenRefDataDocVO1.
     * @return GenRefDataDocVO1
     */
    public ViewObjectImpl getGenRefDataDocVO1() {
        return (ViewObjectImpl)findViewObject("GenRefDataDocVO1");
    }

    /**
     * Container's getter for GenRefDataDetailMstRVO1.
     * @return GenRefDataDetailMstRVO1
     */
    public ViewObjectImpl getGenRefDataDetailMstRVO1() {
        return (ViewObjectImpl)findViewObject("GenRefDataDetailMstRVO1");
    }

    /**
     * Container's getter for GenRefDataHeaderMstRVO1.
     * @return GenRefDataHeaderMstRVO1
     */
    public ViewObjectImpl getGenRefDataHeaderMstRVO1() {
        return (ViewObjectImpl)findViewObject("GenRefDataHeaderMstRVO1");
    }

    /**
     * Container's getter for VehiclePlateCategoryLVO1.
     * @return VehiclePlateCategoryLVO1
     */
    public ViewObjectImpl getVehiclePlateCategoryLVO1() {
        return (ViewObjectImpl)findViewObject("VehiclePlateCategoryLVO1");
    }

    /**
     * Container's getter for PVTStatusSpoiledVO1.
     * @return PVTStatusSpoiledVO1
     */
    public ViewObjectImpl getPVTStatusSpoiledVO1() {
        return (ViewObjectImpl)findViewObject("PVTStatusSpoiledVO1");
    }

    /**
     * Container's getter for HolidayMstUVO1.
     * @return HolidayMstUVO1
     */
    public ViewObjectImpl getHolidayMstUVO1() {
        return (ViewObjectImpl)findViewObject("HolidayMstUVO1");
    }

    /**
     * Container's getter for HolidayMstUVO2.
     * @return HolidayMstUVO2
     */
    public HolidayMstUVOImpl getHolidayMstUVO2() {
        return (HolidayMstUVOImpl)findViewObject("HolidayMstUVO2");
    }

    /**
     * Container's getter for PoundBayDetailVO1.
     * @return PoundBayDetailVO1
     */
    public PoundBayDetailVOImpl getPoundBayDetailVO1() {
        return (PoundBayDetailVOImpl)findViewObject("PoundBayDetailVO1");
    }

    /**
     * Container's getter for VehicleWhitelistMstVO1.
     * @return VehicleWhitelistMstVO1
     */
    public ViewObjectImpl getVehicleWhitelistMstVO1() {
        return (ViewObjectImpl)findViewObject("VehicleWhitelistMstVO1");
    }

    /**
     * Container's getter for VehicleWhitelistMstVO2.
     * @return VehicleWhitelistMstVO2
     */
    public ViewObjectImpl getVehicleWhitelistMstVO2() {
        return (ViewObjectImpl)findViewObject("VehicleWhitelistMstVO2");
    }

    /**
     * Container's getter for ZoneMstVO1.
     * @return ZoneMstVO1
     */
    public ZoneMstVOImpl getZoneMstVO1() {
        return (ZoneMstVOImpl)findViewObject("ZoneMstVO1");
    }

    /**
     * Container's getter for LinkedSectorsVO1.
     * @return LinkedSectorsVO1
     */
    public com.imum.cpms.model.masters.vo.LinkedSectorsVOImpl getLinkedSectorsVO1() {
        return (com.imum.cpms.model.masters.vo.LinkedSectorsVOImpl)findViewObject("LinkedSectorsVO1");
    }

    /**
     * Container's getter for GroupMstUVO1.
     * @return GroupMstUVO1
     */
    public GroupMstUVOImpl getGroupMstUVO1() {
        return (GroupMstUVOImpl)findViewObject("GroupMstUVO1");
    }

    /**
     * Container's getter for UserMstUVO1.
     * @return UserMstUVO1
     */
    public ViewObjectImpl getUserMstUVO1() {
        return (ViewObjectImpl)findViewObject("UserMstUVO1");
    }

    /**
     * Container's getter for UserMstUVO2.
     * @return UserMstUVO2
     */
    public ViewObjectImpl getUserMstUVO2() {
        return (ViewObjectImpl)findViewObject("UserMstUVO2");
    }

    /**
     * Container's getter for GroupMstUVO2.
     * @return GroupMstUVO2
     */
    public GroupMstUVOImpl getGroupMstUVO2() {
        return (GroupMstUVOImpl)findViewObject("GroupMstUVO2");
    }


    /**
     * Container's getter for RoleLOVVO1.
     * @return RoleLOVVO1
     */
    public ViewObjectImpl getRoleLOVVO1() {
        return (ViewObjectImpl)findViewObject("RoleLOVVO1");
    }


    /**
     * Container's getter for UserRoleMapUVO1.
     * @return UserRoleMapUVO1
     */
    public ViewObjectImpl getUserRoleMapUVO1() {
        return (ViewObjectImpl)findViewObject("UserRoleMapUVO1");
    }

    /**
     * Container's getter for UserRoleMapUVO2.
     * @return UserRoleMapUVO2
     */
    public ViewObjectImpl getUserRoleMapUVO2() {
        return (ViewObjectImpl)findViewObject("UserRoleMapUVO2");
    }

    /**
     * Container's getter for ZoneMstVO2.
     * @return ZoneMstVO2
     */
    public ZoneMstVOImpl getZoneMstVO2() {
        return (ZoneMstVOImpl)findViewObject("ZoneMstVO2");
    }

    /**
     * Container's getter for GenRoleUVO1.
     * @return GenRoleUVO1
     */
    public ViewObjectImpl getGenRoleUVO1() {
        return (ViewObjectImpl)findViewObject("GenRoleUVO1");
    }


    /**
     * Container's getter for GenMenuRoleUVO1.
     * @return GenMenuRoleUVO1
     */
    public ViewObjectImpl getGenMenuRoleUVO1() {
        return (ViewObjectImpl)findViewObject("GenMenuRoleUVO1");
    }


    /**
     * Container's getter for GenRoleUVO2.
     * @return GenRoleUVO2
     */
    public ViewObjectImpl getGenRoleUVO2() {
        return (ViewObjectImpl)findViewObject("GenRoleUVO2");
    }

    /**
     * Container's getter for GenMenuRoleUVO3.
     * @return GenMenuRoleUVO3
     */
    public ViewObjectImpl getGenMenuRoleUVO3() {
        return (ViewObjectImpl)findViewObject("GenMenuRoleUVO3");
    }

    /**
     * Container's getter for GenRoleMenuVL2.
     * @return GenRoleMenuVL2
     */
    public ViewLinkImpl getGenRoleMenuVL2() {
        return (ViewLinkImpl)findViewLink("GenRoleMenuVL2");
    }

    /**
     * Container's getter for GenMsgMstVO1.
     * @return GenMsgMstVO1
     */
    public GenMsgMstVOImpl getGenMsgMstVO1() {
        return (GenMsgMstVOImpl)findViewObject("GenMsgMstVO1");
    }

    /**
     * Container's getter for GenMsgMstLngVO1.
     * @return GenMsgMstLngVO1
     */
    public GenMsgMstLngVOImpl getGenMsgMstLngVO1() {
        return (GenMsgMstLngVOImpl)findViewObject("GenMsgMstLngVO1");
    }


    /**
     * Container's getter for UserRoleMapUVO3.
     * @return UserRoleMapUVO3
     */
    public ViewObjectImpl getUserRoleMapUVO3() {
        return (ViewObjectImpl)findViewObject("UserRoleMapUVO3");
    }

    /**
     * Container's getter for UserRoleVL1.
     * @return UserRoleVL1
     */
    public ViewLinkImpl getUserRoleVL1() {
        return (ViewLinkImpl)findViewLink("UserRoleVL1");
    }

    /**
     * Container's getter for PermitAccountEntriesRVO1.
     * @return PermitAccountEntriesRVO1
     */
    public PermitAccountEntriesRVOImpl getPermitAccountEntriesRVO1() {
        return (PermitAccountEntriesRVOImpl)findViewObject("PermitAccountEntriesRVO1");
    }

    /**
     * Container's getter for SectorMstLngVO1.
     * @return SectorMstLngVO1
     */
    public SectorMstLngVOImpl getSectorMstLngVO1() {
        return (SectorMstLngVOImpl)findViewObject("SectorMstLngVO1");
    }

    /**
     * Container's getter for LocationMstLngVO1.
     * @return LocationMstLngVO1
     */
    public ViewObjectImpl getLocationMstLngVO1() {
        return (ViewObjectImpl)findViewObject("LocationMstLngVO1");
    }

    /**
     * Container's getter for ContraMstLngVO1.
     * @return ContraMstLngVO1
     */
    public ViewObjectImpl getContraMstLngVO1() {
        return (ViewObjectImpl)findViewObject("ContraMstLngVO1");
    }

    /**
     * Container's getter for PermitPaidDetails1.
     * @return PermitPaidDetails1
     */
    public PermitPaidDetailsImpl getPermitPaidDetails1() {
        return (PermitPaidDetailsImpl)findViewObject("PermitPaidDetails1");
    }

    /**
     * Container's getter for PRMDocUVO1.
     * @return PRMDocUVO1
     */
    public PRMDocUVOImpl getPRMDocUVO1() {
        return (PRMDocUVOImpl)findViewObject("PRMDocUVO1");
    }

    /**
     * Container's getter for ZoneMstLngVO1.
     * @return ZoneMstLngVO1
     */
    public ZoneMstLngVOImpl getZoneMstLngVO1() {
        return (ZoneMstLngVOImpl)findViewObject("ZoneMstLngVO1");
    }

    /**
     * Container's getter for VehMakeMstLngVO1.
     * @return VehMakeMstLngVO1
     */
    public ViewObjectImpl getVehMakeMstLngVO1() {
        return (ViewObjectImpl)findViewObject("VehMakeMstLngVO1");
    }

    /**
     * Container's getter for VehMakeMstLngVO2.
     * @return VehMakeMstLngVO2
     */
    public ViewObjectImpl getVehMakeMstLngVO2() {
        return (ViewObjectImpl)findViewObject("VehMakeMstLngVO2");
    }

    /**
     * Container's getter for VehModelMstLngVO1.
     * @return VehModelMstLngVO1
     */
    public ViewObjectImpl getVehModelMstLngVO1() {
        return (ViewObjectImpl)findViewObject("VehModelMstLngVO1");
    }

    /**
     * Container's getter for VehModelMstLngVO2.
     * @return VehModelMstLngVO2
     */
    public ViewObjectImpl getVehModelMstLngVO2() {
        return (ViewObjectImpl)findViewObject("VehModelMstLngVO2");
    }

    /**
     * Container's getter for VehModelMstVO3.
     * @return VehModelMstVO3
     */
    public ViewObjectImpl getVehModelMstVO3() {
        return (ViewObjectImpl)findViewObject("VehModelMstVO3");
    }

    /**
     * Container's getter for VehModelMstModelIdRVO1.
     * @return VehModelMstModelIdRVO1
     */
    public ViewObjectImpl getVehModelMstModelIdRVO1() {
        return (ViewObjectImpl)findViewObject("VehModelMstModelIdRVO1");
    }

    /**
     * Container's getter for VehPlateCtgMstLngVO1.
     * @return VehPlateCtgMstLngVO1
     */
    public ViewObjectImpl getVehPlateCtgMstLngVO1() {
        return (ViewObjectImpl)findViewObject("VehPlateCtgMstLngVO1");
    }

    /**
     * Container's getter for VehPlateCtgMstLngVO2.
     * @return VehPlateCtgMstLngVO2
     */
    public ViewObjectImpl getVehPlateCtgMstLngVO2() {
        return (ViewObjectImpl)findViewObject("VehPlateCtgMstLngVO2");
    }

    /**
     * Container's getter for VehPlateTypeMstLngVO1.
     * @return VehPlateTypeMstLngVO1
     */
    public ViewObjectImpl getVehPlateTypeMstLngVO1() {
        return (ViewObjectImpl)findViewObject("VehPlateTypeMstLngVO1");
    }

    /**
     * Container's getter for VehPlateTypeMstLngVO2.
     * @return VehPlateTypeMstLngVO2
     */
    public ViewObjectImpl getVehPlateTypeMstLngVO2() {
        return (ViewObjectImpl)findViewObject("VehPlateTypeMstLngVO2");
    }

    /**
     * Container's getter for VehPlateTypeTypeIdRVO1.
     * @return VehPlateTypeTypeIdRVO1
     */
    public ViewObjectImpl getVehPlateTypeTypeIdRVO1() {
        return (ViewObjectImpl)findViewObject("VehPlateTypeTypeIdRVO1");
    }

    /**
     * Container's getter for RuleMaxQuotaVO1.
     * @return RuleMaxQuotaVO1
     */
    public RuleMaxQuotaVOImpl getRuleMaxQuotaVO1() {
        return (RuleMaxQuotaVOImpl)findViewObject("RuleMaxQuotaVO1");
    }

    /**
     * Container's getter for AccountMapMstVO1.
     * @return AccountMapMstVO1
     */
    public AccountMapMstVOImpl getAccountMapMstVO1() {
        return (AccountMapMstVOImpl)findViewObject("AccountMapMstVO1");
    }

    /**
     * Container's getter for AccountMstVO1.
     * @return AccountMstVO1
     */
    public AccountMstVOImpl getAccountMstVO1() {
        return (AccountMstVOImpl)findViewObject("AccountMstVO1");
    }

    /**
     * Container's getter for AccountMstVO2.
     * @return AccountMstVO2
     */
    public AccountMstVOImpl getAccountMstVO2() {
        return (AccountMstVOImpl)findViewObject("AccountMstVO2");
    }

    /**
     * Container's getter for ShiftMstUVO1.
     * @return ShiftMstUVO1
     */
    public ShiftMstUVOImpl getShiftMstUVO1() {
        return (ShiftMstUVOImpl)findViewObject("ShiftMstUVO1");
    }

    /**
     * Container's getter for ShiftMstUVO2.
     * @return ShiftMstUVO2
     */
    public ShiftMstUVOImpl getShiftMstUVO2() {
        return (ShiftMstUVOImpl)findViewObject("ShiftMstUVO2");
    }
    /**
     * Container's getter for VehiclePlateCountryLVO1.
     * @return VehiclePlateCountryLVO1
     */
    public ViewObjectImpl getVehiclePlateCountryLVO1() {
        return (ViewObjectImpl)findViewObject("VehiclePlateCountryLVO1");
    }

    /**
     * Container's getter for VehiclePlateCountryLVO2.
     * @return VehiclePlateCountryLVO2
     */
    public ViewObjectImpl getVehiclePlateCountryLVO2() {
        return (ViewObjectImpl)findViewObject("VehiclePlateCountryLVO2");
    }

    /**
     * Container's getter for printVO1.
     * @return printVO1
     */
    public printVOImpl getprintVO1() {
        return (printVOImpl)findViewObject("printVO1");
    }

    /**
     * Container's getter for VehicleBlaclListMstUVO1.
     * @return VehicleBlaclListMstUVO1
     */
    public ViewObjectImpl getVehicleBlaclListMstUVO1() {
        return (ViewObjectImpl)findViewObject("VehicleBlaclListMstUVO1");
    }

    /**
     * Container's getter for VehicleBlaclListMstUVO2.
     * @return VehicleBlaclListMstUVO2
     */
    public ViewObjectImpl getVehicleBlaclListMstUVO2() {
        return (ViewObjectImpl)findViewObject("VehicleBlaclListMstUVO2");
    }

    /**
     * Container's getter for VehicleBlacklistMstVO1.
     * @return VehicleBlacklistMstVO1
     */
    public VehicleBlacklistMstVOImpl getVehicleBlacklistMstVO1() {
        return (VehicleBlacklistMstVOImpl)findViewObject("VehicleBlacklistMstVO1");
    }

    /**
     * Container's getter for VehicleBlacklistMstVO2.
     * @return VehicleBlacklistMstVO2
     */
    public VehicleBlacklistMstVOImpl getVehicleBlacklistMstVO2() {
        return (VehicleBlacklistMstVOImpl)findViewObject("VehicleBlacklistMstVO2");
    }

    /**
     * Container's getter for printBlackVO1.
     * @return printBlackVO1
     */
    public printBlackVOImpl getprintBlackVO1() {
        return (printBlackVOImpl)findViewObject("printBlackVO1");
    }

    /**
     * Container's getter for GenEventDetailsUVO1.
     * @return GenEventDetailsUVO1
     */
    public GenEventDetailsUVOImpl getGenEventDetailsUVO1() {
        return (GenEventDetailsUVOImpl)findViewObject("GenEventDetailsUVO1");
    }


    /**
     * Container's getter for GenEventLogDetailsUVO1.
     * @return GenEventLogDetailsUVO1
     */
    public ViewObjectImpl getGenEventLogDetailsUVO1() {
        return (ViewObjectImpl)findViewObject("GenEventLogDetailsUVO1");
    }

    /**
     * Container's getter for InvStockReorderLevelDetailsVO1.
     * @return InvStockReorderLevelDetailsVO1
     */
    public ViewObjectImpl getInvStockReorderLevelDetailsVO1() {
        return (ViewObjectImpl)findViewObject("InvStockReorderLevelDetailsVO1");
    }

    /**
     * Container's getter for InvStockReorderLevelDetailsVO2.
     * @return InvStockReorderLevelDetailsVO2
     */
    public ViewObjectImpl getInvStockReorderLevelDetailsVO2() {
        return (ViewObjectImpl)findViewObject("InvStockReorderLevelDetailsVO2");
    }

    /**
     * Container's getter for LocationmstLOV1.
     * @return LocationmstLOV1
     */
    public ViewObjectImpl getLocationmstLOV1() {
        return (ViewObjectImpl)findViewObject("LocationmstLOV1");
    }

    /**
     * Container's getter for BeatMstUVO1.
     * @return BeatMstUVO1
     */
    public BeatMstUVOImpl getBeatMstUVO1() {
        return (BeatMstUVOImpl)findViewObject("BeatMstUVO1");
    }

    /**
     * Container's getter for RevenueGroupUVO1.
     * @return RevenueGroupUVO1
     */
    public RevenueGroupUVOImpl getRevenueGroupUVO1() {
        return (RevenueGroupUVOImpl)findViewObject("RevenueGroupUVO1");
    }

    /**
     * Container's getter for RevenueGroupUVO2.
     * @return RevenueGroupUVO2
     */
    public RevenueGroupUVOImpl getRevenueGroupUVO2() {
        return (RevenueGroupUVOImpl)findViewObject("RevenueGroupUVO2");
    }

    /**
     * Container's getter for RevenueTypeUVO1.
     * @return RevenueTypeUVO1
     */
    public RevenueTypeUVOImpl getRevenueTypeUVO1() {
        return (RevenueTypeUVOImpl)findViewObject("RevenueTypeUVO1");
    }

    /**
     * Container's getter for AppealReasonMstVO1.
     * @return AppealReasonMstVO1
     */
    public ViewObjectImpl getAppealReasonMstVO1() {
        return (ViewObjectImpl)findViewObject("AppealReasonMstVO1");
    }

    /**
     * Container's getter for PvtAppealdocMstVO1.
     * @return PvtAppealdocMstVO1
     */
    public ViewObjectImpl getPvtAppealdocMstVO1() {
        return (ViewObjectImpl)findViewObject("PvtAppealdocMstVO1");
    }

    /**
     * Container's getter for appealResVO1.
     * @return appealResVO1
     */
    public ViewObjectImpl getappealResVO1() {
        return (ViewObjectImpl)findViewObject("appealResVO1");
    }
    /**
     * Container's getter for PVTCourtReportUVO1.
     * @return PVTCourtReportUVO1
     */
    public PVTCourtReportUVOImpl getPVTCourtReportUVO1() {
        return (PVTCourtReportUVOImpl)findViewObject("PVTCourtReportUVO1");
    }

    /**
     * Container's getter for InvStockReorderLevelDetailsVO3.
     * @return InvStockReorderLevelDetailsVO3
     */
    public InvStockReorderLevelDetailsVOImpl getInvStockReorderLevelDetailsVO3() {
        return (InvStockReorderLevelDetailsVOImpl)findViewObject("InvStockReorderLevelDetailsVO3");
    }
    /**
     * Container's getter for PVTCourtReportingRVO1.
     * @return PVTCourtReportingRVO1
     */
    public PVTCourtReportingRVOImpl getPVTCourtReportingRVO1() {
        return (PVTCourtReportingRVOImpl)findViewObject("PVTCourtReportingRVO1");
    }

    /**
     * Container's getter for PVTCourtReportDocsUVO1.
     * @return PVTCourtReportDocsUVO1
     */
    public PVTCourtReportDocsUVOImpl getPVTCourtReportDocsUVO1() {
        return (PVTCourtReportDocsUVOImpl)findViewObject("PVTCourtReportDocsUVO1");
    }

    /**
     * Container's getter for PVTCourtReportUVO2.
     * @return PVTCourtReportUVO2
     */
    public PVTCourtReportUVOImpl getPVTCourtReportUVO2() {
        return (PVTCourtReportUVOImpl)findViewObject("PVTCourtReportUVO2");
    }
    /**
     * Container's getter for PermitRemarksEntityDetailsVO1.
     * @return PermitRemarksEntityDetailsVO1
     */
    public ViewObjectImpl getPermitRemarksEntityDetailsVO1() {
        return (ViewObjectImpl)findViewObject("PermitRemarksEntityDetailsVO1");
    }

    /**
     * Container's getter for PermitDocumentUVO1.
     * @return PermitDocumentUVO1
     */
    public ViewObjectImpl getPermitDocumentUVO1() {
        return (ViewObjectImpl)findViewObject("PermitDocumentUVO1");
    }

    /**
     * Container's getter for PVTDocsVO1.
     * @return PVTDocsVO1
     */
    public PVTDocsVOImpl getPVTDocsVO1() {
        return (PVTDocsVOImpl)findViewObject("PVTDocsVO1");
    }

    /**
     * Container's getter for CourtpvtHeaderVO1.
     * @return CourtpvtHeaderVO1
     */
    public ViewObjectImpl getCourtpvtHeaderVO1() {
        return (ViewObjectImpl)findViewObject("CourtpvtHeaderVO1");
    }

    /**
     * Container's getter for PVTEventDetailsVO1.
     * @return PVTEventDetailsVO1
     */
    public PVTEventDetailsVOImpl getPVTEventDetailsVO1() {
        return (PVTEventDetailsVOImpl)findViewObject("PVTEventDetailsVO1");
    }

    /**
     * Container's getter for PVTCourtcaseremarksVO1.
     * @return PVTCourtcaseremarksVO1
     */
    public ViewObjectImpl getPVTCourtcaseremarksVO1() {
        return (ViewObjectImpl)findViewObject("PVTCourtcaseremarksVO1");
    }

    /**
     * Container's getter for PVTCourtcaseremarksVO2.
     * @return PVTCourtcaseremarksVO2
     */
    public PVTCourtcaseremarksVOImpl getPVTCourtcaseremarksVO2() {
        return (PVTCourtcaseremarksVOImpl)findViewObject("PVTCourtcaseremarksVO2");
    }

    /**
     * Container's getter for PVTcourtsearchVO1.
     * @return PVTcourtsearchVO1
     */
    public ViewObjectImpl getPVTcourtsearchVO1() {
        return (ViewObjectImpl)findViewObject("PVTcourtsearchVO1");
    }

    /**
     * Container's getter for docverifictionlov1.
     * @return docverifictionlov1
     */
    public ViewObjectImpl getdocverifictionlov1() {
        return (ViewObjectImpl)findViewObject("docverifictionlov1");
    }

   
    /**
     * Container's getter for AuditcardDetailsVO1.
     * @return AuditcardDetailsVO1
     */
    public ViewObjectImpl getAuditcardDetailsVO1() {
        return (ViewObjectImpl)findViewObject("AuditcardDetailsVO1");
    }
    /**
     * Container's getter for PVTExceptionzoneVO1.
     * @return PVTExceptionzoneVO1
     */
    public ViewObjectImpl getPVTExceptionzoneVO1() {
        return (ViewObjectImpl)findViewObject("PVTExceptionzoneVO1");
    }

    /**
     * Container's getter for VehicleCountrymstVO1.
     * @return VehicleCountrymstVO1
     */
    public ViewObjectImpl getVehicleCountrymstVO1() {
        return (ViewObjectImpl)findViewObject("VehicleCountrymstVO1");
    }

    /**
     * Container's getter for VehicleCountrymstVO2.
     * @return VehicleCountrymstVO2
     */
    public ViewObjectImpl getVehicleCountrymstVO2() {
        return (ViewObjectImpl)findViewObject("VehicleCountrymstVO2");
    }

    /**
     * Container's getter for VehicleCountrymstlngVO1.
     * @return VehicleCountrymstlngVO1
     */
    public ViewObjectImpl getVehicleCountrymstlngVO1() {
        return (ViewObjectImpl)findViewObject("VehicleCountrymstlngVO1");
    }

    /**
     * Container's getter for VehColourmstVO1.
     * @return VehColourmstVO1
     */
    public ViewObjectImpl getVehColourmstVO1() {
        return (ViewObjectImpl)findViewObject("VehColourmstVO1");
    }
    /**
     * Container's getter for VehicleWhitelistMstValidationRVO1.
     * @return VehicleWhitelistMstValidationRVO1
     */
    public ViewObjectImpl getVehicleWhitelistMstValidationRVO1() {
        return (ViewObjectImpl)findViewObject("VehicleWhitelistMstValidationRVO1");
    }
    /**
     * Container's getter for AuditCardcountdtlsVO1.
     * @return AuditCardcountdtlsVO1
     */
    public ViewObjectImpl getAuditCardcountdtlsVO1() {
        return (ViewObjectImpl)findViewObject("AuditCardcountdtlsVO1");
    }

    /**
     * Container's getter for AuditHeaderVO1.
     * @return AuditHeaderVO1
     */
    public ViewObjectImpl getAuditHeaderVO1() {
        return (ViewObjectImpl)findViewObject("AuditHeaderVO1");
    }

    /**
     * Container's getter for AuditCardsearchVO1.
     * @return AuditCardsearchVO1
     */
    public AuditCardsearchVOImpl loctionSearchgetAuditCardsearchVO1() {
        return (AuditCardsearchVOImpl)findViewObject("AuditCardsearchVO1");
    }

    /**
     * Container's getter for AuditHeaderVO2.
     * @return AuditHeaderVO2
     */
    public ViewObjectImpl getAuditHeaderVO2() {
        return (ViewObjectImpl)findViewObject("AuditHeaderVO2");
    }

    /**
     * Container's getter for AuditCardsearchVO1.
     * @return AuditCardsearchVO1
     */
    public AuditCardsearchVOImpl getAuditCardsearchVO1() {
        return (AuditCardsearchVOImpl)findViewObject("AuditCardsearchVO1");
    }
    /**
     * Container's getter for AuditCardcountdtlsVO2.
     * @return AuditCardcountdtlsVO2
     */
    public ViewObjectImpl getAuditCardcountdtlsVO2() {
        return (ViewObjectImpl)findViewObject("AuditCardcountdtlsVO2");
    }

    /**
     * Container's getter for ExcessShortageLOV1.
     * @return ExcessShortageLOV1
     */
    public ViewObjectImpl getExcessShortageLOV1() {
        return (ViewObjectImpl)findViewObject("ExcessShortageLOV1");
    }

    /**
     * Container's getter for AuditcardDetailsVO2.
     * @return AuditcardDetailsVO2
     */
    public ViewObjectImpl getAuditcardDetailsVO2() {
        return (ViewObjectImpl)findViewObject("AuditcardDetailsVO2");
    }

    /**
     * Container's getter for auditcardDetailsRVO1.
     * @return auditcardDetailsRVO1
     */
    public ViewObjectImpl getauditcardDetailsRVO1() {
        return (ViewObjectImpl)findViewObject("auditcardDetailsRVO1");
    }

    /**
     * Container's getter for PvtSearchWriteOffRVO1.
     * @return PvtSearchWriteOffRVO1
     */
    public ViewObjectImpl getPvtSearchWriteOffRVO1() {
        return (ViewObjectImpl)findViewObject("PvtSearchWriteOffRVO1");
    }

    /**
     * Container's getter for PvtWriteOffProgVO1.
     * @return PvtWriteOffProgVO1
     */
    public PvtWriteOffProgVOImpl getPvtWriteOffProgVO1() {
        return (PvtWriteOffProgVOImpl)findViewObject("PvtWriteOffProgVO1");
    }

    /**
     * Container's getter for PVTWRITEOFFDETAILSVO1.
     * @return PVTWRITEOFFDETAILSVO1
     */
    public ViewObjectImpl getPVTWRITEOFFDETAILSVO1() {
        return (ViewObjectImpl)findViewObject("PVTWRITEOFFDETAILSVO1");
    }

    /**
     * Container's getter for PVTWRITEOFFHEADERVO1.
     * @return PVTWRITEOFFHEADERVO1
     */
    public ViewObjectImpl getPVTWRITEOFFHEADERVO1() {
        return (ViewObjectImpl)findViewObject("PVTWRITEOFFHEADERVO1");
    }

    /**
     * Container's getter for PvtWiriteOffCount1.
     * @return PvtWiriteOffCount1
     */
    public ViewObjectImpl getPvtWiriteOffCount1() {
        return (ViewObjectImpl)findViewObject("PvtWiriteOffCount1");
    }
}
