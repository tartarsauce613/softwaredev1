package prime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Primeserverconnection {
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
				
				String response = Primeserverconnection.primecalculator(num1);
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




	 public static String primecalculator(int num) {
	    String result;
		boolean flag = false;
	    for (int i = 2; i <= num / 2; ++i) {
	      // condition for nonprime number
	      if (num % i == 0) {
	        flag = true;
	        break;
	      }
	    }

	    if (!flag)
	      result = (num + " is a prime number.");
	    else
	      result = (num + " is not a prime number.");
	    return result;
	  }
	}

	



