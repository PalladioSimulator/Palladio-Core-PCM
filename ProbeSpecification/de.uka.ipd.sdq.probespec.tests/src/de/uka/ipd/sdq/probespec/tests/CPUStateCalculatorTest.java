/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.tests;

import de.uka.ipd.sdq.probespec.CPUStateCalculator;
import de.uka.ipd.sdq.probespec.probespecFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CPU State Calculator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CPUStateCalculatorTest extends UnaryCalculatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CPUStateCalculatorTest.class);
	}

	/**
	 * Constructs a new CPU State Calculator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPUStateCalculatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this CPU State Calculator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CPUStateCalculator getFixture() {
		return (CPUStateCalculator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(probespecFactory.eINSTANCE.createCPUStateCalculator());
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

} //CPUStateCalculatorTest
