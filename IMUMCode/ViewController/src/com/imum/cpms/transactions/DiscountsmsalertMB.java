package com.imum.cpms.transactions;

import com.imum.cpms.model.transactions.vo.PVTDiscCnclDetailVORowImpl;

import java.sql.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.binding.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.ADFUtil;

public class DiscountsmsalertMB {
    private RichTable tablebind;
    private RichInputText seq;
    DCBindingContainer bindingsAM =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    private RichInputText pvtno;
    private RichTable pvtsearchtable;
    private RichSelectOneChoice sectorlov;
    private RichSelectOneChoice zonelov;
    private RichSelectOneChoice contracodelov;
    private RichCommandButton save;
    private Boolean vis=false;
    private Boolean vis2=false;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    String lngCode = httpSession.getAttribute("language").toString();
    String userName = httpSession.getAttribute("loggedinUserid").toString();
      public DiscountsmsalertMB() {
        
    }

    public void search(ActionEvent actionEvent) {
       // int seq1=seq.getValue();
        System.out.println("---------------");
        String  pvtnumber=null;
        Object contracode=null;
        Object sectorcode=null;
        Object zonecode=null;
        DCIteratorBinding dc2 = bindingsAM.findIteratorBinding("PVTHeadersmsVO1Iterator");
        ViewObject pvtsearch = dc2.getViewObject();
        if(pvtno.getValue()!=null) {
            Object ob=pvtno.getValue();
            if(ob.equals(""))
                pvtnumber=null;
            else    
            pvtnumber=pvtno.getValue().toString();
        }
        DCIteratorBinding dc3 = bindingsAM.findIteratorBinding("PVTdissmsVO1Iterator");
        ViewObject psector = dc3.getViewObject(); 
        Row r=psector.getCurrentRow();        
        if(r.getAttribute("SectorCode")!=null) {
             sectorcode = r.getAttribute("SectorCode");  
        }
       // if(zonelov.getValue()!=null) {
        if(r.getAttribute("zonecode")!=null){
            
             zonecode=r.getAttribute("zonecode");    
        }
       // if(contracodelov.getValue()!=null &&contracodelov.getValue()!=0) {
        if(r.getAttribute("Contracode")!=null){
         contracode=r.getAttribute("Contracode");
        }
        
        Object sequence=seq.getValue();
        String seq1=null;
        if(sequence!=null) {
         //seq1=sequence.toString();
         if(sequence.equals(""))
             sequence=null;
        }
        //seq number serach
       if(sequence!=null)
       {
           BindingContainer bindings1 = getBindings();
           OperationBinding opBinding =bindings1.getOperationBinding("pvtdiscountsearch");
           opBinding.getParamsMap().put("seq",seq.getValue());
           opBinding.getParamsMap().put("sector",sectorcode);
           opBinding.getParamsMap().put("zone",zonecode);
           opBinding.getParamsMap().put("pvtnum",pvtnumber);
           opBinding.getParamsMap().put("contracode",contracode);
           Object ob=opBinding.execute();  
           if(ob!=null) {
               if(ob.toString().equals("N"))
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No Data Found Please Redefine Your Search Crieteria ",null));
                   
           }
           tablebind.setVisible(true);
           tablebind.setRendered(true);
           pvtsearchtable.setVisible(false);
            pvtsearchtable.setRendered(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(tablebind);
           setVis(true);
           setVis2(false);
       }
       else
       {
           if(sectorcode!=null || zonecode!=null || pvtnumber!=null || contracode!=null)
           {
           BindingContainer bindings1 = getBindings();
           OperationBinding opBinding =bindings1.getOperationBinding("pvtSearch");
           opBinding.getParamsMap().put("sector",sectorcode);
           opBinding.getParamsMap().put("zone",zonecode);
           opBinding.getParamsMap().put("pvtnum",pvtnumber);
           opBinding.getParamsMap().put("contracode",contracode);
           Object ob=opBinding.execute();  
               if(ob!=null) {
                   if(ob.toString().equals("N"))
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No Data Found Please Redefine Your Search Crieteria ",null));
                       
               }
           pvtsearchtable.setVisible(true);
           pvtsearchtable.setRendered(true);
           tablebind.setVisible(false);
           tablebind.setRendered(false);
               setVis(true);
               setVis2(true);
           }
           else {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Enter/Select Search ",null));
           }
          
       }
           
           
         
           
    }
    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public void setTablebind(RichTable tablebind) {
        this.tablebind = tablebind;
    }

    public RichTable getTablebind() {
        return tablebind;
    }

    public void setSeq(RichInputText seq) {
        this.seq = seq;
    }

    public RichInputText getSeq() {
        return seq;
    }

    public String smsSave() {
       
       
       
       
       
       
       
        return null;
    }

    public void setPvtno(RichInputText pvtno) {
        this.pvtno = pvtno;
    }

    public RichInputText getPvtno() {
        return pvtno;
    }

    public void setPvtsearchtable(RichTable pvtsearchtable) {
        this.pvtsearchtable = pvtsearchtable;
    }

    public RichTable getPvtsearchtable() {
        return pvtsearchtable;
    }

    public String Cancel() {
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTHeadersmsVO1Iterator");
        ViewObject pvtheader = dcIteratorBinding.getViewObject();
        pvtheader.clearCache();
        DCIteratorBinding dcIteratorBinding1 = bindingsAM.findIteratorBinding("discountsearchVO1Iterator");
        ViewObject discount = dcIteratorBinding1.getViewObject();
        discount.clearCache();
        pvtsearchtable.setRendered(false);
        tablebind.setRendered(false);
        pvtsearchtable.getSelectedRowKeys().clear();
        AdfFacesContext.getCurrentInstance().addPartialTarget(tablebind);
        return null;
    }

    public void setSectorlov(RichSelectOneChoice sectorlov) {
        this.sectorlov = sectorlov;
    }

    public RichSelectOneChoice getSectorlov() {
        return sectorlov;
    }

    public void setZonelov(RichSelectOneChoice zonelov) {
        this.zonelov = zonelov;
    }

    public RichSelectOneChoice getZonelov() {
        return zonelov;
    }

    public void setContracodelov(RichSelectOneChoice contracodelov) {
        this.contracodelov = contracodelov;
    }

    public RichSelectOneChoice getContracodelov() {
        return contracodelov;
    }


    public void save(ActionEvent actionEvent) {
        
        DCIteratorBinding dcIteratorBinding = bindingsAM.findIteratorBinding("PVTHeadersmsVO1Iterator");
        ViewObject pvtrowsVO= dcIteratorBinding.getViewObject();
        Row[] allrows= pvtrowsVO.getAllRowsInRange();
        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        for(int i=0;i<allrows.length;i++) {
           Object st=allrows[i].getAttribute("CheckRowStatus");
            if(st!=null)
            {
         if(Integer.parseInt(st.toString())==2) {
             allrows[i].setAttribute("Updateddate",sqlDate);
             allrows[i].setAttribute("Updatedby", userName);
         }
            }
            
        }
        BindingContainer bindings1 = getBindings();
        OperationBinding op =bindings1.getOperationBinding("doCommit");
        op.execute();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Details saved Successfully",null));
        pvtsearchtable.setRendered(false);
        tablebind.setRendered(false);
        pvtsearchtable.getSelectedRowKeys().clear();
        AdfFacesContext.getCurrentInstance().addPartialTarget(tablebind);
        setVis(false);
    }

    public void setVis(Boolean vis) {
        this.vis = vis;
    }

    public Boolean getVis() {
        return vis;
    }

    public void setVis2(Boolean vis2) {
        this.vis2 = vis2;
    }

    public Boolean getVis2() {
        return vis2;
    }
}
