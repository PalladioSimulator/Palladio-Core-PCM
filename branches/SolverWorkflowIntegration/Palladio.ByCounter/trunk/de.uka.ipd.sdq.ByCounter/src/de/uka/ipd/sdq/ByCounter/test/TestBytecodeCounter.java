package de.uka.ipd.sdq.ByCounter.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.objectweb.asm.Opcodes;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.test.helpers.TestSubject;
import de.uka.ipd.sdq.ByCounter.test.helpers.Utils;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * This test suite tests several different usage patterns for ByCounter.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.1
 */
@RunWith(Parameterized.class)
public class TestBytecodeCounter {
	
	private static final String testCallingTreeClassName = "TestSubject";

	private static final String packageName = "de.uka.ipd.sdq.ByCounter";
	
	private static final String CLASS_PACKAGE = packageName+".test.helpers.";
	
	private static final String CLASS_NAME = "ASMBytecodeOccurences";
	
	private static final String METHOD_SIGNATURE = "public static void arrayInstructions()";
	
	private static final String CLASS_DIR = "bin" + File.separatorChar + 
						File.separatorChar + "de" + 
						File.separatorChar + "uka" +
						File.separatorChar + "ipd" +
						File.separatorChar + "sdq" +
						File.separatorChar + "ByCounter" +
						File.separatorChar + "test" +
						File.separatorChar + "helpers" + 
						File.separatorChar;
	
	private static final String resultLogFileName = "output" + File.separatorChar +"tmpLogFile.log";
	
	private static String nestedClassPackageName = "de.uka.ipd.sdq.ByCounter.test.helpers";
	
	private static String nestedClassName = "TestSubject$InnerClass$InnerClassLevel2";

	private static String nestedClassMethodSig1 = "public TestSubject$InnerClass$InnerClassLevel2()";
	private static String nestedClassMethodSig2 = "public boolean isWorking(int a)";

	private static String nestedClassRunMethodSig = "public void useInnerClassLevel2()";

	private static String testCallingTreePackageName = "de.uka.ipd.sdq.ByCounter.test.helpers";

	private static String testCallingTreeMethodSignature = "public void methodCallTest()";
	
	/**
	 * Generates the different parameters with which all tests are run.
	 * This reuses the parameters from TestASMBytecodes.parameterSetup().
	 * @return The parameter collection for calling the test constructor.
	 * @see TestASMBytecodes.parameterSetup()
	 */
	@SuppressWarnings({ "unchecked"})
	@Parameters
	public static Collection parameterSetup() {
		return TestASMBytecodes.parameterSetup();
	}
	
	private InstrumentationParameters instrumentationParameters;
	
	private static String testClassName = TestSubject.class.getCanonicalName();

	/**
	 * This constructor is used by the Parametrized runner 
	 * for running tests with different parameters.
	 * @param params {@link InstrumentationParameters} for the counting setup.
	 */
	public TestBytecodeCounter(InstrumentationParameters params) {
		// create a BytecodeCounter
		this.instrumentationParameters = params;
	}
	
	@After
	public void cleanResults() {
		// clear all collected results
		CountingResultCollector.getInstance().clearResults();
	}
	
	/**
	 * This unit test tries to instrument a class that is given as byte[].
	 * In this case the .class file of ASMBytecodeOccurences is used.
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
		BytecodeCounter counter = new BytecodeCounter();
		Assert.assertNotNull(counter);
		counter.setClassToInstrument(bytes);
		counter.setInstrumentationParams(this.instrumentationParameters);
		
		// do the de.uka.ipd.sdq.ByCount
		// let the counter do its work on a method
		counter.instrument(new MethodDescriptor(testClassName, METHOD_SIGNATURE));

		
		Assert.assertNotNull(resultColl.getAllCountingResults_nonRecursively());
		// print the results into the log
		for(CountingResult r : resultColl.getAllCountingResults_nonRecursively()) {
			Assert.assertNotSame(r.getOpcodeCounts().size(), 0);
			resultColl.logResult(r, true, true);
		}
		// clear all collected results
		resultColl.clearResults();

	}
	
	/**TODO: This test does no tests yet
	 * This test uses the instrumenter on the method methodTest(),
	 * which is a method that calls other methods of the Test class.
	 * It is then tested whether the results calculated by 
	 * {@link CountingResultCollector} are sane.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCallingTreeResults() {
		BytecodeCounter counter = new BytecodeCounter();
		counter.setInstrumentationParams(this.instrumentationParameters);
		// instrument the methodCallTest
		// flat results
		MethodDescriptor methodDescriptorMCT = 
			new MethodDescriptor(testCallingTreePackageName, testCallingTreeClassName, 
				testCallingTreeMethodSignature);
		MethodDescriptor methodDescriptorLT = 
			new MethodDescriptor(testCallingTreePackageName, testCallingTreeClassName, 
					"public int loopTest()");
		MethodDescriptor methodDescriptorPT =  
			new MethodDescriptor(testCallingTreePackageName, testCallingTreeClassName, 
			"public void printTest()");
		
		ArrayList<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
		methodsToInstrument.add(methodDescriptorMCT);
		methodsToInstrument.add(methodDescriptorLT);
		methodsToInstrument.add(methodDescriptorPT);
		this.instrumentationParameters.setMethodsToInstrument(methodsToInstrument);
		// FIXME: The following does not work
//		counter.instrument(methodDescriptorMCT);
//		counter.instrument(methodDescriptorLT);
		counter.instrument();
		counter.execute(methodDescriptorMCT, new Object[0]);

		CountingResult[] countingResults = 
			CountingResultCollector.getInstance().getAllCountingResultsAsArray(false);
		Assert.assertTrue("Could not get any counting results.", countingResults.length > 0);
		CountingResult r1 = countingResults[countingResults.length-1];	// last is methodCallTest
		CountingResultCollector.getInstance().logResult(r1, true, true);
		CountingResultCollector.getInstance().clearResults();
		// calling tree results
		counter.execute(methodDescriptorMCT, new Object[0]);
		
		countingResults = CountingResultCollector.getInstance().getAllCountingResultsAsArray(true);
		CountingResult r2 = countingResults[countingResults.length-1];
		CountingResultCollector.getInstance().logResult(r2, true, true);
	}

	/**
	 * Test for writing to log file instead of using CountingResultCollector.
	 */
	@Test
	public void testDirectResultWriting() {
		// create a BytecodeCounter
		BytecodeCounter counter = new BytecodeCounter();
		Assert.assertNotNull(counter);
		counter.setInstrumentationParams(this.instrumentationParameters);
		
		// disable usage of result collector
		Assert.assertNotNull(counter.getInstrumentationParams());
		boolean oldUseResultCollector = 
			counter.getInstrumentationParams().getUseResultCollector();
		counter.getInstrumentationParams().setUseResultCollector(false);
		Assert.assertEquals(false, counter.getInstrumentationParams().getUseResultCollector());
		
		// set the file name for the result log
		String oldResultLogFileName = 
			counter.getInstrumentationParams().getResultLogFileName();
		counter.getInstrumentationParams().setResultLogFileName(resultLogFileName);
		boolean oldUseArrayParameterRecording = 
			counter.getInstrumentationParams().getUseArrayParameterRecording();
		counter.getInstrumentationParams().setUseArrayParameterRecording(true);
		Assert.assertEquals(resultLogFileName, counter.getInstrumentationParams().getResultLogFileName());


		// test with void method
		MethodDescriptor methodDescriptor = new MethodDescriptor(
				testClassName, "public void methodCallTest()");
		counter.instrument(methodDescriptor);
		counter.execute(methodDescriptor, new Object[]{});
		

		// check whether a file was written
		File f = new File(resultLogFileName);
		Assert.assertTrue("No log file was created.", f.exists());
		Assert.assertTrue("Created file is empty.", f.length() > 0);
		
		// remove file again
		if(f.exists()) {
			f.delete();
		}
		cleanResults();

		// test with boolean method
		methodDescriptor = new MethodDescriptor(testClassName, 
			"public boolean parameterTest(int i, float f, java.lang.String s)");
		counter.instrument(methodDescriptor);
		counter.execute(methodDescriptor, 
			new Object[]{2, 2, testCallingTreeClassName});
		
		// check whether a file was written
		f = new File(resultLogFileName);
		Assert.assertTrue("No log file was created.", f.exists());
		Assert.assertTrue("Created file is empty.", f.length() > 0);
		
		// remove file again
		if(f.exists()) {
			f.delete();
		}
		
		// reset to old instrumentation parameters
		instrumentationParameters.setUseResultCollector(oldUseResultCollector);
		instrumentationParameters.setResultLogFileName(oldResultLogFileName);
		instrumentationParameters.setUseArrayParameterRecording(oldUseArrayParameterRecording);
	}
	
	/**
	 * This test uses the instrumenter on inner classes using the classfile 
	 * overwriting option which is important as 
	 * nested classes follow a special .class file naming scheme.
	 */
	@Test
	public void testNestedClassInstrumentation() {
		BytecodeCounter counter = new BytecodeCounter();
		counter.setInstrumentationParams(this.instrumentationParameters);
		// instrument the constructor of the nested class
		CountingResult r = Utils.getCountingResultForTest(
				counter,
				MethodDescriptor.forConstructor(nestedClassPackageName, nestedClassName, 
						nestedClassMethodSig1),
				new MethodDescriptor(nestedClassPackageName, testCallingTreeClassName, nestedClassRunMethodSig));

		CountingResultCollector.getInstance().logResult(r, true, true);
		
		cleanResults();
		
		// instrument the method of the nested class
		r = Utils.getCountingResultForTest(
				counter,
				new MethodDescriptor(nestedClassPackageName, nestedClassName, 
						nestedClassMethodSig2),
				new MethodDescriptor(nestedClassPackageName, testCallingTreeClassName, nestedClassRunMethodSig));

		CountingResultCollector.getInstance().logResult(r, true, true);
	}
	
	/**
	 * Tests for counting a method section defined by line numbers.
	 * WARNING: This depends on the EXACT line numbers in ASMBytecodeOccurences.
	 *
	 */
	@Test
	public void testSectionCounting() {
		// make sure only a section gets counted:
		int oldStartLine = this.instrumentationParameters.getStartLine();
		int oldStopLine = this.instrumentationParameters.getStopLine();
		this.instrumentationParameters.setStartLine(52);
		this.instrumentationParameters.setStopLine(57);
		
		BytecodeCounter counter = new BytecodeCounter();
		counter.setInstrumentationParams(this.instrumentationParameters);
		CountingResult r = Utils.getCountingResultForTest(
				counter,
				new MethodDescriptor(CLASS_PACKAGE + CLASS_NAME, 
						"public static void arrayInstructions()"));

		Assert.assertEquals(1, Utils.getOpcCount(r, Opcodes.CALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, Opcodes.CASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, Opcodes.DALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, Opcodes.DASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, Opcodes.FALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, Opcodes.FASTORE));

		// make sure that no other opcodes are counted
		// the expected number is calculated as follows:
		// the asserted opcodes as above (6) +
		// ICONST_0 for assignment and accessing of array[0]
		// ICONST_1 for assignment at index 1
		// ICONST_2 for array size
		// BIPUSH, LDC
		// FCONST_1, FCONST_2, DCONST_1 (dstore_2 does not exist -> ldc 2.0)
		// ALOAD, ASTORE for loading/ array objects
		// ISTORE, FSTORE, DSTORE for storing the values loaded from the arrays
		// DUP, NEWARRAY
		Assert.assertEquals(6+15, r.getOpcodeCounts().size());
		CountingResultCollector.getInstance().logResult(r, true, true);

		// reset to old settings
		this.instrumentationParameters.setStartLine(oldStartLine);
		this.instrumentationParameters.setStartLine(oldStopLine);
	}
}
