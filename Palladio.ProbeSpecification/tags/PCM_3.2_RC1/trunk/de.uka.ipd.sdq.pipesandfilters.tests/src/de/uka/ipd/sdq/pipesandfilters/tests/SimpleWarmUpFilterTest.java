/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.tests;

import de.uka.ipd.sdq.pipesandfilters.SimpleWarmUpFilter;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Simple Warm Up Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleWarmUpFilterTest extends FilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimpleWarmUpFilterTest.class);
	}

	/**
	 * Constructs a new Simple Warm Up Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleWarmUpFilterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Simple Warm Up Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SimpleWarmUpFilter getFixture() {
		return (SimpleWarmUpFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(pipesandfiltersFactory.eINSTANCE.createSimpleWarmUpFilter());
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

} //SimpleWarmUpFilterTest
