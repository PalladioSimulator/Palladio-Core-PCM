/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.parameters.impl.ParameterValueImpl;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterValue;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterValueImpl#getVariableCharacterisations
 * <em>Variable Characterisations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMParameterValueImpl extends ParameterValueImpl implements PCMParameterValue {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PCMParameterValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_PARAMETER_VALUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<VariableUsage> getVariableCharacterisations() {
        return (EList<VariableUsage>) this.eDynamicGet(PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS,
                PCMPackage.Literals.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS, true, true);
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
        case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
            return ((InternalEList<?>) this.getVariableCharacterisations()).basicRemove(otherEnd, msgs);
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
        case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
            return this.getVariableCharacterisations();
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
        case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
            this.getVariableCharacterisations().clear();
            this.getVariableCharacterisations().addAll((Collection<? extends VariableUsage>) newValue);
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
        case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
            this.getVariableCharacterisations().clear();
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
        case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
            return !this.getVariableCharacterisations().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PCMParameterValueImpl
