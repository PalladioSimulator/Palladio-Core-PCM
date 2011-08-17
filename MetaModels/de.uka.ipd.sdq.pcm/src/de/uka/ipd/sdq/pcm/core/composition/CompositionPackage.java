/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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
 * <!-- begin-model-doc -->
 * A package holding all composable entities
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionFactory
 * @model kind="package"
 * @generated
 */
public interface CompositionPackage extends EPackage {
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
	String eNAME = "composition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/4.0";

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
	CompositionPackage eINSTANCE = de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl <em>Provided Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getProvidedDelegationConnector()
	 * @generated
	 */
	int PROVIDED_DELEGATION_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_DELEGATION_CONNECTOR__ID = RepositoryPackage.DELEGATION_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_DELEGATION_CONNECTOR__ENTITY_NAME = RepositoryPackage.DELEGATION_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Inner Provided Role Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outer Provided Role Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Structure Provided Delegation Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Provided Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_DELEGATION_CONNECTOR_FEATURE_COUNT = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl <em>Assembly Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getAssemblyContext()
	 * @generated
	 */
	int ASSEMBLY_CONTEXT = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl <em>Required Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getRequiredDelegationConnector()
	 * @generated
	 */
	int REQUIRED_DELEGATION_CONNECTOR = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl <em>Assembly Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getAssemblyConnector()
	 * @generated
	 */
	int ASSEMBLY_CONNECTOR = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl <em>Resource Required Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getResourceRequiredDelegationConnector()
	 * @generated
	 */
	int RESOURCE_REQUIRED_DELEGATION_CONNECTOR = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl <em>Assembly Event Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getAssemblyEventConnector()
	 * @generated
	 */
	int ASSEMBLY_EVENT_CONNECTOR = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl <em>Source Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getSourceDelegationConnector()
	 * @generated
	 */
	int SOURCE_DELEGATION_CONNECTOR = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl <em>Sink Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getSinkDelegationConnector()
	 * @generated
	 */
	int SINK_DELEGATION_CONNECTOR = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl <em>Composed Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl
	 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getComposedStructure()
	 * @generated
	 */
	int COMPOSED_STRUCTURE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Assembly Contexts Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Assembly Event Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sink Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Composed Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__ID = ConnectorsPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__ENTITY_NAME = ConnectorsPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Requiring Assembly Context Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Providing Assembly Context Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provided Role Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Required Role Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent Structure Assembly Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Assembly Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR_FEATURE_COUNT = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_DELEGATION_CONNECTOR__ID = RepositoryPackage.DELEGATION_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_DELEGATION_CONNECTOR__ENTITY_NAME = RepositoryPackage.DELEGATION_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Inner Required Role Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outer Required Role Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Structure Required Delegation Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Required Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_DELEGATION_CONNECTOR_FEATURE_COUNT = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inner Resource Required Role Resource Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Outer Resource Required Role Resource Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Parent Structure Resource Required Delegation Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR = 2;

	/**
	 * The number of structural features of the '<em>Resource Required Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIRED_DELEGATION_CONNECTOR_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR__ID = ConnectorsPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR__ENTITY_NAME = ConnectorsPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Sink Role Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Role Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sink Assembly Context Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Assembly Context Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Composed Structure Assembly Event Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR__COMPOSED_STRUCTURE_ASSEMBLY_EVENT_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Assembly Event Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_EVENT_CONNECTOR_FEATURE_COUNT = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_DELEGATION_CONNECTOR__ID = RepositoryPackage.DELEGATION_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_DELEGATION_CONNECTOR__ENTITY_NAME = RepositoryPackage.DELEGATION_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Inner Source Role Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outer Source Role Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Source Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Structure Source Delegation Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Source Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_DELEGATION_CONNECTOR_FEATURE_COUNT = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_DELEGATION_CONNECTOR__ID = RepositoryPackage.DELEGATION_CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_DELEGATION_CONNECTOR__ENTITY_NAME = RepositoryPackage.DELEGATION_CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Assembly Context Sink Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inner Sink Role Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outer Sink Role Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Structure Sink Delegation Connector</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sink Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINK_DELEGATION_CONNECTOR_FEATURE_COUNT = RepositoryPackage.DELEGATION_CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Parent Structure Assembly Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Encapsulated Component Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Config Parameter Usages Assembly Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assembly Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector <em>Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector
	 * @generated
	 */
	EClass getProvidedDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getInnerProvidedRole_ProvidedDelegationConnector <em>Inner Provided Role Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Provided Role Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getInnerProvidedRole_ProvidedDelegationConnector()
	 * @see #getProvidedDelegationConnector()
	 * @generated
	 */
	EReference getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getOuterProvidedRole_ProvidedDelegationConnector <em>Outer Provided Role Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Provided Role Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getOuterProvidedRole_ProvidedDelegationConnector()
	 * @see #getProvidedDelegationConnector()
	 * @generated
	 */
	EReference getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getAssemblyContext_ProvidedDelegationConnector <em>Assembly Context Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getAssemblyContext_ProvidedDelegationConnector()
	 * @see #getProvidedDelegationConnector()
	 * @generated
	 */
	EReference getProvidedDelegationConnector_AssemblyContext_ProvidedDelegationConnector();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getParentStructure_ProvidedDelegationConnector <em>Parent Structure Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Structure Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getParentStructure_ProvidedDelegationConnector()
	 * @see #getProvidedDelegationConnector()
	 * @generated
	 */
	EReference getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext <em>Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
	 * @generated
	 */
	EClass getAssemblyContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getEncapsulatedComponent_AssemblyContext <em>Encapsulated Component Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Encapsulated Component Assembly Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getEncapsulatedComponent_AssemblyContext()
	 * @see #getAssemblyContext()
	 * @generated
	 */
	EReference getAssemblyContext_EncapsulatedComponent_AssemblyContext();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getParentStructure_AssemblyContext <em>Parent Structure Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Structure Assembly Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getParentStructure_AssemblyContext()
	 * @see #getAssemblyContext()
	 * @generated
	 */
	EReference getAssemblyContext_ParentStructure_AssemblyContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigParameterUsages_AssemblyContext <em>Config Parameter Usages Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Config Parameter Usages Assembly Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getConfigParameterUsages_AssemblyContext()
	 * @see #getAssemblyContext()
	 * @generated
	 */
	EReference getAssemblyContext_ConfigParameterUsages_AssemblyContext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector <em>Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector
	 * @generated
	 */
	EClass getRequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getInnerRequiredRole_RequiredDelegationConnector <em>Inner Required Role Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Required Role Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getInnerRequiredRole_RequiredDelegationConnector()
	 * @see #getRequiredDelegationConnector()
	 * @generated
	 */
	EReference getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getOuterRequiredRole_RequiredDelegationConnector <em>Outer Required Role Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Required Role Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getOuterRequiredRole_RequiredDelegationConnector()
	 * @see #getRequiredDelegationConnector()
	 * @generated
	 */
	EReference getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getAssemblyContext_RequiredDelegationConnector <em>Assembly Context Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getAssemblyContext_RequiredDelegationConnector()
	 * @see #getRequiredDelegationConnector()
	 * @generated
	 */
	EReference getRequiredDelegationConnector_AssemblyContext_RequiredDelegationConnector();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getParentStructure_RequiredDelegationConnector <em>Parent Structure Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Structure Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getParentStructure_RequiredDelegationConnector()
	 * @see #getRequiredDelegationConnector()
	 * @generated
	 */
	EReference getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector <em>Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector
	 * @generated
	 */
	EClass getAssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiringAssemblyContext_AssemblyConnector <em>Requiring Assembly Context Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Requiring Assembly Context Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiringAssemblyContext_AssemblyConnector()
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	EReference getAssemblyConnector_RequiringAssemblyContext_AssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidingAssemblyContext_AssemblyConnector <em>Providing Assembly Context Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Providing Assembly Context Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidingAssemblyContext_AssemblyConnector()
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	EReference getAssemblyConnector_ProvidingAssemblyContext_AssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidedRole_AssemblyConnector <em>Provided Role Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Role Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidedRole_AssemblyConnector()
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	EReference getAssemblyConnector_ProvidedRole_AssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiredRole_AssemblyConnector <em>Required Role Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Role Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiredRole_AssemblyConnector()
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	EReference getAssemblyConnector_RequiredRole_AssemblyConnector();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getParentStructure_AssemblyConnector <em>Parent Structure Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Structure Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getParentStructure_AssemblyConnector()
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	EReference getAssemblyConnector_ParentStructure_AssemblyConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector <em>Resource Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector
	 * @generated
	 */
	EClass getResourceRequiredDelegationConnector();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getParentStructure_ResourceRequiredDelegationConnector <em>Parent Structure Resource Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Structure Resource Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getParentStructure_ResourceRequiredDelegationConnector()
	 * @see #getResourceRequiredDelegationConnector()
	 * @generated
	 */
	EReference getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getInnerResourceRequiredRole_ResourceRequiredDelegationConnector <em>Inner Resource Required Role Resource Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Resource Required Role Resource Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getInnerResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @see #getResourceRequiredDelegationConnector()
	 * @generated
	 */
	EReference getResourceRequiredDelegationConnector_InnerResourceRequiredRole_ResourceRequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getOuterResourceRequiredRole_ResourceRequiredDelegationConnector <em>Outer Resource Required Role Resource Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Resource Required Role Resource Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getOuterResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @see #getResourceRequiredDelegationConnector()
	 * @generated
	 */
	EReference getResourceRequiredDelegationConnector_OuterResourceRequiredRole_ResourceRequiredDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector <em>Assembly Event Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly Event Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector
	 * @generated
	 */
	EClass getAssemblyEventConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkRole__AssemblyEventConnector <em>Sink Role Assembly Event Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sink Role Assembly Event Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkRole__AssemblyEventConnector()
	 * @see #getAssemblyEventConnector()
	 * @generated
	 */
	EReference getAssemblyEventConnector_SinkRole__AssemblyEventConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceRole__AssemblyEventConnector <em>Source Role Assembly Event Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Role Assembly Event Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceRole__AssemblyEventConnector()
	 * @see #getAssemblyEventConnector()
	 * @generated
	 */
	EReference getAssemblyEventConnector_SourceRole__AssemblyEventConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkAssemblyContext__AssemblyEventConnector <em>Sink Assembly Context Assembly Event Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sink Assembly Context Assembly Event Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkAssemblyContext__AssemblyEventConnector()
	 * @see #getAssemblyEventConnector()
	 * @generated
	 */
	EReference getAssemblyEventConnector_SinkAssemblyContext__AssemblyEventConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceAssemblyContext__AssemblyEventConnector <em>Source Assembly Context Assembly Event Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Assembly Context Assembly Event Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceAssemblyContext__AssemblyEventConnector()
	 * @see #getAssemblyEventConnector()
	 * @generated
	 */
	EReference getAssemblyEventConnector_SourceAssemblyContext__AssemblyEventConnector();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getComposedStructure__AssemblyEventConnector <em>Composed Structure Assembly Event Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Composed Structure Assembly Event Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getComposedStructure__AssemblyEventConnector()
	 * @see #getAssemblyEventConnector()
	 * @generated
	 */
	EReference getAssemblyEventConnector_ComposedStructure__AssemblyEventConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector <em>Source Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector
	 * @generated
	 */
	EClass getSourceDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getInnerSourceRole__SourceRole <em>Inner Source Role Source Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Source Role Source Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getInnerSourceRole__SourceRole()
	 * @see #getSourceDelegationConnector()
	 * @generated
	 */
	EReference getSourceDelegationConnector_InnerSourceRole__SourceRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getOuterSourceRole__SourceRole <em>Outer Source Role Source Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Source Role Source Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getOuterSourceRole__SourceRole()
	 * @see #getSourceDelegationConnector()
	 * @generated
	 */
	EReference getSourceDelegationConnector_OuterSourceRole__SourceRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getAssemblyContext__SourceDelegationConnector <em>Assembly Context Source Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Source Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getAssemblyContext__SourceDelegationConnector()
	 * @see #getSourceDelegationConnector()
	 * @generated
	 */
	EReference getSourceDelegationConnector_AssemblyContext__SourceDelegationConnector();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure__SourceDelegationConnector <em>Parent Structure Source Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Structure Source Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure__SourceDelegationConnector()
	 * @see #getSourceDelegationConnector()
	 * @generated
	 */
	EReference getSourceDelegationConnector_ParentStructure__SourceDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector <em>Sink Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sink Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector
	 * @generated
	 */
	EClass getSinkDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getAssemblyContext__SinkDelegationConnector <em>Assembly Context Sink Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Sink Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getAssemblyContext__SinkDelegationConnector()
	 * @see #getSinkDelegationConnector()
	 * @generated
	 */
	EReference getSinkDelegationConnector_AssemblyContext__SinkDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getInnerSinkRole__SinkRole <em>Inner Sink Role Sink Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Sink Role Sink Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getInnerSinkRole__SinkRole()
	 * @see #getSinkDelegationConnector()
	 * @generated
	 */
	EReference getSinkDelegationConnector_InnerSinkRole__SinkRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getOuterSinkRole__SinkRole <em>Outer Sink Role Sink Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Sink Role Sink Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getOuterSinkRole__SinkRole()
	 * @see #getSinkDelegationConnector()
	 * @generated
	 */
	EReference getSinkDelegationConnector_OuterSinkRole__SinkRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getParentStructure__SinkDelegationConnector <em>Parent Structure Sink Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Structure Sink Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getParentStructure__SinkDelegationConnector()
	 * @see #getSinkDelegationConnector()
	 * @generated
	 */
	EReference getSinkDelegationConnector_ParentStructure__SinkDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure <em>Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
	 * @generated
	 */
	EClass getComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyContexts_ComposedStructure <em>Assembly Contexts Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assembly Contexts Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyContexts_ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_AssemblyContexts_ComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Delegation Connectors Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getProvidedDelegationConnectors_ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_ProvidedDelegationConnectors_ComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Delegation Connectors Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getRequiredDelegationConnectors_ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_RequiredDelegationConnectors_ComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyConnectors_ComposedStructure <em>Assembly Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assembly Connectors Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyConnectors_ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_AssemblyConnectors_ComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getResourceRequiredDelegationConnectors_ComposedStructure <em>Resource Required Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Required Delegation Connectors Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getResourceRequiredDelegationConnectors_ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyEventConnectors__ComposedStructure <em>Assembly Event Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assembly Event Connectors Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyEventConnectors__ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_AssemblyEventConnectors__ComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSourceDelegationConnectors__ComposedStructure <em>Source Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Delegation Connectors Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSourceDelegationConnectors__ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_SourceDelegationConnectors__ComposedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSinkDelegationConnectors__ComposedStructure <em>Sink Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sink Delegation Connectors Composed Structure</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSinkDelegationConnectors__ComposedStructure()
	 * @see #getComposedStructure()
	 * @generated
	 */
	EReference getComposedStructure_SinkDelegationConnectors__ComposedStructure();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompositionFactory getCompositionFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl <em>Provided Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getProvidedDelegationConnector()
		 * @generated
		 */
		EClass PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getProvidedDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Inner Provided Role Provided Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Outer Provided Role Provided Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Provided Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getProvidedDelegationConnector_AssemblyContext_ProvidedDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Parent Structure Provided Delegation Connector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl <em>Assembly Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getAssemblyContext()
		 * @generated
		 */
		EClass ASSEMBLY_CONTEXT = eINSTANCE.getAssemblyContext();

		/**
		 * The meta object literal for the '<em><b>Encapsulated Component Assembly Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT = eINSTANCE.getAssemblyContext_EncapsulatedComponent_AssemblyContext();

		/**
		 * The meta object literal for the '<em><b>Parent Structure Assembly Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT = eINSTANCE.getAssemblyContext_ParentStructure_AssemblyContext();

		/**
		 * The meta object literal for the '<em><b>Config Parameter Usages Assembly Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT = eINSTANCE.getAssemblyContext_ConfigParameterUsages_AssemblyContext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl <em>Required Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getRequiredDelegationConnector()
		 * @generated
		 */
		EClass REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getRequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Inner Required Role Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Outer Required Role Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getRequiredDelegationConnector_AssemblyContext_RequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Parent Structure Required Delegation Connector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl <em>Assembly Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getAssemblyConnector()
		 * @generated
		 */
		EClass ASSEMBLY_CONNECTOR = eINSTANCE.getAssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Requiring Assembly Context Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR = eINSTANCE.getAssemblyConnector_RequiringAssemblyContext_AssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Providing Assembly Context Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR = eINSTANCE.getAssemblyConnector_ProvidingAssemblyContext_AssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Provided Role Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR = eINSTANCE.getAssemblyConnector_ProvidedRole_AssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Required Role Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR = eINSTANCE.getAssemblyConnector_RequiredRole_AssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Parent Structure Assembly Connector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR = eINSTANCE.getAssemblyConnector_ParentStructure_AssemblyConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl <em>Resource Required Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getResourceRequiredDelegationConnector()
		 * @generated
		 */
		EClass RESOURCE_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getResourceRequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Parent Structure Resource Required Delegation Connector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Inner Resource Required Role Resource Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getResourceRequiredDelegationConnector_InnerResourceRequiredRole_ResourceRequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Outer Resource Required Role Resource Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getResourceRequiredDelegationConnector_OuterResourceRequiredRole_ResourceRequiredDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl <em>Assembly Event Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getAssemblyEventConnector()
		 * @generated
		 */
		EClass ASSEMBLY_EVENT_CONNECTOR = eINSTANCE.getAssemblyEventConnector();

		/**
		 * The meta object literal for the '<em><b>Sink Role Assembly Event Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR = eINSTANCE.getAssemblyEventConnector_SinkRole__AssemblyEventConnector();

		/**
		 * The meta object literal for the '<em><b>Source Role Assembly Event Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR = eINSTANCE.getAssemblyEventConnector_SourceRole__AssemblyEventConnector();

		/**
		 * The meta object literal for the '<em><b>Sink Assembly Context Assembly Event Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR = eINSTANCE.getAssemblyEventConnector_SinkAssemblyContext__AssemblyEventConnector();

		/**
		 * The meta object literal for the '<em><b>Source Assembly Context Assembly Event Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR = eINSTANCE.getAssemblyEventConnector_SourceAssemblyContext__AssemblyEventConnector();

		/**
		 * The meta object literal for the '<em><b>Composed Structure Assembly Event Connector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_EVENT_CONNECTOR__COMPOSED_STRUCTURE_ASSEMBLY_EVENT_CONNECTOR = eINSTANCE.getAssemblyEventConnector_ComposedStructure__AssemblyEventConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl <em>Source Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getSourceDelegationConnector()
		 * @generated
		 */
		EClass SOURCE_DELEGATION_CONNECTOR = eINSTANCE.getSourceDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Inner Source Role Source Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE = eINSTANCE.getSourceDelegationConnector_InnerSourceRole__SourceRole();

		/**
		 * The meta object literal for the '<em><b>Outer Source Role Source Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE = eINSTANCE.getSourceDelegationConnector_OuterSourceRole__SourceRole();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Source Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR = eINSTANCE.getSourceDelegationConnector_AssemblyContext__SourceDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Parent Structure Source Delegation Connector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR = eINSTANCE.getSourceDelegationConnector_ParentStructure__SourceDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl <em>Sink Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getSinkDelegationConnector()
		 * @generated
		 */
		EClass SINK_DELEGATION_CONNECTOR = eINSTANCE.getSinkDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Sink Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR = eINSTANCE.getSinkDelegationConnector_AssemblyContext__SinkDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Inner Sink Role Sink Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE = eINSTANCE.getSinkDelegationConnector_InnerSinkRole__SinkRole();

		/**
		 * The meta object literal for the '<em><b>Outer Sink Role Sink Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE = eINSTANCE.getSinkDelegationConnector_OuterSinkRole__SinkRole();

		/**
		 * The meta object literal for the '<em><b>Parent Structure Sink Delegation Connector</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR = eINSTANCE.getSinkDelegationConnector_ParentStructure__SinkDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl <em>Composed Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl
		 * @see de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl#getComposedStructure()
		 * @generated
		 */
		EClass COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Assembly Contexts Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_AssemblyContexts_ComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_ProvidedDelegationConnectors_ComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_RequiredDelegationConnectors_ComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Assembly Connectors Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_AssemblyConnectors_ComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Resource Required Delegation Connectors Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Assembly Event Connectors Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTORS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_AssemblyEventConnectors__ComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Source Delegation Connectors Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_SourceDelegationConnectors__ComposedStructure();

		/**
		 * The meta object literal for the '<em><b>Sink Delegation Connectors Composed Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = eINSTANCE.getComposedStructure_SinkDelegationConnectors__ComposedStructure();

	}

} //CompositionPackage
