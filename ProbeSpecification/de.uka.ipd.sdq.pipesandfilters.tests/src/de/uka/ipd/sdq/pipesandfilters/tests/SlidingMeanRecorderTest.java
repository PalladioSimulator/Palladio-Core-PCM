/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.tests;

import de.uka.ipd.sdq.pipesandfilters.SlidingMeanRecorder;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sliding Mean Recorder</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SlidingMeanRecorderTest extends AggregationRecorderTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SlidingMeanRecorderTest.class);
	}

	/**
	 * Constructs a new Sliding Mean Recorder test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlidingMeanRecorderTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sliding Mean Recorder test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SlidingMeanRecorder getFixture() {
		return (SlidingMeanRecorder)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(pipesandfiltersFactory.eINSTANCE.createSlidingMeanRecorder());
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

} //SlidingMeanRecorderTest
