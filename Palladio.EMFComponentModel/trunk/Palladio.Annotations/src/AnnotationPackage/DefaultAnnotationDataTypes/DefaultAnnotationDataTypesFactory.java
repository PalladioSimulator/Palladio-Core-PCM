/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage
 * @generated
 */
public interface DefaultAnnotationDataTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DefaultAnnotationDataTypesFactory eINSTANCE = AnnotationPackage.DefaultAnnotationDataTypes.impl.DefaultAnnotationDataTypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Boolean Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Annotation</em>'.
	 * @generated
	 */
	BooleanAnnotation createBooleanAnnotation();

	/**
	 * Returns a new object of class '<em>Double Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Annotation</em>'.
	 * @generated
	 */
	DoubleAnnotation createDoubleAnnotation();

	/**
	 * Returns a new object of class '<em>Integer Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Annotation</em>'.
	 * @generated
	 */
	IntegerAnnotation createIntegerAnnotation();

	/**
	 * Returns a new object of class '<em>Long Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Annotation</em>'.
	 * @generated
	 */
	LongAnnotation createLongAnnotation();

	/**
	 * Returns a new object of class '<em>Short Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Short Annotation</em>'.
	 * @generated
	 */
	ShortAnnotation createShortAnnotation();

	/**
	 * Returns a new object of class '<em>String Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Annotation</em>'.
	 * @generated
	 */
	StringAnnotation createStringAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DefaultAnnotationDataTypesPackage getDefaultAnnotationDataTypesPackage();

} //DefaultAnnotationDataTypesFactory
