/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Repository/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.repository";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RepositoryPackage eINSTANCE = de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl <em>Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getSignature()
	 * @generated
	 */
	int SIGNATURE = 0;

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
	 * The feature id for the '<em><b>Returntype Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__RETURNTYPE_SIGNATURE = 2;

	/**
	 * The feature id for the '<em><b>Exceptions Signature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__EXCEPTIONS_SIGNATURE = 3;

	/**
	 * The number of structural features of the '<em>Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Datatype Parameter</b></em>' containment reference.
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
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Parent Data Type Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PARENT_DATA_TYPE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl <em>Exception Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ExceptionTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getExceptionType()
	 * @generated
	 */
	int EXCEPTION_TYPE = 3;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RoleImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 4;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl <em>Required Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRequiredRole()
	 * @generated
	 */
	int REQUIRED_ROLE = 5;

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
	 * The number of structural features of the '<em>Required Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 6;

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
	 * The feature id for the '<em><b>Anchestor Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ANCHESTOR_INTERFACES = EntityPackage.ENTITY_FEATURE_COUNT + 1;

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
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 7;

	/**
	 * The feature id for the '<em><b>Repository Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__REPOSITORY_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Repository Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__REPOSITORY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Components Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__COMPONENTS_REPOSITORY = 2;

	/**
	 * The feature id for the '<em><b>Interfaces Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__INTERFACES_REPOSITORY = 3;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl <em>Provides Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getProvidesComponentType()
	 * @generated
	 */
	int PROVIDES_COMPONENT_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Provides Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_COMPONENT_TYPE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl <em>Provided Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getProvidedRole()
	 * @generated
	 */
	int PROVIDED_ROLE = 9;

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
	 * The feature id for the '<em><b>Providing Component Provided Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE = ROLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Provided Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl <em>Complete Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompleteComponentType()
	 * @generated
	 */
	int COMPLETE_COMPONENT_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__ID = PROVIDES_COMPONENT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__ENTITY_NAME = PROVIDES_COMPONENT_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE = PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Required Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE = PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Provides Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES = PROVIDES_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complete Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_COMPONENT_TYPE_FEATURE_COUNT = PROVIDES_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl <em>Implementation Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getImplementationComponentType()
	 * @generated
	 */
	int IMPLEMENTATION_COMPONENT_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__ID = COMPLETE_COMPONENT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__ENTITY_NAME = COMPLETE_COMPONENT_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE = COMPLETE_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Required Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE = COMPLETE_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Provides Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES = COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES;

	/**
	 * The feature id for the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES = COMPLETE_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Implementation Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT = COMPLETE_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompositeComponent()
	 * @generated
	 */
	int COMPOSITE_COMPONENT = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ID = IMPLEMENTATION_COMPONENT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ENTITY_NAME = IMPLEMENTATION_COMPONENT_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE = IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Required Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE = IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Provides Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES = IMPLEMENTATION_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES;

	/**
	 * The feature id for the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES = IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;

	/**
	 * The feature id for the '<em><b>Child Component Contexts Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Composite Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Implementation Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT_FEATURE_COUNT = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl <em>Basic Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getBasicComponent()
	 * @generated
	 */
	int BASIC_COMPONENT = 13;

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
	 * The feature id for the '<em><b>Provided Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE = IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Required Roles Provides Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE = IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Provides Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES = IMPLEMENTATION_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES;

	/**
	 * The feature id for the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES = IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;

	/**
	 * The feature id for the '<em><b>Implementation Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Effect Specifications Basic Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Basic Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT_FEATURE_COUNT = IMPLEMENTATION_COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl <em>Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getDelegationConnector()
	 * @generated
	 */
	int DELEGATION_CONNECTOR = 14;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.repository.ParameterModifier <em>Parameter Modifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.repository.ParameterModifier
	 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameterModifier()
	 * @generated
	 */
	int PARAMETER_MODIFIER = 15;


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
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.repository.Signature#getReturntype__Signature <em>Returntype Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Returntype Signature</em>'.
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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getDatatype__Parameter <em>Datatype Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Datatype Parameter</em>'.
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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.DataType#getParentDataType__DataType <em>Parent Data Type Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Data Type Data Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.DataType#getParentDataType__DataType()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_ParentDataType__DataType();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.DataType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.DataType#getType()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Type();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Role
	 * @generated
	 */
	EClass getRole();

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
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.repository.Interface#getAnchestorInterfaces <em>Anchestor Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Anchestor Interfaces</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getAnchestorInterfaces()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_AnchestorInterfaces();

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
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryName <em>Repository Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_RepositoryName();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType <em>Provides Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provides Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidesComponentType
	 * @generated
	 */
	EClass getProvidesComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getProvidedRoles__ProvidesComponentType <em>Provided Roles Provides Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Roles Provides Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getProvidedRoles__ProvidesComponentType()
	 * @see #getProvidesComponentType()
	 * @generated
	 */
	EReference getProvidesComponentType_ProvidedRoles__ProvidesComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getRequiredRoles_ProvidesComponentType <em>Required Roles Provides Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Roles Provides Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getRequiredRoles_ProvidesComponentType()
	 * @see #getProvidesComponentType()
	 * @generated
	 */
	EReference getProvidesComponentType_RequiredRoles_ProvidesComponentType();

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
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingComponent__ProvidedRole <em>Providing Component Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Providing Component Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingComponent__ProvidedRole()
	 * @see #getProvidedRole()
	 * @generated
	 */
	EReference getProvidedRole_ProvidingComponent__ProvidedRole();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompositeComponent
	 * @generated
	 */
	EClass getCompositeComponent();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getImplementationComponentType <em>Implementation Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.CompositeComponent#getImplementationComponentType()
	 * @see #getCompositeComponent()
	 * @generated
	 */
	EReference getCompositeComponent_ImplementationComponentType();

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
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.repository.BasicComponent#getImplementationComponentType <em>Implementation Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Component Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.BasicComponent#getImplementationComponentType()
	 * @see #getBasicComponent()
	 * @generated
	 */
	EReference getBasicComponent_ImplementationComponentType();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.repository.DelegationConnector <em>Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.repository.DelegationConnector
	 * @generated
	 */
	EClass getDelegationConnector();

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
	interface Literals  {
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
		 * The meta object literal for the '<em><b>Returntype Signature</b></em>' containment reference feature.
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Datatype Parameter</b></em>' containment reference feature.
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Parent Data Type Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__PARENT_DATA_TYPE_DATA_TYPE = eINSTANCE.getDataType_ParentDataType__DataType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__TYPE = eINSTANCE.getDataType_Type();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RoleImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

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
		 * The meta object literal for the '<em><b>Anchestor Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__ANCHESTOR_INTERFACES = eINSTANCE.getInterface_AnchestorInterfaces();

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
		 * The meta object literal for the '<em><b>Repository Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__REPOSITORY_NAME = eINSTANCE.getRepository_RepositoryName();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl <em>Provides Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getProvidesComponentType()
		 * @generated
		 */
		EClass PROVIDES_COMPONENT_TYPE = eINSTANCE.getProvidesComponentType();

		/**
		 * The meta object literal for the '<em><b>Provided Roles Provides Component Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE = eINSTANCE.getProvidesComponentType_ProvidedRoles__ProvidesComponentType();

		/**
		 * The meta object literal for the '<em><b>Required Roles Provides Component Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE = eINSTANCE.getProvidesComponentType_RequiredRoles_ProvidesComponentType();

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
		 * The meta object literal for the '<em><b>Providing Component Provided Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE = eINSTANCE.getProvidedRole_ProvidingComponent__ProvidedRole();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getCompositeComponent()
		 * @generated
		 */
		EClass COMPOSITE_COMPONENT = eINSTANCE.getCompositeComponent();

		/**
		 * The meta object literal for the '<em><b>Implementation Component Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE = eINSTANCE.getCompositeComponent_ImplementationComponentType();

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
		 * The meta object literal for the '<em><b>Implementation Component Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE = eINSTANCE.getBasicComponent_ImplementationComponentType();

		/**
		 * The meta object literal for the '<em><b>Service Effect Specifications Basic Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT = eINSTANCE.getBasicComponent_ServiceEffectSpecifications__BasicComponent();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.repository.ParameterModifier <em>Parameter Modifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.repository.ParameterModifier
		 * @see de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl#getParameterModifier()
		 * @generated
		 */
		EEnum PARAMETER_MODIFIER = eINSTANCE.getParameterModifier();

	}

} //RepositoryPackage
