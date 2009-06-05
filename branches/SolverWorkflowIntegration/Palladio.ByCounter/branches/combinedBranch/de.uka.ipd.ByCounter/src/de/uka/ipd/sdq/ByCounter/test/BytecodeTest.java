package de.uka.ipd.sdq.ByCounter.test;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * Tests for bytecode instrumentation.
 * Demonstrates how to use the BytecodeCounter.

 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class BytecodeTest {
	
	private static String testClassName = "de.uka.ipd.sdq.ByCounter.test.Test";//Test.class.getCanonicalName();
	
	
	/**
	 * Test application entry point.
	 * @param args No arguments needed.
	 */
	public static void main(String[] args) {

		// early CountingResultCollector construction; initialize the singleton
		CountingResultCollector resultColl = CountingResultCollector.getInstance();
		// create a BytecodeCounter
		BytecodeCounter counter = new BytecodeCounter();
		
		
		// do the de.uka.ipd.sdq.ByCount
		// let the counter do its work
		MethodDescriptor methodDescriptor = 
			new MethodDescriptor(testClassName, "public void printTest()");
		counter.instrument(methodDescriptor);
		counter.execute(methodDescriptor, 
				new Object[]{});
		methodDescriptor = new MethodDescriptor(testClassName, 
			"public boolean parameterTest(int i, float f, java.lang.String s)");
		counter.instrument(methodDescriptor);
		counter.execute(methodDescriptor, 
						new Object[]{2, 2, "Test"});
		methodDescriptor = new MethodDescriptor(testClassName, 
				"public void methodCallTest()");
		counter.instrument(methodDescriptor);
		counter.execute(methodDescriptor,
				new Object[]{});

		
		// print the results into the log
		for(CountingResult r : resultColl.getResults()) {
			resultColl.logResult(r);
		}
		// clear all collected results
		resultColl.clearResults();
	}
}
