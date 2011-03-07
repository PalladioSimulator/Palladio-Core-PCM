/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>featureconfig</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class featureconfigTests extends TestSuite {

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
		TestSuite suite = new featureconfigTests("featureconfig Tests");
		suite.addTestSuite(ConfigNodeTest.class);
		suite.addTestSuite(FeatureConfigTest.class);
		suite.addTestSuite(IntegerAttributeValueTest.class);
		suite.addTestSuite(DoubleAttributeValueTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featureconfigTests(String name) {
		super(name);
	}

} //featureconfigTests
