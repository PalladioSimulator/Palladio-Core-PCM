package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Properties;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeriesEntity;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class TimeSpanToTimeSeriesAdapter implements IAdapter {

	private SensorAndMeasurements myValues;
	private Properties myProperties = new Properties();

	public TimeSpanToTimeSeriesAdapter(SensorAndMeasurements myValues) {
		super();
		this.myValues = myValues;
	}

	@Override
	public Object getAdaptedObject() {
		TimeSeries series = new TimeSeries( myValues.getSensor().getSensorName() );
		for (Measurement m : myValues.getMeasurements()) {
			series.add(m.getMeasurementID(), ((TimeSpanMeasurement)m).getTimeSpan());
		}
		return series;
	}

	@Override
	public Properties getProperties() {
		return myProperties;
	}

	@Override
	public void setProperties(Properties newProperties) {
		myProperties = newProperties;
	}

}
