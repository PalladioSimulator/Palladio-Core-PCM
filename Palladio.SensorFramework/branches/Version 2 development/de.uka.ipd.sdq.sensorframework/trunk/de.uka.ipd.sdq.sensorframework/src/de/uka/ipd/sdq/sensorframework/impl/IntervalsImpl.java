/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.FixedWidthAggregation;
import de.uka.ipd.sdq.sensorframework.Intervals;
import de.uka.ipd.sdq.sensorframework.SensorframeworkPackage;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intervals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.IntervalsImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.IntervalsImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.IntervalsImpl#getNumberOfIntervals <em>Number Of Intervals</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.IntervalsImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntervalsImpl extends RawXValuesImpl implements Intervals {
	/**
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final Measure LOWER_BOUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected Measure lowerBound = LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Measure WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected Measure width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfIntervals() <em>Number Of Intervals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfIntervals()
	 * @generated
	 * @ordered
	 */
	protected static final long NUMBER_OF_INTERVALS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getNumberOfIntervals() <em>Number Of Intervals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfIntervals()
	 * @generated
	 * @ordered
	 */
	protected long numberOfIntervals = NUMBER_OF_INTERVALS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntervalsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensorframeworkPackage.Literals.INTERVALS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(Measure newLowerBound) {
		Measure oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.INTERVALS__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(Measure newWidth) {
		Measure oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.INTERVALS__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getNumberOfIntervals() {
		return numberOfIntervals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfIntervals(long newNumberOfIntervals) {
		long oldNumberOfIntervals = numberOfIntervals;
		numberOfIntervals = newNumberOfIntervals;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS, oldNumberOfIntervals, numberOfIntervals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedWidthAggregation getAggregatedMeasurements() {
		if (eContainerFeatureID != SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS) return null;
		return (FixedWidthAggregation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregatedMeasurements(FixedWidthAggregation newAggregatedMeasurements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAggregatedMeasurements, SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregatedMeasurements(FixedWidthAggregation newAggregatedMeasurements) {
		if (newAggregatedMeasurements != eInternalContainer() || (eContainerFeatureID != SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS && newAggregatedMeasurements != null)) {
			if (EcoreUtil.isAncestor(this, newAggregatedMeasurements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAggregatedMeasurements != null)
				msgs = ((InternalEObject)newAggregatedMeasurements).eInverseAdd(this, SensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES, FixedWidthAggregation.class, msgs);
			msgs = basicSetAggregatedMeasurements(newAggregatedMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS, newAggregatedMeasurements, newAggregatedMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAggregatedMeasurements((FixedWidthAggregation)otherEnd, msgs);
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
			case SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS:
				return basicSetAggregatedMeasurements(null, msgs);
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
			case SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS:
				return eInternalContainer().eInverseRemove(this, SensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_XVALUES, FixedWidthAggregation.class, msgs);
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
			case SensorframeworkPackage.INTERVALS__LOWER_BOUND:
				return getLowerBound();
			case SensorframeworkPackage.INTERVALS__WIDTH:
				return getWidth();
			case SensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				return new Long(getNumberOfIntervals());
			case SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements();
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
			case SensorframeworkPackage.INTERVALS__LOWER_BOUND:
				setLowerBound((Measure)newValue);
				return;
			case SensorframeworkPackage.INTERVALS__WIDTH:
				setWidth((Measure)newValue);
				return;
			case SensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				setNumberOfIntervals(((Long)newValue).longValue());
				return;
			case SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS:
				setAggregatedMeasurements((FixedWidthAggregation)newValue);
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
			case SensorframeworkPackage.INTERVALS__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case SensorframeworkPackage.INTERVALS__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case SensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				setNumberOfIntervals(NUMBER_OF_INTERVALS_EDEFAULT);
				return;
			case SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS:
				setAggregatedMeasurements((FixedWidthAggregation)null);
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
			case SensorframeworkPackage.INTERVALS__LOWER_BOUND:
				return LOWER_BOUND_EDEFAULT == null ? lowerBound != null : !LOWER_BOUND_EDEFAULT.equals(lowerBound);
			case SensorframeworkPackage.INTERVALS__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case SensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				return numberOfIntervals != NUMBER_OF_INTERVALS_EDEFAULT;
			case SensorframeworkPackage.INTERVALS__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements() != null;
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
		result.append(" (lowerBound: ");
		result.append(lowerBound);
		result.append(", width: ");
		result.append(width);
		result.append(", numberOfIntervals: ");
		result.append(numberOfIntervals);
		result.append(')');
		return result.toString();
	}

} //IntervalsImpl
