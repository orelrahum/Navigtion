package map;

import java.util.ArrayList;

public class packmanGroup {
	ArrayList<packman> packmans=new ArrayList<packman>();
	public packmanGroup() {	
	}
	public packmanGroup(packman p) {
		packmans.add(p);
		double id=packmans.size()-1;
	}
	
}
