
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.allocation.Allocation;

import de.uka.ipd.sdq.pcm.assembly.Assembly;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;
import de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getSystemProvidedRole_System <em>System Provided Role System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getAssembly_System <em>Assembly System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getProvidedDelegationConnector_System <em>Provided Delegation Connector System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getRequiredDelegationConnector_System <em>Required Delegation Connector System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getAllocation_System <em>Allocation System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getSystemRequiredRole_System <em>System Required Role System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EntityImpl implements de.uka.ipd.sdq.pcm.system.System {
	/**
	 * The cached value of the '{@link #getSystemProvidedRole_System() <em>System Provided Role System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemProvidedRole_System()
	 * @generated
	 * @ordered
	 */
	protected EList systemProvidedRole_System = null;

	/**
	 * The cached value of the '{@link #getAssembly_System() <em>Assembly System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssembly_System()
	 * @generated
	 * @ordered
	 */
	protected Assembly assembly_System = null;

	/**
	 * The cached value of the '{@link #getProvidedDelegationConnector_System() <em>Provided Delegation Connector System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedDelegationConnector_System()
	 * @generated
	 * @ordered
	 */
	protected EList providedDelegationConnector_System = null;

	/**
	 * The cached value of the '{@link #getRequiredDelegationConnector_System() <em>Required Delegation Connector System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDelegationConnector_System()
	 * @generated
	 * @ordered
	 */
	protected EList requiredDelegationConnector_System = null;

	/**
	 * The cached value of the '{@link #getAllocation_System() <em>Allocation System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocation_System()
	 * @generated
	 * @ordered
	 */
	protected Allocation allocation_System = null;

	/**
	 * The cached value of the '{@link #getSystemRequiredRole_System() <em>System Required Role System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemRequiredRole_System()
	 * @generated
	 * @ordered
	 */
	protected EList systemRequiredRole_System = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSystemProvidedRole_System() {
		if (systemProvidedRole_System == null) {
			systemProvidedRole_System = new EObjectContainmentWithInverseEList(SystemProvidedRole.class, this, SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM, SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE);
		}
		return systemProvidedRole_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assembly getAssembly_System() {
		if (assembly_System != null && assembly_System.eIsProxy()) {
			InternalEObject oldAssembly_System = (InternalEObject)assembly_System;
			assembly_System = (Assembly)eResolveProxy(oldAssembly_System);
			if (assembly_System != oldAssembly_System) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM__ASSEMBLY_SYSTEM, oldAssembly_System, assembly_System));
			}
		}
		return assembly_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assembly basicGetAssembly_System() {
		return assembly_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssembly_System(Assembly newAssembly_System) {
		Assembly oldAssembly_System = assembly_System;
		assembly_System = newAssembly_System;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__ASSEMBLY_SYSTEM, oldAssembly_System, assembly_System));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProvidedDelegationConnector_System() {
		if (providedDelegationConnector_System == null) {
			providedDelegationConnector_System = new EObjectContainmentEList(SystemProvidedDelegationConnector.class, this, SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM);
		}
		return providedDelegationConnector_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRequiredDelegationConnector_System() {
		if (requiredDelegationConnector_System == null) {
			requiredDelegationConnector_System = new EObjectContainmentEList(SystemRequiredDelegationConnector.class, this, SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM);
		}
		return requiredDelegationConnector_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation getAllocation_System() {
		if (allocation_System != null && allocation_System.eIsProxy()) {
			InternalEObject oldAllocation_System = (InternalEObject)allocation_System;
			allocation_System = (Allocation)eResolveProxy(oldAllocation_System);
			if (allocation_System != oldAllocation_System) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM__ALLOCATION_SYSTEM, oldAllocation_System, allocation_System));
			}
		}
		return allocation_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation basicGetAllocation_System() {
		return allocation_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocation_System(Allocation newAllocation_System) {
		Allocation oldAllocation_System = allocation_System;
		allocation_System = newAllocation_System;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__ALLOCATION_SYSTEM, oldAllocation_System, allocation_System));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSystemRequiredRole_System() {
		if (systemRequiredRole_System == null) {
			systemRequiredRole_System = new EObjectContainmentWithInverseEList(SystemRequiredRole.class, this, SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM, SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE);
		}
		return systemRequiredRole_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return ((InternalEList)getSystemProvidedRole_System()).basicAdd(otherEnd, msgs);
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return ((InternalEList)getSystemRequiredRole_System()).basicAdd(otherEnd, msgs);
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
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return ((InternalEList)getSystemProvidedRole_System()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM:
				return ((InternalEList)getProvidedDelegationConnector_System()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM:
				return ((InternalEList)getRequiredDelegationConnector_System()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return ((InternalEList)getSystemRequiredRole_System()).basicRemove(otherEnd, msgs);
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
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return getSystemProvidedRole_System();
			case SystemPackage.SYSTEM__ASSEMBLY_SYSTEM:
				if (resolve) return getAssembly_System();
				return basicGetAssembly_System();
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM:
				return getProvidedDelegationConnector_System();
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM:
				return getRequiredDelegationConnector_System();
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				if (resolve) return getAllocation_System();
				return basicGetAllocation_System();
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return getSystemRequiredRole_System();
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
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				getSystemProvidedRole_System().clear();
				getSystemProvidedRole_System().addAll((Collection)newValue);
				return;
			case SystemPackage.SYSTEM__ASSEMBLY_SYSTEM:
				setAssembly_System((Assembly)newValue);
				return;
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM:
				getProvidedDelegationConnector_System().clear();
				getProvidedDelegationConnector_System().addAll((Collection)newValue);
				return;
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM:
				getRequiredDelegationConnector_System().clear();
				getRequiredDelegationConnector_System().addAll((Collection)newValue);
				return;
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				setAllocation_System((Allocation)newValue);
				return;
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				getSystemRequiredRole_System().clear();
				getSystemRequiredRole_System().addAll((Collection)newValue);
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
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				getSystemProvidedRole_System().clear();
				return;
			case SystemPackage.SYSTEM__ASSEMBLY_SYSTEM:
				setAssembly_System((Assembly)null);
				return;
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM:
				getProvidedDelegationConnector_System().clear();
				return;
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM:
				getRequiredDelegationConnector_System().clear();
				return;
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				setAllocation_System((Allocation)null);
				return;
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				getSystemRequiredRole_System().clear();
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
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return systemProvidedRole_System != null && !systemProvidedRole_System.isEmpty();
			case SystemPackage.SYSTEM__ASSEMBLY_SYSTEM:
				return assembly_System != null;
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM:
				return providedDelegationConnector_System != null && !providedDelegationConnector_System.isEmpty();
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM:
				return requiredDelegationConnector_System != null && !requiredDelegationConnector_System.isEmpty();
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				return allocation_System != null;
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return systemRequiredRole_System != null && !systemRequiredRole_System.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemImpl