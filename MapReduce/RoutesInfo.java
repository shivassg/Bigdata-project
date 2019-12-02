import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class RoutesInfo implements WritableComparable<RoutesInfo> {
	
	private float highestTravelTime;
	private float lowestTravelTime;
	private float meanTravelTime;
	private float standardDeviation;
	
	private String sourceAndDestinationID;

	public String getSourceAndDestinationID() {
		return sourceAndDestinationID;
	}

	public void setSourceAndDestinationID(String sourceAndDestinationID) {
		this.sourceAndDestinationID = sourceAndDestinationID;
	}

	public float getHighestTravelTime() {
		return highestTravelTime;
	}

	public void setHighestTravelTime(float highestTravelTime) {
		this.highestTravelTime = highestTravelTime;
	}

	public float getLowestTravelTime() {
		return lowestTravelTime;
	}

	public void setLowestTravelTime(float lowestTravelTime) {
		this.lowestTravelTime = lowestTravelTime;
	}

	public float getMeanTravelTime() {
		return meanTravelTime;
	}

	public void setMeanTravelTime(float meanTravelTime) {
		this.meanTravelTime = meanTravelTime;
	}

	public float getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(float standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		highestTravelTime = arg0.readFloat();
		lowestTravelTime = arg0.readFloat();
		meanTravelTime = arg0.readFloat();
		standardDeviation = arg0.readFloat();
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
		arg0.writeFloat(highestTravelTime);
		arg0.writeFloat(lowestTravelTime);
		arg0.writeFloat(meanTravelTime);
		arg0.writeFloat(standardDeviation);
		
	}
	
	public String toString(){
		return Float.toString(this.highestTravelTime) + "," + Float.toString(this.lowestTravelTime) + "," + Float.toString(this.meanTravelTime) + "," + Float.toString(this.standardDeviation);
		
	}
	
	@Override
	public int compareTo(RoutesInfo o) {
		// TODO Auto-generated method stub
		
		int cmp = Float.compare(this.standardDeviation, o.standardDeviation);
		return cmp;
	}
	

}
