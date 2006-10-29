/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyFactory
 * @model kind="package"
 * @generated
 */
public interface AssemblyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "assembly";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Assembly/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.assembly";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AssemblyPackage eINSTANCE = de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl <em>System Assembly Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl#getSystemAssemblyConnector()
	 * @generated
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR__ID = ConnectorsPackage.CONNECTOR__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR__ENTITY_NAME = ConnectorsPackage.CONNECTOR__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Providing Context System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Requiring Context System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provided Role System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Required Role System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>System Assembly Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ASSEMBLY_CONNECTOR_FEATURE_COUNT = ConnectorsPackage.CONNECTOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.assembly.impl.AssemblyContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyContextImpl
	 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl#getAssemblyContext()
	 * @generated
	 */
	int ASSEMBLY_CONTEXT = 1;

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
	 * The feature id for the '<em><b>Encapsulated Component Assembly Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONTEXT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.assembly.impl.AssemblyImpl <em>Assembly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyImpl
	 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl#getAssembly()
	 * @generated
	 */
	int ASSEMBLY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Assembly Contexts Assembly</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assembly Connectors Assembly</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector <em>System Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector
	 * @generated
	 */
	EClass getSystemAssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidingContext_SystemAssemblyConnector <em>Providing Context System Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Providing Context System Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidingContext_SystemAssemblyConnector()
	 * @see #getSystemAssemblyConnector()
	 * @generated
	 */
	EReference getSystemAssemblyConnector_ProvidingContext_SystemAssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiringContext_SystemAssemblyConnector <em>Requiring Context System Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Requiring Context System Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiringContext_SystemAssemblyConnector()
	 * @see #getSystemAssemblyConnector()
	 * @generated
	 */
	EReference getSystemAssemblyConnector_RequiringContext_SystemAssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidedRole_SystemAssemblyConnector <em>Provided Role System Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Role System Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidedRole_SystemAssemblyConnector()
	 * @see #getSystemAssemblyConnector()
	 * @generated
	 */
	EReference getSystemAssemblyConnector_ProvidedRole_SystemAssemblyConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiredRole_SystemAssemblyConnector <em>Required Role System Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Role System Assembly Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiredRole_SystemAssemblyConnector()
	 * @see #getSystemAssemblyConnector()
	 * @generated
	 */
	EReference getSystemAssemblyConnector_RequiredRole_SystemAssemblyConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.assembly.AssemblyContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyContext
	 * @generated
	 */
	EClass getAssemblyContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.assembly.AssemblyContext#getEncapsulatedComponent__AssemblyContext <em>Encapsulated Component Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Encapsulated Component Assembly Context</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyContext#getEncapsulatedComponent__AssemblyContext()
	 * @see #getAssemblyContext()
	 * @generated
	 */
	EReference getAssemblyContext_EncapsulatedComponent__AssemblyContext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.assembly.Assembly <em>Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.Assembly
	 * @generated
	 */
	EClass getAssembly();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.assembly.Assembly#getAssemblyContexts_Assembly <em>Assembly Contexts Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assembly Contexts Assembly</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.Assembly#getAssemblyContexts_Assembly()
	 * @see #getAssembly()
	 * @generated
	 */
	EReference getAssembly_AssemblyContexts_Assembly();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.assembly.Assembly#getAssemblyConnectors_Assembly <em>Assembly Connectors Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assembly Connectors Assembly</em>'.
	 * @see de.uka.ipd.sdq.pcm.assembly.Assembly#getAssemblyConnectors_Assembly()
	 * @see #getAssembly()
	 * @generated
	 */
	EReference getAssembly_AssemblyConnectors_Assembly();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AssemblyFactory getAssemblyFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl <em>System Assembly Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl#getSystemAssemblyConnector()
		 * @generated
		 */
		EClass SYSTEM_ASSEMBLY_CONNECTOR = eINSTANCE.getSystemAssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Providing Context System Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR = eINSTANCE.getSystemAssemblyConnector_ProvidingContext_SystemAssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Requiring Context System Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR = eINSTANCE.getSystemAssemblyConnector_RequiringContext_SystemAssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Provided Role System Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR = eINSTANCE.getSystemAssemblyConnector_ProvidedRole_SystemAssemblyConnector();

		/**
		 * The meta object literal for the '<em><b>Required Role System Assembly Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR = eINSTANCE.getSystemAssemblyConnector_RequiredRole_SystemAssemblyConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.assembly.impl.AssemblyContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyContextImpl
		 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl#getAssemblyContext()
		 * @generated
		 */
		EClass ASSEMBLY_CONTEXT = eINSTANCE.getAssemblyContext();

		/**
		 * The meta object literal for the '<em><b>Encapsulated Component Assembly Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT = eINSTANCE.getAssemblyContext_EncapsulatedComponent__AssemblyContext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.assembly.impl.AssemblyImpl <em>Assembly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyImpl
		 * @see de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl#getAssembly()
		 * @generated
		 */
		EClass ASSEMBLY = eINSTANCE.getAssembly();

		/**
		 * The meta object literal for the '<em><b>Assembly Contexts Assembly</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY = eINSTANCE.getAssembly_AssemblyContexts_Assembly();

		/**
		 * The meta object literal for the '<em><b>Assembly Connectors Assembly</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY = eINSTANCE.getAssembly_AssemblyConnectors_Assembly();

	}

} //AssemblyPackage
