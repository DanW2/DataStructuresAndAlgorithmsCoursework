package astaire;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class InputReader {
	private String[] dances;
	private String dancers;
	private HashMap <String, String> performance;

	public InputReader(String csvFile) {
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			performance = new HashMap<String, String>();
			while ((line = br.readLine()) != null) {
				// using commas as seperators
				dances = line.split("\t");
				dancers = dances[1];
				performance.put(dances[0], dancers);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public HashMap<String,String> getPerformance() {
		return performance;
	}
	
}