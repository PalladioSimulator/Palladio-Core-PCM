/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.PCMREResourceSignature;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCMRE Resource Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREResourceSignatureImpl#getResourceSignature <em>Resource Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREResourceSignatureImpl extends PCMREImpl implements PCMREResourceSignature {
	/**
	 * The cached value of the '{@link #getResourceSignature() <em>Resource Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceSignature()
	 * @generated
	 * @ordered
	 */
	protected ResourceSignature resourceSignature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMREResourceSignatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCMRE_RESOURCE_SIGNATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSignature getResourceSignature() {
		if (resourceSignature != null && resourceSignature.eIsProxy()) {
			InternalEObject oldResourceSignature = (InternalEObject)resourceSignature;
			resourceSignature = (ResourceSignature)eResolveProxy(oldResourceSignature);
			if (resourceSignature != oldResourceSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE, oldResourceSignature, resourceSignature));
			}
		}
		return resourceSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSignature basicGetResourceSignature() {
		return resourceSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceSignature(ResourceSignature newResourceSignature) {
		ResourceSignature oldResourceSignature = resourceSignature;
		resourceSignature = newResourceSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE, oldResourceSignature, resourceSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
				if (resolve) return getResourceSignature();
				return basicGetResourceSignature();
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
				setResourceSignature((ResourceSignature)newValue);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
				setResourceSignature((ResourceSignature)null);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
				return resourceSignature != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMREResourceSignatureImpl
