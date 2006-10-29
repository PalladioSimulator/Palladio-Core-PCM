
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedDelegationConnectorImpl#getSystemProvidedRole_SystemProvidedDelegationConnector <em>System Provided Role System Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedDelegationConnectorImpl#getAssemblyContext_SystemProvidedDelegationConnector <em>Assembly Context System Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedDelegationConnectorImpl#getComponentProvidedRole_SystemProvidedDelegationConnector <em>Component Provided Role System Provided Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemProvidedDelegationConnectorImpl extends EObjectImpl implements SystemProvidedDelegationConnector {
	/**
	 * The cached value of the '{@link #getSystemProvidedRole_SystemProvidedDelegationConnector() <em>System Provided Role System Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemProvidedRole_SystemProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected SystemProvidedRole systemProvidedRole_SystemProvidedDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getAssemblyContext_SystemProvidedDelegationConnector() <em>Assembly Context System Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_SystemProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_SystemProvidedDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getComponentProvidedRole_SystemProvidedDelegationConnector() <em>Component Provided Role System Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentProvidedRole_SystemProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole componentProvidedRole_SystemProvidedDelegationConnector = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemProvidedDelegationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM_PROVIDED_DELEGATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProvidedRole getSystemProvidedRole_SystemProvidedDelegationConnector() {
		if (systemProvidedRole_SystemProvidedDelegationConnector != null && systemProvidedRole_SystemProvidedDelegationConnector.eIsProxy()) {
			InternalEObject oldSystemProvidedRole_SystemProvidedDelegationConnector = (InternalEObject)systemProvidedRole_SystemProvidedDelegationConnector;
			systemProvidedRole_SystemProvidedDelegationConnector = (SystemProvidedRole)eResolveProxy(oldSystemProvidedRole_SystemProvidedDelegationConnector);
			if (systemProvidedRole_SystemProvidedDelegationConnector != oldSystemProvidedRole_SystemProvidedDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, oldSystemProvidedRole_SystemProvidedDelegationConnector, systemProvidedRole_SystemProvidedDelegationConnector));
			}
		}
		return systemProvidedRole_SystemProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProvidedRole basicGetSystemProvidedRole_SystemProvidedDelegationConnector() {
		return systemProvidedRole_SystemProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystemProvidedRole_SystemProvidedDelegationConnector(SystemProvidedRole newSystemProvidedRole_SystemProvidedDelegationConnector, NotificationChain msgs) {
		SystemProvidedRole oldSystemProvidedRole_SystemProvidedDelegationConnector = systemProvidedRole_SystemProvidedDelegationConnector;
		systemProvidedRole_SystemProvidedDelegationConnector = newSystemProvidedRole_SystemProvidedDelegationConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, oldSystemProvidedRole_SystemProvidedDelegationConnector, newSystemProvidedRole_SystemProvidedDelegationConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemProvidedRole_SystemProvidedDelegationConnector(SystemProvidedRole newSystemProvidedRole_SystemProvidedDelegationConnector) {
		if (newSystemProvidedRole_SystemProvidedDelegationConnector != systemProvidedRole_SystemProvidedDelegationConnector) {
			NotificationChain msgs = null;
			if (systemProvidedRole_SystemProvidedDelegationConnector != null)
				msgs = ((InternalEObject)systemProvidedRole_SystemProvidedDelegationConnector).eInverseRemove(this, SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE, SystemProvidedRole.class, msgs);
			if (newSystemProvidedRole_SystemProvidedDelegationConnector != null)
				msgs = ((InternalEObject)newSystemProvidedRole_SystemProvidedDelegationConnector).eInverseAdd(this, SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE, SystemProvidedRole.class, msgs);
			msgs = basicSetSystemProvidedRole_SystemProvidedDelegationConnector(newSystemProvidedRole_SystemProvidedDelegationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, newSystemProvidedRole_SystemProvidedDelegationConnector, newSystemProvidedRole_SystemProvidedDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_SystemProvidedDelegationConnector() {
		if (assemblyContext_SystemProvidedDelegationConnector != null && assemblyContext_SystemProvidedDelegationConnector.eIsProxy()) {
			InternalEObject oldAssemblyContext_SystemProvidedDelegationConnector = (InternalEObject)assemblyContext_SystemProvidedDelegationConnector;
			assemblyContext_SystemProvidedDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext_SystemProvidedDelegationConnector);
			if (assemblyContext_SystemProvidedDelegationConnector != oldAssemblyContext_SystemProvidedDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, oldAssemblyContext_SystemProvidedDelegationConnector, assemblyContext_SystemProvidedDelegationConnector));
			}
		}
		return assemblyContext_SystemProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_SystemProvidedDelegationConnector() {
		return assemblyContext_SystemProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_SystemProvidedDelegationConnector(AssemblyContext newAssemblyContext_SystemProvidedDelegationConnector) {
		AssemblyContext oldAssemblyContext_SystemProvidedDelegationConnector = assemblyContext_SystemProvidedDelegationConnector;
		assemblyContext_SystemProvidedDelegationConnector = newAssemblyContext_SystemProvidedDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, oldAssemblyContext_SystemProvidedDelegationConnector, assemblyContext_SystemProvidedDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole getComponentProvidedRole_SystemProvidedDelegationConnector() {
		if (componentProvidedRole_SystemProvidedDelegationConnector != null && componentProvidedRole_SystemProvidedDelegationConnector.eIsProxy()) {
			InternalEObject oldComponentProvidedRole_SystemProvidedDelegationConnector = (InternalEObject)componentProvidedRole_SystemProvidedDelegationConnector;
			componentProvidedRole_SystemProvidedDelegationConnector = (ProvidedRole)eResolveProxy(oldComponentProvidedRole_SystemProvidedDelegationConnector);
			if (componentProvidedRole_SystemProvidedDelegationConnector != oldComponentProvidedRole_SystemProvidedDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, oldComponentProvidedRole_SystemProvidedDelegationConnector, componentProvidedRole_SystemProvidedDelegationConnector));
			}
		}
		return componentProvidedRole_SystemProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetComponentProvidedRole_SystemProvidedDelegationConnector() {
		return componentProvidedRole_SystemProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentProvidedRole_SystemProvidedDelegationConnector(ProvidedRole newComponentProvidedRole_SystemProvidedDelegationConnector) {
		ProvidedRole oldComponentProvidedRole_SystemProvidedDelegationConnector = componentProvidedRole_SystemProvidedDelegationConnector;
		componentProvidedRole_SystemProvidedDelegationConnector = newComponentProvidedRole_SystemProvidedDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, oldComponentProvidedRole_SystemProvidedDelegationConnector, componentProvidedRole_SystemProvidedDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				if (systemProvidedRole_SystemProvidedDelegationConnector != null)
					msgs = ((InternalEObject)systemProvidedRole_SystemProvidedDelegationConnector).eInverseRemove(this, SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE, SystemProvidedRole.class, msgs);
				return basicSetSystemProvidedRole_SystemProvidedDelegationConnector((SystemProvidedRole)otherEnd, msgs);
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
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				return basicSetSystemProvidedRole_SystemProvidedDelegationConnector(null, msgs);
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
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getSystemProvidedRole_SystemProvidedDelegationConnector();
				return basicGetSystemProvidedRole_SystemProvidedDelegationConnector();
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getAssemblyContext_SystemProvidedDelegationConnector();
				return basicGetAssemblyContext_SystemProvidedDelegationConnector();
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getComponentProvidedRole_SystemProvidedDelegationConnector();
				return basicGetComponentProvidedRole_SystemProvidedDelegationConnector();
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
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				setSystemProvidedRole_SystemProvidedDelegationConnector((SystemProvidedRole)newValue);
				return;
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				setAssemblyContext_SystemProvidedDelegationConnector((AssemblyContext)newValue);
				return;
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				setComponentProvidedRole_SystemProvidedDelegationConnector((ProvidedRole)newValue);
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
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				setSystemProvidedRole_SystemProvidedDelegationConnector((SystemProvidedRole)null);
				return;
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				setAssemblyContext_SystemProvidedDelegationConnector((AssemblyContext)null);
				return;
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				setComponentProvidedRole_SystemProvidedDelegationConnector((ProvidedRole)null);
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
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				return systemProvidedRole_SystemProvidedDelegationConnector != null;
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				return assemblyContext_SystemProvidedDelegationConnector != null;
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR:
				return componentProvidedRole_SystemProvidedDelegationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemProvidedDelegationConnectorImpl