package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JButton j = new JButton();
	JButton s = new JButton();

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	ArrayList <String> array = new ArrayList <String>(); 
	
//	public static void main(String[] args) {
//
//	/*
//     * Create a GUI with two buttons. One button reads "Add Name" and the other
//     * button reads "View Names". When the add name button is clicked, display
//     * an input dialog that asks the user to enter a name. Add that name to an
//     * ArrayList. When the "View Names" button is clicked, display a message
//     * dialog that displays all the names added to the list. Format the list as
//     * follows:
//     * Guest #1: Bob Banders
//     * Guest #2: Sandy Summers
//     * Guest #3: Greg Ganders
//     * Guest #4: Donny Doners
//     */
//
//}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == j) {
			String name = JOptionPane.showInputDialog("enter your name");
			array.add(name);
			
			
		}
		if(arg0.getSource() == s) {
			JOptionPane.showMessageDialog(null, array);
		}
		
	}

	public void run() {
		// TODO Auto-generated method stub
		frame.add(panel);
		panel.add(j);
		panel.add(s);
		j.setText("Add Name");
		s.setText("View Names");
		j.addActionListener(this);
		s.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}
}