/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationCharacterization;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl#getMeasurementRange <em>Measurement Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl#getAggregationStatistics <em>Aggregation Statistics</em>}</li>
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
		return EmfmodelPackage.Literals.AGGREGATED_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementRange getMeasurementRange() {
		if (eContainerFeatureID != EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE) return null;
		return (MeasurementRange)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurementRange(MeasurementRange newMeasurementRange, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMeasurementRange, EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementRange(MeasurementRange newMeasurementRange) {
		if (newMeasurementRange != eInternalContainer() || (eContainerFeatureID != EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE && newMeasurementRange != null)) {
			if (EcoreUtil.isAncestor(this, newMeasurementRange))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMeasurementRange != null)
				msgs = ((InternalEObject)newMeasurementRange).eInverseAdd(this, EmfmodelPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS, MeasurementRange.class, msgs);
			msgs = basicSetMeasurementRange(newMeasurementRange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE, newMeasurementRange, newMeasurementRange));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.AGGREGATED_MEASUREMENTS__VALID, oldValid, valid));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfmodelPackage.AGGREGATED_MEASUREMENTS__FUNCTION, oldFunction, function));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.AGGREGATED_MEASUREMENTS__FUNCTION, oldFunction, function));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, oldAggregationStatistics, newAggregationStatistics);
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
				msgs = ((InternalEObject)aggregationStatistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, null, msgs);
			if (newAggregationStatistics != null)
				msgs = ((InternalEObject)newAggregationStatistics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, null, msgs);
			msgs = basicSetAggregationStatistics(newAggregationStatistics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS, newAggregationStatistics, newAggregationStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
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
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				return basicSetMeasurementRange(null, msgs);
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
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
		switch (eContainerFeatureID) {
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS, MeasurementRange.class, msgs);
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
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange();
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__VALID:
				return isValid() ? Boolean.TRUE : Boolean.FALSE;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
				if (resolve) return getFunction();
				return basicGetFunction();
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
				return getAggregationStatistics();
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
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)newValue);
				return;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__VALID:
				setValid(((Boolean)newValue).booleanValue());
				return;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
				setFunction((AggregationFunctionDescription)newValue);
				return;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
				setAggregationStatistics((AggregationStatistics)newValue);
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
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				setMeasurementRange((MeasurementRange)null);
				return;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__VALID:
				setValid(VALID_EDEFAULT);
				return;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
				setFunction((AggregationFunctionDescription)null);
				return;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
				setAggregationStatistics((AggregationStatistics)null);
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
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE:
				return getMeasurementRange() != null;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__VALID:
				return valid != VALID_EDEFAULT;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__FUNCTION:
				return function != null;
			case EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS:
				return aggregationStatistics != null;
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
