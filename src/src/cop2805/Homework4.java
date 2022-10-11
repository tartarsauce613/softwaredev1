package cop2805;
import java.util.*;
import java.io.*;

public class Homework4 {
	
	public static List<Double> ReadFile(String file) {
		List<Double> data = new ArrayList<Double>();
		File f = new File(file);
		try {
			Scanner scnr = new Scanner(f);
			while (scnr.hasNext()) {
				Double number;
				number = Double.parseDouble(scnr.next());
				data.add(number);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		return data;	
	}
	
	public static void WriteFile(List<Double> data, String file) {
		File newfile = new File(file);
		try ( BufferedWriter writer = new BufferedWriter (new FileWriter(file)) ) 
            {           
                for (Double line : data) {
                    writer.write (line + "\n");
                }
			}
		catch (IOException ex) {
			System.out.println("Error");
		}
		
	}

	public static void main(String[] args) {
		List<Double> data = new ArrayList<Double>();
		data = ReadFile("data.txt");
		Collections.sort(data);
		WriteFile(data, "data-sorted.txt");
	}

}
