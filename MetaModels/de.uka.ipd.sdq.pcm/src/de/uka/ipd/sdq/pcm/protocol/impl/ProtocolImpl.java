/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.protocol.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.uka.ipd.sdq.pcm.protocol.Protocol;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Protocol</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.protocol.impl.ProtocolImpl#getProtocolTypeID <em>Protocol Type ID
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProtocolImpl extends MinimalEObjectImpl.Container implements Protocol {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getProtocolTypeID() <em>Protocol Type ID</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getProtocolTypeID()
     * @generated
     * @ordered
     */
    protected static final String PROTOCOL_TYPE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProtocolTypeID() <em>Protocol Type ID</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getProtocolTypeID()
     * @generated
     * @ordered
     */
    protected String protocolTypeID = PROTOCOL_TYPE_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ProtocolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProtocolPackage.Literals.PROTOCOL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getProtocolTypeID() {
        return this.protocolTypeID;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProtocolTypeID(final String newProtocolTypeID) {
        final String oldProtocolTypeID = this.protocolTypeID;
        this.protocolTypeID = newProtocolTypeID;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID,
                    oldProtocolTypeID, this.protocolTypeID));
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
        case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
            return this.getProtocolTypeID();
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
        case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
            this.setProtocolTypeID((String) newValue);
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
        case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
            this.setProtocolTypeID(PROTOCOL_TYPE_ID_EDEFAULT);
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
        case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
            return PROTOCOL_TYPE_ID_EDEFAULT == null ? this.protocolTypeID != null : !PROTOCOL_TYPE_ID_EDEFAULT
            .equals(this.protocolTypeID);
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
        result.append(" (protocolTypeID: ");
        result.append(this.protocolTypeID);
        result.append(')');
        return result.toString();
    }

} // ProtocolImpl
