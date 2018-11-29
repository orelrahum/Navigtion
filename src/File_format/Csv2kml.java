package File_format;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import Declaration.Filters;
import Declaration.ourFile;


public class Csv2kml {
	
	public static void main(String[] args) {
		Csv2kml data=new Csv2kml("C:\\Users\\orelr\\Desktop\\New folder\\WigleWifi_20171203085618.csv");
		data.write();
	}
	
	public  void write() {
		ourFile file=this.read();
		PrintWriter Print = null;

		try 
		{
			Print = new PrintWriter(new File(file.getName()));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
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
	
	public ourFile read() {
		String L = "";
		String S = ",";

		try (BufferedReader Buffer = new BufferedReader(new FileReader(_Csv2kml))) {
			ArrayList<Filters> List=new ArrayList<Filters>();
			Buffer.readLine();
			Buffer.readLine();
			while ((L = Buffer.readLine()) != null) {
				String[] Data = L.split(S);
				Filters place=new Filters();
				place.setName(Data[1]);
				place.setDescription(Data[10]);
				place.setPoint(Data[7]+","+Data[6]+","+Data[8]);
				place.setTime(Data[3]);
				List.add(place);
			}
			ourFile file=new ourFile();
			String temp=_Csv2kml.substring(0, _Csv2kml.length()-4);
			file.setName(temp);
			file.setFilters(List);

			return file;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	//**********Private Methods**********//
	private String _Csv2kml;
	
	public Csv2kml(String csv2kml) {
		this._Csv2kml=csv2kml;
	}
	
	public String getCsvFile() {
		return _Csv2kml;
	}
	
	public void setCsvFile(String csv2kml) {
		this._Csv2kml=csv2kml;
	}
	
}
