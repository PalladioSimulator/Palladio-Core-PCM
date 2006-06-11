/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.tests;

import AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation;
import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesFactory;

import AnnotationPackage.tests.AnnotationTest;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Boolean Annotation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BooleanAnnotationTest extends AnnotationTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BooleanAnnotationTest.class);
	}

	/**
	 * Constructs a new Boolean Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Boolean Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BooleanAnnotation getFixture() {
		return (BooleanAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(DefaultAnnotationDataTypesFactory.eINSTANCE.createBooleanAnnotation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //BooleanAnnotationTest
