/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ProcessingResourceUsageImpl#getProcessingResource <em>Processing Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingResourceUsageImpl extends ResourceUsageImpl implements ProcessingResourceUsage {
	/**
	 * The cached value of the '{@link #getProcessingResource() <em>Processing Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingResource()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResource processingResource = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingResourceUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResourceModelPackage.Literals.PROCESSING_RESOURCE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResource getProcessingResource() {
		if (processingResource != null && processingResource.eIsProxy()) {
			InternalEObject oldProcessingResource = (InternalEObject)processingResource;
			processingResource = (ProcessingResource)eResolveProxy(oldProcessingResource);
			if (processingResource != oldProcessingResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceModelPackage.PROCESSING_RESOURCE_USAGE__PROCESSING_RESOURCE, oldProcessingResource, processingResource));
			}
		}
		return processingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResource basicGetProcessingResource() {
		return processingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingResource(ProcessingResource newProcessingResource) {
		ProcessingResource oldProcessingResource = processingResource;
		processingResource = newProcessingResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceModelPackage.PROCESSING_RESOURCE_USAGE__PROCESSING_RESOURCE, oldProcessingResource, processingResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceModelPackage.PROCESSING_RESOURCE_USAGE__PROCESSING_RESOURCE:
				if (resolve) return getProcessingResource();
				return basicGetProcessingResource();
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
			case ResourceModelPackage.PROCESSING_RESOURCE_USAGE__PROCESSING_RESOURCE:
				setProcessingResource((ProcessingResource)newValue);
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
			case ResourceModelPackage.PROCESSING_RESOURCE_USAGE__PROCESSING_RESOURCE:
				setProcessingResource((ProcessingResource)null);
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
			case ResourceModelPackage.PROCESSING_RESOURCE_USAGE__PROCESSING_RESOURCE:
				return processingResource != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessingResourceUsageImpl