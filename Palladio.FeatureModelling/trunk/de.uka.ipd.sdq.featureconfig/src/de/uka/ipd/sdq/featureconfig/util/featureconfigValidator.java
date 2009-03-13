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
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;
	
	public static final int CONFIG_NODE__PROHIBITS_FEATURE_SELECTED = 3;
	
	public static final int CONFIG_NODE__REQUIRED_FEATURE_ELIMINATED = 4;
	
	public static final int CONFIGURATION__MANDATORY_ELIMINATED = 5;
	
	public static final int CONFIGURATION__MIN_MAX_VIOLATED = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featureconfigValidator() {
		super();
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
			case featureconfigPackage.FEATURE_CONFIG:
				return validateFeatureConfig((FeatureConfig)value, diagnostics, context);
			case featureconfigPackage.CONFIGURATION:
				return validateConfiguration((Configuration)value, diagnostics, context);
			case featureconfigPackage.CONFIG_STATE:
				return validateConfigState((ConfigState)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= validate_RequiresFeaturesChecked(configNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_ProhibitsFeaturesUnchecked(configNode, diagnostics, context);
		return result;
	}
	

	private boolean validate_ProhibitsFeaturesUnchecked(ConfigNode configNode,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return configNode.prohibitsFeaturesUnchecked(configNode, diagnostics, context);
	}

	private boolean validate_RequiresFeaturesChecked(ConfigNode configNode,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return configNode.requiresFeaturesChecked(configNode, diagnostics, context);
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
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfiguration(Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryDefaultConstraint(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_MinMaxCorrect(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_MandatoryFeaturesChecked(configuration, diagnostics, context);
		return result;
	}

	private boolean validate_MinMaxCorrect(Configuration configuration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return configuration.minMaxCorrect(configuration, diagnostics, context);
	}

	private boolean validate_MandatoryFeaturesChecked(Configuration configuration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return configuration.mandatoryFeaturesChecked(configuration, diagnostics, context);
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
