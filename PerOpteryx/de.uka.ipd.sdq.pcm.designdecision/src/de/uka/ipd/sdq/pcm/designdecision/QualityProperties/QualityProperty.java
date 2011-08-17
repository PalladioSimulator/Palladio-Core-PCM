/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties;


import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quality Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityProperty#getQualityValue <em>Quality Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage#getQualityProperty()
 * @model abstract="true"
 * @generated
 */
public interface QualityProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Quality Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Value</em>' attribute.
	 * @see #setQualityValue(Object)
	 * @see de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage#getQualityProperty_QualityValue()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Object getQualityValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityProperty#getQualityValue <em>Quality Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Value</em>' attribute.
	 * @see #getQualityValue()
	 * @generated
	 */
	void setQualityValue(Object value);

} // QualityProperty
