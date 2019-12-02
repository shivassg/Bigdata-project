INSERT OVERWRITE DIRECTORY 's3://uberdataset/hiveoutput/Q2' 
SELECT source_id as SourceId, dest_id as DestinationId, mean_travel_time MeanTravelTime, standard_deviation StandardDeviation
FROM london_data
ORDER BY MeanTravelTime ASC LIMIT 10;