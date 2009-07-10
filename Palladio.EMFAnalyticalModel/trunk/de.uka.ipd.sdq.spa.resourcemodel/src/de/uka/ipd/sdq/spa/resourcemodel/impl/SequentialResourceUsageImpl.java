/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequential Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.SequentialResourceUsageImpl#getResourceUsages <em>Resource Usages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequentialResourceUsageImpl extends AbstractResourceUsageImpl implements SequentialResourceUsage {
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
	protected SequentialResourceUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResourceModelPackage.Literals.SEQUENTIAL_RESOURCE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResourceUsages() {
		if (resourceUsages == null) {
			resourceUsages = new EObjectContainmentEList(AbstractResourceUsage.class, this, ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES);
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
			case ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES:
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
			case ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES:
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
			case ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES:
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
			case ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES:
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
			case ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES:
				return resourceUsages != null && !resourceUsages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequentialResourceUsageImpl
