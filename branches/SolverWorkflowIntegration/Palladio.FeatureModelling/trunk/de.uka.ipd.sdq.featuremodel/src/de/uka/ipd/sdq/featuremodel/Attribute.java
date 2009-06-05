/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Attribute#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.featuremodel.AttributeTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
	 * @see #setType(AttributeTypes)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getAttribute_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AttributeTypes getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Attribute#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(AttributeTypes value);

} // Attribute
