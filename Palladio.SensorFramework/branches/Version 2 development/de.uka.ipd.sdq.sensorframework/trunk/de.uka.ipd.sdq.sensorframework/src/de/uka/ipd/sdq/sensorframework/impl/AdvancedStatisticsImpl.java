/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.AdvancedStatistics;
import de.uka.ipd.sdq.sensorframework.SensorframeworkPackage;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advanced Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.AdvancedStatisticsImpl#getMedian <em>Median</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.AdvancedStatisticsImpl#getVariance <em>Variance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.AdvancedStatisticsImpl#getStandardDeviation <em>Standard Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdvancedStatisticsImpl extends StatisticsImpl implements AdvancedStatistics {
	/**
	 * The default value of the '{@link #getMedian() <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedian()
	 * @generated
	 * @ordered
	 */
	protected static final Measure MEDIAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMedian() <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedian()
	 * @generated
	 * @ordered
	 */
	protected Measure median = MEDIAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected static final double VARIANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected double variance = VARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected static final double STANDARD_DEVIATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected double standardDeviation = STANDARD_DEVIATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdvancedStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensorframeworkPackage.Literals.ADVANCED_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMedian() {
		return median;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMedian(Measure newMedian) {
		Measure oldMedian = median;
		median = newMedian;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.ADVANCED_STATISTICS__MEDIAN, oldMedian, median));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVariance() {
		return variance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariance(double newVariance) {
		double oldVariance = variance;
		variance = newVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.ADVANCED_STATISTICS__VARIANCE, oldVariance, variance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardDeviation(double newStandardDeviation) {
		double oldStandardDeviation = standardDeviation;
		standardDeviation = newStandardDeviation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.ADVANCED_STATISTICS__STANDARD_DEVIATION, oldStandardDeviation, standardDeviation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SensorframeworkPackage.ADVANCED_STATISTICS__MEDIAN:
				return getMedian();
			case SensorframeworkPackage.ADVANCED_STATISTICS__VARIANCE:
				return new Double(getVariance());
			case SensorframeworkPackage.ADVANCED_STATISTICS__STANDARD_DEVIATION:
				return new Double(getStandardDeviation());
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
			case SensorframeworkPackage.ADVANCED_STATISTICS__MEDIAN:
				setMedian((Measure)newValue);
				return;
			case SensorframeworkPackage.ADVANCED_STATISTICS__VARIANCE:
				setVariance(((Double)newValue).doubleValue());
				return;
			case SensorframeworkPackage.ADVANCED_STATISTICS__STANDARD_DEVIATION:
				setStandardDeviation(((Double)newValue).doubleValue());
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
			case SensorframeworkPackage.ADVANCED_STATISTICS__MEDIAN:
				setMedian(MEDIAN_EDEFAULT);
				return;
			case SensorframeworkPackage.ADVANCED_STATISTICS__VARIANCE:
				setVariance(VARIANCE_EDEFAULT);
				return;
			case SensorframeworkPackage.ADVANCED_STATISTICS__STANDARD_DEVIATION:
				setStandardDeviation(STANDARD_DEVIATION_EDEFAULT);
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
			case SensorframeworkPackage.ADVANCED_STATISTICS__MEDIAN:
				return MEDIAN_EDEFAULT == null ? median != null : !MEDIAN_EDEFAULT.equals(median);
			case SensorframeworkPackage.ADVANCED_STATISTICS__VARIANCE:
				return variance != VARIANCE_EDEFAULT;
			case SensorframeworkPackage.ADVANCED_STATISTICS__STANDARD_DEVIATION:
				return standardDeviation != STANDARD_DEVIATION_EDEFAULT;
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
		result.append(" (median: ");
		result.append(median);
		result.append(", variance: ");
		result.append(variance);
		result.append(", standardDeviation: ");
		result.append(standardDeviation);
		result.append(')');
		return result.toString();
	}

} //AdvancedStatisticsImpl
