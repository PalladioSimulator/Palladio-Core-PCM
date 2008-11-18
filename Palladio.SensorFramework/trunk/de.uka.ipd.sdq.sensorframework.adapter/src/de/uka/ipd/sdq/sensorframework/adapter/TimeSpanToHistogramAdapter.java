package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.HashMap;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

/**Adapter for TimeSpanSensors to Histograms.
 * @author groenda
 */
public class TimeSpanToHistogramAdapter extends DataAdapter {

	/** The identifier for the property "Histogram Width". */
	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	
//	private static final String ACTIVEDE_FILTERS = "ACTIVEDE_FILTERS";
//	private FilteredMeasurementsCollection measurements;
	/** Information about the TimeSpanSensor and the measurements. */
	private SensorAndMeasurements samInformation;

	/**Initializes a new adapter for the provided TimeSpanSensor.
	 * @param sensorAndMeasurements Information about the TimeSpanSensor and the measurements.
	 */
	public TimeSpanToHistogramAdapter(
			final SensorAndMeasurements sensorAndMeasurements) {
		super();
		this.samInformation = sensorAndMeasurements;

		/* Check if there would be at least to different buckets for the
		 * histogram as JFreeChart otherwise displays a bar with default
		 * width and the small values are very difficult to identify.
		 */
		TimeSpanMeasurement timeSpanMeasurement = null;
		double minValue = Double.MAX_VALUE, maxValue = Double.MIN_VALUE;
		for (Measurement measurement : samInformation.getMeasurements()) {
			timeSpanMeasurement = (TimeSpanMeasurement) measurement;
			minValue = (minValue < timeSpanMeasurement.getTimeSpan()) 
					? minValue : timeSpanMeasurement.getTimeSpan();  
			maxValue = (maxValue > timeSpanMeasurement.getTimeSpan()) 
					? maxValue : timeSpanMeasurement.getTimeSpan();  
		}
		if (maxValue - minValue < Histogram.DEFAULT_BUCKET_WIDTH) {
			//whole histogram would be in one bucket, thus set bucket width to 1/2 of total width.  
			this.adapterProperties.put(HISTOGRAM_WIDTH, 
					(maxValue - minValue) / 2.0);
		} else {
			double currentNumberOfBuckets = (maxValue - minValue)/Histogram.DEFAULT_BUCKET_WIDTH;
			if (currentNumberOfBuckets > Histogram.MAXIMUM_NUMBER_OF_BUCKETS){
				//do not show too many buckets (not more than Histogram.MAXIMUM_NUMBER_OF_BUCKETS)
				//Divide by max number to get the factor to make the buckets larger by. 
				double widthFactor = currentNumberOfBuckets / Histogram.MAXIMUM_NUMBER_OF_BUCKETS;
				
				//Also, only use whole numbers for bucket width. Thus, round up after applying the factor. 
				//TODO: Only round up if the number is larger than 1
				double newNumberOfBuckets = Math.ceil(Histogram.DEFAULT_BUCKET_WIDTH * widthFactor); 
				this.adapterProperties.put(HISTOGRAM_WIDTH, 
					newNumberOfBuckets);
			} else {
				this.adapterProperties.put(HISTOGRAM_WIDTH, 
					Histogram.DEFAULT_BUCKET_WIDTH);
			}
		}
		
//		this.properties.put(ACTIVEDE_FILTERS, false);
//		this.measurements = new FilteredMeasurementsCollection(
//				sensorAndMeasurements);
	}

	/** {@inheritDoc}
	 */
	public Object getAdaptedObject() {
//		SensorAndMeasurements values = (Boolean) properties
//				.get(ACTIVEDE_FILTERS) ? (SensorAndMeasurements) measurements
//				.getAdaptedObject() : myValues;

		double histWidth = (Double) adapterProperties.get(HISTOGRAM_WIDTH);
		if (histWidth <= 0) {
			throw new RuntimeException("Histogram width must be > 0");
		}
		
		Histogram histogram = new Histogram(
				samInformation.getSensor().getSensorName(), histWidth);
		HashMap<Integer, Integer> histClasses = new HashMap<Integer, Integer>();
		
		int maxHistClass = 
			assignMeasurementsToClasses(histClasses, histWidth);
		storeClassifiedMeasurementsInHistogram(
				histogram, histClasses, maxHistClass);
		
		return histogram;
	}

	/**Stores the classified measurements in a histogram.
	 * @param histogram The histogram in which the information is stored.
	 * @param histClasses The classes and the frequency of the measurements 
	 *        per class.
	 * @param maxHistClass The class with the higher number in which the 
	 *        frequency is greater than 0.
	 */
	private void storeClassifiedMeasurementsInHistogram(Histogram histogram, 
			final HashMap<Integer, Integer> histClasses, 
			final int maxHistClass) {
		double histWidth = histogram.getBucketWidth();
		boolean firstValueFound = false;
		for (int i = 0; i <= maxHistClass; i++) {
			Integer histClass = histClasses.get(i);
			if (histClass == null) {
				/* only append classes with 0 probability if there is at least 
				 * one class with probability >=0 in the left hand side of the 
				 * current class.
				 */
				if (firstValueFound) {
					histogram.addEntity(new HistogramBucketInformation(0.0, 
							i * histWidth));
				}
			} else {
				firstValueFound = true;
				// calculate probability and store class
				histogram.addEntity(new HistogramBucketInformation(
						histClass.doubleValue() 
						/ (double) samInformation.getMeasurements().size(), 
						i	* histWidth));
			}
		}
	}

	/**Assigns the measurement to histogram classes.
	 * The number of measurements is stored for each of the classes.
	 * @param histClasses Receives the number of measurements for each class.
	 * @param histWidth width of the classes of a histogram.
	 * @return number of the highest class.
	 */
	private int assignMeasurementsToClasses(
			HashMap<Integer, Integer> histClasses, final double histWidth) {
		int maxHistClass = 0;
		int histogramClassNumber;
		for (Measurement measurement : samInformation.getMeasurements()) {
			TimeSpanMeasurement tsm = (TimeSpanMeasurement) measurement;
			/* checks to which class the measurement belongs.
			 * The class number always starts at 0, which means the interval
			 * [0..histWidth/2). Uses integer rounding and comparison for
			 * performance reasons instead of the easier to understand Floor()
			 */
			histogramClassNumber = (int) (tsm.getTimeSpan() / histWidth);
			// increases number of measurements for the class
			Integer classNumber = histClasses.get(histogramClassNumber);
			if (classNumber == null) {
				histClasses.put(histogramClassNumber, 1);
			} else {
				histClasses.put(histogramClassNumber, classNumber.intValue() 
						+ 1);
			}
			/*Store the number of the highest class in which a measurement was 
			 * found
			 */
			if (maxHistClass < histogramClassNumber) {
				maxHistClass = histogramClassNumber;
			}
		}
		return maxHistClass;
	}

//	public FilteredMeasurementsCollection getMeasurements() {
//		return measurements;
//	}
}
