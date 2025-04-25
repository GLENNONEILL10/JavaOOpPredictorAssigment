package com.OOPAssigment;

public class PredictionControllers {

    private dataset data = new dataset();
    private Prediction predictor;

    public PredictionControllers(){

        loadData();

        predictor = new Prediction(data);
    }

    public void setData(dataset data) {
    	
    	this.data = data;
    	this.predictor = new Prediction(data);
    
    }
    	
    

    public void loadData(){

        data.addRows(new dataRow("Day","Clear","Stable","Available",5,8));
        data.addRows(new dataRow("Day", "Clear", "Stable","Unavailable", 7, 5));
        data.addRows(new dataRow("Day", "Clear", "Unstable","Available", 5, 7));
        data.addRows(new dataRow("Day", "Clear", "Unstable","Unavailable", 8, 5));
        data.addRows(new dataRow("Day", "Stormy", "Stable","Available", 5, 5));
        data.addRows(new dataRow("Day", "Stormy", "Stable","Unavailable", 8, 4));
        data.addRows(new dataRow("Day", "Stormy", "Unstable","Available", 5, 8));
        data.addRows(new dataRow("Day", "Stormy", "Unstable","Unavailable", 5, 8));
        data.addRows(new dataRow("Night", "Clear", "Stable", "Available", 4, 9));
        data.addRows(new dataRow("Night", "Clear", "Stable", "Unavailable", 7, 5));
        data.addRows(new dataRow("Night", "Clear", "Unstable", "Available", 6, 6));
        data.addRows(new dataRow("Night", "Clear", "Unstable", "Unavailable", 9, 4));
        data.addRows(new dataRow("Night", "Stormy", "Stable", "Available", 7, 6));
        data.addRows(new dataRow("Night", "Stormy", "Stable", "Unavailable", 6, 6));
        data.addRows(new dataRow("Night", "Stormy", "Unstable", "Available", 6, 6));
        data.addRows(new dataRow("Night", "Stormy", "Unstable", "Unavailable", 8, 5));


    }

    public String predict(String timeOfDay,String weatherCondition,String powerGridStatus,String backupGenerator){

        return predictor.predict(timeOfDay, weatherCondition, powerGridStatus, backupGenerator);
    }

}
