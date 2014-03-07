/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Ordinal Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalOrdinalStatisticsImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalOrdinalStatisticsImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalOrdinalStatisticsImpl#getMedian <em>Median</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalOrdinalStatisticsImpl#getPercentiles <em>Percentiles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalOrdinalStatisticsImpl extends NumericalNominalStatisticsImpl implements NumericalOrdinalStatistics {
	/**
     * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMinimum()
     * @generated
     * @ordered
     */
	protected Measure minimum;

	/**
     * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMaximum()
     * @generated
     * @ordered
     */
	protected Measure maximum;

	/**
     * The cached value of the '{@link #getMedian() <em>Median</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMedian()
     * @generated
     * @ordered
     */
	protected Measure median;

	/**
     * The cached value of the '{@link #getPercentiles() <em>Percentiles</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPercentiles()
     * @generated
     * @ordered
     */
	protected EList<NumericalPercentile> percentiles;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NumericalOrdinalStatisticsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.NUMERICAL_ORDINAL_STATISTICS;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MINIMUM, oldMinimum, minimum));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MAXIMUM, oldMaximum, maximum));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MEDIAN, oldMedian, median));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<NumericalPercentile> getPercentiles() {
        if (percentiles == null) {
            percentiles = new EObjectContainmentWithInverseEList<NumericalPercentile>(NumericalPercentile.class, this, ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES, ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS);
        }
        return percentiles;
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
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPercentiles()).basicAdd(otherEnd, msgs);
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
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES:
                return ((InternalEList<?>)getPercentiles()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MINIMUM:
                return getMinimum();
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MAXIMUM:
                return getMaximum();
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MEDIAN:
                return getMedian();
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES:
                return getPercentiles();
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
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MINIMUM:
                setMinimum((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MAXIMUM:
                setMaximum((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MEDIAN:
                setMedian((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES:
                getPercentiles().clear();
                getPercentiles().addAll((Collection<? extends NumericalPercentile>)newValue);
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
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MINIMUM:
                setMinimum((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MAXIMUM:
                setMaximum((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MEDIAN:
                setMedian((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES:
                getPercentiles().clear();
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
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MINIMUM:
                return minimum != null;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MAXIMUM:
                return maximum != null;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__MEDIAN:
                return median != null;
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES:
                return percentiles != null && !percentiles.isEmpty();
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
        result.append(", maximum: ");
        result.append(maximum);
        result.append(", median: ");
        result.append(median);
        result.append(')');
        return result.toString();
    }

} //NumericalOrdinalStatisticsImpl
