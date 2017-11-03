package com.imum.cpms.util;

import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.faces.event.PhaseEvent;

public class PropertiesBeanUtils {
    private static Properties properties = null;
       private static Map<String, String> cpmsbpmhttpProperties;
       private static String CPMS_BPM_URL_PROPERTIES_FILENAME = "cpmsproperties.properties";
     
       
       
       public PropertiesBeanUtils() {
           super();
       }
       
       public static void loadCpmsBPMHttpPropertiesPhase(PhaseEvent phaseEvent) throws Exception {
           loadCpmsBPMHttpProperties();
       }
       
       public static void loadCpmsBPMHttpProperties() throws Exception {
           InputStream myVFInputStream = null;
           try {
               myVFInputStream = PropertiesBeanUtils.class.getResourceAsStream("/" + CPMS_BPM_URL_PROPERTIES_FILENAME);
               
               properties = new Properties();
               properties.load(myVFInputStream);
               
               if (properties != null) {
                   cpmsbpmhttpProperties = new HashMap<String, String>((Map) properties);
                   Set<Map.Entry<String, String>> propSet;
                   propSet = cpmsbpmhttpProperties.entrySet();
               }
    
           } catch (Exception e) {
              
               throw e;
           } finally {
               if (myVFInputStream != null) {
                   try {
                       myVFInputStream.close();
                   } catch (Exception e) {
                     
                   }
               }
           }
       }
       
       public static String getValue(String bpmHttpPropertyKey) {
           try {
               if (properties == null) {
                   loadCpmsBPMHttpProperties();
               }
           } catch (Exception e) {
            
               return "";
           }
           return properties.getProperty(bpmHttpPropertyKey);
       }
       
       public static int getIntValue(String bpmHttpPropertyKey) {
           String stringValue = getValue(bpmHttpPropertyKey);
           if (stringValue != null && stringValue.trim().length() != 0) {
               return (new Integer(stringValue)).intValue();
           }
           return 0;
       }

       public Map getcpmsBPMhttpURLProperties() throws Exception {
           try {
               if (properties == null) {
                   loadCpmsBPMHttpProperties();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           
           if (cpmsbpmhttpProperties == null) {
               System.out.println("SETTING properties");
               Map<String, String> mybpmHttpProperties = new HashMap<String, String>((Map) properties);
               Set<Map.Entry<String, String>> propSet;
               propSet = mybpmHttpProperties.entrySet();
               
               return mybpmHttpProperties;
           }
           
           return cpmsbpmhttpProperties;
       }
    }
