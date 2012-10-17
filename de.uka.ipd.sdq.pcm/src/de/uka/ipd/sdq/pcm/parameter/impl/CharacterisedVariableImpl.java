/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.stoex.impl.VariableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterised Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl#getCharacterisationType <em>Characterisation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CharacterisedVariableImpl extends VariableImpl implements CharacterisedVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getCharacterisationType() <em>Characterisation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationType()
	 * @generated
	 * @ordered
	 */
	protected static final VariableCharacterisationType CHARACTERISATION_TYPE_EDEFAULT = VariableCharacterisationType.STRUCTURE;

	/**
	 * The cached value of the '{@link #getCharacterisationType() <em>Characterisation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationType()
	 * @generated
	 * @ordered
	 */
	protected VariableCharacterisationType characterisationType = CHARACTERISATION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacterisedVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.CHARACTERISED_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCharacterisationType getCharacterisationType() {
		return characterisationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterisationType(VariableCharacterisationType newCharacterisationType) {
		VariableCharacterisationType oldCharacterisationType = characterisationType;
		characterisationType = newCharacterisationType == null ? CHARACTERISATION_TYPE_EDEFAULT : newCharacterisationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE, oldCharacterisationType, characterisationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE:
				return getCharacterisationType();
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
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE:
				setCharacterisationType((VariableCharacterisationType)newValue);
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
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE:
				setCharacterisationType(CHARACTERISATION_TYPE_EDEFAULT);
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
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE:
				return characterisationType != CHARACTERISATION_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (characterisationType: ");
		result.append(characterisationType);
		result.append(')');
		return result.toString();
	}

} //CharacterisedVariableImpl
