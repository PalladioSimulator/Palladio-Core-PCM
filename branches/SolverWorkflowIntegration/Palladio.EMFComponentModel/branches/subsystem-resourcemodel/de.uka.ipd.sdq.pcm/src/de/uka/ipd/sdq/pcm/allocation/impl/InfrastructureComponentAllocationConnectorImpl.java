/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope;

import de.uka.ipd.sdq.pcm.allocation.util.AllocationValidator;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorImpl;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Component Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getResourceRequiredRole_AllocationConnector <em>Resource Required Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getFromAssemblyContext_AllocationConnector <em>From Assembly Context Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getProvidedRole_AllocationConnector <em>Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureComponentAllocationConnectorImpl extends ConnectorImpl implements InfrastructureComponentAllocationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceRequiredRole_AllocationConnector() <em>Resource Required Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequiredRole_AllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected ResourceRequiredRole resourceRequiredRole_AllocationConnector;

	/**
	 * The cached value of the '{@link #getFromAssemblyContext_AllocationConnector() <em>From Assembly Context Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromAssemblyContext_AllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext fromAssemblyContext_AllocationConnector;

	/**
	 * The cached value of the '{@link #getProvidedRole_AllocationConnector() <em>Provided Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRole_AllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole providedRole_AllocationConnector;

	/**
	 * The cached value of the '{@link #getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector() <em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureComponentScope toInfrastructureComponentScope_InfrastructureComponentAllocationConnector;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ChildContextContainsRoleWithReferencedInterface <em>Child Context Contains Role With Referenced Interface</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ChildContextContainsRoleWithReferencedInterface
	 * @generated
	 */
	private static OCLExpression ChildContextContainsRoleWithReferencedInterfaceInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #FromAssemblyContextHasToBeSet <em>From Assembly Context Has To Be Set</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FromAssemblyContextHasToBeSet
	 * @generated
	 */
	private static OCLExpression FromAssemblyContextHasToBeSetInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ProvidedRoleHasToBelongToInfrastructureComponentScope <em>Provided Role Has To Belong To Infrastructure Component Scope</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvidedRoleHasToBelongToInfrastructureComponentScope
	 * @generated
	 */
	private static OCLExpression ProvidedRoleHasToBelongToInfrastructureComponentScopeInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureComponentAllocationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getResourceRequiredRole_AllocationConnector() {
		if (resourceRequiredRole_AllocationConnector != null && resourceRequiredRole_AllocationConnector.eIsProxy()) {
			InternalEObject oldResourceRequiredRole_AllocationConnector = (InternalEObject)resourceRequiredRole_AllocationConnector;
			resourceRequiredRole_AllocationConnector = (ResourceRequiredRole)eResolveProxy(oldResourceRequiredRole_AllocationConnector);
			if (resourceRequiredRole_AllocationConnector != oldResourceRequiredRole_AllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR, oldResourceRequiredRole_AllocationConnector, resourceRequiredRole_AllocationConnector));
			}
		}
		return resourceRequiredRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetResourceRequiredRole_AllocationConnector() {
		return resourceRequiredRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiredRole_AllocationConnector(ResourceRequiredRole newResourceRequiredRole_AllocationConnector) {
		ResourceRequiredRole oldResourceRequiredRole_AllocationConnector = resourceRequiredRole_AllocationConnector;
		resourceRequiredRole_AllocationConnector = newResourceRequiredRole_AllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR, oldResourceRequiredRole_AllocationConnector, resourceRequiredRole_AllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getFromAssemblyContext_AllocationConnector() {
		if (fromAssemblyContext_AllocationConnector != null && fromAssemblyContext_AllocationConnector.eIsProxy()) {
			InternalEObject oldFromAssemblyContext_AllocationConnector = (InternalEObject)fromAssemblyContext_AllocationConnector;
			fromAssemblyContext_AllocationConnector = (AssemblyContext)eResolveProxy(oldFromAssemblyContext_AllocationConnector);
			if (fromAssemblyContext_AllocationConnector != oldFromAssemblyContext_AllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR, oldFromAssemblyContext_AllocationConnector, fromAssemblyContext_AllocationConnector));
			}
		}
		return fromAssemblyContext_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetFromAssemblyContext_AllocationConnector() {
		return fromAssemblyContext_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromAssemblyContext_AllocationConnector(AssemblyContext newFromAssemblyContext_AllocationConnector) {
		AssemblyContext oldFromAssemblyContext_AllocationConnector = fromAssemblyContext_AllocationConnector;
		fromAssemblyContext_AllocationConnector = newFromAssemblyContext_AllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR, oldFromAssemblyContext_AllocationConnector, fromAssemblyContext_AllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole getProvidedRole_AllocationConnector() {
		if (providedRole_AllocationConnector != null && providedRole_AllocationConnector.eIsProxy()) {
			InternalEObject oldProvidedRole_AllocationConnector = (InternalEObject)providedRole_AllocationConnector;
			providedRole_AllocationConnector = (ProvidedRole)eResolveProxy(oldProvidedRole_AllocationConnector);
			if (providedRole_AllocationConnector != oldProvidedRole_AllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR, oldProvidedRole_AllocationConnector, providedRole_AllocationConnector));
			}
		}
		return providedRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetProvidedRole_AllocationConnector() {
		return providedRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedRole_AllocationConnector(ProvidedRole newProvidedRole_AllocationConnector) {
		ProvidedRole oldProvidedRole_AllocationConnector = providedRole_AllocationConnector;
		providedRole_AllocationConnector = newProvidedRole_AllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR, oldProvidedRole_AllocationConnector, providedRole_AllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector() {
		if (toInfrastructureComponentScope_InfrastructureComponentAllocationConnector != null && toInfrastructureComponentScope_InfrastructureComponentAllocationConnector.eIsProxy()) {
			InternalEObject oldToInfrastructureComponentScope_InfrastructureComponentAllocationConnector = (InternalEObject)toInfrastructureComponentScope_InfrastructureComponentAllocationConnector;
			toInfrastructureComponentScope_InfrastructureComponentAllocationConnector = (InfrastructureComponentScope)eResolveProxy(oldToInfrastructureComponentScope_InfrastructureComponentAllocationConnector);
			if (toInfrastructureComponentScope_InfrastructureComponentAllocationConnector != oldToInfrastructureComponentScope_InfrastructureComponentAllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR, oldToInfrastructureComponentScope_InfrastructureComponentAllocationConnector, toInfrastructureComponentScope_InfrastructureComponentAllocationConnector));
			}
		}
		return toInfrastructureComponentScope_InfrastructureComponentAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope basicGetToInfrastructureComponentScope_InfrastructureComponentAllocationConnector() {
		return toInfrastructureComponentScope_InfrastructureComponentAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToInfrastructureComponentScope_InfrastructureComponentAllocationConnector(InfrastructureComponentScope newToInfrastructureComponentScope_InfrastructureComponentAllocationConnector) {
		InfrastructureComponentScope oldToInfrastructureComponentScope_InfrastructureComponentAllocationConnector = toInfrastructureComponentScope_InfrastructureComponentAllocationConnector;
		toInfrastructureComponentScope_InfrastructureComponentAllocationConnector = newToInfrastructureComponentScope_InfrastructureComponentAllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR, oldToInfrastructureComponentScope_InfrastructureComponentAllocationConnector, toInfrastructureComponentScope_InfrastructureComponentAllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ChildContextContainsRoleWithReferencedInterface(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ChildContextContainsRoleWithReferencedInterfaceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.fromAssemblyContext_AllocationConnector.encapsulatedComponent_AssemblyContext.resourceRequiredRoles_ResourceInterfaceRequiringEntity->exists(role|role.requiredResourceInterface_ResourceRequiredRole = self.resourceRequiredRole_AllocationConnector.requiredResourceInterface_ResourceRequiredRole) ";
			
			try {
				ChildContextContainsRoleWithReferencedInterfaceInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ChildContextContainsRoleWithReferencedInterfaceInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__CHILD_CONTEXT_CONTAINS_ROLE_WITH_REFERENCED_INTERFACE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ChildContextContainsRoleWithReferencedInterface", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean FromAssemblyContextHasToBeSet(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (FromAssemblyContextHasToBeSetInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.fromAssemblyContext_AllocationConnector->size() = 1 ";
			
			try {
				FromAssemblyContextHasToBeSetInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(FromAssemblyContextHasToBeSetInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_HAS_TO_BE_SET,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "FromAssemblyContextHasToBeSet", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ProvidedRoleHasToBelongToInfrastructureComponentScope(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ProvidedRoleHasToBelongToInfrastructureComponentScopeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.toInfrastructureComponentScope_InfrastructureComponentAllocationConnector.providedRoles_InterfaceProvidingEntity->exists(role | role = self.providedRole_AllocationConnector) ";
			
			try {
				ProvidedRoleHasToBelongToInfrastructureComponentScopeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ProvidedRoleHasToBelongToInfrastructureComponentScopeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_HAS_TO_BELONG_TO_INFRASTRUCTURE_COMPONENT_SCOPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProvidedRoleHasToBelongToInfrastructureComponentScope", EObjectValidator.getObjectLabel(this, context) }),
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				if (resolve) return getResourceRequiredRole_AllocationConnector();
				return basicGetResourceRequiredRole_AllocationConnector();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				if (resolve) return getFromAssemblyContext_AllocationConnector();
				return basicGetFromAssemblyContext_AllocationConnector();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				if (resolve) return getProvidedRole_AllocationConnector();
				return basicGetProvidedRole_AllocationConnector();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				if (resolve) return getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector();
				return basicGetToInfrastructureComponentScope_InfrastructureComponentAllocationConnector();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				setResourceRequiredRole_AllocationConnector((ResourceRequiredRole)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setFromAssemblyContext_AllocationConnector((AssemblyContext)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setProvidedRole_AllocationConnector((ProvidedRole)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				setToInfrastructureComponentScope_InfrastructureComponentAllocationConnector((InfrastructureComponentScope)newValue);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				setResourceRequiredRole_AllocationConnector((ResourceRequiredRole)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setFromAssemblyContext_AllocationConnector((AssemblyContext)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setProvidedRole_AllocationConnector((ProvidedRole)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				setToInfrastructureComponentScope_InfrastructureComponentAllocationConnector((InfrastructureComponentScope)null);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				return resourceRequiredRole_AllocationConnector != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				return fromAssemblyContext_AllocationConnector != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				return providedRole_AllocationConnector != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				return toInfrastructureComponentScope_InfrastructureComponentAllocationConnector != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AllocationConnector.class) {
			switch (derivedFeatureID) {
				case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR: return AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR;
				case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR: return AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AllocationConnector.class) {
			switch (baseFeatureID) {
				case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR: return AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR;
				case AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR: return AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InfrastructureComponentAllocationConnectorImpl
