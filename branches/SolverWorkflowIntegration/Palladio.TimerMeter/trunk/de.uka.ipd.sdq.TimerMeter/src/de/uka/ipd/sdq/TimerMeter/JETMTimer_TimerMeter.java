package de.uka.ipd.sdq.TimerMeter;

import java.lang.reflect.Method;

import etm.core.configuration.EtmMonitorFactory;
import etm.core.timer.ExecutionTimer;


/**This class computes the resolution of 
 * <code>PerfmonWrapper.queryPerformanceCounter();</code> method. 
 * For detailed documentation of parameters, behaviour, inner workings etc., 
 * see <code>AbstractTimerMeter</code>.
 * 
 * <b>Note: You need to have the location of PerfmonWrapper.dll in
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
public class JETMTimer_TimerMeter extends AbstractTimerMeter {
	
	/**Evaluates the arguments and computes <code>ExecutionTimer.getCurrentTime();</code> resolution accordingly.
	 * @param args see <code>parseArguments</code> for documentation of parameters
	 */
	public static void main(String[] args) {
		JETMTimer_TimerMeter rwcrr = new JETMTimer_TimerMeter();
		rwcrr.run(args);
//		rwcrr.computeResolution(args);
//		System.out.println("Minimal timer invocation cost: "+rwcrr.getMinimalTimerInvocationCost());
	}
	
	private ExecutionTimer timer;

	/**Changes increase step width to 10 and number of iteration increases to 400.
	 */
	public JETMTimer_TimerMeter() {
		super();
		this.timerClassName = "etm.core.timer.ExecutionTimer";//interface
		this.timerMethodName = "getCurrentTime";
		this.timerMethodIsStatic = false;
		this.timerMethodUnit = "ticks";
		
		timer = EtmMonitorFactory.bestAvailableTimer();
		this.setOfficialTimerFrequency(timer.getTicksPerSecond());
//		o.println("ExecutionTimer.getTicksPerSecond() returns " + freq + ". 1/x: " + 1.0/freq + ".");

		//		DEFAULT_ITERATION_INCREASE_STEP_WIDTH = 1000;
//		DEFAULT_NUMBER_OF_ITERATION_INCREASE_STEPS = 400;
//		DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP = 100;
//		DEFAULT_CLUSTER_FORMATION_THRESHOLD_DISTANCE = 1;
	}
	
	protected boolean initialiseInvokableTimerMethod() {
		//make it simple
		
		Class<?> factory;
		Method factoryMethod;
		try {
			factory = Class.forName("etm.core.configuration.EtmMonitorFactory");
			factoryMethod = factory.getMethod("bestAvailableTimer", new Class<?>[]{});
			invokableTimerTarget = factoryMethod.invoke(null, new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			invokableTimerMethod = invokableTimerTarget.getClass().getMethod("getCurrentTime", new Class<?>[]{});
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}//finally?
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
			publicDummy += timer.getCurrentTime();
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
				this.methodReturnAtMeasurementStart = timer.getCurrentTime();
				this.methodReturnAtMeasurementFinish = timer.getCurrentTime();
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
					this.methodReturnAtMeasurementStart = timer.getCurrentTime();
					for (int a = 0; a < this.currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					this.methodReturnAtMeasurementFinish = timer.getCurrentTime();
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

	@Override
	protected long timerMethodToOverride() {
		return timer.getCurrentTime();
	}
}
