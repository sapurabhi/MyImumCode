package com.imum.cpms.transactions.pilocationmap;

import com.imum.cpms.model.transactions.vo.PIMonthlyDeploymentVOImpl;
import com.imum.cpms.model.transactions.vo.PIMonthlyDeploymentVORowImpl;
import com.imum.cpms.model.transactions.vo.SectorforSupVORowImpl;
import com.imum.cpms.util.ADFUtils;
import com.imum.cpms.util.MessageUtil;

import java.sql.Timestamp;

import java.text.ParseException;

import java.util.Date;

import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class PiLocation {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    BindingContainer bindings = getBindings();
    String lngCode = "";
    private String hide;
    MessageUtil genMsg = new MessageUtil();
    
    
    private RichInputDate pilocationDate;
    private RichInputText piidlocationmap;
    private RichInputListOfValues piidlocationmap1;
    private RichInputText sector;
    public String Sector;
    public int shift;
 
    private RichSelectOneChoice s;

    public PiLocation() {
    }
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public String generateReport() throws ParseException {
        String piid=null;
        Date piDate=null;
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);      
               // Invoke a java script method name called showConfPopup()' with two parameters, You can pass any value
             
          
        
        JUCtrlListBinding listBinding1 =(JUCtrlListBinding)BindingContext.getCurrent().getCurrentBindingsEntry().getControlBinding("PiidMonthlyDeployment1");
        String str = (String)listBinding1.getSelectedValue();
        
       // System.out.println(str);
//        if(piidlocationmap.getValue()!=null){
//       piid=piidlocationmap.getValue().toString();
//        }else{
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter PIID",genMsg.getMessage("000", lngCode)));                    
//        }
       if(str!=null){
       piid=str;
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select PIID",genMsg.getMessage("000", lngCode)));                    
        }
   
        if(pilocationDate.getValue()!=null){
       piDate=(Date)pilocationDate.getValue();
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select Date",genMsg.getMessage("000", lngCode))); 
            return null;
        }
        java.sql.Date sqldate= new java.sql.Date( piDate.getTime());
      //  System.out.println(sqldate);
    //        java.sql.Date sqldate = new java.sql.Date(pidate.getTime());
    //        DateFormat formatter1;
    //        formatter1 = new SimpleDateFormat("mm/DD/yyyy");
    //        //System.out.println((Date)formatter1.parse("piDate"));
        
              
            //   erks.addScript(fctx, "loadMap('"+"54.37425"+"','"+"24.512689"+ "')");  

           
        //FacesContext fctx = FacesContext.getCurrentInstance();
            //   ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);      
               // Invoke a java script method name called showConfPopup()' with two parameters, You can pass any value 
    //               erks.addScript(fctx, "var long = []");
    //               erks.addScript(fctx, "var latt = []");
    //               erks.addScript(fctx, "long.push(54.37425");
    //               erks.addScript(fctx, "latt.push(24.512689");
    //               erks.addScript(fctx, "loadMap('long','latt')");
               //erks.addScript(fctx, "loadMap('"+"54.37425"+"','"+"24.512689"+ "')");  
        
        // vamsi add code for pi-pvt's
        
        
        
        
        
//        OperationBinding op = bindings.getOperationBinding("getPiPvts");
//        op.getParamsMap().put("piid", piid);
//        op.getParamsMap().put("pidate", sqldate);
//        op.execute();
        
//        DCBindingContainer bindings1 =(DCBindingContainer)getBindings();
//        DCIteratorBinding dcIteratorBinding = bindings1.findIteratorBinding("SectorforSupVO1Iterator");
//        ViewObject sectorVO = dcIteratorBinding.getViewObject();
//                String userName = "";
//            ADFContext adfctx = ADFContext.getCurrent();
//            if(adfctx.getSessionScope().get("loggedinUserid")!=null){
//                userName = adfctx.getSessionScope().get("loggedinUserid").toString(); 
//            }   
      
        
//        Row row= sectorVO.first(); 
//        System.out.println(row.getAttribute("Sector").toString());
//        
//        sector.setValue(row.getAttribute("Sector").toString());
        OperationBinding operationBindings = bindings.getOperationBinding("getPiLocationCoordinates");
        operationBindings.getParamsMap().put("piid", piid);
        operationBindings.getParamsMap().put("pidate", sqldate);
        operationBindings.execute();








        return null;
    }

    public void setPilocationDate(RichInputDate pilocationDate) {
        this.pilocationDate = pilocationDate;
    }

    public RichInputDate getPilocationDate() {
        return pilocationDate;
    }

    public void setPiidlocationmap(RichInputText piidlocationmap) {
        this.piidlocationmap = piidlocationmap;
    }

    public RichInputText getPiidlocationmap() {
        return piidlocationmap;
    }

    public void setPiidlocationmap1(RichInputListOfValues piidlocationmap1) {
        this.piidlocationmap1 = piidlocationmap1;
    }

    public RichInputListOfValues getPiidlocationmap1() {
        return piidlocationmap1;
    }

    public void setSector(RichInputText sector) {
        this.sector = sector;
    }

    public RichInputText getSector() {
        return sector;
    }

    public void shiftVC(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getNewValue();
        Timestamp currentDate = new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println(currentDate);
       // java.sql.Date sqldate= new java.sql.Date(piDate.getTime());
       System.out.println(valueChangeEvent.getNewValue());
        String userName="";
        if(valueChangeEvent.getNewValue()!=null) {
            shift=Integer.parseInt(valueChangeEvent.getNewValue().toString()); 
            ADFContext adfctx = ADFContext.getCurrent();
            if(adfctx.getSessionScope().get("loggedinUserid")!=null){
              userName = adfctx.getSessionScope().get("loggedinUserid").toString(); 
            }
            OperationBinding operationBindings = bindings.getOperationBinding("getPisforShiftSector");
            operationBindings.getParamsMap().put("sup_id",userName);
            operationBindings.getParamsMap().put("SName",Sector);
            operationBindings.getParamsMap().put("Shift",shift);
            operationBindings.getParamsMap().put("pidate",currentDate);
            operationBindings.execute();
            
        }
       
//        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//                
//         DCIteratorBinding roleIter = bindings.findIteratorBinding("PIMonthlyDeploymentVO1Iterator");
//
//         //ViewObject obj = roleIter.getViewObject();
//        
//        
//        PIMonthlyDeploymentVOImpl vo2= (PIMonthlyDeploymentVOImpl)roleIter.getViewObject();
//         vo2.setApplyViewCriteriaName("PIMonthlyDeploymentVOCriteria");
//        vo2.setNamedWhereClauseParam("supid","Supervisor");
//       vo2.setNamedWhereClauseParam("SectorName","Sector");
//        vo2.setNamedWhereClauseParam("Shift","shift");
//       vo2.executeQuery();
       // pissupVO1Iterator
        
        
        
        
        
        
        
        
        
      
       
    }

    public void sectorVC(ValueChangeEvent valueChangeEvent) {
        
         if(valueChangeEvent.getNewValue()!=null) {
            int i=Integer.parseInt(valueChangeEvent.getNewValue().toString());
            System.out.println(i);
            DCBindingContainer bindings =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings =
                bindings.findIteratorBinding("SectorforSupVO1Iterator");
            ViewObject VO = dcItteratorBindings.getViewObject();
            SectorforSupVORowImpl voimpl=(SectorforSupVORowImpl)VO.getRowAtRangeIndex(i);
            voimpl.getsector();
            System.out.println(voimpl.getsector());
            Sector=voimpl.getsector();
        }
       
    }
   
    public void setS(RichSelectOneChoice s) {
        this.s = s;
    }

    public RichSelectOneChoice getS() {
        return s;
    }
}
