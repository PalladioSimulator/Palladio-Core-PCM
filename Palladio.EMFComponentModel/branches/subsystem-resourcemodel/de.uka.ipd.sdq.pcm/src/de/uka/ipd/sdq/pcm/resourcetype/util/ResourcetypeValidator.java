/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.core.entity.util.EntityValidator;

import de.uka.ipd.sdq.pcm.resourcetype.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage
 * @generated
 */
public class ResourcetypeValidator extends EObjectValidator {
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
	public static final ResourcetypeValidator INSTANCE = new ResourcetypeValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.resourcetype";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Resource Service Names Have To Be Unique For AResource Interface' of 'Resource Interface'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_INTERFACE__RESOURCE_SERVICE_NAMES_HAVE_TO_BE_UNIQUE_FOR_ARESOURCE_INTERFACE = 1;

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityValidator entityValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcetypeValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
		entityValidator = EntityValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ResourcetypePackage.eINSTANCE;
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
			case ResourcetypePackage.RESOURCE_TYPE:
				return validateResourceType((ResourceType)value, diagnostics, context);
			case ResourcetypePackage.RESOURCE_REPOSITORY:
				return validateResourceRepository((ResourceRepository)value, diagnostics, context);
			case ResourcetypePackage.PROCESSING_RESOURCE_TYPE:
				return validateProcessingResourceType((ProcessingResourceType)value, diagnostics, context);
			case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE:
				return validateCommunicationLinkResourceType((CommunicationLinkResourceType)value, diagnostics, context);
			case ResourcetypePackage.RESOURCE_INTERFACE:
				return validateResourceInterface((ResourceInterface)value, diagnostics, context);
			case ResourcetypePackage.RESOURCE_SERVICE:
				return validateResourceService((ResourceService)value, diagnostics, context);
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT:
				return validateInfrastructureComponent((InfrastructureComponent)value, diagnostics, context);
			case ResourcetypePackage.RESOURCE_PROVIDED_ROLE:
				return validateResourceProvidedRole((ResourceProvidedRole)value, diagnostics, context);
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE:
				return validateResourceRequiredRole((ResourceRequiredRole)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceType(ResourceType resourceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceRepository(ResourceRepository resourceRepository, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceRepository, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessingResourceType(ProcessingResourceType processingResourceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(processingResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(processingResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(processingResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(processingResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(processingResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(processingResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(processingResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(processingResourceType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommunicationLinkResourceType(CommunicationLinkResourceType communicationLinkResourceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(communicationLinkResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(communicationLinkResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(communicationLinkResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(communicationLinkResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(communicationLinkResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(communicationLinkResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(communicationLinkResourceType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(communicationLinkResourceType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceInterface(ResourceInterface resourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validateResourceInterface_ResourceServiceNamesHaveToBeUniqueForAResourceInterface(resourceInterface, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ResourceServiceNamesHaveToBeUniqueForAResourceInterface constraint of '<em>Resource Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceInterface_ResourceServiceNamesHaveToBeUniqueForAResourceInterface(ResourceInterface resourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceInterface.ResourceServiceNamesHaveToBeUniqueForAResourceInterface(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceService(ResourceService resourceService, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceService, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponent(InfrastructureComponent infrastructureComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(infrastructureComponent, diagnostics, context);
		if (result || diagnostics != null) result &= entityValidator.validateComposedProvidingRequiringEntity_ProvidedRolesMustBeBound(infrastructureComponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceProvidedRole(ResourceProvidedRole resourceProvidedRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceProvidedRole, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceRequiredRole(ResourceRequiredRole resourceRequiredRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceRequiredRole, diagnostics, context);
		return result;
	}

} //ResourcetypeValidator
