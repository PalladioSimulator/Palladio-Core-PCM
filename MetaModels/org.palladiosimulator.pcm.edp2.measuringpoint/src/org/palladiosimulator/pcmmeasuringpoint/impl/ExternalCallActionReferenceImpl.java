/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>External Call Action Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionReferenceImpl#getExternalCall
 * <em>External Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExternalCallActionReferenceImpl extends MinimalEObjectImpl.Container implements
        ExternalCallActionReference {
    /**
     * The cached value of the '{@link #getExternalCall() <em>External Call</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExternalCall()
     * @generated
     * @ordered
     */
    protected ExternalCallAction externalCall;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ExternalCallActionReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ExternalCallAction getExternalCall() {
        if (this.externalCall != null && ((EObject) this.externalCall).eIsProxy()) {
            final InternalEObject oldExternalCall = (InternalEObject) this.externalCall;
            this.externalCall = (ExternalCallAction) this.eResolveProxy(oldExternalCall);
            if (this.externalCall != oldExternalCall) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL, oldExternalCall,
                            this.externalCall));
                }
            }
        }
        return this.externalCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ExternalCallAction basicGetExternalCall() {
        return this.externalCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setExternalCall(final ExternalCallAction newExternalCall) {
        final ExternalCallAction oldExternalCall = this.externalCall;
        this.externalCall = newExternalCall;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL, oldExternalCall,
                    this.externalCall));
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
            if (resolve) {
                return this.getExternalCall();
            }
            return this.basicGetExternalCall();
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
            this.setExternalCall((ExternalCallAction) newValue);
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
            this.setExternalCall((ExternalCallAction) null);
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
            return this.externalCall != null;
        }
        return super.eIsSet(featureID);
    }

} // ExternalCallActionReferenceImpl
