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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sink Role</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SinkRoleImpl#getEventGroup__SinkRole <em>Event Group Sink Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SinkRoleImpl extends ProvidedRoleImpl implements SinkRole {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached value of the '{@link #getEventGroup__SinkRole() <em>Event Group Sink Role</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEventGroup__SinkRole()
	 * @generated
	 * @ordered
	 */
    protected EventGroup eventGroup__SinkRole;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected SinkRoleImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RepositoryPackage.Literals.SINK_ROLE;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EventGroup getEventGroup__SinkRole() {
		if (eventGroup__SinkRole != null && eventGroup__SinkRole.eIsProxy()) {
			InternalEObject oldEventGroup__SinkRole = (InternalEObject)eventGroup__SinkRole;
			eventGroup__SinkRole = (EventGroup)eResolveProxy(oldEventGroup__SinkRole);
			if (eventGroup__SinkRole != oldEventGroup__SinkRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE, oldEventGroup__SinkRole, eventGroup__SinkRole));
			}
		}
		return eventGroup__SinkRole;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EventGroup basicGetEventGroup__SinkRole() {
		return eventGroup__SinkRole;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setEventGroup__SinkRole(EventGroup newEventGroup__SinkRole) {
		EventGroup oldEventGroup__SinkRole = eventGroup__SinkRole;
		eventGroup__SinkRole = newEventGroup__SinkRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE, oldEventGroup__SinkRole, eventGroup__SinkRole));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
				if (resolve) return getEventGroup__SinkRole();
				return basicGetEventGroup__SinkRole();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
				setEventGroup__SinkRole((EventGroup)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
				setEventGroup__SinkRole((EventGroup)null);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
				return eventGroup__SinkRole != null;
		}
		return super.eIsSet(featureID);
	}

} // SinkRoleImpl
