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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
     * The cached value of the '{@link #getExceptions__Signature() <em>Exceptions Signature</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExceptions__Signature()
     * @generated
     * @ordered
     */
    protected EList<ExceptionType> exceptions__Signature;

    /**
     * The cached value of the '{@link #getFailureType() <em>Failure Type</em>}' reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFailureType()
     * @generated
     * @ordered
     */
    protected EList<FailureType> failureType;

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
    @Override
    public EList<ExceptionType> getExceptions__Signature() {
        if (exceptions__Signature == null) {
            exceptions__Signature = new EObjectContainmentEList<ExceptionType>(ExceptionType.class, this,
                    RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE);
        }
        return exceptions__Signature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<FailureType> getFailureType() {
        if (failureType == null) {
            failureType = new EObjectResolvingEList<FailureType>(FailureType.class, this,
                    RepositoryPackage.SIGNATURE__FAILURE_TYPE);
        }
        return failureType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
            return exceptions__Signature != null && !exceptions__Signature.isEmpty();
        case RepositoryPackage.SIGNATURE__FAILURE_TYPE:
            return failureType != null && !failureType.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // SignatureImpl
