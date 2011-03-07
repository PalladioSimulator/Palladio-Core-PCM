/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Lqn</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class LqnAllTests extends TestSuite {

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
		TestSuite suite = new LqnAllTests("Lqn Tests");
		suite.addTest(LqnCoreTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LqnAllTests(String name) {
		super(name);
	}

} //LqnAllTests
