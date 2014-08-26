/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ResourcetypeFactoryImpl extends EFactoryImpl implements ResourcetypeFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static ResourcetypeFactory init() {
        try {
            final ResourcetypeFactory theResourcetypeFactory = (ResourcetypeFactory) EPackage.Registry.INSTANCE
                    .getEFactory(ResourcetypePackage.eNS_URI);
            if (theResourcetypeFactory != null) {
                return theResourcetypeFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ResourcetypeFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourcetypeFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case ResourcetypePackage.RESOURCE_SIGNATURE:
            return this.createResourceSignature();
        case ResourcetypePackage.PROCESSING_RESOURCE_TYPE:
            return this.createProcessingResourceType();
        case ResourcetypePackage.RESOURCE_REPOSITORY:
            return this.createResourceRepository();
        case ResourcetypePackage.SCHEDULING_POLICY:
            return this.createSchedulingPolicy();
        case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE:
            return this.createCommunicationLinkResourceType();
        case ResourcetypePackage.RESOURCE_INTERFACE:
            return this.createResourceInterface();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceSignature createResourceSignature() {
        final ResourceSignatureImpl resourceSignature = new ResourceSignatureImpl();
        return resourceSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceRepository createResourceRepository() {
        final ResourceRepositoryImpl resourceRepository = new ResourceRepositoryImpl();
        return resourceRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SchedulingPolicy createSchedulingPolicy() {
        final SchedulingPolicyImpl schedulingPolicy = new SchedulingPolicyImpl();
        return schedulingPolicy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CommunicationLinkResourceType createCommunicationLinkResourceType() {
        final CommunicationLinkResourceTypeImpl communicationLinkResourceType = new CommunicationLinkResourceTypeImpl();
        return communicationLinkResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceInterface createResourceInterface() {
        final ResourceInterfaceImpl resourceInterface = new ResourceInterfaceImpl();
        return resourceInterface;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProcessingResourceType createProcessingResourceType() {
        final ProcessingResourceTypeImpl processingResourceType = new ProcessingResourceTypeImpl();
        return processingResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourcetypePackage getResourcetypePackage() {
        return (ResourcetypePackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ResourcetypePackage getPackage() {
        return ResourcetypePackage.eINSTANCE;
    }

} // ResourcetypeFactoryImpl
