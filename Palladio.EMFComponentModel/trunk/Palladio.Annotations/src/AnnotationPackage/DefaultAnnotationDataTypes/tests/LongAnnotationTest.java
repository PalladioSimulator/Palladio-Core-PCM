/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.tests;

import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesFactory;
import AnnotationPackage.DefaultAnnotationDataTypes.LongAnnotation;

import AnnotationPackage.tests.AnnotationTest;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Long Annotation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LongAnnotationTest extends AnnotationTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LongAnnotationTest.class);
	}

	/**
	 * Constructs a new Long Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Long Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private LongAnnotation getFixture() {
		return (LongAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(DefaultAnnotationDataTypesFactory.eINSTANCE.createLongAnnotation());
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

} //LongAnnotationTest
