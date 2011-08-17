/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import LqnCore.LqnCoreFactory;
import LqnCore.ServiceType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Service Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServiceTypeTest extends TestCase {

	/**
	 * The fixture for this Service Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceType fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ServiceTypeTest.class);
	}

	/**
	 * Constructs a new Service Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceTypeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Service Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ServiceType fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Service Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceType getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LqnCoreFactory.eINSTANCE.createServiceType());
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

} //ServiceTypeTest
