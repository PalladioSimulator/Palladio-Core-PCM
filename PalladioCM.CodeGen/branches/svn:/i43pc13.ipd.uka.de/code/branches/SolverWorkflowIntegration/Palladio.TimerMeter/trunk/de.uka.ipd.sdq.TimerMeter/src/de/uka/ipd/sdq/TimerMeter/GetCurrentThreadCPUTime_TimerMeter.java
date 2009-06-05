package de.uka.ipd.sdq.TimerMeter;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**This class computes the resolution of 
 * <code>java.lang.management.ThreadMXBean.getCurrentThreadCpuTime()</code> method. 
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
public class GetCurrentThreadCPUTime_TimerMeter extends AbstractTimerMeter {
	
	/**Evaluates the arguments and computes <code>ThreadMXBean.getCurrentThreadCpuTime()</code> resolution accordingly.
	 * @param args see <code>parseArguments</code> for documentation of parameters
	 */
	public static void main(String[] args){
		GetCurrentThreadCPUTime_TimerMeter gctcrr = new GetCurrentThreadCPUTime_TimerMeter();
		gctcrr.run(args);

//		gctcrr.setEnabled(true);
//		long with1 = gctcrr.computeResolution(args);
////		gctcrr.setEnabled(false);
////		long without1 = gctcrr.computeResolution(args);
////		gctcrr.setEnabled(true);
////		long with2 = gctcrr.computeResolution(args);
////		gctcrr.setEnabled(false);
////		long without2 = gctcrr.computeResolution(args);
//		System.out.println("With ThreadCpuTimeEnabled=true: "+with1);
////				+", without: "+without1+", " +
////				"with: "+with2+", without: "+without2+" (supported: "+gctcrr.getSupported()+").");
//		System.out.println("Minimal timer invocation cost: "+gctcrr.getMinimalTimerInvocationCost());
	}
	
	private ThreadMXBean bean;

	@SuppressWarnings("unused")
	private Logger logger;

	/**Changes increase step width to 10 and number of iteration increases to 400.
	 */
	public GetCurrentThreadCPUTime_TimerMeter() {
		super();
		logger = Logger.getLogger(this.getClass().getCanonicalName()+"_"+hashCode());
		BasicConfigurator.configure();
		this.timerClassName = "java.lang.management.ThreadMXBean";
		this.timerMethodIsStatic = false;
		this.timerMethodName = "getCurrentThreadCpuTime";
		this.timerMethodUnit = "todo"; //TODO
		this.initialiseInvokableTimerMethod();
		bean = ManagementFactory.getThreadMXBean();//unterschied zu sun.management.*?
		try{
			bean.setThreadCpuTimeEnabled(true); //noch weitere, andere Methoden!
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * TODO modify to accept parameterless constructors as well...
	 * This class is non-final because it may need to be overriden where 
	 * the timer "static instance" cannot be specified directly, but 
	 * must be obtained using a factory method or similar means.
	 * @return
	 */
	protected boolean initialiseInvokableTimerMethod() {
		//make it simple
		invokableTimerTarget = null;
		try {
			invokableTimerMethod = ManagementFactory.getThreadMXBean().getClass().getMethod("getCurrentThreadCpuTime", new Class<?>[]{});
			invokableTimerMethod.setAccessible(true);	// Sun's ThreadMXBean implementation is protected; override the access
			invokableTimerTarget = ManagementFactory.getThreadMXBean();
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}//finally?
		
//		//make it classical / systematic 
//		if(timerMethodName==null || timerMethodName.isEmpty()){
//			logger.error("Timer method name is null or empty - " +
//					"invokable timer method cannot be initialised");
//			return false;
//		}
//		if(timerMethodName.contains(".")
//				|| timerMethodName.contains("(")
//				|| timerMethodName.contains(")")){
//			logger.error("Timer method contains \".\" or \"(\" or \")\" - " +
//					"I won't bother to parse it, please specify a parameterless, " +
//					"classless method name in this field! Therefore, " +
//					"invokable timer method cannot be initialised");
//			return false;
//		}
//		if(timerClassName==null || timerClassName.isEmpty()){
//			logger.error("Timer class name is null or empty - " +
//			"invokable timer method cannot be initialised");
//			return false;
//		}else{
////			if(timerMethodName==null || timerMethodName.isEmpty()){
////				logger.error("Timer method name is null or empty - " +
////						"invokable timer method cannot be initialised");
////				return false;
////			}else{
//				try {
//					Class<?> timerClass = Class.forName(timerClassName);
//					Method[] allTimerClassMethods = timerClass.getMethods();
//					Method currMethod;
//					List<Method> preciseCandidates = new ArrayList<Method>(); //exactly the same name, but possibly with parameters (!)
//					List<Method> potentialCandidates = new ArrayList<Method>(); //the name starts with the <code>timerMethodName</code>
//					for (int i = 0; i < allTimerClassMethods.length; i++) {
//						currMethod = allTimerClassMethods[i];
//						if(currMethod.getName().equals(timerMethodName)){
//							preciseCandidates.add(currMethod);
//							if(currMethod.getParameterTypes().length==0
//									&& this.invokableTimerMethod==null){
//								this.invokableTimerMethod = currMethod;
//							}
//						}else if(currMethod.getName().startsWith(timerMethodName)){
//							potentialCandidates.add(currMethod);
//						}
//					}
//				} catch (ClassNotFoundException e) {
//					logger.error("Timer class could not be initialised " +
//							"(used class name: "+timerClassName+")");
//					e.printStackTrace();
//				}
////			}
//		}
//		
//		if(timerMethodIsStatic){ //TODO test this
//			logger.debug("Timer method is static, no invocation target is generated");
//		}else{
//			try {
//				Class<?> timerClass = Class.forName(timerClassName);
//				Constructor<?>[] constructors = timerClass.getConstructors();
//				if(constructors==null || constructors.length==0){
//					return false;
//				}
//				Constructor<?> currConstructor;
//				Constructor<?> parameterlessConstructor = null;
//				int i = 0;
//				while(i < constructors.length) {
//					currConstructor = constructors[i];
//					int mods = currConstructor.getModifiers();
//					if(Modifier.isAbstract(mods)
//							|| Modifier.isPrivate(mods)){
//						return false; //TODO document
//					}
//					if(currConstructor.getParameterTypes().length==0){
//						parameterlessConstructor = currConstructor;
//						i=constructors.length;
//					}else{
//						i++;
//					}
//				}
//				invokableTimerTarget = parameterlessConstructor.newInstance(new Object[]{});
//				logger.debug("Creating an invocation target succeeded");
//			} catch (Exception e) {
//				logger.error("Creating an invocation target failed");
//				e.printStackTrace();
//			}
//		}
//		
//		if(invokableTimerMethod==null){
//			return false;
//		}else{
//			if(timerMethodIsStatic){
//				try {
//					logger.debug("Testwise direct timer invocation: "+invokableTimerMethod.invoke(null, new Object[]{}));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				try {
//					logger.debug("Testwise timer invocation through predefined invoker: "+timerMethodReflectiveInvoker());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return true;
//			} else {
//				if(invokableTimerTarget!=null){
//					try {
//						logger.debug("Testwise direct timer invocation: "+invokableTimerMethod.invoke(invokableTimerTarget, new Object[]{}));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					try {
//						logger.debug("Testwise timer invocation through predefined invoker: "+timerMethodReflectiveInvoker());
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					return true;
//				}else{
//					return false;
//				}
//			}
//		}
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
			publicDummy += bean.getCurrentThreadCpuTime();
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
				this.methodReturnAtMeasurementStart = bean.getCurrentThreadCpuTime();
				this.methodReturnAtMeasurementFinish = bean.getCurrentThreadCpuTime();
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
					this.methodReturnAtMeasurementStart = bean.getCurrentThreadCpuTime();
					for (int a = 0; a < this.currentUpperLoopSizeBound ; a++) {
	//					increased++;//TODO --> align with paper
					}
					this.methodReturnAtMeasurementFinish = bean.getCurrentThreadCpuTime();
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
		return bean.getCurrentThreadCpuTime();
	}
	
//	/**After "warming up" the <code>getCurrentThreadCpuTime()()</code> method numberOfWarmupTimerInvocations times,
//	 * this method measures the duration of a 'for' loop. The measurement is repeated
//	 * <code>numberOfMeasurements</code> times for each iteration number from 
//	 * 0 to <code>numberOfIterationIncreaseSteps</code>.
//	 * @return <code>List</code> of measurements
//	 */
//	protected List<Long> obtainMeasurements_old() {
//		for(int w=0; w<numberOfWarmupTimerInvocations; w++){
//			publicDummy = bean.getCurrentThreadCpuTime();
//		}
//		o.println("Warmup finished ("+numberOfWarmupTimerInvocations+" calls to "+this.timerMethodName+").\n");
//		
//		//0 "for loop iterations" - intentionally not part of the loop below
//		for(int i=0; i<numberOfMeasurements; i++){
//			System.gc();//TODO manualGC...
//			methodReturnAtMeasurementStart  = bean.getCurrentThreadCpuTime();
//			methodReturnAtMeasurementFinish = bean.getCurrentThreadCpuTime();
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
//				methodReturnAtMeasurementStart = bean.getCurrentThreadCpuTime();
//				for(int a=0; a<currentUpperLoopSizeBound; a++){
//					//nothing
//				}
//				methodReturnAtMeasurementFinish = bean.getCurrentThreadCpuTime();
//				methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
////				o.println("DEBUG: methodReturnDifference: "+methodReturnDifference+"(methodReturnAtMeasurementStart: "+methodReturnAtMeasurementStart+", methodReturnAtMeasurementFinish: "+methodReturnAtMeasurementFinish+")");
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
//	
//
//	/**
//	 * We must overwrite this method because the resolution of GetCurrentThreadCPUTime
//	 * is too far above its invocation cost. That is, two subsequent calls to 
//	 * GetCurrentThreadCPUTime are very likely to deliver the same value.
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
//		List<Long> nanoAndGCTCTDurations = new ArrayList<Long>();
//		long start = 0L;
//		long finish = 0L;
//		long diff = 0L;
//		long dummy = 0L;
//		int GCTCTInvocationNumber = 100;
//		for(int i=0; i<3000; i++){
//			start = System.nanoTime();
//			for(int j=0; j<GCTCTInvocationNumber; j++){
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
//			for(int j=0; j<GCTCTInvocationNumber; j++){
//				dummy++;
//				dummy += bean.getCurrentThreadCpuTime();
//			}
//			finish = System.nanoTime();
//			o.println(dummy);
//			diff = finish-start;
//			if(diff>0){
//				nanoAndGCTCTDurations.add(diff);
//			}
//		}
//		Collections.sort(nanoDurations);
//		Collections.sort(nanoAndGCTCTDurations);
//		double result = (nanoAndGCTCTDurations.get(0)-nanoDurations.get(0))/3000;
//		o.println("DEBUG: "+nanoAndGCTCTDurations.get(0)+"-"+nanoDurations.get(0)+"="+result);
//		this.setMinimalTimerInvocationCost(new Double(result).longValue());
//	}
//
//
}
