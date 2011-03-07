/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.TimeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval State Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.IntervalStateRecorderImpl#getTimeInterval <em>Time Interval</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.IntervalStateRecorderImpl#isPercent <em>Percent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntervalStateRecorderImpl extends StateRecorderImpl implements IntervalStateRecorder {
	/**
	 * The cached value of the '{@link #getTimeInterval() <em>Time Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeInterval()
	 * @generated
	 * @ordered
	 */
	protected TimeValue timeInterval;

	/**
	 * The default value of the '{@link #isPercent() <em>Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPercent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERCENT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isPercent() <em>Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPercent()
	 * @generated
	 * @ordered
	 */
	protected boolean percent = PERCENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntervalStateRecorderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.INTERVAL_STATE_RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeValue getTimeInterval() {
		return timeInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeInterval(TimeValue newTimeInterval, NotificationChain msgs) {
		TimeValue oldTimeInterval = timeInterval;
		timeInterval = newTimeInterval;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL, oldTimeInterval, newTimeInterval);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeInterval(TimeValue newTimeInterval) {
		if (newTimeInterval != timeInterval) {
			NotificationChain msgs = null;
			if (timeInterval != null)
				msgs = ((InternalEObject)timeInterval).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL, null, msgs);
			if (newTimeInterval != null)
				msgs = ((InternalEObject)newTimeInterval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL, null, msgs);
			msgs = basicSetTimeInterval(newTimeInterval, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL, newTimeInterval, newTimeInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPercent() {
		return percent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercent(boolean newPercent) {
		boolean oldPercent = percent;
		percent = newPercent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.INTERVAL_STATE_RECORDER__PERCENT, oldPercent, percent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL:
				return basicSetTimeInterval(null, msgs);
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
			case MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL:
				return getTimeInterval();
			case MeasurementPackage.INTERVAL_STATE_RECORDER__PERCENT:
				return isPercent() ? Boolean.TRUE : Boolean.FALSE;
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
			case MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL:
				setTimeInterval((TimeValue)newValue);
				return;
			case MeasurementPackage.INTERVAL_STATE_RECORDER__PERCENT:
				setPercent(((Boolean)newValue).booleanValue());
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
			case MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL:
				setTimeInterval((TimeValue)null);
				return;
			case MeasurementPackage.INTERVAL_STATE_RECORDER__PERCENT:
				setPercent(PERCENT_EDEFAULT);
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
			case MeasurementPackage.INTERVAL_STATE_RECORDER__TIME_INTERVAL:
				return timeInterval != null;
			case MeasurementPackage.INTERVAL_STATE_RECORDER__PERCENT:
				return percent != PERCENT_EDEFAULT;
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
		result.append(" (percent: ");
		result.append(percent);
		result.append(')');
		return result.toString();
	}

} //IntervalStateRecorderImpl
