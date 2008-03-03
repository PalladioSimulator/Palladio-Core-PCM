package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

public class TimeSpanToThroughputHistogramAdapter implements IAdapter {

	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	private static final String TIME_SPAN_WIDTH = "TIME_SPAN_WIDTH";
	
	private SensorAndMeasurements myValues;
	private Properties myProperties = new Properties();

	public TimeSpanToThroughputHistogramAdapter(SensorAndMeasurements sensorAndMeasurements) {
		this.myValues = sensorAndMeasurements;
		this.myProperties.put(HISTOGRAM_WIDTH, 1.0);
		this.myProperties.put(TIME_SPAN_WIDTH, 10.0);
	}

	public Object getAdaptedObject() {
		int maxHistClass = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		double histWidth = (Double)myProperties.get(HISTOGRAM_WIDTH);
		double spanLenght = (Double)(myProperties.get(TIME_SPAN_WIDTH) == null ? 10.0 : myProperties.get(TIME_SPAN_WIDTH));
		if (histWidth == 0) {
			throw new RuntimeException("Histogram width must be > 0");
		}
		Histogram hist = new Histogram(myValues.getSensor().getSensorName());
		ArrayList<Integer> count = new ArrayList<Integer>(); int currentCount = 0; 
		double currentTime = 0;
		double nextLimit = spanLenght;
		boolean first = true;
		for (Measurement m : myValues.getMeasurements()){
			currentTime = m.getEventTime();
			if (first) {
				nextLimit += currentTime;
				first = false;
			}
			if (currentTime < nextLimit)
				currentCount++;
			else {
				count.add(currentCount);
				currentCount = 1;
				nextLimit += spanLenght;
			}
		}
		for (Integer singleCount : count){
			int histogramClass = (int)((singleCount+histWidth/2) / histWidth);
			Object o = map.get(histogramClass);
			if (o != null)
			{
				Integer oldValue = (Integer)o;
				map.put(histogramClass, oldValue+1);
			}
			else
				map.put(histogramClass,1);
			if (maxHistClass < histogramClass)
				maxHistClass = histogramClass;
		}
		boolean firstValueFound = false;
		for (int i=0; i<=maxHistClass; i++) {
			Object o = map.get(i);
			if (o != null) {
				firstValueFound = true;
				hist.addEntity(new HistogramEntity((Integer)o / (double)myValues.getMeasurements().size(),i*histWidth));
			} else {
				if (firstValueFound)
					hist.addEntity(new HistogramEntity(0.0,i*histWidth));
			}
		}
		return hist;
	}

	public Properties getProperties() {
		return myProperties;
	}

	public void setProperties(Properties newProperties) {
		this.myProperties = newProperties;
	}

}
