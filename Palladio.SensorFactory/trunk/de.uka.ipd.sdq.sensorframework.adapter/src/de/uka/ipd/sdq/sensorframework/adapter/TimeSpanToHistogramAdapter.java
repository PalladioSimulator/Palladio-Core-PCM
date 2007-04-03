package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import sun.nio.cs.HistoricallyNamedCharset;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.impl.SensorAndMeasurements;

public class TimeSpanToHistogramAdapter implements IAdapter {

	private static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	private SensorAndMeasurements myValues;
	private Properties myProperties = new Properties();

	public TimeSpanToHistogramAdapter(SensorAndMeasurements sensorAndMeasurements) {
		this.myValues = sensorAndMeasurements;
		this.myProperties.put(HISTOGRAM_WIDTH, 1.0);
	}

	@Override
	public Object getAdaptedObject() {
		int maxHistClass = 0;
		HashMap map = new HashMap();
		double histWidth = (Double) myProperties.get(HISTOGRAM_WIDTH);
		Histogram hist = new Histogram(myValues.getSensor().getSensorName());
		for (Measurement m : myValues.getMeasurements()){
			TimeSpanMeasurement tsm = (TimeSpanMeasurement)m;
			int histogramClass = (int)((tsm.getTimeSpan()+histWidth/2) / histWidth);
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
		for (int i=0; i<maxHistClass; i++) {
			Object o = map.get(i);
			if (o != null) {
				hist.addEntity(new HistogramEntity((Integer)o / (double)myValues.getMeasurements().size(),i*histWidth));
			} else {
				hist.addEntity(new HistogramEntity(0.0,i*histWidth));
			}
		}
		return hist;
	}

	@Override
	public Properties getProperties() {
		return myProperties;
	}

	@Override
	public void setProperties(Properties newProperties) {
		this.myProperties = newProperties;
	}

}
