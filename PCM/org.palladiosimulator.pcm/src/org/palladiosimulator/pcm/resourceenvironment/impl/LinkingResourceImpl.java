/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourceenvironment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;
import org.palladiosimulator.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Linking Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.LinkingResourceImpl#getConnectedResourceContainers_LinkingResource <em>Connected Resource Containers Linking Resource</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.LinkingResourceImpl#getCommunicationLinkResourceSpecifications_LinkingResource <em>Communication Link Resource Specifications Linking Resource</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.LinkingResourceImpl#getResourceEnvironment_LinkingResource <em>Resource Environment Linking Resource</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkingResourceImpl extends EntityImpl implements LinkingResource {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkingResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.LINKING_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<ResourceContainer> getConnectedResourceContainers_LinkingResource() {
		return (EList<ResourceContainer>) eDynamicGet(
				ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE,
				ResourceenvironmentPackage.Literals.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommunicationLinkResourceSpecification getCommunicationLinkResourceSpecifications_LinkingResource() {
		return (CommunicationLinkResourceSpecification) eDynamicGet(
				ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
				ResourceenvironmentPackage.Literals.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommunicationLinkResourceSpecifications_LinkingResource(
			CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifications_LinkingResource,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newCommunicationLinkResourceSpecifications_LinkingResource,
				ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommunicationLinkResourceSpecifications_LinkingResource(
			CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifications_LinkingResource) {
		eDynamicSet(
				ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
				ResourceenvironmentPackage.Literals.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
				newCommunicationLinkResourceSpecifications_LinkingResource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceEnvironment getResourceEnvironment_LinkingResource() {
		return (ResourceEnvironment) eDynamicGet(
				ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE,
				ResourceenvironmentPackage.Literals.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE, true,
				true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceEnvironment_LinkingResource(
			ResourceEnvironment newResourceEnvironment_LinkingResource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newResourceEnvironment_LinkingResource,
				ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceEnvironment_LinkingResource(ResourceEnvironment newResourceEnvironment_LinkingResource) {
		eDynamicSet(ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE,
				ResourceenvironmentPackage.Literals.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE,
				newResourceEnvironment_LinkingResource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
			CommunicationLinkResourceSpecification communicationLinkResourceSpecifications_LinkingResource = getCommunicationLinkResourceSpecifications_LinkingResource();
			if (communicationLinkResourceSpecifications_LinkingResource != null)
				msgs = ((InternalEObject) communicationLinkResourceSpecifications_LinkingResource).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
						null, msgs);
			return basicSetCommunicationLinkResourceSpecifications_LinkingResource(
					(CommunicationLinkResourceSpecification) otherEnd, msgs);
		case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetResourceEnvironment_LinkingResource((ResourceEnvironment) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
			return basicSetCommunicationLinkResourceSpecifications_LinkingResource(null, msgs);
		case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
			return basicSetResourceEnvironment_LinkingResource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
			return eInternalContainer().eInverseRemove(this,
					ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT,
					ResourceEnvironment.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
			return getConnectedResourceContainers_LinkingResource();
		case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
			return getCommunicationLinkResourceSpecifications_LinkingResource();
		case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
			return getResourceEnvironment_LinkingResource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
			getConnectedResourceContainers_LinkingResource().clear();
			getConnectedResourceContainers_LinkingResource().addAll((Collection<? extends ResourceContainer>) newValue);
			return;
		case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
			setCommunicationLinkResourceSpecifications_LinkingResource(
					(CommunicationLinkResourceSpecification) newValue);
			return;
		case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
			setResourceEnvironment_LinkingResource((ResourceEnvironment) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
			getConnectedResourceContainers_LinkingResource().clear();
			return;
		case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
			setCommunicationLinkResourceSpecifications_LinkingResource((CommunicationLinkResourceSpecification) null);
			return;
		case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
			setResourceEnvironment_LinkingResource((ResourceEnvironment) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
			return !getConnectedResourceContainers_LinkingResource().isEmpty();
		case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
			return getCommunicationLinkResourceSpecifications_LinkingResource() != null;
		case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
			return getResourceEnvironment_LinkingResource() != null;
		}
		return super.eIsSet(featureID);
	}

} // LinkingResourceImpl
