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
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.repository.impl.RoleImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Provided Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceProvidedRoleImpl#getResourceInterfaceProvidingEntity__ResourceProvidedRole
 * <em>Resource Interface Providing Entity Resource Provided Role</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceProvidedRoleImpl#getProvidedResourceInterface__ResourceProvidedRole
 * <em>Provided Resource Interface Resource Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceProvidedRoleImpl extends RoleImpl implements ResourceProvidedRole {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getProvidedResourceInterface__ResourceProvidedRole()
     * <em>Provided Resource Interface Resource Provided Role</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getProvidedResourceInterface__ResourceProvidedRole()
     * @generated
     * @ordered
     */
    protected ResourceInterface providedResourceInterface__ResourceProvidedRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceProvidedRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EntityPackage.Literals.RESOURCE_PROVIDED_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceInterfaceProvidingEntity getResourceInterfaceProvidingEntity__ResourceProvidedRole() {
        if (this.eContainerFeatureID() != EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE) {
            return null;
        }
        return (ResourceInterfaceProvidingEntity) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetResourceInterfaceProvidingEntity__ResourceProvidedRole(
            final ResourceInterfaceProvidingEntity newResourceInterfaceProvidingEntity__ResourceProvidedRole,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newResourceInterfaceProvidingEntity__ResourceProvidedRole,
                EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceInterfaceProvidingEntity__ResourceProvidedRole(
            final ResourceInterfaceProvidingEntity newResourceInterfaceProvidingEntity__ResourceProvidedRole) {
        if (newResourceInterfaceProvidingEntity__ResourceProvidedRole != this.eInternalContainer()
                || (this.eContainerFeatureID() != EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE && newResourceInterfaceProvidingEntity__ResourceProvidedRole != null)) {
            if (EcoreUtil.isAncestor(this, newResourceInterfaceProvidingEntity__ResourceProvidedRole)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newResourceInterfaceProvidingEntity__ResourceProvidedRole != null) {
                msgs = ((InternalEObject) newResourceInterfaceProvidingEntity__ResourceProvidedRole)
                        .eInverseAdd(
                                this,
                                EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY,
                                ResourceInterfaceProvidingEntity.class, msgs);
            }
            msgs = this.basicSetResourceInterfaceProvidingEntity__ResourceProvidedRole(
                    newResourceInterfaceProvidingEntity__ResourceProvidedRole, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE,
                    newResourceInterfaceProvidingEntity__ResourceProvidedRole,
                    newResourceInterfaceProvidingEntity__ResourceProvidedRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceInterface getProvidedResourceInterface__ResourceProvidedRole() {
        if (this.providedResourceInterface__ResourceProvidedRole != null
                && ((EObject) this.providedResourceInterface__ResourceProvidedRole).eIsProxy()) {
            final InternalEObject oldProvidedResourceInterface__ResourceProvidedRole = (InternalEObject) this.providedResourceInterface__ResourceProvidedRole;
            this.providedResourceInterface__ResourceProvidedRole = (ResourceInterface) this
                    .eResolveProxy(oldProvidedResourceInterface__ResourceProvidedRole);
            if (this.providedResourceInterface__ResourceProvidedRole != oldProvidedResourceInterface__ResourceProvidedRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE,
                            oldProvidedResourceInterface__ResourceProvidedRole,
                            this.providedResourceInterface__ResourceProvidedRole));
                }
            }
        }
        return this.providedResourceInterface__ResourceProvidedRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceInterface basicGetProvidedResourceInterface__ResourceProvidedRole() {
        return this.providedResourceInterface__ResourceProvidedRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProvidedResourceInterface__ResourceProvidedRole(
            final ResourceInterface newProvidedResourceInterface__ResourceProvidedRole) {
        final ResourceInterface oldProvidedResourceInterface__ResourceProvidedRole = this.providedResourceInterface__ResourceProvidedRole;
        this.providedResourceInterface__ResourceProvidedRole = newProvidedResourceInterface__ResourceProvidedRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE,
                    oldProvidedResourceInterface__ResourceProvidedRole,
                    this.providedResourceInterface__ResourceProvidedRole));
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceInterfaceProvidingEntity__ResourceProvidedRole(
                    (ResourceInterfaceProvidingEntity) otherEnd, msgs);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return this.basicSetResourceInterfaceProvidingEntity__ResourceProvidedRole(null, msgs);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return this
                    .eInternalContainer()
                    .eInverseRemove(
                            this,
                            EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY,
                            ResourceInterfaceProvidingEntity.class, msgs);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return this.getResourceInterfaceProvidingEntity__ResourceProvidedRole();
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            if (resolve) {
                return this.getProvidedResourceInterface__ResourceProvidedRole();
            }
            return this.basicGetProvidedResourceInterface__ResourceProvidedRole();
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            this.setResourceInterfaceProvidingEntity__ResourceProvidedRole((ResourceInterfaceProvidingEntity) newValue);
            return;
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            this.setProvidedResourceInterface__ResourceProvidedRole((ResourceInterface) newValue);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            this.setResourceInterfaceProvidingEntity__ResourceProvidedRole((ResourceInterfaceProvidingEntity) null);
            return;
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            this.setProvidedResourceInterface__ResourceProvidedRole((ResourceInterface) null);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return this.getResourceInterfaceProvidingEntity__ResourceProvidedRole() != null;
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            return this.providedResourceInterface__ResourceProvidedRole != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceProvidedRoleImpl
