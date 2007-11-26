package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Properties;

import com.sun.corba.se.spi.protocol.ClientDelegateFactory;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.adapter.internal.OutlierRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.adapter.internal.WarmupRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class TimeSpanToQuantilAdapter implements IAdapter {

	private static final String FIRST_VALUE_BELOW = "FIRST_VALUE_BELOW";
	private static final String QUANTIL = "QUANTIL";
	private SensorAndMeasurements myValues;
	private Properties myProperties = new Properties();

	public TimeSpanToQuantilAdapter(SensorAndMeasurements myValues) {
		super();
		this.myValues = myValues;
		myProperties.put(FIRST_VALUE_BELOW, true);
		myProperties.put(QUANTIL, 0.9);
	}

	public Object getAdaptedObject() {
		TimeSpanToHistogramAdapter tstha = new TimeSpanToHistogramAdapter(myValues);
		tstha.getProperties().put("HISTOGRAM_WIDTH", new Double(0.01));
		Histogram hist = (Histogram) tstha.getAdaptedObject();
		
		TimeSeries series = new TimeSeries(myValues.getSensor().getSensorName());

		int counter = 0;
		double sum = 0.0;
		for (HistogramEntity he : hist.getEntityList()){
			sum += he.getProbability();
			if (sum >= (Double)myProperties.get(QUANTIL)){
				if ((Boolean)myProperties.get(FIRST_VALUE_BELOW) && counter>0){
					// get the former histogram entity
					he = hist.getEntityList().get(counter-1);
				}
				series.add( myValues.getSensor().getSensorID(), he.getValue());
				return series;
			}
			counter++;
		}
		return series;
	}

	public Properties getProperties() {
		return myProperties;
	}

	public void setProperties(Properties newProperties) {
		myProperties = newProperties;
	}

}