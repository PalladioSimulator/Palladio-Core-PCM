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

import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Infrastructure Required Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.InfrastructureRequiredRoleImpl#getRequiredInterface__InfrastructureRequiredRole
 * <em>Required Interface Infrastructure Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureRequiredRoleImpl extends RequiredRoleImpl implements InfrastructureRequiredRole {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getRequiredInterface__InfrastructureRequiredRole()
     * <em>Required Interface Infrastructure Required Role</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRequiredInterface__InfrastructureRequiredRole()
     * @generated
     * @ordered
     */
    protected InfrastructureInterface requiredInterface__InfrastructureRequiredRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InfrastructureRequiredRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.INFRASTRUCTURE_REQUIRED_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureInterface getRequiredInterface__InfrastructureRequiredRole() {
        if (this.requiredInterface__InfrastructureRequiredRole != null
                && this.requiredInterface__InfrastructureRequiredRole.eIsProxy()) {
            final InternalEObject oldRequiredInterface__InfrastructureRequiredRole = (InternalEObject) this.requiredInterface__InfrastructureRequiredRole;
            this.requiredInterface__InfrastructureRequiredRole = (InfrastructureInterface) this
                    .eResolveProxy(oldRequiredInterface__InfrastructureRequiredRole);
            if (this.requiredInterface__InfrastructureRequiredRole != oldRequiredInterface__InfrastructureRequiredRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE__REQUIRED_INTERFACE_INFRASTRUCTURE_REQUIRED_ROLE,
                            oldRequiredInterface__InfrastructureRequiredRole,
                            this.requiredInterface__InfrastructureRequiredRole));
                }
            }
        }
        return this.requiredInterface__InfrastructureRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureInterface basicGetRequiredInterface__InfrastructureRequiredRole() {
        return this.requiredInterface__InfrastructureRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredInterface__InfrastructureRequiredRole(
            final InfrastructureInterface newRequiredInterface__InfrastructureRequiredRole) {
        final InfrastructureInterface oldRequiredInterface__InfrastructureRequiredRole = this.requiredInterface__InfrastructureRequiredRole;
        this.requiredInterface__InfrastructureRequiredRole = newRequiredInterface__InfrastructureRequiredRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE__REQUIRED_INTERFACE_INFRASTRUCTURE_REQUIRED_ROLE,
                    oldRequiredInterface__InfrastructureRequiredRole,
                    this.requiredInterface__InfrastructureRequiredRole));
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
        case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE__REQUIRED_INTERFACE_INFRASTRUCTURE_REQUIRED_ROLE:
            if (resolve) {
                return this.getRequiredInterface__InfrastructureRequiredRole();
            }
            return this.basicGetRequiredInterface__InfrastructureRequiredRole();
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
        case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE__REQUIRED_INTERFACE_INFRASTRUCTURE_REQUIRED_ROLE:
            this.setRequiredInterface__InfrastructureRequiredRole((InfrastructureInterface) newValue);
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
        case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE__REQUIRED_INTERFACE_INFRASTRUCTURE_REQUIRED_ROLE:
            this.setRequiredInterface__InfrastructureRequiredRole((InfrastructureInterface) null);
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
        case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE__REQUIRED_INTERFACE_INFRASTRUCTURE_REQUIRED_ROLE:
            return this.requiredInterface__InfrastructureRequiredRole != null;
        }
        return super.eIsSet(featureID);
    }

} // InfrastructureRequiredRoleImpl
