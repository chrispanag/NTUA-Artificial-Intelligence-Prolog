package arti;

import java.io.*;

public class PrologCreator {
	private PrintWriter writer;
	
	public PrologCreator(String file) {
		try {
			writer = new PrintWriter(file, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writePredicate(Predicate p) {
		writer.println(p.toString());
	}
	
	public void close() {
		writer.close();
	}
}
