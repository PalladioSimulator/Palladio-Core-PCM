package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Properties;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class TimeSpanToTimeSeriesAdapter implements IAdapter {

	//private FilteredMeasurementsCollection measurements;
	private SensorAndMeasurements values;

	//private static final String ACTIVEDE_FILTERS = "ACTIVEDE_FILTERS";
	private Properties properties = new Properties();

	public TimeSpanToTimeSeriesAdapter(SensorAndMeasurements values) {
		super();
		this.values = values;
	}

	public Object getAdaptedObject() {
		TimeSeries series = new TimeSeries(values.getSensor().getSensorName());
		for (Measurement m : values.getMeasurements()) {
			series.add(m.getMeasurementID(), ((TimeSpanMeasurement) m)
					.getTimeSpan());
		}

		return series;
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.IAdapter#getProperties()
	 */
	public Properties getProperties() {
		return properties;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.IAdapter#setProperties(java.util.Properties)
	 */
	public void setProperties(Properties newProperties) {
		this.properties = newProperties;
	}
}
