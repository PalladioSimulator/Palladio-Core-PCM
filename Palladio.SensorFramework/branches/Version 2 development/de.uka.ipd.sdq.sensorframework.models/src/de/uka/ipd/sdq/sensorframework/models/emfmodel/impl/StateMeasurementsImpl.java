/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.impl;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.State;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.StateMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.StateMeasurementsImpl#getObservedStates <em>Observed States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMeasurementsImpl extends RawYValuesImpl implements StateMeasurements {
	/**
	 * The cached value of the '{@link #getObservedStates() <em>Observed States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> observedStates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMeasurementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return emfmodelPackage.Literals.STATE_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getObservedStates() {
		if (observedStates == null) {
			observedStates = new EObjectResolvingEList<State>(State.class, this, emfmodelPackage.STATE_MEASUREMENTS__OBSERVED_STATES);
		}
		return observedStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case emfmodelPackage.STATE_MEASUREMENTS__OBSERVED_STATES:
				return getObservedStates();
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
			case emfmodelPackage.STATE_MEASUREMENTS__OBSERVED_STATES:
				getObservedStates().clear();
				getObservedStates().addAll((Collection<? extends State>)newValue);
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
			case emfmodelPackage.STATE_MEASUREMENTS__OBSERVED_STATES:
				getObservedStates().clear();
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
			case emfmodelPackage.STATE_MEASUREMENTS__OBSERVED_STATES:
				return observedStates != null && !observedStates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateMeasurementsImpl
