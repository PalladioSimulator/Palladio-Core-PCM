/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The Feature Config simply sets states selected, eliminated or default for single features. Thus, invalid configurations can be built, this is by purpose, so that invalid intermediate steps can 
 * be stored. 
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.featureconfig.featureconfigFactory
 * @model kind="package"
 * @generated
 */
public interface featureconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "featureconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/FeatureConfig/2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.uka.ipd.sdq";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	featureconfigPackage eINSTANCE = de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl <em>Config Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfigNode()
	 * @generated
	 */
	int CONFIG_NODE = 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_NODE__ORIGIN = 0;

	/**
	 * The feature id for the '<em><b>Config State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_NODE__CONFIG_STATE = 1;

	/**
	 * The number of structural features of the '<em>Config Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl <em>Feature Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getFeatureConfig()
	 * @generated
	 */
	int FEATURE_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG__REFERENCED_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Confignode</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG__CONFIGNODE = 1;

	/**
	 * The number of structural features of the '<em>Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Default Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DEFAULT_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Config Overrides</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CONFIG_OVERRIDES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.ConfigState <em>Config State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfigState()
	 * @generated
	 */
	int CONFIG_STATE = 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.ConfigNode <em>Config Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Node</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigNode
	 * @generated
	 */
	EClass getConfigNode();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origin</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigNode#getOrigin()
	 * @see #getConfigNode()
	 * @generated
	 */
	EReference getConfigNode_Origin();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getConfigState <em>Config State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config State</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigNode#getConfigState()
	 * @see #getConfigNode()
	 * @generated
	 */
	EAttribute getConfigNode_ConfigState();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig <em>Feature Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Config</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfig
	 * @generated
	 */
	EClass getFeatureConfig();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Object</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfig#getReferencedObject()
	 * @see #getFeatureConfig()
	 * @generated
	 */
	EReference getFeatureConfig_ReferencedObject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfignode <em>Confignode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Confignode</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfignode()
	 * @see #getFeatureConfig()
	 * @generated
	 */
	EReference getFeatureConfig_Confignode();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.featureconfig.Configuration#getDefaultConfig <em>Default Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Config</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.Configuration#getDefaultConfig()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_DefaultConfig();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.featureconfig.Configuration#getConfigOverrides <em>Config Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Config Overrides</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.Configuration#getConfigOverrides()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ConfigOverrides();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featureconfig.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.featureconfig.ConfigState <em>Config State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Config State</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @generated
	 */
	EEnum getConfigState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	featureconfigFactory getfeatureconfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl <em>Config Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfigNode()
		 * @generated
		 */
		EClass CONFIG_NODE = eINSTANCE.getConfigNode();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_NODE__ORIGIN = eINSTANCE.getConfigNode_Origin();

		/**
		 * The meta object literal for the '<em><b>Config State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_NODE__CONFIG_STATE = eINSTANCE.getConfigNode_ConfigState();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl <em>Feature Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getFeatureConfig()
		 * @generated
		 */
		EClass FEATURE_CONFIG = eINSTANCE.getFeatureConfig();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIG__REFERENCED_OBJECT = eINSTANCE.getFeatureConfig_ReferencedObject();

		/**
		 * The meta object literal for the '<em><b>Confignode</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIG__CONFIGNODE = eINSTANCE.getFeatureConfig_Confignode();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Default Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__DEFAULT_CONFIG = eINSTANCE.getConfiguration_DefaultConfig();

		/**
		 * The meta object literal for the '<em><b>Config Overrides</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__CONFIG_OVERRIDES = eINSTANCE.getConfiguration_ConfigOverrides();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.ConfigState <em>Config State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.ConfigState
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfigState()
		 * @generated
		 */
		EEnum CONFIG_STATE = eINSTANCE.getConfigState();

	}

} //featureconfigPackage
