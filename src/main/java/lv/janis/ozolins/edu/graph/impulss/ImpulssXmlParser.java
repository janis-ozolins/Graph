package lv.janis.ozolins.edu.graph.impulss;

import lv.janis.ozolins.edu.graph.Graph;
import lv.janis.ozolins.edu.graph.impulss.jaxb.WorkflowType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Created by janis.ozolins on 14.14.10.
 */
public class ImpulssXmlParser {
    public Graph createGraph(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(WorkflowType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<WorkflowType> root = jaxbUnmarshaller.unmarshal(new StreamSource(file), WorkflowType.class);

            return workflowToGraph(root.getValue());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Graph workflowToGraph(WorkflowType workflow){
        return new WorkflowToGraphMapper(workflow).mapToGraph();
    }
}
