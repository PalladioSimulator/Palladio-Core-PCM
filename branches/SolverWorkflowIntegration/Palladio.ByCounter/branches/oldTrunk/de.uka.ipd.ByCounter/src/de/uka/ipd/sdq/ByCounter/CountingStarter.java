package de.uka.ipd.sdq.ByCounter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import spec.benchmarks.scimark.lu.LU;
import spec.benchmarks.scimark.monte_carlo.MonteCarlo;
import spec.benchmarks.scimark.utils.Random;


import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.test.JGFCastBench_MK;
import de.uka.ipd.sdq.ByCounter.test.Linpack_MK;
import de.uka.ipd.sdq.ByCounter.test.SciMarkMonteCarlo_MK;

/** Tests for bytecode instrumentation.
 * Demonstrates how to use the BytecodeCounter.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.3
 */
public class CountingStarter {
	
//	private static final int defaultProblemSize = 10000;

	private static final int USE_JGF 					= 0;
	private static final int USE_LINPACK 				= 1;
	private static final int USE_SCIMARK 				= 2;
	private static final int USE_LU2008 				= 3; //TODO test
	private static final int USE_MC2008 				= 4; //TODO test
	private static final int USE_RD2008 				= 5; //TODO test

	private static final MethodDescriptor METHOD_TO_EXECUTE = //FIXME
		new MethodDescriptor("public void run_MK()");

	private static final String TEST_CLASS_CANONICAL_NAME_JFG = 
		JGFCastBench_MK.class.getCanonicalName();
	private static final String TEST_METHODSIG_JFG			= 
		"public void JGFrun_MK()";
	
	private static final String TEST_CLASS_CANONICAL_NAME_LI 	= 
		Linpack_MK.class.getCanonicalName();
	private static final String TEST_METHODSIG_LI 			= 
		"public void run_benchmark()";
	
	private static final String TEST_CLASS_CANONICAL_NAME_MC	= 
		SciMarkMonteCarlo_MK.class.getCanonicalName();
	private static final String TEST_METHODSIG_MC 			= 
		"public static final double integrateMK()";
	
	/**
	 * NEW
	 */
	private static final String TEST_CLASS_CANONICAL_NAME_LU2008  //TODO test
		= LU.class.getCanonicalName();
	private static final String TEST_METHODSIG_LU2008 			  //TODO test
		= "public int factor(double A[][], int pivot[])";
	
	/**
	 * NEW
	 */
	private static final String TEST_CLASS_CANONICAL_NAME_MC2008  //TODO test
		= MonteCarlo.class.getCanonicalName();
	private static final String TEST_METHODSIG_MC2008 			  //TODO test
		= "public final double integrate_MK(int Num_samples)";
	
	/**
	 * NEW
	 */
	private static final String TEST_CLASS_CANONICAL_NAME_RD2008  //TODO test
		= Random.class.getCanonicalName();
	private static final String TEST_METHODSIG_RD2008 			  //TODO test
		= "public final double integrate_MK_inlined(int Num_samples)";    

	private BytecodeCounter counter;
	private Logger log;
	private CountingResultCollector resultColl;
	private String testClassName;
	private String testMethodSignature;
	private int use;

	public CountingStarter(){
		PropertyConfigurator.configure("log4j.properties");
		this.log = Logger.getLogger(this.getClass().getCanonicalName());
		
		this.use = USE_LU2008; //TODO add command line interpretation...
		
		if(use == USE_JGF){
			this.testClassName 			= TEST_CLASS_CANONICAL_NAME_JFG;
			this.testMethodSignature 	= TEST_METHODSIG_JFG;
		}else if(use == USE_LINPACK){
			this.testClassName 			= TEST_CLASS_CANONICAL_NAME_LI;
			this.testMethodSignature 	= TEST_METHODSIG_LI;
		}else if(use == USE_SCIMARK){
			this.testClassName 			= TEST_CLASS_CANONICAL_NAME_MC;
			this.testMethodSignature 	= TEST_METHODSIG_MC;
		}else if(use == USE_LU2008){ //TODO: test
			this.testClassName 			= TEST_CLASS_CANONICAL_NAME_LU2008;
			this.testMethodSignature 	= TEST_METHODSIG_LU2008;
		}else if(use == USE_MC2008){
			this.testClassName 			= TEST_CLASS_CANONICAL_NAME_MC2008;
			this.testMethodSignature 	= TEST_METHODSIG_MC2008;
		}else if(use == USE_RD2008){
			this.testClassName 			= TEST_CLASS_CANONICAL_NAME_RD2008;
			this.testMethodSignature 	= TEST_METHODSIG_RD2008;
		}else{
			//TODO
		}
		this.resultColl = CountingResultCollector.getInstance();
		this.counter = new BytecodeCounter(this.testClassName);
	}

	/** Tests application entry point.
	 * @param args No arguments needed.
	 */
	public static void main(String[] args) {
		//MK TODO wozu war das? new Thread().start();
		// early ResultCollector construction; initialize the singleton
		CountingStarter cs = new CountingStarter();
		cs.count();
	}
	
	private void count(){
		MethodDescriptor methDesc = new MethodDescriptor(this.testMethodSignature);
		log.debug("Method descriptor: "+methDesc);
		
		long start = System.nanoTime();
//		log.debug("(NOT INITIALISED)" + counter.getInstrumParams().toString());//FIXME SOFORT!
		this.counter.countMethod(
				methDesc, 			//which is instrumented //TODO refactor
				METHOD_TO_EXECUTE, 	//FIXME generalise
				new Object[]{}); 	/*nothing for run_MK*/ /*new String[0] : for main(String args[])*//*problemSize*///TODO: document, generalise
		long stop = System.nanoTime();
		long counting = stop-start;
		
		log.debug(counter.getInstrumentationParams().toString());
		log.info(counting+    "ns to count (aka \t"+
				Math.round((double) counting/1000)+"us aka \t"+
				Math.round((double) counting/1000000)+"ms aka \t"+
				Math.round((double) counting/1000000000)+"s)");
		
		CountingResult[] finalResults = resultColl.getResultsAsArray();
		log.info("Final results: "+finalResults.length);
		for(CountingResult r : finalResults) {
			resultColl.logResult(r); //from Martin
		}
		// clear all collected results
		resultColl.clearResults();
	}
}
