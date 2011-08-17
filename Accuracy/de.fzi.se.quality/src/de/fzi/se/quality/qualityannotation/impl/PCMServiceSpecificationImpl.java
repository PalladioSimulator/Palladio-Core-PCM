/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Service Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMServiceSpecificationImpl#getResourceDemandingSEFF <em>Resource Demanding SEFF</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMServiceSpecificationImpl extends ServiceSpecificationImpl implements PCMServiceSpecification {
	/**
	 * The cached value of the '{@link #getResourceDemandingSEFF() <em>Resource Demanding SEFF</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDemandingSEFF()
	 * @generated
	 * @ordered
	 */
	protected ResourceDemandingSEFF resourceDemandingSEFF;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMServiceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCM_SERVICE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingSEFF getResourceDemandingSEFF() {
		if (resourceDemandingSEFF != null && resourceDemandingSEFF.eIsProxy()) {
			InternalEObject oldResourceDemandingSEFF = (InternalEObject)resourceDemandingSEFF;
			resourceDemandingSEFF = (ResourceDemandingSEFF)eResolveProxy(oldResourceDemandingSEFF);
			if (resourceDemandingSEFF != oldResourceDemandingSEFF) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF, oldResourceDemandingSEFF, resourceDemandingSEFF));
			}
		}
		return resourceDemandingSEFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingSEFF basicGetResourceDemandingSEFF() {
		return resourceDemandingSEFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceDemandingSEFF(ResourceDemandingSEFF newResourceDemandingSEFF) {
		ResourceDemandingSEFF oldResourceDemandingSEFF = resourceDemandingSEFF;
		resourceDemandingSEFF = newResourceDemandingSEFF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF, oldResourceDemandingSEFF, resourceDemandingSEFF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
				if (resolve) return getResourceDemandingSEFF();
				return basicGetResourceDemandingSEFF();
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
			case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
				setResourceDemandingSEFF((ResourceDemandingSEFF)newValue);
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
			case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
				setResourceDemandingSEFF((ResourceDemandingSEFF)null);
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
			case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
				return resourceDemandingSEFF != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMServiceSpecificationImpl
