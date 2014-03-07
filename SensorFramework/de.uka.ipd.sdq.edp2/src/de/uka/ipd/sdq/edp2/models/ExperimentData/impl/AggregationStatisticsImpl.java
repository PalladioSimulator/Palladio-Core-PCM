/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregation Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregationStatisticsImpl#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregationStatisticsImpl#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregationStatisticsImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregationStatisticsImpl extends IdentifiableImpl implements AggregationStatistics {
	/**
     * The default value of the '{@link #getDistinctValuesBeforeAggregation() <em>Distinct Values Before Aggregation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDistinctValuesBeforeAggregation()
     * @generated
     * @ordered
     */
	protected static final long DISTINCT_VALUES_BEFORE_AGGREGATION_EDEFAULT = 0L;

	/**
     * The cached value of the '{@link #getDistinctValuesBeforeAggregation() <em>Distinct Values Before Aggregation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDistinctValuesBeforeAggregation()
     * @generated
     * @ordered
     */
	protected long distinctValuesBeforeAggregation = DISTINCT_VALUES_BEFORE_AGGREGATION_EDEFAULT;

	/**
     * The default value of the '{@link #getDistinctValuesAfterAggregation() <em>Distinct Values After Aggregation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDistinctValuesAfterAggregation()
     * @generated
     * @ordered
     */
	protected static final long DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT = 0L;

	/**
     * The cached value of the '{@link #getDistinctValuesAfterAggregation() <em>Distinct Values After Aggregation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDistinctValuesAfterAggregation()
     * @generated
     * @ordered
     */
	protected long distinctValuesAfterAggregation = DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AggregationStatisticsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.AGGREGATION_STATISTICS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getDistinctValuesBeforeAggregation() {
        return distinctValuesBeforeAggregation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDistinctValuesBeforeAggregation(long newDistinctValuesBeforeAggregation) {
        long oldDistinctValuesBeforeAggregation = distinctValuesBeforeAggregation;
        distinctValuesBeforeAggregation = newDistinctValuesBeforeAggregation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION, oldDistinctValuesBeforeAggregation, distinctValuesBeforeAggregation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getDistinctValuesAfterAggregation() {
        return distinctValuesAfterAggregation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDistinctValuesAfterAggregation(long newDistinctValuesAfterAggregation) {
        long oldDistinctValuesAfterAggregation = distinctValuesAfterAggregation;
        distinctValuesAfterAggregation = newDistinctValuesAfterAggregation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION, oldDistinctValuesAfterAggregation, distinctValuesAfterAggregation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AggregatedMeasurements getAggregatedMeasurements() {
        if (eContainerFeatureID() != ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS) return null;
        return (AggregatedMeasurements)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAggregatedMeasurements(AggregatedMeasurements newAggregatedMeasurements, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAggregatedMeasurements, ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAggregatedMeasurements(AggregatedMeasurements newAggregatedMeasurements) {
        if (newAggregatedMeasurements != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS && newAggregatedMeasurements != null)) {
            if (EcoreUtil.isAncestor(this, newAggregatedMeasurements))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAggregatedMeasurements != null)
                msgs = ((InternalEObject)newAggregatedMeasurements).eInverseAdd(this, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, AggregatedMeasurements.class, msgs);
            msgs = basicSetAggregatedMeasurements(newAggregatedMeasurements, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS, newAggregatedMeasurements, newAggregatedMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAggregatedMeasurements((AggregatedMeasurements)otherEnd, msgs);
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
            case ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS:
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
        switch (eContainerFeatureID()) {
            case ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, AggregatedMeasurements.class, msgs);
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
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION:
                return getDistinctValuesBeforeAggregation();
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION:
                return getDistinctValuesAfterAggregation();
            case ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS:
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
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION:
                setDistinctValuesBeforeAggregation((Long)newValue);
                return;
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION:
                setDistinctValuesAfterAggregation((Long)newValue);
                return;
            case ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS:
                setAggregatedMeasurements((AggregatedMeasurements)newValue);
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
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION:
                setDistinctValuesBeforeAggregation(DISTINCT_VALUES_BEFORE_AGGREGATION_EDEFAULT);
                return;
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION:
                setDistinctValuesAfterAggregation(DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT);
                return;
            case ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS:
                setAggregatedMeasurements((AggregatedMeasurements)null);
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
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION:
                return distinctValuesBeforeAggregation != DISTINCT_VALUES_BEFORE_AGGREGATION_EDEFAULT;
            case ExperimentDataPackage.AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION:
                return distinctValuesAfterAggregation != DISTINCT_VALUES_AFTER_AGGREGATION_EDEFAULT;
            case ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS:
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
        result.append(" (distinctValuesBeforeAggregation: ");
        result.append(distinctValuesBeforeAggregation);
        result.append(", distinctValuesAfterAggregation: ");
        result.append(distinctValuesAfterAggregation);
        result.append(')');
        return result.toString();
    }

} //AggregationStatisticsImpl
