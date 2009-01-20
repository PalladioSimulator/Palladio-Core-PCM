/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope;
import de.uka.ipd.sdq.pcm.allocation.util.AllocationValidator;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getAllocationContexts_Allocation <em>Allocation Contexts Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getSystem_Allocation <em>System Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getInfrastructureComponentScopes_Allocation <em>Infrastructure Component Scopes Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getAllocationConnectors_Allocation <em>Allocation Connectors Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationImpl extends EntityImpl implements Allocation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getAllocationContexts_Allocation() <em>Allocation Contexts Allocation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContexts_Allocation()
	 * @generated
	 * @ordered
	 */
	protected EList<AllocationContext> allocationContexts_Allocation;

	/**
	 * The cached value of the '{@link #getTargetResourceEnvironment_Allocation() <em>Target Resource Environment Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetResourceEnvironment_Allocation()
	 * @generated
	 * @ordered
	 */
	protected ResourceEnvironment targetResourceEnvironment_Allocation;

	/**
	 * The cached value of the '{@link #getSystem_Allocation() <em>System Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem_Allocation()
	 * @generated
	 * @ordered
	 */
	protected de.uka.ipd.sdq.pcm.system.System system_Allocation;

	/**
	 * The cached value of the '{@link #getInfrastructureComponentScopes_Allocation() <em>Infrastructure Component Scopes Allocation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructureComponentScopes_Allocation()
	 * @generated
	 * @ordered
	 */
	protected EList<InfrastructureComponentScope> infrastructureComponentScopes_Allocation;

	/**
	 * The cached value of the '{@link #getAllocationConnectors_Allocation() <em>Allocation Connectors Allocation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationConnectors_Allocation()
	 * @generated
	 * @ordered
	 */
	protected EList<AllocationConnector> allocationConnectors_Allocation;

	/**
	 * The parsed OCL expression for the definition of the '{@link #EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce <em>Each Assembly Context Within System Has To Be Allocated Exactly Once</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce
	 * @generated
	 */
	private static OCLExpression EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnceInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOne <em>For All Infrastructure Component Scopes On The Same Resource Container Only One Scope Is The Uppest One</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOne
	 * @generated
	 */
	private static OCLExpression ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOneInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne <em>For All Infrastructure Component Scopes On The Same Resource Container Only One Scope Is The Lowest One</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne
	 * @generated
	 */
	private static OCLExpression ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOneInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound <em>Each Resource Required Role Of AComponent In An Infrastructure Component Scope Has To Be Bound</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound
	 * @generated
	 */
	private static OCLExpression EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBoundInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound <em>For Each Resource Container All Resource Required Roles Of All Controller Layers Have To Be Bound</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound
	 * @generated
	 */
	private static OCLExpression ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBoundInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound <em>Each Resource Required Role Of An Allocated Assembly Context Has To Be Bound</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound
	 * @generated
	 */
	private static OCLExpression EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBoundInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.ALLOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AllocationContext> getAllocationContexts_Allocation() {
		if (allocationContexts_Allocation == null) {
			allocationContexts_Allocation = new EObjectContainmentEList<AllocationContext>(AllocationContext.class, this, AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION);
		}
		return allocationContexts_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEnvironment getTargetResourceEnvironment_Allocation() {
		if (targetResourceEnvironment_Allocation != null && targetResourceEnvironment_Allocation.eIsProxy()) {
			InternalEObject oldTargetResourceEnvironment_Allocation = (InternalEObject)targetResourceEnvironment_Allocation;
			targetResourceEnvironment_Allocation = (ResourceEnvironment)eResolveProxy(oldTargetResourceEnvironment_Allocation);
			if (targetResourceEnvironment_Allocation != oldTargetResourceEnvironment_Allocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION, oldTargetResourceEnvironment_Allocation, targetResourceEnvironment_Allocation));
			}
		}
		return targetResourceEnvironment_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEnvironment basicGetTargetResourceEnvironment_Allocation() {
		return targetResourceEnvironment_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetResourceEnvironment_Allocation(ResourceEnvironment newTargetResourceEnvironment_Allocation) {
		ResourceEnvironment oldTargetResourceEnvironment_Allocation = targetResourceEnvironment_Allocation;
		targetResourceEnvironment_Allocation = newTargetResourceEnvironment_Allocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION, oldTargetResourceEnvironment_Allocation, targetResourceEnvironment_Allocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uka.ipd.sdq.pcm.system.System getSystem_Allocation() {
		if (system_Allocation != null && system_Allocation.eIsProxy()) {
			InternalEObject oldSystem_Allocation = (InternalEObject)system_Allocation;
			system_Allocation = (de.uka.ipd.sdq.pcm.system.System)eResolveProxy(oldSystem_Allocation);
			if (system_Allocation != oldSystem_Allocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION, oldSystem_Allocation, system_Allocation));
			}
		}
		return system_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uka.ipd.sdq.pcm.system.System basicGetSystem_Allocation() {
		return system_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem_Allocation(de.uka.ipd.sdq.pcm.system.System newSystem_Allocation) {
		de.uka.ipd.sdq.pcm.system.System oldSystem_Allocation = system_Allocation;
		system_Allocation = newSystem_Allocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION, oldSystem_Allocation, system_Allocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InfrastructureComponentScope> getInfrastructureComponentScopes_Allocation() {
		if (infrastructureComponentScopes_Allocation == null) {
			infrastructureComponentScopes_Allocation = new EObjectContainmentEList<InfrastructureComponentScope>(InfrastructureComponentScope.class, this, AllocationPackage.ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION);
		}
		return infrastructureComponentScopes_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AllocationConnector> getAllocationConnectors_Allocation() {
		if (allocationConnectors_Allocation == null) {
			allocationConnectors_Allocation = new EObjectContainmentEList<AllocationConnector>(AllocationConnector.class, this, AllocationPackage.ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION);
		}
		return allocationConnectors_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.system_Allocation.assemblyContexts_ComposedStructure->forAll(assemblyCtx|self.allocationContexts_Allocation->select(allocationCtx|allocationCtx.assemblyContext_AllocationContext = assemblyCtx)->size() = 1) ";
			
			try {
				EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnceInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnceInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.ALLOCATION__EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
		
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOneInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "(self.infrastructureComponentScopes_Allocation->select(scope|scope.upperLayer->asBag()->isEmpty()))->forAll(scope1, scope2| scope1 <> scope2 implies scope1.resourceContainer_InfrastructureComponentScope <> scope2.resourceContainer_InfrastructureComponentScope) ";
			
			try {
				ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOneInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOneInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.ALLOCATION__FOR_ALL_INFRASTRUCTURE_COMPONENT_SCOPES_ON_THE_SAME_RESOURCE_CONTAINER_ONLY_ONE_SCOPE_IS_THE_UPPEST_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheUppestOne", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOneInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "(self.infrastructureComponentScopes_Allocation->select(scope|scope.lowerLayer->asBag()->isEmpty()))->forAll(scope1, scope2| scope1 <> scope2 implies scope1.resourceContainer_InfrastructureComponentScope <> scope2.resourceContainer_InfrastructureComponentScope) ";
			
			try {
				ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOneInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOneInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.ALLOCATION__FOR_ALL_INFRASTRUCTURE_COMPONENT_SCOPES_ON_THE_SAME_RESOURCE_CONTAINER_ONLY_ONE_SCOPE_IS_THE_LOWEST_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ForAllInfrastructureComponentScopesOnTheSameResourceContainerOnlyOneScopeIsTheLowestOne", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBoundInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "   self.infrastructureComponentScopes_Allocation.assemblyContexts_ComposedStructure->forAll(ctx|ctx.encapsulatedComponent_AssemblyContext.resourceRequiredRoles_ResourceInterfaceRequiringEntity->forAll(role|self.allocationConnectors_Allocation->exists(connector|(connector.resourceRequiredRole_AllocationConnector = role) and (connector.fromAssemblyContext_AllocationConnector = ctx)))) ";
			
			try {
				EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBoundInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBoundInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.ALLOCATION__EACH_RESOURCE_REQUIRED_ROLE_OF_ACOMPONENT_IN_AN_INFRASTRUCTURE_COMPONENT_SCOPE_HAS_TO_BE_BOUND,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EachResourceRequiredRoleOfAComponentInAnInfrastructureComponentScopeHasToBeBound", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBoundInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.targetResourceEnvironment_Allocation.resourceContainer_ResourceEnvironment->forAll(container|container.controllerInstances_ResourceContainer->forAll(contrInst|contrInst.controllerLayer_ControllerInstance.controllerType_ControllerLayer.resourceRequiredRoles_ResourceInterfaceRequiringEntity->forAll(role|self.allocationConnectors_Allocation->exists(connector|connector.oclIsKindOf(ResourceProvidedRoleConnector) and connector.oclAsType(ResourceProvidedRoleConnector).resourceProvidedRole_ResourceProvidedRoleAllocationConnector = role)))) ";
			
			try {
				ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBoundInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBoundInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.ALLOCATION__FOR_EACH_RESOURCE_CONTAINER_ALL_RESOURCE_REQUIRED_ROLES_OF_ALL_CONTROLLER_LAYERS_HAVE_TO_BE_BOUND,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ForEachResourceContainerAllResourceRequiredRolesOfAllControllerLayersHaveToBeBound", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBoundInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "  self.allocationContexts_Allocation->forAll(allocCtx|allocCtx.assemblyContext_AllocationContext.encapsulatedComponent_AssemblyContext.resourceRequiredRoles_ResourceInterfaceRequiringEntity->forAll(role|self.allocationConnectors_Allocation->exists(connector|(connector.resourceRequiredRole_AllocationConnector = role) and (connector.fromAssemblyContext_AllocationConnector = allocCtx.assemblyContext_AllocationContext)))) ";
			
			try {
				EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBoundInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBoundInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.ALLOCATION__EACH_RESOURCE_REQUIRED_ROLE_OF_AN_ALLOCATED_ASSEMBLY_CONTEXT_HAS_TO_BE_BOUND,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EachResourceRequiredRoleOfAnAllocatedAssemblyContextHasToBeBound", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				return ((InternalEList<?>)getAllocationContexts_Allocation()).basicRemove(otherEnd, msgs);
			case AllocationPackage.ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION:
				return ((InternalEList<?>)getInfrastructureComponentScopes_Allocation()).basicRemove(otherEnd, msgs);
			case AllocationPackage.ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION:
				return ((InternalEList<?>)getAllocationConnectors_Allocation()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				return getAllocationContexts_Allocation();
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				if (resolve) return getTargetResourceEnvironment_Allocation();
				return basicGetTargetResourceEnvironment_Allocation();
			case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
				if (resolve) return getSystem_Allocation();
				return basicGetSystem_Allocation();
			case AllocationPackage.ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION:
				return getInfrastructureComponentScopes_Allocation();
			case AllocationPackage.ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION:
				return getAllocationConnectors_Allocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				getAllocationContexts_Allocation().clear();
				getAllocationContexts_Allocation().addAll((Collection<? extends AllocationContext>)newValue);
				return;
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				setTargetResourceEnvironment_Allocation((ResourceEnvironment)newValue);
				return;
			case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
				setSystem_Allocation((de.uka.ipd.sdq.pcm.system.System)newValue);
				return;
			case AllocationPackage.ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION:
				getInfrastructureComponentScopes_Allocation().clear();
				getInfrastructureComponentScopes_Allocation().addAll((Collection<? extends InfrastructureComponentScope>)newValue);
				return;
			case AllocationPackage.ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION:
				getAllocationConnectors_Allocation().clear();
				getAllocationConnectors_Allocation().addAll((Collection<? extends AllocationConnector>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				getAllocationContexts_Allocation().clear();
				return;
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				setTargetResourceEnvironment_Allocation((ResourceEnvironment)null);
				return;
			case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
				setSystem_Allocation((de.uka.ipd.sdq.pcm.system.System)null);
				return;
			case AllocationPackage.ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION:
				getInfrastructureComponentScopes_Allocation().clear();
				return;
			case AllocationPackage.ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION:
				getAllocationConnectors_Allocation().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				return allocationContexts_Allocation != null && !allocationContexts_Allocation.isEmpty();
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				return targetResourceEnvironment_Allocation != null;
			case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
				return system_Allocation != null;
			case AllocationPackage.ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION:
				return infrastructureComponentScopes_Allocation != null && !infrastructureComponentScopes_Allocation.isEmpty();
			case AllocationPackage.ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION:
				return allocationConnectors_Allocation != null && !allocationConnectors_Allocation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AllocationImpl
