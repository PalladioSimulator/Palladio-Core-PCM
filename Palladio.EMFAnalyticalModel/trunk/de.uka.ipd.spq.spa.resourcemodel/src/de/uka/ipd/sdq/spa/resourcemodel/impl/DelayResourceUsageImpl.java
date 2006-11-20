/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delay Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.DelayResourceUsageImpl#getDelayResource <em>Delay Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelayResourceUsageImpl extends ResourceUsageImpl implements DelayResourceUsage {
	/**
	 * The cached value of the '{@link #getDelayResource() <em>Delay Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelayResource()
	 * @generated
	 * @ordered
	 */
	protected DelayResource delayResource = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelayResourceUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResourceModelPackage.Literals.DELAY_RESOURCE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelayResource getDelayResource() {
		if (delayResource != null && delayResource.eIsProxy()) {
			InternalEObject oldDelayResource = (InternalEObject)delayResource;
			delayResource = (DelayResource)eResolveProxy(oldDelayResource);
			if (delayResource != oldDelayResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceModelPackage.DELAY_RESOURCE_USAGE__DELAY_RESOURCE, oldDelayResource, delayResource));
			}
		}
		return delayResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelayResource basicGetDelayResource() {
		return delayResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelayResource(DelayResource newDelayResource) {
		DelayResource oldDelayResource = delayResource;
		delayResource = newDelayResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceModelPackage.DELAY_RESOURCE_USAGE__DELAY_RESOURCE, oldDelayResource, delayResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceModelPackage.DELAY_RESOURCE_USAGE__DELAY_RESOURCE:
				if (resolve) return getDelayResource();
				return basicGetDelayResource();
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
			case ResourceModelPackage.DELAY_RESOURCE_USAGE__DELAY_RESOURCE:
				setDelayResource((DelayResource)newValue);
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
			case ResourceModelPackage.DELAY_RESOURCE_USAGE__DELAY_RESOURCE:
				setDelayResource((DelayResource)null);
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
			case ResourceModelPackage.DELAY_RESOURCE_USAGE__DELAY_RESOURCE:
				return delayResource != null;
		}
		return super.eIsSet(featureID);
	}

} //DelayResourceUsageImpl