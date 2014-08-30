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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.parameters.impl.ParameterValueImpl;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterValue;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterValueImpl#getVariableCharacterisations <em>Variable Characterisations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMParameterValueImpl extends ParameterValueImpl implements PCMParameterValue {
	/**
     * The cached value of the '{@link #getVariableCharacterisations() <em>Variable Characterisations</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariableCharacterisations()
     * @generated
     * @ordered
     */
	protected EList<VariableUsage> variableCharacterisations;
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMParameterValueImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_PARAMETER_VALUE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<VariableUsage> getVariableCharacterisations() {
        if (variableCharacterisations == null) {
            variableCharacterisations = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS);
        }
        return variableCharacterisations;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
                return ((InternalEList<?>)getVariableCharacterisations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
                return getVariableCharacterisations();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
                getVariableCharacterisations().clear();
                getVariableCharacterisations().addAll((Collection<? extends VariableUsage>)newValue);
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
            case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
                getVariableCharacterisations().clear();
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
            case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATIONS:
                return variableCharacterisations != null && !variableCharacterisations.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //PCMParameterValueImpl
