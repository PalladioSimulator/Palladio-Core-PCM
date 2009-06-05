package de.uka.ipd.sdq.TimerMeter;


/**This class computes the resolution of 
 * <code>java.lang.System.currentTimeMillis()</code> method. 
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
public class CurrentTimeMillis_TimerMeter extends AbstractTimerMeter {
	
	/**Evaluates the arguments and computes <code>currentTimeMillis</code> resolution accordingly.
	 * @param args see <code>parseArguments</code> for documentation of parameters
	 */
	public static void main(String[] args){
		CurrentTimeMillis_TimerMeter tm = new CurrentTimeMillis_TimerMeter();
		//alternative 1 : CurrentTimeMillis_TimerMeter.timerClassName = "java.lang.System";
		//alternative 2 : tm.timerClassName = "java.lang.System"; (gets a warning because non-static access to a static field)
		tm.parseArguments(args);//is needed to set the parameters
		tm.initialiseInvokableTimerMethod();
		System.out.println(tm.computeTimerCharacterization(tm.obtainMeasurementsUsingDirectInvocation(), false));
		System.out.println(tm.computeTimerCharacterization(tm.obtainMeasurementsUsingOverridenTimerMethod(), false));
		if(tm.getInvokableTimerMethod()!=null){
			try{
				long[][] resultsFromReflection = tm.obtainMeasurementsUsingReflection();
				System.out.println(tm.computeTimerCharacterization(resultsFromReflection, false));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**Changes increase step width to 10 and number of iteration increases to 400.
	 */
	public CurrentTimeMillis_TimerMeter() {
		super();
		timerClassName = "java.lang.System"; //TODO test this!
		timerMethodIsStatic = true;
		timerMethodName = "currentTimeMillis";
		timerMethodUnit = "ms";
	}

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
			publicDummy += System.currentTimeMillis();
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
				this.methodReturnAtMeasurementStart = System.currentTimeMillis();
				this.methodReturnAtMeasurementFinish = System.currentTimeMillis();
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
					this.methodReturnAtMeasurementStart = System.currentTimeMillis();
					for (int a = 0; a < this.currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					this.methodReturnAtMeasurementFinish = System.currentTimeMillis();
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
		return System.currentTimeMillis();
	}

//	/**After "warming up" the <code>currentTimeMillis()</code> method numberOfWarmupTimerInvocations times,
//	 * this method measures the duration of for loop. The measurement is repeated
//	 * <code>numberOfMeasurements</code> times for each iteration number from 
//	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
//	 * @return <code>List</code> of measurements
//	 */
//	protected List<Long> obtainMeasurements_old() {
//		for(int w=0; w<numberOfWarmupTimerInvocations; w++){
//			publicDummy = System.currentTimeMillis();
//		}
//		o.println("Warmup finished ("+numberOfWarmupTimerInvocations+" calls to "+this.timerMethodName+").\n");
//		
//		//0 "for loop iterations" - intentionally not part of the loop below
//		for(int i=0; i<numberOfMeasurements; i++){
//			System.gc();//TODO manualGC...
//			methodReturnAtMeasurementStart=System.currentTimeMillis();
//			methodReturnAtMeasurementFinish=System.currentTimeMillis();
//			methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
//			
//			if(methodReturnDifference<0){
//				o.println(warningOnNegativeDiff);
//			}else{
//				originalMeasurements.add(methodReturnDifference);
//			}
//		}
//		
//		//1 to (numberOfMeasurements-1) "for loop iterations"
//		for(int l = 1; l<numberOfIterationIncreaseSteps; l++){
//			currentUpperLoopSizeBound= currentUpperLoopSizeBound + iterationIncreaseStepWidth;
//			for(int i=0; i<numberOfMeasurements; i++){
//				methodReturnAtMeasurementStart=System.currentTimeMillis();
//				for(int a=0; a<currentUpperLoopSizeBound; a++){
//					//nothing
//				}
//				methodReturnAtMeasurementFinish=System.currentTimeMillis();
////				o.println("DEBUG: Start: "+methodReturnAtMeasurementStart+", methodReturnAtMeasurementFinish: "+methodReturnAtMeasurementFinish);
//				methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
//				
//				if(methodReturnDifference<0){
//					o.println(warningOnNegativeDiff);
//				}else{
//					originalMeasurements.add(methodReturnDifference);
//				}
//			}
//		}
//		//note that the minimal cost is not necessarily achieved during the run 
//		//where no code is executed between timer invocations! 
//		computeMinimalTimerInvocationCost();
//		return originalMeasurements;
//	}
//	/**
//	 * We must overwrite this method because the resolution of currentTimeMillis
//	 * is too far above its invocation cost. That is, two subsequent calls to 
//	 * currentTimeMillis are very likely to deliver the same value.
//	 */
//	protected void computeMinimalTimerInvocationCost() {
//		//this could be done by obtaining the smallest element of the *sorted* list...
//		//however, we do not want to wait until data postprocessing, especially
//		//since only this method should be overwritten by subclasses
////		o.println("DEBUG: measurements: "+originalMeasurements);
//		
//		long nanoTimeDuration = super.getMinimalTimerInvocationCost();
//		o.println("DEBUG: from super: cost: "+nanoTimeDuration);
//		List<Long> nanoDurations = new ArrayList<Long>();
//		List<Long> nanoAndMilliDurations = new ArrayList<Long>();
//		long start = 0L;
//		long finish = 0L;
//		long diff = 0L;
//		long dummy = 0L;
//		int currentTimeMillisInvocationNumber = 10000;
//		for(int i=0; i<3000; i++){
//			start = System.nanoTime();
//			for(int j=0; j<currentTimeMillisInvocationNumber; j++){
//				dummy++;
//			}
//			finish = System.nanoTime();
//			o.println(dummy);
//			diff = finish-start;
//			if(diff>0){
//				nanoDurations.add(diff);
//			}
//		}
//		for(int i=0; i<3000; i++){
//			start = System.nanoTime();
//			for(int j=0; j<currentTimeMillisInvocationNumber; j++){
//				dummy++;
//				dummy += System.currentTimeMillis();
//			}
//			finish = System.nanoTime();
//			o.println(dummy);
//			diff = finish-start;
//			if(diff>0){
//				nanoAndMilliDurations.add(diff);
//			}
//		}
//		Collections.sort(nanoDurations);
//		Collections.sort(nanoAndMilliDurations);
//		double result = (nanoAndMilliDurations.get(0)-nanoDurations.get(0))/3000;
//		o.println("DEBUG: "+nanoAndMilliDurations.get(0)+"-"+nanoDurations.get(0)+"="+result);
//		this.setMinimalTimerInvocationCost(new Double(result).longValue());
//	}
}
