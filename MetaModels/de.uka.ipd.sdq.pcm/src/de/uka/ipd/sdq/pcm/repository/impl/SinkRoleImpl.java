/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Sink Role</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.SinkRoleImpl#getEventGroup__SinkRole <em>Event Group
 * Sink Role</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SinkRoleImpl extends ProvidedRoleImpl implements SinkRole {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getEventGroup__SinkRole() <em>Event Group Sink Role</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEventGroup__SinkRole()
     * @generated
     * @ordered
     */
    protected EventGroup eventGroup__SinkRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SinkRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.SINK_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventGroup getEventGroup__SinkRole() {
        if (this.eventGroup__SinkRole != null && ((EObject) this.eventGroup__SinkRole).eIsProxy()) {
            final InternalEObject oldEventGroup__SinkRole = (InternalEObject) this.eventGroup__SinkRole;
            this.eventGroup__SinkRole = (EventGroup) this.eResolveProxy(oldEventGroup__SinkRole);
            if (this.eventGroup__SinkRole != oldEventGroup__SinkRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE, oldEventGroup__SinkRole,
                            this.eventGroup__SinkRole));
                }
            }
        }
        return this.eventGroup__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventGroup basicGetEventGroup__SinkRole() {
        return this.eventGroup__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEventGroup__SinkRole(final EventGroup newEventGroup__SinkRole) {
        final EventGroup oldEventGroup__SinkRole = this.eventGroup__SinkRole;
        this.eventGroup__SinkRole = newEventGroup__SinkRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE, oldEventGroup__SinkRole,
                    this.eventGroup__SinkRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
            if (resolve) {
                return this.getEventGroup__SinkRole();
            }
            return this.basicGetEventGroup__SinkRole();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
            this.setEventGroup__SinkRole((EventGroup) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
            this.setEventGroup__SinkRole((EventGroup) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case RepositoryPackage.SINK_ROLE__EVENT_GROUP_SINK_ROLE:
            return this.eventGroup__SinkRole != null;
        }
        return super.eIsSet(featureID);
    }

} // SinkRoleImpl
