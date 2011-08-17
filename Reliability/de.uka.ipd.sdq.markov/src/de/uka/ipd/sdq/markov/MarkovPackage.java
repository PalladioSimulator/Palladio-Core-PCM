/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.markov;

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
 * @see de.uka.ipd.sdq.markov.MarkovFactory
 * @model kind="package"
 * @generated
 */
public interface MarkovPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "markov";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/FiniteMakovChain/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.uka.ipd.sdq";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MarkovPackage eINSTANCE = de.uka.ipd.sdq.markov.impl.MarkovPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.markov.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.markov.impl.EntityImpl
	 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.markov.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.markov.impl.StateImpl
	 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getState()
	 * @generated
	 */
	int STATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TYPE = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LABELS = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TRACES = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.markov.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.markov.impl.TransitionImpl
	 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PROBABILITY = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM_STATE = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO_STATE = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.markov.impl.MarkovChainImpl <em>Chain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.markov.impl.MarkovChainImpl
	 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getMarkovChain()
	 * @generated
	 */
	int MARKOV_CHAIN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_CHAIN__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_CHAIN__STATES = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_CHAIN__TRANSITIONS = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Chain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_CHAIN_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.markov.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.markov.impl.LabelImpl
	 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.markov.StateType <em>State Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.markov.StateType
	 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getStateType()
	 * @generated
	 */
	int STATE_TYPE = 5;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.markov.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see de.uka.ipd.sdq.markov.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.markov.State#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.markov.State#getType()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.markov.State#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see de.uka.ipd.sdq.markov.State#getLabels()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Labels();

	/**
	 * Returns the meta object for the attribute list '{@link de.uka.ipd.sdq.markov.State#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Traces</em>'.
	 * @see de.uka.ipd.sdq.markov.State#getTraces()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Traces();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.markov.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see de.uka.ipd.sdq.markov.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.markov.Transition#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.markov.Transition#getProbability()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Probability();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.markov.Transition#getFromState <em>From State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From State</em>'.
	 * @see de.uka.ipd.sdq.markov.Transition#getFromState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_FromState();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.markov.Transition#getToState <em>To State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To State</em>'.
	 * @see de.uka.ipd.sdq.markov.Transition#getToState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_ToState();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.markov.MarkovChain <em>Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chain</em>'.
	 * @see de.uka.ipd.sdq.markov.MarkovChain
	 * @generated
	 */
	EClass getMarkovChain();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.markov.MarkovChain#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see de.uka.ipd.sdq.markov.MarkovChain#getStates()
	 * @see #getMarkovChain()
	 * @generated
	 */
	EReference getMarkovChain_States();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.markov.MarkovChain#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see de.uka.ipd.sdq.markov.MarkovChain#getTransitions()
	 * @see #getMarkovChain()
	 * @generated
	 */
	EReference getMarkovChain_Transitions();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.markov.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see de.uka.ipd.sdq.markov.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.markov.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.markov.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.markov.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see de.uka.ipd.sdq.markov.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.markov.Label#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see de.uka.ipd.sdq.markov.Label#getKey()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Key();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.markov.Label#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.markov.Label#getValue()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Value();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.markov.StateType <em>State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Type</em>'.
	 * @see de.uka.ipd.sdq.markov.StateType
	 * @generated
	 */
	EEnum getStateType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MarkovFactory getMarkovFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.markov.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.markov.impl.StateImpl
		 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__TYPE = eINSTANCE.getState_Type();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__LABELS = eINSTANCE.getState_Labels();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__TRACES = eINSTANCE.getState_Traces();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.markov.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.markov.impl.TransitionImpl
		 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__PROBABILITY = eINSTANCE.getTransition_Probability();

		/**
		 * The meta object literal for the '<em><b>From State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__FROM_STATE = eINSTANCE.getTransition_FromState();

		/**
		 * The meta object literal for the '<em><b>To State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TO_STATE = eINSTANCE.getTransition_ToState();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.markov.impl.MarkovChainImpl <em>Chain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.markov.impl.MarkovChainImpl
		 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getMarkovChain()
		 * @generated
		 */
		EClass MARKOV_CHAIN = eINSTANCE.getMarkovChain();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_CHAIN__STATES = eINSTANCE.getMarkovChain_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_CHAIN__TRANSITIONS = eINSTANCE.getMarkovChain_Transitions();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.markov.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.markov.impl.EntityImpl
		 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.markov.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.markov.impl.LabelImpl
		 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__KEY = eINSTANCE.getLabel_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__VALUE = eINSTANCE.getLabel_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.markov.StateType <em>State Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.markov.StateType
		 * @see de.uka.ipd.sdq.markov.impl.MarkovPackageImpl#getStateType()
		 * @generated
		 */
		EEnum STATE_TYPE = eINSTANCE.getStateType();

	}

} //MarkovPackage
