package com.imum.cpms;

import com.imum.cpms.model.transactions.am.TransactionsAMImpl;

import com.imum.cpms.model.transactions.vo.PVTCategorizedChargesRVOImpl;
import com.imum.cpms.model.transactions.vo.PVTCategorizedChargesRVORowImpl;
import com.imum.cpms.model.transactions.vo.PVTHeaderVOImpl;
import com.imum.cpms.model.transactions.vo.PVTSearchRVOImpl;

import com.imum.cpms.model.transactions.vo.PVTSearchRVORowImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Iterator;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCDataControl;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.jbo.VariableValueManager;
        import java.util.List;
import java.util.StringTokenizer;

import javax.el.ELContext;
        import javax.el.ExpressionFactory;
        import
        javax.el.MethodExpression;
        import javax.faces.application.FacesMessage;
        import javax.faces.context.FacesContext;
        import oracle.adf.view.rich.event.QueryEvent;
        import oracle.adf.view.rich.model.AttributeCriterion;

import oracle.adf.view.rich.model.AttributeDescriptor;
import oracle.adf.view.rich.model.ConjunctionCriterion;
import oracle.adf.view.rich.model.Criterion;
import oracle.adf.view.rich.model.QueryDescriptor;

import oracle.jbo.Key;
import oracle.jbo.RowSetIterator;

import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class PVTDetailsMBean {
    private String PVTNum ; 
    private Float Balance ;
    private Float TotalCost;
    private Long PVTsForPlate;
    private RichCommandLink filePropertyCommandLink;
    private RichCommandLink filePropertyCommandLinkphoto;

/** Default Constructor*/
    public PVTDetailsMBean() {}


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
    
    public void setFilePropertyCommandLink(RichCommandLink filePropertyCommandLink) {
        this.filePropertyCommandLink = filePropertyCommandLink;
    }

    public RichCommandLink getFilePropertyCommandLink() {
        return filePropertyCommandLink;
    }


    
    

    private DCBindingContainer getBindings() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setPVTNum(String PVTNum) {
        this.PVTNum = PVTNum;
    }

    public String getPVTNum() {
        return ADFContext.getCurrent().getPageFlowScope().get("PVTNum").toString();
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

    public void setFilePropertyCommandLinkphoto(RichCommandLink filePropertyCommandLinkphoto) {
        this.filePropertyCommandLinkphoto = filePropertyCommandLinkphoto;
    }

    public RichCommandLink getFilePropertyCommandLinkphoto() {
        return filePropertyCommandLinkphoto;
    }

   
    
    private RichTable pvTSearchResultTable;

       
    public void updateSelectedPVTNum(ActionEvent actionEvent){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                       //get current date time with Date()
                       Date date = new Date();
                       System.out.println(dateFormat.format(date));
                    DCIteratorBinding binding = getBindings().findIteratorBinding("PVTSearchRVO1Iterator1");
                    
                    ADFContext.getCurrent().getPageFlowScope().put("PVTNum",binding.getCurrentRow().getAttribute("PVTNum").toString());
                    System.out.println("Selected Row PVT Number is : "+binding.getCurrentRow().getAttribute("PVTNum"));
                    System.out.println("Exiting action listener "+dateFormat.format(date));
                 
      
                    System.out.println("PVT Details Page - Initializing - Model started "+dateFormat.format(date));
                    OperationBinding getPVTbinding = getBindings().getOperationBinding("getPVTDetails");
                    getPVTbinding.getParamsMap().put("PVTNum", getPVTNum());
                    getPVTbinding.execute();
                    
                    DCIteratorBinding ChargesVOIter = getBindings().findIteratorBinding("PVTCategorizedChargesRVO1Iterator");
                    Row[] allRowsInRange = ChargesVOIter.getAllRowsInRange();
                    RowKeySet selectedEmps = getPvTSearchResultTable().getSelectedRowKeys();   
                    Iterator selectedEmpIter = selectedEmps.iterator();
                    DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding empIter = bindings.findIteratorBinding("PVTSearchRVO1Iterator1");
                    RowSetIterator empRSIter = empIter.getRowSetIterator();
                     while(selectedEmpIter.hasNext()){
                       Key key = (Key)((List)selectedEmpIter.next()).get(0);
                       Row row = empRSIter.getRow(key);
                       System.out.println("row is " + row.getAttribute("CONTRAAMT") + row.getAttribute("Discountamt"));
                         TotalCost= Float.parseFloat(row.getAttribute("CONTRAAMT")==null? "0" :row.getAttribute("CONTRAAMT").toString());
                         TotalCost-= Float.parseFloat(row.getAttribute("Discountamt")==null? "0" :row.getAttribute("Discountamt").toString());
                         
                         for(Row curRow : allRowsInRange)
                             TotalCost+= Float.parseFloat(curRow.getAttribute("ChargeAmount")==null? "0" :curRow.getAttribute("ChargeAmount").toString());
                         
                         setTotalCost(TotalCost);
                     }

                    
            
                    System.out.println("PVT Details Page - Initializing - Model completed "+dateFormat.format(date));
                    System.out.println("Balance computation started");
                    DCIteratorBinding PVTSearchRVOIter = getBindings().findIteratorBinding("PVTSearchRVO1Iterator1");
                    ViewObject PVTSearchVO =  PVTSearchRVOIter.getViewObject();
                    Float PVTAMTPAYABLE = Float.parseFloat(PVTSearchVO.first().getAttribute("PVTAMTPAYABLE")==null ? "0" :PVTSearchVO.first().getAttribute("PVTAMTPAYABLE").toString());
                    Float PVTAMTPAID = Float.parseFloat(PVTSearchVO.first().getAttribute("PVTAMTPAID")==null? "0" :PVTSearchVO.first().getAttribute("PVTAMTPAID").toString());
            
                    Balance = PVTAMTPAYABLE-PVTAMTPAID;
            
                    System.out.println("initializing customer info - Done "+dateFormat.format(date));
                    System.out.println("initializing Charges info - started "+dateFormat.format(date));
/*                     DCIteratorBinding ChargesVOIter = getBindings().findIteratorBinding("PVTCategorizedChargesRVO1Iterator");
                    Row[] allRowsInRange = ChargesVOIter.getAllRowsInRange();
           
                    TotalCost= Float.parseFloat(binding.getCurrentRow().getAttribute("CONTRAAMT")==null? "0" :binding.getCurrentRow().getAttribute("CONTRAAMT").toString());
                    TotalCost-= Float.parseFloat(binding.getCurrentRow().getAttribute("Discountamt")==null? "0" :binding.getCurrentRow().getAttribute("Discountamt").toString());
            
                    for(Row curRow : allRowsInRange)
                        TotalCost+= Float.parseFloat(curRow.getAttribute("ChargeAmount")==null? "0" :curRow.getAttribute("ChargeAmount").toString());
            
                    setTotalCost(TotalCost);
         */    
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
    
    public void ResetSearchPage(QueryOperationEvent queryOperationEvent) {
          invokeMethodExpression("#{bindings.PVTSearchRVOCriteriaQuery.processQueryOperation}",
        Object.class,   
                                 new Class[]{ QueryOperationEvent.class},  
                                 new Object [] {queryOperationEvent});
          
          if(queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")){
              getBindings().findIteratorBinding("PVTSearchRVO1Iterator1").getViewObject().executeEmptyRowSet();
    //              AdfFacesContext.getCurrentInstance().addPartialTarget((UIComponent)getPvTSearchResultTable);
    //                  resId1
            }
        
        // Add event code here...
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

    public void setPvTSearchResultTable(RichTable pvTSearchResultTable) {
        this.pvTSearchResultTable = pvTSearchResultTable;
    }

    public RichTable getPvTSearchResultTable() {
        return pvTSearchResultTable;
    }

    public void ValidatePVTFormat(QueryEvent queryEvent) {
        // Add event code here...
       
      
       
        //method ref
        
    
     
       String PVTNumber = null;
       String firstLetter = null;
       String lastletter = null;
       String PVTSubString = null;
      
       String s = "^\\d*[%AD0-9%][AD0-9]*$";
       
        QueryDescriptor qdesc =
       
       
        (QueryDescriptor)queryEvent.getDescriptor();
        ConjunctionCriterion conCrit = qdesc.getConjunctionCriterion();
        //access the list of search fields
        List<Criterion> criterionList = conCrit.getCriterionList();
        //iterate over the attributes to find FromDate and ToDate
        for (Criterion criterion : criterionList) { AttributeDescriptor attrDescriptor =
        ((AttributeCriterion)criterion).getAttribute();
        if (attrDescriptor.getName().
        equalsIgnoreCase("PVTNum")) {PVTNumber =(String)((AttributeCriterion)criterion).getValues().get(0);
            if(PVTNumber.length() > 3)
            {
            firstLetter = String.valueOf(PVTNumber.charAt(0));
            lastletter = String.valueOf(PVTNumber.charAt(PVTNumber.length() - 1));
             PVTSubString = PVTNumber.substring(1, PVTNumber.length()-2);
            }

        }
        }
       
        //startDate must be lower than end date
        if (PVTNumber != null)
       
     {
       if(PVTNumber.indexOf("%")!=-1)
        {
       if(firstLetter.indexOf("%")!=-1 || lastletter.indexOf("%")!=-1   ) {
       if(PVTSubString.indexOf("%")!=-1) {
           FacesContext fctx = FacesContext.getCurrentInstance();
           fctx.addMessage("VacationQueryComponent",new FacesMessage(FacesMessage.SEVERITY_ERROR," From Dat","Please enter % either in the first or last character"));
           //immediately render response if ToDate is lower than
           
           fctx.renderResponse();
       }
       else
       {
           
           invokeMethodExpression("#{bindings.PVTSearchRVOCriteriaQuery1.processQuery}",
           Object.class,
                                  new Class[]{QueryEvent.class},  
                                  new Object [] {queryEvent});
       }
       }
            else
            {
             FacesContext fctx = FacesContext.getCurrentInstance();
             fctx.addMessage("VacationQueryComponent",new FacesMessage(FacesMessage.SEVERITY_ERROR," From Dat","Please enter % either in the first or last character"));
             //immediately render response if ToDate is lower than
            
             fctx.renderResponse();
            }
     
        
        }
       else {
           if(PVTNumber .length() >= 10)
           {
           
           invokeMethodExpression("#{bindings.PVTSearchRVOCriteriaQuery1.processQuery}",
           Object.class,
                                  new Class[]{QueryEvent.class},  
                                  new Object [] {queryEvent});
           }
           else {
               FacesContext fctx = FacesContext.getCurrentInstance();
               fctx.addMessage("VacationQueryComponent",new FacesMessage(FacesMessage.SEVERITY_ERROR," From Dat","Please enter correct pvt Number"));
               //immediately render response if ToDate is lower than
               
               fctx.renderResponse();
           }
       }
               
            }}
            public void invokeMethodExpression(String expr,
            QueryEvent queryEvent) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            ELContext elContext = fctx.getELContext();

            }
        
        //


    public String map() {
       System.out.println("hiiiiiiiiiiiiiiiiiiii");
       String lon;
       String lat;
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks =
            Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
        
        Row newRow = getBindings().findIteratorBinding("PVTSearchRVO1Iterator").getViewObject().getCurrentRow();
        System.out.println(newRow.getAttribute("PVTVHCLgeolon"));
        System.out.println(newRow.getAttribute("PVTVHCLgeolat"));
        if(newRow.getAttribute("PVTVHCLgeolon")!=null &&newRow.getAttribute("PVTVHCLgeolon")!="") {
            lon=res(newRow.getAttribute("PVTVHCLgeolon").toString());
            System.out.println(lon);
            
           // lat=res("2429.76585"); 
        }
        else {
            lon="-";
        }
        if(newRow.getAttribute("PVTVHCLgeolat")!=null && newRow.getAttribute("PVTVHCLgeolat")!="") {
            
            lat=res(newRow.getAttribute("PVTVHCLgeolat").toString()); 
            System.out.println(lat);
           
        }
        else {
            lat="-";
        }
        if(lon.equals("-")){
            erks.addScript(fctx,"var long1 =0;");
            erks.addScript(fctx,"var lat1 =0;");
            erks.addScript(fctx,"alert('Longitude and Lattitude are not available for this PVT')");
            
        }
        else{
            erks.addScript(fctx,"var long1 ="+lon+";");
            erks.addScript(fctx,"var lat1 ="+lat+";");
                
        }
        
//        if(newRow.getAttribute("PVTVHCLgeolon")!=null) {
//               erks.addScript(fctx,"long.push("+lat+")");
//       }
//       if(newRow.getAttribute("PVTVHCLgeolat")!=null) {
//             erks.addScript(fctx,"lat.push("+lon+")");     
//          }
          
        erks.addScript(fctx,"loadMap(long1,lat1)");
          
//        Row newRow = getBindings().findIteratorBinding("PVTSearchRVO1Iterator1").getViewObject().getCurrentRow();
////        DCIteratorBinding binding = getBindings().findIteratorBinding("PVTSearchRVO1Iterator1");
////       
////        ViewObject PVTSearchVO =  binding.getViewObject();
////        Row r=PVTSearchVO.getCurrentRow();
//       
//      System.out.println(newRow.getAttribute("PVTVHCLgeolat"));
//        System.out.println(newRow.getAttribute("PVTVHCLgeolon"));
       
        return null;
    }
    
    
    
    public String res(String s ) {
        String grados = null;
        String str = "";
        String minutos = null;
     
        StringTokenizer st1 = new StringTokenizer(s, ".");
        String str1 = st1.nextToken();
      //  System.out.println(str1);
      //  System.out.println(str1.length());
        if (str1.length() == 4) {
            grados = s.substring(0, 2);
          //  System.out.println(grados);
            minutos = s.substring(2, s.length());
         //   System.out.println(minutos);
            // String res=removeChar(minutos,'.');
            StringTokenizer st = new StringTokenizer(minutos, ".");
            while (st.hasMoreTokens()) {
                str = str.concat(st.nextToken());
            }
            int num = Integer.parseInt(str);
            int f = Math.round(num / 60);
           // System.out.println(f);
           // System.out.println(grados + "." + f);
            return grados + "." + f;
        } else {
            return s;
        }
     

    } 
}
