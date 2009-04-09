/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ratio Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RatioStatisticsImpl#getCoefficientOfVariation <em>Coefficient Of Variation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RatioStatisticsImpl#getGeometricMean <em>Geometric Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RatioStatisticsImpl#getHarmonicMean <em>Harmonic Mean</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RatioStatisticsImpl extends IntervalStatisticsImpl implements RatioStatistics {
	/**
	 * The default value of the '{@link #getCoefficientOfVariation() <em>Coefficient Of Variation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoefficientOfVariation()
	 * @generated
	 * @ordered
	 */
	protected static final double COEFFICIENT_OF_VARIATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCoefficientOfVariation() <em>Coefficient Of Variation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoefficientOfVariation()
	 * @generated
	 * @ordered
	 */
	protected double coefficientOfVariation = COEFFICIENT_OF_VARIATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeometricMean() <em>Geometric Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeometricMean()
	 * @generated
	 * @ordered
	 */
	protected static final Measure GEOMETRIC_MEAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeometricMean() <em>Geometric Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeometricMean()
	 * @generated
	 * @ordered
	 */
	protected Measure geometricMean = GEOMETRIC_MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getHarmonicMean() <em>Harmonic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHarmonicMean()
	 * @generated
	 * @ordered
	 */
	protected static final Measure HARMONIC_MEAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHarmonicMean() <em>Harmonic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHarmonicMean()
	 * @generated
	 * @ordered
	 */
	protected Measure harmonicMean = HARMONIC_MEAN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RatioStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.RATIO_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCoefficientOfVariation() {
		return coefficientOfVariation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoefficientOfVariation(double newCoefficientOfVariation) {
		double oldCoefficientOfVariation = coefficientOfVariation;
		coefficientOfVariation = newCoefficientOfVariation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.RATIO_STATISTICS__COEFFICIENT_OF_VARIATION, oldCoefficientOfVariation, coefficientOfVariation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.RATIO_STATISTICS__GEOMETRIC_MEAN, oldGeometricMean, geometricMean));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.RATIO_STATISTICS__HARMONIC_MEAN, oldHarmonicMean, harmonicMean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfmodelPackage.RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
				return new Double(getCoefficientOfVariation());
			case EmfmodelPackage.RATIO_STATISTICS__GEOMETRIC_MEAN:
				return getGeometricMean();
			case EmfmodelPackage.RATIO_STATISTICS__HARMONIC_MEAN:
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
			case EmfmodelPackage.RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
				setCoefficientOfVariation(((Double)newValue).doubleValue());
				return;
			case EmfmodelPackage.RATIO_STATISTICS__GEOMETRIC_MEAN:
				setGeometricMean((Measure)newValue);
				return;
			case EmfmodelPackage.RATIO_STATISTICS__HARMONIC_MEAN:
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
			case EmfmodelPackage.RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
				setCoefficientOfVariation(COEFFICIENT_OF_VARIATION_EDEFAULT);
				return;
			case EmfmodelPackage.RATIO_STATISTICS__GEOMETRIC_MEAN:
				setGeometricMean(GEOMETRIC_MEAN_EDEFAULT);
				return;
			case EmfmodelPackage.RATIO_STATISTICS__HARMONIC_MEAN:
				setHarmonicMean(HARMONIC_MEAN_EDEFAULT);
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
			case EmfmodelPackage.RATIO_STATISTICS__COEFFICIENT_OF_VARIATION:
				return coefficientOfVariation != COEFFICIENT_OF_VARIATION_EDEFAULT;
			case EmfmodelPackage.RATIO_STATISTICS__GEOMETRIC_MEAN:
				return GEOMETRIC_MEAN_EDEFAULT == null ? geometricMean != null : !GEOMETRIC_MEAN_EDEFAULT.equals(geometricMean);
			case EmfmodelPackage.RATIO_STATISTICS__HARMONIC_MEAN:
				return HARMONIC_MEAN_EDEFAULT == null ? harmonicMean != null : !HARMONIC_MEAN_EDEFAULT.equals(harmonicMean);
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

} //RatioStatisticsImpl
