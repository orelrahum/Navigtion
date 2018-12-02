package GIS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * 
 *@author orelr
 *@author lital
 */
public class layer implements GIS_layer{
	public layer(){
		
	}
	ArrayList<GIS_element> places=new ArrayList<GIS_element>();
	/**
	 * @return if the add action is success 
	 */
	@Override
	public boolean add(GIS_element e) {
		// TODO Auto-generated method stub
		return places.add(e);
	}
	/**
	 *this function add a arrayList of elements to the correct project
	 *@return if the add action is success 
	 */
	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		// TODO Auto-generated method stub
		return places.addAll(c);
	}
	/**
	 *this function clear all the elements from this layer 
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		places.clear();
	}/**
	 * @return if the layer contains this element
	 */

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return places.contains(o);
	}
	/**
	 * @return if the layer contains all elements 
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return places.containsAll(c);
	}
	/**
	 * @return if the layer is empty 
	 */
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
	/**
	 * @return if the element remove success
	 */
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
	/**
	 * @return if all the elements remove success
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return places.retainAll(c);
	}
	/**
	 * @return the size of this layer (number of elemnts)
	 */
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
