package com.OOPAssigment;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class GUI extends JFrame{
	
	public GUI() {

        JFrame frame = new JFrame("PowerIsOut");

        // Create the controller and trainer
        PredictionControllers controller = new PredictionControllers();
        TrainModel train = new TrainModel();

        // Set GUI size and layout
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(8, 2, 10, 10));

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
        JButton submitButton = new JButton("Enter Prediction");
        JLabel trainingResult = new JLabel("Training Result");
        JLabel resultLabel = new JLabel("Prediction Will Appear Here");

 
        trainModel.addActionListener(e -> {
            try {
              
                Dataset newData = train.trainModel("src/PowerIsOut_Dataset.csv");
                
                controller.setData(newData);
                trainingResult.setText("Training Complete: " + newData.getRows().size() + " entries learned.");
                
                for (DataRow row : newData.getRows()) {
                    System.out.println("Row: " + row.getTimeOfDay() + "," +
                                       row.getWeatherCondition() + "," +
                                       row.getPowerGridStatus() + "," +
                                       row.getBackupGenerator() +
                                       " | On: " + row.getPowerIsOn() + ", Off: " + row.getPowerIsOff());
                }               
                
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

            String result = controller.predict(time, weather, powerGrid, generator);
            resultLabel.setText("Prediction: " + result);

         
            String info = "Time Of Day: " + time +
                    "\nWeather: " + weather +
                    "\nPower Grid: " + powerGrid +
                    "\nBackup Generator: " + generator;
            JOptionPane.showMessageDialog(frame, info);
        });

        // Add components to GUI
        frame.add(new JLabel("Time Of Day:"));
        frame.add(timeOfDayDropdown);
        frame.add(new JLabel("Weather Condition:"));
        frame.add(weatherConditionDropdown);
        frame.add(new JLabel("Power Grid Status:"));
        frame.add(powerGridStatusDropdown);
        frame.add(new JLabel("Backup Generator:"));
        frame.add(backupGeneratorDropdown);
        frame.add(trainModel);
        frame.add(trainingResult);
        frame.add(submitButton);
        frame.add(resultLabel);
    

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

