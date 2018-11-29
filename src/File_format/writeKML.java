package File_format;
import GIS.Project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import GIS.CSVReader;
public class writeKML {
	BufferedWriter writer;
	public writeKML(String output)throws IOException{
		writer = new BufferedWriter(new FileWriter(output));
		
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"blue\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/blue-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");
		while(iter_layer.hasNext()){
			GISLayer layer_temp = (GISLayer)iter_layer.next();
			Iterator<GIS_element> iter_element = layer_temp.iterator();
			while(iter_element.hasNext())
			{
				GISElement elm = (GISElement)iter_element.next();
				writer.write("<Placemark>\n");
				writer.write("<name>"+"<![CDATA["+elm.getMd().getSSID()+"]]>"  +"</name>\n");
				writer.write("<description>"+"<![CDATA[BSSID: <b>"+elm.getMd().getMAC()+"</b><br/>Capabilities: <b>"+elm.getMd().getAuthMode()+"</b><br/>Timestamp: <b>"+elm.getMd().getUTC()+"</b><br/>Channel: <b>"+elm.getMd().getChannel()+"</b><br/>RSSI: <b>"+elm.getMd().getRSSI()+"</b><br/>AltitudeMeters: <b>"+elm.getP().z()+"</b><br/>AccuracyMeters: <b>"+elm.getMd().getAccuracyMeters()+"</b><br/>Type: <b>"+elm.getMd().getType()+"</b><br/>Date: <b>"+elm.getMd().getFirstSeen()+"</b>]]>"+"</description><styleUrl>#blue</styleUrl>\n");
				writer.write("<Point>\n");
				writer.write("<coordinates>"+elm.getP().y()+","+elm.getP().x()+"</coordinates></Point>\n");
				writer.write("</Placemark>\n");

			}
		}
		writer.write("</Folder>\n");
		writer.write("</Document></kml>");
	}
}
