/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation;
import de.uka.ipd.sdq.edp2.models.emfmodel.Intervals;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Width Aggregation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregationImpl#getRawXSeries <em>Raw XSeries</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregationImpl#getRawYSeries <em>Raw YSeries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FixedWidthAggregationImpl extends AggregatedMeasurementsImpl implements FixedWidthAggregation {
	/**
	 * The cached value of the '{@link #getRawXSeries() <em>Raw XSeries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawXSeries()
	 * @generated
	 * @ordered
	 */
	protected Intervals rawXSeries;

	/**
	 * The cached value of the '{@link #getRawYSeries() <em>Raw YSeries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawYSeries()
	 * @generated
	 * @ordered
	 */
	protected RawYSeries rawYSeries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedWidthAggregationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.FIXED_WIDTH_AGGREGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intervals getRawXSeries() {
		return rawXSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawXSeries(Intervals newRawXSeries, NotificationChain msgs) {
		Intervals oldRawXSeries = rawXSeries;
		rawXSeries = newRawXSeries;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES, oldRawXSeries, newRawXSeries);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawXSeries(Intervals newRawXSeries) {
		if (newRawXSeries != rawXSeries) {
			NotificationChain msgs = null;
			if (rawXSeries != null)
				msgs = ((InternalEObject)rawXSeries).eInverseRemove(this, EmfmodelPackage.INTERVALS__AGGREGATED_MEASUREMENTS, Intervals.class, msgs);
			if (newRawXSeries != null)
				msgs = ((InternalEObject)newRawXSeries).eInverseAdd(this, EmfmodelPackage.INTERVALS__AGGREGATED_MEASUREMENTS, Intervals.class, msgs);
			msgs = basicSetRawXSeries(newRawXSeries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES, newRawXSeries, newRawXSeries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawYSeries getRawYSeries() {
		return rawYSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawYSeries(RawYSeries newRawYSeries, NotificationChain msgs) {
		RawYSeries oldRawYSeries = rawYSeries;
		rawYSeries = newRawYSeries;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES, oldRawYSeries, newRawYSeries);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawYSeries(RawYSeries newRawYSeries) {
		if (newRawYSeries != rawYSeries) {
			NotificationChain msgs = null;
			if (rawYSeries != null)
				msgs = ((InternalEObject)rawYSeries).eInverseRemove(this, EmfmodelPackage.RAW_YSERIES__AGGREGATED_MEASUREMENTS, RawYSeries.class, msgs);
			if (newRawYSeries != null)
				msgs = ((InternalEObject)newRawYSeries).eInverseAdd(this, EmfmodelPackage.RAW_YSERIES__AGGREGATED_MEASUREMENTS, RawYSeries.class, msgs);
			msgs = basicSetRawYSeries(newRawYSeries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES, newRawYSeries, newRawYSeries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES:
				if (rawXSeries != null)
					msgs = ((InternalEObject)rawXSeries).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES, null, msgs);
				return basicSetRawXSeries((Intervals)otherEnd, msgs);
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES:
				if (rawYSeries != null)
					msgs = ((InternalEObject)rawYSeries).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES, null, msgs);
				return basicSetRawYSeries((RawYSeries)otherEnd, msgs);
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES:
				return basicSetRawXSeries(null, msgs);
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES:
				return basicSetRawYSeries(null, msgs);
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES:
				return getRawXSeries();
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES:
				return getRawYSeries();
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES:
				setRawXSeries((Intervals)newValue);
				return;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES:
				setRawYSeries((RawYSeries)newValue);
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES:
				setRawXSeries((Intervals)null);
				return;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES:
				setRawYSeries((RawYSeries)null);
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
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_XSERIES:
				return rawXSeries != null;
			case EmfmodelPackage.FIXED_WIDTH_AGGREGATION__RAW_YSERIES:
				return rawYSeries != null;
		}
		return super.eIsSet(featureID);
	}

} //FixedWidthAggregationImpl
