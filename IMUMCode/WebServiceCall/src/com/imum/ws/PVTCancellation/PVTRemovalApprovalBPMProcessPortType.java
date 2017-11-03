package com.imum.ws.PVTCancellation;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

@WebService(wsdlLocation="http://cpmsfmwappdc.cpms.local:8001/soa-infra/services/default/PVTRemovalApprovalBPM/PVTRemovalApprovalBPMProcess.service?WSDL",
  targetNamespace="http://xmlns.oracle.com/bpmn/bpmnProcess/PVTRemovalApprovalBPMProcess",
  name="PVTRemovalApprovalBPMProcessPortType")
@XmlSeeAlso(
  { com.imum.ws.PVTCancellation.ObjectFactory.class })
public interface PVTRemovalApprovalBPMProcessPortType
{
  @WebMethod(action="cancelpvt")
  @Action(input="cancelpvt")
  @RequestWrapper(localName="cancelpvt", targetNamespace="http://xmlns.oracle.com/bpmn/bpmnProcess/PVTRemovalApprovalBPMProcess",
    className="com.imum.ws.PVTCancellation.Cancelpvt")
  @Oneway
  public void cancelpvt(@WebParam(targetNamespace="", name="pvtsequence")
    long pvtsequence);

  @WebMethod(action="start")
  @Action(input="start")
  @RequestWrapper(localName="start", targetNamespace="http://xmlns.oracle.com/bpmn/bpmnProcess/PVTRemovalApprovalBPMProcess",
    className="com.imum.ws.PVTCancellation.Start")
  @Oneway
  public void start(@WebParam(targetNamespace="", name="PVTNum")
    long pvtNum);
}
