/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.repository.InfrastructureInterface;
import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Provided Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.InfrastructureProvidedRoleImpl#getProvidedInterface__InfrastructureProvidedRole <em>Provided Interface Infrastructure Provided Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InfrastructureProvidedRoleImpl extends ProvidedRoleImpl implements InfrastructureProvidedRole {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InfrastructureProvidedRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.INFRASTRUCTURE_PROVIDED_ROLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureInterface getProvidedInterface__InfrastructureProvidedRole() {
        return (InfrastructureInterface) eDynamicGet(
                RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE,
                RepositoryPackage.Literals.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureInterface basicGetProvidedInterface__InfrastructureProvidedRole() {
        return (InfrastructureInterface) eDynamicGet(
                RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE,
                RepositoryPackage.Literals.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProvidedInterface__InfrastructureProvidedRole(
            InfrastructureInterface newProvidedInterface__InfrastructureProvidedRole) {
        eDynamicSet(RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE,
                RepositoryPackage.Literals.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE,
                newProvidedInterface__InfrastructureProvidedRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE:
            if (resolve)
                return getProvidedInterface__InfrastructureProvidedRole();
            return basicGetProvidedInterface__InfrastructureProvidedRole();
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
        case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE:
            setProvidedInterface__InfrastructureProvidedRole((InfrastructureInterface) newValue);
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
        case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE:
            setProvidedInterface__InfrastructureProvidedRole((InfrastructureInterface) null);
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
        case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE__PROVIDED_INTERFACE_INFRASTRUCTURE_PROVIDED_ROLE:
            return basicGetProvidedInterface__InfrastructureProvidedRole() != null;
        }
        return super.eIsSet(featureID);
    }

} //InfrastructureProvidedRoleImpl
