/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage;
import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationContextImpl#getResourceDemands_ComputedAllocationContext <em>Resource Demands Computed Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationContextImpl#getUsageContext_ComputedAllocationContext <em>Usage Context Computed Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationContextImpl#getAllocationContext_ComputedAllocationContext <em>Allocation Context Computed Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputedAllocationContextImpl extends EntityImpl implements ComputedAllocationContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getResourceDemands_ComputedAllocationContext() <em>Resource Demands Computed Allocation Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDemands_ComputedAllocationContext()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceDemand> resourceDemands_ComputedAllocationContext;

	/**
	 * The cached value of the '{@link #getUsageContext_ComputedAllocationContext() <em>Usage Context Computed Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageContext_ComputedAllocationContext()
	 * @generated
	 * @ordered
	 */
	protected ComputedUsageContext usageContext_ComputedAllocationContext;

	/**
	 * The cached value of the '{@link #getAllocationContext_ComputedAllocationContext() <em>Allocation Context Computed Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContext_ComputedAllocationContext()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationContext_ComputedAllocationContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputedAllocationContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputedAllocationPackage.Literals.COMPUTED_ALLOCATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceDemand> getResourceDemands_ComputedAllocationContext() {
		if (resourceDemands_ComputedAllocationContext == null) {
			resourceDemands_ComputedAllocationContext = new EObjectContainmentEList<ResourceDemand>(ResourceDemand.class, this, ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT);
		}
		return resourceDemands_ComputedAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedUsageContext getUsageContext_ComputedAllocationContext() {
		if (usageContext_ComputedAllocationContext != null && usageContext_ComputedAllocationContext.eIsProxy()) {
			InternalEObject oldUsageContext_ComputedAllocationContext = (InternalEObject)usageContext_ComputedAllocationContext;
			usageContext_ComputedAllocationContext = (ComputedUsageContext)eResolveProxy(oldUsageContext_ComputedAllocationContext);
			if (usageContext_ComputedAllocationContext != oldUsageContext_ComputedAllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT, oldUsageContext_ComputedAllocationContext, usageContext_ComputedAllocationContext));
			}
		}
		return usageContext_ComputedAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedUsageContext basicGetUsageContext_ComputedAllocationContext() {
		return usageContext_ComputedAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageContext_ComputedAllocationContext(ComputedUsageContext newUsageContext_ComputedAllocationContext) {
		ComputedUsageContext oldUsageContext_ComputedAllocationContext = usageContext_ComputedAllocationContext;
		usageContext_ComputedAllocationContext = newUsageContext_ComputedAllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT, oldUsageContext_ComputedAllocationContext, usageContext_ComputedAllocationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext getAllocationContext_ComputedAllocationContext() {
		if (allocationContext_ComputedAllocationContext != null && allocationContext_ComputedAllocationContext.eIsProxy()) {
			InternalEObject oldAllocationContext_ComputedAllocationContext = (InternalEObject)allocationContext_ComputedAllocationContext;
			allocationContext_ComputedAllocationContext = (AllocationContext)eResolveProxy(oldAllocationContext_ComputedAllocationContext);
			if (allocationContext_ComputedAllocationContext != oldAllocationContext_ComputedAllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT, oldAllocationContext_ComputedAllocationContext, allocationContext_ComputedAllocationContext));
			}
		}
		return allocationContext_ComputedAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationContext_ComputedAllocationContext() {
		return allocationContext_ComputedAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationContext_ComputedAllocationContext(AllocationContext newAllocationContext_ComputedAllocationContext) {
		AllocationContext oldAllocationContext_ComputedAllocationContext = allocationContext_ComputedAllocationContext;
		allocationContext_ComputedAllocationContext = newAllocationContext_ComputedAllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT, oldAllocationContext_ComputedAllocationContext, allocationContext_ComputedAllocationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT:
				return ((InternalEList<?>)getResourceDemands_ComputedAllocationContext()).basicRemove(otherEnd, msgs);
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
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT:
				return getResourceDemands_ComputedAllocationContext();
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				if (resolve) return getUsageContext_ComputedAllocationContext();
				return basicGetUsageContext_ComputedAllocationContext();
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				if (resolve) return getAllocationContext_ComputedAllocationContext();
				return basicGetAllocationContext_ComputedAllocationContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT:
				getResourceDemands_ComputedAllocationContext().clear();
				getResourceDemands_ComputedAllocationContext().addAll((Collection<? extends ResourceDemand>)newValue);
				return;
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				setUsageContext_ComputedAllocationContext((ComputedUsageContext)newValue);
				return;
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				setAllocationContext_ComputedAllocationContext((AllocationContext)newValue);
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
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT:
				getResourceDemands_ComputedAllocationContext().clear();
				return;
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				setUsageContext_ComputedAllocationContext((ComputedUsageContext)null);
				return;
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				setAllocationContext_ComputedAllocationContext((AllocationContext)null);
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
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT:
				return resourceDemands_ComputedAllocationContext != null && !resourceDemands_ComputedAllocationContext.isEmpty();
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				return usageContext_ComputedAllocationContext != null;
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT:
				return allocationContext_ComputedAllocationContext != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputedAllocationContextImpl
