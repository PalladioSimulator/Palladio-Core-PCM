package de.uka.ipd.sdq.TimerMeter;

import com.mindprod.pentium.Pentium;


/**This class computes the resolution of 
 * <code>Pentium.rdtsc()</code> method (rdtsc). 
 * For detailed documentation of parameters, behaviour, inner workings etc., 
 * see <code>AbstractTimerMeter</code>.
 * 
 * <b>Note: You need to have the location of nativepentium.dll in
 * your PATH variable. In Eclipse you can use the [Run Dialog]->Environment
 * tab to append to your path.</b>
 * 
 * @author Michael Kuperberg (mkuper@ipd.uka.de), 
 * Chair for Software Design and Quality (SDQ), 
 * Institute for Program Structures and Data Organisation (IPD),
 * Faculty of Informatics, University of Karlsruhe, Germany
 * http://sdq.ipd.uka.de
 *
 */
public class RdtscWindows_TimerMeter extends AbstractTimerMeter {
	
	/**Evaluates the arguments and computes <code>Perfcount.readcounter()</code> resolution accordingly.
	 * @param args see <code>parseArguments</code> for documentation of parameters
	 */
	public static void main(String[] args) {
		RdtscWindows_TimerMeter tm = new RdtscWindows_TimerMeter();
		tm.run(args);
//		rwcrr.computeResolution(args);//defined in superclass; calls 
//		System.out.println("Minimal timer invocation cost: "+
//				rwcrr.getMinimalTimerInvocationCost());
//		System.out.println(""+rwcrr);
//		StringBuffer sb = new StringBuffer();
//		for(int i=1; i<50; i++){
//			rwcrr.clusterFormationThresholdDistance = i;
////			rwcrr.originalMeasurements = new ArrayList<Long>();
//			sb.append("Resolution with clusterFormationThresholdDistance "+rwcrr.clusterFormationThresholdDistance+": "+
//					rwcrr.computeResolution_old(
//							args, 
//							false, 
//							rwcrr.originalMeasurements)+
//					"\n");
//		}
//		System.out.println(sb.toString());
	}
	
/**Changes increase step width to 10 and number of iteration increases to 400.
	 */
	public RdtscWindows_TimerMeter() {
		super();
		this.timerClassName = "com.mindprod.pentium.Pentium";
		this.timerMethodIsStatic = true;
		this.timerMethodName = "rdtsc";
		this.timerMethodUnit = "ticks";
		
//		DEFAULT_ITERATION_INCREASE_STEP_WIDTH = 2;
//		iterationIncreaseStepWidth = DEFAULT_ITERATION_INCREASE_STEP_WIDTH;
//		DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS = 400;
//		numberOfIterationIncreaseSteps = DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS;
//		DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP = 1000;
//		numberOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP;
//		DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE = 30;
//		clusterFormationThresholdDistance = DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE;
	}

	//	public String toString(){
//		StringBuffer sb = new StringBuffer();
//		sb.append("This RdtscWindows_TimerMeter has "+
//				this.originalMeasurements.size()+" measurements");
//		return sb.toString();
//	}
	@Override
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
			publicDummy += Pentium.rdtsc();
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
				this.methodReturnAtMeasurementStart = Pentium.rdtsc();
				this.methodReturnAtMeasurementFinish = Pentium.rdtsc();
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
					this.methodReturnAtMeasurementStart = Pentium.rdtsc();
					for (int a = 0; a < this.currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					this.methodReturnAtMeasurementFinish = Pentium.rdtsc();
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

	protected long timerMethodToOverride(){
		return Pentium.rdtsc();
	}

//	/**After "warming up" the <code>Perfcount.readcounter()</code> method numberOfWarmupTimerInvocations times,
//	 * this method measures the duration of a 'for' loop. The measurement is repeated
//	 * <code>numberOfMeasurements</code> times for each iteration number from 
//	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
//	 * @return <code>List</code> of measurements
//	 */
//	protected List<Long> obtainMeasurements_old() {
//		for(int w=0; w<numberOfWarmupTimerInvocations; w++){
//			publicDummy = Perfcount.readcounter();
//		}
//		o.println("Warmup finished ("+numberOfWarmupTimerInvocations+" calls to "+this.timerMethodName+").\n");
//		o.println(numberOfMeasurements+"=numberOfMeasurements");
//		
//		//0 "for loop iterations" - intentionally not part of the loop below
//		for(int i=0; i<numberOfMeasurements; i++){
////			System.gc();//TODO manualGC...????
//			methodReturnAtMeasurementStart  = Perfcount.readcounter();
//			methodReturnAtMeasurementFinish = Perfcount.readcounter();
//			methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
//			
//			if(methodReturnDifference<0){
//				o.println(warningOnNegativeDiff);
//			}else{
//				this.originalMeasurements.add(methodReturnDifference);
//			}
//		}
//		
//		//1 to (numberOfMeasurements-1) "for loop iterations"
//		for(int l = 1; l<numberOfIterationIncreaseSteps; l++){
//			currentUpperLoopSizeBound= currentUpperLoopSizeBound + iterationIncreaseStepWidth;
//			for(int i=0; i<numberOfMeasurements; i++){
//				methodReturnAtMeasurementStart = Perfcount.readcounter();
//				for(int a=0; a<currentUpperLoopSizeBound; a++){
//					//nothing
//				}
//				methodReturnAtMeasurementFinish = Perfcount.readcounter();
//				methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
////					o.println("DEBUG: methodReturnDifference: "+methodReturnDifference+"(methodReturnAtMeasurementStart: "+methodReturnAtMeasurementStart+", methodReturnAtMeasurementFinish: "+methodReturnAtMeasurementFinish+")");
//				
//				if(methodReturnDifference<0){
//					o.println(warningOnNegativeDiff);
//				}else{
//					this.originalMeasurements.add(methodReturnDifference);
//				}
//			}
//		}
//		//note that the minimal cost is not necessarily achieved during the run 
//		//where no code is executed between timer invocations! 
//		computeMinimalTimerInvocationCost();
//		return this.originalMeasurements;
//	}

//	/**Evaluates the arguments and computes <code>Pentium.rdtsc()</code> resolution accordingly.
//	 * @param args see <code>parseArguments</code> for documentation of parameters
//	 */
//	public static void main(String[] args) {
//
//		RdtscWindows_TimerMeter rwcrr;
//		rwcrr = new RdtscWindows_TimerMeter();
//		rwcrr.computeResolution(args);//defined in superclass; calls 
//		System.out.println("Minimal timer invocation cost: "+
//				rwcrr.getMinimalTimerInvocationCost());
//		System.out.println(""+rwcrr);
//		StringBuffer sb = new StringBuffer();
//		for(int i=1; i<50; i++){
//			rwcrr.clusterFormationThresholdDistance = i;
////			rwcrr.originalMeasurements = new ArrayList<Long>();
//			sb.append("Resolution with clusterFormationThresholdDistance "+rwcrr.clusterFormationThresholdDistance+": "+
//					rwcrr.computeResolution_old(
//							args, 
//							false, 
//							rwcrr.originalMeasurements)+
//					"\n");
//		}
//		System.out.println(sb.toString());
//	}
//	
//	public String toString(){
//		StringBuffer sb = new StringBuffer();
//		sb.append("This RdtscWindows_TimerMeter has "+
//				this.originalMeasurements.size()+" measurements");
//		return sb.toString();
//	}
//	/**Changes increase step width to 10 and number of iteration increases to 400.
//	 */
//	public RdtscWindows_TimerMeter() {
//		super();
//		DEFAULT_ITERATION_INCREASE_STEP_WIDTH = 2;
//		iterationIncreaseStepWidth = DEFAULT_ITERATION_INCREASE_STEP_WIDTH;
//		DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS = 400;
//		numberOfIterationIncreaseSteps = DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS;
//		DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP = 1000;
//		numberOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP;
//		DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE = 30;
//		clusterFormationThresholdDistance = DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE;
//		this.timerMethodName = "rdtsc()";
//	}
//
//	/**After "warming up" the <code>Pentium.rdtsc()</code> method numberOfWarmupTimerInvocations times,
//	 * this method measures the duration of a 'for' loop. The measurement is repeated
//	 * <code>numberOfMeasurements</code> times for each iteration number from 
//	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
//	 * @return <code>List</code> of measurements
//	 */
//	protected List<Long> obtainMeasurements_old() {
//		for(int w=0; w<numberOfWarmupTimerInvocations; w++){
//			publicDummy = Pentium.rdtsc();
//		}
//		o.println("Warmup finished ("+numberOfWarmupTimerInvocations+" calls to "+this.timerMethodName+").\n");
//		o.println(numberOfMeasurements+"=numberOfMeasurements");
//		
//		//0 "for loop iterations" - intentionally not part of the loop below
//		for(int i=0; i<numberOfMeasurements; i++){
////			System.gc();//TODO manualGC...????
//			methodReturnAtMeasurementStart  = Pentium.rdtsc();
//			methodReturnAtMeasurementFinish = Pentium.rdtsc();
//			methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
//			
//			if(methodReturnDifference<0){
//				o.println(warningOnNegativeDiff);
//			}else{
//				this.originalMeasurements.add(methodReturnDifference);
//			}
//		}
//		
//		//1 to (numberOfMeasurements-1) "for loop iterations"
//		for(int l = 1; l<numberOfIterationIncreaseSteps; l++){
//			currentUpperLoopSizeBound= currentUpperLoopSizeBound + iterationIncreaseStepWidth;
//			for(int i=0; i<numberOfMeasurements; i++){
//				methodReturnAtMeasurementStart = Pentium.rdtsc();
//				for(int a=0; a<currentUpperLoopSizeBound; a++){
//					//nothing
//				}
//				methodReturnAtMeasurementFinish = Pentium.rdtsc();
//				methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
////					o.println("DEBUG: methodReturnDifference: "+methodReturnDifference+"(methodReturnAtMeasurementStart: "+methodReturnAtMeasurementStart+", methodReturnAtMeasurementFinish: "+methodReturnAtMeasurementFinish+")");
//				
//				if(methodReturnDifference<0){
//					o.println(warningOnNegativeDiff);
//				}else{
//					this.originalMeasurements.add(methodReturnDifference);
//				}
//			}
//		}
//		//note that the minimal cost is not necessarily achieved during the run 
//		//where no code is executed between timer invocations! 
//		computeMinimalTimerInvocationCost();
//		return this.originalMeasurements;
//	}
//
}
