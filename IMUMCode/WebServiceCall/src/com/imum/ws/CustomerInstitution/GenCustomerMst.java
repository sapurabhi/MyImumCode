
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
 * <p>Java class for GenCustomerMst complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenCustomerMst">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cust_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Salutation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Last_Name" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="First_Name" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Middle_Name" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Gender" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Emirates_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Resident_type" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Nationality" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
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
 *         &lt;element name="Mobile_num" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
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
 *         &lt;element name="Comments" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Legacy_info" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2000"/>
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
@XmlType(name = "GenCustomerMst", propOrder = {
    "custID",
    "salutation",
    "lastName",
    "firstName",
    "middleName",
    "gender",
    "emiratesID",
    "residentType",
    "nationality",
    "cityCode",
    "countryCode",
    "mobileNum",
    "landlineNum",
    "alternatePhoneNum",
    "emailID",
    "activeFlag",
    "comments",
    "legacyInfo",
    "createdBy",
    "createdDate",
    "updatedBy",
    "updateDate",
    "genAddressDetailsCollection"
})
public class GenCustomerMst {

    @XmlElement(name = "Cust_ID")
    protected long custID;
    @XmlElementRef(name = "Salutation", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> salutation;
    @XmlElementRef(name = "Last_Name", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> lastName;
    @XmlElementRef(name = "First_Name", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> firstName;
    @XmlElementRef(name = "Middle_Name", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> middleName;
    @XmlElementRef(name = "Gender", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> gender;
    @XmlElementRef(name = "Emirates_ID", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> emiratesID;
    @XmlElementRef(name = "Resident_type", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> residentType;
    @XmlElementRef(name = "Nationality", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> nationality;
    @XmlElementRef(name = "City_Code", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> cityCode;
    @XmlElement(name = "Country_code")
    protected String countryCode;
    @XmlElementRef(name = "Mobile_num", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> mobileNum;
    @XmlElementRef(name = "Landline_num", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> landlineNum;
    @XmlElementRef(name = "alternatePhoneNum", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> alternatePhoneNum;
    @XmlElementRef(name = "Email_ID", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> emailID;
    @XmlElementRef(name = "Active_flag", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> activeFlag;
    @XmlElementRef(name = "Comments", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "Legacy_info", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> legacyInfo;
    @XmlElementRef(name = "Created_By", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> createdBy;
    @XmlElement(name = "Created_Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlElementRef(name = "Updated_by", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<String> updatedBy;
    @XmlElementRef(name = "Update_date", namespace = "http://www.zoneparking.ae/Generic_CustomerOrInstitutionCreationInSIBL", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> updateDate;
    @XmlElement(name = "GenAddressDetailsCollection")
    protected GenCustomerMst.GenAddressDetailsCollection genAddressDetailsCollection;

    /**
     * Gets the value of the custID property.
     * 
     */
    public long getCustID() {
        return custID;
    }

    /**
     * Sets the value of the custID property.
     * 
     */
    public void setCustID(long value) {
        this.custID = value;
    }

    /**
     * Gets the value of the salutation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalutation(JAXBElement<String> value) {
        this.salutation = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastName(JAXBElement<String> value) {
        this.lastName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstName(JAXBElement<String> value) {
        this.firstName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMiddleName(JAXBElement<String> value) {
        this.middleName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGender(JAXBElement<String> value) {
        this.gender = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the emiratesID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmiratesID() {
        return emiratesID;
    }

    /**
     * Sets the value of the emiratesID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmiratesID(JAXBElement<String> value) {
        this.emiratesID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the residentType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResidentType() {
        return residentType;
    }

    /**
     * Sets the value of the residentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResidentType(JAXBElement<String> value) {
        this.residentType = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNationality(JAXBElement<String> value) {
        this.nationality = ((JAXBElement<String> ) value);
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
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the mobileNum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMobileNum() {
        return mobileNum;
    }

    /**
     * Sets the value of the mobileNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMobileNum(JAXBElement<String> value) {
        this.mobileNum = ((JAXBElement<String> ) value);
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
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComments(JAXBElement<String> value) {
        this.comments = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the legacyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegacyInfo() {
        return legacyInfo;
    }

    /**
     * Sets the value of the legacyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegacyInfo(JAXBElement<String> value) {
        this.legacyInfo = ((JAXBElement<String> ) value);
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
     * Gets the value of the genAddressDetailsCollection property.
     * 
     * @return
     *     possible object is
     *     {@link GenCustomerMst.GenAddressDetailsCollection }
     *     
     */
    public GenCustomerMst.GenAddressDetailsCollection getGenAddressDetailsCollection() {
        return genAddressDetailsCollection;
    }

    /**
     * Sets the value of the genAddressDetailsCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenCustomerMst.GenAddressDetailsCollection }
     *     
     */
    public void setGenAddressDetailsCollection(GenCustomerMst.GenAddressDetailsCollection value) {
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
