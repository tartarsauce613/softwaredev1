package prime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Primecalcclient {

	public static void main(String[] args) {
		try {
			myFrame fr = new myFrame();
			Socket connection = new Socket("127.0.0.1", 1236);
			InputStream input = null;
			OutputStream output = null;
			Scanner scnr = new Scanner(System.in);
			System.out.println("Enter potential prime number: ");
			String num1 = scnr.next();
			input = connection.getInputStream();
			output = connection.getOutputStream();
			
			output.write(num1.length());
			output.write(num1.getBytes());
			
			int n = input.read();
			byte[] data = new byte[n];
			input.read(data);
			
			String serverResponse = new String(data, StandardCharsets.UTF_8);
			System.out.println(serverResponse);
			
			
			if (!connection.isClosed()) {
				connection.close();
			}
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
