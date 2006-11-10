/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.allocation.impl;

import de.uka.ipd.sdq.context.allocation.ActualResourceDemand;
import de.uka.ipd.sdq.context.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actual Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.allocation.impl.ActualResourceDemandImpl#getParametricResourceDemand_ActualResourceDemand <em>Parametric Resource Demand Actual Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.allocation.impl.ActualResourceDemandImpl#getRandomVariable_ActualResourceDemand <em>Random Variable Actual Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActualResourceDemandImpl extends EObjectImpl implements ActualResourceDemand {
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
	protected ParametricResourceDemand parametricResourceDemand_ActualResourceDemand = null;

	/**
	 * The cached value of the '{@link #getRandomVariable_ActualResourceDemand() <em>Random Variable Actual Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomVariable_ActualResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected RandomVariable randomVariable_ActualResourceDemand = null;

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
		return AllocationPackage.Literals.ACTUAL_RESOURCE_DEMAND;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND, oldParametricResourceDemand_ActualResourceDemand, parametricResourceDemand_ActualResourceDemand));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND, oldParametricResourceDemand_ActualResourceDemand, parametricResourceDemand_ActualResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomVariable getRandomVariable_ActualResourceDemand() {
		if (randomVariable_ActualResourceDemand != null && randomVariable_ActualResourceDemand.eIsProxy()) {
			InternalEObject oldRandomVariable_ActualResourceDemand = (InternalEObject)randomVariable_ActualResourceDemand;
			randomVariable_ActualResourceDemand = (RandomVariable)eResolveProxy(oldRandomVariable_ActualResourceDemand);
			if (randomVariable_ActualResourceDemand != oldRandomVariable_ActualResourceDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND, oldRandomVariable_ActualResourceDemand, randomVariable_ActualResourceDemand));
			}
		}
		return randomVariable_ActualResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomVariable basicGetRandomVariable_ActualResourceDemand() {
		return randomVariable_ActualResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRandomVariable_ActualResourceDemand(RandomVariable newRandomVariable_ActualResourceDemand) {
		RandomVariable oldRandomVariable_ActualResourceDemand = randomVariable_ActualResourceDemand;
		randomVariable_ActualResourceDemand = newRandomVariable_ActualResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND, oldRandomVariable_ActualResourceDemand, randomVariable_ActualResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				if (resolve) return getParametricResourceDemand_ActualResourceDemand();
				return basicGetParametricResourceDemand_ActualResourceDemand();
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND:
				if (resolve) return getRandomVariable_ActualResourceDemand();
				return basicGetRandomVariable_ActualResourceDemand();
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
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				setParametricResourceDemand_ActualResourceDemand((ParametricResourceDemand)newValue);
				return;
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND:
				setRandomVariable_ActualResourceDemand((RandomVariable)newValue);
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
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				setParametricResourceDemand_ActualResourceDemand((ParametricResourceDemand)null);
				return;
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND:
				setRandomVariable_ActualResourceDemand((RandomVariable)null);
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
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND:
				return parametricResourceDemand_ActualResourceDemand != null;
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND:
				return randomVariable_ActualResourceDemand != null;
		}
		return super.eIsSet(featureID);
	}

} //ActualResourceDemandImpl