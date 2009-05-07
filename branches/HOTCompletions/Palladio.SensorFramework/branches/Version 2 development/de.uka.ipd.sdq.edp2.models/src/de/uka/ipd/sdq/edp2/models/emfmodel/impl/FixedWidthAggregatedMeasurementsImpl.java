/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Width Aggregated Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregatedMeasurementsImpl#getIntervals <em>Intervals</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregatedMeasurementsImpl#getAggregationOn <em>Aggregation On</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregatedMeasurementsImpl#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedWidthAggregatedMeasurementsImpl extends AggregatedMeasurementsImpl implements FixedWidthAggregatedMeasurements {
	/**
	 * The cached value of the '{@link #getIntervals() <em>Intervals</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervals()
	 * @generated
	 * @ordered
	 */
	protected FixedIntervals intervals;

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
	 * The cached value of the '{@link #getDataSeries() <em>Data Series</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSeries()
	 * @generated
	 * @ordered
	 */
	protected EList<DataSeries> dataSeries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedWidthAggregatedMeasurementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.FIXED_WIDTH_AGGREGATED_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedIntervals getIntervals() {
		return intervals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntervals(FixedIntervals newIntervals, NotificationChain msgs) {
		FixedIntervals oldIntervals = intervals;
		intervals = newIntervals;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS, oldIntervals, newIntervals);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntervals(FixedIntervals newIntervals) {
		if (newIntervals != intervals) {
			NotificationChain msgs = null;
			if (intervals != null)
				msgs = ((InternalEObject)intervals).eInverseRemove(this, EmfmodelPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS, FixedIntervals.class, msgs);
			if (newIntervals != null)
				msgs = ((InternalEObject)newIntervals).eInverseAdd(this, EmfmodelPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS, FixedIntervals.class, msgs);
			msgs = basicSetIntervals(newIntervals, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS, newIntervals, newIntervals));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_ON, oldAggregationOn, aggregationOn));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_ON, oldAggregationOn, aggregationOn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataSeries> getDataSeries() {
		if (dataSeries == null) {
			dataSeries = new EObjectContainmentWithInverseEList<DataSeries>(DataSeries.class, this, EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES, EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS);
		}
		return dataSeries;
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS:
				if (intervals != null)
					msgs = ((InternalEObject)intervals).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS, null, msgs);
				return basicSetIntervals((FixedIntervals)otherEnd, msgs);
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataSeries()).basicAdd(otherEnd, msgs);
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS:
				return basicSetIntervals(null, msgs);
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES:
				return ((InternalEList<?>)getDataSeries()).basicRemove(otherEnd, msgs);
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS:
				return getIntervals();
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
				if (resolve) return getAggregationOn();
				return basicGetAggregationOn();
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES:
				return getDataSeries();
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS:
				setIntervals((FixedIntervals)newValue);
				return;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
				setAggregationOn((BaseMetricDescription)newValue);
				return;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES:
				getDataSeries().clear();
				getDataSeries().addAll((Collection<? extends DataSeries>)newValue);
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS:
				setIntervals((FixedIntervals)null);
				return;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
				setAggregationOn((BaseMetricDescription)null);
				return;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES:
				getDataSeries().clear();
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS:
				return intervals != null;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_ON:
				return aggregationOn != null;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES:
				return dataSeries != null && !dataSeries.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FixedWidthAggregatedMeasurementsImpl
