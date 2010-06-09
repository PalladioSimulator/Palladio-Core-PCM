/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sink Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SinkRoleImpl#getEventgroup__SinkRole <em>Eventgroup Sink Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SinkRoleImpl extends ProvidedRoleImpl implements SinkRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getEventgroup__SinkRole() <em>Eventgroup Sink Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventgroup__SinkRole()
	 * @generated
	 * @ordered
	 */
	protected EventGroup eventgroup__SinkRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SinkRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.SINK_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup getEventgroup__SinkRole() {
		if (eventgroup__SinkRole != null && eventgroup__SinkRole.eIsProxy()) {
			InternalEObject oldEventgroup__SinkRole = (InternalEObject)eventgroup__SinkRole;
			eventgroup__SinkRole = (EventGroup)eResolveProxy(oldEventgroup__SinkRole);
			if (eventgroup__SinkRole != oldEventgroup__SinkRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.SINK_ROLE__EVENTGROUP_SINK_ROLE, oldEventgroup__SinkRole, eventgroup__SinkRole));
			}
		}
		return eventgroup__SinkRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetEventgroup__SinkRole() {
		return eventgroup__SinkRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventgroup__SinkRole(EventGroup newEventgroup__SinkRole) {
		EventGroup oldEventgroup__SinkRole = eventgroup__SinkRole;
		eventgroup__SinkRole = newEventgroup__SinkRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SINK_ROLE__EVENTGROUP_SINK_ROLE, oldEventgroup__SinkRole, eventgroup__SinkRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.SINK_ROLE__EVENTGROUP_SINK_ROLE:
				if (resolve) return getEventgroup__SinkRole();
				return basicGetEventgroup__SinkRole();
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
			case RepositoryPackage.SINK_ROLE__EVENTGROUP_SINK_ROLE:
				setEventgroup__SinkRole((EventGroup)newValue);
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
			case RepositoryPackage.SINK_ROLE__EVENTGROUP_SINK_ROLE:
				setEventgroup__SinkRole((EventGroup)null);
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
			case RepositoryPackage.SINK_ROLE__EVENTGROUP_SINK_ROLE:
				return eventgroup__SinkRole != null;
		}
		return super.eIsSet(featureID);
	}

} //SinkRoleImpl
