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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Variation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterVariationImpl#getSingleSensitivityParameter__SensitivityParameterVariation <em>Single Sensitivity Parameter Sensitivity Parameter Variation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SensitivityParameterVariationImpl extends EObjectImpl implements SensitivityParameterVariation {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SensitivityParameterVariationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.SENSITIVITY_PARAMETER_VARIATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SingleSensitivityParameter getSingleSensitivityParameter__SensitivityParameterVariation() {
        if (eContainerFeatureID() != SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION) return null;
        return (SingleSensitivityParameter)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSingleSensitivityParameter__SensitivityParameterVariation(SingleSensitivityParameter newSingleSensitivityParameter__SensitivityParameterVariation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSingleSensitivityParameter__SensitivityParameterVariation, SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSingleSensitivityParameter__SensitivityParameterVariation(SingleSensitivityParameter newSingleSensitivityParameter__SensitivityParameterVariation) {
        if (newSingleSensitivityParameter__SensitivityParameterVariation != eInternalContainer() || (eContainerFeatureID() != SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION && newSingleSensitivityParameter__SensitivityParameterVariation != null)) {
            if (EcoreUtil.isAncestor(this, newSingleSensitivityParameter__SensitivityParameterVariation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSingleSensitivityParameter__SensitivityParameterVariation != null)
                msgs = ((InternalEObject)newSingleSensitivityParameter__SensitivityParameterVariation).eInverseAdd(this, SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER, SingleSensitivityParameter.class, msgs);
            msgs = basicSetSingleSensitivityParameter__SensitivityParameterVariation(newSingleSensitivityParameter__SensitivityParameterVariation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION, newSingleSensitivityParameter__SensitivityParameterVariation, newSingleSensitivityParameter__SensitivityParameterVariation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSingleSensitivityParameter__SensitivityParameterVariation((SingleSensitivityParameter)otherEnd, msgs);
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
            case SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION:
                return basicSetSingleSensitivityParameter__SensitivityParameterVariation(null, msgs);
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
            case SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION:
                return eInternalContainer().eInverseRemove(this, SensitivityPackage.SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER, SingleSensitivityParameter.class, msgs);
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
            case SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION:
                return getSingleSensitivityParameter__SensitivityParameterVariation();
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
            case SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION:
                setSingleSensitivityParameter__SensitivityParameterVariation((SingleSensitivityParameter)newValue);
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
            case SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION:
                setSingleSensitivityParameter__SensitivityParameterVariation((SingleSensitivityParameter)null);
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
            case SensitivityPackage.SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION:
                return getSingleSensitivityParameter__SensitivityParameterVariation() != null;
        }
        return super.eIsSet(featureID);
    }

} //SensitivityParameterVariationImpl
