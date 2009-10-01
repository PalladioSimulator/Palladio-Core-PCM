/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.tests;

import de.uka.ipd.sdq.pipesandfilters.RawRecorder;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Raw Recorder</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RawRecorderTest extends RecorderTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RawRecorderTest.class);
	}

	/**
	 * Constructs a new Raw Recorder test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawRecorderTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Raw Recorder test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RawRecorder getFixture() {
		return (RawRecorder)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(pipesandfiltersFactory.eINSTANCE.createRawRecorder());
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

} //RawRecorderTest
