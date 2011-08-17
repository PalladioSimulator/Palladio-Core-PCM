/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation.impl;

import de.uka.ipd.sdq.context.actual_allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand;
import de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage;

import de.uka.ipd.sdq.context.usage.UsageContext;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actual Allocation Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.actual_allocation.impl.ActualAllocationContextImpl#getActualResourceDemands_ActualAllocationContext <em>Actual Resource Demands Actual Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.actual_allocation.impl.ActualAllocationContextImpl#getUsageContext_ActualAllocationContext <em>Usage Context Actual Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActualAllocationContextImpl extends EObjectImpl implements ActualAllocationContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getActualResourceDemands_ActualAllocationContext() <em>Actual Resource Demands Actual Allocation Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualResourceDemands_ActualAllocationContext()
	 * @generated
	 * @ordered
	 */
	protected EList actualResourceDemands_ActualAllocationContext;

	/**
	 * The cached value of the '{@link #getUsageContext_ActualAllocationContext() <em>Usage Context Actual Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageContext_ActualAllocationContext()
	 * @generated
	 * @ordered
	 */
	protected UsageContext usageContext_ActualAllocationContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActualAllocationContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Actual_AllocationPackage.Literals.ACTUAL_ALLOCATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getActualResourceDemands_ActualAllocationContext() {
		if (actualResourceDemands_ActualAllocationContext == null) {
			actualResourceDemands_ActualAllocationContext = new EObjectContainmentEList(ActualResourceDemand.class, this, Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT);
		}
		return actualResourceDemands_ActualAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageContext getUsageContext_ActualAllocationContext() {
		if (usageContext_ActualAllocationContext != null && usageContext_ActualAllocationContext.eIsProxy()) {
			InternalEObject oldUsageContext_ActualAllocationContext = (InternalEObject)usageContext_ActualAllocationContext;
			usageContext_ActualAllocationContext = (UsageContext)eResolveProxy(oldUsageContext_ActualAllocationContext);
			if (usageContext_ActualAllocationContext != oldUsageContext_ActualAllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT, oldUsageContext_ActualAllocationContext, usageContext_ActualAllocationContext));
			}
		}
		return usageContext_ActualAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageContext basicGetUsageContext_ActualAllocationContext() {
		return usageContext_ActualAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageContext_ActualAllocationContext(UsageContext newUsageContext_ActualAllocationContext) {
		UsageContext oldUsageContext_ActualAllocationContext = usageContext_ActualAllocationContext;
		usageContext_ActualAllocationContext = newUsageContext_ActualAllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT, oldUsageContext_ActualAllocationContext, usageContext_ActualAllocationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT:
				return ((InternalEList)getActualResourceDemands_ActualAllocationContext()).basicRemove(otherEnd, msgs);
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
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT:
				return getActualResourceDemands_ActualAllocationContext();
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT:
				if (resolve) return getUsageContext_ActualAllocationContext();
				return basicGetUsageContext_ActualAllocationContext();
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
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT:
				getActualResourceDemands_ActualAllocationContext().clear();
				getActualResourceDemands_ActualAllocationContext().addAll((Collection)newValue);
				return;
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT:
				setUsageContext_ActualAllocationContext((UsageContext)newValue);
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
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT:
				getActualResourceDemands_ActualAllocationContext().clear();
				return;
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT:
				setUsageContext_ActualAllocationContext((UsageContext)null);
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
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT:
				return actualResourceDemands_ActualAllocationContext != null && !actualResourceDemands_ActualAllocationContext.isEmpty();
			case Actual_AllocationPackage.ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT:
				return usageContext_ActualAllocationContext != null;
		}
		return super.eIsSet(featureID);
	}

} //ActualAllocationContextImpl
