/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.reliability.FailureType;

import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.RepositoryImpl#getRepositoryDescription <em>Repository Description</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.RepositoryImpl#getComponents__Repository <em>Components Repository</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.RepositoryImpl#getInterfaces__Repository <em>Interfaces Repository</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.RepositoryImpl#getFailureTypes__Repository <em>Failure Types Repository</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.RepositoryImpl#getDataTypes__Repository <em>Data Types Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryImpl extends EntityImpl implements Repository {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getRepositoryDescription() <em>Repository Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRepositoryDescription()
     * @generated
     * @ordered
     */
    protected static final String REPOSITORY_DESCRIPTION_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.REPOSITORY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRepositoryDescription() {
        return (String) eDynamicGet(RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION,
                RepositoryPackage.Literals.REPOSITORY__REPOSITORY_DESCRIPTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepositoryDescription(String newRepositoryDescription) {
        eDynamicSet(RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION,
                RepositoryPackage.Literals.REPOSITORY__REPOSITORY_DESCRIPTION, newRepositoryDescription);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RepositoryComponent> getComponents__Repository() {
        return (EList<RepositoryComponent>) eDynamicGet(RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY,
                RepositoryPackage.Literals.REPOSITORY__COMPONENTS_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<Interface> getInterfaces__Repository() {
        return (EList<Interface>) eDynamicGet(RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY,
                RepositoryPackage.Literals.REPOSITORY__INTERFACES_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<FailureType> getFailureTypes__Repository() {
        return (EList<FailureType>) eDynamicGet(RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY,
                RepositoryPackage.Literals.REPOSITORY__FAILURE_TYPES_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<DataType> getDataTypes__Repository() {
        return (EList<DataType>) eDynamicGet(RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY,
                RepositoryPackage.Literals.REPOSITORY__DATA_TYPES_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getComponents__Repository()).basicAdd(otherEnd,
                    msgs);
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getInterfaces__Repository()).basicAdd(otherEnd,
                    msgs);
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getFailureTypes__Repository())
                    .basicAdd(otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getDataTypes__Repository()).basicAdd(otherEnd,
                    msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return ((InternalEList<?>) getComponents__Repository()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return ((InternalEList<?>) getInterfaces__Repository()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return ((InternalEList<?>) getFailureTypes__Repository()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return ((InternalEList<?>) getDataTypes__Repository()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            return getRepositoryDescription();
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return getComponents__Repository();
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return getInterfaces__Repository();
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return getFailureTypes__Repository();
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return getDataTypes__Repository();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            setRepositoryDescription((String) newValue);
            return;
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            getComponents__Repository().clear();
            getComponents__Repository().addAll((Collection<? extends RepositoryComponent>) newValue);
            return;
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            getInterfaces__Repository().clear();
            getInterfaces__Repository().addAll((Collection<? extends Interface>) newValue);
            return;
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            getFailureTypes__Repository().clear();
            getFailureTypes__Repository().addAll((Collection<? extends FailureType>) newValue);
            return;
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            getDataTypes__Repository().clear();
            getDataTypes__Repository().addAll((Collection<? extends DataType>) newValue);
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
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            setRepositoryDescription(REPOSITORY_DESCRIPTION_EDEFAULT);
            return;
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            getComponents__Repository().clear();
            return;
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            getInterfaces__Repository().clear();
            return;
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            getFailureTypes__Repository().clear();
            return;
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            getDataTypes__Repository().clear();
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
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            return REPOSITORY_DESCRIPTION_EDEFAULT == null ? getRepositoryDescription() != null
                    : !REPOSITORY_DESCRIPTION_EDEFAULT.equals(getRepositoryDescription());
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return !getComponents__Repository().isEmpty();
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return !getInterfaces__Repository().isEmpty();
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return !getFailureTypes__Repository().isEmpty();
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return !getDataTypes__Repository().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RepositoryImpl
