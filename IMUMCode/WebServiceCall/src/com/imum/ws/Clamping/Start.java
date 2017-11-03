
package com.imum.ws.Clamping;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="pvthdrseq" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="requestType" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "pvthdrseq",
    "requestType"
})
@XmlRootElement(name = "start")
public class Start {

    protected long pvthdrseq;
    protected int requestType;

    /**
     * Gets the value of the pvthdrseq property.
     * 
     */
    public long getPvthdrseq() {
        return pvthdrseq;
    }

    /**
     * Sets the value of the pvthdrseq property.
     * 
     */
    public void setPvthdrseq(long value) {
        this.pvthdrseq = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     */
    public int getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     */
    public void setRequestType(int value) {
        this.requestType = value;
    }

}
