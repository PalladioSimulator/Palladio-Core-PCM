package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.io.Serializable;

/**
 * @author groenda, Michael Kuperberg
 *
 */
public class TimeSeriesEntity implements Comparable<TimeSeriesEntity>, Serializable{
	/**
	 * Needed for serialization
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * x-axis value
	 */
	double xValue = 0;
	
	/**
	 * y-axis value
	 */
	double yValue = 0;

	/**
	 * TODO specify which value ranges are permitted
	 * @param xValue
	 * @param yValue
	 */
	public TimeSeriesEntity(double xValue, double yValue) {
		super();
		this.xValue = xValue;
		this.yValue = yValue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TimeSeriesEntity other) {
		int xValueCmp = Double.compare(this.getXValue(), other.getXValue());
		if(xValueCmp!=0){
			return xValueCmp;
		}else{
			return Double.compare(this.getYValue(), other.getYValue());
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof TimeSeriesEntity){
			if(this.compareTo((TimeSeriesEntity) arg0)==0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public double getXValue() {
		return xValue;
	}
	
	public double getYValue() {
		return yValue;
	}
	
	public void setXValue(double value) {
		xValue = value;
	}

	public void setYValue(double value) {
		yValue = value;
	}
	
	@Override
	public String toString() {
		return "(" + xValue + ", " + yValue + ")";
	}
}
