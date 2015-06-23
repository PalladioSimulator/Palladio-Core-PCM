/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.reliability.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.palladiosimulator.pcm.reliability.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.pcm.reliability.ReliabilityPackage
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
    public static final String DIAGNOSTIC_SOURCE = "org.palladiosimulator.pcm.reliability";

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
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReliabilityValidator() {
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
        return ReliabilityPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        switch (classifierID) {
        case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION:
            return validateFailureOccurrenceDescription((FailureOccurrenceDescription) value, diagnostics, context);
        case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE:
            return validateHardwareInducedFailureType((HardwareInducedFailureType) value, diagnostics, context);
        case ReliabilityPackage.SOFTWARE_INDUCED_FAILURE_TYPE:
            return validateSoftwareInducedFailureType((SoftwareInducedFailureType) value, diagnostics, context);
        case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            return validateInternalFailureOccurrenceDescription((InternalFailureOccurrenceDescription) value,
                    diagnostics, context);
        case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE:
            return validateNetworkInducedFailureType((NetworkInducedFailureType) value, diagnostics, context);
        case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
            return validateExternalFailureOccurrenceDescription((ExternalFailureOccurrenceDescription) value,
                    diagnostics, context);
        case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE:
            return validateResourceTimeoutFailureType((ResourceTimeoutFailureType) value, diagnostics, context);
        case ReliabilityPackage.FAILURE_TYPE:
            return validateFailureType((FailureType) value, diagnostics, context);
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFailureOccurrenceDescription(FailureOccurrenceDescription failureOccurrenceDescription,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) failureOccurrenceDescription, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) failureOccurrenceDescription, diagnostics,
                context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) failureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) failureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) failureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) failureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) failureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) failureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(
                    failureOccurrenceDescription, diagnostics, context);
        return result;
    }

    /**
     * Validates the EnsureValidFailureProbabilityRange constraint of '<em>Failure Occurrence Description</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(
            FailureOccurrenceDescription failureOccurrenceDescription, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return failureOccurrenceDescription.EnsureValidFailureProbabilityRange(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateHardwareInducedFailureType(HardwareInducedFailureType hardwareInducedFailureType,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) hardwareInducedFailureType, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) hardwareInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) hardwareInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) hardwareInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) hardwareInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) hardwareInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) hardwareInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) hardwareInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateHardwareInducedFailureType_HardwareInducedFailureTypeHasProcessingResourceType(
                    hardwareInducedFailureType, diagnostics, context);
        return result;
    }

    /**
     * Validates the HardwareInducedFailureTypeHasProcessingResourceType constraint of '<em>Hardware Induced Failure Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateHardwareInducedFailureType_HardwareInducedFailureTypeHasProcessingResourceType(
            HardwareInducedFailureType hardwareInducedFailureType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return hardwareInducedFailureType.HardwareInducedFailureTypeHasProcessingResourceType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSoftwareInducedFailureType(SoftwareInducedFailureType softwareInducedFailureType,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject) softwareInducedFailureType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateInternalFailureOccurrenceDescription(
            InternalFailureOccurrenceDescription internalFailureOccurrenceDescription, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) internalFailureOccurrenceDescription, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) internalFailureOccurrenceDescription, diagnostics,
                context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) internalFailureOccurrenceDescription, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) internalFailureOccurrenceDescription, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) internalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) internalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) internalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) internalFailureOccurrenceDescription, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(
                    internalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateInternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(
                    internalFailureOccurrenceDescription, diagnostics, context);
        return result;
    }

    /**
     * Validates the NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription constraint of '<em>Internal Failure Occurrence Description</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateInternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(
            InternalFailureOccurrenceDescription internalFailureOccurrenceDescription, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return internalFailureOccurrenceDescription
                .NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNetworkInducedFailureType(NetworkInducedFailureType networkInducedFailureType,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) networkInducedFailureType, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) networkInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) networkInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) networkInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) networkInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) networkInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) networkInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) networkInducedFailureType, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateNetworkInducedFailureType_NetworkInducedFailureTypeHasCommunicationLinkResourceType(
                    networkInducedFailureType, diagnostics, context);
        return result;
    }

    /**
     * Validates the NetworkInducedFailureTypeHasCommunicationLinkResourceType constraint of '<em>Network Induced Failure Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNetworkInducedFailureType_NetworkInducedFailureTypeHasCommunicationLinkResourceType(
            NetworkInducedFailureType networkInducedFailureType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return networkInducedFailureType.NetworkInducedFailureTypeHasCommunicationLinkResourceType(diagnostics,
                context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExternalFailureOccurrenceDescription(
            ExternalFailureOccurrenceDescription externalFailureOccurrenceDescription, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject) externalFailureOccurrenceDescription, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms((EObject) externalFailureOccurrenceDescription, diagnostics,
                context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms((EObject) externalFailureOccurrenceDescription, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained((EObject) externalFailureOccurrenceDescription, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves((EObject) externalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID((EObject) externalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique((EObject) externalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique((EObject) externalFailureOccurrenceDescription, diagnostics,
                    context);
        if (result || diagnostics != null)
            result &= validateFailureOccurrenceDescription_EnsureValidFailureProbabilityRange(
                    externalFailureOccurrenceDescription, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateExternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(
                    externalFailureOccurrenceDescription, diagnostics, context);
        return result;
    }

    /**
     * Validates the NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription constraint of '<em>External Failure Occurrence Description</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExternalFailureOccurrenceDescription_NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(
            ExternalFailureOccurrenceDescription externalFailureOccurrenceDescription, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return externalFailureOccurrenceDescription
                .NoResourceTimeoutFailureAllowedForExternalFailureOccurrenceDescription(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateResourceTimeoutFailureType(ResourceTimeoutFailureType resourceTimeoutFailureType,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject) resourceTimeoutFailureType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFailureType(FailureType failureType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject) failureType, diagnostics, context);
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
