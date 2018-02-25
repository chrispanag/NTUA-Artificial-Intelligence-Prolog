package arti;

import java.util.ArrayList;

public class Path {
	public ArrayList<Node> path;
	public double length;
	
	public Path(ArrayList<Node> path, double length) {
		super();
		this.path = path;
		this.length = new Double(length);
	}
}
