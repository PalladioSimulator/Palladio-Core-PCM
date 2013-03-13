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
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Role</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SourceRoleImpl#getEventGroup__SourceRole <em>Event Group Source Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceRoleImpl extends RequiredRoleImpl implements SourceRole {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached value of the '{@link #getEventGroup__SourceRole() <em>Event Group Source Role</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEventGroup__SourceRole()
	 * @generated
	 * @ordered
	 */
    protected EventGroup eventGroup__SourceRole;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected SourceRoleImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RepositoryPackage.Literals.SOURCE_ROLE;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EventGroup getEventGroup__SourceRole() {
		if (eventGroup__SourceRole != null && eventGroup__SourceRole.eIsProxy()) {
			InternalEObject oldEventGroup__SourceRole = (InternalEObject)eventGroup__SourceRole;
			eventGroup__SourceRole = (EventGroup)eResolveProxy(oldEventGroup__SourceRole);
			if (eventGroup__SourceRole != oldEventGroup__SourceRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.SOURCE_ROLE__EVENT_GROUP_SOURCE_ROLE, oldEventGroup__SourceRole, eventGroup__SourceRole));
			}
		}
		return eventGroup__SourceRole;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EventGroup basicGetEventGroup__SourceRole() {
		return eventGroup__SourceRole;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setEventGroup__SourceRole(EventGroup newEventGroup__SourceRole) {
		EventGroup oldEventGroup__SourceRole = eventGroup__SourceRole;
		eventGroup__SourceRole = newEventGroup__SourceRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SOURCE_ROLE__EVENT_GROUP_SOURCE_ROLE, oldEventGroup__SourceRole, eventGroup__SourceRole));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.SOURCE_ROLE__EVENT_GROUP_SOURCE_ROLE:
				if (resolve) return getEventGroup__SourceRole();
				return basicGetEventGroup__SourceRole();
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
			case RepositoryPackage.SOURCE_ROLE__EVENT_GROUP_SOURCE_ROLE:
				setEventGroup__SourceRole((EventGroup)newValue);
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
			case RepositoryPackage.SOURCE_ROLE__EVENT_GROUP_SOURCE_ROLE:
				setEventGroup__SourceRole((EventGroup)null);
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
			case RepositoryPackage.SOURCE_ROLE__EVENT_GROUP_SOURCE_ROLE:
				return eventGroup__SourceRole != null;
		}
		return super.eIsSet(featureID);
	}

} // SourceRoleImpl
