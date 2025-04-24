package com.OOPAssigment;

public class Prediction{

    private dataset data;

    public Prediction(dataset dataset){

        this.data = dataset;
    }

    public String predict(String timeOfDay,String weatherCondition,String powerGridStatus,String backupGenerator){

        int totalOn = 0;
        int totalOff = 0;

        for(dataRow row : data.getRows()){

            if (row.getTimeOfDay().equals(timeOfDay) && row.getWeatherCondition().equals(weatherCondition)
                && row.getPowerGridStatus().equals(powerGridStatus) && row.getBackupGenerator().equals(backupGenerator)){

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

        else if (totalOn < totalOff) {

            return "Power Is Off";
            
        }
        else{

            return "0";
        }
    }
    
}