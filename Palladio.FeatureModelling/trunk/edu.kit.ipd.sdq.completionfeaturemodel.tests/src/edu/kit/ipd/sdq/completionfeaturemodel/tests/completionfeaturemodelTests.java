/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>completionfeaturemodel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class completionfeaturemodelTests extends TestSuite {

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
		TestSuite suite = new completionfeaturemodelTests("completionfeaturemodel Tests");
		suite.addTestSuite(CompletionFeatureTest.class);
		suite.addTestSuite(CompletionFeatureDiagramTest.class);
		suite.addTestSuite(CompletionSimpleTest.class);
		suite.addTestSuite(CompletionFeatureGroupTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public completionfeaturemodelTests(String name) {
		super(name);
	}

} //completionfeaturemodelTests
