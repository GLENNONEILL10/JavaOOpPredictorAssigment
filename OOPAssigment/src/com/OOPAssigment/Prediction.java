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
        	
        	//if 
            if (row.getTimeOfDay().equalsIgnoreCase(timeOfDay) && row.getWeatherCondition().equalsIgnoreCase(weatherCondition)
                && row.getPowerGridStatus().equalsIgnoreCase(powerGridStatus) 
                && row.getBackupGenerator().equalsIgnoreCase(backupGenerator)){

                    totalOn += row.getPowerIsOn();
                    totalOff += row.getPowerIsOff(); 
                    
                    
            }
        }

        if (totalOn == 0 && totalOff == 0) {

            return "Error";
            
        }
        else if(totalOn > totalOff){

            return "Power Is On";

        }
        
        else if(totalOn < totalOff){
        	
        	return "Power Is Off";
        	
        	
        }
        
        //if total on and off are the same
        else if(totalOn == totalOff){
        	
        	Random rand = new Random();
        	
        	//gets random number between 0 and 1
        	int randomChoice = rand.nextInt(2);
        	
        	if(randomChoice == 0){
        		
        		return "Power Is On";
        		
        	}
        	else {
        		
        		return "Power Is Off";
        	}
        		
        }
		return "0";
       
    }
       
}


