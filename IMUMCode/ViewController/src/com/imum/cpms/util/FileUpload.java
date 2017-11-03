package com.imum.cpms.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class FileUpload {
    public static final ADFLogger logger = ADFLogger.createADFLogger(FileUpload.class);
    
  private List<UploadedFile> uploadedFile;
     
  //private String rootPath = "D://FileStore";
  //private String rootPath = "//home//dev1//u01//cpms";
    private String rootPath = "//cpmsshare";
    
    public FileUpload() {
        super();
    }


// documentCategory should be PERMIT/PVT/APPEAL/SECTOR/ZONE, Code can be permit number,pvt number,appeal number, sector code or zone code
// This method return file server path where documents are uploaded
  public String uploadFilesToFolder(String organizationId,
                                    String documentCategory, String code,
                                    List<UploadedFile> uploadFiles) {

    String path = null;
    String uploadedPath = null;
    if (null != uploadFiles) {
      for (int i = 0; i < uploadFiles.size(); i++) {

        UploadedFile tempFile = uploadFiles.get(i);
        System.out.println("temp file" + tempFile.getFilename());
      //  rootPath = "D://FileStore";
        File rootP = new File(rootPath);
        rootP.setWritable(Boolean.TRUE);
        if (tempFile != null) {
          System.out.println(tempFile.getFilename());
          File orgId = new File(rootPath + "//"+ organizationId);
          // check if orgId folder exist
          if (!orgId.isDirectory()) {
            System.out.println("before creating directory orgId");            
            orgId.mkdir();
            orgId.setWritable(Boolean.TRUE);
            System.out.println("after creating directory orgId");
              path = rootPath + "//"+  organizationId;
              uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
          }else{
               path = rootPath + "//" + organizationId;
               uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
              }
                
                System.out.println("Path in if part" + path);
          } 
          
        }
      }
        return uploadedPath;
    }
  
  
  
    public String uploadFilesToFolder(String organizationId,
                                      String documentCategory, String code,
                                       UploadedFile uploadFiles) {

      String path = null;
      String uploadedPath = null;
      if (null != uploadFiles) {
       
          UploadedFile tempFile = uploadFiles;
          System.out.println("temp file" + tempFile.getFilename());
        //  rootPath = "D://FileStore";
          File rootP = new File(rootPath);
          rootP.setWritable(Boolean.TRUE);
          if (tempFile != null) {
            System.out.println(tempFile.getFilename());
            File orgId = new File(rootPath + "//"+ organizationId);
            // check if orgId folder exist
            if (!orgId.isDirectory()) {
              System.out.println("before creating directory orgId");            
              orgId.mkdir();
              orgId.setWritable(Boolean.TRUE);
              System.out.println("after creating directory orgId");
                path = rootPath + "//"+  organizationId;
                uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
            }else{
                 path = rootPath + "//" + organizationId;
                 uploadedPath = findDirectoryAndUpload(documentCategory,code,path,rootPath,organizationId,tempFile);     
                }
                  
                  System.out.println("Path in if part" + path);
            } 
            
        
        }
          return uploadedPath;
      }
  
  
  public void callUploadFiles(UploadedFile tempFile, String path){
      
          InputStream inputStream = null;
          try {
            FileOutputStream out = new FileOutputStream(path +"//"+ tempFile.getFilename());
            inputStream = tempFile.getInputStream();
            byte[] buffer = new byte[8192];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
              out.write(buffer, 0, bytesRead);
            }
            out.flush();
            out.close();
          } catch (Exception ex) {
            // handle exception
            ex.printStackTrace();
          } finally {
            try {
                if(inputStream!=null){
                    inputStream.close(); 
                }
              
            } catch (IOException e) {
            }
          }
      }

  public void setUploadedFile(List<UploadedFile> uploadedFile) {
    this.uploadedFile = uploadedFile;
  }

  public List<UploadedFile> getUploadedFile() {
    return uploadedFile;
  }

    private String findDirectoryAndUpload(String documentCategory, String code, String path, String rootPath, String orgId, UploadedFile tempFile) {
        String pvtTempPath = null;
        String tempPath = null;
        File pathFile = null;
        //Check if document category exist
                   if(documentCategory.equals("PERMIT") || documentCategory.equals("SECTOR") || documentCategory.equals("ZONE")|| documentCategory.equals("PVT") || documentCategory.equals("APPEAL"))
                   {                        
                     File docCat = null;
                     if (documentCategory.equals("PVT") || documentCategory.equals("APPEAL"))
                     {
                       path=  getFolderPath(orgId, documentCategory, code);
                       pvtTempPath = path;
                       docCat = new File(pvtTempPath);
                     }else{                       
                       System.out.println("before creating directory documentCategory");  
                       tempPath = rootPath + "//" + orgId  +"//" + documentCategory;
                       docCat = new File(tempPath);                       
                    
                       if(!docCat.isDirectory()){
                               docCat.mkdir();
                               docCat.setWritable(Boolean.TRUE);
                               //path = rootPath + "//" + orgId + "//"+ documentCategory;
                           }
                       else{
                            //path = rootPath + "//" + orgId + "//"+ documentCategory;                            
                        }
                       path = tempPath;
                     }
                       System.out.println("after creating directory documentCategory");  
                       if(documentCategory.equals("PVT") || documentCategory.equals("APPEAL"))
                       {
                          pathFile = new File (pvtTempPath + "//" + code);
                          path = pvtTempPath + "//" + code;
                       }
                       else
                       {
                          pathFile = new File (tempPath + "//" + code);
                          path = tempPath + "//" + code;
                        }
                       
                       if(!pathFile.isDirectory())
                       {
                            pathFile.mkdir();
                            pathFile.setWritable(Boolean.TRUE);
                            //path = rootPath + "//" + orgId + "//"+ documentCategory + "//" + code;
                            callUploadFiles(tempFile, path);    
                            
                       }else{
                             //path = rootPath + "//" + orgId + "//"+ documentCategory + "//" + code;
                             callUploadFiles(tempFile, path);                                   
                           }                       
                   }                   
                     
      
                   return path;
    }
    //Get folder path where documents are uploaded
    public String getFolderPath(String orgId, String documentCategory, String code){
        
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            String monthS = "0";
            String path = null;
            if(month < 10) {
                 monthS = "0"+month;
                }else {
                 monthS = String.valueOf(month);
            }

            File currentYearMonth = new File(rootPath + "//" + orgId + "//"+ documentCategory +"//"+ year+monthS);
            
            if(!currentYearMonth.isDirectory())
            {
              currentYearMonth.mkdirs();
              currentYearMonth.setWritable(Boolean.TRUE);
              path = rootPath + "//" + orgId + "//"+ documentCategory +"//"+year+monthS;             
              
            }else{
             path = rootPath + "//" + orgId + "//"+ documentCategory +"//"+year+monthS;            
              
            }
            return path;
        }
}
