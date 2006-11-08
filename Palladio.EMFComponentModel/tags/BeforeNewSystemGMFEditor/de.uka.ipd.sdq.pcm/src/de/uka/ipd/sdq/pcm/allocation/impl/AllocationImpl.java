
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

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
 * An implementation of the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getAllocationContexts_Allocation <em>Allocation Contexts Allocation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationImpl extends EntityImpl implements Allocation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getAllocationContexts_Allocation() <em>Allocation Contexts Allocation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContexts_Allocation()
	 * @generated
	 * @ordered
	 */
	protected EList allocationContexts_Allocation = null;

	/**
	 * The cached value of the '{@link #getTargetResourceEnvironment_Allocation() <em>Target Resource Environment Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetResourceEnvironment_Allocation()
	 * @generated
	 * @ordered
	 */
	protected ResourceEnvironment targetResourceEnvironment_Allocation = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.ALLOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAllocationContexts_Allocation() {
		if (allocationContexts_Allocation == null) {
			allocationContexts_Allocation = new EObjectContainmentEList(AllocationContext.class, this, AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION);
		}
		return allocationContexts_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEnvironment getTargetResourceEnvironment_Allocation() {
		if (targetResourceEnvironment_Allocation != null && targetResourceEnvironment_Allocation.eIsProxy()) {
			InternalEObject oldTargetResourceEnvironment_Allocation = (InternalEObject)targetResourceEnvironment_Allocation;
			targetResourceEnvironment_Allocation = (ResourceEnvironment)eResolveProxy(oldTargetResourceEnvironment_Allocation);
			if (targetResourceEnvironment_Allocation != oldTargetResourceEnvironment_Allocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION, oldTargetResourceEnvironment_Allocation, targetResourceEnvironment_Allocation));
			}
		}
		return targetResourceEnvironment_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEnvironment basicGetTargetResourceEnvironment_Allocation() {
		return targetResourceEnvironment_Allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetResourceEnvironment_Allocation(ResourceEnvironment newTargetResourceEnvironment_Allocation) {
		ResourceEnvironment oldTargetResourceEnvironment_Allocation = targetResourceEnvironment_Allocation;
		targetResourceEnvironment_Allocation = newTargetResourceEnvironment_Allocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION, oldTargetResourceEnvironment_Allocation, targetResourceEnvironment_Allocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				return ((InternalEList)getAllocationContexts_Allocation()).basicRemove(otherEnd, msgs);
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
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				return getAllocationContexts_Allocation();
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				if (resolve) return getTargetResourceEnvironment_Allocation();
				return basicGetTargetResourceEnvironment_Allocation();
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
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				getAllocationContexts_Allocation().clear();
				getAllocationContexts_Allocation().addAll((Collection)newValue);
				return;
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				setTargetResourceEnvironment_Allocation((ResourceEnvironment)newValue);
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
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				getAllocationContexts_Allocation().clear();
				return;
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				setTargetResourceEnvironment_Allocation((ResourceEnvironment)null);
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
			case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
				return allocationContexts_Allocation != null && !allocationContexts_Allocation.isEmpty();
			case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
				return targetResourceEnvironment_Allocation != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationImpl