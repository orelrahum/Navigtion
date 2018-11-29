package Declaration;

import java.util.Collection;


public class ourFile {
	

//**********Getters**********//

public String getName() {
	return _Name;
}

public Collection<Filters> getFilters() {
	return _Filters;
}

//**********Setters**********//

public void setName(String Name) {
	this._Name = Name;
	this._Name = _Name + ".kml";
}

public void setFilters(Collection<Filters> Filters) {
	this._Filters = Filters;
}

//***********Private Methods**********//

private Collection<Filters> _Filters;
private String _Name;
}
