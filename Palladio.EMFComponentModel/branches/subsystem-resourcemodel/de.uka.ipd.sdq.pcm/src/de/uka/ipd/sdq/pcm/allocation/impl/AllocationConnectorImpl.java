/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl#getResourceRequiredRole_AllocationConnector <em>Resource Required Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl#getResourceContainer_AllocationConnector <em>Resource Container Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl#getAssemblyContext_AllocationConnector <em>Assembly Context Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AllocationConnectorImpl extends EObjectImpl implements AllocationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.ALLOCATION_CONNECTOR;
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				if (resolve) return getResourceRequiredRole_AllocationConnector();
				return basicGetResourceRequiredRole_AllocationConnector();
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				if (resolve) return getResourceContainer_AllocationConnector();
				return basicGetResourceContainer_AllocationConnector();
			case AllocationPackage.ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				if (resolve) return getAssemblyContext_AllocationConnector();
				return basicGetAssemblyContext_AllocationConnector();
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
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				setResourceRequiredRole_AllocationConnector((ResourceRequiredRole)newValue);
				return;
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				setResourceContainer_AllocationConnector((ResourceContainer)newValue);
				return;
			case AllocationPackage.ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setAssemblyContext_AllocationConnector((AssemblyContext)newValue);
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
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				setResourceRequiredRole_AllocationConnector((ResourceRequiredRole)null);
				return;
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				setResourceContainer_AllocationConnector((ResourceContainer)null);
				return;
			case AllocationPackage.ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setAssemblyContext_AllocationConnector((AssemblyContext)null);
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
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				return basicGetResourceRequiredRole_AllocationConnector() != null;
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR:
				return basicGetResourceContainer_AllocationConnector() != null;
			case AllocationPackage.ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				return basicGetAssemblyContext_AllocationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationConnectorImpl
