/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>featuremodel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class featuremodelTests extends TestSuite {

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
		TestSuite suite = new featuremodelTests("featuremodel Tests");
		suite.addTestSuite(FeatureTest.class);
		suite.addTestSuite(SimpleTest.class);
		suite.addTestSuite(FeatureGroupTest.class);
		suite.addTestSuite(FeatureDiagramTest.class);
		suite.addTestSuite(RequiredConstraintTest.class);
		suite.addTestSuite(ProhibitsConstraintTest.class);
		suite.addTestSuite(IntegerAttributeTest.class);
		suite.addTestSuite(DoubleAttributeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featuremodelTests(String name) {
		super(name);
	}

} //featuremodelTests
