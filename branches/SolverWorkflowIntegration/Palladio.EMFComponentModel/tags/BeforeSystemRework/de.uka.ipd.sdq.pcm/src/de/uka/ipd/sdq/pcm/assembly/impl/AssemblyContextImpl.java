
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly.impl;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;
import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.impl.AssemblyContextImpl#getEncapsulatedComponent__AssemblyContext <em>Encapsulated Component Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyContextImpl extends EntityImpl implements AssemblyContext {
	/**
	 * The cached value of the '{@link #getEncapsulatedComponent__AssemblyContext() <em>Encapsulated Component Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncapsulatedComponent__AssemblyContext()
	 * @generated
	 * @ordered
	 */
	protected ProvidesComponentType encapsulatedComponent__AssemblyContext = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssemblyContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AssemblyPackage.Literals.ASSEMBLY_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesComponentType getEncapsulatedComponent__AssemblyContext() {
		if (encapsulatedComponent__AssemblyContext != null && encapsulatedComponent__AssemblyContext.eIsProxy()) {
			InternalEObject oldEncapsulatedComponent__AssemblyContext = (InternalEObject)encapsulatedComponent__AssemblyContext;
			encapsulatedComponent__AssemblyContext = (ProvidesComponentType)eResolveProxy(oldEncapsulatedComponent__AssemblyContext);
			if (encapsulatedComponent__AssemblyContext != oldEncapsulatedComponent__AssemblyContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT, oldEncapsulatedComponent__AssemblyContext, encapsulatedComponent__AssemblyContext));
			}
		}
		return encapsulatedComponent__AssemblyContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesComponentType basicGetEncapsulatedComponent__AssemblyContext() {
		return encapsulatedComponent__AssemblyContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncapsulatedComponent__AssemblyContext(ProvidesComponentType newEncapsulatedComponent__AssemblyContext) {
		ProvidesComponentType oldEncapsulatedComponent__AssemblyContext = encapsulatedComponent__AssemblyContext;
		encapsulatedComponent__AssemblyContext = newEncapsulatedComponent__AssemblyContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT, oldEncapsulatedComponent__AssemblyContext, encapsulatedComponent__AssemblyContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AssemblyPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				if (resolve) return getEncapsulatedComponent__AssemblyContext();
				return basicGetEncapsulatedComponent__AssemblyContext();
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
			case AssemblyPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				setEncapsulatedComponent__AssemblyContext((ProvidesComponentType)newValue);
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
			case AssemblyPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				setEncapsulatedComponent__AssemblyContext((ProvidesComponentType)null);
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
			case AssemblyPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				return encapsulatedComponent__AssemblyContext != null;
		}
		return super.eIsSet(featureID);
	}

} //AssemblyContextImpl