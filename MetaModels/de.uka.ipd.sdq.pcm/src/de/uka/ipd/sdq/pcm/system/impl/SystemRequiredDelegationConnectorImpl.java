
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredDelegationConnectorImpl#getSystemRequiredRole_SystemRequiredDelegationConnector <em>System Required Role System Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredDelegationConnectorImpl#getAssemblyContext_SystemRequiredDelegationConnector <em>Assembly Context System Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredDelegationConnectorImpl#getRequiredRole_SystemRequiredDelegationConnector <em>Required Role System Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemRequiredDelegationConnectorImpl extends EObjectImpl implements SystemRequiredDelegationConnector {
	/**
	 * The cached value of the '{@link #getSystemRequiredRole_SystemRequiredDelegationConnector() <em>System Required Role System Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemRequiredRole_SystemRequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected SystemRequiredRole systemRequiredRole_SystemRequiredDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getAssemblyContext_SystemRequiredDelegationConnector() <em>Assembly Context System Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_SystemRequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_SystemRequiredDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getRequiredRole_SystemRequiredDelegationConnector() <em>Required Role System Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRole_SystemRequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected RequiredRole requiredRole_SystemRequiredDelegationConnector = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemRequiredDelegationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM_REQUIRED_DELEGATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemRequiredRole getSystemRequiredRole_SystemRequiredDelegationConnector() {
		if (systemRequiredRole_SystemRequiredDelegationConnector != null && systemRequiredRole_SystemRequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldSystemRequiredRole_SystemRequiredDelegationConnector = (InternalEObject)systemRequiredRole_SystemRequiredDelegationConnector;
			systemRequiredRole_SystemRequiredDelegationConnector = (SystemRequiredRole)eResolveProxy(oldSystemRequiredRole_SystemRequiredDelegationConnector);
			if (systemRequiredRole_SystemRequiredDelegationConnector != oldSystemRequiredRole_SystemRequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR, oldSystemRequiredRole_SystemRequiredDelegationConnector, systemRequiredRole_SystemRequiredDelegationConnector));
			}
		}
		return systemRequiredRole_SystemRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemRequiredRole basicGetSystemRequiredRole_SystemRequiredDelegationConnector() {
		return systemRequiredRole_SystemRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystemRequiredRole_SystemRequiredDelegationConnector(SystemRequiredRole newSystemRequiredRole_SystemRequiredDelegationConnector, NotificationChain msgs) {
		SystemRequiredRole oldSystemRequiredRole_SystemRequiredDelegationConnector = systemRequiredRole_SystemRequiredDelegationConnector;
		systemRequiredRole_SystemRequiredDelegationConnector = newSystemRequiredRole_SystemRequiredDelegationConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR, oldSystemRequiredRole_SystemRequiredDelegationConnector, newSystemRequiredRole_SystemRequiredDelegationConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemRequiredRole_SystemRequiredDelegationConnector(SystemRequiredRole newSystemRequiredRole_SystemRequiredDelegationConnector) {
		if (newSystemRequiredRole_SystemRequiredDelegationConnector != systemRequiredRole_SystemRequiredDelegationConnector) {
			NotificationChain msgs = null;
			if (systemRequiredRole_SystemRequiredDelegationConnector != null)
				msgs = ((InternalEObject)systemRequiredRole_SystemRequiredDelegationConnector).eInverseRemove(this, SystemPackage.SYSTEM_REQUIRED_ROLE__REQUIRED_DELEGATION_CONNECTOR_SYSTEM_REQUIRED_ROLE, SystemRequiredRole.class, msgs);
			if (newSystemRequiredRole_SystemRequiredDelegationConnector != null)
				msgs = ((InternalEObject)newSystemRequiredRole_SystemRequiredDelegationConnector).eInverseAdd(this, SystemPackage.SYSTEM_REQUIRED_ROLE__REQUIRED_DELEGATION_CONNECTOR_SYSTEM_REQUIRED_ROLE, SystemRequiredRole.class, msgs);
			msgs = basicSetSystemRequiredRole_SystemRequiredDelegationConnector(newSystemRequiredRole_SystemRequiredDelegationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR, newSystemRequiredRole_SystemRequiredDelegationConnector, newSystemRequiredRole_SystemRequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_SystemRequiredDelegationConnector() {
		if (assemblyContext_SystemRequiredDelegationConnector != null && assemblyContext_SystemRequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldAssemblyContext_SystemRequiredDelegationConnector = (InternalEObject)assemblyContext_SystemRequiredDelegationConnector;
			assemblyContext_SystemRequiredDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext_SystemRequiredDelegationConnector);
			if (assemblyContext_SystemRequiredDelegationConnector != oldAssemblyContext_SystemRequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR, oldAssemblyContext_SystemRequiredDelegationConnector, assemblyContext_SystemRequiredDelegationConnector));
			}
		}
		return assemblyContext_SystemRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_SystemRequiredDelegationConnector() {
		return assemblyContext_SystemRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_SystemRequiredDelegationConnector(AssemblyContext newAssemblyContext_SystemRequiredDelegationConnector) {
		AssemblyContext oldAssemblyContext_SystemRequiredDelegationConnector = assemblyContext_SystemRequiredDelegationConnector;
		assemblyContext_SystemRequiredDelegationConnector = newAssemblyContext_SystemRequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR, oldAssemblyContext_SystemRequiredDelegationConnector, assemblyContext_SystemRequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole getRequiredRole_SystemRequiredDelegationConnector() {
		if (requiredRole_SystemRequiredDelegationConnector != null && requiredRole_SystemRequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldRequiredRole_SystemRequiredDelegationConnector = (InternalEObject)requiredRole_SystemRequiredDelegationConnector;
			requiredRole_SystemRequiredDelegationConnector = (RequiredRole)eResolveProxy(oldRequiredRole_SystemRequiredDelegationConnector);
			if (requiredRole_SystemRequiredDelegationConnector != oldRequiredRole_SystemRequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR, oldRequiredRole_SystemRequiredDelegationConnector, requiredRole_SystemRequiredDelegationConnector));
			}
		}
		return requiredRole_SystemRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole basicGetRequiredRole_SystemRequiredDelegationConnector() {
		return requiredRole_SystemRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredRole_SystemRequiredDelegationConnector(RequiredRole newRequiredRole_SystemRequiredDelegationConnector) {
		RequiredRole oldRequiredRole_SystemRequiredDelegationConnector = requiredRole_SystemRequiredDelegationConnector;
		requiredRole_SystemRequiredDelegationConnector = newRequiredRole_SystemRequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR, oldRequiredRole_SystemRequiredDelegationConnector, requiredRole_SystemRequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				if (systemRequiredRole_SystemRequiredDelegationConnector != null)
					msgs = ((InternalEObject)systemRequiredRole_SystemRequiredDelegationConnector).eInverseRemove(this, SystemPackage.SYSTEM_REQUIRED_ROLE__REQUIRED_DELEGATION_CONNECTOR_SYSTEM_REQUIRED_ROLE, SystemRequiredRole.class, msgs);
				return basicSetSystemRequiredRole_SystemRequiredDelegationConnector((SystemRequiredRole)otherEnd, msgs);
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
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				return basicSetSystemRequiredRole_SystemRequiredDelegationConnector(null, msgs);
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
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getSystemRequiredRole_SystemRequiredDelegationConnector();
				return basicGetSystemRequiredRole_SystemRequiredDelegationConnector();
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getAssemblyContext_SystemRequiredDelegationConnector();
				return basicGetAssemblyContext_SystemRequiredDelegationConnector();
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getRequiredRole_SystemRequiredDelegationConnector();
				return basicGetRequiredRole_SystemRequiredDelegationConnector();
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
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				setSystemRequiredRole_SystemRequiredDelegationConnector((SystemRequiredRole)newValue);
				return;
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				setAssemblyContext_SystemRequiredDelegationConnector((AssemblyContext)newValue);
				return;
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				setRequiredRole_SystemRequiredDelegationConnector((RequiredRole)newValue);
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
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				setSystemRequiredRole_SystemRequiredDelegationConnector((SystemRequiredRole)null);
				return;
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				setAssemblyContext_SystemRequiredDelegationConnector((AssemblyContext)null);
				return;
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				setRequiredRole_SystemRequiredDelegationConnector((RequiredRole)null);
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
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				return systemRequiredRole_SystemRequiredDelegationConnector != null;
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				return assemblyContext_SystemRequiredDelegationConnector != null;
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR:
				return requiredRole_SystemRequiredDelegationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemRequiredDelegationConnectorImpl