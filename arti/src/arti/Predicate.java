package arti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Predicate {
	private String name;
	private ArrayList<String> parameters;
	
	public Predicate(String set_name, String[] params) {
		name = set_name;
		parameters = new ArrayList<String>(Arrays.asList(params));
	}
	
	@Override
	public String toString() {
		Iterator<String> it = parameters.iterator();
		String parametersString = "";
		while (it.hasNext()) {
			parametersString = parametersString + it.next() + ", ";
		}
		parametersString = parametersString.substring(0, parametersString.length() - 2);
		return name + "(" + parametersString + ").";
	}
	
}
