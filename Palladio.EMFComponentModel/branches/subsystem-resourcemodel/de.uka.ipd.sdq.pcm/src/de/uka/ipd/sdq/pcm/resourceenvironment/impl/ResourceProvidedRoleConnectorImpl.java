/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceProvidedRoleConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Provided Role Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceProvidedRoleConnectorImpl#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceProvidedRoleConnectorImpl#getRequiringControllerInstance_ControllerAllocationConnector <em>Requiring Controller Instance Controller Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceProvidedRoleConnectorImpl extends AllocationConnectorImpl implements ResourceProvidedRoleConnector {
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
	protected ResourceProvidedRoleConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.RESOURCE_PROVIDED_ROLE_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceProvidedRole getResourceProvidedRole_ResourceProvidedRoleAllocationConnector() {
		ResourceProvidedRole resourceProvidedRole_ResourceProvidedRoleAllocationConnector = basicGetResourceProvidedRole_ResourceProvidedRoleAllocationConnector();
		return resourceProvidedRole_ResourceProvidedRoleAllocationConnector != null && resourceProvidedRole_ResourceProvidedRoleAllocationConnector.eIsProxy() ? (ResourceProvidedRole)eResolveProxy((InternalEObject)resourceProvidedRole_ResourceProvidedRoleAllocationConnector) : resourceProvidedRole_ResourceProvidedRoleAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceProvidedRole basicGetResourceProvidedRole_ResourceProvidedRoleAllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceProvidedRole_ResourceProvidedRoleAllocationConnector(ResourceProvidedRole newResourceProvidedRole_ResourceProvidedRoleAllocationConnector) {
		// TODO: implement this method to set the 'Resource Provided Role Resource Provided Role Allocation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerInstance getRequiringControllerInstance_ControllerAllocationConnector() {
		ControllerInstance requiringControllerInstance_ControllerAllocationConnector = basicGetRequiringControllerInstance_ControllerAllocationConnector();
		return requiringControllerInstance_ControllerAllocationConnector != null && requiringControllerInstance_ControllerAllocationConnector.eIsProxy() ? (ControllerInstance)eResolveProxy((InternalEObject)requiringControllerInstance_ControllerAllocationConnector) : requiringControllerInstance_ControllerAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerInstance basicGetRequiringControllerInstance_ControllerAllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiringControllerInstance_ControllerAllocationConnector(ControllerInstance newRequiringControllerInstance_ControllerAllocationConnector) {
		// TODO: implement this method to set the 'Requiring Controller Instance Controller Allocation Connector' reference
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
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				if (resolve) return getResourceProvidedRole_ResourceProvidedRoleAllocationConnector();
				return basicGetResourceProvidedRole_ResourceProvidedRoleAllocationConnector();
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__REQUIRING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				if (resolve) return getRequiringControllerInstance_ControllerAllocationConnector();
				return basicGetRequiringControllerInstance_ControllerAllocationConnector();
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
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setResourceProvidedRole_ResourceProvidedRoleAllocationConnector((ResourceProvidedRole)newValue);
				return;
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__REQUIRING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setRequiringControllerInstance_ControllerAllocationConnector((ControllerInstance)newValue);
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
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setResourceProvidedRole_ResourceProvidedRoleAllocationConnector((ResourceProvidedRole)null);
				return;
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__REQUIRING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setRequiringControllerInstance_ControllerAllocationConnector((ControllerInstance)null);
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
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				return basicGetResourceProvidedRole_ResourceProvidedRoleAllocationConnector() != null;
			case ResourceenvironmentPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__REQUIRING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				return basicGetRequiringControllerInstance_ControllerAllocationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceProvidedRoleConnectorImpl
