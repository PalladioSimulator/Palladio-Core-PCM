/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link AnnotationPackage.Annotation#getAnnotationTypeID <em>Annotation Type ID</em>}</li>
 *   <li>{@link AnnotationPackage.Annotation#isIsCalculated <em>Is Calculated</em>}</li>
 * </ul>
 * </p>
 *
 * @see AnnotationPackage.AnnotationPackagePackage#getAnnotation()
 * @model abstract="true"
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotation Type ID</b></em>' attribute.
	 * The literals are from the enumeration {@link AnnotationPackage.AnnotationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Type ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Type ID</em>' attribute.
	 * @see AnnotationPackage.AnnotationType
	 * @see AnnotationPackage.AnnotationPackagePackage#getAnnotation_AnnotationTypeID()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	AnnotationType getAnnotationTypeID();

	/**
	 * Returns the value of the '<em><b>Is Calculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Calculated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Calculated</em>' attribute.
	 * @see #setIsCalculated(boolean)
	 * @see AnnotationPackage.AnnotationPackagePackage#getAnnotation_IsCalculated()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsCalculated();

	/**
	 * Sets the value of the '{@link AnnotationPackage.Annotation#isIsCalculated <em>Is Calculated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Calculated</em>' attribute.
	 * @see #isIsCalculated()
	 * @generated
	 */
	void setIsCalculated(boolean value);

} // Annotation