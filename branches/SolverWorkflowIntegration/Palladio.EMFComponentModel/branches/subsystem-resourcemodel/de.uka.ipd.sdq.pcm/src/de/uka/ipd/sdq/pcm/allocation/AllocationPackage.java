/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import org.eclipse.emf.ecore.EAttribute;

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
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationFactory
 * @model kind="package"
 * @generated
 */
public interface AllocationPackage extends EPackage {
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
	String eNAME = "allocation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Allocation/1.0";

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
	AllocationPackage eINSTANCE = de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getAllocationContext()
	 * @generated
	 */
	int ALLOCATION_CONTEXT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getAllocationConnector()
	 * @generated
	 */
	int ALLOCATION_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Resource Required Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>From Assembly Context Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR = 1;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONNECTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl <em>Resource Provided Role Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getResourceProvidedRoleConnector()
	 * @generated
	 */
	int RESOURCE_PROVIDED_ROLE_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Resource Required Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR = ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR;

	/**
	 * The feature id for the '<em><b>From Assembly Context Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR = ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Resource Provided Role Resource Provided Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR = ALLOCATION_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Controller Instance Controller Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR = ALLOCATION_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Provided Role Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDED_ROLE_CONNECTOR_FEATURE_COUNT = ALLOCATION_CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Resource Container Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assembly Context Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONTEXT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl <em>Infrastructure Component Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getInfrastructureComponentScope()
	 * @generated
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl <em>Allocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getAllocation()
	 * @generated
	 */
	int ALLOCATION = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl <em>Infrastructure Component Allocation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getInfrastructureComponentAllocationConnector()
	 * @generated
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Allocation Contexts Allocation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Resource Environment Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>System Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__SYSTEM_ALLOCATION = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Infrastructure Component Scopes Allocation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Allocation Connectors Allocation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__ID = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__ENTITY_NAME = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Assembly Contexts Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Resource Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Lower Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Container Infrastructure Component Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Part Of Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__IS_PART_OF_CYCLE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Infrastructure Component Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE_FEATURE_COUNT = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ID = ConnectorsPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ENTITY_NAME = ConnectorsPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Resource Required Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Assembly Context Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provided Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>To Infrastructure Component Scope Infrastructure Component Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Infrastructure Component Allocation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR_FEATURE_COUNT = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector <em>Resource Provided Role Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Provided Role Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector
	 * @generated
	 */
	EClass getResourceProvidedRoleConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Provided Role Resource Provided Role Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector()
	 * @see #getResourceProvidedRoleConnector()
	 * @generated
	 */
	EReference getResourceProvidedRoleConnector_ResourceProvidedRole_ResourceProvidedRoleAllocationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getFromControllerInstance_ControllerAllocationConnector <em>From Controller Instance Controller Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Controller Instance Controller Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getFromControllerInstance_ControllerAllocationConnector()
	 * @see #getResourceProvidedRoleConnector()
	 * @generated
	 */
	EReference getResourceProvidedRoleConnector_FromControllerInstance_ControllerAllocationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationContext
	 * @generated
	 */
	EClass getAllocationContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getResourceContainer_AllocationContext <em>Resource Container Allocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Container Allocation Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationContext#getResourceContainer_AllocationContext()
	 * @see #getAllocationContext()
	 * @generated
	 */
	EReference getAllocationContext_ResourceContainer_AllocationContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAssemblyContext_AllocationContext <em>Assembly Context Allocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Allocation Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAssemblyContext_AllocationContext()
	 * @see #getAllocationContext()
	 * @generated
	 */
	EReference getAllocationContext_AssemblyContext_AllocationContext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationConnector
	 * @generated
	 */
	EClass getAllocationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceRequiredRole_AllocationConnector <em>Resource Required Role Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Required Role Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceRequiredRole_AllocationConnector()
	 * @see #getAllocationConnector()
	 * @generated
	 */
	EReference getAllocationConnector_ResourceRequiredRole_AllocationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getFromAssemblyContext_AllocationConnector <em>From Assembly Context Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Assembly Context Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getFromAssemblyContext_AllocationConnector()
	 * @see #getAllocationConnector()
	 * @generated
	 */
	EReference getAllocationConnector_FromAssemblyContext_AllocationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope <em>Infrastructure Component Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Component Scope</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope
	 * @generated
	 */
	EClass getInfrastructureComponentScope();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer <em>Lower Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Layer</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer()
	 * @see #getInfrastructureComponentScope()
	 * @generated
	 */
	EReference getInfrastructureComponentScope_LowerLayer();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer <em>Upper Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Layer</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer()
	 * @see #getInfrastructureComponentScope()
	 * @generated
	 */
	EReference getInfrastructureComponentScope_UpperLayer();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getResourceContainer_InfrastructureComponentScope <em>Resource Container Infrastructure Component Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Container Infrastructure Component Scope</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getResourceContainer_InfrastructureComponentScope()
	 * @see #getInfrastructureComponentScope()
	 * @generated
	 */
	EReference getInfrastructureComponentScope_ResourceContainer_InfrastructureComponentScope();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#isIsPartOfCycle <em>Is Part Of Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Part Of Cycle</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#isIsPartOfCycle()
	 * @see #getInfrastructureComponentScope()
	 * @generated
	 */
	EAttribute getInfrastructureComponentScope_IsPartOfCycle();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.allocation.Allocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.Allocation
	 * @generated
	 */
	EClass getAllocation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts_Allocation <em>Allocation Contexts Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Allocation Contexts Allocation</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts_Allocation()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_AllocationContexts_Allocation();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Resource Environment Allocation</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_TargetResourceEnvironment_Allocation();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation <em>System Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Allocation</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_System_Allocation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getInfrastructureComponentScopes_Allocation <em>Infrastructure Component Scopes Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Infrastructure Component Scopes Allocation</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.Allocation#getInfrastructureComponentScopes_Allocation()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_InfrastructureComponentScopes_Allocation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationConnectors_Allocation <em>Allocation Connectors Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Allocation Connectors Allocation</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationConnectors_Allocation()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_AllocationConnectors_Allocation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector <em>Infrastructure Component Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Component Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector
	 * @generated
	 */
	EClass getInfrastructureComponentAllocationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getProvidedRole_AllocationConnector <em>Provided Role Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Role Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getProvidedRole_AllocationConnector()
	 * @see #getInfrastructureComponentAllocationConnector()
	 * @generated
	 */
	EReference getInfrastructureComponentAllocationConnector_ProvidedRole_AllocationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector()
	 * @see #getInfrastructureComponentAllocationConnector()
	 * @generated
	 */
	EReference getInfrastructureComponentAllocationConnector_ToInfrastructureComponentScope_InfrastructureComponentAllocationConnector();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AllocationFactory getAllocationFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl <em>Resource Provided Role Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getResourceProvidedRoleConnector()
		 * @generated
		 */
		EClass RESOURCE_PROVIDED_ROLE_CONNECTOR = eINSTANCE.getResourceProvidedRoleConnector();

		/**
		 * The meta object literal for the '<em><b>Resource Provided Role Resource Provided Role Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR = eINSTANCE.getResourceProvidedRoleConnector_ResourceProvidedRole_ResourceProvidedRoleAllocationConnector();

		/**
		 * The meta object literal for the '<em><b>From Controller Instance Controller Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR = eINSTANCE.getResourceProvidedRoleConnector_FromControllerInstance_ControllerAllocationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getAllocationContext()
		 * @generated
		 */
		EClass ALLOCATION_CONTEXT = eINSTANCE.getAllocationContext();

		/**
		 * The meta object literal for the '<em><b>Resource Container Allocation Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT = eINSTANCE.getAllocationContext_ResourceContainer_AllocationContext();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Allocation Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT = eINSTANCE.getAllocationContext_AssemblyContext_AllocationContext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getAllocationConnector()
		 * @generated
		 */
		EClass ALLOCATION_CONNECTOR = eINSTANCE.getAllocationConnector();

		/**
		 * The meta object literal for the '<em><b>Resource Required Role Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CONNECTOR__RESOURCE_REQUIRED_ROLE_ALLOCATION_CONNECTOR = eINSTANCE.getAllocationConnector_ResourceRequiredRole_AllocationConnector();

		/**
		 * The meta object literal for the '<em><b>From Assembly Context Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CONNECTOR__FROM_ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR = eINSTANCE.getAllocationConnector_FromAssemblyContext_AllocationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl <em>Infrastructure Component Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getInfrastructureComponentScope()
		 * @generated
		 */
		EClass INFRASTRUCTURE_COMPONENT_SCOPE = eINSTANCE.getInfrastructureComponentScope();

		/**
		 * The meta object literal for the '<em><b>Lower Layer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER = eINSTANCE.getInfrastructureComponentScope_LowerLayer();

		/**
		 * The meta object literal for the '<em><b>Upper Layer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER = eINSTANCE.getInfrastructureComponentScope_UpperLayer();

		/**
		 * The meta object literal for the '<em><b>Resource Container Infrastructure Component Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE = eINSTANCE.getInfrastructureComponentScope_ResourceContainer_InfrastructureComponentScope();

		/**
		 * The meta object literal for the '<em><b>Is Part Of Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFRASTRUCTURE_COMPONENT_SCOPE__IS_PART_OF_CYCLE = eINSTANCE.getInfrastructureComponentScope_IsPartOfCycle();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl <em>Allocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getAllocation()
		 * @generated
		 */
		EClass ALLOCATION = eINSTANCE.getAllocation();

		/**
		 * The meta object literal for the '<em><b>Allocation Contexts Allocation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION = eINSTANCE.getAllocation_AllocationContexts_Allocation();

		/**
		 * The meta object literal for the '<em><b>Target Resource Environment Allocation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION = eINSTANCE.getAllocation_TargetResourceEnvironment_Allocation();

		/**
		 * The meta object literal for the '<em><b>System Allocation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__SYSTEM_ALLOCATION = eINSTANCE.getAllocation_System_Allocation();

		/**
		 * The meta object literal for the '<em><b>Infrastructure Component Scopes Allocation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__INFRASTRUCTURE_COMPONENT_SCOPES_ALLOCATION = eINSTANCE.getAllocation_InfrastructureComponentScopes_Allocation();

		/**
		 * The meta object literal for the '<em><b>Allocation Connectors Allocation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION__ALLOCATION_CONNECTORS_ALLOCATION = eINSTANCE.getAllocation_AllocationConnectors_Allocation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl <em>Infrastructure Component Allocation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getInfrastructureComponentAllocationConnector()
		 * @generated
		 */
		EClass INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR = eINSTANCE.getInfrastructureComponentAllocationConnector();

		/**
		 * The meta object literal for the '<em><b>Provided Role Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR = eINSTANCE.getInfrastructureComponentAllocationConnector_ProvidedRole_AllocationConnector();

		/**
		 * The meta object literal for the '<em><b>To Infrastructure Component Scope Infrastructure Component Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__TO_INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR = eINSTANCE.getInfrastructureComponentAllocationConnector_ToInfrastructureComponentScope_InfrastructureComponentAllocationConnector();

	}

} //AllocationPackage
