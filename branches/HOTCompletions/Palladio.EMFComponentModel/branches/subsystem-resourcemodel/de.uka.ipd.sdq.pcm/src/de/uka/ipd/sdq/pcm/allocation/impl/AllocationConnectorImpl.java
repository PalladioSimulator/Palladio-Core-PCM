/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl#getResourceRequiredRole_AllocationConnector <em>Resource Required Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl#getFromAssemblyContext_AllocationConnector <em>From Assembly Context Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AllocationConnectorImpl extends EObjectImpl implements AllocationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceRequiredRole_AllocationConnector() <em>Resource Required Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequiredRole_AllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected ResourceRequiredRole resourceRequiredRole_AllocationConnector;
	/**
	 * The cached value of the '{@link #getFromAssemblyContext_AllocationConnector() <em>From Assembly Context Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromAssemblyContext_AllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext fromAssemblyContext_AllocationConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.ALLOCATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getResourceRequiredRole_AllocationConnector() {
		if (resourceRequiredRole_AllocationConnector != null && resourceRequiredRole_AllocationConnector.eIsProxy()) {
			InternalEObject oldResourceRequiredRole_AllocationConnector = (InternalEObject)resourceRequiredRole_AllocationConnector;
			resourceRequiredRole_AllocationConnector = (ResourceRequiredRole)eResolveProxy(oldResourceRequiredRole_AllocationConnector);
			if (resourceRequiredRole_AllocationConnector != oldResourceRequiredRole_AllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR, oldResourceRequiredRole_AllocationConnector, resourceRequiredRole_AllocationConnector));
			}
		}
		return resourceRequiredRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetResourceRequiredRole_AllocationConnector() {
		return resourceRequiredRole_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiredRole_AllocationConnector(ResourceRequiredRole newResourceRequiredRole_AllocationConnector) {
		ResourceRequiredRole oldResourceRequiredRole_AllocationConnector = resourceRequiredRole_AllocationConnector;
		resourceRequiredRole_AllocationConnector = newResourceRequiredRole_AllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR, oldResourceRequiredRole_AllocationConnector, resourceRequiredRole_AllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getFromAssemblyContext_AllocationConnector() {
		if (fromAssemblyContext_AllocationConnector != null && fromAssemblyContext_AllocationConnector.eIsProxy()) {
			InternalEObject oldFromAssemblyContext_AllocationConnector = (InternalEObject)fromAssemblyContext_AllocationConnector;
			fromAssemblyContext_AllocationConnector = (AssemblyContext)eResolveProxy(oldFromAssemblyContext_AllocationConnector);
			if (fromAssemblyContext_AllocationConnector != oldFromAssemblyContext_AllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR, oldFromAssemblyContext_AllocationConnector, fromAssemblyContext_AllocationConnector));
			}
		}
		return fromAssemblyContext_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetFromAssemblyContext_AllocationConnector() {
		return fromAssemblyContext_AllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromAssemblyContext_AllocationConnector(AssemblyContext newFromAssemblyContext_AllocationConnector) {
		AssemblyContext oldFromAssemblyContext_AllocationConnector = fromAssemblyContext_AllocationConnector;
		fromAssemblyContext_AllocationConnector = newFromAssemblyContext_AllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR, oldFromAssemblyContext_AllocationConnector, fromAssemblyContext_AllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				if (resolve) return getResourceRequiredRole_AllocationConnector();
				return basicGetResourceRequiredRole_AllocationConnector();
			case AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				if (resolve) return getFromAssemblyContext_AllocationConnector();
				return basicGetFromAssemblyContext_AllocationConnector();
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
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				setResourceRequiredRole_AllocationConnector((ResourceRequiredRole)newValue);
				return;
			case AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setFromAssemblyContext_AllocationConnector((AssemblyContext)newValue);
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
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				setResourceRequiredRole_AllocationConnector((ResourceRequiredRole)null);
				return;
			case AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				setFromAssemblyContext_AllocationConnector((AssemblyContext)null);
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
			case AllocationPackage.ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR:
				return resourceRequiredRole_AllocationConnector != null;
			case AllocationPackage.ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR:
				return fromAssemblyContext_AllocationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationConnectorImpl
