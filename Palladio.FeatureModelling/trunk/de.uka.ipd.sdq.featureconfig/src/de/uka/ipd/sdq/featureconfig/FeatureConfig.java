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
 * A representation of the model object '<em><b>Feature Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getFeatureConfigState <em>Feature Config State</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfignode <em>Confignode</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationOverrides <em>Configuration Overrides</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationDefault <em>Configuration Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig()
 * @model
 * @generated
 */
public interface FeatureConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature Config State</b></em>' attribute.
	 * The default value is <code>"NOT_SET"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.featureconfig.FeatureConfigState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Config State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Config State</em>' attribute.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfigState
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig_FeatureConfigState()
	 * @model default="NOT_SET" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FeatureConfigState getFeatureConfigState();

	/**
	 * Returns the value of the '<em><b>Confignode</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featureconfig.ConfigNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confignode</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confignode</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig_Confignode()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ConfigNode> getConfignode();

	/**
	 * Returns the value of the '<em><b>Configuration Overrides</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featureconfig.Configuration#getConfigOverrides <em>Config Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Overrides</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Overrides</em>' container reference.
	 * @see #setConfigurationOverrides(Configuration)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig_ConfigurationOverrides()
	 * @see de.uka.ipd.sdq.featureconfig.Configuration#getConfigOverrides
	 * @model opposite="configOverrides" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Configuration getConfigurationOverrides();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationOverrides <em>Configuration Overrides</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Overrides</em>' container reference.
	 * @see #getConfigurationOverrides()
	 * @generated
	 */
	void setConfigurationOverrides(Configuration value);

	/**
	 * Returns the value of the '<em><b>Configuration Default</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featureconfig.Configuration#getDefaultConfig <em>Default Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Default</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Default</em>' container reference.
	 * @see #setConfigurationDefault(Configuration)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig_ConfigurationDefault()
	 * @see de.uka.ipd.sdq.featureconfig.Configuration#getDefaultConfig
	 * @model opposite="defaultConfig" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Configuration getConfigurationDefault();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationDefault <em>Configuration Default</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Default</em>' container reference.
	 * @see #getConfigurationDefault()
	 * @generated
	 */
	void setConfigurationDefault(Configuration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.origin.oclIsTypeOf(featuremodel::FeatureDiagram)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.origin.oclIsTypeOf(featuremodel::FeatureDiagram)'"
	 * @generated
	 */
	boolean RootIsFeatureModel(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * if (configurationDefault->size() = 1 and configurationDefault.defaultConfig = self) then FeatureConfigState::DEFAULT
	 *  else (
	 *  if (configurationOverrides->size() = 1 and configurationOverrides.configOverrides->size() > 0 and configurationOverrides.configOverrides->includes(self)) then FeatureConfigState::OVERRIDE
	 *  else FeatureConfigState::NOT_SET
	 *  endif
	 *  ) endif
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if (configurationDefault->size() = 1 and configurationDefault.defaultConfig = self) then FeatureConfigState::DEFAULT\r\n else (\r\n if (configurationOverrides->size() = 1 and configurationOverrides.configOverrides->size() > 0 and configurationOverrides.configOverrides->includes(self)) then FeatureConfigState::OVERRIDE\r\n else FeatureConfigState::NOT_SET\r\n endif\r\n ) endif'"
	 * @generated
	 */
	FeatureConfigState showFeatureConfigState();

} // FeatureConfig
