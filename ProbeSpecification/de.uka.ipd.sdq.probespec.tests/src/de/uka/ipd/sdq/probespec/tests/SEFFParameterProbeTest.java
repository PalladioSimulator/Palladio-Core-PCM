/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.tests;

import de.uka.ipd.sdq.probespec.SEFFParameterProbe;
import de.uka.ipd.sdq.probespec.probespecFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SEFF Parameter Probe</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SEFFParameterProbeTest extends ProbeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SEFFParameterProbeTest.class);
	}

	/**
	 * Constructs a new SEFF Parameter Probe test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEFFParameterProbeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SEFF Parameter Probe test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SEFFParameterProbe getFixture() {
		return (SEFFParameterProbe)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(probespecFactory.eINSTANCE.createSEFFParameterProbe());
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

} //SEFFParameterProbeTest
