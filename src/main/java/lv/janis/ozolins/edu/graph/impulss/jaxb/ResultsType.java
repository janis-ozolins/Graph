
package lv.janis.ozolins.edu.graph.impulss.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="unconditional-result" type="{}unconditional-resultType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultsType", propOrder = {
    "unconditionalResult"
})
public class ResultsType {

    @XmlElement(name = "unconditional-result", required = true)
    protected UnconditionalResultType unconditionalResult;

    /**
     * Gets the value of the unconditionalResult property.
     * 
     * @return
     *     possible object is
     *     {@link UnconditionalResultType }
     *     
     */
    public UnconditionalResultType getUnconditionalResult() {
        return unconditionalResult;
    }

    /**
     * Sets the value of the unconditionalResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnconditionalResultType }
     *     
     */
    public void setUnconditionalResult(UnconditionalResultType value) {
        this.unconditionalResult = value;
    }

}
