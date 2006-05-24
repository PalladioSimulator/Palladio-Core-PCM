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
 * A representation of the model object '<em><b>Integer Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation#getDataField <em>Data Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage#getIntegerAnnotation()
 * @model
 * @generated
 */
public interface IntegerAnnotation extends Annotation {
	/**
	 * Returns the value of the '<em><b>Data Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Field</em>' attribute.
	 * @see #setDataField(int)
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage#getIntegerAnnotation_DataField()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getDataField();

	/**
	 * Sets the value of the '{@link AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation#getDataField <em>Data Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Field</em>' attribute.
	 * @see #getDataField()
	 * @generated
	 */
	void setDataField(int value);

} // IntegerAnnotation