/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
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
	int ASSEMBLY_CONTEXT = 5;

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
	 * The feature id for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Composed Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_STRUCTURE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 5;

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

	}

} //CompositionPackage
