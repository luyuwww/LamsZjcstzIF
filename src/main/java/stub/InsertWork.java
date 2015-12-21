
package stub;

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
 *         &lt;element name="waitWork" type="{http://tempuri.org/}WaitWork" minOccurs="0"/>
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
    "waitWork"
})
@XmlRootElement(name = "InsertWork")
public class InsertWork {

    protected WaitWork waitWork;

    /**
     * Gets the value of the waitWork property.
     * 
     * @return
     *     possible object is
     *     {@link WaitWork }
     *     
     */
    public WaitWork getWaitWork() {
        return waitWork;
    }

    /**
     * Sets the value of the waitWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link WaitWork }
     *     
     */
    public void setWaitWork(WaitWork value) {
        this.waitWork = value;
    }

}
