/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.AbstractResourceUsage;
import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.DemandAction;
import de.uka.ipd.sdq.capra.core.DemandIdentifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Demand Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.DemandActionImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.DemandActionImpl#getResourceUsage <em>Resource Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DemandActionImpl extends ActionImpl implements DemandAction {
	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected DemandIdentifier identifier;

	/**
	 * The cached value of the '{@link #getResourceUsage() <em>Resource Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUsage()
	 * @generated
	 * @ordered
	 */
	protected AbstractResourceUsage resourceUsage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DemandActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.DEMAND_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandIdentifier getIdentifier() {
		if (identifier != null && identifier.eIsProxy()) {
			InternalEObject oldIdentifier = (InternalEObject)identifier;
			identifier = (DemandIdentifier)eResolveProxy(oldIdentifier);
			if (identifier != oldIdentifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.DEMAND_ACTION__IDENTIFIER, oldIdentifier, identifier));
			}
		}
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandIdentifier basicGetIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(DemandIdentifier newIdentifier) {
		DemandIdentifier oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DEMAND_ACTION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractResourceUsage getResourceUsage() {
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceUsage(AbstractResourceUsage newResourceUsage, NotificationChain msgs) {
		AbstractResourceUsage oldResourceUsage = resourceUsage;
		resourceUsage = newResourceUsage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.DEMAND_ACTION__RESOURCE_USAGE, oldResourceUsage, newResourceUsage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUsage(AbstractResourceUsage newResourceUsage) {
		if (newResourceUsage != resourceUsage) {
			NotificationChain msgs = null;
			if (resourceUsage != null)
				msgs = ((InternalEObject)resourceUsage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.DEMAND_ACTION__RESOURCE_USAGE, null, msgs);
			if (newResourceUsage != null)
				msgs = ((InternalEObject)newResourceUsage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.DEMAND_ACTION__RESOURCE_USAGE, null, msgs);
			msgs = basicSetResourceUsage(newResourceUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DEMAND_ACTION__RESOURCE_USAGE, newResourceUsage, newResourceUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.DEMAND_ACTION__RESOURCE_USAGE:
				return basicSetResourceUsage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.DEMAND_ACTION__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
			case CorePackage.DEMAND_ACTION__RESOURCE_USAGE:
				return getResourceUsage();
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
			case CorePackage.DEMAND_ACTION__IDENTIFIER:
				setIdentifier((DemandIdentifier)newValue);
				return;
			case CorePackage.DEMAND_ACTION__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)newValue);
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
			case CorePackage.DEMAND_ACTION__IDENTIFIER:
				setIdentifier((DemandIdentifier)null);
				return;
			case CorePackage.DEMAND_ACTION__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)null);
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
			case CorePackage.DEMAND_ACTION__IDENTIFIER:
				return identifier != null;
			case CorePackage.DEMAND_ACTION__RESOURCE_USAGE:
				return resourceUsage != null;
		}
		return super.eIsSet(featureID);
	}

} //DemandActionImpl
