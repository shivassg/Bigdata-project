![Title-image](https://github.com/shivassg/Bigdata-project/blob/master/Images/Title-Image.png)

# Analyzing Uber Movement Dataset
This reposity contains the code for big data project - Analyzing Uber Movement Dataset

## Introduction:
Uber movement data is an anonymized data aggregated from over ten billion trips to help urban planning around the world. This data provided by data can be used to understand the city better and address urban transportation challenges. Uber movement shares details like Travel Times, Vehicle speed, etc., Currently Travel time details for few cities is available to public for free. Vehicle speed dataset is still in beta testing. 

In this project, we are planning to analyze the uber movement dataset to derive some insights from the data which can be used for city planning. The problem statements to be addressed in this project will be explained in the Project Definition section.

The uber movement dataset is provided at https://movement.uber.com/?lang=en-US

![Dataset-Image1](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image1.png)

![Dataset-Image2](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image2.png)

## Problem Definition:
In this project, we are planning to analyze the below problem statements based on the data provided by uber. 

### Problem Statement 1: Find all the routes which has more fluctuations in travel time based on hour of the day?

The data provided by the uber consists of the travel time taken within the cities. It also consists of the hour of the day. From this data, we can find all the routes which has more fluctuations in travel time based on hour of the day. This can help in deciding which routes has worse traffic conditions. This can also help in finding at which hour of the day, the traffic conditions will be worse.

### Problem Statement 2: What is the average Uber travel times by city wise?

In this problem statement, we are going to analyze the average uber travel times by city wise. The data is provided for multiple cities by Uber. We can analyze the average uber travel time in different cities. This can help us in finding which city has worse traffic conditions. 

### Problem Statement 3: Analyze the travel times taken within the city based on weather conditions using weather API

Using openweathermap API we can fetch the weather details for a particular city. We can use this data in addition to uber movement data to analyze the travel times taken within the city based on the weather conditions. This can help us in understanding the traffic patterns for the routes in the city based on the climatic conditions.  

## Data Set:
Downloading Dataset:

The dataset can be downloaded from https://movement.uber.com/?lang=en-US

![Dataset-Image2](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image2.png)

The dataset can be downloaded for multiple cities. Below are the dataset details for some of the cities. The dataset is collected for each quarters of year from 2016 to 2019. This consists of arithmetic mean, geometric mean, and standard deviations for aggregated travel times over the selected quarter of the year.

### Dataset Details:

Los Angeles:
•	Total number of records: 20M
•	Size: 4.85GB
•	Timeline: 2016 - 2019
•	Format: CSV

Boston:
•	Total number of records: 5M
•	Size: 2.15GB
•	Timeline: 2016 - 2019
•	Format: CSV

London:
•	Record: 5M
•	Size: 4.01GB
•	Timeline: 2016 - 2019
•	Format: CSV

Location Details:
•	GeoJson file for each city

Dataset Screenshots:

![Dataset-Image3](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image3.png)



## Group Members:
1. Shiva Shankar Ganesan
2. Nitish Subhash Soman 
