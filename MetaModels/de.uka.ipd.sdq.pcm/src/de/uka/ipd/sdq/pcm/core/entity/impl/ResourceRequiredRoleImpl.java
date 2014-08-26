/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.repository.impl.RoleImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Required Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceRequiredRoleImpl#getRequiredResourceInterface__ResourceRequiredRole
 * <em>Required Resource Interface Resource Required Role</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceRequiredRoleImpl#getResourceInterfaceRequiringEntity__ResourceRequiredRole
 * <em>Resource Interface Requiring Entity Resource Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceRequiredRoleImpl extends RoleImpl implements ResourceRequiredRole {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getRequiredResourceInterface__ResourceRequiredRole()
     * <em>Required Resource Interface Resource Required Role</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getRequiredResourceInterface__ResourceRequiredRole()
     * @generated
     * @ordered
     */
    protected ResourceInterface requiredResourceInterface__ResourceRequiredRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceRequiredRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EntityPackage.Literals.RESOURCE_REQUIRED_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceInterface getRequiredResourceInterface__ResourceRequiredRole() {
        if (this.requiredResourceInterface__ResourceRequiredRole != null
                && ((EObject) this.requiredResourceInterface__ResourceRequiredRole).eIsProxy()) {
            final InternalEObject oldRequiredResourceInterface__ResourceRequiredRole = (InternalEObject) this.requiredResourceInterface__ResourceRequiredRole;
            this.requiredResourceInterface__ResourceRequiredRole = (ResourceInterface) this
                    .eResolveProxy(oldRequiredResourceInterface__ResourceRequiredRole);
            if (this.requiredResourceInterface__ResourceRequiredRole != oldRequiredResourceInterface__ResourceRequiredRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            EntityPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE,
                            oldRequiredResourceInterface__ResourceRequiredRole,
                            this.requiredResourceInterface__ResourceRequiredRole));
                }
            }
        }
        return this.requiredResourceInterface__ResourceRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceInterface basicGetRequiredResourceInterface__ResourceRequiredRole() {
        return this.requiredResourceInterface__ResourceRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRequiredResourceInterface__ResourceRequiredRole(
            final ResourceInterface newRequiredResourceInterface__ResourceRequiredRole) {
        final ResourceInterface oldRequiredResourceInterface__ResourceRequiredRole = this.requiredResourceInterface__ResourceRequiredRole;
        this.requiredResourceInterface__ResourceRequiredRole = newRequiredResourceInterface__ResourceRequiredRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    EntityPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE,
                    oldRequiredResourceInterface__ResourceRequiredRole,
                    this.requiredResourceInterface__ResourceRequiredRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceInterfaceRequiringEntity getResourceInterfaceRequiringEntity__ResourceRequiredRole() {
        if (this.eContainerFeatureID() != EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE) {
            return null;
        }
        return (ResourceInterfaceRequiringEntity) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetResourceInterfaceRequiringEntity__ResourceRequiredRole(
            final ResourceInterfaceRequiringEntity newResourceInterfaceRequiringEntity__ResourceRequiredRole,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newResourceInterfaceRequiringEntity__ResourceRequiredRole,
                EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceInterfaceRequiringEntity__ResourceRequiredRole(
            final ResourceInterfaceRequiringEntity newResourceInterfaceRequiringEntity__ResourceRequiredRole) {
        if (newResourceInterfaceRequiringEntity__ResourceRequiredRole != this.eInternalContainer()
                || (this.eContainerFeatureID() != EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE && newResourceInterfaceRequiringEntity__ResourceRequiredRole != null)) {
            if (EcoreUtil.isAncestor(this, newResourceInterfaceRequiringEntity__ResourceRequiredRole)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newResourceInterfaceRequiringEntity__ResourceRequiredRole != null) {
                msgs = ((InternalEObject) newResourceInterfaceRequiringEntity__ResourceRequiredRole)
                        .eInverseAdd(
                                this,
                                EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                                ResourceInterfaceRequiringEntity.class, msgs);
            }
            msgs = this.basicSetResourceInterfaceRequiringEntity__ResourceRequiredRole(
                    newResourceInterfaceRequiringEntity__ResourceRequiredRole, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE,
                    newResourceInterfaceRequiringEntity__ResourceRequiredRole,
                    newResourceInterfaceRequiringEntity__ResourceRequiredRole));
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
        case EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceInterfaceRequiringEntity__ResourceRequiredRole(
                    (ResourceInterfaceRequiringEntity) otherEnd, msgs);
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
        case EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
            return this.basicSetResourceInterfaceRequiringEntity__ResourceRequiredRole(null, msgs);
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
        case EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
            return this
                    .eInternalContainer()
                    .eInverseRemove(
                            this,
                            EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                            ResourceInterfaceRequiringEntity.class, msgs);
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
        case EntityPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
            if (resolve) {
                return this.getRequiredResourceInterface__ResourceRequiredRole();
            }
            return this.basicGetRequiredResourceInterface__ResourceRequiredRole();
        case EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
            return this.getResourceInterfaceRequiringEntity__ResourceRequiredRole();
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
        case EntityPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
            this.setRequiredResourceInterface__ResourceRequiredRole((ResourceInterface) newValue);
            return;
        case EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
            this.setResourceInterfaceRequiringEntity__ResourceRequiredRole((ResourceInterfaceRequiringEntity) newValue);
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
        case EntityPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
            this.setRequiredResourceInterface__ResourceRequiredRole((ResourceInterface) null);
            return;
        case EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
            this.setResourceInterfaceRequiringEntity__ResourceRequiredRole((ResourceInterfaceRequiringEntity) null);
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
        case EntityPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
            return this.requiredResourceInterface__ResourceRequiredRole != null;
        case EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
            return this.getResourceInterfaceRequiringEntity__ResourceRequiredRole() != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceRequiredRoleImpl
