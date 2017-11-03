
package com.oracle.xmlns.bpmn.bpmnprocess.pvtwriteoffapprovalbpm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="Req_WRITEOFF_HDR_Seq" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "reqWRITEOFFHDRSeq"
})
@XmlRootElement(name = "start")
public class Start {

    @XmlElement(name = "Req_WRITEOFF_HDR_Seq")
    protected long reqWRITEOFFHDRSeq;

    /**
     * Gets the value of the reqWRITEOFFHDRSeq property.
     * 
     */
    public long getReqWRITEOFFHDRSeq() {
        return reqWRITEOFFHDRSeq;
    }

    /**
     * Sets the value of the reqWRITEOFFHDRSeq property.
     * 
     */
    public void setReqWRITEOFFHDRSeq(long value) {
        this.reqWRITEOFFHDRSeq = value;
    }

}
