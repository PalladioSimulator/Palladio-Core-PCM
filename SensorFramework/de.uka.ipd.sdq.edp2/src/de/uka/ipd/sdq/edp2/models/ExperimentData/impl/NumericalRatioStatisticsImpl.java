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
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalRatioStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Ratio Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalRatioStatisticsImpl#getCoefficientOfVariation <em>Coefficient Of Variation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalRatioStatisticsImpl#getGeometricMean <em>Geometric Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalRatioStatisticsImpl#getHarmonicMean <em>Harmonic Mean</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalRatioStatisticsImpl extends NumericalIntervalStatisticsImpl implements NumericalRatioStatistics {
	/**
     * The cached value of the '{@link #getCoefficientOfVariation() <em>Coefficient Of Variation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCoefficientOfVariation()
     * @generated
     * @ordered
     */
	protected Measure coefficientOfVariation;

	/**
     * The cached value of the '{@link #getGeometricMean() <em>Geometric Mean</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getGeometricMean()
     * @generated
     * @ordered
     */
	protected Measure geometricMean;

	/**
     * The cached value of the '{@link #getHarmonicMean() <em>Harmonic Mean</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getHarmonicMean()
     * @generated
     * @ordered
     */
	protected Measure harmonicMean;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NumericalRatioStatisticsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.NUMERICAL_RATIO_STATISTICS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getCoefficientOfVariation() {
        return coefficientOfVariation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCoefficientOfVariation(Measure newCoefficientOfVariation) {
        Measure oldCoefficientOfVariation = coefficientOfVariation;
        coefficientOfVariation = newCoefficientOfVariation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__COEFFICIENT_OF_VARIATION, oldCoefficientOfVariation, coefficientOfVariation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getGeometricMean() {
        return geometricMean;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setGeometricMean(Measure newGeometricMean) {
        Measure oldGeometricMean = geometricMean;
        geometricMean = newGeometricMean;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__GEOMETRIC_MEAN, oldGeometricMean, geometricMean));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getHarmonicMean() {
        return harmonicMean;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setHarmonicMean(Measure newHarmonicMean) {
        Measure oldHarmonicMean = harmonicMean;
        harmonicMean = newHarmonicMean;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__HARMONIC_MEAN, oldHarmonicMean, harmonicMean));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
                return getCoefficientOfVariation();
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__GEOMETRIC_MEAN:
                return getGeometricMean();
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__HARMONIC_MEAN:
                return getHarmonicMean();
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
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
                setCoefficientOfVariation((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__GEOMETRIC_MEAN:
                setGeometricMean((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__HARMONIC_MEAN:
                setHarmonicMean((Measure)newValue);
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
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
                setCoefficientOfVariation((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__GEOMETRIC_MEAN:
                setGeometricMean((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__HARMONIC_MEAN:
                setHarmonicMean((Measure)null);
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
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
                return coefficientOfVariation != null;
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__GEOMETRIC_MEAN:
                return geometricMean != null;
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS__HARMONIC_MEAN:
                return harmonicMean != null;
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
        result.append(" (coefficientOfVariation: ");
        result.append(coefficientOfVariation);
        result.append(", geometricMean: ");
        result.append(geometricMean);
        result.append(", harmonicMean: ");
        result.append(harmonicMean);
        result.append(')');
        return result.toString();
    }

} //NumericalRatioStatisticsImpl
