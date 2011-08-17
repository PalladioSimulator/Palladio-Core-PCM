/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import java.util.List;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

import de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Cost Per Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostPerInstanceImpl#getAllocation <em>Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentCostPerInstanceImpl extends ComponentCostImpl implements ComponentCostPerInstance {
	/**
	 * The cached value of the '{@link #getAllocation() <em>Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocation()
	 * @generated
	 * @ordered
	 */
	protected Allocation allocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentCostPerInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.COMPONENT_COST_PER_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation getAllocation() {
		if (allocation != null && allocation.eIsProxy()) {
			InternalEObject oldAllocation = (InternalEObject)allocation;
			allocation = (Allocation)eResolveProxy(oldAllocation);
			if (allocation != oldAllocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, costPackage.COMPONENT_COST_PER_INSTANCE__ALLOCATION, oldAllocation, allocation));
			}
		}
		return allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation basicGetAllocation() {
		return allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocation(Allocation newAllocation) {
		Allocation oldAllocation = allocation;
		allocation = newAllocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.COMPONENT_COST_PER_INSTANCE__ALLOCATION, oldAllocation, allocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.COMPONENT_COST_PER_INSTANCE__ALLOCATION:
				if (resolve) return getAllocation();
				return basicGetAllocation();
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
			case costPackage.COMPONENT_COST_PER_INSTANCE__ALLOCATION:
				setAllocation((Allocation)newValue);
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
			case costPackage.COMPONENT_COST_PER_INSTANCE__ALLOCATION:
				setAllocation((Allocation)null);
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
			case costPackage.COMPONENT_COST_PER_INSTANCE__ALLOCATION:
				return allocation != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getOperatingCost() {
		// the operating costs are the componentOperatingCost times the number of instances of the component.
		return getNumberOfInstances() * this.getComponentOperatingCost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getInitialCost() {
		// the initial costs are the componentOperatingCost times the number of instances of the component.
		return getNumberOfInstances() * this.getComponentInitialCost();
	}
	
	private int getNumberOfInstances(){
		int numberOfInstances = 0;
		if (this.getAllocation() != null){
			List<AllocationContext> allocationContexts = this.getAllocation().getAllocationContexts_Allocation();
			for (AllocationContext allocationContext : allocationContexts) {
				if (allocationContext.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext().getId()
						.equals(this.getRepositoryComponent().getId())){
					numberOfInstances ++;
				}
			}
		} else {
			numberOfInstances = 1;
		}
		return numberOfInstances;
	}

} //ComponentCostPerInstanceImpl
