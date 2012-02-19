/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import de.uka.ipd.sdq.featuremodel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.AttributeValue#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.AttributeValue#getConfignode <em>Confignode</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getAttributeValue()
 * @model abstract="true"
 * @generated
 */
public interface AttributeValue extends NamedElement {
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
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getAttributeValue_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.AttributeValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Confignode</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getAttributevalue <em>Attributevalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confignode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confignode</em>' container reference.
	 * @see #setConfignode(ConfigNode)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getAttributeValue_Confignode()
	 * @see de.uka.ipd.sdq.featureconfig.ConfigNode#getAttributevalue
	 * @model opposite="attributevalue" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ConfigNode getConfignode();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.AttributeValue#getConfignode <em>Confignode</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confignode</em>' container reference.
	 * @see #getConfignode()
	 * @generated
	 */
	void setConfignode(ConfigNode value);

} // AttributeValue
