/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.impl.OperationReferenceImpl;
import de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl#getRole <em>Role</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMInfrastructureOperationReferenceImpl extends OperationReferenceImpl implements PCMInfrastructureOperationReference {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureRequiredRole role;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureSignature signature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMInfrastructureOperationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureRequiredRole getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (InfrastructureRequiredRole)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureRequiredRole basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(InfrastructureRequiredRole newRole) {
		InfrastructureRequiredRole oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureSignature getSignature() {
		if (signature != null && signature.eIsProxy()) {
			InternalEObject oldSignature = (InternalEObject)signature;
			signature = (InfrastructureSignature)eResolveProxy(oldSignature);
			if (signature != oldSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE, oldSignature, signature));
			}
		}
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureSignature basicGetSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(InfrastructureSignature newSignature) {
		InfrastructureSignature oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE, oldSignature, signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
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
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
				setRole((InfrastructureRequiredRole)newValue);
				return;
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
				setSignature((InfrastructureSignature)newValue);
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
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
				setRole((InfrastructureRequiredRole)null);
				return;
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
				setSignature((InfrastructureSignature)null);
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
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
				return role != null;
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
				return signature != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMInfrastructureOperationReferenceImpl
