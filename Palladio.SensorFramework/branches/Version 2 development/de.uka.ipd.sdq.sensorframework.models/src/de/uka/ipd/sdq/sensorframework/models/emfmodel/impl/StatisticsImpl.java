/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.impl;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.RawYValues;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.StatisticsImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.StatisticsImpl#getMean <em>Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.StatisticsImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.StatisticsImpl#getSum <em>Sum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.StatisticsImpl#getCount <em>Count</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.StatisticsImpl#getRawYValues <em>Raw YValues</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatisticsImpl extends EObjectImpl implements Statistics {
	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final Measure MINIMUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected Measure minimum = MINIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMean() <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMean()
	 * @generated
	 * @ordered
	 */
	protected static final Measure MEAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMean() <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMean()
	 * @generated
	 * @ordered
	 */
	protected Measure mean = MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final Measure MAXIMUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected Measure maximum = MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSum() <em>Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSum()
	 * @generated
	 * @ordered
	 */
	protected static final Measure SUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSum() <em>Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSum()
	 * @generated
	 * @ordered
	 */
	protected Measure sum = SUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final long COUNT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected long count = COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return emfmodelPackage.Literals.STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(Measure newMinimum) {
		Measure oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.STATISTICS__MINIMUM, oldMinimum, minimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMean() {
		return mean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMean(Measure newMean) {
		Measure oldMean = mean;
		mean = newMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.STATISTICS__MEAN, oldMean, mean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(Measure newMaximum) {
		Measure oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.STATISTICS__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getSum() {
		return sum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSum(Measure newSum) {
		Measure oldSum = sum;
		sum = newSum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.STATISTICS__SUM, oldSum, sum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(long newCount) {
		long oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.STATISTICS__COUNT, oldCount, count));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawYValues getRawYValues() {
		if (eContainerFeatureID != emfmodelPackage.STATISTICS__RAW_YVALUES) return null;
		return (RawYValues)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawYValues(RawYValues newRawYValues, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRawYValues, emfmodelPackage.STATISTICS__RAW_YVALUES, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawYValues(RawYValues newRawYValues) {
		if (newRawYValues != eInternalContainer() || (eContainerFeatureID != emfmodelPackage.STATISTICS__RAW_YVALUES && newRawYValues != null)) {
			if (EcoreUtil.isAncestor(this, newRawYValues))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRawYValues != null)
				msgs = ((InternalEObject)newRawYValues).eInverseAdd(this, emfmodelPackage.RAW_YVALUES__STATISTICS, RawYValues.class, msgs);
			msgs = basicSetRawYValues(newRawYValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.STATISTICS__RAW_YVALUES, newRawYValues, newRawYValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case emfmodelPackage.STATISTICS__RAW_YVALUES:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRawYValues((RawYValues)otherEnd, msgs);
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
			case emfmodelPackage.STATISTICS__RAW_YVALUES:
				return basicSetRawYValues(null, msgs);
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
			case emfmodelPackage.STATISTICS__RAW_YVALUES:
				return eInternalContainer().eInverseRemove(this, emfmodelPackage.RAW_YVALUES__STATISTICS, RawYValues.class, msgs);
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
			case emfmodelPackage.STATISTICS__MINIMUM:
				return getMinimum();
			case emfmodelPackage.STATISTICS__MEAN:
				return getMean();
			case emfmodelPackage.STATISTICS__MAXIMUM:
				return getMaximum();
			case emfmodelPackage.STATISTICS__SUM:
				return getSum();
			case emfmodelPackage.STATISTICS__COUNT:
				return new Long(getCount());
			case emfmodelPackage.STATISTICS__RAW_YVALUES:
				return getRawYValues();
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
			case emfmodelPackage.STATISTICS__MINIMUM:
				setMinimum((Measure)newValue);
				return;
			case emfmodelPackage.STATISTICS__MEAN:
				setMean((Measure)newValue);
				return;
			case emfmodelPackage.STATISTICS__MAXIMUM:
				setMaximum((Measure)newValue);
				return;
			case emfmodelPackage.STATISTICS__SUM:
				setSum((Measure)newValue);
				return;
			case emfmodelPackage.STATISTICS__COUNT:
				setCount(((Long)newValue).longValue());
				return;
			case emfmodelPackage.STATISTICS__RAW_YVALUES:
				setRawYValues((RawYValues)newValue);
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
			case emfmodelPackage.STATISTICS__MINIMUM:
				setMinimum(MINIMUM_EDEFAULT);
				return;
			case emfmodelPackage.STATISTICS__MEAN:
				setMean(MEAN_EDEFAULT);
				return;
			case emfmodelPackage.STATISTICS__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case emfmodelPackage.STATISTICS__SUM:
				setSum(SUM_EDEFAULT);
				return;
			case emfmodelPackage.STATISTICS__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case emfmodelPackage.STATISTICS__RAW_YVALUES:
				setRawYValues((RawYValues)null);
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
			case emfmodelPackage.STATISTICS__MINIMUM:
				return MINIMUM_EDEFAULT == null ? minimum != null : !MINIMUM_EDEFAULT.equals(minimum);
			case emfmodelPackage.STATISTICS__MEAN:
				return MEAN_EDEFAULT == null ? mean != null : !MEAN_EDEFAULT.equals(mean);
			case emfmodelPackage.STATISTICS__MAXIMUM:
				return MAXIMUM_EDEFAULT == null ? maximum != null : !MAXIMUM_EDEFAULT.equals(maximum);
			case emfmodelPackage.STATISTICS__SUM:
				return SUM_EDEFAULT == null ? sum != null : !SUM_EDEFAULT.equals(sum);
			case emfmodelPackage.STATISTICS__COUNT:
				return count != COUNT_EDEFAULT;
			case emfmodelPackage.STATISTICS__RAW_YVALUES:
				return getRawYValues() != null;
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
		result.append(" (minimum: ");
		result.append(minimum);
		result.append(", mean: ");
		result.append(mean);
		result.append(", maximum: ");
		result.append(maximum);
		result.append(", sum: ");
		result.append(sum);
		result.append(", count: ");
		result.append(count);
		result.append(')');
		return result.toString();
	}

} //StatisticsImpl
