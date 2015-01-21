package finalstuff;


import java.util.*;

public class LinkedPriorityQueue implements PriorityQueue{
	
	//private ArrayList<Integer> thing[];
	ArrayList<Patient> thing[];
	private int size;
	
	public LinkedPriorityQueue(int s){
		System.out.println("size for array" + s);
		size = s; 
	 //thing = new ArrayList<Patient>(4);
		thing = new ArrayList[size];
		for(int x = 0; x < size; x++){
			thing[x] = new ArrayList<Patient>();
		}
	}	
	
	public Object dequeue(){
//		if (hasData() == false){
//			throw new IllegalStateException
//				("Queue is empty");
//		}
		
		if (queueSize(0) > 0){
			return thing[0].remove(0);
		}
		else if (queueSize(1) > 0){
			return thing[1].remove(0);
		}
		else return thing[2].remove(0);
	}
	

	public void enqueue(Object o){
		throw new IllegalStateException("must Give a Priority");
	}
	
	public void enqueue(Patient o, int i){
		thing[i].add(o);
		System.out.println((Patient)thing[i].get(0));
	}
	
	public int size(){
		return thing.length;
	}
	
	public int queueSize(int i){
		return thing[i].size();
	}
	
	public boolean hasData(){
		for(int x = 0; x < size; x++){
			if(queueSize(x) > 0){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
