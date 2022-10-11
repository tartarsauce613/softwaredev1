package cop2805;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class homework5 {
	
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

	}
}

class myFrame extends JFrame {
	public JTextField num1;
	public JTextField num2;
	public String operator;
	public String symbol;
	
	public myFrame() {
	super();
	init();
	}
	
	private void init() {
		num1 = new JTextField();
		num2 = new JTextField();
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new calculateListener(this));
		String operators[] = {"+" , "-", "*", "/"};
		JComboBox operator = new JComboBox (operators);
		String symbol =(String) operator.getSelectedItem();
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setTitle("Simple Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 450;
		int frameHeight = 100;
		this.setSize(frameWidth, frameHeight);
		this.setLayout(new GridLayout(0, 4));
		this.add(new JLabel("First Number:"));
		this.add(num1);
		this.add(new JLabel("Second Number:"));
		this.add(num2);
		this.add(new JLabel());
		this.add(operator);
		this.add(calculateButton);
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
		String num1 = fr.num1.getText();
		String num2 = fr.num2.getText();
		Double.parseDouble(num1);
		Double.parseDouble(num2);
		System.out.println(fr.symbol);
		
	}
	
}

	

