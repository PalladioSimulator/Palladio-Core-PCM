/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.TimeProbe;
import de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder;
import de.uka.ipd.sdq.capra.measurement.TimeSpanSensor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Span Sensor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanSensorImpl#getTimeSpanRecorders <em>Time Span Recorders</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanSensorImpl#getStartMeasurement <em>Start Measurement</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanSensorImpl#getStopMeasurement <em>Stop Measurement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeSpanSensorImpl extends SensorImpl implements TimeSpanSensor {
	/**
	 * The cached value of the '{@link #getTimeSpanRecorders() <em>Time Span Recorders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeSpanRecorders()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeSpanRecorder> timeSpanRecorders;

	/**
	 * The cached value of the '{@link #getStartMeasurement() <em>Start Measurement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartMeasurement()
	 * @generated
	 * @ordered
	 */
	protected TimeProbe startMeasurement;

	/**
	 * The cached value of the '{@link #getStopMeasurement() <em>Stop Measurement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopMeasurement()
	 * @generated
	 * @ordered
	 */
	protected TimeProbe stopMeasurement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeSpanSensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.TIME_SPAN_SENSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeSpanRecorder> getTimeSpanRecorders() {
		if (timeSpanRecorders == null) {
			timeSpanRecorders = new EObjectContainmentWithInverseEList<TimeSpanRecorder>(TimeSpanRecorder.class, this, MeasurementPackage.TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS, MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR);
		}
		return timeSpanRecorders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeProbe getStartMeasurement() {
		if (startMeasurement != null && startMeasurement.eIsProxy()) {
			InternalEObject oldStartMeasurement = (InternalEObject)startMeasurement;
			startMeasurement = (TimeProbe)eResolveProxy(oldStartMeasurement);
			if (startMeasurement != oldStartMeasurement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT, oldStartMeasurement, startMeasurement));
			}
		}
		return startMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeProbe basicGetStartMeasurement() {
		return startMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartMeasurement(TimeProbe newStartMeasurement, NotificationChain msgs) {
		TimeProbe oldStartMeasurement = startMeasurement;
		startMeasurement = newStartMeasurement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT, oldStartMeasurement, newStartMeasurement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartMeasurement(TimeProbe newStartMeasurement) {
		if (newStartMeasurement != startMeasurement) {
			NotificationChain msgs = null;
			if (startMeasurement != null)
				msgs = ((InternalEObject)startMeasurement).eInverseRemove(this, MeasurementPackage.TIME_PROBE__SENSORS_TO_START, TimeProbe.class, msgs);
			if (newStartMeasurement != null)
				msgs = ((InternalEObject)newStartMeasurement).eInverseAdd(this, MeasurementPackage.TIME_PROBE__SENSORS_TO_START, TimeProbe.class, msgs);
			msgs = basicSetStartMeasurement(newStartMeasurement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT, newStartMeasurement, newStartMeasurement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeProbe getStopMeasurement() {
		if (stopMeasurement != null && stopMeasurement.eIsProxy()) {
			InternalEObject oldStopMeasurement = (InternalEObject)stopMeasurement;
			stopMeasurement = (TimeProbe)eResolveProxy(oldStopMeasurement);
			if (stopMeasurement != oldStopMeasurement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT, oldStopMeasurement, stopMeasurement));
			}
		}
		return stopMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeProbe basicGetStopMeasurement() {
		return stopMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStopMeasurement(TimeProbe newStopMeasurement, NotificationChain msgs) {
		TimeProbe oldStopMeasurement = stopMeasurement;
		stopMeasurement = newStopMeasurement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT, oldStopMeasurement, newStopMeasurement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopMeasurement(TimeProbe newStopMeasurement) {
		if (newStopMeasurement != stopMeasurement) {
			NotificationChain msgs = null;
			if (stopMeasurement != null)
				msgs = ((InternalEObject)stopMeasurement).eInverseRemove(this, MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP, TimeProbe.class, msgs);
			if (newStopMeasurement != null)
				msgs = ((InternalEObject)newStopMeasurement).eInverseAdd(this, MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP, TimeProbe.class, msgs);
			msgs = basicSetStopMeasurement(newStopMeasurement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT, newStopMeasurement, newStopMeasurement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementPackage.TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTimeSpanRecorders()).basicAdd(otherEnd, msgs);
			case MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT:
				if (startMeasurement != null)
					msgs = ((InternalEObject)startMeasurement).eInverseRemove(this, MeasurementPackage.TIME_PROBE__SENSORS_TO_START, TimeProbe.class, msgs);
				return basicSetStartMeasurement((TimeProbe)otherEnd, msgs);
			case MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT:
				if (stopMeasurement != null)
					msgs = ((InternalEObject)stopMeasurement).eInverseRemove(this, MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP, TimeProbe.class, msgs);
				return basicSetStopMeasurement((TimeProbe)otherEnd, msgs);
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
			case MeasurementPackage.TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS:
				return ((InternalEList<?>)getTimeSpanRecorders()).basicRemove(otherEnd, msgs);
			case MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT:
				return basicSetStartMeasurement(null, msgs);
			case MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT:
				return basicSetStopMeasurement(null, msgs);
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
			case MeasurementPackage.TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS:
				return getTimeSpanRecorders();
			case MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT:
				if (resolve) return getStartMeasurement();
				return basicGetStartMeasurement();
			case MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT:
				if (resolve) return getStopMeasurement();
				return basicGetStopMeasurement();
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
			case MeasurementPackage.TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS:
				getTimeSpanRecorders().clear();
				getTimeSpanRecorders().addAll((Collection<? extends TimeSpanRecorder>)newValue);
				return;
			case MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT:
				setStartMeasurement((TimeProbe)newValue);
				return;
			case MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT:
				setStopMeasurement((TimeProbe)newValue);
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
			case MeasurementPackage.TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS:
				getTimeSpanRecorders().clear();
				return;
			case MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT:
				setStartMeasurement((TimeProbe)null);
				return;
			case MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT:
				setStopMeasurement((TimeProbe)null);
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
			case MeasurementPackage.TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS:
				return timeSpanRecorders != null && !timeSpanRecorders.isEmpty();
			case MeasurementPackage.TIME_SPAN_SENSOR__START_MEASUREMENT:
				return startMeasurement != null;
			case MeasurementPackage.TIME_SPAN_SENSOR__STOP_MEASUREMENT:
				return stopMeasurement != null;
		}
		return super.eIsSet(featureID);
	}

} //TimeSpanSensorImpl
