/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controller Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl#getUpperLayer <em>Upper Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl#getLowerLayer <em>Lower Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl#getControllerType_ControllerScope <em>Controller Type Controller Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControllerLayerImpl extends EObjectImpl implements ControllerLayer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getUpperLayer() <em>Upper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperLayer()
	 * @generated
	 * @ordered
	 */
	protected ControllerLayer upperLayer;

	/**
	 * The cached value of the '{@link #getLowerLayer() <em>Lower Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerLayer()
	 * @generated
	 * @ordered
	 */
	protected ControllerLayer lowerLayer;

	/**
	 * The cached value of the '{@link #getControllerType_ControllerScope() <em>Controller Type Controller Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerType_ControllerScope()
	 * @generated
	 * @ordered
	 */
	protected ControllerType controllerType_ControllerScope;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControllerLayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.CONTROLLER_LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer getUpperLayer() {
		if (upperLayer != null && upperLayer.eIsProxy()) {
			InternalEObject oldUpperLayer = (InternalEObject)upperLayer;
			upperLayer = (ControllerLayer)eResolveProxy(oldUpperLayer);
			if (upperLayer != oldUpperLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, oldUpperLayer, upperLayer));
			}
		}
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer basicGetUpperLayer() {
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperLayer(ControllerLayer newUpperLayer, NotificationChain msgs) {
		ControllerLayer oldUpperLayer = upperLayer;
		upperLayer = newUpperLayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, oldUpperLayer, newUpperLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperLayer(ControllerLayer newUpperLayer) {
		if (newUpperLayer != upperLayer) {
			NotificationChain msgs = null;
			if (upperLayer != null)
				msgs = ((InternalEObject)upperLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, ControllerLayer.class, msgs);
			if (newUpperLayer != null)
				msgs = ((InternalEObject)newUpperLayer).eInverseAdd(this, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, ControllerLayer.class, msgs);
			msgs = basicSetUpperLayer(newUpperLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, newUpperLayer, newUpperLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer getLowerLayer() {
		if (lowerLayer != null && lowerLayer.eIsProxy()) {
			InternalEObject oldLowerLayer = (InternalEObject)lowerLayer;
			lowerLayer = (ControllerLayer)eResolveProxy(oldLowerLayer);
			if (lowerLayer != oldLowerLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, oldLowerLayer, lowerLayer));
			}
		}
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer basicGetLowerLayer() {
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLowerLayer(ControllerLayer newLowerLayer, NotificationChain msgs) {
		ControllerLayer oldLowerLayer = lowerLayer;
		lowerLayer = newLowerLayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, oldLowerLayer, newLowerLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerLayer(ControllerLayer newLowerLayer) {
		if (newLowerLayer != lowerLayer) {
			NotificationChain msgs = null;
			if (lowerLayer != null)
				msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, ControllerLayer.class, msgs);
			if (newLowerLayer != null)
				msgs = ((InternalEObject)newLowerLayer).eInverseAdd(this, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, ControllerLayer.class, msgs);
			msgs = basicSetLowerLayer(newLowerLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, newLowerLayer, newLowerLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerType getControllerType_ControllerScope() {
		if (controllerType_ControllerScope != null && controllerType_ControllerScope.eIsProxy()) {
			InternalEObject oldControllerType_ControllerScope = (InternalEObject)controllerType_ControllerScope;
			controllerType_ControllerScope = (ControllerType)eResolveProxy(oldControllerType_ControllerScope);
			if (controllerType_ControllerScope != oldControllerType_ControllerScope) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE, oldControllerType_ControllerScope, controllerType_ControllerScope));
			}
		}
		return controllerType_ControllerScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerType basicGetControllerType_ControllerScope() {
		return controllerType_ControllerScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerType_ControllerScope(ControllerType newControllerType_ControllerScope) {
		ControllerType oldControllerType_ControllerScope = controllerType_ControllerScope;
		controllerType_ControllerScope = newControllerType_ControllerScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE, oldControllerType_ControllerScope, controllerType_ControllerScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				if (upperLayer != null)
					msgs = ((InternalEObject)upperLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, ControllerLayer.class, msgs);
				return basicSetUpperLayer((ControllerLayer)otherEnd, msgs);
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				if (lowerLayer != null)
					msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, ControllerLayer.class, msgs);
				return basicSetLowerLayer((ControllerLayer)otherEnd, msgs);
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				return basicSetUpperLayer(null, msgs);
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				return basicSetLowerLayer(null, msgs);
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				if (resolve) return getUpperLayer();
				return basicGetUpperLayer();
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				if (resolve) return getLowerLayer();
				return basicGetLowerLayer();
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE:
				if (resolve) return getControllerType_ControllerScope();
				return basicGetControllerType_ControllerScope();
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				setUpperLayer((ControllerLayer)newValue);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				setLowerLayer((ControllerLayer)newValue);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE:
				setControllerType_ControllerScope((ControllerType)newValue);
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				setUpperLayer((ControllerLayer)null);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				setLowerLayer((ControllerLayer)null);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE:
				setControllerType_ControllerScope((ControllerType)null);
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				return upperLayer != null;
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				return lowerLayer != null;
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE:
				return controllerType_ControllerScope != null;
		}
		return super.eIsSet(featureID);
	}

} //ControllerLayerImpl
