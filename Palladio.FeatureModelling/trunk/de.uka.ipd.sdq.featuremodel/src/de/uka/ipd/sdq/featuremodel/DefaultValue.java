/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getDefaultValue()
 * @model
 * @generated
 */
public interface DefaultValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getDefaultValue_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getDefaultValue_Type()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	AttributeTypes getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(AttributeTypes value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.Attribute#getDefaultvalue <em>Defaultvalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' container reference.
	 * @see #setAttribute(Attribute)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getDefaultValue_Attribute()
	 * @see de.uka.ipd.sdq.featuremodel.Attribute#getDefaultvalue
	 * @model opposite="defaultvalue" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Attribute getAttribute();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getAttribute <em>Attribute</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' container reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(Attribute value);

} // DefaultValue
