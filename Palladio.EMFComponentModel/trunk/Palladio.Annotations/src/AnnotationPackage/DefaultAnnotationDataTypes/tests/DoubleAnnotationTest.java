/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.tests;

import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesFactory;
import AnnotationPackage.DefaultAnnotationDataTypes.DoubleAnnotation;

import AnnotationPackage.tests.AnnotationTest;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Double Annotation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DoubleAnnotationTest extends AnnotationTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DoubleAnnotationTest.class);
	}

	/**
	 * Constructs a new Double Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Double Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DoubleAnnotation getFixture() {
		return (DoubleAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(DefaultAnnotationDataTypesFactory.eINSTANCE.createDoubleAnnotation());
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

} //DoubleAnnotationTest
