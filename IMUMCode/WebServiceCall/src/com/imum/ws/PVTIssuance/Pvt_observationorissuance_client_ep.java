package com.imum.ws.PVTIssuance;

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

@WebServiceClient(wsdlLocation="http://192.168.200.113:8003/PVT/ObservationOrIssuance/#%7Bhttp%3A%2F%2Fwww.zoneparking.ae%2FPVT_ObservationOrIssuance%7Dpvt_observationorissuance_client_ep?wsdl",
  targetNamespace="http://www.zoneparking.ae/PVT_ObservationOrIssuance",
  name="pvt_observationorissuance_client_ep")
public class Pvt_observationorissuance_client_ep
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("com.imum.ws.PVTIssuance.Pvt_observationorissuance_client_ep");
      URL baseUrl =
        Pvt_observationorissuance_client_ep.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            Pvt_observationorissuance_client_ep.class.getResource("http://192.168.200.113:8003/PVT/ObservationOrIssuance/#%7Bhttp%3A%2F%2Fwww.zoneparking.ae%2FPVT_ObservationOrIssuance%7Dpvt_observationorissuance_client_ep?wsdl");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://192.168.200.113:8003/PVT/ObservationOrIssuance/#%7Bhttp%3A%2F%2Fwww.zoneparking.ae%2FPVT_ObservationOrIssuance%7Dpvt_observationorissuance_client_ep?wsdl");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://192.168.200.113:8003/PVT/ObservationOrIssuance/#%7Bhttp%3A%2F%2Fwww.zoneparking.ae%2FPVT_ObservationOrIssuance%7Dpvt_observationorissuance_client_ep?wsdl");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://192.168.200.113:8003/PVT/ObservationOrIssuance/#%7Bhttp%3A%2F%2Fwww.zoneparking.ae%2FPVT_ObservationOrIssuance%7Dpvt_observationorissuance_client_ep?wsdl",
          e);
    }
  }

  public Pvt_observationorissuance_client_ep()
  {
    super(wsdlLocationURL,
          new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance",
                    "pvt_observationorissuance_client_ep"));
  }

  public Pvt_observationorissuance_client_ep(URL wsdlLocation,
                                             QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="PVT_ObservationOrIssuance_pt")
  public com.imum.ws.PVTIssuance.PVT_ObservationOrIssuance getPVT_ObservationOrIssuance_pt()
  {
    return (com.imum.ws.PVTIssuance.PVT_ObservationOrIssuance) super.getPort(new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance",
                                                                                       "PVT_ObservationOrIssuance_pt"),
                                                                             com.imum.ws.PVTIssuance.PVT_ObservationOrIssuance.class);
  }

  @WebEndpoint(name="PVT_ObservationOrIssuance_pt")
  public com.imum.ws.PVTIssuance.PVT_ObservationOrIssuance getPVT_ObservationOrIssuance_pt(WebServiceFeature... features)
  {
    return (com.imum.ws.PVTIssuance.PVT_ObservationOrIssuance) super.getPort(new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance",
                                                                                       "PVT_ObservationOrIssuance_pt"),
                                                                             com.imum.ws.PVTIssuance.PVT_ObservationOrIssuance.class,
                                                                             features);
  }
}
