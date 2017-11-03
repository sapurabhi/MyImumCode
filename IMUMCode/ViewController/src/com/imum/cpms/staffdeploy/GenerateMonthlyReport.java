package com.imum.cpms.staffdeploy;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class GenerateMonthlyReport {
    String qry1 = "";
    public GenerateMonthlyReport() {
        super();
    }
    public Connection getConnection(){
           Connection con =null;
           try{
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               con = DriverManager.getConnection("jdbc:sqlserver://192.168.200.111:1433;databaseName=CPMSGCT;username=cpmsuser;password=cpms@user1");
               //con = DriverManager.getConnection("jdbc:sqlserver://10.56.170.141:1433;databaseName=practice;username=sa;password=imum123$");
             
           }
           catch(Exception e){
               
           }
           return con;
       }
    public void callReport(String strtdate,String enddate,int shift){
           synchronized(this){
                createTableColumns();
               selectValues(strtdate,enddate,shift);
               checkPiOnLeaveDates(strtdate,enddate,shift);
           }
       }
    public boolean isTableExist(){
           boolean tableExists = false;
           try{
           Connection conn = getConnection();
           ResultSet rset = conn.getMetaData().getTables(null, null, "pireport", null);
               String dropQry = "drop table pireport";
               Statement st = conn.createStatement();
           if (rset.next())
           {
             
             st.execute(dropQry);
             conn.commit();
            // tableExists = true;
             
           }
           }
           catch(Exception e){
               e.printStackTrace();
           }
           System.out.println(tableExists);
           return tableExists;
       }
    public void createTableColumns(){
           try{
               if(!isTableExist()){
               ArrayList list = new ArrayList();
               Connection con = getConnection();
               String dropTable = "drop table pireport";
               String columnQry = "select DISTINCT (ss.Sector+ ' - ' +gz.Zone_Name) as zone \n" + 
               "from Sup_Alloc sa\n" + 
               "inner join Sup_Shift_Sector_Alloc ss\n" + 
               "on sa.Alloc_id=ss.Alloc_id\n" + 
               "inner join GEN_Zone_Mst gz\n" + 
               "on gz.Sector_Code=ss.Sector\n" + 
               "where sA.Sup_id='Supervisor1'\n";
               if(!isTableExist()){
                  // Statement st2 = con.createStatement();
                   //st2.execute(dropTable);
               Statement st1 = con.createStatement();
               ResultSet rs =  st1.executeQuery(columnQry);
               while(rs.next()){
                    list.add(rs.getString("zone"));
               }
               
               //System.out.println(list);
               
              // String x = "k";
               String PIID = "PIID";
               String date = "Assign_Date";
               for(int i=0;i<list.size();i++){
                   String x = list.get(i).toString();
                   x = "["+x+"]";
                   x = x+" "+"varchar (500)";
                   qry1= qry1 + x+",";
                  // System.out.println("Qry--------"+qry1);
               }
               
           String qry = "create table pireport ("+date+" varchar(10),"+qry1+")" ;
               String finalString = qry.substring(0, qry.lastIndexOf(","))+")";
               System.out.println("qry ---------------------------"+finalString);
           Statement st = con.createStatement();
               st.execute(qry);
              con.commit();
               }
           }
           }
              catch(Exception e){
                  e.printStackTrace();
              }
       }
    public void selectValues(String startDate,String endDate,int shift1){
          try{
              
             // String startDate = "2014-12-01";
              //String endDate = "2014-12-31";
              //int shift1 = 2;
              ArrayList listAll = new ArrayList();
              ArrayList dateList = getAllDates(startDate,endDate);
              String insertQry = "insert into pireport  (Assign_Date," ;
              String insertEmptyQry = "insert into pireport  (Assign_Date ";
              String x ="";
              String updateQuery = "UPDATE pireport SET ";//tutorial_title='Learning JAVA'  WHERE tutorial_id=3";
              String checkQry = "select '"+x+ "' from pireport where Assign_Date =  ";
              String checkColumnName = "select  from pireport where ";
              ArrayList list = new ArrayList();
              ArrayList listUpdate = new ArrayList();
              ArrayList days = new ArrayList();
              Connection con = getConnection();
              String qry = "select shift1,Shift2,Shift3,Assgn_Date,PI_id,Shift from GEN_PI_MonthlyDeployment where (CONVERT(varchar(10),Assgn_Date,120) between '"+startDate+"' and '"+endDate+"') and  CreatedBy='Supervisor1' and (shift=0 or shift = "+shift1+")";
              System.out.println("Main Qury----"+qry);
              Statement st3 = con.createStatement();
              Statement st4 = con.createStatement();
              Statement st5 = con.createStatement();
              Statement st6 = con.createStatement();
              Statement st = con.createStatement();
              Statement st1 = con.createStatement();
              Statement st2 = con.createStatement();
                ResultSet rs =  st.executeQuery(qry);
              String finalQry = "";
              String sh1oldValue="";
              String sh2oldValue="";
              String sh3oldValue="";
              int i = 1;
              String shift = "";
              while(rs.next()){
                  String qry1 = "";
                  String value = rs.getString("PI_id").toString();
                  String colName1 = rs.getString("shift1").toString();
                  String colName2 = rs.getString("shift2").toString();
                  String colName3 = rs.getString("shift3").toString();
                  String Assgn_Date = rs.getString("Assgn_Date").toString();
                  shift = rs.getString("Shift").toString();
                  String day = Assgn_Date.substring(Assgn_Date.lastIndexOf("-")+1,Assgn_Date.length() );
                  days.add(Assgn_Date);
                 
                  if(dateList.contains(Assgn_Date)){
                      dateList.remove(Assgn_Date);
                  }
              if(colName1.equals("")&&colName2.equals("")&&colName3.equals("")){
                  value = "";
                  String qry11 = "select Assign_Date from pireport where Assign_Date = '"+Assgn_Date+ "'";
                  ResultSet rs4 = st4.executeQuery(qry11);
                  if(!rs4.next()){
                      finalQry = insertEmptyQry+") values ('"+Assgn_Date+"' )";
                      list.add(finalQry);
                  }
              }
                  if(colName1.equals("OnLeave")&&colName2.equals("OnLeave")&&colName3.equals("OnLeave")){
                      value = "";
                      String qry11 = "select Assign_Date from pireport where Assign_Date = '"+Assgn_Date+ "'";
                      ResultSet rs4 = st4.executeQuery(qry11);
                      if(!rs4.next()){
                          finalQry = insertEmptyQry+") values ('"+Assgn_Date+"' )";
                          list.add(finalQry);
                      }
                  }
                  
              if(!colName1.equals("") && !colName1.equals("ALL")  && !colName1.equals("OFF") && !colName1.equals("OnLeave") && !colName1.equals("RESERVED")  ){ 
                  String qry11 = "select * from pireport where Assign_Date = '"+Assgn_Date+ "'";
                //  System.out.println("colName1----------"+qry11);
                  st = con.createStatement();
                  ResultSet rs1 = st.executeQuery(qry11);
                  if(rs1.next()){
                    String oldPIID = rs1.getString(colName1);
                //    System.out.println("oldPIID"+oldPIID);
                      if(oldPIID!=null){
                          sh1oldValue = oldPIID +","+ value;  
                      }
                      else{
                          sh1oldValue =  value;  
                      }
                      qry1 = colName1; 
                      qry1 = "["+qry1+"]";
                      finalQry = updateQuery+qry1+"=  '"+sh1oldValue+"'  where Assign_Date = '"+Assgn_Date+"'";
                      listUpdate.add(finalQry);
                  }
                  else{
                  qry1 = colName1; 
                  qry1 = "["+qry1+"]";
                  finalQry = insertQry+qry1+") values ('"+Assgn_Date+"','"+value+"' )";
                  list.add(finalQry);
                  }
              }
              else if(!colName2.equals("") && !colName2.equals("ALL") && !colName2.equals("OFF") && !colName2.equals("OnLeave") && !colName2.equals("RESERVED") ){
                 // String qry11 = "select ["+colName2+ "] from pireport where Assign_Date = '"+Assgn_Date+ "' and  ["+colName2+ "]  is not null";
                 String qry11 = "select * from pireport where Assign_Date = '"+Assgn_Date+ "' ";
                 // System.out.println("colName2----------"+qry11);
                  st = con.createStatement();
                  ResultSet rs1 = st.executeQuery(qry11);
                  if(rs1.next()){
                    String oldPIID = rs1.getString(colName2);
                    System.out.println("oldPIID"+oldPIID);
                    if(oldPIID!=null){
                        sh1oldValue = oldPIID +","+ value;  
                    }
                    else{
                        sh1oldValue =  value;  
                    }
                      
                      qry1 = colName2; 
                      qry1 = "["+qry1+"]";
                      finalQry = updateQuery+qry1+"=  '"+sh1oldValue+"'  where Assign_Date = '"+Assgn_Date+"'";
                      listUpdate.add(finalQry);
                  }
                  else{
                  qry1 = colName2; 
                  qry1 = "["+qry1+"]";
                  finalQry = insertQry+qry1+") values ('"+Assgn_Date+"','"+value+"' )";
                  list.add(finalQry);
                  }
              }
              else if(!colName3.equals("") && !colName3.equals("ALL")  && !colName3.equals("OFF") && !colName3.equals("OnLeave") && !colName3.equals("RESERVED")  ){
                  //String qry11 = "select ["+colName3+ "] from pireport where Assign_Date = '"+Assgn_Date+ "' and  ["+colName3+ "]  is not null";
                  String qry11 = "select * from pireport where Assign_Date = '"+Assgn_Date+ "' ";
                 // System.out.println("colName3----------"+qry11);
                  st = con.createStatement();
                  ResultSet rs1 = st.executeQuery(qry11);
                  if(rs1.next()){
                    String oldPIID = rs1.getString(colName3);
                    System.out.println("oldPIID"+oldPIID);
                      if(oldPIID!=null){
                          sh1oldValue = oldPIID +","+ value;  
                      }
                      else{
                          sh1oldValue =  value;  
                      }
                      qry1 = colName3; 
                      qry1 = "["+qry1+"]";
                      finalQry = updateQuery+qry1+"=  '"+sh1oldValue+"'  where Assign_Date = '"+Assgn_Date+"'";
                      listUpdate.add(finalQry);
                  }
                  else{
                  qry1 = colName3; 
                  qry1 = "["+qry1+"]";
                  finalQry = insertQry+qry1+") values ('"+Assgn_Date+"','"+value+"' )";
                  list.add(finalQry);
                  }
              }
                  
                  for(int j=0;j<list.size();j++){
                      qry = list.get(j).toString();
                     // System.out.println("Qry-----11111111------"+qry);
                      st2.execute(qry);
                  }  
                  for(int j=0;j<listUpdate.size();j++){
                      qry = listUpdate.get(j).toString();
                   //   System.out.println("Update Qry-----2222222222222------"+qry);
                      st3.execute(qry);
                  }  
                  list.clear();
                  listUpdate.clear();
                  HashMap map = new HashMap();
                 List listVa = new ArrayList();
                  

                  if(colName1.equals("ALL")){
                       listAll.add(value);
                  }
                  if(colName2.equals("ALL")){
                      listAll.add(value);
                  }
                  if(colName3.equals("ALL")){
                      listAll.add(value);
                  }
              }    
              
              Set set = new HashSet(listAll);
            //  if(shift.equals("3")){
              String qryAll = "select PI_Id,Assgn_Date from gen_pi_monthlydeployment where (CONVERT(varchar(10),Assgn_Date,120) between '"+startDate+"' and '"+endDate+"') and shift = "+shift1+" and Sector_Zone = 'ALL'";
           //   System.out.println("qryAll------------"+qryAll);
              Statement stAll = con.createStatement();
              ResultSet rsAll = stAll.executeQuery(qryAll);
              Statement sst = con.createStatement();
              Statement sstUpdate = con.createStatement();
              while(rsAll.next()){
                  String qry1 = "";
                  String pi_id = rsAll.getString("PI_Id");
                  String Assgn_Date = rsAll.getString("Assgn_Date");
                  ArrayList listColums = setToAll();
                  System.out.println("-----------listColums--------------"+listColums);
                  for(int j=0;j<listColums.size();j++){
                      String columName = listColums.get(j).toString();
                      String qry11 = "select ["+columName+ "] from pireport where Assign_Date = '"+Assgn_Date+ "' and  ["+columName+ "]  is not null";
                      System.out.println("qry11---------"+qry11);
                     ResultSet rsSST = sst.executeQuery(qry11);
                      if(rsSST.next()){
                          String oldValue = rsSST.getString(columName);
                          oldValue = pi_id +","+ oldValue;
                          qry1 = "["+columName+"]";
                          String updateAll = updateQuery+qry1+"=  '"+oldValue+"'  where Assign_Date = '"+Assgn_Date+"'";
                          System.out.println("updateAll in if----------"+updateAll);
                          sstUpdate.executeUpdate(updateAll);
                      }
                      else{
                          qry1 = "["+columName+"]";
                          String updateAll = updateQuery+qry1+"=  '"+pi_id+"'  where Assign_Date = '"+Assgn_Date+"'";
                          System.out.println("updateAll in else---------"+updateAll);
                          sstUpdate.executeUpdate(updateAll);
                      }
                  }
              }
             // }
              Statement stEmpty = con.createStatement();
              System.out.println(dateList);
              for(int k=0;k<dateList.size();k++){
                //  if(!dateList.get(k).toString().equals("RESERVED")){
                   String emptyQry = insertEmptyQry+") values ('"+dateList.get(k).toString()+"' )";
                   stEmpty.execute(emptyQry);
                 // }
              }
              //list.add(insertQry);
              //System.out.println("insertQry-----"+list);
              //System.out.println("update Qry-----"+listUpdate);
             // listUpdate
    //                for (String string : set) {
    //                    ArrayList listColums = setToAll();
    //                    for(int j=0;j<listColums.size();j++){
    //
    //                    }
    //                }
                      
    //                 System.out.println("Printing Set "+string);
    //                    String qry11 = "select ["+colName3+ "] from pireport where Assign_Date = '"+Assgn_Date+ "' and  ["+colName3+ "]  is not null";
    //                    System.out.println("----------"+qry11);
    //                    st = con.createStatement();
    //                    ResultSet rs1 = st.executeQuery(qry11);
    //                    if(rs1.next()){
    //                      String oldPIID = rs1.getString(colName3);
    //                      System.out.println("oldPIID"+oldPIID);
    //                        sh1oldValue = oldPIID +","+ value;
    //                        qry1 = colName3;
    //                        qry1 = "["+qry1+"]";
    //                        finalQry = updateQuery+qry1+"=  '"+sh1oldValue+"'  where Assign_Date = '"+Assgn_Date+"'";
    //                        listUpdate.add(finalQry);
    //                    }
           

            System.out.println(set);
              
         
          }
          catch(Exception e){
              e.printStackTrace();
          }
      }
    public void checkPiOnLeaveDates(String startDate1,String endDate1,int shift1){
          // Call PI,Leave Date from PILeave
          try{
              //String startDate1 = "2014-12-01";
             // String endDate1 = "2014-12-31";
              //int shift1 = 2;
          String qryPIAppliedLeaves = "select PI_id,From_Date,To_Date from pi_leavemgmt where status = 'Approved' and From_Date between '"+startDate1+"' and '"+endDate1+"'";
          Connection con = getConnection();
          Statement st = con.createStatement();
          Statement st1 = con.createStatement();
              ResultSet rs = st.executeQuery(qryPIAppliedLeaves);
            //  HashMap map = new HashMap();
            ArrayList list = new ArrayList();
              HashMap<String, List<String>> map = new HashMap<String, List<String>>();
              while(rs.next()){
                  String startDate = rs.getString("From_Date").toString();
                  String endDate = rs.getString("To_Date").toString();
                  String PI_id = rs.getString("PI_id").toString();
                  String qryIndividualDates = "SELECT IndividualDate FROM GetDates('"+startDate+"', '"+endDate+"')";
                  ResultSet rs1 = st1.executeQuery(qryIndividualDates);
                 
                  while(rs1.next()){
                      list.add(rs1.getString("IndividualDate").toString());
                  }
                  if(map.containsKey(PI_id)){
                      ArrayList oldList = (ArrayList)map.get(PI_id);
                      Collections.copy(oldList,list);
                      map.put(PI_id,list);
                  }
                  else{
                      map.put(PI_id,list);
                  }
              }
          //String qryIndividualDates = "SELECT IndividualDate FROM GetDates('12/05/2014', '12/07/2014')";
              Statement st3 = con.createStatement();
              Statement st4 = con.createStatement();
              Statement st5 = con.createStatement();
              System.out.println("Map values---"+map);
              //String updateQuery = "";
              ArrayList updateLeavelist = new ArrayList();
          for (Map.Entry<String, List<String>> entry : map.entrySet()) {
              String key = entry.getKey();
              List<String> values = entry.getValue();
              System.out.println("Key = " + key);
              System.out.println("Values = " + values + "n");
              for(int j=0;j<values.size();j++){
                  String getPIZone = "select Sector_Zone,PI_id from GEN_PI_MonthlyDeployment where PI_id = '"+key+"' and Assgn_Date = '"+values.get(j).toString()+"' and shift ="+shift1;
                  System.out.println(getPIZone);
                  ResultSet rs3 = st3.executeQuery(getPIZone);
                  String oldPiid = "";
                  while(rs3.next()){
                     String sectorZone =rs3.getString("Sector_Zone");
                     String qryPireport = "select ["+sectorZone+"] from pireport where  Assign_Date = '"+values.get(j).toString()+"' and ["+sectorZone+"] = '"+key+"' ";
                      System.out.println(qryPireport);
                      ResultSet rs5 = st5.executeQuery(qryPireport);
                      if(rs5.next()){
                          oldPiid = rs5.getString(sectorZone);
                      }
                     System.out.println(sectorZone);
                     String updateQuery= "UPDATE pireport SET"+ "["+sectorZone+"] ="+oldPiid+" '"+key+"(L)'  where Assign_Date = '"+values.get(j).toString()+"'";
                      System.out.println(updateQuery);
                      st4.executeUpdate(updateQuery);
                  }
              }
          }
          }
          catch(Exception e){
              e.printStackTrace();
          }
          
          
          //Check PI with same date is allocated in the Monthle
          //If Yes Update the PI ID in pireport column
      }
    public ArrayList getAllDates(String startDate,String endDate){
          ArrayList list = new ArrayList();
          try{
              Connection con = getConnection();
              Statement st = con.createStatement();
              String qry = "SELECT IndividualDate FROM GetDates('"+startDate+"', '"+endDate+"')";
              System.out.println("qry---------------------------------"+qry);
              ResultSet rs = st.executeQuery("SELECT IndividualDate FROM GetDates('"+startDate+"', '"+endDate+"')");
              while(rs.next()){
                  list.add(rs.getString("IndividualDate"));
              }
          }
          catch(Exception e ){
              e.printStackTrace();
          }
          return list;
      }
    public ArrayList setToAll(){
           ArrayList list = new ArrayList();
           try{
               Connection con = getConnection();
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT * FROM pireport");
               ResultSetMetaData rsmd = rs.getMetaData();
               int count = rsmd.getColumnCount();
               for(int i=1;i<=count;i++){
                   if(!rsmd.getColumnName(i).toString().equals("PIID") && !rsmd.getColumnName(i).toString().equals("Assign_Date")){
                       list.add(rsmd.getColumnName(i));
                   }
               }
               System.out.println(list);
           }
           catch(Exception e ){
               e.printStackTrace();
           }
           return list;

       }
}
