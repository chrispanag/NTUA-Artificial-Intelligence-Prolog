package arti;

import java.util.*;

public class Main {
	
	static String[] colors = {"501400FF", "50140050", "5014B4FF", "50FF7800", "507800F0", "50780014", "50F0FF14", "500078F0", "500A0A0A", "5014F0FF"};

	public static void main(String[] args) {
		CSVReader csv = new CSVReader("nodes.csv");
		ArrayList<String[]> mapPoints = csv.readCSV();
		
		Graph graph = new Graph(mapPoints);
		
		csv = new CSVReader("client.csv");
		ArrayList<String[]> clientData = csv.readCSV();
		Coordinate client = new Coordinate(clientData.get(0)[0], clientData.get(0)[1]);
		Coordinate start = graph.nearestNode(client);
		
		csv = new CSVReader("taxis.csv");
		ArrayList<String[]> taxisData = csv.readCSV();
		
		ArrayList<Taxi> taxis = new ArrayList<Taxi>();
		
		taxisData.forEach((t) -> {
			taxis.add(new Taxi(new Coordinate(t[0], t[1]), t[2]));
		});
		
		XmlCreator output = new XmlCreator("output.kml");
		
		
		ArrayList<Path> paths = new ArrayList<Path>();
		Iterator<Taxi> it = taxis.iterator();
		double minLength = Double.MAX_VALUE; 
		while (it.hasNext()) {
			Taxi t = it.next();
			t.node = graph.nearestNode(t.position);
			System.out.println(t);
			Astar search = new Astar(start, t.node, 10000, graph);
			Path path = search.start();
			if (path == null) {
				System.out.println("ERROR Path Not found");
			} else {
				if (path.length < minLength)
					minLength = path.length;
				paths.add(path);
			}
		}
		
		Iterator<Path> it1 = paths.iterator();
		int i = 0, j = 0;
		while (it1.hasNext()) {
			Path p = it1.next();
			String color = colors[j];
			if (p.length == minLength) {
				color = "ff009900";
				j--;
			}
			output.addPath(p.path, taxis.get(i).id, color);
			System.out.println(p.length);
			i++;
			j++;
		}
		output.closeFile();
		
		output.close();
	}
}
