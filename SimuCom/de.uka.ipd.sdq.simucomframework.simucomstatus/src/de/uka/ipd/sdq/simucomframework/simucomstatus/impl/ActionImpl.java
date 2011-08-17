/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.Action;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActionImpl#getActionStartTime <em>Action Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ActionImpl#getActionDuration <em>Action Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActionImpl extends EObjectImpl implements Action {
	/**
	 * The default value of the '{@link #getActionStartTime() <em>Action Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final double ACTION_START_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getActionStartTime() <em>Action Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionStartTime()
	 * @generated
	 * @ordered
	 */
	protected double actionStartTime = ACTION_START_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionDuration() <em>Action Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionDuration()
	 * @generated
	 * @ordered
	 */
	protected static final double ACTION_DURATION_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimucomstatusPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getActionStartTime() {
		return actionStartTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionStartTime(double newActionStartTime) {
		double oldActionStartTime = actionStartTime;
		actionStartTime = newActionStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.ACTION__ACTION_START_TIME, oldActionStartTime, actionStartTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getActionDuration() {
		// TODO: implement this method to return the 'Action Duration' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionDuration(double newActionDuration) {
		// TODO: implement this method to set the 'Action Duration' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimucomstatusPackage.ACTION__ACTION_START_TIME:
				return new Double(getActionStartTime());
			case SimucomstatusPackage.ACTION__ACTION_DURATION:
				return new Double(getActionDuration());
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
			case SimucomstatusPackage.ACTION__ACTION_START_TIME:
				setActionStartTime(((Double)newValue).doubleValue());
				return;
			case SimucomstatusPackage.ACTION__ACTION_DURATION:
				setActionDuration(((Double)newValue).doubleValue());
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
			case SimucomstatusPackage.ACTION__ACTION_START_TIME:
				setActionStartTime(ACTION_START_TIME_EDEFAULT);
				return;
			case SimucomstatusPackage.ACTION__ACTION_DURATION:
				setActionDuration(ACTION_DURATION_EDEFAULT);
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
			case SimucomstatusPackage.ACTION__ACTION_START_TIME:
				return actionStartTime != ACTION_START_TIME_EDEFAULT;
			case SimucomstatusPackage.ACTION__ACTION_DURATION:
				return getActionDuration() != ACTION_DURATION_EDEFAULT;
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
		result.append(" (actionStartTime: ");
		result.append(actionStartTime);
		result.append(')');
		return result.toString();
	}

} //ActionImpl
