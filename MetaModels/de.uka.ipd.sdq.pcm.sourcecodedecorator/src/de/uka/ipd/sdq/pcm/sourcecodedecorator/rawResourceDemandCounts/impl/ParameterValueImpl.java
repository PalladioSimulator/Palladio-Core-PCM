/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.repository.Parameter;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.ParameterValueImpl#getDescribedParameter <em>Described Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.ParameterValueImpl#getMeasuredCharacterisationValue <em>Measured Characterisation Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterValueImpl extends IdentifierImpl implements ParameterValue {
	/**
	 * The cached value of the '{@link #getDescribedParameter() <em>Described Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescribedParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter describedParameter;

	/**
	 * The cached value of the '{@link #getMeasuredCharacterisationValue() <em>Measured Characterisation Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredCharacterisationValue()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasuredCharacterisationValue> measuredCharacterisationValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawResourceDemandCountsPackage.Literals.PARAMETER_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getDescribedParameter() {
		if (describedParameter != null && describedParameter.eIsProxy()) {
			InternalEObject oldDescribedParameter = (InternalEObject)describedParameter;
			describedParameter = (Parameter)eResolveProxy(oldDescribedParameter);
			if (describedParameter != oldDescribedParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RawResourceDemandCountsPackage.PARAMETER_VALUE__DESCRIBED_PARAMETER, oldDescribedParameter, describedParameter));
			}
		}
		return describedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetDescribedParameter() {
		return describedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescribedParameter(Parameter newDescribedParameter) {
		Parameter oldDescribedParameter = describedParameter;
		describedParameter = newDescribedParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawResourceDemandCountsPackage.PARAMETER_VALUE__DESCRIBED_PARAMETER, oldDescribedParameter, describedParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasuredCharacterisationValue> getMeasuredCharacterisationValue() {
		if (measuredCharacterisationValue == null) {
			measuredCharacterisationValue = new EObjectContainmentEList<MeasuredCharacterisationValue>(MeasuredCharacterisationValue.class, this, RawResourceDemandCountsPackage.PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE);
		}
		return measuredCharacterisationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE:
				return ((InternalEList<?>)getMeasuredCharacterisationValue()).basicRemove(otherEnd, msgs);
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
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__DESCRIBED_PARAMETER:
				if (resolve) return getDescribedParameter();
				return basicGetDescribedParameter();
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE:
				return getMeasuredCharacterisationValue();
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
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__DESCRIBED_PARAMETER:
				setDescribedParameter((Parameter)newValue);
				return;
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE:
				getMeasuredCharacterisationValue().clear();
				getMeasuredCharacterisationValue().addAll((Collection<? extends MeasuredCharacterisationValue>)newValue);
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
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__DESCRIBED_PARAMETER:
				setDescribedParameter((Parameter)null);
				return;
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE:
				getMeasuredCharacterisationValue().clear();
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
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__DESCRIBED_PARAMETER:
				return describedParameter != null;
			case RawResourceDemandCountsPackage.PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE:
				return measuredCharacterisationValue != null && !measuredCharacterisationValue.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ParameterValueImpl
