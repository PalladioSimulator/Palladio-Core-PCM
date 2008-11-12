/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
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
import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourcetypeFactoryImpl extends EFactoryImpl implements ResourcetypeFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourcetypeFactory init() {
		try {
			ResourcetypeFactory theResourcetypeFactory = (ResourcetypeFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/ResourceType/1.0"); 
			if (theResourcetypeFactory != null) {
				return theResourcetypeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourcetypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcetypeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ResourcetypePackage.RESOURCE_REPOSITORY: return createResourceRepository();
			case ResourcetypePackage.PROCESSING_RESOURCE_TYPE: return createProcessingResourceType();
			case ResourcetypePackage.RESOURCE_PROVIDED_ROLE: return createResourceProvidedRole();
			case ResourcetypePackage.RESOURCE_INTERFACE: return createResourceInterface();
			case ResourcetypePackage.RESOURCE_SERVICE: return createResourceService();
			case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE: return createCommunicationLinkResourceType();
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE: return createResourceRequiredRole();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRepository createResourceRepository() {
		ResourceRepositoryImpl resourceRepository = new ResourceRepositoryImpl();
		return resourceRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationLinkResourceType createCommunicationLinkResourceType() {
		CommunicationLinkResourceTypeImpl communicationLinkResourceType = new CommunicationLinkResourceTypeImpl();
		return communicationLinkResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface createResourceInterface() {
		ResourceInterfaceImpl resourceInterface = new ResourceInterfaceImpl();
		return resourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceService createResourceService() {
		ResourceServiceImpl resourceService = new ResourceServiceImpl();
		return resourceService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceProvidedRole createResourceProvidedRole() {
		ResourceProvidedRoleImpl resourceProvidedRole = new ResourceProvidedRoleImpl();
		return resourceProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole createResourceRequiredRole() {
		ResourceRequiredRoleImpl resourceRequiredRole = new ResourceRequiredRoleImpl();
		return resourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType createProcessingResourceType() {
		ProcessingResourceTypeImpl processingResourceType = new ProcessingResourceTypeImpl();
		return processingResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcetypePackage getResourcetypePackage() {
		return (ResourcetypePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourcetypePackage getPackage() {
		return ResourcetypePackage.eINSTANCE;
	}

} //ResourcetypeFactoryImpl
