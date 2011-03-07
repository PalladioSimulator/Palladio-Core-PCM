/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>pipesandfilters</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class pipesandfiltersTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new pipesandfiltersTests("pipesandfilters Tests");
		suite.addTestSuite(RawRecorderTest.class);
		suite.addTestSuite(SimpleWarmUpFilterTest.class);
		suite.addTestSuite(SlidingMeanRecorderTest.class);
		suite.addTestSuite(EDP2WriterTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pipesandfiltersTests(String name) {
		super(name);
	}

} //pipesandfiltersTests
