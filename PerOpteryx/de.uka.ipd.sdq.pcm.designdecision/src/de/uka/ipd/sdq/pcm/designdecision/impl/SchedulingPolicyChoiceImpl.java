/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Policy Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyChoiceImpl#getChosenValue <em>Chosen Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulingPolicyChoiceImpl extends ChoiceImpl implements SchedulingPolicyChoice {
	/**
	 * The default value of the '{@link #getChosenValue() <em>Chosen Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenValue()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingPolicy CHOSEN_VALUE_EDEFAULT = SchedulingPolicy.EXACT;

	/**
	 * The cached value of the '{@link #getChosenValue() <em>Chosen Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenValue()
	 * @generated
	 * @ordered
	 */
	protected SchedulingPolicy chosenValue = CHOSEN_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingPolicyChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.SCHEDULING_POLICY_CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicy getChosenValue() {
		return chosenValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenValue(SchedulingPolicy newChosenValue) {
		SchedulingPolicy oldChosenValue = chosenValue;
		chosenValue = newChosenValue == null ? CHOSEN_VALUE_EDEFAULT : newChosenValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE, oldChosenValue, chosenValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE:
				return getChosenValue();
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
			case designdecisionPackage.SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE:
				setChosenValue((SchedulingPolicy)newValue);
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
			case designdecisionPackage.SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE:
				setChosenValue(CHOSEN_VALUE_EDEFAULT);
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
			case designdecisionPackage.SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE:
				return chosenValue != CHOSEN_VALUE_EDEFAULT;
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
		result.append(" (chosenValue: ");
		result.append(chosenValue);
		result.append(')');
		return result.toString();
	}

} //SchedulingPolicyChoiceImpl
