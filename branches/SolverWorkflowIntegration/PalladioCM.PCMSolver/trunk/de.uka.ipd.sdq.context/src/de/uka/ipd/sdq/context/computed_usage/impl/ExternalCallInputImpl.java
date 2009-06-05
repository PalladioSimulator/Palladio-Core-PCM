/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Call Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallInputImpl#getParameterCharacterisations_ExternalCallInput <em>Parameter Characterisations External Call Input</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallInputImpl#getExternalCallAction_ExternalCallInput <em>External Call Action External Call Input</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalCallInputImpl extends EObjectImpl implements ExternalCallInput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getParameterCharacterisations_ExternalCallInput() <em>Parameter Characterisations External Call Input</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterCharacterisations_ExternalCallInput()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> parameterCharacterisations_ExternalCallInput;

	/**
	 * The cached value of the '{@link #getExternalCallAction_ExternalCallInput() <em>External Call Action External Call Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalCallAction_ExternalCallInput()
	 * @generated
	 * @ordered
	 */
	protected ExternalCallAction externalCallAction_ExternalCallInput;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalCallInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputedUsagePackage.Literals.EXTERNAL_CALL_INPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getParameterCharacterisations_ExternalCallInput() {
		if (parameterCharacterisations_ExternalCallInput == null) {
			parameterCharacterisations_ExternalCallInput = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, ComputedUsagePackage.EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT);
		}
		return parameterCharacterisations_ExternalCallInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallAction getExternalCallAction_ExternalCallInput() {
		if (externalCallAction_ExternalCallInput != null && externalCallAction_ExternalCallInput.eIsProxy()) {
			InternalEObject oldExternalCallAction_ExternalCallInput = (InternalEObject)externalCallAction_ExternalCallInput;
			externalCallAction_ExternalCallInput = (ExternalCallAction)eResolveProxy(oldExternalCallAction_ExternalCallInput);
			if (externalCallAction_ExternalCallInput != oldExternalCallAction_ExternalCallInput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputedUsagePackage.EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT, oldExternalCallAction_ExternalCallInput, externalCallAction_ExternalCallInput));
			}
		}
		return externalCallAction_ExternalCallInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallAction basicGetExternalCallAction_ExternalCallInput() {
		return externalCallAction_ExternalCallInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalCallAction_ExternalCallInput(ExternalCallAction newExternalCallAction_ExternalCallInput) {
		ExternalCallAction oldExternalCallAction_ExternalCallInput = externalCallAction_ExternalCallInput;
		externalCallAction_ExternalCallInput = newExternalCallAction_ExternalCallInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputedUsagePackage.EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT, oldExternalCallAction_ExternalCallInput, externalCallAction_ExternalCallInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT:
				return ((InternalEList<?>)getParameterCharacterisations_ExternalCallInput()).basicRemove(otherEnd, msgs);
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
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT:
				return getParameterCharacterisations_ExternalCallInput();
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT:
				if (resolve) return getExternalCallAction_ExternalCallInput();
				return basicGetExternalCallAction_ExternalCallInput();
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
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT:
				getParameterCharacterisations_ExternalCallInput().clear();
				getParameterCharacterisations_ExternalCallInput().addAll((Collection<? extends VariableUsage>)newValue);
				return;
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT:
				setExternalCallAction_ExternalCallInput((ExternalCallAction)newValue);
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
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT:
				getParameterCharacterisations_ExternalCallInput().clear();
				return;
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT:
				setExternalCallAction_ExternalCallInput((ExternalCallAction)null);
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
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT:
				return parameterCharacterisations_ExternalCallInput != null && !parameterCharacterisations_ExternalCallInput.isEmpty();
			case ComputedUsagePackage.EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT:
				return externalCallAction_ExternalCallInput != null;
		}
		return super.eIsSet(featureID);
	}

} //ExternalCallInputImpl
