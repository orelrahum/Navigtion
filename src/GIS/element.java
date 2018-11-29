package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class element implements GIS_element{
	private String _MAC , _SSID , _AuthMode , _FirstSeen , _Channel , _RSSI ,_CurrentLatitude,_AltitudeMeters, _AccuracyMeters , _Type;
	private data _info;
	private Point3D _Geom;
	
	public element() {
		this._Geom=null;
		this._info=null;
		this._MAC=null;
		this._SSID=null;
		this._AuthMode=null;
		this._FirstSeen=null;
		this._Channel=null;
		this._RSSI=null;
		this._CurrentLatitude=null;
		this._AltitudeMeters=null;
		this._AccuracyMeters=null;
		this._Type=null;	
	}
	public element(String mac,String ssid, String authmode,String firstseen,String channel,String rssi,String currentlatitude, String altitudemeters,String accuracymeters,String type ) {
//		this._Geom=geom;
//		this._info=info;
		this._MAC=mac;
		this._SSID=ssid;
		this._AuthMode=authmode;
		this._FirstSeen=firstseen;
		this._Channel=channel;
		this._RSSI=rssi;
		this._CurrentLatitude=currentlatitude;
		this._AltitudeMeters=altitudemeters;
		this._AccuracyMeters=accuracymeters;
		this._Type=type;
	}
	
	// ALL getters and setters 
	public String get_MAC() {
		return _MAC;
	}
	private void set_MAC(String _MAC) {
		this._MAC =_MAC;
	}
	
	
	public String get_SSID() {
		return _SSID;
	}
	private void set_SSID(String _SSID) {
		this._SSID =_SSID;
	}
	
	
	public String get_FirstSeen() {
		return _FirstSeen;
	}
	private void set_FirstSeen(String _FirstSeen) {
		this._FirstSeen =_FirstSeen;
	}
	
	
	public String get_AuthMode() {
		return _AuthMode;
	}
	private void set_AuthMode(String _AuthMode) {
		this._AuthMode =_AuthMode;
	}
	
	
	public String get_Channel() {
		return _Channel;
	}
	private void set_Channel(String _Channel) {
		this._Channel =_Channel;
	}
	
	
	public String get_CurrentLatitude() {
		return _CurrentLatitude;
	}
	private void set_CurrentLatitude(String _CurrentLatitude) {
		this._CurrentLatitude=_CurrentLatitude;
	}
	
	public String get_RSSI() {
		return _RSSI;
	}
	private void set_RSSI(String _RSSI) {
		this._RSSI =_RSSI;
	}
	
	
	
	public String get_AccuracyMeters() {
		return _AccuracyMeters;
	}
	private void set_AccuracyMeters(String _AccuracyMeters) {
		this._AccuracyMeters =_AccuracyMeters;
	}
	
	public String get__Type() {
		return _Type;
	}
	private void set_Type(String _Type) {
		this._Type=_Type;
	}
	
	
	public String get_AltitudeMeters() {
		return _AccuracyMeters;
	}
	private void set__AccuracyMeters(String _AccuracyMeters) {
		this._AccuracyMeters=_AccuracyMeters;
	}
	


	@Override
	public Geom_element getGeom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meta_data getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub

	}

}
