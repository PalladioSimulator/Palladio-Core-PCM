package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author groenda, Michael Kuperberg
 *
 */
public class TimeSeries implements /*Comparable<TimeSeries>, */Serializable  {
	
	/** The logger used by this class. */
	private Logger logger;
	/**
	 * Needed for serialization
	 */
	private static final long serialVersionUID = 1L;

	private String myLabel;
	
	List<TimeSeriesEntity> values;

	/**
	 * TODO myLabel shouldn't be null
	 * @param myLabel
	 */
	public TimeSeries(String myLabel) {
		super();
		this.logger =Logger.getLogger(this.getClass().getName());
		this.values = new ArrayList<TimeSeriesEntity>();
		this.setLabel(myLabel);
	}
	
//	@SuppressWarnings("unused")
//	private TimeSeries(){
//		//empty constructor, to prevent accidental use of the default constructor
//	}

	/**
	 * Plausibility check should be performed by the constructor of 
	 * TimeSeriesEntity
	 * @param x
	 * @param y
	 */
	public void add(double x, double y) {
		values.add(new TimeSeriesEntity(x,y));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		//TODO does sorting play in role in comparison? we assume NO.
		//TODO to be tested
		if(obj instanceof TimeSeries){
			TimeSeries other = (TimeSeries) obj;
			if(this.getValues().size()!=other.getValues().size()){
				return false;
			}else{
				List<TimeSeriesEntity> thisClone = new ArrayList<TimeSeriesEntity>();
				Collections.copy(thisClone, this.getValues());
				List<TimeSeriesEntity> otherClone = new ArrayList<TimeSeriesEntity>();
				Collections.copy(otherClone, other.getValues());
				Collections.sort(thisClone);
				Collections.sort(otherClone);
				for(int i=0; i<thisClone.size(); i++){
					if(thisClone.get(i).equals(otherClone.get(i))){
						//continue
					}else{
						return false;
					}
				}
				return true;
			}
		}else{
			return false;
		}
	}

	public String getLabel() {
		return myLabel;
	}

	public List<TimeSeriesEntity> getValues() {
		return values;
	}

	/**
	 * 
	 * @param newLabel must not be null or empty
	 */
	public void setLabel(String newLabel) {
		if(myLabel==null || myLabel.equals("")){
			logger.error/*throw new RuntimeException*/
			("Label of TimeSeries should not be null or an empty string");
			this.myLabel = "Time Series Generic Label";
		}else{
			this.myLabel = newLabel;
		}
	}
	
	public void setValues(List<TimeSeriesEntity> values) {
		this.values = values;//TODO add checks
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = this.myLabel + "\n";
		if(this.values!=null){
			for (TimeSeriesEntity e : this.values) {
				result += e + "\n";//TODO replace with StringBuffer and append
			}
		}
		return result;
	}
	
//	@Override
//	public int compareTo(TimeSeries o) {
//		//TODO consider myLabel as well?
//		//TODO does sorting play in role in comparison? we assume NO. 
//		return Collections
//		return 0;
//	}
}
