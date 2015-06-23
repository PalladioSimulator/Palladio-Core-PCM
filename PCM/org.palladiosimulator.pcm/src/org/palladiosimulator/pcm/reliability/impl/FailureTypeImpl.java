/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.reliability.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.reliability.FailureType;
import org.palladiosimulator.pcm.reliability.ReliabilityPackage;

import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.reliability.impl.FailureTypeImpl#getRepository__FailureType <em>Repository Failure Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FailureTypeImpl extends EntityImpl implements FailureType {

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
    protected FailureTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ReliabilityPackage.Literals.FAILURE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Repository getRepository__FailureType() {
        return (Repository) eDynamicGet(ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE,
                ReliabilityPackage.Literals.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRepository__FailureType(Repository newRepository__FailureType,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newRepository__FailureType,
                ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepository__FailureType(Repository newRepository__FailureType) {
        eDynamicSet(ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE,
                ReliabilityPackage.Literals.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE, newRepository__FailureType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetRepository__FailureType((Repository) otherEnd, msgs);
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
        case ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE:
            return basicSetRepository__FailureType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE:
            return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY,
                    Repository.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE:
            return getRepository__FailureType();
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
        case ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE:
            setRepository__FailureType((Repository) newValue);
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
        case ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE:
            setRepository__FailureType((Repository) null);
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
        case ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE:
            return getRepository__FailureType() != null;
        }
        return super.eIsSet(featureID);
    }

} //FailureTypeImpl
