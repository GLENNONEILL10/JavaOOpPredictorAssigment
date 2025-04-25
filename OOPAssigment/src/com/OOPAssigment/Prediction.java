package com.OOPAssigment;

public class Prediction {
	
	private dataset data;
	
	TrainModel train;

    public Prediction(dataset dataset){

        this.data = dataset;
    }

    public String predict(String timeOfDay,String weatherCondition,String powerGridStatus,String backupGenerator){
    	
 
        int totalOn = 0;
        int totalOff = 0;

        for(dataRow row : data.getRows()){

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
		return "0";
       
    }
       
}


