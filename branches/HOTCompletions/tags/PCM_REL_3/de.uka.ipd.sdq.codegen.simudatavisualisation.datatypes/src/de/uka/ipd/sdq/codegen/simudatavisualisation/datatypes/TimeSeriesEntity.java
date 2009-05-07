package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

public class TimeSeriesEntity {
	double xValue = 0;
	double yValue = 0;

	public double getXValue() {
		return xValue;
	}
	public void setXValue(double value) {
		xValue = value;
	}
	public double getYValue() {
		return yValue;
	}
	public void setYValue(double value) {
		yValue = value;
	}
	public TimeSeriesEntity(double xValue, double yValue) {
		super();
		this.xValue = xValue;
		this.yValue = yValue;
	}
	
	@Override
	public String toString() {
		return "(" + xValue + ", " + yValue + ")";
	}

}
