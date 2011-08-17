/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.impl;

import de.fzi.se.quality.parameters.ParameterValue;

import de.fzi.se.validation.testbased.results.ParameterVFN;
import de.fzi.se.validation.testbased.results.ResultsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter VFN</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.ParameterVFNImpl#getObservedValue <em>Observed Value</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.ParameterVFNImpl#getExpectedValue <em>Expected Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterVFNImpl extends ValidationFailureNoticeImpl implements ParameterVFN {
	/**
	 * The cached value of the '{@link #getObservedValue() <em>Observed Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedValue()
	 * @generated
	 * @ordered
	 */
	protected ParameterValue observedValue;

	/**
	 * The cached value of the '{@link #getExpectedValue() <em>Expected Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedValue()
	 * @generated
	 * @ordered
	 */
	protected ParameterValue expectedValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterVFNImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.PARAMETER_VFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValue getObservedValue() {
		return observedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObservedValue(ParameterValue newObservedValue, NotificationChain msgs) {
		ParameterValue oldObservedValue = observedValue;
		observedValue = newObservedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE, oldObservedValue, newObservedValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObservedValue(ParameterValue newObservedValue) {
		if (newObservedValue != observedValue) {
			NotificationChain msgs = null;
			if (observedValue != null)
				msgs = ((InternalEObject)observedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE, null, msgs);
			if (newObservedValue != null)
				msgs = ((InternalEObject)newObservedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE, null, msgs);
			msgs = basicSetObservedValue(newObservedValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE, newObservedValue, newObservedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValue getExpectedValue() {
		return expectedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpectedValue(ParameterValue newExpectedValue, NotificationChain msgs) {
		ParameterValue oldExpectedValue = expectedValue;
		expectedValue = newExpectedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE, oldExpectedValue, newExpectedValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpectedValue(ParameterValue newExpectedValue) {
		if (newExpectedValue != expectedValue) {
			NotificationChain msgs = null;
			if (expectedValue != null)
				msgs = ((InternalEObject)expectedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE, null, msgs);
			if (newExpectedValue != null)
				msgs = ((InternalEObject)newExpectedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE, null, msgs);
			msgs = basicSetExpectedValue(newExpectedValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE, newExpectedValue, newExpectedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE:
				return basicSetObservedValue(null, msgs);
			case ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE:
				return basicSetExpectedValue(null, msgs);
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
			case ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE:
				return getObservedValue();
			case ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE:
				return getExpectedValue();
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
			case ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE:
				setObservedValue((ParameterValue)newValue);
				return;
			case ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE:
				setExpectedValue((ParameterValue)newValue);
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
			case ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE:
				setObservedValue((ParameterValue)null);
				return;
			case ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE:
				setExpectedValue((ParameterValue)null);
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
			case ResultsPackage.PARAMETER_VFN__OBSERVED_VALUE:
				return observedValue != null;
			case ResultsPackage.PARAMETER_VFN__EXPECTED_VALUE:
				return expectedValue != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterVFNImpl
