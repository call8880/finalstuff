package finalstuff;


public class Patient {
	
	static String name, condition, treat;
	static boolean treated;
	
	public Patient(String nm, String cond, boolean t){
		name = nm;
		condition = cond;
		treated = t;
	}
	private String Treated(){
	if (treated == true) treat = " has been treated ";
	else if (treated == false) treat = "waiting....";
	return treat;
	}
	
	public void isTreated(boolean t){
		treated = t;
		Treated();
	}
	public String priority(){
		return condition;
	}
	
	public String toString() {
		String str = name + " ";
		str += condition + " ";
		str += Treated() +  "\n";
		return str;
	}
	

}
