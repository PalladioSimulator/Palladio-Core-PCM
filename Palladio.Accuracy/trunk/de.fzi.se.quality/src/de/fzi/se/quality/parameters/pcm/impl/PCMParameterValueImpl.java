/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import de.fzi.se.quality.parameters.impl.ParameterValueImpl;

import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterValue;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterValueImpl#getVariableCharacterisation <em>Variable Characterisation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMParameterValueImpl extends ParameterValueImpl implements PCMParameterValue {
	/**
	 * The cached value of the '{@link #getVariableCharacterisation() <em>Variable Characterisation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCharacterisation()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCharacterisation> variableCharacterisation;

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
	public EList<VariableCharacterisation> getVariableCharacterisation() {
		if (variableCharacterisation == null) {
			variableCharacterisation = new EObjectContainmentEList<VariableCharacterisation>(VariableCharacterisation.class, this, PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION);
		}
		return variableCharacterisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION:
				return ((InternalEList<?>)getVariableCharacterisation()).basicRemove(otherEnd, msgs);
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
			case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION:
				return getVariableCharacterisation();
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
			case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION:
				getVariableCharacterisation().clear();
				getVariableCharacterisation().addAll((Collection<? extends VariableCharacterisation>)newValue);
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
			case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION:
				getVariableCharacterisation().clear();
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
			case PCMPackage.PCM_PARAMETER_VALUE__VARIABLE_CHARACTERISATION:
				return variableCharacterisation != null && !variableCharacterisation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PCMParameterValueImpl
