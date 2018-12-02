package File_format;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import GIS.layer;
import GIS.GIS_element;
import GIS.Project;
import java.util.ArrayList;

public class multiCSV {
	private static Project pro= new Project();
	private static layer lay=new layer();
	public static ArrayList<String> CSVFiles=new ArrayList<String>(); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Project pro=new Project();
		String directoryPath="C:\\Users\\LitalStudy\\Desktop\\Ex2\\data";
		CSVFiles=CSVrexursia(directoryPath);
		Iterator<String> CSVFile = CSVFiles.iterator();
		while (CSVFile.hasNext()) {
			lay=CSVReader.CVSread(CSVFile.next());
			pro.add(lay);
		}
		String SaveKMLTo="C:\\Users\\LitalStudy\\Desktop\\Ex2\\data\\newfile.kml";
		writeKML kml=new writeKML (SaveKMLTo ,pro);	
	}

	public static ArrayList<String>  CSVrexursia(String directoryPath){
		File[] filesInDirectory = new File(directoryPath).listFiles();
		for(File f : filesInDirectory){
			String filePath = f.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
			if("csv".equals(fileExtenstion)){
				CSVFiles.add(filePath);
				// Call the method checkForCobalt(filePath);
			}
		}    
		return CSVFiles;
	}

}
