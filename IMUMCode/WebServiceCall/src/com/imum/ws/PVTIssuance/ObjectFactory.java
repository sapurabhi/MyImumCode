
package com.imum.ws.PVTIssuance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.imum.ws.PVTIssuance package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PVTHHCRequestLogLocalAuthId_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "localAuthId");
    private final static QName _PVTHHCRequestLogOrgObsrvSeq_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Org_Obsrv_Seq");
    private final static QName _PVTHHCRequestLogResponseTime_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "responseTime");
    private final static QName _PVTHHCRequestLogPvtPrintDatetime_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "pvtPrintDatetime");
    private final static QName _PVTHHCRequestLogMemoDetails_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "memoDetails");
    private final static QName _PVTHHCRequestLogPrintCount_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "printCount");
    private final static QName _PVTHHCRequestLogPvtIssDatetime_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "pvtIssDatetime");
    private final static QName _PVTHHCRequestLogObsrvTo_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Obsrv_To");
    private final static QName _PVTHHCRequestLogPVTNum_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "PVT_Num");
    private final static QName _PVTObservationOrIssuanceRequest_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "PVT_ObservationOrIssuance_Request");
    private final static QName _PVTObservationOrIssuanceResponseContraCode_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Contra_code");
    private final static QName _PVTObservationOrIssuanceResponseStatus_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Status");
    private final static QName _PVTObservationOrIssuanceResponseObsrvStatusCode_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Obsrv_Status_Code");
    private final static QName _PVTObservationOrIssuanceResponseResponseDesc_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Response_Desc");
    private final static QName _PVTObservationOrIssuanceResponseResponseCode_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Response_Code");
    private final static QName _PVTObservationOrIssuanceResponsePlateNumber_QNAME = new QName("http://www.zoneparking.ae/PVT_ObservationOrIssuance", "Plate_Number");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.imum.ws.PVTIssuance
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PVTObservationOrIssuanceResponse }
     * 
     */
    public PVTObservationOrIssuanceResponse createPVTObservationOrIssuanceResponse() {
        return new PVTObservationOrIssuanceResponse();
    }

    /**
     * Create an instance of {@link PVTHHCRequestLog }
     * 
     */
    public PVTHHCRequestLog createPVTHHCRequestLog() {
        return new PVTHHCRequestLog();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "localAuthId", scope = PVTHHCRequestLog.class)
    public JAXBElement<Integer> createPVTHHCRequestLogLocalAuthId(Integer value) {
        return new JAXBElement<Integer>(_PVTHHCRequestLogLocalAuthId_QNAME, Integer.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Org_Obsrv_Seq", scope = PVTHHCRequestLog.class)
    public JAXBElement<Long> createPVTHHCRequestLogOrgObsrvSeq(Long value) {
        return new JAXBElement<Long>(_PVTHHCRequestLogOrgObsrvSeq_QNAME, Long.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "responseTime", scope = PVTHHCRequestLog.class)
    public JAXBElement<XMLGregorianCalendar> createPVTHHCRequestLogResponseTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PVTHHCRequestLogResponseTime_QNAME, XMLGregorianCalendar.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "pvtPrintDatetime", scope = PVTHHCRequestLog.class)
    public JAXBElement<XMLGregorianCalendar> createPVTHHCRequestLogPvtPrintDatetime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PVTHHCRequestLogPvtPrintDatetime_QNAME, XMLGregorianCalendar.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "memoDetails", scope = PVTHHCRequestLog.class)
    public JAXBElement<String> createPVTHHCRequestLogMemoDetails(String value) {
        return new JAXBElement<String>(_PVTHHCRequestLogMemoDetails_QNAME, String.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "printCount", scope = PVTHHCRequestLog.class)
    public JAXBElement<Integer> createPVTHHCRequestLogPrintCount(Integer value) {
        return new JAXBElement<Integer>(_PVTHHCRequestLogPrintCount_QNAME, Integer.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "pvtIssDatetime", scope = PVTHHCRequestLog.class)
    public JAXBElement<XMLGregorianCalendar> createPVTHHCRequestLogPvtIssDatetime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PVTHHCRequestLogPvtIssDatetime_QNAME, XMLGregorianCalendar.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Obsrv_To", scope = PVTHHCRequestLog.class)
    public JAXBElement<XMLGregorianCalendar> createPVTHHCRequestLogObsrvTo(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PVTHHCRequestLogObsrvTo_QNAME, XMLGregorianCalendar.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "PVT_Num", scope = PVTHHCRequestLog.class)
    public JAXBElement<String> createPVTHHCRequestLogPVTNum(String value) {
        return new JAXBElement<String>(_PVTHHCRequestLogPVTNum_QNAME, String.class, PVTHHCRequestLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PVTHHCRequestLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "PVT_ObservationOrIssuance_Request")
    public JAXBElement<PVTHHCRequestLog> createPVTObservationOrIssuanceRequest(PVTHHCRequestLog value) {
        return new JAXBElement<PVTHHCRequestLog>(_PVTObservationOrIssuanceRequest_QNAME, PVTHHCRequestLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Contra_code", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponseContraCode(String value) {
        return new JAXBElement<String>(_PVTObservationOrIssuanceResponseContraCode_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Org_Obsrv_Seq", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponseOrgObsrvSeq(String value) {
        return new JAXBElement<String>(_PVTHHCRequestLogOrgObsrvSeq_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Status", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponseStatus(String value) {
        return new JAXBElement<String>(_PVTObservationOrIssuanceResponseStatus_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Obsrv_Status_Code", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponseObsrvStatusCode(String value) {
        return new JAXBElement<String>(_PVTObservationOrIssuanceResponseObsrvStatusCode_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Response_Desc", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponseResponseDesc(String value) {
        return new JAXBElement<String>(_PVTObservationOrIssuanceResponseResponseDesc_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Response_Code", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponseResponseCode(String value) {
        return new JAXBElement<String>(_PVTObservationOrIssuanceResponseResponseCode_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "PVT_Num", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponsePVTNum(String value) {
        return new JAXBElement<String>(_PVTHHCRequestLogPVTNum_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zoneparking.ae/PVT_ObservationOrIssuance", name = "Plate_Number", scope = PVTObservationOrIssuanceResponse.class)
    public JAXBElement<String> createPVTObservationOrIssuanceResponsePlateNumber(String value) {
        return new JAXBElement<String>(_PVTObservationOrIssuanceResponsePlateNumber_QNAME, String.class, PVTObservationOrIssuanceResponse.class, value);
    }

}
