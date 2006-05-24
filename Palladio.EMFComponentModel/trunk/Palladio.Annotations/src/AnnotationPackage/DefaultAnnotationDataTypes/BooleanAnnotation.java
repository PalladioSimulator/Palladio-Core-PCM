/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes;

import AnnotationPackage.Annotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation#isDataField <em>Data Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage#getBooleanAnnotation()
 * @model
 * @generated
 */
public interface BooleanAnnotation extends Annotation {
	/**
	 * Returns the value of the '<em><b>Data Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Field</em>' attribute.
	 * @see #setDataField(boolean)
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage#getBooleanAnnotation_DataField()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isDataField();

	/**
	 * Sets the value of the '{@link AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation#isDataField <em>Data Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Field</em>' attribute.
	 * @see #isDataField()
	 * @generated
	 */
	void setDataField(boolean value);

} // BooleanAnnotation