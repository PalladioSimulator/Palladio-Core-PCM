
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl;

import de.uka.ipd.sdq.pcm.repository.Parameter;

import de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametric Parameter Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ParametricParameterUsageImpl#getCharacterisedParameter_ParametricParameterUsage <em>Characterised Parameter Parametric Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParametricParameterUsageImpl extends RandomVariableImpl implements ParametricParameterUsage {
	/**
	 * The cached value of the '{@link #getCharacterisedParameter_ParametricParameterUsage() <em>Characterised Parameter Parametric Parameter Usage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisedParameter_ParametricParameterUsage()
	 * @generated
	 * @ordered
	 */
	protected Parameter characterisedParameter_ParametricParameterUsage = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametricParameterUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.PARAMETRIC_PARAMETER_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getCharacterisedParameter_ParametricParameterUsage() {
		if (characterisedParameter_ParametricParameterUsage != null && characterisedParameter_ParametricParameterUsage.eIsProxy()) {
			InternalEObject oldCharacterisedParameter_ParametricParameterUsage = (InternalEObject)characterisedParameter_ParametricParameterUsage;
			characterisedParameter_ParametricParameterUsage = (Parameter)eResolveProxy(oldCharacterisedParameter_ParametricParameterUsage);
			if (characterisedParameter_ParametricParameterUsage != oldCharacterisedParameter_ParametricParameterUsage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.PARAMETRIC_PARAMETER_USAGE__CHARACTERISED_PARAMETER_PARAMETRIC_PARAMETER_USAGE, oldCharacterisedParameter_ParametricParameterUsage, characterisedParameter_ParametricParameterUsage));
			}
		}
		return characterisedParameter_ParametricParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetCharacterisedParameter_ParametricParameterUsage() {
		return characterisedParameter_ParametricParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterisedParameter_ParametricParameterUsage(Parameter newCharacterisedParameter_ParametricParameterUsage) {
		Parameter oldCharacterisedParameter_ParametricParameterUsage = characterisedParameter_ParametricParameterUsage;
		characterisedParameter_ParametricParameterUsage = newCharacterisedParameter_ParametricParameterUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.PARAMETRIC_PARAMETER_USAGE__CHARACTERISED_PARAMETER_PARAMETRIC_PARAMETER_USAGE, oldCharacterisedParameter_ParametricParameterUsage, characterisedParameter_ParametricParameterUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.PARAMETRIC_PARAMETER_USAGE__CHARACTERISED_PARAMETER_PARAMETRIC_PARAMETER_USAGE:
				if (resolve) return getCharacterisedParameter_ParametricParameterUsage();
				return basicGetCharacterisedParameter_ParametricParameterUsage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.PARAMETRIC_PARAMETER_USAGE__CHARACTERISED_PARAMETER_PARAMETRIC_PARAMETER_USAGE:
				setCharacterisedParameter_ParametricParameterUsage((Parameter)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.PARAMETRIC_PARAMETER_USAGE__CHARACTERISED_PARAMETER_PARAMETRIC_PARAMETER_USAGE:
				setCharacterisedParameter_ParametricParameterUsage((Parameter)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.PARAMETRIC_PARAMETER_USAGE__CHARACTERISED_PARAMETER_PARAMETRIC_PARAMETER_USAGE:
				return characterisedParameter_ParametricParameterUsage != null;
		}
		return super.eIsSet(featureID);
	}

} //ParametricParameterUsageImpl