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
import de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl#getRole <em>Role</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMBusinessOperationReferenceImpl extends OperationReferenceImpl implements PCMBusinessOperationReference {
	/**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRole()
     * @generated
     * @ordered
     */
	protected OperationRequiredRole role;

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
	public OperationRequiredRole getRole() {
        if (role != null && role.eIsProxy()) {
            InternalEObject oldRole = (InternalEObject)role;
            role = (OperationRequiredRole)eResolveProxy(oldRole);
            if (role != oldRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE, oldRole, role));
            }
        }
        return role;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OperationRequiredRole basicGetRole() {
        return role;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRole(OperationRequiredRole newRole) {
        OperationRequiredRole oldRole = role;
        role = newRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE, oldRole, role));
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
            case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
                if (resolve) return getRole();
                return basicGetRole();
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
            case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
                setRole((OperationRequiredRole)newValue);
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
            case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
                setRole((OperationRequiredRole)null);
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
            case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
                return role != null;
            case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
                return signature != null;
        }
        return super.eIsSet(featureID);
    }

} //PCMBusinessOperationReferenceImpl
