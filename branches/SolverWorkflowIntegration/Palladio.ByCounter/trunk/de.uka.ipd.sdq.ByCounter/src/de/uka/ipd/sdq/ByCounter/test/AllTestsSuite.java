package de.uka.ipd.sdq.ByCounter.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.log4j.PropertyConfigurator;

/**
 * Test suite that contains all tests for ByCounter.
 * This makes running all tests at once simpler.
 * NOTE: When some tests fail due to heap space issues, try to add 
 * the VM option "-Xmx192M". Also, the option "-Xss1M" for more stack 
 * size might be necessary for some tests.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class AllTestsSuite {

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
