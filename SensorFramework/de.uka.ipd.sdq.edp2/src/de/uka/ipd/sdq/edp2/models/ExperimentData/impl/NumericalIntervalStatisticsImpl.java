/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics;

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
     * The cached value of the '{@link #getArithmethicMean() <em>Arithmethic Mean</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getArithmethicMean()
     * @generated
     * @ordered
     */
	protected Measure arithmethicMean;

	/**
     * The cached value of the '{@link #getVariance() <em>Variance</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariance()
     * @generated
     * @ordered
     */
	protected Measure variance;

	/**
     * The cached value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStandardDeviation()
     * @generated
     * @ordered
     */
	protected Measure standardDeviation;

	/**
     * The cached value of the '{@link #getSum() <em>Sum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSum()
     * @generated
     * @ordered
     */
	protected Measure sum;

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
                setArithmethicMean((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__VARIANCE:
                setVariance((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION:
                setStandardDeviation((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__SUM:
                setSum((Measure)null);
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
                return arithmethicMean != null;
            case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__VARIANCE:
                return variance != null;
            case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION:
                return standardDeviation != null;
            case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS__SUM:
                return sum != null;
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
