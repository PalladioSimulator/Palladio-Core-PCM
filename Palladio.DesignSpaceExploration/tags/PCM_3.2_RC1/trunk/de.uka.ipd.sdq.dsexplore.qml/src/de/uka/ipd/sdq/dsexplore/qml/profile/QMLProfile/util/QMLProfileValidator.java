/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.util;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.*;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage
 * @generated
 */
public class QMLProfileValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QMLProfileValidator INSTANCE = new QMLProfileValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Profile cannot refine itself' of 'Refined QML Profile'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFINED_QML_PROFILE__PROFILE_CANNOT_REFINE_ITSELF = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

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
	public QMLProfileValidator() {
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
	  return QMLProfilePackage.eINSTANCE;
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
			case QMLProfilePackage.SIMPLE_QML_PROFILE:
				return validateSimpleQMLProfile((SimpleQMLProfile)value, diagnostics, context);
			case QMLProfilePackage.GENERIC_QML_PROFILE:
				return validateGenericQMLProfile((GenericQMLProfile)value, diagnostics, context);
			case QMLProfilePackage.REQUIREMENT:
				return validateRequirement((Requirement)value, diagnostics, context);
			case QMLProfilePackage.REFINED_QML_PROFILE:
				return validateRefinedQMLProfile((RefinedQMLProfile)value, diagnostics, context);
			case QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT:
				return validateUsageScenarioRequirement((UsageScenarioRequirement)value, diagnostics, context);
			case QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT:
				return validateEntryLevelSystemCallRequirement((EntryLevelSystemCallRequirement)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleQMLProfile(SimpleQMLProfile simpleQMLProfile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(simpleQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simpleQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simpleQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simpleQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simpleQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simpleQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simpleQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(simpleQMLProfile, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenericQMLProfile(GenericQMLProfile genericQMLProfile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(genericQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(genericQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(genericQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(genericQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(genericQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(genericQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(genericQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(genericQMLProfile, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequirement(Requirement requirement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(requirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requirement, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requirement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinedQMLProfile(RefinedQMLProfile refinedQMLProfile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(refinedQMLProfile, diagnostics, context);
		if (result || diagnostics != null) result &= validateRefinedQMLProfile_profile_cannot_refine_itself(refinedQMLProfile, diagnostics, context);
		return result;
	}

	/**
	 * Validates the profile_cannot_refine_itself constraint of '<em>Refined QML Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinedQMLProfile_profile_cannot_refine_itself(RefinedQMLProfile refinedQMLProfile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return refinedQMLProfile.profile_cannot_refine_itself(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUsageScenarioRequirement(UsageScenarioRequirement usageScenarioRequirement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(usageScenarioRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(usageScenarioRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(usageScenarioRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(usageScenarioRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(usageScenarioRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(usageScenarioRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(usageScenarioRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(usageScenarioRequirement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntryLevelSystemCallRequirement(EntryLevelSystemCallRequirement entryLevelSystemCallRequirement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(entryLevelSystemCallRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entryLevelSystemCallRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entryLevelSystemCallRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entryLevelSystemCallRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entryLevelSystemCallRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entryLevelSystemCallRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entryLevelSystemCallRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(entryLevelSystemCallRequirement, diagnostics, context);
		return result;
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

} //QMLProfileValidator
