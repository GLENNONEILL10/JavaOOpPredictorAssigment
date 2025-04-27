package com.OOPAssigment;

import java.io.*;
import java.util.*;

public class TrainModel {
	
	Prediction predict;
	dataset data = new dataset();
	
	public dataset trainModel(String path) throws FileNotFoundException {
		
		//creates hashmap with key being the 4 features and value int array  
		Map<String, int[]>frequencyMap = new HashMap<>();

		//created file path object
		File powerIsOutDataset = new File(path);
		
		//creates scanner for file
		Scanner fileScanner = new Scanner(powerIsOutDataset);
		
		int totalNo = 0;
		int totalYes = 0;
		String timeOfDay;
		String weatherCondition;
		String powerGridStatus;
		String backupGenerator;
		String powerIsOut;
		
		//while the file has a next line
		while(fileScanner.hasNextLine()){
			
			//stores lines in this variable
			String line = fileScanner.nextLine().trim();
			
			//skips lines that are empty, the headers and commas
			if(line.isEmpty() || line.startsWith("TimeOfDay") || line.split(",").length < 5)continue;
				
				//split the line by comma and convert to list
				String[] values = line.split(",");
				
				//creates key with first 4 columns, the 4 features
				String key = values[0].trim()+","+values[1].trim()+","+ values[2].trim()+","+
							 values[3].trim();
				
				//5th column for yes/no
				String result = values[4].trim();
				
				//gets the count of keys, 4 features then returns current array, if key doesnt exist it creates new array
				int[] counts = frequencyMap.getOrDefault(key, new int[2]);
				
				//if result = yes
				if(result.equalsIgnoreCase("Yes")){
					
					//increment count index 1
					counts[1]++;
					
				}

				//else result = no
				else {
					
					//increment count index 0 
					counts[0]++;
				}
				
				//puts the key and count into frequency map
				frequencyMap.put(key, counts);
					
		}
		
		//closes the file scanner
		fileScanner.close();
		
		//loops through each key in frequency map
		for(String key: frequencyMap.keySet()){
			
			String[] parts = key.split(",");

			//stores the array index 0 which is off
			int off = frequencyMap.get(key)[0];

			//stores the array index 1 which is on
			int on = frequencyMap.get(key)[1];

			//creates new dataRow and adds to dataset
			data.addRows(new dataRow(parts[0],parts[1],parts[2],parts[3],off,on));
			
		}
		
		//return full dataset object
		return data;
	
	}
}

