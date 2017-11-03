package com.imum.cpms.transactions.pvt;

import com.imum.cpms.util.PropertiesBeanUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;


import java.util.HashSet;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.sql.DataSource;

import oracle.adf.share.logging.ADFLogger;

public class PVTImagesExtractBean {
    private String message;
    public static final ADFLogger logger = ADFLogger.createADFLogger(PVTImagesExtractBean.class);
    
    public PVTImagesExtractBean() {
    }

//    public Connection getConnection(){
//        Connection con =null;
//        try{
//            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //con = DriverManager.getConnection("jdbc:sqlserver://192.168.200.100:1433;databaseName=CPMSPROD;username=cpmsuser;password=cpms@user1");
//            Class.forName(PropertiesBeanUtils.getValue("DRIVER_CLASS"));
//            con = DriverManager.getConnection(PropertiesBeanUtils.getValue("DATABASE_HOST"));
//
//        }
//        catch(Exception e){
//            
//        }
//        return con;
//    }
    public String insertPvtImages(){
        String messageStr = null;
        try{
            setMessage(null);
            Connection con = getConnection(); 
            HashSet  duplicatePVT = new HashSet();
//            String  qry = "select a.PVTNumber, a.PhotoContent, a.PhotoCaption, b.PVT_HDR_SEQ, b.PVT_date_time, b.Created_By, b.Created_Date\n" + 
//            "from cpmshhapp.imumserver.dbo.trn_vehiclephoto a\n" + 
//            "join PVT_Header b\n" + 
//            "on a.PVTNumber = b.PVT_Num collate SQL_Latin1_General_CP1_CI_AS";
            
         
     String qry = "  select a.PVTNumber, a.PhotoContent, a.PhotoCaption, c.PVT_HDR_SEQ, c.PVT_date_time, c.Created_By, c.Created_Date, d.ID" +
                  "  from CPMSHHDB.iMUMServer.dbo.trn_vehiclephoto a, CPMSHHDB.iMUMServer.dbo.PVTPushTracker b, PVT_Header c, CPMSHHDB.iMUMServer.dbo.Web_TicketCreation d " +
                  "  where b.PhotoPushStatus = 0 and b.TicketID = d.id and c.PVT_Num = d.TicketNumbr collate SQL_Latin1_General_CP1_CI_AS " +
                  "  and a.PVTNumber = c.PVT_Num   collate SQL_Latin1_General_CP1_CI_AS"; 
            
            
/*          String qry = "Select a.PVTNumber, a.PhotoContent, a.PhotoCaption, c.PVT_HDR_SEQ, c.PVT_date_time, c.Created_By, c.Created_Date " +
                         "  From trn_vehiclephoto a, PVT_Header c " +
                         "  Where c.PVT_Num  IN('AD10004224') " +
                         "  and a.PVTNumber = c.PVT_Num";   */
            
            System.out.println("qry   : :::::::::::::::::      "+qry);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);  
            String PVTNumber = "";
            String PVT_HDR_SEQ = "";
            String PhotoContent = "";
            String PhotoCaption = "";
            String PVT_date_time = "";
            String Created_By = "";
            String Created_Date = "";
            String id = "";
            String defaultPath = "//cpmsshare//1//PVT";
            String finalPath = "";
            InputStream is = null;
            FileOutputStream fos=null;
            String dirname = "";
            int imageSize = 0;
            while(rs.next()){
                
                PVTNumber = rs.getString("PVTNumber") ;
                duplicatePVT.add(PVTNumber);
                PVT_HDR_SEQ = rs.getString("PVT_HDR_SEQ") ;
                PhotoCaption = rs.getString("PhotoCaption") ;
                PVT_date_time = rs.getString("PVT_date_time") ;
                Created_By = rs.getString("Created_By") ;
                Created_Date = rs.getString("Created_Date") ;
                id = rs.getString("ID");
                PVT_date_time = PVT_date_time.substring(0, 8).replaceAll("-", "");
                System.out.println("PVT_date_time"+PVT_date_time);
                finalPath = defaultPath+"//"+PVT_date_time+"//"+PVTNumber;
                boolean f = new File(finalPath).mkdir(); 
                String filename = rs.getString("PhotoCaption");
                Blob blob = rs.getBlob("PhotoContent");
                is = blob.getBinaryStream();  
                fos = new FileOutputStream(finalPath+"//"+filename+".jpg");
                finalPath = finalPath + "//"+filename+".jpg";
                logger.info("  finalPath     ::::::::::   "+finalPath); 
              
                int b = 0;   
                while ((b = is.read()) != -1)   
                {   
                    fos.write(b);    
                } 
                imageSize ++;
                fos.close();
                String qry1 = "insert into PVT_DOCS (PVT_HDR_SEQ,doc_type,remarks,Doc_stage,file_path,Created_By,Created_Date,DOC_Desc) values ("+PVT_HDR_SEQ+",2,'"+PhotoCaption+"',3,'"+finalPath+"','"+Created_By+"','"+Created_Date+"','"+PhotoCaption+"')  ";
                String qry2 = "Update CPMSHHDB.iMUMServer.dbo.PVTPushTracker set PhotoPushStatus = 1 Where TicketID = "+ id +" ";
                logger.info("qry1    ::::::::::         "+qry1);
                logger.info("qry2    ::::::::::         "+qry2);
                System.out.println("qry1"+qry1);
                Statement st1 = con.createStatement();
                st1.executeUpdate(qry1); 
                st1.executeUpdate(qry2); 
            }
            messageStr ="No of PVT's processed "+duplicatePVT.size()+"            And No of Images processed    "+imageSize; 
            con.close();
        }
        catch(SQLException e){
            messageStr="SQL Exception Occured ::::  "+e.getMessage();
            System.out.println("SQL Exception Occured"+e.getMessage());
            logger.info("Exception" +e);
        }
        catch(IOException e){
            messageStr="IO Exception Occured ::::  "+e.getMessage();
            System.out.println("IO Exception Occured"+e.getMessage());
            logger.info("Exception" +e);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
        setMessage(messageStr);
        return messageStr;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
       //Data source connectivity
          private Connection getConnection() {
               Connection connection = null;
               try {
                   InitialContext context = new InitialContext();
                   DataSource dataSource = (DataSource) context.lookup("jdbc/ADFDS");
                   connection = dataSource.getConnection();
                 } catch (NamingException e) {
                   e.printStackTrace();
                 } catch (SQLException e) {
                   e.printStackTrace();
               }
               return connection;
               }
    
    
}

