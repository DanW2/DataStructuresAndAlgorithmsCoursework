package astaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DancersStorage {
	private HashMap<String, String[]> dances;
	private String sortedDances;

	public DancersStorage() {
		dances = new HashMap<String, String[]>();
		sortedDances = "";
	}

	public void addDances(String Dance, String[] dancers) {
		dances.put(Dance, dancers);
	}

	public String[] getDance(String Dance) {
		return dances.get(Dance);
	}

	public void sortDances() {

		// Orders the names of the dances.
		List<String> orderedList = new ArrayList<String>();
		orderedList.addAll(dances.keySet());
		Collections.sort(orderedList);
		

		// Orders all of the dancers first to then be added to the hashmap.
		for (String d : orderedList) {
			ArrayList<String> dancers = new ArrayList<String>();
			for (int i = 0; i < dances.get(d).length; i++) {
				dancers.add(dances.get(d)[i]);
			}
			Collections.sort(dancers);
			System.out.println(dancers.get(0));
			sortedDances += d + ": " + dancers + "\n";
		}

	}

	public String getSortedDances() {
		return sortedDances;
	}

}
