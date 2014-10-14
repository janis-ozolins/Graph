
package lv.janis.ozolins.edu.graph.impulss.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="restrict-to" type="{}restrict-toType" minOccurs="0"/>
 *         &lt;element name="pre-functions" type="{}pre-functionsType" minOccurs="0"/>
 *         &lt;element name="results" type="{}resultsType"/>
 *         &lt;element name="post-functions" type="{}post-functionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="view" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actionType", propOrder = {
    "restrictTo",
    "preFunctions",
    "results",
    "postFunctions"
})
public class ActionType {

    @XmlElement(name = "restrict-to")
    protected RestrictToType restrictTo;
    @XmlElement(name = "pre-functions")
    protected PreFunctionsType preFunctions;
    @XmlElement(required = true)
    protected ResultsType results;
    @XmlElement(name = "post-functions")
    protected PostFunctionsType postFunctions;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "view")
    protected String view;

    /**
     * Gets the value of the restrictTo property.
     * 
     * @return
     *     possible object is
     *     {@link RestrictToType }
     *     
     */
    public RestrictToType getRestrictTo() {
        return restrictTo;
    }

    /**
     * Sets the value of the restrictTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictToType }
     *     
     */
    public void setRestrictTo(RestrictToType value) {
        this.restrictTo = value;
    }

    /**
     * Gets the value of the preFunctions property.
     * 
     * @return
     *     possible object is
     *     {@link PreFunctionsType }
     *     
     */
    public PreFunctionsType getPreFunctions() {
        return preFunctions;
    }

    /**
     * Sets the value of the preFunctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreFunctionsType }
     *     
     */
    public void setPreFunctions(PreFunctionsType value) {
        this.preFunctions = value;
    }

    /**
     * Gets the value of the results property.
     * 
     * @return
     *     possible object is
     *     {@link ResultsType }
     *     
     */
    public ResultsType getResults() {
        return results;
    }

    /**
     * Sets the value of the results property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultsType }
     *     
     */
    public void setResults(ResultsType value) {
        this.results = value;
    }

    /**
     * Gets the value of the postFunctions property.
     * 
     * @return
     *     possible object is
     *     {@link PostFunctionsType }
     *     
     */
    public PostFunctionsType getPostFunctions() {
        return postFunctions;
    }

    /**
     * Sets the value of the postFunctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostFunctionsType }
     *     
     */
    public void setPostFunctions(PostFunctionsType value) {
        this.postFunctions = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the view property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getView() {
        return view;
    }

    /**
     * Sets the value of the view property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setView(String value) {
        this.view = value;
    }

}
