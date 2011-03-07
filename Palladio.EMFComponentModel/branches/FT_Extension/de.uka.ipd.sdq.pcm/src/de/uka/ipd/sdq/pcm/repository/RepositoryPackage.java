/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
 * <!-- begin-model-doc -->
 * The main package contributing component types and interfaces.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryFactory
 * @model kind="package"
 * @generated
 */
public interface RepositoryPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "repository";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Repository/4.0";

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
	RepositoryPackage eINSTANCE = de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getPassiveResource()
	 * @generated
	 */
	int PASSIVE_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Capacity Passive Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Passive Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl <em>Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getSignature()
	 * @generated
	 */
	int SIGNATURE = 1;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__SERVICE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Parameters Signature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__PARAMETERS_SIGNATURE = 1;

	/**
	 * The feature id for the '<em><b>Interface Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__INTERFACE_SIGNATURE = 2;

	/**
	 * The feature id for the '<em><b>Returntype Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__RETURNTYPE_SIGNATURE = 3;

	/**
	 * The feature id for the '<em><b>Exceptions Signature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__EXCEPTIONS_SIGNATURE = 4;

	/**
	 * The feature id for the '<em><b>Failure Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__FAILURE_TYPES = 5;

	/**
	 * The number of structural features of the '<em>Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Datatype Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DATATYPE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PARAMETER_NAME = 1;

	/**
	 * The feature id for the '<em><b>Modifier Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MODIFIER_PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Signature Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__SIGNATURE_PARAMETER = 3;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Repository Data Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__REPOSITORY_DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl <em>Provides Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getProvidesComponentType()
	 * @generated
	 */
	int PROVIDES_COMPONENT_TYPE = 13;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RoleImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl <em>Required Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRequiredRole()
	 * @generated
	 */
	int REQUIRED_ROLE = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl <em>Exception Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getExceptionType()
	 * @generated
	 */
	int EXCEPTION_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__REPOSITORY_DESCRIPTION = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__COMPONENTS_REPOSITORY = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interfaces Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__INTERFACES_REPOSITORY = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Failuretype</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__FAILURETYPE = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Datatypes Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DATATYPES_REPOSITORY = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryComponentImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRepositoryComponent()
	 * @generated
	 */
	int REPOSITORY_COMPONENT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_COMPONENT__ID = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_COMPONENT__ENTITY_NAME = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_COMPONENT__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Repository Repository Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_COMPONENT_FEATURE_COUNT = EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl <em>Complete Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompleteComponentType()
	 * @generated
	 */
	int COMPLETE_COMPONENT_TYPE = 15;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl <em>Implementation Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getImplementationComponentType()
	 * @generated
	 */
	int IMPLEMENTATION_COMPONENT_TYPE = 14;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl <em>Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getDelegationConnector()
	 * @generated
	 */
	int DELEGATION_CONNECTOR = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_ROLE__ID = ROLE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_ROLE__ENTITY_NAME = ROLE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Required Interface Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE = ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Requiring Entity Required Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE = ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Required Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Interface Interface</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PARENT_INTERFACE_INTERFACE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ancestor Interfaces Interface</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ANCESTOR_INTERFACES_INTERFACE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Protocols Interface</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PROTOCOLS_INTERFACE = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Signatures Interface</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__SIGNATURES_INTERFACE = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Repository Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REPOSITORY_INTERFACE = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Required Characterisations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REQUIRED_CHARACTERISATIONS = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl <em>Required Characterisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRequiredCharacterisation()
	 * @generated
	 */
	int REQUIRED_CHARACTERISATION = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CHARACTERISATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CHARACTERISATION__PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Required Characterisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CHARACTERISATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl <em>Resource Required Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getResourceRequiredRole()
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
	int RESOURCE_REQUIRED_ROLE__ID = ROLE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE__ENTITY_NAME = ROLE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Required Interface Resource Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE = ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Requiring Entity Resource Required Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE = ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Required Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.FailureTypeImpl <em>Failure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.FailureTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getFailureType()
	 * @generated
	 */
	int FAILURE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__REPOSITORY = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Failure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exception Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_TYPE__EXCEPTION_NAME = 0;

	/**
	 * The feature id for the '<em><b>Exception Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_TYPE__EXCEPTION_MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>Exception Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_TYPE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__ID = REPOSITORY_COMPONENT__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__ENTITY_NAME = REPOSITORY_COMPONENT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = REPOSITORY_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = REPOSITORY_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = REPOSITORY_COMPONENT__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Repository Repository Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT = REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;

	/**
	 * The number of structural features of the '<em>Provides Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE_FEATURE_COUNT = REPOSITORY_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__ID = REPOSITORY_COMPONENT__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__ENTITY_NAME = REPOSITORY_COMPONENT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = REPOSITORY_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = REPOSITORY_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = REPOSITORY_COMPONENT__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Repository Repository Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT = REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;

	/**
	 * The feature id for the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES = REPOSITORY_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component Parameter Usage Implementation Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE = REPOSITORY_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Implementation Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT = REPOSITORY_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__ID = REPOSITORY_COMPONENT__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__ENTITY_NAME = REPOSITORY_COMPONENT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = REPOSITORY_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = REPOSITORY_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = REPOSITORY_COMPONENT__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Repository Repository Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT = REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;

	/**
	 * The feature id for the '<em><b>Parent Provides Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES = REPOSITORY_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complete Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE_FEATURE_COUNT = REPOSITORY_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION_CONNECTOR__ID = ConnectorsPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION_CONNECTOR__ENTITY_NAME = ConnectorsPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION_CONNECTOR_FEATURE_COUNT = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompositeComponent()
	 * @generated
	 */
	int COMPOSITE_COMPONENT = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ID = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ENTITY_NAME = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Assembly Contexts Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Resource Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Repository Repository Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component Parameter Usage Implementation Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT_FEATURE_COUNT = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl <em>Basic Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getBasicComponent()
	 * @generated
	 */
	int BASIC_COMPONENT = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__ID = IMPLEMENTATION_COMPONENT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__ENTITY_NAME = IMPLEMENTATION_COMPONENT_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = IMPLEMENTATION_COMPONENT_TYPE__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Repository Repository Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT = IMPLEMENTATION_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT;

	/**
	 * The feature id for the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES = IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;

	/**
	 * The feature id for the '<em><b>Component Parameter Usage Implementation Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE = IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Service Effect Specifications Basic Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Passive Resource Basic Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__PASSIVE_RESOURCE_BASIC_COMPONENT = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Basic Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT_FEATURE_COUNT = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.PrimitiveDataTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getPrimitiveDataType()
	 * @generated
	 */
	int PRIMITIVE_DATA_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Repository Data Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__REPOSITORY_DATA_TYPE = DATA_TYPE__REPOSITORY_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl <em>Collection Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCollectionDataType()
	 * @generated
	 */
	int COLLECTION_DATA_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository Data Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inner Type Collection Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl <em>Composite Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompositeDataType()
	 * @generated
	 */
	int COMPOSITE_DATA_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_TYPE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_TYPE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository Data Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Type Composite Data Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inner Declaration Composite Data Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_TYPE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl <em>Inner Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getInnerDeclaration()
	 * @generated
	 */
	int INNER_DECLARATION = 22;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_DECLARATION__ENTITY_NAME = EntityPackage.NAMED_ELEMENT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Datatype Inner Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_DECLARATION__DATATYPE_INNER_DECLARATION = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inner Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_DECLARATION_FEATURE_COUNT = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.StopFailureTypeImpl <em>Stop Failure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.StopFailureTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getStopFailureType()
	 * @generated
	 */
	int STOP_FAILURE_TYPE = 23;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_FAILURE_TYPE__ID = FAILURE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_FAILURE_TYPE__ENTITY_NAME = FAILURE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_FAILURE_TYPE__REPOSITORY = FAILURE_TYPE__REPOSITORY;

	/**
	 * The number of structural features of the '<em>Stop Failure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_FAILURE_TYPE_FEATURE_COUNT = FAILURE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ApplicationFailureTypeImpl <em>Application Failure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ApplicationFailureTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getApplicationFailureType()
	 * @generated
	 */
	int APPLICATION_FAILURE_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FAILURE_TYPE__ID = STOP_FAILURE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FAILURE_TYPE__ENTITY_NAME = STOP_FAILURE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FAILURE_TYPE__REPOSITORY = STOP_FAILURE_TYPE__REPOSITORY;

	/**
	 * The number of structural features of the '<em>Application Failure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FAILURE_TYPE_FEATURE_COUNT = STOP_FAILURE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.EnvironmentFailureTypeImpl <em>Environment Failure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.EnvironmentFailureTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getEnvironmentFailureType()
	 * @generated
	 */
	int ENVIRONMENT_FAILURE_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FAILURE_TYPE__ID = STOP_FAILURE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FAILURE_TYPE__ENTITY_NAME = STOP_FAILURE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FAILURE_TYPE__REPOSITORY = STOP_FAILURE_TYPE__REPOSITORY;

	/**
	 * The feature id for the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE = STOP_FAILURE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Environment Failure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FAILURE_TYPE_FEATURE_COUNT = STOP_FAILURE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl <em>Provided Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getProvidedRole()
	 * @generated
	 */
	int PROVIDED_ROLE = 26;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_ROLE__ID = ROLE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_ROLE__ENTITY_NAME = ROLE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Interface Provided Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE = ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Providing Entity Provided Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE = ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Provided Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.ParameterModifier <em>Parameter Modifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.ParameterModifier
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameterModifier()
	 * @generated
	 */
	int PARAMETER_MODIFIER = 27;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getPrimitiveTypeEnum()
	 * @generated
	 */
	int PRIMITIVE_TYPE_ENUM = 28;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.PassiveResource <em>Passive Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.PassiveResource
	 * @generated
	 */
	EClass getPassiveResource();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getCapacity_PassiveResource <em>Capacity Passive Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capacity Passive Resource</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.PassiveResource#getCapacity_PassiveResource()
	 * @see #getPassiveResource()
	 * @generated
	 */
	EReference getPassiveResource_Capacity_PassiveResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.Signature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signature</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Signature
	 * @generated
	 */
	EClass getSignature();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.Signature#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Signature#getServiceName()
	 * @see #getSignature()
	 * @generated
	 */
	EAttribute getSignature_ServiceName();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Signature#getParameters__Signature <em>Parameters Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters Signature</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Signature#getParameters__Signature()
	 * @see #getSignature()
	 * @generated
	 */
	EReference getSignature_Parameters__Signature();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.Signature#getInterface_Signature <em>Interface Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interface Signature</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Signature#getInterface_Signature()
	 * @see #getSignature()
	 * @generated
	 */
	EReference getSignature_Interface_Signature();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.Signature#getReturntype__Signature <em>Returntype Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Returntype Signature</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Signature#getReturntype__Signature()
	 * @see #getSignature()
	 * @generated
	 */
	EReference getSignature_Returntype__Signature();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Signature#getExceptions__Signature <em>Exceptions Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions Signature</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Signature#getExceptions__Signature()
	 * @see #getSignature()
	 * @generated
	 */
	EReference getSignature_Exceptions__Signature();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.repository.Signature#getFailureTypes <em>Failure Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Failure Types</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Signature#getFailureTypes()
	 * @see #getSignature()
	 * @generated
	 */
	EReference getSignature_FailureTypes();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getDatatype__Parameter <em>Datatype Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datatype Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter#getDatatype__Parameter()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Datatype__Parameter();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter#getParameterName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_ParameterName();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getModifier__Parameter <em>Modifier Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifier Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter#getModifier__Parameter()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Modifier__Parameter();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getSignature_Parameter <em>Signature Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Signature Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter#getSignature_Parameter()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Signature_Parameter();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.DataType#getRepository_DataType <em>Repository Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.DataType#getRepository_DataType()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Repository_DataType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryDescription <em>Repository Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Description</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryDescription()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_RepositoryDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository <em>Components Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Components__Repository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository <em>Interfaces Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interfaces Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Interfaces__Repository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Repository#getFailuretype <em>Failuretype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failuretype</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getFailuretype()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Failuretype();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Repository#getDatatypes_Repository <em>Datatypes Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Datatypes Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getDatatypes_Repository()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Datatypes_Repository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.RepositoryComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryComponent
	 * @generated
	 */
	EClass getRepositoryComponent();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.RepositoryComponent#getRepository_RepositoryComponent <em>Repository Repository Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository Repository Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryComponent#getRepository_RepositoryComponent()
	 * @see #getRepositoryComponent()
	 * @generated
	 */
	EReference getRepositoryComponent_Repository_RepositoryComponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType <em>Provides Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provides Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidesComponentType
	 * @generated
	 */
	EClass getProvidesComponentType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.RequiredRole <em>Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RequiredRole
	 * @generated
	 */
	EClass getRequiredRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiredInterface__RequiredRole <em>Required Interface Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Interface Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiredInterface__RequiredRole()
	 * @see #getRequiredRole()
	 * @generated
	 */
	EReference getRequiredRole_RequiredInterface__RequiredRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiringEntity_RequiredRole <em>Requiring Entity Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requiring Entity Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiringEntity_RequiredRole()
	 * @see #getRequiredRole()
	 * @generated
	 */
	EReference getRequiredRole_RequiringEntity_RequiredRole();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.repository.Interface#getParentInterface__Interface <em>Parent Interface Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Interface Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getParentInterface__Interface()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_ParentInterface__Interface();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.repository.Interface#getAncestorInterfaces_Interface <em>Ancestor Interfaces Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ancestor Interfaces Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getAncestorInterfaces_Interface()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_AncestorInterfaces_Interface();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Interface#getProtocols__Interface <em>Protocols Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protocols Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getProtocols__Interface()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Protocols__Interface();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Interface#getSignatures__Interface <em>Signatures Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signatures Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getSignatures__Interface()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Signatures__Interface();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.Interface#getRepository_Interface <em>Repository Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository Interface</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getRepository_Interface()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Repository_Interface();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.Interface#getRequiredCharacterisations <em>Required Characterisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Characterisations</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getRequiredCharacterisations()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_RequiredCharacterisations();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation <em>Required Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation
	 * @generated
	 */
	EClass getRequiredCharacterisation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation#getType()
	 * @see #getRequiredCharacterisation()
	 * @generated
	 */
	EAttribute getRequiredCharacterisation_Type();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation#getParameter()
	 * @see #getRequiredCharacterisation()
	 * @generated
	 */
	EReference getRequiredCharacterisation_Parameter();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole <em>Resource Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole
	 * @generated
	 */
	EClass getResourceRequiredRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getRequiredInterface_ResourceRequiredRole <em>Required Interface Resource Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Interface Resource Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getRequiredInterface_ResourceRequiredRole()
	 * @see #getResourceRequiredRole()
	 * @generated
	 */
	EReference getResourceRequiredRole_RequiredInterface_ResourceRequiredRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Requiring Entity Resource Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole()
	 * @see #getResourceRequiredRole()
	 * @generated
	 */
	EReference getResourceRequiredRole_ResourceRequiringEntity_ResourceRequiredRole();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.FailureType <em>Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.FailureType
	 * @generated
	 */
	EClass getFailureType();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.FailureType#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.FailureType#getRepository()
	 * @see #getFailureType()
	 * @generated
	 */
	EReference getFailureType_Repository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.ExceptionType <em>Exception Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ExceptionType
	 * @generated
	 */
	EClass getExceptionType();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionName <em>Exception Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionName()
	 * @see #getExceptionType()
	 * @generated
	 */
	EAttribute getExceptionType_ExceptionName();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionMessage <em>Exception Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Message</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionMessage()
	 * @see #getExceptionType()
	 * @generated
	 */
	EAttribute getExceptionType_ExceptionMessage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.ImplementationComponentType <em>Implementation Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ImplementationComponentType
	 * @generated
	 */
	EClass getImplementationComponentType();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Complete Component Types</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getParentCompleteComponentTypes()
	 * @see #getImplementationComponentType()
	 * @generated
	 */
	EReference getImplementationComponentType_ParentCompleteComponentTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getComponentParameterUsage_ImplementationComponentType <em>Component Parameter Usage Implementation Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Parameter Usage Implementation Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getComponentParameterUsage_ImplementationComponentType()
	 * @see #getImplementationComponentType()
	 * @generated
	 */
	EReference getImplementationComponentType_ComponentParameterUsage_ImplementationComponentType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType <em>Complete Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompleteComponentType
	 * @generated
	 */
	EClass getCompleteComponentType();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType#getParentProvidesComponentTypes <em>Parent Provides Component Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Provides Component Types</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompleteComponentType#getParentProvidesComponentTypes()
	 * @see #getCompleteComponentType()
	 * @generated
	 */
	EReference getCompleteComponentType_ParentProvidesComponentTypes();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.DelegationConnector <em>Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.DelegationConnector
	 * @generated
	 */
	EClass getDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompositeComponent
	 * @generated
	 */
	EClass getCompositeComponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.BasicComponent <em>Basic Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.BasicComponent
	 * @generated
	 */
	EClass getBasicComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.BasicComponent#getServiceEffectSpecifications__BasicComponent <em>Service Effect Specifications Basic Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Effect Specifications Basic Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.BasicComponent#getServiceEffectSpecifications__BasicComponent()
	 * @see #getBasicComponent()
	 * @generated
	 */
	EReference getBasicComponent_ServiceEffectSpecifications__BasicComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.BasicComponent#getPassiveResource_BasicComponent <em>Passive Resource Basic Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Passive Resource Basic Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.BasicComponent#getPassiveResource_BasicComponent()
	 * @see #getBasicComponent()
	 * @generated
	 */
	EReference getBasicComponent_PassiveResource_BasicComponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.PrimitiveDataType <em>Primitive Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.PrimitiveDataType
	 * @generated
	 */
	EClass getPrimitiveDataType();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.PrimitiveDataType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.PrimitiveDataType#getType()
	 * @see #getPrimitiveDataType()
	 * @generated
	 */
	EAttribute getPrimitiveDataType_Type();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.CollectionDataType <em>Collection Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CollectionDataType
	 * @generated
	 */
	EClass getCollectionDataType();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.CollectionDataType#getInnerType_CollectionDataType <em>Inner Type Collection Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Type Collection Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CollectionDataType#getInnerType_CollectionDataType()
	 * @see #getCollectionDataType()
	 * @generated
	 */
	EReference getCollectionDataType_InnerType_CollectionDataType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType <em>Composite Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompositeDataType
	 * @generated
	 */
	EClass getCompositeDataType();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getParentType_CompositeDataType <em>Parent Type Composite Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Type Composite Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompositeDataType#getParentType_CompositeDataType()
	 * @see #getCompositeDataType()
	 * @generated
	 */
	EReference getCompositeDataType_ParentType_CompositeDataType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getInnerDeclaration_CompositeDataType <em>Inner Declaration Composite Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner Declaration Composite Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompositeDataType#getInnerDeclaration_CompositeDataType()
	 * @see #getCompositeDataType()
	 * @generated
	 */
	EReference getCompositeDataType_InnerDeclaration_CompositeDataType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration <em>Inner Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inner Declaration</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.InnerDeclaration
	 * @generated
	 */
	EClass getInnerDeclaration();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration#getDatatype_InnerDeclaration <em>Datatype Inner Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datatype Inner Declaration</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.InnerDeclaration#getDatatype_InnerDeclaration()
	 * @see #getInnerDeclaration()
	 * @generated
	 */
	EReference getInnerDeclaration_Datatype_InnerDeclaration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.StopFailureType <em>Stop Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Failure Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.StopFailureType
	 * @generated
	 */
	EClass getStopFailureType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.ApplicationFailureType <em>Application Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Failure Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ApplicationFailureType
	 * @generated
	 */
	EClass getApplicationFailureType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType <em>Environment Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment Failure Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType
	 * @generated
	 */
	EClass getEnvironmentFailureType();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType#getProcessingresourcetype <em>Processingresourcetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processingresourcetype</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType#getProcessingresourcetype()
	 * @see #getEnvironmentFailureType()
	 * @generated
	 */
	EReference getEnvironmentFailureType_Processingresourcetype();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole <em>Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidedRole
	 * @generated
	 */
	EClass getProvidedRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidedInterface__ProvidedRole <em>Provided Interface Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Interface Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidedInterface__ProvidedRole()
	 * @see #getProvidedRole()
	 * @generated
	 */
	EReference getProvidedRole_ProvidedInterface__ProvidedRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity_ProvidedRole <em>Providing Entity Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Providing Entity Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity_ProvidedRole()
	 * @see #getProvidedRole()
	 * @generated
	 */
	EReference getProvidedRole_ProvidingEntity_ProvidedRole();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.repository.ParameterModifier <em>Parameter Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter Modifier</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ParameterModifier
	 * @generated
	 */
	EEnum getParameterModifier();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum <em>Primitive Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type Enum</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
	 * @generated
	 */
	EEnum getPrimitiveTypeEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RepositoryFactory getRepositoryFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getPassiveResource()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE = eINSTANCE.getPassiveResource();

		/**
		 * The meta object literal for the '<em><b>Capacity Passive Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE = eINSTANCE.getPassiveResource_Capacity_PassiveResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl <em>Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getSignature()
		 * @generated
		 */
		EClass SIGNATURE = eINSTANCE.getSignature();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNATURE__SERVICE_NAME = eINSTANCE.getSignature_ServiceName();

		/**
		 * The meta object literal for the '<em><b>Parameters Signature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE__PARAMETERS_SIGNATURE = eINSTANCE.getSignature_Parameters__Signature();

		/**
		 * The meta object literal for the '<em><b>Interface Signature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE__INTERFACE_SIGNATURE = eINSTANCE.getSignature_Interface_Signature();

		/**
		 * The meta object literal for the '<em><b>Returntype Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE__RETURNTYPE_SIGNATURE = eINSTANCE.getSignature_Returntype__Signature();

		/**
		 * The meta object literal for the '<em><b>Exceptions Signature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE__EXCEPTIONS_SIGNATURE = eINSTANCE.getSignature_Exceptions__Signature();

		/**
		 * The meta object literal for the '<em><b>Failure Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE__FAILURE_TYPES = eINSTANCE.getSignature_FailureTypes();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Datatype Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__DATATYPE_PARAMETER = eINSTANCE.getParameter_Datatype__Parameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__PARAMETER_NAME = eINSTANCE.getParameter_ParameterName();

		/**
		 * The meta object literal for the '<em><b>Modifier Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__MODIFIER_PARAMETER = eINSTANCE.getParameter_Modifier__Parameter();

		/**
		 * The meta object literal for the '<em><b>Signature Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__SIGNATURE_PARAMETER = eINSTANCE.getParameter_Signature_Parameter();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Repository Data Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__REPOSITORY_DATA_TYPE = eINSTANCE.getDataType_Repository_DataType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Repository Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__REPOSITORY_DESCRIPTION = eINSTANCE.getRepository_RepositoryDescription();

		/**
		 * The meta object literal for the '<em><b>Components Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__COMPONENTS_REPOSITORY = eINSTANCE.getRepository_Components__Repository();

		/**
		 * The meta object literal for the '<em><b>Interfaces Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__INTERFACES_REPOSITORY = eINSTANCE.getRepository_Interfaces__Repository();

		/**
		 * The meta object literal for the '<em><b>Failuretype</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__FAILURETYPE = eINSTANCE.getRepository_Failuretype();

		/**
		 * The meta object literal for the '<em><b>Datatypes Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__DATATYPES_REPOSITORY = eINSTANCE.getRepository_Datatypes_Repository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryComponentImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRepositoryComponent()
		 * @generated
		 */
		EClass REPOSITORY_COMPONENT = eINSTANCE.getRepositoryComponent();

		/**
		 * The meta object literal for the '<em><b>Repository Repository Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT = eINSTANCE.getRepositoryComponent_Repository_RepositoryComponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl <em>Provides Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getProvidesComponentType()
		 * @generated
		 */
		EClass PROVIDES_COMPONENT_TYPE = eINSTANCE.getProvidesComponentType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl <em>Required Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRequiredRole()
		 * @generated
		 */
		EClass REQUIRED_ROLE = eINSTANCE.getRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Required Interface Required Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE = eINSTANCE.getRequiredRole_RequiredInterface__RequiredRole();

		/**
		 * The meta object literal for the '<em><b>Requiring Entity Required Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE = eINSTANCE.getRequiredRole_RequiringEntity_RequiredRole();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RoleImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Parent Interface Interface</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PARENT_INTERFACE_INTERFACE = eINSTANCE.getInterface_ParentInterface__Interface();

		/**
		 * The meta object literal for the '<em><b>Ancestor Interfaces Interface</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__ANCESTOR_INTERFACES_INTERFACE = eINSTANCE.getInterface_AncestorInterfaces_Interface();

		/**
		 * The meta object literal for the '<em><b>Protocols Interface</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PROTOCOLS_INTERFACE = eINSTANCE.getInterface_Protocols__Interface();

		/**
		 * The meta object literal for the '<em><b>Signatures Interface</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__SIGNATURES_INTERFACE = eINSTANCE.getInterface_Signatures__Interface();

		/**
		 * The meta object literal for the '<em><b>Repository Interface</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REPOSITORY_INTERFACE = eINSTANCE.getInterface_Repository_Interface();

		/**
		 * The meta object literal for the '<em><b>Required Characterisations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REQUIRED_CHARACTERISATIONS = eINSTANCE.getInterface_RequiredCharacterisations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl <em>Required Characterisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRequiredCharacterisation()
		 * @generated
		 */
		EClass REQUIRED_CHARACTERISATION = eINSTANCE.getRequiredCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRED_CHARACTERISATION__TYPE = eINSTANCE.getRequiredCharacterisation_Type();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRED_CHARACTERISATION__PARAMETER = eINSTANCE.getRequiredCharacterisation_Parameter();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl <em>Resource Required Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getResourceRequiredRole()
		 * @generated
		 */
		EClass RESOURCE_REQUIRED_ROLE = eINSTANCE.getResourceRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Required Interface Resource Required Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE = eINSTANCE.getResourceRequiredRole_RequiredInterface_ResourceRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Resource Requiring Entity Resource Required Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE = eINSTANCE.getResourceRequiredRole_ResourceRequiringEntity_ResourceRequiredRole();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.FailureTypeImpl <em>Failure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.FailureTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getFailureType()
		 * @generated
		 */
		EClass FAILURE_TYPE = eINSTANCE.getFailureType();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_TYPE__REPOSITORY = eINSTANCE.getFailureType_Repository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl <em>Exception Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getExceptionType()
		 * @generated
		 */
		EClass EXCEPTION_TYPE = eINSTANCE.getExceptionType();

		/**
		 * The meta object literal for the '<em><b>Exception Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION_TYPE__EXCEPTION_NAME = eINSTANCE.getExceptionType_ExceptionName();

		/**
		 * The meta object literal for the '<em><b>Exception Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION_TYPE__EXCEPTION_MESSAGE = eINSTANCE.getExceptionType_ExceptionMessage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl <em>Implementation Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getImplementationComponentType()
		 * @generated
		 */
		EClass IMPLEMENTATION_COMPONENT_TYPE = eINSTANCE.getImplementationComponentType();

		/**
		 * The meta object literal for the '<em><b>Parent Complete Component Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES = eINSTANCE.getImplementationComponentType_ParentCompleteComponentTypes();

		/**
		 * The meta object literal for the '<em><b>Component Parameter Usage Implementation Component Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE = eINSTANCE.getImplementationComponentType_ComponentParameterUsage_ImplementationComponentType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl <em>Complete Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompleteComponentType()
		 * @generated
		 */
		EClass COMPLETE_COMPONENT_TYPE = eINSTANCE.getCompleteComponentType();

		/**
		 * The meta object literal for the '<em><b>Parent Provides Component Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES = eINSTANCE.getCompleteComponentType_ParentProvidesComponentTypes();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl <em>Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getDelegationConnector()
		 * @generated
		 */
		EClass DELEGATION_CONNECTOR = eINSTANCE.getDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompositeComponent()
		 * @generated
		 */
		EClass COMPOSITE_COMPONENT = eINSTANCE.getCompositeComponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl <em>Basic Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getBasicComponent()
		 * @generated
		 */
		EClass BASIC_COMPONENT = eINSTANCE.getBasicComponent();

		/**
		 * The meta object literal for the '<em><b>Service Effect Specifications Basic Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT = eINSTANCE.getBasicComponent_ServiceEffectSpecifications__BasicComponent();

		/**
		 * The meta object literal for the '<em><b>Passive Resource Basic Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_COMPONENT__PASSIVE_RESOURCE_BASIC_COMPONENT = eINSTANCE.getBasicComponent_PassiveResource_BasicComponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.PrimitiveDataTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getPrimitiveDataType()
		 * @generated
		 */
		EClass PRIMITIVE_DATA_TYPE = eINSTANCE.getPrimitiveDataType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_DATA_TYPE__TYPE = eINSTANCE.getPrimitiveDataType_Type();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl <em>Collection Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCollectionDataType()
		 * @generated
		 */
		EClass COLLECTION_DATA_TYPE = eINSTANCE.getCollectionDataType();

		/**
		 * The meta object literal for the '<em><b>Inner Type Collection Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE = eINSTANCE.getCollectionDataType_InnerType_CollectionDataType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl <em>Composite Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompositeDataType()
		 * @generated
		 */
		EClass COMPOSITE_DATA_TYPE = eINSTANCE.getCompositeDataType();

		/**
		 * The meta object literal for the '<em><b>Parent Type Composite Data Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE = eINSTANCE.getCompositeDataType_ParentType_CompositeDataType();

		/**
		 * The meta object literal for the '<em><b>Inner Declaration Composite Data Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE = eINSTANCE.getCompositeDataType_InnerDeclaration_CompositeDataType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl <em>Inner Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getInnerDeclaration()
		 * @generated
		 */
		EClass INNER_DECLARATION = eINSTANCE.getInnerDeclaration();

		/**
		 * The meta object literal for the '<em><b>Datatype Inner Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INNER_DECLARATION__DATATYPE_INNER_DECLARATION = eINSTANCE.getInnerDeclaration_Datatype_InnerDeclaration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.StopFailureTypeImpl <em>Stop Failure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.StopFailureTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getStopFailureType()
		 * @generated
		 */
		EClass STOP_FAILURE_TYPE = eINSTANCE.getStopFailureType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ApplicationFailureTypeImpl <em>Application Failure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ApplicationFailureTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getApplicationFailureType()
		 * @generated
		 */
		EClass APPLICATION_FAILURE_TYPE = eINSTANCE.getApplicationFailureType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.EnvironmentFailureTypeImpl <em>Environment Failure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.EnvironmentFailureTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getEnvironmentFailureType()
		 * @generated
		 */
		EClass ENVIRONMENT_FAILURE_TYPE = eINSTANCE.getEnvironmentFailureType();

		/**
		 * The meta object literal for the '<em><b>Processingresourcetype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE = eINSTANCE.getEnvironmentFailureType_Processingresourcetype();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl <em>Provided Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getProvidedRole()
		 * @generated
		 */
		EClass PROVIDED_ROLE = eINSTANCE.getProvidedRole();

		/**
		 * The meta object literal for the '<em><b>Provided Interface Provided Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE = eINSTANCE.getProvidedRole_ProvidedInterface__ProvidedRole();

		/**
		 * The meta object literal for the '<em><b>Providing Entity Provided Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE = eINSTANCE.getProvidedRole_ProvidingEntity_ProvidedRole();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.ParameterModifier <em>Parameter Modifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.ParameterModifier
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameterModifier()
		 * @generated
		 */
		EEnum PARAMETER_MODIFIER = eINSTANCE.getParameterModifier();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getPrimitiveTypeEnum()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE_ENUM = eINSTANCE.getPrimitiveTypeEnum();

	}

} //RepositoryPackage
