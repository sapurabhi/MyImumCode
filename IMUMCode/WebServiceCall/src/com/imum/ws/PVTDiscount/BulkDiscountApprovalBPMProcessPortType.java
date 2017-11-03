package com.imum.ws.PVTDiscount;

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

@WebService(wsdlLocation="http://192.168.200.112:8001/soa-infra/services/default/BulkDiscountApprovalBPM/BulkDiscountApprovalBPMProcess.service?WSDL",
  targetNamespace="http://xmlns.oracle.com/bpmn/bpmnProcess/BulkDiscountApprovalBPMProcess",
  name="BulkDiscountApprovalBPMProcessPortType")
@XmlSeeAlso(
  { ObjectFactory.class })
public interface BulkDiscountApprovalBPMProcessPortType
{
  @WebMethod(action="cancelblkd")
  @Action(input="cancelblkd")
  @RequestWrapper(localName="cancelblkd", targetNamespace="http://xmlns.oracle.com/bpmn/bpmnProcess/BulkDiscountApprovalBPMProcess",
    className="com.imum.ws.PVTDiscount.Cancelblkd")
  @Oneway
  public void cancelblkd(@WebParam(targetNamespace="", name="bulk_seq")
    long bulkSeq);

  @WebMethod(action="start")
  @Action(input="start")
  @RequestWrapper(localName="start", targetNamespace="http://xmlns.oracle.com/bpmn/bpmnProcess/BulkDiscountApprovalBPMProcess",
    className="com.imum.ws.PVTDiscount.Start")
  @Oneway
  public void start(@WebParam(targetNamespace="", name="bulkdiscountheaderSeq")
    long bulkdiscountheaderSeq);
}