CREATE EXTERNAL TABLE london_data
(source_id INT, dest_id INT, hod INT, mean_travel_time float, standard_deviation)
ROW FORMAT DELIMITED FIELDS TERMINATED BY 
','LOCATION 's3://uberdataset/London/';

