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
	int ALLOCATION_CONTEXT = 0;

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
	 * The feature id for the '<em><b>Resource Container Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR = 2;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CONNECTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl <em>Infrastructure Component Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getInfrastructureComponentScope()
	 * @generated
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE = 2;

	/**
	 * The feature id for the '<em><b>Assembly Context Infrastructure Component Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE = 0;

	/**
	 * The feature id for the '<em><b>Lower Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER = 1;

	/**
	 * The feature id for the '<em><b>Upper Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER = 2;

	/**
	 * The number of structural features of the '<em>Infrastructure Component Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_SCOPE_FEATURE_COUNT = 3;

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
	 * The number of structural features of the '<em>Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl <em>Infrastructure Component Allocation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentAllocationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl#getInfrastructureComponentAllocationConnector()
	 * @generated
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR = 4;

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
	 * The feature id for the '<em><b>Resource Container Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Provided Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__PROVIDED_ROLE_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Infrastructure Component Scope Infrastructure Component Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Infrastructure Component Allocation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR_FEATURE_COUNT = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 5;


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
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceContainer_AllocationConnector <em>Resource Container Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Container Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getResourceContainer_AllocationConnector()
	 * @see #getAllocationConnector()
	 * @generated
	 */
	EReference getAllocationConnector_ResourceContainer_AllocationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getAssemblyContext_AllocationConnector <em>Assembly Context Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationConnector#getAssemblyContext_AllocationConnector()
	 * @see #getAllocationConnector()
	 * @generated
	 */
	EReference getAllocationConnector_AssemblyContext_AllocationConnector();

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
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getAssemblyContext_InfrastructureComponentScope <em>Assembly Context Infrastructure Component Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Infrastructure Component Scope</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getAssemblyContext_InfrastructureComponentScope()
	 * @see #getInfrastructureComponentScope()
	 * @generated
	 */
	EReference getInfrastructureComponentScope_AssemblyContext_InfrastructureComponentScope();

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
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getInfrastructureComponentScope_InfrastructureComponentAllocationConnector()
	 * @see #getInfrastructureComponentAllocationConnector()
	 * @generated
	 */
	EReference getInfrastructureComponentAllocationConnector_InfrastructureComponentScope_InfrastructureComponentAllocationConnector();

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
		 * The meta object literal for the '<em><b>Resource Container Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CONNECTOR__RESOURCE_CONTAINER_ALLOCATION_CONNECTOR = eINSTANCE.getAllocationConnector_ResourceContainer_AllocationConnector();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CONNECTOR__ASSEMBLY_CONTEXT_ALLOCATION_CONNECTOR = eINSTANCE.getAllocationConnector_AssemblyContext_AllocationConnector();

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
		 * The meta object literal for the '<em><b>Assembly Context Infrastructure Component Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_COMPONENT_SCOPE__ASSEMBLY_CONTEXT_INFRASTRUCTURE_COMPONENT_SCOPE = eINSTANCE.getInfrastructureComponentScope_AssemblyContext_InfrastructureComponentScope();

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
		 * The meta object literal for the '<em><b>Infrastructure Component Scope Infrastructure Component Allocation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR__INFRASTRUCTURE_COMPONENT_SCOPE_INFRASTRUCTURE_COMPONENT_ALLOCATION_CONNECTOR = eINSTANCE.getInfrastructureComponentAllocationConnector_InfrastructureComponentScope_InfrastructureComponentAllocationConnector();

	}

} //AllocationPackage
