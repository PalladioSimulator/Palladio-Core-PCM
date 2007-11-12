package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.HashMap;
import java.util.Properties;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.sensorframework.adapter.internal.OutlierRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.adapter.internal.WarmupRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class TimeSpanToHistogramAdapter implements IAdapter {

	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	private static final String OUTLIER_REMOVAL = "OUTLIER_REMOVAL";
	private SensorAndMeasurements myValues;
	private Properties myProperties = new Properties();

	public TimeSpanToHistogramAdapter(SensorAndMeasurements sensorAndMeasurements) {
		this.myValues = sensorAndMeasurements;
		this.myProperties.put(HISTOGRAM_WIDTH, 1.0);
		this.myProperties.put(OUTLIER_REMOVAL,false);
	}

	public Object getAdaptedObject() {
		SensorAndMeasurements values = (Boolean)myProperties.get(OUTLIER_REMOVAL) ? 
				(SensorAndMeasurements) new OutlierRemovingAdapterTimeSpanSensor((SensorAndMeasurements) new WarmupRemovingAdapterTimeSpanSensor(myValues).getAdaptedObject()).getAdaptedObject() 
				: myValues;
		int maxHistClass = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		double histWidth = (Double)myProperties.get(HISTOGRAM_WIDTH);
		if (histWidth == 0) {
			throw new RuntimeException("Histogram width must be > 0");
		}
		Histogram hist = new Histogram(values.getSensor().getSensorName());
		for (Measurement m : values.getMeasurements()){
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
		boolean firstValueFound = false;
		for (int i=0; i<=maxHistClass; i++) {
			Object o = map.get(i);
			if (o != null) {
				firstValueFound = true;
				hist.addEntity(new HistogramEntity((Integer)o / (double)values.getMeasurements().size(),i*histWidth));
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
