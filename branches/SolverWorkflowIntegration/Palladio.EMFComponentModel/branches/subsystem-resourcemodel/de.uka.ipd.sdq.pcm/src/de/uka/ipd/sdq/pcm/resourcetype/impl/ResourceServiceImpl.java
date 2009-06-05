/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.repository.impl.AbstractServiceImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceServiceImpl#getResourceInterface_ResourceService <em>Resource Interface Resource Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceServiceImpl extends AbstractServiceImpl implements ResourceService {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.RESOURCE_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface getResourceInterface_ResourceService() {
		if (eContainerFeatureID != ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE) return null;
		return (ResourceInterface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceInterface_ResourceService(ResourceInterface newResourceInterface_ResourceService, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceInterface_ResourceService, ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceInterface_ResourceService(ResourceInterface newResourceInterface_ResourceService) {
		if (newResourceInterface_ResourceService != eInternalContainer() || (eContainerFeatureID != ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE && newResourceInterface_ResourceService != null)) {
			if (EcoreUtil.isAncestor(this, newResourceInterface_ResourceService))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceInterface_ResourceService != null)
				msgs = ((InternalEObject)newResourceInterface_ResourceService).eInverseAdd(this, ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE, ResourceInterface.class, msgs);
			msgs = basicSetResourceInterface_ResourceService(newResourceInterface_ResourceService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE, newResourceInterface_ResourceService, newResourceInterface_ResourceService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceInterface_ResourceService((ResourceInterface)otherEnd, msgs);
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
			case ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE:
				return basicSetResourceInterface_ResourceService(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE:
				return eInternalContainer().eInverseRemove(this, ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE, ResourceInterface.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE:
				return getResourceInterface_ResourceService();
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
			case ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE:
				setResourceInterface_ResourceService((ResourceInterface)newValue);
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
			case ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE:
				setResourceInterface_ResourceService((ResourceInterface)null);
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
			case ResourcetypePackage.RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE:
				return getResourceInterface_ResourceService() != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceServiceImpl
