/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.resourcetype.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ResourcetypePackage.RESOURCE_REPOSITORY: return createResourceRepository();
			case ResourcetypePackage.PASSIVE_RESOURCE_TYPE: return createPassiveResourceType();
			case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE: return createCommunicationLinkResourceType();
			case ResourcetypePackage.PROCESSING_RESOURCE_TYPE: return createProcessingResourceType();
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
	public PassiveResourceType createPassiveResourceType() {
		PassiveResourceTypeImpl passiveResourceType = new PassiveResourceTypeImpl();
		return passiveResourceType;
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
	public static ResourcetypePackage getPackage() {
		return ResourcetypePackage.eINSTANCE;
	}

} //ResourcetypeFactoryImpl
