package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	HashMap<Integer, String> map;
	JButton entry;
	JButton search;
	JButton view;
	JButton remove;
	JFrame frame;
	JPanel panel;

	public _02_LogSearch() {
		map = new HashMap<>();

		// Initialize buttons
		entry = new JButton("Add Entry");
		search = new JButton("Search by ID");
		view = new JButton("View List");
		remove = new JButton("Remove Entry");

		// Add action listeners
		entry.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);

		// Setup panel and frame
		panel = new JPanel();
		panel.add(entry);
		panel.add(search);
		panel.add(view);
		panel.add(remove);

		frame = new JFrame("Log Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.add(panel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new _02_LogSearch();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == entry) {
			// Add Entry

			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
			String name = JOptionPane.showInputDialog("Enter a name");
			map.put(id, name);
	
		} else if (e.getSource() == search) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
			String name = map.get(id);
			if (name != null) {
				JOptionPane.showMessageDialog(null, "\nName: " + name);
			} else {
				JOptionPane.showMessageDialog(null, "ID not found");
			}
		}
		else if (e.getSource() == view) {
			 
			
			String message = "";
		        for (Integer id : map.keySet()) {
		            message += "ID: " + id + " Name: " + map.get(id) + "\n";
		        }
		        JOptionPane.showMessageDialog(null, message);
		}
		else if (e.getSource() == remove) {
	            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
	            if (map.remove(id) != null) {
	                JOptionPane.showMessageDialog(null, "Removing entry...");
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "id is not found");
	            }
		}
	}
}
