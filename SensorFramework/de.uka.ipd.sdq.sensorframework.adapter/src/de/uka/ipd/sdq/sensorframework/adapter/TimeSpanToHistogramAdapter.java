package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

/**
 * Adapter for TimeSpanSensors to Histograms.
 * @author groenda, Michael Kuperberg
 */
public class TimeSpanToHistogramAdapter extends DataAdapter {
	/** The logger used by this class. */
	private Logger logger;
	

	/** The identifier for the property "Histogram Width". */
	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	
//	private static final String ACTIVEDE_FILTERS = "ACTIVEDE_FILTERS";
//	private FilteredMeasurementsCollection measurements;
	/** Information about the TimeSpanSensor and the measurements. */
	private SensorAndMeasurements samInformation;

	@SuppressWarnings("unused")
	private TimeSpanToHistogramAdapter(){
		super();//made private to prevent usage
	}
	
	/**Initializes a new adapter for the provided TimeSpanSensor.
	 * @param sensorAndMeasurements Information about the TimeSpanSensor and the measurements.
	 */
	public TimeSpanToHistogramAdapter(
			final SensorAndMeasurements sensorAndMeasurements) {
		super();
		this.logger =Logger.getLogger(this.getClass().getName());
		this.samInformation = sensorAndMeasurements;

		/* Check if there would be at least two different buckets for the
		 * histogram as JFreeChart otherwise displays a bar with default
		 * width and the small values are very difficult to identify.
		 */
		double newBucketWidth;

		newBucketWidth = calculateHistogramBucketWidthFromMeasurements(samInformation,Histogram.DEFAULT_BUCKET_WIDTH);
		
		this.adapterProperties.put(HISTOGRAM_WIDTH,newBucketWidth);
		logger.debug("Histogram width: "+newBucketWidth);//TODO remove +", nrOfBuckets: "+newNumberOfBuckets
//		this.properties.put(ACTIVEDE_FILTERS, false);
//		this.measurements = new FilteredMeasurementsCollection(
//				sensorAndMeasurements);
	}

	public static final double calculateHistogramBucketWidthFromMeasurements(SensorAndMeasurements sam, 
			Double presetBucketWidth) {
		TimeSpanMeasurement timeSpanMeasurement;
		double newBucketWidth;
		double minValue = Double.MAX_VALUE;
		double maxValue = Double.MIN_VALUE;
		for (Measurement measurement : sam.getMeasurements()) {//TODO lessen overhead!
			timeSpanMeasurement = (TimeSpanMeasurement) measurement;
			minValue = (minValue < timeSpanMeasurement.getTimeSpan()) 
					? minValue : timeSpanMeasurement.getTimeSpan();  
			maxValue = (maxValue > timeSpanMeasurement.getTimeSpan()) 
					? maxValue : timeSpanMeasurement.getTimeSpan();  
		}
		
		newBucketWidth = calculateHistogramBucketWidth(minValue,
				maxValue, presetBucketWidth);
		return newBucketWidth;
	}

	/**
	 * Needs to take Histogram.MAXIMUM_NUMBER_OF_BUCKETS into account. 
	 * Can do so because the adapter's underlying data is fixed and final. 
	 * @param minValue of measurements
	 * @param maxValue of measurements
	 * @return
	 */
	public static final double calculateHistogramBucketWidth(
			double minValue,
			double maxValue,
			double presetBucketWidth) {
		double newBucketWidth = -1; //Histogram.DEFAULT_BUCKET_WIDTH;
		if(minValue>=maxValue){
			//logger.error("minValue<maxValue: "+minValue+"<"+maxValue);
			return Double.NaN;
			//TODO, also check for / assert on NaN
		}
		
		if (maxValue - minValue < presetBucketWidth ) {
			//whole histogram would be in one bucket, thus set bucket width to 1/2 of total width.  
			newBucketWidth = (maxValue - minValue) / 2.0;
			//there are just 2 buckets available now, so it's OK to skip the checking the number of buckets
		} else {
			double currentNumberOfBuckets = (maxValue - minValue)/presetBucketWidth;
			if (currentNumberOfBuckets <= Histogram.MAXIMUM_NUMBER_OF_BUCKETS){
				newBucketWidth = presetBucketWidth;
			} else {
				//do not show too many buckets (not more than Histogram.MAXIMUM_NUMBER_OF_BUCKETS)
				//Divide by max number to get the factor to make the buckets larger by. 
				double widthFactor = currentNumberOfBuckets / Histogram.MAXIMUM_NUMBER_OF_BUCKETS;
				
				//TODO 
				//Also, only use whole numbers for bucket width. Thus, round up after applying the factor. 
				//TODO: Only round up if the number is larger than 1
				//integer bucket width...
				newBucketWidth = Math.ceil(presetBucketWidth * widthFactor); 
			}
		}
		//TODO print histogram bucket width here...
		return newBucketWidth;
	}
	
	

	/**Assigns the measurement to histogram classes.
	 * The number of measurements is stored for each of the classes.
	 * @param histClasses Receives the number of measurements for each class, where 
	 * the keys are class indices (starting with 1) and values are frequencies of 
	 * these classes.
	 * @param histWidth width of the classes of a histogram.
	 * @return number of the highest class, i.e. the maximum key of histClasses
	 */
	private synchronized int assignMeasurementsToClasses(
			HashMap<Integer, Integer> histClasses,//key: index, value:frequency 
			final double histWidth, //TODO assert that it is positive
			final Collection<Measurement> collMeasurements) {
		int maxHistClass = 0;
		int histogramClassNumber;
		for (Measurement measurement : collMeasurements) {
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

	/** {@inheritDoc}
	 */
	public synchronized Object getAdaptedObject() {
		//re-executed each time... because histWidth might have changed...
		//TODO write tests for such re-execution!
		
//		SensorAndMeasurements values = (Boolean) properties
//				.get(ACTIVEDE_FILTERS) ? (SensorAndMeasurements) measurements
//				.getAdaptedObject() : myValues;
		//TODO if this is re-set, no check is made...
		double histBucketWidth = (Double) adapterProperties.get(HISTOGRAM_WIDTH);
		//TODO a security check for whether maximum number of buckets is maintained 
		//needs to go here!
		
		if (histBucketWidth <= 0) {
			throw new RuntimeException("Histogram width must be > 0");
		}else{
			logger.debug("TEST Hist: histWidth "+histBucketWidth);//TODO remove or replace by logger (logging currently doesn't work...)
		}
		
		Histogram histogram;
		HashMap<Integer, Integer> histClasses;
		int maxHistClass;
		
		histogram = new Histogram(
				samInformation.getSensor().getSensorName(), histBucketWidth);//TODO x axis label?
		histClasses = new HashMap<Integer, Integer>();
		
		maxHistClass = //maxHistClass may be larger than Histogram.MAXIMUM_NUMBER_OF_BUCKETS
			this.assignMeasurementsToClasses(histClasses, histBucketWidth, samInformation.getMeasurements());
		this.storeClassifiedMeasurementsInHistogram(
				histogram, histClasses, maxHistClass,histBucketWidth);
		
		//System.err.println("TEST Hist: measurements: "+samInformation.getMeasurements().size()+" measurements"); //: "+samInformation.getMeasurements());//TODO remove
		//System.err.println("TEST Hist: classes: "+histClasses);//TODO remove
		//System.err.println("Classification check: "+checkClasses(histClasses,samInformation.getMeasurements().size()));
		//System.err.println("TEST Hist: histogram: "+histogram);//TODO remove
		return histogram;
	}

	private boolean checkClasses(HashMap<Integer, Integer> histClasses,int sum) {
		int mySum = 0;
		for(Integer key : histClasses.keySet()){
			mySum += histClasses.get(key);
		}
		if(mySum==sum){
			return true;
		}else{
			return false;
		}
		
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
			final int maxHistClass, 
			double histWidth/* = histogram.getBucketWidth();*/
	) {
		Integer[] keyset = histClasses.keySet().toArray(new Integer[]{});
		//TODO use these instead of iterating over indes and checking for empty ones...
		Arrays.sort(keyset);//does not impact the original structure
		Integer largestKeyValue = keyset[keyset.length-1];
		if(largestKeyValue>maxHistClass) {
			logger.error("largers classes key "+largestKeyValue+">"+maxHistClass+" maxHistClass");
		}
		boolean firstValueFound = false;
		double currFrequency,currProbability,currBucketStartValue;
		double totalCount=(double) samInformation.getMeasurements().size();
		//see checkClasses method for comparison of totalCount to the contents of histClasses
		
		logger.debug("Total elements count: "+totalCount);
		
		for (int histogramClassesIndex = 0; histogramClassesIndex <= maxHistClass; histogramClassesIndex++) {//TODO check if we miss something here...
			Integer histClassFrequency = histClasses.get(histogramClassesIndex);
			if (histClassFrequency == null || histClassFrequency==0) {
				/* only append classes with 0 probability if there is at least 
				 * one class with probability >=0 on the left-hand side of the 
				 * current class.
				 */
				if (firstValueFound) {//why add zero-probability buckets at all?
					histogram.addEntity(new HistogramBucketInformation(
							0.0, //probability
							histogramClassesIndex * histWidth//bucket representative: its start, i.e. its left border
							));
				}
			} else {
				firstValueFound = true;
				// calculate probability and store class
				currFrequency = histClassFrequency.doubleValue();
				currProbability = currFrequency / totalCount;
				currBucketStartValue = histogramClassesIndex * histWidth;
				logger.debug("Index "+histogramClassesIndex+", freq "+histClassFrequency+", probability "+currProbability+", value "+currBucketStartValue);//TODO remove
				histogram.addEntity(new HistogramBucketInformation(
						currProbability, 
						currBucketStartValue));
			}
		}
	}

//	public FilteredMeasurementsCollection getMeasurements() {
//		return measurements;
//	}
}
