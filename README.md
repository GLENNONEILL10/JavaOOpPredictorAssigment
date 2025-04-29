# JavaPredictorAssignment

Everything is in the OOPAssigment folder NOT in the PowerIsOutJavaPredictor Folder i couldnt figure out how to remove it

Frequency Table
TimeOfDay	WeatherCondition	PowerGridStatus	BackupGenerator	PowerIsOut_Yes	PowerIsOut_No
Day	        Clear	            Stable	        Available	        5	              8
Day	        Clear	            Stable	        NotAvailable	    7	              5
Day	        Clear	            Unstable	      Available	        5              	7
Day	        Clear	            Unstable	      NotAvailable	    8	              5
Day	        Stormy	          Stable	        Available	        5	              5
Day	        Stormy	          Stable	        NotAvailable	    8	              4
Day	        Stormy	          Unstable	      Available	        5	              8
Day	        Stormy	          Unstable	      NotAvailable	    5              	8
Night      	Clear            	Stable	        Available	        4	              9
Night	      Clear            	Stable        	NotAvailable	    7	              5
Night	      Clear            	Unstable      	Available	        6              	6
Night      	Clear            	Unstable	      NotAvailable	    9	              4  
Night      	Stormy	          Stable	        Available	        7	              6
Night	      Stormy	          Stable	        NotAvailable	    6	              6
Night	      Stormy	          Unstable	      Available	        6	              6
Night      	Stormy	          Unstable	      NotAvailable	    8	              5
![image](https://github.com/user-attachments/assets/2c78e02c-1f56-4c37-adcb-2af87a24638b)


Got the class structure for classes 1-6 from chatgpt 

Class 1 - Control: The class with main method. Initialises Gui class object to run the gui

Class 2 - GUI: This class has 4 labels and 4 drop down menus with two options for the user to select, for example time of day - day/night
 It has a submit button the user clicks on when they have selected the options they want
 And then at the bottom is has a label which tells the user whether the power is on or off based on their selections.
 Added a train data button which trains the data based on level 2 
 Added a add to dataset button based on level 3

Class 3 - dataRow: This class has the attributes based on the data set, ie timeOfDay, weatherCondition etc.
It has the getters and setters and a constructor for each attribute

Class 4 - dataset: This class has an arraylist of dataRow objects.
It has a function that adds to the arraylist and a function which gets the rows from arraylist

Class 5 - Prediction: This class has a constructor which takes dataset object.
It has a function called predict which handles the logic behind determining whether the power is on or off
It takes 4 labels from dataset as parameters. It uses for each loop to get each row and increments totalOn and increments totalOff based on   PowerIsOn and PowerisOff attributes. If totalOn and totalOff = 0 then error is totalOn is greater than totalOff returns power is on and is totalOn is less than totalOff returns power is off
If in the dataset  power is on/off is the same then it chooses either on or off at random

Class 6 - predictionControllers: This class  has a function where the data from dataset is hard coded in and a function called predict which returns the result of the Prediction classes predict function and is used in GUI class .

Class 7 - TrainModel: This class reads in from dataset csv file and creates frequency table using hashmap and gets the result based on if the power is on/yes or    off/no. It then creates a new datarow object and stores the new results


Functionality-

predict function takes in 4 parameters String timeOfDay,String weatherCondition,String powerGridStatus,String backupGenerator that will be used in the gui class. It has for each loop that uses dataRow object to loop through each row in dataset class arraylist. if what the user selects is the same as whats in the dataset then it gets the total number of powerIsOn and powerIsOff. If the totals are equal to 0 then the user gets an erro. if the totalOn is greater than total off returns Power is On, if total off is greater than totalOff returns Power is Off. If the totals are the same then uses random object to get a random number between 0 and 1, if 1 is gotten then power is on if 0 then power is off

addRow function adds dataRow objects to arraylsit

getRow function returns the objects in arraylist

setData function sets dataset object and creates new prediction object with the dataset object as parameter

loadData function is where the hardcoded frequency table is

trainModel function that takes the file path as parameter. It creates file object with the file path parameter and then creates scanner for the file. It loops through the file and skips line that are empty, headers and commas (,). It then creates the key variable for hashmap using the 4 features in dataset.It uses hashmap function getOrDefault to get the keys of hashmap and creates new count array of 2 index for yes and no. if yes then increment index 1 of count and if no then increment index of count . It then puts the keys and yes/no count into the hashmap. It then loops through the hashmap and it adds the elements to the dataRow arraylist

The gui is done in the constructor

If i had more time i would look to try and complete level 4 of this assigment. I just felt that it took so long to figure out how to do each of the first 3 levels and if i had more time i could complete the 4th. I would also try to make the gui look better with more colours and better layout

