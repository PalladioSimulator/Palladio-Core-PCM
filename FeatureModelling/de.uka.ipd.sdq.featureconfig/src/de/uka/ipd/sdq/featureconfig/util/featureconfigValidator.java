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
import de.uka.ipd.sdq.featureconfig.DoubleAttributeValue;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.FeatureConfigState;
import de.uka.ipd.sdq.featureconfig.IntegerAttributeValue;
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Multiplicity Of Feature Group' of 'Config Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONFIG_NODE__CHECK_MULTIPLICITY_OF_FEATURE_GROUP = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Attribute Value Is Defined In Feature And Equals Type Integer' of 'Integer Attribute Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTEGER_ATTRIBUTE_VALUE__ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_INTEGER = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Attribute Value Is Defined In Feature And Equals Type Double' of 'Double Attribute Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DOUBLE_ATTRIBUTE_VALUE__ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_DOUBLE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Attribute Value Is Defined In Feature And Equals Type String' of 'String Attribute Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRING_ATTRIBUTE_VALUE__ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_STRING = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Attribute Value Is Defined In Feature And Equals Type External Object' of 'External Object Attribute Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_OBJECT_ATTRIBUTE_VALUE__ATTRIBUTE_VALUE_IS_DEFINED_IN_FEATURE_AND_EQUALS_TYPE_EXTERNAL_OBJECT = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 6;

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
			case featureconfigPackage.INTEGER_ATTRIBUTE_VALUE:
				return validateIntegerAttributeValue((IntegerAttributeValue)value, diagnostics, context);
			case featureconfigPackage.DOUBLE_ATTRIBUTE_VALUE:
				return validateDoubleAttributeValue((DoubleAttributeValue)value, diagnostics, context);
			case featureconfigPackage.STRING_ATTRIBUTE_VALUE:
				return validateStringAttributeValue((StringAttributeValue)value, diagnostics, context);
			case featureconfigPackage.EXTERNAL_OBJECT_ATTRIBUTE_VALUE:
				return validateExternalObjectAttributeValue((ExternalObjectAttributeValue)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateConfigNode_CheckMultiplicityOfFeatureGroup(configNode, diagnostics, context);
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
	 * Validates the CheckMultiplicityOfFeatureGroup constraint of '<em>Config Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfigNode_CheckMultiplicityOfFeatureGroup(ConfigNode configNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return configNode.CheckMultiplicityOfFeatureGroup(diagnostics, context);
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
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConfig(FeatureConfig featureConfig, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureConfig, diagnostics, context);
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
	public boolean validateIntegerAttributeValue(IntegerAttributeValue integerAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(integerAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntegerAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeInteger(integerAttributeValue, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AttributeValueIsDefinedInFeatureAndEqualsTypeInteger constraint of '<em>Integer Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeInteger(IntegerAttributeValue integerAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return integerAttributeValue.AttributeValueIsDefinedInFeatureAndEqualsTypeInteger(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleAttributeValue(DoubleAttributeValue doubleAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(doubleAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateDoubleAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeDouble(doubleAttributeValue, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AttributeValueIsDefinedInFeatureAndEqualsTypeDouble constraint of '<em>Double Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeDouble(DoubleAttributeValue doubleAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return doubleAttributeValue.AttributeValueIsDefinedInFeatureAndEqualsTypeDouble(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringAttributeValue(StringAttributeValue stringAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(stringAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateStringAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeString(stringAttributeValue, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AttributeValueIsDefinedInFeatureAndEqualsTypeString constraint of '<em>String Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeString(StringAttributeValue stringAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stringAttributeValue.AttributeValueIsDefinedInFeatureAndEqualsTypeString(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalObjectAttributeValue(ExternalObjectAttributeValue externalObjectAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(externalObjectAttributeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalObjectAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(externalObjectAttributeValue, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject constraint of '<em>External Object Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalObjectAttributeValue_AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(ExternalObjectAttributeValue externalObjectAttributeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalObjectAttributeValue.AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(diagnostics, context);
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
