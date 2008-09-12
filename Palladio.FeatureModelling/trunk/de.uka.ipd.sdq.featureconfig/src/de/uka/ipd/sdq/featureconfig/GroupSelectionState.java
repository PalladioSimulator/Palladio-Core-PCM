/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import de.uka.ipd.sdq.featuremodel.FeatureGroup;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Selection State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.GroupSelectionState#getFeaturegroup <em>Featuregroup</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.GroupSelectionState#getConfigStatus <em>Config Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getGroupSelectionState()
 * @model
 * @generated
 */
public interface GroupSelectionState extends EObject {
	/**
	 * Returns the value of the '<em><b>Featuregroup</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featuregroup</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featuregroup</em>' reference.
	 * @see #setFeaturegroup(FeatureGroup)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getGroupSelectionState_Featuregroup()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FeatureGroup getFeaturegroup();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.GroupSelectionState#getFeaturegroup <em>Featuregroup</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Featuregroup</em>' reference.
	 * @see #getFeaturegroup()
	 * @generated
	 */
	void setFeaturegroup(FeatureGroup value);

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
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getGroupSelectionState_ConfigStatus()
	 * @model unique="false" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ConfigState getConfigStatus();

} // GroupSelectionState
