/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Single Sensitivity Parameter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.impl.SingleSensitivityParameterImpl#getSensitivityParameterVariation__SingleSensitivityParameter
 * <em>Sensitivity Parameter Variation Single Sensitivity Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SingleSensitivityParameterImpl extends SensitivityParameterImpl implements
        SingleSensitivityParameter {
    /**
     * The cached value of the '
     * {@link #getSensitivityParameterVariation__SingleSensitivityParameter()
     * <em>Sensitivity Parameter Variation Single Sensitivity Parameter</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSensitivityParameterVariation__SingleSensitivityParameter()
     * @generated
     * @ordered
     */
    protected SensitivityParameterVariation sensitivityParameterVariation__SingleSensitivityParameter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SingleSensitivityParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SensitivityPackage.Literals.SINGLE_SENSITIVITY_PARAMETER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SensitivityParameterVariation getSensitivityParameterVariation__SingleSensitivityParameter() {
        return sensitivityParameterVariation__SingleSensitivityParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSensitivityParameterVariation__SingleSensitivityParameter(
            SensitivityParameterVariation newSensitivityParameterVariation__SingleSensitivityParameter,
            NotificationChain msgs) {
        SensitivityParameterVariation oldSensitivityParameterVariation__SingleSensitivityParameter = sensitivityParameterVariation__SingleSensitivityParameter;
        sensitivityParameterVariation__SingleSensitivityParameter = newSensitivityParameterVariation__SingleSensitivityParameter;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER,
                    oldSensitivityParameterVariation__SingleSensitivityParameter,
                    newSensitivityParameterVariation__SingleSensitivityParameter);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSensitivityParameterVariation__SingleSensitivityParameter(
            SensitivityParameterVariation newSensitivityParameterVariation__SingleSensitivityParameter) {
        if (newSensitivityParameterVariation__SingleSensitivityParameter != sensitivityParameterVariation__SingleSensitivityParameter) {
            NotificationChain msgs = null;
            if (sensitivityParameterVariation__SingleSensitivityParameter != null)
                msgs = ((InternalEObject) sensitivityParameterVariation__SingleSensitivityParameter)
                        .eInverseRemove(
                                this,
                                SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION,
                                SensitivityParameterVariation.class, msgs);
            if (newSensitivityParameterVariation__SingleSensitivityParameter != null)
                msgs = ((InternalEObject) newSensitivityParameterVariation__SingleSensitivityParameter)
                        .eInverseAdd(
                                this,
                                SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION,
                                SensitivityParameterVariation.class, msgs);
            msgs = basicSetSensitivityParameterVariation__SingleSensitivityParameter(
                    newSensitivityParameterVariation__SingleSensitivityParameter, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER,
                    newSensitivityParameterVariation__SingleSensitivityParameter,
                    newSensitivityParameterVariation__SingleSensitivityParameter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER:
            if (sensitivityParameterVariation__SingleSensitivityParameter != null)
                msgs = ((InternalEObject) sensitivityParameterVariation__SingleSensitivityParameter)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER,
                                null, msgs);
            return basicSetSensitivityParameterVariation__SingleSensitivityParameter(
                    (SensitivityParameterVariation) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER:
            return basicSetSensitivityParameterVariation__SingleSensitivityParameter(null, msgs);
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
        case SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER:
            return getSensitivityParameterVariation__SingleSensitivityParameter();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER:
            setSensitivityParameterVariation__SingleSensitivityParameter((SensitivityParameterVariation) newValue);
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
        case SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER:
            setSensitivityParameterVariation__SingleSensitivityParameter((SensitivityParameterVariation) null);
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
        case SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER:
            return sensitivityParameterVariation__SingleSensitivityParameter != null;
        }
        return super.eIsSet(featureID);
    }

} // SingleSensitivityParameterImpl
