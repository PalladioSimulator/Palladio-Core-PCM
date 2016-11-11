/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourceenvironment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcm.resourceenvironment.*;
import org.palladiosimulator.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentFactory;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ResourceenvironmentFactoryImpl extends EFactoryImpl implements ResourceenvironmentFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceenvironmentFactory init() {
		try {
			ResourceenvironmentFactory theResourceenvironmentFactory = (ResourceenvironmentFactory) EPackage.Registry.INSTANCE
					.getEFactory(ResourceenvironmentPackage.eNS_URI);
			if (theResourceenvironmentFactory != null) {
				return theResourceenvironmentFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourceenvironmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT:
			return createResourceEnvironment();
		case ResourceenvironmentPackage.LINKING_RESOURCE:
			return createLinkingResource();
		case ResourceenvironmentPackage.RESOURCE_CONTAINER:
			return createResourceContainer();
		case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION:
			return createProcessingResourceSpecification();
		case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION:
			return createCommunicationLinkResourceSpecification();
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION:
			return createHDDProcessingResourceSpecification();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceEnvironment createResourceEnvironment() {
		ResourceEnvironmentImpl resourceEnvironment = new ResourceEnvironmentImpl();
		return resourceEnvironment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LinkingResource createLinkingResource() {
		LinkingResourceImpl linkingResource = new LinkingResourceImpl();
		return linkingResource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceContainer createResourceContainer() {
		ResourceContainerImpl resourceContainer = new ResourceContainerImpl();
		return resourceContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessingResourceSpecification createProcessingResourceSpecification() {
		ProcessingResourceSpecificationImpl processingResourceSpecification = new ProcessingResourceSpecificationImpl();
		return processingResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommunicationLinkResourceSpecification createCommunicationLinkResourceSpecification() {
		CommunicationLinkResourceSpecificationImpl communicationLinkResourceSpecification = new CommunicationLinkResourceSpecificationImpl();
		return communicationLinkResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HDDProcessingResourceSpecification createHDDProcessingResourceSpecification() {
		HDDProcessingResourceSpecificationImpl hddProcessingResourceSpecification = new HDDProcessingResourceSpecificationImpl();
		return hddProcessingResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceenvironmentPackage getResourceenvironmentPackage() {
		return (ResourceenvironmentPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourceenvironmentPackage getPackage() {
		return ResourceenvironmentPackage.eINSTANCE;
	}

} // ResourceenvironmentFactoryImpl
