/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.AggregatedMeasurements;
import de.uka.ipd.sdq.sensorframework.CollectedData;
import de.uka.ipd.sdq.sensorframework.MeasurementRange;
import de.uka.ipd.sdq.sensorframework.RawMeasurements;
import de.uka.ipd.sdq.sensorframework.SensorframeworkPackage;

import java.util.Collection;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measurement Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasurementRangeImpl#getRawMeasurements <em>Raw Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasurementRangeImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasurementRangeImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasurementRangeImpl#getCollectedData <em>Collected Data</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasurementRangeImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurementRangeImpl extends EObjectImpl implements MeasurementRange {
	/**
	 * The cached value of the '{@link #getRawMeasurements() <em>Raw Measurements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawMeasurements()
	 * @generated
	 * @ordered
	 */
	protected RawMeasurements rawMeasurements;

	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final Measure END_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected Measure endTime = END_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final Measure START_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected Measure startTime = START_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAggregatedMeasurements() <em>Aggregated Measurements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedMeasurements()
	 * @generated
	 * @ordered
	 */
	protected EList<AggregatedMeasurements> aggregatedMeasurements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurementRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensorframeworkPackage.Literals.MEASUREMENT_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawMeasurements getRawMeasurements() {
		return rawMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawMeasurements(RawMeasurements newRawMeasurements, NotificationChain msgs) {
		RawMeasurements oldRawMeasurements = rawMeasurements;
		rawMeasurements = newRawMeasurements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS, oldRawMeasurements, newRawMeasurements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawMeasurements(RawMeasurements newRawMeasurements) {
		if (newRawMeasurements != rawMeasurements) {
			NotificationChain msgs = null;
			if (rawMeasurements != null)
				msgs = ((InternalEObject)rawMeasurements).eInverseRemove(this, SensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE, RawMeasurements.class, msgs);
			if (newRawMeasurements != null)
				msgs = ((InternalEObject)newRawMeasurements).eInverseAdd(this, SensorframeworkPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE, RawMeasurements.class, msgs);
			msgs = basicSetRawMeasurements(newRawMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS, newRawMeasurements, newRawMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(Measure newEndTime) {
		Measure oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.MEASUREMENT_RANGE__END_TIME, oldEndTime, endTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(Measure newStartTime) {
		Measure oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.MEASUREMENT_RANGE__START_TIME, oldStartTime, startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectedData getCollectedData() {
		if (eContainerFeatureID != SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA) return null;
		return (CollectedData)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollectedData(CollectedData newCollectedData, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCollectedData, SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectedData(CollectedData newCollectedData) {
		if (newCollectedData != eInternalContainer() || (eContainerFeatureID != SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA && newCollectedData != null)) {
			if (EcoreUtil.isAncestor(this, newCollectedData))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCollectedData != null)
				msgs = ((InternalEObject)newCollectedData).eInverseAdd(this, SensorframeworkPackage.COLLECTED_DATA__MEASUREMENT_RANGE, CollectedData.class, msgs);
			msgs = basicSetCollectedData(newCollectedData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA, newCollectedData, newCollectedData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AggregatedMeasurements> getAggregatedMeasurements() {
		if (aggregatedMeasurements == null) {
			aggregatedMeasurements = new EObjectContainmentWithInverseEList<AggregatedMeasurements>(AggregatedMeasurements.class, this, SensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS, SensorframeworkPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE);
		}
		return aggregatedMeasurements;
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
			case SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS:
				if (rawMeasurements != null)
					msgs = ((InternalEObject)rawMeasurements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS, null, msgs);
				return basicSetRawMeasurements((RawMeasurements)otherEnd, msgs);
			case SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCollectedData((CollectedData)otherEnd, msgs);
			case SensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAggregatedMeasurements()).basicAdd(otherEnd, msgs);
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
			case SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS:
				return basicSetRawMeasurements(null, msgs);
			case SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA:
				return basicSetCollectedData(null, msgs);
			case SensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS:
				return ((InternalEList<?>)getAggregatedMeasurements()).basicRemove(otherEnd, msgs);
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
			case SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA:
				return eInternalContainer().eInverseRemove(this, SensorframeworkPackage.COLLECTED_DATA__MEASUREMENT_RANGE, CollectedData.class, msgs);
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
			case SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS:
				return getRawMeasurements();
			case SensorframeworkPackage.MEASUREMENT_RANGE__END_TIME:
				return getEndTime();
			case SensorframeworkPackage.MEASUREMENT_RANGE__START_TIME:
				return getStartTime();
			case SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA:
				return getCollectedData();
			case SensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements();
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
			case SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)newValue);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__END_TIME:
				setEndTime((Measure)newValue);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__START_TIME:
				setStartTime((Measure)newValue);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA:
				setCollectedData((CollectedData)newValue);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS:
				getAggregatedMeasurements().clear();
				getAggregatedMeasurements().addAll((Collection<? extends AggregatedMeasurements>)newValue);
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
			case SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)null);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__END_TIME:
				setEndTime(END_TIME_EDEFAULT);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA:
				setCollectedData((CollectedData)null);
				return;
			case SensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS:
				getAggregatedMeasurements().clear();
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
			case SensorframeworkPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS:
				return rawMeasurements != null;
			case SensorframeworkPackage.MEASUREMENT_RANGE__END_TIME:
				return END_TIME_EDEFAULT == null ? endTime != null : !END_TIME_EDEFAULT.equals(endTime);
			case SensorframeworkPackage.MEASUREMENT_RANGE__START_TIME:
				return START_TIME_EDEFAULT == null ? startTime != null : !START_TIME_EDEFAULT.equals(startTime);
			case SensorframeworkPackage.MEASUREMENT_RANGE__COLLECTED_DATA:
				return getCollectedData() != null;
			case SensorframeworkPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS:
				return aggregatedMeasurements != null && !aggregatedMeasurements.isEmpty();
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
		result.append(" (endTime: ");
		result.append(endTime);
		result.append(", startTime: ");
		result.append(startTime);
		result.append(')');
		return result.toString();
	}

} //MeasurementRangeImpl
