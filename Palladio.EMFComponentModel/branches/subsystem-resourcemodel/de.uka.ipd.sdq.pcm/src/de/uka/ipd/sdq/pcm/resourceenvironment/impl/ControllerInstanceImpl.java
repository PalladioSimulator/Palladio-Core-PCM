/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceProvidedRoleConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controller Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerInstanceImpl#getControllerScope_ResourceContainer <em>Controller Scope Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerInstanceImpl#getUpperControllerAllocationConnectors_ControllerInstance <em>Upper Controller Allocation Connectors Controller Instance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerInstanceImpl#getLowerControllerAllocationConnectors_ControllerInstance <em>Lower Controller Allocation Connectors Controller Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControllerInstanceImpl extends EObjectImpl implements ControllerInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getControllerScope_ResourceContainer() <em>Controller Scope Resource Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerScope_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected ControllerLayer controllerScope_ResourceContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControllerInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.CONTROLLER_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer getControllerScope_ResourceContainer() {
		if (controllerScope_ResourceContainer != null && controllerScope_ResourceContainer.eIsProxy()) {
			InternalEObject oldControllerScope_ResourceContainer = (InternalEObject)controllerScope_ResourceContainer;
			controllerScope_ResourceContainer = (ControllerLayer)eResolveProxy(oldControllerScope_ResourceContainer);
			if (controllerScope_ResourceContainer != oldControllerScope_ResourceContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_SCOPE_RESOURCE_CONTAINER, oldControllerScope_ResourceContainer, controllerScope_ResourceContainer));
			}
		}
		return controllerScope_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer basicGetControllerScope_ResourceContainer() {
		return controllerScope_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerScope_ResourceContainer(ControllerLayer newControllerScope_ResourceContainer) {
		ControllerLayer oldControllerScope_ResourceContainer = controllerScope_ResourceContainer;
		controllerScope_ResourceContainer = newControllerScope_ResourceContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_SCOPE_RESOURCE_CONTAINER, oldControllerScope_ResourceContainer, controllerScope_ResourceContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControllerAllocationConnector> getUpperControllerAllocationConnectors_ControllerInstance() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceProvidedRoleConnector> getLowerControllerAllocationConnectors_ControllerInstance() {
		// TODO: implement this method
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_SCOPE_RESOURCE_CONTAINER:
				if (resolve) return getControllerScope_ResourceContainer();
				return basicGetControllerScope_ResourceContainer();
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return getUpperControllerAllocationConnectors_ControllerInstance();
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return getLowerControllerAllocationConnectors_ControllerInstance();
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_SCOPE_RESOURCE_CONTAINER:
				setControllerScope_ResourceContainer((ControllerLayer)newValue);
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getUpperControllerAllocationConnectors_ControllerInstance().clear();
				getUpperControllerAllocationConnectors_ControllerInstance().addAll((Collection<? extends ControllerAllocationConnector>)newValue);
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getLowerControllerAllocationConnectors_ControllerInstance().clear();
				getLowerControllerAllocationConnectors_ControllerInstance().addAll((Collection<? extends ResourceProvidedRoleConnector>)newValue);
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_SCOPE_RESOURCE_CONTAINER:
				setControllerScope_ResourceContainer((ControllerLayer)null);
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getUpperControllerAllocationConnectors_ControllerInstance().clear();
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getLowerControllerAllocationConnectors_ControllerInstance().clear();
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_SCOPE_RESOURCE_CONTAINER:
				return controllerScope_ResourceContainer != null;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return !getUpperControllerAllocationConnectors_ControllerInstance().isEmpty();
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return !getLowerControllerAllocationConnectors_ControllerInstance().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ControllerInstanceImpl
