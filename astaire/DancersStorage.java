package astaire;

import java.util.HashMap;

public class DancersStorage {
	private HashMap<String, String[]> dances;
	
	public DancersStorage() {
		dances = new HashMap<String, String[]>();
	}
	
	public void addDance(String Dance) {
		if(dances.containsKey(Dance)){
			System.out.println("This dance already exists.");
		}
		
		dances.put(Dance, null);
	}
	
	public void addDancer(String Dance, String Dancer) {
		String[] d = dances.get(Dance);
		//need to change this so that it will go through and check if the value is null.
		d[0] = Dancer;
		dances.replace(Dance, d);
	}
	
	public String[] getDance(String Dance) {
		return dances.get(Dance);
	}
	

}
