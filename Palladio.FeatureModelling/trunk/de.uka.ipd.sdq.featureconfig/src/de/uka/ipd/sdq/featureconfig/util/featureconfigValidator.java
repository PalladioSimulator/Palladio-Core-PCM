/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.util;

import de.uka.ipd.sdq.featureconfig.*;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.featureconfig.AttributeValue;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.FeatureConfigState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage
 * @generated
 */
public class featureconfigValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final featureconfigValidator INSTANCE = new featureconfigValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.featureconfig";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Config Cardinality Invalid' of 'Config Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONFIG_NODE__CONFIG_CARDINALITY_INVALID = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Attribute Is Defined In Feature' of 'Attribute Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ATTRIBUTE_VALUE__ATTRIBUTE_IS_DEFINED_IN_FEATURE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Root Is Feature Model' of 'Feature Config'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_CONFIG__ROOT_IS_FEATURE_MODEL = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierValidator identifierValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featureconfigValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return featureconfigPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case featureconfigPackage.CONFIG_NODE:
				return validateConfigNode((ConfigNode)value, diagnostics, context);
			case featureconfigPackage.ATTRIBUTE_VALUE:
				return validateAttributeValue((AttributeValue)value, diagnostics, context);
			case featureconfigPackage.FEATURE_CONFIG:
				return validateFeatureConfig((FeatureConfig)value, diagnostics, context);
			case featureconfigPackage.CONFIGURATION:
				return validateConfiguration((Configuration)value, diagnostics, context);
			case featureconfigPackage.CONFIG_STATE:
				return validateConfigState((ConfigState)value, diagnostics, context);
			case featureconfigPackage.FEATURE_CONFIG_STATE:
				return validateFeatureConfigState((FeatureConfigState)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfigNode(ConfigNode configNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateConfigNode_ConfigCardinalityInvalid(configNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ConfigCardinalityInvalid constraint of '<em>Config Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfigNode_ConfigCardinalityInvalid(ConfigNode configNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return configNode.ConfigCardinalityInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValue(AttributeValue attributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(attributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeValue_AttributeIsDefinedInFeature(attributeValue, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AttributeIsDefinedInFeature constraint of '<em>Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValue_AttributeIsDefinedInFeature(AttributeValue attributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return attributeValue.AttributeIsDefinedInFeature(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConfig(FeatureConfig featureConfig, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(featureConfig, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(featureConfig, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(featureConfig, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(featureConfig, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(featureConfig, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(featureConfig, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(featureConfig, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureConfig_RootIsFeatureModel(featureConfig, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RootIsFeatureModel constraint of '<em>Feature Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConfig_RootIsFeatureModel(FeatureConfig featureConfig, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureConfig.RootIsFeatureModel(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfiguration(Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(configuration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfigState(ConfigState configState, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConfigState(FeatureConfigState featureConfigState, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //featureconfigValidator
