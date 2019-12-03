from pyspark.sql.functions import col, avg
from pyspark.sql import SparkSession
from pyspark.sql.functions import lit


spark = SparkSession.builder.appName('AverageTravelTime').getOrCreate()

bostonInputPath = "s3://uberdataset/boston/*.csv"
LondonInputPath = "s3://uberdataset/London/*.csv"
LAInputPath = "s3://uberdataset/LosAngeles/*.csv"

bostondf = spark.read.option("header", "true").csv(bostonInputPath)
londondf = spark.read.option("header", "true").csv(LondonInputPath)
LAdf = spark.read.option("header", "true").csv(LAInputPath)

bostonOutput = bostondf.select(avg(bostondf['mean_travel_time']))
londonOutput = londondf.select(avg(londondf['mean_travel_time']))
laOutput = LAdf.select(avg(LAdf['mean_travel_time']))

bostonOutput1 = bostonOutput.withColumn('City', lit('Boston'))
londonOutput1 = londonOutput.withColumn('City', lit('London'))
laOutput1 = laOutput.withColumn('City', lit('Los Angeles'))


finalOutput = bostonOutput1.union(londonOutput1).union(laOutput1)


finalOutput.write.csv("s3://uberdataset/SparkOutput/output")