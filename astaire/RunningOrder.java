/**
 * 
 * 
 */
package astaire;

import java.util.HashMap;

public class RunningOrder {
	private String[] order;
	private HashMap<String, String> dances;
	private int gap;

	public RunningOrder(String f, int gaps) {
		this.gap = gaps;
		InputReader ir = new InputReader(f);
		dances = ir.getPerformance();
		order = new String[dances.keySet().size()];
		
		// Adds the dances to the array from the hashmap.
		int i = 0;
		for (String d : dances.keySet()) {
			order[i] = dances.get(d);
			i++;
		}
		splitGroups();
	}

	public String checkFeasibility() {
		for (int i = 0; i < order.length; i++) {
			String[] currentDance = order[i].split(",");
			for (int j = i + 1; j < i + gap; j++) {
				String comparedDance = order[j];
				for (int x = 0; x < currentDance.length; x++) {
					if (comparedDance.contains(currentDance[x])) {
						/*return "This order cannot be completed as there are dancers "
								+ "that do not have enough time to get ready. Which are "
								+ comparedDance + " in dance " + i + " and " + j;*/
						return "";
					}
				}

			}
		}
		return "This order is feasable.";
	}

	public void splitGroups() {
		InputReader groupReader = new InputReader("assets/danceShowData_danceGroups.csv");
		HashMap<String, String> groups = groupReader.getPerformance();
		
		for (int i = 0; i < order.length; i++) {
			String dancers = order[i];
			for (String g : groups.keySet())
				if (dancers.contains(g)) {
					dancers.replace(g, groups.get(g));
				}
			System.out.println(dancers);
			System.out.println(i);
		}
	}
}
