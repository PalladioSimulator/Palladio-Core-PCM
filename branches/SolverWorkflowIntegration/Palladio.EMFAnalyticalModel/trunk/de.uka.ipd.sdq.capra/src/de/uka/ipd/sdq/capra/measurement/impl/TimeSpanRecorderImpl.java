/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Span Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanRecorderImpl#getTimeSpanSensor <em>Time Span Sensor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TimeSpanRecorderImpl extends RecorderImpl implements TimeSpanRecorder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeSpanRecorderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.TIME_SPAN_RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTimeSpanSensor getTimeSpanSensor() {
		if (eContainerFeatureID != MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR) return null;
		return (AbstractTimeSpanSensor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeSpanSensor(AbstractTimeSpanSensor newTimeSpanSensor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTimeSpanSensor, MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSpanSensor(AbstractTimeSpanSensor newTimeSpanSensor) {
		if (newTimeSpanSensor != eInternalContainer() || (eContainerFeatureID != MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR && newTimeSpanSensor != null)) {
			if (EcoreUtil.isAncestor(this, newTimeSpanSensor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTimeSpanSensor != null)
				msgs = ((InternalEObject)newTimeSpanSensor).eInverseAdd(this, MeasurementPackage.ABSTRACT_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS, AbstractTimeSpanSensor.class, msgs);
			msgs = basicSetTimeSpanSensor(newTimeSpanSensor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR, newTimeSpanSensor, newTimeSpanSensor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTimeSpanSensor((AbstractTimeSpanSensor)otherEnd, msgs);
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
			case MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR:
				return basicSetTimeSpanSensor(null, msgs);
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
		switch (eContainerFeatureID) {
			case MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR:
				return eInternalContainer().eInverseRemove(this, MeasurementPackage.ABSTRACT_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS, AbstractTimeSpanSensor.class, msgs);
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
			case MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR:
				return getTimeSpanSensor();
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
			case MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR:
				setTimeSpanSensor((AbstractTimeSpanSensor)newValue);
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
			case MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR:
				setTimeSpanSensor((AbstractTimeSpanSensor)null);
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
			case MeasurementPackage.TIME_SPAN_RECORDER__TIME_SPAN_SENSOR:
				return getTimeSpanSensor() != null;
		}
		return super.eIsSet(featureID);
	}

} //TimeSpanRecorderImpl
