/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawXSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RawMeasurementsImpl#getRawXSeries <em>Raw XSeries</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RawMeasurementsImpl#getRawYSeries <em>Raw YSeries</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RawMeasurementsImpl#getMeasurementRange <em>Measurement Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RawMeasurementsImpl extends IdentifiableImpl implements RawMeasurements {
	/**
	 * The cached value of the '{@link #getRawXSeries() <em>Raw XSeries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawXSeries()
	 * @generated
	 * @ordered
	 */
	protected RawXSeries rawXSeries;

	/**
	 * The cached value of the '{@link #getRawYSeries() <em>Raw YSeries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawYSeries()
	 * @generated
	 * @ordered
	 */
	protected EList<RawYSeries> rawYSeries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawMeasurementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.RAW_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawXSeries getRawXSeries() {
		return rawXSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawXSeries(RawXSeries newRawXSeries, NotificationChain msgs) {
		RawXSeries oldRawXSeries = rawXSeries;
		rawXSeries = newRawXSeries;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES, oldRawXSeries, newRawXSeries);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawXSeries(RawXSeries newRawXSeries) {
		if (newRawXSeries != rawXSeries) {
			NotificationChain msgs = null;
			if (rawXSeries != null)
				msgs = ((InternalEObject)rawXSeries).eInverseRemove(this, EmfmodelPackage.RAW_XSERIES__RAW_MEASUREMENTS, RawXSeries.class, msgs);
			if (newRawXSeries != null)
				msgs = ((InternalEObject)newRawXSeries).eInverseAdd(this, EmfmodelPackage.RAW_XSERIES__RAW_MEASUREMENTS, RawXSeries.class, msgs);
			msgs = basicSetRawXSeries(newRawXSeries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES, newRawXSeries, newRawXSeries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RawYSeries> getRawYSeries() {
		if (rawYSeries == null) {
			rawYSeries = new EObjectContainmentWithInverseEList<RawYSeries>(RawYSeries.class, this, EmfmodelPackage.RAW_MEASUREMENTS__RAW_YSERIES, EmfmodelPackage.RAW_YSERIES__RAW_MEASUREMENTS);
		}
		return rawYSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementRange getMeasurementRange() {
		if (eContainerFeatureID != EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE) return null;
		return (MeasurementRange)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurementRange(MeasurementRange newMeasurementRange, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMeasurementRange, EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementRange(MeasurementRange newMeasurementRange) {
		if (newMeasurementRange != eInternalContainer() || (eContainerFeatureID != EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE && newMeasurementRange != null)) {
			if (EcoreUtil.isAncestor(this, newMeasurementRange))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMeasurementRange != null)
				msgs = ((InternalEObject)newMeasurementRange).eInverseAdd(this, EmfmodelPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS, MeasurementRange.class, msgs);
			msgs = basicSetMeasurementRange(newMeasurementRange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE, newMeasurementRange, newMeasurementRange));
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
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES:
				if (rawXSeries != null)
					msgs = ((InternalEObject)rawXSeries).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES, null, msgs);
				return basicSetRawXSeries((RawXSeries)otherEnd, msgs);
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_YSERIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRawYSeries()).basicAdd(otherEnd, msgs);
			case EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMeasurementRange((MeasurementRange)otherEnd, msgs);
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
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES:
				return basicSetRawXSeries(null, msgs);
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_YSERIES:
				return ((InternalEList<?>)getRawYSeries()).basicRemove(otherEnd, msgs);
			case EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return basicSetMeasurementRange(null, msgs);
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
		switch (eContainerFeatureID) {
			case EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.MEASUREMENT_RANGE__RAW_MEASUREMENTS, MeasurementRange.class, msgs);
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
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES:
				return getRawXSeries();
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_YSERIES:
				return getRawYSeries();
			case EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange();
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
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES:
				setRawXSeries((RawXSeries)newValue);
				return;
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_YSERIES:
				getRawYSeries().clear();
				getRawYSeries().addAll((Collection<? extends RawYSeries>)newValue);
				return;
			case EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)newValue);
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
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES:
				setRawXSeries((RawXSeries)null);
				return;
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_YSERIES:
				getRawYSeries().clear();
				return;
			case EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)null);
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
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_XSERIES:
				return rawXSeries != null;
			case EmfmodelPackage.RAW_MEASUREMENTS__RAW_YSERIES:
				return rawYSeries != null && !rawYSeries.isEmpty();
			case EmfmodelPackage.RAW_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange() != null;
		}
		return super.eIsSet(featureID);
	}

} //RawMeasurementsImpl
