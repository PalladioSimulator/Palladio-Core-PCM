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

import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getResourceContainer_AllocationConnector <em>Resource Container Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getAssemblyContext_AllocationConnector <em>Assembly Context Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getProvidedRole_AllocationConnector <em>Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl#getInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}</li>
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
	 * The parsed OCL expression for the definition of the '{@link #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch <em>Assembly Connectors Referenced Provided Roles And Child Context Must Match</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch
	 * @generated
	 */
	private static OCLExpression AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL;
	
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
		ResourceRequiredRole resourceRequiredRole_AllocationConnector = basicGetResourceRequiredRole_AllocationConnector();
		return resourceRequiredRole_AllocationConnector != null && resourceRequiredRole_AllocationConnector.eIsProxy() ? (ResourceRequiredRole)eResolveProxy((InternalEObject)resourceRequiredRole_AllocationConnector) : resourceRequiredRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetResourceRequiredRole_AllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiredRole_AllocationConnector(ResourceRequiredRole newResourceRequiredRole_AllocationConnector) {
		// TODO: implement this method to set the 'Resource Required Role Allocation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer getResourceContainer_AllocationConnector() {
		ResourceContainer resourceContainer_AllocationConnector = basicGetResourceContainer_AllocationConnector();
		return resourceContainer_AllocationConnector != null && resourceContainer_AllocationConnector.eIsProxy() ? (ResourceContainer)eResolveProxy((InternalEObject)resourceContainer_AllocationConnector) : resourceContainer_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourceContainer_AllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceContainer_AllocationConnector(ResourceContainer newResourceContainer_AllocationConnector) {
		// TODO: implement this method to set the 'Resource Container Allocation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_AllocationConnector() {
		AssemblyContext assemblyContext_AllocationConnector = basicGetAssemblyContext_AllocationConnector();
		return assemblyContext_AllocationConnector != null && assemblyContext_AllocationConnector.eIsProxy() ? (AssemblyContext)eResolveProxy((InternalEObject)assemblyContext_AllocationConnector) : assemblyContext_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_AllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_AllocationConnector(AssemblyContext newAssemblyContext_AllocationConnector) {
		// TODO: implement this method to set the 'Assembly Context Allocation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole getProvidedRole_AllocationConnector() {
		ProvidedRole providedRole_AllocationConnector = basicGetProvidedRole_AllocationConnector();
		return providedRole_AllocationConnector != null && providedRole_AllocationConnector.eIsProxy() ? (ProvidedRole)eResolveProxy((InternalEObject)providedRole_AllocationConnector) : providedRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetProvidedRole_AllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedRole_AllocationConnector(ProvidedRole newProvidedRole_AllocationConnector) {
		// TODO: implement this method to set the 'Provided Role Allocation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope getInfrastructureComponentScope_InfrastructureComponentAllocationConnector() {
		InfrastructureComponentScope infrastructureComponentScope_InfrastructureComponentAllocationConnector = basicGetInfrastructureComponentScope_InfrastructureComponentAllocationConnector();
		return infrastructureComponentScope_InfrastructureComponentAllocationConnector != null && infrastructureComponentScope_InfrastructureComponentAllocationConnector.eIsProxy() ? (InfrastructureComponentScope)eResolveProxy((InternalEObject)infrastructureComponentScope_InfrastructureComponentAllocationConnector) : infrastructureComponentScope_InfrastructureComponentAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope basicGetInfrastructureComponentScope_InfrastructureComponentAllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfrastructureComponentScope_InfrastructureComponentAllocationConnector(InfrastructureComponentScope newInfrastructureComponentScope_InfrastructureComponentAllocationConnector) {
		// TODO: implement this method to set the 'Infrastructure Component Scope Infrastructure Component Allocation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.assemblyContext_AllocationConnector.encapsulatedComponent_AssemblyContext.providedRoles_InterfaceProvidingEntity->includes(self.providedRole_AllocationConnector) ";
			
			try {
				AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch", EObjectValidator.getObjectLabel(this, context) }),
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				if (resolve) return getResourceContainer_AllocationConnector();
				return basicGetResourceContainer_AllocationConnector();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				if (resolve) return getAssemblyContext_AllocationConnector();
				return basicGetAssemblyContext_AllocationConnector();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				if (resolve) return getProvidedRole_AllocationConnector();
				return basicGetProvidedRole_AllocationConnector();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				if (resolve) return getInfrastructureComponentScope_InfrastructureComponentAllocationConnector();
				return basicGetInfrastructureComponentScope_InfrastructureComponentAllocationConnector();
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				setResourceContainer_AllocationConnector((ResourceContainer)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setAssemblyContext_AllocationConnector((AssemblyContext)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setProvidedRole_AllocationConnector((ProvidedRole)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				setInfrastructureComponentScope_InfrastructureComponentAllocationConnector((InfrastructureComponentScope)newValue);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				setResourceContainer_AllocationConnector((ResourceContainer)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setAssemblyContext_AllocationConnector((AssemblyContext)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setProvidedRole_AllocationConnector((ProvidedRole)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				setInfrastructureComponentScope_InfrastructureComponentAllocationConnector((InfrastructureComponentScope)null);
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
				return basicGetResourceRequiredRole_AllocationConnector() != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				return basicGetResourceContainer_AllocationConnector() != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				return basicGetAssemblyContext_AllocationConnector() != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				return basicGetProvidedRole_AllocationConnector() != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR:
				return basicGetInfrastructureComponentScope_InfrastructureComponentAllocationConnector() != null;
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
				case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR: return AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR;
				case AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR: return AllocationPackage.ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR;
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
				case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR: return AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR;
				case AllocationPackage.ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR: return AllocationPackage.INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InfrastructureComponentAllocationConnectorImpl
