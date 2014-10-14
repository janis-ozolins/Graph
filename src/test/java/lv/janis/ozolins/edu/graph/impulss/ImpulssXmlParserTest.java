package lv.janis.ozolins.edu.graph.impulss;

import lv.janis.ozolins.edu.graph.Graph;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by janis.ozolins on 14.14.10.
 */
public class ImpulssXmlParserTest {
    @Test
    public void testCreateGraph() throws Exception {
        ImpulssXmlParser xmlParser = new ImpulssXmlParser();
        URL xml = ClassLoader.getSystemResource("existing_example.xml");
        Graph graph = xmlParser.createGraph(new File(xml.toURI()));
        System.out.println(graph);
    }
}
