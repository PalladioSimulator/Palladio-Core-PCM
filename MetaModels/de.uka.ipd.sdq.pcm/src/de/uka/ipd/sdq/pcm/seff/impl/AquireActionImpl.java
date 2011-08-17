
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.resourcetype.PassiveResourceType;

import de.uka.ipd.sdq.pcm.seff.AquireAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aquire Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AquireActionImpl#getResourceType_Aquire <em>Resource Type Aquire</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AquireActionImpl extends AbstractResourceDemandingActionImpl implements AquireAction {
	/**
	 * The cached value of the '{@link #getResourceType_Aquire() <em>Resource Type Aquire</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType_Aquire()
	 * @generated
	 * @ordered
	 */
	protected PassiveResourceType resourceType_Aquire = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AquireActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.AQUIRE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType getResourceType_Aquire() {
		if (resourceType_Aquire != null && resourceType_Aquire.eIsProxy()) {
			InternalEObject oldResourceType_Aquire = (InternalEObject)resourceType_Aquire;
			resourceType_Aquire = (PassiveResourceType)eResolveProxy(oldResourceType_Aquire);
			if (resourceType_Aquire != oldResourceType_Aquire) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE, oldResourceType_Aquire, resourceType_Aquire));
			}
		}
		return resourceType_Aquire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType basicGetResourceType_Aquire() {
		return resourceType_Aquire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType_Aquire(PassiveResourceType newResourceType_Aquire) {
		PassiveResourceType oldResourceType_Aquire = resourceType_Aquire;
		resourceType_Aquire = newResourceType_Aquire;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE, oldResourceType_Aquire, resourceType_Aquire));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE:
				if (resolve) return getResourceType_Aquire();
				return basicGetResourceType_Aquire();
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
			case SeffPackage.AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE:
				setResourceType_Aquire((PassiveResourceType)newValue);
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
			case SeffPackage.AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE:
				setResourceType_Aquire((PassiveResourceType)null);
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
			case SeffPackage.AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE:
				return resourceType_Aquire != null;
		}
		return super.eIsSet(featureID);
	}

} //AquireActionImpl