package com.imum.ws.BulkSale;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

@WebService(wsdlLocation="http://192.168.200.113:8003/CARDS/Card_RechargeSale/#%7Bhttp%3A%2F%2Fws.sale.rc.mparking.infocomm.com%2F%7DRCSaleWS?wsdl",
  targetNamespace="http://ws.sale.rc.mparking.infocomm.com/", name="RCSaleWS")
@XmlSeeAlso(
  { com.imum.ws.BulkSale.ObjectFactory.class })
public interface RCSaleWS
{
  @WebMethod
  @Action(input="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/checkRechargeCardRequest",
    output="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/checkRechargeCardResponse")
  @ResponseWrapper(localName="checkRechargeCardResponse", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.CheckRechargeCardResponse")
  @RequestWrapper(localName="checkRechargeCard", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.CheckRechargeCard")
  @WebResult(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/")
  public com.imum.ws.BulkSale.RechargeCardObj checkRechargeCard(@WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cardNo")
    String cardNo, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="userId")
    String userId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="pwd")
    String pwd, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cvc")
    String cvc, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="expiryDate")
    String expiryDate);

  @WebMethod
  @Action(input="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/soldRechargeCardRequest",
    output="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/soldRechargeCardResponse")
  @ResponseWrapper(localName="soldRechargeCardResponse", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.SoldRechargeCardResponse")
  @RequestWrapper(localName="soldRechargeCard", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.SoldRechargeCard")
  @WebResult(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/")
  public com.imum.ws.BulkSale.RechargeCardObj soldRechargeCard(@WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cardNo")
    String cardNo, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="userId")
    String userId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="pwd")
    String pwd, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cvc")
    String cvc, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="expiryDate")
    String expiryDate);

  @WebMethod
  @Action(input="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/rollbackRechargeCardRequest",
    output="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/rollbackRechargeCardResponse")
  @ResponseWrapper(localName="rollbackRechargeCardResponse",
    targetNamespace="http://ws.sale.rc.mparking.infocomm.com/", className="com.imum.ws.BulkSale.RollbackRechargeCardResponse")
  @RequestWrapper(localName="rollbackRechargeCard", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.RollbackRechargeCard")
  @WebResult(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/")
  public com.imum.ws.BulkSale.RechargeCardObj rollbackRechargeCard(@WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cardNo")
    String cardNo, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="userId")
    String userId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="pwd")
    String pwd, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cvc")
    String cvc, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="expiryDate")
    String expiryDate);

  @WebMethod
  @Action(input="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/deactivateRechargeCardRequest",
    output="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/deactivateRechargeCardResponse")
  @ResponseWrapper(localName="deactivateRechargeCardResponse",
    targetNamespace="http://ws.sale.rc.mparking.infocomm.com/", className="com.imum.ws.BulkSale.DeactivateRechargeCardResponse")
  @RequestWrapper(localName="deactivateRechargeCard", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.DeactivateRechargeCard")
  @WebResult(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/")
  public com.imum.ws.BulkSale.RechargeCardObj deactivateRechargeCard(@WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cardNo")
    String cardNo, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="userId")
    String userId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="pwd")
    String pwd, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cvc")
    String cvc, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="expiryDate")
    String expiryDate);

  @WebMethod
  @Action(input="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/deactivateRechargeCardByWebRequest",
    output="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/deactivateRechargeCardByWebResponse")
  @ResponseWrapper(localName="deactivateRechargeCardByWebResponse",
    targetNamespace="http://ws.sale.rc.mparking.infocomm.com/", className="com.imum.ws.BulkSale.DeactivateRechargeCardByWebResponse")
  @RequestWrapper(localName="deactivateRechargeCardByWeb",
    targetNamespace="http://ws.sale.rc.mparking.infocomm.com/", className="com.imum.ws.BulkSale.DeactivateRechargeCardByWeb")
  @WebResult(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/")
  public com.imum.ws.BulkSale.RechargeCardObj deactivateRechargeCardByWeb(@WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cardNo")
    String cardNo, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="userId")
    String userId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="pwd")
    String pwd, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cvc")
    String cvc, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="expiryDate")
    String expiryDate, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="webUserId")
    String webUserId);

  @WebMethod
  @Action(input="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/linkRechargeCardRequest",
    output="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/linkRechargeCardResponse")
  @ResponseWrapper(localName="linkRechargeCardResponse", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.LinkRechargeCardResponse")
  @RequestWrapper(localName="linkRechargeCard", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.LinkRechargeCard")
  @WebResult(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/")
  public com.imum.ws.BulkSale.RechargeCardObj linkRechargeCard(@WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cardNo")
    String cardNo, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="msisdn")
    String msisdn, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="userId")
    String userId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="pwd")
    String pwd, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cvc")
    String cvc, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="expiryDate")
    String expiryDate, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="emiratesID")
    String emiratesID, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="activationSource")
    String activationSource);

  @WebMethod
  @Action(input="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/topupMWalletRequest",
    output="http://ws.sale.rc.mparking.infocomm.com/RCSaleWS/topupMWalletResponse")
  @ResponseWrapper(localName="topupMWalletResponse", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.TopupMWalletResponse")
  @RequestWrapper(localName="topupMWallet", targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
    className="com.imum.ws.BulkSale.TopupMWallet")
  @WebResult(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/")
  public com.imum.ws.BulkSale.MWalletObj topupMWallet(@WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="msisdn")
    String msisdn, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="cardNo")
    String cardNo, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="amount")
    int amount, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="parkingShopId")
    String parkingShopId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="userId")
    String userId, @WebParam(targetNamespace="http://ws.sale.rc.mparking.infocomm.com/",
      name="pwd")
    String pwd);
}
