/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.StateRecorder;

import de.uka.ipd.sdq.capra.measurement.StateSensor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.StateRecorderImpl#getStateSensor <em>State Sensor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StateRecorderImpl extends RecorderImpl implements StateRecorder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateRecorderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.STATE_RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateSensor getStateSensor() {
		if (eContainerFeatureID != MeasurementPackage.STATE_RECORDER__STATE_SENSOR) return null;
		return (StateSensor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateSensor(StateSensor newStateSensor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStateSensor, MeasurementPackage.STATE_RECORDER__STATE_SENSOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateSensor(StateSensor newStateSensor) {
		if (newStateSensor != eInternalContainer() || (eContainerFeatureID != MeasurementPackage.STATE_RECORDER__STATE_SENSOR && newStateSensor != null)) {
			if (EcoreUtil.isAncestor(this, newStateSensor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStateSensor != null)
				msgs = ((InternalEObject)newStateSensor).eInverseAdd(this, MeasurementPackage.STATE_SENSOR__STATE_RECORDER, StateSensor.class, msgs);
			msgs = basicSetStateSensor(newStateSensor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.STATE_RECORDER__STATE_SENSOR, newStateSensor, newStateSensor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementPackage.STATE_RECORDER__STATE_SENSOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetStateSensor((StateSensor)otherEnd, msgs);
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
			case MeasurementPackage.STATE_RECORDER__STATE_SENSOR:
				return basicSetStateSensor(null, msgs);
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
			case MeasurementPackage.STATE_RECORDER__STATE_SENSOR:
				return eInternalContainer().eInverseRemove(this, MeasurementPackage.STATE_SENSOR__STATE_RECORDER, StateSensor.class, msgs);
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
			case MeasurementPackage.STATE_RECORDER__STATE_SENSOR:
				return getStateSensor();
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
			case MeasurementPackage.STATE_RECORDER__STATE_SENSOR:
				setStateSensor((StateSensor)newValue);
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
			case MeasurementPackage.STATE_RECORDER__STATE_SENSOR:
				setStateSensor((StateSensor)null);
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
			case MeasurementPackage.STATE_RECORDER__STATE_SENSOR:
				return getStateSensor() != null;
		}
		return super.eIsSet(featureID);
	}

} //StateRecorderImpl
