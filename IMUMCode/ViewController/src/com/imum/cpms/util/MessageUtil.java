package com.imum.cpms.util;


import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import javax.faces.context.FacesContext;
import javax.el.ExpressionFactory;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.application.Application;

import oracle.adf.share.logging.ADFLogger;


public class MessageUtil {
    public MessageUtil() {
        super();
    }
    
    public static final ADFLogger logger = ADFLogger.createADFLogger(MessageUtil.class);
     
    public String getMessage(String msgCode, String lng)
    {
        String msg =  null;
        Connection con = null;
        if(lng==null)lng = "EN" ;
        try
        {
            if(lng.equals("EN"))
            {
                msg = getEnglishMessage(msgCode);         
            }
           else if(lng.equals("AR"))
            {
                // need to code 
                String query = "SELECT MSG_DESC FROM GEN_MSG_MST_LNG WHERE MSG_SEQ="+ msgCode +"";
                 con = getConnection(); 
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query); 
                while(rs.next()){
                   msg = rs.getString("MSG_DESC");
                }
            }
        }catch(Exception e)
        {
            logger.info("Generic Message : getMessage Exception : "+e.getMessage());
            }finally{
            try{
                if(con!=null)
                {
                   con.close(); 
                }
                }catch(Exception e){
                logger.info("Generic Message finally : getMessage Exception : "+e.getMessage());
                }
            }
        return msg;
    }

    
    public String getEnglishMessage(String msgCode)
    {
        String msg = null;
        String query = "SELECT MSG_DESC FROM GEN_MSG_MST WHERE MSG_SEQ="+ msgCode +"";
        Connection con = getConnection(); 
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            while(rs.next()){
               msg = rs.getString("MSG_DESC");
            }
        } catch(Exception e)
        {
            logger.info("Generic Message : getMessage Exception : "+e.getMessage());
            }finally{
            try{
                if(con!=null)
                {
                   con.close(); 
                }
                }catch(Exception e){
                    logger.info("Generic Message finally : getMessage Exception : "+e.getMessage());
                }
            }
        return msg;
    }
    
//    public Connection getConnection(){
//        Connection con =null;
//        try{
//            Class.forName(PropertiesBeanUtils.getValue("DRIVER_CLASS"));
//            con = DriverManager.getConnection(PropertiesBeanUtils.getValue("DATABASE_HOST"));
//            }
//        catch(Exception e){
//            
//        }
//        return con;
//    }
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
