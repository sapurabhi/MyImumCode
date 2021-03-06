package com.imum.ws.PVTDiscount;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

@WebServiceClient(wsdlLocation="http://192.168.200.112:8001/soa-infra/services/default/BulkDiscountApprovalBPM/BulkDiscountApprovalBPMProcess.service?WSDL",
  targetNamespace="http://xmlns.oracle.com/bpmn/bpmnProcess/BulkDiscountApprovalBPMProcess",
  name="BulkDiscountApprovalBPMProcess.service")
public class BulkDiscountApprovalBPMProcessService
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("com.imum.ws.PVTDiscount.BulkDiscountApprovalBPMProcessService");
      URL baseUrl =
        BulkDiscountApprovalBPMProcessService.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            BulkDiscountApprovalBPMProcessService.class.getResource("http://cpmsfmwappdc.cpms.local:8001/soa-infra/services/default/BulkDiscountApprovalBPM/BulkDiscountApprovalBPMProcess.service?WSDL");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://cpmsfmwappdc.cpms.local:8001/soa-infra/services/default/BulkDiscountApprovalBPM/BulkDiscountApprovalBPMProcess.service?WSDL");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://cpmsfmwappdc.cpms.local:8001/soa-infra/services/default/BulkDiscountApprovalBPM/BulkDiscountApprovalBPMProcess.service?WSDL");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://cpmsfmwappdc.cpms.local:8001/soa-infra/services/default/BulkDiscountApprovalBPM/BulkDiscountApprovalBPMProcess.service?WSDL",
          e);
    }
  }

  public BulkDiscountApprovalBPMProcessService()
  {
    super(wsdlLocationURL,
          new QName("http://xmlns.oracle.com/bpmn/bpmnProcess/BulkDiscountApprovalBPMProcess",
                    "BulkDiscountApprovalBPMProcess.service"));
  }

  public BulkDiscountApprovalBPMProcessService(URL wsdlLocation,
                                               QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="BulkDiscountApprovalBPMProcessPort")
  public BulkDiscountApprovalBPMProcessPortType getBulkDiscountApprovalBPMProcessPort()
  {
    return (BulkDiscountApprovalBPMProcessPortType) super.getPort(new QName("http://xmlns.oracle.com/bpmn/bpmnProcess/BulkDiscountApprovalBPMProcess",
                                                                            "BulkDiscountApprovalBPMProcessPort"),
                                                                  BulkDiscountApprovalBPMProcessPortType.class);
  }

  @WebEndpoint(name="BulkDiscountApprovalBPMProcessPort")
  public BulkDiscountApprovalBPMProcessPortType getBulkDiscountApprovalBPMProcessPort(WebServiceFeature... features)
  {
    return (BulkDiscountApprovalBPMProcessPortType) super.getPort(new QName("http://xmlns.oracle.com/bpmn/bpmnProcess/BulkDiscountApprovalBPMProcess",
                                                                            "BulkDiscountApprovalBPMProcessPort"),
                                                                  BulkDiscountApprovalBPMProcessPortType.class,
                                                                  features);
  }
}
