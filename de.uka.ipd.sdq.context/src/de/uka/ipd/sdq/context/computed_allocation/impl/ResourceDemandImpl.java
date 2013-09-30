/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage;
import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.computed_allocation.impl.ResourceDemandImpl#getParametricResourceDemand_ResourceDemand <em>Parametric Resource Demand Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_allocation.impl.ResourceDemandImpl#getSpecification_ResourceDemand <em>Specification Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDemandImpl extends EObjectImpl implements ResourceDemand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getParametricResourceDemand_ResourceDemand() <em>Parametric Resource Demand Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParametricResourceDemand_ResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected ParametricResourceDemand parametricResourceDemand_ResourceDemand;

	/**
	 * The cached value of the '{@link #getSpecification_ResourceDemand() <em>Specification Resource Demand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification_ResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable specification_ResourceDemand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDemandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputedAllocationPackage.Literals.RESOURCE_DEMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricResourceDemand getParametricResourceDemand_ResourceDemand() {
		if (parametricResourceDemand_ResourceDemand != null && parametricResourceDemand_ResourceDemand.eIsProxy()) {
			InternalEObject oldParametricResourceDemand_ResourceDemand = (InternalEObject)parametricResourceDemand_ResourceDemand;
			parametricResourceDemand_ResourceDemand = (ParametricResourceDemand)eResolveProxy(oldParametricResourceDemand_ResourceDemand);
			if (parametricResourceDemand_ResourceDemand != oldParametricResourceDemand_ResourceDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputedAllocationPackage.RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND, oldParametricResourceDemand_ResourceDemand, parametricResourceDemand_ResourceDemand));
			}
		}
		return parametricResourceDemand_ResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricResourceDemand basicGetParametricResourceDemand_ResourceDemand() {
		return parametricResourceDemand_ResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParametricResourceDemand_ResourceDemand(ParametricResourceDemand newParametricResourceDemand_ResourceDemand) {
		ParametricResourceDemand oldParametricResourceDemand_ResourceDemand = parametricResourceDemand_ResourceDemand;
		parametricResourceDemand_ResourceDemand = newParametricResourceDemand_ResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputedAllocationPackage.RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND, oldParametricResourceDemand_ResourceDemand, parametricResourceDemand_ResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getSpecification_ResourceDemand() {
		return specification_ResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification_ResourceDemand(PCMRandomVariable newSpecification_ResourceDemand, NotificationChain msgs) {
		PCMRandomVariable oldSpecification_ResourceDemand = specification_ResourceDemand;
		specification_ResourceDemand = newSpecification_ResourceDemand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND, oldSpecification_ResourceDemand, newSpecification_ResourceDemand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification_ResourceDemand(PCMRandomVariable newSpecification_ResourceDemand) {
		if (newSpecification_ResourceDemand != specification_ResourceDemand) {
			NotificationChain msgs = null;
			if (specification_ResourceDemand != null)
				msgs = ((InternalEObject)specification_ResourceDemand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND, null, msgs);
			if (newSpecification_ResourceDemand != null)
				msgs = ((InternalEObject)newSpecification_ResourceDemand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND, null, msgs);
			msgs = basicSetSpecification_ResourceDemand(newSpecification_ResourceDemand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND, newSpecification_ResourceDemand, newSpecification_ResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND:
				return basicSetSpecification_ResourceDemand(null, msgs);
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
			case ComputedAllocationPackage.RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND:
				if (resolve) return getParametricResourceDemand_ResourceDemand();
				return basicGetParametricResourceDemand_ResourceDemand();
			case ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND:
				return getSpecification_ResourceDemand();
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
			case ComputedAllocationPackage.RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND:
				setParametricResourceDemand_ResourceDemand((ParametricResourceDemand)newValue);
				return;
			case ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND:
				setSpecification_ResourceDemand((PCMRandomVariable)newValue);
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
			case ComputedAllocationPackage.RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND:
				setParametricResourceDemand_ResourceDemand((ParametricResourceDemand)null);
				return;
			case ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND:
				setSpecification_ResourceDemand((PCMRandomVariable)null);
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
			case ComputedAllocationPackage.RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND:
				return parametricResourceDemand_ResourceDemand != null;
			case ComputedAllocationPackage.RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND:
				return specification_ResourceDemand != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceDemandImpl
