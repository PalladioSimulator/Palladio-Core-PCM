/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ResourceenvironmentFactoryImpl extends EFactoryImpl implements ResourceenvironmentFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static ResourceenvironmentFactory init() {
        try {
            ResourceenvironmentFactory theResourceenvironmentFactory = (ResourceenvironmentFactory)EPackage.Registry.INSTANCE.getEFactory(ResourceenvironmentPackage.eNS_URI);
            if (theResourceenvironmentFactory != null) {
                return theResourceenvironmentFactory;
            }
        }
        catch (Exception exception) {
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
            case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT: return createResourceEnvironment();
            case ResourceenvironmentPackage.LINKING_RESOURCE: return createLinkingResource();
            case ResourceenvironmentPackage.RESOURCE_CONTAINER: return createResourceContainer();
            case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION: return createProcessingResourceSpecification();
            case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION: return createCommunicationLinkResourceSpecification();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceEnvironment createResourceEnvironment() {
        ResourceEnvironmentImpl resourceEnvironment = new ResourceEnvironmentImpl();
        return resourceEnvironment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public LinkingResource createLinkingResource() {
        LinkingResourceImpl linkingResource = new LinkingResourceImpl();
        return linkingResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceContainer createResourceContainer() {
        ResourceContainerImpl resourceContainer = new ResourceContainerImpl();
        return resourceContainer;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ProcessingResourceSpecification createProcessingResourceSpecification() {
        ProcessingResourceSpecificationImpl processingResourceSpecification = new ProcessingResourceSpecificationImpl();
        return processingResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public CommunicationLinkResourceSpecification createCommunicationLinkResourceSpecification() {
        CommunicationLinkResourceSpecificationImpl communicationLinkResourceSpecification = new CommunicationLinkResourceSpecificationImpl();
        return communicationLinkResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceenvironmentPackage getResourceenvironmentPackage() {
        return (ResourceenvironmentPackage)getEPackage();
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
