/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Exception Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl#getExceptionName <em>Exception
 * Name</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl#getExceptionMessage <em>Exception
 * Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExceptionTypeImpl extends CDOObjectImpl implements ExceptionType {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getExceptionName() <em>Exception Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExceptionName()
     * @generated
     * @ordered
     */
    protected static final String EXCEPTION_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExceptionName() <em>Exception Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExceptionName()
     * @generated
     * @ordered
     */
    protected String exceptionName = EXCEPTION_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getExceptionMessage() <em>Exception Message</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExceptionMessage()
     * @generated
     * @ordered
     */
    protected static final String EXCEPTION_MESSAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExceptionMessage() <em>Exception Message</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExceptionMessage()
     * @generated
     * @ordered
     */
    protected String exceptionMessage = EXCEPTION_MESSAGE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ExceptionTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.EXCEPTION_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getExceptionName() {
        return this.exceptionName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setExceptionName(final String newExceptionName) {
        final String oldExceptionName = this.exceptionName;
        this.exceptionName = newExceptionName;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME, oldExceptionName, this.exceptionName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setExceptionMessage(final String newExceptionMessage) {
        final String oldExceptionMessage = this.exceptionMessage;
        this.exceptionMessage = newExceptionMessage;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE, oldExceptionMessage, this.exceptionMessage));
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
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            return this.getExceptionName();
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            return this.getExceptionMessage();
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
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            this.setExceptionName((String) newValue);
            return;
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            this.setExceptionMessage((String) newValue);
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
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            this.setExceptionName(EXCEPTION_NAME_EDEFAULT);
            return;
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            this.setExceptionMessage(EXCEPTION_MESSAGE_EDEFAULT);
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
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_NAME:
            return EXCEPTION_NAME_EDEFAULT == null ? this.exceptionName != null : !EXCEPTION_NAME_EDEFAULT
            .equals(this.exceptionName);
        case RepositoryPackage.EXCEPTION_TYPE__EXCEPTION_MESSAGE:
            return EXCEPTION_MESSAGE_EDEFAULT == null ? this.exceptionMessage != null : !EXCEPTION_MESSAGE_EDEFAULT
            .equals(this.exceptionMessage);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (exceptionName: ");
        result.append(this.exceptionName);
        result.append(", exceptionMessage: ");
        result.append(this.exceptionMessage);
        result.append(')');
        return result.toString();
    }

} // ExceptionTypeImpl
