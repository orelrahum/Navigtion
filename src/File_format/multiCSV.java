package File_format;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import GIS.layer;
import GIS.GIS_element;
import GIS.Project;
import java.util.ArrayList;

public class multiCSV {
	public static ArrayList<String> CSVFiles=new ArrayList<String>(); 
	
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
