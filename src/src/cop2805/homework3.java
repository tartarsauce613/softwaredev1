package cop2805;

public class homework3 {
	
	public static <E extends Comparable<E>> E max (E [] list) { // function using compareTo to find max of a list of unknown items
		E m = list[0];
		
		if (list[1].compareTo(m) > 0) {
			m = list[1];
		}
			
		if (list[2].compareTo(m) > 0) {
			m = list[2];
		}
		return m;	
	}

	public static void main(String[] args) {
		String[] colors = {"Red", "Green", "Blue"};
		Integer[] numbers = {1, 2, 3};
		Double[] circleRadius = {3.0, 5.9, 2.9};
		
		System.out.printf("Colors: %s", max(colors));
		System.out.println();
		System.out.printf("Numbers: %s", max(numbers));
		System.out.println();
		System.out.printf("Circle Radius: %s", max(circleRadius));
	}

}
