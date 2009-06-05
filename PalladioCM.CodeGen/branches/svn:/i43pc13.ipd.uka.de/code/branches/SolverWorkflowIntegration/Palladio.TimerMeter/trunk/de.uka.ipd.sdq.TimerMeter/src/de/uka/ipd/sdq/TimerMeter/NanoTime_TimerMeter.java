package de.uka.ipd.sdq.TimerMeter;


/**This class computes the resolution of 
 * <code>java.lang.System.nanoTime()</code> method. 
 * For detailed documentation of parameters, behaviour, inner workings etc., 
 * see <code>AbstractTimerMeter</code>.
 * 
 * @author Michael Kuperberg (mkuper@ipd.uka.de), 
 * Chair for Software Design and Quality (SDQ), 
 * Institute for Program Structures and Data Organisation (IPD),
 * Faculty of Informatics, University of Karlsruhe, Germany
 * http://sdq.ipd.uka.de
 *
 */
public class NanoTime_TimerMeter extends AbstractTimerMeter {
	
	/**
	 * TODO
	 * @param args
	 */
	public static void main(String[] args){
		NanoTime_TimerMeter tm = new NanoTime_TimerMeter();
		tm.run(args);
	}
	
	public NanoTime_TimerMeter() {
		timerClassName = "java.lang.System";
		timerMethodIsStatic = true;
		timerMethodName = "nanoTime";
		timerMethodUnit = "ns";
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
	protected long[][] obtainMeasurementsUsingDirectInvocation() {
		int totalNumberOfMeasurementsInOneProcessRun = (this.numberOfIterationIncreaseSteps+1)*this.numberOfMeasurements;
		o.println("Creating and filling a data structure occupying at least 2*"+
				this.numberOfProcessRepetitions+"*"+
				(this.numberOfIterationIncreaseSteps+1)+"*"+
				this.numberOfMeasurements+"="+
				(2*this.numberOfProcessRepetitions*(this.numberOfIterationIncreaseSteps+1)*this.numberOfMeasurements) +
				" bytes of DATA memory, not counting the linking structure...");
		
		//1. initialise data structure fully
		long[][] allResults = new long[this.numberOfProcessRepetitions][totalNumberOfMeasurementsInOneProcessRun];
		for (int i=0; i<this.numberOfProcessRepetitions; i++) {
			for (int j=0; j<totalNumberOfMeasurementsInOneProcessRun; j++) {
				allResults[i][j]=0L;
			}
		}

		for (int w = 0; w < this.numberOfWarmupTimerInvocations; w++) {
			publicDummy += System.nanoTime();
		}
		o.println("DEBUG: Warmup finished (" + 
				this.numberOfWarmupTimerInvocations + 
				" calls to "+timerMethodName+", " +
				"publicDummy is " + publicDummy+").\n");

		for(int p=0; p<this.numberOfProcessRepetitions; p++){
			o.println("Process "+p+" of "+this.numberOfProcessRepetitions);
			// here: no work between timer invocations, i.e. no "for loop iterations" - 
			// intentionally not part of the second loop below, but included in 
			//measurements for obtaining invocation costs
			for (int i = 0; i < this.numberOfMeasurements; i++) {
//				System.gc();// TODO manualGC...
				this.methodReturnAtMeasurementStart = System.nanoTime();
				this.methodReturnAtMeasurementFinish = System.nanoTime();
				this.methodReturnDifference = this.methodReturnAtMeasurementFinish - this.methodReturnAtMeasurementStart;
	
				if (this.methodReturnDifference < 0) {
					o.println(warningOnNegativeDiff);
				} else {
					allResults[p][i]=this.methodReturnDifference;
				}
			}
			int offsetIntoArray = this.numberOfMeasurements-1;
			
			// 0 to (numberOfIterationIncreaseSteps-1) outer "for loop iterations"
			for (int l = 0; l < this.numberOfIterationIncreaseSteps; l++) {//TODO check this
				this.currentUpperLoopSizeBound = this.currentUpperLoopSizeBound + this.iterationIncreaseStepWidth;
				// 0 to (numberOfMeasurements-1) inner "for loop iterations"
				for (int m = 0; m < this.numberOfMeasurements; m++) {
					offsetIntoArray++; //pointing to the place to store the diff
					this.methodReturnAtMeasurementStart = System.nanoTime();
					for (int a = 0; a < this.currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					this.methodReturnAtMeasurementFinish = System.nanoTime();
					this.methodReturnDifference = this.methodReturnAtMeasurementFinish - this.methodReturnAtMeasurementStart;
	
					if (this.methodReturnDifference < 0) {
						o.println(warningOnNegativeDiff);
					} else {
						allResults[p][offsetIntoArray]=this.methodReturnDifference;
					}
	//				o.println("DEBUG: currentUpperLoopSizeBound "+currentUpperLoopSizeBound+"->methodReturnDifference="+methodReturnDifference);
				}
			}
		}

		return allResults;
	}
	/**
	 * This timer method is called by the final method  
	 * <code>obtainMeasurementsUsingOverridenTimerMethod</code>. 
	 * This method should be overriden in subclasses; in this class, it calls
	 * <code>java.lang.System.nanoTime</code>.
	 * @return
	 */
	protected long timerMethodToOverride(){
		return System.nanoTime();
	}

	
//	/**Evaluates the arguments and computes <code>nanoTime</code> resolution accordingly.
//	 * @param args see <code>parseArguments</code> for documentation of parameters
//	 */
//	public static void main(String[] args){
//		NanoTime_TimerMeter ntrr = new NanoTime_TimerMeter();
//		ntrr.computeResolution(args);
//		System.out.println("Minimal timer invocation cost: "+ntrr.getMinimalTimerInvocationCost());
//	}
//	
//	/**Default constructor: initialises all fields to 
//	 * default values declared in this class.
//	 */
//	public NanoTime_TimerMeter() {
//		super();
//		this.timerMethodName = "nanoTime()"; //short form, compared to superclass;
//	}
//
//	/**After "warming up" the <code>nanoTime</code> method 3000 times,
//	 * this method measures the duration of for loop. The measurement is repeated
//	 * <code>numberOfMeasurements</code> times for each iteration number from 
//	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
//	 * @return <code>List</code> of measurements
//	 */
//	protected List<Long> obtainMeasurements_old() {
//		return super.obtainMeasurements_old();
//	}
}
