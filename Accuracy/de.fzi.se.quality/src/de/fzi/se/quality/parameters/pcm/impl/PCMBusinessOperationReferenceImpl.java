/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import de.fzi.se.quality.parameters.impl.BusinessOperationReferenceImpl;

import de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;

import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl#getRequiredRole <em>Required Role</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMBusinessOperationReferenceImpl extends BusinessOperationReferenceImpl implements PCMBusinessOperationReference {
	/**
	 * The cached value of the '{@link #getRequiredRole() <em>Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRole()
	 * @generated
	 * @ordered
	 */
	protected OperationRequiredRole requiredRole;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected OperationSignature signature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMBusinessOperationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationRequiredRole getRequiredRole() {
		if (requiredRole != null && requiredRole.eIsProxy()) {
			InternalEObject oldRequiredRole = (InternalEObject)requiredRole;
			requiredRole = (OperationRequiredRole)eResolveProxy(oldRequiredRole);
			if (requiredRole != oldRequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__REQUIRED_ROLE, oldRequiredRole, requiredRole));
			}
		}
		return requiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationRequiredRole basicGetRequiredRole() {
		return requiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredRole(OperationRequiredRole newRequiredRole) {
		OperationRequiredRole oldRequiredRole = requiredRole;
		requiredRole = newRequiredRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__REQUIRED_ROLE, oldRequiredRole, requiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature getSignature() {
		if (signature != null && signature.eIsProxy()) {
			InternalEObject oldSignature = (InternalEObject)signature;
			signature = (OperationSignature)eResolveProxy(oldSignature);
			if (signature != oldSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE, oldSignature, signature));
			}
		}
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature basicGetSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(OperationSignature newSignature) {
		OperationSignature oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE, oldSignature, signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__REQUIRED_ROLE:
				if (resolve) return getRequiredRole();
				return basicGetRequiredRole();
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
				if (resolve) return getSignature();
				return basicGetSignature();
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
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__REQUIRED_ROLE:
				setRequiredRole((OperationRequiredRole)newValue);
				return;
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
				setSignature((OperationSignature)newValue);
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
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__REQUIRED_ROLE:
				setRequiredRole((OperationRequiredRole)null);
				return;
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
				setSignature((OperationSignature)null);
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
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__REQUIRED_ROLE:
				return requiredRole != null;
			case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
				return signature != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMBusinessOperationReferenceImpl
