/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Internal Control Flow Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractInternalControlFlowActionImpl#getResourceDemand_Action <em>Resource Demand Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractInternalControlFlowActionImpl extends AbstractActionImpl implements AbstractInternalControlFlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceDemand_Action() <em>Resource Demand Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDemand_Action()
	 * @generated
	 * @ordered
	 */
	protected EList<ParametricResourceDemand> resourceDemand_Action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractInternalControlFlowActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParametricResourceDemand> getResourceDemand_Action() {
		if (resourceDemand_Action == null) {
			resourceDemand_Action = new EObjectContainmentWithInverseEList<ParametricResourceDemand>(ParametricResourceDemand.class, this, SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND);
		}
		return resourceDemand_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceDemand_Action()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
				return ((InternalEList<?>)getResourceDemand_Action()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
				return getResourceDemand_Action();
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
			case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
				getResourceDemand_Action().clear();
				getResourceDemand_Action().addAll((Collection<? extends ParametricResourceDemand>)newValue);
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
			case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
				getResourceDemand_Action().clear();
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
			case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
				return resourceDemand_Action != null && !resourceDemand_Action.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractInternalControlFlowActionImpl
