import java.util.Random;

public class arraysum extends Thread {
	
	private int[] arr;
	private int high;
	private int low;
	private int partial;
	
	public arraysum(int[] array, int low, int high) { // arraysum constructor
		this.arr = array;
		this.low = low;
		this.high = Math.min(high, array.length);		
	}
	
	public static int concurrentSum(int[] array) { // run 4 concurrent threads to split array and calculator partial sums, then recombine
		int total = 0;
		int arrSize = (int) Math.ceil(array.length / 4);
		arraysum[] sums = new arraysum[4];
		for (int i = 0; i < 4; i++) {
			sums[i] = new arraysum(array, i * arrSize, (i + 1) * arrSize);
			sums[i].start();
		}
		for (arraysum sum : sums) {
			try {
				sum.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (arraysum sum: sums) {
			total = total + sum.getPartialSum();
		}
		return total;
	}
	
	public int getPartialSum() {
		return partial;
	}
	
	public void run() {
		partial = partialSum(arr, high, low);
	}
	
	public static int partialSum(int[] array, int high, int low) {
		int total = 0;
		for (int i = low; i < high; i++) {
			total = total + array[i];
		}
		return total;
	}
	
	public static int normalSum(int[] array) { // single thread summing method
		int sum = 0;
		for (int i : array) {
			sum = sum + i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[200000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10) + 1;
		}
		long start = System.currentTimeMillis();
		System.out.println("Single thread solution of " + arraysum.normalSum(array) + ", in " + (System.currentTimeMillis()
- start) + "ms.");
		start = System.currentTimeMillis();
		System.out.println("Multi-threaded solution of " + arraysum.concurrentSum(array) + ", in " + (System.currentTimeMillis() - start) + "ms.");
	}

}
