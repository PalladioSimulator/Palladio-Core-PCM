/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.tests;

import de.uka.ipd.sdq.probespec.WaitingTimeCalculator;
import de.uka.ipd.sdq.probespec.probespecFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Waiting Time Calculator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WaitingTimeCalculatorTest extends BinaryCalculatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WaitingTimeCalculatorTest.class);
	}

	/**
	 * Constructs a new Waiting Time Calculator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitingTimeCalculatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Waiting Time Calculator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected WaitingTimeCalculator getFixture() {
		return (WaitingTimeCalculator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(probespecFactory.eINSTANCE.createWaitingTimeCalculator());
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

} //WaitingTimeCalculatorTest
