
package com.imum.ws.BulkSale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rechargeCardObj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rechargeCardObj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="costPerCard" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cvc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expiryMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationStatusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operationStatusDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rechargeCardNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rechargeCardStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rechargeCardObj", propOrder = {
    "costPerCard",
    "cvc",
    "expiryMonth",
    "msisdn",
    "operationStatusCode",
    "operationStatusDesc",
    "rechargeCardNo",
    "rechargeCardStatus",
    "sessionID"
})
public class RechargeCardObj {

    protected int costPerCard;
    protected String cvc;
    protected String expiryMonth;
    protected String msisdn;
    protected int operationStatusCode;
    protected String operationStatusDesc;
    protected String rechargeCardNo;
    protected String rechargeCardStatus;
    protected String sessionID;

    /**
     * Gets the value of the costPerCard property.
     * 
     */
    public int getCostPerCard() {
        return costPerCard;
    }

    /**
     * Sets the value of the costPerCard property.
     * 
     */
    public void setCostPerCard(int value) {
        this.costPerCard = value;
    }

    /**
     * Gets the value of the cvc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * Sets the value of the cvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvc(String value) {
        this.cvc = value;
    }

    /**
     * Gets the value of the expiryMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * Sets the value of the expiryMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryMonth(String value) {
        this.expiryMonth = value;
    }

    /**
     * Gets the value of the msisdn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsisdn(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the operationStatusCode property.
     * 
     */
    public int getOperationStatusCode() {
        return operationStatusCode;
    }

    /**
     * Sets the value of the operationStatusCode property.
     * 
     */
    public void setOperationStatusCode(int value) {
        this.operationStatusCode = value;
    }

    /**
     * Gets the value of the operationStatusDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationStatusDesc() {
        return operationStatusDesc;
    }

    /**
     * Sets the value of the operationStatusDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationStatusDesc(String value) {
        this.operationStatusDesc = value;
    }

    /**
     * Gets the value of the rechargeCardNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechargeCardNo() {
        return rechargeCardNo;
    }

    /**
     * Sets the value of the rechargeCardNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechargeCardNo(String value) {
        this.rechargeCardNo = value;
    }

    /**
     * Gets the value of the rechargeCardStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechargeCardStatus() {
        return rechargeCardStatus;
    }

    /**
     * Sets the value of the rechargeCardStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechargeCardStatus(String value) {
        this.rechargeCardStatus = value;
    }

    /**
     * Gets the value of the sessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

}
