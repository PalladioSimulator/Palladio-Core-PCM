/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Linking Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.FixedLinkingResourceCostImpl#getLinkingresource <em>Linkingresource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedLinkingResourceCostImpl extends CostImpl implements FixedLinkingResourceCost {
	/**
	 * The cached value of the '{@link #getLinkingresource() <em>Linkingresource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkingresource()
	 * @generated
	 * @ordered
	 */
	protected LinkingResource linkingresource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedLinkingResourceCostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.FIXED_LINKING_RESOURCE_COST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkingResource getLinkingresource() {
		if (linkingresource != null && linkingresource.eIsProxy()) {
			InternalEObject oldLinkingresource = (InternalEObject)linkingresource;
			linkingresource = (LinkingResource)eResolveProxy(oldLinkingresource);
			if (linkingresource != oldLinkingresource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, costPackage.FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE, oldLinkingresource, linkingresource));
			}
		}
		return linkingresource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkingResource basicGetLinkingresource() {
		return linkingresource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkingresource(LinkingResource newLinkingresource) {
		LinkingResource oldLinkingresource = linkingresource;
		linkingresource = newLinkingresource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE, oldLinkingresource, linkingresource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE:
				if (resolve) return getLinkingresource();
				return basicGetLinkingresource();
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
			case costPackage.FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE:
				setLinkingresource((LinkingResource)newValue);
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
			case costPackage.FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE:
				setLinkingresource((LinkingResource)null);
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
			case costPackage.FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE:
				return linkingresource != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public double getOperatingCost() {
		// TODO Auto-generated method stub
		return 0;
	}

} //FixedLinkingResourceCostImpl
