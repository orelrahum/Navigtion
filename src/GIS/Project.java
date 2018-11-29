package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Project implements GIS_project{
	ArrayList<GIS_layer> Project=new ArrayList<GIS_layer>();
	@Override
	public boolean add(GIS_layer arg0) {
		// TODO Auto-generated method stub
		return Project.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		return Project.addAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Project.clear();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return Project.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return Project.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Project.isEmpty();
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return Project.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return Project.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return Project.retainAll(c);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Project.size();
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
