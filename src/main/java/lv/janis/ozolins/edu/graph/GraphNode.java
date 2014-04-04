package lv.janis.ozolins.edu.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;



public class GraphNode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7886041367281757661L;
	HashSet<GraphNode> neighbors;
	Integer value;
	double x;
	double y;
	double velocityX;
	double velocityY;
	
	public GraphNode(int value){
		this.value = value;
		neighbors = new HashSet<GraphNode>();
		
	}
	
	@SafeVarargs
	public GraphNode(int value,GraphNode... neighbors){
		this.value = value;
		
		this.neighbors = new HashSet<GraphNode>();
		for (GraphNode neighbor : neighbors){
			addNeighbor(neighbor);
		};
	}
	
	public void addNeighbor(GraphNode elem){
		if(neighbors.add(elem)){
			elem.addNeighbor(this);
		}
	}
	
	public boolean containsNode(GraphNode graphNode){
		Iterator<GraphNode> iter = neighbors.iterator();
		while(iter.hasNext()){
			if (iter.next()== graphNode){
				return true;
			}
		}
		return false;
	}
	
	public double distance(GraphNode other){
		return Math.sqrt(Math.pow(distanceX(other), 2)+Math.pow(distanceY(other), 2));
	}
	public double distanceX(GraphNode other){
		return x - other.getX();
	}

	public double distanceY(GraphNode other){
		return y - other.getY();
	}

	public List<GraphNode> getNeighbors(){
		return new ArrayList<GraphNode>(neighbors);
	}

	public int getValue() {
		return value;
	}
	
	public double getVelocityX() {
		return velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public synchronized double getX() {
		return x;
	}

	public synchronized double getY() {
		return y;
	}
	
	public void removeNeighbor(GraphNode node){
		Iterator<GraphNode> iter = neighbors.iterator();
		while(iter.hasNext()){
			if (iter.next() == node){
				iter.remove();
			}
		}
	}
	
	public void removeFromNeighbor(){
		Iterator<GraphNode> iter = neighbors.iterator();
		while(iter.hasNext()){
			iter.next().removeNeighbor(this);
		}
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public synchronized void setX(double x) {
		this.x = x;
	}

	public synchronized void setY(double y) {
		this.y = y;
	}
}
