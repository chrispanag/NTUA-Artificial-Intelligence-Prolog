package arti;

import java.util.*;
import java.io.*;

public class XmlCreator {
	FileWriter fr = null;
	BufferedWriter br = null;
	
	public XmlCreator(String path) {
		File file = new File(path);
		try {
			fr = new FileWriter(file);
			br = new BufferedWriter(fr);
			writeUsingBufferedWriter("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <kml xmlns=\"http://earth.google.com/kml/2.1\"> <Document> <name>TaxiRoutes</name>", 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addStyle(String color, String id) {
		writeUsingBufferedWriter("<Style id=\""+ id +"\"> <LineStyle> <color>"+ color +"</color> <width>4</width> </LineStyle> </Style>", 1);
		 
	}
	 
	public void addPath(ArrayList<Node> p, String taxiName, String color) {
		addStyle(color, taxiName);
		writeUsingBufferedWriter("<Placemark>", 1);
		writeUsingBufferedWriter("<name>"+taxiName+"</name>", 1);
		writeUsingBufferedWriter("<styleUrl>#" + taxiName +"</styleUrl> <LineString> <altitudeMode>absolute</altitudeMode> <coordinates>", 1);
		p.forEach((t) -> {
			writeUsingBufferedWriter(t.coord.lat+","+t.coord.lng+",0", 1);
		});
		writeUsingBufferedWriter("</coordinates> </LineString> </Placemark>", 1);
	}
	
	public void closeFile() {
		writeUsingBufferedWriter("</Document> </kml>", 1);
	}
	
	public void close() {
		try {
			br.flush();
			fr.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeUsingBufferedWriter(String data, int noOfLines) {
	        String dataWithNewLine=data+System.getProperty("line.separator");
	        try {
	            for(int i = noOfLines; i>0; i--){
	                br.write(dataWithNewLine);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
