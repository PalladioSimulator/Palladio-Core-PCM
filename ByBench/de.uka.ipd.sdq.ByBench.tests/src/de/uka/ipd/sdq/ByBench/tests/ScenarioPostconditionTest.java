/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.tests;

import de.uka.ipd.sdq.ByBench.ByBenchFactory;
import de.uka.ipd.sdq.ByBench.ScenarioPostcondition;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Scenario Postcondition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScenarioPostconditionTest extends InstructionSequenceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ScenarioPostconditionTest.class);
	}

	/**
	 * Constructs a new Scenario Postcondition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioPostconditionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Scenario Postcondition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ScenarioPostcondition getFixture() {
		return (ScenarioPostcondition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ByBenchFactory.eINSTANCE.createScenarioPostcondition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ScenarioPostconditionTest
