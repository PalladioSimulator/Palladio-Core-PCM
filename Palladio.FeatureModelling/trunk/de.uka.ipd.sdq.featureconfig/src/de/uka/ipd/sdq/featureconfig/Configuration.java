/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * External container for default and overrides config
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.Configuration#getDefaultConfig <em>Default Config</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.Configuration#getConfigOverrides <em>Config Overrides</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.Configuration#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Default Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Config</em>' containment reference.
	 * @see #setDefaultConfig(FeatureConfig)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfiguration_DefaultConfig()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	FeatureConfig getDefaultConfig();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.Configuration#getDefaultConfig <em>Default Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Config</em>' containment reference.
	 * @see #getDefaultConfig()
	 * @generated
	 */
	void setDefaultConfig(FeatureConfig value);

	/**
	 * Returns the value of the '<em><b>Config Overrides</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featureconfig.FeatureConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Overrides</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Overrides</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfiguration_ConfigOverrides()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FeatureConfig> getConfigOverrides();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfiguration_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.Configuration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
	
	/**
	 * Checks if all mandatory Features are selected
	 * 
	 * @param configuration The Configuration object
	 * @param diagnostics The DiagnosticChain object for the validation process
	 * @param context The context map
	 * @return <code>true</code> if the validation succeeded
	 * <code>false</code> else
     * @generated NOT 
	 */
	boolean mandatoryFeaturesChecked (Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context);
	
	/**
	 * Checks if the the number of selected Feature objects in every FeatureGroup is in the Min:Max range of that group
	 * 
	 * @param configuration The Configuration object
	 * @param diagnostics The DiagnosticChain object for the validation process
	 * @param context The context map
	 * @return <code>true</code> if the validation succeeded
	 * <code>false</code> else
     * @generated NOT
	 */
	boolean minMaxCorrect (Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context);

} // Configuration
