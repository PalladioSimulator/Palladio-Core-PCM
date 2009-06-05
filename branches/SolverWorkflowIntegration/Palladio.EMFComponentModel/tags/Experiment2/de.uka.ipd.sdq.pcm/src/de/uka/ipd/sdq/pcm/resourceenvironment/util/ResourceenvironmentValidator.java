/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.resourceenvironment.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage
 * @generated
 */
public class ResourceenvironmentValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ResourceenvironmentValidator INSTANCE = new ResourceenvironmentValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.resourceenvironment";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Processing Ratemustbelargerthanzero' of 'Processing Resource Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATEMUSTBELARGERTHANZERO = 1;

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
	public ResourceenvironmentValidator() {
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
	  return ResourceenvironmentPackage.eINSTANCE;
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
			case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT:
				return validateResourceEnvironment((ResourceEnvironment)value, diagnostics, context);
			case ResourceenvironmentPackage.LINKING_RESOURCE:
				return validateLinkingResource((LinkingResource)value, diagnostics, context);
			case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
				return validateCommunicationLinkResourceSpecification((CommunicationLinkResourceSpecification)value, diagnostics, context);
			case ResourceenvironmentPackage.LATENCY:
				return validateLatency((Latency)value, diagnostics, context);
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION:
				return validateProcessingResourceSpecification((ProcessingResourceSpecification)value, diagnostics, context);
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION:
				return validatePassiveResourceSpecification((PassiveResourceSpecification)value, diagnostics, context);
			case ResourceenvironmentPackage.RESOURCE_CONTAINER:
				return validateResourceContainer((ResourceContainer)value, diagnostics, context);
			case ResourceenvironmentPackage.SCHEDULING_POLICY:
				return validateSchedulingPolicy((SchedulingPolicy)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceEnvironment(ResourceEnvironment resourceEnvironment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceEnvironment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkingResource(LinkingResource linkingResource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(linkingResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkingResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkingResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkingResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(linkingResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkingResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkingResource, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(linkingResource, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommunicationLinkResourceSpecification(CommunicationLinkResourceSpecification communicationLinkResourceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(communicationLinkResourceSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLatency(Latency latency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(latency, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessingResourceSpecification(ProcessingResourceSpecification processingResourceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(processingResourceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(processingResourceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(processingResourceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(processingResourceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(processingResourceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(processingResourceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(processingResourceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validateProcessingResourceSpecification_ProcessingRatemustbelargerthanzero(processingResourceSpecification, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ProcessingRatemustbelargerthanzero constraint of '<em>Processing Resource Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessingResourceSpecification_ProcessingRatemustbelargerthanzero(ProcessingResourceSpecification processingResourceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return processingResourceSpecification.ProcessingRatemustbelargerthanzero(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePassiveResourceSpecification(PassiveResourceSpecification passiveResourceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(passiveResourceSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceContainer(ResourceContainer resourceContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceContainer, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchedulingPolicy(SchedulingPolicy schedulingPolicy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

} //ResourceenvironmentValidator
