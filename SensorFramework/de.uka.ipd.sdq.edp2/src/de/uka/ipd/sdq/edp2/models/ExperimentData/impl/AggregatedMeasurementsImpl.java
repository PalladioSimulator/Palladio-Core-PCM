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
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregatedMeasurementsImpl#getMeasurementsRange <em>Measurements Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregatedMeasurementsImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregatedMeasurementsImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregatedMeasurementsImpl#getAggregationStatistics <em>Aggregation Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregatedMeasurementsImpl#getAggregationOn <em>Aggregation On</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.AggregatedMeasurementsImpl#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AggregatedMeasurementsImpl extends IdentifiableImpl implements AggregatedMeasurements {
	/**
     * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isValid()
     * @generated
     * @ordered
     */
	protected static final boolean VALID_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isValid()
     * @generated
     * @ordered
     */
	protected boolean valid = VALID_EDEFAULT;

	/**
     * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFunction()
     * @generated
     * @ordered
     */
	protected AggregationFunctionDescription function;

	/**
     * The cached value of the '{@link #getAggregationStatistics() <em>Aggregation Statistics</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAggregationStatistics()
     * @generated
     * @ordered
     */
	protected AggregationStatistics aggregationStatistics;

	/**
     * The cached value of the '{@link #getAggregationOn() <em>Aggregation On</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAggregationOn()
     * @generated
     * @ordered
     */
	protected BaseMetricDescription aggregationOn;

	/**
     * The cached value of the '{@link #getMetric() <em>Metric</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMetric()
     * @generated
     * @ordered
     */
	protected MetricDescription metric;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AggregatedMeasurementsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.AGGREGATED_MEASUREMENTS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MeasurementsRange getMeasurementsRange() {
        if (eContainerFeatureID() != ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE) return null;
        return (MeasurementsRange)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetMeasurementsRange(MeasurementsRange newMeasurementsRange, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMeasurementsRange, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMeasurementsRange(MeasurementsRange newMeasurementsRange) {
        if (newMeasurementsRange != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE && newMeasurementsRange != null)) {
            if (EcoreUtil.isAncestor(this, newMeasurementsRange))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMeasurementsRange != null)
                msgs = ((InternalEObject)newMeasurementsRange).eInverseAdd(this, ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS, MeasurementsRange.class, msgs);
            msgs = basicSetMeasurementsRange(newMeasurementsRange, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE, newMeasurementsRange, newMeasurementsRange));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isValid() {
        return valid;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValid(boolean newValid) {
        boolean oldValid = valid;
        valid = newValid;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__VALID, oldValid, valid));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AggregationFunctionDescription getFunction() {
        if (function != null && function.eIsProxy()) {
            InternalEObject oldFunction = (InternalEObject)function;
            function = (AggregationFunctionDescription)eResolveProxy(oldFunction);
            if (function != oldFunction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__FUNCTION, oldFunction, function));
            }
        }
        return function;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AggregationFunctionDescription basicGetFunction() {
        return function;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFunction(AggregationFunctionDescription newFunction) {
        AggregationFunctionDescription oldFunction = function;
        function = newFunction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__FUNCTION, oldFunction, function));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AggregationStatistics getAggregationStatistics() {
        return aggregationStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAggregationStatistics(AggregationStatistics newAggregationStatistics, NotificationChain msgs) {
        AggregationStatistics oldAggregationStatistics = aggregationStatistics;
        aggregationStatistics = newAggregationStatistics;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, oldAggregationStatistics, newAggregationStatistics);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAggregationStatistics(AggregationStatistics newAggregationStatistics) {
        if (newAggregationStatistics != aggregationStatistics) {
            NotificationChain msgs = null;
            if (aggregationStatistics != null)
                msgs = ((InternalEObject)aggregationStatistics).eInverseRemove(this, ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS, AggregationStatistics.class, msgs);
            if (newAggregationStatistics != null)
                msgs = ((InternalEObject)newAggregationStatistics).eInverseAdd(this, ExperimentDataPackage.AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS, AggregationStatistics.class, msgs);
            msgs = basicSetAggregationStatistics(newAggregationStatistics, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, newAggregationStatistics, newAggregationStatistics));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BaseMetricDescription getAggregationOn() {
        if (aggregationOn != null && aggregationOn.eIsProxy()) {
            InternalEObject oldAggregationOn = (InternalEObject)aggregationOn;
            aggregationOn = (BaseMetricDescription)eResolveProxy(oldAggregationOn);
            if (aggregationOn != oldAggregationOn) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_ON, oldAggregationOn, aggregationOn));
            }
        }
        return aggregationOn;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BaseMetricDescription basicGetAggregationOn() {
        return aggregationOn;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAggregationOn(BaseMetricDescription newAggregationOn) {
        BaseMetricDescription oldAggregationOn = aggregationOn;
        aggregationOn = newAggregationOn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_ON, oldAggregationOn, aggregationOn));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MetricDescription getMetric() {
        if (metric != null && metric.eIsProxy()) {
            InternalEObject oldMetric = (InternalEObject)metric;
            metric = (MetricDescription)eResolveProxy(oldMetric);
            if (metric != oldMetric) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__METRIC, oldMetric, metric));
            }
        }
        return metric;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MetricDescription basicGetMetric() {
        return metric;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMetric(MetricDescription newMetric) {
        MetricDescription oldMetric = metric;
        metric = newMetric;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__METRIC, oldMetric, metric));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMeasurementsRange((MeasurementsRange)otherEnd, msgs);
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
                if (aggregationStatistics != null)
                    msgs = ((InternalEObject)aggregationStatistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, null, msgs);
                return basicSetAggregationStatistics((AggregationStatistics)otherEnd, msgs);
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
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE:
                return basicSetMeasurementsRange(null, msgs);
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
                return basicSetAggregationStatistics(null, msgs);
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
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS, MeasurementsRange.class, msgs);
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
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE:
                return getMeasurementsRange();
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__VALID:
                return isValid();
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
                if (resolve) return getFunction();
                return basicGetFunction();
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
                return getAggregationStatistics();
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
                if (resolve) return getAggregationOn();
                return basicGetAggregationOn();
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__METRIC:
                if (resolve) return getMetric();
                return basicGetMetric();
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
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE:
                setMeasurementsRange((MeasurementsRange)newValue);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__VALID:
                setValid((Boolean)newValue);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
                setFunction((AggregationFunctionDescription)newValue);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
                setAggregationStatistics((AggregationStatistics)newValue);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
                setAggregationOn((BaseMetricDescription)newValue);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__METRIC:
                setMetric((MetricDescription)newValue);
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
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE:
                setMeasurementsRange((MeasurementsRange)null);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__VALID:
                setValid(VALID_EDEFAULT);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
                setFunction((AggregationFunctionDescription)null);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
                setAggregationStatistics((AggregationStatistics)null);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
                setAggregationOn((BaseMetricDescription)null);
                return;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__METRIC:
                setMetric((MetricDescription)null);
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
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE:
                return getMeasurementsRange() != null;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__VALID:
                return valid != VALID_EDEFAULT;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
                return function != null;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
                return aggregationStatistics != null;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
                return aggregationOn != null;
            case ExperimentDataPackage.AGGREGATED_MEASUREMENTS__METRIC:
                return metric != null;
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
        result.append(" (valid: ");
        result.append(valid);
        result.append(')');
        return result.toString();
    }

} //AggregatedMeasurementsImpl
