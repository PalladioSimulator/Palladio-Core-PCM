/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Required Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl#getRequiringEntity_RequiredRole
 * <em>Requiring Entity Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RequiredRoleImpl extends RoleImpl implements RequiredRole {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RequiredRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.REQUIRED_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InterfaceRequiringEntity getRequiringEntity_RequiredRole() {
        if (this.eContainerFeatureID() != RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE) {
            return null;
        }
        return (InterfaceRequiringEntity) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetRequiringEntity_RequiredRole(
            final InterfaceRequiringEntity newRequiringEntity_RequiredRole, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newRequiringEntity_RequiredRole,
                RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRequiringEntity_RequiredRole(final InterfaceRequiringEntity newRequiringEntity_RequiredRole) {
        if (newRequiringEntity_RequiredRole != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE && newRequiringEntity_RequiredRole != null)) {
            if (EcoreUtil.isAncestor(this, newRequiringEntity_RequiredRole)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newRequiringEntity_RequiredRole != null) {
                msgs = ((InternalEObject) newRequiringEntity_RequiredRole).eInverseAdd(this,
                        EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                        InterfaceRequiringEntity.class, msgs);
            }
            msgs = this.basicSetRequiringEntity_RequiredRole(newRequiringEntity_RequiredRole, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE, newRequiringEntity_RequiredRole,
                    newRequiringEntity_RequiredRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetRequiringEntity_RequiredRole((InterfaceRequiringEntity) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
            return this.basicSetRequiringEntity_RequiredRole(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
            return this.eInternalContainer().eInverseRemove(this,
                    EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                    InterfaceRequiringEntity.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
            return this.getRequiringEntity_RequiredRole();
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
        case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
            this.setRequiringEntity_RequiredRole((InterfaceRequiringEntity) newValue);
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
        case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
            this.setRequiringEntity_RequiredRole((InterfaceRequiringEntity) null);
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
        case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
            return this.getRequiringEntity_RequiredRole() != null;
        }
        return super.eIsSet(featureID);
    }

} // RequiredRoleImpl
