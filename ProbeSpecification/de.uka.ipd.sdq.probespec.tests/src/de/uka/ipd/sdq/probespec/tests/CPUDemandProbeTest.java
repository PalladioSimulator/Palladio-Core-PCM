/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.tests;

import de.uka.ipd.sdq.probespec.CPUDemandProbe;
import de.uka.ipd.sdq.probespec.probespecFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CPU Demand Probe</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CPUDemandProbeTest extends ProbeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CPUDemandProbeTest.class);
	}

	/**
	 * Constructs a new CPU Demand Probe test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPUDemandProbeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this CPU Demand Probe test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CPUDemandProbe getFixture() {
		return (CPUDemandProbe)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(probespecFactory.eINSTANCE.createCPUDemandProbe());
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

} //CPUDemandProbeTest
