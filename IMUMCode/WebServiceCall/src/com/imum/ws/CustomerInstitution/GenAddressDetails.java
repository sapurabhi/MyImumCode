
package com.imum.ws.CustomerInstitution;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GenAddressDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenAddressDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressDtlSeq" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="utilBillNum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TowTeeq_Num" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="addrLine1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="addrLine2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="addrLine3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Post_Box_Num" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Sector_Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Zone_Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Community_Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="City_Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Country_code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Created_By" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Created_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Updated_by" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Update_date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenAddressDetails", propOrder = {
    "addressDtlSeq",
    "utilBillNum",
    "towTeeqNum",
    "addrLine1",
    "addrLine2",
    "addrLine3",
    "postBoxNum",
    "sectorCode",
    "zoneCode",
    "communityCode",
    "cityCode",
    "countryCode",
    "createdBy",
    "createdDate",
    "updatedBy",
    "updateDate"
})
public class GenAddressDetails {

    protected long addressDtlSeq;
    @XmlElementRef(name = "utilBillNum", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> utilBillNum;
    @XmlElementRef(name = "TowTeeq_Num", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> towTeeqNum;
    @XmlElementRef(name = "addrLine1", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> addrLine1;
    @XmlElementRef(name = "addrLine2", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> addrLine2;
    @XmlElementRef(name = "addrLine3", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> addrLine3;
    @XmlElementRef(name = "Post_Box_Num", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<Long> postBoxNum;
    @XmlElementRef(name = "Sector_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> sectorCode;
    @XmlElementRef(name = "Zone_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> zoneCode;
    @XmlElementRef(name = "Community_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> communityCode;
    @XmlElementRef(name = "City_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> cityCode;
    @XmlElementRef(name = "Country_code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> countryCode;
    @XmlElementRef(name = "Created_By", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> createdBy;
    @XmlElement(name = "Created_Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlElementRef(name = "Updated_by", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> updatedBy;
    @XmlElementRef(name = "Update_date", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> updateDate;

    /**
     * Gets the value of the addressDtlSeq property.
     * 
     */
    public long getAddressDtlSeq() {
        return addressDtlSeq;
    }

    /**
     * Sets the value of the addressDtlSeq property.
     * 
     */
    public void setAddressDtlSeq(long value) {
        this.addressDtlSeq = value;
    }

    /**
     * Gets the value of the utilBillNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUtilBillNum() {
        return utilBillNum;
    }

    /**
     * Sets the value of the utilBillNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUtilBillNum(JAXBElement<String> value) {
        this.utilBillNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the towTeeqNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTowTeeqNum() {
        return towTeeqNum;
    }

    /**
     * Sets the value of the towTeeqNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTowTeeqNum(JAXBElement<String> value) {
        this.towTeeqNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the addrLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrLine1() {
        return addrLine1;
    }

    /**
     * Sets the value of the addrLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrLine1(JAXBElement<String> value) {
        this.addrLine1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the addrLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrLine2() {
        return addrLine2;
    }

    /**
     * Sets the value of the addrLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrLine2(JAXBElement<String> value) {
        this.addrLine2 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the addrLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddrLine3() {
        return addrLine3;
    }

    /**
     * Sets the value of the addrLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddrLine3(JAXBElement<String> value) {
        this.addrLine3 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the postBoxNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPostBoxNum() {
        return postBoxNum;
    }

    /**
     * Sets the value of the postBoxNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPostBoxNum(JAXBElement<Long> value) {
        this.postBoxNum = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the sectorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSectorCode() {
        return sectorCode;
    }

    /**
     * Sets the value of the sectorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSectorCode(JAXBElement<String> value) {
        this.sectorCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the zoneCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getZoneCode() {
        return zoneCode;
    }

    /**
     * Sets the value of the zoneCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setZoneCode(JAXBElement<String> value) {
        this.zoneCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the communityCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCommunityCode() {
        return communityCode;
    }

    /**
     * Sets the value of the communityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCommunityCode(JAXBElement<String> value) {
        this.communityCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cityCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCityCode() {
        return cityCode;
    }

    /**
     * Sets the value of the cityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCityCode(JAXBElement<String> value) {
        this.cityCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountryCode(JAXBElement<String> value) {
        this.countryCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreatedBy(JAXBElement<String> value) {
        this.createdBy = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the updatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets the value of the updatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUpdatedBy(JAXBElement<String> value) {
        this.updatedBy = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the updateDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the value of the updateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setUpdateDate(JAXBElement<XMLGregorianCalendar> value) {
        this.updateDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

}
