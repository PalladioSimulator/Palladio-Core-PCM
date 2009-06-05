package de.uka.ipd.sdq.ByCounter.test;

import com.sun.org.apache.regexp.internal.recompile;

import junit.framework.Assert;
import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * A collection of tool functions that are used by more than one unit test. 
* @author Martin Krogmann
* @author Michael Kuperberg
* @since 0.9
* @version 0.9
*/
public class Utils {

	/**
	 * Gets the count for the given opcode in the given result.
	 * Has asserts for the result not being null.
	 * @param r Result containing opcode counts.
	 * @param opcode Opcode to get the count for.
	 * @return Count for the given opcode as defined in the result.
	 */
	public static int getOpcCount(CountingResult r, int opcode) {
		Assert.assertNotNull(r);
		Assert.assertNotNull(r.getOpcodeCounts());
		Assert.assertNotNull(r.getOpcodeCounts().get(opcode));
		
		return r.getOpcodeCounts().get(opcode).intValue();
	}

	/**
	 * Gets the results from CountingResultCollector, assures (asserts) 
	 * that there is only one and then returns that.
	 * @param recursive As in {@link CountingResultCollector}.getResult. 
	 */
	public static CountingResult getAssertedResult(boolean recursive) {
		CountingResult[] r = CountingResultCollector.getInstance().getResultsAsArray(recursive);
		Assert.assertEquals(1, r.length);
		return r[0];
	}

	/**
	 * Instruments the test method with name methodToInstrument, runs it and returns the
	 * opcode counts.
	 * @param c BytecodeCounter to use for counting.
	 * @param methodToInstrument The method to instrument.
	 * @return The de.uka.ipd.sdq.ByCount result.
	 */
	public static CountingResult getCountingResultForTest(BytecodeCounter c, 
			MethodDescriptor methodToInstrument) {
		return getCountingResultForTest(c, methodToInstrument, methodToInstrument, false);
	}

	/**
	 * Instruments the test method with name methodToInstrument, runs it and returns the
	 * opcode counts.
	 * @param c BytecodeCounter to use for counting.
	 * @param methodToInstrument The method to instrument.
	 * @param recursive Get recursive (calling tree respecting) result? See CountingResultCollector.
	 * @return The de.uka.ipd.sdq.ByCount result.
	 */
	public static CountingResult getCountingResultForTest(BytecodeCounter c, 
			MethodDescriptor methodToInstrument, 
			boolean recursive) {
		return getCountingResultForTest(c, methodToInstrument, methodToInstrument, recursive);
	}
	

	/**
	 * Instruments the test method with name methodToInstrument, runs the
	 * method with the name methodToExecute and returns the
	 * opcode counts.
	 * @param c BytecodeCounter to use for counting.
	 * @param methodToInstrument The method to instrument.
	 * @param methodToExecute The method to execute. 
	 * @return The de.uka.ipd.sdq.ByCount result.
	 */
	public static CountingResult getCountingResultForTest(BytecodeCounter c, 
			MethodDescriptor methodToInstrument,
			MethodDescriptor methodToExecute) {
		return getCountingResultForTest(c, methodToInstrument, methodToExecute, false);
	}

	/**
	 * Instruments the test method with name methodToInstrument, runs the
	 * method with the name methodToExecute and returns the
	 * opcode counts.
	 * @param c BytecodeCounter to use for counting.
	 * @param methodToInstrument The method to instrument.
	 * @param methodToExecute The method to execute.
	 * @param recursive Get recursive (calling tree respecting) result? See CountingResultCollector. 
	 * @return The de.uka.ipd.sdq.ByCount result.
	 */
	public static CountingResult getCountingResultForTest(BytecodeCounter c, 
			MethodDescriptor methodToInstrument,
			MethodDescriptor methodToExecute, 
			boolean recursive) {
		c.instrument(methodToInstrument);
		c.execute(methodToExecute, new Object[0]);
	
		CountingResult r = getAssertedResult(recursive);
		//resultCollector.logResult(r);
		return r;
	}

}
