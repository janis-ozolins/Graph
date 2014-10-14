
package lv.janis.ozolins.edu.graph.impulss.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workflowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workflowType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trigger-functions" type="{}trigger-functionsType"/>
 *         &lt;element name="initial-actions" type="{}initial-actionsType"/>
 *         &lt;element name="steps" type="{}stepsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflowType", propOrder = {
    "triggerFunctions",
    "initialActions",
    "steps"
})
public class WorkflowType {

    @XmlElement(name = "trigger-functions", required = true)
    protected TriggerFunctionsType triggerFunctions;
    @XmlElement(name = "initial-actions", required = true)
    protected InitialActionsType initialActions;
    @XmlElement(required = true)
    protected StepsType steps;

    /**
     * Gets the value of the triggerFunctions property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerFunctionsType }
     *     
     */
    public TriggerFunctionsType getTriggerFunctions() {
        return triggerFunctions;
    }

    /**
     * Sets the value of the triggerFunctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerFunctionsType }
     *     
     */
    public void setTriggerFunctions(TriggerFunctionsType value) {
        this.triggerFunctions = value;
    }

    /**
     * Gets the value of the initialActions property.
     * 
     * @return
     *     possible object is
     *     {@link InitialActionsType }
     *     
     */
    public InitialActionsType getInitialActions() {
        return initialActions;
    }

    /**
     * Sets the value of the initialActions property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialActionsType }
     *     
     */
    public void setInitialActions(InitialActionsType value) {
        this.initialActions = value;
    }

    /**
     * Gets the value of the steps property.
     * 
     * @return
     *     possible object is
     *     {@link StepsType }
     *     
     */
    public StepsType getSteps() {
        return steps;
    }

    /**
     * Sets the value of the steps property.
     * 
     * @param value
     *     allowed object is
     *     {@link StepsType }
     *     
     */
    public void setSteps(StepsType value) {
        this.steps = value;
    }

}
