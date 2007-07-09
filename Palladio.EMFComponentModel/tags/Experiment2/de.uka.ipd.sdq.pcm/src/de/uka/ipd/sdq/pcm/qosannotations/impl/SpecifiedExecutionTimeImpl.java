
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.impl;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime;

import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.stoex.impl.RandomVariableImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specified Execution Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedExecutionTimeImpl#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedExecutionTimeImpl#getRole_SpecifiedExecutionTime <em>Role Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SpecifiedExecutionTimeImpl extends RandomVariableImpl implements SpecifiedExecutionTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSignature_SpecifiedTimeConsumption() <em>Signature Specified Time Consumption</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature_SpecifiedTimeConsumption()
	 * @generated
	 * @ordered
	 */
	protected Signature signature_SpecifiedTimeConsumption;

	/**
	 * The cached value of the '{@link #getRole_SpecifiedExecutionTime() <em>Role Specified Execution Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole_SpecifiedExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected Role role_SpecifiedExecutionTime;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecifiedExecutionTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QosannotationsPackage.Literals.SPECIFIED_EXECUTION_TIME;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QosannotationsPackage.SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION, oldSignature_SpecifiedTimeConsumption, signature_SpecifiedTimeConsumption));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION, oldSignature_SpecifiedTimeConsumption, signature_SpecifiedTimeConsumption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getRole_SpecifiedExecutionTime() {
		if (role_SpecifiedExecutionTime != null && role_SpecifiedExecutionTime.eIsProxy()) {
			InternalEObject oldRole_SpecifiedExecutionTime = (InternalEObject)role_SpecifiedExecutionTime;
			role_SpecifiedExecutionTime = (Role)eResolveProxy(oldRole_SpecifiedExecutionTime);
			if (role_SpecifiedExecutionTime != oldRole_SpecifiedExecutionTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QosannotationsPackage.SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME, oldRole_SpecifiedExecutionTime, role_SpecifiedExecutionTime));
			}
		}
		return role_SpecifiedExecutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetRole_SpecifiedExecutionTime() {
		return role_SpecifiedExecutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole_SpecifiedExecutionTime(Role newRole_SpecifiedExecutionTime) {
		Role oldRole_SpecifiedExecutionTime = role_SpecifiedExecutionTime;
		role_SpecifiedExecutionTime = newRole_SpecifiedExecutionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME, oldRole_SpecifiedExecutionTime, role_SpecifiedExecutionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				if (resolve) return getSignature_SpecifiedTimeConsumption();
				return basicGetSignature_SpecifiedTimeConsumption();
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME:
				if (resolve) return getRole_SpecifiedExecutionTime();
				return basicGetRole_SpecifiedExecutionTime();
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
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				setSignature_SpecifiedTimeConsumption((Signature)newValue);
				return;
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME:
				setRole_SpecifiedExecutionTime((Role)newValue);
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
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				setSignature_SpecifiedTimeConsumption((Signature)null);
				return;
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME:
				setRole_SpecifiedExecutionTime((Role)null);
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
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				return signature_SpecifiedTimeConsumption != null;
			case QosannotationsPackage.SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME:
				return role_SpecifiedExecutionTime != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecifiedExecutionTimeImpl
