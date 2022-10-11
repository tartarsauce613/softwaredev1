package cop2805;

public class Homework1 {
	public static double computeIncome(double salesAmount) {
		double income = 0;
		if (salesAmount <= 5000.00) { // first compute sales of 5000 or less
			income = 5000.00 + (salesAmount * .08);
		}
		else if (salesAmount <= 10000.00) {  // second compute sales of 10000 or less
			income = 5000.00 + (5000.00 * .08) + ((salesAmount - 5000.00) * .1);
		}
		else {  // lastly compute all sales greater than 10000
			income = 5000.00 + (5000.00 * .08) + (5000.00 * .1) + ((salesAmount - 10000.00) * .12);
		}
		return income;	
	}
	
	public static void main(String[] args) {
		double salesAmount;
		int i;
		System.out.println("Sales Amount		Income");
		for (i = 1; i <= 20; i++) {
			salesAmount = i * 1000.00;
			System.out.printf("$%.2f", salesAmount); // print sales column
			System.out.printf("		$%.2f \n", computeIncome(salesAmount)); // print income column
			}	
	}
}


