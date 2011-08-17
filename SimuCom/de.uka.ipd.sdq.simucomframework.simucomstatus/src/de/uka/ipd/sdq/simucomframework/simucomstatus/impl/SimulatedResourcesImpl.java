/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulated Resources</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedResourcesImpl#getActiveResources <em>Active Resources</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedResourcesImpl#getPassiveResources <em>Passive Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulatedResourcesImpl extends EObjectImpl implements SimulatedResources {
	/**
	 * The cached value of the '{@link #getActiveResources() <em>Active Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ActiveResouce> activeResources;

	/**
	 * The cached value of the '{@link #getPassiveResources() <em>Passive Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassiveResources()
	 * @generated
	 * @ordered
	 */
	protected EList<PassiveResource> passiveResources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulatedResourcesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimucomstatusPackage.Literals.SIMULATED_RESOURCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActiveResouce> getActiveResources() {
		if (activeResources == null) {
			activeResources = new EObjectContainmentEList<ActiveResouce>(ActiveResouce.class, this, SimucomstatusPackage.SIMULATED_RESOURCES__ACTIVE_RESOURCES);
		}
		return activeResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PassiveResource> getPassiveResources() {
		if (passiveResources == null) {
			passiveResources = new EObjectContainmentEList<PassiveResource>(PassiveResource.class, this, SimucomstatusPackage.SIMULATED_RESOURCES__PASSIVE_RESOURCES);
		}
		return passiveResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimucomstatusPackage.SIMULATED_RESOURCES__ACTIVE_RESOURCES:
				return ((InternalEList<?>)getActiveResources()).basicRemove(otherEnd, msgs);
			case SimucomstatusPackage.SIMULATED_RESOURCES__PASSIVE_RESOURCES:
				return ((InternalEList<?>)getPassiveResources()).basicRemove(otherEnd, msgs);
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
			case SimucomstatusPackage.SIMULATED_RESOURCES__ACTIVE_RESOURCES:
				return getActiveResources();
			case SimucomstatusPackage.SIMULATED_RESOURCES__PASSIVE_RESOURCES:
				return getPassiveResources();
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
			case SimucomstatusPackage.SIMULATED_RESOURCES__ACTIVE_RESOURCES:
				getActiveResources().clear();
				getActiveResources().addAll((Collection<? extends ActiveResouce>)newValue);
				return;
			case SimucomstatusPackage.SIMULATED_RESOURCES__PASSIVE_RESOURCES:
				getPassiveResources().clear();
				getPassiveResources().addAll((Collection<? extends PassiveResource>)newValue);
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
			case SimucomstatusPackage.SIMULATED_RESOURCES__ACTIVE_RESOURCES:
				getActiveResources().clear();
				return;
			case SimucomstatusPackage.SIMULATED_RESOURCES__PASSIVE_RESOURCES:
				getPassiveResources().clear();
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
			case SimucomstatusPackage.SIMULATED_RESOURCES__ACTIVE_RESOURCES:
				return activeResources != null && !activeResources.isEmpty();
			case SimucomstatusPackage.SIMULATED_RESOURCES__PASSIVE_RESOURCES:
				return passiveResources != null && !passiveResources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SimulatedResourcesImpl
