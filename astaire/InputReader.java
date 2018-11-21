package astaire;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class InputReader {

	public InputReader(String csvFile) {
		BufferedReader br = null;
		String line = "";
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				//using commas as seperators
				String[] dances = line.split("\t");
				String[] dancers = dances[1].split(",");
				map.put(dances[0], dancers);
			}
			for(String k : map.keySet()) {
				String[] s = (map.get(k));
				
				System.out.println("Dance: " + k);
				System.out.println("Dancers:" );
				for(String v : s) {
					System.out.println(v);
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
}