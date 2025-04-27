package com.OOPAssigment;

import java.util.*;

public class Prediction {
	
	//datset object
	private dataset data;
	
	//trainModel object
	TrainModel train;

    public Prediction(dataset dataset){

        this.data = dataset;
    }

    //function that predicts whether the power is on or off
    public String predict(String timeOfDay,String weatherCondition,String powerGridStatus,String backupGenerator){
    	
 
        int totalOn = 0;
        int totalOff = 0;
        
        //for each row object get the rows from the dataset
        for(dataRow row : data.getRows()){
        	
        	//if whats in row is equal to what the user selects in gui
            if (row.getTimeOfDay().equalsIgnoreCase(timeOfDay) && row.getWeatherCondition().equalsIgnoreCase(weatherCondition)
                && row.getPowerGridStatus().equalsIgnoreCase(powerGridStatus) 
                && row.getBackupGenerator().equalsIgnoreCase(backupGenerator)){

                    //gets total number of powersIsOn
                    totalOn += row.getPowerIsOn();

                    //gets total number of powerIsOff
                    totalOff += row.getPowerIsOff(); 
                
            }
        }

        //if totalOn and totalOff = 0
        if (totalOn == 0 && totalOff == 0) {

            return "Error";
            
        }
        //or if totalOn is greater than totalOff
        else if(totalOn > totalOff){

            return "Power Is On";

        }
        
        //or else totalOn is less than totalOff
        else if(totalOn < totalOff){
        	
        	return "Power Is Off";
        	
        }
        
        //if total on and off are the same
        else if(totalOn == totalOff){
        	
        	Random rand = new Random();
        	
        	//gets random number between 0 and 1
        	int randomChoice = rand.nextInt(2);
        	
            //if random number is 1
        	if(randomChoice == 1){
        		
        		return "Power Is On";
        		
        	}
            //or else random number = 0
        	else {
        		
        		return "Power Is Off";
        	}
        		
        }
		return "0";
       
    }
       
}


