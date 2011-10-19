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

import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

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
	String eNS_PREFIX = "featureconfig";

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
	 * The feature id for the '<em><b>Attributevalue</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_NODE__ATTRIBUTEVALUE = 2;

	/**
	 * The number of structural features of the '<em>Config Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.AttributeValueImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getAttributeValue()
	 * @generated
	 */
	int ATTRIBUTE_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__ID = featuremodelPackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__NAME = featuremodelPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__VALUE = featuremodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Confignode</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__CONFIGNODE = featuremodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_FEATURE_COUNT = featuremodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl <em>Feature Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getFeatureConfig()
	 * @generated
	 */
	int FEATURE_CONFIG = 2;

	/**
	 * The feature id for the '<em><b>Feature Config State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG__FEATURE_CONFIG_STATE = 0;

	/**
	 * The feature id for the '<em><b>Confignode</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG__CONFIGNODE = 1;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG__ANNOTATED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Configuration Overrides</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG__CONFIGURATION_OVERRIDES = 3;

	/**
	 * The feature id for the '<em><b>Configuration Default</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG__CONFIGURATION_DEFAULT = 4;

	/**
	 * The number of structural features of the '<em>Feature Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Default Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DEFAULT_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Config Overrides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CONFIG_OVERRIDES = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.IntegerAttributeValueImpl <em>Integer Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.IntegerAttributeValueImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getIntegerAttributeValue()
	 * @generated
	 */
	int INTEGER_ATTRIBUTE_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE_VALUE__ID = ATTRIBUTE_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE_VALUE__NAME = ATTRIBUTE_VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE_VALUE__VALUE = ATTRIBUTE_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Confignode</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE_VALUE__CONFIGNODE = ATTRIBUTE_VALUE__CONFIGNODE;

	/**
	 * The number of structural features of the '<em>Integer Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.DoubleAttributeValueImpl <em>Double Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.DoubleAttributeValueImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getDoubleAttributeValue()
	 * @generated
	 */
	int DOUBLE_ATTRIBUTE_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE_VALUE__ID = ATTRIBUTE_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE_VALUE__NAME = ATTRIBUTE_VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE_VALUE__VALUE = ATTRIBUTE_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Confignode</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE_VALUE__CONFIGNODE = ATTRIBUTE_VALUE__CONFIGNODE;

	/**
	 * The number of structural features of the '<em>Double Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.StringAttributeValueImpl <em>String Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.StringAttributeValueImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getStringAttributeValue()
	 * @generated
	 */
	int STRING_ATTRIBUTE_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_VALUE__ID = ATTRIBUTE_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_VALUE__NAME = ATTRIBUTE_VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_VALUE__VALUE = ATTRIBUTE_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Confignode</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_VALUE__CONFIGNODE = ATTRIBUTE_VALUE__CONFIGNODE;

	/**
	 * The number of structural features of the '<em>String Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.impl.ExternalObjectAttributeValueImpl <em>External Object Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.impl.ExternalObjectAttributeValueImpl
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getExternalObjectAttributeValue()
	 * @generated
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_VALUE__ID = ATTRIBUTE_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_VALUE__NAME = ATTRIBUTE_VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_VALUE__VALUE = ATTRIBUTE_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Confignode</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_VALUE__CONFIGNODE = ATTRIBUTE_VALUE__CONFIGNODE;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Object Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.ConfigState <em>Config State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getConfigState()
	 * @generated
	 */
	int CONFIG_STATE = 8;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featureconfig.FeatureConfigState <em>Feature Config State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfigState
	 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getFeatureConfigState()
	 * @generated
	 */
	int FEATURE_CONFIG_STATE = 9;


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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getAttributevalue <em>Attributevalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributevalue</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigNode#getAttributevalue()
	 * @see #getConfigNode()
	 * @generated
	 */
	EReference getConfigNode_Attributevalue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.AttributeValue <em>Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.AttributeValue
	 * @generated
	 */
	EClass getAttributeValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featureconfig.AttributeValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.AttributeValue#getValue()
	 * @see #getAttributeValue()
	 * @generated
	 */
	EAttribute getAttributeValue_Value();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.featureconfig.AttributeValue#getConfignode <em>Confignode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Confignode</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.AttributeValue#getConfignode()
	 * @see #getAttributeValue()
	 * @generated
	 */
	EReference getAttributeValue_Confignode();

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
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getFeatureConfigState <em>Feature Config State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Config State</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfig#getFeatureConfigState()
	 * @see #getFeatureConfig()
	 * @generated
	 */
	EAttribute getFeatureConfig_FeatureConfigState();

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
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getAnnotatedElement <em>Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotated Element</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfig#getAnnotatedElement()
	 * @see #getFeatureConfig()
	 * @generated
	 */
	EReference getFeatureConfig_AnnotatedElement();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationOverrides <em>Configuration Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration Overrides</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationOverrides()
	 * @see #getFeatureConfig()
	 * @generated
	 */
	EReference getFeatureConfig_ConfigurationOverrides();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationDefault <em>Configuration Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration Default</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfigurationDefault()
	 * @see #getFeatureConfig()
	 * @generated
	 */
	EReference getFeatureConfig_ConfigurationDefault();

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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featureconfig.Configuration#getConfigOverrides <em>Config Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Config Overrides</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.Configuration#getConfigOverrides()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ConfigOverrides();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.IntegerAttributeValue <em>Integer Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Attribute Value</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.IntegerAttributeValue
	 * @generated
	 */
	EClass getIntegerAttributeValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.DoubleAttributeValue <em>Double Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Attribute Value</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.DoubleAttributeValue
	 * @generated
	 */
	EClass getDoubleAttributeValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.StringAttributeValue <em>String Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Attribute Value</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.StringAttributeValue
	 * @generated
	 */
	EClass getStringAttributeValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featureconfig.ExternalObjectAttributeValue <em>External Object Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Object Attribute Value</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.ExternalObjectAttributeValue
	 * @generated
	 */
	EClass getExternalObjectAttributeValue();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.featureconfig.ExternalObjectAttributeValue#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Object</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.ExternalObjectAttributeValue#getReferencedObject()
	 * @see #getExternalObjectAttributeValue()
	 * @generated
	 */
	EReference getExternalObjectAttributeValue_ReferencedObject();

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
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.featureconfig.FeatureConfigState <em>Feature Config State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Config State</em>'.
	 * @see de.uka.ipd.sdq.featureconfig.FeatureConfigState
	 * @generated
	 */
	EEnum getFeatureConfigState();

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
		 * The meta object literal for the '<em><b>Attributevalue</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_NODE__ATTRIBUTEVALUE = eINSTANCE.getConfigNode_Attributevalue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.AttributeValueImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getAttributeValue()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE__VALUE = eINSTANCE.getAttributeValue_Value();

		/**
		 * The meta object literal for the '<em><b>Confignode</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_VALUE__CONFIGNODE = eINSTANCE.getAttributeValue_Confignode();

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
		 * The meta object literal for the '<em><b>Feature Config State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CONFIG__FEATURE_CONFIG_STATE = eINSTANCE.getFeatureConfig_FeatureConfigState();

		/**
		 * The meta object literal for the '<em><b>Confignode</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIG__CONFIGNODE = eINSTANCE.getFeatureConfig_Confignode();

		/**
		 * The meta object literal for the '<em><b>Annotated Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIG__ANNOTATED_ELEMENT = eINSTANCE.getFeatureConfig_AnnotatedElement();

		/**
		 * The meta object literal for the '<em><b>Configuration Overrides</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIG__CONFIGURATION_OVERRIDES = eINSTANCE.getFeatureConfig_ConfigurationOverrides();

		/**
		 * The meta object literal for the '<em><b>Configuration Default</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIG__CONFIGURATION_DEFAULT = eINSTANCE.getFeatureConfig_ConfigurationDefault();

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
		 * The meta object literal for the '<em><b>Config Overrides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__CONFIG_OVERRIDES = eINSTANCE.getConfiguration_ConfigOverrides();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.IntegerAttributeValueImpl <em>Integer Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.IntegerAttributeValueImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getIntegerAttributeValue()
		 * @generated
		 */
		EClass INTEGER_ATTRIBUTE_VALUE = eINSTANCE.getIntegerAttributeValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.DoubleAttributeValueImpl <em>Double Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.DoubleAttributeValueImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getDoubleAttributeValue()
		 * @generated
		 */
		EClass DOUBLE_ATTRIBUTE_VALUE = eINSTANCE.getDoubleAttributeValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.StringAttributeValueImpl <em>String Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.StringAttributeValueImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getStringAttributeValue()
		 * @generated
		 */
		EClass STRING_ATTRIBUTE_VALUE = eINSTANCE.getStringAttributeValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.impl.ExternalObjectAttributeValueImpl <em>External Object Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.impl.ExternalObjectAttributeValueImpl
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getExternalObjectAttributeValue()
		 * @generated
		 */
		EClass EXTERNAL_OBJECT_ATTRIBUTE_VALUE = eINSTANCE.getExternalObjectAttributeValue();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_OBJECT_ATTRIBUTE_VALUE__REFERENCED_OBJECT = eINSTANCE.getExternalObjectAttributeValue_ReferencedObject();

		/**
		 * The meta object literal for the '<em><b>Default Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__DEFAULT_CONFIG = eINSTANCE.getConfiguration_DefaultConfig();

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

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featureconfig.FeatureConfigState <em>Feature Config State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featureconfig.FeatureConfigState
		 * @see de.uka.ipd.sdq.featureconfig.impl.featureconfigPackageImpl#getFeatureConfigState()
		 * @generated
		 */
		EEnum FEATURE_CONFIG_STATE = eINSTANCE.getFeatureConfigState();

	}

} //featureconfigPackage
