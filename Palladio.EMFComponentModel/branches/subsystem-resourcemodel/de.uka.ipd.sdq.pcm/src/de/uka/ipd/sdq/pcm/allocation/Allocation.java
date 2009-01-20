/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts_Allocation <em>Allocation Contexts Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation <em>System Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getInfrastructureComponentScopes_Allocation <em>Infrastructure Component Scopes Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationConnectors_Allocation <em>Allocation Connectors Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation()
 * @model
 * @generated
 */
public interface Allocation extends Entity {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Allocation Contexts Allocation</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.allocation.AllocationContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Contexts Allocation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Contexts Allocation</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_AllocationContexts_Allocation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AllocationContext> getAllocationContexts_Allocation();

	/**
	 * Returns the value of the '<em><b>Target Resource Environment Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Resource Environment Allocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Resource Environment Allocation</em>' reference.
	 * @see #setTargetResourceEnvironment_Allocation(ResourceEnvironment)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_TargetResourceEnvironment_Allocation()
	 * @model ordered="false"
	 * @generated
	 */
	ResourceEnvironment getTargetResourceEnvironment_Allocation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Resource Environment Allocation</em>' reference.
	 * @see #getTargetResourceEnvironment_Allocation()
	 * @generated
	 */
	void setTargetResourceEnvironment_Allocation(ResourceEnvironment value);

	/**
	 * Returns the value of the '<em><b>System Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Allocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Allocation</em>' reference.
	 * @see #setSystem_Allocation(de.uka.ipd.sdq.pcm.system.System)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_System_Allocation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	de.uka.ipd.sdq.pcm.system.System getSystem_Allocation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation <em>System Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Allocation</em>' reference.
	 * @see #getSystem_Allocation()
	 * @generated
	 */
	void setSystem_Allocation(de.uka.ipd.sdq.pcm.system.System value);

	/**
	 * Returns the value of the '<em><b>Infrastructure Component Scopes Allocation</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infrastructure Component Scopes Allocation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure Component Scopes Allocation</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_InfrastructureComponentScopes_Allocation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InfrastructureComponentScope> getInfrastructureComponentScopes_Allocation();

	/**
	 * Returns the value of the '<em><b>Allocation Connectors Allocation</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Connectors Allocation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Connectors Allocation</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_AllocationConnectors_Allocation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AllocationConnector> getAllocationConnectors_Allocation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.system_Allocation.assemblyContexts_ComposedStructure->forAll(assemblyCtx|self.allocationContexts_Allocation->select(allocationCtx|allocationCtx.assemblyContext_AllocationContext = assemblyCtx)->size() = 1)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (self.infrastructureComponentScopes_Allocation->select(scope|scope.upperLayer->asBag()->isEmpty()))->forAll(scope1, scope2| scope1 <> scope2 implies scope1.resourceContainer_InfrastructureComponentScope <> scope2.resourceContainer_InfrastructureComponentScope)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOne(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (self.infrastructureComponentScopes_Allocation->select(scope|scope.lowerLayer->asBag()->isEmpty()))->forAll(scope1, scope2| scope1 <> scope2 implies scope1.resourceContainer_InfrastructureComponentScope <> scope2.resourceContainer_InfrastructureComponentScope)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- Each inner assembly context of an InfrastructureComponentScope has to be bound by means of an AllocationConnector
	 * -- Check if an AllocationConnector exists which binds every inner role and references the same AssemblyContext
	 * -- This has to be refactored if an AllocationConnector references the "fromInfrastructureComponentScope" directly
	 * self.infrastructureComponentScopes_Allocation.assemblyContexts_ComposedStructure->forAll(ctx|ctx.encapsulatedComponent_AssemblyContext.resourceRequiredRoles_ResourceInterfaceRequiringEntity->forAll(role|self.allocationConnectors_Allocation->exists(connector|(connector.resourceRequiredRole_AllocationConnector = role) and (connector.fromAssemblyContext_AllocationConnector = ctx))))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.targetResourceEnvironment_Allocation.resourceContainer_ResourceEnvironment->forAll(container|container.controllerInstance_ResourceContainer->forAll(contrInst|contrInst.controllerLayer_ControllerInstance.controllerType_ControllerLayer.resourceRequiredRoles_ResourceInterfaceRequiringEntity->forAll(role|self.allocationConnectors_Allocation->exists(connector|connector.oclIsKindOf(ResourceProvidedRoleConnector) and connector.oclAsType(ResourceProvidedRoleConnector).resourceProvidedRole_ResourceProvidedRoleAllocationConnector = role))))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- Each assembly context which is referenced by an AllocationContext has to be bound by means of an AllocationConnector
	 * -- Check if an AllocationConnector exists which binds every resource required role of an allocated AssemblyContext and references the same AssemblyContext
	 * self.allocationContexts_Allocation->forAll(allocCtx|allocCtx.assemblyContext_AllocationContext.encapsulatedComponent_AssemblyContext.resourceRequiredRoles_ResourceInterfaceRequiringEntity->forAll(role|self.allocationConnectors_Allocation->exists(connector|(connector.resourceRequiredRole_AllocationConnector = role) and (connector.fromAssemblyContext_AllocationConnector = allocCtx.assemblyContext_AllocationContext))))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound(DiagnosticChain diagnostics, Map<Object, Object> context);

	

} // Allocation
