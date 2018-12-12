package astaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DancersStorage {
	private HashMap<String, String> dances;
	private String sortedDances;
	private InputReader ir;

	public DancersStorage(String f) {
		ir = new InputReader(f);
		dances = ir.getPerformance();
		sortedDances = "";
	}

	public String getDancers(String Dance) {
		return dances.get(Dance);
	}

	public void sortDances() {

		// Orders the names of the dances.
		List<String> orderedList = new ArrayList<String>();
		orderedList.addAll(dances.keySet());
		Collections.sort(orderedList);
		

		// Orders all of the dancers first to then be added to the hashmap.
		for (String d : orderedList) {
			String[] dancerNames = dances.get(d).split(",");
			ArrayList<String> dancers = new ArrayList<String>();
			for (int i = 0; i < dancerNames.length; i++) {
				dancers.add(dancerNames[i]);
			}
			Collections.sort(dancers);
			sortedDances += d + ":" + dancers + "\n";
		}

	}

	public String getSortedDances() {
		return sortedDances;
	}
	

}
