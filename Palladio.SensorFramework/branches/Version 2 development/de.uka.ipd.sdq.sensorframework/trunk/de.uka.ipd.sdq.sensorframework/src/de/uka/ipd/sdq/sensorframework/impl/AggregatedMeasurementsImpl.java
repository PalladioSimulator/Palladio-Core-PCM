/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.AggregatedMeasurements;
import de.uka.ipd.sdq.sensorframework.MeasurementRange;
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
 * An implementation of the model object '<em><b>Aggregated Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.AggregatedMeasurementsImpl#getMeasurementRange <em>Measurement Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.AggregatedMeasurementsImpl#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.AggregatedMeasurementsImpl#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AggregatedMeasurementsImpl extends EObjectImpl implements AggregatedMeasurements {
	/**
	 * The default value of the '{@link #getDistinctValuesBeforeAggregation() <em>Distinct Values Before Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistinctValuesBeforeAggregation()
	 * @generated
	 * @ordered
	 */
	protected static final long DISTINCT_VALUES_BEFORE_AGGREGATION_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getDistinctValuesAfterAggregation() <em>Distinct Values After Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistinctValuesAfterAggregation()
	 * @generated
	 * @ordered
	 */
	protected static final long DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDistinctValuesAfterAggregation() <em>Distinct Values After Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistinctValuesAfterAggregation()
	 * @generated
	 * @ordered
	 */
	protected long distinctValuesAfterAggregation = DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedMeasurementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return sensorframeworkPackage.Literals.AGGREGATED_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementRange getMeasurementRange() {
		if (eContainerFeatureID != sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE) return null;
		return (MeasurementRange)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurementRange(MeasurementRange newMeasurementRange, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMeasurementRange, sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementRange(MeasurementRange newMeasurementRange) {
		if (newMeasurementRange != eInternalContainer() || (eContainerFeatureID != sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE && newMeasurementRange != null)) {
			if (EcoreUtil.isAncestor(this, newMeasurementRange))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMeasurementRange != null)
				msgs = ((InternalEObject)newMeasurementRange).eInverseAdd(this, sensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS, MeasurementRange.class, msgs);
			msgs = basicSetMeasurementRange(newMeasurementRange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE, newMeasurementRange, newMeasurementRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDistinctValuesBeforeAggregation() {
		// TODO: implement this method to return the 'Distinct Values Before Aggregation' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistinctValuesBeforeAggregation(long newDistinctValuesBeforeAggregation) {
		// TODO: implement this method to set the 'Distinct Values Before Aggregation' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDistinctValuesAfterAggregation() {
		return distinctValuesAfterAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistinctValuesAfterAggregation(long newDistinctValuesAfterAggregation) {
		long oldDistinctValuesAfterAggregation = distinctValuesAfterAggregation;
		distinctValuesAfterAggregation = newDistinctValuesAfterAggregation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_AFTER_AGGREGATION, oldDistinctValuesAfterAggregation, distinctValuesAfterAggregation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
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
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
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
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				return eInternalContainer().eInverseRemove(this, sensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS, MeasurementRange.class, msgs);
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
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange();
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_BEFORE_AGGREGATION:
				return new Long(getDistinctValuesBeforeAggregation());
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_AFTER_AGGREGATION:
				return new Long(getDistinctValuesAfterAggregation());
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
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)newValue);
				return;
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_BEFORE_AGGREGATION:
				setDistinctValuesBeforeAggregation(((Long)newValue).longValue());
				return;
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_AFTER_AGGREGATION:
				setDistinctValuesAfterAggregation(((Long)newValue).longValue());
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
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)null);
				return;
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_BEFORE_AGGREGATION:
				setDistinctValuesBeforeAggregation(DISTINCT_VALUES_BEFORE_AGGREGATION_EDEFAULT);
				return;
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_AFTER_AGGREGATION:
				setDistinctValuesAfterAggregation(DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT);
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
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange() != null;
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_BEFORE_AGGREGATION:
				return getDistinctValuesBeforeAggregation() != DISTINCT_VALUES_BEFORE_AGGREGATION_EDEFAULT;
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_AFTER_AGGREGATION:
				return distinctValuesAfterAggregation != DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT;
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
		result.append(" (distinctValuesAfterAggregation: ");
		result.append(distinctValuesAfterAggregation);
		result.append(')');
		return result.toString();
	}

} //AggregatedMeasurementsImpl
