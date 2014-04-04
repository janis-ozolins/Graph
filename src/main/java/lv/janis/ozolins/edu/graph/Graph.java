package lv.janis.ozolins.edu.graph;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Graph implements Serializable,ComponentListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7169060478719761105L;
	final static double RADIUS = 10.0;
	final static double POPUP_RADIUS = 30.0;
	Set<GraphNode> nodes;
	GraphNode selectedNode;
	boolean addSelected;
	int maxX;
	int maxY;
	
	public Graph(Collection<GraphNode> nodesIn){
		nodes = new HashSet<GraphNode>();
		nodes.addAll(nodesIn);
	}
	
	public void addNode(GraphNode node){
		nodes.add(node);
	}
	
	public void setDimensions(int x, int y){
		maxX = x;
		maxY = y;
	}
	
	public double calculateEnergy(){
		
		GraphNode[] graphicNodes = new GraphNode[nodes.size()]; 
		nodes.toArray(graphicNodes);
		double totalEnergy = 0.0;
		for (int i = 0; i < nodes.size() ; i++){
			GraphNode node = graphicNodes[i];
			Force force = new Force(node,maxX,maxY);
			for (int j = 0; j < graphicNodes.length; j++) {
				if (i != j){
					force.coulombRepulsion(graphicNodes[j]);
					if (node.containsNode(graphicNodes[j])){
					force.hookeAttraction(graphicNodes[j]);
					}
				}
			}
			totalEnergy += force.calcPositionAndVelocity();
		}
		return totalEnergy;
	}
	
	public boolean checkCoord(int x,int y){
		Iterator<GraphNode> iter = nodes.iterator();
		while(iter.hasNext()){
			GraphNode node = iter.next();
			if(node.getX() == x && node.getY() == y){
				return false;
			}
		}
		return true;
	}
	
	private GraphNode getSelectedNode(int x, int y){
		Iterator<GraphNode> iter = nodes.iterator();
		while (iter.hasNext()) {
			GraphNode node = iter.next();
			double nodeX = node.getX();
			double nodeY = node.getY();
			if (nodeX - RADIUS < x && nodeX + RADIUS > x
				&& nodeY - RADIUS < y && nodeY + RADIUS > y) {
				return node;
			}
		}
		return null;
	}
	
	public boolean selectNode(int x, int y){
		/*if (selectedNode != null){
			selectedNode = null;
		}*/
		selectedNode = getSelectedNode(x,y);
		return selectedNode == null ? false : true ;
	}
	
	public void deselectNode(){
		selectedNode = null;
	}
	
	public void moveSelectedNode(int x, int y){
		Random rand = new Random();
		while (!checkCoord(x, y)) {
			x += rand.nextInt(1);
			y += rand.nextInt(1);
		}
		selectedNode.setX(x);
		selectedNode.setY(y);
	}
	
	public void addNodeToSelected(int value){
		GraphNode newNode = new GraphNode(value);
		Random rand = new Random();
		double rad = rand.nextDouble()*Math.PI;
		newNode.setX(selectedNode.getX()+POPUP_RADIUS*Math.cos(rad));
		newNode.setY(selectedNode.getY()+POPUP_RADIUS*Math.sin(rad));
		selectedNode.addNeighbor(newNode);
		addNode(newNode);
	}
	
	public void deleteSelectedNode(){
		selectedNode.removeFromNeighbor();
		nodes.remove(selectedNode);
	}
	
	public List<GraphNode> getNodes(){
		return new ArrayList<GraphNode>(nodes);
	}
	
	public void initGraph(){
		Random rand = new Random();
		Map<Integer, Integer> nodeCoord = new HashMap<Integer, Integer>();
		Iterator<GraphNode> iter = nodes.iterator();
		while(iter.hasNext()) {
			GraphNode node = iter.next();
			boolean found = false;
			while (!found) {
				int x = rand.nextInt(maxX);
				int y = rand.nextInt(maxY);
				if (!(nodeCoord.containsKey(x) && nodeCoord.get(x) == y)){
					node.setX(x);
					node.setY(y);
					nodeCoord.put(x, y);
					found = true;
				}
			}
			node.setVelocityX(0.0);
			node.setVelocityY(0.0);
		}
	}
	
	public boolean isNodeSelected(){
		return selectedNode == null ? false : true ;
	}
	
	public void setAddSelected(boolean value){
		addSelected = value;
	}
	
	public boolean getAddSelected(){
		return addSelected;
	}
	
	public void addThisToSelected(int x,int y){
		GraphNode node = getSelectedNode(x, y);
		if(node != null && selectedNode != null){
			selectedNode.addNeighbor(node);
			selectedNode = null;
		}	
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent ev) {
		Dimension dimension = ev.getComponent().getSize();
		maxX = dimension.width;
		maxY = dimension.height;
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
