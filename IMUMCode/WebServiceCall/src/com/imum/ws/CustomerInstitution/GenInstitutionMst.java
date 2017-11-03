
package com.imum.ws.CustomerInstitution;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GenInstitutionMst complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenInstitutionMst">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="instName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="tradeLicenseNum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="instType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="custInstAddrSeq" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="City_Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Country_Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Landline_num" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="alternatePhoneNum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Fax_num" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Primary_contact" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Email_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Active_flag" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
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
 *         &lt;element name="instUrl" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GenAddressDetailsCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GenAddressDetails" type="{http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL}GenAddressDetails" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenInstitutionMst", propOrder = {
    "instId",
    "instName",
    "tradeLicenseNum",
    "instType",
    "custInstAddrSeq",
    "cityCode",
    "countryCode",
    "landlineNum",
    "alternatePhoneNum",
    "faxNum",
    "primaryContact",
    "emailID",
    "activeFlag",
    "createdBy",
    "createdDate",
    "updatedBy",
    "updateDate",
    "instUrl",
    "genAddressDetailsCollection"
})
public class GenInstitutionMst {

    protected long instId;
    @XmlElementRef(name = "instName", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> instName;
    @XmlElementRef(name = "tradeLicenseNum", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> tradeLicenseNum;
    @XmlElementRef(name = "instType", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> instType;
    @XmlElementRef(name = "custInstAddrSeq", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<Long> custInstAddrSeq;
    @XmlElementRef(name = "City_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> cityCode;
    @XmlElementRef(name = "Country_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> countryCode;
    @XmlElementRef(name = "Landline_num", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> landlineNum;
    @XmlElementRef(name = "alternatePhoneNum", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> alternatePhoneNum;
    @XmlElementRef(name = "Fax_num", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> faxNum;
    @XmlElementRef(name = "Primary_contact", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> primaryContact;
    @XmlElementRef(name = "Email_ID", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> emailID;
    @XmlElementRef(name = "Active_flag", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> activeFlag;
    @XmlElementRef(name = "Created_By", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> createdBy;
    @XmlElement(name = "Created_Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlElementRef(name = "Updated_by", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> updatedBy;
    @XmlElementRef(name = "Update_date", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> updateDate;
    @XmlElementRef(name = "instUrl", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> instUrl;
    @XmlElement(name = "GenAddressDetailsCollection")
    protected GenInstitutionMst.GenAddressDetailsCollection genAddressDetailsCollection;

    /**
     * Gets the value of the instId property.
     * 
     */
    public long getInstId() {
        return instId;
    }

    /**
     * Sets the value of the instId property.
     * 
     */
    public void setInstId(long value) {
        this.instId = value;
    }

    /**
     * Gets the value of the instName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstName() {
        return instName;
    }

    /**
     * Sets the value of the instName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstName(JAXBElement<String> value) {
        this.instName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the tradeLicenseNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTradeLicenseNum() {
        return tradeLicenseNum;
    }

    /**
     * Sets the value of the tradeLicenseNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTradeLicenseNum(JAXBElement<String> value) {
        this.tradeLicenseNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the instType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstType() {
        return instType;
    }

    /**
     * Sets the value of the instType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstType(JAXBElement<String> value) {
        this.instType = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the custInstAddrSeq property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCustInstAddrSeq() {
        return custInstAddrSeq;
    }

    /**
     * Sets the value of the custInstAddrSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCustInstAddrSeq(JAXBElement<Long> value) {
        this.custInstAddrSeq = ((JAXBElement<Long> ) value);
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
     * Gets the value of the landlineNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLandlineNum() {
        return landlineNum;
    }

    /**
     * Sets the value of the landlineNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLandlineNum(JAXBElement<String> value) {
        this.landlineNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the alternatePhoneNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAlternatePhoneNum() {
        return alternatePhoneNum;
    }

    /**
     * Sets the value of the alternatePhoneNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAlternatePhoneNum(JAXBElement<String> value) {
        this.alternatePhoneNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the faxNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFaxNum() {
        return faxNum;
    }

    /**
     * Sets the value of the faxNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFaxNum(JAXBElement<String> value) {
        this.faxNum = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the primaryContact property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrimaryContact() {
        return primaryContact;
    }

    /**
     * Sets the value of the primaryContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrimaryContact(JAXBElement<String> value) {
        this.primaryContact = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the emailID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmailID() {
        return emailID;
    }

    /**
     * Sets the value of the emailID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmailID(JAXBElement<String> value) {
        this.emailID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the activeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getActiveFlag() {
        return activeFlag;
    }

    /**
     * Sets the value of the activeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setActiveFlag(JAXBElement<String> value) {
        this.activeFlag = ((JAXBElement<String> ) value);
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

    /**
     * Gets the value of the instUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstUrl() {
        return instUrl;
    }

    /**
     * Sets the value of the instUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstUrl(JAXBElement<String> value) {
        this.instUrl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the genAddressDetailsCollection property.
     * 
     * @return
     *     possible object is
     *     {@link GenInstitutionMst.GenAddressDetailsCollection }
     *     
     */
    public GenInstitutionMst.GenAddressDetailsCollection getGenAddressDetailsCollection() {
        return genAddressDetailsCollection;
    }

    /**
     * Sets the value of the genAddressDetailsCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenInstitutionMst.GenAddressDetailsCollection }
     *     
     */
    public void setGenAddressDetailsCollection(GenInstitutionMst.GenAddressDetailsCollection value) {
        this.genAddressDetailsCollection = value;
    }


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
     *         &lt;element name="GenAddressDetails" type="{http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL}GenAddressDetails" maxOccurs="unbounded" minOccurs="0"/>
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
        "genAddressDetails"
    })
    public static class GenAddressDetailsCollection {

        @XmlElement(name = "GenAddressDetails")
        protected List<GenAddressDetails> genAddressDetails;

        /**
         * Gets the value of the genAddressDetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the genAddressDetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGenAddressDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GenAddressDetails }
         * 
         * 
         */
        public List<GenAddressDetails> getGenAddressDetails() {
            if (genAddressDetails == null) {
                genAddressDetails = new ArrayList<GenAddressDetails>();
            }
            return this.genAddressDetails;
        }

    }

}
