
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
    "pvthdrseq"
})
@XmlRootElement(name = "cancellationrequest")
public class Cancellationrequest {

    protected long pvthdrseq;

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

}
