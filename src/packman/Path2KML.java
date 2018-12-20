package packman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Path2KML {
	public static boolean path2kml(Game g) {
		ArrayList<String> content = new ArrayList<String>();
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n<Document><Style id=\"red\">\r\n" + 
				"<IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle>\r\n" + 
				"</Style><Style id=\"Packman\"><IconStyle><Icon><href>https://png2.kisspng.com/sh/cbe6dbcf1fface5c8a4892f6c04c955c/L0KzQYm3V8MxN5DohJH0aYP2gLBuTf10NaFme592YX6wgLLqTf1idl58hAR1ZD21PcHog71uaZ8ySp99aHWwfrbATfFlfl51edU2bXHxPbL1hL11cJYyf9p4c4TviX7ohQZmdqV6itd8LUXlRbbpWcY1PWdnT9U5Lkm5Q4WBWcE1OWY4Sqs8NEWzQIS8VcIveJ9s/kisspng-ms-pac-man-pac-man-world-2-pac-man-2-the-new-adv-pac-man-and-the-ghostly-adventures-5b5eb96456b7c0.9634891415329345003552.png</href></Icon></IconStyle>\r\n" + 
				"</Style><Style id=\"Fruit\"><IconStyle><Icon><href>http://chittagongit.com//images/cherry-icon/cherry-icon-15.jpg</href></Icon></IconStyle></Style>";
		content.add(kmlstart);

		String kmlend = "\n</Document></kml>";
		try{
			FileWriter fw = new FileWriter("data\\mygamekml.kml");
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<g.Fruits.size();i++) {
				Fruit tmp=g.Fruits.get(i);
				String kmlelement ="<Placemark>\n" +
						"<name>fruit"+tmp.GetID()+"</name>\n" +
						"<description>Type: Fruit\nlat: "+tmp.getLat()+"\nlon :"+tmp.getLon()+"\nAlt: "+tmp.getAlt()+"\nWeight: "+tmp.getWeight()+ "</description>\n" +
						"<styleUrl>"+"Fruit"+"</styleUrl>"+"<Point>\n" +
						"<coordinates>"+tmp.getAlt()+","+tmp.getLon()+","+tmp.getAlt()+"</coordinates>" +
						"</Point>\n";
				content.add(kmlelement);
			}
			for(int i=0;i<g.packmans.size();i++) {
				packman tmp=g.packmans.get(i);
				String kmlelement ="<Placemark>\n" +
						"<name>Packman"+tmp.GetID()+"</name>\n" +
						"<description>Type: Packman\nlat: "+tmp.getLat()+"\nlon :"+tmp.getLon()+"\nAlt: "+tmp.getAlt()+"\nSpeed: "+tmp.getSpeed()+"\nRadius: "+tmp.getRadius()+"\nScore: "+tmp.getWeight()+
						"</description>\n" +
						"<styleUrl>"+"Packman"+
						"</styleUrl>"+"<Point>\n" +
						"<coordinates>"+tmp.getLat()+","+tmp.getLon()+","+tmp.getAlt()+"</coordinates>" +
						"</Point>\n";
				content.add(kmlelement);
			}
			for(int i=0;i<g.packmans.size();i++) {
				packman tmp=g.packmans.get(i);
				for(int j=0;j<g.packmans.get(i).getPath().path.size();j++) {
					String kmlelement ="<Placemark>\n" +
							"<name>Packman"+tmp.GetID()+"</name>\n" +
							"<description>Type: Packman\nlat: "+tmp.getPath().path.get(j).y()+"\nlon :"+tmp.getPath().path.get(j).x()+"\nAlt: "+tmp.getPath().path.get(j).z()+"\nSpeed: "+tmp.getSpeed()+"\nRadius: "+tmp.getRadius()+"\nScore: "+tmp.getWeight()+
							"</description>\n" +
							"<styleUrl>"+"Packman"+"</styleUrl>"+"<Point>\n" +
							"<coordinates>"+tmp.getPath().path.get(j).y()+","+tmp.getPath().path.get(j).x()+","+tmp.getPath().path.get(j).z()+"</coordinates>" +
							"</Point>\n";
					content.add(kmlelement);
				}
			}
			content.add(kmlend);
			String csv = content.toString().replaceAll("</Placemark>, <Placemark>", "</Placemark><Placemark>").replaceAll("</Placemark>, ", "</Placemark>").replaceAll(", <Placemark>", "<Placemark>");
			csv = csv.substring(1, csv.length()-1);
			bw.write(csv);
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}