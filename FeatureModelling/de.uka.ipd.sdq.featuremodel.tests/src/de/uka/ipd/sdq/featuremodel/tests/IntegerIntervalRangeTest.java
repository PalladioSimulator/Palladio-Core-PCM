/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.tests;

import junit.textui.TestRunner;
import de.uka.ipd.sdq.featuremodel.IntegerIntervalRange;
import de.uka.ipd.sdq.featuremodel.featuremodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Interval Range</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntegerIntervalRangeTest extends IntervalRangeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerIntervalRangeTest.class);
	}

	/**
	 * Constructs a new Integer Interval Range test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerIntervalRangeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Interval Range test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IntegerIntervalRange getFixture() {
		return (IntegerIntervalRange)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(featuremodelFactory.eINSTANCE.createIntegerIntervalRange());
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

} //IntegerIntervalRangeTest
