/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory
 * @model kind="package"
 * @generated
 */
public interface ResourcetypePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resourcetype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/ResourceType/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcetypePackage eINSTANCE = de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__UNIT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__UNIT_SPECIFICATION = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl <em>Resource Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceRepository()
	 * @generated
	 */
	int RESOURCE_REPOSITORY = 1;

	/**
	 * The feature id for the '<em><b>Available Resource Types Resource Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY = 0;

	/**
	 * The number of structural features of the '<em>Resource Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REPOSITORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl <em>Processing Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getProcessingResourceType()
	 * @generated
	 */
	int PROCESSING_RESOURCE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__ID = RESOURCE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__ENTITY_NAME = RESOURCE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__UNIT = RESOURCE_TYPE__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__UNIT_SPECIFICATION = RESOURCE_TYPE__UNIT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Resource Provided Roles Resource Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY = RESOURCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE_FEATURE_COUNT = RESOURCE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl <em>Communication Link Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getCommunicationLinkResourceType()
	 * @generated
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl <em>Resource Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceInterface()
	 * @generated
	 */
	int RESOURCE_INTERFACE = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceServiceImpl <em>Resource Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceServiceImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceService()
	 * @generated
	 */
	int RESOURCE_SERVICE = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceProvidedRoleImpl <em>Resource Provided Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceProvidedRoleImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceProvidedRole()
	 * @generated
	 */
	int RESOURCE_PROVIDED_ROLE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE__ID = RepositoryPackage.ROLE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE__ENTITY_NAME = RepositoryPackage.ROLE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Resource Interface Resource Provided Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE = RepositoryPackage.ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Interface Providing Entity Resource Provided Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE = RepositoryPackage.ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Provided Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE_FEATURE_COUNT = RepositoryPackage.ROLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE__ID = RepositoryPackage.ABSTRACT_INTERFACE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE__ENTITY_NAME = RepositoryPackage.ABSTRACT_INTERFACE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository Abstract Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE__REPOSITORY_ABSTRACT_INTERFACE = RepositoryPackage.ABSTRACT_INTERFACE__REPOSITORY_ABSTRACT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Resource Services Resource Interface</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE = RepositoryPackage.ABSTRACT_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_FEATURE_COUNT = RepositoryPackage.ABSTRACT_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE__SERVICE_NAME = 0;

	/**
	 * The number of structural features of the '<em>Resource Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__ID = PROCESSING_RESOURCE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__ENTITY_NAME = PROCESSING_RESOURCE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__UNIT = PROCESSING_RESOURCE_TYPE__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__UNIT_SPECIFICATION = PROCESSING_RESOURCE_TYPE__UNIT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Resource Provided Roles Resource Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY = PROCESSING_RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The number of structural features of the '<em>Communication Link Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE_FEATURE_COUNT = PROCESSING_RESOURCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl <em>Resource Required Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceRequiredRole()
	 * @generated
	 */
	int RESOURCE_REQUIRED_ROLE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE__ID = RepositoryPackage.ROLE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE__ENTITY_NAME = RepositoryPackage.ROLE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Required Resource Interface Resource Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE = RepositoryPackage.ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Requiring Entity Resource Required Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE = RepositoryPackage.ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Required Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE_FEATURE_COUNT = RepositoryPackage.ROLE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository <em>Resource Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository
	 * @generated
	 */
	EClass getResourceRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableResourceTypes_ResourceRepository <em>Available Resource Types Resource Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Resource Types Resource Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableResourceTypes_ResourceRepository()
	 * @see #getResourceRepository()
	 * @generated
	 */
	EReference getResourceRepository_AvailableResourceTypes_ResourceRepository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType <em>Communication Link Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Link Resource Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType
	 * @generated
	 */
	EClass getCommunicationLinkResourceType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface <em>Resource Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface
	 * @generated
	 */
	EClass getResourceInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getResourceServices_ResourceInterface <em>Resource Services Resource Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Services Resource Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getResourceServices_ResourceInterface()
	 * @see #getResourceInterface()
	 * @generated
	 */
	EReference getResourceInterface_ResourceServices_ResourceInterface();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceService <em>Resource Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Service</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceService
	 * @generated
	 */
	EClass getResourceService();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getServiceName()
	 * @see #getResourceService()
	 * @generated
	 */
	EAttribute getResourceService_ServiceName();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole <em>Resource Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole
	 * @generated
	 */
	EClass getResourceProvidedRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getProvidedResourceInterface_ResourceProvidedRole <em>Provided Resource Interface Resource Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Resource Interface Resource Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getProvidedResourceInterface_ResourceProvidedRole()
	 * @see #getResourceProvidedRole()
	 * @generated
	 */
	EReference getResourceProvidedRole_ProvidedResourceInterface_ResourceProvidedRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getResourceInterfaceProvidingEntity_ResourceProvidedRole <em>Resource Interface Providing Entity Resource Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Interface Providing Entity Resource Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getResourceInterfaceProvidingEntity_ResourceProvidedRole()
	 * @see #getResourceProvidedRole()
	 * @generated
	 */
	EReference getResourceProvidedRole_ResourceInterfaceProvidingEntity_ResourceProvidedRole();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole <em>Resource Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole
	 * @generated
	 */
	EClass getResourceRequiredRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole#getRequiredResourceInterface_ResourceRequiredRole <em>Required Resource Interface Resource Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Resource Interface Resource Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole#getRequiredResourceInterface_ResourceRequiredRole()
	 * @see #getResourceRequiredRole()
	 * @generated
	 */
	EReference getResourceRequiredRole_RequiredResourceInterface_ResourceRequiredRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Requiring Entity Resource Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole()
	 * @see #getResourceRequiredRole()
	 * @generated
	 */
	EReference getResourceRequiredRole_ResourceRequiringEntity_ResourceRequiredRole();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType <em>Processing Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType
	 * @generated
	 */
	EClass getProcessingResourceType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourcetypeFactory getResourcetypeFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl <em>Resource Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceRepository()
		 * @generated
		 */
		EClass RESOURCE_REPOSITORY = eINSTANCE.getResourceRepository();

		/**
		 * The meta object literal for the '<em><b>Available Resource Types Resource Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY = eINSTANCE.getResourceRepository_AvailableResourceTypes_ResourceRepository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl <em>Communication Link Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getCommunicationLinkResourceType()
		 * @generated
		 */
		EClass COMMUNICATION_LINK_RESOURCE_TYPE = eINSTANCE.getCommunicationLinkResourceType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl <em>Resource Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceInterface()
		 * @generated
		 */
		EClass RESOURCE_INTERFACE = eINSTANCE.getResourceInterface();

		/**
		 * The meta object literal for the '<em><b>Resource Services Resource Interface</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE = eINSTANCE.getResourceInterface_ResourceServices_ResourceInterface();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceServiceImpl <em>Resource Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceServiceImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceService()
		 * @generated
		 */
		EClass RESOURCE_SERVICE = eINSTANCE.getResourceService();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_SERVICE__SERVICE_NAME = eINSTANCE.getResourceService_ServiceName();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceProvidedRoleImpl <em>Resource Provided Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceProvidedRoleImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceProvidedRole()
		 * @generated
		 */
		EClass RESOURCE_PROVIDED_ROLE = eINSTANCE.getResourceProvidedRole();

		/**
		 * The meta object literal for the '<em><b>Provided Resource Interface Resource Provided Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE = eINSTANCE.getResourceProvidedRole_ProvidedResourceInterface_ResourceProvidedRole();

		/**
		 * The meta object literal for the '<em><b>Resource Interface Providing Entity Resource Provided Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE = eINSTANCE.getResourceProvidedRole_ResourceInterfaceProvidingEntity_ResourceProvidedRole();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl <em>Resource Required Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceRequiredRole()
		 * @generated
		 */
		EClass RESOURCE_REQUIRED_ROLE = eINSTANCE.getResourceRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Required Resource Interface Resource Required Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE = eINSTANCE.getResourceRequiredRole_RequiredResourceInterface_ResourceRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Resource Requiring Entity Resource Required Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE = eINSTANCE.getResourceRequiredRole_ResourceRequiringEntity_ResourceRequiredRole();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl <em>Processing Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getProcessingResourceType()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE_TYPE = eINSTANCE.getProcessingResourceType();

	}

} //ResourcetypePackage
