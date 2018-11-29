package File_format;

import java.io.File;
import java.util.Iterator;
import GIS.layer;
import GIS.CSVReader;
import GIS.GIS_element;
import GIS.Project;
import java.util.ArrayList;

public class multiCSV {
	private static Project pro= new Project();
	private static layer lay=new layer();
	public static ArrayList<String> CSVFiles=new ArrayList<String>(); 

	
	public static ArrayList<String>  CSVrexursia(String directoryPath){
		File[] filesInDirectory = new File(directoryPath).listFiles();
		for(File f : filesInDirectory){
			String filePath = f.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
			if("csv".equals(fileExtenstion)){
				CSVFiles.add(filePath);
				System.out.println("CSV file found -> " + filePath);
				// Call the method checkForCobalt(filePath);
			}
		}    
		return CSVFiles;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> CSV=new ArrayList<String>();
		String directoryPath="";
		CSV=CSVrexursia(directoryPath);
		Iterator<String> CSVF = CSV.iterator();
		while (CSVF.hasNext()) {
			lay=CSVReader.CVSread(CSVF.next());
			pro.add(lay);
		}
		
	}
}
