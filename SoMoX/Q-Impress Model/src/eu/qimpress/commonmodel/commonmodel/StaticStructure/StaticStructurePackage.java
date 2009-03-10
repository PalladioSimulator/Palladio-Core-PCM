/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;

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
 * <!-- begin-model-doc -->
 * The package StaticStructure defines Services, their Interfaces, and their Bindings. Is the main package of core metamodel defining static structure of applications.
 * 
 * <!-- end-model-doc -->
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructureFactory
 * @model kind="package"
 * @generated
 */
public interface StaticStructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StaticStructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CoreModel/StaticStructure.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CoreModel.StaticStructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StaticStructurePackage eINSTANCE = eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EntityImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ID = 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.NamedEntityImpl <em>Named Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.NamedEntityImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getNamedEntity()
	 * @generated
	 */
	int NAMED_ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ENTITY__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ENTITY__NAME = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentTypeImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__REQUIRED = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__PROVIDED = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__BEHAVIOUR = NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeStructureImpl <em>Composite Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeStructureImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getCompositeStructure()
	 * @generated
	 */
	int COMPOSITE_STRUCTURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE__ID = COMPONENT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE__NAME = COMPONENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE__REQUIRED = COMPONENT_TYPE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE__PROVIDED = COMPONENT_TYPE__PROVIDED;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE__BEHAVIOUR = COMPONENT_TYPE__BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>Subcomponents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE__SUBCOMPONENTS = COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE__CONNECTOR = COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRUCTURE_FEATURE_COUNT = COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PortImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getPort()
	 * @generated
	 */
	int PORT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = NAMED_ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.OperationImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__INPUT = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OUTPUT = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Throws Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__THROWS_EXCEPTIONS = NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.MessageImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__PARAMETERS = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ParameterImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.TypeImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getType()
	 * @generated
	 */
	int TYPE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = NAMED_ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ExceptionImpl <em>Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ExceptionImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Exception Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION__EXCEPTION_MESSAGE = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentInstanceImpl <em>Subcomponent Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentInstanceImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getSubcomponentInstance()
	 * @generated
	 */
	int SUBCOMPONENT_INSTANCE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBCOMPONENT_INSTANCE__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBCOMPONENT_INSTANCE__REALIZED_BY = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subcomponent Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBCOMPONENT_INSTANCE_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ConnectorImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Is Delegation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__IS_DELEGATION = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__ENDPOINTS = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EndPointImpl <em>End Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EndPointImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getEndPoint()
	 * @generated
	 */
	int END_POINT = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__ID = ENTITY__ID;

	/**
	 * The number of structural features of the '<em>End Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ServiceArchitectureModelImpl <em>Service Architecture Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ServiceArchitectureModelImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getServiceArchitectureModel()
	 * @generated
	 */
	int SERVICE_ARCHITECTURE_MODEL = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__ID = COMPOSITE_STRUCTURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__NAME = COMPOSITE_STRUCTURE__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__REQUIRED = COMPOSITE_STRUCTURE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__PROVIDED = COMPOSITE_STRUCTURE__PROVIDED;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__BEHAVIOUR = COMPOSITE_STRUCTURE__BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>Subcomponents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__SUBCOMPONENTS = COMPOSITE_STRUCTURE__SUBCOMPONENTS;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__CONNECTOR = COMPOSITE_STRUCTURE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Declared Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES = COMPOSITE_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL__SERVICE = COMPOSITE_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Architecture Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ARCHITECTURE_MODEL_FEATURE_COUNT = COMPOSITE_STRUCTURE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfaceImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Signatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__SIGNATURES = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__INHERITANCE = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentEndpointImpl <em>Subcomponent Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentEndpointImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getSubcomponentEndpoint()
	 * @generated
	 */
	int SUBCOMPONENT_ENDPOINT = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBCOMPONENT_ENDPOINT__ID = END_POINT__ID;

	/**
	 * The feature id for the '<em><b>Subcomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBCOMPONENT_ENDPOINT__SUBCOMPONENT = END_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBCOMPONENT_ENDPOINT__PORT = END_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Subcomponent Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBCOMPONENT_ENDPOINT_FEATURE_COUNT = END_POINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.RepositoryImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__ENTITIES = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentEndpointImpl <em>Component Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentEndpointImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getComponentEndpoint()
	 * @generated
	 */
	int COMPONENT_ENDPOINT = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENDPOINT__ID = END_POINT__ID;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENDPOINT__PORT = END_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ENDPOINT_FEATURE_COUNT = END_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveDataTypeImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getPrimitiveDataType()
	 * @generated
	 */
	int PRIMITIVE_DATA_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__ID = TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComplexDataTypeImpl <em>Complex Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComplexDataTypeImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getComplexDataType()
	 * @generated
	 */
	int COMPLEX_DATA_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DATA_TYPE__ID = TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DATA_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DATA_TYPE__ELEMENTS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DATA_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InnerElementImpl <em>Inner Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InnerElementImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getInnerElement()
	 * @generated
	 */
	int INNER_ELEMENT = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_ELEMENT__ID = NAMED_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_ELEMENT__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_ELEMENT__TYPE = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inner Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_ELEMENT_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeComponentImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getCompositeComponent()
	 * @generated
	 */
	int COMPOSITE_COMPONENT = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__ID = COMPOSITE_STRUCTURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__NAME = COMPOSITE_STRUCTURE__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__REQUIRED = COMPOSITE_STRUCTURE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PROVIDED = COMPOSITE_STRUCTURE__PROVIDED;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__BEHAVIOUR = COMPOSITE_STRUCTURE__BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>Subcomponents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__SUBCOMPONENTS = COMPOSITE_STRUCTURE__SUBCOMPONENTS;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__CONNECTOR = COMPOSITE_STRUCTURE__CONNECTOR;

	/**
	 * The number of structural features of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT_FEATURE_COUNT = COMPOSITE_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveComponentImpl <em>Primitive Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveComponentImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getPrimitiveComponent()
	 * @generated
	 */
	int PRIMITIVE_COMPONENT = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_COMPONENT__ID = COMPONENT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_COMPONENT__NAME = COMPONENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_COMPONENT__REQUIRED = COMPONENT_TYPE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_COMPONENT__PROVIDED = COMPONENT_TYPE__PROVIDED;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_COMPONENT__BEHAVIOUR = COMPONENT_TYPE__BEHAVIOUR;

	/**
	 * The number of structural features of the '<em>Primitive Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_COMPONENT_FEATURE_COUNT = COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EventPortImpl <em>Event Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EventPortImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getEventPort()
	 * @generated
	 */
	int EVENT_PORT = 23;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__ID = PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Is Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__IS_SOURCE = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__MESSAGE = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfacePortImpl <em>Interface Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfacePortImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getInterfacePort()
	 * @generated
	 */
	int INTERFACE_PORT = 24;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__ID = PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__TYPE = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CollectionDataTypeImpl <em>Collection Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CollectionDataTypeImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getCollectionDataType()
	 * @generated
	 */
	int COLLECTION_DATA_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE__ID = TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Innertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE__INNERTYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_DATA_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.FirstClassEntityImpl <em>First Class Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.FirstClassEntityImpl
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getFirstClassEntity()
	 * @generated
	 */
	int FIRST_CLASS_ENTITY = 26;

	/**
	 * The number of structural features of the '<em>First Class Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRST_CLASS_ENTITY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes <em>XSD Primitive Data Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getXSDPrimitiveDataTypes()
	 * @generated
	 */
	int XSD_PRIMITIVE_DATA_TYPES = 27;


	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure <em>Composite Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Structure</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure
	 * @generated
	 */
	EClass getCompositeStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure#getSubcomponents <em>Subcomponents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subcomponents</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure#getSubcomponents()
	 * @see #getCompositeStructure()
	 * @generated
	 */
	EReference getCompositeStructure_Subcomponents();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure#getConnector()
	 * @see #getCompositeStructure()
	 * @generated
	 */
	EReference getCompositeStructure_Connector();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getRequired()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Required();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getProvided <em>Provided</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getProvided()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Provided();

	/**
	 * Returns the meta object for the reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getBehaviour <em>Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Behaviour</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getBehaviour()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Behaviour();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity <em>Named Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Entity</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity
	 * @generated
	 */
	EClass getNamedEntity();

	/**
	 * Returns the meta object for the attribute '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity#getName()
	 * @see #getNamedEntity()
	 * @generated
	 */
	EAttribute getNamedEntity_Name();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity#getId()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Id();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getInput()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Input();

	/**
	 * Returns the meta object for the containment reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getOutput()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getThrowsExceptions <em>Throws Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Throws Exceptions</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getThrowsExceptions()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_ThrowsExceptions();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Message#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Message#getParameters()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Parameters();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception
	 * @generated
	 */
	EClass getException();

	/**
	 * Returns the meta object for the attribute '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception#getExceptionMessage <em>Exception Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Message</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception#getExceptionMessage()
	 * @see #getException()
	 * @generated
	 */
	EAttribute getException_ExceptionMessage();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance <em>Subcomponent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subcomponent Instance</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance
	 * @generated
	 */
	EClass getSubcomponentInstance();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance#getRealizedBy <em>Realized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realized By</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance#getRealizedBy()
	 * @see #getSubcomponentInstance()
	 * @generated
	 */
	EReference getSubcomponentInstance_RealizedBy();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for the attribute '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector#isIsDelegation <em>Is Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Delegation</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector#isIsDelegation()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_IsDelegation();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endpoints</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector#getEndpoints()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Endpoints();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Point</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint
	 * @generated
	 */
	EClass getEndPoint();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel <em>Service Architecture Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Architecture Model</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel
	 * @generated
	 */
	EClass getServiceArchitectureModel();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel#getDeclaredInterfaces <em>Declared Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Interfaces</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel#getDeclaredInterfaces()
	 * @see #getServiceArchitectureModel()
	 * @generated
	 */
	EReference getServiceArchitectureModel_DeclaredInterfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel#getService()
	 * @see #getServiceArchitectureModel()
	 * @generated
	 */
	EReference getServiceArchitectureModel_Service();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface#getSignatures <em>Signatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signatures</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface#getSignatures()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Signatures();

	/**
	 * Returns the meta object for the reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface#getInheritance <em>Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inheritance</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface#getInheritance()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Inheritance();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint <em>Subcomponent Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subcomponent Endpoint</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint
	 * @generated
	 */
	EClass getSubcomponentEndpoint();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getSubcomponent <em>Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subcomponent</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getSubcomponent()
	 * @see #getSubcomponentEndpoint()
	 * @generated
	 */
	EReference getSubcomponentEndpoint_Subcomponent();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getPort()
	 * @see #getSubcomponentEndpoint()
	 * @generated
	 */
	EReference getSubcomponentEndpoint_Port();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository#getEntities()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Entities();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint <em>Component Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Endpoint</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint
	 * @generated
	 */
	EClass getComponentEndpoint();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint#getPort()
	 * @see #getComponentEndpoint()
	 * @generated
	 */
	EReference getComponentEndpoint_Port();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType <em>Primitive Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Data Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType
	 * @generated
	 */
	EClass getPrimitiveDataType();

	/**
	 * Returns the meta object for the attribute '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType#getType()
	 * @see #getPrimitiveDataType()
	 * @generated
	 */
	EAttribute getPrimitiveDataType_Type();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType <em>Complex Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Data Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType
	 * @generated
	 */
	EClass getComplexDataType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType#getElements()
	 * @see #getComplexDataType()
	 * @generated
	 */
	EReference getComplexDataType_Elements();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement <em>Inner Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inner Element</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement
	 * @generated
	 */
	EClass getInnerElement();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement#getType()
	 * @see #getInnerElement()
	 * @generated
	 */
	EReference getInnerElement_Type();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Component</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeComponent
	 * @generated
	 */
	EClass getCompositeComponent();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveComponent <em>Primitive Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Component</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveComponent
	 * @generated
	 */
	EClass getPrimitiveComponent();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort <em>Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Port</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort
	 * @generated
	 */
	EClass getEventPort();

	/**
	 * Returns the meta object for the attribute '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#isIsSource <em>Is Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Source</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#isIsSource()
	 * @see #getEventPort()
	 * @generated
	 */
	EAttribute getEventPort_IsSource();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#getMessage()
	 * @see #getEventPort()
	 * @generated
	 */
	EReference getEventPort_Message();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort <em>Interface Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Port</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort
	 * @generated
	 */
	EClass getInterfacePort();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort#getType()
	 * @see #getInterfacePort()
	 * @generated
	 */
	EReference getInterfacePort_Type();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType <em>Collection Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Data Type</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType
	 * @generated
	 */
	EClass getCollectionDataType();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType#getInnertype <em>Innertype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Innertype</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType#getInnertype()
	 * @see #getCollectionDataType()
	 * @generated
	 */
	EReference getCollectionDataType_Innertype();

	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.FirstClassEntity <em>First Class Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>First Class Entity</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.FirstClassEntity
	 * @generated
	 */
	EClass getFirstClassEntity();

	/**
	 * Returns the meta object for enum '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes <em>XSD Primitive Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>XSD Primitive Data Types</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes
	 * @generated
	 */
	EEnum getXSDPrimitiveDataTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StaticStructureFactory getStaticStructureFactory();

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
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeStructureImpl <em>Composite Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeStructureImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getCompositeStructure()
		 * @generated
		 */
		EClass COMPOSITE_STRUCTURE = eINSTANCE.getCompositeStructure();

		/**
		 * The meta object literal for the '<em><b>Subcomponents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STRUCTURE__SUBCOMPONENTS = eINSTANCE.getCompositeStructure_Subcomponents();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STRUCTURE__CONNECTOR = eINSTANCE.getCompositeStructure_Connector();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentTypeImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__REQUIRED = eINSTANCE.getComponentType_Required();

		/**
		 * The meta object literal for the '<em><b>Provided</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__PROVIDED = eINSTANCE.getComponentType_Provided();

		/**
		 * The meta object literal for the '<em><b>Behaviour</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__BEHAVIOUR = eINSTANCE.getComponentType_Behaviour();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.NamedEntityImpl <em>Named Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.NamedEntityImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getNamedEntity()
		 * @generated
		 */
		EClass NAMED_ENTITY = eINSTANCE.getNamedEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ENTITY__NAME = eINSTANCE.getNamedEntity_Name();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EntityImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__ID = eINSTANCE.getEntity_Id();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PortImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.OperationImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__INPUT = eINSTANCE.getOperation_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OUTPUT = eINSTANCE.getOperation_Output();

		/**
		 * The meta object literal for the '<em><b>Throws Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__THROWS_EXCEPTIONS = eINSTANCE.getOperation_ThrowsExceptions();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.MessageImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__PARAMETERS = eINSTANCE.getMessage_Parameters();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ParameterImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.TypeImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ExceptionImpl <em>Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ExceptionImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getException()
		 * @generated
		 */
		EClass EXCEPTION = eINSTANCE.getException();

		/**
		 * The meta object literal for the '<em><b>Exception Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION__EXCEPTION_MESSAGE = eINSTANCE.getException_ExceptionMessage();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentInstanceImpl <em>Subcomponent Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentInstanceImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getSubcomponentInstance()
		 * @generated
		 */
		EClass SUBCOMPONENT_INSTANCE = eINSTANCE.getSubcomponentInstance();

		/**
		 * The meta object literal for the '<em><b>Realized By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBCOMPONENT_INSTANCE__REALIZED_BY = eINSTANCE.getSubcomponentInstance_RealizedBy();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ConnectorImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '<em><b>Is Delegation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__IS_DELEGATION = eINSTANCE.getConnector_IsDelegation();

		/**
		 * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__ENDPOINTS = eINSTANCE.getConnector_Endpoints();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EndPointImpl <em>End Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EndPointImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getEndPoint()
		 * @generated
		 */
		EClass END_POINT = eINSTANCE.getEndPoint();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ServiceArchitectureModelImpl <em>Service Architecture Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ServiceArchitectureModelImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getServiceArchitectureModel()
		 * @generated
		 */
		EClass SERVICE_ARCHITECTURE_MODEL = eINSTANCE.getServiceArchitectureModel();

		/**
		 * The meta object literal for the '<em><b>Declared Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES = eINSTANCE.getServiceArchitectureModel_DeclaredInterfaces();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_ARCHITECTURE_MODEL__SERVICE = eINSTANCE.getServiceArchitectureModel_Service();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfaceImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Signatures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__SIGNATURES = eINSTANCE.getInterface_Signatures();

		/**
		 * The meta object literal for the '<em><b>Inheritance</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__INHERITANCE = eINSTANCE.getInterface_Inheritance();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentEndpointImpl <em>Subcomponent Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentEndpointImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getSubcomponentEndpoint()
		 * @generated
		 */
		EClass SUBCOMPONENT_ENDPOINT = eINSTANCE.getSubcomponentEndpoint();

		/**
		 * The meta object literal for the '<em><b>Subcomponent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBCOMPONENT_ENDPOINT__SUBCOMPONENT = eINSTANCE.getSubcomponentEndpoint_Subcomponent();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBCOMPONENT_ENDPOINT__PORT = eINSTANCE.getSubcomponentEndpoint_Port();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.RepositoryImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__ENTITIES = eINSTANCE.getRepository_Entities();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentEndpointImpl <em>Component Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentEndpointImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getComponentEndpoint()
		 * @generated
		 */
		EClass COMPONENT_ENDPOINT = eINSTANCE.getComponentEndpoint();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_ENDPOINT__PORT = eINSTANCE.getComponentEndpoint_Port();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveDataTypeImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getPrimitiveDataType()
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
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComplexDataTypeImpl <em>Complex Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComplexDataTypeImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getComplexDataType()
		 * @generated
		 */
		EClass COMPLEX_DATA_TYPE = eINSTANCE.getComplexDataType();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DATA_TYPE__ELEMENTS = eINSTANCE.getComplexDataType_Elements();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InnerElementImpl <em>Inner Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InnerElementImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getInnerElement()
		 * @generated
		 */
		EClass INNER_ELEMENT = eINSTANCE.getInnerElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INNER_ELEMENT__TYPE = eINSTANCE.getInnerElement_Type();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeComponentImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getCompositeComponent()
		 * @generated
		 */
		EClass COMPOSITE_COMPONENT = eINSTANCE.getCompositeComponent();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveComponentImpl <em>Primitive Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.PrimitiveComponentImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getPrimitiveComponent()
		 * @generated
		 */
		EClass PRIMITIVE_COMPONENT = eINSTANCE.getPrimitiveComponent();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EventPortImpl <em>Event Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.EventPortImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getEventPort()
		 * @generated
		 */
		EClass EVENT_PORT = eINSTANCE.getEventPort();

		/**
		 * The meta object literal for the '<em><b>Is Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_PORT__IS_SOURCE = eINSTANCE.getEventPort_IsSource();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_PORT__MESSAGE = eINSTANCE.getEventPort_Message();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfacePortImpl <em>Interface Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfacePortImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getInterfacePort()
		 * @generated
		 */
		EClass INTERFACE_PORT = eINSTANCE.getInterfacePort();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_PORT__TYPE = eINSTANCE.getInterfacePort_Type();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CollectionDataTypeImpl <em>Collection Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CollectionDataTypeImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getCollectionDataType()
		 * @generated
		 */
		EClass COLLECTION_DATA_TYPE = eINSTANCE.getCollectionDataType();

		/**
		 * The meta object literal for the '<em><b>Innertype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_DATA_TYPE__INNERTYPE = eINSTANCE.getCollectionDataType_Innertype();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.FirstClassEntityImpl <em>First Class Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.FirstClassEntityImpl
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getFirstClassEntity()
		 * @generated
		 */
		EClass FIRST_CLASS_ENTITY = eINSTANCE.getFirstClassEntity();

		/**
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes <em>XSD Primitive Data Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes
		 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl#getXSDPrimitiveDataTypes()
		 * @generated
		 */
		EEnum XSD_PRIMITIVE_DATA_TYPES = eINSTANCE.getXSDPrimitiveDataTypes();

	}

} //StaticStructurePackage
