
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
 *         &lt;element name="InsertWorkResult" type="{http://tempuri.org/}NotifyTodoAppResult" minOccurs="0"/>
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
    "insertWorkResult"
})
@XmlRootElement(name = "InsertWorkResponse")
public class InsertWorkResponse {

    @XmlElement(name = "InsertWorkResult")
    protected NotifyTodoAppResult insertWorkResult;

    /**
     * Gets the value of the insertWorkResult property.
     * 
     * @return
     *     possible object is
     *     {@link NotifyTodoAppResult }
     *     
     */
    public NotifyTodoAppResult getInsertWorkResult() {
        return insertWorkResult;
    }

    /**
     * Sets the value of the insertWorkResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotifyTodoAppResult }
     *     
     */
    public void setInsertWorkResult(NotifyTodoAppResult value) {
        this.insertWorkResult = value;
    }

}
