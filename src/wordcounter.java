import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class wordcounter {
	
	public static void countwords (String file, Map<String, Integer> words) throws FileNotFoundException {
		Scanner scnr = new Scanner (new File(file));
		while (scnr.hasNext()) {
			String word = scnr.next();
			Integer count = words.get(word);
			if (count != null) {
				count++;
			}
			else {
				count = 1;
				words.put(word,count);
				}
			}
			
		}
		public static HashMap<String, Integer>
	    sortByValue(Map<String, Integer> poem)
	    {
	        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(
	                poem.entrySet());
	        Collections.sort(
	            list,
	            new Comparator<Map.Entry<String, Integer> >() {
	                public int compare(
	                    Map.Entry<String, Integer> object1,
	                    Map.Entry<String, Integer> object2)
	                {
	                    return (object1.getValue())
	                        .compareTo(object2.getValue());
	                }
	            });
	        HashMap<String, Integer> result
	            = new LinkedHashMap<String, Integer>();
	        for (Map.Entry<String, Integer> me : list) {
	            result.put(me.getKey(), me.getValue());
	        }
	        return result;
	    }
		public static void main(String[] args) {
			Map<String, Integer> poem = new HashMap<String, Integer>();
			try {
				countwords("testtext.txt", poem);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(sortByValue(poem));
	}
}
