import static org.junit.Assert.*;


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class sortByValuetest {
	
	@Test
	public void testsorter() throws FileNotFoundException {
		Map<String, Integer> text = new HashMap<String, Integer>();
		wordcounter.countwords("testtext.txt", text);
		wordcounter.sortByValue(text);
		int output = text.get("dog");
		assertEquals(2, output);
	}

}
