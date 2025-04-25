package com.OOPAssigment;

import java.io.*;
import java.util.*;

public class TrainModel {
	
	Prediction predict;
	dataset data = new dataset();
	
	public dataset trainModel(String path) throws FileNotFoundException {
		
		Map<String, int[]>frequencyMap = new HashMap<>();
	
		File powerIsOutDataset = new File(path);
		
		Scanner fileScanner = new Scanner(powerIsOutDataset);
		
		int totalNo = 0;
		int totalYes = 0;
		String timeOfDay;
		String weatherCondition;
		String powerGridStatus;
		String backupGenerator;
		String powerIsOut;
		
		while(fileScanner.hasNextLine()){
			
			String line = fileScanner.nextLine().trim();
			
			if(line.isEmpty() || line.startsWith("TimeOfDay") || line.split(",").length < 5)continue;
				
				//split the line by comma and convert to list
				String[] values = line.split(",");
				
				String key = values[0].trim()+","+values[1].trim()+","+ values[2].trim()+","+
							 values[3].trim();
				
				String result = values[4].trim();
				
				int[] counts = frequencyMap.getOrDefault(key, new int[2]);
				
				if(result.equalsIgnoreCase("Yes")){
					
					counts[1]++;
					
				}
				else {
					
					counts[0]++;
				}
				
				frequencyMap.put(key, counts);
					
		}
	
		fileScanner.close();
		
		for(String key: frequencyMap.keySet()){
			
			String[] parts = key.split(",");
			int on = frequencyMap.get(key)[0];
			int off = frequencyMap.get(key)[1];
			data.addRows(new dataRow(parts[0],parts[1],parts[2],parts[3],off,on));
			
			
		}
		
		return data;
	
	}
}

