/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.qnm.CompositeResourceUsage;
import de.uka.ipd.sdq.qnm.QnmPackage;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;

import de.uka.ipd.sdq.spa.resourcemodel.impl.AbstractResourceUsageImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.CompositeResourceUsageImpl#getPassiveResource <em>Passive Resource</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.CompositeResourceUsageImpl#getResourceUsages <em>Resource Usages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeResourceUsageImpl extends AbstractResourceUsageImpl implements CompositeResourceUsage {
	/**
	 * The cached value of the '{@link #getPassiveResource() <em>Passive Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassiveResource()
	 * @generated
	 * @ordered
	 */
	protected PassiveResource passiveResource = null;

	/**
	 * The cached value of the '{@link #getResourceUsages() <em>Resource Usages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUsages()
	 * @generated
	 * @ordered
	 */
	protected EList resourceUsages = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeResourceUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QnmPackage.Literals.COMPOSITE_RESOURCE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResource getPassiveResource() {
		if (passiveResource != null && passiveResource.eIsProxy()) {
			InternalEObject oldPassiveResource = (InternalEObject)passiveResource;
			passiveResource = (PassiveResource)eResolveProxy(oldPassiveResource);
			if (passiveResource != oldPassiveResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QnmPackage.COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE, oldPassiveResource, passiveResource));
			}
		}
		return passiveResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResource basicGetPassiveResource() {
		return passiveResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassiveResource(PassiveResource newPassiveResource) {
		PassiveResource oldPassiveResource = passiveResource;
		passiveResource = newPassiveResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QnmPackage.COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE, oldPassiveResource, passiveResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResourceUsages() {
		if (resourceUsages == null) {
			resourceUsages = new EObjectContainmentEList(AbstractResourceUsage.class, this, QnmPackage.COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES);
		}
		return resourceUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES:
				return ((InternalEList)getResourceUsages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE:
				if (resolve) return getPassiveResource();
				return basicGetPassiveResource();
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES:
				return getResourceUsages();
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
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE:
				setPassiveResource((PassiveResource)newValue);
				return;
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES:
				getResourceUsages().clear();
				getResourceUsages().addAll((Collection)newValue);
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
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE:
				setPassiveResource((PassiveResource)null);
				return;
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES:
				getResourceUsages().clear();
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
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE:
				return passiveResource != null;
			case QnmPackage.COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES:
				return resourceUsages != null && !resourceUsages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeResourceUsageImpl