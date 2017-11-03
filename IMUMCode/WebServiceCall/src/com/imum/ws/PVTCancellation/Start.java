
package com.imum.ws.PVTCancellation;

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
 *         &lt;element name="PVTNum" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "pvtNum"
})
@XmlRootElement(name = "start")
public class Start {

    @XmlElement(name = "PVTNum")
    protected long pvtNum;

    /**
     * Gets the value of the pvtNum property.
     * 
     */
    public long getPVTNum() {
        return pvtNum;
    }

    /**
     * Sets the value of the pvtNum property.
     * 
     */
    public void setPVTNum(long value) {
        this.pvtNum = value;
    }

}
