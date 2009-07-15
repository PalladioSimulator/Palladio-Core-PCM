package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

/**Adapter for TimeSpanSensors to Histograms.
 * @author groenda
 */
public class TimeSpanToThroughputHistogramAdapter extends DataAdapter {

	/** Width of the histogram classes. */
	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	/** Width of the time span. */
	private static final String TIME_SPAN_WIDTH = "TIME_SPAN_WIDTH";
	/** Default width of the time span. */
	private static final double DEFAULT_TIME_SPAN_WIDTH = 10.0;
	
	/** Information about the TimeSpanSensor and the measurements. */
	private SensorAndMeasurements samInformation;

	/**Initializes the adapter with the provided TimeSpanSensor.
	 * @param samInformation Information about the TimeSpanSensor 
	 *        and the measurements.
	 */
	public TimeSpanToThroughputHistogramAdapter(
			final SensorAndMeasurements samInformation) {
		super();
		this.samInformation = samInformation;
		this.adapterProperties.put(HISTOGRAM_WIDTH, Histogram.DEFAULT_BUCKET_WIDTH);
		this.adapterProperties.put(TIME_SPAN_WIDTH, DEFAULT_TIME_SPAN_WIDTH);
	}

	/** {@inheritDoc}
	 */
	public Object getAdaptedObject() {
		throw new RuntimeException("Is not correctly implemented.");
		
//		int maxHistClass = 0;
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		double histWidth = (Double) adapterProperties.get(HISTOGRAM_WIDTH);
//		double spanLenght = (Double) (
//				adapterProperties.get(TIME_SPAN_WIDTH) == null 
//				? DEFAULT_TIME_SPAN_WIDTH 
//				: adapterProperties.get(TIME_SPAN_WIDTH));
//		if (histWidth == 0) {
//			throw new RuntimeException("Histogram width must be > 0");
//		}
//		Histogram hist = 
//			new Histogram(samInformation.getSensor().getSensorName());
//		ArrayList<Integer> count = new ArrayList<Integer>(); 
//		int currentCount = 0; 
//		double currentTime = 0;
//		double nextLimit = spanLenght;
//		boolean first = true;
//		for (Measurement m : samInformation.getMeasurements()) {
//			currentTime = m.getEventTime();
//			if (first) {
//				nextLimit += currentTime;
//				first = false;
//			}
//			if (currentTime < nextLimit) {
//				currentCount++;
//			} else {
//				count.add(currentCount);
//				currentCount = 1;
//				nextLimit += spanLenght;
//			}
//		}
//		for (Integer singleCount : count) {
//			int histogramClass = (int) ((singleCount + histWidth / 2) 
//					/ histWidth);
//			Object o = map.get(histogramClass);
//			if (o != null) {
//				Integer oldValue = (Integer) o;
//				map.put(histogramClass, oldValue + 1);
//			} else {
//				map.put(histogramClass, 1);
//			}
//			if (maxHistClass < histogramClass) {
//				maxHistClass = histogramClass;
//			}
//		}
//		boolean firstValueFound = false;
//		for (int i = 0; i <= maxHistClass; i++) {
//			Object o = map.get(i);
//			if (o != null) {
//				firstValueFound = true;
//				hist.addEntity(new HistogramBucketInformation((Integer) o 
//						/ (double) samInformation.getMeasurements().size(), 
//						i * histWidth));
//			} else {
//				if (firstValueFound) {
//					hist.addEntity(new HistogramBucketInformation(0.0, 
//							i * histWidth));
//				}
//			}
//		}
//		return hist;
	}
}
