/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.tests;

import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesFactory;
import AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation;

import AnnotationPackage.tests.AnnotationTest;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Annotation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntegerAnnotationTest extends AnnotationTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerAnnotationTest.class);
	}

	/**
	 * Constructs a new Integer Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IntegerAnnotation getFixture() {
		return (IntegerAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(DefaultAnnotationDataTypesFactory.eINSTANCE.createIntegerAnnotation());
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

} //IntegerAnnotationTest
