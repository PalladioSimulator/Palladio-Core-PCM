package de.uka.ipd.sdq.TimerMeter.utils;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MeasurementResults implements Serializable{
	
	private static final int DOUBLE_MEASUREMENTS = 0;

	private static final PrintStream e = System.err;
	
	private static final int LONG_MEASUREMENTS = 1;
	
	private static final PrintStream o = System.out; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private static final int UNDEFINED = -1;
	
	public static void main(String args[]){
		MeasurementResults mr = new  MeasurementResults();
		mr.addMeasurement(10);
		mr.addMeasurement(5);
		mr.addMeasurement(15);
		System.out.println("Mean:"+mr.computeMeasurementMeanExpensively_Long()+
				", median: "+mr.getMeasurementMedian_Long());
		mr.addMeasurement(20);
		System.out.println("After adding 20: mean:"+mr.computeMeasurementMeanExpensively_Long()+
				", median: "+mr.getMeasurementMedian_Long());
	}

	protected String desc;
	
	protected List<Double> simpleMeasuredResultsDouble;

	/**
	 * There is no SortedList type in Java, so this is a conventional <code>List</code> 
	 */
	protected List<Double> simpleMeasuredResultsDouble_sorted;
	
	protected List<Long> simpleMeasuredResultsLong;

	/**
	 * There is no SortedList type in Java, so this is a conventional <code>List</code> 
	 */
	protected List<Long> simpleMeasuredResultsLong_sorted;

	private int typeSet;

	public MeasurementResults(){
		typeSet=UNDEFINED;
//		this.simpleMeasuredResults = new ArrayList<Long>();
//		this.simpleMeasuredResultsDouble = new ArrayList<Double>();
		this.desc="No description given";
	}
	
	public MeasurementResults(double measurementValue){
		this();
		typeSet=DOUBLE_MEASUREMENTS;
		this.simpleMeasuredResultsLong=null;
		this.simpleMeasuredResultsLong_sorted=null;
		this.simpleMeasuredResultsDouble = new ArrayList<Double>();
		this.simpleMeasuredResultsDouble.add(measurementValue);
		this.simpleMeasuredResultsDouble_sorted = new ArrayList<Double>();
		this.simpleMeasuredResultsDouble_sorted.add(measurementValue);
		Collections.sort(this.simpleMeasuredResultsDouble_sorted);
	}

	
	public MeasurementResults(double measurementValue, String description){
		this(measurementValue);
		this.setDesc(description);
	}

	public MeasurementResults(long measurementValue){
		this();
		typeSet=LONG_MEASUREMENTS;
		this.simpleMeasuredResultsDouble=null;
		this.simpleMeasuredResultsDouble_sorted=null;
		this.simpleMeasuredResultsLong = new ArrayList<Long>();
		this.simpleMeasuredResultsLong.add(measurementValue);
		this.simpleMeasuredResultsLong_sorted = new ArrayList<Long>();
		this.simpleMeasuredResultsLong_sorted.add(measurementValue);
		Collections.sort(this.simpleMeasuredResultsLong_sorted);
	}
		
	public MeasurementResults(long measurementValue, String description){
		this(measurementValue);
		this.setDesc(description);
	}

	public MeasurementResults(String description){
//		this.simpleMeasuredResultsDouble = new ArrayList<Double>();
		this();
		this.desc=description;
	}

	public void addMeasurement(double measurementValue){
		if(typeSet==DOUBLE_MEASUREMENTS){
			this.simpleMeasuredResultsDouble.add(measurementValue);
			this.simpleMeasuredResultsDouble_sorted.add(measurementValue);
			Collections.sort(this.simpleMeasuredResultsDouble_sorted);//expensive
		}else if(typeSet==LONG_MEASUREMENTS){
			e.println("changing type of measurements not allowed; not adding the measurement");
		}else{
			this.typeSet = DOUBLE_MEASUREMENTS;
			this.simpleMeasuredResultsLong=null;
			this.simpleMeasuredResultsLong_sorted=null;
			this.simpleMeasuredResultsDouble=new ArrayList<Double>();
			this.simpleMeasuredResultsDouble_sorted=new ArrayList<Double>();
			this.simpleMeasuredResultsDouble.add(measurementValue);
			this.simpleMeasuredResultsDouble_sorted.add(measurementValue);
			Collections.sort(this.simpleMeasuredResultsDouble_sorted);
		}
	}

	public void addMeasurement(long measurementValue){
		if(typeSet==LONG_MEASUREMENTS){
			this.simpleMeasuredResultsLong.add(measurementValue);
			this.simpleMeasuredResultsLong_sorted.add(measurementValue);
			Collections.sort(this.simpleMeasuredResultsLong_sorted);
		}else if(typeSet==DOUBLE_MEASUREMENTS){
			o.println("changing type of measurements not allowed");
		}else{
			this.typeSet = LONG_MEASUREMENTS;
			this.simpleMeasuredResultsDouble=null;
			this.simpleMeasuredResultsDouble_sorted=null;
			this.simpleMeasuredResultsLong = new ArrayList<Long>();
			this.simpleMeasuredResultsLong_sorted = new ArrayList<Long>();
			this.simpleMeasuredResultsLong.add(measurementValue);
			this.simpleMeasuredResultsLong_sorted.add(measurementValue);
			Collections.sort(this.simpleMeasuredResultsLong_sorted);
		}
	}
	
	public double computeChainingMeanExpensively_Double(int numberOfChainings){
		return this.computeMeasurementMeanExpensively_Double()/numberOfChainings;
	}
	
	public double computeChainingMeanExpensively_Long(int numberOfChainings){
		return this.computeMeasurementMeanExpensively_Long()/numberOfChainings;
	}
	
	public double computeMeasurementMeanExpensively_Double(){
		double sum=0d;
		for (Iterator<Double> iter = simpleMeasuredResultsDouble.iterator(); iter.hasNext();) {
			sum+=iter.next();
		}
		return (double) sum/simpleMeasuredResultsDouble.size();
	}
	
	public double computeMeasurementMeanExpensively_Long(){
		long sum=0L;
		for (Iterator<Long> iter = simpleMeasuredResultsLong.iterator(); iter.hasNext();) {
			sum+=iter.next();//not checking for overflow...
		}
		return (double) sum/simpleMeasuredResultsLong.size();
	}
	
	private double getDoubleElementAt(int index) {
		if(this.simpleMeasuredResultsDouble==null){
			o.println("Internal data structure is null");
			return Double.NaN;
		}else if(index<0){
			o.println("Parameter may not be less than null");
			return Double.NaN;
		}else if(this.simpleMeasuredResultsDouble.size()<=index){
			o.println("Internal data structure too short (i.e., parameter too large)");
			return Double.NaN;
		}else{
			return this.simpleMeasuredResultsDouble.get(index);
		}
	}
	
	public double getElementAt(int index){
		if(this.typeSet==DOUBLE_MEASUREMENTS){
			return getDoubleElementAt(index);
		}else if(this.typeSet==LONG_MEASUREMENTS){
			return getLongElementAt(index);
		}else{
			return Double.MIN_VALUE;//TODO throw error
		}
	}

	private long getLongElementAt(int index) {
		if(this.simpleMeasuredResultsLong==null){
			o.println("Internal data structure is null");
			return Long.MIN_VALUE;
		}else if(index<0){
			o.println("Parameter may not be less than null");
			return Long.MIN_VALUE;
		}else if(this.simpleMeasuredResultsLong.size()<=index){
			o.println("Internal data structure too short (i.e., parameter too large)");
			return Long.MIN_VALUE;
		}else{
			return this.simpleMeasuredResultsLong.get(index);
		}
	}
	
	/**@deprecated because rounding if number of elements is even
	 * @return
	 */
	public double getMeasurementMedian_Double() { //TODO test
		double median=this.simpleMeasuredResultsDouble_sorted.get(this.simpleMeasuredResultsDouble_sorted.size()/2);
		if(this.simpleMeasuredResultsDouble_sorted.size()%2==0){
			median+=this.simpleMeasuredResultsDouble_sorted.get((this.simpleMeasuredResultsDouble_sorted.size()/2)-1);
			median=median/2;
		}
		return median;
	}
	
	/**@deprecated because rounding if number of elements is even
	 * @return
	 */
	public long getMeasurementMedian_Long() {//TODO test
		long median=this.simpleMeasuredResultsLong_sorted.get(this.simpleMeasuredResultsLong_sorted.size()/2);
		if(this.simpleMeasuredResultsLong_sorted.size()%2==0){
			median+=this.simpleMeasuredResultsLong_sorted.get((this.simpleMeasuredResultsLong_sorted.size()/2)-1);
			median=median/2;
		}
		return median;
	}

	public void setDesc(String description) {
		if(!desc.equals("No description given")){
			o.println("Existing description "+desc+" overwritten with "+description);
		}
		this.desc = description;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		if(this.typeSet==UNDEFINED){
			sb.append("Measurement result has undefined type, no data.");
		}else if(this.typeSet==DOUBLE_MEASUREMENTS){
			sb.append(this.simpleMeasuredResultsDouble.size()+" measurements, " +
				this.getMeasurementMedian_Double()+" is median, " +
				this.computeMeasurementMeanExpensively_Double()+" is mean.");
		}else if(this.typeSet==LONG_MEASUREMENTS){
			sb.append(this.simpleMeasuredResultsLong.size()+" measurements, " +
				this.getMeasurementMedian_Long()+" is median, " +
				this.computeMeasurementMeanExpensively_Long()+" is mean.");
		}
		return sb.toString();
//		sb.append("Median: "+median+", mean: "+mean+", SD: "+SD+".");
//		sb.append("[");
//		double sum=0d;
//		double value=0d;
//		for (Iterator<Double> iter = simpleMeasuredResultsDouble.iterator(); iter.hasNext();) {
//			value = iter.next();
//			sb.append(value+";");
//			sum+=value;
//		}
//		sb.append("]");
//		return "avg: "+(sum/simpleMeasuredResultsDouble.size())+" "+sb.toString();
	}
}
