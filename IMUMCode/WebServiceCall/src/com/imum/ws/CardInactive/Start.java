
package com.imum.ws.CardInactive;

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
 *         &lt;element name="cardInactive_seq" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "cardInactiveSeq"
})
@XmlRootElement(name = "start")
public class Start {

    @XmlElement(name = "cardInactive_seq")
    protected long cardInactiveSeq;

    /**
     * Gets the value of the cardInactiveSeq property.
     * 
     */
    public long getCardInactiveSeq() {
        return cardInactiveSeq;
    }

    /**
     * Sets the value of the cardInactiveSeq property.
     * 
     */
    public void setCardInactiveSeq(long value) {
        this.cardInactiveSeq = value;
    }

}
