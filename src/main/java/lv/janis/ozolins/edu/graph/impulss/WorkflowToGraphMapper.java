package lv.janis.ozolins.edu.graph.impulss;

import lv.janis.ozolins.edu.graph.Graph;
import lv.janis.ozolins.edu.graph.GraphNode;
import lv.janis.ozolins.edu.graph.impulss.jaxb.StepType;
import lv.janis.ozolins.edu.graph.impulss.jaxb.StepsType;
import lv.janis.ozolins.edu.graph.impulss.jaxb.WorkflowType;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by janis.ozolins on 14.14.10.
 */
public class WorkflowToGraphMapper {
    private WorkflowType workflow;
    private List<StepType> steps;
    private Set<StepType> visitedSteps;
    private Map<Integer, GraphNode> graphNodes;

    public WorkflowToGraphMapper(WorkflowType workflow){
        this.workflow = workflow;

        visitedSteps = new HashSet<>();

        StepsType stepsType = workflow.getSteps();

        for(StepType step : stepsType.getStep()){
            int id = Integer.parseInt(step.getId());
            GraphNode node = new GraphNode(id);
            graphNodes.put(id, node);
        }
    }


    public Graph mapToGraph(){
        StepType initStep = workflow.getSteps().getStep().get(0);

        return null;
    }

    public void processStep(StepType step){

    }
}
