package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

//import org.apache.log4j.*;

/**
 * Adapter for TimeSpanSensors to Throughput (!) Histograms.
 * TODO explain why the adaptee (i.e. the input data) cannot change
 * TODO check that the sum of probabilities is at most epsilon from 1 !
 * TODO bucket equidistance is ensured in this class -> propagate to the Histogram class
 * TODO make it configurable whether the first histogram bucket starts with the first real element
 * @author Michael Kuperberg, Henning Groenda
 */
public class TimeSpanToThroughputHistogramAdapter extends DataAdapter {
	
	/** Default histogram bucket width, i.e. TODO */
	private static final double DEFAULT_HISTOGRAM_WIDTH = 1.0; //TODO consider the case where the histogram width is smaller ?! Histogram.DEFAULT_BUCKET_WIDTH;

	/** Default width of the time span for which a throughput is constructed. */
	public static final double DEFAULT_TIME_SPAN_WIDTH = 10.0;
	
	/** Properties key for width of the histogram classes. */
	public static final String HISTOGRAM_WIDTH_PROPERTY_NAME = "HISTOGRAM_WIDTH";

	/**
	 * Log4j logger (TODO configuration!)
	 */
	private static Logger log;
	
	/**
	 * The sum of histogram probabilities is allowed to deviate from 
	 * 1.0 by this epsilon value, to account for rounding errors etc.
	 * If this threshold is exceeded, a RuntimeException should be thrown. 
	 */
	private static final double PROBABILITIES_SUM_ALLOWED_EPSILON = 0.01D;

	/** Properties key for the width of the time span, 
	 * i.e. (supposedly) the length of window 
	 * for which the throughput value is calculated. 
	 * */
	private static final String TIME_SPAN_WIDTH_PROPERTY_NAME = "TIME_SPAN_WIDTH";
	
	/**
	 * TODO to be tested...
	 * TODO this implementation assumes that the histogram buckets are aligned 
	 * so that the left border of the (potentially first) bucket starts at 0.0
	 * Assumption (TODO check!): non-negative values because throughputs are never negative!
	 * @param widthOfHistogramClass width of histogram class
	 * @param throughputFrequenciesDouble non-aggregated frequencies
	 * @return aggregated frequencies, where the key is the center of the corresponding bucket 
	 * and only non-empty buckets are returned (!)
	 */
	public synchronized static SortedMap<Double, Integer> aggregateToHistogramBucketWidth(
			Double widthOfHistogramClass,
			SortedMap<Double, Integer> throughputFrequenciesDouble) {
		Double[] keysAsArray = throughputFrequenciesDouble.keySet().toArray(new Double[]{});
		
		SortedMap<Double, Integer> aggregatedThroughputs;
		aggregatedThroughputs = new TreeMap<Double, Integer>();
		Double keyOfAggregated;
		Integer oldValueOfAggregated;
//		Double lastKey = keysAsArray[keysAsArray.length-1];
//		for(int i=0; i<Math.ceil(lastKey/widthOfHistogramClass); i++){
//			keyOfAggregated = i*widthOfHistogramClass+widthOfHistogramClass/2;
//			aggregatedThroughputs.put(keyOfAggregated, 0);
//		}
		for(int i=0; i<keysAsArray.length; i++){
			keyOfAggregated = 
				(new Double(keysAsArray[i]/widthOfHistogramClass).intValue()+0.5d)
				*widthOfHistogramClass;//could be rounding issues here...
			if(aggregatedThroughputs.get(keyOfAggregated)==null){
				aggregatedThroughputs.put(
						keyOfAggregated, 
						throughputFrequenciesDouble.get(keysAsArray[i]));
			}else{
				oldValueOfAggregated = (Integer) aggregatedThroughputs.get(keyOfAggregated);
				aggregatedThroughputs.put(
						keyOfAggregated, 
						oldValueOfAggregated+throughputFrequenciesDouble.get(keysAsArray[i]));
			}
		}
		return aggregatedThroughputs;
	}
	
	/**
	 * Only the values inside {@#aggregatedThroughputs} are considered
	 *  - eventual "leading zeros" or "intermediate zeros" etc. must already be included. 
	 *  The method does not check (yet) whether histogram width or 
	 *  "one in bucket" rule (see histogramBucketWidth) is violated. 
	 * @param totalNumberOfConsideredWindows
	 * @param aggregatedThroughputs
	 * @param histogramBucketWidth
	 */
	public static synchronized void fillHistogramFromFrequencies(
			Histogram hist,
			SortedMap<Double,Integer> aggregatedThroughputs, //key: throughput, value: frequency of throughput
			double histogramBucketWidth//, 
//			boolean includeLeadingEmptyBuckets, //should be set to true by default...
//			boolean includeIntermediateLeadingBuckets
			/*, 
			int totalNumberOfConsideredWindows, 
			double timeWindowLengthForThroughputCalculation,
			int totalNumberOfMeasurements*/){
		if(histogramBucketWidth<=0.0){
			throw new RuntimeException("Invalid, non-positive bucket width for histogram: "+
					histogramBucketWidth);
		}
		if(hist==null){
			hist = new Histogram("New empty histogram", histogramBucketWidth, "Throughput");
		}
		if(aggregatedThroughputs==null || aggregatedThroughputs.size()==0){
			hist = new Histogram("Empty histogram",histogramBucketWidth,"Throughput");
			return;//really?
			//throw new RuntimeException("null cannot be converted into a Histogram instance");
		}
		Long sumOfAggregatedClasses = 0L;
		for (Double key : aggregatedThroughputs.keySet()) {
			if(sumOfAggregatedClasses+aggregatedThroughputs.get(key)<sumOfAggregatedClasses){
				throw new RuntimeException("Overflow detected while adding "+
						aggregatedThroughputs.get(key)+" to "+sumOfAggregatedClasses+
						" for computing frequencies");
			}else{
				sumOfAggregatedClasses += aggregatedThroughputs.get(key);
			}
		}
		//TODO is a check missing here?
		
		Double sumOfProbabilities = 0.0D;
		
//		Double firstKey = aggregatedThroughputs.keySet().iterator().next();//shorter way...?
//		int bucketIndexToStartWith = 0;
//		if(firstKey-histogramBucketWidth>PROBABILITIES_SUM_ALLOWED_EPSILON){
//			if(includeLeadingEmptyBuckets)
//		}
		sumOfProbabilities = 0.0D;
		Double probability; 
		for (Double key : aggregatedThroughputs.keySet()) {
			probability = new Double(aggregatedThroughputs.get(key)) / new Double(sumOfAggregatedClasses);
			sumOfProbabilities += probability;//now reused to check for "missed" classes
			hist.addEntity(new HistogramBucketInformation(
					probability, //TODO rounding issues?
					key));
		}
		if(Math.abs(sumOfProbabilities-1.0D)>PROBABILITIES_SUM_ALLOWED_EPSILON){
			throw new RuntimeException("Sum of histogram probabilities too far from 1.0D, " +
					"histogram classes were lost");
		}
					//former key: (i * widthOfHistogramClass)/timeWindowLengthForThroughputCalculation));//value (i.e. throughput)
//			Object o = throughputFrequenciesInteger.get(i);
//			if (o != null) {
//				firstValueFound = true;
//				//this was grossly wrong: o was divided by samInformation.getMeasurements().size()
//				//and count did not consider empty buckets (see above)
//				
//			} else {
//				if (firstValueFound) {
//					hist.addEntity(new HistogramBucketInformation(
//							0.0, //probability
//							(i * widthOfHistogramClass)/timeWindowLengthForThroughputCalculation //value
//					));
//				}else{
//					//"no leading zeros" (aka empty buckets): only insert a 
//					//"real" HistorgramBucketInformation if non-empty bucket has been found
//				}
//			}
//		}
//		int totalNumberOfConsideredWindows, 
//		double timeWindowLengthForThroughputCalculation,
//		int totalNumberOfMeasurements
//		boolean firstValueFound = false;
//		
//		Double overallTime = totalNumberOfConsideredWindows*timeWindowLengthForThroughputCalculation;
		//later, check that SUM(throughput*probability)*overallTime==totalNumberOfMeasurements
		
		//throughput histogram: x axis needs to be sorted in the order of ascending throughputs
		//implicit assumption: there is at least one non-zero througput
		//otherwise, no buckets will be returned at all
		
	}

	/**
	 * For a collection of measurements, finds how many measurements fall in classes 
	 * of width {@link timeWindowLengthForThroughputCalculation}. 
	 * For example, if firstBucketStartsWithSmallestRealValue is set to true, 
	 * for windows length 2 and the first value being 0.4, 
	 * the windows are [0.4, 2.4), [2.4, 4.4) etc.
	 * If firstBucketStartsWithSmallestRealValue is set to false, 
	 * for the same settings (windows length 2, the first value is 0.4), 
	 * the windows are [0.0, 2.0), [2.0, 4.0) etc.
	 * 
	 * TODO check for side effects
	 * @param collection va
	 * @param timeWindowLengthForThroughputCalculation
	 * @param firstBucketStartsWithSmallestRealValue flag
	 * @param considerTimespanEndInsteadOfStart flag
	 * @return TODO
	 */
	public synchronized static ArrayList<Integer> getMeasurementsInEachTimeWindow(
			Collection<Measurement> collection, 
			double timeWindowLengthForThroughputCalculation, 
			boolean firstBucketStartsWithSmallestRealValue, 
			boolean considerTimespanEndInsteadOfStart//TODO test this flag
			) {
		if(collection == null){
			return null;
		}else if(collection.size()==0){
			return new ArrayList<Integer>();
		}
		Measurement[] measurements = collection.toArray(new Measurement[]{});
		Arrays.sort(measurements, new MeasurementsComparator());
		for(Measurement m : measurements){
			if(m.getEventTime()<0){
				throw new RuntimeException("Timespan measurements cannot have negative event time");
			}
		}
		
		ArrayList<Integer> count;
		count = new ArrayList<Integer>();
		
		int currentCount = 0;
		double currentTime = 0;
		double nextLimit = timeWindowLengthForThroughputCalculation;
		boolean first = true;
		TimeSpanMeasurement tsm;
		//undocumented assumption: the measurements are sorted by the time! TODO check
		for (Measurement m : measurements/*samInformation.getMeasurements()*/) {
			currentTime = m.getEventTime();//TODO timespan is ignored!
			if(considerTimespanEndInsteadOfStart){
				try{
					tsm = (TimeSpanMeasurement) m;
					currentTime += tsm.getTimeSpan();
				}catch(ClassCastException e){
					//log_debug("cannot cast Measurement into TimeSpanMeasurement");//e.printStack
				}catch (Exception e) {
					// TODO: handle exception other than ClassCastException
				}
			}
			//log_debug(m);
			if (first) {
				if(firstBucketStartsWithSmallestRealValue) nextLimit += currentTime;
				//log_debug("First measurement; nextLimit established to "+nextLimit);
				first = false;
			}
			if (currentTime < nextLimit) {//also run when first==true
				//if(bucketOpen){
					currentCount++;
					//log_debug("currentCount increased to "+currentCount);
				//}else{
				//	
				//}
				//TODO add proper logging log_debug("After "+m+": currentCount="+currentCount);
			} else {
				count.add(currentCount);//previous bucket completed
//				log_debug("Added completed bucket with "+
//						currentCount+" elements to counts");
				nextLimit += timeWindowLengthForThroughputCalculation;
//				log_debug("Next limit: "+nextLimit);
				
				//some buckets may be empty - must be accounted for properly!
				while(currentTime>=nextLimit){
//					System.out.print("currentTime "+currentTime+">="+nextLimit+": ");
					count.add(0);
					nextLimit += timeWindowLengthForThroughputCalculation;
//					log_debug("added 0 to counts; increased nextLimit to "+nextLimit); 
				}
				
				currentCount = 1;
//				log_debug("Current count set to 1");
			}
		}
		count.add(currentCount); // the last, dangling one...
		return count;
	}

	/**
	 * Check for leading and intermediate zeros
	 * @param timeWindowLengthForThroughputCalculation
	 * @param measurementsInTimeWindows
	 * @return
	 */
	public synchronized static SortedMap<Double, Integer> getThroughputFrequencies(
			Double timeWindowLengthForThroughputCalculation,
			List<Integer> measurementsInTimeWindows) {
		//measuremntsInTimeWindows is unsorted, but this is not a problem...
		SortedMap<Double, Integer> throughputFrequenciesDouble;
		throughputFrequenciesDouble = new TreeMap<Double, Integer>();
		for (Integer singleCount : measurementsInTimeWindows) {
			//throughput for a given time interval 
			double histogramClassDouble = new Double(singleCount)/timeWindowLengthForThroughputCalculation;//TODO test the impact of changing histWidth
			
			Integer oldValue = throughputFrequenciesDouble.get(histogramClassDouble);//should be typed correctly!!!
			if (oldValue == null || oldValue==0) {
				throughputFrequenciesDouble.put(histogramClassDouble, 1);
			} else {
				throughputFrequenciesDouble.put(histogramClassDouble, oldValue + 1);
			}
		}
		return throughputFrequenciesDouble;
	}

	/** Information about the TimeSpanSensor and the measurements. */
	private SensorAndMeasurements samInformation;

	/**
	 * TODO explain!!!
	 */
	private boolean supportAggregation = true;

	/**
	 * Temporary using System.out because logger config is a nightmare
	 */
	private boolean logUsingLogger = false;

	@SuppressWarnings("unused")
	private TimeSpanToThroughputHistogramAdapter(){
		super();
	}
	
	/**
	 * Initializes the adapter with the provided TimeSpanSensor.
	 * 
	 * @param samInformation
	 *            Information about the TimeSpanSensor and the measurements. 
	 *            Does not change after passing because final. 
	 */
	public TimeSpanToThroughputHistogramAdapter(
			final SensorAndMeasurements samInformation) {
		super();
		log = Logger.getLogger(this.getClass().getCanonicalName());
		log.setLevel(Level.DEBUG);
		BasicConfigurator.configure();//TODO unify this!
		this.samInformation = samInformation;//TODO check for null? or null permitted?
		this.adapterProperties.put(//TODO consider adding logging here!
				HISTOGRAM_WIDTH_PROPERTY_NAME,
				DEFAULT_HISTOGRAM_WIDTH);
		this.adapterProperties.put(
				TIME_SPAN_WIDTH_PROPERTY_NAME, 
				DEFAULT_TIME_SPAN_WIDTH);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object getAdaptedObject() {
		
		Double timeWindowLengthForThroughputCalculation = 0D;
		if(adapterProperties.get(TIME_SPAN_WIDTH_PROPERTY_NAME) == null){
			timeWindowLengthForThroughputCalculation 
				= (Double) DEFAULT_TIME_SPAN_WIDTH;
		}else{
			timeWindowLengthForThroughputCalculation 
				= (Double) adapterProperties.get(TIME_SPAN_WIDTH_PROPERTY_NAME);
		}

		Double widthOfHistogramClass = (Double) adapterProperties.get(HISTOGRAM_WIDTH_PROPERTY_NAME);
		if (widthOfHistogramClass < 0 
				|| widthOfHistogramClass.equals(0) 
				|| widthOfHistogramClass.equals(Double.NaN)) {
			throw new RuntimeException("Histogram width must be > 0 and non-NaN");
		}else if (widthOfHistogramClass==null) {
			throw new RuntimeException("Histogram width must a non-null Double");
		}
		Double recomputedBucketWidth = TimeSpanToHistogramAdapter.calculateHistogramBucketWidthFromMeasurements(this.samInformation, widthOfHistogramClass);
		if(recomputedBucketWidth.compareTo(widthOfHistogramClass)!=0){
			log.error("recomputed bucket width "+recomputedBucketWidth+" is different from "+//TODO check output!
					"property-read bucket width "+widthOfHistogramClass);
		}else{
			log.debug("recomputed bucket width is the same as the property-based bucket width");
		}
		if(samInformation.getMeasurements().size()==0){
			throw new RuntimeException("No measurements passed for throughput histogram calculation");
		}
		
		Histogram hist = new Histogram(
				samInformation.getSensor().getSensorName(), 
				widthOfHistogramClass, 
				"Throughput");//on request of Heiko Koziolek
		
		//contains, for each window of length timeWindowLengthForThroughputCalculation, 
		//the number of measurements in that window
		//(the windows are non-overlapping) 
		//TODO implement consistency checks
		//TODO windows may be empty! - this should be reflected in "zero throuput" bucket
		
		log_debug("1. Individual measurements: ");
		for(Measurement m: samInformation.getMeasurements()){
			log_debug(""+m);
		}
		
		log_debug("2. Number of measurements in *each* window: ");
		List<Integer> measurementsInTimeWindows;// are the "leading zeros" included?
		measurementsInTimeWindows = getMeasurementsInEachTimeWindow(
				samInformation.getMeasurements(), 
				timeWindowLengthForThroughputCalculation, 
				true, //first bucket starts with the first real value (i.e., the buckets are not aligned!)
				false //consider timestamp end instead of start
				);
		
		for(Integer m : measurementsInTimeWindows){
			log_debug(m+" ");
		}
		log_debug("-> "+measurementsInTimeWindows.size()+" windows");
		
		log_debug("3a. Map 'throughput per window'->'frequency of this throughput value': ");
		SortedMap<Double, Integer> throughputFrequenciesDouble;
		throughputFrequenciesDouble = getThroughputFrequencies(
				timeWindowLengthForThroughputCalculation,
				measurementsInTimeWindows);
		
		for(Double m : throughputFrequenciesDouble.keySet()){
			log_debug(m+"->"+throughputFrequenciesDouble.get(m));
		}
		

//		HashMap<Integer, Integer> throughputFrequenciesInteger;
//		throughputFrequenciesInteger = new HashMap<Integer, Integer>();
//		maxFoundThroughputInteger = getThroughputFrequencies(
//				maxFoundThroughputInteger, 
//				widthOfHistogramClass,
//				measurementsInTimeWindows, 
//				throughputFrequenciesInteger);
//		log_debug("3b. Map 'throughput per window'->'frequency of this throughput value': ");
//		for(Integer m : throughputFrequenciesInteger.keySet()){
//			log_debug(m+"->"+throughputFrequenciesInteger.get(m));
//		}
		
		if(supportAggregation){
			SortedMap<Double,Integer> aggregatedThroughputs;
			aggregatedThroughputs = aggregateToHistogramBucketWidth(
					widthOfHistogramClass, throughputFrequenciesDouble);
			log_debug("4. Aggregated into histogram buckets of width "+widthOfHistogramClass+": " +
					"Map 'throughput per window'->'frequency of this throughput value': ");
			for(Double m : aggregatedThroughputs.keySet()){
				log_debug(m+"->"+aggregatedThroughputs.get(m));
			}
			fillHistogramFromFrequencies(hist, aggregatedThroughputs, widthOfHistogramClass); 
				
		}else{
			fillHistogramFromFrequencies(hist, throughputFrequenciesDouble, widthOfHistogramClass); 
		}
		
		log_debug("5. Created histogram: buckets: ");
		//TODO check sum, etc.
		for(HistogramBucketInformation m : hist.getBucketInformation()){
			log_debug(""+m);
		}
		
		return hist;
	}

	private void log_debug(String str){
		if(logUsingLogger ){
			log.debug(str);
		}else{
			System.out.println(str);
		}
	}
	
	/**
	 * TODO explain
	 * @param d
	 */
	public void setTimespanWidth(double d) {
		if(d>0.0D){
			this.adapterProperties.put(
					TIME_SPAN_WIDTH_PROPERTY_NAME,
					d);
		}else{
			throw new RuntimeException("timespan width must be larger than 0");
		}
	}

//	/**
//	 * So far, only the start time of the measurement is considered. 
//	 * Setting this flag to true should result in considering the duration 
//	 * of a measurement as well. 
//	 */
//	@SuppressWarnings("unused")
//	private boolean considerTimespanEndInsteadOfStart = DEFAULT_CONSIDER_TIMESPAN_DURATION;
//
//	/**
//	 * For a histogram with bucket width 2, setting this field to 
//	 * true means that histogram element 1 encompasses values in the interval 
//	 * [0,1). For another histogram with bucket width 3, setting this field 
//	 * to false means that the histogram element 4 encompasses values in the 
//	 * interval [4,7).   
//	 */
//	@SuppressWarnings("unused")
//	private boolean histogramElementValueDefinesCenter=false;
//	
//	/**
//	 * TODO
//	 */
//	private boolean includeIntermediateEmptyBuckets = DEFAULT_INCLUDE_INTERMEDIATE_EMPTY_BUCKETS;
//
//	/**
//	 * TODO
//	 */
//	private boolean includeLeadingEmptyBuckets = DEFAULT_INCLUDE_LEADING_EMPTY_BUCKETS;
//
//	/**
//	 * For later use - currently ignored...
//	 */
//	private static final boolean DEFAULT_CONSIDER_TIMESPAN_DURATION = false; 
//	/**
//	 * TODO this 
//	 * @param d
//	 */
//	public void setBucketWidth(double d) {
//		if(d>0.0D){
//			this.adapterProperties.put(
//					HISTOGRAM_WIDTH_PROPERTY_NAME,
//					d);
//		}else{
//			throw new RuntimeException("bucket width must be larger than 0");
//		}
//	}
//
//	int numberOfConsideredWindows = measurementsInTimeWindows.size();
//	boolean firstValueFound = false;
//
//	throughput histogram: x axis needs to be sorted in the order of ascending throughputs
//	double sumOfProbabilities = 0D;
//	double probability = 0D;
//	//implicit assumption: there is at least one non-zero througput
//	//otherwise, no buckets will be returned at all
//	for (int i = 0; i <= maxFoundThroughputInteger; i++) {
//		Object o = throughputFrequenciesInteger.get(i);
//		if (o != null) {
//			firstValueFound = true;
//			//this was grossly wrong: o was divided by samInformation.getMeasurements().size()
//			//and count did not consider empty buckets (see above)
//			probability = new Double((Integer) o) / measurementsInTimeWindows.size();
//			sumOfProbabilities += probability;
//			hist.addEntity(new HistogramBucketInformation(
//					probability, //TODO rounding issues?
//					(i * widthOfHistogramClass)/timeWindowLengthForThroughputCalculation));//value (i.e. throughput)
//		} else {
//			if (firstValueFound) {
//				hist.addEntity(new HistogramBucketInformation(
//						0.0, //probability
//						(i * widthOfHistogramClass)/timeWindowLengthForThroughputCalculation //value
//				));
//			}else{
//				//"no leading zeros" (aka empty buckets): only insert a 
//				//"real" HistorgramBucketInformation if non-empty bucket has been found
//			}
//		}
//	}
	//cross-check
//	double sumOfElementsFromHistogram = 0.0D;
//	for(HistogramBucketInformation bucket : hist.getBucketInformation()){
//		sumOfElementsFromHistogram += bucket.getProbability()*bucket.getValue();
//	}
//	double crossCheckEpsilon = 0.1;
//	int nrOfMeasurements = samInformation.getMeasurements().size();
//	if(Math.abs(sumOfElementsFromHistogram-nrOfMeasurements)>crossCheckEpsilon){
//		throw new RuntimeException("Cross-check of histogram plausibility " +
//				"failed: \n" +
//				"sumOfElementsFromHistogram="+
//				sumOfElementsFromHistogram+" too far from " +
//				"number of measurements (="+nrOfMeasurements+")");
//	
//	}
	
	
//	if(Math.abs(1-sumOfProbabilities)>PROBABILITIES_SUM_ALLOWED_EPSILON){
//		throw new RuntimeException("Sum of probabilities during histogram computation " +
//				"too different from 1: "+sumOfProbabilities);
//	}
//	private synchronized int getThroughputFrequencies(int maxFoundThroughputInteger,
//			Double widthOfHistogramClass,
//			ArrayList<Integer> measurementsInTimeWindows,
//			HashMap<Integer, Integer> throughputFrequenciesInteger) {
//		for (Integer singleCount : measurementsInTimeWindows) {
//			//throughput for a given time interval 
//			//TODO not clear why addition of (histWidth/2) was originaly needed here...
//			//TODO division by widthOfHistogramClass (instead of timeWindowLength*) appears to be wrong
//			int histogramClassInteger = (int) ((singleCount + widthOfHistogramClass / 2) / widthOfHistogramClass);
//			//int histogramClass = new Double((double) singleCount/(double) histWidth + 0.5d).intValue();
//			
//			Integer oldValue = throughputFrequenciesInteger.get(histogramClassInteger);//should be typed correctly!!!
//			if (oldValue == null || oldValue==0) {
//				throughputFrequenciesInteger.put(histogramClassInteger, 1);
//			} else {
//				throughputFrequenciesInteger.put(histogramClassInteger, oldValue + 1);
//			}
//			//contains the maximum throughput
//			if (maxFoundThroughputInteger < histogramClassInteger) {
//				maxFoundThroughputInteger = histogramClassInteger;
//			}
//		}
//		return maxFoundThroughputInteger;
//	}
//	/**
//	 * 
//	 */
//	private static final boolean DEFAULT_INCLUDE_INTERMEDIATE_EMPTY_BUCKETS = false;
//
//	private static final boolean DEFAULT_INCLUDE_LEADING_EMPTY_BUCKETS = false;
	
}
