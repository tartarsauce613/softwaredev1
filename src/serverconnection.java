package cop2805;
import java.net.*;
import java.io.*;
import java.nio.charset.*;

public class serverconnection {

	public static void main(String[] args) {
		ServerSocket server = null;
		boolean shutdown = false;
		
		try {
			server = new ServerSocket(1236);
			System.out.println("Server accepting connections.");
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		while (!shutdown) {
			Socket client = null;
			InputStream input = null;
			OutputStream output = null;
			
			try {
				client = server.accept();
				input = client.getInputStream();
				output = client.getOutputStream();
				
				int n = input.read();
				byte[] data = new byte[n];
				input.read(data);
				
				String clientInput = new String(data, StandardCharsets.UTF_8);
				System.out.println("Client sent: " + clientInput);
				
				int num1 = Integer.parseInt(clientInput);
				int result;
				result = FibonacciDynamic.fibonacci(num1);
				
				String response = Integer.toString(result);
				System.out.println("Returned " + response + " to client");
				output.write(response.length());
				output.write(response.getBytes());
				
			} 
			catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
		

	}

}

class FibonacciDynamic extends Thread {
	public int n = 40;	
	public void run() {
		long time1 = System.currentTimeMillis();
		int answer = fibonacci(n);
		long time2 = System.currentTimeMillis();
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
	
