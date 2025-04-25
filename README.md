# JavaPredictorAssignment

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





Class Structure Gotten From Chatgpt

Class 1 - Control: The class with main method. Initialises Gui class object to run the gui

Class 2 - GUI: This class has 4 labels and 4 drop down menus with two options for the user to select, for example time of day - day/night
               It has a submit button the user clicks on when they have selected the options they want
               And then at the bottom is has a label which tells the user whether the power is on or off based on their selections

Class 3 - dataRow: This class has the attributes based on the data set, ie timeOfDay, weatherCondition etc.
                   It has the getters and setters and a constructor for each attribute

Class 4 - dataset: This class has an arraylist of dataRow objects.
                   It has a function that adds to the arraylist and a function which gets the rows from arraylist

Class 5 - Prediction: This class has a constructor which takes dataset object.
                      It has a function called predict which handles the logic behind determining whether the power is on or off
                      It takes 4 labels from dataset as parameters. It uses for each loop to get each row and increments totalOn and increments totalOff based on PowerIsOn and PowerisOff attributes
                      if totalOn and totalOff = 0 then error is totalOn is greater than totalOff returns power is on and is totalOn is less than totalOff returns power is off

Class 6 - predictionControllers: This class  has a function where the data from dataset is hard coded in and a function called predict which returns the result of the Prediction classes predict function and is                                     used in GUI class .
