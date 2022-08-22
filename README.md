# Coding Exercise
## Description
The Coding Exercise keeps track of the transaction record. It generates trainees each month and they get places in different training centres: training hubs, boot camp centres and tech centres. It generates a CSV file containing a forecast about the number of trainees and training centres based on the chosen number of years and category.

## Requirements
- This application works with Java 8 (earlier versions may not work correctly)

## Setup
1. Copy the repository HTML link
2. Git clone the repository to a local directory of your choice
3. Open the application in an IDE of your choice
4. Change the value in config.properties file before running the app
   1. `amountOfYears`: Change the amount of years that the program will simulate, the value must be positive integer
   2. `amountOfTimesToRun`: Change the amount of times the program is run, the value must be positive integer
   3. `choiceOfOutput`: Change the choice of output between month and year, the value must be year or month, the value must be year or month
5. Run the app from your IDE and the result of simulation should be shown based on the value of the config.properties file
6. View the result in the output.csv file
