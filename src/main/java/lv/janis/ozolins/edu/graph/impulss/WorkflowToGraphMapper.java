package lv.janis.ozolins.edu.graph.impulss;

import lv.janis.ozolins.edu.graph.Graph;
import lv.janis.ozolins.edu.graph.GraphNode;
import lv.janis.ozolins.edu.graph.impulss.jaxb.ActionType;
import lv.janis.ozolins.edu.graph.impulss.jaxb.ResultsType;
import lv.janis.ozolins.edu.graph.impulss.jaxb.StepType;
import lv.janis.ozolins.edu.graph.impulss.jaxb.WorkflowType;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by janis.ozolins on 14.14.10.
 */
public class WorkflowToGraphMapper {
    private WorkflowType workflow;
    private Map<Integer, GraphNode> graphNodes;
    private Map<Integer, StepType> workflowNodes;

    public WorkflowToGraphMapper(WorkflowType workflow){
        this.workflow = workflow;

        graphNodes = new HashMap<>();
        workflowNodes = new HashMap<>();

        for(StepType step : workflow.getSteps().getStep()){
            String strId = step.getId();
            int id = Integer.parseInt(strId);
            workflowNodes.put(id, step);
        }
    }


    public Graph mapToGraph(){
        StepType initStep = workflow.getSteps().getStep().get(0);
        processStep(initStep);

        Graph graph = new Graph(Collections.EMPTY_LIST);
        for(Integer key : graphNodes.keySet()){
            GraphNode graphNode = graphNodes.get(key);
            graph.addNode(graphNode);
        }

        return graph;
    }

    public GraphNode processStep(StepType step){
        String strId = step.getId();
        int id = Integer.parseInt(strId);
        GraphNode currentNode = new GraphNode(id);
        graphNodes.put(id, currentNode);

        List<ActionType> actions = step.getActions().getAction();

        for(ActionType action : actions){
            ResultsType result = action.getResults();
            String strStepId = result.getUnconditionalResult().getStep();
            Integer stepId = Integer.parseInt(strStepId);
            GraphNode nextGraphNode = graphNodes.get(stepId);
            if(nextGraphNode == null){
                StepType nextStep = workflowNodes.get(stepId);
                if(nextStep == null){
                    nextGraphNode = new GraphNode(stepId); //TODO missing step, what to do?
                } else {
                    nextGraphNode = processStep(nextStep);
                }
            }
            currentNode.addNeighbor(nextGraphNode);
        }
        return currentNode;
    }
}
