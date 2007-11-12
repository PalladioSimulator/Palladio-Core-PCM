package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Properties;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.adapter.internal.OutlierRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.adapter.internal.WarmupRemovingAdapterTimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class TimeSpanToTimeSeriesAdapter implements IAdapter {

	private static final String OUTLIER_REMOVAL = "OUTLIER_REMOVAL";
	private SensorAndMeasurements myValues;
	private Properties myProperties = new Properties();

	public TimeSpanToTimeSeriesAdapter(SensorAndMeasurements myValues) {
		super();
		this.myValues = myValues;
		myProperties.put(OUTLIER_REMOVAL,true);
	}

	public Object getAdaptedObject() {
		SensorAndMeasurements values = (Boolean)myProperties.get(OUTLIER_REMOVAL) ? 
				(SensorAndMeasurements) new OutlierRemovingAdapterTimeSpanSensor((SensorAndMeasurements) new WarmupRemovingAdapterTimeSpanSensor(myValues).getAdaptedObject()).getAdaptedObject() 
				: myValues;
		TimeSeries series = new TimeSeries( values.getSensor().getSensorName() );
		for (Measurement m : values.getMeasurements()) {
			series.add(m.getMeasurementID(), ((TimeSpanMeasurement)m).getTimeSpan());
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
