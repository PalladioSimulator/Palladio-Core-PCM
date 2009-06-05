/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerStack;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

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
 * An implementation of the model object '<em><b>Controller Stack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerStackImpl#getControllerLayers_ControllerStack <em>Controller Layers Controller Stack</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControllerStackImpl extends EObjectImpl implements ControllerStack {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getControllerLayers_ControllerStack() <em>Controller Layers Controller Stack</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerLayers_ControllerStack()
	 * @generated
	 * @ordered
	 */
	protected EList<ControllerLayer> controllerLayers_ControllerStack;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControllerStackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.CONTROLLER_STACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControllerLayer> getControllerLayers_ControllerStack() {
		if (controllerLayers_ControllerStack == null) {
			controllerLayers_ControllerStack = new EObjectContainmentEList<ControllerLayer>(ControllerLayer.class, this, ResourcetypePackage.CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK);
		}
		return controllerLayers_ControllerStack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcetypePackage.CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK:
				return ((InternalEList<?>)getControllerLayers_ControllerStack()).basicRemove(otherEnd, msgs);
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
			case ResourcetypePackage.CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK:
				return getControllerLayers_ControllerStack();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResourcetypePackage.CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK:
				getControllerLayers_ControllerStack().clear();
				getControllerLayers_ControllerStack().addAll((Collection<? extends ControllerLayer>)newValue);
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
			case ResourcetypePackage.CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK:
				getControllerLayers_ControllerStack().clear();
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
			case ResourcetypePackage.CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK:
				return controllerLayers_ControllerStack != null && !controllerLayers_ControllerStack.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ControllerStackImpl
