/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.completions;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;
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
 * @see de.uka.ipd.sdq.completions.CompletionsFactory
 * @model kind="package"
 * @generated
 */
public interface CompletionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "completions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Completions/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "completions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompletionsPackage eINSTANCE = de.uka.ipd.sdq.completions.impl.CompletionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.completions.impl.CompletionImpl <em>Completion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.completions.impl.CompletionImpl
	 * @see de.uka.ipd.sdq.completions.impl.CompletionsPackageImpl#getCompletion()
	 * @generated
	 */
	int COMPLETION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__ID = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__ENTITY_NAME = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Assembly Contexts Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Resource Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;

	/**
	 * The feature id for the '<em><b>Repository Repository Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__REPOSITORY_REPOSITORY_COMPONENT = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component Parameter Usage Implementation Component Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Completion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_COUNT = EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.completions.impl.CompletionRepositoryImpl <em>Completion Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.completions.impl.CompletionRepositoryImpl
	 * @see de.uka.ipd.sdq.completions.impl.CompletionsPackageImpl#getCompletionRepository()
	 * @generated
	 */
	int COMPLETION_REPOSITORY = 1;

	/**
	 * The feature id for the '<em><b>Completions Completion Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY = 0;

	/**
	 * The number of structural features of the '<em>Completion Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_REPOSITORY_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.completions.impl.DelegatingExternalCallActionImpl <em>Delegating External Call Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.completions.impl.DelegatingExternalCallActionImpl
	 * @see de.uka.ipd.sdq.completions.impl.CompletionsPackageImpl#getDelegatingExternalCallAction()
	 * @generated
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__ID = SeffPackage.EXTERNAL_CALL_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__ENTITY_NAME = SeffPackage.EXTERNAL_CALL_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.EXTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.EXTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Called Service External Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE = SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE;

	/**
	 * The feature id for the '<em><b>Input Parameter Usages External Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION = SeffPackage.EXTERNAL_CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION;

	/**
	 * The feature id for the '<em><b>Output Variable Usages External Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION = SeffPackage.EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION;

	/**
	 * The feature id for the '<em><b>Role External Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE = SeffPackage.EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE;

	/**
	 * The number of structural features of the '<em>Delegating External Call Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATING_EXTERNAL_CALL_ACTION_FEATURE_COUNT = SeffPackage.EXTERNAL_CALL_ACTION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.completions.Completion <em>Completion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion</em>'.
	 * @see de.uka.ipd.sdq.completions.Completion
	 * @generated
	 */
	EClass getCompletion();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.completions.CompletionRepository <em>Completion Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Repository</em>'.
	 * @see de.uka.ipd.sdq.completions.CompletionRepository
	 * @generated
	 */
	EClass getCompletionRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.completions.CompletionRepository#getCompletions_CompletionRepository <em>Completions Completion Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Completions Completion Repository</em>'.
	 * @see de.uka.ipd.sdq.completions.CompletionRepository#getCompletions_CompletionRepository()
	 * @see #getCompletionRepository()
	 * @generated
	 */
	EReference getCompletionRepository_Completions_CompletionRepository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.completions.DelegatingExternalCallAction <em>Delegating External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delegating External Call Action</em>'.
	 * @see de.uka.ipd.sdq.completions.DelegatingExternalCallAction
	 * @generated
	 */
	EClass getDelegatingExternalCallAction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompletionsFactory getCompletionsFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.completions.impl.CompletionImpl <em>Completion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.completions.impl.CompletionImpl
		 * @see de.uka.ipd.sdq.completions.impl.CompletionsPackageImpl#getCompletion()
		 * @generated
		 */
		EClass COMPLETION = eINSTANCE.getCompletion();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.completions.impl.CompletionRepositoryImpl <em>Completion Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.completions.impl.CompletionRepositoryImpl
		 * @see de.uka.ipd.sdq.completions.impl.CompletionsPackageImpl#getCompletionRepository()
		 * @generated
		 */
		EClass COMPLETION_REPOSITORY = eINSTANCE.getCompletionRepository();

		/**
		 * The meta object literal for the '<em><b>Completions Completion Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY = eINSTANCE.getCompletionRepository_Completions_CompletionRepository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.completions.impl.DelegatingExternalCallActionImpl <em>Delegating External Call Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.completions.impl.DelegatingExternalCallActionImpl
		 * @see de.uka.ipd.sdq.completions.impl.CompletionsPackageImpl#getDelegatingExternalCallAction()
		 * @generated
		 */
		EClass DELEGATING_EXTERNAL_CALL_ACTION = eINSTANCE.getDelegatingExternalCallAction();

	}

} //CompletionsPackage
