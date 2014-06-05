/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Interface Providing Entity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingEntityImpl#getProvidedRoles_InterfaceProvidingEntity
 * <em>Provided Roles Interface Providing Entity</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class InterfaceProvidingEntityImpl extends EntityImpl implements InterfaceProvidingEntity {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getProvidedRoles_InterfaceProvidingEntity()
     * <em>Provided Roles Interface Providing Entity</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProvidedRoles_InterfaceProvidingEntity()
     * @generated
     * @ordered
     */
    protected EList<ProvidedRole> providedRoles_InterfaceProvidingEntity;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InterfaceProvidingEntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EntityPackage.Literals.INTERFACE_PROVIDING_ENTITY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<ProvidedRole> getProvidedRoles_InterfaceProvidingEntity() {
        if (providedRoles_InterfaceProvidingEntity == null) {
            providedRoles_InterfaceProvidingEntity = new EObjectContainmentWithInverseEList<ProvidedRole>(
                    ProvidedRole.class, this,
                    EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY,
                    RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE);
        }
        return providedRoles_InterfaceProvidingEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getProvidedRoles_InterfaceProvidingEntity())
                    .basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return ((InternalEList<?>) getProvidedRoles_InterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return getProvidedRoles_InterfaceProvidingEntity();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            getProvidedRoles_InterfaceProvidingEntity().clear();
            getProvidedRoles_InterfaceProvidingEntity().addAll((Collection<? extends ProvidedRole>) newValue);
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
        case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            getProvidedRoles_InterfaceProvidingEntity().clear();
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
        case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return providedRoles_InterfaceProvidingEntity != null && !providedRoles_InterfaceProvidingEntity.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // InterfaceProvidingEntityImpl
