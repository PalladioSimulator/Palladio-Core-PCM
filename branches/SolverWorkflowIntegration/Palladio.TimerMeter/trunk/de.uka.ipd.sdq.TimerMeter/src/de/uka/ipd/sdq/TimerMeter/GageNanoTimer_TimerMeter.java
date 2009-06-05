package de.uka.ipd.sdq.TimerMeter;

import com.dnsalias.java.timer.NativeTimer;
import com.dnsalias.java.timer.nanotimer.NanoTimer;


/**This class computes the resolution of 
 * <code>AdvancedTimer.getClockTicks();</code> method of GageTimer. 
 * For detailed documentation of parameters, behaviour, inner workings etc., 
 * see <code>AbstractTimerMeter</code>.
 * 
 * <b>Note: You should have the location of timer.dll in
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
public class GageNanoTimer_TimerMeter extends AbstractTimerMeter {
	
	public static void main(String[] args) {
		GageNanoTimer_TimerMeter tm = new GageNanoTimer_TimerMeter();
		tm.run(args);
		
//		tm.initialiseInvokableTimerMethod();
//		System.out.println(tm.computeTimerCharacterization(tm.obtainMeasurementsUsingDirectInvocation(), false));
//		System.out.println(tm.computeTimerCharacterization(tm.obtainMeasurementsUsingOverridenTimerMethod(), false));
//		if(tm.invokableTimerMethod!=null){
//			try{
//				long[][] resultsFromReflection = tm.obtainMeasurementsUsingReflection();
//				System.out.println(tm.computeTimerCharacterization(resultsFromReflection, false));
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

	private NativeTimer natTimer;

	/**Changes increase step width to 10 and number of iteration increases to 400.
	 */
	public GageNanoTimer_TimerMeter() {
		super();
		timerClassName = "com.dnsalias.java.timer.nanotimer.NanoTimer"; //TODO test this!
		timerMethodName = "getClockTicks";
		timerMethodIsStatic = false; //Reflection will call a parameterless constructor and save the target instance...
		timerMethodUnit = "ticks"; //TODO

		natTimer = new NanoTimer(); //TODO document the choice (not in GAGE API docs!)
		this.setOfficialTimerMethodAccuracy(natTimer.getResolution()); //TODO test //TODO is in milliseconds - consistent?

//		DEFAULT_ITERATION_INCREASE_STEP_WIDTH = 10000;
//		DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS = 400;
//		DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP = 8000;
//		DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE = 1;
//		this.timerMethodName = "AdvancedTimer.getClockTicks()";
//		long freq = AdvancedTimer.getTicksPerSecond();
	}
	
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
			publicDummy += natTimer.getClockTicks();
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
				this.methodReturnAtMeasurementStart = natTimer.getClockTicks();
				this.methodReturnAtMeasurementFinish = natTimer.getClockTicks();
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
					this.methodReturnAtMeasurementStart = natTimer.getClockTicks();
					for (int a = 0; a < this.currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					this.methodReturnAtMeasurementFinish = natTimer.getClockTicks();
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
		return natTimer.getClockTicks();
	}

}
