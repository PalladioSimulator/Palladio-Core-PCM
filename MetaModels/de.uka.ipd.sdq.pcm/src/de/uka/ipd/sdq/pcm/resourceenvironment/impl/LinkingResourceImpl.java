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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linking Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl#getConnectedResourceContainers <em>Connected Resource Containers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl#getCommunicationLinkResourceSpecifications <em>Communication Link Resource Specifications</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkingResourceImpl extends EntityImpl implements LinkingResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getConnectedResourceContainers() <em>Connected Resource Containers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectedResourceContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceContainer> connectedResourceContainers;

	/**
	 * The cached value of the '{@link #getCommunicationLinkResourceSpecifications() <em>Communication Link Resource Specifications</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationLinkResourceSpecifications()
	 * @generated
	 * @ordered
	 */
	protected CommunicationLinkResourceSpecification communicationLinkResourceSpecifications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkingResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.LINKING_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceContainer> getConnectedResourceContainers() {
		if (connectedResourceContainers == null) {
			connectedResourceContainers = new EObjectResolvingEList<ResourceContainer>(ResourceContainer.class, this, ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS);
		}
		return connectedResourceContainers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationLinkResourceSpecification getCommunicationLinkResourceSpecifications() {
		return communicationLinkResourceSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommunicationLinkResourceSpecifications(CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifications, NotificationChain msgs) {
		CommunicationLinkResourceSpecification oldCommunicationLinkResourceSpecifications = communicationLinkResourceSpecifications;
		communicationLinkResourceSpecifications = newCommunicationLinkResourceSpecifications;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS, oldCommunicationLinkResourceSpecifications, newCommunicationLinkResourceSpecifications);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommunicationLinkResourceSpecifications(CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifications) {
		if (newCommunicationLinkResourceSpecifications != communicationLinkResourceSpecifications) {
			NotificationChain msgs = null;
			if (communicationLinkResourceSpecifications != null)
				msgs = ((InternalEObject)communicationLinkResourceSpecifications).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS, null, msgs);
			if (newCommunicationLinkResourceSpecifications != null)
				msgs = ((InternalEObject)newCommunicationLinkResourceSpecifications).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS, null, msgs);
			msgs = basicSetCommunicationLinkResourceSpecifications(newCommunicationLinkResourceSpecifications, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS, newCommunicationLinkResourceSpecifications, newCommunicationLinkResourceSpecifications));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS:
				return basicSetCommunicationLinkResourceSpecifications(null, msgs);
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
			case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS:
				return getConnectedResourceContainers();
			case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS:
				return getCommunicationLinkResourceSpecifications();
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
			case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS:
				getConnectedResourceContainers().clear();
				getConnectedResourceContainers().addAll((Collection<? extends ResourceContainer>)newValue);
				return;
			case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS:
				setCommunicationLinkResourceSpecifications((CommunicationLinkResourceSpecification)newValue);
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
			case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS:
				getConnectedResourceContainers().clear();
				return;
			case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS:
				setCommunicationLinkResourceSpecifications((CommunicationLinkResourceSpecification)null);
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
			case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS:
				return connectedResourceContainers != null && !connectedResourceContainers.isEmpty();
			case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS:
				return communicationLinkResourceSpecifications != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkingResourceImpl
