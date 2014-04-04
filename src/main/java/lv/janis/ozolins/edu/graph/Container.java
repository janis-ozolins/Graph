package lv.janis.ozolins.edu.graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Container extends JPanel{
	private static final long serialVersionUID = 6893648863319305572L;
	public static final int NODE_SIZE = 10;
	ImageIcon icon;
	Graph graph;
	
	public Container(Graph graph){
		this.graph = graph;
		addComponentListener(graph);
		
		icon = new ImageIcon(getClass().getClassLoader().getResource("ball.png"));
		icon = scaleImageIcon(icon);
	}
	
	private ImageIcon scaleImageIcon(ImageIcon newIcon){
		Image image = newIcon.getImage();
		return new ImageIcon(image.getScaledInstance(NODE_SIZE, NODE_SIZE, Image.SCALE_SMOOTH));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			g.setColor(Color.BLACK);
			List<GraphNode> stackNodes = new ArrayList<GraphNode>(graph.getNodes());
			while (stackNodes.size() != 0) {
				GraphNode curNode = stackNodes.remove(0);
				List<GraphNode> nodeList = curNode.getNeighbors();
				Iterator<GraphNode> iter = nodeList.iterator();
				while (iter.hasNext()) {
					GraphNode node = iter.next();
					if (stackNodes.contains(node)) {
						g.drawLine((int) curNode.getX(),(int)curNode.getY(),
								(int)node.getX(),(int) node.getY());
					}
				}
			}
			
			g.setColor(Color.RED);
			stackNodes = new ArrayList<GraphNode>(graph.getNodes());
			while (stackNodes.size() != 0) {
				GraphNode curNode = stackNodes.remove(0);
				icon.paintIcon(this, g, (int)curNode.getX() - NODE_SIZE/2, (int)curNode.getY()- NODE_SIZE/2);
				g.drawString(String.valueOf(curNode.getValue()), (int)curNode.getX() + 5, (int)curNode.getY());
			}
	}

	public void setIcon(ImageIcon newIcon) {
		icon = scaleImageIcon(newIcon);
	}
	
	public void setGraph(Graph graph){
		this.graph = graph;
		removeComponentListener(this.graph);
		addComponentListener(graph);
	}
}
