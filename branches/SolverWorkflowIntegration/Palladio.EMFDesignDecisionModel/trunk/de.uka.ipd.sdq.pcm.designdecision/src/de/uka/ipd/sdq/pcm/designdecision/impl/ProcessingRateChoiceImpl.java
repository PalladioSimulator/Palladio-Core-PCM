/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Rate Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateChoiceImpl#getChosenRate <em>Chosen Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingRateChoiceImpl extends ChoiceImpl implements ProcessingRateChoice {
	/**
	 * The default value of the '{@link #getChosenRate() <em>Chosen Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenRate()
	 * @generated
	 * @ordered
	 */
	protected static final double CHOSEN_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getChosenRate() <em>Chosen Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenRate()
	 * @generated
	 * @ordered
	 */
	protected double chosenRate = CHOSEN_RATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingRateChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.PROCESSING_RATE_CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getChosenRate() {
		return chosenRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenRate(double newChosenRate) {
		double oldChosenRate = chosenRate;
		chosenRate = newChosenRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.PROCESSING_RATE_CHOICE__CHOSEN_RATE, oldChosenRate, chosenRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.PROCESSING_RATE_CHOICE__CHOSEN_RATE:
				return new Double(getChosenRate());
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
			case designdecisionPackage.PROCESSING_RATE_CHOICE__CHOSEN_RATE:
				setChosenRate(((Double)newValue).doubleValue());
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
			case designdecisionPackage.PROCESSING_RATE_CHOICE__CHOSEN_RATE:
				setChosenRate(CHOSEN_RATE_EDEFAULT);
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
			case designdecisionPackage.PROCESSING_RATE_CHOICE__CHOSEN_RATE:
				return chosenRate != CHOSEN_RATE_EDEFAULT;
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
		result.append(" (chosenRate: ");
		result.append(chosenRate);
		result.append(')');
		return result.toString();
	}

} //ProcessingRateChoiceImpl
