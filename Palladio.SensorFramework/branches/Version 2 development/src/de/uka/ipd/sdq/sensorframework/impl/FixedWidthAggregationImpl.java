/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.FixedWidthAggregation;
import de.uka.ipd.sdq.sensorframework.Intervals;
import de.uka.ipd.sdq.sensorframework.RawYValues;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Width Aggregation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.FixedWidthAggregationImpl#getRawYValues <em>Raw YValues</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.FixedWidthAggregationImpl#getRawXValues <em>Raw XValues</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FixedWidthAggregationImpl extends AggregatedMeasurementsImpl implements FixedWidthAggregation {
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
	 * The cached value of the '{@link #getRawXValues() <em>Raw XValues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawXValues()
	 * @generated
	 * @ordered
	 */
	protected Intervals rawXValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedWidthAggregationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return sensorframeworkPackage.Literals.FIXED_WIDTH_AGGREGATION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES, oldRawYValues, newRawYValues);
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
				msgs = ((InternalEObject)rawYValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES, null, msgs);
			if (newRawYValues != null)
				msgs = ((InternalEObject)newRawYValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES, null, msgs);
			msgs = basicSetRawYValues(newRawYValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES, newRawYValues, newRawYValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intervals getRawXValues() {
		return rawXValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawXValues(Intervals newRawXValues, NotificationChain msgs) {
		Intervals oldRawXValues = rawXValues;
		rawXValues = newRawXValues;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES, oldRawXValues, newRawXValues);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawXValues(Intervals newRawXValues) {
		if (newRawXValues != rawXValues) {
			NotificationChain msgs = null;
			if (rawXValues != null)
				msgs = ((InternalEObject)rawXValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES, null, msgs);
			if (newRawXValues != null)
				msgs = ((InternalEObject)newRawXValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES, null, msgs);
			msgs = basicSetRawXValues(newRawXValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES, newRawXValues, newRawXValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES:
				return basicSetRawYValues(null, msgs);
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES:
				return basicSetRawXValues(null, msgs);
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
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES:
				return getRawYValues();
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES:
				return getRawXValues();
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
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES:
				setRawYValues((RawYValues)newValue);
				return;
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES:
				setRawXValues((Intervals)newValue);
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
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES:
				setRawYValues((RawYValues)null);
				return;
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES:
				setRawXValues((Intervals)null);
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
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES:
				return rawYValues != null;
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES:
				return rawXValues != null;
		}
		return super.eIsSet(featureID);
	}

} //FixedWidthAggregationImpl
