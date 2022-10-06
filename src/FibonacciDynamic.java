
public class FibonacciDynamic extends Thread {
	public int n = 40;	
	public void run() {
		long time1 = System.nanoTime();
		int answer = fibonacci(n);
		long time2 = System.nanoTime();
		System.out.println("Dynamic Thread found answer " + answer + " in time " + (time2 - time1) + "ms.");
	}
	public static int fibonacci(int n) {
		int v1 = 0;
		int v2 = 1;
		int v3 = 0;
		for (int i = 2 ; i <= n ; i++) {
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		}
		return v3;
		}	
	
			
}
	


