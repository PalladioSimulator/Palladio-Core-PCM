/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.featuremodel.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Holds ConfigState of a Feature. For a Feature it holds the actual value. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getConfigState <em>Config State</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigNode()
 * @model
 * @generated
 */
public interface ConfigNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' reference.
	 * @see #setOrigin(Feature)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigNode_Origin()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Feature getOrigin();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getOrigin <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' reference.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(Feature value);

	/**
	 * Returns the value of the '<em><b>Config State</b></em>' attribute.
	 * The default value is <code>"DEFAULT"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.featureconfig.ConfigState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * actual state for annotated Features; for FeatureGroups it is a derived attribute
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Config State</em>' attribute.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @see #setConfigState(ConfigState)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigNode_ConfigState()
	 * @model default="DEFAULT" required="true" ordered="false"
	 * @generated
	 */
	ConfigState getConfigState();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getConfigState <em>Config State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config State</em>' attribute.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @see #getConfigState()
	 * @generated
	 */
	void setConfigState(ConfigState value);
	
	boolean requiresFeaturesChecked (ConfigNode configNode, DiagnosticChain diagnostics, Map<Object, Object> context);
	boolean prohibitsFeaturesUnchecked (ConfigNode configNode, DiagnosticChain diagnostics, Map<Object, Object> context);

} // ConfigNode
