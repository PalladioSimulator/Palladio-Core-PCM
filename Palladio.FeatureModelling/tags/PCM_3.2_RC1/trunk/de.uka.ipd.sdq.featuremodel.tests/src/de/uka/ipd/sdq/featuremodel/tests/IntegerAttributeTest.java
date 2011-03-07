/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.tests;

import junit.textui.TestRunner;
import de.uka.ipd.sdq.featuremodel.IntegerAttribute;
import de.uka.ipd.sdq.featuremodel.featuremodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Attribute</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntegerAttributeTest extends AttributeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerAttributeTest.class);
	}

	/**
	 * Constructs a new Integer Attribute test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAttributeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Attribute test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IntegerAttribute getFixture() {
		return (IntegerAttribute)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(featuremodelFactory.eINSTANCE.createIntegerAttribute());
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

} //IntegerAttributeTest
