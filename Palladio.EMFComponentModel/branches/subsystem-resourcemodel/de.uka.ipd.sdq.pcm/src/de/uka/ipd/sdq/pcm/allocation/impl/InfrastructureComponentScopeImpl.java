/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Component Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl#getAssemblyContext_InfrastructureComponentScope <em>Assembly Context Infrastructure Component Scope</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl#getLowerLayer <em>Lower Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl#getUpperLayer <em>Upper Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureComponentScopeImpl extends EObjectImpl implements InfrastructureComponentScope {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getAssemblyContext_InfrastructureComponentScope() <em>Assembly Context Infrastructure Component Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_InfrastructureComponentScope()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_InfrastructureComponentScope;

	/**
	 * The cached value of the '{@link #getLowerLayer() <em>Lower Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerLayer()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureComponentScope lowerLayer;

	/**
	 * The cached value of the '{@link #getUpperLayer() <em>Upper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperLayer()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureComponentScope upperLayer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureComponentScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.INFRASTRUCTURE_COMPONENT_SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_InfrastructureComponentScope() {
		if (assemblyContext_InfrastructureComponentScope != null && assemblyContext_InfrastructureComponentScope.eIsProxy()) {
			InternalEObject oldAssemblyContext_InfrastructureComponentScope = (InternalEObject)assemblyContext_InfrastructureComponentScope;
			assemblyContext_InfrastructureComponentScope = (AssemblyContext)eResolveProxy(oldAssemblyContext_InfrastructureComponentScope);
			if (assemblyContext_InfrastructureComponentScope != oldAssemblyContext_InfrastructureComponentScope) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE, oldAssemblyContext_InfrastructureComponentScope, assemblyContext_InfrastructureComponentScope));
			}
		}
		return assemblyContext_InfrastructureComponentScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_InfrastructureComponentScope() {
		return assemblyContext_InfrastructureComponentScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_InfrastructureComponentScope(AssemblyContext newAssemblyContext_InfrastructureComponentScope) {
		AssemblyContext oldAssemblyContext_InfrastructureComponentScope = assemblyContext_InfrastructureComponentScope;
		assemblyContext_InfrastructureComponentScope = newAssemblyContext_InfrastructureComponentScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE, oldAssemblyContext_InfrastructureComponentScope, assemblyContext_InfrastructureComponentScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope getLowerLayer() {
		if (lowerLayer != null && lowerLayer.eIsProxy()) {
			InternalEObject oldLowerLayer = (InternalEObject)lowerLayer;
			lowerLayer = (InfrastructureComponentScope)eResolveProxy(oldLowerLayer);
			if (lowerLayer != oldLowerLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, oldLowerLayer, lowerLayer));
			}
		}
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope basicGetLowerLayer() {
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLowerLayer(InfrastructureComponentScope newLowerLayer, NotificationChain msgs) {
		InfrastructureComponentScope oldLowerLayer = lowerLayer;
		lowerLayer = newLowerLayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, oldLowerLayer, newLowerLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerLayer(InfrastructureComponentScope newLowerLayer) {
		if (newLowerLayer != lowerLayer) {
			NotificationChain msgs = null;
			if (lowerLayer != null)
				msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, InfrastructureComponentScope.class, msgs);
			if (newLowerLayer != null)
				msgs = ((InternalEObject)newLowerLayer).eInverseAdd(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, InfrastructureComponentScope.class, msgs);
			msgs = basicSetLowerLayer(newLowerLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, newLowerLayer, newLowerLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope getUpperLayer() {
		if (upperLayer != null && upperLayer.eIsProxy()) {
			InternalEObject oldUpperLayer = (InternalEObject)upperLayer;
			upperLayer = (InfrastructureComponentScope)eResolveProxy(oldUpperLayer);
			if (upperLayer != oldUpperLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, oldUpperLayer, upperLayer));
			}
		}
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope basicGetUpperLayer() {
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperLayer(InfrastructureComponentScope newUpperLayer, NotificationChain msgs) {
		InfrastructureComponentScope oldUpperLayer = upperLayer;
		upperLayer = newUpperLayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, oldUpperLayer, newUpperLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperLayer(InfrastructureComponentScope newUpperLayer) {
		if (newUpperLayer != upperLayer) {
			NotificationChain msgs = null;
			if (upperLayer != null)
				msgs = ((InternalEObject)upperLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, InfrastructureComponentScope.class, msgs);
			if (newUpperLayer != null)
				msgs = ((InternalEObject)newUpperLayer).eInverseAdd(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, InfrastructureComponentScope.class, msgs);
			msgs = basicSetUpperLayer(newUpperLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, newUpperLayer, newUpperLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				if (lowerLayer != null)
					msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, InfrastructureComponentScope.class, msgs);
				return basicSetLowerLayer((InfrastructureComponentScope)otherEnd, msgs);
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				if (upperLayer != null)
					msgs = ((InternalEObject)upperLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, InfrastructureComponentScope.class, msgs);
				return basicSetUpperLayer((InfrastructureComponentScope)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				return basicSetLowerLayer(null, msgs);
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				return basicSetUpperLayer(null, msgs);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE:
				if (resolve) return getAssemblyContext_InfrastructureComponentScope();
				return basicGetAssemblyContext_InfrastructureComponentScope();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				if (resolve) return getLowerLayer();
				return basicGetLowerLayer();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				if (resolve) return getUpperLayer();
				return basicGetUpperLayer();
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE:
				setAssemblyContext_InfrastructureComponentScope((AssemblyContext)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				setLowerLayer((InfrastructureComponentScope)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				setUpperLayer((InfrastructureComponentScope)newValue);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE:
				setAssemblyContext_InfrastructureComponentScope((AssemblyContext)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				setLowerLayer((InfrastructureComponentScope)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				setUpperLayer((InfrastructureComponentScope)null);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE:
				return assemblyContext_InfrastructureComponentScope != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				return lowerLayer != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				return upperLayer != null;
		}
		return super.eIsSet(featureID);
	}

} //InfrastructureComponentScopeImpl
