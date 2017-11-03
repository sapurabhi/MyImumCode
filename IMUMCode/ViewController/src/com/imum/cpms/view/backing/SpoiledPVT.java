package com.imum.cpms.view.backing;

import com.imum.cpms.model.transactions.vo.PVTSearchRVORowImpl;

import com.imum.cpms.util.MessageUtil;

import com.sun.xml.internal.ws.client.RequestContext;

import java.util.ArrayList;
import com.imum.ws.PVTCancellation.PVTRemovalApprovalBPMProcessPortType;
import com.imum.ws.PVTCancellation.PVTRemovalApprovalBPMProcessService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;

import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;

public class SpoiledPVT {
    private RichForm f1;
    private RichDocument d1;
    String remarks;
    private RichRegion r1;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession httpSession = (HttpSession) externalContext.getSession(false);
    MessageUtil genMsg = new MessageUtil();
    String lngCode = httpSession.getAttribute("language").toString();
    private String PVTNum ; 
    private Float Balance ;
    private Float TotalCost;
    private Long PVTsForPlate;
    private RichCommandLink filePropertyCommandLink;
    private RichCommandLink filePropertyCommandLinkphoto;

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }


    public String cb1_action() {
        // Add event code here...
        if(lngCode==null || lngCode.equals(""))
        {
            lngCode = "EN";
        }
        String result = (String)validateSubmit();
        String contraCode = null;
        Map pvtMap = new HashMap();
        if(result.equals("pass"))
        {
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =  bindingsAM.findIteratorBinding("PVTSearchRVO1Iterator");
        ViewObject spoiledPvtVO = dcItteratorBinding.getViewObject();
        Long rowCount = spoiledPvtVO.getEstimatedRowCount();
        ArrayList pvtNums = new ArrayList();
     if (rowCount > 0) {
          String userName = null;
          if (httpSession.getAttribute("loggedinUserid") == null || httpSession.getAttribute("loggedinUserid").equals("")) {                
              userName = "anonymous";
          } else {
              userName = httpSession.getAttribute("loggedinUserid").toString();
          }
          
         System.out.println("userName" + userName);
        for(int i=0; i< rowCount; i++){
            
               PVTSearchRVORowImpl searchRow=  (PVTSearchRVORowImpl) spoiledPvtVO.getRowAtRangeIndex(i);
               System.out.println("PVTHDRSEQ Number"  + searchRow.getAttribute("PVTHDRSEQ"));
               pvtNums.add(i, searchRow.getAttribute("PVTHDRSEQ"));        
               contraCode = searchRow.getAttribute("Contracode").toString();        
               pvtMap.put(searchRow.getAttribute("PVTHDRSEQ"), contraCode);
 
            }
       
                OperationBinding opBinding = bindingsAM.getOperationBinding("updateSpoiledPVT");
                opBinding.getParamsMap().put("userId", userName);
                opBinding.getParamsMap().put("pvts", pvtNums);
                opBinding.getParamsMap().put("remarks", this.getRemarks());
                opBinding.execute();
                setRemarks("");
                spoiledPvtVO.executeEmptyRowSet();
               
                OperationBinding opBinding1 = bindingsAM.getOperationBinding("getPVTRemovalStatus");
                opBinding1.getParamsMap().put("pvtMap", pvtMap);
                Map resultMap = (Map)opBinding1.execute();
                
                Iterator<Map.Entry<String,String>> it1 = pvtMap.entrySet().iterator();
                while(it1.hasNext()){
                System.out.println("Map Size" + pvtMap.size() );
                Map.Entry entry = it1.next();
                String mapPvtSeq = entry.getKey().toString();
                String mapContraCode = entry.getValue().toString();
                System.out.println("PVT Seq" + mapPvtSeq + "Contra Code" + mapContraCode);

                    // Call BPM Cancel ws if PVT is removal PVT

                    PVTRemovalApprovalBPMProcessService service = new PVTRemovalApprovalBPMProcessService();
                    PVTRemovalApprovalBPMProcessPortType type = service.getPVTRemovalApprovalBPMProcessPort();
                    type.cancelpvt(Integer.parseInt(entry.getKey().toString())); 
                    // End BPM call
                    
                }
                
                /*committing txn if everything is successful */
                OperationBinding opBinding2 = bindingsAM.getOperationBinding("doCommit");
                opBinding2.execute();
                if(opBinding2.getErrors().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sample info message", genMsg.getMessage("197", lngCode)));
                }
        } else{
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sample info message", genMsg.getMessage("198", lngCode)));
            }
        }
        return null;
    }

    public String validateSubmit()
        {
            if(lngCode==null || lngCode.equals(""))
            {
                lngCode = "EN";
            }
            String result = "pass";
            String remarks = this.getRemarks();
            if(remarks == null || remarks.equals(""))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample info message", genMsg.getMessage("196", lngCode)));    
                result = "fail";
            }
            
            return result;
        }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void showDetails(ActionEvent actionEvent) {
        // Add event code here...
            TotalCost = 0.0F;
            DCIteratorBinding binding = getBindings().findIteratorBinding("PVTSearchRVO1Iterator");            
            ADFContext.getCurrent().getPageFlowScope().put("PVTNum",binding.getCurrentRow().getAttribute("PVTNum").toString());
            System.out.println("Selected Row PVT Number is : "+binding.getCurrentRow().getAttribute("PVTNum"));
            System.out.println("Exiting action listener"); 
            
            
            
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                //get current date time with Date()
                Date date = new Date();
                System.out.println(dateFormat.format(date));

             System.out.println("PVT Details Page - Initializing - Model started "+dateFormat.format(date));
             OperationBinding getPVTbinding = getBindings().getOperationBinding("getPVTDetails");
             getPVTbinding.getParamsMap().put("PVTNum", getPVTNum());
             getPVTbinding.execute();
        
             System.out.println("PVT Details Page - Initializing - Model completed "+dateFormat.format(date));
             System.out.println("Balance computation started");
             DCIteratorBinding PVTSearchRVOIter = getBindings().findIteratorBinding("PVTSearchRVO1Iterator");
             ViewObject PVTSearchVO =  PVTSearchRVOIter.getViewObject();
             Float PVTAMTPAYABLE = Float.parseFloat(PVTSearchVO.getCurrentRow().getAttribute("PVTAMTPAYABLE")==null ? "0" :PVTSearchVO.getCurrentRow().getAttribute("PVTAMTPAYABLE").toString());
             Float PVTAMTPAID = Float.parseFloat(PVTSearchVO.getCurrentRow().getAttribute("PVTAMTPAID")== null? "0" :PVTSearchVO.getCurrentRow().getAttribute("PVTAMTPAID").toString());
        
             Balance = PVTAMTPAYABLE-PVTAMTPAID;
        
             System.out.println("initializing customer info - Done "+dateFormat.format(date));
             System.out.println("initializing Charges info - started "+dateFormat.format(date));
             DCIteratorBinding ChargesVOIter = getBindings().findIteratorBinding("PVTCategorizedChargesRVO1Iterator");
             Row[] allRowsInRange = ChargesVOIter.getAllRowsInRange();
             TotalCost= Float.parseFloat(PVTSearchVO.first().getAttribute("CONTRAAMT")==null? "0" :PVTSearchVO.first().getAttribute("CONTRAAMT").toString());
             TotalCost-= Float.parseFloat(PVTSearchVO.first().getAttribute("Discountamt")==null? "0" :PVTSearchVO.first().getAttribute("Discountamt").toString());
        
             for(Row curRow : allRowsInRange)
                 TotalCost+= Float.parseFloat(curRow.getAttribute("ChargeAmount")==null? "0" :curRow.getAttribute("ChargeAmount").toString());
        
             setTotalCost(TotalCost);
        
             System.out.println("initializing Charges info - Done "+dateFormat.format(date));
             System.out.println("Count of PVTs for vehicle - started "+dateFormat.format(date));
             OperationBinding binding1 = getBindings().getOperationBinding("getPVTCountForVehicle");
             binding1.getParamsMap().put("PVTNum", getPVTNum());
             binding1.execute();
             System.out.println("Count of PVTs for vehicle - Done "+dateFormat.format(date));
        //        binding1.getResult().toString();
        //        Long.parseLong(binding1.getResult().toString());
              setPVTsForPlate(Long.parseLong(binding1.getResult().toString()));
             System.out.println("PVTs For This Plate : "+PVTsForPlate );
            
            
       
    }
    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String cb2_action() {
        DCBindingContainer bindingsAM = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBinding =  bindingsAM.findIteratorBinding("PVTSearchRVO1Iterator");
        ViewObject spoiledPvtVO = dcItteratorBinding.getViewObject();
        spoiledPvtVO.executeEmptyRowSet();        
        return null;
    }

    public void setPVTNum(String PVTNum) {
        this.PVTNum = PVTNum;
    }

    public String getPVTNum() {
        return  ADFContext.getCurrent().getPageFlowScope().get("PVTNum").toString();
    }

    public void setBalance(Float Balance) {
        this.Balance = Balance;
    }

    public Float getBalance() {
        return Balance;
    }

    public void setTotalCost(Float TotalCost) {
        this.TotalCost = TotalCost;
    }

    public Float getTotalCost() {
        return TotalCost;
    }

    public void setPVTsForPlate(Long PVTsForPlate) {
        this.PVTsForPlate = PVTsForPlate;
    }

    public Long getPVTsForPlate() {
        return PVTsForPlate;
    }

    public void setFilePropertyCommandLink(RichCommandLink filePropertyCommandLink) {
        this.filePropertyCommandLink = filePropertyCommandLink;
    }

    public RichCommandLink getFilePropertyCommandLink() {
        return filePropertyCommandLink;
    }

    public void setFilePropertyCommandLinkphoto(RichCommandLink filePropertyCommandLinkphoto) {
        this.filePropertyCommandLinkphoto = filePropertyCommandLinkphoto;
    }

    public RichCommandLink getFilePropertyCommandLinkphoto() {
        return filePropertyCommandLinkphoto;
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
    
    
    public void ResetSearchPage(QueryOperationEvent queryOperationEvent) {
          invokeMethodExpression("#{bindings.PVTSpoiledPVTSearchRVOCriteriaQuery2.processQueryOperation}",
        Object.class,   
                                 new Class[]{ QueryOperationEvent.class},  
                                 new Object [] {queryOperationEvent});
          
          if(queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")){
              getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().executeEmptyRowSet();
    
            }
  }
    
    public Object invokeMethodExpression(String expr, Class returnType,  
                                           Class[] argTypes, Object[] args)  
      {  
        FacesContext fc = FacesContext.getCurrentInstance();  
        ELContext elctx = fc.getELContext();  
        ExpressionFactory elFactory =  
          fc.getApplication().getExpressionFactory();
    //        ExpressionFactory expressionFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr =  
          elFactory.createMethodExpression(elctx, expr, returnType, argTypes);  
        return methodExpr.invoke(elctx, args);  
      }
}
