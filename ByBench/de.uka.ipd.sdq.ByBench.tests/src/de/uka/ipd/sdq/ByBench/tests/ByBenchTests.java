/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>ByBench</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ByBenchTests extends TestSuite {

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
		TestSuite suite = new ByBenchTests("ByBench Tests");
		suite.addTestSuite(ScenarioTest.class);
		suite.addTestSuite(ScenarioPreconditionTest.class);
		suite.addTestSuite(InstructionSequenceTest.class);
		suite.addTestSuite(SequenceElementTest.class);
		suite.addTestSuite(MeasurementStartTest.class);
		suite.addTestSuite(ScenarioCoreTest.class);
		suite.addTestSuite(MeasurementEndTest.class);
		suite.addTestSuite(ScenarioPostconditionTest.class);
		suite.addTestSuite(NamedCardinalityTest.class);
		suite.addTestSuite(InstructionChainingTest.class);
		suite.addTestSuite(InstructionLoopingTest.class);
		suite.addTestSuite(AtomicInstructionTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByBenchTests(String name) {
		super(name);
	}

} //ByBenchTests
