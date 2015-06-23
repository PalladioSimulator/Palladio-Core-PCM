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

import org.palladiosimulator.pcm.repository.ExceptionType;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.SignatureImpl#getExceptions__Signature <em>Exceptions Signature</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.SignatureImpl#getFailureType <em>Failure Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SignatureImpl extends EntityImpl implements Signature {

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
    protected SignatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.SIGNATURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ExceptionType> getExceptions__Signature() {
        return (EList<ExceptionType>) eDynamicGet(RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE,
                RepositoryPackage.Literals.SIGNATURE__EXCEPTIONS_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<FailureType> getFailureType() {
        return (EList<FailureType>) eDynamicGet(RepositoryPackage.SIGNATURE__FAILURE_TYPE,
                RepositoryPackage.Literals.SIGNATURE__FAILURE_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            return ((InternalEList<?>) getExceptions__Signature()).basicRemove(otherEnd, msgs);
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
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            return getExceptions__Signature();
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            return getFailureType();
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
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            getExceptions__Signature().clear();
            getExceptions__Signature().addAll((Collection<? extends ExceptionType>) newValue);
            return;
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            getFailureType().clear();
            getFailureType().addAll((Collection<? extends FailureType>) newValue);
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
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            getExceptions__Signature().clear();
            return;
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            getFailureType().clear();
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
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            return !getExceptions__Signature().isEmpty();
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            return !getFailureType().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SignatureImpl
