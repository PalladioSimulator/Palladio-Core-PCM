/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationCharacterization;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregation Characterization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationCharacterizationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationCharacterizationImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregationCharacterizationImpl extends EObjectImpl implements AggregationCharacterization {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregationCharacterizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.AGGREGATION_CHARACTERIZATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfmodelPackage.AGGREGATION_CHARACTERIZATION__FUNCTION, oldFunction, function));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.AGGREGATION_CHARACTERIZATION__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedMeasurements getAggregatedMeasurements() {
		if (eContainerFeatureID != EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS) return null;
		return (AggregatedMeasurements)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregatedMeasurements(AggregatedMeasurements newAggregatedMeasurements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAggregatedMeasurements, EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregatedMeasurements(AggregatedMeasurements newAggregatedMeasurements) {
		if (newAggregatedMeasurements != eInternalContainer() || (eContainerFeatureID != EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS && newAggregatedMeasurements != null)) {
			if (EcoreUtil.isAncestor(this, newAggregatedMeasurements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAggregatedMeasurements != null)
				msgs = ((InternalEObject)newAggregatedMeasurements).eInverseAdd(this, EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_CHARACTERIZATION, AggregatedMeasurements.class, msgs);
			msgs = basicSetAggregatedMeasurements(newAggregatedMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS, newAggregatedMeasurements, newAggregatedMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS:
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
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS:
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
		switch (eContainerFeatureID) {
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.AGGREGATED_MEASUREMENTS__AGGREGATION_CHARACTERIZATION, AggregatedMeasurements.class, msgs);
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
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__FUNCTION:
				if (resolve) return getFunction();
				return basicGetFunction();
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS:
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
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__FUNCTION:
				setFunction((AggregationFunctionDescription)newValue);
				return;
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS:
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
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__FUNCTION:
				setFunction((AggregationFunctionDescription)null);
				return;
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS:
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
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__FUNCTION:
				return function != null;
			case EmfmodelPackage.AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements() != null;
		}
		return super.eIsSet(featureID);
	}

} //AggregationCharacterizationImpl
