
package com.imum.ws.PVTIssuance;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PVT_HHC_Request_log complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PVT_HHC_Request_log">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Request_log_seq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Request_Type" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Org_Obsrv_Seq" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Obsrv_from" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Obsrv_To" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="piId" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Sector_Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="zoneCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PVT_Num" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Contra_code" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="contraAmt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="pvtIssDatetime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="pvtPrintDatetime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="HHC_Serial_Num" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="printCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="VEH_geo_lat" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VEH_geo_lon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="plateNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Plate_Country_ID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="plateCtgId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="plateTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vehMakeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vehModelId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vehColourId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Tariff_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="localAuthId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memoDetails" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="responseTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Request_DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Created_By" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Created_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PVT_HHC_Request_log", propOrder = {
    "requestLogSeq",
    "requestType",
    "orgObsrvSeq",
    "obsrvFrom",
    "obsrvTo",
    "piId",
    "sectorCode",
    "zoneCode",
    "pvtNum",
    "contraCode",
    "contraAmt",
    "pvtIssDatetime",
    "pvtPrintDatetime",
    "hhcSerialNum",
    "printCount",
    "vehGeoLat",
    "vehGeoLon",
    "plateNumber",
    "plateCountryID",
    "plateCtgId",
    "plateTypeId",
    "vehMakeId",
    "vehModelId",
    "vehColourId",
    "tariffID",
    "localAuthId",
    "memoDetails",
    "responseTime",
    "requestDateTime",
    "createdBy",
    "createdDate"
})
public class PVTHHCRequestLog {

    @XmlElement(name = "Request_log_seq", required = true, nillable = true)
    protected String requestLogSeq;
    @XmlElement(name = "Request_Type")
    protected String requestType;
    @XmlElementRef(name = "Org_Obsrv_Seq", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<Long> orgObsrvSeq;
    @XmlElement(name = "Obsrv_from")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar obsrvFrom;
    @XmlElementRef(name = "Obsrv_To", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> obsrvTo;
    protected String piId;
    @XmlElement(name = "Sector_Code")
    protected String sectorCode;
    protected String zoneCode;
    @XmlElementRef(name = "PVT_Num", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> pvtNum;
    @XmlElement(name = "Contra_code")
    protected Integer contraCode;
    protected BigDecimal contraAmt;
    @XmlElementRef(name = "pvtIssDatetime", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> pvtIssDatetime;
    @XmlElementRef(name = "pvtPrintDatetime", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> pvtPrintDatetime;
    @XmlElement(name = "HHC_Serial_Num")
    protected String hhcSerialNum;
    @XmlElementRef(name = "printCount", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<Integer> printCount;
    @XmlElement(name = "VEH_geo_lat")
    protected Double vehGeoLat;
    @XmlElement(name = "VEH_geo_lon")
    protected Double vehGeoLon;
    protected String plateNumber;
    @XmlElement(name = "Plate_Country_ID")
    protected Integer plateCountryID;
    protected Integer plateCtgId;
    protected Integer plateTypeId;
    protected Integer vehMakeId;
    protected Integer vehModelId;
    protected Integer vehColourId;
    @XmlElement(name = "Tariff_ID")
    protected String tariffID;
    @XmlElementRef(name = "localAuthId", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<Integer> localAuthId;
    @XmlElementRef(name = "memoDetails", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<String> memoDetails;
    @XmlElementRef(name = "responseTime", namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> responseTime;
    @XmlElement(name = "Request_DateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestDateTime;
    @XmlElement(name = "Created_By")
    protected String createdBy;
    @XmlElement(name = "Created_Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;

    /**
     * Gets the value of the requestLogSeq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestLogSeq() {
        return requestLogSeq;
    }

    /**
     * Sets the value of the requestLogSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestLogSeq(String value) {
        this.requestLogSeq = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestType(String value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the orgObsrvSeq property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrgObsrvSeq() {
        return orgObsrvSeq;
    }

    /**
     * Sets the value of the orgObsrvSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrgObsrvSeq(JAXBElement<Long> value) {
        this.orgObsrvSeq = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the obsrvFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObsrvFrom() {
        return obsrvFrom;
    }

    /**
     * Sets the value of the obsrvFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObsrvFrom(XMLGregorianCalendar value) {
        this.obsrvFrom = value;
    }

    /**
     * Gets the value of the obsrvTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getObsrvTo() {
        return obsrvTo;
    }

    /**
     * Sets the value of the obsrvTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setObsrvTo(JAXBElement<XMLGregorianCalendar> value) {
        this.obsrvTo = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the piId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPiId() {
        return piId;
    }

    /**
     * Sets the value of the piId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPiId(String value) {
        this.piId = value;
    }

    /**
     * Gets the value of the sectorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectorCode() {
        return sectorCode;
    }

    /**
     * Sets the value of the sectorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectorCode(String value) {
        this.sectorCode = value;
    }

    /**
     * Gets the value of the zoneCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * Sets the value of the zoneCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneCode(String value) {
        this.zoneCode = value;
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
     * Gets the value of the contraCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContraCode() {
        return contraCode;
    }

    /**
     * Sets the value of the contraCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContraCode(Integer value) {
        this.contraCode = value;
    }

    /**
     * Gets the value of the contraAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getContraAmt() {
        return contraAmt;
    }

    /**
     * Sets the value of the contraAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setContraAmt(BigDecimal value) {
        this.contraAmt = value;
    }

    /**
     * Gets the value of the pvtIssDatetime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getPvtIssDatetime() {
        return pvtIssDatetime;
    }

    /**
     * Sets the value of the pvtIssDatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setPvtIssDatetime(JAXBElement<XMLGregorianCalendar> value) {
        this.pvtIssDatetime = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the pvtPrintDatetime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getPvtPrintDatetime() {
        return pvtPrintDatetime;
    }

    /**
     * Sets the value of the pvtPrintDatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setPvtPrintDatetime(JAXBElement<XMLGregorianCalendar> value) {
        this.pvtPrintDatetime = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the hhcSerialNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHHCSerialNum() {
        return hhcSerialNum;
    }

    /**
     * Sets the value of the hhcSerialNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHHCSerialNum(String value) {
        this.hhcSerialNum = value;
    }

    /**
     * Gets the value of the printCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getPrintCount() {
        return printCount;
    }

    /**
     * Sets the value of the printCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setPrintCount(JAXBElement<Integer> value) {
        this.printCount = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the vehGeoLat property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVEHGeoLat() {
        return vehGeoLat;
    }

    /**
     * Sets the value of the vehGeoLat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVEHGeoLat(Double value) {
        this.vehGeoLat = value;
    }

    /**
     * Gets the value of the vehGeoLon property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVEHGeoLon() {
        return vehGeoLon;
    }

    /**
     * Sets the value of the vehGeoLon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVEHGeoLon(Double value) {
        this.vehGeoLon = value;
    }

    /**
     * Gets the value of the plateNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Sets the value of the plateNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateNumber(String value) {
        this.plateNumber = value;
    }

    /**
     * Gets the value of the plateCountryID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlateCountryID() {
        return plateCountryID;
    }

    /**
     * Sets the value of the plateCountryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlateCountryID(Integer value) {
        this.plateCountryID = value;
    }

    /**
     * Gets the value of the plateCtgId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlateCtgId() {
        return plateCtgId;
    }

    /**
     * Sets the value of the plateCtgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlateCtgId(Integer value) {
        this.plateCtgId = value;
    }

    /**
     * Gets the value of the plateTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlateTypeId() {
        return plateTypeId;
    }

    /**
     * Sets the value of the plateTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlateTypeId(Integer value) {
        this.plateTypeId = value;
    }

    /**
     * Gets the value of the vehMakeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVehMakeId() {
        return vehMakeId;
    }

    /**
     * Sets the value of the vehMakeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVehMakeId(Integer value) {
        this.vehMakeId = value;
    }

    /**
     * Gets the value of the vehModelId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVehModelId() {
        return vehModelId;
    }

    /**
     * Sets the value of the vehModelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVehModelId(Integer value) {
        this.vehModelId = value;
    }

    /**
     * Gets the value of the vehColourId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVehColourId() {
        return vehColourId;
    }

    /**
     * Sets the value of the vehColourId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVehColourId(Integer value) {
        this.vehColourId = value;
    }

    /**
     * Gets the value of the tariffID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffID() {
        return tariffID;
    }

    /**
     * Sets the value of the tariffID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffID(String value) {
        this.tariffID = value;
    }

    /**
     * Gets the value of the localAuthId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getLocalAuthId() {
        return localAuthId;
    }

    /**
     * Sets the value of the localAuthId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setLocalAuthId(JAXBElement<Integer> value) {
        this.localAuthId = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the memoDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemoDetails() {
        return memoDetails;
    }

    /**
     * Sets the value of the memoDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemoDetails(JAXBElement<String> value) {
        this.memoDetails = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the responseTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getResponseTime() {
        return responseTime;
    }

    /**
     * Sets the value of the responseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setResponseTime(JAXBElement<XMLGregorianCalendar> value) {
        this.responseTime = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the requestDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDateTime() {
        return requestDateTime;
    }

    /**
     * Sets the value of the requestDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDateTime(XMLGregorianCalendar value) {
        this.requestDateTime = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
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

}
