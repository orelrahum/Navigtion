package map;

import java.util.ArrayList;

public class FruitGroup {
	ArrayList<Fruit> Fruits=new ArrayList<Fruit>() ;
	public FruitGroup() {	
	}
	public FruitGroup(Fruit f) {
		Fruits.add(f);
		double id=Fruits.size()-1;
	}

}
