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

import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operation Required Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.OperationRequiredRoleImpl#getRequiredInterface__OperationRequiredRole
 * <em>Required Interface Operation Required Role</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OperationRequiredRoleImpl extends RequiredRoleImpl implements OperationRequiredRole {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getRequiredInterface__OperationRequiredRole()
     * <em>Required Interface Operation Required Role</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getRequiredInterface__OperationRequiredRole()
     * @generated
     * @ordered
     */
    protected OperationInterface requiredInterface__OperationRequiredRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OperationRequiredRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.OPERATION_REQUIRED_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationInterface getRequiredInterface__OperationRequiredRole() {
        if (requiredInterface__OperationRequiredRole != null
                && ((EObject) requiredInterface__OperationRequiredRole).eIsProxy()) {
            InternalEObject oldRequiredInterface__OperationRequiredRole = (InternalEObject) requiredInterface__OperationRequiredRole;
            requiredInterface__OperationRequiredRole = (OperationInterface) eResolveProxy(oldRequiredInterface__OperationRequiredRole);
            if (requiredInterface__OperationRequiredRole != oldRequiredInterface__OperationRequiredRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.OPERATION_REQUIRED_ROLE__REQUIRED_INTERFACE_OPERATION_REQUIRED_ROLE,
                            oldRequiredInterface__OperationRequiredRole, requiredInterface__OperationRequiredRole));
            }
        }
        return requiredInterface__OperationRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationInterface basicGetRequiredInterface__OperationRequiredRole() {
        return requiredInterface__OperationRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRequiredInterface__OperationRequiredRole(
            OperationInterface newRequiredInterface__OperationRequiredRole) {
        OperationInterface oldRequiredInterface__OperationRequiredRole = requiredInterface__OperationRequiredRole;
        requiredInterface__OperationRequiredRole = newRequiredInterface__OperationRequiredRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.OPERATION_REQUIRED_ROLE__REQUIRED_INTERFACE_OPERATION_REQUIRED_ROLE,
                    oldRequiredInterface__OperationRequiredRole, requiredInterface__OperationRequiredRole));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.OPERATION_REQUIRED_ROLE__REQUIRED_INTERFACE_OPERATION_REQUIRED_ROLE:
            if (resolve)
                return getRequiredInterface__OperationRequiredRole();
            return basicGetRequiredInterface__OperationRequiredRole();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case RepositoryPackage.OPERATION_REQUIRED_ROLE__REQUIRED_INTERFACE_OPERATION_REQUIRED_ROLE:
            setRequiredInterface__OperationRequiredRole((OperationInterface) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case RepositoryPackage.OPERATION_REQUIRED_ROLE__REQUIRED_INTERFACE_OPERATION_REQUIRED_ROLE:
            setRequiredInterface__OperationRequiredRole((OperationInterface) null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case RepositoryPackage.OPERATION_REQUIRED_ROLE__REQUIRED_INTERFACE_OPERATION_REQUIRED_ROLE:
            return requiredInterface__OperationRequiredRole != null;
        }
        return super.eIsSet(featureID);
    }

} // OperationRequiredRoleImpl
