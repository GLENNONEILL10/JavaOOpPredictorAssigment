package com.OOPAssigment;

public class dataRow {

    private String timeOfDay;
	private String weatherCondition;
	private String powerGridStatus;
	private String backupGenerator;
	private int powerIsOn;
	private int powerIsOff;


	public dataRow(String timeOfDay, String weatherCondition, String powerGridStatus, String backupGenerator, 
					  int powerIsOff,int powerIsOn){

		setTimeOfDay(timeOfDay);
		setWeatherCondition(weatherCondition);
		setPowerGridStatus(powerGridStatus);
		setBackupGenerator(backupGenerator);
		setPowerIsOn(powerIsOn);
		setPowerIsOff(powerIsOff);

	}

	//getters and setters for attributes

	public String getTimeOfDay(){

		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay){

		this.timeOfDay = timeOfDay;
	}

	public String getWeatherCondition(){

		return weatherCondition;
	}
	
	public void setWeatherCondition(String weatherCondition){

		this.weatherCondition = weatherCondition;
	}

	public String getPowerGridStatus(){

		return powerGridStatus;
	}

	public void setPowerGridStatus(String powerGridStatus){

		this.powerGridStatus = powerGridStatus;
	}

	public String getBackupGenerator(){

		return backupGenerator;
	}

	public void setBackupGenerator(String backupGenerator){

		this.backupGenerator = backupGenerator;
	}

	public int getPowerIsOn(){

		return powerIsOn;
	}

	public void setPowerIsOn(int powerIsOn){

		this.powerIsOn = powerIsOn;
	}
	public int getPowerIsOff(){

		return powerIsOff;
	}
	public void setPowerIsOff(int powerIsOff){

		this.powerIsOff = powerIsOff;
	}
}
