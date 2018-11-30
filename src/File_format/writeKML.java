package File_format;
import GIS.Project;
import GIS.layer;
import GIS.element;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import GIS.CSVReader;
import GIS.GIS_element;
import GIS.GIS_layer;
public class writeKML {
	static BufferedWriter writer;
	public writeKML(Project pro, String output)throws IOException{
		writer = new BufferedWriter(new FileWriter(output));}



	public static void write (Project pro) {

		Iterator<GIS_layer> project = pro.iterator();
		try {
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"blue\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/blue-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		while(project.hasNext()) {
			GIS_layer lay=project.next();
			Iterator<GIS_element> element= lay.iterator();
			while(element.hasNext()){
				GIS_element elme = element.next();
				element elm =(element) elme;
				writer.write("<Placemark>\n");
				writer.write("<name>"+"<![CDATA["+elm.get_SSID()+"]]>"  +"</name>\n");
				writer.write("<description>"+"<![CDATA[BSSID: <b>"+elm.get_MAC()+"</b><br/>Capabilities: <b>"+elm.get_AuthMode()+"</b><br/>Timestamp: <b>"+elm.get_UTC()+"</b><br/>Channel: <b>"+elm.get_Channel()+"</b><br/>RSSI: <b>"+elm.get_RSSI()+"</b><br/>AltitudeMeters: <b>"+elm.getP().z()+"</b><br/>AccuracyMeters: <b>"+elm.get_AccuracyMeters()+"</b><br/>Type: <b>"+elm.get_Type()+"</b><br/>Date: <b>"+elm.get_FirstSeen()+"</b>]]>"+"</description><styleUrl>#blue</styleUrl>\n");
				writer.write("<Point>\n");
				writer.write("<coordinates>"+elm.get_CurrentLatitude+","+elm.x()+"</coordinates></Point>\n");
				writer.write("</Placemark>\n");
			}

			writer.write("</Folder>\n");
			writer.write("</Document></kml>");
		}
	}
}
