
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.repository.ChildComponentContext;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Component Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ChildComponentContextImpl#getEncapsulatedComponent_ChildComponentContext <em>Encapsulated Component Child Component Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildComponentContextImpl extends EntityImpl implements ChildComponentContext {
	/**
	 * The cached value of the '{@link #getEncapsulatedComponent_ChildComponentContext() <em>Encapsulated Component Child Component Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncapsulatedComponent_ChildComponentContext()
	 * @generated
	 * @ordered
	 */
	protected ProvidesComponentType encapsulatedComponent_ChildComponentContext = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildComponentContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.CHILD_COMPONENT_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesComponentType getEncapsulatedComponent_ChildComponentContext() {
		if (encapsulatedComponent_ChildComponentContext != null && encapsulatedComponent_ChildComponentContext.eIsProxy()) {
			InternalEObject oldEncapsulatedComponent_ChildComponentContext = (InternalEObject)encapsulatedComponent_ChildComponentContext;
			encapsulatedComponent_ChildComponentContext = (ProvidesComponentType)eResolveProxy(oldEncapsulatedComponent_ChildComponentContext);
			if (encapsulatedComponent_ChildComponentContext != oldEncapsulatedComponent_ChildComponentContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CHILD_COMPONENT_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT, oldEncapsulatedComponent_ChildComponentContext, encapsulatedComponent_ChildComponentContext));
			}
		}
		return encapsulatedComponent_ChildComponentContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesComponentType basicGetEncapsulatedComponent_ChildComponentContext() {
		return encapsulatedComponent_ChildComponentContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncapsulatedComponent_ChildComponentContext(ProvidesComponentType newEncapsulatedComponent_ChildComponentContext) {
		ProvidesComponentType oldEncapsulatedComponent_ChildComponentContext = encapsulatedComponent_ChildComponentContext;
		encapsulatedComponent_ChildComponentContext = newEncapsulatedComponent_ChildComponentContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_COMPONENT_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT, oldEncapsulatedComponent_ChildComponentContext, encapsulatedComponent_ChildComponentContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.CHILD_COMPONENT_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT:
				if (resolve) return getEncapsulatedComponent_ChildComponentContext();
				return basicGetEncapsulatedComponent_ChildComponentContext();
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
			case RepositoryPackage.CHILD_COMPONENT_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT:
				setEncapsulatedComponent_ChildComponentContext((ProvidesComponentType)newValue);
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
			case RepositoryPackage.CHILD_COMPONENT_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT:
				setEncapsulatedComponent_ChildComponentContext((ProvidesComponentType)null);
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
			case RepositoryPackage.CHILD_COMPONENT_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT:
				return encapsulatedComponent_ChildComponentContext != null;
		}
		return super.eIsSet(featureID);
	}

} //ChildComponentContextImpl