/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory
 * @model kind="package"
 * @generated
 */
public interface ResourceenvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resourceenvironment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/ResourceEnvironment/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.resourceenvironment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourceenvironmentPackage eINSTANCE = de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceEnvironmentImpl <em>Resource Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceEnvironmentImpl
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getResourceEnvironment()
	 * @generated
	 */
	int RESOURCE_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Linkingresource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ENVIRONMENT__LINKINGRESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Resource Container Resource Environment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT = 1;

	/**
	 * The number of structural features of the '<em>Resource Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ENVIRONMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl <em>Linking Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getLinkingResource()
	 * @generated
	 */
	int LINKING_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>To Resource Container Linking Resource</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE__TO_RESOURCE_CONTAINER_LINKING_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>From Resource Container Linking Resource</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE__FROM_RESOURCE_CONTAINER_LINKING_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Communication Link Resource Specifications Linking Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE = 2;

	/**
	 * The number of structural features of the '<em>Linking Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl <em>Communication Link Resource Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getCommunicationLinkResourceSpecification()
	 * @generated
	 */
	int COMMUNICATION_LINK_RESOURCE_SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Communication Link Resource Type Communication Link Resource Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT = 1;

	/**
	 * The feature id for the '<em><b>Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_SPECIFICATION__UNITS = 2;

	/**
	 * The number of structural features of the '<em>Communication Link Resource Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_SPECIFICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl <em>Processing Resource Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getProcessingResourceSpecification()
	 * @generated
	 */
	int PROCESSING_RESOURCE_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Active Resource Type Active Resource Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Processing Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE = 1;

	/**
	 * The feature id for the '<em><b>Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION__UNITS = 2;

	/**
	 * The number of structural features of the '<em>Processing Resource Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.PassiveResourceSpecificationImpl <em>Passive Resource Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.PassiveResourceSpecificationImpl
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getPassiveResourceSpecification()
	 * @generated
	 */
	int PASSIVE_RESOURCE_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_SPECIFICATION__CAPACITY = 0;

	/**
	 * The feature id for the '<em><b>Passive Resource Type Passive Resource Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION = 1;

	/**
	 * The number of structural features of the '<em>Passive Resource Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl <em>Resource Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getResourceContainer()
	 * @generated
	 */
	int RESOURCE_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Active Resource Specifications Resource Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Passive Resource Specifications Resource Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment <em>Resource Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Environment</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment
	 * @generated
	 */
	EClass getResourceEnvironment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getLinkingresource <em>Linkingresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Linkingresource</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getLinkingresource()
	 * @see #getResourceEnvironment()
	 * @generated
	 */
	EReference getResourceEnvironment_Linkingresource();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getResourceContainer_ResourceEnvironment <em>Resource Container Resource Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Container Resource Environment</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getResourceContainer_ResourceEnvironment()
	 * @see #getResourceEnvironment()
	 * @generated
	 */
	EReference getResourceEnvironment_ResourceContainer_ResourceEnvironment();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource <em>Linking Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linking Resource</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource
	 * @generated
	 */
	EClass getLinkingResource();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getToResourceContainer_LinkingResource <em>To Resource Container Linking Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To Resource Container Linking Resource</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getToResourceContainer_LinkingResource()
	 * @see #getLinkingResource()
	 * @generated
	 */
	EReference getLinkingResource_ToResourceContainer_LinkingResource();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getFromResourceContainer_LinkingResource <em>From Resource Container Linking Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Resource Container Linking Resource</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getFromResourceContainer_LinkingResource()
	 * @see #getLinkingResource()
	 * @generated
	 */
	EReference getLinkingResource_FromResourceContainer_LinkingResource();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getCommunicationLinkResourceSpecifications_LinkingResource <em>Communication Link Resource Specifications Linking Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Communication Link Resource Specifications Linking Resource</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getCommunicationLinkResourceSpecifications_LinkingResource()
	 * @see #getLinkingResource()
	 * @generated
	 */
	EReference getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification <em>Communication Link Resource Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Link Resource Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification
	 * @generated
	 */
	EClass getCommunicationLinkResourceSpecification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getCommunicationLinkResourceType_CommunicationLinkResourceSpecification <em>Communication Link Resource Type Communication Link Resource Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Communication Link Resource Type Communication Link Resource Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getCommunicationLinkResourceType_CommunicationLinkResourceSpecification()
	 * @see #getCommunicationLinkResourceSpecification()
	 * @generated
	 */
	EReference getCommunicationLinkResourceSpecification_CommunicationLinkResourceType_CommunicationLinkResourceSpecification();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getThroughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throughput</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getThroughput()
	 * @see #getCommunicationLinkResourceSpecification()
	 * @generated
	 */
	EAttribute getCommunicationLinkResourceSpecification_Throughput();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Units</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getUnits()
	 * @see #getCommunicationLinkResourceSpecification()
	 * @generated
	 */
	EAttribute getCommunicationLinkResourceSpecification_Units();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification <em>Processing Resource Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification
	 * @generated
	 */
	EClass getProcessingResourceSpecification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getActiveResourceType_ActiveResourceSpecification <em>Active Resource Type Active Resource Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Resource Type Active Resource Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getActiveResourceType_ActiveResourceSpecification()
	 * @see #getProcessingResourceSpecification()
	 * @generated
	 */
	EReference getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getProcessingRate <em>Processing Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processing Rate</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getProcessingRate()
	 * @see #getProcessingResourceSpecification()
	 * @generated
	 */
	EAttribute getProcessingResourceSpecification_ProcessingRate();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Units</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getUnits()
	 * @see #getProcessingResourceSpecification()
	 * @generated
	 */
	EAttribute getProcessingResourceSpecification_Units();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification <em>Passive Resource Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification
	 * @generated
	 */
	EClass getPassiveResourceSpecification();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification#getCapacity()
	 * @see #getPassiveResourceSpecification()
	 * @generated
	 */
	EAttribute getPassiveResourceSpecification_Capacity();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification#getPassiveResourceType_PassiveResourceSpecification <em>Passive Resource Type Passive Resource Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Passive Resource Type Passive Resource Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification#getPassiveResourceType_PassiveResourceSpecification()
	 * @see #getPassiveResourceSpecification()
	 * @generated
	 */
	EReference getPassiveResourceSpecification_PassiveResourceType_PassiveResourceSpecification();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer <em>Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Container</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer
	 * @generated
	 */
	EClass getResourceContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Active Resource Specifications Resource Container</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getActiveResourceSpecifications_ResourceContainer()
	 * @see #getResourceContainer()
	 * @generated
	 */
	EReference getResourceContainer_ActiveResourceSpecifications_ResourceContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getPassiveResourceSpecifications_ResourceContainer <em>Passive Resource Specifications Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Passive Resource Specifications Resource Container</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getPassiveResourceSpecifications_ResourceContainer()
	 * @see #getResourceContainer()
	 * @generated
	 */
	EReference getResourceContainer_PassiveResourceSpecifications_ResourceContainer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourceenvironmentFactory getResourceenvironmentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceEnvironmentImpl <em>Resource Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceEnvironmentImpl
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getResourceEnvironment()
		 * @generated
		 */
		EClass RESOURCE_ENVIRONMENT = eINSTANCE.getResourceEnvironment();

		/**
		 * The meta object literal for the '<em><b>Linkingresource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_ENVIRONMENT__LINKINGRESOURCE = eINSTANCE.getResourceEnvironment_Linkingresource();

		/**
		 * The meta object literal for the '<em><b>Resource Container Resource Environment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT = eINSTANCE.getResourceEnvironment_ResourceContainer_ResourceEnvironment();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl <em>Linking Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getLinkingResource()
		 * @generated
		 */
		EClass LINKING_RESOURCE = eINSTANCE.getLinkingResource();

		/**
		 * The meta object literal for the '<em><b>To Resource Container Linking Resource</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKING_RESOURCE__TO_RESOURCE_CONTAINER_LINKING_RESOURCE = eINSTANCE.getLinkingResource_ToResourceContainer_LinkingResource();

		/**
		 * The meta object literal for the '<em><b>From Resource Container Linking Resource</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKING_RESOURCE__FROM_RESOURCE_CONTAINER_LINKING_RESOURCE = eINSTANCE.getLinkingResource_FromResourceContainer_LinkingResource();

		/**
		 * The meta object literal for the '<em><b>Communication Link Resource Specifications Linking Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE = eINSTANCE.getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl <em>Communication Link Resource Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.CommunicationLinkResourceSpecificationImpl
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getCommunicationLinkResourceSpecification()
		 * @generated
		 */
		EClass COMMUNICATION_LINK_RESOURCE_SPECIFICATION = eINSTANCE.getCommunicationLinkResourceSpecification();

		/**
		 * The meta object literal for the '<em><b>Communication Link Resource Type Communication Link Resource Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION = eINSTANCE.getCommunicationLinkResourceSpecification_CommunicationLinkResourceType_CommunicationLinkResourceSpecification();

		/**
		 * The meta object literal for the '<em><b>Throughput</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT = eINSTANCE.getCommunicationLinkResourceSpecification_Throughput();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_LINK_RESOURCE_SPECIFICATION__UNITS = eINSTANCE.getCommunicationLinkResourceSpecification_Units();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl <em>Processing Resource Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getProcessingResourceSpecification()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE_SPECIFICATION = eINSTANCE.getProcessingResourceSpecification();

		/**
		 * The meta object literal for the '<em><b>Active Resource Type Active Resource Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION = eINSTANCE.getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification();

		/**
		 * The meta object literal for the '<em><b>Processing Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE = eINSTANCE.getProcessingResourceSpecification_ProcessingRate();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_RESOURCE_SPECIFICATION__UNITS = eINSTANCE.getProcessingResourceSpecification_Units();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.PassiveResourceSpecificationImpl <em>Passive Resource Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.PassiveResourceSpecificationImpl
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getPassiveResourceSpecification()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE_SPECIFICATION = eINSTANCE.getPassiveResourceSpecification();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASSIVE_RESOURCE_SPECIFICATION__CAPACITY = eINSTANCE.getPassiveResourceSpecification_Capacity();

		/**
		 * The meta object literal for the '<em><b>Passive Resource Type Passive Resource Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION = eINSTANCE.getPassiveResourceSpecification_PassiveResourceType_PassiveResourceSpecification();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl <em>Resource Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl
		 * @see de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl#getResourceContainer()
		 * @generated
		 */
		EClass RESOURCE_CONTAINER = eINSTANCE.getResourceContainer();

		/**
		 * The meta object literal for the '<em><b>Active Resource Specifications Resource Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER = eINSTANCE.getResourceContainer_ActiveResourceSpecifications_ResourceContainer();

		/**
		 * The meta object literal for the '<em><b>Passive Resource Specifications Resource Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER = eINSTANCE.getResourceContainer_PassiveResourceSpecifications_ResourceContainer();

	}

} //ResourceenvironmentPackage
