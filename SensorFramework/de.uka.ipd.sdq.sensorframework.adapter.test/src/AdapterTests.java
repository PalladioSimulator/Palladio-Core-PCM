import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;
import de.uka.ipd.sdq.sensorframework.adapter.MeasurementsComparator;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanSensorToHistogramFactory;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanSensorToThroughputHistogramFactory;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanToHistogramAdapter;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanToThroughputHistogramAdapter;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.TimeSpanMeasurementImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.TimeSpanSensorImpl;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;


public class AdapterTests extends TestCase {
	private static Logger log;

//	public void testInternalAdapter(){
//		SensorAndMeasurements sam = initialiseSAM(new double[]{1,2,3,4,5,6,7,8,9,1000});
//		SensorAndMeasurements outlierSAM = (SensorAndMeasurements) new OutlierRemovingAdapterTimeSpanSensor(sam).getAdaptedObject();
//		Assert.assertEquals(9,outlierSAM.getMeasurements().size());
//		for (double value : new double[]{1,2,3,4,5,6,7,8,9}) {
//			boolean found = false;
//			for(Iterator<Measurement> it = outlierSAM.getMeasurements().iterator(); it.hasNext(); ) {
//				TimeSpanMeasurement tsm = (TimeSpanMeasurement) it.next();
//				if (tsm.getTimeSpan() == value)
//					found  = true;
//			}
//			Assert.assertTrue(found);
//		}
//	}

//	public void testWarmupAdapter() {
//		SensorAndMeasurements sam = initialiseSAM(new double[]{1,2,3,4,5,6,7,8,9,1000});
//		WarmupRemovingAdapterTimeSpanSensor adapter = new WarmupRemovingAdapterTimeSpanSensor(sam);
//		adapter.getProperties().put(WarmupRemovingAdapterTimeSpanSensor.WARMUP_SIZE, 2L);
//		SensorAndMeasurements outlierSAM = (SensorAndMeasurements) adapter.getAdaptedObject();
//		Assert.assertEquals(8,outlierSAM.getMeasurements().size());
//		for (double value : new double[]{3,4,5,6,7,8,9,1000}) {
//			boolean found = false;
//			for(Iterator<Measurement> it = outlierSAM.getMeasurements().iterator(); it.hasNext(); ) {
//				TimeSpanMeasurement tsm = (TimeSpanMeasurement) it.next();
//				if (tsm.getTimeSpan() == value)
//					found  = true;
//			}
//			Assert.assertTrue(found);
//		}
//	}

	/**
	 * TODO refactor into a proper test
	 * @param overlapping
	 * @param eventTimeSpacing
	 */
	static{
		log = Logger.getLogger("AdapterTests");
		BasicConfigurator.configure();
		log.setLevel(Level.DEBUG);
	}
	public AdapterTests(){
		
	}
	
	@SuppressWarnings("unused")
	private boolean areEqual(Histogram histo1, Histogram histo2){
		return histo1.equals(histo2);
	}
	
	@SuppressWarnings("unused")
	private SensorAndMeasurements initialiseSAM(double[] timespans) {
		IDAOFactory daoFactory = new MemoryDAOFactory(1);
		Experiment exp = daoFactory.createExperimentDAO().addExperiment("Server");
		ExperimentRun expRun = daoFactory.createExperimentRunDAO().addExperimentRun(new Date().toString());
		exp.addExperimentRun(expRun);
		TimeSpanSensor tss = exp.addTimeSpanSensor("Overall RT");
		for (double value : timespans)
			expRun.addTimeSpanMeasurement(tss, 0, value);
		return expRun.getMeasurementsOfSensor(tss);
	}
	
	@SuppressWarnings("unused")
	private SensorAndMeasurements initialiseSAMbyEventTimes(double[] times) {
		IDAOFactory daoFactory = new MemoryDAOFactory(1);
		Experiment exp = daoFactory.createExperimentDAO().addExperiment("Server");
		ExperimentRun expRun = daoFactory.createExperimentRunDAO().addExperimentRun(new Date().toString());
		exp.addExperimentRun(expRun);
		TimeSpanSensor tss = exp.addTimeSpanSensor("Overall RT");
		long l=0;
		for (double value : times)
			expRun.addTimeSpanMeasurement(tss, value, l++);
		return expRun.getMeasurementsOfSensor(tss);
	}
	
	public void performFullTasks(){
		int nrOfMeasurements = 21;

//		double timeSpanWidth = TimeSpanToThroughputHistogramAdapter.DEFAULT_TIME_SPAN_WIDTH;
//		double histogramWidth = Histogram.DEFAULT_BUCKET_WIDTH;   
		
		boolean overlapping = true;
		int eventTimeSpacing = 1;
		
		performThroughputHistogramCreation(overlapping, eventTimeSpacing, nrOfMeasurements);
		
		overlapping = false;
		eventTimeSpacing = 1;
		performThroughputHistogramCreation(overlapping, eventTimeSpacing, nrOfMeasurements);
		
		overlapping = true;
		eventTimeSpacing = 15;
		performThroughputHistogramCreation(overlapping, eventTimeSpacing, nrOfMeasurements);
		
		overlapping = false;
		eventTimeSpacing = 15;
		performThroughputHistogramCreation(overlapping, eventTimeSpacing, nrOfMeasurements);

	}
	
	/**
	 * If overlapping is true, measurements are created with eventTimes
	 * 0, 1*eventTimeSpacing, 2*eventTimeSpacing, etc. and have a length 
	 * of 2*eventTimeSpacing, which means that they overlap each other. 
	 * If overlapping is false, measurements spacing is 4*eventTimeSpacing, so 
	 * that there is no overlap. Note that Measurement does not include 
	 * timeSpan as a field, so the overlapping does not have any effect in this 
	 * test (in fact, this is one of the subjects of the test. 
	 * 
	 * This test should be run with ordered (sorted) and unordered measurements, 
	 * with the first measurement started at time 0 and the first measurement started 
	 * at time > 0; it should be tested if exceptions are properly thrown when 
	 * the eventTime of an event is negative. 
	 * @param overlapping
	 * @param eventTimeSpacing
	 * @param nrOfMeasurements
	 */
	public Histogram performThroughputHistogramCreation(
			boolean overlapping, 
			int eventTimeSpacing, 
			int nrOfMeasurements) {
		Collection<Measurement> measurements = new ArrayList<Measurement>();
		log.debug("\n"+"Testing settings: "+
				"overlapping="+overlapping+", "+
				"eventTimeSpacing="+eventTimeSpacing+", "+
				"nrOfMeasurements="+nrOfMeasurements);
		for(int i=0; i<nrOfMeasurements; i++){
			//TODO it is unclear what the eventTime field of the TimeSpanMeasurementImpl means...
			//TODO it is unclear what the timeSpan field of the TimeSpanMeasurementImpl means...
			//completion or initiation?
			if(overlapping){
				measurements.add(new TimeSpanMeasurementImpl(
						i, //id
						i*eventTimeSpacing,//eventTime 
						2*eventTimeSpacing //timespan
						));
			}else{
				measurements.add(new TimeSpanMeasurementImpl(
						i, 
						i*4*eventTimeSpacing, 
						2*eventTimeSpacing));
			}
			
		}
		for(Measurement m : measurements){
			log.debug(m);
		}
		
		Sensor sensor = new TimeSpanSensorImpl(null);//TODO null factory for testing
		SensorAndMeasurements sam = new SensorAndMeasurements(sensor, measurements);
		TimeSpanSensorToThroughputHistogramFactory factory;
		factory = new TimeSpanSensorToThroughputHistogramFactory();
		TimeSpanToThroughputHistogramAdapter adapter;
		adapter = (TimeSpanToThroughputHistogramAdapter) factory.getAdapter(sam);
		log.debug("Adapter properties: "+adapter.getProperties());
		//adapter.
		Histogram histogram = (Histogram) adapter.getAdaptedObject();
		log.debug("Histogram bucket width: "+histogram.getBucketWidth());
		log.debug("Number of histogram buckets: "+histogram.getBucketInformation().size());
		Iterator<HistogramBucketInformation> iter = histogram.getBucketInformation().iterator();
		HistogramBucketInformation bucket;
		while(iter.hasNext()){
			bucket = iter.next();
			log.debug("Histogram bucket: "+
					"prob="+bucket.getProbability()+", " +
					"value="+bucket.getValue());
		}
		return histogram;
	}
	
	boolean sortedMapsEqualByEpsilon(
			SortedMap<Double,Integer> first, 
			SortedMap<Double,Integer> second, 
			double epsilon){
		Iterator<Double> iterFirst = first.keySet().iterator();
		Iterator<Double> iterSecond = second.keySet().iterator();
		if(first==null){
			if(second==null){
				return true;
			}else{
				return false;
			}
		}
		Double currFirst = 0D;
		Double currSecond = 0D;
		while(iterFirst.hasNext()){
			currFirst = iterFirst.next();
			currSecond = iterSecond.next();
			if(Math.abs(currFirst-currSecond)>epsilon){
				return false;
			}else{
				if(!first.get(currFirst).equals(second.get(currSecond))){
					return false;
				}
			}
		}
		return true;
	}
	
	public void testAggregateToHistogramWidth() {
		SortedMap<Double,Integer> throughputFrequenciesDouble;
		SortedMap<Double,Integer> result; 
		SortedMap<Double,Integer> expectedResult;
		
		throughputFrequenciesDouble = new TreeMap<Double, Integer>();
		throughputFrequenciesDouble.put(0.51,1);
		throughputFrequenciesDouble.put(0.79,1);
		throughputFrequenciesDouble.put(2.72,2);
		throughputFrequenciesDouble.put(2.83,1);
		throughputFrequenciesDouble.put(2.91,1);
		
		result = TimeSpanToThroughputHistogramAdapter.aggregateToHistogramBucketWidth(1.0, throughputFrequenciesDouble);
		expectedResult = new TreeMap<Double,Integer>();
		expectedResult.put(0.5, 2);
		expectedResult.put(2.5, 4);
		Assert.assertEquals(expectedResult,result);
		
		result = TimeSpanToThroughputHistogramAdapter.aggregateToHistogramBucketWidth(0.2, throughputFrequenciesDouble);
		expectedResult = new TreeMap<Double,Integer>();
		expectedResult.put(0.5, 1);
		expectedResult.put(0.7, 1);
		expectedResult.put(2.7, 2);
		expectedResult.put(2.9, 2);
		Assert.assertEquals(true, sortedMapsEqualByEpsilon(expectedResult,result,0.001D));
	}
	
	public void testCalculateHistogramBucketWidth(){
		double minValue = Histogram.DEFAULT_BUCKET_WIDTH;
		double maxValue = Histogram.DEFAULT_BUCKET_WIDTH*1.9D;
		double result;
		result = TimeSpanToHistogramAdapter.calculateHistogramBucketWidth(
				minValue, 
				maxValue,
				1);
		Assert.assertEquals(0, Double.compare(maxValue/2-minValue/2, result));
		
		maxValue = Histogram.DEFAULT_BUCKET_WIDTH*2.1D;
		result = TimeSpanToHistogramAdapter.calculateHistogramBucketWidth(
				minValue, 
				maxValue,
				1);
		Assert.assertEquals(0, Double.compare(Histogram.DEFAULT_BUCKET_WIDTH, result));
		maxValue = Histogram.DEFAULT_BUCKET_WIDTH*(Histogram.MAXIMUM_NUMBER_OF_BUCKETS+3);
		result = TimeSpanToHistogramAdapter.calculateHistogramBucketWidth(
				minValue, 
				maxValue,
				1);
		Assert.assertEquals(0, Double.compare(2*Histogram.DEFAULT_BUCKET_WIDTH, result));
	}
	
	public void testComparator() {
		MeasurementsComparator comparator = new MeasurementsComparator();
		Measurement m1 = new TimeSpanMeasurementImpl(1, 2, 1);
		Measurement m2 = new TimeSpanMeasurementImpl(3, 4, 5);
		Measurement m3 = new TimeSpanMeasurementImpl(6, 2, 7);
		Measurement m4 = new TimeSpanMeasurementImpl(6, 2, 8);
		Assert.assertEquals( 0, comparator.compare(m1,m1));
		Assert.assertEquals(-1, comparator.compare(m1,m2));
		Assert.assertEquals(-1, comparator.compare(m1,m3));
		Assert.assertEquals(-1, comparator.compare(m1,m4));

		Assert.assertEquals( 1, comparator.compare(m2,m1));
		Assert.assertEquals( 0, comparator.compare(m2,m2));
		Assert.assertEquals( 1, comparator.compare(m2,m3));
		Assert.assertEquals( 1, comparator.compare(m2,m4));

		Assert.assertEquals( 1, comparator.compare(m3,m1));
		Assert.assertEquals(-1, comparator.compare(m3,m2));
		Assert.assertEquals( 0, comparator.compare(m3,m3));
		Assert.assertEquals( 0, comparator.compare(m3,m4));

		Assert.assertEquals( 1, comparator.compare(m4,m1));
		Assert.assertEquals(-1, comparator.compare(m4,m2));
		Assert.assertEquals( 0, comparator.compare(m4,m3));
		Assert.assertEquals( 0, comparator.compare(m4,m4));

//		SensorAndMeasurements sam = initialiseSAM(new double[]{1,2,3,4,5,6,7,8,9,1000});
//		WarmupRemovingAdapterTimeSpanSensor adapter = new WarmupRemovingAdapterTimeSpanSensor(sam);
//		adapter.getProperties().put(WarmupRemovingAdapterTimeSpanSensor.WARMUP_SIZE, 2L);
//		SensorAndMeasurements outlierSAM = (SensorAndMeasurements) adapter.getAdaptedObject();
//		Assert.assertEquals(8,outlierSAM.getMeasurements().size());
//		for (double value : new double[]{3,4,5,6,7,8,9,1000}) {
//			boolean found = false;
//			for(Iterator<Measurement> it = outlierSAM.getMeasurements().iterator(); it.hasNext(); ) {
//				TimeSpanMeasurement tsm = (TimeSpanMeasurement) it.next();
//				if (tsm.getTimeSpan() == value)
//					found  = true;
//			}
//			Assert.assertTrue(found);
//		}
	}
	
	public void testFillHistogramFromFrequencies(){
		Histogram result = null;
		SortedMap<Double,Integer> aggregatedThroughputs;
		aggregatedThroughputs = new TreeMap<Double, Integer>();
		aggregatedThroughputs.put(1.50D, 2);
		aggregatedThroughputs.put(2.51D, 3);
		
		TimeSpanToThroughputHistogramAdapter.fillHistogramFromFrequencies(
				result, 
				aggregatedThroughputs, 
				1.0D);
		Histogram expectedResult;
		expectedResult = new Histogram("expectedHistogram", 1.0D);
		expectedResult.addEntity(new HistogramBucketInformation(0.4D, 1.50D));
		expectedResult.addEntity(new HistogramBucketInformation(0.6D, 2.51D));
		
	}
	
	public void testGetMeasurementsInEachTimeWindow() {
//		TimeSpanToThroughputHistogramAdapter adapter = new TimeSpanToThroughputHistogramAdapter(null);
		Collection<Measurement> collection = new ArrayList<Measurement>();
		collection.add(new TimeSpanMeasurementImpl(1, 5, 2.0));
		collection.add(new TimeSpanMeasurementImpl(2, 4, 2.5));
		collection.add(new TimeSpanMeasurementImpl(3, 0.2, 3.0));
		collection.add(new TimeSpanMeasurementImpl(4, 11.9, 3.5));
		ArrayList<Integer> result; 
		ArrayList<Integer> expectedResult;

		//resulting buckets: [0.2,2.2), [2.2,4.2), [4.2,6.2), [6.2,8.2), [8.2,10.2), [10.2,12.2),   
		result = TimeSpanToThroughputHistogramAdapter.getMeasurementsInEachTimeWindow(collection, 2, true, false);
		expectedResult = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1,0,0,1}));
		Assert.assertEquals(expectedResult,result);

		//resulting buckets: [0.0,2.0), [2.0,4.0), [4.0,6.0), [6.0,8.0), [8.0,10.0), [10.0,12.0),   
		result = TimeSpanToThroughputHistogramAdapter.getMeasurementsInEachTimeWindow(collection, 2, false, false);
		expectedResult = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,0,2,0,0,1}));
		Assert.assertEquals(expectedResult,result);

		//resulting buckets: [0.2,3.2), [3.2,6.2), [6.2,9.2), [9.2,12.2)   
		result = TimeSpanToThroughputHistogramAdapter.getMeasurementsInEachTimeWindow(collection, 3, true, false);
		expectedResult = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,0,1}));
		Assert.assertEquals(expectedResult,result);

		//resulting buckets: [0.0,3.0), [3.0,6.0), [6.0,9.0), [9.0,12.0)   
		result = TimeSpanToThroughputHistogramAdapter.getMeasurementsInEachTimeWindow(collection, 3, true, false);
		expectedResult = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,0,1}));
		Assert.assertEquals(expectedResult,result);

	}

	public void testGetThroughputFrequencies(){
		List<Integer> measurements;
		measurements = new ArrayList<Integer>();
		measurements.add(5);
		measurements.add(5);
		measurements.add(10);
		measurements.add(20);
		SortedMap<Double,Integer> expectedResult;
		SortedMap<Double,Integer> result;
		double timeWindowLength;
		
		
		timeWindowLength = 1.0D;
		result = TimeSpanToThroughputHistogramAdapter.getThroughputFrequencies(
				timeWindowLength, measurements);
		expectedResult = new TreeMap<Double, Integer>();
		expectedResult.put(5D, 2);
		expectedResult.put(10D, 1);
		expectedResult.put(20D, 1);
		Assert.assertEquals(expectedResult, result);

		timeWindowLength = 2.0D;
		result = TimeSpanToThroughputHistogramAdapter.getThroughputFrequencies(
				timeWindowLength, measurements);
		expectedResult = new TreeMap<Double, Integer>();
		expectedResult.put(2.5D, 2);
		expectedResult.put(5D, 1);
		expectedResult.put(10D, 1);
		Assert.assertEquals(expectedResult, result);

	}
	
	public void testHistogramBucketInformation(){
		HistogramBucketInformation hbi1 = new HistogramBucketInformation(0.1D, 0.2D);
		HistogramBucketInformation hbi2 = new HistogramBucketInformation(0.11D, 0.2D);
		HistogramBucketInformation hbi3 = new HistogramBucketInformation(0.10001D, 0.2D);
		HistogramBucketInformation hbi4 = new HistogramBucketInformation(0.1D, 0.21D);
		HistogramBucketInformation hbi5 = new HistogramBucketInformation(0.1D, 0.20001D);
		Assert.assertEquals(0, hbi1.compareTo(hbi1));
		Assert.assertEquals(0, hbi1.compareTo(hbi3));
		Assert.assertEquals(-1, hbi1.compareTo(hbi4));
		Assert.assertEquals(-1, hbi1.compareTo(hbi2));
		Assert.assertEquals(0, hbi1.compareTo(hbi5));
		
		Assert.assertEquals(1, hbi2.compareTo(hbi1));
		Assert.assertEquals(0, hbi2.compareTo(hbi2));
		Assert.assertEquals(1, hbi2.compareTo(hbi3));
		Assert.assertEquals(-1, hbi2.compareTo(hbi4));
		Assert.assertEquals(1, hbi2.compareTo(hbi5));
		
		Assert.assertEquals(0, hbi3.compareTo(hbi1));
		Assert.assertEquals(-1, hbi3.compareTo(hbi2));
		Assert.assertEquals(0, hbi3.compareTo(hbi3));
		Assert.assertEquals(-1, hbi3.compareTo(hbi4));
		Assert.assertEquals(0, hbi3.compareTo(hbi5));
	}
	
	public void testHistogramBucketWidthResizingAndCreation(){
		Histogram result;
		Histogram expectedResult;
		Collection<Measurement> measurements;
		Sensor sensor;
		SensorAndMeasurements sam;
		TimeSpanSensorToThroughputHistogramFactory factory;
		TimeSpanToThroughputHistogramAdapter adapter;
		
		measurements = new ArrayList<Measurement>();
		measurements.add(new TimeSpanMeasurementImpl(
				1, //id
				1.1D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				2, //id
				1.2D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				3, //id
				2.3D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				4, //id
				3.4D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				5, //id
				4.6D,//eventTime 
				2.0D //timespan
				));
		
		sensor = new TimeSpanSensorImpl(null);//TODO null factory for testing
		sam = new SensorAndMeasurements(sensor, measurements);
		factory = new TimeSpanSensorToThroughputHistogramFactory();
		adapter = (TimeSpanToThroughputHistogramAdapter) factory.getAdapter(sam);
		
		//TODO removed tests because bucket changes must be coordinated with min and max measurements TODO
//		adapter.setBucketWidth(0.1D);//TODO this should be checked...
//		adapter.setTimespanWidth(1.0D);//TODO this should be checked...
//		log.error("Adapter properties: "+adapter.getProperties());
//		result = (Histogram) adapter.getAdaptedObject();
//		expectedResult = new Histogram("ExpectedHistogram", result.getBucketWidth());
//		expectedResult.addEntity(new HistogramBucketInformation(0.25D, 2.05D));
//		expectedResult.addEntity(new HistogramBucketInformation(0.75D, 1.05D));
//		Assert.assertEquals(expectedResult, result);
//		
//		adapter.setBucketWidth(0.2D);
//		adapter.setTimespanWidth(8.0D);//throughput: 5/8=0.625
//		log.error("Adapter properties: "+adapter.getProperties());
//		result = (Histogram) adapter.getAdaptedObject();
//		expectedResult = new Histogram("ExpectedHistogram", result.getBucketWidth());
//		expectedResult.addEntity(new HistogramBucketInformation(1.0D, 0.7D));
//		Assert.assertEquals(expectedResult, result);
	}
	
	public void testHistogramComparisons(){
		Histogram hist1 = new Histogram("Empty histogram1");
		Histogram hist2 = new Histogram("Empty histogram2");
		Assert.assertEquals(true, hist1.equals(hist2));
		Assert.assertEquals(true, hist2.equals(hist1));
		Assert.assertEquals(0, hist1.compareTo(hist2));
		Assert.assertEquals(0, hist2.compareTo(hist1));
		Assert.assertEquals(Histogram.DEFAULT_BUCKET_WIDTH, hist1.getBucketWidth());
		Assert.assertEquals(Histogram.DEFAULT_BUCKET_WIDTH, hist2.getBucketWidth());
		//the remaining cases are removed, because setBucketWidth was made a private method, to prevent inconsistent results
//		hist1.setBucketWidth(0.1);
//		Assert.assertEquals(false, hist1.equals(hist2));
//		Assert.assertEquals(false, hist2.equals(hist1));
//		Assert.assertEquals(
//				Double.compare(hist1.getBucketWidth(),hist2.getBucketWidth()), 
//				hist1.compareTo(hist2));
//		Assert.assertEquals(
//				Double.compare(hist2.getBucketWidth(),hist1.getBucketWidth()), 
//				hist2.compareTo(hist1));
//		Assert.assertEquals(false, hist1.addEntity(new HistogramBucketInformation(1.1D, 1)));
//		Assert.assertEquals(false, hist1.addEntity(new HistogramBucketInformation(-0.1D, 1)));
//		HistogramBucketInformation nanBucket = new HistogramBucketInformation(Double.NaN, 1);
////		System.out.println(nanBucket);
//		Assert.assertEquals(false, hist1.addEntity(nanBucket));
//		
//		HistogramBucketInformation hbi = new HistogramBucketInformation(0.9D, 1);
//		Assert.assertEquals(true, hist1.addEntity(hbi));
//		hist2.setBucketWidth(0.1);
//		Assert.assertEquals(false, hist1.equals(hist2));
//		Assert.assertEquals(false, hist2.equals(hist1));
//		
//		Assert.assertEquals(false, hist1.removeEntity(new HistogramBucketInformation(0.9D, 1.01D)));
//		Assert.assertEquals(false, hist1.removeEntity(new HistogramBucketInformation(0.901D, 1.0D)));
//		Assert.assertEquals(false, hist1.removeEntity(null));
//		Assert.assertEquals(true, hist1.removeEntity(hbi));
//		
//		Assert.assertEquals(true, hist1.equals(hist2));
//		Assert.assertEquals(true, hist2.equals(hist1));
	}
	
	/**
	 * TODO Test bucket width adaptation on creation...
	 * @deprecated as long as just a copty
	 */
	public void testFullHistogramCreation(){
		Histogram result;
		Histogram expectedResult;
		Collection<Measurement> measurements;
		Sensor sensor;
		SensorAndMeasurements sam;
		TimeSpanSensorToHistogramFactory factory;
		TimeSpanToHistogramAdapter adapter;
		
		measurements = new ArrayList<Measurement>();
		measurements.add(new TimeSpanMeasurementImpl(
				1, //id
				1.1D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				2, //id
				1.2D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				3, //id
				2000.3D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				4, //id
				2001.4D,//eventTime 
				2.0D //timespan
				));
		measurements.add(new TimeSpanMeasurementImpl(
				5, //id
				1004.6D,//eventTime 
				2.0D //timespan
				));
		
		sensor = new TimeSpanSensorImpl(null);//TODO null factory for testing
		sam = new SensorAndMeasurements(sensor, measurements);
		factory = new TimeSpanSensorToHistogramFactory();
		adapter = (TimeSpanToHistogramAdapter) factory.getAdapter(sam);
		
		log.error("Adapter properties: "+adapter.getProperties());
		result = (Histogram) adapter.getAdaptedObject();
		System.out.println(result);
//		expectedResult = new Histogram("ExpectedHistogram", 10);
//		expectedResult.addEntity(new HistogramBucketInformation(0.25D, 2.05D));
//		expectedResult.addEntity(new HistogramBucketInformation(0.75D, 1.05D));
//		Assert.assertEquals(expectedResult, result);
//		
//		log.error("Adapter properties: "+adapter.getProperties());
//		result = (Histogram) adapter.getAdaptedObject();
//		expectedResult = new Histogram("ExpectedHistogram", result.getBucketWidth());
//		expectedResult.addEntity(new HistogramBucketInformation(1.0D, 0.7D));
//		Assert.assertEquals(expectedResult, result);
	}
}
