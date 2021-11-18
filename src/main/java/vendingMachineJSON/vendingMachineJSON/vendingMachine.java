package vendingMachineJSON.vendingMachineJSON;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class vendingMachine extends JFrame{
	JFrame machine = new JFrame(); // initializing GUI objects
	JTextArea displayArea = new JTextArea();
	JPanel itemSelectArea = new JPanel(new GridLayout(4, 8));
	
	public vendingMachine() {// constructor for JFrame object
		machine.setTitle("Eric's Vending Machine");
		machine.setSize(500,600);
		machine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		machine.setLayout(new BorderLayout());
		machine.setVisible(true);
		
		displayArea.setEditable(false);// setting layout for display using borderlayout GUI
		machine.add(displayArea, BorderLayout.NORTH);
		machine.add(itemSelectArea, BorderLayout.CENTER);
	}
	public void selectItems() {// initializing each button for each item in JSON file
		this.itemSelectArea = new JPanel();// there are nine buttons for the nine items
		JButton one = new JButton(readJSONfile.readJSON(0));// reading for each object in items list
		one.addActionListener(new SingleActionListener());
		
		JButton two = new JButton(readJSONfile.readJSON(1));
		two.addActionListener(new SingleActionListener());
		
		JButton three = new JButton(readJSONfile.readJSON(2));
		three.addActionListener(new SingleActionListener());
		
		JButton four = new JButton(readJSONfile.readJSON(3));
		four.addActionListener(new SingleActionListener());
		
		JButton five = new JButton(readJSONfile.readJSON(4));
		five.addActionListener(new SingleActionListener());
		
		JButton six = new JButton(readJSONfile.readJSON(5));
		six.addActionListener(new SingleActionListener());
		
		JButton seven = new JButton(readJSONfile.readJSON(6));
		seven.addActionListener(new SingleActionListener());
		
		JButton eight = new JButton(readJSONfile.readJSON(7));
		eight.addActionListener(new SingleActionListener());
		
		JButton nine = new JButton(readJSONfile.readJSON(8));
		nine.addActionListener(new SingleActionListener());
		
		
		this.itemSelectArea.add(one);// adding each to the button panel
		this.itemSelectArea.add(two);
		this.itemSelectArea.add(three);
		this.itemSelectArea.add(four);
		this.itemSelectArea.add(five);
		this.itemSelectArea.add(six);
		this.itemSelectArea.add(seven);
		this.itemSelectArea.add(eight);
		this.itemSelectArea.add(nine);


		//END OF CREATE BUTTON PANEL
	}
	
	class SingleActionListener implements ActionListener { //Listener for button selected
		public void actionPerformed(ActionEvent ae) {
			JButton button = (JButton)ae.getSource();
			String money = ((JButton) button).get("amount");
			displayArea.append("Total cost is $ " + money);// displaying payment
			
		}

		class TotalListener implements ActionListener { // total for all items selected
			public void actionPerformed(ActionEvent ae) {
				String order = displayArea.getText();
				String[] text = order.split(null);// converting to string array
				float num1 = Float.parseFloat(text[0]);
				float num2 = Float.parseFloat(text[1]);
				float answer = num1 + num2;// calculating payment
					displayArea.append("Final total is  $ " + answer);
				}
				
	
}
		}
	}

