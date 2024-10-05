package _09_World_Clocks;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	ClockUtilities clockUtil;
	Timer timer;
	TimeZone timeZone;

	JFrame frame;
	JPanel panel;
	JTextArea textArea;
	JButton addButton;
	JTextArea timeText;

	String city;
	String dateStr;
	String timeStr;

	HashMap<TimeZone, JTextArea> times = new HashMap<TimeZone, JTextArea>();
	HashMap<String, TimeZone> times2 = new HashMap<>();

	public WorldClocks() {
		clockUtil = new ClockUtilities();

		frame = new JFrame("World Clock");
		panel = new JPanel();
		textArea = new JTextArea();
		
		
		frame.add(panel);

		panel.add(textArea);
		addButton = new JButton("Add Time");

		addButton.addActionListener(this);
		frame.setVisible(true);
		panel.add(addButton);
		frame.pack();
		timer = new Timer(1000, this);
		timer.start();


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == addButton) {
			String city2 = JOptionPane.showInputDialog("What city do you want to display?");
			TimeZone timeZone = clockUtil.getTimeZoneFromCityName(city2);

			times2.put(city2, timeZone);


		}
			
			String entries ="";
			

			for (Entry<String, TimeZone> e : times2.entrySet()) {

				Calendar c = Calendar.getInstance(e.getValue());
				String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
						+ c.get(Calendar.SECOND);
				String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
						+ c.get(Calendar.SECOND) + "]";
				String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
				String dayOfWeek = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
				dateStr = dayOfWeek + " " + month + " " + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR);
				timeStr = militaryTime + twelveHourTime;
				
				entries += e.getKey() + "\n" + dateStr + "\n" + timeStr + "\n\n";

			}
			textArea.setText(entries);
			frame.pack();

		}

	}
