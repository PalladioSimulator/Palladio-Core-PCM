/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specified Qo SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getSignature_SpecifiedQoSAnnation <em>Signature Specified Qo SAnnation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl#getRole_SpecifiedQoSAnnotation <em>Role Specified Qo SAnnotation</em>}</li>
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
	 * The cached value of the '{@link #getSignature_SpecifiedQoSAnnation() <em>Signature Specified Qo SAnnation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature_SpecifiedQoSAnnation()
	 * @generated
	 * @ordered
	 */
	protected Signature signature_SpecifiedQoSAnnation;

	/**
	 * The cached value of the '{@link #getRole_SpecifiedQoSAnnotation() <em>Role Specified Qo SAnnotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole_SpecifiedQoSAnnotation()
	 * @generated
	 * @ordered
	 */
	protected Role role_SpecifiedQoSAnnotation;

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
	public Signature getSignature_SpecifiedQoSAnnation() {
		if (signature_SpecifiedQoSAnnation != null && signature_SpecifiedQoSAnnation.eIsProxy()) {
			InternalEObject oldSignature_SpecifiedQoSAnnation = (InternalEObject)signature_SpecifiedQoSAnnation;
			signature_SpecifiedQoSAnnation = (Signature)eResolveProxy(oldSignature_SpecifiedQoSAnnation);
			if (signature_SpecifiedQoSAnnation != oldSignature_SpecifiedQoSAnnation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION, oldSignature_SpecifiedQoSAnnation, signature_SpecifiedQoSAnnation));
			}
		}
		return signature_SpecifiedQoSAnnation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetSignature_SpecifiedQoSAnnation() {
		return signature_SpecifiedQoSAnnation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature_SpecifiedQoSAnnation(Signature newSignature_SpecifiedQoSAnnation) {
		Signature oldSignature_SpecifiedQoSAnnation = signature_SpecifiedQoSAnnation;
		signature_SpecifiedQoSAnnation = newSignature_SpecifiedQoSAnnation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION, oldSignature_SpecifiedQoSAnnation, signature_SpecifiedQoSAnnation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getRole_SpecifiedQoSAnnotation() {
		if (role_SpecifiedQoSAnnotation != null && role_SpecifiedQoSAnnotation.eIsProxy()) {
			InternalEObject oldRole_SpecifiedQoSAnnotation = (InternalEObject)role_SpecifiedQoSAnnotation;
			role_SpecifiedQoSAnnotation = (Role)eResolveProxy(oldRole_SpecifiedQoSAnnotation);
			if (role_SpecifiedQoSAnnotation != oldRole_SpecifiedQoSAnnotation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION, oldRole_SpecifiedQoSAnnotation, role_SpecifiedQoSAnnotation));
			}
		}
		return role_SpecifiedQoSAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetRole_SpecifiedQoSAnnotation() {
		return role_SpecifiedQoSAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole_SpecifiedQoSAnnotation(Role newRole_SpecifiedQoSAnnotation) {
		Role oldRole_SpecifiedQoSAnnotation = role_SpecifiedQoSAnnotation;
		role_SpecifiedQoSAnnotation = newRole_SpecifiedQoSAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION, oldRole_SpecifiedQoSAnnotation, role_SpecifiedQoSAnnotation));
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
				if (resolve) return getSignature_SpecifiedQoSAnnation();
				return basicGetSignature_SpecifiedQoSAnnation();
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
				if (resolve) return getRole_SpecifiedQoSAnnotation();
				return basicGetRole_SpecifiedQoSAnnotation();
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
				setSignature_SpecifiedQoSAnnation((Signature)newValue);
				return;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
				setRole_SpecifiedQoSAnnotation((Role)newValue);
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
				setSignature_SpecifiedQoSAnnation((Signature)null);
				return;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
				setRole_SpecifiedQoSAnnotation((Role)null);
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
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION:
				return signature_SpecifiedQoSAnnation != null;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION:
				return role_SpecifiedQoSAnnotation != null;
			case QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
				return specification_SpecifiedExecutionTime != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecifiedQoSAnnotationImpl
