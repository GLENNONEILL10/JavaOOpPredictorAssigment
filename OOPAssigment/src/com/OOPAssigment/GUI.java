package com.OOPAssigment;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	public GUI() {

        JFrame frame = new JFrame("PowerIsOut");

        // Create the controller and trainer
        PredictorControllers controller = new PredictorControllers();
        TrainModel train = new TrainModel();
        dataset newData = new dataset();
        
        // Set GUI size and layout
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(8,2,20,20));
        

        // Dropdown options
        String[] timeOfDay = {"Day", "Night"};
        String[] weatherCondition = {"Clear", "Stormy"};
        String[] powerGridStatus = {"Stable", "Unstable"};
        String[] backupGenerator = {"Available", "NotAvailable"};

        // Dropdown components
        JComboBox<String> timeOfDayDropdown = new JComboBox<>(timeOfDay);
        JComboBox<String> weatherConditionDropdown = new JComboBox<>(weatherCondition);
        JComboBox<String> powerGridStatusDropdown = new JComboBox<>(powerGridStatus);
        JComboBox<String> backupGeneratorDropdown = new JComboBox<>(backupGenerator);

        // Buttons and labels
        JButton trainModel = new JButton("Train Model");
        JLabel trainingResult = new JLabel("Training Result");
        
        JButton submitButton = new JButton("Enter Prediction");
        JLabel resultLabel = new JLabel("Prediction Will Appear Here");
        
        JButton addData = new JButton("Add More Data");
        JLabel addDataLabel = new JLabel("Add new Row & ReTrain");

 
        trainModel.addActionListener(e -> {
        	
            try {
              
                dataset trainData = train.trainModel("src/PowerIsOut_Dataset.csv");
                
                controller.setData(trainData);
                trainingResult.setText("Training Complete: " + trainData.getRows().size() + " entries learned.");
                              
            }
            catch (FileNotFoundException ex) {
                trainingResult.setText("File not found!");
                ex.printStackTrace();
            } 
            catch (Exception ex) {
                trainingResult.setText("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Prediction Button
        submitButton.addActionListener(e -> {
            String time = (String) timeOfDayDropdown.getSelectedItem();
            String weather = (String) weatherConditionDropdown.getSelectedItem();
            String powerGrid = (String) powerGridStatusDropdown.getSelectedItem();
            String generator = (String) backupGeneratorDropdown.getSelectedItem();

            //stores prediction result
            String result = controller.predict(time, weather, powerGrid, generator);
            resultLabel.setText("Prediction: " + result);

            
            //information that pops up for user when they select the options the want
            String info = "Time Of Day: " + time +
                    "\nWeather: " + weather +
                    "\nPower Grid: " + powerGrid +
                    "\nBackup Generator: " + generator;
            JOptionPane.showMessageDialog(frame, info);
        });
        
        //add more data button
        addData.addActionListener(e ->{
            
            //dropdown options
        	String time = (String) timeOfDayDropdown.getSelectedItem();
            String weather = (String) weatherConditionDropdown.getSelectedItem();
            String powerGrid = (String) powerGridStatusDropdown.getSelectedItem();
            String generator = (String) backupGeneratorDropdown.getSelectedItem();
            
            
            String[] options = {"Power is On","Power is Off"};
            
            //option menu that asks user to select power is on/off pops up when user select the attribute they want
            int labelChoice = JOptionPane.showOptionDialog(frame,
            		
            		"What is the label for this entry","Label Input",
            		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            		null, options, options[0]);
            
            //creates new dataRow object
            dataRow newRow = new dataRow(time,weather,powerGrid,generator, 0, 0);
            
            //places the new data into dataset
            newRow.setTimeOfDay(time);
            newRow.setWeatherCondition(weather);
            newRow.setPowerGridStatus(powerGrid);
            newRow.setBackupGenerator(generator);
            
            //if user selects power is on
            if(labelChoice == JOptionPane.YES_OPTION){
            	
            	newRow.setPowerIsOn(1);
            	newRow.setPowerIsOff(0);
            	
            }
            //if user selects power is off
            else if(labelChoice == JOptionPane.NO_OPTION){
            	
            	newRow.setPowerIsOn(0);
            	newRow.setPowerIsOff(1);
            	
            }
            
            else if (labelChoice == JOptionPane.CLOSED_OPTION){
            	
            		return; 
        		
            }
            //adds the new data to arraylist
            newData.getRows().add(newRow);
            

            //adds new data to data controller
            controller.setData(newData);
            
            //is displayed after user selcts option choice
            JOptionPane.showMessageDialog(frame, "New row added and classifier retrained!");
            trainingResult.setText("Training Updated: " + newData.getRows().size() + " entries now.");
        
        });

        // Add components to GUI
        leftPanel.add(new JLabel("Time Of Day:"));
        leftPanel.add(timeOfDayDropdown);
        leftPanel.add(new JLabel("Weather Condition:"));
        leftPanel.add(weatherConditionDropdown);
        leftPanel.add(new JLabel("Power Grid Status:"));
        leftPanel.add(powerGridStatusDropdown);
        leftPanel.add(new JLabel("Backup Generator:"));
        leftPanel.add(backupGeneratorDropdown);
        
        leftPanel.add(addData);
        leftPanel.add(addDataLabel);
        
        leftPanel.add(trainModel);
        leftPanel.add(trainingResult);
        
        
        leftPanel.add(submitButton);
        leftPanel.add(resultLabel);
        
        frame.add(leftPanel,BorderLayout.CENTER);
         
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}