
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Resource Demanding Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractResourceDemandingActionImpl#getResourceDemand_Action <em>Resource Demand Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractResourceDemandingActionImpl extends AbstractActionImpl implements AbstractResourceDemandingAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getResourceDemand_Action() <em>Resource Demand Action</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDemand_Action()
	 * @generated
	 * @ordered
	 */
	protected EList resourceDemand_Action = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractResourceDemandingActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.ABSTRACT_RESOURCE_DEMANDING_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResourceDemand_Action() {
		if (resourceDemand_Action == null) {
			resourceDemand_Action = new EObjectWithInverseResolvingEList(ParametricResourceDemand.class, this, SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION, SeffPackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND);
		}
		return resourceDemand_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION:
				return ((InternalEList)getResourceDemand_Action()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION:
				return ((InternalEList)getResourceDemand_Action()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION:
				return getResourceDemand_Action();
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
			case SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION:
				getResourceDemand_Action().clear();
				getResourceDemand_Action().addAll((Collection)newValue);
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
			case SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION:
				return resourceDemand_Action != null && !resourceDemand_Action.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractResourceDemandingActionImpl