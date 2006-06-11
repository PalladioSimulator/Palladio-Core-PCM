/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.tests;

import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesFactory;
import AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation;

import AnnotationPackage.tests.AnnotationTest;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Annotation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringAnnotationTest extends AnnotationTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringAnnotationTest.class);
	}

	/**
	 * Constructs a new String Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this String Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private StringAnnotation getFixture() {
		return (StringAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(DefaultAnnotationDataTypesFactory.eINSTANCE.createStringAnnotation());
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

} //StringAnnotationTest
