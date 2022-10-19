import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class wordcounterTest {

	@Test
	public void testcounter() throws FileNotFoundException {
		Map<String, Integer> text = new HashMap<String, Integer>();
		assertEquals(0, text.size());
		wordcounter.countwords("testtext.txt", text);
		assertEquals(6, text.size());
		
	}
}
