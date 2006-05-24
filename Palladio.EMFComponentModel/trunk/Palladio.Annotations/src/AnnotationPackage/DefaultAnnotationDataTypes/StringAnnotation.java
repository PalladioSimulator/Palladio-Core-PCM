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
 * A representation of the model object '<em><b>String Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation#getDataField <em>Data Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage#getStringAnnotation()
 * @model
 * @generated
 */
public interface StringAnnotation extends Annotation {
	/**
	 * Returns the value of the '<em><b>Data Field</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Field</em>' attribute.
	 * @see #setDataField(String)
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage#getStringAnnotation_DataField()
	 * @model default="" unique="false" required="true"
	 * @generated
	 */
	String getDataField();

	/**
	 * Sets the value of the '{@link AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation#getDataField <em>Data Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Field</em>' attribute.
	 * @see #getDataField()
	 * @generated
	 */
	void setDataField(String value);

} // StringAnnotation