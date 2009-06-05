/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.CountingRecorder;
import de.uka.ipd.sdq.capra.measurement.CountingSensor;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Counting Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.CountingRecorderImpl#getCountingSensor <em>Counting Sensor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CountingRecorderImpl extends RecorderImpl implements CountingRecorder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountingRecorderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.COUNTING_RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountingSensor getCountingSensor() {
		if (eContainerFeatureID != MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR) return null;
		return (CountingSensor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCountingSensor(CountingSensor newCountingSensor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCountingSensor, MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountingSensor(CountingSensor newCountingSensor) {
		if (newCountingSensor != eInternalContainer() || (eContainerFeatureID != MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR && newCountingSensor != null)) {
			if (EcoreUtil.isAncestor(this, newCountingSensor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCountingSensor != null)
				msgs = ((InternalEObject)newCountingSensor).eInverseAdd(this, MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS, CountingSensor.class, msgs);
			msgs = basicSetCountingSensor(newCountingSensor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR, newCountingSensor, newCountingSensor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCountingSensor((CountingSensor)otherEnd, msgs);
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
			case MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR:
				return basicSetCountingSensor(null, msgs);
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
			case MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR:
				return eInternalContainer().eInverseRemove(this, MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS, CountingSensor.class, msgs);
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
			case MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR:
				return getCountingSensor();
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
			case MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR:
				setCountingSensor((CountingSensor)newValue);
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
			case MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR:
				setCountingSensor((CountingSensor)null);
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
			case MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR:
				return getCountingSensor() != null;
		}
		return super.eIsSet(featureID);
	}

} //CountingRecorderImpl
