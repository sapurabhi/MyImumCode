package com.imum.ws.PVTIssuance;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

@WebService(wsdlLocation="http://192.168.200.113:8003/PVT/ObservationOrIssuance/#%7Bhttp%3A%2F%2Fwww.zoneparking.ae%2FPVT_ObservationOrIssuance%7Dpvt_observationorissuance_client_ep?wsdl",
  targetNamespace="http://www.zoneparking.ae/PVT_ObservationOrIssuance",
  name="PVT_ObservationOrIssuance")
@XmlSeeAlso(
  { com.imum.ws.PVTIssuance.ObjectFactory.class })
public interface PVT_ObservationOrIssuance
{
  @WebMethod(operationName="PVT_ObservationOrIssuance", action="PVT_ObservationOrIssuance")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="PVT_ObservationOrIssuance", output="http://www.zoneparking.ae/PVT_ObservationOrIssuance/PVT_ObservationOrIssuance/PVT_ObservationOrIssuanceResponse")
  @WebResult(targetNamespace="http://www.zoneparking.ae/PVT_ObservationOrIssuance",
    partName="payload", name="PVT_ObservationOrIssuance_Response")
  public com.imum.ws.PVTIssuance.PVTObservationOrIssuanceResponse pvtObservationOrIssuance(@WebParam(targetNamespace="http://www.zoneparking.ae/PVT_ObservationOrIssuance",
      partName="payload", name="PVT_ObservationOrIssuance_Request")
    com.imum.ws.PVTIssuance.PVTHHCRequestLog payload);
}