/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.TimeProbe;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Probe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.TimeProbeImpl#getSensorsToStart <em>Sensors To Start</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.TimeProbeImpl#getSensorsToStop <em>Sensors To Stop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeProbeImpl extends ProbeActionImpl implements TimeProbe {
	/**
	 * The cached value of the '{@link #getSensorsToStart() <em>Sensors To Start</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensorsToStart()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTimeSpanSensor> sensorsToStart;

	/**
	 * The cached value of the '{@link #getSensorsToStop() <em>Sensors To Stop</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensorsToStop()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTimeSpanSensor> sensorsToStop;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeProbeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.TIME_PROBE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTimeSpanSensor> getSensorsToStart() {
		if (sensorsToStart == null) {
			sensorsToStart = new EObjectWithInverseResolvingEList<AbstractTimeSpanSensor>(AbstractTimeSpanSensor.class, this, MeasurementPackage.TIME_PROBE__SENSORS_TO_START, MeasurementPackage.ABSTRACT_TIME_SPAN_SENSOR__START_MEASUREMENT);
		}
		return sensorsToStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTimeSpanSensor> getSensorsToStop() {
		if (sensorsToStop == null) {
			sensorsToStop = new EObjectWithInverseResolvingEList<AbstractTimeSpanSensor>(AbstractTimeSpanSensor.class, this, MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP, MeasurementPackage.ABSTRACT_TIME_SPAN_SENSOR__STOP_MEASUREMENT);
		}
		return sensorsToStop;
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
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_START:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSensorsToStart()).basicAdd(otherEnd, msgs);
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSensorsToStop()).basicAdd(otherEnd, msgs);
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
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_START:
				return ((InternalEList<?>)getSensorsToStart()).basicRemove(otherEnd, msgs);
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP:
				return ((InternalEList<?>)getSensorsToStop()).basicRemove(otherEnd, msgs);
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
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_START:
				return getSensorsToStart();
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP:
				return getSensorsToStop();
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
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_START:
				getSensorsToStart().clear();
				getSensorsToStart().addAll((Collection<? extends AbstractTimeSpanSensor>)newValue);
				return;
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP:
				getSensorsToStop().clear();
				getSensorsToStop().addAll((Collection<? extends AbstractTimeSpanSensor>)newValue);
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
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_START:
				getSensorsToStart().clear();
				return;
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP:
				getSensorsToStop().clear();
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
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_START:
				return sensorsToStart != null && !sensorsToStart.isEmpty();
			case MeasurementPackage.TIME_PROBE__SENSORS_TO_STOP:
				return sensorsToStop != null && !sensorsToStop.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TimeProbeImpl
