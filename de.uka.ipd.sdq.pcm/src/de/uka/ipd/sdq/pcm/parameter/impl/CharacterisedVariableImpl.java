/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.stoex.impl.VariableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterised Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl#getCharacterisationDefinition <em>Characterisation Definition</em>}</li>
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
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * The cached value of the '{@link #getCharacterisationDefinition() <em>Characterisation Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationDefinition()
	 * @generated
	 * @ordered
	 */
	protected CharacterisationDefinition characterisationDefinition;

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
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParameterPackage.CHARACTERISED_VARIABLE__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.CHARACTERISED_VARIABLE__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterisationDefinition getCharacterisationDefinition() {
		if (characterisationDefinition != null && characterisationDefinition.eIsProxy()) {
			InternalEObject oldCharacterisationDefinition = (InternalEObject)characterisationDefinition;
			characterisationDefinition = (CharacterisationDefinition)eResolveProxy(oldCharacterisationDefinition);
			if (characterisationDefinition != oldCharacterisationDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION, oldCharacterisationDefinition, characterisationDefinition));
			}
		}
		return characterisationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterisationDefinition basicGetCharacterisationDefinition() {
		return characterisationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterisationDefinition(CharacterisationDefinition newCharacterisationDefinition) {
		CharacterisationDefinition oldCharacterisationDefinition = characterisationDefinition;
		characterisationDefinition = newCharacterisationDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION, oldCharacterisationDefinition, characterisationDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParameterPackage.CHARACTERISED_VARIABLE__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION:
				if (resolve) return getCharacterisationDefinition();
				return basicGetCharacterisationDefinition();
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
			case ParameterPackage.CHARACTERISED_VARIABLE__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION:
				setCharacterisationDefinition((CharacterisationDefinition)newValue);
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
			case ParameterPackage.CHARACTERISED_VARIABLE__VARIABLE:
				setVariable((Variable)null);
				return;
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION:
				setCharacterisationDefinition((CharacterisationDefinition)null);
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
			case ParameterPackage.CHARACTERISED_VARIABLE__VARIABLE:
				return variable != null;
			case ParameterPackage.CHARACTERISED_VARIABLE__CHARACTERISATION_DEFINITION:
				return characterisationDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //CharacterisedVariableImpl
