
package com.imum.ws.BulkSale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mWalletObj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mWalletObj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operationStatusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operationStatusDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mWalletTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mWalletObj", propOrder = {
    "operationStatusCode",
    "operationStatusDesc",
    "mWalletTransactionId"
})
public class MWalletObj {

    protected int operationStatusCode;
    protected String operationStatusDesc;
    protected String mWalletTransactionId;

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
     * Gets the value of the mWalletTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMWalletTransactionId() {
        return mWalletTransactionId;
    }

    /**
     * Sets the value of the mWalletTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMWalletTransactionId(String value) {
        this.mWalletTransactionId = value;
    }

}
