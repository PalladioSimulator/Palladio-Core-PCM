
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getReferencedAssemblyContext_AllocationContext <em>Referenced Assembly Context Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getResourceContainer_AllocationContext <em>Resource Container Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationContextImpl extends EObjectImpl implements AllocationContext {
	/**
	 * The cached value of the '{@link #getReferencedAssemblyContext_AllocationContext() <em>Referenced Assembly Context Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedAssemblyContext_AllocationContext()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext referencedAssemblyContext_AllocationContext = null;

	/**
	 * The cached value of the '{@link #getResourceContainer_AllocationContext() <em>Resource Container Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceContainer_AllocationContext()
	 * @generated
	 * @ordered
	 */
	protected ResourceContainer resourceContainer_AllocationContext = null;


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
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.ALLOCATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getReferencedAssemblyContext_AllocationContext() {
		if (referencedAssemblyContext_AllocationContext != null && referencedAssemblyContext_AllocationContext.eIsProxy()) {
			InternalEObject oldReferencedAssemblyContext_AllocationContext = (InternalEObject)referencedAssemblyContext_AllocationContext;
			referencedAssemblyContext_AllocationContext = (AssemblyContext)eResolveProxy(oldReferencedAssemblyContext_AllocationContext);
			if (referencedAssemblyContext_AllocationContext != oldReferencedAssemblyContext_AllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONTEXT__REFERENCED_ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT, oldReferencedAssemblyContext_AllocationContext, referencedAssemblyContext_AllocationContext));
			}
		}
		return referencedAssemblyContext_AllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetReferencedAssemblyContext_AllocationContext() {
		return referencedAssemblyContext_AllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedAssemblyContext_AllocationContext(AssemblyContext newReferencedAssemblyContext_AllocationContext) {
		AssemblyContext oldReferencedAssemblyContext_AllocationContext = referencedAssemblyContext_AllocationContext;
		referencedAssemblyContext_AllocationContext = newReferencedAssemblyContext_AllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONTEXT__REFERENCED_ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT, oldReferencedAssemblyContext_AllocationContext, referencedAssemblyContext_AllocationContext));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.ALLOCATION_CONTEXT__REFERENCED_ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				if (resolve) return getReferencedAssemblyContext_AllocationContext();
				return basicGetReferencedAssemblyContext_AllocationContext();
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				if (resolve) return getResourceContainer_AllocationContext();
				return basicGetResourceContainer_AllocationContext();
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
			case AllocationPackage.ALLOCATION_CONTEXT__REFERENCED_ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				setReferencedAssemblyContext_AllocationContext((AssemblyContext)newValue);
				return;
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				setResourceContainer_AllocationContext((ResourceContainer)newValue);
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
			case AllocationPackage.ALLOCATION_CONTEXT__REFERENCED_ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				setReferencedAssemblyContext_AllocationContext((AssemblyContext)null);
				return;
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				setResourceContainer_AllocationContext((ResourceContainer)null);
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
			case AllocationPackage.ALLOCATION_CONTEXT__REFERENCED_ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
				return referencedAssemblyContext_AllocationContext != null;
			case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
				return resourceContainer_AllocationContext != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationContextImpl