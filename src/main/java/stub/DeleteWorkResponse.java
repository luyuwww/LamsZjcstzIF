
package stub;

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
 *         &lt;element name="DeleteWorkResult" type="{http://tempuri.org/}NotifyTodoAppResult" minOccurs="0"/>
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
    "deleteWorkResult"
})
@XmlRootElement(name = "DeleteWorkResponse")
public class DeleteWorkResponse {

    @XmlElement(name = "DeleteWorkResult")
    protected NotifyTodoAppResult deleteWorkResult;

    /**
     * Gets the value of the deleteWorkResult property.
     * 
     * @return
     *     possible object is
     *     {@link NotifyTodoAppResult }
     *     
     */
    public NotifyTodoAppResult getDeleteWorkResult() {
        return deleteWorkResult;
    }

    /**
     * Sets the value of the deleteWorkResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotifyTodoAppResult }
     *     
     */
    public void setDeleteWorkResult(NotifyTodoAppResult value) {
        this.deleteWorkResult = value;
    }

}
