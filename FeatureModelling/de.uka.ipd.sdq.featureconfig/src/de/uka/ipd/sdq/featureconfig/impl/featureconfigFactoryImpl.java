/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import de.uka.ipd.sdq.featureconfig.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.DoubleAttributeValue;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.FeatureConfigState;
import de.uka.ipd.sdq.featureconfig.IntegerAttributeValue;
import de.uka.ipd.sdq.featureconfig.featureconfigFactory;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class featureconfigFactoryImpl extends EFactoryImpl implements featureconfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static featureconfigFactory init() {
		try {
			featureconfigFactory thefeatureconfigFactory = (featureconfigFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/FeatureConfig/2.0"); 
			if (thefeatureconfigFactory != null) {
				return thefeatureconfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new featureconfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featureconfigFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case featureconfigPackage.CONFIG_NODE: return createConfigNode();
			case featureconfigPackage.FEATURE_CONFIG: return createFeatureConfig();
			case featureconfigPackage.CONFIGURATION: return createConfiguration();
			case featureconfigPackage.INTEGER_ATTRIBUTE_VALUE: return createIntegerAttributeValue();
			case featureconfigPackage.DOUBLE_ATTRIBUTE_VALUE: return createDoubleAttributeValue();
			case featureconfigPackage.STRING_ATTRIBUTE_VALUE: return createStringAttributeValue();
			case featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE: return createExternalObjectAttributeValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case featureconfigPackage.CONFIG_STATE:
				return createConfigStateFromString(eDataType, initialValue);
			case featureconfigPackage.FEATURE_CONFIG_STATE:
				return createFeatureConfigStateFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case featureconfigPackage.CONFIG_STATE:
				return convertConfigStateToString(eDataType, instanceValue);
			case featureconfigPackage.FEATURE_CONFIG_STATE:
				return convertFeatureConfigStateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigNode createConfigNode() {
		ConfigNodeImpl configNode = new ConfigNodeImpl();
		return configNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfig createFeatureConfig() {
		FeatureConfigImpl featureConfig = new FeatureConfigImpl();
		return featureConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAttributeValue createIntegerAttributeValue() {
		IntegerAttributeValueImpl integerAttributeValue = new IntegerAttributeValueImpl();
		return integerAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleAttributeValue createDoubleAttributeValue() {
		DoubleAttributeValueImpl doubleAttributeValue = new DoubleAttributeValueImpl();
		return doubleAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAttributeValue createStringAttributeValue() {
		StringAttributeValueImpl stringAttributeValue = new StringAttributeValueImpl();
		return stringAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalObjectAttributeValue createExternalObjectAttributeValue() {
		ExternalObjectAttributeValueImpl externalObjectAttributeValue = new ExternalObjectAttributeValueImpl();
		return externalObjectAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigState createConfigStateFromString(EDataType eDataType, String initialValue) {
		ConfigState result = ConfigState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConfigStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfigState createFeatureConfigStateFromString(EDataType eDataType, String initialValue) {
		FeatureConfigState result = FeatureConfigState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureConfigStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featureconfigPackage getfeatureconfigPackage() {
		return (featureconfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static featureconfigPackage getPackage() {
		return featureconfigPackage.eINSTANCE;
	}

} //featureconfigFactoryImpl
