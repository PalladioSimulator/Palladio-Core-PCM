/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config Feature Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Holds ConfigState of a FeatureGroup; a derived attribute is held.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ConfigFeatureGroup#getConfigStatus <em>Config Status</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ConfigFeatureGroup#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigFeatureGroup()
 * @model
 * @generated
 */
public interface ConfigFeatureGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Config Status</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.featureconfig.ConfigState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Status</em>' attribute.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigFeatureGroup_ConfigStatus()
	 * @model unique="false" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ConfigState getConfigStatus();

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' reference.
	 * @see #setOrigin(EObject)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigFeatureGroup_Origin()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getOrigin();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.ConfigFeatureGroup#getOrigin <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' reference.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(EObject value);

} // ConfigFeatureGroup
