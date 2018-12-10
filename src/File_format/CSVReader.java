package File_format;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import GIS.element;
import GIS.layer;

public class CSVReader {
	public static layer CVSread(String csvFile){

		String line = "";
		String cvsSplitBy = ",";
		layer lay=new layer();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{	
			line = br.readLine();
			line = br.readLine();

			while ((line = br.readLine()) != null) 
			{
				String[] AllData = line.split(cvsSplitBy);
				element e=new element(AllData[0],AllData[1],AllData[2],AllData[3],AllData[4],AllData[5]
						,AllData[6],AllData[7],AllData[8],AllData[9], AllData[10]);
				lay.add(e);
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return lay;
	}
}