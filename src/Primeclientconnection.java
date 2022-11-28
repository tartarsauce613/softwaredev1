package prime;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Primeclientconnection {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		myFrame frame = new myFrame();
		frame.setVisible(true); 
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}

		});
		try {
			myFrame fr = new myFrame();
			Socket connection = new Socket("127.0.0.1", 1236);
			InputStream input = null;
			OutputStream output = null;
			String num1 = "20";
			input = connection.getInputStream();
			output = connection.getOutputStream();
			
			output.write(num1.length());
			output.write(num1.getBytes());
			
			int n = input.read();
			byte[] data = new byte[n];
			input.read(data);
			
			String serverResponse = new String(data, StandardCharsets.UTF_8);
			System.out.println("Prime result: " + serverResponse);
			
			
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

class myFrame extends JFrame {
	public JTextField num1;
	public String operator;
	public String symbol;
	public JLabel someText;
	public myFrame() {
	super();
	init();
	}
	
	private void init() {
		num1 = new JTextField();
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new calculateListener(this));
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setTitle("Prime Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 450;
		int frameHeight = 100;
		this.setSize(frameWidth, frameHeight);
		this.setLayout(new GridLayout(0, 4));
		this.add(new JLabel("Enter Number:"));
		this.add(num1);
		this.add(calculateButton);
		this.add(new JLabel("Answer"));
	
	}
}

class calculateListener implements ActionListener {
	myFrame fr;
	public calculateListener (myFrame frame) {
		fr = frame;
	}
	public void actionPerformed(ActionEvent e) 
	{
		JButton btn = (JButton)e.getSource();
		fr.someText.setText("Result: " + btn.getText());
	

		
	}
}
