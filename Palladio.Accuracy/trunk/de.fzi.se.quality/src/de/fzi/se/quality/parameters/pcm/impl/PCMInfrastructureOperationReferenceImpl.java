/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import de.fzi.se.quality.parameters.impl.InfrastructureOperationReferenceImpl;

import de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;

import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;

import de.uka.ipd.sdq.pcm.repository.Signature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl#getResourceRequiredRole <em>Resource Required Role</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMInfrastructureOperationReferenceImpl extends InfrastructureOperationReferenceImpl implements PCMInfrastructureOperationReference {
	/**
	 * The cached value of the '{@link #getResourceRequiredRole() <em>Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequiredRole()
	 * @generated
	 * @ordered
	 */
	protected ResourceRequiredRole resourceRequiredRole;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected Signature signature;

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
	public ResourceRequiredRole getResourceRequiredRole() {
		if (resourceRequiredRole != null && resourceRequiredRole.eIsProxy()) {
			InternalEObject oldResourceRequiredRole = (InternalEObject)resourceRequiredRole;
			resourceRequiredRole = (ResourceRequiredRole)eResolveProxy(oldResourceRequiredRole);
			if (resourceRequiredRole != oldResourceRequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__RESOURCE_REQUIRED_ROLE, oldResourceRequiredRole, resourceRequiredRole));
			}
		}
		return resourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetResourceRequiredRole() {
		return resourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiredRole(ResourceRequiredRole newResourceRequiredRole) {
		ResourceRequiredRole oldResourceRequiredRole = resourceRequiredRole;
		resourceRequiredRole = newResourceRequiredRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__RESOURCE_REQUIRED_ROLE, oldResourceRequiredRole, resourceRequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getSignature() {
		if (signature != null && signature.eIsProxy()) {
			InternalEObject oldSignature = (InternalEObject)signature;
			signature = (Signature)eResolveProxy(oldSignature);
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
	public Signature basicGetSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(Signature newSignature) {
		Signature oldSignature = signature;
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
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__RESOURCE_REQUIRED_ROLE:
				if (resolve) return getResourceRequiredRole();
				return basicGetResourceRequiredRole();
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
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__RESOURCE_REQUIRED_ROLE:
				setResourceRequiredRole((ResourceRequiredRole)newValue);
				return;
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
				setSignature((Signature)newValue);
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
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__RESOURCE_REQUIRED_ROLE:
				setResourceRequiredRole((ResourceRequiredRole)null);
				return;
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
				setSignature((Signature)null);
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
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__RESOURCE_REQUIRED_ROLE:
				return resourceRequiredRole != null;
			case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
				return signature != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMInfrastructureOperationReferenceImpl
