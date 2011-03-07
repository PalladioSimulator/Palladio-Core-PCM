/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measured Characterisation Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCharacterisationValueImpl#getRequiredCharacterisation <em>Required Characterisation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MeasuredCharacterisationValueImpl extends IdentifierImpl implements MeasuredCharacterisationValue {
	/**
	 * The cached value of the '{@link #getRequiredCharacterisation() <em>Required Characterisation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredCharacterisation()
	 * @generated
	 * @ordered
	 */
	protected RequiredCharacterisation requiredCharacterisation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasuredCharacterisationValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawResourceDemandCountsPackage.Literals.MEASURED_CHARACTERISATION_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredCharacterisation getRequiredCharacterisation() {
		if (requiredCharacterisation != null && requiredCharacterisation.eIsProxy()) {
			InternalEObject oldRequiredCharacterisation = (InternalEObject)requiredCharacterisation;
			requiredCharacterisation = (RequiredCharacterisation)eResolveProxy(oldRequiredCharacterisation);
			if (requiredCharacterisation != oldRequiredCharacterisation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RawResourceDemandCountsPackage.MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION, oldRequiredCharacterisation, requiredCharacterisation));
			}
		}
		return requiredCharacterisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredCharacterisation basicGetRequiredCharacterisation() {
		return requiredCharacterisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredCharacterisation(RequiredCharacterisation newRequiredCharacterisation) {
		RequiredCharacterisation oldRequiredCharacterisation = requiredCharacterisation;
		requiredCharacterisation = newRequiredCharacterisation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawResourceDemandCountsPackage.MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION, oldRequiredCharacterisation, requiredCharacterisation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RawResourceDemandCountsPackage.MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION:
				if (resolve) return getRequiredCharacterisation();
				return basicGetRequiredCharacterisation();
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
			case RawResourceDemandCountsPackage.MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION:
				setRequiredCharacterisation((RequiredCharacterisation)newValue);
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
			case RawResourceDemandCountsPackage.MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION:
				setRequiredCharacterisation((RequiredCharacterisation)null);
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
			case RawResourceDemandCountsPackage.MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION:
				return requiredCharacterisation != null;
		}
		return super.eIsSet(featureID);
	}

} //MeasuredCharacterisationValueImpl
