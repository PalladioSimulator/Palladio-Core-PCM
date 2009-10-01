/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>probespec</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class probespecTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new probespecTests("probespec Tests");
		suite.addTestSuite(PassiveResourceCalculatorTest.class);
		suite.addTestSuite(ProbeSetTest.class);
		suite.addTestSuite(PassiveResourceStateProbeTest.class);
		suite.addTestSuite(StoExProbeTest.class);
		suite.addTestSuite(SEFFParameterProbeTest.class);
		suite.addTestSuite(CurrentTimeProbeTest.class);
		suite.addTestSuite(StoExCalculatorTest.class);
		suite.addTestSuite(SEFFParameterCalculatorTest.class);
		suite.addTestSuite(ResponseTimeCalculatorTest.class);
		suite.addTestSuite(WaitingTimeCalculatorTest.class);
		suite.addTestSuite(CPUStateProbeTest.class);
		suite.addTestSuite(HDDStateProbeTest.class);
		suite.addTestSuite(CPUDemandProbeTest.class);
		suite.addTestSuite(HDDDemandProbeTest.class);
		suite.addTestSuite(HDDStateCalculatorTest.class);
		suite.addTestSuite(CPUStateCalculatorTest.class);
		suite.addTestSuite(CPUDemandCalculatorTest.class);
		suite.addTestSuite(HDDDemandCalculatorTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probespecTests(String name) {
		super(name);
	}

} //probespecTests
