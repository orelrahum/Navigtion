package GIS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class layer implements GIS_layer{
	public layer(){
		
	}
	ArrayList<GIS_element> places=new ArrayList<GIS_element>();
	@Override
	public boolean add(GIS_element e) {
		// TODO Auto-generated method stub
		return places.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		// TODO Auto-generated method stub
		return places.addAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		places.clear();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return places.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return places.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return places.isEmpty();
	}

	@Override
	public Iterator<GIS_element> iterator() {
		// TODO Auto-generated method stub
		return places.iterator();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return places.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return places.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return places.retainAll(c);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return places.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return null;
	}

}
