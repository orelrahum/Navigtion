package GIS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

//	public static void main(String[] args) 
//	{
//
//		String csvFile = "C:\\Users\\orelr\\Desktop\\New folder\\WigleWifi_20171203085618.csv";
//		String line = "";
//		String cvsSplitBy = ",";
//		layer lay=new layer();
//		ArrayList<String> _MAC=new ArrayList<String>();
//		ArrayList<String> _SSID=new ArrayList<String>();
//		ArrayList<String> _AuthMode=new ArrayList<String>();
//		ArrayList<String> _FirstSeen=new ArrayList<String>();
//		ArrayList<String> _Channel=new ArrayList<String>();
//		ArrayList<String> _RSSI=new ArrayList<String>();
//		ArrayList<String> _CurrentLatitude=new ArrayList<String>();
//		ArrayList<String> _AltitudeMeters=new ArrayList<String>();
//		ArrayList<String> _AccuracyMeters=new ArrayList<String>();
//		ArrayList<String> _Type=new ArrayList<String>();
//
//		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
//		{	
//			line = br.readLine();
//			line = br.readLine();
//
//			while ((line = br.readLine()) != null) 
//			{
//				String[] AllData = line.split(cvsSplitBy);
//				_MAC.add(AllData[0]);
//				_SSID.add(AllData[1]);
//				_AuthMode.add(AllData[2]);
//				_FirstSeen.add(AllData[3]);
//				_Channel.add(AllData[4]);
//				_RSSI.add(AllData[5]);
//				_CurrentLatitude.add(AllData[6]);
//				_AltitudeMeters.add(AllData[7]);
//				_AccuracyMeters.add(AllData[8]);
//				_Type.add(AllData[9]);
//				element e=new element(AllData[0],AllData[1],AllData[2],AllData[3],AllData[4],AllData[5]
//						,AllData[6],AllData[7],AllData[8],AllData[9]);
//				lay.add(e);
//				//             System.out.println("MAC: " + AllData[0] + " , _SSID: " + AllData[1] +
//				//              		" _AuthMode: " + AllData[2] + " _FirstSeen: " + AllData[3] +
//				//              		"_Channel: "+ AllData[4] + "_RSSI: "+ AllData[5]+ "_CurrentLatitude: "+ 
//				//               		AllData[6]+ "_AltitudeMeters: "+ AllData[7] + "_AccuracyMeters: "+ AllData[8]+
//				//               		"_Type: "+ AllData[9]);
//			}
//
//		} catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
//
//	}
//
}