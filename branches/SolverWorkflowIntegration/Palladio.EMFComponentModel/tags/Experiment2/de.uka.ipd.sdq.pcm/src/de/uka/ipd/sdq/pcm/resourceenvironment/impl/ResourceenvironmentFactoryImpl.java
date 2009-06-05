/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ResourceenvironmentFactoryImpl extends EFactoryImpl implements ResourceenvironmentFactory {
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
	public static ResourceenvironmentFactory init() {
		try {
			ResourceenvironmentFactory theResourceenvironmentFactory = (ResourceenvironmentFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/ResourceEnvironment/1.0"); 
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentFactoryImpl() {
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
			case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT: return createResourceEnvironment();
			case ResourceenvironmentPackage.LINKING_RESOURCE: return createLinkingResource();
			case ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION: return createCommunicationLinkResourceSpecification();
			case ResourceenvironmentPackage.LATENCY: return createLatency();
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION: return createProcessingResourceSpecification();
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION: return createPassiveResourceSpecification();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER: return createResourceContainer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ResourceenvironmentPackage.SCHEDULING_POLICY:
				return createSchedulingPolicyFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ResourceenvironmentPackage.SCHEDULING_POLICY:
				return convertSchedulingPolicyToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEnvironment createResourceEnvironment() {
		ResourceEnvironmentImpl resourceEnvironment = new ResourceEnvironmentImpl();
		return resourceEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkingResource createLinkingResource() {
		LinkingResourceImpl linkingResource = new LinkingResourceImpl();
		return linkingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationLinkResourceSpecification createCommunicationLinkResourceSpecification() {
		CommunicationLinkResourceSpecificationImpl communicationLinkResourceSpecification = new CommunicationLinkResourceSpecificationImpl();
		return communicationLinkResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Latency createLatency() {
		LatencyImpl latency = new LatencyImpl();
		return latency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification createProcessingResourceSpecification() {
		ProcessingResourceSpecificationImpl processingResourceSpecification = new ProcessingResourceSpecificationImpl();
		return processingResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceSpecification createPassiveResourceSpecification() {
		PassiveResourceSpecificationImpl passiveResourceSpecification = new PassiveResourceSpecificationImpl();
		return passiveResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer createResourceContainer() {
		ResourceContainerImpl resourceContainer = new ResourceContainerImpl();
		return resourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicy createSchedulingPolicyFromString(EDataType eDataType, String initialValue) {
		SchedulingPolicy result = SchedulingPolicy.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchedulingPolicyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentPackage getResourceenvironmentPackage() {
		return (ResourceenvironmentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourceenvironmentPackage getPackage() {
		return ResourceenvironmentPackage.eINSTANCE;
	}

} //ResourceenvironmentFactoryImpl
