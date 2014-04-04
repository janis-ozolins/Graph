import java.util.Random;


public class Force {
	double xVelocity;
	double yVelocity;
	int containerX;
	int containerY;
	GraphNode node;
	Random rand;
	static  double MASS = 1.0;
	static  double COULOMB = 1000;
	static  double HOOKE = 0.001;
	static  double DAMPING = 0.8;
	static  double TIME_STEP = 0.2;
	static  double MIN_FORCE = 0.01;
	static  double REPULSION = 0.1;
	static  int MAX_DISTANCE = 10;
	
	public Force(GraphNode node,int x, int y){
		containerX = x;
		containerY = y;
		this.node = node;
		//repulsionFromSides();
	}
	
	public void coulombRepulsion(GraphNode otherNode){
			double noDirection = 2*MASS*COULOMB/Math.pow(node.distance(otherNode),2);
			double radians = Math.atan2(node.distanceY(otherNode),node.distanceX(otherNode));
			xVelocity += noDirection*Math.cos(radians);
			yVelocity += noDirection*Math.sin(radians);
	}
	
	public void hookeAttraction(GraphNode otherNode){
			double noDirection = HOOKE*Math.pow(node.distance(otherNode),2);
			double radians = Math.atan2(node.distanceY(otherNode),node.distanceX(otherNode));
			xVelocity -= noDirection*Math.cos(radians);
			yVelocity -= noDirection*Math.sin(radians);
	}
	
	public void repulsionFromSides(){
		int nodeX = (int)node.getX();
		int nodeY = (int)node.getY();
		if (nodeX < MAX_DISTANCE){
			xVelocity += REPULSION*nodeX;
		}else if (containerX - nodeX < MAX_DISTANCE){
			xVelocity -= REPULSION*nodeX;
		}
		if (nodeY < MAX_DISTANCE){
			yVelocity += REPULSION*nodeY;
		}else if (containerX - nodeY < MAX_DISTANCE){
			yVelocity -= REPULSION*nodeY;
		}
	}
	
	public double getRandomDouble(){
		if(rand == null){
			rand = new Random();
		}
		return rand.nextDouble();
	}
	
	public double calcPositionAndVelocity(){
		double velocityX = ((node.getVelocityX()+TIME_STEP*xVelocity)*DAMPING);
		double velocityY = (node.getVelocityY()+TIME_STEP*yVelocity)*DAMPING;
		node.setVelocityX(velocityX);
		node.setVelocityY(velocityY);
		double locationX = node.getX() + TIME_STEP*node.getVelocityX();
		double locationY = node.getY() + TIME_STEP*node.getVelocityY();
		if (locationX < 0.0) {
			node.setX(getRandomDouble());
		}else if (locationX > containerX){
			node.setX(containerX - getRandomDouble());
		}else{
			node.setX(locationX);
		}
		if (locationY < 0.0) {
			node.setY(getRandomDouble());
		}else if (locationY > containerY){
			node.setY(containerY - getRandomDouble());
		}else{
			node.setY(locationY);
		}
		return MASS*(Math.pow(node.getVelocityX(), 2)
					+ Math.pow(node.getVelocityY(), 2));
	}
	
	public static void setDamping(double damping){
		DAMPING = damping;
	}
	
	public static void setCoulomb(double coulomb){
		COULOMB = coulomb;
	}
	
	public double getX() {
		return xVelocity;
	}

	public double getY() {
		return yVelocity;
	}
}
