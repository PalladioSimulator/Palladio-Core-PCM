/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Interval Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalIntervalStatisticsImpl#getArithmethicMean <em>Arithmethic Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalIntervalStatisticsImpl#getVariance <em>Variance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalIntervalStatisticsImpl#getStandardDeviation <em>Standard Deviation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalIntervalStatisticsImpl#getSum <em>Sum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalIntervalStatisticsImpl extends NumericalOrdinalStatisticsImpl implements NumericalIntervalStatistics {
	/**
	 * The default value of the '{@link #getArithmethicMean() <em>Arithmethic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArithmethicMean()
	 * @generated
	 * @ordered
	 */
	protected static final Measure ARITHMETHIC_MEAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArithmethicMean() <em>Arithmethic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArithmethicMean()
	 * @generated
	 * @ordered
	 */
	protected Measure arithmethicMean = ARITHMETHIC_MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected static final Measure VARIANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected Measure variance = VARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected static final Measure STANDARD_DEVIATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected Measure standardDeviation = STANDARD_DEVIATION_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericalIntervalStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentDataPackage.Literals.NUMERICAL_INTERVAL_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getArithmethicMean() {
		return arithmethicMean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArithmethicMean(Measure newArithmethicMean) {
		Measure oldArithmethicMean = arithmethicMean;
		arithmethicMean = newArithmethicMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__ARITHMETHIC_MEAN, oldArithmethicMean, arithmethicMean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getVariance() {
		return variance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariance(Measure newVariance) {
		Measure oldVariance = variance;
		variance = newVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__VARIANCE, oldVariance, variance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardDeviation(Measure newStandardDeviation) {
		Measure oldStandardDeviation = standardDeviation;
		standardDeviation = newStandardDeviation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION, oldStandardDeviation, standardDeviation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__SUM, oldSum, sum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__ARITHMETHIC_MEAN:
				return getArithmethicMean();
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__VARIANCE:
				return getVariance();
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION:
				return getStandardDeviation();
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__SUM:
				return getSum();
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
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__ARITHMETHIC_MEAN:
				setArithmethicMean((Measure)newValue);
				return;
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__VARIANCE:
				setVariance((Measure)newValue);
				return;
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION:
				setStandardDeviation((Measure)newValue);
				return;
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__SUM:
				setSum((Measure)newValue);
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
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__ARITHMETHIC_MEAN:
				setArithmethicMean(ARITHMETHIC_MEAN_EDEFAULT);
				return;
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__VARIANCE:
				setVariance(VARIANCE_EDEFAULT);
				return;
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION:
				setStandardDeviation(STANDARD_DEVIATION_EDEFAULT);
				return;
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__SUM:
				setSum(SUM_EDEFAULT);
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
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__ARITHMETHIC_MEAN:
				return ARITHMETHIC_MEAN_EDEFAULT == null ? arithmethicMean != null : !ARITHMETHIC_MEAN_EDEFAULT.equals(arithmethicMean);
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__VARIANCE:
				return VARIANCE_EDEFAULT == null ? variance != null : !VARIANCE_EDEFAULT.equals(variance);
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION:
				return STANDARD_DEVIATION_EDEFAULT == null ? standardDeviation != null : !STANDARD_DEVIATION_EDEFAULT.equals(standardDeviation);
			case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__SUM:
				return SUM_EDEFAULT == null ? sum != null : !SUM_EDEFAULT.equals(sum);
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
		result.append(" (arithmethicMean: ");
		result.append(arithmethicMean);
		result.append(", variance: ");
		result.append(variance);
		result.append(", standardDeviation: ");
		result.append(standardDeviation);
		result.append(", sum: ");
		result.append(sum);
		result.append(')');
		return result.toString();
	}

} //NumericalIntervalStatisticsImpl
