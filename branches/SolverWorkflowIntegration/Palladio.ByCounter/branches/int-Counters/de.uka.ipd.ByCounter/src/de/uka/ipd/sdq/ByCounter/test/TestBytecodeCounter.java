package de.uka.ipd.sdq.ByCounter.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * This unit test tries to instrument a class that is given as byte[].
 * In this case the .class file of ASMBytecodeOccurences is used.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.1
 */
public class TestBytecodeCounter {
	
	private static final String packageName = "de.uka.ipd.sdq.ByCount.execution";
	private static final String CLASS_PACKAGE = packageName+".unittests.";
	private static final String CLASS_NAME = "ASMBytecodeOccurences";
	private static final String METHOD_SIGNATURE = "public static void arrayInstructions()";
	private static final String CLASS_DIR = "bin" + File.separatorChar + 
						File.separatorChar + "de" + 
						File.separatorChar + "uka" +
						File.separatorChar + "ipd" +
						File.separatorChar + "sdq" +
						File.separatorChar + "ByCounter" +
						File.separatorChar + "test" + 
						File.separatorChar;


	
	/**
	 * Test for the instrumentation of a byte array.
	 *
	 */
	@Test
	public void testByteClass() {		
		File file = new File(CLASS_DIR + CLASS_NAME + ".class");
		FileInputStream fs = null;
		
		// create a file stream for the test .class data
		try {
			fs = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		// get the data into a Byte[] array.
		ArrayList<Byte> bytelist = new ArrayList<Byte>();
		try {
			while(fs.available() > 0) {
				bytelist.add((byte)fs.read());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Byte[] bytesBig = bytelist.toArray(new Byte[bytelist.size()]);

		// get the data from the Byte[] array into the byte[] array.
		byte[] bytes = new byte[bytelist.size()];
		for(int i = 0; i < bytesBig.length; i++) {
			bytes[i] = bytesBig[i].byteValue();
		}
		
		// early CountingResultCollector construction; initialize the singleton
		CountingResultCollector resultColl = CountingResultCollector.getInstance();
		
		Assert.assertNotNull(resultColl);
		
		// create a BytecodeCounter
		BytecodeCounter counter = new BytecodeCounter(bytes, CLASS_PACKAGE + CLASS_NAME);
		Assert.assertNotNull(counter);
		
		// do the de.uka.ipd.sdq.ByCount
		// let the counter do its work on a method
		counter.countParameterlessMethod(new MethodDescriptor(METHOD_SIGNATURE));

		
		Assert.assertNotNull(resultColl.getResults());
		// print the results into the log
		for(CountingResult r : resultColl.getResults()) {
			Assert.assertNotSame(r.getOpcodeCounts().size(), 0);
			resultColl.logResult(r);
		}
		// clear all collected results
		resultColl.clearResults();

	}

	private static String testClassName = de.uka.ipd.sdq.ByCounter.test.Test.class.getCanonicalName();
	private static final String resultLogFileName = "ByCounter output" + File.separatorChar +"tmpLogFile.log";
	/**
	 * Test for writing to log file instead of using CountingResultCollector.
	 */
	@Test
	public void testDirectResultWriting() {
		// create a BytecodeCounter
		BytecodeCounter counter = new BytecodeCounter(testClassName);
		Assert.assertNotNull(counter);
		Assert.assertNotNull(counter.getInstrumentationParams());
		counter.getInstrumentationParams().setUseResultCollector(false);
		Assert.assertEquals(false, counter.getInstrumentationParams().getUseResultCollector());
		counter.getInstrumentationParams().setResultLogFileName(resultLogFileName);
		counter.getInstrumentationParams().setUseArrayParameterRecording(true);
		Assert.assertEquals(resultLogFileName, counter.getInstrumentationParams().getResultLogFileName());


		// test with void method
		counter.countMethod(new MethodDescriptor(
				"public void methodCallTest()"), 
			new Object[]{});
		

		// check whether a file was written
		File f = new File(resultLogFileName);
		Assert.assertTrue("No log file was created.", f.exists());
		Assert.assertTrue("Created file is empty.", f.length() > 0);
		
		// remove file again
		if(f.exists()) {
			f.delete();
		}

		// test with boolean method
		counter.countMethod(new MethodDescriptor(
		"public boolean parameterTest(int i, float f, java.lang.String s)"), 
			new Object[]{2, 2, "Test"});
		
		// check whether a file was written
		f = new File(resultLogFileName);
		Assert.assertTrue("No log file was created.", f.exists());
		Assert.assertTrue("Created file is empty.", f.length() > 0);
		
		// remove file again
		if(f.exists()) {
			f.delete();
		}
	}
}
