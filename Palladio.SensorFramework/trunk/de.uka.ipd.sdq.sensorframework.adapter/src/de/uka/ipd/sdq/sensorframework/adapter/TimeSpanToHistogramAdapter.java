package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.HashMap;
import java.util.Properties;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class TimeSpanToHistogramAdapter implements IAdapter {

	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	private static final String ACTIVEDE_FILTERS = "ACTIVEDE_FILTERS";
	private SensorAndMeasurements myValues;
	//private FilteredMeasurementsCollection measurements;
	private Properties properties = new Properties();

	public TimeSpanToHistogramAdapter(
			SensorAndMeasurements sensorAndMeasurements) {
		this.myValues = sensorAndMeasurements;
		this.properties.put(HISTOGRAM_WIDTH, 1.0);
		//this.properties.put(ACTIVEDE_FILTERS, false);
		//this.measurements = new FilteredMeasurementsCollection(sensorAndMeasurements);
	}

	public Object getAdaptedObject() {

//		SensorAndMeasurements values = (Boolean) properties
//				.get(ACTIVEDE_FILTERS) ? (SensorAndMeasurements) measurements
//				.getAdaptedObject() : myValues;

		int maxHistClass = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		double histWidth = (Double) properties.get(HISTOGRAM_WIDTH);
		if (histWidth == 0) {
			throw new RuntimeException("Histogram width must be > 0");
		}
		Histogram hist = new Histogram(myValues.getSensor().getSensorName());
		for (Measurement m : myValues.getMeasurements()) {
			TimeSpanMeasurement tsm = (TimeSpanMeasurement) m;
			int histogramClass = (int) ((tsm.getTimeSpan() + histWidth / 2) / histWidth);
			Object o = map.get(histogramClass);
			if (o != null) {
				Integer oldValue = (Integer) o;
				map.put(histogramClass, oldValue + 1);
			} else
				map.put(histogramClass, 1);
			if (maxHistClass < histogramClass)
				maxHistClass = histogramClass;
		}
		boolean firstValueFound = false;
		for (int i = 0; i <= maxHistClass; i++) {
			Object o = map.get(i);
			if (o != null) {
				firstValueFound = true;
				hist.addEntity(new HistogramEntity((Integer) o
						/ (double) myValues.getMeasurements().size(), i
						* histWidth));
			} else {
				if (firstValueFound)
					hist.addEntity(new HistogramEntity(0.0, i * histWidth));
			}
		}
		return hist;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties newProperties) {
		this.properties = newProperties;
	}

//	public FilteredMeasurementsCollection getMeasurements() {
//		return measurements;
//	}
}
