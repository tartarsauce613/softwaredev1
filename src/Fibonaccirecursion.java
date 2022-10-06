
public class Fibonaccirecursion extends Thread{	
	
	public int n = 40;
	
	public void run() {
		long time1 = System.nanoTime();
		int answer = fibonacci(n);
		long time2 = System.nanoTime();
		System.out.println("Recursion Thread found answer " + answer + " in time " + (time2 - time1) + "ms.");
	}
	public static int fibonacci(int n) {
		if (n == 0) {
			n = 0;
			return n;
			
		}
		if (n == 1) {
			n = 1;
			return n;
		}
		else {
			n = fibonacci(n-1) + fibonacci(n-2);
			return n;
		}	
		
	}
	
}




