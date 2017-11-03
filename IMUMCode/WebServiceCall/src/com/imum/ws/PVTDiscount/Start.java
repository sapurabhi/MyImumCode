
package com.imum.ws.PVTDiscount;

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
 *         &lt;element name="bulkdiscountheaderSeq" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "bulkdiscountheaderSeq"
})
@XmlRootElement(name = "start")
public class Start {

    protected long bulkdiscountheaderSeq;

    /**
     * Gets the value of the bulkdiscountheaderSeq property.
     * 
     */
    public long getBulkdiscountheaderSeq() {
        return bulkdiscountheaderSeq;
    }

    /**
     * Sets the value of the bulkdiscountheaderSeq property.
     * 
     */
    public void setBulkdiscountheaderSeq(long value) {
        this.bulkdiscountheaderSeq = value;
    }

}
