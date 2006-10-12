/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.system.impl;

import de.uka.ipd.sdq.spa.resource.Resource;

import de.uka.ipd.sdq.spa.system.Behaviour;
import de.uka.ipd.sdq.spa.system.SystemModel;
import de.uka.ipd.sdq.spa.system.SystemPackage;

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
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.system.impl.SystemModelImpl#getProcesses <em>Processes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.system.impl.SystemModelImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemModelImpl extends EObjectImpl implements SystemModel {
	/**
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList processes = null;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList resources = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProcesses() {
		if (processes == null) {
			processes = new EObjectContainmentEList(Behaviour.class, this, SystemPackage.SYSTEM_MODEL__PROCESSES);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList(Resource.class, this, SystemPackage.SYSTEM_MODEL__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM_MODEL__PROCESSES:
				return ((InternalEList)getProcesses()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM_MODEL__RESOURCES:
				return ((InternalEList)getResources()).basicRemove(otherEnd, msgs);
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
			case SystemPackage.SYSTEM_MODEL__PROCESSES:
				return getProcesses();
			case SystemPackage.SYSTEM_MODEL__RESOURCES:
				return getResources();
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
			case SystemPackage.SYSTEM_MODEL__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection)newValue);
				return;
			case SystemPackage.SYSTEM_MODEL__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection)newValue);
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
			case SystemPackage.SYSTEM_MODEL__PROCESSES:
				getProcesses().clear();
				return;
			case SystemPackage.SYSTEM_MODEL__RESOURCES:
				getResources().clear();
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
			case SystemPackage.SYSTEM_MODEL__PROCESSES:
				return processes != null && !processes.isEmpty();
			case SystemPackage.SYSTEM_MODEL__RESOURCES:
				return resources != null && !resources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemModelImpl