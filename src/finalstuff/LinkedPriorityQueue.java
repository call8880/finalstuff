package finalstuff;


import java.util.*;

public class LinkedPriorityQueue implements PriorityQueue{
	
	private ArrayList list[];
	private int size;
	
	public LinkedPriorityQueue(int s){
		size = s; 
		list = new ArrayList[size];
		for(int x = 0; x < size; x++){
			list[x] = new ArrayList();
		}
	}
	
	public Object dequeue(int i){
		if (hasData() == false){
			throw new IllegalStateException
				("Queue is empty");
		}
		else return list[i].remove(0);
	}
	

	public void enqueue(Object o){
		throw new IllegalStateException("must Give a Priority");
	}
	public void enqueue(Object o, int i){
		list[i].add(o);
	}
	public int size(){
		return list.length;
	}
	public int queueSize(int i){
		return list[i].size();
	}
	public boolean hasData(){
		for(int x = 0; x < size; x++){
			if(list.length > 0){
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
