/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.allocation.util.AllocationValidator;
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Controller Layers Only One Layer Is The Uppermost One' of 'Resource Container'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_CONTAINER__FOR_ALL_CONTROLLER_LAYERS_ONLY_ONE_LAYER_IS_THE_UPPERMOST_ONE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Controller Layers Only One Layer Is The Lowest One' of 'Resource Container'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_CONTAINER__FOR_ALL_CONTROLLER_LAYERS_ONLY_ONE_LAYER_IS_THE_LOWEST_ONE = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

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
	protected AllocationValidator allocationValidator;

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
		allocationValidator = AllocationValidator.INSTANCE;
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR:
				return validateControllerAllocationConnector((ControllerAllocationConnector)value, diagnostics, context);
			case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT:
				return validateResourceEnvironment((ResourceEnvironment)value, diagnostics, context);
			case ResourceenvironmentPackage.LINKING_RESOURCE:
				return validateLinkingResource((LinkingResource)value, diagnostics, context);
			case ResourceenvironmentPackage.RESOURCE_CONTAINER:
				return validateResourceContainer((ResourceContainer)value, diagnostics, context);
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION:
				return validateProcessingResourceSpecification((ProcessingResourceSpecification)value, diagnostics, context);
			case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
				return validateCommunicationLinkResourceSpecification((CommunicationLinkResourceSpecification)value, diagnostics, context);
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR:
				return validateResourceAllocationConnector((ResourceAllocationConnector)value, diagnostics, context);
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE:
				return validateControllerInstance((ControllerInstance)value, diagnostics, context);
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
	public boolean validateControllerAllocationConnector(ControllerAllocationConnector controllerAllocationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(controllerAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(controllerAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(controllerAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(controllerAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(controllerAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(controllerAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(controllerAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= allocationValidator.validateResourceProvidedRoleConnector_ReferencedResourceRequiredRoleAndResourceProvidedRoleMustMatch(controllerAllocationConnector, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControllerInstance(ControllerInstance controllerInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(controllerInstance, diagnostics, context);
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
	public boolean validateProcessingResourceSpecification(ProcessingResourceSpecification processingResourceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processingResourceSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceAllocationConnector(ResourceAllocationConnector resourceAllocationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= allocationValidator.validateResourceProvidedRoleConnector_ReferencedResourceRequiredRoleAndResourceProvidedRoleMustMatch(resourceAllocationConnector, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateResourceContainer_ForAllControllerLayersOnlyOneLayerIsTheUppermostOne(resourceContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validateResourceContainer_ForAllControllerLayersOnlyOneLayerIsTheLowestOne(resourceContainer, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ForAllControllerLayersOnlyOneLayerIsTheUppermostOne constraint of '<em>Resource Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceContainer_ForAllControllerLayersOnlyOneLayerIsTheUppermostOne(ResourceContainer resourceContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceContainer.ForAllControllerLayersOnlyOneLayerIsTheUppermostOne(diagnostics, context);
	}

	/**
	 * Validates the ForAllControllerLayersOnlyOneLayerIsTheLowestOne constraint of '<em>Resource Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceContainer_ForAllControllerLayersOnlyOneLayerIsTheLowestOne(ResourceContainer resourceContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceContainer.ForAllControllerLayersOnlyOneLayerIsTheLowestOne(diagnostics, context);
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
