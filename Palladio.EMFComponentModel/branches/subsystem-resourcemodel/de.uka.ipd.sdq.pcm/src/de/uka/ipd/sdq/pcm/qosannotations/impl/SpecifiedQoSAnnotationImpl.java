/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.impl;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;

import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specified Qo SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getRole_SpecifiedExecutionTime <em>Role Specified Execution Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getSpecification_SpecifiedExecutionTime <em>Specification Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SpecifiedQoSAnnotationImpl extends EObjectImpl implements SpecifiedQoSAnnotation {
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
	 * The cached value of the '{@link #getSpecification_SpecifiedExecutionTime() <em>Specification Specified Execution Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification_SpecifiedExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable specification_SpecifiedExecutionTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecifiedQoSAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QosannotationsPackage.Literals.SPECIFIED_QO_SANNOTATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION, oldSignature_SpecifiedTimeConsumption, signature_SpecifiedTimeConsumption));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION, oldSignature_SpecifiedTimeConsumption, signature_SpecifiedTimeConsumption));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_EXECUTION_TIME, oldRole_SpecifiedExecutionTime, role_SpecifiedExecutionTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_EXECUTION_TIME, oldRole_SpecifiedExecutionTime, role_SpecifiedExecutionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getSpecification_SpecifiedExecutionTime() {
		return specification_SpecifiedExecutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification_SpecifiedExecutionTime(PCMRandomVariable newSpecification_SpecifiedExecutionTime, NotificationChain msgs) {
		PCMRandomVariable oldSpecification_SpecifiedExecutionTime = specification_SpecifiedExecutionTime;
		specification_SpecifiedExecutionTime = newSpecification_SpecifiedExecutionTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME, oldSpecification_SpecifiedExecutionTime, newSpecification_SpecifiedExecutionTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification_SpecifiedExecutionTime(PCMRandomVariable newSpecification_SpecifiedExecutionTime) {
		if (newSpecification_SpecifiedExecutionTime != specification_SpecifiedExecutionTime) {
			NotificationChain msgs = null;
			if (specification_SpecifiedExecutionTime != null)
				msgs = ((InternalEObject)specification_SpecifiedExecutionTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME, null, msgs);
			if (newSpecification_SpecifiedExecutionTime != null)
				msgs = ((InternalEObject)newSpecification_SpecifiedExecutionTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME, null, msgs);
			msgs = basicSetSpecification_SpecifiedExecutionTime(newSpecification_SpecifiedExecutionTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME, newSpecification_SpecifiedExecutionTime, newSpecification_SpecifiedExecutionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
				return basicSetSpecification_SpecifiedExecutionTime(null, msgs);
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				if (resolve) return getSignature_SpecifiedTimeConsumption();
				return basicGetSignature_SpecifiedTimeConsumption();
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_EXECUTION_TIME:
				if (resolve) return getRole_SpecifiedExecutionTime();
				return basicGetRole_SpecifiedExecutionTime();
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
				return getSpecification_SpecifiedExecutionTime();
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				setSignature_SpecifiedTimeConsumption((Signature)newValue);
				return;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_EXECUTION_TIME:
				setRole_SpecifiedExecutionTime((Role)newValue);
				return;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
				setSpecification_SpecifiedExecutionTime((PCMRandomVariable)newValue);
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				setSignature_SpecifiedTimeConsumption((Signature)null);
				return;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_EXECUTION_TIME:
				setRole_SpecifiedExecutionTime((Role)null);
				return;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
				setSpecification_SpecifiedExecutionTime((PCMRandomVariable)null);
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION:
				return signature_SpecifiedTimeConsumption != null;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_EXECUTION_TIME:
				return role_SpecifiedExecutionTime != null;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
				return specification_SpecifiedExecutionTime != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecifiedQoSAnnotationImpl
