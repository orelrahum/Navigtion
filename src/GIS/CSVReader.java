package GIS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVReader {
	private String _MAC , _SSID , _AuthMode , _FirstSeen , _Channel , _RSSI ,_CurrentLatitude,_AltitudeMeters, _AccuracyMeters , _Type;
    public static void main(String[] args) 
    {
        String csvFile = "C:\\Users\\orelr\\Desktop\\New folder\\WigleWifi_20171203085618.csv";
        String line = "";
        String cvsSplitBy = ",";
        layer lay=new layer();
        ArrayList<String> _MAC=new ArrayList<String>();
        ArrayList<String> _SSID=new ArrayList<String>();
        ArrayList<String> _AuthMode=new ArrayList<String>();
        ArrayList<String> _FirstSeen=new ArrayList<String>();
        ArrayList<String> _Channel=new ArrayList<String>();
        ArrayList<String> _RSSI=new ArrayList<String>();
        ArrayList<String> _CurrentLatitude=new ArrayList<String>();
        ArrayList<String> _AltitudeMeters=new ArrayList<String>();
        ArrayList<String> _AccuracyMeters=new ArrayList<String>();
        ArrayList<String> _Type=new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {	
        	line = br.readLine();
        	line = br.readLine();
        	
            while ((line = br.readLine()) != null) 
            {
                String[] userInfo = line.split(cvsSplitBy);
                _MAC.add(userInfo[0]);
                _SSID.add(userInfo[1]);
                _AuthMode.add(userInfo[2]);
                _FirstSeen.add(userInfo[3]);
                _Channel.add(userInfo[4]);
                _RSSI.add(userInfo[5]);
                _CurrentLatitude.add(userInfo[6]);
                _AltitudeMeters.add(userInfo[7]);
                _AccuracyMeters.add(userInfo[8]);
                _Type.add(userInfo[9]);
                element e=new element(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4],userInfo[5]
                		,userInfo[6],userInfo[7],userInfo[8],userInfo[9]);
                lay.add(e);
//             System.out.println("MAC: " + userInfo[0] + " , _SSID: " + userInfo[1] +
//              		" _AuthMode: " + userInfo[2] + " _FirstSeen: " + userInfo[3] +
//              		"_Channel: "+ userInfo[4] + "_RSSI: "+ userInfo[5]+ "_CurrentLatitude: "+ 
//               		userInfo[6]+ "_AltitudeMeters: "+ userInfo[7] + "_AccuracyMeters: "+ userInfo[8]+
//               		"_Type: "+ userInfo[9]);
           }

        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

}