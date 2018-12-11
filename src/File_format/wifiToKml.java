package File_format;

import java.util.ArrayList;
import java.util.Iterator;

import GIS.Project;
import GIS.layer;

public class wifiToKml {
	private static Project pro= new Project();
	private static layer lay=new layer();
	public static ArrayList<String> CSVFiles=new ArrayList<String>(); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Project pro=new Project();
		String directoryPath="C:\\Users\\orelr\\Desktop\\data";
		CSVFiles=multiCSV.CSVrexursia(directoryPath);
		Iterator<String> CSVFile = CSVFiles.iterator();
		while (CSVFile.hasNext()) {
			lay=CSVReader.CVSread(CSVFile.next());
			pro.add(lay);
		}
		String SaveKMLTo="C:\\Users\\orelr\\Desktop\\data\\daniel1.kml";
		writeKML kml=new writeKML (SaveKMLTo ,pro);	
}
}
