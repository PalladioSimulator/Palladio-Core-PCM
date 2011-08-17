/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation.impl;

import de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand;
import de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage;

import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;

import de.uka.ipd.sdq.stoex.impl.RandomVariableImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actual Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.actual_allocation.impl.ActualResourceDemandImpl#getParametricResourceDemand_ActualResourceDemand <em>Parametric Resource Demand Actual Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActualResourceDemandImpl extends RandomVariableImpl implements ActualResourceDemand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getParametricResourceDemand_ActualResourceDemand() <em>Parametric Resource Demand Actual Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParametricResourceDemand_ActualResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected ParametricResourceDemand parametricResourceDemand_ActualResourceDemand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActualResourceDemandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Actual_AllocationPackage.Literals.ACTUAL_RESOURCE_DEMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricResourceDemand getParametricResourceDemand_ActualResourceDemand() {
		if (parametricResourceDemand_ActualResourceDemand != null && parametricResourceDemand_ActualResourceDemand.eIsProxy()) {
			InternalEObject oldParametricResourceDemand_ActualResourceDemand = (InternalEObject)parametricResourceDemand_ActualResourceDemand;
			parametricResourceDemand_ActualResourceDemand = (ParametricResourceDemand)eResolveProxy(oldParametricResourceDemand_ActualResourceDemand);
			if (parametricResourceDemand_ActualResourceDemand != oldParametricResourceDemand_ActualResourceDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Actual_AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND, oldParametricResourceDemand_ActualResourceDemand, parametricResourceDemand_ActualResourceDemand));
			}
		}
		return parametricResourceDemand_ActualResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricResourceDemand basicGetParametricResourceDemand_ActualResourceDemand() {
		return parametricResourceDemand_ActualResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParametricResourceDemand_ActualResourceDemand(ParametricResourceDemand newParametricResourceDemand_ActualResourceDemand) {
		ParametricResourceDemand oldParametricResourceDemand_ActualResourceDemand = parametricResourceDemand_ActualResourceDemand;
		parametricResourceDemand_ActualResourceDemand = newParametricResourceDemand_ActualResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actual_AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND, oldParametricResourceDemand_ActualResourceDemand, parametricResourceDemand_ActualResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actual_AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				if (resolve) return getParametricResourceDemand_ActualResourceDemand();
				return basicGetParametricResourceDemand_ActualResourceDemand();
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
			case Actual_AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				setParametricResourceDemand_ActualResourceDemand((ParametricResourceDemand)newValue);
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
			case Actual_AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				setParametricResourceDemand_ActualResourceDemand((ParametricResourceDemand)null);
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
			case Actual_AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				return parametricResourceDemand_ActualResourceDemand != null;
		}
		return super.eIsSet(featureID);
	}

} //ActualResourceDemandImpl
