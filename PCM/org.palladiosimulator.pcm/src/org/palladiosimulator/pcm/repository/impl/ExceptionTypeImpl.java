/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.repository.ExceptionType;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exception Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.ExceptionTypeImpl#getExceptionName <em>Exception Name</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.ExceptionTypeImpl#getExceptionMessage <em>Exception Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExceptionTypeImpl extends CDOObjectImpl implements ExceptionType {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getExceptionName() <em>Exception Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExceptionName()
     * @generated
     * @ordered
     */
    protected static final String EXCEPTION_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getExceptionMessage() <em>Exception Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExceptionMessage()
     * @generated
     * @ordered
     */
    protected static final String EXCEPTION_MESSAGE_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExceptionTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.EXCEPTION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExceptionName() {
        return (String) eDynamicGet(RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME,
                RepositoryPackage.Literals.EXCEPTION_TYPE__EXCEPTION_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExceptionName(String newExceptionName) {
        eDynamicSet(RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME,
                RepositoryPackage.Literals.EXCEPTION_TYPE__EXCEPTION_NAME, newExceptionName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExceptionMessage() {
        return (String) eDynamicGet(RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE,
                RepositoryPackage.Literals.EXCEPTION_TYPE__EXCEPTION_MESSAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExceptionMessage(String newExceptionMessage) {
        eDynamicSet(RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE,
                RepositoryPackage.Literals.EXCEPTION_TYPE__EXCEPTION_MESSAGE, newExceptionMessage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            return getExceptionName();
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            return getExceptionMessage();
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
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            setExceptionName((String) newValue);
            return;
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            setExceptionMessage((String) newValue);
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
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            setExceptionName(EXCEPTION_NAME_EDEFAULT);
            return;
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            setExceptionMessage(EXCEPTION_MESSAGE_EDEFAULT);
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
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            return EXCEPTION_NAME_EDEFAULT == null ? getExceptionName() != null
                    : !EXCEPTION_NAME_EDEFAULT.equals(getExceptionName());
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            return EXCEPTION_MESSAGE_EDEFAULT == null ? getExceptionMessage() != null
                    : !EXCEPTION_MESSAGE_EDEFAULT.equals(getExceptionMessage());
        }
        return super.eIsSet(featureID);
    }

} //ExceptionTypeImpl
