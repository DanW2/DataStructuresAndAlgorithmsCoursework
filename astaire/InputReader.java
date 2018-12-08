package astaire;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class InputReader {
	private DancersStorage ds;

	public InputReader(String csvFile) {
		BufferedReader br = null;
		String line = "";
		ds = new DancersStorage();

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// using commas as seperators
				String[] dances = line.split("\t");
				String[] dancers = dances[1].split(",");
				for(int i = 0; i < dances.length; i++) {
					ds.addDances(dances[i], dancers);
				}
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

	public DancersStorage getDancersStorage() {
		return ds;
	}
}