/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controller Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerAllocationConnectorImpl#getToControllerInstance_ControllerAllocationConnector <em>To Controller Instance Controller Allocation Connector</em>}</li>
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
	 * The cached value of the '{@link #getToControllerInstance_ControllerAllocationConnector() <em>To Controller Instance Controller Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToControllerInstance_ControllerAllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected ControllerInstance toControllerInstance_ControllerAllocationConnector;

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
	public ControllerInstance getToControllerInstance_ControllerAllocationConnector() {
		if (toControllerInstance_ControllerAllocationConnector != null && toControllerInstance_ControllerAllocationConnector.eIsProxy()) {
			InternalEObject oldToControllerInstance_ControllerAllocationConnector = (InternalEObject)toControllerInstance_ControllerAllocationConnector;
			toControllerInstance_ControllerAllocationConnector = (ControllerInstance)eResolveProxy(oldToControllerInstance_ControllerAllocationConnector);
			if (toControllerInstance_ControllerAllocationConnector != oldToControllerInstance_ControllerAllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR, oldToControllerInstance_ControllerAllocationConnector, toControllerInstance_ControllerAllocationConnector));
			}
		}
		return toControllerInstance_ControllerAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerInstance basicGetToControllerInstance_ControllerAllocationConnector() {
		return toControllerInstance_ControllerAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToControllerInstance_ControllerAllocationConnector(ControllerInstance newToControllerInstance_ControllerAllocationConnector, NotificationChain msgs) {
		ControllerInstance oldToControllerInstance_ControllerAllocationConnector = toControllerInstance_ControllerAllocationConnector;
		toControllerInstance_ControllerAllocationConnector = newToControllerInstance_ControllerAllocationConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR, oldToControllerInstance_ControllerAllocationConnector, newToControllerInstance_ControllerAllocationConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToControllerInstance_ControllerAllocationConnector(ControllerInstance newToControllerInstance_ControllerAllocationConnector) {
		if (newToControllerInstance_ControllerAllocationConnector != toControllerInstance_ControllerAllocationConnector) {
			NotificationChain msgs = null;
			if (toControllerInstance_ControllerAllocationConnector != null)
				msgs = ((InternalEObject)toControllerInstance_ControllerAllocationConnector).eInverseRemove(this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, ControllerInstance.class, msgs);
			if (newToControllerInstance_ControllerAllocationConnector != null)
				msgs = ((InternalEObject)newToControllerInstance_ControllerAllocationConnector).eInverseAdd(this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, ControllerInstance.class, msgs);
			msgs = basicSetToControllerInstance_ControllerAllocationConnector(newToControllerInstance_ControllerAllocationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR, newToControllerInstance_ControllerAllocationConnector, newToControllerInstance_ControllerAllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				if (toControllerInstance_ControllerAllocationConnector != null)
					msgs = ((InternalEObject)toControllerInstance_ControllerAllocationConnector).eInverseRemove(this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, ControllerInstance.class, msgs);
				return basicSetToControllerInstance_ControllerAllocationConnector((ControllerInstance)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				return basicSetToControllerInstance_ControllerAllocationConnector(null, msgs);
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				if (resolve) return getToControllerInstance_ControllerAllocationConnector();
				return basicGetToControllerInstance_ControllerAllocationConnector();
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setToControllerInstance_ControllerAllocationConnector((ControllerInstance)newValue);
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setToControllerInstance_ControllerAllocationConnector((ControllerInstance)null);
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
			case ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				return toControllerInstance_ControllerAllocationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //ControllerAllocationConnectorImpl
