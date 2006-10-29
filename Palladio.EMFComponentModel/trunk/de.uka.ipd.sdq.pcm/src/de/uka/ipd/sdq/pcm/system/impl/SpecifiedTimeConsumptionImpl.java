
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl;

import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption;
import de.uka.ipd.sdq.pcm.system.SystemPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specified Time Consumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SpecifiedTimeConsumptionImpl#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecifiedTimeConsumptionImpl extends RandomVariableImpl implements SpecifiedTimeConsumption {
	/**
	 * The cached value of the '{@link #getSignature_SpecifiedTimeConsumption() <em>Signature Specified Time Consumption</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature_SpecifiedTimeConsumption()
	 * @generated
	 * @ordered
	 */
	protected Signature signature_SpecifiedTimeConsumption = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecifiedTimeConsumptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SPECIFIED_TIME_CONSUMPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getSignature_SpecifiedTimeConsumption() {
		if (signature_SpecifiedTimeConsumption != null && signature_SpecifiedTimeConsumption.eIsProxy()) {
			InternalEObject oldSignature_SpecifiedTimeConsumption = (InternalEObject)signature_SpecifiedTimeConsumption;
			signature_SpecifiedTimeConsumption = (Signature)eResolveProxy(oldSignature_SpecifiedTimeConsumption);
			if (signature_SpecifiedTimeConsumption != oldSignature_SpecifiedTimeConsumption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION, oldSignature_SpecifiedTimeConsumption, signature_SpecifiedTimeConsumption));
			}
		}
		return signature_SpecifiedTimeConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetSignature_SpecifiedTimeConsumption() {
		return signature_SpecifiedTimeConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature_SpecifiedTimeConsumption(Signature newSignature_SpecifiedTimeConsumption) {
		Signature oldSignature_SpecifiedTimeConsumption = signature_SpecifiedTimeConsumption;
		signature_SpecifiedTimeConsumption = newSignature_SpecifiedTimeConsumption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION, oldSignature_SpecifiedTimeConsumption, signature_SpecifiedTimeConsumption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemPackage.SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				if (resolve) return getSignature_SpecifiedTimeConsumption();
				return basicGetSignature_SpecifiedTimeConsumption();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SystemPackage.SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				setSignature_SpecifiedTimeConsumption((Signature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SystemPackage.SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				setSignature_SpecifiedTimeConsumption((Signature)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SystemPackage.SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				return signature_SpecifiedTimeConsumption != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecifiedTimeConsumptionImpl