package de.uka.ipd.sdq.ByCounter.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.ByCounter.test.JGFCastBench_MK;
import de.uka.ipd.sdq.ByCounter.test.Linpack_MK;
import de.uka.ipd.sdq.ByCounter.test.SciMarkMonteCarlo_MK;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * Class for measuring the cost of the bytecode instrumentation as well as the 
 * cost for the invocation of (instrumented) methods.
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class CostMeasurement {
	
	@SuppressWarnings("unused")
	private static String CHART_DIR = "charts";	// directory to output charts into
	
//	/** Filetypes for chart files. */
//	public static final int FILETYPE_JPG = 0;
//	public static final int FILETYPE_PDF = 1;
//	public static final int FILETYPE_PNG = 2;

	private static final int INSTRUMENTATION_INSTRUMENT_AND_CALL = 0;
	@SuppressWarnings("unused")
	private static final int INSTRUMENTATION_INSTRUMENT_ONLY = 1;		// for verbosity
	private static final int INSTRUMENTATION_NO_HIGH_REGISTERS = 2;	// for verbosity

	/** Flags for instrumentation modes. Combine bitwise. TODO*/
	public static final int INSTRUMENTATION_NONE = -1;
	public static final int INSTRUMENTATION_USE_HIGH_REGISTERS = 1;
	
	private static Logger log;
	private static int NUMBEROFMEASUREMENTS_DEFAULT = 4;

	private static String TEST_CLASS_CANONICAL_NAME_JFG = JGFCastBench_MK.class.getCanonicalName();
	private static String TEST_CLASS_CANONICAL_NAME_LI 	= Linpack_MK.class.getCanonicalName();
	private static String TEST_CLASS_CANONICAL_NAME_MC	= SciMarkMonteCarlo_MK.class.getCanonicalName();
	
	private static String TEST_METHODSIG_JFG			= "public void JGFrun()";
	private static String TEST_METHODSIG_LI 			= "public void run_benchmark()";
	private static String TEST_METHODSIG_MC 			= "public static final double integrateMK()";
	private static final int USE_JGF = 0;
	private static final int USE_LINPACK = 1;
	private static final int USE_SCIMARK = 2;

	/**
	 * Main call for a measurement of the costs for instrumentation.
	 * @param args First argument is the number if measurements to do.
	 */
	public static void main(String args[]) {
		int numberOfMeasurements = NUMBEROFMEASUREMENTS_DEFAULT;
		
		// try to read command line arguments
		if (args.length > 0) {
		    try {
		    	numberOfMeasurements = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument must be an integer (number of measurements).");
		        System.exit(1);
		    }
		} else {
			System.out.println("Warning: Expected one argument to be supplied for the number " +
					"of measurements to take. Using default of "+numberOfMeasurements+".");
		}
		
		// start the measurement
		CostMeasurement measurement = new CostMeasurement(numberOfMeasurements);
		measurement.measureAllClasses();
	}
	@SuppressWarnings("unused")
	private ArrayList<Long> callCostInstrumResults_dynamic;
	@SuppressWarnings("unused")
	private ArrayList<Long> callCostInstrumResults_high;
	
	@SuppressWarnings("unused")
	private ArrayList<Long> callCostNoInstrumResults;
	
	protected long diff = 0L;
	@SuppressWarnings("unused")
	private ArrayList<Long> instrumentationResults_dynamic;
	@SuppressWarnings("unused")
	private ArrayList<Long> instrumentationResults_high;
	private Map<String, List<String>> methodnames;

	//	private long nanoTimeCost;
	protected int numberOfMeasurements;
	protected long start = 0L;
	protected long stop = 0L;
	private String testClassName;
	private String testMethodSignature;

	private int use;
	
	/**
	 * Construct CostMeasurement.
	 * @param numberOfMeasurements The number of measurements to perform.
	 */
	public CostMeasurement(int pNumberOfMeasurements) {
		
		this.use = USE_JGF;
		
		if(use == USE_JGF){
			this.testClassName = TEST_CLASS_CANONICAL_NAME_JFG;
			this.testMethodSignature = TEST_METHODSIG_JFG;
		}else if(use == USE_LINPACK){
			this.testClassName = TEST_CLASS_CANONICAL_NAME_LI;
			this.testMethodSignature = TEST_METHODSIG_LI;
		}else if(use == USE_SCIMARK){
			this.testClassName = TEST_CLASS_CANONICAL_NAME_MC;
			this.testMethodSignature = TEST_METHODSIG_MC;
		}else{
			//TODO
		}
	
		// setup log4j
		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(this.getClass().getCanonicalName());
		this.numberOfMeasurements = pNumberOfMeasurements;
		
		// get a (not so accurate) value for nanoTimeCost //TODO: talkback
//		long n1, n2;
//		n1 = System.nanoTime();
//		do {
//			n2 = System.nanoTime();
//		} while(n1 == n2);
//		this.nanoTimeCost = n2-n1;
		this.methodnames = new HashMap<String, List<String>>();
	}
	

	/**
	 * Do a measurement on the given <code>IMeasurable</code>. This
	 * does not substract the costs for calling <code>nanoTime()</code>!
	 * @param measurable IMeasurable object that defines what to measure. 
	 * @param numberOfMeasurements The number of repetitive calls for a measurement.
	 * @return An ArrayList of longs that represent the time (in nanoseconds) 
	 * that a call of the IMeasurable's callForMeasurement method has taken.
	 */
	@SuppressWarnings("boxing")
	public ArrayList<Long> measure(IMeasurable measurable, int pNumberOfMeasurements) {
		ArrayList<Long> measurements = new ArrayList<Long>(pNumberOfMeasurements);
		
		boolean prepareSuccess = measurable.prepareMeasuring();
//		int numberOfRepetitions = 1;

		if(prepareSuccess == false) {
			log.error("ERROR: Could not initialize the measuring with " + 
					measurable.toString() + ". Skipping.");
		} else {
			// do the measurements
			for (int i = 0; i < pNumberOfMeasurements; i++) {

				// automatism to increase repetitions between nanoTime()s if diff=nanoTime cost or only slightly above.
//				do {
					start = System.nanoTime();
	
//					for(int j = 0; j < numberOfRepetitions; j++) {
						// call the method to measure
						measurable.callForMeasuring();
//					}
					
					// take the time
					stop = System.nanoTime();
					diff = stop - start;
//					diff = Math.round(((double)diff)/numberOfRepetitions);
				//MK} while (diff < 2*nanoTimeCost);
				measurements.add(diff);
			}
		}
		
		return measurements;
	}
	
	private void measureAllClasses() {
		List<String> methods = new ArrayList<String>();
		methods.add(this.testMethodSignature);
		methodnames.put(this.testClassName, methods);
		String className;
		for (Iterator<String> iter = methodnames.keySet().iterator(); iter.hasNext();) {
			className =  iter.next();
			this.measureOneClass(className, methodnames.get(className));
		}
	}

	@SuppressWarnings("deprecation")
	private void measureDurationOfInstrumentation_dynamic() {
		// measure the time the instrumentation takes in the "dynamic" case
		MeasurableInstrumentationCostsForMethod measurableInstrumDyn
			= new MeasurableInstrumentationCostsForMethod(this.testClassName, 
					new MethodDescriptor(this.testMethodSignature), false);
		measurableInstrumDyn.setUseHighRegisters(false);//duplicate...
		this.instrumentationResults_dynamic = new ArrayList<Long>();
		this.instrumentationResults_dynamic = this.measure(measurableInstrumDyn, numberOfMeasurements);
	}

	@SuppressWarnings("deprecation")
	private void measureDurationOfInstrumentation_high() {
		// measure the time the instrumentation takes in the "high" case
		MeasurableInstrumentationCostsForMethod measurableInstrumHigh
			= new MeasurableInstrumentationCostsForMethod(this.testClassName, 
					new MethodDescriptor(this.testMethodSignature), true);
		measurableInstrumHigh.setUseHighRegisters(true);//duplicate..
		this.instrumentationResults_high = new ArrayList<Long>();
		this.instrumentationResults_high = this.measure(measurableInstrumHigh, numberOfMeasurements);
	}

	@SuppressWarnings("deprecation")
	private void measureDurationOfInstrumentedMethods_dynamic() {
		MeasurableCostsForMethodRun measurableRun
			= new MeasurableCostsForMethodRun(this.testClassName, 
					new MethodDescriptor(this.testMethodSignature), INSTRUMENTATION_NONE);
		// measure the time it takes to run "dynamically" instrumented methods:
		measurableRun.setInstrumentationMode(INSTRUMENTATION_INSTRUMENT_AND_CALL|INSTRUMENTATION_NO_HIGH_REGISTERS);
		this.callCostInstrumResults_dynamic = new ArrayList<Long>();
		this.callCostInstrumResults_dynamic = this.measure(measurableRun, numberOfMeasurements);
	}

	@SuppressWarnings("deprecation")
	private void measureDurationOfInstrumentedMethods_dynamic(MeasurableCostsForMethodRun measurableRun) {
		// measure the time it takes to run "dynamically" instrumented methods:
		measurableRun.setInstrumentationMode(INSTRUMENTATION_INSTRUMENT_AND_CALL|INSTRUMENTATION_NO_HIGH_REGISTERS);
		this.callCostInstrumResults_dynamic = new ArrayList<Long>();
		this.callCostInstrumResults_dynamic = this.measure(measurableRun, numberOfMeasurements);
	}

	@SuppressWarnings("deprecation")
	private void measureDurationOfInstrumentedMethods_high() {
		// measure the time it takes to run "high-ly" instrumented methods:
		MeasurableCostsForMethodRun measurableRun
			= new MeasurableCostsForMethodRun(this.testClassName, 
					new MethodDescriptor(this.testMethodSignature), INSTRUMENTATION_NONE);
		measurableRun.setInstrumentationMode(INSTRUMENTATION_INSTRUMENT_AND_CALL|INSTRUMENTATION_USE_HIGH_REGISTERS);
		this.callCostInstrumResults_high = new ArrayList<Long>();
		this.callCostInstrumResults_high = this.measure(measurableRun, numberOfMeasurements);
	}

	@SuppressWarnings("deprecation")
	private void measureDurationOfInstrumentedMethods_high(MeasurableCostsForMethodRun measurableRun) {
		// measure the time it takes to run "high-ly" instrumented methods:
		measurableRun.setInstrumentationMode(INSTRUMENTATION_INSTRUMENT_AND_CALL|INSTRUMENTATION_USE_HIGH_REGISTERS);
		this.callCostInstrumResults_high = new ArrayList<Long>();
		this.callCostInstrumResults_high = this.measure(measurableRun, numberOfMeasurements);
	}

	@SuppressWarnings("deprecation")
	private MeasurableCostsForMethodRun measureDurationOfUninstrumentedMethod() {
		// measure the time it takes to run non-instrumented methods:
		MeasurableCostsForMethodRun measurableRun
			= new MeasurableCostsForMethodRun(this.testClassName, 
					new MethodDescriptor(this.testMethodSignature), INSTRUMENTATION_NONE);
		this.callCostNoInstrumResults = new ArrayList<Long>();
		this.callCostNoInstrumResults = this.measure(measurableRun, numberOfMeasurements);
		return measurableRun;
	}
	
	
	/**
	 * Performs a set of measurements and evaluations on the instrumentation.
	 * //MK TODO rewrite to evaluate parameters...
	 */
	@SuppressWarnings("deprecation")
	private void measureOneClass(String className, List<String> classMethods) {
		//MK TODO parameters have been ignored so far............
		
		MeasurableCostsForMethodRun measurableRun = measureDurationOfUninstrumentedMethod();

		measureDurationOfInstrumentation_dynamic();
		measureDurationOfInstrumentedMethods_dynamic(measurableRun);
		
		measureDurationOfInstrumentation_high();
		measureDurationOfInstrumentedMethods_high(measurableRun);
		
		if(1==0){//TODO
			measureDurationOfInstrumentation_dynamic();
			measureDurationOfInstrumentedMethods_dynamic();
			measureDurationOfInstrumentation_high();
			measureDurationOfInstrumentedMethods_high();
			measureDurationOfUninstrumentedMethod();
		}
		

//		eval.evaluateMeasurement("Method call (not instrumented)", callCostNoInstrumResults, false);
//		eval.evaluateMeasurement("Instrumentation (dyn. registers)",    instrumentationResults_dynamic, false);
//		eval.evaluateMeasurement("Method call (instr. dyn. registers)", callCostInstrumResults_dynamic, false);
//		eval.evaluateMeasurement("Instrumentation (high registers)",    instrumentationResults_high, false);
//		eval.evaluateMeasurement("Method call (instr. high registers)", callCostInstrumResults_high, false);
//
//		Collections.sort(callCostNoInstrumResults);
//		Collections.sort(instrumentationResults_dynamic);
//		Collections.sort(callCostInstrumResults_dynamic);
//		Collections.sort(instrumentationResults_high);
//		Collections.sort(callCostInstrumResults_high);
//		
//		List<Long> callCostNoInstrumResultsTruncated   = callCostNoInstrumResults.subList  (0, new Double(0.75D*callCostNoInstrumResults.size()).intValue());
//		List<Long> instrumentationResultsTruncated_dynamic  = instrumentationResults_dynamic.subList (0, new Double(0.75D*instrumentationResults_dynamic.size()).intValue());
//		List<Long> callCostInstrumResultsTruncated_dynamic  = callCostInstrumResults_dynamic.subList (0, new Double(0.75D*callCostInstrumResults_dynamic.size()).intValue());
//		List<Long> instrumentationResultsTruncated_high     = instrumentationResults_high.subList(0, new Double(0.75D*instrumentationResults_high.size()).intValue());
//		List<Long> callCostInstrumResultsTruncated_high     = callCostInstrumResults_high.subList(0, new Double(0.75D*callCostInstrumResults_high.size()).intValue());
//
//		System.out.println("=======================================================");
//		
//		eval.evaluateMeasurement("TRUNCATED Method call (not instrumented)", callCostNoInstrumResultsTruncated, false);
//		eval.evaluateMeasurement("TRUNCATED Instrumentation (dyn. registers)", instrumentationResultsTruncated_dynamic, false);
//		eval.evaluateMeasurement("TRUNCATED Method call (instr. dyn. registers)", callCostInstrumResultsTruncated_dynamic, false);
//		eval.evaluateMeasurement("TRUNCATED Instrumentation (high registers)", instrumentationResultsTruncated_high, false);
//		eval.evaluateMeasurement("TRUNCATED Method call (instr. high registers)", callCostInstrumResultsTruncated_high, false);
	}
}
