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
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Attribute#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Attribute#getDefaultvalue <em>Defaultvalue</em>}</li>
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
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getAttribute_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Attribute#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Defaultvalue</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.DefaultValue#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defaultvalue</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defaultvalue</em>' containment reference.
	 * @see #setDefaultvalue(DefaultValue)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getAttribute_Defaultvalue()
	 * @see de.uka.ipd.sdq.featuremodel.DefaultValue#getAttribute
	 * @model opposite="attribute" containment="true" required="true" ordered="false"
	 * @generated
	 */
	DefaultValue getDefaultvalue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Attribute#getDefaultvalue <em>Defaultvalue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defaultvalue</em>' containment reference.
	 * @see #getDefaultvalue()
	 * @generated
	 */
	void setDefaultvalue(DefaultValue value);

} // Attribute
