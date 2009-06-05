
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getResourceContainer_AllocationContext <em>Resource Container Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getAssemblyContext_AllocationContext <em>Assembly Context Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationContextImpl extends EntityImpl implements AllocationContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceContainer_AllocationContext() <em>Resource Container Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceContainer_AllocationContext()
	 * @generated
	 * @ordered
	 */
	protected ResourceContainer resourceContainer_AllocationContext;

	/**
	 * The cached value of the '{@link #getAssemblyContext_AllocationContext() <em>Assembly Context Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_AllocationContext()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_AllocationContext;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.ALLOCATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer getResourceContainer_AllocationContext() {
		if (resourceContainer_AllocationContext != null && resourceContainer_AllocationContext.eIsProxy()) {
			InternalEObject oldResourceContainer_AllocationContext = (InternalEObject)resourceContainer_AllocationContext;
			resourceContainer_AllocationContext = (ResourceContainer)eResolveProxy(oldResourceContainer_AllocationContext);
			if (resourceContainer_AllocationContext != oldResourceContainer_AllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT, oldResourceContainer_AllocationContext, resourceContainer_AllocationContext));
			}
		}
		return resourceContainer_AllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourceContainer_AllocationContext() {
		return resourceContainer_AllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceContainer_AllocationContext(ResourceContainer newResourceContainer_AllocationContext) {
		ResourceContainer oldResourceContainer_AllocationContext = resourceContainer_AllocationContext;
		resourceContainer_AllocationContext = newResourceContainer_AllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT, oldResourceContainer_AllocationContext, resourceContainer_AllocationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_AllocationContext() {
		if (assemblyContext_AllocationContext != null && assemblyContext_AllocationContext.eIsProxy()) {
			InternalEObject oldAssemblyContext_AllocationContext = (InternalEObject)assemblyContext_AllocationContext;
			assemblyContext_AllocationContext = (AssemblyContext)eResolveProxy(oldAssemblyContext_AllocationContext);
			if (assemblyContext_AllocationContext != oldAssemblyContext_AllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT, oldAssemblyContext_AllocationContext, assemblyContext_AllocationContext));
			}
		}
		return assemblyContext_AllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_AllocationContext() {
		return assemblyContext_AllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_AllocationContext(AssemblyContext newAssemblyContext_AllocationContext) {
		AssemblyContext oldAssemblyContext_AllocationContext = assemblyContext_AllocationContext;
		assemblyContext_AllocationContext = newAssemblyContext_AllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT, oldAssemblyContext_AllocationContext, assemblyContext_AllocationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				if (resolve) return getResourceContainer_AllocationContext();
				return basicGetResourceContainer_AllocationContext();
			case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				if (resolve) return getAssemblyContext_AllocationContext();
				return basicGetAssemblyContext_AllocationContext();
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
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				setResourceContainer_AllocationContext((ResourceContainer)newValue);
				return;
			case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				setAssemblyContext_AllocationContext((AssemblyContext)newValue);
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
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				setResourceContainer_AllocationContext((ResourceContainer)null);
				return;
			case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				setAssemblyContext_AllocationContext((AssemblyContext)null);
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
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				return resourceContainer_AllocationContext != null;
			case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				return assemblyContext_AllocationContext != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationContextImpl
