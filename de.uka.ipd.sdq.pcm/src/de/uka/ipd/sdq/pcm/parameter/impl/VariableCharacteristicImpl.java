/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic;
import de.uka.ipd.sdq.stoex.impl.StoExVariableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Characteristic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacteristicImpl#getCharacterisationDefinition__VariableCharacteristic <em>Characterisation Definition Variable Characteristic</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacteristicImpl#getVariable__VariableCharacteristic <em>Variable Variable Characteristic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableCharacteristicImpl extends StoExVariableImpl implements VariableCharacteristic {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getCharacterisationDefinition__VariableCharacteristic() <em>Characterisation Definition Variable Characteristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationDefinition__VariableCharacteristic()
	 * @generated
	 * @ordered
	 */
	protected static final VariableCharacterisationType CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC_EDEFAULT = VariableCharacterisationType.STRUCTURE;

	/**
	 * The cached value of the '{@link #getCharacterisationDefinition__VariableCharacteristic() <em>Characterisation Definition Variable Characteristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationDefinition__VariableCharacteristic()
	 * @generated
	 * @ordered
	 */
	protected VariableCharacterisationType characterisationDefinition__VariableCharacteristic = CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableCharacteristicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.VARIABLE_CHARACTERISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCharacterisationType getCharacterisationDefinition__VariableCharacteristic() {
		return characterisationDefinition__VariableCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterisationDefinition__VariableCharacteristic(VariableCharacterisationType newCharacterisationDefinition__VariableCharacteristic) {
		VariableCharacterisationType oldCharacterisationDefinition__VariableCharacteristic = characterisationDefinition__VariableCharacteristic;
		characterisationDefinition__VariableCharacteristic = newCharacterisationDefinition__VariableCharacteristic == null ? CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC_EDEFAULT : newCharacterisationDefinition__VariableCharacteristic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC, oldCharacterisationDefinition__VariableCharacteristic, characterisationDefinition__VariableCharacteristic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable__VariableCharacteristic() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC) return null;
		return (Variable)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable__VariableCharacteristic(Variable newVariable__VariableCharacteristic, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newVariable__VariableCharacteristic, ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable__VariableCharacteristic(Variable newVariable__VariableCharacteristic) {
		if (newVariable__VariableCharacteristic != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC && newVariable__VariableCharacteristic != null)) {
			if (EcoreUtil.isAncestor(this, newVariable__VariableCharacteristic))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVariable__VariableCharacteristic != null)
				msgs = ((InternalEObject)newVariable__VariableCharacteristic).eInverseAdd(this, ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE, Variable.class, msgs);
			msgs = basicSetVariable__VariableCharacteristic(newVariable__VariableCharacteristic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC, newVariable__VariableCharacteristic, newVariable__VariableCharacteristic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVariable__VariableCharacteristic((Variable)otherEnd, msgs);
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
			case ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC:
				return basicSetVariable__VariableCharacteristic(null, msgs);
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
			case ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC:
				return eInternalContainer().eInverseRemove(this, ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE, Variable.class, msgs);
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
			case ParameterPackage.VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC:
				return getCharacterisationDefinition__VariableCharacteristic();
			case ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC:
				return getVariable__VariableCharacteristic();
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
			case ParameterPackage.VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC:
				setCharacterisationDefinition__VariableCharacteristic((VariableCharacterisationType)newValue);
				return;
			case ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC:
				setVariable__VariableCharacteristic((Variable)newValue);
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
			case ParameterPackage.VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC:
				setCharacterisationDefinition__VariableCharacteristic(CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC_EDEFAULT);
				return;
			case ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC:
				setVariable__VariableCharacteristic((Variable)null);
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
			case ParameterPackage.VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC:
				return characterisationDefinition__VariableCharacteristic != CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC_EDEFAULT;
			case ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC:
				return getVariable__VariableCharacteristic() != null;
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
		result.append(" (characterisationDefinition__VariableCharacteristic: ");
		result.append(characterisationDefinition__VariableCharacteristic);
		result.append(')');
		return result.toString();
	}

} //VariableCharacteristicImpl
