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
 * A test suite for the '<em><b>LqnCore</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class LqnCoreTests extends TestSuite {

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
		TestSuite suite = new LqnCoreTests("LqnCore Tests");
		suite.addTestSuite(ActivityDefTypeTest.class);
		suite.addTestSuite(ActivityPhasesTypeTest.class);
		suite.addTestSuite(DocumentRootTest.class);
		suite.addTestSuite(EntryActivityDefTypeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LqnCoreTests(String name) {
		super(name);
	}

} //LqnCoreTests
