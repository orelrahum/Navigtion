package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * 
 *@author orelr
 *@author lital
 */
public class Project implements GIS_project{
	ArrayList<GIS_layer> Project=new ArrayList<GIS_layer>();
	/**
	 * this function add a layer to the correct project
	 * @return if the add action is success 
	 */
	@Override
	public boolean add(GIS_layer arg0) {
		// TODO Auto-generated method stub
		return Project.add(arg0);
	}
	/**
	 *this function add a arrayList layer to the correct project
	 *@return if the add action is success 
	 */
	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		return Project.addAll(c);
	}
	/**
	 *this function clear all the project
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Project.clear();
	}
/**
 * @return if the project contains this layer
 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return Project.contains(o);
	}
	/**
	 * @return if the project contains all layers 
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return Project.containsAll(c);
	}
	/**
	 * @return if the project is empty 
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Project.isEmpty();
	}
	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return Project.iterator();
	}
	/**
	 * @return if the layer remove success 
	 */
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return Project.remove(o);
	}
	/**
	 * @return if all the layers remove success
	 */
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
	/**
	 * @return the size of the project(number of lyers)
	 */
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
