/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerAllocationConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controller Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerInstanceImpl#getUpperControllerAllocationConnectors_ControllerInstance <em>Upper Controller Allocation Connectors Controller Instance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerInstanceImpl#getControllerLayer_ControllerInstance <em>Controller Layer Controller Instance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerInstanceImpl#getLowerControllerAllocationConnectors_ControllerInstance <em>Lower Controller Allocation Connectors Controller Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControllerInstanceImpl extends EObjectImpl implements ControllerInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getUpperControllerAllocationConnectors_ControllerInstance() <em>Upper Controller Allocation Connectors Controller Instance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperControllerAllocationConnectors_ControllerInstance()
	 * @generated
	 * @ordered
	 */
	protected EList<ControllerAllocationConnector> upperControllerAllocationConnectors_ControllerInstance;

	/**
	 * The cached value of the '{@link #getControllerLayer_ControllerInstance() <em>Controller Layer Controller Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerLayer_ControllerInstance()
	 * @generated
	 * @ordered
	 */
	protected ControllerLayer controllerLayer_ControllerInstance;

	/**
	 * The cached value of the '{@link #getLowerControllerAllocationConnectors_ControllerInstance() <em>Lower Controller Allocation Connectors Controller Instance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerControllerAllocationConnectors_ControllerInstance()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceProvidedRoleConnector> lowerControllerAllocationConnectors_ControllerInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControllerInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.CONTROLLER_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer getControllerLayer_ControllerInstance() {
		if (controllerLayer_ControllerInstance != null && controllerLayer_ControllerInstance.eIsProxy()) {
			InternalEObject oldControllerLayer_ControllerInstance = (InternalEObject)controllerLayer_ControllerInstance;
			controllerLayer_ControllerInstance = (ControllerLayer)eResolveProxy(oldControllerLayer_ControllerInstance);
			if (controllerLayer_ControllerInstance != oldControllerLayer_ControllerInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_LAYER_CONTROLLER_INSTANCE, oldControllerLayer_ControllerInstance, controllerLayer_ControllerInstance));
			}
		}
		return controllerLayer_ControllerInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer basicGetControllerLayer_ControllerInstance() {
		return controllerLayer_ControllerInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerLayer_ControllerInstance(ControllerLayer newControllerLayer_ControllerInstance) {
		ControllerLayer oldControllerLayer_ControllerInstance = controllerLayer_ControllerInstance;
		controllerLayer_ControllerInstance = newControllerLayer_ControllerInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_LAYER_CONTROLLER_INSTANCE, oldControllerLayer_ControllerInstance, controllerLayer_ControllerInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControllerAllocationConnector> getUpperControllerAllocationConnectors_ControllerInstance() {
		if (upperControllerAllocationConnectors_ControllerInstance == null) {
			upperControllerAllocationConnectors_ControllerInstance = new EObjectWithInverseResolvingEList<ControllerAllocationConnector>(ControllerAllocationConnector.class, this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, ResourceenvironmentPackage.CONTROLLER_ALLOCATION_CONNECTOR__TO_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR);
		}
		return upperControllerAllocationConnectors_ControllerInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceProvidedRoleConnector> getLowerControllerAllocationConnectors_ControllerInstance() {
		if (lowerControllerAllocationConnectors_ControllerInstance == null) {
			lowerControllerAllocationConnectors_ControllerInstance = new EObjectWithInverseResolvingEList<ResourceProvidedRoleConnector>(ResourceProvidedRoleConnector.class, this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR);
		}
		return lowerControllerAllocationConnectors_ControllerInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUpperControllerAllocationConnectors_ControllerInstance()).basicAdd(otherEnd, msgs);
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLowerControllerAllocationConnectors_ControllerInstance()).basicAdd(otherEnd, msgs);
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return ((InternalEList<?>)getUpperControllerAllocationConnectors_ControllerInstance()).basicRemove(otherEnd, msgs);
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return ((InternalEList<?>)getLowerControllerAllocationConnectors_ControllerInstance()).basicRemove(otherEnd, msgs);
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return getUpperControllerAllocationConnectors_ControllerInstance();
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_LAYER_CONTROLLER_INSTANCE:
				if (resolve) return getControllerLayer_ControllerInstance();
				return basicGetControllerLayer_ControllerInstance();
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return getLowerControllerAllocationConnectors_ControllerInstance();
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getUpperControllerAllocationConnectors_ControllerInstance().clear();
				getUpperControllerAllocationConnectors_ControllerInstance().addAll((Collection<? extends ControllerAllocationConnector>)newValue);
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_LAYER_CONTROLLER_INSTANCE:
				setControllerLayer_ControllerInstance((ControllerLayer)newValue);
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getLowerControllerAllocationConnectors_ControllerInstance().clear();
				getLowerControllerAllocationConnectors_ControllerInstance().addAll((Collection<? extends ResourceProvidedRoleConnector>)newValue);
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getUpperControllerAllocationConnectors_ControllerInstance().clear();
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_LAYER_CONTROLLER_INSTANCE:
				setControllerLayer_ControllerInstance((ControllerLayer)null);
				return;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				getLowerControllerAllocationConnectors_ControllerInstance().clear();
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
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__UPPER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return upperControllerAllocationConnectors_ControllerInstance != null && !upperControllerAllocationConnectors_ControllerInstance.isEmpty();
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__CONTROLLER_LAYER_CONTROLLER_INSTANCE:
				return controllerLayer_ControllerInstance != null;
			case ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE:
				return lowerControllerAllocationConnectors_ControllerInstance != null && !lowerControllerAllocationConnectors_ControllerInstance.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ControllerInstanceImpl
