package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	HashMap<String, WeatherData> weatherData;
	
	    void start() {
	    	frame.setVisible(true);
			frame.setSize(800, 600);
			frame.add(panel);
			panel.add(button1);
			panel.add(button2);
			panel.add(button3);
			button1.setText("City");
			button2.setText("Weather Condition");
			button3.setText("Min & Max Temp");
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
	
			

		

			weatherData = Utilities.getWeatherData();
        
        // All city keys have the first letter capitalized of each word
        String cityName = Utilities.capitalizeWords( "National City" );
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			if (button1 == e.getSource()) {
			  String j  = JOptionPane.showInputDialog(null, "Enter a city in California");
			  JOptionPane.showMessageDialog(null, weatherData.get(j).weatherSummary + " " +weatherData.get(j).temperatureF);
			  
			}

			if(button2 == e.getSource()) {
				String weather = JOptionPane.showInputDialog("Enter a weather condition")
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						;
				for(String jett : weatherData.keySet()) {
					if (weather.equalsIgnoreCase(weatherData.get(jett).weatherSummary)) {
						System.out.println(jett);
					}
				}
				
		}
			if(button3 == e.getSource()) {
			
			}
		}
}
