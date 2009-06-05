package de.uka.ipd.sdq.BySuite.Study;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * This class wraps the invocation of the benchmarks and executes ByCounter
 * on them. Then it compares the results.
 *
 */
public class ByCounterWrapper {
	
	/**
	 * Start the execution and comparison.
	 * @param args Not used.
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		BytecodeCounter bc = new BytecodeCounter();
		
		MethodDescriptor mdFibonacci = new MethodDescriptor("de.uka.ipd.sdq.BySuite.Study", "Fibonacci", "public final void run(int nr)");
		MethodDescriptor mdBeforePrimeDivision = new MethodDescriptor("de.uka.ipd.sdq.BySuite.Study", "PrimeDivision", "public final void beforeRun()");
		MethodDescriptor mdPrimeDivision = new MethodDescriptor("de.uka.ipd.sdq.BySuite.Study", "PrimeDivision", "public final void run(int nr)");
		
		// measure fibonacci
		bc.instrument(mdFibonacci);
		bc.execute(mdFibonacci, new Object[]{SimpleTiming.DEFAULT_PROBLEM_SIZE});
		CountingResult resultsFib = CountingResultCollector.getInstance().getAllCountingResults_nonRecursively().get(0);
		
		// clear the results
		CountingResultCollector.getInstance().clearResults();
		
		// measure prime division
		bc.instrument(mdPrimeDivision);
		bc.execute(mdBeforePrimeDivision, new Object[]{});
		bc.execute(mdPrimeDivision, new Object[]{SimpleTiming.DEFAULT_PROBLEM_SIZE});
		CountingResult resultsPrime = CountingResultCollector.getInstance().getAllCountingResults_nonRecursively().get(0);
		
		System.out.println(resultsFib);
		System.out.println(resultsPrime);
	}

}
