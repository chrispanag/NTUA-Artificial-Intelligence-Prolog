package arti;

public class Edge {
	public Node to;
	public String road;
	public double length;
	public double maxSpeed;
	
	public Edge(Node to, String road, double length, double maxSpeed2) {
		this.to = to;
		this.road = road;
		this.length = length;
		this.maxSpeed = maxSpeed2;
	}
}
