/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.tests;

import de.uka.ipd.sdq.ByBench.ByBenchFactory;
import de.uka.ipd.sdq.ByBench.ScenarioPrecondition;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Scenario Precondition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScenarioPreconditionTest extends InstructionSequenceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ScenarioPreconditionTest.class);
	}

	/**
	 * Constructs a new Scenario Precondition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioPreconditionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Scenario Precondition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ScenarioPrecondition getFixture() {
		return (ScenarioPrecondition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ByBenchFactory.eINSTANCE.createScenarioPrecondition());
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

} //ScenarioPreconditionTest
