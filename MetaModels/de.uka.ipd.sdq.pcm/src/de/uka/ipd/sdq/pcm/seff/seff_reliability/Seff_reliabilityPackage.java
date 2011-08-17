/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

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
 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityFactory
 * @model kind="package"
 * @generated
 */
public interface Seff_reliabilityPackage extends EPackage {
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
	String eNAME = "seff_reliability";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Reliability/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "seff_reliability";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Seff_reliabilityPackage eINSTANCE = de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.Seff_reliabilityPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.FailureHandlingEntityImpl <em>Failure Handling Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.FailureHandlingEntityImpl
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.Seff_reliabilityPackageImpl#getFailureHandlingEntity()
	 * @generated
	 */
	int FAILURE_HANDLING_ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_HANDLING_ENTITY__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_HANDLING_ENTITY__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Failure Types Failure Handling Entity</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_HANDLING_ENTITY__FAILURE_TYPES_FAILURE_HANDLING_ENTITY = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Failure Handling Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_HANDLING_ENTITY_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockAlternativeBehaviourImpl <em>Recovery Block Alternative Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockAlternativeBehaviourImpl
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.Seff_reliabilityPackageImpl#getRecoveryBlockAlternativeBehaviour()
	 * @generated
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ID = FAILURE_HANDLING_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ENTITY_NAME = FAILURE_HANDLING_ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Failure Types Failure Handling Entity</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURE_TYPES_FAILURE_HANDLING_ENTITY = FAILURE_HANDLING_ENTITY__FAILURE_TYPES_FAILURE_HANDLING_ENTITY;

	/**
	 * The feature id for the '<em><b>Abstract Loop Action Resource Demanding Behaviour</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR = FAILURE_HANDLING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract Branch Transition Resource Demanding Behaviour</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR = FAILURE_HANDLING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Steps Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR = FAILURE_HANDLING_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Alternative Recovery Block Alternative Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR = FAILURE_HANDLING_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Recovery Block Action Recovery Block Alternative Behaviour</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR = FAILURE_HANDLING_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Recovery Block Alternative Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR_FEATURE_COUNT = FAILURE_HANDLING_ENTITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockActionImpl <em>Recovery Block Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.Seff_reliabilityPackageImpl#getRecoveryBlockAction()
	 * @generated
	 */
	int RECOVERY_BLOCK_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__ID = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__ENTITY_NAME = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__PREDECESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__SUCCESSOR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__RESOURCE_DEMAND_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Infrastructure Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__INFRASTRUCTURE_CALL_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__RESOURCE_CALL_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION;

	/**
	 * The feature id for the '<em><b>Recovery Block Alternative Behaviours Recovery Block Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Recovery Block Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVERY_BLOCK_ACTION_FEATURE_COUNT = SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour <em>Recovery Block Alternative Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recovery Block Alternative Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour
	 * @generated
	 */
	EClass getRecoveryBlockAlternativeBehaviour();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour#getNextAlternative_RecoveryBlockAlternativeBehaviour <em>Next Alternative Recovery Block Alternative Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Alternative Recovery Block Alternative Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour#getNextAlternative_RecoveryBlockAlternativeBehaviour()
	 * @see #getRecoveryBlockAlternativeBehaviour()
	 * @generated
	 */
	EReference getRecoveryBlockAlternativeBehaviour_NextAlternative_RecoveryBlockAlternativeBehaviour();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour <em>Recovery Block Action Recovery Block Alternative Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Recovery Block Action Recovery Block Alternative Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour()
	 * @see #getRecoveryBlockAlternativeBehaviour()
	 * @generated
	 */
	EReference getRecoveryBlockAlternativeBehaviour_RecoveryBlockAction_RecoveryBlockAlternativeBehaviour();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction <em>Recovery Block Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recovery Block Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction
	 * @generated
	 */
	EClass getRecoveryBlockAction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction#getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction <em>Recovery Block Alternative Behaviours Recovery Block Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Recovery Block Alternative Behaviours Recovery Block Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction#getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction()
	 * @see #getRecoveryBlockAction()
	 * @generated
	 */
	EReference getRecoveryBlockAction_RecoveryBlockAlternativeBehaviours_RecoveryBlockAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity <em>Failure Handling Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Handling Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity
	 * @generated
	 */
	EClass getFailureHandlingEntity();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity#getFailureTypes_FailureHandlingEntity <em>Failure Types Failure Handling Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Failure Types Failure Handling Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity#getFailureTypes_FailureHandlingEntity()
	 * @see #getFailureHandlingEntity()
	 * @generated
	 */
	EReference getFailureHandlingEntity_FailureTypes_FailureHandlingEntity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Seff_reliabilityFactory getSeff_reliabilityFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockAlternativeBehaviourImpl <em>Recovery Block Alternative Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockAlternativeBehaviourImpl
		 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.Seff_reliabilityPackageImpl#getRecoveryBlockAlternativeBehaviour()
		 * @generated
		 */
		EClass RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR = eINSTANCE.getRecoveryBlockAlternativeBehaviour();

		/**
		 * The meta object literal for the '<em><b>Next Alternative Recovery Block Alternative Behaviour</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR = eINSTANCE.getRecoveryBlockAlternativeBehaviour_NextAlternative_RecoveryBlockAlternativeBehaviour();

		/**
		 * The meta object literal for the '<em><b>Recovery Block Action Recovery Block Alternative Behaviour</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR = eINSTANCE.getRecoveryBlockAlternativeBehaviour_RecoveryBlockAction_RecoveryBlockAlternativeBehaviour();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockActionImpl <em>Recovery Block Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.Seff_reliabilityPackageImpl#getRecoveryBlockAction()
		 * @generated
		 */
		EClass RECOVERY_BLOCK_ACTION = eINSTANCE.getRecoveryBlockAction();

		/**
		 * The meta object literal for the '<em><b>Recovery Block Alternative Behaviours Recovery Block Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION = eINSTANCE.getRecoveryBlockAction_RecoveryBlockAlternativeBehaviours_RecoveryBlockAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.FailureHandlingEntityImpl <em>Failure Handling Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.FailureHandlingEntityImpl
		 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.Seff_reliabilityPackageImpl#getFailureHandlingEntity()
		 * @generated
		 */
		EClass FAILURE_HANDLING_ENTITY = eINSTANCE.getFailureHandlingEntity();

		/**
		 * The meta object literal for the '<em><b>Failure Types Failure Handling Entity</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_HANDLING_ENTITY__FAILURE_TYPES_FAILURE_HANDLING_ENTITY = eINSTANCE.getFailureHandlingEntity_FailureTypes_FailureHandlingEntity();

	}

} //Seff_reliabilityPackage
