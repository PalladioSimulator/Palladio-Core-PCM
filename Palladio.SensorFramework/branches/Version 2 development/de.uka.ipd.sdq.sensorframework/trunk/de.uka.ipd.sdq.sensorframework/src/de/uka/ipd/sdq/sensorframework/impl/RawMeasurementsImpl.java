/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.MeasurementRange;
import de.uka.ipd.sdq.sensorframework.RawMeasurements;
import de.uka.ipd.sdq.sensorframework.RawXValues;
import de.uka.ipd.sdq.sensorframework.RawYValues;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.RawMeasurementsImpl#getRawXValues <em>Raw XValues</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.RawMeasurementsImpl#getRawYValues <em>Raw YValues</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.RawMeasurementsImpl#getMeasurementRange <em>Measurement Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RawMeasurementsImpl extends EObjectImpl implements RawMeasurements {
	/**
	 * The cached value of the '{@link #getRawXValues() <em>Raw XValues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawXValues()
	 * @generated
	 * @ordered
	 */
	protected RawXValues rawXValues;

	/**
	 * The cached value of the '{@link #getRawYValues() <em>Raw YValues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawYValues()
	 * @generated
	 * @ordered
	 */
	protected RawYValues rawYValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawMeasurementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return sensorframeworkPackage.Literals.RAW_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawXValues getRawXValues() {
		return rawXValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawXValues(RawXValues newRawXValues, NotificationChain msgs) {
		RawXValues oldRawXValues = rawXValues;
		rawXValues = newRawXValues;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES, oldRawXValues, newRawXValues);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawXValues(RawXValues newRawXValues) {
		if (newRawXValues != rawXValues) {
			NotificationChain msgs = null;
			if (rawXValues != null)
				msgs = ((InternalEObject)rawXValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES, null, msgs);
			if (newRawXValues != null)
				msgs = ((InternalEObject)newRawXValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES, null, msgs);
			msgs = basicSetRawXValues(newRawXValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES, newRawXValues, newRawXValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawYValues getRawYValues() {
		return rawYValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawYValues(RawYValues newRawYValues, NotificationChain msgs) {
		RawYValues oldRawYValues = rawYValues;
		rawYValues = newRawYValues;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES, oldRawYValues, newRawYValues);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawYValues(RawYValues newRawYValues) {
		if (newRawYValues != rawYValues) {
			NotificationChain msgs = null;
			if (rawYValues != null)
				msgs = ((InternalEObject)rawYValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES, null, msgs);
			if (newRawYValues != null)
				msgs = ((InternalEObject)newRawYValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES, null, msgs);
			msgs = basicSetRawYValues(newRawYValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES, newRawYValues, newRawYValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementRange getMeasurementRange() {
		if (eContainerFeatureID != sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE) return null;
		return (MeasurementRange)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurementRange(MeasurementRange newMeasurementRange, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMeasurementRange, sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementRange(MeasurementRange newMeasurementRange) {
		if (newMeasurementRange != eInternalContainer() || (eContainerFeatureID != sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE && newMeasurementRange != null)) {
			if (EcoreUtil.isAncestor(this, newMeasurementRange))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMeasurementRange != null)
				msgs = ((InternalEObject)newMeasurementRange).eInverseAdd(this, sensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS, MeasurementRange.class, msgs);
			msgs = basicSetMeasurementRange(newMeasurementRange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE, newMeasurementRange, newMeasurementRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMeasurementRange((MeasurementRange)otherEnd, msgs);
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
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES:
				return basicSetRawXValues(null, msgs);
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES:
				return basicSetRawYValues(null, msgs);
			case sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return basicSetMeasurementRange(null, msgs);
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
			case sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return eInternalContainer().eInverseRemove(this, sensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS, MeasurementRange.class, msgs);
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
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES:
				return getRawXValues();
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES:
				return getRawYValues();
			case sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange();
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
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES:
				setRawXValues((RawXValues)newValue);
				return;
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES:
				setRawYValues((RawYValues)newValue);
				return;
			case sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)newValue);
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
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES:
				setRawXValues((RawXValues)null);
				return;
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES:
				setRawYValues((RawYValues)null);
				return;
			case sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)null);
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
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_XVALUES:
				return rawXValues != null;
			case sensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES:
				return rawYValues != null;
			case sensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange() != null;
		}
		return super.eIsSet(featureID);
	}

} //RawMeasurementsImpl
