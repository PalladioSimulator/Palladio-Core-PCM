/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controller Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerAllocationConnectorImpl#getProvidingControllerInstance_ControllerAllocationConnector <em>Providing Controller Instance Controller Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControllerAllocationConnectorImpl extends ResourceProvidedRoleConnectorImpl implements ControllerAllocationConnector {
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
	protected ControllerAllocationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.CONTROLLER_ALLOCATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerInstance getProvidingControllerInstance_ControllerAllocationConnector() {
		ControllerInstance providingControllerInstance_ControllerAllocationConnector = basicGetProvidingControllerInstance_ControllerAllocationConnector();
		return providingControllerInstance_ControllerAllocationConnector != null && providingControllerInstance_ControllerAllocationConnector.eIsProxy() ? (ControllerInstance)eResolveProxy((InternalEObject)providingControllerInstance_ControllerAllocationConnector) : providingControllerInstance_ControllerAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerInstance basicGetProvidingControllerInstance_ControllerAllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingControllerInstance_ControllerAllocationConnector(ControllerInstance newProvidingControllerInstance_ControllerAllocationConnector) {
		// TODO: implement this method to set the 'Providing Controller Instance Controller Allocation Connector' reference
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__PROVIDING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				if (resolve) return getProvidingControllerInstance_ControllerAllocationConnector();
				return basicGetProvidingControllerInstance_ControllerAllocationConnector();
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__PROVIDING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setProvidingControllerInstance_ControllerAllocationConnector((ControllerInstance)newValue);
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__PROVIDING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setProvidingControllerInstance_ControllerAllocationConnector((ControllerInstance)null);
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__PROVIDING_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				return basicGetProvidingControllerInstance_ControllerAllocationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //ControllerAllocationConnectorImpl
