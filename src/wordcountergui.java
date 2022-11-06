import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class wordcountergui { /** creates gui for word counter app */
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

class myFrame extends JFrame { /** creates gui design for word counter app */
	public JTextArea fileName;
	public JTextArea results;
	public String operator;
	public String symbol;
	
	public myFrame() {
	super();
	init();
	}
	
	private void init() {
		fileName = new JTextArea();
		JScrollPane fileScroll = new JScrollPane(fileName); 
		results = new JTextArea();
		JScrollPane resultsScroll = new JScrollPane(results); 
		JButton calculateButton = new JButton("Count");
		calculateButton.addActionListener(new calculateListener(this));
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setTitle("Word Counter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 850;
		int frameHeight = 200;
		this.setSize(frameWidth, frameHeight);
		this.setLayout(new GridLayout(0, 2));
		this.add(new JLabel("Enter File Name:", JLabel.RIGHT
				));
		this.add(fileScroll);
		this.add(calculateButton);
		this.add(resultsScroll);
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
		String fileName = fr.fileName.getText();
		Map<String, Integer> textMap = new HashMap<String, Integer>();
		try {
			wordcounter.countwords(fileName, textMap);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		wordSorter.sortByValue((HashMap<String, Integer>) textMap);
		String text = textMap.toString();
		fr.results.setText(text);
		
	}	
}


