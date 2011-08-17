/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel;

import org.eclipse.emf.ecore.EAttribute;
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
 * This is the documentation for the Task and Probabilities metamodel that is the interface for the PerOpteryx metaheuristic optimisation based on the Palladio Component Model to the analytic multicriteria optimisation of Polimi. 
 * 
 * This package contains all metamodel elements. The TaskList is the root model element and contains a Task and Probabilities model. 
 * 
 * The main class is the Task. It represents a single resource-demanding action in the software. It is derived from actions in the PCM SEFF and can be used for tasks in the optimisation of Polimi. 
 * 
 * Tasks are connected to each other by Edges. Each Task can have multiple outgoing Edges. The set of outgoing Edges is modelled with the edge_Task containment association of the Task. Each Edge points to one successor Task. 
 * 
 * See the Alternative class for details how to specify alternatives. 
 * 
 * See the description of the model elements for a detailed description of the attributes. 
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelFactory
 * @model kind="package"
 * @generated
 */
public interface taskmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "taskmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/TaskModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "taskmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	taskmodelPackage eINSTANCE = de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Probability Of Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PROBABILITY_OF_EXECUTION = 1;

	/**
	 * The feature id for the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__FAILURE_PROBABILITY = 2;

	/**
	 * The feature id for the '<em><b>Mean Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__MEAN_DEMANDED_TIME = 3;

	/**
	 * The feature id for the '<em><b>Repositorycomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__REPOSITORYCOMPONENT = 4;

	/**
	 * The feature id for the '<em><b>Allocationcontext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ALLOCATIONCONTEXT = 5;

	/**
	 * The feature id for the '<em><b>Edge Task</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EDGE_TASK = 6;

	/**
	 * The feature id for the '<em><b>Abstractaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ABSTRACTACTION = 7;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.EdgeImpl
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 1;

	/**
	 * The feature id for the '<em><b>Transition Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TRANSITION_PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Successor Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SUCCESSOR_EDGE = 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskListImpl <em>Task List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.TaskListImpl
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getTaskList()
	 * @generated
	 */
	int TASK_LIST = 2;

	/**
	 * The feature id for the '<em><b>Task Task List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_LIST__TASK_TASK_LIST = 0;

	/**
	 * The feature id for the '<em><b>Start Task Task List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_LIST__START_TASK_TASK_LIST = 1;

	/**
	 * The feature id for the '<em><b>Alternative Task List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_LIST__ALTERNATIVE_TASK_LIST = 2;

	/**
	 * The number of structural features of the '<em>Task List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_LIST_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeImpl <em>Alternative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeImpl
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getAlternative()
	 * @generated
	 */
	int ALTERNATIVE = 3;

	/**
	 * The feature id for the '<em><b>Alternativetasks Alternative</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE = 0;

	/**
	 * The number of structural features of the '<em>Alternative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeTaskImpl <em>Alternative Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeTaskImpl
	 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getAlternativeTask()
	 * @generated
	 */
	int ALTERNATIVE_TASK = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__NAME = TASK__NAME;

	/**
	 * The feature id for the '<em><b>Probability Of Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__PROBABILITY_OF_EXECUTION = TASK__PROBABILITY_OF_EXECUTION;

	/**
	 * The feature id for the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__FAILURE_PROBABILITY = TASK__FAILURE_PROBABILITY;

	/**
	 * The feature id for the '<em><b>Mean Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__MEAN_DEMANDED_TIME = TASK__MEAN_DEMANDED_TIME;

	/**
	 * The feature id for the '<em><b>Repositorycomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__REPOSITORYCOMPONENT = TASK__REPOSITORYCOMPONENT;

	/**
	 * The feature id for the '<em><b>Allocationcontext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__ALLOCATIONCONTEXT = TASK__ALLOCATIONCONTEXT;

	/**
	 * The feature id for the '<em><b>Edge Task</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__EDGE_TASK = TASK__EDGE_TASK;

	/**
	 * The feature id for the '<em><b>Abstractaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__ABSTRACTACTION = TASK__ABSTRACTACTION;

	/**
	 * The feature id for the '<em><b>Task Alternative Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK = TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Alternative Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.taskmodel.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getName()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getProbabilityOfExecution <em>Probability Of Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability Of Execution</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getProbabilityOfExecution()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_ProbabilityOfExecution();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getFailureProbability <em>Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Probability</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getFailureProbability()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_FailureProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getMeanDemandedTime <em>Mean Demanded Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mean Demanded Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getMeanDemandedTime()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_MeanDemandedTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getRepositorycomponent <em>Repositorycomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Repositorycomponent</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getRepositorycomponent()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Repositorycomponent();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getAllocationcontext <em>Allocationcontext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocationcontext</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getAllocationcontext()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Allocationcontext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getEdge_Task <em>Edge Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge Task</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getEdge_Task()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Edge_Task();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getAbstractaction <em>Abstractaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Abstractaction</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Task#getAbstractaction()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Abstractaction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.taskmodel.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.taskmodel.Edge#getTransitionProbability <em>Transition Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition Probability</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Edge#getTransitionProbability()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_TransitionProbability();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.taskmodel.Edge#getSuccessor_Edge <em>Successor Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor Edge</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Edge#getSuccessor_Edge()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Successor_Edge();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList <em>Task List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task List</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.TaskList
	 * @generated
	 */
	EClass getTaskList();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList#getTask_TaskList <em>Task Task List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Task List</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.TaskList#getTask_TaskList()
	 * @see #getTaskList()
	 * @generated
	 */
	EReference getTaskList_Task_TaskList();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList#getStartTask_TaskList <em>Start Task Task List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Task Task List</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.TaskList#getStartTask_TaskList()
	 * @see #getTaskList()
	 * @generated
	 */
	EReference getTaskList_StartTask_TaskList();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList#getAlternative_TaskList <em>Alternative Task List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternative Task List</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.TaskList#getAlternative_TaskList()
	 * @see #getTaskList()
	 * @generated
	 */
	EReference getTaskList_Alternative_TaskList();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.taskmodel.Alternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Alternative
	 * @generated
	 */
	EClass getAlternative();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.taskmodel.Alternative#getAlternativetasks_Alternative <em>Alternativetasks Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternativetasks Alternative</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.Alternative#getAlternativetasks_Alternative()
	 * @see #getAlternative()
	 * @generated
	 */
	EReference getAlternative_Alternativetasks_Alternative();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask <em>Alternative Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Task</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask
	 * @generated
	 */
	EClass getAlternativeTask();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask#getTask_AlternativeTask <em>Task Alternative Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Task Alternative Task</em>'.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask#getTask_AlternativeTask()
	 * @see #getAlternativeTask()
	 * @generated
	 */
	EReference getAlternativeTask_Task_AlternativeTask();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	taskmodelFactory gettaskmodelFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__NAME = eINSTANCE.getTask_Name();

		/**
		 * The meta object literal for the '<em><b>Probability Of Execution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__PROBABILITY_OF_EXECUTION = eINSTANCE.getTask_ProbabilityOfExecution();

		/**
		 * The meta object literal for the '<em><b>Failure Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__FAILURE_PROBABILITY = eINSTANCE.getTask_FailureProbability();

		/**
		 * The meta object literal for the '<em><b>Mean Demanded Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__MEAN_DEMANDED_TIME = eINSTANCE.getTask_MeanDemandedTime();

		/**
		 * The meta object literal for the '<em><b>Repositorycomponent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__REPOSITORYCOMPONENT = eINSTANCE.getTask_Repositorycomponent();

		/**
		 * The meta object literal for the '<em><b>Allocationcontext</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__ALLOCATIONCONTEXT = eINSTANCE.getTask_Allocationcontext();

		/**
		 * The meta object literal for the '<em><b>Edge Task</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__EDGE_TASK = eINSTANCE.getTask_Edge_Task();

		/**
		 * The meta object literal for the '<em><b>Abstractaction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__ABSTRACTACTION = eINSTANCE.getTask_Abstractaction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.EdgeImpl
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Transition Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__TRANSITION_PROBABILITY = eINSTANCE.getEdge_TransitionProbability();

		/**
		 * The meta object literal for the '<em><b>Successor Edge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SUCCESSOR_EDGE = eINSTANCE.getEdge_Successor_Edge();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskListImpl <em>Task List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.TaskListImpl
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getTaskList()
		 * @generated
		 */
		EClass TASK_LIST = eINSTANCE.getTaskList();

		/**
		 * The meta object literal for the '<em><b>Task Task List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_LIST__TASK_TASK_LIST = eINSTANCE.getTaskList_Task_TaskList();

		/**
		 * The meta object literal for the '<em><b>Start Task Task List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_LIST__START_TASK_TASK_LIST = eINSTANCE.getTaskList_StartTask_TaskList();

		/**
		 * The meta object literal for the '<em><b>Alternative Task List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_LIST__ALTERNATIVE_TASK_LIST = eINSTANCE.getTaskList_Alternative_TaskList();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeImpl <em>Alternative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeImpl
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getAlternative()
		 * @generated
		 */
		EClass ALTERNATIVE = eINSTANCE.getAlternative();

		/**
		 * The meta object literal for the '<em><b>Alternativetasks Alternative</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE__ALTERNATIVETASKS_ALTERNATIVE = eINSTANCE.getAlternative_Alternativetasks_Alternative();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeTaskImpl <em>Alternative Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.AlternativeTaskImpl
		 * @see de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelPackageImpl#getAlternativeTask()
		 * @generated
		 */
		EClass ALTERNATIVE_TASK = eINSTANCE.getAlternativeTask();

		/**
		 * The meta object literal for the '<em><b>Task Alternative Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE_TASK__TASK_ALTERNATIVE_TASK = eINSTANCE.getAlternativeTask_Task_AlternativeTask();

	}

} //taskmodelPackage
