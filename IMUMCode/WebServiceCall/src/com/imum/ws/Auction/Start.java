
package com.imum.ws.Auction;

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
 *         &lt;element name="auctionHdrSeq" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "auctionHdrSeq"
})
@XmlRootElement(name = "start")
public class Start {

    protected long auctionHdrSeq;

    /**
     * Gets the value of the auctionHdrSeq property.
     * 
     */
    public long getAuctionHdrSeq() {
        return auctionHdrSeq;
    }

    /**
     * Sets the value of the auctionHdrSeq property.
     * 
     */
    public void setAuctionHdrSeq(long value) {
        this.auctionHdrSeq = value;
    }

}
