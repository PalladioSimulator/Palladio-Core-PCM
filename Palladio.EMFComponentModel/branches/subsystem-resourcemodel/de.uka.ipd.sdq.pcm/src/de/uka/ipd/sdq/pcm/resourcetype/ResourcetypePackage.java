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
	 * The feature id for the '<em><b>Available Controller Stacks Resource Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY = 1;

	/**
	 * The feature id for the '<em><b>Available Controller Types Resource Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY = 2;

	/**
	 * The number of structural features of the '<em>Resource Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REPOSITORY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerStackImpl <em>Controller Stack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerStackImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getControllerStack()
	 * @generated
	 */
	int CONTROLLER_STACK = 2;

	/**
	 * The feature id for the '<em><b>Controller Layers Controller Stack</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK = 0;

	/**
	 * The number of structural features of the '<em>Controller Stack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_STACK_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl <em>Controller Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getControllerLayer()
	 * @generated
	 */
	int CONTROLLER_LAYER = 3;

	/**
	 * The feature id for the '<em><b>Upper Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_LAYER__UPPER_LAYER = 0;

	/**
	 * The feature id for the '<em><b>Lower Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_LAYER__LOWER_LAYER = 1;

	/**
	 * The feature id for the '<em><b>Controller Type Controller Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE = 2;

	/**
	 * The number of structural features of the '<em>Controller Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_LAYER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerTypeImpl <em>Controller Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getControllerType()
	 * @generated
	 */
	int CONTROLLER_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_TYPE__ID = EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_TYPE__ENTITY_NAME = EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_TYPE__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Provided Role Resource Interface Providing Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_TYPE__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY = EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Controller Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_TYPE_FEATURE_COUNT = EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl <em>Processing Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getProcessingResourceType()
	 * @generated
	 */
	int PROCESSING_RESOURCE_TYPE = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl <em>Communication Link Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getCommunicationLinkResourceType()
	 * @generated
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE = 9;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl <em>Resource Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceInterface()
	 * @generated
	 */
	int RESOURCE_INTERFACE = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceServiceImpl <em>Resource Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceServiceImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceService()
	 * @generated
	 */
	int RESOURCE_SERVICE = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceProvidedRoleImpl <em>Resource Provided Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceProvidedRoleImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceProvidedRole()
	 * @generated
	 */
	int RESOURCE_PROVIDED_ROLE = 5;

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
	 * The feature id for the '<em><b>Ancestor Resource Interfaces Resource Interface</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE__ANCESTOR_RESOURCE_INTERFACES_RESOURCE_INTERFACE = RepositoryPackage.ABSTRACT_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Resource Interface Resource Interface</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE__PARENT_RESOURCE_INTERFACE_RESOURCE_INTERFACE = RepositoryPackage.ABSTRACT_INTERFACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_FEATURE_COUNT = RepositoryPackage.ABSTRACT_INTERFACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE__SERVICE_NAME = RepositoryPackage.ABSTRACT_SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Resource Interface Resource Service</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE = RepositoryPackage.ABSTRACT_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE_FEATURE_COUNT = RepositoryPackage.ABSTRACT_SERVICE_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Resource Provided Role Resource Interface Providing Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY = RESOURCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE_FEATURE_COUNT = RESOURCE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__ID = RESOURCE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__ENTITY_NAME = RESOURCE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__UNIT = RESOURCE_TYPE__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__UNIT_SPECIFICATION = RESOURCE_TYPE__UNIT_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Communication Link Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE_FEATURE_COUNT = RESOURCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl <em>Resource Required Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceRequiredRole()
	 * @generated
	 */
	int RESOURCE_REQUIRED_ROLE = 10;

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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableControllerStacks_ResourceRepository <em>Available Controller Stacks Resource Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Controller Stacks Resource Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableControllerStacks_ResourceRepository()
	 * @see #getResourceRepository()
	 * @generated
	 */
	EReference getResourceRepository_AvailableControllerStacks_ResourceRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableControllerTypes_ResourceRepository <em>Available Controller Types Resource Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Controller Types Resource Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableControllerTypes_ResourceRepository()
	 * @see #getResourceRepository()
	 * @generated
	 */
	EReference getResourceRepository_AvailableControllerTypes_ResourceRepository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerStack <em>Controller Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Controller Stack</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerStack
	 * @generated
	 */
	EClass getControllerStack();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerStack#getControllerLayers_ControllerStack <em>Controller Layers Controller Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controller Layers Controller Stack</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerStack#getControllerLayers_ControllerStack()
	 * @see #getControllerStack()
	 * @generated
	 */
	EReference getControllerStack_ControllerLayers_ControllerStack();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer <em>Controller Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Controller Layer</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer
	 * @generated
	 */
	EClass getControllerLayer();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getUpperLayer <em>Upper Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Layer</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getUpperLayer()
	 * @see #getControllerLayer()
	 * @generated
	 */
	EReference getControllerLayer_UpperLayer();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getLowerLayer <em>Lower Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Layer</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getLowerLayer()
	 * @see #getControllerLayer()
	 * @generated
	 */
	EReference getControllerLayer_LowerLayer();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getControllerType_ControllerScope <em>Controller Type Controller Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Controller Type Controller Scope</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer#getControllerType_ControllerScope()
	 * @see #getControllerLayer()
	 * @generated
	 */
	EReference getControllerLayer_ControllerType_ControllerScope();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ControllerType <em>Controller Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Controller Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ControllerType
	 * @generated
	 */
	EClass getControllerType();

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
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getAncestorResourceInterfaces_ResourceInterface <em>Ancestor Resource Interfaces Resource Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ancestor Resource Interfaces Resource Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getAncestorResourceInterfaces_ResourceInterface()
	 * @see #getResourceInterface()
	 * @generated
	 */
	EReference getResourceInterface_AncestorResourceInterfaces_ResourceInterface();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getParentResourceInterface__ResourceInterface <em>Parent Resource Interface Resource Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Resource Interface Resource Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getParentResourceInterface__ResourceInterface()
	 * @see #getResourceInterface()
	 * @generated
	 */
	EReference getResourceInterface_ParentResourceInterface__ResourceInterface();

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
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getResourceInterface_ResourceService <em>Resource Interface Resource Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Interface Resource Service</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getResourceInterface_ResourceService()
	 * @see #getResourceService()
	 * @generated
	 */
	EReference getResourceService_ResourceInterface_ResourceService();

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
		 * The meta object literal for the '<em><b>Available Controller Stacks Resource Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY = eINSTANCE.getResourceRepository_AvailableControllerStacks_ResourceRepository();

		/**
		 * The meta object literal for the '<em><b>Available Controller Types Resource Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY = eINSTANCE.getResourceRepository_AvailableControllerTypes_ResourceRepository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerStackImpl <em>Controller Stack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerStackImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getControllerStack()
		 * @generated
		 */
		EClass CONTROLLER_STACK = eINSTANCE.getControllerStack();

		/**
		 * The meta object literal for the '<em><b>Controller Layers Controller Stack</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROLLER_STACK__CONTROLLER_LAYERS_CONTROLLER_STACK = eINSTANCE.getControllerStack_ControllerLayers_ControllerStack();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl <em>Controller Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getControllerLayer()
		 * @generated
		 */
		EClass CONTROLLER_LAYER = eINSTANCE.getControllerLayer();

		/**
		 * The meta object literal for the '<em><b>Upper Layer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROLLER_LAYER__UPPER_LAYER = eINSTANCE.getControllerLayer_UpperLayer();

		/**
		 * The meta object literal for the '<em><b>Lower Layer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROLLER_LAYER__LOWER_LAYER = eINSTANCE.getControllerLayer_LowerLayer();

		/**
		 * The meta object literal for the '<em><b>Controller Type Controller Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_SCOPE = eINSTANCE.getControllerLayer_ControllerType_ControllerScope();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerTypeImpl <em>Controller Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerTypeImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getControllerType()
		 * @generated
		 */
		EClass CONTROLLER_TYPE = eINSTANCE.getControllerType();

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
		 * The meta object literal for the '<em><b>Ancestor Resource Interfaces Resource Interface</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INTERFACE__ANCESTOR_RESOURCE_INTERFACES_RESOURCE_INTERFACE = eINSTANCE.getResourceInterface_AncestorResourceInterfaces_ResourceInterface();

		/**
		 * The meta object literal for the '<em><b>Parent Resource Interface Resource Interface</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INTERFACE__PARENT_RESOURCE_INTERFACE_RESOURCE_INTERFACE = eINSTANCE.getResourceInterface_ParentResourceInterface__ResourceInterface();

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
		 * The meta object literal for the '<em><b>Resource Interface Resource Service</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_SERVICE__RESOURCE_INTERFACE_RESOURCE_SERVICE = eINSTANCE.getResourceService_ResourceInterface_ResourceService();

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
