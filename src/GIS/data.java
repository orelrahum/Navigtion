package GIS;

import java.sql.Date;

import Geom.Point3D;

public class data implements Meta_data{
	private String MAC;
	private String SSID;
	private String AuthMode;
	private String FirstSeen;
	private int Channel;
	private int RSSI;
	private int AccuracyMeters;
	private String Type;
	public data(String _MAC,String _SSID,String _AuthMode,String _FirstSeen,String _Channel,String _RSSI,String _AccuracyMeters,String _Type) {
		MAC=_MAC;
		SSID=_SSID;
		AuthMode=_AuthMode;
		FirstSeen=_FirstSeen;
		Channel=Integer.parseInt(_Channel);
		RSSI=Integer.parseInt(_RSSI);
		AccuracyMeters=Integer.parseInt(_AccuracyMeters);
		Type=_Type;
	}
	@Override
	public long getUTC() {
		int year,month,day,hour,min;
		int i=0;
		while(FirstSeen.charAt(i)!=' ')
			i++;
		String date=FirstSeen.substring(0, i);
		String time=FirstSeen.substring(i+1, FirstSeen.length());
		String[] ymd=date.split("/");
		String[] hs=time.split(":");
		year=Integer.parseInt(ymd[0]);
		month=Integer.parseInt(ymd[1]);
		day=Integer.parseInt(ymd[2]);
		hour=Integer.parseInt(hs[0]);
	    min=Integer.parseInt(hs[1]);
	    String total=ymd[0]+ymd[1]+ymd[2]+hs[0]+hs[1];
	    long x=Long.parseLong(total);
		Date utc=new Date(x);
		return utc.getTime();
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
