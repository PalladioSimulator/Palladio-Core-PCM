package de.uka.ipd.sdq.ByCounter.test;

import org.apache.log4j.PropertyConfigurator;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Test suite that contains all tests for ByCounter.
 * This makes running all tests at once simpler.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class TestSuiteAllTests {

	public static Test suite() {
		PropertyConfigurator.configure("log4j.properties");
		
		TestSuite suite = new TestSuite(
				"Test for de.uka.ipd.sdq.ByCounter.test");
		//$JUnit-BEGIN$
		//$JUnit-END$
		
		// Manually added tests:
		suite.addTest(new JUnit4TestAdapter(TestASMBytecodes.class));
		suite.addTest(new JUnit4TestAdapter(TestBytecodeCounter.class));
		suite.addTest(new JUnit4TestAdapter(TestMethodDescriptor.class));
		
		return suite;
	}

}
