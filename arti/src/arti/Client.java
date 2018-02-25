package arti;

import java.time.*;
import java.util.ArrayList;

public class Client {
	public Coordinate start;
	public Coordinate dest;
	public LocalTime time = null;
	public int persons = 1;
	public int luggage = 0;
	
	public Client (ArrayList<String> clientData) {
		// Start
		if (clientData.get(0).length() > 0 && clientData.get(1).length() > 0) {
			this.start = new Coordinate(clientData.get(0), clientData.get(1));
		}
		
		// End
		if (clientData.get(2).length() > 0 && clientData.get(3).length() > 0) {
			this.dest = new Coordinate(clientData.get(2), clientData.get(3));
		}
		
		// Time
		if (clientData.get(4).length() > 0) {
			this.time = LocalTime.parse(clientData.get(4));
		}
		
		// Persons
		if (clientData.get(5).length() > 0) {
			this.persons = Integer.parseInt(clientData.get(5));
		}
		
		// Luggage
		if (clientData.get(7).length() > 0) {
			this.luggage = Integer.parseInt(clientData.get(7));
		}
		
		// TODO: Implement language
	}
}
