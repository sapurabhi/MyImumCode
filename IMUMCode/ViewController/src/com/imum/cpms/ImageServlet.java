package com.imum.cpms;



import javax.servlet.http.HttpServlet;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.math.BigDecimal;

import java.sql.Blob;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.sql.DataSource;

import oracle.jbo.Row;

import org.apache.myfaces.trinidad.ADFUtil;

public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ImageServlet() {
        super();
    }
    private static final String CONTENT_TYPE = "image/gif; charset=utf-8";

        public void init(ServletConfig config) throws ServletException {
            super.init(config);
        }

        public void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,
                                                               IOException {
            
            String path = request.getContextPath().toString();
            
            System.out.println("path"+path);
                
            response.setContentType(CONTENT_TYPE);
            String PIId = request.getParameter("id");
             //String PIId = "D://images//Desert.jpg";
           
            System.out.println("pvtHdrSeq"+PIId);
            //String fileName = "//cpmsshare//PIProfile//PIPhoto//+"//+PIId;
            OutputStream os = response.getOutputStream();
//            Connection conn = null;
    
       
        try {
            File filed = new File(PIId);
            FileInputStream fis;
            byte[] b;
            fis = new FileInputStream(filed);
            int n;
            while ((n = fis.available()) > 0) {
                b = new byte[n];
                int result = fis.read(b);
                os.write(b, 0, b.length);
                if (result == -1){
                    break;
                }
                    os.close();
           // }
            }
        } catch (IOException e)  {
                System.out.println(e);
            } 
        catch(Exception e){
            System.out.println(e);
        }
    }        
    public Connection getDBConnection(){
         Connection con =null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://192.168.200.111:1433;databaseName=CPMSGCT;username=cpmsuser;password=cpms@user1");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
       return con;
    }
    
}