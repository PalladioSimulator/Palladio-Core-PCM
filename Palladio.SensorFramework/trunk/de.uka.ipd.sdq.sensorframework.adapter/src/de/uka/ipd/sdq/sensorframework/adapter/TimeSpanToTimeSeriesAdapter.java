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
		//properties.put(ACTIVEDE_FILTERS,true);
		//this.measurements =  new FilteredMeasurementsCollection(values);
		this.values = values;
	}

	public Object getAdaptedObject() {
		// SensorAndMeasurements sensorAndMeasurements = (Boolean) properties
		// .get(ACTIVEDE_FILTERS) ? (SensorAndMeasurements) measurements
		// .getAdaptedObject() : values;
		//
		// TimeSeries series = new TimeSeries(sensorAndMeasurements.getSensor()
		// .getSensorName());
		// for (Measurement m : sensorAndMeasurements.getMeasurements()) {
		// series.add(m.getMeasurementID(), ((TimeSpanMeasurement) m)
		// .getTimeSpan());
		// }
		//		

		TimeSeries series = new TimeSeries(values.getSensor().getSensorName());
		for (Measurement m : values.getMeasurements()) {
			series.add(m.getMeasurementID(), ((TimeSpanMeasurement) m)
					.getTimeSpan());
		}

		return series;
	}

	
//	public FilteredMeasurementsCollection getMeasurements() {
//		return measurements;
//	}
//
//	public void setMeasurements(FilteredMeasurementsCollection measurements) {
//		this.measurements = measurements;
//	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.IAdapter#getProperties()
	 */
	@Override
	public Properties getProperties() {
		return properties;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.IAdapter#setProperties(java.util.Properties)
	 */
	@Override
	public void setProperties(Properties newProperties) {
		this.properties = newProperties;
	}
}
