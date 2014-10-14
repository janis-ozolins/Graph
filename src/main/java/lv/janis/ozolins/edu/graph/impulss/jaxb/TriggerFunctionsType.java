
package lv.janis.ozolins.edu.graph.impulss.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trigger-functionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trigger-functionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trigger-function" type="{}trigger-functionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trigger-functionsType", propOrder = {
    "triggerFunction"
})
public class TriggerFunctionsType {

    @XmlElement(name = "trigger-function")
    protected List<TriggerFunctionType> triggerFunction;

    /**
     * Gets the value of the triggerFunction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the triggerFunction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTriggerFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TriggerFunctionType }
     * 
     * 
     */
    public List<TriggerFunctionType> getTriggerFunction() {
        if (triggerFunction == null) {
            triggerFunction = new ArrayList<TriggerFunctionType>();
        }
        return this.triggerFunction;
    }

}
