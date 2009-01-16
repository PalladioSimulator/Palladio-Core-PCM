/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.Intervals;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intervals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.IntervalsImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.IntervalsImpl#getIntervalWidth <em>Interval Width</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.IntervalsImpl#getNumberOfIntervals <em>Number Of Intervals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntervalsImpl extends RawXValuesImpl implements Intervals {
	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final Measure OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected Measure offset = OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntervalWidth() <em>Interval Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Measure INTERVAL_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIntervalWidth() <em>Interval Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalWidth()
	 * @generated
	 * @ordered
	 */
	protected Measure intervalWidth = INTERVAL_WIDTH_EDEFAULT;

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
		return sensorframeworkPackage.Literals.INTERVALS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(Measure newOffset) {
		Measure oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.INTERVALS__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getIntervalWidth() {
		return intervalWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntervalWidth(Measure newIntervalWidth) {
		Measure oldIntervalWidth = intervalWidth;
		intervalWidth = newIntervalWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.INTERVALS__INTERVAL_WIDTH, oldIntervalWidth, intervalWidth));
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
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS, oldNumberOfIntervals, numberOfIntervals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case sensorframeworkPackage.INTERVALS__OFFSET:
				return getOffset();
			case sensorframeworkPackage.INTERVALS__INTERVAL_WIDTH:
				return getIntervalWidth();
			case sensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				return new Long(getNumberOfIntervals());
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
			case sensorframeworkPackage.INTERVALS__OFFSET:
				setOffset((Measure)newValue);
				return;
			case sensorframeworkPackage.INTERVALS__INTERVAL_WIDTH:
				setIntervalWidth((Measure)newValue);
				return;
			case sensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				setNumberOfIntervals(((Long)newValue).longValue());
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
			case sensorframeworkPackage.INTERVALS__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case sensorframeworkPackage.INTERVALS__INTERVAL_WIDTH:
				setIntervalWidth(INTERVAL_WIDTH_EDEFAULT);
				return;
			case sensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				setNumberOfIntervals(NUMBER_OF_INTERVALS_EDEFAULT);
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
			case sensorframeworkPackage.INTERVALS__OFFSET:
				return OFFSET_EDEFAULT == null ? offset != null : !OFFSET_EDEFAULT.equals(offset);
			case sensorframeworkPackage.INTERVALS__INTERVAL_WIDTH:
				return INTERVAL_WIDTH_EDEFAULT == null ? intervalWidth != null : !INTERVAL_WIDTH_EDEFAULT.equals(intervalWidth);
			case sensorframeworkPackage.INTERVALS__NUMBER_OF_INTERVALS:
				return numberOfIntervals != NUMBER_OF_INTERVALS_EDEFAULT;
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
		result.append(" (offset: ");
		result.append(offset);
		result.append(", intervalWidth: ");
		result.append(intervalWidth);
		result.append(", numberOfIntervals: ");
		result.append(numberOfIntervals);
		result.append(')');
		return result.toString();
	}

} //IntervalsImpl
