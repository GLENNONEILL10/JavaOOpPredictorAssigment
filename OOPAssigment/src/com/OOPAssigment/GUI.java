package com.OOPAssigment;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	public GUI(){
		
		JFrame frame = new JFrame("PowerIsOut");

		PredictionControllers controller = new PredictionControllers();
		
	
		frame.setSize(350,250);
		
		frame.setLayout(new GridLayout(6,2,10,10));
		
		String[] timeOfDay= {"Day","Night"};
		String[] weatherCondition = {"Clear","Stormy"};
		String[] powerGridStatus = {"Stable","Unstable"};
		String[] backupGenerator = {"Available","Unavailable"};

		
		//dropdown menus
		JComboBox<String> timeOfDayDropdown = new JComboBox<>(timeOfDay);
		JComboBox<String> weatherConditionDropdown = new JComboBox<>(weatherCondition);
		JComboBox<String> powerGridStatusDropdown = new JComboBox<>(powerGridStatus);
		JComboBox<String> backupGeneratorDropdown = new JComboBox<>(backupGenerator);
		
		JButton submitButton = new JButton("Enter Prediction"); 

		JLabel resultLabel;
		resultLabel = new JLabel("Prediction Will Appear here");
		
		//when button is clicked
		submitButton.addActionListener(e ->{
			
			
			//information is shown to user 
			String info = "Time Of Day:"+timeOfDayDropdown.getSelectedItem() +
					      "\nWeather Condition:"+weatherConditionDropdown.getSelectedItem() +
					      "\nPower Grid Status:"+powerGridStatusDropdown.getSelectedItem() +
					      "\nBackup Generator:"+backupGeneratorDropdown.getSelectedItem();
			
			JOptionPane.showMessageDialog(frame,info);
			
			String time = (String) timeOfDayDropdown.getSelectedItem();
			String weather = (String) weatherConditionDropdown.getSelectedItem();
			String powerGrid = (String) powerGridStatusDropdown.getSelectedItem();
			String generator = (String) backupGeneratorDropdown.getSelectedItem();

			String result = controller.predict(time, weather, powerGrid, generator);

			resultLabel.setText("Prediction:" + result);

			
		});
		
		//adds the labels and dropdown menus
		frame.add(new JLabel("Time Of Day:"));
		frame.add(timeOfDayDropdown);
		
		frame.add(new JLabel("Weather Condition:"));
		frame.add(weatherConditionDropdown);
		
		frame.add(new JLabel("Power Grid Status:"));
		frame.add(powerGridStatusDropdown);
		
		frame.add(new JLabel("Backup Generator:"));
		frame.add(backupGeneratorDropdown);
		
		//adds the button
		frame.add(new JLabel(""));//adds space
		frame.add(submitButton);
		
		frame.add(resultLabel);
		
		//makes window visible
		frame.setVisible(true);
			
	}


}
