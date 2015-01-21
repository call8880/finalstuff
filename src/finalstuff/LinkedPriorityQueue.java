package finalstuff;


import java.util.*;

public class LinkedPriorityQueue{
	
	//private ArrayList<Integer> thing[];
	ArrayList<Patient> thing[];
	private int size;
	
	public LinkedPriorityQueue(int s){
		
		size = s; 
	 //thing = new ArrayList<Patient>(4);
		thing = new ArrayList[size];
		for(int x = 0; x < size; x++){
			thing[x] = new ArrayList<Patient>();
		}
	}	
	
	public Object dequeue(){
		if (hasData() == false){
			throw new IllegalStateException
				("Queue is empty");
		}

		Object o;
		System.out.println(queueSize(0) + " " + queueSize(1) + " " + queueSize(2) + " ");
		int q;
		if (queueSize(0) > 0){
			return thing[0].remove(0);
		}
		else if (queueSize(1) > 0){
			return thing[1].remove(0);
		}
		else{
			return thing[2].remove(0);
		}
		
	}
	

	public void enqueue(Object o){
		throw new IllegalStateException("must Give a Priority");
	}
	
	public void enqueue(Patient o, int i){
		thing[i].add(o);
		System.out.println((Patient)thing[i].get(0) + " " + i);
		
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

	
}
