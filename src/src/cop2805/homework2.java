package cop2805;
import java.util.*;

public class homework2 {
	public static void Output(List l) {
		int i;
		for (i = 0; i < l.size(); i++) {
			System.out.printf("%s ", l.get(i));
		}
	}
	public static void main(String[] args) {
		String[] initials = {"M", "P", "R"};
		List<String> list1 = new ArrayList<String>();
		for (String x: initials) {
			list1.add(x);
		}
		System.out.println("Initial List");
		Output(list1); //printing initial list
		System.out.println();
		
		System.out.println("Reversed List"); //reversing and printing list
		Collections.reverse(list1);
		Output(list1);
		System.out.println();
		
		System.out.println("Copied List"); // copy list1 to list2 and print list2
		List<String> list2 = new ArrayList<String>(list1); 
		Output(list2);
		System.out.println();
		
		System.out.println("R List"); // copy Rs to list and print
		Collections.fill(list1, "R");
		Output(list1);
		}
		
		
			
	
}
