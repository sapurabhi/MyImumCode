
package com.imum.ws.PVTIssuance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="Plate_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contra_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Org_Obsrv_Seq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Obsrv_Status_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PVT_Num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "plateNumber",
    "contraCode",
    "orgObsrvSeq",
    "obsrvStatusCode",
    "pvtNum",
    "status",
    "responseCode",
    "responseDesc"
})
@XmlRootElement(name = "PVT_ObservationOrIssuance_Response")
public class PVTObservationOrIssuanceResponse {

    @XmlElementRef(name = "Plate_Number", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> plateNumber;
    @XmlElementRef(name = "Contra_code", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> contraCode;
    @XmlElementRef(name = "Org_Obsrv_Seq", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> orgObsrvSeq;
    @XmlElementRef(name = "Obsrv_Status_Code", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> obsrvStatusCode;
    @XmlElementRef(name = "PVT_Num", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> pvtNum;
    @XmlElementRef(name = "Status", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "Response_Code", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> responseCode;
    @XmlElementRef(name = "Response_Desc", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> responseDesc;

    /**
     * Gets the value of the plateNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlateNumber() {
        return plateNumber;
    }

    /**
     * Sets the value of the plateNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlateNumber(JAXBElement<String> value) {
        this.plateNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the contraCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContraCode() {
        return contraCode;
    }

    /**
     * Sets the value of the contraCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContraCode(JAXBElement<String> value) {
        this.contraCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the orgObsrvSeq property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgObsrvSeq() {
        return orgObsrvSeq;
    }

    /**
     * Sets the value of the orgObsrvSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgObsrvSeq(JAXBElement<String> value) {
        this.orgObsrvSeq = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the obsrvStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getObsrvStatusCode() {
        return obsrvStatusCode;
    }

    /**
     * Sets the value of the obsrvStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setObsrvStatusCode(JAXBElement<String> value) {
        this.obsrvStatusCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the pvtNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPVTNum() {
        return pvtNum;
    }

    /**
     * Sets the value of the pvtNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPVTNum(JAXBElement<String> value) {
        this.pvtNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = ((JAXBElement<String> ) value);
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
