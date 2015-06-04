/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operation Parameter Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMOperationParameterReferenceImpl#getParameter
 * <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMOperationParameterReferenceImpl extends PCMParameterReferenceImpl implements
PCMOperationParameterReference {

    /**
     * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getParameter()
     * @generated
     * @ordered
     */
    protected Parameter parameter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PCMOperationParameterReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_OPERATION_PARAMETER_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Parameter getParameter() {
        if (this.parameter != null && this.parameter.eIsProxy()) {
            final InternalEObject oldParameter = (InternalEObject) this.parameter;
            this.parameter = (Parameter) this.eResolveProxy(oldParameter);
            if (this.parameter != oldParameter) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER, oldParameter, this.parameter));
                }
            }
        }
        return this.parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Parameter basicGetParameter() {
        return this.parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameter(final Parameter newParameter) {
        final Parameter oldParameter = this.parameter;
        this.parameter = newParameter;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER, oldParameter, this.parameter));
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
        case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER:
            if (resolve) {
                return this.getParameter();
            }
            return this.basicGetParameter();
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
        case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER:
            this.setParameter((Parameter) newValue);
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
        case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER:
            this.setParameter((Parameter) null);
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
        case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE__PARAMETER:
            return this.parameter != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMOperationParameterReferenceImpl
