package de.uka.ipd.sdq.TimerMeter;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.TimerMeter.utils.CommonUtilities;
import de.uka.ipd.sdq.TimerMeter.utils.TimerCharacterisation;
import de.uka.ipd.sdq.TimerMeter.utils.StatisticalDescription;

/**
 * This class needs Java 5 or later to work, as it uses generics and the method
 * <code>java.lang.System.nanoTime()</code>.
 * 
 * This class contains common utility methods that are needed by subclasses.
 * Subclasses are created to analyse a specific timer method. They must
 * overwrite the <code>obtainMeasurement</code> method (in this class,
 * <code>nanoTime</code> is used for demonstration). Then, the
 * <code>computeResolution</code> method of the subclasses should be called.
 * Its execution can be configured by running it with the -help command line
 * flag.
 * 
 * The principle behind the resolution computation is the following: between two
 * timer calls, a <code>for</code> loop is inserted. A measurement consists of
 * executing the loop with a fixed iteration number. A suite of measurements
 * must be performed in a way that the time needed to execute the loop reaches
 * from well below timer method resolution to well above a multiple of that
 * resolution.
 * 
 * In the implementation, the number of loop iterations increases from 0 to
 * <code>numberOfIterationIncreaseSteps</code>. To enhance the representability of the
 * approach and to account for outliers, for each iteration number,
 * <code>numberOfMeasurements</code> measurements are executed.
 * 
 * The overall results (<code>numberOfMeasurements</code>
 * *<code>numberOfIterationIncreaseSteps</code>
 * values) are then sorted in ascending order. To ensure that outliers (due to
 * garbage collection etc.) do not distort the results, we remove 
 * the upper ~25% from the sorted list ("quartiles").
 * 
 * The sorted, cleaned list is partitioned into clusters using
 * <code>clusterFormationThresholdDistance</code> for deciding whether a list element belongs to the
 * last cluster or creates a new cluster (the clusterFormationThresholdDistance can be changed using
 * command line parameters). Finally, the resolution is computed as the average
 * of cluster distances, whereby the cluster's smallest element is chosen as the
 * cluster center for computing the cluster distance (from our experience, this
 * works well as the differences between cluster elements are usually 0 or 1
 * [with the default clusterFormationThresholdDistance of 50] and are most likely due to rounding inside
 * the timer method implementation.
 * 
 * @author Michael Kuperberg (mkuper@ipd.uka.de), 
 * Chair for Software Design and Quality (SDQ), 
 * Institute for Program Structures and Data Organisation (IPD),
 * Faculty of Informatics, University of Karlsruhe, Germany
 * http://sdq.ipd.uka.de
 *
 */
public abstract class AbstractTimerMeter {

	/**
	 * Measurements that are less than this clusterFormationThresholdDistance apart are combined into
	 * one cluster, whereby the cluster median is taken to compute the timer
	 * method resolution. 
	 * <b>This field should be overridden in subclasses.</b>
	 */
	protected static final int DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE = 2;

	/**
	 * Default width of steps by which the number of 'for loop' iterations 
	 * is increased. For further details, see class description.
	 * <b>This field should be overridden in subclasses.</b>
	 */
	protected static final int DEFAULT_ITERATION_INCREASE_STEP_WIDTH = 2;

	/**
	 * TODO use and document
	 */
	protected static final double DEFAULT_LOWER_PERCENTAGE_TO_CUT = 0D; //TODO

	/**
	 * Default number of steps in which the number of 'for loop' iterations 
	 * is increased. Each step has a width that is specified separately. 
	 * For further details, see class description.
	 * <b>This field should be overridden in subclasses.</b>
	 */
	protected static final int DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS=100;
	
	/**
	 * Specifies how many measurements are performed for each number of 
	 * 'for loop' iterations. This constant has proved suitable for 
	 * <code>nanoTime</code> on our development platform. 
	 * For further details, see class description. <b>This field should be
	 * overridden in subclasses.</b>
	 */
	protected static final int DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP = 300;

	/**
	 * The number of times the entire process is repeated (entire process := 
	 * DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS times increasing the 
	 * code section inserted between two timer invocation, with increase size 
	 * of DEFAULT_ITERATION_INCREASE_STEP_WIDTH) 
	 */
	protected static final int DEFAULT_NUMBER_OF_PROCESS_REPETITIONS = 10;

	/**
	 * TODO
	 */
	protected static final int DEFAULT_NUMBER_OF_WARMUP_TIMER_INVOCATIONS = 1/*0000*/;

	/**
	 * TODO use and document
	 */
	protected static final double DEFAULT_UPPER_PERCENTAGE_TO_CUT = 0D; //TODO

	/**
	 * When we cannot use a logging framework, this field simplifies coding 
	 * using <code>System.err</code> :-)
	 */
//	 * @deprecated
	protected static PrintStream e = System.err;

	/**
	 * This helper field is used to invoke parameterless timer methods 
	 * using Java reflection API  
	 */
	protected static final Object[] immutableEmptyParameters = new Object[]{};

	/**
	 * When we cannot use a logging framework, this field simplifies coding 
	 * using <code>System.out</code> :-)
	 */
//	 * @deprecated
	protected static PrintStream o = System.out;
	
	/**
	 * This dummy variable is used for warmup; it is intentionally global 
	 * because of JIT / dead code elimination prevention.
	 */
	protected static long publicDummy = 0L;
	
	/**
	 * TODO
	 */
	protected TimerCharacterisation characterisation;

	/** 
	 * See class description. 
	 * TODO add getter and non-overriding setter
	 */
	protected int clusterFormationThresholdDistance;
	
	/**
	 * not private because needed in <code>obtainMeasurementsUsingDirectInvocation</code>
	 */
	protected int currentUpperLoopSizeBound=0;

	/**
	 * TODO
	 */
	protected Double externallyDeterminedTimerFrequency = -1D;

	/**
	 * TODO
	 */
	protected Double externallyDeterminedTimerInvocationCost = -1D;

	/**
	 * Vendor-specified
	 */
	protected boolean hasOfficialTimerMethodAccuracy;

	/**
	 * Vendor-specified
	 */
	protected boolean hasOfficialTimerMethodInvocationCost;
	
	/**
	 * If <code>timerMethodIsStatic</code>==false, then 
	 * <code>invokableTimerTarget</code> must be properly initialised.
	 */
	protected Method invokableTimerMethod = null;
	
	/**
	 * Can be null if <code>timerMethodIsStatic</code> is true - 
	 * otherwise, must be initialised properly before 
	 * <code>invokableTimerMethod</code> is invoked.
	 */
	protected Object invokableTimerTarget = null;

	/**
	 * TODO add getter and non-overriding setter
	 */
	protected int iterationIncreaseStepWidth;

	/**
	 * The logger instance (log4j) as a supplement to <code>e</code> and <code>o</code>.
	 * */
	private Logger logger; //TODO make it protected? Logger name changeable in subclasses? --> multiple logging problem
	
	/**
	 * TODO
	 * protected because it must be set and read in subclasses' that override
	 * the <code>obtainMeasurementsUsingDirectInvocation</code> method
	 */
	protected long methodReturnAtMeasurementFinish = 0L;
	
	/**
	 * TODO
	 * protected because it must be set and read in subclasses' that override
	 * the <code>obtainMeasurementsUsingDirectInvocation</code> method
	 */
	protected long methodReturnAtMeasurementStart = 0L;

	/**
	 * Distance between timer method results separated by for loop (see class 
	 * description and source code, esp. obtainMeasurements method, for more details).
	 * protected because it must be set and read in subclasses' that override
	 * the <code>obtainMeasurementsUsingDirectInvocation</code> method
	 */
	protected long methodReturnDifference = 0L;
	
	/**
	 * Actual maximum number of for loop iterations that are executed between
	 * two <code>nanoTime</code> invocations (cf. class description)
	 * TODO add getter and non-overriding setter
	 */
	protected int numberOfIterationIncreaseSteps;
	
	/** 
	 * See class description. 
	 * TODO add getter and non-overriding setter
	 */
	protected int numberOfMeasurements;
	
	/**
	 * Number of times the entire process is repeated.
	 * TODO add getter and non-overriding setter
	 */
	protected int numberOfProcessRepetitions;

	/**
	 * TODO add getter and non-overriding setter
	 */
	protected int numberOfWarmupTimerInvocations;

	/**
	 * Frequency as it can be retrieved by an "official" method in the same API
	 * as the considered timer method.
	 */
	protected Double officialTimerFrequency;

	/**
	 * Vendor-specified
	 */
	protected Double officialTimerMethodAccuracy;

	/**
	 * Vendor-specified
	 */
	protected Double officialTimerMethodInvocationCost;

	/**
	 * TODO 
	 */
	protected String timerClassName;

	/**
	 * Overwrite this in subclasses if needed - then, also provide 
	 * an <code>timerMethodIsStatic</code>
	 */
	protected boolean timerMethodIsStatic;
	
	/**
	 * TODO document assumption: parameterless and no class/package name! 
	 *      --> no parentheses: (){}[]<> and no "."s and ";" s
	 */
	protected String timerMethodName;
	
	/**
	 * TODO: replace through enum
	 */
	protected String timerMethodUnit;

	/**
	 * TODO
	 */
	protected final String warningOnNegativeDiff = "Difference " 
		+"of time measurements smaller than 0! " 
		+"This points to inconsitencies in "+timerMethodName+" implementation";

	/** The constructor should be overwritten in subclasses.
	 * 
	 */
	public AbstractTimerMeter() {
		super();
		logger = Logger.getLogger(this.getClass().getCanonicalName()+"_"+hashCode());
		BasicConfigurator.configure();
//		DEFAULT_ITERATION_INCREASE_STEP_WIDTH = NANOTIME_DEFAULT_ITERATION_INCREASE_STEP_WIDTH;
//		DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS = NANOTIME_DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS;
//		DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP = NANOTIME_DEFAULT_NUMBER_OF_MEASUREMENTS;
//		numberOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP;
//		DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE = NANOTIME_DEFAULT_THRESHOLD;
	}

	/**
	 * TODO engineer for performance: sofort eindimensionales Array benutzen, mit offsets arbeiten --> ein Duplikatsvorgang entfällt
	 * @param timerMeterMeasurements
	 * @param logValues
	 * @return
	 */
	protected final TimerCharacterisation computeTimerCharacterization(
			long[][] timerMeterMeasurements, 
			boolean logValues) {
		
		
		//number of measurements in one process
		int numberOfProcesses = timerMeterMeasurements.length;
		int processLength = timerMeterMeasurements[0].length;
		long[] allMeasurementsAppendedAndSorted = new long[numberOfProcesses*processLength];//TODO add security checks
		long[] invocationCostMeasurements = new long[numberOfProcesses*numberOfMeasurements];
		List<StatisticalDescription> processCharacterisations = new ArrayList<StatisticalDescription>();
		SortedMap<Integer, SortedMap<Long,Integer>> histogramElementsByProcessAcrossAllProcesses
			= new TreeMap<Integer, SortedMap<Long,Integer>>();
		
		for(int i=0; i<numberOfProcesses; i++){
			// copy the invocation cost measurements in an own flat structure
			System.arraycopy(timerMeterMeasurements[i], 0, invocationCostMeasurements, i*numberOfMeasurements, numberOfMeasurements);
			
			// copy all measurements in a flat structure
			System.arraycopy(timerMeterMeasurements[i], 0, allMeasurementsAppendedAndSorted, i*processLength, processLength);
			
			processCharacterisations.add(CommonUtilities.computeCharacteristics_detailed(timerMeterMeasurements[i], logValues));
			histogramElementsByProcessAcrossAllProcesses.put(i, CommonUtilities.computeHistogram(timerMeterMeasurements[i]));
		}
		
		Arrays.sort(allMeasurementsAppendedAndSorted);//TODO document this
		SortedMap<Long, Integer> allMeasurementsHistogram = CommonUtilities.computeHistogram(allMeasurementsAppendedAndSorted);
		StatisticalDescription allMeasurementsCharacterisation = CommonUtilities.computeCharacteristics_detailed(allMeasurementsAppendedAndSorted, logValues);
		
		//getting histogram elements by value (accross all processes
		
//		Integer currInputKey;
//		SortedMap<Long,Integer> currInputValue;
//		Long currInputValue_currInternalKey;
//		Integer currInputValue_currInternalValue;
//		
////		Long currOutputKey;//equal to currInputValue_currInternalKey
//		SortedMap<Integer,Integer> currOutputValue;
//		Integer currOutputValue_currInternalKey; //equal to currInputKey
//		Integer currOutputValue_currInternalValue; //equal to currInputValue_currInternalValue
		
		SortedMap<Long, SortedMap<Integer,Integer>> histogramElementsByValueAcrossAllProcesses
			= new TreeMap<Long, SortedMap<Integer,Integer>>();
		CommonUtilities.rearrangeMeasurementsByValue(histogramElementsByProcessAcrossAllProcesses,
				histogramElementsByValueAcrossAllProcesses);

		Arrays.sort(invocationCostMeasurements);//überflüssig...?
		
		TimerCharacterisation tc = new TimerCharacterisation();
		tc.setAllInitialMeasurements(timerMeterMeasurements);//sorted?
		tc.setAllMeasurementsAppendedAndSorted(allMeasurementsAppendedAndSorted);//sorted?
		tc.setAllMeasurementsCharacterisation(allMeasurementsCharacterisation);
		tc.setAllMeasurementsHistogram(allMeasurementsHistogram);
		tc.setHistogramElementsByProcess(histogramElementsByProcessAcrossAllProcesses);
		tc.setHistogramElementsByValue(histogramElementsByValueAcrossAllProcesses);
		tc.setProcessCharacterisations(processCharacterisations);
		tc.setClusters(
				CommonUtilities.clusterTimerValuesFromHistogram(
						allMeasurementsHistogram, 
						this.clusterFormationThresholdDistance)); //TODO evaluate clusters

		tc.setAccuracy(CommonUtilities.computeAccuracyFromClusters(tc.getClusters(), false));
		tc.setInvocationCost(CommonUtilities.computeCharacteristics_detailed(invocationCostMeasurements, false));

		return tc;
	}
	
	/**
	 * @deprecated for bytecode study purposes
	 */
	@SuppressWarnings("unused")
	private final void dummyToRemove(){
		long[] results = new long[300];
		int i=0;
		while(i<300){
		  long time1=System.nanoTime();  
		  long time2=System.nanoTime(); 
		  results[i] = time2-time1;
		  i++;
		}
		Arrays.sort(results);
	}
	
//	/**
//	 * TODO
//	 * @deprecated because should not be used anymore
//	 */
//	protected List<Long> originalMeasurements = new ArrayList<Long>();

	/**
	 * This getter uses obtainMeasurementsUsingDirectInvocation, i.e. neither
	 * reflection nor timerMethodToOverride 
	 * @return
	 */
	public TimerCharacterisation getCharacterisation() {
		if(characterisation==null){
			characterisation = this.computeTimerCharacterization(this.obtainMeasurementsUsingDirectInvocation(), false);
		}
		return characterisation;
	}

	public final double getExternallyDeterminedTimerFrequency() {
		return externallyDeterminedTimerFrequency;
	}

	public final double getExternallyDeterminedTimerInvocationCost() {
		return externallyDeterminedTimerInvocationCost;
	}

	public final Method getInvokableTimerMethod() {
		return invokableTimerMethod;
	}

	public final Object getInvokableTimerTarget() {
		return invokableTimerTarget;
	}

	public double getOfficialTimerMethodAccuracy() {
		return officialTimerMethodAccuracy;
	}
	
	public double getOfficialTimerMethodInvocationCost() {
		return officialTimerMethodInvocationCost;
	}
	
	/**
	 * TODO modify to accept parameterless constructors as well...
	 * This class is non-final because it may need to be overriden where 
	 * the timer "static instance" cannot be specified directly, but 
	 * must be obtained using a factory method or similar means.
	 * @return
	 */
	protected boolean initialiseInvokableTimerMethod() {
		if(timerMethodName==null || timerMethodName.isEmpty()){
			logger.error("Timer method name is null or empty - " +
					"invokable timer method cannot be initialised");
			return false;
		}
		if(timerMethodName.contains(".")
				|| timerMethodName.contains("(")
				|| timerMethodName.contains(")")){
			logger.error("Timer method contains \".\" or \"(\" or \")\" - " +
					"I won't bother to parse it, please specify a parameterless, " +
					"classless method name in this field! Therefore, " +
					"invokable timer method cannot be initialised");
			return false;
		}
		if(timerClassName==null || timerClassName.isEmpty()){
			logger.error("Timer class name is null or empty - " +
			"invokable timer method cannot be initialised");
			return false;
		}else{
//			if(timerMethodName==null || timerMethodName.isEmpty()){
//				logger.error("Timer method name is null or empty - " +
//						"invokable timer method cannot be initialised");
//				return false;
//			}else{
				try {
					Class<?> timerClass = Class.forName(timerClassName);
					Method[] allTimerClassMethods = timerClass.getMethods();
					Method currMethod;
					List<Method> preciseCandidates = new ArrayList<Method>(); //exactly the same name, but possibly with parameters (!)
					List<Method> potentialCandidates = new ArrayList<Method>(); //the name starts with the <code>timerMethodName</code>
					for (int i = 0; i < allTimerClassMethods.length; i++) {
						currMethod = allTimerClassMethods[i];
						if(currMethod.getName().equals(timerMethodName)){
							preciseCandidates.add(currMethod);
							if(currMethod.getParameterTypes().length==0
									&& this.invokableTimerMethod==null){
								this.invokableTimerMethod = currMethod;
							}
						}else if(currMethod.getName().startsWith(timerMethodName)){
							potentialCandidates.add(currMethod);
						}
					}
				} catch (ClassNotFoundException e) {
					logger.error("Timer class could not be initialised " +
							"(used class name: "+timerClassName+")");
					e.printStackTrace();
				}
//			}
		}
		
		if(!timerMethodIsStatic){ //TODO test this
			try {
				Class<?> timerClass = Class.forName(timerClassName);
				Constructor<?>[] constructors = timerClass.getConstructors();
				if(constructors==null || constructors.length==0){
					return false;
				}
				Constructor<?> currConstructor;
				Constructor<?> parameterlessConstructor = null;
				int i = 0;
				while(i < constructors.length) {
					currConstructor = constructors[i];
					int mods = currConstructor.getModifiers();
					if(Modifier.isAbstract(mods)
							|| Modifier.isPrivate(mods)){
						return false; //TODO document
					}
					if(currConstructor.getParameterTypes().length==0){
						parameterlessConstructor = currConstructor;
						i=constructors.length;
					}else{
						i++;
					}
				}
				invokableTimerTarget = parameterlessConstructor.newInstance(new Object[]{});
				logger.debug("Creating an invocation target succeeded");
			} catch (Exception e) {
				logger.error("Creating an invocation target failed");
				e.printStackTrace();
			}
		}else{
			logger.debug("Timer method is static, no invocation target is generated");
		}
		
		if(invokableTimerMethod==null){
			return false;
		}else{
			if(timerMethodIsStatic){
				try {
					logger.debug("Testwise direct timer invocation: "+invokableTimerMethod.invoke(null, new Object[]{}));
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					logger.debug("Testwise timer invocation through predefined invoker: "+timerMethodReflectiveInvoker());
				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
			} else {
				if(invokableTimerTarget!=null){
					try {
						logger.debug("Testwise direct timer invocation: "+invokableTimerMethod.invoke(invokableTimerTarget, new Object[]{}));
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						logger.debug("Testwise timer invocation through predefined invoker: "+timerMethodReflectiveInvoker());
					} catch (Exception e) {
						e.printStackTrace();
					}
					return true;
				}else{
					return false;
				}
			}
		}
	}

	/** THIS METHOD MUST BE OVERRIDDEN IN SUBCLASSES. Implementation is 
	 * provided here as an example. Use it and replace the <code>nanoTime</code>. 
	 * 
	 * After "warming up" the timer method <code>numberOfWarmupTimerInvocations</code> times, this
	 * method measures the duration of a 'for' loop. The measurement is repeated
	 * <code>numberOfMeasurements</code> times for each loop iteration number from
	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
	 * 
	 * @return <code>List</code> of measurements
	 */
	protected abstract long[][] obtainMeasurementsUsingDirectInvocation();
//	{
//		int totalNumberOfMeasurementsInOneProcessRun = (this.numberOfIterationIncreaseSteps+1)*this.numberOfMeasurements;
//		o.println("Creating and filling a data structure occupying at least 2*"+
//				this.numberOfProcessRepetitions+"*"+
//				(this.numberOfIterationIncreaseSteps+1)+"*"+
//				this.numberOfMeasurements+"="+
//				(2*this.numberOfProcessRepetitions*(this.numberOfIterationIncreaseSteps+1)*this.numberOfMeasurements) +
//				" bytes of DATA memory, not counting the linking structure...");
//		
//		//1. initialise data structure fully
//		long[][] allResults = new long[this.numberOfProcessRepetitions][totalNumberOfMeasurementsInOneProcessRun];
//		for (int i=0; i<this.numberOfProcessRepetitions; i++) {
//			for (int j=0; j<totalNumberOfMeasurementsInOneProcessRun; j++) {
//				allResults[i][j]=0L;
//			}
//		}
//
//		for (int w = 0; w < this.numberOfWarmupTimerInvocations; w++) {
//			publicDummy += System.nanoTime();
//		}
//		o.println("DEBUG: Warmup finished (" + 
//				this.numberOfWarmupTimerInvocations + 
//				" calls to "+timerMethodName+", " +
//				"publicDummy is " + publicDummy+").\n");
//
//		for(int p=0; p<this.numberOfProcessRepetitions; p++){
//			o.println("Process "+p+" of "+this.numberOfProcessRepetitions);
//			// here: no work between timer invocations, i.e. no "for loop iterations" - 
//			// intentionally not part of the second loop below, but included in 
//			//measurements for obtaining invocation costs
//			for (int i = 0; i < this.numberOfMeasurements; i++) {
////				System.gc();// TODO manualGC...
//				this.timerValueAtStart = System.nanoTime();
//				this.timerValueAtFinish = System.nanoTime();
//				this.timerValuesDifference = this.timerValueAtFinish - this.timerValueAtStart;
//	
//				if (this.timerValuesDifference < 0) {
//					o.println(warningOnNegativeDiff);
//				} else {
//					allResults[p][i]=this.timerValuesDifference;
//				}
//			}
//			int offsetIntoArray = this.numberOfMeasurements-1;
//			
//			// 0 to (numberOfIterationIncreaseSteps-1) outer "for loop iterations"
//			for (int l = 0; l < this.numberOfIterationIncreaseSteps; l++) {//TODO check this
//				this.currentUpperLoopSizeBound = this.currentUpperLoopSizeBound + this.iterationIncreaseStepWidth;
//				// 0 to (numberOfMeasurements-1) inner "for loop iterations"
//				for (int m = 0; m < this.numberOfMeasurements; m++) {
//					offsetIntoArray++; //pointing to the place to store the diff
//					this.timerValueAtStart = System.nanoTime();
//					for (int a = 0; a < this.currentUpperLoopSizeBound ; a++) {
//	//					increased++;//TODO --> align with paper
//					}
//					this.timerValueAtFinish = System.nanoTime();
//					this.timerValuesDifference = this.timerValueAtFinish - this.timerValueAtStart;
//	
//					if (this.timerValuesDifference < 0) {
//						o.println(warningOnNegativeDiff);
//					} else {
//						allResults[p][offsetIntoArray]=this.timerValuesDifference;
//					}
//	//				o.println("DEBUG: currentUpperLoopSizeBound "+currentUpperLoopSizeBound+"->methodReturnDifference="+methodReturnDifference);
//				}
//			}
//		}
//
//		return allResults;
//	};
	
	/** Instead of overriding this method in subclasses, just override the
	 * <code>myTimerMethod</code> in those subclasses, then call this method. 
	 * The implementation that is provided here is final and cannot be overriden.
	 * By default, it uses the timer method <code>java.lang.System.nanoTime()</code>
	 *  
	 *  
	 * After "warming up" the timer method <code>numberOfWarmupTimerInvocations</code> times, this
	 * method measures the duration of a 'for' loop. The measurement is repeated
	 * <code>numberOfMeasurements</code> times for each loop iteration number from
	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
	 * 
	 * @return <code>List</code> of measurements
	 */
	protected final long[][] obtainMeasurementsUsingOverridenTimerMethod() {
		int totalNumberOfMeasurementsInOneProcessRun = (numberOfIterationIncreaseSteps+1)*numberOfMeasurements;
		o.println("Creating and filling a data structure occupying at least 2*"+
				numberOfProcessRepetitions+"*"+
				(numberOfIterationIncreaseSteps+1)+"*"+
				numberOfMeasurements+"="+
				(2*numberOfProcessRepetitions*(numberOfIterationIncreaseSteps+1)*numberOfMeasurements) +
				" bytes of DATA memory, not counting the linking structure...");
		
		//1. initialise data structure fully
		long[][] allResults = new long[numberOfProcessRepetitions][totalNumberOfMeasurementsInOneProcessRun];
		for (int i=0; i<numberOfProcessRepetitions; i++) {
			for (int j=0; j<totalNumberOfMeasurementsInOneProcessRun; j++) {
				allResults[i][j]=0L;
			}
		}

		for (int w = 0; w < numberOfWarmupTimerInvocations; w++) {
			publicDummy += timerMethodToOverride();
		}
		o.println("DEBUG: Warmup finished (" + numberOfWarmupTimerInvocations + 
				" calls to "+timerMethodName+", " +
				"publicDummy is " + publicDummy+").\n");

		for(int p=0; p<numberOfProcessRepetitions; p++){
			o.println("Process "+p+" of "+numberOfProcessRepetitions);
			// 0 "for loop iterations" - intentionally not part of the loop below
			for (int i = 0; i < numberOfMeasurements; i++) {
//				System.gc();// TODO manualGC...
				methodReturnAtMeasurementStart = timerMethodToOverride();
				methodReturnAtMeasurementFinish = timerMethodToOverride();
				methodReturnDifference = methodReturnAtMeasurementFinish - methodReturnAtMeasurementStart;
	
				if (methodReturnDifference < 0) {
					o.println(warningOnNegativeDiff);
				} else {
					allResults[p][i]=methodReturnDifference;
				}
			}
			int offsetIntoArray = numberOfMeasurements-1;
			
			// 0 to (numberOfIterationIncreaseSteps-1) outer "for loop iterations"
			for (int l = 0; l < numberOfIterationIncreaseSteps; l++) {//TODO check this
				currentUpperLoopSizeBound = currentUpperLoopSizeBound + iterationIncreaseStepWidth;
				// 0 to (numberOfMeasurements-1) inner "for loop iterations"
				for (int m = 0; m < numberOfMeasurements; m++) {
					offsetIntoArray++; //pointing to the place to store the diff
					methodReturnAtMeasurementStart = timerMethodToOverride();
					for (int a = 0; a < currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					methodReturnAtMeasurementFinish = timerMethodToOverride();
					methodReturnDifference = methodReturnAtMeasurementFinish - methodReturnAtMeasurementStart;
	
					if (methodReturnDifference < 0) {
						o.println(warningOnNegativeDiff);
					} else {
						allResults[p][offsetIntoArray]=methodReturnDifference;
					}
	//				o.println("DEBUG: currentUpperLoopSizeBound "+currentUpperLoopSizeBound+"->methodReturnDifference="+methodReturnDifference);
				}
			}
		}

		return allResults;
	}

	protected final long[][] obtainMeasurementsUsingReflection() 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		/*boolean isStatic = Modifier.isStatic(invokableTimerMethod.getModifiers());*/
		if(invokableTimerMethod==null /*|| !isStatic*/){
			logger.error("The invokable timer method is null"/*+" or non-static"*/+
					" - returning null data");
			return null;
		}
		try {
			Object tentativeResult = timerMethodReflectiveInvoker();
			if(!(tentativeResult instanceof Long)){//TODO überflüssig?
				logger.error("The reflection-invoked timer method does not " +
						"return a long --> exiting prematurely");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		int totalNumberOfMeasurementsInOneProcessRun = (numberOfIterationIncreaseSteps+1)*numberOfMeasurements;
		o.println("Creating and filling a data structure occupying at least 2*"+
				numberOfProcessRepetitions+"*"+
				(numberOfIterationIncreaseSteps+1)+"*"+
				numberOfMeasurements+"="+
				(2*numberOfProcessRepetitions*(numberOfIterationIncreaseSteps+1)*numberOfMeasurements) +
				" bytes of DATA memory, not counting the linking structure...");
		
		//1. initialise data structure fully
		long[][] allResults = new long[numberOfProcessRepetitions][totalNumberOfMeasurementsInOneProcessRun];
		for (int i=0; i<numberOfProcessRepetitions; i++) {
			for (int j=0; j<totalNumberOfMeasurementsInOneProcessRun; j++) {
				allResults[i][j]=0L;
			}
		}

		for (int w = 0; w < numberOfWarmupTimerInvocations; w++) {
			publicDummy += timerMethodReflectiveInvoker();
		}
		o.println("DEBUG: Warmup finished (" + numberOfWarmupTimerInvocations + 
				" calls to "+timerMethodName+", " +
				"publicDummy is " + publicDummy+").\n");

		for(int p=0; p<numberOfProcessRepetitions; p++){
			o.println("Process "+p+" of "+numberOfProcessRepetitions);
			// 0 "for loop iterations" - intentionally not part of the loop below
			for (int i = 0; i < numberOfMeasurements; i++) {
//				System.gc();// TODO manualGC...
				methodReturnAtMeasurementStart = timerMethodReflectiveInvoker();
				methodReturnAtMeasurementFinish = timerMethodReflectiveInvoker();
				methodReturnDifference = methodReturnAtMeasurementFinish - methodReturnAtMeasurementStart;
	
				if (methodReturnDifference < 0) {
					o.println(warningOnNegativeDiff);
				} else {
					allResults[p][i]=methodReturnDifference;
				}
			}
			int offsetIntoArray = numberOfMeasurements-1;
			
			// 0 to (numberOfIterationIncreaseSteps-1) outer "for loop iterations"
			for (int l = 0; l < numberOfIterationIncreaseSteps; l++) {//TODO check this
				currentUpperLoopSizeBound = currentUpperLoopSizeBound + iterationIncreaseStepWidth;
				// 0 to (numberOfMeasurements-1) inner "for loop iterations"
				for (int m = 0; m < numberOfMeasurements; m++) {
					offsetIntoArray++; //pointing to the place to store the diff
					methodReturnAtMeasurementStart = timerMethodReflectiveInvoker();
					for (int a = 0; a < currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					methodReturnAtMeasurementFinish = timerMethodReflectiveInvoker();
					methodReturnDifference = methodReturnAtMeasurementFinish - methodReturnAtMeasurementStart;
	
					if (methodReturnDifference < 0) {
						o.println(warningOnNegativeDiff);
					} else {
						allResults[p][offsetIntoArray]=methodReturnDifference;
					}
	//				o.println("DEBUG: currentUpperLoopSizeBound "+currentUpperLoopSizeBound+"->methodReturnDifference="+methodReturnDifference);
				}
			}
		}

		return allResults;
	}
	
	/**
	 * See source code. TODO make it final?
	 * 
	 * @param args
	 * @return whether the parameters were parsed successfully
	 */
	protected final boolean parseArguments(String[] args) {

		boolean usagePrinted = false;
		boolean parsedSuccessfully = true;
		if (args == null || args.length != 6) {
			o.println("INFO: "+this.getClass().getName()
							+ " received no parameters "
							+ "or the wrong number of parameters (exactly "
							+ "6 parameters are required, see below). "
							+ "Executing with default values (see below)\n");
			this.printUsage();
			this.numberOfWarmupTimerInvocations = DEFAULT_NUMBER_OF_WARMUP_TIMER_INVOCATIONS;
			this.numberOfProcessRepetitions = DEFAULT_NUMBER_OF_PROCESS_REPETITIONS;
			this.numberOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP;
			this.iterationIncreaseStepWidth = DEFAULT_ITERATION_INCREASE_STEP_WIDTH;
			this.numberOfIterationIncreaseSteps = DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS;
			this.clusterFormationThresholdDistance = DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE;
			parsedSuccessfully = parsedSuccessfully & false;
		} else {
			try { //1.
				numberOfWarmupTimerInvocations = Integer.parseInt(args[0]);
			} catch (Exception e) {
				if (!usagePrinted) {
					printUsage();
					usagePrinted = true;
				}
				o.println("ERROR: number of warmup timer invocations " 
						+ "could not be parsed, taking "
						+ DEFAULT_NUMBER_OF_WARMUP_TIMER_INVOCATIONS
						+ " as default.");
				numberOfWarmupTimerInvocations = DEFAULT_NUMBER_OF_WARMUP_TIMER_INVOCATIONS;
				parsedSuccessfully = parsedSuccessfully & false;
			}
			
			try { //2.
				numberOfProcessRepetitions = Integer.parseInt(args[1]);
			} catch (Exception e) {
				if (!usagePrinted) {
					printUsage();
					usagePrinted = true;
				}
				o.println("ERROR: number of process repetitions "
						+ "could not be parsed, taking "
						+ DEFAULT_NUMBER_OF_PROCESS_REPETITIONS
						+ " as default.");
				numberOfProcessRepetitions = DEFAULT_NUMBER_OF_PROCESS_REPETITIONS;
				parsedSuccessfully = parsedSuccessfully & false;
			}
			
			try { //3. 
				numberOfMeasurements = Integer.parseInt(args[2]);
			} catch (Exception e) {
				if (!usagePrinted) {
					printUsage();
					usagePrinted = true;
				}
				o.println("ERROR: number of measurements "
						+ "could not be parsed, taking "
						+ DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP
						+ " as default.");
				numberOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP;
				parsedSuccessfully = parsedSuccessfully & false;
			}
			
			try { //4. 
				iterationIncreaseStepWidth = Integer.parseInt(args[3]);
			} catch (Exception e) {
				if (!usagePrinted) {
					printUsage();
					usagePrinted = true;
				}
				o.println("ERROR: iteration increase step width "
						+ "could not be parsed, taking "
						+ DEFAULT_ITERATION_INCREASE_STEP_WIDTH
						+ " as default.");
				iterationIncreaseStepWidth = DEFAULT_ITERATION_INCREASE_STEP_WIDTH;
				parsedSuccessfully = parsedSuccessfully & false;
			}
			
			try { //5. 
				numberOfIterationIncreaseSteps = Integer.parseInt(args[4]);
			} catch (Exception e) {
				if (!usagePrinted) {
					printUsage();
					usagePrinted = true;
				}
				o.println("ERROR: number of iteration number increase steps "
						+ "could not be parsed, taking "
						+ DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS
						+ " as default.");
				numberOfIterationIncreaseSteps = DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS;
				parsedSuccessfully = parsedSuccessfully & false;
			}
			
			try { //6. 
				clusterFormationThresholdDistance = Integer.parseInt(args[5]);
			} catch (Exception e) {
				if (!usagePrinted) {
					printUsage();
					usagePrinted = true;
				}
				o.println("ERROR: clusterFormationThresholdDistance "
						+ "could not be parsed, taking "
						+ DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE + 
						" as default.");
				clusterFormationThresholdDistance = DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE;
				parsedSuccessfully = parsedSuccessfully & false;
			}
		}
		return parsedSuccessfully;
	}

	/**
	 * Explains the possible command line parameters and shows the default values
	 */
	protected final void printUsage(){
		o.println("USAGE: " +
			"          EITHER specify no parameters to run with (displayed) defaults\n" +
			"          OR     specify all of the following 6 parameters in the precise order:\n" +
			"                 number of warmup timer invocations " +
			"as positive integer (default: "+DEFAULT_NUMBER_OF_WARMUP_TIMER_INVOCATIONS+")\n" +
			"                 number of process repetitions " +
			"as positive integer (default: "+DEFAULT_NUMBER_OF_PROCESS_REPETITIONS+")\n" +
			"                 number of measurements " +
			"as positive integer (default: "+DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP+")\n" +
			"                 increase step width " +
			"as positive integer (default: "+DEFAULT_ITERATION_INCREASE_STEP_WIDTH+")\n" +
			"                 number of iteration increase steps " +
			"as positive integer (default: "+DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS+")\n" +
			"                 default cluster formation threshold distance " +
			"as positive integer (default: "+DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE+")\n" +
			"                 example (from this class' defaults):    " +
			""+this.getClass().getName()+" "+
			DEFAULT_NUMBER_OF_WARMUP_TIMER_INVOCATIONS + " " +
			DEFAULT_NUMBER_OF_PROCESS_REPETITIONS + " " +
			DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP + " " +
			DEFAULT_ITERATION_INCREASE_STEP_WIDTH + " " +
			DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS + " " +
			DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE);//TODO
//		numberOfWarmupTimerInvocations = DEFAULT_NUMBER_OF_WARMUP_TIMER_INVOCATIONS;
//		numberOfProcessRepetitions = DEFAULT_NUMBER_OF_PROCESS_REPETITIONS;
//		numberOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP;
//		iterationIncreaseStepWidth = DEFAULT_ITERATION_INCREASE_STEP_WIDTH;
//		numberOfIterationIncreaseSteps = DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS;
//		clusterFormationThresholdDistance = DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE;
	}

	/**
	 * @param args
	 * @param tm
	 */
	protected final void run(String[] args) {
		this.parseArguments(args);//is needed to set the parameters
		this.initialiseInvokableTimerMethod();//TODO test: if run() is called on a subclass: what is the target of this method?
		System.out.println(this.getCharacterisation());
		System.out.println(this.computeTimerCharacterization(this.obtainMeasurementsUsingOverridenTimerMethod(), false));
		if(this.getInvokableTimerMethod()!=null){
			try{
				long[][] resultsFromReflection = this.obtainMeasurementsUsingReflection();
				System.out.println(this.computeTimerCharacterization(resultsFromReflection, false));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public final void setExternallyDeterminedTimerFrequency(
			double externallyDeterminedTimerFrequency) {
		if(this.externallyDeterminedTimerFrequency!=null 
				&& !this.externallyDeterminedTimerFrequency.equals(-1D)){
			logger.warn("Overwriting old frequency ("+
					this.externallyDeterminedTimerFrequency+") with " +
					externallyDeterminedTimerFrequency);
		}
		this.externallyDeterminedTimerFrequency = externallyDeterminedTimerFrequency;
	}
	
	public final void setExternallyDeterminedTimerInvocationCost(
			double externallyDeterminedTimerInvocationCost) {
		if(this.externallyDeterminedTimerInvocationCost!=null
				&& !this.externallyDeterminedTimerInvocationCost.equals(-1D)){
			logger.warn("Overwriting old invocation cost ("+
					this.externallyDeterminedTimerInvocationCost+") with " +
					externallyDeterminedTimerInvocationCost);
		}
		this.externallyDeterminedTimerInvocationCost = externallyDeterminedTimerInvocationCost;
	}
	
	public final void setOfficialTimerFrequency(
			double officialTimerFrequency) {
		if(this.officialTimerFrequency!=null 
				&& !this.officialTimerFrequency.equals(-1D)){
			logger.warn("Overwriting old official frequency ("+
					this.officialTimerFrequency+") with " +
					officialTimerFrequency);
		}
		this.officialTimerFrequency = officialTimerFrequency;
	}
	
	public void setOfficialTimerMethodAccuracy(double officialTimerMethodAccuracy) {
		this.officialTimerMethodAccuracy = officialTimerMethodAccuracy;
	}
	
	public void setOfficialTimerMethodInvocationCost(double officialTimerMethodInvocationCost) {
		this.officialTimerMethodInvocationCost = officialTimerMethodInvocationCost;
	}
	
	/**
	 * This timer method is called by the final method  
	 * <code>obtainMeasurementsUsingOverridenTimerMethod</code>. 
	 * This method should be overriden in subclasses; in this class, it calls
	 * <code>java.lang.System.nanoTime</code>.
	 * @return
	 */
	protected final long timerMethodReflectiveInvoker(){
		try {
			return (Long) invokableTimerMethod.invoke(invokableTimerTarget, immutableEmptyParameters );
		} catch (Exception e) {
			e.printStackTrace();
			return -1L;
		}
	}

	/**
	 * This timer method is called by the final method  
	 * <code>obtainMeasurementsUsingOverridenTimerMethod</code>. 
	 * This method should be overriden in subclasses; in this class, it calls
	 * <code>java.lang.System.nanoTime</code>.
	 * @return
	 */
	protected abstract long timerMethodToOverride();
//	{
//		return System.nanoTime();
//	}

//	/** THIS METHOD MUST BE OVERRIDDEN IN SUBCLASSES. Implementation is 
//	 * provided here as an example. Use it and replace the <code>nanoTime</code>. 
//	 * 
//	 * After "warming up" the timer method <code>numberOfWarmupTimerInvocations</code> times, this
//	 * method measures the duration of a 'for' loop. The measurement is repeated
//	 * <code>numberOfMeasurements</code> times for each loop iteration number from
//	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
//	 * 
//	 * @return <code>List</code> of measurements
//	 * @deprecated see protected List<List<Long>> obtainMeasurements in this class
//	 */
//	protected List<Long> obtainMeasurements_old() {
//		for (int w = 0; w < numberOfWarmupTimerInvocations; w++) {
//			publicDummy = System.nanoTime();
//		}
//		o.println("DEBUG: Warmup finished (" + numberOfWarmupTimerInvocations + " calls to "+timerMethodName+").\n");
//
//		// 0 "for loop iterations" - intentionally not part of the loop below
//		for (int i = 0; i < numberOfMeasurements; i++) {
//			System.gc();// TODO manualGC...
//			methodReturnAtMeasurementStart = System.nanoTime();
//			methodReturnAtMeasurementFinish = System.nanoTime();
//			methodReturnDifference = methodReturnAtMeasurementFinish - methodReturnAtMeasurementStart;
//
//			if (methodReturnDifference < 0) {
//				o.println(warningOnNegativeDiff);
//			} else {
//				originalMeasurements.add(methodReturnDifference);
//			}
//		}
//		
//		// 1 to (numberOfMeasurements-1) "for loop iterations"
//		for (int l = 1; l < numberOfIterationIncreaseSteps; l++) {
//			currentUpperLoopSizeBound= currentUpperLoopSizeBound + iterationIncreaseStepWidth;
//			for (int i = 0; i < numberOfMeasurements; i++) {
//				methodReturnAtMeasurementStart = System.nanoTime();
//				for (int a = 0; a < currentUpperLoopSizeBound ; a++) {
////					increased++;
//				}
//				methodReturnAtMeasurementFinish = System.nanoTime();
//				methodReturnDifference = methodReturnAtMeasurementFinish - methodReturnAtMeasurementStart;
//
//				if (methodReturnDifference < 0) {
//					o.println(warningOnNegativeDiff);
//				} else {
//					originalMeasurements.add(methodReturnDifference);
//				}
////				o.println("DEBUG: currentUpperLoopSizeBound "+currentUpperLoopSizeBound+"->methodReturnDifference="+methodReturnDifference);
//			}
//		}
//
//		//note that the minimal cost is not necessarily achieved during the run 
//		//where no code is executed between timer invocations! 
////		computeMinimalTimerInvocationCost();REMOVED BECAUSE THE METHOD REMOVED
//		return originalMeasurements;
//	}
//	
//	/** This method simply searches for the minimal element in the current 
//	 * state of <code>originalMeasurements</code> and then sets 
//	 * <code>minimalTimerInvocationCost</code> accordingly. It assumes 
//	 * (TODO: implement test using assertions) that there are no negative 
//	 * elements in that list, that the list contains elements etc.
//	 * This method should not be overridden by subclasses, but it should be 
//	 * calles inside <code>computeResolution</code> that should be 
//	 * overridden by subclasses. See AbstractTimerMeter.computeResolution.
//	 * The computed minimal timer invocation cost can be obtained by getter 
//	 * method.
//	 * @deprecated
//	 */
//	protected void computeMinimalTimerInvocationCost() {
//		//this could be done by obtaining the smallest element of the *sorted* list...
//		//however, we do not want to wait until data postprocessing, especially
//		//since only this method should be overwritten by subclasses
////		o.println("DEBUG: measurements: "+originalMeasurements);
//		long currTimerInvocationCost = Long.MAX_VALUE;
//		long currValue = 0L;
//		for(Iterator<Long> iter = originalMeasurements.iterator(); iter.hasNext(); ){
//			currValue = iter.next();
//			if(currValue<currTimerInvocationCost){
//				o.println("DEBUG: "+currValue+"<"+currTimerInvocationCost);
//				currTimerInvocationCost = currValue;
//			}
//		}
//		this.setMinimalTimerInvocationCost(currTimerInvocationCost);
//	}
//	/**
//	 * TODO
//	 * @deprecated - make a structured timer properties instance
//	 */
//	private long minimalTimerInvocationCost = 0L;
//
//	/**
//	 * TODO
//	 */
//	protected int increased = 0;
//	
//	/**
//	 * This method encapsulates the entire process. It obtains measurements
//	 * through <code>obtainMeasurements</code>, sorts them and removes ~25%
//	 * of the smallest and ~25% of the largest measurements, clusters the
//	 * remaining results and obtains actual resolution from them.
//	 * 
//	 * @return resolution, converted to long
//	 * @deprecated
//	 */
//	public Long computeResolution_old(
//			String[] args, 
//			boolean doParseArguments, 
//			List<Long> originalMeasurements) {
//		if(doParseArguments) this.parseArguments(args);
//		List<Long> sortedMeasurements = new ArrayList<Long>();
//		List<Long> quartiledMeasurements = new ArrayList<Long>();
//
////		o.println("DEBUG: computeResolution(.,.) executed with following values:\n" 
////				+ "\t " + this.iterationIncreaseStepWidth + " = step width, \n" 
////				+ "\t " + this.nrOfIterationIncreaseSteps + " = nr of steps, \n" 
////				+ "\t " + this.numberOfMeasurements + " = number of measurements, \n" 
////				+ "\t " + this.threshold	+ " = clusterFormationThresholdDistance.\n");
////		o.println("DEBUG: "+originalMeasurements.size());
//		sortedMeasurements = originalMeasurements.subList( // deep copy
//				0, originalMeasurements.size());
////		o.println("DEBUG: "+sortedMeasurements.size());
////		originalMeasurements = null; // helping the GC...
//		Collections.sort(sortedMeasurements);
//		
////		plotHistogram(sortedMeasurements);
//		
////		o.println("DEBUG: "+sortedMeasurements.size());
//		quartiledMeasurements = sortedMeasurements.subList(
//				0,//sortedMeasurements.size() / 4, 
//				(sortedMeasurements.size() / 4) * 3);
////		o.println("DEBUG: "+quartiledMeasurements.size());
////		sortedMeasurements = null; // helping the GC...
//
//		long retResolution = 0L;
//		/*
//		TODO removed because no more in this class
//		Map<Long, Integer> classification = classifyMeasurements(quartiledMeasurements); 
//		printStatisticsForStepWidth(classification);
//		o.println("Unsorted classification results "
//			+ "(tuples are \"smallest cluster element=number of cluster elements\"): \n"
//			+ classification + "\n");
//		
//		//TODO print sorted classification results
//
//		double resolution = 0L;
//		double resolutionSum = 0L;
//		Set<Long> clusterKeys = classification.keySet();
//		
//		int nrOfKeys = clusterKeys.size();
//		if (nrOfKeys < 2) {
//			o.println("Resolution could not be derived because only "
//							+ "one class of results was discovered. "
//							+ "Please try a higher \"loop upper bound\" "
//							+ "(or run with defaults if you changed the command-line settings).");
//			resolution = -1L;
//		} else {
//			Iterator<Long> keysIter = clusterKeys.iterator();
//			List<Long> keysList = new ArrayList<Long>();
//			for (; keysIter.hasNext();) {
//				keysList.add(keysIter.next());
//			}
//			Collections.sort(keysList);
//			// starting with i=1 because n points constitute (n-1) distances
//			keysIter = keysList.iterator();
//			Long currKey = 0L;
//			Long prevKey = keysIter.next();
//			
//			for (; keysIter.hasNext();) {
//				currKey = keysIter.next();
////				o.println("currKey: " + currKey);
//				resolutionSum += (currKey - prevKey);
//				prevKey = currKey;
//			}
//			resolution = resolutionSum / (nrOfKeys - 1);
//		}
//		retResolution = new Double(resolution).longValue(); 
//		o.println("\nResolution as double: " + resolution + ", as long: "
//				+ retResolution + "\n");
//		*/
//		return retResolution;
//	}
//	
//	/**TODO: implement security checks
//	 * @param minimalTimerInvocationCost
//	 */
//	protected void setMinimalTimerInvocationCost(long minimalTimerInvocationCost) {
//		this.minimalTimerInvocationCost = minimalTimerInvocationCost;
//	}
//	public Long computeResolution(String[] args) {
////		List<Long> originalMeasurements = new ArrayList<Long>();
//		
//		//that call may go to the sublass which does not override this method, 
//		//but overrides obtainMeasurements
//		
//		this.originalMeasurements = obtainMeasurements_old(); 
//	
//		System.out.println(this.originalMeasurements.size()+" original measurements");
//		return computeResolution(args, true, this.originalMeasurements);
//	}
//
//	/**
//	 * Default width of steps by which the number of 'for loop' iterations 
//	 * is increased. This constant has proved suitable for <code>nanoTime</code> 
//	 * on our development platform. For further details, see class description.
//	 */
//	private static final int NANOTIME_DEFAULT_ITERATION_INCREASE_STEP_WIDTH = 4;
//
//	/**
//	 * Default number of steps in which the number of 'for loop' iterations 
//	 * is increased. Each step has a width that is specified separately. 
//	 * This constant has proved suitable for <code>nanoTime</code> 
//	 * on our development platform.
//	 * For further details, see class description.
//	 */
//	private static final int NANOTIME_DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS = 400;
//
//	/**
//	 * Specifies how many measurements are performed for each number of 
//	 * 'for loop' iterations. This constant has proved suitable for 
//	 * <code>nanoTime</code> on our development platform. 
//	 * For further details, see class description.
//	 */
//	private static final int NANOTIME_DEFAULT_NUMBER_OF_MEASUREMENTS = 400; // per
//
//	/**
//	 * Measurements that are less than this clusterFormationThresholdDistance apart are combined into
//	 * one cluster, whereby the cluster median is taken to compute the
//	 * <code>nanoTime</code> resolution.
//	 */
//	private static final int NANOTIME_DEFAULT_THRESHOLD = 50;
}
