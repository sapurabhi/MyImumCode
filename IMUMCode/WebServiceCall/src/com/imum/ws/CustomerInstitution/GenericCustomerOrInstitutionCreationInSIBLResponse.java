
package com.imum.ws.CustomerInstitution;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cust_Inst_ID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Response_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Response_Desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "custInstID",
    "status",
    "responseCode",
    "responseDesc"
})
@XmlRootElement(name = "Generic_CustomerOrInstitutionCreationInSIBL_Response")
public class GenericCustomerOrInstitutionCreationInSIBLResponse {

    @XmlElement(name = "Cust_Inst_ID", required = true)
    protected BigInteger custInstID;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElementRef(name = "Response_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> responseCode;
    @XmlElementRef(name = "Response_Desc", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> responseDesc;

    /**
     * Gets the value of the custInstID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCustInstID() {
        return custInstID;
    }

    /**
     * Sets the value of the custInstID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCustInstID(BigInteger value) {
        this.custInstID = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResponseCode(JAXBElement<String> value) {
        this.responseCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the responseDesc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResponseDesc() {
        return responseDesc;
    }

    /**
     * Sets the value of the responseDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResponseDesc(JAXBElement<String> value) {
        this.responseDesc = ((JAXBElement<String> ) value);
    }

}
