/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.impl;

import de.fzi.se.validation.testbased.results.InfrastructureCallVFN;
import de.fzi.se.validation.testbased.results.ResultsPackage;

import edu.kit.ipd.sdq.bycounter.output.ObservedEntityExecution;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Call VFN</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.InfrastructureCallVFNImpl#getObserved <em>Observed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureCallVFNImpl extends ValidationFailureNoticeImpl implements InfrastructureCallVFN {
	/**
	 * The cached value of the '{@link #getObserved() <em>Observed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObserved()
	 * @generated
	 * @ordered
	 */
	protected ObservedEntityExecution observed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureCallVFNImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.INFRASTRUCTURE_CALL_VFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservedEntityExecution getObserved() {
		if (observed != null && observed.eIsProxy()) {
			InternalEObject oldObserved = (InternalEObject)observed;
			observed = (ObservedEntityExecution)eResolveProxy(oldObserved);
			if (observed != oldObserved) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.INFRASTRUCTURE_CALL_VFN__OBSERVED, oldObserved, observed));
			}
		}
		return observed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservedEntityExecution basicGetObserved() {
		return observed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObserved(ObservedEntityExecution newObserved) {
		ObservedEntityExecution oldObserved = observed;
		observed = newObserved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.INFRASTRUCTURE_CALL_VFN__OBSERVED, oldObserved, observed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultsPackage.INFRASTRUCTURE_CALL_VFN__OBSERVED:
				if (resolve) return getObserved();
				return basicGetObserved();
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
			case ResultsPackage.INFRASTRUCTURE_CALL_VFN__OBSERVED:
				setObserved((ObservedEntityExecution)newValue);
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
			case ResultsPackage.INFRASTRUCTURE_CALL_VFN__OBSERVED:
				setObserved((ObservedEntityExecution)null);
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
			case ResultsPackage.INFRASTRUCTURE_CALL_VFN__OBSERVED:
				return observed != null;
		}
		return super.eIsSet(featureID);
	}

} //InfrastructureCallVFNImpl
