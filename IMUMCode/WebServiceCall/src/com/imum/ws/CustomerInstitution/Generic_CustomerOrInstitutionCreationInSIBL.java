package com.imum.ws.CustomerInstitution;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

@WebService(wsdlLocation="http://192.168.200.113:8003/Generic/CustomerOrInstitutionCreationInSIBL?wsdl",
  targetNamespace="http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL",
  name="Generic_CustomerOrInstitutionCreationInSIBL")
@XmlSeeAlso(
  { com.imum.ws.CustomerInstitution.ObjectFactory.class })
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.BARE)
public interface Generic_CustomerOrInstitutionCreationInSIBL
{
  @WebMethod(operationName="Generic_CustomerCreationInSIBL", action="Generic_CustomerCreationInSIBL")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="Generic_CustomerCreationInSIBL", output="http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL/Generic_CustomerOrInstitutionCreationInSIBL/Generic_CustomerCreationInSIBLResponse")
  @WebResult(targetNamespace="http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL",
    partName="payload", name="Generic_CustomerOrInstitutionCreationInSIBL_Response")
  public com.imum.ws.CustomerInstitution.GenericCustomerOrInstitutionCreationInSIBLResponse genericCustomerCreationInSIBL(@WebParam(targetNamespace="http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL",
      partName="payload", name="Generic_CustomerCreationInSIBL_Request")
    com.imum.ws.CustomerInstitution.GenCustomerMst payload);

  @WebMethod(operationName="Generic_InstitutionCreationInSIBL", action="Generic_InstitutionCreationInSIBL")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="Generic_InstitutionCreationInSIBL", output="http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL/Generic_CustomerOrInstitutionCreationInSIBL/Generic_InstitutionCreationInSIBLResponse")
  @WebResult(targetNamespace="http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL",
    partName="payload", name="Generic_CustomerOrInstitutionCreationInSIBL_Response")
  public com.imum.ws.CustomerInstitution.GenericCustomerOrInstitutionCreationInSIBLResponse genericInstitutionCreationInSIBL(@WebParam(targetNamespace="http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL",
      partName="payload", name="Generic_InstitutionCreationInSIBL_Request")
    com.imum.ws.CustomerInstitution.GenInstitutionMst payload);
}