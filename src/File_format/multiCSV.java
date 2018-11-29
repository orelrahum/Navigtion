package File_format;

import java.util.Iterator;

import Declaration.Filters;

public class multiCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder Builder = new StringBuilder();
		Iterator<Filters> it=file.getFilters().iterator();
		Builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		Builder.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		Builder.append("<Document>");
		while(it.hasNext()) {
			Filters Replace=it.next();
			Builder.append("<Placemark>");
			Builder.append("<name>");
			Builder.append(Replace.getName());
			Builder.append("</name>");
			Builder.append("<description>");
			Builder.append(Replace.getDescription());
			Builder.append("</description>");
			Builder.append("<Point>");
			Builder.append("<coordinates>");
			Builder.append(Replace.getPoint());
			Builder.append("</coordinates>");
			Builder.append("</Point>");
			Builder.append("<time>");
			Builder.append(Replace.getTime());
			Builder.append("</time>");
			Builder.append("</Placemark>");
		}
		Builder.append("</Document>");
		Builder.append("</kml>");
		Print.write(Builder.toString());
		Print.close();
		System.out.println("the conversion was sucsess :)");
	}
	}

}
