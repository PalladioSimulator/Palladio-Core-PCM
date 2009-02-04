/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.FixedWidthAggregation;
import de.uka.ipd.sdq.sensorframework.RawMeasurements;
import de.uka.ipd.sdq.sensorframework.RawYValues;
import de.uka.ipd.sdq.sensorframework.SensorframeworkPackage;
import de.uka.ipd.sdq.sensorframework.Statistics;

import de.uka.ipd.sdq.sensorframework.util.SensorframeworkValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw YValues</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.RawYValuesImpl#getStatistics <em>Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.RawYValuesImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.RawYValuesImpl#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RawYValuesImpl extends EObjectImpl implements RawYValues {
	/**
	 * The cached value of the '{@link #getStatistics() <em>Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatistics()
	 * @generated
	 * @ordered
	 */
	protected Statistics statistics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawYValuesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensorframeworkPackage.Literals.RAW_YVALUES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatistics(Statistics newStatistics, NotificationChain msgs) {
		Statistics oldStatistics = statistics;
		statistics = newStatistics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.RAW_YVALUES__STATISTICS, oldStatistics, newStatistics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatistics(Statistics newStatistics) {
		if (newStatistics != statistics) {
			NotificationChain msgs = null;
			if (statistics != null)
				msgs = ((InternalEObject)statistics).eInverseRemove(this, SensorframeworkPackage.STATISTICS__RAW_YVALUES, Statistics.class, msgs);
			if (newStatistics != null)
				msgs = ((InternalEObject)newStatistics).eInverseAdd(this, SensorframeworkPackage.STATISTICS__RAW_YVALUES, Statistics.class, msgs);
			msgs = basicSetStatistics(newStatistics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.RAW_YVALUES__STATISTICS, newStatistics, newStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedWidthAggregation getAggregatedMeasurements() {
		if (eContainerFeatureID != SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS) return null;
		return (FixedWidthAggregation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregatedMeasurements(FixedWidthAggregation newAggregatedMeasurements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAggregatedMeasurements, SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregatedMeasurements(FixedWidthAggregation newAggregatedMeasurements) {
		if (newAggregatedMeasurements != eInternalContainer() || (eContainerFeatureID != SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS && newAggregatedMeasurements != null)) {
			if (EcoreUtil.isAncestor(this, newAggregatedMeasurements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAggregatedMeasurements != null)
				msgs = ((InternalEObject)newAggregatedMeasurements).eInverseAdd(this, SensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES, FixedWidthAggregation.class, msgs);
			msgs = basicSetAggregatedMeasurements(newAggregatedMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS, newAggregatedMeasurements, newAggregatedMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawMeasurements getRawMeasurements() {
		if (eContainerFeatureID != SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS) return null;
		return (RawMeasurements)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawMeasurements(RawMeasurements newRawMeasurements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRawMeasurements, SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawMeasurements(RawMeasurements newRawMeasurements) {
		if (newRawMeasurements != eInternalContainer() || (eContainerFeatureID != SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS && newRawMeasurements != null)) {
			if (EcoreUtil.isAncestor(this, newRawMeasurements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRawMeasurements != null)
				msgs = ((InternalEObject)newRawMeasurements).eInverseAdd(this, SensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES, RawMeasurements.class, msgs);
			msgs = basicSetRawMeasurements(newRawMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS, newRawMeasurements, newRawMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Statisticsonlyformeasurablevalues(DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SensorframeworkValidator.DIAGNOSTIC_SOURCE,
						 SensorframeworkValidator.RAW_YVALUES__STATISTICSONLYFORMEASURABLEVALUES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Statisticsonlyformeasurablevalues", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SensorframeworkPackage.RAW_YVALUES__STATISTICS:
				if (statistics != null)
					msgs = ((InternalEObject)statistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SensorframeworkPackage.RAW_YVALUES__STATISTICS, null, msgs);
				return basicSetStatistics((Statistics)otherEnd, msgs);
			case SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAggregatedMeasurements((FixedWidthAggregation)otherEnd, msgs);
			case SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRawMeasurements((RawMeasurements)otherEnd, msgs);
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
			case SensorframeworkPackage.RAW_YVALUES__STATISTICS:
				return basicSetStatistics(null, msgs);
			case SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS:
				return basicSetAggregatedMeasurements(null, msgs);
			case SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS:
				return basicSetRawMeasurements(null, msgs);
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
			case SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS:
				return eInternalContainer().eInverseRemove(this, SensorframeworkPackage.FIXED_WIDTH_AGGREGATION__RAW_YVALUES, FixedWidthAggregation.class, msgs);
			case SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS:
				return eInternalContainer().eInverseRemove(this, SensorframeworkPackage.RAW_MEASUREMENTS__RAW_YVALUES, RawMeasurements.class, msgs);
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
			case SensorframeworkPackage.RAW_YVALUES__STATISTICS:
				return getStatistics();
			case SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements();
			case SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS:
				return getRawMeasurements();
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
			case SensorframeworkPackage.RAW_YVALUES__STATISTICS:
				setStatistics((Statistics)newValue);
				return;
			case SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS:
				setAggregatedMeasurements((FixedWidthAggregation)newValue);
				return;
			case SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)newValue);
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
			case SensorframeworkPackage.RAW_YVALUES__STATISTICS:
				setStatistics((Statistics)null);
				return;
			case SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS:
				setAggregatedMeasurements((FixedWidthAggregation)null);
				return;
			case SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)null);
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
			case SensorframeworkPackage.RAW_YVALUES__STATISTICS:
				return statistics != null;
			case SensorframeworkPackage.RAW_YVALUES__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements() != null;
			case SensorframeworkPackage.RAW_YVALUES__RAW_MEASUREMENTS:
				return getRawMeasurements() != null;
		}
		return super.eIsSet(featureID);
	}

} //RawYValuesImpl
