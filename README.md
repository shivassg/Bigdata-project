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


## Data Set:
Downloading Dataset:

The dataset can be downloaded from https://movement.uber.com/?lang=en-US

![Dataset-Image2](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image2.png)

The dataset can be downloaded for multiple cities. Below are the dataset details for some of the cities. The dataset is collected for each quarters of year from 2016 to 2019. This consists of arithmetic mean, geometric mean, and standard deviations for aggregated travel times over the selected quarter of the year.

### Dataset Details:

Los Angeles:
*	Total number of records: 20M
*	Size: 4.85GB
*	Timeline: 2016 - 2019
*	Format: CSV

Boston:
*	Total number of records: 5M
*	Size: 2.15GB
*	Timeline: 2016 - 2019
*	Format: CSV

London:
*	Record: 5M
*	Size: 4.01GB
*	Timeline: 2016 - 2019
*	Format: CSV

Location Details:
*	GeoJson file for each city

Dataset Screenshots:

![Dataset-Image3](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image3.png)

![Dataset-Image4](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image4.png)

Location Details Data:

![Dataset-Image5](https://github.com/shivassg/Bigdata-project/blob/master/Images/Dataset-Image5.png)

Uploading the data:

*	In this project we will be using Amazon S3 bucket for storing the dataset. 


## Methods:

### System Setup: 

In this project, AWS services will be used for storage and processing the data.  For storage purpose, AWS S3 bucket will be used. 

### Amazon EMR Service: 
In this project, Amazon EMR service is used for the processing the data.

### Storage:
In EMR, the storage layer will access the data from the S3 bucket using the EMRFS. EMRFS is an implementation of the Hadoop files system that are used for reading and writing regular files from Amazon EMR directly to Amazon S3. EMRFS provides the convenience of storing persistent data in Amazon S3 for use with Hadoop while also providing features like Amazon S3 server-side encryption, read-after-write consistency, and list consistency.

The data can be used using the following URI s3://aws-s3-bucket1
 
### Data Processing:

### Hadoop MapReduce: 

In this project, MapReduce component will be implemented in AWS EMR. The code will be written in java using MapReduce libraries. Eclipse IDE will be used for programming. The code will be exported to a jar files after creating a cluster in EMR. This jar file will be imported to the EMR so that the MR jobs can be run. The results of the mapreduce will be stored in the S3 bucket which could be further used for spark implementation. 

key value pair: The data needs to be aggregated depending upon the hour of the day. So key for the MR programming will be hod column. The rest all columns will be the value. The output of the MR program will display the routes which has more fluctuation in travel times. 

The skeleton of the MapReduce programming is as follows:

Mapper class
{
map function ()
{
//Key will be the hour of the day column (hod)
//Value will be the remaining columns
}
}
Reducer class
{
reduce function ()
{

//From the map output, the records will be aggregated/grouped based on the hod which has more fluctuation. 

}
}


## Results and Visualization

* After analyzing the data, Quicksight was used for visualization the output. 
* The Quicksight used the output given by the EMR service. 
* This was helpful in understanding the data better. 

### MapReduce output
All the routes which has more fluctuations in travel time based on hour of the day

![MapReduce-output](https://github.com/shivassg/Bigdata-project/blob/master/Images/MapReduce-output.png)

### MapReduce Visualization

![Map-Reduce-Visualization1](https://github.com/shivassg/Bigdata-project/blob/master/Images/Map-Reduce-Visualization1.jpeg)

![Map-Reduce-Visualization2](https://github.com/shivassg/Bigdata-project/blob/master/Images/Map-Reduce-Visualization2.jpeg)

### Hive Output
All the routes which has more fluctuations in travel time based on hour of the day

![Hive-output](https://github.com/shivassg/Bigdata-project/blob/master/Images/Hive-output.png)

### Hive Visualization

![Hive-Visualization](https://github.com/shivassg/Bigdata-project/blob/master/Images/Hive-Visualization.png)

### Spark Output
The average Uber travel times by city wise

![Spark-output](https://github.com/shivassg/Bigdata-project/blob/master/Images/Spark-Output.png)

### Spark Visualization
Boston City:

![Spark-Visualization-Boston](https://github.com/shivassg/Bigdata-project/blob/master/Images/Spark-Boston-Visualization.png)


Los-Angeles City:

![Spark-Visualization-LA](https://github.com/shivassg/Bigdata-project/blob/master/Images/Spark-Los-Angeles-Visualization.png)


All Cities:

![Spark-Visualization-All-Cities](https://github.com/shivassg/Bigdata-project/blob/master/Images/Spark-All-Cities-Visualization.png)


## Conclusion:
This project will analyze the dataset provided by Uber. The insights from analyzing the huge data will be helpful to understand the city better and address urban transportation challenges. The main task in the project will be handling the huge dataset using big data solutions. 


## Group Members:
1. Shiva Shankar Ganesan
2. Nitish Subhash Soman 
