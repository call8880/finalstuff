package finalstuff;

public class Task {
	
	private String Name;
	private String Description;
	
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Task(String name, String description) {
		super();
		Name = name;
		Description = description;
	}
	@Override
	public String toString() {
		return "Task [Name=" + Name + ", Description=" + Description + "]";
	}
	
	public boolean validate(){
		
		if(Name == null || Description == null || Name.equals("") || Description.equals("")) return false;
		else return true;
	}

}
