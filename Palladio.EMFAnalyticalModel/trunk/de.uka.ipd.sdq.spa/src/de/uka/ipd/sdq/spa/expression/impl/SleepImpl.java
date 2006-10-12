/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.impl;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

import de.uka.ipd.sdq.spa.expression.ExpressionPackage;
import de.uka.ipd.sdq.spa.expression.Sleep;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sleep</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.SleepImpl#getInputVal <em>Input Val</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SleepImpl extends TerminalImpl implements Sleep {
	/**
	 * The cached value of the '{@link #getInputVal() <em>Input Val</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVal()
	 * @generated
	 * @ordered
	 */
	protected ProbabilityDensityFunction inputVal = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SleepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.SLEEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityDensityFunction getInputVal() {
		return inputVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputVal(ProbabilityDensityFunction newInputVal, NotificationChain msgs) {
		ProbabilityDensityFunction oldInputVal = inputVal;
		inputVal = newInputVal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.SLEEP__INPUT_VAL, oldInputVal, newInputVal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVal(ProbabilityDensityFunction newInputVal) {
		if (newInputVal != inputVal) {
			NotificationChain msgs = null;
			if (inputVal != null)
				msgs = ((InternalEObject)inputVal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.SLEEP__INPUT_VAL, null, msgs);
			if (newInputVal != null)
				msgs = ((InternalEObject)newInputVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.SLEEP__INPUT_VAL, null, msgs);
			msgs = basicSetInputVal(newInputVal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.SLEEP__INPUT_VAL, newInputVal, newInputVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.SLEEP__INPUT_VAL:
				return basicSetInputVal(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.SLEEP__INPUT_VAL:
				return getInputVal();
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
			case ExpressionPackage.SLEEP__INPUT_VAL:
				setInputVal((ProbabilityDensityFunction)newValue);
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
			case ExpressionPackage.SLEEP__INPUT_VAL:
				setInputVal((ProbabilityDensityFunction)null);
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
			case ExpressionPackage.SLEEP__INPUT_VAL:
				return inputVal != null;
		}
		return super.eIsSet(featureID);
	}

} //SleepImpl