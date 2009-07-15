package de.uka.ipd.sdq.sensorframework.adapter;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

/**Adapter for TimeSpanSensors to Quantiles.
 * @author groenda
 */
public class TimeSpanToQuantilAdapter extends DataAdapter {

	/** The property "first value below". */
	private static final String FIRST_VALUE_BELOW = "FIRST_VALUE_BELOW";
	/** The property "quantile". */
	private static final String QUANTIL = "QUANTIL";
	/** Default quantile to use. */
	private static final double DEFAULT_QUANTIL = 0.9;
	/** Factor to use for the histogram for correct scaling of qunatiles. */
	private static final double QUANTILE_FACTOR = 0.001;
	/** Information about the TimeSpanSensor and the measurements. */
	private SensorAndMeasurements samInformation;

	/**Initializes the adapter with the provided TimeSpanSensor.
	 * @param samInformation Information about the TimeSpanSensor and the 
	 *        measurements.
	 */
	public TimeSpanToQuantilAdapter(
			final SensorAndMeasurements samInformation) {
		super();
		this.samInformation = samInformation;
		adapterProperties.put(FIRST_VALUE_BELOW, true);
		adapterProperties.put(QUANTIL, DEFAULT_QUANTIL);
	}

	/** {@inheritDoc}
	 */
	public Object getAdaptedObject() {
		TimeSpanToHistogramAdapter tstha = 
			new TimeSpanToHistogramAdapter(samInformation);
		tstha.getProperties().put("HISTOGRAM_WIDTH", 
				new Double(QUANTILE_FACTOR));
		Histogram hist = (Histogram) tstha.getAdaptedObject();
		
		TimeSeries series = new TimeSeries(
				samInformation.getSensor().getSensorName());

		int counter = 0;
		double sum = 0.0;
		for (HistogramBucketInformation he : hist.getBucketInformation()) {
			sum += he.getProbability();
			if (sum >= (Double) adapterProperties.get(QUANTIL)) {
				if ((Boolean) adapterProperties.get(FIRST_VALUE_BELOW) 
						&& counter > 0) {
					// get the former histogram entity
					he = hist.getBucketInformation().get(counter - 1);
				}
				series.add(samInformation.getSensor().getSensorID(), 
						he.getValue());
				return series;
			}
			counter++;
		}
		return series;
	}
}
