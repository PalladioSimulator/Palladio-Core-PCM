package de.uka.ipd.sdq.sensorframework.adapter.internal;

import java.util.Properties;

import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;


public class WarmupRemovingAdapterTimeSpanSensor implements IAdapter {

	public static final String WARMUP_SIZE = "Warmup_Size";
	private Properties myProperties = new Properties();
	private SensorAndMeasurements sam;

	public WarmupRemovingAdapterTimeSpanSensor(SensorAndMeasurements sensorAndMeasurements){
		this.sam = sensorAndMeasurements;
		myProperties.put(WARMUP_SIZE,2500L);
	}

	public Object getAdaptedObject() {
		SensorAndMeasurements result = new SensorAndMeasurements(sam.getSensor(),
			new WarmupFilteringCollection(sam.getMeasurements(),(Long) myProperties.get(WARMUP_SIZE))); 
		
		return result;
	}

	public Properties getProperties() {
		return myProperties;
	}

	public void setProperties(Properties arg0) {
		myProperties = arg0;
	}

}
