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

import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operation Provided Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.OperationProvidedRoleImpl#getProvidedInterface__OperationProvidedRole
 * <em>Provided Interface Operation Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationProvidedRoleImpl extends ProvidedRoleImpl implements OperationProvidedRole {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getProvidedInterface__OperationProvidedRole()
     * <em>Provided Interface Operation Provided Role</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getProvidedInterface__OperationProvidedRole()
     * @generated
     * @ordered
     */
    protected OperationInterface providedInterface__OperationProvidedRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected OperationProvidedRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.OPERATION_PROVIDED_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationInterface getProvidedInterface__OperationProvidedRole() {
        if (this.providedInterface__OperationProvidedRole != null
                && this.providedInterface__OperationProvidedRole.eIsProxy()) {
            final InternalEObject oldProvidedInterface__OperationProvidedRole = (InternalEObject) this.providedInterface__OperationProvidedRole;
            this.providedInterface__OperationProvidedRole = (OperationInterface) this
                    .eResolveProxy(oldProvidedInterface__OperationProvidedRole);
            if (this.providedInterface__OperationProvidedRole != oldProvidedInterface__OperationProvidedRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.OPERATION_PROVIDED_ROLE__PROVIDED_INTERFACE_OPERATION_PROVIDED_ROLE,
                            oldProvidedInterface__OperationProvidedRole, this.providedInterface__OperationProvidedRole));
                }
            }
        }
        return this.providedInterface__OperationProvidedRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationInterface basicGetProvidedInterface__OperationProvidedRole() {
        return this.providedInterface__OperationProvidedRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProvidedInterface__OperationProvidedRole(
            final OperationInterface newProvidedInterface__OperationProvidedRole) {
        final OperationInterface oldProvidedInterface__OperationProvidedRole = this.providedInterface__OperationProvidedRole;
        this.providedInterface__OperationProvidedRole = newProvidedInterface__OperationProvidedRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.OPERATION_PROVIDED_ROLE__PROVIDED_INTERFACE_OPERATION_PROVIDED_ROLE,
                    oldProvidedInterface__OperationProvidedRole, this.providedInterface__OperationProvidedRole));
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
        case RepositoryPackage.OPERATION_PROVIDED_ROLE__PROVIDED_INTERFACE_OPERATION_PROVIDED_ROLE:
            if (resolve) {
                return this.getProvidedInterface__OperationProvidedRole();
            }
            return this.basicGetProvidedInterface__OperationProvidedRole();
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
        case RepositoryPackage.OPERATION_PROVIDED_ROLE__PROVIDED_INTERFACE_OPERATION_PROVIDED_ROLE:
            this.setProvidedInterface__OperationProvidedRole((OperationInterface) newValue);
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
        case RepositoryPackage.OPERATION_PROVIDED_ROLE__PROVIDED_INTERFACE_OPERATION_PROVIDED_ROLE:
            this.setProvidedInterface__OperationProvidedRole((OperationInterface) null);
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
        case RepositoryPackage.OPERATION_PROVIDED_ROLE__PROVIDED_INTERFACE_OPERATION_PROVIDED_ROLE:
            return this.providedInterface__OperationProvidedRole != null;
        }
        return super.eIsSet(featureID);
    }

} // OperationProvidedRoleImpl
