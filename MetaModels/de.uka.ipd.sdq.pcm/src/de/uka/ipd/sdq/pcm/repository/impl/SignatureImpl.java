/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Signature</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getExceptions__Signature <em>
 * Exceptions Signature</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getFailureType <em>Failure Type</em>}
 * </li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SignatureImpl extends EntityImpl implements Signature {

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
    protected SignatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.SIGNATURE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ExceptionType> getExceptions__Signature() {
        return (EList<ExceptionType>) this.eDynamicGet(RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE,
                RepositoryPackage.Literals.SIGNATURE__EXCEPTIONS_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<FailureType> getFailureType() {
        return (EList<FailureType>) this.eDynamicGet(RepositoryPackage.SIGNATURE__FAILURE_TYPE,
                RepositoryPackage.Literals.SIGNATURE__FAILURE_TYPE, true, true);
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
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            return ((InternalEList<?>) this.getExceptions__Signature()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            return this.getExceptions__Signature();
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            return this.getFailureType();
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
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            this.getExceptions__Signature().clear();
            this.getExceptions__Signature().addAll((Collection<? extends ExceptionType>) newValue);
            return;
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            this.getFailureType().clear();
            this.getFailureType().addAll((Collection<? extends FailureType>) newValue);
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
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            this.getExceptions__Signature().clear();
            return;
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            this.getFailureType().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            return !this.getExceptions__Signature().isEmpty();
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            return !this.getFailureType().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // SignatureImpl
