
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.resourcetype.PassiveResourceType;

import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Release Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ReleaseActionImpl#getResourceType_Release <em>Resource Type Release</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReleaseActionImpl extends AbstractResourceDemandingActionImpl implements ReleaseAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceType_Release() <em>Resource Type Release</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType_Release()
	 * @generated
	 * @ordered
	 */
	protected PassiveResourceType resourceType_Release;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.RELEASE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType getResourceType_Release() {
		if (resourceType_Release != null && resourceType_Release.eIsProxy()) {
			InternalEObject oldResourceType_Release = (InternalEObject)resourceType_Release;
			resourceType_Release = (PassiveResourceType)eResolveProxy(oldResourceType_Release);
			if (resourceType_Release != oldResourceType_Release) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.RELEASE_ACTION__RESOURCE_TYPE_RELEASE, oldResourceType_Release, resourceType_Release));
			}
		}
		return resourceType_Release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType basicGetResourceType_Release() {
		return resourceType_Release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType_Release(PassiveResourceType newResourceType_Release) {
		PassiveResourceType oldResourceType_Release = resourceType_Release;
		resourceType_Release = newResourceType_Release;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RELEASE_ACTION__RESOURCE_TYPE_RELEASE, oldResourceType_Release, resourceType_Release));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.RELEASE_ACTION__RESOURCE_TYPE_RELEASE:
				if (resolve) return getResourceType_Release();
				return basicGetResourceType_Release();
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
			case SeffPackage.RELEASE_ACTION__RESOURCE_TYPE_RELEASE:
				setResourceType_Release((PassiveResourceType)newValue);
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
			case SeffPackage.RELEASE_ACTION__RESOURCE_TYPE_RELEASE:
				setResourceType_Release((PassiveResourceType)null);
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
			case SeffPackage.RELEASE_ACTION__RESOURCE_TYPE_RELEASE:
				return resourceType_Release != null;
		}
		return super.eIsSet(featureID);
	}

} //ReleaseActionImpl
