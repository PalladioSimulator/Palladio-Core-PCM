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
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SourceRoleImpl#getEventgroup__SourceRole <em>Eventgroup Source Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceRoleImpl extends RequiredRoleImpl implements SourceRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getEventgroup__SourceRole() <em>Eventgroup Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventgroup__SourceRole()
	 * @generated
	 * @ordered
	 */
	protected EventGroup eventgroup__SourceRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.SOURCE_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup getEventgroup__SourceRole() {
		if (eventgroup__SourceRole != null && eventgroup__SourceRole.eIsProxy()) {
			InternalEObject oldEventgroup__SourceRole = (InternalEObject)eventgroup__SourceRole;
			eventgroup__SourceRole = (EventGroup)eResolveProxy(oldEventgroup__SourceRole);
			if (eventgroup__SourceRole != oldEventgroup__SourceRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.SOURCE_ROLE__EVENTGROUP_SOURCE_ROLE, oldEventgroup__SourceRole, eventgroup__SourceRole));
			}
		}
		return eventgroup__SourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetEventgroup__SourceRole() {
		return eventgroup__SourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventgroup__SourceRole(EventGroup newEventgroup__SourceRole) {
		EventGroup oldEventgroup__SourceRole = eventgroup__SourceRole;
		eventgroup__SourceRole = newEventgroup__SourceRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SOURCE_ROLE__EVENTGROUP_SOURCE_ROLE, oldEventgroup__SourceRole, eventgroup__SourceRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.SOURCE_ROLE__EVENTGROUP_SOURCE_ROLE:
				if (resolve) return getEventgroup__SourceRole();
				return basicGetEventgroup__SourceRole();
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
			case RepositoryPackage.SOURCE_ROLE__EVENTGROUP_SOURCE_ROLE:
				setEventgroup__SourceRole((EventGroup)newValue);
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
			case RepositoryPackage.SOURCE_ROLE__EVENTGROUP_SOURCE_ROLE:
				setEventgroup__SourceRole((EventGroup)null);
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
			case RepositoryPackage.SOURCE_ROLE__EVENTGROUP_SOURCE_ROLE:
				return eventgroup__SourceRole != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceRoleImpl
