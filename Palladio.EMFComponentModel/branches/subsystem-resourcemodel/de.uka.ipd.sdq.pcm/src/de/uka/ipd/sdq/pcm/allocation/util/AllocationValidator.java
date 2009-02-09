/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;
import de.uka.ipd.sdq.pcm.allocation.*;
import de.uka.ipd.sdq.pcm.core.entity.util.EntityValidator;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage
 * @generated
 */
public class AllocationValidator extends EObjectValidator {
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
	public static final AllocationValidator INSTANCE = new AllocationValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.allocation";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Referenced Resource Required Role And Resource Provided Role Must Match' of 'Resource Provided Role Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_PROVIDED_ROLE_CONNECTOR__REFERENCED_RESOURCE_REQUIRED_ROLE_AND_RESOURCE_PROVIDED_ROLE_MUST_MATCH = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each Assembly Context Within System Has To Be Allocated Exactly Once' of 'Allocation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ALLOCATION__EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Infrastructure Component Scopes On The Same Resource Container Only One Scope Is The Uppermost One' of 'Allocation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ALLOCATION__FOR_ALL_INFRASTRUCTURE_COMPONENT_SCOPES_ON_THE_SAME_RESOURCE_CONTAINER_ONLY_ONE_SCOPE_IS_THE_UPPERMOST_ONE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Infrastructure Component Scopes On The Same Resource Container Only One Scope Is The Lowest One' of 'Allocation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ALLOCATION__FOR_ALL_INFRASTRUCTURE_COMPONENT_SCOPES_ON_THE_SAME_RESOURCE_CONTAINER_ONLY_ONE_SCOPE_IS_THE_LOWEST_ONE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each Resource Required Role Of AComponent In An Infrastructure Component Scope Has To Be Bound' of 'Allocation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ALLOCATION__EACH_RESOURCE_REQUIRED_ROLE_OF_ACOMPONENT_IN_AN_INFRASTRUCTURE_COMPONENT_SCOPE_HAS_TO_BE_BOUND = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Each Resource Container All Resource Required Roles Of All Controller Layers Have To Be Bound' of 'Allocation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ALLOCATION__FOR_EACH_RESOURCE_CONTAINER_ALL_RESOURCE_REQUIRED_ROLES_OF_ALL_CONTROLLER_LAYERS_HAVE_TO_BE_BOUND = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each Resource Required Role Of An Allocated Assembly Context Has To Be Bound' of 'Allocation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ALLOCATION__EACH_RESOURCE_REQUIRED_ROLE_OF_AN_ALLOCATED_ASSEMBLY_CONTEXT_HAS_TO_BE_BOUND = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Scope Must Not Contain Required Roles' of 'Infrastructure Component Scope'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFRASTRUCTURE_COMPONENT_SCOPE__SCOPE_MUST_NOT_CONTAIN_REQUIRED_ROLES = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Scope Must Not Be Part Of ACycle' of 'Infrastructure Component Scope'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFRASTRUCTURE_COMPONENT_SCOPE__SCOPE_MUST_NOT_BE_PART_OF_ACYCLE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Scope Must Not Contain Resource Required Roles' of 'Infrastructure Component Scope'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFRASTRUCTURE_COMPONENT_SCOPE__SCOPE_MUST_NOT_CONTAIN_RESOURCE_REQUIRED_ROLES = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Child Context Contains Role With Referenced Interface' of 'Infrastructure Component Allocation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__CHILD_CONTEXT_CONTAINS_ROLE_WITH_REFERENCED_INTERFACE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'From Assembly Context Has To Be Set' of 'Infrastructure Component Allocation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_HAS_TO_BE_SET = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided Role Has To Belong To Infrastructure Component Scope' of 'Infrastructure Component Allocation Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_HAS_TO_BELONG_TO_INFRASTRUCTURE_COMPONENT_SCOPE = 13;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 13;

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
	public AllocationValidator() {
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
	  return AllocationPackage.eINSTANCE;
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
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR:
				return validateResourceProvidedRoleConnector((ResourceProvidedRoleConnector)value, diagnostics, context);
			case AllocationPackage.ALLOCATION_CONNECTOR:
				return validateAllocationConnector((AllocationConnector)value, diagnostics, context);
			case AllocationPackage.ALLOCATION_CONTEXT:
				return validateAllocationContext((AllocationContext)value, diagnostics, context);
			case AllocationPackage.ALLOCATION:
				return validateAllocation((Allocation)value, diagnostics, context);
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE:
				return validateInfrastructureComponentScope((InfrastructureComponentScope)value, diagnostics, context);
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				return validateInfrastructureComponentAllocationConnector((InfrastructureComponentAllocationConnector)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceProvidedRoleConnector(ResourceProvidedRoleConnector resourceProvidedRoleConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceProvidedRoleConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceProvidedRoleConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceProvidedRoleConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceProvidedRoleConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceProvidedRoleConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceProvidedRoleConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceProvidedRoleConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateResourceProvidedRoleConnector_ReferencedResourceRequiredRoleAndResourceProvidedRoleMustMatch(resourceProvidedRoleConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ReferencedResourceRequiredRoleAndResourceProvidedRoleMustMatch constraint of '<em>Resource Provided Role Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceProvidedRoleConnector_ReferencedResourceRequiredRoleAndResourceProvidedRoleMustMatch(ResourceProvidedRoleConnector resourceProvidedRoleConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceProvidedRoleConnector.ReferencedResourceRequiredRoleAndResourceProvidedRoleMustMatch(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocationContext(AllocationContext allocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(allocationContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(allocationContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(allocationContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(allocationContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(allocationContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(allocationContext, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(allocationContext, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(allocationContext, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocationConnector(AllocationConnector allocationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(allocationConnector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentScope(InfrastructureComponentScope infrastructureComponentScope, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= entityValidator.validateInterfaceProvidingEntity_NoInterfaceIsProvidedTwice(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= entityValidator.validateComposedProvidingRequiringEntity_ProvidedRolesMustBeBound(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfrastructureComponentScope_ScopeMustNotContainRequiredRoles(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfrastructureComponentScope_ScopeMustNotBePartOfACycle(infrastructureComponentScope, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfrastructureComponentScope_ScopeMustNotContainResourceRequiredRoles(infrastructureComponentScope, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ScopeMustNotContainRequiredRoles constraint of '<em>Infrastructure Component Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentScope_ScopeMustNotContainRequiredRoles(InfrastructureComponentScope infrastructureComponentScope, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return infrastructureComponentScope.ScopeMustNotContainRequiredRoles(diagnostics, context);
	}

	/**
	 * Validates the ScopeMustNotBePartOfACycle constraint of '<em>Infrastructure Component Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentScope_ScopeMustNotBePartOfACycle(InfrastructureComponentScope infrastructureComponentScope, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return infrastructureComponentScope.ScopeMustNotBePartOfACycle(diagnostics, context);
	}

	/**
	 * Validates the ScopeMustNotContainResourceRequiredRoles constraint of '<em>Infrastructure Component Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentScope_ScopeMustNotContainResourceRequiredRoles(InfrastructureComponentScope infrastructureComponentScope, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return infrastructureComponentScope.ScopeMustNotContainResourceRequiredRoles(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validateAllocation_EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validateAllocation_ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppermostOne(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validateAllocation_ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validateAllocation_EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validateAllocation_ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound(allocation, diagnostics, context);
		if (result || diagnostics != null) result &= validateAllocation_EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound(allocation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce constraint of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation_EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return allocation.EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(diagnostics, context);
	}


	/**
	 * Validates the ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppermostOne constraint of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation_ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppermostOne(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return allocation.ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppermostOne(diagnostics, context);
	}

	/**
	 * Validates the ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne constraint of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation_ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return allocation.ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne(diagnostics, context);
	}

	/**
	 * Validates the EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound constraint of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation_EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return allocation.EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound(diagnostics, context);
	}

	/**
	 * Validates the ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound constraint of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation_ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return allocation.ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound(diagnostics, context);
	}

	/**
	 * Validates the EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound constraint of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation_EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return allocation.EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentAllocationConnector(InfrastructureComponentAllocationConnector infrastructureComponentAllocationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfrastructureComponentAllocationConnector_ChildContextContainsRoleWithReferencedInterface(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfrastructureComponentAllocationConnector_FromAssemblyContextHasToBeSet(infrastructureComponentAllocationConnector, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfrastructureComponentAllocationConnector_ProvidedRoleHasToBelongToInfrastructureComponentScope(infrastructureComponentAllocationConnector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ChildContextContainsRoleWithReferencedInterface constraint of '<em>Infrastructure Component Allocation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentAllocationConnector_ChildContextContainsRoleWithReferencedInterface(InfrastructureComponentAllocationConnector infrastructureComponentAllocationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return infrastructureComponentAllocationConnector.ChildContextContainsRoleWithReferencedInterface(diagnostics, context);
	}

	/**
	 * Validates the FromAssemblyContextHasToBeSet constraint of '<em>Infrastructure Component Allocation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentAllocationConnector_FromAssemblyContextHasToBeSet(InfrastructureComponentAllocationConnector infrastructureComponentAllocationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return infrastructureComponentAllocationConnector.FromAssemblyContextHasToBeSet(diagnostics, context);
	}

	/**
	 * Validates the ProvidedRoleHasToBelongToInfrastructureComponentScope constraint of '<em>Infrastructure Component Allocation Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureComponentAllocationConnector_ProvidedRoleHasToBelongToInfrastructureComponentScope(InfrastructureComponentAllocationConnector infrastructureComponentAllocationConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return infrastructureComponentAllocationConnector.ProvidedRoleHasToBelongToInfrastructureComponentScope(diagnostics, context);
	}

} //AllocationValidator
