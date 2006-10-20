/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage.impl;

import de.uka.ipd.sdq.context.usage.Usage;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.context.usage.UsagePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.usage.impl.UsageImpl#getUsageContexts <em>Usage Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageImpl extends EObjectImpl implements Usage {
	/**
	 * The cached value of the '{@link #getUsageContexts() <em>Usage Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageContexts()
	 * @generated
	 * @ordered
	 */
	protected EList usageContexts = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagePackage.Literals.USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUsageContexts() {
		if (usageContexts == null) {
			usageContexts = new EObjectContainmentEList(UsageContext.class, this, UsagePackage.USAGE__USAGE_CONTEXTS);
		}
		return usageContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagePackage.USAGE__USAGE_CONTEXTS:
				return ((InternalEList)getUsageContexts()).basicRemove(otherEnd, msgs);
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
			case UsagePackage.USAGE__USAGE_CONTEXTS:
				return getUsageContexts();
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
			case UsagePackage.USAGE__USAGE_CONTEXTS:
				getUsageContexts().clear();
				getUsageContexts().addAll((Collection)newValue);
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
			case UsagePackage.USAGE__USAGE_CONTEXTS:
				getUsageContexts().clear();
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
			case UsagePackage.USAGE__USAGE_CONTEXTS:
				return usageContexts != null && !usageContexts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UsageImpl