/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType;
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage
 * @generated
 */
public class ReliabilityValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ReliabilityValidator INSTANCE = new ReliabilityValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.reliability";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Ensure Valid Failure Probability Range' of 'Failure Occurrence Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FAILURE_OCCURRENCE_DESCRIPTION__ENSURE_VALID_FAILURE_PROBABILITY_RANGE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Hardware Induced Failure Type Has Processing Resource Type' of 'Hardware Induced Failure Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int HARDWARE_INDUCED_FAILURE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Resource Timeout Failure Allowed For Internal Failure Occurrence Description' of 'Internal Failure Occurrence Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Network Induced Failure Type Has Communication Link Resource Type' of 'Network Induced Failure Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NETWORK_INDUCED_FAILURE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Resource Timeout Failure Allowed For External Failure Occurrence Description' of 'External Failure Occurrence Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 5;

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
	public ReliabilityValidator() {
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
	  return ReliabilityPackage.eINSTANCE;
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
			case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION:
				return validateFailureOccurrenceDescription((FailureOccurrenceDescription)value, diagnostics, context);
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE:
				return validateHardwareInducedFailureType((HardwareInducedFailureType)value, diagnostics, context);
			case ReliabilityPackage.SOFTWARE_INDUCED_FAILURE_TYPE:
				return validateSoftwareInducedFailureType((SoftwareInducedFailureType)value, diagnostics, context);
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return validateInternalFailureOccurrenceDescription((InternalFailureOccurrenceDescription)value, diagnostics, context);
			case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE:
				return validateNetworkInducedFailureType((NetworkInducedFailureType)value, diagnostics, context);
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return validateExternalFailureOccurrenceDescription((ExternalFailureOccurrenceDescription)value, diagnostics, context);
			case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE:
				return validateResourceTimeoutFailureType((ResourceTimeoutFailureType)value, diagnostics, context);
			case ReliabilityPackage.FAILURE_TYPE:
				return validateFailureType((FailureType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFailureOccurrenceDescription(FailureOccurrenceDescription failureOccurrenceDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(failureOccurrenceDescription, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(failureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(failureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(failureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(failureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(failureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(failureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(failureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(failureOccurrenceDescription, diagnostics, context);
		return result;
	}

	/**
	 * Validates the EnsureValidFailureProbabilityRange constraint of '<em>Failure Occurrence Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(FailureOccurrenceDescription failureOccurrenceDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return failureOccurrenceDescription.EnsureValidFailureProbabilityRange(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHardwareInducedFailureType(HardwareInducedFailureType hardwareInducedFailureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(hardwareInducedFailureType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(hardwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validateHardwareInducedFailureType_HardwareInducedFailureTypeHasProcessingResourceType(hardwareInducedFailureType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the HardwareInducedFailureTypeHasProcessingResourceType constraint of '<em>Hardware Induced Failure Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHardwareInducedFailureType_HardwareInducedFailureTypeHasProcessingResourceType(HardwareInducedFailureType hardwareInducedFailureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return hardwareInducedFailureType.HardwareInducedFailureTypeHasProcessingResourceType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalFailureOccurrenceDescription(ExternalFailureOccurrenceDescription externalFailureOccurrenceDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalFailureOccurrenceDescription, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(externalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(externalFailureOccurrenceDescription, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription constraint of '<em>External Failure Occurrence Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(ExternalFailureOccurrenceDescription externalFailureOccurrenceDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalFailureOccurrenceDescription.NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceTimeoutFailureType(ResourceTimeoutFailureType resourceTimeoutFailureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(resourceTimeoutFailureType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(resourceTimeoutFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceTimeoutFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceTimeoutFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceTimeoutFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceTimeoutFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceTimeoutFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceTimeoutFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceTimeoutFailureType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNetworkInducedFailureType(NetworkInducedFailureType networkInducedFailureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(networkInducedFailureType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(networkInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validateNetworkInducedFailureType_NetworkInducedFailureTypeHasCommunicationLinkResourceType(networkInducedFailureType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NetworkInducedFailureTypeHasCommunicationLinkResourceType constraint of '<em>Network Induced Failure Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNetworkInducedFailureType_NetworkInducedFailureTypeHasCommunicationLinkResourceType(NetworkInducedFailureType networkInducedFailureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return networkInducedFailureType.NetworkInducedFailureTypeHasCommunicationLinkResourceType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalFailureOccurrenceDescription(InternalFailureOccurrenceDescription internalFailureOccurrenceDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(internalFailureOccurrenceDescription, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(internalFailureOccurrenceDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateInternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(internalFailureOccurrenceDescription, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription constraint of '<em>Internal Failure Occurrence Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(InternalFailureOccurrenceDescription internalFailureOccurrenceDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return internalFailureOccurrenceDescription.NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSoftwareInducedFailureType(SoftwareInducedFailureType softwareInducedFailureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(softwareInducedFailureType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(softwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(softwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(softwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(softwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(softwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(softwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(softwareInducedFailureType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(softwareInducedFailureType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFailureType(FailureType failureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(failureType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(failureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(failureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(failureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(failureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(failureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(failureType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(failureType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(failureType, diagnostics, context);
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

} //ReliabilityValidator
