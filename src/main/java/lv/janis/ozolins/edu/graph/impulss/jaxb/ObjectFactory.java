
package lv.janis.ozolins.edu.graph.impulss.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lv.janis.ozolins.edu.graph.impulss.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Workflow_QNAME = new QName("", "workflow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lv.janis.ozolins.edu.graph.impulss.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WorkflowType }
     * 
     */
    public WorkflowType createWorkflowType() {
        return new WorkflowType();
    }

    /**
     * Create an instance of {@link StepType }
     * 
     */
    public StepType createStepType() {
        return new StepType();
    }

    /**
     * Create an instance of {@link ActionsType }
     * 
     */
    public ActionsType createActionsType() {
        return new ActionsType();
    }

    /**
     * Create an instance of {@link ArgType }
     * 
     */
    public ArgType createArgType() {
        return new ArgType();
    }

    /**
     * Create an instance of {@link PreFunctionsType }
     * 
     */
    public PreFunctionsType createPreFunctionsType() {
        return new PreFunctionsType();
    }

    /**
     * Create an instance of {@link ConditionsType }
     * 
     */
    public ConditionsType createConditionsType() {
        return new ConditionsType();
    }

    /**
     * Create an instance of {@link ActionType }
     * 
     */
    public ActionType createActionType() {
        return new ActionType();
    }

    /**
     * Create an instance of {@link RestrictToType }
     * 
     */
    public RestrictToType createRestrictToType() {
        return new RestrictToType();
    }

    /**
     * Create an instance of {@link PostFunctionsType }
     * 
     */
    public PostFunctionsType createPostFunctionsType() {
        return new PostFunctionsType();
    }

    /**
     * Create an instance of {@link StepsType }
     * 
     */
    public StepsType createStepsType() {
        return new StepsType();
    }

    /**
     * Create an instance of {@link UnconditionalResultType }
     * 
     */
    public UnconditionalResultType createUnconditionalResultType() {
        return new UnconditionalResultType();
    }

    /**
     * Create an instance of {@link ResultsType }
     * 
     */
    public ResultsType createResultsType() {
        return new ResultsType();
    }

    /**
     * Create an instance of {@link ConditionType }
     * 
     */
    public ConditionType createConditionType() {
        return new ConditionType();
    }

    /**
     * Create an instance of {@link FunctionType }
     * 
     */
    public FunctionType createFunctionType() {
        return new FunctionType();
    }

    /**
     * Create an instance of {@link InitialActionsType }
     * 
     */
    public InitialActionsType createInitialActionsType() {
        return new InitialActionsType();
    }

    /**
     * Create an instance of {@link TriggerFunctionType }
     * 
     */
    public TriggerFunctionType createTriggerFunctionType() {
        return new TriggerFunctionType();
    }

    /**
     * Create an instance of {@link TriggerFunctionsType }
     * 
     */
    public TriggerFunctionsType createTriggerFunctionsType() {
        return new TriggerFunctionsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "workflow")
    public JAXBElement<WorkflowType> createWorkflow(WorkflowType value) {
        return new JAXBElement<WorkflowType>(_Workflow_QNAME, WorkflowType.class, null, value);
    }

}
